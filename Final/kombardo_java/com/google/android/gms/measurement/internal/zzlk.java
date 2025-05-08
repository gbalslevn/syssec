package com.google.android.gms.measurement.internal;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.adjust.sdk.Constants;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzlk implements Application.ActivityLifecycleCallbacks, zzll {
    private final /* synthetic */ zzju zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzlk(zzju zzjuVar) {
        this.zza = zzjuVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00db A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00dc A[Catch: RuntimeException -> 0x0072, TRY_LEAVE, TryCatch #0 {RuntimeException -> 0x0072, blocks: (B:3:0x0005, B:9:0x0097, B:11:0x00a3, B:14:0x00b0, B:16:0x00b6, B:17:0x00c9, B:18:0x00d5, B:22:0x00dc, B:26:0x0100, B:27:0x011c, B:29:0x010d, B:30:0x0122, B:32:0x0128, B:34:0x012e, B:36:0x0134, B:38:0x013a, B:40:0x0143, B:42:0x014c, B:44:0x0152, B:47:0x0158, B:49:0x0023, B:51:0x0029, B:53:0x0031, B:55:0x0037, B:57:0x003d, B:59:0x0043, B:61:0x004c, B:63:0x0054, B:65:0x005d, B:67:0x0066, B:68:0x0075, B:70:0x008d), top: B:2:0x0005 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static /* synthetic */ void zza(zzlk zzlkVar, boolean z5, Uri uri, String str, String str2) {
        Bundle zza;
        Bundle zza2;
        zzlkVar.zza.zzv();
        try {
            zzpn zzs = zzlkVar.zza.zzs();
            if (!TextUtils.isEmpty(str2)) {
                if (!str2.contains("gclid") && !str2.contains("gbraid") && !str2.contains("utm_campaign") && !str2.contains("utm_source") && !str2.contains("utm_medium") && !str2.contains("utm_id") && !str2.contains("dclid") && !str2.contains("srsltid") && !str2.contains("sfmc_id")) {
                    zzs.zzj().zzc().zza("Activity created with data 'referrer' without required params");
                } else {
                    zza = zzs.zza(Uri.parse("https://google.com/search?" + str2));
                    if (zza != null) {
                        zza.putString("_cis", Constants.REFERRER);
                    }
                    if (z5 && (zza2 = zzlkVar.zza.zzs().zza(uri)) != null) {
                        zza2.putString("_cis", "intent");
                        if (!zza2.containsKey("gclid") && zza != null && zza.containsKey("gclid")) {
                            zza2.putString("_cer", String.format("gclid=%s", zza.getString("gclid")));
                        }
                        zzlkVar.zza.zzc(str, "_cmp", zza2);
                        zzlkVar.zza.zza.zza(str, zza2);
                    }
                    if (TextUtils.isEmpty(str2)) {
                        zzlkVar.zza.zzj().zzc().zza("Activity created with referrer", str2);
                        if (zzlkVar.zza.zze().zza(zzbn.zzca)) {
                            if (zza != null) {
                                zzlkVar.zza.zzc(str, "_cmp", zza);
                                zzlkVar.zza.zza.zza(str, zza);
                            } else {
                                zzlkVar.zza.zzj().zzc().zza("Referrer does not contain valid parameters", str2);
                            }
                            zzlkVar.zza.zza("auto", "_ldl", (Object) null, true);
                            return;
                        }
                        if (str2.contains("gclid") && (str2.contains("utm_campaign") || str2.contains("utm_source") || str2.contains("utm_medium") || str2.contains("utm_term") || str2.contains("utm_content"))) {
                            if (TextUtils.isEmpty(str2)) {
                                return;
                            }
                            zzlkVar.zza.zza("auto", "_ldl", (Object) str2, true);
                            return;
                        }
                        zzlkVar.zza.zzj().zzc().zza("Activity created with data 'referrer' without required params");
                        return;
                    }
                    return;
                }
            }
            zza = null;
            if (z5) {
                zza2.putString("_cis", "intent");
                if (!zza2.containsKey("gclid")) {
                    zza2.putString("_cer", String.format("gclid=%s", zza.getString("gclid")));
                }
                zzlkVar.zza.zzc(str, "_cmp", zza2);
                zzlkVar.zza.zza.zza(str, zza2);
            }
            if (TextUtils.isEmpty(str2)) {
            }
        } catch (RuntimeException e5) {
            zzlkVar.zza.zzj().zzg().zza("Throwable caught in handleReferrerForOnActivityCreated", e5);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        zza(com.google.android.gms.internal.measurement.zzeb.zza(activity), bundle);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        zza(com.google.android.gms.internal.measurement.zzeb.zza(activity));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        zzb(com.google.android.gms.internal.measurement.zzeb.zza(activity));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        zzc(com.google.android.gms.internal.measurement.zzeb.zza(activity));
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        zzb(com.google.android.gms.internal.measurement.zzeb.zza(activity), bundle);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
    }

    @Override // com.google.android.gms.measurement.internal.zzll
    public final void zzb(com.google.android.gms.internal.measurement.zzeb zzebVar) {
        this.zza.zzp().zzb(zzebVar);
        zznx zzr = this.zza.zzr();
        zzr.zzl().zzb(new zznz(zzr, zzr.zzb().elapsedRealtime()));
    }

    @Override // com.google.android.gms.measurement.internal.zzll
    public final void zzc(com.google.android.gms.internal.measurement.zzeb zzebVar) {
        zznx zzr = this.zza.zzr();
        zzr.zzl().zzb(new zznw(zzr, zzr.zzb().elapsedRealtime()));
        this.zza.zzp().zzc(zzebVar);
    }

    @Override // com.google.android.gms.measurement.internal.zzll
    public final void zzb(com.google.android.gms.internal.measurement.zzeb zzebVar, Bundle bundle) {
        this.zza.zzp().zzb(zzebVar, bundle);
    }

    @Override // com.google.android.gms.measurement.internal.zzll
    public final void zza(com.google.android.gms.internal.measurement.zzeb zzebVar, Bundle bundle) {
        String str;
        try {
            try {
                this.zza.zzj().zzq().zza("onActivityCreated");
                Intent intent = zzebVar.zzc;
                if (intent == null) {
                    this.zza.zzp().zza(zzebVar, bundle);
                    return;
                }
                Uri data = intent.getData();
                if (data == null || !data.isHierarchical()) {
                    Bundle extras = intent.getExtras();
                    if (extras != null) {
                        String string = extras.getString("com.android.vending.referral_url");
                        if (!TextUtils.isEmpty(string)) {
                            data = Uri.parse(string);
                        }
                    }
                    data = null;
                }
                Uri uri = data;
                if (uri != null && uri.isHierarchical()) {
                    this.zza.zzs();
                    if (zzpn.zza(intent)) {
                        str = "gs";
                    } else {
                        str = "auto";
                    }
                    this.zza.zzl().zzb(new zzln(this, bundle == null, uri, str, uri.getQueryParameter(Constants.REFERRER)));
                    this.zza.zzp().zza(zzebVar, bundle);
                }
            } catch (RuntimeException e5) {
                this.zza.zzj().zzg().zza("Throwable caught in onActivityCreated", e5);
                this.zza.zzp().zza(zzebVar, bundle);
            }
        } finally {
            this.zza.zzp().zza(zzebVar, bundle);
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzll
    public final void zza(com.google.android.gms.internal.measurement.zzeb zzebVar) {
        this.zza.zzp().zza(zzebVar);
    }
}
