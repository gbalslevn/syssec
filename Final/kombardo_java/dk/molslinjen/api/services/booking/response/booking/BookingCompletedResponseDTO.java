package dk.molslinjen.api.services.booking.response.booking;

import dk.molslinjen.api.helpers.serializers.IntToEnumSerializer;
import dk.molslinjen.api.helpers.serializers.SerializableEnum;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0087\b\u0018\u0000 +2\u00020\u0001:\u0003)*+B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tBC\b\u0010\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\b\u0010\u000eJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0007HÆ\u0003J1\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020\u000bHÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001J%\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u00002\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'H\u0001¢\u0006\u0002\b(R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0010R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006,"}, d2 = {"Ldk/molslinjen/api/services/booking/response/booking/BookingCompletedResponseDTO;", BuildConfig.FLAVOR, "orderId", BuildConfig.FLAVOR, "paymentWindowUrl", "appRedirectUrl", "bookingProcessingResult", "Ldk/molslinjen/api/services/booking/response/booking/BookingCompletedResponseDTO$BookingProcessingResultResponseDTO;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ldk/molslinjen/api/services/booking/response/booking/BookingCompletedResponseDTO$BookingProcessingResultResponseDTO;)V", "seen0", BuildConfig.FLAVOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ldk/molslinjen/api/services/booking/response/booking/BookingCompletedResponseDTO$BookingProcessingResultResponseDTO;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getOrderId", "()Ljava/lang/String;", "getPaymentWindowUrl$annotations", "()V", "getPaymentWindowUrl", "getAppRedirectUrl", "getBookingProcessingResult", "()Ldk/molslinjen/api/services/booking/response/booking/BookingCompletedResponseDTO$BookingProcessingResultResponseDTO;", "component1", "component2", "component3", "component4", "copy", "equals", BuildConfig.FLAVOR, "other", "hashCode", "toString", "write$Self", BuildConfig.FLAVOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$api_kombardoProd", "BookingProcessingResultResponseDTO", "$serializer", "Companion", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
/* loaded from: classes2.dex */
public final /* data */ class BookingCompletedResponseDTO {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String appRedirectUrl;
    private final BookingProcessingResultResponseDTO bookingProcessingResult;
    private final String orderId;
    private final String paymentWindowUrl;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0087\u0081\u0002\u0018\u0000 \f2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0002\u000b\fB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\n¨\u0006\r"}, d2 = {"Ldk/molslinjen/api/services/booking/response/booking/BookingCompletedResponseDTO$BookingProcessingResultResponseDTO;", "Ldk/molslinjen/api/helpers/serializers/SerializableEnum;", BuildConfig.FLAVOR, "rawValue", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;II)V", "getRawValue", "()I", "Pay", "Free", "Serializer", "Companion", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @Serializable(with = Serializer.class)
    /* loaded from: classes2.dex */
    public static final class BookingProcessingResultResponseDTO implements SerializableEnum {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ BookingProcessingResultResponseDTO[] $VALUES;

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE;
        private final int rawValue;
        public static final BookingProcessingResultResponseDTO Pay = new BookingProcessingResultResponseDTO("Pay", 0, 0);
        public static final BookingProcessingResultResponseDTO Free = new BookingProcessingResultResponseDTO("Free", 1, 1);

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Ldk/molslinjen/api/services/booking/response/booking/BookingCompletedResponseDTO$BookingProcessingResultResponseDTO$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldk/molslinjen/api/services/booking/response/booking/BookingCompletedResponseDTO$BookingProcessingResultResponseDTO;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes2.dex */
        public static final class Companion {
            private Companion() {
            }

            public final KSerializer<BookingProcessingResultResponseDTO> serializer() {
                return Serializer.INSTANCE;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Ldk/molslinjen/api/services/booking/response/booking/BookingCompletedResponseDTO$BookingProcessingResultResponseDTO$Serializer;", "Ldk/molslinjen/api/helpers/serializers/IntToEnumSerializer;", "Ldk/molslinjen/api/services/booking/response/booking/BookingCompletedResponseDTO$BookingProcessingResultResponseDTO;", "<init>", "()V", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes2.dex */
        public static final class Serializer extends IntToEnumSerializer<BookingProcessingResultResponseDTO> {
            public static final Serializer INSTANCE = new Serializer();

            private Serializer() {
                super(BookingProcessingResultResponseDTO.class);
            }
        }

        private static final /* synthetic */ BookingProcessingResultResponseDTO[] $values() {
            return new BookingProcessingResultResponseDTO[]{Pay, Free};
        }

        static {
            BookingProcessingResultResponseDTO[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
            INSTANCE = new Companion(null);
        }

        private BookingProcessingResultResponseDTO(String str, int i5, int i6) {
            this.rawValue = i6;
        }

        public static EnumEntries<BookingProcessingResultResponseDTO> getEntries() {
            return $ENTRIES;
        }

        public static BookingProcessingResultResponseDTO valueOf(String str) {
            return (BookingProcessingResultResponseDTO) Enum.valueOf(BookingProcessingResultResponseDTO.class, str);
        }

        public static BookingProcessingResultResponseDTO[] values() {
            return (BookingProcessingResultResponseDTO[]) $VALUES.clone();
        }

        @Override // dk.molslinjen.api.helpers.serializers.SerializableEnum
        public int getRawValue() {
            return this.rawValue;
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Ldk/molslinjen/api/services/booking/response/booking/BookingCompletedResponseDTO$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldk/molslinjen/api/services/booking/response/booking/BookingCompletedResponseDTO;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public final KSerializer<BookingCompletedResponseDTO> serializer() {
            return BookingCompletedResponseDTO$$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public /* synthetic */ BookingCompletedResponseDTO(int i5, String str, String str2, String str3, BookingProcessingResultResponseDTO bookingProcessingResultResponseDTO, SerializationConstructorMarker serializationConstructorMarker) {
        if (15 != (i5 & 15)) {
            PluginExceptionsKt.throwMissingFieldException(i5, 15, BookingCompletedResponseDTO$$serializer.INSTANCE.getDescriptor());
        }
        this.orderId = str;
        this.paymentWindowUrl = str2;
        this.appRedirectUrl = str3;
        this.bookingProcessingResult = bookingProcessingResultResponseDTO;
    }

    public static /* synthetic */ BookingCompletedResponseDTO copy$default(BookingCompletedResponseDTO bookingCompletedResponseDTO, String str, String str2, String str3, BookingProcessingResultResponseDTO bookingProcessingResultResponseDTO, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            str = bookingCompletedResponseDTO.orderId;
        }
        if ((i5 & 2) != 0) {
            str2 = bookingCompletedResponseDTO.paymentWindowUrl;
        }
        if ((i5 & 4) != 0) {
            str3 = bookingCompletedResponseDTO.appRedirectUrl;
        }
        if ((i5 & 8) != 0) {
            bookingProcessingResultResponseDTO = bookingCompletedResponseDTO.bookingProcessingResult;
        }
        return bookingCompletedResponseDTO.copy(str, str2, str3, bookingProcessingResultResponseDTO);
    }

    public static /* synthetic */ void getPaymentWindowUrl$annotations() {
    }

    public static final /* synthetic */ void write$Self$api_kombardoProd(BookingCompletedResponseDTO self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeStringElement(serialDesc, 0, self.orderId);
        output.encodeStringElement(serialDesc, 1, self.paymentWindowUrl);
        output.encodeStringElement(serialDesc, 2, self.appRedirectUrl);
        output.encodeSerializableElement(serialDesc, 3, BookingProcessingResultResponseDTO.Serializer.INSTANCE, self.bookingProcessingResult);
    }

    /* renamed from: component1, reason: from getter */
    public final String getOrderId() {
        return this.orderId;
    }

    /* renamed from: component2, reason: from getter */
    public final String getPaymentWindowUrl() {
        return this.paymentWindowUrl;
    }

    /* renamed from: component3, reason: from getter */
    public final String getAppRedirectUrl() {
        return this.appRedirectUrl;
    }

    /* renamed from: component4, reason: from getter */
    public final BookingProcessingResultResponseDTO getBookingProcessingResult() {
        return this.bookingProcessingResult;
    }

    public final BookingCompletedResponseDTO copy(String orderId, String paymentWindowUrl, String appRedirectUrl, BookingProcessingResultResponseDTO bookingProcessingResult) {
        Intrinsics.checkNotNullParameter(orderId, "orderId");
        Intrinsics.checkNotNullParameter(paymentWindowUrl, "paymentWindowUrl");
        Intrinsics.checkNotNullParameter(appRedirectUrl, "appRedirectUrl");
        Intrinsics.checkNotNullParameter(bookingProcessingResult, "bookingProcessingResult");
        return new BookingCompletedResponseDTO(orderId, paymentWindowUrl, appRedirectUrl, bookingProcessingResult);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BookingCompletedResponseDTO)) {
            return false;
        }
        BookingCompletedResponseDTO bookingCompletedResponseDTO = (BookingCompletedResponseDTO) other;
        return Intrinsics.areEqual(this.orderId, bookingCompletedResponseDTO.orderId) && Intrinsics.areEqual(this.paymentWindowUrl, bookingCompletedResponseDTO.paymentWindowUrl) && Intrinsics.areEqual(this.appRedirectUrl, bookingCompletedResponseDTO.appRedirectUrl) && this.bookingProcessingResult == bookingCompletedResponseDTO.bookingProcessingResult;
    }

    public final String getAppRedirectUrl() {
        return this.appRedirectUrl;
    }

    public final BookingProcessingResultResponseDTO getBookingProcessingResult() {
        return this.bookingProcessingResult;
    }

    public final String getOrderId() {
        return this.orderId;
    }

    public final String getPaymentWindowUrl() {
        return this.paymentWindowUrl;
    }

    public int hashCode() {
        return (((((this.orderId.hashCode() * 31) + this.paymentWindowUrl.hashCode()) * 31) + this.appRedirectUrl.hashCode()) * 31) + this.bookingProcessingResult.hashCode();
    }

    public String toString() {
        return "BookingCompletedResponseDTO(orderId=" + this.orderId + ", paymentWindowUrl=" + this.paymentWindowUrl + ", appRedirectUrl=" + this.appRedirectUrl + ", bookingProcessingResult=" + this.bookingProcessingResult + ")";
    }

    public BookingCompletedResponseDTO(String orderId, String paymentWindowUrl, String appRedirectUrl, BookingProcessingResultResponseDTO bookingProcessingResult) {
        Intrinsics.checkNotNullParameter(orderId, "orderId");
        Intrinsics.checkNotNullParameter(paymentWindowUrl, "paymentWindowUrl");
        Intrinsics.checkNotNullParameter(appRedirectUrl, "appRedirectUrl");
        Intrinsics.checkNotNullParameter(bookingProcessingResult, "bookingProcessingResult");
        this.orderId = orderId;
        this.paymentWindowUrl = paymentWindowUrl;
        this.appRedirectUrl = appRedirectUrl;
        this.bookingProcessingResult = bookingProcessingResult;
    }
}
