package com.google.firebase.perf.session.gauges;

import android.app.ActivityManager;
import android.content.Context;
import com.google.firebase.perf.logging.AndroidLogger;
import com.google.firebase.perf.util.StorageUnit;
import com.google.firebase.perf.util.Utils;

/* loaded from: classes2.dex */
class GaugeMetadataManager {
    private static final AndroidLogger logger = AndroidLogger.getInstance();
    private final ActivityManager activityManager;
    private final Context appContext;
    private final ActivityManager.MemoryInfo memoryInfo;
    private final Runtime runtime;

    /* JADX INFO: Access modifiers changed from: package-private */
    public GaugeMetadataManager(Context context) {
        this(Runtime.getRuntime(), context);
    }

    public int getDeviceRamSizeKb() {
        return Utils.saturatedIntCast(StorageUnit.BYTES.toKilobytes(this.memoryInfo.totalMem));
    }

    public int getMaxAppJavaHeapMemoryKb() {
        return Utils.saturatedIntCast(StorageUnit.BYTES.toKilobytes(this.runtime.maxMemory()));
    }

    public int getMaxEncouragedAppJavaHeapMemoryKb() {
        return Utils.saturatedIntCast(StorageUnit.MEGABYTES.toKilobytes(this.activityManager.getMemoryClass()));
    }

    GaugeMetadataManager(Runtime runtime, Context context) {
        this.runtime = runtime;
        this.appContext = context;
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        this.activityManager = activityManager;
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        this.memoryInfo = memoryInfo;
        activityManager.getMemoryInfo(memoryInfo);
    }
}
