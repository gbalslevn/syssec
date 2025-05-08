package dk.molslinjen.ui.views.screens.profile.brobizz.shared;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\u0003\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0012\u001a\u0004\b\u0013\u0010\n¨\u0006\u0014"}, d2 = {"dk/molslinjen/ui/views/screens/profile/brobizz/shared/IProfileBrobizzInputHandler$InputState", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "brobizzNumber", "<init>", "(Ljava/lang/String;)V", "Ldk/molslinjen/ui/views/screens/profile/brobizz/shared/IProfileBrobizzInputHandler$InputState;", "copy", "(Ljava/lang/String;)Ldk/molslinjen/ui/views/screens/profile/brobizz/shared/IProfileBrobizzInputHandler$InputState;", "toString", "()Ljava/lang/String;", BuildConfig.FLAVOR, "hashCode", "()I", "other", BuildConfig.FLAVOR, "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getBrobizzNumber", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* renamed from: dk.molslinjen.ui.views.screens.profile.brobizz.shared.IProfileBrobizzInputHandler$InputState, reason: from toString */
/* loaded from: classes2.dex */
public final /* data */ class InputState {
    private final String brobizzNumber;

    public InputState(String brobizzNumber) {
        Intrinsics.checkNotNullParameter(brobizzNumber, "brobizzNumber");
        this.brobizzNumber = brobizzNumber;
    }

    public final InputState copy(String brobizzNumber) {
        Intrinsics.checkNotNullParameter(brobizzNumber, "brobizzNumber");
        return new InputState(brobizzNumber);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof InputState) && Intrinsics.areEqual(this.brobizzNumber, ((InputState) other).brobizzNumber);
    }

    public final String getBrobizzNumber() {
        return this.brobizzNumber;
    }

    public int hashCode() {
        return this.brobizzNumber.hashCode();
    }

    public String toString() {
        return "InputState(brobizzNumber=" + this.brobizzNumber + ")";
    }

    public /* synthetic */ InputState(String str, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this((i5 & 1) != 0 ? BuildConfig.FLAVOR : str);
    }
}
