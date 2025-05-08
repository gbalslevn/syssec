package com.google.android.gms.measurement.internal;

import android.annotation.TargetApi;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.adjust.sdk.Constants;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.internal.measurement.zzfw$zzb;
import com.google.android.gms.internal.measurement.zzfw$zzc;
import com.google.android.gms.internal.measurement.zzfw$zzd;
import com.google.android.gms.internal.measurement.zzfw$zze;
import com.google.android.gms.internal.measurement.zzfw$zzf;
import com.google.android.gms.internal.measurement.zzgf$zza;
import com.google.android.gms.internal.measurement.zzgf$zzc;
import com.google.android.gms.internal.measurement.zzgf$zzd;
import com.google.android.gms.internal.measurement.zzgf$zze;
import com.google.android.gms.internal.measurement.zzgf$zzf;
import com.google.android.gms.internal.measurement.zzgf$zzh;
import com.google.android.gms.internal.measurement.zzgf$zzj;
import com.google.android.gms.internal.measurement.zzgf$zzk;
import com.google.android.gms.internal.measurement.zzgf$zzm;
import com.google.android.gms.internal.measurement.zzgf$zzn;
import com.google.android.gms.internal.measurement.zzgf$zzo;
import com.google.android.gms.internal.measurement.zzgf$zzp;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import org.conscrypt.BuildConfig;

