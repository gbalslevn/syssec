package dk.molslinjen.ui.views.screens.booking.shared.kombardoTravelDetails;

import dk.molslinjen.ui.views.screens.booking.ticketType.Step;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0005\u0010\u0006J \u0010\b\u001a\u00020\u00072\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0017"}, d2 = {"dk/molslinjen/ui/views/screens/booking/shared/kombardoTravelDetails/IKombardoTravelDetailsHandler$TravelDetailsState", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "Ldk/molslinjen/ui/views/screens/booking/ticketType/Step;", "detailSteps", "<init>", "(Ljava/util/List;)V", "Ldk/molslinjen/ui/views/screens/booking/shared/kombardoTravelDetails/IKombardoTravelDetailsHandler$TravelDetailsState;", "copy", "(Ljava/util/List;)Ldk/molslinjen/ui/views/screens/booking/shared/kombardoTravelDetails/IKombardoTravelDetailsHandler$TravelDetailsState;", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", BuildConfig.FLAVOR, "hashCode", "()I", "other", BuildConfig.FLAVOR, "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", "getDetailSteps", "()Ljava/util/List;", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* renamed from: dk.molslinjen.ui.views.screens.booking.shared.kombardoTravelDetails.IKombardoTravelDetailsHandler$TravelDetailsState, reason: from toString */
/* loaded from: classes2.dex */
public final /* data */ class TravelDetailsState {
    private final List<Step> detailSteps;

    /* JADX WARN: Multi-variable type inference failed */
    public TravelDetailsState(List<? extends Step> detailSteps) {
        Intrinsics.checkNotNullParameter(detailSteps, "detailSteps");
        this.detailSteps = detailSteps;
    }

    public final TravelDetailsState copy(List<? extends Step> detailSteps) {
        Intrinsics.checkNotNullParameter(detailSteps, "detailSteps");
        return new TravelDetailsState(detailSteps);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof TravelDetailsState) && Intrinsics.areEqual(this.detailSteps, ((TravelDetailsState) other).detailSteps);
    }

    public final List<Step> getDetailSteps() {
        return this.detailSteps;
    }

    public int hashCode() {
        return this.detailSteps.hashCode();
    }

    public String toString() {
        return "TravelDetailsState(detailSteps=" + this.detailSteps + ")";
    }

    public /* synthetic */ TravelDetailsState(List list, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this((i5 & 1) != 0 ? CollectionsKt.emptyList() : list);
    }
}
