package dk.molslinjen.ui.views.screens.booking.departures;

import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\r\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\r\u0010\u000eR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u000f\u001a\u0004\b\u0003\u0010\u0010¨\u0006\u0011"}, d2 = {"Ldk/molslinjen/ui/views/screens/booking/departures/DeparturesScreenNavArgs;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "isAddingReturnFromBookingSummary", "<init>", "(Z)V", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", BuildConfig.FLAVOR, "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "()Z", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class DeparturesScreenNavArgs {
    private final boolean isAddingReturnFromBookingSummary;

    public DeparturesScreenNavArgs(boolean z5) {
        this.isAddingReturnFromBookingSummary = z5;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof DeparturesScreenNavArgs) && this.isAddingReturnFromBookingSummary == ((DeparturesScreenNavArgs) other).isAddingReturnFromBookingSummary;
    }

    public int hashCode() {
        return Boolean.hashCode(this.isAddingReturnFromBookingSummary);
    }

    /* renamed from: isAddingReturnFromBookingSummary, reason: from getter */
    public final boolean getIsAddingReturnFromBookingSummary() {
        return this.isAddingReturnFromBookingSummary;
    }

    public String toString() {
        return "DeparturesScreenNavArgs(isAddingReturnFromBookingSummary=" + this.isAddingReturnFromBookingSummary + ")";
    }
}
