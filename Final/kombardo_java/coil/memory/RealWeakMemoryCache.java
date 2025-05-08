package coil.memory;

import android.graphics.Bitmap;
import coil.memory.MemoryCache;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0000\u0018\u0000 &2\u00020\u0001:\u0002&'B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u0019\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ;\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000b2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\r2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0019\u001a\u00020\u0004H\u0001¢\u0006\u0004\b\u0018\u0010\u0003R\\\u0010\u001f\u001a>\u0012\u0004\u0012\u00020\u0006\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u001c0\u001bj\b\u0012\u0004\u0012\u00020\u001c`\u001d0\u001aj\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u001c0\u001bj\b\u0012\u0004\u0012\u00020\u001c`\u001d`\u001e8\u0000X\u0081\u0004¢\u0006\u0012\n\u0004\b\u001f\u0010 \u0012\u0004\b#\u0010\u0003\u001a\u0004\b!\u0010\"R\u0016\u0010$\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010%¨\u0006("}, d2 = {"Lcoil/memory/RealWeakMemoryCache;", "Lcoil/memory/WeakMemoryCache;", "<init>", "()V", BuildConfig.FLAVOR, "cleanUpIfNecessary", "Lcoil/memory/MemoryCache$Key;", "key", "Lcoil/memory/MemoryCache$Value;", "get", "(Lcoil/memory/MemoryCache$Key;)Lcoil/memory/MemoryCache$Value;", "Landroid/graphics/Bitmap;", "bitmap", BuildConfig.FLAVOR, BuildConfig.FLAVOR, BuildConfig.FLAVOR, "extras", BuildConfig.FLAVOR, "size", "set", "(Lcoil/memory/MemoryCache$Key;Landroid/graphics/Bitmap;Ljava/util/Map;I)V", "level", "trimMemory", "(I)V", "cleanUp$coil_base_release", "cleanUp", "Ljava/util/LinkedHashMap;", "Ljava/util/ArrayList;", "Lcoil/memory/RealWeakMemoryCache$InternalValue;", "Lkotlin/collections/ArrayList;", "Lkotlin/collections/LinkedHashMap;", "cache", "Ljava/util/LinkedHashMap;", "getCache$coil_base_release", "()Ljava/util/LinkedHashMap;", "getCache$coil_base_release$annotations", "operationsSinceCleanUp", "I", "Companion", "InternalValue", "coil-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class RealWeakMemoryCache implements WeakMemoryCache {
    private static final int CLEAN_UP_INTERVAL = 10;
    private final LinkedHashMap<MemoryCache.Key, ArrayList<InternalValue>> cache = new LinkedHashMap<>();
    private int operationsSinceCleanUp;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\n\b\u0001\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\b\u0012\u0006\u0010\n\u001a\u00020\u0003¢\u0006\u0002\u0010\u000bR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001d\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011¨\u0006\u0013"}, d2 = {"Lcoil/memory/RealWeakMemoryCache$InternalValue;", BuildConfig.FLAVOR, "identityHashCode", BuildConfig.FLAVOR, "bitmap", "Ljava/lang/ref/WeakReference;", "Landroid/graphics/Bitmap;", "extras", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "size", "(ILjava/lang/ref/WeakReference;Ljava/util/Map;I)V", "getBitmap", "()Ljava/lang/ref/WeakReference;", "getExtras", "()Ljava/util/Map;", "getIdentityHashCode", "()I", "getSize", "coil-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class InternalValue {
        private final WeakReference<Bitmap> bitmap;
        private final Map<String, Object> extras;
        private final int identityHashCode;
        private final int size;

        public InternalValue(int i5, WeakReference<Bitmap> weakReference, Map<String, ? extends Object> map, int i6) {
            this.identityHashCode = i5;
            this.bitmap = weakReference;
            this.extras = map;
            this.size = i6;
        }

        public final WeakReference<Bitmap> getBitmap() {
            return this.bitmap;
        }

        public final Map<String, Object> getExtras() {
            return this.extras;
        }

        public final int getIdentityHashCode() {
            return this.identityHashCode;
        }

        public final int getSize() {
            return this.size;
        }
    }

    private final void cleanUpIfNecessary() {
        int i5 = this.operationsSinceCleanUp;
        this.operationsSinceCleanUp = i5 + 1;
        if (i5 >= 10) {
            cleanUp$coil_base_release();
        }
    }

    public final void cleanUp$coil_base_release() {
        WeakReference<Bitmap> bitmap;
        this.operationsSinceCleanUp = 0;
        Iterator<ArrayList<InternalValue>> it = this.cache.values().iterator();
        while (it.hasNext()) {
            ArrayList<InternalValue> next = it.next();
            if (next.size() <= 1) {
                InternalValue internalValue = (InternalValue) CollectionsKt.firstOrNull((List) next);
                if (((internalValue == null || (bitmap = internalValue.getBitmap()) == null) ? null : bitmap.get()) == null) {
                    it.remove();
                }
            } else {
                int size = next.size();
                int i5 = 0;
                for (int i6 = 0; i6 < size; i6++) {
                    int i7 = i6 - i5;
                    if (next.get(i7).getBitmap().get() == null) {
                        next.remove(i7);
                        i5++;
                    }
                }
                if (next.isEmpty()) {
                    it.remove();
                }
            }
        }
    }

    @Override // coil.memory.WeakMemoryCache
    public synchronized MemoryCache.Value get(MemoryCache.Key key) {
        try {
            ArrayList<InternalValue> arrayList = this.cache.get(key);
            MemoryCache.Value value = null;
            if (arrayList == null) {
                return null;
            }
            int size = arrayList.size();
            int i5 = 0;
            while (true) {
                if (i5 >= size) {
                    break;
                }
                InternalValue internalValue = arrayList.get(i5);
                Bitmap bitmap = internalValue.getBitmap().get();
                MemoryCache.Value value2 = bitmap != null ? new MemoryCache.Value(bitmap, internalValue.getExtras()) : null;
                if (value2 != null) {
                    value = value2;
                    break;
                }
                i5++;
            }
            cleanUpIfNecessary();
            return value;
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // coil.memory.WeakMemoryCache
    public synchronized void set(MemoryCache.Key key, Bitmap bitmap, Map<String, ? extends Object> extras, int size) {
        try {
            LinkedHashMap<MemoryCache.Key, ArrayList<InternalValue>> linkedHashMap = this.cache;
            ArrayList<InternalValue> arrayList = linkedHashMap.get(key);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                linkedHashMap.put(key, arrayList);
            }
            ArrayList<InternalValue> arrayList2 = arrayList;
            int identityHashCode = System.identityHashCode(bitmap);
            InternalValue internalValue = new InternalValue(identityHashCode, new WeakReference(bitmap), extras, size);
            int size2 = arrayList2.size();
            int i5 = 0;
            while (true) {
                if (i5 >= size2) {
                    arrayList2.add(internalValue);
                    break;
                }
                InternalValue internalValue2 = arrayList2.get(i5);
                if (size < internalValue2.getSize()) {
                    i5++;
                } else if (internalValue2.getIdentityHashCode() == identityHashCode && internalValue2.getBitmap().get() == bitmap) {
                    arrayList2.set(i5, internalValue);
                } else {
                    arrayList2.add(i5, internalValue);
                }
            }
            cleanUpIfNecessary();
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // coil.memory.WeakMemoryCache
    public synchronized void trimMemory(int level) {
        if (level >= 10 && level != 20) {
            cleanUp$coil_base_release();
        }
    }
}
