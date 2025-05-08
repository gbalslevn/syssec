package com.google.android.gms.internal.measurement;

import java.lang.Comparable;
import java.util.AbstractMap;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class zzmj<K extends Comparable<K>, V> extends AbstractMap<K, V> {
    private Object[] zza;
    private int zzb;
    private Map<K, V> zzc;
    private boolean zzd;
    private volatile zzmp zze;
    private Map<K, V> zzf;

    private final SortedMap<K, V> zzf() {
        zzg();
        if (this.zzc.isEmpty() && !(this.zzc instanceof TreeMap)) {
            TreeMap treeMap = new TreeMap();
            this.zzc = treeMap;
            this.zzf = treeMap.descendingMap();
        }
        return (SortedMap) this.zzc;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzg() {
        if (this.zzd) {
            throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        zzg();
        if (this.zzb != 0) {
            this.zza = null;
            this.zzb = 0;
        }
        if (this.zzc.isEmpty()) {
            return;
        }
        this.zzc.clear();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        return zza((zzmj<K, V>) comparable) >= 0 || this.zzc.containsKey(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        if (this.zze == null) {
            this.zze = new zzmp(this);
        }
        return this.zze;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzmj)) {
            return super.equals(obj);
        }
        zzmj zzmjVar = (zzmj) obj;
        int size = size();
        if (size != zzmjVar.size()) {
            return false;
        }
        int i5 = this.zzb;
        if (i5 != zzmjVar.zzb) {
            return entrySet().equals(zzmjVar.entrySet());
        }
        for (int i6 = 0; i6 < i5; i6++) {
            if (!zza(i6).equals(zzmjVar.zza(i6))) {
                return false;
            }
        }
        if (i5 != size) {
            return this.zzc.equals(zzmjVar.zzc);
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public V get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int zza = zza((zzmj<K, V>) comparable);
        return zza >= 0 ? (V) ((zzmn) this.zza[zza]).getValue() : this.zzc.get(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int hashCode() {
        int i5 = this.zzb;
        int i6 = 0;
        for (int i7 = 0; i7 < i5; i7++) {
            i6 += this.zza[i7].hashCode();
        }
        return this.zzc.size() > 0 ? i6 + this.zzc.hashCode() : i6;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public /* synthetic */ Object put(Object obj, Object obj2) {
        return zza((zzmj<K, V>) obj, (Comparable) obj2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        zzg();
        Comparable comparable = (Comparable) obj;
        int zza = zza((zzmj<K, V>) comparable);
        if (zza >= 0) {
            return (V) zzb(zza);
        }
        if (this.zzc.isEmpty()) {
            return null;
        }
        return this.zzc.remove(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return this.zzb + this.zzc.size();
    }

    private zzmj() {
        this.zzc = Collections.emptyMap();
        this.zzf = Collections.emptyMap();
    }

    public final int zzb() {
        return this.zzb;
    }

    public final Iterable<Map.Entry<K, V>> zzc() {
        if (this.zzc.isEmpty()) {
            return Collections.emptySet();
        }
        return this.zzc.entrySet();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Set<Map.Entry<K, V>> zzd() {
        return new zzmk(this);
    }

    public final boolean zze() {
        return this.zzd;
    }

    private final int zza(K k5) {
        int i5;
        int i6 = this.zzb;
        int i7 = i6 - 1;
        if (i7 >= 0) {
            int compareTo = k5.compareTo((Comparable) ((zzmn) this.zza[i7]).getKey());
            if (compareTo > 0) {
                i5 = i6 + 1;
                return -i5;
            }
            if (compareTo == 0) {
                return i7;
            }
        }
        int i8 = 0;
        while (i8 <= i7) {
            int i9 = (i8 + i7) / 2;
            int compareTo2 = k5.compareTo((Comparable) ((zzmn) this.zza[i9]).getKey());
            if (compareTo2 < 0) {
                i7 = i9 - 1;
            } else {
                if (compareTo2 <= 0) {
                    return i9;
                }
                i8 = i9 + 1;
            }
        }
        i5 = i8 + 1;
        return -i5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final V zzb(int i5) {
        zzg();
        V v5 = (V) ((zzmn) this.zza[i5]).getValue();
        Object[] objArr = this.zza;
        System.arraycopy(objArr, i5 + 1, objArr, i5, (this.zzb - i5) - 1);
        this.zzb--;
        if (!this.zzc.isEmpty()) {
            Iterator<Map.Entry<K, V>> it = zzf().entrySet().iterator();
            this.zza[this.zzb] = new zzmn(this, it.next());
            this.zzb++;
            it.remove();
        }
        return v5;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final V zza(K k5, V v5) {
        zzg();
        int zza = zza((zzmj<K, V>) k5);
        if (zza >= 0) {
            return (V) ((zzmn) this.zza[zza]).setValue(v5);
        }
        zzg();
        if (this.zza == null) {
            this.zza = new Object[16];
        }
        int i5 = -(zza + 1);
        if (i5 >= 16) {
            return zzf().put(k5, v5);
        }
        int i6 = this.zzb;
        if (i6 == 16) {
            zzmn zzmnVar = (zzmn) this.zza[15];
            this.zzb = i6 - 1;
            zzf().put((Comparable) zzmnVar.getKey(), zzmnVar.getValue());
        }
        Object[] objArr = this.zza;
        System.arraycopy(objArr, i5, objArr, i5 + 1, (objArr.length - i5) - 1);
        this.zza[i5] = new zzmn(this, k5, v5);
        this.zzb++;
        return null;
    }

    public final Map.Entry<K, V> zza(int i5) {
        if (i5 < this.zzb) {
            return (zzmn) this.zza[i5];
        }
        throw new ArrayIndexOutOfBoundsException(i5);
    }

    public void zza() {
        Map<K, V> unmodifiableMap;
        Map<K, V> unmodifiableMap2;
        if (this.zzd) {
            return;
        }
        if (this.zzc.isEmpty()) {
            unmodifiableMap = Collections.emptyMap();
        } else {
            unmodifiableMap = Collections.unmodifiableMap(this.zzc);
        }
        this.zzc = unmodifiableMap;
        if (this.zzf.isEmpty()) {
            unmodifiableMap2 = Collections.emptyMap();
        } else {
            unmodifiableMap2 = Collections.unmodifiableMap(this.zzf);
        }
        this.zzf = unmodifiableMap2;
        this.zzd = true;
    }
}
