package com.google.android.gms.internal.identity;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.location.zzw;

/* loaded from: classes.dex */
public final class zzee extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzee> CREATOR = new zzef();
    private final int zza;
    private final IBinder zzb;
    private final IBinder zzc;
    private final PendingIntent zzd;
    private final String zze;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzee(int i5, IBinder iBinder, IBinder iBinder2, PendingIntent pendingIntent, String str) {
        this.zza = i5;
        this.zzb = iBinder;
        this.zzc = iBinder2;
        this.zzd = pendingIntent;
        this.zze = str;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [android.os.IBinder] */
    /* JADX WARN: Type inference failed for: r8v0, types: [com.google.android.gms.location.zzw, android.os.IBinder] */
    public static zzee zzb(IInterface iInterface, zzw zzwVar, String str) {
        if (iInterface == null) {
            iInterface = null;
        }
        return new zzee(2, iInterface, zzwVar, null, str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static zzee zzd(zzz zzzVar) {
        return new zzee(4, null, zzzVar, null, null);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i5) {
        int i6 = this.zza;
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, i6);
        SafeParcelWriter.writeIBinder(parcel, 2, this.zzb, false);
        SafeParcelWriter.writeIBinder(parcel, 3, this.zzc, false);
        SafeParcelWriter.writeParcelable(parcel, 4, this.zzd, i5, false);
        SafeParcelWriter.writeString(parcel, 6, this.zze, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
