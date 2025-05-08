package coil.intercept;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "coil.intercept.EngineInterceptor", f = "EngineInterceptor.kt", l = {122, 126, 144}, m = "execute")
/* loaded from: classes.dex */
public final class EngineInterceptor$execute$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    Object L$7;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ EngineInterceptor this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EngineInterceptor$execute$1(EngineInterceptor engineInterceptor, Continuation<? super EngineInterceptor$execute$1> continuation) {
        super(continuation);
        this.this$0 = engineInterceptor;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object execute;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        execute = this.this$0.execute(null, null, null, null, this);
        return execute;
    }
}
