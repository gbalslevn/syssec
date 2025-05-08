package dk.molslinjen.ui.views.screens.booking.departures;

import dk.molslinjen.domain.model.booking.TravelTimeToNearestHarborOnRoute;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\b\u0087\b\u0018\u00002\u00020\u0001B'\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bJ0\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0012\u001a\u00020\u00022\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0014\u001a\u0004\b\u0003\u0010\u0015R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u0006\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0014\u001a\u0004\b\u0019\u0010\u0015¨\u0006\u001a"}, d2 = {"Ldk/molslinjen/ui/views/screens/booking/departures/DepartureTabState;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "isLoading", "Ldk/molslinjen/domain/model/booking/TravelTimeToNearestHarborOnRoute;", "travelTime", "showLoadDepartureError", "<init>", "(ZLdk/molslinjen/domain/model/booking/TravelTimeToNearestHarborOnRoute;Z)V", "copy", "(ZLdk/molslinjen/domain/model/booking/TravelTimeToNearestHarborOnRoute;Z)Ldk/molslinjen/ui/views/screens/booking/departures/DepartureTabState;", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", BuildConfig.FLAVOR, "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "()Z", "Ldk/molslinjen/domain/model/booking/TravelTimeToNearestHarborOnRoute;", "getTravelTime", "()Ldk/molslinjen/domain/model/booking/TravelTimeToNearestHarborOnRoute;", "getShowLoadDepartureError", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class DepartureTabState {
    private final boolean isLoading;
    private final boolean showLoadDepartureError;
    private final TravelTimeToNearestHarborOnRoute travelTime;

    public DepartureTabState(boolean z5, TravelTimeToNearestHarborOnRoute travelTimeToNearestHarborOnRoute, boolean z6) {
        this.isLoading = z5;
        this.travelTime = travelTimeToNearestHarborOnRoute;
        this.showLoadDepartureError = z6;
    }

    public static /* synthetic */ DepartureTabState copy$default(DepartureTabState departureTabState, boolean z5, TravelTimeToNearestHarborOnRoute travelTimeToNearestHarborOnRoute, boolean z6, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            z5 = departureTabState.isLoading;
        }
        if ((i5 & 2) != 0) {
            travelTimeToNearestHarborOnRoute = departureTabState.travelTime;
        }
        if ((i5 & 4) != 0) {
            z6 = departureTabState.showLoadDepartureError;
        }
        return departureTabState.copy(z5, travelTimeToNearestHarborOnRoute, z6);
    }

    public final DepartureTabState copy(boolean isLoading, TravelTimeToNearestHarborOnRoute travelTime, boolean showLoadDepartureError) {
        return new DepartureTabState(isLoading, travelTime, showLoadDepartureError);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DepartureTabState)) {
            return false;
        }
        DepartureTabState departureTabState = (DepartureTabState) other;
        return this.isLoading == departureTabState.isLoading && Intrinsics.areEqual(this.travelTime, departureTabState.travelTime) && this.showLoadDepartureError == departureTabState.showLoadDepartureError;
    }

    public final boolean getShowLoadDepartureError() {
        return this.showLoadDepartureError;
    }

    public final TravelTimeToNearestHarborOnRoute getTravelTime() {
        return this.travelTime;
    }

    public int hashCode() {
        int hashCode = Boolean.hashCode(this.isLoading) * 31;
        TravelTimeToNearestHarborOnRoute travelTimeToNearestHarborOnRoute = this.travelTime;
        return ((hashCode + (travelTimeToNearestHarborOnRoute == null ? 0 : travelTimeToNearestHarborOnRoute.hashCode())) * 31) + Boolean.hashCode(this.showLoadDepartureError);
    }

    /* renamed from: isLoading, reason: from getter */
    public final boolean getIsLoading() {
        return this.isLoading;
    }

    public String toString() {
        return "DepartureTabState(isLoading=" + this.isLoading + ", travelTime=" + this.travelTime + ", showLoadDepartureError=" + this.showLoadDepartureError + ")";
    }

    public /* synthetic */ DepartureTabState(boolean z5, TravelTimeToNearestHarborOnRoute travelTimeToNearestHarborOnRoute, boolean z6, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this((i5 & 1) != 0 ? true : z5, (i5 & 2) != 0 ? null : travelTimeToNearestHarborOnRoute, (i5 & 4) != 0 ? false : z6);
    }
}
