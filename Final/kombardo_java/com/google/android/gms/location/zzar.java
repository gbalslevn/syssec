package com.google.android.gms.location;

import com.google.android.gms.common.internal.Preconditions;

/* loaded from: classes.dex */
public abstract class zzar {
    public static int zza(int i5) {
        boolean z5 = true;
        if (i5 != 0 && i5 != 1) {
            if (i5 == 2) {
                i5 = 2;
            } else {
                z5 = false;
            }
        }
        Preconditions.checkArgument(z5, "throttle behavior %d must be a ThrottleBehavior.THROTTLE_* constant", Integer.valueOf(i5));
        return i5;
    }

    public static String zzb(int i5) {
        if (i5 == 0) {
            return "THROTTLE_BACKGROUND";
        }
        if (i5 == 1) {
            return "THROTTLE_ALWAYS";
        }
        if (i5 == 2) {
            return "THROTTLE_NEVER";
        }
        throw new IllegalArgumentException();
    }
}
