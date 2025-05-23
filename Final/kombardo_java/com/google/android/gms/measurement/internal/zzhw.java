package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.google.android.gms.common.R$string;
import com.google.android.gms.common.internal.Preconditions;

/* loaded from: classes.dex */
public final class zzhw {
    private final Resources zza;
    private final String zzb;

    public zzhw(Context context, String str) {
        Preconditions.checkNotNull(context);
        this.zza = context.getResources();
        if (TextUtils.isEmpty(str)) {
            this.zzb = zza(context);
        } else {
            this.zzb = str;
        }
    }

    public final String zza(String str) {
        int identifier = this.zza.getIdentifier(str, "string", this.zzb);
        if (identifier == 0) {
            return null;
        }
        try {
            return this.zza.getString(identifier);
        } catch (Resources.NotFoundException unused) {
            return null;
        }
    }

    public static String zza(Context context) {
        try {
            return context.getResources().getResourcePackageName(R$string.common_google_play_services_unknown_issue);
        } catch (Resources.NotFoundException unused) {
            return context.getPackageName();
        }
    }
}
