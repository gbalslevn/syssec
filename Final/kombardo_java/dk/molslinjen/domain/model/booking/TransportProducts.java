package dk.molslinjen.domain.model.booking;

import dk.molslinjen.api.services.booking.response.TransportProductsResponseDTO;
import dk.molslinjen.api.services.booking.response.product.ProductResponseDTO;
import dk.molslinjen.domain.model.booking.product.BikeProduct;
import dk.molslinjen.domain.model.booking.product.Product;
import dk.molslinjen.domain.model.booking.product.TrailerProduct;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\t\u0010\nB\u0011\b\u0016\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\t\u0010\rJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J-\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00052\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0010R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001e"}, d2 = {"Ldk/molslinjen/domain/model/booking/TransportProducts;", BuildConfig.FLAVOR, "goods", "Ldk/molslinjen/domain/model/booking/GoodsRequirements;", "isNotesAvailable", BuildConfig.FLAVOR, "products", BuildConfig.FLAVOR, "Ldk/molslinjen/domain/model/booking/product/Product;", "<init>", "(Ldk/molslinjen/domain/model/booking/GoodsRequirements;ZLjava/util/List;)V", "dto", "Ldk/molslinjen/api/services/booking/response/TransportProductsResponseDTO;", "(Ldk/molslinjen/api/services/booking/response/TransportProductsResponseDTO;)V", "getGoods", "()Ldk/molslinjen/domain/model/booking/GoodsRequirements;", "()Z", "getProducts", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", BuildConfig.FLAVOR, "toString", BuildConfig.FLAVOR, "Companion", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class TransportProducts {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final TransportProducts mock = new TransportProducts(GoodsRequirements.INSTANCE.getMock(), false, CollectionsKt.listOf((Object[]) new Product[]{BikeProduct.INSTANCE.getMock(), TrailerProduct.INSTANCE.getMock()}));
    private final GoodsRequirements goods;
    private final boolean isNotesAvailable;
    private final List<Product> products;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Ldk/molslinjen/domain/model/booking/TransportProducts$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "mock", "Ldk/molslinjen/domain/model/booking/TransportProducts;", "getMock", "()Ldk/molslinjen/domain/model/booking/TransportProducts;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final TransportProducts getMock() {
            return TransportProducts.mock;
        }

        private Companion() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public TransportProducts(GoodsRequirements goods, boolean z5, List<? extends Product> products) {
        Intrinsics.checkNotNullParameter(goods, "goods");
        Intrinsics.checkNotNullParameter(products, "products");
        this.goods = goods;
        this.isNotesAvailable = z5;
        this.products = products;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ TransportProducts copy$default(TransportProducts transportProducts, GoodsRequirements goodsRequirements, boolean z5, List list, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            goodsRequirements = transportProducts.goods;
        }
        if ((i5 & 2) != 0) {
            z5 = transportProducts.isNotesAvailable;
        }
        if ((i5 & 4) != 0) {
            list = transportProducts.products;
        }
        return transportProducts.copy(goodsRequirements, z5, list);
    }

    /* renamed from: component1, reason: from getter */
    public final GoodsRequirements getGoods() {
        return this.goods;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getIsNotesAvailable() {
        return this.isNotesAvailable;
    }

    public final List<Product> component3() {
        return this.products;
    }

    public final TransportProducts copy(GoodsRequirements goods, boolean isNotesAvailable, List<? extends Product> products) {
        Intrinsics.checkNotNullParameter(goods, "goods");
        Intrinsics.checkNotNullParameter(products, "products");
        return new TransportProducts(goods, isNotesAvailable, products);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TransportProducts)) {
            return false;
        }
        TransportProducts transportProducts = (TransportProducts) other;
        return Intrinsics.areEqual(this.goods, transportProducts.goods) && this.isNotesAvailable == transportProducts.isNotesAvailable && Intrinsics.areEqual(this.products, transportProducts.products);
    }

    public final GoodsRequirements getGoods() {
        return this.goods;
    }

    public final List<Product> getProducts() {
        return this.products;
    }

    public int hashCode() {
        return (((this.goods.hashCode() * 31) + Boolean.hashCode(this.isNotesAvailable)) * 31) + this.products.hashCode();
    }

    public final boolean isNotesAvailable() {
        return this.isNotesAvailable;
    }

    public String toString() {
        return "TransportProducts(goods=" + this.goods + ", isNotesAvailable=" + this.isNotesAvailable + ", products=" + this.products + ")";
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public TransportProducts(TransportProductsResponseDTO dto) {
        this(r0, r1, r2);
        Intrinsics.checkNotNullParameter(dto, "dto");
        GoodsRequirements goodsRequirements = new GoodsRequirements(dto.getGoods());
        boolean isNotesAvailable = dto.isNotesAvailable();
        List<ProductResponseDTO> products = dto.getProducts();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(products, 10));
        Iterator<T> it = products.iterator();
        while (it.hasNext()) {
            arrayList.add(Product.INSTANCE.invoke((ProductResponseDTO) it.next()));
        }
    }
}
