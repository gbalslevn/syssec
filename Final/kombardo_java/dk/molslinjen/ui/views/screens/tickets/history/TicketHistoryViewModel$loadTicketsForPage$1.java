package dk.molslinjen.ui.views.screens.tickets.history;

import dk.molslinjen.core.snackbar.ISnackbarService;
import dk.molslinjen.domain.extensions.ManagerResultExtensionsKt;
import dk.molslinjen.domain.managers.ManagerResult;
import dk.molslinjen.domain.managers.ticket.ITicketsManager;
import dk.molslinjen.domain.model.booking.BookingHeader;
import dk.molslinjen.ui.views.screens.tickets.history.TicketHistoryViewModel;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
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
@DebugMetadata(c = "dk.molslinjen.ui.views.screens.tickets.history.TicketHistoryViewModel$loadTicketsForPage$1", f = "TicketHistoryViewModel.kt", l = {40, 43, 44, 53}, m = "invokeSuspend")
/* loaded from: classes2.dex */
public final class TicketHistoryViewModel$loadTicketsForPage$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $page;
    int I$0;
    int label;
    final /* synthetic */ TicketHistoryViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "bookings", BuildConfig.FLAVOR, "Ldk/molslinjen/domain/model/booking/BookingHeader;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "dk.molslinjen.ui.views.screens.tickets.history.TicketHistoryViewModel$loadTicketsForPage$1$1", f = "TicketHistoryViewModel.kt", l = {}, m = "invokeSuspend")
    /* renamed from: dk.molslinjen.ui.views.screens.tickets.history.TicketHistoryViewModel$loadTicketsForPage$1$1, reason: invalid class name */
    /* loaded from: classes2.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<List<? extends BookingHeader>, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $pageSize;
        /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ TicketHistoryViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(TicketHistoryViewModel ticketHistoryViewModel, int i5, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = ticketHistoryViewModel;
            this.$pageSize = i5;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, this.$pageSize, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(List<? extends BookingHeader> list, Continuation<? super Unit> continuation) {
            return invoke2((List<BookingHeader>) list, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            MutableStateFlow mutableStateFlow;
            Object value;
            TicketHistoryViewModel.ViewState viewState;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            List list = (List) this.L$0;
            mutableStateFlow = this.this$0._viewState;
            int i5 = this.$pageSize;
            do {
                value = mutableStateFlow.getValue();
                viewState = (TicketHistoryViewModel.ViewState) value;
            } while (!mutableStateFlow.compareAndSet(value, TicketHistoryViewModel.ViewState.copy$default(viewState, CollectionsKt.plus((Collection) viewState.getBookings(), (Iterable) list), i5 == list.size(), 0, 0, i5 == list.size(), 12, null)));
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(List<BookingHeader> list, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(list, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "dk.molslinjen.ui.views.screens.tickets.history.TicketHistoryViewModel$loadTicketsForPage$1$2", f = "TicketHistoryViewModel.kt", l = {}, m = "invokeSuspend")
    /* renamed from: dk.molslinjen.ui.views.screens.tickets.history.TicketHistoryViewModel$loadTicketsForPage$1$2, reason: invalid class name */
    /* loaded from: classes2.dex */
    public static final class AnonymousClass2 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ TicketHistoryViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(TicketHistoryViewModel ticketHistoryViewModel, Continuation<? super AnonymousClass2> continuation) {
            super(1, continuation);
            this.this$0 = ticketHistoryViewModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> continuation) {
            return new AnonymousClass2(this.this$0, continuation);
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
            } while (!mutableStateFlow.compareAndSet(value, TicketHistoryViewModel.ViewState.copy$default((TicketHistoryViewModel.ViewState) value, null, false, 0, 0, false, 13, null)));
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TicketHistoryViewModel$loadTicketsForPage$1(TicketHistoryViewModel ticketHistoryViewModel, int i5, Continuation<? super TicketHistoryViewModel$loadTicketsForPage$1> continuation) {
        super(2, continuation);
        this.this$0 = ticketHistoryViewModel;
        this.$page = i5;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TicketHistoryViewModel$loadTicketsForPage$1(this.this$0, this.$page, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0091 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x007f A[RETURN] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        ITicketsManager iTicketsManager;
        int i5;
        ISnackbarService iSnackbarService;
        AnonymousClass2 anonymousClass2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i6 = this.label;
        if (i6 == 0) {
            ResultKt.throwOnFailure(obj);
            int pageSize = this.this$0.getViewState().getValue().getPageSize();
            iTicketsManager = this.this$0.ticketsManager;
            int i7 = this.$page;
            this.I$0 = pageSize;
            this.label = 1;
            Object ticketHistory = iTicketsManager.getTicketHistory(i7, pageSize, this);
            if (ticketHistory == coroutine_suspended) {
                return coroutine_suspended;
            }
            i5 = pageSize;
            obj = ticketHistory;
        } else {
            if (i6 != 1) {
                if (i6 != 2) {
                    if (i6 != 3) {
                        if (i6 != 4) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                        return Unit.INSTANCE;
                    }
                    ResultKt.throwOnFailure(obj);
                    anonymousClass2 = new AnonymousClass2(this.this$0, null);
                    this.label = 4;
                    if (ManagerResultExtensionsKt.onFailure((ManagerResult) obj, anonymousClass2, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return Unit.INSTANCE;
                }
                i5 = this.I$0;
                ResultKt.throwOnFailure(obj);
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, i5, null);
                this.label = 3;
                obj = ManagerResultExtensionsKt.onSuccess((ManagerResult) obj, anonymousClass1, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                anonymousClass2 = new AnonymousClass2(this.this$0, null);
                this.label = 4;
                if (ManagerResultExtensionsKt.onFailure((ManagerResult) obj, anonymousClass2, this) == coroutine_suspended) {
                }
                return Unit.INSTANCE;
            }
            i5 = this.I$0;
            ResultKt.throwOnFailure(obj);
        }
        iSnackbarService = this.this$0.snackbarService;
        this.I$0 = i5;
        this.label = 2;
        obj = dk.molslinjen.extensions.ManagerResultExtensionsKt.handlePotentialError((ManagerResult) obj, iSnackbarService, this);
        if (obj == coroutine_suspended) {
            return coroutine_suspended;
        }
        AnonymousClass1 anonymousClass12 = new AnonymousClass1(this.this$0, i5, null);
        this.label = 3;
        obj = ManagerResultExtensionsKt.onSuccess((ManagerResult) obj, anonymousClass12, this);
        if (obj == coroutine_suspended) {
        }
        anonymousClass2 = new AnonymousClass2(this.this$0, null);
        this.label = 4;
        if (ManagerResultExtensionsKt.onFailure((ManagerResult) obj, anonymousClass2, this) == coroutine_suspended) {
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((TicketHistoryViewModel$loadTicketsForPage$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
