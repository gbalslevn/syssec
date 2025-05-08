package dk.molslinjen.domain.managers.checkout;

import dk.molslinjen.api.services.booking.response.ProductsResponseDTO;
import dk.molslinjen.domain.extensions.domain.SplitTestExtensionsKt;
import dk.molslinjen.domain.managers.checkout.AddonHelper;
import dk.molslinjen.domain.managers.splitTest.ISplitTestManager;
import dk.molslinjen.domain.model.booking.ProductType;
import dk.molslinjen.domain.model.booking.ProductsResponse;
import dk.molslinjen.domain.model.booking.TicketCategoryType;
import dk.molslinjen.domain.model.booking.product.Product;
import dk.molslinjen.domain.model.booking.product.ProductGroup;
import dk.molslinjen.domain.model.booking.product.UnavailableProduct;
import dk.molslinjen.domain.providers.IStringsProvider;
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
import kotlinx.coroutines.flow.MutableStateFlow;
import org.conscrypt.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "dto", "Ldk/molslinjen/api/services/booking/response/ProductsResponseDTO;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.domain.managers.checkout.AddonHelper$loadProducts$2", f = "AddonHelper.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes2.dex */
public final class AddonHelper$loadProducts$2 extends SuspendLambda implements Function2<ProductsResponseDTO, Continuation<? super Unit>, Object> {
    final /* synthetic */ TicketCategoryType $ticketType;
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ AddonHelper this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AddonHelper$loadProducts$2(AddonHelper addonHelper, TicketCategoryType ticketCategoryType, Continuation<? super AddonHelper$loadProducts$2> continuation) {
        super(2, continuation);
        this.this$0 = addonHelper;
        this.$ticketType = ticketCategoryType;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        AddonHelper$loadProducts$2 addonHelper$loadProducts$2 = new AddonHelper$loadProducts$2(this.this$0, this.$ticketType, continuation);
        addonHelper$loadProducts$2.L$0 = obj;
        return addonHelper$loadProducts$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(ProductsResponseDTO productsResponseDTO, Continuation<? super Unit> continuation) {
        return ((AddonHelper$loadProducts$2) create(productsResponseDTO, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        ISplitTestManager iSplitTestManager;
        IStringsProvider iStringsProvider;
        AddonHelper.AddonState value;
        AddonHelper.AddonState addonState;
        ArrayList arrayList;
        ProductGroup productGroup;
        List<ProductGroup> minus;
        ArrayList arrayList2;
        ArrayList arrayList3;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        ProductsResponse productsResponse = new ProductsResponse((ProductsResponseDTO) this.L$0);
        iSplitTestManager = this.this$0.splitTestManager;
        iStringsProvider = this.this$0.stringProvider;
        ProductsResponse applySplitTestChanges = SplitTestExtensionsKt.applySplitTestChanges(productsResponse, iSplitTestManager, iStringsProvider);
        MutableStateFlow<AddonHelper.AddonState> addonState2 = this.this$0.getAddonState();
        TicketCategoryType ticketCategoryType = this.$ticketType;
        do {
            value = addonState2.getValue();
            addonState = value;
            List filterNotNull = CollectionsKt.filterNotNull(CollectionsKt.plus((Collection) CollectionsKt.listOf(applySplitTestChanges.getRecommendedProductsGroup()), (Iterable) applySplitTestChanges.getProductGroups()));
            ArrayList arrayList4 = new ArrayList();
            for (Object obj2 : filterNotNull) {
                if (!((ProductGroup) obj2).getProducts().isEmpty()) {
                    arrayList4.add(obj2);
                }
            }
            arrayList = new ArrayList();
            for (Object obj3 : arrayList4) {
                List<Product> products = ((ProductGroup) obj3).getProducts();
                if (!(products instanceof Collection) || !products.isEmpty()) {
                    Iterator<T> it = products.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        if (((Product) it.next()).getProductType() == ProductType.Catering) {
                            arrayList.add(obj3);
                            break;
                        }
                    }
                }
            }
            productGroup = null;
            if (ticketCategoryType != TicketCategoryType.BlueClass) {
                Iterator it2 = filterNotNull.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    Object next = it2.next();
                    List<Product> products2 = ((ProductGroup) next).getProducts();
                    if (!(products2 instanceof Collection) || !products2.isEmpty()) {
                        Iterator<T> it3 = products2.iterator();
                        while (it3.hasNext()) {
                            if (((Product) it3.next()).getProductType() == ProductType.SelectSeating) {
                                productGroup = next;
                                break;
                            }
                        }
                    }
                }
                productGroup = productGroup;
            }
            minus = CollectionsKt.minus((Iterable) arrayList4, (Iterable) CollectionsKt.toSet(arrayList));
            if (productGroup != null) {
                minus = CollectionsKt.minus(minus, productGroup);
            }
            List<UnavailableProduct> unavailableProducts = applySplitTestChanges.getUnavailableProducts();
            arrayList2 = new ArrayList();
            for (Object obj4 : unavailableProducts) {
                if (((UnavailableProduct) obj4).getProductType() != ProductType.Catering) {
                    arrayList2.add(obj4);
                }
            }
            List<UnavailableProduct> unavailableProducts2 = applySplitTestChanges.getUnavailableProducts();
            arrayList3 = new ArrayList();
            for (Object obj5 : unavailableProducts2) {
                if (((UnavailableProduct) obj5).getProductType() == ProductType.Catering) {
                    arrayList3.add(obj5);
                }
            }
        } while (!addonState2.compareAndSet(value, addonState.copy(minus, productGroup, arrayList, arrayList2, arrayList3)));
        return Unit.INSTANCE;
    }
}
