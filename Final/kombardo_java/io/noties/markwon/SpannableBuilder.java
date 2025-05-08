package io.noties.markwon;

import android.text.SpannableStringBuilder;
import android.text.Spanned;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import org.conscrypt.BuildConfig;

/* loaded from: classes2.dex */
public class SpannableBuilder implements Appendable, CharSequence {
    private final StringBuilder builder;
    private final Deque<Span> spans;

    /* loaded from: classes2.dex */
    public static class Span {
        public int end;
        public final int flags;
        public int start;
        public final Object what;

        Span(Object obj, int i5, int i6, int i7) {
            this.what = obj;
            this.start = i5;
            this.end = i6;
            this.flags = i7;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class SpannableStringBuilderReversed extends SpannableStringBuilder {
        SpannableStringBuilderReversed(CharSequence charSequence) {
            super(charSequence);
        }
    }

    public SpannableBuilder() {
        this(BuildConfig.FLAVOR);
    }

    private void copySpans(int i5, CharSequence charSequence) {
        if (charSequence instanceof Spanned) {
            Spanned spanned = (Spanned) charSequence;
            boolean z5 = spanned instanceof SpannableStringBuilderReversed;
            Object[] spans = spanned.getSpans(0, spanned.length(), Object.class);
            int length = spans != null ? spans.length : 0;
            if (length > 0) {
                if (!z5) {
                    for (int i6 = 0; i6 < length; i6++) {
                        Object obj = spans[i6];
                        setSpan(obj, spanned.getSpanStart(obj) + i5, spanned.getSpanEnd(obj) + i5, spanned.getSpanFlags(obj));
                    }
                    return;
                }
                for (int i7 = length - 1; i7 >= 0; i7--) {
                    Object obj2 = spans[i7];
                    setSpan(obj2, spanned.getSpanStart(obj2) + i5, spanned.getSpanEnd(obj2) + i5, spanned.getSpanFlags(obj2));
                }
            }
        }
    }

    static boolean isPositionValid(int i5, int i6, int i7) {
        return i7 > i6 && i6 >= 0 && i7 <= i5;
    }

    public static void setSpans(SpannableBuilder spannableBuilder, Object obj, int i5, int i6) {
        if (obj == null || !isPositionValid(spannableBuilder.length(), i5, i6)) {
            return;
        }
        setSpansInternal(spannableBuilder, obj, i5, i6);
    }

    private static void setSpansInternal(SpannableBuilder spannableBuilder, Object obj, int i5, int i6) {
        if (obj != null) {
            if (!obj.getClass().isArray()) {
                spannableBuilder.setSpan(obj, i5, i6, 33);
                return;
            }
            for (Object obj2 : (Object[]) obj) {
                setSpansInternal(spannableBuilder, obj2, i5, i6);
            }
        }
    }

    @Override // java.lang.CharSequence
    public char charAt(int i5) {
        return this.builder.charAt(i5);
    }

    public List<Span> getSpans(int i5, int i6) {
        int i7;
        int length = length();
        if (!isPositionValid(length, i5, i6)) {
            return Collections.emptyList();
        }
        if (i5 == 0 && length == i6) {
            ArrayList arrayList = new ArrayList(this.spans);
            Collections.reverse(arrayList);
            return Collections.unmodifiableList(arrayList);
        }
        ArrayList arrayList2 = new ArrayList(0);
        Iterator<Span> descendingIterator = this.spans.descendingIterator();
        while (descendingIterator.hasNext()) {
            Span next = descendingIterator.next();
            int i8 = next.start;
            if ((i8 >= i5 && i8 < i6) || (((i7 = next.end) <= i6 && i7 > i5) || (i8 < i5 && i7 > i6))) {
                arrayList2.add(next);
            }
        }
        return Collections.unmodifiableList(arrayList2);
    }

    public char lastChar() {
        return this.builder.charAt(length() - 1);
    }

    @Override // java.lang.CharSequence
    public int length() {
        return this.builder.length();
    }

    public CharSequence removeFromEnd(int i5) {
        Span next;
        int i6;
        int length = length();
        SpannableStringBuilderReversed spannableStringBuilderReversed = new SpannableStringBuilderReversed(this.builder.subSequence(i5, length));
        Iterator<Span> it = this.spans.iterator();
        while (it.hasNext() && (next = it.next()) != null) {
            int i7 = next.start;
            if (i7 >= i5 && (i6 = next.end) <= length) {
                spannableStringBuilderReversed.setSpan(next.what, i7 - i5, i6 - i5, 33);
                it.remove();
            }
        }
        this.builder.replace(i5, length, BuildConfig.FLAVOR);
        return spannableStringBuilderReversed;
    }

    public SpannableBuilder setSpan(Object obj, int i5, int i6, int i7) {
        this.spans.push(new Span(obj, i5, i6, i7));
        return this;
    }

    public SpannableStringBuilder spannableStringBuilder() {
        SpannableStringBuilderReversed spannableStringBuilderReversed = new SpannableStringBuilderReversed(this.builder);
        for (Span span : this.spans) {
            spannableStringBuilderReversed.setSpan(span.what, span.start, span.end, span.flags);
        }
        return spannableStringBuilderReversed;
    }

    @Override // java.lang.CharSequence
    public CharSequence subSequence(int i5, int i6) {
        List<Span> spans = getSpans(i5, i6);
        if (spans.isEmpty()) {
            return this.builder.subSequence(i5, i6);
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.builder.subSequence(i5, i6));
        int length = spannableStringBuilder.length();
        for (Span span : spans) {
            int max = Math.max(0, span.start - i5);
            spannableStringBuilder.setSpan(span.what, max, Math.min(length, (span.end - span.start) + max), span.flags);
        }
        return spannableStringBuilder;
    }

    @Override // java.lang.CharSequence
    public String toString() {
        return this.builder.toString();
    }

    public SpannableBuilder(CharSequence charSequence) {
        this.spans = new ArrayDeque(8);
        this.builder = new StringBuilder(charSequence);
        copySpans(0, charSequence);
    }

    public SpannableBuilder append(String str) {
        this.builder.append(str);
        return this;
    }

    @Override // java.lang.Appendable
    public SpannableBuilder append(char c5) {
        this.builder.append(c5);
        return this;
    }

    @Override // java.lang.Appendable
    public SpannableBuilder append(CharSequence charSequence) {
        copySpans(length(), charSequence);
        this.builder.append(charSequence);
        return this;
    }

    @Override // java.lang.Appendable
    public SpannableBuilder append(CharSequence charSequence, int i5, int i6) {
        CharSequence subSequence = charSequence.subSequence(i5, i6);
        copySpans(length(), subSequence);
        this.builder.append(subSequence);
        return this;
    }
}
