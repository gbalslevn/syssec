package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
final class zzmi extends zzmj {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzmi() {
        super();
    }

    @Override // com.google.android.gms.internal.measurement.zzmj
    public final void zza() {
        if (!zze()) {
            if (zzb() > 0) {
                android.support.v4.media.session.a.a(zza(0).getKey());
                throw null;
            }
            Iterator it = zzc().iterator();
            if (it.hasNext()) {
                android.support.v4.media.session.a.a(((Map.Entry) it.next()).getKey());
                throw null;
            }
        }
        super.zza();
    }
}
