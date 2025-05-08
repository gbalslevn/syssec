package dk.molslinjen.ui.views.screens.booking.departures.selectTrailers;

import dk.molslinjen.core.snackbar.ISnackbarService;
import dk.molslinjen.domain.managers.ManagerResult;
import dk.molslinjen.domain.managers.checkout.IReturnManager;
import dk.molslinjen.domain.managers.route.IRouteManager;
import dk.molslinjen.domain.managers.route.RouteSelectedState;
import dk.molslinjen.domain.model.booking.BookingType;
import dk.molslinjen.domain.model.booking.product.TrailerProduct;
import dk.molslinjen.extensions.ManagerResultExtensionsKt;
import dk.molslinjen.ui.views.screens.booking.departures.selectTrailers.TrailerSelectorViewModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableStateFlow;
import org.conscrypt.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.ui.views.screens.booking.departures.selectTrailers.TrailerSelectorViewModel$loadTrailers$1", f = "TrailerSelectorViewModel.kt", l = {39, 40}, m = "invokeSuspend")
/* loaded from: classes2.dex */
public final class TrailerSelectorViewModel$loadTrailers$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ TrailerSelectorViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TrailerSelectorViewModel$loadTrailers$1(TrailerSelectorViewModel trailerSelectorViewModel, Continuation<? super TrailerSelectorViewModel$loadTrailers$1> continuation) {
        super(2, continuation);
        this.this$0 = trailerSelectorViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TrailerSelectorViewModel$loadTrailers$1(this.this$0, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x005d  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        IRouteManager iRouteManager;
        Object loadTrailers;
        ISnackbarService iSnackbarService;
        ManagerResult managerResult;
        MutableStateFlow mutableStateFlow;
        Object value;
        TrailerSelectorViewModel.ViewState copy$default;
        IRouteManager iRouteManager2;
        RouteSelectedState value2;
        IRouteManager iRouteManager3;
        TrailerProduct selectedTrailer;
        boolean z5;
        MutableStateFlow mutableStateFlow2;
        TrailerSelectorViewModel trailerSelectorViewModel;
        Object value3;
        IRouteManager iRouteManager4;
        BookingType value4;
        IReturnManager iReturnManager;
        MutableStateFlow mutableStateFlow3;
        Object value5;
        TrailerSelectorViewModel.TrailerSelectedState trailerSelectedState;
        IRouteManager iRouteManager5;
        RouteSelectedState value6;
        MutableStateFlow mutableStateFlow4;
        Object value7;
        TrailerSelectorViewModel.TrailerSelectedState trailerSelectedState2;
        IRouteManager iRouteManager6;
        RouteSelectedState value8;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = this.label;
        if (i5 == 0) {
            ResultKt.throwOnFailure(obj);
            iRouteManager = this.this$0.routeManager;
            this.label = 1;
            loadTrailers = iRouteManager.loadTrailers(this);
            if (loadTrailers == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i5 != 1) {
                if (i5 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                managerResult = (ManagerResult) this.L$0;
                ResultKt.throwOnFailure(obj);
                mutableStateFlow = this.this$0._viewState;
                do {
                    value = mutableStateFlow.getValue();
                    TrailerSelectorViewModel.ViewState viewState = (TrailerSelectorViewModel.ViewState) value;
                    if (!(managerResult instanceof ManagerResult.Success)) {
                        copy$default = TrailerSelectorViewModel.ViewState.copy$default(viewState, false, false, false, null, (List) ((ManagerResult.Success) managerResult).getData(), false, 44, null);
                    } else {
                        if (!(managerResult instanceof ManagerResult.Error)) {
                            throw new NoWhenBranchMatchedException();
                        }
                        copy$default = TrailerSelectorViewModel.ViewState.copy$default(viewState, true, false, false, null, null, false, 60, null);
                    }
                } while (!mutableStateFlow.compareAndSet(value, copy$default));
                iRouteManager2 = this.this$0.routeManager;
                value2 = iRouteManager2.getOutboundSelectedState().getValue();
                if (value2 != null || (selectedTrailer = value2.getSelectedTrailer()) == null) {
                    iRouteManager3 = this.this$0.routeManager;
                    RouteSelectedState value9 = iRouteManager3.getReturnSelectedState().getValue();
                    selectedTrailer = value9 == null ? value9.getSelectedTrailer() : null;
                }
                z5 = selectedTrailer != null;
                mutableStateFlow2 = this.this$0._viewState;
                trailerSelectorViewModel = this.this$0;
                do {
                    value3 = mutableStateFlow2.getValue();
                    iRouteManager4 = trailerSelectorViewModel.routeManager;
                    value4 = iRouteManager4.getBookingTypeState().getValue();
                    iReturnManager = trailerSelectorViewModel.returnManager;
                } while (!mutableStateFlow2.compareAndSet(value3, TrailerSelectorViewModel.ViewState.copy$default((TrailerSelectorViewModel.ViewState) value3, false, false, iReturnManager.getReturnState().getValue().getIsAddingReturnFromBookingSummary(), value4, null, z5, 19, null)));
                if (!this.this$0.getViewState().getValue().getTrailers().isEmpty()) {
                    mutableStateFlow3 = this.this$0._outboundTrailerState;
                    TrailerSelectorViewModel trailerSelectorViewModel2 = this.this$0;
                    do {
                        value5 = mutableStateFlow3.getValue();
                        trailerSelectedState = (TrailerSelectorViewModel.TrailerSelectedState) value5;
                        iRouteManager5 = trailerSelectorViewModel2.routeManager;
                        value6 = iRouteManager5.getOutboundSelectedState().getValue();
                    } while (!mutableStateFlow3.compareAndSet(value5, trailerSelectedState.copy(value6 != null ? value6.getSelectedTrailer() : null)));
                    mutableStateFlow4 = this.this$0._returnTrailerState;
                    TrailerSelectorViewModel trailerSelectorViewModel3 = this.this$0;
                    do {
                        value7 = mutableStateFlow4.getValue();
                        trailerSelectedState2 = (TrailerSelectorViewModel.TrailerSelectedState) value7;
                        iRouteManager6 = trailerSelectorViewModel3.routeManager;
                        value8 = iRouteManager6.getReturnSelectedState().getValue();
                    } while (!mutableStateFlow4.compareAndSet(value7, trailerSelectedState2.copy(value8 != null ? value8.getSelectedTrailer() : null)));
                }
                return Unit.INSTANCE;
            }
            ResultKt.throwOnFailure(obj);
            loadTrailers = obj;
        }
        ManagerResult managerResult2 = (ManagerResult) loadTrailers;
        iSnackbarService = this.this$0.snackbarService;
        this.L$0 = managerResult2;
        this.label = 2;
        if (ManagerResultExtensionsKt.handlePotentialError(managerResult2, iSnackbarService, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        managerResult = managerResult2;
        mutableStateFlow = this.this$0._viewState;
        do {
            value = mutableStateFlow.getValue();
            TrailerSelectorViewModel.ViewState viewState2 = (TrailerSelectorViewModel.ViewState) value;
            if (!(managerResult instanceof ManagerResult.Success)) {
            }
        } while (!mutableStateFlow.compareAndSet(value, copy$default));
        iRouteManager2 = this.this$0.routeManager;
        value2 = iRouteManager2.getOutboundSelectedState().getValue();
        if (value2 != null) {
        }
        iRouteManager3 = this.this$0.routeManager;
        RouteSelectedState value92 = iRouteManager3.getReturnSelectedState().getValue();
        if (value92 == null) {
        }
        z5 = selectedTrailer != null;
        mutableStateFlow2 = this.this$0._viewState;
        trailerSelectorViewModel = this.this$0;
        do {
            value3 = mutableStateFlow2.getValue();
            iRouteManager4 = trailerSelectorViewModel.routeManager;
            value4 = iRouteManager4.getBookingTypeState().getValue();
            iReturnManager = trailerSelectorViewModel.returnManager;
        } while (!mutableStateFlow2.compareAndSet(value3, TrailerSelectorViewModel.ViewState.copy$default((TrailerSelectorViewModel.ViewState) value3, false, false, iReturnManager.getReturnState().getValue().getIsAddingReturnFromBookingSummary(), value4, null, z5, 19, null)));
        if (!this.this$0.getViewState().getValue().getTrailers().isEmpty()) {
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((TrailerSelectorViewModel$loadTrailers$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
