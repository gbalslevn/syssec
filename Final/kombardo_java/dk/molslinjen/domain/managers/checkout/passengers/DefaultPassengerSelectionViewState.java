package dk.molslinjen.domain.managers.checkout.passengers;

import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0013\u001a\u00020\b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0003\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0015\u001a\u0004\b\u0016\u0010\u0010R\u001a\u0010\u0004\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0015\u001a\u0004\b\u0017\u0010\u0010R\u001a\u0010\u0005\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0015\u001a\u0004\b\u0018\u0010\u0010R\u001a\u0010\u0006\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0015\u001a\u0004\b\u0019\u0010\u0010R\u001a\u0010\u0007\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0015\u001a\u0004\b\u001a\u0010\u0010R\u001a\u0010\t\u001a\u00020\b8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\t\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d¨\u0006\u001e"}, d2 = {"Ldk/molslinjen/domain/managers/checkout/passengers/DefaultPassengerSelectionViewState;", "Ldk/molslinjen/domain/managers/checkout/passengers/ISharedPassengerSelectionViewState;", BuildConfig.FLAVOR, "remainingPassengerCount", "remainingAdultCount", "remainingChildCount", "remainingInfantCount", "passengerCount", BuildConfig.FLAVOR, "showAgeGroup", "<init>", "(IIIIIZ)V", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", "hashCode", "()I", BuildConfig.FLAVOR, "other", "equals", "(Ljava/lang/Object;)Z", "I", "getRemainingPassengerCount", "getRemainingAdultCount", "getRemainingChildCount", "getRemainingInfantCount", "getPassengerCount", "Z", "getShowAgeGroup", "()Z", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final /* data */ class DefaultPassengerSelectionViewState implements ISharedPassengerSelectionViewState {
    private final int passengerCount;
    private final int remainingAdultCount;
    private final int remainingChildCount;
    private final int remainingInfantCount;
    private final int remainingPassengerCount;
    private final boolean showAgeGroup;

    public DefaultPassengerSelectionViewState(int i5, int i6, int i7, int i8, int i9, boolean z5) {
        this.remainingPassengerCount = i5;
        this.remainingAdultCount = i6;
        this.remainingChildCount = i7;
        this.remainingInfantCount = i8;
        this.passengerCount = i9;
        this.showAgeGroup = z5;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DefaultPassengerSelectionViewState)) {
            return false;
        }
        DefaultPassengerSelectionViewState defaultPassengerSelectionViewState = (DefaultPassengerSelectionViewState) other;
        return this.remainingPassengerCount == defaultPassengerSelectionViewState.remainingPassengerCount && this.remainingAdultCount == defaultPassengerSelectionViewState.remainingAdultCount && this.remainingChildCount == defaultPassengerSelectionViewState.remainingChildCount && this.remainingInfantCount == defaultPassengerSelectionViewState.remainingInfantCount && this.passengerCount == defaultPassengerSelectionViewState.passengerCount && this.showAgeGroup == defaultPassengerSelectionViewState.showAgeGroup;
    }

    @Override // dk.molslinjen.domain.managers.checkout.passengers.ISharedPassengerSelectionViewState
    public int getPassengerCount() {
        return this.passengerCount;
    }

    @Override // dk.molslinjen.domain.managers.checkout.passengers.ISharedPassengerSelectionViewState
    public int getRemainingAdultCount() {
        return this.remainingAdultCount;
    }

    @Override // dk.molslinjen.domain.managers.checkout.passengers.ISharedPassengerSelectionViewState
    public int getRemainingChildCount() {
        return this.remainingChildCount;
    }

    @Override // dk.molslinjen.domain.managers.checkout.passengers.ISharedPassengerSelectionViewState
    public int getRemainingInfantCount() {
        return this.remainingInfantCount;
    }

    @Override // dk.molslinjen.domain.managers.checkout.passengers.ISharedPassengerSelectionViewState
    public int getRemainingPassengerCount() {
        return this.remainingPassengerCount;
    }

    @Override // dk.molslinjen.domain.managers.checkout.passengers.ISharedPassengerSelectionViewState
    public boolean getShowAgeGroup() {
        return this.showAgeGroup;
    }

    public int hashCode() {
        return (((((((((Integer.hashCode(this.remainingPassengerCount) * 31) + Integer.hashCode(this.remainingAdultCount)) * 31) + Integer.hashCode(this.remainingChildCount)) * 31) + Integer.hashCode(this.remainingInfantCount)) * 31) + Integer.hashCode(this.passengerCount)) * 31) + Boolean.hashCode(this.showAgeGroup);
    }

    public String toString() {
        return "DefaultPassengerSelectionViewState(remainingPassengerCount=" + this.remainingPassengerCount + ", remainingAdultCount=" + this.remainingAdultCount + ", remainingChildCount=" + this.remainingChildCount + ", remainingInfantCount=" + this.remainingInfantCount + ", passengerCount=" + this.passengerCount + ", showAgeGroup=" + this.showAgeGroup + ")";
    }
}
