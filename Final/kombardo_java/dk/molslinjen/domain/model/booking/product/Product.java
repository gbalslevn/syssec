package dk.molslinjen.domain.model.booking.product;

import com.sdk.growthbook.utils.Constants;
import dk.molslinjen.api.services.booking.response.product.ProductBikeResponseDTO;
import dk.molslinjen.api.services.booking.response.product.ProductExtraResponseDTO;
import dk.molslinjen.api.services.booking.response.product.ProductQuantityResponseDTO;
import dk.molslinjen.api.services.booking.response.product.ProductResponseDTO;
import dk.molslinjen.api.services.booking.response.product.ProductTrailerResponseDTO;
import dk.molslinjen.domain.model.booking.ProductType;
import dk.molslinjen.domain.model.booking.product.ISummaryProduct;
import dk.molslinjen.domain.model.booking.product.presentation.ImageProductPresentation;
import dk.molslinjen.domain.model.booking.product.presentation.ProductInputType;
import dk.molslinjen.domain.model.booking.product.presentation.ProductPresentation;
import dk.molslinjen.domain.model.shared.PriceWithCurrency;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 -2\u00020\u0001:\u0001-B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010*\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u0011J\u000e\u0010+\u001a\u00020\u00002\u0006\u0010\"\u001a\u00020\u0017J\b\u0010,\u001a\u00020\u0017H\u0016R\u0012\u0010\u0004\u001a\u00020\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0012\u0010\b\u001a\u00020\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0007R\u0012\u0010\n\u001a\u00020\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u0004\u0018\u00010\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\rR\u0012\u0010\u0010\u001a\u00020\u0011X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0012\u0010\u0014\u001a\u00020\u0011X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0013R\u0012\u0010\u0016\u001a\u00020\u0017X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0012\u0010\u001a\u001a\u00020\u001bX¦\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0012\u0010\u001e\u001a\u00020\u001fX¦\u0004¢\u0006\u0006\u001a\u0004\b \u0010!R\u0012\u0010\"\u001a\u00020\u0017X¦\u0004¢\u0006\u0006\u001a\u0004\b#\u0010\u0019R\u0014\u0010$\u001a\u0004\u0018\u00010%X¦\u0004¢\u0006\u0006\u001a\u0004\b&\u0010'R\u0016\u0010(\u001a\u0004\u0018\u00010\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b)\u0010\u0007\u0082\u0001\u0004./01¨\u00062"}, d2 = {"Ldk/molslinjen/domain/model/booking/product/Product;", "Ldk/molslinjen/domain/model/booking/product/ISummaryProduct;", "<init>", "()V", Constants.ID_ATTRIBUTE_KEY, BuildConfig.FLAVOR, "getId", "()Ljava/lang/String;", "name", "getName", "price", "Ldk/molslinjen/domain/model/shared/PriceWithCurrency;", "getPrice", "()Ldk/molslinjen/domain/model/shared/PriceWithCurrency;", "originalPrice", "getOriginalPrice", "quantity", BuildConfig.FLAVOR, "getQuantity", "()I", "originalQuantity", "getOriginalQuantity", "disabled", BuildConfig.FLAVOR, "getDisabled", "()Z", "presentation", "Ldk/molslinjen/domain/model/booking/product/presentation/ProductPresentation;", "getPresentation", "()Ldk/molslinjen/domain/model/booking/product/presentation/ProductPresentation;", "productType", "Ldk/molslinjen/domain/model/booking/ProductType;", "getProductType", "()Ldk/molslinjen/domain/model/booking/ProductType;", "recommended", "getRecommended", "tag", "Ldk/molslinjen/domain/model/booking/product/ProductTag;", "getTag", "()Ldk/molslinjen/domain/model/booking/product/ProductTag;", "imageUrl", "getImageUrl", "copyQuantity", "copyRecommended", "showQuantity", "Companion", "Ldk/molslinjen/domain/model/booking/product/BikeProduct;", "Ldk/molslinjen/domain/model/booking/product/ExtraProduct;", "Ldk/molslinjen/domain/model/booking/product/QuantityProduct;", "Ldk/molslinjen/domain/model/booking/product/TrailerProduct;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class Product implements ISummaryProduct {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0011\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0086\u0002¨\u0006\b"}, d2 = {"Ldk/molslinjen/domain/model/booking/product/Product$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "invoke", "Ldk/molslinjen/domain/model/booking/product/Product;", "dto", "Ldk/molslinjen/api/services/booking/response/product/ProductResponseDTO;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Product invoke(ProductResponseDTO dto) {
            Intrinsics.checkNotNullParameter(dto, "dto");
            if (dto instanceof ProductTrailerResponseDTO) {
                return new TrailerProduct((ProductTrailerResponseDTO) dto);
            }
            if (dto instanceof ProductQuantityResponseDTO) {
                return new QuantityProduct((ProductQuantityResponseDTO) dto);
            }
            if (dto instanceof ProductBikeResponseDTO) {
                return new BikeProduct((ProductBikeResponseDTO) dto);
            }
            if (dto instanceof ProductExtraResponseDTO) {
                return new ExtraProduct((ProductExtraResponseDTO) dto);
            }
            throw new NoWhenBranchMatchedException();
        }

        private Companion() {
        }
    }

    public /* synthetic */ Product(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public final Product copyQuantity(int quantity) {
        if (this instanceof BikeProduct) {
            return BikeProduct.copy$default((BikeProduct) this, null, null, null, null, quantity, 0, false, null, null, 0, 0, false, null, false, 16367, null);
        }
        if (this instanceof QuantityProduct) {
            return QuantityProduct.copy$default((QuantityProduct) this, null, null, null, null, quantity, 0, false, null, null, 0, 0, false, null, 8175, null);
        }
        if (this instanceof ExtraProduct) {
            return ExtraProduct.copy$default((ExtraProduct) this, null, null, null, null, quantity, 0, false, null, null, 0, 0, false, null, null, 16367, null);
        }
        if (this instanceof TrailerProduct) {
            return TrailerProduct.copy$default((TrailerProduct) this, null, null, null, null, quantity, 0, false, null, null, false, null, 0.0d, 0.0d, 0, 16367, null);
        }
        throw new NoWhenBranchMatchedException();
    }

    public final Product copyRecommended(boolean recommended) {
        if (this instanceof BikeProduct) {
            return BikeProduct.copy$default((BikeProduct) this, null, null, null, null, 0, 0, false, null, null, 0, 0, recommended, null, false, 14335, null);
        }
        if (this instanceof QuantityProduct) {
            return QuantityProduct.copy$default((QuantityProduct) this, null, null, null, null, 0, 0, false, null, null, 0, 0, recommended, null, 6143, null);
        }
        if (this instanceof ExtraProduct) {
            return ExtraProduct.copy$default((ExtraProduct) this, null, null, null, null, 0, 0, false, null, null, 0, 0, recommended, null, null, 14335, null);
        }
        if (this instanceof TrailerProduct) {
            return TrailerProduct.copy$default((TrailerProduct) this, null, null, null, null, 0, 0, false, null, null, recommended, null, 0.0d, 0.0d, 0, 15871, null);
        }
        throw new NoWhenBranchMatchedException();
    }

    public abstract boolean getDisabled();

    @Override // dk.molslinjen.domain.model.booking.product.ISummaryProduct
    public abstract String getId();

    @Override // dk.molslinjen.domain.model.booking.product.ISummaryProduct
    public String getImageUrl() {
        ProductPresentation presentation = getPresentation();
        ImageProductPresentation imageProductPresentation = presentation instanceof ImageProductPresentation ? (ImageProductPresentation) presentation : null;
        if (imageProductPresentation != null) {
            return imageProductPresentation.getImageUrl();
        }
        return null;
    }

    @Override // dk.molslinjen.domain.model.booking.product.ISummaryProduct
    public abstract String getName();

    public abstract PriceWithCurrency getOriginalPrice();

    @Override // dk.molslinjen.domain.model.booking.product.ISummaryProduct
    public abstract int getOriginalQuantity();

    public abstract ProductPresentation getPresentation();

    @Override // dk.molslinjen.domain.model.booking.product.ISummaryProduct
    public abstract PriceWithCurrency getPrice();

    @Override // dk.molslinjen.domain.model.booking.product.ISummaryProduct
    public abstract ProductType getProductType();

    @Override // dk.molslinjen.domain.model.booking.product.ISummaryProduct
    public abstract int getQuantity();

    public abstract boolean getRecommended();

    public abstract ProductTag getTag();

    @Override // dk.molslinjen.domain.model.booking.product.ISummaryProduct
    public boolean showQuantity() {
        return getPresentation().getInputType() == ProductInputType.Numeric;
    }

    @Override // dk.molslinjen.domain.model.booking.product.ISummaryProduct
    public PriceWithCurrency sum() {
        return ISummaryProduct.DefaultImpls.sum(this);
    }

    private Product() {
    }
}
