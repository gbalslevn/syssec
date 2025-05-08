package dk.molslinjen.domain.model.booking.product;

import com.sdk.growthbook.utils.Constants;
import dk.molslinjen.api.services.booking.response.ProductsResponseDTO;
import dk.molslinjen.domain.model.booking.ProductType;
import dk.molslinjen.domain.model.shared.PriceWithCurrency;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000  2\u00020\u0001:\u0001 B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nB\u0011\b\u0016\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\t\u0010\rJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0018\u001a\u00020\bHÆ\u0003J1\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006!"}, d2 = {"Ldk/molslinjen/domain/model/booking/product/UnavailableProduct;", BuildConfig.FLAVOR, Constants.ID_ATTRIBUTE_KEY, BuildConfig.FLAVOR, "name", "price", "Ldk/molslinjen/domain/model/shared/PriceWithCurrency;", "productType", "Ldk/molslinjen/domain/model/booking/ProductType;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ldk/molslinjen/domain/model/shared/PriceWithCurrency;Ldk/molslinjen/domain/model/booking/ProductType;)V", "dto", "Ldk/molslinjen/api/services/booking/response/ProductsResponseDTO$UnavailableProductResponseDTO;", "(Ldk/molslinjen/api/services/booking/response/ProductsResponseDTO$UnavailableProductResponseDTO;)V", "getId", "()Ljava/lang/String;", "getName", "getPrice", "()Ldk/molslinjen/domain/model/shared/PriceWithCurrency;", "getProductType", "()Ldk/molslinjen/domain/model/booking/ProductType;", "component1", "component2", "component3", "component4", "copy", "equals", BuildConfig.FLAVOR, "other", "hashCode", BuildConfig.FLAVOR, "toString", "Companion", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class UnavailableProduct {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final UnavailableProduct mock = new UnavailableProduct("1", "Burger med pommes frites", PriceWithCurrency.INSTANCE.mock(65), ProductType.Catering);
    private final String id;
    private final String name;
    private final PriceWithCurrency price;
    private final ProductType productType;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Ldk/molslinjen/domain/model/booking/product/UnavailableProduct$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "mock", "Ldk/molslinjen/domain/model/booking/product/UnavailableProduct;", "getMock", "()Ldk/molslinjen/domain/model/booking/product/UnavailableProduct;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final UnavailableProduct getMock() {
            return UnavailableProduct.mock;
        }

        private Companion() {
        }
    }

    public UnavailableProduct(String id, String name, PriceWithCurrency price, ProductType productType) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(price, "price");
        Intrinsics.checkNotNullParameter(productType, "productType");
        this.id = id;
        this.name = name;
        this.price = price;
        this.productType = productType;
    }

    public static /* synthetic */ UnavailableProduct copy$default(UnavailableProduct unavailableProduct, String str, String str2, PriceWithCurrency priceWithCurrency, ProductType productType, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            str = unavailableProduct.id;
        }
        if ((i5 & 2) != 0) {
            str2 = unavailableProduct.name;
        }
        if ((i5 & 4) != 0) {
            priceWithCurrency = unavailableProduct.price;
        }
        if ((i5 & 8) != 0) {
            productType = unavailableProduct.productType;
        }
        return unavailableProduct.copy(str, str2, priceWithCurrency, productType);
    }

    /* renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component3, reason: from getter */
    public final PriceWithCurrency getPrice() {
        return this.price;
    }

    /* renamed from: component4, reason: from getter */
    public final ProductType getProductType() {
        return this.productType;
    }

    public final UnavailableProduct copy(String id, String name, PriceWithCurrency price, ProductType productType) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(price, "price");
        Intrinsics.checkNotNullParameter(productType, "productType");
        return new UnavailableProduct(id, name, price, productType);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UnavailableProduct)) {
            return false;
        }
        UnavailableProduct unavailableProduct = (UnavailableProduct) other;
        return Intrinsics.areEqual(this.id, unavailableProduct.id) && Intrinsics.areEqual(this.name, unavailableProduct.name) && Intrinsics.areEqual(this.price, unavailableProduct.price) && this.productType == unavailableProduct.productType;
    }

    public final String getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public final PriceWithCurrency getPrice() {
        return this.price;
    }

    public final ProductType getProductType() {
        return this.productType;
    }

    public int hashCode() {
        return (((((this.id.hashCode() * 31) + this.name.hashCode()) * 31) + this.price.hashCode()) * 31) + this.productType.hashCode();
    }

    public String toString() {
        return "UnavailableProduct(id=" + this.id + ", name=" + this.name + ", price=" + this.price + ", productType=" + this.productType + ")";
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public UnavailableProduct(ProductsResponseDTO.UnavailableProductResponseDTO dto) {
        this(dto.getId(), dto.getName(), new PriceWithCurrency(dto.getPrice()), ProductType.INSTANCE.invoke(dto.getProductType()));
        Intrinsics.checkNotNullParameter(dto, "dto");
    }
}
