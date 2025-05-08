package dk.molslinjen.domain.managers.user.newsletters;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.domain.managers.user.newsletters.NewslettersManager", f = "NewslettersManager.kt", l = {40}, m = "loadSubscriptions")
/* loaded from: classes2.dex */
public final class NewslettersManager$loadSubscriptions$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ NewslettersManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NewslettersManager$loadSubscriptions$1(NewslettersManager newslettersManager, Continuation<? super NewslettersManager$loadSubscriptions$1> continuation) {
        super(continuation);
        this.this$0 = newslettersManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.loadSubscriptions(null, this);
    }
}
