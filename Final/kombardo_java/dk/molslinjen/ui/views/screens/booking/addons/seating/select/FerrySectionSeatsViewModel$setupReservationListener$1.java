package dk.molslinjen.ui.views.screens.booking.addons.seating.select;

import dk.molslinjen.domain.managers.seating.ISelectSeatingManager;
import dk.molslinjen.ui.views.screens.booking.addons.seating.select.FerrySectionSeatsViewModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import org.conscrypt.BuildConfig;
import uniffi.molslinjen_shared.FerrySeatType;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.ui.views.screens.booking.addons.seating.select.FerrySectionSeatsViewModel$setupReservationListener$1", f = "FerrySectionSeatsViewModel.kt", l = {123}, m = "invokeSuspend")
/* loaded from: classes2.dex */
public final class FerrySectionSeatsViewModel$setupReservationListener$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ FerrySectionSeatsViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "managerState", "Ldk/molslinjen/domain/managers/seating/ISelectSeatingManager$SeatReservationState;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "dk.molslinjen.ui.views.screens.booking.addons.seating.select.FerrySectionSeatsViewModel$setupReservationListener$1$1", f = "FerrySectionSeatsViewModel.kt", l = {}, m = "invokeSuspend")
    /* renamed from: dk.molslinjen.ui.views.screens.booking.addons.seating.select.FerrySectionSeatsViewModel$setupReservationListener$1$1, reason: invalid class name */
    /* loaded from: classes2.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<ISelectSeatingManager.SeatReservationState, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ FerrySectionSeatsViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(FerrySectionSeatsViewModel ferrySectionSeatsViewModel, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = ferrySectionSeatsViewModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(ISelectSeatingManager.SeatReservationState seatReservationState, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(seatReservationState, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            MutableStateFlow mutableStateFlow;
            Object value;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            ISelectSeatingManager.SeatReservationState seatReservationState = (ISelectSeatingManager.SeatReservationState) this.L$0;
            mutableStateFlow = this.this$0._viewState;
            do {
                value = mutableStateFlow.getValue();
            } while (!mutableStateFlow.compareAndSet(value, FerrySectionSeatsViewModel.ViewState.m3453copyBn6Y4c$default((FerrySectionSeatsViewModel.ViewState) value, false, CollectionsKt.toSet(FerrySeatType.getEntries()), null, Boxing.boxInt(seatReservationState.getSeatsToBeSelected()), null, seatReservationState.getSeatReservationId() != null, null, false, false, null, null, 2005, null)));
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FerrySectionSeatsViewModel$setupReservationListener$1(FerrySectionSeatsViewModel ferrySectionSeatsViewModel, Continuation<? super FerrySectionSeatsViewModel$setupReservationListener$1> continuation) {
        super(2, continuation);
        this.this$0 = ferrySectionSeatsViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new FerrySectionSeatsViewModel$setupReservationListener$1(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        ISelectSeatingManager iSelectSeatingManager;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = this.label;
        if (i5 == 0) {
            ResultKt.throwOnFailure(obj);
            iSelectSeatingManager = this.this$0.seatReservationManager;
            StateFlow<ISelectSeatingManager.SeatReservationState> state = iSelectSeatingManager.getState();
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, null);
            this.label = 1;
            if (FlowKt.collectLatest(state, anonymousClass1, this) == coroutine_suspended) {
                return coroutine_suspended;
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
        return ((FerrySectionSeatsViewModel$setupReservationListener$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
