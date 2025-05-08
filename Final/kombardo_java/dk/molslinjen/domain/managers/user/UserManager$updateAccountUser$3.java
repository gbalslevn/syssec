package dk.molslinjen.domain.managers.user;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.domain.managers.user.UserManager", f = "UserManager.kt", l = {309, 316, 323}, m = "updateAccountUser-hlWoXfE")
/* loaded from: classes2.dex */
public final class UserManager$updateAccountUser$3 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ UserManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserManager$updateAccountUser$3(UserManager userManager, Continuation<? super UserManager$updateAccountUser$3> continuation) {
        super(continuation);
        this.this$0 = userManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object m3203updateAccountUserhlWoXfE;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        m3203updateAccountUserhlWoXfE = this.this$0.m3203updateAccountUserhlWoXfE(null, null, this);
        return m3203updateAccountUserhlWoXfE;
    }
}
