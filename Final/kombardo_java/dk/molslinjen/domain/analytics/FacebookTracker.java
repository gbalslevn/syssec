package dk.molslinjen.domain.analytics;

import android.content.Context;
import android.os.Bundle;
import androidx.core.os.BundleKt;
import com.facebook.FacebookSdk;
import com.facebook.LoggingBehavior;
import com.facebook.appevents.AppEventsLogger;
import dk.molslinjen.core.Environment;
import dk.molslinjen.core.Feature;
import dk.molslinjen.domain.model.settings.ISettings;
import dk.molslinjen.domain.model.settings.SettingsProperty;
import java.math.BigDecimal;
import java.util.Currency;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J)\u0010\u000b\u001a\u00020\n2\u0018\u0010\t\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006H\u0002¢\u0006\u0004\b\u000b\u0010\fJ?\u0010\u0014\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J[\u0010\u001b\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u00072\b\u0010\u001a\u001a\u0004\u0018\u00010\n2\u0018\u0010\t\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ?\u0010\u001d\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u001d\u0010\u0015J?\u0010\u001e\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u001e\u0010\u0015J?\u0010\u001f\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u001f\u0010\u0015J\u0017\u0010!\u001a\u00020\b2\u0006\u0010 \u001a\u00020\rH\u0016¢\u0006\u0004\b!\u0010\"J\u001f\u0010$\u001a\u00020\b2\u0006\u0010#\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\rH\u0016¢\u0006\u0004\b$\u0010%J7\u0010&\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u0007H\u0016¢\u0006\u0004\b&\u0010'J\u0017\u0010)\u001a\u00020\b2\u0006\u0010(\u001a\u00020\nH\u0016¢\u0006\u0004\b)\u0010*R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010+R\u0016\u0010-\u001a\u00020,8\u0002@\u0002X\u0082.¢\u0006\u0006\n\u0004\b-\u0010.¨\u0006/"}, d2 = {"Ldk/molslinjen/domain/analytics/FacebookTracker;", "Ldk/molslinjen/domain/analytics/IFacebookTracker;", "Ldk/molslinjen/domain/model/settings/ISettings;", "settings", "<init>", "(Ldk/molslinjen/domain/model/settings/ISettings;)V", "Ldk/molslinjen/domain/model/settings/SettingsProperty;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "purchaseCountProperty", BuildConfig.FLAVOR, "isFirstPurchase", "(Ldk/molslinjen/domain/model/settings/SettingsProperty;)Z", BuildConfig.FLAVOR, "contentData", "contentId", "contentType", "currency", "quantity", "price", "addToCart", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;II)V", "Landroid/content/Context;", "context", "setup", "(Landroid/content/Context;)V", "isAuthenticated", "trackPurchase", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/Boolean;Ldk/molslinjen/domain/model/settings/SettingsProperty;)V", "trackDepartureAdded", "trackSaleOnBoardAdded", "trackMultiRideCardAdded", "tabName", "trackTabChanged", "(Ljava/lang/String;)V", "searchString", "trackFindTicket", "(Ljava/lang/String;Ljava/lang/String;)V", "trackBeginCheckout", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "success", "trackAddCreditCard", "(Z)V", "Ldk/molslinjen/domain/model/settings/ISettings;", "Lcom/facebook/appevents/AppEventsLogger;", "facebookLogger", "Lcom/facebook/appevents/AppEventsLogger;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class FacebookTracker implements IFacebookTracker {
    private AppEventsLogger facebookLogger;
    private final ISettings settings;

    public FacebookTracker(ISettings settings) {
        Intrinsics.checkNotNullParameter(settings, "settings");
        this.settings = settings;
    }

    private final void addToCart(String contentData, String contentId, String contentType, String currency, int quantity, int price) {
        AppEventsLogger appEventsLogger = null;
        if (currency.length() != 3) {
            currency = null;
        }
        if (currency == null) {
            currency = "DKK";
        }
        Bundle bundleOf = BundleKt.bundleOf(TuplesKt.to("fb_content", contentData), TuplesKt.to("fb_content_id", contentId), TuplesKt.to("fb_content_type", contentType), TuplesKt.to("fb_currency", currency), TuplesKt.to("fb_num_items", Integer.valueOf(quantity)));
        AppEventsLogger appEventsLogger2 = this.facebookLogger;
        if (appEventsLogger2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("facebookLogger");
        } else {
            appEventsLogger = appEventsLogger2;
        }
        appEventsLogger.logEvent("fb_mobile_add_to_cart", price, bundleOf);
    }

    private final boolean isFirstPurchase(SettingsProperty<Integer, Integer, Unit> purchaseCountProperty) {
        return ((Number) this.settings.latestValueFor(purchaseCountProperty)).intValue() == 1;
    }

    @Override // dk.molslinjen.domain.analytics.IFacebookTracker
    public void setup(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        FacebookSdk.fullyInitialize();
        FacebookSdk.setAutoLogAppEventsEnabled(true);
        FacebookSdk.setAutoInitEnabled(true);
        FacebookSdk.setAdvertiserIDCollectionEnabled(true);
        if (Environment.INSTANCE.current() == Environment.Dev) {
            FacebookSdk.setIsDebugEnabled(true);
            FacebookSdk.addLoggingBehavior(LoggingBehavior.APP_EVENTS);
        }
        this.facebookLogger = AppEventsLogger.INSTANCE.newLogger(context);
    }

    @Override // dk.molslinjen.domain.analytics.IFacebookTracker
    public void trackAddCreditCard(boolean success) {
        Bundle bundleOf = BundleKt.bundleOf(TuplesKt.to("fb_success", Integer.valueOf(success ? 1 : 0)));
        AppEventsLogger appEventsLogger = this.facebookLogger;
        if (appEventsLogger == null) {
            Intrinsics.throwUninitializedPropertyAccessException("facebookLogger");
            appEventsLogger = null;
        }
        appEventsLogger.logEvent("fb_mobile_add_payment_info", bundleOf);
    }

    @Override // dk.molslinjen.domain.analytics.IFacebookTracker
    public void trackBeginCheckout(String contentData, String contentId, String contentType, String currency, int price) {
        Intrinsics.checkNotNullParameter(contentData, "contentData");
        Intrinsics.checkNotNullParameter(contentId, "contentId");
        Intrinsics.checkNotNullParameter(contentType, "contentType");
        Intrinsics.checkNotNullParameter(currency, "currency");
        AppEventsLogger appEventsLogger = null;
        if (currency.length() != 3) {
            currency = null;
        }
        if (currency == null) {
            currency = "DKK";
        }
        Bundle bundleOf = BundleKt.bundleOf(TuplesKt.to("fb_content", contentData), TuplesKt.to("fb_content_id", contentId), TuplesKt.to("fb_content_type", contentType), TuplesKt.to("fb_currency", currency));
        Bundle bundleOf2 = BundleKt.bundleOf(TuplesKt.to("fb_content", contentData), TuplesKt.to("fb_content_id", contentId), TuplesKt.to("fb_content_type", contentType), TuplesKt.to("fb_currency", currency), TuplesKt.to("fb_num_items", 1));
        AppEventsLogger appEventsLogger2 = this.facebookLogger;
        if (appEventsLogger2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("facebookLogger");
            appEventsLogger2 = null;
        }
        double d5 = price;
        appEventsLogger2.logEvent("fb_mobile_content_view", d5, bundleOf);
        AppEventsLogger appEventsLogger3 = this.facebookLogger;
        if (appEventsLogger3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("facebookLogger");
        } else {
            appEventsLogger = appEventsLogger3;
        }
        appEventsLogger.logEvent("fb_mobile_initiated_checkout", d5, bundleOf2);
    }

    @Override // dk.molslinjen.domain.analytics.IFacebookTracker
    public void trackDepartureAdded(String contentData, String contentId, String contentType, String currency, int price, int quantity) {
        Intrinsics.checkNotNullParameter(contentData, "contentData");
        Intrinsics.checkNotNullParameter(contentId, "contentId");
        Intrinsics.checkNotNullParameter(contentType, "contentType");
        Intrinsics.checkNotNullParameter(currency, "currency");
        addToCart(contentData, contentId, contentType, currency, quantity, price);
    }

    @Override // dk.molslinjen.domain.analytics.IFacebookTracker
    public void trackFindTicket(String searchString, String contentType) {
        Intrinsics.checkNotNullParameter(searchString, "searchString");
        Intrinsics.checkNotNullParameter(contentType, "contentType");
        Bundle bundleOf = BundleKt.bundleOf(TuplesKt.to("fb_search_string", searchString), TuplesKt.to("fb_content_type", contentType), TuplesKt.to("fb_success", 1));
        AppEventsLogger appEventsLogger = this.facebookLogger;
        if (appEventsLogger == null) {
            Intrinsics.throwUninitializedPropertyAccessException("facebookLogger");
            appEventsLogger = null;
        }
        appEventsLogger.logEvent("fb_mobile_search", bundleOf);
    }

    @Override // dk.molslinjen.domain.analytics.IFacebookTracker
    public void trackMultiRideCardAdded(String contentData, String contentId, String contentType, String currency, int price, int quantity) {
        Intrinsics.checkNotNullParameter(contentData, "contentData");
        Intrinsics.checkNotNullParameter(contentId, "contentId");
        Intrinsics.checkNotNullParameter(contentType, "contentType");
        Intrinsics.checkNotNullParameter(currency, "currency");
        addToCart(contentData, contentId, contentType, currency, quantity, price);
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0081, code lost:
    
        if ((r22 != null ? r22.booleanValue() : true) != false) goto L22;
     */
    @Override // dk.molslinjen.domain.analytics.IFacebookTracker
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void trackPurchase(String contentData, String contentId, String contentType, String currency, int price, Boolean isAuthenticated, SettingsProperty<Integer, Integer, Unit> purchaseCountProperty) {
        boolean z5;
        AppEventsLogger appEventsLogger;
        Intrinsics.checkNotNullParameter(contentData, "contentData");
        Intrinsics.checkNotNullParameter(contentId, "contentId");
        Intrinsics.checkNotNullParameter(contentType, "contentType");
        String currency2 = currency;
        Intrinsics.checkNotNullParameter(currency2, "currency");
        Intrinsics.checkNotNullParameter(purchaseCountProperty, "purchaseCountProperty");
        if (currency.length() != 3) {
            currency2 = null;
        }
        if (currency2 == null) {
            currency2 = "DKK";
        }
        Bundle bundleOf = BundleKt.bundleOf(TuplesKt.to("fb_content", contentData), TuplesKt.to("fb_content_id", contentId), TuplesKt.to("fb_content_type", contentType), TuplesKt.to("fb_currency", currency2));
        AppEventsLogger appEventsLogger2 = this.facebookLogger;
        if (appEventsLogger2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("facebookLogger");
            appEventsLogger2 = null;
        }
        appEventsLogger2.logPurchase(new BigDecimal(price), Currency.getInstance(currency2), bundleOf);
        if (isFirstPurchase(purchaseCountProperty)) {
            if (Feature.Account.isEnabled()) {
                z5 = true;
            }
            z5 = false;
            String str = z5 ? "first_purchase" : "first_purchase_anonymous";
            Bundle bundleOf2 = BundleKt.bundleOf(TuplesKt.to("fb_content", contentData), TuplesKt.to("fb_content_id", contentId), TuplesKt.to("fb_content_type", contentType), TuplesKt.to("fb_currency", currency2));
            AppEventsLogger appEventsLogger3 = this.facebookLogger;
            if (appEventsLogger3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("facebookLogger");
                appEventsLogger = null;
            } else {
                appEventsLogger = appEventsLogger3;
            }
            appEventsLogger.logEvent(str, price, bundleOf2);
        }
    }

    @Override // dk.molslinjen.domain.analytics.IFacebookTracker
    public void trackSaleOnBoardAdded(String contentData, String contentId, String contentType, String currency, int price, int quantity) {
        Intrinsics.checkNotNullParameter(contentData, "contentData");
        Intrinsics.checkNotNullParameter(contentId, "contentId");
        Intrinsics.checkNotNullParameter(contentType, "contentType");
        Intrinsics.checkNotNullParameter(currency, "currency");
        addToCart(contentData, contentId, contentType, currency, quantity, price);
    }

    @Override // dk.molslinjen.domain.analytics.IFacebookTracker
    public void trackTabChanged(String tabName) {
        Intrinsics.checkNotNullParameter(tabName, "tabName");
        Bundle bundleOf = BundleKt.bundleOf(TuplesKt.to("fb_content", tabName));
        AppEventsLogger appEventsLogger = this.facebookLogger;
        if (appEventsLogger == null) {
            Intrinsics.throwUninitializedPropertyAccessException("facebookLogger");
            appEventsLogger = null;
        }
        appEventsLogger.logEvent("fb_mobile_content_view", bundleOf);
    }
}
