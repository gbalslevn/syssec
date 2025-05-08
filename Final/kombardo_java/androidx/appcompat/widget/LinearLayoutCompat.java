package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.LinearLayout;
import androidx.appcompat.R$styleable;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;

/* loaded from: classes.dex */
public abstract class LinearLayoutCompat extends ViewGroup {
    private static final String ACCESSIBILITY_CLASS_NAME = "androidx.appcompat.widget.LinearLayoutCompat";
    private static final int INDEX_BOTTOM = 2;
    private static final int INDEX_CENTER_VERTICAL = 0;
    private static final int INDEX_FILL = 3;
    private static final int INDEX_TOP = 1;
    private static final int VERTICAL_GRAVITY_COUNT = 4;
    private boolean mBaselineAligned;
    private int mBaselineAlignedChildIndex;
    private int mBaselineChildTop;
    private Drawable mDivider;
    private int mDividerHeight;
    private int mDividerPadding;
    private int mDividerWidth;
    private int mGravity;
    private int[] mMaxAscent;
    private int[] mMaxDescent;
    private int mOrientation;
    private int mShowDividers;
    private int mTotalLength;
    private boolean mUseLargestChild;
    private float mWeightSum;

    /* loaded from: classes.dex */
    public static class LayoutParams extends LinearLayout.LayoutParams {
        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams(int i5, int i6) {
            super(i5, i6);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }
    }

