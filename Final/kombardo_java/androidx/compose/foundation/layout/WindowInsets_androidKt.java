package androidx.compose.foundation.layout;

import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.core.graphics.Insets;
import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\u001a\u0013\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0005H\u0000¢\u0006\u0004\b\b\u0010\t\"\u0015\u0010\u000e\u001a\u00020\u000b*\u00020\n8G¢\u0006\u0006\u001a\u0004\b\f\u0010\r\"\u001e\u0010\u0010\u001a\u00020\u000f*\u00020\n8GX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0014"}, d2 = {"Landroidx/core/graphics/Insets;", "Landroidx/compose/foundation/layout/InsetsValues;", "toInsetsValues", "(Landroidx/core/graphics/Insets;)Landroidx/compose/foundation/layout/InsetsValues;", "insets", BuildConfig.FLAVOR, "name", "Landroidx/compose/foundation/layout/ValueInsets;", "ValueInsets", "(Landroidx/core/graphics/Insets;Ljava/lang/String;)Landroidx/compose/foundation/layout/ValueInsets;", "Landroidx/compose/foundation/layout/WindowInsets$Companion;", "Landroidx/compose/foundation/layout/WindowInsets;", "getSystemBars", "(Landroidx/compose/foundation/layout/WindowInsets$Companion;Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/layout/WindowInsets;", "systemBars", BuildConfig.FLAVOR, "isImeVisible", "(Landroidx/compose/foundation/layout/WindowInsets$Companion;Landroidx/compose/runtime/Composer;I)Z", "isImeVisible$annotations", "(Landroidx/compose/foundation/layout/WindowInsets$Companion;)V", "foundation-layout_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class WindowInsets_androidKt {
    public static final ValueInsets ValueInsets(Insets insets, String str) {
        return new ValueInsets(toInsetsValues(insets), str);
    }

    public static final WindowInsets getSystemBars(WindowInsets.Companion companion, Composer composer, int i5) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-282936756, i5, -1, "androidx.compose.foundation.layout.<get-systemBars> (WindowInsets.android.kt:200)");
        }
        AndroidWindowInsets systemBars = WindowInsetsHolder.INSTANCE.current(composer, 6).getSystemBars();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return systemBars;
    }

    public static final boolean isImeVisible(WindowInsets.Companion companion, Composer composer, int i5) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1873571424, i5, -1, "androidx.compose.foundation.layout.<get-isImeVisible> (WindowInsets.android.kt:342)");
        }
        boolean isVisible = WindowInsetsHolder.INSTANCE.current(composer, 6).getIme().isVisible();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return isVisible;
    }

    public static final InsetsValues toInsetsValues(Insets insets) {
        return new InsetsValues(insets.left, insets.top, insets.right, insets.bottom);
    }
}
