package dk.molslinjen.domain.managers.faq;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.domain.managers.faq.FaqManager", f = "FaqManager.kt", l = {40, 79}, m = "loadFaq")
/* loaded from: classes2.dex */
public final class FaqManager$loadFaq$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ FaqManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FaqManager$loadFaq$1(FaqManager faqManager, Continuation<? super FaqManager$loadFaq$1> continuation) {
        super(continuation);
        this.this$0 = faqManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.loadFaq(null, this);
    }
}
