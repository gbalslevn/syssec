package dk.molslinjen.domain.analytics;

import android.content.Context;
import dk.molslinjen.domain.model.settings.SettingsProperty;
import kotlin.Metadata;
import kotlin.Unit;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J]\u0010\u0012\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\f2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0018\u0010\u0011\u001a\u0014\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00040\u0010H&¢\u0006\u0004\b\u0012\u0010\u0013J?\u0010\u0015\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\fH&¢\u0006\u0004\b\u0015\u0010\u0016J?\u0010\u0017\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\fH&¢\u0006\u0004\b\u0017\u0010\u0016J?\u0010\u0018\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\fH&¢\u0006\u0004\b\u0018\u0010\u0016J\u001f\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007H&¢\u0006\u0004\b\u001a\u0010\u001bJ7\u0010\u001c\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\fH&¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u000eH&¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010\"\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u0007H&¢\u0006\u0004\b\"\u0010#¨\u0006$"}, d2 = {"Ldk/molslinjen/domain/analytics/IFacebookTracker;", BuildConfig.FLAVOR, "Landroid/content/Context;", "context", BuildConfig.FLAVOR, "setup", "(Landroid/content/Context;)V", BuildConfig.FLAVOR, "contentData", "contentId", "contentType", "currency", BuildConfig.FLAVOR, "price", BuildConfig.FLAVOR, "isAuthenticated", "Ldk/molslinjen/domain/model/settings/SettingsProperty;", "purchaseCountProperty", "trackPurchase", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/Boolean;Ldk/molslinjen/domain/model/settings/SettingsProperty;)V", "quantity", "trackDepartureAdded", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;II)V", "trackSaleOnBoardAdded", "trackMultiRideCardAdded", "searchString", "trackFindTicket", "(Ljava/lang/String;Ljava/lang/String;)V", "trackBeginCheckout", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "success", "trackAddCreditCard", "(Z)V", "tabName", "trackTabChanged", "(Ljava/lang/String;)V", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface IFacebookTracker {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ void trackPurchase$default(IFacebookTracker iFacebookTracker, String str, String str2, String str3, String str4, int i5, Boolean bool, SettingsProperty settingsProperty, int i6, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: trackPurchase");
            }
            iFacebookTracker.trackPurchase(str, str2, str3, str4, i5, (i6 & 32) != 0 ? null : bool, settingsProperty);
        }
    }

    void setup(Context context);

    void trackAddCreditCard(boolean success);

    void trackBeginCheckout(String contentData, String contentId, String contentType, String currency, int price);

    void trackDepartureAdded(String contentData, String contentId, String contentType, String currency, int price, int quantity);

    void trackFindTicket(String searchString, String contentType);

    void trackMultiRideCardAdded(String contentData, String contentId, String contentType, String currency, int price, int quantity);

    void trackPurchase(String contentData, String contentId, String contentType, String currency, int price, Boolean isAuthenticated, SettingsProperty<Integer, Integer, Unit> purchaseCountProperty);

    void trackSaleOnBoardAdded(String contentData, String contentId, String contentType, String currency, int price, int quantity);

    void trackTabChanged(String tabName);
}
