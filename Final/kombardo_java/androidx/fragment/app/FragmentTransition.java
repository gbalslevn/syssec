package androidx.fragment.app;

import android.view.View;
import androidx.collection.ArrayMap;
import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class FragmentTransition {
    static final FragmentTransitionImpl PLATFORM_IMPL = new FragmentTransitionCompat21();
    static final FragmentTransitionImpl SUPPORT_IMPL = resolveSupportImpl();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void callSharedElementStartEnd(Fragment fragment, Fragment fragment2, boolean z5, ArrayMap<String, View> arrayMap, boolean z6) {
        if (z5) {
            fragment2.getEnterTransitionCallback();
        } else {
            fragment.getEnterTransitionCallback();
        }
    }

    private static FragmentTransitionImpl resolveSupportImpl() {
        try {
            return (FragmentTransitionImpl) Class.forName("androidx.transition.FragmentTransitionSupport").getDeclaredConstructor(null).newInstance(null);
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void retainValues(ArrayMap<String, String> arrayMap, ArrayMap<String, View> arrayMap2) {
        for (int size = arrayMap.getSize() - 1; size >= 0; size--) {
            if (!arrayMap2.containsKey(arrayMap.valueAt(size))) {
                arrayMap.removeAt(size);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setViewVisibility(ArrayList<View> arrayList, int i5) {
        if (arrayList == null) {
            return;
        }
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            arrayList.get(size).setVisibility(i5);
        }
    }
}
