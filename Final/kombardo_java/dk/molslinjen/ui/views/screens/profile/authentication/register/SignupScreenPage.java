package dk.molslinjen.ui.views.screens.profile.authentication.register;

import dk.molslinjen.kombardo.R;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.conscrypt.BuildConfig;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0086\u0081\u0002\u0018\u0000 \u00102\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0010B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u000e\u001a\u00020\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\f\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\r\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\u0011"}, d2 = {"Ldk/molslinjen/ui/views/screens/profile/authentication/register/SignupScreenPage;", BuildConfig.FLAVOR, "index", BuildConfig.FLAVOR, "<init>", "(Ljava/lang/String;II)V", "getIndex", "()I", "Name", "AdditionalInfo", "Contact", "PasswordAndTerms", "pageButtonText", "getPageButtonText", "isFirstPage", BuildConfig.FLAVOR, "Companion", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SignupScreenPage {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ SignupScreenPage[] $VALUES;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private final int index;
    public static final SignupScreenPage Name = new SignupScreenPage("Name", 0, 0);
    public static final SignupScreenPage AdditionalInfo = new SignupScreenPage("AdditionalInfo", 1, 1);
    public static final SignupScreenPage Contact = new SignupScreenPage("Contact", 2, 2);
    public static final SignupScreenPage PasswordAndTerms = new SignupScreenPage("PasswordAndTerms", 3, 3);

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Ldk/molslinjen/ui/views/screens/profile/authentication/register/SignupScreenPage$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "from", "Ldk/molslinjen/ui/views/screens/profile/authentication/register/SignupScreenPage;", "index", BuildConfig.FLAVOR, "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final SignupScreenPage from(int index) {
            SignupScreenPage signupScreenPage;
            SignupScreenPage[] values = SignupScreenPage.values();
            int length = values.length;
            int i5 = 0;
            while (true) {
                if (i5 >= length) {
                    signupScreenPage = null;
                    break;
                }
                signupScreenPage = values[i5];
                if (signupScreenPage.getIndex() == index) {
                    break;
                }
                i5++;
            }
            if (signupScreenPage != null) {
                return signupScreenPage;
            }
            throw new IllegalArgumentException("No SignupScreenPage for position " + index);
        }

        private Companion() {
        }
    }

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[SignupScreenPage.values().length];
            try {
                iArr[SignupScreenPage.Name.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SignupScreenPage.AdditionalInfo.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[SignupScreenPage.Contact.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[SignupScreenPage.PasswordAndTerms.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private static final /* synthetic */ SignupScreenPage[] $values() {
        return new SignupScreenPage[]{Name, AdditionalInfo, Contact, PasswordAndTerms};
    }

    static {
        SignupScreenPage[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
        INSTANCE = new Companion(null);
    }

    private SignupScreenPage(String str, int i5, int i6) {
        this.index = i6;
    }

    public static SignupScreenPage valueOf(String str) {
        return (SignupScreenPage) Enum.valueOf(SignupScreenPage.class, str);
    }

    public static SignupScreenPage[] values() {
        return (SignupScreenPage[]) $VALUES.clone();
    }

    public final int getIndex() {
        return this.index;
    }

    public final int getPageButtonText() {
        int i5 = WhenMappings.$EnumSwitchMapping$0[ordinal()];
        if (i5 == 1 || i5 == 2 || i5 == 3) {
            return R.string.checkout_buttonBar_proceed;
        }
        if (i5 == 4) {
            return R.string.createProfile_cta;
        }
        throw new NoWhenBranchMatchedException();
    }

    public final boolean isFirstPage() {
        return this == Name;
    }
}
