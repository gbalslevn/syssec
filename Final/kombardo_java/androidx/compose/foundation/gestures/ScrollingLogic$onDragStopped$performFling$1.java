package androidx.compose.foundation.gestures;

import androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher;
import androidx.compose.ui.unit.Velocity;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u008a@"}, d2 = {"<anonymous>", "Landroidx/compose/ui/unit/Velocity;", "velocity"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.gestures.ScrollingLogic$onDragStopped$performFling$1", f = "Scrollable.kt", l = {745, 748, 751}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class ScrollingLogic$onDragStopped$performFling$1 extends SuspendLambda implements Function2<Velocity, Continuation<? super Velocity>, Object> {
    /* synthetic */ long J$0;
    long J$1;
    int label;
    final /* synthetic */ ScrollingLogic this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ScrollingLogic$onDragStopped$performFling$1(ScrollingLogic scrollingLogic, Continuation<? super ScrollingLogic$onDragStopped$performFling$1> continuation) {
        super(2, continuation);
        this.this$0 = scrollingLogic;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ScrollingLogic$onDragStopped$performFling$1 scrollingLogic$onDragStopped$performFling$1 = new ScrollingLogic$onDragStopped$performFling$1(this.this$0, continuation);
        scrollingLogic$onDragStopped$performFling$1.J$0 = ((Velocity) obj).getPackedValue();
        return scrollingLogic$onDragStopped$performFling$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Velocity velocity, Continuation<? super Velocity> continuation) {
        return m236invokesFctU(velocity.getPackedValue(), continuation);
    }

    /* renamed from: invoke-sF-c-tU, reason: not valid java name */
    public final Object m236invokesFctU(long j5, Continuation<? super Velocity> continuation) {
        return ((ScrollingLogic$onDragStopped$performFling$1) create(Velocity.m2695boximpl(j5), continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0087 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0088  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        NestedScrollDispatcher nestedScrollDispatcher;
        Object m1837dispatchPreFlingQWom1Mo;
        long j5;
        Object m229doFlingAnimationQWom1Mo;
        long j6;
        long j7;
        long packedValue;
        NestedScrollDispatcher nestedScrollDispatcher2;
        Object m1835dispatchPostFlingRZ2iAVY;
        long j8;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = this.label;
        if (i5 == 0) {
            ResultKt.throwOnFailure(obj);
            long j9 = this.J$0;
            nestedScrollDispatcher = this.this$0.nestedScrollDispatcher;
            this.J$0 = j9;
            this.label = 1;
            m1837dispatchPreFlingQWom1Mo = nestedScrollDispatcher.m1837dispatchPreFlingQWom1Mo(j9, this);
            if (m1837dispatchPreFlingQWom1Mo == coroutine_suspended) {
                return coroutine_suspended;
            }
            j5 = j9;
        } else {
            if (i5 != 1) {
                if (i5 != 2) {
                    if (i5 != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    long j10 = this.J$1;
                    j8 = this.J$0;
                    ResultKt.throwOnFailure(obj);
                    packedValue = j10;
                    m1835dispatchPostFlingRZ2iAVY = obj;
                    return Velocity.m2695boximpl(Velocity.m2704minusAH228Gc(j8, Velocity.m2704minusAH228Gc(packedValue, ((Velocity) m1835dispatchPostFlingRZ2iAVY).getPackedValue())));
                }
                j6 = this.J$1;
                long j11 = this.J$0;
                ResultKt.throwOnFailure(obj);
                m229doFlingAnimationQWom1Mo = obj;
                j7 = j11;
                packedValue = ((Velocity) m229doFlingAnimationQWom1Mo).getPackedValue();
                nestedScrollDispatcher2 = this.this$0.nestedScrollDispatcher;
                long m2704minusAH228Gc = Velocity.m2704minusAH228Gc(j6, packedValue);
                this.J$0 = j7;
                this.J$1 = packedValue;
                this.label = 3;
                m1835dispatchPostFlingRZ2iAVY = nestedScrollDispatcher2.m1835dispatchPostFlingRZ2iAVY(m2704minusAH228Gc, packedValue, this);
                if (m1835dispatchPostFlingRZ2iAVY != coroutine_suspended) {
                    return coroutine_suspended;
                }
                j8 = j7;
                return Velocity.m2695boximpl(Velocity.m2704minusAH228Gc(j8, Velocity.m2704minusAH228Gc(packedValue, ((Velocity) m1835dispatchPostFlingRZ2iAVY).getPackedValue())));
            }
            j5 = this.J$0;
            ResultKt.throwOnFailure(obj);
            m1837dispatchPreFlingQWom1Mo = obj;
        }
        long m2704minusAH228Gc2 = Velocity.m2704minusAH228Gc(j5, ((Velocity) m1837dispatchPreFlingQWom1Mo).getPackedValue());
        ScrollingLogic scrollingLogic = this.this$0;
        this.J$0 = j5;
        this.J$1 = m2704minusAH228Gc2;
        this.label = 2;
        m229doFlingAnimationQWom1Mo = scrollingLogic.m229doFlingAnimationQWom1Mo(m2704minusAH228Gc2, this);
        if (m229doFlingAnimationQWom1Mo == coroutine_suspended) {
            return coroutine_suspended;
        }
        j6 = m2704minusAH228Gc2;
        j7 = j5;
        packedValue = ((Velocity) m229doFlingAnimationQWom1Mo).getPackedValue();
        nestedScrollDispatcher2 = this.this$0.nestedScrollDispatcher;
        long m2704minusAH228Gc3 = Velocity.m2704minusAH228Gc(j6, packedValue);
        this.J$0 = j7;
        this.J$1 = packedValue;
        this.label = 3;
        m1835dispatchPostFlingRZ2iAVY = nestedScrollDispatcher2.m1835dispatchPostFlingRZ2iAVY(m2704minusAH228Gc3, packedValue, this);
        if (m1835dispatchPostFlingRZ2iAVY != coroutine_suspended) {
        }
    }
}
