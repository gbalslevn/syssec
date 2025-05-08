package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public abstract class DrawableCompat {
    private static final String TAG = "DrawableCompat";
    private static Method sGetLayoutDirectionMethod;
    private static boolean sGetLayoutDirectionMethodFetched;
    private static Method sSetLayoutDirectionMethod;
    private static boolean sSetLayoutDirectionMethodFetched;

    /* loaded from: classes.dex */
    static class Api21Impl {
        static void setHotspot(Drawable drawable, float f5, float f6) {
            drawable.setHotspot(f5, f6);
        }

        static void setHotspotBounds(Drawable drawable, int i5, int i6, int i7, int i8) {
            drawable.setHotspotBounds(i5, i6, i7, i8);
        }

        static void setTint(Drawable drawable, int i5) {
            drawable.setTint(i5);
        }

        static void setTintList(Drawable drawable, ColorStateList colorStateList) {
            drawable.setTintList(colorStateList);
        }

        static void setTintMode(Drawable drawable, PorterDuff.Mode mode) {
            drawable.setTintMode(mode);
        }
    }

    @Deprecated
    public static boolean isAutoMirrored(Drawable drawable) {
        return drawable.isAutoMirrored();
    }

    @Deprecated
    public static void setAutoMirrored(Drawable drawable, boolean z5) {
        drawable.setAutoMirrored(z5);
    }

    public static void setHotspot(Drawable drawable, float f5, float f6) {
        Api21Impl.setHotspot(drawable, f5, f6);
    }

    public static void setHotspotBounds(Drawable drawable, int i5, int i6, int i7, int i8) {
        Api21Impl.setHotspotBounds(drawable, i5, i6, i7, i8);
    }

    public static void setTint(Drawable drawable, int i5) {
        Api21Impl.setTint(drawable, i5);
    }

    public static void setTintList(Drawable drawable, ColorStateList colorStateList) {
        Api21Impl.setTintList(drawable, colorStateList);
    }

    public static void setTintMode(Drawable drawable, PorterDuff.Mode mode) {
        Api21Impl.setTintMode(drawable, mode);
    }

    public static Drawable wrap(Drawable drawable) {
        return drawable;
    }
}
