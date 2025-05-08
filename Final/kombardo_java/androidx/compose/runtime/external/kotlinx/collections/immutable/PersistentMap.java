package androidx.compose.runtime.external.kotlinx.collections.immutable;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.jvm.internal.markers.KMutableMap;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b`\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0006\b\u0001\u0010\u0002 \u00012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0003:\u0001\u0007J\u001b\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004H&¢\u0006\u0004\b\u0005\u0010\u0006ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\bÀ\u0006\u0001"}, d2 = {"Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentMap;", "K", "V", BuildConfig.FLAVOR, "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentMap$Builder;", "builder", "()Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentMap$Builder;", "Builder", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public interface PersistentMap<K, V> extends Map, KMappedMarker {

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0004\b\u0003\u0010\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0003J\u0014\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0005H&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0006À\u0006\u0001"}, d2 = {"Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentMap$Builder;", "K", "V", BuildConfig.FLAVOR, "build", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentMap;", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public interface Builder<K, V> extends Map<K, V>, KMutableMap {
        PersistentMap<K, V> build();
    }

    Builder<K, V> builder();
}
