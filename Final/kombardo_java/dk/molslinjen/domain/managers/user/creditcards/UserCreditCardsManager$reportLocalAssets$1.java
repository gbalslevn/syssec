package dk.molslinjen.domain.managers.user.creditcards;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.domain.managers.user.creditcards.UserCreditCardsManager", f = "UserCreditCardsManager.kt", l = {129}, m = "reportLocalAssets")
/* loaded from: classes2.dex */
public final class UserCreditCardsManager$reportLocalAssets$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ UserCreditCardsManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserCreditCardsManager$reportLocalAssets$1(UserCreditCardsManager userCreditCardsManager, Continuation<? super UserCreditCardsManager$reportLocalAssets$1> continuation) {
        super(continuation);
        this.this$0 = userCreditCardsManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.reportLocalAssets(this);
    }
}
