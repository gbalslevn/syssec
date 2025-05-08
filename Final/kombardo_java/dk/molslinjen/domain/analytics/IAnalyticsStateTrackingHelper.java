package dk.molslinjen.domain.analytics;

import com.google.firebase.analytics.FirebaseAnalytics;
import dk.molslinjen.domain.analytics.AnalyticsStateTrackingHelper;
import dk.molslinjen.domain.managers.user.IUserManager;
import dk.molslinjen.domain.model.booking.BookingType;
import dk.molslinjen.domain.model.config.Site;
import dk.molslinjen.domain.model.config.Transportation;
import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J/\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\tH&¢\u0006\u0002\u0010\u000bJ\u0018\u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000eH&J \u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0012H&J*\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H&¨\u0006\u001a"}, d2 = {"Ldk/molslinjen/domain/analytics/IAnalyticsStateTrackingHelper;", BuildConfig.FLAVOR, "updateStateTracking", BuildConfig.FLAVOR, "firebaseAnalytics", "Lcom/google/firebase/analytics/FirebaseAnalytics;", "userManager", "Ldk/molslinjen/domain/managers/user/IUserManager;", "locationAllowed", BuildConfig.FLAVOR, "pushEnabled", "(Lcom/google/firebase/analytics/FirebaseAnalytics;Ldk/molslinjen/domain/managers/user/IUserManager;ZLjava/lang/Boolean;)V", "updateActiveTab", "activeTab", BuildConfig.FLAVOR, "updateBookingTypeStateTracking", "isEditing", "bookingFlowType", "Ldk/molslinjen/domain/analytics/AnalyticsStateTrackingHelper$BookingFlowTypeTracking;", "updateBookingStateTracking", "activeDepartureSite", "Ldk/molslinjen/domain/model/config/Site;", "bookingType", "Ldk/molslinjen/domain/model/booking/BookingType;", "transportation", "Ldk/molslinjen/domain/model/config/Transportation;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface IAnalyticsStateTrackingHelper {
    void updateActiveTab(FirebaseAnalytics firebaseAnalytics, String activeTab);

    void updateBookingStateTracking(FirebaseAnalytics firebaseAnalytics, Site activeDepartureSite, BookingType bookingType, Transportation transportation);

    void updateBookingTypeStateTracking(FirebaseAnalytics firebaseAnalytics, boolean isEditing, AnalyticsStateTrackingHelper.BookingFlowTypeTracking bookingFlowType);

    void updateStateTracking(FirebaseAnalytics firebaseAnalytics, IUserManager userManager, boolean locationAllowed, Boolean pushEnabled);
}
