package dk.molslinjen.domain.model.booking.product;

import com.sdk.growthbook.utils.Constants;
import dk.molslinjen.api.services.booking.response.product.ProductBikeResponseDTO;
import dk.molslinjen.api.services.booking.response.product.ProductTagDTO;
import dk.molslinjen.api.shared.response.PriceWithCurrencyDTO;
import dk.molslinjen.domain.model.booking.ProductType;
import dk.molslinjen.domain.model.booking.product.presentation.ImageProductPresentation;
import dk.molslinjen.domain.model.booking.product.presentation.ProductPresentation;
import dk.molslinjen.domain.model.shared.PriceWithCurrency;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b'\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0086\b\u0018\u0000 F2\u00020\u00012\u00020\u0002:\u0001FB}\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\n\u0012\u0006\u0010\u0013\u001a\u00020\n\u0012\b\b\u0002\u0010\u0014\u001a\u00020\r\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u0012\u0006\u0010\u0017\u001a\u00020\r¢\u0006\u0004\b\u0018\u0010\u0019B\u0011\b\u0016\u0012\u0006\u0010\u001a\u001a\u00020\u001b¢\u0006\u0004\b\u0018\u0010\u001cJ\t\u00102\u001a\u00020\u0004HÆ\u0003J\t\u00103\u001a\u00020\u0004HÆ\u0003J\t\u00104\u001a\u00020\u0007HÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u00106\u001a\u00020\nHÆ\u0003J\t\u00107\u001a\u00020\nHÆ\u0003J\t\u00108\u001a\u00020\rHÆ\u0003J\t\u00109\u001a\u00020\u000fHÆ\u0003J\t\u0010:\u001a\u00020\u0011HÆ\u0003J\t\u0010;\u001a\u00020\nHÆ\u0003J\t\u0010<\u001a\u00020\nHÆ\u0003J\t\u0010=\u001a\u00020\rHÆ\u0003J\u000b\u0010>\u001a\u0004\u0018\u00010\u0016HÆ\u0003J\t\u0010?\u001a\u00020\rHÆ\u0003J\u0099\u0001\u0010@\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\n2\b\b\u0002\u0010\u0013\u001a\u00020\n2\b\b\u0002\u0010\u0014\u001a\u00020\r2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\b\u0002\u0010\u0017\u001a\u00020\rHÆ\u0001J\u0013\u0010A\u001a\u00020\r2\b\u0010B\u001a\u0004\u0018\u00010CHÖ\u0003J\t\u0010D\u001a\u00020\nHÖ\u0001J\t\u0010E\u001a\u00020\u0004HÖ\u0001R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0014\u0010\u0005\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001eR\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0016\u0010\b\u001a\u0004\u0018\u00010\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010!R\u0014\u0010\t\u001a\u00020\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0014\u0010\u000b\u001a\u00020\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010$R\u0014\u0010\f\u001a\u00020\rX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0014\u0010\u000e\u001a\u00020\u000fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0014\u0010\u0010\u001a\u00020\u0011X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0014\u0010\u0012\u001a\u00020\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010$R\u0014\u0010\u0013\u001a\u00020\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010$R\u0014\u0010\u0014\u001a\u00020\rX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b.\u0010'R\u0016\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u0011\u0010\u0017\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b1\u0010'¨\u0006G"}, d2 = {"Ldk/molslinjen/domain/model/booking/product/BikeProduct;", "Ldk/molslinjen/domain/model/booking/product/Product;", "Ldk/molslinjen/domain/model/booking/product/IQuantityProduct;", Constants.ID_ATTRIBUTE_KEY, BuildConfig.FLAVOR, "name", "price", "Ldk/molslinjen/domain/model/shared/PriceWithCurrency;", "originalPrice", "quantity", BuildConfig.FLAVOR, "originalQuantity", "disabled", BuildConfig.FLAVOR, "presentation", "Ldk/molslinjen/domain/model/booking/product/presentation/ProductPresentation;", "productType", "Ldk/molslinjen/domain/model/booking/ProductType;", "maxQuantity", "minFirstStep", "recommended", "tag", "Ldk/molslinjen/domain/model/booking/product/ProductTag;", "hasTrailer", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ldk/molslinjen/domain/model/shared/PriceWithCurrency;Ldk/molslinjen/domain/model/shared/PriceWithCurrency;IIZLdk/molslinjen/domain/model/booking/product/presentation/ProductPresentation;Ldk/molslinjen/domain/model/booking/ProductType;IIZLdk/molslinjen/domain/model/booking/product/ProductTag;Z)V", "dto", "Ldk/molslinjen/api/services/booking/response/product/ProductBikeResponseDTO;", "(Ldk/molslinjen/api/services/booking/response/product/ProductBikeResponseDTO;)V", "getId", "()Ljava/lang/String;", "getName", "getPrice", "()Ldk/molslinjen/domain/model/shared/PriceWithCurrency;", "getOriginalPrice", "getQuantity", "()I", "getOriginalQuantity", "getDisabled", "()Z", "getPresentation", "()Ldk/molslinjen/domain/model/booking/product/presentation/ProductPresentation;", "getProductType", "()Ldk/molslinjen/domain/model/booking/ProductType;", "getMaxQuantity", "getMinFirstStep", "getRecommended", "getTag", "()Ldk/molslinjen/domain/model/booking/product/ProductTag;", "getHasTrailer", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "copy", "equals", "other", BuildConfig.FLAVOR, "hashCode", "toString", "Companion", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class BikeProduct extends Product implements IQuantityProduct {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final BikeProduct mock;
    private static final BikeProduct mockRecommended;
    private final boolean disabled;
    private final boolean hasTrailer;
    private final String id;
    private final int maxQuantity;
    private final int minFirstStep;
    private final String name;
    private final PriceWithCurrency originalPrice;
    private final int originalQuantity;
    private final ProductPresentation presentation;
    private final PriceWithCurrency price;
    private final ProductType productType;
    private final int quantity;
    private final boolean recommended;
    private final ProductTag tag;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007¨\u0006\n"}, d2 = {"Ldk/molslinjen/domain/model/booking/product/BikeProduct$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "mock", "Ldk/molslinjen/domain/model/booking/product/BikeProduct;", "getMock", "()Ldk/molslinjen/domain/model/booking/product/BikeProduct;", "mockRecommended", "getMockRecommended", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final BikeProduct getMock() {
            return BikeProduct.mock;
        }

        public final BikeProduct getMockRecommended() {
            return BikeProduct.mockRecommended;
        }

        private Companion() {
        }
    }

    static {
        BikeProduct bikeProduct = new BikeProduct("60", "Cykel/knallert, voksen", PriceWithCurrency.INSTANCE.mock(30), null, 0, 0, false, ImageProductPresentation.INSTANCE.getMockNumeric(), ProductType.Bike, 20, 1, false, ProductTag.INSTANCE.getMock(), false, 2048, null);
        mock = bikeProduct;
        mockRecommended = copy$default(bikeProduct, null, null, null, null, 0, 0, false, null, null, 0, 0, true, null, false, 14335, null);
    }

    public /* synthetic */ BikeProduct(String str, String str2, PriceWithCurrency priceWithCurrency, PriceWithCurrency priceWithCurrency2, int i5, int i6, boolean z5, ProductPresentation productPresentation, ProductType productType, int i7, int i8, boolean z6, ProductTag productTag, boolean z7, int i9, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, priceWithCurrency, priceWithCurrency2, i5, i6, z5, productPresentation, productType, i7, i8, (i9 & 2048) != 0 ? false : z6, productTag, z7);
    }

    public static /* synthetic */ BikeProduct copy$default(BikeProduct bikeProduct, String str, String str2, PriceWithCurrency priceWithCurrency, PriceWithCurrency priceWithCurrency2, int i5, int i6, boolean z5, ProductPresentation productPresentation, ProductType productType, int i7, int i8, boolean z6, ProductTag productTag, boolean z7, int i9, Object obj) {
        return bikeProduct.copy((i9 & 1) != 0 ? bikeProduct.id : str, (i9 & 2) != 0 ? bikeProduct.name : str2, (i9 & 4) != 0 ? bikeProduct.price : priceWithCurrency, (i9 & 8) != 0 ? bikeProduct.originalPrice : priceWithCurrency2, (i9 & 16) != 0 ? bikeProduct.quantity : i5, (i9 & 32) != 0 ? bikeProduct.originalQuantity : i6, (i9 & 64) != 0 ? bikeProduct.disabled : z5, (i9 & 128) != 0 ? bikeProduct.presentation : productPresentation, (i9 & 256) != 0 ? bikeProduct.productType : productType, (i9 & 512) != 0 ? bikeProduct.maxQuantity : i7, (i9 & 1024) != 0 ? bikeProduct.minFirstStep : i8, (i9 & 2048) != 0 ? bikeProduct.recommended : z6, (i9 & 4096) != 0 ? bikeProduct.tag : productTag, (i9 & 8192) != 0 ? bikeProduct.hasTrailer : z7);
    }

    /* renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: component10, reason: from getter */
    public final int getMaxQuantity() {
        return this.maxQuantity;
    }

    /* renamed from: component11, reason: from getter */
    public final int getMinFirstStep() {
        return this.minFirstStep;
    }

    /* renamed from: component12, reason: from getter */
    public final boolean getRecommended() {
        return this.recommended;
    }

    /* renamed from: component13, reason: from getter */
    public final ProductTag getTag() {
        return this.tag;
    }

    /* renamed from: component14, reason: from getter */
    public final boolean getHasTrailer() {
        return this.hasTrailer;
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
    public final PriceWithCurrency getOriginalPrice() {
        return this.originalPrice;
    }

    /* renamed from: component5, reason: from getter */
    public final int getQuantity() {
        return this.quantity;
    }

    /* renamed from: component6, reason: from getter */
    public final int getOriginalQuantity() {
        return this.originalQuantity;
    }

    /* renamed from: component7, reason: from getter */
    public final boolean getDisabled() {
        return this.disabled;
    }

    /* renamed from: component8, reason: from getter */
    public final ProductPresentation getPresentation() {
        return this.presentation;
    }

    /* renamed from: component9, reason: from getter */
    public final ProductType getProductType() {
        return this.productType;
    }

    public final BikeProduct copy(String r17, String name, PriceWithCurrency price, PriceWithCurrency originalPrice, int quantity, int originalQuantity, boolean disabled, ProductPresentation presentation, ProductType productType, int maxQuantity, int minFirstStep, boolean recommended, ProductTag tag, boolean hasTrailer) {
        Intrinsics.checkNotNullParameter(r17, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(price, "price");
        Intrinsics.checkNotNullParameter(presentation, "presentation");
        Intrinsics.checkNotNullParameter(productType, "productType");
        return new BikeProduct(r17, name, price, originalPrice, quantity, originalQuantity, disabled, presentation, productType, maxQuantity, minFirstStep, recommended, tag, hasTrailer);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BikeProduct)) {
            return false;
        }
        BikeProduct bikeProduct = (BikeProduct) other;
        return Intrinsics.areEqual(this.id, bikeProduct.id) && Intrinsics.areEqual(this.name, bikeProduct.name) && Intrinsics.areEqual(this.price, bikeProduct.price) && Intrinsics.areEqual(this.originalPrice, bikeProduct.originalPrice) && this.quantity == bikeProduct.quantity && this.originalQuantity == bikeProduct.originalQuantity && this.disabled == bikeProduct.disabled && Intrinsics.areEqual(this.presentation, bikeProduct.presentation) && this.productType == bikeProduct.productType && this.maxQuantity == bikeProduct.maxQuantity && this.minFirstStep == bikeProduct.minFirstStep && this.recommended == bikeProduct.recommended && Intrinsics.areEqual(this.tag, bikeProduct.tag) && this.hasTrailer == bikeProduct.hasTrailer;
    }

    @Override // dk.molslinjen.domain.model.booking.product.Product, dk.molslinjen.domain.model.booking.product.IQuantityProduct
    public boolean getDisabled() {
        return this.disabled;
    }

    public final boolean getHasTrailer() {
        return this.hasTrailer;
    }

    @Override // dk.molslinjen.domain.model.booking.product.Product, dk.molslinjen.domain.model.booking.product.ISummaryProduct
    public String getId() {
        return this.id;
    }

    @Override // dk.molslinjen.domain.model.booking.product.IQuantityProduct
    public int getMaxQuantity() {
        return this.maxQuantity;
    }

    @Override // dk.molslinjen.domain.model.booking.product.IQuantityProduct
    public int getMinFirstStep() {
        return this.minFirstStep;
    }

    @Override // dk.molslinjen.domain.model.booking.product.Product, dk.molslinjen.domain.model.booking.product.ISummaryProduct
    public String getName() {
        return this.name;
    }

    @Override // dk.molslinjen.domain.model.booking.product.Product
    public PriceWithCurrency getOriginalPrice() {
        return this.originalPrice;
    }

    @Override // dk.molslinjen.domain.model.booking.product.Product, dk.molslinjen.domain.model.booking.product.ISummaryProduct
    public int getOriginalQuantity() {
        return this.originalQuantity;
    }

    @Override // dk.molslinjen.domain.model.booking.product.Product, dk.molslinjen.domain.model.booking.product.IQuantityProduct
    public ProductPresentation getPresentation() {
        return this.presentation;
    }

    @Override // dk.molslinjen.domain.model.booking.product.Product, dk.molslinjen.domain.model.booking.product.ISummaryProduct
    public PriceWithCurrency getPrice() {
        return this.price;
    }

    @Override // dk.molslinjen.domain.model.booking.product.Product, dk.molslinjen.domain.model.booking.product.ISummaryProduct
    public ProductType getProductType() {
        return this.productType;
    }

    @Override // dk.molslinjen.domain.model.booking.product.Product, dk.molslinjen.domain.model.booking.product.ISummaryProduct
    public int getQuantity() {
        return this.quantity;
    }

    @Override // dk.molslinjen.domain.model.booking.product.Product
    public boolean getRecommended() {
        return this.recommended;
    }

    @Override // dk.molslinjen.domain.model.booking.product.Product
    public ProductTag getTag() {
        return this.tag;
    }

    public int hashCode() {
        int hashCode = ((((this.id.hashCode() * 31) + this.name.hashCode()) * 31) + this.price.hashCode()) * 31;
        PriceWithCurrency priceWithCurrency = this.originalPrice;
        int hashCode2 = (((((((((((((((((hashCode + (priceWithCurrency == null ? 0 : priceWithCurrency.hashCode())) * 31) + Integer.hashCode(this.quantity)) * 31) + Integer.hashCode(this.originalQuantity)) * 31) + Boolean.hashCode(this.disabled)) * 31) + this.presentation.hashCode()) * 31) + this.productType.hashCode()) * 31) + Integer.hashCode(this.maxQuantity)) * 31) + Integer.hashCode(this.minFirstStep)) * 31) + Boolean.hashCode(this.recommended)) * 31;
        ProductTag productTag = this.tag;
        return ((hashCode2 + (productTag != null ? productTag.hashCode() : 0)) * 31) + Boolean.hashCode(this.hasTrailer);
    }

    public String toString() {
        return "BikeProduct(id=" + this.id + ", name=" + this.name + ", price=" + this.price + ", originalPrice=" + this.originalPrice + ", quantity=" + this.quantity + ", originalQuantity=" + this.originalQuantity + ", disabled=" + this.disabled + ", presentation=" + this.presentation + ", productType=" + this.productType + ", maxQuantity=" + this.maxQuantity + ", minFirstStep=" + this.minFirstStep + ", recommended=" + this.recommended + ", tag=" + this.tag + ", hasTrailer=" + this.hasTrailer + ")";
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BikeProduct(String id, String name, PriceWithCurrency price, PriceWithCurrency priceWithCurrency, int i5, int i6, boolean z5, ProductPresentation presentation, ProductType productType, int i7, int i8, boolean z6, ProductTag productTag, boolean z7) {
        super(null);
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(price, "price");
        Intrinsics.checkNotNullParameter(presentation, "presentation");
        Intrinsics.checkNotNullParameter(productType, "productType");
        this.id = id;
        this.name = name;
        this.price = price;
        this.originalPrice = priceWithCurrency;
        this.quantity = i5;
        this.originalQuantity = i6;
        this.disabled = z5;
        this.presentation = presentation;
        this.productType = productType;
        this.maxQuantity = i7;
        this.minFirstStep = i8;
        this.recommended = z6;
        this.tag = productTag;
        this.hasTrailer = z7;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public BikeProduct(ProductBikeResponseDTO dto) {
        this(r2, r3, r4, r6, r0, r7, r8, r9, r10, r11, r12, false, r5, dto.getHasTrailer(), 2048, null);
        ProductTagDTO productTagDTO;
        Intrinsics.checkNotNullParameter(dto, "dto");
        String id = dto.getId();
        String name = dto.getName();
        PriceWithCurrency priceWithCurrency = new PriceWithCurrency(dto.getPrice());
        PriceWithCurrencyDTO originalPrice = dto.getOriginalPrice();
        ProductTag productTag = null;
        PriceWithCurrency priceWithCurrency2 = originalPrice != null ? new PriceWithCurrency(originalPrice) : null;
        int quantity = dto.getQuantity();
        int quantity2 = dto.getQuantity();
        boolean disabled = dto.getDisabled();
        ProductPresentation invoke = ProductPresentation.INSTANCE.invoke(dto.getPresentation());
        ProductType invoke2 = ProductType.INSTANCE.invoke(dto.getProductType());
        int maxQuantity = dto.getMaxQuantity();
        int minFirstStep = dto.getMinFirstStep();
        List<ProductTagDTO> tags = dto.getTags();
        if (tags != null && (productTagDTO = (ProductTagDTO) CollectionsKt.firstOrNull((List) tags)) != null) {
            productTag = new ProductTag(productTagDTO);
        }
    }
}
