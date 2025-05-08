package dk.molslinjen.domain.model.booking;

import dk.molslinjen.api.services.geolocator.response.TravelModeDTO;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\fB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Ldk/molslinjen/domain/model/booking/TravelMode;", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;I)V", "Bicycle", "Bus", "Car", "Motorcycle", "Pedestrian", "Taxi", "Truck", "Van", "Companion", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class TravelMode {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ TravelMode[] $VALUES;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    public static final TravelMode Bicycle = new TravelMode("Bicycle", 0);
    public static final TravelMode Bus = new TravelMode("Bus", 1);
    public static final TravelMode Car = new TravelMode("Car", 2);
    public static final TravelMode Motorcycle = new TravelMode("Motorcycle", 3);
    public static final TravelMode Pedestrian = new TravelMode("Pedestrian", 4);
    public static final TravelMode Taxi = new TravelMode("Taxi", 5);
    public static final TravelMode Truck = new TravelMode("Truck", 6);
    public static final TravelMode Van = new TravelMode("Van", 7);

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0011\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0086\u0002¨\u0006\b"}, d2 = {"Ldk/molslinjen/domain/model/booking/TravelMode$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "invoke", "Ldk/molslinjen/domain/model/booking/TravelMode;", "dto", "Ldk/molslinjen/api/services/geolocator/response/TravelModeDTO;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {

        @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes2.dex */
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[TravelModeDTO.values().length];
                try {
                    iArr[TravelModeDTO.Bicycle.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[TravelModeDTO.Bus.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[TravelModeDTO.Car.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[TravelModeDTO.Motorcycle.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                try {
                    iArr[TravelModeDTO.Pedestrian.ordinal()] = 5;
                } catch (NoSuchFieldError unused5) {
                }
                try {
                    iArr[TravelModeDTO.Taxi.ordinal()] = 6;
                } catch (NoSuchFieldError unused6) {
                }
                try {
                    iArr[TravelModeDTO.Truck.ordinal()] = 7;
                } catch (NoSuchFieldError unused7) {
                }
                try {
                    iArr[TravelModeDTO.Van.ordinal()] = 8;
                } catch (NoSuchFieldError unused8) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final TravelMode invoke(TravelModeDTO dto) {
            Intrinsics.checkNotNullParameter(dto, "dto");
            switch (WhenMappings.$EnumSwitchMapping$0[dto.ordinal()]) {
                case 1:
                    return TravelMode.Bicycle;
                case 2:
                    return TravelMode.Bus;
                case 3:
                    return TravelMode.Car;
                case 4:
                    return TravelMode.Motorcycle;
                case 5:
                    return TravelMode.Pedestrian;
                case 6:
                    return TravelMode.Taxi;
                case 7:
                    return TravelMode.Truck;
                case 8:
                    return TravelMode.Van;
                default:
                    throw new NoWhenBranchMatchedException();
            }
        }

        private Companion() {
        }
    }

    private static final /* synthetic */ TravelMode[] $values() {
        return new TravelMode[]{Bicycle, Bus, Car, Motorcycle, Pedestrian, Taxi, Truck, Van};
    }

    static {
        TravelMode[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
        INSTANCE = new Companion(null);
    }

    private TravelMode(String str, int i5) {
    }

    public static EnumEntries<TravelMode> getEntries() {
        return $ENTRIES;
    }

    public static TravelMode valueOf(String str) {
        return (TravelMode) Enum.valueOf(TravelMode.class, str);
    }

    public static TravelMode[] values() {
        return (TravelMode[]) $VALUES.clone();
    }
}
