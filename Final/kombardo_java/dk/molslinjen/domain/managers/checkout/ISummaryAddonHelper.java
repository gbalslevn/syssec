package dk.molslinjen.domain.managers.checkout;

import dk.molslinjen.domain.managers.ManagerResult;
import dk.molslinjen.domain.managers.checkout.SummaryAddonHelper;
import dk.molslinjen.domain.model.booking.DepartureDirection;
import dk.molslinjen.domain.model.booking.product.Product;
import dk.molslinjen.domain.model.config.Site;
import dk.molslinjen.domain.model.shared.CurrencyType;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.StateFlow;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001Jb\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H¦@¢\u0006\u0002\u0010\u0018J \u0010\u0019\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\u001eH&R\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u001f"}, d2 = {"Ldk/molslinjen/domain/managers/checkout/ISummaryAddonHelper;", BuildConfig.FLAVOR, "summaryAddonState", "Lkotlinx/coroutines/flow/StateFlow;", "Ldk/molslinjen/domain/managers/checkout/SummaryAddonHelper$SummaryAddonState;", "getSummaryAddonState", "()Lkotlinx/coroutines/flow/StateFlow;", "loadSummaryProducts", "Ldk/molslinjen/domain/managers/ManagerResult;", BuildConfig.FLAVOR, "outboundDepartureId", BuildConfig.FLAVOR, "outboundCarId", "outboundPassengerCount", BuildConfig.FLAVOR, "returnDepartureId", "returnCarId", "returnPassengerCount", "isEditingBooking", BuildConfig.FLAVOR, "site", "Ldk/molslinjen/domain/model/config/Site;", "currency", "Ldk/molslinjen/domain/model/shared/CurrencyType;", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/Integer;ZLdk/molslinjen/domain/model/config/Site;Ldk/molslinjen/domain/model/shared/CurrencyType;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateProductQuantity", "product", "Ldk/molslinjen/domain/model/booking/product/Product;", "quantity", "direction", "Ldk/molslinjen/domain/model/booking/DepartureDirection;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface ISummaryAddonHelper {
    StateFlow<SummaryAddonHelper.SummaryAddonState> getSummaryAddonState();

    Object loadSummaryProducts(String str, String str2, int i5, String str3, String str4, Integer num, boolean z5, Site site, CurrencyType currencyType, Continuation<? super ManagerResult<Unit>> continuation);

    void updateProductQuantity(Product product, int quantity, DepartureDirection direction);
}
