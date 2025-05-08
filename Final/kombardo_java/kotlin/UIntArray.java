package kotlin;

import java.util.Arrays;
import java.util.Collection;
import java.util.NoSuchElementException;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010(\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\n\b\u0087@\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00011B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006B\u0011\b\u0001\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u0005\u0010\tJ\u0018\u0010\r\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0003H\u0086\u0002¢\u0006\u0004\b\u000b\u0010\fJ \u0010\u0012\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0002H\u0086\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0016\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00020\u0013H\u0096\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0018\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00020\u0002H\u0096\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u001d\u0010\u001f\u001a\u00020\u00182\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\"\u001a\u00020\u0018H\u0016¢\u0006\u0004\b \u0010!J\u0010\u0010$\u001a\u00020#HÖ\u0001¢\u0006\u0004\b$\u0010%J\u0010\u0010&\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b&\u0010'J\u001a\u0010*\u001a\u00020\u00182\b\u0010)\u001a\u0004\u0018\u00010(HÖ\u0003¢\u0006\u0004\b*\u0010+R\u001a\u0010\b\u001a\u00020\u00078\u0000X\u0081\u0004¢\u0006\f\n\u0004\b\b\u0010,\u0012\u0004\b-\u0010.R\u0014\u0010\u0004\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b/\u00100\u0088\u0001\b\u0092\u0001\u00020\u0007¨\u00062"}, d2 = {"Lkotlin/UIntArray;", BuildConfig.FLAVOR, "Lkotlin/UInt;", BuildConfig.FLAVOR, "size", "constructor-impl", "(I)[I", BuildConfig.FLAVOR, "storage", "([I)[I", "index", "get-pVg5ArA", "([II)I", "get", "value", BuildConfig.FLAVOR, "set-VXSXFK8", "([III)V", "set", BuildConfig.FLAVOR, "iterator-impl", "([I)Ljava/util/Iterator;", "iterator", "element", BuildConfig.FLAVOR, "contains-WZ4Q5Ns", "([II)Z", "contains", "elements", "containsAll-impl", "([ILjava/util/Collection;)Z", "containsAll", "isEmpty-impl", "([I)Z", "isEmpty", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", "hashCode", "()I", BuildConfig.FLAVOR, "other", "equals", "(Ljava/lang/Object;)Z", "[I", "getStorage$annotations", "()V", "getSize-impl", "([I)I", "Iterator", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class UIntArray implements Collection<UInt>, KMappedMarker {
    private final int[] storage;

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\t\u001a\u00020\nH\u0096\u0002J\u0010\u0010\u000b\u001a\u00020\u0002H\u0096\u0002¢\u0006\u0004\b\f\u0010\rR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lkotlin/UIntArray$Iterator;", BuildConfig.FLAVOR, "Lkotlin/UInt;", "array", BuildConfig.FLAVOR, "<init>", "([I)V", "index", BuildConfig.FLAVOR, "hasNext", BuildConfig.FLAVOR, "next", "next-pVg5ArA", "()I", "kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Iterator implements java.util.Iterator<UInt>, KMappedMarker {
        private final int[] array;
        private int index;

        public Iterator(int[] array) {
            Intrinsics.checkNotNullParameter(array, "array");
            this.array = array;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.index < this.array.length;
        }

        @Override // java.util.Iterator
        public /* bridge */ /* synthetic */ UInt next() {
            return UInt.m3598boximpl(m3620nextpVg5ArA());
        }

        /* renamed from: next-pVg5ArA, reason: not valid java name */
        public int m3620nextpVg5ArA() {
            int i5 = this.index;
            int[] iArr = this.array;
            if (i5 >= iArr.length) {
                throw new NoSuchElementException(String.valueOf(this.index));
            }
            this.index = i5 + 1;
            return UInt.m3599constructorimpl(iArr[i5]);
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    private /* synthetic */ UIntArray(int[] iArr) {
        this.storage = iArr;
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ UIntArray m3604boximpl(int[] iArr) {
        return new UIntArray(iArr);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static int[] m3606constructorimpl(int[] storage) {
        Intrinsics.checkNotNullParameter(storage, "storage");
        return storage;
    }

    /* renamed from: containsAll-impl, reason: not valid java name */
    public static boolean m3608containsAllimpl(int[] iArr, Collection<UInt> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        Collection<UInt> collection = elements;
        if (collection.isEmpty()) {
            return true;
        }
        for (Object obj : collection) {
            if (!(obj instanceof UInt) || !ArraysKt.contains(iArr, ((UInt) obj).getData())) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m3609equalsimpl(int[] iArr, Object obj) {
        return (obj instanceof UIntArray) && Intrinsics.areEqual(iArr, ((UIntArray) obj).getStorage());
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m3610equalsimpl0(int[] iArr, int[] iArr2) {
        return Intrinsics.areEqual(iArr, iArr2);
    }

    /* renamed from: get-pVg5ArA, reason: not valid java name */
    public static final int m3611getpVg5ArA(int[] iArr, int i5) {
        return UInt.m3599constructorimpl(iArr[i5]);
    }

    /* renamed from: getSize-impl, reason: not valid java name */
    public static int m3612getSizeimpl(int[] iArr) {
        return iArr.length;
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m3613hashCodeimpl(int[] iArr) {
        return Arrays.hashCode(iArr);
    }

    /* renamed from: isEmpty-impl, reason: not valid java name */
    public static boolean m3614isEmptyimpl(int[] iArr) {
        return iArr.length == 0;
    }

    /* renamed from: iterator-impl, reason: not valid java name */
    public static java.util.Iterator<UInt> m3615iteratorimpl(int[] iArr) {
        return new Iterator(iArr);
    }

    /* renamed from: set-VXSXFK8, reason: not valid java name */
    public static final void m3616setVXSXFK8(int[] iArr, int i5, int i6) {
        iArr[i5] = i6;
    }

    /* renamed from: toString-impl, reason: not valid java name */
    public static String m3617toStringimpl(int[] iArr) {
        return "UIntArray(storage=" + Arrays.toString(iArr) + ')';
    }

    @Override // java.util.Collection
    public /* bridge */ /* synthetic */ boolean add(UInt uInt) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public boolean addAll(Collection<? extends UInt> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Collection
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof UInt) {
            return m3618containsWZ4Q5Ns(((UInt) obj).getData());
        }
        return false;
    }

    /* renamed from: contains-WZ4Q5Ns, reason: not valid java name */
    public boolean m3618containsWZ4Q5Ns(int i5) {
        return m3607containsWZ4Q5Ns(this.storage, i5);
    }

    @Override // java.util.Collection
    public boolean containsAll(Collection<? extends Object> elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        return m3608containsAllimpl(this.storage, elements);
    }

    @Override // java.util.Collection
    public boolean equals(Object other) {
        return m3609equalsimpl(this.storage, other);
    }

    @Override // java.util.Collection
    /* renamed from: getSize, reason: merged with bridge method [inline-methods] */
    public int size() {
        return m3612getSizeimpl(this.storage);
    }

    @Override // java.util.Collection
    public int hashCode() {
        return m3613hashCodeimpl(this.storage);
    }

    @Override // java.util.Collection
    public boolean isEmpty() {
        return m3614isEmptyimpl(this.storage);
    }

    @Override // java.util.Collection, java.lang.Iterable
    public java.util.Iterator<UInt> iterator() {
        return m3615iteratorimpl(this.storage);
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
        return m3617toStringimpl(this.storage);
    }

    /* renamed from: unbox-impl, reason: not valid java name and from getter */
    public final /* synthetic */ int[] getStorage() {
        return this.storage;
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static int[] m3605constructorimpl(int i5) {
        return m3606constructorimpl(new int[i5]);
    }

    /* renamed from: contains-WZ4Q5Ns, reason: not valid java name */
    public static boolean m3607containsWZ4Q5Ns(int[] iArr, int i5) {
        return ArraysKt.contains(iArr, i5);
    }

    @Override // java.util.Collection
    public <T> T[] toArray(T[] array) {
        Intrinsics.checkNotNullParameter(array, "array");
        return (T[]) CollectionToArray.toArray(this, array);
    }
}
