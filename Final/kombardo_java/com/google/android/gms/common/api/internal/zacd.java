package com.google.android.gms.common.api.internal;

import android.os.SystemClock;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.ConnectionTelemetryConfiguration;
import com.google.android.gms.common.internal.MethodInvocation;
import com.google.android.gms.common.internal.RootTelemetryConfigManager;
import com.google.android.gms.common.internal.RootTelemetryConfiguration;
import com.google.android.gms.common.util.ArrayUtils;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zacd implements OnCompleteListener {
    private final GoogleApiManager zaa;
    private final int zab;
    private final ApiKey zac;
    private final long zad;
    private final long zae;

    zacd(GoogleApiManager googleApiManager, int i5, ApiKey apiKey, long j5, long j6, String str, String str2) {
        this.zaa = googleApiManager;
        this.zab = i5;
        this.zac = apiKey;
        this.zad = j5;
        this.zae = j6;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zacd zaa(GoogleApiManager googleApiManager, int i5, ApiKey apiKey) {
        boolean z5;
        if (!googleApiManager.zaD()) {
            return null;
        }
        RootTelemetryConfiguration config = RootTelemetryConfigManager.getInstance().getConfig();
        if (config == null) {
            z5 = true;
        } else {
            if (!config.getMethodInvocationTelemetryEnabled()) {
                return null;
            }
            z5 = config.getMethodTimingTelemetryEnabled();
            zabq zai = googleApiManager.zai(apiKey);
            if (zai != null) {
                if (!(zai.zaf() instanceof BaseGmsClient)) {
                    return null;
                }
                BaseGmsClient baseGmsClient = (BaseGmsClient) zai.zaf();
                if (baseGmsClient.hasConnectionInfo() && !baseGmsClient.isConnecting()) {
                    ConnectionTelemetryConfiguration zab = zab(zai, baseGmsClient, i5);
                    if (zab == null) {
                        return null;
                    }
                    zai.zaq();
                    z5 = zab.getMethodTimingTelemetryEnabled();
                }
            }
        }
        return new zacd(googleApiManager, i5, apiKey, z5 ? System.currentTimeMillis() : 0L, z5 ? SystemClock.elapsedRealtime() : 0L, null, null);
    }

    private static ConnectionTelemetryConfiguration zab(zabq zabqVar, BaseGmsClient baseGmsClient, int i5) {
        int[] methodInvocationMethodKeyAllowlist;
        int[] methodInvocationMethodKeyDisallowlist;
        ConnectionTelemetryConfiguration telemetryConfiguration = baseGmsClient.getTelemetryConfiguration();
        if (telemetryConfiguration == null || !telemetryConfiguration.getMethodInvocationTelemetryEnabled() || ((methodInvocationMethodKeyAllowlist = telemetryConfiguration.getMethodInvocationMethodKeyAllowlist()) != null ? !ArrayUtils.contains(methodInvocationMethodKeyAllowlist, i5) : !((methodInvocationMethodKeyDisallowlist = telemetryConfiguration.getMethodInvocationMethodKeyDisallowlist()) == null || !ArrayUtils.contains(methodInvocationMethodKeyDisallowlist, i5))) || zabqVar.zac() >= telemetryConfiguration.getMaxMethodInvocationsLogged()) {
            return null;
        }
        return telemetryConfiguration;
    }

    @Override // com.google.android.gms.tasks.OnCompleteListener
    public final void onComplete(Task task) {
        zabq zai;
        int i5;
        int i6;
        int i7;
        int errorCode;
        long j5;
        long j6;
        int i8;
        if (this.zaa.zaD()) {
            RootTelemetryConfiguration config = RootTelemetryConfigManager.getInstance().getConfig();
            if ((config == null || config.getMethodInvocationTelemetryEnabled()) && (zai = this.zaa.zai(this.zac)) != null && (zai.zaf() instanceof BaseGmsClient)) {
                BaseGmsClient baseGmsClient = (BaseGmsClient) zai.zaf();
                int i9 = 0;
                boolean z5 = this.zad > 0;
                int gCoreServiceId = baseGmsClient.getGCoreServiceId();
                int i10 = 100;
                if (config != null) {
                    z5 &= config.getMethodTimingTelemetryEnabled();
                    int batchPeriodMillis = config.getBatchPeriodMillis();
                    int maxMethodInvocationsInBatch = config.getMaxMethodInvocationsInBatch();
                    i5 = config.getVersion();
                    if (baseGmsClient.hasConnectionInfo() && !baseGmsClient.isConnecting()) {
                        ConnectionTelemetryConfiguration zab = zab(zai, baseGmsClient, this.zab);
                        if (zab == null) {
                            return;
                        }
                        boolean z6 = zab.getMethodTimingTelemetryEnabled() && this.zad > 0;
                        maxMethodInvocationsInBatch = zab.getMaxMethodInvocationsLogged();
                        z5 = z6;
                    }
                    i7 = batchPeriodMillis;
                    i6 = maxMethodInvocationsInBatch;
                } else {
                    i5 = 0;
                    i6 = 100;
                    i7 = 5000;
                }
                GoogleApiManager googleApiManager = this.zaa;
                if (task.isSuccessful()) {
                    errorCode = 0;
                } else {
                    if (!task.isCanceled()) {
                        Exception exception = task.getException();
                        if (exception instanceof ApiException) {
                            Status status = ((ApiException) exception).getStatus();
                            i10 = status.getStatusCode();
                            ConnectionResult connectionResult = status.getConnectionResult();
                            if (connectionResult != null) {
                                errorCode = connectionResult.getErrorCode();
                                i9 = i10;
                            }
                        } else {
                            i9 = 101;
                            errorCode = -1;
                        }
                    }
                    i9 = i10;
                    errorCode = -1;
                }
                if (z5) {
                    long j7 = this.zad;
                    long j8 = this.zae;
                    long currentTimeMillis = System.currentTimeMillis();
                    i8 = (int) (SystemClock.elapsedRealtime() - j8);
                    j6 = currentTimeMillis;
                    j5 = j7;
                } else {
                    j5 = 0;
                    j6 = 0;
                    i8 = -1;
                }
                googleApiManager.zaw(new MethodInvocation(this.zab, i9, errorCode, j5, j6, null, null, gCoreServiceId, i8), i5, i7, i6);
            }
        }
    }
}
