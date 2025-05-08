package androidx.compose.material3.tokens;

import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u000f\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u001d\u0010\n\u001a\u00020\t8\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u000e\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u0006\u001a\u0004\b\u000f\u0010\bR\u0017\u0010\u0010\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0006\u001a\u0004\b\u0011\u0010\bR\u0017\u0010\u0012\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0006\u001a\u0004\b\u0013\u0010\bR\u0017\u0010\u0014\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0006\u001a\u0004\b\u0015\u0010\bR\u0017\u0010\u0017\u001a\u00020\u00168\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001d\u0010\u001b\u001a\u00020\t8\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u001b\u0010\u000b\u001a\u0004\b\u001c\u0010\rR\u0017\u0010\u001d\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u0006\u001a\u0004\b\u001e\u0010\bR\u0017\u0010\u001f\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u001f\u0010\u0006\u001a\u0004\b \u0010\bR\u0017\u0010!\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b!\u0010\u0006\u001a\u0004\b\"\u0010\bR\u0017\u0010#\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b#\u0010\u0006\u001a\u0004\b$\u0010\b\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006%"}, d2 = {"Landroidx/compose/material3/tokens/IconButtonTokens;", BuildConfig.FLAVOR, "<init>", "()V", "Landroidx/compose/material3/tokens/ColorSchemeKeyTokens;", "DisabledIconColor", "Landroidx/compose/material3/tokens/ColorSchemeKeyTokens;", "getDisabledIconColor", "()Landroidx/compose/material3/tokens/ColorSchemeKeyTokens;", "Landroidx/compose/ui/unit/Dp;", "IconSize", "F", "getIconSize-D9Ej5fM", "()F", "SelectedFocusIconColor", "getSelectedFocusIconColor", "SelectedHoverIconColor", "getSelectedHoverIconColor", "SelectedIconColor", "getSelectedIconColor", "SelectedPressedIconColor", "getSelectedPressedIconColor", "Landroidx/compose/material3/tokens/ShapeKeyTokens;", "StateLayerShape", "Landroidx/compose/material3/tokens/ShapeKeyTokens;", "getStateLayerShape", "()Landroidx/compose/material3/tokens/ShapeKeyTokens;", "StateLayerSize", "getStateLayerSize-D9Ej5fM", "UnselectedFocusIconColor", "getUnselectedFocusIconColor", "UnselectedHoverIconColor", "getUnselectedHoverIconColor", "UnselectedIconColor", "getUnselectedIconColor", "UnselectedPressedIconColor", "getUnselectedPressedIconColor", "material3_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class IconButtonTokens {
    private static final ColorSchemeKeyTokens SelectedFocusIconColor;
    private static final ColorSchemeKeyTokens SelectedHoverIconColor;
    private static final ColorSchemeKeyTokens SelectedIconColor;
    private static final ColorSchemeKeyTokens SelectedPressedIconColor;
    private static final ShapeKeyTokens StateLayerShape;
    private static final float StateLayerSize;
    private static final ColorSchemeKeyTokens UnselectedFocusIconColor;
    private static final ColorSchemeKeyTokens UnselectedHoverIconColor;
    private static final ColorSchemeKeyTokens UnselectedIconColor;
    private static final ColorSchemeKeyTokens UnselectedPressedIconColor;
    public static final IconButtonTokens INSTANCE = new IconButtonTokens();
    private static final ColorSchemeKeyTokens DisabledIconColor = ColorSchemeKeyTokens.OnSurface;
    private static final float IconSize = Dp.m2599constructorimpl((float) 24.0d);

    static {
        ColorSchemeKeyTokens colorSchemeKeyTokens = ColorSchemeKeyTokens.Primary;
        SelectedFocusIconColor = colorSchemeKeyTokens;
        SelectedHoverIconColor = colorSchemeKeyTokens;
        SelectedIconColor = colorSchemeKeyTokens;
        SelectedPressedIconColor = colorSchemeKeyTokens;
        StateLayerShape = ShapeKeyTokens.CornerFull;
        StateLayerSize = Dp.m2599constructorimpl((float) 40.0d);
        ColorSchemeKeyTokens colorSchemeKeyTokens2 = ColorSchemeKeyTokens.OnSurfaceVariant;
        UnselectedFocusIconColor = colorSchemeKeyTokens2;
        UnselectedHoverIconColor = colorSchemeKeyTokens2;
        UnselectedIconColor = colorSchemeKeyTokens2;
        UnselectedPressedIconColor = colorSchemeKeyTokens2;
    }

    private IconButtonTokens() {
    }

    /* renamed from: getIconSize-D9Ej5fM, reason: not valid java name */
    public final float m1087getIconSizeD9Ej5fM() {
        return IconSize;
    }

    public final ShapeKeyTokens getStateLayerShape() {
        return StateLayerShape;
    }

    /* renamed from: getStateLayerSize-D9Ej5fM, reason: not valid java name */
    public final float m1088getStateLayerSizeD9Ej5fM() {
        return StateLayerSize;
    }
}
