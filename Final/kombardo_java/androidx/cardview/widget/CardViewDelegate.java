package androidx.cardview.widget;

import android.graphics.drawable.Drawable;
import android.view.View;

/* loaded from: classes.dex */
interface CardViewDelegate {
    Drawable getCardBackground();

    View getCardView();

    boolean getPreventCornerOverlap();

    boolean getUseCompatPadding();

    void setCardBackground(Drawable drawable);

    void setShadowPadding(int i5, int i6, int i7, int i8);
}
