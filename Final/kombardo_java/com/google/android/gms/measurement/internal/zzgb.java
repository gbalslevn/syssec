package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class zzgb extends com.google.android.gms.internal.measurement.zzbu implements zzfz {
    /* JADX INFO: Access modifiers changed from: package-private */
    public zzgb(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.measurement.internal.IMeasurementService");
    }

    @Override // com.google.android.gms.measurement.internal.zzfz
    public final zzap zza(zzp zzpVar) {
        Parcel b_ = b_();
        com.google.android.gms.internal.measurement.zzbw.zza(b_, zzpVar);
        Parcel zza = zza(21, b_);
        zzap zzapVar = (zzap) com.google.android.gms.internal.measurement.zzbw.zza(zza, zzap.CREATOR);
        zza.recycle();
        return zzapVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzfz
    public final String zzb(zzp zzpVar) {
        Parcel b_ = b_();
        com.google.android.gms.internal.measurement.zzbw.zza(b_, zzpVar);
        Parcel zza = zza(11, b_);
        String readString = zza.readString();
        zza.recycle();
        return readString;
    }

    @Override // com.google.android.gms.measurement.internal.zzfz
    public final void zzc(zzp zzpVar) {
        Parcel b_ = b_();
        com.google.android.gms.internal.measurement.zzbw.zza(b_, zzpVar);
        zzb(27, b_);
    }

    @Override // com.google.android.gms.measurement.internal.zzfz
    public final void zzd(zzp zzpVar) {
        Parcel b_ = b_();
        com.google.android.gms.internal.measurement.zzbw.zza(b_, zzpVar);
        zzb(4, b_);
    }

    @Override // com.google.android.gms.measurement.internal.zzfz
    public final void zze(zzp zzpVar) {
        Parcel b_ = b_();
        com.google.android.gms.internal.measurement.zzbw.zza(b_, zzpVar);
        zzb(18, b_);
    }

    @Override // com.google.android.gms.measurement.internal.zzfz
    public final void zzf(zzp zzpVar) {
        Parcel b_ = b_();
        com.google.android.gms.internal.measurement.zzbw.zza(b_, zzpVar);
        zzb(20, b_);
    }

    @Override // com.google.android.gms.measurement.internal.zzfz
    public final void zzg(zzp zzpVar) {
        Parcel b_ = b_();
        com.google.android.gms.internal.measurement.zzbw.zza(b_, zzpVar);
        zzb(26, b_);
    }

    @Override // com.google.android.gms.measurement.internal.zzfz
    public final void zzh(zzp zzpVar) {
        Parcel b_ = b_();
        com.google.android.gms.internal.measurement.zzbw.zza(b_, zzpVar);
        zzb(6, b_);
    }

    @Override // com.google.android.gms.measurement.internal.zzfz
    public final void zzi(zzp zzpVar) {
        Parcel b_ = b_();
        com.google.android.gms.internal.measurement.zzbw.zza(b_, zzpVar);
        zzb(25, b_);
    }

    @Override // com.google.android.gms.measurement.internal.zzfz
    public final List<zzog> zza(zzp zzpVar, Bundle bundle) {
        Parcel b_ = b_();
        com.google.android.gms.internal.measurement.zzbw.zza(b_, zzpVar);
        com.google.android.gms.internal.measurement.zzbw.zza(b_, bundle);
        Parcel zza = zza(24, b_);
        ArrayList createTypedArrayList = zza.createTypedArrayList(zzog.CREATOR);
        zza.recycle();
        return createTypedArrayList;
    }

    @Override // com.google.android.gms.measurement.internal.zzfz
    public final List<zzag> zza(String str, String str2, zzp zzpVar) {
        Parcel b_ = b_();
        b_.writeString(str);
        b_.writeString(str2);
        com.google.android.gms.internal.measurement.zzbw.zza(b_, zzpVar);
        Parcel zza = zza(16, b_);
        ArrayList createTypedArrayList = zza.createTypedArrayList(zzag.CREATOR);
        zza.recycle();
        return createTypedArrayList;
    }

    @Override // com.google.android.gms.measurement.internal.zzfz
    public final List<zzag> zza(String str, String str2, String str3) {
        Parcel b_ = b_();
        b_.writeString(str);
        b_.writeString(str2);
        b_.writeString(str3);
        Parcel zza = zza(17, b_);
        ArrayList createTypedArrayList = zza.createTypedArrayList(zzag.CREATOR);
        zza.recycle();
        return createTypedArrayList;
    }

    @Override // com.google.android.gms.measurement.internal.zzfz
    public final List<zzpm> zza(String str, String str2, boolean z5, zzp zzpVar) {
        Parcel b_ = b_();
        b_.writeString(str);
        b_.writeString(str2);
        com.google.android.gms.internal.measurement.zzbw.zza(b_, z5);
        com.google.android.gms.internal.measurement.zzbw.zza(b_, zzpVar);
        Parcel zza = zza(14, b_);
        ArrayList createTypedArrayList = zza.createTypedArrayList(zzpm.CREATOR);
        zza.recycle();
        return createTypedArrayList;
    }

    @Override // com.google.android.gms.measurement.internal.zzfz
    public final List<zzpm> zza(String str, String str2, String str3, boolean z5) {
        Parcel b_ = b_();
        b_.writeString(str);
        b_.writeString(str2);
        b_.writeString(str3);
        com.google.android.gms.internal.measurement.zzbw.zza(b_, z5);
        Parcel zza = zza(15, b_);
        ArrayList createTypedArrayList = zza.createTypedArrayList(zzpm.CREATOR);
        zza.recycle();
        return createTypedArrayList;
    }

    @Override // com.google.android.gms.measurement.internal.zzfz
    public final void zza(zzp zzpVar, zzop zzopVar, zzgf zzgfVar) {
        Parcel b_ = b_();
        com.google.android.gms.internal.measurement.zzbw.zza(b_, zzpVar);
        com.google.android.gms.internal.measurement.zzbw.zza(b_, zzopVar);
        com.google.android.gms.internal.measurement.zzbw.zza(b_, zzgfVar);
        zzb(29, b_);
    }

    @Override // com.google.android.gms.measurement.internal.zzfz
    public final void zza(zzbl zzblVar, zzp zzpVar) {
        Parcel b_ = b_();
        com.google.android.gms.internal.measurement.zzbw.zza(b_, zzblVar);
        com.google.android.gms.internal.measurement.zzbw.zza(b_, zzpVar);
        zzb(1, b_);
    }

    @Override // com.google.android.gms.measurement.internal.zzfz
    public final void zza(zzbl zzblVar, String str, String str2) {
        Parcel b_ = b_();
        com.google.android.gms.internal.measurement.zzbw.zza(b_, zzblVar);
        b_.writeString(str);
        b_.writeString(str2);
        zzb(5, b_);
    }

    @Override // com.google.android.gms.measurement.internal.zzfz
    public final void zza(zzp zzpVar, Bundle bundle, zzga zzgaVar) {
        Parcel b_ = b_();
        com.google.android.gms.internal.measurement.zzbw.zza(b_, zzpVar);
        com.google.android.gms.internal.measurement.zzbw.zza(b_, bundle);
        com.google.android.gms.internal.measurement.zzbw.zza(b_, zzgaVar);
        zzb(31, b_);
    }

    @Override // com.google.android.gms.measurement.internal.zzfz
    public final void zza(zzag zzagVar, zzp zzpVar) {
        Parcel b_ = b_();
        com.google.android.gms.internal.measurement.zzbw.zza(b_, zzagVar);
        com.google.android.gms.internal.measurement.zzbw.zza(b_, zzpVar);
        zzb(12, b_);
    }

    @Override // com.google.android.gms.measurement.internal.zzfz
    public final void zza(zzag zzagVar) {
        Parcel b_ = b_();
        com.google.android.gms.internal.measurement.zzbw.zza(b_, zzagVar);
        zzb(13, b_);
    }

    @Override // com.google.android.gms.measurement.internal.zzfz
    public final void zza(long j5, String str, String str2, String str3) {
        Parcel b_ = b_();
        b_.writeLong(j5);
        b_.writeString(str);
        b_.writeString(str2);
        b_.writeString(str3);
        zzb(10, b_);
    }

    @Override // com.google.android.gms.measurement.internal.zzfz
    public final void zza(Bundle bundle, zzp zzpVar) {
        Parcel b_ = b_();
        com.google.android.gms.internal.measurement.zzbw.zza(b_, bundle);
        com.google.android.gms.internal.measurement.zzbw.zza(b_, zzpVar);
        zzb(19, b_);
    }

    @Override // com.google.android.gms.measurement.internal.zzfz
    public final void zza(zzpm zzpmVar, zzp zzpVar) {
        Parcel b_ = b_();
        com.google.android.gms.internal.measurement.zzbw.zza(b_, zzpmVar);
        com.google.android.gms.internal.measurement.zzbw.zza(b_, zzpVar);
        zzb(2, b_);
    }

    @Override // com.google.android.gms.measurement.internal.zzfz
    public final void zza(zzp zzpVar, zzae zzaeVar) {
        Parcel b_ = b_();
        com.google.android.gms.internal.measurement.zzbw.zza(b_, zzpVar);
        com.google.android.gms.internal.measurement.zzbw.zza(b_, zzaeVar);
        zzb(30, b_);
    }

    @Override // com.google.android.gms.measurement.internal.zzfz
    public final byte[] zza(zzbl zzblVar, String str) {
        Parcel b_ = b_();
        com.google.android.gms.internal.measurement.zzbw.zza(b_, zzblVar);
        b_.writeString(str);
        Parcel zza = zza(9, b_);
        byte[] createByteArray = zza.createByteArray();
        zza.recycle();
        return createByteArray;
    }
}
