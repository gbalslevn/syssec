package dk.molslinjen.domain.model.booking;

import dk.molslinjen.api.services.booking.response.booking.AgeGroupResponseDTO;
import dk.molslinjen.domain.extensions.LocalDateTimeExtensionsKt;
import dk.molslinjen.domain.model.config.AgeClassifications;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;
import org.threeten.bp.LocalDate;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0007B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\b"}, d2 = {"Ldk/molslinjen/domain/model/booking/AgeGroup;", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;I)V", "Infant", "Child", "Adult", "Companion", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class AgeGroup {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ AgeGroup[] $VALUES;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    public static final AgeGroup Infant = new AgeGroup("Infant", 0);
    public static final AgeGroup Child = new AgeGroup("Child", 1);
    public static final AgeGroup Adult = new AgeGroup("Adult", 2);

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0011\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0086\u0002J\u0016\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f¨\u0006\r"}, d2 = {"Ldk/molslinjen/domain/model/booking/AgeGroup$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "invoke", "Ldk/molslinjen/domain/model/booking/AgeGroup;", "dto", "Ldk/molslinjen/api/services/booking/response/booking/AgeGroupResponseDTO;", "get", "ageClassifications", "Ldk/molslinjen/domain/model/config/AgeClassifications;", "birthDate", "Lorg/threeten/bp/LocalDate;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {

        @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes2.dex */
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[AgeGroupResponseDTO.values().length];
                try {
                    iArr[AgeGroupResponseDTO.Infant.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[AgeGroupResponseDTO.Child.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[AgeGroupResponseDTO.Adult.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final AgeGroup get(AgeClassifications ageClassifications, LocalDate birthDate) {
            Intrinsics.checkNotNullParameter(ageClassifications, "ageClassifications");
            Intrinsics.checkNotNullParameter(birthDate, "birthDate");
            int age = LocalDateTimeExtensionsKt.toAge(birthDate);
            return ageClassifications.getInfantRange().contains(age) ? AgeGroup.Infant : ageClassifications.getChildRange().contains(age) ? AgeGroup.Child : AgeGroup.Adult;
        }

        public final AgeGroup invoke(AgeGroupResponseDTO dto) {
            Intrinsics.checkNotNullParameter(dto, "dto");
            int i5 = WhenMappings.$EnumSwitchMapping$0[dto.ordinal()];
            if (i5 == 1) {
                return AgeGroup.Infant;
            }
            if (i5 == 2) {
                return AgeGroup.Child;
            }
            if (i5 == 3) {
                return AgeGroup.Adult;
            }
            throw new NoWhenBranchMatchedException();
        }

        private Companion() {
        }
    }

    private static final /* synthetic */ AgeGroup[] $values() {
        return new AgeGroup[]{Infant, Child, Adult};
    }

    static {
        AgeGroup[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
        INSTANCE = new Companion(null);
    }

    private AgeGroup(String str, int i5) {
    }

    public static EnumEntries<AgeGroup> getEntries() {
        return $ENTRIES;
    }

    public static AgeGroup valueOf(String str) {
        return (AgeGroup) Enum.valueOf(AgeGroup.class, str);
    }

    public static AgeGroup[] values() {
        return (AgeGroup[]) $VALUES.clone();
    }
}
