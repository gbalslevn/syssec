package dk.molslinjen.domain.managers.checkout;

import dk.molslinjen.domain.extensions.PriceWithCurrencyExtensionsKt;
import dk.molslinjen.domain.managers.checkout.CheckoutManager;
import dk.molslinjen.domain.model.booking.Booking;
import dk.molslinjen.domain.model.booking.BookingTicket;
import dk.molslinjen.domain.model.booking.product.CheckoutSeatReservation;
import dk.molslinjen.domain.model.booking.product.Product;
import dk.molslinjen.domain.model.booking.product.UnavailableProduct;
import dk.molslinjen.domain.model.booking.product.UnavailableSeatReservation;
import dk.molslinjen.domain.model.shared.CurrencyType;
import dk.molslinjen.domain.model.shared.Price;
import dk.molslinjen.domain.model.shared.PriceWithCurrency;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tJ0\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00072\b\u0010\r\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\b\u001a\u00020\t¨\u0006\u0012"}, d2 = {"Ldk/molslinjen/domain/managers/checkout/PriceHelper;", BuildConfig.FLAVOR, "<init>", "()V", "calculateDirectionSum", "Ldk/molslinjen/domain/managers/checkout/PriceTotal;", "checkoutDirectionState", "Ldk/molslinjen/domain/managers/checkout/CheckoutManager$CheckoutDirectionState;", "currencyType", "Ldk/molslinjen/domain/model/shared/CurrencyType;", "calculatePriceDetails", "Ldk/molslinjen/domain/managers/checkout/PriceDetails;", "outboundState", "returnState", "checkoutState", "Ldk/molslinjen/domain/managers/checkout/CheckoutManager$CheckoutState;", "addonsNoneRefundable", BuildConfig.FLAVOR, "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class PriceHelper {
    public static final PriceHelper INSTANCE = new PriceHelper();

    private PriceHelper() {
    }

    public final PriceTotal calculateDirectionSum(CheckoutManager.CheckoutDirectionState checkoutDirectionState, CurrencyType currencyType) {
        int i5;
        CheckoutSeatReservation reservation;
        PriceWithCurrency paidPrice;
        PriceWithCurrency unpaidPrice;
        Intrinsics.checkNotNullParameter(currencyType, "currencyType");
        int i6 = 0;
        if (checkoutDirectionState == null) {
            return new PriceTotal(PriceWithCurrency.INSTANCE.m3248default(), new Price.Charge(0), false, 4, null);
        }
        Price.Charge charge = new Price.Charge(0);
        Price price = checkoutDirectionState.getDepartureTicket().getPrice();
        if (price instanceof PriceWithCurrency) {
            i5 = ((PriceWithCurrency) checkoutDirectionState.getDepartureTicket().getPrice()).getValue();
        } else {
            if (!(price instanceof Price.Charge)) {
                throw new NoWhenBranchMatchedException();
            }
            charge = (Price.Charge) checkoutDirectionState.getDepartureTicket().getPrice();
            i5 = 0;
        }
        Price.Charge charge2 = charge;
        Iterator<T> it = checkoutDirectionState.getAddons().iterator();
        int i7 = 0;
        while (it.hasNext()) {
            i7 += ((Product) it.next()).sum().getValue();
        }
        int i8 = i5 + i7;
        Iterator<T> it2 = checkoutDirectionState.getFood().iterator();
        int i9 = 0;
        while (it2.hasNext()) {
            i9 += ((Product) it2.next()).sum().getValue();
        }
        int i10 = i8 + i9;
        Iterator<T> it3 = checkoutDirectionState.getSummaryAddons().iterator();
        int i11 = 0;
        while (it3.hasNext()) {
            i11 += ((Product) it3.next()).sum().getValue();
        }
        int i12 = i10 + i11;
        CheckoutSeatReservation seatReservation = checkoutDirectionState.getSeatReservation();
        int value = i12 + ((seatReservation == null || (unpaidPrice = seatReservation.getUnpaidPrice()) == null) ? 0 : unpaidPrice.getValue());
        UnavailableSeatReservation unavailableSeatReservation = checkoutDirectionState.getUnavailableSeatReservation();
        if (unavailableSeatReservation != null && (reservation = unavailableSeatReservation.getReservation()) != null && (paidPrice = reservation.getPaidPrice()) != null) {
            i6 = paidPrice.getValue();
        }
        return new PriceTotal(new PriceWithCurrency(value - i6, currencyType), charge2, false, 4, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x0295  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0297  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final PriceDetails calculatePriceDetails(CheckoutManager.CheckoutDirectionState outboundState, CheckoutManager.CheckoutDirectionState returnState, CheckoutManager.CheckoutState checkoutState, boolean addonsNoneRefundable, CurrencyType currencyType) {
        PriceTotal plus;
        PriceTotal priceTotal;
        CheckoutSeatReservation reservation;
        PriceWithCurrency paidPrice;
        PriceWithCurrency unpaidPrice;
        int value;
        CheckoutSeatReservation reservation2;
        PriceWithCurrency paidPrice2;
        PriceWithCurrency unpaidPrice2;
        Intrinsics.checkNotNullParameter(outboundState, "outboundState");
        Intrinsics.checkNotNullParameter(checkoutState, "checkoutState");
        Intrinsics.checkNotNullParameter(currencyType, "currencyType");
        PriceWithCurrency changeFee = outboundState.getDepartureTicket().getChangeFee();
        Price price = outboundState.getDepartureTicket().getPrice();
        Booking editingBooking = checkoutState.getEditingBooking();
        BookingTicket ticket = editingBooking != null ? editingBooking.getTicket() : null;
        if (ticket != null && (price instanceof PriceWithCurrency) && (ticket.getTicketPrice() instanceof PriceWithCurrency)) {
            int value2 = ((PriceWithCurrency) price).getValue() - ((PriceWithCurrency) ticket.getTicketPrice()).getValue();
            int value3 = changeFee.getValue() + value2;
            Iterator<T> it = outboundState.getEditUnavailableFood().iterator();
            int i5 = 0;
            while (it.hasNext()) {
                i5 += ((UnavailableProduct) it.next()).getPrice().getValue();
            }
            int i6 = 0;
            for (Product product : outboundState.getEditFood()) {
                int value4 = product.getPrice().getValue() * product.getQuantity();
                PriceWithCurrency originalPrice = product.getOriginalPrice();
                if (originalPrice == null) {
                    originalPrice = product.getPrice();
                }
                i6 += value4 - (originalPrice.getValue() * product.getOriginalQuantity());
            }
            Iterator<T> it2 = outboundState.getEditUnavailableProducts().iterator();
            int i7 = 0;
            while (it2.hasNext()) {
                i7 += ((UnavailableProduct) it2.next()).getPrice().getValue();
            }
            int i8 = 0;
            for (Product product2 : outboundState.getEditAddons()) {
                int value5 = product2.getPrice().getValue() * product2.getQuantity();
                PriceWithCurrency originalPrice2 = product2.getOriginalPrice();
                if (originalPrice2 == null) {
                    originalPrice2 = product2.getPrice();
                }
                i8 += value5 - (originalPrice2.getValue() * product2.getOriginalQuantity());
            }
            if (addonsNoneRefundable) {
                int value6 = value2 + changeFee.getValue() + (i8 - i7);
                int max = Math.max(0, value6);
                int i9 = i6 - i5;
                value = (max != 0 || i9 <= 0) ? max + i9 : Math.max(Math.min(i9, 0), value6 + i9);
            } else {
                int i10 = (((value3 - i5) + i6) - i7) + i8;
                CheckoutSeatReservation seatReservation = outboundState.getSeatReservation();
                int value7 = i10 + ((seatReservation == null || (unpaidPrice2 = seatReservation.getUnpaidPrice()) == null) ? 0 : unpaidPrice2.getValue());
                UnavailableSeatReservation unavailableSeatReservation = outboundState.getUnavailableSeatReservation();
                value = value7 - ((unavailableSeatReservation == null || (reservation2 = unavailableSeatReservation.getReservation()) == null || (paidPrice2 = reservation2.getPaidPrice()) == null) ? 0 : paidPrice2.getValue());
            }
            plus = new PriceTotal(new PriceWithCurrency(value, currencyType), new Price.Charge(0), false, 4, null);
        } else {
            if (checkoutState.getEditingBooking() != null && (price instanceof Price.Charge)) {
                Iterator<T> it3 = outboundState.getEditUnavailableFood().iterator();
                int i11 = 0;
                while (it3.hasNext()) {
                    i11 += ((UnavailableProduct) it3.next()).getPrice().getValue();
                }
                int i12 = 0;
                for (Product product3 : outboundState.getEditFood()) {
                    int value8 = product3.getPrice().getValue() * product3.getQuantity();
                    PriceWithCurrency originalPrice3 = product3.getOriginalPrice();
                    if (originalPrice3 == null) {
                        originalPrice3 = product3.getPrice();
                    }
                    i12 += value8 - (originalPrice3.getValue() * product3.getOriginalQuantity());
                }
                Iterator<T> it4 = outboundState.getEditUnavailableProducts().iterator();
                int i13 = 0;
                while (it4.hasNext()) {
                    i13 += ((UnavailableProduct) it4.next()).getPrice().getValue();
                }
                int i14 = 0;
                for (Product product4 : outboundState.getEditAddons()) {
                    int value9 = product4.getPrice().getValue() * product4.getQuantity();
                    PriceWithCurrency originalPrice4 = product4.getOriginalPrice();
                    if (originalPrice4 == null) {
                        originalPrice4 = product4.getPrice();
                    }
                    i14 += value9 - (originalPrice4.getValue() * product4.getOriginalQuantity());
                }
                int i15 = (((0 - i11) + i12) - i13) + i14;
                CheckoutSeatReservation seatReservation2 = outboundState.getSeatReservation();
                int value10 = i15 + ((seatReservation2 == null || (unpaidPrice = seatReservation2.getUnpaidPrice()) == null) ? 0 : unpaidPrice.getValue());
                UnavailableSeatReservation unavailableSeatReservation2 = outboundState.getUnavailableSeatReservation();
                priceTotal = new PriceTotal(new PriceWithCurrency(value10 - ((unavailableSeatReservation2 == null || (reservation = unavailableSeatReservation2.getReservation()) == null || (paidPrice = reservation.getPaidPrice()) == null) ? 0 : paidPrice.getValue()), currencyType), new Price.Charge(0), true);
                return new PriceDetails(priceTotal, checkoutState.getEditingBooking() == null, PriceWithCurrencyExtensionsKt.nullIfZero(changeFee), false, null);
            }
            plus = outboundState.getTotalPrice().plus(returnState != null ? returnState.getTotalPrice() : null);
        }
        priceTotal = plus;
        return new PriceDetails(priceTotal, checkoutState.getEditingBooking() == null, PriceWithCurrencyExtensionsKt.nullIfZero(changeFee), false, null);
    }
}
