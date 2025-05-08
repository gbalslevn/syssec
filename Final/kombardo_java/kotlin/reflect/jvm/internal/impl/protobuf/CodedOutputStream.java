package kotlin.reflect.jvm.internal.impl.protobuf;

import com.adjust.sdk.Constants;
import com.sun.jna.Function;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

/* loaded from: classes3.dex */
public final class CodedOutputStream {
    private final byte[] buffer;
    private final int limit;
    private final OutputStream output;
    private int totalBytesWritten = 0;
    private int position = 0;

    /* loaded from: classes3.dex */
    public static class OutOfSpaceException extends IOException {
        OutOfSpaceException() {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.");
        }
    }

    private CodedOutputStream(OutputStream outputStream, byte[] bArr) {
        this.output = outputStream;
        this.buffer = bArr;
        this.limit = bArr.length;
    }

    public static int computeBoolSize(int i5, boolean z5) {
        return computeTagSize(i5) + computeBoolSizeNoTag(z5);
    }

    public static int computeBoolSizeNoTag(boolean z5) {
        return 1;
    }

    public static int computeByteArraySizeNoTag(byte[] bArr) {
        return computeRawVarint32Size(bArr.length) + bArr.length;
    }

    public static int computeBytesSize(int i5, ByteString byteString) {
        return computeTagSize(i5) + computeBytesSizeNoTag(byteString);
    }

