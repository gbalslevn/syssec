package dk.molslinjen.domain.managers.api;

import dk.molslinjen.api.helpers.ApiResult;
import dk.molslinjen.api.services.forceUpdate.IForceUpdateService;
import dk.molslinjen.api.services.forceUpdate.response.ForceUpdateDTO;
import dk.molslinjen.domain.extensions.ManagerResultExtensionsKt;
import dk.molslinjen.domain.managers.ManagerResult;
import dk.molslinjen.domain.managers.api.ForceUpdateManager;
import dk.molslinjen.domain.model.settings.ForceUpdate;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0096@¢\u0006\u0002\u0010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Ldk/molslinjen/domain/managers/api/ForceUpdateManager;", "Ldk/molslinjen/domain/managers/api/IForceUpdateManager;", "forceUpdateService", "Ldk/molslinjen/api/services/forceUpdate/IForceUpdateService;", "<init>", "(Ldk/molslinjen/api/services/forceUpdate/IForceUpdateService;)V", "getForceUpdateVersion", "Ldk/molslinjen/domain/managers/ManagerResult;", "Ldk/molslinjen/domain/model/settings/ForceUpdate;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "domain_kombardoProd"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ForceUpdateManager implements IForceUpdateManager {
    private final IForceUpdateService forceUpdateService;

    public ForceUpdateManager(IForceUpdateService forceUpdateService) {
        Intrinsics.checkNotNullParameter(forceUpdateService, "forceUpdateService");
        this.forceUpdateService = forceUpdateService;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ForceUpdate getForceUpdateVersion$lambda$0(ForceUpdateDTO it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return new ForceUpdate(it);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @Override // dk.molslinjen.domain.managers.api.IForceUpdateManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object getForceUpdateVersion(Continuation<? super ManagerResult<ForceUpdate>> continuation) {
        ForceUpdateManager$getForceUpdateVersion$1 forceUpdateManager$getForceUpdateVersion$1;
        int i5;
        if (continuation instanceof ForceUpdateManager$getForceUpdateVersion$1) {
            forceUpdateManager$getForceUpdateVersion$1 = (ForceUpdateManager$getForceUpdateVersion$1) continuation;
            int i6 = forceUpdateManager$getForceUpdateVersion$1.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                forceUpdateManager$getForceUpdateVersion$1.label = i6 - Integer.MIN_VALUE;
                Object obj = forceUpdateManager$getForceUpdateVersion$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = forceUpdateManager$getForceUpdateVersion$1.label;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj);
                    IForceUpdateService iForceUpdateService = this.forceUpdateService;
                    forceUpdateManager$getForceUpdateVersion$1.label = 1;
                    obj = iForceUpdateService.getForceUpdateVersion(forceUpdateManager$getForceUpdateVersion$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i5 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                return ManagerResultExtensionsKt.toManagerResult((ApiResult) obj, new Function1() { // from class: A1.a
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        ForceUpdate forceUpdateVersion$lambda$0;
                        forceUpdateVersion$lambda$0 = ForceUpdateManager.getForceUpdateVersion$lambda$0((ForceUpdateDTO) obj2);
                        return forceUpdateVersion$lambda$0;
                    }
                });
            }
        }
        forceUpdateManager$getForceUpdateVersion$1 = new ForceUpdateManager$getForceUpdateVersion$1(this, continuation);
        Object obj2 = forceUpdateManager$getForceUpdateVersion$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = forceUpdateManager$getForceUpdateVersion$1.label;
        if (i5 != 0) {
        }
        return ManagerResultExtensionsKt.toManagerResult((ApiResult) obj2, new Function1() { // from class: A1.a
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj22) {
                ForceUpdate forceUpdateVersion$lambda$0;
                forceUpdateVersion$lambda$0 = ForceUpdateManager.getForceUpdateVersion$lambda$0((ForceUpdateDTO) obj22);
                return forceUpdateVersion$lambda$0;
            }
        });
    }
}
