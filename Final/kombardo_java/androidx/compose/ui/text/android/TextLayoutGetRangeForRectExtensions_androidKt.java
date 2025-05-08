package androidx.compose.ui.text.android;

import android.graphics.RectF;
import android.text.Layout;
import androidx.compose.ui.text.android.LayoutHelper;
import androidx.compose.ui.text.android.selection.SegmentFinder;
import androidx.compose.ui.text.android.selection.SegmentFinder_androidKt;
import androidx.compose.ui.text.android.selection.WordSegmentFinder;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function2;
import kotlin.ranges.IntProgression;
import kotlin.ranges.RangesKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000N\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0015\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u001a \u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0002\u001a \u0010\u0007\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0002\u001af\u0010\b\u001a\u00020\u0003*\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00112\u0018\u0010\u0012\u001a\u0014\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00140\u0013H\u0002\u001aH\u0010\u0015\u001a\u0004\u0018\u00010\u0016*\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u00032\u0018\u0010\u0012\u001a\u0014\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00140\u0013H\u0000\u001af\u0010\u001d\u001a\u00020\u0003*\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00112\u0018\u0010\u0012\u001a\u0014\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00140\u0013H\u0002\u001aV\u0010\u001e\u001a\u00020\u0003*\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u00112\u0018\u0010\u0012\u001a\u0014\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00140\u00132\u0006\u0010 \u001a\u00020\u0014H\u0002\u001a\u001c\u0010!\u001a\u00020\u0014*\u00020\u000b2\u0006\u0010\"\u001a\u00020\u00012\u0006\u0010#\u001a\u00020\u0001H\u0002¨\u0006$"}, d2 = {"getCharacterLeftBounds", BuildConfig.FLAVOR, "offset", BuildConfig.FLAVOR, "lineStart", "horizontalBounds", BuildConfig.FLAVOR, "getCharacterRightBounds", "getEndOffsetForRectWithinRun", "Landroidx/compose/ui/text/android/LayoutHelper$BidiRun;", "rect", "Landroid/graphics/RectF;", "lineTop", "lineBottom", "runLeft", "runRight", "segmentFinder", "Landroidx/compose/ui/text/android/selection/SegmentFinder;", "inclusionStrategy", "Lkotlin/Function2;", BuildConfig.FLAVOR, "getRangeForRect", BuildConfig.FLAVOR, "Landroidx/compose/ui/text/android/TextLayout;", "layout", "Landroid/text/Layout;", "layoutHelper", "Landroidx/compose/ui/text/android/LayoutHelper;", "granularity", "getStartOffsetForRectWithinRun", "getStartOrEndOffsetForRectWithinLine", "lineIndex", "getStart", "horizontalOverlap", "left", "right", "ui-text_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class TextLayoutGetRangeForRectExtensions_androidKt {
    private static final float getCharacterLeftBounds(int i5, int i6, float[] fArr) {
        return fArr[(i5 - i6) * 2];
    }

    private static final float getCharacterRightBounds(int i5, int i6, float[] fArr) {
        return fArr[((i5 - i6) * 2) + 1];
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x00d6, code lost:
    
        return -1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final int getEndOffsetForRectWithinRun(LayoutHelper.BidiRun bidiRun, RectF rectF, int i5, int i6, int i7, float f5, float f6, float[] fArr, SegmentFinder segmentFinder, Function2<? super RectF, ? super RectF, Boolean> function2) {
        int start;
        int nextEndBoundary;
        if (!horizontalOverlap(rectF, f5, f6)) {
            return -1;
        }
        if ((bidiRun.getIsRtl() || rectF.right < f6) && (!bidiRun.getIsRtl() || rectF.left > f5)) {
            start = bidiRun.getStart();
            int end = bidiRun.getEnd();
            while (end - start > 1) {
                int i8 = (end + start) / 2;
                float characterLeftBounds = getCharacterLeftBounds(i8, i5, fArr);
                if ((bidiRun.getIsRtl() || characterLeftBounds <= rectF.right) && (!bidiRun.getIsRtl() || characterLeftBounds >= rectF.left)) {
                    start = i8;
                } else {
                    end = i8;
                }
            }
            if (bidiRun.getIsRtl()) {
                start = end;
            }
        } else {
            start = bidiRun.getEnd() - 1;
        }
        int previousStartBoundary = segmentFinder.previousStartBoundary(start + 1);
        if (previousStartBoundary == -1 || (nextEndBoundary = segmentFinder.nextEndBoundary(previousStartBoundary)) <= bidiRun.getStart()) {
            return -1;
        }
        int coerceAtLeast = RangesKt.coerceAtLeast(previousStartBoundary, bidiRun.getStart());
        int coerceAtMost = RangesKt.coerceAtMost(nextEndBoundary, bidiRun.getEnd());
        RectF rectF2 = new RectF(0.0f, i6, 0.0f, i7);
        while (true) {
            rectF2.left = bidiRun.getIsRtl() ? getCharacterLeftBounds(coerceAtMost - 1, i5, fArr) : getCharacterLeftBounds(coerceAtLeast, i5, fArr);
            rectF2.right = bidiRun.getIsRtl() ? getCharacterRightBounds(coerceAtLeast, i5, fArr) : getCharacterRightBounds(coerceAtMost - 1, i5, fArr);
            if (function2.invoke(rectF2, rectF).booleanValue()) {
                return coerceAtMost;
            }
            coerceAtMost = segmentFinder.previousEndBoundary(coerceAtMost);
            if (coerceAtMost == -1 || coerceAtMost <= bidiRun.getStart()) {
                break;
            }
            coerceAtLeast = RangesKt.coerceAtLeast(segmentFinder.previousStartBoundary(coerceAtMost), bidiRun.getStart());
        }
    }

    public static final int[] getRangeForRect(TextLayout textLayout, Layout layout, LayoutHelper layoutHelper, RectF rectF, int i5, Function2<? super RectF, ? super RectF, Boolean> function2) {
        int i6;
        int i7;
        SegmentFinder wordSegmentFinder = i5 == 1 ? new WordSegmentFinder(textLayout.getText(), textLayout.getWordIterator()) : SegmentFinder_androidKt.createGraphemeClusterSegmentFinder(textLayout.getText(), textLayout.getTextPaint());
        int lineForVertical = layout.getLineForVertical((int) rectF.top);
        if (rectF.top > textLayout.getLineBottom(lineForVertical) && (lineForVertical = lineForVertical + 1) >= textLayout.getLineCount()) {
            return null;
        }
        int i8 = lineForVertical;
        int lineForVertical2 = layout.getLineForVertical((int) rectF.bottom);
        if (lineForVertical2 == 0 && rectF.bottom < textLayout.getLineTop(0)) {
            return null;
        }
        int startOrEndOffsetForRectWithinLine = getStartOrEndOffsetForRectWithinLine(textLayout, layout, layoutHelper, i8, rectF, wordSegmentFinder, function2, true);
        while (true) {
            i6 = i8;
            i7 = startOrEndOffsetForRectWithinLine;
            if (i7 != -1 || i6 >= lineForVertical2) {
                break;
            }
            i8 = i6 + 1;
            startOrEndOffsetForRectWithinLine = getStartOrEndOffsetForRectWithinLine(textLayout, layout, layoutHelper, i8, rectF, wordSegmentFinder, function2, true);
        }
        if (i7 == -1) {
            return null;
        }
        int startOrEndOffsetForRectWithinLine2 = getStartOrEndOffsetForRectWithinLine(textLayout, layout, layoutHelper, lineForVertical2, rectF, wordSegmentFinder, function2, false);
        while (startOrEndOffsetForRectWithinLine2 == -1 && i6 < lineForVertical2) {
            lineForVertical2--;
            startOrEndOffsetForRectWithinLine2 = getStartOrEndOffsetForRectWithinLine(textLayout, layout, layoutHelper, lineForVertical2, rectF, wordSegmentFinder, function2, false);
        }
        if (startOrEndOffsetForRectWithinLine2 == -1) {
            return null;
        }
        return new int[]{wordSegmentFinder.previousStartBoundary(i7 + 1), wordSegmentFinder.nextEndBoundary(startOrEndOffsetForRectWithinLine2 - 1)};
    }

    private static final int getStartOffsetForRectWithinRun(LayoutHelper.BidiRun bidiRun, RectF rectF, int i5, int i6, int i7, float f5, float f6, float[] fArr, SegmentFinder segmentFinder, Function2<? super RectF, ? super RectF, Boolean> function2) {
        int start;
        int previousStartBoundary;
        if (!horizontalOverlap(rectF, f5, f6)) {
            return -1;
        }
        if ((bidiRun.getIsRtl() || rectF.left > f5) && (!bidiRun.getIsRtl() || rectF.right < f6)) {
            start = bidiRun.getStart();
            int end = bidiRun.getEnd();
            while (end - start > 1) {
                int i8 = (end + start) / 2;
                float characterLeftBounds = getCharacterLeftBounds(i8, i5, fArr);
                if ((bidiRun.getIsRtl() || characterLeftBounds <= rectF.left) && (!bidiRun.getIsRtl() || characterLeftBounds >= rectF.right)) {
                    start = i8;
                } else {
                    end = i8;
                }
            }
            if (bidiRun.getIsRtl()) {
                start = end;
            }
        } else {
            start = bidiRun.getStart();
        }
        int nextEndBoundary = segmentFinder.nextEndBoundary(start);
        if (nextEndBoundary == -1 || (previousStartBoundary = segmentFinder.previousStartBoundary(nextEndBoundary)) >= bidiRun.getEnd()) {
            return -1;
        }
        int coerceAtLeast = RangesKt.coerceAtLeast(previousStartBoundary, bidiRun.getStart());
        int coerceAtMost = RangesKt.coerceAtMost(nextEndBoundary, bidiRun.getEnd());
        RectF rectF2 = new RectF(0.0f, i6, 0.0f, i7);
        while (true) {
            rectF2.left = bidiRun.getIsRtl() ? getCharacterLeftBounds(coerceAtMost - 1, i5, fArr) : getCharacterLeftBounds(coerceAtLeast, i5, fArr);
            rectF2.right = bidiRun.getIsRtl() ? getCharacterRightBounds(coerceAtLeast, i5, fArr) : getCharacterRightBounds(coerceAtMost - 1, i5, fArr);
            if (function2.invoke(rectF2, rectF).booleanValue()) {
                return coerceAtLeast;
            }
            coerceAtLeast = segmentFinder.nextStartBoundary(coerceAtLeast);
            if (coerceAtLeast == -1 || coerceAtLeast >= bidiRun.getEnd()) {
                break;
            }
            coerceAtMost = RangesKt.coerceAtMost(segmentFinder.nextEndBoundary(coerceAtLeast), bidiRun.getEnd());
        }
        return -1;
    }

    private static final int getStartOrEndOffsetForRectWithinLine(TextLayout textLayout, Layout layout, LayoutHelper layoutHelper, int i5, RectF rectF, SegmentFinder segmentFinder, Function2<? super RectF, ? super RectF, Boolean> function2, boolean z5) {
        int i6;
        LayoutHelper.BidiRun[] bidiRunArr;
        int i7;
        int endOffsetForRectWithinRun;
        int lineTop = layout.getLineTop(i5);
        int lineBottom = layout.getLineBottom(i5);
        int lineStart = layout.getLineStart(i5);
        int lineEnd = layout.getLineEnd(i5);
        if (lineStart == lineEnd) {
            return -1;
        }
        float[] fArr = new float[(lineEnd - lineStart) * 2];
        textLayout.fillLineHorizontalBounds$ui_text_release(i5, fArr);
        LayoutHelper.BidiRun[] lineBidiRuns$ui_text_release = layoutHelper.getLineBidiRuns$ui_text_release(i5);
        IntProgression indices = z5 ? ArraysKt.getIndices(lineBidiRuns$ui_text_release) : RangesKt.downTo(ArraysKt.getLastIndex(lineBidiRuns$ui_text_release), 0);
        int first = indices.getFirst();
        int last = indices.getLast();
        int step = indices.getStep();
        if ((step <= 0 || first > last) && (step >= 0 || last > first)) {
            return -1;
        }
        int i8 = first;
        while (true) {
            LayoutHelper.BidiRun bidiRun = lineBidiRuns$ui_text_release[i8];
            float characterLeftBounds = bidiRun.getIsRtl() ? getCharacterLeftBounds(bidiRun.getEnd() - 1, lineStart, fArr) : getCharacterLeftBounds(bidiRun.getStart(), lineStart, fArr);
            float characterRightBounds = bidiRun.getIsRtl() ? getCharacterRightBounds(bidiRun.getStart(), lineStart, fArr) : getCharacterRightBounds(bidiRun.getEnd() - 1, lineStart, fArr);
            if (z5) {
                i6 = i8;
                bidiRunArr = lineBidiRuns$ui_text_release;
                i7 = last;
                endOffsetForRectWithinRun = getStartOffsetForRectWithinRun(bidiRun, rectF, lineStart, lineTop, lineBottom, characterLeftBounds, characterRightBounds, fArr, segmentFinder, function2);
            } else {
                i6 = i8;
                bidiRunArr = lineBidiRuns$ui_text_release;
                i7 = last;
                endOffsetForRectWithinRun = getEndOffsetForRectWithinRun(bidiRun, rectF, lineStart, lineTop, lineBottom, characterLeftBounds, characterRightBounds, fArr, segmentFinder, function2);
            }
            if (endOffsetForRectWithinRun >= 0) {
                return endOffsetForRectWithinRun;
            }
            if (i6 == i7) {
                return -1;
            }
            i8 = i6 + step;
            last = i7;
            lineBidiRuns$ui_text_release = bidiRunArr;
        }
    }

    private static final boolean horizontalOverlap(RectF rectF, float f5, float f6) {
        return f6 >= rectF.left && f5 <= rectF.right;
    }
}
