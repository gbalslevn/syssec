package androidx.compose.foundation.gestures;

import androidx.compose.ui.geometry.Offset;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "Landroidx/compose/ui/geometry/Offset;", "offset"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.gestures.ScrollableNode$setScrollSemanticsActions$2", f = "Scrollable.kt", l = {527}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class ScrollableNode$setScrollSemanticsActions$2 extends SuspendLambda implements Function2<Offset, Continuation<? super Offset>, Object> {
    /* synthetic */ long J$0;
    int label;
    final /* synthetic */ ScrollableNode this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScrollableNode$setScrollSemanticsActions$2(ScrollableNode scrollableNode, Continuation<? super ScrollableNode$setScrollSemanticsActions$2> continuation) {
        super(2, continuation);
        this.this$0 = scrollableNode;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ScrollableNode$setScrollSemanticsActions$2 scrollableNode$setScrollSemanticsActions$2 = new ScrollableNode$setScrollSemanticsActions$2(this.this$0, continuation);
        scrollableNode$setScrollSemanticsActions$2.J$0 = ((Offset) obj).getPackedValue();
        return scrollableNode$setScrollSemanticsActions$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Offset offset, Continuation<? super Offset> continuation) {
        return m221invoke3MmeM6k(offset.getPackedValue(), continuation);
    }

    /* renamed from: invoke-3MmeM6k, reason: not valid java name */
    public final Object m221invoke3MmeM6k(long j5, Continuation<? super Offset> continuation) {
        return ((ScrollableNode$setScrollSemanticsActions$2) create(Offset.m1328boximpl(j5), continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        ScrollingLogic scrollingLogic;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = this.label;
        if (i5 == 0) {
            ResultKt.throwOnFailure(obj);
            long j5 = this.J$0;
            scrollingLogic = this.this$0.scrollingLogic;
            this.label = 1;
            obj = ScrollableKt.m217semanticsScrollByd4ec7I(scrollingLogic, j5, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i5 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return obj;
    }
}
