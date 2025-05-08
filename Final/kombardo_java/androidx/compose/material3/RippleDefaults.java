package androidx.compose.material3;

import androidx.compose.material.ripple.RippleAlpha;
import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Landroidx/compose/material3/RippleDefaults;", BuildConfig.FLAVOR, "()V", "RippleAlpha", "Landroidx/compose/material/ripple/RippleAlpha;", "getRippleAlpha", "()Landroidx/compose/material/ripple/RippleAlpha;", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class RippleDefaults {
    public static final RippleDefaults INSTANCE = new RippleDefaults();
    private static final RippleAlpha RippleAlpha = new RippleAlpha(0.16f, 0.1f, 0.08f, 0.1f);

    private RippleDefaults() {
    }

    public final RippleAlpha getRippleAlpha() {
        return RippleAlpha;
    }
}
