package com.google.accompanist.permissions;

import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.view.result.ActivityResultLauncher;
import com.google.accompanist.permissions.PermissionStatus;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\b\u0007\b\u0001\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ#\u0010\u0010\u001a\u00020\u00072\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nH\u0000¢\u0006\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0011R \u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0011\u001a\u0004\b\u0014\u0010\u0015R!\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00120\u00028VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0015R\u001b\u0010\u001d\u001a\u00020\f8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u0017\u001a\u0004\b\u001b\u0010\u001cR\u001b\u0010 \u001a\u00020\f8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u0017\u001a\u0004\b\u001f\u0010\u001cR0\u0010#\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\"\u0018\u00010!8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(¨\u0006)"}, d2 = {"Lcom/google/accompanist/permissions/MutableMultiplePermissionsState;", "Lcom/google/accompanist/permissions/MultiplePermissionsState;", BuildConfig.FLAVOR, "Lcom/google/accompanist/permissions/MutablePermissionState;", "mutablePermissions", "<init>", "(Ljava/util/List;)V", BuildConfig.FLAVOR, "launchMultiplePermissionRequest", "()V", BuildConfig.FLAVOR, BuildConfig.FLAVOR, BuildConfig.FLAVOR, "permissionsStatus", "updatePermissionsStatus$permissions_release", "(Ljava/util/Map;)V", "updatePermissionsStatus", "Ljava/util/List;", "Lcom/google/accompanist/permissions/PermissionState;", "permissions", "getPermissions", "()Ljava/util/List;", "revokedPermissions$delegate", "Landroidx/compose/runtime/State;", "getRevokedPermissions", "revokedPermissions", "allPermissionsGranted$delegate", "getAllPermissionsGranted", "()Z", "allPermissionsGranted", "shouldShowRationale$delegate", "getShouldShowRationale", "shouldShowRationale", "Landroidx/activity/result/ActivityResultLauncher;", BuildConfig.FLAVOR, "launcher", "Landroidx/activity/result/ActivityResultLauncher;", "getLauncher$permissions_release", "()Landroidx/activity/result/ActivityResultLauncher;", "setLauncher$permissions_release", "(Landroidx/activity/result/ActivityResultLauncher;)V", "permissions_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class MutableMultiplePermissionsState implements MultiplePermissionsState {

    /* renamed from: allPermissionsGranted$delegate, reason: from kotlin metadata */
    private final State allPermissionsGranted;
    private ActivityResultLauncher<String[]> launcher;
    private final List<MutablePermissionState> mutablePermissions;
    private final List<PermissionState> permissions;

    /* renamed from: revokedPermissions$delegate, reason: from kotlin metadata */
    private final State revokedPermissions;

    /* renamed from: shouldShowRationale$delegate, reason: from kotlin metadata */
    private final State shouldShowRationale;

    public MutableMultiplePermissionsState(List<MutablePermissionState> mutablePermissions) {
        Intrinsics.checkNotNullParameter(mutablePermissions, "mutablePermissions");
        this.mutablePermissions = mutablePermissions;
        this.permissions = mutablePermissions;
        this.revokedPermissions = SnapshotStateKt.derivedStateOf(new Function0<List<? extends PermissionState>>() { // from class: com.google.accompanist.permissions.MutableMultiplePermissionsState$revokedPermissions$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final List<? extends PermissionState> invoke() {
                List<PermissionState> permissions = MutableMultiplePermissionsState.this.getPermissions();
                ArrayList arrayList = new ArrayList();
                for (Object obj : permissions) {
                    if (!Intrinsics.areEqual(((PermissionState) obj).getStatus(), PermissionStatus.Granted.INSTANCE)) {
                        arrayList.add(obj);
                    }
                }
                return arrayList;
            }
        });
        this.allPermissionsGranted = SnapshotStateKt.derivedStateOf(new Function0<Boolean>() { // from class: com.google.accompanist.permissions.MutableMultiplePermissionsState$allPermissionsGranted$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                boolean z5;
                List<PermissionState> permissions = MutableMultiplePermissionsState.this.getPermissions();
                if (!(permissions instanceof Collection) || !permissions.isEmpty()) {
                    Iterator<T> it = permissions.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        if (!PermissionsUtilKt.isGranted(((PermissionState) it.next()).getStatus())) {
                            if (!MutableMultiplePermissionsState.this.getRevokedPermissions().isEmpty()) {
                                z5 = false;
                            }
                        }
                    }
                }
                z5 = true;
                return Boolean.valueOf(z5);
            }
        });
        this.shouldShowRationale = SnapshotStateKt.derivedStateOf(new Function0<Boolean>() { // from class: com.google.accompanist.permissions.MutableMultiplePermissionsState$shouldShowRationale$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                List<PermissionState> permissions = MutableMultiplePermissionsState.this.getPermissions();
                boolean z5 = false;
                if (!(permissions instanceof Collection) || !permissions.isEmpty()) {
                    Iterator<T> it = permissions.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        if (PermissionsUtilKt.getShouldShowRationale(((PermissionState) it.next()).getStatus())) {
                            z5 = true;
                            break;
                        }
                    }
                }
                return Boolean.valueOf(z5);
            }
        });
    }

    @Override // com.google.accompanist.permissions.MultiplePermissionsState
    public boolean getAllPermissionsGranted() {
        return ((Boolean) this.allPermissionsGranted.getValue()).booleanValue();
    }

    public List<PermissionState> getPermissions() {
        return this.permissions;
    }

    public List<PermissionState> getRevokedPermissions() {
        return (List) this.revokedPermissions.getValue();
    }

    @Override // com.google.accompanist.permissions.MultiplePermissionsState
    public boolean getShouldShowRationale() {
        return ((Boolean) this.shouldShowRationale.getValue()).booleanValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.accompanist.permissions.MultiplePermissionsState
    public void launchMultiplePermissionRequest() {
        Unit unit;
        ActivityResultLauncher<String[]> activityResultLauncher = this.launcher;
        if (activityResultLauncher != 0) {
            List<PermissionState> permissions = getPermissions();
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(permissions, 10));
            Iterator<T> it = permissions.iterator();
            while (it.hasNext()) {
                arrayList.add(((PermissionState) it.next()).getPermission());
            }
            activityResultLauncher.launch(arrayList.toArray(new String[0]));
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            throw new IllegalStateException("ActivityResultLauncher cannot be null");
        }
    }

    public final void setLauncher$permissions_release(ActivityResultLauncher<String[]> activityResultLauncher) {
        this.launcher = activityResultLauncher;
    }

    public final void updatePermissionsStatus$permissions_release(Map<String, Boolean> permissionsStatus) {
        Object obj;
        Intrinsics.checkNotNullParameter(permissionsStatus, "permissionsStatus");
        for (String str : permissionsStatus.keySet()) {
            Iterator<T> it = this.mutablePermissions.iterator();
            while (true) {
                if (it.hasNext()) {
                    obj = it.next();
                    if (Intrinsics.areEqual(((MutablePermissionState) obj).getPermission(), str)) {
                        break;
                    }
                } else {
                    obj = null;
                    break;
                }
            }
            MutablePermissionState mutablePermissionState = (MutablePermissionState) obj;
            if (mutablePermissionState != null && permissionsStatus.get(str) != null) {
                mutablePermissionState.refreshPermissionStatus$permissions_release();
            }
        }
    }
}
