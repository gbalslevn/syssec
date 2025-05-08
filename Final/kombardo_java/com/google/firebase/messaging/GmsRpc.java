package com.google.firebase.messaging;

import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.google.android.gms.cloudmessaging.CloudMessage;
import com.google.android.gms.cloudmessaging.Rpc;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApp;
import com.google.firebase.heartbeatinfo.HeartBeatInfo;
import com.google.firebase.inject.Provider;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.installations.InstallationTokenResult;
import com.google.firebase.platforminfo.UserAgentPublisher;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.ExecutionException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class GmsRpc {
    private static final String EXTRA_DELETE = "delete";
    private static final String EXTRA_ERROR = "error";
    private static final String EXTRA_IID_OPERATION = "iid-operation";
    private static final String EXTRA_REGISTRATION_ID = "registration_id";
    private static final String EXTRA_SCOPE = "scope";
    private static final String EXTRA_SENDER = "sender";
    private static final String EXTRA_SUBTYPE = "subtype";
    private static final String EXTRA_TOPIC = "gcm.topic";
    private static final String EXTRA_UNREGISTERED = "unregistered";
    private static final String PARAM_APP_VER_CODE = "app_ver";
    private static final String PARAM_APP_VER_NAME = "app_ver_name";
    private static final String PARAM_CLIENT_VER = "cliv";
    private static final String PARAM_FIREBASE_APP_NAME_HASH = "firebase-app-name-hash";
    private static final String PARAM_FIS_AUTH_TOKEN = "Goog-Firebase-Installations-Auth";
    private static final String PARAM_GMP_APP_ID = "gmp_app_id";
    private static final String PARAM_GMS_VER = "gmsv";
    private static final String PARAM_HEARTBEAT_CODE = "Firebase-Client-Log-Type";
    private static final String PARAM_INSTANCE_ID = "appid";
    private static final String PARAM_OS_VER = "osv";
    private static final String PARAM_USER_AGENT = "Firebase-Client";
    private static final String SCOPE_ALL = "*";
    private static final String TOPIC_PREFIX = "/topics/";
    private final FirebaseApp app;
    private final FirebaseInstallationsApi firebaseInstallations;
    private final Provider<HeartBeatInfo> heartbeatInfo;
    private final Metadata metadata;
    private final Rpc rpc;
    private final Provider<UserAgentPublisher> userAgentPublisher;

    /* JADX INFO: Access modifiers changed from: package-private */
    public GmsRpc(FirebaseApp firebaseApp, Metadata metadata, Provider<UserAgentPublisher> provider, Provider<HeartBeatInfo> provider2, FirebaseInstallationsApi firebaseInstallationsApi) {
        this(firebaseApp, metadata, new Rpc(firebaseApp.getApplicationContext()), provider, provider2, firebaseInstallationsApi);
    }

    private static String base64UrlSafe(byte[] bArr) {
        return Base64.encodeToString(bArr, 11);
    }

    private Task<String> extractResponseWhenComplete(Task<Bundle> task) {
        return task.continueWith(new K.d(), new Continuation() { // from class: com.google.firebase.messaging.r
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task2) {
                String lambda$extractResponseWhenComplete$0;
                lambda$extractResponseWhenComplete$0 = GmsRpc.this.lambda$extractResponseWhenComplete$0(task2);
                return lambda$extractResponseWhenComplete$0;
            }
        });
    }

    private String getHashedFirebaseAppName() {
        try {
            return base64UrlSafe(MessageDigest.getInstance("SHA-1").digest(this.app.getName().getBytes()));
        } catch (NoSuchAlgorithmException unused) {
            return "[HASH-ERROR]";
        }
    }

    private String handleResponse(Bundle bundle) {
        if (bundle == null) {
            throw new IOException("SERVICE_NOT_AVAILABLE");
        }
        String string = bundle.getString(EXTRA_REGISTRATION_ID);
        if (string != null) {
            return string;
        }
        String string2 = bundle.getString(EXTRA_UNREGISTERED);
        if (string2 != null) {
            return string2;
        }
        String string3 = bundle.getString(EXTRA_ERROR);
        if ("RST".equals(string3)) {
            throw new IOException("INSTANCE_ID_RESET");
        }
        if (string3 != null) {
            throw new IOException(string3);
        }
        Log.w("FirebaseMessaging", "Unexpected response: " + bundle, new Throwable());
        throw new IOException("SERVICE_NOT_AVAILABLE");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isErrorMessageForRetryableError(String str) {
        return "SERVICE_NOT_AVAILABLE".equals(str) || "INTERNAL_SERVER_ERROR".equals(str) || "InternalServerError".equals(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ String lambda$extractResponseWhenComplete$0(Task task) {
        return handleResponse((Bundle) task.getResult(IOException.class));
    }

    /* JADX WARN: Removed duplicated region for block: B:17:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x00c0 A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void setDefaultAttributesToBundle(String str, String str2, Bundle bundle) {
        HeartBeatInfo heartBeatInfo;
        HeartBeatInfo.HeartBeat heartBeatCode;
        bundle.putString(EXTRA_SCOPE, str2);
        bundle.putString(EXTRA_SENDER, str);
        bundle.putString(EXTRA_SUBTYPE, str);
        bundle.putString(PARAM_GMP_APP_ID, this.app.getOptions().getApplicationId());
        bundle.putString(PARAM_GMS_VER, Integer.toString(this.metadata.getGmsVersionCode()));
        bundle.putString(PARAM_OS_VER, Integer.toString(Build.VERSION.SDK_INT));
        bundle.putString(PARAM_APP_VER_CODE, this.metadata.getAppVersionCode());
        bundle.putString(PARAM_APP_VER_NAME, this.metadata.getAppVersionName());
        bundle.putString(PARAM_FIREBASE_APP_NAME_HASH, getHashedFirebaseAppName());
        try {
            String token = ((InstallationTokenResult) Tasks.await(this.firebaseInstallations.getToken(false))).getToken();
            if (TextUtils.isEmpty(token)) {
                Log.w("FirebaseMessaging", "FIS auth token is empty");
            } else {
                bundle.putString(PARAM_FIS_AUTH_TOKEN, token);
            }
        } catch (InterruptedException e5) {
            e = e5;
            Log.e("FirebaseMessaging", "Failed to get FIS auth token", e);
            bundle.putString(PARAM_INSTANCE_ID, (String) Tasks.await(this.firebaseInstallations.getId()));
            bundle.putString(PARAM_CLIENT_VER, "fcm-24.1.0");
            heartBeatInfo = this.heartbeatInfo.get();
            UserAgentPublisher userAgentPublisher = this.userAgentPublisher.get();
            if (heartBeatInfo == null) {
                return;
            } else {
                return;
            }
        } catch (ExecutionException e6) {
            e = e6;
            Log.e("FirebaseMessaging", "Failed to get FIS auth token", e);
            bundle.putString(PARAM_INSTANCE_ID, (String) Tasks.await(this.firebaseInstallations.getId()));
            bundle.putString(PARAM_CLIENT_VER, "fcm-24.1.0");
            heartBeatInfo = this.heartbeatInfo.get();
            UserAgentPublisher userAgentPublisher2 = this.userAgentPublisher.get();
            if (heartBeatInfo == null) {
            }
        }
        bundle.putString(PARAM_INSTANCE_ID, (String) Tasks.await(this.firebaseInstallations.getId()));
        bundle.putString(PARAM_CLIENT_VER, "fcm-24.1.0");
        heartBeatInfo = this.heartbeatInfo.get();
        UserAgentPublisher userAgentPublisher22 = this.userAgentPublisher.get();
        if (heartBeatInfo == null || userAgentPublisher22 == null || (heartBeatCode = heartBeatInfo.getHeartBeatCode("fire-iid")) == HeartBeatInfo.HeartBeat.NONE) {
            return;
        }
        bundle.putString(PARAM_HEARTBEAT_CODE, Integer.toString(heartBeatCode.getCode()));
        bundle.putString(PARAM_USER_AGENT, userAgentPublisher22.getUserAgent());
    }

    private Task<Bundle> startRpc(String str, String str2, Bundle bundle) {
        try {
            setDefaultAttributesToBundle(str, str2, bundle);
            return this.rpc.send(bundle);
        } catch (InterruptedException | ExecutionException e5) {
            return Tasks.forException(e5);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Task<CloudMessage> getProxyNotificationData() {
        return this.rpc.getProxiedNotificationData();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Task<String> getToken() {
        return extractResponseWhenComplete(startRpc(Metadata.getDefaultSenderId(this.app), SCOPE_ALL, new Bundle()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Task<Void> setRetainProxiedNotifications(boolean z5) {
        return this.rpc.setRetainProxiedNotifications(z5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Task<?> subscribeToTopic(String str, String str2) {
        Bundle bundle = new Bundle();
        bundle.putString(EXTRA_TOPIC, TOPIC_PREFIX + str2);
        return extractResponseWhenComplete(startRpc(str, TOPIC_PREFIX + str2, bundle));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Task<?> unsubscribeFromTopic(String str, String str2) {
        Bundle bundle = new Bundle();
        bundle.putString(EXTRA_TOPIC, TOPIC_PREFIX + str2);
        bundle.putString(EXTRA_DELETE, "1");
        return extractResponseWhenComplete(startRpc(str, TOPIC_PREFIX + str2, bundle));
    }

    GmsRpc(FirebaseApp firebaseApp, Metadata metadata, Rpc rpc, Provider<UserAgentPublisher> provider, Provider<HeartBeatInfo> provider2, FirebaseInstallationsApi firebaseInstallationsApi) {
        this.app = firebaseApp;
        this.metadata = metadata;
        this.rpc = rpc;
        this.userAgentPublisher = provider;
        this.heartbeatInfo = provider2;
        this.firebaseInstallations = firebaseInstallationsApi;
    }
}
