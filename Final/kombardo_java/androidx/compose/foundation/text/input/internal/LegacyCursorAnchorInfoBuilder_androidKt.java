package androidx.compose.foundation.text.input.internal;

import android.graphics.Matrix;
import android.os.Build;
import android.view.inputmethod.CursorAnchorInfo;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import androidx.compose.ui.unit.IntSize;
import kotlin.Metadata;
import kotlin.ranges.RangesKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000F\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0004\u001a4\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002\u001ad\u0010\u000b\u001a\u00020\f*\u00020\u00012\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\n2\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010\u0015\u001a\u00020\u00132\b\b\u0002\u0010\u0016\u001a\u00020\u0013H\u0000\u001a\u001c\u0010\u0017\u001a\u00020\u0013*\u00020\n2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0019H\u0000\u001a,\u0010\u001b\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002¨\u0006\u001d"}, d2 = {"addCharacterBounds", "Landroid/view/inputmethod/CursorAnchorInfo$Builder;", "startOffset", BuildConfig.FLAVOR, "endOffset", "offsetMapping", "Landroidx/compose/ui/text/input/OffsetMapping;", "textLayoutResult", "Landroidx/compose/ui/text/TextLayoutResult;", "innerTextFieldBounds", "Landroidx/compose/ui/geometry/Rect;", "build", "Landroid/view/inputmethod/CursorAnchorInfo;", "textFieldValue", "Landroidx/compose/ui/text/input/TextFieldValue;", "matrix", "Landroid/graphics/Matrix;", "decorationBoxBounds", "includeInsertionMarker", BuildConfig.FLAVOR, "includeCharacterBounds", "includeEditorBounds", "includeLineBounds", "containsInclusive", "x", BuildConfig.FLAVOR, "y", "setInsertionMarker", "selectionStart", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class LegacyCursorAnchorInfoBuilder_androidKt {
    /* JADX WARN: Code restructure failed: missing block: B:6:0x005d, code lost:
    
        if (containsInclusive(r22, r8.getRight(), r8.getBottom()) == false) goto L10;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final CursorAnchorInfo.Builder addCharacterBounds(CursorAnchorInfo.Builder builder, int i5, int i6, OffsetMapping offsetMapping, TextLayoutResult textLayoutResult, Rect rect) {
        int i7;
        int i8 = i5;
        int originalToTransformed = offsetMapping.originalToTransformed(i8);
        int originalToTransformed2 = offsetMapping.originalToTransformed(i6);
        float[] fArr = new float[(originalToTransformed2 - originalToTransformed) * 4];
        textLayoutResult.getMultiParagraph().m2217fillBoundingBoxes8ffj60Q(TextRangeKt.TextRange(originalToTransformed, originalToTransformed2), fArr, 0);
        while (i8 < i6) {
            int originalToTransformed3 = offsetMapping.originalToTransformed(i8);
            int i9 = (originalToTransformed3 - originalToTransformed) * 4;
            Rect rect2 = new Rect(fArr[i9], fArr[i9 + 1], fArr[i9 + 2], fArr[i9 + 3]);
            boolean overlaps = rect.overlaps(rect2);
            if (containsInclusive(rect, rect2.getLeft(), rect2.getTop())) {
                i7 = overlaps;
            }
            i7 = (overlaps ? 1 : 0) | 2;
            builder.addCharacterBounds(i8, rect2.getLeft(), rect2.getTop(), rect2.getRight(), rect2.getBottom(), textLayoutResult.getBidiRunDirection(originalToTransformed3) == ResolvedTextDirection.Rtl ? i7 | 4 : i7);
            i8++;
        }
        return builder;
    }

    public static final CursorAnchorInfo build(CursorAnchorInfo.Builder builder, TextFieldValue textFieldValue, OffsetMapping offsetMapping, TextLayoutResult textLayoutResult, Matrix matrix, Rect rect, Rect rect2, boolean z5, boolean z6, boolean z7, boolean z8) {
        builder.reset();
        builder.setMatrix(matrix);
        int m2283getMinimpl = TextRange.m2283getMinimpl(textFieldValue.getSelection());
        builder.setSelectionRange(m2283getMinimpl, TextRange.m2282getMaximpl(textFieldValue.getSelection()));
        if (z5) {
            setInsertionMarker(builder, m2283getMinimpl, offsetMapping, textLayoutResult, rect);
        }
        if (z6) {
            TextRange composition = textFieldValue.getComposition();
            int m2283getMinimpl2 = composition != null ? TextRange.m2283getMinimpl(composition.getPackedValue()) : -1;
            TextRange composition2 = textFieldValue.getComposition();
            int m2282getMaximpl = composition2 != null ? TextRange.m2282getMaximpl(composition2.getPackedValue()) : -1;
            if (m2283getMinimpl2 >= 0 && m2283getMinimpl2 < m2282getMaximpl) {
                builder.setComposingText(m2283getMinimpl2, textFieldValue.getText().subSequence(m2283getMinimpl2, m2282getMaximpl));
                addCharacterBounds(builder, m2283getMinimpl2, m2282getMaximpl, offsetMapping, textLayoutResult, rect);
            }
        }
        int i5 = Build.VERSION.SDK_INT;
        if (i5 >= 33 && z7) {
            CursorAnchorInfoApi33Helper.setEditorBoundsInfo(builder, rect2);
        }
        if (i5 >= 34 && z8) {
            CursorAnchorInfoApi34Helper.addVisibleLineBounds(builder, textLayoutResult, rect);
        }
        return builder.build();
    }

    public static final boolean containsInclusive(Rect rect, float f5, float f6) {
        float left = rect.getLeft();
        if (f5 <= rect.getRight() && left <= f5) {
            float top = rect.getTop();
            if (f6 <= rect.getBottom() && top <= f6) {
                return true;
            }
        }
        return false;
    }

    private static final CursorAnchorInfo.Builder setInsertionMarker(CursorAnchorInfo.Builder builder, int i5, OffsetMapping offsetMapping, TextLayoutResult textLayoutResult, Rect rect) {
        if (i5 < 0) {
            return builder;
        }
        int originalToTransformed = offsetMapping.originalToTransformed(i5);
        Rect cursorRect = textLayoutResult.getCursorRect(originalToTransformed);
        float coerceIn = RangesKt.coerceIn(cursorRect.getLeft(), 0.0f, IntSize.m2661getWidthimpl(textLayoutResult.getSize()));
        boolean containsInclusive = containsInclusive(rect, coerceIn, cursorRect.getTop());
        boolean containsInclusive2 = containsInclusive(rect, coerceIn, cursorRect.getBottom());
        boolean z5 = textLayoutResult.getBidiRunDirection(originalToTransformed) == ResolvedTextDirection.Rtl;
        int i6 = (containsInclusive || containsInclusive2) ? 1 : 0;
        if (!containsInclusive || !containsInclusive2) {
            i6 |= 2;
        }
        builder.setInsertionMarkerLocation(coerceIn, cursorRect.getTop(), cursorRect.getBottom(), cursorRect.getBottom(), z5 ? i6 | 4 : i6);
        return builder;
    }
}
