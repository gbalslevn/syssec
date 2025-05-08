package androidx.compose.animation.core;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.animation.core.SeekableTransitionState", f = "Transition.kt", l = {566, 2186}, m = "waitForComposition")
/* loaded from: classes.dex */
public final class SeekableTransitionState$waitForComposition$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ SeekableTransitionState<S> this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SeekableTransitionState$waitForComposition$1(SeekableTransitionState<S> seekableTransitionState, Continuation<? super SeekableTransitionState$waitForComposition$1> continuation) {
        super(continuation);
        this.this$0 = seekableTransitionState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object waitForComposition;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        waitForComposition = this.this$0.waitForComposition(this);
        return waitForComposition;
    }
}
