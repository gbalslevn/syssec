package com.google.firebase.messaging;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayDeque;
import java.util.Queue;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class FcmLifecycleCallbacks implements Application.ActivityLifecycleCallbacks {
    private static final int RECENTLY_LOGGED_MESSAGE_IDS_MAX_SIZE = 10;
    private final Queue<String> recentlyLoggedMessageIds = new ArrayDeque(10);

    private void logNotificationOpen(Intent intent) {
        Bundle bundle = null;
        try {
            Bundle extras = intent.getExtras();
            if (extras != null) {
                String messageId = MessagingAnalytics.getMessageId(extras);
                if (!TextUtils.isEmpty(messageId)) {
                    if (this.recentlyLoggedMessageIds.contains(messageId)) {
                        return;
                    } else {
                        this.recentlyLoggedMessageIds.add(messageId);
                    }
                }
                bundle = extras.getBundle("gcm.n.analytics_data");
            }
        } catch (RuntimeException e5) {
            Log.w("FirebaseMessaging", "Failed trying to get analytics data from Intent extras.", e5);
        }
        if (MessagingAnalytics.shouldUploadScionMetrics(bundle)) {
            MessagingAnalytics.logNotificationOpen(bundle);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    @SuppressLint({"ThreadPoolCreation"})
    public void onActivityCreated(Activity activity, Bundle bundle) {
        Intent intent = activity.getIntent();
        if (intent == null) {
            return;
        }
        logNotificationOpen(intent);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
    }
}
