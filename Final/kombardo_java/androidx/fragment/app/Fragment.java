package androidx.fragment.app;

import android.animation.Animator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import androidx.arch.core.util.Function;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.app.SharedElementCallback;
import androidx.core.view.LayoutInflaterCompat;
import androidx.fragment.app.strictmode.FragmentStrictMode;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.SavedStateHandleSupport;
import androidx.lifecycle.SavedStateViewModelFactory;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import androidx.lifecycle.ViewTreeViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.MutableCreationExtras;
import androidx.loader.app.LoaderManager;
import androidx.savedstate.SavedStateRegistry;
import androidx.savedstate.SavedStateRegistryController;
import androidx.savedstate.SavedStateRegistryOwner;
import androidx.savedstate.ViewTreeSavedStateRegistryOwner;
import androidx.view.result.ActivityResultCallback;
import androidx.view.result.ActivityResultLauncher;
import androidx.view.result.ActivityResultRegistry;
import androidx.view.result.ActivityResultRegistryOwner;
import androidx.view.result.contract.ActivityResultContract;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public abstract class Fragment implements ComponentCallbacks, View.OnCreateContextMenuListener, LifecycleOwner, ViewModelStoreOwner, HasDefaultViewModelProviderFactory, SavedStateRegistryOwner {
    static final Object USE_DEFAULT_TRANSITION = new Object();
    boolean mAdded;
    AnimationInfo mAnimationInfo;
    Bundle mArguments;
    int mBackStackNesting;
    boolean mBeingSaved;
    private boolean mCalled;
    ViewGroup mContainer;
    int mContainerId;
    private int mContentLayoutId;
    ViewModelProvider.Factory mDefaultFactory;
    boolean mDeferStart;
    boolean mDetached;
    int mFragmentId;
    FragmentManager mFragmentManager;
    boolean mFromLayout;
    boolean mHasMenu;
    boolean mHidden;
    boolean mHiddenChanged;
    FragmentHostCallback<?> mHost;
    boolean mInLayout;
    boolean mIsCreated;
    LayoutInflater mLayoutInflater;
    LifecycleRegistry mLifecycleRegistry;
    Fragment mParentFragment;
    boolean mPerformedCreateView;
    public String mPreviousWho;
    boolean mRemoving;
    boolean mRestored;
    boolean mRetainInstance;
    boolean mRetainInstanceChangedWhileDetached;
    Bundle mSavedFragmentState;
    SavedStateRegistryController mSavedStateRegistryController;
    Boolean mSavedUserVisibleHint;
    Bundle mSavedViewRegistryState;
    SparseArray<Parcelable> mSavedViewState;
    String mTag;
    Fragment mTarget;
    int mTargetRequestCode;
    View mView;
    FragmentViewLifecycleOwner mViewLifecycleOwner;
    int mState = -1;
    String mWho = UUID.randomUUID().toString();
    String mTargetWho = null;
    private Boolean mIsPrimaryNavigationFragment = null;
    FragmentManager mChildFragmentManager = new FragmentManagerImpl();
    boolean mMenuVisible = true;
    boolean mUserVisibleHint = true;
    Runnable mPostponedDurationRunnable = new Runnable() { // from class: androidx.fragment.app.Fragment.1
        @Override // java.lang.Runnable
        public void run() {
            Fragment.this.startPostponedEnterTransition();
        }
    };
    Lifecycle.State mMaxState = Lifecycle.State.RESUMED;
    MutableLiveData<LifecycleOwner> mViewLifecycleOwnerLiveData = new MutableLiveData<>();
    private final AtomicInteger mNextLocalRequestCode = new AtomicInteger();
    private final ArrayList<OnPreAttachedListener> mOnPreAttachedListeners = new ArrayList<>();
    private final OnPreAttachedListener mSavedStateAttachListener = new OnPreAttachedListener() { // from class: androidx.fragment.app.Fragment.2
        @Override // androidx.fragment.app.Fragment.OnPreAttachedListener
        void onPreAttached() {
            Fragment.this.mSavedStateRegistryController.performAttach();
            SavedStateHandleSupport.enableSavedStateHandles(Fragment.this);
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class AnimationInfo {
        Boolean mAllowEnterTransitionOverlap;
        Boolean mAllowReturnTransitionOverlap;
        View mAnimatingAway;
        int mEnterAnim;
        Object mEnterTransition = null;
        boolean mEnterTransitionPostponed;
        int mExitAnim;
        Object mExitTransition;
        View mFocusedView;
        boolean mIsPop;
        int mNextTransition;
        int mPopEnterAnim;
        int mPopExitAnim;
        float mPostOnViewCreatedAlpha;
        Object mReenterTransition;
        Object mReturnTransition;
        Object mSharedElementEnterTransition;
        Object mSharedElementReturnTransition;
        ArrayList<String> mSharedElementSourceNames;
        ArrayList<String> mSharedElementTargetNames;

        AnimationInfo() {
            Object obj = Fragment.USE_DEFAULT_TRANSITION;
            this.mReturnTransition = obj;
            this.mExitTransition = null;
            this.mReenterTransition = obj;
            this.mSharedElementEnterTransition = null;
            this.mSharedElementReturnTransition = obj;
            this.mPostOnViewCreatedAlpha = 1.0f;
            this.mFocusedView = null;
        }
    }

    /* loaded from: classes.dex */
    static class Api19Impl {
        static void cancelPendingInputEvents(View view) {
            view.cancelPendingInputEvents();
        }
    }

    /* loaded from: classes.dex */
    public static class InstantiationException extends RuntimeException {
        public InstantiationException(String str, Exception exc) {
            super(str, exc);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static abstract class OnPreAttachedListener {
        private OnPreAttachedListener() {
        }

        abstract void onPreAttached();
    }

    public Fragment() {
        initLifecycle();
    }

    private AnimationInfo ensureAnimationInfo() {
        if (this.mAnimationInfo == null) {
            this.mAnimationInfo = new AnimationInfo();
        }
        return this.mAnimationInfo;
    }

    private int getMinimumMaxLifecycleState() {
        Lifecycle.State state = this.mMaxState;
        return (state == Lifecycle.State.INITIALIZED || this.mParentFragment == null) ? state.ordinal() : Math.min(state.ordinal(), this.mParentFragment.getMinimumMaxLifecycleState());
    }

    private Fragment getTargetFragment(boolean z5) {
        String str;
        if (z5) {
            FragmentStrictMode.onGetTargetFragmentUsage(this);
        }
        Fragment fragment = this.mTarget;
        if (fragment != null) {
            return fragment;
        }
        FragmentManager fragmentManager = this.mFragmentManager;
        if (fragmentManager == null || (str = this.mTargetWho) == null) {
            return null;
        }
        return fragmentManager.findActiveFragment(str);
    }

    private void initLifecycle() {
        this.mLifecycleRegistry = new LifecycleRegistry(this);
        this.mSavedStateRegistryController = SavedStateRegistryController.create(this);
        this.mDefaultFactory = null;
        if (this.mOnPreAttachedListeners.contains(this.mSavedStateAttachListener)) {
            return;
        }
        registerOnPreAttachListener(this.mSavedStateAttachListener);
    }

    @Deprecated
    public static Fragment instantiate(Context context, String str, Bundle bundle) {
        try {
            Fragment newInstance = FragmentFactory.loadFragmentClass(context.getClassLoader(), str).getConstructor(null).newInstance(null);
            if (bundle != null) {
                bundle.setClassLoader(newInstance.getClass().getClassLoader());
                newInstance.setArguments(bundle);
            }
            return newInstance;
        } catch (IllegalAccessException e5) {
            throw new InstantiationException("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an empty constructor that is public", e5);
        } catch (java.lang.InstantiationException e6) {
            throw new InstantiationException("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an empty constructor that is public", e6);
        } catch (NoSuchMethodException e7) {
            throw new InstantiationException("Unable to instantiate fragment " + str + ": could not find Fragment constructor", e7);
        } catch (InvocationTargetException e8) {
            throw new InstantiationException("Unable to instantiate fragment " + str + ": calling Fragment constructor caused an exception", e8);
        }
    }

    private <I, O> ActivityResultLauncher<I> prepareCallInternal(final ActivityResultContract<I, O> activityResultContract, final Function<Void, ActivityResultRegistry> function, final ActivityResultCallback<O> activityResultCallback) {
        if (this.mState <= 1) {
            final AtomicReference atomicReference = new AtomicReference();
            registerOnPreAttachListener(new OnPreAttachedListener() { // from class: androidx.fragment.app.Fragment.9
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super();
                }

                @Override // androidx.fragment.app.Fragment.OnPreAttachedListener
                void onPreAttached() {
                    String generateActivityResultKey = Fragment.this.generateActivityResultKey();
                    atomicReference.set(((ActivityResultRegistry) function.apply(null)).register(generateActivityResultKey, Fragment.this, activityResultContract, activityResultCallback));
                }
            });
            return new ActivityResultLauncher<I>() { // from class: androidx.fragment.app.Fragment.10
                @Override // androidx.view.result.ActivityResultLauncher
                public void launch(I i5, ActivityOptionsCompat activityOptionsCompat) {
                    ActivityResultLauncher activityResultLauncher = (ActivityResultLauncher) atomicReference.get();
                    if (activityResultLauncher == null) {
                        throw new IllegalStateException("Operation cannot be started before fragment is in created state");
                    }
                    activityResultLauncher.launch(i5, activityOptionsCompat);
                }

                @Override // androidx.view.result.ActivityResultLauncher
                public void unregister() {
                    ActivityResultLauncher activityResultLauncher = (ActivityResultLauncher) atomicReference.getAndSet(null);
                    if (activityResultLauncher != null) {
                        activityResultLauncher.unregister();
                    }
                }
            };
        }
        throw new IllegalStateException("Fragment " + this + " is attempting to registerForActivityResult after being created. Fragments must call registerForActivityResult() before they are created (i.e. initialization, onAttach(), or onCreate()).");
    }

    private void registerOnPreAttachListener(OnPreAttachedListener onPreAttachedListener) {
        if (this.mState >= 0) {
            onPreAttachedListener.onPreAttached();
        } else {
            this.mOnPreAttachedListeners.add(onPreAttachedListener);
        }
    }

    void callStartTransitionListener(boolean z5) {
        ViewGroup viewGroup;
        FragmentManager fragmentManager;
        AnimationInfo animationInfo = this.mAnimationInfo;
        if (animationInfo != null) {
            animationInfo.mEnterTransitionPostponed = false;
        }
        if (this.mView == null || (viewGroup = this.mContainer) == null || (fragmentManager = this.mFragmentManager) == null) {
            return;
        }
        final SpecialEffectsController orCreateController = SpecialEffectsController.getOrCreateController(viewGroup, fragmentManager);
        orCreateController.markPostponedState();
        if (z5) {
            this.mHost.getHandler().post(new Runnable() { // from class: androidx.fragment.app.Fragment.4
                @Override // java.lang.Runnable
                public void run() {
                    orCreateController.executePendingOperations();
                }
            });
        } else {
            orCreateController.executePendingOperations();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public FragmentContainer createFragmentContainer() {
        return new FragmentContainer() { // from class: androidx.fragment.app.Fragment.5
            @Override // androidx.fragment.app.FragmentContainer
            public View onFindViewById(int i5) {
                View view = Fragment.this.mView;
                if (view != null) {
                    return view.findViewById(i5);
                }
                throw new IllegalStateException("Fragment " + Fragment.this + " does not have a view");
            }

            @Override // androidx.fragment.app.FragmentContainer
            public boolean onHasView() {
                return Fragment.this.mView != null;
            }
        };
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.print(str);
        printWriter.print("mFragmentId=#");
        printWriter.print(Integer.toHexString(this.mFragmentId));
        printWriter.print(" mContainerId=#");
        printWriter.print(Integer.toHexString(this.mContainerId));
        printWriter.print(" mTag=");
        printWriter.println(this.mTag);
        printWriter.print(str);
        printWriter.print("mState=");
        printWriter.print(this.mState);
        printWriter.print(" mWho=");
        printWriter.print(this.mWho);
        printWriter.print(" mBackStackNesting=");
        printWriter.println(this.mBackStackNesting);
        printWriter.print(str);
        printWriter.print("mAdded=");
        printWriter.print(this.mAdded);
        printWriter.print(" mRemoving=");
        printWriter.print(this.mRemoving);
        printWriter.print(" mFromLayout=");
        printWriter.print(this.mFromLayout);
        printWriter.print(" mInLayout=");
        printWriter.println(this.mInLayout);
        printWriter.print(str);
        printWriter.print("mHidden=");
        printWriter.print(this.mHidden);
        printWriter.print(" mDetached=");
        printWriter.print(this.mDetached);
        printWriter.print(" mMenuVisible=");
        printWriter.print(this.mMenuVisible);
        printWriter.print(" mHasMenu=");
        printWriter.println(this.mHasMenu);
        printWriter.print(str);
        printWriter.print("mRetainInstance=");
        printWriter.print(this.mRetainInstance);
        printWriter.print(" mUserVisibleHint=");
        printWriter.println(this.mUserVisibleHint);
        if (this.mFragmentManager != null) {
            printWriter.print(str);
            printWriter.print("mFragmentManager=");
            printWriter.println(this.mFragmentManager);
        }
        if (this.mHost != null) {
            printWriter.print(str);
            printWriter.print("mHost=");
            printWriter.println(this.mHost);
        }
        if (this.mParentFragment != null) {
            printWriter.print(str);
            printWriter.print("mParentFragment=");
            printWriter.println(this.mParentFragment);
        }
        if (this.mArguments != null) {
            printWriter.print(str);
            printWriter.print("mArguments=");
            printWriter.println(this.mArguments);
        }
        if (this.mSavedFragmentState != null) {
            printWriter.print(str);
            printWriter.print("mSavedFragmentState=");
            printWriter.println(this.mSavedFragmentState);
        }
        if (this.mSavedViewState != null) {
            printWriter.print(str);
            printWriter.print("mSavedViewState=");
            printWriter.println(this.mSavedViewState);
        }
        if (this.mSavedViewRegistryState != null) {
            printWriter.print(str);
            printWriter.print("mSavedViewRegistryState=");
            printWriter.println(this.mSavedViewRegistryState);
        }
        Fragment targetFragment = getTargetFragment(false);
        if (targetFragment != null) {
            printWriter.print(str);
            printWriter.print("mTarget=");
            printWriter.print(targetFragment);
            printWriter.print(" mTargetRequestCode=");
            printWriter.println(this.mTargetRequestCode);
        }
        printWriter.print(str);
        printWriter.print("mPopDirection=");
        printWriter.println(getPopDirection());
        if (getEnterAnim() != 0) {
            printWriter.print(str);
            printWriter.print("getEnterAnim=");
            printWriter.println(getEnterAnim());
        }
        if (getExitAnim() != 0) {
            printWriter.print(str);
            printWriter.print("getExitAnim=");
            printWriter.println(getExitAnim());
        }
        if (getPopEnterAnim() != 0) {
            printWriter.print(str);
            printWriter.print("getPopEnterAnim=");
            printWriter.println(getPopEnterAnim());
        }
        if (getPopExitAnim() != 0) {
            printWriter.print(str);
            printWriter.print("getPopExitAnim=");
            printWriter.println(getPopExitAnim());
        }
        if (this.mContainer != null) {
            printWriter.print(str);
            printWriter.print("mContainer=");
            printWriter.println(this.mContainer);
        }
        if (this.mView != null) {
            printWriter.print(str);
            printWriter.print("mView=");
            printWriter.println(this.mView);
        }
        if (getAnimatingAway() != null) {
            printWriter.print(str);
            printWriter.print("mAnimatingAway=");
            printWriter.println(getAnimatingAway());
        }
        if (getContext() != null) {
            LoaderManager.getInstance(this).dump(str, fileDescriptor, printWriter, strArr);
        }
        printWriter.print(str);
        printWriter.println("Child " + this.mChildFragmentManager + ":");
        this.mChildFragmentManager.dump(str + "  ", fileDescriptor, printWriter, strArr);
    }

    public final boolean equals(Object obj) {
        return super.equals(obj);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Fragment findFragmentByWho(String str) {
        return str.equals(this.mWho) ? this : this.mChildFragmentManager.findFragmentByWho(str);
    }

    String generateActivityResultKey() {
        return "fragment_" + this.mWho + "_rq#" + this.mNextLocalRequestCode.getAndIncrement();
    }

    public final FragmentActivity getActivity() {
        FragmentHostCallback<?> fragmentHostCallback = this.mHost;
        if (fragmentHostCallback == null) {
            return null;
        }
        return (FragmentActivity) fragmentHostCallback.getActivity();
    }

    public boolean getAllowEnterTransitionOverlap() {
        Boolean bool;
        AnimationInfo animationInfo = this.mAnimationInfo;
        if (animationInfo == null || (bool = animationInfo.mAllowEnterTransitionOverlap) == null) {
            return true;
        }
        return bool.booleanValue();
    }

    public boolean getAllowReturnTransitionOverlap() {
        Boolean bool;
        AnimationInfo animationInfo = this.mAnimationInfo;
        if (animationInfo == null || (bool = animationInfo.mAllowReturnTransitionOverlap) == null) {
            return true;
        }
        return bool.booleanValue();
    }

    View getAnimatingAway() {
        AnimationInfo animationInfo = this.mAnimationInfo;
        if (animationInfo == null) {
            return null;
        }
        return animationInfo.mAnimatingAway;
    }

    public final Bundle getArguments() {
        return this.mArguments;
    }

    public final FragmentManager getChildFragmentManager() {
        if (this.mHost != null) {
            return this.mChildFragmentManager;
        }
        throw new IllegalStateException("Fragment " + this + " has not been attached yet.");
    }

    public Context getContext() {
        FragmentHostCallback<?> fragmentHostCallback = this.mHost;
        if (fragmentHostCallback == null) {
            return null;
        }
        return fragmentHostCallback.getContext();
    }

    @Override // androidx.lifecycle.HasDefaultViewModelProviderFactory
    public CreationExtras getDefaultViewModelCreationExtras() {
        Application application;
        Context applicationContext = requireContext().getApplicationContext();
        while (true) {
            if (!(applicationContext instanceof ContextWrapper)) {
                application = null;
                break;
            }
            if (applicationContext instanceof Application) {
                application = (Application) applicationContext;
                break;
            }
            applicationContext = ((ContextWrapper) applicationContext).getBaseContext();
        }
        if (application == null && FragmentManager.isLoggingEnabled(3)) {
            Log.d("FragmentManager", "Could not find Application instance from Context " + requireContext().getApplicationContext() + ", you will not be able to use AndroidViewModel with the default ViewModelProvider.Factory");
        }
        MutableCreationExtras mutableCreationExtras = new MutableCreationExtras();
        if (application != null) {
            mutableCreationExtras.set(ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY, application);
        }
        mutableCreationExtras.set(SavedStateHandleSupport.SAVED_STATE_REGISTRY_OWNER_KEY, this);
        mutableCreationExtras.set(SavedStateHandleSupport.VIEW_MODEL_STORE_OWNER_KEY, this);
        if (getArguments() != null) {
            mutableCreationExtras.set(SavedStateHandleSupport.DEFAULT_ARGS_KEY, getArguments());
        }
        return mutableCreationExtras;
    }

    @Override // androidx.lifecycle.HasDefaultViewModelProviderFactory
    public ViewModelProvider.Factory getDefaultViewModelProviderFactory() {
        Application application;
        if (this.mFragmentManager == null) {
            throw new IllegalStateException("Can't access ViewModels from detached fragment");
        }
        if (this.mDefaultFactory == null) {
            Context applicationContext = requireContext().getApplicationContext();
            while (true) {
                if (!(applicationContext instanceof ContextWrapper)) {
                    application = null;
                    break;
                }
                if (applicationContext instanceof Application) {
                    application = (Application) applicationContext;
                    break;
                }
                applicationContext = ((ContextWrapper) applicationContext).getBaseContext();
            }
            if (application == null && FragmentManager.isLoggingEnabled(3)) {
                Log.d("FragmentManager", "Could not find Application instance from Context " + requireContext().getApplicationContext() + ", you will need CreationExtras to use AndroidViewModel with the default ViewModelProvider.Factory");
            }
            this.mDefaultFactory = new SavedStateViewModelFactory(application, this, getArguments());
        }
        return this.mDefaultFactory;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getEnterAnim() {
        AnimationInfo animationInfo = this.mAnimationInfo;
        if (animationInfo == null) {
            return 0;
        }
        return animationInfo.mEnterAnim;
    }

    public Object getEnterTransition() {
        AnimationInfo animationInfo = this.mAnimationInfo;
        if (animationInfo == null) {
            return null;
        }
        return animationInfo.mEnterTransition;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SharedElementCallback getEnterTransitionCallback() {
        AnimationInfo animationInfo = this.mAnimationInfo;
        if (animationInfo == null) {
            return null;
        }
        animationInfo.getClass();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getExitAnim() {
        AnimationInfo animationInfo = this.mAnimationInfo;
        if (animationInfo == null) {
            return 0;
        }
        return animationInfo.mExitAnim;
    }

    public Object getExitTransition() {
        AnimationInfo animationInfo = this.mAnimationInfo;
        if (animationInfo == null) {
            return null;
        }
        return animationInfo.mExitTransition;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SharedElementCallback getExitTransitionCallback() {
        AnimationInfo animationInfo = this.mAnimationInfo;
        if (animationInfo == null) {
            return null;
        }
        animationInfo.getClass();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View getFocusedView() {
        AnimationInfo animationInfo = this.mAnimationInfo;
        if (animationInfo == null) {
            return null;
        }
        return animationInfo.mFocusedView;
    }

    public final Object getHost() {
        FragmentHostCallback<?> fragmentHostCallback = this.mHost;
        if (fragmentHostCallback == null) {
            return null;
        }
        return fragmentHostCallback.onGetHost();
    }

    public final LayoutInflater getLayoutInflater() {
        LayoutInflater layoutInflater = this.mLayoutInflater;
        return layoutInflater == null ? performGetLayoutInflater(null) : layoutInflater;
    }

    @Override // androidx.lifecycle.LifecycleOwner
    public Lifecycle getLifecycle() {
        return this.mLifecycleRegistry;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getNextTransition() {
        AnimationInfo animationInfo = this.mAnimationInfo;
        if (animationInfo == null) {
            return 0;
        }
        return animationInfo.mNextTransition;
    }

    public final Fragment getParentFragment() {
        return this.mParentFragment;
    }

    public final FragmentManager getParentFragmentManager() {
        FragmentManager fragmentManager = this.mFragmentManager;
        if (fragmentManager != null) {
            return fragmentManager;
        }
        throw new IllegalStateException("Fragment " + this + " not associated with a fragment manager.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean getPopDirection() {
        AnimationInfo animationInfo = this.mAnimationInfo;
        if (animationInfo == null) {
            return false;
        }
        return animationInfo.mIsPop;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getPopEnterAnim() {
        AnimationInfo animationInfo = this.mAnimationInfo;
        if (animationInfo == null) {
            return 0;
        }
        return animationInfo.mPopEnterAnim;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getPopExitAnim() {
        AnimationInfo animationInfo = this.mAnimationInfo;
        if (animationInfo == null) {
            return 0;
        }
        return animationInfo.mPopExitAnim;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float getPostOnViewCreatedAlpha() {
        AnimationInfo animationInfo = this.mAnimationInfo;
        if (animationInfo == null) {
            return 1.0f;
        }
        return animationInfo.mPostOnViewCreatedAlpha;
    }

    public Object getReenterTransition() {
        AnimationInfo animationInfo = this.mAnimationInfo;
        if (animationInfo == null) {
            return null;
        }
        Object obj = animationInfo.mReenterTransition;
        return obj == USE_DEFAULT_TRANSITION ? getExitTransition() : obj;
    }

    public final Resources getResources() {
        return requireContext().getResources();
    }

    @Deprecated
    public final boolean getRetainInstance() {
        FragmentStrictMode.onGetRetainInstanceUsage(this);
        return this.mRetainInstance;
    }

    public Object getReturnTransition() {
        AnimationInfo animationInfo = this.mAnimationInfo;
        if (animationInfo == null) {
            return null;
        }
        Object obj = animationInfo.mReturnTransition;
        return obj == USE_DEFAULT_TRANSITION ? getEnterTransition() : obj;
    }

    @Override // androidx.savedstate.SavedStateRegistryOwner
    public final SavedStateRegistry getSavedStateRegistry() {
        return this.mSavedStateRegistryController.getSavedStateRegistry();
    }

    public Object getSharedElementEnterTransition() {
        AnimationInfo animationInfo = this.mAnimationInfo;
        if (animationInfo == null) {
            return null;
        }
        return animationInfo.mSharedElementEnterTransition;
    }

    public Object getSharedElementReturnTransition() {
        AnimationInfo animationInfo = this.mAnimationInfo;
        if (animationInfo == null) {
            return null;
        }
        Object obj = animationInfo.mSharedElementReturnTransition;
        return obj == USE_DEFAULT_TRANSITION ? getSharedElementEnterTransition() : obj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ArrayList<String> getSharedElementSourceNames() {
        ArrayList<String> arrayList;
        AnimationInfo animationInfo = this.mAnimationInfo;
        return (animationInfo == null || (arrayList = animationInfo.mSharedElementSourceNames) == null) ? new ArrayList<>() : arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ArrayList<String> getSharedElementTargetNames() {
        ArrayList<String> arrayList;
        AnimationInfo animationInfo = this.mAnimationInfo;
        return (animationInfo == null || (arrayList = animationInfo.mSharedElementTargetNames) == null) ? new ArrayList<>() : arrayList;
    }

    public final String getString(int i5) {
        return getResources().getString(i5);
    }

    public View getView() {
        return this.mView;
    }

    public LiveData<LifecycleOwner> getViewLifecycleOwnerLiveData() {
        return this.mViewLifecycleOwnerLiveData;
    }

    @Override // androidx.lifecycle.ViewModelStoreOwner
    public ViewModelStore getViewModelStore() {
        if (this.mFragmentManager == null) {
            throw new IllegalStateException("Can't access ViewModels from detached fragment");
        }
        if (getMinimumMaxLifecycleState() != Lifecycle.State.INITIALIZED.ordinal()) {
            return this.mFragmentManager.getViewModelStore(this);
        }
        throw new IllegalStateException("Calling getViewModelStore() before a Fragment reaches onCreate() when using setMaxLifecycle(INITIALIZED) is not supported");
    }

    public final int hashCode() {
        return super.hashCode();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void initState() {
        initLifecycle();
        this.mPreviousWho = this.mWho;
        this.mWho = UUID.randomUUID().toString();
        this.mAdded = false;
        this.mRemoving = false;
        this.mFromLayout = false;
        this.mInLayout = false;
        this.mRestored = false;
        this.mBackStackNesting = 0;
        this.mFragmentManager = null;
        this.mChildFragmentManager = new FragmentManagerImpl();
        this.mHost = null;
        this.mFragmentId = 0;
        this.mContainerId = 0;
        this.mTag = null;
        this.mHidden = false;
        this.mDetached = false;
    }

    public final boolean isAdded() {
        return this.mHost != null && this.mAdded;
    }

    public final boolean isHidden() {
        FragmentManager fragmentManager;
        return this.mHidden || ((fragmentManager = this.mFragmentManager) != null && fragmentManager.isParentHidden(this.mParentFragment));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean isInBackStack() {
        return this.mBackStackNesting > 0;
    }

    public final boolean isMenuVisible() {
        FragmentManager fragmentManager;
        return this.mMenuVisible && ((fragmentManager = this.mFragmentManager) == null || fragmentManager.isParentMenuVisible(this.mParentFragment));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isPostponed() {
        AnimationInfo animationInfo = this.mAnimationInfo;
        if (animationInfo == null) {
            return false;
        }
        return animationInfo.mEnterTransitionPostponed;
    }

    public final boolean isRemoving() {
        return this.mRemoving;
    }

    public final boolean isResumed() {
        return this.mState >= 7;
    }

    public final boolean isStateSaved() {
        FragmentManager fragmentManager = this.mFragmentManager;
        if (fragmentManager == null) {
            return false;
        }
        return fragmentManager.isStateSaved();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void noteStateNotSaved() {
        this.mChildFragmentManager.noteStateNotSaved();
    }

    @Deprecated
    public void onActivityCreated(Bundle bundle) {
        this.mCalled = true;
    }

    @Deprecated
    public void onActivityResult(int i5, int i6, Intent intent) {
        if (FragmentManager.isLoggingEnabled(2)) {
            Log.v("FragmentManager", "Fragment " + this + " received the following in onActivityResult(): requestCode: " + i5 + " resultCode: " + i6 + " data: " + intent);
        }
    }

    public void onAttach(Context context) {
        this.mCalled = true;
        FragmentHostCallback<?> fragmentHostCallback = this.mHost;
        Activity activity = fragmentHostCallback == null ? null : fragmentHostCallback.getActivity();
        if (activity != null) {
            this.mCalled = false;
            onAttach(activity);
        }
    }

    @Deprecated
    public void onAttachFragment(Fragment fragment) {
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        this.mCalled = true;
    }

    public boolean onContextItemSelected(MenuItem menuItem) {
        return false;
    }

    public void onCreate(Bundle bundle) {
        this.mCalled = true;
        restoreChildFragmentState(bundle);
        if (this.mChildFragmentManager.isStateAtLeast(1)) {
            return;
        }
        this.mChildFragmentManager.dispatchCreate();
    }

    public Animation onCreateAnimation(int i5, boolean z5, int i6) {
        return null;
    }

    public Animator onCreateAnimator(int i5, boolean z5, int i6) {
        return null;
    }

    @Override // android.view.View.OnCreateContextMenuListener
    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        requireActivity().onCreateContextMenu(contextMenu, view, contextMenuInfo);
    }

    @Deprecated
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int i5 = this.mContentLayoutId;
        if (i5 != 0) {
            return layoutInflater.inflate(i5, viewGroup, false);
        }
        return null;
    }

    public void onDestroy() {
        this.mCalled = true;
    }

    @Deprecated
    public void onDestroyOptionsMenu() {
    }

    public void onDestroyView() {
        this.mCalled = true;
    }

    public void onDetach() {
        this.mCalled = true;
    }

    public LayoutInflater onGetLayoutInflater(Bundle bundle) {
        return getLayoutInflater(bundle);
    }

    public void onHiddenChanged(boolean z5) {
    }

    public void onInflate(Context context, AttributeSet attributeSet, Bundle bundle) {
        this.mCalled = true;
        FragmentHostCallback<?> fragmentHostCallback = this.mHost;
        Activity activity = fragmentHostCallback == null ? null : fragmentHostCallback.getActivity();
        if (activity != null) {
            this.mCalled = false;
            onInflate(activity, attributeSet, bundle);
        }
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
        this.mCalled = true;
    }

    public void onMultiWindowModeChanged(boolean z5) {
    }

    @Deprecated
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        return false;
    }

    @Deprecated
    public void onOptionsMenuClosed(Menu menu) {
    }

    public void onPause() {
        this.mCalled = true;
    }

    public void onPictureInPictureModeChanged(boolean z5) {
    }

    @Deprecated
    public void onPrepareOptionsMenu(Menu menu) {
    }

    public void onPrimaryNavigationFragmentChanged(boolean z5) {
    }

    @Deprecated
    public void onRequestPermissionsResult(int i5, String[] strArr, int[] iArr) {
    }

    public void onResume() {
        this.mCalled = true;
    }

    public void onSaveInstanceState(Bundle bundle) {
    }

    public void onStart() {
        this.mCalled = true;
    }

    public void onStop() {
        this.mCalled = true;
    }

    public void onViewCreated(View view, Bundle bundle) {
    }

    public void onViewStateRestored(Bundle bundle) {
        this.mCalled = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void performActivityCreated(Bundle bundle) {
        this.mChildFragmentManager.noteStateNotSaved();
        this.mState = 3;
        this.mCalled = false;
        onActivityCreated(bundle);
        if (this.mCalled) {
            restoreViewState();
            this.mChildFragmentManager.dispatchActivityCreated();
        } else {
            throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onActivityCreated()");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void performAttach() {
        Iterator<OnPreAttachedListener> it = this.mOnPreAttachedListeners.iterator();
        while (it.hasNext()) {
            it.next().onPreAttached();
        }
        this.mOnPreAttachedListeners.clear();
        this.mChildFragmentManager.attachController(this.mHost, createFragmentContainer(), this);
        this.mState = 0;
        this.mCalled = false;
        onAttach(this.mHost.getContext());
        if (this.mCalled) {
            this.mFragmentManager.dispatchOnAttachFragment(this);
            this.mChildFragmentManager.dispatchAttach();
        } else {
            throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onAttach()");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void performConfigurationChanged(Configuration configuration) {
        onConfigurationChanged(configuration);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean performContextItemSelected(MenuItem menuItem) {
        if (this.mHidden) {
            return false;
        }
        if (onContextItemSelected(menuItem)) {
            return true;
        }
        return this.mChildFragmentManager.dispatchContextItemSelected(menuItem);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void performCreate(Bundle bundle) {
        this.mChildFragmentManager.noteStateNotSaved();
        this.mState = 1;
        this.mCalled = false;
        this.mLifecycleRegistry.addObserver(new LifecycleEventObserver() { // from class: androidx.fragment.app.Fragment.6
            @Override // androidx.lifecycle.LifecycleEventObserver
            public void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                View view;
                if (event != Lifecycle.Event.ON_STOP || (view = Fragment.this.mView) == null) {
                    return;
                }
                Api19Impl.cancelPendingInputEvents(view);
            }
        });
        this.mSavedStateRegistryController.performRestore(bundle);
        onCreate(bundle);
        this.mIsCreated = true;
        if (this.mCalled) {
            this.mLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
            return;
        }
        throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onCreate()");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean performCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        boolean z5 = false;
        if (this.mHidden) {
            return false;
        }
        if (this.mHasMenu && this.mMenuVisible) {
            onCreateOptionsMenu(menu, menuInflater);
            z5 = true;
        }
        return z5 | this.mChildFragmentManager.dispatchCreateOptionsMenu(menu, menuInflater);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void performCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mChildFragmentManager.noteStateNotSaved();
        this.mPerformedCreateView = true;
        this.mViewLifecycleOwner = new FragmentViewLifecycleOwner(this, getViewModelStore());
        View onCreateView = onCreateView(layoutInflater, viewGroup, bundle);
        this.mView = onCreateView;
        if (onCreateView == null) {
            if (this.mViewLifecycleOwner.isInitialized()) {
                throw new IllegalStateException("Called getViewLifecycleOwner() but onCreateView() returned null");
            }
            this.mViewLifecycleOwner = null;
        } else {
            this.mViewLifecycleOwner.initialize();
            ViewTreeLifecycleOwner.set(this.mView, this.mViewLifecycleOwner);
            ViewTreeViewModelStoreOwner.set(this.mView, this.mViewLifecycleOwner);
            ViewTreeSavedStateRegistryOwner.set(this.mView, this.mViewLifecycleOwner);
            this.mViewLifecycleOwnerLiveData.setValue(this.mViewLifecycleOwner);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void performDestroy() {
        this.mChildFragmentManager.dispatchDestroy();
        this.mLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_DESTROY);
        this.mState = 0;
        this.mCalled = false;
        this.mIsCreated = false;
        onDestroy();
        if (this.mCalled) {
            return;
        }
        throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onDestroy()");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void performDestroyView() {
        this.mChildFragmentManager.dispatchDestroyView();
        if (this.mView != null && this.mViewLifecycleOwner.getLifecycle().getState().isAtLeast(Lifecycle.State.CREATED)) {
            this.mViewLifecycleOwner.handleLifecycleEvent(Lifecycle.Event.ON_DESTROY);
        }
        this.mState = 1;
        this.mCalled = false;
        onDestroyView();
        if (this.mCalled) {
            LoaderManager.getInstance(this).markForRedelivery();
            this.mPerformedCreateView = false;
        } else {
            throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onDestroyView()");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void performDetach() {
        this.mState = -1;
        this.mCalled = false;
        onDetach();
        this.mLayoutInflater = null;
        if (this.mCalled) {
            if (this.mChildFragmentManager.isDestroyed()) {
                return;
            }
            this.mChildFragmentManager.dispatchDestroy();
            this.mChildFragmentManager = new FragmentManagerImpl();
            return;
        }
        throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onDetach()");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public LayoutInflater performGetLayoutInflater(Bundle bundle) {
        LayoutInflater onGetLayoutInflater = onGetLayoutInflater(bundle);
        this.mLayoutInflater = onGetLayoutInflater;
        return onGetLayoutInflater;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void performLowMemory() {
        onLowMemory();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void performMultiWindowModeChanged(boolean z5) {
        onMultiWindowModeChanged(z5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean performOptionsItemSelected(MenuItem menuItem) {
        if (this.mHidden) {
            return false;
        }
        if (this.mHasMenu && this.mMenuVisible && onOptionsItemSelected(menuItem)) {
            return true;
        }
        return this.mChildFragmentManager.dispatchOptionsItemSelected(menuItem);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void performOptionsMenuClosed(Menu menu) {
        if (this.mHidden) {
            return;
        }
        if (this.mHasMenu && this.mMenuVisible) {
            onOptionsMenuClosed(menu);
        }
        this.mChildFragmentManager.dispatchOptionsMenuClosed(menu);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void performPause() {
        this.mChildFragmentManager.dispatchPause();
        if (this.mView != null) {
            this.mViewLifecycleOwner.handleLifecycleEvent(Lifecycle.Event.ON_PAUSE);
        }
        this.mLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_PAUSE);
        this.mState = 6;
        this.mCalled = false;
        onPause();
        if (this.mCalled) {
            return;
        }
        throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onPause()");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void performPictureInPictureModeChanged(boolean z5) {
        onPictureInPictureModeChanged(z5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean performPrepareOptionsMenu(Menu menu) {
        boolean z5 = false;
        if (this.mHidden) {
            return false;
        }
        if (this.mHasMenu && this.mMenuVisible) {
            onPrepareOptionsMenu(menu);
            z5 = true;
        }
        return z5 | this.mChildFragmentManager.dispatchPrepareOptionsMenu(menu);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void performPrimaryNavigationFragmentChanged() {
        boolean isPrimaryNavigation = this.mFragmentManager.isPrimaryNavigation(this);
        Boolean bool = this.mIsPrimaryNavigationFragment;
        if (bool == null || bool.booleanValue() != isPrimaryNavigation) {
            this.mIsPrimaryNavigationFragment = Boolean.valueOf(isPrimaryNavigation);
            onPrimaryNavigationFragmentChanged(isPrimaryNavigation);
            this.mChildFragmentManager.dispatchPrimaryNavigationFragmentChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void performResume() {
        this.mChildFragmentManager.noteStateNotSaved();
        this.mChildFragmentManager.execPendingActions(true);
        this.mState = 7;
        this.mCalled = false;
        onResume();
        if (!this.mCalled) {
            throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onResume()");
        }
        LifecycleRegistry lifecycleRegistry = this.mLifecycleRegistry;
        Lifecycle.Event event = Lifecycle.Event.ON_RESUME;
        lifecycleRegistry.handleLifecycleEvent(event);
        if (this.mView != null) {
            this.mViewLifecycleOwner.handleLifecycleEvent(event);
        }
        this.mChildFragmentManager.dispatchResume();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void performSaveInstanceState(Bundle bundle) {
        onSaveInstanceState(bundle);
        this.mSavedStateRegistryController.performSave(bundle);
        Bundle lambda$attachController$4 = this.mChildFragmentManager.lambda$attachController$4();
        if (lambda$attachController$4 != null) {
            bundle.putParcelable("android:support:fragments", lambda$attachController$4);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void performStart() {
        this.mChildFragmentManager.noteStateNotSaved();
        this.mChildFragmentManager.execPendingActions(true);
        this.mState = 5;
        this.mCalled = false;
        onStart();
        if (!this.mCalled) {
            throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onStart()");
        }
        LifecycleRegistry lifecycleRegistry = this.mLifecycleRegistry;
        Lifecycle.Event event = Lifecycle.Event.ON_START;
        lifecycleRegistry.handleLifecycleEvent(event);
        if (this.mView != null) {
            this.mViewLifecycleOwner.handleLifecycleEvent(event);
        }
        this.mChildFragmentManager.dispatchStart();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void performStop() {
        this.mChildFragmentManager.dispatchStop();
        if (this.mView != null) {
            this.mViewLifecycleOwner.handleLifecycleEvent(Lifecycle.Event.ON_STOP);
        }
        this.mLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_STOP);
        this.mState = 4;
        this.mCalled = false;
        onStop();
        if (this.mCalled) {
            return;
        }
        throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onStop()");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void performViewCreated() {
        onViewCreated(this.mView, this.mSavedFragmentState);
        this.mChildFragmentManager.dispatchViewCreated();
    }

    public final <I, O> ActivityResultLauncher<I> registerForActivityResult(ActivityResultContract<I, O> activityResultContract, ActivityResultCallback<O> activityResultCallback) {
        return prepareCallInternal(activityResultContract, new Function<Void, ActivityResultRegistry>() { // from class: androidx.fragment.app.Fragment.7
            @Override // androidx.arch.core.util.Function
            public ActivityResultRegistry apply(Void r32) {
                Fragment fragment = Fragment.this;
                Object obj = fragment.mHost;
                if (obj instanceof ActivityResultRegistryOwner) {
                    return ((ActivityResultRegistryOwner) obj).getActivityResultRegistry();
                }
                return fragment.requireActivity().getActivityResultRegistry();
            }
        }, activityResultCallback);
    }

    public final FragmentActivity requireActivity() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            return activity;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to an activity.");
    }

    public final Context requireContext() {
        Context context = getContext();
        if (context != null) {
            return context;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to a context.");
    }

    public final View requireView() {
        View view = getView();
        if (view != null) {
            return view;
        }
        throw new IllegalStateException("Fragment " + this + " did not return a View from onCreateView() or this was called before onCreateView().");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void restoreChildFragmentState(Bundle bundle) {
        Parcelable parcelable;
        if (bundle == null || (parcelable = bundle.getParcelable("android:support:fragments")) == null) {
            return;
        }
        this.mChildFragmentManager.restoreSaveStateInternal(parcelable);
        this.mChildFragmentManager.dispatchCreate();
    }

    final void restoreViewState(Bundle bundle) {
        SparseArray<Parcelable> sparseArray = this.mSavedViewState;
        if (sparseArray != null) {
            this.mView.restoreHierarchyState(sparseArray);
            this.mSavedViewState = null;
        }
        if (this.mView != null) {
            this.mViewLifecycleOwner.performRestore(this.mSavedViewRegistryState);
            this.mSavedViewRegistryState = null;
        }
        this.mCalled = false;
        onViewStateRestored(bundle);
        if (this.mCalled) {
            if (this.mView != null) {
                this.mViewLifecycleOwner.handleLifecycleEvent(Lifecycle.Event.ON_CREATE);
            }
        } else {
            throw new SuperNotCalledException("Fragment " + this + " did not call through to super.onViewStateRestored()");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setAnimations(int i5, int i6, int i7, int i8) {
        if (this.mAnimationInfo == null && i5 == 0 && i6 == 0 && i7 == 0 && i8 == 0) {
            return;
        }
        ensureAnimationInfo().mEnterAnim = i5;
        ensureAnimationInfo().mExitAnim = i6;
        ensureAnimationInfo().mPopEnterAnim = i7;
        ensureAnimationInfo().mPopExitAnim = i8;
    }

    public void setArguments(Bundle bundle) {
        if (this.mFragmentManager != null && isStateSaved()) {
            throw new IllegalStateException("Fragment already added and state has been saved");
        }
        this.mArguments = bundle;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setFocusedView(View view) {
        ensureAnimationInfo().mFocusedView = view;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setNextTransition(int i5) {
        if (this.mAnimationInfo == null && i5 == 0) {
            return;
        }
        ensureAnimationInfo();
        this.mAnimationInfo.mNextTransition = i5;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setPopDirection(boolean z5) {
        if (this.mAnimationInfo == null) {
            return;
        }
        ensureAnimationInfo().mIsPop = z5;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setPostOnViewCreatedAlpha(float f5) {
        ensureAnimationInfo().mPostOnViewCreatedAlpha = f5;
    }

    @Deprecated
    public void setRetainInstance(boolean z5) {
        FragmentStrictMode.onSetRetainInstanceUsage(this);
        this.mRetainInstance = z5;
        FragmentManager fragmentManager = this.mFragmentManager;
        if (fragmentManager == null) {
            this.mRetainInstanceChangedWhileDetached = true;
        } else if (z5) {
            fragmentManager.addRetainedFragment(this);
        } else {
            fragmentManager.removeRetainedFragment(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setSharedElementNames(ArrayList<String> arrayList, ArrayList<String> arrayList2) {
        ensureAnimationInfo();
        AnimationInfo animationInfo = this.mAnimationInfo;
        animationInfo.mSharedElementSourceNames = arrayList;
        animationInfo.mSharedElementTargetNames = arrayList2;
    }

    @Deprecated
    public void startActivityForResult(@SuppressLint({"UnknownNullness"}) Intent intent, int i5) {
        startActivityForResult(intent, i5, null);
    }

    public void startPostponedEnterTransition() {
        if (this.mAnimationInfo == null || !ensureAnimationInfo().mEnterTransitionPostponed) {
            return;
        }
        if (this.mHost == null) {
            ensureAnimationInfo().mEnterTransitionPostponed = false;
        } else if (Looper.myLooper() != this.mHost.getHandler().getLooper()) {
            this.mHost.getHandler().postAtFrontOfQueue(new Runnable() { // from class: androidx.fragment.app.Fragment.3
                @Override // java.lang.Runnable
                public void run() {
                    Fragment.this.callStartTransitionListener(false);
                }
            });
        } else {
            callStartTransitionListener(true);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append(getClass().getSimpleName());
        sb.append("{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("}");
        sb.append(" (");
        sb.append(this.mWho);
        if (this.mFragmentId != 0) {
            sb.append(" id=0x");
            sb.append(Integer.toHexString(this.mFragmentId));
        }
        if (this.mTag != null) {
            sb.append(" tag=");
            sb.append(this.mTag);
        }
        sb.append(")");
        return sb.toString();
    }

    @Deprecated
    public void startActivityForResult(@SuppressLint({"UnknownNullness"}) Intent intent, int i5, Bundle bundle) {
        if (this.mHost != null) {
            getParentFragmentManager().launchStartActivityForResult(this, intent, i5, bundle);
            return;
        }
        throw new IllegalStateException("Fragment " + this + " not attached to Activity");
    }

    @Deprecated
    public LayoutInflater getLayoutInflater(Bundle bundle) {
        FragmentHostCallback<?> fragmentHostCallback = this.mHost;
        if (fragmentHostCallback != null) {
            LayoutInflater onGetLayoutInflater = fragmentHostCallback.onGetLayoutInflater();
            LayoutInflaterCompat.setFactory2(onGetLayoutInflater, this.mChildFragmentManager.getLayoutInflaterFactory());
            return onGetLayoutInflater;
        }
        throw new IllegalStateException("onGetLayoutInflater() cannot be executed until the Fragment is attached to the FragmentManager.");
    }

    @Deprecated
    public void onAttach(Activity activity) {
        this.mCalled = true;
    }

    @Deprecated
    public void onInflate(Activity activity, AttributeSet attributeSet, Bundle bundle) {
        this.mCalled = true;
    }

    private void restoreViewState() {
        if (FragmentManager.isLoggingEnabled(3)) {
            Log.d("FragmentManager", "moveto RESTORE_VIEW_STATE: " + this);
        }
        if (this.mView != null) {
            restoreViewState(this.mSavedFragmentState);
        }
        this.mSavedFragmentState = null;
    }
}
