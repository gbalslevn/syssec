package dk.molslinjen.ui.views.screens.tickets.details;

import android.content.Context;
import dk.molslinjen.core.snackbar.ISnackbarService;
import dk.molslinjen.domain.managers.ManagerResult;
import dk.molslinjen.domain.managers.saleOnBoard.ISaleOnBoardManager;
import dk.molslinjen.domain.managers.ticket.ITicketsManager;
import dk.molslinjen.domain.model.booking.Booking;
import dk.molslinjen.domain.model.config.Site;
import dk.molslinjen.domain.model.saleOnBoard.SaleOnBoardOrder;
import dk.molslinjen.extensions.ManagerResultExtensionsKt;
import dk.molslinjen.ui.views.screens.tickets.details.TicketDetailsViewModel;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableStateFlow;
import org.conscrypt.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.ui.views.screens.tickets.details.TicketDetailsViewModel$refund$2", f = "TicketDetailsViewModel.kt", l = {163, 164, 165, 168}, m = "invokeSuspend")
/* loaded from: classes2.dex */
public final class TicketDetailsViewModel$refund$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Booking $booking;
    final /* synthetic */ Context $context;
    final /* synthetic */ Function0<Unit> $showRefundReceipt;
    int label;
    final /* synthetic */ TicketDetailsViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "dk.molslinjen.ui.views.screens.tickets.details.TicketDetailsViewModel$refund$2$1", f = "TicketDetailsViewModel.kt", l = {}, m = "invokeSuspend")
    /* renamed from: dk.molslinjen.ui.views.screens.tickets.details.TicketDetailsViewModel$refund$2$1, reason: invalid class name */
    /* loaded from: classes2.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ TicketDetailsViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(TicketDetailsViewModel ticketDetailsViewModel, Continuation<? super AnonymousClass1> continuation) {
            super(1, continuation);
            this.this$0 = ticketDetailsViewModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            MutableStateFlow mutableStateFlow;
            Object value;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            mutableStateFlow = this.this$0._viewState;
            do {
                value = mutableStateFlow.getValue();
            } while (!mutableStateFlow.compareAndSet(value, TicketDetailsViewModel.ViewState.copy$default((TicketDetailsViewModel.ViewState) value, null, null, null, null, null, false, false, false, null, false, false, false, null, 8159, null)));
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "it"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "dk.molslinjen.ui.views.screens.tickets.details.TicketDetailsViewModel$refund$2$2", f = "TicketDetailsViewModel.kt", l = {185, 185}, m = "invokeSuspend")
    /* renamed from: dk.molslinjen.ui.views.screens.tickets.details.TicketDetailsViewModel$refund$2$2, reason: invalid class name */
    /* loaded from: classes2.dex */
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<Unit, Continuation<? super Unit>, Object> {
        final /* synthetic */ Booking $booking;
        final /* synthetic */ Context $context;
        final /* synthetic */ Function0<Unit> $showRefundReceipt;
        Object L$0;
        int label;
        final /* synthetic */ TicketDetailsViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(TicketDetailsViewModel ticketDetailsViewModel, Booking booking, Context context, Function0<Unit> function0, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.this$0 = ticketDetailsViewModel;
            this.$booking = booking;
            this.$context = context;
            this.$showRefundReceipt = function0;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.this$0, this.$booking, this.$context, this.$showRefundReceipt, continuation);
        }

        /* JADX WARN: Removed duplicated region for block: B:14:0x00c3 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:15:0x00c4  */
        /* JADX WARN: Removed duplicated region for block: B:8:0x009a  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x00c1 -> B:6:0x0094). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            MutableStateFlow mutableStateFlow;
            Object value;
            TicketDetailsScreenNavArgs ticketDetailsScreenNavArgs;
            Iterator<SaleOnBoardOrder> it;
            Object obj2;
            ISnackbarService iSnackbarService;
            ISaleOnBoardManager iSaleOnBoardManager;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i5 = this.label;
            if (i5 == 0) {
                ResultKt.throwOnFailure(obj);
                mutableStateFlow = this.this$0._viewState;
                do {
                    value = mutableStateFlow.getValue();
                } while (!mutableStateFlow.compareAndSet(value, TicketDetailsViewModel.ViewState.copy$default((TicketDetailsViewModel.ViewState) value, null, null, null, null, null, false, true, false, null, false, false, false, null, 7583, null)));
                TicketDetailsViewModel ticketDetailsViewModel = this.this$0;
                String reservationNumber = this.$booking.getReservationNumber();
                String nationalNumber = this.$booking.getCustomerInfo().getPhoneNumber().getNationalNumber();
                ticketDetailsScreenNavArgs = this.this$0.navArgs;
                ticketDetailsViewModel.loadTicket(reservationNumber, nationalNumber, ticketDetailsScreenNavArgs.getSite(), this.$context);
                it = this.this$0.getViewState().getValue().getSaleOnBoardOrders().iterator();
            } else if (i5 == 1) {
                it = (Iterator) this.L$0;
                ResultKt.throwOnFailure(obj);
                obj2 = obj;
                iSnackbarService = this.this$0.snackbarService;
                this.L$0 = it;
                this.label = 2;
                if (ManagerResultExtensionsKt.handlePotentialError((ManagerResult) obj2, iSnackbarService, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i5 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                it = (Iterator) this.L$0;
                ResultKt.throwOnFailure(obj);
            }
            if (!it.hasNext()) {
                SaleOnBoardOrder next = it.next();
                iSaleOnBoardManager = this.this$0.saleOnBoardManager;
                this.L$0 = it;
                this.label = 1;
                obj2 = iSaleOnBoardManager.cancelOrder(next, this);
                if (obj2 == coroutine_suspended) {
                    return coroutine_suspended;
                }
                iSnackbarService = this.this$0.snackbarService;
                this.L$0 = it;
                this.label = 2;
                if (ManagerResultExtensionsKt.handlePotentialError((ManagerResult) obj2, iSnackbarService, this) == coroutine_suspended) {
                }
                if (!it.hasNext()) {
                    this.$showRefundReceipt.invoke();
                    return Unit.INSTANCE;
                }
            }
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Unit unit, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(unit, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TicketDetailsViewModel$refund$2(TicketDetailsViewModel ticketDetailsViewModel, Booking booking, Context context, Function0<Unit> function0, Continuation<? super TicketDetailsViewModel$refund$2> continuation) {
        super(2, continuation);
        this.this$0 = ticketDetailsViewModel;
        this.$booking = booking;
        this.$context = context;
        this.$showRefundReceipt = function0;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TicketDetailsViewModel$refund$2(this.this$0, this.$booking, this.$context, this.$showRefundReceipt, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x008e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0074 A[RETURN] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        ITicketsManager iTicketsManager;
        ISnackbarService iSnackbarService;
        AnonymousClass2 anonymousClass2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = this.label;
        if (i5 == 0) {
            ResultKt.throwOnFailure(obj);
            iTicketsManager = this.this$0.ticketsManager;
            Booking booking = this.$booking;
            Site site = this.this$0.getViewState().getValue().getSite();
            this.label = 1;
            obj = iTicketsManager.refund(booking, site, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i5 != 1) {
                if (i5 == 2) {
                    ResultKt.throwOnFailure(obj);
                    AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, null);
                    this.label = 3;
                    obj = dk.molslinjen.domain.extensions.ManagerResultExtensionsKt.onFailure((ManagerResult) obj, anonymousClass1, this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    anonymousClass2 = new AnonymousClass2(this.this$0, this.$booking, this.$context, this.$showRefundReceipt, null);
                    this.label = 4;
                    if (dk.molslinjen.domain.extensions.ManagerResultExtensionsKt.onSuccess((ManagerResult) obj, anonymousClass2, this) == coroutine_suspended) {
                    }
                    return Unit.INSTANCE;
                }
                if (i5 != 3) {
                    if (i5 != 4) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                ResultKt.throwOnFailure(obj);
                anonymousClass2 = new AnonymousClass2(this.this$0, this.$booking, this.$context, this.$showRefundReceipt, null);
                this.label = 4;
                if (dk.molslinjen.domain.extensions.ManagerResultExtensionsKt.onSuccess((ManagerResult) obj, anonymousClass2, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            }
            ResultKt.throwOnFailure(obj);
        }
        iSnackbarService = this.this$0.snackbarService;
        this.label = 2;
        obj = ManagerResultExtensionsKt.handlePotentialError((ManagerResult) obj, iSnackbarService, this);
        if (obj == coroutine_suspended) {
            return coroutine_suspended;
        }
        AnonymousClass1 anonymousClass12 = new AnonymousClass1(this.this$0, null);
        this.label = 3;
        obj = dk.molslinjen.domain.extensions.ManagerResultExtensionsKt.onFailure((ManagerResult) obj, anonymousClass12, this);
        if (obj == coroutine_suspended) {
        }
        anonymousClass2 = new AnonymousClass2(this.this$0, this.$booking, this.$context, this.$showRefundReceipt, null);
        this.label = 4;
        if (dk.molslinjen.domain.extensions.ManagerResultExtensionsKt.onSuccess((ManagerResult) obj, anonymousClass2, this) == coroutine_suspended) {
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((TicketDetailsViewModel$refund$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
