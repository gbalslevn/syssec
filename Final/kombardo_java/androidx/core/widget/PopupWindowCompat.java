package androidx.core.widget;

import android.view.View;
import android.widget.PopupWindow;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public abstract class PopupWindowCompat {
    private static final String TAG = "PopupWindowCompatApi21";
    private static Method sGetWindowLayoutTypeMethod;
    private static boolean sGetWindowLayoutTypeMethodAttempted;
    private static Field sOverlapAnchorField;
    private static boolean sOverlapAnchorFieldAttempted;
    private static Method sSetWindowLayoutTypeMethod;
    private static boolean sSetWindowLayoutTypeMethodAttempted;

    /* loaded from: classes.dex */
    static class Api23Impl {
        static void setOverlapAnchor(PopupWindow popupWindow, boolean z5) {
            popupWindow.setOverlapAnchor(z5);
        }

        static void setWindowLayoutType(PopupWindow popupWindow, int i5) {
            popupWindow.setWindowLayoutType(i5);
        }
    }

    public static void setOverlapAnchor(PopupWindow popupWindow, boolean z5) {
        Api23Impl.setOverlapAnchor(popupWindow, z5);
    }

    public static void setWindowLayoutType(PopupWindow popupWindow, int i5) {
        Api23Impl.setWindowLayoutType(popupWindow, i5);
    }

    @Deprecated
    public static void showAsDropDown(PopupWindow popupWindow, View view, int i5, int i6, int i7) {
        popupWindow.showAsDropDown(view, i5, i6, i7);
    }
}
