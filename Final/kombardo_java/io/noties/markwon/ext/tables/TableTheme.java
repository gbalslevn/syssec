package io.noties.markwon.ext.tables;

import android.content.Context;
import android.graphics.Paint;
import io.noties.markwon.utils.ColorUtils;
import io.noties.markwon.utils.Dip;

/* loaded from: classes2.dex */
public class TableTheme {
    protected final int tableBorderColor;
    protected final int tableBorderWidth;
    protected final int tableCellPadding;
    protected final int tableEvenRowBackgroundColor;
    protected final int tableHeaderRowBackgroundColor;
    protected final int tableOddRowBackgroundColor;

    /* loaded from: classes2.dex */
    public static class Builder {
        private int tableBorderColor;
        private int tableBorderWidth = -1;
        private int tableCellPadding;
        private int tableEvenRowBackgroundColor;
        private int tableHeaderRowBackgroundColor;
        private int tableOddRowBackgroundColor;

        public TableTheme build() {
            return new TableTheme(this);
        }

        public Builder tableBorderWidth(int i5) {
            this.tableBorderWidth = i5;
            return this;
        }

        public Builder tableCellPadding(int i5) {
            this.tableCellPadding = i5;
            return this;
        }
    }

    protected TableTheme(Builder builder) {
        this.tableCellPadding = builder.tableCellPadding;
        this.tableBorderColor = builder.tableBorderColor;
        this.tableBorderWidth = builder.tableBorderWidth;
        this.tableOddRowBackgroundColor = builder.tableOddRowBackgroundColor;
        this.tableEvenRowBackgroundColor = builder.tableEvenRowBackgroundColor;
        this.tableHeaderRowBackgroundColor = builder.tableHeaderRowBackgroundColor;
    }

    public static Builder buildWithDefaults(Context context) {
        Dip create = Dip.create(context);
        return emptyBuilder().tableCellPadding(create.toPx(4)).tableBorderWidth(create.toPx(1));
    }

    public static TableTheme create(Context context) {
        return buildWithDefaults(context).build();
    }

    public static Builder emptyBuilder() {
        return new Builder();
    }

    public void applyTableBorderStyle(Paint paint) {
        int i5 = this.tableBorderColor;
        if (i5 == 0) {
            i5 = ColorUtils.applyAlpha(paint.getColor(), 75);
        }
        paint.setColor(i5);
        paint.setStyle(Paint.Style.FILL);
    }

    public void applyTableEvenRowStyle(Paint paint) {
        paint.setColor(this.tableEvenRowBackgroundColor);
        paint.setStyle(Paint.Style.FILL);
    }

    public void applyTableHeaderRowStyle(Paint paint) {
        paint.setColor(this.tableHeaderRowBackgroundColor);
        paint.setStyle(Paint.Style.FILL);
    }

    public void applyTableOddRowStyle(Paint paint) {
        int i5 = this.tableOddRowBackgroundColor;
        if (i5 == 0) {
            i5 = ColorUtils.applyAlpha(paint.getColor(), 22);
        }
        paint.setColor(i5);
        paint.setStyle(Paint.Style.FILL);
    }

    public int tableBorderWidth(Paint paint) {
        int i5 = this.tableBorderWidth;
        return i5 == -1 ? (int) (paint.getStrokeWidth() + 0.5f) : i5;
    }

    public int tableCellPadding() {
        return this.tableCellPadding;
    }
}
