package com.google.android.gms.measurement.internal;

import android.annotation.TargetApi;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import androidx.collection.ArrayMap;
import androidx.privacysandbox.ads.adservices.java.measurement.MeasurementManagerFutures;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.CollectionUtils;
import com.google.android.gms.common.util.Strings;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Function;
import kotlin.Unit;
import org.conscrypt.BuildConfig;

/* loaded from: classes.dex */
public final class zzju extends zzf {
    final zzu zza;
    private zzlk zzb;
    private zzjq zzc;
    private final Set<zzjt> zzd;
    private boolean zze;
    private final AtomicReference<String> zzf;
    private final Object zzg;
    private boolean zzh;
    private int zzi;
    private zzbb zzj;
    private zzbb zzk;
    private PriorityQueue<zzog> zzl;
    private boolean zzm;
    private zzjj zzn;
    private final AtomicLong zzo;
    private long zzp;
    private boolean zzq;
    private zzbb zzr;
    private SharedPreferences.OnSharedPreferenceChangeListener zzs;
    private zzbb zzt;
    private final zzpp zzv;

    /* JADX INFO: Access modifiers changed from: protected */
    public zzju(zzic zzicVar) {
        super(zzicVar);
        this.zzd = new CopyOnWriteArraySet();
        this.zzg = new Object();
        this.zzh = false;
        this.zzi = 1;
        this.zzq = true;
        this.zzv = new zzld(this);
        this.zzf = new AtomicReference<>();
        this.zzn = zzjj.zza;
        this.zzp = -1L;
        this.zzo = new AtomicLong(0L);
        this.zza = new zzu(zzicVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzay() {
        zzv();
        String zza = zzk().zzh.zza();
        if (zza != null) {
            if ("unset".equals(zza)) {
                zza("app", "_npa", (Object) null, zzb().currentTimeMillis());
            } else {
                zza("app", "_npa", Long.valueOf("true".equals(zza) ? 1L : 0L), zzb().currentTimeMillis());
            }
        }
        if (!this.zzu.zzae() || !this.zzq) {
            zzj().zzc().zza("Updating Scion state (FE)");
            zzq().zzak();
        } else {
            zzj().zzc().zza("Recording app launch after enabling measurement for the first time (FE)");
            zzap();
            zzr().zza.zza();
            zzl().zzb(new zzkp(this));
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzf
    protected final boolean zzab() {
        return false;
    }

    public final zzap zzac() {
        zzv();
        return zzq().zzac();
    }

    public final zzll zzad() {
        return this.zzb;
    }

    public final Boolean zzae() {
        AtomicReference atomicReference = new AtomicReference();
        return (Boolean) zzl().zza(atomicReference, 15000L, "boolean test flag value", new zzkg(this, atomicReference));
    }

    public final Double zzaf() {
        AtomicReference atomicReference = new AtomicReference();
        return (Double) zzl().zza(atomicReference, 15000L, "double test flag value", new zzle(this, atomicReference));
    }

    public final Integer zzag() {
        AtomicReference atomicReference = new AtomicReference();
        return (Integer) zzl().zza(atomicReference, 15000L, "int test flag value", new zzlf(this, atomicReference));
    }

    public final Long zzah() {
        AtomicReference atomicReference = new AtomicReference();
        return (Long) zzl().zza(atomicReference, 15000L, "long test flag value", new zzlc(this, atomicReference));
    }

    public final String zzai() {
        return this.zzf.get();
    }

    public final String zzaj() {
        zzlw zzac = this.zzu.zzs().zzac();
        if (zzac != null) {
            return zzac.zzb;
        }
        return null;
    }

    public final String zzak() {
        zzlw zzac = this.zzu.zzs().zzac();
        if (zzac != null) {
            return zzac.zza;
        }
        return null;
    }

    public final String zzal() {
        if (this.zzu.zzw() != null) {
            return this.zzu.zzw();
        }
        try {
            return new zzhw(zza(), this.zzu.zzz()).zza("google_app_id");
        } catch (IllegalStateException e5) {
            this.zzu.zzj().zzg().zza("getGoogleAppId failed with exception", e5);
            return null;
        }
    }

    public final String zzam() {
        AtomicReference atomicReference = new AtomicReference();
        return (String) zzl().zza(atomicReference, 15000L, "String test flag value", new zzks(this, atomicReference));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @TargetApi(30)
    public final PriorityQueue<zzog> zzan() {
        if (this.zzl == null) {
            this.zzl = new PriorityQueue<>(Comparator.comparing(new Function() { // from class: com.google.android.gms.measurement.internal.zzjx
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    Long valueOf;
                    valueOf = Long.valueOf(((zzog) obj).zzb);
                    return valueOf;
                }
            }, new Comparator() { // from class: com.google.android.gms.measurement.internal.zzjw
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    int compare;
                    compare = Long.compare(((Long) obj).longValue(), ((Long) obj2).longValue());
                    return compare;
                }
            }));
        }
        return this.zzl;
    }

    public final void zzao() {
        zzv();
        zzw();
        zzme zzq = zzq();
        zzq.zzv();
        zzq.zzw();
        if (zzq.zzap() && zzq.zzs().zzg() < 242600) {
            return;
        }
        zzq().zzae();
    }

    public final void zzap() {
        zzv();
        zzw();
        if (this.zzu.zzah()) {
            Boolean zze = zze().zze("google_analytics_deferred_deep_link_enabled");
            if (zze != null && zze.booleanValue()) {
                zzj().zzc().zza("Deferred Deep Link feature enabled.");
                zzl().zzb(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzke
                    @Override // java.lang.Runnable
                    public final void run() {
                        zzju.this.zzat();
                    }
                });
            }
            zzq().zzaf();
            this.zzq = false;
            String zzx = zzk().zzx();
            if (TextUtils.isEmpty(zzx)) {
                return;
            }
            zzf().zzad();
            if (zzx.equals(Build.VERSION.RELEASE)) {
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString("_po", zzx);
            zzc("auto", "_ou", bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzaq() {
        zzv();
        zzbb zzbbVar = this.zzk;
        if (zzbbVar != null) {
            zzbbVar.zza();
        }
    }

    public final void zzar() {
        if (!(zza().getApplicationContext() instanceof Application) || this.zzb == null) {
            return;
        }
        ((Application) zza().getApplicationContext()).unregisterActivityLifecycleCallbacks(this.zzb);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzas() {
        if (com.google.android.gms.internal.measurement.zzoy.zza() && zze().zza(zzbn.zzcq)) {
            if (zzl().zzm()) {
                zzj().zzg().zza("Cannot get trigger URIs from analytics worker thread");
                return;
            }
            if (zzaf.zza()) {
                zzj().zzg().zza("Cannot get trigger URIs from main thread");
                return;
            }
            zzw();
            zzj().zzq().zza("Getting trigger URIs (FE)");
            final AtomicReference atomicReference = new AtomicReference();
            zzl().zza(atomicReference, 10000L, "get trigger URIs", new Runnable() { // from class: com.google.android.gms.measurement.internal.zzjy
                @Override // java.lang.Runnable
                public final void run() {
                    zzju.zza(zzju.this, atomicReference);
                }
            });
            final List list = (List) atomicReference.get();
            if (list == null) {
                zzj().zzg().zza("Timed out waiting for get trigger URIs");
            } else {
                zzl().zzb(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzkb
                    @Override // java.lang.Runnable
                    public final void run() {
                        zzju.zza(zzju.this, list);
                    }
                });
            }
        }
    }

    public final void zzat() {
        zzv();
        if (zzk().zzo.zza()) {
            zzj().zzc().zza("Deferred Deep Link already retrieved. Not fetching again.");
            return;
        }
        long zza = zzk().zzp.zza();
        zzk().zzp.zza(1 + zza);
        if (zza >= 5) {
            zzj().zzr().zza("Permanently failed to retrieve Deferred Deep Link. Reached maximum retries.");
            zzk().zzo.zza(true);
        } else {
            if (this.zzr == null) {
                this.zzr = new zzku(this, this.zzu);
            }
            this.zzr.zza(0L);
        }
    }

    public final void zzau() {
        zzv();
        zzj().zzc().zza("Handle tcf update.");
        zzoe zza = zzoe.zza(zzk().zzc());
        zzj().zzq().zza("Tcf preferences read", zza);
        if (zzk().zza(zza)) {
            Bundle zza2 = zza.zza();
            zzj().zzq().zza("Consent generated from Tcf", zza2);
            if (zza2 != Bundle.EMPTY) {
                zza(zza2, -30, zzb().currentTimeMillis());
            }
            Bundle bundle = new Bundle();
            bundle.putString("_tcfd", zza.zzb());
            zzc("auto", "_tcf", bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @TargetApi(30)
    public final void zzav() {
        zzog poll;
        MeasurementManagerFutures zzp;
        zzv();
        this.zzm = false;
        if (zzan().isEmpty() || this.zzh || (poll = zzan().poll()) == null || (zzp = zzs().zzp()) == null) {
            return;
        }
        this.zzh = true;
        zzj().zzq().zza("Registering trigger URI", poll.zza);
        ListenableFuture<Unit> registerTriggerAsync = zzp.registerTriggerAsync(Uri.parse(poll.zza));
        if (registerTriggerAsync != null) {
            Futures.addCallback(registerTriggerAsync, new zzkk(this, poll), new zzkl(this));
        } else {
            this.zzh = false;
            zzan().add(poll);
        }
    }

    public final void zzaw() {
        zzv();
        zzj().zzc().zza("Register tcfPrefChangeListener.");
        if (this.zzs == null) {
            this.zzt = new zzkr(this, this.zzu);
            this.zzs = new SharedPreferences.OnSharedPreferenceChangeListener() { // from class: com.google.android.gms.measurement.internal.zzkh
                @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
                public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
                    zzju.zza(zzju.this, sharedPreferences, str);
                }
            };
        }
        zzk().zzc().registerOnSharedPreferenceChangeListener(this.zzs);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzax() {
        return this.zzm;
    }

    @Override // com.google.android.gms.measurement.internal.zzjf, com.google.android.gms.measurement.internal.zzjh
    public final /* bridge */ /* synthetic */ zzaf zzd() {
        return super.zzd();
    }

    @Override // com.google.android.gms.measurement.internal.zzjf
    public final /* bridge */ /* synthetic */ zzai zze() {
        return super.zze();
    }

    @Override // com.google.android.gms.measurement.internal.zzjf
    public final /* bridge */ /* synthetic */ zzbf zzf() {
        return super.zzf();
    }

    @Override // com.google.android.gms.measurement.internal.zzg
    public final /* bridge */ /* synthetic */ zzgg zzg() {
        return super.zzg();
    }

    @Override // com.google.android.gms.measurement.internal.zzg
    public final /* bridge */ /* synthetic */ zzgj zzh() {
        return super.zzh();
    }

    @Override // com.google.android.gms.measurement.internal.zzjf
    public final /* bridge */ /* synthetic */ zzgl zzi() {
        return super.zzi();
    }

    @Override // com.google.android.gms.measurement.internal.zzjf, com.google.android.gms.measurement.internal.zzjh
    public final /* bridge */ /* synthetic */ zzgo zzj() {
        return super.zzj();
    }

    @Override // com.google.android.gms.measurement.internal.zzjf
    public final /* bridge */ /* synthetic */ zzha zzk() {
        return super.zzk();
    }

    @Override // com.google.android.gms.measurement.internal.zzjf, com.google.android.gms.measurement.internal.zzjh
    public final /* bridge */ /* synthetic */ zzhv zzl() {
        return super.zzl();
    }

    @Override // com.google.android.gms.measurement.internal.zzg
    public final /* bridge */ /* synthetic */ zzju zzm() {
        return super.zzm();
    }

    @Override // com.google.android.gms.measurement.internal.zzjf
    public final /* bridge */ /* synthetic */ zzlp zzn() {
        return super.zzn();
    }

    @Override // com.google.android.gms.measurement.internal.zzg
    public final /* bridge */ /* synthetic */ zzls zzo() {
        return super.zzo();
    }

    @Override // com.google.android.gms.measurement.internal.zzg
    public final /* bridge */ /* synthetic */ zzlz zzp() {
        return super.zzp();
    }

    @Override // com.google.android.gms.measurement.internal.zzg
    public final /* bridge */ /* synthetic */ zzme zzq() {
        return super.zzq();
    }

    @Override // com.google.android.gms.measurement.internal.zzg
    public final /* bridge */ /* synthetic */ zznx zzr() {
        return super.zzr();
    }

    @Override // com.google.android.gms.measurement.internal.zzjf
    public final /* bridge */ /* synthetic */ zzpn zzs() {
        return super.zzs();
    }

    @Override // com.google.android.gms.measurement.internal.zzg, com.google.android.gms.measurement.internal.zzjf
    public final /* bridge */ /* synthetic */ void zzt() {
        super.zzt();
    }

    @Override // com.google.android.gms.measurement.internal.zzg, com.google.android.gms.measurement.internal.zzjf
    public final /* bridge */ /* synthetic */ void zzu() {
        super.zzu();
    }

    @Override // com.google.android.gms.measurement.internal.zzg, com.google.android.gms.measurement.internal.zzjf
    public final /* bridge */ /* synthetic */ void zzv() {
        super.zzv();
    }

    @Override // com.google.android.gms.measurement.internal.zzjf, com.google.android.gms.measurement.internal.zzjh
    public final /* bridge */ /* synthetic */ Clock zzb() {
        return super.zzb();
    }

    @Override // com.google.android.gms.measurement.internal.zzg
    public final /* bridge */ /* synthetic */ zza zzc() {
        return super.zzc();
    }

    public final void zzd(long j5) {
        zzl().zzb(new zzko(this, j5));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzc(zzju zzjuVar, Bundle bundle) {
        zzjuVar.zzv();
        zzjuVar.zzw();
        Preconditions.checkNotNull(bundle);
        String string = bundle.getString("name");
        String string2 = bundle.getString("origin");
        Preconditions.checkNotEmpty(string);
        Preconditions.checkNotEmpty(string2);
        Preconditions.checkNotNull(bundle.get("value"));
        if (!zzjuVar.zzu.zzae()) {
            zzjuVar.zzj().zzq().zza("Conditional property not set since app measurement is disabled");
            return;
        }
        zzpm zzpmVar = new zzpm(string, bundle.getLong("triggered_timestamp"), bundle.get("value"), string2);
        try {
            zzbl zza = zzjuVar.zzs().zza(bundle.getString("app_id"), bundle.getString("triggered_event_name"), bundle.getBundle("triggered_event_params"), string2, 0L, true, true);
            zzjuVar.zzq().zza(new zzag(bundle.getString("app_id"), string2, zzpmVar, bundle.getLong("creation_timestamp"), false, bundle.getString("trigger_event_name"), zzjuVar.zzs().zza(bundle.getString("app_id"), bundle.getString("timed_out_event_name"), bundle.getBundle("timed_out_event_params"), string2, 0L, true, true), bundle.getLong("trigger_timeout"), zza, bundle.getLong("time_to_live"), zzjuVar.zzs().zza(bundle.getString("app_id"), bundle.getString("expired_event_name"), bundle.getBundle("expired_event_params"), string2, 0L, true, true)));
        } catch (IllegalArgumentException unused) {
        }
    }

    public static int zza(String str) {
        Preconditions.checkNotEmpty(str);
        return 25;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzb(zzju zzjuVar, Bundle bundle) {
        zzjuVar.zzv();
        zzjuVar.zzw();
        Preconditions.checkNotNull(bundle);
        String checkNotEmpty = Preconditions.checkNotEmpty(bundle.getString("name"));
        if (!zzjuVar.zzu.zzae()) {
            zzjuVar.zzj().zzq().zza("Conditional property not cleared since app measurement is disabled");
            return;
        }
        try {
            zzjuVar.zzq().zza(new zzag(bundle.getString("app_id"), BuildConfig.FLAVOR, new zzpm(checkNotEmpty, 0L, null, BuildConfig.FLAVOR), bundle.getLong("creation_timestamp"), bundle.getBoolean("active"), bundle.getString("trigger_event_name"), null, bundle.getLong("trigger_timeout"), null, bundle.getLong("time_to_live"), zzjuVar.zzs().zza(bundle.getString("app_id"), bundle.getString("expired_event_name"), bundle.getBundle("expired_event_params"), BuildConfig.FLAVOR, bundle.getLong("creation_timestamp"), true, true)));
        } catch (IllegalArgumentException unused) {
        }
    }

    @Override // com.google.android.gms.measurement.internal.zzjf, com.google.android.gms.measurement.internal.zzjh
    public final /* bridge */ /* synthetic */ Context zza() {
        return super.zza();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ int zza(zzju zzjuVar, Throwable th) {
        String message = th.getMessage();
        zzjuVar.zzm = false;
        if (message == null) {
            return 2;
        }
        if (!(th instanceof IllegalStateException) && !message.contains("garbage collected") && !th.getClass().getSimpleName().equals("ServiceUnavailableException")) {
            return (!(th instanceof SecurityException) || message.endsWith("READ_DEVICE_CONFIG")) ? 2 : 3;
        }
        if (message.contains("Background")) {
            zzjuVar.zzm = true;
        }
        return 1;
    }

    public final ArrayList<Bundle> zza(String str, String str2) {
        if (zzl().zzm()) {
            zzj().zzg().zza("Cannot get conditional user properties from analytics worker thread");
            return new ArrayList<>(0);
        }
        if (zzaf.zza()) {
            zzj().zzg().zza("Cannot get conditional user properties from main thread");
            return new ArrayList<>(0);
        }
        AtomicReference atomicReference = new AtomicReference();
        this.zzu.zzl().zza(atomicReference, 5000L, "get conditional user properties", new zzky(this, atomicReference, null, str, str2));
        List list = (List) atomicReference.get();
        if (list == null) {
            zzj().zzg().zza("Timed out waiting for get conditional user properties", null);
            return new ArrayList<>();
        }
        return zzpn.zzb((List<zzag>) list);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzb(zzju zzjuVar, int i5) {
        if (zzjuVar.zzj == null) {
            zzjuVar.zzj = new zzkn(zzjuVar, zzjuVar.zzu);
        }
        zzjuVar.zzj.zza(i5 * 1000);
    }

    public final void zzb(String str, String str2, Bundle bundle) {
        zza(str, str2, bundle, true, true, zzb().currentTimeMillis());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzb(long j5) {
        zzv();
        zzw();
        zzj().zzc().zza("Resetting analytics data (FE)");
        zznx zzr = zzr();
        zzr.zzv();
        zzr.zzb.zza();
        zzg().zzaj();
        boolean zzae = this.zzu.zzae();
        zzha zzk = zzk();
        zzk.zzc.zza(j5);
        if (!TextUtils.isEmpty(zzk.zzk().zzq.zza())) {
            zzk.zzq.zza(null);
        }
        zzk.zzk.zza(0L);
        zzk.zzl.zza(0L);
        if (!zzk.zze().zzy()) {
            zzk.zzb(!zzae);
        }
        zzk.zzr.zza(null);
        zzk.zzs.zza(0L);
        zzk.zzt.zza(null);
        zzq().zzai();
        zzr().zza.zza();
        this.zzq = !zzae;
    }

    public final Map<String, Object> zza(String str, String str2, boolean z5) {
        if (zzl().zzm()) {
            zzj().zzg().zza("Cannot get user properties from analytics worker thread");
            return Collections.emptyMap();
        }
        if (zzaf.zza()) {
            zzj().zzg().zza("Cannot get user properties from main thread");
            return Collections.emptyMap();
        }
        AtomicReference atomicReference = new AtomicReference();
        this.zzu.zzl().zza(atomicReference, 5000L, "get user properties", new zzlb(this, atomicReference, null, str, str2, z5));
        List<zzpm> list = (List) atomicReference.get();
        if (list == null) {
            zzj().zzg().zza("Timed out waiting for handle get user properties, includeInternal", Boolean.valueOf(z5));
            return Collections.emptyMap();
        }
        ArrayMap arrayMap = new ArrayMap(list.size());
        for (zzpm zzpmVar : list) {
            Object zza = zzpmVar.zza();
            if (zza != null) {
                arrayMap.put(zzpmVar.zza, zza);
            }
        }
        return arrayMap;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzc(String str, String str2, Bundle bundle) {
        zzv();
        zza(str, str2, zzb().currentTimeMillis(), bundle);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzc(long j5) {
        zzv();
        if (this.zzk == null) {
            this.zzk = new zzkj(this, this.zzu);
        }
        this.zzk.zza(j5);
    }

    public final void zzc(Bundle bundle, long j5) {
        zza(bundle, -20, j5);
    }

    public final void zzc(boolean z5) {
        zzw();
        zzl().zzb(new zzkm(this, z5));
    }

    public static /* synthetic */ void zza(zzju zzjuVar, AtomicReference atomicReference) {
        Bundle zza = zzjuVar.zzk().zzi.zza();
        zzme zzq = zzjuVar.zzq();
        if (zza == null) {
            zza = new Bundle();
        }
        zzq.zza((AtomicReference<List<zzog>>) atomicReference, zza);
    }

    private final void zzb(String str, String str2, long j5, Bundle bundle, boolean z5, boolean z6, boolean z7, String str3) {
        zzl().zzb(new zzkq(this, str, str2, j5, zzpn.zza(bundle), z5, z6, z7, str3));
    }

    public static /* synthetic */ void zza(zzju zzjuVar, List list) {
        boolean contains;
        zzjuVar.zzv();
        if (Build.VERSION.SDK_INT >= 30) {
            SparseArray<Long> zzm = zzjuVar.zzk().zzm();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                zzog zzogVar = (zzog) it.next();
                contains = zzm.contains(zzogVar.zzc);
                if (!contains || zzm.get(zzogVar.zzc).longValue() < zzogVar.zzb) {
                    zzjuVar.zzan().add(zzogVar);
                }
            }
            zzjuVar.zzav();
        }
    }

    public final void zzb(boolean z5) {
        if (zza().getApplicationContext() instanceof Application) {
            Application application = (Application) zza().getApplicationContext();
            if (this.zzb == null) {
                this.zzb = new zzlk(this);
            }
            if (z5) {
                application.unregisterActivityLifecycleCallbacks(this.zzb);
                application.registerActivityLifecycleCallbacks(this.zzb);
                zzj().zzq().zza("Registered activity lifecycle callback");
            }
        }
    }

    public static /* synthetic */ void zza(zzju zzjuVar, Bundle bundle, long j5) {
        if (TextUtils.isEmpty(zzjuVar.zzg().zzah())) {
            zzjuVar.zza(bundle, 0, j5);
        } else {
            zzjuVar.zzj().zzw().zza("Using developer consent only; google app id found");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzb(String str) {
        this.zzf.set(str);
    }

    public final void zzb(final Bundle bundle, final long j5) {
        zzl().zzc(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzkf
            @Override // java.lang.Runnable
            public final void run() {
                zzju.zza(zzju.this, bundle, j5);
            }
        });
    }

    public static /* synthetic */ void zza(zzju zzjuVar, Bundle bundle) {
        Bundle bundle2;
        if (bundle.isEmpty()) {
            bundle2 = bundle;
        } else {
            bundle2 = new Bundle(zzjuVar.zzk().zzt.zza());
            for (String str : bundle.keySet()) {
                Object obj = bundle.get(str);
                if (obj != null && !(obj instanceof String) && !(obj instanceof Long) && !(obj instanceof Double)) {
                    zzjuVar.zzs();
                    if (zzpn.zza(obj)) {
                        zzjuVar.zzs();
                        zzpn.zza(zzjuVar.zzv, 27, (String) null, (String) null, 0);
                    }
                    zzjuVar.zzj().zzw().zza("Invalid default event parameter type. Name, value", str, obj);
                } else if (zzpn.zzf(str)) {
                    zzjuVar.zzj().zzw().zza("Invalid default event parameter name. Name", str);
                } else if (obj == null) {
                    bundle2.remove(str);
                } else if (zzjuVar.zzs().zza("param", str, zzjuVar.zze().zza((String) null, false), obj)) {
                    zzjuVar.zzs().zza(bundle2, str, obj);
                }
            }
            zzjuVar.zzs();
            if (zzpn.zza(bundle2, zzjuVar.zze().zzc())) {
                zzjuVar.zzs();
                zzpn.zza(zzjuVar.zzv, 26, (String) null, (String) null, 0);
                zzjuVar.zzj().zzw().zza("Too many default event parameters set. Discarding beyond event parameter limit");
            }
        }
        zzjuVar.zzk().zzt.zza(bundle2);
        if (!bundle.isEmpty() || zzjuVar.zze().zza(zzbn.zzcy)) {
            zzjuVar.zzq().zza(bundle2);
        }
    }

    public final void zzb(Bundle bundle) {
        final Bundle bundle2 = bundle == null ? new Bundle() : new Bundle(bundle);
        zzl().zzb(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzka
            @Override // java.lang.Runnable
            public final void run() {
                zzju.zza(zzju.this, bundle2);
            }
        });
    }

    public final void zzb(zzjt zzjtVar) {
        zzw();
        Preconditions.checkNotNull(zzjtVar);
        if (this.zzd.remove(zzjtVar)) {
            return;
        }
        zzj().zzr().zza("OnEventListener had not been registered");
    }

    public static /* synthetic */ void zza(zzju zzjuVar, AtomicReference atomicReference, zzon zzonVar, String str, int i5, Throwable th, byte[] bArr, Map map) {
        int zza;
        zzjuVar.zzv();
        boolean z5 = (i5 == 200 || i5 == 204 || i5 == 304) && th == null;
        if (z5) {
            zzjuVar.zzj().zzq().zza("[sgtm] Upload succeeded for row_id", Long.valueOf(zzonVar.zza));
        } else {
            zzjuVar.zzj().zzr().zza("[sgtm] Upload failed for row_id. response, exception", Long.valueOf(zzonVar.zza), Integer.valueOf(i5), th);
        }
        zzme zzq = zzjuVar.zzq();
        long j5 = zzonVar.zza;
        if (z5) {
            zza = zzlv.SUCCESS.zza();
        } else {
            zza = zzlv.FAILURE.zza();
        }
        zzq.zza(new zzae(j5, zza, zzonVar.zze));
        zzjuVar.zzj().zzq().zza("[sgtm] Updated status for row_id", Long.valueOf(zzonVar.zza), z5 ? "SUCCESS" : "FAILURE");
        synchronized (atomicReference) {
            atomicReference.set(Boolean.valueOf(z5));
            atomicReference.notifyAll();
        }
    }

    public static /* synthetic */ void zza(zzju zzjuVar, SharedPreferences sharedPreferences, String str) {
        if ("IABTCF_TCString".equals(str)) {
            zzjuVar.zzj().zzq().zza("IABTCF_TCString change picked up in listener.");
            ((zzbb) Preconditions.checkNotNull(zzjuVar.zzt)).zza(500L);
        }
    }

    public static /* synthetic */ void zza(zzju zzjuVar, String str) {
        if (zzjuVar.zzg().zzb(str)) {
            zzjuVar.zzg().zzaj();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zza(zzju zzjuVar, zzjj zzjjVar, long j5, boolean z5, boolean z6) {
        zzjuVar.zzv();
        zzjuVar.zzw();
        zzjj zzp = zzjuVar.zzk().zzp();
        if (j5 <= zzjuVar.zzp && zzjj.zza(zzp.zza(), zzjjVar.zza())) {
            zzjuVar.zzj().zzp().zza("Dropped out-of-date consent setting, proposed settings", zzjjVar);
            return;
        }
        if (zzjuVar.zzk().zza(zzjjVar)) {
            zzjuVar.zzj().zzq().zza("Setting storage consent(FE)", zzjjVar);
            zzjuVar.zzp = j5;
            if (zzjuVar.zzq().zzao()) {
                zzjuVar.zzq().zzb(z5);
            } else {
                zzjuVar.zzq().zza(z5);
            }
            if (z6) {
                zzjuVar.zzq().zza(new AtomicReference<>());
                return;
            }
            return;
        }
        zzjuVar.zzj().zzp().zza("Lower precedence consent source ignored, proposed source", Integer.valueOf(zzjjVar.zza()));
    }

    public final void zza(String str, String str2, Bundle bundle) {
        long currentTimeMillis = zzb().currentTimeMillis();
        Preconditions.checkNotEmpty(str);
        Bundle bundle2 = new Bundle();
        bundle2.putString("name", str);
        bundle2.putLong("creation_timestamp", currentTimeMillis);
        if (str2 != null) {
            bundle2.putString("expired_event_name", str2);
            bundle2.putBundle("expired_event_params", bundle);
        }
        zzl().zzb(new zzkz(this, bundle2));
    }

    public final void zza(com.google.android.gms.internal.measurement.zzdq zzdqVar) {
        zzl().zzb(new zzla(this, zzdqVar));
    }

    public final void zza(String str, String str2, Bundle bundle, boolean z5, boolean z6, long j5) {
        String str3 = str == null ? "app" : str;
        Bundle bundle2 = bundle == null ? new Bundle() : bundle;
        if (Objects.equals(str2, "screen_view")) {
            zzp().zza(bundle2, j5);
        } else {
            zzb(str3, str2, j5, bundle2, z6, !z6 || this.zzc == null || zzpn.zzf(str2), z5, null);
        }
    }

    public final void zza(String str, String str2, Bundle bundle, String str3) {
        zzu();
        zzb(str, str2, zzb().currentTimeMillis(), bundle, false, true, true, str3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zza(String str, String str2, long j5, Bundle bundle) {
        zzv();
        zza(str, str2, j5, bundle, true, this.zzc == null || zzpn.zzf(str2), true, (String) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zza(String str, String str2, long j5, Bundle bundle, boolean z5, boolean z6, boolean z7, String str3) {
        boolean zza;
        String str4;
        ArrayList arrayList;
        long j6;
        int i5;
        Object obj;
        int length;
        Class<?> cls;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(bundle);
        zzv();
        zzw();
        if (!this.zzu.zzae()) {
            zzj().zzc().zza("Event not sent since app measurement is disabled");
            return;
        }
        List<String> zzai = zzg().zzai();
        if (zzai != null && !zzai.contains(str2)) {
            zzj().zzc().zza("Dropping non-safelisted event. event name, origin", str2, str);
            return;
        }
        if (!this.zze) {
            this.zze = true;
            try {
                if (!this.zzu.zzai()) {
                    cls = Class.forName("com.google.android.gms.tagmanager.TagManagerService", true, zza().getClassLoader());
                } else {
                    cls = Class.forName("com.google.android.gms.tagmanager.TagManagerService");
                }
                try {
                    cls.getDeclaredMethod("initialize", Context.class).invoke(null, zza());
                } catch (Exception e5) {
                    zzj().zzr().zza("Failed to invoke Tag Manager's initialize() method", e5);
                }
            } catch (ClassNotFoundException unused) {
                zzj().zzp().zza("Tag Manager is not found and thus will not be used");
            }
        }
        if ("_cmp".equals(str2) && bundle.containsKey("gclid")) {
            zza("auto", "_lgclid", bundle.getString("gclid"), zzb().currentTimeMillis());
        }
        if (z5 && zzpn.zzh(str2)) {
            zzs().zza(bundle, zzk().zzt.zza());
        }
        if (!z7 && !"_iap".equals(str2)) {
            zzpn zzv = this.zzu.zzv();
            int i6 = 2;
            if (zzv.zzc("event", str2)) {
                if (!zzv.zza("event", zzjp.zza, zzjp.zzb, str2)) {
                    i6 = 13;
                } else if (zzv.zza("event", 40, str2)) {
                    i6 = 0;
                }
            }
            if (i6 != 0) {
                zzj().zzm().zza("Invalid public event name. Event will not be logged (FE)", zzi().zza(str2));
                this.zzu.zzv();
                String zza2 = zzpn.zza(str2, 40, true);
                length = str2 != null ? str2.length() : 0;
                this.zzu.zzv();
                zzpn.zza(this.zzv, i6, "_ev", zza2, length);
                return;
            }
        }
        zzlw zza3 = zzp().zza(false);
        if (zza3 != null && !bundle.containsKey("_sc")) {
            zza3.zzd = true;
        }
        zzpn.zza(zza3, bundle, z5 && !z7);
        boolean equals = "am".equals(str);
        boolean zzf = zzpn.zzf(str2);
        if (z5 && this.zzc != null && !zzf && !equals) {
            zzj().zzc().zza("Passing event to registered event handler (FE)", zzi().zza(str2), zzi().zza(bundle));
            Preconditions.checkNotNull(this.zzc);
            this.zzc.interceptEvent(str, str2, bundle, j5);
            return;
        }
        if (this.zzu.zzah()) {
            int zza4 = zzs().zza(str2);
            if (zza4 != 0) {
                zzj().zzm().zza("Invalid event name. Event will not be logged (FE)", zzi().zza(str2));
                zzs();
                String zza5 = zzpn.zza(str2, 40, true);
                length = str2 != null ? str2.length() : 0;
                this.zzu.zzv();
                zzpn.zza(this.zzv, str3, zza4, "_ev", zza5, length);
                return;
            }
            String str5 = "_o";
            Bundle zza6 = zzs().zza(str3, str2, bundle, CollectionUtils.listOf((Object[]) new String[]{"_o", "_sn", "_sc", "_si"}), z7);
            Preconditions.checkNotNull(zza6);
            if (zzp().zza(false) != null && "_ae".equals(str2)) {
                zzod zzodVar = zzr().zzb;
                long elapsedRealtime = zzodVar.zzb.zzb().elapsedRealtime();
                long j7 = elapsedRealtime - zzodVar.zza;
                zzodVar.zza = elapsedRealtime;
                if (j7 > 0) {
                    zzs().zza(zza6, j7);
                }
            }
            if (!"auto".equals(str) && "_ssr".equals(str2)) {
                zzpn zzs = zzs();
                String string = zza6.getString("_ffr");
                if (Strings.isEmptyOrWhitespace(string)) {
                    string = null;
                } else if (string != null) {
                    string = string.trim();
                }
                if (Objects.equals(string, zzs.zzk().zzq.zza())) {
                    zzs.zzj().zzc().zza("Not logging duplicate session_start_with_rollout event");
                    return;
                }
                zzs.zzk().zzq.zza(string);
            } else if ("_ae".equals(str2)) {
                String zza7 = zzs().zzk().zzq.zza();
                if (!TextUtils.isEmpty(zza7)) {
                    zza6.putString("_ffr", zza7);
                }
            }
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(zza6);
            if (zze().zza(zzbn.zzcv)) {
                zza = zzr().zzac();
            } else {
                zza = zzk().zzn.zza();
            }
            if (zzk().zzk.zza() <= 0 || !zzk().zza(j5) || !zza) {
                str4 = "_ae";
                arrayList = arrayList2;
                j6 = 0;
            } else {
                zzj().zzq().zza("Current session is expired, remove the session number, ID, and engagement time");
                arrayList = arrayList2;
                j6 = 0;
                str4 = "_ae";
                zza("auto", "_sid", (Object) null, zzb().currentTimeMillis());
                zza("auto", "_sno", (Object) null, zzb().currentTimeMillis());
                zza("auto", "_se", (Object) null, zzb().currentTimeMillis());
                zzk().zzl.zza(0L);
            }
            if (zza6.getLong("extend_session", j6) == 1) {
                zzj().zzq().zza("EXTEND_SESSION param attached: initiate a new session or extend the current active session");
                i5 = 1;
                this.zzu.zzu().zza.zza(j5, true);
            } else {
                i5 = 1;
            }
            ArrayList arrayList3 = new ArrayList(zza6.keySet());
            Collections.sort(arrayList3);
            int size = arrayList3.size();
            int i7 = 0;
            while (i7 < size) {
                Object obj2 = arrayList3.get(i7);
                i7 += i5;
                String str6 = (String) obj2;
                if (str6 != null) {
                    zzs();
                    Bundle[] zzb = zzpn.zzb(zza6.get(str6));
                    if (zzb != null) {
                        zza6.putParcelableArray(str6, zzb);
                    }
                }
                i5 = 1;
            }
            int i8 = 0;
            while (i8 < arrayList.size()) {
                ArrayList arrayList4 = arrayList;
                Bundle bundle2 = (Bundle) arrayList4.get(i8);
                String str7 = i8 != 0 ? "_ep" : str2;
                bundle2.putString(str5, str);
                if (z6) {
                    obj = null;
                    bundle2 = zzs().zza(bundle2, (String) null);
                } else {
                    obj = null;
                }
                Bundle bundle3 = bundle2;
                String str8 = str5;
                zzq().zza(new zzbl(str7, new zzbg(bundle3), str, j5), str3);
                if (!equals) {
                    Iterator<zzjt> it = this.zzd.iterator();
                    while (it.hasNext()) {
                        it.next().onEvent(str, str2, new Bundle(bundle3), j5);
                    }
                }
                i8++;
                arrayList = arrayList4;
                str5 = str8;
            }
            if (zzp().zza(false) == null || !str4.equals(str2)) {
                return;
            }
            zzr().zza(true, true, zzb().elapsedRealtime());
        }
    }

    public final void zza(zzjt zzjtVar) {
        zzw();
        Preconditions.checkNotNull(zzjtVar);
        if (this.zzd.add(zzjtVar)) {
            return;
        }
        zzj().zzr().zza("OnEventListener already registered");
    }

    public final void zza(long j5) {
        zzb((String) null);
        zzl().zzb(new zzkx(this, j5));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zza(Runnable runnable) {
        if (zze().zza(zzbn.zzcl)) {
            zzw();
            if (zzl().zzm()) {
                zzj().zzg().zza("Cannot retrieve and upload batches from analytics worker thread");
                return;
            }
            if (zzl().zzg()) {
                zzj().zzg().zza("Cannot retrieve and upload batches from analytics network thread");
                return;
            }
            if (zzaf.zza()) {
                zzj().zzg().zza("Cannot retrieve and upload batches from main thread");
                return;
            }
            zzj().zzq().zza("[sgtm] Started client-side batch upload work.");
            boolean z5 = false;
            int i5 = 0;
            int i6 = 0;
            while (!z5) {
                zzj().zzq().zza("[sgtm] Getting upload batches from service (FE)");
                final AtomicReference atomicReference = new AtomicReference();
                zzl().zza(atomicReference, 10000L, "[sgtm] Getting upload batches", new Runnable() { // from class: com.google.android.gms.measurement.internal.zzkd
                    @Override // java.lang.Runnable
                    public final void run() {
                        zzju.this.zzq().zza((AtomicReference<zzor>) atomicReference, zzop.zza(zzlu.SGTM_CLIENT));
                    }
                });
                zzor zzorVar = (zzor) atomicReference.get();
                if (zzorVar != null && !zzorVar.zza.isEmpty()) {
                    zzj().zzq().zza("[sgtm] Retrieved upload batches. count", Integer.valueOf(zzorVar.zza.size()));
                    i5 += zzorVar.zza.size();
                    Iterator<zzon> it = zzorVar.zza.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        if (!zza(it.next())) {
                            z5 = true;
                            break;
                        }
                        i6++;
                    }
                } else {
                    break;
                }
            }
            zzj().zzq().zza("[sgtm] Completed client-side batch upload work. total, success", Integer.valueOf(i5), Integer.valueOf(i6));
            runnable.run();
        }
    }

    private final void zza(String str, String str2, long j5, Object obj) {
        zzl().zzb(new zzkt(this, str, str2, obj, j5));
    }

    public final void zza(Bundle bundle) {
        zza(bundle, zzb().currentTimeMillis());
    }

    public final void zza(Bundle bundle, long j5) {
        Preconditions.checkNotNull(bundle);
        Bundle bundle2 = new Bundle(bundle);
        if (!TextUtils.isEmpty(bundle2.getString("app_id"))) {
            zzj().zzr().zza("Package name should be null when calling setConditionalUserProperty");
        }
        bundle2.remove("app_id");
        Preconditions.checkNotNull(bundle2);
        zzjk.zza(bundle2, "app_id", String.class, null);
        zzjk.zza(bundle2, "origin", String.class, null);
        zzjk.zza(bundle2, "name", String.class, null);
        zzjk.zza(bundle2, "value", Object.class, null);
        zzjk.zza(bundle2, "trigger_event_name", String.class, null);
        zzjk.zza(bundle2, "trigger_timeout", Long.class, 0L);
        zzjk.zza(bundle2, "timed_out_event_name", String.class, null);
        zzjk.zza(bundle2, "timed_out_event_params", Bundle.class, null);
        zzjk.zza(bundle2, "triggered_event_name", String.class, null);
        zzjk.zza(bundle2, "triggered_event_params", Bundle.class, null);
        zzjk.zza(bundle2, "time_to_live", Long.class, 0L);
        zzjk.zza(bundle2, "expired_event_name", String.class, null);
        zzjk.zza(bundle2, "expired_event_params", Bundle.class, null);
        Preconditions.checkNotEmpty(bundle2.getString("name"));
        Preconditions.checkNotEmpty(bundle2.getString("origin"));
        Preconditions.checkNotNull(bundle2.get("value"));
        bundle2.putLong("creation_timestamp", j5);
        String string = bundle2.getString("name");
        Object obj = bundle2.get("value");
        if (zzs().zzb(string) != 0) {
            zzj().zzg().zza("Invalid conditional user property name", zzi().zzc(string));
            return;
        }
        if (zzs().zza(string, obj) != 0) {
            zzj().zzg().zza("Invalid conditional user property value", zzi().zzc(string), obj);
            return;
        }
        Object zzc = zzs().zzc(string, obj);
        if (zzc == null) {
            zzj().zzg().zza("Unable to normalize conditional user property value", zzi().zzc(string), obj);
            return;
        }
        zzjk.zza(bundle2, zzc);
        long j6 = bundle2.getLong("trigger_timeout");
        if (!TextUtils.isEmpty(bundle2.getString("trigger_event_name")) && (j6 > 15552000000L || j6 < 1)) {
            zzj().zzg().zza("Invalid conditional user property timeout", zzi().zzc(string), Long.valueOf(j6));
            return;
        }
        long j7 = bundle2.getLong("time_to_live");
        if (j7 <= 15552000000L && j7 >= 1) {
            zzl().zzb(new zzkw(this, bundle2));
        } else {
            zzj().zzg().zza("Invalid conditional user property time to live", zzi().zzc(string), Long.valueOf(j7));
        }
    }

    private final void zza(Bundle bundle, int i5, long j5) {
        String str;
        zzw();
        String zza = zzjj.zza(bundle);
        if (zza != null) {
            zzj().zzw().zza("Ignoring invalid consent setting", zza);
            zzj().zzw().zza("Valid consent values are 'granted', 'denied'");
        }
        boolean zzm = zzl().zzm();
        zzjj zza2 = zzjj.zza(bundle, i5);
        if (zza2.zzi()) {
            zza(zza2, zzm);
        }
        zzbd zza3 = zzbd.zza(bundle, i5);
        if (zza3.zzg()) {
            zza(zza3, zzm);
        }
        Boolean zza4 = zzbd.zza(bundle);
        if (zza4 != null) {
            if (i5 == -30) {
                str = "tcf";
            } else {
                str = "app";
            }
            String str2 = str;
            if (zzm) {
                zza(str2, "allow_personalized_ads", zza4.toString(), j5);
            } else {
                zza(str2, "allow_personalized_ads", (Object) zza4.toString(), false, j5);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zza(zzbd zzbdVar, boolean z5) {
        zzlg zzlgVar = new zzlg(this, zzbdVar);
        if (z5) {
            zzv();
            zzlgVar.run();
        } else {
            zzl().zzb(zzlgVar);
        }
    }

    public final void zza(zzjq zzjqVar) {
        zzjq zzjqVar2;
        zzv();
        zzw();
        if (zzjqVar != null && zzjqVar != (zzjqVar2 = this.zzc)) {
            Preconditions.checkState(zzjqVar2 == null, "EventInterceptor already set.");
        }
        this.zzc = zzjqVar;
    }

    public final void zza(Boolean bool) {
        zzw();
        zzl().zzb(new zzlh(this, bool));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zza(zzjj zzjjVar) {
        zzv();
        boolean z5 = (zzjjVar.zzh() && zzjjVar.zzg()) || zzq().zzan();
        if (z5 != this.zzu.zzaf()) {
            this.zzu.zzb(z5);
            Boolean zzr = zzk().zzr();
            if (!z5 || zzr == null || zzr.booleanValue()) {
                zza(Boolean.valueOf(z5), false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(Boolean bool, boolean z5) {
        zzv();
        zzw();
        zzj().zzc().zza("Setting app measurement enabled (FE)", bool);
        zzk().zza(bool);
        if (z5) {
            zzk().zzb(bool);
        }
        if (this.zzu.zzaf() || !(bool == null || bool.booleanValue())) {
            zzay();
        }
    }

    public final void zza(Intent intent) {
        Uri data = intent.getData();
        if (data == null) {
            zzj().zzp().zza("Activity intent has no data. Preview Mode was not enabled.");
            return;
        }
        String queryParameter = data.getQueryParameter("sgtm_debug_enable");
        if (queryParameter != null && queryParameter.equals("1")) {
            String queryParameter2 = data.getQueryParameter("sgtm_preview_key");
            if (TextUtils.isEmpty(queryParameter2)) {
                return;
            }
            zzj().zzp().zza("Preview Mode was enabled. Using the sgtmPreviewKey: ", queryParameter2);
            zze().zzh(queryParameter2);
            return;
        }
        zzj().zzp().zza("Preview Mode was not enabled.");
        zze().zzh(null);
    }

    public final void zza(zzjj zzjjVar, boolean z5) {
        boolean z6;
        zzjj zzjjVar2;
        boolean z7;
        boolean z8;
        zzw();
        int zza = zzjjVar.zza();
        if (zza != -10) {
            zzjm zzc = zzjjVar.zzc();
            zzjm zzjmVar = zzjm.UNINITIALIZED;
            if (zzc == zzjmVar && zzjjVar.zzd() == zzjmVar) {
                zzj().zzw().zza("Ignoring empty consent settings");
                return;
            }
        }
        synchronized (this.zzg) {
            try {
                z6 = false;
                if (zzjj.zza(zza, this.zzn.zza())) {
                    z7 = zzjjVar.zzc(this.zzn);
                    if (zzjjVar.zzh() && !this.zzn.zzh()) {
                        z6 = true;
                    }
                    zzjj zzb = zzjjVar.zzb(this.zzn);
                    this.zzn = zzb;
                    zzjjVar2 = zzb;
                    z8 = z6;
                    z6 = true;
                } else {
                    zzjjVar2 = zzjjVar;
                    z7 = false;
                    z8 = false;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (!z6) {
            zzj().zzp().zza("Ignoring lower-priority consent settings, proposed settings", zzjjVar2);
            return;
        }
        long andIncrement = this.zzo.getAndIncrement();
        if (z7) {
            zzb((String) null);
            zzlj zzljVar = new zzlj(this, zzjjVar2, andIncrement, z8);
            if (z5) {
                zzv();
                zzljVar.run();
                return;
            } else {
                zzl().zzc(zzljVar);
                return;
            }
        }
        zzli zzliVar = new zzli(this, zzjjVar2, andIncrement, z8);
        if (z5) {
            zzv();
            zzliVar.run();
        } else if (zza != 30 && zza != -10) {
            zzl().zzb(zzliVar);
        } else {
            zzl().zzc(zzliVar);
        }
    }

    public final void zza(final String str, long j5) {
        if (str != null && TextUtils.isEmpty(str)) {
            this.zzu.zzj().zzr().zza("User ID must be non-empty or null");
        } else {
            zzl().zzb(new Runnable() { // from class: com.google.android.gms.measurement.internal.zzjz
                @Override // java.lang.Runnable
                public final void run() {
                    zzju.zza(zzju.this, str);
                }
            });
            zza((String) null, "_id", (Object) str, true, j5);
        }
    }

    public final void zza(String str, String str2, Object obj, boolean z5) {
        zza(str, str2, obj, z5, zzb().currentTimeMillis());
    }

    public final void zza(String str, String str2, Object obj, boolean z5, long j5) {
        int i5;
        int length;
        if (str == null) {
            str = "app";
        }
        String str3 = str;
        if (z5) {
            i5 = zzs().zzb(str2);
        } else {
            zzpn zzs = zzs();
            if (zzs.zzc("user property", str2)) {
                if (!zzs.zza("user property", zzjr.zza, str2)) {
                    i5 = 15;
                } else if (zzs.zza("user property", 24, str2)) {
                    i5 = 0;
                }
            }
            i5 = 6;
        }
        if (i5 != 0) {
            zzs();
            String zza = zzpn.zza(str2, 24, true);
            length = str2 != null ? str2.length() : 0;
            this.zzu.zzv();
            zzpn.zza(this.zzv, i5, "_ev", zza, length);
            return;
        }
        if (obj != null) {
            int zza2 = zzs().zza(str2, obj);
            if (zza2 != 0) {
                zzs();
                String zza3 = zzpn.zza(str2, 24, true);
                length = ((obj instanceof String) || (obj instanceof CharSequence)) ? String.valueOf(obj).length() : 0;
                this.zzu.zzv();
                zzpn.zza(this.zzv, zza2, "_ev", zza3, length);
                return;
            }
            Object zzc = zzs().zzc(str2, obj);
            if (zzc != null) {
                zza(str3, str2, j5, zzc);
                return;
            }
            return;
        }
        zza(str3, str2, j5, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zza(String str, String str2, Object obj, long j5) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzv();
        zzw();
        if ("allow_personalized_ads".equals(str2)) {
            if (obj instanceof String) {
                String str3 = (String) obj;
                if (!TextUtils.isEmpty(str3)) {
                    Long valueOf = Long.valueOf("false".equals(str3.toLowerCase(Locale.ENGLISH)) ? 1L : 0L);
                    zzk().zzh.zza(valueOf.longValue() == 1 ? "true" : "false");
                    obj = valueOf;
                    str2 = "_npa";
                    zzj().zzq().zza("Setting user property(FE)", "non_personalized_ads(_npa)", obj);
                }
            }
            if (obj == null) {
                zzk().zzh.zza("unset");
                str2 = "_npa";
            }
            zzj().zzq().zza("Setting user property(FE)", "non_personalized_ads(_npa)", obj);
        }
        String str4 = str2;
        Object obj2 = obj;
        if (!this.zzu.zzae()) {
            zzj().zzq().zza("User property not set since app measurement is disabled");
        } else if (this.zzu.zzah()) {
            zzq().zza(new zzpm(str4, j5, obj2, str));
        }
    }

    private final boolean zza(final zzon zzonVar) {
        try {
            URL url = new URI(zzonVar.zzc).toURL();
            final AtomicReference atomicReference = new AtomicReference();
            String zzag = zzg().zzag();
            zzj().zzq().zza("[sgtm] Uploading data from app. row_id, url, uncompressed size", Long.valueOf(zzonVar.zza), zzonVar.zzc, Integer.valueOf(zzonVar.zzb.length));
            if (!TextUtils.isEmpty(zzonVar.zzf)) {
                zzj().zzq().zza("[sgtm] Uploading data from app. row_id", Long.valueOf(zzonVar.zza), zzonVar.zzf);
            }
            HashMap hashMap = new HashMap();
            for (String str : zzonVar.zzd.keySet()) {
                String string = zzonVar.zzd.getString(str);
                if (!TextUtils.isEmpty(string)) {
                    hashMap.put(str, string);
                }
            }
            zzlp zzn = zzn();
            byte[] bArr = zzonVar.zzb;
            zzlo zzloVar = new zzlo() { // from class: com.google.android.gms.measurement.internal.zzkc
                @Override // com.google.android.gms.measurement.internal.zzlo
                public final void zza(String str2, int i5, Throwable th, byte[] bArr2, Map map) {
                    zzju.zza(zzju.this, atomicReference, zzonVar, str2, i5, th, bArr2, map);
                }
            };
            zzn.zzad();
            Preconditions.checkNotNull(url);
            Preconditions.checkNotNull(bArr);
            Preconditions.checkNotNull(zzloVar);
            zzn.zzl().zza(new zzlr(zzn, zzag, url, bArr, hashMap, zzloVar));
            try {
                zzpn zzs = zzs();
                long currentTimeMillis = zzs.zzb().currentTimeMillis() + 60000;
                synchronized (atomicReference) {
                    for (long j5 = 60000; atomicReference.get() == null && j5 > 0; j5 = currentTimeMillis - zzs.zzb().currentTimeMillis()) {
                        try {
                            atomicReference.wait(j5);
                        } finally {
                        }
                    }
                }
            } catch (InterruptedException unused) {
                zzj().zzr().zza("[sgtm] Interrupted waiting for uploading batch");
            }
            return atomicReference.get() == Boolean.TRUE;
        } catch (MalformedURLException | URISyntaxException e5) {
            zzj().zzg().zza("[sgtm] Bad upload url for row_id", zzonVar.zzc, Long.valueOf(zzonVar.zza), e5);
            return false;
        }
    }
}
