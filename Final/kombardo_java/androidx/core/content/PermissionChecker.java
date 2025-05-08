package androidx.core.content;

import android.content.Context;
import android.os.Process;
import androidx.core.app.AppOpsManagerCompat;
import androidx.core.util.ObjectsCompat;

/* loaded from: classes.dex */
public abstract class PermissionChecker {
    public static int checkPermission(Context context, String str, int i5, int i6, String str2) {
        if (context.checkPermission(str, i5, i6) == -1) {
            return -1;
        }
        String permissionToOp = AppOpsManagerCompat.permissionToOp(str);
        if (permissionToOp == null) {
            return 0;
        }
        if (str2 == null) {
            String[] packagesForUid = context.getPackageManager().getPackagesForUid(i6);
            if (packagesForUid == null || packagesForUid.length <= 0) {
                return -1;
            }
            str2 = packagesForUid[0];
        }
        return ((Process.myUid() != i6 || !ObjectsCompat.equals(context.getPackageName(), str2)) ? AppOpsManagerCompat.noteProxyOpNoThrow(context, permissionToOp, str2) : AppOpsManagerCompat.checkOrNoteProxyOp(context, i6, permissionToOp, str2)) == 0 ? 0 : -2;
    }

    public static int checkSelfPermission(Context context, String str) {
        return checkPermission(context, str, Process.myPid(), Process.myUid(), context.getPackageName());
    }
}
