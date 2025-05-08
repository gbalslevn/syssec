package coil;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "coil.RealImageLoader", f = "RealImageLoader.kt", l = {166, 178, 182}, m = "executeMain")
/* loaded from: classes.dex */
public final class RealImageLoader$executeMain$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ RealImageLoader this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RealImageLoader$executeMain$1(RealImageLoader realImageLoader, Continuation<? super RealImageLoader$executeMain$1> continuation) {
        super(continuation);
        this.this$0 = realImageLoader;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object executeMain;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        executeMain = this.this$0.executeMain(null, 0, this);
        return executeMain;
    }
}
