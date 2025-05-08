package dk.molslinjen.domain.model.shared;

import dk.molslinjen.api.shared.response.CurrencyTypeDTO;
import dk.molslinjen.domain.model.shared.CurrencyType;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.internal.EnumsKt;
import org.conscrypt.BuildConfig;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\u0081\u0002\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\tB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0007\u001a\u00020\bj\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\n"}, d2 = {"Ldk/molslinjen/domain/model/shared/CurrencyType;", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;I)V", "DKK", "SEK", "EUR", "toDTO", "Ldk/molslinjen/api/shared/response/CurrencyTypeDTO;", "Companion", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
/* loaded from: classes2.dex */
public final class CurrencyType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ CurrencyType[] $VALUES;
    private static final Lazy<KSerializer<Object>> $cachedSerializer$delegate;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    public static final CurrencyType DKK = new CurrencyType("DKK", 0);
    public static final CurrencyType SEK = new CurrencyType("SEK", 1);
    public static final CurrencyType EUR = new CurrencyType("EUR", 2);

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0011\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0086\u0002J\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\t¨\u0006\n"}, d2 = {"Ldk/molslinjen/domain/model/shared/CurrencyType$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "invoke", "Ldk/molslinjen/domain/model/shared/CurrencyType;", "dto", "Ldk/molslinjen/api/shared/response/CurrencyTypeDTO;", "serializer", "Lkotlinx/serialization/KSerializer;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {

        @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes2.dex */
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[CurrencyTypeDTO.values().length];
                try {
                    iArr[CurrencyTypeDTO.DKK.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[CurrencyTypeDTO.SEK.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[CurrencyTypeDTO.EUR.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final /* synthetic */ KSerializer get$cachedSerializer() {
            return (KSerializer) CurrencyType.$cachedSerializer$delegate.getValue();
        }

        public final CurrencyType invoke(CurrencyTypeDTO dto) {
            Intrinsics.checkNotNullParameter(dto, "dto");
            int i5 = WhenMappings.$EnumSwitchMapping$0[dto.ordinal()];
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

        public final KSerializer<CurrencyType> serializer() {
            return get$cachedSerializer();
        }

        private Companion() {
        }
    }

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

    private static final /* synthetic */ CurrencyType[] $values() {
        return new CurrencyType[]{DKK, SEK, EUR};
    }

    static {
        CurrencyType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
        INSTANCE = new Companion(null);
        $cachedSerializer$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: N1.a
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                KSerializer _init_$_anonymous_;
                _init_$_anonymous_ = CurrencyType._init_$_anonymous_();
                return _init_$_anonymous_;
            }
        });
    }

    private CurrencyType(String str, int i5) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _init_$_anonymous_() {
        return EnumsKt.createSimpleEnumSerializer("dk.molslinjen.domain.model.shared.CurrencyType", values());
    }

    public static EnumEntries<CurrencyType> getEntries() {
        return $ENTRIES;
    }

    public static CurrencyType valueOf(String str) {
        return (CurrencyType) Enum.valueOf(CurrencyType.class, str);
    }

    public static CurrencyType[] values() {
        return (CurrencyType[]) $VALUES.clone();
    }

    public final CurrencyTypeDTO toDTO() {
        int i5 = WhenMappings.$EnumSwitchMapping$0[ordinal()];
        if (i5 == 1) {
            return CurrencyTypeDTO.DKK;
        }
        if (i5 == 2) {
            return CurrencyTypeDTO.SEK;
        }
        if (i5 == 3) {
            return CurrencyTypeDTO.EUR;
        }
        throw new NoWhenBranchMatchedException();
    }
}
