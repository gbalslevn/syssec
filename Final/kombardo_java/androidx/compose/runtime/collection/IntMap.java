package androidx.compose.runtime.collection;

import android.util.SparseArray;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0017\b\u0002\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003¢\u0006\u0004\b\u0005\u0010\u0006B\u0013\b\u0016\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u0005\u0010\tJ\u001a\u0010\u000b\u001a\u0004\u0018\u00018\u00002\u0006\u0010\n\u001a\u00020\u0007H\u0086\u0002¢\u0006\u0004\b\u000b\u0010\fJ \u0010\u000f\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\r\u001a\u00028\u0000H\u0086\u0002¢\u0006\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0011¨\u0006\u0012"}, d2 = {"Landroidx/compose/runtime/collection/IntMap;", "E", BuildConfig.FLAVOR, "Landroid/util/SparseArray;", "sparseArray", "<init>", "(Landroid/util/SparseArray;)V", BuildConfig.FLAVOR, "initialCapacity", "(I)V", "key", "get", "(I)Ljava/lang/Object;", "value", BuildConfig.FLAVOR, "set", "(ILjava/lang/Object;)V", "Landroid/util/SparseArray;", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class IntMap<E> {
    private final SparseArray<E> sparseArray;

    private IntMap(SparseArray<E> sparseArray) {
        this.sparseArray = sparseArray;
    }

    public final E get(int key) {
        return this.sparseArray.get(key);
    }

    public final void set(int key, E value) {
        this.sparseArray.put(key, value);
    }

    public IntMap(int i5) {
        this(new SparseArray(i5));
    }

    public /* synthetic */ IntMap(int i5, int i6, DefaultConstructorMarker defaultConstructorMarker) {
        this((i6 & 1) != 0 ? 10 : i5);
    }
}
