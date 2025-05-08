package io.noties.markwon.core.spans;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.Layout;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.style.LeadingMarginSpan;
import android.widget.TextView;
import io.noties.markwon.core.MarkwonTheme;
import io.noties.markwon.utils.LeadingMarginUtils;

/* loaded from: classes2.dex */
public class OrderedListItemSpan implements LeadingMarginSpan {
    private int margin;
    private final String number;
    private final Paint paint = ObjectsPool.paint();
    private final MarkwonTheme theme;

    public OrderedListItemSpan(MarkwonTheme markwonTheme, String str) {
        this.theme = markwonTheme;
        this.number = str;
    }

    public static void measure(TextView textView, CharSequence charSequence) {
        if (charSequence instanceof Spanned) {
            OrderedListItemSpan[] orderedListItemSpanArr = (OrderedListItemSpan[]) ((Spanned) charSequence).getSpans(0, charSequence.length(), OrderedListItemSpan.class);
            if (orderedListItemSpanArr != null) {
                TextPaint paint = textView.getPaint();
                for (OrderedListItemSpan orderedListItemSpan : orderedListItemSpanArr) {
                    orderedListItemSpan.margin = (int) (paint.measureText(orderedListItemSpan.number) + 0.5f);
                }
            }
        }
    }

    @Override // android.text.style.LeadingMarginSpan
    public void drawLeadingMargin(Canvas canvas, Paint paint, int i5, int i6, int i7, int i8, int i9, CharSequence charSequence, int i10, int i11, boolean z5, Layout layout) {
        if (z5 && LeadingMarginUtils.selfStart(i10, charSequence, this)) {
            this.paint.set(paint);
            this.theme.applyListItemStyle(this.paint);
            int measureText = (int) (this.paint.measureText(this.number) + 0.5f);
            int blockMargin = this.theme.getBlockMargin();
            if (measureText > blockMargin) {
                this.margin = measureText;
                blockMargin = measureText;
            } else {
                this.margin = 0;
            }
            canvas.drawText(this.number, i6 > 0 ? (i5 + (blockMargin * i6)) - measureText : i5 + (i6 * blockMargin) + (blockMargin - measureText), i8, this.paint);
        }
    }

    @Override // android.text.style.LeadingMarginSpan
    public int getLeadingMargin(boolean z5) {
        return Math.max(this.margin, this.theme.getBlockMargin());
    }
}
