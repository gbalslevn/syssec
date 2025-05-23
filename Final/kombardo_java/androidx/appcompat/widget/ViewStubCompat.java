package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.appcompat.R$styleable;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public final class ViewStubCompat extends View {
    private OnInflateListener mInflateListener;
    private int mInflatedId;
    private WeakReference<View> mInflatedViewRef;
    private LayoutInflater mInflater;
    private int mLayoutResource;

    /* loaded from: classes.dex */
    public interface OnInflateListener {
    }

    public ViewStubCompat(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // android.view.View
    protected void dispatchDraw(Canvas canvas) {
    }

    @Override // android.view.View
    @SuppressLint({"MissingSuperCall"})
    public void draw(Canvas canvas) {
    }

    public int getInflatedId() {
        return this.mInflatedId;
    }

    public LayoutInflater getLayoutInflater() {
        return this.mInflater;
    }

    public int getLayoutResource() {
        return this.mLayoutResource;
    }

    public View inflate() {
        ViewParent parent = getParent();
        if (!(parent instanceof ViewGroup)) {
            throw new IllegalStateException("ViewStub must have a non-null ViewGroup viewParent");
        }
        if (this.mLayoutResource == 0) {
            throw new IllegalArgumentException("ViewStub must have a valid layoutResource");
        }
        ViewGroup viewGroup = (ViewGroup) parent;
        LayoutInflater layoutInflater = this.mInflater;
        if (layoutInflater == null) {
            layoutInflater = LayoutInflater.from(getContext());
        }
        View inflate = layoutInflater.inflate(this.mLayoutResource, viewGroup, false);
        int i5 = this.mInflatedId;
        if (i5 != -1) {
            inflate.setId(i5);
        }
        int indexOfChild = viewGroup.indexOfChild(this);
        viewGroup.removeViewInLayout(this);
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams != null) {
            viewGroup.addView(inflate, indexOfChild, layoutParams);
        } else {
            viewGroup.addView(inflate, indexOfChild);
        }
        this.mInflatedViewRef = new WeakReference<>(inflate);
        return inflate;
    }

    @Override // android.view.View
    protected void onMeasure(int i5, int i6) {
        setMeasuredDimension(0, 0);
    }

    public void setInflatedId(int i5) {
        this.mInflatedId = i5;
    }

    public void setLayoutInflater(LayoutInflater layoutInflater) {
        this.mInflater = layoutInflater;
    }

    public void setLayoutResource(int i5) {
        this.mLayoutResource = i5;
    }

    public void setOnInflateListener(OnInflateListener onInflateListener) {
    }

    @Override // android.view.View
    public void setVisibility(int i5) {
        WeakReference<View> weakReference = this.mInflatedViewRef;
        if (weakReference != null) {
            View view = weakReference.get();
            if (view == null) {
                throw new IllegalStateException("setVisibility called on un-referenced view");
            }
            view.setVisibility(i5);
            return;
        }
        super.setVisibility(i5);
        if (i5 == 0 || i5 == 4) {
            inflate();
        }
    }

    public ViewStubCompat(Context context, AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
        this.mLayoutResource = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ViewStubCompat, i5, 0);
        this.mInflatedId = obtainStyledAttributes.getResourceId(R$styleable.ViewStubCompat_android_inflatedId, -1);
        this.mLayoutResource = obtainStyledAttributes.getResourceId(R$styleable.ViewStubCompat_android_layout, 0);
        setId(obtainStyledAttributes.getResourceId(R$styleable.ViewStubCompat_android_id, -1));
        obtainStyledAttributes.recycle();
        setVisibility(8);
        setWillNotDraw(true);
    }
}
