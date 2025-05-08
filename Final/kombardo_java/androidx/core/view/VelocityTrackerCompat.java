package androidx.core.view;

import android.os.Build;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import java.util.Collections;
import java.util.Map;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public abstract class VelocityTrackerCompat {
    private static Map<VelocityTracker, VelocityTrackerFallback> sFallbackTrackers = Collections.synchronizedMap(new WeakHashMap());

    /* loaded from: classes.dex */
    private static class Api34Impl {
        static float getAxisVelocity(VelocityTracker velocityTracker, int i5) {
            return velocityTracker.getAxisVelocity(i5);
        }
    }

    public static void addMovement(VelocityTracker velocityTracker, MotionEvent motionEvent) {
        velocityTracker.addMovement(motionEvent);
        if (Build.VERSION.SDK_INT < 34 && motionEvent.getSource() == 4194304) {
            if (!sFallbackTrackers.containsKey(velocityTracker)) {
                sFallbackTrackers.put(velocityTracker, new VelocityTrackerFallback());
            }
            sFallbackTrackers.get(velocityTracker).addMovement(motionEvent);
        }
    }

    public static void computeCurrentVelocity(VelocityTracker velocityTracker, int i5, float f5) {
        velocityTracker.computeCurrentVelocity(i5, f5);
        VelocityTrackerFallback fallbackTrackerOrNull = getFallbackTrackerOrNull(velocityTracker);
        if (fallbackTrackerOrNull != null) {
            fallbackTrackerOrNull.computeCurrentVelocity(i5, f5);
        }
    }

    public static float getAxisVelocity(VelocityTracker velocityTracker, int i5) {
        if (Build.VERSION.SDK_INT >= 34) {
            return Api34Impl.getAxisVelocity(velocityTracker, i5);
        }
        if (i5 == 0) {
            return velocityTracker.getXVelocity();
        }
        if (i5 == 1) {
            return velocityTracker.getYVelocity();
        }
        VelocityTrackerFallback fallbackTrackerOrNull = getFallbackTrackerOrNull(velocityTracker);
        if (fallbackTrackerOrNull != null) {
            return fallbackTrackerOrNull.getAxisVelocity(i5);
        }
        return 0.0f;
    }

    private static VelocityTrackerFallback getFallbackTrackerOrNull(VelocityTracker velocityTracker) {
        return sFallbackTrackers.get(velocityTracker);
    }

    public static void computeCurrentVelocity(VelocityTracker velocityTracker, int i5) {
        computeCurrentVelocity(velocityTracker, i5, Float.MAX_VALUE);
    }
}
