package com.google.android.gms.internal.measurement;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public final class zzlg<K, V> extends LinkedHashMap<K, V> {
    private static final zzlg<?, ?> zza;
    private boolean zzb;

    static {
        zzlg<?, ?> zzlgVar = new zzlg<>();
        zza = zzlgVar;
        ((zzlg) zzlgVar).zzb = false;
    }

    private zzlg() {
        this.zzb = true;
    }

    private static int zza(Object obj) {
        if (obj instanceof byte[]) {
            return zzkj.zza((byte[]) obj);
        }
        if (!(obj instanceof zzki)) {
            return obj.hashCode();
        }
        throw new UnsupportedOperationException();
    }

    private final void zze() {
        if (!this.zzb) {
            throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final void clear() {
        zze();
        super.clear();
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final Set<Map.Entry<K, V>> entrySet() {
        return isEmpty() ? Collections.emptySet() : super.entrySet();
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x005c A[RETURN] */
    @Override // java.util.AbstractMap, java.util.Map
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean equals(Object obj) {
        boolean z5;
        if (obj instanceof Map) {
            Map map = (Map) obj;
            if (this != map) {
                if (size() == map.size()) {
                    for (Map.Entry<K, V> entry : entrySet()) {
                        if (map.containsKey(entry.getKey())) {
                            V value = entry.getValue();
                            Object obj2 = map.get(entry.getKey());
                            if (!(((value instanceof byte[]) && (obj2 instanceof byte[])) ? Arrays.equals((byte[]) value, (byte[]) obj2) : value.equals(obj2))) {
                            }
                        }
                    }
                }
                z5 = false;
                if (!z5) {
                    return true;
                }
            }
            z5 = true;
            if (!z5) {
            }
        }
        return false;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int hashCode() {
        int i5 = 0;
        for (Map.Entry<K, V> entry : entrySet()) {
            i5 += zza(entry.getValue()) ^ zza(entry.getKey());
        }
        return i5;
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final V put(K k5, V v5) {
        zze();
        zzkj.zza(k5);
        zzkj.zza(v5);
        return (V) super.put(k5, v5);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final void putAll(Map<? extends K, ? extends V> map) {
        zze();
        for (K k5 : map.keySet()) {
            zzkj.zza(k5);
            zzkj.zza(map.get(k5));
        }
        super.putAll(map);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final V remove(Object obj) {
        zze();
        return (V) super.remove(obj);
    }

    public final zzlg<K, V> zzb() {
        return isEmpty() ? new zzlg<>() : new zzlg<>(this);
    }

    public final void zzc() {
        this.zzb = false;
    }

    public final boolean zzd() {
        return this.zzb;
    }

    private zzlg(Map<K, V> map) {
        super(map);
        this.zzb = true;
    }

    public static <K, V> zzlg<K, V> zza() {
        return (zzlg<K, V>) zza;
    }

    public final void zza(zzlg<K, V> zzlgVar) {
        zze();
        if (zzlgVar.isEmpty()) {
            return;
        }
        putAll(zzlgVar);
    }
}
