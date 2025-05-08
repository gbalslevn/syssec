package dk.molslinjen.domain.extensions.domain;

import dk.molslinjen.api.shared.response.PriceWithCurrencyDTO;
import dk.molslinjen.domain.model.shared.PriceWithCurrency;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import uniffi.molslinjen_shared.Amount;
import uniffi.molslinjen_shared.Currency;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0086\u0002\u001a\f\u0010\u0005\u001a\u0004\u0018\u00010\u0006*\u00020\u0007¨\u0006\b"}, d2 = {"invoke", "Luniffi/molslinjen_shared/Amount$Monetary;", "Luniffi/molslinjen_shared/Amount$Companion;", "dto", "Ldk/molslinjen/api/shared/response/PriceWithCurrencyDTO;", "toPriceWithCurrency", "Ldk/molslinjen/domain/model/shared/PriceWithCurrency;", "Luniffi/molslinjen_shared/Amount;", "domain_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class AmountExtensionsKt {
    public static final Amount.Monetary invoke(Amount.Companion companion, PriceWithCurrencyDTO dto) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        Intrinsics.checkNotNullParameter(dto, "dto");
        return new Amount.Monetary((long) dto.getValue(), CurrencyExtensionsKt.invoke(Currency.INSTANCE, dto.getCurrencyType()));
    }

    public static final PriceWithCurrency toPriceWithCurrency(Amount amount) {
        Intrinsics.checkNotNullParameter(amount, "<this>");
        if (amount instanceof Amount.Monetary) {
            Amount.Monetary monetary = (Amount.Monetary) amount;
            return new PriceWithCurrency((int) monetary.getAmount(), CurrencyExtensionsKt.toCurrencyType(monetary.getCurrency()));
        }
        if ((amount instanceof Amount.Charge) || (amount instanceof Amount.Mixed)) {
            return null;
        }
        throw new NoWhenBranchMatchedException();
    }
}
