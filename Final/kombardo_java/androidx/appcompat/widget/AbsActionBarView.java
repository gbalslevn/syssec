package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$styleable;

/* loaded from: classes.dex */
abstract class AbsActionBarView extends ViewGroup {
    private static final int FADE_DURATION = 200;
    protected ActionMenuPresenter mActionMenuPresenter;
    protected int mContentHeight;
    private boolean mEatingHover;
    private boolean mEatingTouch;
    protected ActionMenuView mMenuView;
    protected final Context mPopupContext;
    protected final VisibilityAnimListener mVisAnimListener;

    /* loaded from: classes.dex */
    protected class VisibilityAnimListener {
        private boolean mCanceled = false;

        protected VisibilityAnimListener() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AbsActionBarView(Context context, AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
        this.mVisAnimListener = new VisibilityAnimListener();
        TypedValue typedValue = new TypedValue();
        if (!context.getTheme().resolveAttribute(R$attr.actionBarPopupTheme, typedValue, true) || typedValue.resourceId == 0) {
            this.mPopupContext = context;
        } else {
            this.mPopupContext = new ContextThemeWrapper(context, typedValue.resourceId);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static int next(int i5, int i6, boolean z5) {
        return z5 ? i5 - i6 : i5 + i6;
    }

    public int getAnimatedVisibility() {
        return getVisibility();
    }

    public int getContentHeight() {
        return this.mContentHeight;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int measureChildView(View view, int i5, int i6, int i7) {
        view.measure(View.MeasureSpec.makeMeasureSpec(i5, Integer.MIN_VALUE), i6);
        return Math.max(0, (i5 - view.getMeasuredWidth()) - i7);
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(null, R$styleable.ActionBar, R$attr.actionBarStyle, 0);
        setContentHeight(obtainStyledAttributes.getLayoutDimension(R$styleable.ActionBar_height, 0));
        obtainStyledAttributes.recycle();
        ActionMenuPresenter actionMenuPresenter = this.mActionMenuPresenter;
        if (actionMenuPresenter != null) {
            actionMenuPresenter.onConfigurationChanged(configuration);
        }
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.mEatingHover = false;
        }
        if (!this.mEatingHover) {
            boolean onHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !onHoverEvent) {
                this.mEatingHover = true;
            }
        }
        if (actionMasked == 10 || actionMasked == 3) {
            this.mEatingHover = false;
        }
        return true;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.mEatingTouch = false;
        }
        if (!this.mEatingTouch) {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !onTouchEvent) {
                this.mEatingTouch = true;
            }
        }
        if (actionMasked == 1 || actionMasked == 3) {
            this.mEatingTouch = false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int positionChild(View view, int i5, int i6, int i7, boolean z5) {
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        int i8 = i6 + ((i7 - measuredHeight) / 2);
        if (z5) {
            view.layout(i5 - measuredWidth, i8, i5, measuredHeight + i8);
        } else {
            view.layout(i5, i8, i5 + measuredWidth, measuredHeight + i8);
        }
        return z5 ? -measuredWidth : measuredWidth;
    }

    public abstract void setContentHeight(int i5);

    @Override // android.view.View
    public void setVisibility(int i5) {
        if (i5 != getVisibility()) {
            super.setVisibility(i5);
        }
    }
}
