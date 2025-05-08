package dk.molslinjen.ui.views.screens.booking.passengers.create;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u000f\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0011\u001a\u0004\b\u0003\u0010\u0012¨\u0006\u0013"}, d2 = {"Ldk/molslinjen/ui/views/screens/booking/passengers/create/PassengerCreateViewState;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "isLoading", "<init>", "(Z)V", "copy", "(Z)Ldk/molslinjen/ui/views/screens/booking/passengers/create/PassengerCreateViewState;", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", BuildConfig.FLAVOR, "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Z", "()Z", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class PassengerCreateViewState {
    private final boolean isLoading;

    public PassengerCreateViewState(boolean z5) {
        this.isLoading = z5;
    }

    public final PassengerCreateViewState copy(boolean isLoading) {
        return new PassengerCreateViewState(isLoading);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof PassengerCreateViewState) && this.isLoading == ((PassengerCreateViewState) other).isLoading;
    }

    public int hashCode() {
        return Boolean.hashCode(this.isLoading);
    }

    /* renamed from: isLoading, reason: from getter */
    public final boolean getIsLoading() {
        return this.isLoading;
    }

    public String toString() {
        return "PassengerCreateViewState(isLoading=" + this.isLoading + ")";
    }

    public /* synthetic */ PassengerCreateViewState(boolean z5, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this((i5 & 1) != 0 ? false : z5);
    }
}
