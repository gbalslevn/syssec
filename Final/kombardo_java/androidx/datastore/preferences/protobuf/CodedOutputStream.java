package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.Utf8;
import com.sun.jna.Function;
import java.io.IOException;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes.dex */
public abstract class CodedOutputStream extends ByteOutput {
    private boolean serializationDeterministic;
    CodedOutputStreamWriter wrapper;
    private static final Logger logger = Logger.getLogger(CodedOutputStream.class.getName());
    private static final boolean HAS_UNSAFE_ARRAY_OPERATIONS = UnsafeUtil.hasUnsafeArrayOperations();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static abstract class AbstractBufferedEncoder extends CodedOutputStream {
        final byte[] buffer;
        final int limit;
        int position;
        int totalBytesWritten;

        AbstractBufferedEncoder(int i5) {
            super();
            if (i5 < 0) {
                throw new IllegalArgumentException("bufferSize must be >= 0");
            }
            byte[] bArr = new byte[Math.max(i5, 20)];
            this.buffer = bArr;
            this.limit = bArr.length;
        }

        final void buffer(byte b5) {
            byte[] bArr = this.buffer;
            int i5 = this.position;
            this.position = i5 + 1;
            bArr[i5] = b5;
            this.totalBytesWritten++;
        }

        final void bufferFixed32NoTag(int i5) {
            byte[] bArr = this.buffer;
            int i6 = this.position;
            int i7 = i6 + 1;
            this.position = i7;
            bArr[i6] = (byte) (i5 & Function.USE_VARARGS);
            int i8 = i6 + 2;
            this.position = i8;
            bArr[i7] = (byte) ((i5 >> 8) & Function.USE_VARARGS);
            int i9 = i6 + 3;
            this.position = i9;
            bArr[i8] = (byte) ((i5 >> 16) & Function.USE_VARARGS);
            this.position = i6 + 4;
            bArr[i9] = (byte) ((i5 >> 24) & Function.USE_VARARGS);
            this.totalBytesWritten += 4;
        }

        final void bufferFixed64NoTag(long j5) {
            byte[] bArr = this.buffer;
            int i5 = this.position;
            int i6 = i5 + 1;
            this.position = i6;
            bArr[i5] = (byte) (j5 & 255);
            int i7 = i5 + 2;
            this.position = i7;
            bArr[i6] = (byte) ((j5 >> 8) & 255);
            int i8 = i5 + 3;
            this.position = i8;
            bArr[i7] = (byte) ((j5 >> 16) & 255);
            int i9 = i5 + 4;
            this.position = i9;
            bArr[i8] = (byte) (255 & (j5 >> 24));
            int i10 = i5 + 5;
            this.position = i10;
            bArr[i9] = (byte) (((int) (j5 >> 32)) & Function.USE_VARARGS);
            int i11 = i5 + 6;
            this.position = i11;
            bArr[i10] = (byte) (((int) (j5 >> 40)) & Function.USE_VARARGS);
            int i12 = i5 + 7;
            this.position = i12;
            bArr[i11] = (byte) (((int) (j5 >> 48)) & Function.USE_VARARGS);
            this.position = i5 + 8;
            bArr[i12] = (byte) (((int) (j5 >> 56)) & Function.USE_VARARGS);
            this.totalBytesWritten += 8;
        }

        final void bufferInt32NoTag(int i5) {
            if (i5 >= 0) {
                bufferUInt32NoTag(i5);
            } else {
                bufferUInt64NoTag(i5);
            }
        }

        final void bufferTag(int i5, int i6) {
            bufferUInt32NoTag(WireFormat.makeTag(i5, i6));
        }

        final void bufferUInt32NoTag(int i5) {
            if (!CodedOutputStream.HAS_UNSAFE_ARRAY_OPERATIONS) {
                while ((i5 & (-128)) != 0) {
                    byte[] bArr = this.buffer;
                    int i6 = this.position;
                    this.position = i6 + 1;
                    bArr[i6] = (byte) ((i5 | 128) & Function.USE_VARARGS);
                    this.totalBytesWritten++;
                    i5 >>>= 7;
                }
                byte[] bArr2 = this.buffer;
                int i7 = this.position;
                this.position = i7 + 1;
                bArr2[i7] = (byte) i5;
                this.totalBytesWritten++;
                return;
            }
            long j5 = this.position;
            while ((i5 & (-128)) != 0) {
                byte[] bArr3 = this.buffer;
                int i8 = this.position;
                this.position = i8 + 1;
                UnsafeUtil.putByte(bArr3, i8, (byte) ((i5 | 128) & Function.USE_VARARGS));
                i5 >>>= 7;
            }
            byte[] bArr4 = this.buffer;
            int i9 = this.position;
            this.position = i9 + 1;
            UnsafeUtil.putByte(bArr4, i9, (byte) i5);
            this.totalBytesWritten += (int) (this.position - j5);
        }

        final void bufferUInt64NoTag(long j5) {
            if (!CodedOutputStream.HAS_UNSAFE_ARRAY_OPERATIONS) {
                while ((j5 & (-128)) != 0) {
                    byte[] bArr = this.buffer;
                    int i5 = this.position;
                    this.position = i5 + 1;
                    bArr[i5] = (byte) ((((int) j5) | 128) & Function.USE_VARARGS);
                    this.totalBytesWritten++;
                    j5 >>>= 7;
                }
                byte[] bArr2 = this.buffer;
                int i6 = this.position;
                this.position = i6 + 1;
                bArr2[i6] = (byte) j5;
                this.totalBytesWritten++;
                return;
            }
            long j6 = this.position;
            while ((j5 & (-128)) != 0) {
                byte[] bArr3 = this.buffer;
                int i7 = this.position;
                this.position = i7 + 1;
                UnsafeUtil.putByte(bArr3, i7, (byte) ((((int) j5) | 128) & Function.USE_VARARGS));
                j5 >>>= 7;
            }
            byte[] bArr4 = this.buffer;
            int i8 = this.position;
            this.position = i8 + 1;
            UnsafeUtil.putByte(bArr4, i8, (byte) j5);
            this.totalBytesWritten += (int) (this.position - j6);
        }
    }

