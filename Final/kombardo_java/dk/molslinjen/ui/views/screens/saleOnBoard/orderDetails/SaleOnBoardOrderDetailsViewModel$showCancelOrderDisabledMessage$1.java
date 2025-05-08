package dk.molslinjen.ui.views.screens.saleOnBoard.orderDetails;

import dk.molslinjen.core.snackbar.ISnackbarService;
import dk.molslinjen.core.snackbar.SnackbarEvent;
import dk.molslinjen.core.snackbar.SnackbarText;
import dk.molslinjen.kombardo.R;
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
@DebugMetadata(c = "dk.molslinjen.ui.views.screens.saleOnBoard.orderDetails.SaleOnBoardOrderDetailsViewModel$showCancelOrderDisabledMessage$1", f = "SaleOnBoardOrderDetailsViewModel.kt", l = {86}, m = "invokeSuspend")
/* loaded from: classes2.dex */
public final class SaleOnBoardOrderDetailsViewModel$showCancelOrderDisabledMessage$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ SaleOnBoardOrderDetailsViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SaleOnBoardOrderDetailsViewModel$showCancelOrderDisabledMessage$1(SaleOnBoardOrderDetailsViewModel saleOnBoardOrderDetailsViewModel, Continuation<? super SaleOnBoardOrderDetailsViewModel$showCancelOrderDisabledMessage$1> continuation) {
        super(2, continuation);
        this.this$0 = saleOnBoardOrderDetailsViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SaleOnBoardOrderDetailsViewModel$showCancelOrderDisabledMessage$1(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        ISnackbarService iSnackbarService;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = this.label;
        if (i5 == 0) {
            ResultKt.throwOnFailure(obj);
            iSnackbarService = this.this$0.snackbarService;
            SnackbarEvent.Error error = new SnackbarEvent.Error(new SnackbarText.ResourceText(R.string.saleOnBoard_orderDetails_canNotCancel));
            this.label = 1;
            if (iSnackbarService.publishEvent(error, this) == coroutine_suspended) {
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
        return ((SaleOnBoardOrderDetailsViewModel$showCancelOrderDisabledMessage$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
