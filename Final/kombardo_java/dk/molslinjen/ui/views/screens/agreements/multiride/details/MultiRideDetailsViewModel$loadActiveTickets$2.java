package dk.molslinjen.ui.views.screens.agreements.multiride.details;

import com.google.android.gms.dynamite.descriptors.com.google.android.gms.measurement.dynamite.ModuleDescriptor;
import dk.molslinjen.core.snackbar.ISnackbarService;
import dk.molslinjen.domain.extensions.ManagerResultExtensionsKt;
import dk.molslinjen.domain.managers.ManagerResult;
import dk.molslinjen.domain.managers.agreement.multiride.IMultiRideManager;
import dk.molslinjen.domain.model.agreement.multiRide.MultiRideBookingTicket;
import dk.molslinjen.ui.views.screens.agreements.multiride.details.MultiRideDetailsViewModel;
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
@DebugMetadata(c = "dk.molslinjen.ui.views.screens.agreements.multiride.details.MultiRideDetailsViewModel$loadActiveTickets$2", f = "MultiRideDetailsViewModel.kt", l = {135, ModuleDescriptor.MODULE_VERSION, 137}, m = "invokeSuspend")
/* loaded from: classes2.dex */
public final class MultiRideDetailsViewModel$loadActiveTickets$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ MultiRideDetailsViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "data", BuildConfig.FLAVOR, "Ldk/molslinjen/domain/model/agreement/multiRide/MultiRideBookingTicket;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "dk.molslinjen.ui.views.screens.agreements.multiride.details.MultiRideDetailsViewModel$loadActiveTickets$2$1", f = "MultiRideDetailsViewModel.kt", l = {}, m = "invokeSuspend")
    /* renamed from: dk.molslinjen.ui.views.screens.agreements.multiride.details.MultiRideDetailsViewModel$loadActiveTickets$2$1, reason: invalid class name */
    /* loaded from: classes2.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<List<? extends MultiRideBookingTicket>, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ MultiRideDetailsViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(MultiRideDetailsViewModel multiRideDetailsViewModel, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = multiRideDetailsViewModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(List<? extends MultiRideBookingTicket> list, Continuation<? super Unit> continuation) {
            return invoke2((List<MultiRideBookingTicket>) list, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object value;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            List list = (List) this.L$0;
            MutableStateFlow mutableStateFlow = this.this$0._viewState;
            do {
                value = mutableStateFlow.getValue();
            } while (!mutableStateFlow.compareAndSet(value, MultiRideDetailsViewModel.ViewState.copy$default((MultiRideDetailsViewModel.ViewState) value, null, null, false, null, false, null, false, list, 127, null)));
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(List<MultiRideBookingTicket> list, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(list, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MultiRideDetailsViewModel$loadActiveTickets$2(MultiRideDetailsViewModel multiRideDetailsViewModel, Continuation<? super MultiRideDetailsViewModel$loadActiveTickets$2> continuation) {
        super(2, continuation);
        this.this$0 = multiRideDetailsViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MultiRideDetailsViewModel$loadActiveTickets$2(this.this$0, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0060 A[RETURN] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        ISnackbarService iSnackbarService;
        AnonymousClass1 anonymousClass1;
        MutableStateFlow mutableStateFlow;
        Object value;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = this.label;
        if (i5 == 0) {
            ResultKt.throwOnFailure(obj);
            IMultiRideManager iMultiRideManager = this.this$0.multiRideManager;
            String multiRideId = this.this$0.getMultiRideId();
            this.label = 1;
            obj = iMultiRideManager.getActiveTickets(multiRideId, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i5 != 1) {
                if (i5 != 2) {
                    if (i5 != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    mutableStateFlow = this.this$0._viewState;
                    do {
                        value = mutableStateFlow.getValue();
                    } while (!mutableStateFlow.compareAndSet(value, MultiRideDetailsViewModel.ViewState.copy$default((MultiRideDetailsViewModel.ViewState) value, null, null, false, null, false, null, false, null, 191, null)));
                    return Unit.INSTANCE;
                }
                ResultKt.throwOnFailure(obj);
                anonymousClass1 = new AnonymousClass1(this.this$0, null);
                this.label = 3;
                if (ManagerResultExtensionsKt.onSuccess((ManagerResult) obj, anonymousClass1, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                mutableStateFlow = this.this$0._viewState;
                do {
                    value = mutableStateFlow.getValue();
                } while (!mutableStateFlow.compareAndSet(value, MultiRideDetailsViewModel.ViewState.copy$default((MultiRideDetailsViewModel.ViewState) value, null, null, false, null, false, null, false, null, 191, null)));
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
        anonymousClass1 = new AnonymousClass1(this.this$0, null);
        this.label = 3;
        if (ManagerResultExtensionsKt.onSuccess((ManagerResult) obj, anonymousClass1, this) == coroutine_suspended) {
        }
        mutableStateFlow = this.this$0._viewState;
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, MultiRideDetailsViewModel.ViewState.copy$default((MultiRideDetailsViewModel.ViewState) value, null, null, false, null, false, null, false, null, 191, null)));
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((MultiRideDetailsViewModel$loadActiveTickets$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
