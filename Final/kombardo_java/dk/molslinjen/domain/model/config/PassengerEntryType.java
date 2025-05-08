package dk.molslinjen.domain.model.config;

import dk.molslinjen.api.services.config.response.ConfigurationResponseDTO;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u0000 \b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\bB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\t"}, d2 = {"Ldk/molslinjen/domain/model/config/PassengerEntryType;", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;I)V", "None", "Standard", "AdultsAndChildren", "PassengersOnly", "Companion", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class PassengerEntryType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ PassengerEntryType[] $VALUES;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    public static final PassengerEntryType None = new PassengerEntryType("None", 0);
    public static final PassengerEntryType Standard = new PassengerEntryType("Standard", 1);
    public static final PassengerEntryType AdultsAndChildren = new PassengerEntryType("AdultsAndChildren", 2);
    public static final PassengerEntryType PassengersOnly = new PassengerEntryType("PassengersOnly", 3);

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0011\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0086\u0002¨\u0006\b"}, d2 = {"Ldk/molslinjen/domain/model/config/PassengerEntryType$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "invoke", "Ldk/molslinjen/domain/model/config/PassengerEntryType;", "dto", "Ldk/molslinjen/api/services/config/response/ConfigurationResponseDTO$PassengerEntryTypeDTO;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {

        @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes2.dex */
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[ConfigurationResponseDTO.PassengerEntryTypeDTO.values().length];
                try {
                    iArr[ConfigurationResponseDTO.PassengerEntryTypeDTO.None.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[ConfigurationResponseDTO.PassengerEntryTypeDTO.Standard.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[ConfigurationResponseDTO.PassengerEntryTypeDTO.AdultsAndChildren.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[ConfigurationResponseDTO.PassengerEntryTypeDTO.PassengersOnly.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final PassengerEntryType invoke(ConfigurationResponseDTO.PassengerEntryTypeDTO dto) {
            Intrinsics.checkNotNullParameter(dto, "dto");
            int i5 = WhenMappings.$EnumSwitchMapping$0[dto.ordinal()];
            if (i5 == 1) {
                return PassengerEntryType.None;
            }
            if (i5 == 2) {
                return PassengerEntryType.Standard;
            }
            if (i5 == 3) {
                return PassengerEntryType.AdultsAndChildren;
            }
            if (i5 == 4) {
                return PassengerEntryType.PassengersOnly;
            }
            throw new NoWhenBranchMatchedException();
        }

        private Companion() {
        }
    }

    private static final /* synthetic */ PassengerEntryType[] $values() {
        return new PassengerEntryType[]{None, Standard, AdultsAndChildren, PassengersOnly};
    }

    static {
        PassengerEntryType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
        INSTANCE = new Companion(null);
    }

    private PassengerEntryType(String str, int i5) {
    }

    public static EnumEntries<PassengerEntryType> getEntries() {
        return $ENTRIES;
    }

    public static PassengerEntryType valueOf(String str) {
        return (PassengerEntryType) Enum.valueOf(PassengerEntryType.class, str);
    }

    public static PassengerEntryType[] values() {
        return (PassengerEntryType[]) $VALUES.clone();
    }
}
