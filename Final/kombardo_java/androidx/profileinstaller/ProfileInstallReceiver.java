package androidx.profileinstaller;

import K.d;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Process;
import androidx.profileinstaller.ProfileInstaller;

/* loaded from: classes.dex */
public class ProfileInstallReceiver extends BroadcastReceiver {
    private static final String EXTRA_BENCHMARK_OPERATION = "EXTRA_BENCHMARK_OPERATION";
    private static final String EXTRA_BENCHMARK_OPERATION_DROP_SHADER_CACHE = "DROP_SHADER_CACHE";
    private static final String EXTRA_SKIP_FILE_OPERATION = "EXTRA_SKIP_FILE_OPERATION";
    private static final String EXTRA_SKIP_FILE_OPERATION_DELETE = "DELETE_SKIP_FILE";
    private static final String EXTRA_SKIP_FILE_OPERATION_WRITE = "WRITE_SKIP_FILE";

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class ResultDiagnostics implements ProfileInstaller.DiagnosticsCallback {
        ResultDiagnostics() {
        }

        @Override // androidx.profileinstaller.ProfileInstaller.DiagnosticsCallback
        public void onDiagnosticReceived(int i5, Object obj) {
            ProfileInstaller.LOG_DIAGNOSTICS.onDiagnosticReceived(i5, obj);
        }

        @Override // androidx.profileinstaller.ProfileInstaller.DiagnosticsCallback
        public void onResultReceived(int i5, Object obj) {
            ProfileInstaller.LOG_DIAGNOSTICS.onResultReceived(i5, obj);
            ProfileInstallReceiver.this.setResultCode(i5);
        }
    }

    static void saveProfile(ProfileInstaller.DiagnosticsCallback diagnosticsCallback) {
        Process.sendSignal(Process.myPid(), 10);
        diagnosticsCallback.onResultReceived(12, null);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Bundle extras;
        if (intent == null) {
            return;
        }
        String action = intent.getAction();
        if ("androidx.profileinstaller.action.INSTALL_PROFILE".equals(action)) {
            ProfileInstaller.writeProfile(context, new d(), new ResultDiagnostics(), true);
            return;
        }
        if ("androidx.profileinstaller.action.SKIP_FILE".equals(action)) {
            Bundle extras2 = intent.getExtras();
            if (extras2 != null) {
                String string = extras2.getString(EXTRA_SKIP_FILE_OPERATION);
                if (EXTRA_SKIP_FILE_OPERATION_WRITE.equals(string)) {
                    ProfileInstaller.writeSkipFile(context, new d(), new ResultDiagnostics());
                    return;
                } else {
                    if (EXTRA_SKIP_FILE_OPERATION_DELETE.equals(string)) {
                        ProfileInstaller.deleteSkipFile(context, new d(), new ResultDiagnostics());
                        return;
                    }
                    return;
                }
            }
            return;
        }
        if ("androidx.profileinstaller.action.SAVE_PROFILE".equals(action)) {
            saveProfile(new ResultDiagnostics());
            return;
        }
        if (!"androidx.profileinstaller.action.BENCHMARK_OPERATION".equals(action) || (extras = intent.getExtras()) == null) {
            return;
        }
        String string2 = extras.getString(EXTRA_BENCHMARK_OPERATION);
        ResultDiagnostics resultDiagnostics = new ResultDiagnostics();
        if (EXTRA_BENCHMARK_OPERATION_DROP_SHADER_CACHE.equals(string2)) {
            BenchmarkOperation.dropShaderCache(context, resultDiagnostics);
        } else {
            resultDiagnostics.onResultReceived(16, null);
        }
    }
}
