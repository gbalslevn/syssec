package androidx.compose.material;

import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.style.LineHeightStyle;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u001b\u0010\u0003\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u0003\u0010\u0004\"\u001a\u0010\u0006\u001a\u00020\u00058\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u001a\u0010\n\u001a\u00020\u00008\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\" \u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Landroidx/compose/ui/text/TextStyle;", "Landroidx/compose/ui/text/font/FontFamily;", "default", "withDefaultFontFamily", "(Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/font/FontFamily;)Landroidx/compose/ui/text/TextStyle;", "Landroidx/compose/ui/text/style/LineHeightStyle;", "DefaultLineHeightStyle", "Landroidx/compose/ui/text/style/LineHeightStyle;", "getDefaultLineHeightStyle", "()Landroidx/compose/ui/text/style/LineHeightStyle;", "DefaultTextStyle", "Landroidx/compose/ui/text/TextStyle;", "getDefaultTextStyle", "()Landroidx/compose/ui/text/TextStyle;", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Landroidx/compose/material/Typography;", "LocalTypography", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "getLocalTypography", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "material_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class TypographyKt {
    private static final LineHeightStyle DefaultLineHeightStyle;
    private static final TextStyle DefaultTextStyle;
    private static final ProvidableCompositionLocal<Typography> LocalTypography;

    static {
        TextStyle m2295copyp1EtxEg;
        LineHeightStyle lineHeightStyle = new LineHeightStyle(LineHeightStyle.Alignment.INSTANCE.m2511getCenterPIaL0Z0(), LineHeightStyle.Trim.INSTANCE.m2520getNoneEVpEnUU(), null);
        DefaultLineHeightStyle = lineHeightStyle;
        m2295copyp1EtxEg = r0.m2295copyp1EtxEg((r48 & 1) != 0 ? r0.spanStyle.m2255getColor0d7_KjU() : 0L, (r48 & 2) != 0 ? r0.spanStyle.getFontSize() : 0L, (r48 & 4) != 0 ? r0.spanStyle.getFontWeight() : null, (r48 & 8) != 0 ? r0.spanStyle.getFontStyle() : null, (r48 & 16) != 0 ? r0.spanStyle.getFontSynthesis() : null, (r48 & 32) != 0 ? r0.spanStyle.getFontFamily() : null, (r48 & 64) != 0 ? r0.spanStyle.getFontFeatureSettings() : null, (r48 & 128) != 0 ? r0.spanStyle.getLetterSpacing() : 0L, (r48 & 256) != 0 ? r0.spanStyle.getBaselineShift() : null, (r48 & 512) != 0 ? r0.spanStyle.getTextGeometricTransform() : null, (r48 & 1024) != 0 ? r0.spanStyle.getLocaleList() : null, (r48 & 2048) != 0 ? r0.spanStyle.getBackground() : 0L, (r48 & 4096) != 0 ? r0.spanStyle.getTextDecoration() : null, (r48 & 8192) != 0 ? r0.spanStyle.getShadow() : null, (r48 & 16384) != 0 ? r0.spanStyle.getDrawStyle() : null, (r48 & 32768) != 0 ? r0.paragraphStyle.getTextAlign() : 0, (r48 & 65536) != 0 ? r0.paragraphStyle.getTextDirection() : 0, (r48 & 131072) != 0 ? r0.paragraphStyle.getLineHeight() : 0L, (r48 & 262144) != 0 ? r0.paragraphStyle.getTextIndent() : null, (r48 & 524288) != 0 ? r0.platformStyle : DefaultPlatformTextStyle_androidKt.defaultPlatformTextStyle(), (r48 & 1048576) != 0 ? r0.paragraphStyle.getLineHeightStyle() : lineHeightStyle, (r48 & 2097152) != 0 ? r0.paragraphStyle.getLineBreak() : 0, (r48 & 4194304) != 0 ? r0.paragraphStyle.getHyphens() : 0, (r48 & 8388608) != 0 ? TextStyle.INSTANCE.getDefault().paragraphStyle.getTextMotion() : null);
        DefaultTextStyle = m2295copyp1EtxEg;
        LocalTypography = CompositionLocalKt.staticCompositionLocalOf(new Function0<Typography>() { // from class: androidx.compose.material.TypographyKt$LocalTypography$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Typography invoke() {
                return new Typography(null, null, null, null, null, null, null, null, null, null, null, null, null, null, 16383, null);
            }
        });
    }

    public static final /* synthetic */ TextStyle access$withDefaultFontFamily(TextStyle textStyle, FontFamily fontFamily) {
        return withDefaultFontFamily(textStyle, fontFamily);
    }

    public static final TextStyle getDefaultTextStyle() {
        return DefaultTextStyle;
    }

    public static final ProvidableCompositionLocal<Typography> getLocalTypography() {
        return LocalTypography;
    }

    public static final TextStyle withDefaultFontFamily(TextStyle textStyle, FontFamily fontFamily) {
        TextStyle m2295copyp1EtxEg;
        if (textStyle.getFontFamily() != null) {
            return textStyle;
        }
        m2295copyp1EtxEg = textStyle.m2295copyp1EtxEg((r48 & 1) != 0 ? textStyle.spanStyle.m2255getColor0d7_KjU() : 0L, (r48 & 2) != 0 ? textStyle.spanStyle.getFontSize() : 0L, (r48 & 4) != 0 ? textStyle.spanStyle.getFontWeight() : null, (r48 & 8) != 0 ? textStyle.spanStyle.getFontStyle() : null, (r48 & 16) != 0 ? textStyle.spanStyle.getFontSynthesis() : null, (r48 & 32) != 0 ? textStyle.spanStyle.getFontFamily() : fontFamily, (r48 & 64) != 0 ? textStyle.spanStyle.getFontFeatureSettings() : null, (r48 & 128) != 0 ? textStyle.spanStyle.getLetterSpacing() : 0L, (r48 & 256) != 0 ? textStyle.spanStyle.getBaselineShift() : null, (r48 & 512) != 0 ? textStyle.spanStyle.getTextGeometricTransform() : null, (r48 & 1024) != 0 ? textStyle.spanStyle.getLocaleList() : null, (r48 & 2048) != 0 ? textStyle.spanStyle.getBackground() : 0L, (r48 & 4096) != 0 ? textStyle.spanStyle.getTextDecoration() : null, (r48 & 8192) != 0 ? textStyle.spanStyle.getShadow() : null, (r48 & 16384) != 0 ? textStyle.spanStyle.getDrawStyle() : null, (r48 & 32768) != 0 ? textStyle.paragraphStyle.getTextAlign() : 0, (r48 & 65536) != 0 ? textStyle.paragraphStyle.getTextDirection() : 0, (r48 & 131072) != 0 ? textStyle.paragraphStyle.getLineHeight() : 0L, (r48 & 262144) != 0 ? textStyle.paragraphStyle.getTextIndent() : null, (r48 & 524288) != 0 ? textStyle.platformStyle : null, (r48 & 1048576) != 0 ? textStyle.paragraphStyle.getLineHeightStyle() : null, (r48 & 2097152) != 0 ? textStyle.paragraphStyle.getLineBreak() : 0, (r48 & 4194304) != 0 ? textStyle.paragraphStyle.getHyphens() : 0, (r48 & 8388608) != 0 ? textStyle.paragraphStyle.getTextMotion() : null);
        return m2295copyp1EtxEg;
    }
}
