package com.airbnb.lottie.compose;

import androidx.compose.runtime.MutableState;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.compose.LottieAnimatable;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.airbnb.lottie.compose.AnimateLottieCompositionAsStateKt$animateLottieCompositionAsState$3", f = "animateLottieCompositionAsState.kt", l = {73, 78}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class AnimateLottieCompositionAsStateKt$animateLottieCompositionAsState$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ float $actualSpeed;
    final /* synthetic */ LottieAnimatable $animatable;
    final /* synthetic */ LottieCancellationBehavior $cancellationBehavior;
    final /* synthetic */ LottieClipSpec $clipSpec;
    final /* synthetic */ LottieComposition $composition;
    final /* synthetic */ boolean $isPlaying;
    final /* synthetic */ int $iterations;
    final /* synthetic */ boolean $restartOnPlay;
    final /* synthetic */ boolean $reverseOnRepeat;
    final /* synthetic */ boolean $useCompositionFrameRate;
    final /* synthetic */ MutableState<Boolean> $wasPlaying$delegate;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AnimateLottieCompositionAsStateKt$animateLottieCompositionAsState$3(boolean z5, boolean z6, LottieAnimatable lottieAnimatable, LottieComposition lottieComposition, int i5, boolean z7, float f5, LottieClipSpec lottieClipSpec, LottieCancellationBehavior lottieCancellationBehavior, boolean z8, MutableState<Boolean> mutableState, Continuation<? super AnimateLottieCompositionAsStateKt$animateLottieCompositionAsState$3> continuation) {
        super(2, continuation);
        this.$isPlaying = z5;
        this.$restartOnPlay = z6;
        this.$animatable = lottieAnimatable;
        this.$composition = lottieComposition;
        this.$iterations = i5;
        this.$reverseOnRepeat = z7;
        this.$actualSpeed = f5;
        this.$clipSpec = lottieClipSpec;
        this.$cancellationBehavior = lottieCancellationBehavior;
        this.$useCompositionFrameRate = z8;
        this.$wasPlaying$delegate = mutableState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AnimateLottieCompositionAsStateKt$animateLottieCompositionAsState$3(this.$isPlaying, this.$restartOnPlay, this.$animatable, this.$composition, this.$iterations, this.$reverseOnRepeat, this.$actualSpeed, this.$clipSpec, this.$cancellationBehavior, this.$useCompositionFrameRate, this.$wasPlaying$delegate, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        boolean m2751animateLottieCompositionAsState$lambda3;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = this.label;
        if (i5 == 0) {
            ResultKt.throwOnFailure(obj);
            if (this.$isPlaying) {
                m2751animateLottieCompositionAsState$lambda3 = AnimateLottieCompositionAsStateKt.m2751animateLottieCompositionAsState$lambda3(this.$wasPlaying$delegate);
                if (!m2751animateLottieCompositionAsState$lambda3 && this.$restartOnPlay) {
                    LottieAnimatable lottieAnimatable = this.$animatable;
                    this.label = 1;
                    if (LottieAnimatableKt.resetToBeginning(lottieAnimatable, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
            }
        } else {
            if (i5 != 1) {
                if (i5 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            }
            ResultKt.throwOnFailure(obj);
        }
        AnimateLottieCompositionAsStateKt.m2752animateLottieCompositionAsState$lambda4(this.$wasPlaying$delegate, this.$isPlaying);
        if (!this.$isPlaying) {
            return Unit.INSTANCE;
        }
        LottieAnimatable lottieAnimatable2 = this.$animatable;
        LottieComposition lottieComposition = this.$composition;
        int i6 = this.$iterations;
        boolean z5 = this.$reverseOnRepeat;
        float f5 = this.$actualSpeed;
        LottieClipSpec lottieClipSpec = this.$clipSpec;
        float progress = lottieAnimatable2.getProgress();
        LottieCancellationBehavior lottieCancellationBehavior = this.$cancellationBehavior;
        boolean z6 = this.$useCompositionFrameRate;
        this.label = 2;
        if (LottieAnimatable.DefaultImpls.animate$default(lottieAnimatable2, lottieComposition, 0, i6, z5, f5, lottieClipSpec, progress, false, lottieCancellationBehavior, false, z6, this, 514, null) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AnimateLottieCompositionAsStateKt$animateLottieCompositionAsState$3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
