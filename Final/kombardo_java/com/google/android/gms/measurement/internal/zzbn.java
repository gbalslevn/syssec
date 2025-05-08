package com.google.android.gms.measurement.internal;

import android.content.Context;
import com.adjust.sdk.Constants;
import com.google.android.gms.internal.measurement.zzpq;
import com.google.android.gms.internal.measurement.zzpr;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import org.conscrypt.BuildConfig;

/* loaded from: classes.dex */
public abstract class zzbn {
    public static final zzfx<Long> zza;
    public static final zzfx<Long> zzaa;
    public static final zzfx<Long> zzab;
    public static final zzfx<Long> zzac;
    public static final zzfx<Long> zzad;
    public static final zzfx<Long> zzae;
    public static final zzfx<Long> zzaf;
    public static final zzfx<Long> zzag;
    public static final zzfx<Long> zzah;
    public static final zzfx<Long> zzai;
    public static final zzfx<Long> zzaj;
    public static final zzfx<Long> zzak;
    public static final zzfx<Integer> zzal;
    public static final zzfx<Long> zzam;
    public static final zzfx<Long> zzan;
    public static final zzfx<Integer> zzao;
    public static final zzfx<Integer> zzap;
    public static final zzfx<Integer> zzaq;
    public static final zzfx<Integer> zzar;
    public static final zzfx<Integer> zzas;
    public static final zzfx<Long> zzat;
    public static final zzfx<Boolean> zzau;
    public static final zzfx<String> zzav;
    public static final zzfx<Long> zzaw;
    public static final zzfx<Integer> zzax;
    public static final zzfx<Double> zzay;
    public static final zzfx<Integer> zzaz;
    public static final zzfx<Long> zzb;
    public static final zzfx<Integer> zzba;
    public static final zzfx<Integer> zzbb;
    public static final zzfx<Integer> zzbc;
    public static final zzfx<Long> zzbd;
    public static final zzfx<Long> zzbe;
    public static final zzfx<Integer> zzbf;
    public static final zzfx<Integer> zzbg;
    public static final zzfx<String> zzbh;
    public static final zzfx<String> zzbi;
    public static final zzfx<String> zzbj;
    public static final zzfx<Long> zzbk;
    public static final zzfx<String> zzbl;
    public static final zzfx<String> zzbm;
    public static final zzfx<String> zzbn;
    public static final zzfx<String> zzbo;
    public static final zzfx<Long> zzbp;
    public static final zzfx<Integer> zzbq;
    public static final zzfx<Integer> zzbr;
    public static final zzfx<Integer> zzbs;
    public static final zzfx<Boolean> zzbt;
    public static final zzfx<Boolean> zzbu;
    public static final zzfx<Integer> zzbv;
    public static final zzfx<Boolean> zzbw;
    public static final zzfx<Boolean> zzbx;
    public static final zzfx<Boolean> zzby;
    public static final zzfx<Boolean> zzbz;
    public static final zzfx<Long> zzc;
    public static final zzfx<Boolean> zzca;
    public static final zzfx<Boolean> zzcb;
    public static final zzfx<Boolean> zzcc;
    public static final zzfx<Integer> zzcd;
    public static final zzfx<Boolean> zzce;
    public static final zzfx<Boolean> zzcf;
    public static final zzfx<Boolean> zzcg;
    public static final zzfx<Boolean> zzch;
    public static final zzfx<Boolean> zzci;
    public static final zzfx<Boolean> zzcj;
    public static final zzfx<Boolean> zzck;
    public static final zzfx<Boolean> zzcl;
    public static final zzfx<Boolean> zzcm;
    public static final zzfx<Boolean> zzcn;
    public static final zzfx<Boolean> zzco;
    public static final zzfx<Boolean> zzcp;
    public static final zzfx<Boolean> zzcq;
    public static final zzfx<Boolean> zzcr;
    public static final zzfx<Boolean> zzcs;
    public static final zzfx<Boolean> zzct;
    public static final zzfx<Boolean> zzcu;
    public static final zzfx<Boolean> zzcv;
    public static final zzfx<Boolean> zzcw;
    public static final zzfx<Boolean> zzcx;
    public static final zzfx<Boolean> zzcy;
    public static final zzfx<Boolean> zzcz;
    public static final zzfx<Long> zzd;
    public static final zzfx<Boolean> zzda;
    public static final zzfx<Boolean> zzdb;
    public static final zzfx<Boolean> zzdc;
    public static final zzfx<Boolean> zzdd;
    public static final zzfx<Boolean> zzde;
    private static final List<zzfx<?>> zzdf = Collections.synchronizedList(new ArrayList());
    public static final zzfx<String> zze;
    public static final zzfx<String> zzf;
    public static final zzfx<Integer> zzg;
    public static final zzfx<Integer> zzh;
    public static final zzfx<Integer> zzi;
    public static final zzfx<Integer> zzj;
    public static final zzfx<Integer> zzk;
    public static final zzfx<Integer> zzl;
    public static final zzfx<Integer> zzm;
    public static final zzfx<Integer> zzn;
    public static final zzfx<Integer> zzo;
    public static final zzfx<Integer> zzp;
    public static final zzfx<String> zzq;
    public static final zzfx<String> zzr;
    public static final zzfx<String> zzs;
    public static final zzfx<Long> zzt;
    public static final zzfx<Long> zzu;
    public static final zzfx<Integer> zzv;
    public static final zzfx<Integer> zzw;
    public static final zzfx<Long> zzx;
    public static final zzfx<Long> zzy;
    public static final zzfx<Long> zzz;

