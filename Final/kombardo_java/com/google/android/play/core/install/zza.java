package com.google.android.play.core.install;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zza extends InstallState {
    private final int zza;
    private final long zzb;
    private final long zzc;
    private final int zzd;
    private final String zze;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zza(int i5, long j5, long j6, int i6, String str) {
        this.zza = i5;
        this.zzb = j5;
        this.zzc = j6;
        this.zzd = i6;
        if (str == null) {
            throw new NullPointerException("Null packageName");
        }
        this.zze = str;
    }

    @Override // com.google.android.play.core.install.InstallState
    public final long bytesDownloaded() {
        return this.zzb;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof InstallState) {
            InstallState installState = (InstallState) obj;
            if (this.zza == installState.installStatus() && this.zzb == installState.bytesDownloaded() && this.zzc == installState.totalBytesToDownload() && this.zzd == installState.installErrorCode() && this.zze.equals(installState.packageName())) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i5 = this.zza ^ 1000003;
        long j5 = this.zzb;
        long j6 = this.zzc;
        return (((((((i5 * 1000003) ^ ((int) (j5 ^ (j5 >>> 32)))) * 1000003) ^ ((int) ((j6 >>> 32) ^ j6))) * 1000003) ^ this.zzd) * 1000003) ^ this.zze.hashCode();
    }

    @Override // com.google.android.play.core.install.InstallState
    public final int installErrorCode() {
        return this.zzd;
    }

    @Override // com.google.android.play.core.install.InstallState
    public final int installStatus() {
        return this.zza;
    }

    @Override // com.google.android.play.core.install.InstallState
    public final String packageName() {
        return this.zze;
    }

    public final String toString() {
        return "InstallState{installStatus=" + this.zza + ", bytesDownloaded=" + this.zzb + ", totalBytesToDownload=" + this.zzc + ", installErrorCode=" + this.zzd + ", packageName=" + this.zze + "}";
    }

    @Override // com.google.android.play.core.install.InstallState
    public final long totalBytesToDownload() {
        return this.zzc;
    }
}
