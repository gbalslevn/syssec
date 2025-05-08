package dk.molslinjen.domain.managers.user.passengers;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.domain.managers.user.passengers.UserPassengerManager", f = "UserPassengerManager.kt", l = {80, 89, 103, 106}, m = "registerPassenger")
/* loaded from: classes2.dex */
public final class UserPassengerManager$registerPassenger$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ UserPassengerManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserPassengerManager$registerPassenger$1(UserPassengerManager userPassengerManager, Continuation<? super UserPassengerManager$registerPassenger$1> continuation) {
        super(continuation);
        this.this$0 = userPassengerManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.registerPassenger(null, null, null, null, null, this);
    }
}
