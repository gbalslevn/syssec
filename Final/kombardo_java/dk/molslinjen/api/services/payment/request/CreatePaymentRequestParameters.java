package dk.molslinjen.api.services.payment.request;

import dk.molslinjen.api.services.payment.request.PaymentProductTypeDTO;
import dk.molslinjen.api.services.payment.request.PaymentSourceDTO;
import dk.molslinjen.api.services.paymentTypes.response.PaymentTypeDTO;
import dk.molslinjen.api.shared.response.CurrencyTypeDTO;
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

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b$\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 L2\u00020\u0001:\u0002KLBq\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0005\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0005\u0012\u0006\u0010\u0013\u001a\u00020\u0003\u0012\u0006\u0010\u0014\u001a\u00020\u0015¢\u0006\u0004\b\u0016\u0010\u0017B\u0099\u0001\b\u0010\u0012\u0006\u0010\u0018\u001a\u00020\u0003\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0013\u001a\u00020\u0003\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a¢\u0006\u0004\b\u0016\u0010\u001bJ\t\u00100\u001a\u00020\u0003HÆ\u0003J\t\u00101\u001a\u00020\u0005HÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u00103\u001a\u00020\bHÆ\u0003J\t\u00104\u001a\u00020\u0005HÆ\u0003J\t\u00105\u001a\u00020\u0005HÆ\u0003J\t\u00106\u001a\u00020\fHÆ\u0003J\t\u00107\u001a\u00020\u000eHÆ\u0003J\t\u00108\u001a\u00020\u0005HÆ\u0003J\t\u00109\u001a\u00020\u0011HÆ\u0003J\t\u0010:\u001a\u00020\u0005HÆ\u0003J\t\u0010;\u001a\u00020\u0003HÆ\u0003J\t\u0010<\u001a\u00020\u0015HÆ\u0003J\u008d\u0001\u0010=\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00052\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00052\b\b\u0002\u0010\u0013\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u0015HÆ\u0001J\u0013\u0010>\u001a\u00020?2\b\u0010@\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010A\u001a\u00020\u0003HÖ\u0001J\t\u0010B\u001a\u00020\u0005HÖ\u0001J%\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u00020\u00002\u0006\u0010F\u001a\u00020G2\u0006\u0010H\u001a\u00020IH\u0001¢\u0006\u0002\bJR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001fR\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001fR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0011\u0010\u000f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u001fR\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0011\u0010\u0012\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u001fR\u0011\u0010\u0013\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\u001dR\u0011\u0010\u0014\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/¨\u0006M"}, d2 = {"Ldk/molslinjen/api/services/payment/request/CreatePaymentRequestParameters;", BuildConfig.FLAVOR, "amount", BuildConfig.FLAVOR, "callbackFailUrl", BuildConfig.FLAVOR, "creditCardToken", "currency", "Ldk/molslinjen/api/shared/response/CurrencyTypeDTO;", "language", "orderNumber", "paymentType", "Ldk/molslinjen/api/services/paymentTypes/response/PaymentTypeDTO;", "productType", "Ldk/molslinjen/api/services/payment/request/PaymentProductTypeDTO;", "receiptUrl", "source", "Ldk/molslinjen/api/services/payment/request/PaymentSourceDTO;", "email", "paymentLine", "appPaymentRedirectDetails", "Ldk/molslinjen/api/services/payment/request/PaymentServiceAppPaymentRedirectDetailsDTO;", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ldk/molslinjen/api/shared/response/CurrencyTypeDTO;Ljava/lang/String;Ljava/lang/String;Ldk/molslinjen/api/services/paymentTypes/response/PaymentTypeDTO;Ldk/molslinjen/api/services/payment/request/PaymentProductTypeDTO;Ljava/lang/String;Ldk/molslinjen/api/services/payment/request/PaymentSourceDTO;Ljava/lang/String;ILdk/molslinjen/api/services/payment/request/PaymentServiceAppPaymentRedirectDetailsDTO;)V", "seen0", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IILjava/lang/String;Ljava/lang/String;Ldk/molslinjen/api/shared/response/CurrencyTypeDTO;Ljava/lang/String;Ljava/lang/String;Ldk/molslinjen/api/services/paymentTypes/response/PaymentTypeDTO;Ldk/molslinjen/api/services/payment/request/PaymentProductTypeDTO;Ljava/lang/String;Ldk/molslinjen/api/services/payment/request/PaymentSourceDTO;Ljava/lang/String;ILdk/molslinjen/api/services/payment/request/PaymentServiceAppPaymentRedirectDetailsDTO;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getAmount", "()I", "getCallbackFailUrl", "()Ljava/lang/String;", "getCreditCardToken", "getCurrency", "()Ldk/molslinjen/api/shared/response/CurrencyTypeDTO;", "getLanguage", "getOrderNumber", "getPaymentType", "()Ldk/molslinjen/api/services/paymentTypes/response/PaymentTypeDTO;", "getProductType", "()Ldk/molslinjen/api/services/payment/request/PaymentProductTypeDTO;", "getReceiptUrl", "getSource", "()Ldk/molslinjen/api/services/payment/request/PaymentSourceDTO;", "getEmail", "getPaymentLine", "getAppPaymentRedirectDetails", "()Ldk/molslinjen/api/services/payment/request/PaymentServiceAppPaymentRedirectDetailsDTO;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "copy", "equals", BuildConfig.FLAVOR, "other", "hashCode", "toString", "write$Self", BuildConfig.FLAVOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$api_kombardoProd", "$serializer", "Companion", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
/* loaded from: classes2.dex */
public final /* data */ class CreatePaymentRequestParameters {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final int amount;
    private final PaymentServiceAppPaymentRedirectDetailsDTO appPaymentRedirectDetails;
    private final String callbackFailUrl;
    private final String creditCardToken;
    private final CurrencyTypeDTO currency;
    private final String email;
    private final String language;
    private final String orderNumber;
    private final int paymentLine;
    private final PaymentTypeDTO paymentType;
    private final PaymentProductTypeDTO productType;
    private final String receiptUrl;
    private final PaymentSourceDTO source;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Ldk/molslinjen/api/services/payment/request/CreatePaymentRequestParameters$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldk/molslinjen/api/services/payment/request/CreatePaymentRequestParameters;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public final KSerializer<CreatePaymentRequestParameters> serializer() {
            return CreatePaymentRequestParameters$$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public /* synthetic */ CreatePaymentRequestParameters(int i5, int i6, String str, String str2, CurrencyTypeDTO currencyTypeDTO, String str3, String str4, PaymentTypeDTO paymentTypeDTO, PaymentProductTypeDTO paymentProductTypeDTO, String str5, PaymentSourceDTO paymentSourceDTO, String str6, int i7, PaymentServiceAppPaymentRedirectDetailsDTO paymentServiceAppPaymentRedirectDetailsDTO, SerializationConstructorMarker serializationConstructorMarker) {
        if (8191 != (i5 & 8191)) {
            PluginExceptionsKt.throwMissingFieldException(i5, 8191, CreatePaymentRequestParameters$$serializer.INSTANCE.getDescriptor());
        }
        this.amount = i6;
        this.callbackFailUrl = str;
        this.creditCardToken = str2;
        this.currency = currencyTypeDTO;
        this.language = str3;
        this.orderNumber = str4;
        this.paymentType = paymentTypeDTO;
        this.productType = paymentProductTypeDTO;
        this.receiptUrl = str5;
        this.source = paymentSourceDTO;
        this.email = str6;
        this.paymentLine = i7;
        this.appPaymentRedirectDetails = paymentServiceAppPaymentRedirectDetailsDTO;
    }

    public static final /* synthetic */ void write$Self$api_kombardoProd(CreatePaymentRequestParameters self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeIntElement(serialDesc, 0, self.amount);
        output.encodeStringElement(serialDesc, 1, self.callbackFailUrl);
        output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.creditCardToken);
        output.encodeSerializableElement(serialDesc, 3, CurrencyTypeDTO.Serializer.INSTANCE, self.currency);
        output.encodeStringElement(serialDesc, 4, self.language);
        output.encodeStringElement(serialDesc, 5, self.orderNumber);
        output.encodeSerializableElement(serialDesc, 6, PaymentTypeDTO.Serializer.INSTANCE, self.paymentType);
        output.encodeSerializableElement(serialDesc, 7, PaymentProductTypeDTO.Serializer.INSTANCE, self.productType);
        output.encodeStringElement(serialDesc, 8, self.receiptUrl);
        output.encodeSerializableElement(serialDesc, 9, PaymentSourceDTO.Serializer.INSTANCE, self.source);
        output.encodeStringElement(serialDesc, 10, self.email);
        output.encodeIntElement(serialDesc, 11, self.paymentLine);
        output.encodeSerializableElement(serialDesc, 12, PaymentServiceAppPaymentRedirectDetailsDTO$$serializer.INSTANCE, self.appPaymentRedirectDetails);
    }

    /* renamed from: component1, reason: from getter */
    public final int getAmount() {
        return this.amount;
    }

    /* renamed from: component10, reason: from getter */
    public final PaymentSourceDTO getSource() {
        return this.source;
    }

    /* renamed from: component11, reason: from getter */
    public final String getEmail() {
        return this.email;
    }

    /* renamed from: component12, reason: from getter */
    public final int getPaymentLine() {
        return this.paymentLine;
    }

    /* renamed from: component13, reason: from getter */
    public final PaymentServiceAppPaymentRedirectDetailsDTO getAppPaymentRedirectDetails() {
        return this.appPaymentRedirectDetails;
    }

    /* renamed from: component2, reason: from getter */
    public final String getCallbackFailUrl() {
        return this.callbackFailUrl;
    }

    /* renamed from: component3, reason: from getter */
    public final String getCreditCardToken() {
        return this.creditCardToken;
    }

    /* renamed from: component4, reason: from getter */
    public final CurrencyTypeDTO getCurrency() {
        return this.currency;
    }

    /* renamed from: component5, reason: from getter */
    public final String getLanguage() {
        return this.language;
    }

    /* renamed from: component6, reason: from getter */
    public final String getOrderNumber() {
        return this.orderNumber;
    }

    /* renamed from: component7, reason: from getter */
    public final PaymentTypeDTO getPaymentType() {
        return this.paymentType;
    }

    /* renamed from: component8, reason: from getter */
    public final PaymentProductTypeDTO getProductType() {
        return this.productType;
    }

    /* renamed from: component9, reason: from getter */
    public final String getReceiptUrl() {
        return this.receiptUrl;
    }

    public final CreatePaymentRequestParameters copy(int amount, String callbackFailUrl, String creditCardToken, CurrencyTypeDTO currency, String language, String orderNumber, PaymentTypeDTO paymentType, PaymentProductTypeDTO productType, String receiptUrl, PaymentSourceDTO source, String email, int paymentLine, PaymentServiceAppPaymentRedirectDetailsDTO appPaymentRedirectDetails) {
        Intrinsics.checkNotNullParameter(callbackFailUrl, "callbackFailUrl");
        Intrinsics.checkNotNullParameter(currency, "currency");
        Intrinsics.checkNotNullParameter(language, "language");
        Intrinsics.checkNotNullParameter(orderNumber, "orderNumber");
        Intrinsics.checkNotNullParameter(paymentType, "paymentType");
        Intrinsics.checkNotNullParameter(productType, "productType");
        Intrinsics.checkNotNullParameter(receiptUrl, "receiptUrl");
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(email, "email");
        Intrinsics.checkNotNullParameter(appPaymentRedirectDetails, "appPaymentRedirectDetails");
        return new CreatePaymentRequestParameters(amount, callbackFailUrl, creditCardToken, currency, language, orderNumber, paymentType, productType, receiptUrl, source, email, paymentLine, appPaymentRedirectDetails);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CreatePaymentRequestParameters)) {
            return false;
        }
        CreatePaymentRequestParameters createPaymentRequestParameters = (CreatePaymentRequestParameters) other;
        return this.amount == createPaymentRequestParameters.amount && Intrinsics.areEqual(this.callbackFailUrl, createPaymentRequestParameters.callbackFailUrl) && Intrinsics.areEqual(this.creditCardToken, createPaymentRequestParameters.creditCardToken) && this.currency == createPaymentRequestParameters.currency && Intrinsics.areEqual(this.language, createPaymentRequestParameters.language) && Intrinsics.areEqual(this.orderNumber, createPaymentRequestParameters.orderNumber) && this.paymentType == createPaymentRequestParameters.paymentType && this.productType == createPaymentRequestParameters.productType && Intrinsics.areEqual(this.receiptUrl, createPaymentRequestParameters.receiptUrl) && this.source == createPaymentRequestParameters.source && Intrinsics.areEqual(this.email, createPaymentRequestParameters.email) && this.paymentLine == createPaymentRequestParameters.paymentLine && Intrinsics.areEqual(this.appPaymentRedirectDetails, createPaymentRequestParameters.appPaymentRedirectDetails);
    }

    public final int getAmount() {
        return this.amount;
    }

    public final PaymentServiceAppPaymentRedirectDetailsDTO getAppPaymentRedirectDetails() {
        return this.appPaymentRedirectDetails;
    }

    public final String getCallbackFailUrl() {
        return this.callbackFailUrl;
    }

    public final String getCreditCardToken() {
        return this.creditCardToken;
    }

    public final CurrencyTypeDTO getCurrency() {
        return this.currency;
    }

    public final String getEmail() {
        return this.email;
    }

    public final String getLanguage() {
        return this.language;
    }

    public final String getOrderNumber() {
        return this.orderNumber;
    }

    public final int getPaymentLine() {
        return this.paymentLine;
    }

    public final PaymentTypeDTO getPaymentType() {
        return this.paymentType;
    }

    public final PaymentProductTypeDTO getProductType() {
        return this.productType;
    }

    public final String getReceiptUrl() {
        return this.receiptUrl;
    }

    public final PaymentSourceDTO getSource() {
        return this.source;
    }

    public int hashCode() {
        int hashCode = ((Integer.hashCode(this.amount) * 31) + this.callbackFailUrl.hashCode()) * 31;
        String str = this.creditCardToken;
        return ((((((((((((((((((((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.currency.hashCode()) * 31) + this.language.hashCode()) * 31) + this.orderNumber.hashCode()) * 31) + this.paymentType.hashCode()) * 31) + this.productType.hashCode()) * 31) + this.receiptUrl.hashCode()) * 31) + this.source.hashCode()) * 31) + this.email.hashCode()) * 31) + Integer.hashCode(this.paymentLine)) * 31) + this.appPaymentRedirectDetails.hashCode();
    }

    public String toString() {
        return "CreatePaymentRequestParameters(amount=" + this.amount + ", callbackFailUrl=" + this.callbackFailUrl + ", creditCardToken=" + this.creditCardToken + ", currency=" + this.currency + ", language=" + this.language + ", orderNumber=" + this.orderNumber + ", paymentType=" + this.paymentType + ", productType=" + this.productType + ", receiptUrl=" + this.receiptUrl + ", source=" + this.source + ", email=" + this.email + ", paymentLine=" + this.paymentLine + ", appPaymentRedirectDetails=" + this.appPaymentRedirectDetails + ")";
    }

    public CreatePaymentRequestParameters(int i5, String callbackFailUrl, String str, CurrencyTypeDTO currency, String language, String orderNumber, PaymentTypeDTO paymentType, PaymentProductTypeDTO productType, String receiptUrl, PaymentSourceDTO source, String email, int i6, PaymentServiceAppPaymentRedirectDetailsDTO appPaymentRedirectDetails) {
        Intrinsics.checkNotNullParameter(callbackFailUrl, "callbackFailUrl");
        Intrinsics.checkNotNullParameter(currency, "currency");
        Intrinsics.checkNotNullParameter(language, "language");
        Intrinsics.checkNotNullParameter(orderNumber, "orderNumber");
        Intrinsics.checkNotNullParameter(paymentType, "paymentType");
        Intrinsics.checkNotNullParameter(productType, "productType");
        Intrinsics.checkNotNullParameter(receiptUrl, "receiptUrl");
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(email, "email");
        Intrinsics.checkNotNullParameter(appPaymentRedirectDetails, "appPaymentRedirectDetails");
        this.amount = i5;
        this.callbackFailUrl = callbackFailUrl;
        this.creditCardToken = str;
        this.currency = currency;
        this.language = language;
        this.orderNumber = orderNumber;
        this.paymentType = paymentType;
        this.productType = productType;
        this.receiptUrl = receiptUrl;
        this.source = source;
        this.email = email;
        this.paymentLine = i6;
        this.appPaymentRedirectDetails = appPaymentRedirectDetails;
    }
}
