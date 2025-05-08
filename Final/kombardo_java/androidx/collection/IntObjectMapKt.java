package androidx.collection;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0001\n\u0002\b\u0003\u001a\u0019\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0019\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001aI\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u00002\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00028\u00002\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00028\u00002\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00028\u0000¢\u0006\u0004\b\u0005\u0010\u000e\"\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"V", "Landroidx/collection/IntObjectMap;", "intObjectMapOf", "()Landroidx/collection/IntObjectMap;", "Landroidx/collection/MutableIntObjectMap;", "mutableIntObjectMapOf", "()Landroidx/collection/MutableIntObjectMap;", BuildConfig.FLAVOR, "key1", "value1", "key2", "value2", "key3", "value3", "(ILjava/lang/Object;ILjava/lang/Object;ILjava/lang/Object;)Landroidx/collection/MutableIntObjectMap;", BuildConfig.FLAVOR, "EmptyIntObjectMap", "Landroidx/collection/MutableIntObjectMap;", "collection"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class IntObjectMapKt {
    private static final MutableIntObjectMap EmptyIntObjectMap = new MutableIntObjectMap(0);

    public static final <V> IntObjectMap<V> intObjectMapOf() {
        MutableIntObjectMap mutableIntObjectMap = EmptyIntObjectMap;
        Intrinsics.checkNotNull(mutableIntObjectMap, "null cannot be cast to non-null type androidx.collection.IntObjectMap<V of androidx.collection.IntObjectMapKt.intObjectMapOf>");
        return mutableIntObjectMap;
    }

    public static final <V> MutableIntObjectMap<V> mutableIntObjectMapOf() {
        return new MutableIntObjectMap<>(0, 1, null);
    }

    public static final <V> MutableIntObjectMap<V> mutableIntObjectMapOf(int i5, V v5, int i6, V v6, int i7, V v7) {
        MutableIntObjectMap<V> mutableIntObjectMap = new MutableIntObjectMap<>(0, 1, null);
        mutableIntObjectMap.set(i5, v5);
        mutableIntObjectMap.set(i6, v6);
        mutableIntObjectMap.set(i7, v7);
        return mutableIntObjectMap;
    }
}
