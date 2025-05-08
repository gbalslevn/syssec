package dk.molslinjen.domain.analytics;

import android.os.Bundle;
import androidx.core.os.BundleKt;
import com.google.firebase.analytics.FirebaseAnalytics;
import dk.molslinjen.domain.analytics.AnalyticsTracker;
import dk.molslinjen.domain.extensions.AnalyticsExtensionsKt;
import dk.molslinjen.domain.extensions.LocalDateTimeExtensionsKt;
import dk.molslinjen.domain.model.booking.BookingType;
import dk.molslinjen.domain.model.booking.Departure;
import dk.molslinjen.domain.model.booking.DepartureTicket;
import dk.molslinjen.domain.model.booking.PassengerInfo;
import dk.molslinjen.domain.model.booking.TicketSection;
import dk.molslinjen.domain.model.config.Route;
import dk.molslinjen.domain.model.config.Transportation;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.conscrypt.BuildConfig;
import org.threeten.bp.LocalDate;
import org.threeten.bp.temporal.ChronoUnit;

@Metadata(d1 = {"\u0000¢\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001: \n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u001d\u001e\u001f !\"#$%&'()B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&\u0082\u0001 *+,-./0123456789:;<=>?@ABCDEFGHI¨\u0006J"}, d2 = {"Ldk/molslinjen/domain/analytics/AnalyticsEvent;", BuildConfig.FLAVOR, "<init>", "()V", "track", BuildConfig.FLAVOR, "firebaseAnalytics", "Lcom/google/firebase/analytics/FirebaseAnalytics;", "facebookTracker", "Ldk/molslinjen/domain/analytics/IFacebookTracker;", "BookingInitiated", "ChangePushEvent", "ChangeMarketingPushEvent", "ChangeLocationPermissionEvent", "ChangeRouteEvent", "ChangeRouteDirectionEvent", "ChangeDateEvent", "ChangeTransportationEvent", "ChangeReturnTripEvent", "ShowDirectionsEvent", "SelectTicketTypeEvent", "StopAddingReturnTripEvent", "StartAddReturnTripFromSummaryEvent", "OtherPaymentCardWhenHasSavedCardsEvent", "MobilePayEvent", "ChangedProfileInfoEvent", "RemovedSavedCardEvent", "ShownFaqEvent", "StartEditTicketEvent", "CancelledEditTicketEvent", "TimeoutEvent", "CallSupportEvent", "AddExistingMultiRideCard", "AddCommuterAgreements", "CreateAccount", "Login", "Logout", "SaleOnBoardOrderError", "SaleOnBoardNoMenuAvailable", "PaymentFailed", "NavigatedBackThroughCheckoutTopBar", "SplitTestExperimentViewed", "Ldk/molslinjen/domain/analytics/AnalyticsEvent$AddCommuterAgreements;", "Ldk/molslinjen/domain/analytics/AnalyticsEvent$AddExistingMultiRideCard;", "Ldk/molslinjen/domain/analytics/AnalyticsEvent$BookingInitiated;", "Ldk/molslinjen/domain/analytics/AnalyticsEvent$CallSupportEvent;", "Ldk/molslinjen/domain/analytics/AnalyticsEvent$CancelledEditTicketEvent;", "Ldk/molslinjen/domain/analytics/AnalyticsEvent$ChangeDateEvent;", "Ldk/molslinjen/domain/analytics/AnalyticsEvent$ChangeLocationPermissionEvent;", "Ldk/molslinjen/domain/analytics/AnalyticsEvent$ChangeMarketingPushEvent;", "Ldk/molslinjen/domain/analytics/AnalyticsEvent$ChangePushEvent;", "Ldk/molslinjen/domain/analytics/AnalyticsEvent$ChangeReturnTripEvent;", "Ldk/molslinjen/domain/analytics/AnalyticsEvent$ChangeRouteDirectionEvent;", "Ldk/molslinjen/domain/analytics/AnalyticsEvent$ChangeRouteEvent;", "Ldk/molslinjen/domain/analytics/AnalyticsEvent$ChangeTransportationEvent;", "Ldk/molslinjen/domain/analytics/AnalyticsEvent$ChangedProfileInfoEvent;", "Ldk/molslinjen/domain/analytics/AnalyticsEvent$CreateAccount;", "Ldk/molslinjen/domain/analytics/AnalyticsEvent$Login;", "Ldk/molslinjen/domain/analytics/AnalyticsEvent$Logout;", "Ldk/molslinjen/domain/analytics/AnalyticsEvent$MobilePayEvent;", "Ldk/molslinjen/domain/analytics/AnalyticsEvent$NavigatedBackThroughCheckoutTopBar;", "Ldk/molslinjen/domain/analytics/AnalyticsEvent$OtherPaymentCardWhenHasSavedCardsEvent;", "Ldk/molslinjen/domain/analytics/AnalyticsEvent$PaymentFailed;", "Ldk/molslinjen/domain/analytics/AnalyticsEvent$RemovedSavedCardEvent;", "Ldk/molslinjen/domain/analytics/AnalyticsEvent$SaleOnBoardNoMenuAvailable;", "Ldk/molslinjen/domain/analytics/AnalyticsEvent$SaleOnBoardOrderError;", "Ldk/molslinjen/domain/analytics/AnalyticsEvent$SelectTicketTypeEvent;", "Ldk/molslinjen/domain/analytics/AnalyticsEvent$ShowDirectionsEvent;", "Ldk/molslinjen/domain/analytics/AnalyticsEvent$ShownFaqEvent;", "Ldk/molslinjen/domain/analytics/AnalyticsEvent$SplitTestExperimentViewed;", "Ldk/molslinjen/domain/analytics/AnalyticsEvent$StartAddReturnTripFromSummaryEvent;", "Ldk/molslinjen/domain/analytics/AnalyticsEvent$StartEditTicketEvent;", "Ldk/molslinjen/domain/analytics/AnalyticsEvent$StopAddingReturnTripEvent;", "Ldk/molslinjen/domain/analytics/AnalyticsEvent$TimeoutEvent;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class AnalyticsEvent {

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"Ldk/molslinjen/domain/analytics/AnalyticsEvent$AddCommuterAgreements;", "Ldk/molslinjen/domain/analytics/AnalyticsEvent;", "<init>", "()V", "track", BuildConfig.FLAVOR, "firebaseAnalytics", "Lcom/google/firebase/analytics/FirebaseAnalytics;", "facebookTracker", "Ldk/molslinjen/domain/analytics/IFacebookTracker;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class AddCommuterAgreements extends AnalyticsEvent {
        public static final AddCommuterAgreements INSTANCE = new AddCommuterAgreements();

        private AddCommuterAgreements() {
            super(null);
        }

        @Override // dk.molslinjen.domain.analytics.AnalyticsEvent
        public void track(FirebaseAnalytics firebaseAnalytics, IFacebookTracker facebookTracker) {
            Intrinsics.checkNotNullParameter(firebaseAnalytics, "firebaseAnalytics");
            Intrinsics.checkNotNullParameter(facebookTracker, "facebookTracker");
            firebaseAnalytics.logEvent("commuter_find_agreement", null);
            facebookTracker.trackFindTicket(BuildConfig.FLAVOR, "commuter_find_agreement");
        }
    }

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0017¨\u0006\u0018"}, d2 = {"Ldk/molslinjen/domain/analytics/AnalyticsEvent$AddExistingMultiRideCard;", "Ldk/molslinjen/domain/analytics/AnalyticsEvent;", BuildConfig.FLAVOR, "cardNumber", "<init>", "(Ljava/lang/String;)V", "Lcom/google/firebase/analytics/FirebaseAnalytics;", "firebaseAnalytics", "Ldk/molslinjen/domain/analytics/IFacebookTracker;", "facebookTracker", BuildConfig.FLAVOR, "track", "(Lcom/google/firebase/analytics/FirebaseAnalytics;Ldk/molslinjen/domain/analytics/IFacebookTracker;)V", "toString", "()Ljava/lang/String;", BuildConfig.FLAVOR, "hashCode", "()I", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final /* data */ class AddExistingMultiRideCard extends AnalyticsEvent {
        private final String cardNumber;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AddExistingMultiRideCard(String cardNumber) {
            super(null);
            Intrinsics.checkNotNullParameter(cardNumber, "cardNumber");
            this.cardNumber = cardNumber;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof AddExistingMultiRideCard) && Intrinsics.areEqual(this.cardNumber, ((AddExistingMultiRideCard) other).cardNumber);
        }

        public int hashCode() {
            return this.cardNumber.hashCode();
        }

        public String toString() {
            return "AddExistingMultiRideCard(cardNumber=" + this.cardNumber + ")";
        }

        @Override // dk.molslinjen.domain.analytics.AnalyticsEvent
        public void track(FirebaseAnalytics firebaseAnalytics, IFacebookTracker facebookTracker) {
            Intrinsics.checkNotNullParameter(firebaseAnalytics, "firebaseAnalytics");
            Intrinsics.checkNotNullParameter(facebookTracker, "facebookTracker");
            firebaseAnalytics.logEvent("add_travel_pass", BundleKt.bundleOf(TuplesKt.to("transaction_id", this.cardNumber), TuplesKt.to("affiliation", "app")));
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0006\u0010\f\u001a\u00020\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Ldk/molslinjen/domain/analytics/AnalyticsEvent$BookingInitiated;", "Ldk/molslinjen/domain/analytics/AnalyticsEvent;", "<init>", "()V", "hasTrackedBookingInitiated", BuildConfig.FLAVOR, "track", BuildConfig.FLAVOR, "firebaseAnalytics", "Lcom/google/firebase/analytics/FirebaseAnalytics;", "facebookTracker", "Ldk/molslinjen/domain/analytics/IFacebookTracker;", "reset", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class BookingInitiated extends AnalyticsEvent {
        public static final BookingInitiated INSTANCE = new BookingInitiated();
        private static boolean hasTrackedBookingInitiated;

        private BookingInitiated() {
            super(null);
        }

        public final void reset() {
            hasTrackedBookingInitiated = false;
        }

        @Override // dk.molslinjen.domain.analytics.AnalyticsEvent
        public void track(FirebaseAnalytics firebaseAnalytics, IFacebookTracker facebookTracker) {
            Intrinsics.checkNotNullParameter(firebaseAnalytics, "firebaseAnalytics");
            Intrinsics.checkNotNullParameter(facebookTracker, "facebookTracker");
            if (hasTrackedBookingInitiated) {
                return;
            }
            firebaseAnalytics.logEvent("booking_initiated", null);
            hasTrackedBookingInitiated = true;
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"Ldk/molslinjen/domain/analytics/AnalyticsEvent$CallSupportEvent;", "Ldk/molslinjen/domain/analytics/AnalyticsEvent;", "<init>", "()V", "track", BuildConfig.FLAVOR, "firebaseAnalytics", "Lcom/google/firebase/analytics/FirebaseAnalytics;", "facebookTracker", "Ldk/molslinjen/domain/analytics/IFacebookTracker;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class CallSupportEvent extends AnalyticsEvent {
        public static final CallSupportEvent INSTANCE = new CallSupportEvent();

        private CallSupportEvent() {
            super(null);
        }

        @Override // dk.molslinjen.domain.analytics.AnalyticsEvent
        public void track(FirebaseAnalytics firebaseAnalytics, IFacebookTracker facebookTracker) {
            Intrinsics.checkNotNullParameter(firebaseAnalytics, "firebaseAnalytics");
            Intrinsics.checkNotNullParameter(facebookTracker, "facebookTracker");
            firebaseAnalytics.logEvent("call_us", null);
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"Ldk/molslinjen/domain/analytics/AnalyticsEvent$CancelledEditTicketEvent;", "Ldk/molslinjen/domain/analytics/AnalyticsEvent;", "<init>", "()V", "track", BuildConfig.FLAVOR, "firebaseAnalytics", "Lcom/google/firebase/analytics/FirebaseAnalytics;", "facebookTracker", "Ldk/molslinjen/domain/analytics/IFacebookTracker;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class CancelledEditTicketEvent extends AnalyticsEvent {
        public static final CancelledEditTicketEvent INSTANCE = new CancelledEditTicketEvent();

        private CancelledEditTicketEvent() {
            super(null);
        }

        @Override // dk.molslinjen.domain.analytics.AnalyticsEvent
        public void track(FirebaseAnalytics firebaseAnalytics, IFacebookTracker facebookTracker) {
            Intrinsics.checkNotNullParameter(firebaseAnalytics, "firebaseAnalytics");
            Intrinsics.checkNotNullParameter(facebookTracker, "facebookTracker");
            firebaseAnalytics.logEvent("cancel_rebooking", null);
        }
    }

    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0018¨\u0006\u0019"}, d2 = {"Ldk/molslinjen/domain/analytics/AnalyticsEvent$ChangeDateEvent;", "Ldk/molslinjen/domain/analytics/AnalyticsEvent;", "Lorg/threeten/bp/LocalDate;", "date", "<init>", "(Lorg/threeten/bp/LocalDate;)V", "Lcom/google/firebase/analytics/FirebaseAnalytics;", "firebaseAnalytics", "Ldk/molslinjen/domain/analytics/IFacebookTracker;", "facebookTracker", BuildConfig.FLAVOR, "track", "(Lcom/google/firebase/analytics/FirebaseAnalytics;Ldk/molslinjen/domain/analytics/IFacebookTracker;)V", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", BuildConfig.FLAVOR, "hashCode", "()I", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "equals", "(Ljava/lang/Object;)Z", "Lorg/threeten/bp/LocalDate;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final /* data */ class ChangeDateEvent extends AnalyticsEvent {
        private final LocalDate date;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ChangeDateEvent(LocalDate date) {
            super(null);
            Intrinsics.checkNotNullParameter(date, "date");
            this.date = date;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof ChangeDateEvent) && Intrinsics.areEqual(this.date, ((ChangeDateEvent) other).date);
        }

        public int hashCode() {
            return this.date.hashCode();
        }

        public String toString() {
            return "ChangeDateEvent(date=" + this.date + ")";
        }

        @Override // dk.molslinjen.domain.analytics.AnalyticsEvent
        public void track(FirebaseAnalytics firebaseAnalytics, IFacebookTracker facebookTracker) {
            Intrinsics.checkNotNullParameter(firebaseAnalytics, "firebaseAnalytics");
            Intrinsics.checkNotNullParameter(facebookTracker, "facebookTracker");
            String format = LocalDateTimeExtensionsKt.toFormat(this.date, "yyyy-MM-dd");
            long between = ChronoUnit.DAYS.between(LocalDate.now(), this.date);
            firebaseAnalytics.logEvent("select_departure_date", BundleKt.bundleOf(TuplesKt.to("departure_date", format), TuplesKt.to("departure_days_from_now", Long.valueOf(between))));
            facebookTracker.trackFindTicket("departure_date=" + format + "&departure_days_from_now=" + between, "select_departure_date");
        }
    }

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\u000e\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0018\u001a\u00020\u00022\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u001aR\u0014\u0010\u0004\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u001aR\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u001aR\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u001a¨\u0006\u001b"}, d2 = {"Ldk/molslinjen/domain/analytics/AnalyticsEvent$ChangeLocationPermissionEvent;", "Ldk/molslinjen/domain/analytics/AnalyticsEvent;", BuildConfig.FLAVOR, "authorized", "fromIntro", "fromProfile", "fromDirections", "<init>", "(ZZZZ)V", "Lcom/google/firebase/analytics/FirebaseAnalytics;", "firebaseAnalytics", "Ldk/molslinjen/domain/analytics/IFacebookTracker;", "facebookTracker", BuildConfig.FLAVOR, "track", "(Lcom/google/firebase/analytics/FirebaseAnalytics;Ldk/molslinjen/domain/analytics/IFacebookTracker;)V", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", BuildConfig.FLAVOR, "hashCode", "()I", BuildConfig.FLAVOR, "other", "equals", "(Ljava/lang/Object;)Z", "Z", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final /* data */ class ChangeLocationPermissionEvent extends AnalyticsEvent {
        private final boolean authorized;
        private final boolean fromDirections;
        private final boolean fromIntro;
        private final boolean fromProfile;

        public /* synthetic */ ChangeLocationPermissionEvent(boolean z5, boolean z6, boolean z7, boolean z8, int i5, DefaultConstructorMarker defaultConstructorMarker) {
            this(z5, (i5 & 2) != 0 ? false : z6, (i5 & 4) != 0 ? false : z7, (i5 & 8) != 0 ? false : z8);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ChangeLocationPermissionEvent)) {
                return false;
            }
            ChangeLocationPermissionEvent changeLocationPermissionEvent = (ChangeLocationPermissionEvent) other;
            return this.authorized == changeLocationPermissionEvent.authorized && this.fromIntro == changeLocationPermissionEvent.fromIntro && this.fromProfile == changeLocationPermissionEvent.fromProfile && this.fromDirections == changeLocationPermissionEvent.fromDirections;
        }

        public int hashCode() {
            return (((((Boolean.hashCode(this.authorized) * 31) + Boolean.hashCode(this.fromIntro)) * 31) + Boolean.hashCode(this.fromProfile)) * 31) + Boolean.hashCode(this.fromDirections);
        }

        public String toString() {
            return "ChangeLocationPermissionEvent(authorized=" + this.authorized + ", fromIntro=" + this.fromIntro + ", fromProfile=" + this.fromProfile + ", fromDirections=" + this.fromDirections + ")";
        }

        @Override // dk.molslinjen.domain.analytics.AnalyticsEvent
        public void track(FirebaseAnalytics firebaseAnalytics, IFacebookTracker facebookTracker) {
            String str;
            Intrinsics.checkNotNullParameter(firebaseAnalytics, "firebaseAnalytics");
            Intrinsics.checkNotNullParameter(facebookTracker, "facebookTracker");
            Pair pair = TuplesKt.to("change_to", this.authorized ? "allow" : "disallow");
            if (this.fromIntro) {
                str = "intro";
            } else if (this.fromProfile) {
                str = "profile";
            } else {
                if (!this.fromDirections) {
                    throw new Exception("Invalid change location tracking location arguments");
                }
                str = "show directions";
            }
            firebaseAnalytics.logEvent("change_location_services", BundleKt.bundleOf(pair, TuplesKt.to("change_location", str)));
        }

        public ChangeLocationPermissionEvent(boolean z5, boolean z6, boolean z7, boolean z8) {
            super(null);
            this.authorized = z5;
            this.fromIntro = z6;
            this.fromProfile = z7;
            this.fromDirections = z8;
        }
    }

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0016\u001a\u00020\u00022\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0018R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0019¨\u0006\u001a"}, d2 = {"Ldk/molslinjen/domain/analytics/AnalyticsEvent$ChangeMarketingPushEvent;", "Ldk/molslinjen/domain/analytics/AnalyticsEvent;", BuildConfig.FLAVOR, "isPushEnabled", BuildConfig.FLAVOR, "changeLocation", "<init>", "(ZLjava/lang/String;)V", "Lcom/google/firebase/analytics/FirebaseAnalytics;", "firebaseAnalytics", "Ldk/molslinjen/domain/analytics/IFacebookTracker;", "facebookTracker", BuildConfig.FLAVOR, "track", "(Lcom/google/firebase/analytics/FirebaseAnalytics;Ldk/molslinjen/domain/analytics/IFacebookTracker;)V", "toString", "()Ljava/lang/String;", BuildConfig.FLAVOR, "hashCode", "()I", BuildConfig.FLAVOR, "other", "equals", "(Ljava/lang/Object;)Z", "Z", "Ljava/lang/String;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final /* data */ class ChangeMarketingPushEvent extends AnalyticsEvent {
        private final String changeLocation;
        private final boolean isPushEnabled;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ChangeMarketingPushEvent(boolean z5, String changeLocation) {
            super(null);
            Intrinsics.checkNotNullParameter(changeLocation, "changeLocation");
            this.isPushEnabled = z5;
            this.changeLocation = changeLocation;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ChangeMarketingPushEvent)) {
                return false;
            }
            ChangeMarketingPushEvent changeMarketingPushEvent = (ChangeMarketingPushEvent) other;
            return this.isPushEnabled == changeMarketingPushEvent.isPushEnabled && Intrinsics.areEqual(this.changeLocation, changeMarketingPushEvent.changeLocation);
        }

        public int hashCode() {
            return (Boolean.hashCode(this.isPushEnabled) * 31) + this.changeLocation.hashCode();
        }

        public String toString() {
            return "ChangeMarketingPushEvent(isPushEnabled=" + this.isPushEnabled + ", changeLocation=" + this.changeLocation + ")";
        }

        @Override // dk.molslinjen.domain.analytics.AnalyticsEvent
        public void track(FirebaseAnalytics firebaseAnalytics, IFacebookTracker facebookTracker) {
            Intrinsics.checkNotNullParameter(firebaseAnalytics, "firebaseAnalytics");
            Intrinsics.checkNotNullParameter(facebookTracker, "facebookTracker");
            firebaseAnalytics.logEvent("change_marketing_push_messages", BundleKt.bundleOf(TuplesKt.to("change_to", this.isPushEnabled ? "allow" : "disallow"), TuplesKt.to("change_location", this.changeLocation)));
        }
    }

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0016\u001a\u00020\u00022\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0018R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0019¨\u0006\u001a"}, d2 = {"Ldk/molslinjen/domain/analytics/AnalyticsEvent$ChangePushEvent;", "Ldk/molslinjen/domain/analytics/AnalyticsEvent;", BuildConfig.FLAVOR, "isPushEnabled", BuildConfig.FLAVOR, "changeLocation", "<init>", "(ZLjava/lang/String;)V", "Lcom/google/firebase/analytics/FirebaseAnalytics;", "firebaseAnalytics", "Ldk/molslinjen/domain/analytics/IFacebookTracker;", "facebookTracker", BuildConfig.FLAVOR, "track", "(Lcom/google/firebase/analytics/FirebaseAnalytics;Ldk/molslinjen/domain/analytics/IFacebookTracker;)V", "toString", "()Ljava/lang/String;", BuildConfig.FLAVOR, "hashCode", "()I", BuildConfig.FLAVOR, "other", "equals", "(Ljava/lang/Object;)Z", "Z", "Ljava/lang/String;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final /* data */ class ChangePushEvent extends AnalyticsEvent {
        private final String changeLocation;
        private final boolean isPushEnabled;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ChangePushEvent(boolean z5, String changeLocation) {
            super(null);
            Intrinsics.checkNotNullParameter(changeLocation, "changeLocation");
            this.isPushEnabled = z5;
            this.changeLocation = changeLocation;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ChangePushEvent)) {
                return false;
            }
            ChangePushEvent changePushEvent = (ChangePushEvent) other;
            return this.isPushEnabled == changePushEvent.isPushEnabled && Intrinsics.areEqual(this.changeLocation, changePushEvent.changeLocation);
        }

        public int hashCode() {
            return (Boolean.hashCode(this.isPushEnabled) * 31) + this.changeLocation.hashCode();
        }

        public String toString() {
            return "ChangePushEvent(isPushEnabled=" + this.isPushEnabled + ", changeLocation=" + this.changeLocation + ")";
        }

        @Override // dk.molslinjen.domain.analytics.AnalyticsEvent
        public void track(FirebaseAnalytics firebaseAnalytics, IFacebookTracker facebookTracker) {
            Intrinsics.checkNotNullParameter(firebaseAnalytics, "firebaseAnalytics");
            Intrinsics.checkNotNullParameter(facebookTracker, "facebookTracker");
            firebaseAnalytics.logEvent("change_push_messages", BundleKt.bundleOf(TuplesKt.to("change_to", this.isPushEnabled ? "allow" : "disallow"), TuplesKt.to("change_location", this.changeLocation)));
        }
    }

    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0018¨\u0006\u0019"}, d2 = {"Ldk/molslinjen/domain/analytics/AnalyticsEvent$ChangeReturnTripEvent;", "Ldk/molslinjen/domain/analytics/AnalyticsEvent;", "Ldk/molslinjen/domain/model/booking/BookingType;", "bookingType", "<init>", "(Ldk/molslinjen/domain/model/booking/BookingType;)V", "Lcom/google/firebase/analytics/FirebaseAnalytics;", "firebaseAnalytics", "Ldk/molslinjen/domain/analytics/IFacebookTracker;", "facebookTracker", BuildConfig.FLAVOR, "track", "(Lcom/google/firebase/analytics/FirebaseAnalytics;Ldk/molslinjen/domain/analytics/IFacebookTracker;)V", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", BuildConfig.FLAVOR, "hashCode", "()I", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "equals", "(Ljava/lang/Object;)Z", "Ldk/molslinjen/domain/model/booking/BookingType;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final /* data */ class ChangeReturnTripEvent extends AnalyticsEvent {
        private final BookingType bookingType;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ChangeReturnTripEvent(BookingType bookingType) {
            super(null);
            Intrinsics.checkNotNullParameter(bookingType, "bookingType");
            this.bookingType = bookingType;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof ChangeReturnTripEvent) && this.bookingType == ((ChangeReturnTripEvent) other).bookingType;
        }

        public int hashCode() {
            return this.bookingType.hashCode();
        }

        public String toString() {
            return "ChangeReturnTripEvent(bookingType=" + this.bookingType + ")";
        }

        @Override // dk.molslinjen.domain.analytics.AnalyticsEvent
        public void track(FirebaseAnalytics firebaseAnalytics, IFacebookTracker facebookTracker) {
            Intrinsics.checkNotNullParameter(firebaseAnalytics, "firebaseAnalytics");
            Intrinsics.checkNotNullParameter(facebookTracker, "facebookTracker");
            String str = this.bookingType == BookingType.TwoWay ? "return" : "single";
            firebaseAnalytics.logEvent("change_single_return", BundleKt.bundleOf(TuplesKt.to("single_return", str)));
            facebookTracker.trackFindTicket("single_return=" + str, "change_single_return");
            BookingInitiated.INSTANCE.track(firebaseAnalytics, facebookTracker);
        }
    }

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0018R\u0014\u0010\u0004\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0018¨\u0006\u0019"}, d2 = {"Ldk/molslinjen/domain/analytics/AnalyticsEvent$ChangeRouteDirectionEvent;", "Ldk/molslinjen/domain/analytics/AnalyticsEvent;", BuildConfig.FLAVOR, "previousFromHarborName", "previousToHarborName", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "Lcom/google/firebase/analytics/FirebaseAnalytics;", "firebaseAnalytics", "Ldk/molslinjen/domain/analytics/IFacebookTracker;", "facebookTracker", BuildConfig.FLAVOR, "track", "(Lcom/google/firebase/analytics/FirebaseAnalytics;Ldk/molslinjen/domain/analytics/IFacebookTracker;)V", "toString", "()Ljava/lang/String;", BuildConfig.FLAVOR, "hashCode", "()I", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final /* data */ class ChangeRouteDirectionEvent extends AnalyticsEvent {
        private final String previousFromHarborName;
        private final String previousToHarborName;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ChangeRouteDirectionEvent(String previousFromHarborName, String previousToHarborName) {
            super(null);
            Intrinsics.checkNotNullParameter(previousFromHarborName, "previousFromHarborName");
            Intrinsics.checkNotNullParameter(previousToHarborName, "previousToHarborName");
            this.previousFromHarborName = previousFromHarborName;
            this.previousToHarborName = previousToHarborName;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ChangeRouteDirectionEvent)) {
                return false;
            }
            ChangeRouteDirectionEvent changeRouteDirectionEvent = (ChangeRouteDirectionEvent) other;
            return Intrinsics.areEqual(this.previousFromHarborName, changeRouteDirectionEvent.previousFromHarborName) && Intrinsics.areEqual(this.previousToHarborName, changeRouteDirectionEvent.previousToHarborName);
        }

        public int hashCode() {
            return (this.previousFromHarborName.hashCode() * 31) + this.previousToHarborName.hashCode();
        }

        public String toString() {
            return "ChangeRouteDirectionEvent(previousFromHarborName=" + this.previousFromHarborName + ", previousToHarborName=" + this.previousToHarborName + ")";
        }

        @Override // dk.molslinjen.domain.analytics.AnalyticsEvent
        public void track(FirebaseAnalytics firebaseAnalytics, IFacebookTracker facebookTracker) {
            Intrinsics.checkNotNullParameter(firebaseAnalytics, "firebaseAnalytics");
            Intrinsics.checkNotNullParameter(facebookTracker, "facebookTracker");
            firebaseAnalytics.logEvent("change_direction", BundleKt.bundleOf(TuplesKt.to("change_origin_from", this.previousFromHarborName), TuplesKt.to("change_destination_from", this.previousToHarborName), TuplesKt.to("change_origin_to", this.previousToHarborName), TuplesKt.to("change_destination_to", this.previousFromHarborName)));
            facebookTracker.trackFindTicket("from=" + this.previousToHarborName + "&to=" + this.previousFromHarborName, "change_direction");
            BookingInitiated.INSTANCE.track(firebaseAnalytics, facebookTracker);
        }
    }

    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0017\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018R\u0016\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0019R\u0014\u0010\u0004\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0019¨\u0006\u001a"}, d2 = {"Ldk/molslinjen/domain/analytics/AnalyticsEvent$ChangeRouteEvent;", "Ldk/molslinjen/domain/analytics/AnalyticsEvent;", "Ldk/molslinjen/domain/model/config/Route;", "previous", "current", "<init>", "(Ldk/molslinjen/domain/model/config/Route;Ldk/molslinjen/domain/model/config/Route;)V", "Lcom/google/firebase/analytics/FirebaseAnalytics;", "firebaseAnalytics", "Ldk/molslinjen/domain/analytics/IFacebookTracker;", "facebookTracker", BuildConfig.FLAVOR, "track", "(Lcom/google/firebase/analytics/FirebaseAnalytics;Ldk/molslinjen/domain/analytics/IFacebookTracker;)V", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", BuildConfig.FLAVOR, "hashCode", "()I", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "equals", "(Ljava/lang/Object;)Z", "Ldk/molslinjen/domain/model/config/Route;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final /* data */ class ChangeRouteEvent extends AnalyticsEvent {
        private final Route current;
        private final Route previous;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ChangeRouteEvent(Route route, Route current) {
            super(null);
            Intrinsics.checkNotNullParameter(current, "current");
            this.previous = route;
            this.current = current;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ChangeRouteEvent)) {
                return false;
            }
            ChangeRouteEvent changeRouteEvent = (ChangeRouteEvent) other;
            return Intrinsics.areEqual(this.previous, changeRouteEvent.previous) && Intrinsics.areEqual(this.current, changeRouteEvent.current);
        }

        public int hashCode() {
            Route route = this.previous;
            return ((route == null ? 0 : route.hashCode()) * 31) + this.current.hashCode();
        }

        public String toString() {
            return "ChangeRouteEvent(previous=" + this.previous + ", current=" + this.current + ")";
        }

        @Override // dk.molslinjen.domain.analytics.AnalyticsEvent
        public void track(FirebaseAnalytics firebaseAnalytics, IFacebookTracker facebookTracker) {
            Intrinsics.checkNotNullParameter(firebaseAnalytics, "firebaseAnalytics");
            Intrinsics.checkNotNullParameter(facebookTracker, "facebookTracker");
            String str = this.current.getOutRoute().getDepartureHarbor().getName() + "-" + this.current.getOutRoute().getArrivalHarbor().getName();
            Locale locale = Locale.ROOT;
            String lowerCase = str.toLowerCase(locale);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            Bundle bundleOf = BundleKt.bundleOf(TuplesKt.to("change_route_to_route", lowerCase));
            Route route = this.previous;
            if (route != null) {
                String lowerCase2 = (route.getOutRoute().getDepartureHarbor().getName() + "-" + this.previous.getOutRoute().getArrivalHarbor().getName()).toLowerCase(locale);
                Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
                bundleOf.putString("change_line_from_route", lowerCase2);
            }
            firebaseAnalytics.logEvent("change_line", bundleOf);
            facebookTracker.trackFindTicket("from=" + this.current.getOutRoute().getDepartureHarbor().getName() + "&to=" + this.current.getOutRoute().getArrivalHarbor().getName(), "change_line");
            BookingInitiated.INSTANCE.track(firebaseAnalytics, facebookTracker);
        }
    }

    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001B#\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\u000e\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\u0013HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0019\u001a\u00020\u00182\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016HÖ\u0003¢\u0006\u0004\b\u0019\u0010\u001aR\u0016\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u001bR\u0014\u0010\u0004\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u001bR\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u001c¨\u0006\u001d"}, d2 = {"Ldk/molslinjen/domain/analytics/AnalyticsEvent$ChangeTransportationEvent;", "Ldk/molslinjen/domain/analytics/AnalyticsEvent;", "Ldk/molslinjen/domain/model/config/Transportation;", "previous", "current", "Ldk/molslinjen/domain/model/booking/PassengerInfo;", "passengerInfo", "<init>", "(Ldk/molslinjen/domain/model/config/Transportation;Ldk/molslinjen/domain/model/config/Transportation;Ldk/molslinjen/domain/model/booking/PassengerInfo;)V", "Lcom/google/firebase/analytics/FirebaseAnalytics;", "firebaseAnalytics", "Ldk/molslinjen/domain/analytics/IFacebookTracker;", "facebookTracker", BuildConfig.FLAVOR, "track", "(Lcom/google/firebase/analytics/FirebaseAnalytics;Ldk/molslinjen/domain/analytics/IFacebookTracker;)V", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", BuildConfig.FLAVOR, "hashCode", "()I", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "equals", "(Ljava/lang/Object;)Z", "Ldk/molslinjen/domain/model/config/Transportation;", "Ldk/molslinjen/domain/model/booking/PassengerInfo;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final /* data */ class ChangeTransportationEvent extends AnalyticsEvent {
        private final Transportation current;
        private final PassengerInfo passengerInfo;
        private final Transportation previous;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ChangeTransportationEvent(Transportation transportation, Transportation current, PassengerInfo passengerInfo) {
            super(null);
            Intrinsics.checkNotNullParameter(current, "current");
            this.previous = transportation;
            this.current = current;
            this.passengerInfo = passengerInfo;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ChangeTransportationEvent)) {
                return false;
            }
            ChangeTransportationEvent changeTransportationEvent = (ChangeTransportationEvent) other;
            return Intrinsics.areEqual(this.previous, changeTransportationEvent.previous) && Intrinsics.areEqual(this.current, changeTransportationEvent.current) && Intrinsics.areEqual(this.passengerInfo, changeTransportationEvent.passengerInfo);
        }

        public int hashCode() {
            Transportation transportation = this.previous;
            int hashCode = (((transportation == null ? 0 : transportation.hashCode()) * 31) + this.current.hashCode()) * 31;
            PassengerInfo passengerInfo = this.passengerInfo;
            return hashCode + (passengerInfo != null ? passengerInfo.hashCode() : 0);
        }

        public String toString() {
            return "ChangeTransportationEvent(previous=" + this.previous + ", current=" + this.current + ", passengerInfo=" + this.passengerInfo + ")";
        }

        @Override // dk.molslinjen.domain.analytics.AnalyticsEvent
        public void track(FirebaseAnalytics firebaseAnalytics, IFacebookTracker facebookTracker) {
            PassengerInfo passengerInfo;
            Intrinsics.checkNotNullParameter(firebaseAnalytics, "firebaseAnalytics");
            Intrinsics.checkNotNullParameter(facebookTracker, "facebookTracker");
            AnalyticsTracker.Companion companion = AnalyticsTracker.INSTANCE;
            String travelType$domain_kombardoProd = companion.getTravelType$domain_kombardoProd(this.previous);
            String travelType$domain_kombardoProd2 = companion.getTravelType$domain_kombardoProd(this.current);
            String str = "from=" + this.previous + "&to=" + this.current;
            Bundle bundleOf = BundleKt.bundleOf(TuplesKt.to("change_from", travelType$domain_kombardoProd), TuplesKt.to("change_to", travelType$domain_kombardoProd2));
            if (this.current.isWalking() && (passengerInfo = this.passengerInfo) != null) {
                bundleOf.putInt("adults", passengerInfo.getAdultCount());
                bundleOf.putInt("children", this.passengerInfo.getChildCount());
                bundleOf.putInt("infants", this.passengerInfo.getInfantCount());
                str = str + "&adults=" + this.passengerInfo.getAdultCount() + "&children=" + this.passengerInfo.getChildCount() + "&infants=" + this.passengerInfo.getInfantCount();
            }
            firebaseAnalytics.logEvent("change_travel_type", bundleOf);
            facebookTracker.trackFindTicket(str, "change_travel_type");
            BookingInitiated.INSTANCE.track(firebaseAnalytics, facebookTracker);
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"Ldk/molslinjen/domain/analytics/AnalyticsEvent$ChangedProfileInfoEvent;", "Ldk/molslinjen/domain/analytics/AnalyticsEvent;", "<init>", "()V", "track", BuildConfig.FLAVOR, "firebaseAnalytics", "Lcom/google/firebase/analytics/FirebaseAnalytics;", "facebookTracker", "Ldk/molslinjen/domain/analytics/IFacebookTracker;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class ChangedProfileInfoEvent extends AnalyticsEvent {
        public static final ChangedProfileInfoEvent INSTANCE = new ChangedProfileInfoEvent();

        private ChangedProfileInfoEvent() {
            super(null);
        }

        @Override // dk.molslinjen.domain.analytics.AnalyticsEvent
        public void track(FirebaseAnalytics firebaseAnalytics, IFacebookTracker facebookTracker) {
            Intrinsics.checkNotNullParameter(firebaseAnalytics, "firebaseAnalytics");
            Intrinsics.checkNotNullParameter(facebookTracker, "facebookTracker");
            firebaseAnalytics.logEvent("update_profile", null);
        }
    }

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0017¨\u0006\u0018"}, d2 = {"Ldk/molslinjen/domain/analytics/AnalyticsEvent$CreateAccount;", "Ldk/molslinjen/domain/analytics/AnalyticsEvent;", BuildConfig.FLAVOR, "originRoute", "<init>", "(Ljava/lang/String;)V", "Lcom/google/firebase/analytics/FirebaseAnalytics;", "firebaseAnalytics", "Ldk/molslinjen/domain/analytics/IFacebookTracker;", "facebookTracker", BuildConfig.FLAVOR, "track", "(Lcom/google/firebase/analytics/FirebaseAnalytics;Ldk/molslinjen/domain/analytics/IFacebookTracker;)V", "toString", "()Ljava/lang/String;", BuildConfig.FLAVOR, "hashCode", "()I", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final /* data */ class CreateAccount extends AnalyticsEvent {
        private final String originRoute;

        public CreateAccount(String str) {
            super(null);
            this.originRoute = str;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof CreateAccount) && Intrinsics.areEqual(this.originRoute, ((CreateAccount) other).originRoute);
        }

        public int hashCode() {
            String str = this.originRoute;
            if (str == null) {
                return 0;
            }
            return str.hashCode();
        }

        public String toString() {
            return "CreateAccount(originRoute=" + this.originRoute + ")";
        }

        @Override // dk.molslinjen.domain.analytics.AnalyticsEvent
        public void track(FirebaseAnalytics firebaseAnalytics, IFacebookTracker facebookTracker) {
            Intrinsics.checkNotNullParameter(firebaseAnalytics, "firebaseAnalytics");
            Intrinsics.checkNotNullParameter(facebookTracker, "facebookTracker");
            Pair pair = TuplesKt.to("method", "email");
            String str = this.originRoute;
            if (str == null) {
                str = "-";
            }
            firebaseAnalytics.logEvent("sign_up", BundleKt.bundleOf(pair, TuplesKt.to("view_name", str)));
        }
    }

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0017¨\u0006\u0018"}, d2 = {"Ldk/molslinjen/domain/analytics/AnalyticsEvent$Login;", "Ldk/molslinjen/domain/analytics/AnalyticsEvent;", BuildConfig.FLAVOR, "screenTrackingKey", "<init>", "(Ljava/lang/String;)V", "Lcom/google/firebase/analytics/FirebaseAnalytics;", "firebaseAnalytics", "Ldk/molslinjen/domain/analytics/IFacebookTracker;", "facebookTracker", BuildConfig.FLAVOR, "track", "(Lcom/google/firebase/analytics/FirebaseAnalytics;Ldk/molslinjen/domain/analytics/IFacebookTracker;)V", "toString", "()Ljava/lang/String;", BuildConfig.FLAVOR, "hashCode", "()I", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final /* data */ class Login extends AnalyticsEvent {
        private final String screenTrackingKey;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Login(String screenTrackingKey) {
            super(null);
            Intrinsics.checkNotNullParameter(screenTrackingKey, "screenTrackingKey");
            this.screenTrackingKey = screenTrackingKey;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Login) && Intrinsics.areEqual(this.screenTrackingKey, ((Login) other).screenTrackingKey);
        }

        public int hashCode() {
            return this.screenTrackingKey.hashCode();
        }

        public String toString() {
            return "Login(screenTrackingKey=" + this.screenTrackingKey + ")";
        }

        @Override // dk.molslinjen.domain.analytics.AnalyticsEvent
        public void track(FirebaseAnalytics firebaseAnalytics, IFacebookTracker facebookTracker) {
            Intrinsics.checkNotNullParameter(firebaseAnalytics, "firebaseAnalytics");
            Intrinsics.checkNotNullParameter(facebookTracker, "facebookTracker");
            firebaseAnalytics.logEvent("login", BundleKt.bundleOf(TuplesKt.to("method", "email"), TuplesKt.to("view_name", this.screenTrackingKey)));
        }
    }

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0017¨\u0006\u0018"}, d2 = {"Ldk/molslinjen/domain/analytics/AnalyticsEvent$Logout;", "Ldk/molslinjen/domain/analytics/AnalyticsEvent;", BuildConfig.FLAVOR, "screenTrackingKey", "<init>", "(Ljava/lang/String;)V", "Lcom/google/firebase/analytics/FirebaseAnalytics;", "firebaseAnalytics", "Ldk/molslinjen/domain/analytics/IFacebookTracker;", "facebookTracker", BuildConfig.FLAVOR, "track", "(Lcom/google/firebase/analytics/FirebaseAnalytics;Ldk/molslinjen/domain/analytics/IFacebookTracker;)V", "toString", "()Ljava/lang/String;", BuildConfig.FLAVOR, "hashCode", "()I", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final /* data */ class Logout extends AnalyticsEvent {
        private final String screenTrackingKey;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Logout(String screenTrackingKey) {
            super(null);
            Intrinsics.checkNotNullParameter(screenTrackingKey, "screenTrackingKey");
            this.screenTrackingKey = screenTrackingKey;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Logout) && Intrinsics.areEqual(this.screenTrackingKey, ((Logout) other).screenTrackingKey);
        }

        public int hashCode() {
            return this.screenTrackingKey.hashCode();
        }

        public String toString() {
            return "Logout(screenTrackingKey=" + this.screenTrackingKey + ")";
        }

        @Override // dk.molslinjen.domain.analytics.AnalyticsEvent
        public void track(FirebaseAnalytics firebaseAnalytics, IFacebookTracker facebookTracker) {
            Intrinsics.checkNotNullParameter(firebaseAnalytics, "firebaseAnalytics");
            Intrinsics.checkNotNullParameter(facebookTracker, "facebookTracker");
            firebaseAnalytics.logEvent("logout", BundleKt.bundleOf(TuplesKt.to("view_name", this.screenTrackingKey)));
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"Ldk/molslinjen/domain/analytics/AnalyticsEvent$MobilePayEvent;", "Ldk/molslinjen/domain/analytics/AnalyticsEvent;", "<init>", "()V", "track", BuildConfig.FLAVOR, "firebaseAnalytics", "Lcom/google/firebase/analytics/FirebaseAnalytics;", "facebookTracker", "Ldk/molslinjen/domain/analytics/IFacebookTracker;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class MobilePayEvent extends AnalyticsEvent {
        public static final MobilePayEvent INSTANCE = new MobilePayEvent();

        private MobilePayEvent() {
            super(null);
        }

        @Override // dk.molslinjen.domain.analytics.AnalyticsEvent
        public void track(FirebaseAnalytics firebaseAnalytics, IFacebookTracker facebookTracker) {
            Intrinsics.checkNotNullParameter(firebaseAnalytics, "firebaseAnalytics");
            Intrinsics.checkNotNullParameter(facebookTracker, "facebookTracker");
            firebaseAnalytics.logEvent("use_mobile_pay", null);
        }
    }

    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001b"}, d2 = {"Ldk/molslinjen/domain/analytics/AnalyticsEvent$NavigatedBackThroughCheckoutTopBar;", "Ldk/molslinjen/domain/analytics/AnalyticsEvent;", "Ldk/molslinjen/domain/model/booking/TicketSection;", "section", "<init>", "(Ldk/molslinjen/domain/model/booking/TicketSection;)V", "Lcom/google/firebase/analytics/FirebaseAnalytics;", "firebaseAnalytics", "Ldk/molslinjen/domain/analytics/IFacebookTracker;", "facebookTracker", BuildConfig.FLAVOR, "track", "(Lcom/google/firebase/analytics/FirebaseAnalytics;Ldk/molslinjen/domain/analytics/IFacebookTracker;)V", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", BuildConfig.FLAVOR, "hashCode", "()I", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "equals", "(Ljava/lang/Object;)Z", "Ldk/molslinjen/domain/model/booking/TicketSection;", "getSection", "()Ldk/molslinjen/domain/model/booking/TicketSection;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final /* data */ class NavigatedBackThroughCheckoutTopBar extends AnalyticsEvent {
        private final TicketSection section;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public NavigatedBackThroughCheckoutTopBar(TicketSection section) {
            super(null);
            Intrinsics.checkNotNullParameter(section, "section");
            this.section = section;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof NavigatedBackThroughCheckoutTopBar) && this.section == ((NavigatedBackThroughCheckoutTopBar) other).section;
        }

        public int hashCode() {
            return this.section.hashCode();
        }

        public String toString() {
            return "NavigatedBackThroughCheckoutTopBar(section=" + this.section + ")";
        }

        @Override // dk.molslinjen.domain.analytics.AnalyticsEvent
        public void track(FirebaseAnalytics firebaseAnalytics, IFacebookTracker facebookTracker) {
            Intrinsics.checkNotNullParameter(firebaseAnalytics, "firebaseAnalytics");
            Intrinsics.checkNotNullParameter(facebookTracker, "facebookTracker");
            firebaseAnalytics.logEvent("bookingflow_backtrack", BundleKt.bundleOf(TuplesKt.to("to_section", this.section.name())));
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"Ldk/molslinjen/domain/analytics/AnalyticsEvent$OtherPaymentCardWhenHasSavedCardsEvent;", "Ldk/molslinjen/domain/analytics/AnalyticsEvent;", "<init>", "()V", "track", BuildConfig.FLAVOR, "firebaseAnalytics", "Lcom/google/firebase/analytics/FirebaseAnalytics;", "facebookTracker", "Ldk/molslinjen/domain/analytics/IFacebookTracker;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class OtherPaymentCardWhenHasSavedCardsEvent extends AnalyticsEvent {
        public static final OtherPaymentCardWhenHasSavedCardsEvent INSTANCE = new OtherPaymentCardWhenHasSavedCardsEvent();

        private OtherPaymentCardWhenHasSavedCardsEvent() {
            super(null);
        }

        @Override // dk.molslinjen.domain.analytics.AnalyticsEvent
        public void track(FirebaseAnalytics firebaseAnalytics, IFacebookTracker facebookTracker) {
            Intrinsics.checkNotNullParameter(firebaseAnalytics, "firebaseAnalytics");
            Intrinsics.checkNotNullParameter(facebookTracker, "facebookTracker");
            firebaseAnalytics.logEvent("use_other_payment_card_than_saved", null);
        }
    }

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\u000e\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019R\u0016\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u001a¨\u0006\u001b"}, d2 = {"Ldk/molslinjen/domain/analytics/AnalyticsEvent$PaymentFailed;", "Ldk/molslinjen/domain/analytics/AnalyticsEvent;", BuildConfig.FLAVOR, "englishMessage", "<init>", "(Ljava/lang/String;)V", "str", "ensureMaxLength", "(Ljava/lang/String;)Ljava/lang/String;", "Lcom/google/firebase/analytics/FirebaseAnalytics;", "firebaseAnalytics", "Ldk/molslinjen/domain/analytics/IFacebookTracker;", "facebookTracker", BuildConfig.FLAVOR, "track", "(Lcom/google/firebase/analytics/FirebaseAnalytics;Ldk/molslinjen/domain/analytics/IFacebookTracker;)V", "toString", "()Ljava/lang/String;", BuildConfig.FLAVOR, "hashCode", "()I", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final /* data */ class PaymentFailed extends AnalyticsEvent {
        private final String englishMessage;

        public PaymentFailed(String str) {
            super(null);
            this.englishMessage = str;
        }

        private final String ensureMaxLength(String str) {
            return str.length() > 100 ? StringsKt.dropLast(str, str.length() - 100) : str;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof PaymentFailed) && Intrinsics.areEqual(this.englishMessage, ((PaymentFailed) other).englishMessage);
        }

        public int hashCode() {
            String str = this.englishMessage;
            if (str == null) {
                return 0;
            }
            return str.hashCode();
        }

        public String toString() {
            return "PaymentFailed(englishMessage=" + this.englishMessage + ")";
        }

        @Override // dk.molslinjen.domain.analytics.AnalyticsEvent
        public void track(FirebaseAnalytics firebaseAnalytics, IFacebookTracker facebookTracker) {
            Intrinsics.checkNotNullParameter(firebaseAnalytics, "firebaseAnalytics");
            Intrinsics.checkNotNullParameter(facebookTracker, "facebookTracker");
            Pair pair = TuplesKt.to("anti_conversion_id", "5");
            Pair pair2 = TuplesKt.to("anti_conversion_name", "payment error");
            String str = this.englishMessage;
            if (str == null) {
                str = "-";
            }
            firebaseAnalytics.logEvent("anti_conversion", BundleKt.bundleOf(pair, pair2, TuplesKt.to("anti_conversion_message", ensureMaxLength(str)), TuplesKt.to("anti_conversion_category", "checkout")));
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"Ldk/molslinjen/domain/analytics/AnalyticsEvent$RemovedSavedCardEvent;", "Ldk/molslinjen/domain/analytics/AnalyticsEvent;", "<init>", "()V", "track", BuildConfig.FLAVOR, "firebaseAnalytics", "Lcom/google/firebase/analytics/FirebaseAnalytics;", "facebookTracker", "Ldk/molslinjen/domain/analytics/IFacebookTracker;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class RemovedSavedCardEvent extends AnalyticsEvent {
        public static final RemovedSavedCardEvent INSTANCE = new RemovedSavedCardEvent();

        private RemovedSavedCardEvent() {
            super(null);
        }

        @Override // dk.molslinjen.domain.analytics.AnalyticsEvent
        public void track(FirebaseAnalytics firebaseAnalytics, IFacebookTracker facebookTracker) {
            Intrinsics.checkNotNullParameter(firebaseAnalytics, "firebaseAnalytics");
            Intrinsics.checkNotNullParameter(facebookTracker, "facebookTracker");
            firebaseAnalytics.logEvent("delete_saved_credit_card", null);
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"Ldk/molslinjen/domain/analytics/AnalyticsEvent$SaleOnBoardNoMenuAvailable;", "Ldk/molslinjen/domain/analytics/AnalyticsEvent;", "<init>", "()V", "track", BuildConfig.FLAVOR, "firebaseAnalytics", "Lcom/google/firebase/analytics/FirebaseAnalytics;", "facebookTracker", "Ldk/molslinjen/domain/analytics/IFacebookTracker;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class SaleOnBoardNoMenuAvailable extends AnalyticsEvent {
        public static final SaleOnBoardNoMenuAvailable INSTANCE = new SaleOnBoardNoMenuAvailable();

        private SaleOnBoardNoMenuAvailable() {
            super(null);
        }

        @Override // dk.molslinjen.domain.analytics.AnalyticsEvent
        public void track(FirebaseAnalytics firebaseAnalytics, IFacebookTracker facebookTracker) {
            Intrinsics.checkNotNullParameter(firebaseAnalytics, "firebaseAnalytics");
            Intrinsics.checkNotNullParameter(facebookTracker, "facebookTracker");
            firebaseAnalytics.logEvent("anti_conversion", BundleKt.bundleOf(TuplesKt.to("screen_name", "Catering Menu"), TuplesKt.to("anti_conversion_id", "3"), TuplesKt.to("anti_conversion_name", "menu card error"), TuplesKt.to("anti_conversion_message", "-"), TuplesKt.to("anti_conversion_category", "food & drinks")));
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"Ldk/molslinjen/domain/analytics/AnalyticsEvent$SaleOnBoardOrderError;", "Ldk/molslinjen/domain/analytics/AnalyticsEvent;", "<init>", "()V", "track", BuildConfig.FLAVOR, "firebaseAnalytics", "Lcom/google/firebase/analytics/FirebaseAnalytics;", "facebookTracker", "Ldk/molslinjen/domain/analytics/IFacebookTracker;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class SaleOnBoardOrderError extends AnalyticsEvent {
        public static final SaleOnBoardOrderError INSTANCE = new SaleOnBoardOrderError();

        private SaleOnBoardOrderError() {
            super(null);
        }

        @Override // dk.molslinjen.domain.analytics.AnalyticsEvent
        public void track(FirebaseAnalytics firebaseAnalytics, IFacebookTracker facebookTracker) {
            Intrinsics.checkNotNullParameter(firebaseAnalytics, "firebaseAnalytics");
            Intrinsics.checkNotNullParameter(facebookTracker, "facebookTracker");
            firebaseAnalytics.logEvent("anti_conversion", BundleKt.bundleOf(TuplesKt.to("screen_name", "Catering ordre opsummering"), TuplesKt.to("anti_conversion_id", "1"), TuplesKt.to("anti_conversion_name", "error on ordering"), TuplesKt.to("anti_conversion_message", "-"), TuplesKt.to("anti_conversion_category", "food & drinks")));
        }
    }

    @Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\t\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\b\b\u0002\u0010\f\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0017\u001a\u00020\u0016HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u001a\u001a\u00020\u0019HÖ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u001a\u0010\u001e\u001a\u00020\n2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cHÖ\u0003¢\u0006\u0004\b\u001e\u0010\u001fR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010 R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010!R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\"R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010#R\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010$R\u0014\u0010\f\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010$¨\u0006%"}, d2 = {"Ldk/molslinjen/domain/analytics/AnalyticsEvent$SelectTicketTypeEvent;", "Ldk/molslinjen/domain/analytics/AnalyticsEvent;", "Ldk/molslinjen/domain/model/booking/DepartureTicket;", "departureTicket", "Ldk/molslinjen/domain/model/booking/Departure;", "departure", "Ldk/molslinjen/domain/model/config/Transportation;", "transportation", "Ldk/molslinjen/domain/model/booking/BookingType;", "bookingType", BuildConfig.FLAVOR, "isEditing", "isCheapestAvailable", "<init>", "(Ldk/molslinjen/domain/model/booking/DepartureTicket;Ldk/molslinjen/domain/model/booking/Departure;Ldk/molslinjen/domain/model/config/Transportation;Ldk/molslinjen/domain/model/booking/BookingType;ZZ)V", "Lcom/google/firebase/analytics/FirebaseAnalytics;", "firebaseAnalytics", "Ldk/molslinjen/domain/analytics/IFacebookTracker;", "facebookTracker", BuildConfig.FLAVOR, "track", "(Lcom/google/firebase/analytics/FirebaseAnalytics;Ldk/molslinjen/domain/analytics/IFacebookTracker;)V", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", BuildConfig.FLAVOR, "hashCode", "()I", BuildConfig.FLAVOR, "other", "equals", "(Ljava/lang/Object;)Z", "Ldk/molslinjen/domain/model/booking/DepartureTicket;", "Ldk/molslinjen/domain/model/booking/Departure;", "Ldk/molslinjen/domain/model/config/Transportation;", "Ldk/molslinjen/domain/model/booking/BookingType;", "Z", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final /* data */ class SelectTicketTypeEvent extends AnalyticsEvent {
        private final BookingType bookingType;
        private final Departure departure;
        private final DepartureTicket departureTicket;
        private final boolean isCheapestAvailable;
        private final boolean isEditing;
        private final Transportation transportation;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SelectTicketTypeEvent(DepartureTicket departureTicket, Departure departure, Transportation transportation, BookingType bookingType, boolean z5, boolean z6) {
            super(null);
            Intrinsics.checkNotNullParameter(departureTicket, "departureTicket");
            Intrinsics.checkNotNullParameter(departure, "departure");
            Intrinsics.checkNotNullParameter(transportation, "transportation");
            Intrinsics.checkNotNullParameter(bookingType, "bookingType");
            this.departureTicket = departureTicket;
            this.departure = departure;
            this.transportation = transportation;
            this.bookingType = bookingType;
            this.isEditing = z5;
            this.isCheapestAvailable = z6;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SelectTicketTypeEvent)) {
                return false;
            }
            SelectTicketTypeEvent selectTicketTypeEvent = (SelectTicketTypeEvent) other;
            return Intrinsics.areEqual(this.departureTicket, selectTicketTypeEvent.departureTicket) && Intrinsics.areEqual(this.departure, selectTicketTypeEvent.departure) && Intrinsics.areEqual(this.transportation, selectTicketTypeEvent.transportation) && this.bookingType == selectTicketTypeEvent.bookingType && this.isEditing == selectTicketTypeEvent.isEditing && this.isCheapestAvailable == selectTicketTypeEvent.isCheapestAvailable;
        }

        public int hashCode() {
            return (((((((((this.departureTicket.hashCode() * 31) + this.departure.hashCode()) * 31) + this.transportation.hashCode()) * 31) + this.bookingType.hashCode()) * 31) + Boolean.hashCode(this.isEditing)) * 31) + Boolean.hashCode(this.isCheapestAvailable);
        }

        public String toString() {
            return "SelectTicketTypeEvent(departureTicket=" + this.departureTicket + ", departure=" + this.departure + ", transportation=" + this.transportation + ", bookingType=" + this.bookingType + ", isEditing=" + this.isEditing + ", isCheapestAvailable=" + this.isCheapestAvailable + ")";
        }

        @Override // dk.molslinjen.domain.analytics.AnalyticsEvent
        public void track(FirebaseAnalytics firebaseAnalytics, IFacebookTracker facebookTracker) {
            Intrinsics.checkNotNullParameter(firebaseAnalytics, "firebaseAnalytics");
            Intrinsics.checkNotNullParameter(facebookTracker, "facebookTracker");
            int analyticsAmount = AnalyticsExtensionsKt.toAnalyticsAmount(this.departureTicket.getPrice());
            String trackingKey = this.departureTicket.getCategory().getType().trackingKey();
            firebaseAnalytics.logEvent("change_ticket_type", BundleKt.bundleOf(TuplesKt.to("currency", AnalyticsExtensionsKt.toAnalyticsCurrency(this.departureTicket.getPrice())), TuplesKt.to("value", Integer.valueOf(analyticsAmount)), TuplesKt.to("quantity", 1), TuplesKt.to("item_id", this.departure.getRouteId()), TuplesKt.to("item_name", this.departure.getRouteId()), TuplesKt.to("price", Integer.valueOf(analyticsAmount)), TuplesKt.to("item_category", "ticket"), TuplesKt.to("item_category2", trackingKey), TuplesKt.to("item_variant", trackingKey), TuplesKt.to("start_date", LocalDateTimeExtensionsKt.toFormat(this.departure.getDepartureDateTime(), "yyyy-MM-dd")), TuplesKt.to("end_date", LocalDateTimeExtensionsKt.toFormat(this.departure.getArrivalDateTime(), "yyyy-MM-dd")), TuplesKt.to("origin", this.departure.getDepartureHarborName()), TuplesKt.to("destination", this.departure.getArrivalHarborName()), TuplesKt.to("direction", this.bookingType == BookingType.TwoWay ? "return" : "departure"), TuplesKt.to("travel_type", AnalyticsTracker.INSTANCE.getTravelType$domain_kombardoProd(this.transportation)), TuplesKt.to("departure_time", LocalDateTimeExtensionsKt.toFormat(this.departure.getDepartureDateTime(), "HH:mm")), TuplesKt.to("booking_type", this.isEditing ? "rebooking" : "booking"), TuplesKt.to("ticket_type", trackingKey), TuplesKt.to("is_cheapest_available", Boolean.valueOf(this.isCheapestAvailable))));
        }
    }

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0018R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0019¨\u0006\u001a"}, d2 = {"Ldk/molslinjen/domain/analytics/AnalyticsEvent$ShowDirectionsEvent;", "Ldk/molslinjen/domain/analytics/AnalyticsEvent;", BuildConfig.FLAVOR, "timeToHarborInMinutes", BuildConfig.FLAVOR, "departureHarborName", "<init>", "(ILjava/lang/String;)V", "Lcom/google/firebase/analytics/FirebaseAnalytics;", "firebaseAnalytics", "Ldk/molslinjen/domain/analytics/IFacebookTracker;", "facebookTracker", BuildConfig.FLAVOR, "track", "(Lcom/google/firebase/analytics/FirebaseAnalytics;Ldk/molslinjen/domain/analytics/IFacebookTracker;)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "equals", "(Ljava/lang/Object;)Z", "I", "Ljava/lang/String;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final /* data */ class ShowDirectionsEvent extends AnalyticsEvent {
        private final String departureHarborName;
        private final int timeToHarborInMinutes;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ShowDirectionsEvent(int i5, String departureHarborName) {
            super(null);
            Intrinsics.checkNotNullParameter(departureHarborName, "departureHarborName");
            this.timeToHarborInMinutes = i5;
            this.departureHarborName = departureHarborName;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ShowDirectionsEvent)) {
                return false;
            }
            ShowDirectionsEvent showDirectionsEvent = (ShowDirectionsEvent) other;
            return this.timeToHarborInMinutes == showDirectionsEvent.timeToHarborInMinutes && Intrinsics.areEqual(this.departureHarborName, showDirectionsEvent.departureHarborName);
        }

        public int hashCode() {
            return (Integer.hashCode(this.timeToHarborInMinutes) * 31) + this.departureHarborName.hashCode();
        }

        public String toString() {
            return "ShowDirectionsEvent(timeToHarborInMinutes=" + this.timeToHarborInMinutes + ", departureHarborName=" + this.departureHarborName + ")";
        }

        @Override // dk.molslinjen.domain.analytics.AnalyticsEvent
        public void track(FirebaseAnalytics firebaseAnalytics, IFacebookTracker facebookTracker) {
            Intrinsics.checkNotNullParameter(firebaseAnalytics, "firebaseAnalytics");
            Intrinsics.checkNotNullParameter(facebookTracker, "facebookTracker");
            String lowerCase = this.departureHarborName.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            firebaseAnalytics.logEvent("click_show_route", BundleKt.bundleOf(TuplesKt.to("departure_destination", lowerCase), TuplesKt.to("time_to_departure_destination", Integer.valueOf(this.timeToHarborInMinutes))));
        }
    }

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0017¨\u0006\u0018"}, d2 = {"Ldk/molslinjen/domain/analytics/AnalyticsEvent$ShownFaqEvent;", "Ldk/molslinjen/domain/analytics/AnalyticsEvent;", BuildConfig.FLAVOR, "question", "<init>", "(Ljava/lang/String;)V", "Lcom/google/firebase/analytics/FirebaseAnalytics;", "firebaseAnalytics", "Ldk/molslinjen/domain/analytics/IFacebookTracker;", "facebookTracker", BuildConfig.FLAVOR, "track", "(Lcom/google/firebase/analytics/FirebaseAnalytics;Ldk/molslinjen/domain/analytics/IFacebookTracker;)V", "toString", "()Ljava/lang/String;", BuildConfig.FLAVOR, "hashCode", "()I", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final /* data */ class ShownFaqEvent extends AnalyticsEvent {
        private final String question;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ShownFaqEvent(String question) {
            super(null);
            Intrinsics.checkNotNullParameter(question, "question");
            this.question = question;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof ShownFaqEvent) && Intrinsics.areEqual(this.question, ((ShownFaqEvent) other).question);
        }

        public int hashCode() {
            return this.question.hashCode();
        }

        public String toString() {
            return "ShownFaqEvent(question=" + this.question + ")";
        }

        @Override // dk.molslinjen.domain.analytics.AnalyticsEvent
        public void track(FirebaseAnalytics firebaseAnalytics, IFacebookTracker facebookTracker) {
            Intrinsics.checkNotNullParameter(firebaseAnalytics, "firebaseAnalytics");
            Intrinsics.checkNotNullParameter(facebookTracker, "facebookTracker");
            firebaseAnalytics.logEvent("click_faq", BundleKt.bundleOf(TuplesKt.to("question", this.question)));
        }
    }

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0018\u001a\u0004\b\u0019\u0010\u0010R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001a\u001a\u0004\b\u001b\u0010\u0012¨\u0006\u001c"}, d2 = {"Ldk/molslinjen/domain/analytics/AnalyticsEvent$SplitTestExperimentViewed;", "Ldk/molslinjen/domain/analytics/AnalyticsEvent;", BuildConfig.FLAVOR, "experimentId", BuildConfig.FLAVOR, "variationId", "<init>", "(Ljava/lang/String;I)V", "Lcom/google/firebase/analytics/FirebaseAnalytics;", "firebaseAnalytics", "Ldk/molslinjen/domain/analytics/IFacebookTracker;", "facebookTracker", BuildConfig.FLAVOR, "track", "(Lcom/google/firebase/analytics/FirebaseAnalytics;Ldk/molslinjen/domain/analytics/IFacebookTracker;)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getExperimentId", "I", "getVariationId", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final /* data */ class SplitTestExperimentViewed extends AnalyticsEvent {
        private final String experimentId;
        private final int variationId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SplitTestExperimentViewed(String experimentId, int i5) {
            super(null);
            Intrinsics.checkNotNullParameter(experimentId, "experimentId");
            this.experimentId = experimentId;
            this.variationId = i5;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SplitTestExperimentViewed)) {
                return false;
            }
            SplitTestExperimentViewed splitTestExperimentViewed = (SplitTestExperimentViewed) other;
            return Intrinsics.areEqual(this.experimentId, splitTestExperimentViewed.experimentId) && this.variationId == splitTestExperimentViewed.variationId;
        }

        public int hashCode() {
            return (this.experimentId.hashCode() * 31) + Integer.hashCode(this.variationId);
        }

        public String toString() {
            return "SplitTestExperimentViewed(experimentId=" + this.experimentId + ", variationId=" + this.variationId + ")";
        }

        @Override // dk.molslinjen.domain.analytics.AnalyticsEvent
        public void track(FirebaseAnalytics firebaseAnalytics, IFacebookTracker facebookTracker) {
            Intrinsics.checkNotNullParameter(firebaseAnalytics, "firebaseAnalytics");
            Intrinsics.checkNotNullParameter(facebookTracker, "facebookTracker");
            firebaseAnalytics.logEvent("experiment_viewed", BundleKt.bundleOf(TuplesKt.to("experiment_id", this.experimentId), TuplesKt.to("variation_id", String.valueOf(this.variationId))));
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"Ldk/molslinjen/domain/analytics/AnalyticsEvent$StartAddReturnTripFromSummaryEvent;", "Ldk/molslinjen/domain/analytics/AnalyticsEvent;", "<init>", "()V", "track", BuildConfig.FLAVOR, "firebaseAnalytics", "Lcom/google/firebase/analytics/FirebaseAnalytics;", "facebookTracker", "Ldk/molslinjen/domain/analytics/IFacebookTracker;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class StartAddReturnTripFromSummaryEvent extends AnalyticsEvent {
        public static final StartAddReturnTripFromSummaryEvent INSTANCE = new StartAddReturnTripFromSummaryEvent();

        private StartAddReturnTripFromSummaryEvent() {
            super(null);
        }

        @Override // dk.molslinjen.domain.analytics.AnalyticsEvent
        public void track(FirebaseAnalytics firebaseAnalytics, IFacebookTracker facebookTracker) {
            Intrinsics.checkNotNullParameter(firebaseAnalytics, "firebaseAnalytics");
            Intrinsics.checkNotNullParameter(facebookTracker, "facebookTracker");
            firebaseAnalytics.logEvent("add_return", null);
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"Ldk/molslinjen/domain/analytics/AnalyticsEvent$StartEditTicketEvent;", "Ldk/molslinjen/domain/analytics/AnalyticsEvent;", "<init>", "()V", "track", BuildConfig.FLAVOR, "firebaseAnalytics", "Lcom/google/firebase/analytics/FirebaseAnalytics;", "facebookTracker", "Ldk/molslinjen/domain/analytics/IFacebookTracker;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class StartEditTicketEvent extends AnalyticsEvent {
        public static final StartEditTicketEvent INSTANCE = new StartEditTicketEvent();

        private StartEditTicketEvent() {
            super(null);
        }

        @Override // dk.molslinjen.domain.analytics.AnalyticsEvent
        public void track(FirebaseAnalytics firebaseAnalytics, IFacebookTracker facebookTracker) {
            Intrinsics.checkNotNullParameter(firebaseAnalytics, "firebaseAnalytics");
            Intrinsics.checkNotNullParameter(facebookTracker, "facebookTracker");
            firebaseAnalytics.logEvent("start_rebooking", null);
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"Ldk/molslinjen/domain/analytics/AnalyticsEvent$StopAddingReturnTripEvent;", "Ldk/molslinjen/domain/analytics/AnalyticsEvent;", "<init>", "()V", "track", BuildConfig.FLAVOR, "firebaseAnalytics", "Lcom/google/firebase/analytics/FirebaseAnalytics;", "facebookTracker", "Ldk/molslinjen/domain/analytics/IFacebookTracker;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class StopAddingReturnTripEvent extends AnalyticsEvent {
        public static final StopAddingReturnTripEvent INSTANCE = new StopAddingReturnTripEvent();

        private StopAddingReturnTripEvent() {
            super(null);
        }

        @Override // dk.molslinjen.domain.analytics.AnalyticsEvent
        public void track(FirebaseAnalytics firebaseAnalytics, IFacebookTracker facebookTracker) {
            Intrinsics.checkNotNullParameter(firebaseAnalytics, "firebaseAnalytics");
            Intrinsics.checkNotNullParameter(facebookTracker, "facebookTracker");
            firebaseAnalytics.logEvent("cancel_return", null);
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"Ldk/molslinjen/domain/analytics/AnalyticsEvent$TimeoutEvent;", "Ldk/molslinjen/domain/analytics/AnalyticsEvent;", "<init>", "()V", "track", BuildConfig.FLAVOR, "firebaseAnalytics", "Lcom/google/firebase/analytics/FirebaseAnalytics;", "facebookTracker", "Ldk/molslinjen/domain/analytics/IFacebookTracker;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class TimeoutEvent extends AnalyticsEvent {
        public static final TimeoutEvent INSTANCE = new TimeoutEvent();

        private TimeoutEvent() {
            super(null);
        }

        @Override // dk.molslinjen.domain.analytics.AnalyticsEvent
        public void track(FirebaseAnalytics firebaseAnalytics, IFacebookTracker facebookTracker) {
            Intrinsics.checkNotNullParameter(firebaseAnalytics, "firebaseAnalytics");
            Intrinsics.checkNotNullParameter(facebookTracker, "facebookTracker");
            firebaseAnalytics.logEvent("booking_timed_out", null);
        }
    }

    public /* synthetic */ AnalyticsEvent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public abstract void track(FirebaseAnalytics firebaseAnalytics, IFacebookTracker facebookTracker);

    private AnalyticsEvent() {
    }
}
