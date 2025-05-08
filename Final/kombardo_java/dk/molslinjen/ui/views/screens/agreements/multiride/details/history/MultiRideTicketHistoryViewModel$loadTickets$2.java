package dk.molslinjen.ui.views.screens.agreements.multiride.details.history;

import dk.molslinjen.core.snackbar.ISnackbarService;
import dk.molslinjen.domain.managers.ManagerResult;
import dk.molslinjen.domain.managers.agreement.multiride.MultiRideManager;
import dk.molslinjen.extensions.ManagerResultExtensionsKt;
import dk.molslinjen.ui.views.screens.agreements.multiride.details.history.MultiRideTicketHistoryViewModel;
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
@DebugMetadata(c = "dk.molslinjen.ui.views.screens.agreements.multiride.details.history.MultiRideTicketHistoryViewModel$loadTickets$2", f = "MultiRideTicketHistoryViewModel.kt", l = {48, 49}, m = "invokeSuspend")
/* loaded from: classes2.dex */
public final class MultiRideTicketHistoryViewModel$loadTickets$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $multiRideId;
    int label;
    final /* synthetic */ MultiRideTicketHistoryViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MultiRideTicketHistoryViewModel$loadTickets$2(MultiRideTicketHistoryViewModel multiRideTicketHistoryViewModel, String str, Continuation<? super MultiRideTicketHistoryViewModel$loadTickets$2> continuation) {
        super(2, continuation);
        this.this$0 = multiRideTicketHistoryViewModel;
        this.$multiRideId = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MultiRideTicketHistoryViewModel$loadTickets$2(this.this$0, this.$multiRideId, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0049  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        MultiRideManager multiRideManager;
        ISnackbarService iSnackbarService;
        ManagerResult managerResult;
        List list;
        MutableStateFlow mutableStateFlow;
        Object value;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = this.label;
        if (i5 == 0) {
            ResultKt.throwOnFailure(obj);
            multiRideManager = this.this$0.multiRideManager;
            String str = this.$multiRideId;
            this.label = 1;
            obj = multiRideManager.getTicketHistory(str, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i5 != 1) {
                if (i5 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                managerResult = (ManagerResult) obj;
                if (!(managerResult instanceof ManagerResult.Error)) {
                    list = null;
                } else {
                    if (!(managerResult instanceof ManagerResult.Success)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    list = (List) ((ManagerResult.Success) managerResult).getData();
                }
                mutableStateFlow = this.this$0._viewState;
                do {
                    value = mutableStateFlow.getValue();
                } while (!mutableStateFlow.compareAndSet(value, MultiRideTicketHistoryViewModel.ViewState.copy$default((MultiRideTicketHistoryViewModel.ViewState) value, null, false, list, null, 9, null)));
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
        managerResult = (ManagerResult) obj;
        if (!(managerResult instanceof ManagerResult.Error)) {
        }
        mutableStateFlow = this.this$0._viewState;
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, MultiRideTicketHistoryViewModel.ViewState.copy$default((MultiRideTicketHistoryViewModel.ViewState) value, null, false, list, null, 9, null)));
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((MultiRideTicketHistoryViewModel$loadTickets$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
