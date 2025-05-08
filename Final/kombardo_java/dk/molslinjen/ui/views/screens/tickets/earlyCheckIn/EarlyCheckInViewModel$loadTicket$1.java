package dk.molslinjen.ui.views.screens.tickets.earlyCheckIn;

import dk.molslinjen.core.snackbar.ISnackbarService;
import dk.molslinjen.domain.extensions.ManagerResultExtensionsKt;
import dk.molslinjen.domain.managers.ManagerResult;
import dk.molslinjen.domain.managers.checkout.IEarlyCheckInPassengerManager;
import dk.molslinjen.domain.managers.checkout.ISimpleChangeCheckoutManager;
import dk.molslinjen.domain.managers.ticket.ITicketsManager;
import dk.molslinjen.domain.managers.user.vehicles.IUserVehiclesManager;
import dk.molslinjen.domain.model.booking.Booking;
import dk.molslinjen.domain.model.booking.CustomerInfo;
import dk.molslinjen.domain.model.config.Site;
import dk.molslinjen.ui.views.screens.tickets.earlyCheckIn.EarlyCheckInViewModel;
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
@DebugMetadata(c = "dk.molslinjen.ui.views.screens.tickets.earlyCheckIn.EarlyCheckInViewModel$loadTicket$1", f = "EarlyCheckInViewModel.kt", l = {59, 60, 66, 66, 72}, m = "invokeSuspend")
/* loaded from: classes2.dex */
public final class EarlyCheckInViewModel$loadTicket$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $phone;
    final /* synthetic */ String $reservationNumber;
    final /* synthetic */ Site $site;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ EarlyCheckInViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "it"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "dk.molslinjen.ui.views.screens.tickets.earlyCheckIn.EarlyCheckInViewModel$loadTicket$1$2", f = "EarlyCheckInViewModel.kt", l = {}, m = "invokeSuspend")
    /* renamed from: dk.molslinjen.ui.views.screens.tickets.earlyCheckIn.EarlyCheckInViewModel$loadTicket$1$2, reason: invalid class name */
    /* loaded from: classes2.dex */
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<Unit, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $licensePlate;
        int label;
        final /* synthetic */ EarlyCheckInViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(EarlyCheckInViewModel earlyCheckInViewModel, String str, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.this$0 = earlyCheckInViewModel;
            this.$licensePlate = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.this$0, this.$licensePlate, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            this.this$0.setPreselectedVehicle(this.$licensePlate);
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Unit unit, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(unit, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EarlyCheckInViewModel$loadTicket$1(EarlyCheckInViewModel earlyCheckInViewModel, String str, String str2, Site site, Continuation<? super EarlyCheckInViewModel$loadTicket$1> continuation) {
        super(2, continuation);
        this.this$0 = earlyCheckInViewModel;
        this.$reservationNumber = str;
        this.$phone = str2;
        this.$site = site;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new EarlyCheckInViewModel$loadTicket$1(this.this$0, this.$reservationNumber, this.$phone, this.$site, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00e8 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00b6  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        ITicketsManager iTicketsManager;
        Object booking;
        ISnackbarService iSnackbarService;
        Object handlePotentialError;
        Booking booking2;
        MutableStateFlow mutableStateFlow;
        Object value;
        String licensePlate;
        IUserVehiclesManager iUserVehiclesManager;
        Object loadVehicles;
        Booking booking3;
        String str;
        CustomerInfo customerInfo;
        AnonymousClass2 anonymousClass2;
        IEarlyCheckInPassengerManager iEarlyCheckInPassengerManager;
        Booking booking4;
        MutableStateFlow mutableStateFlow2;
        Object value2;
        ISimpleChangeCheckoutManager iSimpleChangeCheckoutManager;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = this.label;
        if (i5 == 0) {
            ResultKt.throwOnFailure(obj);
            iTicketsManager = this.this$0.ticketsManager;
            String str2 = this.$reservationNumber;
            String str3 = this.$phone;
            Site site = this.$site;
            this.label = 1;
            booking = iTicketsManager.getBooking(str2, str3, site, this);
            if (booking == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i5 != 1) {
                if (i5 == 2) {
                    ResultKt.throwOnFailure(obj);
                    handlePotentialError = obj;
                    booking2 = (Booking) ManagerResultExtensionsKt.toData((ManagerResult) handlePotentialError);
                    mutableStateFlow = this.this$0._viewState;
                    do {
                        value = mutableStateFlow.getValue();
                    } while (!mutableStateFlow.compareAndSet(value, EarlyCheckInViewModel.ViewState.copy$default((EarlyCheckInViewModel.ViewState) value, false, null, null, null, booking2, null, 47, null)));
                    licensePlate = (booking2 != null || (customerInfo = booking2.getCustomerInfo()) == null) ? null : customerInfo.getLicensePlate();
                    if (licensePlate != null) {
                        this.this$0.setPreselectedVehicle(licensePlate);
                        iUserVehiclesManager = this.this$0.userVehiclesManager;
                        this.L$0 = booking2;
                        this.L$1 = licensePlate;
                        this.label = 3;
                        loadVehicles = iUserVehiclesManager.loadVehicles(this);
                        if (loadVehicles == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        String str4 = licensePlate;
                        booking3 = booking2;
                        str = str4;
                        anonymousClass2 = new AnonymousClass2(this.this$0, str, null);
                        this.L$0 = booking3;
                        this.L$1 = null;
                        this.label = 4;
                        if (ManagerResultExtensionsKt.onSuccess((ManagerResult) loadVehicles, anonymousClass2, this) != coroutine_suspended) {
                        }
                    }
                    if (booking2 != null) {
                    }
                    mutableStateFlow2 = this.this$0._viewState;
                    do {
                        value2 = mutableStateFlow2.getValue();
                    } while (!mutableStateFlow2.compareAndSet(value2, EarlyCheckInViewModel.ViewState.copy$default((EarlyCheckInViewModel.ViewState) value2, false, null, null, null, null, null, 62, null)));
                    return Unit.INSTANCE;
                }
                if (i5 == 3) {
                    str = (String) this.L$1;
                    Booking booking5 = (Booking) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    booking3 = booking5;
                    loadVehicles = obj;
                    anonymousClass2 = new AnonymousClass2(this.this$0, str, null);
                    this.L$0 = booking3;
                    this.L$1 = null;
                    this.label = 4;
                    if (ManagerResultExtensionsKt.onSuccess((ManagerResult) loadVehicles, anonymousClass2, this) != coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    booking2 = booking3;
                    if (booking2 != null) {
                    }
                    mutableStateFlow2 = this.this$0._viewState;
                    do {
                        value2 = mutableStateFlow2.getValue();
                    } while (!mutableStateFlow2.compareAndSet(value2, EarlyCheckInViewModel.ViewState.copy$default((EarlyCheckInViewModel.ViewState) value2, false, null, null, null, null, null, 62, null)));
                    return Unit.INSTANCE;
                }
                if (i5 != 4) {
                    if (i5 != 5) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    booking4 = (Booking) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    iSimpleChangeCheckoutManager = this.this$0.simpleChangeCheckoutManager;
                    iSimpleChangeCheckoutManager.setup(booking4, true);
                    mutableStateFlow2 = this.this$0._viewState;
                    do {
                        value2 = mutableStateFlow2.getValue();
                    } while (!mutableStateFlow2.compareAndSet(value2, EarlyCheckInViewModel.ViewState.copy$default((EarlyCheckInViewModel.ViewState) value2, false, null, null, null, null, null, 62, null)));
                    return Unit.INSTANCE;
                }
                booking2 = (Booking) this.L$0;
                ResultKt.throwOnFailure(obj);
                if (booking2 != null) {
                    iEarlyCheckInPassengerManager = this.this$0.earlyCheckInPassengerManager;
                    this.L$0 = booking2;
                    this.label = 5;
                    if (iEarlyCheckInPassengerManager.load(booking2, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    booking4 = booking2;
                    iSimpleChangeCheckoutManager = this.this$0.simpleChangeCheckoutManager;
                    iSimpleChangeCheckoutManager.setup(booking4, true);
                }
                mutableStateFlow2 = this.this$0._viewState;
                do {
                    value2 = mutableStateFlow2.getValue();
                } while (!mutableStateFlow2.compareAndSet(value2, EarlyCheckInViewModel.ViewState.copy$default((EarlyCheckInViewModel.ViewState) value2, false, null, null, null, null, null, 62, null)));
                return Unit.INSTANCE;
            }
            ResultKt.throwOnFailure(obj);
            booking = obj;
        }
        iSnackbarService = this.this$0.snackbarService;
        this.label = 2;
        handlePotentialError = dk.molslinjen.extensions.ManagerResultExtensionsKt.handlePotentialError((ManagerResult) booking, iSnackbarService, this);
        if (handlePotentialError == coroutine_suspended) {
            return coroutine_suspended;
        }
        booking2 = (Booking) ManagerResultExtensionsKt.toData((ManagerResult) handlePotentialError);
        mutableStateFlow = this.this$0._viewState;
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, EarlyCheckInViewModel.ViewState.copy$default((EarlyCheckInViewModel.ViewState) value, false, null, null, null, booking2, null, 47, null)));
        if (booking2 != null) {
        }
        if (licensePlate != null) {
        }
        if (booking2 != null) {
        }
        mutableStateFlow2 = this.this$0._viewState;
        do {
            value2 = mutableStateFlow2.getValue();
        } while (!mutableStateFlow2.compareAndSet(value2, EarlyCheckInViewModel.ViewState.copy$default((EarlyCheckInViewModel.ViewState) value2, false, null, null, null, null, null, 62, null)));
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((EarlyCheckInViewModel$loadTicket$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
