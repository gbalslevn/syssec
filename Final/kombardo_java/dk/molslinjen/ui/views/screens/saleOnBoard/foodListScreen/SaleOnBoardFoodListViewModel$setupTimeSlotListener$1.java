package dk.molslinjen.ui.views.screens.saleOnBoard.foodListScreen;

import dk.molslinjen.domain.managers.saleOnBoard.ISaleOnBoardCheckoutManager;
import dk.molslinjen.domain.managers.saleOnBoard.SaleOnBoardCheckoutManager;
import dk.molslinjen.domain.model.saleOnBoard.SaleOnBoardStore;
import dk.molslinjen.domain.model.saleOnBoard.SaleOnBoardStoreTimeSlots;
import dk.molslinjen.domain.model.saleOnBoard.SaleOnBoardTimeSlot;
import dk.molslinjen.ui.views.screens.saleOnBoard.foodListScreen.SaleOnBoardFoodListViewModel;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import org.conscrypt.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.ui.views.screens.saleOnBoard.foodListScreen.SaleOnBoardFoodListViewModel$setupTimeSlotListener$1", f = "SaleOnBoardFoodListViewModel.kt", l = {39}, m = "invokeSuspend")
/* loaded from: classes2.dex */
public final class SaleOnBoardFoodListViewModel$setupTimeSlotListener$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ SaleOnBoardFoodListViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "state", "Ldk/molslinjen/domain/managers/saleOnBoard/SaleOnBoardCheckoutManager$SaleOnBoardCheckoutState;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "dk.molslinjen.ui.views.screens.saleOnBoard.foodListScreen.SaleOnBoardFoodListViewModel$setupTimeSlotListener$1$1", f = "SaleOnBoardFoodListViewModel.kt", l = {}, m = "invokeSuspend")
    /* renamed from: dk.molslinjen.ui.views.screens.saleOnBoard.foodListScreen.SaleOnBoardFoodListViewModel$setupTimeSlotListener$1$1, reason: invalid class name */
    /* loaded from: classes2.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<SaleOnBoardCheckoutManager.SaleOnBoardCheckoutState, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ SaleOnBoardFoodListViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(SaleOnBoardFoodListViewModel saleOnBoardFoodListViewModel, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = saleOnBoardFoodListViewModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(SaleOnBoardCheckoutManager.SaleOnBoardCheckoutState saleOnBoardCheckoutState, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(saleOnBoardCheckoutState, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            MutableStateFlow mutableStateFlow;
            Object value;
            SaleOnBoardFoodListViewModel.ViewState viewState;
            Object obj2;
            List<SaleOnBoardTimeSlot> emptyList;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            SaleOnBoardCheckoutManager.SaleOnBoardCheckoutState saleOnBoardCheckoutState = (SaleOnBoardCheckoutManager.SaleOnBoardCheckoutState) this.L$0;
            if (saleOnBoardCheckoutState.getStoresWithTimeSlots().isEmpty()) {
                return Unit.INSTANCE;
            }
            SaleOnBoardStore selectedStore = saleOnBoardCheckoutState.getSelectedStore();
            if (selectedStore != null) {
                mutableStateFlow = this.this$0._viewState;
                do {
                    value = mutableStateFlow.getValue();
                    viewState = (SaleOnBoardFoodListViewModel.ViewState) value;
                    Iterator<T> it = saleOnBoardCheckoutState.getStoresWithTimeSlots().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            obj2 = null;
                            break;
                        }
                        obj2 = it.next();
                        if (Intrinsics.areEqual(((SaleOnBoardStoreTimeSlots) obj2).getStoreId(), selectedStore.getId())) {
                            break;
                        }
                    }
                    SaleOnBoardStoreTimeSlots saleOnBoardStoreTimeSlots = (SaleOnBoardStoreTimeSlots) obj2;
                    if (saleOnBoardStoreTimeSlots == null || (emptyList = saleOnBoardStoreTimeSlots.getTimeSlots()) == null) {
                        emptyList = CollectionsKt.emptyList();
                    }
                } while (!mutableStateFlow.compareAndSet(value, SaleOnBoardFoodListViewModel.ViewState.copy$default(viewState, false, false, null, emptyList, 7, null)));
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SaleOnBoardFoodListViewModel$setupTimeSlotListener$1(SaleOnBoardFoodListViewModel saleOnBoardFoodListViewModel, Continuation<? super SaleOnBoardFoodListViewModel$setupTimeSlotListener$1> continuation) {
        super(2, continuation);
        this.this$0 = saleOnBoardFoodListViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SaleOnBoardFoodListViewModel$setupTimeSlotListener$1(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        ISaleOnBoardCheckoutManager iSaleOnBoardCheckoutManager;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = this.label;
        if (i5 == 0) {
            ResultKt.throwOnFailure(obj);
            iSaleOnBoardCheckoutManager = this.this$0.saleOnBoardCheckoutManager;
            StateFlow<SaleOnBoardCheckoutManager.SaleOnBoardCheckoutState> saleOnBoardCheckoutState = iSaleOnBoardCheckoutManager.getSaleOnBoardCheckoutState();
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, null);
            this.label = 1;
            if (FlowKt.collectLatest(saleOnBoardCheckoutState, anonymousClass1, this) == coroutine_suspended) {
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
        return ((SaleOnBoardFoodListViewModel$setupTimeSlotListener$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
