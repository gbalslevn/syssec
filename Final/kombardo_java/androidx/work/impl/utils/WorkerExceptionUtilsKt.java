package androidx.work.impl.utils;

import androidx.core.util.Consumer;
import androidx.work.Logger;
import androidx.work.WorkerExceptionInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u001a \u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"safeAccept", BuildConfig.FLAVOR, "Landroidx/core/util/Consumer;", "Landroidx/work/WorkerExceptionInfo;", "info", "tag", BuildConfig.FLAVOR, "work-runtime_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class WorkerExceptionUtilsKt {
    public static final void safeAccept(Consumer<WorkerExceptionInfo> consumer, WorkerExceptionInfo info, String tag) {
        Intrinsics.checkNotNullParameter(consumer, "<this>");
        Intrinsics.checkNotNullParameter(info, "info");
        Intrinsics.checkNotNullParameter(tag, "tag");
        try {
            consumer.accept(info);
        } catch (Throwable th) {
            Logger.get().error(tag, "Exception handler threw an exception", th);
        }
    }
}
