package androidx.compose.ui.text.android;

import android.text.Layout;
import android.text.Spanned;
import android.text.TextPaint;
import androidx.compose.ui.text.android.LayoutIntrinsics_androidKt;
import androidx.compose.ui.text.android.style.LetterSpacingSpanPx;
import java.text.BreakIterator;
import java.util.Comparator;
import java.util.PriorityQueue;
import kotlin.Metadata;
import kotlin.Pair;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0000\u001a \u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0005H\u0002¨\u0006\u000b"}, d2 = {"minIntrinsicWidth", BuildConfig.FLAVOR, "text", BuildConfig.FLAVOR, "paint", "Landroid/text/TextPaint;", "shouldIncreaseMaxIntrinsic", BuildConfig.FLAVOR, "desiredWidth", "charSequence", "textPaint", "ui-text_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class LayoutIntrinsics_androidKt {
    public static final float minIntrinsicWidth(CharSequence charSequence, TextPaint textPaint) {
        BreakIterator lineInstance = BreakIterator.getLineInstance(textPaint.getTextLocale());
        int i5 = 0;
        lineInstance.setText(new CharSequenceCharacterIterator(charSequence, 0, charSequence.length()));
        PriorityQueue<Pair> priorityQueue = new PriorityQueue(10, new Comparator() { // from class: t.t
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int minIntrinsicWidth$lambda$0;
                minIntrinsicWidth$lambda$0 = LayoutIntrinsics_androidKt.minIntrinsicWidth$lambda$0((Pair) obj, (Pair) obj2);
                return minIntrinsicWidth$lambda$0;
            }
        });
        int next = lineInstance.next();
        while (true) {
            int i6 = i5;
            i5 = next;
            if (i5 == -1) {
                break;
            }
            if (priorityQueue.size() < 10) {
                priorityQueue.add(new Pair(Integer.valueOf(i6), Integer.valueOf(i5)));
            } else {
                Pair pair = (Pair) priorityQueue.peek();
                if (pair != null && ((Number) pair.getSecond()).intValue() - ((Number) pair.getFirst()).intValue() < i5 - i6) {
                    priorityQueue.poll();
                    priorityQueue.add(new Pair(Integer.valueOf(i6), Integer.valueOf(i5)));
                }
            }
            next = lineInstance.next();
        }
        float f5 = 0.0f;
        for (Pair pair2 : priorityQueue) {
            f5 = Math.max(f5, Layout.getDesiredWidth(charSequence, ((Number) pair2.component1()).intValue(), ((Number) pair2.component2()).intValue(), textPaint));
        }
        return f5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int minIntrinsicWidth$lambda$0(Pair pair, Pair pair2) {
        return (((Number) pair.getSecond()).intValue() - ((Number) pair.getFirst()).intValue()) - (((Number) pair2.getSecond()).intValue() - ((Number) pair2.getFirst()).intValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x001a, code lost:
    
        if (androidx.compose.ui.text.android.SpannedExtensions_androidKt.hasSpan(r2, androidx.compose.ui.text.android.style.LetterSpacingSpanEm.class) == false) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final boolean shouldIncreaseMaxIntrinsic(float f5, CharSequence charSequence, TextPaint textPaint) {
        if (f5 != 0.0f) {
            if (charSequence instanceof Spanned) {
                Spanned spanned = (Spanned) charSequence;
                if (!SpannedExtensions_androidKt.hasSpan(spanned, LetterSpacingSpanPx.class)) {
                }
                return true;
            }
            if (textPaint.getLetterSpacing() != 0.0f) {
                return true;
            }
        }
        return false;
    }
}
