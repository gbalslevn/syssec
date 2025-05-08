package dk.molslinjen.domain.managers.checkout;

import dk.molslinjen.api.helpers.ApiResult;
import dk.molslinjen.api.services.booking.IBookingService;
import dk.molslinjen.api.services.booking.request.DirectionDTO;
import dk.molslinjen.api.services.config.response.SiteDTO;
import dk.molslinjen.api.shared.response.CurrencyTypeDTO;
import dk.molslinjen.domain.extensions.ApiResultExtensionsKt;
import dk.molslinjen.domain.managers.ManagerResult;
import dk.molslinjen.domain.managers.splitTest.ISplitTestManager;
import dk.molslinjen.domain.model.booking.DepartureDirection;
import dk.molslinjen.domain.model.booking.TicketCategoryType;
import dk.molslinjen.domain.model.booking.product.Product;
import dk.molslinjen.domain.model.booking.product.ProductGroup;
import dk.molslinjen.domain.model.booking.product.UnavailableProduct;
import dk.molslinjen.domain.model.config.Site;
import dk.molslinjen.domain.model.shared.CurrencyType;
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
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001+B!\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ`\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u00132\b\u0010\u001c\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0096@¢\u0006\u0002\u0010!J\u0018\u0010\"\u001a\u00020\u00112\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u0018H\u0016J\u0018\u0010&\u001a\u00020\u00112\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u0018H\u0016J.\u0010'\u001a\n\u0012\u0004\u0012\u00020)\u0018\u00010(2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020)0(2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u0018H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006,"}, d2 = {"Ldk/molslinjen/domain/managers/checkout/AddonHelper;", "Ldk/molslinjen/domain/managers/checkout/IAddonHelper;", "bookingService", "Ldk/molslinjen/api/services/booking/IBookingService;", "splitTestManager", "Ldk/molslinjen/domain/managers/splitTest/ISplitTestManager;", "stringProvider", "Ldk/molslinjen/domain/providers/IStringsProvider;", "<init>", "(Ldk/molslinjen/api/services/booking/IBookingService;Ldk/molslinjen/domain/managers/splitTest/ISplitTestManager;Ldk/molslinjen/domain/providers/IStringsProvider;)V", "addonState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Ldk/molslinjen/domain/managers/checkout/AddonHelper$AddonState;", "getAddonState", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "loadProducts", "Ldk/molslinjen/domain/managers/ManagerResult;", BuildConfig.FLAVOR, "carId", BuildConfig.FLAVOR, "departureId", "departureDirection", "Ldk/molslinjen/domain/model/booking/DepartureDirection;", "passengerCount", BuildConfig.FLAVOR, "site", "Ldk/molslinjen/domain/model/config/Site;", "reservationNumber", "editPhoneNumber", "currency", "Ldk/molslinjen/domain/model/shared/CurrencyType;", "ticketType", "Ldk/molslinjen/domain/model/booking/TicketCategoryType;", "(Ljava/lang/String;Ljava/lang/String;Ldk/molslinjen/domain/model/booking/DepartureDirection;ILdk/molslinjen/domain/model/config/Site;Ljava/lang/String;Ljava/lang/String;Ldk/molslinjen/domain/model/shared/CurrencyType;Ldk/molslinjen/domain/model/booking/TicketCategoryType;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateFoodQuantity", "product", "Ldk/molslinjen/domain/model/booking/product/Product;", "quantity", "updateProductQuantity", "updateProducts", BuildConfig.FLAVOR, "Ldk/molslinjen/domain/model/booking/product/ProductGroup;", "productGroups", "AddonState", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class AddonHelper implements IAddonHelper {
    private final MutableStateFlow<AddonState> addonState;
    private final IBookingService bookingService;
    private final ISplitTestManager splitTestManager;
    private final IStringsProvider stringProvider;

    public AddonHelper(IBookingService bookingService, ISplitTestManager splitTestManager, IStringsProvider stringProvider) {
        Intrinsics.checkNotNullParameter(bookingService, "bookingService");
        Intrinsics.checkNotNullParameter(splitTestManager, "splitTestManager");
        Intrinsics.checkNotNullParameter(stringProvider, "stringProvider");
        this.bookingService = bookingService;
        this.splitTestManager = splitTestManager;
        this.stringProvider = stringProvider;
        this.addonState = StateFlowKt.MutableStateFlow(new AddonState(null, null, null, null, null, 31, null));
    }

    private final List<ProductGroup> updateProducts(List<ProductGroup> productGroups, Product product, int quantity) {
        Object obj;
        List<ProductGroup> list = productGroups;
        Iterator<T> it = list.iterator();
        loop0: while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            List<Product> products = ((ProductGroup) obj).getProducts();
            if (!(products instanceof Collection) || !products.isEmpty()) {
                Iterator<T> it2 = products.iterator();
                while (it2.hasNext()) {
                    if (Intrinsics.areEqual(((Product) it2.next()).getId(), product.getId())) {
                        break loop0;
                    }
                }
            }
        }
        ProductGroup productGroup = (ProductGroup) obj;
        if (productGroup == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        for (ProductGroup productGroup2 : list) {
            if (Intrinsics.areEqual(productGroup2, productGroup)) {
                List<Product> products2 = productGroup.getProducts();
                ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(products2, 10));
                for (Product product2 : products2) {
                    if (Intrinsics.areEqual(product2.getId(), product.getId())) {
                        product2 = product2.copyQuantity(quantity);
                    }
                    arrayList2.add(product2);
                }
                productGroup2 = ProductGroup.copy$default(productGroup, null, null, arrayList2, null, 11, null);
            }
            arrayList.add(productGroup2);
        }
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x00b6 A[PHI: r1
      0x00b6: PHI (r1v9 java.lang.Object) = (r1v8 java.lang.Object), (r1v1 java.lang.Object) binds: [B:18:0x00b3, B:11:0x002f] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00b5 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00a9 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0029  */
    @Override // dk.molslinjen.domain.managers.checkout.IAddonHelper
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object loadProducts(String str, String str2, DepartureDirection departureDirection, int i5, Site site, String str3, String str4, CurrencyType currencyType, TicketCategoryType ticketCategoryType, Continuation<? super ManagerResult<Unit>> continuation) {
        AddonHelper$loadProducts$1 addonHelper$loadProducts$1;
        Object obj;
        Object coroutine_suspended;
        int i6;
        TicketCategoryType ticketCategoryType2;
        int i7;
        Object products;
        AddonHelper addonHelper;
        if (continuation instanceof AddonHelper$loadProducts$1) {
            addonHelper$loadProducts$1 = (AddonHelper$loadProducts$1) continuation;
            int i8 = addonHelper$loadProducts$1.label;
            if ((i8 & Integer.MIN_VALUE) != 0) {
                addonHelper$loadProducts$1.label = i8 - Integer.MIN_VALUE;
                obj = addonHelper$loadProducts$1.result;
                coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i6 = addonHelper$loadProducts$1.label;
                if (i6 != 0) {
                    ResultKt.throwOnFailure(obj);
                    boolean z5 = str3 != null;
                    IBookingService iBookingService = this.bookingService;
                    DirectionDTO dto = departureDirection.toDTO();
                    SiteDTO dto2 = site.toDTO();
                    boolean z6 = z5 || this.splitTestManager.getMoveSummaryAddons();
                    CurrencyTypeDTO dto3 = currencyType.toDTO();
                    addonHelper$loadProducts$1.L$0 = this;
                    ticketCategoryType2 = ticketCategoryType;
                    addonHelper$loadProducts$1.L$1 = ticketCategoryType2;
                    addonHelper$loadProducts$1.label = 1;
                    i7 = 2;
                    products = iBookingService.getProducts(str, str2, dto, i5, dto2, str3, str4, z6, dto3, addonHelper$loadProducts$1);
                    if (products == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    addonHelper = this;
                } else {
                    if (i6 != 1) {
                        if (i6 != 2) {
                            if (i6 == 3) {
                                ResultKt.throwOnFailure(obj);
                            }
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                        addonHelper$loadProducts$1.label = 3;
                        obj = ApiResultExtensionsKt.toUnitManagerResult((ApiResult) obj, addonHelper$loadProducts$1);
                        return obj == coroutine_suspended ? coroutine_suspended : obj;
                    }
                    TicketCategoryType ticketCategoryType3 = (TicketCategoryType) addonHelper$loadProducts$1.L$1;
                    addonHelper = (AddonHelper) addonHelper$loadProducts$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    i7 = 2;
                    products = obj;
                    ticketCategoryType2 = ticketCategoryType3;
                }
                AddonHelper$loadProducts$2 addonHelper$loadProducts$2 = new AddonHelper$loadProducts$2(addonHelper, ticketCategoryType2, null);
                addonHelper$loadProducts$1.L$0 = null;
                addonHelper$loadProducts$1.L$1 = null;
                addonHelper$loadProducts$1.label = i7;
                obj = dk.molslinjen.api.extensions.ApiResultExtensionsKt.mapOnSuccess((ApiResult) products, addonHelper$loadProducts$2, addonHelper$loadProducts$1);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                addonHelper$loadProducts$1.label = 3;
                obj = ApiResultExtensionsKt.toUnitManagerResult((ApiResult) obj, addonHelper$loadProducts$1);
                if (obj == coroutine_suspended) {
                }
            }
        }
        addonHelper$loadProducts$1 = new AddonHelper$loadProducts$1(this, continuation);
        obj = addonHelper$loadProducts$1.result;
        coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i6 = addonHelper$loadProducts$1.label;
        if (i6 != 0) {
        }
        AddonHelper$loadProducts$2 addonHelper$loadProducts$22 = new AddonHelper$loadProducts$2(addonHelper, ticketCategoryType2, null);
        addonHelper$loadProducts$1.L$0 = null;
        addonHelper$loadProducts$1.L$1 = null;
        addonHelper$loadProducts$1.label = i7;
        obj = dk.molslinjen.api.extensions.ApiResultExtensionsKt.mapOnSuccess((ApiResult) products, addonHelper$loadProducts$22, addonHelper$loadProducts$1);
        if (obj == coroutine_suspended) {
        }
        addonHelper$loadProducts$1.label = 3;
        obj = ApiResultExtensionsKt.toUnitManagerResult((ApiResult) obj, addonHelper$loadProducts$1);
        if (obj == coroutine_suspended) {
        }
    }

    @Override // dk.molslinjen.domain.managers.checkout.IAddonHelper
    public void updateFoodQuantity(Product product, int quantity) {
        AddonState value;
        AddonState addonState;
        List<ProductGroup> updateProducts;
        Intrinsics.checkNotNullParameter(product, "product");
        MutableStateFlow<AddonState> addonState2 = getAddonState();
        do {
            value = addonState2.getValue();
            addonState = value;
            List<ProductGroup> food = addonState.getFood();
            if (food == null || (updateProducts = updateProducts(food, product, quantity)) == null) {
                return;
            }
        } while (!addonState2.compareAndSet(value, AddonState.copy$default(addonState, null, null, updateProducts, null, null, 27, null)));
    }

    @Override // dk.molslinjen.domain.managers.checkout.IAddonHelper
    public void updateProductQuantity(Product product, int quantity) {
        AddonState value;
        AddonState addonState;
        List<ProductGroup> productGroups;
        Intrinsics.checkNotNullParameter(product, "product");
        MutableStateFlow<AddonState> addonState2 = getAddonState();
        do {
            value = addonState2.getValue();
            addonState = value;
            productGroups = addonState.getProductGroups();
            if (productGroups == null) {
                return;
            }
        } while (!addonState2.compareAndSet(value, AddonState.copy$default(addonState, updateProducts(productGroups, product, quantity), null, null, null, null, 30, null)));
    }

    @Override // dk.molslinjen.domain.managers.checkout.IAddonHelper
    public MutableStateFlow<AddonState> getAddonState() {
        return this.addonState;
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001BW\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0002\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\u0002¢\u0006\u0004\b\n\u0010\u000bJ`\u0010\f\u001a\u00020\u00002\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00022\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00022\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\u0002HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017R\u001f\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u001f\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0018\u001a\u0004\b\u001e\u0010\u001aR\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00028\u0006¢\u0006\f\n\u0004\b\b\u0010\u0018\u001a\u0004\b\u001f\u0010\u001aR\u001d\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00070\u00028\u0006¢\u0006\f\n\u0004\b\t\u0010\u0018\u001a\u0004\b \u0010\u001a¨\u0006!"}, d2 = {"Ldk/molslinjen/domain/managers/checkout/AddonHelper$AddonState;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "Ldk/molslinjen/domain/model/booking/product/ProductGroup;", "productGroups", "selectSeatingGroup", "food", "Ldk/molslinjen/domain/model/booking/product/UnavailableProduct;", "unavailableProducts", "unavailableFood", "<init>", "(Ljava/util/List;Ldk/molslinjen/domain/model/booking/product/ProductGroup;Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "copy", "(Ljava/util/List;Ldk/molslinjen/domain/model/booking/product/ProductGroup;Ljava/util/List;Ljava/util/List;Ljava/util/List;)Ldk/molslinjen/domain/managers/checkout/AddonHelper$AddonState;", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", BuildConfig.FLAVOR, "hashCode", "()I", "other", BuildConfig.FLAVOR, "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", "getProductGroups", "()Ljava/util/List;", "Ldk/molslinjen/domain/model/booking/product/ProductGroup;", "getSelectSeatingGroup", "()Ldk/molslinjen/domain/model/booking/product/ProductGroup;", "getFood", "getUnavailableProducts", "getUnavailableFood", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final /* data */ class AddonState {
        private final List<ProductGroup> food;
        private final List<ProductGroup> productGroups;
        private final ProductGroup selectSeatingGroup;
        private final List<UnavailableProduct> unavailableFood;
        private final List<UnavailableProduct> unavailableProducts;

        public AddonState(List<ProductGroup> list, ProductGroup productGroup, List<ProductGroup> list2, List<UnavailableProduct> unavailableProducts, List<UnavailableProduct> unavailableFood) {
            Intrinsics.checkNotNullParameter(unavailableProducts, "unavailableProducts");
            Intrinsics.checkNotNullParameter(unavailableFood, "unavailableFood");
            this.productGroups = list;
            this.selectSeatingGroup = productGroup;
            this.food = list2;
            this.unavailableProducts = unavailableProducts;
            this.unavailableFood = unavailableFood;
        }

        public static /* synthetic */ AddonState copy$default(AddonState addonState, List list, ProductGroup productGroup, List list2, List list3, List list4, int i5, Object obj) {
            if ((i5 & 1) != 0) {
                list = addonState.productGroups;
            }
            if ((i5 & 2) != 0) {
                productGroup = addonState.selectSeatingGroup;
            }
            ProductGroup productGroup2 = productGroup;
            if ((i5 & 4) != 0) {
                list2 = addonState.food;
            }
            List list5 = list2;
            if ((i5 & 8) != 0) {
                list3 = addonState.unavailableProducts;
            }
            List list6 = list3;
            if ((i5 & 16) != 0) {
                list4 = addonState.unavailableFood;
            }
            return addonState.copy(list, productGroup2, list5, list6, list4);
        }

        public final AddonState copy(List<ProductGroup> productGroups, ProductGroup selectSeatingGroup, List<ProductGroup> food, List<UnavailableProduct> unavailableProducts, List<UnavailableProduct> unavailableFood) {
            Intrinsics.checkNotNullParameter(unavailableProducts, "unavailableProducts");
            Intrinsics.checkNotNullParameter(unavailableFood, "unavailableFood");
            return new AddonState(productGroups, selectSeatingGroup, food, unavailableProducts, unavailableFood);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof AddonState)) {
                return false;
            }
            AddonState addonState = (AddonState) other;
            return Intrinsics.areEqual(this.productGroups, addonState.productGroups) && Intrinsics.areEqual(this.selectSeatingGroup, addonState.selectSeatingGroup) && Intrinsics.areEqual(this.food, addonState.food) && Intrinsics.areEqual(this.unavailableProducts, addonState.unavailableProducts) && Intrinsics.areEqual(this.unavailableFood, addonState.unavailableFood);
        }

        public final List<ProductGroup> getFood() {
            return this.food;
        }

        public final List<ProductGroup> getProductGroups() {
            return this.productGroups;
        }

        public final ProductGroup getSelectSeatingGroup() {
            return this.selectSeatingGroup;
        }

        public final List<UnavailableProduct> getUnavailableFood() {
            return this.unavailableFood;
        }

        public final List<UnavailableProduct> getUnavailableProducts() {
            return this.unavailableProducts;
        }

        public int hashCode() {
            List<ProductGroup> list = this.productGroups;
            int hashCode = (list == null ? 0 : list.hashCode()) * 31;
            ProductGroup productGroup = this.selectSeatingGroup;
            int hashCode2 = (hashCode + (productGroup == null ? 0 : productGroup.hashCode())) * 31;
            List<ProductGroup> list2 = this.food;
            return ((((hashCode2 + (list2 != null ? list2.hashCode() : 0)) * 31) + this.unavailableProducts.hashCode()) * 31) + this.unavailableFood.hashCode();
        }

        public String toString() {
            return "AddonState(productGroups=" + this.productGroups + ", selectSeatingGroup=" + this.selectSeatingGroup + ", food=" + this.food + ", unavailableProducts=" + this.unavailableProducts + ", unavailableFood=" + this.unavailableFood + ")";
        }

        public /* synthetic */ AddonState(List list, ProductGroup productGroup, List list2, List list3, List list4, int i5, DefaultConstructorMarker defaultConstructorMarker) {
            this((i5 & 1) != 0 ? null : list, (i5 & 2) != 0 ? null : productGroup, (i5 & 4) == 0 ? list2 : null, (i5 & 8) != 0 ? CollectionsKt.emptyList() : list3, (i5 & 16) != 0 ? CollectionsKt.emptyList() : list4);
        }
    }
}
