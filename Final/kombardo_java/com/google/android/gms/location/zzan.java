package com.google.android.gms.location;

import com.google.android.gms.common.internal.Preconditions;

/* loaded from: classes.dex */
public abstract class zzan {
    public static int zza(int i5) {
        boolean z5 = true;
        if (i5 != 100 && i5 != 102 && i5 != 104) {
            if (i5 == 105) {
                i5 = 105;
            } else {
                z5 = false;
            }
        }
        Preconditions.checkArgument(z5, "priority %d must be a Priority.PRIORITY_* constant", Integer.valueOf(i5));
        return i5;
    }

    public static String zzb(int i5) {
        if (i5 == 100) {
            return "HIGH_ACCURACY";
        }
        if (i5 == 102) {
            return "BALANCED_POWER_ACCURACY";
        }
        if (i5 == 104) {
            return "LOW_POWER";
        }
        if (i5 == 105) {
            return "PASSIVE";
        }
        throw new IllegalArgumentException();
    }
}
