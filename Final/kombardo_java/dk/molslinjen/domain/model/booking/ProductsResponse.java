package dk.molslinjen.domain.model.booking;

import dk.molslinjen.api.services.booking.response.ProductsResponseDTO;
import dk.molslinjen.domain.model.booking.product.Product;
import dk.molslinjen.domain.model.booking.product.ProductGroup;
import dk.molslinjen.domain.model.booking.product.UnavailableProduct;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\b\u0010\tB\u0011\b\u0016\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\b\u0010\fJ\u000f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0004HÆ\u0003J5\u0010\u0015\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001d"}, d2 = {"Ldk/molslinjen/domain/model/booking/ProductsResponse;", BuildConfig.FLAVOR, "productGroups", BuildConfig.FLAVOR, "Ldk/molslinjen/domain/model/booking/product/ProductGroup;", "unavailableProducts", "Ldk/molslinjen/domain/model/booking/product/UnavailableProduct;", "recommendedProductsGroup", "<init>", "(Ljava/util/List;Ljava/util/List;Ldk/molslinjen/domain/model/booking/product/ProductGroup;)V", "dto", "Ldk/molslinjen/api/services/booking/response/ProductsResponseDTO;", "(Ldk/molslinjen/api/services/booking/response/ProductsResponseDTO;)V", "getProductGroups", "()Ljava/util/List;", "getUnavailableProducts", "getRecommendedProductsGroup", "()Ldk/molslinjen/domain/model/booking/product/ProductGroup;", "component1", "component2", "component3", "copy", "equals", BuildConfig.FLAVOR, "other", "hashCode", BuildConfig.FLAVOR, "toString", BuildConfig.FLAVOR, "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class ProductsResponse {
    private final List<ProductGroup> productGroups;
    private final ProductGroup recommendedProductsGroup;
    private final List<UnavailableProduct> unavailableProducts;

    public ProductsResponse(List<ProductGroup> productGroups, List<UnavailableProduct> unavailableProducts, ProductGroup productGroup) {
        Intrinsics.checkNotNullParameter(productGroups, "productGroups");
        Intrinsics.checkNotNullParameter(unavailableProducts, "unavailableProducts");
        this.productGroups = productGroups;
        this.unavailableProducts = unavailableProducts;
        this.recommendedProductsGroup = productGroup;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ProductsResponse copy$default(ProductsResponse productsResponse, List list, List list2, ProductGroup productGroup, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            list = productsResponse.productGroups;
        }
        if ((i5 & 2) != 0) {
            list2 = productsResponse.unavailableProducts;
        }
        if ((i5 & 4) != 0) {
            productGroup = productsResponse.recommendedProductsGroup;
        }
        return productsResponse.copy(list, list2, productGroup);
    }

    public final List<ProductGroup> component1() {
        return this.productGroups;
    }

    public final List<UnavailableProduct> component2() {
        return this.unavailableProducts;
    }

    /* renamed from: component3, reason: from getter */
    public final ProductGroup getRecommendedProductsGroup() {
        return this.recommendedProductsGroup;
    }

    public final ProductsResponse copy(List<ProductGroup> productGroups, List<UnavailableProduct> unavailableProducts, ProductGroup recommendedProductsGroup) {
        Intrinsics.checkNotNullParameter(productGroups, "productGroups");
        Intrinsics.checkNotNullParameter(unavailableProducts, "unavailableProducts");
        return new ProductsResponse(productGroups, unavailableProducts, recommendedProductsGroup);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ProductsResponse)) {
            return false;
        }
        ProductsResponse productsResponse = (ProductsResponse) other;
        return Intrinsics.areEqual(this.productGroups, productsResponse.productGroups) && Intrinsics.areEqual(this.unavailableProducts, productsResponse.unavailableProducts) && Intrinsics.areEqual(this.recommendedProductsGroup, productsResponse.recommendedProductsGroup);
    }

    public final List<ProductGroup> getProductGroups() {
        return this.productGroups;
    }

    public final ProductGroup getRecommendedProductsGroup() {
        return this.recommendedProductsGroup;
    }

    public final List<UnavailableProduct> getUnavailableProducts() {
        return this.unavailableProducts;
    }

    public int hashCode() {
        int hashCode = ((this.productGroups.hashCode() * 31) + this.unavailableProducts.hashCode()) * 31;
        ProductGroup productGroup = this.recommendedProductsGroup;
        return hashCode + (productGroup == null ? 0 : productGroup.hashCode());
    }

    public String toString() {
        return "ProductsResponse(productGroups=" + this.productGroups + ", unavailableProducts=" + this.unavailableProducts + ", recommendedProductsGroup=" + this.recommendedProductsGroup + ")";
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ProductsResponse(ProductsResponseDTO dto) {
        this(r2, r3, r12);
        List emptyList;
        List emptyList2;
        ProductGroup productGroup;
        Intrinsics.checkNotNullParameter(dto, "dto");
        List<ProductsResponseDTO.ProductGroupResponseDTO> groups = dto.getGroups();
        if (groups != null) {
            List<ProductsResponseDTO.ProductGroupResponseDTO> list = groups;
            emptyList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                emptyList.add(new ProductGroup((ProductsResponseDTO.ProductGroupResponseDTO) it.next()));
            }
        } else {
            emptyList = CollectionsKt.emptyList();
        }
        List<ProductsResponseDTO.UnavailableProductResponseDTO> unavailableProducts = dto.getUnavailableProducts();
        if (unavailableProducts != null) {
            List<ProductsResponseDTO.UnavailableProductResponseDTO> list2 = unavailableProducts;
            emptyList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
            Iterator<T> it2 = list2.iterator();
            while (it2.hasNext()) {
                emptyList2.add(new UnavailableProduct((ProductsResponseDTO.UnavailableProductResponseDTO) it2.next()));
            }
        } else {
            emptyList2 = CollectionsKt.emptyList();
        }
        ProductsResponseDTO.ProductGroupResponseDTO recommendedProductsGroup = dto.getRecommendedProductsGroup();
        if (recommendedProductsGroup != null) {
            ProductGroup productGroup2 = new ProductGroup(recommendedProductsGroup);
            List<Product> products = productGroup2.getProducts();
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(products, 10));
            Iterator<T> it3 = products.iterator();
            while (it3.hasNext()) {
                arrayList.add(((Product) it3.next()).copyRecommended(true));
            }
            productGroup = ProductGroup.copy$default(productGroup2, null, null, arrayList, null, 11, null);
        } else {
            productGroup = null;
        }
    }
}
