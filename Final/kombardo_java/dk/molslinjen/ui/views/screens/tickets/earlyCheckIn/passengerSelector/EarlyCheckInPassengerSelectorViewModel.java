package dk.molslinjen.ui.views.screens.tickets.earlyCheckIn.passengerSelector;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import dk.molslinjen.core.snackbar.ISnackbarService;
import dk.molslinjen.domain.managers.checkout.IEarlyCheckInPassengerManager;
import dk.molslinjen.domain.managers.checkout.PassengerSelectionHelper;
import dk.molslinjen.domain.managers.checkout.passengers.ISharedPassengerSelectionViewState;
import dk.molslinjen.domain.managers.ticket.ITicketsManager;
import dk.molslinjen.domain.model.booking.Booking;
import dk.molslinjen.domain.model.booking.BookingPassenger;
import dk.molslinjen.domain.model.booking.PassengerInfo;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\u001cB!\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017J\u0006\u0010\u0018\u001a\u00020\u0015J\u000e\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u001bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010¨\u0006\u001d"}, d2 = {"Ldk/molslinjen/ui/views/screens/tickets/earlyCheckIn/passengerSelector/EarlyCheckInPassengerSelectorViewModel;", "Landroidx/lifecycle/ViewModel;", "earlyCheckInPassengerManager", "Ldk/molslinjen/domain/managers/checkout/IEarlyCheckInPassengerManager;", "ticketsManager", "Ldk/molslinjen/domain/managers/ticket/ITicketsManager;", "snackbarService", "Ldk/molslinjen/core/snackbar/ISnackbarService;", "<init>", "(Ldk/molslinjen/domain/managers/checkout/IEarlyCheckInPassengerManager;Ldk/molslinjen/domain/managers/ticket/ITicketsManager;Ldk/molslinjen/core/snackbar/ISnackbarService;)V", "_viewState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Ldk/molslinjen/ui/views/screens/tickets/earlyCheckIn/passengerSelector/EarlyCheckInPassengerSelectorViewModel$ViewState;", "viewState", "Lkotlinx/coroutines/flow/StateFlow;", "getViewState", "()Lkotlinx/coroutines/flow/StateFlow;", "passengerState", "Ldk/molslinjen/domain/managers/checkout/PassengerSelectionHelper$PassengerState;", "getPassengerState", "toggleSelected", BuildConfig.FLAVOR, "passenger", "Ldk/molslinjen/domain/model/booking/BookingPassenger;", "showAgeGroupError", "showValidationMessage", "errorMessage", BuildConfig.FLAVOR, "ViewState", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class EarlyCheckInPassengerSelectorViewModel extends ViewModel {
    private final MutableStateFlow<ViewState> _viewState;
    private final IEarlyCheckInPassengerManager earlyCheckInPassengerManager;
    private final StateFlow<PassengerSelectionHelper.PassengerState> passengerState;
    private final ISnackbarService snackbarService;
    private final ITicketsManager ticketsManager;
    private final StateFlow<ViewState> viewState;

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "dk.molslinjen.ui.views.screens.tickets.earlyCheckIn.passengerSelector.EarlyCheckInPassengerSelectorViewModel$2", f = "EarlyCheckInPassengerSelectorViewModel.kt", l = {38}, m = "invokeSuspend")
    /* renamed from: dk.molslinjen.ui.views.screens.tickets.earlyCheckIn.passengerSelector.EarlyCheckInPassengerSelectorViewModel$2, reason: invalid class name */
    /* loaded from: classes2.dex */
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        /* JADX INFO: Access modifiers changed from: package-private */
        @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "it", "Ldk/molslinjen/domain/managers/checkout/PassengerSelectionHelper$PassengerState;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "dk.molslinjen.ui.views.screens.tickets.earlyCheckIn.passengerSelector.EarlyCheckInPassengerSelectorViewModel$2$1", f = "EarlyCheckInPassengerSelectorViewModel.kt", l = {}, m = "invokeSuspend")
        /* renamed from: dk.molslinjen.ui.views.screens.tickets.earlyCheckIn.passengerSelector.EarlyCheckInPassengerSelectorViewModel$2$1, reason: invalid class name */
        /* loaded from: classes2.dex */
        public static final class AnonymousClass1 extends SuspendLambda implements Function2<PassengerSelectionHelper.PassengerState, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ EarlyCheckInPassengerSelectorViewModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(EarlyCheckInPassengerSelectorViewModel earlyCheckInPassengerSelectorViewModel, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.this$0 = earlyCheckInPassengerSelectorViewModel;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass1(this.this$0, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(PassengerSelectionHelper.PassengerState passengerState, Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(passengerState, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                Booking booking = this.this$0.getViewState().getValue().getBooking();
                if (booking == null) {
                    return Unit.INSTANCE;
                }
                boolean isWalking = booking.getTicket().getTransport().isWalking();
                PassengerInfo passengerInfo = booking.getTicket().getPassengerInfo().toPassengerInfo();
                ISharedPassengerSelectionViewState calculatePassengerSelectionState = this.this$0.earlyCheckInPassengerManager.calculatePassengerSelectionState(passengerInfo, booking.getTicket().getTransport());
                MutableStateFlow mutableStateFlow = this.this$0._viewState;
                while (true) {
                    Object value = mutableStateFlow.getValue();
                    MutableStateFlow mutableStateFlow2 = mutableStateFlow;
                    if (mutableStateFlow2.compareAndSet(value, ViewState.copy$default((ViewState) value, false, null, calculatePassengerSelectionState.getRemainingPassengerCount(), calculatePassengerSelectionState.getRemainingAdultCount(), calculatePassengerSelectionState.getRemainingChildCount(), calculatePassengerSelectionState.getRemainingInfantCount(), calculatePassengerSelectionState.getPassengerCount(), isWalking, passengerInfo, 2, null))) {
                        return Unit.INSTANCE;
                    }
                    mutableStateFlow = mutableStateFlow2;
                }
            }
        }

        AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i5 = this.label;
            if (i5 == 0) {
                ResultKt.throwOnFailure(obj);
                StateFlow<PassengerSelectionHelper.PassengerState> passengerState = EarlyCheckInPassengerSelectorViewModel.this.getPassengerState();
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(EarlyCheckInPassengerSelectorViewModel.this, null);
                this.label = 1;
                if (FlowKt.collectLatest(passengerState, anonymousClass1, this) == coroutine_suspended) {
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
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    public EarlyCheckInPassengerSelectorViewModel(IEarlyCheckInPassengerManager earlyCheckInPassengerManager, ITicketsManager ticketsManager, ISnackbarService snackbarService) {
        ViewState value;
        Intrinsics.checkNotNullParameter(earlyCheckInPassengerManager, "earlyCheckInPassengerManager");
        Intrinsics.checkNotNullParameter(ticketsManager, "ticketsManager");
        Intrinsics.checkNotNullParameter(snackbarService, "snackbarService");
        this.earlyCheckInPassengerManager = earlyCheckInPassengerManager;
        this.ticketsManager = ticketsManager;
        this.snackbarService = snackbarService;
        MutableStateFlow<ViewState> MutableStateFlow = StateFlowKt.MutableStateFlow(new ViewState(false, null, 0, 0, 0, 0, 0, false, null, 511, null));
        this._viewState = MutableStateFlow;
        this.viewState = MutableStateFlow;
        this.passengerState = earlyCheckInPassengerManager.getPassengerState();
        do {
            value = MutableStateFlow.getValue();
        } while (!MutableStateFlow.compareAndSet(value, ViewState.copy$default(value, false, this.ticketsManager.getTicketsState().getValue().getLastActiveBooking(), 0, 0, 0, 0, 0, false, null, 509, null)));
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass2(null), 3, null);
    }

    public final StateFlow<PassengerSelectionHelper.PassengerState> getPassengerState() {
        return this.passengerState;
    }

    public final StateFlow<ViewState> getViewState() {
        return this.viewState;
    }

    public final void showAgeGroupError() {
        if (this.viewState.getValue().getRemainingPassengerCount() == 0) {
            return;
        }
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new EarlyCheckInPassengerSelectorViewModel$showAgeGroupError$1(this, null), 3, null);
    }

    public final void showValidationMessage(String errorMessage) {
        Intrinsics.checkNotNullParameter(errorMessage, "errorMessage");
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new EarlyCheckInPassengerSelectorViewModel$showValidationMessage$1(this, errorMessage, null), 3, null);
    }

    public final void toggleSelected(BookingPassenger passenger) {
        Intrinsics.checkNotNullParameter(passenger, "passenger");
        this.earlyCheckInPassengerManager.toggleSelected(passenger);
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0013\b\u0087\b\u0018\u00002\u00020\u0001Be\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\u0006\u0012\b\b\u0002\u0010\n\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\f\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u000f\u0010\u0010Jn\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\u00062\b\b\u0002\u0010\u000b\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\u00022\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\rHÆ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u001a\u0010\u001a\u001a\u00020\u00022\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018HÖ\u0003¢\u0006\u0004\b\u001a\u0010\u001bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001c\u001a\u0004\b\u0003\u0010\u001dR\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u001a\u0010\u0007\u001a\u00020\u00068\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0007\u0010!\u001a\u0004\b\"\u0010\u0017R\u001a\u0010\b\u001a\u00020\u00068\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\b\u0010!\u001a\u0004\b#\u0010\u0017R\u001a\u0010\t\u001a\u00020\u00068\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\t\u0010!\u001a\u0004\b$\u0010\u0017R\u001a\u0010\n\u001a\u00020\u00068\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\n\u0010!\u001a\u0004\b%\u0010\u0017R\u001a\u0010\u000b\u001a\u00020\u00068\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u000b\u0010!\u001a\u0004\b&\u0010\u0017R\u001a\u0010\f\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\f\u0010\u001c\u001a\u0004\b'\u0010\u001dR\u0019\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0006¢\u0006\f\n\u0004\b\u000e\u0010(\u001a\u0004\b)\u0010*¨\u0006+"}, d2 = {"Ldk/molslinjen/ui/views/screens/tickets/earlyCheckIn/passengerSelector/EarlyCheckInPassengerSelectorViewModel$ViewState;", "Ldk/molslinjen/domain/managers/checkout/passengers/ISharedPassengerSelectionViewState;", BuildConfig.FLAVOR, "isLoading", "Ldk/molslinjen/domain/model/booking/Booking;", "booking", BuildConfig.FLAVOR, "remainingPassengerCount", "remainingAdultCount", "remainingChildCount", "remainingInfantCount", "passengerCount", "showAgeGroup", "Ldk/molslinjen/domain/model/booking/PassengerInfo;", "passengerInfo", "<init>", "(ZLdk/molslinjen/domain/model/booking/Booking;IIIIIZLdk/molslinjen/domain/model/booking/PassengerInfo;)V", "copy", "(ZLdk/molslinjen/domain/model/booking/Booking;IIIIIZLdk/molslinjen/domain/model/booking/PassengerInfo;)Ldk/molslinjen/ui/views/screens/tickets/earlyCheckIn/passengerSelector/EarlyCheckInPassengerSelectorViewModel$ViewState;", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", "hashCode", "()I", BuildConfig.FLAVOR, "other", "equals", "(Ljava/lang/Object;)Z", "Z", "()Z", "Ldk/molslinjen/domain/model/booking/Booking;", "getBooking", "()Ldk/molslinjen/domain/model/booking/Booking;", "I", "getRemainingPassengerCount", "getRemainingAdultCount", "getRemainingChildCount", "getRemainingInfantCount", "getPassengerCount", "getShowAgeGroup", "Ldk/molslinjen/domain/model/booking/PassengerInfo;", "getPassengerInfo", "()Ldk/molslinjen/domain/model/booking/PassengerInfo;", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final /* data */ class ViewState implements ISharedPassengerSelectionViewState {
        private final Booking booking;
        private final boolean isLoading;
        private final int passengerCount;
        private final PassengerInfo passengerInfo;
        private final int remainingAdultCount;
        private final int remainingChildCount;
        private final int remainingInfantCount;
        private final int remainingPassengerCount;
        private final boolean showAgeGroup;

        public ViewState(boolean z5, Booking booking, int i5, int i6, int i7, int i8, int i9, boolean z6, PassengerInfo passengerInfo) {
            this.isLoading = z5;
            this.booking = booking;
            this.remainingPassengerCount = i5;
            this.remainingAdultCount = i6;
            this.remainingChildCount = i7;
            this.remainingInfantCount = i8;
            this.passengerCount = i9;
            this.showAgeGroup = z6;
            this.passengerInfo = passengerInfo;
        }

        public static /* synthetic */ ViewState copy$default(ViewState viewState, boolean z5, Booking booking, int i5, int i6, int i7, int i8, int i9, boolean z6, PassengerInfo passengerInfo, int i10, Object obj) {
            return viewState.copy((i10 & 1) != 0 ? viewState.isLoading : z5, (i10 & 2) != 0 ? viewState.booking : booking, (i10 & 4) != 0 ? viewState.remainingPassengerCount : i5, (i10 & 8) != 0 ? viewState.remainingAdultCount : i6, (i10 & 16) != 0 ? viewState.remainingChildCount : i7, (i10 & 32) != 0 ? viewState.remainingInfantCount : i8, (i10 & 64) != 0 ? viewState.passengerCount : i9, (i10 & 128) != 0 ? viewState.showAgeGroup : z6, (i10 & 256) != 0 ? viewState.passengerInfo : passengerInfo);
        }

        public final ViewState copy(boolean isLoading, Booking booking, int remainingPassengerCount, int remainingAdultCount, int remainingChildCount, int remainingInfantCount, int passengerCount, boolean showAgeGroup, PassengerInfo passengerInfo) {
            return new ViewState(isLoading, booking, remainingPassengerCount, remainingAdultCount, remainingChildCount, remainingInfantCount, passengerCount, showAgeGroup, passengerInfo);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ViewState)) {
                return false;
            }
            ViewState viewState = (ViewState) other;
            return this.isLoading == viewState.isLoading && Intrinsics.areEqual(this.booking, viewState.booking) && this.remainingPassengerCount == viewState.remainingPassengerCount && this.remainingAdultCount == viewState.remainingAdultCount && this.remainingChildCount == viewState.remainingChildCount && this.remainingInfantCount == viewState.remainingInfantCount && this.passengerCount == viewState.passengerCount && this.showAgeGroup == viewState.showAgeGroup && Intrinsics.areEqual(this.passengerInfo, viewState.passengerInfo);
        }

        public final Booking getBooking() {
            return this.booking;
        }

        @Override // dk.molslinjen.domain.managers.checkout.passengers.ISharedPassengerSelectionViewState
        public int getPassengerCount() {
            return this.passengerCount;
        }

        @Override // dk.molslinjen.domain.managers.checkout.passengers.ISharedPassengerSelectionViewState
        public int getRemainingAdultCount() {
            return this.remainingAdultCount;
        }

        @Override // dk.molslinjen.domain.managers.checkout.passengers.ISharedPassengerSelectionViewState
        public int getRemainingChildCount() {
            return this.remainingChildCount;
        }

        @Override // dk.molslinjen.domain.managers.checkout.passengers.ISharedPassengerSelectionViewState
        public int getRemainingInfantCount() {
            return this.remainingInfantCount;
        }

        @Override // dk.molslinjen.domain.managers.checkout.passengers.ISharedPassengerSelectionViewState
        public int getRemainingPassengerCount() {
            return this.remainingPassengerCount;
        }

        @Override // dk.molslinjen.domain.managers.checkout.passengers.ISharedPassengerSelectionViewState
        public boolean getShowAgeGroup() {
            return this.showAgeGroup;
        }

        public int hashCode() {
            int hashCode = Boolean.hashCode(this.isLoading) * 31;
            Booking booking = this.booking;
            int hashCode2 = (((((((((((((hashCode + (booking == null ? 0 : booking.hashCode())) * 31) + Integer.hashCode(this.remainingPassengerCount)) * 31) + Integer.hashCode(this.remainingAdultCount)) * 31) + Integer.hashCode(this.remainingChildCount)) * 31) + Integer.hashCode(this.remainingInfantCount)) * 31) + Integer.hashCode(this.passengerCount)) * 31) + Boolean.hashCode(this.showAgeGroup)) * 31;
            PassengerInfo passengerInfo = this.passengerInfo;
            return hashCode2 + (passengerInfo != null ? passengerInfo.hashCode() : 0);
        }

        /* renamed from: isLoading, reason: from getter */
        public final boolean getIsLoading() {
            return this.isLoading;
        }

        public String toString() {
            return "ViewState(isLoading=" + this.isLoading + ", booking=" + this.booking + ", remainingPassengerCount=" + this.remainingPassengerCount + ", remainingAdultCount=" + this.remainingAdultCount + ", remainingChildCount=" + this.remainingChildCount + ", remainingInfantCount=" + this.remainingInfantCount + ", passengerCount=" + this.passengerCount + ", showAgeGroup=" + this.showAgeGroup + ", passengerInfo=" + this.passengerInfo + ")";
        }

        public /* synthetic */ ViewState(boolean z5, Booking booking, int i5, int i6, int i7, int i8, int i9, boolean z6, PassengerInfo passengerInfo, int i10, DefaultConstructorMarker defaultConstructorMarker) {
            this((i10 & 1) != 0 ? true : z5, (i10 & 2) != 0 ? null : booking, (i10 & 4) != 0 ? 0 : i5, (i10 & 8) != 0 ? 0 : i6, (i10 & 16) != 0 ? 0 : i7, (i10 & 32) != 0 ? 0 : i8, (i10 & 64) != 0 ? 0 : i9, (i10 & 128) == 0 ? z6 : false, (i10 & 256) == 0 ? passengerInfo : null);
        }
    }
}
