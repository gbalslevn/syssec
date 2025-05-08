package dk.molslinjen.ui.views.screens.booking.departures.selectTransportationProducts;

import dk.molslinjen.core.snackbar.ISnackbarService;
import dk.molslinjen.domain.extensions.ManagerResultExtensionsKt;
import dk.molslinjen.domain.managers.ManagerResult;
import dk.molslinjen.domain.managers.checkout.IReturnManager;
import dk.molslinjen.domain.managers.route.IRouteManager;
import dk.molslinjen.domain.managers.route.RouteSelectedState;
import dk.molslinjen.domain.managers.route.RouteState;
import dk.molslinjen.domain.model.booking.BookingType;
import dk.molslinjen.domain.model.booking.TransportProducts;
import dk.molslinjen.domain.model.booking.product.Product;
import dk.molslinjen.ui.views.screens.booking.departures.selectTransportationProducts.TransportProductSelectorViewModel;
import java.util.ArrayList;
import java.util.Collection;
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
import kotlinx.coroutines.flow.MutableStateFlow;
import org.conscrypt.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.ui.views.screens.booking.departures.selectTransportationProducts.TransportProductSelectorViewModel$load$1", f = "TransportProductSelectorViewModel.kt", l = {39, 41}, m = "invokeSuspend")
/* loaded from: classes2.dex */
public final class TransportProductSelectorViewModel$load$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ TransportProductSelectorViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TransportProductSelectorViewModel$load$1(TransportProductSelectorViewModel transportProductSelectorViewModel, Continuation<? super TransportProductSelectorViewModel$load$1> continuation) {
        super(2, continuation);
        this.this$0 = transportProductSelectorViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new TransportProductSelectorViewModel$load$1(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IRouteManager iRouteManager;
        IRouteManager iRouteManager2;
        IRouteManager iRouteManager3;
        List emptyList;
        List emptyList2;
        Object obj2;
        MutableStateFlow mutableStateFlow;
        Object value;
        IRouteManager iRouteManager4;
        BookingType value2;
        boolean z5;
        IReturnManager iReturnManager;
        MutableStateFlow mutableStateFlow2;
        Object value3;
        MutableStateFlow mutableStateFlow3;
        Object value4;
        Object obj3;
        TransportProducts transportProducts;
        ISnackbarService iSnackbarService;
        ISnackbarService iSnackbarService2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = this.label;
        if (i5 != 0) {
            if (i5 == 1) {
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            }
            if (i5 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return Unit.INSTANCE;
        }
        ResultKt.throwOnFailure(obj);
        iRouteManager = this.this$0.routeManager;
        RouteState value5 = iRouteManager.getRouteState().getValue();
        if (value5 == null) {
            iSnackbarService2 = this.this$0.snackbarService;
            this.label = 1;
            if (iSnackbarService2.publishGenericError(this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            return Unit.INSTANCE;
        }
        iRouteManager2 = this.this$0.routeManager;
        RouteSelectedState value6 = iRouteManager2.getOutboundSelectedState().getValue();
        if (value6 == null) {
            iSnackbarService = this.this$0.snackbarService;
            this.label = 2;
            if (iSnackbarService.publishGenericError(this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            return Unit.INSTANCE;
        }
        iRouteManager3 = this.this$0.routeManager;
        RouteSelectedState value7 = iRouteManager3.getReturnSelectedState().getValue();
        ManagerResult<TransportProducts> transportProducts2 = value5.getTransportProducts();
        List<Product> products = (transportProducts2 == null || (transportProducts = (TransportProducts) ManagerResultExtensionsKt.toData(transportProducts2)) == null) ? null : transportProducts.getProducts();
        if (products != null) {
            List<Product> list = products;
            emptyList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            for (Product product : list) {
                Iterator<T> it = value6.getSelectedTransportProducts().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        obj3 = null;
                        break;
                    }
                    obj3 = it.next();
                    if (Intrinsics.areEqual(((Product) obj3).getId(), product.getId())) {
                        break;
                    }
                }
                Product product2 = (Product) obj3;
                emptyList.add(product.copyQuantity(product2 != null ? product2.getQuantity() : 0));
            }
        } else {
            emptyList = CollectionsKt.emptyList();
        }
        if (value7 == null) {
            emptyList2 = CollectionsKt.emptyList();
        } else if (products != null) {
            List<Product> list2 = products;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
            for (Product product3 : list2) {
                Iterator<T> it2 = value7.getSelectedTransportProducts().iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        obj2 = null;
                        break;
                    }
                    obj2 = it2.next();
                    if (Intrinsics.areEqual(((Product) obj2).getId(), product3.getId())) {
                        break;
                    }
                }
                Product product4 = (Product) obj2;
                arrayList.add(product3.copyQuantity(product4 != null ? product4.getQuantity() : 0));
            }
            emptyList2 = arrayList;
        } else {
            emptyList2 = CollectionsKt.emptyList();
        }
        boolean areEqual = Intrinsics.areEqual(emptyList, emptyList2);
        mutableStateFlow = this.this$0._viewState;
        TransportProductSelectorViewModel transportProductSelectorViewModel = this.this$0;
        do {
            value = mutableStateFlow.getValue();
            iRouteManager4 = transportProductSelectorViewModel.routeManager;
            value2 = iRouteManager4.getBookingTypeState().getValue();
            List list3 = emptyList;
            if (!(list3 instanceof Collection) || !list3.isEmpty()) {
                Iterator it3 = list3.iterator();
                while (it3.hasNext()) {
                    if (((Product) it3.next()).getQuantity() > 0) {
                        break;
                    }
                }
            }
            List list4 = emptyList2;
            if (!(list4 instanceof Collection) || !list4.isEmpty()) {
                Iterator it4 = list4.iterator();
                while (it4.hasNext()) {
                    if (((Product) it4.next()).getQuantity() > 0) {
                        z5 = true;
                    }
                }
            }
            z5 = false;
            iReturnManager = transportProductSelectorViewModel.returnManager;
        } while (!mutableStateFlow.compareAndSet(value, new TransportProductSelectorViewModel.ViewState(value2, areEqual, z5, iReturnManager.getReturnState().getValue().getIsAddingReturnFromBookingSummary())));
        mutableStateFlow2 = this.this$0._outboundProductsState;
        do {
            value3 = mutableStateFlow2.getValue();
        } while (!mutableStateFlow2.compareAndSet(value3, new TransportProductSelectorViewModel.TransportProductsState(emptyList)));
        mutableStateFlow3 = this.this$0._returnProductsState;
        do {
            value4 = mutableStateFlow3.getValue();
        } while (!mutableStateFlow3.compareAndSet(value4, new TransportProductSelectorViewModel.TransportProductsState(emptyList2)));
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((TransportProductSelectorViewModel$load$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
