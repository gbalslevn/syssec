package dk.molslinjen.domain.model.booking.product;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\b\tB\u0011\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0082\u0001\u0002\n\u000b¨\u0006\f"}, d2 = {"Ldk/molslinjen/domain/model/booking/product/UnavailableSeatReservation;", BuildConfig.FLAVOR, "reservation", "Ldk/molslinjen/domain/model/booking/product/CheckoutSeatReservation;", "<init>", "(Ldk/molslinjen/domain/model/booking/product/CheckoutSeatReservation;)V", "getReservation", "()Ldk/molslinjen/domain/model/booking/product/CheckoutSeatReservation;", "Invalid", "Invalidated", "Ldk/molslinjen/domain/model/booking/product/UnavailableSeatReservation$Invalid;", "Ldk/molslinjen/domain/model/booking/product/UnavailableSeatReservation$Invalidated;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class UnavailableSeatReservation {
    private final CheckoutSeatReservation reservation;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Ldk/molslinjen/domain/model/booking/product/UnavailableSeatReservation$Invalid;", "Ldk/molslinjen/domain/model/booking/product/UnavailableSeatReservation;", "reservation", "Ldk/molslinjen/domain/model/booking/product/CheckoutSeatReservation;", "<init>", "(Ldk/molslinjen/domain/model/booking/product/CheckoutSeatReservation;)V", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Invalid extends UnavailableSeatReservation {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Invalid(CheckoutSeatReservation reservation) {
            super(reservation, null);
            Intrinsics.checkNotNullParameter(reservation, "reservation");
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Ldk/molslinjen/domain/model/booking/product/UnavailableSeatReservation$Invalidated;", "Ldk/molslinjen/domain/model/booking/product/UnavailableSeatReservation;", "reservation", "Ldk/molslinjen/domain/model/booking/product/CheckoutSeatReservation;", "<init>", "(Ldk/molslinjen/domain/model/booking/product/CheckoutSeatReservation;)V", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Invalidated extends UnavailableSeatReservation {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Invalidated(CheckoutSeatReservation reservation) {
            super(reservation, null);
            Intrinsics.checkNotNullParameter(reservation, "reservation");
        }
    }

    public /* synthetic */ UnavailableSeatReservation(CheckoutSeatReservation checkoutSeatReservation, DefaultConstructorMarker defaultConstructorMarker) {
        this(checkoutSeatReservation);
    }

    public final CheckoutSeatReservation getReservation() {
        return this.reservation;
    }

    private UnavailableSeatReservation(CheckoutSeatReservation checkoutSeatReservation) {
        this.reservation = checkoutSeatReservation;
    }
}
