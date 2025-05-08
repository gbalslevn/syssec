package dk.molslinjen.domain.model.booking.product;

import com.sdk.growthbook.utils.Constants;
import dk.molslinjen.api.services.booking.request.BookRequestParameters;
import dk.molslinjen.domain.extensions.domain.FerrySeatExtenstionsKt;
import dk.molslinjen.domain.model.booking.BookingSeatReservation;
import dk.molslinjen.domain.model.shared.PriceWithCurrency;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;
import uniffi.molslinjen_shared.FerrySeat;
import uniffi.molslinjen_shared.SeatReservationId;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 (2\u00020\u0001:\u0001(B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nB\u0011\b\u0016\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\t\u0010\rJ\u0006\u0010\u001c\u001a\u00020\u001dJ\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\t\u0010 \u001a\u00020\bHÆ\u0003J-\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\"\u001a\u00020\b2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001a\u00020%HÖ\u0001J\t\u0010&\u001a\u00020'HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0017R\u0013\u0010\u001a\u001a\u0004\u0018\u00010\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0017¨\u0006)"}, d2 = {"Ldk/molslinjen/domain/model/booking/product/CheckoutSeatReservation;", BuildConfig.FLAVOR, Constants.ID_ATTRIBUTE_KEY, "Luniffi/molslinjen_shared/SeatReservationId;", "seats", BuildConfig.FLAVOR, "Luniffi/molslinjen_shared/FerrySeat;", "paid", BuildConfig.FLAVOR, "<init>", "(Luniffi/molslinjen_shared/SeatReservationId;Ljava/util/List;Z)V", "bookingSeatReservation", "Ldk/molslinjen/domain/model/booking/BookingSeatReservation;", "(Ldk/molslinjen/domain/model/booking/BookingSeatReservation;)V", "getId", "()Luniffi/molslinjen_shared/SeatReservationId;", "getSeats", "()Ljava/util/List;", "getPaid", "()Z", "totalPrice", "Ldk/molslinjen/domain/model/shared/PriceWithCurrency;", "getTotalPrice", "()Ldk/molslinjen/domain/model/shared/PriceWithCurrency;", "unpaidPrice", "getUnpaidPrice", "paidPrice", "getPaidPrice", "toBookRequestParameter", "Ldk/molslinjen/api/services/booking/request/BookRequestParameters$BookSeatReservationRequestParameter;", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", BuildConfig.FLAVOR, "toString", BuildConfig.FLAVOR, "Companion", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class CheckoutSeatReservation {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final CheckoutSeatReservation mock;
    private final SeatReservationId id;
    private final boolean paid;
    private final PriceWithCurrency paidPrice;
    private final List<FerrySeat> seats;
    private final PriceWithCurrency totalPrice;
    private final PriceWithCurrency unpaidPrice;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Ldk/molslinjen/domain/model/booking/product/CheckoutSeatReservation$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "mock", "Ldk/molslinjen/domain/model/booking/product/CheckoutSeatReservation;", "getMock", "()Ldk/molslinjen/domain/model/booking/product/CheckoutSeatReservation;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final CheckoutSeatReservation getMock() {
            return CheckoutSeatReservation.mock;
        }

        private Companion() {
        }
    }

    static {
        SeatReservationId seatReservationId = new SeatReservationId(1);
        FerrySeat.Companion companion = FerrySeat.INSTANCE;
        mock = new CheckoutSeatReservation(seatReservationId, CollectionsKt.listOf((Object[]) new FerrySeat[]{FerrySeatExtenstionsKt.mock(companion, 1), FerrySeatExtenstionsKt.mock(companion, 2), FerrySeatExtenstionsKt.mock(companion, 3)}), true);
    }

    public CheckoutSeatReservation(SeatReservationId id, List<FerrySeat> seats, boolean z5) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(seats, "seats");
        this.id = id;
        this.seats = seats;
        this.paid = z5;
        PriceWithCurrency priceWithCurrency = FerrySeatExtenstionsKt.totalPrice(seats);
        this.totalPrice = priceWithCurrency;
        this.unpaidPrice = !z5 ? priceWithCurrency : null;
        this.paidPrice = z5 ? priceWithCurrency : null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CheckoutSeatReservation copy$default(CheckoutSeatReservation checkoutSeatReservation, SeatReservationId seatReservationId, List list, boolean z5, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            seatReservationId = checkoutSeatReservation.id;
        }
        if ((i5 & 2) != 0) {
            list = checkoutSeatReservation.seats;
        }
        if ((i5 & 4) != 0) {
            z5 = checkoutSeatReservation.paid;
        }
        return checkoutSeatReservation.copy(seatReservationId, list, z5);
    }

    /* renamed from: component1, reason: from getter */
    public final SeatReservationId getId() {
        return this.id;
    }

    public final List<FerrySeat> component2() {
        return this.seats;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getPaid() {
        return this.paid;
    }

    public final CheckoutSeatReservation copy(SeatReservationId id, List<FerrySeat> seats, boolean paid) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(seats, "seats");
        return new CheckoutSeatReservation(id, seats, paid);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CheckoutSeatReservation)) {
            return false;
        }
        CheckoutSeatReservation checkoutSeatReservation = (CheckoutSeatReservation) other;
        return Intrinsics.areEqual(this.id, checkoutSeatReservation.id) && Intrinsics.areEqual(this.seats, checkoutSeatReservation.seats) && this.paid == checkoutSeatReservation.paid;
    }

    public final SeatReservationId getId() {
        return this.id;
    }

    public final boolean getPaid() {
        return this.paid;
    }

    public final PriceWithCurrency getPaidPrice() {
        return this.paidPrice;
    }

    public final List<FerrySeat> getSeats() {
        return this.seats;
    }

    public final PriceWithCurrency getTotalPrice() {
        return this.totalPrice;
    }

    public final PriceWithCurrency getUnpaidPrice() {
        return this.unpaidPrice;
    }

    public int hashCode() {
        return (((this.id.hashCode() * 31) + this.seats.hashCode()) * 31) + Boolean.hashCode(this.paid);
    }

    public final BookRequestParameters.BookSeatReservationRequestParameter toBookRequestParameter() {
        int value = this.id.getValue();
        List<FerrySeat> list = this.seats;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(FerrySeatExtenstionsKt.toRequestParameter((FerrySeat) it.next()));
        }
        return new BookRequestParameters.BookSeatReservationRequestParameter(value, arrayList);
    }

    public String toString() {
        return "CheckoutSeatReservation(id=" + this.id + ", seats=" + this.seats + ", paid=" + this.paid + ")";
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CheckoutSeatReservation(BookingSeatReservation bookingSeatReservation) {
        this(bookingSeatReservation.getId(), bookingSeatReservation.getSeats(), true);
        Intrinsics.checkNotNullParameter(bookingSeatReservation, "bookingSeatReservation");
    }
}
