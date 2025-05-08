package dk.molslinjen.ui.views.screens.profile.vehicles.shared;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J$\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0013\u001a\u0004\b\u0014\u0010\u000bR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0013\u001a\u0004\b\u0015\u0010\u000b¨\u0006\u0016"}, d2 = {"dk/molslinjen/ui/views/screens/profile/vehicles/shared/IProfileVehicleInputHandler$InputState", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "licensePlate", "name", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "Ldk/molslinjen/ui/views/screens/profile/vehicles/shared/IProfileVehicleInputHandler$InputState;", "copy", "(Ljava/lang/String;Ljava/lang/String;)Ldk/molslinjen/ui/views/screens/profile/vehicles/shared/IProfileVehicleInputHandler$InputState;", "toString", "()Ljava/lang/String;", BuildConfig.FLAVOR, "hashCode", "()I", "other", BuildConfig.FLAVOR, "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getLicensePlate", "getName", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* renamed from: dk.molslinjen.ui.views.screens.profile.vehicles.shared.IProfileVehicleInputHandler$InputState, reason: from toString */
/* loaded from: classes2.dex */
public final /* data */ class InputState {
    private final String licensePlate;
    private final String name;

    public InputState(String licensePlate, String name) {
        Intrinsics.checkNotNullParameter(licensePlate, "licensePlate");
        Intrinsics.checkNotNullParameter(name, "name");
        this.licensePlate = licensePlate;
        this.name = name;
    }

    public static /* synthetic */ InputState copy$default(InputState inputState, String str, String str2, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            str = inputState.licensePlate;
        }
        if ((i5 & 2) != 0) {
            str2 = inputState.name;
        }
        return inputState.copy(str, str2);
    }

    public final InputState copy(String licensePlate, String name) {
        Intrinsics.checkNotNullParameter(licensePlate, "licensePlate");
        Intrinsics.checkNotNullParameter(name, "name");
        return new InputState(licensePlate, name);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof InputState)) {
            return false;
        }
        InputState inputState = (InputState) other;
        return Intrinsics.areEqual(this.licensePlate, inputState.licensePlate) && Intrinsics.areEqual(this.name, inputState.name);
    }

    public final String getLicensePlate() {
        return this.licensePlate;
    }

    public final String getName() {
        return this.name;
    }

    public int hashCode() {
        return (this.licensePlate.hashCode() * 31) + this.name.hashCode();
    }

    public String toString() {
        return "InputState(licensePlate=" + this.licensePlate + ", name=" + this.name + ")";
    }

    public /* synthetic */ InputState(String str, String str2, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this((i5 & 1) != 0 ? BuildConfig.FLAVOR : str, (i5 & 2) != 0 ? BuildConfig.FLAVOR : str2);
    }
}
