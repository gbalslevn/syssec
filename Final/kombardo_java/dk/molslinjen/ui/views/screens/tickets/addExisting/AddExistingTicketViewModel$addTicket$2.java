package dk.molslinjen.ui.views.screens.tickets.addExisting;

import dk.molslinjen.core.snackbar.ISnackbarService;
import dk.molslinjen.domain.extensions.ManagerResultExtensionsKt;
import dk.molslinjen.domain.managers.ManagerResult;
import dk.molslinjen.domain.managers.ticket.ITicketsManager;
import dk.molslinjen.domain.model.shared.PhoneNumber;
import dk.molslinjen.ui.views.screens.tickets.addExisting.AddExistingTicketViewModel;
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
@DebugMetadata(c = "dk.molslinjen.ui.views.screens.tickets.addExisting.AddExistingTicketViewModel$addTicket$2", f = "AddExistingTicketViewModel.kt", l = {34, 35, 36, 38}, m = "invokeSuspend")
/* loaded from: classes2.dex */
public final class AddExistingTicketViewModel$addTicket$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ PhoneNumber $phoneNumber;
    final /* synthetic */ Function0<Unit> $proceed;
    final /* synthetic */ String $reservationNumber;
    int label;
    final /* synthetic */ AddExistingTicketViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "it"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "dk.molslinjen.ui.views.screens.tickets.addExisting.AddExistingTicketViewModel$addTicket$2$1", f = "AddExistingTicketViewModel.kt", l = {}, m = "invokeSuspend")
    /* renamed from: dk.molslinjen.ui.views.screens.tickets.addExisting.AddExistingTicketViewModel$addTicket$2$1, reason: invalid class name */
    /* loaded from: classes2.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<Unit, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function0<Unit> $proceed;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Function0<Unit> function0, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$proceed = function0;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$proceed, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            this.$proceed.invoke();
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Unit unit, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(unit, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "dk.molslinjen.ui.views.screens.tickets.addExisting.AddExistingTicketViewModel$addTicket$2$2", f = "AddExistingTicketViewModel.kt", l = {}, m = "invokeSuspend")
    /* renamed from: dk.molslinjen.ui.views.screens.tickets.addExisting.AddExistingTicketViewModel$addTicket$2$2, reason: invalid class name */
    /* loaded from: classes2.dex */
    public static final class AnonymousClass2 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ AddExistingTicketViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(AddExistingTicketViewModel addExistingTicketViewModel, Continuation<? super AnonymousClass2> continuation) {
            super(1, continuation);
            this.this$0 = addExistingTicketViewModel;
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
            } while (!mutableStateFlow.compareAndSet(value, AddExistingTicketViewModel.ViewState.copy$default((AddExistingTicketViewModel.ViewState) value, null, null, false, 3, null)));
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AddExistingTicketViewModel$addTicket$2(AddExistingTicketViewModel addExistingTicketViewModel, PhoneNumber phoneNumber, String str, Function0<Unit> function0, Continuation<? super AddExistingTicketViewModel$addTicket$2> continuation) {
        super(2, continuation);
        this.this$0 = addExistingTicketViewModel;
        this.$phoneNumber = phoneNumber;
        this.$reservationNumber = str;
        this.$proceed = function0;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AddExistingTicketViewModel$addTicket$2(this.this$0, this.$phoneNumber, this.$reservationNumber, this.$proceed, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0077 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0065 A[RETURN] */
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
            PhoneNumber phoneNumber = this.$phoneNumber;
            String str = this.$reservationNumber;
            this.label = 1;
            obj = iTicketsManager.addTicket(phoneNumber, str, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i5 != 1) {
                if (i5 == 2) {
                    ResultKt.throwOnFailure(obj);
                    AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$proceed, null);
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
                if (i5 != 3) {
                    if (i5 != 4) {
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
            ResultKt.throwOnFailure(obj);
        }
        iSnackbarService = this.this$0.snackbarService;
        this.label = 2;
        obj = dk.molslinjen.extensions.ManagerResultExtensionsKt.handlePotentialError((ManagerResult) obj, iSnackbarService, this);
        if (obj == coroutine_suspended) {
            return coroutine_suspended;
        }
        AnonymousClass1 anonymousClass12 = new AnonymousClass1(this.$proceed, null);
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
        return ((AddExistingTicketViewModel$addTicket$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
