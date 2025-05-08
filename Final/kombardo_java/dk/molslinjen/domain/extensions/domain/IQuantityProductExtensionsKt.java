package dk.molslinjen.domain.extensions.domain;

import dk.molslinjen.domain.model.booking.product.IQuantityProduct;
import dk.molslinjen.domain.model.booking.product.Product;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"}, d2 = {"isRecommended", BuildConfig.FLAVOR, "Ldk/molslinjen/domain/model/booking/product/IQuantityProduct;", "domain_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class IQuantityProductExtensionsKt {
    /* JADX WARN: Multi-variable type inference failed */
    public static final boolean isRecommended(IQuantityProduct iQuantityProduct) {
        Intrinsics.checkNotNullParameter(iQuantityProduct, "<this>");
        Product product = iQuantityProduct instanceof Product ? (Product) iQuantityProduct : null;
        if (product != null) {
            return product.getRecommended();
        }
        return false;
    }
}
