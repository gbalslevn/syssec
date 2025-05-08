package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.measurement.internal.zzjj;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class zzoe {
    private static final String[] zza = {"GoogleConsent", "gdprApplies", "EnableAdvertiserConsentMode", "PolicyVersion", "PurposeConsents", "CmpSdkID"};
    private final Map<String, String> zzb;

    private zzoe(Map<String, String> map) {
        HashMap hashMap = new HashMap();
        this.zzb = hashMap;
        hashMap.putAll(map);
    }

    private static int zza(SharedPreferences sharedPreferences, String str) {
        try {
            return sharedPreferences.getInt(str, -1);
        } catch (ClassCastException unused) {
            return -1;
        }
    }

    private static String zzb(SharedPreferences sharedPreferences, String str) {
        try {
            return sharedPreferences.getString(str, "\u0000");
        } catch (ClassCastException unused) {
            return "\u0000";
        }
    }

    private final int zzd() {
        try {
            String str = this.zzb.get("CmpSdkID");
            if (TextUtils.isEmpty(str)) {
                return -1;
            }
            return Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    private final int zze() {
        try {
            String str = this.zzb.get("PolicyVersion");
            if (TextUtils.isEmpty(str)) {
                return -1;
            }
            return Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzoe) {
            return zzc().equalsIgnoreCase(((zzoe) obj).zzc());
        }
        return false;
    }

    public final int hashCode() {
        return zzc().hashCode();
    }

    public final String toString() {
        return zzc();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String zzc() {
        StringBuilder sb = new StringBuilder();
        for (String str : zza) {
            if (this.zzb.containsKey(str)) {
                if (sb.length() > 0) {
                    sb.append(";");
                }
                sb.append(str);
                sb.append("=");
                sb.append(this.zzb.get(str));
            }
        }
        return sb.toString();
    }

    public final Bundle zza() {
        if ("1".equals(this.zzb.get("GoogleConsent")) && "1".equals(this.zzb.get("gdprApplies")) && "1".equals(this.zzb.get("EnableAdvertiserConsentMode"))) {
            int zze = zze();
            if (zze < 0) {
                return Bundle.EMPTY;
            }
            String str = this.zzb.get("PurposeConsents");
            if (TextUtils.isEmpty(str)) {
                return Bundle.EMPTY;
            }
            Bundle bundle = new Bundle();
            String str2 = "denied";
            if (str.length() > 0) {
                bundle.putString(zzjj.zza.AD_STORAGE.zze, str.charAt(0) == '1' ? "granted" : "denied");
            }
            if (str.length() > 3) {
                bundle.putString(zzjj.zza.AD_PERSONALIZATION.zze, (str.charAt(2) == '1' && str.charAt(3) == '1') ? "granted" : "denied");
            }
            if (str.length() > 6 && zze >= 4) {
                String str3 = zzjj.zza.AD_USER_DATA.zze;
                if (str.charAt(0) == '1' && str.charAt(6) == '1') {
                    str2 = "granted";
                }
                bundle.putString(str3, str2);
            }
            return bundle;
        }
        return Bundle.EMPTY;
    }

    public final String zzb() {
        StringBuilder sb = new StringBuilder();
        sb.append("1");
        int zzd = zzd();
        if (zzd >= 0 && zzd <= 4095) {
            sb.append("0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-_".charAt((zzd >> 6) & 63));
            sb.append("0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-_".charAt(zzd & 63));
        } else {
            sb.append("00");
        }
        int zze = zze();
        if (zze >= 0 && zze <= 63) {
            sb.append("0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-_".charAt(zze));
        } else {
            sb.append("0");
        }
        Preconditions.checkArgument(true);
        int i5 = "1".equals(this.zzb.get("gdprApplies")) ? 2 : 0;
        int i6 = i5 | 4;
        if ("1".equals(this.zzb.get("EnableAdvertiserConsentMode"))) {
            i6 = i5 | 12;
        }
        sb.append("0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-_".charAt(i6));
        return sb.toString();
    }

    public static zzoe zza(SharedPreferences sharedPreferences) {
        HashMap hashMap = new HashMap();
        String zzb = zzb(sharedPreferences, "IABTCF_VendorConsents");
        if (!"\u0000".equals(zzb) && zzb.length() > 754) {
            hashMap.put("GoogleConsent", String.valueOf(zzb.charAt(754)));
        }
        int zza2 = zza(sharedPreferences, "IABTCF_gdprApplies");
        if (zza2 != -1) {
            hashMap.put("gdprApplies", String.valueOf(zza2));
        }
        int zza3 = zza(sharedPreferences, "IABTCF_EnableAdvertiserConsentMode");
        if (zza3 != -1) {
            hashMap.put("EnableAdvertiserConsentMode", String.valueOf(zza3));
        }
        int zza4 = zza(sharedPreferences, "IABTCF_PolicyVersion");
        if (zza4 != -1) {
            hashMap.put("PolicyVersion", String.valueOf(zza4));
        }
        String zzb2 = zzb(sharedPreferences, "IABTCF_PurposeConsents");
        if (!"\u0000".equals(zzb2)) {
            hashMap.put("PurposeConsents", zzb2);
        }
        int zza5 = zza(sharedPreferences, "IABTCF_CmpSdkID");
        if (zza5 != -1) {
            hashMap.put("CmpSdkID", String.valueOf(zza5));
        }
        return new zzoe(hashMap);
    }

    public static String zza(String str, boolean z5) {
        if (!z5 || str.length() <= 4) {
            return str;
        }
        char[] charArray = str.toCharArray();
        int i5 = 1;
        while (true) {
            if (i5 >= 64) {
                i5 = 0;
                break;
            }
            if (charArray[4] == "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-_".charAt(i5)) {
                break;
            }
            i5++;
        }
        charArray[4] = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-_".charAt(1 | i5);
        return String.valueOf(charArray);
    }
}
