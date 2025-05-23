package org.conscrypt;

import java.nio.ByteBuffer;

/* loaded from: classes3.dex */
public abstract class BufferAllocator {
    private static final BufferAllocator UNPOOLED = new BufferAllocator() { // from class: org.conscrypt.BufferAllocator.1
        @Override // org.conscrypt.BufferAllocator
        public AllocatedBuffer allocateDirectBuffer(int i5) {
            return AllocatedBuffer.wrap(ByteBuffer.allocateDirect(i5));
        }
    };

    public static BufferAllocator unpooled() {
        return UNPOOLED;
    }

    public abstract AllocatedBuffer allocateDirectBuffer(int i5);
}
