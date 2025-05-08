package dk.molslinjen.ui.views.screens.profile.authentication;

import com.airbnb.lottie.compose.LottieClipSpec;
import dk.molslinjen.kombardo.R;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0002\u0012\u0013B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u00058G¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\t\u0010\u0007R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b8F¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011\u0082\u0001\u0002\u0014\u0015¨\u0006\u0016"}, d2 = {"Ldk/molslinjen/ui/views/screens/profile/authentication/LoginAnimationState;", BuildConfig.FLAVOR, "<init>", "()V", "animationRes", BuildConfig.FLAVOR, "getAnimationRes", "()I", "iterations", "getIterations", "initials", BuildConfig.FLAVOR, "getInitials", "()Ljava/lang/String;", "clipSpec", "Lcom/airbnb/lottie/compose/LottieClipSpec;", "getClipSpec", "()Lcom/airbnb/lottie/compose/LottieClipSpec;", "Loading", "Success", "Ldk/molslinjen/ui/views/screens/profile/authentication/LoginAnimationState$Loading;", "Ldk/molslinjen/ui/views/screens/profile/authentication/LoginAnimationState$Success;", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class LoginAnimationState {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Ldk/molslinjen/ui/views/screens/profile/authentication/LoginAnimationState$Loading;", "Ldk/molslinjen/ui/views/screens/profile/authentication/LoginAnimationState;", "<init>", "()V", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Loading extends LoginAnimationState {
        public static final Loading INSTANCE = new Loading();

        private Loading() {
            super(null);
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Ldk/molslinjen/ui/views/screens/profile/authentication/LoginAnimationState$Success;", "Ldk/molslinjen/ui/views/screens/profile/authentication/LoginAnimationState;", "userInitials", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;)V", "getUserInitials", "()Ljava/lang/String;", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Success extends LoginAnimationState {
        private final String userInitials;

        public Success(String str) {
            super(null);
            this.userInitials = str;
        }

        public final String getUserInitials() {
            return this.userInitials;
        }
    }

    public /* synthetic */ LoginAnimationState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public final int getAnimationRes() {
        if (this instanceof Loading) {
            return R.raw.animation_lottie_full_width_spinner;
        }
        if (this instanceof Success) {
            return R.raw.animation_lottie_login_check_pop_text;
        }
        throw new NoWhenBranchMatchedException();
    }

    public final LottieClipSpec getClipSpec() {
        if (this instanceof Loading) {
            return null;
        }
        if (this instanceof Success) {
            return getInitials() == null ? new LottieClipSpec.Markers("Pop", "Shrink", false, 4, null) : new LottieClipSpec.Markers("Pop", "End", false, 4, null);
        }
        throw new NoWhenBranchMatchedException();
    }

    public final String getInitials() {
        if (this instanceof Loading) {
            return null;
        }
        if (this instanceof Success) {
            return ((Success) this).getUserInitials();
        }
        throw new NoWhenBranchMatchedException();
    }

    public final int getIterations() {
        if (this instanceof Loading) {
            return Integer.MAX_VALUE;
        }
        if (this instanceof Success) {
            return 1;
        }
        throw new NoWhenBranchMatchedException();
    }

    private LoginAnimationState() {
    }
}
