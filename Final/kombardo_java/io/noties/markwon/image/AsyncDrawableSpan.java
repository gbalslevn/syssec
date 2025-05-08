package io.noties.markwon.image;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.style.ReplacementSpan;
import io.noties.markwon.core.MarkwonTheme;
import io.noties.markwon.utils.SpanUtils;

/* loaded from: classes2.dex */
public class AsyncDrawableSpan extends ReplacementSpan {
    private final int alignment;
    private final AsyncDrawable drawable;
    private final boolean replacementTextIsLink;
    private final MarkwonTheme theme;

    public AsyncDrawableSpan(MarkwonTheme markwonTheme, AsyncDrawable asyncDrawable, int i5, boolean z5) {
        this.theme = markwonTheme;
        this.drawable = asyncDrawable;
        this.alignment = i5;
        this.replacementTextIsLink = z5;
    }

    private static float textCenterY(int i5, int i6, Paint paint) {
        return (int) ((i5 + ((i6 - i5) / 2)) - (((paint.descent() + paint.ascent()) / 2.0f) + 0.5f));
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence charSequence, int i5, int i6, float f5, int i7, int i8, int i9, Paint paint) {
        int i10;
        this.drawable.initWithKnownDimensions(SpanUtils.width(canvas, charSequence), paint.getTextSize());
        AsyncDrawable asyncDrawable = this.drawable;
        if (!asyncDrawable.hasResult()) {
            float textCenterY = textCenterY(i7, i9, paint);
            if (this.replacementTextIsLink) {
                this.theme.applyLinkStyle(paint);
            }
            canvas.drawText(charSequence, i5, i6, f5, textCenterY, paint);
            return;
        }
        int i11 = i9 - asyncDrawable.getBounds().bottom;
        int save = canvas.save();
        try {
            int i12 = this.alignment;
            if (2 != i12) {
                if (1 == i12) {
                    i10 = paint.getFontMetricsInt().descent;
                }
                canvas.translate(f5, i11);
                asyncDrawable.draw(canvas);
                canvas.restoreToCount(save);
            }
            i10 = ((i9 - i7) - asyncDrawable.getBounds().height()) / 2;
            i11 -= i10;
            canvas.translate(f5, i11);
            asyncDrawable.draw(canvas);
            canvas.restoreToCount(save);
        } catch (Throwable th) {
            canvas.restoreToCount(save);
            throw th;
        }
    }

    public AsyncDrawable getDrawable() {
        return this.drawable;
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence charSequence, int i5, int i6, Paint.FontMetricsInt fontMetricsInt) {
        if (!this.drawable.hasResult()) {
            if (this.replacementTextIsLink) {
                this.theme.applyLinkStyle(paint);
            }
            return (int) (paint.measureText(charSequence, i5, i6) + 0.5f);
        }
        Rect bounds = this.drawable.getBounds();
        if (fontMetricsInt != null) {
            int i7 = -bounds.bottom;
            fontMetricsInt.ascent = i7;
            fontMetricsInt.descent = 0;
            fontMetricsInt.top = i7;
            fontMetricsInt.bottom = 0;
        }
        return bounds.right;
    }
}