    /* loaded from: classes.dex */
    public static class OutOfSpaceException extends IOException {
        private static final String MESSAGE = "CodedOutputStream was writing to a flat byte array and ran out of space.";
        private static final long serialVersionUID = -6947486886997889499L;

        OutOfSpaceException() {
            super(MESSAGE);
        }

        OutOfSpaceException(Throwable th) {
            super(MESSAGE, th);
        }
    }

    public static int computeBoolSize(int i5, boolean z5) {
        return computeTagSize(i5) + computeBoolSizeNoTag(z5);
    }

    public static int computeBoolSizeNoTag(boolean z5) {
        return 1;
    }

    public static int computeByteArraySizeNoTag(byte[] bArr) {
        return computeLengthDelimitedFieldSize(bArr.length);
    }

    public static int computeBytesSize(int i5, ByteString byteString) {
        return computeTagSize(i5) + computeBytesSizeNoTag(byteString);
    }

    public static int computeBytesSizeNoTag(ByteString byteString) {
        return computeLengthDelimitedFieldSize(byteString.size());
    }

    public static int computeDoubleSize(int i5, double d5) {
        return computeTagSize(i5) + computeDoubleSizeNoTag(d5);
    }

    public static int computeDoubleSizeNoTag(double d5) {
        return 8;
    }

    public static int computeEnumSize(int i5, int i6) {
        return computeTagSize(i5) + computeEnumSizeNoTag(i6);
    }

    public static int computeEnumSizeNoTag(int i5) {
        return computeInt32SizeNoTag(i5);
    }

    public static int computeFixed32Size(int i5, int i6) {
        return computeTagSize(i5) + computeFixed32SizeNoTag(i6);
    }

    public static int computeFixed32SizeNoTag(int i5) {
        return 4;
    }

    public static int computeFixed64Size(int i5, long j5) {
        return computeTagSize(i5) + computeFixed64SizeNoTag(j5);
    }

    public static int computeFixed64SizeNoTag(long j5) {
        return 8;
    }

    public static int computeFloatSize(int i5, float f5) {
        return computeTagSize(i5) + computeFloatSizeNoTag(f5);
    }

