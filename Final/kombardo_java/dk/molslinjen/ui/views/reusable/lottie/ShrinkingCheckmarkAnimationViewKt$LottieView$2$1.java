package dk.molslinjen.ui.views.reusable.lottie;

import com.airbnb.lottie.compose.LottieAnimatable;
import com.airbnb.lottie.compose.LottieClipSpec;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.ui.views.reusable.lottie.ShrinkingCheckmarkAnimationViewKt$LottieView$2$1", f = "ShrinkingCheckmarkAnimationView.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes2.dex */
final class ShrinkingCheckmarkAnimationViewKt$LottieView$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ LottieAnimatable $animatable;
    final /* synthetic */ LottieClipSpec $marker;
    final /* synthetic */ Function1<LottieClipSpec, Unit> $onCompletion;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ShrinkingCheckmarkAnimationViewKt$LottieView$2$1(LottieAnimatable lottieAnimatable, Function1<? super LottieClipSpec, Unit> function1, LottieClipSpec lottieClipSpec, Continuation<? super ShrinkingCheckmarkAnimationViewKt$LottieView$2$1> continuation) {
        super(2, continuation);
        this.$animatable = lottieAnimatable;
        this.$onCompletion = function1;
        this.$marker = lottieClipSpec;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ShrinkingCheckmarkAnimationViewKt$LottieView$2$1(this.$animatable, this.$onCompletion, this.$marker, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        if (this.$animatable.isAtEnd() && this.$animatable.getProgress() != 0.0f) {
            this.$onCompletion.invoke(this.$marker);
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ShrinkingCheckmarkAnimationViewKt$LottieView$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
