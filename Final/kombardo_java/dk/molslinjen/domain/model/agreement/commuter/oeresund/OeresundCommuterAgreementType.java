package dk.molslinjen.domain.model.agreement.commuter.oeresund;

import dk.molslinjen.api.services.commuter.oeresund.response.OeresundCommuterAgreementTypeDTO;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u0000 \b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\t"}, d2 = {"Ldk/molslinjen/domain/model/agreement/commuter/oeresund/OeresundCommuterAgreementType;", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;I)V", "Unknown", "Bizz", "Commute", "Punchcard", "Companion", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class OeresundCommuterAgreementType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ OeresundCommuterAgreementType[] $VALUES;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    public static final OeresundCommuterAgreementType Unknown = new OeresundCommuterAgreementType("Unknown", 0);
    public static final OeresundCommuterAgreementType Bizz = new OeresundCommuterAgreementType("Bizz", 1);
    public static final OeresundCommuterAgreementType Commute = new OeresundCommuterAgreementType("Commute", 2);
    public static final OeresundCommuterAgreementType Punchcard = new OeresundCommuterAgreementType("Punchcard", 3);

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0011\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0086\u0002¨\u0006\b"}, d2 = {"Ldk/molslinjen/domain/model/agreement/commuter/oeresund/OeresundCommuterAgreementType$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "invoke", "Ldk/molslinjen/domain/model/agreement/commuter/oeresund/OeresundCommuterAgreementType;", "dto", "Ldk/molslinjen/api/services/commuter/oeresund/response/OeresundCommuterAgreementTypeDTO;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {

        @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes2.dex */
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[OeresundCommuterAgreementTypeDTO.values().length];
                try {
                    iArr[OeresundCommuterAgreementTypeDTO.Unknown.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[OeresundCommuterAgreementTypeDTO.Bizz.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[OeresundCommuterAgreementTypeDTO.Commute.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[OeresundCommuterAgreementTypeDTO.Punchcard.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final OeresundCommuterAgreementType invoke(OeresundCommuterAgreementTypeDTO dto) {
            Intrinsics.checkNotNullParameter(dto, "dto");
            int i5 = WhenMappings.$EnumSwitchMapping$0[dto.ordinal()];
            if (i5 == 1) {
                return OeresundCommuterAgreementType.Unknown;
            }
            if (i5 == 2) {
                return OeresundCommuterAgreementType.Bizz;
            }
            if (i5 == 3) {
                return OeresundCommuterAgreementType.Commute;
            }
            if (i5 == 4) {
                return OeresundCommuterAgreementType.Punchcard;
            }
            throw new NoWhenBranchMatchedException();
        }

        private Companion() {
        }
    }

    private static final /* synthetic */ OeresundCommuterAgreementType[] $values() {
        return new OeresundCommuterAgreementType[]{Unknown, Bizz, Commute, Punchcard};
    }

    static {
        OeresundCommuterAgreementType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
        INSTANCE = new Companion(null);
    }

    private OeresundCommuterAgreementType(String str, int i5) {
    }

    public static EnumEntries<OeresundCommuterAgreementType> getEntries() {
        return $ENTRIES;
    }

    public static OeresundCommuterAgreementType valueOf(String str) {
        return (OeresundCommuterAgreementType) Enum.valueOf(OeresundCommuterAgreementType.class, str);
    }

    public static OeresundCommuterAgreementType[] values() {
        return (OeresundCommuterAgreementType[]) $VALUES.clone();
    }
}