    static {
        Collections.synchronizedSet(new HashSet());
        zza = zzb("measurement.ad_id_cache_time", 10000L, new zzfv() { // from class: com.google.android.gms.measurement.internal.zzbp
            @Override // com.google.android.gms.measurement.internal.zzfv
            public final Object zza() {
                Long valueOf;
                valueOf = Long.valueOf(com.google.android.gms.internal.measurement.zznu.zza());
                return valueOf;
            }
        });
        zzb = zzb("measurement.app_uninstalled_additional_ad_id_cache_time", 3600000L, new zzfv() { // from class: com.google.android.gms.measurement.internal.zzcm
            @Override // com.google.android.gms.measurement.internal.zzfv
            public final Object zza() {
                Long valueOf;
                valueOf = Long.valueOf(com.google.android.gms.internal.measurement.zznu.zzb());
                return valueOf;
            }
        });
        zzc = zzb("measurement.monitoring.sample_period_millis", 86400000L, new zzfv() { // from class: com.google.android.gms.measurement.internal.zzcy
            @Override // com.google.android.gms.measurement.internal.zzfv
            public final Object zza() {
                Long valueOf;
                valueOf = Long.valueOf(com.google.android.gms.internal.measurement.zznu.zzt());
                return valueOf;
            }
        });
        zzd = zza("measurement.config.cache_time", 86400000L, 3600000L, new zzfv() { // from class: com.google.android.gms.measurement.internal.zzdk
            @Override // com.google.android.gms.measurement.internal.zzfv
            public final Object zza() {
                Long valueOf;
                valueOf = Long.valueOf(com.google.android.gms.internal.measurement.zznu.zzd());
                return valueOf;
            }
        }, false);
        zze = zzb("measurement.config.url_scheme", Constants.SCHEME, new zzfv() { // from class: com.google.android.gms.measurement.internal.zzdw
            @Override // com.google.android.gms.measurement.internal.zzfv
            public final Object zza() {
                String zzbc2;
                zzbc2 = com.google.android.gms.internal.measurement.zznu.zzbc();
                return zzbc2;
            }
        });
        zzf = zzb("measurement.config.url_authority", "app-measurement.com", new zzfv() { // from class: com.google.android.gms.measurement.internal.zzei
            @Override // com.google.android.gms.measurement.internal.zzfv
            public final Object zza() {
                String zzbb2;
                zzbb2 = com.google.android.gms.internal.measurement.zznu.zzbb();
                return zzbb2;
            }
        });
        zzg = zzb("measurement.upload.max_bundles", 100, new zzfv() { // from class: com.google.android.gms.measurement.internal.zzeu
            @Override // com.google.android.gms.measurement.internal.zzfv
            public final Object zza() {
                Integer valueOf;
                valueOf = Integer.valueOf((int) com.google.android.gms.internal.measurement.zznu.zzap());
                return valueOf;
            }
        });
        zzh = zzb("measurement.upload.max_batch_size", 65536, new zzfv() { // from class: com.google.android.gms.measurement.internal.zzfg
            @Override // com.google.android.gms.measurement.internal.zzfv
            public final Object zza() {
                Integer valueOf;
                valueOf = Integer.valueOf((int) com.google.android.gms.internal.measurement.zznu.zzax());
                return valueOf;
            }
        });
        zzi = zzb("measurement.upload.max_bundle_size", 65536, new zzfv() { // from class: com.google.android.gms.measurement.internal.zzfs
            @Override // com.google.android.gms.measurement.internal.zzfv
            public final Object zza() {
                Integer valueOf;
                valueOf = Integer.valueOf((int) com.google.android.gms.internal.measurement.zznu.zzao());
                return valueOf;
            }
        });
        Integer valueOf = Integer.valueOf(Constants.ONE_SECOND);
        zzj = zzb("measurement.upload.max_events_per_bundle", valueOf, new zzfv() { // from class: com.google.android.gms.measurement.internal.zzca
            @Override // com.google.android.gms.measurement.internal.zzfv
            public final Object zza() {
                Integer valueOf2;
                valueOf2 = Integer.valueOf((int) com.google.android.gms.internal.measurement.zznu.zzas());
                return valueOf2;
            }
        });
        zzk = zzb("measurement.upload.max_events_per_day", 100000, new zzfv() { // from class: com.google.android.gms.measurement.internal.zzcd
            @Override // com.google.android.gms.measurement.internal.zzfv
            public final Object zza() {
                Integer valueOf2;
                valueOf2 = Integer.valueOf((int) com.google.android.gms.internal.measurement.zznu.zzat());
                return valueOf2;
            }
        });
        zzl = zzb("measurement.upload.max_error_events_per_day", valueOf, new zzfv() { // from class: com.google.android.gms.measurement.internal.zzcc
            @Override // com.google.android.gms.measurement.internal.zzfv
            public final Object zza() {
                Integer valueOf2;
                valueOf2 = Integer.valueOf((int) com.google.android.gms.internal.measurement.zznu.zzar());
                return valueOf2;
            }
        });
        zzm = zzb("measurement.upload.max_public_events_per_day", 50000, new zzfv() { // from class: com.google.android.gms.measurement.internal.zzcf
            @Override // com.google.android.gms.measurement.internal.zzfv
            public final Object zza() {
                Integer valueOf2;
                valueOf2 = Integer.valueOf((int) com.google.android.gms.internal.measurement.zznu.zzau());
                return valueOf2;
            }
        });
        zzn = zzb("measurement.upload.max_conversions_per_day", 10000, new zzfv() { // from class: com.google.android.gms.measurement.internal.zzce
            @Override // com.google.android.gms.measurement.internal.zzfv
            public final Object zza() {
                Integer valueOf2;
                valueOf2 = Integer.valueOf((int) com.google.android.gms.internal.measurement.zznu.zzaq());
                return valueOf2;
            }
        });
        zzo = zzb("measurement.upload.max_realtime_events_per_day", 10, new zzfv() { // from class: com.google.android.gms.measurement.internal.zzch
            @Override // com.google.android.gms.measurement.internal.zzfv
            public final Object zza() {
                Integer valueOf2;
                valueOf2 = Integer.valueOf((int) com.google.android.gms.internal.measurement.zznu.zzaw());
                return valueOf2;
            }
        });
        zzp = zzb("measurement.store.max_stored_events_per_app", 100000, new zzfv() { // from class: com.google.android.gms.measurement.internal.zzcg
            @Override // com.google.android.gms.measurement.internal.zzfv
            public final Object zza() {
                Integer valueOf2;
                valueOf2 = Integer.valueOf((int) com.google.android.gms.internal.measurement.zznu.zzk());
                return valueOf2;
            }
        });
        zzq = zzb("measurement.upload.url", "https://app-measurement.com/a", new zzfv() { // from class: com.google.android.gms.measurement.internal.zzcj
            @Override // com.google.android.gms.measurement.internal.zzfv
            public final Object zza() {
                String zzbl2;
                zzbl2 = com.google.android.gms.internal.measurement.zznu.zzbl();
                return zzbl2;
            }
        });
        zzr = zzb("measurement.sgtm.google_signal.url", "https://app-measurement.com/s/d", new zzfv() { // from class: com.google.android.gms.measurement.internal.zzci
            @Override // com.google.android.gms.measurement.internal.zzfv
            public final Object zza() {
                String zzbe2;
                zzbe2 = com.google.android.gms.internal.measurement.zznu.zzbe();
                return zzbe2;
            }
        });
        zzs = zzb("measurement.sgtm.service_upload_apps_list", "de.zalando.mobile", new zzfv() { // from class: com.google.android.gms.measurement.internal.zzck
            @Override // com.google.android.gms.measurement.internal.zzfv
            public final Object zza() {
                String zzbg2;
                zzbg2 = com.google.android.gms.internal.measurement.zznu.zzbg();
                return zzbg2;
            }
        });
        zzt = zzb("measurement.sgtm.upload.retry_interval", 1800000L, new zzfv() { // from class: com.google.android.gms.measurement.internal.zzcn
            @Override // com.google.android.gms.measurement.internal.zzfv
            public final Object zza() {
                Long valueOf2;
                valueOf2 = Long.valueOf(com.google.android.gms.internal.measurement.zznu.zzad());
                return valueOf2;
            }
        });
        zzu = zzb("measurement.sgtm.upload.retry_max_wait", 21600000L, new zzfv() { // from class: com.google.android.gms.measurement.internal.zzcp
            @Override // com.google.android.gms.measurement.internal.zzfv
            public final Object zza() {
                Long valueOf2;
                valueOf2 = Long.valueOf(com.google.android.gms.internal.measurement.zznu.zzae());
                return valueOf2;
            }
        });
        zzv = zzb("measurement.sgtm.upload.max_queued_batches", 5000, new zzfv() { // from class: com.google.android.gms.measurement.internal.zzco
            @Override // com.google.android.gms.measurement.internal.zzfv
            public final Object zza() {
                Integer valueOf2;
                valueOf2 = Integer.valueOf((int) com.google.android.gms.internal.measurement.zznu.zzz());
                return valueOf2;
            }
        });
        zzw = zzb("measurement.sgtm.upload.batches_retrieval_limit", 10, new zzfv() { // from class: com.google.android.gms.measurement.internal.zzcr
            @Override // com.google.android.gms.measurement.internal.zzfv
            public final Object zza() {
                Integer valueOf2;
                valueOf2 = Integer.valueOf((int) com.google.android.gms.internal.measurement.zznu.zzy());
                return valueOf2;
            }
        });
        zzx = zzb("measurement.sgtm.upload.min_delay_after_startup", 5000L, new zzfv() { // from class: com.google.android.gms.measurement.internal.zzcq
            @Override // com.google.android.gms.measurement.internal.zzfv
            public final Object zza() {
                Long valueOf2;
                valueOf2 = Long.valueOf(com.google.android.gms.internal.measurement.zznu.zzac());
                return valueOf2;
            }
        });
        zzy = zzb("measurement.sgtm.upload.min_delay_after_broadcast", 1000L, new zzfv() { // from class: com.google.android.gms.measurement.internal.zzct
            @Override // com.google.android.gms.measurement.internal.zzfv
            public final Object zza() {
                Long valueOf2;
                valueOf2 = Long.valueOf(com.google.android.gms.internal.measurement.zznu.zzab());
                return valueOf2;
            }
        });
        zzz = zzb("measurement.sgtm.upload.min_delay_after_background", 600000L, new zzfv() { // from class: com.google.android.gms.measurement.internal.zzcs
            @Override // com.google.android.gms.measurement.internal.zzfv
            public final Object zza() {
                Long valueOf2;
                valueOf2 = Long.valueOf(com.google.android.gms.internal.measurement.zznu.zzaa());
                return valueOf2;
            }
        });
        zzaa = zzb("measurement.upload.backoff_period", 43200000L, new zzfv() { // from class: com.google.android.gms.measurement.internal.zzcv
            @Override // com.google.android.gms.measurement.internal.zzfv
            public final Object zza() {
                Long valueOf2;
                valueOf2 = Long.valueOf(com.google.android.gms.internal.measurement.zznu.zzal());
                return valueOf2;
            }
        });
        zzab = zzb("measurement.upload.window_interval", 3600000L, new zzfv() { // from class: com.google.android.gms.measurement.internal.zzcx
            @Override // com.google.android.gms.measurement.internal.zzfv
            public final Object zza() {
                Long valueOf2;
                valueOf2 = Long.valueOf(com.google.android.gms.internal.measurement.zznu.zzba());
                return valueOf2;
            }
        });
        zzac = zzb("measurement.upload.interval", 3600000L, new zzfv() { // from class: com.google.android.gms.measurement.internal.zzcw
            @Override // com.google.android.gms.measurement.internal.zzfv
            public final Object zza() {
                Long valueOf2;
                valueOf2 = Long.valueOf(com.google.android.gms.internal.measurement.zznu.zzan());
                return valueOf2;
            }
        });
        zzad = zzb("measurement.upload.realtime_upload_interval", 10000L, new zzfv() { // from class: com.google.android.gms.measurement.internal.zzcz
            @Override // com.google.android.gms.measurement.internal.zzfv
            public final Object zza() {
                Long valueOf2;
                valueOf2 = Long.valueOf(com.google.android.gms.internal.measurement.zznu.zzv());
                return valueOf2;
            }
        });
        zzae = zzb("measurement.upload.debug_upload_interval", 1000L, new zzfv() { // from class: com.google.android.gms.measurement.internal.zzdb
            @Override // com.google.android.gms.measurement.internal.zzfv
            public final Object zza() {
                Long valueOf2;
                valueOf2 = Long.valueOf(com.google.android.gms.internal.measurement.zznu.zze());
                return valueOf2;
            }
        });
        zzaf = zzb("measurement.upload.minimum_delay", 500L, new zzfv() { // from class: com.google.android.gms.measurement.internal.zzda
            @Override // com.google.android.gms.measurement.internal.zzfv
            public final Object zza() {
                Long valueOf2;
                valueOf2 = Long.valueOf(com.google.android.gms.internal.measurement.zznu.zzs());
                return valueOf2;
            }
        });
        zzag = zzb("measurement.alarm_manager.minimum_interval", 60000L, new zzfv() { // from class: com.google.android.gms.measurement.internal.zzdd
            @Override // com.google.android.gms.measurement.internal.zzfv
            public final Object zza() {
                Long valueOf2;
                valueOf2 = Long.valueOf(com.google.android.gms.internal.measurement.zznu.zzr());
                return valueOf2;
            }
        });
        zzah = zzb("measurement.upload.stale_data_deletion_interval", 86400000L, new zzfv() { // from class: com.google.android.gms.measurement.internal.zzdc
            @Override // com.google.android.gms.measurement.internal.zzfv
            public final Object zza() {
                Long valueOf2;
                valueOf2 = Long.valueOf(com.google.android.gms.internal.measurement.zznu.zzaf());
                return valueOf2;
            }
        });
        zzai = zzb("measurement.upload.refresh_blacklisted_config_interval", 604800000L, new zzfv() { // from class: com.google.android.gms.measurement.internal.zzdf
            @Override // com.google.android.gms.measurement.internal.zzfv
            public final Object zza() {
                Long valueOf2;
                valueOf2 = Long.valueOf(com.google.android.gms.internal.measurement.zznu.zzw());
                return valueOf2;
            }
        });
        zzaj = zzb("measurement.upload.initial_upload_delay_time", 15000L, new zzfv() { // from class: com.google.android.gms.measurement.internal.zzde
            @Override // com.google.android.gms.measurement.internal.zzfv
            public final Object zza() {
                Long valueOf2;
                valueOf2 = Long.valueOf(com.google.android.gms.internal.measurement.zznu.zzam());
                return valueOf2;
            }
        });
        zzak = zzb("measurement.upload.retry_time", 1800000L, new zzfv() { // from class: com.google.android.gms.measurement.internal.zzdg
            @Override // com.google.android.gms.measurement.internal.zzfv
            public final Object zza() {
                Long valueOf2;
                valueOf2 = Long.valueOf(com.google.android.gms.internal.measurement.zznu.zzaz());
                return valueOf2;
            }
        });
        zzal = zzb("measurement.upload.retry_count", 6, new zzfv() { // from class: com.google.android.gms.measurement.internal.zzdj
            @Override // com.google.android.gms.measurement.internal.zzfv
            public final Object zza() {
                Integer valueOf2;
                valueOf2 = Integer.valueOf((int) com.google.android.gms.internal.measurement.zznu.zzay());
                return valueOf2;
            }
        });
        zzam = zzb("measurement.upload.max_queue_time", 518400000L, new zzfv() { // from class: com.google.android.gms.measurement.internal.zzdi
            @Override // com.google.android.gms.measurement.internal.zzfv
            public final Object zza() {
                Long valueOf2;
                valueOf2 = Long.valueOf(com.google.android.gms.internal.measurement.zznu.zzav());
                return valueOf2;
            }
        });
        zzan = zzb("measurement.upload.google_signal_max_queue_time", 300000L, new zzfv() { // from class: com.google.android.gms.measurement.internal.zzdl
            @Override // com.google.android.gms.measurement.internal.zzfv
            public final Object zza() {
                Long valueOf2;
                valueOf2 = Long.valueOf(com.google.android.gms.internal.measurement.zznu.zzg());
                return valueOf2;
            }
        });
        zzao = zzb("measurement.lifetimevalue.max_currency_tracked", 4, new zzfv() { // from class: com.google.android.gms.measurement.internal.zzdn
            @Override // com.google.android.gms.measurement.internal.zzfv
            public final Object zza() {
                Integer valueOf2;
                valueOf2 = Integer.valueOf((int) com.google.android.gms.internal.measurement.zznu.zzh());
                return valueOf2;
            }
        });
        zzap = zzb("measurement.audience.filter_result_max_count", 200, new zzfv() { // from class: com.google.android.gms.measurement.internal.zzdm
            @Override // com.google.android.gms.measurement.internal.zzfv
            public final Object zza() {
                Integer valueOf2;
                valueOf2 = Integer.valueOf((int) com.google.android.gms.internal.measurement.zznu.zzm());
                return valueOf2;
            }
        });
        zzaq = zza("measurement.upload.max_public_user_properties", 100);
        zzar = zza("measurement.upload.max_event_name_cardinality", 2000);
        zzas = zza("measurement.upload.max_public_event_params", 100);
        zzat = zzb("measurement.service_client.idle_disconnect_millis", 5000L, new zzfv() { // from class: com.google.android.gms.measurement.internal.zzdp
            @Override // com.google.android.gms.measurement.internal.zzfv
            public final Object zza() {
                Long valueOf2;
                valueOf2 = Long.valueOf(com.google.android.gms.internal.measurement.zznu.zzx());
                return valueOf2;
            }
        });
        Boolean bool = Boolean.FALSE;
        zzau = zzb("measurement.test.boolean_flag", bool, new zzfv() { // from class: com.google.android.gms.measurement.internal.zzdo
            @Override // com.google.android.gms.measurement.internal.zzfv
            public final Object zza() {
                Boolean valueOf2;
                valueOf2 = Boolean.valueOf(com.google.android.gms.internal.measurement.zzot.zzf());
                return valueOf2;
            }
        });
        zzav = zzb("measurement.test.string_flag", "---", new zzfv() { // from class: com.google.android.gms.measurement.internal.zzdr
            @Override // com.google.android.gms.measurement.internal.zzfv
            public final Object zza() {
                String zze2;
                zze2 = com.google.android.gms.internal.measurement.zzot.zze();
                return zze2;
            }
        });
        zzaw = zzb("measurement.test.long_flag", -1L, new zzfv() { // from class: com.google.android.gms.measurement.internal.zzdt
            @Override // com.google.android.gms.measurement.internal.zzfv
            public final Object zza() {
                Long valueOf2;
                valueOf2 = Long.valueOf(com.google.android.gms.internal.measurement.zzot.zzd());
                return valueOf2;
            }
        });
        zza("measurement.test.cached_long_flag", -1L, new zzfv() { // from class: com.google.android.gms.measurement.internal.zzds
            @Override // com.google.android.gms.measurement.internal.zzfv
            public final Object zza() {
                Long valueOf2;
                valueOf2 = Long.valueOf(com.google.android.gms.internal.measurement.zzot.zzb());
                return valueOf2;
            }
        });
        zzax = zzb("measurement.test.int_flag", -2, new zzfv() { // from class: com.google.android.gms.measurement.internal.zzdv
            @Override // com.google.android.gms.measurement.internal.zzfv
            public final Object zza() {
                Integer valueOf2;
                valueOf2 = Integer.valueOf((int) com.google.android.gms.internal.measurement.zzot.zzc());
                return valueOf2;
            }
        });
        zzay = zzb("measurement.test.double_flag", Double.valueOf(-3.0d), new zzfv() { // from class: com.google.android.gms.measurement.internal.zzdu
            @Override // com.google.android.gms.measurement.internal.zzfv
            public final Object zza() {
                Double valueOf2;
                valueOf2 = Double.valueOf(com.google.android.gms.internal.measurement.zzot.zza());
                return valueOf2;
            }
        });
        zzaz = zzb("measurement.experiment.max_ids", 50, new zzfv() { // from class: com.google.android.gms.measurement.internal.zzdx
            @Override // com.google.android.gms.measurement.internal.zzfv
            public final Object zza() {
                Integer valueOf2;
                valueOf2 = Integer.valueOf((int) com.google.android.gms.internal.measurement.zznu.zzl());
                return valueOf2;
            }
        });
        zzba = zzb("measurement.upload.max_item_scoped_custom_parameters", 27, new zzfv() { // from class: com.google.android.gms.measurement.internal.zzdz
            @Override // com.google.android.gms.measurement.internal.zzfv
            public final Object zza() {
                Integer valueOf2;
                valueOf2 = Integer.valueOf((int) com.google.android.gms.internal.measurement.zznu.zzn());
                return valueOf2;
            }
        });
        zzbb = zza("measurement.upload.max_event_parameter_value_length", 500, new zzfv() { // from class: com.google.android.gms.measurement.internal.zzdy
            @Override // com.google.android.gms.measurement.internal.zzfv
            public final Object zza() {
                Integer valueOf2;
                valueOf2 = Integer.valueOf((int) com.google.android.gms.internal.measurement.zznu.zzj());
                return valueOf2;
            }
        });
        zzbc = zzb("measurement.max_bundles_per_iteration", 100, new zzfv() { // from class: com.google.android.gms.measurement.internal.zzeb
            @Override // com.google.android.gms.measurement.internal.zzfv
            public final Object zza() {
                Integer valueOf2;
                valueOf2 = Integer.valueOf((int) com.google.android.gms.internal.measurement.zznu.zzc());
                return valueOf2;
            }
        });
        zzbd = zzb("measurement.sdk.attribution.cache.ttl", 604800000L, new zzfv() { // from class: com.google.android.gms.measurement.internal.zzea
            @Override // com.google.android.gms.measurement.internal.zzfv
            public final Object zza() {
                Long valueOf2;
                valueOf2 = Long.valueOf(com.google.android.gms.internal.measurement.zznu.zzaj());
                return valueOf2;
            }
        });
        zzbe = zzb("measurement.redaction.app_instance_id.ttl", 7200000L, new zzfv() { // from class: com.google.android.gms.measurement.internal.zzec
            @Override // com.google.android.gms.measurement.internal.zzfv
            public final Object zza() {
                Long valueOf2;
                valueOf2 = Long.valueOf(com.google.android.gms.internal.measurement.zznu.zzak());
                return valueOf2;
            }
        });
        zzbf = zzb("measurement.rb.attribution.client.min_ad_services_version", 7, new zzfv() { // from class: com.google.android.gms.measurement.internal.zzef
            @Override // com.google.android.gms.measurement.internal.zzfv
            public final Object zza() {
                Integer valueOf2;
                valueOf2 = Integer.valueOf((int) com.google.android.gms.internal.measurement.zznu.zzq());
                return valueOf2;
            }
        });
        zzbg = zzb("measurement.dma_consent.max_daily_dcu_realtime_events", 1, new zzfv() { // from class: com.google.android.gms.measurement.internal.zzee
            @Override // com.google.android.gms.measurement.internal.zzfv
            public final Object zza() {
                Integer valueOf2;
                valueOf2 = Integer.valueOf((int) com.google.android.gms.internal.measurement.zznu.zzi());
                return valueOf2;
            }
        });
        zzbh = zzb("measurement.rb.attribution.uri_scheme", Constants.SCHEME, new zzfv() { // from class: com.google.android.gms.measurement.internal.zzeh
            @Override // com.google.android.gms.measurement.internal.zzfv
            public final Object zza() {
                String zzbk2;
                zzbk2 = com.google.android.gms.internal.measurement.zznu.zzbk();
                return zzbk2;
            }
        });
        zzbi = zzb("measurement.rb.attribution.uri_authority", "google-analytics.com", new zzfv() { // from class: com.google.android.gms.measurement.internal.zzeg
            @Override // com.google.android.gms.measurement.internal.zzfv
            public final Object zza() {
                String zzbh2;
                zzbh2 = com.google.android.gms.internal.measurement.zznu.zzbh();
                return zzbh2;
            }
        });
        zzbj = zzb("measurement.rb.attribution.uri_path", "privacy-sandbox/register-app-conversion", new zzfv() { // from class: com.google.android.gms.measurement.internal.zzej
            @Override // com.google.android.gms.measurement.internal.zzfv
            public final Object zza() {
                String zzbi2;
                zzbi2 = com.google.android.gms.internal.measurement.zznu.zzbi();
                return zzbi2;
            }
        });
        zzbk = zzb("measurement.session.engagement_interval", 3600000L, new zzfv() { // from class: com.google.android.gms.measurement.internal.zzel
            @Override // com.google.android.gms.measurement.internal.zzfv
            public final Object zza() {
                Long valueOf2;
                valueOf2 = Long.valueOf(com.google.android.gms.internal.measurement.zznu.zzf());
                return valueOf2;
            }
        });
        zzbl = zzb("measurement.rb.attribution.app_allowlist", "com.labpixies.flood,com.sofascore.results,games.spearmint.triplecrush,com.block.juggle,io.supercent.linkedcubic,com.cdtg.gunsound,com.corestudios.storemanagementidle,com.cdgames.fidget3d,io.supercent.burgeridle,io.supercent.pizzaidle,jp.ne.ibis.ibispaintx.app,com.dencreak.dlcalculator,com.ebay.kleinanzeigen,de.wetteronline.wetterapp,com.game.shape.shift,com.champion.cubes,bubbleshooter.orig,com.wolt.android,com.master.hotelmaster,com.games.bus.arrival,com.playstrom.dop2,com.huuuge.casino.slots,com.ig.spider.fighting,com.jura.coloring.page,com.rikkogame.ragdoll2,com.ludo.king,com.sigma.prank.sound.haircut,com.crazy.block.robo.monster.cliffs.craft,com.fugo.wow,com.maps.locator.gps.gpstracker.phone,com.gamovation.tileclub,com.pronetis.ironball2,com.meesho.supply,pdf.pdfreader.viewer.editor.free,com.dino.race.master,com.ig.moto.racing,ai.photo.enhancer.photoclear,com.duolingo,com.candle.magic_piano,com.free.vpn.super.hotspot.open,sg.bigo.live,com.cdg.tictactoe,com.zhiliaoapp.musically.go,com.wildspike.wormszone,com.mast.status.video.edit,com.vyroai.photoeditorone,com.pujiagames.deeeersimulator,com.superbinogo.jungleboyadventure,com.trustedapp.pdfreaderpdfviewer,com.artimind.aiart.artgenerator.artavatar,de.cellular.ottohybrid,com.zeptolab.cats.google,in.crossy.daily_crossword", new zzfv() { // from class: com.google.android.gms.measurement.internal.zzek
            @Override // com.google.android.gms.measurement.internal.zzfv
            public final Object zza() {
                String zzbf2;
                zzbf2 = com.google.android.gms.internal.measurement.zznu.zzbf();
                return zzbf2;
            }
        });
        zzbm = zzb("measurement.rb.attribution.user_properties", "_npa,npa|_fot,fot", new zzfv() { // from class: com.google.android.gms.measurement.internal.zzen
            @Override // com.google.android.gms.measurement.internal.zzfv
            public final Object zza() {
                String zzbm2;
                zzbm2 = com.google.android.gms.internal.measurement.zznu.zzbm();
                return zzbm2;
            }
        });
        zzbn = zzb("measurement.rb.attribution.event_params", "value|currency", new zzfv() { // from class: com.google.android.gms.measurement.internal.zzep
            @Override // com.google.android.gms.measurement.internal.zzfv
            public final Object zza() {
                String zzbd2;
                zzbd2 = com.google.android.gms.internal.measurement.zznu.zzbd();
                return zzbd2;
            }
        });
        zzbo = zzb("measurement.rb.attribution.query_parameters_to_remove", BuildConfig.FLAVOR, new zzfv() { // from class: com.google.android.gms.measurement.internal.zzeo
            @Override // com.google.android.gms.measurement.internal.zzfv
            public final Object zza() {
                String zzbj2;
                zzbj2 = com.google.android.gms.internal.measurement.zznu.zzbj();
                return zzbj2;
            }
        });
        zzbp = zzb("measurement.rb.attribution.max_queue_time", 864000000L, new zzfv() { // from class: com.google.android.gms.measurement.internal.zzer
            @Override // com.google.android.gms.measurement.internal.zzfv
            public final Object zza() {
                Long valueOf2;
                valueOf2 = Long.valueOf(com.google.android.gms.internal.measurement.zznu.zzai());
                return valueOf2;
            }
        });
        zzbq = zzb("measurement.rb.attribution.max_retry_delay_seconds", 16, new zzfv() { // from class: com.google.android.gms.measurement.internal.zzeq
            @Override // com.google.android.gms.measurement.internal.zzfv
            public final Object zza() {
                Integer valueOf2;
                valueOf2 = Integer.valueOf((int) com.google.android.gms.internal.measurement.zznu.zzag());
                return valueOf2;
            }
        });
        zzbr = zzb("measurement.rb.attribution.client.min_time_after_boot_seconds", 0, new zzfv() { // from class: com.google.android.gms.measurement.internal.zzet
            @Override // com.google.android.gms.measurement.internal.zzfv
            public final Object zza() {
                Integer valueOf2;
                valueOf2 = Integer.valueOf((int) com.google.android.gms.internal.measurement.zznu.zzah());
                return valueOf2;
            }
        });
        zzb("measurement.rb.attribution.max_trigger_uris_queried_at_once", 0, new zzfv() { // from class: com.google.android.gms.measurement.internal.zzes
            @Override // com.google.android.gms.measurement.internal.zzfv
            public final Object zza() {
                Integer valueOf2;
                valueOf2 = Integer.valueOf((int) com.google.android.gms.internal.measurement.zznu.zzp());
                return valueOf2;
            }
        });
        zzbs = zzb("measurement.rb.max_trigger_registrations_per_day", valueOf, new zzfv() { // from class: com.google.android.gms.measurement.internal.zzev
            @Override // com.google.android.gms.measurement.internal.zzfv
            public final Object zza() {
                Integer valueOf2;
                valueOf2 = Integer.valueOf((int) com.google.android.gms.internal.measurement.zznu.zzo());
                return valueOf2;
            }
        });
        Boolean bool2 = Boolean.TRUE;
        zzbt = zzb("measurement.config.bundle_for_all_apps_on_backgrounded", bool2, new zzfv() { // from class: com.google.android.gms.measurement.internal.zzex
            @Override // com.google.android.gms.measurement.internal.zzfv
            public final Object zza() {
                Boolean valueOf2;
                valueOf2 = Boolean.valueOf(com.google.android.gms.internal.measurement.zznu.zzbn());
                return valueOf2;
            }
        });
        zzbu = zzb("measurement.config.notify_trigger_uris_on_backgrounded", bool2, new zzfv() { // from class: com.google.android.gms.measurement.internal.zzew
            @Override // com.google.android.gms.measurement.internal.zzfv
            public final Object zza() {
                Boolean valueOf2;
                valueOf2 = Boolean.valueOf(com.google.android.gms.internal.measurement.zznu.zzbo());
                return valueOf2;
            }
        });
        zzbv = zzb("measurement.rb.attribution.notify_app_delay_millis", 0, new zzfv() { // from class: com.google.android.gms.measurement.internal.zzey
            @Override // com.google.android.gms.measurement.internal.zzfv
            public final Object zza() {
                Integer valueOf2;
                valueOf2 = Integer.valueOf((int) com.google.android.gms.internal.measurement.zznu.zzu());
                return valueOf2;
            }
        });
        zzbw = zza("measurement.quality.checksum", bool);
        zzbx = zzb("measurement.audience.use_bundle_end_timestamp_for_non_sequence_property_filters", bool, new zzfv() { // from class: com.google.android.gms.measurement.internal.zzfb
            @Override // com.google.android.gms.measurement.internal.zzfv
            public final Object zza() {
                Boolean valueOf2;
                valueOf2 = Boolean.valueOf(com.google.android.gms.internal.measurement.zzoh.zzc());
                return valueOf2;
            }
        });
        zzby = zzb("measurement.audience.refresh_event_count_filters_timestamp", bool, new zzfv() { // from class: com.google.android.gms.measurement.internal.zzfa
            @Override // com.google.android.gms.measurement.internal.zzfv
            public final Object zza() {
                Boolean valueOf2;
                valueOf2 = Boolean.valueOf(com.google.android.gms.internal.measurement.zzoh.zzb());
                return valueOf2;
            }
        });
        zzbz = zza("measurement.audience.use_bundle_timestamp_for_event_count_filters", bool, new zzfv() { // from class: com.google.android.gms.measurement.internal.zzfd
            @Override // com.google.android.gms.measurement.internal.zzfv
            public final Object zza() {
                Boolean valueOf2;
                valueOf2 = Boolean.valueOf(com.google.android.gms.internal.measurement.zzoh.zzd());
                return valueOf2;
            }
        });
        zzca = zzb("measurement.sdk.collection.last_deep_link_referrer_campaign2", bool, new zzfv() { // from class: com.google.android.gms.measurement.internal.zzfc
            @Override // com.google.android.gms.measurement.internal.zzfv
            public final Object zza() {
                Boolean valueOf2;
                valueOf2 = Boolean.valueOf(com.google.android.gms.internal.measurement.zzos.zza());
                return valueOf2;
            }
        });
        zzcb = zzb("measurement.integration.disable_firebase_instance_id", bool, new zzfv() { // from class: com.google.android.gms.measurement.internal.zzff
            @Override // com.google.android.gms.measurement.internal.zzfv
            public final Object zza() {
                Boolean valueOf2;
                valueOf2 = Boolean.valueOf(zzpq.zzb());
                return valueOf2;
            }
        });
        zzcc = zzb("measurement.collection.service.update_with_analytics_fix", bool, new zzfv() { // from class: com.google.android.gms.measurement.internal.zzfe
            @Override // com.google.android.gms.measurement.internal.zzfv
            public final Object zza() {
                Boolean valueOf2;
                valueOf2 = Boolean.valueOf(zzpr.zza());
                return valueOf2;
            }
        });
        zzcd = zzb("measurement.service.storage_consent_support_version", 203600, new zzfv() { // from class: com.google.android.gms.measurement.internal.zzfh
            @Override // com.google.android.gms.measurement.internal.zzfv
            public final Object zza() {
                Integer valueOf2;
                valueOf2 = Integer.valueOf((int) com.google.android.gms.internal.measurement.zznv.zza());
                return valueOf2;
            }
        });
        zzce = zzb("measurement.service.store_null_safelist", bool2, new zzfv() { // from class: com.google.android.gms.measurement.internal.zzfj
            @Override // com.google.android.gms.measurement.internal.zzfv
            public final Object zza() {
                Boolean valueOf2;
                valueOf2 = Boolean.valueOf(com.google.android.gms.internal.measurement.zzog.zzb());
                return valueOf2;
            }
        });
        zzcf = zzb("measurement.service.store_safelist", bool2, new zzfv() { // from class: com.google.android.gms.measurement.internal.zzfl
            @Override // com.google.android.gms.measurement.internal.zzfv
            public final Object zza() {
                Boolean valueOf2;
                valueOf2 = Boolean.valueOf(com.google.android.gms.internal.measurement.zzog.zzc());
                return valueOf2;
            }
        });
        zzcg = zzb("measurement.session_stitching_token_enabled", bool, new zzfv() { // from class: com.google.android.gms.measurement.internal.zzfk
            @Override // com.google.android.gms.measurement.internal.zzfv
            public final Object zza() {
                Boolean valueOf2;
                valueOf2 = Boolean.valueOf(com.google.android.gms.internal.measurement.zzpf.zzb());
                return valueOf2;
            }
        });
        zzch = zzb("measurement.sgtm.upload_queue", bool, new zzfv() { // from class: com.google.android.gms.measurement.internal.zzfn
            @Override // com.google.android.gms.measurement.internal.zzfv
            public final Object zza() {
                Boolean valueOf2;
                valueOf2 = Boolean.valueOf(com.google.android.gms.internal.measurement.zzpl.zzg());
                return valueOf2;
            }
        });
        zzci = zzb("measurement.sgtm.google_signal.enable", bool, new zzfv() { // from class: com.google.android.gms.measurement.internal.zzfm
            @Override // com.google.android.gms.measurement.internal.zzfv
            public final Object zza() {
                Boolean valueOf2;
                valueOf2 = Boolean.valueOf(com.google.android.gms.internal.measurement.zzpl.zzc());
                return valueOf2;
            }
        });
        zzcj = zzb("measurement.sgtm.no_proxy.service", bool, new zzfv() { // from class: com.google.android.gms.measurement.internal.zzfp
            @Override // com.google.android.gms.measurement.internal.zzfv
            public final Object zza() {
                Boolean valueOf2;
                valueOf2 = Boolean.valueOf(com.google.android.gms.internal.measurement.zzpl.zze());
                return valueOf2;
            }
        });
        zzck = zzb("measurement.sgtm.service.batching_on_backgrounded", bool, new zzfv() { // from class: com.google.android.gms.measurement.internal.zzfo
            @Override // com.google.android.gms.measurement.internal.zzfv
            public final Object zza() {
                Boolean valueOf2;
                valueOf2 = Boolean.valueOf(com.google.android.gms.internal.measurement.zzpl.zzf());
                return valueOf2;
            }
        });
        zzcl = zza("measurement.sgtm.no_proxy.client.dev", bool, new zzfv() { // from class: com.google.android.gms.measurement.internal.zzfr
            @Override // com.google.android.gms.measurement.internal.zzfv
            public final Object zza() {
                Boolean valueOf2;
                valueOf2 = Boolean.valueOf(com.google.android.gms.internal.measurement.zzpl.zzd());
                return valueOf2;
            }
        });
        zzcm = zza("measurement.sgtm.client.upload_on_backgrounded.dev", bool, new zzfv() { // from class: com.google.android.gms.measurement.internal.zzfq
            @Override // com.google.android.gms.measurement.internal.zzfv
            public final Object zza() {
                Boolean valueOf2;
                valueOf2 = Boolean.valueOf(com.google.android.gms.internal.measurement.zzpl.zzb());
                return valueOf2;
            }
        });
        zzcn = zza("measurement.sgtm.client.scion_upload_action.dev", bool, new zzfv() { // from class: com.google.android.gms.measurement.internal.zzft
            @Override // com.google.android.gms.measurement.internal.zzfv
            public final Object zza() {
                Boolean valueOf2;
                valueOf2 = Boolean.valueOf(com.google.android.gms.internal.measurement.zzpl.zza());
                return valueOf2;
            }
        });
        zzco = zzb("measurement.gmscore_client_telemetry", bool, new zzfv() { // from class: com.google.android.gms.measurement.internal.zzbr
            @Override // com.google.android.gms.measurement.internal.zzfv
            public final Object zza() {
                return Boolean.valueOf(com.google.android.gms.internal.measurement.zzon.zza());
            }
        });
        zzcp = zza("measurement.rb.attribution.service", bool2, new zzfv() { // from class: com.google.android.gms.measurement.internal.zzbq
            @Override // com.google.android.gms.measurement.internal.zzfv
            public final Object zza() {
                Boolean valueOf2;
                valueOf2 = Boolean.valueOf(com.google.android.gms.internal.measurement.zzoy.zzi());
                return valueOf2;
            }
        });
        zzcq = zza("measurement.rb.attribution.client2", bool2, new zzfv() { // from class: com.google.android.gms.measurement.internal.zzbt
            @Override // com.google.android.gms.measurement.internal.zzfv
            public final Object zza() {
                Boolean valueOf2;
                valueOf2 = Boolean.valueOf(com.google.android.gms.internal.measurement.zzoy.zzc());
                return valueOf2;
            }
        });
        zzcr = zzb("measurement.rb.attribution.uuid_generation", bool2, new zzfv() { // from class: com.google.android.gms.measurement.internal.zzbs
            @Override // com.google.android.gms.measurement.internal.zzfv
            public final Object zza() {
                Boolean valueOf2;
                valueOf2 = Boolean.valueOf(com.google.android.gms.internal.measurement.zzoy.zzk());
                return valueOf2;
            }
        });
        zzcs = zzb("measurement.rb.attribution.enable_trigger_redaction", bool2, new zzfv() { // from class: com.google.android.gms.measurement.internal.zzbv
            @Override // com.google.android.gms.measurement.internal.zzfv
            public final Object zza() {
                Boolean valueOf2;
                valueOf2 = Boolean.valueOf(com.google.android.gms.internal.measurement.zzoy.zzj());
                return valueOf2;
            }
        });
        zzb("measurement.rb.attribution.followup1.service", bool, new zzfv() { // from class: com.google.android.gms.measurement.internal.zzbu
            @Override // com.google.android.gms.measurement.internal.zzfv
            public final Object zza() {
                Boolean valueOf2;
                valueOf2 = Boolean.valueOf(com.google.android.gms.internal.measurement.zzoy.zzd());
                return valueOf2;
            }
        });
        zzct = zzb("measurement.rb.attribution.retry_disposition", bool, new zzfv() { // from class: com.google.android.gms.measurement.internal.zzbx
            @Override // com.google.android.gms.measurement.internal.zzfv
            public final Object zza() {
                Boolean valueOf2;
                valueOf2 = Boolean.valueOf(com.google.android.gms.internal.measurement.zzoy.zzh());
                return valueOf2;
            }
        });
        zzcu = zzb("measurement.rb.attribution.ad_campaign_info", bool2, new zzfv() { // from class: com.google.android.gms.measurement.internal.zzbw
            @Override // com.google.android.gms.measurement.internal.zzfv
            public final Object zza() {
                Boolean valueOf2;
                valueOf2 = Boolean.valueOf(com.google.android.gms.internal.measurement.zzoy.zzb());
                return valueOf2;
            }
        });
        zzcv = zzb("measurement.client.sessions.enable_fix_background_engagement", bool, new zzfv() { // from class: com.google.android.gms.measurement.internal.zzbz
            @Override // com.google.android.gms.measurement.internal.zzfv
            public final Object zza() {
                return Boolean.valueOf(com.google.android.gms.internal.measurement.zzpk.zza());
            }
        });
        zzcw = zzb("measurement.fix_engagement_on_reset_analytics_data", bool2, new zzfv() { // from class: com.google.android.gms.measurement.internal.zzby
            @Override // com.google.android.gms.measurement.internal.zzfv
            public final Object zza() {
                Boolean valueOf2;
                valueOf2 = Boolean.valueOf(com.google.android.gms.internal.measurement.zzom.zza());
                return valueOf2;
            }
        });
        zzcx = zzb("measurement.set_default_event_parameters_propagate_clear.service.dev", bool, new zzfv() { // from class: com.google.android.gms.measurement.internal.zzcl
            @Override // com.google.android.gms.measurement.internal.zzfv
            public final Object zza() {
                Boolean valueOf2;
                valueOf2 = Boolean.valueOf(com.google.android.gms.internal.measurement.zzob.zzb());
                return valueOf2;
            }
        });
        zzcy = zzb("measurement.set_default_event_parameters_propagate_clear.client.dev", bool, new zzfv() { // from class: com.google.android.gms.measurement.internal.zzcu
            @Override // com.google.android.gms.measurement.internal.zzfv
            public final Object zza() {
                Boolean valueOf2;
                valueOf2 = Boolean.valueOf(com.google.android.gms.internal.measurement.zzob.zza());
                return valueOf2;
            }
        });
        zzcz = zzb("measurement.set_default_event_parameters.fix_deferred_analytics_collection", bool, new zzfv() { // from class: com.google.android.gms.measurement.internal.zzdh
            @Override // com.google.android.gms.measurement.internal.zzfv
            public final Object zza() {
                Boolean valueOf2;
                valueOf2 = Boolean.valueOf(com.google.android.gms.internal.measurement.zzoa.zza());
                return valueOf2;
            }
        });
        zzda = zzb("measurement.chimera.parameter.service", bool2, new zzfv() { // from class: com.google.android.gms.measurement.internal.zzdq
            @Override // com.google.android.gms.measurement.internal.zzfv
            public final Object zza() {
                Boolean valueOf2;
                valueOf2 = Boolean.valueOf(com.google.android.gms.internal.measurement.zznp.zzb());
                return valueOf2;
            }
        });
        zzdb = zzb("measurement.service.ad_impression.convert_value_to_double", bool2, new zzfv() { // from class: com.google.android.gms.measurement.internal.zzed
            @Override // com.google.android.gms.measurement.internal.zzfv
            public final Object zza() {
                Boolean valueOf2;
                valueOf2 = Boolean.valueOf(com.google.android.gms.internal.measurement.zzno.zza());
                return valueOf2;
            }
        });
        zzb("measurement.rb.attribution.service.enable_max_trigger_uris_queried_at_once", bool2, new zzfv() { // from class: com.google.android.gms.measurement.internal.zzem
            @Override // com.google.android.gms.measurement.internal.zzfv
            public final Object zza() {
                Boolean valueOf2;
                valueOf2 = Boolean.valueOf(com.google.android.gms.internal.measurement.zzoy.zzg());
                return valueOf2;
            }
        });
        zzb("measurement.remove_conflicting_first_party_apis.dev", bool, new zzfv() { // from class: com.google.android.gms.measurement.internal.zzez
            @Override // com.google.android.gms.measurement.internal.zzfv
            public final Object zza() {
                Boolean valueOf2;
                valueOf2 = Boolean.valueOf(com.google.android.gms.internal.measurement.zzoz.zza());
                return valueOf2;
            }
        });
        zzdc = zzb("measurement.rb.attribution.service.trigger_uris_high_priority", bool2, new zzfv() { // from class: com.google.android.gms.measurement.internal.zzfi
            @Override // com.google.android.gms.measurement.internal.zzfv
            public final Object zza() {
                Boolean valueOf2;
                valueOf2 = Boolean.valueOf(com.google.android.gms.internal.measurement.zzoy.zzf());
                return valueOf2;
            }
        });
        zzdd = zzb("measurement.rb.attribution.client.get_trigger_uris_async", bool, new zzfv() { // from class: com.google.android.gms.measurement.internal.zzbo
            @Override // com.google.android.gms.measurement.internal.zzfv
            public final Object zza() {
                return Boolean.valueOf(com.google.android.gms.internal.measurement.zzoy.zze());
            }
        });
        zzde = zzb("measurement.backfill_session_ids.service", bool, new zzfv() { // from class: com.google.android.gms.measurement.internal.zzcb
            @Override // com.google.android.gms.measurement.internal.zzfv
            public final Object zza() {
                return Boolean.valueOf(com.google.android.gms.internal.measurement.zzpe.zzb());
            }
        });
    }

