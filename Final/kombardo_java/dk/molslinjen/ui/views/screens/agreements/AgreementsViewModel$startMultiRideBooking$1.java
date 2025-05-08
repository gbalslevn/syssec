package dk.molslinjen.ui.views.screens.agreements;

import dk.molslinjen.domain.managers.agreement.multiride.MultiRideManager;
import dk.molslinjen.domain.managers.route.IRouteManager;
import dk.molslinjen.domain.model.agreement.multiRide.MultiRideCard;
import dk.molslinjen.domain.model.booking.MultiRideBookingData;
import dk.molslinjen.domain.model.config.Site;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.conscrypt.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.ui.views.screens.agreements.AgreementsViewModel$startMultiRideBooking$1", f = "AgreementsViewModel.kt", l = {74}, m = "invokeSuspend")
/* loaded from: classes2.dex */
public final class AgreementsViewModel$startMultiRideBooking$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MultiRideCard $multiRideCard;
    final /* synthetic */ Function0<Unit> $proceed;
    int label;
    final /* synthetic */ AgreementsViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AgreementsViewModel$startMultiRideBooking$1(AgreementsViewModel agreementsViewModel, MultiRideCard multiRideCard, Function0<Unit> function0, Continuation<? super AgreementsViewModel$startMultiRideBooking$1> continuation) {
        super(2, continuation);
        this.this$0 = agreementsViewModel;
        this.$multiRideCard = multiRideCard;
        this.$proceed = function0;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AgreementsViewModel$startMultiRideBooking$1(this.this$0, this.$multiRideCard, this.$proceed, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IRouteManager iRouteManager;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = this.label;
        if (i5 == 0) {
            ResultKt.throwOnFailure(obj);
            iRouteManager = this.this$0.routeManager;
            MultiRideBookingData multiRideBookingData = new MultiRideBookingData(this.$multiRideCard, false);
            Site forceMolsSite = MultiRideManager.INSTANCE.getForceMolsSite();
            this.label = 1;
            if (iRouteManager.setupForMultiRide(multiRideBookingData, forceMolsSite, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i5 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        this.$proceed.invoke();
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AgreementsViewModel$startMultiRideBooking$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
