package dk.molslinjen.core;

import dk.molslinjen.domain.managers.ManagerResult;
import dk.molslinjen.domain.managers.api.IForceUpdateManager;
import dk.molslinjen.domain.model.settings.ForceUpdate;
import dk.molslinjen.domain.model.settings.ISettings;
import dk.molslinjen.domain.model.settings.SettingsProperty;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.conscrypt.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.core.AppUpdater$getUpdateVersionCode$1", f = "AppUpdater.kt", l = {89, 97}, m = "invokeSuspend")
/* loaded from: classes2.dex */
public final class AppUpdater$getUpdateVersionCode$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function2<Boolean, Integer, Unit> $completed;
    int I$0;
    int label;
    final /* synthetic */ AppUpdater this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public AppUpdater$getUpdateVersionCode$1(AppUpdater appUpdater, Function2<? super Boolean, ? super Integer, Unit> function2, Continuation<? super AppUpdater$getUpdateVersionCode$1> continuation) {
        super(2, continuation);
        this.this$0 = appUpdater;
        this.$completed = function2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AppUpdater$getUpdateVersionCode$1(this.this$0, this.$completed, continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0079 A[Catch: all -> 0x0087, TRY_LEAVE, TryCatch #0 {all -> 0x0087, blocks: (B:7:0x0011, B:8:0x0075, B:10:0x0079, B:25:0x004d), top: B:2:0x0009 }] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        IForceUpdateManager iForceUpdateManager;
        ISettings iSettings;
        int i5;
        Function2<Boolean, Integer, Unit> function2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i6 = this.label;
        try {
        } catch (Throwable unused) {
            Function2<Boolean, Integer, Unit> function22 = this.$completed;
            if (function22 != null) {
                function22.invoke(Boxing.boxBoolean(false), Boxing.boxInt(0));
                Unit unit = Unit.INSTANCE;
            }
        }
        if (i6 == 0) {
            ResultKt.throwOnFailure(obj);
            iForceUpdateManager = this.this$0.forceUpdateManager;
            this.label = 1;
            obj = iForceUpdateManager.getForceUpdateVersion(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i6 != 1) {
                if (i6 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                i5 = this.I$0;
                ResultKt.throwOnFailure(obj);
                function2 = this.$completed;
                if (function2 != null) {
                    function2.invoke(Boxing.boxBoolean(true), Boxing.boxInt(i5));
                    Unit unit2 = Unit.INSTANCE;
                }
                return Unit.INSTANCE;
            }
            ResultKt.throwOnFailure(obj);
        }
        ManagerResult managerResult = (ManagerResult) obj;
        if (managerResult instanceof ManagerResult.Error) {
            Function2<Boolean, Integer, Unit> function23 = this.$completed;
            if (function23 != null) {
                function23.invoke(Boxing.boxBoolean(false), Boxing.boxInt(0));
            }
            return Unit.INSTANCE;
        }
        if (!(managerResult instanceof ManagerResult.Success)) {
            throw new NoWhenBranchMatchedException();
        }
        int parseInt = Integer.parseInt(((ForceUpdate) ((ManagerResult.Success) managerResult).getData()).getMinimumVersionCode());
        iSettings = this.this$0.settings;
        SettingsProperty.ForceUpdate.MinAppVersionCode minAppVersionCode = SettingsProperty.ForceUpdate.MinAppVersionCode.INSTANCE;
        Integer boxInt = Boxing.boxInt(parseInt);
        this.I$0 = parseInt;
        this.label = 2;
        if (iSettings.update(minAppVersionCode, boxInt, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        i5 = parseInt;
        function2 = this.$completed;
        if (function2 != null) {
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AppUpdater$getUpdateVersionCode$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
