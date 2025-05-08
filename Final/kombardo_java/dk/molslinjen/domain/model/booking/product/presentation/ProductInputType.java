package dk.molslinjen.domain.model.booking.product.presentation;

import dk.molslinjen.api.services.booking.response.ProductInputTypeResponseDTO;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u0000 \u00072\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0007B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\b"}, d2 = {"Ldk/molslinjen/domain/model/booking/product/presentation/ProductInputType;", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;I)V", "Checkbox", "Radio", "Numeric", "Companion", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ProductInputType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ ProductInputType[] $VALUES;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    public static final ProductInputType Checkbox = new ProductInputType("Checkbox", 0);
    public static final ProductInputType Radio = new ProductInputType("Radio", 1);
    public static final ProductInputType Numeric = new ProductInputType("Numeric", 2);

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0011\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0086\u0002¨\u0006\b"}, d2 = {"Ldk/molslinjen/domain/model/booking/product/presentation/ProductInputType$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "invoke", "Ldk/molslinjen/domain/model/booking/product/presentation/ProductInputType;", "dto", "Ldk/molslinjen/api/services/booking/response/ProductInputTypeResponseDTO;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {

        @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
        /* loaded from: classes2.dex */
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[ProductInputTypeResponseDTO.values().length];
                try {
                    iArr[ProductInputTypeResponseDTO.Checkbox.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[ProductInputTypeResponseDTO.Radio.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[ProductInputTypeResponseDTO.Numeric.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ProductInputType invoke(ProductInputTypeResponseDTO dto) {
            Intrinsics.checkNotNullParameter(dto, "dto");
            int i5 = WhenMappings.$EnumSwitchMapping$0[dto.ordinal()];
            if (i5 == 1) {
                return ProductInputType.Checkbox;
            }
            if (i5 == 2) {
                return ProductInputType.Radio;
            }
            if (i5 == 3) {
                return ProductInputType.Numeric;
            }
            throw new NoWhenBranchMatchedException();
        }

        private Companion() {
        }
    }

    private static final /* synthetic */ ProductInputType[] $values() {
        return new ProductInputType[]{Checkbox, Radio, Numeric};
    }

    static {
        ProductInputType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
        INSTANCE = new Companion(null);
    }

    private ProductInputType(String str, int i5) {
    }

    public static EnumEntries<ProductInputType> getEntries() {
        return $ENTRIES;
    }

    public static ProductInputType valueOf(String str) {
        return (ProductInputType) Enum.valueOf(ProductInputType.class, str);
    }

    public static ProductInputType[] values() {
        return (ProductInputType[]) $VALUES.clone();
    }
}
