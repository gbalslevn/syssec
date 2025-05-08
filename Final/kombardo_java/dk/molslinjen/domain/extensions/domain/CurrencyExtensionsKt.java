package dk.molslinjen.domain.extensions.domain;

import dk.molslinjen.api.shared.response.CurrencyTypeDTO;
import dk.molslinjen.domain.model.shared.CurrencyType;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import uniffi.molslinjen_shared.Currency;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001c\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0086\u0002¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u0011\u0010\u0007\u001a\u00020\u0006*\u00020\u0003¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Luniffi/molslinjen_shared/Currency$Companion;", "Ldk/molslinjen/api/shared/response/CurrencyTypeDTO;", "dto", "Luniffi/molslinjen_shared/Currency;", "invoke", "(Luniffi/molslinjen_shared/Currency$Companion;Ldk/molslinjen/api/shared/response/CurrencyTypeDTO;)Luniffi/molslinjen_shared/Currency;", "Ldk/molslinjen/domain/model/shared/CurrencyType;", "toCurrencyType", "(Luniffi/molslinjen_shared/Currency;)Ldk/molslinjen/domain/model/shared/CurrencyType;", "domain_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class CurrencyExtensionsKt {

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
            int[] iArr2 = new int[CurrencyTypeDTO.values().length];
            try {
                iArr2[CurrencyTypeDTO.DKK.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[CurrencyTypeDTO.SEK.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[CurrencyTypeDTO.EUR.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    public static final Currency invoke(Currency.Companion companion, CurrencyTypeDTO dto) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        Intrinsics.checkNotNullParameter(dto, "dto");
        int i5 = WhenMappings.$EnumSwitchMapping$1[dto.ordinal()];
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

    public static final CurrencyType toCurrencyType(Currency currency) {
        Intrinsics.checkNotNullParameter(currency, "<this>");
        int i5 = WhenMappings.$EnumSwitchMapping$0[currency.ordinal()];
        if (i5 == 1) {
            return CurrencyType.DKK;
        }
        if (i5 == 2) {
            return CurrencyType.SEK;
        }
        if (i5 == 3) {
            return CurrencyType.EUR;
        }
        throw new NoWhenBranchMatchedException();
    }
}
