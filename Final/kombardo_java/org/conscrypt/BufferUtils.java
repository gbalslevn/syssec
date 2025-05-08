package org.conscrypt;

import java.nio.ByteBuffer;

/* loaded from: classes3.dex */
final class BufferUtils {
    private BufferUtils() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void checkNotNull(ByteBuffer[] byteBufferArr) {
        for (ByteBuffer byteBuffer : byteBufferArr) {
            if (byteBuffer == null) {
                throw new IllegalArgumentException("Null buffer in array");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void consume(ByteBuffer[] byteBufferArr, int i5) {
        for (ByteBuffer byteBuffer : byteBufferArr) {
            int min = Math.min(byteBuffer.remaining(), i5);
            if (min > 0) {
                byteBuffer.position(byteBuffer.position() + min);
                i5 -= min;
                if (i5 == 0) {
                    break;
                }
            }
        }
        if (i5 > 0) {
            throw new IllegalArgumentException("toConsume > data size");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ByteBuffer copyNoConsume(ByteBuffer[] byteBufferArr, ByteBuffer byteBuffer, int i5) {
        Preconditions.checkArgument(byteBuffer.remaining() >= i5, "Destination buffer too small");
        for (ByteBuffer byteBuffer2 : byteBufferArr) {
            int remaining = byteBuffer2.remaining();
            if (remaining > 0) {
                int position = byteBuffer2.position();
                if (remaining <= i5) {
                    byteBuffer.put(byteBuffer2);
                    i5 -= remaining;
                } else {
                    int limit = byteBuffer2.limit();
                    byteBuffer2.limit(byteBuffer2.position() + i5);
                    byteBuffer.put(byteBuffer2);
                    byteBuffer2.limit(limit);
                    i5 = 0;
                }
                byteBuffer2.position(position);
                if (i5 == 0) {
                    break;
                }
            }
        }
        byteBuffer.flip();
        return byteBuffer;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ByteBuffer getBufferLargerThan(ByteBuffer[] byteBufferArr, int i5) {
        int length = byteBufferArr.length;
        int i6 = 0;
        while (i6 < length) {
            ByteBuffer byteBuffer = byteBufferArr[i6];
            int remaining = byteBuffer.remaining();
            if (remaining > 0) {
                if (remaining >= i5) {
                    return byteBuffer;
                }
                do {
                    i6++;
                    if (i6 >= length) {
                        return byteBuffer;
                    }
                } while (byteBufferArr[i6].remaining() <= 0);
                return null;
            }
            i6++;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long remaining(ByteBuffer[] byteBufferArr) {
        long j5 = 0;
        for (ByteBuffer byteBuffer : byteBufferArr) {
            j5 += byteBuffer.remaining();
        }
        return j5;
    }
}
