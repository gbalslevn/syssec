package androidx.work;

import android.content.Context;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\"\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH&J \u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007¨\u0006\f"}, d2 = {"Landroidx/work/WorkerFactory;", BuildConfig.FLAVOR, "()V", "createWorker", "Landroidx/work/ListenableWorker;", "appContext", "Landroid/content/Context;", "workerClassName", BuildConfig.FLAVOR, "workerParameters", "Landroidx/work/WorkerParameters;", "createWorkerWithDefaultFallback", "work-runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class WorkerFactory {
    private static final ListenableWorker createWorkerWithDefaultFallback$fallbackToReflection(Context context, String str, WorkerParameters workerParameters) {
        String str2;
        try {
            ListenableWorker newInstance = createWorkerWithDefaultFallback$getWorkerClass(str).getDeclaredConstructor(Context.class, WorkerParameters.class).newInstance(context, workerParameters);
            Intrinsics.checkNotNullExpressionValue(newInstance, "{\n                val co…Parameters)\n            }");
            return newInstance;
        } catch (Throwable th) {
            Logger logger = Logger.get();
            str2 = WorkerFactoryKt.TAG;
            logger.error(str2, "Could not instantiate " + str, th);
            throw th;
        }
    }

    private static final Class<? extends ListenableWorker> createWorkerWithDefaultFallback$getWorkerClass(String str) {
        String str2;
        try {
            Class asSubclass = Class.forName(str).asSubclass(ListenableWorker.class);
            Intrinsics.checkNotNullExpressionValue(asSubclass, "{\n                Class.…class.java)\n            }");
            return asSubclass;
        } catch (Throwable th) {
            Logger logger = Logger.get();
            str2 = WorkerFactoryKt.TAG;
            logger.error(str2, "Invalid class: " + str, th);
            throw th;
        }
    }

    public abstract ListenableWorker createWorker(Context appContext, String workerClassName, WorkerParameters workerParameters);

    public final ListenableWorker createWorkerWithDefaultFallback(Context appContext, String workerClassName, WorkerParameters workerParameters) {
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        Intrinsics.checkNotNullParameter(workerClassName, "workerClassName");
        Intrinsics.checkNotNullParameter(workerParameters, "workerParameters");
        ListenableWorker createWorker = createWorker(appContext, workerClassName, workerParameters);
        if (createWorker == null) {
            createWorker = createWorkerWithDefaultFallback$fallbackToReflection(appContext, workerClassName, workerParameters);
        }
        if (!createWorker.isUsed()) {
            return createWorker;
        }
        throw new IllegalStateException("WorkerFactory (" + getClass().getName() + ") returned an instance of a ListenableWorker (" + workerClassName + ") which has already been invoked. createWorker() must always return a new instance of a ListenableWorker.");
    }
}
