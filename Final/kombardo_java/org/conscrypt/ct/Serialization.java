package org.conscrypt.ct;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class Serialization {
    private static final int DER_LENGTH_LONG_FORM_FLAG = 128;
    private static final int DER_TAG_MASK = 63;
    private static final int DER_TAG_OCTET_STRING = 4;

    private Serialization() {
    }

    public static byte readByte(InputStream inputStream) {
        try {
            int read = inputStream.read();
            if (read != -1) {
                return (byte) read;
            }
            throw new SerializationException("Premature end of input, could not read byte.");
        } catch (IOException e5) {
            throw new SerializationException(e5);
        }
    }

    public static byte[] readDEROctetString(byte[] bArr) {
        return readDEROctetString(new ByteArrayInputStream(bArr));
    }

    public static byte[] readFixedBytes(InputStream inputStream, int i5) {
        try {
            if (i5 < 0) {
                throw new SerializationException("Negative length: " + i5);
            }
            byte[] bArr = new byte[i5];
            int read = inputStream.read(bArr);
            if (read >= i5) {
                return bArr;
            }
            throw new SerializationException("Premature end of input, expected " + i5 + " bytes, only read " + read);
        } catch (IOException e5) {
            throw new SerializationException(e5);
        }
    }

    public static byte[][] readList(byte[] bArr, int i5, int i6) {
        return readList(new ByteArrayInputStream(bArr), i5, i6);
    }

    public static long readLong(InputStream inputStream, int i5) {
        if (i5 > 8 || i5 < 0) {
            throw new IllegalArgumentException("Invalid width: " + i5);
        }
        long j5 = 0;
        for (int i6 = 0; i6 < i5; i6++) {
            j5 = (j5 << 8) | (readByte(inputStream) & 255);
        }
        return j5;
    }

    public static int readNumber(InputStream inputStream, int i5) {
        if (i5 > 4 || i5 < 0) {
            throw new SerializationException("Invalid width: " + i5);
        }
        int i6 = 0;
        for (int i7 = 0; i7 < i5; i7++) {
            i6 = (i6 << 8) | (readByte(inputStream) & 255);
        }
        return i6;
    }

    public static byte[] readVariableBytes(InputStream inputStream, int i5) {
        return readFixedBytes(inputStream, readNumber(inputStream, i5));
    }

    public static void writeFixedBytes(OutputStream outputStream, byte[] bArr) {
        try {
            outputStream.write(bArr);
        } catch (IOException e5) {
            throw new SerializationException(e5);
        }
    }

    public static void writeNumber(OutputStream outputStream, long j5, int i5) {
        if (i5 < 0) {
            throw new SerializationException("Negative width: " + i5);
        }
        if (i5 < 8 && j5 >= (1 << (i5 * 8))) {
            throw new SerializationException("Number too large, " + j5 + " does not fit in " + i5 + " bytes");
        }
        while (i5 > 0) {
            if ((i5 - 1) * 8 < 64) {
                try {
                    outputStream.write((byte) ((j5 >> ((int) r0)) & 255));
                } catch (IOException e5) {
                    throw new SerializationException(e5);
                }
            } else {
                outputStream.write(0);
            }
            i5--;
        }
    }

    public static void writeVariableBytes(OutputStream outputStream, byte[] bArr, int i5) {
        writeNumber(outputStream, bArr.length, i5);
        writeFixedBytes(outputStream, bArr);
    }

    public static byte[] readDEROctetString(InputStream inputStream) {
        int readByte = readByte(inputStream) & 63;
        if (readByte == 4) {
            int readNumber = readNumber(inputStream, 1);
            if ((readNumber & 128) != 0) {
                readNumber = readNumber(inputStream, readNumber & (-129));
            }
            return readFixedBytes(inputStream, readNumber);
        }
        throw new SerializationException("Wrong DER tag, expected OCTET STRING, got " + readByte);
    }

    public static byte[][] readList(InputStream inputStream, int i5, int i6) {
        ArrayList arrayList = new ArrayList();
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(readVariableBytes(inputStream, i5));
        while (byteArrayInputStream.available() > 0) {
            try {
                arrayList.add(readVariableBytes(byteArrayInputStream, i6));
            } catch (IOException e5) {
                throw new SerializationException(e5);
            }
        }
        return (byte[][]) arrayList.toArray(new byte[arrayList.size()]);
    }
}
