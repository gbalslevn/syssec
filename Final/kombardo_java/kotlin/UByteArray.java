package kotlin;

import java.util.Arrays;
import java.util.Collection;
import java.util.NoSuchElementException;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010(\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\n\b\u0087@\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00011B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006B\u0011\b\u0001\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u0005\u0010\tJ\u0018\u0010\r\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0003H\u0086\u0002¢\u0006\u0004\b\u000b\u0010\fJ \u0010\u0012\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0002H\u0086\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0016\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00020\u0013H\u0096\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0018\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00020\u0002H\u0096\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u001d\u0010\u001f\u001a\u00020\u00182\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\"\u001a\u00020\u0018H\u0016¢\u0006\u0004\b \u0010!J\u0010\u0010$\u001a\u00020#HÖ\u0001¢\u0006\u0004\b$\u0010%J\u0010\u0010&\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b&\u0010'J\u001a\u0010*\u001a\u00020\u00182\b\u0010)\u001a\u0004\u0018\u00010(HÖ\u0003¢\u0006\u0004\b*\u0010+R\u001a\u0010\b\u001a\u00020\u00078\u0000X\u0081\u0004¢\u0006\f\n\u0004\b\b\u0010,\u0012\u0004\b-\u0010.R\u0014\u0010\u0004\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b/\u00100\u0088\u0001\b\u0092\u0001\u00020\u0007¨\u00062"}, d2 = {"Lkotlin/UByteArray;", BuildConfig.FLAVOR, "Lkotlin/UByte;", BuildConfig.FLAVOR, "size", "constructor-impl", "(I)[B", BuildConfig.FLAVOR, "storage", "([B)[B", "index", "get-w2LRezQ", "([BI)B", "get", "value", BuildConfig.FLAVOR, "set-VurrAj0", "([BIB)V", "set", BuildConfig.FLAVOR, "iterator-impl", "([B)Ljava/util/Iterator;", "iterator", "element", BuildConfig.FLAVOR, "contains-7apg3OU", "([BB)Z", "contains", "elements", "containsAll-impl", "([BLjava/util/Collection;)Z", "containsAll", "isEmpty-impl", "([B)Z", "isEmpty", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", "hashCode", "()I", BuildConfig.FLAVOR, "other", "equals", "(Ljava/lang/Object;)Z", "[B", "getStorage$annotations", "()V", "getSize-impl", "([B)I", "Iterator", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class UByteArray implements Collection<UByte>, KMappedMarker {
    private final byte[] storage;

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\t\u001a\u00020\nH\u0096\u0002J\u0010\u0010\u000b\u001a\u00020\u0002H\u0096\u0002¢\u0006\u0004\b\f\u0010\rR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lkotlin/UByteArray$Iterator;", BuildConfig.FLAVOR, "Lkotlin/UByte;", "array", BuildConfig.FLAVOR, "<init>", "([B)V", "index", BuildConfig.FLAVOR, "hasNext", BuildConfig.FLAVOR, "next", "next-w2LRezQ", "()B", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Iterator implements java.util.Iterator<UByte>, KMappedMarker {
        private final byte[] array;
        private int index;

        public Iterator(byte[] array) {
            Intrinsics.checkNotNullParameter(array, "array");
            this.array = array;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.index < this.array.length;
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ UByte next() {
            return UByte.m3576boximpl(m3597nextw2LRezQ());
        }

        /* renamed from: next-w2LRezQ, reason: not valid java name */
        public byte m3597nextw2LRezQ() {
            int i5 = this.index;
            byte[] bArr = this.array;
            if (i5 >= bArr.length) {
                throw new NoSuchElementException(String.valueOf(this.index));
            }
            this.index = i5 + 1;
            return UByte.m3577constructorimpl(bArr[i5]);
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    private /* synthetic */ UByteArray(byte[] bArr) {
        this.storage = bArr;
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ UByteArray m3582boximpl(byte[] bArr) {
        return new UByteArray(bArr);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static byte[] m3584constructorimpl(byte[] storage) {
        Intrinsics.checkNotNullParameter(storage, "storage");
        return storage;
    }

    /* renamed from: containsAll-impl, reason: not valid java name */
    public static boolean m3586containsAllimpl(byte[] bArr, Collection<UByte> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        Collection<UByte> collection = elements;
        if (collection.isEmpty()) {
            return true;
        }
        for (Object obj : collection) {
            if (!(obj instanceof UByte) || !ArraysKt.contains(bArr, ((UByte) obj).getData())) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m3587equalsimpl(byte[] bArr, Object obj) {
        return (obj instanceof UByteArray) && Intrinsics.areEqual(bArr, ((UByteArray) obj).getStorage());
    }

    /* renamed from: get-w2LRezQ, reason: not valid java name */
    public static final byte m3588getw2LRezQ(byte[] bArr, int i5) {
        return UByte.m3577constructorimpl(bArr[i5]);
    }

    /* renamed from: getSize-impl, reason: not valid java name */
    public static int m3589getSizeimpl(byte[] bArr) {
        return bArr.length;
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m3590hashCodeimpl(byte[] bArr) {
        return Arrays.hashCode(bArr);
    }

    /* renamed from: isEmpty-impl, reason: not valid java name */
    public static boolean m3591isEmptyimpl(byte[] bArr) {
        return bArr.length == 0;
    }

    /* renamed from: iterator-impl, reason: not valid java name */
    public static java.util.Iterator<UByte> m3592iteratorimpl(byte[] bArr) {
        return new Iterator(bArr);
    }

    /* renamed from: set-VurrAj0, reason: not valid java name */
    public static final void m3593setVurrAj0(byte[] bArr, int i5, byte b5) {
        bArr[i5] = b5;
    }

    /* renamed from: toString-impl, reason: not valid java name */
    public static String m3594toStringimpl(byte[] bArr) {
        return "UByteArray(storage=" + Arrays.toString(bArr) + ')';
    }

    @Override // java.util.Collection
    public /* bridge */ /* synthetic */ boolean add(UByte uByte) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean addAll(Collection<? extends UByte> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof UByte) {
            return m3595contains7apg3OU(((UByte) obj).getData());
        }
        return false;
    }

    /* renamed from: contains-7apg3OU, reason: not valid java name */
    public boolean m3595contains7apg3OU(byte b5) {
        return m3585contains7apg3OU(this.storage, b5);
    }

    @Override // java.util.Collection
    public boolean containsAll(Collection<? extends Object> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        return m3586containsAllimpl(this.storage, elements);
    }

    @Override // java.util.Collection
    public boolean equals(Object other) {
        return m3587equalsimpl(this.storage, other);
    }

    @Override // java.util.Collection
    /* renamed from: getSize, reason: merged with bridge method [inline-methods] */
    public int size() {
        return m3589getSizeimpl(this.storage);
    }

    @Override // java.util.Collection
    public int hashCode() {
        return m3590hashCodeimpl(this.storage);
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return m3591isEmptyimpl(this.storage);
    }

    @Override // java.util.Collection, java.lang.Iterable
    public java.util.Iterator<UByte> iterator() {
        return m3592iteratorimpl(this.storage);
    }

    @Override // java.util.Collection
    public boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean removeAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean retainAll(Collection<? extends Object> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public Object[] toArray() {
        return CollectionToArray.toArray(this);
    }

    public String toString() {
        return m3594toStringimpl(this.storage);
    }

    /* renamed from: unbox-impl, reason: not valid java name and from getter */
    public final /* synthetic */ byte[] getStorage() {
        return this.storage;
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static byte[] m3583constructorimpl(int i5) {
        return m3584constructorimpl(new byte[i5]);
    }

    /* renamed from: contains-7apg3OU, reason: not valid java name */
    public static boolean m3585contains7apg3OU(byte[] bArr, byte b5) {
        return ArraysKt.contains(bArr, b5);
    }

    @Override // java.util.Collection
    public <T> T[] toArray(T[] array) {
        Intrinsics.checkNotNullParameter(array, "array");
        return (T[]) CollectionToArray.toArray(this, array);
    }
}
