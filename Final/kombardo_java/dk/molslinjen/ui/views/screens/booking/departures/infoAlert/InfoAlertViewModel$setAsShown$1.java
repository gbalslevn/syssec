package dk.molslinjen.ui.views.screens.booking.departures.infoAlert;

import dk.molslinjen.domain.managers.infoAlerts.IInfoAlertManager;
import dk.molslinjen.domain.model.info.InfoAlert;
import java.util.ArrayList;
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
import org.conscrypt.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.ui.views.screens.booking.departures.infoAlert.InfoAlertViewModel$setAsShown$1", f = "InfoAlertViewModel.kt", l = {55}, m = "invokeSuspend")
/* loaded from: classes2.dex */
public final class InfoAlertViewModel$setAsShown$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ InfoAlert $infoAlert;
    int label;
    final /* synthetic */ InfoAlertViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InfoAlertViewModel$setAsShown$1(InfoAlertViewModel infoAlertViewModel, InfoAlert infoAlert, Continuation<? super InfoAlertViewModel$setAsShown$1> continuation) {
        super(2, continuation);
        this.this$0 = infoAlertViewModel;
        this.$infoAlert = infoAlert;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new InfoAlertViewModel$setAsShown$1(this.this$0, this.$infoAlert, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = this.label;
        if (i5 == 0) {
            ResultKt.throwOnFailure(obj);
            IInfoAlertManager iInfoAlertManager = this.this$0.infoAlertManager;
            InfoAlert infoAlert = this.$infoAlert;
            this.label = 1;
            if (iInfoAlertManager.setAsShown(infoAlert, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i5 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        InfoAlertViewModel infoAlertViewModel = this.this$0;
        List<InfoAlert> infoAlerts = infoAlertViewModel.infoAlertManager.getInfoAlertsState().getValue().getInfoAlerts();
        ArrayList arrayList = new ArrayList();
        for (Object obj2 : infoAlerts) {
            if (!((InfoAlert) obj2).getShown()) {
                arrayList.add(obj2);
            }
        }
        infoAlertViewModel.updateInfoAlertsToShow(arrayList);
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((InfoAlertViewModel$setAsShown$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
