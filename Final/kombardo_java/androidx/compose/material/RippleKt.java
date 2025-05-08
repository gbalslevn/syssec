package androidx.compose.material;

import androidx.compose.foundation.Indication;
import androidx.compose.foundation.IndicationNodeFactory;
import androidx.compose.material.ripple.RippleAlpha;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000B\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a0\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\b\u001a0\u0010\r\u001a\u00020\n2\b\b\u0002\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004H\u0001ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\f\"&\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00000\u000e8GX\u0087\u0004¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u0012\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012\"(\u0010\u0016\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00150\u000e8GX\u0087\u0004¢\u0006\u0012\n\u0004\b\u0016\u0010\u0010\u0012\u0004\b\u0018\u0010\u0014\u001a\u0004\b\u0017\u0010\u0012\"\u0014\u0010\u001a\u001a\u00020\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001b\"\u0014\u0010\u001c\u001a\u00020\u00198\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001b\"\u0014\u0010\u001e\u001a\u00020\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001f\"\u0014\u0010 \u001a\u00020\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010\u001f\"\u0014\u0010!\u001a\u00020\u001d8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\u001f\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\""}, d2 = {BuildConfig.FLAVOR, "bounded", "Landroidx/compose/ui/unit/Dp;", "radius", "Landroidx/compose/ui/graphics/Color;", "color", "Landroidx/compose/foundation/IndicationNodeFactory;", "ripple-H2RKhps", "(ZFJ)Landroidx/compose/foundation/IndicationNodeFactory;", "ripple", "Landroidx/compose/foundation/Indication;", "rippleOrFallbackImplementation-9IZ8Weo", "(ZFJLandroidx/compose/runtime/Composer;II)Landroidx/compose/foundation/Indication;", "rippleOrFallbackImplementation", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "LocalUseFallbackRippleImplementation", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "getLocalUseFallbackRippleImplementation", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "getLocalUseFallbackRippleImplementation$annotations", "()V", "Landroidx/compose/material/RippleConfiguration;", "LocalRippleConfiguration", "getLocalRippleConfiguration", "getLocalRippleConfiguration$annotations", "Landroidx/compose/material/RippleNodeFactory;", "DefaultBoundedRipple", "Landroidx/compose/material/RippleNodeFactory;", "DefaultUnboundedRipple", "Landroidx/compose/material/ripple/RippleAlpha;", "LightThemeHighContrastRippleAlpha", "Landroidx/compose/material/ripple/RippleAlpha;", "LightThemeLowContrastRippleAlpha", "DarkThemeRippleAlpha", "material_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class RippleKt {
    private static final RippleAlpha DarkThemeRippleAlpha;
    private static final RippleNodeFactory DefaultBoundedRipple;
    private static final RippleNodeFactory DefaultUnboundedRipple;
    private static final RippleAlpha LightThemeHighContrastRippleAlpha;
    private static final RippleAlpha LightThemeLowContrastRippleAlpha;
    private static final ProvidableCompositionLocal<Boolean> LocalUseFallbackRippleImplementation = CompositionLocalKt.staticCompositionLocalOf(new Function0<Boolean>() { // from class: androidx.compose.material.RippleKt$LocalUseFallbackRippleImplementation$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Boolean invoke() {
            return Boolean.FALSE;
        }
    });
    private static final ProvidableCompositionLocal<RippleConfiguration> LocalRippleConfiguration = CompositionLocalKt.compositionLocalOf$default(null, new Function0<RippleConfiguration>() { // from class: androidx.compose.material.RippleKt$LocalRippleConfiguration$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final RippleConfiguration invoke() {
            return new RippleConfiguration(0L, null, 3, null);
        }
    }, 1, null);

    static {
        Dp.Companion companion = Dp.INSTANCE;
        float m2608getUnspecifiedD9Ej5fM = companion.m2608getUnspecifiedD9Ej5fM();
        Color.Companion companion2 = Color.INSTANCE;
        DefaultBoundedRipple = new RippleNodeFactory(true, m2608getUnspecifiedD9Ej5fM, companion2.m1501getUnspecified0d7_KjU(), (DefaultConstructorMarker) null);
        DefaultUnboundedRipple = new RippleNodeFactory(false, companion.m2608getUnspecifiedD9Ej5fM(), companion2.m1501getUnspecified0d7_KjU(), (DefaultConstructorMarker) null);
        LightThemeHighContrastRippleAlpha = new RippleAlpha(0.16f, 0.24f, 0.08f, 0.24f);
        LightThemeLowContrastRippleAlpha = new RippleAlpha(0.08f, 0.12f, 0.04f, 0.12f);
        DarkThemeRippleAlpha = new RippleAlpha(0.08f, 0.12f, 0.04f, 0.1f);
    }

    public static final ProvidableCompositionLocal<RippleConfiguration> getLocalRippleConfiguration() {
        return LocalRippleConfiguration;
    }

    /* renamed from: ripple-H2RKhps, reason: not valid java name */
    public static final IndicationNodeFactory m717rippleH2RKhps(boolean z5, float f5, long j5) {
        return (Dp.m2601equalsimpl0(f5, Dp.INSTANCE.m2608getUnspecifiedD9Ej5fM()) && Color.m1487equalsimpl0(j5, Color.INSTANCE.m1501getUnspecified0d7_KjU())) ? z5 ? DefaultBoundedRipple : DefaultUnboundedRipple : new RippleNodeFactory(z5, f5, j5, (DefaultConstructorMarker) null);
    }

    /* renamed from: rippleOrFallbackImplementation-9IZ8Weo, reason: not valid java name */
    public static final Indication m718rippleOrFallbackImplementation9IZ8Weo(boolean z5, float f5, long j5, Composer composer, int i5, int i6) {
        Indication m717rippleH2RKhps;
        if ((i6 & 1) != 0) {
            z5 = true;
        }
        boolean z6 = z5;
        if ((i6 & 2) != 0) {
            f5 = Dp.INSTANCE.m2608getUnspecifiedD9Ej5fM();
        }
        float f6 = f5;
        if ((i6 & 4) != 0) {
            j5 = Color.INSTANCE.m1501getUnspecified0d7_KjU();
        }
        long j6 = j5;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-58830494, i5, -1, "androidx.compose.material.rippleOrFallbackImplementation (Ripple.kt:264)");
        }
        if (((Boolean) composer.consume(LocalUseFallbackRippleImplementation)).booleanValue()) {
            composer.startReplaceGroup(96412190);
            m717rippleH2RKhps = androidx.compose.material.ripple.RippleKt.m760rememberRipple9IZ8Weo(z6, f6, j6, composer, i5 & 1022, 0);
            composer.endReplaceGroup();
        } else {
            composer.startReplaceGroup(96503175);
            composer.endReplaceGroup();
            m717rippleH2RKhps = m717rippleH2RKhps(z6, f6, j6);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return m717rippleH2RKhps;
    }
}
