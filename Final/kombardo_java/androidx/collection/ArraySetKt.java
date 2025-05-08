package androidx.collection;

import androidx.collection.internal.ContainerHelpersKt;
import java.util.ConcurrentModificationException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a'\u0010\u0004\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001a1\u0010\b\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\b\u0010\t\u001a\u001f\u0010\n\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0000¢\u0006\u0004\b\n\u0010\u000b\u001a'\u0010\u000e\u001a\u00020\r\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\f\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"E", "Landroidx/collection/ArraySet;", BuildConfig.FLAVOR, "hash", "binarySearchInternal", "(Landroidx/collection/ArraySet;I)I", BuildConfig.FLAVOR, "key", "indexOf", "(Landroidx/collection/ArraySet;Ljava/lang/Object;I)I", "indexOfNull", "(Landroidx/collection/ArraySet;)I", "size", BuildConfig.FLAVOR, "allocArrays", "(Landroidx/collection/ArraySet;I)V", "collection"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class ArraySetKt {
    public static final <E> void allocArrays(ArraySet<E> arraySet, int i5) {
        Intrinsics.checkNotNullParameter(arraySet, "<this>");
        arraySet.setHashes$collection(new int[i5]);
        arraySet.setArray$collection(new Object[i5]);
    }

    public static final <E> int binarySearchInternal(ArraySet<E> arraySet, int i5) {
        Intrinsics.checkNotNullParameter(arraySet, "<this>");
        try {
            return ContainerHelpersKt.binarySearch(arraySet.getHashes(), arraySet.get_size$collection(), i5);
        } catch (IndexOutOfBoundsException unused) {
            throw new ConcurrentModificationException();
        }
    }

    public static final <E> int indexOf(ArraySet<E> arraySet, Object obj, int i5) {
        Intrinsics.checkNotNullParameter(arraySet, "<this>");
        int i6 = arraySet.get_size$collection();
        if (i6 == 0) {
            return -1;
        }
        int binarySearchInternal = binarySearchInternal(arraySet, i5);
        if (binarySearchInternal < 0 || Intrinsics.areEqual(obj, arraySet.getArray()[binarySearchInternal])) {
            return binarySearchInternal;
        }
        int i7 = binarySearchInternal + 1;
        while (i7 < i6 && arraySet.getHashes()[i7] == i5) {
            if (Intrinsics.areEqual(obj, arraySet.getArray()[i7])) {
                return i7;
            }
            i7++;
        }
        for (int i8 = binarySearchInternal - 1; i8 >= 0 && arraySet.getHashes()[i8] == i5; i8--) {
            if (Intrinsics.areEqual(obj, arraySet.getArray()[i8])) {
                return i8;
            }
        }
        return ~i7;
    }

    public static final <E> int indexOfNull(ArraySet<E> arraySet) {
        Intrinsics.checkNotNullParameter(arraySet, "<this>");
        return indexOf(arraySet, null, 0);
    }
}
