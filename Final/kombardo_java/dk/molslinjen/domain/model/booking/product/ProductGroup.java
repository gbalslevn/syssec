package dk.molslinjen.domain.model.booking.product;

import dk.molslinjen.api.services.booking.response.ProductsResponseDTO;
import dk.molslinjen.api.services.booking.response.product.ProductResponseDTO;
import dk.molslinjen.core.extensions.StringExtensionsKt;
import dk.molslinjen.domain.model.booking.product.ExtraProduct;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\b\u0018\u0000 !2\u00020\u0001:\u0001!B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bB\u0011\b\u0016\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0004\b\n\u0010\u000eJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003J\t\u0010\u0019\u001a\u00020\tHÆ\u0003J9\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006\""}, d2 = {"Ldk/molslinjen/domain/model/booking/product/ProductGroup;", BuildConfig.FLAVOR, "name", BuildConfig.FLAVOR, "description", "products", BuildConfig.FLAVOR, "Ldk/molslinjen/domain/model/booking/product/Product;", "size", "Ldk/molslinjen/domain/model/booking/product/ProductSize;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ldk/molslinjen/domain/model/booking/product/ProductSize;)V", "dto", "Ldk/molslinjen/api/services/booking/response/ProductsResponseDTO$ProductGroupResponseDTO;", "(Ldk/molslinjen/api/services/booking/response/ProductsResponseDTO$ProductGroupResponseDTO;)V", "getName", "()Ljava/lang/String;", "getDescription", "getProducts", "()Ljava/util/List;", "getSize", "()Ldk/molslinjen/domain/model/booking/product/ProductSize;", "component1", "component2", "component3", "component4", "copy", "equals", BuildConfig.FLAVOR, "other", "hashCode", BuildConfig.FLAVOR, "toString", "Companion", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class ProductGroup {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final ProductGroup mock1;
    private static final ProductGroup mock2;
    private static final ProductGroup mock3;
    private static final ProductGroup mockRecommended;
    private static final ProductGroup mockSelectSeating;
    private final String description;
    private final String name;
    private final List<Product> products;
    private final ProductSize size;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0007R\u0011\u0010\f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0007R\u0011\u0010\u000e\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0007¨\u0006\u0010"}, d2 = {"Ldk/molslinjen/domain/model/booking/product/ProductGroup$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "mock1", "Ldk/molslinjen/domain/model/booking/product/ProductGroup;", "getMock1", "()Ldk/molslinjen/domain/model/booking/product/ProductGroup;", "mock2", "getMock2", "mock3", "getMock3", "mockSelectSeating", "getMockSelectSeating", "mockRecommended", "getMockRecommended", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ProductGroup getMock1() {
            return ProductGroup.mock1;
        }

        public final ProductGroup getMock2() {
            return ProductGroup.mock2;
        }

        public final ProductGroup getMock3() {
            return ProductGroup.mock3;
        }

        public final ProductGroup getMockRecommended() {
            return ProductGroup.mockRecommended;
        }

        public final ProductGroup getMockSelectSeating() {
            return ProductGroup.mockSelectSeating;
        }

        private Companion() {
        }
    }

    static {
        ExtraProduct.Companion companion = ExtraProduct.INSTANCE;
        mock1 = new ProductGroup("Tilvalg", null, CollectionsKt.listOf(companion.getMock()), ProductSize.Large);
        List listOf = CollectionsKt.listOf((Object[]) new Product[]{companion.getMock(), TrailerProduct.INSTANCE.getMock()});
        ProductSize productSize = ProductSize.Small;
        mock2 = new ProductGroup("Andre tilvalg", null, listOf, productSize);
        mock3 = new ProductGroup("Mad & drikke", "Bestil din mad allerede nu og kom ombord lige efter BlueClass", CollectionsKt.listOf(QuantityProduct.INSTANCE.getMock()), productSize);
        mockSelectSeating = new ProductGroup("Pladsreservation", BuildConfig.FLAVOR, CollectionsKt.listOf(companion.getMockSelectSeating()), productSize);
        mockRecommended = new ProductGroup("Anbefalet", null, CollectionsKt.listOf(companion.getMockRampRecommended()), productSize);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ProductGroup(String name, String str, List<? extends Product> products, ProductSize size) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(products, "products");
        Intrinsics.checkNotNullParameter(size, "size");
        this.name = name;
        this.description = str;
        this.products = products;
        this.size = size;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ProductGroup copy$default(ProductGroup productGroup, String str, String str2, List list, ProductSize productSize, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            str = productGroup.name;
        }
        if ((i5 & 2) != 0) {
            str2 = productGroup.description;
        }
        if ((i5 & 4) != 0) {
            list = productGroup.products;
        }
        if ((i5 & 8) != 0) {
            productSize = productGroup.size;
        }
        return productGroup.copy(str, str2, list, productSize);
    }

    /* renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component2, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    public final List<Product> component3() {
        return this.products;
    }

    /* renamed from: component4, reason: from getter */
    public final ProductSize getSize() {
        return this.size;
    }

    public final ProductGroup copy(String name, String description, List<? extends Product> products, ProductSize size) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(products, "products");
        Intrinsics.checkNotNullParameter(size, "size");
        return new ProductGroup(name, description, products, size);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ProductGroup)) {
            return false;
        }
        ProductGroup productGroup = (ProductGroup) other;
        return Intrinsics.areEqual(this.name, productGroup.name) && Intrinsics.areEqual(this.description, productGroup.description) && Intrinsics.areEqual(this.products, productGroup.products) && this.size == productGroup.size;
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getName() {
        return this.name;
    }

    public final List<Product> getProducts() {
        return this.products;
    }

    public final ProductSize getSize() {
        return this.size;
    }

    public int hashCode() {
        int hashCode = this.name.hashCode() * 31;
        String str = this.description;
        return ((((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.products.hashCode()) * 31) + this.size.hashCode();
    }

    public String toString() {
        return "ProductGroup(name=" + this.name + ", description=" + this.description + ", products=" + this.products + ", size=" + this.size + ")";
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ProductGroup(ProductsResponseDTO.ProductGroupResponseDTO dto) {
        this(r0, r1, r3, ProductSize.INSTANCE.invoke(dto.getSize()));
        Intrinsics.checkNotNullParameter(dto, "dto");
        String name = dto.getName();
        String nullIfEmpty = StringExtensionsKt.nullIfEmpty(dto.getDescription());
        List<ProductResponseDTO> products = dto.getProducts();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(products, 10));
        Iterator<T> it = products.iterator();
        while (it.hasNext()) {
            arrayList.add(Product.INSTANCE.invoke((ProductResponseDTO) it.next()));
        }
    }
}
