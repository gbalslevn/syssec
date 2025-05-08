package androidx.compose.ui.node;

import androidx.compose.ui.internal.InlineClassHelperKt;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\r\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0003H\u0002J\u0011\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0003H\u0086\u0002J\u0006\u0010\u0011\u001a\u00020\fJ \u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0003H\u0002J\u0006\u0010\u0016\u001a\u00020\u0003J\u001e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0003J&\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\u0003J \u0010 \u001a\u00020\u00182\u0006\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0003H\u0002J\u0006\u0010!\u001a\u00020\u0018J\u0018\u0010\"\u001a\u00020\u00182\u0006\u0010#\u001a\u00020\u00032\u0006\u0010$\u001a\u00020\u0003H\u0002R\u000e\u0010\u0005\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Landroidx/compose/ui/node/IntStack;", BuildConfig.FLAVOR, "initialCapacity", BuildConfig.FLAVOR, "(I)V", "lastIndex", "size", "getSize", "()I", "stack", BuildConfig.FLAVOR, "compareDiagonal", BuildConfig.FLAVOR, "a", "b", "get", "index", "isNotEmpty", "partition", "start", "end", "elSize", "pop", "pushDiagonal", BuildConfig.FLAVOR, "x", "y", "pushRange", "oldStart", "oldEnd", "newStart", "newEnd", "quickSort", "sortDiagonals", "swapDiagonal", "i", "j", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
final class IntStack {
    private int lastIndex;
    private int[] stack;

    public IntStack(int i5) {
        this.stack = new int[i5];
    }

    private final boolean compareDiagonal(int a5, int b5) {
        int[] iArr = this.stack;
        int i5 = iArr[a5];
        int i6 = iArr[b5];
        if (i5 >= i6) {
            return i5 == i6 && iArr[a5 + 1] <= iArr[b5 + 1];
        }
        return true;
    }

    private final int partition(int start, int end, int elSize) {
        int i5 = start - elSize;
        while (start < end) {
            if (compareDiagonal(start, end)) {
                i5 += elSize;
                swapDiagonal(i5, start);
            }
            start += elSize;
        }
        int i6 = i5 + elSize;
        swapDiagonal(i6, end);
        return i6;
    }

    private final void quickSort(int start, int end, int elSize) {
        if (start < end) {
            int partition = partition(start, end, elSize);
            quickSort(start, partition - elSize, elSize);
            quickSort(partition + elSize, end, elSize);
        }
    }

    private final void swapDiagonal(int i5, int j5) {
        int[] iArr = this.stack;
        MyersDiffKt.access$swap(iArr, i5, j5);
        MyersDiffKt.access$swap(iArr, i5 + 1, j5 + 1);
        MyersDiffKt.access$swap(iArr, i5 + 2, j5 + 2);
    }

    public final int get(int index) {
        return this.stack[index];
    }

    /* renamed from: getSize, reason: from getter */
    public final int getLastIndex() {
        return this.lastIndex;
    }

    public final boolean isNotEmpty() {
        return this.lastIndex != 0;
    }

    public final int pop() {
        int[] iArr = this.stack;
        int i5 = this.lastIndex - 1;
        this.lastIndex = i5;
        return iArr[i5];
    }

    public final void pushDiagonal(int x5, int y5, int size) {
        int i5 = this.lastIndex;
        int i6 = i5 + 3;
        int[] iArr = this.stack;
        if (i6 >= iArr.length) {
            int[] copyOf = Arrays.copyOf(iArr, iArr.length * 2);
            Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
            this.stack = copyOf;
        }
        int[] iArr2 = this.stack;
        iArr2[i5] = x5 + size;
        iArr2[i5 + 1] = y5 + size;
        iArr2[i5 + 2] = size;
        this.lastIndex = i6;
    }

    public final void pushRange(int oldStart, int oldEnd, int newStart, int newEnd) {
        int i5 = this.lastIndex;
        int i6 = i5 + 4;
        int[] iArr = this.stack;
        if (i6 >= iArr.length) {
            int[] copyOf = Arrays.copyOf(iArr, iArr.length * 2);
            Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
            this.stack = copyOf;
        }
        int[] iArr2 = this.stack;
        iArr2[i5] = oldStart;
        iArr2[i5 + 1] = oldEnd;
        iArr2[i5 + 2] = newStart;
        iArr2[i5 + 3] = newEnd;
        this.lastIndex = i6;
    }

    public final void sortDiagonals() {
        int i5 = this.lastIndex;
        if (!(i5 % 3 == 0)) {
            InlineClassHelperKt.throwIllegalStateException("Array size not a multiple of 3");
        }
        if (i5 > 3) {
            quickSort(0, i5 - 3, 3);
        }
    }
}
