package io.noties.markwon.ext.tables;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.style.ReplacementSpan;
import io.noties.markwon.core.spans.TextLayoutSpan;
import io.noties.markwon.image.AsyncDrawable;
import io.noties.markwon.image.AsyncDrawableSpan;
import io.noties.markwon.utils.LeadingMarginUtils;
import io.noties.markwon.utils.SpanUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class TableRowSpan extends ReplacementSpan {
    private final List<Cell> cells;
    private final boolean header;
    private int height;
    private Invalidator invalidator;
    private final List<Layout> layouts;
    private final boolean odd;
    private final TableTheme theme;
    private int width;
    private final Rect rect = new Rect();
    private final Paint paint = new Paint(1);
    private final TextPaint textPaint = new TextPaint();

    /* loaded from: classes2.dex */
    private static abstract class CallbackAdapter implements Drawable.Callback {
        private CallbackAdapter() {
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void scheduleDrawable(Drawable drawable, Runnable runnable, long j5) {
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        }
    }

    /* loaded from: classes2.dex */
    public static class Cell {
        final int alignment;
        final CharSequence text;

        public Cell(int i5, CharSequence charSequence) {
            this.alignment = i5;
            this.text = charSequence;
        }

        public String toString() {
            return "Cell{alignment=" + this.alignment + ", text=" + ((Object) this.text) + '}';
        }
    }

    /* loaded from: classes2.dex */
    public interface Invalidator {
        void invalidate();
    }

    public TableRowSpan(TableTheme tableTheme, List<Cell> list, boolean z5, boolean z6) {
        this.theme = tableTheme;
        this.cells = list;
        this.layouts = new ArrayList(list.size());
        this.header = z5;
        this.odd = z6;
    }

    @SuppressLint({"SwitchIntDef"})
    private static Layout.Alignment alignment(int i5) {
        return i5 != 1 ? i5 != 2 ? Layout.Alignment.ALIGN_NORMAL : Layout.Alignment.ALIGN_OPPOSITE : Layout.Alignment.ALIGN_CENTER;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void makeLayout(final int i5, final int i6, final Cell cell) {
        Runnable runnable = new Runnable() { // from class: io.noties.markwon.ext.tables.TableRowSpan.1
            @Override // java.lang.Runnable
            public void run() {
                Invalidator invalidator = TableRowSpan.this.invalidator;
                if (invalidator != null) {
                    TableRowSpan.this.layouts.remove(i5);
                    TableRowSpan.this.makeLayout(i5, i6, cell);
                    invalidator.invalidate();
                }
            }
        };
        CharSequence charSequence = cell.text;
        Spannable spannableString = charSequence instanceof Spannable ? (Spannable) charSequence : new SpannableString(cell.text);
        StaticLayout staticLayout = new StaticLayout(spannableString, this.textPaint, i6, alignment(cell.alignment), 1.0f, 0.0f, false);
        TextLayoutSpan.applyTo(spannableString, staticLayout);
        scheduleAsyncDrawables(spannableString, runnable);
        this.layouts.add(i5, staticLayout);
    }

    private void makeNewLayouts() {
        this.textPaint.setFakeBoldText(this.header);
        int size = this.cells.size();
        int cellWidth = cellWidth(size) - (this.theme.tableCellPadding() * 2);
        this.layouts.clear();
        int size2 = this.cells.size();
        for (int i5 = 0; i5 < size2; i5++) {
            makeLayout(i5, cellWidth, this.cells.get(i5));
        }
    }

    private boolean recreateLayouts(int i5) {
        return this.width != i5;
    }

    private void scheduleAsyncDrawables(Spannable spannable, final Runnable runnable) {
        AsyncDrawableSpan[] asyncDrawableSpanArr = (AsyncDrawableSpan[]) spannable.getSpans(0, spannable.length(), AsyncDrawableSpan.class);
        if (asyncDrawableSpanArr == null || asyncDrawableSpanArr.length <= 0) {
            return;
        }
        for (AsyncDrawableSpan asyncDrawableSpan : asyncDrawableSpanArr) {
            AsyncDrawable drawable = asyncDrawableSpan.getDrawable();
            if (!drawable.isAttached()) {
                drawable.setCallback2(new CallbackAdapter() { // from class: io.noties.markwon.ext.tables.TableRowSpan.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super();
                    }

                    @Override // android.graphics.drawable.Drawable.Callback
                    public void invalidateDrawable(Drawable drawable2) {
                        runnable.run();
                    }
                });
            }
        }
    }

    protected int cellWidth(int i5) {
        return (int) (((this.width * 1.0f) / i5) + 0.5f);
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x0169 A[Catch: all -> 0x012a, TRY_LEAVE, TryCatch #0 {all -> 0x012a, blocks: (B:37:0x011c, B:40:0x0123, B:41:0x0135, B:43:0x0140, B:45:0x0159, B:47:0x0169, B:52:0x012e), top: B:36:0x011c }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x016e A[SYNTHETIC] */
    @Override // android.text.style.ReplacementSpan
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void draw(Canvas canvas, CharSequence charSequence, int i5, int i6, float f5, int i7, int i8, int i9, Paint paint) {
        int i10;
        int i11;
        boolean z5;
        Invalidator invalidator;
        int save;
        int i12;
        boolean z6;
        float f6 = f5;
        int width = SpanUtils.width(canvas, charSequence);
        if (recreateLayouts(width)) {
            this.width = width;
            if (paint instanceof TextPaint) {
                this.textPaint.set((TextPaint) paint);
            } else {
                this.textPaint.set(paint);
            }
            makeNewLayouts();
        }
        int tableCellPadding = this.theme.tableCellPadding();
        int size = this.layouts.size();
        int cellWidth = cellWidth(size);
        int i13 = cellWidth - (this.width / size);
        if (this.header) {
            this.theme.applyTableHeaderRowStyle(this.paint);
        } else if (this.odd) {
            this.theme.applyTableOddRowStyle(this.paint);
        } else {
            this.theme.applyTableEvenRowStyle(this.paint);
        }
        if (this.paint.getColor() != 0) {
            save = canvas.save();
            try {
                i10 = tableCellPadding;
                this.rect.set(0, 0, this.width, i9 - i7);
                canvas.translate(f6, i7);
                canvas.drawRect(this.rect, this.paint);
            } finally {
                canvas.restoreToCount(save);
            }
        } else {
            i10 = tableCellPadding;
        }
        this.paint.set(paint);
        this.theme.applyTableBorderStyle(this.paint);
        int tableBorderWidth = this.theme.tableBorderWidth(this.paint);
        boolean z7 = tableBorderWidth > 0;
        int i14 = i9 - i7;
        int i15 = (i14 - this.height) / 4;
        if (z7) {
            i11 = i15;
            TableSpan[] tableSpanArr = (TableSpan[]) ((Spanned) charSequence).getSpans(i5, i6, TableSpan.class);
            if (tableSpanArr == null || tableSpanArr.length <= 0 || !LeadingMarginUtils.selfStart(i5, charSequence, tableSpanArr[0])) {
                z6 = false;
            } else {
                this.rect.set((int) f6, i7, this.width, i7 + tableBorderWidth);
                canvas.drawRect(this.rect, this.paint);
                z6 = true;
            }
            this.rect.set((int) f6, i9 - tableBorderWidth, this.width, i9);
            canvas.drawRect(this.rect, this.paint);
            z5 = z6;
        } else {
            i11 = i15;
            z5 = false;
        }
        int i16 = tableBorderWidth / 2;
        int i17 = z5 ? tableBorderWidth : 0;
        int i18 = i14 - tableBorderWidth;
        int i19 = 0;
        int i20 = 0;
        while (i19 < size) {
            Layout layout = this.layouts.get(i19);
            save = canvas.save();
            try {
                canvas.translate((i19 * cellWidth) + f6, i7);
                if (z7) {
                    if (i19 == 0) {
                        this.rect.set(0, i17, tableBorderWidth, i18);
                    } else {
                        this.rect.set(-i16, i17, i16, i18);
                    }
                    canvas.drawRect(this.rect, this.paint);
                    if (i19 == size - 1) {
                        i12 = i16;
                        this.rect.set((cellWidth - tableBorderWidth) - i13, i17, cellWidth - i13, i18);
                        canvas.drawRect(this.rect, this.paint);
                        int i21 = i10;
                        canvas.translate(i21, i21 + i11);
                        layout.draw(canvas);
                        if (layout.getHeight() <= i20) {
                            i20 = layout.getHeight();
                        }
                        canvas.restoreToCount(save);
                        i19++;
                        f6 = f5;
                        i10 = i21;
                        i16 = i12;
                    }
                }
                i12 = i16;
                int i212 = i10;
                canvas.translate(i212, i212 + i11);
                layout.draw(canvas);
                if (layout.getHeight() <= i20) {
                }
                canvas.restoreToCount(save);
                i19++;
                f6 = f5;
                i10 = i212;
                i16 = i12;
            } catch (Throwable th) {
                throw th;
            }
        }
        if (this.height == i20 || (invalidator = this.invalidator) == null) {
            return;
        }
        invalidator.invalidate();
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence charSequence, int i5, int i6, Paint.FontMetricsInt fontMetricsInt) {
        if (this.layouts.size() > 0 && fontMetricsInt != null) {
            Iterator<Layout> it = this.layouts.iterator();
            int i7 = 0;
            while (it.hasNext()) {
                int height = it.next().getHeight();
                if (height > i7) {
                    i7 = height;
                }
            }
            this.height = i7;
            int i8 = -(i7 + (this.theme.tableCellPadding() * 2));
            fontMetricsInt.ascent = i8;
            fontMetricsInt.descent = 0;
            fontMetricsInt.top = i8;
            fontMetricsInt.bottom = 0;
        }
        return this.width;
    }

    public void invalidator(Invalidator invalidator) {
        this.invalidator = invalidator;
    }
}
