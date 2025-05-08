package com.google.firebase.messaging;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.util.Base64;
import android.util.Log;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
public class FcmBroadcastProcessor {
    private static final String EXTRA_BINARY_DATA = "rawData";
    private static final String EXTRA_BINARY_DATA_BASE_64 = "gcm.rawData64";
    private static WithinAppServiceConnection fcmServiceConn;
    private static final Object lock = new Object();
    private final Context context;
    private final Executor executor = new K.d();

    public FcmBroadcastProcessor(Context context) {
        this.context = context;
    }

    private static Task<Integer> bindToMessagingService(Context context, Intent intent, boolean z5) {
        if (Log.isLoggable("FirebaseMessaging", 3)) {
            Log.d("FirebaseMessaging", "Binding to service");
        }
        WithinAppServiceConnection serviceConnection = getServiceConnection(context, "com.google.firebase.MESSAGING_EVENT");
        if (!z5) {
            return serviceConnection.sendIntent(intent).continueWith(new K.d(), new Continuation() { // from class: com.google.firebase.messaging.f
                @Override // com.google.android.gms.tasks.Continuation
                public final Object then(Task task) {
                    Integer lambda$bindToMessagingService$3;
                    lambda$bindToMessagingService$3 = FcmBroadcastProcessor.lambda$bindToMessagingService$3(task);
                    return lambda$bindToMessagingService$3;
                }
            });
        }
        if (ServiceStarter.getInstance().hasWakeLockPermission(context)) {
            WakeLockHolder.sendWakefulServiceIntent(context, serviceConnection, intent);
        } else {
            serviceConnection.sendIntent(intent);
        }
        return Tasks.forResult(-1);
    }

    private static WithinAppServiceConnection getServiceConnection(Context context, String str) {
        WithinAppServiceConnection withinAppServiceConnection;
        synchronized (lock) {
            try {
                if (fcmServiceConn == null) {
                    fcmServiceConn = new WithinAppServiceConnection(context, str);
                }
                withinAppServiceConnection = fcmServiceConn;
            } catch (Throwable th) {
                throw th;
            }
        }
        return withinAppServiceConnection;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Integer lambda$bindToMessagingService$3(Task task) {
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Integer lambda$startMessagingService$0(Context context, Intent intent) {
        return Integer.valueOf(ServiceStarter.getInstance().startMessagingService(context, intent));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Integer lambda$startMessagingService$1(Task task) {
        return 403;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Task lambda$startMessagingService$2(Context context, Intent intent, boolean z5, Task task) {
        return (PlatformVersion.isAtLeastO() && ((Integer) task.getResult()).intValue() == 402) ? bindToMessagingService(context, intent, z5).continueWith(new K.d(), new Continuation() { // from class: com.google.firebase.messaging.e
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task2) {
                Integer lambda$startMessagingService$1;
                lambda$startMessagingService$1 = FcmBroadcastProcessor.lambda$startMessagingService$1(task2);
                return lambda$startMessagingService$1;
            }
        }) : task;
    }

    public Task<Integer> process(Intent intent) {
        String stringExtra = intent.getStringExtra(EXTRA_BINARY_DATA_BASE_64);
        if (stringExtra != null) {
            intent.putExtra(EXTRA_BINARY_DATA, Base64.decode(stringExtra, 0));
            intent.removeExtra(EXTRA_BINARY_DATA_BASE_64);
        }
        return startMessagingService(this.context, intent);
    }

    @SuppressLint({"InlinedApi"})
    public Task<Integer> startMessagingService(final Context context, final Intent intent) {
        boolean z5 = PlatformVersion.isAtLeastO() && context.getApplicationInfo().targetSdkVersion >= 26;
        final boolean z6 = (intent.getFlags() & 268435456) != 0;
        return (!z5 || z6) ? Tasks.call(this.executor, new Callable() { // from class: com.google.firebase.messaging.c
            @Override // java.util.concurrent.Callable
            public final Object call() {
                Integer lambda$startMessagingService$0;
                lambda$startMessagingService$0 = FcmBroadcastProcessor.lambda$startMessagingService$0(context, intent);
                return lambda$startMessagingService$0;
            }
        }).continueWithTask(this.executor, new Continuation() { // from class: com.google.firebase.messaging.d
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task) {
                Task lambda$startMessagingService$2;
                lambda$startMessagingService$2 = FcmBroadcastProcessor.lambda$startMessagingService$2(context, intent, z6, task);
                return lambda$startMessagingService$2;
            }
        }) : bindToMessagingService(context, intent, z6);
    }
}
