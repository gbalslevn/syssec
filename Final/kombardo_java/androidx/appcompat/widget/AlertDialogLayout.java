package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.R$id;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;

/* loaded from: classes.dex */
public class AlertDialogLayout extends LinearLayoutCompat {
    public AlertDialogLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private void forceUniformWidth(int i5, int i6) {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824);
        for (int i7 = 0; i7 < i5; i7++) {
            View childAt = getChildAt(i7);
            if (childAt.getVisibility() != 8) {
                LinearLayoutCompat.LayoutParams layoutParams = (LinearLayoutCompat.LayoutParams) childAt.getLayoutParams();
                if (((LinearLayout.LayoutParams) layoutParams).width == -1) {
                    int i8 = ((LinearLayout.LayoutParams) layoutParams).height;
                    ((LinearLayout.LayoutParams) layoutParams).height = childAt.getMeasuredHeight();
                    measureChildWithMargins(childAt, makeMeasureSpec, 0, i6, 0);
                    ((LinearLayout.LayoutParams) layoutParams).height = i8;
                }
            }
        }
    }

    private static int resolveMinimumHeight(View view) {
        int minimumHeight = ViewCompat.getMinimumHeight(view);
        if (minimumHeight > 0) {
            return minimumHeight;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (viewGroup.getChildCount() == 1) {
                return resolveMinimumHeight(viewGroup.getChildAt(0));
            }
        }
        return 0;
    }

    private void setChildFrame(View view, int i5, int i6, int i7, int i8) {
        view.layout(i5, i6, i7 + i5, i8 + i6);
    }

    private boolean tryOnMeasure(int i5, int i6) {
        int i7;
        int i8;
        int i9;
        int i10;
        int childCount = getChildCount();
        View view = null;
        View view2 = null;
        View view3 = null;
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = getChildAt(i11);
            if (childAt.getVisibility() != 8) {
                int id = childAt.getId();
                if (id == R$id.topPanel) {
                    view = childAt;
                } else if (id == R$id.buttonPanel) {
                    view2 = childAt;
                } else {
                    if ((id != R$id.contentPanel && id != R$id.customPanel) || view3 != null) {
                        return false;
                    }
                    view3 = childAt;
                }
            }
        }
        int mode = View.MeasureSpec.getMode(i6);
        int size = View.MeasureSpec.getSize(i6);
        int mode2 = View.MeasureSpec.getMode(i5);
        int paddingTop = getPaddingTop() + getPaddingBottom();
        if (view != null) {
            view.measure(i5, 0);
            paddingTop += view.getMeasuredHeight();
            i7 = View.combineMeasuredStates(0, view.getMeasuredState());
        } else {
            i7 = 0;
        }
        if (view2 != null) {
            view2.measure(i5, 0);
            i8 = resolveMinimumHeight(view2);
            i9 = view2.getMeasuredHeight() - i8;
            paddingTop += i8;
            i7 = View.combineMeasuredStates(i7, view2.getMeasuredState());
        } else {
            i8 = 0;
            i9 = 0;
        }
        if (view3 != null) {
            view3.measure(i5, mode == 0 ? 0 : View.MeasureSpec.makeMeasureSpec(Math.max(0, size - paddingTop), mode));
            i10 = view3.getMeasuredHeight();
            paddingTop += i10;
            i7 = View.combineMeasuredStates(i7, view3.getMeasuredState());
        } else {
            i10 = 0;
        }
        int i12 = size - paddingTop;
        if (view2 != null) {
            int i13 = paddingTop - i8;
            int min = Math.min(i12, i9);
            if (min > 0) {
                i12 -= min;
                i8 += min;
            }
            view2.measure(i5, View.MeasureSpec.makeMeasureSpec(i8, 1073741824));
            paddingTop = i13 + view2.getMeasuredHeight();
            i7 = View.combineMeasuredStates(i7, view2.getMeasuredState());
        }
        if (view3 != null && i12 > 0) {
            view3.measure(i5, View.MeasureSpec.makeMeasureSpec(i10 + i12, mode));
            paddingTop = (paddingTop - i10) + view3.getMeasuredHeight();
            i7 = View.combineMeasuredStates(i7, view3.getMeasuredState());
        }
        int i14 = 0;
        for (int i15 = 0; i15 < childCount; i15++) {
            View childAt2 = getChildAt(i15);
            if (childAt2.getVisibility() != 8) {
                i14 = Math.max(i14, childAt2.getMeasuredWidth());
            }
        }
        setMeasuredDimension(View.resolveSizeAndState(i14 + getPaddingLeft() + getPaddingRight(), i5, i7), View.resolveSizeAndState(paddingTop, i6, 0));
        if (mode2 == 1073741824) {
            return true;
        }
        forceUniformWidth(childCount, i6);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00a9  */
    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onLayout(boolean z5, int i5, int i6, int i7, int i8) {
        int i9;
        int i10;
        int i11;
        int paddingLeft = getPaddingLeft();
        int i12 = i7 - i5;
        int paddingRight = i12 - getPaddingRight();
        int paddingRight2 = (i12 - paddingLeft) - getPaddingRight();
        int measuredHeight = getMeasuredHeight();
        int childCount = getChildCount();
        int gravity = getGravity();
        int i13 = gravity & 112;
        int i14 = gravity & 8388615;
        int paddingTop = i13 != 16 ? i13 != 80 ? getPaddingTop() : ((getPaddingTop() + i8) - i6) - measuredHeight : getPaddingTop() + (((i8 - i6) - measuredHeight) / 2);
        Drawable dividerDrawable = getDividerDrawable();
        int intrinsicHeight = dividerDrawable == null ? 0 : dividerDrawable.getIntrinsicHeight();
        for (int i15 = 0; i15 < childCount; i15++) {
            View childAt = getChildAt(i15);
            if (childAt != null && childAt.getVisibility() != 8) {
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight2 = childAt.getMeasuredHeight();
                LinearLayoutCompat.LayoutParams layoutParams = (LinearLayoutCompat.LayoutParams) childAt.getLayoutParams();
                int i16 = ((LinearLayout.LayoutParams) layoutParams).gravity;
                if (i16 < 0) {
                    i16 = i14;
                }
                int absoluteGravity = GravityCompat.getAbsoluteGravity(i16, getLayoutDirection()) & 7;
                if (absoluteGravity == 1) {
                    i9 = ((paddingRight2 - measuredWidth) / 2) + paddingLeft + ((LinearLayout.LayoutParams) layoutParams).leftMargin;
                    i10 = ((LinearLayout.LayoutParams) layoutParams).rightMargin;
                } else if (absoluteGravity != 5) {
                    i11 = ((LinearLayout.LayoutParams) layoutParams).leftMargin + paddingLeft;
                    if (hasDividerBeforeChildAt(i15)) {
                        paddingTop += intrinsicHeight;
                    }
                    int i17 = paddingTop + ((LinearLayout.LayoutParams) layoutParams).topMargin;
                    setChildFrame(childAt, i11, i17, measuredWidth, measuredHeight2);
                    paddingTop = i17 + measuredHeight2 + ((LinearLayout.LayoutParams) layoutParams).bottomMargin;
                } else {
                    i9 = paddingRight - measuredWidth;
                    i10 = ((LinearLayout.LayoutParams) layoutParams).rightMargin;
                }
                i11 = i9 - i10;
                if (hasDividerBeforeChildAt(i15)) {
                }
                int i172 = paddingTop + ((LinearLayout.LayoutParams) layoutParams).topMargin;
                setChildFrame(childAt, i11, i172, measuredWidth, measuredHeight2);
                paddingTop = i172 + measuredHeight2 + ((LinearLayout.LayoutParams) layoutParams).bottomMargin;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.View
    public void onMeasure(int i5, int i6) {
        if (tryOnMeasure(i5, i6)) {
            return;
        }
        super.onMeasure(i5, i6);
    }
}
