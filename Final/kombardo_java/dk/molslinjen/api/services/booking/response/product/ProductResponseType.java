package dk.molslinjen.api.services.booking.response.product;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Ldk/molslinjen/api/services/booking/response/product/ProductResponseType;", BuildConfig.FLAVOR, "rawValue", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getRawValue", "()Ljava/lang/String;", "Trailer", "Bike", "Extra", "Quantity", "Companion", "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ProductResponseType {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ ProductResponseType[] $VALUES;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private final String rawValue;
    public static final ProductResponseType Trailer = new ProductResponseType("Trailer", 0, "ProductTrailerModel");
    public static final ProductResponseType Bike = new ProductResponseType("Bike", 1, "ProductBikeModel");
    public static final ProductResponseType Extra = new ProductResponseType("Extra", 2, "ProductExtraModel");
    public static final ProductResponseType Quantity = new ProductResponseType("Quantity", 3, "ProductQuantityModel");

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0086\u0002¨\u0006\b"}, d2 = {"Ldk/molslinjen/api/services/booking/response/product/ProductResponseType$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "invoke", "Ldk/molslinjen/api/services/booking/response/product/ProductResponseType;", "rawValue", BuildConfig.FLAVOR, "api_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ProductResponseType invoke(String rawValue) {
            for (ProductResponseType productResponseType : ProductResponseType.values()) {
                if (Intrinsics.areEqual(productResponseType.getRawValue(), rawValue)) {
                    return productResponseType;
                }
            }
            return null;
        }

        private Companion() {
        }
    }

    private static final /* synthetic */ ProductResponseType[] $values() {
        return new ProductResponseType[]{Trailer, Bike, Extra, Quantity};
    }

    static {
        ProductResponseType[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
        INSTANCE = new Companion(null);
    }

    private ProductResponseType(String str, int i5, String str2) {
        this.rawValue = str2;
    }

    public static EnumEntries<ProductResponseType> getEntries() {
        return $ENTRIES;
    }

    public static ProductResponseType valueOf(String str) {
        return (ProductResponseType) Enum.valueOf(ProductResponseType.class, str);
    }

    public static ProductResponseType[] values() {
        return (ProductResponseType[]) $VALUES.clone();
    }

    public final String getRawValue() {
        return this.rawValue;
    }
}
