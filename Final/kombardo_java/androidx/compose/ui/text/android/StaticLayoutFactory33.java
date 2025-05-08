package androidx.compose.ui.text.android;

import android.graphics.text.LineBreakConfig;
import android.text.StaticLayout;
import kotlin.Metadata;
import org.conscrypt.BuildConfig;
import t.AbstractC0760B;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bÃ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J \u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0007¨\u0006\u000e"}, d2 = {"Landroidx/compose/ui/text/android/StaticLayoutFactory33;", BuildConfig.FLAVOR, "()V", "isFallbackLineSpacingEnabled", BuildConfig.FLAVOR, "layout", "Landroid/text/StaticLayout;", "setLineBreakConfig", BuildConfig.FLAVOR, "builder", "Landroid/text/StaticLayout$Builder;", "lineBreakStyle", BuildConfig.FLAVOR, "lineBreakWordStyle", "ui-text_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
final class StaticLayoutFactory33 {
    public static final StaticLayoutFactory33 INSTANCE = new StaticLayoutFactory33();

    private StaticLayoutFactory33() {
    }

    public static final boolean isFallbackLineSpacingEnabled(StaticLayout layout) {
        boolean isFallbackLineSpacingEnabled;
        isFallbackLineSpacingEnabled = layout.isFallbackLineSpacingEnabled();
        return isFallbackLineSpacingEnabled;
    }

    public static final void setLineBreakConfig(StaticLayout.Builder builder, int lineBreakStyle, int lineBreakWordStyle) {
        LineBreakConfig.Builder lineBreakStyle2;
        LineBreakConfig.Builder lineBreakWordStyle2;
        LineBreakConfig build;
        lineBreakStyle2 = AbstractC0760B.a().setLineBreakStyle(lineBreakStyle);
        lineBreakWordStyle2 = lineBreakStyle2.setLineBreakWordStyle(lineBreakWordStyle);
        build = lineBreakWordStyle2.build();
        builder.setLineBreakConfig(build);
    }
}
