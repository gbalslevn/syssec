package androidx.profileinstaller;

import K.d;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.util.Log;
import androidx.profileinstaller.ProfileInstaller;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.Executor;
import org.conscrypt.BuildConfig;

/* loaded from: classes.dex */
public abstract class ProfileInstaller {
    private static final DiagnosticsCallback EMPTY_DIAGNOSTICS = new DiagnosticsCallback() { // from class: androidx.profileinstaller.ProfileInstaller.1
        @Override // androidx.profileinstaller.ProfileInstaller.DiagnosticsCallback
        public void onDiagnosticReceived(int i5, Object obj) {
        }

        @Override // androidx.profileinstaller.ProfileInstaller.DiagnosticsCallback
        public void onResultReceived(int i5, Object obj) {
        }
    };
    static final DiagnosticsCallback LOG_DIAGNOSTICS = new DiagnosticsCallback() { // from class: androidx.profileinstaller.ProfileInstaller.2
        @Override // androidx.profileinstaller.ProfileInstaller.DiagnosticsCallback
        public void onDiagnosticReceived(int i5, Object obj) {
            Log.d(ProfileInstaller.TAG, i5 != 1 ? i5 != 2 ? i5 != 3 ? i5 != 4 ? i5 != 5 ? BuildConfig.FLAVOR : "DIAGNOSTIC_PROFILE_IS_COMPRESSED" : "DIAGNOSTIC_REF_PROFILE_DOES_NOT_EXIST" : "DIAGNOSTIC_REF_PROFILE_EXISTS" : "DIAGNOSTIC_CURRENT_PROFILE_DOES_NOT_EXIST" : "DIAGNOSTIC_CURRENT_PROFILE_EXISTS");
        }

        @Override // androidx.profileinstaller.ProfileInstaller.DiagnosticsCallback
        public void onResultReceived(int i5, Object obj) {
            String str;
            switch (i5) {
                case 1:
                    str = "RESULT_INSTALL_SUCCESS";
                    break;
                case 2:
                    str = "RESULT_ALREADY_INSTALLED";
                    break;
                case 3:
                    str = "RESULT_UNSUPPORTED_ART_VERSION";
                    break;
                case 4:
                    str = "RESULT_NOT_WRITABLE";
                    break;
                case 5:
                    str = "RESULT_DESIRED_FORMAT_UNSUPPORTED";
                    break;
                case 6:
                    str = "RESULT_BASELINE_PROFILE_NOT_FOUND";
                    break;
                case 7:
                    str = "RESULT_IO_EXCEPTION";
                    break;
                case 8:
                    str = "RESULT_PARSE_EXCEPTION";
                    break;
                case 9:
                default:
                    str = BuildConfig.FLAVOR;
                    break;
                case 10:
                    str = "RESULT_INSTALL_SKIP_FILE_SUCCESS";
                    break;
                case 11:
                    str = "RESULT_DELETE_SKIP_FILE_SUCCESS";
                    break;
            }
            if (i5 == 6 || i5 == 7 || i5 == 8) {
                Log.e(ProfileInstaller.TAG, str, (Throwable) obj);
            } else {
                Log.d(ProfileInstaller.TAG, str);
            }
        }
    };
    private static final String PROFILE_BASE_DIR = "/data/misc/profiles/cur/0";
    private static final String PROFILE_FILE = "primary.prof";
    private static final String PROFILE_INSTALLER_SKIP_FILE_NAME = "profileinstaller_profileWrittenFor_lastUpdateTime.dat";
    private static final String PROFILE_META_LOCATION = "dexopt/baseline.profm";
    private static final String TAG = "ProfileInstaller";

    /* loaded from: classes.dex */
    public interface DiagnosticsCallback {
        void onDiagnosticReceived(int i5, Object obj);

        void onResultReceived(int i5, Object obj);
    }

