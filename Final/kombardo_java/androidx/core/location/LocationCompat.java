package androidx.core.location;

import android.location.Location;
import android.os.Build;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public abstract class LocationCompat {
    private static Field sFieldsMaskField;
    private static Integer sHasBearingAccuracyMask;
    private static Integer sHasSpeedAccuracyMask;
    private static Integer sHasVerticalAccuracyMask;
    private static Method sSetIsFromMockProviderMethod;

    /* loaded from: classes.dex */
    private static class Api26Impl {
        static float getBearingAccuracyDegrees(Location location) {
            return location.getBearingAccuracyDegrees();
        }

        static float getSpeedAccuracyMetersPerSecond(Location location) {
            return location.getSpeedAccuracyMetersPerSecond();
        }

        static float getVerticalAccuracyMeters(Location location) {
            return location.getVerticalAccuracyMeters();
        }

        static boolean hasBearingAccuracy(Location location) {
            return location.hasBearingAccuracy();
        }

        static boolean hasSpeedAccuracy(Location location) {
            return location.hasSpeedAccuracy();
        }

        static boolean hasVerticalAccuracy(Location location) {
            return location.hasVerticalAccuracy();
        }
    }

    /* loaded from: classes.dex */
    static class Api31Impl {
        static boolean isMock(Location location) {
            return location.isMock();
        }
    }

    public static float getBearingAccuracyDegrees(Location location) {
        return Api26Impl.getBearingAccuracyDegrees(location);
    }

    public static long getElapsedRealtimeMillis(Location location) {
        return TimeUnit.NANOSECONDS.toMillis(location.getElapsedRealtimeNanos());
    }

    public static float getSpeedAccuracyMetersPerSecond(Location location) {
        return Api26Impl.getSpeedAccuracyMetersPerSecond(location);
    }

    public static float getVerticalAccuracyMeters(Location location) {
        return Api26Impl.getVerticalAccuracyMeters(location);
    }

    public static boolean hasBearingAccuracy(Location location) {
        return Api26Impl.hasBearingAccuracy(location);
    }

    public static boolean hasSpeedAccuracy(Location location) {
        return Api26Impl.hasSpeedAccuracy(location);
    }

    public static boolean hasVerticalAccuracy(Location location) {
        return Api26Impl.hasVerticalAccuracy(location);
    }

    public static boolean isMock(Location location) {
        return Build.VERSION.SDK_INT >= 31 ? Api31Impl.isMock(location) : location.isFromMockProvider();
    }
}
