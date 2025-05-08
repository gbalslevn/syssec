package androidx.emoji2.text;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.style.CharacterStyle;

/* loaded from: classes.dex */
public final class TypefaceEmojiSpan extends EmojiSpan {
    private static Paint sDebugPaint;
    private TextPaint mWorkingPaint;

    public TypefaceEmojiSpan(TypefaceEmojiRasterizer typefaceEmojiRasterizer) {
        super(typefaceEmojiRasterizer);
    }

    private TextPaint applyCharacterSpanStyles(CharSequence charSequence, int i5, int i6, Paint paint) {
        if (!(charSequence instanceof Spanned)) {
            if (paint instanceof TextPaint) {
                return (TextPaint) paint;
            }
            return null;
        }
        CharacterStyle[] characterStyleArr = (CharacterStyle[]) ((Spanned) charSequence).getSpans(i5, i6, CharacterStyle.class);
        if (characterStyleArr.length != 0) {
            if (characterStyleArr.length != 1 || characterStyleArr[0] != this) {
                TextPaint textPaint = this.mWorkingPaint;
                if (textPaint == null) {
                    textPaint = new TextPaint();
                    this.mWorkingPaint = textPaint;
                }
                textPaint.set(paint);
                for (CharacterStyle characterStyle : characterStyleArr) {
                    characterStyle.updateDrawState(textPaint);
                }
                return textPaint;
            }
        }
        if (paint instanceof TextPaint) {
            return (TextPaint) paint;
        }
        return null;
    }

    private static Paint getDebugPaint() {
        if (sDebugPaint == null) {
            TextPaint textPaint = new TextPaint();
            sDebugPaint = textPaint;
            textPaint.setColor(EmojiCompat.get().getEmojiSpanIndicatorColor());
            sDebugPaint.setStyle(Paint.Style.FILL);
        }
        return sDebugPaint;
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(Canvas canvas, @SuppressLint({"UnknownNullness"}) CharSequence charSequence, int i5, int i6, float f5, int i7, int i8, int i9, Paint paint) {
        Paint paint2 = paint;
        TextPaint applyCharacterSpanStyles = applyCharacterSpanStyles(charSequence, i5, i6, paint2);
        if (applyCharacterSpanStyles != null && applyCharacterSpanStyles.bgColor != 0) {
            drawBackground(canvas, applyCharacterSpanStyles, f5, f5 + getWidth(), i7, i9);
        }
        if (EmojiCompat.get().isEmojiSpanIndicatorEnabled()) {
            canvas.drawRect(f5, i7, f5 + getWidth(), i9, getDebugPaint());
        }
        TypefaceEmojiRasterizer typefaceRasterizer = getTypefaceRasterizer();
        float f6 = i8;
        if (applyCharacterSpanStyles != null) {
            paint2 = applyCharacterSpanStyles;
        }
        typefaceRasterizer.draw(canvas, f5, f6, paint2);
    }

    void drawBackground(Canvas canvas, TextPaint textPaint, float f5, float f6, float f7, float f8) {
        int color = textPaint.getColor();
        Paint.Style style = textPaint.getStyle();
        textPaint.setColor(textPaint.bgColor);
        textPaint.setStyle(Paint.Style.FILL);
        canvas.drawRect(f5, f7, f6, f8, textPaint);
        textPaint.setStyle(style);
        textPaint.setColor(color);
    }
}
