package com.google.android.gms.measurement.internal;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import androidx.core.content.ContextCompat;
import com.adjust.sdk.Constants;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.measurement.zzgf$zzo;
import com.google.android.gms.measurement.internal.zzjj;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import org.conscrypt.BuildConfig;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class zzic implements zzjh {
    private static volatile zzic zzb;
    final long zza;
    private Boolean zzab;
    private long zzac;
    private volatile Boolean zzad;
    private Boolean zzae;
    private Boolean zzaf;
    private volatile boolean zzag;
    private int zzah;
    private int zzai;
    private final Context zzc;
    private final String zzd;
    private final String zze;
    private final String zzf;
    private final boolean zzg;
    private final zzaf zzh;
    private final zzai zzi;
    private final zzha zzj;
    private final zzgo zzk;
    private final zzhv zzl;
    private final zznx zzm;
    private final zzpn zzn;
    private final zzgl zzo;
    private final Clock zzp;
    private final zzlz zzq;
    private final zzju zzr;
    private final zza zzs;
    private final zzlp zzt;
    private final String zzu;
    private zzgj zzv;
    private zzme zzw;
    private zzbf zzx;
    private zzgg zzy;
    private zzls zzz;
    private boolean zzaa = false;
    private AtomicInteger zzaj = new AtomicInteger(0);

    private zzic(zzjs zzjsVar) {
        Bundle bundle;
        boolean z5 = false;
        Preconditions.checkNotNull(zzjsVar);
        zzaf zzafVar = new zzaf(zzjsVar.zza);
        this.zzh = zzafVar;
        zzfu.zza = zzafVar;
        Context context = zzjsVar.zza;
        this.zzc = context;
        this.zzd = zzjsVar.zzb;
        this.zze = zzjsVar.zzc;
        this.zzf = zzjsVar.zzd;
        this.zzg = zzjsVar.zzh;
        this.zzad = zzjsVar.zze;
        this.zzu = zzjsVar.zzj;
        this.zzag = true;
        com.google.android.gms.internal.measurement.zzdz zzdzVar = zzjsVar.zzg;
        if (zzdzVar != null && (bundle = zzdzVar.zzg) != null) {
            Object obj = bundle.get("measurementEnabled");
            if (obj instanceof Boolean) {
                this.zzae = (Boolean) obj;
            }
            Object obj2 = zzdzVar.zzg.get("measurementDeactivated");
            if (obj2 instanceof Boolean) {
                this.zzaf = (Boolean) obj2;
            }
        }
        com.google.android.gms.internal.measurement.zzhx.zzb(context);
        Clock defaultClock = DefaultClock.getInstance();
        this.zzp = defaultClock;
        Long l5 = zzjsVar.zzi;
        this.zza = l5 != null ? l5.longValue() : defaultClock.currentTimeMillis();
        this.zzi = new zzai(this);
        zzha zzhaVar = new zzha(this);
        zzhaVar.zzae();
        this.zzj = zzhaVar;
        zzgo zzgoVar = new zzgo(this);
        zzgoVar.zzae();
        this.zzk = zzgoVar;
        zzpn zzpnVar = new zzpn(this);
        zzpnVar.zzae();
        this.zzn = zzpnVar;
        this.zzo = new zzgl(new zzjv(zzjsVar, this));
        this.zzs = new zza(this);
        zzlz zzlzVar = new zzlz(this);
        zzlzVar.zzx();
        this.zzq = zzlzVar;
        zzju zzjuVar = new zzju(this);
        zzjuVar.zzx();
        this.zzr = zzjuVar;
        zznx zznxVar = new zznx(this);
        zznxVar.zzx();
        this.zzm = zznxVar;
        zzlp zzlpVar = new zzlp(this);
        zzlpVar.zzae();
        this.zzt = zzlpVar;
        zzhv zzhvVar = new zzhv(this);
        zzhvVar.zzae();
        this.zzl = zzhvVar;
        com.google.android.gms.internal.measurement.zzdz zzdzVar2 = zzjsVar.zzg;
        if (zzdzVar2 != null && zzdzVar2.zzb != 0) {
            z5 = true;
        }
        boolean z6 = !z5;
        if (context.getApplicationContext() instanceof Application) {
            zzp().zzb(z6);
        } else {
            zzj().zzr().zza("Application context is not an Application");
        }
        zzhvVar.zzb(new zzid(this, zzjsVar));
    }

    @Override // com.google.android.gms.measurement.internal.zzjh
    public final Context zza() {
        return this.zzc;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzaa() {
        throw new IllegalStateException("Unexpected call on client side");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzab() {
        this.zzaj.incrementAndGet();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzac() {
        this.zzah++;
    }

    public final boolean zzad() {
        return this.zzad != null && this.zzad.booleanValue();
    }

    public final boolean zzae() {
        return zzc() == 0;
    }

    public final boolean zzaf() {
        zzl().zzv();
        return this.zzag;
    }

    public final boolean zzag() {
        return TextUtils.isEmpty(this.zzd);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean zzah() {
        if (!this.zzaa) {
            throw new IllegalStateException("AppMeasurement is not initialized");
        }
        zzl().zzv();
        Boolean bool = this.zzab;
        if (bool == null || this.zzac == 0 || (bool != null && !bool.booleanValue() && Math.abs(this.zzp.elapsedRealtime() - this.zzac) > 1000)) {
            this.zzac = this.zzp.elapsedRealtime();
            boolean z5 = true;
            Boolean valueOf = Boolean.valueOf(zzv().zze("android.permission.INTERNET") && zzv().zze("android.permission.ACCESS_NETWORK_STATE") && (Wrappers.packageManager(this.zzc).isCallerInstantApp() || this.zzi.zzz() || (zzpn.zza(this.zzc) && zzpn.zza(this.zzc, false))));
            this.zzab = valueOf;
            if (valueOf.booleanValue()) {
                if (!zzv().zza(zzh().zzah(), zzh().zzae()) && TextUtils.isEmpty(zzh().zzae())) {
                    z5 = false;
                }
                this.zzab = Boolean.valueOf(z5);
            }
        }
        return this.zzab.booleanValue();
    }

    public final boolean zzai() {
        return this.zzg;
    }

    public final boolean zzaj() {
        zzl().zzv();
        zza((zzji) zzq());
        String zzaf = zzh().zzaf();
        if (!this.zzi.zzw()) {
            zzj().zzq().zza("ADID collection is disabled from Manifest. Skipping");
            return false;
        }
        Pair<String, Boolean> zza = zzn().zza(zzaf);
        if (((Boolean) zza.second).booleanValue() || TextUtils.isEmpty((CharSequence) zza.first)) {
            zzj().zzq().zza("ADID unavailable to retrieve Deferred Deep Link. Skipping");
            return false;
        }
        if (!zzq().zzc()) {
            zzj().zzr().zza("Network is not available for Deferred Deep Link request. Skipping");
            return false;
        }
        StringBuilder sb = new StringBuilder();
        zzme zzt = zzt();
        zzt.zzv();
        zzt.zzw();
        if (!zzt.zzap() || zzt.zzs().zzg() >= 234200) {
            zzap zzac = zzp().zzac();
            Bundle bundle = zzac != null ? zzac.zza : null;
            if (bundle == null) {
                int i5 = this.zzai;
                this.zzai = i5 + 1;
                boolean z5 = i5 < 10;
                zzj().zzc().zza("Failed to retrieve DMA consent from the service, " + (z5 ? "Retrying." : "Skipping.") + " retryCount", Integer.valueOf(this.zzai));
                return z5;
            }
            zzjj zza2 = zzjj.zza(bundle, 100);
            sb.append("&gcs=");
            sb.append(zza2.zze());
            zzbd zza3 = zzbd.zza(bundle, 100);
            sb.append("&dma=");
            sb.append(zza3.zzd() == Boolean.FALSE ? 0 : 1);
            if (!TextUtils.isEmpty(zza3.zze())) {
                sb.append("&dma_cps=");
                sb.append(zza3.zze());
            }
            int i6 = zzbd.zza(bundle) == Boolean.TRUE ? 0 : 1;
            sb.append("&npa=");
            sb.append(i6);
            zzj().zzq().zza("Consent query parameters to Bow", sb);
        }
        zzpn zzv = zzv();
        zzh();
        URL zza4 = zzv.zza(114010L, zzaf, (String) zza.first, zzn().zzp.zza() - 1, sb.toString());
        if (zza4 != null) {
            zzlp zzq = zzq();
            zzlo zzloVar = new zzlo() { // from class: com.google.android.gms.measurement.internal.zzie
                @Override // com.google.android.gms.measurement.internal.zzlo
                public final void zza(String str, int i7, Throwable th, byte[] bArr, Map map) {
                    zzic.zza(zzic.this, str, i7, th, bArr, map);
                }
            };
            zzq.zzad();
            Preconditions.checkNotNull(zza4);
            Preconditions.checkNotNull(zzloVar);
            zzq.zzl().zza(new zzlr(zzq, zzaf, zza4, null, null, zzloVar));
        }
        return false;
    }

    @Override // com.google.android.gms.measurement.internal.zzjh
    public final Clock zzb() {
        return this.zzp;
    }

    public final int zzc() {
        zzl().zzv();
        if (this.zzi.zzy()) {
            return 1;
        }
        Boolean bool = this.zzaf;
        if (bool != null && bool.booleanValue()) {
            return 2;
        }
        if (!zzaf()) {
            return 8;
        }
        Boolean zzw = zzn().zzw();
        if (zzw != null) {
            return zzw.booleanValue() ? 0 : 3;
        }
        Boolean zze = this.zzi.zze("firebase_analytics_collection_enabled");
        if (zze != null) {
            return zze.booleanValue() ? 0 : 4;
        }
        Boolean bool2 = this.zzae;
        return bool2 != null ? bool2.booleanValue() ? 0 : 5 : (this.zzad == null || this.zzad.booleanValue()) ? 0 : 7;
    }

    @Override // com.google.android.gms.measurement.internal.zzjh
    public final zzaf zzd() {
        return this.zzh;
    }

    public final zza zze() {
        zza((zzg) this.zzs);
        return this.zzs;
    }

    public final zzai zzf() {
        return this.zzi;
    }

    public final zzbf zzg() {
        zza((zzji) this.zzx);
        return this.zzx;
    }

    public final zzgg zzh() {
        zza((zzf) this.zzy);
        return this.zzy;
    }

    public final zzgj zzi() {
        zza((zzf) this.zzv);
        return this.zzv;
    }

    @Override // com.google.android.gms.measurement.internal.zzjh
    public final zzgo zzj() {
        zza((zzji) this.zzk);
        return this.zzk;
    }

    public final zzgl zzk() {
        return this.zzo;
    }

    @Override // com.google.android.gms.measurement.internal.zzjh
    public final zzhv zzl() {
        zza((zzji) this.zzl);
        return this.zzl;
    }

    public final zzgo zzm() {
        zzgo zzgoVar = this.zzk;
        if (zzgoVar == null || !zzgoVar.zzag()) {
            return null;
        }
        return this.zzk;
    }

    public final zzha zzn() {
        zza((zzjf) this.zzj);
        return this.zzj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzhv zzo() {
        return this.zzl;
    }

    public final zzju zzp() {
        zza((zzf) this.zzr);
        return this.zzr;
    }

    public final zzlp zzq() {
        zza((zzji) this.zzt);
        return this.zzt;
    }

    public final zzls zzr() {
        zza((zzg) this.zzz);
        return this.zzz;
    }

    public final zzlz zzs() {
        zza((zzf) this.zzq);
        return this.zzq;
    }

    public final zzme zzt() {
        zza((zzf) this.zzw);
        return this.zzw;
    }

    public final zznx zzu() {
        zza((zzf) this.zzm);
        return this.zzm;
    }

    public final zzpn zzv() {
        zza((zzjf) this.zzn);
        return this.zzn;
    }

    public final String zzw() {
        return this.zzd;
    }

    public final String zzx() {
        return this.zze;
    }

    public final String zzy() {
        return this.zzf;
    }

    public final String zzz() {
        return this.zzu;
    }

    public static zzic zza(Context context, com.google.android.gms.internal.measurement.zzdz zzdzVar, Long l5) {
        Bundle bundle;
        if (zzdzVar != null && (zzdzVar.zze == null || zzdzVar.zzf == null)) {
            zzdzVar = new com.google.android.gms.internal.measurement.zzdz(zzdzVar.zza, zzdzVar.zzb, zzdzVar.zzc, zzdzVar.zzd, null, null, zzdzVar.zzg, null);
        }
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(context.getApplicationContext());
        if (zzb == null) {
            synchronized (zzic.class) {
                try {
                    if (zzb == null) {
                        zzb = new zzic(new zzjs(context, zzdzVar, l5));
                    }
                } finally {
                }
            }
        } else if (zzdzVar != null && (bundle = zzdzVar.zzg) != null && bundle.containsKey("dataCollectionDefaultEnabled")) {
            Preconditions.checkNotNull(zzb);
            zzb.zza(zzdzVar.zzg.getBoolean("dataCollectionDefaultEnabled"));
        }
        Preconditions.checkNotNull(zzb);
        return zzb;
    }

    public final void zzb(boolean z5) {
        zzl().zzv();
        this.zzag = z5;
    }

    public static /* synthetic */ void zza(zzic zzicVar, String str, int i5, Throwable th, byte[] bArr, Map map) {
        List<ResolveInfo> queryIntentActivities;
        if ((i5 == 200 || i5 == 204 || i5 == 304) && th == null) {
            zzicVar.zzn().zzo.zza(true);
            if (bArr != null && bArr.length != 0) {
                try {
                    JSONObject jSONObject = new JSONObject(new String(bArr));
                    String optString = jSONObject.optString(Constants.DEEPLINK, BuildConfig.FLAVOR);
                    if (TextUtils.isEmpty(optString)) {
                        zzicVar.zzj().zzc().zza("Deferred Deep Link is empty.");
                        return;
                    }
                    String optString2 = jSONObject.optString("gclid", BuildConfig.FLAVOR);
                    String optString3 = jSONObject.optString("gbraid", BuildConfig.FLAVOR);
                    String optString4 = jSONObject.optString("gad_source", BuildConfig.FLAVOR);
                    double optDouble = jSONObject.optDouble("timestamp", 0.0d);
                    Bundle bundle = new Bundle();
                    zzpn zzv = zzicVar.zzv();
                    if (!TextUtils.isEmpty(optString) && (queryIntentActivities = zzv.zza().getPackageManager().queryIntentActivities(new Intent("android.intent.action.VIEW", Uri.parse(optString)), 0)) != null && !queryIntentActivities.isEmpty()) {
                        if (!TextUtils.isEmpty(optString3)) {
                            bundle.putString("gbraid", optString3);
                        }
                        if (!TextUtils.isEmpty(optString4)) {
                            bundle.putString("gad_source", optString4);
                        }
                        bundle.putString("gclid", optString2);
                        bundle.putString("_cis", "ddp");
                        zzicVar.zzr.zzc("auto", "_cmp", bundle);
                        zzpn zzv2 = zzicVar.zzv();
                        if (TextUtils.isEmpty(optString) || !zzv2.zza(optString, optDouble)) {
                            return;
                        }
                        zzv2.zza().sendBroadcast(new Intent("android.google.analytics.action.DEEPLINK_ACTION"));
                        return;
                    }
                    zzicVar.zzj().zzr().zza("Deferred Deep Link validation failed. gclid, gbraid, deep link", optString2, optString3, optString);
                    return;
                } catch (JSONException e5) {
                    zzicVar.zzj().zzg().zza("Failed to parse the Deferred Deep Link response. exception", e5);
                    return;
                }
            }
            zzicVar.zzj().zzc().zza("Deferred Deep Link response empty.");
            return;
        }
        zzicVar.zzj().zzr().zza("Network Request for Deferred Deep Link failed. response, exception", Integer.valueOf(i5), th);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zza(zzic zzicVar, zzjs zzjsVar) {
        zzicVar.zzl().zzv();
        zzbf zzbfVar = new zzbf(zzicVar);
        zzbfVar.zzae();
        zzicVar.zzx = zzbfVar;
        zzgg zzggVar = new zzgg(zzicVar, zzjsVar.zzf);
        zzggVar.zzx();
        zzicVar.zzy = zzggVar;
        zzgj zzgjVar = new zzgj(zzicVar);
        zzgjVar.zzx();
        zzicVar.zzv = zzgjVar;
        zzme zzmeVar = new zzme(zzicVar);
        zzmeVar.zzx();
        zzicVar.zzw = zzmeVar;
        zzicVar.zzn.zzaf();
        zzicVar.zzj.zzaf();
        zzicVar.zzy.zzy();
        zzls zzlsVar = new zzls(zzicVar);
        zzlsVar.zzx();
        zzicVar.zzz = zzlsVar;
        zzlsVar.zzy();
        zzicVar.zzj().zzp().zza("App measurement initialized, version", 114010L);
        zzicVar.zzj().zzp().zza("To enable debug logging run: adb shell setprop log.tag.FA VERBOSE");
        String zzaf = zzggVar.zzaf();
        if (TextUtils.isEmpty(zzicVar.zzd)) {
            if (zzicVar.zzv().zzd(zzaf, zzicVar.zzi.zzr())) {
                zzicVar.zzj().zzp().zza("Faster debug mode event logging enabled. To disable, run:\n  adb shell setprop debug.firebase.analytics.app .none.");
            } else {
                zzicVar.zzj().zzp().zza("To enable faster debug mode event logging run:\n  adb shell setprop debug.firebase.analytics.app " + zzaf);
            }
        }
        zzicVar.zzj().zzc().zza("Debug-level message logging enabled");
        if (zzicVar.zzah != zzicVar.zzaj.get()) {
            zzicVar.zzj().zzg().zza("Not all components initialized", Integer.valueOf(zzicVar.zzah), Integer.valueOf(zzicVar.zzaj.get()));
        }
        zzicVar.zzaa = true;
    }

    private static void zza(zzg zzgVar) {
        if (zzgVar == null) {
            throw new IllegalStateException("Component not created");
        }
    }

    private static void zza(zzjf zzjfVar) {
        if (zzjfVar == null) {
            throw new IllegalStateException("Component not created");
        }
    }

    private static void zza(zzf zzfVar) {
        if (zzfVar != null) {
            if (zzfVar.zzaa()) {
                return;
            }
            throw new IllegalStateException("Component not initialized: " + String.valueOf(zzfVar.getClass()));
        }
        throw new IllegalStateException("Component not created");
    }

    private static void zza(zzji zzjiVar) {
        if (zzjiVar != null) {
            if (zzjiVar.zzag()) {
                return;
            }
            throw new IllegalStateException("Component not initialized: " + String.valueOf(zzjiVar.getClass()));
        }
        throw new IllegalStateException("Component not created");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zza(boolean z5) {
        this.zzad = Boolean.valueOf(z5);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:151:0x0118, code lost:
    
        if (r4.zzi() != false) goto L50;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void zza(com.google.android.gms.internal.measurement.zzdz zzdzVar) {
        zzjj zza;
        Boolean zza2;
        zzl().zzv();
        zzai zzaiVar = this.zzi;
        zzfx<Boolean> zzfxVar = zzbn.zzcl;
        boolean z5 = zzaiVar.zza(zzfxVar) && zzr().zzac() == zzgf$zzo.zza.CLIENT_UPLOAD_ELIGIBLE;
        if ((com.google.android.gms.internal.measurement.zzoy.zza() && this.zzi.zza(zzbn.zzcq) && zzv().zzx()) || z5) {
            zzpn zzv = zzv();
            zzv.zzv();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.google.android.gms.measurement.TRIGGERS_AVAILABLE");
            if (zzv.zze().zza(zzfxVar)) {
                intentFilter.addAction("com.google.android.gms.measurement.BATCHES_AVAILABLE");
            }
            ContextCompat.registerReceiver(zzv.zza(), new zzq(zzv.zzu), intentFilter, 2);
            zzv.zzj().zzc().zza("Registered app receiver");
        }
        if (z5) {
            zzr().zza(zzbn.zzx.zza(null).longValue());
        }
        zzjj zzp = zzn().zzp();
        int zza3 = zzp.zza();
        zzjm zzc = this.zzi.zzc("google_analytics_default_allow_ad_storage", false);
        zzjm zzc2 = this.zzi.zzc("google_analytics_default_allow_analytics_storage", false);
        zzjm zzjmVar = zzjm.UNINITIALIZED;
        if ((zzc != zzjmVar || zzc2 != zzjmVar) && zzn().zza(-10)) {
            zza = zzjj.zza(zzc, zzc2, -10);
        } else {
            if (!TextUtils.isEmpty(zzh().zzah()) && (zza3 == 0 || zza3 == 30 || zza3 == 10 || zza3 == 30 || zza3 == 30 || zza3 == 40)) {
                zzp().zza(new zzjj(null, null, -10), false);
            } else if (TextUtils.isEmpty(zzh().zzah()) && zzdzVar != null && zzdzVar.zzg != null && zzn().zza(30)) {
                zza = zzjj.zza(zzdzVar.zzg, 30);
            }
            zza = null;
        }
        if (zza != null) {
            zzp().zza(zza, true);
            zzp = zza;
        }
        zzp().zza(zzp);
        int zza4 = zzn().zzo().zza();
        zzjm zzc3 = this.zzi.zzc("google_analytics_default_allow_ad_personalization_signals", true);
        if (zzc3 != zzjmVar) {
            zzj().zzq().zza("Default ad personalization consent from Manifest", zzc3);
        }
        zzjm zzc4 = this.zzi.zzc("google_analytics_default_allow_ad_user_data", true);
        if (zzc4 != zzjmVar && zzjj.zza(-10, zza4)) {
            zzp().zza(zzbd.zza(zzc4, -10), true);
        } else if (!TextUtils.isEmpty(zzh().zzah()) && (zza4 == 0 || zza4 == 30)) {
            zzp().zza(new zzbd(null, -10), true);
        } else {
            if (TextUtils.isEmpty(zzh().zzah()) && zzdzVar != null && zzdzVar.zzg != null && zzjj.zza(30, zza4)) {
                zzbd zza5 = zzbd.zza(zzdzVar.zzg, 30);
                if (zza5.zzg()) {
                    zzp().zza(zza5, true);
                }
            }
            if (TextUtils.isEmpty(zzh().zzah()) && zzdzVar != null && zzdzVar.zzg != null && zzn().zzh.zza() == null && (zza2 = zzbd.zza(zzdzVar.zzg)) != null) {
                zzp().zza(zzdzVar.zze, "allow_personalized_ads", (Object) zza2.toString(), false);
            }
        }
        Boolean zze = this.zzi.zze("google_analytics_tcf_data_enabled");
        if (zze == null ? true : zze.booleanValue()) {
            zzj().zzc().zza("TCF client enabled.");
            zzp().zzaw();
            zzp().zzau();
        }
        if (zzn().zzc.zza() == 0) {
            zzj().zzq().zza("Persisting first open", Long.valueOf(this.zza));
            zzn().zzc.zza(this.zza);
        }
        zzp().zza.zzb();
        if (!zzah()) {
            if (zzae()) {
                if (!zzv().zze("android.permission.INTERNET")) {
                    zzj().zzg().zza("App is missing INTERNET permission");
                }
                if (!zzv().zze("android.permission.ACCESS_NETWORK_STATE")) {
                    zzj().zzg().zza("App is missing ACCESS_NETWORK_STATE permission");
                }
                if (!Wrappers.packageManager(this.zzc).isCallerInstantApp() && !this.zzi.zzz()) {
                    if (!zzpn.zza(this.zzc)) {
                        zzj().zzg().zza("AppMeasurementReceiver not registered/enabled");
                    }
                    if (!zzpn.zza(this.zzc, false)) {
                        zzj().zzg().zza("AppMeasurementService not registered/enabled");
                    }
                }
                zzj().zzg().zza("Uploading is not possible. App measurement disabled");
            }
        } else {
            if (!TextUtils.isEmpty(zzh().zzah()) || !TextUtils.isEmpty(zzh().zzae())) {
                zzv();
                if (zzpn.zza(zzh().zzah(), zzn().zzz(), zzh().zzae(), zzn().zzy())) {
                    zzj().zzp().zza("Rechecking which service to use due to a GMP App Id change");
                    zzn().zzaa();
                    zzi().zzac();
                    this.zzw.zzah();
                    this.zzw.zzag();
                    zzn().zzc.zza(this.zza);
                    zzn().zze.zza(null);
                }
                zzn().zzc(zzh().zzah());
                zzn().zzb(zzh().zzae());
            }
            if (!zzn().zzp().zza(zzjj.zza.ANALYTICS_STORAGE)) {
                zzn().zze.zza(null);
            }
            zzp().zzb(zzn().zze.zza());
            if (!zzv().zzy() && !TextUtils.isEmpty(zzn().zzq.zza())) {
                zzj().zzr().zza("Remote config removed with active feature rollouts");
                zzn().zzq.zza(null);
            }
            if (!TextUtils.isEmpty(zzh().zzah()) || !TextUtils.isEmpty(zzh().zzae())) {
                boolean zzae = zzae();
                if (!zzn().zzac() && !this.zzi.zzy()) {
                    zzn().zzb(!zzae);
                }
                if (zzae) {
                    zzp().zzap();
                }
                zzu().zza.zza();
                zzt().zza(new AtomicReference<>());
                zzt().zza(zzn().zzt.zza());
            }
        }
        if (com.google.android.gms.internal.measurement.zzoy.zza() && this.zzi.zza(zzbn.zzcq) && zzv().zzx()) {
            if (zzbn.zzbr.zza(null).intValue() > 0) {
                long max = Math.max(500L, ((r12.zza(null).intValue() * 1000) + new Random().nextInt(5000)) - this.zzp.elapsedRealtime());
                if (max > 500) {
                    zzj().zzq().zza("Waiting to fetch trigger URIs until some time after boot. Delay in millis", Long.valueOf(max));
                }
                zzp().zzc(max);
            } else {
                final zzju zzp2 = zzp();
                Objects.requireNonNull(zzp2);
                new Thread(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzib
                    @Override // java.lang.Runnable
                    public final void run() {
                        zzju.this.zzas();
                    }
                }).start();
            }
        }
        zzn().zzj.zza(true);
    }
}
