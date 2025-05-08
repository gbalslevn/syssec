package dk.molslinjen.domain.managers.user;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.domain.managers.user.UserManager", f = "UserManager.kt", l = {403, 410, 411}, m = "handleValidAuthToken-zHhnIQY")
/* loaded from: classes2.dex */
public final class UserManager$handleValidAuthToken$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ UserManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserManager$handleValidAuthToken$1(UserManager userManager, Continuation<? super UserManager$handleValidAuthToken$1> continuation) {
        super(continuation);
        this.this$0 = userManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object m3202handleValidAuthTokenzHhnIQY;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        m3202handleValidAuthTokenzHhnIQY = this.this$0.m3202handleValidAuthTokenzHhnIQY(null, null, false, this);
        return m3202handleValidAuthTokenzHhnIQY;
    }
}
