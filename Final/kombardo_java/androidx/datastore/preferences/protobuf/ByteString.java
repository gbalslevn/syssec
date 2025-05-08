package androidx.datastore.preferences.protobuf;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Locale;
import java.util.NoSuchElementException;

/* loaded from: classes.dex */
public abstract class ByteString implements Iterable<Byte>, Serializable {
    public static final ByteString EMPTY = new LiteralByteString(Internal.EMPTY_BYTE_ARRAY);
    private static final int UNSIGNED_BYTE_MASK = 255;
    private static final Comparator<ByteString> UNSIGNED_LEXICOGRAPHICAL_COMPARATOR;
    private static final ByteArrayCopier byteArrayCopier;
    private static final long serialVersionUID = 1;
    private int hash = 0;

    /* loaded from: classes.dex */
    static abstract class AbstractByteIterator implements ByteIterator {
        AbstractByteIterator() {
        }

        @Override // java.util.Iterator
        public final void remove() {
            throw new UnsupportedOperationException();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.Iterator
        public final Byte next() {
            return Byte.valueOf(nextByte());
        }
    }

    /* loaded from: classes.dex */
    private static final class ArraysByteArrayCopier implements ByteArrayCopier {
        private ArraysByteArrayCopier() {
        }

        @Override // androidx.datastore.preferences.protobuf.ByteString.ByteArrayCopier
        public byte[] copyFrom(byte[] bArr, int i5, int i6) {
            return Arrays.copyOfRange(bArr, i5, i6 + i5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class BoundedByteString extends LiteralByteString {
        private static final long serialVersionUID = 1;
        private final int bytesLength;
        private final int bytesOffset;

        BoundedByteString(byte[] bArr, int i5, int i6) {
            super(bArr);
            ByteString.checkRange(i5, i5 + i6, bArr.length);
            this.bytesOffset = i5;
            this.bytesLength = i6;
        }

        private void readObject(ObjectInputStream objectInputStream) {
            throw new InvalidObjectException("BoundedByteStream instances are not to be serialized directly");
        }

        @Override // androidx.datastore.preferences.protobuf.ByteString.LiteralByteString, androidx.datastore.preferences.protobuf.ByteString
        public byte byteAt(int i5) {
            ByteString.checkIndex(i5, size());
            return this.bytes[this.bytesOffset + i5];
        }

        @Override // androidx.datastore.preferences.protobuf.ByteString.LiteralByteString, androidx.datastore.preferences.protobuf.ByteString
        protected void copyToInternal(byte[] bArr, int i5, int i6, int i7) {
            System.arraycopy(this.bytes, getOffsetIntoBytes() + i5, bArr, i6, i7);
        }

        @Override // androidx.datastore.preferences.protobuf.ByteString.LiteralByteString
        protected int getOffsetIntoBytes() {
            return this.bytesOffset;
        }

        @Override // androidx.datastore.preferences.protobuf.ByteString.LiteralByteString, androidx.datastore.preferences.protobuf.ByteString
        byte internalByteAt(int i5) {
            return this.bytes[this.bytesOffset + i5];
        }

        @Override // androidx.datastore.preferences.protobuf.ByteString.LiteralByteString, androidx.datastore.preferences.protobuf.ByteString
        public int size() {
            return this.bytesLength;
        }

        Object writeReplace() {
            return ByteString.wrap(toByteArray());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public interface ByteArrayCopier {
        byte[] copyFrom(byte[] bArr, int i5, int i6);
    }

    /* loaded from: classes.dex */
    public interface ByteIterator extends Iterator<Byte> {
        byte nextByte();
    }

    /* loaded from: classes.dex */
    static abstract class LeafByteString extends ByteString {
        private static final long serialVersionUID = 1;

        @Override // java.lang.Iterable
        public /* bridge */ /* synthetic */ Iterator<Byte> iterator() {
            return super.iterator();
        }

        private LeafByteString() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class LiteralByteString extends LeafByteString {
        private static final long serialVersionUID = 1;
        protected final byte[] bytes;

        LiteralByteString(byte[] bArr) {
            super();
            bArr.getClass();
            this.bytes = bArr;
        }

        @Override // androidx.datastore.preferences.protobuf.ByteString
        public byte byteAt(int i5) {
            return this.bytes[i5];
        }

        @Override // androidx.datastore.preferences.protobuf.ByteString
        protected void copyToInternal(byte[] bArr, int i5, int i6, int i7) {
            System.arraycopy(this.bytes, i5, bArr, i6, i7);
        }

        @Override // androidx.datastore.preferences.protobuf.ByteString
        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof ByteString) || size() != ((ByteString) obj).size()) {
                return false;
            }
            if (size() == 0) {
                return true;
            }
            if (!(obj instanceof LiteralByteString)) {
                return obj.equals(this);
            }
            LiteralByteString literalByteString = (LiteralByteString) obj;
            int peekCachedHashCode = peekCachedHashCode();
            int peekCachedHashCode2 = literalByteString.peekCachedHashCode();
            if (peekCachedHashCode == 0 || peekCachedHashCode2 == 0 || peekCachedHashCode == peekCachedHashCode2) {
                return equalsRange(literalByteString, 0, size());
            }
            return false;
        }

        final boolean equalsRange(ByteString byteString, int i5, int i6) {
            if (i6 > byteString.size()) {
                throw new IllegalArgumentException("Length too large: " + i6 + size());
            }
            int i7 = i5 + i6;
            if (i7 > byteString.size()) {
                throw new IllegalArgumentException("Ran off end of other: " + i5 + ", " + i6 + ", " + byteString.size());
            }
            if (!(byteString instanceof LiteralByteString)) {
                return byteString.substring(i5, i7).equals(substring(0, i6));
            }
            LiteralByteString literalByteString = (LiteralByteString) byteString;
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

        @Override // androidx.datastore.preferences.protobuf.ByteString
        byte internalByteAt(int i5) {
            return this.bytes[i5];
        }

        @Override // androidx.datastore.preferences.protobuf.ByteString
        protected final int partialHash(int i5, int i6, int i7) {
            return Internal.partialHash(i5, this.bytes, getOffsetIntoBytes() + i6, i7);
        }

        @Override // androidx.datastore.preferences.protobuf.ByteString
        public int size() {
            return this.bytes.length;
        }

        @Override // androidx.datastore.preferences.protobuf.ByteString
        public final ByteString substring(int i5, int i6) {
            int checkRange = ByteString.checkRange(i5, i6, size());
            return checkRange == 0 ? ByteString.EMPTY : new BoundedByteString(this.bytes, getOffsetIntoBytes() + i5, checkRange);
        }

        @Override // androidx.datastore.preferences.protobuf.ByteString
        final void writeTo(ByteOutput byteOutput) {
            byteOutput.writeLazy(this.bytes, getOffsetIntoBytes(), size());
        }
    }

    /* loaded from: classes.dex */
    private static final class SystemByteArrayCopier implements ByteArrayCopier {
        private SystemByteArrayCopier() {
        }

        @Override // androidx.datastore.preferences.protobuf.ByteString.ByteArrayCopier
        public byte[] copyFrom(byte[] bArr, int i5, int i6) {
            byte[] bArr2 = new byte[i6];
            System.arraycopy(bArr, i5, bArr2, 0, i6);
            return bArr2;
        }
    }

    static {
        byteArrayCopier = Android.isOnAndroidDevice() ? new SystemByteArrayCopier() : new ArraysByteArrayCopier();
        UNSIGNED_LEXICOGRAPHICAL_COMPARATOR = new Comparator<ByteString>() { // from class: androidx.datastore.preferences.protobuf.ByteString.2
            /* JADX WARN: Type inference failed for: r0v0, types: [java.util.Iterator, androidx.datastore.preferences.protobuf.ByteString$ByteIterator] */
            /* JADX WARN: Type inference failed for: r1v0, types: [java.util.Iterator, androidx.datastore.preferences.protobuf.ByteString$ByteIterator] */
            @Override // java.util.Comparator
            public int compare(ByteString byteString, ByteString byteString2) {
                ?? it = byteString.iterator();
                ?? it2 = byteString2.iterator();
                while (it.hasNext() && it2.hasNext()) {
                    int compareTo = Integer.valueOf(ByteString.toInt(it.nextByte())).compareTo(Integer.valueOf(ByteString.toInt(it2.nextByte())));
                    if (compareTo != 0) {
                        return compareTo;
                    }
                }
                return Integer.valueOf(byteString.size()).compareTo(Integer.valueOf(byteString2.size()));
            }
        };
    }

    ByteString() {
    }

    static void checkIndex(int i5, int i6) {
        if (((i6 - (i5 + 1)) | i5) < 0) {
            if (i5 < 0) {
                throw new ArrayIndexOutOfBoundsException("Index < 0: " + i5);
            }
            throw new ArrayIndexOutOfBoundsException("Index > length: " + i5 + ", " + i6);
        }
    }

    static int checkRange(int i5, int i6, int i7) {
        int i8 = i6 - i5;
        if ((i5 | i6 | i8 | (i7 - i6)) >= 0) {
            return i8;
        }
        if (i5 < 0) {
            throw new IndexOutOfBoundsException("Beginning index: " + i5 + " < 0");
        }
        if (i6 < i5) {
            throw new IndexOutOfBoundsException("Beginning index larger than ending index: " + i5 + ", " + i6);
        }
        throw new IndexOutOfBoundsException("End index: " + i6 + " >= " + i7);
    }

    public static ByteString copyFrom(byte[] bArr, int i5, int i6) {
        checkRange(i5, i5 + i6, bArr.length);
        return new LiteralByteString(byteArrayCopier.copyFrom(bArr, i5, i6));
    }

    public static ByteString copyFromUtf8(String str) {
        return new LiteralByteString(str.getBytes(Internal.UTF_8));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int toInt(byte b5) {
        return b5 & 255;
    }

    private String truncateAndEscapeForDisplay() {
        if (size() <= 50) {
            return TextFormatEscaper.escapeBytes(this);
        }
        return TextFormatEscaper.escapeBytes(substring(0, 47)) + "...";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ByteString wrap(byte[] bArr) {
        return new LiteralByteString(bArr);
    }

    public abstract byte byteAt(int i5);

    protected abstract void copyToInternal(byte[] bArr, int i5, int i6, int i7);

    public abstract boolean equals(Object obj);

    public final int hashCode() {
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

    abstract byte internalByteAt(int i5);

    @Override // java.lang.Iterable
    public Iterator<Byte> iterator() {
        return new AbstractByteIterator() { // from class: androidx.datastore.preferences.protobuf.ByteString.1
            private final int limit;
            private int position = 0;

            {
                this.limit = ByteString.this.size();
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.position < this.limit;
            }

            @Override // androidx.datastore.preferences.protobuf.ByteString.ByteIterator
            public byte nextByte() {
                int i5 = this.position;
                if (i5 >= this.limit) {
                    throw new NoSuchElementException();
                }
                this.position = i5 + 1;
                return ByteString.this.internalByteAt(i5);
            }
        };
    }

    protected abstract int partialHash(int i5, int i6, int i7);

    protected final int peekCachedHashCode() {
        return this.hash;
    }

    public abstract int size();

    public abstract ByteString substring(int i5, int i6);

    public final byte[] toByteArray() {
        int size = size();
        if (size == 0) {
            return Internal.EMPTY_BYTE_ARRAY;
        }
        byte[] bArr = new byte[size];
        copyToInternal(bArr, 0, 0, size);
        return bArr;
    }

    public final String toString() {
        return String.format(Locale.ROOT, "<ByteString@%s size=%d contents=\"%s\">", Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(size()), truncateAndEscapeForDisplay());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void writeTo(ByteOutput byteOutput);

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ByteString wrap(byte[] bArr, int i5, int i6) {
        return new BoundedByteString(bArr, i5, i6);
    }

    public static ByteString copyFrom(byte[] bArr) {
        return copyFrom(bArr, 0, bArr.length);
    }
}
