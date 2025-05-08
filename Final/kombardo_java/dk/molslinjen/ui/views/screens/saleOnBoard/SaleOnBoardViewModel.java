package dk.molslinjen.ui.views.screens.saleOnBoard;

import androidx.appcompat.R$styleable;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import dk.molslinjen.domain.managers.saleOnBoard.ISaleOnBoardCheckoutManager;
import dk.molslinjen.domain.managers.saleOnBoard.ISaleOnBoardManager;
import dk.molslinjen.domain.managers.saleOnBoard.SaleOnBoardManager;
import dk.molslinjen.domain.managers.ticket.ITicketsManager;
import dk.molslinjen.domain.managers.ticket.TicketsManager;
import dk.molslinjen.domain.model.booking.IDepartureInfo;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.StateFlow;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u001c\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00130\u0017J\u0006\u0010\u0018\u001a\u00020\u0013R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000e¨\u0006\u0019"}, d2 = {"Ldk/molslinjen/ui/views/screens/saleOnBoard/SaleOnBoardViewModel;", "Landroidx/lifecycle/ViewModel;", "ticketsManager", "Ldk/molslinjen/domain/managers/ticket/ITicketsManager;", "saleOnBoardCheckoutManager", "Ldk/molslinjen/domain/managers/saleOnBoard/ISaleOnBoardCheckoutManager;", "saleOnBoardManager", "Ldk/molslinjen/domain/managers/saleOnBoard/ISaleOnBoardManager;", "<init>", "(Ldk/molslinjen/domain/managers/ticket/ITicketsManager;Ldk/molslinjen/domain/managers/saleOnBoard/ISaleOnBoardCheckoutManager;Ldk/molslinjen/domain/managers/saleOnBoard/ISaleOnBoardManager;)V", "ticketsState", "Lkotlinx/coroutines/flow/StateFlow;", "Ldk/molslinjen/domain/managers/ticket/TicketsManager$TicketsState;", "getTicketsState", "()Lkotlinx/coroutines/flow/StateFlow;", "saleOnBoardState", "Ldk/molslinjen/domain/managers/saleOnBoard/SaleOnBoardManager$SaleOnBoardState;", "getSaleOnBoardState", "departureSelected", BuildConfig.FLAVOR, "departure", "Ldk/molslinjen/domain/model/booking/IDepartureInfo;", "proceed", "Lkotlin/Function0;", "updateOrders", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SaleOnBoardViewModel extends ViewModel {
    private final ISaleOnBoardCheckoutManager saleOnBoardCheckoutManager;
    private final ISaleOnBoardManager saleOnBoardManager;
    private final StateFlow<SaleOnBoardManager.SaleOnBoardState> saleOnBoardState;
    private final ITicketsManager ticketsManager;
    private final StateFlow<TicketsManager.TicketsState> ticketsState;

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "dk.molslinjen.ui.views.screens.saleOnBoard.SaleOnBoardViewModel$1", f = "SaleOnBoardViewModel.kt", l = {R$styleable.Toolbar_titleMarginEnd}, m = "invokeSuspend")
    /* renamed from: dk.molslinjen.ui.views.screens.saleOnBoard.SaleOnBoardViewModel$1, reason: invalid class name */
    /* loaded from: classes2.dex */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i5 = this.label;
            if (i5 == 0) {
                ResultKt.throwOnFailure(obj);
                ITicketsManager iTicketsManager = SaleOnBoardViewModel.this.ticketsManager;
                this.label = 1;
                if (iTicketsManager.updateLocalBookings(this) == coroutine_suspended) {
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
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    public SaleOnBoardViewModel(ITicketsManager ticketsManager, ISaleOnBoardCheckoutManager saleOnBoardCheckoutManager, ISaleOnBoardManager saleOnBoardManager) {
        Intrinsics.checkNotNullParameter(ticketsManager, "ticketsManager");
        Intrinsics.checkNotNullParameter(saleOnBoardCheckoutManager, "saleOnBoardCheckoutManager");
        Intrinsics.checkNotNullParameter(saleOnBoardManager, "saleOnBoardManager");
        this.ticketsManager = ticketsManager;
        this.saleOnBoardCheckoutManager = saleOnBoardCheckoutManager;
        this.saleOnBoardManager = saleOnBoardManager;
        this.ticketsState = ticketsManager.getTicketsState();
        this.saleOnBoardState = saleOnBoardManager.getSaleOnBoardState();
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new AnonymousClass1(null), 3, null);
    }

    public final void departureSelected(IDepartureInfo departure, Function0<Unit> proceed) {
        Intrinsics.checkNotNullParameter(departure, "departure");
        Intrinsics.checkNotNullParameter(proceed, "proceed");
        this.saleOnBoardCheckoutManager.setupWithDeparture(departure);
        proceed.invoke();
    }

    public final StateFlow<SaleOnBoardManager.SaleOnBoardState> getSaleOnBoardState() {
        return this.saleOnBoardState;
    }

    public final StateFlow<TicketsManager.TicketsState> getTicketsState() {
        return this.ticketsState;
    }

    public final void updateOrders() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new SaleOnBoardViewModel$updateOrders$1(this, null), 3, null);
    }
}
