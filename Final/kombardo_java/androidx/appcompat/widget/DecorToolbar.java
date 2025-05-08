package androidx.appcompat.widget;

import android.graphics.drawable.Drawable;
import android.view.Window;

/* loaded from: classes.dex */
public interface DecorToolbar {
    CharSequence getTitle();

    void setIcon(int i5);

    void setIcon(Drawable drawable);

    void setLogo(int i5);

    void setWindowCallback(Window.Callback callback);

    void setWindowTitle(CharSequence charSequence);
}
