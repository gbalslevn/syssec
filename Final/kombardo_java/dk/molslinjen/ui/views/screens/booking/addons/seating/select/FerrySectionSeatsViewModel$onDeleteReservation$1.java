package dk.molslinjen.ui.views.screens.booking.addons.seating.select;

import dk.molslinjen.core.snackbar.ISnackbarService;
import dk.molslinjen.domain.managers.ManagerResult;
import dk.molslinjen.domain.managers.seating.ISelectSeatingManager;
import dk.molslinjen.extensions.ManagerResultExtensionsKt;
import dk.molslinjen.ui.views.screens.booking.addons.seating.select.FerrySectionSeatsViewModel;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableStateFlow;
import org.conscrypt.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.ui.views.screens.booking.addons.seating.select.FerrySectionSeatsViewModel$onDeleteReservation$1", f = "FerrySectionSeatsViewModel.kt", l = {208, 216}, m = "invokeSuspend")
/* loaded from: classes2.dex */
public final class FerrySectionSeatsViewModel$onDeleteReservation$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<Boolean, Unit> $onSuccessfulDelete;
    int label;
    final /* synthetic */ FerrySectionSeatsViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FerrySectionSeatsViewModel$onDeleteReservation$1(FerrySectionSeatsViewModel ferrySectionSeatsViewModel, Function1<? super Boolean, Unit> function1, Continuation<? super FerrySectionSeatsViewModel$onDeleteReservation$1> continuation) {
        super(2, continuation);
        this.this$0 = ferrySectionSeatsViewModel;
        this.$onSuccessfulDelete = function1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new FerrySectionSeatsViewModel$onDeleteReservation$1(this.this$0, this.$onSuccessfulDelete, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        MutableStateFlow mutableStateFlow;
        Object value;
        ISelectSeatingManager iSelectSeatingManager;
        Object unreserve;
        MutableStateFlow mutableStateFlow2;
        Object value2;
        ISnackbarService iSnackbarService;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = this.label;
        if (i5 == 0) {
            ResultKt.throwOnFailure(obj);
            mutableStateFlow = this.this$0._viewState;
            do {
                value = mutableStateFlow.getValue();
            } while (!mutableStateFlow.compareAndSet(value, FerrySectionSeatsViewModel.ViewState.m3453copyBn6Y4c$default((FerrySectionSeatsViewModel.ViewState) value, false, null, null, null, null, false, null, false, true, null, null, 1791, null)));
            iSelectSeatingManager = this.this$0.seatReservationManager;
            this.label = 1;
            unreserve = iSelectSeatingManager.unreserve(this);
            if (unreserve == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i5 != 1) {
                if (i5 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            }
            ResultKt.throwOnFailure(obj);
            unreserve = obj;
        }
        ManagerResult managerResult = (ManagerResult) unreserve;
        if (managerResult instanceof ManagerResult.Error) {
            mutableStateFlow2 = this.this$0._viewState;
            do {
                value2 = mutableStateFlow2.getValue();
            } while (!mutableStateFlow2.compareAndSet(value2, FerrySectionSeatsViewModel.ViewState.m3453copyBn6Y4c$default((FerrySectionSeatsViewModel.ViewState) value2, false, null, null, null, null, false, null, false, false, null, null, 1663, null)));
            iSnackbarService = this.this$0.snackbarService;
            this.label = 2;
            if (ManagerResultExtensionsKt.handleError((ManagerResult.Error) managerResult, iSnackbarService, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (!(managerResult instanceof ManagerResult.Success)) {
                throw new NoWhenBranchMatchedException();
            }
            this.$onSuccessfulDelete.invoke(Boxing.boxBoolean(true));
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((FerrySectionSeatsViewModel$onDeleteReservation$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