    public static int computeFloatSizeNoTag(float f5) {
        return 4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Deprecated
    public static int computeGroupSize(int i5, MessageLite messageLite, Schema schema) {
        return (computeTagSize(i5) * 2) + computeGroupSizeNoTag(messageLite, schema);
    }

    @Deprecated
    public static int computeGroupSizeNoTag(MessageLite messageLite) {
        return messageLite.getSerializedSize();
    }

    public static int computeInt32Size(int i5, int i6) {
        return computeTagSize(i5) + computeInt32SizeNoTag(i6);
    }

    public static int computeInt32SizeNoTag(int i5) {
        return computeUInt64SizeNoTag(i5);
    }

    public static int computeInt64Size(int i5, long j5) {
        return computeTagSize(i5) + computeInt64SizeNoTag(j5);
    }

    public static int computeInt64SizeNoTag(long j5) {
        return computeUInt64SizeNoTag(j5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int computeLengthDelimitedFieldSize(int i5) {
        return computeUInt32SizeNoTag(i5) + i5;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int computeMessageSize(int i5, MessageLite messageLite, Schema schema) {
        return computeTagSize(i5) + computeMessageSizeNoTag(messageLite, schema);
    }

    public static int computeMessageSizeNoTag(MessageLite messageLite) {
        return computeLengthDelimitedFieldSize(messageLite.getSerializedSize());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int computePreferredBufferSize(int i5) {
        if (i5 > 4096) {
            return 4096;
        }
        return i5;
    }

    public static int computeRawMessageSetExtensionSize(int i5, ByteString byteString) {
        return (computeTagSize(1) * 2) + computeUInt32Size(2, i5) + computeBytesSize(3, byteString);
    }

    public static int computeSFixed32Size(int i5, int i6) {
        return computeTagSize(i5) + computeSFixed32SizeNoTag(i6);
    }

    public static int computeSFixed32SizeNoTag(int i5) {
        return 4;
    }

    public static int computeSFixed64Size(int i5, long j5) {
        return computeTagSize(i5) + computeSFixed64SizeNoTag(j5);
    }

    public static int computeSFixed64SizeNoTag(long j5) {
        return 8;
    }

    public static int computeSInt32Size(int i5, int i6) {
        return computeTagSize(i5) + computeSInt32SizeNoTag(i6);
    }

    public static int computeSInt32SizeNoTag(int i5) {
        return computeUInt32SizeNoTag(encodeZigZag32(i5));
    }

    public static int computeSInt64Size(int i5, long j5) {
        return computeTagSize(i5) + computeSInt64SizeNoTag(j5);
    }

    public static int computeSInt64SizeNoTag(long j5) {
        return computeUInt64SizeNoTag(encodeZigZag64(j5));
    }

    public static int computeStringSize(int i5, String str) {
        return computeTagSize(i5) + computeStringSizeNoTag(str);
    }

    public static int computeStringSizeNoTag(String str) {
        int length;
        try {
            length = Utf8.encodedLength(str);
        } catch (Utf8.UnpairedSurrogateException unused) {
            length = str.getBytes(Internal.UTF_8).length;
        }
        return computeLengthDelimitedFieldSize(length);
    }

    public static int computeTagSize(int i5) {
        return computeUInt32SizeNoTag(WireFormat.makeTag(i5, 0));
    }

    public static int computeUInt32Size(int i5, int i6) {
        return computeTagSize(i5) + computeUInt32SizeNoTag(i6);
    }

    public static int computeUInt32SizeNoTag(int i5) {
        return (352 - (Integer.numberOfLeadingZeros(i5) * 9)) >>> 6;
    }

    public static int computeUInt64Size(int i5, long j5) {
        return computeTagSize(i5) + computeUInt64SizeNoTag(j5);
    }

    public static int computeUInt64SizeNoTag(long j5) {
        return (640 - (Long.numberOfLeadingZeros(j5) * 9)) >>> 6;
    }

    public static int encodeZigZag32(int i5) {
        return (i5 >> 31) ^ (i5 << 1);
    }

    public static long encodeZigZag64(long j5) {
        return (j5 >> 63) ^ (j5 << 1);
    }

    public static CodedOutputStream newInstance(OutputStream outputStream, int i5) {
        return new OutputStreamEncoder(outputStream, i5);
    }

    public abstract void flush();

    final void inefficientWriteStringNoTag(String str, Utf8.UnpairedSurrogateException unpairedSurrogateException) {
        logger.log(Level.WARNING, "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) unpairedSurrogateException);
        byte[] bytes = str.getBytes(Internal.UTF_8);
        try {
            writeUInt32NoTag(bytes.length);
            writeLazy(bytes, 0, bytes.length);
        } catch (IndexOutOfBoundsException e5) {
            throw new OutOfSpaceException(e5);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isSerializationDeterministic() {
        return this.serializationDeterministic;
    }

    public abstract void write(byte b5);

    public abstract void writeBool(int i5, boolean z5);

    public final void writeBoolNoTag(boolean z5) {
        write(z5 ? (byte) 1 : (byte) 0);
    }

    public final void writeByteArrayNoTag(byte[] bArr) {
        writeByteArrayNoTag(bArr, 0, bArr.length);
    }

    abstract void writeByteArrayNoTag(byte[] bArr, int i5, int i6);

    public abstract void writeBytes(int i5, ByteString byteString);

    public abstract void writeBytesNoTag(ByteString byteString);

    public final void writeDouble(int i5, double d5) {
        writeFixed64(i5, Double.doubleToRawLongBits(d5));
    }

    public final void writeDoubleNoTag(double d5) {
        writeFixed64NoTag(Double.doubleToRawLongBits(d5));
    }

    public final void writeEnum(int i5, int i6) {
        writeInt32(i5, i6);
    }

    public final void writeEnumNoTag(int i5) {
        writeInt32NoTag(i5);
    }

    public abstract void writeFixed32(int i5, int i6);

    public abstract void writeFixed32NoTag(int i5);

    public abstract void writeFixed64(int i5, long j5);

    public abstract void writeFixed64NoTag(long j5);

    public final void writeFloat(int i5, float f5) {
        writeFixed32(i5, Float.floatToRawIntBits(f5));
    }

    public final void writeFloatNoTag(float f5) {
        writeFixed32NoTag(Float.floatToRawIntBits(f5));
    }

    @Deprecated
    public final void writeGroup(int i5, MessageLite messageLite) {
        writeTag(i5, 3);
        writeGroupNoTag(messageLite);
        writeTag(i5, 4);
    }

    @Deprecated
    public final void writeGroupNoTag(MessageLite messageLite) {
        messageLite.writeTo(this);
    }

    public abstract void writeInt32(int i5, int i6);

    public abstract void writeInt32NoTag(int i5);

    public final void writeInt64(int i5, long j5) {
        writeUInt64(i5, j5);
    }

    public final void writeInt64NoTag(long j5) {
        writeUInt64NoTag(j5);
    }

    @Override // androidx.datastore.preferences.protobuf.ByteOutput
    public abstract void writeLazy(byte[] bArr, int i5, int i6);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void writeMessage(int i5, MessageLite messageLite, Schema schema);

    public abstract void writeMessageNoTag(MessageLite messageLite);

    public abstract void writeMessageSetExtension(int i5, MessageLite messageLite);

    public abstract void writeRawMessageSetExtension(int i5, ByteString byteString);

    public final void writeSFixed32(int i5, int i6) {
        writeFixed32(i5, i6);
    }

    public final void writeSFixed32NoTag(int i5) {
        writeFixed32NoTag(i5);
    }

    public final void writeSFixed64(int i5, long j5) {
        writeFixed64(i5, j5);
    }

    public final void writeSFixed64NoTag(long j5) {
        writeFixed64NoTag(j5);
    }

    public final void writeSInt32(int i5, int i6) {
        writeUInt32(i5, encodeZigZag32(i6));
    }

    public final void writeSInt32NoTag(int i5) {
        writeUInt32NoTag(encodeZigZag32(i5));
    }

    public final void writeSInt64(int i5, long j5) {
        writeUInt64(i5, encodeZigZag64(j5));
    }

    public final void writeSInt64NoTag(long j5) {
        writeUInt64NoTag(encodeZigZag64(j5));
    }

    public abstract void writeString(int i5, String str);

    public abstract void writeStringNoTag(String str);

    public abstract void writeTag(int i5, int i6);

    public abstract void writeUInt32(int i5, int i6);

    public abstract void writeUInt32NoTag(int i5);

    public abstract void writeUInt64(int i5, long j5);

    public abstract void writeUInt64NoTag(long j5);

    /* loaded from: classes.dex */
    private static final class OutputStreamEncoder extends AbstractBufferedEncoder {
        private final OutputStream out;

        OutputStreamEncoder(OutputStream outputStream, int i5) {
            super(i5);
            if (outputStream == null) {
                throw new NullPointerException("out");
            }
            this.out = outputStream;
        }

        private void doFlush() {
            this.out.write(this.buffer, 0, this.position);
            this.position = 0;
        }

        private void flushIfNotAvailable(int i5) {
            if (this.limit - this.position < i5) {
                doFlush();
            }
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public void flush() {
            if (this.position > 0) {
                doFlush();
            }
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public void write(byte b5) {
            if (this.position == this.limit) {
                doFlush();
            }
            buffer(b5);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public void writeBool(int i5, boolean z5) {
            flushIfNotAvailable(11);
            bufferTag(i5, 0);
            buffer(z5 ? (byte) 1 : (byte) 0);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public void writeByteArrayNoTag(byte[] bArr, int i5, int i6) {
            writeUInt32NoTag(i6);
            write(bArr, i5, i6);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public void writeBytes(int i5, ByteString byteString) {
            writeTag(i5, 2);
            writeBytesNoTag(byteString);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public void writeBytesNoTag(ByteString byteString) {
            writeUInt32NoTag(byteString.size());
            byteString.writeTo(this);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public void writeFixed32(int i5, int i6) {
            flushIfNotAvailable(14);
            bufferTag(i5, 5);
            bufferFixed32NoTag(i6);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public void writeFixed32NoTag(int i5) {
            flushIfNotAvailable(4);
            bufferFixed32NoTag(i5);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public void writeFixed64(int i5, long j5) {
            flushIfNotAvailable(18);
            bufferTag(i5, 1);
            bufferFixed64NoTag(j5);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public void writeFixed64NoTag(long j5) {
            flushIfNotAvailable(8);
            bufferFixed64NoTag(j5);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public void writeInt32(int i5, int i6) {
            flushIfNotAvailable(20);
            bufferTag(i5, 0);
            bufferInt32NoTag(i6);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public void writeInt32NoTag(int i5) {
            if (i5 >= 0) {
                writeUInt32NoTag(i5);
            } else {
                writeUInt64NoTag(i5);
            }
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream, androidx.datastore.preferences.protobuf.ByteOutput
        public void writeLazy(byte[] bArr, int i5, int i6) {
            write(bArr, i5, i6);
        }

        public void writeMessage(int i5, MessageLite messageLite) {
            writeTag(i5, 2);
            writeMessageNoTag(messageLite);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public void writeMessageNoTag(MessageLite messageLite) {
            writeUInt32NoTag(messageLite.getSerializedSize());
            messageLite.writeTo(this);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public void writeMessageSetExtension(int i5, MessageLite messageLite) {
            writeTag(1, 3);
            writeUInt32(2, i5);
            writeMessage(3, messageLite);
            writeTag(1, 4);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public void writeRawMessageSetExtension(int i5, ByteString byteString) {
            writeTag(1, 3);
            writeUInt32(2, i5);
            writeBytes(3, byteString);
            writeTag(1, 4);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public void writeString(int i5, String str) {
            writeTag(i5, 2);
            writeStringNoTag(str);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public void writeStringNoTag(String str) {
            int encodedLength;
            try {
                int length = str.length() * 3;
                int computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(length);
                int i5 = computeUInt32SizeNoTag + length;
                int i6 = this.limit;
                if (i5 > i6) {
                    byte[] bArr = new byte[length];
                    int encode = Utf8.encode(str, bArr, 0, length);
                    writeUInt32NoTag(encode);
                    writeLazy(bArr, 0, encode);
                    return;
                }
                if (i5 > i6 - this.position) {
                    doFlush();
                }
                int computeUInt32SizeNoTag2 = CodedOutputStream.computeUInt32SizeNoTag(str.length());
                int i7 = this.position;
                try {
                    if (computeUInt32SizeNoTag2 == computeUInt32SizeNoTag) {
                        int i8 = i7 + computeUInt32SizeNoTag2;
                        this.position = i8;
                        int encode2 = Utf8.encode(str, this.buffer, i8, this.limit - i8);
                        this.position = i7;
                        encodedLength = (encode2 - i7) - computeUInt32SizeNoTag2;
                        bufferUInt32NoTag(encodedLength);
                        this.position = encode2;
                    } else {
                        encodedLength = Utf8.encodedLength(str);
                        bufferUInt32NoTag(encodedLength);
                        this.position = Utf8.encode(str, this.buffer, this.position, encodedLength);
                    }
                    this.totalBytesWritten += encodedLength;
                } catch (Utf8.UnpairedSurrogateException e5) {
                    this.totalBytesWritten -= this.position - i7;
                    this.position = i7;
                    throw e5;
                } catch (ArrayIndexOutOfBoundsException e6) {
                    throw new OutOfSpaceException(e6);
                }
            } catch (Utf8.UnpairedSurrogateException e7) {
                inefficientWriteStringNoTag(str, e7);
            }
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public void writeTag(int i5, int i6) {
            writeUInt32NoTag(WireFormat.makeTag(i5, i6));
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public void writeUInt32(int i5, int i6) {
            flushIfNotAvailable(20);
            bufferTag(i5, 0);
            bufferUInt32NoTag(i6);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public void writeUInt32NoTag(int i5) {
            flushIfNotAvailable(5);
            bufferUInt32NoTag(i5);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public void writeUInt64(int i5, long j5) {
            flushIfNotAvailable(20);
            bufferTag(i5, 0);
            bufferUInt64NoTag(j5);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        public void writeUInt64NoTag(long j5) {
            flushIfNotAvailable(10);
            bufferUInt64NoTag(j5);
        }

        @Override // androidx.datastore.preferences.protobuf.CodedOutputStream
        void writeMessage(int i5, MessageLite messageLite, Schema schema) {
            writeTag(i5, 2);
            writeMessageNoTag(messageLite, schema);
        }

        void writeMessageNoTag(MessageLite messageLite, Schema schema) {
            writeUInt32NoTag(((AbstractMessageLite) messageLite).getSerializedSize(schema));
            schema.writeTo(messageLite, this.wrapper);
        }

        public void write(byte[] bArr, int i5, int i6) {
            int i7 = this.limit;
            int i8 = this.position;
            if (i7 - i8 >= i6) {
                System.arraycopy(bArr, i5, this.buffer, i8, i6);
                this.position += i6;
                this.totalBytesWritten += i6;
                return;
            }
            int i9 = i7 - i8;
            System.arraycopy(bArr, i5, this.buffer, i8, i9);
            int i10 = i5 + i9;
            int i11 = i6 - i9;
            this.position = this.limit;
            this.totalBytesWritten += i9;
            doFlush();
            if (i11 <= this.limit) {
                System.arraycopy(bArr, i10, this.buffer, 0, i11);
                this.position = i11;
            } else {
                this.out.write(bArr, i10, i11);
            }
            this.totalBytesWritten += i11;
        }
    }

    private CodedOutputStream() {
    }

    @Deprecated
    static int computeGroupSizeNoTag(MessageLite messageLite, Schema schema) {
        return ((AbstractMessageLite) messageLite).getSerializedSize(schema);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int computeMessageSizeNoTag(MessageLite messageLite, Schema schema) {
        return computeLengthDelimitedFieldSize(((AbstractMessageLite) messageLite).getSerializedSize(schema));
    }

    @Deprecated
    final void writeGroupNoTag(MessageLite messageLite, Schema schema) {
        schema.writeTo(messageLite, this.wrapper);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Deprecated
    public final void writeGroup(int i5, MessageLite messageLite, Schema schema) {
        writeTag(i5, 3);
        writeGroupNoTag(messageLite, schema);
        writeTag(i5, 4);
    }
}
