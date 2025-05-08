package dk.molslinjen.ui.views.screens.profile.authentication.register;

import dk.molslinjen.kombardo.R;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import org.conscrypt.BuildConfig;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\b\u001a\u00020\t8G¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bj\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\f"}, d2 = {"Ldk/molslinjen/ui/views/screens/profile/authentication/register/LoginAnimationMode;", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;I)V", "Activation", "Login", "ResetPassword", "SignUp", "mainText", BuildConfig.FLAVOR, "getMainText", "()I", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class LoginAnimationMode {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ LoginAnimationMode[] $VALUES;
    public static final LoginAnimationMode Activation = new LoginAnimationMode("Activation", 0);
    public static final LoginAnimationMode Login = new LoginAnimationMode("Login", 1);
    public static final LoginAnimationMode ResetPassword = new LoginAnimationMode("ResetPassword", 2);
    public static final LoginAnimationMode SignUp = new LoginAnimationMode("SignUp", 3);

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[LoginAnimationMode.values().length];
            try {
                iArr[LoginAnimationMode.Activation.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[LoginAnimationMode.Login.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[LoginAnimationMode.ResetPassword.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[LoginAnimationMode.SignUp.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private static final /* synthetic */ LoginAnimationMode[] $values() {
        return new LoginAnimationMode[]{Activation, Login, ResetPassword, SignUp};
    }

    static {
        LoginAnimationMode[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    private LoginAnimationMode(String str, int i5) {
    }

    public static LoginAnimationMode valueOf(String str) {
        return (LoginAnimationMode) Enum.valueOf(LoginAnimationMode.class, str);
    }

    public static LoginAnimationMode[] values() {
        return (LoginAnimationMode[]) $VALUES.clone();
    }

    public final int getMainText() {
        int i5 = WhenMappings.$EnumSwitchMapping$0[ordinal()];
        if (i5 == 1) {
            return R.string.profile_activation_success;
        }
        if (i5 == 2) {
            return R.string.profile_authentication_success_loggedIn;
        }
        if (i5 == 3) {
            return R.string.resetPassword_success;
        }
        if (i5 == 4) {
            return R.string.profile_authentication_success_signedUp;
        }
        throw new NoWhenBranchMatchedException();
    }
}
