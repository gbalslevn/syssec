package androidx.compose.ui.node;

import com.sun.jna.Callback;
import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0015\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001aZ\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014\u001a \u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u0005H\u0002\u001a \u0010\u0018\u001a\u00020\u00012\u0006\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u0005H\u0000\u001a8\u0010\u0019\u001a\u00020\u00012\u0006\u0010\u001a\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u0012H\u0000\u001aZ\u0010\u000e\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002ø\u0001\u0000¢\u0006\u0004\b \u0010\u0014\u001aR\u0010!\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002ø\u0001\u0000¢\u0006\u0004\b\"\u0010#\u001a\u001c\u0010$\u001a\u00020\u0001*\u00020\u00122\u0006\u0010%\u001a\u00020\t2\u0006\u0010&\u001a\u00020\tH\u0002\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006'"}, d2 = {"applyDiff", BuildConfig.FLAVOR, "diagonals", "Landroidx/compose/ui/node/IntStack;", Callback.METHOD_NAME, "Landroidx/compose/ui/node/DiffCallback;", "backward", BuildConfig.FLAVOR, "oldStart", BuildConfig.FLAVOR, "oldEnd", "newStart", "newEnd", "cb", "forward", "Landroidx/compose/ui/node/CenteredArray;", "d", "snake", BuildConfig.FLAVOR, "backward-4l5_RBY", "(IIIILandroidx/compose/ui/node/DiffCallback;[I[II[I)Z", "calculateDiff", "oldSize", "newSize", "executeDiff", "fillSnake", "startX", "startY", "endX", "endY", "reverse", "data", "forward-4l5_RBY", "midPoint", "midPoint-q5eDKzI", "(IIIILandroidx/compose/ui/node/DiffCallback;[I[I[I)Z", "swap", "i", "j", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class MyersDiffKt {
    public static final /* synthetic */ void access$swap(int[] iArr, int i5, int i6) {
        swap(iArr, i5, i6);
    }

    private static final void applyDiff(IntStack intStack, DiffCallback diffCallback) {
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        while (i5 < intStack.getLastIndex()) {
            int i8 = i5 + 2;
            int i9 = intStack.get(i5) - intStack.get(i8);
            int i10 = intStack.get(i5 + 1) - intStack.get(i8);
            int i11 = intStack.get(i8);
            i5 += 3;
            while (i6 < i9) {
                diffCallback.remove(i7, i6);
                i6++;
            }
            while (i7 < i10) {
                diffCallback.insert(i7);
                i7++;
            }
            while (true) {
                int i12 = i11 - 1;
                if (i11 > 0) {
                    diffCallback.same(i6, i7);
                    i6++;
                    i7++;
                    i11 = i12;
                }
            }
        }
    }

    /* renamed from: backward-4l5_RBY, reason: not valid java name */
    private static final boolean m2039backward4l5_RBY(int i5, int i6, int i7, int i8, DiffCallback diffCallback, int[] iArr, int[] iArr2, int i9, int[] iArr3) {
        int m1986getimpl;
        int i10;
        int i11;
        int i12 = (i6 - i5) - (i8 - i7);
        boolean z5 = i12 % 2 == 0;
        int i13 = -i9;
        for (int i14 = i13; i14 <= i9; i14 += 2) {
            if (i14 == i13 || (i14 != i9 && CenteredArray.m1986getimpl(iArr2, i14 + 1) < CenteredArray.m1986getimpl(iArr2, i14 - 1))) {
                m1986getimpl = CenteredArray.m1986getimpl(iArr2, i14 + 1);
                i10 = m1986getimpl;
            } else {
                m1986getimpl = CenteredArray.m1986getimpl(iArr2, i14 - 1);
                i10 = m1986getimpl - 1;
            }
            int i15 = i8 - ((i6 - i10) - i14);
            int i16 = (i9 == 0 || i10 != m1986getimpl) ? i15 : i15 + 1;
            while (i10 > i5 && i15 > i7) {
                if (!diffCallback.areItemsTheSame(i10 - 1, i15 - 1)) {
                    break;
                }
                i10--;
                i15--;
            }
            CenteredArray.m1988setimpl(iArr2, i14, i10);
            if (z5 && (i11 = i12 - i14) >= i13 && i11 <= i9) {
                if (CenteredArray.m1986getimpl(iArr, i11) >= i10) {
                    fillSnake(i10, i15, m1986getimpl, i16, true, iArr3);
                    return true;
                }
            }
        }
        return false;
    }

    private static final IntStack calculateDiff(int i5, int i6, DiffCallback diffCallback) {
        int i7 = ((i5 + i6) + 1) / 2;
        IntStack intStack = new IntStack(i7 * 3);
        IntStack intStack2 = new IntStack(i7 * 4);
        intStack2.pushRange(0, i5, 0, i6);
        int i8 = (i7 * 2) + 1;
        int[] m1985constructorimpl = CenteredArray.m1985constructorimpl(new int[i8]);
        int[] m1985constructorimpl2 = CenteredArray.m1985constructorimpl(new int[i8]);
        int[] m2086constructorimpl = Snake.m2086constructorimpl(new int[5]);
        while (intStack2.isNotEmpty()) {
            int pop = intStack2.pop();
            int pop2 = intStack2.pop();
            int pop3 = intStack2.pop();
            int pop4 = intStack2.pop();
            int[] iArr = m1985constructorimpl;
            int[] iArr2 = m1985constructorimpl2;
            if (m2041midPointq5eDKzI(pop4, pop3, pop2, pop, diffCallback, m1985constructorimpl, m1985constructorimpl2, m2086constructorimpl)) {
                if (Snake.m2087getDiagonalSizeimpl(m2086constructorimpl) > 0) {
                    Snake.m2085addDiagonalToStackimpl(m2086constructorimpl, intStack);
                }
                intStack2.pushRange(pop4, Snake.m2092getStartXimpl(m2086constructorimpl), pop2, Snake.m2093getStartYimpl(m2086constructorimpl));
                intStack2.pushRange(Snake.m2088getEndXimpl(m2086constructorimpl), pop3, Snake.m2089getEndYimpl(m2086constructorimpl), pop);
            }
            m1985constructorimpl = iArr;
            m1985constructorimpl2 = iArr2;
        }
        intStack.sortDiagonals();
        intStack.pushDiagonal(i5, i6, 0);
        return intStack;
    }

    public static final void executeDiff(int i5, int i6, DiffCallback diffCallback) {
        applyDiff(calculateDiff(i5, i6, diffCallback), diffCallback);
    }

    public static final void fillSnake(int i5, int i6, int i7, int i8, boolean z5, int[] iArr) {
        iArr[0] = i5;
        iArr[1] = i6;
        iArr[2] = i7;
        iArr[3] = i8;
        iArr[4] = z5 ? 1 : 0;
    }

    /* renamed from: forward-4l5_RBY, reason: not valid java name */
    private static final boolean m2040forward4l5_RBY(int i5, int i6, int i7, int i8, DiffCallback diffCallback, int[] iArr, int[] iArr2, int i9, int[] iArr3) {
        int m1986getimpl;
        int i10;
        int i11;
        int i12 = (i6 - i5) - (i8 - i7);
        boolean z5 = Math.abs(i12) % 2 == 1;
        int i13 = -i9;
        for (int i14 = i13; i14 <= i9; i14 += 2) {
            if (i14 == i13 || (i14 != i9 && CenteredArray.m1986getimpl(iArr, i14 + 1) > CenteredArray.m1986getimpl(iArr, i14 - 1))) {
                m1986getimpl = CenteredArray.m1986getimpl(iArr, i14 + 1);
                i10 = m1986getimpl;
            } else {
                m1986getimpl = CenteredArray.m1986getimpl(iArr, i14 - 1);
                i10 = m1986getimpl + 1;
            }
            int i15 = (i7 + (i10 - i5)) - i14;
            int i16 = (i9 == 0 || i10 != m1986getimpl) ? i15 : i15 - 1;
            while (i10 < i6 && i15 < i8) {
                if (!diffCallback.areItemsTheSame(i10, i15)) {
                    break;
                }
                i10++;
                i15++;
            }
            CenteredArray.m1988setimpl(iArr, i14, i10);
            if (z5 && (i11 = i12 - i14) >= i13 + 1 && i11 <= i9 - 1) {
                if (CenteredArray.m1986getimpl(iArr2, i11) <= i10) {
                    fillSnake(m1986getimpl, i16, i10, i15, false, iArr3);
                    return true;
                }
            }
        }
        return false;
    }

    /* renamed from: midPoint-q5eDKzI, reason: not valid java name */
    private static final boolean m2041midPointq5eDKzI(int i5, int i6, int i7, int i8, DiffCallback diffCallback, int[] iArr, int[] iArr2, int[] iArr3) {
        int i9 = i6 - i5;
        int i10 = i8 - i7;
        if (i9 >= 1 && i10 >= 1) {
            int i11 = ((i9 + i10) + 1) / 2;
            CenteredArray.m1988setimpl(iArr, 1, i5);
            CenteredArray.m1988setimpl(iArr2, 1, i6);
            int i12 = 0;
            while (i12 < i11) {
                int i13 = i12;
                if (m2040forward4l5_RBY(i5, i6, i7, i8, diffCallback, iArr, iArr2, i12, iArr3) || m2039backward4l5_RBY(i5, i6, i7, i8, diffCallback, iArr, iArr2, i13, iArr3)) {
                    return true;
                }
                i12 = i13 + 1;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void swap(int[] iArr, int i5, int i6) {
        int i7 = iArr[i5];
        iArr[i5] = iArr[i6];
        iArr[i6] = i7;
    }
}
