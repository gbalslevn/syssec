package androidx.compose.runtime;

import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000 \n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u001a;\u0010\u0005\u001a\u0004\u0018\u00018\u0001\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00030\u00022\u0006\u0010\u0004\u001a\u00028\u0000H\u0000¢\u0006\u0004\b\u0005\u0010\u0006\"\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082T¢\u0006\u0006\n\u0004\b\b\u0010\t\"\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f\"\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\f¨\u0006\u000e"}, d2 = {"K", "V", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "key", "removeLastMultiValue", "(Ljava/util/Map;Ljava/lang/Object;)Ljava/lang/Object;", BuildConfig.FLAVOR, "RecomposerCompoundHashKey", "I", BuildConfig.FLAVOR, "ProduceAnotherFrame", "Ljava/lang/Object;", "FramePending", "runtime_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class RecomposerKt {
    private static final int RecomposerCompoundHashKey = 1000;
    private static final Object ProduceAnotherFrame = new Object();
    private static final Object FramePending = new Object();

    public static final <K, V> V removeLastMultiValue(Map<K, List<V>> map, K k5) {
        List<V> list = map.get(k5);
        if (list == null) {
            return null;
        }
        V v5 = (V) CollectionsKt.removeFirst(list);
        if (!list.isEmpty()) {
            return v5;
        }
        map.remove(k5);
        return v5;
    }
}
