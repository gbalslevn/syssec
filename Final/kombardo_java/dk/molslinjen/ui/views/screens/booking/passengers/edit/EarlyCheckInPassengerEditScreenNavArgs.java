package dk.molslinjen.ui.views.screens.booking.passengers.edit;

import dk.molslinjen.domain.model.config.Site;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0011\u001a\u0004\b\u0012\u0010\tR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Ldk/molslinjen/ui/views/screens/booking/passengers/edit/EarlyCheckInPassengerEditScreenNavArgs;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "passengerLocalId", "Ldk/molslinjen/domain/model/config/Site;", "site", "<init>", "(Ljava/lang/String;Ldk/molslinjen/domain/model/config/Site;)V", "toString", "()Ljava/lang/String;", BuildConfig.FLAVOR, "hashCode", "()I", "other", BuildConfig.FLAVOR, "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getPassengerLocalId", "Ldk/molslinjen/domain/model/config/Site;", "getSite", "()Ldk/molslinjen/domain/model/config/Site;", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class EarlyCheckInPassengerEditScreenNavArgs {
    private final String passengerLocalId;
    private final Site site;

    public EarlyCheckInPassengerEditScreenNavArgs(String passengerLocalId, Site site) {
        Intrinsics.checkNotNullParameter(passengerLocalId, "passengerLocalId");
        Intrinsics.checkNotNullParameter(site, "site");
        this.passengerLocalId = passengerLocalId;
        this.site = site;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EarlyCheckInPassengerEditScreenNavArgs)) {
            return false;
        }
        EarlyCheckInPassengerEditScreenNavArgs earlyCheckInPassengerEditScreenNavArgs = (EarlyCheckInPassengerEditScreenNavArgs) other;
        return Intrinsics.areEqual(this.passengerLocalId, earlyCheckInPassengerEditScreenNavArgs.passengerLocalId) && this.site == earlyCheckInPassengerEditScreenNavArgs.site;
    }

    public final String getPassengerLocalId() {
        return this.passengerLocalId;
    }

    public final Site getSite() {
        return this.site;
    }

    public int hashCode() {
        return (this.passengerLocalId.hashCode() * 31) + this.site.hashCode();
    }

    public String toString() {
        return "EarlyCheckInPassengerEditScreenNavArgs(passengerLocalId=" + this.passengerLocalId + ", site=" + this.site + ")";
    }
}
