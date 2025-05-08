package androidx.work.impl;

import androidx.work.WorkerParameters;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH&J\u0018\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0016ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\fÀ\u0006\u0001"}, d2 = {"Landroidx/work/impl/WorkLauncher;", BuildConfig.FLAVOR, "startWork", BuildConfig.FLAVOR, "workSpecId", "Landroidx/work/impl/StartStopToken;", "runtimeExtras", "Landroidx/work/WorkerParameters$RuntimeExtras;", "stopWork", "reason", BuildConfig.FLAVOR, "stopWorkWithReason", "work-runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public interface WorkLauncher {
    default void startWork(StartStopToken workSpecId) {
        Intrinsics.checkNotNullParameter(workSpecId, "workSpecId");
        startWork(workSpecId, null);
    }

    void startWork(StartStopToken workSpecId, WorkerParameters.RuntimeExtras runtimeExtras);

    default void stopWork(StartStopToken workSpecId) {
        Intrinsics.checkNotNullParameter(workSpecId, "workSpecId");
        stopWork(workSpecId, -512);
    }

    void stopWork(StartStopToken workSpecId, int reason);

    default void stopWorkWithReason(StartStopToken workSpecId, int reason) {
        Intrinsics.checkNotNullParameter(workSpecId, "workSpecId");
        stopWork(workSpecId, reason);
    }
}
