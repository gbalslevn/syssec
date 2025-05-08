package com.google.android.gms.internal.measurement;

import java.net.URL;
import java.net.URLConnection;

/* loaded from: classes.dex */
final class zzcz extends zzda {
    @Override // com.google.android.gms.internal.measurement.zzda
    public final URLConnection zza(URL url, String str) {
        return url.openConnection();
    }

    private zzcz() {
    }
}
