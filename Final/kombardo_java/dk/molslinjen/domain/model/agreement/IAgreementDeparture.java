package dk.molslinjen.domain.model.agreement;

import dk.molslinjen.domain.model.booking.IDepartureInfo;
import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001R\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005¨\u0006\b"}, d2 = {"Ldk/molslinjen/domain/model/agreement/IAgreementDeparture;", "Ldk/molslinjen/domain/model/booking/IDepartureInfo;", "phone", BuildConfig.FLAVOR, "getPhone", "()Ljava/lang/String;", "reservationNumber", "getReservationNumber", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface IAgreementDeparture extends IDepartureInfo {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class DefaultImpls {
        public static String getTransportSwitchDescription(IAgreementDeparture iAgreementDeparture) {
            return IDepartureInfo.DefaultImpls.getTransportSwitchDescription(iAgreementDeparture);
        }
    }

    String getPhone();

    String getReservationNumber();
}
