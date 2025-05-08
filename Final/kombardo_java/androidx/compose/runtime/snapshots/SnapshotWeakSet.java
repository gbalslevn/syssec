package androidx.compose.runtime.snapshots;

import androidx.compose.runtime.ActualJvm_jvmKt;
import androidx.compose.runtime.WeakReference;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0015\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001f\u0010\b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00028\u00002\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\b\u0010\tJ'\u0010\f\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00028\u00002\u0006\u0010\u000b\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00028\u0000¢\u0006\u0004\b\u000f\u0010\u0010R\"\u0010\u0011\u001a\u00020\u00068\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u0018\u001a\u00020\u00178\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR0\u0010 \u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u001f0\u001e8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%¨\u0006&"}, d2 = {"Landroidx/compose/runtime/snapshots/SnapshotWeakSet;", BuildConfig.FLAVOR, "T", "<init>", "()V", "value", BuildConfig.FLAVOR, "hash", "find", "(Ljava/lang/Object;I)I", "midIndex", "valueHash", "findExactIndex", "(ILjava/lang/Object;I)I", BuildConfig.FLAVOR, "add", "(Ljava/lang/Object;)Z", "size", "I", "getSize$runtime_release", "()I", "setSize$runtime_release", "(I)V", BuildConfig.FLAVOR, "hashes", "[I", "getHashes$runtime_release", "()[I", "setHashes$runtime_release", "([I)V", BuildConfig.FLAVOR, "Landroidx/compose/runtime/WeakReference;", "values", "[Landroidx/compose/runtime/WeakReference;", "getValues$runtime_release", "()[Landroidx/compose/runtime/WeakReference;", "setValues$runtime_release", "([Landroidx/compose/runtime/WeakReference;)V", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SnapshotWeakSet<T> {
    private int size;
    private int[] hashes = new int[16];
    private WeakReference<T>[] values = new WeakReference[16];

    private final int find(T value, int hash) {
        int i5 = this.size - 1;
        int i6 = 0;
        while (i6 <= i5) {
            int i7 = (i6 + i5) >>> 1;
            int i8 = this.hashes[i7];
            if (i8 < hash) {
                i6 = i7 + 1;
            } else {
                if (i8 <= hash) {
                    WeakReference<T> weakReference = this.values[i7];
                    return value == (weakReference != null ? weakReference.get() : null) ? i7 : findExactIndex(i7, value, hash);
                }
                i5 = i7 - 1;
            }
        }
        return -(i6 + 1);
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x002c, code lost:
    
        return -(r4 + 1);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final int findExactIndex(int midIndex, T value, int valueHash) {
        int i5 = midIndex - 1;
        while (true) {
            if (-1 >= i5 || this.hashes[i5] != valueHash) {
                break;
            }
            WeakReference<T> weakReference = this.values[i5];
            if ((weakReference != null ? weakReference.get() : null) == value) {
                return i5;
            }
            i5--;
        }
        int i6 = midIndex + 1;
        int i7 = this.size;
        while (true) {
            if (i6 >= i7) {
                i6 = this.size;
                break;
            }
            if (this.hashes[i6] != valueHash) {
                break;
            }
            WeakReference<T> weakReference2 = this.values[i6];
            if ((weakReference2 != null ? weakReference2.get() : null) == value) {
                return i6;
            }
            i6++;
        }
    }

    public final boolean add(T value) {
        int i5;
        int i6 = this.size;
        int identityHashCode = ActualJvm_jvmKt.identityHashCode(value);
        if (i6 > 0) {
            i5 = find(value, identityHashCode);
            if (i5 >= 0) {
                return false;
            }
        } else {
            i5 = -1;
        }
        int i7 = -(i5 + 1);
        WeakReference<T>[] weakReferenceArr = this.values;
        int length = weakReferenceArr.length;
        if (i6 == length) {
            int i8 = length * 2;
            WeakReference<T>[] weakReferenceArr2 = new WeakReference[i8];
            int[] iArr = new int[i8];
            int i9 = i7 + 1;
            ArraysKt.copyInto(weakReferenceArr, weakReferenceArr2, i9, i7, i6);
            ArraysKt.copyInto$default(this.values, weakReferenceArr2, 0, 0, i7, 6, (Object) null);
            ArraysKt.copyInto(this.hashes, iArr, i9, i7, i6);
            ArraysKt.copyInto$default(this.hashes, iArr, 0, 0, i7, 6, (Object) null);
            this.values = weakReferenceArr2;
            this.hashes = iArr;
        } else {
            int i10 = i7 + 1;
            ArraysKt.copyInto(weakReferenceArr, weakReferenceArr, i10, i7, i6);
            int[] iArr2 = this.hashes;
            ArraysKt.copyInto(iArr2, iArr2, i10, i7, i6);
        }
        this.values[i7] = new WeakReference<>(value);
        this.hashes[i7] = identityHashCode;
        this.size++;
        return true;
    }

    /* renamed from: getHashes$runtime_release, reason: from getter */
    public final int[] getHashes() {
        return this.hashes;
    }

    /* renamed from: getSize$runtime_release, reason: from getter */
    public final int getSize() {
        return this.size;
    }

    public final WeakReference<T>[] getValues$runtime_release() {
        return this.values;
    }

    public final void setSize$runtime_release(int i5) {
        this.size = i5;
    }
}
