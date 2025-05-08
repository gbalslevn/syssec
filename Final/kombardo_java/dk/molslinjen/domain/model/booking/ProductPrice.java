package dk.molslinjen.domain.model.booking;

import dk.molslinjen.api.services.booking.response.DeparturesResponseDTO;
import dk.molslinjen.domain.model.shared.PriceWithCurrency;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tB\u0011\b\u0016\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\b\u0010\fJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0007HÆ\u0003J'\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001e"}, d2 = {"Ldk/molslinjen/domain/model/booking/ProductPrice;", BuildConfig.FLAVOR, "productId", BuildConfig.FLAVOR, "productType", "Ldk/molslinjen/domain/model/booking/ProductType;", "unitPrice", "Ldk/molslinjen/domain/model/shared/PriceWithCurrency;", "<init>", "(Ljava/lang/String;Ldk/molslinjen/domain/model/booking/ProductType;Ldk/molslinjen/domain/model/shared/PriceWithCurrency;)V", "dto", "Ldk/molslinjen/api/services/booking/response/DeparturesResponseDTO$ProductPriceResponseDTO;", "(Ldk/molslinjen/api/services/booking/response/DeparturesResponseDTO$ProductPriceResponseDTO;)V", "getProductId", "()Ljava/lang/String;", "getProductType", "()Ldk/molslinjen/domain/model/booking/ProductType;", "getUnitPrice", "()Ldk/molslinjen/domain/model/shared/PriceWithCurrency;", "component1", "component2", "component3", "copy", "equals", BuildConfig.FLAVOR, "other", "hashCode", BuildConfig.FLAVOR, "toString", "Companion", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class ProductPrice {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final ProductPrice mock = new ProductPrice("XX", ProductType.Extra, PriceWithCurrency.INSTANCE.mock(100));
    private final String productId;
    private final ProductType productType;
    private final PriceWithCurrency unitPrice;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Ldk/molslinjen/domain/model/booking/ProductPrice$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "mock", "Ldk/molslinjen/domain/model/booking/ProductPrice;", "getMock", "()Ldk/molslinjen/domain/model/booking/ProductPrice;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ProductPrice getMock() {
            return ProductPrice.mock;
        }

        private Companion() {
        }
    }

    public ProductPrice(String productId, ProductType productType, PriceWithCurrency unitPrice) {
        Intrinsics.checkNotNullParameter(productId, "productId");
        Intrinsics.checkNotNullParameter(productType, "productType");
        Intrinsics.checkNotNullParameter(unitPrice, "unitPrice");
        this.productId = productId;
        this.productType = productType;
        this.unitPrice = unitPrice;
    }

    public static /* synthetic */ ProductPrice copy$default(ProductPrice productPrice, String str, ProductType productType, PriceWithCurrency priceWithCurrency, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            str = productPrice.productId;
        }
        if ((i5 & 2) != 0) {
            productType = productPrice.productType;
        }
        if ((i5 & 4) != 0) {
            priceWithCurrency = productPrice.unitPrice;
        }
        return productPrice.copy(str, productType, priceWithCurrency);
    }

    /* renamed from: component1, reason: from getter */
    public final String getProductId() {
        return this.productId;
    }

    /* renamed from: component2, reason: from getter */
    public final ProductType getProductType() {
        return this.productType;
    }

    /* renamed from: component3, reason: from getter */
    public final PriceWithCurrency getUnitPrice() {
        return this.unitPrice;
    }

    public final ProductPrice copy(String productId, ProductType productType, PriceWithCurrency unitPrice) {
        Intrinsics.checkNotNullParameter(productId, "productId");
        Intrinsics.checkNotNullParameter(productType, "productType");
        Intrinsics.checkNotNullParameter(unitPrice, "unitPrice");
        return new ProductPrice(productId, productType, unitPrice);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ProductPrice)) {
            return false;
        }
        ProductPrice productPrice = (ProductPrice) other;
        return Intrinsics.areEqual(this.productId, productPrice.productId) && this.productType == productPrice.productType && Intrinsics.areEqual(this.unitPrice, productPrice.unitPrice);
    }

    public final String getProductId() {
        return this.productId;
    }

    public final ProductType getProductType() {
        return this.productType;
    }

    public final PriceWithCurrency getUnitPrice() {
        return this.unitPrice;
    }

    public int hashCode() {
        return (((this.productId.hashCode() * 31) + this.productType.hashCode()) * 31) + this.unitPrice.hashCode();
    }

    public String toString() {
        return "ProductPrice(productId=" + this.productId + ", productType=" + this.productType + ", unitPrice=" + this.unitPrice + ")";
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ProductPrice(DeparturesResponseDTO.ProductPriceResponseDTO dto) {
        this(dto.getProductId(), ProductType.INSTANCE.invoke(dto.getProductType()), new PriceWithCurrency(dto.getUnitPrice()));
        Intrinsics.checkNotNullParameter(dto, "dto");
    }
}
