package dk.molslinjen.domain.analytics;

import com.adjust.sdk.Constants;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import dk.molslinjen.core.extensions.StringExtensionsKt;
import dk.molslinjen.domain.extensions.LocalDateTimeExtensionsKt;
import dk.molslinjen.domain.managers.user.AuthenticationType;
import dk.molslinjen.domain.managers.user.IUserManager;
import dk.molslinjen.domain.model.account.Gender;
import dk.molslinjen.domain.model.account.user.User;
import dk.molslinjen.domain.model.account.user.UserContactDetails;
import dk.molslinjen.domain.model.account.user.UserInfo;
import dk.molslinjen.domain.model.account.user.UserPersonalDetails;
import dk.molslinjen.domain.model.booking.BookingType;
import dk.molslinjen.domain.model.config.Site;
import dk.molslinjen.domain.model.config.Transportation;
import dk.molslinjen.domain.model.shared.PhoneNumber;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.conscrypt.BuildConfig;
import org.threeten.bp.LocalDate;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001-B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J/\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0002\u0010\rJ\u007f\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0012\u001a\u0004\u0018\u00010\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u00102\b\u0010\u001a\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002¢\u0006\u0002\u0010\u001cJ\u0018\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u0010H\u0016J \u0010\u001f\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u000b2\u0006\u0010!\u001a\u00020\"H\u0016J*\u0010#\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010)H\u0016J\u001c\u0010*\u001a\u00020\u0005*\u00020\u00072\u0006\u0010+\u001a\u00020\u00102\u0006\u0010,\u001a\u00020\u0010H\u0002¨\u0006."}, d2 = {"Ldk/molslinjen/domain/analytics/AnalyticsStateTrackingHelper;", "Ldk/molslinjen/domain/analytics/IAnalyticsStateTrackingHelper;", "<init>", "()V", "updateStateTracking", BuildConfig.FLAVOR, "firebaseAnalytics", "Lcom/google/firebase/analytics/FirebaseAnalytics;", "userManager", "Ldk/molslinjen/domain/managers/user/IUserManager;", "locationAllowed", BuildConfig.FLAVOR, "pushEnabled", "(Lcom/google/firebase/analytics/FirebaseAnalytics;Ldk/molslinjen/domain/managers/user/IUserManager;ZLjava/lang/Boolean;)V", "updateUserStateTracking", "email", BuildConfig.FLAVOR, "firstName", "lastName", "phoneNumber", "Ldk/molslinjen/domain/model/shared/PhoneNumber;", "birthDate", "Lorg/threeten/bp/LocalDate;", "gender", "Ldk/molslinjen/domain/model/account/Gender;", "postalCode", "nationality", "isAuthenticated", "(Lcom/google/firebase/analytics/FirebaseAnalytics;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ldk/molslinjen/domain/model/shared/PhoneNumber;Lorg/threeten/bp/LocalDate;Ldk/molslinjen/domain/model/account/Gender;Ljava/lang/String;Ljava/lang/String;ZZLjava/lang/Boolean;)V", "updateActiveTab", "activeTab", "updateBookingTypeStateTracking", "isEditing", "bookingFlowType", "Ldk/molslinjen/domain/analytics/AnalyticsStateTrackingHelper$BookingFlowTypeTracking;", "updateBookingStateTracking", "activeDepartureSite", "Ldk/molslinjen/domain/model/config/Site;", "bookingType", "Ldk/molslinjen/domain/model/booking/BookingType;", "transportation", "Ldk/molslinjen/domain/model/config/Transportation;", "setUserPropertyAndFirebaseCrashlytics", "key", "value", "BookingFlowTypeTracking", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class AnalyticsStateTrackingHelper implements IAnalyticsStateTrackingHelper {

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Ldk/molslinjen/domain/analytics/AnalyticsStateTrackingHelper$BookingFlowTypeTracking;", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;I)V", "Ticket", "CommuteTicket", "MultiRideTicket", "MultiRideCard", "SimpleChange", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class BookingFlowTypeTracking {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ BookingFlowTypeTracking[] $VALUES;
        public static final BookingFlowTypeTracking Ticket = new BookingFlowTypeTracking("Ticket", 0);
        public static final BookingFlowTypeTracking CommuteTicket = new BookingFlowTypeTracking("CommuteTicket", 1);
        public static final BookingFlowTypeTracking MultiRideTicket = new BookingFlowTypeTracking("MultiRideTicket", 2);
        public static final BookingFlowTypeTracking MultiRideCard = new BookingFlowTypeTracking("MultiRideCard", 3);
        public static final BookingFlowTypeTracking SimpleChange = new BookingFlowTypeTracking("SimpleChange", 4);

        private static final /* synthetic */ BookingFlowTypeTracking[] $values() {
            return new BookingFlowTypeTracking[]{Ticket, CommuteTicket, MultiRideTicket, MultiRideCard, SimpleChange};
        }

        static {
            BookingFlowTypeTracking[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }

        private BookingFlowTypeTracking(String str, int i5) {
        }

        public static BookingFlowTypeTracking valueOf(String str) {
            return (BookingFlowTypeTracking) Enum.valueOf(BookingFlowTypeTracking.class, str);
        }

        public static BookingFlowTypeTracking[] values() {
            return (BookingFlowTypeTracking[]) $VALUES.clone();
        }
    }

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[BookingFlowTypeTracking.values().length];
            try {
                iArr[BookingFlowTypeTracking.Ticket.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[BookingFlowTypeTracking.CommuteTicket.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[BookingFlowTypeTracking.MultiRideTicket.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[BookingFlowTypeTracking.MultiRideCard.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[BookingFlowTypeTracking.SimpleChange.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private final void setUserPropertyAndFirebaseCrashlytics(FirebaseAnalytics firebaseAnalytics, String str, String str2) {
        firebaseAnalytics.setUserProperty(str, str2);
        FirebaseCrashlytics.getInstance().setCustomKey(str, str2);
    }

    private final void updateUserStateTracking(FirebaseAnalytics firebaseAnalytics, String email, String firstName, String lastName, PhoneNumber phoneNumber, LocalDate birthDate, Gender gender, String postalCode, String nationality, boolean isAuthenticated, boolean locationAllowed, Boolean pushEnabled) {
        String str;
        String nationalNumber;
        if (email != null) {
            String md5 = StringExtensionsKt.md5(email);
            firebaseAnalytics.setUserId(md5);
            FirebaseCrashlytics.getInstance().setUserId(md5);
        }
        String str2 = firstName + " " + lastName;
        boolean isBlank = StringsKt.isBlank(str2);
        String str3 = BuildConfig.FLAVOR;
        if (isBlank) {
            str2 = BuildConfig.FLAVOR;
        }
        setUserPropertyAndFirebaseCrashlytics(firebaseAnalytics, "name", str2);
        if (phoneNumber == null || (str = phoneNumber.getCountryCode()) == null) {
            str = BuildConfig.FLAVOR;
        }
        setUserPropertyAndFirebaseCrashlytics(firebaseAnalytics, "phone_number_code", str);
        if (phoneNumber != null && (nationalNumber = phoneNumber.getNationalNumber()) != null) {
            str3 = nationalNumber;
        }
        setUserPropertyAndFirebaseCrashlytics(firebaseAnalytics, "phone_number", str3);
        setUserPropertyAndFirebaseCrashlytics(firebaseAnalytics, "user_logged_in", String.valueOf(isAuthenticated));
        if (birthDate != null) {
            setUserPropertyAndFirebaseCrashlytics(firebaseAnalytics, "user_age", String.valueOf(LocalDateTimeExtensionsKt.toAge(birthDate)));
            setUserPropertyAndFirebaseCrashlytics(firebaseAnalytics, "user_birth_year", String.valueOf(birthDate.getYear()));
        }
        if (nationality != null) {
            setUserPropertyAndFirebaseCrashlytics(firebaseAnalytics, "user_nationality", nationality);
        }
        if (gender != null) {
            setUserPropertyAndFirebaseCrashlytics(firebaseAnalytics, "user_gender", gender.name());
        }
        if (postalCode != null) {
            setUserPropertyAndFirebaseCrashlytics(firebaseAnalytics, "user_postal_code", postalCode);
        }
        if (pushEnabled != null) {
            String lowerCase = pushEnabled.toString().toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            setUserPropertyAndFirebaseCrashlytics(firebaseAnalytics, "push_messages", lowerCase);
        }
        String lowerCase2 = String.valueOf(locationAllowed).toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
        setUserPropertyAndFirebaseCrashlytics(firebaseAnalytics, "location_services", lowerCase2);
    }

    @Override // dk.molslinjen.domain.analytics.IAnalyticsStateTrackingHelper
    public void updateActiveTab(FirebaseAnalytics firebaseAnalytics, String activeTab) {
        Intrinsics.checkNotNullParameter(firebaseAnalytics, "firebaseAnalytics");
        Intrinsics.checkNotNullParameter(activeTab, "activeTab");
        setUserPropertyAndFirebaseCrashlytics(firebaseAnalytics, "active_tab", activeTab);
    }

    @Override // dk.molslinjen.domain.analytics.IAnalyticsStateTrackingHelper
    public void updateBookingStateTracking(FirebaseAnalytics firebaseAnalytics, Site activeDepartureSite, BookingType bookingType, Transportation transportation) {
        String str;
        Intrinsics.checkNotNullParameter(firebaseAnalytics, "firebaseAnalytics");
        Intrinsics.checkNotNullParameter(activeDepartureSite, "activeDepartureSite");
        Intrinsics.checkNotNullParameter(bookingType, "bookingType");
        setUserPropertyAndFirebaseCrashlytics(firebaseAnalytics, "line", activeDepartureSite.trackingKey());
        if (transportation == null || (str = AnalyticsTracker.INSTANCE.getTravelType$domain_kombardoProd(transportation)) == null) {
            str = "-";
        }
        setUserPropertyAndFirebaseCrashlytics(firebaseAnalytics, "travel_type", str);
        setUserPropertyAndFirebaseCrashlytics(firebaseAnalytics, "single_return", bookingType == BookingType.TwoWay ? "return" : "single");
    }

    @Override // dk.molslinjen.domain.analytics.IAnalyticsStateTrackingHelper
    public void updateBookingTypeStateTracking(FirebaseAnalytics firebaseAnalytics, boolean isEditing, BookingFlowTypeTracking bookingFlowType) {
        String str;
        Intrinsics.checkNotNullParameter(firebaseAnalytics, "firebaseAnalytics");
        Intrinsics.checkNotNullParameter(bookingFlowType, "bookingFlowType");
        setUserPropertyAndFirebaseCrashlytics(firebaseAnalytics, "booking_type", isEditing ? "rebooking" : "booking");
        int i5 = WhenMappings.$EnumSwitchMapping$0[bookingFlowType.ordinal()];
        if (i5 == 1) {
            str = Constants.NORMAL;
        } else if (i5 == 2) {
            str = "commuter_ticket";
        } else if (i5 == 3) {
            str = "multi_ride_ticket";
        } else if (i5 == 4) {
            str = "multi_ride_card";
        } else {
            if (i5 != 5) {
                throw new NoWhenBranchMatchedException();
            }
            str = "simple_change";
        }
        setUserPropertyAndFirebaseCrashlytics(firebaseAnalytics, "checkout_type", str);
    }

    @Override // dk.molslinjen.domain.analytics.IAnalyticsStateTrackingHelper
    public void updateStateTracking(FirebaseAnalytics firebaseAnalytics, IUserManager userManager, boolean locationAllowed, Boolean pushEnabled) {
        UserPersonalDetails personalDetails;
        UserContactDetails contactDetails;
        UserPersonalDetails personalDetails2;
        UserPersonalDetails personalDetails3;
        UserContactDetails contactDetails2;
        UserPersonalDetails personalDetails4;
        UserPersonalDetails personalDetails5;
        UserContactDetails contactDetails3;
        Intrinsics.checkNotNullParameter(firebaseAnalytics, "firebaseAnalytics");
        Intrinsics.checkNotNullParameter(userManager, "userManager");
        User user = userManager.getCurrentUserState().getValue().getUser();
        UserInfo details = user.getDetails();
        String email = (details == null || (contactDetails3 = details.getContactDetails()) == null) ? null : contactDetails3.getEmail();
        UserInfo details2 = user.getDetails();
        String firstName = (details2 == null || (personalDetails5 = details2.getPersonalDetails()) == null) ? null : personalDetails5.getFirstName();
        UserInfo details3 = user.getDetails();
        String lastName = (details3 == null || (personalDetails4 = details3.getPersonalDetails()) == null) ? null : personalDetails4.getLastName();
        UserInfo details4 = user.getDetails();
        PhoneNumber phoneNumber = (details4 == null || (contactDetails2 = details4.getContactDetails()) == null) ? null : contactDetails2.getPhoneNumber();
        UserInfo details5 = user.getDetails();
        LocalDate birthDate = (details5 == null || (personalDetails3 = details5.getPersonalDetails()) == null) ? null : personalDetails3.getBirthDate();
        UserInfo details6 = user.getDetails();
        Gender gender = (details6 == null || (personalDetails2 = details6.getPersonalDetails()) == null) ? null : personalDetails2.getGender();
        UserInfo details7 = user.getDetails();
        String postalCode = (details7 == null || (contactDetails = details7.getContactDetails()) == null) ? null : contactDetails.getPostalCode();
        UserInfo details8 = user.getDetails();
        updateUserStateTracking(firebaseAnalytics, email, firstName, lastName, phoneNumber, birthDate, gender, postalCode, (details8 == null || (personalDetails = details8.getPersonalDetails()) == null) ? null : personalDetails.getNationality(), !Intrinsics.areEqual(userManager.getAuthenticationType().getValue(), AuthenticationType.None.INSTANCE), locationAllowed, pushEnabled);
    }
}
