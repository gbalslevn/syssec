package dk.molslinjen.domain.model.account;

import dk.molslinjen.api.services.account.creditcard.response.CreditCardDTO;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.EnumsKt;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import org.conscrypt.BuildConfig;
import org.threeten.bp.LocalDate;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 42\u00020\u0001:\u000245B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003¢\u0006\u0004\b\n\u0010\u000bB\u0011\b\u0016\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0004\b\n\u0010\u000eBW\b\u0010\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\n\u0010\u0013J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0006HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003JE\u0010'\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u0003HÆ\u0001J\u0013\u0010(\u001a\u00020\u001f2\b\u0010)\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010*\u001a\u00020\u0010HÖ\u0001J\t\u0010+\u001a\u00020\u0003HÖ\u0001J%\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\u00002\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u000202H\u0001¢\u0006\u0002\b3R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0015R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0015R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0015R\u0011\u0010\u001c\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u0015R\u0011\u0010\u001e\u001a\u00020\u001f8F¢\u0006\u0006\u001a\u0004\b\u001e\u0010 ¨\u00066"}, d2 = {"Ldk/molslinjen/domain/model/account/CreditCard;", BuildConfig.FLAVOR, "cardId", BuildConfig.FLAVOR, "maskedNumber", "cardType", "Ldk/molslinjen/domain/model/account/CreditCardType;", "expirationMonth", "expirationYear", "creditCardToken", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ldk/molslinjen/domain/model/account/CreditCardType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "dto", "Ldk/molslinjen/api/services/account/creditcard/response/CreditCardDTO;", "(Ldk/molslinjen/api/services/account/creditcard/response/CreditCardDTO;)V", "seen0", BuildConfig.FLAVOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ldk/molslinjen/domain/model/account/CreditCardType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getCardId", "()Ljava/lang/String;", "getMaskedNumber", "getCardType", "()Ldk/molslinjen/domain/model/account/CreditCardType;", "getExpirationMonth", "getExpirationYear", "getCreditCardToken", "adjustedMaskedNumber", "getAdjustedMaskedNumber", "isExpired", BuildConfig.FLAVOR, "()Z", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "toString", "write$Self", BuildConfig.FLAVOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$domain_kombardoProd", "Companion", "$serializer", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
/* loaded from: classes2.dex */
public final /* data */ class CreditCard {
    private final String cardId;
    private final CreditCardType cardType;
    private final String creditCardToken;
    private final String expirationMonth;
    private final String expirationYear;
    private final String maskedNumber;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final KSerializer<Object>[] $childSerializers = {null, null, EnumsKt.createSimpleEnumSerializer("dk.molslinjen.domain.model.account.CreditCardType", CreditCardType.values()), null, null, null};
    private static final CreditCard mock = new CreditCard("34245", "5471********3434", CreditCardType.Visa, "12", "2026", "12vlnk234vlæ12l3v4ælk23vjlk12l34vlkæ1342lvæ");

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\n"}, d2 = {"Ldk/molslinjen/domain/model/account/CreditCard$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "mock", "Ldk/molslinjen/domain/model/account/CreditCard;", "getMock", "()Ldk/molslinjen/domain/model/account/CreditCard;", "serializer", "Lkotlinx/serialization/KSerializer;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final CreditCard getMock() {
            return CreditCard.mock;
        }

        public final KSerializer<CreditCard> serializer() {
            return CreditCard$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    public /* synthetic */ CreditCard(int i5, String str, String str2, CreditCardType creditCardType, String str3, String str4, String str5, SerializationConstructorMarker serializationConstructorMarker) {
        if (63 != (i5 & 63)) {
            PluginExceptionsKt.throwMissingFieldException(i5, 63, CreditCard$$serializer.INSTANCE.getDescriptor());
        }
        this.cardId = str;
        this.maskedNumber = str2;
        this.cardType = creditCardType;
        this.expirationMonth = str3;
        this.expirationYear = str4;
        this.creditCardToken = str5;
    }

    public static /* synthetic */ CreditCard copy$default(CreditCard creditCard, String str, String str2, CreditCardType creditCardType, String str3, String str4, String str5, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            str = creditCard.cardId;
        }
        if ((i5 & 2) != 0) {
            str2 = creditCard.maskedNumber;
        }
        String str6 = str2;
        if ((i5 & 4) != 0) {
            creditCardType = creditCard.cardType;
        }
        CreditCardType creditCardType2 = creditCardType;
        if ((i5 & 8) != 0) {
            str3 = creditCard.expirationMonth;
        }
        String str7 = str3;
        if ((i5 & 16) != 0) {
            str4 = creditCard.expirationYear;
        }
        String str8 = str4;
        if ((i5 & 32) != 0) {
            str5 = creditCard.creditCardToken;
        }
        return creditCard.copy(str, str6, creditCardType2, str7, str8, str5);
    }

    public static final /* synthetic */ void write$Self$domain_kombardoProd(CreditCard self, CompositeEncoder output, SerialDescriptor serialDesc) {
        KSerializer<Object>[] kSerializerArr = $childSerializers;
        output.encodeStringElement(serialDesc, 0, self.cardId);
        output.encodeStringElement(serialDesc, 1, self.maskedNumber);
        output.encodeSerializableElement(serialDesc, 2, kSerializerArr[2], self.cardType);
        output.encodeStringElement(serialDesc, 3, self.expirationMonth);
        output.encodeStringElement(serialDesc, 4, self.expirationYear);
        output.encodeStringElement(serialDesc, 5, self.creditCardToken);
    }

    /* renamed from: component1, reason: from getter */
    public final String getCardId() {
        return this.cardId;
    }

    /* renamed from: component2, reason: from getter */
    public final String getMaskedNumber() {
        return this.maskedNumber;
    }

    /* renamed from: component3, reason: from getter */
    public final CreditCardType getCardType() {
        return this.cardType;
    }

    /* renamed from: component4, reason: from getter */
    public final String getExpirationMonth() {
        return this.expirationMonth;
    }

    /* renamed from: component5, reason: from getter */
    public final String getExpirationYear() {
        return this.expirationYear;
    }

    /* renamed from: component6, reason: from getter */
    public final String getCreditCardToken() {
        return this.creditCardToken;
    }

    public final CreditCard copy(String cardId, String maskedNumber, CreditCardType cardType, String expirationMonth, String expirationYear, String creditCardToken) {
        Intrinsics.checkNotNullParameter(cardId, "cardId");
        Intrinsics.checkNotNullParameter(maskedNumber, "maskedNumber");
        Intrinsics.checkNotNullParameter(cardType, "cardType");
        Intrinsics.checkNotNullParameter(expirationMonth, "expirationMonth");
        Intrinsics.checkNotNullParameter(expirationYear, "expirationYear");
        Intrinsics.checkNotNullParameter(creditCardToken, "creditCardToken");
        return new CreditCard(cardId, maskedNumber, cardType, expirationMonth, expirationYear, creditCardToken);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CreditCard)) {
            return false;
        }
        CreditCard creditCard = (CreditCard) other;
        return Intrinsics.areEqual(this.cardId, creditCard.cardId) && Intrinsics.areEqual(this.maskedNumber, creditCard.maskedNumber) && this.cardType == creditCard.cardType && Intrinsics.areEqual(this.expirationMonth, creditCard.expirationMonth) && Intrinsics.areEqual(this.expirationYear, creditCard.expirationYear) && Intrinsics.areEqual(this.creditCardToken, creditCard.creditCardToken);
    }

    public final String getAdjustedMaskedNumber() {
        return "**** " + StringsKt.takeLast(this.maskedNumber, 4);
    }

    public final String getCardId() {
        return this.cardId;
    }

    public final CreditCardType getCardType() {
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
        return (((((((((this.cardId.hashCode() * 31) + this.maskedNumber.hashCode()) * 31) + this.cardType.hashCode()) * 31) + this.expirationMonth.hashCode()) * 31) + this.expirationYear.hashCode()) * 31) + this.creditCardToken.hashCode();
    }

    public final boolean isExpired() {
        LocalDate now = LocalDate.now();
        try {
            int parseInt = Integer.parseInt(this.expirationYear);
            int parseInt2 = Integer.parseInt(this.expirationMonth);
            if (parseInt >= now.getYear()) {
                if (parseInt != now.getYear()) {
                    return false;
                }
                if (parseInt2 > now.getMonthValue()) {
                    return false;
                }
            }
            return true;
        } catch (NumberFormatException unused) {
            return false;
        }
    }

    public String toString() {
        return "CreditCard(cardId=" + this.cardId + ", maskedNumber=" + this.maskedNumber + ", cardType=" + this.cardType + ", expirationMonth=" + this.expirationMonth + ", expirationYear=" + this.expirationYear + ", creditCardToken=" + this.creditCardToken + ")";
    }

    public CreditCard(String cardId, String maskedNumber, CreditCardType cardType, String expirationMonth, String expirationYear, String creditCardToken) {
        Intrinsics.checkNotNullParameter(cardId, "cardId");
        Intrinsics.checkNotNullParameter(maskedNumber, "maskedNumber");
        Intrinsics.checkNotNullParameter(cardType, "cardType");
        Intrinsics.checkNotNullParameter(expirationMonth, "expirationMonth");
        Intrinsics.checkNotNullParameter(expirationYear, "expirationYear");
        Intrinsics.checkNotNullParameter(creditCardToken, "creditCardToken");
        this.cardId = cardId;
        this.maskedNumber = maskedNumber;
        this.cardType = cardType;
        this.expirationMonth = expirationMonth;
        this.expirationYear = expirationYear;
        this.creditCardToken = creditCardToken;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public CreditCard(CreditCardDTO dto) {
        this(dto.getCardId(), dto.getMaskedNumber(), CreditCardType.INSTANCE.invoke(dto.getCardType()), dto.getExpirationMonth(), dto.getExpirationYear(), dto.getCreditCardToken());
        Intrinsics.checkNotNullParameter(dto, "dto");
    }
}
