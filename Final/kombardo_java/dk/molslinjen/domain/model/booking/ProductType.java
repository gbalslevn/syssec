package dk.molslinjen.domain.model.booking;

import dk.molslinjen.api.services.booking.response.ProductTypeResponseDTO;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0081\u0002\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\fB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\n\u001a\u00020\u000bj\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\r"}, d2 = {"Ldk/molslinjen/domain/model/booking/ProductType;", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;I)V", "Catering", "Extra", "Bike", "Bunk", "Trailer", "SelectSeating", "toDTO", "Ldk/molslinjen/api/services/booking/response/ProductTypeResponseDTO;", "Companion", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ProductType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ ProductType[] $VALUES;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    public static final ProductType Catering = new ProductType("Catering", 0);
    public static final ProductType Extra = new ProductType("Extra", 1);
    public static final ProductType Bike = new ProductType("Bike", 2);
    public static final ProductType Bunk = new ProductType("Bunk", 3);
    public static final ProductType Trailer = new ProductType("Trailer", 4);
    public static final ProductType SelectSeating = new ProductType("SelectSeating", 5);

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0011\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0086\u0002¨\u0006\b"}, d2 = {"Ldk/molslinjen/domain/model/booking/ProductType$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "invoke", "Ldk/molslinjen/domain/model/booking/ProductType;", "dto", "Ldk/molslinjen/api/services/booking/response/ProductTypeResponseDTO;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {

        @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes2.dex */
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[ProductTypeResponseDTO.values().length];
                try {
                    iArr[ProductTypeResponseDTO.Catering.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[ProductTypeResponseDTO.Extra.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[ProductTypeResponseDTO.Bike.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[ProductTypeResponseDTO.Bunk.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                try {
                    iArr[ProductTypeResponseDTO.Trailer.ordinal()] = 5;
                } catch (NoSuchFieldError unused5) {
                }
                try {
                    iArr[ProductTypeResponseDTO.SelectSeating.ordinal()] = 6;
                } catch (NoSuchFieldError unused6) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ProductType invoke(ProductTypeResponseDTO dto) {
            Intrinsics.checkNotNullParameter(dto, "dto");
            switch (WhenMappings.$EnumSwitchMapping$0[dto.ordinal()]) {
                case 1:
                    return ProductType.Catering;
                case 2:
                    return ProductType.Extra;
                case 3:
                    return ProductType.Bike;
                case 4:
                    return ProductType.Bunk;
                case 5:
                    return ProductType.Trailer;
                case 6:
                    return ProductType.SelectSeating;
                default:
                    throw new NoWhenBranchMatchedException();
            }
        }

        private Companion() {
        }
    }

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ProductType.values().length];
            try {
                iArr[ProductType.Catering.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ProductType.Extra.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ProductType.Bike.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ProductType.Bunk.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[ProductType.Trailer.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[ProductType.SelectSeating.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private static final /* synthetic */ ProductType[] $values() {
        return new ProductType[]{Catering, Extra, Bike, Bunk, Trailer, SelectSeating};
    }

    static {
        ProductType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
        INSTANCE = new Companion(null);
    }

    private ProductType(String str, int i5) {
    }

    public static EnumEntries<ProductType> getEntries() {
        return $ENTRIES;
    }

    public static ProductType valueOf(String str) {
        return (ProductType) Enum.valueOf(ProductType.class, str);
    }

    public static ProductType[] values() {
        return (ProductType[]) $VALUES.clone();
    }

    public final ProductTypeResponseDTO toDTO() {
        switch (WhenMappings.$EnumSwitchMapping$0[ordinal()]) {
            case 1:
                return ProductTypeResponseDTO.Catering;
            case 2:
                return ProductTypeResponseDTO.Extra;
            case 3:
                return ProductTypeResponseDTO.Bike;
            case 4:
                return ProductTypeResponseDTO.Bunk;
            case 5:
                return ProductTypeResponseDTO.Trailer;
            case 6:
                return ProductTypeResponseDTO.SelectSeating;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }
}
