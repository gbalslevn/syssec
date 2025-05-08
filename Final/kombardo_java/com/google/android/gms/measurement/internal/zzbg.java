package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class zzbg extends AbstractSafeParcelable implements Iterable<String> {
    public static final Parcelable.Creator<zzbg> CREATOR = new zzbi();
    private final Bundle zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbg(Bundle bundle) {
        this.zza = bundle;
    }

    @Override // java.lang.Iterable
    public final Iterator<String> iterator() {
        return new zzbj(this);
    }

    public final String toString() {
        return this.zza.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i5) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeBundle(parcel, 2, zzb(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final Bundle zzb() {
        return new Bundle(this.zza);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Object zzc(String str) {
        return this.zza.get(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final String zzd(String str) {
        return this.zza.getString(str);
    }

    public final int zza() {
        return this.zza.size();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Long zzb(String str) {
        return Long.valueOf(this.zza.getLong(str));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Double zza(String str) {
        return Double.valueOf(this.zza.getDouble(str));
    }
}
