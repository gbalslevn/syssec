package dk.molslinjen.ui.views.screens.profile.vehicles.selector;

import dk.molslinjen.domain.model.config.Site;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\b\u0087\b\u0018\u00002\u00020\u0001B?\u0012\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u0004\u0012\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u0004\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R'\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R'\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0014\u001a\u0004\b\u0017\u0010\u0016R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, d2 = {"Ldk/molslinjen/ui/views/screens/profile/vehicles/selector/VehicleSelectorScreenNavArgs;", BuildConfig.FLAVOR, "Ljava/util/ArrayList;", BuildConfig.FLAVOR, "Lkotlin/collections/ArrayList;", "carIds", "transportationIds", "Ldk/molslinjen/domain/model/config/Site;", "site", "<init>", "(Ljava/util/ArrayList;Ljava/util/ArrayList;Ldk/molslinjen/domain/model/config/Site;)V", "toString", "()Ljava/lang/String;", BuildConfig.FLAVOR, "hashCode", "()I", "other", BuildConfig.FLAVOR, "equals", "(Ljava/lang/Object;)Z", "Ljava/util/ArrayList;", "getCarIds", "()Ljava/util/ArrayList;", "getTransportationIds", "Ldk/molslinjen/domain/model/config/Site;", "getSite", "()Ldk/molslinjen/domain/model/config/Site;", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class VehicleSelectorScreenNavArgs {
    private final ArrayList<String> carIds;
    private final Site site;
    private final ArrayList<String> transportationIds;

    public VehicleSelectorScreenNavArgs(ArrayList<String> carIds, ArrayList<String> transportationIds, Site site) {
        Intrinsics.checkNotNullParameter(carIds, "carIds");
        Intrinsics.checkNotNullParameter(transportationIds, "transportationIds");
        Intrinsics.checkNotNullParameter(site, "site");
        this.carIds = carIds;
        this.transportationIds = transportationIds;
        this.site = site;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VehicleSelectorScreenNavArgs)) {
            return false;
        }
        VehicleSelectorScreenNavArgs vehicleSelectorScreenNavArgs = (VehicleSelectorScreenNavArgs) other;
        return Intrinsics.areEqual(this.carIds, vehicleSelectorScreenNavArgs.carIds) && Intrinsics.areEqual(this.transportationIds, vehicleSelectorScreenNavArgs.transportationIds) && this.site == vehicleSelectorScreenNavArgs.site;
    }

    public final ArrayList<String> getCarIds() {
        return this.carIds;
    }

    public final Site getSite() {
        return this.site;
    }

    public final ArrayList<String> getTransportationIds() {
        return this.transportationIds;
    }

    public int hashCode() {
        return (((this.carIds.hashCode() * 31) + this.transportationIds.hashCode()) * 31) + this.site.hashCode();
    }

    public String toString() {
        return "VehicleSelectorScreenNavArgs(carIds=" + this.carIds + ", transportationIds=" + this.transportationIds + ", site=" + this.site + ")";
    }
}
