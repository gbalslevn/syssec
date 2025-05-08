package com.facebook.appevents;

import android.preference.PreferenceManager;
import android.util.Log;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AnalyticsUserIDStore;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0005\u0010\u0003J\u0011\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\t\u0010\u0003R\u001c\u0010\u000b\u001a\n \n*\u0004\u0018\u00010\u00060\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u00068\u0002X\u0082T¢\u0006\u0006\n\u0004\b\r\u0010\fR\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\fR\u0016\u0010\u0013\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/facebook/appevents/AnalyticsUserIDStore;", BuildConfig.FLAVOR, "<init>", "()V", BuildConfig.FLAVOR, "initStore", BuildConfig.FLAVOR, "getUserID", "()Ljava/lang/String;", "initAndWait", "kotlin.jvm.PlatformType", "TAG", "Ljava/lang/String;", "ANALYTICS_USER_ID_KEY", "Ljava/util/concurrent/locks/ReentrantReadWriteLock;", "lock", "Ljava/util/concurrent/locks/ReentrantReadWriteLock;", "userID", BuildConfig.FLAVOR, "initialized", "Z", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final class AnalyticsUserIDStore {
    private static final String ANALYTICS_USER_ID_KEY = "com.facebook.appevents.AnalyticsUserIDStore.userID";
    private static volatile boolean initialized;
    private static String userID;
    public static final AnalyticsUserIDStore INSTANCE = new AnalyticsUserIDStore();
    private static final String TAG = AnalyticsUserIDStore.class.getSimpleName();
    private static final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    private AnalyticsUserIDStore() {
    }

    public static final String getUserID() {
        if (!initialized) {
            Log.w(TAG, "initStore should have been called before calling setUserID");
            INSTANCE.initAndWait();
        }
        ReentrantReadWriteLock reentrantReadWriteLock = lock;
        reentrantReadWriteLock.readLock().lock();
        try {
            String str = userID;
            reentrantReadWriteLock.readLock().unlock();
            return str;
        } catch (Throwable th) {
            lock.readLock().unlock();
            throw th;
        }
    }

    private final void initAndWait() {
        if (initialized) {
            return;
        }
        ReentrantReadWriteLock reentrantReadWriteLock = lock;
        reentrantReadWriteLock.writeLock().lock();
        try {
            if (initialized) {
                reentrantReadWriteLock.writeLock().unlock();
                return;
            }
            userID = PreferenceManager.getDefaultSharedPreferences(FacebookSdk.getApplicationContext()).getString(ANALYTICS_USER_ID_KEY, null);
            initialized = true;
            reentrantReadWriteLock.writeLock().unlock();
        } catch (Throwable th) {
            lock.writeLock().unlock();
            throw th;
        }
    }

    public static final void initStore() {
        if (initialized) {
            return;
        }
        InternalAppEventsLogger.INSTANCE.getAnalyticsExecutor().execute(new Runnable() { // from class: e0.a
            @Override // java.lang.Runnable
            public final void run() {
                AnalyticsUserIDStore.m2788initStore$lambda0();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: initStore$lambda-0, reason: not valid java name */
    public static final void m2788initStore$lambda0() {
        INSTANCE.initAndWait();
    }
}
