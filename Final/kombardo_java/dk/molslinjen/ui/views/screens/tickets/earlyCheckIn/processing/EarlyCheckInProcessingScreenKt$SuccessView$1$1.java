package dk.molslinjen.ui.views.screens.tickets.earlyCheckIn.processing;

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
@DebugMetadata(c = "dk.molslinjen.ui.views.screens.tickets.earlyCheckIn.processing.EarlyCheckInProcessingScreenKt$SuccessView$1$1", f = "EarlyCheckInProcessingScreen.kt", l = {135}, m = "invokeSuspend")
/* loaded from: classes2.dex */
public final class EarlyCheckInProcessingScreenKt$SuccessView$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ LottieAnimatable $animatable;
    final /* synthetic */ LottieCompositionResult $composition$delegate;
    final /* synthetic */ LottieClipSpec.Markers $expandMarker;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EarlyCheckInProcessingScreenKt$SuccessView$1$1(LottieAnimatable lottieAnimatable, LottieClipSpec.Markers markers, LottieCompositionResult lottieCompositionResult, Continuation<? super EarlyCheckInProcessingScreenKt$SuccessView$1$1> continuation) {
        super(2, continuation);
        this.$animatable = lottieAnimatable;
        this.$expandMarker = markers;
        this.$composition$delegate = lottieCompositionResult;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new EarlyCheckInProcessingScreenKt$SuccessView$1$1(this.$animatable, this.$expandMarker, this.$composition$delegate, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        LottieComposition SuccessView$lambda$11;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = this.label;
        if (i5 == 0) {
            ResultKt.throwOnFailure(obj);
            LottieAnimatable lottieAnimatable = this.$animatable;
            SuccessView$lambda$11 = EarlyCheckInProcessingScreenKt.SuccessView$lambda$11(this.$composition$delegate);
            LottieClipSpec.Markers markers = this.$expandMarker;
            this.label = 1;
            if (LottieAnimatable.DefaultImpls.animate$default(lottieAnimatable, SuccessView$lambda$11, 0, 1, false, 1.0f, markers, 0.0f, false, null, false, false, this, 1994, null) == coroutine_suspended) {
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
        return ((EarlyCheckInProcessingScreenKt$SuccessView$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
