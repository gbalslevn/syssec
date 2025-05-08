package dk.molslinjen.ui.views.screens.booking.passengers.create;

import dk.molslinjen.domain.model.config.Site;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u000f\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"Ldk/molslinjen/ui/views/screens/booking/passengers/create/EarlyCheckInPassengerCreateScreenNavArgs;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "selectAfterCreation", "Ldk/molslinjen/domain/model/config/Site;", "site", "<init>", "(ZLdk/molslinjen/domain/model/config/Site;)V", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", BuildConfig.FLAVOR, "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "getSelectAfterCreation", "()Z", "Ldk/molslinjen/domain/model/config/Site;", "getSite", "()Ldk/molslinjen/domain/model/config/Site;", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class EarlyCheckInPassengerCreateScreenNavArgs {
    private final boolean selectAfterCreation;
    private final Site site;

    public EarlyCheckInPassengerCreateScreenNavArgs(boolean z5, Site site) {
        Intrinsics.checkNotNullParameter(site, "site");
        this.selectAfterCreation = z5;
        this.site = site;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EarlyCheckInPassengerCreateScreenNavArgs)) {
            return false;
        }
        EarlyCheckInPassengerCreateScreenNavArgs earlyCheckInPassengerCreateScreenNavArgs = (EarlyCheckInPassengerCreateScreenNavArgs) other;
        return this.selectAfterCreation == earlyCheckInPassengerCreateScreenNavArgs.selectAfterCreation && this.site == earlyCheckInPassengerCreateScreenNavArgs.site;
    }

    public final boolean getSelectAfterCreation() {
        return this.selectAfterCreation;
    }

    public final Site getSite() {
        return this.site;
    }

    public int hashCode() {
        return (Boolean.hashCode(this.selectAfterCreation) * 31) + this.site.hashCode();
    }

    public String toString() {
        return "EarlyCheckInPassengerCreateScreenNavArgs(selectAfterCreation=" + this.selectAfterCreation + ", site=" + this.site + ")";
    }
}
