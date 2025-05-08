package dk.molslinjen.api.services.booking.response;

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
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\r\b\u0087\u0081\u0002\u0018\u0000 \u00102\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0002\u000f\u0010B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u0011"}, d2 = {"Ldk/molslinjen/api/services/booking/response/ProductTypeResponseDTO;", "Ldk/molslinjen/api/helpers/serializers/SerializableEnum;", BuildConfig.FLAVOR, "rawValue", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;II)V", "getRawValue", "()I", "Catering", "Extra", "Bike", "Bunk", "Trailer", "SelectSeating", "Serializer", "Companion", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable(with = Serializer.class)
/* loaded from: classes2.dex */
public final class ProductTypeResponseDTO implements SerializableEnum {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ ProductTypeResponseDTO[] $VALUES;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private final int rawValue;
    public static final ProductTypeResponseDTO Catering = new ProductTypeResponseDTO("Catering", 0, 0);
    public static final ProductTypeResponseDTO Extra = new ProductTypeResponseDTO("Extra", 1, 1);
    public static final ProductTypeResponseDTO Bike = new ProductTypeResponseDTO("Bike", 2, 2);
    public static final ProductTypeResponseDTO Bunk = new ProductTypeResponseDTO("Bunk", 3, 3);
    public static final ProductTypeResponseDTO Trailer = new ProductTypeResponseDTO("Trailer", 4, 4);
    public static final ProductTypeResponseDTO SelectSeating = new ProductTypeResponseDTO("SelectSeating", 5, 5);

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Ldk/molslinjen/api/services/booking/response/ProductTypeResponseDTO$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Ldk/molslinjen/api/services/booking/response/ProductTypeResponseDTO;", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public final KSerializer<ProductTypeResponseDTO> serializer() {
            return Serializer.INSTANCE;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Ldk/molslinjen/api/services/booking/response/ProductTypeResponseDTO$Serializer;", "Ldk/molslinjen/api/helpers/serializers/IntToEnumSerializer;", "Ldk/molslinjen/api/services/booking/response/ProductTypeResponseDTO;", "<init>", "()V", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Serializer extends IntToEnumSerializer<ProductTypeResponseDTO> {
        public static final Serializer INSTANCE = new Serializer();

        private Serializer() {
            super(ProductTypeResponseDTO.class);
        }
    }

    private static final /* synthetic */ ProductTypeResponseDTO[] $values() {
        return new ProductTypeResponseDTO[]{Catering, Extra, Bike, Bunk, Trailer, SelectSeating};
    }

    static {
        ProductTypeResponseDTO[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
        INSTANCE = new Companion(null);
    }

    private ProductTypeResponseDTO(String str, int i5, int i6) {
        this.rawValue = i6;
    }

    public static EnumEntries<ProductTypeResponseDTO> getEntries() {
        return $ENTRIES;
    }

    public static ProductTypeResponseDTO valueOf(String str) {
        return (ProductTypeResponseDTO) Enum.valueOf(ProductTypeResponseDTO.class, str);
    }

    public static ProductTypeResponseDTO[] values() {
        return (ProductTypeResponseDTO[]) $VALUES.clone();
    }

    @Override // dk.molslinjen.api.helpers.serializers.SerializableEnum
    public int getRawValue() {
        return this.rawValue;
    }
}
