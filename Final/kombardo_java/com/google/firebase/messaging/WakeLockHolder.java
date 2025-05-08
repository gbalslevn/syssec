package com.google.firebase.messaging;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.stats.WakeLock;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import java.util.concurrent.TimeUnit;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public abstract class WakeLockHolder {
    private static final String EXTRA_WAKEFUL_INTENT = "com.google.firebase.iid.WakeLockHolder.wakefulintent";
    static final long WAKE_LOCK_ACQUIRE_TIMEOUT_MILLIS = TimeUnit.MINUTES.toMillis(1);
    private static final Object syncObject = new Object();
    private static WakeLock wakeLock;

    private static void checkAndInitWakeLock(Context context) {
        if (wakeLock == null) {
            WakeLock wakeLock2 = new WakeLock(context, 1, "wake:com.google.firebase.iid.WakeLockHolder");
            wakeLock = wakeLock2;
            wakeLock2.setReferenceCounted(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void completeWakefulIntent(Intent intent) {
        synchronized (syncObject) {
            try {
                if (wakeLock != null && isWakefulIntent(intent)) {
                    setAsWakefulIntent(intent, false);
                    wakeLock.release();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    static boolean isWakefulIntent(Intent intent) {
        return intent.getBooleanExtra(EXTRA_WAKEFUL_INTENT, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SuppressLint({"TaskMainThread"})
    public static void sendWakefulServiceIntent(Context context, WithinAppServiceConnection withinAppServiceConnection, final Intent intent) {
        synchronized (syncObject) {
            try {
                checkAndInitWakeLock(context);
                boolean isWakefulIntent = isWakefulIntent(intent);
                setAsWakefulIntent(intent, true);
                if (!isWakefulIntent) {
                    wakeLock.acquire(WAKE_LOCK_ACQUIRE_TIMEOUT_MILLIS);
                }
                withinAppServiceConnection.sendIntent(intent).addOnCompleteListener(new OnCompleteListener() { // from class: com.google.firebase.messaging.B
                    @Override // com.google.android.gms.tasks.OnCompleteListener
                    public final void onComplete(Task task) {
                        WakeLockHolder.completeWakefulIntent(intent);
                    }
                });
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private static void setAsWakefulIntent(Intent intent, boolean z5) {
        intent.putExtra(EXTRA_WAKEFUL_INTENT, z5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ComponentName startWakefulService(Context context, Intent intent) {
        synchronized (syncObject) {
            try {
                checkAndInitWakeLock(context);
                boolean isWakefulIntent = isWakefulIntent(intent);
                setAsWakefulIntent(intent, true);
                ComponentName startService = context.startService(intent);
                if (startService == null) {
                    return null;
                }
                if (!isWakefulIntent) {
                    wakeLock.acquire(WAKE_LOCK_ACQUIRE_TIMEOUT_MILLIS);
                }
                return startService;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
