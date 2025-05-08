package dk.molslinjen.ui.views.screens.tickets.barcodeDetails;

import dk.molslinjen.ui.views.reusable.barcode.BarcodeViewType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\b\u0087\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0014\u001a\u0004\b\u0015\u0010\fR\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0014\u001a\u0004\b\u0016\u0010\fR\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c¨\u0006\u001d"}, d2 = {"Ldk/molslinjen/ui/views/screens/tickets/barcodeDetails/BarcodeDetailsScreenNavArgs;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "barcode", "text", "Ldk/molslinjen/ui/views/reusable/barcode/BarcodeViewType;", "type", "Ldk/molslinjen/ui/views/screens/tickets/barcodeDetails/BarcodeValidity;", "validity", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ldk/molslinjen/ui/views/reusable/barcode/BarcodeViewType;Ldk/molslinjen/ui/views/screens/tickets/barcodeDetails/BarcodeValidity;)V", "toString", "()Ljava/lang/String;", BuildConfig.FLAVOR, "hashCode", "()I", "other", BuildConfig.FLAVOR, "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getBarcode", "getText", "Ldk/molslinjen/ui/views/reusable/barcode/BarcodeViewType;", "getType", "()Ldk/molslinjen/ui/views/reusable/barcode/BarcodeViewType;", "Ldk/molslinjen/ui/views/screens/tickets/barcodeDetails/BarcodeValidity;", "getValidity", "()Ldk/molslinjen/ui/views/screens/tickets/barcodeDetails/BarcodeValidity;", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class BarcodeDetailsScreenNavArgs {
    private final String barcode;
    private final String text;
    private final BarcodeViewType type;
    private final BarcodeValidity validity;

    public BarcodeDetailsScreenNavArgs(String barcode, String str, BarcodeViewType type, BarcodeValidity validity) {
        Intrinsics.checkNotNullParameter(barcode, "barcode");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(validity, "validity");
        this.barcode = barcode;
        this.text = str;
        this.type = type;
        this.validity = validity;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BarcodeDetailsScreenNavArgs)) {
            return false;
        }
        BarcodeDetailsScreenNavArgs barcodeDetailsScreenNavArgs = (BarcodeDetailsScreenNavArgs) other;
        return Intrinsics.areEqual(this.barcode, barcodeDetailsScreenNavArgs.barcode) && Intrinsics.areEqual(this.text, barcodeDetailsScreenNavArgs.text) && this.type == barcodeDetailsScreenNavArgs.type && this.validity == barcodeDetailsScreenNavArgs.validity;
    }

    public final String getBarcode() {
        return this.barcode;
    }

    public final String getText() {
        return this.text;
    }

    public final BarcodeViewType getType() {
        return this.type;
    }

    public final BarcodeValidity getValidity() {
        return this.validity;
    }

    public int hashCode() {
        int hashCode = this.barcode.hashCode() * 31;
        String str = this.text;
        return ((((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.type.hashCode()) * 31) + this.validity.hashCode();
    }

    public String toString() {
        return "BarcodeDetailsScreenNavArgs(barcode=" + this.barcode + ", text=" + this.text + ", type=" + this.type + ", validity=" + this.validity + ")";
    }
}
