package androidx.core.view;

import android.view.View;

/* loaded from: classes.dex */
public interface NestedScrollingParent2 {
    void onNestedPreScroll(View view, int i5, int i6, int[] iArr, int i7);

    void onNestedScroll(View view, int i5, int i6, int i7, int i8, int i9);

    void onNestedScrollAccepted(View view, View view2, int i5, int i6);

    boolean onStartNestedScroll(View view, View view2, int i5, int i6);

    void onStopNestedScroll(View view, int i5);
}
