package dk.molslinjen.ui.views.reusable.lottie;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.compose.LottieAnimatable;
import com.airbnb.lottie.compose.LottieClipSpec;
import com.airbnb.lottie.compose.LottieCompositionResult;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.conscrypt.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.ui.views.reusable.lottie.ShrinkingCheckmarkAnimationViewKt$LottieView$1$1", f = "ShrinkingCheckmarkAnimationView.kt", l = {225}, m = "invokeSuspend")
/* loaded from: classes2.dex */
public final class ShrinkingCheckmarkAnimationViewKt$LottieView$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ LottieAnimatable $animatable;
    final /* synthetic */ LottieCompositionResult $composition$delegate;
    final /* synthetic */ LottieClipSpec $marker;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShrinkingCheckmarkAnimationViewKt$LottieView$1$1(LottieAnimatable lottieAnimatable, LottieClipSpec lottieClipSpec, LottieCompositionResult lottieCompositionResult, Continuation<? super ShrinkingCheckmarkAnimationViewKt$LottieView$1$1> continuation) {
        super(2, continuation);
        this.$animatable = lottieAnimatable;
        this.$marker = lottieClipSpec;
        this.$composition$delegate = lottieCompositionResult;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ShrinkingCheckmarkAnimationViewKt$LottieView$1$1(this.$animatable, this.$marker, this.$composition$delegate, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        LottieComposition LottieView$lambda$47;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = this.label;
        if (i5 == 0) {
            ResultKt.throwOnFailure(obj);
            LottieAnimatable lottieAnimatable = this.$animatable;
            LottieView$lambda$47 = ShrinkingCheckmarkAnimationViewKt.LottieView$lambda$47(this.$composition$delegate);
            LottieClipSpec lottieClipSpec = this.$marker;
            this.label = 1;
            if (LottieAnimatable.DefaultImpls.animate$default(lottieAnimatable, LottieView$lambda$47, 0, 1, false, 1.0f, lottieClipSpec, 0.0f, false, null, false, false, this, 1994, null) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i5 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ShrinkingCheckmarkAnimationViewKt$LottieView$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
