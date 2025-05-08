package kotlin.reflect.jvm.internal.impl.protobuf;

import com.adjust.sdk.Constants;
import java.io.InputStream;
import java.util.ArrayList;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import org.conscrypt.BuildConfig;

/* loaded from: classes3.dex */
public final class CodedInputStream {
    private int bufferSizeAfterLimit;
    private final InputStream input;
    private int lastTag;
    private int recursionDepth;
    private RefillCallback refillCallback;
    private boolean enableAliasing = false;
    private int currentLimit = Integer.MAX_VALUE;
    private int recursionLimit = 64;
    private int sizeLimit = 67108864;
    private final byte[] buffer = new byte[4096];
    private int bufferSize = 0;
    private int bufferPos = 0;
    private int totalBytesRetired = 0;
    private final boolean bufferIsImmutable = false;

    /* loaded from: classes3.dex */
    private interface RefillCallback {
    }

    private CodedInputStream(InputStream inputStream) {
        this.input = inputStream;
    }

    public static int decodeZigZag32(int i5) {
        return (-(i5 & 1)) ^ (i5 >>> 1);
    }

    public static long decodeZigZag64(long j5) {
        return (-(j5 & 1)) ^ (j5 >>> 1);
    }

    private void ensureAvailable(int i5) {
        if (this.bufferSize - this.bufferPos < i5) {
            refillBuffer(i5);
        }
    }

    public static CodedInputStream newInstance(InputStream inputStream) {
        return new CodedInputStream(inputStream);
    }

    private byte[] readRawBytesSlowPath(int i5) {
        if (i5 <= 0) {
            if (i5 == 0) {
                return Internal.EMPTY_BYTE_ARRAY;
            }
            throw InvalidProtocolBufferException.negativeSize();
        }
        int i6 = this.totalBytesRetired;
        int i7 = this.bufferPos;
        int i8 = i6 + i7 + i5;
        int i9 = this.currentLimit;
        if (i8 > i9) {
            skipRawBytes((i9 - i6) - i7);
            throw InvalidProtocolBufferException.truncatedMessage();
        }
        if (i5 < 4096) {
            byte[] bArr = new byte[i5];
            int i10 = this.bufferSize - i7;
            System.arraycopy(this.buffer, i7, bArr, 0, i10);
            this.bufferPos = this.bufferSize;
            int i11 = i5 - i10;
            ensureAvailable(i11);
            System.arraycopy(this.buffer, 0, bArr, i10, i11);
            this.bufferPos = i11;
            return bArr;
        }
        int i12 = this.bufferSize;
        this.totalBytesRetired = i6 + i12;
        this.bufferPos = 0;
        this.bufferSize = 0;
        int i13 = i12 - i7;
        int i14 = i5 - i13;
        ArrayList<byte[]> arrayList = new ArrayList();
        while (i14 > 0) {
            int min = Math.min(i14, 4096);
            byte[] bArr2 = new byte[min];
            int i15 = 0;
            while (i15 < min) {
                InputStream inputStream = this.input;
                int read = inputStream == null ? -1 : inputStream.read(bArr2, i15, min - i15);
                if (read == -1) {
                    throw InvalidProtocolBufferException.truncatedMessage();
                }
                this.totalBytesRetired += read;
                i15 += read;
            }
            i14 -= min;
            arrayList.add(bArr2);
        }
        byte[] bArr3 = new byte[i5];
        System.arraycopy(this.buffer, i7, bArr3, 0, i13);
        for (byte[] bArr4 : arrayList) {
            System.arraycopy(bArr4, 0, bArr3, i13, bArr4.length);
            i13 += bArr4.length;
        }
        return bArr3;
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
        if (!tryRefillBuffer(i5)) {
            throw InvalidProtocolBufferException.truncatedMessage();
        }
    }

