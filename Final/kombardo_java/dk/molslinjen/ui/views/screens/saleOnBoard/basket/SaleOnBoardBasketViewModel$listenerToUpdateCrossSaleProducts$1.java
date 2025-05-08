package dk.molslinjen.ui.views.screens.saleOnBoard.basket;

import dk.molslinjen.domain.managers.saleOnBoard.SaleOnBoardCheckoutManager;
import dk.molslinjen.domain.model.saleOnBoard.SaleOnBoardCrossSaleProduct;
import dk.molslinjen.domain.model.saleOnBoard.SaleOnBoardCrossSales;
import dk.molslinjen.domain.model.saleOnBoard.SaleOnBoardLineItem;
import dk.molslinjen.domain.model.saleOnBoard.SaleOnBoardProduct;
import dk.molslinjen.ui.views.screens.saleOnBoard.basket.SaleOnBoardBasketViewModel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
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
import kotlin.jvm.internal.Ref$IntRef;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import org.conscrypt.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.ui.views.screens.saleOnBoard.basket.SaleOnBoardBasketViewModel$listenerToUpdateCrossSaleProducts$1", f = "SaleOnBoardBasketViewModel.kt", l = {66}, m = "invokeSuspend")
/* loaded from: classes2.dex */
public final class SaleOnBoardBasketViewModel$listenerToUpdateCrossSaleProducts$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ SaleOnBoardBasketViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "saleOnBoardState", "Ldk/molslinjen/domain/managers/saleOnBoard/SaleOnBoardCheckoutManager$SaleOnBoardCheckoutState;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "dk.molslinjen.ui.views.screens.saleOnBoard.basket.SaleOnBoardBasketViewModel$listenerToUpdateCrossSaleProducts$1$1", f = "SaleOnBoardBasketViewModel.kt", l = {}, m = "invokeSuspend")
    /* renamed from: dk.molslinjen.ui.views.screens.saleOnBoard.basket.SaleOnBoardBasketViewModel$listenerToUpdateCrossSaleProducts$1$1, reason: invalid class name */
    /* loaded from: classes2.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<SaleOnBoardCheckoutManager.SaleOnBoardCheckoutState, Continuation<? super Unit>, Object> {
        final /* synthetic */ Ref$IntRef $lastBasketLineItemsCount;
        /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ SaleOnBoardBasketViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Ref$IntRef ref$IntRef, SaleOnBoardBasketViewModel saleOnBoardBasketViewModel, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$lastBasketLineItemsCount = ref$IntRef;
            this.this$0 = saleOnBoardBasketViewModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$lastBasketLineItemsCount, this.this$0, continuation);
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
            SaleOnBoardProduct product;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            SaleOnBoardCheckoutManager.SaleOnBoardCheckoutState saleOnBoardCheckoutState = (SaleOnBoardCheckoutManager.SaleOnBoardCheckoutState) this.L$0;
            if (this.$lastBasketLineItemsCount.element == saleOnBoardCheckoutState.getBasketLineItems().size()) {
                return Unit.INSTANCE;
            }
            List<SaleOnBoardLineItem> basketLineItems = saleOnBoardCheckoutState.getBasketLineItems();
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = basketLineItems.iterator();
            while (it.hasNext()) {
                SaleOnBoardCrossSales crossSale = ((SaleOnBoardLineItem) it.next()).getProduct().getCrossSale();
                if (crossSale != null) {
                    arrayList.add(crossSale);
                }
            }
            ArrayList arrayList2 = new ArrayList();
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                CollectionsKt.addAll(arrayList2, ((SaleOnBoardCrossSales) it2.next()).getCrossSaleProducts());
            }
            HashSet hashSet = new HashSet();
            ArrayList arrayList3 = new ArrayList();
            for (Object obj2 : arrayList2) {
                if (hashSet.add(((SaleOnBoardCrossSaleProduct) obj2).getProductId())) {
                    arrayList3.add(obj2);
                }
            }
            ArrayList<SaleOnBoardCrossSaleProduct> arrayList4 = new ArrayList();
            for (Object obj3 : arrayList3) {
                SaleOnBoardCrossSaleProduct saleOnBoardCrossSaleProduct = (SaleOnBoardCrossSaleProduct) obj3;
                List<SaleOnBoardLineItem> basketLineItems2 = saleOnBoardCheckoutState.getBasketLineItems();
                boolean z5 = false;
                if (!(basketLineItems2 instanceof Collection) || !basketLineItems2.isEmpty()) {
                    Iterator<T> it3 = basketLineItems2.iterator();
                    while (true) {
                        if (!it3.hasNext()) {
                            break;
                        }
                        if (Intrinsics.areEqual(saleOnBoardCrossSaleProduct.getProductId(), ((SaleOnBoardLineItem) it3.next()).getProduct().getId())) {
                            z5 = true;
                            break;
                        }
                    }
                }
                if (!z5) {
                    arrayList4.add(obj3);
                }
            }
            SaleOnBoardBasketViewModel saleOnBoardBasketViewModel = this.this$0;
            ArrayList arrayList5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList4, 10));
            for (SaleOnBoardCrossSaleProduct saleOnBoardCrossSaleProduct2 : arrayList4) {
                product = saleOnBoardBasketViewModel.getProduct(saleOnBoardCrossSaleProduct2);
                arrayList5.add(SaleOnBoardCrossSaleProduct.copy$default(saleOnBoardCrossSaleProduct2, null, product, null, null, null, 29, null));
            }
            ArrayList arrayList6 = new ArrayList();
            for (Object obj4 : arrayList5) {
                if (((SaleOnBoardCrossSaleProduct) obj4).getProduct() != null) {
                    arrayList6.add(obj4);
                }
            }
            mutableStateFlow = this.this$0._viewState;
            do {
                value = mutableStateFlow.getValue();
            } while (!mutableStateFlow.compareAndSet(value, SaleOnBoardBasketViewModel.ViewState.copy$default((SaleOnBoardBasketViewModel.ViewState) value, false, false, null, null, null, false, null, arrayList6, null, 383, null)));
            this.$lastBasketLineItemsCount.element = saleOnBoardCheckoutState.getBasketLineItems().size();
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SaleOnBoardBasketViewModel$listenerToUpdateCrossSaleProducts$1(SaleOnBoardBasketViewModel saleOnBoardBasketViewModel, Continuation<? super SaleOnBoardBasketViewModel$listenerToUpdateCrossSaleProducts$1> continuation) {
        super(2, continuation);
        this.this$0 = saleOnBoardBasketViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SaleOnBoardBasketViewModel$listenerToUpdateCrossSaleProducts$1(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = this.label;
        if (i5 == 0) {
            ResultKt.throwOnFailure(obj);
            Ref$IntRef ref$IntRef = new Ref$IntRef();
            ref$IntRef.element = -1;
            StateFlow<SaleOnBoardCheckoutManager.SaleOnBoardCheckoutState> saleOnBoardCheckoutState = this.this$0.getSaleOnBoardCheckoutState();
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(ref$IntRef, this.this$0, null);
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
        return ((SaleOnBoardBasketViewModel$listenerToUpdateCrossSaleProducts$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