    static boolean deleteProfileWrittenFor(File file) {
        return new File(file, PROFILE_INSTALLER_SKIP_FILE_NAME).delete();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void deleteSkipFile(Context context, Executor executor, DiagnosticsCallback diagnosticsCallback) {
        deleteProfileWrittenFor(context.getFilesDir());
        result(executor, diagnosticsCallback, 11, null);
    }

    static boolean hasAlreadyWrittenProfileForThisInstall(PackageInfo packageInfo, File file, DiagnosticsCallback diagnosticsCallback) {
        File file2 = new File(file, PROFILE_INSTALLER_SKIP_FILE_NAME);
        if (!file2.exists()) {
            return false;
        }
        try {
            DataInputStream dataInputStream = new DataInputStream(new FileInputStream(file2));
            try {
                long readLong = dataInputStream.readLong();
                dataInputStream.close();
                boolean z5 = readLong == packageInfo.lastUpdateTime;
                if (z5) {
                    diagnosticsCallback.onResultReceived(2, null);
                }
                return z5;
            } finally {
            }
        } catch (IOException unused) {
            return false;
        }
    }

    static void noteProfileWrittenFor(PackageInfo packageInfo, File file) {
        try {
            DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(new File(file, PROFILE_INSTALLER_SKIP_FILE_NAME)));
            try {
                dataOutputStream.writeLong(packageInfo.lastUpdateTime);
                dataOutputStream.close();
            } finally {
            }
        } catch (IOException unused) {
        }
    }

    static void result(Executor executor, final DiagnosticsCallback diagnosticsCallback, final int i5, final Object obj) {
        executor.execute(new Runnable() { // from class: L.b
            @Override // java.lang.Runnable
            public final void run() {
                ProfileInstaller.DiagnosticsCallback.this.onResultReceived(i5, obj);
            }
        });
    }

    private static boolean transcodeAndWrite(AssetManager assetManager, String str, PackageInfo packageInfo, File file, String str2, Executor executor, DiagnosticsCallback diagnosticsCallback) {
        DeviceProfileWriter deviceProfileWriter = new DeviceProfileWriter(assetManager, executor, diagnosticsCallback, str2, "dexopt/baseline.prof", PROFILE_META_LOCATION, new File(new File(PROFILE_BASE_DIR, str), PROFILE_FILE));
        if (!deviceProfileWriter.deviceAllowsProfileInstallerAotWrites()) {
            return false;
        }
        boolean write = deviceProfileWriter.read().transcodeIfNeeded().write();
        if (write) {
            noteProfileWrittenFor(packageInfo, file);
        }
        return write;
    }

    public static void writeProfile(Context context) {
        writeProfile(context, new d(), EMPTY_DIAGNOSTICS);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void writeSkipFile(Context context, Executor executor, DiagnosticsCallback diagnosticsCallback) {
        try {
            noteProfileWrittenFor(context.getPackageManager().getPackageInfo(context.getApplicationContext().getPackageName(), 0), context.getFilesDir());
            result(executor, diagnosticsCallback, 10, null);
        } catch (PackageManager.NameNotFoundException e5) {
            result(executor, diagnosticsCallback, 7, e5);
        }
    }

    public static void writeProfile(Context context, Executor executor, DiagnosticsCallback diagnosticsCallback) {
        writeProfile(context, executor, diagnosticsCallback, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void writeProfile(Context context, Executor executor, DiagnosticsCallback diagnosticsCallback, boolean z5) {
        Context applicationContext = context.getApplicationContext();
        String packageName = applicationContext.getPackageName();
        ApplicationInfo applicationInfo = applicationContext.getApplicationInfo();
        AssetManager assets = applicationContext.getAssets();
        String name = new File(applicationInfo.sourceDir).getName();
        boolean z6 = false;
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(packageName, 0);
            File filesDir = context.getFilesDir();
            if (!z5 && hasAlreadyWrittenProfileForThisInstall(packageInfo, filesDir, diagnosticsCallback)) {
                Log.d(TAG, "Skipping profile installation for " + context.getPackageName());
                ProfileVerifier.writeProfileVerification(context, false);
                return;
            }
            Log.d(TAG, "Installing profile for " + context.getPackageName());
            if (transcodeAndWrite(assets, packageName, packageInfo, filesDir, name, executor, diagnosticsCallback) && z5) {
                z6 = true;
            }
            ProfileVerifier.writeProfileVerification(context, z6);
        } catch (PackageManager.NameNotFoundException e5) {
            diagnosticsCallback.onResultReceived(7, e5);
            ProfileVerifier.writeProfileVerification(context, false);
        }
    }
}