    public LinearLayoutCompat(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void forceUniformHeight(int i5, int i6) {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824);
        for (int i7 = 0; i7 < i5; i7++) {
            View virtualChildAt = getVirtualChildAt(i7);
            if (virtualChildAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) virtualChildAt.getLayoutParams();
                if (((LinearLayout.LayoutParams) layoutParams).height == -1) {
                    int i8 = ((LinearLayout.LayoutParams) layoutParams).width;
                    ((LinearLayout.LayoutParams) layoutParams).width = virtualChildAt.getMeasuredWidth();
                    measureChildWithMargins(virtualChildAt, i6, 0, makeMeasureSpec, 0);
                    ((LinearLayout.LayoutParams) layoutParams).width = i8;
                }
            }
        }
    }

    private void forceUniformWidth(int i5, int i6) {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824);
        for (int i7 = 0; i7 < i5; i7++) {
            View virtualChildAt = getVirtualChildAt(i7);
            if (virtualChildAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) virtualChildAt.getLayoutParams();
                if (((LinearLayout.LayoutParams) layoutParams).width == -1) {
                    int i8 = ((LinearLayout.LayoutParams) layoutParams).height;
                    ((LinearLayout.LayoutParams) layoutParams).height = virtualChildAt.getMeasuredHeight();
                    measureChildWithMargins(virtualChildAt, makeMeasureSpec, 0, i6, 0);
                    ((LinearLayout.LayoutParams) layoutParams).height = i8;
                }
            }
        }
    }

    private void setChildFrame(View view, int i5, int i6, int i7, int i8) {
        view.layout(i5, i6, i7 + i5, i8 + i6);
    }

    @Override // android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    void drawDividersHorizontal(Canvas canvas) {
        int right;
        int left;
        int i5;
        int virtualChildCount = getVirtualChildCount();
        boolean isLayoutRtl = ViewUtils.isLayoutRtl(this);
        for (int i6 = 0; i6 < virtualChildCount; i6++) {
            View virtualChildAt = getVirtualChildAt(i6);
            if (virtualChildAt != null && virtualChildAt.getVisibility() != 8 && hasDividerBeforeChildAt(i6)) {
                LayoutParams layoutParams = (LayoutParams) virtualChildAt.getLayoutParams();
                drawVerticalDivider(canvas, isLayoutRtl ? virtualChildAt.getRight() + ((LinearLayout.LayoutParams) layoutParams).rightMargin : (virtualChildAt.getLeft() - ((LinearLayout.LayoutParams) layoutParams).leftMargin) - this.mDividerWidth);
            }
        }
        if (hasDividerBeforeChildAt(virtualChildCount)) {
            View virtualChildAt2 = getVirtualChildAt(virtualChildCount - 1);
            if (virtualChildAt2 != null) {
                LayoutParams layoutParams2 = (LayoutParams) virtualChildAt2.getLayoutParams();
                if (isLayoutRtl) {
                    left = virtualChildAt2.getLeft() - ((LinearLayout.LayoutParams) layoutParams2).leftMargin;
                    i5 = this.mDividerWidth;
                    right = left - i5;
                } else {
                    right = virtualChildAt2.getRight() + ((LinearLayout.LayoutParams) layoutParams2).rightMargin;
                }
            } else if (isLayoutRtl) {
                right = getPaddingLeft();
            } else {
                left = getWidth() - getPaddingRight();
                i5 = this.mDividerWidth;
                right = left - i5;
            }
            drawVerticalDivider(canvas, right);
        }
    }

    void drawDividersVertical(Canvas canvas) {
        int virtualChildCount = getVirtualChildCount();
        for (int i5 = 0; i5 < virtualChildCount; i5++) {
            View virtualChildAt = getVirtualChildAt(i5);
            if (virtualChildAt != null && virtualChildAt.getVisibility() != 8 && hasDividerBeforeChildAt(i5)) {
                drawHorizontalDivider(canvas, (virtualChildAt.getTop() - ((LinearLayout.LayoutParams) ((LayoutParams) virtualChildAt.getLayoutParams())).topMargin) - this.mDividerHeight);
            }
        }
        if (hasDividerBeforeChildAt(virtualChildCount)) {
            View virtualChildAt2 = getVirtualChildAt(virtualChildCount - 1);
            drawHorizontalDivider(canvas, virtualChildAt2 == null ? (getHeight() - getPaddingBottom()) - this.mDividerHeight : virtualChildAt2.getBottom() + ((LinearLayout.LayoutParams) ((LayoutParams) virtualChildAt2.getLayoutParams())).bottomMargin);
        }
    }

    void drawHorizontalDivider(Canvas canvas, int i5) {
        this.mDivider.setBounds(getPaddingLeft() + this.mDividerPadding, i5, (getWidth() - getPaddingRight()) - this.mDividerPadding, this.mDividerHeight + i5);
        this.mDivider.draw(canvas);
    }

    void drawVerticalDivider(Canvas canvas, int i5) {
        this.mDivider.setBounds(i5, getPaddingTop() + this.mDividerPadding, this.mDividerWidth + i5, (getHeight() - getPaddingBottom()) - this.mDividerPadding);
        this.mDivider.draw(canvas);
    }

    @Override // android.view.View
    public int getBaseline() {
        int i5;
        if (this.mBaselineAlignedChildIndex < 0) {
            return super.getBaseline();
        }
        int childCount = getChildCount();
        int i6 = this.mBaselineAlignedChildIndex;
        if (childCount <= i6) {
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout set to an index that is out of bounds.");
        }
        View childAt = getChildAt(i6);
        int baseline = childAt.getBaseline();
        if (baseline == -1) {
            if (this.mBaselineAlignedChildIndex == 0) {
                return -1;
            }
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout points to a View that doesn't know how to get its baseline.");
        }
        int i7 = this.mBaselineChildTop;
        if (this.mOrientation == 1 && (i5 = this.mGravity & 112) != 48) {
            if (i5 == 16) {
                i7 += ((((getBottom() - getTop()) - getPaddingTop()) - getPaddingBottom()) - this.mTotalLength) / 2;
            } else if (i5 == 80) {
                i7 = ((getBottom() - getTop()) - getPaddingBottom()) - this.mTotalLength;
            }
        }
        return i7 + ((LinearLayout.LayoutParams) ((LayoutParams) childAt.getLayoutParams())).topMargin + baseline;
    }

    public int getBaselineAlignedChildIndex() {
        return this.mBaselineAlignedChildIndex;
    }

    int getChildrenSkipCount(View view, int i5) {
        return 0;
    }

    public Drawable getDividerDrawable() {
        return this.mDivider;
    }

    public int getDividerPadding() {
        return this.mDividerPadding;
    }

    public int getDividerWidth() {
        return this.mDividerWidth;
    }

    public int getGravity() {
        return this.mGravity;
    }

    int getLocationOffset(View view) {
        return 0;
    }

    int getNextLocationOffset(View view) {
        return 0;
    }

    public int getOrientation() {
        return this.mOrientation;
    }

    public int getShowDividers() {
        return this.mShowDividers;
    }

    View getVirtualChildAt(int i5) {
        return getChildAt(i5);
    }

    int getVirtualChildCount() {
        return getChildCount();
    }

    public float getWeightSum() {
        return this.mWeightSum;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean hasDividerBeforeChildAt(int i5) {
        if (i5 == 0) {
            return (this.mShowDividers & 1) != 0;
        }
        if (i5 == getChildCount()) {
            return (this.mShowDividers & 4) != 0;
        }
        if ((this.mShowDividers & 2) == 0) {
            return false;
        }
        for (int i6 = i5 - 1; i6 >= 0; i6--) {
            if (getChildAt(i6).getVisibility() != 8) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00ec  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    void layoutHorizontal(int i5, int i6, int i7, int i8) {
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        boolean z5;
        int i14;
        int i15;
        int i16;
        int i17;
        boolean isLayoutRtl = ViewUtils.isLayoutRtl(this);
        int paddingTop = getPaddingTop();
        int i18 = i8 - i6;
        int paddingBottom = i18 - getPaddingBottom();
        int paddingBottom2 = (i18 - paddingTop) - getPaddingBottom();
        int virtualChildCount = getVirtualChildCount();
        int i19 = this.mGravity;
        int i20 = i19 & 112;
        boolean z6 = this.mBaselineAligned;
        int[] iArr = this.mMaxAscent;
        int[] iArr2 = this.mMaxDescent;
        int absoluteGravity = GravityCompat.getAbsoluteGravity(8388615 & i19, getLayoutDirection());
        boolean z7 = true;
        int paddingLeft = absoluteGravity != 1 ? absoluteGravity != 5 ? getPaddingLeft() : ((getPaddingLeft() + i7) - i5) - this.mTotalLength : getPaddingLeft() + (((i7 - i5) - this.mTotalLength) / 2);
        if (isLayoutRtl) {
            i9 = virtualChildCount - 1;
            i10 = -1;
        } else {
            i9 = 0;
            i10 = 1;
        }
        int i21 = 0;
        while (i21 < virtualChildCount) {
            int i22 = i9 + (i10 * i21);
            View virtualChildAt = getVirtualChildAt(i22);
            if (virtualChildAt == null) {
                paddingLeft += measureNullChild(i22);
                z5 = z7;
                i11 = paddingTop;
                i12 = virtualChildCount;
                i13 = i20;
            } else if (virtualChildAt.getVisibility() != 8) {
                int measuredWidth = virtualChildAt.getMeasuredWidth();
                int measuredHeight = virtualChildAt.getMeasuredHeight();
                LayoutParams layoutParams = (LayoutParams) virtualChildAt.getLayoutParams();
                int i23 = i21;
                if (z6) {
                    i12 = virtualChildCount;
                    if (((LinearLayout.LayoutParams) layoutParams).height != -1) {
                        i14 = virtualChildAt.getBaseline();
                        i15 = ((LinearLayout.LayoutParams) layoutParams).gravity;
                        if (i15 < 0) {
                            i15 = i20;
                        }
                        i16 = i15 & 112;
                        i13 = i20;
                        if (i16 == 16) {
                            if (i16 == 48) {
                                i17 = ((LinearLayout.LayoutParams) layoutParams).topMargin + paddingTop;
                                if (i14 != -1) {
                                    z5 = true;
                                    i17 += iArr[1] - i14;
                                }
                            } else if (i16 != 80) {
                                i17 = paddingTop;
                            } else {
                                i17 = (paddingBottom - measuredHeight) - ((LinearLayout.LayoutParams) layoutParams).bottomMargin;
                                if (i14 != -1) {
                                    i17 -= iArr2[2] - (virtualChildAt.getMeasuredHeight() - i14);
                                }
                            }
                            z5 = true;
                        } else {
                            z5 = true;
                            i17 = ((((paddingBottom2 - measuredHeight) / 2) + paddingTop) + ((LinearLayout.LayoutParams) layoutParams).topMargin) - ((LinearLayout.LayoutParams) layoutParams).bottomMargin;
                        }
                        if (hasDividerBeforeChildAt(i22)) {
                            paddingLeft += this.mDividerWidth;
                        }
                        int i24 = ((LinearLayout.LayoutParams) layoutParams).leftMargin + paddingLeft;
                        i11 = paddingTop;
                        setChildFrame(virtualChildAt, i24 + getLocationOffset(virtualChildAt), i17, measuredWidth, measuredHeight);
                        int nextLocationOffset = i24 + measuredWidth + ((LinearLayout.LayoutParams) layoutParams).rightMargin + getNextLocationOffset(virtualChildAt);
                        i21 = i23 + getChildrenSkipCount(virtualChildAt, i22);
                        paddingLeft = nextLocationOffset;
                        i21++;
                        virtualChildCount = i12;
                        i20 = i13;
                        z7 = z5;
                        paddingTop = i11;
                    }
                } else {
                    i12 = virtualChildCount;
                }
                i14 = -1;
                i15 = ((LinearLayout.LayoutParams) layoutParams).gravity;
                if (i15 < 0) {
                }
                i16 = i15 & 112;
                i13 = i20;
                if (i16 == 16) {
                }
                if (hasDividerBeforeChildAt(i22)) {
                }
                int i242 = ((LinearLayout.LayoutParams) layoutParams).leftMargin + paddingLeft;
                i11 = paddingTop;
                setChildFrame(virtualChildAt, i242 + getLocationOffset(virtualChildAt), i17, measuredWidth, measuredHeight);
                int nextLocationOffset2 = i242 + measuredWidth + ((LinearLayout.LayoutParams) layoutParams).rightMargin + getNextLocationOffset(virtualChildAt);
                i21 = i23 + getChildrenSkipCount(virtualChildAt, i22);
                paddingLeft = nextLocationOffset2;
                i21++;
                virtualChildCount = i12;
                i20 = i13;
                z7 = z5;
                paddingTop = i11;
            } else {
                i11 = paddingTop;
                i12 = virtualChildCount;
                i13 = i20;
                z5 = true;
            }
            i21++;
            virtualChildCount = i12;
            i20 = i13;
            z7 = z5;
            paddingTop = i11;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x00a1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    void layoutVertical(int i5, int i6, int i7, int i8) {
        int i9;
        int i10;
        int i11;
        int i12;
        int paddingLeft = getPaddingLeft();
        int i13 = i7 - i5;
        int paddingRight = i13 - getPaddingRight();
        int paddingRight2 = (i13 - paddingLeft) - getPaddingRight();
        int virtualChildCount = getVirtualChildCount();
        int i14 = this.mGravity;
        int i15 = i14 & 112;
        int i16 = i14 & 8388615;
        int paddingTop = i15 != 16 ? i15 != 80 ? getPaddingTop() : ((getPaddingTop() + i8) - i6) - this.mTotalLength : getPaddingTop() + (((i8 - i6) - this.mTotalLength) / 2);
        int i17 = 0;
        while (i17 < virtualChildCount) {
            View virtualChildAt = getVirtualChildAt(i17);
            if (virtualChildAt == null) {
                paddingTop += measureNullChild(i17);
            } else if (virtualChildAt.getVisibility() != 8) {
                int measuredWidth = virtualChildAt.getMeasuredWidth();
                int measuredHeight = virtualChildAt.getMeasuredHeight();
                LayoutParams layoutParams = (LayoutParams) virtualChildAt.getLayoutParams();
                int i18 = ((LinearLayout.LayoutParams) layoutParams).gravity;
                if (i18 < 0) {
                    i18 = i16;
                }
                int absoluteGravity = GravityCompat.getAbsoluteGravity(i18, getLayoutDirection()) & 7;
                if (absoluteGravity == 1) {
                    i9 = ((paddingRight2 - measuredWidth) / 2) + paddingLeft + ((LinearLayout.LayoutParams) layoutParams).leftMargin;
                    i10 = ((LinearLayout.LayoutParams) layoutParams).rightMargin;
                } else if (absoluteGravity != 5) {
                    i11 = ((LinearLayout.LayoutParams) layoutParams).leftMargin + paddingLeft;
                    int i19 = i11;
                    if (hasDividerBeforeChildAt(i17)) {
                        paddingTop += this.mDividerHeight;
                    }
                    int i20 = paddingTop + ((LinearLayout.LayoutParams) layoutParams).topMargin;
                    setChildFrame(virtualChildAt, i19, i20 + getLocationOffset(virtualChildAt), measuredWidth, measuredHeight);
                    int nextLocationOffset = i20 + measuredHeight + ((LinearLayout.LayoutParams) layoutParams).bottomMargin + getNextLocationOffset(virtualChildAt);
                    i17 += getChildrenSkipCount(virtualChildAt, i17);
                    paddingTop = nextLocationOffset;
                    i12 = 1;
                    i17 += i12;
                } else {
                    i9 = paddingRight - measuredWidth;
                    i10 = ((LinearLayout.LayoutParams) layoutParams).rightMargin;
                }
                i11 = i9 - i10;
                int i192 = i11;
                if (hasDividerBeforeChildAt(i17)) {
                }
                int i202 = paddingTop + ((LinearLayout.LayoutParams) layoutParams).topMargin;
                setChildFrame(virtualChildAt, i192, i202 + getLocationOffset(virtualChildAt), measuredWidth, measuredHeight);
                int nextLocationOffset2 = i202 + measuredHeight + ((LinearLayout.LayoutParams) layoutParams).bottomMargin + getNextLocationOffset(virtualChildAt);
                i17 += getChildrenSkipCount(virtualChildAt, i17);
                paddingTop = nextLocationOffset2;
                i12 = 1;
                i17 += i12;
            }
            i12 = 1;
            i17 += i12;
        }
    }

    void measureChildBeforeLayout(View view, int i5, int i6, int i7, int i8, int i9) {
        measureChildWithMargins(view, i6, i7, i8, i9);
    }

    /* JADX WARN: Removed duplicated region for block: B:200:0x045b  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0197  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x01cb  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x01d9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    void measureHorizontal(int i5, int i6) {
        int[] iArr;
        int i7;
        int max;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        float f5;
        int i14;
        boolean z5;
        int baseline;
        int i15;
        int i16;
        int i17;
        char c5;
        int i18;
        int i19;
        boolean z6;
        boolean z7;
        View view;
        int i20;
        boolean z8;
        int measuredHeight;
        int childrenSkipCount;
        int baseline2;
        int i21;
        this.mTotalLength = 0;
        int virtualChildCount = getVirtualChildCount();
        int mode = View.MeasureSpec.getMode(i5);
        int mode2 = View.MeasureSpec.getMode(i6);
        if (this.mMaxAscent == null || this.mMaxDescent == null) {
            this.mMaxAscent = new int[4];
            this.mMaxDescent = new int[4];
        }
        int[] iArr2 = this.mMaxAscent;
        int[] iArr3 = this.mMaxDescent;
        iArr2[3] = -1;
        iArr2[2] = -1;
        iArr2[1] = -1;
        iArr2[0] = -1;
        iArr3[3] = -1;
        iArr3[2] = -1;
        iArr3[1] = -1;
        iArr3[0] = -1;
        boolean z9 = this.mBaselineAligned;
        boolean z10 = this.mUseLargestChild;
        int i22 = 1073741824;
        boolean z11 = mode == 1073741824;
        int i23 = 0;
        int i24 = 0;
        int i25 = 0;
        int i26 = 0;
        int i27 = 0;
        boolean z12 = false;
        int i28 = 0;
        boolean z13 = false;
        boolean z14 = true;
        float f6 = 0.0f;
        while (true) {
            iArr = iArr3;
            if (i23 >= virtualChildCount) {
                break;
            }
            View virtualChildAt = getVirtualChildAt(i23);
            if (virtualChildAt == null) {
                this.mTotalLength += measureNullChild(i23);
            } else if (virtualChildAt.getVisibility() == 8) {
                i23 += getChildrenSkipCount(virtualChildAt, i23);
            } else {
                if (hasDividerBeforeChildAt(i23)) {
                    this.mTotalLength += this.mDividerWidth;
                }
                LayoutParams layoutParams = (LayoutParams) virtualChildAt.getLayoutParams();
                float f7 = ((LinearLayout.LayoutParams) layoutParams).weight;
                float f8 = f6 + f7;
                if (mode == i22 && ((LinearLayout.LayoutParams) layoutParams).width == 0 && f7 > 0.0f) {
                    if (z11) {
                        this.mTotalLength += ((LinearLayout.LayoutParams) layoutParams).leftMargin + ((LinearLayout.LayoutParams) layoutParams).rightMargin;
                    } else {
                        int i29 = this.mTotalLength;
                        this.mTotalLength = Math.max(i29, ((LinearLayout.LayoutParams) layoutParams).leftMargin + i29 + ((LinearLayout.LayoutParams) layoutParams).rightMargin);
                    }
                    if (z9) {
                        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                        virtualChildAt.measure(makeMeasureSpec, makeMeasureSpec);
                        i19 = i23;
                        z6 = z10;
                        z7 = z9;
                        view = virtualChildAt;
                    } else {
                        i19 = i23;
                        z6 = z10;
                        z7 = z9;
                        view = virtualChildAt;
                        z12 = true;
                        i20 = 1073741824;
                        if (mode2 == i20 && ((LinearLayout.LayoutParams) layoutParams).height == -1) {
                            z8 = true;
                            z13 = true;
                        } else {
                            z8 = false;
                        }
                        int i30 = ((LinearLayout.LayoutParams) layoutParams).topMargin + ((LinearLayout.LayoutParams) layoutParams).bottomMargin;
                        measuredHeight = view.getMeasuredHeight() + i30;
                        i28 = View.combineMeasuredStates(i28, view.getMeasuredState());
                        if (z7 && (baseline2 = view.getBaseline()) != -1) {
                            i21 = ((LinearLayout.LayoutParams) layoutParams).gravity;
                            if (i21 < 0) {
                                i21 = this.mGravity;
                            }
                            int i31 = (((i21 & 112) >> 4) & (-2)) >> 1;
                            iArr2[i31] = Math.max(iArr2[i31], baseline2);
                            iArr[i31] = Math.max(iArr[i31], measuredHeight - baseline2);
                        }
                        i25 = Math.max(i25, measuredHeight);
                        z14 = !z14 && ((LinearLayout.LayoutParams) layoutParams).height == -1;
                        if (((LinearLayout.LayoutParams) layoutParams).weight <= 0.0f) {
                            if (!z8) {
                                i30 = measuredHeight;
                            }
                            i27 = Math.max(i27, i30);
                        } else {
                            int i32 = i27;
                            if (!z8) {
                                i30 = measuredHeight;
                            }
                            i26 = Math.max(i26, i30);
                            i27 = i32;
                        }
                        int i33 = i19;
                        childrenSkipCount = getChildrenSkipCount(view, i33) + i33;
                        f6 = f8;
                        int i34 = childrenSkipCount + 1;
                        iArr3 = iArr;
                        z10 = z6;
                        z9 = z7;
                        i22 = i20;
                        i23 = i34;
                    }
                } else {
                    if (((LinearLayout.LayoutParams) layoutParams).width != 0 || f7 <= 0.0f) {
                        c5 = 65534;
                        i18 = Integer.MIN_VALUE;
                    } else {
                        c5 = 65534;
                        ((LinearLayout.LayoutParams) layoutParams).width = -2;
                        i18 = 0;
                    }
                    i19 = i23;
                    int i35 = i18;
                    z6 = z10;
                    z7 = z9;
                    measureChildBeforeLayout(virtualChildAt, i19, i5, f8 == 0.0f ? this.mTotalLength : 0, i6, 0);
                    if (i35 != Integer.MIN_VALUE) {
                        ((LinearLayout.LayoutParams) layoutParams).width = i35;
                    }
                    int measuredWidth = virtualChildAt.getMeasuredWidth();
                    if (z11) {
                        view = virtualChildAt;
                        this.mTotalLength += ((LinearLayout.LayoutParams) layoutParams).leftMargin + measuredWidth + ((LinearLayout.LayoutParams) layoutParams).rightMargin + getNextLocationOffset(view);
                    } else {
                        view = virtualChildAt;
                        int i36 = this.mTotalLength;
                        this.mTotalLength = Math.max(i36, i36 + measuredWidth + ((LinearLayout.LayoutParams) layoutParams).leftMargin + ((LinearLayout.LayoutParams) layoutParams).rightMargin + getNextLocationOffset(view));
                    }
                    if (z6) {
                        i24 = Math.max(measuredWidth, i24);
                    }
                }
                i20 = 1073741824;
                if (mode2 == i20) {
                }
                z8 = false;
                int i302 = ((LinearLayout.LayoutParams) layoutParams).topMargin + ((LinearLayout.LayoutParams) layoutParams).bottomMargin;
                measuredHeight = view.getMeasuredHeight() + i302;
                i28 = View.combineMeasuredStates(i28, view.getMeasuredState());
                if (z7) {
                    i21 = ((LinearLayout.LayoutParams) layoutParams).gravity;
                    if (i21 < 0) {
                    }
                    int i312 = (((i21 & 112) >> 4) & (-2)) >> 1;
                    iArr2[i312] = Math.max(iArr2[i312], baseline2);
                    iArr[i312] = Math.max(iArr[i312], measuredHeight - baseline2);
                }
                i25 = Math.max(i25, measuredHeight);
                if (z14) {
                }
                if (((LinearLayout.LayoutParams) layoutParams).weight <= 0.0f) {
                }
                int i332 = i19;
                childrenSkipCount = getChildrenSkipCount(view, i332) + i332;
                f6 = f8;
                int i342 = childrenSkipCount + 1;
                iArr3 = iArr;
                z10 = z6;
                z9 = z7;
                i22 = i20;
                i23 = i342;
            }
            z6 = z10;
            z7 = z9;
            int i37 = i22;
            childrenSkipCount = i23;
            i20 = i37;
            int i3422 = childrenSkipCount + 1;
            iArr3 = iArr;
            z10 = z6;
            z9 = z7;
            i22 = i20;
            i23 = i3422;
        }
        boolean z15 = z10;
        boolean z16 = z9;
        int i38 = i25;
        int i39 = i26;
        int i40 = i27;
        int i41 = i28;
        if (this.mTotalLength > 0 && hasDividerBeforeChildAt(virtualChildCount)) {
            this.mTotalLength += this.mDividerWidth;
        }
        int i42 = iArr2[1];
        if (i42 == -1 && iArr2[0] == -1 && iArr2[2] == -1 && iArr2[3] == -1) {
            max = i38;
            i7 = i41;
        } else {
            i7 = i41;
            max = Math.max(i38, Math.max(iArr2[3], Math.max(iArr2[0], Math.max(i42, iArr2[2]))) + Math.max(iArr[3], Math.max(iArr[0], Math.max(iArr[1], iArr[2]))));
        }
        if (z15 && (mode == Integer.MIN_VALUE || mode == 0)) {
            this.mTotalLength = 0;
            int i43 = 0;
            while (i43 < virtualChildCount) {
                View virtualChildAt2 = getVirtualChildAt(i43);
                if (virtualChildAt2 == null) {
                    this.mTotalLength += measureNullChild(i43);
                } else if (virtualChildAt2.getVisibility() == 8) {
                    i43 += getChildrenSkipCount(virtualChildAt2, i43);
                } else {
                    LayoutParams layoutParams2 = (LayoutParams) virtualChildAt2.getLayoutParams();
                    if (z11) {
                        this.mTotalLength += ((LinearLayout.LayoutParams) layoutParams2).leftMargin + i24 + ((LinearLayout.LayoutParams) layoutParams2).rightMargin + getNextLocationOffset(virtualChildAt2);
                    } else {
                        int i44 = this.mTotalLength;
                        i17 = max;
                        this.mTotalLength = Math.max(i44, i44 + i24 + ((LinearLayout.LayoutParams) layoutParams2).leftMargin + ((LinearLayout.LayoutParams) layoutParams2).rightMargin + getNextLocationOffset(virtualChildAt2));
                        i43++;
                        max = i17;
                    }
                }
                i17 = max;
                i43++;
                max = i17;
            }
        }
        int i45 = max;
        int paddingLeft = this.mTotalLength + getPaddingLeft() + getPaddingRight();
        this.mTotalLength = paddingLeft;
        int resolveSizeAndState = View.resolveSizeAndState(Math.max(paddingLeft, getSuggestedMinimumWidth()), i5, 0);
        int i46 = (16777215 & resolveSizeAndState) - this.mTotalLength;
        if (z12 || (i46 != 0 && f6 > 0.0f)) {
            float f9 = this.mWeightSum;
            if (f9 > 0.0f) {
                f6 = f9;
            }
            iArr2[3] = -1;
            iArr2[2] = -1;
            iArr2[1] = -1;
            iArr2[0] = -1;
            iArr[3] = -1;
            iArr[2] = -1;
            iArr[1] = -1;
            iArr[0] = -1;
            this.mTotalLength = 0;
            int i47 = i39;
            int i48 = -1;
            i8 = i7;
            int i49 = 0;
            while (i49 < virtualChildCount) {
                View virtualChildAt3 = getVirtualChildAt(i49);
                if (virtualChildAt3 == null || virtualChildAt3.getVisibility() == 8) {
                    i12 = i46;
                    i13 = virtualChildCount;
                } else {
                    LayoutParams layoutParams3 = (LayoutParams) virtualChildAt3.getLayoutParams();
                    float f10 = ((LinearLayout.LayoutParams) layoutParams3).weight;
                    if (f10 > 0.0f) {
                        int i50 = (int) ((i46 * f10) / f6);
                        float f11 = f6 - f10;
                        int i51 = i46 - i50;
                        i13 = virtualChildCount;
                        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i6, getPaddingTop() + getPaddingBottom() + ((LinearLayout.LayoutParams) layoutParams3).topMargin + ((LinearLayout.LayoutParams) layoutParams3).bottomMargin, ((LinearLayout.LayoutParams) layoutParams3).height);
                        if (((LinearLayout.LayoutParams) layoutParams3).width == 0) {
                            i16 = 1073741824;
                            if (mode == 1073741824) {
                                if (i50 <= 0) {
                                    i50 = 0;
                                }
                                virtualChildAt3.measure(View.MeasureSpec.makeMeasureSpec(i50, 1073741824), childMeasureSpec);
                                i8 = View.combineMeasuredStates(i8, virtualChildAt3.getMeasuredState() & (-16777216));
                                f6 = f11;
                                i12 = i51;
                            }
                        } else {
                            i16 = 1073741824;
                        }
                        int measuredWidth2 = virtualChildAt3.getMeasuredWidth() + i50;
                        if (measuredWidth2 < 0) {
                            measuredWidth2 = 0;
                        }
                        virtualChildAt3.measure(View.MeasureSpec.makeMeasureSpec(measuredWidth2, i16), childMeasureSpec);
                        i8 = View.combineMeasuredStates(i8, virtualChildAt3.getMeasuredState() & (-16777216));
                        f6 = f11;
                        i12 = i51;
                    } else {
                        i12 = i46;
                        i13 = virtualChildCount;
                    }
                    if (z11) {
                        this.mTotalLength += virtualChildAt3.getMeasuredWidth() + ((LinearLayout.LayoutParams) layoutParams3).leftMargin + ((LinearLayout.LayoutParams) layoutParams3).rightMargin + getNextLocationOffset(virtualChildAt3);
                        f5 = f6;
                    } else {
                        int i52 = this.mTotalLength;
                        f5 = f6;
                        this.mTotalLength = Math.max(i52, virtualChildAt3.getMeasuredWidth() + i52 + ((LinearLayout.LayoutParams) layoutParams3).leftMargin + ((LinearLayout.LayoutParams) layoutParams3).rightMargin + getNextLocationOffset(virtualChildAt3));
                    }
                    boolean z17 = mode2 != 1073741824 && ((LinearLayout.LayoutParams) layoutParams3).height == -1;
                    int i53 = ((LinearLayout.LayoutParams) layoutParams3).topMargin + ((LinearLayout.LayoutParams) layoutParams3).bottomMargin;
                    int measuredHeight2 = virtualChildAt3.getMeasuredHeight() + i53;
                    i48 = Math.max(i48, measuredHeight2);
                    if (!z17) {
                        i53 = measuredHeight2;
                    }
                    int max2 = Math.max(i47, i53);
                    if (z14) {
                        i14 = -1;
                        if (((LinearLayout.LayoutParams) layoutParams3).height == -1) {
                            z5 = true;
                            if (z16 && (baseline = virtualChildAt3.getBaseline()) != i14) {
                                i15 = ((LinearLayout.LayoutParams) layoutParams3).gravity;
                                if (i15 < 0) {
                                    i15 = this.mGravity;
                                }
                                int i54 = (((i15 & 112) >> 4) & (-2)) >> 1;
                                iArr2[i54] = Math.max(iArr2[i54], baseline);
                                iArr[i54] = Math.max(iArr[i54], measuredHeight2 - baseline);
                            }
                            z14 = z5;
                            i47 = max2;
                            f6 = f5;
                        }
                    } else {
                        i14 = -1;
                    }
                    z5 = false;
                    if (z16) {
                        i15 = ((LinearLayout.LayoutParams) layoutParams3).gravity;
                        if (i15 < 0) {
                        }
                        int i542 = (((i15 & 112) >> 4) & (-2)) >> 1;
                        iArr2[i542] = Math.max(iArr2[i542], baseline);
                        iArr[i542] = Math.max(iArr[i542], measuredHeight2 - baseline);
                    }
                    z14 = z5;
                    i47 = max2;
                    f6 = f5;
                }
                i49++;
                i46 = i12;
                virtualChildCount = i13;
            }
            i9 = i6;
            i10 = virtualChildCount;
            this.mTotalLength += getPaddingLeft() + getPaddingRight();
            int i55 = iArr2[1];
            i45 = (i55 == -1 && iArr2[0] == -1 && iArr2[2] == -1 && iArr2[3] == -1) ? i48 : Math.max(i48, Math.max(iArr2[3], Math.max(iArr2[0], Math.max(i55, iArr2[2]))) + Math.max(iArr[3], Math.max(iArr[0], Math.max(iArr[1], iArr[2]))));
            i11 = i47;
        } else {
            i11 = Math.max(i39, i40);
            if (z15 && mode != 1073741824) {
                for (int i56 = 0; i56 < virtualChildCount; i56++) {
                    View virtualChildAt4 = getVirtualChildAt(i56);
                    if (virtualChildAt4 != null && virtualChildAt4.getVisibility() != 8 && ((LinearLayout.LayoutParams) ((LayoutParams) virtualChildAt4.getLayoutParams())).weight > 0.0f) {
                        virtualChildAt4.measure(View.MeasureSpec.makeMeasureSpec(i24, 1073741824), View.MeasureSpec.makeMeasureSpec(virtualChildAt4.getMeasuredHeight(), 1073741824));
                    }
                }
            }
            i9 = i6;
            i10 = virtualChildCount;
            i8 = i7;
        }
        if (z14 || mode2 == 1073741824) {
            i11 = i45;
        }
        setMeasuredDimension(resolveSizeAndState | ((-16777216) & i8), View.resolveSizeAndState(Math.max(i11 + getPaddingTop() + getPaddingBottom(), getSuggestedMinimumHeight()), i9, i8 << 16));
        if (z13) {
            forceUniformHeight(i10, i5);
        }
    }

    int measureNullChild(int i5) {
        return 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:156:0x031b, code lost:
    
        if (((android.widget.LinearLayout.LayoutParams) r14).width == (-1)) goto L147;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    void measureVertical(int i5, int i6) {
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        int i21;
        int i22;
        View view;
        int max;
        boolean z5;
        this.mTotalLength = 0;
        int virtualChildCount = getVirtualChildCount();
        int mode = View.MeasureSpec.getMode(i5);
        int mode2 = View.MeasureSpec.getMode(i6);
        int i23 = this.mBaselineAlignedChildIndex;
        boolean z6 = this.mUseLargestChild;
        int i24 = 0;
        int i25 = 0;
        int i26 = 0;
        int i27 = 0;
        int i28 = 0;
        int i29 = 0;
        boolean z7 = false;
        boolean z8 = false;
        boolean z9 = true;
        float f5 = 0.0f;
        while (true) {
            int i30 = 8;
            int i31 = i27;
            if (i29 >= virtualChildCount) {
                int i32 = i24;
                int i33 = i26;
                int i34 = i28;
                int i35 = mode2;
                int i36 = i25;
                int i37 = virtualChildCount;
                if (this.mTotalLength > 0) {
                    i7 = i37;
                    if (hasDividerBeforeChildAt(i7)) {
                        this.mTotalLength += this.mDividerHeight;
                    }
                } else {
                    i7 = i37;
                }
                if (z6 && (i35 == Integer.MIN_VALUE || i35 == 0)) {
                    this.mTotalLength = 0;
                    int i38 = 0;
                    while (i38 < i7) {
                        View virtualChildAt = getVirtualChildAt(i38);
                        if (virtualChildAt == null) {
                            this.mTotalLength += measureNullChild(i38);
                        } else if (virtualChildAt.getVisibility() == i30) {
                            i38 += getChildrenSkipCount(virtualChildAt, i38);
                        } else {
                            LayoutParams layoutParams = (LayoutParams) virtualChildAt.getLayoutParams();
                            int i39 = this.mTotalLength;
                            this.mTotalLength = Math.max(i39, i39 + i33 + ((LinearLayout.LayoutParams) layoutParams).topMargin + ((LinearLayout.LayoutParams) layoutParams).bottomMargin + getNextLocationOffset(virtualChildAt));
                        }
                        i38++;
                        i30 = 8;
                    }
                }
                int paddingTop = this.mTotalLength + getPaddingTop() + getPaddingBottom();
                this.mTotalLength = paddingTop;
                int resolveSizeAndState = View.resolveSizeAndState(Math.max(paddingTop, getSuggestedMinimumHeight()), i6, 0);
                int i40 = (16777215 & resolveSizeAndState) - this.mTotalLength;
                if (z7 || (i40 != 0 && f5 > 0.0f)) {
                    float f6 = this.mWeightSum;
                    if (f6 > 0.0f) {
                        f5 = f6;
                    }
                    this.mTotalLength = 0;
                    int i41 = i40;
                    int i42 = i34;
                    i8 = i32;
                    int i43 = 0;
                    while (i43 < i7) {
                        View virtualChildAt2 = getVirtualChildAt(i43);
                        if (virtualChildAt2.getVisibility() == 8) {
                            i11 = i41;
                        } else {
                            LayoutParams layoutParams2 = (LayoutParams) virtualChildAt2.getLayoutParams();
                            float f7 = ((LinearLayout.LayoutParams) layoutParams2).weight;
                            if (f7 > 0.0f) {
                                int i44 = (int) ((i41 * f7) / f5);
                                float f8 = f5 - f7;
                                i11 = i41 - i44;
                                int childMeasureSpec = ViewGroup.getChildMeasureSpec(i5, getPaddingLeft() + getPaddingRight() + ((LinearLayout.LayoutParams) layoutParams2).leftMargin + ((LinearLayout.LayoutParams) layoutParams2).rightMargin, ((LinearLayout.LayoutParams) layoutParams2).width);
                                if (((LinearLayout.LayoutParams) layoutParams2).height == 0) {
                                    i14 = 1073741824;
                                    if (i35 == 1073741824) {
                                        if (i44 <= 0) {
                                            i44 = 0;
                                        }
                                        virtualChildAt2.measure(childMeasureSpec, View.MeasureSpec.makeMeasureSpec(i44, 1073741824));
                                        i8 = View.combineMeasuredStates(i8, virtualChildAt2.getMeasuredState() & (-256));
                                        f5 = f8;
                                    }
                                } else {
                                    i14 = 1073741824;
                                }
                                int measuredHeight = virtualChildAt2.getMeasuredHeight() + i44;
                                if (measuredHeight < 0) {
                                    measuredHeight = 0;
                                }
                                virtualChildAt2.measure(childMeasureSpec, View.MeasureSpec.makeMeasureSpec(measuredHeight, i14));
                                i8 = View.combineMeasuredStates(i8, virtualChildAt2.getMeasuredState() & (-256));
                                f5 = f8;
                            } else {
                                i11 = i41;
                            }
                            int i45 = ((LinearLayout.LayoutParams) layoutParams2).leftMargin + ((LinearLayout.LayoutParams) layoutParams2).rightMargin;
                            int measuredWidth = virtualChildAt2.getMeasuredWidth() + i45;
                            i36 = Math.max(i36, measuredWidth);
                            float f9 = f5;
                            if (mode != 1073741824) {
                                i12 = i8;
                                i13 = -1;
                            } else {
                                i12 = i8;
                                i13 = -1;
                            }
                            i45 = measuredWidth;
                            int max2 = Math.max(i42, i45);
                            boolean z10 = z9 && ((LinearLayout.LayoutParams) layoutParams2).width == i13;
                            int i46 = this.mTotalLength;
                            this.mTotalLength = Math.max(i46, virtualChildAt2.getMeasuredHeight() + i46 + ((LinearLayout.LayoutParams) layoutParams2).topMargin + ((LinearLayout.LayoutParams) layoutParams2).bottomMargin + getNextLocationOffset(virtualChildAt2));
                            z9 = z10;
                            i8 = i12;
                            i42 = max2;
                            f5 = f9;
                        }
                        i43++;
                        i41 = i11;
                    }
                    i9 = i5;
                    this.mTotalLength += getPaddingTop() + getPaddingBottom();
                    i10 = i42;
                } else {
                    i10 = Math.max(i34, i31);
                    if (z6 && i35 != 1073741824) {
                        for (int i47 = 0; i47 < i7; i47++) {
                            View virtualChildAt3 = getVirtualChildAt(i47);
                            if (virtualChildAt3 != null && virtualChildAt3.getVisibility() != 8 && ((LinearLayout.LayoutParams) ((LayoutParams) virtualChildAt3.getLayoutParams())).weight > 0.0f) {
                                virtualChildAt3.measure(View.MeasureSpec.makeMeasureSpec(virtualChildAt3.getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(i33, 1073741824));
                            }
                        }
                    }
                    i9 = i5;
                    i8 = i32;
                }
                if (z9 || mode == 1073741824) {
                    i10 = i36;
                }
                setMeasuredDimension(View.resolveSizeAndState(Math.max(i10 + getPaddingLeft() + getPaddingRight(), getSuggestedMinimumWidth()), i9, i8), resolveSizeAndState);
                if (z8) {
                    forceUniformWidth(i7, i6);
                    return;
                }
                return;
            }
            View virtualChildAt4 = getVirtualChildAt(i29);
            if (virtualChildAt4 == null) {
                this.mTotalLength += measureNullChild(i29);
                i18 = mode2;
                i27 = i31;
                i20 = virtualChildCount;
            } else {
                int i48 = i24;
                if (virtualChildAt4.getVisibility() == 8) {
                    i29 += getChildrenSkipCount(virtualChildAt4, i29);
                    i27 = i31;
                    i24 = i48;
                    i20 = virtualChildCount;
                    i18 = mode2;
                } else {
                    if (hasDividerBeforeChildAt(i29)) {
                        this.mTotalLength += this.mDividerHeight;
                    }
                    LayoutParams layoutParams3 = (LayoutParams) virtualChildAt4.getLayoutParams();
                    float f10 = ((LinearLayout.LayoutParams) layoutParams3).weight;
                    float f11 = f5 + f10;
                    if (mode2 == 1073741824 && ((LinearLayout.LayoutParams) layoutParams3).height == 0 && f10 > 0.0f) {
                        int i49 = this.mTotalLength;
                        this.mTotalLength = Math.max(i49, ((LinearLayout.LayoutParams) layoutParams3).topMargin + i49 + ((LinearLayout.LayoutParams) layoutParams3).bottomMargin);
                        max = i26;
                        view = virtualChildAt4;
                        i21 = i28;
                        z7 = true;
                        i16 = i48;
                        i17 = i25;
                        i18 = mode2;
                        i19 = i31;
                        i20 = virtualChildCount;
                        i22 = i29;
                    } else {
                        int i50 = i25;
                        if (((LinearLayout.LayoutParams) layoutParams3).height != 0 || f10 <= 0.0f) {
                            i15 = Integer.MIN_VALUE;
                        } else {
                            ((LinearLayout.LayoutParams) layoutParams3).height = -2;
                            i15 = 0;
                        }
                        i16 = i48;
                        int i51 = i15;
                        i17 = i50;
                        int i52 = i26;
                        i18 = mode2;
                        i19 = i31;
                        i20 = virtualChildCount;
                        i21 = i28;
                        i22 = i29;
                        measureChildBeforeLayout(virtualChildAt4, i29, i5, 0, i6, f11 == 0.0f ? this.mTotalLength : 0);
                        if (i51 != Integer.MIN_VALUE) {
                            ((LinearLayout.LayoutParams) layoutParams3).height = i51;
                        }
                        int measuredHeight2 = virtualChildAt4.getMeasuredHeight();
                        int i53 = this.mTotalLength;
                        view = virtualChildAt4;
                        this.mTotalLength = Math.max(i53, i53 + measuredHeight2 + ((LinearLayout.LayoutParams) layoutParams3).topMargin + ((LinearLayout.LayoutParams) layoutParams3).bottomMargin + getNextLocationOffset(view));
                        max = z6 ? Math.max(measuredHeight2, i52) : i52;
                    }
                    if (i23 >= 0 && i23 == i22 + 1) {
                        this.mBaselineChildTop = this.mTotalLength;
                    }
                    if (i22 < i23 && ((LinearLayout.LayoutParams) layoutParams3).weight > 0.0f) {
                        throw new RuntimeException("A child of LinearLayout with index less than mBaselineAlignedChildIndex has weight > 0, which won't work.  Either remove the weight, or don't set mBaselineAlignedChildIndex.");
                    }
                    if (mode == 1073741824 || ((LinearLayout.LayoutParams) layoutParams3).width != -1) {
                        z5 = false;
                    } else {
                        z5 = true;
                        z8 = true;
                    }
                    int i54 = ((LinearLayout.LayoutParams) layoutParams3).leftMargin + ((LinearLayout.LayoutParams) layoutParams3).rightMargin;
                    int measuredWidth2 = view.getMeasuredWidth() + i54;
                    int max3 = Math.max(i17, measuredWidth2);
                    int combineMeasuredStates = View.combineMeasuredStates(i16, view.getMeasuredState());
                    z9 = z9 && ((LinearLayout.LayoutParams) layoutParams3).width == -1;
                    if (((LinearLayout.LayoutParams) layoutParams3).weight > 0.0f) {
                        if (!z5) {
                            i54 = measuredWidth2;
                        }
                        i27 = Math.max(i19, i54);
                    } else {
                        if (!z5) {
                            i54 = measuredWidth2;
                        }
                        i21 = Math.max(i21, i54);
                        i27 = i19;
                    }
                    int childrenSkipCount = getChildrenSkipCount(view, i22) + i22;
                    i26 = max;
                    i25 = max3;
                    f5 = f11;
                    i28 = i21;
                    i29 = childrenSkipCount;
                    i24 = combineMeasuredStates;
                }
            }
            i29++;
            virtualChildCount = i20;
            mode2 = i18;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.mDivider == null) {
            return;
        }
        if (this.mOrientation == 1) {
            drawDividersVertical(canvas);
        } else {
            drawDividersHorizontal(canvas);
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(ACCESSIBILITY_CLASS_NAME);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(ACCESSIBILITY_CLASS_NAME);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z5, int i5, int i6, int i7, int i8) {
        if (this.mOrientation == 1) {
            layoutVertical(i5, i6, i7, i8);
        } else {
            layoutHorizontal(i5, i6, i7, i8);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onMeasure(int i5, int i6) {
        if (this.mOrientation == 1) {
            measureVertical(i5, i6);
        } else {
            measureHorizontal(i5, i6);
        }
    }

    public void setBaselineAligned(boolean z5) {
        this.mBaselineAligned = z5;
    }

    public void setBaselineAlignedChildIndex(int i5) {
        if (i5 >= 0 && i5 < getChildCount()) {
            this.mBaselineAlignedChildIndex = i5;
            return;
        }
        throw new IllegalArgumentException("base aligned child index out of range (0, " + getChildCount() + ")");
    }

    public void setDividerDrawable(Drawable drawable) {
        if (drawable == this.mDivider) {
            return;
        }
        this.mDivider = drawable;
        if (drawable != null) {
            this.mDividerWidth = drawable.getIntrinsicWidth();
            this.mDividerHeight = drawable.getIntrinsicHeight();
        } else {
            this.mDividerWidth = 0;
            this.mDividerHeight = 0;
        }
        setWillNotDraw(drawable == null);
        requestLayout();
    }

    public void setDividerPadding(int i5) {
        this.mDividerPadding = i5;
    }

    public void setGravity(int i5) {
        if (this.mGravity != i5) {
            if ((8388615 & i5) == 0) {
                i5 |= 8388611;
            }
            if ((i5 & 112) == 0) {
                i5 |= 48;
            }
            this.mGravity = i5;
            requestLayout();
        }
    }

    public void setHorizontalGravity(int i5) {
        int i6 = i5 & 8388615;
        int i7 = this.mGravity;
        if ((8388615 & i7) != i6) {
            this.mGravity = i6 | ((-8388616) & i7);
            requestLayout();
        }
    }

    public void setMeasureWithLargestChildEnabled(boolean z5) {
        this.mUseLargestChild = z5;
    }

    public void setOrientation(int i5) {
        if (this.mOrientation != i5) {
            this.mOrientation = i5;
            requestLayout();
        }
    }

    public void setShowDividers(int i5) {
        if (i5 != this.mShowDividers) {
            requestLayout();
        }
        this.mShowDividers = i5;
    }

    public void setVerticalGravity(int i5) {
        int i6 = i5 & 112;
        int i7 = this.mGravity;
        if ((i7 & 112) != i6) {
            this.mGravity = i6 | (i7 & (-113));
            requestLayout();
        }
    }

    public void setWeightSum(float f5) {
        this.mWeightSum = Math.max(0.0f, f5);
    }

    @Override // android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public LinearLayoutCompat(Context context, AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
        this.mBaselineAligned = true;
        this.mBaselineAlignedChildIndex = -1;
        this.mBaselineChildTop = 0;
        this.mGravity = 8388659;
        int[] iArr = R$styleable.LinearLayoutCompat;
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, attributeSet, iArr, i5, 0);
        ViewCompat.saveAttributeDataForStyleable(this, context, iArr, attributeSet, obtainStyledAttributes.getWrappedTypeArray(), i5, 0);
        int i6 = obtainStyledAttributes.getInt(R$styleable.LinearLayoutCompat_android_orientation, -1);
        if (i6 >= 0) {
            setOrientation(i6);
        }
        int i7 = obtainStyledAttributes.getInt(R$styleable.LinearLayoutCompat_android_gravity, -1);
        if (i7 >= 0) {
            setGravity(i7);
        }
        boolean z5 = obtainStyledAttributes.getBoolean(R$styleable.LinearLayoutCompat_android_baselineAligned, true);
        if (!z5) {
            setBaselineAligned(z5);
        }
        this.mWeightSum = obtainStyledAttributes.getFloat(R$styleable.LinearLayoutCompat_android_weightSum, -1.0f);
        this.mBaselineAlignedChildIndex = obtainStyledAttributes.getInt(R$styleable.LinearLayoutCompat_android_baselineAlignedChildIndex, -1);
        this.mUseLargestChild = obtainStyledAttributes.getBoolean(R$styleable.LinearLayoutCompat_measureWithLargestChild, false);
        setDividerDrawable(obtainStyledAttributes.getDrawable(R$styleable.LinearLayoutCompat_divider));
        this.mShowDividers = obtainStyledAttributes.getInt(R$styleable.LinearLayoutCompat_showDividers, 0);
        this.mDividerPadding = obtainStyledAttributes.getDimensionPixelSize(R$styleable.LinearLayoutCompat_dividerPadding, 0);
        obtainStyledAttributes.recycle();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    public LayoutParams generateDefaultLayoutParams() {
        int i5 = this.mOrientation;
        if (i5 == 0) {
            return new LayoutParams(-2, -2);
        }
        if (i5 == 1) {
            return new LayoutParams(-1, -2);
        }
        return null;
    }

    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup
    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof LayoutParams) {
            return new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams);
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new LayoutParams(layoutParams);
    }
}
