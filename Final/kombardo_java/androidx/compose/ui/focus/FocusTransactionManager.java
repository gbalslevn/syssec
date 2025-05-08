package androidx.compose.ui.focus;

import androidx.collection.MutableScatterMap;
import androidx.collection.ScatterMapKt;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.internal.InlineClassHelperKt;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0003J\u000f\u0010\u0006\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0003J\u000f\u0010\u0007\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\u0003R \u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR \u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u000e0\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0012\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R,\u0010\u0019\u001a\u0004\u0018\u00010\n*\u00020\t2\b\u0010\u0014\u001a\u0004\u0018\u00010\n8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006\u001a"}, d2 = {"Landroidx/compose/ui/focus/FocusTransactionManager;", BuildConfig.FLAVOR, "<init>", "()V", BuildConfig.FLAVOR, "beginTransaction", "commitTransaction", "cancelTransaction", "Landroidx/collection/MutableScatterMap;", "Landroidx/compose/ui/focus/FocusTargetNode;", "Landroidx/compose/ui/focus/FocusStateImpl;", "states", "Landroidx/collection/MutableScatterMap;", "Landroidx/compose/runtime/collection/MutableVector;", "Lkotlin/Function0;", "cancellationListener", "Landroidx/compose/runtime/collection/MutableVector;", BuildConfig.FLAVOR, "ongoingTransaction", "Z", "value", "getUncommittedFocusState", "(Landroidx/compose/ui/focus/FocusTargetNode;)Landroidx/compose/ui/focus/FocusStateImpl;", "setUncommittedFocusState", "(Landroidx/compose/ui/focus/FocusTargetNode;Landroidx/compose/ui/focus/FocusStateImpl;)V", "uncommittedFocusState", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class FocusTransactionManager {
    private boolean ongoingTransaction;
    private final MutableScatterMap<FocusTargetNode, FocusStateImpl> states = ScatterMapKt.mutableScatterMapOf();
    private final MutableVector<Function0<Unit>> cancellationListener = new MutableVector<>(new Function0[16], 0);

    public static final /* synthetic */ void access$beginTransaction(FocusTransactionManager focusTransactionManager) {
        focusTransactionManager.beginTransaction();
    }

    public static final /* synthetic */ void access$cancelTransaction(FocusTransactionManager focusTransactionManager) {
        focusTransactionManager.cancelTransaction();
    }

    public static final /* synthetic */ void access$commitTransaction(FocusTransactionManager focusTransactionManager) {
        focusTransactionManager.commitTransaction();
    }

    public static final /* synthetic */ boolean access$getOngoingTransaction$p(FocusTransactionManager focusTransactionManager) {
        return focusTransactionManager.ongoingTransaction;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void beginTransaction() {
        this.ongoingTransaction = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void cancelTransaction() {
        this.states.clear();
        int i5 = 0;
        this.ongoingTransaction = false;
        MutableVector<Function0<Unit>> mutableVector = this.cancellationListener;
        int size = mutableVector.getSize();
        if (size > 0) {
            Function0<Unit>[] content = mutableVector.getContent();
            do {
                content[i5].invoke();
                i5++;
            } while (i5 < size);
        }
        this.cancellationListener.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void commitTransaction() {
        MutableScatterMap<FocusTargetNode, FocusStateImpl> mutableScatterMap = this.states;
        Object[] objArr = mutableScatterMap.keys;
        long[] jArr = mutableScatterMap.metadata;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i5 = 0;
            while (true) {
                long j5 = jArr[i5];
                if ((((~j5) << 7) & j5 & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i6 = 8 - ((~(i5 - length)) >>> 31);
                    for (int i7 = 0; i7 < i6; i7++) {
                        if ((255 & j5) < 128) {
                            ((FocusTargetNode) objArr[(i5 << 3) + i7]).commitFocusState$ui_release();
                        }
                        j5 >>= 8;
                    }
                    if (i6 != 8) {
                        break;
                    }
                }
                if (i5 == length) {
                    break;
                } else {
                    i5++;
                }
            }
        }
        this.states.clear();
        this.ongoingTransaction = false;
        this.cancellationListener.clear();
    }

    public final FocusStateImpl getUncommittedFocusState(FocusTargetNode focusTargetNode) {
        return this.states.get(focusTargetNode);
    }

    public final void setUncommittedFocusState(FocusTargetNode focusTargetNode, FocusStateImpl focusStateImpl) {
        MutableScatterMap<FocusTargetNode, FocusStateImpl> mutableScatterMap = this.states;
        if (focusStateImpl != null) {
            mutableScatterMap.set(focusTargetNode, focusStateImpl);
        } else {
            InlineClassHelperKt.throwIllegalStateExceptionForNullCheck("requires a non-null focus state");
            throw new KotlinNothingValueException();
        }
    }
}
