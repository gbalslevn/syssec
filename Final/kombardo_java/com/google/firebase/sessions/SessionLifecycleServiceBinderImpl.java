package com.google.firebase.sessions;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Messenger;
import android.os.Process;
import android.util.Log;
import com.google.firebase.FirebaseApp;
import com.sun.jna.Callback;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\nH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/google/firebase/sessions/SessionLifecycleServiceBinderImpl;", "Lcom/google/firebase/sessions/SessionLifecycleServiceBinder;", "firebaseApp", "Lcom/google/firebase/FirebaseApp;", "(Lcom/google/firebase/FirebaseApp;)V", "bindToService", BuildConfig.FLAVOR, Callback.METHOD_NAME, "Landroid/os/Messenger;", "serviceConnection", "Landroid/content/ServiceConnection;", "unbindServiceSafely", BuildConfig.FLAVOR, "appContext", "Landroid/content/Context;", "Companion", "com.google.firebase-firebase-sessions"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SessionLifecycleServiceBinderImpl implements SessionLifecycleServiceBinder {
    private static final Companion Companion = new Companion(null);
    private final FirebaseApp firebaseApp;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/google/firebase/sessions/SessionLifecycleServiceBinderImpl$Companion;", BuildConfig.FLAVOR, "()V", "TAG", BuildConfig.FLAVOR, "com.google.firebase-firebase-sessions"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes2.dex */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public SessionLifecycleServiceBinderImpl(FirebaseApp firebaseApp) {
        Intrinsics.checkNotNullParameter(firebaseApp, "firebaseApp");
        this.firebaseApp = firebaseApp;
    }

    private final Object unbindServiceSafely(Context appContext, ServiceConnection serviceConnection) {
        try {
            appContext.unbindService(serviceConnection);
            return Unit.INSTANCE;
        } catch (IllegalArgumentException e5) {
            return Integer.valueOf(Log.w("LifecycleServiceBinder", "Session lifecycle service binding failed.", e5));
        }
    }

    @Override // com.google.firebase.sessions.SessionLifecycleServiceBinder
    public void bindToService(Messenger callback, ServiceConnection serviceConnection) {
        boolean z5;
        Intrinsics.checkNotNullParameter(callback, "callback");
        Intrinsics.checkNotNullParameter(serviceConnection, "serviceConnection");
        Context applicationContext = this.firebaseApp.getApplicationContext().getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "firebaseApp.applicationContext.applicationContext");
        Intent intent = new Intent(applicationContext, (Class<?>) SessionLifecycleService.class);
        Log.d("LifecycleServiceBinder", "Binding service to application.");
        intent.setAction(String.valueOf(Process.myPid()));
        intent.putExtra("ClientCallbackMessenger", callback);
        intent.setPackage(applicationContext.getPackageName());
        try {
            z5 = applicationContext.bindService(intent, serviceConnection, 65);
        } catch (SecurityException e5) {
            Log.w("LifecycleServiceBinder", "Failed to bind session lifecycle service to application.", e5);
            z5 = false;
        }
        if (z5) {
            return;
        }
        unbindServiceSafely(applicationContext, serviceConnection);
        Log.i("LifecycleServiceBinder", "Session lifecycle service binding failed.");
    }
}
