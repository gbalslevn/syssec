package dk.molslinjen.domain.extensions.domain;

import dk.molslinjen.domain.model.shared.CurrencyType;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import uniffi.molslinjen_shared.Currency;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"}, d2 = {"toCurrency", "Luniffi/molslinjen_shared/Currency;", "Ldk/molslinjen/domain/model/shared/CurrencyType;", "domain_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class CurrencyTypeExtensionsKt {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[CurrencyType.values().length];
            try {
                iArr[CurrencyType.DKK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[CurrencyType.SEK.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[CurrencyType.EUR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final Currency toCurrency(CurrencyType currencyType) {
        Intrinsics.checkNotNullParameter(currencyType, "<this>");
        int i5 = WhenMappings.$EnumSwitchMapping$0[currencyType.ordinal()];
        if (i5 == 1) {
            return Currency.DKK;
        }
        if (i5 == 2) {
            return Currency.SEK;
        }
        if (i5 == 3) {
            return Currency.EUR;
        }
        throw new NoWhenBranchMatchedException();
    }
}
