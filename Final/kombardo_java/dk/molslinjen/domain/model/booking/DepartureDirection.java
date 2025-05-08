package dk.molslinjen.domain.model.booking;

import dk.molslinjen.api.services.booking.request.DirectionDTO;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0081\u0002\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\tB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0006\u001a\u00020\u0000J\u0006\u0010\u0007\u001a\u00020\bj\u0002\b\u0004j\u0002\b\u0005¨\u0006\n"}, d2 = {"Ldk/molslinjen/domain/model/booking/DepartureDirection;", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;I)V", "Outbound", "Return", "invert", "toDTO", "Ldk/molslinjen/api/services/booking/request/DirectionDTO;", "Companion", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class DepartureDirection {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ DepartureDirection[] $VALUES;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    public static final DepartureDirection Outbound = new DepartureDirection("Outbound", 0);
    public static final DepartureDirection Return = new DepartureDirection("Return", 1);

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0011\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0086\u0002¨\u0006\b"}, d2 = {"Ldk/molslinjen/domain/model/booking/DepartureDirection$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "invoke", "Ldk/molslinjen/domain/model/booking/DepartureDirection;", "name", BuildConfig.FLAVOR, "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final DepartureDirection invoke(String name) {
            Intrinsics.checkNotNullParameter(name, "name");
            for (DepartureDirection departureDirection : DepartureDirection.values()) {
                if (Intrinsics.areEqual(departureDirection.name(), name)) {
                    return departureDirection;
                }
            }
            throw new NoSuchElementException("Array contains no element matching the predicate.");
        }

        private Companion() {
        }
    }

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[DepartureDirection.values().length];
            try {
                iArr[DepartureDirection.Outbound.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[DepartureDirection.Return.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private static final /* synthetic */ DepartureDirection[] $values() {
        return new DepartureDirection[]{Outbound, Return};
    }

    static {
        DepartureDirection[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
        INSTANCE = new Companion(null);
    }

    private DepartureDirection(String str, int i5) {
    }

    public static EnumEntries<DepartureDirection> getEntries() {
        return $ENTRIES;
    }

    public static DepartureDirection valueOf(String str) {
        return (DepartureDirection) Enum.valueOf(DepartureDirection.class, str);
    }

    public static DepartureDirection[] values() {
        return (DepartureDirection[]) $VALUES.clone();
    }

    public final DepartureDirection invert() {
        int i5 = WhenMappings.$EnumSwitchMapping$0[ordinal()];
        if (i5 == 1) {
            return Return;
        }
        if (i5 == 2) {
            return Outbound;
        }
        throw new NoWhenBranchMatchedException();
    }

    public final DirectionDTO toDTO() {
        int i5 = WhenMappings.$EnumSwitchMapping$0[ordinal()];
        if (i5 == 1) {
            return DirectionDTO.Outbound;
        }
        if (i5 == 2) {
            return DirectionDTO.Return;
        }
        throw new NoWhenBranchMatchedException();
    }
}
