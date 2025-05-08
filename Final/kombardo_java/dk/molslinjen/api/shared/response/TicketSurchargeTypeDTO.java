package dk.molslinjen.api.shared.response;

import dk.molslinjen.api.helpers.serializers.IntToEnumSerializer;
import dk.molslinjen.api.helpers.serializers.SerializableEnum;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.encoding.Decoder;
import org.conscrypt.BuildConfig;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0087\u0081\u0002\u0018\u0000 \f2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0002\u000b\fB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\n¨\u0006\r"}, d2 = {"Ldk/molslinjen/api/shared/response/TicketSurchargeTypeDTO;", "Ldk/molslinjen/api/helpers/serializers/SerializableEnum;", BuildConfig.FLAVOR, "rawValue", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;II)V", "getRawValue", "()I", "Unknown", "Goods", "Serializer", "Companion", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable(with = Serializer.class)
/* loaded from: classes2.dex */
public final class TicketSurchargeTypeDTO implements SerializableEnum {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ TicketSurchargeTypeDTO[] $VALUES;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private final int rawValue;
    public static final TicketSurchargeTypeDTO Unknown = new TicketSurchargeTypeDTO("Unknown", 0, -1);
    public static final TicketSurchargeTypeDTO Goods = new TicketSurchargeTypeDTO("Goods", 1, 0);

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Ldk/molslinjen/api/shared/response/TicketSurchargeTypeDTO$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldk/molslinjen/api/shared/response/TicketSurchargeTypeDTO;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public final KSerializer<TicketSurchargeTypeDTO> serializer() {
            return Serializer.INSTANCE;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private static final /* synthetic */ TicketSurchargeTypeDTO[] $values() {
        return new TicketSurchargeTypeDTO[]{Unknown, Goods};
    }

    static {
        TicketSurchargeTypeDTO[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
        INSTANCE = new Companion(null);
    }

    private TicketSurchargeTypeDTO(String str, int i5, int i6) {
        this.rawValue = i6;
    }

    public static TicketSurchargeTypeDTO valueOf(String str) {
        return (TicketSurchargeTypeDTO) Enum.valueOf(TicketSurchargeTypeDTO.class, str);
    }

    public static TicketSurchargeTypeDTO[] values() {
        return (TicketSurchargeTypeDTO[]) $VALUES.clone();
    }

    @Override // dk.molslinjen.api.helpers.serializers.SerializableEnum
    public int getRawValue() {
        return this.rawValue;
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"Ldk/molslinjen/api/shared/response/TicketSurchargeTypeDTO$Serializer;", "Ldk/molslinjen/api/helpers/serializers/IntToEnumSerializer;", "Ldk/molslinjen/api/shared/response/TicketSurchargeTypeDTO;", "<init>", "()V", "deserialize", "decoder", "Lkotlinx/serialization/encoding/Decoder;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Serializer extends IntToEnumSerializer<TicketSurchargeTypeDTO> {
        public static final Serializer INSTANCE = new Serializer();

        private Serializer() {
            super(TicketSurchargeTypeDTO.class);
        }

        @Override // dk.molslinjen.api.helpers.serializers.IntToEnumSerializer, kotlinx.serialization.DeserializationStrategy
        public TicketSurchargeTypeDTO deserialize(Decoder decoder) {
            Intrinsics.checkNotNullParameter(decoder, "decoder");
            try {
                return (TicketSurchargeTypeDTO) super.deserialize(decoder);
            } catch (Exception unused) {
                return TicketSurchargeTypeDTO.Unknown;
            }
        }
    }
}
