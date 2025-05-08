package dk.molslinjen.api.services.account.creditcard.response;

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

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 %2\u00020\u0001:\u0002$%B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003¢\u0006\u0004\b\n\u0010\u000bBW\b\u0010\u0012\u0006\u0010\f\u001a\u00020\r\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\n\u0010\u0010J%\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0001¢\u0006\u0002\b#R\u001c\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u001c\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0016\u0010\u0012\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0014R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0014R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0014¨\u0006&"}, d2 = {"Ldk/molslinjen/api/services/account/creditcard/response/CreditCardDTO;", BuildConfig.FLAVOR, "cardId", BuildConfig.FLAVOR, "maskedNumber", "cardType", "Ldk/molslinjen/api/services/account/creditcard/response/CreditCardTypeDTO;", "expirationMonth", "expirationYear", "creditCardToken", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ldk/molslinjen/api/services/account/creditcard/response/CreditCardTypeDTO;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "seen0", BuildConfig.FLAVOR, "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Ljava/lang/String;Ldk/molslinjen/api/services/account/creditcard/response/CreditCardTypeDTO;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getCardId$annotations", "()V", "getCardId", "()Ljava/lang/String;", "getMaskedNumber", "getCardType$annotations", "getCardType", "()Ldk/molslinjen/api/services/account/creditcard/response/CreditCardTypeDTO;", "getExpirationMonth", "getExpirationYear", "getCreditCardToken", "write$Self", BuildConfig.FLAVOR, "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$api_kombardoProd", "$serializer", "Companion", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
/* loaded from: classes2.dex */
public final class CreditCardDTO {
    private final String cardId;
    private final CreditCardTypeDTO cardType;
    private final String creditCardToken;
    private final String expirationMonth;
    private final String expirationYear;
    private final String maskedNumber;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final KSerializer<Object>[] $childSerializers = {null, null, new CreditCardTypeDTOSerializer(), null, null, null};

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Ldk/molslinjen/api/services/account/creditcard/response/CreditCardDTO$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldk/molslinjen/api/services/account/creditcard/response/CreditCardDTO;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public final KSerializer<CreditCardDTO> serializer() {
            return CreditCardDTO$$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public /* synthetic */ CreditCardDTO(int i5, String str, String str2, CreditCardTypeDTO creditCardTypeDTO, String str3, String str4, String str5, SerializationConstructorMarker serializationConstructorMarker) {
        if (63 != (i5 & 63)) {
            PluginExceptionsKt.throwMissingFieldException(i5, 63, CreditCardDTO$$serializer.INSTANCE.getDescriptor());
        }
        this.cardId = str;
        this.maskedNumber = str2;
        this.cardType = creditCardTypeDTO;
        this.expirationMonth = str3;
        this.expirationYear = str4;
        this.creditCardToken = str5;
    }

    public static /* synthetic */ void getCardId$annotations() {
    }

    @Serializable(with = CreditCardTypeDTOSerializer.class)
    public static /* synthetic */ void getCardType$annotations() {
    }

    public static final /* synthetic */ void write$Self$api_kombardoProd(CreditCardDTO self, CompositeEncoder output, SerialDescriptor serialDesc) {
        KSerializer<Object>[] kSerializerArr = $childSerializers;
        output.encodeStringElement(serialDesc, 0, self.cardId);
        output.encodeStringElement(serialDesc, 1, self.maskedNumber);
        output.encodeSerializableElement(serialDesc, 2, kSerializerArr[2], self.cardType);
        output.encodeStringElement(serialDesc, 3, self.expirationMonth);
        output.encodeStringElement(serialDesc, 4, self.expirationYear);
        output.encodeStringElement(serialDesc, 5, self.creditCardToken);
    }

    public final String getCardId() {
        return this.cardId;
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

    public CreditCardDTO(String cardId, String maskedNumber, CreditCardTypeDTO cardType, String expirationMonth, String expirationYear, String creditCardToken) {
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
}
