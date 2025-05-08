package androidx.collection;

import androidx.collection.internal.ContainerHelpersKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u001a)\u0010\u0004\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u001f\u0010\u0007\u001a\u00020\u0006\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0002¢\u0006\u0004\b\u0007\u0010\b\"\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"E", "Landroidx/collection/SparseArrayCompat;", BuildConfig.FLAVOR, "key", "commonGet", "(Landroidx/collection/SparseArrayCompat;I)Ljava/lang/Object;", BuildConfig.FLAVOR, "gc", "(Landroidx/collection/SparseArrayCompat;)V", BuildConfig.FLAVOR, "DELETED", "Ljava/lang/Object;", "collection"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class SparseArrayCompatKt {
    private static final Object DELETED = new Object();

    public static final <E> E commonGet(SparseArrayCompat<E> sparseArrayCompat, int i5) {
        E e5;
        Intrinsics.checkNotNullParameter(sparseArrayCompat, "<this>");
        int binarySearch = ContainerHelpersKt.binarySearch(sparseArrayCompat.keys, sparseArrayCompat.size, i5);
        if (binarySearch < 0 || (e5 = (E) sparseArrayCompat.values[binarySearch]) == DELETED) {
            return null;
        }
        return e5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <E> void gc(SparseArrayCompat<E> sparseArrayCompat) {
        int i5 = sparseArrayCompat.size;
        int[] iArr = sparseArrayCompat.keys;
        Object[] objArr = sparseArrayCompat.values;
        int i6 = 0;
        for (int i7 = 0; i7 < i5; i7++) {
            Object obj = objArr[i7];
            if (obj != DELETED) {
                if (i7 != i6) {
                    iArr[i6] = iArr[i7];
                    objArr[i6] = obj;
                    objArr[i7] = null;
                }
                i6++;
            }
        }
        sparseArrayCompat.garbage = false;
        sparseArrayCompat.size = i6;
    }
}
