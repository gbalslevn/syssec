package io.noties.markwon.core.spans;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.text.Layout;
import android.text.style.LeadingMarginSpan;
import io.noties.markwon.core.MarkwonTheme;
import io.noties.markwon.utils.LeadingMarginUtils;

/* loaded from: classes2.dex */
public class BulletListItemSpan implements LeadingMarginSpan {
    private static final boolean IS_NOUGAT = false;
    private final int level;
    private MarkwonTheme theme;
    private final Paint paint = ObjectsPool.paint();
    private final RectF circle = ObjectsPool.rectF();
    private final Rect rectangle = ObjectsPool.rect();

    public BulletListItemSpan(MarkwonTheme markwonTheme, int i5) {
        this.theme = markwonTheme;
        this.level = i5;
    }

    @Override // android.text.style.LeadingMarginSpan
    public void drawLeadingMargin(Canvas canvas, Paint paint, int i5, int i6, int i7, int i8, int i9, CharSequence charSequence, int i10, int i11, boolean z5, Layout layout) {
        int i12;
        int i13;
        if (z5 && LeadingMarginUtils.selfStart(i10, charSequence, this)) {
            this.paint.set(paint);
            this.theme.applyListItemStyle(this.paint);
            int save = canvas.save();
            try {
                int blockMargin = this.theme.getBlockMargin();
                int bulletWidth = this.theme.getBulletWidth((int) ((this.paint.descent() - this.paint.ascent()) + 0.5f));
                int i14 = (blockMargin - bulletWidth) / 2;
                if (IS_NOUGAT) {
                    int width = i6 < 0 ? i5 - (layout.getWidth() - (blockMargin * this.level)) : (blockMargin * this.level) - i5;
                    int i15 = i5 + (i14 * i6);
                    int i16 = (i6 * bulletWidth) + i15;
                    int i17 = i6 * width;
                    i12 = Math.min(i15, i16) + i17;
                    i13 = Math.max(i15, i16) + i17;
                } else {
                    if (i6 <= 0) {
                        i5 -= blockMargin;
                    }
                    i12 = i5 + i14;
                    i13 = i12 + bulletWidth;
                }
                int descent = (i8 + ((int) (((this.paint.descent() + this.paint.ascent()) / 2.0f) + 0.5f))) - (bulletWidth / 2);
                int i18 = bulletWidth + descent;
                int i19 = this.level;
                if (i19 != 0 && i19 != 1) {
                    this.rectangle.set(i12, descent, i13, i18);
                    this.paint.setStyle(Paint.Style.FILL);
                    canvas.drawRect(this.rectangle, this.paint);
                    canvas.restoreToCount(save);
                }
                this.circle.set(i12, descent, i13, i18);
                this.paint.setStyle(this.level == 0 ? Paint.Style.FILL : Paint.Style.STROKE);
                canvas.drawOval(this.circle, this.paint);
                canvas.restoreToCount(save);
            } catch (Throwable th) {
                canvas.restoreToCount(save);
                throw th;
            }
        }
    }

    @Override // android.text.style.LeadingMarginSpan
    public int getLeadingMargin(boolean z5) {
        return this.theme.getBlockMargin();
    }
}
