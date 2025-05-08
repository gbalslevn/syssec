package androidx.core.view;

import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowInsetsController;
import androidx.collection.SimpleArrayMap;

/* loaded from: classes.dex */
public final class WindowInsetsControllerCompat {
    private final Impl mImpl;

    /* loaded from: classes.dex */
    private static class Impl {
        Impl() {
        }

        public abstract boolean isAppearanceLightNavigationBars();

        public abstract boolean isAppearanceLightStatusBars();

        public abstract void setAppearanceLightNavigationBars(boolean z5);

        public abstract void setAppearanceLightStatusBars(boolean z5);
    }

    /* loaded from: classes.dex */
    private static class Impl20 extends Impl {
        private final SoftwareKeyboardControllerCompat mSoftwareKeyboardControllerCompat;
        protected final Window mWindow;

        Impl20(Window window, SoftwareKeyboardControllerCompat softwareKeyboardControllerCompat) {
            this.mWindow = window;
            this.mSoftwareKeyboardControllerCompat = softwareKeyboardControllerCompat;
        }

        protected void setSystemUiFlag(int i5) {
            View decorView = this.mWindow.getDecorView();
            decorView.setSystemUiVisibility(i5 | decorView.getSystemUiVisibility());
        }

        protected void setWindowFlag(int i5) {
            this.mWindow.addFlags(i5);
        }

        protected void unsetSystemUiFlag(int i5) {
            View decorView = this.mWindow.getDecorView();
            decorView.setSystemUiVisibility((~i5) & decorView.getSystemUiVisibility());
        }

        protected void unsetWindowFlag(int i5) {
            this.mWindow.clearFlags(i5);
        }
    }

