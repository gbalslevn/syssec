package dk.molslinjen.workers;

import android.content.Context;
import androidx.work.ListenableWorker;
import androidx.work.WorkerParameters;
import dk.molslinjen.core.log.Logger;
import dk.molslinjen.domain.managers.ManagerResult;
import dk.molslinjen.domain.managers.ManagerResultKt;
import dk.molslinjen.domain.managers.configuration.IConfigurationManager;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B%\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\n\u001a\u00020\u000bH\u0096@¢\u0006\u0002\u0010\fR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Ldk/molslinjen/workers/ConfigUpdateWorker;", "Ldk/molslinjen/workers/UpdateWorker;", "appContext", "Landroid/content/Context;", "workerParams", "Landroidx/work/WorkerParameters;", "configurationManager", "Ldk/molslinjen/domain/managers/configuration/IConfigurationManager;", "<init>", "(Landroid/content/Context;Landroidx/work/WorkerParameters;Ldk/molslinjen/domain/managers/configuration/IConfigurationManager;)V", "doWork", "Landroidx/work/ListenableWorker$Result;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ConfigUpdateWorker extends UpdateWorker {
    private final IConfigurationManager configurationManager;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConfigUpdateWorker(Context appContext, WorkerParameters workerParams, IConfigurationManager configurationManager) {
        super(appContext, workerParams);
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        Intrinsics.checkNotNullParameter(workerParams, "workerParams");
        Intrinsics.checkNotNullParameter(configurationManager, "configurationManager");
        this.configurationManager = configurationManager;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @Override // androidx.work.CoroutineWorker
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object doWork(Continuation<? super ListenableWorker.Result> continuation) {
        ConfigUpdateWorker$doWork$1 configUpdateWorker$doWork$1;
        int i5;
        ConfigUpdateWorker configUpdateWorker;
        ManagerResult managerResult;
        if (continuation instanceof ConfigUpdateWorker$doWork$1) {
            configUpdateWorker$doWork$1 = (ConfigUpdateWorker$doWork$1) continuation;
            int i6 = configUpdateWorker$doWork$1.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                configUpdateWorker$doWork$1.label = i6 - Integer.MIN_VALUE;
                Object obj = configUpdateWorker$doWork$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = configUpdateWorker$doWork$1.label;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj);
                    IConfigurationManager iConfigurationManager = this.configurationManager;
                    configUpdateWorker$doWork$1.L$0 = this;
                    configUpdateWorker$doWork$1.label = 1;
                    obj = iConfigurationManager.loadConfiguration(configUpdateWorker$doWork$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    configUpdateWorker = this;
                } else {
                    if (i5 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    configUpdateWorker = (ConfigUpdateWorker) configUpdateWorker$doWork$1.L$0;
                    ResultKt.throwOnFailure(obj);
                }
                managerResult = (ManagerResult) obj;
                if (managerResult instanceof ManagerResult.Error) {
                    if (!(managerResult instanceof ManagerResult.Success)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    ListenableWorker.Result success = ListenableWorker.Result.success();
                    Intrinsics.checkNotNullExpressionValue(success, "success(...)");
                    return success;
                }
                Context applicationContext = configUpdateWorker.getApplicationContext();
                Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
                String errorMessage = ManagerResultKt.errorMessage((ManagerResult.Error) managerResult, applicationContext);
                Logger.log$default(Logger.INSTANCE, "ConfigUpdateWorker: Error getting configuration: " + errorMessage, null, 0, 6, null);
                ListenableWorker.Result retry = ListenableWorker.Result.retry();
                Intrinsics.checkNotNull(retry);
                return retry;
            }
        }
        configUpdateWorker$doWork$1 = new ConfigUpdateWorker$doWork$1(this, continuation);
        Object obj2 = configUpdateWorker$doWork$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = configUpdateWorker$doWork$1.label;
        if (i5 != 0) {
        }
        managerResult = (ManagerResult) obj2;
        if (managerResult instanceof ManagerResult.Error) {
        }
    }
}