/* loaded from: classes.dex */
public final class zzpj extends zzot {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzpj(zzou zzouVar) {
        super(zzouVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zza(zzgf$zzk.zza zzaVar, String str) {
        if (zzaVar == null) {
            return -1;
        }
        for (int i5 = 0; i5 < zzaVar.zzd(); i5++) {
            if (str.equals(zzaVar.zzk(i5).zzg())) {
                return i5;
            }
        }
        return -1;
    }

    @Override // com.google.android.gms.measurement.internal.zzok
    public final /* bridge */ /* synthetic */ zzpj h_() {
        return super.h_();
    }

    @Override // com.google.android.gms.measurement.internal.zzjf, com.google.android.gms.measurement.internal.zzjh
    public final /* bridge */ /* synthetic */ Clock zzb() {
        return super.zzb();
    }

    @Override // com.google.android.gms.measurement.internal.zzot
    protected final boolean zzc() {
        return false;
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

    @Override // com.google.android.gms.measurement.internal.zzok
    public final /* bridge */ /* synthetic */ zzx zzg() {
        return super.zzg();
    }

    @Override // com.google.android.gms.measurement.internal.zzok
    public final /* bridge */ /* synthetic */ zzar zzh() {
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

    @Override // com.google.android.gms.measurement.internal.zzok
    public final /* bridge */ /* synthetic */ zzhm zzm() {
        return super.zzm();
    }

    @Override // com.google.android.gms.measurement.internal.zzjf
    public final /* bridge */ /* synthetic */ zzlp zzn() {
        return super.zzn();
    }

    @Override // com.google.android.gms.measurement.internal.zzok
    public final /* bridge */ /* synthetic */ zznp zzo() {
        return super.zzo();
    }

    @Override // com.google.android.gms.measurement.internal.zzok
    public final /* bridge */ /* synthetic */ zzos zzp() {
        return super.zzp();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final List<Integer> zzr() {
        Map<String, String> zza = zzbn.zza(this.zzg.zza());
        if (zza == null || zza.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int intValue = zzbn.zzaz.zza(null).intValue();
        for (Map.Entry<String, String> entry : zza.entrySet()) {
            if (entry.getKey().startsWith("measurement.id.")) {
                try {
                    int parseInt = Integer.parseInt(entry.getValue());
                    if (parseInt != 0) {
                        arrayList.add(Integer.valueOf(parseInt));
                        if (arrayList.size() >= intValue) {
                            zzj().zzr().zza("Too many experiment IDs. Number of IDs", Integer.valueOf(arrayList.size()));
                            break;
                        }
                        continue;
                    } else {
                        continue;
                    }
                } catch (NumberFormatException e5) {
                    zzj().zzr().zza("Experiment ID NumberFormatException", e5);
                }
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return arrayList;
    }

    @Override // com.google.android.gms.measurement.internal.zzjf
    public final /* bridge */ /* synthetic */ zzpn zzs() {
        return super.zzs();
    }

    @Override // com.google.android.gms.measurement.internal.zzjf
    public final /* bridge */ /* synthetic */ void zzt() {
        super.zzt();
    }

    @Override // com.google.android.gms.measurement.internal.zzjf
    public final /* bridge */ /* synthetic */ void zzu() {
        super.zzu();
    }

    @Override // com.google.android.gms.measurement.internal.zzjf
    public final /* bridge */ /* synthetic */ void zzv() {
        super.zzv();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object zzb(zzgf$zzf zzgf_zzf, String str) {
        zzgf$zzh zza = zza(zzgf_zzf, str);
        if (zza == null) {
            return null;
        }
        if (zza.zzn()) {
            return zza.zzh();
        }
        if (zza.zzl()) {
            return Long.valueOf(zza.zzd());
        }
        if (zza.zzj()) {
            return Double.valueOf(zza.zza());
        }
        if (zza.zzc() > 0) {
            return zzb(zza.zzi());
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final byte[] zzc(byte[] bArr) {
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            GZIPInputStream gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr2 = new byte[1024];
            while (true) {
                int read = gZIPInputStream.read(bArr2);
                if (read > 0) {
                    byteArrayOutputStream.write(bArr2, 0, read);
                } else {
                    gZIPInputStream.close();
                    byteArrayInputStream.close();
                    return byteArrayOutputStream.toByteArray();
                }
            }
        } catch (IOException e5) {
            zzj().zzg().zza("Failed to ungzip content", e5);
            throw e5;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final long zza(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0L;
        }
        return zza(str.getBytes(Charset.forName(Constants.ENCODING)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final long zza(byte[] bArr) {
        Preconditions.checkNotNull(bArr);
        zzs().zzv();
        MessageDigest zzr = zzpn.zzr();
        if (zzr == null) {
            zzj().zzg().zza("Failed to get MD5");
            return 0L;
        }
        return zzpn.zza(zzr.digest(bArr));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean zzb(String str) {
        return str != null && str.matches("([+-])?([0-9]+\\.?[0-9]*|[0-9]*\\.?[0-9]+)") && str.length() <= 310;
    }

    @Override // com.google.android.gms.measurement.internal.zzjf, com.google.android.gms.measurement.internal.zzjh
    public final /* bridge */ /* synthetic */ Context zza() {
        return super.zza();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Bundle zza(List<zzgf$zzh> list) {
        Bundle bundle = new Bundle();
        for (zzgf$zzh zzgf_zzh : list) {
            String zzg = zzgf_zzh.zzg();
            if (zzgf_zzh.zzj()) {
                bundle.putDouble(zzg, zzgf_zzh.zza());
            } else if (zzgf_zzh.zzk()) {
                bundle.putFloat(zzg, zzgf_zzh.zzb());
            } else if (zzgf_zzh.zzn()) {
                bundle.putString(zzg, zzgf_zzh.zzh());
            } else if (zzgf_zzh.zzl()) {
                bundle.putLong(zzg, zzgf_zzh.zzd());
            }
        }
        return bundle;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final byte[] zzb(byte[] bArr) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.close();
            byteArrayOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e5) {
            zzj().zzg().zza("Failed to gzip content", e5);
            throw e5;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Bundle[] zzb(List<zzgf$zzh> list) {
        ArrayList arrayList = new ArrayList();
        for (zzgf$zzh zzgf_zzh : list) {
            if (zzgf_zzh != null) {
                Bundle bundle = new Bundle();
                for (zzgf$zzh zzgf_zzh2 : zzgf_zzh.zzi()) {
                    if (zzgf_zzh2.zzn()) {
                        bundle.putString(zzgf_zzh2.zzg(), zzgf_zzh2.zzh());
                    } else if (zzgf_zzh2.zzl()) {
                        bundle.putLong(zzgf_zzh2.zzg(), zzgf_zzh2.zzd());
                    } else if (zzgf_zzh2.zzj()) {
                        bundle.putDouble(zzgf_zzh2.zzg(), zzgf_zzh2.zza());
                    }
                }
                if (!bundle.isEmpty()) {
                    arrayList.add(bundle);
                }
            }
        }
        return (Bundle[]) arrayList.toArray(new Bundle[arrayList.size()]);
    }

    private final Bundle zza(Map<String, Object> map, boolean z5) {
        Bundle bundle = new Bundle();
        for (String str : map.keySet()) {
            Object obj = map.get(str);
            if (obj == null) {
                bundle.putString(str, null);
            } else if (obj instanceof Long) {
                bundle.putLong(str, ((Long) obj).longValue());
            } else if (obj instanceof Double) {
                bundle.putDouble(str, ((Double) obj).doubleValue());
            } else if (!(obj instanceof ArrayList)) {
                bundle.putString(str, obj.toString());
            } else if (z5) {
                ArrayList arrayList = (ArrayList) obj;
                ArrayList arrayList2 = new ArrayList();
                int size = arrayList.size();
                int i5 = 0;
                while (i5 < size) {
                    Object obj2 = arrayList.get(i5);
                    i5++;
                    arrayList2.add(zza((Map<String, Object>) obj2, false));
                }
                bundle.putParcelableArray(str, (Parcelable[]) arrayList2.toArray(new Parcelable[0]));
            }
        }
        return bundle;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final <T extends Parcelable> T zza(byte[] bArr, Parcelable.Creator<T> creator) {
        if (bArr == null) {
            return null;
        }
        Parcel obtain = Parcel.obtain();
        try {
            obtain.unmarshall(bArr, 0, bArr.length);
            obtain.setDataPosition(0);
            return creator.createFromParcel(obtain);
        } catch (SafeParcelReader.ParseException unused) {
            zzj().zzg().zza("Failed to load parcelable from buffer");
            return null;
        } finally {
            obtain.recycle();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzbl zza(com.google.android.gms.internal.measurement.zzad zzadVar) {
        String str;
        Object obj;
        Bundle zza = zza(zzadVar.zzc(), true);
        if (zza.containsKey("_o") && (obj = zza.get("_o")) != null) {
            str = obj.toString();
        } else {
            str = "app";
        }
        String str2 = str;
        String zzb = zzjp.zzb(zzadVar.zzb());
        if (zzb == null) {
            zzb = zzadVar.zzb();
        }
        return new zzbl(zzb, new zzbg(zza), str2, zzadVar.zza());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @TargetApi(30)
    public final zzog zza(String str, zzgf$zzk.zza zzaVar, zzgf$zzf.zza zzaVar2, String str2) {
        int indexOf;
        if (!com.google.android.gms.internal.measurement.zzoy.zza() || !zze().zze(str, zzbn.zzcp)) {
            return null;
        }
        long currentTimeMillis = zzb().currentTimeMillis();
        String[] split = zze().zzd(str, zzbn.zzbo).split(",");
        HashSet hashSet = new HashSet(split.length);
        for (String str3 : split) {
            Objects.requireNonNull(str3);
            if (!hashSet.add(str3)) {
                throw new IllegalArgumentException("duplicate element: " + ((Object) str3));
            }
        }
        Set unmodifiableSet = Collections.unmodifiableSet(hashSet);
        zzos zzp = zzp();
        String zzf = zzp.zzm().zzf(str);
        Uri.Builder builder = new Uri.Builder();
        builder.scheme(zzp.zze().zzd(str, zzbn.zzbh));
        if (!TextUtils.isEmpty(zzf)) {
            builder.authority(zzf + "." + zzp.zze().zzd(str, zzbn.zzbi));
        } else {
            builder.authority(zzp.zze().zzd(str, zzbn.zzbi));
        }
        builder.path(zzp.zze().zzd(str, zzbn.zzbj));
        zza(builder, "gmp_app_id", zzaVar.zzy(), (Set<String>) unmodifiableSet);
        zza(builder, "gmp_version", "114010", (Set<String>) unmodifiableSet);
        String zzv = zzaVar.zzv();
        zzai zze = zze();
        zzfx<Boolean> zzfxVar = zzbn.zzcs;
        if (zze.zze(str, zzfxVar) && zzm().zzo(str)) {
            zzv = BuildConfig.FLAVOR;
        }
        zza(builder, "app_instance_id", zzv, (Set<String>) unmodifiableSet);
        zza(builder, "rdid", zzaVar.zzaa(), (Set<String>) unmodifiableSet);
        zza(builder, "bundle_id", zzaVar.zzu(), (Set<String>) unmodifiableSet);
        String zze2 = zzaVar2.zze();
        String zza = zzjp.zza(zze2);
        if (!TextUtils.isEmpty(zza)) {
            zze2 = zza;
        }
        zza(builder, "app_event_name", zze2, (Set<String>) unmodifiableSet);
        zza(builder, "app_version", String.valueOf(zzaVar.zzb()), (Set<String>) unmodifiableSet);
        String zzz = zzaVar.zzz();
        if (zze().zze(str, zzfxVar) && zzm().zzs(str) && !TextUtils.isEmpty(zzz) && (indexOf = zzz.indexOf(".")) != -1) {
            zzz = zzz.substring(0, indexOf);
        }
        zza(builder, "os_version", zzz, (Set<String>) unmodifiableSet);
        zza(builder, "timestamp", String.valueOf(zzaVar2.zzc()), (Set<String>) unmodifiableSet);
        if (zzaVar.zzae()) {
            zza(builder, "lat", "1", (Set<String>) unmodifiableSet);
        }
        zza(builder, "privacy_sandbox_version", String.valueOf(zzaVar.zza()), (Set<String>) unmodifiableSet);
        zza(builder, "trigger_uri_source", "1", (Set<String>) unmodifiableSet);
        zza(builder, "trigger_uri_timestamp", String.valueOf(currentTimeMillis), (Set<String>) unmodifiableSet);
        zza(builder, "request_uuid", str2, (Set<String>) unmodifiableSet);
        List<zzgf$zzh> zzf2 = zzaVar2.zzf();
        Bundle bundle = new Bundle();
        for (zzgf$zzh zzgf_zzh : zzf2) {
            String zzg = zzgf_zzh.zzg();
            if (zzgf_zzh.zzj()) {
                bundle.putString(zzg, String.valueOf(zzgf_zzh.zza()));
            } else if (zzgf_zzh.zzk()) {
                bundle.putString(zzg, String.valueOf(zzgf_zzh.zzb()));
            } else if (zzgf_zzh.zzn()) {
                bundle.putString(zzg, zzgf_zzh.zzh());
            } else if (zzgf_zzh.zzl()) {
                bundle.putString(zzg, String.valueOf(zzgf_zzh.zzd()));
            }
        }
        zza(builder, zze().zzd(str, zzbn.zzbn).split("\\|"), bundle, (Set<String>) unmodifiableSet);
        List<zzgf$zzp> zzac = zzaVar.zzac();
        Bundle bundle2 = new Bundle();
        for (zzgf$zzp zzgf_zzp : zzac) {
            String zzg2 = zzgf_zzp.zzg();
            if (zzgf_zzp.zzi()) {
                bundle2.putString(zzg2, String.valueOf(zzgf_zzp.zza()));
            } else if (zzgf_zzp.zzj()) {
                bundle2.putString(zzg2, String.valueOf(zzgf_zzp.zzb()));
            } else if (zzgf_zzp.zzm()) {
                bundle2.putString(zzg2, zzgf_zzp.zzh());
            } else if (zzgf_zzp.zzk()) {
                bundle2.putString(zzg2, String.valueOf(zzgf_zzp.zzc()));
            }
        }
        zza(builder, zze().zzd(str, zzbn.zzbm).split("\\|"), bundle2, (Set<String>) unmodifiableSet);
        zza(builder, "dma", zzaVar.zzad() ? "1" : "0", (Set<String>) unmodifiableSet);
        if (!zzaVar.zzx().isEmpty()) {
            zza(builder, "dma_cps", zzaVar.zzx(), (Set<String>) unmodifiableSet);
        }
        if (zze().zza(zzbn.zzcu) && zzaVar.zzaf()) {
            zzgf$zza zzg3 = zzaVar.zzg();
            if (!zzg3.zzh().isEmpty()) {
                zza(builder, "dl_gclid", zzg3.zzh(), (Set<String>) unmodifiableSet);
            }
            if (!zzg3.zzg().isEmpty()) {
                zza(builder, "dl_gbraid", zzg3.zzg(), (Set<String>) unmodifiableSet);
            }
            if (!zzg3.zzf().isEmpty()) {
                zza(builder, "dl_gs", zzg3.zzf(), (Set<String>) unmodifiableSet);
            }
            if (zzg3.zza() > 0) {
                zza(builder, "dl_ss_ts", String.valueOf(zzg3.zza()), (Set<String>) unmodifiableSet);
            }
            if (!zzg3.zzk().isEmpty()) {
                zza(builder, "mr_gclid", zzg3.zzk(), (Set<String>) unmodifiableSet);
            }
            if (!zzg3.zzj().isEmpty()) {
                zza(builder, "mr_gbraid", zzg3.zzj(), (Set<String>) unmodifiableSet);
            }
            if (!zzg3.zzi().isEmpty()) {
                zza(builder, "mr_gs", zzg3.zzi(), (Set<String>) unmodifiableSet);
            }
            if (zzg3.zzb() > 0) {
                zza(builder, "mr_click_ts", String.valueOf(zzg3.zzb()), (Set<String>) unmodifiableSet);
            }
        }
        return new zzog(builder.build().toString(), currentTimeMillis, 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzgf$zzf zza(zzbe zzbeVar) {
        zzgf$zzf.zza zza = zzgf$zzf.zze().zza(zzbeVar.zze);
        Iterator<String> it = zzbeVar.zzf.iterator();
        while (it.hasNext()) {
            String next = it.next();
            zzgf$zzh.zza zza2 = zzgf$zzh.zze().zza(next);
            Object zzc = zzbeVar.zzf.zzc(next);
            Preconditions.checkNotNull(zzc);
            zza(zza2, zzc);
            zza.zza(zza2);
        }
        if (!TextUtils.isEmpty(zzbeVar.zzc) && zzbeVar.zzf.zzc("_o") == null) {
            zza.zza((zzgf$zzh) ((com.google.android.gms.internal.measurement.zzkg) zzgf$zzh.zze().zza("_o").zzb(zzbeVar.zzc).zzaj()));
        }
        return (zzgf$zzf) ((com.google.android.gms.internal.measurement.zzkg) zza.zzaj());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzgf$zzh zza(zzgf$zzf zzgf_zzf, String str) {
        for (zzgf$zzh zzgf_zzh : zzgf_zzf.zzh()) {
            if (zzgf_zzh.zzg().equals(str)) {
                return zzgf_zzh;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <BuilderT extends com.google.android.gms.internal.measurement.zzlp> BuilderT zza(BuilderT buildert, byte[] bArr) {
        com.google.android.gms.internal.measurement.zzjt zza = com.google.android.gms.internal.measurement.zzjt.zza();
        if (zza != null) {
            return (BuilderT) buildert.zza(bArr, zza);
        }
        return (BuilderT) buildert.zza(bArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object zza(zzgf$zzf zzgf_zzf, String str, Object obj) {
        Object zzb = zzb(zzgf_zzf, str);
        return zzb == null ? obj : zzb;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String zza(zzgf$zzj zzgf_zzj) {
        zzgf$zzc zzw;
        if (zzgf_zzj == null) {
            return BuildConfig.FLAVOR;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("\nbatch {\n");
        if (zzgf_zzj.zzh()) {
            zza(sb, 0, "upload_subdomain", zzgf_zzj.zze());
        }
        if (zzgf_zzj.zzg()) {
            zza(sb, 0, "sgtm_join_id", zzgf_zzj.zzd());
        }
        for (zzgf$zzk zzgf_zzk : zzgf_zzj.zzf()) {
            if (zzgf_zzk != null) {
                zza(sb, 1);
                sb.append("bundle {\n");
                if (zzgf_zzk.zzbs()) {
                    zza(sb, 1, "protocol_version", Integer.valueOf(zzgf_zzk.zzf()));
                }
                if (com.google.android.gms.internal.measurement.zzpf.zza() && zze().zze(zzgf_zzk.zzab(), zzbn.zzcg) && zzgf_zzk.zzbv()) {
                    zza(sb, 1, "session_stitching_token", zzgf_zzk.zzaq());
                }
                zza(sb, 1, "platform", zzgf_zzk.zzao());
                if (zzgf_zzk.zzbn()) {
                    zza(sb, 1, "gmp_version", Long.valueOf(zzgf_zzk.zzo()));
                }
                if (zzgf_zzk.zzcb()) {
                    zza(sb, 1, "uploading_gmp_version", Long.valueOf(zzgf_zzk.zzu()));
                }
                if (zzgf_zzk.zzbl()) {
                    zza(sb, 1, "dynamite_version", Long.valueOf(zzgf_zzk.zzm()));
                }
                if (zzgf_zzk.zzbe()) {
                    zza(sb, 1, "config_version", Long.valueOf(zzgf_zzk.zzk()));
                }
                zza(sb, 1, "gmp_app_id", zzgf_zzk.i_());
                zza(sb, 1, "admob_app_id", zzgf_zzk.zzaa());
                zza(sb, 1, "app_id", zzgf_zzk.zzab());
                zza(sb, 1, "app_version", zzgf_zzk.zzae());
                if (zzgf_zzk.zzba()) {
                    zza(sb, 1, "app_version_major", Integer.valueOf(zzgf_zzk.zzb()));
                }
                zza(sb, 1, "firebase_instance_id", zzgf_zzk.zzak());
                if (zzgf_zzk.zzbj()) {
                    zza(sb, 1, "dev_cert_hash", Long.valueOf(zzgf_zzk.zzl()));
                }
                zza(sb, 1, "app_store", zzgf_zzk.zzad());
                if (zzgf_zzk.zzca()) {
                    zza(sb, 1, "upload_timestamp_millis", Long.valueOf(zzgf_zzk.zzt()));
                }
                if (zzgf_zzk.zzbx()) {
                    zza(sb, 1, "start_timestamp_millis", Long.valueOf(zzgf_zzk.zzr()));
                }
                if (zzgf_zzk.zzbm()) {
                    zza(sb, 1, "end_timestamp_millis", Long.valueOf(zzgf_zzk.zzn()));
                }
                if (zzgf_zzk.zzbr()) {
                    zza(sb, 1, "previous_bundle_start_timestamp_millis", Long.valueOf(zzgf_zzk.zzq()));
                }
                if (zzgf_zzk.zzbq()) {
                    zza(sb, 1, "previous_bundle_end_timestamp_millis", Long.valueOf(zzgf_zzk.zzp()));
                }
                zza(sb, 1, "app_instance_id", zzgf_zzk.zzac());
                zza(sb, 1, "resettable_device_id", zzgf_zzk.zzap());
                zza(sb, 1, "ds_id", zzgf_zzk.zzaj());
                if (zzgf_zzk.zzbp()) {
                    zza(sb, 1, "limited_ad_tracking", Boolean.valueOf(zzgf_zzk.zzax()));
                }
                zza(sb, 1, "os_version", zzgf_zzk.zzan());
                zza(sb, 1, "device_model", zzgf_zzk.zzai());
                zza(sb, 1, "user_default_language", zzgf_zzk.zzar());
                if (zzgf_zzk.zzbz()) {
                    zza(sb, 1, "time_zone_offset_minutes", Integer.valueOf(zzgf_zzk.zzh()));
                }
                if (zzgf_zzk.zzbd()) {
                    zza(sb, 1, "bundle_sequential_index", Integer.valueOf(zzgf_zzk.zzc()));
                }
                if (zzgf_zzk.zzbi()) {
                    zza(sb, 1, "delivery_index", Integer.valueOf(zzgf_zzk.zzd()));
                }
                if (zzgf_zzk.zzbu()) {
                    zza(sb, 1, "service_upload", Boolean.valueOf(zzgf_zzk.zzay()));
                }
                zza(sb, 1, "health_monitor", zzgf_zzk.zzam());
                if (zzgf_zzk.zzbt()) {
                    zza(sb, 1, "retry_counter", Integer.valueOf(zzgf_zzk.zzg()));
                }
                if (zzgf_zzk.zzbg()) {
                    zza(sb, 1, "consent_signals", zzgf_zzk.zzag());
                }
                if (zzgf_zzk.zzbo()) {
                    zza(sb, 1, "is_dma_region", Boolean.valueOf(zzgf_zzk.zzaw()));
                }
                if (zzgf_zzk.zzbh()) {
                    zza(sb, 1, "core_platform_services", zzgf_zzk.zzah());
                }
                if (zzgf_zzk.zzbf()) {
                    zza(sb, 1, "consent_diagnostics", zzgf_zzk.zzaf());
                }
                if (zzgf_zzk.zzby()) {
                    zza(sb, 1, "target_os_version", Long.valueOf(zzgf_zzk.zzs()));
                }
                if (com.google.android.gms.internal.measurement.zzoy.zza() && zze().zze(zzgf_zzk.zzab(), zzbn.zzcp)) {
                    zza(sb, 1, "ad_services_version", Integer.valueOf(zzgf_zzk.zza()));
                    if (zzgf_zzk.zzbb() && (zzw = zzgf_zzk.zzw()) != null) {
                        zza(sb, 2);
                        sb.append("attribution_eligibility_status {\n");
                        zza(sb, 2, "eligible", Boolean.valueOf(zzw.zzf()));
                        zza(sb, 2, "no_access_adservices_attribution_permission", Boolean.valueOf(zzw.zzh()));
                        zza(sb, 2, "pre_r", Boolean.valueOf(zzw.zzi()));
                        zza(sb, 2, "r_extensions_too_old", Boolean.valueOf(zzw.zzj()));
                        zza(sb, 2, "adservices_extension_too_old", Boolean.valueOf(zzw.zze()));
                        zza(sb, 2, "ad_storage_not_allowed", Boolean.valueOf(zzw.zzd()));
                        zza(sb, 2, "measurement_manager_disabled", Boolean.valueOf(zzw.zzg()));
                        zza(sb, 2);
                        sb.append("}\n");
                    }
                }
                if (zzgf_zzk.zzaz()) {
                    zzgf$zza zzv = zzgf_zzk.zzv();
                    zza(sb, 2);
                    sb.append("ad_campaign_info {\n");
                    if (zzv.zzn()) {
                        zza(sb, 2, "deep_link_gclid", zzv.zzh());
                    }
                    if (zzv.zzm()) {
                        zza(sb, 2, "deep_link_gbraid", zzv.zzg());
                    }
                    if (zzv.zzl()) {
                        zza(sb, 2, "deep_link_gad_source", zzv.zzf());
                    }
                    if (zzv.zzo()) {
                        zza(sb, 2, "deep_link_session_millis", Long.valueOf(zzv.zza()));
                    }
                    if (zzv.zzs()) {
                        zza(sb, 2, "market_referrer_gclid", zzv.zzk());
                    }
                    if (zzv.zzr()) {
                        zza(sb, 2, "market_referrer_gbraid", zzv.zzj());
                    }
                    if (zzv.zzq()) {
                        zza(sb, 2, "market_referrer_gad_source", zzv.zzi());
                    }
                    if (zzv.zzp()) {
                        zza(sb, 2, "market_referrer_click_millis", Long.valueOf(zzv.zzb()));
                    }
                    zza(sb, 2);
                    sb.append("}\n");
                }
                if (zzgf_zzk.zzbc()) {
                    zza(sb, 1, "batching_timestamp_millis", Long.valueOf(zzgf_zzk.zzj()));
                }
                if (zzgf_zzk.zzbw()) {
                    zzgf$zzo zzz = zzgf_zzk.zzz();
                    zza(sb, 2);
                    sb.append("sgtm_diagnostics {\n");
                    zza(sb, 2, "upload_type", zzz.zzd().name());
                    zza(sb, 2, "client_upload_eligibility", zzz.zzb().name());
                    zza(sb, 2, "service_upload_eligibility", zzz.zzc().name());
                    zza(sb, 2);
                    sb.append("}\n");
                }
                List<zzgf$zzp> zzau = zzgf_zzk.zzau();
                if (zzau != null) {
                    for (zzgf$zzp zzgf_zzp : zzau) {
                        if (zzgf_zzp != null) {
                            zza(sb, 2);
                            sb.append("user_property {\n");
                            zza(sb, 2, "set_timestamp_millis", zzgf_zzp.zzl() ? Long.valueOf(zzgf_zzp.zzd()) : null);
                            zza(sb, 2, "name", zzi().zzc(zzgf_zzp.zzg()));
                            zza(sb, 2, "string_value", zzgf_zzp.zzh());
                            zza(sb, 2, "int_value", zzgf_zzp.zzk() ? Long.valueOf(zzgf_zzp.zzc()) : null);
                            zza(sb, 2, "double_value", zzgf_zzp.zzi() ? Double.valueOf(zzgf_zzp.zza()) : null);
                            zza(sb, 2);
                            sb.append("}\n");
                        }
                    }
                }
                List<zzgf$zzd> zzas = zzgf_zzk.zzas();
                zzgf_zzk.zzab();
                if (zzas != null) {
                    for (zzgf$zzd zzgf_zzd : zzas) {
                        if (zzgf_zzd != null) {
                            zza(sb, 2);
                            sb.append("audience_membership {\n");
                            if (zzgf_zzd.zzg()) {
                                zza(sb, 2, "audience_id", Integer.valueOf(zzgf_zzd.zza()));
                            }
                            if (zzgf_zzd.zzh()) {
                                zza(sb, 2, "new_audience", Boolean.valueOf(zzgf_zzd.zzf()));
                            }
                            zza(sb, 2, "current_data", zzgf_zzd.zzd());
                            if (zzgf_zzd.zzi()) {
                                zza(sb, 2, "previous_data", zzgf_zzd.zze());
                            }
                            zza(sb, 2);
                            sb.append("}\n");
                        }
                    }
                }
                List<zzgf$zzf> zzat = zzgf_zzk.zzat();
                if (zzat != null) {
                    for (zzgf$zzf zzgf_zzf : zzat) {
                        if (zzgf_zzf != null) {
                            zza(sb, 2);
                            sb.append("event {\n");
                            zza(sb, 2, "name", zzi().zza(zzgf_zzf.zzg()));
                            if (zzgf_zzf.zzk()) {
                                zza(sb, 2, "timestamp_millis", Long.valueOf(zzgf_zzf.zzd()));
                            }
                            if (zzgf_zzf.zzj()) {
                                zza(sb, 2, "previous_timestamp_millis", Long.valueOf(zzgf_zzf.zzc()));
                            }
                            if (zzgf_zzf.zzi()) {
                                zza(sb, 2, "count", Integer.valueOf(zzgf_zzf.zza()));
                            }
                            if (zzgf_zzf.zzb() != 0) {
                                zza(sb, 2, zzgf_zzf.zzh());
                            }
                            zza(sb, 2);
                            sb.append("}\n");
                        }
                    }
                }
                zza(sb, 1);
                sb.append("}\n");
            }
        }
        sb.append("} // End-of-batch\n");
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String zza(zzfw$zzb zzfw_zzb) {
        if (zzfw_zzb == null) {
            return "null";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("\nevent_filter {\n");
        if (zzfw_zzb.zzl()) {
            zza(sb, 0, "filter_id", Integer.valueOf(zzfw_zzb.zzb()));
        }
        zza(sb, 0, "event_name", zzi().zza(zzfw_zzb.zzf()));
        String zza = zza(zzfw_zzb.zzh(), zzfw_zzb.zzi(), zzfw_zzb.zzj());
        if (!zza.isEmpty()) {
            zza(sb, 0, "filter_type", zza);
        }
        if (zzfw_zzb.zzk()) {
            zza(sb, 1, "event_count_filter", zzfw_zzb.zze());
        }
        if (zzfw_zzb.zza() > 0) {
            sb.append("  filters {\n");
            Iterator<zzfw$zzc> it = zzfw_zzb.zzg().iterator();
            while (it.hasNext()) {
                zza(sb, 2, it.next());
            }
        }
        zza(sb, 1);
        sb.append("}\n}\n");
        return sb.toString();
    }

    private static String zza(boolean z5, boolean z6, boolean z7) {
        StringBuilder sb = new StringBuilder();
        if (z5) {
            sb.append("Dynamic ");
        }
        if (z6) {
            sb.append("Sequence ");
        }
        if (z7) {
            sb.append("Session-Scoped ");
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String zza(zzfw$zze zzfw_zze) {
        if (zzfw_zze == null) {
            return "null";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("\nproperty_filter {\n");
        if (zzfw_zze.zzi()) {
            zza(sb, 0, "filter_id", Integer.valueOf(zzfw_zze.zza()));
        }
        zza(sb, 0, "property_name", zzi().zzc(zzfw_zze.zze()));
        String zza = zza(zzfw_zze.zzf(), zzfw_zze.zzg(), zzfw_zze.zzh());
        if (!zza.isEmpty()) {
            zza(sb, 0, "filter_type", zza);
        }
        zza(sb, 1, zzfw_zze.zzb());
        sb.append("}\n");
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final List<Long> zza(List<Long> list, List<Integer> list2) {
        int i5;
        ArrayList arrayList = new ArrayList(list);
        for (Integer num : list2) {
            if (num.intValue() < 0) {
                zzj().zzr().zza("Ignoring negative bit index to be cleared", num);
            } else {
                int intValue = num.intValue() / 64;
                if (intValue >= arrayList.size()) {
                    zzj().zzr().zza("Ignoring bit index greater than bitSet size", num, Integer.valueOf(arrayList.size()));
                } else {
                    arrayList.set(intValue, Long.valueOf(((Long) arrayList.get(intValue)).longValue() & (~(1 << (num.intValue() % 64)))));
                }
            }
        }
        int size = arrayList.size();
        int size2 = arrayList.size() - 1;
        while (true) {
            int i6 = size2;
            i5 = size;
            size = i6;
            if (size < 0 || ((Long) arrayList.get(size)).longValue() != 0) {
                break;
            }
            size2 = size - 1;
        }
        return arrayList.subList(0, i5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static List<Long> zza(BitSet bitSet) {
        int length = (bitSet.length() + 63) / 64;
        ArrayList arrayList = new ArrayList(length);
        for (int i5 = 0; i5 < length; i5++) {
            long j5 = 0;
            for (int i6 = 0; i6 < 64; i6++) {
                int i7 = (i5 << 6) + i6;
                if (i7 < bitSet.length()) {
                    if (bitSet.get(i7)) {
                        j5 |= 1 << i6;
                    }
                }
            }
            arrayList.add(Long.valueOf(j5));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0032, code lost:
    
        r5 = new java.util.ArrayList();
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0038, code lost:
    
        if (r4 == false) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x003a, code lost:
    
        r3 = (android.os.Parcelable[]) r3;
        r4 = r3.length;
        r7 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x003e, code lost:
    
        if (r7 >= r4) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0040, code lost:
    
        r8 = r3[r7];
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0044, code lost:
    
        if ((r8 instanceof android.os.Bundle) == false) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0046, code lost:
    
        r5.add(zza((android.os.Bundle) r8, false));
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x004f, code lost:
    
        r7 = r7 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0080, code lost:
    
        r0.put(r2, r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0054, code lost:
    
        if ((r3 instanceof java.util.ArrayList) == false) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0056, code lost:
    
        r3 = (java.util.ArrayList) r3;
        r4 = r3.size();
        r7 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x005d, code lost:
    
        if (r7 >= r4) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x005f, code lost:
    
        r8 = r3.get(r7);
        r7 = r7 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0067, code lost:
    
        if ((r8 instanceof android.os.Bundle) == false) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0069, code lost:
    
        r5.add(zza((android.os.Bundle) r8, false));
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0075, code lost:
    
        if ((r3 instanceof android.os.Bundle) == false) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0077, code lost:
    
        r5.add(zza((android.os.Bundle) r3, false));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Map<String, Object> zza(Bundle bundle, boolean z5) {
        HashMap hashMap = new HashMap();
        Iterator<String> it = bundle.keySet().iterator();
        while (it.hasNext()) {
            String next = it.next();
            Object obj = bundle.get(next);
            boolean z6 = obj instanceof Parcelable[];
            if (!z6 && !(obj instanceof ArrayList) && !(obj instanceof Bundle)) {
                if (obj != null) {
                    hashMap.put(next, obj);
                }
            }
        }
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zza(zzgf$zzf.zza zzaVar, String str, Object obj) {
        List<zzgf$zzh> zzf = zzaVar.zzf();
        int i5 = 0;
        while (true) {
            if (i5 >= zzf.size()) {
                i5 = -1;
                break;
            } else if (str.equals(zzf.get(i5).zzg())) {
                break;
            } else {
                i5++;
            }
        }
        zzgf$zzh.zza zza = zzgf$zzh.zze().zza(str);
        if (obj instanceof Long) {
            zza.zza(((Long) obj).longValue());
        } else if (obj instanceof String) {
            zza.zzb((String) obj);
        } else if (obj instanceof Double) {
            zza.zza(((Double) obj).doubleValue());
        }
        if (i5 >= 0) {
            zzaVar.zza(i5, zza);
        } else {
            zzaVar.zza(zza);
        }
    }

    private static void zza(Uri.Builder builder, String[] strArr, Bundle bundle, Set<String> set) {
        for (String str : strArr) {
            String[] split = str.split(",");
            String str2 = split[0];
            String str3 = split[split.length - 1];
            String string = bundle.getString(str2);
            if (string != null) {
                zza(builder, str3, string, set);
            }
        }
    }

    private static void zza(StringBuilder sb, int i5, String str, zzgf$zzm zzgf_zzm) {
        if (zzgf_zzm == null) {
            return;
        }
        zza(sb, 3);
        sb.append(str);
        sb.append(" {\n");
        if (zzgf_zzm.zzb() != 0) {
            zza(sb, 4);
            sb.append("results: ");
            int i6 = 0;
            for (Long l5 : zzgf_zzm.zzi()) {
                int i7 = i6 + 1;
                if (i6 != 0) {
                    sb.append(", ");
                }
                sb.append(l5);
                i6 = i7;
            }
            sb.append('\n');
        }
        if (zzgf_zzm.zzd() != 0) {
            zza(sb, 4);
            sb.append("status: ");
            int i8 = 0;
            for (Long l6 : zzgf_zzm.zzk()) {
                int i9 = i8 + 1;
                if (i8 != 0) {
                    sb.append(", ");
                }
                sb.append(l6);
                i8 = i9;
            }
            sb.append('\n');
        }
        if (zzgf_zzm.zza() != 0) {
            zza(sb, 4);
            sb.append("dynamic_filter_timestamps: {");
            int i10 = 0;
            for (zzgf$zze zzgf_zze : zzgf_zzm.zzh()) {
                int i11 = i10 + 1;
                if (i10 != 0) {
                    sb.append(", ");
                }
                sb.append(zzgf_zze.zzf() ? Integer.valueOf(zzgf_zze.zza()) : null);
                sb.append(":");
                sb.append(zzgf_zze.zze() ? Long.valueOf(zzgf_zze.zzb()) : null);
                i10 = i11;
            }
            sb.append("}\n");
        }
        if (zzgf_zzm.zzc() != 0) {
            zza(sb, 4);
            sb.append("sequence_filter_timestamps: {");
            int i12 = 0;
            for (zzgf$zzn zzgf_zzn : zzgf_zzm.zzj()) {
                int i13 = i12 + 1;
                if (i12 != 0) {
                    sb.append(", ");
                }
                sb.append(zzgf_zzn.zzf() ? Integer.valueOf(zzgf_zzn.zzb()) : null);
                sb.append(": [");
                Iterator<Long> it = zzgf_zzn.zze().iterator();
                int i14 = 0;
                while (it.hasNext()) {
                    long longValue = it.next().longValue();
                    int i15 = i14 + 1;
                    if (i14 != 0) {
                        sb.append(", ");
                    }
                    sb.append(longValue);
                    i14 = i15;
                }
                sb.append("]");
                i12 = i13;
            }
            sb.append("}\n");
        }
        zza(sb, 3);
        sb.append("}\n");
    }

    private final void zza(StringBuilder sb, int i5, List<zzgf$zzh> list) {
        if (list == null) {
            return;
        }
        int i6 = i5 + 1;
        for (zzgf$zzh zzgf_zzh : list) {
            if (zzgf_zzh != null) {
                zza(sb, i6);
                sb.append("param {\n");
                zza(sb, i6, "name", zzgf_zzh.zzm() ? zzi().zzb(zzgf_zzh.zzg()) : null);
                zza(sb, i6, "string_value", zzgf_zzh.zzn() ? zzgf_zzh.zzh() : null);
                zza(sb, i6, "int_value", zzgf_zzh.zzl() ? Long.valueOf(zzgf_zzh.zzd()) : null);
                zza(sb, i6, "double_value", zzgf_zzh.zzj() ? Double.valueOf(zzgf_zzh.zza()) : null);
                if (zzgf_zzh.zzc() > 0) {
                    zza(sb, i6, zzgf_zzh.zzi());
                }
                zza(sb, i6);
                sb.append("}\n");
            }
        }
    }

    private final void zza(StringBuilder sb, int i5, zzfw$zzc zzfw_zzc) {
        if (zzfw_zzc == null) {
            return;
        }
        zza(sb, i5);
        sb.append("filter {\n");
        if (zzfw_zzc.zzg()) {
            zza(sb, i5, "complement", Boolean.valueOf(zzfw_zzc.zzf()));
        }
        if (zzfw_zzc.zzi()) {
            zza(sb, i5, "param_name", zzi().zzb(zzfw_zzc.zze()));
        }
        if (zzfw_zzc.zzj()) {
            int i6 = i5 + 1;
            zzfw$zzf zzd = zzfw_zzc.zzd();
            if (zzd != null) {
                zza(sb, i6);
                sb.append("string_filter");
                sb.append(" {\n");
                if (zzd.zzj()) {
                    zza(sb, i6, "match_type", zzd.zzb().name());
                }
                if (zzd.zzi()) {
                    zza(sb, i6, "expression", zzd.zze());
                }
                if (zzd.zzh()) {
                    zza(sb, i6, "case_sensitive", Boolean.valueOf(zzd.zzg()));
                }
                if (zzd.zza() > 0) {
                    zza(sb, i5 + 2);
                    sb.append("expression_list {\n");
                    for (String str : zzd.zzf()) {
                        zza(sb, i5 + 3);
                        sb.append(str);
                        sb.append("\n");
                    }
                    sb.append("}\n");
                }
                zza(sb, i6);
                sb.append("}\n");
            }
        }
        if (zzfw_zzc.zzh()) {
            zza(sb, i5 + 1, "number_filter", zzfw_zzc.zzc());
        }
        zza(sb, i5);
        sb.append("}\n");
    }

    private static void zza(StringBuilder sb, int i5) {
        for (int i6 = 0; i6 < i5; i6++) {
            sb.append("  ");
        }
    }

    private static void zza(StringBuilder sb, int i5, String str, zzfw$zzd zzfw_zzd) {
        if (zzfw_zzd == null) {
            return;
        }
        zza(sb, i5);
        sb.append(str);
        sb.append(" {\n");
        if (zzfw_zzd.zzh()) {
            zza(sb, i5, "comparison_type", zzfw_zzd.zza().name());
        }
        if (zzfw_zzd.zzj()) {
            zza(sb, i5, "match_as_float", Boolean.valueOf(zzfw_zzd.zzg()));
        }
        if (zzfw_zzd.zzi()) {
            zza(sb, i5, "comparison_value", zzfw_zzd.zzd());
        }
        if (zzfw_zzd.zzl()) {
            zza(sb, i5, "min_comparison_value", zzfw_zzd.zzf());
        }
        if (zzfw_zzd.zzk()) {
            zza(sb, i5, "max_comparison_value", zzfw_zzd.zze());
        }
        zza(sb, i5);
        sb.append("}\n");
    }

    private static void zza(Uri.Builder builder, String str, String str2, Set<String> set) {
        if (set.contains(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        builder.appendQueryParameter(str, str2);
    }

    private static void zza(StringBuilder sb, int i5, String str, Object obj) {
        if (obj == null) {
            return;
        }
        zza(sb, i5 + 1);
        sb.append(str);
        sb.append(": ");
        sb.append(obj);
        sb.append('\n');
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zza(zzgf$zzh.zza zzaVar, Object obj) {
        Preconditions.checkNotNull(obj);
        zzaVar.zze().zzc().zzb().zzd();
        if (obj instanceof String) {
            zzaVar.zzb((String) obj);
            return;
        }
        if (obj instanceof Long) {
            zzaVar.zza(((Long) obj).longValue());
            return;
        }
        if (obj instanceof Double) {
            zzaVar.zza(((Double) obj).doubleValue());
            return;
        }
        if (obj instanceof Bundle[]) {
            ArrayList arrayList = new ArrayList();
            for (Bundle bundle : (Bundle[]) obj) {
                if (bundle != null) {
                    zzgf$zzh.zza zze = zzgf$zzh.zze();
                    for (String str : bundle.keySet()) {
                        zzgf$zzh.zza zza = zzgf$zzh.zze().zza(str);
                        Object obj2 = bundle.get(str);
                        if (obj2 instanceof Long) {
                            zza.zza(((Long) obj2).longValue());
                        } else if (obj2 instanceof String) {
                            zza.zzb((String) obj2);
                        } else if (obj2 instanceof Double) {
                            zza.zza(((Double) obj2).doubleValue());
                        }
                        zze.zza(zza);
                    }
                    if (zze.zza() > 0) {
                        arrayList.add((zzgf$zzh) ((com.google.android.gms.internal.measurement.zzkg) zze.zzaj()));
                    }
                }
            }
            zzaVar.zza(arrayList);
            return;
        }
        zzj().zzg().zza("Ignoring invalid (type) event param value", obj);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zza(zzgf$zzp.zza zzaVar, Object obj) {
        Preconditions.checkNotNull(obj);
        zzaVar.zzc().zzb().zza();
        if (obj instanceof String) {
            zzaVar.zzb((String) obj);
            return;
        }
        if (obj instanceof Long) {
            zzaVar.zza(((Long) obj).longValue());
        } else if (obj instanceof Double) {
            zzaVar.zza(((Double) obj).doubleValue());
        } else {
            zzj().zzg().zza("Ignoring invalid (type) user attribute value", obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean zza(zzbl zzblVar, zzp zzpVar) {
        Preconditions.checkNotNull(zzblVar);
        Preconditions.checkNotNull(zzpVar);
        return (TextUtils.isEmpty(zzpVar.zzb) && TextUtils.isEmpty(zzpVar.zzp)) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean zza(List<Long> list, int i5) {
        if (i5 < (list.size() << 6)) {
            return ((1 << (i5 % 64)) & list.get(i5 / 64).longValue()) != 0;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zza(long j5, long j6) {
        return j5 == 0 || j6 <= 0 || Math.abs(zzb().currentTimeMillis() - j5) > j6;
    }
}
