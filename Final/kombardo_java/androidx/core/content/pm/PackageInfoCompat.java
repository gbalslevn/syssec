package androidx.core.content.pm;

import android.content.pm.PackageInfo;
import android.os.Build;

/* loaded from: classes.dex */
public abstract class PackageInfoCompat {

    /* loaded from: classes.dex */
    private static class Api28Impl {
        static long getLongVersionCode(PackageInfo packageInfo) {
            return packageInfo.getLongVersionCode();
        }
    }

    public static long getLongVersionCode(PackageInfo packageInfo) {
        return Build.VERSION.SDK_INT >= 28 ? Api28Impl.getLongVersionCode(packageInfo) : packageInfo.versionCode;
    }
}
