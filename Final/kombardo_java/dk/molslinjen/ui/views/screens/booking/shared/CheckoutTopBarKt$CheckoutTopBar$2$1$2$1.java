package dk.molslinjen.ui.views.screens.booking.shared;

import androidx.compose.foundation.ScrollState;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.geometry.Rect;
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

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.ui.views.screens.booking.shared.CheckoutTopBarKt$CheckoutTopBar$2$1$2$1", f = "CheckoutTopBar.kt", l = {103}, m = "invokeSuspend")
/* loaded from: classes2.dex */
final class CheckoutTopBarKt$CheckoutTopBar$2$1$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableState<Rect> $activeSectionBoundsInParent;
    final /* synthetic */ MutableState<Integer> $barWidth;
    final /* synthetic */ ScrollState $scrollState;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CheckoutTopBarKt$CheckoutTopBar$2$1$2$1(MutableState<Rect> mutableState, MutableState<Integer> mutableState2, ScrollState scrollState, Continuation<? super CheckoutTopBarKt$CheckoutTopBar$2$1$2$1> continuation) {
        super(2, continuation);
        this.$activeSectionBoundsInParent = mutableState;
        this.$barWidth = mutableState2;
        this.$scrollState = scrollState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CheckoutTopBarKt$CheckoutTopBar$2$1$2$1(this.$activeSectionBoundsInParent, this.$barWidth, this.$scrollState, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = this.label;
        if (i5 == 0) {
            ResultKt.throwOnFailure(obj);
            double left = ((int) (this.$activeSectionBoundsInParent.getValue().getLeft() + (this.$activeSectionBoundsInParent.getValue().getWidth() / 2))) - (this.$barWidth.getValue().intValue() / 2);
            this.label = 1;
            if (ScrollState.animateScrollTo$default(this.$scrollState, (int) left, null, this, 2, null) == coroutine_suspended) {
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
        return ((CheckoutTopBarKt$CheckoutTopBar$2$1$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
