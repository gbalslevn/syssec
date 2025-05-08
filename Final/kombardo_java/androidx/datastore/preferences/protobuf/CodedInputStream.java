package androidx.datastore.preferences.protobuf;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.conscrypt.BuildConfig;

/* loaded from: classes.dex */
public abstract class CodedInputStream {
    private static final int DEFAULT_BUFFER_SIZE = 4096;
    private static final int DEFAULT_SIZE_LIMIT = Integer.MAX_VALUE;
    private static volatile int defaultRecursionLimit = 100;
    int recursionDepth;
    int recursionLimit;
    private boolean shouldDiscardUnknownFields;
    int sizeLimit;
    CodedInputStreamReader wrapper;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class ArrayDecoder extends CodedInputStream {
        private final byte[] buffer;
        private int bufferSizeAfterLimit;
        private int currentLimit;
        private boolean enableAliasing;
        private final boolean immutable;
        private int lastTag;
        private int limit;
        private int pos;
        private int startPos;

        private void recomputeBufferSizeAfterLimit() {
            int i5 = this.limit + this.bufferSizeAfterLimit;
            this.limit = i5;
            int i6 = i5 - this.startPos;
            int i7 = this.currentLimit;
            if (i6 <= i7) {
                this.bufferSizeAfterLimit = 0;
                return;
            }
            int i8 = i6 - i7;
            this.bufferSizeAfterLimit = i8;
            this.limit = i5 - i8;
        }

        private void skipRawVarint() {
            if (this.limit - this.pos >= 10) {
                skipRawVarintFastPath();
            } else {
                skipRawVarintSlowPath();
            }
        }

        private void skipRawVarintFastPath() {
            for (int i5 = 0; i5 < 10; i5++) {
                byte[] bArr = this.buffer;
                int i6 = this.pos;
                this.pos = i6 + 1;
                if (bArr[i6] >= 0) {
                    return;
                }
            }
            throw InvalidProtocolBufferException.malformedVarint();
        }

        private void skipRawVarintSlowPath() {
            for (int i5 = 0; i5 < 10; i5++) {
                if (readRawByte() >= 0) {
                    return;
                }
            }
            throw InvalidProtocolBufferException.malformedVarint();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public void checkLastTagWas(int i5) {
            if (this.lastTag != i5) {
                throw InvalidProtocolBufferException.invalidEndTag();
            }
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public int getTotalBytesRead() {
            return this.pos - this.startPos;
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public boolean isAtEnd() {
            return this.pos == this.limit;
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public void popLimit(int i5) {
            this.currentLimit = i5;
            recomputeBufferSizeAfterLimit();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public int pushLimit(int i5) {
            if (i5 < 0) {
                throw InvalidProtocolBufferException.negativeSize();
            }
            int totalBytesRead = i5 + getTotalBytesRead();
            if (totalBytesRead < 0) {
                throw InvalidProtocolBufferException.parseFailure();
            }
            int i6 = this.currentLimit;
            if (totalBytesRead > i6) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            this.currentLimit = totalBytesRead;
            recomputeBufferSizeAfterLimit();
            return i6;
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public boolean readBool() {
            return readRawVarint64() != 0;
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public ByteString readBytes() {
            int readRawVarint32 = readRawVarint32();
            if (readRawVarint32 > 0) {
                int i5 = this.limit;
                int i6 = this.pos;
                if (readRawVarint32 <= i5 - i6) {
                    ByteString wrap = (this.immutable && this.enableAliasing) ? ByteString.wrap(this.buffer, i6, readRawVarint32) : ByteString.copyFrom(this.buffer, i6, readRawVarint32);
                    this.pos += readRawVarint32;
                    return wrap;
                }
            }
            return readRawVarint32 == 0 ? ByteString.EMPTY : ByteString.wrap(readRawBytes(readRawVarint32));
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public double readDouble() {
            return Double.longBitsToDouble(readRawLittleEndian64());
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public int readEnum() {
            return readRawVarint32();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public int readFixed32() {
            return readRawLittleEndian32();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public long readFixed64() {
            return readRawLittleEndian64();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public float readFloat() {
            return Float.intBitsToFloat(readRawLittleEndian32());
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public int readInt32() {
            return readRawVarint32();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public long readInt64() {
            return readRawVarint64();
        }

        public byte readRawByte() {
            int i5 = this.pos;
            if (i5 == this.limit) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            byte[] bArr = this.buffer;
            this.pos = i5 + 1;
            return bArr[i5];
        }

        public byte[] readRawBytes(int i5) {
            if (i5 > 0) {
                int i6 = this.limit;
                int i7 = this.pos;
                if (i5 <= i6 - i7) {
                    int i8 = i5 + i7;
                    this.pos = i8;
                    return Arrays.copyOfRange(this.buffer, i7, i8);
                }
            }
            if (i5 > 0) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            if (i5 == 0) {
                return Internal.EMPTY_BYTE_ARRAY;
            }
            throw InvalidProtocolBufferException.negativeSize();
        }

        public int readRawLittleEndian32() {
            int i5 = this.pos;
            if (this.limit - i5 < 4) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            byte[] bArr = this.buffer;
            this.pos = i5 + 4;
            return ((bArr[i5 + 3] & 255) << 24) | (bArr[i5] & 255) | ((bArr[i5 + 1] & 255) << 8) | ((bArr[i5 + 2] & 255) << 16);
        }

        public long readRawLittleEndian64() {
            int i5 = this.pos;
            if (this.limit - i5 < 8) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            byte[] bArr = this.buffer;
            this.pos = i5 + 8;
            return ((bArr[i5 + 7] & 255) << 56) | (bArr[i5] & 255) | ((bArr[i5 + 1] & 255) << 8) | ((bArr[i5 + 2] & 255) << 16) | ((bArr[i5 + 3] & 255) << 24) | ((bArr[i5 + 4] & 255) << 32) | ((bArr[i5 + 5] & 255) << 40) | ((bArr[i5 + 6] & 255) << 48);
        }

        public int readRawVarint32() {
            int i5;
            int i6 = this.pos;
            int i7 = this.limit;
            if (i7 != i6) {
                byte[] bArr = this.buffer;
                int i8 = i6 + 1;
                byte b5 = bArr[i6];
                if (b5 >= 0) {
                    this.pos = i8;
                    return b5;
                }
                if (i7 - i8 >= 9) {
                    int i9 = i6 + 2;
                    int i10 = (bArr[i8] << 7) ^ b5;
                    if (i10 < 0) {
                        i5 = i10 ^ (-128);
                    } else {
                        int i11 = i6 + 3;
                        int i12 = (bArr[i9] << 14) ^ i10;
                        if (i12 >= 0) {
                            i5 = i12 ^ 16256;
                        } else {
                            int i13 = i6 + 4;
                            int i14 = i12 ^ (bArr[i11] << 21);
                            if (i14 < 0) {
                                i5 = (-2080896) ^ i14;
                            } else {
                                i11 = i6 + 5;
                                byte b6 = bArr[i13];
                                int i15 = (i14 ^ (b6 << 28)) ^ 266354560;
                                if (b6 < 0) {
                                    i13 = i6 + 6;
                                    if (bArr[i11] < 0) {
                                        i11 = i6 + 7;
                                        if (bArr[i13] < 0) {
                                            i13 = i6 + 8;
                                            if (bArr[i11] < 0) {
                                                i11 = i6 + 9;
                                                if (bArr[i13] < 0) {
                                                    int i16 = i6 + 10;
                                                    if (bArr[i11] >= 0) {
                                                        i9 = i16;
                                                        i5 = i15;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    i5 = i15;
                                }
                                i5 = i15;
                            }
                            i9 = i13;
                        }
                        i9 = i11;
                    }
                    this.pos = i9;
                    return i5;
                }
            }
            return (int) readRawVarint64SlowPath();
        }

        public long readRawVarint64() {
            long j5;
            long j6;
            long j7;
            int i5 = this.pos;
            int i6 = this.limit;
            if (i6 != i5) {
                byte[] bArr = this.buffer;
                int i7 = i5 + 1;
                byte b5 = bArr[i5];
                if (b5 >= 0) {
                    this.pos = i7;
                    return b5;
                }
                if (i6 - i7 >= 9) {
                    int i8 = i5 + 2;
                    int i9 = (bArr[i7] << 7) ^ b5;
                    if (i9 < 0) {
                        j5 = i9 ^ (-128);
                    } else {
                        int i10 = i5 + 3;
                        int i11 = (bArr[i8] << 14) ^ i9;
                        if (i11 >= 0) {
                            j5 = i11 ^ 16256;
                            i8 = i10;
                        } else {
                            int i12 = i5 + 4;
                            int i13 = i11 ^ (bArr[i10] << 21);
                            if (i13 < 0) {
                                long j8 = (-2080896) ^ i13;
                                i8 = i12;
                                j5 = j8;
                            } else {
                                long j9 = i13;
                                i8 = i5 + 5;
                                long j10 = j9 ^ (bArr[i12] << 28);
                                if (j10 >= 0) {
                                    j7 = 266354560;
                                } else {
                                    int i14 = i5 + 6;
                                    long j11 = j10 ^ (bArr[i8] << 35);
                                    if (j11 < 0) {
                                        j6 = -34093383808L;
                                    } else {
                                        i8 = i5 + 7;
                                        j10 = j11 ^ (bArr[i14] << 42);
                                        if (j10 >= 0) {
                                            j7 = 4363953127296L;
                                        } else {
                                            i14 = i5 + 8;
                                            j11 = j10 ^ (bArr[i8] << 49);
                                            if (j11 < 0) {
                                                j6 = -558586000294016L;
                                            } else {
                                                i8 = i5 + 9;
                                                long j12 = (j11 ^ (bArr[i14] << 56)) ^ 71499008037633920L;
                                                if (j12 < 0) {
                                                    int i15 = i5 + 10;
                                                    if (bArr[i8] >= 0) {
                                                        i8 = i15;
                                                    }
                                                }
                                                j5 = j12;
                                            }
                                        }
                                    }
                                    j5 = j11 ^ j6;
                                    i8 = i14;
                                }
                                j5 = j10 ^ j7;
                            }
                        }
                    }
                    this.pos = i8;
                    return j5;
                }
            }
            return readRawVarint64SlowPath();
        }

        long readRawVarint64SlowPath() {
            long j5 = 0;
            for (int i5 = 0; i5 < 64; i5 += 7) {
                j5 |= (r3 & Byte.MAX_VALUE) << i5;
                if ((readRawByte() & 128) == 0) {
                    return j5;
                }
            }
            throw InvalidProtocolBufferException.malformedVarint();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public int readSFixed32() {
            return readRawLittleEndian32();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public long readSFixed64() {
            return readRawLittleEndian64();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public int readSInt32() {
            return CodedInputStream.decodeZigZag32(readRawVarint32());
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public long readSInt64() {
            return CodedInputStream.decodeZigZag64(readRawVarint64());
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public String readString() {
            int readRawVarint32 = readRawVarint32();
            if (readRawVarint32 > 0) {
                int i5 = this.limit;
                int i6 = this.pos;
                if (readRawVarint32 <= i5 - i6) {
                    String str = new String(this.buffer, i6, readRawVarint32, Internal.UTF_8);
                    this.pos += readRawVarint32;
                    return str;
                }
            }
            if (readRawVarint32 == 0) {
                return BuildConfig.FLAVOR;
            }
            if (readRawVarint32 < 0) {
                throw InvalidProtocolBufferException.negativeSize();
            }
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public String readStringRequireUtf8() {
            int readRawVarint32 = readRawVarint32();
            if (readRawVarint32 > 0) {
                int i5 = this.limit;
                int i6 = this.pos;
                if (readRawVarint32 <= i5 - i6) {
                    String decodeUtf8 = Utf8.decodeUtf8(this.buffer, i6, readRawVarint32);
                    this.pos += readRawVarint32;
                    return decodeUtf8;
                }
            }
            if (readRawVarint32 == 0) {
                return BuildConfig.FLAVOR;
            }
            if (readRawVarint32 <= 0) {
                throw InvalidProtocolBufferException.negativeSize();
            }
            throw InvalidProtocolBufferException.truncatedMessage();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public int readTag() {
            if (isAtEnd()) {
                this.lastTag = 0;
                return 0;
            }
            int readRawVarint32 = readRawVarint32();
            this.lastTag = readRawVarint32;
            if (WireFormat.getTagFieldNumber(readRawVarint32) != 0) {
                return this.lastTag;
            }
            throw InvalidProtocolBufferException.invalidTag();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public int readUInt32() {
            return readRawVarint32();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public long readUInt64() {
            return readRawVarint64();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public boolean skipField(int i5) {
            int tagWireType = WireFormat.getTagWireType(i5);
            if (tagWireType == 0) {
                skipRawVarint();
                return true;
            }
            if (tagWireType == 1) {
                skipRawBytes(8);
                return true;
            }
            if (tagWireType == 2) {
                skipRawBytes(readRawVarint32());
                return true;
            }
            if (tagWireType == 3) {
                skipMessage();
                checkLastTagWas(WireFormat.makeTag(WireFormat.getTagFieldNumber(i5), 4));
                return true;
            }
            if (tagWireType == 4) {
                return false;
            }
            if (tagWireType != 5) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            skipRawBytes(4);
            return true;
        }

        public void skipRawBytes(int i5) {
            if (i5 >= 0) {
                int i6 = this.limit;
                int i7 = this.pos;
                if (i5 <= i6 - i7) {
                    this.pos = i7 + i5;
                    return;
                }
            }
            if (i5 >= 0) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            throw InvalidProtocolBufferException.negativeSize();
        }

        private ArrayDecoder(byte[] bArr, int i5, int i6, boolean z5) {
            super();
            this.currentLimit = CodedInputStream.DEFAULT_SIZE_LIMIT;
            this.buffer = bArr;
            this.limit = i6 + i5;
            this.pos = i5;
            this.startPos = i5;
            this.immutable = z5;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class StreamDecoder extends CodedInputStream {
        private final byte[] buffer;
        private int bufferSize;
        private int bufferSizeAfterLimit;
        private int currentLimit;
        private final InputStream input;
        private int lastTag;
        private int pos;
        private RefillCallback refillCallback;
        private int totalBytesRetired;

        /* loaded from: classes.dex */
        private interface RefillCallback {
        }

        private static int available(InputStream inputStream) {
            try {
                return inputStream.available();
            } catch (InvalidProtocolBufferException e5) {
                e5.setThrownFromInputStream();
                throw e5;
            }
        }

        private static int read(InputStream inputStream, byte[] bArr, int i5, int i6) {
            try {
                return inputStream.read(bArr, i5, i6);
            } catch (InvalidProtocolBufferException e5) {
                e5.setThrownFromInputStream();
                throw e5;
            }
        }

        private ByteString readBytesSlowPath(int i5) {
            byte[] readRawBytesSlowPathOneChunk = readRawBytesSlowPathOneChunk(i5);
            if (readRawBytesSlowPathOneChunk != null) {
                return ByteString.copyFrom(readRawBytesSlowPathOneChunk);
            }
            int i6 = this.pos;
            int i7 = this.bufferSize;
            int i8 = i7 - i6;
            this.totalBytesRetired += i7;
            this.pos = 0;
            this.bufferSize = 0;
            List<byte[]> readRawBytesSlowPathRemainingChunks = readRawBytesSlowPathRemainingChunks(i5 - i8);
            byte[] bArr = new byte[i5];
            System.arraycopy(this.buffer, i6, bArr, 0, i8);
            for (byte[] bArr2 : readRawBytesSlowPathRemainingChunks) {
                System.arraycopy(bArr2, 0, bArr, i8, bArr2.length);
                i8 += bArr2.length;
            }
            return ByteString.wrap(bArr);
        }

        private byte[] readRawBytesSlowPath(int i5, boolean z5) {
            byte[] readRawBytesSlowPathOneChunk = readRawBytesSlowPathOneChunk(i5);
            if (readRawBytesSlowPathOneChunk != null) {
                return z5 ? (byte[]) readRawBytesSlowPathOneChunk.clone() : readRawBytesSlowPathOneChunk;
            }
            int i6 = this.pos;
            int i7 = this.bufferSize;
            int i8 = i7 - i6;
            this.totalBytesRetired += i7;
            this.pos = 0;
            this.bufferSize = 0;
            List<byte[]> readRawBytesSlowPathRemainingChunks = readRawBytesSlowPathRemainingChunks(i5 - i8);
            byte[] bArr = new byte[i5];
            System.arraycopy(this.buffer, i6, bArr, 0, i8);
            for (byte[] bArr2 : readRawBytesSlowPathRemainingChunks) {
                System.arraycopy(bArr2, 0, bArr, i8, bArr2.length);
                i8 += bArr2.length;
            }
            return bArr;
        }

        private byte[] readRawBytesSlowPathOneChunk(int i5) {
            if (i5 == 0) {
                return Internal.EMPTY_BYTE_ARRAY;
            }
            if (i5 < 0) {
                throw InvalidProtocolBufferException.negativeSize();
            }
            int i6 = this.totalBytesRetired;
            int i7 = this.pos;
            int i8 = i6 + i7 + i5;
            if (i8 - this.sizeLimit > 0) {
                throw InvalidProtocolBufferException.sizeLimitExceeded();
            }
            int i9 = this.currentLimit;
            if (i8 > i9) {
                skipRawBytes((i9 - i6) - i7);
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            int i10 = this.bufferSize - i7;
            int i11 = i5 - i10;
            if (i11 >= CodedInputStream.DEFAULT_BUFFER_SIZE && i11 > available(this.input)) {
                return null;
            }
            byte[] bArr = new byte[i5];
            System.arraycopy(this.buffer, this.pos, bArr, 0, i10);
            this.totalBytesRetired += this.bufferSize;
            this.pos = 0;
            this.bufferSize = 0;
            while (i10 < i5) {
                int read = read(this.input, bArr, i10, i5 - i10);
                if (read == -1) {
                    throw InvalidProtocolBufferException.truncatedMessage();
                }
                this.totalBytesRetired += read;
                i10 += read;
            }
            return bArr;
        }

        private List<byte[]> readRawBytesSlowPathRemainingChunks(int i5) {
            ArrayList arrayList = new ArrayList();
            while (i5 > 0) {
                int min = Math.min(i5, CodedInputStream.DEFAULT_BUFFER_SIZE);
                byte[] bArr = new byte[min];
                int i6 = 0;
                while (i6 < min) {
                    int read = this.input.read(bArr, i6, min - i6);
                    if (read == -1) {
                        throw InvalidProtocolBufferException.truncatedMessage();
                    }
                    this.totalBytesRetired += read;
                    i6 += read;
                }
                i5 -= min;
                arrayList.add(bArr);
            }
            return arrayList;
        }

        private void recomputeBufferSizeAfterLimit() {
            int i5 = this.bufferSize + this.bufferSizeAfterLimit;
            this.bufferSize = i5;
            int i6 = this.totalBytesRetired + i5;
            int i7 = this.currentLimit;
            if (i6 <= i7) {
                this.bufferSizeAfterLimit = 0;
                return;
            }
            int i8 = i6 - i7;
            this.bufferSizeAfterLimit = i8;
            this.bufferSize = i5 - i8;
        }

        private void refillBuffer(int i5) {
            if (tryRefillBuffer(i5)) {
                return;
            }
            if (i5 <= (this.sizeLimit - this.totalBytesRetired) - this.pos) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            throw InvalidProtocolBufferException.sizeLimitExceeded();
        }

        private static long skip(InputStream inputStream, long j5) {
            try {
                return inputStream.skip(j5);
            } catch (InvalidProtocolBufferException e5) {
                e5.setThrownFromInputStream();
                throw e5;
            }
        }

        private void skipRawBytesSlowPath(int i5) {
            if (i5 < 0) {
                throw InvalidProtocolBufferException.negativeSize();
            }
            int i6 = this.totalBytesRetired;
            int i7 = this.pos;
            int i8 = i6 + i7 + i5;
            int i9 = this.currentLimit;
            if (i8 > i9) {
                skipRawBytes((i9 - i6) - i7);
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            this.totalBytesRetired = i6 + i7;
            int i10 = this.bufferSize - i7;
            this.bufferSize = 0;
            this.pos = 0;
            while (i10 < i5) {
                try {
                    long j5 = i5 - i10;
                    long skip = skip(this.input, j5);
                    if (skip < 0 || skip > j5) {
                        throw new IllegalStateException(this.input.getClass() + "#skip returned invalid result: " + skip + "\nThe InputStream implementation is buggy.");
                    }
                    if (skip == 0) {
                        break;
                    } else {
                        i10 += (int) skip;
                    }
                } finally {
                    this.totalBytesRetired += i10;
                    recomputeBufferSizeAfterLimit();
                }
            }
            if (i10 >= i5) {
                return;
            }
            int i11 = this.bufferSize;
            int i12 = i11 - this.pos;
            this.pos = i11;
            refillBuffer(1);
            while (true) {
                int i13 = i5 - i12;
                int i14 = this.bufferSize;
                if (i13 <= i14) {
                    this.pos = i13;
                    return;
                } else {
                    i12 += i14;
                    this.pos = i14;
                    refillBuffer(1);
                }
            }
        }

        private void skipRawVarint() {
            if (this.bufferSize - this.pos >= 10) {
                skipRawVarintFastPath();
            } else {
                skipRawVarintSlowPath();
            }
        }

        private void skipRawVarintFastPath() {
            for (int i5 = 0; i5 < 10; i5++) {
                byte[] bArr = this.buffer;
                int i6 = this.pos;
                this.pos = i6 + 1;
                if (bArr[i6] >= 0) {
                    return;
                }
            }
            throw InvalidProtocolBufferException.malformedVarint();
        }

        private void skipRawVarintSlowPath() {
            for (int i5 = 0; i5 < 10; i5++) {
                if (readRawByte() >= 0) {
                    return;
                }
            }
            throw InvalidProtocolBufferException.malformedVarint();
        }

        private boolean tryRefillBuffer(int i5) {
            int i6 = this.pos;
            int i7 = i6 + i5;
            int i8 = this.bufferSize;
            if (i7 <= i8) {
                throw new IllegalStateException("refillBuffer() called when " + i5 + " bytes were already available in buffer");
            }
            int i9 = this.sizeLimit;
            int i10 = this.totalBytesRetired;
            if (i5 > (i9 - i10) - i6 || i10 + i6 + i5 > this.currentLimit) {
                return false;
            }
            if (i6 > 0) {
                if (i8 > i6) {
                    byte[] bArr = this.buffer;
                    System.arraycopy(bArr, i6, bArr, 0, i8 - i6);
                }
                this.totalBytesRetired += i6;
                this.bufferSize -= i6;
                this.pos = 0;
            }
            InputStream inputStream = this.input;
            byte[] bArr2 = this.buffer;
            int i11 = this.bufferSize;
            int read = read(inputStream, bArr2, i11, Math.min(bArr2.length - i11, (this.sizeLimit - this.totalBytesRetired) - i11));
            if (read == 0 || read < -1 || read > this.buffer.length) {
                throw new IllegalStateException(this.input.getClass() + "#read(byte[]) returned invalid result: " + read + "\nThe InputStream implementation is buggy.");
            }
            if (read <= 0) {
                return false;
            }
            this.bufferSize += read;
            recomputeBufferSizeAfterLimit();
            if (this.bufferSize >= i5) {
                return true;
            }
            return tryRefillBuffer(i5);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public void checkLastTagWas(int i5) {
            if (this.lastTag != i5) {
                throw InvalidProtocolBufferException.invalidEndTag();
            }
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public int getTotalBytesRead() {
            return this.totalBytesRetired + this.pos;
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public boolean isAtEnd() {
            return this.pos == this.bufferSize && !tryRefillBuffer(1);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public void popLimit(int i5) {
            this.currentLimit = i5;
            recomputeBufferSizeAfterLimit();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public int pushLimit(int i5) {
            if (i5 < 0) {
                throw InvalidProtocolBufferException.negativeSize();
            }
            int i6 = i5 + this.totalBytesRetired + this.pos;
            if (i6 < 0) {
                throw InvalidProtocolBufferException.parseFailure();
            }
            int i7 = this.currentLimit;
            if (i6 > i7) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            this.currentLimit = i6;
            recomputeBufferSizeAfterLimit();
            return i7;
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public boolean readBool() {
            return readRawVarint64() != 0;
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public ByteString readBytes() {
            int readRawVarint32 = readRawVarint32();
            int i5 = this.bufferSize;
            int i6 = this.pos;
            if (readRawVarint32 <= i5 - i6 && readRawVarint32 > 0) {
                ByteString copyFrom = ByteString.copyFrom(this.buffer, i6, readRawVarint32);
                this.pos += readRawVarint32;
                return copyFrom;
            }
            if (readRawVarint32 == 0) {
                return ByteString.EMPTY;
            }
            if (readRawVarint32 >= 0) {
                return readBytesSlowPath(readRawVarint32);
            }
            throw InvalidProtocolBufferException.negativeSize();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public double readDouble() {
            return Double.longBitsToDouble(readRawLittleEndian64());
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public int readEnum() {
            return readRawVarint32();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public int readFixed32() {
            return readRawLittleEndian32();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public long readFixed64() {
            return readRawLittleEndian64();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public float readFloat() {
            return Float.intBitsToFloat(readRawLittleEndian32());
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public int readInt32() {
            return readRawVarint32();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public long readInt64() {
            return readRawVarint64();
        }

        public byte readRawByte() {
            if (this.pos == this.bufferSize) {
                refillBuffer(1);
            }
            byte[] bArr = this.buffer;
            int i5 = this.pos;
            this.pos = i5 + 1;
            return bArr[i5];
        }

        public int readRawLittleEndian32() {
            int i5 = this.pos;
            if (this.bufferSize - i5 < 4) {
                refillBuffer(4);
                i5 = this.pos;
            }
            byte[] bArr = this.buffer;
            this.pos = i5 + 4;
            return ((bArr[i5 + 3] & 255) << 24) | (bArr[i5] & 255) | ((bArr[i5 + 1] & 255) << 8) | ((bArr[i5 + 2] & 255) << 16);
        }

        public long readRawLittleEndian64() {
            int i5 = this.pos;
            if (this.bufferSize - i5 < 8) {
                refillBuffer(8);
                i5 = this.pos;
            }
            byte[] bArr = this.buffer;
            this.pos = i5 + 8;
            return ((bArr[i5 + 7] & 255) << 56) | (bArr[i5] & 255) | ((bArr[i5 + 1] & 255) << 8) | ((bArr[i5 + 2] & 255) << 16) | ((bArr[i5 + 3] & 255) << 24) | ((bArr[i5 + 4] & 255) << 32) | ((bArr[i5 + 5] & 255) << 40) | ((bArr[i5 + 6] & 255) << 48);
        }

        public int readRawVarint32() {
            int i5;
            int i6 = this.pos;
            int i7 = this.bufferSize;
            if (i7 != i6) {
                byte[] bArr = this.buffer;
                int i8 = i6 + 1;
                byte b5 = bArr[i6];
                if (b5 >= 0) {
                    this.pos = i8;
                    return b5;
                }
                if (i7 - i8 >= 9) {
                    int i9 = i6 + 2;
                    int i10 = (bArr[i8] << 7) ^ b5;
                    if (i10 < 0) {
                        i5 = i10 ^ (-128);
                    } else {
                        int i11 = i6 + 3;
                        int i12 = (bArr[i9] << 14) ^ i10;
                        if (i12 >= 0) {
                            i5 = i12 ^ 16256;
                        } else {
                            int i13 = i6 + 4;
                            int i14 = i12 ^ (bArr[i11] << 21);
                            if (i14 < 0) {
                                i5 = (-2080896) ^ i14;
                            } else {
                                i11 = i6 + 5;
                                byte b6 = bArr[i13];
                                int i15 = (i14 ^ (b6 << 28)) ^ 266354560;
                                if (b6 < 0) {
                                    i13 = i6 + 6;
                                    if (bArr[i11] < 0) {
                                        i11 = i6 + 7;
                                        if (bArr[i13] < 0) {
                                            i13 = i6 + 8;
                                            if (bArr[i11] < 0) {
                                                i11 = i6 + 9;
                                                if (bArr[i13] < 0) {
                                                    int i16 = i6 + 10;
                                                    if (bArr[i11] >= 0) {
                                                        i9 = i16;
                                                        i5 = i15;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    i5 = i15;
                                }
                                i5 = i15;
                            }
                            i9 = i13;
                        }
                        i9 = i11;
                    }
                    this.pos = i9;
                    return i5;
                }
            }
            return (int) readRawVarint64SlowPath();
        }

        public long readRawVarint64() {
            long j5;
            long j6;
            long j7;
            int i5 = this.pos;
            int i6 = this.bufferSize;
            if (i6 != i5) {
                byte[] bArr = this.buffer;
                int i7 = i5 + 1;
                byte b5 = bArr[i5];
                if (b5 >= 0) {
                    this.pos = i7;
                    return b5;
                }
                if (i6 - i7 >= 9) {
                    int i8 = i5 + 2;
                    int i9 = (bArr[i7] << 7) ^ b5;
                    if (i9 < 0) {
                        j5 = i9 ^ (-128);
                    } else {
                        int i10 = i5 + 3;
                        int i11 = (bArr[i8] << 14) ^ i9;
                        if (i11 >= 0) {
                            j5 = i11 ^ 16256;
                            i8 = i10;
                        } else {
                            int i12 = i5 + 4;
                            int i13 = i11 ^ (bArr[i10] << 21);
                            if (i13 < 0) {
                                long j8 = (-2080896) ^ i13;
                                i8 = i12;
                                j5 = j8;
                            } else {
                                long j9 = i13;
                                i8 = i5 + 5;
                                long j10 = j9 ^ (bArr[i12] << 28);
                                if (j10 >= 0) {
                                    j7 = 266354560;
                                } else {
                                    int i14 = i5 + 6;
                                    long j11 = j10 ^ (bArr[i8] << 35);
                                    if (j11 < 0) {
                                        j6 = -34093383808L;
                                    } else {
                                        i8 = i5 + 7;
                                        j10 = j11 ^ (bArr[i14] << 42);
                                        if (j10 >= 0) {
                                            j7 = 4363953127296L;
                                        } else {
                                            i14 = i5 + 8;
                                            j11 = j10 ^ (bArr[i8] << 49);
                                            if (j11 < 0) {
                                                j6 = -558586000294016L;
                                            } else {
                                                i8 = i5 + 9;
                                                long j12 = (j11 ^ (bArr[i14] << 56)) ^ 71499008037633920L;
                                                if (j12 < 0) {
                                                    int i15 = i5 + 10;
                                                    if (bArr[i8] >= 0) {
                                                        i8 = i15;
                                                    }
                                                }
                                                j5 = j12;
                                            }
                                        }
                                    }
                                    j5 = j11 ^ j6;
                                    i8 = i14;
                                }
                                j5 = j10 ^ j7;
                            }
                        }
                    }
                    this.pos = i8;
                    return j5;
                }
            }
            return readRawVarint64SlowPath();
        }

        long readRawVarint64SlowPath() {
            long j5 = 0;
            for (int i5 = 0; i5 < 64; i5 += 7) {
                j5 |= (r3 & Byte.MAX_VALUE) << i5;
                if ((readRawByte() & 128) == 0) {
                    return j5;
                }
            }
            throw InvalidProtocolBufferException.malformedVarint();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public int readSFixed32() {
            return readRawLittleEndian32();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public long readSFixed64() {
            return readRawLittleEndian64();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public int readSInt32() {
            return CodedInputStream.decodeZigZag32(readRawVarint32());
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public long readSInt64() {
            return CodedInputStream.decodeZigZag64(readRawVarint64());
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public String readString() {
            int readRawVarint32 = readRawVarint32();
            if (readRawVarint32 > 0) {
                int i5 = this.bufferSize;
                int i6 = this.pos;
                if (readRawVarint32 <= i5 - i6) {
                    String str = new String(this.buffer, i6, readRawVarint32, Internal.UTF_8);
                    this.pos += readRawVarint32;
                    return str;
                }
            }
            if (readRawVarint32 == 0) {
                return BuildConfig.FLAVOR;
            }
            if (readRawVarint32 < 0) {
                throw InvalidProtocolBufferException.negativeSize();
            }
            if (readRawVarint32 > this.bufferSize) {
                return new String(readRawBytesSlowPath(readRawVarint32, false), Internal.UTF_8);
            }
            refillBuffer(readRawVarint32);
            String str2 = new String(this.buffer, this.pos, readRawVarint32, Internal.UTF_8);
            this.pos += readRawVarint32;
            return str2;
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public String readStringRequireUtf8() {
            byte[] readRawBytesSlowPath;
            int readRawVarint32 = readRawVarint32();
            int i5 = this.pos;
            int i6 = this.bufferSize;
            if (readRawVarint32 <= i6 - i5 && readRawVarint32 > 0) {
                readRawBytesSlowPath = this.buffer;
                this.pos = i5 + readRawVarint32;
            } else {
                if (readRawVarint32 == 0) {
                    return BuildConfig.FLAVOR;
                }
                if (readRawVarint32 < 0) {
                    throw InvalidProtocolBufferException.negativeSize();
                }
                i5 = 0;
                if (readRawVarint32 <= i6) {
                    refillBuffer(readRawVarint32);
                    readRawBytesSlowPath = this.buffer;
                    this.pos = readRawVarint32;
                } else {
                    readRawBytesSlowPath = readRawBytesSlowPath(readRawVarint32, false);
                }
            }
            return Utf8.decodeUtf8(readRawBytesSlowPath, i5, readRawVarint32);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public int readTag() {
            if (isAtEnd()) {
                this.lastTag = 0;
                return 0;
            }
            int readRawVarint32 = readRawVarint32();
            this.lastTag = readRawVarint32;
            if (WireFormat.getTagFieldNumber(readRawVarint32) != 0) {
                return this.lastTag;
            }
            throw InvalidProtocolBufferException.invalidTag();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public int readUInt32() {
            return readRawVarint32();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public long readUInt64() {
            return readRawVarint64();
        }

        @Override // androidx.datastore.preferences.protobuf.CodedInputStream
        public boolean skipField(int i5) {
            int tagWireType = WireFormat.getTagWireType(i5);
            if (tagWireType == 0) {
                skipRawVarint();
                return true;
            }
            if (tagWireType == 1) {
                skipRawBytes(8);
                return true;
            }
            if (tagWireType == 2) {
                skipRawBytes(readRawVarint32());
                return true;
            }
            if (tagWireType == 3) {
                skipMessage();
                checkLastTagWas(WireFormat.makeTag(WireFormat.getTagFieldNumber(i5), 4));
                return true;
            }
            if (tagWireType == 4) {
                return false;
            }
            if (tagWireType != 5) {
                throw InvalidProtocolBufferException.invalidWireType();
            }
            skipRawBytes(4);
            return true;
        }

        public void skipRawBytes(int i5) {
            int i6 = this.bufferSize;
            int i7 = this.pos;
            if (i5 > i6 - i7 || i5 < 0) {
                skipRawBytesSlowPath(i5);
            } else {
                this.pos = i7 + i5;
            }
        }

        private StreamDecoder(InputStream inputStream, int i5) {
            super();
            this.currentLimit = CodedInputStream.DEFAULT_SIZE_LIMIT;
            Internal.checkNotNull(inputStream, "input");
            this.input = inputStream;
            this.buffer = new byte[i5];
            this.bufferSize = 0;
            this.pos = 0;
            this.totalBytesRetired = 0;
        }
    }

    public static int decodeZigZag32(int i5) {
        return (-(i5 & 1)) ^ (i5 >>> 1);
    }

    public static long decodeZigZag64(long j5) {
        return (-(j5 & 1)) ^ (j5 >>> 1);
    }

    public static CodedInputStream newInstance(InputStream inputStream) {
        return newInstance(inputStream, DEFAULT_BUFFER_SIZE);
    }

    public abstract void checkLastTagWas(int i5);

    public void checkRecursionLimit() {
        if (this.recursionDepth >= this.recursionLimit) {
            throw InvalidProtocolBufferException.recursionLimitExceeded();
        }
    }

    public abstract int getTotalBytesRead();

    public abstract boolean isAtEnd();

    public abstract void popLimit(int i5);

    public abstract int pushLimit(int i5);

    public abstract boolean readBool();

    public abstract ByteString readBytes();

    public abstract double readDouble();

    public abstract int readEnum();

    public abstract int readFixed32();

    public abstract long readFixed64();

    public abstract float readFloat();

    public abstract int readInt32();

    public abstract long readInt64();

    public abstract int readSFixed32();

    public abstract long readSFixed64();

    public abstract int readSInt32();

    public abstract long readSInt64();

    public abstract String readString();

    public abstract String readStringRequireUtf8();

    public abstract int readTag();

    public abstract int readUInt32();

    public abstract long readUInt64();

    public abstract boolean skipField(int i5);

    public void skipMessage() {
        int readTag;
        do {
            readTag = readTag();
            if (readTag == 0) {
                return;
            }
            checkRecursionLimit();
            this.recursionDepth++;
            this.recursionDepth--;
        } while (skipField(readTag));
    }

    private CodedInputStream() {
        this.recursionLimit = defaultRecursionLimit;
        this.sizeLimit = DEFAULT_SIZE_LIMIT;
        this.shouldDiscardUnknownFields = false;
    }

    public static CodedInputStream newInstance(InputStream inputStream, int i5) {
        if (i5 <= 0) {
            throw new IllegalArgumentException("bufferSize must be > 0");
        }
        if (inputStream == null) {
            return newInstance(Internal.EMPTY_BYTE_ARRAY);
        }
        return new StreamDecoder(inputStream, i5);
    }

    public static CodedInputStream newInstance(byte[] bArr) {
        return newInstance(bArr, 0, bArr.length);
    }

    public static CodedInputStream newInstance(byte[] bArr, int i5, int i6) {
        return newInstance(bArr, i5, i6, false);
    }

    static CodedInputStream newInstance(byte[] bArr, int i5, int i6, boolean z5) {
        ArrayDecoder arrayDecoder = new ArrayDecoder(bArr, i5, i6, z5);
        try {
            arrayDecoder.pushLimit(i6);
            return arrayDecoder;
        } catch (InvalidProtocolBufferException e5) {
            throw new IllegalArgumentException(e5);
        }
    }
}
