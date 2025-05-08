package dk.molslinjen.domain.managers.user.vehicles;

import dk.molslinjen.domain.model.account.UserVehicle;
import dk.molslinjen.domain.model.config.Site;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.domain.managers.user.vehicles.UserVehiclesManager", f = "UserVehiclesManager.kt", l = {168}, m = "validateVehicle")
/* loaded from: classes2.dex */
public final class UserVehiclesManager$validateVehicle$2 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ UserVehiclesManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserVehiclesManager$validateVehicle$2(UserVehiclesManager userVehiclesManager, Continuation<? super UserVehiclesManager$validateVehicle$2> continuation) {
        super(continuation);
        this.this$0 = userVehiclesManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.validateVehicle((UserVehicle) null, (List<String>) null, (Site) null, this);
    }
}
