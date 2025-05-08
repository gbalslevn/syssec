package dk.molslinjen.ui.views.screens.booking.departures;

import android.content.Context;
import androidx.compose.foundation.lazy.LazyListState;
import dk.molslinjen.domain.managers.checkout.EditManager;
import dk.molslinjen.domain.managers.departure.DepartureState;
import dk.molslinjen.domain.model.booking.DepartureDirection;
import dk.molslinjen.domain.model.booking.DepartureTicket;
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
import org.threeten.bp.LocalDate;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.ui.views.screens.booking.departures.DeparturesScreenSharedKt$HandleDepartureSelectionChanges$3$1", f = "DeparturesScreenShared.kt", l = {291}, m = "invokeSuspend")
/* loaded from: classes2.dex */
final class DeparturesScreenSharedKt$HandleDepartureSelectionChanges$3$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ EditManager.EditState $editState;
    final /* synthetic */ LazyListState $listState;
    final /* synthetic */ DepartureState $outboundDepartureState;
    final /* synthetic */ LocalDate $selectedCalendarDate;
    final /* synthetic */ DeparturesViewModel $viewModel;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DeparturesScreenSharedKt$HandleDepartureSelectionChanges$3$1(DepartureState departureState, EditManager.EditState editState, DeparturesViewModel departuresViewModel, Context context, LocalDate localDate, LazyListState lazyListState, Continuation<? super DeparturesScreenSharedKt$HandleDepartureSelectionChanges$3$1> continuation) {
        super(2, continuation);
        this.$outboundDepartureState = departureState;
        this.$editState = editState;
        this.$viewModel = departuresViewModel;
        this.$context = context;
        this.$selectedCalendarDate = localDate;
        this.$listState = lazyListState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DeparturesScreenSharedKt$HandleDepartureSelectionChanges$3$1(this.$outboundDepartureState, this.$editState, this.$viewModel, this.$context, this.$selectedCalendarDate, this.$listState, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = this.label;
        if (i5 == 0) {
            ResultKt.throwOnFailure(obj);
            if (this.$outboundDepartureState.getSelectedDepartureTicket() != null && this.$editState.getIsEditing()) {
                DeparturesViewModel departuresViewModel = this.$viewModel;
                Context context = this.$context;
                DepartureTicket selectedDepartureTicket = this.$outboundDepartureState.getSelectedDepartureTicket();
                if (selectedDepartureTicket == null) {
                    return Unit.INSTANCE;
                }
                departuresViewModel.showChangeFeeWarning(context, selectedDepartureTicket);
            }
            if (this.$outboundDepartureState.getSelectedDepartureTicket() == null) {
                this.$viewModel.updateDepartureDirection(DepartureDirection.Outbound, this.$selectedCalendarDate);
                LazyListState lazyListState = this.$listState;
                this.label = 1;
                if (LazyListState.animateScrollToItem$default(lazyListState, 0, 0, this, 2, null) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        } else {
            if (i5 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DeparturesScreenSharedKt$HandleDepartureSelectionChanges$3$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
