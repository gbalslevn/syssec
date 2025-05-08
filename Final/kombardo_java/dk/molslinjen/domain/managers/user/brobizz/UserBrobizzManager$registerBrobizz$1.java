package dk.molslinjen.domain.managers.user.brobizz;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.domain.managers.user.brobizz.UserBrobizzManager", f = "UserBrobizzManager.kt", l = {35, 35}, m = "registerBrobizz")
/* loaded from: classes2.dex */
public final class UserBrobizzManager$registerBrobizz$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ UserBrobizzManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserBrobizzManager$registerBrobizz$1(UserBrobizzManager userBrobizzManager, Continuation<? super UserBrobizzManager$registerBrobizz$1> continuation) {
        super(continuation);
        this.this$0 = userBrobizzManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.registerBrobizz(null, this);
    }
}
