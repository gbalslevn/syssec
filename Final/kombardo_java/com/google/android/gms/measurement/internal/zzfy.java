package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import androidx.appcompat.R$styleable;
import java.util.List;

/* loaded from: classes.dex */
public abstract class zzfy extends com.google.android.gms.internal.measurement.zzbx implements zzfz {
    public zzfy() {
        super("com.google.android.gms.measurement.internal.IMeasurementService");
    }

    @Override // com.google.android.gms.internal.measurement.zzbx
    protected final boolean zza(int i5, Parcel parcel, Parcel parcel2, int i6) {
        zzgf zzgfVar = null;
        zzga zzgaVar = null;
        switch (i5) {
            case 1:
                zzbl zzblVar = (zzbl) com.google.android.gms.internal.measurement.zzbw.zza(parcel, zzbl.CREATOR);
                zzp zzpVar = (zzp) com.google.android.gms.internal.measurement.zzbw.zza(parcel, zzp.CREATOR);
                com.google.android.gms.internal.measurement.zzbw.zzb(parcel);
                zza(zzblVar, zzpVar);
                parcel2.writeNoException();
                return true;
            case 2:
                zzpm zzpmVar = (zzpm) com.google.android.gms.internal.measurement.zzbw.zza(parcel, zzpm.CREATOR);
                zzp zzpVar2 = (zzp) com.google.android.gms.internal.measurement.zzbw.zza(parcel, zzp.CREATOR);
                com.google.android.gms.internal.measurement.zzbw.zzb(parcel);
                zza(zzpmVar, zzpVar2);
                parcel2.writeNoException();
                return true;
            case 3:
            case 8:
            case 22:
            case R$styleable.Toolbar_titleMarginBottom /* 23 */:
            case 28:
            default:
                return false;
            case 4:
                zzp zzpVar3 = (zzp) com.google.android.gms.internal.measurement.zzbw.zza(parcel, zzp.CREATOR);
                com.google.android.gms.internal.measurement.zzbw.zzb(parcel);
                zzd(zzpVar3);
                parcel2.writeNoException();
                return true;
            case 5:
                zzbl zzblVar2 = (zzbl) com.google.android.gms.internal.measurement.zzbw.zza(parcel, zzbl.CREATOR);
                String readString = parcel.readString();
                String readString2 = parcel.readString();
                com.google.android.gms.internal.measurement.zzbw.zzb(parcel);
                zza(zzblVar2, readString, readString2);
                parcel2.writeNoException();
                return true;
            case 6:
                zzp zzpVar4 = (zzp) com.google.android.gms.internal.measurement.zzbw.zza(parcel, zzp.CREATOR);
                com.google.android.gms.internal.measurement.zzbw.zzb(parcel);
                zzh(zzpVar4);
                parcel2.writeNoException();
                return true;
            case 7:
                zzp zzpVar5 = (zzp) com.google.android.gms.internal.measurement.zzbw.zza(parcel, zzp.CREATOR);
                boolean zzc = com.google.android.gms.internal.measurement.zzbw.zzc(parcel);
                com.google.android.gms.internal.measurement.zzbw.zzb(parcel);
                List<zzpm> zza = zza(zzpVar5, zzc);
                parcel2.writeNoException();
                parcel2.writeTypedList(zza);
                return true;
            case 9:
                zzbl zzblVar3 = (zzbl) com.google.android.gms.internal.measurement.zzbw.zza(parcel, zzbl.CREATOR);
                String readString3 = parcel.readString();
                com.google.android.gms.internal.measurement.zzbw.zzb(parcel);
                byte[] zza2 = zza(zzblVar3, readString3);
                parcel2.writeNoException();
                parcel2.writeByteArray(zza2);
                return true;
            case 10:
                long readLong = parcel.readLong();
                String readString4 = parcel.readString();
                String readString5 = parcel.readString();
                String readString6 = parcel.readString();
                com.google.android.gms.internal.measurement.zzbw.zzb(parcel);
                zza(readLong, readString4, readString5, readString6);
                parcel2.writeNoException();
                return true;
            case 11:
                zzp zzpVar6 = (zzp) com.google.android.gms.internal.measurement.zzbw.zza(parcel, zzp.CREATOR);
                com.google.android.gms.internal.measurement.zzbw.zzb(parcel);
                String zzb = zzb(zzpVar6);
                parcel2.writeNoException();
                parcel2.writeString(zzb);
                return true;
            case 12:
                zzag zzagVar = (zzag) com.google.android.gms.internal.measurement.zzbw.zza(parcel, zzag.CREATOR);
                zzp zzpVar7 = (zzp) com.google.android.gms.internal.measurement.zzbw.zza(parcel, zzp.CREATOR);
                com.google.android.gms.internal.measurement.zzbw.zzb(parcel);
                zza(zzagVar, zzpVar7);
                parcel2.writeNoException();
                return true;
            case 13:
                zzag zzagVar2 = (zzag) com.google.android.gms.internal.measurement.zzbw.zza(parcel, zzag.CREATOR);
                com.google.android.gms.internal.measurement.zzbw.zzb(parcel);
                zza(zzagVar2);
                parcel2.writeNoException();
                return true;
            case 14:
                String readString7 = parcel.readString();
                String readString8 = parcel.readString();
                boolean zzc2 = com.google.android.gms.internal.measurement.zzbw.zzc(parcel);
                zzp zzpVar8 = (zzp) com.google.android.gms.internal.measurement.zzbw.zza(parcel, zzp.CREATOR);
                com.google.android.gms.internal.measurement.zzbw.zzb(parcel);
                List<zzpm> zza3 = zza(readString7, readString8, zzc2, zzpVar8);
                parcel2.writeNoException();
                parcel2.writeTypedList(zza3);
                return true;
            case 15:
                String readString9 = parcel.readString();
                String readString10 = parcel.readString();
                String readString11 = parcel.readString();
                boolean zzc3 = com.google.android.gms.internal.measurement.zzbw.zzc(parcel);
                com.google.android.gms.internal.measurement.zzbw.zzb(parcel);
                List<zzpm> zza4 = zza(readString9, readString10, readString11, zzc3);
                parcel2.writeNoException();
                parcel2.writeTypedList(zza4);
                return true;
            case 16:
                String readString12 = parcel.readString();
                String readString13 = parcel.readString();
                zzp zzpVar9 = (zzp) com.google.android.gms.internal.measurement.zzbw.zza(parcel, zzp.CREATOR);
                com.google.android.gms.internal.measurement.zzbw.zzb(parcel);
                List<zzag> zza5 = zza(readString12, readString13, zzpVar9);
                parcel2.writeNoException();
                parcel2.writeTypedList(zza5);
                return true;
            case 17:
                String readString14 = parcel.readString();
                String readString15 = parcel.readString();
                String readString16 = parcel.readString();
                com.google.android.gms.internal.measurement.zzbw.zzb(parcel);
                List<zzag> zza6 = zza(readString14, readString15, readString16);
                parcel2.writeNoException();
                parcel2.writeTypedList(zza6);
                return true;
            case 18:
                zzp zzpVar10 = (zzp) com.google.android.gms.internal.measurement.zzbw.zza(parcel, zzp.CREATOR);
                com.google.android.gms.internal.measurement.zzbw.zzb(parcel);
                zze(zzpVar10);
                parcel2.writeNoException();
                return true;
            case 19:
                Bundle bundle = (Bundle) com.google.android.gms.internal.measurement.zzbw.zza(parcel, Bundle.CREATOR);
                zzp zzpVar11 = (zzp) com.google.android.gms.internal.measurement.zzbw.zza(parcel, zzp.CREATOR);
                com.google.android.gms.internal.measurement.zzbw.zzb(parcel);
                zza(bundle, zzpVar11);
                parcel2.writeNoException();
                return true;
            case 20:
                zzp zzpVar12 = (zzp) com.google.android.gms.internal.measurement.zzbw.zza(parcel, zzp.CREATOR);
                com.google.android.gms.internal.measurement.zzbw.zzb(parcel);
                zzf(zzpVar12);
                parcel2.writeNoException();
                return true;
            case 21:
                zzp zzpVar13 = (zzp) com.google.android.gms.internal.measurement.zzbw.zza(parcel, zzp.CREATOR);
                com.google.android.gms.internal.measurement.zzbw.zzb(parcel);
                zzap zza7 = zza(zzpVar13);
                parcel2.writeNoException();
                com.google.android.gms.internal.measurement.zzbw.zzb(parcel2, zza7);
                return true;
            case R$styleable.Toolbar_titleMarginEnd /* 24 */:
                zzp zzpVar14 = (zzp) com.google.android.gms.internal.measurement.zzbw.zza(parcel, zzp.CREATOR);
                Bundle bundle2 = (Bundle) com.google.android.gms.internal.measurement.zzbw.zza(parcel, Bundle.CREATOR);
                com.google.android.gms.internal.measurement.zzbw.zzb(parcel);
                List<zzog> zza8 = zza(zzpVar14, bundle2);
                parcel2.writeNoException();
                parcel2.writeTypedList(zza8);
                return true;
            case 25:
                zzp zzpVar15 = (zzp) com.google.android.gms.internal.measurement.zzbw.zza(parcel, zzp.CREATOR);
                com.google.android.gms.internal.measurement.zzbw.zzb(parcel);
                zzi(zzpVar15);
                parcel2.writeNoException();
                return true;
            case 26:
                zzp zzpVar16 = (zzp) com.google.android.gms.internal.measurement.zzbw.zza(parcel, zzp.CREATOR);
                com.google.android.gms.internal.measurement.zzbw.zzb(parcel);
                zzg(zzpVar16);
                parcel2.writeNoException();
                return true;
            case 27:
                zzp zzpVar17 = (zzp) com.google.android.gms.internal.measurement.zzbw.zza(parcel, zzp.CREATOR);
                com.google.android.gms.internal.measurement.zzbw.zzb(parcel);
                zzc(zzpVar17);
                parcel2.writeNoException();
                return true;
            case R$styleable.Toolbar_titleTextColor /* 29 */:
                zzp zzpVar18 = (zzp) com.google.android.gms.internal.measurement.zzbw.zza(parcel, zzp.CREATOR);
                zzop zzopVar = (zzop) com.google.android.gms.internal.measurement.zzbw.zza(parcel, zzop.CREATOR);
                IBinder readStrongBinder = parcel.readStrongBinder();
                if (readStrongBinder != null) {
                    IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.measurement.internal.IUploadBatchesCallback");
                    zzgfVar = queryLocalInterface instanceof zzgf ? (zzgf) queryLocalInterface : new zzgh(readStrongBinder);
                }
                com.google.android.gms.internal.measurement.zzbw.zzb(parcel);
                zza(zzpVar18, zzopVar, zzgfVar);
                parcel2.writeNoException();
                return true;
            case 30:
                zzp zzpVar19 = (zzp) com.google.android.gms.internal.measurement.zzbw.zza(parcel, zzp.CREATOR);
                zzae zzaeVar = (zzae) com.google.android.gms.internal.measurement.zzbw.zza(parcel, zzae.CREATOR);
                com.google.android.gms.internal.measurement.zzbw.zzb(parcel);
                zza(zzpVar19, zzaeVar);
                parcel2.writeNoException();
                return true;
            case 31:
                zzp zzpVar20 = (zzp) com.google.android.gms.internal.measurement.zzbw.zza(parcel, zzp.CREATOR);
                Bundle bundle3 = (Bundle) com.google.android.gms.internal.measurement.zzbw.zza(parcel, Bundle.CREATOR);
                IBinder readStrongBinder2 = parcel.readStrongBinder();
                if (readStrongBinder2 != null) {
                    IInterface queryLocalInterface2 = readStrongBinder2.queryLocalInterface("com.google.android.gms.measurement.internal.ITriggerUrisCallback");
                    zzgaVar = queryLocalInterface2 instanceof zzga ? (zzga) queryLocalInterface2 : new zzgc(readStrongBinder2);
                }
                com.google.android.gms.internal.measurement.zzbw.zzb(parcel);
                zza(zzpVar20, bundle3, zzgaVar);
                parcel2.writeNoException();
                return true;
        }
    }
}
