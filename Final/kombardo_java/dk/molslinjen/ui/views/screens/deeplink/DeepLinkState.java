package dk.molslinjen.ui.views.screens.deeplink;

import dk.molslinjen.domain.model.config.Site;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0004\u0004\u0005\u0006\u0007B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0004\b\t\n\u000b¨\u0006\f"}, d2 = {"Ldk/molslinjen/ui/views/screens/deeplink/DeepLinkState;", BuildConfig.FLAVOR, "<init>", "()V", "ShowHomeScreen", "ShowEarlyCheckIn", "ShowAccountActivation", "ShowPasswordReset", "Ldk/molslinjen/ui/views/screens/deeplink/DeepLinkState$ShowAccountActivation;", "Ldk/molslinjen/ui/views/screens/deeplink/DeepLinkState$ShowEarlyCheckIn;", "Ldk/molslinjen/ui/views/screens/deeplink/DeepLinkState$ShowHomeScreen;", "Ldk/molslinjen/ui/views/screens/deeplink/DeepLinkState$ShowPasswordReset;", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class DeepLinkState {

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0011\u001a\u0004\b\u0012\u0010\bR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0011\u001a\u0004\b\u0013\u0010\b¨\u0006\u0014"}, d2 = {"Ldk/molslinjen/ui/views/screens/deeplink/DeepLinkState$ShowAccountActivation;", "Ldk/molslinjen/ui/views/screens/deeplink/DeepLinkState;", BuildConfig.FLAVOR, "token", "originalUrl", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", BuildConfig.FLAVOR, "hashCode", "()I", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getToken", "getOriginalUrl", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final /* data */ class ShowAccountActivation extends DeepLinkState {
        private final String originalUrl;
        private final String token;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ShowAccountActivation(String token, String originalUrl) {
            super(null);
            Intrinsics.checkNotNullParameter(token, "token");
            Intrinsics.checkNotNullParameter(originalUrl, "originalUrl");
            this.token = token;
            this.originalUrl = originalUrl;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ShowAccountActivation)) {
                return false;
            }
            ShowAccountActivation showAccountActivation = (ShowAccountActivation) other;
            return Intrinsics.areEqual(this.token, showAccountActivation.token) && Intrinsics.areEqual(this.originalUrl, showAccountActivation.originalUrl);
        }

        public final String getOriginalUrl() {
            return this.originalUrl;
        }

        public final String getToken() {
            return this.token;
        }

        public int hashCode() {
            return (this.token.hashCode() * 31) + this.originalUrl.hashCode();
        }

        public String toString() {
            return "ShowAccountActivation(token=" + this.token + ", originalUrl=" + this.originalUrl + ")";
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Ldk/molslinjen/ui/views/screens/deeplink/DeepLinkState$ShowHomeScreen;", "Ldk/molslinjen/ui/views/screens/deeplink/DeepLinkState;", "<init>", "()V", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class ShowHomeScreen extends DeepLinkState {
        public static final ShowHomeScreen INSTANCE = new ShowHomeScreen();

        private ShowHomeScreen() {
            super(null);
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0011\u001a\u0004\b\u0012\u0010\bR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0011\u001a\u0004\b\u0013\u0010\b¨\u0006\u0014"}, d2 = {"Ldk/molslinjen/ui/views/screens/deeplink/DeepLinkState$ShowPasswordReset;", "Ldk/molslinjen/ui/views/screens/deeplink/DeepLinkState;", BuildConfig.FLAVOR, "token", "originalUrl", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", BuildConfig.FLAVOR, "hashCode", "()I", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getToken", "getOriginalUrl", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final /* data */ class ShowPasswordReset extends DeepLinkState {
        private final String originalUrl;
        private final String token;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ShowPasswordReset(String token, String originalUrl) {
            super(null);
            Intrinsics.checkNotNullParameter(token, "token");
            Intrinsics.checkNotNullParameter(originalUrl, "originalUrl");
            this.token = token;
            this.originalUrl = originalUrl;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ShowPasswordReset)) {
                return false;
            }
            ShowPasswordReset showPasswordReset = (ShowPasswordReset) other;
            return Intrinsics.areEqual(this.token, showPasswordReset.token) && Intrinsics.areEqual(this.originalUrl, showPasswordReset.originalUrl);
        }

        public final String getOriginalUrl() {
            return this.originalUrl;
        }

        public final String getToken() {
            return this.token;
        }

        public int hashCode() {
            return (this.token.hashCode() * 31) + this.originalUrl.hashCode();
        }

        public String toString() {
            return "ShowPasswordReset(token=" + this.token + ", originalUrl=" + this.originalUrl + ")";
        }
    }

    public /* synthetic */ DeepLinkState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\b\u0087\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0013\u001a\u0004\b\u0014\u0010\nR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0013\u001a\u0004\b\u0015\u0010\nR\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Ldk/molslinjen/ui/views/screens/deeplink/DeepLinkState$ShowEarlyCheckIn;", "Ldk/molslinjen/ui/views/screens/deeplink/DeepLinkState;", BuildConfig.FLAVOR, "phone", "reservationNumber", "Ldk/molslinjen/domain/model/config/Site;", "site", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ldk/molslinjen/domain/model/config/Site;)V", "toString", "()Ljava/lang/String;", BuildConfig.FLAVOR, "hashCode", "()I", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getPhone", "getReservationNumber", "Ldk/molslinjen/domain/model/config/Site;", "getSite", "()Ldk/molslinjen/domain/model/config/Site;", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final /* data */ class ShowEarlyCheckIn extends DeepLinkState {
        private final String phone;
        private final String reservationNumber;
        private final Site site;

        public /* synthetic */ ShowEarlyCheckIn(String str, String str2, Site site, int i5, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2, (i5 & 4) != 0 ? Site.Mols : site);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ShowEarlyCheckIn)) {
                return false;
            }
            ShowEarlyCheckIn showEarlyCheckIn = (ShowEarlyCheckIn) other;
            return Intrinsics.areEqual(this.phone, showEarlyCheckIn.phone) && Intrinsics.areEqual(this.reservationNumber, showEarlyCheckIn.reservationNumber) && this.site == showEarlyCheckIn.site;
        }

        public final String getPhone() {
            return this.phone;
        }

        public final String getReservationNumber() {
            return this.reservationNumber;
        }

        public final Site getSite() {
            return this.site;
        }

        public int hashCode() {
            return (((this.phone.hashCode() * 31) + this.reservationNumber.hashCode()) * 31) + this.site.hashCode();
        }

        public String toString() {
            return "ShowEarlyCheckIn(phone=" + this.phone + ", reservationNumber=" + this.reservationNumber + ", site=" + this.site + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ShowEarlyCheckIn(String phone, String reservationNumber, Site site) {
            super(null);
            Intrinsics.checkNotNullParameter(phone, "phone");
            Intrinsics.checkNotNullParameter(reservationNumber, "reservationNumber");
            Intrinsics.checkNotNullParameter(site, "site");
            this.phone = phone;
            this.reservationNumber = reservationNumber;
            this.site = site;
        }
    }

    private DeepLinkState() {
    }
}
