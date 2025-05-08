package com.google.firebase.crashlytics.internal.common;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.google.firebase.crashlytics.internal.Logger;

/* loaded from: classes2.dex */
class BatteryState {
    private final Float level;
    private final boolean powerConnected;

    private BatteryState(Float f5, boolean z5) {
        this.powerConnected = z5;
        this.level = f5;
    }

    public static BatteryState get(Context context) {
        boolean z5 = false;
        Float f5 = null;
        try {
            Intent registerReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
            if (registerReceiver != null) {
                z5 = isPowerConnected(registerReceiver);
                f5 = getLevel(registerReceiver);
            }
        } catch (IllegalStateException e5) {
            Logger.getLogger().e("An error occurred getting battery state.", e5);
        }
        return new BatteryState(f5, z5);
    }

    private static Float getLevel(Intent intent) {
        int intExtra = intent.getIntExtra("level", -1);
        int intExtra2 = intent.getIntExtra("scale", -1);
        if (intExtra == -1 || intExtra2 == -1) {
            return null;
        }
        return Float.valueOf(intExtra / intExtra2);
    }

    private static boolean isPowerConnected(Intent intent) {
        int intExtra = intent.getIntExtra("status", -1);
        if (intExtra == -1) {
            return false;
        }
        return intExtra == 2 || intExtra == 5;
    }

    public Float getBatteryLevel() {
        return this.level;
    }

    public int getBatteryVelocity() {
        Float f5;
        if (!this.powerConnected || (f5 = this.level) == null) {
            return 1;
        }
        return ((double) f5.floatValue()) < 0.99d ? 2 : 3;
    }
}
