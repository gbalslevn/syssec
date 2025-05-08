package androidx.compose.runtime.internal;

import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.CompositionLocalMapKt;
import androidx.compose.runtime.PersistentCompositionLocalMap;
import androidx.compose.runtime.ValueHolder;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap;
import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMap;
import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBuilder;
import androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode;
import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.MutabilityOwnership;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 \u00162\u001e\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00040\u00012\u00020\u0005:\u0002\u0017\u0016B3\u0012\"\u0010\u0007\u001a\u001e\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00040\u0006\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ$\u0010\u000e\u001a\u00028\u0000\"\u0004\b\u0000\u0010\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0096\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ/\u0010\u0011\u001a\u00020\u00052\u000e\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00022\u000e\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0004H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0014\u0010\u0015¨\u0006\u0018"}, d2 = {"Landroidx/compose/runtime/internal/PersistentCompositionLocalHashMap;", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/PersistentHashMap;", "Landroidx/compose/runtime/CompositionLocal;", BuildConfig.FLAVOR, "Landroidx/compose/runtime/ValueHolder;", "Landroidx/compose/runtime/PersistentCompositionLocalMap;", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;", "node", BuildConfig.FLAVOR, "size", "<init>", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;I)V", "T", "key", "get", "(Landroidx/compose/runtime/CompositionLocal;)Ljava/lang/Object;", "value", "putValue", "(Landroidx/compose/runtime/CompositionLocal;Landroidx/compose/runtime/ValueHolder;)Landroidx/compose/runtime/PersistentCompositionLocalMap;", "Landroidx/compose/runtime/internal/PersistentCompositionLocalHashMap$Builder;", "builder", "()Landroidx/compose/runtime/internal/PersistentCompositionLocalHashMap$Builder;", "Companion", "Builder", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class PersistentCompositionLocalHashMap extends PersistentHashMap<CompositionLocal<Object>, ValueHolder<Object>> implements PersistentCompositionLocalMap {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final PersistentCompositionLocalHashMap Empty;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u001e\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00040\u00012\u00020\u0005B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\n\u0010\u000bR\"\u0010\u0007\u001a\u00020\u00068\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\f\u001a\u0004\b\r\u0010\u000b\"\u0004\b\u000e\u0010\t¨\u0006\u000f"}, d2 = {"Landroidx/compose/runtime/internal/PersistentCompositionLocalHashMap$Builder;", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/PersistentHashMapBuilder;", "Landroidx/compose/runtime/CompositionLocal;", BuildConfig.FLAVOR, "Landroidx/compose/runtime/ValueHolder;", "Landroidx/compose/runtime/PersistentCompositionLocalMap$Builder;", "Landroidx/compose/runtime/internal/PersistentCompositionLocalHashMap;", "map", "<init>", "(Landroidx/compose/runtime/internal/PersistentCompositionLocalHashMap;)V", "build", "()Landroidx/compose/runtime/internal/PersistentCompositionLocalHashMap;", "Landroidx/compose/runtime/internal/PersistentCompositionLocalHashMap;", "getMap$runtime_release", "setMap$runtime_release", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Builder extends PersistentHashMapBuilder<CompositionLocal<Object>, ValueHolder<Object>> implements PersistentCompositionLocalMap.Builder {
        private PersistentCompositionLocalHashMap map;

        public Builder(PersistentCompositionLocalHashMap persistentCompositionLocalHashMap) {
            super(persistentCompositionLocalHashMap);
            this.map = persistentCompositionLocalHashMap;
        }

        public /* bridge */ boolean containsKey(CompositionLocal<Object> compositionLocal) {
            return super.containsKey((Builder) compositionLocal);
        }

        public /* bridge */ boolean containsValue(ValueHolder<Object> valueHolder) {
            return super.containsValue((Object) valueHolder);
        }

        public /* bridge */ ValueHolder<Object> get(CompositionLocal<Object> compositionLocal) {
            return (ValueHolder) super.get((Builder) compositionLocal);
        }

        public /* bridge */ ValueHolder<Object> getOrDefault(CompositionLocal<Object> compositionLocal, ValueHolder<Object> valueHolder) {
            return (ValueHolder) super.getOrDefault((Object) compositionLocal, (CompositionLocal<Object>) valueHolder);
        }

        public /* bridge */ ValueHolder<Object> remove(CompositionLocal<Object> compositionLocal) {
            return (ValueHolder) super.remove((Builder) compositionLocal);
        }

        @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBuilder, java.util.AbstractMap, java.util.Map
        public final /* bridge */ boolean containsKey(Object obj) {
            if (obj instanceof CompositionLocal) {
                return containsKey((CompositionLocal<Object>) obj);
            }
            return false;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public final /* bridge */ boolean containsValue(Object obj) {
            if (obj instanceof ValueHolder) {
                return containsValue((ValueHolder<Object>) obj);
            }
            return false;
        }

        @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBuilder, java.util.AbstractMap, java.util.Map
        public final /* bridge */ /* synthetic */ Object get(Object obj) {
            if (obj instanceof CompositionLocal) {
                return get((CompositionLocal<Object>) obj);
            }
            return null;
        }

        @Override // java.util.Map
        public final /* bridge */ /* synthetic */ Object getOrDefault(Object obj, Object obj2) {
            return !(obj instanceof CompositionLocal) ? obj2 : getOrDefault((CompositionLocal<Object>) obj, (ValueHolder<Object>) obj2);
        }

        @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBuilder, java.util.AbstractMap, java.util.Map
        public final /* bridge */ /* synthetic */ Object remove(Object obj) {
            if (obj instanceof CompositionLocal) {
                return remove((CompositionLocal<Object>) obj);
            }
            return null;
        }

        @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBuilder, androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap.Builder
        /* renamed from: build, reason: merged with bridge method [inline-methods] */
        public PersistentMap<CompositionLocal<Object>, ValueHolder<Object>> build2() {
            PersistentCompositionLocalHashMap persistentCompositionLocalHashMap;
            if (getNode$runtime_release() == this.map.getNode$runtime_release()) {
                persistentCompositionLocalHashMap = this.map;
            } else {
                setOwnership(new MutabilityOwnership());
                persistentCompositionLocalHashMap = new PersistentCompositionLocalHashMap(getNode$runtime_release(), size());
            }
            this.map = persistentCompositionLocalHashMap;
            return persistentCompositionLocalHashMap;
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001d\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u0012\u0004\b\t\u0010\u0003\u001a\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Landroidx/compose/runtime/internal/PersistentCompositionLocalHashMap$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "Landroidx/compose/runtime/internal/PersistentCompositionLocalHashMap;", "Empty", "Landroidx/compose/runtime/internal/PersistentCompositionLocalHashMap;", "getEmpty", "()Landroidx/compose/runtime/internal/PersistentCompositionLocalHashMap;", "getEmpty$annotations", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final PersistentCompositionLocalHashMap getEmpty() {
            return PersistentCompositionLocalHashMap.Empty;
        }

        private Companion() {
        }
    }

    static {
        TrieNode eMPTY$runtime_release = TrieNode.INSTANCE.getEMPTY$runtime_release();
        Intrinsics.checkNotNull(eMPTY$runtime_release, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode<androidx.compose.runtime.CompositionLocal<kotlin.Any?>, androidx.compose.runtime.ValueHolder<kotlin.Any?>>");
        Empty = new PersistentCompositionLocalHashMap(eMPTY$runtime_release, 0);
    }

    public PersistentCompositionLocalHashMap(TrieNode<CompositionLocal<Object>, ValueHolder<Object>> trieNode, int i5) {
        super(trieNode, i5);
    }

    public /* bridge */ boolean containsKey(CompositionLocal<Object> compositionLocal) {
        return super.containsKey((PersistentCompositionLocalHashMap) compositionLocal);
    }

    public /* bridge */ boolean containsValue(ValueHolder<Object> valueHolder) {
        return super.containsValue((Object) valueHolder);
    }

    @Override // androidx.compose.runtime.CompositionLocalMap
    public /* bridge */ ValueHolder<Object> get(CompositionLocal<Object> compositionLocal) {
        return (ValueHolder) super.get((PersistentCompositionLocalHashMap) compositionLocal);
    }

    public /* bridge */ ValueHolder<Object> getOrDefault(CompositionLocal<Object> compositionLocal, ValueHolder<Object> valueHolder) {
        return (ValueHolder) super.getOrDefault((Object) compositionLocal, (CompositionLocal<Object>) valueHolder);
    }

    @Override // androidx.compose.runtime.PersistentCompositionLocalMap
    public PersistentCompositionLocalMap putValue(CompositionLocal<Object> key, ValueHolder<Object> value) {
        TrieNode.ModificationResult<CompositionLocal<Object>, ValueHolder<Object>> put = getNode$runtime_release().put(key.hashCode(), key, value, 0);
        return put == null ? this : new PersistentCompositionLocalHashMap(put.getNode(), size() + put.getSizeDelta());
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMap, java.util.Map
    public final /* bridge */ boolean containsKey(Object obj) {
        if (obj instanceof CompositionLocal) {
            return containsKey((CompositionLocal<Object>) obj);
        }
        return false;
    }

    @Override // kotlin.collections.AbstractMap, java.util.Map
    public final /* bridge */ boolean containsValue(Object obj) {
        if (obj instanceof ValueHolder) {
            return containsValue((ValueHolder<Object>) obj);
        }
        return false;
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMap, java.util.Map
    public final /* bridge */ /* synthetic */ Object get(Object obj) {
        if (obj instanceof CompositionLocal) {
            return get((CompositionLocal<Object>) obj);
        }
        return null;
    }

    @Override // java.util.Map
    public final /* bridge */ /* synthetic */ Object getOrDefault(Object obj, Object obj2) {
        return !(obj instanceof CompositionLocal) ? obj2 : getOrDefault((CompositionLocal<Object>) obj, (ValueHolder<Object>) obj2);
    }

    @Override // androidx.compose.runtime.CompositionLocalMap
    public <T> T get(CompositionLocal<T> key) {
        return (T) CompositionLocalMapKt.read(this, key);
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMap, androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap
    /* renamed from: builder, reason: merged with bridge method [inline-methods] */
    public PersistentMap.Builder<CompositionLocal<Object>, ValueHolder<Object>> builder2() {
        return new Builder(this);
    }
}
