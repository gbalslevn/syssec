package kotlin.reflect.jvm.internal.impl.protobuf;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.reflect.jvm.internal.impl.protobuf.ByteString;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class BoundedByteString extends LiteralByteString {
    private final int bytesLength;
    private final int bytesOffset;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class BoundedByteIterator implements ByteString.ByteIterator {
        private final int limit;
        private int position;

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.position < this.limit;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString.ByteIterator
        public byte nextByte() {
            int i5 = this.position;
            if (i5 >= this.limit) {
                throw new NoSuchElementException();
            }
            byte[] bArr = BoundedByteString.this.bytes;
            this.position = i5 + 1;
            return bArr[i5];
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }

        private BoundedByteIterator() {
            int offsetIntoBytes = BoundedByteString.this.getOffsetIntoBytes();
            this.position = offsetIntoBytes;
            this.limit = offsetIntoBytes + BoundedByteString.this.size();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.Iterator
        public Byte next() {
            return Byte.valueOf(nextByte());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public BoundedByteString(byte[] bArr, int i5, int i6) {
        super(bArr);
        if (i5 < 0) {
            StringBuilder sb = new StringBuilder(29);
            sb.append("Offset too small: ");
            sb.append(i5);
            throw new IllegalArgumentException(sb.toString());
        }
        if (i6 < 0) {
            StringBuilder sb2 = new StringBuilder(29);
            sb2.append("Length too small: ");
            sb2.append(i5);
            throw new IllegalArgumentException(sb2.toString());
        }
        if (i5 + i6 <= bArr.length) {
            this.bytesOffset = i5;
            this.bytesLength = i6;
            return;
        }
        StringBuilder sb3 = new StringBuilder(48);
        sb3.append("Offset+Length too large: ");
        sb3.append(i5);
        sb3.append("+");
        sb3.append(i6);
        throw new IllegalArgumentException(sb3.toString());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // kotlin.reflect.jvm.internal.impl.protobuf.LiteralByteString, kotlin.reflect.jvm.internal.impl.protobuf.ByteString
    public void copyToInternal(byte[] bArr, int i5, int i6, int i7) {
        System.arraycopy(this.bytes, getOffsetIntoBytes() + i5, bArr, i6, i7);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.LiteralByteString
    protected int getOffsetIntoBytes() {
        return this.bytesOffset;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.LiteralByteString, kotlin.reflect.jvm.internal.impl.protobuf.ByteString
    public int size() {
        return this.bytesLength;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.LiteralByteString, java.lang.Iterable
    public Iterator<Byte> iterator() {
        return new BoundedByteIterator();
    }
}
