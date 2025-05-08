package io.noties.markwon.html.span;

import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;

/* loaded from: classes2.dex */
public class SuperScriptSpan extends MetricAffectingSpan {
    private void apply(TextPaint textPaint) {
        textPaint.setTextSize(textPaint.getTextSize() * 0.75f);
        textPaint.baselineShift += (int) (textPaint.ascent() / 2.0f);
    }

    @Override // android.text.style.CharacterStyle
    public void updateDrawState(TextPaint textPaint) {
        apply(textPaint);
    }

    @Override // android.text.style.MetricAffectingSpan
    public void updateMeasureState(TextPaint textPaint) {
        apply(textPaint);
    }
}
