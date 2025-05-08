package io.noties.markwon.core.spans;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.Layout;
import android.text.style.LeadingMarginSpan;
import io.noties.markwon.core.MarkwonTheme;

/* loaded from: classes2.dex */
public class ThematicBreakSpan implements LeadingMarginSpan {
    private final MarkwonTheme theme;
    private final Rect rect = ObjectsPool.rect();
    private final Paint paint = ObjectsPool.paint();

    public ThematicBreakSpan(MarkwonTheme markwonTheme) {
        this.theme = markwonTheme;
    }

    @Override // android.text.style.LeadingMarginSpan
    public void drawLeadingMargin(Canvas canvas, Paint paint, int i5, int i6, int i7, int i8, int i9, CharSequence charSequence, int i10, int i11, boolean z5, Layout layout) {
        int i12;
        int i13 = i7 + ((i9 - i7) / 2);
        this.paint.set(paint);
        this.theme.applyThematicBreakStyle(this.paint);
        int strokeWidth = (int) ((((int) (this.paint.getStrokeWidth() + 0.5f)) / 2.0f) + 0.5f);
        if (i6 > 0) {
            i12 = canvas.getWidth();
        } else {
            i12 = i5;
            i5 -= canvas.getWidth();
        }
        this.rect.set(i5, i13 - strokeWidth, i12, i13 + strokeWidth);
        canvas.drawRect(this.rect, this.paint);
    }

    @Override // android.text.style.LeadingMarginSpan
    public int getLeadingMargin(boolean z5) {
        return 0;
    }
}
