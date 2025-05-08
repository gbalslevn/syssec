package dk.molslinjen.domain.managers.checkout.passengers;

import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005R\u0012\u0010\b\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0005R\u0012\u0010\n\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0005R\u0012\u0010\f\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u0005R\u0012\u0010\u000e\u001a\u00020\u000fX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Ldk/molslinjen/domain/managers/checkout/passengers/ISharedPassengerSelectionViewState;", BuildConfig.FLAVOR, "remainingPassengerCount", BuildConfig.FLAVOR, "getRemainingPassengerCount", "()I", "remainingAdultCount", "getRemainingAdultCount", "remainingChildCount", "getRemainingChildCount", "remainingInfantCount", "getRemainingInfantCount", "passengerCount", "getPassengerCount", "showAgeGroup", BuildConfig.FLAVOR, "getShowAgeGroup", "()Z", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface ISharedPassengerSelectionViewState {
    int getPassengerCount();

    int getRemainingAdultCount();

    int getRemainingChildCount();

    int getRemainingInfantCount();

    int getRemainingPassengerCount();

    boolean getShowAgeGroup();
}
