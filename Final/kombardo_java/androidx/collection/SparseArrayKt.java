package androidx.collection;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010(\n\u0002\b\u0003\u001a\u001d\u0010\u0003\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\u0004\b\u0003\u0010\u0004\u001a#\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"T", "Landroidx/collection/SparseArrayCompat;", "Lkotlin/collections/IntIterator;", "keyIterator", "(Landroidx/collection/SparseArrayCompat;)Lkotlin/collections/IntIterator;", BuildConfig.FLAVOR, "valueIterator", "(Landroidx/collection/SparseArrayCompat;)Ljava/util/Iterator;", "collection"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class SparseArrayKt {
    public static final <T> IntIterator keyIterator(final SparseArrayCompat<T> sparseArrayCompat) {
        Intrinsics.checkNotNullParameter(sparseArrayCompat, "<this>");
        return new IntIterator() { // from class: androidx.collection.SparseArrayKt$keyIterator$1
            private int index;

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.index < sparseArrayCompat.size();
            }

            @Override // kotlin.collections.IntIterator
            public int nextInt() {
                SparseArrayCompat<T> sparseArrayCompat2 = sparseArrayCompat;
                int i5 = this.index;
                this.index = i5 + 1;
                return sparseArrayCompat2.keyAt(i5);
            }
        };
    }

    public static final <T> Iterator<T> valueIterator(SparseArrayCompat<T> sparseArrayCompat) {
        Intrinsics.checkNotNullParameter(sparseArrayCompat, "<this>");
        return new SparseArrayKt$valueIterator$1(sparseArrayCompat);
    }
}
