package androidx.fragment.app;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.Transformation;
import androidx.core.view.OneShotPreDrawListener;
import androidx.fragment.R$animator;
import androidx.fragment.R$id;

/* loaded from: classes.dex */
abstract class FragmentAnim {
    private static int getNextAnim(Fragment fragment, boolean z5, boolean z6) {
        return z6 ? z5 ? fragment.getPopEnterAnim() : fragment.getPopExitAnim() : z5 ? fragment.getEnterAnim() : fragment.getExitAnim();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static AnimationOrAnimator loadAnimation(Context context, Fragment fragment, boolean z5, boolean z6) {
        int nextTransition = fragment.getNextTransition();
        int nextAnim = getNextAnim(fragment, z5, z6);
        fragment.setAnimations(0, 0, 0, 0);
        ViewGroup viewGroup = fragment.mContainer;
        if (viewGroup != null) {
            int i5 = R$id.visible_removing_fragment_view_tag;
            if (viewGroup.getTag(i5) != null) {
                fragment.mContainer.setTag(i5, null);
            }
        }
        ViewGroup viewGroup2 = fragment.mContainer;
        if (viewGroup2 != null && viewGroup2.getLayoutTransition() != null) {
            return null;
        }
        Animation onCreateAnimation = fragment.onCreateAnimation(nextTransition, z5, nextAnim);
        if (onCreateAnimation != null) {
            return new AnimationOrAnimator(onCreateAnimation);
        }
        Animator onCreateAnimator = fragment.onCreateAnimator(nextTransition, z5, nextAnim);
        if (onCreateAnimator != null) {
            return new AnimationOrAnimator(onCreateAnimator);
        }
        if (nextAnim == 0 && nextTransition != 0) {
            nextAnim = transitToAnimResourceId(context, nextTransition, z5);
        }
        if (nextAnim != 0) {
            boolean equals = "anim".equals(context.getResources().getResourceTypeName(nextAnim));
            if (equals) {
                try {
                    Animation loadAnimation = AnimationUtils.loadAnimation(context, nextAnim);
                    if (loadAnimation != null) {
                        return new AnimationOrAnimator(loadAnimation);
                    }
                } catch (Resources.NotFoundException e5) {
                    throw e5;
                } catch (RuntimeException unused) {
                }
            }
            try {
                Animator loadAnimator = AnimatorInflater.loadAnimator(context, nextAnim);
                if (loadAnimator != null) {
                    return new AnimationOrAnimator(loadAnimator);
                }
            } catch (RuntimeException e6) {
                if (equals) {
                    throw e6;
                }
                Animation loadAnimation2 = AnimationUtils.loadAnimation(context, nextAnim);
                if (loadAnimation2 != null) {
                    return new AnimationOrAnimator(loadAnimation2);
                }
            }
        }
        return null;
    }

    private static int toActivityTransitResId(Context context, int i5) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(R.style.Animation.Activity, new int[]{i5});
        int resourceId = obtainStyledAttributes.getResourceId(0, -1);
        obtainStyledAttributes.recycle();
        return resourceId;
    }

    private static int transitToAnimResourceId(Context context, int i5, boolean z5) {
        if (i5 == 4097) {
            return z5 ? R$animator.fragment_open_enter : R$animator.fragment_open_exit;
        }
        if (i5 == 8194) {
            return z5 ? R$animator.fragment_close_enter : R$animator.fragment_close_exit;
        }
        if (i5 == 8197) {
            return z5 ? toActivityTransitResId(context, R.attr.activityCloseEnterAnimation) : toActivityTransitResId(context, R.attr.activityCloseExitAnimation);
        }
        if (i5 == 4099) {
            return z5 ? R$animator.fragment_fade_enter : R$animator.fragment_fade_exit;
        }
        if (i5 != 4100) {
            return -1;
        }
        return z5 ? toActivityTransitResId(context, R.attr.activityOpenEnterAnimation) : toActivityTransitResId(context, R.attr.activityOpenExitAnimation);
    }

    /* loaded from: classes.dex */
    static class AnimationOrAnimator {
        public final Animation animation;
        public final Animator animator;

        AnimationOrAnimator(Animation animation) {
            this.animation = animation;
            this.animator = null;
            if (animation == null) {
                throw new IllegalStateException("Animation cannot be null");
            }
        }

        AnimationOrAnimator(Animator animator) {
            this.animation = null;
            this.animator = animator;
            if (animator == null) {
                throw new IllegalStateException("Animator cannot be null");
            }
        }
    }

    /* loaded from: classes.dex */
    static class EndViewTransitionAnimation extends AnimationSet implements Runnable {
        private boolean mAnimating;
        private final View mChild;
        private boolean mEnded;
        private final ViewGroup mParent;
        private boolean mTransitionEnded;

        /* JADX INFO: Access modifiers changed from: package-private */
        public EndViewTransitionAnimation(Animation animation, ViewGroup viewGroup, View view) {
            super(false);
            this.mAnimating = true;
            this.mParent = viewGroup;
            this.mChild = view;
            addAnimation(animation);
            viewGroup.post(this);
        }

        @Override // android.view.animation.AnimationSet, android.view.animation.Animation
        public boolean getTransformation(long j5, Transformation transformation) {
            this.mAnimating = true;
            if (this.mEnded) {
                return !this.mTransitionEnded;
            }
            if (!super.getTransformation(j5, transformation)) {
                this.mEnded = true;
                OneShotPreDrawListener.add(this.mParent, this);
            }
            return true;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.mEnded || !this.mAnimating) {
                this.mParent.endViewTransition(this.mChild);
                this.mTransitionEnded = true;
            } else {
                this.mAnimating = false;
                this.mParent.post(this);
            }
        }

        @Override // android.view.animation.Animation
        public boolean getTransformation(long j5, Transformation transformation, float f5) {
            this.mAnimating = true;
            if (this.mEnded) {
                return !this.mTransitionEnded;
            }
            if (!super.getTransformation(j5, transformation, f5)) {
                this.mEnded = true;
                OneShotPreDrawListener.add(this.mParent, this);
            }
            return true;
        }
    }
}
