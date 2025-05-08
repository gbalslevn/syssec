package dk.molslinjen.api.services.payment.response;

import com.sun.jna.Function;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import org.conscrypt.BuildConfig;
import org.threeten.bp.LocalDate;
import org.threeten.bp.format.DateTimeFormatterBuilder;
import org.threeten.bp.temporal.ChronoField;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 52\u00020\u0001:\u000245BS\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\f\u0010\rBg\b\u0010\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\f\u0010\u0012J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0007HÆ\u0003J\t\u0010#\u001a\u00020\u0007HÆ\u0003J\u000b\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003Je\u0010'\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010(\u001a\u00020\u00072\b\u0010)\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010*\u001a\u00020\u000fHÖ\u0001J\t\u0010+\u001a\u00020\u0003HÖ\u0001J%\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\u00002\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u000202H\u0001¢\u0006\u0002\b3R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0017R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0017R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0014R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0014R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0014R\u0011\u0010\u001b\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u0014R\u0011\u0010\u001d\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u0014¨\u00066"}, d2 = {"Ldk/molslinjen/api/services/payment/response/PaymentStatusResponseDTO;", BuildConfig.FLAVOR, "cardExpiryDate", BuildConfig.FLAVOR, "cardNumber", "creditCardToken", "isCompleted", BuildConfig.FLAVOR, "isPending", "paymentId", "paymentType", "transactionId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "seen0", BuildConfig.FLAVOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getCardExpiryDate", "()Ljava/lang/String;", "getCardNumber", "getCreditCardToken", "()Z", "getPaymentId", "getPaymentType", "getTransactionId", "expirationMonth", "getExpirationMonth", "expirationYear", "getExpirationYear", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "hashCode", "toString", "write$Self", BuildConfig.FLAVOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$api_kombardoProd", "$serializer", "Companion", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
/* loaded from: classes2.dex */
public final /* data */ class PaymentStatusResponseDTO {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String cardExpiryDate;
    private final String cardNumber;
    private final String creditCardToken;
    private final boolean isCompleted;
    private final boolean isPending;
    private final String paymentId;
    private final String paymentType;
    private final String transactionId;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Ldk/molslinjen/api/services/payment/response/PaymentStatusResponseDTO$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldk/molslinjen/api/services/payment/response/PaymentStatusResponseDTO;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public final KSerializer<PaymentStatusResponseDTO> serializer() {
            return PaymentStatusResponseDTO$$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public /* synthetic */ PaymentStatusResponseDTO(int i5, String str, String str2, String str3, boolean z5, boolean z6, String str4, String str5, String str6, SerializationConstructorMarker serializationConstructorMarker) {
        if (255 != (i5 & Function.USE_VARARGS)) {
            PluginExceptionsKt.throwMissingFieldException(i5, Function.USE_VARARGS, PaymentStatusResponseDTO$$serializer.INSTANCE.getDescriptor());
        }
        this.cardExpiryDate = str;
        this.cardNumber = str2;
        this.creditCardToken = str3;
        this.isCompleted = z5;
        this.isPending = z6;
        this.paymentId = str4;
        this.paymentType = str5;
        this.transactionId = str6;
    }

    public static final /* synthetic */ void write$Self$api_kombardoProd(PaymentStatusResponseDTO self, CompositeEncoder output, SerialDescriptor serialDesc) {
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        output.encodeNullableSerializableElement(serialDesc, 0, stringSerializer, self.cardExpiryDate);
        output.encodeNullableSerializableElement(serialDesc, 1, stringSerializer, self.cardNumber);
        output.encodeNullableSerializableElement(serialDesc, 2, stringSerializer, self.creditCardToken);
        output.encodeBooleanElement(serialDesc, 3, self.isCompleted);
        output.encodeBooleanElement(serialDesc, 4, self.isPending);
        output.encodeNullableSerializableElement(serialDesc, 5, stringSerializer, self.paymentId);
        output.encodeNullableSerializableElement(serialDesc, 6, stringSerializer, self.paymentType);
        output.encodeNullableSerializableElement(serialDesc, 7, stringSerializer, self.transactionId);
    }

    /* renamed from: component1, reason: from getter */
    public final String getCardExpiryDate() {
        return this.cardExpiryDate;
    }

    /* renamed from: component2, reason: from getter */
    public final String getCardNumber() {
        return this.cardNumber;
    }

    /* renamed from: component3, reason: from getter */
    public final String getCreditCardToken() {
        return this.creditCardToken;
    }

    /* renamed from: component4, reason: from getter */
    public final boolean getIsCompleted() {
        return this.isCompleted;
    }

    /* renamed from: component5, reason: from getter */
    public final boolean getIsPending() {
        return this.isPending;
    }

    /* renamed from: component6, reason: from getter */
    public final String getPaymentId() {
        return this.paymentId;
    }

    /* renamed from: component7, reason: from getter */
    public final String getPaymentType() {
        return this.paymentType;
    }

    /* renamed from: component8, reason: from getter */
    public final String getTransactionId() {
        return this.transactionId;
    }

    public final PaymentStatusResponseDTO copy(String cardExpiryDate, String cardNumber, String creditCardToken, boolean isCompleted, boolean isPending, String paymentId, String paymentType, String transactionId) {
        return new PaymentStatusResponseDTO(cardExpiryDate, cardNumber, creditCardToken, isCompleted, isPending, paymentId, paymentType, transactionId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PaymentStatusResponseDTO)) {
            return false;
        }
        PaymentStatusResponseDTO paymentStatusResponseDTO = (PaymentStatusResponseDTO) other;
        return Intrinsics.areEqual(this.cardExpiryDate, paymentStatusResponseDTO.cardExpiryDate) && Intrinsics.areEqual(this.cardNumber, paymentStatusResponseDTO.cardNumber) && Intrinsics.areEqual(this.creditCardToken, paymentStatusResponseDTO.creditCardToken) && this.isCompleted == paymentStatusResponseDTO.isCompleted && this.isPending == paymentStatusResponseDTO.isPending && Intrinsics.areEqual(this.paymentId, paymentStatusResponseDTO.paymentId) && Intrinsics.areEqual(this.paymentType, paymentStatusResponseDTO.paymentType) && Intrinsics.areEqual(this.transactionId, paymentStatusResponseDTO.transactionId);
    }

    public final String getCardExpiryDate() {
        return this.cardExpiryDate;
    }

    public final String getCardNumber() {
        return this.cardNumber;
    }

    public final String getCreditCardToken() {
        return this.creditCardToken;
    }

    public final String getExpirationMonth() {
        return String.valueOf(LocalDate.parse(this.cardExpiryDate, new DateTimeFormatterBuilder().appendPattern("M/yyyy").parseDefaulting(ChronoField.DAY_OF_MONTH, 1L).toFormatter()).plusMonths(1L).getMonth().getValue());
    }

    public final String getExpirationYear() {
        return String.valueOf(LocalDate.parse(this.cardExpiryDate, new DateTimeFormatterBuilder().appendPattern("M/yyyy").parseDefaulting(ChronoField.DAY_OF_MONTH, 1L).toFormatter()).plusMonths(1L).getYear());
    }

    public final String getPaymentId() {
        return this.paymentId;
    }

    public final String getPaymentType() {
        return this.paymentType;
    }

    public final String getTransactionId() {
        return this.transactionId;
    }

    public int hashCode() {
        String str = this.cardExpiryDate;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.cardNumber;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.creditCardToken;
        int hashCode3 = (((((hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31) + Boolean.hashCode(this.isCompleted)) * 31) + Boolean.hashCode(this.isPending)) * 31;
        String str4 = this.paymentId;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.paymentType;
        int hashCode5 = (hashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.transactionId;
        return hashCode5 + (str6 != null ? str6.hashCode() : 0);
    }

    public final boolean isCompleted() {
        return this.isCompleted;
    }

    public final boolean isPending() {
        return this.isPending;
    }

    public String toString() {
        return "PaymentStatusResponseDTO(cardExpiryDate=" + this.cardExpiryDate + ", cardNumber=" + this.cardNumber + ", creditCardToken=" + this.creditCardToken + ", isCompleted=" + this.isCompleted + ", isPending=" + this.isPending + ", paymentId=" + this.paymentId + ", paymentType=" + this.paymentType + ", transactionId=" + this.transactionId + ")";
    }

    public PaymentStatusResponseDTO(String str, String str2, String str3, boolean z5, boolean z6, String str4, String str5, String str6) {
        this.cardExpiryDate = str;
        this.cardNumber = str2;
        this.creditCardToken = str3;
        this.isCompleted = z5;
        this.isPending = z6;
        this.paymentId = str4;
        this.paymentType = str5;
        this.transactionId = str6;
    }
}
