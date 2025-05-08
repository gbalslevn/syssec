package dk.molslinjen.domain.extensions;

import dk.molslinjen.domain.model.shared.PriceWithCurrency;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u000e\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u0004\u0018\u00010\u0001¨\u0006\u0002"}, d2 = {"nullIfZero", "Ldk/molslinjen/domain/model/shared/PriceWithCurrency;", "domain_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class PriceWithCurrencyExtensionsKt {
    public static final PriceWithCurrency nullIfZero(PriceWithCurrency priceWithCurrency) {
        if (priceWithCurrency == null || priceWithCurrency.getValue() == 0) {
            return null;
        }
        return priceWithCurrency;
    }
}
