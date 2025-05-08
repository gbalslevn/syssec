package androidx.compose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J:\u0010\f\u001a\u00020\t2\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u0004H\u0007ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000b\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\r"}, d2 = {"Landroidx/compose/material/FloatingActionButtonDefaults;", BuildConfig.FLAVOR, "<init>", "()V", "Landroidx/compose/ui/unit/Dp;", "defaultElevation", "pressedElevation", "hoveredElevation", "focusedElevation", "Landroidx/compose/material/FloatingActionButtonElevation;", "elevation-xZ9-QkE", "(FFFFLandroidx/compose/runtime/Composer;II)Landroidx/compose/material/FloatingActionButtonElevation;", "elevation", "material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class FloatingActionButtonDefaults {
    public static final FloatingActionButtonDefaults INSTANCE = new FloatingActionButtonDefaults();

    private FloatingActionButtonDefaults() {
    }

    /* renamed from: elevation-xZ9-QkE, reason: not valid java name */
    public final FloatingActionButtonElevation m702elevationxZ9QkE(float f5, float f6, float f7, float f8, Composer composer, int i5, int i6) {
        if ((i6 & 1) != 0) {
            f5 = Dp.m2599constructorimpl(6);
        }
        float f9 = f5;
        if ((i6 & 2) != 0) {
            f6 = Dp.m2599constructorimpl(12);
        }
        float f10 = f6;
        if ((i6 & 4) != 0) {
            f7 = Dp.m2599constructorimpl(8);
        }
        float f11 = f7;
        if ((i6 & 8) != 0) {
            f8 = Dp.m2599constructorimpl(8);
        }
        float f12 = f8;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(380403812, i5, -1, "androidx.compose.material.FloatingActionButtonDefaults.elevation (FloatingActionButton.kt:248)");
        }
        boolean z5 = ((((i5 & 14) ^ 6) > 4 && composer.changed(f9)) || (i5 & 6) == 4) | ((((i5 & 112) ^ 48) > 32 && composer.changed(f10)) || (i5 & 48) == 32) | ((((i5 & 896) ^ 384) > 256 && composer.changed(f11)) || (i5 & 384) == 256) | ((((i5 & 7168) ^ 3072) > 2048 && composer.changed(f12)) || (i5 & 3072) == 2048);
        Object rememberedValue = composer.rememberedValue();
        if (z5 || rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = new DefaultFloatingActionButtonElevation(f9, f10, f11, f12, null);
            composer.updateRememberedValue(rememberedValue);
        }
        DefaultFloatingActionButtonElevation defaultFloatingActionButtonElevation = (DefaultFloatingActionButtonElevation) rememberedValue;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return defaultFloatingActionButtonElevation;
    }
}
