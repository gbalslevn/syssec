package androidx.core.util;

import android.util.LongSparseArray;
import kotlin.Metadata;
import kotlin.collections.LongIterator;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001d\u0010\u0003\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"T", "Landroid/util/LongSparseArray;", "Lkotlin/collections/LongIterator;", "keyIterator", "(Landroid/util/LongSparseArray;)Lkotlin/collections/LongIterator;", "core-ktx_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class LongSparseArrayKt {
    public static final <T> LongIterator keyIterator(final LongSparseArray<T> longSparseArray) {
        return new LongIterator() { // from class: androidx.core.util.LongSparseArrayKt$keyIterator$1
            private int index;

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.index < longSparseArray.size();
            }

            @Override // kotlin.collections.LongIterator
            public long nextLong() {
                LongSparseArray<T> longSparseArray2 = longSparseArray;
                int i5 = this.index;
                this.index = i5 + 1;
                return longSparseArray2.keyAt(i5);
            }
        };
    }
}
