package dk.molslinjen.ui.views.screens.booking.passengers.edit;

import dk.molslinjen.domain.model.booking.DepartureDirection;
import dk.molslinjen.domain.model.config.Site;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0013\u001a\u0004\b\u0014\u0010\u000bR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, d2 = {"Ldk/molslinjen/ui/views/screens/booking/passengers/edit/CheckoutPassengerEditScreenNavArgs;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "passengerLocalId", "Ldk/molslinjen/domain/model/booking/DepartureDirection;", "direction", "Ldk/molslinjen/domain/model/config/Site;", "site", "<init>", "(Ljava/lang/String;Ldk/molslinjen/domain/model/booking/DepartureDirection;Ldk/molslinjen/domain/model/config/Site;)V", "toString", "()Ljava/lang/String;", BuildConfig.FLAVOR, "hashCode", "()I", "other", BuildConfig.FLAVOR, "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getPassengerLocalId", "Ldk/molslinjen/domain/model/booking/DepartureDirection;", "getDirection", "()Ldk/molslinjen/domain/model/booking/DepartureDirection;", "Ldk/molslinjen/domain/model/config/Site;", "getSite", "()Ldk/molslinjen/domain/model/config/Site;", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class CheckoutPassengerEditScreenNavArgs {
    private final DepartureDirection direction;
    private final String passengerLocalId;
    private final Site site;

    public CheckoutPassengerEditScreenNavArgs(String passengerLocalId, DepartureDirection direction, Site site) {
        Intrinsics.checkNotNullParameter(passengerLocalId, "passengerLocalId");
        Intrinsics.checkNotNullParameter(direction, "direction");
        Intrinsics.checkNotNullParameter(site, "site");
        this.passengerLocalId = passengerLocalId;
        this.direction = direction;
        this.site = site;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CheckoutPassengerEditScreenNavArgs)) {
            return false;
        }
        CheckoutPassengerEditScreenNavArgs checkoutPassengerEditScreenNavArgs = (CheckoutPassengerEditScreenNavArgs) other;
        return Intrinsics.areEqual(this.passengerLocalId, checkoutPassengerEditScreenNavArgs.passengerLocalId) && this.direction == checkoutPassengerEditScreenNavArgs.direction && this.site == checkoutPassengerEditScreenNavArgs.site;
    }

    public final DepartureDirection getDirection() {
        return this.direction;
    }

    public final String getPassengerLocalId() {
        return this.passengerLocalId;
    }

    public final Site getSite() {
        return this.site;
    }

    public int hashCode() {
        return (((this.passengerLocalId.hashCode() * 31) + this.direction.hashCode()) * 31) + this.site.hashCode();
    }

    public String toString() {
        return "CheckoutPassengerEditScreenNavArgs(passengerLocalId=" + this.passengerLocalId + ", direction=" + this.direction + ", site=" + this.site + ")";
    }
}
