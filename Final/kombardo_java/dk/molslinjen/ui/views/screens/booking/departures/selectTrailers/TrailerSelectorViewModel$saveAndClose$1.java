package dk.molslinjen.ui.views.screens.booking.departures.selectTrailers;

import dk.molslinjen.domain.managers.checkout.IReturnManager;
import dk.molslinjen.domain.managers.route.IRouteManager;
import dk.molslinjen.domain.model.booking.product.TrailerProduct;
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
@DebugMetadata(c = "dk.molslinjen.ui.views.screens.booking.departures.selectTrailers.TrailerSelectorViewModel$saveAndClose$1", f = "TrailerSelectorViewModel.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes2.dex */
public final class TrailerSelectorViewModel$saveAndClose$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ TrailerProduct $outboundTrailer;
    final /* synthetic */ Function0<Unit> $proceed;
    final /* synthetic */ TrailerProduct $returnTrailer;
    int label;
    final /* synthetic */ TrailerSelectorViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TrailerSelectorViewModel$saveAndClose$1(TrailerSelectorViewModel trailerSelectorViewModel, TrailerProduct trailerProduct, TrailerProduct trailerProduct2, Function0<Unit> function0, Continuation<? super TrailerSelectorViewModel$saveAndClose$1> continuation) {
        super(2, continuation);
        this.this$0 = trailerSelectorViewModel;
        this.$outboundTrailer = trailerProduct;
        this.$returnTrailer = trailerProduct2;
        this.$proceed = function0;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TrailerSelectorViewModel$saveAndClose$1(this.this$0, this.$outboundTrailer, this.$returnTrailer, this.$proceed, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IRouteManager iRouteManager;
        IReturnManager iReturnManager;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        iRouteManager = this.this$0.routeManager;
        TrailerProduct trailerProduct = this.$outboundTrailer;
        TrailerProduct trailerProduct2 = this.$returnTrailer;
        iReturnManager = this.this$0.returnManager;
        iRouteManager.setTrailer(trailerProduct, trailerProduct2, iReturnManager.getReturnState().getValue().getIsAddingReturnFromBookingSummary());
        this.$proceed.invoke();
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((TrailerSelectorViewModel$saveAndClose$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
