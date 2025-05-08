package com.google.firebase.analytics.connector.internal;

import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.measurement.internal.zzjk;
import com.google.android.gms.measurement.internal.zzjp;
import com.google.android.gms.measurement.internal.zzjr;
import com.google.android.gms.measurement.internal.zzlx;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.firebase.analytics.connector.AnalyticsConnector;

/* loaded from: classes2.dex */
public abstract class zzd {
    private static final ImmutableSet<String> zza = ImmutableSet.of("_in", "_xa", "_xu", "_aq", "_aa", "_ai", "_ac", "campaign_details", "_ug", "_iapx", "_exp_set", "_exp_clear", "_exp_activate", "_exp_timeout", "_exp_expire");
    private static final ImmutableList<String> zzb = ImmutableList.of("_e", "_f", "_iap", "_s", "_au", "_ui", "_cd");
    private static final ImmutableList<String> zzc = ImmutableList.of("auto", "app", "am");
    private static final ImmutableList<String> zzd = ImmutableList.of("_r", "_dbg");
    private static final ImmutableList<String> zze = new ImmutableList.Builder().add((Object[]) zzjr.zza).add((Object[]) zzjr.zzb).build();
    private static final ImmutableList<String> zzf = ImmutableList.of("^_ltv_[A-Z]{3}$", "^_cc[1-5]{1}$");

    public static Bundle zza(AnalyticsConnector.ConditionalUserProperty conditionalUserProperty) {
        Bundle bundle = new Bundle();
        String str = conditionalUserProperty.origin;
        if (str != null) {
            bundle.putString("origin", str);
        }
        String str2 = conditionalUserProperty.name;
        if (str2 != null) {
            bundle.putString("name", str2);
        }
        Object obj = conditionalUserProperty.value;
        if (obj != null) {
            zzjk.zza(bundle, obj);
        }
        String str3 = conditionalUserProperty.triggerEventName;
        if (str3 != null) {
            bundle.putString("trigger_event_name", str3);
        }
        bundle.putLong("trigger_timeout", conditionalUserProperty.triggerTimeout);
        String str4 = conditionalUserProperty.timedOutEventName;
        if (str4 != null) {
            bundle.putString("timed_out_event_name", str4);
        }
        Bundle bundle2 = conditionalUserProperty.timedOutEventParams;
        if (bundle2 != null) {
            bundle.putBundle("timed_out_event_params", bundle2);
        }
        String str5 = conditionalUserProperty.triggeredEventName;
        if (str5 != null) {
            bundle.putString("triggered_event_name", str5);
        }
        Bundle bundle3 = conditionalUserProperty.triggeredEventParams;
        if (bundle3 != null) {
            bundle.putBundle("triggered_event_params", bundle3);
        }
        bundle.putLong("time_to_live", conditionalUserProperty.timeToLive);
        String str6 = conditionalUserProperty.expiredEventName;
        if (str6 != null) {
            bundle.putString("expired_event_name", str6);
        }
        Bundle bundle4 = conditionalUserProperty.expiredEventParams;
        if (bundle4 != null) {
            bundle.putBundle("expired_event_params", bundle4);
        }
        bundle.putLong("creation_timestamp", conditionalUserProperty.creationTimestamp);
        bundle.putBoolean("active", conditionalUserProperty.active);
        bundle.putLong("triggered_timestamp", conditionalUserProperty.triggeredTimestamp);
        return bundle;
    }

    public static boolean zzb(String str, String str2, Bundle bundle) {
        if (!"_cmp".equals(str2)) {
            return true;
        }
        if (!zzf(str) || bundle == null) {
            return false;
        }
        ImmutableList<String> immutableList = zzd;
        int size = immutableList.size();
        int i5 = 0;
        while (i5 < size) {
            String str3 = immutableList.get(i5);
            i5++;
            if (bundle.containsKey(str3)) {
                return false;
            }
        }
        str.hashCode();
        char c5 = 65535;
        switch (str.hashCode()) {
            case 101200:
                if (str.equals("fcm")) {
                    c5 = 0;
                    break;
                }
                break;
            case 101230:
                if (str.equals("fdl")) {
                    c5 = 1;
                    break;
                }
                break;
            case 3142703:
                if (str.equals("fiam")) {
                    c5 = 2;
                    break;
                }
                break;
        }
        switch (c5) {
            case 0:
                bundle.putString("_cis", "fcm_integration");
                return true;
            case 1:
                bundle.putString("_cis", "fdl_integration");
                return true;
            case 2:
                bundle.putString("_cis", "fiam_integration");
                return true;
            default:
                return false;
        }
    }

    public static boolean zze(String str) {
        return !zza.contains(str);
    }

    public static boolean zzf(String str) {
        return !zzc.contains(str);
    }

