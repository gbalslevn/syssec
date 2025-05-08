package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import com.google.android.gms.common.wrappers.PackageManagerWrapper;
import com.google.android.gms.common.wrappers.Wrappers;

/* loaded from: classes.dex */
public final class zzhj {
    final zzic zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzhj(zzou zzouVar) {
        this.zza = zzouVar.zzk();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Bundle zza(String str, com.google.android.gms.internal.measurement.zzbz zzbzVar) {
        this.zza.zzl().zzv();
        if (zzbzVar == null) {
            this.zza.zzj().zzr().zza("Attempting to use Install Referrer Service while it is not initialized");
            return null;
        }
        Bundle bundle = new Bundle();
        bundle.putString("package_name", str);
        try {
            Bundle zza = zzbzVar.zza(bundle);
            if (zza != null) {
                return zza;
            }
            this.zza.zzj().zzg().zza("Install Referrer Service returned a null response");
            return null;
        } catch (Exception e5) {
            this.zza.zzj().zzg().zza("Exception occurred while retrieving the Install Referrer", e5.getMessage());
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zza() {
        try {
            PackageManagerWrapper packageManager = Wrappers.packageManager(this.zza.zza());
            if (packageManager != null) {
                return packageManager.getPackageInfo("com.android.vending", 128).versionCode >= 80837300;
            }
            this.zza.zzj().zzq().zza("Failed to get PackageManager for Install Referrer Play Store compatibility check");
            return false;
        } catch (Exception e5) {
            this.zza.zzj().zzq().zza("Failed to retrieve Play Store version for Install Referrer", e5);
            return false;
        }
    }
}
