package androidx.core.content;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Process;
import android.text.TextUtils;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.util.ObjectsCompat;
import java.io.File;

@SuppressLint({"PrivateConstructorForUtilityClass"})
/* loaded from: classes.dex */
public abstract class ContextCompat {
    private static final String DYNAMIC_RECEIVER_NOT_EXPORTED_PERMISSION_SUFFIX = ".DYNAMIC_RECEIVER_NOT_EXPORTED_PERMISSION";
    private static final String TAG = "ContextCompat";
    private static final Object sSync = new Object();

    /* loaded from: classes.dex */
    static class Api21Impl {
        static Drawable getDrawable(Context context, int i5) {
            return context.getDrawable(i5);
        }

        static File getNoBackupFilesDir(Context context) {
            return context.getNoBackupFilesDir();
        }
    }

    /* loaded from: classes.dex */
    static class Api23Impl {
        static int getColor(Context context, int i5) {
            return context.getColor(i5);
        }

        static <T> T getSystemService(Context context, Class<T> cls) {
            return (T) context.getSystemService(cls);
        }
    }

    /* loaded from: classes.dex */
    static class Api24Impl {
        static Context createDeviceProtectedStorageContext(Context context) {
            return context.createDeviceProtectedStorageContext();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class Api26Impl {
        static Intent registerReceiver(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, String str, Handler handler, int i5) {
            return ((i5 & 4) == 0 || str != null) ? context.registerReceiver(broadcastReceiver, intentFilter, str, handler, i5 & 1) : context.registerReceiver(broadcastReceiver, intentFilter, ContextCompat.obtainAndCheckReceiverPermission(context), handler);
        }

        static ComponentName startForegroundService(Context context, Intent intent) {
            return context.startForegroundService(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class Api33Impl {
        static Intent registerReceiver(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, String str, Handler handler, int i5) {
            return context.registerReceiver(broadcastReceiver, intentFilter, str, handler, i5);
        }
    }

    public static int checkSelfPermission(Context context, String str) {
        ObjectsCompat.requireNonNull(str, "permission must be non-null");
        return (Build.VERSION.SDK_INT >= 33 || !TextUtils.equals("android.permission.POST_NOTIFICATIONS", str)) ? context.checkPermission(str, Process.myPid(), Process.myUid()) : NotificationManagerCompat.from(context).areNotificationsEnabled() ? 0 : -1;
    }

    public static Context createDeviceProtectedStorageContext(Context context) {
        return Api24Impl.createDeviceProtectedStorageContext(context);
    }

    public static int getColor(Context context, int i5) {
        return Api23Impl.getColor(context, i5);
    }

    public static ColorStateList getColorStateList(Context context, int i5) {
        return ResourcesCompat.getColorStateList(context.getResources(), i5, context.getTheme());
    }

    public static Drawable getDrawable(Context context, int i5) {
        return Api21Impl.getDrawable(context, i5);
    }

    @Deprecated
    public static File[] getExternalCacheDirs(Context context) {
        return context.getExternalCacheDirs();
    }

    @Deprecated
    public static File[] getExternalFilesDirs(Context context, String str) {
        return context.getExternalFilesDirs(str);
    }

    public static File getNoBackupFilesDir(Context context) {
        return Api21Impl.getNoBackupFilesDir(context);
    }

    public static <T> T getSystemService(Context context, Class<T> cls) {
        return (T) Api23Impl.getSystemService(context, cls);
    }

    static String obtainAndCheckReceiverPermission(Context context) {
        String str = context.getPackageName() + DYNAMIC_RECEIVER_NOT_EXPORTED_PERMISSION_SUFFIX;
        if (PermissionChecker.checkSelfPermission(context, str) == 0) {
            return str;
        }
        throw new RuntimeException("Permission " + str + " is required by your application to receive broadcasts, please add it to your manifest");
    }

    public static Intent registerReceiver(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, int i5) {
        return registerReceiver(context, broadcastReceiver, intentFilter, null, null, i5);
    }

    public static boolean startActivities(Context context, Intent[] intentArr, Bundle bundle) {
        context.startActivities(intentArr, bundle);
        return true;
    }

    @Deprecated
    public static void startActivity(Context context, Intent intent, Bundle bundle) {
        context.startActivity(intent, bundle);
    }

    public static void startForegroundService(Context context, Intent intent) {
        Api26Impl.startForegroundService(context, intent);
    }

    public static Intent registerReceiver(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, String str, Handler handler, int i5) {
        int i6 = i5 & 1;
        if (i6 != 0 && (i5 & 4) != 0) {
            throw new IllegalArgumentException("Cannot specify both RECEIVER_VISIBLE_TO_INSTANT_APPS and RECEIVER_NOT_EXPORTED");
        }
        if (i6 != 0) {
            i5 |= 2;
        }
        int i7 = i5;
        int i8 = i7 & 2;
        if (i8 == 0 && (i7 & 4) == 0) {
            throw new IllegalArgumentException("One of either RECEIVER_EXPORTED or RECEIVER_NOT_EXPORTED is required");
        }
        if (i8 != 0 && (i7 & 4) != 0) {
            throw new IllegalArgumentException("Cannot specify both RECEIVER_EXPORTED and RECEIVER_NOT_EXPORTED");
        }
        if (Build.VERSION.SDK_INT >= 33) {
            return Api33Impl.registerReceiver(context, broadcastReceiver, intentFilter, str, handler, i7);
        }
        return Api26Impl.registerReceiver(context, broadcastReceiver, intentFilter, str, handler, i7);
    }
}
