package dk.molslinjen.ui.views.screens.config.regular.checkout.helpers;

import androidx.compose.runtime.Composer;
import com.ramcosta.composedestinations.navigation.DestinationsNavigator;
import dk.molslinjen.ui.views.screens.booking.shared.expiration.IExpirableCheckout;
import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001d\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H'¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"Ldk/molslinjen/ui/views/screens/config/regular/checkout/helpers/ICheckoutExpirationDialogHandler;", BuildConfig.FLAVOR, "HandleDepartureExpiration", BuildConfig.FLAVOR, "expirableDepartures", "Ldk/molslinjen/ui/views/screens/booking/shared/expiration/IExpirableCheckout;", "navigator", "Lcom/ramcosta/composedestinations/navigation/DestinationsNavigator;", "(Ldk/molslinjen/ui/views/screens/booking/shared/expiration/IExpirableCheckout;Lcom/ramcosta/composedestinations/navigation/DestinationsNavigator;Landroidx/compose/runtime/Composer;I)V", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface ICheckoutExpirationDialogHandler {
    void HandleDepartureExpiration(IExpirableCheckout iExpirableCheckout, DestinationsNavigator destinationsNavigator, Composer composer, int i5);
}
