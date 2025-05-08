package com.facebook.appevents.gps.ara;

import android.adservices.measurement.MeasurementManager;
import android.annotation.TargetApi;
import android.content.Context;
import android.support.v4.media.session.a;
import android.util.Log;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEvent;
import com.facebook.appevents.gps.ara.GpsAraTriggersManager;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0005\u0010\u0003J\u000f\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\r\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u000f\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\u000f\u0010\u000eR\u0016\u0010\u0010\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\t8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\t8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0014\u0010\u0013¨\u0006\u0015"}, d2 = {"Lcom/facebook/appevents/gps/ara/GpsAraTriggersManager;", BuildConfig.FLAVOR, "<init>", "()V", BuildConfig.FLAVOR, "enable", BuildConfig.FLAVOR, "canRegisterTrigger", "()Z", BuildConfig.FLAVOR, "applicationId", "Lcom/facebook/appevents/AppEvent;", "event", "registerTriggerAsync", "(Ljava/lang/String;Lcom/facebook/appevents/AppEvent;)V", "registerTrigger", "enabled", "Z", "TAG", "Ljava/lang/String;", "SERVER_URI", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final class GpsAraTriggersManager {
    public static final GpsAraTriggersManager INSTANCE = new GpsAraTriggersManager();
    private static final String SERVER_URI = "https://www.facebook.com/privacy_sandbox/mobile/register/trigger";
    private static final String TAG;
    private static boolean enabled;

    static {
        String cls = GpsAraTriggersManager.class.toString();
        Intrinsics.checkNotNullExpressionValue(cls, "GpsAraTriggersManager::class.java.toString()");
        TAG = cls;
    }

    private GpsAraTriggersManager() {
    }

    private final boolean canRegisterTrigger() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return false;
        }
        try {
            return enabled;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return false;
        }
    }

    public static final void enable() {
        if (CrashShieldHandler.isObjectCrashing(GpsAraTriggersManager.class)) {
            return;
        }
        try {
            enabled = true;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, GpsAraTriggersManager.class);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: registerTriggerAsync$lambda-0, reason: not valid java name */
    public static final void m2825registerTriggerAsync$lambda0(String applicationId, AppEvent event) {
        if (CrashShieldHandler.isObjectCrashing(GpsAraTriggersManager.class)) {
            return;
        }
        try {
            Intrinsics.checkNotNullParameter(applicationId, "$applicationId");
            Intrinsics.checkNotNullParameter(event, "$event");
            INSTANCE.registerTrigger(applicationId, event);
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, GpsAraTriggersManager.class);
        }
    }

    @TargetApi(34)
    public final void registerTrigger(String applicationId, AppEvent event) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            Intrinsics.checkNotNullParameter(applicationId, "applicationId");
            Intrinsics.checkNotNullParameter(event, "event");
            if (canRegisterTrigger()) {
                Context applicationContext = FacebookSdk.getApplicationContext();
                try {
                    try {
                        try {
                            a.a(applicationContext.getSystemService(MeasurementManager.class));
                            MeasurementManager.get(applicationContext.getApplicationContext());
                            Log.w(TAG, "FAILURE_GET_MEASUREMENT_MANAGER");
                        } catch (NoSuchMethodError unused) {
                            Log.w(TAG, "FAILURE_TRIGGER_REGISTRATION_NO_METHOD_FOUND");
                        }
                    } catch (NoClassDefFoundError unused2) {
                        Log.w(TAG, "FAILURE_TRIGGER_REGISTRATION_NO_CLASS_FOUND");
                    }
                } catch (Exception unused3) {
                    Log.w(TAG, "FAILURE_TRIGGER_REGISTRATION_FAILED");
                }
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    public final void registerTriggerAsync(final String applicationId, final AppEvent event) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            Intrinsics.checkNotNullParameter(applicationId, "applicationId");
            Intrinsics.checkNotNullParameter(event, "event");
            FacebookSdk.getExecutor().execute(new Runnable() { // from class: i0.a
                @Override // java.lang.Runnable
                public final void run() {
                    GpsAraTriggersManager.m2825registerTriggerAsync$lambda0(applicationId, event);
                }
            });
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }
}
