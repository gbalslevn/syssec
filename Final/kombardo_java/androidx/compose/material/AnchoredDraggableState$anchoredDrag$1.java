package androidx.compose.material;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.material.AnchoredDraggableState", f = "AnchoredDraggable.kt", l = {539}, m = "anchoredDrag")
/* loaded from: classes.dex */
public final class AnchoredDraggableState$anchoredDrag$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AnchoredDraggableState<T> this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AnchoredDraggableState$anchoredDrag$1(AnchoredDraggableState<T> anchoredDraggableState, Continuation<? super AnchoredDraggableState$anchoredDrag$1> continuation) {
        super(continuation);
        this.this$0 = anchoredDraggableState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.anchoredDrag(null, null, this);
    }
}