    private void skipRawBytesSlowPath(int i5) {
        if (i5 < 0) {
            throw InvalidProtocolBufferException.negativeSize();
        }
        int i6 = this.totalBytesRetired;
        int i7 = this.bufferPos;
        int i8 = i6 + i7 + i5;
        int i9 = this.currentLimit;
        if (i8 > i9) {
            skipRawBytes((i9 - i6) - i7);
            throw InvalidProtocolBufferException.truncatedMessage();
        }
        int i10 = this.bufferSize;
        int i11 = i10 - i7;
        this.bufferPos = i10;
        refillBuffer(1);
        while (true) {
            int i12 = i5 - i11;
            int i13 = this.bufferSize;
            if (i12 <= i13) {
                this.bufferPos = i12;
                return;
            } else {
                i11 += i13;
                this.bufferPos = i13;
                refillBuffer(1);
            }
        }
    }

    private boolean tryRefillBuffer(int i5) {
        int i6 = this.bufferPos;
        int i7 = i6 + i5;
        int i8 = this.bufferSize;
        if (i7 <= i8) {
            StringBuilder sb = new StringBuilder(77);
            sb.append("refillBuffer() called when ");
            sb.append(i5);
            sb.append(" bytes were already available in buffer");
            throw new IllegalStateException(sb.toString());
        }
        if (this.totalBytesRetired + i6 + i5 <= this.currentLimit && this.input != null) {
            if (i6 > 0) {
                if (i8 > i6) {
                    byte[] bArr = this.buffer;
                    System.arraycopy(bArr, i6, bArr, 0, i8 - i6);
                }
                this.totalBytesRetired += i6;
                this.bufferSize -= i6;
                this.bufferPos = 0;
            }
            InputStream inputStream = this.input;
            byte[] bArr2 = this.buffer;
            int i9 = this.bufferSize;
            int read = inputStream.read(bArr2, i9, bArr2.length - i9);
            if (read == 0 || read < -1 || read > this.buffer.length) {
                StringBuilder sb2 = new StringBuilder(102);
                sb2.append("InputStream#read(byte[]) returned invalid result: ");
                sb2.append(read);
                sb2.append("\nThe InputStream implementation is buggy.");
                throw new IllegalStateException(sb2.toString());
            }
            if (read > 0) {
                this.bufferSize += read;
                if ((this.totalBytesRetired + i5) - this.sizeLimit > 0) {
                    throw InvalidProtocolBufferException.sizeLimitExceeded();
                }
                recomputeBufferSizeAfterLimit();
                if (this.bufferSize >= i5) {
                    return true;
                }
                return tryRefillBuffer(i5);
            }
        }
        return false;
    }

    public void checkLastTagWas(int i5) {
        if (this.lastTag != i5) {
            throw InvalidProtocolBufferException.invalidEndTag();
        }
    }

    public int getBytesUntilLimit() {
        int i5 = this.currentLimit;
        if (i5 == Integer.MAX_VALUE) {
            return -1;
        }
        return i5 - (this.totalBytesRetired + this.bufferPos);
    }

    public boolean isAtEnd() {
        return this.bufferPos == this.bufferSize && !tryRefillBuffer(1);
    }

    public void popLimit(int i5) {
        this.currentLimit = i5;
        recomputeBufferSizeAfterLimit();
    }

    public int pushLimit(int i5) {
        if (i5 < 0) {
            throw InvalidProtocolBufferException.negativeSize();
        }
        int i6 = i5 + this.totalBytesRetired + this.bufferPos;
        int i7 = this.currentLimit;
        if (i6 > i7) {
            throw InvalidProtocolBufferException.truncatedMessage();
        }
        this.currentLimit = i6;
        recomputeBufferSizeAfterLimit();
        return i7;
    }

    public boolean readBool() {
        return readRawVarint64() != 0;
    }

    public ByteString readBytes() {
        int readRawVarint32 = readRawVarint32();
        int i5 = this.bufferSize;
        int i6 = this.bufferPos;
        if (readRawVarint32 > i5 - i6 || readRawVarint32 <= 0) {
            return readRawVarint32 == 0 ? ByteString.EMPTY : new LiteralByteString(readRawBytesSlowPath(readRawVarint32));
        }
        ByteString boundedByteString = (this.bufferIsImmutable && this.enableAliasing) ? new BoundedByteString(this.buffer, this.bufferPos, readRawVarint32) : ByteString.copyFrom(this.buffer, i6, readRawVarint32);
        this.bufferPos += readRawVarint32;
        return boundedByteString;
    }

    public double readDouble() {
        return Double.longBitsToDouble(readRawLittleEndian64());
    }

