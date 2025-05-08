package com.google.firebase.sessions;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import com.google.android.gms.common.util.ProcessUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J.\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u000bH\u0002J\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000fJ\r\u0010\u0011\u001a\u00020\u0006H\u0000¢\u0006\u0002\b\u0012¨\u0006\u0013"}, d2 = {"Lcom/google/firebase/sessions/ProcessDetailsProvider;", BuildConfig.FLAVOR, "()V", "buildProcessDetails", "Lcom/google/firebase/sessions/ProcessDetails;", "processName", BuildConfig.FLAVOR, "pid", BuildConfig.FLAVOR, "importance", "isDefaultProcess", BuildConfig.FLAVOR, "getAppProcessDetails", BuildConfig.FLAVOR, "context", "Landroid/content/Context;", "getCurrentProcessDetails", "getProcessName", "getProcessName$com_google_firebase_firebase_sessions", "com.google.firebase-firebase-sessions"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ProcessDetailsProvider {
    public static final ProcessDetailsProvider INSTANCE = new ProcessDetailsProvider();

    private ProcessDetailsProvider() {
    }

    private final ProcessDetails buildProcessDetails(String processName, int pid, int importance, boolean isDefaultProcess) {
        return new ProcessDetails(processName, pid, importance, isDefaultProcess);
    }

    static /* synthetic */ ProcessDetails buildProcessDetails$default(ProcessDetailsProvider processDetailsProvider, String str, int i5, int i6, boolean z5, int i7, Object obj) {
        if ((i7 & 2) != 0) {
            i5 = 0;
        }
        if ((i7 & 4) != 0) {
            i6 = 0;
        }
        if ((i7 & 8) != 0) {
            z5 = false;
        }
        return processDetailsProvider.buildProcessDetails(str, i5, i6, z5);
    }

    public final List<ProcessDetails> getAppProcessDetails(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        int i5 = context.getApplicationInfo().uid;
        String str = context.getApplicationInfo().processName;
        Object systemService = context.getSystemService("activity");
        ActivityManager activityManager = systemService instanceof ActivityManager ? (ActivityManager) systemService : null;
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = activityManager != null ? activityManager.getRunningAppProcesses() : null;
        if (runningAppProcesses == null) {
            runningAppProcesses = CollectionsKt.emptyList();
        }
        List filterNotNull = CollectionsKt.filterNotNull(runningAppProcesses);
        ArrayList<ActivityManager.RunningAppProcessInfo> arrayList = new ArrayList();
        for (Object obj : filterNotNull) {
            if (((ActivityManager.RunningAppProcessInfo) obj).uid == i5) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList, 10));
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : arrayList) {
            String str2 = runningAppProcessInfo.processName;
            Intrinsics.checkNotNullExpressionValue(str2, "runningAppProcessInfo.processName");
            arrayList2.add(new ProcessDetails(str2, runningAppProcessInfo.pid, runningAppProcessInfo.importance, Intrinsics.areEqual(runningAppProcessInfo.processName, str)));
        }
        return arrayList2;
    }

    public final ProcessDetails getCurrentProcessDetails(Context context) {
        Object obj;
        Intrinsics.checkNotNullParameter(context, "context");
        int myPid = Process.myPid();
        Iterator<T> it = getAppProcessDetails(context).iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (((ProcessDetails) obj).getPid() == myPid) {
                break;
            }
        }
        ProcessDetails processDetails = (ProcessDetails) obj;
        return processDetails == null ? buildProcessDetails$default(this, getProcessName$com_google_firebase_firebase_sessions(), myPid, 0, false, 12, null) : processDetails;
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0014, code lost:
    
        r0 = android.app.Application.getProcessName();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String getProcessName$com_google_firebase_firebase_sessions() {
        String processName;
        String myProcessName;
        int i5 = Build.VERSION.SDK_INT;
        if (i5 >= 33) {
            myProcessName = Process.myProcessName();
            Intrinsics.checkNotNullExpressionValue(myProcessName, "myProcessName()");
            return myProcessName;
        }
        if (i5 >= 28 && processName != null) {
            return processName;
        }
        String myProcessName2 = ProcessUtils.getMyProcessName();
        return myProcessName2 != null ? myProcessName2 : BuildConfig.FLAVOR;
    }
}
