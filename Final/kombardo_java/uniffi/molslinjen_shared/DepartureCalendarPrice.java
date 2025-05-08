package uniffi.molslinjen_shared;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;
import org.threeten.bp.LocalDateTime;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0019\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 '2\u00020\u0001:\u0001'B+\u0012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\r\u0010\u001c\u001a\u00060\u0003j\u0002`\u0004HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0006HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\bHÆ\u0003J\t\u0010\u001f\u001a\u00020\nHÆ\u0003J7\u0010 \u001a\u00020\u00002\f\b\u0002\u0010\u0002\u001a\u00060\u0003j\u0002`\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010!\u001a\u00020\n2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020$HÖ\u0001J\t\u0010%\u001a\u00020&HÖ\u0001R\u001e\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006("}, d2 = {"Luniffi/molslinjen_shared/DepartureCalendarPrice;", BuildConfig.FLAVOR, "date", "Lorg/threeten/bp/LocalDateTime;", "Luniffi/molslinjen_shared/UtcDateTime;", "priceIndicator", "Luniffi/molslinjen_shared/DeparturePriceIndicator;", "price", "Luniffi/molslinjen_shared/Amount;", "hasDepartures", BuildConfig.FLAVOR, "(Lorg/threeten/bp/LocalDateTime;Luniffi/molslinjen_shared/DeparturePriceIndicator;Luniffi/molslinjen_shared/Amount;Z)V", "getDate", "()Lorg/threeten/bp/LocalDateTime;", "setDate", "(Lorg/threeten/bp/LocalDateTime;)V", "getHasDepartures", "()Z", "setHasDepartures", "(Z)V", "getPrice", "()Luniffi/molslinjen_shared/Amount;", "setPrice", "(Luniffi/molslinjen_shared/Amount;)V", "getPriceIndicator", "()Luniffi/molslinjen_shared/DeparturePriceIndicator;", "setPriceIndicator", "(Luniffi/molslinjen_shared/DeparturePriceIndicator;)V", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", BuildConfig.FLAVOR, "toString", BuildConfig.FLAVOR, "Companion", "shared_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class DepartureCalendarPrice {
    private LocalDateTime date;
    private boolean hasDepartures;
    private Amount price;
    private DeparturePriceIndicator priceIndicator;

    public DepartureCalendarPrice(LocalDateTime date, DeparturePriceIndicator priceIndicator, Amount amount, boolean z5) {
        Intrinsics.checkNotNullParameter(date, "date");
        Intrinsics.checkNotNullParameter(priceIndicator, "priceIndicator");
        this.date = date;
        this.priceIndicator = priceIndicator;
        this.price = amount;
        this.hasDepartures = z5;
    }

    public static /* synthetic */ DepartureCalendarPrice copy$default(DepartureCalendarPrice departureCalendarPrice, LocalDateTime localDateTime, DeparturePriceIndicator departurePriceIndicator, Amount amount, boolean z5, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            localDateTime = departureCalendarPrice.date;
        }
        if ((i5 & 2) != 0) {
            departurePriceIndicator = departureCalendarPrice.priceIndicator;
        }
        if ((i5 & 4) != 0) {
            amount = departureCalendarPrice.price;
        }
        if ((i5 & 8) != 0) {
            z5 = departureCalendarPrice.hasDepartures;
        }
        return departureCalendarPrice.copy(localDateTime, departurePriceIndicator, amount, z5);
    }

    /* renamed from: component1, reason: from getter */
    public final LocalDateTime getDate() {
        return this.date;
    }

    /* renamed from: component2, reason: from getter */
    public final DeparturePriceIndicator getPriceIndicator() {
        return this.priceIndicator;
    }

    /* renamed from: component3, reason: from getter */
    public final Amount getPrice() {
        return this.price;
    }

    /* renamed from: component4, reason: from getter */
    public final boolean getHasDepartures() {
        return this.hasDepartures;
    }

    public final DepartureCalendarPrice copy(LocalDateTime date, DeparturePriceIndicator priceIndicator, Amount price, boolean hasDepartures) {
        Intrinsics.checkNotNullParameter(date, "date");
        Intrinsics.checkNotNullParameter(priceIndicator, "priceIndicator");
        return new DepartureCalendarPrice(date, priceIndicator, price, hasDepartures);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DepartureCalendarPrice)) {
            return false;
        }
        DepartureCalendarPrice departureCalendarPrice = (DepartureCalendarPrice) other;
        return Intrinsics.areEqual(this.date, departureCalendarPrice.date) && this.priceIndicator == departureCalendarPrice.priceIndicator && Intrinsics.areEqual(this.price, departureCalendarPrice.price) && this.hasDepartures == departureCalendarPrice.hasDepartures;
    }

    public final LocalDateTime getDate() {
        return this.date;
    }

    public final boolean getHasDepartures() {
        return this.hasDepartures;
    }

    public final Amount getPrice() {
        return this.price;
    }

    public final DeparturePriceIndicator getPriceIndicator() {
        return this.priceIndicator;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = ((this.date.hashCode() * 31) + this.priceIndicator.hashCode()) * 31;
        Amount amount = this.price;
        int hashCode2 = (hashCode + (amount == null ? 0 : amount.hashCode())) * 31;
        boolean z5 = this.hasDepartures;
        int i5 = z5;
        if (z5 != 0) {
            i5 = 1;
        }
        return hashCode2 + i5;
    }

    public final void setDate(LocalDateTime localDateTime) {
        Intrinsics.checkNotNullParameter(localDateTime, "<set-?>");
        this.date = localDateTime;
    }

    public final void setHasDepartures(boolean z5) {
        this.hasDepartures = z5;
    }

    public final void setPrice(Amount amount) {
        this.price = amount;
    }

    public final void setPriceIndicator(DeparturePriceIndicator departurePriceIndicator) {
        Intrinsics.checkNotNullParameter(departurePriceIndicator, "<set-?>");
        this.priceIndicator = departurePriceIndicator;
    }

    public String toString() {
        return "DepartureCalendarPrice(date=" + this.date + ", priceIndicator=" + this.priceIndicator + ", price=" + this.price + ", hasDepartures=" + this.hasDepartures + ")";
    }
}
