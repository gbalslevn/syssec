package com.google.android.gms.internal.measurement;

import android.content.SharedPreferences;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public final class zzcr implements SharedPreferences {
    private final Map<String, Object> zza = new HashMap();
    private final Set<SharedPreferences.OnSharedPreferenceChangeListener> zzb = new HashSet();

    @Override // android.content.SharedPreferences
    public final boolean contains(String str) {
        return this.zza.containsKey(str);
    }

    @Override // android.content.SharedPreferences
    public final SharedPreferences.Editor edit() {
        return new zzcu(this);
    }

    @Override // android.content.SharedPreferences
    public final Map<String, ?> getAll() {
        return this.zza;
    }

    @Override // android.content.SharedPreferences
    public final boolean getBoolean(String str, boolean z5) {
        return ((Boolean) zza(str, Boolean.valueOf(z5))).booleanValue();
    }

    @Override // android.content.SharedPreferences
    public final float getFloat(String str, float f5) {
        return ((Float) zza(str, Float.valueOf(f5))).floatValue();
    }

    @Override // android.content.SharedPreferences
    public final int getInt(String str, int i5) {
        return ((Integer) zza(str, Integer.valueOf(i5))).intValue();
    }

    @Override // android.content.SharedPreferences
    public final long getLong(String str, long j5) {
        return ((Long) zza(str, Long.valueOf(j5))).longValue();
    }

    @Override // android.content.SharedPreferences
    public final String getString(String str, String str2) {
        return (String) zza(str, str2);
    }

    @Override // android.content.SharedPreferences
    public final Set<String> getStringSet(String str, Set<String> set) {
        return (Set) zza(str, set);
    }

    @Override // android.content.SharedPreferences
    public final void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.zzb.add(onSharedPreferenceChangeListener);
    }

    @Override // android.content.SharedPreferences
    public final void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.zzb.remove(onSharedPreferenceChangeListener);
    }

    private final <T> T zza(String str, T t5) {
        T t6 = (T) this.zza.get(str);
        return t6 != null ? t6 : t5;
    }
}
