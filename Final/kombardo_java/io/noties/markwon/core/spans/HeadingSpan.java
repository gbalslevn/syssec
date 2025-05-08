package io.noties.markwon.core.spans;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.Layout;
import android.text.TextPaint;
import android.text.style.LeadingMarginSpan;
import android.text.style.MetricAffectingSpan;
import io.noties.markwon.core.MarkwonTheme;
import io.noties.markwon.utils.LeadingMarginUtils;

/* loaded from: classes2.dex */
public class HeadingSpan extends MetricAffectingSpan implements LeadingMarginSpan {
    private final int level;
    private final MarkwonTheme theme;
    private final Rect rect = ObjectsPool.rect();
    private final Paint paint = ObjectsPool.paint();

    public HeadingSpan(MarkwonTheme markwonTheme, int i5) {
        this.theme = markwonTheme;
        this.level = i5;
    }

    private void apply(TextPaint textPaint) {
        this.theme.applyHeadingTextStyle(textPaint, this.level);
    }

    @Override // android.text.style.LeadingMarginSpan
    public void drawLeadingMargin(Canvas canvas, Paint paint, int i5, int i6, int i7, int i8, int i9, CharSequence charSequence, int i10, int i11, boolean z5, Layout layout) {
        int i12;
        int i13 = this.level;
        if ((i13 == 1 || i13 == 2) && LeadingMarginUtils.selfEnd(i11, charSequence, this)) {
            this.paint.set(paint);
            this.theme.applyHeadingBreakStyle(this.paint);
            float strokeWidth = this.paint.getStrokeWidth();
            if (strokeWidth > 0.0f) {
                int i14 = (int) ((i9 - strokeWidth) + 0.5f);
                if (i6 > 0) {
                    i12 = canvas.getWidth();
                } else {
                    i12 = i5;
                    i5 -= canvas.getWidth();
                }
                this.rect.set(i5, i14, i12, i9);
                canvas.drawRect(this.rect, this.paint);
            }
        }
    }

    @Override // android.text.style.LeadingMarginSpan
    public int getLeadingMargin(boolean z5) {
        return 0;
    }

    @Override // android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        apply(textPaint);
    }

    @Override // android.text.style.MetricAffectingSpan
    public void updateMeasureState(TextPaint textPaint) {
        apply(textPaint);
    }
}
