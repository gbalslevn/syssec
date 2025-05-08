package androidx.core.graphics;

import android.graphics.Paint;
import android.graphics.Rect;
import androidx.core.util.Pair;

/* loaded from: classes.dex */
public abstract class PaintCompat {
    private static final String EM_STRING = "m";
    private static final String TOFU_STRING = "\udfffd";
    private static final ThreadLocal<Pair<Rect, Rect>> sRectThreadLocal = new ThreadLocal<>();

    /* loaded from: classes.dex */
    static class Api23Impl {
        static boolean hasGlyph(Paint paint, String str) {
            return paint.hasGlyph(str);
        }
    }

    public static boolean hasGlyph(Paint paint, String str) {
        return Api23Impl.hasGlyph(paint, str);
    }
}
