package dk.molslinjen.ui.views.screens.profile.passengers.edit;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u001a\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\r\u0010\u000eR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u000f\u001a\u0004\b\u0010\u0010\u0007¨\u0006\u0011"}, d2 = {"Ldk/molslinjen/ui/views/screens/profile/passengers/edit/ProfilePassengerEditScreenNavArgs;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "passengerLocalId", "<init>", "(Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", BuildConfig.FLAVOR, "hashCode", "()I", "other", BuildConfig.FLAVOR, "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getPassengerLocalId", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class ProfilePassengerEditScreenNavArgs {
    private final String passengerLocalId;

    public ProfilePassengerEditScreenNavArgs(String passengerLocalId) {
        Intrinsics.checkNotNullParameter(passengerLocalId, "passengerLocalId");
        this.passengerLocalId = passengerLocalId;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof ProfilePassengerEditScreenNavArgs) && Intrinsics.areEqual(this.passengerLocalId, ((ProfilePassengerEditScreenNavArgs) other).passengerLocalId);
    }

    public final String getPassengerLocalId() {
        return this.passengerLocalId;
    }

    public int hashCode() {
        return this.passengerLocalId.hashCode();
    }

    public String toString() {
        return "ProfilePassengerEditScreenNavArgs(passengerLocalId=" + this.passengerLocalId + ")";
    }
}
