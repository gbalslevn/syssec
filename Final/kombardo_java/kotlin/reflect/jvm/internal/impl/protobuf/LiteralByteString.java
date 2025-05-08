package kotlin.reflect.jvm.internal.impl.protobuf;

import java.io.OutputStream;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.reflect.jvm.internal.impl.protobuf.ByteString;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class LiteralByteString extends ByteString {
    protected final byte[] bytes;
    private int hash = 0;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class LiteralByteIterator implements ByteString.ByteIterator {
        private final int limit;
        private int position;

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.position < this.limit;
        }

        @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString.ByteIterator
        public byte nextByte() {
            try {
                byte[] bArr = LiteralByteString.this.bytes;
                int i5 = this.position;
                this.position = i5 + 1;
                return bArr[i5];
            } catch (ArrayIndexOutOfBoundsException e5) {
                throw new NoSuchElementException(e5.getMessage());
            }
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }

        private LiteralByteIterator() {
            this.position = 0;
            this.limit = LiteralByteString.this.size();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.Iterator
        public Byte next() {
            return Byte.valueOf(nextByte());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public LiteralByteString(byte[] bArr) {
        this.bytes = bArr;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString
    protected void copyToInternal(byte[] bArr, int i5, int i6, int i7) {
        System.arraycopy(this.bytes, i5, bArr, i6, i7);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ByteString) || size() != ((ByteString) obj).size()) {
            return false;
        }
        if (size() == 0) {
            return true;
        }
        if (obj instanceof LiteralByteString) {
            return equalsRange((LiteralByteString) obj, 0, size());
        }
        if (obj instanceof RopeByteString) {
            return obj.equals(this);
        }
        String valueOf = String.valueOf(obj.getClass());
        StringBuilder sb = new StringBuilder(valueOf.length() + 49);
        sb.append("Has a new type of ByteString been created? Found ");
        sb.append(valueOf);
        throw new IllegalArgumentException(sb.toString());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean equalsRange(LiteralByteString literalByteString, int i5, int i6) {
        if (i6 > literalByteString.size()) {
            int size = size();
            StringBuilder sb = new StringBuilder(40);
            sb.append("Length too large: ");
            sb.append(i6);
            sb.append(size);
            throw new IllegalArgumentException(sb.toString());
        }
        if (i5 + i6 > literalByteString.size()) {
            int size2 = literalByteString.size();
            StringBuilder sb2 = new StringBuilder(59);
            sb2.append("Ran off end of other: ");
            sb2.append(i5);
            sb2.append(", ");
            sb2.append(i6);
            sb2.append(", ");
            sb2.append(size2);
            throw new IllegalArgumentException(sb2.toString());
        }
        byte[] bArr = this.bytes;
        byte[] bArr2 = literalByteString.bytes;
        int offsetIntoBytes = getOffsetIntoBytes() + i6;
        int offsetIntoBytes2 = getOffsetIntoBytes();
        int offsetIntoBytes3 = literalByteString.getOffsetIntoBytes() + i5;
        while (offsetIntoBytes2 < offsetIntoBytes) {
            if (bArr[offsetIntoBytes2] != bArr2[offsetIntoBytes3]) {
                return false;
            }
            offsetIntoBytes2++;
            offsetIntoBytes3++;
        }
        return true;
    }

    protected int getOffsetIntoBytes() {
        return 0;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString
    protected int getTreeDepth() {
        return 0;
    }

    public int hashCode() {
        int i5 = this.hash;
        if (i5 == 0) {
            int size = size();
            i5 = partialHash(size, 0, size);
            if (i5 == 0) {
                i5 = 1;
            }
            this.hash = i5;
        }
        return i5;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString
    protected boolean isBalanced() {
        return true;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString
    public boolean isValidUtf8() {
        int offsetIntoBytes = getOffsetIntoBytes();
        return Utf8.isValidUtf8(this.bytes, offsetIntoBytes, size() + offsetIntoBytes);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString
    protected int partialHash(int i5, int i6, int i7) {
        return hashCode(i5, this.bytes, getOffsetIntoBytes() + i6, i7);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString
    protected int partialIsValidUtf8(int i5, int i6, int i7) {
        int offsetIntoBytes = getOffsetIntoBytes() + i6;
        return Utf8.partialIsValidUtf8(i5, this.bytes, offsetIntoBytes, i7 + offsetIntoBytes);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString
    protected int peekCachedHashCode() {
        return this.hash;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString
    public int size() {
        return this.bytes.length;
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString
    public String toString(String str) {
        return new String(this.bytes, getOffsetIntoBytes(), size(), str);
    }

    @Override // kotlin.reflect.jvm.internal.impl.protobuf.ByteString
    void writeToInternal(OutputStream outputStream, int i5, int i6) {
        outputStream.write(this.bytes, getOffsetIntoBytes() + i5, i6);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // java.lang.Iterable
    public Iterator<Byte> iterator() {
        return new LiteralByteIterator();
    }

    static int hashCode(int i5, byte[] bArr, int i6, int i7) {
        for (int i8 = i6; i8 < i6 + i7; i8++) {
            i5 = (i5 * 31) + bArr[i8];
        }
        return i5;
    }
}
