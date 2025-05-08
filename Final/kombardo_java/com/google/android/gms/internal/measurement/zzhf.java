package com.google.android.gms.internal.measurement;

import android.content.Context;
import com.google.common.base.Optional;
import com.google.common.base.Supplier;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzhf extends zzie {
    private final Context zza;
    private final Supplier<Optional<zzhr>> zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzhf(Context context, Supplier<Optional<zzhr>> supplier) {
        if (context == null) {
            throw new NullPointerException("Null context");
        }
        this.zza = context;
        this.zzb = supplier;
    }

    public final boolean equals(Object obj) {
        Supplier<Optional<zzhr>> supplier;
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzie) {
            zzie zzieVar = (zzie) obj;
            if (this.zza.equals(zzieVar.zza()) && ((supplier = this.zzb) != null ? supplier.equals(zzieVar.zzb()) : zzieVar.zzb() == null)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = (this.zza.hashCode() ^ 1000003) * 1000003;
        Supplier<Optional<zzhr>> supplier = this.zzb;
        return hashCode ^ (supplier == null ? 0 : supplier.hashCode());
    }

    public final String toString() {
        return "FlagsContext{context=" + String.valueOf(this.zza) + ", hermeticFileOverrides=" + String.valueOf(this.zzb) + "}";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zzie
    public final Context zza() {
        return this.zza;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zzie
    public final Supplier<Optional<zzhr>> zzb() {
        return this.zzb;
    }
}
