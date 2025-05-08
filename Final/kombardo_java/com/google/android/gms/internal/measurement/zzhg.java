package com.google.android.gms.internal.measurement;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Process;
import android.os.UserManager;
import android.util.Log;
import androidx.appcompat.R$styleable;

/* loaded from: classes.dex */
public abstract class zzhg {
    private static UserManager zza;
    private static volatile boolean zzb = !zza();

    public static boolean zza() {
        return true;
    }

    public static boolean zzb(Context context) {
        return !zza() || zzc(context);
    }

    @TargetApi(R$styleable.Toolbar_titleMarginEnd)
    private static boolean zzc(Context context) {
        if (zzb) {
            return true;
        }
        synchronized (zzhg.class) {
            try {
                if (zzb) {
                    return true;
                }
                boolean zzd = zzd(context);
                if (zzd) {
                    zzb = zzd;
                }
                return zzd;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @TargetApi(R$styleable.Toolbar_titleMarginEnd)
    private static boolean zzd(Context context) {
        boolean z5;
        boolean z6 = true;
        int i5 = 1;
        while (true) {
            z5 = false;
            if (i5 > 2) {
                break;
            }
            if (zza == null) {
                zza = (UserManager) context.getSystemService(UserManager.class);
            }
            UserManager userManager = zza;
            if (userManager == null) {
                return true;
            }
            try {
                if (userManager.isUserUnlocked()) {
                    break;
                }
                if (userManager.isUserRunning(Process.myUserHandle())) {
                    z6 = false;
                }
            } catch (NullPointerException e5) {
                Log.w("DirectBootUtils", "Failed to check if user is unlocked.", e5);
                zza = null;
                i5++;
            }
        }
        z5 = z6;
        if (z5) {
            zza = null;
        }
        return z5;
    }

    public static boolean zza(Context context) {
        return zza() && !zzc(context);
    }
}
