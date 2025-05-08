package androidx.compose.runtime;

import androidx.collection.MutableScatterMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import org.conscrypt.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0083@\u0018\u0000*\u0004\b\u0000\u0010\u0001*\b\b\u0001\u0010\u0003*\u00020\u00022\u00020\u0002B\u001b\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\r\u001a\u00020\n2\u0006\u0010\b\u001a\u00028\u00002\u0006\u0010\t\u001a\u00028\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u0010\u001a\u0004\u0018\u00018\u00012\u0006\u0010\b\u001a\u00028\u0000¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0014\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0018\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u001a\u0010\u001d\u001a\u00020\u001a2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0002HÖ\u0003¢\u0006\u0004\b\u001b\u0010\u001cR#\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001e\u001a\u0004\b\u001f\u0010 \u0088\u0001\u0005\u0092\u0001\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00020\u0004¨\u0006!"}, d2 = {"Landroidx/compose/runtime/MutableScatterMultiMap;", "K", BuildConfig.FLAVOR, "V", "Landroidx/collection/MutableScatterMap;", "map", "constructor-impl", "(Landroidx/collection/MutableScatterMap;)Landroidx/collection/MutableScatterMap;", "key", "value", BuildConfig.FLAVOR, "put-impl", "(Landroidx/collection/MutableScatterMap;Ljava/lang/Object;Ljava/lang/Object;)V", "put", "pop-impl", "(Landroidx/collection/MutableScatterMap;Ljava/lang/Object;)Ljava/lang/Object;", "pop", BuildConfig.FLAVOR, "toString-impl", "(Landroidx/collection/MutableScatterMap;)Ljava/lang/String;", "toString", BuildConfig.FLAVOR, "hashCode-impl", "(Landroidx/collection/MutableScatterMap;)I", "hashCode", "other", BuildConfig.FLAVOR, "equals-impl", "(Landroidx/collection/MutableScatterMap;Ljava/lang/Object;)Z", "equals", "Landroidx/collection/MutableScatterMap;", "getMap", "()Landroidx/collection/MutableScatterMap;", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class MutableScatterMultiMap<K, V> {
    private final MutableScatterMap<K, Object> map;

    private /* synthetic */ MutableScatterMultiMap(MutableScatterMap mutableScatterMap) {
        this.map = mutableScatterMap;
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ MutableScatterMultiMap m1216boximpl(MutableScatterMap mutableScatterMap) {
        return new MutableScatterMultiMap(mutableScatterMap);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static <K, V> MutableScatterMap<K, Object> m1217constructorimpl(MutableScatterMap<K, Object> mutableScatterMap) {
        return mutableScatterMap;
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m1218equalsimpl(MutableScatterMap<K, Object> mutableScatterMap, Object obj) {
        return (obj instanceof MutableScatterMultiMap) && Intrinsics.areEqual(mutableScatterMap, ((MutableScatterMultiMap) obj).getMap());
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m1219hashCodeimpl(MutableScatterMap<K, Object> mutableScatterMap) {
        return mutableScatterMap.hashCode();
    }

    /* renamed from: pop-impl, reason: not valid java name */
    public static final V m1220popimpl(MutableScatterMap<K, Object> mutableScatterMap, K k5) {
        V v5 = (V) mutableScatterMap.get(k5);
        if (v5 == null) {
            return null;
        }
        if (TypeIntrinsics.isMutableList(v5)) {
            List asMutableList = TypeIntrinsics.asMutableList(v5);
            Object remove = asMutableList.remove(0);
            if (asMutableList.isEmpty()) {
                mutableScatterMap.remove(k5);
            }
            v5 = (V) remove;
        } else {
            mutableScatterMap.remove(k5);
        }
        Intrinsics.checkNotNull(v5, "null cannot be cast to non-null type V of androidx.compose.runtime.MutableScatterMultiMap.pop_impl$lambda$1");
        return v5;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: put-impl, reason: not valid java name */
    public static final void m1221putimpl(MutableScatterMap<K, Object> mutableScatterMap, K k5, V v5) {
        int findInsertIndex = mutableScatterMap.findInsertIndex(k5);
        boolean z5 = findInsertIndex < 0;
        Object obj = z5 ? null : mutableScatterMap.values[findInsertIndex];
        if (obj != null) {
            if (TypeIntrinsics.isMutableList(obj)) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.MutableList<V of androidx.compose.runtime.MutableScatterMultiMap.put_impl$lambda$0>");
                List asMutableList = TypeIntrinsics.asMutableList(obj);
                asMutableList.add(v5);
                v5 = asMutableList;
            } else {
                v5 = (V) CollectionsKt.mutableListOf(obj, v5);
            }
        }
        if (!z5) {
            mutableScatterMap.values[findInsertIndex] = v5;
            return;
        }
        int i5 = ~findInsertIndex;
        mutableScatterMap.keys[i5] = k5;
        mutableScatterMap.values[i5] = v5;
    }

    /* renamed from: toString-impl, reason: not valid java name */
    public static String m1222toStringimpl(MutableScatterMap<K, Object> mutableScatterMap) {
        return "MutableScatterMultiMap(map=" + mutableScatterMap + ')';
    }

    public boolean equals(Object obj) {
        return m1218equalsimpl(this.map, obj);
    }

    public int hashCode() {
        return m1219hashCodeimpl(this.map);
    }

    public String toString() {
        return m1222toStringimpl(this.map);
    }

    /* renamed from: unbox-impl, reason: not valid java name and from getter */
    public final /* synthetic */ MutableScatterMap getMap() {
        return this.map;
    }
}
