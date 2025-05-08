package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.database.ContentObserver;
import android.util.Log;
import androidx.core.content.PermissionChecker;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzhq implements zzhl {
    private static zzhq zza;
    private final Context zzb;
    private final ContentObserver zzc;

    private zzhq() {
        this.zzb = null;
        this.zzc = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzhq zza(Context context) {
        zzhq zzhqVar;
        synchronized (zzhq.class) {
            try {
                if (zza == null) {
                    zza = PermissionChecker.checkSelfPermission(context, "com.google.android.providers.gsf.permission.READ_GSERVICES") == 0 ? new zzhq(context) : new zzhq();
                }
                zzhqVar = zza;
            } catch (Throwable th) {
                throw th;
            }
        }
        return zzhqVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.google.android.gms.internal.measurement.zzhl
    /* renamed from: zzb, reason: merged with bridge method [inline-methods] */
    public final String zza(final String str) {
        Context context = this.zzb;
        if (context != null && !zzhg.zza(context)) {
            try {
                return (String) zzho.zza(new zzhn() { // from class: com.google.android.gms.internal.measurement.zzhp
                    @Override // com.google.android.gms.internal.measurement.zzhn
                    public final Object zza() {
                        String zza2;
                        zza2 = zzgt.zza(zzhq.this.zzb.getContentResolver(), str, null);
                        return zza2;
                    }
                });
            } catch (IllegalStateException | NullPointerException | SecurityException e5) {
                Log.e("GservicesLoader", "Unable to read GServices for: " + str, e5);
            }
        }
        return null;
    }

    private zzhq(Context context) {
        this.zzb = context;
        zzhs zzhsVar = new zzhs(this, null);
        this.zzc = zzhsVar;
        context.getContentResolver().registerContentObserver(zzgw.zza, true, zzhsVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized void zza() {
        Context context;
        synchronized (zzhq.class) {
            try {
                zzhq zzhqVar = zza;
                if (zzhqVar != null && (context = zzhqVar.zzb) != null && zzhqVar.zzc != null) {
                    context.getContentResolver().unregisterContentObserver(zza.zzc);
                }
                zza = null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
