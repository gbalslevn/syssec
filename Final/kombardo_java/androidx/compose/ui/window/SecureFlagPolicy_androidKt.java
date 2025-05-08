package androidx.compose.ui.window;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0001H\u0000¨\u0006\u0004"}, d2 = {"shouldApplySecureFlag", BuildConfig.FLAVOR, "Landroidx/compose/ui/window/SecureFlagPolicy;", "isSecureFlagSetOnParent", "ui_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class SecureFlagPolicy_androidKt {

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[SecureFlagPolicy.values().length];
            try {
                iArr[SecureFlagPolicy.SecureOff.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SecureFlagPolicy.SecureOn.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[SecureFlagPolicy.Inherit.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final boolean shouldApplySecureFlag(SecureFlagPolicy secureFlagPolicy, boolean z5) {
        int i5 = WhenMappings.$EnumSwitchMapping$0[secureFlagPolicy.ordinal()];
        if (i5 == 1) {
            return false;
        }
        if (i5 == 2) {
            return true;
        }
        if (i5 == 3) {
            return z5;
        }
        throw new NoWhenBranchMatchedException();
    }
}
