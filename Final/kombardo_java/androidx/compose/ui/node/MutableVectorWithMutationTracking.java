package androidx.compose.ui.node;

import androidx.compose.runtime.collection.MutableVector;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\r\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B#\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\b\u0010\tJ\r\u0010\n\u001a\u00020\u0006¢\u0006\u0004\b\n\u0010\u000bJ\u001d\u0010\u000f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00028\u0000¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0011\u001a\u00028\u00002\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u0011\u0010\u0012J\u0013\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0013¢\u0006\u0004\b\u0014\u0010\u0015J\u0018\u0010\u0016\u001a\u00028\u00002\u0006\u0010\r\u001a\u00020\fH\u0086\u0002¢\u0006\u0004\b\u0016\u0010\u0012R\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001d\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u001f\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001e¨\u0006 "}, d2 = {"Landroidx/compose/ui/node/MutableVectorWithMutationTracking;", "T", BuildConfig.FLAVOR, "Landroidx/compose/runtime/collection/MutableVector;", "vector", "Lkotlin/Function0;", BuildConfig.FLAVOR, "onVectorMutated", "<init>", "(Landroidx/compose/runtime/collection/MutableVector;Lkotlin/jvm/functions/Function0;)V", "clear", "()V", BuildConfig.FLAVOR, "index", "element", "add", "(ILjava/lang/Object;)V", "removeAt", "(I)Ljava/lang/Object;", BuildConfig.FLAVOR, "asList", "()Ljava/util/List;", "get", "Landroidx/compose/runtime/collection/MutableVector;", "getVector", "()Landroidx/compose/runtime/collection/MutableVector;", "Lkotlin/jvm/functions/Function0;", "getOnVectorMutated", "()Lkotlin/jvm/functions/Function0;", "getSize", "()I", "size", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class MutableVectorWithMutationTracking<T> {
    public static final int $stable = MutableVector.$stable;
    private final Function0<Unit> onVectorMutated;
    private final MutableVector<T> vector;

    public MutableVectorWithMutationTracking(MutableVector<T> mutableVector, Function0<Unit> function0) {
        this.vector = mutableVector;
        this.onVectorMutated = function0;
    }

    public final void add(int index, T element) {
        this.vector.add(index, element);
        this.onVectorMutated.invoke();
    }

    public final List<T> asList() {
        return this.vector.asMutableList();
    }

    public final void clear() {
        this.vector.clear();
        this.onVectorMutated.invoke();
    }

    public final T get(int index) {
        return this.vector.getContent()[index];
    }

    public final int getSize() {
        return this.vector.getSize();
    }

    public final MutableVector<T> getVector() {
        return this.vector;
    }

    public final T removeAt(int index) {
        T removeAt = this.vector.removeAt(index);
        this.onVectorMutated.invoke();
        return removeAt;
    }
}
