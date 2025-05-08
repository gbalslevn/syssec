package com.google.accompanist.permissions;

import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\bg\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00058&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\n\u001a\u00020\u00058&X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0007ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u000bÀ\u0006\u0001"}, d2 = {"Lcom/google/accompanist/permissions/MultiplePermissionsState;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "launchMultiplePermissionRequest", "()V", BuildConfig.FLAVOR, "getAllPermissionsGranted", "()Z", "allPermissionsGranted", "getShouldShowRationale", "shouldShowRationale", "permissions_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public interface MultiplePermissionsState {
    boolean getAllPermissionsGranted();

    boolean getShouldShowRationale();

    void launchMultiplePermissionRequest();
}
