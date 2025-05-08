package dk.molslinjen.domain.extensions;

import dk.molslinjen.api.services.payment.response.PaymentStatusResponseDTO;
import dk.molslinjen.domain.model.account.CreditCardType;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"cardType", "Ldk/molslinjen/domain/model/account/CreditCardType;", "Ldk/molslinjen/api/services/payment/response/PaymentStatusResponseDTO;", "getCardType", "(Ldk/molslinjen/api/services/payment/response/PaymentStatusResponseDTO;)Ldk/molslinjen/domain/model/account/CreditCardType;", "domain_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class PaymentStatusResponseDTOExtensionsKt {
    public static final CreditCardType getCardType(PaymentStatusResponseDTO paymentStatusResponseDTO) {
        Intrinsics.checkNotNullParameter(paymentStatusResponseDTO, "<this>");
        String paymentType = paymentStatusResponseDTO.getPaymentType();
        if (paymentType == null) {
            return CreditCardType.Other;
        }
        Locale locale = Locale.ROOT;
        String lowerCase = paymentType.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        if (StringsKt.contains$default((CharSequence) lowerCase, (CharSequence) "mobilepay", false, 2, (Object) null)) {
            return CreditCardType.Other;
        }
        String lowerCase2 = paymentType.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
        if (StringsKt.contains$default((CharSequence) lowerCase2, (CharSequence) "mastercard", false, 2, (Object) null)) {
            return CreditCardType.MasterCard;
        }
        String lowerCase3 = paymentType.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase3, "toLowerCase(...)");
        if (StringsKt.contains$default((CharSequence) lowerCase3, (CharSequence) "dankort", false, 2, (Object) null)) {
            return CreditCardType.Dankort;
        }
        String lowerCase4 = paymentType.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase4, "toLowerCase(...)");
        if (StringsKt.contains$default((CharSequence) lowerCase4, (CharSequence) "visa", false, 2, (Object) null)) {
            return CreditCardType.Visa;
        }
        String lowerCase5 = paymentType.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase5, "toLowerCase(...)");
        return StringsKt.contains$default((CharSequence) lowerCase5, (CharSequence) "maestro", false, 2, (Object) null) ? CreditCardType.Maestro : CreditCardType.Other;
    }
}
