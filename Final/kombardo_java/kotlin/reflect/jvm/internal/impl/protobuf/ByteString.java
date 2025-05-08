package kotlin.reflect.jvm.internal.impl.protobuf;

import com.adjust.sdk.Constants;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/* loaded from: classes3.dex */
public abstract class ByteString implements Iterable<Byte> {
    public static final ByteString EMPTY = new LiteralByteString(new byte[0]);

    /* loaded from: classes3.dex */
    public interface ByteIterator extends Iterator<Byte> {
        byte nextByte();
    }

    private static ByteString balancedConcat(Iterator<ByteString> it, int i5) {
        if (i5 == 1) {
            return it.next();
        }
        int i6 = i5 >>> 1;
        return balancedConcat(it, i6).concat(balancedConcat(it, i5 - i6));
    }

    public static ByteString copyFrom(byte[] bArr, int i5, int i6) {
        byte[] bArr2 = new byte[i6];
        System.arraycopy(bArr, i5, bArr2, 0, i6);
        return new LiteralByteString(bArr2);
    }

    public static ByteString copyFromUtf8(String str) {
        try {
            return new LiteralByteString(str.getBytes(Constants.ENCODING));
        } catch (UnsupportedEncodingException e5) {
            throw new RuntimeException("UTF-8 not supported?", e5);
        }
    }

    public static Output newOutput() {
        return new Output(128);
    }

    public ByteString concat(ByteString byteString) {
        int size = size();
        int size2 = byteString.size();
        if (size + size2 < 2147483647L) {
            return RopeByteString.concatenate(this, byteString);
        }
        StringBuilder sb = new StringBuilder(53);
        sb.append("ByteString would be too long: ");
        sb.append(size);
        sb.append("+");
        sb.append(size2);
        throw new IllegalArgumentException(sb.toString());
    }

