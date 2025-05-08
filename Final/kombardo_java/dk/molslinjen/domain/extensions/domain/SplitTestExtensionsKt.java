package dk.molslinjen.domain.extensions.domain;

import dk.molslinjen.core.Environment;
import dk.molslinjen.domain.managers.splitTest.ISplitTestManager;
import dk.molslinjen.domain.model.booking.ProductsResponse;
import dk.molslinjen.domain.model.booking.product.ExtraProduct;
import dk.molslinjen.domain.model.booking.product.Product;
import dk.molslinjen.domain.model.booking.product.ProductGroup;
import dk.molslinjen.domain.providers.IStringsProvider;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u001a\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005\u001a\u001a\u0010\u0000\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005¨\u0006\u0007"}, d2 = {"applySplitTestChanges", "Ldk/molslinjen/domain/model/booking/ProductsResponse;", "splitTestManager", "Ldk/molslinjen/domain/managers/splitTest/ISplitTestManager;", "stringProvider", "Ldk/molslinjen/domain/providers/IStringsProvider;", "Ldk/molslinjen/domain/model/booking/product/Product;", "domain_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class SplitTestExtensionsKt {
    public static final ProductsResponse applySplitTestChanges(ProductsResponse productsResponse, ISplitTestManager splitTestManager, IStringsProvider stringProvider) {
        Intrinsics.checkNotNullParameter(productsResponse, "<this>");
        Intrinsics.checkNotNullParameter(splitTestManager, "splitTestManager");
        Intrinsics.checkNotNullParameter(stringProvider, "stringProvider");
        if (!Environment.INSTANCE.isMolslinjen() || !splitTestManager.getAddOnRampsUseAlternativeText()) {
            return productsResponse;
        }
        List<ProductGroup> productGroups = productsResponse.getProductGroups();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(productGroups, 10));
        for (ProductGroup productGroup : productGroups) {
            List<Product> products = productGroup.getProducts();
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(products, 10));
            Iterator<T> it = products.iterator();
            while (it.hasNext()) {
                arrayList2.add(applySplitTestChanges((Product) it.next(), splitTestManager, stringProvider));
            }
            arrayList.add(ProductGroup.copy$default(productGroup, null, null, arrayList2, null, 11, null));
        }
        return ProductsResponse.copy$default(productsResponse, arrayList, null, null, 6, null);
    }

    public static final Product applySplitTestChanges(Product product, ISplitTestManager splitTestManager, IStringsProvider stringProvider) {
        Intrinsics.checkNotNullParameter(product, "<this>");
        Intrinsics.checkNotNullParameter(splitTestManager, "splitTestManager");
        Intrinsics.checkNotNullParameter(stringProvider, "stringProvider");
        return (Environment.INSTANCE.isMolslinjen() && splitTestManager.getAddOnRampsUseAlternativeText() && Intrinsics.areEqual(product.getId(), "RAMPEFRI") && (product instanceof ExtraProduct)) ? ExtraProduct.copy$default((ExtraProduct) product, null, stringProvider.getSplitTestRampsAlternativeName(), null, null, 0, 0, false, null, null, 0, 0, false, null, stringProvider.getSplitTestRampsAlternativeDescription(), 8189, null) : product;
    }
}
