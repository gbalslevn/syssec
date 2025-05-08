package androidx.core.widget;

import android.content.res.Resources;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import androidx.core.view.ViewCompat;

/* loaded from: classes.dex */
public abstract class AutoScrollHelper implements View.OnTouchListener {
    private static final int DEFAULT_ACTIVATION_DELAY = ViewConfiguration.getTapTimeout();
    private static final int DEFAULT_EDGE_TYPE = 1;
    private static final float DEFAULT_MAXIMUM_EDGE = Float.MAX_VALUE;
    private static final int DEFAULT_MAXIMUM_VELOCITY_DIPS = 1575;
    private static final int DEFAULT_MINIMUM_VELOCITY_DIPS = 315;
    private static final int DEFAULT_RAMP_DOWN_DURATION = 500;
    private static final int DEFAULT_RAMP_UP_DURATION = 500;
    private static final float DEFAULT_RELATIVE_EDGE = 0.2f;
    private static final float DEFAULT_RELATIVE_VELOCITY = 1.0f;
    private static final int HORIZONTAL = 0;
    private static final int VERTICAL = 1;
    private int mActivationDelay;
    private boolean mAlreadyDelayed;
    boolean mAnimating;
    private int mEdgeType;
    private boolean mEnabled;
    private boolean mExclusive;
    boolean mNeedsCancel;
    boolean mNeedsReset;
    private Runnable mRunnable;
    final View mTarget;
    final ClampedScroller mScroller = new ClampedScroller();
    private final Interpolator mEdgeInterpolator = new AccelerateInterpolator();
    private float[] mRelativeEdges = {0.0f, 0.0f};
    private float[] mMaximumEdges = {DEFAULT_MAXIMUM_EDGE, DEFAULT_MAXIMUM_EDGE};
    private float[] mRelativeVelocity = {0.0f, 0.0f};
    private float[] mMinimumVelocity = {0.0f, 0.0f};
    private float[] mMaximumVelocity = {DEFAULT_MAXIMUM_EDGE, DEFAULT_MAXIMUM_EDGE};

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class ClampedScroller {
        private int mEffectiveRampDown;
        private int mRampDownDuration;
        private int mRampUpDuration;
        private float mStopValue;
        private float mTargetVelocityX;
        private float mTargetVelocityY;
        private long mStartTime = Long.MIN_VALUE;
        private long mStopTime = -1;
        private long mDeltaTime = 0;
        private int mDeltaX = 0;
        private int mDeltaY = 0;

        ClampedScroller() {
        }

        private float getValueAt(long j5) {
            long j6 = this.mStartTime;
            if (j5 < j6) {
                return 0.0f;
            }
            long j7 = this.mStopTime;
            if (j7 < 0 || j5 < j7) {
                return AutoScrollHelper.constrain(((float) (j5 - j6)) / this.mRampUpDuration, 0.0f, AutoScrollHelper.DEFAULT_RELATIVE_VELOCITY) * 0.5f;
            }
            float f5 = this.mStopValue;
            return (AutoScrollHelper.DEFAULT_RELATIVE_VELOCITY - f5) + (f5 * AutoScrollHelper.constrain(((float) (j5 - j7)) / this.mEffectiveRampDown, 0.0f, AutoScrollHelper.DEFAULT_RELATIVE_VELOCITY));
        }

        private float interpolateValue(float f5) {
            return ((-4.0f) * f5 * f5) + (f5 * 4.0f);
        }

        public void computeScrollDelta() {
            if (this.mDeltaTime == 0) {
                throw new RuntimeException("Cannot compute scroll delta before calling start()");
            }
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            float interpolateValue = interpolateValue(getValueAt(currentAnimationTimeMillis));
            long j5 = currentAnimationTimeMillis - this.mDeltaTime;
            this.mDeltaTime = currentAnimationTimeMillis;
            float f5 = ((float) j5) * interpolateValue;
            this.mDeltaX = (int) (this.mTargetVelocityX * f5);
            this.mDeltaY = (int) (f5 * this.mTargetVelocityY);
        }

        public int getDeltaX() {
            return this.mDeltaX;
        }

        public int getDeltaY() {
            return this.mDeltaY;
        }

        public int getHorizontalDirection() {
            float f5 = this.mTargetVelocityX;
            return (int) (f5 / Math.abs(f5));
        }

        public int getVerticalDirection() {
            float f5 = this.mTargetVelocityY;
            return (int) (f5 / Math.abs(f5));
        }

        public boolean isFinished() {
            return this.mStopTime > 0 && AnimationUtils.currentAnimationTimeMillis() > this.mStopTime + ((long) this.mEffectiveRampDown);
        }

        public void requestStop() {
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            this.mEffectiveRampDown = AutoScrollHelper.constrain((int) (currentAnimationTimeMillis - this.mStartTime), 0, this.mRampDownDuration);
            this.mStopValue = getValueAt(currentAnimationTimeMillis);
            this.mStopTime = currentAnimationTimeMillis;
        }

        public void setRampDownDuration(int i5) {
            this.mRampDownDuration = i5;
        }

        public void setRampUpDuration(int i5) {
            this.mRampUpDuration = i5;
        }

        public void setTargetVelocity(float f5, float f6) {
            this.mTargetVelocityX = f5;
            this.mTargetVelocityY = f6;
        }

        public void start() {
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            this.mStartTime = currentAnimationTimeMillis;
            this.mStopTime = -1L;
            this.mDeltaTime = currentAnimationTimeMillis;
            this.mStopValue = 0.5f;
            this.mDeltaX = 0;
            this.mDeltaY = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class ScrollAnimationRunnable implements Runnable {
        ScrollAnimationRunnable() {
        }

        @Override // java.lang.Runnable
        public void run() {
            AutoScrollHelper autoScrollHelper = AutoScrollHelper.this;
            if (autoScrollHelper.mAnimating) {
                if (autoScrollHelper.mNeedsReset) {
                    autoScrollHelper.mNeedsReset = false;
                    autoScrollHelper.mScroller.start();
                }
                ClampedScroller clampedScroller = AutoScrollHelper.this.mScroller;
                if (clampedScroller.isFinished() || !AutoScrollHelper.this.shouldAnimate()) {
                    AutoScrollHelper.this.mAnimating = false;
                    return;
                }
                AutoScrollHelper autoScrollHelper2 = AutoScrollHelper.this;
                if (autoScrollHelper2.mNeedsCancel) {
                    autoScrollHelper2.mNeedsCancel = false;
                    autoScrollHelper2.cancelTargetTouch();
                }
                clampedScroller.computeScrollDelta();
                AutoScrollHelper.this.scrollTargetBy(clampedScroller.getDeltaX(), clampedScroller.getDeltaY());
                ViewCompat.postOnAnimation(AutoScrollHelper.this.mTarget, this);
            }
        }
    }

    public AutoScrollHelper(View view) {
        this.mTarget = view;
        float f5 = Resources.getSystem().getDisplayMetrics().density;
        float f6 = (int) ((1575.0f * f5) + 0.5f);
        setMaximumVelocity(f6, f6);
        float f7 = (int) ((f5 * 315.0f) + 0.5f);
        setMinimumVelocity(f7, f7);
        setEdgeType(1);
        setMaximumEdges(DEFAULT_MAXIMUM_EDGE, DEFAULT_MAXIMUM_EDGE);
        setRelativeEdges(DEFAULT_RELATIVE_EDGE, DEFAULT_RELATIVE_EDGE);
        setRelativeVelocity(DEFAULT_RELATIVE_VELOCITY, DEFAULT_RELATIVE_VELOCITY);
        setActivationDelay(DEFAULT_ACTIVATION_DELAY);
        setRampUpDuration(500);
        setRampDownDuration(500);
    }

    private float computeTargetVelocity(int i5, float f5, float f6, float f7) {
        float edgeValue = getEdgeValue(this.mRelativeEdges[i5], f6, this.mMaximumEdges[i5], f5);
        if (edgeValue == 0.0f) {
            return 0.0f;
        }
        float f8 = this.mRelativeVelocity[i5];
        float f9 = this.mMinimumVelocity[i5];
        float f10 = this.mMaximumVelocity[i5];
        float f11 = f8 * f7;
        return edgeValue > 0.0f ? constrain(edgeValue * f11, f9, f10) : -constrain((-edgeValue) * f11, f9, f10);
    }

    static float constrain(float f5, float f6, float f7) {
        return f5 > f7 ? f7 : f5 < f6 ? f6 : f5;
    }

    private float constrainEdgeValue(float f5, float f6) {
        if (f6 == 0.0f) {
            return 0.0f;
        }
        int i5 = this.mEdgeType;
        if (i5 == 0 || i5 == 1) {
            if (f5 < f6) {
                if (f5 >= 0.0f) {
                    return DEFAULT_RELATIVE_VELOCITY - (f5 / f6);
                }
                if (this.mAnimating && i5 == 1) {
                    return DEFAULT_RELATIVE_VELOCITY;
                }
            }
        } else if (i5 == 2 && f5 < 0.0f) {
            return f5 / (-f6);
        }
        return 0.0f;
    }

    private float getEdgeValue(float f5, float f6, float f7, float f8) {
        float interpolation;
        float constrain = constrain(f5 * f6, 0.0f, f7);
        float constrainEdgeValue = constrainEdgeValue(f6 - f8, constrain) - constrainEdgeValue(f8, constrain);
        if (constrainEdgeValue < 0.0f) {
            interpolation = -this.mEdgeInterpolator.getInterpolation(-constrainEdgeValue);
        } else {
            if (constrainEdgeValue <= 0.0f) {
                return 0.0f;
            }
            interpolation = this.mEdgeInterpolator.getInterpolation(constrainEdgeValue);
        }
        return constrain(interpolation, -1.0f, DEFAULT_RELATIVE_VELOCITY);
    }

    private void requestStop() {
        if (this.mNeedsReset) {
            this.mAnimating = false;
        } else {
            this.mScroller.requestStop();
        }
    }

    private void startAnimating() {
        int i5;
        if (this.mRunnable == null) {
            this.mRunnable = new ScrollAnimationRunnable();
        }
        this.mAnimating = true;
        this.mNeedsReset = true;
        if (this.mAlreadyDelayed || (i5 = this.mActivationDelay) <= 0) {
            this.mRunnable.run();
        } else {
            ViewCompat.postOnAnimationDelayed(this.mTarget, this.mRunnable, i5);
        }
        this.mAlreadyDelayed = true;
    }

    public abstract boolean canTargetScrollHorizontally(int i5);

    public abstract boolean canTargetScrollVertically(int i5);

    void cancelTargetTouch() {
        long uptimeMillis = SystemClock.uptimeMillis();
        MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
        this.mTarget.onTouchEvent(obtain);
        obtain.recycle();
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0013, code lost:
    
        if (r0 != 3) goto L20;
     */
    @Override // android.view.View.OnTouchListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (!this.mEnabled) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked != 2) {
                }
            }
            requestStop();
            return this.mExclusive && this.mAnimating;
        }
        this.mNeedsCancel = true;
        this.mAlreadyDelayed = false;
        this.mScroller.setTargetVelocity(computeTargetVelocity(0, motionEvent.getX(), view.getWidth(), this.mTarget.getWidth()), computeTargetVelocity(1, motionEvent.getY(), view.getHeight(), this.mTarget.getHeight()));
        if (!this.mAnimating && shouldAnimate()) {
            startAnimating();
        }
        if (this.mExclusive) {
            return false;
        }
    }

    public abstract void scrollTargetBy(int i5, int i6);

    public AutoScrollHelper setActivationDelay(int i5) {
        this.mActivationDelay = i5;
        return this;
    }

    public AutoScrollHelper setEdgeType(int i5) {
        this.mEdgeType = i5;
        return this;
    }

    public AutoScrollHelper setEnabled(boolean z5) {
        if (this.mEnabled && !z5) {
            requestStop();
        }
        this.mEnabled = z5;
        return this;
    }

    public AutoScrollHelper setMaximumEdges(float f5, float f6) {
        float[] fArr = this.mMaximumEdges;
        fArr[0] = f5;
        fArr[1] = f6;
        return this;
    }

    public AutoScrollHelper setMaximumVelocity(float f5, float f6) {
        float[] fArr = this.mMaximumVelocity;
        fArr[0] = f5 / 1000.0f;
        fArr[1] = f6 / 1000.0f;
        return this;
    }

    public AutoScrollHelper setMinimumVelocity(float f5, float f6) {
        float[] fArr = this.mMinimumVelocity;
        fArr[0] = f5 / 1000.0f;
        fArr[1] = f6 / 1000.0f;
        return this;
    }

    public AutoScrollHelper setRampDownDuration(int i5) {
        this.mScroller.setRampDownDuration(i5);
        return this;
    }

    public AutoScrollHelper setRampUpDuration(int i5) {
        this.mScroller.setRampUpDuration(i5);
        return this;
    }

    public AutoScrollHelper setRelativeEdges(float f5, float f6) {
        float[] fArr = this.mRelativeEdges;
        fArr[0] = f5;
        fArr[1] = f6;
        return this;
    }

    public AutoScrollHelper setRelativeVelocity(float f5, float f6) {
        float[] fArr = this.mRelativeVelocity;
        fArr[0] = f5 / 1000.0f;
        fArr[1] = f6 / 1000.0f;
        return this;
    }

    boolean shouldAnimate() {
        ClampedScroller clampedScroller = this.mScroller;
        int verticalDirection = clampedScroller.getVerticalDirection();
        int horizontalDirection = clampedScroller.getHorizontalDirection();
        return (verticalDirection != 0 && canTargetScrollVertically(verticalDirection)) || (horizontalDirection != 0 && canTargetScrollHorizontally(horizontalDirection));
    }

    static int constrain(int i5, int i6, int i7) {
        return i5 > i7 ? i7 : i5 < i6 ? i6 : i5;
    }
}
