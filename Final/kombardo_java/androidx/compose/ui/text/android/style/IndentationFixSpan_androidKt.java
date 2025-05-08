package androidx.compose.ui.text.android.style;

import android.graphics.Paint;
import android.text.Layout;
import androidx.compose.ui.text.android.TextLayout_androidKt;
import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001e\u0010\u0002\u001a\u00020\u0003*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bH\u0000\u001a\u001e\u0010\t\u001a\u00020\u0003*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bH\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"EllipsisChar", BuildConfig.FLAVOR, "getEllipsizedLeftPadding", BuildConfig.FLAVOR, "Landroid/text/Layout;", "lineIndex", BuildConfig.FLAVOR, "paint", "Landroid/graphics/Paint;", "getEllipsizedRightPadding", "ui-text_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class IndentationFixSpan_androidKt {
    private static final String EllipsisChar = "…";

    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Layout.Alignment.values().length];
            try {
                iArr[Layout.Alignment.ALIGN_CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final float getEllipsizedLeftPadding(Layout layout, int i5, Paint paint) {
        float abs;
        float width;
        float lineLeft = layout.getLineLeft(i5);
        if (!TextLayout_androidKt.isLineEllipsized(layout, i5) || layout.getParagraphDirection(i5) != 1 || lineLeft >= 0.0f) {
            return 0.0f;
        }
        float primaryHorizontal = (layout.getPrimaryHorizontal(layout.getLineStart(i5) + layout.getEllipsisStart(i5)) - lineLeft) + paint.measureText(EllipsisChar);
        Layout.Alignment paragraphAlignment = layout.getParagraphAlignment(i5);
        if ((paragraphAlignment == null ? -1 : WhenMappings.$EnumSwitchMapping$0[paragraphAlignment.ordinal()]) == 1) {
            abs = Math.abs(lineLeft);
            width = (layout.getWidth() - primaryHorizontal) / 2.0f;
        } else {
            abs = Math.abs(lineLeft);
            width = layout.getWidth() - primaryHorizontal;
        }
        return abs + width;
    }

    public static /* synthetic */ float getEllipsizedLeftPadding$default(Layout layout, int i5, Paint paint, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            paint = layout.getPaint();
        }
        return getEllipsizedLeftPadding(layout, i5, paint);
    }

    public static final float getEllipsizedRightPadding(Layout layout, int i5, Paint paint) {
        float width;
        float width2;
        if (!TextLayout_androidKt.isLineEllipsized(layout, i5)) {
            return 0.0f;
        }
        if (layout.getParagraphDirection(i5) != -1 || layout.getWidth() >= layout.getLineRight(i5)) {
            return 0.0f;
        }
        float lineRight = (layout.getLineRight(i5) - layout.getPrimaryHorizontal(layout.getLineStart(i5) + layout.getEllipsisStart(i5))) + paint.measureText(EllipsisChar);
        Layout.Alignment paragraphAlignment = layout.getParagraphAlignment(i5);
        if ((paragraphAlignment != null ? WhenMappings.$EnumSwitchMapping$0[paragraphAlignment.ordinal()] : -1) == 1) {
            width = layout.getWidth() - layout.getLineRight(i5);
            width2 = (layout.getWidth() - lineRight) / 2.0f;
        } else {
            width = layout.getWidth() - layout.getLineRight(i5);
            width2 = layout.getWidth() - lineRight;
        }
        return width - width2;
    }

    public static /* synthetic */ float getEllipsizedRightPadding$default(Layout layout, int i5, Paint paint, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            paint = layout.getPaint();
        }
        return getEllipsizedRightPadding(layout, i5, paint);
    }
}
