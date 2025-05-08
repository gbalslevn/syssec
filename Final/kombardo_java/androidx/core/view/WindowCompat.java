package androidx.core.view;

import android.os.Build;
import android.view.View;
import android.view.Window;

/* loaded from: classes.dex */
public abstract class WindowCompat {

    /* loaded from: classes.dex */
    static class Api16Impl {
        static void setDecorFitsSystemWindows(Window window, boolean z5) {
            View decorView = window.getDecorView();
            int systemUiVisibility = decorView.getSystemUiVisibility();
            decorView.setSystemUiVisibility(z5 ? systemUiVisibility & (-1793) : systemUiVisibility | 1792);
        }
    }

    /* loaded from: classes.dex */
    static class Api30Impl {
        static void setDecorFitsSystemWindows(Window window, boolean z5) {
            View decorView = window.getDecorView();
            int systemUiVisibility = decorView.getSystemUiVisibility();
            decorView.setSystemUiVisibility(z5 ? systemUiVisibility & (-257) : systemUiVisibility | 256);
            window.setDecorFitsSystemWindows(z5);
        }
    }

    /* loaded from: classes.dex */
    static class Api35Impl {
        static void setDecorFitsSystemWindows(Window window, boolean z5) {
            window.setDecorFitsSystemWindows(z5);
        }
    }

    public static WindowInsetsControllerCompat getInsetsController(Window window, View view) {
        return new WindowInsetsControllerCompat(window, view);
    }

    public static void setDecorFitsSystemWindows(Window window, boolean z5) {
        int i5 = Build.VERSION.SDK_INT;
        if (i5 >= 35) {
            Api35Impl.setDecorFitsSystemWindows(window, z5);
        } else if (i5 >= 30) {
            Api30Impl.setDecorFitsSystemWindows(window, z5);
        } else {
            Api16Impl.setDecorFitsSystemWindows(window, z5);
        }
    }
}
