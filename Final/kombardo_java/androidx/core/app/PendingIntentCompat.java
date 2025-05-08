package androidx.core.app;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;

/* loaded from: classes.dex */
public abstract class PendingIntentCompat {
    private static int addMutabilityFlags(boolean z5, int i5) {
        int i6;
        if (!z5) {
            i6 = 67108864;
        } else {
            if (Build.VERSION.SDK_INT < 31) {
                return i5;
            }
            i6 = 33554432;
        }
        return i5 | i6;
    }

    public static PendingIntent getActivity(Context context, int i5, Intent intent, int i6, boolean z5) {
        return PendingIntent.getActivity(context, i5, intent, addMutabilityFlags(z5, i6));
    }
}
