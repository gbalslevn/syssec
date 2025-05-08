package androidx.appcompat.content.res;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import androidx.appcompat.widget.ResourceManagerInternal;
import androidx.core.content.ContextCompat;

/* loaded from: classes.dex */
public abstract class AppCompatResources {
    public static ColorStateList getColorStateList(Context context, int i5) {
        return ContextCompat.getColorStateList(context, i5);
    }

    public static Drawable getDrawable(Context context, int i5) {
        return ResourceManagerInternal.get().getDrawable(context, i5);
    }
}
