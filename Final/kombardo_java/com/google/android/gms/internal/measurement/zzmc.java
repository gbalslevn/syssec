package com.google.android.gms.internal.measurement;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class zzmc implements zzlk {
    private final zzlm zza;
    private final String zzb;
    private final Object[] zzc;
    private final int zzd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzmc(zzlm zzlmVar, String str, Object[] objArr) {
        this.zza = zzlmVar;
        this.zzb = str;
        this.zzc = objArr;
        char charAt = str.charAt(0);
        if (charAt < 55296) {
            this.zzd = charAt;
            return;
        }
        int i5 = charAt & 8191;
        int i6 = 13;
        int i7 = 1;
        while (true) {
            int i8 = i7 + 1;
            char charAt2 = str.charAt(i7);
            if (charAt2 < 55296) {
                this.zzd = i5 | (charAt2 << i6);
                return;
            } else {
                i5 |= (charAt2 & 8191) << i6;
                i6 += 13;
                i7 = i8;
            }
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzlk
    public final zzlm zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.measurement.zzlk
    public final zzmb zzb() {
        int i5 = this.zzd;
        return (i5 & 1) != 0 ? zzmb.PROTO2 : (i5 & 4) == 4 ? zzmb.EDITIONS : zzmb.PROTO3;
    }

    @Override // com.google.android.gms.internal.measurement.zzlk
    public final boolean zzc() {
        return (this.zzd & 2) == 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String zzd() {
        return this.zzb;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Object[] zze() {
        return this.zzc;
    }
}
