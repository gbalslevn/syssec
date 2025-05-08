package dk.molslinjen.domain.model.booking;

import com.adjust.sdk.Constants;
import dk.molslinjen.api.services.booking.response.booking.BookingResponseDTO;
import dk.molslinjen.api.shared.response.PriceWithCurrencyDTO;
import dk.molslinjen.domain.managers.checkout.PriceTotal;
import dk.molslinjen.domain.model.config.Site;
import dk.molslinjen.domain.model.config.Transportation;
import dk.molslinjen.domain.model.shared.Price;
import dk.molslinjen.domain.model.shared.PriceWithCurrency;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;
import org.threeten.bp.LocalDate;
import org.threeten.bp.LocalDateTime;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b,\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 P2\u00020\u0001:\u0001PB\u0089\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\f\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0005\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\u0006\u0010\u0013\u001a\u00020\u0014\u0012\u0006\u0010\u0015\u001a\u00020\u0005\u0012\u0006\u0010\u0016\u001a\u00020\u0017\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\u001b\u0010\u001cB)\b\u0016\u0012\u0006\u0010\u001d\u001a\u00020\u001e\u0012\u0006\u0010\u0016\u001a\u00020\u0017\u0012\u000e\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010 ¢\u0006\u0004\b\u001b\u0010\"J\u0006\u0010:\u001a\u00020\u0005J\t\u0010;\u001a\u00020\u0003HÆ\u0003J\t\u0010<\u001a\u00020\u0005HÆ\u0003J\t\u0010=\u001a\u00020\u0007HÆ\u0003J\t\u0010>\u001a\u00020\u0005HÆ\u0003J\t\u0010?\u001a\u00020\nHÆ\u0003J\u000b\u0010@\u001a\u0004\u0018\u00010\fHÆ\u0003J\u000b\u0010A\u001a\u0004\u0018\u00010\fHÆ\u0003J\u000b\u0010B\u001a\u0004\u0018\u00010\u000fHÆ\u0003J\t\u0010C\u001a\u00020\u0005HÆ\u0003J\t\u0010D\u001a\u00020\u0012HÆ\u0003J\t\u0010E\u001a\u00020\u0014HÆ\u0003J\t\u0010F\u001a\u00020\u0005HÆ\u0003J\t\u0010G\u001a\u00020\u0017HÆ\u0003J\u000b\u0010H\u001a\u0004\u0018\u00010\u0019HÆ\u0003J\u000b\u0010I\u001a\u0004\u0018\u00010\u0012HÆ\u0003J©\u0001\u0010J\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00052\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00052\b\b\u0002\u0010\u0016\u001a\u00020\u00172\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0012HÆ\u0001J\u0013\u0010K\u001a\u00020\u00052\b\u0010L\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010M\u001a\u00020NHÖ\u0001J\t\u0010O\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010&R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u0013\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b-\u0010,R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u0011\u0010\u0010\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b0\u0010&R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b1\u00102R\u0011\u0010\u0013\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b3\u00104R\u0011\u0010\u0015\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010&R\u0011\u0010\u0016\u001a\u00020\u0017¢\u0006\b\n\u0000\u001a\u0004\b5\u00106R\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u0019¢\u0006\b\n\u0000\u001a\u0004\b7\u00108R\u0013\u0010\u001a\u001a\u0004\u0018\u00010\u0012¢\u0006\b\n\u0000\u001a\u0004\b9\u00102¨\u0006Q"}, d2 = {"Ldk/molslinjen/domain/model/booking/Booking;", BuildConfig.FLAVOR, "authenticationInfo", "Ldk/molslinjen/domain/model/booking/AuthenticationInfo;", "canChange", BuildConfig.FLAVOR, "customerInfo", "Ldk/molslinjen/domain/model/booking/CustomerInfo;", "isRefundAvailable", "orderTotal", "Ldk/molslinjen/domain/managers/checkout/PriceTotal;", "refundAmount", "Ldk/molslinjen/domain/model/shared/PriceWithCurrency;", "refundFee", "refundDate", "Lorg/threeten/bp/LocalDate;", "refunded", "reservationNumber", BuildConfig.FLAVOR, "ticket", "Ldk/molslinjen/domain/model/booking/BookingTicket;", "isUsed", "site", "Ldk/molslinjen/domain/model/config/Site;", "multiRideInfo", "Ldk/molslinjen/domain/model/booking/MultiRideInfo;", "commuteAgreementId", "<init>", "(Ldk/molslinjen/domain/model/booking/AuthenticationInfo;ZLdk/molslinjen/domain/model/booking/CustomerInfo;ZLdk/molslinjen/domain/managers/checkout/PriceTotal;Ldk/molslinjen/domain/model/shared/PriceWithCurrency;Ldk/molslinjen/domain/model/shared/PriceWithCurrency;Lorg/threeten/bp/LocalDate;ZLjava/lang/String;Ldk/molslinjen/domain/model/booking/BookingTicket;ZLdk/molslinjen/domain/model/config/Site;Ldk/molslinjen/domain/model/booking/MultiRideInfo;Ljava/lang/String;)V", "dto", "Ldk/molslinjen/api/services/booking/response/booking/BookingResponseDTO;", "allTransportations", BuildConfig.FLAVOR, "Ldk/molslinjen/domain/model/config/Transportation;", "(Ldk/molslinjen/api/services/booking/response/booking/BookingResponseDTO;Ldk/molslinjen/domain/model/config/Site;Ljava/util/List;)V", "getAuthenticationInfo", "()Ldk/molslinjen/domain/model/booking/AuthenticationInfo;", "getCanChange", "()Z", "getCustomerInfo", "()Ldk/molslinjen/domain/model/booking/CustomerInfo;", "getOrderTotal", "()Ldk/molslinjen/domain/managers/checkout/PriceTotal;", "getRefundAmount", "()Ldk/molslinjen/domain/model/shared/PriceWithCurrency;", "getRefundFee", "getRefundDate", "()Lorg/threeten/bp/LocalDate;", "getRefunded", "getReservationNumber", "()Ljava/lang/String;", "getTicket", "()Ldk/molslinjen/domain/model/booking/BookingTicket;", "getSite", "()Ldk/molslinjen/domain/model/config/Site;", "getMultiRideInfo", "()Ldk/molslinjen/domain/model/booking/MultiRideInfo;", "getCommuteAgreementId", "isActive", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "copy", "equals", "other", "hashCode", BuildConfig.FLAVOR, "toString", "Companion", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class Booking {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Booking mock;
    private final AuthenticationInfo authenticationInfo;
    private final boolean canChange;
    private final String commuteAgreementId;
    private final CustomerInfo customerInfo;
    private final boolean isRefundAvailable;
    private final boolean isUsed;
    private final MultiRideInfo multiRideInfo;
    private final PriceTotal orderTotal;
    private final PriceWithCurrency refundAmount;
    private final LocalDate refundDate;
    private final PriceWithCurrency refundFee;
    private final boolean refunded;
    private final String reservationNumber;
    private final Site site;
    private final BookingTicket ticket;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Ldk/molslinjen/domain/model/booking/Booking$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "mock", "Ldk/molslinjen/domain/model/booking/Booking;", "getMock", "()Ldk/molslinjen/domain/model/booking/Booking;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Booking getMock() {
            return Booking.mock;
        }

        private Companion() {
        }
    }

    static {
        AuthenticationInfo mock2 = AuthenticationInfo.INSTANCE.getMock();
        CustomerInfo mock3 = CustomerInfo.INSTANCE.getMock();
        PriceWithCurrency.Companion companion = PriceWithCurrency.INSTANCE;
        mock = new Booking(mock2, true, mock3, true, new PriceTotal(companion.mock(Constants.ONE_SECOND)), companion.mock(547), companion.mock(64), LocalDate.now(), false, "12345678", BookingTicket.INSTANCE.getMock(), false, Site.Mols, null, null);
    }

    public Booking(AuthenticationInfo authenticationInfo, boolean z5, CustomerInfo customerInfo, boolean z6, PriceTotal orderTotal, PriceWithCurrency priceWithCurrency, PriceWithCurrency priceWithCurrency2, LocalDate localDate, boolean z7, String reservationNumber, BookingTicket ticket, boolean z8, Site site, MultiRideInfo multiRideInfo, String str) {
        Intrinsics.checkNotNullParameter(authenticationInfo, "authenticationInfo");
        Intrinsics.checkNotNullParameter(customerInfo, "customerInfo");
        Intrinsics.checkNotNullParameter(orderTotal, "orderTotal");
        Intrinsics.checkNotNullParameter(reservationNumber, "reservationNumber");
        Intrinsics.checkNotNullParameter(ticket, "ticket");
        Intrinsics.checkNotNullParameter(site, "site");
        this.authenticationInfo = authenticationInfo;
        this.canChange = z5;
        this.customerInfo = customerInfo;
        this.isRefundAvailable = z6;
        this.orderTotal = orderTotal;
        this.refundAmount = priceWithCurrency;
        this.refundFee = priceWithCurrency2;
        this.refundDate = localDate;
        this.refunded = z7;
        this.reservationNumber = reservationNumber;
        this.ticket = ticket;
        this.isUsed = z8;
        this.site = site;
        this.multiRideInfo = multiRideInfo;
        this.commuteAgreementId = str;
    }

    /* renamed from: component1, reason: from getter */
    public final AuthenticationInfo getAuthenticationInfo() {
        return this.authenticationInfo;
    }

    /* renamed from: component10, reason: from getter */
    public final String getReservationNumber() {
        return this.reservationNumber;
    }

    /* renamed from: component11, reason: from getter */
    public final BookingTicket getTicket() {
        return this.ticket;
    }

    /* renamed from: component12, reason: from getter */
    public final boolean getIsUsed() {
        return this.isUsed;
    }

    /* renamed from: component13, reason: from getter */
    public final Site getSite() {
        return this.site;
    }

    /* renamed from: component14, reason: from getter */
    public final MultiRideInfo getMultiRideInfo() {
        return this.multiRideInfo;
    }

    /* renamed from: component15, reason: from getter */
    public final String getCommuteAgreementId() {
        return this.commuteAgreementId;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getCanChange() {
        return this.canChange;
    }

    /* renamed from: component3, reason: from getter */
    public final CustomerInfo getCustomerInfo() {
        return this.customerInfo;
    }

    /* renamed from: component4, reason: from getter */
    public final boolean getIsRefundAvailable() {
        return this.isRefundAvailable;
    }

    /* renamed from: component5, reason: from getter */
    public final PriceTotal getOrderTotal() {
        return this.orderTotal;
    }

    /* renamed from: component6, reason: from getter */
    public final PriceWithCurrency getRefundAmount() {
        return this.refundAmount;
    }

    /* renamed from: component7, reason: from getter */
    public final PriceWithCurrency getRefundFee() {
        return this.refundFee;
    }

    /* renamed from: component8, reason: from getter */
    public final LocalDate getRefundDate() {
        return this.refundDate;
    }

    /* renamed from: component9, reason: from getter */
    public final boolean getRefunded() {
        return this.refunded;
    }

    public final Booking copy(AuthenticationInfo authenticationInfo, boolean canChange, CustomerInfo customerInfo, boolean isRefundAvailable, PriceTotal orderTotal, PriceWithCurrency refundAmount, PriceWithCurrency refundFee, LocalDate refundDate, boolean refunded, String reservationNumber, BookingTicket ticket, boolean isUsed, Site site, MultiRideInfo multiRideInfo, String commuteAgreementId) {
        Intrinsics.checkNotNullParameter(authenticationInfo, "authenticationInfo");
        Intrinsics.checkNotNullParameter(customerInfo, "customerInfo");
        Intrinsics.checkNotNullParameter(orderTotal, "orderTotal");
        Intrinsics.checkNotNullParameter(reservationNumber, "reservationNumber");
        Intrinsics.checkNotNullParameter(ticket, "ticket");
        Intrinsics.checkNotNullParameter(site, "site");
        return new Booking(authenticationInfo, canChange, customerInfo, isRefundAvailable, orderTotal, refundAmount, refundFee, refundDate, refunded, reservationNumber, ticket, isUsed, site, multiRideInfo, commuteAgreementId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Booking)) {
            return false;
        }
        Booking booking = (Booking) other;
        return Intrinsics.areEqual(this.authenticationInfo, booking.authenticationInfo) && this.canChange == booking.canChange && Intrinsics.areEqual(this.customerInfo, booking.customerInfo) && this.isRefundAvailable == booking.isRefundAvailable && Intrinsics.areEqual(this.orderTotal, booking.orderTotal) && Intrinsics.areEqual(this.refundAmount, booking.refundAmount) && Intrinsics.areEqual(this.refundFee, booking.refundFee) && Intrinsics.areEqual(this.refundDate, booking.refundDate) && this.refunded == booking.refunded && Intrinsics.areEqual(this.reservationNumber, booking.reservationNumber) && Intrinsics.areEqual(this.ticket, booking.ticket) && this.isUsed == booking.isUsed && this.site == booking.site && Intrinsics.areEqual(this.multiRideInfo, booking.multiRideInfo) && Intrinsics.areEqual(this.commuteAgreementId, booking.commuteAgreementId);
    }

    public final AuthenticationInfo getAuthenticationInfo() {
        return this.authenticationInfo;
    }

    public final boolean getCanChange() {
        return this.canChange;
    }

    public final String getCommuteAgreementId() {
        return this.commuteAgreementId;
    }

    public final CustomerInfo getCustomerInfo() {
        return this.customerInfo;
    }

    public final MultiRideInfo getMultiRideInfo() {
        return this.multiRideInfo;
    }

    public final PriceTotal getOrderTotal() {
        return this.orderTotal;
    }

    public final PriceWithCurrency getRefundAmount() {
        return this.refundAmount;
    }

    public final LocalDate getRefundDate() {
        return this.refundDate;
    }

    public final PriceWithCurrency getRefundFee() {
        return this.refundFee;
    }

    public final boolean getRefunded() {
        return this.refunded;
    }

    public final String getReservationNumber() {
        return this.reservationNumber;
    }

    public final Site getSite() {
        return this.site;
    }

    public final BookingTicket getTicket() {
        return this.ticket;
    }

    public int hashCode() {
        int hashCode = ((((((((this.authenticationInfo.hashCode() * 31) + Boolean.hashCode(this.canChange)) * 31) + this.customerInfo.hashCode()) * 31) + Boolean.hashCode(this.isRefundAvailable)) * 31) + this.orderTotal.hashCode()) * 31;
        PriceWithCurrency priceWithCurrency = this.refundAmount;
        int hashCode2 = (hashCode + (priceWithCurrency == null ? 0 : priceWithCurrency.hashCode())) * 31;
        PriceWithCurrency priceWithCurrency2 = this.refundFee;
        int hashCode3 = (hashCode2 + (priceWithCurrency2 == null ? 0 : priceWithCurrency2.hashCode())) * 31;
        LocalDate localDate = this.refundDate;
        int hashCode4 = (((((((((((hashCode3 + (localDate == null ? 0 : localDate.hashCode())) * 31) + Boolean.hashCode(this.refunded)) * 31) + this.reservationNumber.hashCode()) * 31) + this.ticket.hashCode()) * 31) + Boolean.hashCode(this.isUsed)) * 31) + this.site.hashCode()) * 31;
        MultiRideInfo multiRideInfo = this.multiRideInfo;
        int hashCode5 = (hashCode4 + (multiRideInfo == null ? 0 : multiRideInfo.hashCode())) * 31;
        String str = this.commuteAgreementId;
        return hashCode5 + (str != null ? str.hashCode() : 0);
    }

    public final boolean isActive() {
        return LocalDateTime.of(this.ticket.getDeparture().getDate(), this.ticket.getDeparture().getArrivalTime()).isAfter(LocalDateTime.now()) && !this.refunded;
    }

    public final boolean isRefundAvailable() {
        return this.isRefundAvailable;
    }

    public final boolean isUsed() {
        return this.isUsed;
    }

    public String toString() {
        return "Booking(authenticationInfo=" + this.authenticationInfo + ", canChange=" + this.canChange + ", customerInfo=" + this.customerInfo + ", isRefundAvailable=" + this.isRefundAvailable + ", orderTotal=" + this.orderTotal + ", refundAmount=" + this.refundAmount + ", refundFee=" + this.refundFee + ", refundDate=" + this.refundDate + ", refunded=" + this.refunded + ", reservationNumber=" + this.reservationNumber + ", ticket=" + this.ticket + ", isUsed=" + this.isUsed + ", site=" + this.site + ", multiRideInfo=" + this.multiRideInfo + ", commuteAgreementId=" + this.commuteAgreementId + ")";
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Booking(BookingResponseDTO dto, Site site, List<Transportation> list) {
        this(r2, r3, r4, r5, r0, r7, r10, r9, r13, r11, r12, r15, site, r6 != null ? new MultiRideInfo(r6) : null, dto.getAuthenticationInfo().getCommuteAgreement().getAgreementId());
        Intrinsics.checkNotNullParameter(dto, "dto");
        Intrinsics.checkNotNullParameter(site, "site");
        AuthenticationInfo authenticationInfo = new AuthenticationInfo(dto.getAuthenticationInfo(), dto.getMultiRideInfo());
        boolean canChange = dto.getCanChange();
        CustomerInfo customerInfo = new CustomerInfo(dto.getCustomerInfo());
        boolean isRefundAvailable = dto.isRefundAvailable();
        PriceTotal priceTotal = dto.getMultiRideInfo() != null ? new PriceTotal(new PriceWithCurrency(dto.getOrderTotal()), new Price.Charge(1), false, 4, null) : new PriceTotal(new PriceWithCurrency(dto.getOrderTotal()));
        PriceWithCurrencyDTO refundAmount = dto.getRefundAmount();
        PriceWithCurrency priceWithCurrency = refundAmount != null ? new PriceWithCurrency(refundAmount) : null;
        PriceWithCurrencyDTO refundFee = dto.getRefundFee();
        PriceWithCurrency priceWithCurrency2 = refundFee != null ? new PriceWithCurrency(refundFee) : null;
        String reservationNumber = dto.getReservationNumber();
        BookingTicket bookingTicket = new BookingTicket((BookingResponseDTO.TicketResponseDTO) CollectionsKt.first((List) dto.getTickets()), dto.getMultiRideInfo() != null, list);
        LocalDate refundDate = dto.getRefundDate();
        boolean isRefunded = dto.isRefunded();
        boolean isUsed = dto.isUsed();
        BookingResponseDTO.MultiRideInfoResponseDTO multiRideInfo = dto.getMultiRideInfo();
    }
}
