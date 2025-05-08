package dk.molslinjen.ui.views.screens.agreements.multiride.details;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0087\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\u0010\u0004\u001a\u00060\u0002j\u0002`\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0004\u001a\u00060\u0002j\u0002`\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0010\u001a\u0004\b\u0011\u0010\b¨\u0006\u0012"}, d2 = {"Ldk/molslinjen/ui/views/screens/agreements/multiride/details/MultiRideDetailsScreenNavArgs;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "Ldk/molslinjen/domain/model/agreement/multiRide/MultiRideCardNumber;", "multiRideCardNumber", "<init>", "(Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", BuildConfig.FLAVOR, "hashCode", "()I", "other", BuildConfig.FLAVOR, "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getMultiRideCardNumber", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class MultiRideDetailsScreenNavArgs {
    private final String multiRideCardNumber;

    public MultiRideDetailsScreenNavArgs(String multiRideCardNumber) {
        Intrinsics.checkNotNullParameter(multiRideCardNumber, "multiRideCardNumber");
        this.multiRideCardNumber = multiRideCardNumber;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof MultiRideDetailsScreenNavArgs) && Intrinsics.areEqual(this.multiRideCardNumber, ((MultiRideDetailsScreenNavArgs) other).multiRideCardNumber);
    }

    public final String getMultiRideCardNumber() {
        return this.multiRideCardNumber;
    }

    public int hashCode() {
        return this.multiRideCardNumber.hashCode();
    }

    public String toString() {
        return "MultiRideDetailsScreenNavArgs(multiRideCardNumber=" + this.multiRideCardNumber + ")";
    }
}
