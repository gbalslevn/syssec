package com.google.firebase.messaging;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.tasks.OnSuccessListener;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public abstract class ProxyNotificationPreferences {
    private static final String FCM_PREFERENCES = "com.google.firebase.messaging";

    private static SharedPreferences getPreference(Context context) {
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            context = applicationContext;
        }
        return context.getSharedPreferences(FCM_PREFERENCES, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isProxyNotificationInitialized(Context context) {
        return getPreference(context).getBoolean("proxy_notification_initialized", false);
    }

    static boolean isProxyNotificationRetentionSet(SharedPreferences sharedPreferences, boolean z5) {
        return sharedPreferences.contains("proxy_retention") && sharedPreferences.getBoolean("proxy_retention", false) == z5;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setProxyNotificationsInitialized(Context context, boolean z5) {
        SharedPreferences.Editor edit = getPreference(context).edit();
        edit.putBoolean("proxy_notification_initialized", z5);
        edit.apply();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setProxyRetention(final Context context, GmsRpc gmsRpc, final boolean z5) {
        if (PlatformVersion.isAtLeastQ() && !isProxyNotificationRetentionSet(getPreference(context), z5)) {
            gmsRpc.setRetainProxiedNotifications(z5).addOnSuccessListener(new K.d(), new OnSuccessListener() { // from class: com.google.firebase.messaging.x
                @Override // com.google.android.gms.tasks.OnSuccessListener
                public final void onSuccess(Object obj) {
                    ProxyNotificationPreferences.setProxyRetentionPreferences(context, z5);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setProxyRetentionPreferences(Context context, boolean z5) {
        SharedPreferences.Editor edit = getPreference(context).edit();
        edit.putBoolean("proxy_retention", z5);
        edit.apply();
    }
}
