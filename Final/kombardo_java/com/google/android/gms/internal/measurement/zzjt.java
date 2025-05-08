package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzkg;
import java.util.Collections;
import java.util.Map;

/* loaded from: classes.dex */
public class zzjt {
    static final zzjt zza = new zzjt(true);
    private static volatile boolean zzb = false;
    private static volatile zzjt zzc;
    private final Map<zza, zzkg.zzd<?, ?>> zzd = Collections.emptyMap();

    /* loaded from: classes.dex */
    private static final class zza {
        private final Object zza;
        private final int zzb;

        zza(Object obj, int i5) {
            this.zza = obj;
            this.zzb = i5;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof zza)) {
                return false;
            }
            zza zzaVar = (zza) obj;
            return this.zza == zzaVar.zza && this.zzb == zzaVar.zzb;
        }

        public final int hashCode() {
            return (System.identityHashCode(this.zza) * 65535) + this.zzb;
        }
    }

    private zzjt(boolean z5) {
    }

    public static zzjt zza() {
        zzjt zzjtVar = zzc;
        if (zzjtVar != null) {
            return zzjtVar;
        }
        synchronized (zzjt.class) {
            try {
                zzjt zzjtVar2 = zzc;
                if (zzjtVar2 != null) {
                    return zzjtVar2;
                }
                zzjt zza2 = zzkf.zza(zzjt.class);
                zzc = zza2;
                return zza2;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final <ContainingType extends zzlm> zzkg.zzd<ContainingType, ?> zza(ContainingType containingtype, int i5) {
        android.support.v4.media.session.a.a(this.zzd.get(new zza(containingtype, i5)));
        return null;
    }
}
