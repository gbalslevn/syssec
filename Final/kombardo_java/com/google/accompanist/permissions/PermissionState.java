package com.google.accompanist.permissions;

import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001R\u0014\u0010\u0005\u001a\u00020\u00028&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00068&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\nÀ\u0006\u0001"}, d2 = {"Lcom/google/accompanist/permissions/PermissionState;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "getPermission", "()Ljava/lang/String;", "permission", "Lcom/google/accompanist/permissions/PermissionStatus;", "getStatus", "()Lcom/google/accompanist/permissions/PermissionStatus;", "status", "permissions_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public interface PermissionState {
    String getPermission();

    PermissionStatus getStatus();
}