    public void copyTo(byte[] bArr, int i5, int i6, int i7) {
        if (i5 < 0) {
            StringBuilder sb = new StringBuilder(30);
            sb.append("Source offset < 0: ");
            sb.append(i5);
            throw new IndexOutOfBoundsException(sb.toString());
        }
        if (i6 < 0) {
            StringBuilder sb2 = new StringBuilder(30);
            sb2.append("Target offset < 0: ");
            sb2.append(i6);
            throw new IndexOutOfBoundsException(sb2.toString());
        }
        if (i7 < 0) {
            StringBuilder sb3 = new StringBuilder(23);
            sb3.append("Length < 0: ");
            sb3.append(i7);
            throw new IndexOutOfBoundsException(sb3.toString());
        }
        int i8 = i5 + i7;
        if (i8 > size()) {
            StringBuilder sb4 = new StringBuilder(34);
            sb4.append("Source end offset < 0: ");
            sb4.append(i8);
            throw new IndexOutOfBoundsException(sb4.toString());
        }
        int i9 = i6 + i7;
        if (i9 <= bArr.length) {
            if (i7 > 0) {
                copyToInternal(bArr, i5, i6, i7);
            }
        } else {
            StringBuilder sb5 = new StringBuilder(34);
            sb5.append("Target end offset < 0: ");
            sb5.append(i9);
            throw new IndexOutOfBoundsException(sb5.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void copyToInternal(byte[] bArr, int i5, int i6, int i7);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract int getTreeDepth();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract boolean isBalanced();

    public boolean isEmpty() {
        return size() == 0;
    }

    public abstract boolean isValidUtf8();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract int partialHash(int i5, int i6, int i7);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract int partialIsValidUtf8(int i5, int i6, int i7);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract int peekCachedHashCode();

    public abstract int size();

    public byte[] toByteArray() {
        int size = size();
        if (size == 0) {
            return Internal.EMPTY_BYTE_ARRAY;
        }
        byte[] bArr = new byte[size];
        copyToInternal(bArr, 0, 0, size);
        return bArr;
    }

    public String toString() {
        return String.format("<ByteString@%s size=%d>", Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(size()));
    }

    public abstract String toString(String str);

    public String toStringUtf8() {
        try {
            return toString(Constants.ENCODING);
        } catch (UnsupportedEncodingException e5) {
            throw new RuntimeException("UTF-8 not supported?", e5);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void writeTo(OutputStream outputStream, int i5, int i6) {
        if (i5 < 0) {
            StringBuilder sb = new StringBuilder(30);
            sb.append("Source offset < 0: ");
            sb.append(i5);
            throw new IndexOutOfBoundsException(sb.toString());
        }
        if (i6 < 0) {
            StringBuilder sb2 = new StringBuilder(23);
            sb2.append("Length < 0: ");
            sb2.append(i6);
            throw new IndexOutOfBoundsException(sb2.toString());
        }
        int i7 = i5 + i6;
        if (i7 <= size()) {
            if (i6 > 0) {
                writeToInternal(outputStream, i5, i6);
            }
        } else {
            StringBuilder sb3 = new StringBuilder(39);
            sb3.append("Source end offset exceeded: ");
            sb3.append(i7);
            throw new IndexOutOfBoundsException(sb3.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void writeToInternal(OutputStream outputStream, int i5, int i6);

    /* loaded from: classes3.dex */
    public static final class Output extends OutputStream {
        private static final byte[] EMPTY_BYTE_ARRAY = new byte[0];
        private byte[] buffer;
        private int bufferPos;
        private final ArrayList<ByteString> flushedBuffers;
        private int flushedBuffersTotalBytes;
        private final int initialCapacity;

        Output(int i5) {
            if (i5 < 0) {
                throw new IllegalArgumentException("Buffer size < 0");
            }
            this.initialCapacity = i5;
            this.flushedBuffers = new ArrayList<>();
            this.buffer = new byte[i5];
        }

        private byte[] copyArray(byte[] bArr, int i5) {
            byte[] bArr2 = new byte[i5];
            System.arraycopy(bArr, 0, bArr2, 0, Math.min(bArr.length, i5));
            return bArr2;
        }

        private void flushFullBuffer(int i5) {
            this.flushedBuffers.add(new LiteralByteString(this.buffer));
            int length = this.flushedBuffersTotalBytes + this.buffer.length;
            this.flushedBuffersTotalBytes = length;
            this.buffer = new byte[Math.max(this.initialCapacity, Math.max(i5, length >>> 1))];
            this.bufferPos = 0;
        }

        private void flushLastBuffer() {
            int i5 = this.bufferPos;
            byte[] bArr = this.buffer;
            if (i5 >= bArr.length) {
                this.flushedBuffers.add(new LiteralByteString(this.buffer));
                this.buffer = EMPTY_BYTE_ARRAY;
            } else if (i5 > 0) {
                this.flushedBuffers.add(new LiteralByteString(copyArray(bArr, i5)));
            }
            this.flushedBuffersTotalBytes += this.bufferPos;
            this.bufferPos = 0;
        }

        public synchronized int size() {
            return this.flushedBuffersTotalBytes + this.bufferPos;
        }

        public synchronized ByteString toByteString() {
            flushLastBuffer();
            return ByteString.copyFrom(this.flushedBuffers);
        }

        public String toString() {
            return String.format("<ByteString.Output@%s size=%d>", Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(size()));
        }

        @Override // java.io.OutputStream
        public synchronized void write(int i5) {
            try {
                if (this.bufferPos == this.buffer.length) {
                    flushFullBuffer(1);
                }
                byte[] bArr = this.buffer;
                int i6 = this.bufferPos;
                this.bufferPos = i6 + 1;
                bArr[i6] = (byte) i5;
            } catch (Throwable th) {
                throw th;
            }
        }

        @Override // java.io.OutputStream
        public synchronized void write(byte[] bArr, int i5, int i6) {
            try {
                byte[] bArr2 = this.buffer;
                int length = bArr2.length;
                int i7 = this.bufferPos;
                if (i6 <= length - i7) {
                    System.arraycopy(bArr, i5, bArr2, i7, i6);
                    this.bufferPos += i6;
                } else {
                    int length2 = bArr2.length - i7;
                    System.arraycopy(bArr, i5, bArr2, i7, length2);
                    int i8 = i6 - length2;
                    flushFullBuffer(i8);
                    System.arraycopy(bArr, i5 + length2, this.buffer, 0, i8);
                    this.bufferPos = i8;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static ByteString copyFrom(byte[] bArr) {
        return copyFrom(bArr, 0, bArr.length);
    }

    public static ByteString copyFrom(Iterable<ByteString> iterable) {
        Collection collection;
        if (!(iterable instanceof Collection)) {
            collection = new ArrayList();
            Iterator<ByteString> it = iterable.iterator();
            while (it.hasNext()) {
                collection.add(it.next());
            }
        } else {
            collection = (Collection) iterable;
        }
        if (collection.isEmpty()) {
            return EMPTY;
        }
        return balancedConcat(collection.iterator(), collection.size());
    }
}
