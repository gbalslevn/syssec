package com.google.android.gms.measurement.internal;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.content.pm.Signature;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.os.ext.SdkExtensions;
import android.text.TextUtils;
import androidx.privacysandbox.ads.adservices.java.measurement.MeasurementManagerFutures;
import com.adjust.sdk.Constants;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.CollectionUtils;
import com.google.android.gms.common.wrappers.Wrappers;
import java.io.ByteArrayInputStream;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.Random;
import java.util.TreeSet;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicLong;
import javax.security.auth.x500.X500Principal;

/* loaded from: classes.dex */
public final class zzpn extends zzji {
    private static final String[] zza = {"firebase_", "google_", "ga_"};
    private static final String[] zzb = {"_err"};
    private SecureRandom zzc;
    private final AtomicLong zzd;
    private int zze;
    private MeasurementManagerFutures zzf;
    private Boolean zzg;
    private Integer zzh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzpn(zzic zzicVar) {
        super(zzicVar);
        this.zzh = null;
        this.zzd = new AtomicLong(0L);
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x00b1 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00b2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final int zza(String str, String str2, String str3, Object obj, Bundle bundle, List<String> list, boolean z5, boolean z6) {
        int i5;
        int zzb2;
        int size;
        zzv();
        int i6 = 0;
        if (zza(obj)) {
            if (!z6) {
                return 21;
            }
            if (!zza(str3, zzjo.zzc)) {
                return 20;
            }
            if (!this.zzu.zzt().zzam()) {
                return 25;
            }
            boolean z7 = obj instanceof Parcelable[];
            if (z7) {
                size = ((Parcelable[]) obj).length;
            } else if (obj instanceof ArrayList) {
                size = ((ArrayList) obj).size();
            }
            if (size > 200) {
                zzj().zzw().zza("Parameter array is too long; discarded. Value kind, name, array length", "param", str3, Integer.valueOf(size));
                if (z7) {
                    Parcelable[] parcelableArr = (Parcelable[]) obj;
                    if (parcelableArr.length > 200) {
                        bundle.putParcelableArray(str3, (Parcelable[]) Arrays.copyOf(parcelableArr, 200));
                    }
                } else if (obj instanceof ArrayList) {
                    ArrayList arrayList = (ArrayList) obj;
                    if (arrayList.size() > 200) {
                        bundle.putParcelableArrayList(str3, new ArrayList<>(arrayList.subList(0, 200)));
                    }
                }
                i5 = 17;
                if (zzf(str2) && !zzf(str3)) {
                    zzb2 = zze().zza((String) null, false);
                } else {
                    zzb2 = zze().zzb((String) null, false);
                }
                if (!zza("param", str3, zzb2, obj)) {
                    return i5;
                }
                if (!z6) {
                    return 4;
                }
                if (obj instanceof Bundle) {
                    zza(str, str2, str3, (Bundle) obj, list, z5);
                } else if (obj instanceof Parcelable[]) {
                    for (Parcelable parcelable : (Parcelable[]) obj) {
                        if (!(parcelable instanceof Bundle)) {
                            zzj().zzw().zza("All Parcelable[] elements must be of type Bundle. Value type, name", parcelable.getClass(), str3);
                            return 4;
                        }
                        zza(str, str2, str3, (Bundle) parcelable, list, z5);
                    }
                } else {
                    if (!(obj instanceof ArrayList)) {
                        return 4;
                    }
                    ArrayList arrayList2 = (ArrayList) obj;
                    int size2 = arrayList2.size();
                    while (i6 < size2) {
                        Object obj2 = arrayList2.get(i6);
                        int i7 = i6 + 1;
                        if (!(obj2 instanceof Bundle)) {
                            zzj().zzw().zza("All ArrayList elements must be of type Bundle. Value type, name", obj2 != null ? obj2.getClass() : "null", str3);
                            return 4;
                        }
                        zza(str, str2, str3, (Bundle) obj2, list, z5);
                        i6 = i7;
                    }
                }
                return i5;
            }
        }
        i5 = 0;
        if (zzf(str2)) {
        }
        zzb2 = zze().zzb((String) null, false);
        if (!zza("param", str3, zzb2, obj)) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzc() {
        int extensionVersion;
        int extensionVersion2;
        if (Build.VERSION.SDK_INT < 30) {
            return 0;
        }
        extensionVersion = SdkExtensions.getExtensionVersion(30);
        if (extensionVersion <= 3) {
            return 0;
        }
        extensionVersion2 = SdkExtensions.getExtensionVersion(1000000);
        return extensionVersion2;
    }

    private final int zzi(String str) {
        if (!zzb("event param", str)) {
            return 3;
        }
        if (zza("event param", (String[]) null, str)) {
            return !zza("event param", 40, str) ? 3 : 0;
        }
        return 14;
    }

    private final int zzj(String str) {
        if (!zzc("event param", str)) {
            return 3;
        }
        if (zza("event param", (String[]) null, str)) {
            return !zza("event param", 40, str) ? 3 : 0;
        }
        return 14;
    }

    private static int zzk(String str) {
        if ("_ldl".equals(str)) {
            return 2048;
        }
        if ("_id".equals(str)) {
            return 256;
        }
        return "_lgclid".equals(str) ? 100 : 36;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static MessageDigest zzr() {
        MessageDigest messageDigest;
        for (int i5 = 0; i5 < 2; i5++) {
            try {
                messageDigest = MessageDigest.getInstance("MD5");
            } catch (NoSuchAlgorithmException unused) {
            }
            if (messageDigest != null) {
                return messageDigest;
            }
        }
        return null;
    }

    @TargetApi(30)
    private final boolean zzz() {
        Integer num;
        if (this.zzg == null) {
            MeasurementManagerFutures zzp = zzp();
            boolean z5 = false;
            if (zzp == null) {
                return false;
            }
            Integer num2 = null;
            try {
                num = zzp.getMeasurementApiStatusAsync().get(10000L, TimeUnit.MILLISECONDS);
                if (num != null) {
                    try {
                        if (num.intValue() == 1) {
                            z5 = true;
                        }
                    } catch (InterruptedException e5) {
                        e = e5;
                        num2 = num;
                        zzj().zzr().zza("Measurement manager api exception", e);
                        this.zzg = Boolean.FALSE;
                        num = num2;
                        zzj().zzq().zza("Measurement manager api status result", num);
                        return this.zzg.booleanValue();
                    } catch (CancellationException e6) {
                        e = e6;
                        num2 = num;
                        zzj().zzr().zza("Measurement manager api exception", e);
                        this.zzg = Boolean.FALSE;
                        num = num2;
                        zzj().zzq().zza("Measurement manager api status result", num);
                        return this.zzg.booleanValue();
                    } catch (ExecutionException e7) {
                        e = e7;
                        num2 = num;
                        zzj().zzr().zza("Measurement manager api exception", e);
                        this.zzg = Boolean.FALSE;
                        num = num2;
                        zzj().zzq().zza("Measurement manager api status result", num);
                        return this.zzg.booleanValue();
                    } catch (TimeoutException e8) {
                        e = e8;
                        num2 = num;
                        zzj().zzr().zza("Measurement manager api exception", e);
                        this.zzg = Boolean.FALSE;
                        num = num2;
                        zzj().zzq().zza("Measurement manager api status result", num);
                        return this.zzg.booleanValue();
                    }
                }
                this.zzg = Boolean.valueOf(z5);
            } catch (InterruptedException e9) {
                e = e9;
            } catch (CancellationException e10) {
                e = e10;
            } catch (ExecutionException e11) {
                e = e11;
            } catch (TimeoutException e12) {
                e = e12;
            }
            zzj().zzq().zza("Measurement manager api status result", num);
        }
        return this.zzg.booleanValue();
    }

    @Override // com.google.android.gms.measurement.internal.zzji
    protected final void zzab() {
        zzv();
        SecureRandom secureRandom = new SecureRandom();
        long nextLong = secureRandom.nextLong();
        if (nextLong == 0) {
            nextLong = secureRandom.nextLong();
            if (nextLong == 0) {
                zzj().zzr().zza("Utils falling back to Random for random id");
            }
        }
        this.zzd.set(nextLong);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int zzb(String str) {
        if (!zzb("user property", str)) {
            return 6;
        }
        if (zza("user property", zzjr.zza, str)) {
            return !zza("user property", 24, str) ? 6 : 0;
        }
        return 15;
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

    public final int zzg() {
        if (this.zzh == null) {
            this.zzh = Integer.valueOf(GoogleApiAvailabilityLight.getInstance().getApkVersion(zza()) / Constants.ONE_SECOND);
        }
        return this.zzh.intValue();
    }

    @Override // com.google.android.gms.measurement.internal.zzji
    protected final boolean zzh() {
        return true;
    }

    @Override // com.google.android.gms.measurement.internal.zzjf, com.google.android.gms.measurement.internal.zzjh
    public final /* bridge */ /* synthetic */ zzhv zzl() {
        return super.zzl();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final long zzm() {
        int extensionVersion;
        long j5;
        zzv();
        if (!zzd(this.zzu.zzh().zzaf())) {
            return 0L;
        }
        if (Build.VERSION.SDK_INT < 30) {
            j5 = 4;
        } else {
            extensionVersion = SdkExtensions.getExtensionVersion(30);
            j5 = extensionVersion < 4 ? 8L : zzc() < zzbn.zzbf.zza(null).intValue() ? 16L : 0L;
        }
        if (!zze("android.permission.ACCESS_ADSERVICES_ATTRIBUTION")) {
            j5 |= 2;
        }
        if (j5 == 0 && !zzz()) {
            j5 |= 64;
        }
        if (j5 == 0) {
            return 1L;
        }
        return j5;
    }

    @Override // com.google.android.gms.measurement.internal.zzjf
    public final /* bridge */ /* synthetic */ zzlp zzn() {
        return super.zzn();
    }

    public final long zzo() {
        long andIncrement;
        long j5;
        if (this.zzd.get() != 0) {
            synchronized (this.zzd) {
                this.zzd.compareAndSet(-1L, 1L);
                andIncrement = this.zzd.getAndIncrement();
            }
            return andIncrement;
        }
        synchronized (this.zzd) {
            long nextLong = new Random(System.nanoTime() ^ zzb().currentTimeMillis()).nextLong();
            int i5 = this.zze + 1;
            this.zze = i5;
            j5 = nextLong + i5;
        }
        return j5;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final MeasurementManagerFutures zzp() {
        if (this.zzf == null) {
            this.zzf = MeasurementManagerFutures.from(zza());
        }
        return this.zzf;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String zzq() {
        byte[] bArr = new byte[16];
        zzw().nextBytes(bArr);
        return String.format(Locale.US, "%032x", new BigInteger(1, bArr));
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
    public final SecureRandom zzw() {
        zzv();
        if (this.zzc == null) {
            this.zzc = new SecureRandom();
        }
        return this.zzc;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzx() {
        zzv();
        return zzm() == 1;
    }

    public final boolean zzy() {
        try {
            zza().getClassLoader().loadClass("com.google.firebase.remoteconfig.FirebaseRemoteConfig");
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean zzd(String str) {
        String zza2 = zzbn.zzbl.zza(null);
        return zza2.equals("*") || Arrays.asList(zza2.split(",")).contains(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean zzf(String str) {
        return !TextUtils.isEmpty(str) && str.startsWith("_");
    }

    public static boolean zzh(String str) {
        for (String str2 : zzb) {
            if (str2.equals(str)) {
                return false;
            }
        }
        return true;
    }

    private static boolean zzl(String str) {
        Preconditions.checkNotNull(str);
        return str.matches("^(1:\\d+:android:[a-f0-9]+|ca-app-pub-.*)$");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zze(String str) {
        zzv();
        if (Wrappers.packageManager(zza()).checkCallingOrSelfPermission(str) == 0) {
            return true;
        }
        zzj().zzc().zza("Permission not granted", str);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean zzg(String str) {
        Preconditions.checkNotEmpty(str);
        return str.charAt(0) != '_' || str.equals("_ep");
    }

    @Override // com.google.android.gms.measurement.internal.zzjf, com.google.android.gms.measurement.internal.zzjh
    public final /* bridge */ /* synthetic */ Clock zzb() {
        return super.zzb();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final long zzc(String str) {
        if (zza().getPackageManager() == null) {
            return 0L;
        }
        int i5 = 0;
        try {
            ApplicationInfo applicationInfo = Wrappers.packageManager(zza()).getApplicationInfo(str, 0);
            if (applicationInfo != null) {
                i5 = applicationInfo.targetSdkVersion;
            }
        } catch (PackageManager.NameNotFoundException unused) {
            zzj().zzp().zza("PackageManager failed to find running app: app_id", str);
        }
        return i5;
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

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Object zzb(String str, Object obj) {
        int zza2;
        if ("_ev".equals(str)) {
            return zza(zze().zzb((String) null, false), obj, true, true, (String) null);
        }
        if (zzf(str)) {
            zza2 = zze().zzb((String) null, false);
        } else {
            zza2 = zze().zza((String) null, false);
        }
        return zza(zza2, obj, false, true, (String) null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzd(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            return true;
        }
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return zze().zzp().equals(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Object zzc(String str, Object obj) {
        if ("_ldl".equals(str)) {
            return zza(zzk(str), obj, true, false, (String) null);
        }
        return zza(zzk(str), obj, false, false, (String) null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzc(String str, String str2) {
        if (str2 == null) {
            zzj().zzm().zza("Name is required and can't be null. Type", str);
            return false;
        }
        if (str2.length() == 0) {
            zzj().zzm().zza("Name is required and can't be empty. Type", str);
            return false;
        }
        int codePointAt = str2.codePointAt(0);
        if (!Character.isLetter(codePointAt)) {
            zzj().zzm().zza("Name must start with a letter. Type, name", str, str2);
            return false;
        }
        int length = str2.length();
        int charCount = Character.charCount(codePointAt);
        while (charCount < length) {
            int codePointAt2 = str2.codePointAt(charCount);
            if (codePointAt2 != 95 && !Character.isLetterOrDigit(codePointAt2)) {
                zzj().zzm().zza("Name must consist of letters, digits or _ (underscores). Type, name", str, str2);
                return false;
            }
            charCount += Character.charCount(codePointAt2);
        }
        return true;
    }

    public static ArrayList<Bundle> zzb(List<zzag> list) {
        if (list == null) {
            return new ArrayList<>(0);
        }
        ArrayList<Bundle> arrayList = new ArrayList<>(list.size());
        for (zzag zzagVar : list) {
            Bundle bundle = new Bundle();
            bundle.putString("app_id", zzagVar.zza);
            bundle.putString("origin", zzagVar.zzb);
            bundle.putLong("creation_timestamp", zzagVar.zzd);
            bundle.putString("name", zzagVar.zzc.zza);
            zzjk.zza(bundle, Preconditions.checkNotNull(zzagVar.zzc.zza()));
            bundle.putBoolean("active", zzagVar.zze);
            String str = zzagVar.zzf;
            if (str != null) {
                bundle.putString("trigger_event_name", str);
            }
            zzbl zzblVar = zzagVar.zzg;
            if (zzblVar != null) {
                bundle.putString("timed_out_event_name", zzblVar.zza);
                zzbg zzbgVar = zzblVar.zzb;
                if (zzbgVar != null) {
                    bundle.putBundle("timed_out_event_params", zzbgVar.zzb());
                }
            }
            bundle.putLong("trigger_timeout", zzagVar.zzh);
            zzbl zzblVar2 = zzagVar.zzi;
            if (zzblVar2 != null) {
                bundle.putString("triggered_event_name", zzblVar2.zza);
                zzbg zzbgVar2 = zzblVar2.zzb;
                if (zzbgVar2 != null) {
                    bundle.putBundle("triggered_event_params", zzbgVar2.zzb());
                }
            }
            bundle.putLong("triggered_timestamp", zzagVar.zzc.zzb);
            bundle.putLong("time_to_live", zzagVar.zzj);
            zzbl zzblVar3 = zzagVar.zzk;
            if (zzblVar3 != null) {
                bundle.putString("expired_event_name", zzblVar3.zza);
                zzbg zzbgVar3 = zzblVar3.zzb;
                if (zzbgVar3 != null) {
                    bundle.putBundle("expired_event_params", zzbgVar3.zzb());
                }
            }
            arrayList.add(bundle);
        }
        return arrayList;
    }

    private final boolean zzc(Context context, String str) {
        Signature[] signatureArr;
        X500Principal x500Principal = new X500Principal("CN=Android Debug,O=Android,C=US");
        try {
            PackageInfo packageInfo = Wrappers.packageManager(context).getPackageInfo(str, 64);
            if (packageInfo == null || (signatureArr = packageInfo.signatures) == null || signatureArr.length <= 0) {
                return true;
            }
            return ((X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(signatureArr[0].toByteArray()))).getSubjectX500Principal().equals(x500Principal);
        } catch (PackageManager.NameNotFoundException e5) {
            zzj().zzg().zza("Package name not found", e5);
            return true;
        } catch (CertificateException e6) {
            zzj().zzg().zza("Error obtaining certificate", e6);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int zza(String str, Object obj) {
        boolean zza2;
        if ("_ldl".equals(str)) {
            zza2 = zza("user property referrer", str, zzk(str), obj);
        } else {
            zza2 = zza("user property", str, zzk(str), obj);
        }
        return zza2 ? 0 : 7;
    }

    private static boolean zzb(Bundle bundle, int i5) {
        if (bundle == null || bundle.getLong("_err") != 0) {
            return false;
        }
        bundle.putLong("_err", i5);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzb(String str, String str2) {
        if (str2 == null) {
            zzj().zzm().zza("Name is required and can't be null. Type", str);
            return false;
        }
        if (str2.length() == 0) {
            zzj().zzm().zza("Name is required and can't be empty. Type", str);
            return false;
        }
        int codePointAt = str2.codePointAt(0);
        if (!Character.isLetter(codePointAt) && codePointAt != 95) {
            zzj().zzm().zza("Name must start with a letter or _ (underscore). Type, name", str, str2);
            return false;
        }
        int length = str2.length();
        int charCount = Character.charCount(codePointAt);
        while (charCount < length) {
            int codePointAt2 = str2.codePointAt(charCount);
            if (codePointAt2 != 95 && !Character.isLetterOrDigit(codePointAt2)) {
                zzj().zzm().zza("Name must consist of letters, digits or _ (underscores). Type, name", str, str2);
                return false;
            }
            charCount += Character.charCount(codePointAt2);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int zza(String str) {
        if (!zzb("event", str)) {
            return 2;
        }
        if (zza("event", zzjp.zza, zzjp.zzb, str)) {
            return !zza("event", 40, str) ? 2 : 0;
        }
        return 13;
    }

    public final int zza(int i5) {
        return GoogleApiAvailabilityLight.getInstance().isGooglePlayServicesAvailable(zza(), GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x0066 -> B:8:0x0073). Please report as a decompilation issue!!! */
    public final long zza(Context context, String str) {
        zzv();
        Preconditions.checkNotNull(context);
        Preconditions.checkNotEmpty(str);
        PackageManager packageManager = context.getPackageManager();
        MessageDigest zzr = zzr();
        long j5 = -1;
        if (zzr == null) {
            zzj().zzg().zza("Could not get MD5 instance");
        } else {
            if (packageManager != null) {
                try {
                } catch (PackageManager.NameNotFoundException e5) {
                    zzj().zzg().zza("Package name not found", e5);
                }
                if (!zzc(context, str)) {
                    Signature[] signatureArr = Wrappers.packageManager(context).getPackageInfo(zza().getPackageName(), 64).signatures;
                    if (signatureArr != null && signatureArr.length > 0) {
                        j5 = zza(zzr.digest(signatureArr[0].toByteArray()));
                    } else {
                        zzj().zzr().zza("Could not get signatures");
                    }
                }
            }
            j5 = 0;
        }
        return j5;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean zzb(Context context, String str) {
        ServiceInfo serviceInfo;
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null && (serviceInfo = packageManager.getServiceInfo(new ComponentName(context, str), 0)) != null) {
                if (serviceInfo.enabled) {
                    return true;
                }
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Bundle[] zzb(Object obj) {
        if (obj instanceof Bundle) {
            return new Bundle[]{(Bundle) obj};
        }
        if (obj instanceof Parcelable[]) {
            Parcelable[] parcelableArr = (Parcelable[]) obj;
            return (Bundle[]) Arrays.copyOf(parcelableArr, parcelableArr.length, Bundle[].class);
        }
        if (!(obj instanceof ArrayList)) {
            return null;
        }
        ArrayList arrayList = (ArrayList) obj;
        return (Bundle[]) arrayList.toArray(new Bundle[arrayList.size()]);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long zza(byte[] bArr) {
        Preconditions.checkNotNull(bArr);
        int i5 = 0;
        Preconditions.checkState(bArr.length > 0);
        long j5 = 0;
        for (int length = bArr.length - 1; length >= 0 && length >= bArr.length - 8; length--) {
            j5 += (bArr[length] & 255) << i5;
            i5 += 8;
        }
        return j5;
    }

    public static long zza(zzbg zzbgVar) {
        long j5 = 0;
        if (zzbgVar == null) {
            return 0L;
        }
        Iterator<String> it = zzbgVar.iterator();
        while (it.hasNext()) {
            if (zzbgVar.zzc(it.next()) instanceof Parcelable[]) {
                j5 += ((Parcelable[]) r3).length;
            }
        }
        return j5;
    }

    public static long zza(long j5, long j6) {
        return (j5 + (j6 * 60000)) / 86400000;
    }

    @Override // com.google.android.gms.measurement.internal.zzjf, com.google.android.gms.measurement.internal.zzjh
    public final /* bridge */ /* synthetic */ Context zza() {
        return super.zza();
    }

    public static Bundle zza(List<zzpm> list) {
        Bundle bundle = new Bundle();
        if (list == null) {
            return bundle;
        }
        for (zzpm zzpmVar : list) {
            String str = zzpmVar.zzd;
            if (str != null) {
                bundle.putString(zzpmVar.zza, str);
            } else {
                Long l5 = zzpmVar.zzc;
                if (l5 != null) {
                    bundle.putLong(zzpmVar.zza, l5.longValue());
                } else {
                    Double d5 = zzpmVar.zzf;
                    if (d5 != null) {
                        bundle.putDouble(zzpmVar.zza, d5.doubleValue());
                    }
                }
            }
        }
        return bundle;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Bundle zza(Uri uri) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        if (uri == null) {
            return null;
        }
        try {
            if (uri.isHierarchical()) {
                str = uri.getQueryParameter("utm_campaign");
                str2 = uri.getQueryParameter("utm_source");
                str3 = uri.getQueryParameter("utm_medium");
                str4 = uri.getQueryParameter("gclid");
                str5 = uri.getQueryParameter("gbraid");
                str6 = uri.getQueryParameter("utm_id");
                str7 = uri.getQueryParameter("dclid");
                str8 = uri.getQueryParameter("srsltid");
                str9 = uri.getQueryParameter("sfmc_id");
            } else {
                str = null;
                str2 = null;
                str3 = null;
                str4 = null;
                str5 = null;
                str6 = null;
                str7 = null;
                str8 = null;
                str9 = null;
            }
            if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2) && TextUtils.isEmpty(str3) && TextUtils.isEmpty(str4) && TextUtils.isEmpty(str5) && TextUtils.isEmpty(str6) && TextUtils.isEmpty(str7) && TextUtils.isEmpty(str8) && TextUtils.isEmpty(str9)) {
                return null;
            }
            Bundle bundle = new Bundle();
            if (TextUtils.isEmpty(str)) {
                str10 = "sfmc_id";
            } else {
                str10 = "sfmc_id";
                bundle.putString("campaign", str);
            }
            if (!TextUtils.isEmpty(str2)) {
                bundle.putString("source", str2);
            }
            if (!TextUtils.isEmpty(str3)) {
                bundle.putString(Constants.MEDIUM, str3);
            }
            if (!TextUtils.isEmpty(str4)) {
                bundle.putString("gclid", str4);
            }
            if (!TextUtils.isEmpty(str5)) {
                bundle.putString("gbraid", str5);
            }
            String queryParameter = uri.getQueryParameter("gad_source");
            if (!TextUtils.isEmpty(queryParameter)) {
                bundle.putString("gad_source", queryParameter);
            }
            String queryParameter2 = uri.getQueryParameter("utm_term");
            if (!TextUtils.isEmpty(queryParameter2)) {
                bundle.putString("term", queryParameter2);
            }
            String queryParameter3 = uri.getQueryParameter("utm_content");
            if (!TextUtils.isEmpty(queryParameter3)) {
                bundle.putString("content", queryParameter3);
            }
            String queryParameter4 = uri.getQueryParameter("aclid");
            if (!TextUtils.isEmpty(queryParameter4)) {
                bundle.putString("aclid", queryParameter4);
            }
            String queryParameter5 = uri.getQueryParameter("cp1");
            if (!TextUtils.isEmpty(queryParameter5)) {
                bundle.putString("cp1", queryParameter5);
            }
            String queryParameter6 = uri.getQueryParameter("anid");
            if (!TextUtils.isEmpty(queryParameter6)) {
                bundle.putString("anid", queryParameter6);
            }
            if (!TextUtils.isEmpty(str6)) {
                bundle.putString("campaign_id", str6);
            }
            if (!TextUtils.isEmpty(str7)) {
                bundle.putString("dclid", str7);
            }
            String queryParameter7 = uri.getQueryParameter("utm_source_platform");
            if (!TextUtils.isEmpty(queryParameter7)) {
                bundle.putString("source_platform", queryParameter7);
            }
            String queryParameter8 = uri.getQueryParameter("utm_creative_format");
            if (!TextUtils.isEmpty(queryParameter8)) {
                bundle.putString("creative_format", queryParameter8);
            }
            String queryParameter9 = uri.getQueryParameter("utm_marketing_tactic");
            if (!TextUtils.isEmpty(queryParameter9)) {
                bundle.putString("marketing_tactic", queryParameter9);
            }
            if (!TextUtils.isEmpty(str8)) {
                bundle.putString("srsltid", str8);
            }
            if (!TextUtils.isEmpty(str9)) {
                bundle.putString(str10, str9);
            }
            return bundle;
        } catch (UnsupportedOperationException e5) {
            zzj().zzr().zza("Install referrer url isn't a hierarchical URI", e5);
            return null;
        }
    }

    public static Bundle zza(Bundle bundle) {
        if (bundle == null) {
            return new Bundle();
        }
        Bundle bundle2 = new Bundle(bundle);
        for (String str : bundle2.keySet()) {
            Object obj = bundle2.get(str);
            if (obj instanceof Bundle) {
                bundle2.putBundle(str, new Bundle((Bundle) obj));
            } else {
                int i5 = 0;
                if (obj instanceof Parcelable[]) {
                    Parcelable[] parcelableArr = (Parcelable[]) obj;
                    while (i5 < parcelableArr.length) {
                        if (parcelableArr[i5] instanceof Bundle) {
                            parcelableArr[i5] = new Bundle((Bundle) parcelableArr[i5]);
                        }
                        i5++;
                    }
                } else if (obj instanceof List) {
                    List list = (List) obj;
                    while (i5 < list.size()) {
                        Object obj2 = list.get(i5);
                        if (obj2 instanceof Bundle) {
                            list.set(i5, new Bundle((Bundle) obj2));
                        }
                        i5++;
                    }
                }
            }
        }
        return bundle2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Bundle zza(Bundle bundle, String str) {
        Bundle bundle2 = new Bundle();
        if (bundle != null) {
            for (String str2 : bundle.keySet()) {
                Object zzb2 = zzb(str2, bundle.get(str2));
                if (zzb2 == null) {
                    zzj().zzw().zza("Param value can't be null", zzi().zzb(str2));
                } else {
                    zza(bundle2, str2, zzb2);
                }
            }
        }
        return bundle2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Bundle zza(String str, String str2, Bundle bundle, List<String> list, boolean z5) {
        int zzj;
        int i5;
        zzpn zzpnVar = this;
        boolean zza2 = zza(str2, zzjp.zzd);
        if (bundle == null) {
            return null;
        }
        Bundle bundle2 = new Bundle(bundle);
        int zzc = zze().zzc();
        int i6 = 0;
        for (String str3 : new TreeSet(bundle.keySet())) {
            if (list == null || !list.contains(str3)) {
                zzj = !z5 ? zzpnVar.zzj(str3) : 0;
                if (zzj == 0) {
                    zzj = zzpnVar.zzi(str3);
                }
            } else {
                zzj = 0;
            }
            if (zzj != 0) {
                zza(bundle2, zzj, str3, zzj == 3 ? str3 : null);
                bundle2.remove(str3);
                i5 = zzc;
            } else {
                i5 = zzc;
                int zza3 = zza(str, str2, str3, bundle.get(str3), bundle2, list, z5, zza2);
                if (zza3 == 17) {
                    zza(bundle2, zza3, str3, Boolean.FALSE);
                } else if (zza3 != 0 && !"_ev".equals(str3)) {
                    zza(bundle2, zza3, zza3 == 21 ? str2 : str3, bundle.get(str3));
                    bundle2.remove(str3);
                }
                if (zzg(str3)) {
                    int i7 = i6 + 1;
                    if (i7 > i5) {
                        zzj().zzm().zza("Event can't contain more than " + i5 + " params", zzi().zza(str2), zzi().zza(bundle));
                        zzb(bundle2, 5);
                        bundle2.remove(str3);
                    }
                    i6 = i7;
                }
            }
            zzc = i5;
            zzpnVar = this;
        }
        return bundle2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzbl zza(String str, String str2, Bundle bundle, String str3, long j5, boolean z5, boolean z6) {
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        if (zza(str2) == 0) {
            Bundle bundle2 = bundle != null ? new Bundle(bundle) : new Bundle();
            bundle2.putString("_o", str3);
            Bundle zza2 = zza(str, str2, bundle2, CollectionUtils.listOf("_o"), true);
            if (z5) {
                zza2 = zza(zza2, str);
            }
            Preconditions.checkNotNull(zza2);
            return new zzbl(str2, new zzbg(zza2), str3, j5);
        }
        zzj().zzg().zza("Invalid conditional property event name", zzi().zzc(str2));
        throw new IllegalArgumentException();
    }

    private final Object zza(int i5, Object obj, boolean z5, boolean z6, String str) {
        Bundle zza2;
        if (obj == null) {
            return null;
        }
        if ((obj instanceof Long) || (obj instanceof Double)) {
            return obj;
        }
        if (obj instanceof Integer) {
            return Long.valueOf(((Integer) obj).intValue());
        }
        if (obj instanceof Byte) {
            return Long.valueOf(((Byte) obj).byteValue());
        }
        if (obj instanceof Short) {
            return Long.valueOf(((Short) obj).shortValue());
        }
        if (obj instanceof Boolean) {
            return Long.valueOf(((Boolean) obj).booleanValue() ? 1L : 0L);
        }
        if (obj instanceof Float) {
            return Double.valueOf(((Float) obj).doubleValue());
        }
        if (!(obj instanceof String) && !(obj instanceof Character) && !(obj instanceof CharSequence)) {
            if (!z6 || (!(obj instanceof Bundle[]) && !(obj instanceof Parcelable[]))) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (Parcelable parcelable : (Parcelable[]) obj) {
                if ((parcelable instanceof Bundle) && (zza2 = zza((Bundle) parcelable, (String) null)) != null && !zza2.isEmpty()) {
                    arrayList.add(zza2);
                }
            }
            return arrayList.toArray(new Bundle[arrayList.size()]);
        }
        return zza(String.valueOf(obj), i5, z5);
    }

    public static String zza(String str, int i5, boolean z5) {
        if (str == null) {
            return null;
        }
        if (str.codePointCount(0, str.length()) <= i5) {
            return str;
        }
        if (!z5) {
            return null;
        }
        return str.substring(0, str.offsetByCodePoints(0, i5)) + "...";
    }

    public final URL zza(long j5, String str, String str2, long j6, String str3) {
        try {
            Preconditions.checkNotEmpty(str2);
            Preconditions.checkNotEmpty(str);
            String format = String.format("https://www.googleadservices.com/pagead/conversion/app/deeplink?id_type=adid&sdk_version=%s&rdid=%s&bundleid=%s&retry=%s", String.format("v%s.%s", Long.valueOf(j5), Integer.valueOf(zzg())), str2, str, Long.valueOf(j6));
            if (str.equals(zze().zzq())) {
                format = format.concat("&ddl_test=1");
            }
            if (!str3.isEmpty()) {
                if (str3.charAt(0) != '&') {
                    format = format.concat("&");
                }
                format = format.concat(str3);
            }
            return new URL(format);
        } catch (IllegalArgumentException e5) {
            e = e5;
            zzj().zzg().zza("Failed to create BOW URL for Deferred Deep Link. exception", e.getMessage());
            return null;
        } catch (MalformedURLException e6) {
            e = e6;
            zzj().zzg().zza("Failed to create BOW URL for Deferred Deep Link. exception", e.getMessage());
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zza(Bundle bundle, long j5) {
        long j6 = bundle.getLong("_et");
        if (j6 != 0) {
            zzj().zzr().zza("Params already contained engagement", Long.valueOf(j6));
        }
        bundle.putLong("_et", j5 + j6);
    }

    private static void zza(Bundle bundle, int i5, String str, Object obj) {
        if (zzb(bundle, i5)) {
            bundle.putString("_ev", zza(str, 40, true));
            if (obj != null) {
                Preconditions.checkNotNull(bundle);
                if ((obj instanceof String) || (obj instanceof CharSequence)) {
                    bundle.putLong("_el", String.valueOf(obj).length());
                }
            }
        }
    }

    public static void zza(zzlw zzlwVar, Bundle bundle, boolean z5) {
        if (bundle == null || zzlwVar == null || (bundle.containsKey("_sc") && !z5)) {
            if (bundle != null && zzlwVar == null && z5) {
                bundle.remove("_sn");
                bundle.remove("_sc");
                bundle.remove("_si");
                return;
            }
            return;
        }
        String str = zzlwVar.zza;
        if (str != null) {
            bundle.putString("_sn", str);
        } else {
            bundle.remove("_sn");
        }
        String str2 = zzlwVar.zzb;
        if (str2 != null) {
            bundle.putString("_sc", str2);
        } else {
            bundle.remove("_sc");
        }
        bundle.putLong("_si", zzlwVar.zzc);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zza(Bundle bundle, Bundle bundle2) {
        if (bundle2 == null) {
            return;
        }
        for (String str : bundle2.keySet()) {
            if (!bundle.containsKey(str)) {
                zzs().zza(bundle, str, bundle2.get(str));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zza(Parcelable[] parcelableArr, int i5) {
        Preconditions.checkNotNull(parcelableArr);
        for (Parcelable parcelable : parcelableArr) {
            Bundle bundle = (Bundle) parcelable;
            int i6 = 0;
            for (String str : new TreeSet(bundle.keySet())) {
                if (zzg(str) && !zza(str, zzjo.zzd) && (i6 = i6 + 1) > i5) {
                    zzj().zzm().zza("Param can't contain more than " + i5 + " item-scoped custom parameters", zzi().zzb(str), zzi().zza(bundle));
                    zzb(bundle, 28);
                    bundle.remove(str);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zza(zzgs zzgsVar, int i5) {
        int i6 = 0;
        for (String str : new TreeSet(zzgsVar.zzc.keySet())) {
            if (zzg(str) && (i6 = i6 + 1) > i5) {
                zzj().zzm().zza("Event can't contain more than " + i5 + " params", zzi().zza(zzgsVar.zza), zzi().zza(zzgsVar.zzc));
                zzb(zzgsVar.zzc, 5);
                zzgsVar.zzc.remove(str);
            }
        }
    }

    public static void zza(zzpp zzppVar, int i5, String str, String str2, int i6) {
        zza(zzppVar, (String) null, i5, str, str2, i6);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zza(zzpp zzppVar, String str, int i5, String str2, String str3, int i6) {
        Bundle bundle = new Bundle();
        zzb(bundle, i5);
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            bundle.putString(str2, str3);
        }
        if (i5 == 6 || i5 == 7 || i5 == 2) {
            bundle.putLong("_el", i6);
        }
        zzppVar.zza(str, "_err", bundle);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zza(Bundle bundle, String str, Object obj) {
        if (bundle == null) {
            return;
        }
        if (obj instanceof Long) {
            bundle.putLong(str, ((Long) obj).longValue());
            return;
        }
        if (obj instanceof String) {
            bundle.putString(str, String.valueOf(obj));
            return;
        }
        if (obj instanceof Double) {
            bundle.putDouble(str, ((Double) obj).doubleValue());
        } else if (obj instanceof Bundle[]) {
            bundle.putParcelableArray(str, (Bundle[]) obj);
        } else if (str != null) {
            zzj().zzw().zza("Not putting event parameter. Invalid value type. name, type", zzi().zzb(str), obj != null ? obj.getClass().getSimpleName() : null);
        }
    }

    public final void zza(com.google.android.gms.internal.measurement.zzdq zzdqVar, boolean z5) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("r", z5);
        try {
            zzdqVar.zza(bundle);
        } catch (RemoteException e5) {
            this.zzu.zzj().zzr().zza("Error returning boolean value to wrapper", e5);
        }
    }

    public final void zza(com.google.android.gms.internal.measurement.zzdq zzdqVar, ArrayList<Bundle> arrayList) {
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("r", arrayList);
        try {
            zzdqVar.zza(bundle);
        } catch (RemoteException e5) {
            this.zzu.zzj().zzr().zza("Error returning bundle list to wrapper", e5);
        }
    }

    public final void zza(com.google.android.gms.internal.measurement.zzdq zzdqVar, Bundle bundle) {
        try {
            zzdqVar.zza(bundle);
        } catch (RemoteException e5) {
            this.zzu.zzj().zzr().zza("Error returning bundle value to wrapper", e5);
        }
    }

    public final void zza(com.google.android.gms.internal.measurement.zzdq zzdqVar, byte[] bArr) {
        Bundle bundle = new Bundle();
        bundle.putByteArray("r", bArr);
        try {
            zzdqVar.zza(bundle);
        } catch (RemoteException e5) {
            this.zzu.zzj().zzr().zza("Error returning byte array to wrapper", e5);
        }
    }

    public final void zza(com.google.android.gms.internal.measurement.zzdq zzdqVar, int i5) {
        Bundle bundle = new Bundle();
        bundle.putInt("r", i5);
        try {
            zzdqVar.zza(bundle);
        } catch (RemoteException e5) {
            this.zzu.zzj().zzr().zza("Error returning int value to wrapper", e5);
        }
    }

    public final void zza(com.google.android.gms.internal.measurement.zzdq zzdqVar, long j5) {
        Bundle bundle = new Bundle();
        bundle.putLong("r", j5);
        try {
            zzdqVar.zza(bundle);
        } catch (RemoteException e5) {
            this.zzu.zzj().zzr().zza("Error returning long value to wrapper", e5);
        }
    }

    public final void zza(com.google.android.gms.internal.measurement.zzdq zzdqVar, String str) {
        Bundle bundle = new Bundle();
        bundle.putString("r", str);
        try {
            zzdqVar.zza(bundle);
        } catch (RemoteException e5) {
            this.zzu.zzj().zzr().zza("Error returning string value to wrapper", e5);
        }
    }

    private final void zza(String str, String str2, String str3, Bundle bundle, List<String> list, boolean z5) {
        int zzj;
        int i5;
        String str4;
        int zza2;
        int i6;
        if (bundle == null) {
            return;
        }
        int i7 = zze().zzs().zza(231100000, true) ? 35 : 0;
        int i8 = 0;
        for (String str5 : new TreeSet(bundle.keySet())) {
            if (list == null || !list.contains(str5)) {
                zzj = !z5 ? zzj(str5) : 0;
                if (zzj == 0) {
                    zzj = zzi(str5);
                }
            } else {
                zzj = 0;
            }
            if (zzj != 0) {
                zza(bundle, zzj, str5, zzj == 3 ? str5 : null);
                bundle.remove(str5);
                i5 = i7;
            } else {
                if (zza(bundle.get(str5))) {
                    zzj().zzw().zza("Nested Bundle parameters are not allowed; discarded. event name, param name, child param name", str2, str3, str5);
                    zza2 = 22;
                    str4 = str5;
                    i5 = i7;
                } else {
                    str4 = str5;
                    i5 = i7;
                    zza2 = zza(str, str2, str5, bundle.get(str5), bundle, list, z5, false);
                }
                if (zza2 != 0 && !"_ev".equals(str4)) {
                    zza(bundle, zza2, str4, bundle.get(str4));
                    bundle.remove(str4);
                } else {
                    if (!zzg(str4) || zza(str4, zzjo.zzd)) {
                        i6 = i5;
                    } else {
                        int i9 = i8 + 1;
                        if (zza(231100000, true)) {
                            i6 = i5;
                            if (i9 > i6) {
                                zzj().zzm().zza("Item can't contain more than " + i6 + " item-scoped custom params", zzi().zza(str2), zzi().zza(bundle));
                                zzb(bundle, 28);
                                bundle.remove(str4);
                            }
                        } else {
                            zzj().zzm().zza("Item array not supported on client's version of Google Play Services (Android Only)", zzi().zza(str2), zzi().zza(bundle));
                            zzb(bundle, 23);
                            bundle.remove(str4);
                            i6 = i5;
                        }
                        i8 = i9;
                    }
                    i7 = i6;
                }
            }
            i7 = i5;
        }
    }

    private static boolean zza(String str, String[] strArr) {
        Preconditions.checkNotNull(strArr);
        for (String str2 : strArr) {
            if (Objects.equals(str, str2)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zza(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            if (zzl(str)) {
                return true;
            }
            if (this.zzu.zzag()) {
                zzj().zzm().zza("Invalid google_app_id. Firebase Analytics disabled. See https://goo.gl/NAOOOI. provided id", zzgo.zza(str));
            }
            return false;
        }
        if (!TextUtils.isEmpty(str2)) {
            if (zzl(str2)) {
                return true;
            }
            zzj().zzm().zza("Invalid admob_app_id. Analytics disabled.", zzgo.zza(str2));
            return false;
        }
        if (this.zzu.zzag()) {
            zzj().zzm().zza("Missing google_app_id. Firebase Analytics disabled. See https://goo.gl/NAOOOI");
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zza(String str, int i5, String str2) {
        if (str2 == null) {
            zzj().zzm().zza("Name is required and can't be null. Type", str);
            return false;
        }
        if (str2.codePointCount(0, str2.length()) <= i5) {
            return true;
        }
        zzj().zzm().zza("Name is too long. Type, maximum supported length, name", str, Integer.valueOf(i5), str2);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zza(String str, String[] strArr, String str2) {
        return zza(str, strArr, (String[]) null, str2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zza(String str, String[] strArr, String[] strArr2, String str2) {
        if (str2 == null) {
            zzj().zzm().zza("Name is required and can't be null. Type", str);
            return false;
        }
        Preconditions.checkNotNull(str2);
        for (String str3 : zza) {
            if (str2.startsWith(str3)) {
                zzj().zzm().zza("Name starts with reserved prefix. Type, name", str, str2);
                return false;
            }
        }
        if (strArr == null || !zza(str2, strArr)) {
            return true;
        }
        if (strArr2 != null && zza(str2, strArr2)) {
            return true;
        }
        zzj().zzm().zza("Name is reserved. Type, name", str, str2);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zza(String str, String str2, int i5, Object obj) {
        if (obj != null && !(obj instanceof Long) && !(obj instanceof Float) && !(obj instanceof Integer) && !(obj instanceof Byte) && !(obj instanceof Short) && !(obj instanceof Boolean) && !(obj instanceof Double)) {
            if (!(obj instanceof String) && !(obj instanceof Character) && !(obj instanceof CharSequence)) {
                return false;
            }
            String valueOf = String.valueOf(obj);
            if (valueOf.codePointCount(0, valueOf.length()) > i5) {
                zzj().zzw().zza("Value is too long; discarded. Value kind, name, value length", str, str2, Integer.valueOf(valueOf.length()));
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean zza(Bundle bundle, int i5) {
        int i6 = 0;
        if (bundle.size() <= i5) {
            return false;
        }
        for (String str : new TreeSet(bundle.keySet())) {
            i6++;
            if (i6 > i5) {
                bundle.remove(str);
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean zza(Object obj) {
        return (obj instanceof Parcelable[]) || (obj instanceof ArrayList) || (obj instanceof Bundle);
    }

    public final boolean zza(int i5, boolean z5) {
        Boolean zzad = this.zzu.zzt().zzad();
        if (zzg() < i5 / Constants.ONE_SECOND) {
            return (zzad == null || zzad.booleanValue()) ? false : true;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean zza(Context context) {
        ActivityInfo receiverInfo;
        Preconditions.checkNotNull(context);
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null && (receiverInfo = packageManager.getReceiverInfo(new ComponentName(context, "com.google.android.gms.measurement.AppMeasurementReceiver"), 0)) != null) {
                if (receiverInfo.enabled) {
                    return true;
                }
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean zza(Context context, boolean z5) {
        Preconditions.checkNotNull(context);
        return zzb(context, "com.google.android.gms.measurement.AppMeasurementJobService");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SuppressLint({"ApplySharedPref"})
    public final boolean zza(String str, double d5) {
        try {
            SharedPreferences.Editor edit = zza().getSharedPreferences("google.analytics.deferred.deeplink.prefs", 0).edit();
            edit.putString(Constants.DEEPLINK, str);
            edit.putLong("timestamp", Double.doubleToRawLongBits(d5));
            return edit.commit();
        } catch (RuntimeException e5) {
            zzj().zzg().zza("Failed to persist Deferred Deep Link. exception", e5);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean zza(Intent intent) {
        String stringExtra = intent.getStringExtra("android.intent.extra.REFERRER_NAME");
        return "android-app://com.google.android.googlequicksearchbox/https/www.google.com".equals(stringExtra) || "https://www.google.com".equals(stringExtra) || "android-app://com.google.appcrawler".equals(stringExtra);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean zza(String str, String str2, String str3, String str4) {
        boolean isEmpty = TextUtils.isEmpty(str);
        boolean isEmpty2 = TextUtils.isEmpty(str2);
        if (!isEmpty && !isEmpty2) {
            Preconditions.checkNotNull(str);
            return !str.equals(str2);
        }
        if (isEmpty && isEmpty2) {
            return (TextUtils.isEmpty(str3) || TextUtils.isEmpty(str4)) ? !TextUtils.isEmpty(str4) : !str3.equals(str4);
        }
        if (isEmpty || !isEmpty2) {
            return TextUtils.isEmpty(str3) || !str3.equals(str4);
        }
        if (TextUtils.isEmpty(str4)) {
            return false;
        }
        return TextUtils.isEmpty(str3) || !str3.equals(str4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static byte[] zza(Parcelable parcelable) {
        if (parcelable == null) {
            return null;
        }
        Parcel obtain = Parcel.obtain();
        try {
            parcelable.writeToParcel(obtain, 0);
            return obtain.marshall();
        } finally {
            obtain.recycle();
        }
    }
}
