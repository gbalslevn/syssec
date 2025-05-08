package com.google.protobuf;

import com.google.protobuf.Utf8;
import com.sun.jna.Function;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes2.dex */
public abstract class CodedOutputStream extends ByteOutput {
    private boolean serializationDeterministic;
    CodedOutputStreamWriter wrapper;
    private static final Logger logger = Logger.getLogger(CodedOutputStream.class.getName());
    private static final boolean HAS_UNSAFE_ARRAY_OPERATIONS = UnsafeUtil.hasUnsafeArrayOperations();

    /* loaded from: classes2.dex */
    public static class OutOfSpaceException extends IOException {
        private static final String MESSAGE = "CodedOutputStream was writing to a flat byte array and ran out of space.";
        private static final long serialVersionUID = -6947486886997889499L;

        OutOfSpaceException() {
            super(MESSAGE);
        }

        OutOfSpaceException(Throwable th) {
            super(MESSAGE, th);
        }

        OutOfSpaceException(String str, Throwable th) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.: " + str, th);
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
        if (i5 >= 0) {
            return computeUInt32SizeNoTag(i5);
        }
        return 10;
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
        if ((i5 & (-128)) == 0) {
            return 1;
        }
        if ((i5 & (-16384)) == 0) {
            return 2;
        }
        if (((-2097152) & i5) == 0) {
            return 3;
        }
        return (i5 & (-268435456)) == 0 ? 4 : 5;
    }

    public static int computeUInt64Size(int i5, long j5) {
        return computeTagSize(i5) + computeUInt64SizeNoTag(j5);
    }

    public static int computeUInt64SizeNoTag(long j5) {
        int i5;
        if (((-128) & j5) == 0) {
            return 1;
        }
        if (j5 < 0) {
            return 10;
        }
        if (((-34359738368L) & j5) != 0) {
            j5 >>>= 28;
            i5 = 6;
        } else {
            i5 = 2;
        }
        if (((-2097152) & j5) != 0) {
            i5 += 2;
            j5 >>>= 14;
        }
        return (j5 & (-16384)) != 0 ? i5 + 1 : i5;
    }

    public static int encodeZigZag32(int i5) {
        return (i5 >> 31) ^ (i5 << 1);
    }

    public static long encodeZigZag64(long j5) {
        return (j5 >> 63) ^ (j5 << 1);
    }

    public static CodedOutputStream newInstance(byte[] bArr) {
        return newInstance(bArr, 0, bArr.length);
    }

