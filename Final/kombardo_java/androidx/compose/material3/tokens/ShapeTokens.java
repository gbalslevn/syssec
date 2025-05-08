package androidx.compose.material3.tokens;

import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0007\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\t\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\t\u0010\u0006\u001a\u0004\b\n\u0010\bR\u0017\u0010\u000b\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0006\u001a\u0004\b\f\u0010\bR\u0017\u0010\r\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\r\u0010\u0006\u001a\u0004\b\u000e\u0010\bR\u0017\u0010\u000f\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0006\u001a\u0004\b\u0010\u0010\bR\u0017\u0010\u0011\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0006\u001a\u0004\b\u0012\u0010\bR\u0017\u0010\u0013\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0006\u001a\u0004\b\u0014\u0010\bR\u0017\u0010\u0015\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0006\u001a\u0004\b\u0016\u0010\bR\u0017\u0010\u0017\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0006\u001a\u0004\b\u0018\u0010\bR\u0017\u0010\u001a\u001a\u00020\u00198\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0017\u0010\u001e\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u0006\u001a\u0004\b\u001f\u0010\b¨\u0006 "}, d2 = {"Landroidx/compose/material3/tokens/ShapeTokens;", BuildConfig.FLAVOR, "<init>", "()V", "Landroidx/compose/foundation/shape/RoundedCornerShape;", "CornerExtraLarge", "Landroidx/compose/foundation/shape/RoundedCornerShape;", "getCornerExtraLarge", "()Landroidx/compose/foundation/shape/RoundedCornerShape;", "CornerExtraLargeTop", "getCornerExtraLargeTop", "CornerExtraSmall", "getCornerExtraSmall", "CornerExtraSmallTop", "getCornerExtraSmallTop", "CornerFull", "getCornerFull", "CornerLarge", "getCornerLarge", "CornerLargeEnd", "getCornerLargeEnd", "CornerLargeTop", "getCornerLargeTop", "CornerMedium", "getCornerMedium", "Landroidx/compose/ui/graphics/Shape;", "CornerNone", "Landroidx/compose/ui/graphics/Shape;", "getCornerNone", "()Landroidx/compose/ui/graphics/Shape;", "CornerSmall", "getCornerSmall", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ShapeTokens {
    private static final RoundedCornerShape CornerExtraLarge;
    private static final RoundedCornerShape CornerExtraLargeTop;
    private static final RoundedCornerShape CornerExtraSmall;
    private static final RoundedCornerShape CornerExtraSmallTop;
    private static final RoundedCornerShape CornerLarge;
    private static final RoundedCornerShape CornerLargeEnd;
    private static final RoundedCornerShape CornerLargeTop;
    public static final ShapeTokens INSTANCE = new ShapeTokens();
    private static final RoundedCornerShape CornerFull = RoundedCornerShapeKt.getCircleShape();
    private static final RoundedCornerShape CornerMedium = RoundedCornerShapeKt.m460RoundedCornerShape0680j_4(Dp.m2599constructorimpl((float) 12.0d));
    private static final Shape CornerNone = RectangleShapeKt.getRectangleShape();
    private static final RoundedCornerShape CornerSmall = RoundedCornerShapeKt.m460RoundedCornerShape0680j_4(Dp.m2599constructorimpl((float) 8.0d));

    static {
        float f5 = (float) 28.0d;
        CornerExtraLarge = RoundedCornerShapeKt.m460RoundedCornerShape0680j_4(Dp.m2599constructorimpl(f5));
        float f6 = (float) 0.0d;
        CornerExtraLargeTop = RoundedCornerShapeKt.m461RoundedCornerShapea9UjIt4(Dp.m2599constructorimpl(f5), Dp.m2599constructorimpl(f5), Dp.m2599constructorimpl(f6), Dp.m2599constructorimpl(f6));
        float f7 = (float) 4.0d;
        CornerExtraSmall = RoundedCornerShapeKt.m460RoundedCornerShape0680j_4(Dp.m2599constructorimpl(f7));
        CornerExtraSmallTop = RoundedCornerShapeKt.m461RoundedCornerShapea9UjIt4(Dp.m2599constructorimpl(f7), Dp.m2599constructorimpl(f7), Dp.m2599constructorimpl(f6), Dp.m2599constructorimpl(f6));
        float f8 = (float) 16.0d;
        CornerLarge = RoundedCornerShapeKt.m460RoundedCornerShape0680j_4(Dp.m2599constructorimpl(f8));
        CornerLargeEnd = RoundedCornerShapeKt.m461RoundedCornerShapea9UjIt4(Dp.m2599constructorimpl(f6), Dp.m2599constructorimpl(f8), Dp.m2599constructorimpl(f8), Dp.m2599constructorimpl(f6));
        CornerLargeTop = RoundedCornerShapeKt.m461RoundedCornerShapea9UjIt4(Dp.m2599constructorimpl(f8), Dp.m2599constructorimpl(f8), Dp.m2599constructorimpl(f6), Dp.m2599constructorimpl(f6));
    }

    private ShapeTokens() {
    }

    public final RoundedCornerShape getCornerExtraLarge() {
        return CornerExtraLarge;
    }

    public final RoundedCornerShape getCornerExtraSmall() {
        return CornerExtraSmall;
    }

    public final RoundedCornerShape getCornerLarge() {
        return CornerLarge;
    }

    public final RoundedCornerShape getCornerMedium() {
        return CornerMedium;
    }

    public final RoundedCornerShape getCornerSmall() {
        return CornerSmall;
    }
}
