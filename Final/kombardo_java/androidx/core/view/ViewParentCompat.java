package androidx.core.view;

import android.util.Log;
import android.view.View;
import android.view.ViewParent;

/* loaded from: classes.dex */
public abstract class ViewParentCompat {
    private static final String TAG = "ViewParentCompat";
    private static int[] sTempNestedScrollConsumed;

    /* loaded from: classes.dex */
    static class Api21Impl {
        static boolean onNestedFling(ViewParent viewParent, View view, float f5, float f6, boolean z5) {
            return viewParent.onNestedFling(view, f5, f6, z5);
        }

        static boolean onNestedPreFling(ViewParent viewParent, View view, float f5, float f6) {
            return viewParent.onNestedPreFling(view, f5, f6);
        }

        static void onNestedPreScroll(ViewParent viewParent, View view, int i5, int i6, int[] iArr) {
            viewParent.onNestedPreScroll(view, i5, i6, iArr);
        }

        static void onNestedScroll(ViewParent viewParent, View view, int i5, int i6, int i7, int i8) {
            viewParent.onNestedScroll(view, i5, i6, i7, i8);
        }

        static void onNestedScrollAccepted(ViewParent viewParent, View view, View view2, int i5) {
            viewParent.onNestedScrollAccepted(view, view2, i5);
        }

        static boolean onStartNestedScroll(ViewParent viewParent, View view, View view2, int i5) {
            return viewParent.onStartNestedScroll(view, view2, i5);
        }

        static void onStopNestedScroll(ViewParent viewParent, View view) {
            viewParent.onStopNestedScroll(view);
        }
    }

    public static boolean onNestedFling(ViewParent viewParent, View view, float f5, float f6, boolean z5) {
        try {
            return Api21Impl.onNestedFling(viewParent, view, f5, f6, z5);
        } catch (AbstractMethodError e5) {
            Log.e(TAG, "ViewParent " + viewParent + " does not implement interface method onNestedFling", e5);
            return false;
        }
    }

    public static boolean onNestedPreFling(ViewParent viewParent, View view, float f5, float f6) {
        try {
            return Api21Impl.onNestedPreFling(viewParent, view, f5, f6);
        } catch (AbstractMethodError e5) {
            Log.e(TAG, "ViewParent " + viewParent + " does not implement interface method onNestedPreFling", e5);
            return false;
        }
    }

    public static void onNestedPreScroll(ViewParent viewParent, View view, int i5, int i6, int[] iArr, int i7) {
        if (viewParent instanceof NestedScrollingParent2) {
            ((NestedScrollingParent2) viewParent).onNestedPreScroll(view, i5, i6, iArr, i7);
            return;
        }
        if (i7 == 0) {
            try {
                Api21Impl.onNestedPreScroll(viewParent, view, i5, i6, iArr);
            } catch (AbstractMethodError e5) {
                Log.e(TAG, "ViewParent " + viewParent + " does not implement interface method onNestedPreScroll", e5);
            }
        }
    }

    public static void onNestedScroll(ViewParent viewParent, View view, int i5, int i6, int i7, int i8, int i9, int[] iArr) {
        if (viewParent instanceof NestedScrollingParent3) {
            ((NestedScrollingParent3) viewParent).onNestedScroll(view, i5, i6, i7, i8, i9, iArr);
            return;
        }
        iArr[0] = iArr[0] + i7;
        iArr[1] = iArr[1] + i8;
        if (viewParent instanceof NestedScrollingParent2) {
            ((NestedScrollingParent2) viewParent).onNestedScroll(view, i5, i6, i7, i8, i9);
            return;
        }
        if (i9 == 0) {
            try {
                Api21Impl.onNestedScroll(viewParent, view, i5, i6, i7, i8);
            } catch (AbstractMethodError e5) {
                Log.e(TAG, "ViewParent " + viewParent + " does not implement interface method onNestedScroll", e5);
            }
        }
    }

    public static void onNestedScrollAccepted(ViewParent viewParent, View view, View view2, int i5, int i6) {
        if (viewParent instanceof NestedScrollingParent2) {
            ((NestedScrollingParent2) viewParent).onNestedScrollAccepted(view, view2, i5, i6);
            return;
        }
        if (i6 == 0) {
            try {
                Api21Impl.onNestedScrollAccepted(viewParent, view, view2, i5);
            } catch (AbstractMethodError e5) {
                Log.e(TAG, "ViewParent " + viewParent + " does not implement interface method onNestedScrollAccepted", e5);
            }
        }
    }

    public static boolean onStartNestedScroll(ViewParent viewParent, View view, View view2, int i5, int i6) {
        if (viewParent instanceof NestedScrollingParent2) {
            return ((NestedScrollingParent2) viewParent).onStartNestedScroll(view, view2, i5, i6);
        }
        if (i6 != 0) {
            return false;
        }
        try {
            return Api21Impl.onStartNestedScroll(viewParent, view, view2, i5);
        } catch (AbstractMethodError e5) {
            Log.e(TAG, "ViewParent " + viewParent + " does not implement interface method onStartNestedScroll", e5);
            return false;
        }
    }

    public static void onStopNestedScroll(ViewParent viewParent, View view, int i5) {
        if (viewParent instanceof NestedScrollingParent2) {
            ((NestedScrollingParent2) viewParent).onStopNestedScroll(view, i5);
            return;
        }
        if (i5 == 0) {
            try {
                Api21Impl.onStopNestedScroll(viewParent, view);
            } catch (AbstractMethodError e5) {
                Log.e(TAG, "ViewParent " + viewParent + " does not implement interface method onStopNestedScroll", e5);
            }
        }
    }
}
