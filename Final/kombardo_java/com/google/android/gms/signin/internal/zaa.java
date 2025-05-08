package com.google.android.gms.signin.internal;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* loaded from: classes.dex */
public final class zaa extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zaa> CREATOR = new zab();
    final int zaa;
    private int zab;
    private Intent zac;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zaa(int i5, int i6, Intent intent) {
        this.zaa = i5;
        this.zab = i6;
        this.zac = intent;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i5) {
        int i6 = this.zaa;
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, i6);
        SafeParcelWriter.writeInt(parcel, 2, this.zab);
        SafeParcelWriter.writeParcelable(parcel, 3, this.zac, i5, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
