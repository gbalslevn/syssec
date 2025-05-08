package com.google.android.play.core.appupdate;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.tasks.Task;
import com.google.android.play.core.common.IntentSenderForResultStarter;
import com.google.android.play.core.install.InstallStateUpdatedListener;

/* loaded from: classes.dex */
final class zzg implements AppUpdateManager {
    private final zzr zza;
    private final zzc zzb;
    private final Context zzc;
    private final Handler zzd = new Handler(Looper.getMainLooper());

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzg(zzr zzrVar, zzc zzcVar, Context context) {
        this.zza = zzrVar;
        this.zzb = zzcVar;
        this.zzc = context;
    }

    @Override // com.google.android.play.core.appupdate.AppUpdateManager
    public final Task<Void> completeUpdate() {
        return this.zza.zzd(this.zzc.getPackageName());
    }

    @Override // com.google.android.play.core.appupdate.AppUpdateManager
    public final Task<AppUpdateInfo> getAppUpdateInfo() {
        return this.zza.zze(this.zzc.getPackageName());
    }

    @Override // com.google.android.play.core.appupdate.AppUpdateManager
    public final synchronized void registerListener(InstallStateUpdatedListener installStateUpdatedListener) {
        this.zzb.zzb(installStateUpdatedListener);
    }

    @Override // com.google.android.play.core.appupdate.AppUpdateManager
    public final boolean startUpdateFlowForResult(AppUpdateInfo appUpdateInfo, int i5, Activity activity, int i6) {
        AppUpdateOptions defaultOptions = AppUpdateOptions.defaultOptions(i5);
        if (activity == null) {
            return false;
        }
        return startUpdateFlowForResult(appUpdateInfo, new zzf(this, activity), defaultOptions, i6);
    }

    @Override // com.google.android.play.core.appupdate.AppUpdateManager
    public final synchronized void unregisterListener(InstallStateUpdatedListener installStateUpdatedListener) {
        this.zzb.zzc(installStateUpdatedListener);
    }

    public final boolean startUpdateFlowForResult(AppUpdateInfo appUpdateInfo, IntentSenderForResultStarter intentSenderForResultStarter, AppUpdateOptions appUpdateOptions, int i5) {
        if (appUpdateInfo == null || intentSenderForResultStarter == null || appUpdateOptions == null || !appUpdateInfo.isUpdateTypeAllowed(appUpdateOptions) || appUpdateInfo.zzd()) {
            return false;
        }
        appUpdateInfo.zzc();
        intentSenderForResultStarter.startIntentSenderForResult(appUpdateInfo.zza(appUpdateOptions).getIntentSender(), i5, null, 0, 0, 0, null);
        return true;
    }
}
