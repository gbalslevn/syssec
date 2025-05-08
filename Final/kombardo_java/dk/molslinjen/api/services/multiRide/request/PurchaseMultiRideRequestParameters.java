package dk.molslinjen.api.services.multiRide.request;

import dk.molslinjen.api.services.booking.request.PaymentTypeRequestParameters;
import dk.molslinjen.api.services.booking.response.booking.ApiAppPaymentRedirectDetailsDTO;
import dk.molslinjen.api.services.booking.response.booking.ApiAppPaymentRedirectDetailsDTO$$serializer;
import dk.molslinjen.api.shared.request.PaymentDataRequestParameters;
import dk.molslinjen.api.shared.request.PaymentDataRequestParameters$$serializer;
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

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b$\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 E2\u00020\u0001:\u0002DEBa\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0011¢\u0006\u0004\b\u0012\u0010\u0013B\u008f\u0001\b\u0010\u0012\u0006\u0010\u0014\u001a\u00020\u0007\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\u0006\u0010\u0015\u001a\u00020\u0016\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018¢\u0006\u0004\b\u0012\u0010\u0019J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\t\u0010-\u001a\u00020\u0003HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010/\u001a\u00020\u0007HÆ\u0003J\t\u00100\u001a\u00020\tHÆ\u0003J\t\u00101\u001a\u00020\u0003HÆ\u0003J\t\u00102\u001a\u00020\u0003HÆ\u0003J\t\u00103\u001a\u00020\u0003HÆ\u0003J\t\u00104\u001a\u00020\u000eHÆ\u0003J\t\u00105\u001a\u00020\u0003HÆ\u0003J\t\u00106\u001a\u00020\u0011HÆ\u0003Jy\u00107\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u0011HÆ\u0001J\u0013\u00108\u001a\u00020\u00162\b\u00109\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010:\u001a\u00020\u0007HÖ\u0001J\t\u0010;\u001a\u00020\u0003HÖ\u0001J%\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020\u00002\u0006\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020BH\u0001¢\u0006\u0002\bCR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001bR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001bR\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001bR\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001bR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0011\u0010\u000f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u001bR\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0011\u0010\u0015\u001a\u00020\u0016¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+¨\u0006F"}, d2 = {"Ldk/molslinjen/api/services/multiRide/request/PurchaseMultiRideRequestParameters;", BuildConfig.FLAVOR, "cardType", BuildConfig.FLAVOR, "email", "multiRideId", "numberOfTickets", BuildConfig.FLAVOR, "paymentType", "Ldk/molslinjen/api/services/booking/request/PaymentTypeRequestParameters;", "phone", "phonePrefix", "postalCode", "paymentData", "Ldk/molslinjen/api/shared/request/PaymentDataRequestParameters;", "version", "appPaymentRedirectDetails", "Ldk/molslinjen/api/services/booking/response/booking/ApiAppPaymentRedirectDetailsDTO;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILdk/molslinjen/api/services/booking/request/PaymentTypeRequestParameters;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ldk/molslinjen/api/shared/request/PaymentDataRequestParameters;Ljava/lang/String;Ldk/molslinjen/api/services/booking/response/booking/ApiAppPaymentRedirectDetailsDTO;)V", "seen0", "refill", BuildConfig.FLAVOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;ILdk/molslinjen/api/services/booking/request/PaymentTypeRequestParameters;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ldk/molslinjen/api/shared/request/PaymentDataRequestParameters;Ljava/lang/String;Ldk/molslinjen/api/services/booking/response/booking/ApiAppPaymentRedirectDetailsDTO;ZLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getCardType", "()Ljava/lang/String;", "getEmail", "getMultiRideId", "getNumberOfTickets", "()I", "getPaymentType", "()Ldk/molslinjen/api/services/booking/request/PaymentTypeRequestParameters;", "getPhone", "getPhonePrefix", "getPostalCode", "getPaymentData", "()Ldk/molslinjen/api/shared/request/PaymentDataRequestParameters;", "getVersion", "getAppPaymentRedirectDetails", "()Ldk/molslinjen/api/services/booking/response/booking/ApiAppPaymentRedirectDetailsDTO;", "getRefill", "()Z", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "copy", "equals", "other", "hashCode", "toString", "write$Self", BuildConfig.FLAVOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$api_kombardoProd", "$serializer", "Companion", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
/* loaded from: classes2.dex */
public final /* data */ class PurchaseMultiRideRequestParameters {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final ApiAppPaymentRedirectDetailsDTO appPaymentRedirectDetails;
    private final String cardType;
    private final String email;
    private final String multiRideId;
    private final int numberOfTickets;
    private final PaymentDataRequestParameters paymentData;
    private final PaymentTypeRequestParameters paymentType;
    private final String phone;
    private final String phonePrefix;
    private final String postalCode;
    private final boolean refill;
    private final String version;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Ldk/molslinjen/api/services/multiRide/request/PurchaseMultiRideRequestParameters$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldk/molslinjen/api/services/multiRide/request/PurchaseMultiRideRequestParameters;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public final KSerializer<PurchaseMultiRideRequestParameters> serializer() {
            return PurchaseMultiRideRequestParameters$$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public /* synthetic */ PurchaseMultiRideRequestParameters(int i5, String str, String str2, String str3, int i6, PaymentTypeRequestParameters paymentTypeRequestParameters, String str4, String str5, String str6, PaymentDataRequestParameters paymentDataRequestParameters, String str7, ApiAppPaymentRedirectDetailsDTO apiAppPaymentRedirectDetailsDTO, boolean z5, SerializationConstructorMarker serializationConstructorMarker) {
        if (2047 != (i5 & 2047)) {
            PluginExceptionsKt.throwMissingFieldException(i5, 2047, PurchaseMultiRideRequestParameters$$serializer.INSTANCE.getDescriptor());
        }
        this.cardType = str;
        this.email = str2;
        this.multiRideId = str3;
        this.numberOfTickets = i6;
        this.paymentType = paymentTypeRequestParameters;
        this.phone = str4;
        this.phonePrefix = str5;
        this.postalCode = str6;
        this.paymentData = paymentDataRequestParameters;
        this.version = str7;
        this.appPaymentRedirectDetails = apiAppPaymentRedirectDetailsDTO;
        if ((i5 & 2048) == 0) {
            this.refill = str3 != null;
        } else {
            this.refill = z5;
        }
    }

    public static final /* synthetic */ void write$Self$api_kombardoProd(PurchaseMultiRideRequestParameters self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeStringElement(serialDesc, 0, self.cardType);
        output.encodeStringElement(serialDesc, 1, self.email);
        output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.multiRideId);
        output.encodeIntElement(serialDesc, 3, self.numberOfTickets);
        output.encodeSerializableElement(serialDesc, 4, PaymentTypeRequestParameters.Serializer.INSTANCE, self.paymentType);
        output.encodeStringElement(serialDesc, 5, self.phone);
        output.encodeStringElement(serialDesc, 6, self.phonePrefix);
        output.encodeStringElement(serialDesc, 7, self.postalCode);
        output.encodeSerializableElement(serialDesc, 8, PaymentDataRequestParameters$$serializer.INSTANCE, self.paymentData);
        output.encodeStringElement(serialDesc, 9, self.version);
        output.encodeSerializableElement(serialDesc, 10, ApiAppPaymentRedirectDetailsDTO$$serializer.INSTANCE, self.appPaymentRedirectDetails);
        if (!output.shouldEncodeElementDefault(serialDesc, 11)) {
            if (self.refill == (self.multiRideId != null)) {
                return;
            }
        }
        output.encodeBooleanElement(serialDesc, 11, self.refill);
    }

    /* renamed from: component1, reason: from getter */
    public final String getCardType() {
        return this.cardType;
    }

    /* renamed from: component10, reason: from getter */
    public final String getVersion() {
        return this.version;
    }

    /* renamed from: component11, reason: from getter */
    public final ApiAppPaymentRedirectDetailsDTO getAppPaymentRedirectDetails() {
        return this.appPaymentRedirectDetails;
    }

    /* renamed from: component2, reason: from getter */
    public final String getEmail() {
        return this.email;
    }

    /* renamed from: component3, reason: from getter */
    public final String getMultiRideId() {
        return this.multiRideId;
    }

    /* renamed from: component4, reason: from getter */
    public final int getNumberOfTickets() {
        return this.numberOfTickets;
    }

    /* renamed from: component5, reason: from getter */
    public final PaymentTypeRequestParameters getPaymentType() {
        return this.paymentType;
    }

    /* renamed from: component6, reason: from getter */
    public final String getPhone() {
        return this.phone;
    }

    /* renamed from: component7, reason: from getter */
    public final String getPhonePrefix() {
        return this.phonePrefix;
    }

    /* renamed from: component8, reason: from getter */
    public final String getPostalCode() {
        return this.postalCode;
    }

    /* renamed from: component9, reason: from getter */
    public final PaymentDataRequestParameters getPaymentData() {
        return this.paymentData;
    }

    public final PurchaseMultiRideRequestParameters copy(String cardType, String email, String multiRideId, int numberOfTickets, PaymentTypeRequestParameters paymentType, String phone, String phonePrefix, String postalCode, PaymentDataRequestParameters paymentData, String version, ApiAppPaymentRedirectDetailsDTO appPaymentRedirectDetails) {
        Intrinsics.checkNotNullParameter(cardType, "cardType");
        Intrinsics.checkNotNullParameter(email, "email");
        Intrinsics.checkNotNullParameter(paymentType, "paymentType");
        Intrinsics.checkNotNullParameter(phone, "phone");
        Intrinsics.checkNotNullParameter(phonePrefix, "phonePrefix");
        Intrinsics.checkNotNullParameter(postalCode, "postalCode");
        Intrinsics.checkNotNullParameter(paymentData, "paymentData");
        Intrinsics.checkNotNullParameter(version, "version");
        Intrinsics.checkNotNullParameter(appPaymentRedirectDetails, "appPaymentRedirectDetails");
        return new PurchaseMultiRideRequestParameters(cardType, email, multiRideId, numberOfTickets, paymentType, phone, phonePrefix, postalCode, paymentData, version, appPaymentRedirectDetails);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PurchaseMultiRideRequestParameters)) {
            return false;
        }
        PurchaseMultiRideRequestParameters purchaseMultiRideRequestParameters = (PurchaseMultiRideRequestParameters) other;
        return Intrinsics.areEqual(this.cardType, purchaseMultiRideRequestParameters.cardType) && Intrinsics.areEqual(this.email, purchaseMultiRideRequestParameters.email) && Intrinsics.areEqual(this.multiRideId, purchaseMultiRideRequestParameters.multiRideId) && this.numberOfTickets == purchaseMultiRideRequestParameters.numberOfTickets && this.paymentType == purchaseMultiRideRequestParameters.paymentType && Intrinsics.areEqual(this.phone, purchaseMultiRideRequestParameters.phone) && Intrinsics.areEqual(this.phonePrefix, purchaseMultiRideRequestParameters.phonePrefix) && Intrinsics.areEqual(this.postalCode, purchaseMultiRideRequestParameters.postalCode) && Intrinsics.areEqual(this.paymentData, purchaseMultiRideRequestParameters.paymentData) && Intrinsics.areEqual(this.version, purchaseMultiRideRequestParameters.version) && Intrinsics.areEqual(this.appPaymentRedirectDetails, purchaseMultiRideRequestParameters.appPaymentRedirectDetails);
    }

    public final ApiAppPaymentRedirectDetailsDTO getAppPaymentRedirectDetails() {
        return this.appPaymentRedirectDetails;
    }

    public final String getCardType() {
        return this.cardType;
    }

    public final String getEmail() {
        return this.email;
    }

    public final String getMultiRideId() {
        return this.multiRideId;
    }

    public final int getNumberOfTickets() {
        return this.numberOfTickets;
    }

    public final PaymentDataRequestParameters getPaymentData() {
        return this.paymentData;
    }

    public final PaymentTypeRequestParameters getPaymentType() {
        return this.paymentType;
    }

    public final String getPhone() {
        return this.phone;
    }

    public final String getPhonePrefix() {
        return this.phonePrefix;
    }

    public final String getPostalCode() {
        return this.postalCode;
    }

    public final boolean getRefill() {
        return this.refill;
    }

    public final String getVersion() {
        return this.version;
    }

    public int hashCode() {
        int hashCode = ((this.cardType.hashCode() * 31) + this.email.hashCode()) * 31;
        String str = this.multiRideId;
        return ((((((((((((((((hashCode + (str == null ? 0 : str.hashCode())) * 31) + Integer.hashCode(this.numberOfTickets)) * 31) + this.paymentType.hashCode()) * 31) + this.phone.hashCode()) * 31) + this.phonePrefix.hashCode()) * 31) + this.postalCode.hashCode()) * 31) + this.paymentData.hashCode()) * 31) + this.version.hashCode()) * 31) + this.appPaymentRedirectDetails.hashCode();
    }

    public String toString() {
        return "PurchaseMultiRideRequestParameters(cardType=" + this.cardType + ", email=" + this.email + ", multiRideId=" + this.multiRideId + ", numberOfTickets=" + this.numberOfTickets + ", paymentType=" + this.paymentType + ", phone=" + this.phone + ", phonePrefix=" + this.phonePrefix + ", postalCode=" + this.postalCode + ", paymentData=" + this.paymentData + ", version=" + this.version + ", appPaymentRedirectDetails=" + this.appPaymentRedirectDetails + ")";
    }

    public PurchaseMultiRideRequestParameters(String cardType, String email, String str, int i5, PaymentTypeRequestParameters paymentType, String phone, String phonePrefix, String postalCode, PaymentDataRequestParameters paymentData, String version, ApiAppPaymentRedirectDetailsDTO appPaymentRedirectDetails) {
        Intrinsics.checkNotNullParameter(cardType, "cardType");
        Intrinsics.checkNotNullParameter(email, "email");
        Intrinsics.checkNotNullParameter(paymentType, "paymentType");
        Intrinsics.checkNotNullParameter(phone, "phone");
        Intrinsics.checkNotNullParameter(phonePrefix, "phonePrefix");
        Intrinsics.checkNotNullParameter(postalCode, "postalCode");
        Intrinsics.checkNotNullParameter(paymentData, "paymentData");
        Intrinsics.checkNotNullParameter(version, "version");
        Intrinsics.checkNotNullParameter(appPaymentRedirectDetails, "appPaymentRedirectDetails");
        this.cardType = cardType;
        this.email = email;
        this.multiRideId = str;
        this.numberOfTickets = i5;
        this.paymentType = paymentType;
        this.phone = phone;
        this.phonePrefix = phonePrefix;
        this.postalCode = postalCode;
        this.paymentData = paymentData;
        this.version = version;
        this.appPaymentRedirectDetails = appPaymentRedirectDetails;
        this.refill = str != null;
    }
}
