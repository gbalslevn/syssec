package dk.molslinjen.extensions.domain;

import android.content.Context;
import dk.molslinjen.domain.managers.checkout.PriceTotal;
import dk.molslinjen.domain.model.shared.CurrencyType;
import dk.molslinjen.domain.model.shared.Price;
import dk.molslinjen.domain.model.shared.PriceWithCurrency;
import dk.molslinjen.kombardo.R;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;
import uniffi.molslinjen_shared.Currency;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0019\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u0019\u0010\u0004\u001a\u00020\u0003*\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0007\u001a\u0019\u0010\b\u001a\u00020\u0003*\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\b\u0010\u0007\u001a\u0019\u0010\u0004\u001a\u00020\u0003*\u00020\t2\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\n\u001a\u0019\u0010\b\u001a\u00020\u0003*\u00020\u000b2\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\b\u0010\f\u001a\u0019\u0010\u0004\u001a\u00020\u0003*\u00020\u000b2\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0004\u0010\f\u001a#\u0010\u0004\u001a\u00020\u0003*\u00020\u000b2\u0006\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u0004\u0010\u000f\u001a-\u0010\u0004\u001a\u00020\u0003*\u00020\u00102\u0006\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0011\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u0004\u0010\u0012\u001a\u0019\u0010\u0013\u001a\u00020\u0003*\u00020\u00102\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Ldk/molslinjen/domain/model/shared/CurrencyType;", "Landroid/content/Context;", "context", BuildConfig.FLAVOR, "formatted", "(Ldk/molslinjen/domain/model/shared/CurrencyType;Landroid/content/Context;)Ljava/lang/String;", "Ldk/molslinjen/domain/model/shared/Price$Charge;", "(Ldk/molslinjen/domain/model/shared/Price$Charge;Landroid/content/Context;)Ljava/lang/String;", "getCurrencyFormatted", "Ldk/molslinjen/domain/model/shared/Price;", "(Ldk/molslinjen/domain/model/shared/Price;Landroid/content/Context;)Ljava/lang/String;", "Ldk/molslinjen/domain/model/shared/PriceWithCurrency;", "(Ldk/molslinjen/domain/model/shared/PriceWithCurrency;Landroid/content/Context;)Ljava/lang/String;", BuildConfig.FLAVOR, "absoluteValue", "(Ldk/molslinjen/domain/model/shared/PriceWithCurrency;Landroid/content/Context;Z)Ljava/lang/String;", "Ldk/molslinjen/domain/managers/checkout/PriceTotal;", "excludeCurrency", "(Ldk/molslinjen/domain/managers/checkout/PriceTotal;Landroid/content/Context;ZZ)Ljava/lang/String;", "firstCurrency", "(Ldk/molslinjen/domain/managers/checkout/PriceTotal;Landroid/content/Context;)Ljava/lang/String;", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class PriceFormatExtensionsKt {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[Currency.values().length];
            try {
                iArr[Currency.DKK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Currency.SEK.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Currency.EUR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[CurrencyType.values().length];
            try {
                iArr2[CurrencyType.DKK.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[CurrencyType.SEK.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[CurrencyType.EUR.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    public static final String firstCurrency(PriceTotal priceTotal, Context context) {
        Intrinsics.checkNotNullParameter(priceTotal, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        boolean z5 = priceTotal.getCharges().getNumberOfCharges() == 0 && priceTotal.getPrice().getValue() == 0;
        return priceTotal.getPrice().getValue() != 0 ? getCurrencyFormatted(priceTotal.getPrice(), context) : (priceTotal.getCharges().getNumberOfCharges() > 0 || (z5 && priceTotal.getPreferChargesIfZero())) ? getCurrencyFormatted(priceTotal.getCharges(), context) : z5 ? getCurrencyFormatted(priceTotal.getPrice(), context) : BuildConfig.FLAVOR;
    }

    public static final String formatted(CurrencyType currencyType, Context context) {
        Intrinsics.checkNotNullParameter(currencyType, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        int i5 = WhenMappings.$EnumSwitchMapping$1[currencyType.ordinal()];
        if (i5 == 1) {
            String string = context.getString(R.string.currency_dkk);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            return string;
        }
        if (i5 == 2) {
            String string2 = context.getString(R.string.currency_sek);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            return string2;
        }
        if (i5 == 3) {
            String string3 = context.getString(R.string.currency_eur);
            Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
            return string3;
        }
        throw new NoWhenBranchMatchedException();
    }

    public static /* synthetic */ String formatted$default(PriceTotal priceTotal, Context context, boolean z5, boolean z6, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            z5 = false;
        }
        if ((i5 & 4) != 0) {
            z6 = false;
        }
        return formatted(priceTotal, context, z5, z6);
    }

    public static final String getCurrencyFormatted(Price.Charge charge, Context context) {
        Intrinsics.checkNotNullParameter(charge, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        String quantityString = context.getResources().getQuantityString(R.plurals.multiRide_charges, charge.getNumberOfCharges());
        Intrinsics.checkNotNullExpressionValue(quantityString, "getQuantityString(...)");
        return quantityString;
    }

    public static final String getCurrencyFormatted(PriceWithCurrency priceWithCurrency, Context context) {
        Intrinsics.checkNotNullParameter(priceWithCurrency, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        return formatted(priceWithCurrency.getCurrencyType(), context);
    }

    public static final String formatted(Price.Charge charge, Context context) {
        Intrinsics.checkNotNullParameter(charge, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        String quantityString = context.getResources().getQuantityString(R.plurals.multiRide_numberOfCharges, charge.getNumberOfCharges(), Integer.valueOf(charge.getNumberOfCharges()));
        Intrinsics.checkNotNullExpressionValue(quantityString, "getQuantityString(...)");
        return quantityString;
    }

    public static final String formatted(Price price, Context context) {
        Intrinsics.checkNotNullParameter(price, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        if (price instanceof Price.Charge) {
            return formatted((Price.Charge) price, context);
        }
        if (price instanceof PriceWithCurrency) {
            return formatted((PriceWithCurrency) price, context);
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final String formatted(PriceWithCurrency priceWithCurrency, Context context) {
        Intrinsics.checkNotNullParameter(priceWithCurrency, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        return formatted(priceWithCurrency, context, false);
    }

    public static final String formatted(PriceWithCurrency priceWithCurrency, Context context, boolean z5) {
        Intrinsics.checkNotNullParameter(priceWithCurrency, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        return priceWithCurrency.formattedValue(z5) + " " + getCurrencyFormatted(priceWithCurrency, context);
    }

    public static final String formatted(PriceTotal priceTotal, Context context, boolean z5, boolean z6) {
        Intrinsics.checkNotNullParameter(priceTotal, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        StringBuilder sb = new StringBuilder();
        boolean z7 = priceTotal.getCharges().getNumberOfCharges() == 0 && priceTotal.getPrice().getValue() == 0;
        if (priceTotal.getCharges().getNumberOfCharges() > 0 || (z7 && priceTotal.getPreferChargesIfZero())) {
            if (z5 && priceTotal.getPrice().getValue() == 0) {
                sb.append(priceTotal.getCharges().getNumberOfCharges());
            } else {
                sb.append(formatted(priceTotal.getCharges(), context));
            }
        }
        if (priceTotal.getPrice().getValue() != 0 || (z7 && !priceTotal.getPreferChargesIfZero())) {
            if (sb.length() > 0) {
                sb.append(" + ");
            }
            sb.append(priceTotal.getPrice().formattedValue(z6));
            if (!z5) {
                sb.append(" " + getCurrencyFormatted(priceTotal.getPrice(), context));
            }
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
        return sb2;
    }
}
