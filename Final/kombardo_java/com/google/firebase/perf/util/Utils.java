package com.google.firebase.perf.util;

import android.content.Context;
import android.content.pm.PackageManager;
import com.google.firebase.perf.logging.AndroidLogger;
import okhttp3.HttpUrl;
import org.conscrypt.BuildConfig;

/* loaded from: classes2.dex */
public abstract class Utils {
    private static Boolean isDebugLoggingEnabled;

    public static void checkArgument(boolean z5, String str) {
        if (!z5) {
            throw new IllegalArgumentException(str);
        }
    }

    public static boolean isDebugLoggingEnabled(Context context) {
        Boolean bool = isDebugLoggingEnabled;
        if (bool != null) {
            return bool.booleanValue();
        }
        try {
            Boolean valueOf = Boolean.valueOf(context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.getBoolean("firebase_performance_logcat_enabled", false));
            isDebugLoggingEnabled = valueOf;
            return valueOf.booleanValue();
        } catch (PackageManager.NameNotFoundException | NullPointerException e5) {
            AndroidLogger.getInstance().debug("No perf logcat meta data found " + e5.getMessage());
            return false;
        }
    }

    public static int saturatedIntCast(long j5) {
        if (j5 > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        if (j5 < -2147483648L) {
            return Integer.MIN_VALUE;
        }
        return (int) j5;
    }

    public static String stripSensitiveInfo(String str) {
        HttpUrl parse = HttpUrl.parse(str);
        return parse != null ? parse.newBuilder().username(BuildConfig.FLAVOR).password(BuildConfig.FLAVOR).query(null).fragment(null).toString() : str;
    }

    public static String truncateURL(String str, int i5) {
        HttpUrl parse;
        int lastIndexOf;
        if (str.length() <= i5) {
            return str;
        }
        if (str.charAt(i5) != '/' && (parse = HttpUrl.parse(str)) != null) {
            return (parse.encodedPath().lastIndexOf(47) < 0 || (lastIndexOf = str.lastIndexOf(47, i5 + (-1))) < 0) ? str.substring(0, i5) : str.substring(0, lastIndexOf);
        }
        return str.substring(0, i5);
    }
}
