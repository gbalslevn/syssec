package coil.memory;

import android.graphics.Bitmap;
import coil.memory.MemoryCache;
import java.util.Map;
import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ;\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Lcoil/memory/EmptyWeakMemoryCache;", "Lcoil/memory/WeakMemoryCache;", "<init>", "()V", "Lcoil/memory/MemoryCache$Key;", "key", "Lcoil/memory/MemoryCache$Value;", "get", "(Lcoil/memory/MemoryCache$Key;)Lcoil/memory/MemoryCache$Value;", "Landroid/graphics/Bitmap;", "bitmap", BuildConfig.FLAVOR, BuildConfig.FLAVOR, BuildConfig.FLAVOR, "extras", BuildConfig.FLAVOR, "size", BuildConfig.FLAVOR, "set", "(Lcoil/memory/MemoryCache$Key;Landroid/graphics/Bitmap;Ljava/util/Map;I)V", "level", "trimMemory", "(I)V", "coil-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class EmptyWeakMemoryCache implements WeakMemoryCache {
    @Override // coil.memory.WeakMemoryCache
    public MemoryCache.Value get(MemoryCache.Key key) {
        return null;
    }

    @Override // coil.memory.WeakMemoryCache
    public void set(MemoryCache.Key key, Bitmap bitmap, Map<String, ? extends Object> extras, int size) {
    }

    @Override // coil.memory.WeakMemoryCache
    public void trimMemory(int level) {
    }
}
