package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import androidx.appcompat.R$id;
import androidx.appcompat.R$styleable;
import androidx.core.view.ViewCompat;

/* loaded from: classes.dex */
public class ButtonBarLayout extends LinearLayout {
    private static final int PEEK_BUTTON_DP = 16;
    private boolean mAllowStacking;
    private int mLastWidthSize;
    private boolean mStacked;

    public ButtonBarLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mLastWidthSize = -1;
        int[] iArr = R$styleable.ButtonBarLayout;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr);
        ViewCompat.saveAttributeDataForStyleable(this, context, iArr, attributeSet, obtainStyledAttributes, 0, 0);
        this.mAllowStacking = obtainStyledAttributes.getBoolean(R$styleable.ButtonBarLayout_allowStacking, true);
        obtainStyledAttributes.recycle();
        if (getOrientation() == 1) {
            setStacked(this.mAllowStacking);
        }
    }

    private int getNextVisibleChildIndex(int i5) {
        int childCount = getChildCount();
        while (i5 < childCount) {
            if (getChildAt(i5).getVisibility() == 0) {
                return i5;
            }
            i5++;
        }
        return -1;
    }

    private boolean isStacked() {
        return this.mStacked;
    }

    private void setStacked(boolean z5) {
        if (this.mStacked != z5) {
            if (!z5 || this.mAllowStacking) {
                this.mStacked = z5;
                setOrientation(z5 ? 1 : 0);
                setGravity(z5 ? 8388613 : 80);
                View findViewById = findViewById(R$id.spacer);
                if (findViewById != null) {
                    findViewById.setVisibility(z5 ? 8 : 4);
                }
                for (int childCount = getChildCount() - 2; childCount >= 0; childCount--) {
                    bringChildToFront(getChildAt(childCount));
                }
            }
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i5, int i6) {
        int i7;
        boolean z5;
        int size = View.MeasureSpec.getSize(i5);
        int i8 = 0;
        if (this.mAllowStacking) {
            if (size > this.mLastWidthSize && isStacked()) {
                setStacked(false);
            }
            this.mLastWidthSize = size;
        }
        if (isStacked() || View.MeasureSpec.getMode(i5) != 1073741824) {
            i7 = i5;
            z5 = false;
        } else {
            i7 = View.MeasureSpec.makeMeasureSpec(size, Integer.MIN_VALUE);
            z5 = true;
        }
        super.onMeasure(i7, i6);
        if (this.mAllowStacking && !isStacked() && (getMeasuredWidthAndState() & (-16777216)) == 16777216) {
            setStacked(true);
            z5 = true;
        }
        if (z5) {
            super.onMeasure(i5, i6);
        }
        int nextVisibleChildIndex = getNextVisibleChildIndex(0);
        if (nextVisibleChildIndex >= 0) {
            View childAt = getChildAt(nextVisibleChildIndex);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) childAt.getLayoutParams();
            int paddingTop = getPaddingTop() + childAt.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
            if (isStacked()) {
                int nextVisibleChildIndex2 = getNextVisibleChildIndex(nextVisibleChildIndex + 1);
                if (nextVisibleChildIndex2 >= 0) {
                    paddingTop += getChildAt(nextVisibleChildIndex2).getPaddingTop() + ((int) (getResources().getDisplayMetrics().density * 16.0f));
                }
                i8 = paddingTop;
            } else {
                i8 = paddingTop + getPaddingBottom();
            }
        }
        if (ViewCompat.getMinimumHeight(this) != i8) {
            setMinimumHeight(i8);
            if (i6 == 0) {
                super.onMeasure(i5, i6);
            }
        }
    }

    public void setAllowStacking(boolean z5) {
        if (this.mAllowStacking != z5) {
            this.mAllowStacking = z5;
            if (!z5 && isStacked()) {
                setStacked(false);
            }
            requestLayout();
        }
    }
}
