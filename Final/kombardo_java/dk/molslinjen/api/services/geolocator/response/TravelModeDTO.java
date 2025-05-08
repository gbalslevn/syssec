package dk.molslinjen.api.services.geolocator.response;

import dk.molslinjen.api.helpers.serializers.IntToEnumSerializer;
import dk.molslinjen.api.helpers.serializers.SerializableEnum;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import org.conscrypt.BuildConfig;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\b\u0087\u0081\u0002\u0018\u0000 \u00122\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0002\u0011\u0012B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0013"}, d2 = {"Ldk/molslinjen/api/services/geolocator/response/TravelModeDTO;", "Ldk/molslinjen/api/helpers/serializers/SerializableEnum;", BuildConfig.FLAVOR, "rawValue", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;II)V", "getRawValue", "()I", "Bicycle", "Bus", "Car", "Motorcycle", "Pedestrian", "Taxi", "Truck", "Van", "Serializer", "Companion", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable(with = Serializer.class)
/* loaded from: classes2.dex */
public final class TravelModeDTO implements SerializableEnum {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ TravelModeDTO[] $VALUES;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private final int rawValue;
    public static final TravelModeDTO Bicycle = new TravelModeDTO("Bicycle", 0, 0);
    public static final TravelModeDTO Bus = new TravelModeDTO("Bus", 1, 1);
    public static final TravelModeDTO Car = new TravelModeDTO("Car", 2, 2);
    public static final TravelModeDTO Motorcycle = new TravelModeDTO("Motorcycle", 3, 3);
    public static final TravelModeDTO Pedestrian = new TravelModeDTO("Pedestrian", 4, 4);
    public static final TravelModeDTO Taxi = new TravelModeDTO("Taxi", 5, 5);
    public static final TravelModeDTO Truck = new TravelModeDTO("Truck", 6, 6);
    public static final TravelModeDTO Van = new TravelModeDTO("Van", 7, 7);

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Ldk/molslinjen/api/services/geolocator/response/TravelModeDTO$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldk/molslinjen/api/services/geolocator/response/TravelModeDTO;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public final KSerializer<TravelModeDTO> serializer() {
            return Serializer.INSTANCE;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Ldk/molslinjen/api/services/geolocator/response/TravelModeDTO$Serializer;", "Ldk/molslinjen/api/helpers/serializers/IntToEnumSerializer;", "Ldk/molslinjen/api/services/geolocator/response/TravelModeDTO;", "<init>", "()V", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Serializer extends IntToEnumSerializer<TravelModeDTO> {
        public static final Serializer INSTANCE = new Serializer();

        private Serializer() {
            super(TravelModeDTO.class);
        }
    }

    private static final /* synthetic */ TravelModeDTO[] $values() {
        return new TravelModeDTO[]{Bicycle, Bus, Car, Motorcycle, Pedestrian, Taxi, Truck, Van};
    }

    static {
        TravelModeDTO[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
        INSTANCE = new Companion(null);
    }

    private TravelModeDTO(String str, int i5, int i6) {
        this.rawValue = i6;
    }

    public static EnumEntries<TravelModeDTO> getEntries() {
        return $ENTRIES;
    }

    public static TravelModeDTO valueOf(String str) {
        return (TravelModeDTO) Enum.valueOf(TravelModeDTO.class, str);
    }

    public static TravelModeDTO[] values() {
        return (TravelModeDTO[]) $VALUES.clone();
    }

    @Override // dk.molslinjen.api.helpers.serializers.SerializableEnum
    public int getRawValue() {
        return this.rawValue;
    }
}
