package com.google.android.gms.common;

import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.common.internal.zzz;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class zzj extends zzz {
    private final int zza;

    /* JADX INFO: Access modifiers changed from: protected */
    public zzj(byte[] bArr) {
        Preconditions.checkArgument(bArr.length == 25);
        this.zza = Arrays.hashCode(bArr);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static byte[] zze(String str) {
        try {
            return str.getBytes("ISO-8859-1");
        } catch (UnsupportedEncodingException e5) {
            throw new AssertionError(e5);
        }
    }

    public final boolean equals(Object obj) {
        IObjectWrapper zzd;
        if (obj != null && (obj instanceof zzaa)) {
            try {
                zzaa zzaaVar = (zzaa) obj;
                if (zzaaVar.zzc() == this.zza && (zzd = zzaaVar.zzd()) != null) {
                    return Arrays.equals(zzf(), (byte[]) ObjectWrapper.unwrap(zzd));
                }
                return false;
            } catch (RemoteException e5) {
                Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e5);
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.zza;
    }

    @Override // com.google.android.gms.common.internal.zzaa
    public final int zzc() {
        return this.zza;
    }

    @Override // com.google.android.gms.common.internal.zzaa
    public final IObjectWrapper zzd() {
        return ObjectWrapper.wrap(zzf());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract byte[] zzf();
}
