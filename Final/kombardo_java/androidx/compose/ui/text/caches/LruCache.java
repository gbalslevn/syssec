package androidx.compose.ui.text.caches;

import androidx.compose.ui.text.platform.Synchronization_jvmKt;
import androidx.compose.ui.text.platform.SynchronizedObject;
import java.util.HashMap;
import java.util.LinkedHashSet;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\b\u0010\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003B\u0011\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\n\u001a\u00020\u00042\u0006\u0010\b\u001a\u00028\u00002\u0006\u0010\t\u001a\u00028\u0001H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\f\u001a\u0004\u0018\u00018\u00012\u0006\u0010\b\u001a\u00028\u0000¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u000e\u001a\u0004\u0018\u00018\u00012\u0006\u0010\b\u001a\u00028\u00002\u0006\u0010\t\u001a\u00028\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0011\u0010\u0007J\u0017\u0010\u0012\u001a\u0004\u0018\u00018\u00012\u0006\u0010\b\u001a\u00028\u0000¢\u0006\u0004\b\u0012\u0010\rJ1\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\b\u001a\u00028\u00002\u0006\u0010\u0015\u001a\u00028\u00012\b\u0010\u0016\u001a\u0004\u0018\u00018\u0001H\u0014¢\u0006\u0004\b\u0017\u0010\u0018J\u0019\u0010\u0019\u001a\u0004\u0018\u00018\u00012\u0006\u0010\b\u001a\u00028\u0000H\u0014¢\u0006\u0004\b\u0019\u0010\rJ\u001f\u0010\u001a\u001a\u00020\u00042\u0006\u0010\b\u001a\u00028\u00002\u0006\u0010\t\u001a\u00028\u0001H\u0014¢\u0006\u0004\b\u001a\u0010\u000bJ\u000f\u0010\u001c\u001a\u00020\u001bH\u0016¢\u0006\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001f\u001a\u00020\u001e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R0\u0010#\u001a\u001e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010!j\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001`\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010$R$\u0010'\u001a\u0012\u0012\u0004\u0012\u00028\u00000%j\b\u0012\u0004\u0012\u00028\u0000`&8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010(R$\u0010*\u001a\u00020\u00042\u0006\u0010)\u001a\u00020\u00048G@BX\u0086\u000e¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b*\u0010,R\u0016\u0010\u0005\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010+R\u0016\u0010-\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010+R\u0016\u0010.\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010+R\u0016\u0010/\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u0010+R\u0016\u00100\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u0010+R\u0016\u00101\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b1\u0010+¨\u00062"}, d2 = {"Landroidx/compose/ui/text/caches/LruCache;", "K", "V", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "maxSize", "<init>", "(I)V", "key", "value", "safeSizeOf", "(Ljava/lang/Object;Ljava/lang/Object;)I", "get", "(Ljava/lang/Object;)Ljava/lang/Object;", "put", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", BuildConfig.FLAVOR, "trimToSize", "remove", BuildConfig.FLAVOR, "evicted", "oldValue", "newValue", "entryRemoved", "(ZLjava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V", "create", "sizeOf", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", "Landroidx/compose/ui/text/platform/SynchronizedObject;", "monitor", "Landroidx/compose/ui/text/platform/SynchronizedObject;", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "map", "Ljava/util/HashMap;", "Ljava/util/LinkedHashSet;", "Lkotlin/collections/LinkedHashSet;", "keySet", "Ljava/util/LinkedHashSet;", "<set-?>", "size", "I", "()I", "putCount", "createCount", "evictionCount", "hitCount", "missCount", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public class LruCache<K, V> {
    private int createCount;
    private int evictionCount;
    private int hitCount;
    private final LinkedHashSet<K> keySet;
    private final HashMap<K, V> map;
    private int maxSize;
    private int missCount;
    private final SynchronizedObject monitor = Synchronization_jvmKt.createSynchronizedObject();
    private int putCount;
    private int size;

    public LruCache(int i5) {
        if (i5 <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        this.maxSize = i5;
        this.map = new HashMap<>(0, 0.75f);
        this.keySet = new LinkedHashSet<>();
    }

    private final int safeSizeOf(K key, V value) {
        int sizeOf = sizeOf(key, value);
        if (sizeOf >= 0) {
            return sizeOf;
        }
        throw new IllegalStateException(("Negative size: " + key + '=' + value).toString());
    }

    protected V create(K key) {
        return null;
    }

    protected void entryRemoved(boolean evicted, K key, V oldValue, V newValue) {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final V get(K key) {
        synchronized (this.monitor) {
            V v5 = this.map.get(key);
            if (v5 != null) {
                this.keySet.remove(key);
                this.keySet.add(key);
                this.hitCount++;
                return v5;
            }
            this.missCount++;
            V create = create(key);
            if (create == null) {
                return null;
            }
            synchronized (this.monitor) {
                try {
                    this.createCount++;
                    Object put = this.map.put(key, create);
                    this.keySet.remove(key);
                    this.keySet.add(key);
                    if (put != 0) {
                        this.map.put(key, put);
                        v5 = put;
                    } else {
                        this.size = size() + safeSizeOf(key, create);
                    }
                    Unit unit = Unit.INSTANCE;
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (v5 != null) {
                entryRemoved(false, key, create, v5);
                return v5;
            }
            trimToSize(this.maxSize);
            return create;
        }
    }

    public final V put(K key, V value) {
        V put;
        if (key == null || value == null) {
            throw null;
        }
        synchronized (this.monitor) {
            try {
                this.putCount++;
                this.size = size() + safeSizeOf(key, value);
                put = this.map.put(key, value);
                if (put != null) {
                    this.size = size() - safeSizeOf(key, put);
                }
                if (this.keySet.contains(key)) {
                    this.keySet.remove(key);
                }
                this.keySet.add(key);
            } catch (Throwable th) {
                throw th;
            }
        }
        if (put != null) {
            entryRemoved(false, key, put, value);
        }
        trimToSize(this.maxSize);
        return put;
    }

    public final V remove(K key) {
        V remove;
        key.getClass();
        synchronized (this.monitor) {
            try {
                remove = this.map.remove(key);
                this.keySet.remove(key);
                if (remove != null) {
                    this.size = size() - safeSizeOf(key, remove);
                }
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                throw th;
            }
        }
        if (remove != null) {
            entryRemoved(false, key, remove, null);
        }
        return remove;
    }

    public final int size() {
        int i5;
        synchronized (this.monitor) {
            i5 = this.size;
        }
        return i5;
    }

    protected int sizeOf(K key, V value) {
        return 1;
    }

    public String toString() {
        String str;
        synchronized (this.monitor) {
            try {
                int i5 = this.hitCount;
                int i6 = this.missCount + i5;
                str = "LruCache[maxSize=" + this.maxSize + ",hits=" + this.hitCount + ",misses=" + this.missCount + ",hitRate=" + (i6 != 0 ? (i5 * 100) / i6 : 0) + "%]";
            } catch (Throwable th) {
                throw th;
            }
        }
        return str;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0094, code lost:
    
        throw new java.lang.IllegalStateException("map/keySet size inconsistency");
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void trimToSize(int maxSize) {
        Object obj;
        V v5;
        while (true) {
            synchronized (this.monitor) {
                try {
                    if (size() >= 0) {
                        if (this.map.isEmpty() && size() != 0) {
                            break;
                        }
                        if (this.map.isEmpty() != this.keySet.isEmpty()) {
                            break;
                        }
                        if (size() <= maxSize || this.map.isEmpty()) {
                            obj = null;
                            v5 = null;
                        } else {
                            obj = CollectionsKt.first(this.keySet);
                            v5 = this.map.get(obj);
                            if (v5 == null) {
                                throw new IllegalStateException("inconsistent state");
                            }
                            TypeIntrinsics.asMutableMap(this.map).remove(obj);
                            TypeIntrinsics.asMutableCollection(this.keySet).remove(obj);
                            int size = size();
                            Intrinsics.checkNotNull(obj);
                            Intrinsics.checkNotNull(v5);
                            this.size = size - safeSizeOf(obj, v5);
                            this.evictionCount++;
                        }
                        Unit unit = Unit.INSTANCE;
                    } else {
                        break;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (obj == null && v5 == null) {
                return;
            }
            Intrinsics.checkNotNull(obj);
            Intrinsics.checkNotNull(v5);
            entryRemoved(true, obj, v5, null);
        }
    }
}
