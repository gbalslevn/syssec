package androidx.emoji2.text;

import android.text.TextPaint;
import androidx.core.graphics.PaintCompat;
import androidx.emoji2.text.EmojiCompat;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class DefaultGlyphChecker implements EmojiCompat.GlyphChecker {
    private static final int PAINT_TEXT_SIZE = 10;
    private static final ThreadLocal<StringBuilder> sStringBuilder = new ThreadLocal<>();
    private final TextPaint mTextPaint;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DefaultGlyphChecker() {
        TextPaint textPaint = new TextPaint();
        this.mTextPaint = textPaint;
        textPaint.setTextSize(10.0f);
    }

    private static StringBuilder getStringBuilder() {
        ThreadLocal<StringBuilder> threadLocal = sStringBuilder;
        if (threadLocal.get() == null) {
            threadLocal.set(new StringBuilder());
        }
        return threadLocal.get();
    }

    @Override // androidx.emoji2.text.EmojiCompat.GlyphChecker
    public boolean hasGlyph(CharSequence charSequence, int i5, int i6, int i7) {
        StringBuilder stringBuilder = getStringBuilder();
        stringBuilder.setLength(0);
        while (i5 < i6) {
            stringBuilder.append(charSequence.charAt(i5));
            i5++;
        }
        return PaintCompat.hasGlyph(this.mTextPaint, stringBuilder.toString());
    }
}
