package dk.molslinjen.extensions.domain;

import dk.molslinjen.domain.model.account.CreditCardType;
import dk.molslinjen.kombardo.R;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0007\u001a\f\u0010\u0003\u001a\u00020\u0001*\u00020\u0002H\u0007¨\u0006\u0004"}, d2 = {"getIcon", BuildConfig.FLAVOR, "Ldk/molslinjen/domain/model/account/CreditCardType;", "getTitle", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class CreditCardTypeExtensionsKt {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[CreditCardType.values().length];
            try {
                iArr[CreditCardType.Dankort.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[CreditCardType.Visa.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[CreditCardType.MasterCard.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[CreditCardType.Maestro.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[CreditCardType.Other.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final int getIcon(CreditCardType creditCardType) {
        Intrinsics.checkNotNullParameter(creditCardType, "<this>");
        int i5 = WhenMappings.$EnumSwitchMapping$0[creditCardType.ordinal()];
        if (i5 == 1) {
            return R.drawable.icon_creditcard_dankort;
        }
        if (i5 == 2) {
            return R.drawable.icon_creditcard_visa;
        }
        if (i5 == 3) {
            return R.drawable.icon_creditcard_mastercard;
        }
        if (i5 == 4) {
            return R.drawable.icon_creditcard_maestro;
        }
        if (i5 == 5) {
            return R.drawable.icon_profile_credit_cards;
        }
        throw new NoWhenBranchMatchedException();
    }

    public static final int getTitle(CreditCardType creditCardType) {
        Intrinsics.checkNotNullParameter(creditCardType, "<this>");
        int i5 = WhenMappings.$EnumSwitchMapping$0[creditCardType.ordinal()];
        if (i5 == 1) {
            return R.string.creditCard_dankort;
        }
        if (i5 == 2) {
            return R.string.creditCard_visa;
        }
        if (i5 == 3) {
            return R.string.creditCard_mastercard;
        }
        if (i5 == 4) {
            return R.string.creditCard_maestro;
        }
        if (i5 == 5) {
            return R.string.creditCard_unknownType;
        }
        throw new NoWhenBranchMatchedException();
    }
}
