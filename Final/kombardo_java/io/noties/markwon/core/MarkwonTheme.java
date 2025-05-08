package io.noties.markwon.core;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.TextPaint;
import io.noties.markwon.utils.ColorUtils;
import io.noties.markwon.utils.Dip;
import java.util.Arrays;
import java.util.Locale;

/* loaded from: classes2.dex */
public class MarkwonTheme {
    private static final float[] HEADING_SIZES = {2.0f, 1.5f, 1.17f, 1.0f, 0.83f, 0.67f};
    protected final int blockMargin;
    protected final int blockQuoteColor;
    protected final int blockQuoteWidth;
    protected final int bulletListItemStrokeWidth;
    protected final int bulletWidth;
    protected final int codeBackgroundColor;
    protected final int codeBlockBackgroundColor;
    protected final int codeBlockMargin;
    protected final int codeBlockTextColor;
    protected final int codeBlockTextSize;
    protected final Typeface codeBlockTypeface;
    protected final int codeTextColor;
    protected final int codeTextSize;
    protected final Typeface codeTypeface;
    protected final int headingBreakColor;
    protected final int headingBreakHeight;
    protected final float[] headingTextSizeMultipliers;
    protected final Typeface headingTypeface;
    protected final boolean isLinkedUnderlined;
    protected final int linkColor;
    protected final int listItemColor;
    protected final int thematicBreakColor;
    protected final int thematicBreakHeight;

    /* loaded from: classes2.dex */
    public static class Builder {
        private int blockMargin;
        private int blockQuoteColor;
        private int blockQuoteWidth;
        private int bulletListItemStrokeWidth;
        private int bulletWidth;
        private int codeBackgroundColor;
        private int codeBlockBackgroundColor;
        private int codeBlockMargin;
        private int codeBlockTextColor;
        private int codeBlockTextSize;
        private Typeface codeBlockTypeface;
        private int codeTextColor;
        private int codeTextSize;
        private Typeface codeTypeface;
        private int headingBreakColor;
        private float[] headingTextSizeMultipliers;
        private Typeface headingTypeface;
        private int linkColor;
        private int listItemColor;
        private int thematicBreakColor;
        private boolean isLinkUnderlined = true;
        private int headingBreakHeight = -1;
        private int thematicBreakHeight = -1;

        Builder() {
        }

        public Builder blockMargin(int i5) {
            this.blockMargin = i5;
            return this;
        }

        public Builder blockQuoteWidth(int i5) {
            this.blockQuoteWidth = i5;
            return this;
        }

        public MarkwonTheme build() {
            return new MarkwonTheme(this);
        }

        public Builder bulletListItemStrokeWidth(int i5) {
            this.bulletListItemStrokeWidth = i5;
            return this;
        }

        public Builder codeBlockMargin(int i5) {
            this.codeBlockMargin = i5;
            return this;
        }

        public Builder headingBreakHeight(int i5) {
            this.headingBreakHeight = i5;
            return this;
        }

        public Builder thematicBreakHeight(int i5) {
            this.thematicBreakHeight = i5;
            return this;
        }
    }

    protected MarkwonTheme(Builder builder) {
        this.linkColor = builder.linkColor;
        this.isLinkedUnderlined = builder.isLinkUnderlined;
        this.blockMargin = builder.blockMargin;
        this.blockQuoteWidth = builder.blockQuoteWidth;
        this.blockQuoteColor = builder.blockQuoteColor;
        this.listItemColor = builder.listItemColor;
        this.bulletListItemStrokeWidth = builder.bulletListItemStrokeWidth;
        this.bulletWidth = builder.bulletWidth;
        this.codeTextColor = builder.codeTextColor;
        this.codeBlockTextColor = builder.codeBlockTextColor;
        this.codeBackgroundColor = builder.codeBackgroundColor;
        this.codeBlockBackgroundColor = builder.codeBlockBackgroundColor;
        this.codeBlockMargin = builder.codeBlockMargin;
        this.codeTypeface = builder.codeTypeface;
        this.codeBlockTypeface = builder.codeBlockTypeface;
        this.codeTextSize = builder.codeTextSize;
        this.codeBlockTextSize = builder.codeBlockTextSize;
        this.headingBreakHeight = builder.headingBreakHeight;
        this.headingBreakColor = builder.headingBreakColor;
        this.headingTypeface = builder.headingTypeface;
        this.headingTextSizeMultipliers = builder.headingTextSizeMultipliers;
        this.thematicBreakColor = builder.thematicBreakColor;
        this.thematicBreakHeight = builder.thematicBreakHeight;
    }

    public static Builder builderWithDefaults(Context context) {
        Dip create = Dip.create(context);
        return new Builder().codeBlockMargin(create.toPx(8)).blockMargin(create.toPx(24)).blockQuoteWidth(create.toPx(4)).bulletListItemStrokeWidth(create.toPx(1)).headingBreakHeight(create.toPx(1)).thematicBreakHeight(create.toPx(4));
    }

    public void applyBlockQuoteStyle(Paint paint) {
        int i5 = this.blockQuoteColor;
        if (i5 == 0) {
            i5 = ColorUtils.applyAlpha(paint.getColor(), 25);
        }
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(i5);
    }

