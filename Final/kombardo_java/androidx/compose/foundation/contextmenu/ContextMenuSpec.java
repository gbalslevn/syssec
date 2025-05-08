package androidx.compose.foundation.contextmenu;

import androidx.compose.ui.Alignment;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\bR\u001d\u0010\u000b\u001a\u00020\n8\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001d\u0010\u000f\u001a\u00020\n8\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u000f\u0010\f\u001a\u0004\b\u0010\u0010\u000eR\u001d\u0010\u0011\u001a\u00020\n8\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u0012\u0010\u000eR\u001d\u0010\u0013\u001a\u00020\n8\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0013\u0010\f\u001a\u0004\b\u0014\u0010\u000eR\u001d\u0010\u0015\u001a\u00020\n8\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u0015\u0010\f\u001a\u0004\b\u0016\u0010\u000eR\u0017\u0010\u0018\u001a\u00020\u00178\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001d\u0010\u001d\u001a\u00020\u001c8\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u001d\u0010!\u001a\u00020\n8\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b!\u0010\f\u001a\u0004\b\"\u0010\u000eR\u001d\u0010#\u001a\u00020\n8\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b#\u0010\f\u001a\u0004\b$\u0010\u000eR\u001d\u0010%\u001a\u00020\n8\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b%\u0010\f\u001a\u0004\b&\u0010\u000eR\u001d\u0010(\u001a\u00020'8\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+R\u0017\u0010-\u001a\u00020,8\u0006¢\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u00100R\u001d\u00101\u001a\u00020'8\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b1\u0010)\u001a\u0004\b2\u0010+R\u001d\u00103\u001a\u00020'8\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\f\n\u0004\b3\u0010)\u001a\u0004\b4\u0010+\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u00065"}, d2 = {"Landroidx/compose/foundation/contextmenu/ContextMenuSpec;", BuildConfig.FLAVOR, "<init>", "()V", "Landroidx/compose/ui/graphics/Color;", "color", "Landroidx/compose/ui/text/TextStyle;", "textStyle-8_81llA", "(J)Landroidx/compose/ui/text/TextStyle;", "textStyle", "Landroidx/compose/ui/unit/Dp;", "ContainerWidthMin", "F", "getContainerWidthMin-D9Ej5fM", "()F", "ContainerWidthMax", "getContainerWidthMax-D9Ej5fM", "ListItemHeight", "getListItemHeight-D9Ej5fM", "MenuContainerElevation", "getMenuContainerElevation-D9Ej5fM", "CornerRadius", "getCornerRadius-D9Ej5fM", "Landroidx/compose/ui/Alignment$Vertical;", "LabelVerticalTextAlignment", "Landroidx/compose/ui/Alignment$Vertical;", "getLabelVerticalTextAlignment", "()Landroidx/compose/ui/Alignment$Vertical;", "Landroidx/compose/ui/text/style/TextAlign;", "LabelHorizontalTextAlignment", "I", "getLabelHorizontalTextAlignment-e0LSkKk", "()I", "HorizontalPadding", "getHorizontalPadding-D9Ej5fM", "VerticalPadding", "getVerticalPadding-D9Ej5fM", "IconSize", "getIconSize-D9Ej5fM", "Landroidx/compose/ui/unit/TextUnit;", "FontSize", "J", "getFontSize-XSAIIZE", "()J", "Landroidx/compose/ui/text/font/FontWeight;", "FontWeight", "Landroidx/compose/ui/text/font/FontWeight;", "getFontWeight", "()Landroidx/compose/ui/text/font/FontWeight;", "LineHeight", "getLineHeight-XSAIIZE", "LetterSpacing", "getLetterSpacing-XSAIIZE", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ContextMenuSpec {
    public static final ContextMenuSpec INSTANCE = new ContextMenuSpec();
    private static final float ContainerWidthMin = Dp.m2599constructorimpl(112);
    private static final float ContainerWidthMax = Dp.m2599constructorimpl(280);
    private static final float ListItemHeight = Dp.m2599constructorimpl(48);
    private static final float MenuContainerElevation = Dp.m2599constructorimpl(3);
    private static final float CornerRadius = Dp.m2599constructorimpl(4);
    private static final Alignment.Vertical LabelVerticalTextAlignment = Alignment.INSTANCE.getCenterVertically();
    private static final int LabelHorizontalTextAlignment = TextAlign.INSTANCE.m2533getStarte0LSkKk();
    private static final float HorizontalPadding = Dp.m2599constructorimpl(12);
    private static final float VerticalPadding = Dp.m2599constructorimpl(8);
    private static final float IconSize = Dp.m2599constructorimpl(24);
    private static final long FontSize = TextUnitKt.getSp(14);
    private static final FontWeight FontWeight = FontWeight.INSTANCE.getMedium();
    private static final long LineHeight = TextUnitKt.getSp(20);
    private static final long LetterSpacing = TextUnitKt.getSp(0.1f);

    private ContextMenuSpec() {
    }

    /* renamed from: getContainerWidthMax-D9Ej5fM, reason: not valid java name */
    public final float m156getContainerWidthMaxD9Ej5fM() {
        return ContainerWidthMax;
    }

    /* renamed from: getContainerWidthMin-D9Ej5fM, reason: not valid java name */
    public final float m157getContainerWidthMinD9Ej5fM() {
        return ContainerWidthMin;
    }

    /* renamed from: getCornerRadius-D9Ej5fM, reason: not valid java name */
    public final float m158getCornerRadiusD9Ej5fM() {
        return CornerRadius;
    }

    /* renamed from: getHorizontalPadding-D9Ej5fM, reason: not valid java name */
    public final float m159getHorizontalPaddingD9Ej5fM() {
        return HorizontalPadding;
    }

    /* renamed from: getIconSize-D9Ej5fM, reason: not valid java name */
    public final float m160getIconSizeD9Ej5fM() {
        return IconSize;
    }

    public final Alignment.Vertical getLabelVerticalTextAlignment() {
        return LabelVerticalTextAlignment;
    }

    /* renamed from: getListItemHeight-D9Ej5fM, reason: not valid java name */
    public final float m161getListItemHeightD9Ej5fM() {
        return ListItemHeight;
    }

    /* renamed from: getMenuContainerElevation-D9Ej5fM, reason: not valid java name */
    public final float m162getMenuContainerElevationD9Ej5fM() {
        return MenuContainerElevation;
    }

    /* renamed from: getVerticalPadding-D9Ej5fM, reason: not valid java name */
    public final float m163getVerticalPaddingD9Ej5fM() {
        return VerticalPadding;
    }

    /* renamed from: textStyle-8_81llA, reason: not valid java name */
    public final TextStyle m164textStyle8_81llA(long color) {
        int i5 = LabelHorizontalTextAlignment;
        return new TextStyle(color, FontSize, FontWeight, null, null, null, null, LetterSpacing, null, null, null, 0L, null, null, null, i5, 0, LineHeight, null, null, null, 0, 0, null, 16613240, null);
    }
}