    public int readEnum() {
        return readRawVarint32();
    }

    public int readFixed32() {
        return readRawLittleEndian32();
    }

    public long readFixed64() {
        return readRawLittleEndian64();
    }

    public float readFloat() {
        return Float.intBitsToFloat(readRawLittleEndian32());
    }

    public void readGroup(int i5, MessageLite.Builder builder, ExtensionRegistryLite extensionRegistryLite) {
        int i6 = this.recursionDepth;
        if (i6 >= this.recursionLimit) {
            throw InvalidProtocolBufferException.recursionLimitExceeded();
        }
        this.recursionDepth = i6 + 1;
        builder.mergeFrom(this, extensionRegistryLite);
        checkLastTagWas(WireFormat.makeTag(i5, 4));
        this.recursionDepth--;
    }

    public int readInt32() {
        return readRawVarint32();
    }

    public long readInt64() {
        return readRawVarint64();
    }

    public void readMessage(MessageLite.Builder builder, ExtensionRegistryLite extensionRegistryLite) {
        int readRawVarint32 = readRawVarint32();
        if (this.recursionDepth < this.recursionLimit) {
            int pushLimit = pushLimit(readRawVarint32);
            this.recursionDepth++;
            builder.mergeFrom(this, extensionRegistryLite);
            checkLastTagWas(0);
            this.recursionDepth--;
            popLimit(pushLimit);
            return;
        }
        throw InvalidProtocolBufferException.recursionLimitExceeded();
    }

    public byte readRawByte() {
        if (this.bufferPos == this.bufferSize) {
            refillBuffer(1);
        }
        byte[] bArr = this.buffer;
        int i5 = this.bufferPos;
        this.bufferPos = i5 + 1;
        return bArr[i5];
    }

    public int readRawLittleEndian32() {
        int i5 = this.bufferPos;
        if (this.bufferSize - i5 < 4) {
            refillBuffer(4);
            i5 = this.bufferPos;
        }
        byte[] bArr = this.buffer;
        this.bufferPos = i5 + 4;
        return ((bArr[i5 + 3] & 255) << 24) | (bArr[i5] & 255) | ((bArr[i5 + 1] & 255) << 8) | ((bArr[i5 + 2] & 255) << 16);
    }

    public long readRawLittleEndian64() {
        int i5 = this.bufferPos;
        if (this.bufferSize - i5 < 8) {
            refillBuffer(8);
            i5 = this.bufferPos;
        }
        byte[] bArr = this.buffer;
        this.bufferPos = i5 + 8;
        return ((bArr[i5 + 7] & 255) << 56) | (bArr[i5] & 255) | ((bArr[i5 + 1] & 255) << 8) | ((bArr[i5 + 2] & 255) << 16) | ((bArr[i5 + 3] & 255) << 24) | ((bArr[i5 + 4] & 255) << 32) | ((bArr[i5 + 5] & 255) << 40) | ((bArr[i5 + 6] & 255) << 48);
    }

    public int readRawVarint32() {
        int i5;
        int i6 = this.bufferPos;
        int i7 = this.bufferSize;
        if (i7 != i6) {
            byte[] bArr = this.buffer;
            int i8 = i6 + 1;
            byte b5 = bArr[i6];
            if (b5 >= 0) {
                this.bufferPos = i8;
                return b5;
            }
            if (i7 - i8 >= 9) {
                int i9 = i6 + 2;
                int i10 = (bArr[i8] << 7) ^ b5;
                long j5 = i10;
                if (j5 < 0) {
                    i5 = (int) ((-128) ^ j5);
                } else {
                    int i11 = i6 + 3;
                    int i12 = (bArr[i9] << 14) ^ i10;
                    long j6 = i12;
                    if (j6 >= 0) {
                        i5 = (int) (16256 ^ j6);
                    } else {
                        int i13 = i6 + 4;
                        long j7 = i12 ^ (bArr[i11] << 21);
                        if (j7 < 0) {
                            i5 = (int) ((-2080896) ^ j7);
                        } else {
                            i11 = i6 + 5;
                            int i14 = (int) ((r1 ^ (r3 << 28)) ^ 266354560);
                            if (bArr[i13] < 0) {
                                i13 = i6 + 6;
                                if (bArr[i11] < 0) {
                                    i11 = i6 + 7;
                                    if (bArr[i13] < 0) {
                                        i13 = i6 + 8;
                                        if (bArr[i11] < 0) {
                                            i11 = i6 + 9;
                                            if (bArr[i13] < 0) {
                                                int i15 = i6 + 10;
                                                if (bArr[i11] >= 0) {
                                                    i9 = i15;
                                                    i5 = i14;
                                                }
                                            }
                                        }
                                    }
                                }
                                i5 = i14;
                            }
                            i5 = i14;
                        }
                        i9 = i13;
                    }
                    i9 = i11;
                }
                this.bufferPos = i9;
                return i5;
            }
        }
        return (int) readRawVarint64SlowPath();
    }

