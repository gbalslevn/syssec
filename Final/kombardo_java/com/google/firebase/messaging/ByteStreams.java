package com.google.firebase.messaging;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/* loaded from: classes2.dex */
abstract class ByteStreams {
    private static final int BUFFER_SIZE = 8192;
    private static final int MAX_ARRAY_LEN = 2147483639;
    private static final int TO_BYTE_ARRAY_DEQUE_SIZE = 20;

    private static byte[] combineBuffers(Queue<byte[]> queue, int i5) {
        if (queue.isEmpty()) {
            return new byte[0];
        }
        byte[] remove = queue.remove();
        if (remove.length == i5) {
            return remove;
        }
        int length = i5 - remove.length;
        byte[] copyOf = Arrays.copyOf(remove, i5);
        while (length > 0) {
            byte[] remove2 = queue.remove();
            int min = Math.min(length, remove2.length);
            System.arraycopy(remove2, 0, copyOf, i5 - length, min);
            length -= min;
        }
        return copyOf;
    }

    public static InputStream limit(InputStream inputStream, long j5) {
        return new LimitedInputStream(inputStream, j5);
    }

    private static int saturatedCast(long j5) {
        if (j5 > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        if (j5 < -2147483648L) {
            return Integer.MIN_VALUE;
        }
        return (int) j5;
    }

    public static byte[] toByteArray(InputStream inputStream) {
        return toByteArrayInternal(inputStream, new ArrayDeque(20), 0);
    }

    private static byte[] toByteArrayInternal(InputStream inputStream, Queue<byte[]> queue, int i5) {
        int min = Math.min(BUFFER_SIZE, Math.max(128, Integer.highestOneBit(i5) * 2));
        while (i5 < MAX_ARRAY_LEN) {
            int min2 = Math.min(min, MAX_ARRAY_LEN - i5);
            byte[] bArr = new byte[min2];
            queue.add(bArr);
            int i6 = 0;
            while (i6 < min2) {
                int read = inputStream.read(bArr, i6, min2 - i6);
                if (read == -1) {
                    return combineBuffers(queue, i5);
                }
                i6 += read;
                i5 += read;
            }
            min = saturatedCast(min * (min < 4096 ? 4 : 2));
        }
        if (inputStream.read() == -1) {
            return combineBuffers(queue, MAX_ARRAY_LEN);
        }
        throw new OutOfMemoryError("input is too large to fit in a byte array");
    }

    /* loaded from: classes2.dex */
    private static final class LimitedInputStream extends FilterInputStream {
        private long left;
        private long mark;

        LimitedInputStream(InputStream inputStream, long j5) {
            super(inputStream);
            this.mark = -1L;
            this.left = j5;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int available() {
            return (int) Math.min(((FilterInputStream) this).in.available(), this.left);
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public synchronized void mark(int i5) {
            ((FilterInputStream) this).in.mark(i5);
            this.mark = this.left;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read() {
            if (this.left == 0) {
                return -1;
            }
            int read = ((FilterInputStream) this).in.read();
            if (read != -1) {
                this.left--;
            }
            return read;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public synchronized void reset() {
            if (!((FilterInputStream) this).in.markSupported()) {
                throw new IOException("Mark not supported");
            }
            if (this.mark == -1) {
                throw new IOException("Mark not set");
            }
            ((FilterInputStream) this).in.reset();
            this.left = this.mark;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public long skip(long j5) {
            long skip = ((FilterInputStream) this).in.skip(Math.min(j5, this.left));
            this.left -= skip;
            return skip;
        }

        @Override // java.io.FilterInputStream, java.io.InputStream
        public int read(byte[] bArr, int i5, int i6) {
            long j5 = this.left;
            if (j5 == 0) {
                return -1;
            }
            int read = ((FilterInputStream) this).in.read(bArr, i5, (int) Math.min(i6, j5));
            if (read != -1) {
                this.left -= read;
            }
            return read;
        }
    }
}
