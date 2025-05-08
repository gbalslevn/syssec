package dk.molslinjen.ui.views.screens.saleOnBoard.orderDetails;

import androidx.compose.foundation.ScrollState;
import dk.molslinjen.domain.model.saleOnBoard.SaleOnBoardOrder;
import dk.molslinjen.ui.views.screens.saleOnBoard.orderDetails.SaleOnBoardOrderDetailsViewModel;
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
@DebugMetadata(c = "dk.molslinjen.ui.views.screens.saleOnBoard.orderDetails.SaleOnBoardOrderDetailsScreenKt$SaleOnBoardOrderDetailsContent$1$1", f = "SaleOnBoardOrderDetailsScreen.kt", l = {122}, m = "invokeSuspend")
/* loaded from: classes2.dex */
final class SaleOnBoardOrderDetailsScreenKt$SaleOnBoardOrderDetailsContent$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ScrollState $scrollState;
    final /* synthetic */ SaleOnBoardOrderDetailsViewModel.ViewState $state;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SaleOnBoardOrderDetailsScreenKt$SaleOnBoardOrderDetailsContent$1$1(SaleOnBoardOrderDetailsViewModel.ViewState viewState, ScrollState scrollState, Continuation<? super SaleOnBoardOrderDetailsScreenKt$SaleOnBoardOrderDetailsContent$1$1> continuation) {
        super(2, continuation);
        this.$state = viewState;
        this.$scrollState = scrollState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SaleOnBoardOrderDetailsScreenKt$SaleOnBoardOrderDetailsContent$1$1(this.$state, this.$scrollState, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = this.label;
        if (i5 == 0) {
            ResultKt.throwOnFailure(obj);
            SaleOnBoardOrder order = this.$state.getOrder();
            if ((order != null ? order.getStatus() : null) == SaleOnBoardOrder.OrderStatus.Cancelled) {
                ScrollState scrollState = this.$scrollState;
                this.label = 1;
                if (ScrollState.animateScrollTo$default(scrollState, 0, null, this, 2, null) == coroutine_suspended) {
                    return coroutine_suspended;
                }
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
        return ((SaleOnBoardOrderDetailsScreenKt$SaleOnBoardOrderDetailsContent$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
