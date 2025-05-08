package dk.molslinjen.domain.model.booking;

import dk.molslinjen.api.shared.response.TicketSurchargeDTO;
import dk.molslinjen.domain.model.shared.PriceWithCurrency;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tB\u0011\b\u0016\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\b\u0010\fJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0007HÆ\u0003J'\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001e"}, d2 = {"Ldk/molslinjen/domain/model/booking/TicketSurcharge;", BuildConfig.FLAVOR, "name", BuildConfig.FLAVOR, "price", "Ldk/molslinjen/domain/model/shared/PriceWithCurrency;", "type", "Ldk/molslinjen/domain/model/booking/TicketSurchargeType;", "<init>", "(Ljava/lang/String;Ldk/molslinjen/domain/model/shared/PriceWithCurrency;Ldk/molslinjen/domain/model/booking/TicketSurchargeType;)V", "dto", "Ldk/molslinjen/api/shared/response/TicketSurchargeDTO;", "(Ldk/molslinjen/api/shared/response/TicketSurchargeDTO;)V", "getName", "()Ljava/lang/String;", "getPrice", "()Ldk/molslinjen/domain/model/shared/PriceWithCurrency;", "getType", "()Ldk/molslinjen/domain/model/booking/TicketSurchargeType;", "component1", "component2", "component3", "copy", "equals", BuildConfig.FLAVOR, "other", "hashCode", BuildConfig.FLAVOR, "toString", "Companion", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class TicketSurcharge {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final TicketSurcharge mock = new TicketSurcharge("CO2 Tillæg", PriceWithCurrency.INSTANCE.mock(250), TicketSurchargeType.Goods);
    private final String name;
    private final PriceWithCurrency price;
    private final TicketSurchargeType type;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Ldk/molslinjen/domain/model/booking/TicketSurcharge$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "mock", "Ldk/molslinjen/domain/model/booking/TicketSurcharge;", "getMock", "()Ldk/molslinjen/domain/model/booking/TicketSurcharge;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final TicketSurcharge getMock() {
            return TicketSurcharge.mock;
        }

        private Companion() {
        }
    }

    public TicketSurcharge(String name, PriceWithCurrency price, TicketSurchargeType type) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(price, "price");
        Intrinsics.checkNotNullParameter(type, "type");
        this.name = name;
        this.price = price;
        this.type = type;
    }

    public static /* synthetic */ TicketSurcharge copy$default(TicketSurcharge ticketSurcharge, String str, PriceWithCurrency priceWithCurrency, TicketSurchargeType ticketSurchargeType, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            str = ticketSurcharge.name;
        }
        if ((i5 & 2) != 0) {
            priceWithCurrency = ticketSurcharge.price;
        }
        if ((i5 & 4) != 0) {
            ticketSurchargeType = ticketSurcharge.type;
        }
        return ticketSurcharge.copy(str, priceWithCurrency, ticketSurchargeType);
    }

    /* renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component2, reason: from getter */
    public final PriceWithCurrency getPrice() {
        return this.price;
    }

    /* renamed from: component3, reason: from getter */
    public final TicketSurchargeType getType() {
        return this.type;
    }

    public final TicketSurcharge copy(String name, PriceWithCurrency price, TicketSurchargeType type) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(price, "price");
        Intrinsics.checkNotNullParameter(type, "type");
        return new TicketSurcharge(name, price, type);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TicketSurcharge)) {
            return false;
        }
        TicketSurcharge ticketSurcharge = (TicketSurcharge) other;
        return Intrinsics.areEqual(this.name, ticketSurcharge.name) && Intrinsics.areEqual(this.price, ticketSurcharge.price) && this.type == ticketSurcharge.type;
    }

    public final String getName() {
        return this.name;
    }

    public final PriceWithCurrency getPrice() {
        return this.price;
    }

    public final TicketSurchargeType getType() {
        return this.type;
    }

    public int hashCode() {
        return (((this.name.hashCode() * 31) + this.price.hashCode()) * 31) + this.type.hashCode();
    }

    public String toString() {
        return "TicketSurcharge(name=" + this.name + ", price=" + this.price + ", type=" + this.type + ")";
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TicketSurcharge(TicketSurchargeDTO dto) {
        this(dto.getName(), new PriceWithCurrency(dto.getPrice()), TicketSurchargeType.INSTANCE.invoke(dto.getType()));
        Intrinsics.checkNotNullParameter(dto, "dto");
    }
}
