package dk.molslinjen.ui.views.screens.tickets.barcodeDetails;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;
import org.threeten.bp.LocalDateTime;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\n\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0012\u001a\u0004\b\u0013\u0010\u000bR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0014\u001a\u0004\b\u0015\u0010\rR\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Ldk/molslinjen/ui/views/screens/tickets/barcodeDetails/LoungeBarcodeDetailsScreenNavArgs;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "barcode", BuildConfig.FLAVOR, "persons", "Lorg/threeten/bp/LocalDateTime;", "departureTime", "<init>", "(Ljava/lang/String;ILorg/threeten/bp/LocalDateTime;)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", BuildConfig.FLAVOR, "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getBarcode", "I", "getPersons", "Lorg/threeten/bp/LocalDateTime;", "getDepartureTime", "()Lorg/threeten/bp/LocalDateTime;", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class LoungeBarcodeDetailsScreenNavArgs {
    private final String barcode;
    private final LocalDateTime departureTime;
    private final int persons;

    public LoungeBarcodeDetailsScreenNavArgs(String barcode, int i5, LocalDateTime departureTime) {
        Intrinsics.checkNotNullParameter(barcode, "barcode");
        Intrinsics.checkNotNullParameter(departureTime, "departureTime");
        this.barcode = barcode;
        this.persons = i5;
        this.departureTime = departureTime;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LoungeBarcodeDetailsScreenNavArgs)) {
            return false;
        }
        LoungeBarcodeDetailsScreenNavArgs loungeBarcodeDetailsScreenNavArgs = (LoungeBarcodeDetailsScreenNavArgs) other;
        return Intrinsics.areEqual(this.barcode, loungeBarcodeDetailsScreenNavArgs.barcode) && this.persons == loungeBarcodeDetailsScreenNavArgs.persons && Intrinsics.areEqual(this.departureTime, loungeBarcodeDetailsScreenNavArgs.departureTime);
    }

    public final String getBarcode() {
        return this.barcode;
    }

    public final LocalDateTime getDepartureTime() {
        return this.departureTime;
    }

    public final int getPersons() {
        return this.persons;
    }

    public int hashCode() {
        return (((this.barcode.hashCode() * 31) + Integer.hashCode(this.persons)) * 31) + this.departureTime.hashCode();
    }

    public String toString() {
        return "LoungeBarcodeDetailsScreenNavArgs(barcode=" + this.barcode + ", persons=" + this.persons + ", departureTime=" + this.departureTime + ")";
    }
}
