package com.google.protobuf;

/* loaded from: classes2.dex */
public abstract class CodedInputStream {
    private static final int DEFAULT_BUFFER_SIZE = 4096;
    private static final int DEFAULT_SIZE_LIMIT = Integer.MAX_VALUE;
    private static volatile int defaultRecursionLimit = 100;
    int recursionLimit;
    private boolean shouldDiscardUnknownFields;
    int sizeLimit;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class ArrayDecoder extends CodedInputStream {
        private final byte[] buffer;
        private int bufferSizeAfterLimit;
        private int currentLimit;
        private boolean enableAliasing;
        private final boolean immutable;
        private int lastTag;
        private int limit;
        private int pos;
        private int startPos;

        private void recomputeBufferSizeAfterLimit() {
            int i5 = this.limit + this.bufferSizeAfterLimit;
            this.limit = i5;
            int i6 = i5 - this.startPos;
            int i7 = this.currentLimit;
            if (i6 <= i7) {
                this.bufferSizeAfterLimit = 0;
                return;
            }
            int i8 = i6 - i7;
            this.bufferSizeAfterLimit = i8;
            this.limit = i5 - i8;
        }

        public int getTotalBytesRead() {
            return this.pos - this.startPos;
        }

        public int pushLimit(int i5) {
            if (i5 < 0) {
                throw InvalidProtocolBufferException.negativeSize();
            }
            int totalBytesRead = i5 + getTotalBytesRead();
            if (totalBytesRead < 0) {
                throw InvalidProtocolBufferException.parseFailure();
            }
            int i6 = this.currentLimit;
            if (totalBytesRead > i6) {
                throw InvalidProtocolBufferException.truncatedMessage();
            }
            this.currentLimit = totalBytesRead;
            recomputeBufferSizeAfterLimit();
            return i6;
        }

        private ArrayDecoder(byte[] bArr, int i5, int i6, boolean z5) {
            super();
            this.currentLimit = CodedInputStream.DEFAULT_SIZE_LIMIT;
            this.buffer = bArr;
            this.limit = i6 + i5;
            this.pos = i5;
            this.startPos = i5;
            this.immutable = z5;
        }
    }

    public static CodedInputStream newInstance(byte[] bArr) {
        return newInstance(bArr, 0, bArr.length);
    }

    private CodedInputStream() {
        this.recursionLimit = defaultRecursionLimit;
        this.sizeLimit = DEFAULT_SIZE_LIMIT;
        this.shouldDiscardUnknownFields = false;
    }

    public static CodedInputStream newInstance(byte[] bArr, int i5, int i6) {
        return newInstance(bArr, i5, i6, false);
    }

    static CodedInputStream newInstance(byte[] bArr, int i5, int i6, boolean z5) {
        ArrayDecoder arrayDecoder = new ArrayDecoder(bArr, i5, i6, z5);
        try {
            arrayDecoder.pushLimit(i6);
            return arrayDecoder;
        } catch (InvalidProtocolBufferException e5) {
            throw new IllegalArgumentException(e5);
        }
    }
}
