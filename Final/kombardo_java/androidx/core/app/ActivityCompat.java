package androidx.core.app;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.content.ContextCompat;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.HashSet;

/* loaded from: classes.dex */
public abstract class ActivityCompat extends ContextCompat {
    private static PermissionCompatDelegate sDelegate;

    /* loaded from: classes.dex */
    static class Api23Impl {
        static void requestPermissions(Activity activity, String[] strArr, int i5) {
            activity.requestPermissions(strArr, i5);
        }

        static boolean shouldShowRequestPermissionRationale(Activity activity, String str) {
            return activity.shouldShowRequestPermissionRationale(str);
        }
    }

    /* loaded from: classes.dex */
    static class Api31Impl {
        @SuppressLint({"BanUncheckedReflection"})
        static boolean shouldShowRequestPermissionRationale(Activity activity, String str) {
            try {
                return ((Boolean) PackageManager.class.getMethod("shouldShowRequestPermissionRationale", String.class).invoke(activity.getApplication().getPackageManager(), str)).booleanValue();
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
                return activity.shouldShowRequestPermissionRationale(str);
            }
        }
    }

    /* loaded from: classes.dex */
    static class Api32Impl {
        static boolean shouldShowRequestPermissionRationale(Activity activity, String str) {
            return activity.shouldShowRequestPermissionRationale(str);
        }
    }

    /* loaded from: classes.dex */
    public interface PermissionCompatDelegate {
    }

    /* loaded from: classes.dex */
    public interface RequestPermissionsRequestCodeValidator {
        void validateRequestPermissionsRequestCode(int i5);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void requestPermissions(Activity activity, String[] strArr, int i5) {
        HashSet hashSet = new HashSet();
        for (int i6 = 0; i6 < strArr.length; i6++) {
            if (TextUtils.isEmpty(strArr[i6])) {
                throw new IllegalArgumentException("Permission request for permissions " + Arrays.toString(strArr) + " must not contain null or empty values");
            }
            if (Build.VERSION.SDK_INT < 33 && TextUtils.equals(strArr[i6], "android.permission.POST_NOTIFICATIONS")) {
                hashSet.add(Integer.valueOf(i6));
            }
        }
        int size = hashSet.size();
        String[] strArr2 = size > 0 ? new String[strArr.length - size] : strArr;
        if (size > 0) {
            if (size == strArr.length) {
                return;
            }
            int i7 = 0;
            for (int i8 = 0; i8 < strArr.length; i8++) {
                if (!hashSet.contains(Integer.valueOf(i8))) {
                    strArr2[i7] = strArr[i8];
                    i7++;
                }
            }
        }
        if (activity instanceof RequestPermissionsRequestCodeValidator) {
            ((RequestPermissionsRequestCodeValidator) activity).validateRequestPermissionsRequestCode(i5);
        }
        Api23Impl.requestPermissions(activity, strArr, i5);
    }

    public static boolean shouldShowRequestPermissionRationale(Activity activity, String str) {
        int i5 = Build.VERSION.SDK_INT;
        if (i5 >= 33 || !TextUtils.equals("android.permission.POST_NOTIFICATIONS", str)) {
            return i5 >= 32 ? Api32Impl.shouldShowRequestPermissionRationale(activity, str) : i5 == 31 ? Api31Impl.shouldShowRequestPermissionRationale(activity, str) : Api23Impl.shouldShowRequestPermissionRationale(activity, str);
        }
        return false;
    }

    public static void startActivityForResult(Activity activity, Intent intent, int i5, Bundle bundle) {
        activity.startActivityForResult(intent, i5, bundle);
    }

    public static void startIntentSenderForResult(Activity activity, IntentSender intentSender, int i5, Intent intent, int i6, int i7, int i8, Bundle bundle) {
        activity.startIntentSenderForResult(intentSender, i5, intent, i6, i7, i8, bundle);
    }
}
