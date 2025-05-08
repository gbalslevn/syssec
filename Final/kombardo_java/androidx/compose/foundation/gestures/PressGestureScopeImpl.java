package androidx.compose.foundation.gestures;

import androidx.compose.ui.unit.Density;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\n\u001a\u00020\u0007*\u00020\u0006H\u0097\u0001ø\u0001\u0000¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u000e\u001a\u00020\u0006*\u00020\u000bH\u0097\u0001ø\u0001\u0000¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u000e\u001a\u00020\u0006*\u00020\u000fH\u0097\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u000e\u001a\u00020\u0006*\u00020\u0007H\u0097\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0012J\u0017\u0010\u0017\u001a\u00020\u0014*\u00020\u0013H\u0097\u0001ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0019\u001a\u00020\u000f*\u00020\u0006H\u0097\u0001ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0011J\u0017\u0010\u0019\u001a\u00020\u000f*\u00020\u000bH\u0097\u0001ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\rJ\u0017\u0010\u001c\u001a\u00020\u0013*\u00020\u0014H\u0097\u0001ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u0016J\u0017\u0010\u001f\u001a\u00020\u000b*\u00020\u0006H\u0097\u0001ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001eJ\u001a\u0010\u001f\u001a\u00020\u000b*\u00020\u000fH\u0097\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b \u0010\u001eJ\r\u0010\"\u001a\u00020!¢\u0006\u0004\b\"\u0010#J\r\u0010$\u001a\u00020!¢\u0006\u0004\b$\u0010#J\u0010\u0010%\u001a\u00020!H\u0086@¢\u0006\u0004\b%\u0010&J\u0010\u0010(\u001a\u00020'H\u0096@¢\u0006\u0004\b(\u0010&R\u0016\u0010)\u001a\u00020'8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010+\u001a\u00020'8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010*R\u0014\u0010-\u001a\u00020,8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010.R\u0014\u0010\u0003\u001a\u00020\u000f8\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b/\u00100R\u0014\u00102\u001a\u00020\u000f8\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b1\u00100\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u00063"}, d2 = {"Landroidx/compose/foundation/gestures/PressGestureScopeImpl;", "Landroidx/compose/foundation/gestures/PressGestureScope;", "Landroidx/compose/ui/unit/Density;", "density", "<init>", "(Landroidx/compose/ui/unit/Density;)V", "Landroidx/compose/ui/unit/Dp;", BuildConfig.FLAVOR, "roundToPx-0680j_4", "(F)I", "roundToPx", "Landroidx/compose/ui/unit/TextUnit;", "toDp-GaN1DYA", "(J)F", "toDp", BuildConfig.FLAVOR, "toDp-u2uoSUM", "(F)F", "(I)F", "Landroidx/compose/ui/geometry/Size;", "Landroidx/compose/ui/unit/DpSize;", "toDpSize-k-rfVVM", "(J)J", "toDpSize", "toPx-0680j_4", "toPx", "toPx--R2X_6o", "toSize-XkaWNTQ", "toSize", "toSp-0xMU5do", "(F)J", "toSp", "toSp-kPz2Gy4", BuildConfig.FLAVOR, "cancel", "()V", "release", "reset", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", BuildConfig.FLAVOR, "tryAwaitRelease", "isReleased", "Z", "isCanceled", "Lkotlinx/coroutines/sync/Mutex;", "mutex", "Lkotlinx/coroutines/sync/Mutex;", "getDensity", "()F", "getFontScale", "fontScale", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class PressGestureScopeImpl implements PressGestureScope, Density {
    private final /* synthetic */ Density $$delegate_0;
    private boolean isCanceled;
    private boolean isReleased;
    private final Mutex mutex = MutexKt.Mutex(false);

    public PressGestureScopeImpl(Density density) {
        this.$$delegate_0 = density;
    }

    public final void cancel() {
        this.isCanceled = true;
        Mutex.DefaultImpls.unlock$default(this.mutex, null, 1, null);
    }

    @Override // androidx.compose.ui.unit.Density
    public float getDensity() {
        return this.$$delegate_0.getDensity();
    }

    @Override // androidx.compose.ui.unit.FontScaling
    public float getFontScale() {
        return this.$$delegate_0.getFontScale();
    }

    public final void release() {
        this.isReleased = true;
        Mutex.DefaultImpls.unlock$default(this.mutex, null, 1, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object reset(Continuation<? super Unit> continuation) {
        PressGestureScopeImpl$reset$1 pressGestureScopeImpl$reset$1;
        int i5;
        PressGestureScopeImpl pressGestureScopeImpl;
        if (continuation instanceof PressGestureScopeImpl$reset$1) {
            pressGestureScopeImpl$reset$1 = (PressGestureScopeImpl$reset$1) continuation;
            int i6 = pressGestureScopeImpl$reset$1.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                pressGestureScopeImpl$reset$1.label = i6 - Integer.MIN_VALUE;
                Object obj = pressGestureScopeImpl$reset$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = pressGestureScopeImpl$reset$1.label;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj);
                    Mutex mutex = this.mutex;
                    pressGestureScopeImpl$reset$1.L$0 = this;
                    pressGestureScopeImpl$reset$1.label = 1;
                    if (Mutex.DefaultImpls.lock$default(mutex, null, pressGestureScopeImpl$reset$1, 1, null) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    pressGestureScopeImpl = this;
                } else {
                    if (i5 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    pressGestureScopeImpl = (PressGestureScopeImpl) pressGestureScopeImpl$reset$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                pressGestureScopeImpl.isReleased = false;
                pressGestureScopeImpl.isCanceled = false;
                return Unit.INSTANCE;
            }
        }
        pressGestureScopeImpl$reset$1 = new PressGestureScopeImpl$reset$1(this, continuation);
        Object obj2 = pressGestureScopeImpl$reset$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = pressGestureScopeImpl$reset$1.label;
        if (i5 != 0) {
        }
        pressGestureScopeImpl.isReleased = false;
        pressGestureScopeImpl.isCanceled = false;
        return Unit.INSTANCE;
    }

    @Override // androidx.compose.ui.unit.Density
    /* renamed from: roundToPx-0680j_4, reason: not valid java name */
    public int mo206roundToPx0680j_4(float f5) {
        return this.$$delegate_0.mo206roundToPx0680j_4(f5);
    }

    @Override // androidx.compose.ui.unit.FontScaling
    /* renamed from: toDp-GaN1DYA, reason: not valid java name */
    public float mo207toDpGaN1DYA(long j5) {
        return this.$$delegate_0.mo207toDpGaN1DYA(j5);
    }

    @Override // androidx.compose.ui.unit.Density
    /* renamed from: toDp-u2uoSUM, reason: not valid java name */
    public float mo208toDpu2uoSUM(float f5) {
        return this.$$delegate_0.mo208toDpu2uoSUM(f5);
    }

    @Override // androidx.compose.ui.unit.Density
    /* renamed from: toDpSize-k-rfVVM, reason: not valid java name */
    public long mo210toDpSizekrfVVM(long j5) {
        return this.$$delegate_0.mo210toDpSizekrfVVM(j5);
    }

    @Override // androidx.compose.ui.unit.Density
    /* renamed from: toPx--R2X_6o, reason: not valid java name */
    public float mo211toPxR2X_6o(long j5) {
        return this.$$delegate_0.mo211toPxR2X_6o(j5);
    }

    @Override // androidx.compose.ui.unit.Density
    /* renamed from: toPx-0680j_4, reason: not valid java name */
    public float mo212toPx0680j_4(float f5) {
        return this.$$delegate_0.mo212toPx0680j_4(f5);
    }

    @Override // androidx.compose.ui.unit.Density
    /* renamed from: toSize-XkaWNTQ, reason: not valid java name */
    public long mo213toSizeXkaWNTQ(long j5) {
        return this.$$delegate_0.mo213toSizeXkaWNTQ(j5);
    }

    @Override // androidx.compose.ui.unit.FontScaling
    /* renamed from: toSp-0xMU5do, reason: not valid java name */
    public long mo214toSp0xMU5do(float f5) {
        return this.$$delegate_0.mo214toSp0xMU5do(f5);
    }

    @Override // androidx.compose.ui.unit.Density
    /* renamed from: toSp-kPz2Gy4, reason: not valid java name */
    public long mo215toSpkPz2Gy4(float f5) {
        return this.$$delegate_0.mo215toSpkPz2Gy4(f5);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    @Override // androidx.compose.foundation.gestures.PressGestureScope
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object tryAwaitRelease(Continuation<? super Boolean> continuation) {
        PressGestureScopeImpl$tryAwaitRelease$1 pressGestureScopeImpl$tryAwaitRelease$1;
        int i5;
        PressGestureScopeImpl pressGestureScopeImpl;
        if (continuation instanceof PressGestureScopeImpl$tryAwaitRelease$1) {
            pressGestureScopeImpl$tryAwaitRelease$1 = (PressGestureScopeImpl$tryAwaitRelease$1) continuation;
            int i6 = pressGestureScopeImpl$tryAwaitRelease$1.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                pressGestureScopeImpl$tryAwaitRelease$1.label = i6 - Integer.MIN_VALUE;
                Object obj = pressGestureScopeImpl$tryAwaitRelease$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = pressGestureScopeImpl$tryAwaitRelease$1.label;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj);
                    if (this.isReleased || this.isCanceled) {
                        pressGestureScopeImpl = this;
                        return Boxing.boxBoolean(pressGestureScopeImpl.isReleased);
                    }
                    Mutex mutex = this.mutex;
                    pressGestureScopeImpl$tryAwaitRelease$1.L$0 = this;
                    pressGestureScopeImpl$tryAwaitRelease$1.label = 1;
                    if (Mutex.DefaultImpls.lock$default(mutex, null, pressGestureScopeImpl$tryAwaitRelease$1, 1, null) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    pressGestureScopeImpl = this;
                } else {
                    if (i5 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    pressGestureScopeImpl = (PressGestureScopeImpl) pressGestureScopeImpl$tryAwaitRelease$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                Mutex.DefaultImpls.unlock$default(pressGestureScopeImpl.mutex, null, 1, null);
                return Boxing.boxBoolean(pressGestureScopeImpl.isReleased);
            }
        }
        pressGestureScopeImpl$tryAwaitRelease$1 = new PressGestureScopeImpl$tryAwaitRelease$1(this, continuation);
        Object obj2 = pressGestureScopeImpl$tryAwaitRelease$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = pressGestureScopeImpl$tryAwaitRelease$1.label;
        if (i5 != 0) {
        }
        Mutex.DefaultImpls.unlock$default(pressGestureScopeImpl.mutex, null, 1, null);
        return Boxing.boxBoolean(pressGestureScopeImpl.isReleased);
    }

    @Override // androidx.compose.ui.unit.Density
    /* renamed from: toDp-u2uoSUM, reason: not valid java name */
    public float mo209toDpu2uoSUM(int i5) {
        return this.$$delegate_0.mo209toDpu2uoSUM(i5);
    }
}