    public static boolean zzb(AnalyticsConnector.ConditionalUserProperty conditionalUserProperty) {
        String str;
        if (conditionalUserProperty == null || (str = conditionalUserProperty.origin) == null || str.isEmpty()) {
            return false;
        }
        Object obj = conditionalUserProperty.value;
        if ((obj != null && zzlx.zza(obj) == null) || !zzf(str) || !zza(str, conditionalUserProperty.name)) {
            return false;
        }
        String str2 = conditionalUserProperty.expiredEventName;
        if (str2 != null && (!zza(str2, conditionalUserProperty.expiredEventParams) || !zzb(str, conditionalUserProperty.expiredEventName, conditionalUserProperty.expiredEventParams))) {
            return false;
        }
        String str3 = conditionalUserProperty.triggeredEventName;
        if (str3 != null && (!zza(str3, conditionalUserProperty.triggeredEventParams) || !zzb(str, conditionalUserProperty.triggeredEventName, conditionalUserProperty.triggeredEventParams))) {
            return false;
        }
        String str4 = conditionalUserProperty.timedOutEventName;
        if (str4 != null) {
            return zza(str4, conditionalUserProperty.timedOutEventParams) && zzb(str, conditionalUserProperty.timedOutEventName, conditionalUserProperty.timedOutEventParams);
        }
        return true;
    }

    public static AnalyticsConnector.ConditionalUserProperty zza(Bundle bundle) {
        Preconditions.checkNotNull(bundle);
        AnalyticsConnector.ConditionalUserProperty conditionalUserProperty = new AnalyticsConnector.ConditionalUserProperty();
        conditionalUserProperty.origin = (String) Preconditions.checkNotNull((String) zzjk.zza(bundle, "origin", String.class, null));
        conditionalUserProperty.name = (String) Preconditions.checkNotNull((String) zzjk.zza(bundle, "name", String.class, null));
        conditionalUserProperty.value = zzjk.zza(bundle, "value", Object.class, null);
        conditionalUserProperty.triggerEventName = (String) zzjk.zza(bundle, "trigger_event_name", String.class, null);
        conditionalUserProperty.triggerTimeout = ((Long) zzjk.zza(bundle, "trigger_timeout", Long.class, 0L)).longValue();
        conditionalUserProperty.timedOutEventName = (String) zzjk.zza(bundle, "timed_out_event_name", String.class, null);
        conditionalUserProperty.timedOutEventParams = (Bundle) zzjk.zza(bundle, "timed_out_event_params", Bundle.class, null);
        conditionalUserProperty.triggeredEventName = (String) zzjk.zza(bundle, "triggered_event_name", String.class, null);
        conditionalUserProperty.triggeredEventParams = (Bundle) zzjk.zza(bundle, "triggered_event_params", Bundle.class, null);
        conditionalUserProperty.timeToLive = ((Long) zzjk.zza(bundle, "time_to_live", Long.class, 0L)).longValue();
        conditionalUserProperty.expiredEventName = (String) zzjk.zza(bundle, "expired_event_name", String.class, null);
        conditionalUserProperty.expiredEventParams = (Bundle) zzjk.zza(bundle, "expired_event_params", Bundle.class, null);
        conditionalUserProperty.active = ((Boolean) zzjk.zza(bundle, "active", Boolean.class, Boolean.FALSE)).booleanValue();
        conditionalUserProperty.creationTimestamp = ((Long) zzjk.zza(bundle, "creation_timestamp", Long.class, 0L)).longValue();
        conditionalUserProperty.triggeredTimestamp = ((Long) zzjk.zza(bundle, "triggered_timestamp", Long.class, 0L)).longValue();
        return conditionalUserProperty;
    }

    public static String zza(String str) {
        String zza2 = zzjp.zza(str);
        return zza2 != null ? zza2 : str;
    }

    public static void zza(String str, String str2, Bundle bundle) {
        if ("clx".equals(str) && "_ae".equals(str2)) {
            bundle.putLong("_r", 1L);
        }
    }

    public static boolean zza(String str, Bundle bundle) {
        if (zzb.contains(str)) {
            return false;
        }
        if (bundle == null) {
            return true;
        }
        ImmutableList<String> immutableList = zzd;
        int size = immutableList.size();
        int i5 = 0;
        while (i5 < size) {
            String str2 = immutableList.get(i5);
            i5++;
            if (bundle.containsKey(str2)) {
                return false;
            }
        }
        return true;
    }

    public static boolean zza(String str, String str2) {
        if ("_ce1".equals(str2) || "_ce2".equals(str2)) {
            return str.equals("fcm") || str.equals("frc");
        }
        if ("_ln".equals(str2)) {
            return str.equals("fcm") || str.equals("fiam");
        }
        if (zze.contains(str2)) {
            return false;
        }
        ImmutableList<String> immutableList = zzf;
        int size = immutableList.size();
        int i5 = 0;
        while (i5 < size) {
            String str3 = immutableList.get(i5);
            i5++;
            if (str2.matches(str3)) {
                return false;
            }
        }
        return true;
    }
}
