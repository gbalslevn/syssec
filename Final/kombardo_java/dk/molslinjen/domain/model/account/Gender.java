package dk.molslinjen.domain.model.account;

import dk.molslinjen.api.services.account.passenger.response.GenderDTO;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0081\u0002\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\tB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0007\u001a\u00020\bj\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\n"}, d2 = {"Ldk/molslinjen/domain/model/account/Gender;", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;I)V", "Male", "Female", "Other", "toDTO", "Ldk/molslinjen/api/services/account/passenger/response/GenderDTO;", "Companion", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class Gender {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ Gender[] $VALUES;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    public static final Gender Male = new Gender("Male", 0);
    public static final Gender Female = new Gender("Female", 1);
    public static final Gender Other = new Gender("Other", 2);

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0011\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0086\u0002¨\u0006\b"}, d2 = {"Ldk/molslinjen/domain/model/account/Gender$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "invoke", "Ldk/molslinjen/domain/model/account/Gender;", "dto", "Ldk/molslinjen/api/services/account/passenger/response/GenderDTO;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {

        @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes2.dex */
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[GenderDTO.values().length];
                try {
                    iArr[GenderDTO.Male.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[GenderDTO.Female.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[GenderDTO.Other.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Gender invoke(GenderDTO dto) {
            Intrinsics.checkNotNullParameter(dto, "dto");
            int i5 = WhenMappings.$EnumSwitchMapping$0[dto.ordinal()];
            if (i5 == 1) {
                return Gender.Male;
            }
            if (i5 == 2) {
                return Gender.Female;
            }
            if (i5 == 3) {
                return Gender.Other;
            }
            throw new NoWhenBranchMatchedException();
        }

        private Companion() {
        }
    }

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Gender.values().length];
            try {
                iArr[Gender.Male.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Gender.Female.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Gender.Other.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private static final /* synthetic */ Gender[] $values() {
        return new Gender[]{Male, Female, Other};
    }

    static {
        Gender[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
        INSTANCE = new Companion(null);
    }

    private Gender(String str, int i5) {
    }

    public static EnumEntries<Gender> getEntries() {
        return $ENTRIES;
    }

    public static Gender valueOf(String str) {
        return (Gender) Enum.valueOf(Gender.class, str);
    }

    public static Gender[] values() {
        return (Gender[]) $VALUES.clone();
    }

    public final GenderDTO toDTO() {
        int i5 = WhenMappings.$EnumSwitchMapping$0[ordinal()];
        if (i5 == 1) {
            return GenderDTO.Male;
        }
        if (i5 == 2) {
            return GenderDTO.Female;
        }
        if (i5 == 3) {
            return GenderDTO.Other;
        }
        throw new NoWhenBranchMatchedException();
    }
}
