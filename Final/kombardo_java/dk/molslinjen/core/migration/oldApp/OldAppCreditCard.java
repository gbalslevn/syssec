package dk.molslinjen.core.migration.oldApp;

import com.sdk.growthbook.utils.Constants;
import dk.molslinjen.domain.model.account.CreditCard;
import dk.molslinjen.domain.model.account.CreditCardType;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\f\b\u0087\b\u0018\u0000 *2\u00020\u0001:\u0002+*BW\b\u0010\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\r\u0010\u000eJ'\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012H\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\r\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001d\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001d\u0010\u001eJ\u001a\u0010!\u001a\u00020 2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b!\u0010\"R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010#\u001a\u0004\b$\u0010\u001cR\u0017\u0010\u0006\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010#\u001a\u0004\b%\u0010\u001cR\u0017\u0010\u0007\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0007\u0010#\u001a\u0004\b&\u0010\u001cR\u0017\u0010\b\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\b\u0010#\u001a\u0004\b'\u0010\u001cR\u0017\u0010\t\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\t\u0010#\u001a\u0004\b(\u0010\u001cR\u0017\u0010\n\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\n\u0010#\u001a\u0004\b)\u0010\u001c¨\u0006,"}, d2 = {"Ldk/molslinjen/core/migration/oldApp/OldAppCreditCard;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "seen0", BuildConfig.FLAVOR, Constants.ID_ATTRIBUTE_KEY, "maskedNumber", "paymentType", "expirationMonth", "expirationYear", "creditCardToken", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "serializationConstructorMarker", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "self", "Lkotlinx/serialization/encoding/CompositeEncoder;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", BuildConfig.FLAVOR, "write$Self$app_kombardoProd", "(Ldk/molslinjen/core/migration/oldApp/OldAppCreditCard;Lkotlinx/serialization/encoding/CompositeEncoder;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "write$Self", "Ldk/molslinjen/domain/model/account/CreditCard;", "toCreditCard", "()Ldk/molslinjen/domain/model/account/CreditCard;", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", BuildConfig.FLAVOR, "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getId", "getMaskedNumber", "getPaymentType", "getExpirationMonth", "getExpirationYear", "getCreditCardToken", "Companion", "$serializer", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
/* loaded from: classes2.dex */
public final /* data */ class OldAppCreditCard {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String creditCardToken;
    private final String expirationMonth;
    private final String expirationYear;
    private final String id;
    private final String maskedNumber;
    private final String paymentType;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Ldk/molslinjen/core/migration/oldApp/OldAppCreditCard$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldk/molslinjen/core/migration/oldApp/OldAppCreditCard;", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public final KSerializer<OldAppCreditCard> serializer() {
            return OldAppCreditCard$$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public /* synthetic */ OldAppCreditCard(int i5, String str, String str2, String str3, String str4, String str5, String str6, SerializationConstructorMarker serializationConstructorMarker) {
        if (63 != (i5 & 63)) {
            PluginExceptionsKt.throwMissingFieldException(i5, 63, OldAppCreditCard$$serializer.INSTANCE.getDescriptor());
        }
        this.id = str;
        this.maskedNumber = str2;
        this.paymentType = str3;
        this.expirationMonth = str4;
        this.expirationYear = str5;
        this.creditCardToken = str6;
    }

    public static final /* synthetic */ void write$Self$app_kombardoProd(OldAppCreditCard self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeStringElement(serialDesc, 0, self.id);
        output.encodeStringElement(serialDesc, 1, self.maskedNumber);
        output.encodeStringElement(serialDesc, 2, self.paymentType);
        output.encodeStringElement(serialDesc, 3, self.expirationMonth);
        output.encodeStringElement(serialDesc, 4, self.expirationYear);
        output.encodeStringElement(serialDesc, 5, self.creditCardToken);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OldAppCreditCard)) {
            return false;
        }
        OldAppCreditCard oldAppCreditCard = (OldAppCreditCard) other;
        return Intrinsics.areEqual(this.id, oldAppCreditCard.id) && Intrinsics.areEqual(this.maskedNumber, oldAppCreditCard.maskedNumber) && Intrinsics.areEqual(this.paymentType, oldAppCreditCard.paymentType) && Intrinsics.areEqual(this.expirationMonth, oldAppCreditCard.expirationMonth) && Intrinsics.areEqual(this.expirationYear, oldAppCreditCard.expirationYear) && Intrinsics.areEqual(this.creditCardToken, oldAppCreditCard.creditCardToken);
    }

    public int hashCode() {
        return (((((((((this.id.hashCode() * 31) + this.maskedNumber.hashCode()) * 31) + this.paymentType.hashCode()) * 31) + this.expirationMonth.hashCode()) * 31) + this.expirationYear.hashCode()) * 31) + this.creditCardToken.hashCode();
    }

    public final CreditCard toCreditCard() {
        String obj = StringsKt.trim(this.paymentType).toString();
        Locale locale = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(locale, "getDefault(...)");
        String lowerCase = obj.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        return new CreditCard(this.id, this.maskedNumber, StringsKt.contains$default((CharSequence) lowerCase, (CharSequence) "dankort", false, 2, (Object) null) ? CreditCardType.Dankort : StringsKt.contains$default((CharSequence) lowerCase, (CharSequence) "mastercard", false, 2, (Object) null) ? CreditCardType.MasterCard : StringsKt.contains$default((CharSequence) lowerCase, (CharSequence) "visa", false, 2, (Object) null) ? CreditCardType.Visa : StringsKt.contains$default((CharSequence) lowerCase, (CharSequence) "maestro", false, 2, (Object) null) ? CreditCardType.Maestro : CreditCardType.Other, this.expirationMonth, this.expirationYear, this.creditCardToken);
    }

    public String toString() {
        return "OldAppCreditCard(id=" + this.id + ", maskedNumber=" + this.maskedNumber + ", paymentType=" + this.paymentType + ", expirationMonth=" + this.expirationMonth + ", expirationYear=" + this.expirationYear + ", creditCardToken=" + this.creditCardToken + ")";
    }
}
