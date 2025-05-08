package dk.molslinjen.ui.theme;

import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.Shapes;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0011\u0010\u0000\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"ThemeShapes", "Landroidx/compose/material3/Shapes;", "getThemeShapes", "()Landroidx/compose/material3/Shapes;", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class ThemeShapesKt {
    private static final Shapes ThemeShapes;

    static {
        float f5 = 4;
        float f6 = 15;
        ThemeShapes = new Shapes(RoundedCornerShapeKt.m460RoundedCornerShape0680j_4(Dp.m2599constructorimpl(f5)), RoundedCornerShapeKt.m460RoundedCornerShape0680j_4(Dp.m2599constructorimpl(f5)), RoundedCornerShapeKt.m460RoundedCornerShape0680j_4(Dp.m2599constructorimpl(8)), RoundedCornerShapeKt.m460RoundedCornerShape0680j_4(Dp.m2599constructorimpl(f6)), RoundedCornerShapeKt.m460RoundedCornerShape0680j_4(Dp.m2599constructorimpl(f6)));
    }

    public static final Shapes getThemeShapes() {
        return ThemeShapes;
    }
}
