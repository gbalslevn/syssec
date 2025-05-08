package io.noties.markwon.core.spans;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.Layout;
import android.text.style.LeadingMarginSpan;
import io.noties.markwon.core.MarkwonTheme;

/* loaded from: classes2.dex */
public class BlockQuoteSpan implements LeadingMarginSpan {
    private final MarkwonTheme theme;
    private final Rect rect = ObjectsPool.rect();
    private final Paint paint = ObjectsPool.paint();

    public BlockQuoteSpan(MarkwonTheme markwonTheme) {
        this.theme = markwonTheme;
    }

    @Override // android.text.style.LeadingMarginSpan
    public void drawLeadingMargin(Canvas canvas, Paint paint, int i5, int i6, int i7, int i8, int i9, CharSequence charSequence, int i10, int i11, boolean z5, Layout layout) {
        int blockQuoteWidth = this.theme.getBlockQuoteWidth();
        this.paint.set(paint);
        this.theme.applyBlockQuoteStyle(this.paint);
        int i12 = i6 * blockQuoteWidth;
        int i13 = i5 + i12;
        int i14 = i12 + i13;
        this.rect.set(Math.min(i13, i14), i7, Math.max(i13, i14), i9);
        canvas.drawRect(this.rect, this.paint);
    }

    @Override // android.text.style.LeadingMarginSpan
    public int getLeadingMargin(boolean z5) {
        return this.theme.getBlockMargin();
    }
}
