package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzjy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
final class zzjw<T extends zzjy<T>> {
    private static final zzjw<?> zzb = new zzjw<>(true);
    final zzmj<T, Object> zza;
    private boolean zzc;
    private boolean zzd;

    private zzjw() {
        this.zza = new zzmi();
    }

    static int zza(zzng zzngVar, int i5, Object obj) {
        int zzf = zzjn.zzf(i5);
        if (zzngVar == zzng.zzj) {
            zzkj.zza((zzlm) obj);
            zzf <<= 1;
        }
        return zzf + zza(zzngVar, obj);
    }

    private final void zzb(Map.Entry<T, Object> entry) {
        android.support.v4.media.session.a.a(entry.getKey());
        entry.getValue();
        throw null;
    }

    public final /* synthetic */ Object clone() {
        zzjw zzjwVar = new zzjw();
        int zzb2 = this.zza.zzb();
        for (int i5 = 0; i5 < zzb2; i5++) {
            Map.Entry<T, Object> zza = this.zza.zza(i5);
            android.support.v4.media.session.a.a(zza.getKey());
            zzjwVar.zzb(null, zza.getValue());
        }
        for (Map.Entry<T, Object> entry : this.zza.zzc()) {
            android.support.v4.media.session.a.a(entry.getKey());
            zzjwVar.zzb(null, entry.getValue());
        }
        zzjwVar.zzd = this.zzd;
        return zzjwVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzjw) {
            return this.zza.equals(((zzjw) obj).zza);
        }
        return false;
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Iterator<Map.Entry<T, Object>> zzc() {
        if (this.zza.isEmpty()) {
            return Collections.emptyIterator();
        }
        if (this.zzd) {
            return new zzks(this.zza.zzd().iterator());
        }
        return this.zza.zzd().iterator();
    }

    public final Iterator<Map.Entry<T, Object>> zzd() {
        return this.zza.isEmpty() ? Collections.emptyIterator() : this.zzd ? new zzks(this.zza.entrySet().iterator()) : this.zza.entrySet().iterator();
    }

    public final void zze() {
        if (this.zzc) {
            return;
        }
        int zzb2 = this.zza.zzb();
        for (int i5 = 0; i5 < zzb2; i5++) {
            Object value = this.zza.zza(i5).getValue();
            if (value instanceof zzkg) {
                ((zzkg) value).zzco();
            }
        }
        Iterator<Map.Entry<T, Object>> it = this.zza.zzc().iterator();
        while (it.hasNext()) {
            Object value2 = it.next().getValue();
            if (value2 instanceof zzkg) {
                ((zzkg) value2).zzco();
            }
        }
        this.zza.zza();
        this.zzc = true;
    }

    public final boolean zzg() {
        int zzb2 = this.zza.zzb();
        for (int i5 = 0; i5 < zzb2; i5++) {
            if (!zzc(this.zza.zza(i5))) {
                return false;
            }
        }
        Iterator<Map.Entry<T, Object>> it = this.zza.zzc().iterator();
        while (it.hasNext()) {
            if (!zzc(it.next())) {
                return false;
            }
        }
        return true;
    }

    private zzjw(zzmj<T, Object> zzmjVar) {
        this.zza = zzmjVar;
        zze();
    }

    private final void zzb(T t5, Object obj) {
        if (t5.zze()) {
            if (obj instanceof List) {
                List list = (List) obj;
                int size = list.size();
                ArrayList arrayList = new ArrayList(size);
                for (int i5 = 0; i5 < size; i5++) {
                    Object obj2 = list.get(i5);
                    zzc(t5, obj2);
                    arrayList.add(obj2);
                }
                obj = arrayList;
            } else {
                throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            }
        } else {
            zzc(t5, obj);
        }
        this.zza.zza((zzmj<T, Object>) t5, (T) obj);
    }

