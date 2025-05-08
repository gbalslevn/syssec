package dk.molslinjen.ui.views.screens.booking.departures;

import androidx.compose.runtime.MutableState;
import dk.molslinjen.domain.managers.departure.DepartureState;
import dk.molslinjen.domain.model.booking.BookingType;
import dk.molslinjen.domain.model.booking.DepartureDirection;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import org.conscrypt.BuildConfig;
import org.threeten.bp.LocalDate;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.ui.views.screens.booking.departures.DeparturesScreenSharedKt$HandleDepartureSelectionChanges$2$1", f = "DeparturesScreenShared.kt", l = {273}, m = "invokeSuspend")
/* loaded from: classes2.dex */
final class DeparturesScreenSharedKt$HandleDepartureSelectionChanges$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ BookingType $bookingType;
    final /* synthetic */ MutableState<UUID> $lastOutboundDeparturesSelectedTriggerKey;
    final /* synthetic */ DepartureState $outboundDepartureState;
    final /* synthetic */ LocalDate $selectedCalendarDate;
    final /* synthetic */ DeparturesViewModel $viewModel;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DeparturesScreenSharedKt$HandleDepartureSelectionChanges$2$1(DepartureState departureState, MutableState<UUID> mutableState, BookingType bookingType, DeparturesViewModel departuresViewModel, LocalDate localDate, Continuation<? super DeparturesScreenSharedKt$HandleDepartureSelectionChanges$2$1> continuation) {
        super(2, continuation);
        this.$outboundDepartureState = departureState;
        this.$lastOutboundDeparturesSelectedTriggerKey = mutableState;
        this.$bookingType = bookingType;
        this.$viewModel = departuresViewModel;
        this.$selectedCalendarDate = localDate;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DeparturesScreenSharedKt$HandleDepartureSelectionChanges$2$1(this.$outboundDepartureState, this.$lastOutboundDeparturesSelectedTriggerKey, this.$bookingType, this.$viewModel, this.$selectedCalendarDate, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = this.label;
        if (i5 == 0) {
            ResultKt.throwOnFailure(obj);
            if (this.$outboundDepartureState.getSelectedDeparture() != null && this.$lastOutboundDeparturesSelectedTriggerKey.getValue() != null && this.$bookingType == BookingType.TwoWay) {
                this.label = 1;
                if (DelayKt.delay(700L, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return Unit.INSTANCE;
        }
        if (i5 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        this.$viewModel.updateDepartureDirection(DepartureDirection.Return, this.$selectedCalendarDate);
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DeparturesScreenSharedKt$HandleDepartureSelectionChanges$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
