package kotlin.collections;

import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\f\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0005\u001a3\u0010\u0006\u001a\u00028\u0001\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00022\u0006\u0010\u0003\u001a\u00028\u0000H\u0001¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, d2 = {"K", "V", BuildConfig.FLAVOR, "key", "getOrImplicitDefaultNullable", "(Ljava/util/Map;Ljava/lang/Object;)Ljava/lang/Object;", "getOrImplicitDefault", "kotlin-stdlib"}, k = 5, mv = {2, 1, 0}, xi = 49, xs = "kotlin/collections/MapsKt")
/* loaded from: classes2.dex */
abstract class MapsKt__MapWithDefaultKt {
    public static final <K, V> V getOrImplicitDefaultNullable(Map<K, ? extends V> map, K k5) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        if (map instanceof MapWithDefault) {
            return (V) ((MapWithDefault) map).getOrImplicitDefault(k5);
        }
        V v5 = map.get(k5);
        if (v5 != null || map.containsKey(k5)) {
            return v5;
        }
        throw new NoSuchElementException("Key " + k5 + " is missing in the map.");
    }
}
