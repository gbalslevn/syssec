package dk.molslinjen.domain.model.booking;

import dk.molslinjen.api.shared.response.RouteTypeResponseDTO;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\tB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\n"}, d2 = {"Ldk/molslinjen/domain/model/booking/RouteType;", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;I)V", "Ferry", "Bridge", "Shuttle", "BusOnly", "BusBus", "Companion", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class RouteType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ RouteType[] $VALUES;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    public static final RouteType Ferry = new RouteType("Ferry", 0);
    public static final RouteType Bridge = new RouteType("Bridge", 1);
    public static final RouteType Shuttle = new RouteType("Shuttle", 2);
    public static final RouteType BusOnly = new RouteType("BusOnly", 3);
    public static final RouteType BusBus = new RouteType("BusBus", 4);

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0011\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0086\u0002¨\u0006\b"}, d2 = {"Ldk/molslinjen/domain/model/booking/RouteType$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "invoke", "Ldk/molslinjen/domain/model/booking/RouteType;", "dto", "Ldk/molslinjen/api/shared/response/RouteTypeResponseDTO;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {

        @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes2.dex */
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[RouteTypeResponseDTO.values().length];
                try {
                    iArr[RouteTypeResponseDTO.Ferry.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[RouteTypeResponseDTO.Bridge.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[RouteTypeResponseDTO.Shuttle.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[RouteTypeResponseDTO.BusOnly.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                try {
                    iArr[RouteTypeResponseDTO.BusBus.ordinal()] = 5;
                } catch (NoSuchFieldError unused5) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final RouteType invoke(RouteTypeResponseDTO dto) {
            Intrinsics.checkNotNullParameter(dto, "dto");
            int i5 = WhenMappings.$EnumSwitchMapping$0[dto.ordinal()];
            if (i5 == 1) {
                return RouteType.Ferry;
            }
            if (i5 == 2) {
                return RouteType.Bridge;
            }
            if (i5 == 3) {
                return RouteType.Shuttle;
            }
            if (i5 == 4) {
                return RouteType.BusOnly;
            }
            if (i5 == 5) {
                return RouteType.BusBus;
            }
            throw new NoWhenBranchMatchedException();
        }

        private Companion() {
        }
    }

    private static final /* synthetic */ RouteType[] $values() {
        return new RouteType[]{Ferry, Bridge, Shuttle, BusOnly, BusBus};
    }

    static {
        RouteType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
        INSTANCE = new Companion(null);
    }

    private RouteType(String str, int i5) {
    }

    public static EnumEntries<RouteType> getEntries() {
        return $ENTRIES;
    }

    public static RouteType valueOf(String str) {
        return (RouteType) Enum.valueOf(RouteType.class, str);
    }

    public static RouteType[] values() {
        return (RouteType[]) $VALUES.clone();
    }
}
