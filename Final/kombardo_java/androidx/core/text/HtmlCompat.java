package androidx.core.text;

import android.annotation.SuppressLint;
import android.text.Html;
import android.text.Spanned;

@SuppressLint({"InlinedApi"})
/* loaded from: classes.dex */
public abstract class HtmlCompat {

    /* loaded from: classes.dex */
    static class Api24Impl {
        static Spanned fromHtml(String str, int i5) {
            return Html.fromHtml(str, i5);
        }
    }

    public static Spanned fromHtml(String str, int i5) {
        return Api24Impl.fromHtml(str, i5);
    }
}
