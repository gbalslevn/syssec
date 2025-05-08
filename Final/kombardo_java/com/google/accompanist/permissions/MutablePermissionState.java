package com.google.accompanist.permissions;

import android.app.Activity;
import android.content.Context;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.view.result.ActivityResultLauncher;
import com.google.accompanist.permissions.PermissionStatus;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0001\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u0010\u001a\u00020\rH\u0000¢\u0006\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0003\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0014R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0015R+\u0010\u001c\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\n8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\f\"\u0004\b\u001a\u0010\u001bR*\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u001d8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#¨\u0006$"}, d2 = {"Lcom/google/accompanist/permissions/MutablePermissionState;", "Lcom/google/accompanist/permissions/PermissionState;", BuildConfig.FLAVOR, "permission", "Landroid/content/Context;", "context", "Landroid/app/Activity;", "activity", "<init>", "(Ljava/lang/String;Landroid/content/Context;Landroid/app/Activity;)V", "Lcom/google/accompanist/permissions/PermissionStatus;", "getPermissionStatus", "()Lcom/google/accompanist/permissions/PermissionStatus;", BuildConfig.FLAVOR, "refreshPermissionStatus$permissions_release", "()V", "refreshPermissionStatus", "Ljava/lang/String;", "getPermission", "()Ljava/lang/String;", "Landroid/content/Context;", "Landroid/app/Activity;", "<set-?>", "status$delegate", "Landroidx/compose/runtime/MutableState;", "getStatus", "setStatus", "(Lcom/google/accompanist/permissions/PermissionStatus;)V", "status", "Landroidx/activity/result/ActivityResultLauncher;", "launcher", "Landroidx/activity/result/ActivityResultLauncher;", "getLauncher$permissions_release", "()Landroidx/activity/result/ActivityResultLauncher;", "setLauncher$permissions_release", "(Landroidx/activity/result/ActivityResultLauncher;)V", "permissions_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class MutablePermissionState implements PermissionState {
    private final Activity activity;
    private final Context context;
    private ActivityResultLauncher<String> launcher;
    private final String permission;

    /* renamed from: status$delegate, reason: from kotlin metadata */
    private final MutableState status;

    public MutablePermissionState(String permission, Context context, Activity activity) {
        MutableState mutableStateOf$default;
        Intrinsics.checkNotNullParameter(permission, "permission");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.permission = permission;
        this.context = context;
        this.activity = activity;
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(getPermissionStatus(), null, 2, null);
        this.status = mutableStateOf$default;
    }

    private final PermissionStatus getPermissionStatus() {
        return PermissionsUtilKt.checkPermission(this.context, getPermission()) ? PermissionStatus.Granted.INSTANCE : new PermissionStatus.Denied(PermissionsUtilKt.shouldShowRationale(this.activity, getPermission()));
    }

    @Override // com.google.accompanist.permissions.PermissionState
    public String getPermission() {
        return this.permission;
    }

    @Override // com.google.accompanist.permissions.PermissionState
    public PermissionStatus getStatus() {
        return (PermissionStatus) this.status.getValue();
    }

    public final void refreshPermissionStatus$permissions_release() {
        setStatus(getPermissionStatus());
    }

    public final void setLauncher$permissions_release(ActivityResultLauncher<String> activityResultLauncher) {
        this.launcher = activityResultLauncher;
    }

    public void setStatus(PermissionStatus permissionStatus) {
        Intrinsics.checkNotNullParameter(permissionStatus, "<set-?>");
        this.status.setValue(permissionStatus);
    }
}
