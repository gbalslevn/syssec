package androidx.core.view;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.view.InputDevice;
import android.view.ViewConfiguration;
import androidx.core.util.Supplier;
import java.lang.reflect.Method;
import java.util.Objects;

/* loaded from: classes.dex */
public abstract class ViewConfigurationCompat {
    private static final int NO_FLING_MAX_VELOCITY = Integer.MIN_VALUE;
    private static final int NO_FLING_MIN_VELOCITY = Integer.MAX_VALUE;
    private static final int RESOURCE_ID_NOT_SUPPORTED = -1;
    private static final int RESOURCE_ID_SUPPORTED_BUT_NOT_FOUND = 0;
    private static final String TAG = "ViewConfigCompat";
    private static Method sGetScaledScrollFactorMethod;

    /* loaded from: classes.dex */
    static class Api26Impl {
        static float getScaledHorizontalScrollFactor(ViewConfiguration viewConfiguration) {
            return viewConfiguration.getScaledHorizontalScrollFactor();
        }

        static float getScaledVerticalScrollFactor(ViewConfiguration viewConfiguration) {
            return viewConfiguration.getScaledVerticalScrollFactor();
        }
    }

    /* loaded from: classes.dex */
    static class Api28Impl {
        static boolean shouldShowMenuShortcutsWhenKeyboardPresent(ViewConfiguration viewConfiguration) {
            return viewConfiguration.shouldShowMenuShortcutsWhenKeyboardPresent();
        }
    }

    /* loaded from: classes.dex */
    static class Api34Impl {
        static int getScaledMaximumFlingVelocity(ViewConfiguration viewConfiguration, int i5, int i6, int i7) {
            return viewConfiguration.getScaledMaximumFlingVelocity(i5, i6, i7);
        }

        static int getScaledMinimumFlingVelocity(ViewConfiguration viewConfiguration, int i5, int i6, int i7) {
            return viewConfiguration.getScaledMinimumFlingVelocity(i5, i6, i7);
        }
    }

    private static int getCompatFlingVelocityThreshold(Resources resources, int i5, Supplier<Integer> supplier, int i6) {
        int dimensionPixelSize;
        return i5 != -1 ? (i5 == 0 || (dimensionPixelSize = resources.getDimensionPixelSize(i5)) < 0) ? i6 : dimensionPixelSize : supplier.get().intValue();
    }

    private static int getPlatformResId(Resources resources, String str, String str2) {
        return resources.getIdentifier(str, str2, "android");
    }

    private static int getPreApi34MaximumFlingVelocityResId(Resources resources, int i5, int i6) {
        if (i5 == 4194304 && i6 == 26) {
            return getPlatformResId(resources, "config_viewMaxRotaryEncoderFlingVelocity", "dimen");
        }
        return -1;
    }

    private static int getPreApi34MinimumFlingVelocityResId(Resources resources, int i5, int i6) {
        if (i5 == 4194304 && i6 == 26) {
            return getPlatformResId(resources, "config_viewMinRotaryEncoderFlingVelocity", "dimen");
        }
        return -1;
    }

    public static float getScaledHorizontalScrollFactor(ViewConfiguration viewConfiguration, Context context) {
        return Api26Impl.getScaledHorizontalScrollFactor(viewConfiguration);
    }

    public static int getScaledMaximumFlingVelocity(Context context, final ViewConfiguration viewConfiguration, int i5, int i6, int i7) {
        if (Build.VERSION.SDK_INT >= 34) {
            return Api34Impl.getScaledMaximumFlingVelocity(viewConfiguration, i5, i6, i7);
        }
        if (!isInputDeviceInfoValid(i5, i6, i7)) {
            return NO_FLING_MAX_VELOCITY;
        }
        Resources resources = context.getResources();
        int preApi34MaximumFlingVelocityResId = getPreApi34MaximumFlingVelocityResId(resources, i7, i6);
        Objects.requireNonNull(viewConfiguration);
        return getCompatFlingVelocityThreshold(resources, preApi34MaximumFlingVelocityResId, new Supplier() { // from class: D.i
            @Override // androidx.core.util.Supplier
            public final Object get() {
                return Integer.valueOf(viewConfiguration.getScaledMaximumFlingVelocity());
            }
        }, NO_FLING_MAX_VELOCITY);
    }

    public static int getScaledMinimumFlingVelocity(Context context, final ViewConfiguration viewConfiguration, int i5, int i6, int i7) {
        if (Build.VERSION.SDK_INT >= 34) {
            return Api34Impl.getScaledMinimumFlingVelocity(viewConfiguration, i5, i6, i7);
        }
        if (!isInputDeviceInfoValid(i5, i6, i7)) {
            return NO_FLING_MIN_VELOCITY;
        }
        Resources resources = context.getResources();
        int preApi34MinimumFlingVelocityResId = getPreApi34MinimumFlingVelocityResId(resources, i7, i6);
        Objects.requireNonNull(viewConfiguration);
        return getCompatFlingVelocityThreshold(resources, preApi34MinimumFlingVelocityResId, new Supplier() { // from class: D.j
            @Override // androidx.core.util.Supplier
            public final Object get() {
                return Integer.valueOf(viewConfiguration.getScaledMinimumFlingVelocity());
            }
        }, NO_FLING_MIN_VELOCITY);
    }

    public static float getScaledVerticalScrollFactor(ViewConfiguration viewConfiguration, Context context) {
        return Api26Impl.getScaledVerticalScrollFactor(viewConfiguration);
    }

    private static boolean isInputDeviceInfoValid(int i5, int i6, int i7) {
        InputDevice device = InputDevice.getDevice(i5);
        return (device == null || device.getMotionRange(i6, i7) == null) ? false : true;
    }

    public static boolean shouldShowMenuShortcutsWhenKeyboardPresent(ViewConfiguration viewConfiguration, Context context) {
        if (Build.VERSION.SDK_INT >= 28) {
            return Api28Impl.shouldShowMenuShortcutsWhenKeyboardPresent(viewConfiguration);
        }
        Resources resources = context.getResources();
        int platformResId = getPlatformResId(resources, "config_showMenuShortcutsWhenKeyboardPresent", "bool");
        return platformResId != 0 && resources.getBoolean(platformResId);
    }
}
