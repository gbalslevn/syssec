package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class zzop extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzop> CREATOR = new zzoo();
    public final List<Integer> zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzop(List<Integer> list) {
        this.zza = list;
    }

    public static zzop zza(zzlu... zzluVarArr) {
        ArrayList arrayList = new ArrayList(zzluVarArr.length);
        for (zzlu zzluVar : zzluVarArr) {
            arrayList.add(Integer.valueOf(zzluVar.zza()));
        }
        return new zzop(arrayList);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i5) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeIntegerList(parcel, 1, this.zza, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
