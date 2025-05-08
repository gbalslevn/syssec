package androidx.collection;

import androidx.collection.internal.Lock;
import androidx.collection.internal.LruHashMap;
import androidx.collection.internal.RuntimeHelpersKt;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0003*\u00020\u00012\u00020\u0001B\u0011\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\n\u001a\u00020\u00042\u0006\u0010\b\u001a\u00028\u00002\u0006\u0010\t\u001a\u00028\u0001H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\f\u001a\u0004\u0018\u00018\u00012\u0006\u0010\b\u001a\u00028\u0000H\u0086\u0002¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u000e\u001a\u0004\u0018\u00018\u00012\u0006\u0010\b\u001a\u00028\u00002\u0006\u0010\t\u001a\u00028\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0011\u0010\u0007J\u0017\u0010\u0012\u001a\u0004\u0018\u00018\u00012\u0006\u0010\b\u001a\u00028\u0000¢\u0006\u0004\b\u0012\u0010\rJ1\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\b\u001a\u00028\u00002\u0006\u0010\u0015\u001a\u00028\u00012\b\u0010\u0016\u001a\u0004\u0018\u00018\u0001H\u0014¢\u0006\u0004\b\u0017\u0010\u0018J\u0019\u0010\u0019\u001a\u0004\u0018\u00018\u00012\u0006\u0010\b\u001a\u00028\u0000H\u0014¢\u0006\u0004\b\u0019\u0010\rJ\u001f\u0010\u001a\u001a\u00020\u00042\u0006\u0010\b\u001a\u00028\u00002\u0006\u0010\t\u001a\u00028\u0001H\u0014¢\u0006\u0004\b\u001a\u0010\u000bJ\r\u0010\u001b\u001a\u00020\u0010¢\u0006\u0004\b\u001b\u0010\u001cJ\r\u0010\u001d\u001a\u00020\u0004¢\u0006\u0004\b\u001d\u0010\u001eJ\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u001eJ\u0019\u0010 \u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u001f¢\u0006\u0004\b \u0010!J\u000f\u0010#\u001a\u00020\"H\u0016¢\u0006\u0004\b#\u0010$R\u0016\u0010\u0005\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010%R \u0010'\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010&8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u0014\u0010*\u001a\u00020)8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010\u001d\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010%R\u0016\u0010,\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010%R\u0016\u0010-\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010%R\u0016\u0010.\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010%R\u0016\u0010/\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b/\u0010%R\u0016\u00100\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u0010%¨\u00061"}, d2 = {"Landroidx/collection/LruCache;", BuildConfig.FLAVOR, "K", "V", BuildConfig.FLAVOR, "maxSize", "<init>", "(I)V", "key", "value", "safeSizeOf", "(Ljava/lang/Object;Ljava/lang/Object;)I", "get", "(Ljava/lang/Object;)Ljava/lang/Object;", "put", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", BuildConfig.FLAVOR, "trimToSize", "remove", BuildConfig.FLAVOR, "evicted", "oldValue", "newValue", "entryRemoved", "(ZLjava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V", "create", "sizeOf", "evictAll", "()V", "size", "()I", BuildConfig.FLAVOR, "snapshot", "()Ljava/util/Map;", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", "I", "Landroidx/collection/internal/LruHashMap;", "map", "Landroidx/collection/internal/LruHashMap;", "Landroidx/collection/internal/Lock;", "lock", "Landroidx/collection/internal/Lock;", "putCount", "createCount", "evictionCount", "hitCount", "missCount", "collection"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public class LruCache<K, V> {
    private int createCount;
    private int evictionCount;
    private int hitCount;
    private final Lock lock;
    private final LruHashMap<K, V> map;
    private int maxSize;
    private int missCount;
    private int putCount;
    private int size;

    public LruCache(int i5) {
        this.maxSize = i5;
        if (!(i5 > 0)) {
            RuntimeHelpersKt.throwIllegalArgumentException("maxSize <= 0");
        }
        this.map = new LruHashMap<>(0, 0.75f);
        this.lock = new Lock();
    }

    private final int safeSizeOf(K key, V value) {
        int sizeOf = sizeOf(key, value);
        if (!(sizeOf >= 0)) {
            RuntimeHelpersKt.throwIllegalStateException("Negative size: " + key + '=' + value);
        }
        return sizeOf;
    }

    protected V create(K key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return null;
    }

    protected void entryRemoved(boolean evicted, K key, V oldValue, V newValue) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(oldValue, "oldValue");
    }

    public final void evictAll() {
        trimToSize(-1);
    }

    public final V get(K key) {
        V v5;
        Intrinsics.checkNotNullParameter(key, "key");
        synchronized (this.lock) {
            V v6 = this.map.get(key);
            if (v6 != null) {
                this.hitCount++;
                return v6;
            }
            this.missCount++;
            V create = create(key);
            if (create == null) {
                return null;
            }
            synchronized (this.lock) {
                try {
                    this.createCount++;
                    v5 = (V) this.map.put(key, create);
                    if (v5 != null) {
                        this.map.put(key, v5);
                    } else {
                        this.size += safeSizeOf(key, create);
                        Unit unit = Unit.INSTANCE;
                    }
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

    public final int maxSize() {
        int i5;
        synchronized (this.lock) {
            i5 = this.maxSize;
        }
        return i5;
    }

    public final V put(K key, V value) {
        V put;
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        synchronized (this.lock) {
            try {
                this.putCount++;
                this.size += safeSizeOf(key, value);
                put = this.map.put(key, value);
                if (put != null) {
                    this.size -= safeSizeOf(key, put);
                }
                Unit unit = Unit.INSTANCE;
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
        Intrinsics.checkNotNullParameter(key, "key");
        synchronized (this.lock) {
            try {
                remove = this.map.remove(key);
                if (remove != null) {
                    this.size -= safeSizeOf(key, remove);
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
        synchronized (this.lock) {
            i5 = this.size;
        }
        return i5;
    }

    protected int sizeOf(K key, V value) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(value, "value");
        return 1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Map<K, V> snapshot() {
        LinkedHashMap linkedHashMap;
        synchronized (this.lock) {
            linkedHashMap = new LinkedHashMap(this.map.getEntries().size());
            Iterator<T> it = this.map.getEntries().iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return linkedHashMap;
    }

    public String toString() {
        String str;
        synchronized (this.lock) {
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

    /* JADX WARN: Code restructure failed: missing block: B:30:0x0062, code lost:
    
        return;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:13:0x001c A[Catch: all -> 0x0015, TryCatch #0 {all -> 0x0015, blocks: (B:4:0x0003, B:6:0x0008, B:8:0x0010, B:13:0x001c, B:14:0x0021, B:16:0x0025, B:18:0x002e, B:20:0x0040), top: B:3:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0040 A[Catch: all -> 0x0015, TRY_ENTER, TRY_LEAVE, TryCatch #0 {all -> 0x0015, blocks: (B:4:0x0003, B:6:0x0008, B:8:0x0010, B:13:0x001c, B:14:0x0021, B:16:0x0025, B:18:0x002e, B:20:0x0040), top: B:3:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x003e A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void trimToSize(int maxSize) {
        boolean z5;
        Map.Entry entry;
        Object key;
        Object value;
        while (true) {
            synchronized (this.lock) {
                try {
                    if (this.size < 0 || (this.map.isEmpty() && this.size != 0)) {
                        z5 = false;
                        if (!z5) {
                            RuntimeHelpersKt.throwIllegalStateException("LruCache.sizeOf() is reporting inconsistent results!");
                        }
                        if (this.size > maxSize || this.map.isEmpty()) {
                            break;
                        }
                        entry = (Map.Entry) CollectionsKt.firstOrNull(this.map.getEntries());
                        if (entry != null) {
                            return;
                        }
                        key = entry.getKey();
                        value = entry.getValue();
                        this.map.remove(key);
                        this.size -= safeSizeOf(key, value);
                        this.evictionCount++;
                    }
                    z5 = true;
                    if (!z5) {
                    }
                    if (this.size > maxSize) {
                        break;
                        break;
                    } else {
                        entry = (Map.Entry) CollectionsKt.firstOrNull(this.map.getEntries());
                        if (entry != null) {
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            entryRemoved(true, key, value, null);
        }
    }
}
