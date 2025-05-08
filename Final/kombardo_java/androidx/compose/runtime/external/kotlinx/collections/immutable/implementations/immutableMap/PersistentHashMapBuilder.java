package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap;

import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap;
import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.DeltaCounter;
import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.MutabilityOwnership;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.AbstractMutableMap;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010#\n\u0002\u0010'\n\u0002\b\u0005\n\u0002\u0010\u001f\n\u0002\b\u0004\b\u0010\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00032\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004B\u001b\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u001b\u0010\t\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u000f\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u000b\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0004\b\u000f\u0010\u0010J!\u0010\u0012\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u000b\u001a\u00028\u00002\u0006\u0010\u0011\u001a\u00028\u0001H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J%\u0010\u0017\u001a\u00020\u00162\u0014\u0010\u0015\u001a\u0010\u0012\u0006\b\u0001\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0014H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0019\u0010\u0019\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u000b\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u0019\u0010\u0010J\u001d\u0010\u0019\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00028\u00002\u0006\u0010\u0011\u001a\u00028\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u001b\u0010\u001cR\"\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u001dR*\u0010 \u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001e8\u0006@DX\u0086\u000e¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R.\u0010'\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010&8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R$\u0010-\u001a\u0004\u0018\u00018\u00018\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b-\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\"\u00104\u001a\u0002038\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b4\u00105\u001a\u0004\b6\u00107\"\u0004\b8\u00109R*\u0010:\u001a\u0002032\u0006\u0010\u0011\u001a\u0002038\u0016@VX\u0096\u000e¢\u0006\u0012\n\u0004\b:\u00105\u001a\u0004\b;\u00107\"\u0004\b<\u00109R&\u0010A\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010>0=8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b?\u0010@R\u001a\u0010C\u001a\b\u0012\u0004\u0012\u00028\u00000=8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bB\u0010@R\u001a\u0010G\u001a\b\u0012\u0004\u0012\u00028\u00010D8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bE\u0010F¨\u0006H"}, d2 = {"Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/PersistentHashMapBuilder;", "K", "V", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentMap$Builder;", "Lkotlin/collections/AbstractMutableMap;", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/PersistentHashMap;", "map", "<init>", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/PersistentHashMap;)V", "build", "()Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/PersistentHashMap;", "key", BuildConfig.FLAVOR, "containsKey", "(Ljava/lang/Object;)Z", "get", "(Ljava/lang/Object;)Ljava/lang/Object;", "value", "put", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", BuildConfig.FLAVOR, "from", BuildConfig.FLAVOR, "putAll", "(Ljava/util/Map;)V", "remove", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "clear", "()V", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/PersistentHashMap;", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/internal/MutabilityOwnership;", "<set-?>", "ownership", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/internal/MutabilityOwnership;", "getOwnership", "()Landroidx/compose/runtime/external/kotlinx/collections/immutable/internal/MutabilityOwnership;", "setOwnership", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/internal/MutabilityOwnership;)V", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;", "node", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;", "getNode$runtime_release", "()Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;", "setNode$runtime_release", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;)V", "operationResult", "Ljava/lang/Object;", "getOperationResult$runtime_release", "()Ljava/lang/Object;", "setOperationResult$runtime_release", "(Ljava/lang/Object;)V", BuildConfig.FLAVOR, "modCount", "I", "getModCount$runtime_release", "()I", "setModCount$runtime_release", "(I)V", "size", "getSize", "setSize", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "getEntries", "()Ljava/util/Set;", "entries", "getKeys", "keys", BuildConfig.FLAVOR, "getValues", "()Ljava/util/Collection;", "values", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public class PersistentHashMapBuilder<K, V> extends AbstractMutableMap<K, V> implements PersistentMap.Builder<K, V> {
    private PersistentHashMap<K, V> map;
    private int modCount;
    private TrieNode<K, V> node;
    private V operationResult;
    private MutabilityOwnership ownership = new MutabilityOwnership();
    private int size;

    public PersistentHashMapBuilder(PersistentHashMap<K, V> persistentHashMap) {
        this.map = persistentHashMap;
        this.node = this.map.getNode$runtime_release();
        this.size = this.map.size();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        TrieNode<K, V> eMPTY$runtime_release = TrieNode.INSTANCE.getEMPTY$runtime_release();
        Intrinsics.checkNotNull(eMPTY$runtime_release, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode<K of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBuilder, V of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBuilder>");
        this.node = eMPTY$runtime_release;
        setSize(0);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(K key) {
        return this.node.containsKey(key != null ? key.hashCode() : 0, key, 0);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V get(K key) {
        return this.node.get(key != null ? key.hashCode() : 0, key, 0);
    }

    @Override // kotlin.collections.AbstractMutableMap
    public Set<Map.Entry<K, V>> getEntries() {
        return new PersistentHashMapBuilderEntries(this);
    }

    @Override // kotlin.collections.AbstractMutableMap
    public Set<K> getKeys() {
        return new PersistentHashMapBuilderKeys(this);
    }

    /* renamed from: getModCount$runtime_release, reason: from getter */
    public final int getModCount() {
        return this.modCount;
    }

    public final TrieNode<K, V> getNode$runtime_release() {
        return this.node;
    }

    public final MutabilityOwnership getOwnership() {
        return this.ownership;
    }

    @Override // kotlin.collections.AbstractMutableMap
    public int getSize() {
        return this.size;
    }

    @Override // kotlin.collections.AbstractMutableMap
    public Collection<V> getValues() {
        return new PersistentHashMapBuilderValues(this);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V put(K key, V value) {
        this.operationResult = null;
        this.node = this.node.mutablePut(key != null ? key.hashCode() : 0, key, value, 0, this);
        return this.operationResult;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void putAll(Map<? extends K, ? extends V> from) {
        PersistentHashMap<K, V> persistentHashMap = from instanceof PersistentHashMap ? (PersistentHashMap) from : null;
        if (persistentHashMap == null) {
            PersistentHashMapBuilder persistentHashMapBuilder = from instanceof PersistentHashMapBuilder ? (PersistentHashMapBuilder) from : null;
            persistentHashMap = persistentHashMapBuilder != null ? persistentHashMapBuilder.build2() : null;
        }
        if (persistentHashMap == null) {
            super.putAll(from);
            return;
        }
        DeltaCounter deltaCounter = new DeltaCounter(0, 1, null);
        int size = size();
        TrieNode<K, V> trieNode = this.node;
        TrieNode<K, V> node$runtime_release = persistentHashMap.getNode$runtime_release();
        Intrinsics.checkNotNull(node$runtime_release, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode<K of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBuilder, V of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBuilder>");
        this.node = trieNode.mutablePutAll(node$runtime_release, 0, deltaCounter, this);
        int size2 = (persistentHashMap.size() + size) - deltaCounter.getCount();
        if (size != size2) {
            setSize(size2);
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(K key) {
        this.operationResult = null;
        TrieNode mutableRemove = this.node.mutableRemove(key != null ? key.hashCode() : 0, key, 0, this);
        if (mutableRemove == null) {
            mutableRemove = TrieNode.INSTANCE.getEMPTY$runtime_release();
            Intrinsics.checkNotNull(mutableRemove, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode<K of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBuilder, V of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBuilder>");
        }
        this.node = mutableRemove;
        return this.operationResult;
    }

    public final void setModCount$runtime_release(int i5) {
        this.modCount = i5;
    }

    public final void setOperationResult$runtime_release(V v5) {
        this.operationResult = v5;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void setOwnership(MutabilityOwnership mutabilityOwnership) {
        this.ownership = mutabilityOwnership;
    }

    public void setSize(int i5) {
        this.size = i5;
        this.modCount++;
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap.Builder
    /* renamed from: build */
    public PersistentHashMap<K, V> build2() {
        PersistentHashMap<K, V> persistentHashMap;
        if (this.node == this.map.getNode$runtime_release()) {
            persistentHashMap = this.map;
        } else {
            this.ownership = new MutabilityOwnership();
            persistentHashMap = new PersistentHashMap<>(this.node, size());
        }
        this.map = persistentHashMap;
        return persistentHashMap;
    }

    @Override // java.util.Map
    public final boolean remove(Object key, Object value) {
        int size = size();
        TrieNode mutableRemove = this.node.mutableRemove(key != null ? key.hashCode() : 0, key, value, 0, this);
        if (mutableRemove == null) {
            mutableRemove = TrieNode.INSTANCE.getEMPTY$runtime_release();
            Intrinsics.checkNotNull(mutableRemove, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode<K of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBuilder, V of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.PersistentHashMapBuilder>");
        }
        this.node = mutableRemove;
        return size != size();
    }
}
