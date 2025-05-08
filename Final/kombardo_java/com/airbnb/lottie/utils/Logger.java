package com.airbnb.lottie.utils;

import com.airbnb.lottie.LottieLogger;

/* loaded from: classes.dex */
public abstract class Logger {
    private static LottieLogger INSTANCE = new LogcatLogger();

    public static void error(String str, Throwable th) {
        INSTANCE.error(str, th);
    }

    public static void warning(String str) {
        INSTANCE.warning(str);
    }

    public static void warning(String str, Throwable th) {
        INSTANCE.warning(str, th);
    }
}
