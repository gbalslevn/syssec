package com.google.android.play.core.appupdate;

/* loaded from: classes.dex */
final class zzx extends AppUpdateOptions {
    private final int zza;
    private final boolean zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzx(int i5, boolean z5, zzw zzwVar) {
        this.zza = i5;
        this.zzb = z5;
    }

    @Override // com.google.android.play.core.appupdate.AppUpdateOptions
    public final boolean allowAssetPackDeletion() {
        return this.zzb;
    }

    @Override // com.google.android.play.core.appupdate.AppUpdateOptions
    public final int appUpdateType() {
        return this.zza;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof AppUpdateOptions) {
            AppUpdateOptions appUpdateOptions = (AppUpdateOptions) obj;
            if (this.zza == appUpdateOptions.appUpdateType() && this.zzb == appUpdateOptions.allowAssetPackDeletion()) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((this.zza ^ 1000003) * 1000003) ^ (true != this.zzb ? 1237 : 1231);
    }

    public final String toString() {
        return "AppUpdateOptions{appUpdateType=" + this.zza + ", allowAssetPackDeletion=" + this.zzb + "}";
    }
}
