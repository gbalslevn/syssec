package com.google.android.gms.internal.measurement;

import android.content.SharedPreferences;
import com.google.common.collect.Sets;
import com.google.common.collect.UnmodifiableIterator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
final class zzcu implements SharedPreferences.Editor {
    private boolean zza;
    private Set<String> zzb;
    private Map<String, Object> zzc;
    private final /* synthetic */ zzcr zzd;

    private final void zza(String str, Object obj) {
        if (obj != null) {
            this.zzc.put(str, obj);
        } else {
            remove(str);
        }
    }

    @Override // android.content.SharedPreferences.Editor
    public final void apply() {
        commit();
    }

    @Override // android.content.SharedPreferences.Editor
    public final SharedPreferences.Editor clear() {
        this.zza = true;
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.content.SharedPreferences.Editor
    public final boolean commit() {
        Map map;
        Set<SharedPreferences.OnSharedPreferenceChangeListener> set;
        Map map2;
        Map map3;
        if (this.zza) {
            map3 = this.zzd.zza;
            map3.clear();
        }
        map = this.zzd.zza;
        map.keySet().removeAll(this.zzb);
        for (Map.Entry<String, Object> entry : this.zzc.entrySet()) {
            map2 = this.zzd.zza;
            map2.put(entry.getKey(), entry.getValue());
        }
        set = this.zzd.zzb;
        for (SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener : set) {
            UnmodifiableIterator it = Sets.union(this.zzb, this.zzc.keySet()).iterator();
            while (it.hasNext()) {
                onSharedPreferenceChangeListener.onSharedPreferenceChanged(this.zzd, (String) it.next());
            }
        }
        return (!this.zza && this.zzb.isEmpty() && this.zzc.isEmpty()) ? false : true;
    }

    @Override // android.content.SharedPreferences.Editor
    public final SharedPreferences.Editor putBoolean(String str, boolean z5) {
        zza(str, Boolean.valueOf(z5));
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public final SharedPreferences.Editor putFloat(String str, float f5) {
        zza(str, Float.valueOf(f5));
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public final SharedPreferences.Editor putInt(String str, int i5) {
        zza(str, Integer.valueOf(i5));
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public final SharedPreferences.Editor putLong(String str, long j5) {
        zza(str, Long.valueOf(j5));
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public final SharedPreferences.Editor putString(String str, String str2) {
        zza(str, str2);
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public final SharedPreferences.Editor putStringSet(String str, Set<String> set) {
        zza(str, set);
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public final SharedPreferences.Editor remove(String str) {
        this.zzb.add(str);
        return this;
    }

    private zzcu(zzcr zzcrVar) {
        this.zzd = zzcrVar;
        this.zza = false;
        this.zzb = new HashSet();
        this.zzc = new HashMap();
    }
}
