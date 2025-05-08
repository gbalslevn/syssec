package com.google.android.gms.cloudmessaging;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.Map;

/* loaded from: classes.dex */
public final class CloudMessage extends AbstractSafeParcelable {
    public static final Parcelable.Creator<CloudMessage> CREATOR = new zza();
    final Intent zza;
    private Map zzb;

    public CloudMessage(Intent intent) {
        this.zza = intent;
    }

    public Intent getIntent() {
        return this.zza;
    }

    public String getMessageId() {
        String stringExtra = this.zza.getStringExtra("google.message_id");
        return stringExtra == null ? this.zza.getStringExtra("message_id") : stringExtra;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i5) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, this.zza, i5, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Integer zza() {
        if (this.zza.hasExtra("google.product_id")) {
            return Integer.valueOf(this.zza.getIntExtra("google.product_id", 0));
        }
        return null;
    }
}
