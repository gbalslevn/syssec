package androidx.work.impl.utils;

import android.content.Context;
import android.os.Build;
import androidx.work.ForegroundUpdater;
import androidx.work.ListenableWorker;
import androidx.work.Logger;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.ExecutorsKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a6\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0086@¢\u0006\u0002\u0010\u000e\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"TAG", BuildConfig.FLAVOR, "workForeground", BuildConfig.FLAVOR, "context", "Landroid/content/Context;", "spec", "Landroidx/work/impl/model/WorkSpec;", "worker", "Landroidx/work/ListenableWorker;", "foregroundUpdater", "Landroidx/work/ForegroundUpdater;", "taskExecutor", "Landroidx/work/impl/utils/taskexecutor/TaskExecutor;", "(Landroid/content/Context;Landroidx/work/impl/model/WorkSpec;Landroidx/work/ListenableWorker;Landroidx/work/ForegroundUpdater;Landroidx/work/impl/utils/taskexecutor/TaskExecutor;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "work-runtime_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class WorkForegroundKt {
    private static final String TAG;

    static {
        String tagWithPrefix = Logger.tagWithPrefix("WorkForegroundRunnable");
        Intrinsics.checkNotNullExpressionValue(tagWithPrefix, "tagWithPrefix(\"WorkForegroundRunnable\")");
        TAG = tagWithPrefix;
    }

    public static final Object workForeground(Context context, WorkSpec workSpec, ListenableWorker listenableWorker, ForegroundUpdater foregroundUpdater, TaskExecutor taskExecutor, Continuation<? super Unit> continuation) {
        if (!workSpec.expedited || Build.VERSION.SDK_INT >= 31) {
            return Unit.INSTANCE;
        }
        Executor mainThreadExecutor = taskExecutor.getMainThreadExecutor();
        Intrinsics.checkNotNullExpressionValue(mainThreadExecutor, "taskExecutor.mainThreadExecutor");
        Object withContext = BuildersKt.withContext(ExecutorsKt.from(mainThreadExecutor), new WorkForegroundKt$workForeground$2(listenableWorker, workSpec, foregroundUpdater, context, null), continuation);
        return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }
}
