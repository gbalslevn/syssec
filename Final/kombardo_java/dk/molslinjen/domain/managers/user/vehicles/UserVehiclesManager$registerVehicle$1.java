package dk.molslinjen.domain.managers.user.vehicles;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.domain.managers.user.vehicles.UserVehiclesManager", f = "UserVehiclesManager.kt", l = {78, 83, 90, 95, 106}, m = "registerVehicle")
/* loaded from: classes2.dex */
public final class UserVehiclesManager$registerVehicle$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ UserVehiclesManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserVehiclesManager$registerVehicle$1(UserVehiclesManager userVehiclesManager, Continuation<? super UserVehiclesManager$registerVehicle$1> continuation) {
        super(continuation);
        this.this$0 = userVehiclesManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.registerVehicle(null, null, null, this);
    }
}
