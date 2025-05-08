package dk.molslinjen.domain.managers.saleOnBoard;

import com.sdk.growthbook.utils.Constants;
import dk.molslinjen.domain.managers.ManagerResult;
import dk.molslinjen.domain.managers.checkout.ICreateBooking;
import dk.molslinjen.domain.managers.saleOnBoard.SaleOnBoardCheckoutManager;
import dk.molslinjen.domain.model.account.CreditCard;
import dk.molslinjen.domain.model.booking.IDepartureInfo;
import dk.molslinjen.domain.model.payment.PaymentType;
import dk.molslinjen.domain.model.saleOnBoard.NotificationType;
import dk.molslinjen.domain.model.saleOnBoard.SaleOnBoardLineItem;
import dk.molslinjen.domain.model.saleOnBoard.SaleOnBoardProduct;
import dk.molslinjen.domain.model.saleOnBoard.SaleOnBoardStore;
import dk.molslinjen.domain.model.saleOnBoard.SaleOnBoardStoreTimeSlots;
import dk.molslinjen.domain.model.saleOnBoard.SaleOnBoardTimeSlot;
import dk.molslinjen.domain.model.shared.PhoneNumber;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.StateFlow;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u001a\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u0007H¦@¢\u0006\u0002\u0010\nJ\u001a\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\b0\u0007H¦@¢\u0006\u0002\u0010\nJ\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u0015H&J\u001a\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u001aH&J\u001a\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH&J\u0010\u0010 \u001a\u00020\u00032\u0006\u0010!\u001a\u00020\"H&J\u0010\u0010#\u001a\u00020\u00032\u0006\u0010$\u001a\u00020\u0015H&J\u0010\u0010%\u001a\u00020\u00032\u0006\u0010&\u001a\u00020\u0015H&J\u0010\u0010'\u001a\u00020\u00032\u0006\u0010(\u001a\u00020)H&J\u0010\u0010*\u001a\u00020\u00032\u0006\u0010+\u001a\u00020,H&J\u0010\u0010-\u001a\u00020\u00032\u0006\u0010.\u001a\u00020\u0015H&R\u0018\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006/"}, d2 = {"Ldk/molslinjen/domain/managers/saleOnBoard/ISaleOnBoardCheckoutManager;", "Ldk/molslinjen/domain/managers/checkout/ICreateBooking;", "setupWithDeparture", BuildConfig.FLAVOR, "departure", "Ldk/molslinjen/domain/model/booking/IDepartureInfo;", "loadShopsAndProducts", "Ldk/molslinjen/domain/managers/ManagerResult;", BuildConfig.FLAVOR, "Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardStore;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saleOnBoardCheckoutState", "Lkotlinx/coroutines/flow/StateFlow;", "Ldk/molslinjen/domain/managers/saleOnBoard/SaleOnBoardCheckoutManager$SaleOnBoardCheckoutState;", "getSaleOnBoardCheckoutState", "()Lkotlinx/coroutines/flow/StateFlow;", "loadTimeSlots", "Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardStoreTimeSlots;", "getProduct", "Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardProduct;", Constants.ID_ATTRIBUTE_KEY, BuildConfig.FLAVOR, "addToBasket", "basketLineItem", "Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardLineItem;", "updateExisting", BuildConfig.FLAVOR, "selectPaymentMethod", "paymentType", "Ldk/molslinjen/domain/model/payment/PaymentType;", "creditCard", "Ldk/molslinjen/domain/model/account/CreditCard;", "selectTimeSlot", "timeSlot", "Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardTimeSlot;", "updateName", "name", "updateEmail", "email", "updatePhoneNumber", "phoneNumber", "Ldk/molslinjen/domain/model/shared/PhoneNumber;", "updateNotificationType", "notificationType", "Ldk/molslinjen/domain/model/saleOnBoard/NotificationType;", "removeLineItem", "lineItemId", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface ISaleOnBoardCheckoutManager extends ICreateBooking {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ void addToBasket$default(ISaleOnBoardCheckoutManager iSaleOnBoardCheckoutManager, SaleOnBoardLineItem saleOnBoardLineItem, boolean z5, int i5, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addToBasket");
            }
            if ((i5 & 2) != 0) {
                z5 = false;
            }
            iSaleOnBoardCheckoutManager.addToBasket(saleOnBoardLineItem, z5);
        }
    }

    void addToBasket(SaleOnBoardLineItem basketLineItem, boolean updateExisting);

    SaleOnBoardProduct getProduct(String id);

    StateFlow<SaleOnBoardCheckoutManager.SaleOnBoardCheckoutState> getSaleOnBoardCheckoutState();

    Object loadShopsAndProducts(Continuation<? super ManagerResult<? extends List<SaleOnBoardStore>>> continuation);

    Object loadTimeSlots(Continuation<? super ManagerResult<? extends List<SaleOnBoardStoreTimeSlots>>> continuation);

    void removeLineItem(String lineItemId);

    void selectPaymentMethod(PaymentType paymentType, CreditCard creditCard);

    void selectTimeSlot(SaleOnBoardTimeSlot timeSlot);

    void setupWithDeparture(IDepartureInfo departure);

    void updateEmail(String email);

    void updateName(String name);

    void updateNotificationType(NotificationType notificationType);

    void updatePhoneNumber(PhoneNumber phoneNumber);
}