    private static int zza(zzng zzngVar, Object obj) {
        switch (zzjz.zzb[zzngVar.ordinal()]) {
            case 1:
                return zzjn.zza(((Double) obj).doubleValue());
            case 2:
                return zzjn.zza(((Float) obj).floatValue());
            case 3:
                return zzjn.zzb(((Long) obj).longValue());
            case 4:
                return zzjn.zze(((Long) obj).longValue());
            case 5:
                return zzjn.zzc(((Integer) obj).intValue());
            case 6:
                return zzjn.zza(((Long) obj).longValue());
            case 7:
                return zzjn.zzb(((Integer) obj).intValue());
            case 8:
                return zzjn.zza(((Boolean) obj).booleanValue());
            case 9:
                return zzjn.zza((zzlm) obj);
            case 10:
                return zzjn.zzb((zzlm) obj);
            case 11:
                if (obj instanceof zziy) {
                    return zzjn.zza((zziy) obj);
                }
                return zzjn.zza((String) obj);
            case 12:
                if (obj instanceof zziy) {
                    return zzjn.zza((zziy) obj);
                }
                return zzjn.zza((byte[]) obj);
            case 13:
                return zzjn.zzg(((Integer) obj).intValue());
            case 14:
                return zzjn.zzd(((Integer) obj).intValue());
            case 15:
                return zzjn.zzc(((Long) obj).longValue());
            case 16:
                return zzjn.zze(((Integer) obj).intValue());
            case 17:
                return zzjn.zzd(((Long) obj).longValue());
            case 18:
                if (obj instanceof zzki) {
                    return zzjn.zza(((zzki) obj).zza());
                }
                return zzjn.zza(((Integer) obj).intValue());
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:10:0x001c, code lost:
    
        if ((r4 instanceof com.google.android.gms.internal.measurement.zzlm) == false) goto L4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0025, code lost:
    
        if ((r4 instanceof com.google.android.gms.internal.measurement.zzki) == false) goto L4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x002e, code lost:
    
        if ((r4 instanceof byte[]) == false) goto L4;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void zzc(T t5, Object obj) {
        zzng zzb2 = t5.zzb();
        zzkj.zza(obj);
        boolean z5 = true;
        switch (zzjz.zza[zzb2.zzb().ordinal()]) {
            case 1:
                z5 = obj instanceof Integer;
                break;
            case 2:
                z5 = obj instanceof Long;
                break;
            case 3:
                z5 = obj instanceof Float;
                break;
            case 4:
                z5 = obj instanceof Double;
                break;
            case 5:
                z5 = obj instanceof Boolean;
                break;
            case 6:
                z5 = obj instanceof String;
                break;
            case 7:
                if (!(obj instanceof zziy)) {
                    break;
                }
                break;
            case 8:
                if (!(obj instanceof Integer)) {
                    break;
                }
                break;
            case 9:
                break;
            default:
                z5 = false;
                break;
        }
        if (!z5) {
            throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", Integer.valueOf(t5.zza()), t5.zzb().zzb(), obj.getClass().getName()));
        }
    }

    private zzjw(boolean z5) {
        this(new zzmi());
        zze();
    }

    private static <T extends zzjy<T>> boolean zzc(Map.Entry<T, Object> entry) {
        android.support.v4.media.session.a.a(entry.getKey());
        throw null;
    }

    public static int zza(zzjy<?> zzjyVar, Object obj) {
        zzng zzb2 = zzjyVar.zzb();
        int zza = zzjyVar.zza();
        if (zzjyVar.zze()) {
            List list = (List) obj;
            int size = list.size();
            int i5 = 0;
            if (!zzjyVar.zzd()) {
                int i6 = 0;
                while (i5 < size) {
                    i6 += zza(zzb2, zza, list.get(i5));
                    i5++;
                }
                return i6;
            }
            if (list.isEmpty()) {
                return 0;
            }
            int i7 = 0;
            while (i5 < size) {
                i7 += zza(zzb2, list.get(i5));
                i5++;
            }
            return zzjn.zzf(zza) + i7 + zzjn.zzg(i7);
        }
        return zza(zzb2, zza, obj);
    }

    public final int zza() {
        int zzb2 = this.zza.zzb();
        int i5 = 0;
        for (int i6 = 0; i6 < zzb2; i6++) {
            i5 += zza(this.zza.zza(i6));
        }
        Iterator<Map.Entry<T, Object>> it = this.zza.zzc().iterator();
        while (it.hasNext()) {
            i5 += zza(it.next());
        }
        return i5;
    }

    private static int zza(Map.Entry<T, Object> entry) {
        android.support.v4.media.session.a.a(entry.getKey());
        entry.getValue();
        throw null;
    }

    public final void zza(zzjw<T> zzjwVar) {
        int zzb2 = zzjwVar.zza.zzb();
        for (int i5 = 0; i5 < zzb2; i5++) {
            zzb(zzjwVar.zza.zza(i5));
        }
        Iterator<Map.Entry<T, Object>> it = zzjwVar.zza.zzc().iterator();
        while (it.hasNext()) {
            zzb(it.next());
        }
    }
}
