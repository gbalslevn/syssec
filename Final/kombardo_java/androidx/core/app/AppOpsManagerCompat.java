package androidx.core.app;

import android.app.AppOpsManager;
import android.content.Context;
import android.os.Binder;
import android.os.Build;

/* loaded from: classes.dex */
public abstract class AppOpsManagerCompat {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class Api23Impl {
        static <T> T getSystemService(Context context, Class<T> cls) {
            return (T) context.getSystemService(cls);
        }

        static int noteProxyOpNoThrow(AppOpsManager appOpsManager, String str, String str2) {
            return appOpsManager.noteProxyOpNoThrow(str, str2);
        }

        static String permissionToOp(String str) {
            return AppOpsManager.permissionToOp(str);
        }
    }

    /* loaded from: classes.dex */
    static class Api29Impl {
        static int checkOpNoThrow(AppOpsManager appOpsManager, String str, int i5, String str2) {
            if (appOpsManager == null) {
                return 1;
            }
            return appOpsManager.checkOpNoThrow(str, i5, str2);
        }

        static String getOpPackageName(Context context) {
            return context.getOpPackageName();
        }

        static AppOpsManager getSystemService(Context context) {
            return (AppOpsManager) context.getSystemService(AppOpsManager.class);
        }
    }

    public static int checkOrNoteProxyOp(Context context, int i5, String str, String str2) {
        if (Build.VERSION.SDK_INT < 29) {
            return noteProxyOpNoThrow(context, str, str2);
        }
        AppOpsManager systemService = Api29Impl.getSystemService(context);
        int checkOpNoThrow = Api29Impl.checkOpNoThrow(systemService, str, Binder.getCallingUid(), str2);
        return checkOpNoThrow != 0 ? checkOpNoThrow : Api29Impl.checkOpNoThrow(systemService, str, i5, Api29Impl.getOpPackageName(context));
    }

    public static int noteProxyOpNoThrow(Context context, String str, String str2) {
        return Api23Impl.noteProxyOpNoThrow((AppOpsManager) Api23Impl.getSystemService(context, AppOpsManager.class), str, str2);
    }

    public static String permissionToOp(String str) {
        return Api23Impl.permissionToOp(str);
    }
}
