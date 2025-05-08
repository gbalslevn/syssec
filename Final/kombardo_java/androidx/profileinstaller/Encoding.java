package androidx.profileinstaller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.FileLock;
import java.nio.charset.StandardCharsets;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.Inflater;

/* loaded from: classes.dex */
abstract class Encoding {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static int bitsToBytes(int i5) {
        return ((i5 + 7) & (-8)) / 8;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte[] compress(byte[] bArr) {
        Deflater deflater = new Deflater(1);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            DeflaterOutputStream deflaterOutputStream = new DeflaterOutputStream(byteArrayOutputStream, deflater);
            try {
                deflaterOutputStream.write(bArr);
                deflaterOutputStream.close();
                deflater.end();
                return byteArrayOutputStream.toByteArray();
            } finally {
            }
        } catch (Throwable th) {
            deflater.end();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static RuntimeException error(String str) {
        return new IllegalStateException(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte[] read(InputStream inputStream, int i5) {
        byte[] bArr = new byte[i5];
        int i6 = 0;
        while (i6 < i5) {
            int read = inputStream.read(bArr, i6, i5 - i6);
            if (read < 0) {
                throw error("Not enough bytes to read: " + i5);
            }
            i6 += read;
        }
        return bArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x005b, code lost:
    
        if (r0.finished() == false) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0060, code lost:
    
        return r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0067, code lost:
    
        throw error("Inflater did not finish");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static byte[] readCompressed(InputStream inputStream, int i5, int i6) {
        Inflater inflater = new Inflater();
        try {
            byte[] bArr = new byte[i6];
            byte[] bArr2 = new byte[2048];
            int i7 = 0;
            int i8 = 0;
            while (!inflater.finished() && !inflater.needsDictionary() && i7 < i5) {
                int read = inputStream.read(bArr2);
                if (read < 0) {
                    throw error("Invalid zip data. Stream ended after $totalBytesRead bytes. Expected " + i5 + " bytes");
                }
                inflater.setInput(bArr2, 0, read);
                try {
                    i8 += inflater.inflate(bArr, i8, i6 - i8);
                    i7 += read;
                } catch (DataFormatException e5) {
                    throw error(e5.getMessage());
                }
            }
            throw error("Didn't read enough bytes during decompression. expected=" + i5 + " actual=" + i7);
        } finally {
            inflater.end();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String readString(InputStream inputStream, int i5) {
        return new String(read(inputStream, i5), StandardCharsets.UTF_8);
    }

    static long readUInt(InputStream inputStream, int i5) {
        byte[] read = read(inputStream, i5);
        long j5 = 0;
        for (int i6 = 0; i6 < i5; i6++) {
            j5 += (read[i6] & 255) << (i6 * 8);
        }
        return j5;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int readUInt16(InputStream inputStream) {
        return (int) readUInt(inputStream, 2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long readUInt32(InputStream inputStream) {
        return readUInt(inputStream, 4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int readUInt8(InputStream inputStream) {
        return (int) readUInt(inputStream, 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int utf8Length(String str) {
        return str.getBytes(StandardCharsets.UTF_8).length;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void writeAll(InputStream inputStream, OutputStream outputStream, FileLock fileLock) {
        if (fileLock == null || !fileLock.isValid()) {
            throw new IOException("Unable to acquire a lock on the underlying file channel.");
        }
        byte[] bArr = new byte[512];
        while (true) {
            int read = inputStream.read(bArr);
            if (read <= 0) {
                return;
            } else {
                outputStream.write(bArr, 0, read);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void writeCompressed(OutputStream outputStream, byte[] bArr) {
        writeUInt32(outputStream, bArr.length);
        byte[] compress = compress(bArr);
        writeUInt32(outputStream, compress.length);
        outputStream.write(compress);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void writeString(OutputStream outputStream, String str) {
        outputStream.write(str.getBytes(StandardCharsets.UTF_8));
    }

    static void writeUInt(OutputStream outputStream, long j5, int i5) {
        byte[] bArr = new byte[i5];
        for (int i6 = 0; i6 < i5; i6++) {
            bArr[i6] = (byte) ((j5 >> (i6 * 8)) & 255);
        }
        outputStream.write(bArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void writeUInt16(OutputStream outputStream, int i5) {
        writeUInt(outputStream, i5, 2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void writeUInt32(OutputStream outputStream, long j5) {
        writeUInt(outputStream, j5, 4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void writeUInt8(OutputStream outputStream, int i5) {
        writeUInt(outputStream, i5, 1);
    }
}
