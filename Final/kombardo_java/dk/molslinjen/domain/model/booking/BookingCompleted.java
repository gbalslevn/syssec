package dk.molslinjen.domain.model.booking;

import dk.molslinjen.api.services.booking.response.booking.BookingCompletedResponseDTO;
import dk.molslinjen.api.services.multiRide.response.MultiRidePurchaseResponseDTO;
import dk.molslinjen.api.services.payment.response.CreatePaymentResponseDTO;
import dk.molslinjen.core.extensions.StringExtensionsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0007HÆ\u0003J3\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001c"}, d2 = {"Ldk/molslinjen/domain/model/booking/BookingCompleted;", BuildConfig.FLAVOR, "outboundReservationNumber", BuildConfig.FLAVOR, "paymentWindowUrl", "fallbackPaymentWindowUrl", "bookingProcessingResult", "Ldk/molslinjen/domain/model/booking/BookingProcessingResult;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ldk/molslinjen/domain/model/booking/BookingProcessingResult;)V", "getOutboundReservationNumber", "()Ljava/lang/String;", "getPaymentWindowUrl", "getFallbackPaymentWindowUrl", "getBookingProcessingResult", "()Ldk/molslinjen/domain/model/booking/BookingProcessingResult;", "component1", "component2", "component3", "component4", "copy", "equals", BuildConfig.FLAVOR, "other", "hashCode", BuildConfig.FLAVOR, "toString", "Companion", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class BookingCompleted {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final BookingProcessingResult bookingProcessingResult;
    private final String fallbackPaymentWindowUrl;
    private final String outboundReservationNumber;
    private final String paymentWindowUrl;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0011\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0086\u0002J\u0011\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\bH\u0086\u0002J\u0019\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0086\u0002¨\u0006\f"}, d2 = {"Ldk/molslinjen/domain/model/booking/BookingCompleted$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "invoke", "Ldk/molslinjen/domain/model/booking/BookingCompleted;", "dto", "Ldk/molslinjen/api/services/booking/response/booking/BookingCompletedResponseDTO;", "Ldk/molslinjen/api/services/multiRide/response/MultiRidePurchaseResponseDTO;", "Ldk/molslinjen/api/services/payment/response/CreatePaymentResponseDTO;", "orderId", BuildConfig.FLAVOR, "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final BookingCompleted invoke(BookingCompletedResponseDTO dto) {
            Intrinsics.checkNotNullParameter(dto, "dto");
            String nullIfEmpty = StringExtensionsKt.nullIfEmpty(dto.getAppRedirectUrl());
            return new BookingCompleted(dto.getOrderId(), nullIfEmpty == null ? dto.getPaymentWindowUrl() : nullIfEmpty, nullIfEmpty != null ? dto.getPaymentWindowUrl() : null, BookingProcessingResult.INSTANCE.invoke(dto.getBookingProcessingResult()));
        }

        private Companion() {
        }

        public final BookingCompleted invoke(MultiRidePurchaseResponseDTO dto) {
            Intrinsics.checkNotNullParameter(dto, "dto");
            String nullIfEmpty = StringExtensionsKt.nullIfEmpty(dto.getAppUrl());
            return new BookingCompleted(dto.getOrderId(), nullIfEmpty == null ? dto.getUrl() : nullIfEmpty, nullIfEmpty != null ? dto.getUrl() : null, BookingProcessingResult.Pay);
        }

        public final BookingCompleted invoke(CreatePaymentResponseDTO dto, String orderId) {
            Intrinsics.checkNotNullParameter(dto, "dto");
            Intrinsics.checkNotNullParameter(orderId, "orderId");
            String nullIfEmpty = StringExtensionsKt.nullIfEmpty(dto.getAppUrl());
            return new BookingCompleted(orderId, nullIfEmpty == null ? dto.getUrl() : nullIfEmpty, nullIfEmpty != null ? dto.getUrl() : null, BookingProcessingResult.Pay);
        }
    }

    public BookingCompleted(String outboundReservationNumber, String paymentWindowUrl, String str, BookingProcessingResult bookingProcessingResult) {
        Intrinsics.checkNotNullParameter(outboundReservationNumber, "outboundReservationNumber");
        Intrinsics.checkNotNullParameter(paymentWindowUrl, "paymentWindowUrl");
        Intrinsics.checkNotNullParameter(bookingProcessingResult, "bookingProcessingResult");
        this.outboundReservationNumber = outboundReservationNumber;
        this.paymentWindowUrl = paymentWindowUrl;
        this.fallbackPaymentWindowUrl = str;
        this.bookingProcessingResult = bookingProcessingResult;
    }

    public static /* synthetic */ BookingCompleted copy$default(BookingCompleted bookingCompleted, String str, String str2, String str3, BookingProcessingResult bookingProcessingResult, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            str = bookingCompleted.outboundReservationNumber;
        }
        if ((i5 & 2) != 0) {
            str2 = bookingCompleted.paymentWindowUrl;
        }
        if ((i5 & 4) != 0) {
            str3 = bookingCompleted.fallbackPaymentWindowUrl;
        }
        if ((i5 & 8) != 0) {
            bookingProcessingResult = bookingCompleted.bookingProcessingResult;
        }
        return bookingCompleted.copy(str, str2, str3, bookingProcessingResult);
    }

    /* renamed from: component1, reason: from getter */
    public final String getOutboundReservationNumber() {
        return this.outboundReservationNumber;
    }

    /* renamed from: component2, reason: from getter */
    public final String getPaymentWindowUrl() {
        return this.paymentWindowUrl;
    }

    /* renamed from: component3, reason: from getter */
    public final String getFallbackPaymentWindowUrl() {
        return this.fallbackPaymentWindowUrl;
    }

    /* renamed from: component4, reason: from getter */
    public final BookingProcessingResult getBookingProcessingResult() {
        return this.bookingProcessingResult;
    }

    public final BookingCompleted copy(String outboundReservationNumber, String paymentWindowUrl, String fallbackPaymentWindowUrl, BookingProcessingResult bookingProcessingResult) {
        Intrinsics.checkNotNullParameter(outboundReservationNumber, "outboundReservationNumber");
        Intrinsics.checkNotNullParameter(paymentWindowUrl, "paymentWindowUrl");
        Intrinsics.checkNotNullParameter(bookingProcessingResult, "bookingProcessingResult");
        return new BookingCompleted(outboundReservationNumber, paymentWindowUrl, fallbackPaymentWindowUrl, bookingProcessingResult);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BookingCompleted)) {
            return false;
        }
        BookingCompleted bookingCompleted = (BookingCompleted) other;
        return Intrinsics.areEqual(this.outboundReservationNumber, bookingCompleted.outboundReservationNumber) && Intrinsics.areEqual(this.paymentWindowUrl, bookingCompleted.paymentWindowUrl) && Intrinsics.areEqual(this.fallbackPaymentWindowUrl, bookingCompleted.fallbackPaymentWindowUrl) && this.bookingProcessingResult == bookingCompleted.bookingProcessingResult;
    }

    public final BookingProcessingResult getBookingProcessingResult() {
        return this.bookingProcessingResult;
    }

    public final String getFallbackPaymentWindowUrl() {
        return this.fallbackPaymentWindowUrl;
    }

    public final String getOutboundReservationNumber() {
        return this.outboundReservationNumber;
    }

    public final String getPaymentWindowUrl() {
        return this.paymentWindowUrl;
    }

    public int hashCode() {
        int hashCode = ((this.outboundReservationNumber.hashCode() * 31) + this.paymentWindowUrl.hashCode()) * 31;
        String str = this.fallbackPaymentWindowUrl;
        return ((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.bookingProcessingResult.hashCode();
    }

    public String toString() {
        return "BookingCompleted(outboundReservationNumber=" + this.outboundReservationNumber + ", paymentWindowUrl=" + this.paymentWindowUrl + ", fallbackPaymentWindowUrl=" + this.fallbackPaymentWindowUrl + ", bookingProcessingResult=" + this.bookingProcessingResult + ")";
    }

    public /* synthetic */ BookingCompleted(String str, String str2, String str3, BookingProcessingResult bookingProcessingResult, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i5 & 4) != 0 ? null : str3, bookingProcessingResult);
    }
}
