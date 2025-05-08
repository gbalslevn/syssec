package androidx.compose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import com.adjust.sdk.Constants;
import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\n\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J#\u0010\u0007\u001a\u00020\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0006\u001a\u00020\u0004H\u0003¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u000b\u001a\u00020\u00048G¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0011\u0010\r\u001a\u00020\u00048G¢\u0006\u0006\u001a\u0004\b\f\u0010\n¨\u0006\u000e"}, d2 = {"Landroidx/compose/material/ContentAlpha;", BuildConfig.FLAVOR, "<init>", "()V", BuildConfig.FLAVOR, "highContrastAlpha", "lowContrastAlpha", "contentAlpha", "(FFLandroidx/compose/runtime/Composer;I)F", "getHigh", "(Landroidx/compose/runtime/Composer;I)F", Constants.HIGH, "getDisabled", "disabled", "material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ContentAlpha {
    public static final int $stable = 0;
    public static final ContentAlpha INSTANCE = new ContentAlpha();

    private ContentAlpha() {
    }

    private final float contentAlpha(float f5, float f6, Composer composer, int i5) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1528360391, i5, -1, "androidx.compose.material.ContentAlpha.contentAlpha (ContentAlpha.kt:76)");
        }
        long value = ((Color) composer.consume(ContentColorKt.getLocalContentColor())).getValue();
        if (!MaterialTheme.INSTANCE.getColors(composer, 6).isLight() ? ColorKt.m1507luminance8_81llA(value) >= 0.5d : ColorKt.m1507luminance8_81llA(value) <= 0.5d) {
            f5 = f6;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return f5;
    }

    public final float getDisabled(Composer composer, int i5) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(621183615, i5, -1, "androidx.compose.material.ContentAlpha.<get-disabled> (ContentAlpha.kt:57)");
        }
        float contentAlpha = contentAlpha(0.38f, 0.38f, composer, ((i5 << 6) & 896) | 54);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return contentAlpha;
    }

    public final float getHigh(Composer composer, int i5) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(629162431, i5, -1, "androidx.compose.material.ContentAlpha.<get-high> (ContentAlpha.kt:35)");
        }
        float contentAlpha = contentAlpha(1.0f, 0.87f, composer, ((i5 << 6) & 896) | 54);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return contentAlpha;
    }
}