    public long readRawVarint64() {
        long j5;
        long j6;
        long j7;
        int i5 = this.bufferPos;
        int i6 = this.bufferSize;
        if (i6 != i5) {
            byte[] bArr = this.buffer;
            int i7 = i5 + 1;
            byte b5 = bArr[i5];
            if (b5 >= 0) {
                this.bufferPos = i7;
                return b5;
            }
            if (i6 - i7 >= 9) {
                int i8 = i5 + 2;
                long j8 = (bArr[i7] << 7) ^ b5;
                if (j8 >= 0) {
                    int i9 = i5 + 3;
                    long j9 = j8 ^ (bArr[i8] << 14);
                    if (j9 >= 0) {
                        j7 = 16256;
                    } else {
                        i8 = i5 + 4;
                        j8 = j9 ^ (bArr[i9] << 21);
                        if (j8 < 0) {
                            j6 = -2080896;
                        } else {
                            i9 = i5 + 5;
                            j9 = j8 ^ (bArr[i8] << 28);
                            if (j9 >= 0) {
                                j7 = 266354560;
                            } else {
                                i8 = i5 + 6;
                                j8 = j9 ^ (bArr[i9] << 35);
                                if (j8 < 0) {
                                    j6 = -34093383808L;
                                } else {
                                    i9 = i5 + 7;
                                    j9 = j8 ^ (bArr[i8] << 42);
                                    if (j9 >= 0) {
                                        j7 = 4363953127296L;
                                    } else {
                                        i8 = i5 + 8;
                                        j8 = j9 ^ (bArr[i9] << 49);
                                        if (j8 < 0) {
                                            j6 = -558586000294016L;
                                        } else {
                                            i9 = i5 + 9;
                                            long j10 = (j8 ^ (bArr[i8] << 56)) ^ 71499008037633920L;
                                            if (j10 >= 0) {
                                                j5 = j10;
                                                i8 = i9;
                                                this.bufferPos = i8;
                                                return j5;
                                            }
                                            i8 = i5 + 10;
                                            if (bArr[i9] >= 0) {
                                                j5 = j10;
                                                this.bufferPos = i8;
                                                return j5;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    j5 = j9 ^ j7;
                    i8 = i9;
                    this.bufferPos = i8;
                    return j5;
                }
                j6 = -128;
                j5 = j8 ^ j6;
                this.bufferPos = i8;
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

    public int readSFixed32() {
        return readRawLittleEndian32();
    }

    public long readSFixed64() {
        return readRawLittleEndian64();
    }

    public int readSInt32() {
        return decodeZigZag32(readRawVarint32());
    }

    public long readSInt64() {
        return decodeZigZag64(readRawVarint64());
    }

    public String readString() {
        int readRawVarint32 = readRawVarint32();
        int i5 = this.bufferSize;
        int i6 = this.bufferPos;
        if (readRawVarint32 > i5 - i6 || readRawVarint32 <= 0) {
            return readRawVarint32 == 0 ? BuildConfig.FLAVOR : new String(readRawBytesSlowPath(readRawVarint32), Constants.ENCODING);
        }
        String str = new String(this.buffer, i6, readRawVarint32, Constants.ENCODING);
        this.bufferPos += readRawVarint32;
        return str;
    }

    public String readStringRequireUtf8() {
        byte[] readRawBytesSlowPath;
        int readRawVarint32 = readRawVarint32();
        int i5 = this.bufferPos;
        if (readRawVarint32 <= this.bufferSize - i5 && readRawVarint32 > 0) {
            readRawBytesSlowPath = this.buffer;
            this.bufferPos = i5 + readRawVarint32;
        } else {
            if (readRawVarint32 == 0) {
                return BuildConfig.FLAVOR;
            }
            readRawBytesSlowPath = readRawBytesSlowPath(readRawVarint32);
            i5 = 0;
        }
        if (Utf8.isValidUtf8(readRawBytesSlowPath, i5, i5 + readRawVarint32)) {
            return new String(readRawBytesSlowPath, i5, readRawVarint32, Constants.ENCODING);
        }
        throw InvalidProtocolBufferException.invalidUtf8();
    }

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

    public int readUInt32() {
        return readRawVarint32();
    }

    public long readUInt64() {
        return readRawVarint64();
    }

    public boolean skipField(int i5, CodedOutputStream codedOutputStream) {
        int tagWireType = WireFormat.getTagWireType(i5);
        if (tagWireType == 0) {
            long readInt64 = readInt64();
            codedOutputStream.writeRawVarint32(i5);
            codedOutputStream.writeUInt64NoTag(readInt64);
            return true;
        }
        if (tagWireType == 1) {
            long readRawLittleEndian64 = readRawLittleEndian64();
            codedOutputStream.writeRawVarint32(i5);
            codedOutputStream.writeFixed64NoTag(readRawLittleEndian64);
            return true;
        }
        if (tagWireType == 2) {
            ByteString readBytes = readBytes();
            codedOutputStream.writeRawVarint32(i5);
            codedOutputStream.writeBytesNoTag(readBytes);
            return true;
        }
        if (tagWireType == 3) {
            codedOutputStream.writeRawVarint32(i5);
            skipMessage(codedOutputStream);
            int makeTag = WireFormat.makeTag(WireFormat.getTagFieldNumber(i5), 4);
            checkLastTagWas(makeTag);
            codedOutputStream.writeRawVarint32(makeTag);
            return true;
        }
        if (tagWireType == 4) {
            return false;
        }
        if (tagWireType != 5) {
            throw InvalidProtocolBufferException.invalidWireType();
        }
        int readRawLittleEndian32 = readRawLittleEndian32();
        codedOutputStream.writeRawVarint32(i5);
        codedOutputStream.writeFixed32NoTag(readRawLittleEndian32);
        return true;
    }

    public void skipMessage(CodedOutputStream codedOutputStream) {
        int readTag;
        do {
            readTag = readTag();
            if (readTag == 0) {
                return;
            }
        } while (skipField(readTag, codedOutputStream));
    }

    public void skipRawBytes(int i5) {
        int i6 = this.bufferSize;
        int i7 = this.bufferPos;
        if (i5 > i6 - i7 || i5 < 0) {
            skipRawBytesSlowPath(i5);
        } else {
            this.bufferPos = i7 + i5;
        }
    }

    public <T extends MessageLite> T readMessage(Parser<T> parser, ExtensionRegistryLite extensionRegistryLite) {
        int readRawVarint32 = readRawVarint32();
        if (this.recursionDepth < this.recursionLimit) {
            int pushLimit = pushLimit(readRawVarint32);
            this.recursionDepth++;
            T parsePartialFrom = parser.parsePartialFrom(this, extensionRegistryLite);
            checkLastTagWas(0);
            this.recursionDepth--;
            popLimit(pushLimit);
            return parsePartialFrom;
        }
        throw InvalidProtocolBufferException.recursionLimitExceeded();
    }

    public static int readRawVarint32(int i5, InputStream inputStream) {
        if ((i5 & 128) == 0) {
            return i5;
        }
        int i6 = i5 & 127;
        int i7 = 7;
        while (i7 < 32) {
            int read = inputStream.read();
            if (read == -1) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            i6 |= (read & 127) << i7;
            if ((read & 128) == 0) {
                return i6;
            }
            i7 += 7;
        }
        while (i7 < 64) {
            int read2 = inputStream.read();
            if (read2 == -1) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            if ((read2 & 128) == 0) {
                return i6;
            }
            i7 += 7;
        }
        throw InvalidProtocolBufferException.malformedVarint();
    }
}
