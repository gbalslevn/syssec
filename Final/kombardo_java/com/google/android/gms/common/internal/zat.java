package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* loaded from: classes.dex */
public final class zat extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zat> CREATOR = new zau();
    final int zaa;
    private final Account zab;
    private final int zac;
    private final GoogleSignInAccount zad;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zat(int i5, Account account, int i6, GoogleSignInAccount googleSignInAccount) {
        this.zaa = i5;
        this.zab = account;
        this.zac = i6;
        this.zad = googleSignInAccount;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i5) {
        int i6 = this.zaa;
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, i6);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zab, i5, false);
        SafeParcelWriter.writeInt(parcel, 3, this.zac);
        SafeParcelWriter.writeParcelable(parcel, 4, this.zad, i5, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public zat(Account account, int i5, GoogleSignInAccount googleSignInAccount) {
        this(2, account, i5, googleSignInAccount);
    }
}