    public void applyCodeBlockTextStyle(Paint paint) {
        int i5 = this.codeBlockTextColor;
        if (i5 == 0) {
            i5 = this.codeTextColor;
        }
        if (i5 != 0) {
            paint.setColor(i5);
        }
        Typeface typeface = this.codeBlockTypeface;
        if (typeface == null) {
            typeface = this.codeTypeface;
        }
        if (typeface != null) {
            paint.setTypeface(typeface);
            int i6 = this.codeBlockTextSize;
            if (i6 <= 0) {
                i6 = this.codeTextSize;
            }
            if (i6 > 0) {
                paint.setTextSize(i6);
                return;
            }
            return;
        }
        paint.setTypeface(Typeface.MONOSPACE);
        int i7 = this.codeBlockTextSize;
        if (i7 <= 0) {
            i7 = this.codeTextSize;
        }
        if (i7 > 0) {
            paint.setTextSize(i7);
        } else {
            paint.setTextSize(paint.getTextSize() * 0.87f);
        }
    }

    public void applyCodeTextStyle(Paint paint) {
        int i5 = this.codeTextColor;
        if (i5 != 0) {
            paint.setColor(i5);
        }
        Typeface typeface = this.codeTypeface;
        if (typeface != null) {
            paint.setTypeface(typeface);
            int i6 = this.codeTextSize;
            if (i6 > 0) {
                paint.setTextSize(i6);
                return;
            }
            return;
        }
        paint.setTypeface(Typeface.MONOSPACE);
        int i7 = this.codeTextSize;
        if (i7 > 0) {
            paint.setTextSize(i7);
        } else {
            paint.setTextSize(paint.getTextSize() * 0.87f);
        }
    }

    public void applyHeadingBreakStyle(Paint paint) {
        int i5 = this.headingBreakColor;
        if (i5 == 0) {
            i5 = ColorUtils.applyAlpha(paint.getColor(), 75);
        }
        paint.setColor(i5);
        paint.setStyle(Paint.Style.FILL);
        int i6 = this.headingBreakHeight;
        if (i6 >= 0) {
            paint.setStrokeWidth(i6);
        }
    }

    public void applyHeadingTextStyle(Paint paint, int i5) {
        Typeface typeface = this.headingTypeface;
        if (typeface == null) {
            paint.setFakeBoldText(true);
        } else {
            paint.setTypeface(typeface);
        }
        float[] fArr = this.headingTextSizeMultipliers;
        if (fArr == null) {
            fArr = HEADING_SIZES;
        }
        if (fArr == null || fArr.length < i5) {
            throw new IllegalStateException(String.format(Locale.US, "Supplied heading level: %d is invalid, where configured heading sizes are: `%s`", Integer.valueOf(i5), Arrays.toString(fArr)));
        }
        paint.setTextSize(paint.getTextSize() * fArr[i5 - 1]);
    }

    public void applyLinkStyle(TextPaint textPaint) {
        textPaint.setUnderlineText(this.isLinkedUnderlined);
        int i5 = this.linkColor;
        if (i5 != 0) {
            textPaint.setColor(i5);
        } else {
            textPaint.setColor(textPaint.linkColor);
        }
    }

    public void applyListItemStyle(Paint paint) {
        int i5 = this.listItemColor;
        if (i5 == 0) {
            i5 = paint.getColor();
        }
        paint.setColor(i5);
        int i6 = this.bulletListItemStrokeWidth;
        if (i6 != 0) {
            paint.setStrokeWidth(i6);
        }
    }

    public void applyThematicBreakStyle(Paint paint) {
        int i5 = this.thematicBreakColor;
        if (i5 == 0) {
            i5 = ColorUtils.applyAlpha(paint.getColor(), 25);
        }
        paint.setColor(i5);
        paint.setStyle(Paint.Style.FILL);
        int i6 = this.thematicBreakHeight;
        if (i6 >= 0) {
            paint.setStrokeWidth(i6);
        }
    }

    public int getBlockMargin() {
        return this.blockMargin;
    }

    public int getBlockQuoteWidth() {
        int i5 = this.blockQuoteWidth;
        return i5 == 0 ? (int) ((this.blockMargin * 0.25f) + 0.5f) : i5;
    }

    public int getBulletWidth(int i5) {
        int min = Math.min(this.blockMargin, i5) / 2;
        int i6 = this.bulletWidth;
        return (i6 == 0 || i6 > min) ? min : i6;
    }

    public int getCodeBackgroundColor(Paint paint) {
        int i5 = this.codeBackgroundColor;
        return i5 != 0 ? i5 : ColorUtils.applyAlpha(paint.getColor(), 25);
    }

    public int getCodeBlockBackgroundColor(Paint paint) {
        int i5 = this.codeBlockBackgroundColor;
        if (i5 == 0) {
            i5 = this.codeBackgroundColor;
        }
        return i5 != 0 ? i5 : ColorUtils.applyAlpha(paint.getColor(), 25);
    }

    public int getCodeBlockMargin() {
        return this.codeBlockMargin;
    }

    public void applyLinkStyle(Paint paint) {
        paint.setUnderlineText(this.isLinkedUnderlined);
        int i5 = this.linkColor;
        if (i5 != 0) {
            paint.setColor(i5);
        } else if (paint instanceof TextPaint) {
            paint.setColor(((TextPaint) paint).linkColor);
        }
    }
}
