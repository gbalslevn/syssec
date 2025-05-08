package dk.molslinjen.domain.extensions;

import dk.molslinjen.domain.managers.checkout.PriceTotal;
import dk.molslinjen.domain.model.shared.Price;
import dk.molslinjen.domain.model.shared.PriceWithCurrency;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0011\u0010\u0005\u001a\u00020\u0004*\u00020\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u0011\u0010\u0005\u001a\u00020\u0004*\u00020\u0007¢\u0006\u0004\b\u0005\u0010\b¨\u0006\t"}, d2 = {"Ldk/molslinjen/domain/model/shared/Price;", BuildConfig.FLAVOR, "toAnalyticsAmount", "(Ldk/molslinjen/domain/model/shared/Price;)I", BuildConfig.FLAVOR, "toAnalyticsCurrency", "(Ldk/molslinjen/domain/model/shared/Price;)Ljava/lang/String;", "Ldk/molslinjen/domain/managers/checkout/PriceTotal;", "(Ldk/molslinjen/domain/managers/checkout/PriceTotal;)Ljava/lang/String;", "domain_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class AnalyticsExtensionsKt {
    public static final int toAnalyticsAmount(Price price) {
        Intrinsics.checkNotNullParameter(price, "<this>");
        if (price instanceof PriceWithCurrency) {
            return ((PriceWithCurrency) price).getValue();
        }
        if (price instanceof Price.Charge) {
            return ((Price.Charge) price).getNumberOfCharges();
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final String toAnalyticsCurrency(Price price) {
        Intrinsics.checkNotNullParameter(price, "<this>");
        if (price instanceof PriceWithCurrency) {
            return ((PriceWithCurrency) price).getCurrencyType().name();
        }
        if (price instanceof Price.Charge) {
            return "clip";
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final String toAnalyticsCurrency(PriceTotal priceTotal) {
        Intrinsics.checkNotNullParameter(priceTotal, "<this>");
        return priceTotal.getPrice().getValue() > 0 ? toAnalyticsCurrency(priceTotal.getPrice()) : priceTotal.getCharges().getNumberOfCharges() > 0 ? toAnalyticsCurrency(priceTotal.getCharges()) : BuildConfig.FLAVOR;
    }
}
