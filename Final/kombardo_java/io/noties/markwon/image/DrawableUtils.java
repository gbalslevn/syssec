package io.noties.markwon.image;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;

/* loaded from: classes2.dex */
public abstract class DrawableUtils {
    public static void applyIntrinsicBoundsIfEmpty(Drawable drawable) {
        if (drawable.getBounds().isEmpty()) {
            drawable.setBounds(intrinsicBounds(drawable));
        }
    }

    public static Rect intrinsicBounds(Drawable drawable) {
        return new Rect(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
    }
}
