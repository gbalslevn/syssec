package dk.molslinjen.ui.views.screens.booking.addons.seating.select;

import dk.molslinjen.core.snackbar.ISnackbarService;
import dk.molslinjen.domain.managers.ManagerResult;
import dk.molslinjen.domain.managers.seating.ISelectSeatingManager;
import dk.molslinjen.domain.model.booking.DepartureDirection;
import dk.molslinjen.extensions.ManagerResultExtensionsKt;
import dk.molslinjen.ui.views.screens.booking.addons.seating.select.FerrySectionSeatsViewModel;
import kotlin.Metadata;
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
@DebugMetadata(c = "dk.molslinjen.ui.views.screens.booking.addons.seating.select.FerrySectionSeatsViewModel$loadFerryData$1", f = "FerrySectionSeatsViewModel.kt", l = {73, 74}, m = "invokeSuspend")
/* loaded from: classes2.dex */
public final class FerrySectionSeatsViewModel$loadFerryData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ DepartureDirection $departureDirection;
    int label;
    final /* synthetic */ FerrySectionSeatsViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FerrySectionSeatsViewModel$loadFerryData$1(FerrySectionSeatsViewModel ferrySectionSeatsViewModel, DepartureDirection departureDirection, Continuation<? super FerrySectionSeatsViewModel$loadFerryData$1> continuation) {
        super(2, continuation);
        this.this$0 = ferrySectionSeatsViewModel;
        this.$departureDirection = departureDirection;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new FerrySectionSeatsViewModel$loadFerryData$1(this.this$0, this.$departureDirection, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        MutableStateFlow mutableStateFlow;
        Object value;
        ISelectSeatingManager iSelectSeatingManager;
        Object fetchFloorPlan;
        ISnackbarService iSnackbarService;
        MutableStateFlow mutableStateFlow2;
        Object value2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = this.label;
        if (i5 == 0) {
            ResultKt.throwOnFailure(obj);
            mutableStateFlow = this.this$0._viewState;
            do {
                value = mutableStateFlow.getValue();
            } while (!mutableStateFlow.compareAndSet(value, FerrySectionSeatsViewModel.ViewState.m3453copyBn6Y4c$default((FerrySectionSeatsViewModel.ViewState) value, true, null, null, null, null, false, null, false, false, null, null, 2046, null)));
            iSelectSeatingManager = this.this$0.seatReservationManager;
            DepartureDirection departureDirection = this.$departureDirection;
            this.label = 1;
            fetchFloorPlan = iSelectSeatingManager.fetchFloorPlan(departureDirection, this);
            if (fetchFloorPlan == coroutine_suspended) {
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
                } while (!mutableStateFlow2.compareAndSet(value2, FerrySectionSeatsViewModel.ViewState.m3453copyBn6Y4c$default((FerrySectionSeatsViewModel.ViewState) value2, false, null, null, null, null, false, null, false, false, null, null, 2046, null)));
                return Unit.INSTANCE;
            }
            ResultKt.throwOnFailure(obj);
            fetchFloorPlan = obj;
        }
        iSnackbarService = this.this$0.snackbarService;
        this.label = 2;
        if (ManagerResultExtensionsKt.handlePotentialError((ManagerResult) fetchFloorPlan, iSnackbarService, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        mutableStateFlow2 = this.this$0._viewState;
        do {
            value2 = mutableStateFlow2.getValue();
        } while (!mutableStateFlow2.compareAndSet(value2, FerrySectionSeatsViewModel.ViewState.m3453copyBn6Y4c$default((FerrySectionSeatsViewModel.ViewState) value2, false, null, null, null, null, false, null, false, false, null, null, 2046, null)));
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((FerrySectionSeatsViewModel$loadFerryData$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
