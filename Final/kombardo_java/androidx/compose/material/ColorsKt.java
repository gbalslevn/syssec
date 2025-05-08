package androidx.compose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0088\u0001\u0010\u0010\u001a\u00020\r2\b\b\u0002\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0007\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u0000ø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000f\u001a\u001c\u0010\u0014\u001a\u00020\u0000*\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0000ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013\u001a\u001a\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u0000H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016\" \u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\r0\u00178\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u001c"}, d2 = {"Landroidx/compose/ui/graphics/Color;", "primary", "primaryVariant", "secondary", "secondaryVariant", "background", "surface", "error", "onPrimary", "onSecondary", "onBackground", "onSurface", "onError", "Landroidx/compose/material/Colors;", "lightColors-2qZNXz8", "(JJJJJJJJJJJJ)Landroidx/compose/material/Colors;", "lightColors", "backgroundColor", "contentColorFor-4WTKRHQ", "(Landroidx/compose/material/Colors;J)J", "contentColorFor", "contentColorFor-ek8zF_U", "(JLandroidx/compose/runtime/Composer;I)J", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "LocalColors", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "getLocalColors", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "material_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class ColorsKt {
    private static final ProvidableCompositionLocal<Colors> LocalColors = CompositionLocalKt.staticCompositionLocalOf(new Function0<Colors>() { // from class: androidx.compose.material.ColorsKt$LocalColors$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Colors invoke() {
            Colors m674lightColors2qZNXz8;
            m674lightColors2qZNXz8 = ColorsKt.m674lightColors2qZNXz8((r43 & 1) != 0 ? ColorKt.Color(4284612846L) : 0L, (r43 & 2) != 0 ? ColorKt.Color(4281794739L) : 0L, (r43 & 4) != 0 ? ColorKt.Color(4278442694L) : 0L, (r43 & 8) != 0 ? ColorKt.Color(4278290310L) : 0L, (r43 & 16) != 0 ? Color.INSTANCE.m1502getWhite0d7_KjU() : 0L, (r43 & 32) != 0 ? Color.INSTANCE.m1502getWhite0d7_KjU() : 0L, (r43 & 64) != 0 ? ColorKt.Color(4289724448L) : 0L, (r43 & 128) != 0 ? Color.INSTANCE.m1502getWhite0d7_KjU() : 0L, (r43 & 256) != 0 ? Color.INSTANCE.m1496getBlack0d7_KjU() : 0L, (r43 & 512) != 0 ? Color.INSTANCE.m1496getBlack0d7_KjU() : 0L, (r43 & 1024) != 0 ? Color.INSTANCE.m1496getBlack0d7_KjU() : 0L, (r43 & 2048) != 0 ? Color.INSTANCE.m1502getWhite0d7_KjU() : 0L);
            return m674lightColors2qZNXz8;
        }
    });

    /* renamed from: contentColorFor-4WTKRHQ, reason: not valid java name */
    public static final long m672contentColorFor4WTKRHQ(Colors colors, long j5) {
        if (!Color.m1487equalsimpl0(j5, colors.m667getPrimary0d7_KjU()) && !Color.m1487equalsimpl0(j5, colors.m668getPrimaryVariant0d7_KjU())) {
            if (!Color.m1487equalsimpl0(j5, colors.m669getSecondary0d7_KjU()) && !Color.m1487equalsimpl0(j5, colors.m670getSecondaryVariant0d7_KjU())) {
                return Color.m1487equalsimpl0(j5, colors.m660getBackground0d7_KjU()) ? colors.m662getOnBackground0d7_KjU() : Color.m1487equalsimpl0(j5, colors.m671getSurface0d7_KjU()) ? colors.m666getOnSurface0d7_KjU() : Color.m1487equalsimpl0(j5, colors.m661getError0d7_KjU()) ? colors.m663getOnError0d7_KjU() : Color.INSTANCE.m1501getUnspecified0d7_KjU();
            }
            return colors.m665getOnSecondary0d7_KjU();
        }
        return colors.m664getOnPrimary0d7_KjU();
    }

    /* renamed from: contentColorFor-ek8zF_U, reason: not valid java name */
    public static final long m673contentColorForek8zF_U(long j5, Composer composer, int i5) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(441849991, i5, -1, "androidx.compose.material.contentColorFor (Colors.kt:296)");
        }
        composer.startReplaceGroup(-702395103);
        long m672contentColorFor4WTKRHQ = m672contentColorFor4WTKRHQ(MaterialTheme.INSTANCE.getColors(composer, 6), j5);
        if (m672contentColorFor4WTKRHQ == 16) {
            m672contentColorFor4WTKRHQ = ((Color) composer.consume(ContentColorKt.getLocalContentColor())).getValue();
        }
        composer.endReplaceGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return m672contentColorFor4WTKRHQ;
    }

    public static final ProvidableCompositionLocal<Colors> getLocalColors() {
        return LocalColors;
    }

    /* renamed from: lightColors-2qZNXz8, reason: not valid java name */
    public static final Colors m674lightColors2qZNXz8(long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, long j13, long j14, long j15, long j16) {
        return new Colors(j5, j6, j7, j8, j9, j10, j11, j12, j13, j14, j15, j16, true, null);
    }
}
