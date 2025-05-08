package dk.molslinjen.api.services.account.vehicle.response;

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
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0087\u0081\u0002\u0018\u0000 \r2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0002\f\rB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\u000e"}, d2 = {"Ldk/molslinjen/api/services/account/vehicle/response/LicensePlateValidationResultResponseDTO;", "Ldk/molslinjen/api/helpers/serializers/SerializableEnum;", BuildConfig.FLAVOR, "rawValue", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;II)V", "getRawValue", "()I", "Valid", "Unknown", "Invalid", "Serializer", "Companion", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable(with = Serializer.class)
/* loaded from: classes2.dex */
public final class LicensePlateValidationResultResponseDTO implements SerializableEnum {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ LicensePlateValidationResultResponseDTO[] $VALUES;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private final int rawValue;
    public static final LicensePlateValidationResultResponseDTO Valid = new LicensePlateValidationResultResponseDTO("Valid", 0, 0);
    public static final LicensePlateValidationResultResponseDTO Unknown = new LicensePlateValidationResultResponseDTO("Unknown", 1, 1);
    public static final LicensePlateValidationResultResponseDTO Invalid = new LicensePlateValidationResultResponseDTO("Invalid", 2, 2);

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Ldk/molslinjen/api/services/account/vehicle/response/LicensePlateValidationResultResponseDTO$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldk/molslinjen/api/services/account/vehicle/response/LicensePlateValidationResultResponseDTO;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public final KSerializer<LicensePlateValidationResultResponseDTO> serializer() {
            return Serializer.INSTANCE;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Ldk/molslinjen/api/services/account/vehicle/response/LicensePlateValidationResultResponseDTO$Serializer;", "Ldk/molslinjen/api/helpers/serializers/IntToEnumSerializer;", "Ldk/molslinjen/api/services/account/vehicle/response/LicensePlateValidationResultResponseDTO;", "<init>", "()V", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Serializer extends IntToEnumSerializer<LicensePlateValidationResultResponseDTO> {
        public static final Serializer INSTANCE = new Serializer();

        private Serializer() {
            super(LicensePlateValidationResultResponseDTO.class);
        }
    }

    private static final /* synthetic */ LicensePlateValidationResultResponseDTO[] $values() {
        return new LicensePlateValidationResultResponseDTO[]{Valid, Unknown, Invalid};
    }

    static {
        LicensePlateValidationResultResponseDTO[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
        INSTANCE = new Companion(null);
    }

    private LicensePlateValidationResultResponseDTO(String str, int i5, int i6) {
        this.rawValue = i6;
    }

    public static EnumEntries<LicensePlateValidationResultResponseDTO> getEntries() {
        return $ENTRIES;
    }

    public static LicensePlateValidationResultResponseDTO valueOf(String str) {
        return (LicensePlateValidationResultResponseDTO) Enum.valueOf(LicensePlateValidationResultResponseDTO.class, str);
    }

    public static LicensePlateValidationResultResponseDTO[] values() {
        return (LicensePlateValidationResultResponseDTO[]) $VALUES.clone();
    }

    @Override // dk.molslinjen.api.helpers.serializers.SerializableEnum
    public int getRawValue() {
        return this.rawValue;
    }
}