    public final void checkNoSpaceLeft() {
        if (spaceLeft() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

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

    public abstract int spaceLeft();

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

    @Override // com.google.protobuf.ByteOutput
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

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class ArrayEncoder extends CodedOutputStream {
        private final byte[] buffer;
        private final int limit;
        private final int offset;
        private int position;

        ArrayEncoder(byte[] bArr, int i5, int i6) {
            super();
            if (bArr == null) {
                throw new NullPointerException("buffer");
            }
            int i7 = i5 + i6;
            if ((i5 | i6 | (bArr.length - i7)) < 0) {
                throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", Integer.valueOf(bArr.length), Integer.valueOf(i5), Integer.valueOf(i6)));
            }
            this.buffer = bArr;
            this.offset = i5;
            this.position = i5;
            this.limit = i7;
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final int spaceLeft() {
            return this.limit - this.position;
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void write(byte b5) {
            try {
                byte[] bArr = this.buffer;
                int i5 = this.position;
                this.position = i5 + 1;
                bArr[i5] = b5;
            } catch (IndexOutOfBoundsException e5) {
                throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.position), Integer.valueOf(this.limit), 1), e5);
            }
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeBool(int i5, boolean z5) {
            writeTag(i5, 0);
            write(z5 ? (byte) 1 : (byte) 0);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeByteArrayNoTag(byte[] bArr, int i5, int i6) {
            writeUInt32NoTag(i6);
            write(bArr, i5, i6);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeBytes(int i5, ByteString byteString) {
            writeTag(i5, 2);
            writeBytesNoTag(byteString);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeBytesNoTag(ByteString byteString) {
            writeUInt32NoTag(byteString.size());
            byteString.writeTo(this);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeFixed32(int i5, int i6) {
            writeTag(i5, 5);
            writeFixed32NoTag(i6);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeFixed32NoTag(int i5) {
            try {
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
            } catch (IndexOutOfBoundsException e5) {
                throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.position), Integer.valueOf(this.limit), 1), e5);
            }
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeFixed64(int i5, long j5) {
            writeTag(i5, 1);
            writeFixed64NoTag(j5);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeFixed64NoTag(long j5) {
            try {
                byte[] bArr = this.buffer;
                int i5 = this.position;
                int i6 = i5 + 1;
                this.position = i6;
                bArr[i5] = (byte) (((int) j5) & Function.USE_VARARGS);
                int i7 = i5 + 2;
                this.position = i7;
                bArr[i6] = (byte) (((int) (j5 >> 8)) & Function.USE_VARARGS);
                int i8 = i5 + 3;
                this.position = i8;
                bArr[i7] = (byte) (((int) (j5 >> 16)) & Function.USE_VARARGS);
                int i9 = i5 + 4;
                this.position = i9;
                bArr[i8] = (byte) (((int) (j5 >> 24)) & Function.USE_VARARGS);
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
            } catch (IndexOutOfBoundsException e5) {
                throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.position), Integer.valueOf(this.limit), 1), e5);
            }
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeInt32(int i5, int i6) {
            writeTag(i5, 0);
            writeInt32NoTag(i6);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeInt32NoTag(int i5) {
            if (i5 >= 0) {
                writeUInt32NoTag(i5);
            } else {
                writeUInt64NoTag(i5);
            }
        }

        @Override // com.google.protobuf.CodedOutputStream, com.google.protobuf.ByteOutput
        public final void writeLazy(byte[] bArr, int i5, int i6) {
            write(bArr, i5, i6);
        }

        public final void writeMessage(int i5, MessageLite messageLite) {
            writeTag(i5, 2);
            writeMessageNoTag(messageLite);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeMessageNoTag(MessageLite messageLite) {
            writeUInt32NoTag(messageLite.getSerializedSize());
            messageLite.writeTo(this);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeMessageSetExtension(int i5, MessageLite messageLite) {
            writeTag(1, 3);
            writeUInt32(2, i5);
            writeMessage(3, messageLite);
            writeTag(1, 4);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeRawMessageSetExtension(int i5, ByteString byteString) {
            writeTag(1, 3);
            writeUInt32(2, i5);
            writeBytes(3, byteString);
            writeTag(1, 4);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeString(int i5, String str) {
            writeTag(i5, 2);
            writeStringNoTag(str);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeStringNoTag(String str) {
            int i5 = this.position;
            try {
                int computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(str.length() * 3);
                int computeUInt32SizeNoTag2 = CodedOutputStream.computeUInt32SizeNoTag(str.length());
                if (computeUInt32SizeNoTag2 == computeUInt32SizeNoTag) {
                    int i6 = i5 + computeUInt32SizeNoTag2;
                    this.position = i6;
                    int encode = Utf8.encode(str, this.buffer, i6, spaceLeft());
                    this.position = i5;
                    writeUInt32NoTag((encode - i5) - computeUInt32SizeNoTag2);
                    this.position = encode;
                } else {
                    writeUInt32NoTag(Utf8.encodedLength(str));
                    this.position = Utf8.encode(str, this.buffer, this.position, spaceLeft());
                }
            } catch (Utf8.UnpairedSurrogateException e5) {
                this.position = i5;
                inefficientWriteStringNoTag(str, e5);
            } catch (IndexOutOfBoundsException e6) {
                throw new OutOfSpaceException(e6);
            }
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeTag(int i5, int i6) {
            writeUInt32NoTag(WireFormat.makeTag(i5, i6));
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeUInt32(int i5, int i6) {
            writeTag(i5, 0);
            writeUInt32NoTag(i6);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeUInt32NoTag(int i5) {
            while ((i5 & (-128)) != 0) {
                try {
                    byte[] bArr = this.buffer;
                    int i6 = this.position;
                    this.position = i6 + 1;
                    bArr[i6] = (byte) ((i5 & 127) | 128);
                    i5 >>>= 7;
                } catch (IndexOutOfBoundsException e5) {
                    throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.position), Integer.valueOf(this.limit), 1), e5);
                }
            }
            byte[] bArr2 = this.buffer;
            int i7 = this.position;
            this.position = i7 + 1;
            bArr2[i7] = (byte) i5;
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeUInt64(int i5, long j5) {
            writeTag(i5, 0);
            writeUInt64NoTag(j5);
        }

        @Override // com.google.protobuf.CodedOutputStream
        public final void writeUInt64NoTag(long j5) {
            if (CodedOutputStream.HAS_UNSAFE_ARRAY_OPERATIONS && spaceLeft() >= 10) {
                while ((j5 & (-128)) != 0) {
                    byte[] bArr = this.buffer;
                    int i5 = this.position;
                    this.position = i5 + 1;
                    UnsafeUtil.putByte(bArr, i5, (byte) ((((int) j5) & 127) | 128));
                    j5 >>>= 7;
                }
                byte[] bArr2 = this.buffer;
                int i6 = this.position;
                this.position = i6 + 1;
                UnsafeUtil.putByte(bArr2, i6, (byte) j5);
                return;
            }
            while ((j5 & (-128)) != 0) {
                try {
                    byte[] bArr3 = this.buffer;
                    int i7 = this.position;
                    this.position = i7 + 1;
                    bArr3[i7] = (byte) ((((int) j5) & 127) | 128);
                    j5 >>>= 7;
                } catch (IndexOutOfBoundsException e5) {
                    throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.position), Integer.valueOf(this.limit), 1), e5);
                }
            }
            byte[] bArr4 = this.buffer;
            int i8 = this.position;
            this.position = i8 + 1;
            bArr4[i8] = (byte) j5;
        }

        @Override // com.google.protobuf.CodedOutputStream
        final void writeMessage(int i5, MessageLite messageLite, Schema schema) {
            writeTag(i5, 2);
            writeUInt32NoTag(((AbstractMessageLite) messageLite).getSerializedSize(schema));
            schema.writeTo(messageLite, this.wrapper);
        }

        public final void write(byte[] bArr, int i5, int i6) {
            try {
                System.arraycopy(bArr, i5, this.buffer, this.position, i6);
                this.position += i6;
            } catch (IndexOutOfBoundsException e5) {
                throw new OutOfSpaceException(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.position), Integer.valueOf(this.limit), Integer.valueOf(i6)), e5);
            }
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

    public static CodedOutputStream newInstance(byte[] bArr, int i5, int i6) {
        return new ArrayEncoder(bArr, i5, i6);
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