    public static int computeBytesSizeNoTag(ByteString byteString) {
        return computeRawVarint32Size(byteString.size()) + byteString.size();
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

    public static int computeFixed32SizeNoTag(int i5) {
        return 4;
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

    public static int computeGroupSizeNoTag(MessageLite messageLite) {
        return messageLite.getSerializedSize();
    }

    public static int computeInt32Size(int i5, int i6) {
        return computeTagSize(i5) + computeInt32SizeNoTag(i6);
    }

    public static int computeInt32SizeNoTag(int i5) {
        if (i5 >= 0) {
            return computeRawVarint32Size(i5);
        }
        return 10;
    }

    public static int computeInt64SizeNoTag(long j5) {
        return computeRawVarint64Size(j5);
    }

    public static int computeMessageSize(int i5, MessageLite messageLite) {
        return computeTagSize(i5) + computeMessageSizeNoTag(messageLite);
    }

    public static int computeMessageSizeNoTag(MessageLite messageLite) {
        int serializedSize = messageLite.getSerializedSize();
        return computeRawVarint32Size(serializedSize) + serializedSize;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int computePreferredBufferSize(int i5) {
        if (i5 > 4096) {
            return 4096;
        }
        return i5;
    }

    public static int computeRawVarint32Size(int i5) {
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

    public static int computeRawVarint64Size(long j5) {
        if (((-128) & j5) == 0) {
            return 1;
        }
        if (((-16384) & j5) == 0) {
            return 2;
        }
        if (((-2097152) & j5) == 0) {
            return 3;
        }
        if (((-268435456) & j5) == 0) {
            return 4;
        }
        if (((-34359738368L) & j5) == 0) {
            return 5;
        }
        if (((-4398046511104L) & j5) == 0) {
            return 6;
        }
        if (((-562949953421312L) & j5) == 0) {
            return 7;
        }
        if (((-72057594037927936L) & j5) == 0) {
            return 8;
        }
        return (j5 & Long.MIN_VALUE) == 0 ? 9 : 10;
    }

    public static int computeSFixed32SizeNoTag(int i5) {
        return 4;
    }

    public static int computeSFixed64SizeNoTag(long j5) {
        return 8;
    }

    public static int computeSInt32SizeNoTag(int i5) {
        return computeRawVarint32Size(encodeZigZag32(i5));
    }

    public static int computeSInt64Size(int i5, long j5) {
        return computeTagSize(i5) + computeSInt64SizeNoTag(j5);
    }

    public static int computeSInt64SizeNoTag(long j5) {
        return computeRawVarint64Size(encodeZigZag64(j5));
    }

    public static int computeStringSizeNoTag(String str) {
        try {
            byte[] bytes = str.getBytes(Constants.ENCODING);
            return computeRawVarint32Size(bytes.length) + bytes.length;
        } catch (UnsupportedEncodingException e5) {
            throw new RuntimeException("UTF-8 not supported.", e5);
        }
    }

    public static int computeTagSize(int i5) {
        return computeRawVarint32Size(WireFormat.makeTag(i5, 0));
    }

    public static int computeUInt32SizeNoTag(int i5) {
        return computeRawVarint32Size(i5);
    }

    public static int computeUInt64SizeNoTag(long j5) {
        return computeRawVarint64Size(j5);
    }

    public static int encodeZigZag32(int i5) {
        return (i5 >> 31) ^ (i5 << 1);
    }

    public static long encodeZigZag64(long j5) {
        return (j5 >> 63) ^ (j5 << 1);
    }

    public static CodedOutputStream newInstance(OutputStream outputStream, int i5) {
        return new CodedOutputStream(outputStream, new byte[i5]);
    }

    private void refreshBuffer() {
        OutputStream outputStream = this.output;
        if (outputStream == null) {
            throw new OutOfSpaceException();
        }
        outputStream.write(this.buffer, 0, this.position);
        this.position = 0;
    }

    public void flush() {
        if (this.output != null) {
            refreshBuffer();
        }
    }

    public void writeBool(int i5, boolean z5) {
        writeTag(i5, 0);
        writeBoolNoTag(z5);
    }

    public void writeBoolNoTag(boolean z5) {
        writeRawByte(z5 ? 1 : 0);
    }

    public void writeByteArrayNoTag(byte[] bArr) {
        writeRawVarint32(bArr.length);
        writeRawBytes(bArr);
    }

    public void writeBytes(int i5, ByteString byteString) {
        writeTag(i5, 2);
        writeBytesNoTag(byteString);
    }

    public void writeBytesNoTag(ByteString byteString) {
        writeRawVarint32(byteString.size());
        writeRawBytes(byteString);
    }

    public void writeDouble(int i5, double d5) {
        writeTag(i5, 1);
        writeDoubleNoTag(d5);
    }

    public void writeDoubleNoTag(double d5) {
        writeRawLittleEndian64(Double.doubleToRawLongBits(d5));
    }

    public void writeEnum(int i5, int i6) {
        writeTag(i5, 0);
        writeEnumNoTag(i6);
    }

    public void writeEnumNoTag(int i5) {
        writeInt32NoTag(i5);
    }

    public void writeFixed32NoTag(int i5) {
        writeRawLittleEndian32(i5);
    }

    public void writeFixed64NoTag(long j5) {
        writeRawLittleEndian64(j5);
    }

    public void writeFloat(int i5, float f5) {
        writeTag(i5, 5);
        writeFloatNoTag(f5);
    }

    public void writeFloatNoTag(float f5) {
        writeRawLittleEndian32(Float.floatToRawIntBits(f5));
    }

    public void writeGroup(int i5, MessageLite messageLite) {
        writeTag(i5, 3);
        writeGroupNoTag(messageLite);
        writeTag(i5, 4);
    }

    public void writeGroupNoTag(MessageLite messageLite) {
        messageLite.writeTo(this);
    }

    public void writeInt32(int i5, int i6) {
        writeTag(i5, 0);
        writeInt32NoTag(i6);
    }

    public void writeInt32NoTag(int i5) {
        if (i5 >= 0) {
            writeRawVarint32(i5);
        } else {
            writeRawVarint64(i5);
        }
    }

    public void writeInt64NoTag(long j5) {
        writeRawVarint64(j5);
    }

    public void writeMessage(int i5, MessageLite messageLite) {
        writeTag(i5, 2);
        writeMessageNoTag(messageLite);
    }

    public void writeMessageNoTag(MessageLite messageLite) {
        writeRawVarint32(messageLite.getSerializedSize());
        messageLite.writeTo(this);
    }

    public void writeMessageSetExtension(int i5, MessageLite messageLite) {
        writeTag(1, 3);
        writeUInt32(2, i5);
        writeMessage(3, messageLite);
        writeTag(1, 4);
    }

    public void writeRawByte(byte b5) {
        if (this.position == this.limit) {
            refreshBuffer();
        }
        byte[] bArr = this.buffer;
        int i5 = this.position;
        this.position = i5 + 1;
        bArr[i5] = b5;
        this.totalBytesWritten++;
    }

    public void writeRawBytes(ByteString byteString) {
        writeRawBytes(byteString, 0, byteString.size());
    }

    public void writeRawLittleEndian32(int i5) {
        writeRawByte(i5 & Function.USE_VARARGS);
        writeRawByte((i5 >> 8) & Function.USE_VARARGS);
        writeRawByte((i5 >> 16) & Function.USE_VARARGS);
        writeRawByte((i5 >> 24) & Function.USE_VARARGS);
    }

    public void writeRawLittleEndian64(long j5) {
        writeRawByte(((int) j5) & Function.USE_VARARGS);
        writeRawByte(((int) (j5 >> 8)) & Function.USE_VARARGS);
        writeRawByte(((int) (j5 >> 16)) & Function.USE_VARARGS);
        writeRawByte(((int) (j5 >> 24)) & Function.USE_VARARGS);
        writeRawByte(((int) (j5 >> 32)) & Function.USE_VARARGS);
        writeRawByte(((int) (j5 >> 40)) & Function.USE_VARARGS);
        writeRawByte(((int) (j5 >> 48)) & Function.USE_VARARGS);
        writeRawByte(((int) (j5 >> 56)) & Function.USE_VARARGS);
    }

    public void writeRawVarint32(int i5) {
        while ((i5 & (-128)) != 0) {
            writeRawByte((i5 & 127) | 128);
            i5 >>>= 7;
        }
        writeRawByte(i5);
    }

    public void writeRawVarint64(long j5) {
        while (((-128) & j5) != 0) {
            writeRawByte((((int) j5) & 127) | 128);
            j5 >>>= 7;
        }
        writeRawByte((int) j5);
    }

    public void writeSFixed32NoTag(int i5) {
        writeRawLittleEndian32(i5);
    }

    public void writeSFixed64NoTag(long j5) {
        writeRawLittleEndian64(j5);
    }

    public void writeSInt32NoTag(int i5) {
        writeRawVarint32(encodeZigZag32(i5));
    }

    public void writeSInt64(int i5, long j5) {
        writeTag(i5, 0);
        writeSInt64NoTag(j5);
    }

    public void writeSInt64NoTag(long j5) {
        writeRawVarint64(encodeZigZag64(j5));
    }

    public void writeStringNoTag(String str) {
        byte[] bytes = str.getBytes(Constants.ENCODING);
        writeRawVarint32(bytes.length);
        writeRawBytes(bytes);
    }

    public void writeTag(int i5, int i6) {
        writeRawVarint32(WireFormat.makeTag(i5, i6));
    }

    public void writeUInt32(int i5, int i6) {
        writeTag(i5, 0);
        writeUInt32NoTag(i6);
    }

    public void writeUInt32NoTag(int i5) {
        writeRawVarint32(i5);
    }

    public void writeUInt64NoTag(long j5) {
        writeRawVarint64(j5);
    }

    public void writeRawBytes(byte[] bArr) {
        writeRawBytes(bArr, 0, bArr.length);
    }

    public void writeRawBytes(byte[] bArr, int i5, int i6) {
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
        refreshBuffer();
        if (i11 <= this.limit) {
            System.arraycopy(bArr, i10, this.buffer, 0, i11);
            this.position = i11;
        } else {
            this.output.write(bArr, i10, i11);
        }
        this.totalBytesWritten += i11;
    }

    public void writeRawByte(int i5) {
        writeRawByte((byte) i5);
    }

    public void writeRawBytes(ByteString byteString, int i5, int i6) {
        int i7 = this.limit;
        int i8 = this.position;
        if (i7 - i8 >= i6) {
            byteString.copyTo(this.buffer, i5, i8, i6);
            this.position += i6;
            this.totalBytesWritten += i6;
            return;
        }
        int i9 = i7 - i8;
        byteString.copyTo(this.buffer, i5, i8, i9);
        int i10 = i5 + i9;
        int i11 = i6 - i9;
        this.position = this.limit;
        this.totalBytesWritten += i9;
        refreshBuffer();
        if (i11 <= this.limit) {
            byteString.copyTo(this.buffer, i10, 0, i11);
            this.position = i11;
        } else {
            byteString.writeTo(this.output, i10, i11);
        }
        this.totalBytesWritten += i11;
    }
}
