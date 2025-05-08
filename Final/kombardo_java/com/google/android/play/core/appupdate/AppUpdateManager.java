package com.google.android.play.core.appupdate;

import android.app.Activity;
import com.google.android.gms.tasks.Task;
import com.google.android.play.core.install.InstallStateUpdatedListener;

/* loaded from: classes.dex */
public interface AppUpdateManager {
    Task<Void> completeUpdate();

    Task<AppUpdateInfo> getAppUpdateInfo();

    void registerListener(InstallStateUpdatedListener installStateUpdatedListener);

    @Deprecated
    boolean startUpdateFlowForResult(AppUpdateInfo appUpdateInfo, int i5, Activity activity, int i6);

    void unregisterListener(InstallStateUpdatedListener installStateUpdatedListener);
}
