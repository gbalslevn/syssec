package com.google.firebase.analytics;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Keep;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzed;
import com.google.android.gms.measurement.internal.zzlm;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.installations.FirebaseInstallations;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: classes2.dex */
public final class FirebaseAnalytics {
    private static volatile FirebaseAnalytics zza;
    private final zzed zzb;
    private ExecutorService zzc;

    private FirebaseAnalytics(zzed zzedVar) {
        Preconditions.checkNotNull(zzedVar);
        this.zzb = zzedVar;
    }

    @Keep
    public static FirebaseAnalytics getInstance(Context context) {
        if (zza == null) {
            synchronized (FirebaseAnalytics.class) {
                try {
                    if (zza == null) {
                        zza = new FirebaseAnalytics(zzed.zza(context));
                    }
                } finally {
                }
            }
        }
        return zza;
    }

    @Keep
    public static zzlm getScionFrontendApiImplementation(Context context, Bundle bundle) {
        zzed zza2 = zzed.zza(context, (String) null, (String) null, (String) null, bundle);
        if (zza2 == null) {
            return null;
        }
        return new zzc(zza2);
    }

    @Keep
    public final String getFirebaseInstanceId() {
        try {
            return (String) Tasks.await(FirebaseInstallations.getInstance().getId(), 30000L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e5) {
            throw new IllegalStateException(e5);
        } catch (ExecutionException e6) {
            throw new IllegalStateException(e6.getCause());
        } catch (TimeoutException unused) {
            throw new IllegalThreadStateException("Firebase Installations getId Task has timed out.");
        }
    }

    public final void logEvent(String str, Bundle bundle) {
        this.zzb.zza(str, bundle);
    }

    @Keep
    @Deprecated
    public final void setCurrentScreen(Activity activity, String str, String str2) {
        this.zzb.zza(activity, str, str2);
    }

    public final void setUserId(String str) {
        this.zzb.zzd(str);
    }

    public final void setUserProperty(String str, String str2) {
        this.zzb.zzb(str, str2);
    }
}
