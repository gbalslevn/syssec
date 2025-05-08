package com.google.android.gms.internal.measurement;

import android.app.Activity;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.Objects;

/* loaded from: classes.dex */
public final class zzeb extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzeb> CREATOR = new zzee();
    public final int zza;
    public final String zzb;
    public final Intent zzc;

    public zzeb(int i5, String str, Intent intent) {
        this.zza = i5;
        this.zzb = str;
        this.zzc = intent;
    }

    public static zzeb zza(Activity activity) {
        return new zzeb(activity.hashCode(), activity.getClass().getCanonicalName(), activity.getIntent());
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzeb)) {
            return false;
        }
        zzeb zzebVar = (zzeb) obj;
        return this.zza == zzebVar.zza && Objects.equals(this.zzb, zzebVar.zzb) && Objects.equals(this.zzc, zzebVar.zzc);
    }

    public final int hashCode() {
        return this.zza;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i5) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zza);
        SafeParcelWriter.writeString(parcel, 2, this.zzb, false);
        SafeParcelWriter.writeParcelable(parcel, 3, this.zzc, i5, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
