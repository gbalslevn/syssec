package androidx.core.widget;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.AnimationUtils;
import android.widget.EdgeEffect;
import android.widget.FrameLayout;
import android.widget.OverScroller;
import android.widget.ScrollView;
import androidx.core.R$attr;
import androidx.core.os.BuildCompat;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.DifferentialMotionFlingController;
import androidx.core.view.DifferentialMotionFlingTarget;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.view.NestedScrollingParent3;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityRecordCompat;
import com.adjust.sdk.Constants;
import com.sun.jna.Function;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class NestedScrollView extends FrameLayout implements NestedScrollingParent3 {
    private static final int DEFAULT_SMOOTH_SCROLL_DURATION = 250;
    private static final float FLING_DESTRETCH_FACTOR = 4.0f;
    private static final float INFLEXION = 0.35f;
    private static final int INVALID_POINTER = -1;
    private static final float SCROLL_FRICTION = 0.015f;
    private static final String TAG = "NestedScrollView";
    private int mActivePointerId;
    private final NestedScrollingChildHelper mChildHelper;
    private View mChildToScrollTo;
    DifferentialMotionFlingController mDifferentialMotionFlingController;
    final DifferentialMotionFlingTargetImpl mDifferentialMotionFlingTarget;
    public EdgeEffect mEdgeGlowBottom;
    public EdgeEffect mEdgeGlowTop;
    private boolean mFillViewport;
    private boolean mIsBeingDragged;
    private boolean mIsLaidOut;
    private boolean mIsLayoutDirty;
    private int mLastMotionY;
    private long mLastScroll;
    private int mLastScrollerY;
    private int mMaximumVelocity;
    private int mMinimumVelocity;
    private int mNestedYOffset;
    private OnScrollChangeListener mOnScrollChangeListener;
    private final NestedScrollingParentHelper mParentHelper;
    private final float mPhysicalCoeff;
    private SavedState mSavedState;
    private final int[] mScrollConsumed;
    private final int[] mScrollOffset;
    private OverScroller mScroller;
    private boolean mSmoothScrollingEnabled;
    private final Rect mTempRect;
    private int mTouchSlop;
    private VelocityTracker mVelocityTracker;
    private float mVerticalScrollFactor;
    private static final float DECELERATION_RATE = (float) (Math.log(0.78d) / Math.log(0.9d));
    private static final AccessibilityDelegate ACCESSIBILITY_DELEGATE = new AccessibilityDelegate();
    private static final int[] SCROLLVIEW_STYLEABLE = {R.attr.fillViewport};

    /* loaded from: classes.dex */
    static class AccessibilityDelegate extends AccessibilityDelegateCompat {
        AccessibilityDelegate() {
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(view, accessibilityEvent);
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            accessibilityEvent.setClassName(ScrollView.class.getName());
            accessibilityEvent.setScrollable(nestedScrollView.getScrollRange() > 0);
            accessibilityEvent.setScrollX(nestedScrollView.getScrollX());
            accessibilityEvent.setScrollY(nestedScrollView.getScrollY());
            AccessibilityRecordCompat.setMaxScrollX(accessibilityEvent, nestedScrollView.getScrollX());
            AccessibilityRecordCompat.setMaxScrollY(accessibilityEvent, nestedScrollView.getScrollRange());
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            int scrollRange;
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            accessibilityNodeInfoCompat.setClassName(ScrollView.class.getName());
            if (!nestedScrollView.isEnabled() || (scrollRange = nestedScrollView.getScrollRange()) <= 0) {
                return;
            }
            accessibilityNodeInfoCompat.setScrollable(true);
            if (nestedScrollView.getScrollY() > 0) {
                accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD);
                accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_UP);
            }
            if (nestedScrollView.getScrollY() < scrollRange) {
                accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_FORWARD);
                accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_DOWN);
            }
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public boolean performAccessibilityAction(View view, int i5, Bundle bundle) {
            if (super.performAccessibilityAction(view, i5, bundle)) {
                return true;
            }
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            if (!nestedScrollView.isEnabled()) {
                return false;
            }
            int height = nestedScrollView.getHeight();
            Rect rect = new Rect();
            if (nestedScrollView.getMatrix().isIdentity() && nestedScrollView.getGlobalVisibleRect(rect)) {
                height = rect.height();
            }
            if (i5 != 4096) {
                if (i5 == 8192 || i5 == 16908344) {
                    int max = Math.max(nestedScrollView.getScrollY() - ((height - nestedScrollView.getPaddingBottom()) - nestedScrollView.getPaddingTop()), 0);
                    if (max == nestedScrollView.getScrollY()) {
                        return false;
                    }
                    nestedScrollView.smoothScrollTo(0, max, true);
                    return true;
                }
                if (i5 != 16908346) {
                    return false;
                }
            }
            int min = Math.min(nestedScrollView.getScrollY() + ((height - nestedScrollView.getPaddingBottom()) - nestedScrollView.getPaddingTop()), nestedScrollView.getScrollRange());
            if (min == nestedScrollView.getScrollY()) {
                return false;
            }
            nestedScrollView.smoothScrollTo(0, min, true);
            return true;
        }
    }

    /* loaded from: classes.dex */
    static class Api21Impl {
        static boolean getClipToPadding(ViewGroup viewGroup) {
            return viewGroup.getClipToPadding();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class Api35Impl {
        public static void setFrameContentVelocity(View view, float f5) {
            try {
                view.setFrameContentVelocity(f5);
            } catch (LinkageError unused) {
            }
        }
    }

    /* loaded from: classes.dex */
    class DifferentialMotionFlingTargetImpl implements DifferentialMotionFlingTarget {
        DifferentialMotionFlingTargetImpl() {
        }

        @Override // androidx.core.view.DifferentialMotionFlingTarget
        public float getScaledScrollFactor() {
            return -NestedScrollView.this.getVerticalScrollFactorCompat();
        }

        @Override // androidx.core.view.DifferentialMotionFlingTarget
        public boolean startDifferentialMotionFling(float f5) {
            if (f5 == NestedScrollView.DECELERATION_RATE) {
                return false;
            }
            stopDifferentialMotionFling();
            NestedScrollView.this.fling((int) f5);
            return true;
        }

        @Override // androidx.core.view.DifferentialMotionFlingTarget
        public void stopDifferentialMotionFling() {
            NestedScrollView.this.mScroller.abortAnimation();
        }
    }

    /* loaded from: classes.dex */
    public interface OnScrollChangeListener {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: androidx.core.widget.NestedScrollView.SavedState.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SavedState[] newArray(int i5) {
                return new SavedState[i5];
            }
        };
        public int scrollPosition;

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "HorizontalScrollView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " scrollPosition=" + this.scrollPosition + "}";
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i5) {
            super.writeToParcel(parcel, i5);
            parcel.writeInt(this.scrollPosition);
        }

        SavedState(Parcel parcel) {
            super(parcel);
            this.scrollPosition = parcel.readInt();
        }
    }

    public NestedScrollView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.nestedScrollViewStyle);
    }

    private void abortAnimatedScroll() {
        this.mScroller.abortAnimation();
        stopNestedScroll(1);
    }

    private boolean canOverScroll() {
        int overScrollMode = getOverScrollMode();
        if (overScrollMode != 0) {
            return overScrollMode == 1 && getScrollRange() > 0;
        }
        return true;
    }

    private boolean canScroll() {
        if (getChildCount() <= 0) {
            return false;
        }
        View childAt = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        return (childAt.getHeight() + layoutParams.topMargin) + layoutParams.bottomMargin > (getHeight() - getPaddingTop()) - getPaddingBottom();
    }

    private static int clamp(int i5, int i6, int i7) {
        if (i6 >= i7 || i5 < 0) {
            return 0;
        }
        return i6 + i5 > i7 ? i7 - i6 : i5;
    }

    private void doScrollY(int i5) {
        if (i5 != 0) {
            if (this.mSmoothScrollingEnabled) {
                smoothScrollBy(0, i5);
            } else {
                scrollBy(0, i5);
            }
        }
    }

    private boolean edgeEffectFling(int i5) {
        if (EdgeEffectCompat.getDistance(this.mEdgeGlowTop) != DECELERATION_RATE) {
            if (shouldAbsorb(this.mEdgeGlowTop, i5)) {
                this.mEdgeGlowTop.onAbsorb(i5);
            } else {
                fling(-i5);
            }
        } else {
            if (EdgeEffectCompat.getDistance(this.mEdgeGlowBottom) == DECELERATION_RATE) {
                return false;
            }
            int i6 = -i5;
            if (shouldAbsorb(this.mEdgeGlowBottom, i6)) {
                this.mEdgeGlowBottom.onAbsorb(i6);
            } else {
                fling(i6);
            }
        }
        return true;
    }

    private void endTouchDrag() {
        this.mActivePointerId = -1;
        this.mIsBeingDragged = false;
        recycleVelocityTracker();
        stopNestedScroll(0);
        this.mEdgeGlowTop.onRelease();
        this.mEdgeGlowBottom.onRelease();
    }

    private View findFocusableViewInBounds(boolean z5, int i5, int i6) {
        ArrayList<View> focusables = getFocusables(2);
        int size = focusables.size();
        View view = null;
        boolean z6 = false;
        for (int i7 = 0; i7 < size; i7++) {
            View view2 = focusables.get(i7);
            int top = view2.getTop();
            int bottom = view2.getBottom();
            if (i5 < bottom && top < i6) {
                boolean z7 = i5 < top && bottom < i6;
                if (view == null) {
                    view = view2;
                    z6 = z7;
                } else {
                    boolean z8 = (z5 && top < view.getTop()) || (!z5 && bottom > view.getBottom());
                    if (z6) {
                        if (z7) {
                            if (!z8) {
                            }
                            view = view2;
                        }
                    } else if (z7) {
                        view = view2;
                        z6 = true;
                    } else {
                        if (!z8) {
                        }
                        view = view2;
                    }
                }
            }
        }
        return view;
    }

    private float getSplineFlingDistance(int i5) {
        double log = Math.log((Math.abs(i5) * INFLEXION) / (this.mPhysicalCoeff * SCROLL_FRICTION));
        float f5 = DECELERATION_RATE;
        return (float) (this.mPhysicalCoeff * SCROLL_FRICTION * Math.exp((f5 / (f5 - 1.0d)) * log));
    }

    private boolean inChild(int i5, int i6) {
        if (getChildCount() <= 0) {
            return false;
        }
        int scrollY = getScrollY();
        View childAt = getChildAt(0);
        return i6 >= childAt.getTop() - scrollY && i6 < childAt.getBottom() - scrollY && i5 >= childAt.getLeft() && i5 < childAt.getRight();
    }

    private void initOrResetVelocityTracker() {
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        } else {
            velocityTracker.clear();
        }
    }

    private void initScrollView() {
        this.mScroller = new OverScroller(getContext());
        setFocusable(true);
        setDescendantFocusability(262144);
        setWillNotDraw(false);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
        this.mMinimumVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
        this.mMaximumVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
    }

    private void initVelocityTrackerIfNotExists() {
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
    }

    private void initializeTouchDrag(int i5, int i6) {
        this.mLastMotionY = i5;
        this.mActivePointerId = i6;
        startNestedScroll(2, 0);
    }

    private boolean isOffScreen(View view) {
        return !isWithinDeltaOfScreen(view, 0, getHeight());
    }

    private static boolean isViewDescendantOf(View view, View view2) {
        if (view == view2) {
            return true;
        }
        Object parent = view.getParent();
        return (parent instanceof ViewGroup) && isViewDescendantOf((View) parent, view2);
    }

    private boolean isWithinDeltaOfScreen(View view, int i5, int i6) {
        view.getDrawingRect(this.mTempRect);
        offsetDescendantRectToMyCoords(view, this.mTempRect);
        return this.mTempRect.bottom + i5 >= getScrollY() && this.mTempRect.top - i5 <= getScrollY() + i6;
    }

    private void onNestedScrollInternal(int i5, int i6, int[] iArr) {
        int scrollY = getScrollY();
        scrollBy(0, i5);
        int scrollY2 = getScrollY() - scrollY;
        if (iArr != null) {
            iArr[1] = iArr[1] + scrollY2;
        }
        this.mChildHelper.dispatchNestedScroll(0, scrollY2, 0, i5 - scrollY2, null, i6, iArr);
    }

    private void onSecondaryPointerUp(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.mActivePointerId) {
            int i5 = actionIndex == 0 ? 1 : 0;
            this.mLastMotionY = (int) motionEvent.getY(i5);
            this.mActivePointerId = motionEvent.getPointerId(i5);
            VelocityTracker velocityTracker = this.mVelocityTracker;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }
    }

    private void recycleVelocityTracker() {
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0060  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int releaseVerticalGlow(int i5, float f5) {
        float onPullDistance;
        int round;
        float width = f5 / getWidth();
        float height = i5 / getHeight();
        float distance = EdgeEffectCompat.getDistance(this.mEdgeGlowTop);
        float f6 = DECELERATION_RATE;
        if (distance == DECELERATION_RATE) {
            if (EdgeEffectCompat.getDistance(this.mEdgeGlowBottom) != DECELERATION_RATE) {
                onPullDistance = EdgeEffectCompat.onPullDistance(this.mEdgeGlowBottom, height, 1.0f - width);
                if (EdgeEffectCompat.getDistance(this.mEdgeGlowBottom) == DECELERATION_RATE) {
                    this.mEdgeGlowBottom.onRelease();
                }
            }
            round = Math.round(f6 * getHeight());
            if (round != 0) {
                invalidate();
            }
            return round;
        }
        onPullDistance = -EdgeEffectCompat.onPullDistance(this.mEdgeGlowTop, -height, width);
        if (EdgeEffectCompat.getDistance(this.mEdgeGlowTop) == DECELERATION_RATE) {
            this.mEdgeGlowTop.onRelease();
        }
        f6 = onPullDistance;
        round = Math.round(f6 * getHeight());
        if (round != 0) {
        }
        return round;
    }

    private void runAnimatedScroll(boolean z5) {
        if (z5) {
            startNestedScroll(2, 1);
        } else {
            stopNestedScroll(1);
        }
        this.mLastScrollerY = getScrollY();
        postInvalidateOnAnimation();
    }

    private boolean scrollAndFocus(int i5, int i6, int i7) {
        int height = getHeight();
        int scrollY = getScrollY();
        int i8 = height + scrollY;
        boolean z5 = false;
        boolean z6 = i5 == 33;
        View findFocusableViewInBounds = findFocusableViewInBounds(z6, i6, i7);
        if (findFocusableViewInBounds == null) {
            findFocusableViewInBounds = this;
        }
        if (i6 < scrollY || i7 > i8) {
            scrollBy(z6 ? i6 - scrollY : i7 - i8, 0, 1, true);
            z5 = true;
        }
        if (findFocusableViewInBounds != findFocus()) {
            findFocusableViewInBounds.requestFocus(i5);
        }
        return z5;
    }

    private int scrollBy(int i5, int i6, int i7, boolean z5) {
        int i8;
        int i9;
        VelocityTracker velocityTracker;
        if (i7 == 1) {
            startNestedScroll(2, i7);
        }
        boolean z6 = false;
        if (dispatchNestedPreScroll(0, i5, this.mScrollConsumed, this.mScrollOffset, i7)) {
            i8 = i5 - this.mScrollConsumed[1];
            i9 = this.mScrollOffset[1];
        } else {
            i8 = i5;
            i9 = 0;
        }
        int scrollY = getScrollY();
        int scrollRange = getScrollRange();
        boolean z7 = canOverScroll() && !z5;
        boolean z8 = overScrollByCompat(0, i8, 0, scrollY, 0, scrollRange, 0, 0, true) && !hasNestedScrollingParent(i7);
        int scrollY2 = getScrollY() - scrollY;
        int[] iArr = this.mScrollConsumed;
        iArr[1] = 0;
        dispatchNestedScroll(0, scrollY2, 0, i8 - scrollY2, this.mScrollOffset, i7, iArr);
        int i10 = i9 + this.mScrollOffset[1];
        int i11 = i8 - this.mScrollConsumed[1];
        int i12 = scrollY + i11;
        if (i12 < 0) {
            if (z7) {
                EdgeEffectCompat.onPullDistance(this.mEdgeGlowTop, (-i11) / getHeight(), i6 / getWidth());
                if (!this.mEdgeGlowBottom.isFinished()) {
                    this.mEdgeGlowBottom.onRelease();
                }
            }
        } else if (i12 > scrollRange && z7) {
            EdgeEffectCompat.onPullDistance(this.mEdgeGlowBottom, i11 / getHeight(), 1.0f - (i6 / getWidth()));
            if (!this.mEdgeGlowTop.isFinished()) {
                this.mEdgeGlowTop.onRelease();
            }
        }
        if (this.mEdgeGlowTop.isFinished() && this.mEdgeGlowBottom.isFinished()) {
            z6 = z8;
        } else {
            postInvalidateOnAnimation();
        }
        if (z6 && i7 == 0 && (velocityTracker = this.mVelocityTracker) != null) {
            velocityTracker.clear();
        }
        if (i7 == 1) {
            stopNestedScroll(i7);
            this.mEdgeGlowTop.onRelease();
            this.mEdgeGlowBottom.onRelease();
        }
        return i10;
    }

    private void scrollToChild(View view) {
        view.getDrawingRect(this.mTempRect);
        offsetDescendantRectToMyCoords(view, this.mTempRect);
        int computeScrollDeltaToGetChildRectOnScreen = computeScrollDeltaToGetChildRectOnScreen(this.mTempRect);
        if (computeScrollDeltaToGetChildRectOnScreen != 0) {
            scrollBy(0, computeScrollDeltaToGetChildRectOnScreen);
        }
    }

    private boolean scrollToChildRect(Rect rect, boolean z5) {
        int computeScrollDeltaToGetChildRectOnScreen = computeScrollDeltaToGetChildRectOnScreen(rect);
        boolean z6 = computeScrollDeltaToGetChildRectOnScreen != 0;
        if (z6) {
            if (z5) {
                scrollBy(0, computeScrollDeltaToGetChildRectOnScreen);
            } else {
                smoothScrollBy(0, computeScrollDeltaToGetChildRectOnScreen);
            }
        }
        return z6;
    }

    private boolean shouldAbsorb(EdgeEffect edgeEffect, int i5) {
        if (i5 > 0) {
            return true;
        }
        return getSplineFlingDistance(-i5) < EdgeEffectCompat.getDistance(edgeEffect) * ((float) getHeight());
    }

    private boolean stopGlowAnimations(MotionEvent motionEvent) {
        boolean z5;
        if (EdgeEffectCompat.getDistance(this.mEdgeGlowTop) != DECELERATION_RATE) {
            EdgeEffectCompat.onPullDistance(this.mEdgeGlowTop, DECELERATION_RATE, motionEvent.getX() / getWidth());
            z5 = true;
        } else {
            z5 = false;
        }
        if (EdgeEffectCompat.getDistance(this.mEdgeGlowBottom) == DECELERATION_RATE) {
            return z5;
        }
        EdgeEffectCompat.onPullDistance(this.mEdgeGlowBottom, DECELERATION_RATE, 1.0f - (motionEvent.getX() / getWidth()));
        return true;
    }

    @Override // android.view.ViewGroup
    public void addView(View view) {
        if (getChildCount() <= 0) {
            super.addView(view);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }

    public boolean arrowScroll(int i5) {
        View findFocus = findFocus();
        if (findFocus == this) {
            findFocus = null;
        }
        View findNextFocus = FocusFinder.getInstance().findNextFocus(this, findFocus, i5);
        int maxScrollAmount = getMaxScrollAmount();
        if (findNextFocus == null || !isWithinDeltaOfScreen(findNextFocus, maxScrollAmount, getHeight())) {
            if (i5 == 33 && getScrollY() < maxScrollAmount) {
                maxScrollAmount = getScrollY();
            } else if (i5 == 130 && getChildCount() > 0) {
                View childAt = getChildAt(0);
                maxScrollAmount = Math.min((childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin) - ((getScrollY() + getHeight()) - getPaddingBottom()), maxScrollAmount);
            }
            if (maxScrollAmount == 0) {
                return false;
            }
            if (i5 != 130) {
                maxScrollAmount = -maxScrollAmount;
            }
            scrollBy(maxScrollAmount, 0, 1, true);
        } else {
            findNextFocus.getDrawingRect(this.mTempRect);
            offsetDescendantRectToMyCoords(findNextFocus, this.mTempRect);
            scrollBy(computeScrollDeltaToGetChildRectOnScreen(this.mTempRect), 0, 1, true);
            findNextFocus.requestFocus(i5);
        }
        if (findFocus != null && findFocus.isFocused() && isOffScreen(findFocus)) {
            int descendantFocusability = getDescendantFocusability();
            setDescendantFocusability(131072);
            requestFocus();
            setDescendantFocusability(descendantFocusability);
        }
        return true;
    }

    @Override // android.view.View
    public int computeHorizontalScrollExtent() {
        return super.computeHorizontalScrollExtent();
    }

    @Override // android.view.View
    public int computeHorizontalScrollOffset() {
        return super.computeHorizontalScrollOffset();
    }

    @Override // android.view.View
    public int computeHorizontalScrollRange() {
        return super.computeHorizontalScrollRange();
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.mScroller.isFinished()) {
            return;
        }
        this.mScroller.computeScrollOffset();
        int currY = this.mScroller.getCurrY();
        int consumeFlingInVerticalStretch = consumeFlingInVerticalStretch(currY - this.mLastScrollerY);
        this.mLastScrollerY = currY;
        int[] iArr = this.mScrollConsumed;
        iArr[1] = 0;
        dispatchNestedPreScroll(0, consumeFlingInVerticalStretch, iArr, null, 1);
        int i5 = consumeFlingInVerticalStretch - this.mScrollConsumed[1];
        int scrollRange = getScrollRange();
        if (BuildCompat.isAtLeastV()) {
            Api35Impl.setFrameContentVelocity(this, Math.abs(this.mScroller.getCurrVelocity()));
        }
        if (i5 != 0) {
            int scrollY = getScrollY();
            overScrollByCompat(0, i5, getScrollX(), scrollY, 0, scrollRange, 0, 0, false);
            int scrollY2 = getScrollY() - scrollY;
            int i6 = i5 - scrollY2;
            int[] iArr2 = this.mScrollConsumed;
            iArr2[1] = 0;
            dispatchNestedScroll(0, scrollY2, 0, i6, this.mScrollOffset, 1, iArr2);
            i5 = i6 - this.mScrollConsumed[1];
        }
        if (i5 != 0) {
            int overScrollMode = getOverScrollMode();
            if (overScrollMode == 0 || (overScrollMode == 1 && scrollRange > 0)) {
                if (i5 < 0) {
                    if (this.mEdgeGlowTop.isFinished()) {
                        this.mEdgeGlowTop.onAbsorb((int) this.mScroller.getCurrVelocity());
                    }
                } else if (this.mEdgeGlowBottom.isFinished()) {
                    this.mEdgeGlowBottom.onAbsorb((int) this.mScroller.getCurrVelocity());
                }
            }
            abortAnimatedScroll();
        }
        if (this.mScroller.isFinished()) {
            stopNestedScroll(1);
        } else {
            postInvalidateOnAnimation();
        }
    }

    protected int computeScrollDeltaToGetChildRectOnScreen(Rect rect) {
        if (getChildCount() == 0) {
            return 0;
        }
        int height = getHeight();
        int scrollY = getScrollY();
        int i5 = scrollY + height;
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        if (rect.top > 0) {
            scrollY += verticalFadingEdgeLength;
        }
        View childAt = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        int i6 = rect.bottom < (childAt.getHeight() + layoutParams.topMargin) + layoutParams.bottomMargin ? i5 - verticalFadingEdgeLength : i5;
        int i7 = rect.bottom;
        if (i7 > i6 && rect.top > scrollY) {
            return Math.min(rect.height() > height ? rect.top - scrollY : rect.bottom - i6, (childAt.getBottom() + layoutParams.bottomMargin) - i5);
        }
        if (rect.top >= scrollY || i7 >= i6) {
            return 0;
        }
        return Math.max(rect.height() > height ? 0 - (i6 - rect.bottom) : 0 - (scrollY - rect.top), -getScrollY());
    }

    @Override // android.view.View
    public int computeVerticalScrollExtent() {
        return super.computeVerticalScrollExtent();
    }

    @Override // android.view.View
    public int computeVerticalScrollOffset() {
        return Math.max(0, super.computeVerticalScrollOffset());
    }

    @Override // android.view.View
    public int computeVerticalScrollRange() {
        int childCount = getChildCount();
        int height = (getHeight() - getPaddingBottom()) - getPaddingTop();
        if (childCount == 0) {
            return height;
        }
        View childAt = getChildAt(0);
        int bottom = childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin;
        int scrollY = getScrollY();
        int max = Math.max(0, bottom - height);
        return scrollY < 0 ? bottom - scrollY : scrollY > max ? bottom + (scrollY - max) : bottom;
    }

    int consumeFlingInVerticalStretch(int i5) {
        int height = getHeight();
        if (i5 > 0 && EdgeEffectCompat.getDistance(this.mEdgeGlowTop) != DECELERATION_RATE) {
            int round = Math.round(((-height) / FLING_DESTRETCH_FACTOR) * EdgeEffectCompat.onPullDistance(this.mEdgeGlowTop, ((-i5) * FLING_DESTRETCH_FACTOR) / height, 0.5f));
            if (round != i5) {
                this.mEdgeGlowTop.finish();
            }
            return i5 - round;
        }
        if (i5 >= 0 || EdgeEffectCompat.getDistance(this.mEdgeGlowBottom) == DECELERATION_RATE) {
            return i5;
        }
        float f5 = height;
        int round2 = Math.round((f5 / FLING_DESTRETCH_FACTOR) * EdgeEffectCompat.onPullDistance(this.mEdgeGlowBottom, (i5 * FLING_DESTRETCH_FACTOR) / f5, 0.5f));
        if (round2 != i5) {
            this.mEdgeGlowBottom.finish();
        }
        return i5 - round2;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) || executeKeyEvent(keyEvent);
    }

    @Override // android.view.View
    public boolean dispatchNestedFling(float f5, float f6, boolean z5) {
        return this.mChildHelper.dispatchNestedFling(f5, f6, z5);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreFling(float f5, float f6) {
        return this.mChildHelper.dispatchNestedPreFling(f5, f6);
    }

    public boolean dispatchNestedPreScroll(int i5, int i6, int[] iArr, int[] iArr2, int i7) {
        return this.mChildHelper.dispatchNestedPreScroll(i5, i6, iArr, iArr2, i7);
    }

    public void dispatchNestedScroll(int i5, int i6, int i7, int i8, int[] iArr, int i9, int[] iArr2) {
        this.mChildHelper.dispatchNestedScroll(i5, i6, i7, i8, iArr, i9, iArr2);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        int i5;
        super.draw(canvas);
        int scrollY = getScrollY();
        int i6 = 0;
        if (!this.mEdgeGlowTop.isFinished()) {
            int save = canvas.save();
            int width = getWidth();
            int height = getHeight();
            int min = Math.min(0, scrollY);
            if (Api21Impl.getClipToPadding(this)) {
                width -= getPaddingLeft() + getPaddingRight();
                i5 = getPaddingLeft();
            } else {
                i5 = 0;
            }
            if (Api21Impl.getClipToPadding(this)) {
                height -= getPaddingTop() + getPaddingBottom();
                min += getPaddingTop();
            }
            canvas.translate(i5, min);
            this.mEdgeGlowTop.setSize(width, height);
            if (this.mEdgeGlowTop.draw(canvas)) {
                postInvalidateOnAnimation();
            }
            canvas.restoreToCount(save);
        }
        if (this.mEdgeGlowBottom.isFinished()) {
            return;
        }
        int save2 = canvas.save();
        int width2 = getWidth();
        int height2 = getHeight();
        int max = Math.max(getScrollRange(), scrollY) + height2;
        if (Api21Impl.getClipToPadding(this)) {
            width2 -= getPaddingLeft() + getPaddingRight();
            i6 = getPaddingLeft();
        }
        if (Api21Impl.getClipToPadding(this)) {
            height2 -= getPaddingTop() + getPaddingBottom();
            max -= getPaddingBottom();
        }
        canvas.translate(i6 - width2, max);
        canvas.rotate(180.0f, width2, DECELERATION_RATE);
        this.mEdgeGlowBottom.setSize(width2, height2);
        if (this.mEdgeGlowBottom.draw(canvas)) {
            postInvalidateOnAnimation();
        }
        canvas.restoreToCount(save2);
    }

    public boolean executeKeyEvent(KeyEvent keyEvent) {
        this.mTempRect.setEmpty();
        if (!canScroll()) {
            if (!isFocused() || keyEvent.getKeyCode() == 4) {
                return false;
            }
            View findFocus = findFocus();
            if (findFocus == this) {
                findFocus = null;
            }
            View findNextFocus = FocusFinder.getInstance().findNextFocus(this, findFocus, 130);
            return (findNextFocus == null || findNextFocus == this || !findNextFocus.requestFocus(130)) ? false : true;
        }
        if (keyEvent.getAction() != 0) {
            return false;
        }
        int keyCode = keyEvent.getKeyCode();
        if (keyCode == 19) {
            return keyEvent.isAltPressed() ? fullScroll(33) : arrowScroll(33);
        }
        if (keyCode == 20) {
            return keyEvent.isAltPressed() ? fullScroll(130) : arrowScroll(130);
        }
        if (keyCode == 62) {
            pageScroll(keyEvent.isShiftPressed() ? 33 : 130);
            return false;
        }
        if (keyCode == 92) {
            return fullScroll(33);
        }
        if (keyCode == 93) {
            return fullScroll(130);
        }
        if (keyCode == 122) {
            pageScroll(33);
            return false;
        }
        if (keyCode != 123) {
            return false;
        }
        pageScroll(130);
        return false;
    }

    public void fling(int i5) {
        if (getChildCount() > 0) {
            this.mScroller.fling(getScrollX(), getScrollY(), 0, i5, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE, 0, 0);
            runAnimatedScroll(true);
            if (BuildCompat.isAtLeastV()) {
                Api35Impl.setFrameContentVelocity(this, Math.abs(this.mScroller.getCurrVelocity()));
            }
        }
    }

    public boolean fullScroll(int i5) {
        int childCount;
        boolean z5 = i5 == 130;
        int height = getHeight();
        Rect rect = this.mTempRect;
        rect.top = 0;
        rect.bottom = height;
        if (z5 && (childCount = getChildCount()) > 0) {
            View childAt = getChildAt(childCount - 1);
            this.mTempRect.bottom = childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin + getPaddingBottom();
            Rect rect2 = this.mTempRect;
            rect2.top = rect2.bottom - height;
        }
        Rect rect3 = this.mTempRect;
        return scrollAndFocus(i5, rect3.top, rect3.bottom);
    }

    @Override // android.view.View
    protected float getBottomFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return DECELERATION_RATE;
        }
        View childAt = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        int bottom = ((childAt.getBottom() + layoutParams.bottomMargin) - getScrollY()) - (getHeight() - getPaddingBottom());
        if (bottom < verticalFadingEdgeLength) {
            return bottom / verticalFadingEdgeLength;
        }
        return 1.0f;
    }

    public int getMaxScrollAmount() {
        return (int) (getHeight() * 0.5f);
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        return this.mParentHelper.getNestedScrollAxes();
    }

    int getScrollRange() {
        if (getChildCount() <= 0) {
            return 0;
        }
        View childAt = getChildAt(0);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
        return Math.max(0, ((childAt.getHeight() + layoutParams.topMargin) + layoutParams.bottomMargin) - ((getHeight() - getPaddingTop()) - getPaddingBottom()));
    }

    @Override // android.view.View
    protected float getTopFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return DECELERATION_RATE;
        }
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        int scrollY = getScrollY();
        if (scrollY < verticalFadingEdgeLength) {
            return scrollY / verticalFadingEdgeLength;
        }
        return 1.0f;
    }

    float getVerticalScrollFactorCompat() {
        if (this.mVerticalScrollFactor == DECELERATION_RATE) {
            TypedValue typedValue = new TypedValue();
            Context context = getContext();
            if (!context.getTheme().resolveAttribute(R.attr.listPreferredItemHeight, typedValue, true)) {
                throw new IllegalStateException("Expected theme to define listPreferredItemHeight.");
            }
            this.mVerticalScrollFactor = typedValue.getDimension(context.getResources().getDisplayMetrics());
        }
        return this.mVerticalScrollFactor;
    }

    public boolean hasNestedScrollingParent(int i5) {
        return this.mChildHelper.hasNestedScrollingParent(i5);
    }

    @Override // android.view.View
    public boolean isNestedScrollingEnabled() {
        return this.mChildHelper.isNestedScrollingEnabled();
    }

    @Override // android.view.ViewGroup
    protected void measureChild(View view, int i5, int i6) {
        view.measure(ViewGroup.getChildMeasureSpec(i5, getPaddingLeft() + getPaddingRight(), view.getLayoutParams().width), View.MeasureSpec.makeMeasureSpec(0, 0));
    }

    @Override // android.view.ViewGroup
    protected void measureChildWithMargins(View view, int i5, int i6, int i7, int i8) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        view.measure(ViewGroup.getChildMeasureSpec(i5, getPaddingLeft() + getPaddingRight() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i6, marginLayoutParams.width), View.MeasureSpec.makeMeasureSpec(marginLayoutParams.topMargin + marginLayoutParams.bottomMargin, 0));
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mIsLaidOut = false;
    }

    @Override // android.view.View
    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        int i5;
        int i6;
        float f5;
        if (motionEvent.getAction() == 8 && !this.mIsBeingDragged) {
            if (MotionEventCompat.isFromSource(motionEvent, 2)) {
                i5 = 9;
                f5 = motionEvent.getAxisValue(9);
                i6 = (int) motionEvent.getX();
            } else if (MotionEventCompat.isFromSource(motionEvent, 4194304)) {
                float axisValue = motionEvent.getAxisValue(26);
                i6 = getWidth() / 2;
                i5 = 26;
                f5 = axisValue;
            } else {
                i5 = 0;
                i6 = 0;
                f5 = 0.0f;
            }
            if (f5 != DECELERATION_RATE) {
                scrollBy(-((int) (f5 * getVerticalScrollFactorCompat())), i6, 1, MotionEventCompat.isFromSource(motionEvent, 8194));
                if (i5 != 0) {
                    this.mDifferentialMotionFlingController.onMotionEvent(motionEvent, i5);
                }
                return true;
            }
        }
        return false;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        boolean z5 = true;
        if (action == 2 && this.mIsBeingDragged) {
            return true;
        }
        int i5 = action & Function.USE_VARARGS;
        if (i5 != 0) {
            if (i5 != 1) {
                if (i5 == 2) {
                    int i6 = this.mActivePointerId;
                    if (i6 != -1) {
                        int findPointerIndex = motionEvent.findPointerIndex(i6);
                        if (findPointerIndex == -1) {
                            Log.e(TAG, "Invalid pointerId=" + i6 + " in onInterceptTouchEvent");
                        } else {
                            int y5 = (int) motionEvent.getY(findPointerIndex);
                            if (Math.abs(y5 - this.mLastMotionY) > this.mTouchSlop && (2 & getNestedScrollAxes()) == 0) {
                                this.mIsBeingDragged = true;
                                this.mLastMotionY = y5;
                                initVelocityTrackerIfNotExists();
                                this.mVelocityTracker.addMovement(motionEvent);
                                this.mNestedYOffset = 0;
                                ViewParent parent = getParent();
                                if (parent != null) {
                                    parent.requestDisallowInterceptTouchEvent(true);
                                }
                            }
                        }
                    }
                } else if (i5 != 3) {
                    if (i5 == 6) {
                        onSecondaryPointerUp(motionEvent);
                    }
                }
            }
            this.mIsBeingDragged = false;
            this.mActivePointerId = -1;
            recycleVelocityTracker();
            if (this.mScroller.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                postInvalidateOnAnimation();
            }
            stopNestedScroll(0);
        } else {
            int y6 = (int) motionEvent.getY();
            if (inChild((int) motionEvent.getX(), y6)) {
                this.mLastMotionY = y6;
                this.mActivePointerId = motionEvent.getPointerId(0);
                initOrResetVelocityTracker();
                this.mVelocityTracker.addMovement(motionEvent);
                this.mScroller.computeScrollOffset();
                if (!stopGlowAnimations(motionEvent) && this.mScroller.isFinished()) {
                    z5 = false;
                }
                this.mIsBeingDragged = z5;
                startNestedScroll(2, 0);
            } else {
                if (!stopGlowAnimations(motionEvent) && this.mScroller.isFinished()) {
                    z5 = false;
                }
                this.mIsBeingDragged = z5;
                recycleVelocityTracker();
            }
        }
        return this.mIsBeingDragged;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z5, int i5, int i6, int i7, int i8) {
        super.onLayout(z5, i5, i6, i7, i8);
        int i9 = 0;
        this.mIsLayoutDirty = false;
        View view = this.mChildToScrollTo;
        if (view != null && isViewDescendantOf(view, this)) {
            scrollToChild(this.mChildToScrollTo);
        }
        this.mChildToScrollTo = null;
        if (!this.mIsLaidOut) {
            if (this.mSavedState != null) {
                scrollTo(getScrollX(), this.mSavedState.scrollPosition);
                this.mSavedState = null;
            }
            if (getChildCount() > 0) {
                View childAt = getChildAt(0);
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
                i9 = childAt.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
            }
            int paddingTop = ((i8 - i6) - getPaddingTop()) - getPaddingBottom();
            int scrollY = getScrollY();
            int clamp = clamp(scrollY, paddingTop, i9);
            if (clamp != scrollY) {
                scrollTo(getScrollX(), clamp);
            }
        }
        scrollTo(getScrollX(), getScrollY());
        this.mIsLaidOut = true;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i5, int i6) {
        super.onMeasure(i5, i6);
        if (this.mFillViewport && View.MeasureSpec.getMode(i6) != 0 && getChildCount() > 0) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int measuredHeight2 = (((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom()) - layoutParams.topMargin) - layoutParams.bottomMargin;
            if (measuredHeight < measuredHeight2) {
                childAt.measure(ViewGroup.getChildMeasureSpec(i5, getPaddingLeft() + getPaddingRight() + layoutParams.leftMargin + layoutParams.rightMargin, layoutParams.width), View.MeasureSpec.makeMeasureSpec(measuredHeight2, 1073741824));
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedFling(View view, float f5, float f6, boolean z5) {
        if (z5) {
            return false;
        }
        dispatchNestedFling(DECELERATION_RATE, f6, true);
        fling((int) f6);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedPreFling(View view, float f5, float f6) {
        return dispatchNestedPreFling(f5, f6);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedPreScroll(View view, int i5, int i6, int[] iArr, int i7) {
        dispatchNestedPreScroll(i5, i6, iArr, null, i7);
    }

    @Override // androidx.core.view.NestedScrollingParent3
    public void onNestedScroll(View view, int i5, int i6, int i7, int i8, int i9, int[] iArr) {
        onNestedScrollInternal(i8, i9, iArr);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedScrollAccepted(View view, View view2, int i5, int i6) {
        this.mParentHelper.onNestedScrollAccepted(view, view2, i5, i6);
        startNestedScroll(2, i6);
    }

    @Override // android.view.View
    protected void onOverScrolled(int i5, int i6, boolean z5, boolean z6) {
        super.scrollTo(i5, i6);
    }

    @Override // android.view.ViewGroup
    protected boolean onRequestFocusInDescendants(int i5, Rect rect) {
        if (i5 == 2) {
            i5 = 130;
        } else if (i5 == 1) {
            i5 = 33;
        }
        View findNextFocus = rect == null ? FocusFinder.getInstance().findNextFocus(this, null, i5) : FocusFinder.getInstance().findNextFocusFromRect(this, rect, i5);
        if (findNextFocus == null || isOffScreen(findNextFocus)) {
            return false;
        }
        return findNextFocus.requestFocus(i5, rect);
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.mSavedState = savedState;
        requestLayout();
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.scrollPosition = getScrollY();
        return savedState;
    }

    @Override // android.view.View
    protected void onScrollChanged(int i5, int i6, int i7, int i8) {
        super.onScrollChanged(i5, i6, i7, i8);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i5, int i6, int i7, int i8) {
        super.onSizeChanged(i5, i6, i7, i8);
        View findFocus = findFocus();
        if (findFocus == null || this == findFocus || !isWithinDeltaOfScreen(findFocus, 0, i8)) {
            return;
        }
        findFocus.getDrawingRect(this.mTempRect);
        offsetDescendantRectToMyCoords(findFocus, this.mTempRect);
        doScrollY(computeScrollDeltaToGetChildRectOnScreen(this.mTempRect));
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public boolean onStartNestedScroll(View view, View view2, int i5, int i6) {
        return (i5 & 2) != 0;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onStopNestedScroll(View view, int i5) {
        this.mParentHelper.onStopNestedScroll(view, i5);
        stopNestedScroll(i5);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        ViewParent parent;
        initVelocityTrackerIfNotExists();
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.mNestedYOffset = 0;
        }
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        obtain.offsetLocation(DECELERATION_RATE, this.mNestedYOffset);
        if (actionMasked != 0) {
            if (actionMasked == 1) {
                VelocityTracker velocityTracker = this.mVelocityTracker;
                velocityTracker.computeCurrentVelocity(Constants.ONE_SECOND, this.mMaximumVelocity);
                int yVelocity = (int) velocityTracker.getYVelocity(this.mActivePointerId);
                if (Math.abs(yVelocity) >= this.mMinimumVelocity) {
                    if (!edgeEffectFling(yVelocity)) {
                        int i5 = -yVelocity;
                        float f5 = i5;
                        if (!dispatchNestedPreFling(DECELERATION_RATE, f5)) {
                            dispatchNestedFling(DECELERATION_RATE, f5, true);
                            fling(i5);
                        }
                    }
                } else if (this.mScroller.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                    postInvalidateOnAnimation();
                }
                endTouchDrag();
            } else if (actionMasked == 2) {
                int findPointerIndex = motionEvent.findPointerIndex(this.mActivePointerId);
                if (findPointerIndex == -1) {
                    Log.e(TAG, "Invalid pointerId=" + this.mActivePointerId + " in onTouchEvent");
                } else {
                    int y5 = (int) motionEvent.getY(findPointerIndex);
                    int i6 = this.mLastMotionY - y5;
                    int releaseVerticalGlow = i6 - releaseVerticalGlow(i6, motionEvent.getX(findPointerIndex));
                    if (!this.mIsBeingDragged && Math.abs(releaseVerticalGlow) > this.mTouchSlop) {
                        ViewParent parent2 = getParent();
                        if (parent2 != null) {
                            parent2.requestDisallowInterceptTouchEvent(true);
                        }
                        this.mIsBeingDragged = true;
                        releaseVerticalGlow = releaseVerticalGlow > 0 ? releaseVerticalGlow - this.mTouchSlop : releaseVerticalGlow + this.mTouchSlop;
                    }
                    if (this.mIsBeingDragged) {
                        int scrollBy = scrollBy(releaseVerticalGlow, (int) motionEvent.getX(findPointerIndex), 0, false);
                        this.mLastMotionY = y5 - scrollBy;
                        this.mNestedYOffset += scrollBy;
                    }
                }
            } else if (actionMasked == 3) {
                if (this.mIsBeingDragged && getChildCount() > 0 && this.mScroller.springBack(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                    postInvalidateOnAnimation();
                }
                endTouchDrag();
            } else if (actionMasked == 5) {
                int actionIndex = motionEvent.getActionIndex();
                this.mLastMotionY = (int) motionEvent.getY(actionIndex);
                this.mActivePointerId = motionEvent.getPointerId(actionIndex);
            } else if (actionMasked == 6) {
                onSecondaryPointerUp(motionEvent);
                this.mLastMotionY = (int) motionEvent.getY(motionEvent.findPointerIndex(this.mActivePointerId));
            }
        } else {
            if (getChildCount() == 0) {
                return false;
            }
            if (this.mIsBeingDragged && (parent = getParent()) != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
            if (!this.mScroller.isFinished()) {
                abortAnimatedScroll();
            }
            initializeTouchDrag((int) motionEvent.getY(), motionEvent.getPointerId(0));
        }
        VelocityTracker velocityTracker2 = this.mVelocityTracker;
        if (velocityTracker2 != null) {
            velocityTracker2.addMovement(obtain);
        }
        obtain.recycle();
        return true;
    }

    boolean overScrollByCompat(int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, boolean z5) {
        boolean z6;
        boolean z7;
        int overScrollMode = getOverScrollMode();
        boolean z8 = computeHorizontalScrollRange() > computeHorizontalScrollExtent();
        boolean z9 = computeVerticalScrollRange() > computeVerticalScrollExtent();
        boolean z10 = overScrollMode == 0 || (overScrollMode == 1 && z8);
        boolean z11 = overScrollMode == 0 || (overScrollMode == 1 && z9);
        int i13 = i7 + i5;
        int i14 = !z10 ? 0 : i11;
        int i15 = i8 + i6;
        int i16 = !z11 ? 0 : i12;
        int i17 = -i14;
        int i18 = i14 + i9;
        int i19 = -i16;
        int i20 = i16 + i10;
        if (i13 > i18) {
            i13 = i18;
            z6 = true;
        } else if (i13 < i17) {
            z6 = true;
            i13 = i17;
        } else {
            z6 = false;
        }
        if (i15 > i20) {
            i15 = i20;
            z7 = true;
        } else if (i15 < i19) {
            z7 = true;
            i15 = i19;
        } else {
            z7 = false;
        }
        if (z7 && !hasNestedScrollingParent(1)) {
            this.mScroller.springBack(i13, i15, 0, 0, 0, getScrollRange());
        }
        onOverScrolled(i13, i15, z6, z7);
        return z6 || z7;
    }

    public boolean pageScroll(int i5) {
        boolean z5 = i5 == 130;
        int height = getHeight();
        if (z5) {
            this.mTempRect.top = getScrollY() + height;
            int childCount = getChildCount();
            if (childCount > 0) {
                View childAt = getChildAt(childCount - 1);
                int bottom = childAt.getBottom() + ((FrameLayout.LayoutParams) childAt.getLayoutParams()).bottomMargin + getPaddingBottom();
                Rect rect = this.mTempRect;
                if (rect.top + height > bottom) {
                    rect.top = bottom - height;
                }
            }
        } else {
            this.mTempRect.top = getScrollY() - height;
            Rect rect2 = this.mTempRect;
            if (rect2.top < 0) {
                rect2.top = 0;
            }
        }
        Rect rect3 = this.mTempRect;
        int i6 = rect3.top;
        int i7 = height + i6;
        rect3.bottom = i7;
        return scrollAndFocus(i5, i6, i7);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestChildFocus(View view, View view2) {
        if (this.mIsLayoutDirty) {
            this.mChildToScrollTo = view2;
        } else {
            scrollToChild(view2);
        }
        super.requestChildFocus(view, view2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z5) {
        rect.offset(view.getLeft() - view.getScrollX(), view.getTop() - view.getScrollY());
        return scrollToChildRect(rect, z5);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z5) {
        if (z5) {
            recycleVelocityTracker();
        }
        super.requestDisallowInterceptTouchEvent(z5);
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        this.mIsLayoutDirty = true;
        super.requestLayout();
    }

    @Override // android.view.View
    public void scrollTo(int i5, int i6) {
        if (getChildCount() > 0) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
            int width2 = childAt.getWidth() + layoutParams.leftMargin + layoutParams.rightMargin;
            int height = (getHeight() - getPaddingTop()) - getPaddingBottom();
            int height2 = childAt.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
            int clamp = clamp(i5, width, width2);
            int clamp2 = clamp(i6, height, height2);
            if (clamp == getScrollX() && clamp2 == getScrollY()) {
                return;
            }
            super.scrollTo(clamp, clamp2);
        }
    }

    public void setFillViewport(boolean z5) {
        if (z5 != this.mFillViewport) {
            this.mFillViewport = z5;
            requestLayout();
        }
    }

    @Override // android.view.View
    public void setNestedScrollingEnabled(boolean z5) {
        this.mChildHelper.setNestedScrollingEnabled(z5);
    }

    public void setOnScrollChangeListener(OnScrollChangeListener onScrollChangeListener) {
    }

    public void setSmoothScrollingEnabled(boolean z5) {
        this.mSmoothScrollingEnabled = z5;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public boolean shouldDelayChildPressedState() {
        return true;
    }

    public final void smoothScrollBy(int i5, int i6) {
        smoothScrollBy(i5, i6, DEFAULT_SMOOTH_SCROLL_DURATION, false);
    }

    void smoothScrollTo(int i5, int i6, boolean z5) {
        smoothScrollTo(i5, i6, DEFAULT_SMOOTH_SCROLL_DURATION, z5);
    }

    public boolean startNestedScroll(int i5, int i6) {
        return this.mChildHelper.startNestedScroll(i5, i6);
    }

    public void stopNestedScroll(int i5) {
        this.mChildHelper.stopNestedScroll(i5);
    }

    public NestedScrollView(Context context, AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
        this.mTempRect = new Rect();
        this.mIsLayoutDirty = true;
        this.mIsLaidOut = false;
        this.mChildToScrollTo = null;
        this.mIsBeingDragged = false;
        this.mSmoothScrollingEnabled = true;
        this.mActivePointerId = -1;
        this.mScrollOffset = new int[2];
        this.mScrollConsumed = new int[2];
        DifferentialMotionFlingTargetImpl differentialMotionFlingTargetImpl = new DifferentialMotionFlingTargetImpl();
        this.mDifferentialMotionFlingTarget = differentialMotionFlingTargetImpl;
        this.mDifferentialMotionFlingController = new DifferentialMotionFlingController(getContext(), differentialMotionFlingTargetImpl);
        this.mEdgeGlowTop = EdgeEffectCompat.create(context, attributeSet);
        this.mEdgeGlowBottom = EdgeEffectCompat.create(context, attributeSet);
        this.mPhysicalCoeff = context.getResources().getDisplayMetrics().density * 160.0f * 386.0878f * 0.84f;
        initScrollView();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, SCROLLVIEW_STYLEABLE, i5, 0);
        setFillViewport(obtainStyledAttributes.getBoolean(0, false));
        obtainStyledAttributes.recycle();
        this.mParentHelper = new NestedScrollingParentHelper(this);
        this.mChildHelper = new NestedScrollingChildHelper(this);
        setNestedScrollingEnabled(true);
        ViewCompat.setAccessibilityDelegate(this, ACCESSIBILITY_DELEGATE);
    }

    private void smoothScrollBy(int i5, int i6, int i7, boolean z5) {
        if (getChildCount() == 0) {
            return;
        }
        if (AnimationUtils.currentAnimationTimeMillis() - this.mLastScroll > 250) {
            View childAt = getChildAt(0);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            int height = childAt.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
            int height2 = (getHeight() - getPaddingTop()) - getPaddingBottom();
            int scrollY = getScrollY();
            this.mScroller.startScroll(getScrollX(), scrollY, 0, Math.max(0, Math.min(i6 + scrollY, Math.max(0, height - height2))) - scrollY, i7);
            runAnimatedScroll(z5);
        } else {
            if (!this.mScroller.isFinished()) {
                abortAnimatedScroll();
            }
            scrollBy(i5, i6);
        }
        this.mLastScroll = AnimationUtils.currentAnimationTimeMillis();
    }

    @Override // android.view.View
    public boolean dispatchNestedPreScroll(int i5, int i6, int[] iArr, int[] iArr2) {
        return dispatchNestedPreScroll(i5, i6, iArr, iArr2, 0);
    }

    @Override // android.view.View
    public boolean dispatchNestedScroll(int i5, int i6, int i7, int i8, int[] iArr) {
        return this.mChildHelper.dispatchNestedScroll(i5, i6, i7, i8, iArr);
    }

    @Override // android.view.View
    public boolean hasNestedScrollingParent() {
        return hasNestedScrollingParent(0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedPreScroll(View view, int i5, int i6, int[] iArr) {
        onNestedPreScroll(view, i5, i6, iArr, 0);
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedScroll(View view, int i5, int i6, int i7, int i8, int i9) {
        onNestedScrollInternal(i8, i9, null);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onStartNestedScroll(View view, View view2, int i5) {
        return onStartNestedScroll(view, view2, i5, 0);
    }

    void smoothScrollTo(int i5, int i6, int i7, boolean z5) {
        smoothScrollBy(i5 - getScrollX(), i6 - getScrollY(), i7, z5);
    }

    @Override // android.view.View
    public boolean startNestedScroll(int i5) {
        return startNestedScroll(i5, 0);
    }

    @Override // android.view.View
    public void stopNestedScroll() {
        stopNestedScroll(0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedScroll(View view, int i5, int i6, int i7, int i8) {
        onNestedScrollInternal(i8, 0, null);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onNestedScrollAccepted(View view, View view2, int i5) {
        onNestedScrollAccepted(view, view2, i5, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void onStopNestedScroll(View view) {
        onStopNestedScroll(view, 0);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i5) {
        if (getChildCount() <= 0) {
            super.addView(view, i5);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        if (getChildCount() <= 0) {
            super.addView(view, layoutParams);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i5, ViewGroup.LayoutParams layoutParams) {
        if (getChildCount() <= 0) {
            super.addView(view, i5, layoutParams);
            return;
        }
        throw new IllegalStateException("ScrollView can host only one direct child");
    }
}
