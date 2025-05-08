package dk.molslinjen.ui.views.screens.booking.passengers.create;

import dk.molslinjen.domain.model.booking.DepartureDirection;
import dk.molslinjen.domain.model.config.Site;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000f\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0011\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"Ldk/molslinjen/ui/views/screens/booking/passengers/create/CheckoutPassengerCreateScreenNavArgs;", BuildConfig.FLAVOR, "Ldk/molslinjen/domain/model/booking/DepartureDirection;", "direction", BuildConfig.FLAVOR, "selectAfterCreation", "Ldk/molslinjen/domain/model/config/Site;", "site", "<init>", "(Ldk/molslinjen/domain/model/booking/DepartureDirection;ZLdk/molslinjen/domain/model/config/Site;)V", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", BuildConfig.FLAVOR, "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ldk/molslinjen/domain/model/booking/DepartureDirection;", "getDirection", "()Ldk/molslinjen/domain/model/booking/DepartureDirection;", "Z", "getSelectAfterCreation", "()Z", "Ldk/molslinjen/domain/model/config/Site;", "getSite", "()Ldk/molslinjen/domain/model/config/Site;", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class CheckoutPassengerCreateScreenNavArgs {
    private final DepartureDirection direction;
    private final boolean selectAfterCreation;
    private final Site site;

    public CheckoutPassengerCreateScreenNavArgs(DepartureDirection direction, boolean z5, Site site) {
        Intrinsics.checkNotNullParameter(direction, "direction");
        Intrinsics.checkNotNullParameter(site, "site");
        this.direction = direction;
        this.selectAfterCreation = z5;
        this.site = site;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CheckoutPassengerCreateScreenNavArgs)) {
            return false;
        }
        CheckoutPassengerCreateScreenNavArgs checkoutPassengerCreateScreenNavArgs = (CheckoutPassengerCreateScreenNavArgs) other;
        return this.direction == checkoutPassengerCreateScreenNavArgs.direction && this.selectAfterCreation == checkoutPassengerCreateScreenNavArgs.selectAfterCreation && this.site == checkoutPassengerCreateScreenNavArgs.site;
    }

    public final DepartureDirection getDirection() {
        return this.direction;
    }

    public final boolean getSelectAfterCreation() {
        return this.selectAfterCreation;
    }

    public final Site getSite() {
        return this.site;
    }

    public int hashCode() {
        return (((this.direction.hashCode() * 31) + Boolean.hashCode(this.selectAfterCreation)) * 31) + this.site.hashCode();
    }

    public String toString() {
        return "CheckoutPassengerCreateScreenNavArgs(direction=" + this.direction + ", selectAfterCreation=" + this.selectAfterCreation + ", site=" + this.site + ")";
    }
}
