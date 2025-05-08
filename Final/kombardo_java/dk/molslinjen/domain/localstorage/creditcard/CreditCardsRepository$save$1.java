package dk.molslinjen.domain.localstorage.creditcard;

import dk.molslinjen.domain.model.account.CreditCard;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.domain.localstorage.creditcard.CreditCardsRepository", f = "CreditCardsRepository.kt", l = {25, 25}, m = "save")
/* loaded from: classes2.dex */
public final class CreditCardsRepository$save$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ CreditCardsRepository this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CreditCardsRepository$save$1(CreditCardsRepository creditCardsRepository, Continuation<? super CreditCardsRepository$save$1> continuation) {
        super(continuation);
        this.this$0 = creditCardsRepository;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.save((CreditCard) null, this);
    }
}
