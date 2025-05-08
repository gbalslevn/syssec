package dk.molslinjen.domain.managers.checkout;

import dk.molslinjen.api.helpers.ApiResult;
import dk.molslinjen.api.services.booking.IBookingService;
import dk.molslinjen.api.services.config.response.SiteDTO;
import dk.molslinjen.api.shared.response.CurrencyTypeDTO;
import dk.molslinjen.domain.extensions.ApiResultExtensionsKt;
import dk.molslinjen.domain.managers.ManagerResult;
import dk.molslinjen.domain.managers.splitTest.ISplitTestManager;
import dk.molslinjen.domain.model.booking.DepartureDirection;
import dk.molslinjen.domain.model.booking.product.Product;
import dk.molslinjen.domain.model.config.Site;
import dk.molslinjen.domain.model.shared.CurrencyType;
import dk.molslinjen.domain.providers.IStringsProvider;
import java.util.ArrayList;
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

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001'B!\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJb\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00132\b\u0010\u0018\u001a\u0004\u0018\u00010\u00132\b\u0010\u0019\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0096@¢\u0006\u0002\u0010 J \u0010!\u001a\u00020\u00112\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u00162\u0006\u0010%\u001a\u00020&H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006("}, d2 = {"Ldk/molslinjen/domain/managers/checkout/SummaryAddonHelper;", "Ldk/molslinjen/domain/managers/checkout/ISummaryAddonHelper;", "bookingService", "Ldk/molslinjen/api/services/booking/IBookingService;", "splitTestManager", "Ldk/molslinjen/domain/managers/splitTest/ISplitTestManager;", "stringProvider", "Ldk/molslinjen/domain/providers/IStringsProvider;", "<init>", "(Ldk/molslinjen/api/services/booking/IBookingService;Ldk/molslinjen/domain/managers/splitTest/ISplitTestManager;Ldk/molslinjen/domain/providers/IStringsProvider;)V", "summaryAddonState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Ldk/molslinjen/domain/managers/checkout/SummaryAddonHelper$SummaryAddonState;", "getSummaryAddonState", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "loadSummaryProducts", "Ldk/molslinjen/domain/managers/ManagerResult;", BuildConfig.FLAVOR, "outboundDepartureId", BuildConfig.FLAVOR, "outboundCarId", "outboundPassengerCount", BuildConfig.FLAVOR, "returnDepartureId", "returnCarId", "returnPassengerCount", "isEditingBooking", BuildConfig.FLAVOR, "site", "Ldk/molslinjen/domain/model/config/Site;", "currency", "Ldk/molslinjen/domain/model/shared/CurrencyType;", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/Integer;ZLdk/molslinjen/domain/model/config/Site;Ldk/molslinjen/domain/model/shared/CurrencyType;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateProductQuantity", "product", "Ldk/molslinjen/domain/model/booking/product/Product;", "quantity", "direction", "Ldk/molslinjen/domain/model/booking/DepartureDirection;", "SummaryAddonState", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SummaryAddonHelper implements ISummaryAddonHelper {
    private final IBookingService bookingService;
    private final ISplitTestManager splitTestManager;
    private final IStringsProvider stringProvider;
    private final MutableStateFlow<SummaryAddonState> summaryAddonState;

    /* JADX WARN: Multi-variable type inference failed */
    public SummaryAddonHelper(IBookingService bookingService, ISplitTestManager splitTestManager, IStringsProvider stringProvider) {
        Intrinsics.checkNotNullParameter(bookingService, "bookingService");
        Intrinsics.checkNotNullParameter(splitTestManager, "splitTestManager");
        Intrinsics.checkNotNullParameter(stringProvider, "stringProvider");
        this.bookingService = bookingService;
        this.splitTestManager = splitTestManager;
        this.stringProvider = stringProvider;
        this.summaryAddonState = StateFlowKt.MutableStateFlow(new SummaryAddonState(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0));
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x00a2 A[PHI: r1
      0x00a2: PHI (r1v11 java.lang.Object) = (r1v10 java.lang.Object), (r1v1 java.lang.Object) binds: [B:18:0x009f, B:11:0x002f] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00a1 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0096 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0029  */
    @Override // dk.molslinjen.domain.managers.checkout.ISummaryAddonHelper
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object loadSummaryProducts(String str, String str2, int i5, String str3, String str4, Integer num, boolean z5, Site site, CurrencyType currencyType, Continuation<? super ManagerResult<Unit>> continuation) {
        SummaryAddonHelper$loadSummaryProducts$1 summaryAddonHelper$loadSummaryProducts$1;
        Object obj;
        Object coroutine_suspended;
        int i6;
        int i7;
        Object summaryProducts;
        SummaryAddonHelper summaryAddonHelper;
        if (continuation instanceof SummaryAddonHelper$loadSummaryProducts$1) {
            summaryAddonHelper$loadSummaryProducts$1 = (SummaryAddonHelper$loadSummaryProducts$1) continuation;
            int i8 = summaryAddonHelper$loadSummaryProducts$1.label;
            if ((i8 & Integer.MIN_VALUE) != 0) {
                summaryAddonHelper$loadSummaryProducts$1.label = i8 - Integer.MIN_VALUE;
                obj = summaryAddonHelper$loadSummaryProducts$1.result;
                coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i6 = summaryAddonHelper$loadSummaryProducts$1.label;
                if (i6 != 0) {
                    ResultKt.throwOnFailure(obj);
                    if (this.splitTestManager.getMoveSummaryAddons()) {
                        return new ManagerResult.Success(Unit.INSTANCE);
                    }
                    IBookingService iBookingService = this.bookingService;
                    SiteDTO dto = site.toDTO();
                    CurrencyTypeDTO dto2 = currencyType.toDTO();
                    summaryAddonHelper$loadSummaryProducts$1.L$0 = this;
                    summaryAddonHelper$loadSummaryProducts$1.label = 1;
                    i7 = 2;
                    summaryProducts = iBookingService.getSummaryProducts(str, str2, i5, str3, str4, num, z5, dto, dto2, summaryAddonHelper$loadSummaryProducts$1);
                    if (summaryProducts == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    summaryAddonHelper = this;
                } else {
                    if (i6 != 1) {
                        if (i6 != 2) {
                            if (i6 == 3) {
                                ResultKt.throwOnFailure(obj);
                            }
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                        summaryAddonHelper$loadSummaryProducts$1.label = 3;
                        obj = ApiResultExtensionsKt.toUnitManagerResult((ApiResult) obj, summaryAddonHelper$loadSummaryProducts$1);
                        return obj == coroutine_suspended ? coroutine_suspended : obj;
                    }
                    SummaryAddonHelper summaryAddonHelper2 = (SummaryAddonHelper) summaryAddonHelper$loadSummaryProducts$1.L$0;
                    ResultKt.throwOnFailure(obj);
                    summaryAddonHelper = summaryAddonHelper2;
                    summaryProducts = obj;
                    i7 = 2;
                }
                SummaryAddonHelper$loadSummaryProducts$2 summaryAddonHelper$loadSummaryProducts$2 = new SummaryAddonHelper$loadSummaryProducts$2(summaryAddonHelper, null);
                summaryAddonHelper$loadSummaryProducts$1.L$0 = null;
                summaryAddonHelper$loadSummaryProducts$1.label = i7;
                obj = dk.molslinjen.api.extensions.ApiResultExtensionsKt.mapOnSuccess((ApiResult) summaryProducts, summaryAddonHelper$loadSummaryProducts$2, summaryAddonHelper$loadSummaryProducts$1);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                summaryAddonHelper$loadSummaryProducts$1.label = 3;
                obj = ApiResultExtensionsKt.toUnitManagerResult((ApiResult) obj, summaryAddonHelper$loadSummaryProducts$1);
                if (obj == coroutine_suspended) {
                }
            }
        }
        summaryAddonHelper$loadSummaryProducts$1 = new SummaryAddonHelper$loadSummaryProducts$1(this, continuation);
        obj = summaryAddonHelper$loadSummaryProducts$1.result;
        coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i6 = summaryAddonHelper$loadSummaryProducts$1.label;
        if (i6 != 0) {
        }
        SummaryAddonHelper$loadSummaryProducts$2 summaryAddonHelper$loadSummaryProducts$22 = new SummaryAddonHelper$loadSummaryProducts$2(summaryAddonHelper, null);
        summaryAddonHelper$loadSummaryProducts$1.L$0 = null;
        summaryAddonHelper$loadSummaryProducts$1.label = i7;
        obj = dk.molslinjen.api.extensions.ApiResultExtensionsKt.mapOnSuccess((ApiResult) summaryProducts, summaryAddonHelper$loadSummaryProducts$22, summaryAddonHelper$loadSummaryProducts$1);
        if (obj == coroutine_suspended) {
        }
        summaryAddonHelper$loadSummaryProducts$1.label = 3;
        obj = ApiResultExtensionsKt.toUnitManagerResult((ApiResult) obj, summaryAddonHelper$loadSummaryProducts$1);
        if (obj == coroutine_suspended) {
        }
    }

    @Override // dk.molslinjen.domain.managers.checkout.ISummaryAddonHelper
    public void updateProductQuantity(Product product, int quantity, DepartureDirection direction) {
        SummaryAddonState value;
        SummaryAddonState summaryAddonState;
        ArrayList arrayList;
        Intrinsics.checkNotNullParameter(product, "product");
        Intrinsics.checkNotNullParameter(direction, "direction");
        MutableStateFlow<SummaryAddonState> summaryAddonState2 = getSummaryAddonState();
        do {
            value = summaryAddonState2.getValue();
            summaryAddonState = value;
            List<Product> outboundProducts = direction == DepartureDirection.Outbound ? summaryAddonState.getOutboundProducts() : summaryAddonState.getReturnProducts();
            arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(outboundProducts, 10));
            for (Product product2 : outboundProducts) {
                if (Intrinsics.areEqual(product2.getId(), product.getId())) {
                    product2 = product.copyQuantity(quantity);
                }
                arrayList.add(product2);
            }
        } while (!summaryAddonState2.compareAndSet(value, direction == DepartureDirection.Outbound ? SummaryAddonState.copy$default(summaryAddonState, arrayList, null, 2, null) : SummaryAddonState.copy$default(summaryAddonState, null, arrayList, 1, null)));
    }

    @Override // dk.molslinjen.domain.managers.checkout.ISummaryAddonHelper
    public MutableStateFlow<SummaryAddonState> getSummaryAddonState() {
        return this.summaryAddonState;
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0006\u0010\u0007J0\u0010\b\u001a\u00020\u00002\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001d\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0014\u001a\u0004\b\u0017\u0010\u0016¨\u0006\u0018"}, d2 = {"Ldk/molslinjen/domain/managers/checkout/SummaryAddonHelper$SummaryAddonState;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "Ldk/molslinjen/domain/model/booking/product/Product;", "outboundProducts", "returnProducts", "<init>", "(Ljava/util/List;Ljava/util/List;)V", "copy", "(Ljava/util/List;Ljava/util/List;)Ldk/molslinjen/domain/managers/checkout/SummaryAddonHelper$SummaryAddonState;", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", BuildConfig.FLAVOR, "hashCode", "()I", "other", BuildConfig.FLAVOR, "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", "getOutboundProducts", "()Ljava/util/List;", "getReturnProducts", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final /* data */ class SummaryAddonState {
        private final List<Product> outboundProducts;
        private final List<Product> returnProducts;

        /* JADX WARN: Multi-variable type inference failed */
        public SummaryAddonState(List<? extends Product> outboundProducts, List<? extends Product> returnProducts) {
            Intrinsics.checkNotNullParameter(outboundProducts, "outboundProducts");
            Intrinsics.checkNotNullParameter(returnProducts, "returnProducts");
            this.outboundProducts = outboundProducts;
            this.returnProducts = returnProducts;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ SummaryAddonState copy$default(SummaryAddonState summaryAddonState, List list, List list2, int i5, Object obj) {
            if ((i5 & 1) != 0) {
                list = summaryAddonState.outboundProducts;
            }
            if ((i5 & 2) != 0) {
                list2 = summaryAddonState.returnProducts;
            }
            return summaryAddonState.copy(list, list2);
        }

        public final SummaryAddonState copy(List<? extends Product> outboundProducts, List<? extends Product> returnProducts) {
            Intrinsics.checkNotNullParameter(outboundProducts, "outboundProducts");
            Intrinsics.checkNotNullParameter(returnProducts, "returnProducts");
            return new SummaryAddonState(outboundProducts, returnProducts);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SummaryAddonState)) {
                return false;
            }
            SummaryAddonState summaryAddonState = (SummaryAddonState) other;
            return Intrinsics.areEqual(this.outboundProducts, summaryAddonState.outboundProducts) && Intrinsics.areEqual(this.returnProducts, summaryAddonState.returnProducts);
        }

        public final List<Product> getOutboundProducts() {
            return this.outboundProducts;
        }

        public final List<Product> getReturnProducts() {
            return this.returnProducts;
        }

        public int hashCode() {
            return (this.outboundProducts.hashCode() * 31) + this.returnProducts.hashCode();
        }

        public String toString() {
            return "SummaryAddonState(outboundProducts=" + this.outboundProducts + ", returnProducts=" + this.returnProducts + ")";
        }

        public /* synthetic */ SummaryAddonState(List list, List list2, int i5, DefaultConstructorMarker defaultConstructorMarker) {
            this((i5 & 1) != 0 ? CollectionsKt.emptyList() : list, (i5 & 2) != 0 ? CollectionsKt.emptyList() : list2);
        }
    }
}
