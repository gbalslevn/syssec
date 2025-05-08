package com.google.android.gms.ads.identifier;

import android.util.Log;
import com.google.android.gms.internal.ads_identifier.zzh;
import com.google.android.gms.internal.ads_identifier.zzk;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/* loaded from: classes.dex */
public abstract class zze {
    public static final void zza(String str) {
        try {
            try {
                zzk.zzb(263);
                URL url = new URL(str);
                int i5 = zzh.f4347a;
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                try {
                    int responseCode = httpURLConnection.getResponseCode();
                    if (responseCode < 200 || responseCode >= 300) {
                        Log.w("HttpUrlPinger", "Received non-success response code " + responseCode + " from pinging URL: " + str);
                    }
                    zzk.zza();
                } finally {
                    httpURLConnection.disconnect();
                }
            } catch (Throwable th) {
                zzk.zza();
                throw th;
            }
        } catch (IOException e5) {
            e = e5;
            Log.w("HttpUrlPinger", "Error while pinging URL: " + str + ". " + e.getMessage(), e);
            zzk.zza();
        } catch (IndexOutOfBoundsException e6) {
            Log.w("HttpUrlPinger", "Error while parsing ping URL: " + str + ". " + e6.getMessage(), e6);
            zzk.zza();
        } catch (RuntimeException e7) {
            e = e7;
            Log.w("HttpUrlPinger", "Error while pinging URL: " + str + ". " + e.getMessage(), e);
            zzk.zza();
        }
    }
}
