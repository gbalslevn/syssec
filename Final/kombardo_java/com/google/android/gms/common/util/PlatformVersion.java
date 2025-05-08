package com.google.android.gms.common.util;

import android.os.Build;

/* loaded from: classes.dex */
public abstract class PlatformVersion {
    public static boolean isAtLeastIceCreamSandwich() {
        return true;
    }

    public static boolean isAtLeastKitKatWatch() {
        return true;
    }

    public static boolean isAtLeastLollipop() {
        return true;
    }

    public static boolean isAtLeastN() {
        return true;
    }

    public static boolean isAtLeastO() {
        return true;
    }

    public static boolean isAtLeastP() {
        return Build.VERSION.SDK_INT >= 28;
    }

    public static boolean isAtLeastQ() {
        return Build.VERSION.SDK_INT >= 29;
    }

    public static boolean isAtLeastR() {
        return Build.VERSION.SDK_INT >= 30;
    }

    public static boolean isAtLeastS() {
        return Build.VERSION.SDK_INT >= 31;
    }
}
