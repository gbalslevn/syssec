package dk.molslinjen.ui.views.screens.tickets.earlyCheckIn;

import dk.molslinjen.domain.model.config.Site;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0012\u001a\u0004\b\u0013\u0010\nR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0012\u001a\u0004\b\u0014\u0010\nR\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Ldk/molslinjen/ui/views/screens/tickets/earlyCheckIn/EarlyCheckInScreenNavArgs;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "reservationNumber", "phone", "Ldk/molslinjen/domain/model/config/Site;", "site", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ldk/molslinjen/domain/model/config/Site;)V", "toString", "()Ljava/lang/String;", BuildConfig.FLAVOR, "hashCode", "()I", "other", BuildConfig.FLAVOR, "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getReservationNumber", "getPhone", "Ldk/molslinjen/domain/model/config/Site;", "getSite", "()Ldk/molslinjen/domain/model/config/Site;", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class EarlyCheckInScreenNavArgs {
    private final String phone;
    private final String reservationNumber;
    private final Site site;

    public EarlyCheckInScreenNavArgs(String reservationNumber, String phone, Site site) {
        Intrinsics.checkNotNullParameter(reservationNumber, "reservationNumber");
        Intrinsics.checkNotNullParameter(phone, "phone");
        Intrinsics.checkNotNullParameter(site, "site");
        this.reservationNumber = reservationNumber;
        this.phone = phone;
        this.site = site;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EarlyCheckInScreenNavArgs)) {
            return false;
        }
        EarlyCheckInScreenNavArgs earlyCheckInScreenNavArgs = (EarlyCheckInScreenNavArgs) other;
        return Intrinsics.areEqual(this.reservationNumber, earlyCheckInScreenNavArgs.reservationNumber) && Intrinsics.areEqual(this.phone, earlyCheckInScreenNavArgs.phone) && this.site == earlyCheckInScreenNavArgs.site;
    }

    public final String getPhone() {
        return this.phone;
    }

    public final String getReservationNumber() {
        return this.reservationNumber;
    }

    public final Site getSite() {
        return this.site;
    }

    public int hashCode() {
        return (((this.reservationNumber.hashCode() * 31) + this.phone.hashCode()) * 31) + this.site.hashCode();
    }

    public String toString() {
        return "EarlyCheckInScreenNavArgs(reservationNumber=" + this.reservationNumber + ", phone=" + this.phone + ", site=" + this.site + ")";
    }
}
