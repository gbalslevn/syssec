package androidx.collection;

import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0003\u001a\u0019\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a)\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0004\u001a\u00028\u00002\u0006\u0010\u0005\u001a\u00028\u0000¢\u0006\u0004\b\u0002\u0010\u0006\"\u001c\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"E", "Landroidx/collection/MutableScatterSet;", "mutableScatterSetOf", "()Landroidx/collection/MutableScatterSet;", "element1", "element2", "(Ljava/lang/Object;Ljava/lang/Object;)Landroidx/collection/MutableScatterSet;", BuildConfig.FLAVOR, "EmptyScatterSet", "Landroidx/collection/MutableScatterSet;", "collection"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class ScatterSetKt {
    private static final MutableScatterSet<Object> EmptyScatterSet = new MutableScatterSet<>(0);

    public static final <E> MutableScatterSet<E> mutableScatterSetOf() {
        return new MutableScatterSet<>(0, 1, null);
    }

    public static final <E> MutableScatterSet<E> mutableScatterSetOf(E e5, E e6) {
        MutableScatterSet<E> mutableScatterSet = new MutableScatterSet<>(2);
        mutableScatterSet.plusAssign((MutableScatterSet<E>) e5);
        mutableScatterSet.plusAssign((MutableScatterSet<E>) e6);
        return mutableScatterSet;
    }
}
