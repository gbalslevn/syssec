package dk.molslinjen.ui.views.screens.booking.shared.expiration;

import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&J\b\u0010\u0007\u001a\u00020\u0003H&J\b\u0010\b\u001a\u00020\u0003H&J\b\u0010\t\u001a\u00020\u0003H&J\b\u0010\n\u001a\u00020\u0003H&¨\u0006\u000b"}, d2 = {"Ldk/molslinjen/ui/views/screens/booking/shared/expiration/IExpirableCheckout;", BuildConfig.FLAVOR, "isExpired", BuildConfig.FLAVOR, "resetCheckoutAfterExpiredDepartures", BuildConfig.FLAVOR, "isEditing", "isMultiRide", "isCommuter", "showReloadDialog", "isInCheckoutFlow", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface IExpirableCheckout {
    boolean isCommuter();

    boolean isEditing();

    boolean isExpired();

    boolean isInCheckoutFlow();

    boolean isMultiRide();

    void resetCheckoutAfterExpiredDepartures();

    boolean showReloadDialog();
}
