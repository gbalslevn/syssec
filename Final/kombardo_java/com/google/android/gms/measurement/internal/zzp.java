package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.List;

/* loaded from: classes.dex */
public final class zzp extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzp> CREATOR = new zzr();
    public final String zza;
    public final int zzaa;
    public final long zzab;
    public final String zzac;
    public final String zzad;
    public final long zzae;
    public final int zzaf;
    private final String zzag;
    public final String zzb;
    public final String zzc;
    public final String zzd;
    public final long zze;
    public final long zzf;
    public final String zzg;
    public final boolean zzh;
    public final boolean zzi;
    public final long zzj;
    public final String zzk;
    public final long zzl;
    public final int zzm;
    public final boolean zzn;
    public final boolean zzo;
    public final String zzp;
    public final Boolean zzq;
    public final long zzr;
    public final List<String> zzs;
    public final String zzt;
    public final String zzu;
    public final String zzv;
    public final boolean zzw;
    public final long zzx;
    public final int zzy;
    public final String zzz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzp(String str, String str2, String str3, long j5, String str4, long j6, long j7, String str5, boolean z5, boolean z6, String str6, long j8, int i5, boolean z7, boolean z8, String str7, Boolean bool, long j9, List<String> list, String str8, String str9, String str10, String str11, boolean z9, long j10, int i6, String str12, int i7, long j11, String str13, String str14, long j12, int i8) {
        Preconditions.checkNotEmpty(str);
        this.zza = str;
        this.zzb = TextUtils.isEmpty(str2) ? null : str2;
        this.zzc = str3;
        this.zzj = j5;
        this.zzd = str4;
        this.zze = j6;
        this.zzf = j7;
        this.zzg = str5;
        this.zzh = z5;
        this.zzi = z6;
        this.zzk = str6;
        this.zzl = j8;
        this.zzm = i5;
        this.zzn = z7;
        this.zzo = z8;
        this.zzp = str7;
        this.zzq = bool;
        this.zzr = j9;
        this.zzs = list;
        this.zzag = null;
        this.zzt = str9;
        this.zzu = str10;
        this.zzv = str11;
        this.zzw = z9;
        this.zzx = j10;
        this.zzy = i6;
        this.zzz = str12;
        this.zzaa = i7;
        this.zzab = j11;
        this.zzac = str13;
        this.zzad = str14;
        this.zzae = j12;
        this.zzaf = i8;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i5) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.zza, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzb, false);
        SafeParcelWriter.writeString(parcel, 4, this.zzc, false);
        SafeParcelWriter.writeString(parcel, 5, this.zzd, false);
        SafeParcelWriter.writeLong(parcel, 6, this.zze);
        SafeParcelWriter.writeLong(parcel, 7, this.zzf);
        SafeParcelWriter.writeString(parcel, 8, this.zzg, false);
        SafeParcelWriter.writeBoolean(parcel, 9, this.zzh);
        SafeParcelWriter.writeBoolean(parcel, 10, this.zzi);
        SafeParcelWriter.writeLong(parcel, 11, this.zzj);
        SafeParcelWriter.writeString(parcel, 12, this.zzk, false);
        SafeParcelWriter.writeLong(parcel, 14, this.zzl);
        SafeParcelWriter.writeInt(parcel, 15, this.zzm);
        SafeParcelWriter.writeBoolean(parcel, 16, this.zzn);
        SafeParcelWriter.writeBoolean(parcel, 18, this.zzo);
        SafeParcelWriter.writeString(parcel, 19, this.zzp, false);
        SafeParcelWriter.writeBooleanObject(parcel, 21, this.zzq, false);
        SafeParcelWriter.writeLong(parcel, 22, this.zzr);
        SafeParcelWriter.writeStringList(parcel, 23, this.zzs, false);
        SafeParcelWriter.writeString(parcel, 24, this.zzag, false);
        SafeParcelWriter.writeString(parcel, 25, this.zzt, false);
        SafeParcelWriter.writeString(parcel, 26, this.zzu, false);
        SafeParcelWriter.writeString(parcel, 27, this.zzv, false);
        SafeParcelWriter.writeBoolean(parcel, 28, this.zzw);
        SafeParcelWriter.writeLong(parcel, 29, this.zzx);
        SafeParcelWriter.writeInt(parcel, 30, this.zzy);
        SafeParcelWriter.writeString(parcel, 31, this.zzz, false);
        SafeParcelWriter.writeInt(parcel, 32, this.zzaa);
        SafeParcelWriter.writeLong(parcel, 34, this.zzab);
        SafeParcelWriter.writeString(parcel, 35, this.zzac, false);
        SafeParcelWriter.writeString(parcel, 36, this.zzad, false);
        SafeParcelWriter.writeLong(parcel, 37, this.zzae);
        SafeParcelWriter.writeInt(parcel, 38, this.zzaf);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzp(String str, String str2, String str3, String str4, long j5, long j6, String str5, boolean z5, boolean z6, long j7, String str6, long j8, int i5, boolean z7, boolean z8, String str7, Boolean bool, long j9, List<String> list, String str8, String str9, String str10, String str11, boolean z9, long j10, int i6, String str12, int i7, long j11, String str13, String str14, long j12, int i8) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = str3;
        this.zzj = j7;
        this.zzd = str4;
        this.zze = j5;
        this.zzf = j6;
        this.zzg = str5;
        this.zzh = z5;
        this.zzi = z6;
        this.zzk = str6;
        this.zzl = j8;
        this.zzm = i5;
        this.zzn = z7;
        this.zzo = z8;
        this.zzp = str7;
        this.zzq = bool;
        this.zzr = j9;
        this.zzs = list;
        this.zzag = str8;
        this.zzt = str9;
        this.zzu = str10;
        this.zzv = str11;
        this.zzw = z9;
        this.zzx = j10;
        this.zzy = i6;
        this.zzz = str12;
        this.zzaa = i7;
        this.zzab = j11;
        this.zzac = str13;
        this.zzad = str14;
        this.zzae = j12;
        this.zzaf = i8;
    }
}
