package androidx.appcompat.app;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.ViewGroup;
import androidx.appcompat.R$styleable;

/* loaded from: classes.dex */
public abstract class ActionBar$LayoutParams extends ViewGroup.MarginLayoutParams {
    public int gravity;

    public ActionBar$LayoutParams(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gravity = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ActionBarLayout);
        this.gravity = obtainStyledAttributes.getInt(R$styleable.ActionBarLayout_android_layout_gravity, 0);
        obtainStyledAttributes.recycle();
    }

    public ActionBar$LayoutParams(int i5, int i6) {
        super(i5, i6);
        this.gravity = 8388627;
    }

    public ActionBar$LayoutParams(ActionBar$LayoutParams actionBar$LayoutParams) {
        super((ViewGroup.MarginLayoutParams) actionBar$LayoutParams);
        this.gravity = 0;
        this.gravity = actionBar$LayoutParams.gravity;
    }

    public ActionBar$LayoutParams(ViewGroup.LayoutParams layoutParams) {
        super(layoutParams);
        this.gravity = 0;
    }
}