    /* loaded from: classes.dex */
    private static class Impl23 extends Impl20 {
        Impl23(Window window, SoftwareKeyboardControllerCompat softwareKeyboardControllerCompat) {
            super(window, softwareKeyboardControllerCompat);
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        public boolean isAppearanceLightStatusBars() {
            return (this.mWindow.getDecorView().getSystemUiVisibility() & 8192) != 0;
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        public void setAppearanceLightStatusBars(boolean z5) {
            if (!z5) {
                unsetSystemUiFlag(8192);
                return;
            }
            unsetWindowFlag(67108864);
            setWindowFlag(Integer.MIN_VALUE);
            setSystemUiFlag(8192);
        }
    }

    /* loaded from: classes.dex */
    private static class Impl26 extends Impl23 {
        Impl26(Window window, SoftwareKeyboardControllerCompat softwareKeyboardControllerCompat) {
            super(window, softwareKeyboardControllerCompat);
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        public boolean isAppearanceLightNavigationBars() {
            return (this.mWindow.getDecorView().getSystemUiVisibility() & 16) != 0;
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        public void setAppearanceLightNavigationBars(boolean z5) {
            if (!z5) {
                unsetSystemUiFlag(16);
                return;
            }
            unsetWindowFlag(134217728);
            setWindowFlag(Integer.MIN_VALUE);
            setSystemUiFlag(16);
        }
    }

    /* loaded from: classes.dex */
    private static class Impl31 extends Impl30 {
        Impl31(Window window, WindowInsetsControllerCompat windowInsetsControllerCompat, SoftwareKeyboardControllerCompat softwareKeyboardControllerCompat) {
            super(window, windowInsetsControllerCompat, softwareKeyboardControllerCompat);
        }
    }

    /* loaded from: classes.dex */
    private static class Impl35 extends Impl31 {
        Impl35(Window window, WindowInsetsControllerCompat windowInsetsControllerCompat, SoftwareKeyboardControllerCompat softwareKeyboardControllerCompat) {
            super(window, windowInsetsControllerCompat, softwareKeyboardControllerCompat);
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl30, androidx.core.view.WindowInsetsControllerCompat.Impl
        public boolean isAppearanceLightNavigationBars() {
            int systemBarsAppearance;
            systemBarsAppearance = this.mInsetsController.getSystemBarsAppearance();
            return (systemBarsAppearance & 16) != 0;
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl30, androidx.core.view.WindowInsetsControllerCompat.Impl
        public boolean isAppearanceLightStatusBars() {
            int systemBarsAppearance;
            systemBarsAppearance = this.mInsetsController.getSystemBarsAppearance();
            return (systemBarsAppearance & 8) != 0;
        }
    }

    public WindowInsetsControllerCompat(Window window, View view) {
        SoftwareKeyboardControllerCompat softwareKeyboardControllerCompat = new SoftwareKeyboardControllerCompat(view);
        int i5 = Build.VERSION.SDK_INT;
        if (i5 >= 35) {
            this.mImpl = new Impl35(window, this, softwareKeyboardControllerCompat);
        } else if (i5 >= 30) {
            this.mImpl = new Impl30(window, this, softwareKeyboardControllerCompat);
        } else {
            this.mImpl = new Impl26(window, softwareKeyboardControllerCompat);
        }
    }

    public boolean isAppearanceLightNavigationBars() {
        return this.mImpl.isAppearanceLightNavigationBars();
    }

    public boolean isAppearanceLightStatusBars() {
        return this.mImpl.isAppearanceLightStatusBars();
    }

    public void setAppearanceLightNavigationBars(boolean z5) {
        this.mImpl.setAppearanceLightNavigationBars(z5);
    }

    public void setAppearanceLightStatusBars(boolean z5) {
        this.mImpl.setAppearanceLightStatusBars(z5);
    }

    /* loaded from: classes.dex */
    private static class Impl30 extends Impl {
        final WindowInsetsControllerCompat mCompatController;
        final WindowInsetsController mInsetsController;
        private final SimpleArrayMap<Object, WindowInsetsController.OnControllableInsetsChangedListener> mListeners;
        final SoftwareKeyboardControllerCompat mSoftwareKeyboardControllerCompat;
        protected Window mWindow;

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        Impl30(Window window, WindowInsetsControllerCompat windowInsetsControllerCompat, SoftwareKeyboardControllerCompat softwareKeyboardControllerCompat) {
            this(r0, windowInsetsControllerCompat, softwareKeyboardControllerCompat);
            WindowInsetsController insetsController;
            insetsController = window.getInsetsController();
            this.mWindow = window;
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        public boolean isAppearanceLightNavigationBars() {
            int systemBarsAppearance;
            this.mInsetsController.setSystemBarsAppearance(0, 0);
            systemBarsAppearance = this.mInsetsController.getSystemBarsAppearance();
            return (systemBarsAppearance & 16) != 0;
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        public boolean isAppearanceLightStatusBars() {
            int systemBarsAppearance;
            this.mInsetsController.setSystemBarsAppearance(0, 0);
            systemBarsAppearance = this.mInsetsController.getSystemBarsAppearance();
            return (systemBarsAppearance & 8) != 0;
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        public void setAppearanceLightNavigationBars(boolean z5) {
            if (z5) {
                if (this.mWindow != null) {
                    setSystemUiFlag(16);
                }
                this.mInsetsController.setSystemBarsAppearance(16, 16);
            } else {
                if (this.mWindow != null) {
                    unsetSystemUiFlag(16);
                }
                this.mInsetsController.setSystemBarsAppearance(0, 16);
            }
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        public void setAppearanceLightStatusBars(boolean z5) {
            if (z5) {
                if (this.mWindow != null) {
                    setSystemUiFlag(8192);
                }
                this.mInsetsController.setSystemBarsAppearance(8, 8);
            } else {
                if (this.mWindow != null) {
                    unsetSystemUiFlag(8192);
                }
                this.mInsetsController.setSystemBarsAppearance(0, 8);
            }
        }

        protected void setSystemUiFlag(int i5) {
            View decorView = this.mWindow.getDecorView();
            decorView.setSystemUiVisibility(i5 | decorView.getSystemUiVisibility());
        }

        protected void unsetSystemUiFlag(int i5) {
            View decorView = this.mWindow.getDecorView();
            decorView.setSystemUiVisibility((~i5) & decorView.getSystemUiVisibility());
        }

        Impl30(WindowInsetsController windowInsetsController, WindowInsetsControllerCompat windowInsetsControllerCompat, SoftwareKeyboardControllerCompat softwareKeyboardControllerCompat) {
            this.mListeners = new SimpleArrayMap<>();
            this.mInsetsController = windowInsetsController;
            this.mCompatController = windowInsetsControllerCompat;
            this.mSoftwareKeyboardControllerCompat = softwareKeyboardControllerCompat;
        }
    }
}
