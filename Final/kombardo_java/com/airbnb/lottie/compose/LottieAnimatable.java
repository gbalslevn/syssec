package com.airbnb.lottie.compose;

import com.airbnb.lottie.LottieComposition;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\bg\u0018\u00002\u00020\u0001J\u0081\u0001\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\f2\b\b\u0002\u0010\u0010\u001a\u00020\n2\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\n2\b\b\u0002\u0010\u0014\u001a\u00020\nH¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0015J;\u0010\u0016\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0017\u001a\u00020\f2\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\u0018\u001a\u00020\nH¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0019\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001a"}, d2 = {"Lcom/airbnb/lottie/compose/LottieAnimatable;", "Lcom/airbnb/lottie/compose/LottieAnimationState;", "animate", BuildConfig.FLAVOR, "composition", "Lcom/airbnb/lottie/LottieComposition;", "iteration", BuildConfig.FLAVOR, "iterations", "reverseOnRepeat", BuildConfig.FLAVOR, "speed", BuildConfig.FLAVOR, "clipSpec", "Lcom/airbnb/lottie/compose/LottieClipSpec;", "initialProgress", "continueFromPreviousAnimate", "cancellationBehavior", "Lcom/airbnb/lottie/compose/LottieCancellationBehavior;", "ignoreSystemAnimationsDisabled", "useCompositionFrameRate", "(Lcom/airbnb/lottie/LottieComposition;IIZFLcom/airbnb/lottie/compose/LottieClipSpec;FZLcom/airbnb/lottie/compose/LottieCancellationBehavior;ZZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "snapTo", "progress", "resetLastFrameNanos", "(Lcom/airbnb/lottie/LottieComposition;FIZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "lottie-compose_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes.dex */
public interface LottieAnimatable extends LottieAnimationState {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ Object animate$default(LottieAnimatable lottieAnimatable, LottieComposition lottieComposition, int i5, int i6, boolean z5, float f5, LottieClipSpec lottieClipSpec, float f6, boolean z6, LottieCancellationBehavior lottieCancellationBehavior, boolean z7, boolean z8, Continuation continuation, int i7, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: animate");
            }
            int iteration = (i7 & 2) != 0 ? lottieAnimatable.getIteration() : i5;
            int iterations = (i7 & 4) != 0 ? lottieAnimatable.getIterations() : i6;
            boolean reverseOnRepeat = (i7 & 8) != 0 ? lottieAnimatable.getReverseOnRepeat() : z5;
            float speed = (i7 & 16) != 0 ? lottieAnimatable.getSpeed() : f5;
            LottieClipSpec clipSpec = (i7 & 32) != 0 ? lottieAnimatable.getClipSpec() : lottieClipSpec;
            return lottieAnimatable.animate(lottieComposition, iteration, iterations, reverseOnRepeat, speed, clipSpec, (i7 & 64) != 0 ? LottieAnimatableKt.access$defaultProgress(lottieComposition, clipSpec, speed) : f6, (i7 & 128) != 0 ? false : z6, (i7 & 256) != 0 ? LottieCancellationBehavior.Immediately : lottieCancellationBehavior, (i7 & 512) != 0 ? false : z7, (i7 & 1024) != 0 ? false : z8, continuation);
        }

        public static /* synthetic */ Object snapTo$default(LottieAnimatable lottieAnimatable, LottieComposition lottieComposition, float f5, int i5, boolean z5, Continuation continuation, int i6, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: snapTo");
            }
            if ((i6 & 1) != 0) {
                lottieComposition = lottieAnimatable.getComposition();
            }
            LottieComposition lottieComposition2 = lottieComposition;
            if ((i6 & 2) != 0) {
                f5 = lottieAnimatable.getProgress();
            }
            float f6 = f5;
            if ((i6 & 4) != 0) {
                i5 = lottieAnimatable.getIteration();
            }
            int i7 = i5;
            if ((i6 & 8) != 0) {
                z5 = !(f6 == lottieAnimatable.getProgress());
            }
            return lottieAnimatable.snapTo(lottieComposition2, f6, i7, z5, continuation);
        }
    }

    Object animate(LottieComposition lottieComposition, int i5, int i6, boolean z5, float f5, LottieClipSpec lottieClipSpec, float f6, boolean z6, LottieCancellationBehavior lottieCancellationBehavior, boolean z7, boolean z8, Continuation<? super Unit> continuation);

    Object snapTo(LottieComposition lottieComposition, float f5, int i5, boolean z5, Continuation<? super Unit> continuation);
}
