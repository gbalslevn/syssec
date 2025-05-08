package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzin;
import com.google.android.gms.internal.measurement.zzio;
import java.io.IOException;
import java.util.List;

/* loaded from: classes.dex */
public abstract class zzio<MessageType extends zzio<MessageType, BuilderType>, BuilderType extends zzin<MessageType, BuilderType>> implements zzlm {
    protected int zza = 0;

    /* JADX INFO: Access modifiers changed from: protected */
    public static <T> void zza(Iterable<T> iterable, List<? super T> list) {
        zzin.zza(iterable, list);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract int zza(zzme zzmeVar);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void zzc(int i5);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract int zzcc();

    public final byte[] zzce() {
        try {
            byte[] bArr = new byte[zzcf()];
            zzjn zzb = zzjn.zzb(bArr);
            zza(zzb);
            zzb.zzb();
            return bArr;
        } catch (IOException e5) {
            throw new RuntimeException("Serializing " + getClass().getName() + " to a byte array threw an IOException (should never happen).", e5);
        }
    }
}
