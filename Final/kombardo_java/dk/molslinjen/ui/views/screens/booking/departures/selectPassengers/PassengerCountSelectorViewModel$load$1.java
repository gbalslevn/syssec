package dk.molslinjen.ui.views.screens.booking.departures.selectPassengers;

import dk.molslinjen.core.snackbar.ISnackbarService;
import dk.molslinjen.domain.managers.checkout.IReturnManager;
import dk.molslinjen.domain.managers.route.IRouteManager;
import dk.molslinjen.domain.managers.route.RouteSelectedState;
import dk.molslinjen.domain.managers.route.RouteSharedSelectedState;
import dk.molslinjen.domain.managers.route.RouteState;
import dk.molslinjen.domain.model.booking.PassengerInfo;
import dk.molslinjen.domain.model.config.AgeClassifications;
import dk.molslinjen.domain.model.config.Transportation;
import dk.molslinjen.extensions.IntRangeExtensionsKt;
import dk.molslinjen.ui.views.screens.booking.departures.selectPassengers.PassengerCountSelectorViewModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableStateFlow;
import org.conscrypt.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.ui.views.screens.booking.departures.selectPassengers.PassengerCountSelectorViewModel$load$1", f = "PassengerCountSelectorViewModel.kt", l = {42, 44}, m = "invokeSuspend")
/* loaded from: classes2.dex */
public final class PassengerCountSelectorViewModel$load$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ PassengerCountSelectorViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PassengerCountSelectorViewModel$load$1(PassengerCountSelectorViewModel passengerCountSelectorViewModel, Continuation<? super PassengerCountSelectorViewModel$load$1> continuation) {
        super(2, continuation);
        this.this$0 = passengerCountSelectorViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PassengerCountSelectorViewModel$load$1(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IRouteManager iRouteManager;
        IRouteManager iRouteManager2;
        IRouteManager iRouteManager3;
        IRouteManager iRouteManager4;
        MutableStateFlow mutableStateFlow;
        Object value;
        Transportation selectedTransportation;
        String format;
        String format2;
        IRouteManager iRouteManager5;
        IReturnManager iReturnManager;
        MutableStateFlow mutableStateFlow2;
        Object value2;
        MutableStateFlow mutableStateFlow3;
        Object value3;
        ISnackbarService iSnackbarService;
        ISnackbarService iSnackbarService2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = this.label;
        if (i5 != 0) {
            if (i5 == 1) {
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            }
            if (i5 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return Unit.INSTANCE;
        }
        ResultKt.throwOnFailure(obj);
        iRouteManager = this.this$0.routeManager;
        RouteState value4 = iRouteManager.getRouteState().getValue();
        if (value4 == null) {
            iSnackbarService2 = this.this$0.snackbarService;
            this.label = 1;
            if (iSnackbarService2.publishGenericError(this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            return Unit.INSTANCE;
        }
        iRouteManager2 = this.this$0.routeManager;
        RouteSharedSelectedState value5 = iRouteManager2.getSharedSelectedState().getValue();
        if (value5 == null) {
            iSnackbarService = this.this$0.snackbarService;
            this.label = 2;
            if (iSnackbarService.publishGenericError(this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            return Unit.INSTANCE;
        }
        iRouteManager3 = this.this$0.routeManager;
        RouteSelectedState value6 = iRouteManager3.getOutboundSelectedState().getValue();
        PassengerInfo passengerInfo = value6 != null ? value6.getPassengerInfo() : null;
        iRouteManager4 = this.this$0.routeManager;
        RouteSelectedState value7 = iRouteManager4.getReturnSelectedState().getValue();
        PassengerInfo passengerInfo2 = value7 != null ? value7.getPassengerInfo() : null;
        AgeClassifications ageClassifications = value4.getConfiguration().getAgeClassifications();
        boolean z5 = (passengerInfo2 == null || Intrinsics.areEqual(passengerInfo, passengerInfo2)) ? false : true;
        mutableStateFlow = this.this$0._viewState;
        PassengerCountSelectorViewModel passengerCountSelectorViewModel = this.this$0;
        do {
            value = mutableStateFlow.getValue();
            selectedTransportation = value5.getSelectedTransportation();
            format = IntRangeExtensionsKt.format(ageClassifications.getChildRange());
            format2 = IntRangeExtensionsKt.format(ageClassifications.getInfantRange());
            iRouteManager5 = passengerCountSelectorViewModel.routeManager;
            iReturnManager = passengerCountSelectorViewModel.returnManager;
        } while (!mutableStateFlow.compareAndSet(value, new PassengerCountSelectorViewModel.ViewState(iRouteManager5.getBookingTypeState().getValue(), !z5, format, format2, selectedTransportation, iReturnManager.getReturnState().getValue().getIsAddingReturnFromBookingSummary())));
        if (passengerInfo != null) {
            mutableStateFlow3 = this.this$0._outboundPassengerState;
            do {
                value3 = mutableStateFlow3.getValue();
            } while (!mutableStateFlow3.compareAndSet(value3, new PassengerCountSelectorViewModel.PassengerSelectionState(passengerInfo.getAdultCount(), passengerInfo.getChildCount(), passengerInfo.getInfantCount())));
        }
        if (passengerInfo2 != null) {
            mutableStateFlow2 = this.this$0._returnPassengerState;
            do {
                value2 = mutableStateFlow2.getValue();
            } while (!mutableStateFlow2.compareAndSet(value2, new PassengerCountSelectorViewModel.PassengerSelectionState(passengerInfo2.getAdultCount(), passengerInfo2.getChildCount(), passengerInfo2.getInfantCount())));
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((PassengerCountSelectorViewModel$load$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
