package dk.molslinjen.ui.views.screens.profile.shared.accountCard;

import dk.molslinjen.domain.managers.user.IUserManager;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Ldk/molslinjen/ui/views/screens/profile/shared/accountCard/AccountCardData;", BuildConfig.FLAVOR, "<init>", "()V", "Signup", "ActivationPending", "Ldk/molslinjen/ui/views/screens/profile/shared/accountCard/AccountCardData$ActivationPending;", "Ldk/molslinjen/ui/views/screens/profile/shared/accountCard/AccountCardData$Signup;", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class AccountCardData {

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0001\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bHÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0010\u001a\u0004\b\u0011\u0010\n¨\u0006\u0012"}, d2 = {"Ldk/molslinjen/ui/views/screens/profile/shared/accountCard/AccountCardData$Signup;", "Ldk/molslinjen/ui/views/screens/profile/shared/accountCard/AccountCardData;", BuildConfig.FLAVOR, "description", "<init>", "(I)V", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", "hashCode", "()I", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "equals", "(Ljava/lang/Object;)Z", "I", "getDescription", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final /* data */ class Signup extends AccountCardData {
        private final int description;

        public Signup(int i5) {
            super(null);
            this.description = i5;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof Signup) && this.description == ((Signup) other).description;
        }

        public final int getDescription() {
            return this.description;
        }

        public int hashCode() {
            return Integer.hashCode(this.description);
        }

        public String toString() {
            return "Signup(description=" + this.description + ")";
        }
    }

    public /* synthetic */ AccountCardData(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private AccountCardData() {
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\u0087\b\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007B\u0011\b\u0016\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u0006\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0015\u001a\u0004\b\u0016\u0010\fR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0015\u001a\u0004\b\u0017\u0010\fR\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0015\u001a\u0004\b\u0018\u0010\fR\u0017\u0010\u0019\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u0015\u001a\u0004\b\u001a\u0010\f¨\u0006\u001c"}, d2 = {"Ldk/molslinjen/ui/views/screens/profile/shared/accountCard/AccountCardData$ActivationPending;", "Ldk/molslinjen/ui/views/screens/profile/shared/accountCard/AccountCardData;", BuildConfig.FLAVOR, "firstName", "lastName", "email", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Ldk/molslinjen/domain/managers/user/IUserManager$ActivationInfo;", "activationInfo", "(Ldk/molslinjen/domain/managers/user/IUserManager$ActivationInfo;)V", "toString", "()Ljava/lang/String;", BuildConfig.FLAVOR, "hashCode", "()I", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getFirstName", "getLastName", "getEmail", "initials", "getInitials", "Companion", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final /* data */ class ActivationPending extends AccountCardData {
        private static final ActivationPending mock = new ActivationPending("Vertica", "Mols", "vertica@vertica.dk");
        private final String email;
        private final String firstName;
        private final String initials;
        private final String lastName;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ActivationPending(String firstName, String lastName, String email) {
            super(null);
            Intrinsics.checkNotNullParameter(firstName, "firstName");
            Intrinsics.checkNotNullParameter(lastName, "lastName");
            Intrinsics.checkNotNullParameter(email, "email");
            this.firstName = firstName;
            this.lastName = lastName;
            this.email = email;
            char charAt = firstName.charAt(0);
            char charAt2 = lastName.charAt(0);
            StringBuilder sb = new StringBuilder();
            sb.append(charAt);
            sb.append(charAt2);
            String upperCase = sb.toString().toUpperCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
            this.initials = upperCase;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ActivationPending)) {
                return false;
            }
            ActivationPending activationPending = (ActivationPending) other;
            return Intrinsics.areEqual(this.firstName, activationPending.firstName) && Intrinsics.areEqual(this.lastName, activationPending.lastName) && Intrinsics.areEqual(this.email, activationPending.email);
        }

        public final String getEmail() {
            return this.email;
        }

        public final String getInitials() {
            return this.initials;
        }

        public int hashCode() {
            return (((this.firstName.hashCode() * 31) + this.lastName.hashCode()) * 31) + this.email.hashCode();
        }

        public String toString() {
            return "ActivationPending(firstName=" + this.firstName + ", lastName=" + this.lastName + ", email=" + this.email + ")";
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public ActivationPending(IUserManager.ActivationInfo activationInfo) {
            this(activationInfo.getFirstName(), activationInfo.getLastName(), activationInfo.getEmail());
            Intrinsics.checkNotNullParameter(activationInfo, "activationInfo");
        }
    }
}
