package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
final class zzli implements zzlj {
    @Override // com.google.android.gms.internal.measurement.zzlj
    public final int zza(int i5, Object obj, Object obj2) {
        zzlg zzlgVar = (zzlg) obj;
        android.support.v4.media.session.a.a(obj2);
        if (zzlgVar.isEmpty()) {
            return 0;
        }
        Iterator it = zzlgVar.entrySet().iterator();
        if (!it.hasNext()) {
            return 0;
        }
        Map.Entry entry = (Map.Entry) it.next();
        entry.getKey();
        entry.getValue();
        throw new NoSuchMethodError();
    }

    @Override // com.google.android.gms.internal.measurement.zzlj
    public final Object zzb(Object obj) {
        return zzlg.zza().zzb();
    }

    @Override // com.google.android.gms.internal.measurement.zzlj
    public final Object zzc(Object obj) {
        ((zzlg) obj).zzc();
        return obj;
    }

    @Override // com.google.android.gms.internal.measurement.zzlj
    public final Map<?, ?> zzd(Object obj) {
        return (zzlg) obj;
    }

    @Override // com.google.android.gms.internal.measurement.zzlj
    public final Map<?, ?> zze(Object obj) {
        return (zzlg) obj;
    }

    @Override // com.google.android.gms.internal.measurement.zzlj
    public final boolean zzf(Object obj) {
        return !((zzlg) obj).zzd();
    }

    @Override // com.google.android.gms.internal.measurement.zzlj
    public final zzlh<?, ?> zza(Object obj) {
        android.support.v4.media.session.a.a(obj);
        throw new NoSuchMethodError();
    }

    @Override // com.google.android.gms.internal.measurement.zzlj
    public final Object zza(Object obj, Object obj2) {
        zzlg zzlgVar = (zzlg) obj;
        zzlg zzlgVar2 = (zzlg) obj2;
        if (!zzlgVar2.isEmpty()) {
            if (!zzlgVar.zzd()) {
                zzlgVar = zzlgVar.zzb();
            }
            zzlgVar.zza(zzlgVar2);
        }
        return zzlgVar;
    }
}
