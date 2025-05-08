package dk.molslinjen.domain.model.booking.product;

import com.sdk.growthbook.utils.Constants;
import dk.molslinjen.domain.model.booking.ProductType;
import dk.molslinjen.domain.model.shared.PriceWithCurrency;
import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\b\u0010\u0016\u001a\u00020\u0017H&J\b\u0010\u001a\u001a\u00020\tH\u0016R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005R\u0012\u0010\b\u001a\u00020\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0012\u0010\f\u001a\u00020\rX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0012\u0010\u0010\u001a\u00020\rX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u000fR\u0012\u0010\u0012\u001a\u00020\u0013X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0018\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0005¨\u0006\u001b"}, d2 = {"Ldk/molslinjen/domain/model/booking/product/ISummaryProduct;", BuildConfig.FLAVOR, Constants.ID_ATTRIBUTE_KEY, BuildConfig.FLAVOR, "getId", "()Ljava/lang/String;", "name", "getName", "price", "Ldk/molslinjen/domain/model/shared/PriceWithCurrency;", "getPrice", "()Ldk/molslinjen/domain/model/shared/PriceWithCurrency;", "quantity", BuildConfig.FLAVOR, "getQuantity", "()I", "originalQuantity", "getOriginalQuantity", "productType", "Ldk/molslinjen/domain/model/booking/ProductType;", "getProductType", "()Ldk/molslinjen/domain/model/booking/ProductType;", "showQuantity", BuildConfig.FLAVOR, "imageUrl", "getImageUrl", "sum", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface ISummaryProduct {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class DefaultImpls {
        public static PriceWithCurrency sum(ISummaryProduct iSummaryProduct) {
            return new PriceWithCurrency(iSummaryProduct.getPrice().getValue() * Math.max(0, iSummaryProduct.getQuantity() - iSummaryProduct.getOriginalQuantity()), iSummaryProduct.getPrice().getCurrencyType());
        }
    }

    String getId();

    String getImageUrl();

    String getName();

    int getOriginalQuantity();

    PriceWithCurrency getPrice();

    ProductType getProductType();

    int getQuantity();

    boolean showQuantity();

    PriceWithCurrency sum();
}
