package dk.molslinjen.domain.model.booking.product;

import com.sdk.growthbook.utils.Constants;
import dk.molslinjen.domain.model.booking.ProductType;
import dk.molslinjen.domain.model.booking.product.presentation.ProductPresentation;
import dk.molslinjen.domain.model.shared.PriceWithCurrency;
import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\bf\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005R\u0012\u0010\b\u001a\u00020\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0012\u0010\f\u001a\u00020\rX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0012\u0010\u0010\u001a\u00020\u0011X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0012\u0010\u0014\u001a\u00020\u0015X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0012\u0010\u0018\u001a\u00020\u0019X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0012\u0010\u001c\u001a\u00020\rX¦\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u000fR\u0012\u0010\u001e\u001a\u00020\rX¦\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u000fR\u0014\u0010 \u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\u0005¨\u0006\""}, d2 = {"Ldk/molslinjen/domain/model/booking/product/IQuantityProduct;", BuildConfig.FLAVOR, Constants.ID_ATTRIBUTE_KEY, BuildConfig.FLAVOR, "getId", "()Ljava/lang/String;", "name", "getName", "price", "Ldk/molslinjen/domain/model/shared/PriceWithCurrency;", "getPrice", "()Ldk/molslinjen/domain/model/shared/PriceWithCurrency;", "quantity", BuildConfig.FLAVOR, "getQuantity", "()I", "disabled", BuildConfig.FLAVOR, "getDisabled", "()Z", "presentation", "Ldk/molslinjen/domain/model/booking/product/presentation/ProductPresentation;", "getPresentation", "()Ldk/molslinjen/domain/model/booking/product/presentation/ProductPresentation;", "productType", "Ldk/molslinjen/domain/model/booking/ProductType;", "getProductType", "()Ldk/molslinjen/domain/model/booking/ProductType;", "maxQuantity", "getMaxQuantity", "minFirstStep", "getMinFirstStep", "imageUrl", "getImageUrl", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface IQuantityProduct {
    boolean getDisabled();

    String getId();

    String getImageUrl();

    int getMaxQuantity();

    int getMinFirstStep();

    String getName();

    ProductPresentation getPresentation();

    PriceWithCurrency getPrice();

    ProductType getProductType();

    int getQuantity();
}
