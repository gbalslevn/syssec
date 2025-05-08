package dagger.hilt.android.internal;

import android.os.Looper;

/* loaded from: classes2.dex */
public abstract class ThreadUtil {
    private static Thread mainThread;

    public static void ensureMainThread() {
        if (!isMainThread()) {
            throw new IllegalStateException("Must be called on the Main thread.");
        }
    }

    public static boolean isMainThread() {
        if (mainThread == null) {
            mainThread = Looper.getMainLooper().getThread();
        }
        return Thread.currentThread() == mainThread;
    }
}
