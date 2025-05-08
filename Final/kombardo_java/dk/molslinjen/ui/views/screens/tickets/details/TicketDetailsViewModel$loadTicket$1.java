package dk.molslinjen.ui.views.screens.tickets.details;

import android.content.Context;
import dk.molslinjen.core.Feature;
import dk.molslinjen.core.snackbar.ISnackbarService;
import dk.molslinjen.domain.extensions.ManagerResultExtensionsKt;
import dk.molslinjen.domain.managers.ManagerResult;
import dk.molslinjen.domain.managers.configuration.IConfigurationManager;
import dk.molslinjen.domain.managers.saleOnBoard.ISaleOnBoardManager;
import dk.molslinjen.domain.managers.ticket.ITicketsManager;
import dk.molslinjen.domain.managers.user.IUserManager;
import dk.molslinjen.domain.model.booking.Booking;
import dk.molslinjen.domain.model.config.LocalizedSiteConfiguration;
import dk.molslinjen.domain.model.config.Site;
import dk.molslinjen.ui.views.screens.tickets.details.TicketDetailsViewModel;
import java.util.List;
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
@DebugMetadata(c = "dk.molslinjen.ui.views.screens.tickets.details.TicketDetailsViewModel$loadTicket$1", f = "TicketDetailsViewModel.kt", l = {99, 100, 110, 116, 119}, m = "invokeSuspend")
/* loaded from: classes2.dex */
public final class TicketDetailsViewModel$loadTicket$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ String $phone;
    final /* synthetic */ String $reservationNumber;
    final /* synthetic */ Site $site;
    int label;
    final /* synthetic */ TicketDetailsViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TicketDetailsViewModel$loadTicket$1(TicketDetailsViewModel ticketDetailsViewModel, String str, String str2, Site site, Context context, Continuation<? super TicketDetailsViewModel$loadTicket$1> continuation) {
        super(2, continuation);
        this.this$0 = ticketDetailsViewModel;
        this.$reservationNumber = str;
        this.$phone = str2;
        this.$site = site;
        this.$context = context;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TicketDetailsViewModel$loadTicket$1(this.this$0, this.$reservationNumber, this.$phone, this.$site, this.$context, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0168  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x016d  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0163 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0143  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x019b A[LOOP:2: B:40:0x0079->B:49:0x019b, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00d9 A[EDGE_INSN: B:50:0x00d9->B:51:0x00d9 BREAK  A[LOOP:2: B:40:0x0079->B:49:0x019b], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00fd A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0087  */
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
        TicketDetailsViewModel ticketDetailsViewModel;
        Object value;
        TicketDetailsViewModel.ViewState viewState;
        boolean z5;
        ISaleOnBoardManager iSaleOnBoardManager;
        Object saleOnBoardOrders;
        IUserManager iUserManager;
        Object buildKombardoRouteDetailsModel;
        List list;
        MutableStateFlow mutableStateFlow2;
        Object value2;
        IConfigurationManager iConfigurationManager;
        Object activeConfiguration;
        String lineLogoUrl;
        MutableStateFlow mutableStateFlow3;
        Object value3;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = this.label;
        if (i5 == 0) {
            ResultKt.throwOnFailure(obj);
            iTicketsManager = this.this$0.ticketsManager;
            String str = this.$reservationNumber;
            String str2 = this.$phone;
            Site site = this.$site;
            this.label = 1;
            booking = iTicketsManager.getBooking(str, str2, site, this);
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
                    ticketDetailsViewModel = this.this$0;
                    while (true) {
                        value = mutableStateFlow.getValue();
                        viewState = (TicketDetailsViewModel.ViewState) value;
                        if ((booking2 == null ? booking2.getTicket() : null) != null) {
                            iUserManager = ticketDetailsViewModel.userManager;
                            if (iUserManager.getAuthenticationType().getValue().isAuthenticated()) {
                                z5 = true;
                                TicketDetailsViewModel ticketDetailsViewModel2 = ticketDetailsViewModel;
                                if (mutableStateFlow.compareAndSet(value, TicketDetailsViewModel.ViewState.copy$default(viewState, null, null, null, booking2, null, false, false, false, null, false, false, z5, null, 6071, null))) {
                                    break;
                                }
                                ticketDetailsViewModel = ticketDetailsViewModel2;
                            }
                        }
                        z5 = false;
                        TicketDetailsViewModel ticketDetailsViewModel22 = ticketDetailsViewModel;
                        if (mutableStateFlow.compareAndSet(value, TicketDetailsViewModel.ViewState.copy$default(viewState, null, null, null, booking2, null, false, false, false, null, false, false, z5, null, 6071, null))) {
                        }
                    }
                    if (Feature.SaleOnboard.isEnabled() && booking2 != null) {
                        iSaleOnBoardManager = this.this$0.saleOnBoardManager;
                        String timeTableId = booking2.getTicket().getDeparture().getTimeTableId();
                        this.label = 3;
                        saleOnBoardOrders = iSaleOnBoardManager.getSaleOnBoardOrders(timeTableId, this);
                        if (saleOnBoardOrders == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        list = (List) saleOnBoardOrders;
                        mutableStateFlow2 = this.this$0._viewState;
                        do {
                            value2 = mutableStateFlow2.getValue();
                        } while (!mutableStateFlow2.compareAndSet(value2, TicketDetailsViewModel.ViewState.copy$default((TicketDetailsViewModel.ViewState) value2, null, null, null, null, list, false, false, false, null, false, false, false, null, 8175, null)));
                    }
                    if (Feature.OnlyWalkingPassengers.isEnabled()) {
                    }
                    iConfigurationManager = this.this$0.configurationManager;
                    Site site2 = this.$site;
                    this.label = 5;
                    activeConfiguration = iConfigurationManager.getActiveConfiguration(site2, this);
                    if (activeConfiguration == coroutine_suspended) {
                    }
                    LocalizedSiteConfiguration localizedSiteConfiguration = (LocalizedSiteConfiguration) activeConfiguration;
                    if (localizedSiteConfiguration != null) {
                    }
                    mutableStateFlow3 = this.this$0._viewState;
                    do {
                        value3 = mutableStateFlow3.getValue();
                    } while (!mutableStateFlow3.compareAndSet(value3, TicketDetailsViewModel.ViewState.copy$default((TicketDetailsViewModel.ViewState) value3, null, null, null, null, null, false, false, false, null, false, false, false, lineLogoUrl, 4095, null)));
                    return Unit.INSTANCE;
                }
                if (i5 != 3) {
                    if (i5 != 4) {
                        if (i5 != 5) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                        activeConfiguration = obj;
                        LocalizedSiteConfiguration localizedSiteConfiguration2 = (LocalizedSiteConfiguration) activeConfiguration;
                        lineLogoUrl = localizedSiteConfiguration2 != null ? localizedSiteConfiguration2.getLineLogoUrl() : null;
                        mutableStateFlow3 = this.this$0._viewState;
                        do {
                            value3 = mutableStateFlow3.getValue();
                        } while (!mutableStateFlow3.compareAndSet(value3, TicketDetailsViewModel.ViewState.copy$default((TicketDetailsViewModel.ViewState) value3, null, null, null, null, null, false, false, false, null, false, false, false, lineLogoUrl, 4095, null)));
                        return Unit.INSTANCE;
                    }
                    ResultKt.throwOnFailure(obj);
                    iConfigurationManager = this.this$0.configurationManager;
                    Site site22 = this.$site;
                    this.label = 5;
                    activeConfiguration = iConfigurationManager.getActiveConfiguration(site22, this);
                    if (activeConfiguration == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    LocalizedSiteConfiguration localizedSiteConfiguration22 = (LocalizedSiteConfiguration) activeConfiguration;
                    if (localizedSiteConfiguration22 != null) {
                    }
                    mutableStateFlow3 = this.this$0._viewState;
                    do {
                        value3 = mutableStateFlow3.getValue();
                    } while (!mutableStateFlow3.compareAndSet(value3, TicketDetailsViewModel.ViewState.copy$default((TicketDetailsViewModel.ViewState) value3, null, null, null, null, null, false, false, false, null, false, false, false, lineLogoUrl, 4095, null)));
                    return Unit.INSTANCE;
                }
                ResultKt.throwOnFailure(obj);
                saleOnBoardOrders = obj;
                list = (List) saleOnBoardOrders;
                mutableStateFlow2 = this.this$0._viewState;
                do {
                    value2 = mutableStateFlow2.getValue();
                } while (!mutableStateFlow2.compareAndSet(value2, TicketDetailsViewModel.ViewState.copy$default((TicketDetailsViewModel.ViewState) value2, null, null, null, null, list, false, false, false, null, false, false, false, null, 8175, null)));
                if (Feature.OnlyWalkingPassengers.isEnabled()) {
                    TicketDetailsViewModel ticketDetailsViewModel3 = this.this$0;
                    Context context = this.$context;
                    Site site3 = this.$site;
                    this.label = 4;
                    buildKombardoRouteDetailsModel = ticketDetailsViewModel3.buildKombardoRouteDetailsModel(context, site3, this);
                    if (buildKombardoRouteDetailsModel == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                iConfigurationManager = this.this$0.configurationManager;
                Site site222 = this.$site;
                this.label = 5;
                activeConfiguration = iConfigurationManager.getActiveConfiguration(site222, this);
                if (activeConfiguration == coroutine_suspended) {
                }
                LocalizedSiteConfiguration localizedSiteConfiguration222 = (LocalizedSiteConfiguration) activeConfiguration;
                if (localizedSiteConfiguration222 != null) {
                }
                mutableStateFlow3 = this.this$0._viewState;
                do {
                    value3 = mutableStateFlow3.getValue();
                } while (!mutableStateFlow3.compareAndSet(value3, TicketDetailsViewModel.ViewState.copy$default((TicketDetailsViewModel.ViewState) value3, null, null, null, null, null, false, false, false, null, false, false, false, lineLogoUrl, 4095, null)));
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
        ticketDetailsViewModel = this.this$0;
        while (true) {
            value = mutableStateFlow.getValue();
            viewState = (TicketDetailsViewModel.ViewState) value;
            if ((booking2 == null ? booking2.getTicket() : null) != null) {
            }
            z5 = false;
            TicketDetailsViewModel ticketDetailsViewModel222 = ticketDetailsViewModel;
            if (mutableStateFlow.compareAndSet(value, TicketDetailsViewModel.ViewState.copy$default(viewState, null, null, null, booking2, null, false, false, false, null, false, false, z5, null, 6071, null))) {
            }
            ticketDetailsViewModel = ticketDetailsViewModel222;
        }
        if (Feature.SaleOnboard.isEnabled()) {
            iSaleOnBoardManager = this.this$0.saleOnBoardManager;
            String timeTableId2 = booking2.getTicket().getDeparture().getTimeTableId();
            this.label = 3;
            saleOnBoardOrders = iSaleOnBoardManager.getSaleOnBoardOrders(timeTableId2, this);
            if (saleOnBoardOrders == coroutine_suspended) {
            }
            list = (List) saleOnBoardOrders;
            mutableStateFlow2 = this.this$0._viewState;
            do {
                value2 = mutableStateFlow2.getValue();
            } while (!mutableStateFlow2.compareAndSet(value2, TicketDetailsViewModel.ViewState.copy$default((TicketDetailsViewModel.ViewState) value2, null, null, null, null, list, false, false, false, null, false, false, false, null, 8175, null)));
        }
        if (Feature.OnlyWalkingPassengers.isEnabled()) {
        }
        iConfigurationManager = this.this$0.configurationManager;
        Site site2222 = this.$site;
        this.label = 5;
        activeConfiguration = iConfigurationManager.getActiveConfiguration(site2222, this);
        if (activeConfiguration == coroutine_suspended) {
        }
        LocalizedSiteConfiguration localizedSiteConfiguration2222 = (LocalizedSiteConfiguration) activeConfiguration;
        if (localizedSiteConfiguration2222 != null) {
        }
        mutableStateFlow3 = this.this$0._viewState;
        do {
            value3 = mutableStateFlow3.getValue();
        } while (!mutableStateFlow3.compareAndSet(value3, TicketDetailsViewModel.ViewState.copy$default((TicketDetailsViewModel.ViewState) value3, null, null, null, null, null, false, false, false, null, false, false, false, lineLogoUrl, 4095, null)));
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((TicketDetailsViewModel$loadTicket$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
