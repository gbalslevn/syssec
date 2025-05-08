package dk.molslinjen.ui.views.screens.tickets.barcodeDetails;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u001a\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\r\u0010\u000eR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u000f\u001a\u0004\b\u0010\u0010\u0007¨\u0006\u0011"}, d2 = {"Ldk/molslinjen/ui/views/screens/tickets/barcodeDetails/SaleOnBoardBarcodeDetailsScreenNavArgs;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "orderNumber", "<init>", "(Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", BuildConfig.FLAVOR, "hashCode", "()I", "other", BuildConfig.FLAVOR, "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getOrderNumber", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class SaleOnBoardBarcodeDetailsScreenNavArgs {
    private final String orderNumber;

    public SaleOnBoardBarcodeDetailsScreenNavArgs(String orderNumber) {
        Intrinsics.checkNotNullParameter(orderNumber, "orderNumber");
        this.orderNumber = orderNumber;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof SaleOnBoardBarcodeDetailsScreenNavArgs) && Intrinsics.areEqual(this.orderNumber, ((SaleOnBoardBarcodeDetailsScreenNavArgs) other).orderNumber);
    }

    public final String getOrderNumber() {
        return this.orderNumber;
    }

    public int hashCode() {
        return this.orderNumber.hashCode();
    }

    public String toString() {
        return "SaleOnBoardBarcodeDetailsScreenNavArgs(orderNumber=" + this.orderNumber + ")";
    }
}
