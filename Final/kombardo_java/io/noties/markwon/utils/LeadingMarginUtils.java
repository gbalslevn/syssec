package io.noties.markwon.utils;

import android.text.Spanned;

/* loaded from: classes2.dex */
public abstract class LeadingMarginUtils {
    public static boolean selfEnd(int i5, CharSequence charSequence, Object obj) {
        return (charSequence instanceof Spanned) && ((Spanned) charSequence).getSpanEnd(obj) == i5;
    }

    public static boolean selfStart(int i5, CharSequence charSequence, Object obj) {
        return (charSequence instanceof Spanned) && ((Spanned) charSequence).getSpanStart(obj) == i5;
    }
}
