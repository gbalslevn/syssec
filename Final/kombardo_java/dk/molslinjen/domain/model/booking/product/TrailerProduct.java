package dk.molslinjen.domain.model.booking.product;

import com.sdk.growthbook.utils.Constants;
import dk.molslinjen.api.services.booking.response.product.ProductTagDTO;
import dk.molslinjen.api.services.booking.response.product.ProductTrailerResponseDTO;
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

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b(\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0086\b\u0018\u0000 G2\u00020\u0001:\u0001GB}\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\f\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\u0006\u0010\u0017\u001a\u00020\t¢\u0006\u0004\b\u0018\u0010\u0019B\u0011\b\u0016\u0012\u0006\u0010\u001a\u001a\u00020\u001b¢\u0006\u0004\b\u0018\u0010\u001cJ\t\u00103\u001a\u00020\u0003HÆ\u0003J\t\u00104\u001a\u00020\u0003HÆ\u0003J\t\u00105\u001a\u00020\u0006HÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u00107\u001a\u00020\tHÆ\u0003J\t\u00108\u001a\u00020\tHÆ\u0003J\t\u00109\u001a\u00020\fHÆ\u0003J\t\u0010:\u001a\u00020\u000eHÆ\u0003J\t\u0010;\u001a\u00020\u0010HÆ\u0003J\t\u0010<\u001a\u00020\fHÆ\u0003J\u000b\u0010=\u001a\u0004\u0018\u00010\u0013HÆ\u0003J\t\u0010>\u001a\u00020\u0015HÆ\u0003J\t\u0010?\u001a\u00020\u0015HÆ\u0003J\t\u0010@\u001a\u00020\tHÆ\u0003J\u0099\u0001\u0010A\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\f2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00152\b\b\u0002\u0010\u0017\u001a\u00020\tHÆ\u0001J\u0013\u0010B\u001a\u00020\f2\b\u0010C\u001a\u0004\u0018\u00010DHÖ\u0003J\t\u0010E\u001a\u00020\tHÖ\u0001J\t\u0010F\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0014\u0010\u0004\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001eR\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010!R\u0014\u0010\b\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0014\u0010\n\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010$R\u0014\u0010\u000b\u001a\u00020\fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u0014\u0010\r\u001a\u00020\u000eX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0014\u0010\u000f\u001a\u00020\u0010X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0014\u0010\u0011\u001a\u00020\fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010'R\u0016\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u0011\u0010\u0014\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u0011\u0010\u0016\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\b1\u00100R\u0011\u0010\u0017\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b2\u0010$¨\u0006H"}, d2 = {"Ldk/molslinjen/domain/model/booking/product/TrailerProduct;", "Ldk/molslinjen/domain/model/booking/product/Product;", Constants.ID_ATTRIBUTE_KEY, BuildConfig.FLAVOR, "name", "price", "Ldk/molslinjen/domain/model/shared/PriceWithCurrency;", "originalPrice", "quantity", BuildConfig.FLAVOR, "originalQuantity", "disabled", BuildConfig.FLAVOR, "presentation", "Ldk/molslinjen/domain/model/booking/product/presentation/ProductPresentation;", "productType", "Ldk/molslinjen/domain/model/booking/ProductType;", "recommended", "tag", "Ldk/molslinjen/domain/model/booking/product/ProductTag;", "maxHeight", BuildConfig.FLAVOR, "maxLength", "sortOrder", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ldk/molslinjen/domain/model/shared/PriceWithCurrency;Ldk/molslinjen/domain/model/shared/PriceWithCurrency;IIZLdk/molslinjen/domain/model/booking/product/presentation/ProductPresentation;Ldk/molslinjen/domain/model/booking/ProductType;ZLdk/molslinjen/domain/model/booking/product/ProductTag;DDI)V", "dto", "Ldk/molslinjen/api/services/booking/response/product/ProductTrailerResponseDTO;", "(Ldk/molslinjen/api/services/booking/response/product/ProductTrailerResponseDTO;)V", "getId", "()Ljava/lang/String;", "getName", "getPrice", "()Ldk/molslinjen/domain/model/shared/PriceWithCurrency;", "getOriginalPrice", "getQuantity", "()I", "getOriginalQuantity", "getDisabled", "()Z", "getPresentation", "()Ldk/molslinjen/domain/model/booking/product/presentation/ProductPresentation;", "getProductType", "()Ldk/molslinjen/domain/model/booking/ProductType;", "getRecommended", "getTag", "()Ldk/molslinjen/domain/model/booking/product/ProductTag;", "getMaxHeight", "()D", "getMaxLength", "getSortOrder", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "copy", "equals", "other", BuildConfig.FLAVOR, "hashCode", "toString", "Companion", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class TrailerProduct extends Product {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final TrailerProduct mock = new TrailerProduct("1", "Anhænger", PriceWithCurrency.INSTANCE.mock(com.adjust.sdk.Constants.MINIMAL_ERROR_STATUS_CODE), null, 0, 0, false, ImageProductPresentation.INSTANCE.getMockNumeric(), ProductType.Trailer, false, ProductTag.INSTANCE.getMock(), 2.0d, 3.0d, 1, 512, null);
    private final boolean disabled;
    private final String id;
    private final double maxHeight;
    private final double maxLength;
    private final String name;
    private final PriceWithCurrency originalPrice;
    private final int originalQuantity;
    private final ProductPresentation presentation;
    private final PriceWithCurrency price;
    private final ProductType productType;
    private final int quantity;
    private final boolean recommended;
    private final int sortOrder;
    private final ProductTag tag;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Ldk/molslinjen/domain/model/booking/product/TrailerProduct$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "mock", "Ldk/molslinjen/domain/model/booking/product/TrailerProduct;", "getMock", "()Ldk/molslinjen/domain/model/booking/product/TrailerProduct;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final TrailerProduct getMock() {
            return TrailerProduct.mock;
        }

        private Companion() {
        }
    }

    public /* synthetic */ TrailerProduct(String str, String str2, PriceWithCurrency priceWithCurrency, PriceWithCurrency priceWithCurrency2, int i5, int i6, boolean z5, ProductPresentation productPresentation, ProductType productType, boolean z6, ProductTag productTag, double d5, double d6, int i7, int i8, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, priceWithCurrency, priceWithCurrency2, i5, i6, z5, productPresentation, productType, (i8 & 512) != 0 ? false : z6, productTag, d5, d6, i7);
    }

    /* renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    /* renamed from: component10, reason: from getter */
    public final boolean getRecommended() {
        return this.recommended;
    }

    /* renamed from: component11, reason: from getter */
    public final ProductTag getTag() {
        return this.tag;
    }

    /* renamed from: component12, reason: from getter */
    public final double getMaxHeight() {
        return this.maxHeight;
    }

    /* renamed from: component13, reason: from getter */
    public final double getMaxLength() {
        return this.maxLength;
    }

    /* renamed from: component14, reason: from getter */
    public final int getSortOrder() {
        return this.sortOrder;
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

    public final TrailerProduct copy(String r20, String name, PriceWithCurrency price, PriceWithCurrency originalPrice, int quantity, int originalQuantity, boolean disabled, ProductPresentation presentation, ProductType productType, boolean recommended, ProductTag tag, double maxHeight, double maxLength, int sortOrder) {
        Intrinsics.checkNotNullParameter(r20, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(price, "price");
        Intrinsics.checkNotNullParameter(presentation, "presentation");
        Intrinsics.checkNotNullParameter(productType, "productType");
        return new TrailerProduct(r20, name, price, originalPrice, quantity, originalQuantity, disabled, presentation, productType, recommended, tag, maxHeight, maxLength, sortOrder);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TrailerProduct)) {
            return false;
        }
        TrailerProduct trailerProduct = (TrailerProduct) other;
        return Intrinsics.areEqual(this.id, trailerProduct.id) && Intrinsics.areEqual(this.name, trailerProduct.name) && Intrinsics.areEqual(this.price, trailerProduct.price) && Intrinsics.areEqual(this.originalPrice, trailerProduct.originalPrice) && this.quantity == trailerProduct.quantity && this.originalQuantity == trailerProduct.originalQuantity && this.disabled == trailerProduct.disabled && Intrinsics.areEqual(this.presentation, trailerProduct.presentation) && this.productType == trailerProduct.productType && this.recommended == trailerProduct.recommended && Intrinsics.areEqual(this.tag, trailerProduct.tag) && Double.compare(this.maxHeight, trailerProduct.maxHeight) == 0 && Double.compare(this.maxLength, trailerProduct.maxLength) == 0 && this.sortOrder == trailerProduct.sortOrder;
    }

    @Override // dk.molslinjen.domain.model.booking.product.Product, dk.molslinjen.domain.model.booking.product.IQuantityProduct
    public boolean getDisabled() {
        return this.disabled;
    }

    @Override // dk.molslinjen.domain.model.booking.product.Product, dk.molslinjen.domain.model.booking.product.ISummaryProduct
    public String getId() {
        return this.id;
    }

    public final double getMaxHeight() {
        return this.maxHeight;
    }

    public final double getMaxLength() {
        return this.maxLength;
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

    public final int getSortOrder() {
        return this.sortOrder;
    }

    @Override // dk.molslinjen.domain.model.booking.product.Product
    public ProductTag getTag() {
        return this.tag;
    }

    public int hashCode() {
        int hashCode = ((((this.id.hashCode() * 31) + this.name.hashCode()) * 31) + this.price.hashCode()) * 31;
        PriceWithCurrency priceWithCurrency = this.originalPrice;
        int hashCode2 = (((((((((((((hashCode + (priceWithCurrency == null ? 0 : priceWithCurrency.hashCode())) * 31) + Integer.hashCode(this.quantity)) * 31) + Integer.hashCode(this.originalQuantity)) * 31) + Boolean.hashCode(this.disabled)) * 31) + this.presentation.hashCode()) * 31) + this.productType.hashCode()) * 31) + Boolean.hashCode(this.recommended)) * 31;
        ProductTag productTag = this.tag;
        return ((((((hashCode2 + (productTag != null ? productTag.hashCode() : 0)) * 31) + Double.hashCode(this.maxHeight)) * 31) + Double.hashCode(this.maxLength)) * 31) + Integer.hashCode(this.sortOrder);
    }

    public String toString() {
        return "TrailerProduct(id=" + this.id + ", name=" + this.name + ", price=" + this.price + ", originalPrice=" + this.originalPrice + ", quantity=" + this.quantity + ", originalQuantity=" + this.originalQuantity + ", disabled=" + this.disabled + ", presentation=" + this.presentation + ", productType=" + this.productType + ", recommended=" + this.recommended + ", tag=" + this.tag + ", maxHeight=" + this.maxHeight + ", maxLength=" + this.maxLength + ", sortOrder=" + this.sortOrder + ")";
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TrailerProduct(String id, String name, PriceWithCurrency price, PriceWithCurrency priceWithCurrency, int i5, int i6, boolean z5, ProductPresentation presentation, ProductType productType, boolean z6, ProductTag productTag, double d5, double d6, int i7) {
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
        this.recommended = z6;
        this.tag = productTag;
        this.maxHeight = d5;
        this.maxLength = d6;
        this.sortOrder = i7;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public TrailerProduct(ProductTrailerResponseDTO dto) {
        this(r3, r4, r5, r6, r7, r8, r9, r10, r11, false, r2, dto.getMaxHeight(), dto.getMaxLength(), dto.getSortOrder(), 512, null);
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
        List<ProductTagDTO> tags = dto.getTags();
        if (tags != null && (productTagDTO = (ProductTagDTO) CollectionsKt.firstOrNull((List) tags)) != null) {
            productTag = new ProductTag(productTagDTO);
        }
    }
}
