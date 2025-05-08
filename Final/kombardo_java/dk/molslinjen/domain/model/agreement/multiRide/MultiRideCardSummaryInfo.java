package dk.molslinjen.domain.model.agreement.multiRide;

import dk.molslinjen.api.services.multiRide.response.MultiRideCardSummaryResponseDTO;
import dk.molslinjen.domain.managers.checkout.PriceTotal;
import dk.molslinjen.domain.model.booking.TicketCategoryType;
import dk.molslinjen.domain.model.shared.PriceWithCurrency;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;
import org.threeten.bp.LocalDate;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\b\u0018\u0000 32\u00020\u0001:\u00013BK\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0004\b\u000f\u0010\u0010B)\b\u0016\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u000f\u0010\u0014J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0006HÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\tHÆ\u0003J\u0010\u0010)\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010\u001eJ\t\u0010*\u001a\u00020\u000bHÆ\u0003J\t\u0010+\u001a\u00020\u000eHÆ\u0003Jb\u0010,\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000eHÆ\u0001¢\u0006\u0002\u0010-J\u0013\u0010.\u001a\u00020/2\b\u00100\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00101\u001a\u00020\u000bHÖ\u0001J\t\u00102\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0016R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0015\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\n\n\u0002\u0010\u001f\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\f\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#¨\u00064"}, d2 = {"Ldk/molslinjen/domain/model/agreement/multiRide/MultiRideCardSummaryInfo;", BuildConfig.FLAVOR, "multiRideId", BuildConfig.FLAVOR, "multiRideTypeId", "ticketCategoryType", "Ldk/molslinjen/domain/model/booking/TicketCategoryType;", "ticketTypeName", "chargesExpireDate", "Lorg/threeten/bp/LocalDate;", "newTotalNumberOfCharges", BuildConfig.FLAVOR, "numberOfChargesToAdd", "totalPrice", "Ldk/molslinjen/domain/managers/checkout/PriceTotal;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ldk/molslinjen/domain/model/booking/TicketCategoryType;Ljava/lang/String;Lorg/threeten/bp/LocalDate;Ljava/lang/Integer;ILdk/molslinjen/domain/managers/checkout/PriceTotal;)V", "dto", "Ldk/molslinjen/api/services/multiRide/response/MultiRideCardSummaryResponseDTO;", "oldChargesAmount", "(Ldk/molslinjen/api/services/multiRide/response/MultiRideCardSummaryResponseDTO;Ljava/lang/String;Ljava/lang/Integer;)V", "getMultiRideId", "()Ljava/lang/String;", "getMultiRideTypeId", "getTicketCategoryType", "()Ldk/molslinjen/domain/model/booking/TicketCategoryType;", "getTicketTypeName", "getChargesExpireDate", "()Lorg/threeten/bp/LocalDate;", "getNewTotalNumberOfCharges", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getNumberOfChargesToAdd", "()I", "getTotalPrice", "()Ldk/molslinjen/domain/managers/checkout/PriceTotal;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/lang/String;Ljava/lang/String;Ldk/molslinjen/domain/model/booking/TicketCategoryType;Ljava/lang/String;Lorg/threeten/bp/LocalDate;Ljava/lang/Integer;ILdk/molslinjen/domain/managers/checkout/PriceTotal;)Ldk/molslinjen/domain/model/agreement/multiRide/MultiRideCardSummaryInfo;", "equals", BuildConfig.FLAVOR, "other", "hashCode", "toString", "Companion", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class MultiRideCardSummaryInfo {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final MultiRideCardSummaryInfo mock;
    private final LocalDate chargesExpireDate;
    private final String multiRideId;
    private final String multiRideTypeId;
    private final Integer newTotalNumberOfCharges;
    private final int numberOfChargesToAdd;
    private final TicketCategoryType ticketCategoryType;
    private final String ticketTypeName;
    private final PriceTotal totalPrice;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Ldk/molslinjen/domain/model/agreement/multiRide/MultiRideCardSummaryInfo$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "mock", "Ldk/molslinjen/domain/model/agreement/multiRide/MultiRideCardSummaryInfo;", "getMock", "()Ldk/molslinjen/domain/model/agreement/multiRide/MultiRideCardSummaryInfo;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final MultiRideCardSummaryInfo getMock() {
            return MultiRideCardSummaryInfo.mock;
        }

        private Companion() {
        }
    }

    static {
        TicketCategoryType ticketCategoryType = TicketCategoryType.Flex;
        LocalDate plusDays = LocalDate.now().plusDays(30L);
        Intrinsics.checkNotNullExpressionValue(plusDays, "plusDays(...)");
        mock = new MultiRideCardSummaryInfo("123456789", "081", ticketCategoryType, "FlexMOCK", plusDays, 10, 10, new PriceTotal(PriceWithCurrency.INSTANCE.mock(10)));
    }

    public MultiRideCardSummaryInfo(String str, String multiRideTypeId, TicketCategoryType ticketCategoryType, String ticketTypeName, LocalDate chargesExpireDate, Integer num, int i5, PriceTotal totalPrice) {
        Intrinsics.checkNotNullParameter(multiRideTypeId, "multiRideTypeId");
        Intrinsics.checkNotNullParameter(ticketCategoryType, "ticketCategoryType");
        Intrinsics.checkNotNullParameter(ticketTypeName, "ticketTypeName");
        Intrinsics.checkNotNullParameter(chargesExpireDate, "chargesExpireDate");
        Intrinsics.checkNotNullParameter(totalPrice, "totalPrice");
        this.multiRideId = str;
        this.multiRideTypeId = multiRideTypeId;
        this.ticketCategoryType = ticketCategoryType;
        this.ticketTypeName = ticketTypeName;
        this.chargesExpireDate = chargesExpireDate;
        this.newTotalNumberOfCharges = num;
        this.numberOfChargesToAdd = i5;
        this.totalPrice = totalPrice;
    }

    /* renamed from: component1, reason: from getter */
    public final String getMultiRideId() {
        return this.multiRideId;
    }

    /* renamed from: component2, reason: from getter */
    public final String getMultiRideTypeId() {
        return this.multiRideTypeId;
    }

    /* renamed from: component3, reason: from getter */
    public final TicketCategoryType getTicketCategoryType() {
        return this.ticketCategoryType;
    }

    /* renamed from: component4, reason: from getter */
    public final String getTicketTypeName() {
        return this.ticketTypeName;
    }

    /* renamed from: component5, reason: from getter */
    public final LocalDate getChargesExpireDate() {
        return this.chargesExpireDate;
    }

    /* renamed from: component6, reason: from getter */
    public final Integer getNewTotalNumberOfCharges() {
        return this.newTotalNumberOfCharges;
    }

    /* renamed from: component7, reason: from getter */
    public final int getNumberOfChargesToAdd() {
        return this.numberOfChargesToAdd;
    }

    /* renamed from: component8, reason: from getter */
    public final PriceTotal getTotalPrice() {
        return this.totalPrice;
    }

    public final MultiRideCardSummaryInfo copy(String multiRideId, String multiRideTypeId, TicketCategoryType ticketCategoryType, String ticketTypeName, LocalDate chargesExpireDate, Integer newTotalNumberOfCharges, int numberOfChargesToAdd, PriceTotal totalPrice) {
        Intrinsics.checkNotNullParameter(multiRideTypeId, "multiRideTypeId");
        Intrinsics.checkNotNullParameter(ticketCategoryType, "ticketCategoryType");
        Intrinsics.checkNotNullParameter(ticketTypeName, "ticketTypeName");
        Intrinsics.checkNotNullParameter(chargesExpireDate, "chargesExpireDate");
        Intrinsics.checkNotNullParameter(totalPrice, "totalPrice");
        return new MultiRideCardSummaryInfo(multiRideId, multiRideTypeId, ticketCategoryType, ticketTypeName, chargesExpireDate, newTotalNumberOfCharges, numberOfChargesToAdd, totalPrice);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MultiRideCardSummaryInfo)) {
            return false;
        }
        MultiRideCardSummaryInfo multiRideCardSummaryInfo = (MultiRideCardSummaryInfo) other;
        return Intrinsics.areEqual(this.multiRideId, multiRideCardSummaryInfo.multiRideId) && Intrinsics.areEqual(this.multiRideTypeId, multiRideCardSummaryInfo.multiRideTypeId) && this.ticketCategoryType == multiRideCardSummaryInfo.ticketCategoryType && Intrinsics.areEqual(this.ticketTypeName, multiRideCardSummaryInfo.ticketTypeName) && Intrinsics.areEqual(this.chargesExpireDate, multiRideCardSummaryInfo.chargesExpireDate) && Intrinsics.areEqual(this.newTotalNumberOfCharges, multiRideCardSummaryInfo.newTotalNumberOfCharges) && this.numberOfChargesToAdd == multiRideCardSummaryInfo.numberOfChargesToAdd && Intrinsics.areEqual(this.totalPrice, multiRideCardSummaryInfo.totalPrice);
    }

    public final LocalDate getChargesExpireDate() {
        return this.chargesExpireDate;
    }

    public final String getMultiRideId() {
        return this.multiRideId;
    }

    public final String getMultiRideTypeId() {
        return this.multiRideTypeId;
    }

    public final Integer getNewTotalNumberOfCharges() {
        return this.newTotalNumberOfCharges;
    }

    public final int getNumberOfChargesToAdd() {
        return this.numberOfChargesToAdd;
    }

    public final TicketCategoryType getTicketCategoryType() {
        return this.ticketCategoryType;
    }

    public final String getTicketTypeName() {
        return this.ticketTypeName;
    }

    public final PriceTotal getTotalPrice() {
        return this.totalPrice;
    }

    public int hashCode() {
        String str = this.multiRideId;
        int hashCode = (((((((((str == null ? 0 : str.hashCode()) * 31) + this.multiRideTypeId.hashCode()) * 31) + this.ticketCategoryType.hashCode()) * 31) + this.ticketTypeName.hashCode()) * 31) + this.chargesExpireDate.hashCode()) * 31;
        Integer num = this.newTotalNumberOfCharges;
        return ((((hashCode + (num != null ? num.hashCode() : 0)) * 31) + Integer.hashCode(this.numberOfChargesToAdd)) * 31) + this.totalPrice.hashCode();
    }

    public String toString() {
        return "MultiRideCardSummaryInfo(multiRideId=" + this.multiRideId + ", multiRideTypeId=" + this.multiRideTypeId + ", ticketCategoryType=" + this.ticketCategoryType + ", ticketTypeName=" + this.ticketTypeName + ", chargesExpireDate=" + this.chargesExpireDate + ", newTotalNumberOfCharges=" + this.newTotalNumberOfCharges + ", numberOfChargesToAdd=" + this.numberOfChargesToAdd + ", totalPrice=" + this.totalPrice + ")";
    }

    public /* synthetic */ MultiRideCardSummaryInfo(MultiRideCardSummaryResponseDTO multiRideCardSummaryResponseDTO, String str, Integer num, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this(multiRideCardSummaryResponseDTO, (i5 & 2) != 0 ? null : str, (i5 & 4) != 0 ? null : num);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MultiRideCardSummaryInfo(MultiRideCardSummaryResponseDTO dto, String str, Integer num) {
        this(str == null ? dto.getCardNumber() : str, dto.getCardType(), TicketCategoryType.INSTANCE.invoke(dto.getCategory().getId()), dto.getCategory().getName(), dto.getValidUntil(), num != null ? Integer.valueOf(num.intValue() + dto.getNumberOfTickets()) : null, dto.getNumberOfTickets(), new PriceTotal(new PriceWithCurrency(dto.getTotalPrice())));
        Intrinsics.checkNotNullParameter(dto, "dto");
    }
}
