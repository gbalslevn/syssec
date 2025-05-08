package dk.molslinjen.domain.managers.checkout;

import dk.molslinjen.domain.managers.ManagerResult;
import dk.molslinjen.domain.managers.checkout.AddonHelper;
import dk.molslinjen.domain.model.booking.DepartureDirection;
import dk.molslinjen.domain.model.booking.TicketCategoryType;
import dk.molslinjen.domain.model.booking.product.Product;
import dk.molslinjen.domain.model.config.Site;
import dk.molslinjen.domain.model.shared.CurrencyType;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.StateFlow;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001Jd\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H¦@¢\u0006\u0002\u0010\u0019J\u0018\u0010\u001a\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0010H&J\u0018\u0010\u001e\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0010H&R\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u001f"}, d2 = {"Ldk/molslinjen/domain/managers/checkout/IAddonHelper;", BuildConfig.FLAVOR, "addonState", "Lkotlinx/coroutines/flow/StateFlow;", "Ldk/molslinjen/domain/managers/checkout/AddonHelper$AddonState;", "getAddonState", "()Lkotlinx/coroutines/flow/StateFlow;", "loadProducts", "Ldk/molslinjen/domain/managers/ManagerResult;", BuildConfig.FLAVOR, "carId", BuildConfig.FLAVOR, "departureId", "departureDirection", "Ldk/molslinjen/domain/model/booking/DepartureDirection;", "passengerCount", BuildConfig.FLAVOR, "site", "Ldk/molslinjen/domain/model/config/Site;", "reservationNumber", "editPhoneNumber", "currency", "Ldk/molslinjen/domain/model/shared/CurrencyType;", "ticketType", "Ldk/molslinjen/domain/model/booking/TicketCategoryType;", "(Ljava/lang/String;Ljava/lang/String;Ldk/molslinjen/domain/model/booking/DepartureDirection;ILdk/molslinjen/domain/model/config/Site;Ljava/lang/String;Ljava/lang/String;Ldk/molslinjen/domain/model/shared/CurrencyType;Ldk/molslinjen/domain/model/booking/TicketCategoryType;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateProductQuantity", "product", "Ldk/molslinjen/domain/model/booking/product/Product;", "quantity", "updateFoodQuantity", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface IAddonHelper {
    StateFlow<AddonHelper.AddonState> getAddonState();

    Object loadProducts(String str, String str2, DepartureDirection departureDirection, int i5, Site site, String str3, String str4, CurrencyType currencyType, TicketCategoryType ticketCategoryType, Continuation<? super ManagerResult<Unit>> continuation);

    void updateFoodQuantity(Product product, int quantity);

    void updateProductQuantity(Product product, int quantity);
}
