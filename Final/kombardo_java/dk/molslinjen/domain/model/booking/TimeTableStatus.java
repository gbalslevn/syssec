package dk.molslinjen.domain.model.booking;

import dk.molslinjen.api.services.booking.response.DeparturesResponseDTO;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0086\u0081\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\b\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\b\u0010\nj\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\f"}, d2 = {"Ldk/molslinjen/domain/model/booking/TimeTableStatus;", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;I)V", "Available", "AvailableLaterDate", "NotAvailable", "NotAvailableForEdit", "isAvailable", BuildConfig.FLAVOR, "()Z", "Companion", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class TimeTableStatus {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ TimeTableStatus[] $VALUES;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    public static final TimeTableStatus Available = new TimeTableStatus("Available", 0);
    public static final TimeTableStatus AvailableLaterDate = new TimeTableStatus("AvailableLaterDate", 1);
    public static final TimeTableStatus NotAvailable = new TimeTableStatus("NotAvailable", 2);
    public static final TimeTableStatus NotAvailableForEdit = new TimeTableStatus("NotAvailableForEdit", 3);

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0011\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0086\u0002¨\u0006\b"}, d2 = {"Ldk/molslinjen/domain/model/booking/TimeTableStatus$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "invoke", "Ldk/molslinjen/domain/model/booking/TimeTableStatus;", "dto", "Ldk/molslinjen/api/services/booking/response/DeparturesResponseDTO$TimeTableStatusDTO;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {

        @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes2.dex */
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[DeparturesResponseDTO.TimeTableStatusDTO.values().length];
                try {
                    iArr[DeparturesResponseDTO.TimeTableStatusDTO.Available.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[DeparturesResponseDTO.TimeTableStatusDTO.AvailableLaterDate.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[DeparturesResponseDTO.TimeTableStatusDTO.NotAvailable.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[DeparturesResponseDTO.TimeTableStatusDTO.NotAvailableForEdit.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final TimeTableStatus invoke(DeparturesResponseDTO.TimeTableStatusDTO dto) {
            Intrinsics.checkNotNullParameter(dto, "dto");
            int i5 = WhenMappings.$EnumSwitchMapping$0[dto.ordinal()];
            if (i5 == 1) {
                return TimeTableStatus.Available;
            }
            if (i5 == 2) {
                return TimeTableStatus.AvailableLaterDate;
            }
            if (i5 == 3) {
                return TimeTableStatus.NotAvailable;
            }
            if (i5 == 4) {
                return TimeTableStatus.NotAvailableForEdit;
            }
            throw new NoWhenBranchMatchedException();
        }

        private Companion() {
        }
    }

    private static final /* synthetic */ TimeTableStatus[] $values() {
        return new TimeTableStatus[]{Available, AvailableLaterDate, NotAvailable, NotAvailableForEdit};
    }

    static {
        TimeTableStatus[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
        INSTANCE = new Companion(null);
    }

    private TimeTableStatus(String str, int i5) {
    }

    public static EnumEntries<TimeTableStatus> getEntries() {
        return $ENTRIES;
    }

    public static TimeTableStatus valueOf(String str) {
        return (TimeTableStatus) Enum.valueOf(TimeTableStatus.class, str);
    }

    public static TimeTableStatus[] values() {
        return (TimeTableStatus[]) $VALUES.clone();
    }

    public final boolean isAvailable() {
        return this == Available || this == AvailableLaterDate;
    }
}
