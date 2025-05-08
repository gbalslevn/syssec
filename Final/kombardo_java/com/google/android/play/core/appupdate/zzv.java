package com.google.android.play.core.appupdate;

import com.google.android.play.core.appupdate.AppUpdateOptions;

/* loaded from: classes.dex */
final class zzv extends AppUpdateOptions.Builder {
    private int zza;
    private boolean zzb;
    private byte zzc;

    @Override // com.google.android.play.core.appupdate.AppUpdateOptions.Builder
    public final AppUpdateOptions build() {
        if (this.zzc == 3) {
            return new zzx(this.zza, this.zzb, null);
        }
        StringBuilder sb = new StringBuilder();
        if ((this.zzc & 1) == 0) {
            sb.append(" appUpdateType");
        }
        if ((this.zzc & 2) == 0) {
            sb.append(" allowAssetPackDeletion");
        }
        throw new IllegalStateException("Missing required properties:".concat(sb.toString()));
    }

    @Override // com.google.android.play.core.appupdate.AppUpdateOptions.Builder
    public final AppUpdateOptions.Builder setAllowAssetPackDeletion(boolean z5) {
        this.zzb = z5;
        this.zzc = (byte) (this.zzc | 2);
        return this;
    }

    public final AppUpdateOptions.Builder setAppUpdateType(int i5) {
        this.zza = i5;
        this.zzc = (byte) (this.zzc | 1);
        return this;
    }
}
