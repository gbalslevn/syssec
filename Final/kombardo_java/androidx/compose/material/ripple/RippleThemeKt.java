package androidx.compose.material.ripple;

import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\"&\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00008\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u0002\u0010\u0003\u0012\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0004\u0010\u0005\"\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n\"\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\n\"\u0014\u0010\f\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\n\"\u0014\u0010\u000e\u001a\u00020\r8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Landroidx/compose/runtime/ProvidableCompositionLocal;", "Landroidx/compose/material/ripple/RippleTheme;", "LocalRippleTheme", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "getLocalRippleTheme", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "getLocalRippleTheme$annotations", "()V", "Landroidx/compose/material/ripple/RippleAlpha;", "LightThemeHighContrastRippleAlpha", "Landroidx/compose/material/ripple/RippleAlpha;", "LightThemeLowContrastRippleAlpha", "DarkThemeRippleAlpha", BuildConfig.FLAVOR, "RippleThemeDeprecationMessage", "Ljava/lang/String;", "material-ripple_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class RippleThemeKt {
    private static final String RippleThemeDeprecationMessage = "RippleTheme and LocalRippleTheme have been deprecated - they are not compatible with the new ripple implementation using the new Indication APIs that provide notable performance improvements. For a migration guide and background information, please visit developer.android.com";
    private static final ProvidableCompositionLocal<RippleTheme> LocalRippleTheme = CompositionLocalKt.staticCompositionLocalOf(new Function0<RippleTheme>() { // from class: androidx.compose.material.ripple.RippleThemeKt$LocalRippleTheme$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final RippleTheme invoke() {
            return DebugRippleTheme.INSTANCE;
        }
    });
    private static final RippleAlpha LightThemeHighContrastRippleAlpha = new RippleAlpha(0.16f, 0.24f, 0.08f, 0.24f);
    private static final RippleAlpha LightThemeLowContrastRippleAlpha = new RippleAlpha(0.08f, 0.12f, 0.04f, 0.12f);
    private static final RippleAlpha DarkThemeRippleAlpha = new RippleAlpha(0.08f, 0.12f, 0.04f, 0.1f);

    public static final ProvidableCompositionLocal<RippleTheme> getLocalRippleTheme() {
        return LocalRippleTheme;
    }
}
