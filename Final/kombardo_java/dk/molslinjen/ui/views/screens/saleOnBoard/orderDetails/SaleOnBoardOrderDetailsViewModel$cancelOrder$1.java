package dk.molslinjen.ui.views.screens.saleOnBoard.orderDetails;

import dk.molslinjen.core.snackbar.ISnackbarService;
import dk.molslinjen.core.snackbar.SnackbarEvent;
import dk.molslinjen.core.snackbar.SnackbarText;
import dk.molslinjen.domain.analytics.IAnalyticsTracker;
import dk.molslinjen.domain.analytics.SaleOnBoardAnalyticsEvent;
import dk.molslinjen.domain.extensions.ManagerResultExtensionsKt;
import dk.molslinjen.domain.managers.ManagerResult;
import dk.molslinjen.domain.managers.saleOnBoard.ISaleOnBoardManager;
import dk.molslinjen.domain.model.saleOnBoard.SaleOnBoardOrder;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.views.screens.saleOnBoard.orderDetails.SaleOnBoardOrderDetailsViewModel;
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
import kotlinx.coroutines.flow.MutableStateFlow;
import org.conscrypt.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.ui.views.screens.saleOnBoard.orderDetails.SaleOnBoardOrderDetailsViewModel$cancelOrder$1", f = "SaleOnBoardOrderDetailsViewModel.kt", l = {68, 69}, m = "invokeSuspend")
/* loaded from: classes2.dex */
public final class SaleOnBoardOrderDetailsViewModel$cancelOrder$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ SaleOnBoardOrder $saleOnBoardOrder;
    int label;
    final /* synthetic */ SaleOnBoardOrderDetailsViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "dk.molslinjen.ui.views.screens.saleOnBoard.orderDetails.SaleOnBoardOrderDetailsViewModel$cancelOrder$1$2", f = "SaleOnBoardOrderDetailsViewModel.kt", l = {70}, m = "invokeSuspend")
    /* renamed from: dk.molslinjen.ui.views.screens.saleOnBoard.orderDetails.SaleOnBoardOrderDetailsViewModel$cancelOrder$1$2, reason: invalid class name */
    /* loaded from: classes2.dex */
    public static final class AnonymousClass2 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ SaleOnBoardOrderDetailsViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(SaleOnBoardOrderDetailsViewModel saleOnBoardOrderDetailsViewModel, Continuation<? super AnonymousClass2> continuation) {
            super(1, continuation);
            this.this$0 = saleOnBoardOrderDetailsViewModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new AnonymousClass2(this.this$0, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            ISnackbarService iSnackbarService;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i5 = this.label;
            if (i5 == 0) {
                ResultKt.throwOnFailure(obj);
                iSnackbarService = this.this$0.snackbarService;
                SnackbarEvent.Error error = new SnackbarEvent.Error(new SnackbarText.ResourceText(R.string.saleOnBoard_orderDetails_cancelOrderFailed));
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

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SaleOnBoardOrderDetailsViewModel$cancelOrder$1(SaleOnBoardOrderDetailsViewModel saleOnBoardOrderDetailsViewModel, SaleOnBoardOrder saleOnBoardOrder, Continuation<? super SaleOnBoardOrderDetailsViewModel$cancelOrder$1> continuation) {
        super(2, continuation);
        this.this$0 = saleOnBoardOrderDetailsViewModel;
        this.$saleOnBoardOrder = saleOnBoardOrder;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SaleOnBoardOrderDetailsViewModel$cancelOrder$1(this.this$0, this.$saleOnBoardOrder, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        MutableStateFlow mutableStateFlow;
        Object value;
        ISaleOnBoardManager iSaleOnBoardManager;
        MutableStateFlow mutableStateFlow2;
        Object value2;
        IAnalyticsTracker iAnalyticsTracker;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = this.label;
        if (i5 == 0) {
            ResultKt.throwOnFailure(obj);
            mutableStateFlow = this.this$0._viewState;
            do {
                value = mutableStateFlow.getValue();
            } while (!mutableStateFlow.compareAndSet(value, SaleOnBoardOrderDetailsViewModel.ViewState.copy$default((SaleOnBoardOrderDetailsViewModel.ViewState) value, false, null, false, true, 7, null)));
            iSaleOnBoardManager = this.this$0.saleOnBoardManager;
            SaleOnBoardOrder saleOnBoardOrder = this.$saleOnBoardOrder;
            this.label = 1;
            obj = iSaleOnBoardManager.cancelOrder(saleOnBoardOrder, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i5 != 1) {
                if (i5 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                mutableStateFlow2 = this.this$0._viewState;
                do {
                    value2 = mutableStateFlow2.getValue();
                } while (!mutableStateFlow2.compareAndSet(value2, SaleOnBoardOrderDetailsViewModel.ViewState.copy$default((SaleOnBoardOrderDetailsViewModel.ViewState) value2, false, null, false, false, 3, null)));
                this.this$0.loadOrder(this.$saleOnBoardOrder.getOrderNumber());
                iAnalyticsTracker = this.this$0.analyticsTracker;
                iAnalyticsTracker.trackSaleOnBoardEvent(new SaleOnBoardAnalyticsEvent.RefundOrder(this.$saleOnBoardOrder));
                return Unit.INSTANCE;
            }
            ResultKt.throwOnFailure(obj);
        }
        AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.this$0, null);
        this.label = 2;
        if (ManagerResultExtensionsKt.onFailure((ManagerResult) obj, anonymousClass2, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        mutableStateFlow2 = this.this$0._viewState;
        do {
            value2 = mutableStateFlow2.getValue();
        } while (!mutableStateFlow2.compareAndSet(value2, SaleOnBoardOrderDetailsViewModel.ViewState.copy$default((SaleOnBoardOrderDetailsViewModel.ViewState) value2, false, null, false, false, 3, null)));
        this.this$0.loadOrder(this.$saleOnBoardOrder.getOrderNumber());
        iAnalyticsTracker = this.this$0.analyticsTracker;
        iAnalyticsTracker.trackSaleOnBoardEvent(new SaleOnBoardAnalyticsEvent.RefundOrder(this.$saleOnBoardOrder));
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SaleOnBoardOrderDetailsViewModel$cancelOrder$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
