package io.noties.markwon.core.spans;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.Layout;
import android.text.TextPaint;
import android.text.style.LeadingMarginSpan;
import android.text.style.MetricAffectingSpan;
import io.noties.markwon.core.MarkwonTheme;

/* loaded from: classes2.dex */
public class CodeBlockSpan extends MetricAffectingSpan implements LeadingMarginSpan {
    private final MarkwonTheme theme;
    private final Rect rect = ObjectsPool.rect();
    private final Paint paint = ObjectsPool.paint();

    public CodeBlockSpan(MarkwonTheme markwonTheme) {
        this.theme = markwonTheme;
    }

    private void apply(TextPaint textPaint) {
        this.theme.applyCodeBlockTextStyle(textPaint);
    }

    @Override // android.text.style.LeadingMarginSpan
    public void drawLeadingMargin(Canvas canvas, Paint paint, int i5, int i6, int i7, int i8, int i9, CharSequence charSequence, int i10, int i11, boolean z5, Layout layout) {
        int i12;
        this.paint.setStyle(Paint.Style.FILL);
        this.paint.setColor(this.theme.getCodeBlockBackgroundColor(paint));
        if (i6 > 0) {
            i12 = canvas.getWidth();
        } else {
            i5 -= canvas.getWidth();
            i12 = i5;
        }
        this.rect.set(i5, i7, i12, i9);
        canvas.drawRect(this.rect, this.paint);
    }

    @Override // android.text.style.LeadingMarginSpan
    public int getLeadingMargin(boolean z5) {
        return this.theme.getCodeBlockMargin();
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
