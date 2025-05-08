package dk.molslinjen.ui.views.global.navigation;

import dk.molslinjen.domain.managers.agreement.multiride.IMultiRideManager;
import dk.molslinjen.domain.managers.infoAlerts.IInfoAlertManager;
import dk.molslinjen.domain.managers.ticket.ITicketsManager;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.ui.views.global.navigation.MainActivity$onStart$1", f = "MainActivity.kt", l = {182, 183, 185}, m = "invokeSuspend")
/* loaded from: classes2.dex */
final class MainActivity$onStart$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ MainActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MainActivity$onStart$1(MainActivity mainActivity, Continuation<? super MainActivity$onStart$1> continuation) {
        super(2, continuation);
        this.this$0 = mainActivity;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MainActivity$onStart$1(this.this$0, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x006d A[RETURN] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        IMultiRideManager multiRideManager;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = this.label;
        if (i5 == 0) {
            ResultKt.throwOnFailure(obj);
            this.this$0.getTicketsManager().updateActiveTicketCount(this.this$0.getTicketsManager().getTicketsState().getValue());
            ITicketsManager ticketsManager = this.this$0.getTicketsManager();
            this.label = 1;
            if (ticketsManager.updateLocalBookings(this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i5 != 1) {
                if (i5 != 2) {
                    if (i5 != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                ResultKt.throwOnFailure(obj);
                multiRideManager = this.this$0.getMultiRideManager();
                this.label = 3;
                if (multiRideManager.loadMultiRides(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return Unit.INSTANCE;
            }
            ResultKt.throwOnFailure(obj);
        }
        IInfoAlertManager infoAlertsManager = this.this$0.getInfoAlertsManager();
        this.label = 2;
        if (infoAlertsManager.updateInfoAlerts(this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        multiRideManager = this.this$0.getMultiRideManager();
        this.label = 3;
        if (multiRideManager.loadMultiRides(this) == coroutine_suspended) {
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((MainActivity$onStart$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
