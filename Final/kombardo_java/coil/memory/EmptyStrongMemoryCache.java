package coil.memory;

import android.graphics.Bitmap;
import coil.content.Bitmaps;
import coil.memory.MemoryCache;
import java.util.Map;
import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0019\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ3\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000b2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000f0\rH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0018¨\u0006\u0019"}, d2 = {"Lcoil/memory/EmptyStrongMemoryCache;", "Lcoil/memory/StrongMemoryCache;", "Lcoil/memory/WeakMemoryCache;", "weakMemoryCache", "<init>", "(Lcoil/memory/WeakMemoryCache;)V", "Lcoil/memory/MemoryCache$Key;", "key", "Lcoil/memory/MemoryCache$Value;", "get", "(Lcoil/memory/MemoryCache$Key;)Lcoil/memory/MemoryCache$Value;", "Landroid/graphics/Bitmap;", "bitmap", BuildConfig.FLAVOR, BuildConfig.FLAVOR, BuildConfig.FLAVOR, "extras", BuildConfig.FLAVOR, "set", "(Lcoil/memory/MemoryCache$Key;Landroid/graphics/Bitmap;Ljava/util/Map;)V", BuildConfig.FLAVOR, "level", "trimMemory", "(I)V", "Lcoil/memory/WeakMemoryCache;", "coil-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class EmptyStrongMemoryCache implements StrongMemoryCache {
    private final WeakMemoryCache weakMemoryCache;

    public EmptyStrongMemoryCache(WeakMemoryCache weakMemoryCache) {
        this.weakMemoryCache = weakMemoryCache;
    }

    @Override // coil.memory.StrongMemoryCache
    public MemoryCache.Value get(MemoryCache.Key key) {
        return null;
    }

    @Override // coil.memory.StrongMemoryCache
    public void set(MemoryCache.Key key, Bitmap bitmap, Map<String, ? extends Object> extras) {
        this.weakMemoryCache.set(key, bitmap, extras, Bitmaps.getAllocationByteCountCompat(bitmap));
    }

    @Override // coil.memory.StrongMemoryCache
    public void trimMemory(int level) {
    }
}
