package com.google.firebase.crashlytics.internal;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J.\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u000bH\u0007J\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000fJ\b\u0010\u0011\u001a\u00020\u0006H\u0002¨\u0006\u0012"}, d2 = {"Lcom/google/firebase/crashlytics/internal/ProcessDetailsProvider;", BuildConfig.FLAVOR, "()V", "buildProcessDetails", "Lcom/google/firebase/crashlytics/internal/model/CrashlyticsReport$Session$Event$Application$ProcessDetails;", "processName", BuildConfig.FLAVOR, "pid", BuildConfig.FLAVOR, "importance", "isDefaultProcess", BuildConfig.FLAVOR, "getAppProcessDetails", BuildConfig.FLAVOR, "context", "Landroid/content/Context;", "getCurrentProcessDetails", "getProcessName", "com.google.firebase-firebase-crashlytics"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ProcessDetailsProvider {
    public static final ProcessDetailsProvider INSTANCE = new ProcessDetailsProvider();

    private ProcessDetailsProvider() {
    }

    public static /* synthetic */ CrashlyticsReport.Session.Event.Application.ProcessDetails buildProcessDetails$default(ProcessDetailsProvider processDetailsProvider, String str, int i5, int i6, boolean z5, int i7, Object obj) {
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

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0016, code lost:
    
        r0 = android.app.Application.getProcessName();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final String getProcessName() {
        String processName;
        String myProcessName;
        int i5 = Build.VERSION.SDK_INT;
        if (i5 < 33) {
            return (i5 < 28 || processName == null) ? BuildConfig.FLAVOR : processName;
        }
        myProcessName = Process.myProcessName();
        Intrinsics.checkNotNullExpressionValue(myProcessName, "{\n      Process.myProcessName()\n    }");
        return myProcessName;
    }

    public final CrashlyticsReport.Session.Event.Application.ProcessDetails buildProcessDetails(String processName, int i5, int i6) {
        Intrinsics.checkNotNullParameter(processName, "processName");
        return buildProcessDetails$default(this, processName, i5, i6, false, 8, null);
    }

    public final List<CrashlyticsReport.Session.Event.Application.ProcessDetails> getAppProcessDetails(Context context) {
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
            arrayList2.add(CrashlyticsReport.Session.Event.Application.ProcessDetails.builder().setProcessName(runningAppProcessInfo.processName).setPid(runningAppProcessInfo.pid).setImportance(runningAppProcessInfo.importance).setDefaultProcess(Intrinsics.areEqual(runningAppProcessInfo.processName, str)).build());
        }
        return arrayList2;
    }

    public final CrashlyticsReport.Session.Event.Application.ProcessDetails getCurrentProcessDetails(Context context) {
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
            if (((CrashlyticsReport.Session.Event.Application.ProcessDetails) obj).getPid() == myPid) {
                break;
            }
        }
        CrashlyticsReport.Session.Event.Application.ProcessDetails processDetails = (CrashlyticsReport.Session.Event.Application.ProcessDetails) obj;
        return processDetails == null ? buildProcessDetails$default(this, getProcessName(), myPid, 0, false, 12, null) : processDetails;
    }

    public final CrashlyticsReport.Session.Event.Application.ProcessDetails buildProcessDetails(String processName, int pid, int importance, boolean isDefaultProcess) {
        Intrinsics.checkNotNullParameter(processName, "processName");
        CrashlyticsReport.Session.Event.Application.ProcessDetails build = CrashlyticsReport.Session.Event.Application.ProcessDetails.builder().setProcessName(processName).setPid(pid).setImportance(importance).setDefaultProcess(isDefaultProcess).build();
        Intrinsics.checkNotNullExpressionValue(build, "builder()\n      .setProc…ltProcess)\n      .build()");
        return build;
    }
}
