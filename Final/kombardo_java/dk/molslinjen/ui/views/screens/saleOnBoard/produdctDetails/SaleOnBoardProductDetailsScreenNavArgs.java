package dk.molslinjen.ui.views.screens.saleOnBoard.produdctDetails;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0010\u001a\u0004\b\u0011\u0010\bR\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0010\u001a\u0004\b\u0012\u0010\b¨\u0006\u0013"}, d2 = {"Ldk/molslinjen/ui/views/screens/saleOnBoard/produdctDetails/SaleOnBoardProductDetailsScreenNavArgs;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "productId", "lineItemId", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", BuildConfig.FLAVOR, "hashCode", "()I", "other", BuildConfig.FLAVOR, "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getProductId", "getLineItemId", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class SaleOnBoardProductDetailsScreenNavArgs {
    private final String lineItemId;
    private final String productId;

    public SaleOnBoardProductDetailsScreenNavArgs(String productId, String str) {
        Intrinsics.checkNotNullParameter(productId, "productId");
        this.productId = productId;
        this.lineItemId = str;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SaleOnBoardProductDetailsScreenNavArgs)) {
            return false;
        }
        SaleOnBoardProductDetailsScreenNavArgs saleOnBoardProductDetailsScreenNavArgs = (SaleOnBoardProductDetailsScreenNavArgs) other;
        return Intrinsics.areEqual(this.productId, saleOnBoardProductDetailsScreenNavArgs.productId) && Intrinsics.areEqual(this.lineItemId, saleOnBoardProductDetailsScreenNavArgs.lineItemId);
    }

    public final String getLineItemId() {
        return this.lineItemId;
    }

    public final String getProductId() {
        return this.productId;
    }

    public int hashCode() {
        int hashCode = this.productId.hashCode() * 31;
        String str = this.lineItemId;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "SaleOnBoardProductDetailsScreenNavArgs(productId=" + this.productId + ", lineItemId=" + this.lineItemId + ")";
    }
}
