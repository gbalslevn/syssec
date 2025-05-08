package androidx.compose.material3.tokens;

import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\t\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\t\u0010\u0006\u001a\u0004\b\n\u0010\bR\u0017\u0010\u000b\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0006\u001a\u0004\b\f\u0010\bR\u0017\u0010\u000e\u001a\u00020\r8\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0013\u001a\u00020\u00128\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001d\u0010\u0018\u001a\u00020\u00178\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0017\u0010\u001c\u001a\u00020\u00128\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u0014\u001a\u0004\b\u001d\u0010\u0016R\u001d\u0010\u001e\u001a\u00020\u00178\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u001e\u0010\u0019\u001a\u0004\b\u001f\u0010\u001b\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006 "}, d2 = {"Landroidx/compose/material3/tokens/BadgeTokens;", BuildConfig.FLAVOR, "<init>", "()V", "Landroidx/compose/material3/tokens/ColorSchemeKeyTokens;", "Color", "Landroidx/compose/material3/tokens/ColorSchemeKeyTokens;", "getColor", "()Landroidx/compose/material3/tokens/ColorSchemeKeyTokens;", "LargeColor", "getLargeColor", "LargeLabelTextColor", "getLargeLabelTextColor", "Landroidx/compose/material3/tokens/TypographyKeyTokens;", "LargeLabelTextFont", "Landroidx/compose/material3/tokens/TypographyKeyTokens;", "getLargeLabelTextFont", "()Landroidx/compose/material3/tokens/TypographyKeyTokens;", "Landroidx/compose/material3/tokens/ShapeKeyTokens;", "LargeShape", "Landroidx/compose/material3/tokens/ShapeKeyTokens;", "getLargeShape", "()Landroidx/compose/material3/tokens/ShapeKeyTokens;", "Landroidx/compose/ui/unit/Dp;", "LargeSize", "F", "getLargeSize-D9Ej5fM", "()F", "Shape", "getShape", "Size", "getSize-D9Ej5fM", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class BadgeTokens {
    private static final ColorSchemeKeyTokens Color;
    public static final BadgeTokens INSTANCE = new BadgeTokens();
    private static final ColorSchemeKeyTokens LargeColor;
    private static final ColorSchemeKeyTokens LargeLabelTextColor;
    private static final TypographyKeyTokens LargeLabelTextFont;
    private static final ShapeKeyTokens LargeShape;
    private static final float LargeSize;
    private static final ShapeKeyTokens Shape;
    private static final float Size;

    static {
        ColorSchemeKeyTokens colorSchemeKeyTokens = ColorSchemeKeyTokens.Error;
        Color = colorSchemeKeyTokens;
        LargeColor = colorSchemeKeyTokens;
        LargeLabelTextColor = ColorSchemeKeyTokens.OnError;
        LargeLabelTextFont = TypographyKeyTokens.LabelSmall;
        ShapeKeyTokens shapeKeyTokens = ShapeKeyTokens.CornerFull;
        LargeShape = shapeKeyTokens;
        LargeSize = Dp.m2599constructorimpl((float) 16.0d);
        Shape = shapeKeyTokens;
        Size = Dp.m2599constructorimpl((float) 6.0d);
    }

    private BadgeTokens() {
    }

    public final ColorSchemeKeyTokens getColor() {
        return Color;
    }

    public final TypographyKeyTokens getLargeLabelTextFont() {
        return LargeLabelTextFont;
    }

    public final ShapeKeyTokens getLargeShape() {
        return LargeShape;
    }

    /* renamed from: getLargeSize-D9Ej5fM, reason: not valid java name */
    public final float m1003getLargeSizeD9Ej5fM() {
        return LargeSize;
    }

    public final ShapeKeyTokens getShape() {
        return Shape;
    }

    /* renamed from: getSize-D9Ej5fM, reason: not valid java name */
    public final float m1004getSizeD9Ej5fM() {
        return Size;
    }
}
