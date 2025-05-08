package com.google.firebase.crashlytics.internal.metadata;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.util.NoSuchElementException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class QueueFile implements Closeable {
    private static final int INITIAL_LENGTH = 4096;
    private static final Logger LOGGER = Logger.getLogger(QueueFile.class.getName());
    private final byte[] buffer = new byte[16];
    private int elementCount;
    int fileLength;
    private Element first;
    private Element last;
    private final RandomAccessFile raf;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class Element {
        static final Element NULL = new Element(0, 0);
        final int length;
        final int position;

        Element(int i5, int i6) {
            this.position = i5;
            this.length = i6;
        }

        public String toString() {
            return getClass().getSimpleName() + "[position = " + this.position + ", length = " + this.length + "]";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public final class ElementInputStream extends InputStream {
        private int position;
        private int remaining;

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i5, int i6) {
            QueueFile.nonNull(bArr, "buffer");
            if ((i5 | i6) >= 0 && i6 <= bArr.length - i5) {
                int i7 = this.remaining;
                if (i7 <= 0) {
                    return -1;
                }
                if (i6 > i7) {
                    i6 = i7;
                }
                QueueFile.this.ringRead(this.position, bArr, i5, i6);
                this.position = QueueFile.this.wrapPosition(this.position + i6);
                this.remaining -= i6;
                return i6;
            }
            throw new ArrayIndexOutOfBoundsException();
        }

        private ElementInputStream(Element element) {
            this.position = QueueFile.this.wrapPosition(element.position + 4);
            this.remaining = element.length;
        }

        @Override // java.io.InputStream
        public int read() {
            if (this.remaining == 0) {
                return -1;
            }
            QueueFile.this.raf.seek(this.position);
            int read = QueueFile.this.raf.read();
            this.position = QueueFile.this.wrapPosition(this.position + 1);
            this.remaining--;
            return read;
        }
    }

    /* loaded from: classes2.dex */
    public interface ElementReader {
        void read(InputStream inputStream, int i5);
    }

    public QueueFile(File file) {
        if (!file.exists()) {
            initialize(file);
        }
        this.raf = open(file);
        readHeader();
    }

    private void expandIfNecessary(int i5) {
        int i6 = i5 + 4;
        int remainingBytes = remainingBytes();
        if (remainingBytes >= i6) {
            return;
        }
        int i7 = this.fileLength;
        do {
            remainingBytes += i7;
            i7 <<= 1;
        } while (remainingBytes < i6);
        setLength(i7);
        Element element = this.last;
        int wrapPosition = wrapPosition(element.position + 4 + element.length);
        if (wrapPosition < this.first.position) {
            FileChannel channel = this.raf.getChannel();
            channel.position(this.fileLength);
            long j5 = wrapPosition - 4;
            if (channel.transferTo(16L, j5, channel) != j5) {
                throw new AssertionError("Copied insufficient number of bytes!");
            }
        }
        int i8 = this.last.position;
        int i9 = this.first.position;
        if (i8 < i9) {
            int i10 = (this.fileLength + i8) - 16;
            writeHeader(i7, this.elementCount, i9, i10);
            this.last = new Element(i10, this.last.length);
        } else {
            writeHeader(i7, this.elementCount, i9, i8);
        }
        this.fileLength = i7;
    }

    private static void initialize(File file) {
        File file2 = new File(file.getPath() + ".tmp");
        RandomAccessFile open = open(file2);
        try {
            open.setLength(4096L);
            open.seek(0L);
            byte[] bArr = new byte[16];
            writeInts(bArr, INITIAL_LENGTH, 0, 0, 0);
            open.write(bArr);
            open.close();
            if (!file2.renameTo(file)) {
                throw new IOException("Rename failed!");
            }
        } catch (Throwable th) {
            open.close();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <T> T nonNull(T t5, String str) {
        if (t5 != null) {
            return t5;
        }
        throw new NullPointerException(str);
    }

    private static RandomAccessFile open(File file) {
        return new RandomAccessFile(file, "rwd");
    }

    private Element readElement(int i5) {
        if (i5 == 0) {
            return Element.NULL;
        }
        this.raf.seek(i5);
        return new Element(i5, this.raf.readInt());
    }

    private void readHeader() {
        this.raf.seek(0L);
        this.raf.readFully(this.buffer);
        int readInt = readInt(this.buffer, 0);
        this.fileLength = readInt;
        if (readInt <= this.raf.length()) {
            this.elementCount = readInt(this.buffer, 4);
            int readInt2 = readInt(this.buffer, 8);
            int readInt3 = readInt(this.buffer, 12);
            this.first = readElement(readInt2);
            this.last = readElement(readInt3);
            return;
        }
        throw new IOException("File is truncated. Expected length: " + this.fileLength + ", Actual length: " + this.raf.length());
    }

    private static int readInt(byte[] bArr, int i5) {
        return ((bArr[i5] & 255) << 24) + ((bArr[i5 + 1] & 255) << 16) + ((bArr[i5 + 2] & 255) << 8) + (bArr[i5 + 3] & 255);
    }

    private int remainingBytes() {
        return this.fileLength - usedBytes();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ringRead(int i5, byte[] bArr, int i6, int i7) {
        int wrapPosition = wrapPosition(i5);
        int i8 = wrapPosition + i7;
        int i9 = this.fileLength;
        if (i8 <= i9) {
            this.raf.seek(wrapPosition);
            this.raf.readFully(bArr, i6, i7);
            return;
        }
        int i10 = i9 - wrapPosition;
        this.raf.seek(wrapPosition);
        this.raf.readFully(bArr, i6, i10);
        this.raf.seek(16L);
        this.raf.readFully(bArr, i6 + i10, i7 - i10);
    }

    private void ringWrite(int i5, byte[] bArr, int i6, int i7) {
        int wrapPosition = wrapPosition(i5);
        int i8 = wrapPosition + i7;
        int i9 = this.fileLength;
        if (i8 <= i9) {
            this.raf.seek(wrapPosition);
            this.raf.write(bArr, i6, i7);
            return;
        }
        int i10 = i9 - wrapPosition;
        this.raf.seek(wrapPosition);
        this.raf.write(bArr, i6, i10);
        this.raf.seek(16L);
        this.raf.write(bArr, i6 + i10, i7 - i10);
    }

    private void setLength(int i5) {
        this.raf.setLength(i5);
        this.raf.getChannel().force(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int wrapPosition(int i5) {
        int i6 = this.fileLength;
        return i5 < i6 ? i5 : (i5 + 16) - i6;
    }

    private void writeHeader(int i5, int i6, int i7, int i8) {
        writeInts(this.buffer, i5, i6, i7, i8);
        this.raf.seek(0L);
        this.raf.write(this.buffer);
    }

    private static void writeInt(byte[] bArr, int i5, int i6) {
        bArr[i5] = (byte) (i6 >> 24);
        bArr[i5 + 1] = (byte) (i6 >> 16);
        bArr[i5 + 2] = (byte) (i6 >> 8);
        bArr[i5 + 3] = (byte) i6;
    }

    private static void writeInts(byte[] bArr, int... iArr) {
        int i5 = 0;
        for (int i6 : iArr) {
            writeInt(bArr, i5, i6);
            i5 += 4;
        }
    }

    public void add(byte[] bArr) {
        add(bArr, 0, bArr.length);
    }

    public synchronized void clear() {
        try {
            writeHeader(INITIAL_LENGTH, 0, 0, 0);
            this.elementCount = 0;
            Element element = Element.NULL;
            this.first = element;
            this.last = element;
            if (this.fileLength > INITIAL_LENGTH) {
                setLength(INITIAL_LENGTH);
            }
            this.fileLength = INITIAL_LENGTH;
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        this.raf.close();
    }

    public synchronized void forEach(ElementReader elementReader) {
        int i5 = this.first.position;
        for (int i6 = 0; i6 < this.elementCount; i6++) {
            Element readElement = readElement(i5);
            elementReader.read(new ElementInputStream(readElement), readElement.length);
            i5 = wrapPosition(readElement.position + 4 + readElement.length);
        }
    }

    public synchronized boolean isEmpty() {
        return this.elementCount == 0;
    }

    public synchronized void remove() {
        try {
            if (isEmpty()) {
                throw new NoSuchElementException();
            }
            if (this.elementCount == 1) {
                clear();
            } else {
                Element element = this.first;
                int wrapPosition = wrapPosition(element.position + 4 + element.length);
                ringRead(wrapPosition, this.buffer, 0, 4);
                int readInt = readInt(this.buffer, 0);
                writeHeader(this.fileLength, this.elementCount - 1, wrapPosition, this.last.position);
                this.elementCount--;
                this.first = new Element(wrapPosition, readInt);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append('[');
        sb.append("fileLength=");
        sb.append(this.fileLength);
        sb.append(", size=");
        sb.append(this.elementCount);
        sb.append(", first=");
        sb.append(this.first);
        sb.append(", last=");
        sb.append(this.last);
        sb.append(", element lengths=[");
        try {
            forEach(new ElementReader() { // from class: com.google.firebase.crashlytics.internal.metadata.QueueFile.1
                boolean first = true;

                @Override // com.google.firebase.crashlytics.internal.metadata.QueueFile.ElementReader
                public void read(InputStream inputStream, int i5) {
                    if (this.first) {
                        this.first = false;
                    } else {
                        sb.append(", ");
                    }
                    sb.append(i5);
                }
            });
        } catch (IOException e5) {
            LOGGER.log(Level.WARNING, "read error", (Throwable) e5);
        }
        sb.append("]]");
        return sb.toString();
    }

    public int usedBytes() {
        if (this.elementCount == 0) {
            return 16;
        }
        Element element = this.last;
        int i5 = element.position;
        int i6 = this.first.position;
        return i5 >= i6 ? (i5 - i6) + 4 + element.length + 16 : (((i5 + 4) + element.length) + this.fileLength) - i6;
    }

    public synchronized void add(byte[] bArr, int i5, int i6) {
        int wrapPosition;
        try {
            nonNull(bArr, "buffer");
            if ((i5 | i6) >= 0 && i6 <= bArr.length - i5) {
                expandIfNecessary(i6);
                boolean isEmpty = isEmpty();
                if (isEmpty) {
                    wrapPosition = 16;
                } else {
                    Element element = this.last;
                    wrapPosition = wrapPosition(element.position + 4 + element.length);
                }
                Element element2 = new Element(wrapPosition, i6);
                writeInt(this.buffer, 0, i6);
                ringWrite(element2.position, this.buffer, 0, 4);
                ringWrite(element2.position + 4, bArr, i5, i6);
                writeHeader(this.fileLength, this.elementCount + 1, isEmpty ? element2.position : this.first.position, element2.position);
                this.last = element2;
                this.elementCount++;
                if (isEmpty) {
                    this.first = element2;
                }
            } else {
                throw new IndexOutOfBoundsException();
            }
        } catch (Throwable th) {
            throw th;
        }
    }
}
