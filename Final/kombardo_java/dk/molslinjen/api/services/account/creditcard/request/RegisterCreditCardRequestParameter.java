package dk.molslinjen.api.services.account.creditcard.request;

import dk.molslinjen.api.services.account.creditcard.response.CreditCardTypeDTO;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 -2\u00020\u0001:\u0002,-B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\nBM\b\u0010\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\t\u0010\u000fJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J;\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020\fHÖ\u0001J\t\u0010#\u001a\u00020\u0003HÖ\u0001J%\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u00002\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020*H\u0001¢\u0006\u0002\b+R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0011R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0011¨\u0006."}, d2 = {"Ldk/molslinjen/api/services/account/creditcard/request/RegisterCreditCardRequestParameter;", BuildConfig.FLAVOR, "maskedNumber", BuildConfig.FLAVOR, "cardType", "Ldk/molslinjen/api/services/account/creditcard/response/CreditCardTypeDTO;", "expirationMonth", "expirationYear", "creditCardToken", "<init>", "(Ljava/lang/String;Ldk/molslinjen/api/services/account/creditcard/response/CreditCardTypeDTO;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "seen0", BuildConfig.FLAVOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ldk/molslinjen/api/services/account/creditcard/response/CreditCardTypeDTO;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getMaskedNumber", "()Ljava/lang/String;", "getCardType$annotations", "()V", "getCardType", "()Ldk/molslinjen/api/services/account/creditcard/response/CreditCardTypeDTO;", "getExpirationMonth", "getExpirationYear", "getCreditCardToken", "component1", "component2", "component3", "component4", "component5", "copy", "equals", BuildConfig.FLAVOR, "other", "hashCode", "toString", "write$Self", BuildConfig.FLAVOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$api_kombardoProd", "$serializer", "Companion", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
/* loaded from: classes2.dex */
public final /* data */ class RegisterCreditCardRequestParameter {
    private final CreditCardTypeDTO cardType;
    private final String creditCardToken;
    private final String expirationMonth;
    private final String expirationYear;
    private final String maskedNumber;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final KSerializer<Object>[] $childSerializers = {null, CreditCardTypeDTO.INSTANCE.serializer(), null, null, null};

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Ldk/molslinjen/api/services/account/creditcard/request/RegisterCreditCardRequestParameter$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldk/molslinjen/api/services/account/creditcard/request/RegisterCreditCardRequestParameter;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public final KSerializer<RegisterCreditCardRequestParameter> serializer() {
            return RegisterCreditCardRequestParameter$$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public /* synthetic */ RegisterCreditCardRequestParameter(int i5, String str, CreditCardTypeDTO creditCardTypeDTO, String str2, String str3, String str4, SerializationConstructorMarker serializationConstructorMarker) {
        if (31 != (i5 & 31)) {
            PluginExceptionsKt.throwMissingFieldException(i5, 31, RegisterCreditCardRequestParameter$$serializer.INSTANCE.getDescriptor());
        }
        this.maskedNumber = str;
        this.cardType = creditCardTypeDTO;
        this.expirationMonth = str2;
        this.expirationYear = str3;
        this.creditCardToken = str4;
    }

    public static /* synthetic */ RegisterCreditCardRequestParameter copy$default(RegisterCreditCardRequestParameter registerCreditCardRequestParameter, String str, CreditCardTypeDTO creditCardTypeDTO, String str2, String str3, String str4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            str = registerCreditCardRequestParameter.maskedNumber;
        }
        if ((i5 & 2) != 0) {
            creditCardTypeDTO = registerCreditCardRequestParameter.cardType;
        }
        CreditCardTypeDTO creditCardTypeDTO2 = creditCardTypeDTO;
        if ((i5 & 4) != 0) {
            str2 = registerCreditCardRequestParameter.expirationMonth;
        }
        String str5 = str2;
        if ((i5 & 8) != 0) {
            str3 = registerCreditCardRequestParameter.expirationYear;
        }
        String str6 = str3;
        if ((i5 & 16) != 0) {
            str4 = registerCreditCardRequestParameter.creditCardToken;
        }
        return registerCreditCardRequestParameter.copy(str, creditCardTypeDTO2, str5, str6, str4);
    }

    public static /* synthetic */ void getCardType$annotations() {
    }

    public static final /* synthetic */ void write$Self$api_kombardoProd(RegisterCreditCardRequestParameter self, CompositeEncoder output, SerialDescriptor serialDesc) {
        KSerializer<Object>[] kSerializerArr = $childSerializers;
        output.encodeStringElement(serialDesc, 0, self.maskedNumber);
        output.encodeSerializableElement(serialDesc, 1, kSerializerArr[1], self.cardType);
        output.encodeStringElement(serialDesc, 2, self.expirationMonth);
        output.encodeStringElement(serialDesc, 3, self.expirationYear);
        output.encodeStringElement(serialDesc, 4, self.creditCardToken);
    }

    /* renamed from: component1, reason: from getter */
    public final String getMaskedNumber() {
        return this.maskedNumber;
    }

    /* renamed from: component2, reason: from getter */
    public final CreditCardTypeDTO getCardType() {
        return this.cardType;
    }

    /* renamed from: component3, reason: from getter */
    public final String getExpirationMonth() {
        return this.expirationMonth;
    }

    /* renamed from: component4, reason: from getter */
    public final String getExpirationYear() {
        return this.expirationYear;
    }

    /* renamed from: component5, reason: from getter */
    public final String getCreditCardToken() {
        return this.creditCardToken;
    }

    public final RegisterCreditCardRequestParameter copy(String maskedNumber, CreditCardTypeDTO cardType, String expirationMonth, String expirationYear, String creditCardToken) {
        Intrinsics.checkNotNullParameter(maskedNumber, "maskedNumber");
        Intrinsics.checkNotNullParameter(cardType, "cardType");
        Intrinsics.checkNotNullParameter(expirationMonth, "expirationMonth");
        Intrinsics.checkNotNullParameter(expirationYear, "expirationYear");
        Intrinsics.checkNotNullParameter(creditCardToken, "creditCardToken");
        return new RegisterCreditCardRequestParameter(maskedNumber, cardType, expirationMonth, expirationYear, creditCardToken);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RegisterCreditCardRequestParameter)) {
            return false;
        }
        RegisterCreditCardRequestParameter registerCreditCardRequestParameter = (RegisterCreditCardRequestParameter) other;
        return Intrinsics.areEqual(this.maskedNumber, registerCreditCardRequestParameter.maskedNumber) && this.cardType == registerCreditCardRequestParameter.cardType && Intrinsics.areEqual(this.expirationMonth, registerCreditCardRequestParameter.expirationMonth) && Intrinsics.areEqual(this.expirationYear, registerCreditCardRequestParameter.expirationYear) && Intrinsics.areEqual(this.creditCardToken, registerCreditCardRequestParameter.creditCardToken);
    }

    public final CreditCardTypeDTO getCardType() {
        return this.cardType;
    }

    public final String getCreditCardToken() {
        return this.creditCardToken;
    }

    public final String getExpirationMonth() {
        return this.expirationMonth;
    }

    public final String getExpirationYear() {
        return this.expirationYear;
    }

    public final String getMaskedNumber() {
        return this.maskedNumber;
    }

    public int hashCode() {
        return (((((((this.maskedNumber.hashCode() * 31) + this.cardType.hashCode()) * 31) + this.expirationMonth.hashCode()) * 31) + this.expirationYear.hashCode()) * 31) + this.creditCardToken.hashCode();
    }

    public String toString() {
        return "RegisterCreditCardRequestParameter(maskedNumber=" + this.maskedNumber + ", cardType=" + this.cardType + ", expirationMonth=" + this.expirationMonth + ", expirationYear=" + this.expirationYear + ", creditCardToken=" + this.creditCardToken + ")";
    }

    public RegisterCreditCardRequestParameter(String maskedNumber, CreditCardTypeDTO cardType, String expirationMonth, String expirationYear, String creditCardToken) {
        Intrinsics.checkNotNullParameter(maskedNumber, "maskedNumber");
        Intrinsics.checkNotNullParameter(cardType, "cardType");
        Intrinsics.checkNotNullParameter(expirationMonth, "expirationMonth");
        Intrinsics.checkNotNullParameter(expirationYear, "expirationYear");
        Intrinsics.checkNotNullParameter(creditCardToken, "creditCardToken");
        this.maskedNumber = maskedNumber;
        this.cardType = cardType;
        this.expirationMonth = expirationMonth;
        this.expirationYear = expirationYear;
        this.creditCardToken = creditCardToken;
    }
}
