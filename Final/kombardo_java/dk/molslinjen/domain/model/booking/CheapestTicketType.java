package dk.molslinjen.domain.model.booking;

import dk.molslinjen.api.services.booking.response.DeparturesResponseDTO;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tB\u0011\b\u0016\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\b\u0010\fJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0007HÆ\u0003J'\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0007HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001e"}, d2 = {"Ldk/molslinjen/domain/model/booking/CheapestTicketType;", BuildConfig.FLAVOR, "priceIndicator", "Ldk/molslinjen/domain/model/booking/CheapestTicketPriceIndicator;", "ticketType", "Ldk/molslinjen/domain/model/booking/TicketCategoryType;", "ticketTypeName", BuildConfig.FLAVOR, "<init>", "(Ldk/molslinjen/domain/model/booking/CheapestTicketPriceIndicator;Ldk/molslinjen/domain/model/booking/TicketCategoryType;Ljava/lang/String;)V", "dto", "Ldk/molslinjen/api/services/booking/response/DeparturesResponseDTO$CheapestTicketDTO;", "(Ldk/molslinjen/api/services/booking/response/DeparturesResponseDTO$CheapestTicketDTO;)V", "getPriceIndicator", "()Ldk/molslinjen/domain/model/booking/CheapestTicketPriceIndicator;", "getTicketType", "()Ldk/molslinjen/domain/model/booking/TicketCategoryType;", "getTicketTypeName", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", BuildConfig.FLAVOR, "other", "hashCode", BuildConfig.FLAVOR, "toString", "Companion", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class CheapestTicketType {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final CheapestTicketType mock = new CheapestTicketType(CheapestTicketPriceIndicator.Highlighted, TicketCategoryType.LowPrice, "Mock");
    private final CheapestTicketPriceIndicator priceIndicator;
    private final TicketCategoryType ticketType;
    private final String ticketTypeName;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Ldk/molslinjen/domain/model/booking/CheapestTicketType$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "mock", "Ldk/molslinjen/domain/model/booking/CheapestTicketType;", "getMock", "()Ldk/molslinjen/domain/model/booking/CheapestTicketType;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final CheapestTicketType getMock() {
            return CheapestTicketType.mock;
        }

        private Companion() {
        }
    }

    public CheapestTicketType(CheapestTicketPriceIndicator priceIndicator, TicketCategoryType ticketType, String ticketTypeName) {
        Intrinsics.checkNotNullParameter(priceIndicator, "priceIndicator");
        Intrinsics.checkNotNullParameter(ticketType, "ticketType");
        Intrinsics.checkNotNullParameter(ticketTypeName, "ticketTypeName");
        this.priceIndicator = priceIndicator;
        this.ticketType = ticketType;
        this.ticketTypeName = ticketTypeName;
    }

    public static /* synthetic */ CheapestTicketType copy$default(CheapestTicketType cheapestTicketType, CheapestTicketPriceIndicator cheapestTicketPriceIndicator, TicketCategoryType ticketCategoryType, String str, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            cheapestTicketPriceIndicator = cheapestTicketType.priceIndicator;
        }
        if ((i5 & 2) != 0) {
            ticketCategoryType = cheapestTicketType.ticketType;
        }
        if ((i5 & 4) != 0) {
            str = cheapestTicketType.ticketTypeName;
        }
        return cheapestTicketType.copy(cheapestTicketPriceIndicator, ticketCategoryType, str);
    }

    /* renamed from: component1, reason: from getter */
    public final CheapestTicketPriceIndicator getPriceIndicator() {
        return this.priceIndicator;
    }

    /* renamed from: component2, reason: from getter */
    public final TicketCategoryType getTicketType() {
        return this.ticketType;
    }

    /* renamed from: component3, reason: from getter */
    public final String getTicketTypeName() {
        return this.ticketTypeName;
    }

    public final CheapestTicketType copy(CheapestTicketPriceIndicator priceIndicator, TicketCategoryType ticketType, String ticketTypeName) {
        Intrinsics.checkNotNullParameter(priceIndicator, "priceIndicator");
        Intrinsics.checkNotNullParameter(ticketType, "ticketType");
        Intrinsics.checkNotNullParameter(ticketTypeName, "ticketTypeName");
        return new CheapestTicketType(priceIndicator, ticketType, ticketTypeName);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CheapestTicketType)) {
            return false;
        }
        CheapestTicketType cheapestTicketType = (CheapestTicketType) other;
        return this.priceIndicator == cheapestTicketType.priceIndicator && this.ticketType == cheapestTicketType.ticketType && Intrinsics.areEqual(this.ticketTypeName, cheapestTicketType.ticketTypeName);
    }

    public final CheapestTicketPriceIndicator getPriceIndicator() {
        return this.priceIndicator;
    }

    public final TicketCategoryType getTicketType() {
        return this.ticketType;
    }

    public final String getTicketTypeName() {
        return this.ticketTypeName;
    }

    public int hashCode() {
        return (((this.priceIndicator.hashCode() * 31) + this.ticketType.hashCode()) * 31) + this.ticketTypeName.hashCode();
    }

    public String toString() {
        return "CheapestTicketType(priceIndicator=" + this.priceIndicator + ", ticketType=" + this.ticketType + ", ticketTypeName=" + this.ticketTypeName + ")";
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CheapestTicketType(DeparturesResponseDTO.CheapestTicketDTO dto) {
        this(CheapestTicketPriceIndicator.INSTANCE.invoke(dto.getPriceIndicator()), TicketCategoryType.INSTANCE.invoke(dto.getTicketTypeId()), dto.getTicketTypeName());
        Intrinsics.checkNotNullParameter(dto, "dto");
    }
}
