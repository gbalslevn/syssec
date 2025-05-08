package androidx.compose.runtime.internal;

import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0016\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\b\u0000\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u000e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0010\u0010\r\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u000b\u001a\u00020\fJ\u0018\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0007X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\t¨\u0006\u0012"}, d2 = {"Landroidx/compose/runtime/internal/ThreadMap;", BuildConfig.FLAVOR, "size", BuildConfig.FLAVOR, "keys", BuildConfig.FLAVOR, "values", BuildConfig.FLAVOR, "(I[J[Ljava/lang/Object;)V", "[Ljava/lang/Object;", "find", "key", BuildConfig.FLAVOR, "get", "newWith", "value", "trySet", BuildConfig.FLAVOR, "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ThreadMap {
    private final long[] keys;
    private final int size;
    private final Object[] values;

    public ThreadMap(int i5, long[] jArr, Object[] objArr) {
        this.size = i5;
        this.keys = jArr;
        this.values = objArr;
    }

    private final int find(long key) {
        int i5 = this.size - 1;
        if (i5 == -1) {
            return -1;
        }
        int i6 = 0;
        if (i5 == 0) {
            long j5 = this.keys[0];
            if (j5 == key) {
                return 0;
            }
            return j5 > key ? -2 : -1;
        }
        while (i6 <= i5) {
            int i7 = (i6 + i5) >>> 1;
            long j6 = this.keys[i7] - key;
            if (j6 < 0) {
                i6 = i7 + 1;
            } else {
                if (j6 <= 0) {
                    return i7;
                }
                i5 = i7 - 1;
            }
        }
        return -(i6 + 1);
    }

    public final Object get(long key) {
        int find = find(key);
        if (find >= 0) {
            return this.values[find];
        }
        return null;
    }

    public final ThreadMap newWith(long key, Object value) {
        int i5 = this.size;
        int i6 = 0;
        int i7 = 0;
        for (Object obj : this.values) {
            if (obj != null) {
                i7++;
            }
        }
        int i8 = i7 + 1;
        long[] jArr = new long[i8];
        Object[] objArr = new Object[i8];
        if (i8 > 1) {
            int i9 = 0;
            while (true) {
                if (i6 >= i8 || i9 >= i5) {
                    break;
                }
                long j5 = this.keys[i9];
                Object obj2 = this.values[i9];
                if (j5 > key) {
                    jArr[i6] = key;
                    objArr[i6] = value;
                    i6++;
                    break;
                }
                if (obj2 != null) {
                    jArr[i6] = j5;
                    objArr[i6] = obj2;
                    i6++;
                }
                i9++;
            }
            if (i9 == i5) {
                jArr[i7] = key;
                objArr[i7] = value;
            } else {
                while (i6 < i8) {
                    long j6 = this.keys[i9];
                    Object obj3 = this.values[i9];
                    if (obj3 != null) {
                        jArr[i6] = j6;
                        objArr[i6] = obj3;
                        i6++;
                    }
                    i9++;
                }
            }
        } else {
            jArr[0] = key;
            objArr[0] = value;
        }
        return new ThreadMap(i8, jArr, objArr);
    }

    public final boolean trySet(long key, Object value) {
        int find = find(key);
        if (find < 0) {
            return false;
        }
        this.values[find] = value;
        return true;
    }
}
