package dk.molslinjen.ui.views.screens.booking.departures;

import dk.molslinjen.domain.model.booking.DayDepartures;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.conscrypt.BuildConfig;
import org.threeten.bp.LocalDate;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.ui.views.screens.booking.departures.DepartureItemsViewKt$departureItemsView$1$1$1", f = "DepartureItemsView.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes2.dex */
final class DepartureItemsViewKt$departureItemsView$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ DayDepartures $dayDepartures;
    final /* synthetic */ Function1<LocalDate, Unit> $departureDayHeaderShown;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public DepartureItemsViewKt$departureItemsView$1$1$1(Function1<? super LocalDate, Unit> function1, DayDepartures dayDepartures, Continuation<? super DepartureItemsViewKt$departureItemsView$1$1$1> continuation) {
        super(2, continuation);
        this.$departureDayHeaderShown = function1;
        this.$dayDepartures = dayDepartures;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DepartureItemsViewKt$departureItemsView$1$1$1(this.$departureDayHeaderShown, this.$dayDepartures, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        this.$departureDayHeaderShown.invoke(this.$dayDepartures.getDate());
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DepartureItemsViewKt$departureItemsView$1$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
