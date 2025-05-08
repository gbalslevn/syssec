package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.collection.ArrayMap;
import androidx.core.os.CancellationSignal;
import androidx.core.util.Preconditions;
import androidx.core.view.OneShotPreDrawListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewGroupCompat;
import androidx.fragment.app.FragmentAnim;
import androidx.fragment.app.SpecialEffectsController;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
class DefaultSpecialEffectsController extends SpecialEffectsController {

    /* renamed from: androidx.fragment.app.DefaultSpecialEffectsController$10, reason: invalid class name */
    /* loaded from: classes.dex */
    static /* synthetic */ class AnonymousClass10 {
        static final /* synthetic */ int[] $SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$State;

        static {
            int[] iArr = new int[SpecialEffectsController.Operation.State.values().length];
            $SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$State = iArr;
            try {
                iArr[SpecialEffectsController.Operation.State.GONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$State[SpecialEffectsController.Operation.State.INVISIBLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$State[SpecialEffectsController.Operation.State.REMOVED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$State[SpecialEffectsController.Operation.State.VISIBLE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class AnimationInfo extends SpecialEffectsInfo {
        private FragmentAnim.AnimationOrAnimator mAnimation;
        private boolean mIsPop;
        private boolean mLoadedAnim;

        AnimationInfo(SpecialEffectsController.Operation operation, CancellationSignal cancellationSignal, boolean z5) {
            super(operation, cancellationSignal);
            this.mLoadedAnim = false;
            this.mIsPop = z5;
        }

        FragmentAnim.AnimationOrAnimator getAnimation(Context context) {
            if (this.mLoadedAnim) {
                return this.mAnimation;
            }
            FragmentAnim.AnimationOrAnimator loadAnimation = FragmentAnim.loadAnimation(context, getOperation().getFragment(), getOperation().getFinalState() == SpecialEffectsController.Operation.State.VISIBLE, this.mIsPop);
            this.mAnimation = loadAnimation;
            this.mLoadedAnim = true;
            return loadAnimation;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class SpecialEffectsInfo {
        private final SpecialEffectsController.Operation mOperation;
        private final CancellationSignal mSignal;

        SpecialEffectsInfo(SpecialEffectsController.Operation operation, CancellationSignal cancellationSignal) {
            this.mOperation = operation;
            this.mSignal = cancellationSignal;
        }

        void completeSpecialEffect() {
            this.mOperation.completeSpecialEffect(this.mSignal);
        }

        SpecialEffectsController.Operation getOperation() {
            return this.mOperation;
        }

        CancellationSignal getSignal() {
            return this.mSignal;
        }

        boolean isVisibilityUnchanged() {
            SpecialEffectsController.Operation.State state;
            SpecialEffectsController.Operation.State from = SpecialEffectsController.Operation.State.from(this.mOperation.getFragment().mView);
            SpecialEffectsController.Operation.State finalState = this.mOperation.getFinalState();
            return from == finalState || !(from == (state = SpecialEffectsController.Operation.State.VISIBLE) || finalState == state);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public DefaultSpecialEffectsController(ViewGroup viewGroup) {
        super(viewGroup);
    }

    private void startAnimations(List<AnimationInfo> list, List<SpecialEffectsController.Operation> list2, boolean z5, Map<SpecialEffectsController.Operation, Boolean> map) {
        int i5;
        boolean z6;
        Context context;
        View view;
        int i6;
        final SpecialEffectsController.Operation operation;
        final ViewGroup container = getContainer();
        Context context2 = container.getContext();
        ArrayList arrayList = new ArrayList();
        Iterator<AnimationInfo> it = list.iterator();
        boolean z7 = false;
        while (true) {
            i5 = 2;
            if (!it.hasNext()) {
                break;
            }
            final AnimationInfo next = it.next();
            if (next.isVisibilityUnchanged()) {
                next.completeSpecialEffect();
            } else {
                FragmentAnim.AnimationOrAnimator animation = next.getAnimation(context2);
                if (animation == null) {
                    next.completeSpecialEffect();
                } else {
                    final Animator animator = animation.animator;
                    if (animator == null) {
                        arrayList.add(next);
                    } else {
                        final SpecialEffectsController.Operation operation2 = next.getOperation();
                        Fragment fragment = operation2.getFragment();
                        if (Boolean.TRUE.equals(map.get(operation2))) {
                            if (FragmentManager.isLoggingEnabled(2)) {
                                Log.v("FragmentManager", "Ignoring Animator set on " + fragment + " as this Fragment was involved in a Transition.");
                            }
                            next.completeSpecialEffect();
                        } else {
                            boolean z8 = operation2.getFinalState() == SpecialEffectsController.Operation.State.GONE;
                            if (z8) {
                                list2.remove(operation2);
                            }
                            final View view2 = fragment.mView;
                            container.startViewTransition(view2);
                            final boolean z9 = z8;
                            animator.addListener(new AnimatorListenerAdapter() { // from class: androidx.fragment.app.DefaultSpecialEffectsController.2
                                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                                public void onAnimationEnd(Animator animator2) {
                                    container.endViewTransition(view2);
                                    if (z9) {
                                        operation2.getFinalState().applyState(view2);
                                    }
                                    next.completeSpecialEffect();
                                    if (FragmentManager.isLoggingEnabled(2)) {
                                        Log.v("FragmentManager", "Animator from operation " + operation2 + " has ended.");
                                    }
                                }
                            });
                            animator.setTarget(view2);
                            animator.start();
                            if (FragmentManager.isLoggingEnabled(2)) {
                                StringBuilder sb = new StringBuilder();
                                sb.append("Animator from operation ");
                                operation = operation2;
                                sb.append(operation);
                                sb.append(" has started.");
                                Log.v("FragmentManager", sb.toString());
                            } else {
                                operation = operation2;
                            }
                            next.getSignal().setOnCancelListener(new CancellationSignal.OnCancelListener() { // from class: androidx.fragment.app.DefaultSpecialEffectsController.3
                                @Override // androidx.core.os.CancellationSignal.OnCancelListener
                                public void onCancel() {
                                    animator.end();
                                    if (FragmentManager.isLoggingEnabled(2)) {
                                        Log.v("FragmentManager", "Animator from operation " + operation + " has been canceled.");
                                    }
                                }
                            });
                            z7 = true;
                        }
                    }
                }
            }
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            final AnimationInfo animationInfo = (AnimationInfo) it2.next();
            final SpecialEffectsController.Operation operation3 = animationInfo.getOperation();
            Fragment fragment2 = operation3.getFragment();
            if (z5) {
                if (FragmentManager.isLoggingEnabled(i5)) {
                    Log.v("FragmentManager", "Ignoring Animation set on " + fragment2 + " as Animations cannot run alongside Transitions.");
                }
                animationInfo.completeSpecialEffect();
            } else if (z7) {
                if (FragmentManager.isLoggingEnabled(i5)) {
                    Log.v("FragmentManager", "Ignoring Animation set on " + fragment2 + " as Animations cannot run alongside Animators.");
                }
                animationInfo.completeSpecialEffect();
            } else {
                final View view3 = fragment2.mView;
                Animation animation2 = (Animation) Preconditions.checkNotNull(((FragmentAnim.AnimationOrAnimator) Preconditions.checkNotNull(animationInfo.getAnimation(context2))).animation);
                if (operation3.getFinalState() != SpecialEffectsController.Operation.State.REMOVED) {
                    view3.startAnimation(animation2);
                    animationInfo.completeSpecialEffect();
                    z6 = z7;
                    context = context2;
                    i6 = i5;
                    view = view3;
                } else {
                    container.startViewTransition(view3);
                    FragmentAnim.EndViewTransitionAnimation endViewTransitionAnimation = new FragmentAnim.EndViewTransitionAnimation(animation2, container, view3);
                    z6 = z7;
                    context = context2;
                    view = view3;
                    endViewTransitionAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: androidx.fragment.app.DefaultSpecialEffectsController.4
                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationEnd(Animation animation3) {
                            container.post(new Runnable() { // from class: androidx.fragment.app.DefaultSpecialEffectsController.4.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    AnonymousClass4 anonymousClass4 = AnonymousClass4.this;
                                    container.endViewTransition(view3);
                                    animationInfo.completeSpecialEffect();
                                }
                            });
                            if (FragmentManager.isLoggingEnabled(2)) {
                                Log.v("FragmentManager", "Animation from operation " + operation3 + " has ended.");
                            }
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationRepeat(Animation animation3) {
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationStart(Animation animation3) {
                            if (FragmentManager.isLoggingEnabled(2)) {
                                Log.v("FragmentManager", "Animation from operation " + operation3 + " has reached onAnimationStart.");
                            }
                        }
                    });
                    view.startAnimation(endViewTransitionAnimation);
                    i6 = 2;
                    if (FragmentManager.isLoggingEnabled(2)) {
                        Log.v("FragmentManager", "Animation from operation " + operation3 + " has started.");
                    }
                }
                final View view4 = view;
                animationInfo.getSignal().setOnCancelListener(new CancellationSignal.OnCancelListener() { // from class: androidx.fragment.app.DefaultSpecialEffectsController.5
                    @Override // androidx.core.os.CancellationSignal.OnCancelListener
                    public void onCancel() {
                        view4.clearAnimation();
                        container.endViewTransition(view4);
                        animationInfo.completeSpecialEffect();
                        if (FragmentManager.isLoggingEnabled(2)) {
                            Log.v("FragmentManager", "Animation from operation " + operation3 + " has been cancelled.");
                        }
                    }
                });
                i5 = i6;
                z7 = z6;
                context2 = context;
            }
        }
    }

    private Map<SpecialEffectsController.Operation, Boolean> startTransitions(List<TransitionInfo> list, List<SpecialEffectsController.Operation> list2, final boolean z5, final SpecialEffectsController.Operation operation, final SpecialEffectsController.Operation operation2) {
        String str;
        String str2;
        String str3;
        View view;
        Object obj;
        ArrayList<View> arrayList;
        Object obj2;
        ArrayList<View> arrayList2;
        HashMap hashMap;
        View view2;
        Object mergeTransitionsTogether;
        ArrayMap arrayMap;
        ArrayList<View> arrayList3;
        SpecialEffectsController.Operation operation3;
        ArrayList<View> arrayList4;
        Rect rect;
        FragmentTransitionImpl fragmentTransitionImpl;
        HashMap hashMap2;
        SpecialEffectsController.Operation operation4;
        View view3;
        View view4;
        final View view5;
        boolean z6 = z5;
        SpecialEffectsController.Operation operation5 = operation;
        SpecialEffectsController.Operation operation6 = operation2;
        HashMap hashMap3 = new HashMap();
        final FragmentTransitionImpl fragmentTransitionImpl2 = null;
        for (TransitionInfo transitionInfo : list) {
            if (!transitionInfo.isVisibilityUnchanged()) {
                FragmentTransitionImpl handlingImpl = transitionInfo.getHandlingImpl();
                if (fragmentTransitionImpl2 == null) {
                    fragmentTransitionImpl2 = handlingImpl;
                } else if (handlingImpl != null && fragmentTransitionImpl2 != handlingImpl) {
                    throw new IllegalArgumentException("Mixing framework transitions and AndroidX transitions is not allowed. Fragment " + transitionInfo.getOperation().getFragment() + " returned Transition " + transitionInfo.getTransition() + " which uses a different Transition  type than other Fragments.");
                }
            }
        }
        if (fragmentTransitionImpl2 == null) {
            for (TransitionInfo transitionInfo2 : list) {
                hashMap3.put(transitionInfo2.getOperation(), Boolean.FALSE);
                transitionInfo2.completeSpecialEffect();
            }
            return hashMap3;
        }
        View view6 = new View(getContainer().getContext());
        final Rect rect2 = new Rect();
        ArrayList<View> arrayList5 = new ArrayList<>();
        ArrayList<View> arrayList6 = new ArrayList<>();
        ArrayMap arrayMap2 = new ArrayMap();
        Iterator<TransitionInfo> it = list.iterator();
        Object obj3 = null;
        View view7 = null;
        boolean z7 = false;
        while (true) {
            str = "FragmentManager";
            if (!it.hasNext()) {
                break;
            }
            TransitionInfo next = it.next();
            if (!next.hasSharedElementTransition() || operation5 == null || operation6 == null) {
                arrayMap = arrayMap2;
                arrayList3 = arrayList6;
                operation3 = operation5;
                arrayList4 = arrayList5;
                rect = rect2;
                fragmentTransitionImpl = fragmentTransitionImpl2;
                hashMap2 = hashMap3;
                View view8 = view6;
                operation4 = operation6;
                view3 = view8;
                view7 = view7;
            } else {
                Object wrapTransitionInSet = fragmentTransitionImpl2.wrapTransitionInSet(fragmentTransitionImpl2.cloneTransition(next.getSharedElementTransition()));
                ArrayList<String> sharedElementSourceNames = operation2.getFragment().getSharedElementSourceNames();
                ArrayList<String> sharedElementSourceNames2 = operation.getFragment().getSharedElementSourceNames();
                ArrayList<String> sharedElementTargetNames = operation.getFragment().getSharedElementTargetNames();
                View view9 = view7;
                int i5 = 0;
                while (i5 < sharedElementTargetNames.size()) {
                    int indexOf = sharedElementSourceNames.indexOf(sharedElementTargetNames.get(i5));
                    ArrayList<String> arrayList7 = sharedElementTargetNames;
                    if (indexOf != -1) {
                        sharedElementSourceNames.set(indexOf, sharedElementSourceNames2.get(i5));
                    }
                    i5++;
                    sharedElementTargetNames = arrayList7;
                }
                ArrayList<String> sharedElementTargetNames2 = operation2.getFragment().getSharedElementTargetNames();
                if (z6) {
                    operation.getFragment().getEnterTransitionCallback();
                    operation2.getFragment().getExitTransitionCallback();
                } else {
                    operation.getFragment().getExitTransitionCallback();
                    operation2.getFragment().getEnterTransitionCallback();
                }
                int i6 = 0;
                for (int size = sharedElementSourceNames.size(); i6 < size; size = size) {
                    arrayMap2.put(sharedElementSourceNames.get(i6), sharedElementTargetNames2.get(i6));
                    i6++;
                }
                if (FragmentManager.isLoggingEnabled(2)) {
                    Log.v("FragmentManager", ">>> entering view names <<<");
                    for (Iterator<String> it2 = sharedElementTargetNames2.iterator(); it2.hasNext(); it2 = it2) {
                        Log.v("FragmentManager", "Name: " + it2.next());
                    }
                    Log.v("FragmentManager", ">>> exiting view names <<<");
                    for (Iterator<String> it3 = sharedElementSourceNames.iterator(); it3.hasNext(); it3 = it3) {
                        Log.v("FragmentManager", "Name: " + it3.next());
                    }
                }
                ArrayMap<String, View> arrayMap3 = new ArrayMap<>();
                findNamedViews(arrayMap3, operation.getFragment().mView);
                arrayMap3.retainAll(sharedElementSourceNames);
                arrayMap2.retainAll(arrayMap3.keySet());
                final ArrayMap<String, View> arrayMap4 = new ArrayMap<>();
                findNamedViews(arrayMap4, operation2.getFragment().mView);
                arrayMap4.retainAll(sharedElementTargetNames2);
                arrayMap4.retainAll(arrayMap2.values());
                FragmentTransition.retainValues(arrayMap2, arrayMap4);
                retainMatchingViews(arrayMap3, arrayMap2.keySet());
                retainMatchingViews(arrayMap4, arrayMap2.values());
                if (arrayMap2.isEmpty()) {
                    arrayList5.clear();
                    arrayList6.clear();
                    arrayMap = arrayMap2;
                    arrayList3 = arrayList6;
                    operation3 = operation5;
                    arrayList4 = arrayList5;
                    rect = rect2;
                    view3 = view6;
                    fragmentTransitionImpl = fragmentTransitionImpl2;
                    view7 = view9;
                    obj3 = null;
                    operation4 = operation2;
                    hashMap2 = hashMap3;
                } else {
                    FragmentTransition.callSharedElementStartEnd(operation2.getFragment(), operation.getFragment(), z6, arrayMap3, true);
                    HashMap hashMap4 = hashMap3;
                    View view10 = view6;
                    arrayMap = arrayMap2;
                    ArrayList<View> arrayList8 = arrayList6;
                    OneShotPreDrawListener.add(getContainer(), new Runnable() { // from class: androidx.fragment.app.DefaultSpecialEffectsController.6
                        @Override // java.lang.Runnable
                        public void run() {
                            FragmentTransition.callSharedElementStartEnd(operation2.getFragment(), operation.getFragment(), z5, arrayMap4, false);
                        }
                    });
                    arrayList5.addAll(arrayMap3.values());
                    if (sharedElementSourceNames.isEmpty()) {
                        view7 = view9;
                    } else {
                        view7 = arrayMap3.get(sharedElementSourceNames.get(0));
                        fragmentTransitionImpl2.setEpicenter(wrapTransitionInSet, view7);
                    }
                    arrayList3 = arrayList8;
                    arrayList3.addAll(arrayMap4.values());
                    if (sharedElementTargetNames2.isEmpty() || (view5 = arrayMap4.get(sharedElementTargetNames2.get(0))) == null) {
                        view4 = view10;
                    } else {
                        OneShotPreDrawListener.add(getContainer(), new Runnable() { // from class: androidx.fragment.app.DefaultSpecialEffectsController.7
                            @Override // java.lang.Runnable
                            public void run() {
                                fragmentTransitionImpl2.getBoundsOnScreen(view5, rect2);
                            }
                        });
                        view4 = view10;
                        z7 = true;
                    }
                    fragmentTransitionImpl2.setSharedElementTargets(wrapTransitionInSet, view4, arrayList5);
                    arrayList4 = arrayList5;
                    rect = rect2;
                    view3 = view4;
                    fragmentTransitionImpl = fragmentTransitionImpl2;
                    fragmentTransitionImpl2.scheduleRemoveTargets(wrapTransitionInSet, null, null, null, null, wrapTransitionInSet, arrayList3);
                    Boolean bool = Boolean.TRUE;
                    operation3 = operation;
                    hashMap2 = hashMap4;
                    hashMap2.put(operation3, bool);
                    operation4 = operation2;
                    hashMap2.put(operation4, bool);
                    obj3 = wrapTransitionInSet;
                }
            }
            operation5 = operation3;
            arrayList5 = arrayList4;
            rect2 = rect;
            hashMap3 = hashMap2;
            arrayMap2 = arrayMap;
            z6 = z5;
            arrayList6 = arrayList3;
            fragmentTransitionImpl2 = fragmentTransitionImpl;
            SpecialEffectsController.Operation operation7 = operation4;
            view6 = view3;
            operation6 = operation7;
        }
        View view11 = view7;
        ArrayMap arrayMap5 = arrayMap2;
        ArrayList<View> arrayList9 = arrayList6;
        SpecialEffectsController.Operation operation8 = operation5;
        ArrayList<View> arrayList10 = arrayList5;
        Rect rect3 = rect2;
        FragmentTransitionImpl fragmentTransitionImpl3 = fragmentTransitionImpl2;
        HashMap hashMap5 = hashMap3;
        View view12 = view6;
        SpecialEffectsController.Operation operation9 = operation6;
        View view13 = view12;
        ArrayList arrayList11 = new ArrayList();
        Object obj4 = null;
        Object obj5 = null;
        for (TransitionInfo transitionInfo3 : list) {
            if (transitionInfo3.isVisibilityUnchanged()) {
                hashMap5.put(transitionInfo3.getOperation(), Boolean.FALSE);
                transitionInfo3.completeSpecialEffect();
            } else {
                Object cloneTransition = fragmentTransitionImpl3.cloneTransition(transitionInfo3.getTransition());
                SpecialEffectsController.Operation operation10 = transitionInfo3.getOperation();
                boolean z8 = obj3 != null && (operation10 == operation8 || operation10 == operation9);
                if (cloneTransition == null) {
                    if (!z8) {
                        hashMap5.put(operation10, Boolean.FALSE);
                        transitionInfo3.completeSpecialEffect();
                    }
                    arrayList2 = arrayList9;
                    str3 = str;
                    arrayList = arrayList10;
                    view = view13;
                    mergeTransitionsTogether = obj4;
                    hashMap = hashMap5;
                    view2 = view11;
                } else {
                    str3 = str;
                    final ArrayList<View> arrayList12 = new ArrayList<>();
                    Object obj6 = obj4;
                    captureTransitioningViews(arrayList12, operation10.getFragment().mView);
                    if (z8) {
                        if (operation10 == operation8) {
                            arrayList12.removeAll(arrayList10);
                        } else {
                            arrayList12.removeAll(arrayList9);
                        }
                    }
                    if (arrayList12.isEmpty()) {
                        fragmentTransitionImpl3.addTarget(cloneTransition, view13);
                        arrayList2 = arrayList9;
                        arrayList = arrayList10;
                        view = view13;
                        obj2 = obj5;
                        hashMap = hashMap5;
                        obj = obj6;
                    } else {
                        fragmentTransitionImpl3.addTargets(cloneTransition, arrayList12);
                        view = view13;
                        obj = obj6;
                        arrayList = arrayList10;
                        obj2 = obj5;
                        arrayList2 = arrayList9;
                        hashMap = hashMap5;
                        fragmentTransitionImpl3.scheduleRemoveTargets(cloneTransition, cloneTransition, arrayList12, null, null, null, null);
                        if (operation10.getFinalState() == SpecialEffectsController.Operation.State.GONE) {
                            list2.remove(operation10);
                            ArrayList<View> arrayList13 = new ArrayList<>(arrayList12);
                            arrayList13.remove(operation10.getFragment().mView);
                            fragmentTransitionImpl3.scheduleHideFragmentView(cloneTransition, operation10.getFragment().mView, arrayList13);
                            OneShotPreDrawListener.add(getContainer(), new Runnable() { // from class: androidx.fragment.app.DefaultSpecialEffectsController.8
                                @Override // java.lang.Runnable
                                public void run() {
                                    FragmentTransition.setViewVisibility(arrayList12, 4);
                                }
                            });
                        }
                    }
                    if (operation10.getFinalState() == SpecialEffectsController.Operation.State.VISIBLE) {
                        arrayList11.addAll(arrayList12);
                        if (z7) {
                            fragmentTransitionImpl3.setEpicenter(cloneTransition, rect3);
                        }
                        view2 = view11;
                    } else {
                        view2 = view11;
                        fragmentTransitionImpl3.setEpicenter(cloneTransition, view2);
                    }
                    hashMap.put(operation10, Boolean.TRUE);
                    if (transitionInfo3.isOverlapAllowed()) {
                        obj5 = fragmentTransitionImpl3.mergeTransitionsTogether(obj2, cloneTransition, null);
                        mergeTransitionsTogether = obj;
                    } else {
                        mergeTransitionsTogether = fragmentTransitionImpl3.mergeTransitionsTogether(obj, cloneTransition, null);
                        obj5 = obj2;
                    }
                }
                operation9 = operation2;
                hashMap5 = hashMap;
                obj4 = mergeTransitionsTogether;
                view11 = view2;
                str = str3;
                view13 = view;
                arrayList10 = arrayList;
                arrayList9 = arrayList2;
            }
        }
        ArrayList<View> arrayList14 = arrayList9;
        String str4 = str;
        ArrayList<View> arrayList15 = arrayList10;
        HashMap hashMap6 = hashMap5;
        Object mergeTransitionsInSequence = fragmentTransitionImpl3.mergeTransitionsInSequence(obj5, obj4, obj3);
        if (mergeTransitionsInSequence == null) {
            return hashMap6;
        }
        for (final TransitionInfo transitionInfo4 : list) {
            if (!transitionInfo4.isVisibilityUnchanged()) {
                Object transition = transitionInfo4.getTransition();
                final SpecialEffectsController.Operation operation11 = transitionInfo4.getOperation();
                HashMap hashMap7 = hashMap6;
                boolean z9 = obj3 != null && (operation11 == operation8 || operation11 == operation2);
                if (transition == null && !z9) {
                    str2 = str4;
                } else if (ViewCompat.isLaidOut(getContainer())) {
                    str2 = str4;
                    fragmentTransitionImpl3.setListenerForTransitionEnd(transitionInfo4.getOperation().getFragment(), mergeTransitionsInSequence, transitionInfo4.getSignal(), new Runnable() { // from class: androidx.fragment.app.DefaultSpecialEffectsController.9
                        @Override // java.lang.Runnable
                        public void run() {
                            transitionInfo4.completeSpecialEffect();
                            if (FragmentManager.isLoggingEnabled(2)) {
                                Log.v("FragmentManager", "Transition for operation " + operation11 + "has completed");
                            }
                        }
                    });
                } else {
                    if (FragmentManager.isLoggingEnabled(2)) {
                        str2 = str4;
                        Log.v(str2, "SpecialEffectsController: Container " + getContainer() + " has not been laid out. Completing operation " + operation11);
                    } else {
                        str2 = str4;
                    }
                    transitionInfo4.completeSpecialEffect();
                }
                hashMap6 = hashMap7;
                str4 = str2;
            }
        }
        HashMap hashMap8 = hashMap6;
        String str5 = str4;
        if (!ViewCompat.isLaidOut(getContainer())) {
            return hashMap8;
        }
        FragmentTransition.setViewVisibility(arrayList11, 4);
        ArrayList<String> prepareSetNameOverridesReordered = fragmentTransitionImpl3.prepareSetNameOverridesReordered(arrayList14);
        if (FragmentManager.isLoggingEnabled(2)) {
            Log.v(str5, ">>>>> Beginning transition <<<<<");
            Log.v(str5, ">>>>> SharedElementFirstOutViews <<<<<");
            Iterator<View> it4 = arrayList15.iterator();
            while (it4.hasNext()) {
                View next2 = it4.next();
                Log.v(str5, "View: " + next2 + " Name: " + ViewCompat.getTransitionName(next2));
            }
            Log.v(str5, ">>>>> SharedElementLastInViews <<<<<");
            Iterator<View> it5 = arrayList14.iterator();
            while (it5.hasNext()) {
                View next3 = it5.next();
                Log.v(str5, "View: " + next3 + " Name: " + ViewCompat.getTransitionName(next3));
            }
        }
        fragmentTransitionImpl3.beginDelayedTransition(getContainer(), mergeTransitionsInSequence);
        fragmentTransitionImpl3.setNameOverridesReordered(getContainer(), arrayList15, arrayList14, prepareSetNameOverridesReordered, arrayMap5);
        FragmentTransition.setViewVisibility(arrayList11, 0);
        fragmentTransitionImpl3.swapSharedElementTargets(obj3, arrayList15, arrayList14);
        return hashMap8;
    }

    private void syncAnimations(List<SpecialEffectsController.Operation> list) {
        Fragment fragment = list.get(list.size() - 1).getFragment();
        for (SpecialEffectsController.Operation operation : list) {
            operation.getFragment().mAnimationInfo.mEnterAnim = fragment.mAnimationInfo.mEnterAnim;
            operation.getFragment().mAnimationInfo.mExitAnim = fragment.mAnimationInfo.mExitAnim;
            operation.getFragment().mAnimationInfo.mPopEnterAnim = fragment.mAnimationInfo.mPopEnterAnim;
            operation.getFragment().mAnimationInfo.mPopExitAnim = fragment.mAnimationInfo.mPopExitAnim;
        }
    }

    void applyContainerChanges(SpecialEffectsController.Operation operation) {
        operation.getFinalState().applyState(operation.getFragment().mView);
    }

    void captureTransitioningViews(ArrayList<View> arrayList, View view) {
        if (!(view instanceof ViewGroup)) {
            if (arrayList.contains(view)) {
                return;
            }
            arrayList.add(view);
            return;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        if (ViewGroupCompat.isTransitionGroup(viewGroup)) {
            if (arrayList.contains(view)) {
                return;
            }
            arrayList.add(viewGroup);
            return;
        }
        int childCount = viewGroup.getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = viewGroup.getChildAt(i5);
            if (childAt.getVisibility() == 0) {
                captureTransitioningViews(arrayList, childAt);
            }
        }
    }

    @Override // androidx.fragment.app.SpecialEffectsController
    void executeOperations(List<SpecialEffectsController.Operation> list, boolean z5) {
        SpecialEffectsController.Operation operation = null;
        SpecialEffectsController.Operation operation2 = null;
        for (SpecialEffectsController.Operation operation3 : list) {
            SpecialEffectsController.Operation.State from = SpecialEffectsController.Operation.State.from(operation3.getFragment().mView);
            int i5 = AnonymousClass10.$SwitchMap$androidx$fragment$app$SpecialEffectsController$Operation$State[operation3.getFinalState().ordinal()];
            if (i5 == 1 || i5 == 2 || i5 == 3) {
                if (from == SpecialEffectsController.Operation.State.VISIBLE && operation == null) {
                    operation = operation3;
                }
            } else if (i5 == 4 && from != SpecialEffectsController.Operation.State.VISIBLE) {
                operation2 = operation3;
            }
        }
        if (FragmentManager.isLoggingEnabled(2)) {
            Log.v("FragmentManager", "Executing operations from " + operation + " to " + operation2);
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        final ArrayList arrayList3 = new ArrayList(list);
        syncAnimations(list);
        for (final SpecialEffectsController.Operation operation4 : list) {
            CancellationSignal cancellationSignal = new CancellationSignal();
            operation4.markStartedSpecialEffect(cancellationSignal);
            arrayList.add(new AnimationInfo(operation4, cancellationSignal, z5));
            CancellationSignal cancellationSignal2 = new CancellationSignal();
            operation4.markStartedSpecialEffect(cancellationSignal2);
            boolean z6 = false;
            if (z5) {
                if (operation4 != operation) {
                    arrayList2.add(new TransitionInfo(operation4, cancellationSignal2, z5, z6));
                    operation4.addCompletionListener(new Runnable() { // from class: androidx.fragment.app.DefaultSpecialEffectsController.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (arrayList3.contains(operation4)) {
                                arrayList3.remove(operation4);
                                DefaultSpecialEffectsController.this.applyContainerChanges(operation4);
                            }
                        }
                    });
                }
                z6 = true;
                arrayList2.add(new TransitionInfo(operation4, cancellationSignal2, z5, z6));
                operation4.addCompletionListener(new Runnable() { // from class: androidx.fragment.app.DefaultSpecialEffectsController.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (arrayList3.contains(operation4)) {
                            arrayList3.remove(operation4);
                            DefaultSpecialEffectsController.this.applyContainerChanges(operation4);
                        }
                    }
                });
            } else {
                if (operation4 != operation2) {
                    arrayList2.add(new TransitionInfo(operation4, cancellationSignal2, z5, z6));
                    operation4.addCompletionListener(new Runnable() { // from class: androidx.fragment.app.DefaultSpecialEffectsController.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (arrayList3.contains(operation4)) {
                                arrayList3.remove(operation4);
                                DefaultSpecialEffectsController.this.applyContainerChanges(operation4);
                            }
                        }
                    });
                }
                z6 = true;
                arrayList2.add(new TransitionInfo(operation4, cancellationSignal2, z5, z6));
                operation4.addCompletionListener(new Runnable() { // from class: androidx.fragment.app.DefaultSpecialEffectsController.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (arrayList3.contains(operation4)) {
                            arrayList3.remove(operation4);
                            DefaultSpecialEffectsController.this.applyContainerChanges(operation4);
                        }
                    }
                });
            }
        }
        Map<SpecialEffectsController.Operation, Boolean> startTransitions = startTransitions(arrayList2, arrayList3, z5, operation, operation2);
        startAnimations(arrayList, arrayList3, startTransitions.containsValue(Boolean.TRUE), startTransitions);
        Iterator<SpecialEffectsController.Operation> it = arrayList3.iterator();
        while (it.hasNext()) {
            applyContainerChanges(it.next());
        }
        arrayList3.clear();
        if (FragmentManager.isLoggingEnabled(2)) {
            Log.v("FragmentManager", "Completed executing operations from " + operation + " to " + operation2);
        }
    }

    void findNamedViews(Map<String, View> map, View view) {
        String transitionName = ViewCompat.getTransitionName(view);
        if (transitionName != null) {
            map.put(transitionName, view);
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i5 = 0; i5 < childCount; i5++) {
                View childAt = viewGroup.getChildAt(i5);
                if (childAt.getVisibility() == 0) {
                    findNamedViews(map, childAt);
                }
            }
        }
    }

    void retainMatchingViews(ArrayMap<String, View> arrayMap, Collection<String> collection) {
        Iterator<Map.Entry<String, View>> it = arrayMap.entrySet().iterator();
        while (it.hasNext()) {
            if (!collection.contains(ViewCompat.getTransitionName(it.next().getValue()))) {
                it.remove();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class TransitionInfo extends SpecialEffectsInfo {
        private final boolean mOverlapAllowed;
        private final Object mSharedElementTransition;
        private final Object mTransition;

        TransitionInfo(SpecialEffectsController.Operation operation, CancellationSignal cancellationSignal, boolean z5, boolean z6) {
            super(operation, cancellationSignal);
            if (operation.getFinalState() == SpecialEffectsController.Operation.State.VISIBLE) {
                this.mTransition = z5 ? operation.getFragment().getReenterTransition() : operation.getFragment().getEnterTransition();
                this.mOverlapAllowed = z5 ? operation.getFragment().getAllowReturnTransitionOverlap() : operation.getFragment().getAllowEnterTransitionOverlap();
            } else {
                this.mTransition = z5 ? operation.getFragment().getReturnTransition() : operation.getFragment().getExitTransition();
                this.mOverlapAllowed = true;
            }
            if (!z6) {
                this.mSharedElementTransition = null;
            } else if (z5) {
                this.mSharedElementTransition = operation.getFragment().getSharedElementReturnTransition();
            } else {
                this.mSharedElementTransition = operation.getFragment().getSharedElementEnterTransition();
            }
        }

        FragmentTransitionImpl getHandlingImpl() {
            FragmentTransitionImpl handlingImpl = getHandlingImpl(this.mTransition);
            FragmentTransitionImpl handlingImpl2 = getHandlingImpl(this.mSharedElementTransition);
            if (handlingImpl == null || handlingImpl2 == null || handlingImpl == handlingImpl2) {
                return handlingImpl != null ? handlingImpl : handlingImpl2;
            }
            throw new IllegalArgumentException("Mixing framework transitions and AndroidX transitions is not allowed. Fragment " + getOperation().getFragment() + " returned Transition " + this.mTransition + " which uses a different Transition  type than its shared element transition " + this.mSharedElementTransition);
        }

        public Object getSharedElementTransition() {
            return this.mSharedElementTransition;
        }

        Object getTransition() {
            return this.mTransition;
        }

        public boolean hasSharedElementTransition() {
            return this.mSharedElementTransition != null;
        }

        boolean isOverlapAllowed() {
            return this.mOverlapAllowed;
        }

        private FragmentTransitionImpl getHandlingImpl(Object obj) {
            if (obj == null) {
                return null;
            }
            FragmentTransitionImpl fragmentTransitionImpl = FragmentTransition.PLATFORM_IMPL;
            if (fragmentTransitionImpl != null && fragmentTransitionImpl.canHandle(obj)) {
                return fragmentTransitionImpl;
            }
            FragmentTransitionImpl fragmentTransitionImpl2 = FragmentTransition.SUPPORT_IMPL;
            if (fragmentTransitionImpl2 != null && fragmentTransitionImpl2.canHandle(obj)) {
                return fragmentTransitionImpl2;
            }
            throw new IllegalArgumentException("Transition " + obj + " for fragment " + getOperation().getFragment() + " is not a valid framework Transition or AndroidX Transition");
        }
    }
}
