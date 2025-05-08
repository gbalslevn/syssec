package androidx.compose.foundation.pager;

import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.gestures.ScrollScope;
import androidx.compose.foundation.gestures.TargetedFlingBehavior;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlin.math.MathKt;
import org.conscrypt.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\n\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001c\u0010\u000b\u001a\u00020\t*\u00020\b2\u0006\u0010\n\u001a\u00020\tH\u0096@¢\u0006\u0004\b\u000b\u0010\fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Landroidx/compose/foundation/pager/PagerWrapperFlingBehavior;", "Landroidx/compose/foundation/gestures/FlingBehavior;", "Landroidx/compose/foundation/gestures/TargetedFlingBehavior;", "originalFlingBehavior", "Landroidx/compose/foundation/pager/PagerState;", "pagerState", "<init>", "(Landroidx/compose/foundation/gestures/TargetedFlingBehavior;Landroidx/compose/foundation/pager/PagerState;)V", "Landroidx/compose/foundation/gestures/ScrollScope;", BuildConfig.FLAVOR, "initialVelocity", "performFling", "(Landroidx/compose/foundation/gestures/ScrollScope;FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroidx/compose/foundation/gestures/TargetedFlingBehavior;", "getOriginalFlingBehavior", "()Landroidx/compose/foundation/gestures/TargetedFlingBehavior;", "Landroidx/compose/foundation/pager/PagerState;", "getPagerState", "()Landroidx/compose/foundation/pager/PagerState;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class PagerWrapperFlingBehavior implements FlingBehavior {
    private final TargetedFlingBehavior originalFlingBehavior;
    private final PagerState pagerState;

    public PagerWrapperFlingBehavior(TargetedFlingBehavior targetedFlingBehavior, PagerState pagerState) {
        this.originalFlingBehavior = targetedFlingBehavior;
        this.pagerState = pagerState;
    }

    public final PagerState getPagerState() {
        return this.pagerState;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @Override // androidx.compose.foundation.gestures.FlingBehavior
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object performFling(final ScrollScope scrollScope, float f5, Continuation<? super Float> continuation) {
        PagerWrapperFlingBehavior$performFling$1 pagerWrapperFlingBehavior$performFling$1;
        int i5;
        if (continuation instanceof PagerWrapperFlingBehavior$performFling$1) {
            pagerWrapperFlingBehavior$performFling$1 = (PagerWrapperFlingBehavior$performFling$1) continuation;
            int i6 = pagerWrapperFlingBehavior$performFling$1.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                pagerWrapperFlingBehavior$performFling$1.label = i6 - Integer.MIN_VALUE;
                Object obj = pagerWrapperFlingBehavior$performFling$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = pagerWrapperFlingBehavior$performFling$1.label;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj);
                    TargetedFlingBehavior targetedFlingBehavior = this.originalFlingBehavior;
                    Function1<Float, Unit> function1 = new Function1<Float, Unit>() { // from class: androidx.compose.foundation.pager.PagerWrapperFlingBehavior$performFling$2$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Float f6) {
                            invoke(f6.floatValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(float f6) {
                            PagerWrapperFlingBehavior.this.getPagerState().updateTargetPage(scrollScope, MathKt.roundToInt(PagerWrapperFlingBehavior.this.getPagerState().getPageSizeWithSpacing$foundation_release() != 0 ? f6 / PagerWrapperFlingBehavior.this.getPagerState().getPageSizeWithSpacing$foundation_release() : 0.0f) + PagerWrapperFlingBehavior.this.getPagerState().getCurrentPage());
                        }
                    };
                    pagerWrapperFlingBehavior$performFling$1.label = 1;
                    obj = targetedFlingBehavior.performFling(scrollScope, f5, function1, pagerWrapperFlingBehavior$performFling$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i5 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return Boxing.boxFloat(((Number) obj).floatValue());
            }
        }
        pagerWrapperFlingBehavior$performFling$1 = new PagerWrapperFlingBehavior$performFling$1(this, continuation);
        Object obj2 = pagerWrapperFlingBehavior$performFling$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = pagerWrapperFlingBehavior$performFling$1.label;
        if (i5 != 0) {
        }
        return Boxing.boxFloat(((Number) obj2).floatValue());
    }
}
