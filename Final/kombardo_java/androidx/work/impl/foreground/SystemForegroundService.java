package androidx.work.impl.foreground;

import android.app.ForegroundServiceStartNotAllowedException;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.os.Build;
import androidx.lifecycle.LifecycleService;
import androidx.work.Logger;
import androidx.work.impl.foreground.SystemForegroundDispatcher;

/* loaded from: classes.dex */
public class SystemForegroundService extends LifecycleService implements SystemForegroundDispatcher.Callback {
    private static final String TAG = Logger.tagWithPrefix("SystemFgService");
    private static SystemForegroundService sForegroundService = null;
    SystemForegroundDispatcher mDispatcher;
    private boolean mIsShutdown;
    NotificationManager mNotificationManager;

    /* loaded from: classes.dex */
    static class Api29Impl {
        static void startForeground(Service service, int i5, Notification notification, int i6) {
            service.startForeground(i5, notification, i6);
        }
    }

    /* loaded from: classes.dex */
    static class Api31Impl {
        static void startForeground(Service service, int i5, Notification notification, int i6) {
            try {
                service.startForeground(i5, notification, i6);
            } catch (ForegroundServiceStartNotAllowedException e5) {
                Logger.get().warning(SystemForegroundService.TAG, "Unable to start foreground service", e5);
            } catch (SecurityException e6) {
                Logger.get().warning(SystemForegroundService.TAG, "Unable to start foreground service", e6);
            }
        }
    }

    private void initializeDispatcher() {
        this.mNotificationManager = (NotificationManager) getApplicationContext().getSystemService("notification");
        SystemForegroundDispatcher systemForegroundDispatcher = new SystemForegroundDispatcher(getApplicationContext());
        this.mDispatcher = systemForegroundDispatcher;
        systemForegroundDispatcher.setCallback(this);
    }

    @Override // androidx.work.impl.foreground.SystemForegroundDispatcher.Callback
    public void cancelNotification(int i5) {
        this.mNotificationManager.cancel(i5);
    }

    @Override // androidx.work.impl.foreground.SystemForegroundDispatcher.Callback
    public void notify(int i5, Notification notification) {
        this.mNotificationManager.notify(i5, notification);
    }

    @Override // androidx.lifecycle.LifecycleService, android.app.Service
    public void onCreate() {
        super.onCreate();
        sForegroundService = this;
        initializeDispatcher();
    }

    @Override // androidx.lifecycle.LifecycleService, android.app.Service
    public void onDestroy() {
        super.onDestroy();
        this.mDispatcher.onDestroy();
    }

    @Override // androidx.lifecycle.LifecycleService, android.app.Service
    public int onStartCommand(Intent intent, int i5, int i6) {
        super.onStartCommand(intent, i5, i6);
        if (this.mIsShutdown) {
            Logger.get().info(TAG, "Re-initializing SystemForegroundService after a request to shut-down.");
            this.mDispatcher.onDestroy();
            initializeDispatcher();
            this.mIsShutdown = false;
        }
        if (intent == null) {
            return 3;
        }
        this.mDispatcher.onStartCommand(intent);
        return 3;
    }

    @Override // android.app.Service
    public void onTimeout(int i5) {
        if (Build.VERSION.SDK_INT >= 35) {
            return;
        }
        this.mDispatcher.onTimeout(i5, 2048);
    }

    @Override // androidx.work.impl.foreground.SystemForegroundDispatcher.Callback
    public void startForeground(int i5, int i6, Notification notification) {
        int i7 = Build.VERSION.SDK_INT;
        if (i7 >= 31) {
            Api31Impl.startForeground(this, i5, notification, i6);
        } else if (i7 >= 29) {
            Api29Impl.startForeground(this, i5, notification, i6);
        } else {
            startForeground(i5, notification);
        }
    }

    @Override // androidx.work.impl.foreground.SystemForegroundDispatcher.Callback
    public void stop() {
        this.mIsShutdown = true;
        Logger.get().debug(TAG, "Shutting down.");
        stopForeground(true);
        sForegroundService = null;
        stopSelf();
    }

    public void onTimeout(int i5, int i6) {
        this.mDispatcher.onTimeout(i5, i6);
    }
}
