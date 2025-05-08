package uniffi.molslinjen_shared;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0013\u0010\r\u001a\u00028\u00002\u0006\u0010\u000e\u001a\u00020\b¢\u0006\u0002\u0010\u000fJ\u0013\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00028\u0000¢\u0006\u0002\u0010\u0012J\u0013\u0010\u0013\u001a\u00028\u00002\u0006\u0010\u000e\u001a\u00020\b¢\u0006\u0002\u0010\u000fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00028\u00000\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\u0014"}, d2 = {"Luniffi/molslinjen_shared/UniffiHandleMap;", "T", BuildConfig.FLAVOR, "()V", "counter", "Ljava/util/concurrent/atomic/AtomicLong;", "map", "Ljava/util/concurrent/ConcurrentHashMap;", BuildConfig.FLAVOR, "size", BuildConfig.FLAVOR, "getSize", "()I", "get", "handle", "(J)Ljava/lang/Object;", "insert", "obj", "(Ljava/lang/Object;)J", "remove", "shared_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class UniffiHandleMap<T> {
    private final ConcurrentHashMap<Long, T> map = new ConcurrentHashMap<>();
    private final AtomicLong counter = new AtomicLong(0);

    public final T get(long handle) {
        T t5 = this.map.get(Long.valueOf(handle));
        if (t5 != null) {
            return t5;
        }
        throw new InternalException("UniffiHandleMap.get: Invalid handle");
    }

    public final int getSize() {
        return this.map.size();
    }

    public final long insert(T obj) {
        Intrinsics.checkNotNullParameter(obj, "obj");
        long andAdd = this.counter.getAndAdd(1L);
        this.map.put(Long.valueOf(andAdd), obj);
        return andAdd;
    }

    public final T remove(long handle) {
        T remove = this.map.remove(Long.valueOf(handle));
        if (remove != null) {
            return remove;
        }
        throw new InternalException("UniffiHandleMap: Invalid handle");
    }
}
