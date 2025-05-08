package androidx.compose.runtime.snapshots;

import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0017\n\u0002\u0010\u0015\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\t\u0010\bJ\u001f\u0010\f\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000f\u0010\bJ\u000f\u0010\u0010\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0013\u0010\bJ\u0017\u0010\u0015\u001a\u00020\u00042\b\b\u0002\u0010\u0014\u001a\u00020\u0004¢\u0006\u0004\b\u0015\u0010\u0016J\u0015\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0004¢\u0006\u0004\b\u0018\u0010\u0016J\u0015\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0004¢\u0006\u0004\b\u0019\u0010\bR$\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u00048\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u0011R\u0016\u0010\u001f\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010\u0005\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010 R\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010 R\u0016\u0010\"\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010\u001c¨\u0006#"}, d2 = {"Landroidx/compose/runtime/snapshots/SnapshotDoubleIndexHeap;", BuildConfig.FLAVOR, "<init>", "()V", BuildConfig.FLAVOR, "index", BuildConfig.FLAVOR, "shiftUp", "(I)V", "shiftDown", "a", "b", "swap", "(II)V", "atLeast", "ensure", "allocateHandle", "()I", "handle", "freeHandle", "default", "lowestOrDefault", "(I)I", "value", "add", "remove", "<set-?>", "size", "I", "getSize", BuildConfig.FLAVOR, "values", "[I", "handles", "firstFreeHandle", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SnapshotDoubleIndexHeap {
    private int firstFreeHandle;
    private int[] handles;
    private int size;
    private int[] values = new int[16];
    private int[] index = new int[16];

    public SnapshotDoubleIndexHeap() {
        int[] iArr = new int[16];
        int i5 = 0;
        while (i5 < 16) {
            int i6 = i5 + 1;
            iArr[i5] = i6;
            i5 = i6;
        }
        this.handles = iArr;
    }

    private final int allocateHandle() {
        int length = this.handles.length;
        if (this.firstFreeHandle >= length) {
            int i5 = length * 2;
            int[] iArr = new int[i5];
            int i6 = 0;
            while (i6 < i5) {
                int i7 = i6 + 1;
                iArr[i6] = i7;
                i6 = i7;
            }
            ArraysKt.copyInto$default(this.handles, iArr, 0, 0, 0, 14, (Object) null);
            this.handles = iArr;
        }
        int i8 = this.firstFreeHandle;
        this.firstFreeHandle = this.handles[i8];
        return i8;
    }

    private final void ensure(int atLeast) {
        int[] iArr = this.values;
        int length = iArr.length;
        if (atLeast <= length) {
            return;
        }
        int i5 = length * 2;
        int[] iArr2 = new int[i5];
        int[] iArr3 = new int[i5];
        ArraysKt.copyInto$default(iArr, iArr2, 0, 0, 0, 14, (Object) null);
        ArraysKt.copyInto$default(this.index, iArr3, 0, 0, 0, 14, (Object) null);
        this.values = iArr2;
        this.index = iArr3;
    }

    private final void freeHandle(int handle) {
        this.handles[handle] = this.firstFreeHandle;
        this.firstFreeHandle = handle;
    }

    private final void shiftDown(int index) {
        int i5;
        int[] iArr = this.values;
        int i6 = this.size >> 1;
        while (index < i6) {
            int i7 = (index + 1) << 1;
            int i8 = i7 - 1;
            if (i7 >= this.size || (i5 = iArr[i7]) >= iArr[i8]) {
                if (iArr[i8] >= iArr[index]) {
                    return;
                }
                swap(i8, index);
                index = i8;
            } else {
                if (i5 >= iArr[index]) {
                    return;
                }
                swap(i7, index);
                index = i7;
            }
        }
    }

    private final void shiftUp(int index) {
        int[] iArr = this.values;
        int i5 = iArr[index];
        while (index > 0) {
            int i6 = ((index + 1) >> 1) - 1;
            if (iArr[i6] <= i5) {
                return;
            }
            swap(i6, index);
            index = i6;
        }
    }

    private final void swap(int a5, int b5) {
        int[] iArr = this.values;
        int[] iArr2 = this.index;
        int[] iArr3 = this.handles;
        int i5 = iArr[a5];
        iArr[a5] = iArr[b5];
        iArr[b5] = i5;
        int i6 = iArr2[a5];
        iArr2[a5] = iArr2[b5];
        iArr2[b5] = i6;
        iArr3[iArr2[a5]] = a5;
        iArr3[iArr2[b5]] = b5;
    }

    public final int add(int value) {
        ensure(this.size + 1);
        int i5 = this.size;
        this.size = i5 + 1;
        int allocateHandle = allocateHandle();
        this.values[i5] = value;
        this.index[i5] = allocateHandle;
        this.handles[allocateHandle] = i5;
        shiftUp(i5);
        return allocateHandle;
    }

    public final int lowestOrDefault(int r22) {
        return this.size > 0 ? this.values[0] : r22;
    }

    public final void remove(int handle) {
        int i5 = this.handles[handle];
        swap(i5, this.size - 1);
        this.size--;
        shiftUp(i5);
        shiftDown(i5);
        freeHandle(handle);
    }
}