    private static <V> zzfx<V> zza(String str, V v5, zzfv<V> zzfvVar) {
        return zza(str, v5, v5, zzfvVar, true);
    }

    private static <V> zzfx<V> zzb(String str, V v5, zzfv<V> zzfvVar) {
        return zza(str, v5, v5, zzfvVar, false);
    }

    private static <V> zzfx<V> zza(String str, V v5, V v6, zzfv<V> zzfvVar, boolean z5) {
        zzfx<V> zzfxVar = new zzfx<>(str, v5, v6, zzfvVar);
        if (z5) {
            zzdf.add(zzfxVar);
        }
        return zzfxVar;
    }

    private static <V> zzfx<V> zza(String str, V v5) {
        return zza(str, v5, v5, null, false);
    }

    public static Map<String, String> zza(Context context) {
        com.google.android.gms.internal.measurement.zzhi zza2 = com.google.android.gms.internal.measurement.zzhi.zza(context.getContentResolver(), com.google.android.gms.internal.measurement.zzhu.zza("com.google.android.gms.measurement"), new Runnable() { // from class: com.google.android.gms.measurement.internal.zzbm
            @Override // java.lang.Runnable
            public final void run() {
                com.google.android.gms.internal.measurement.zzhx.zzc();
            }
        });
        return zza2 == null ? Collections.emptyMap() : zza2.zza();
    }
}
