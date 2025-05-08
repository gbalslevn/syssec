package androidx.profileinstaller;

import android.content.Context;
import android.os.Build;
import androidx.profileinstaller.ProfileInstallReceiver;
import java.io.File;

/* loaded from: classes.dex */
abstract class BenchmarkOperation {

    /* loaded from: classes.dex */
    private static class Api21ContextHelper {
        static File getCodeCacheDir(Context context) {
            return context.getCodeCacheDir();
        }
    }

    /* loaded from: classes.dex */
    private static class Api24ContextHelper {
        static Context createDeviceProtectedStorageContext(Context context) {
            return context.createDeviceProtectedStorageContext();
        }
    }

    static boolean deleteFilesRecursively(File file) {
        if (!file.isDirectory()) {
            file.delete();
            return true;
        }
        File[] listFiles = file.listFiles();
        if (listFiles == null) {
            return false;
        }
        boolean z5 = true;
        for (File file2 : listFiles) {
            z5 = deleteFilesRecursively(file2) && z5;
        }
        return z5;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void dropShaderCache(Context context, ProfileInstallReceiver.ResultDiagnostics resultDiagnostics) {
        if (deleteFilesRecursively(Build.VERSION.SDK_INT >= 34 ? Api24ContextHelper.createDeviceProtectedStorageContext(context).getCacheDir() : Api21ContextHelper.getCodeCacheDir(Api24ContextHelper.createDeviceProtectedStorageContext(context)))) {
            resultDiagnostics.onResultReceived(14, null);
        } else {
            resultDiagnostics.onResultReceived(15, null);
        }
    }
}
