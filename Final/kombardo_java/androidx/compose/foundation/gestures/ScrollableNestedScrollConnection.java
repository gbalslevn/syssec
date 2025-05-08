package androidx.compose.foundation.gestures;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.unit.Velocity;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import org.conscrypt.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J*\u0010\u000f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0016ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000eJ#\u0010\u0013\u001a\u00020\u00102\u0006\u0010\t\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u0010H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\"\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u001c"}, d2 = {"Landroidx/compose/foundation/gestures/ScrollableNestedScrollConnection;", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "Landroidx/compose/foundation/gestures/ScrollingLogic;", "scrollingLogic", BuildConfig.FLAVOR, "enabled", "<init>", "(Landroidx/compose/foundation/gestures/ScrollingLogic;Z)V", "Landroidx/compose/ui/geometry/Offset;", "consumed", "available", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "source", "onPostScroll-DzOQY0M", "(JJI)J", "onPostScroll", "Landroidx/compose/ui/unit/Velocity;", "onPostFling-RZ2iAVY", "(JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onPostFling", "Landroidx/compose/foundation/gestures/ScrollingLogic;", "getScrollingLogic", "()Landroidx/compose/foundation/gestures/ScrollingLogic;", "Z", "getEnabled", "()Z", "setEnabled", "(Z)V", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ScrollableNestedScrollConnection implements NestedScrollConnection {
    private boolean enabled;
    private final ScrollingLogic scrollingLogic;

    public ScrollableNestedScrollConnection(ScrollingLogic scrollingLogic, boolean z5) {
        this.scrollingLogic = scrollingLogic;
        this.enabled = z5;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* renamed from: onPostFling-RZ2iAVY, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object mo218onPostFlingRZ2iAVY(long j5, long j6, Continuation<? super Velocity> continuation) {
        ScrollableNestedScrollConnection$onPostFling$1 scrollableNestedScrollConnection$onPostFling$1;
        int i5;
        long m2709getZero9UxMQ8M;
        if (continuation instanceof ScrollableNestedScrollConnection$onPostFling$1) {
            scrollableNestedScrollConnection$onPostFling$1 = (ScrollableNestedScrollConnection$onPostFling$1) continuation;
            int i6 = scrollableNestedScrollConnection$onPostFling$1.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                scrollableNestedScrollConnection$onPostFling$1.label = i6 - Integer.MIN_VALUE;
                Object obj = scrollableNestedScrollConnection$onPostFling$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = scrollableNestedScrollConnection$onPostFling$1.label;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj);
                    if (!this.enabled) {
                        m2709getZero9UxMQ8M = Velocity.INSTANCE.m2709getZero9UxMQ8M();
                        return Velocity.m2695boximpl(m2709getZero9UxMQ8M);
                    }
                    ScrollingLogic scrollingLogic = this.scrollingLogic;
                    scrollableNestedScrollConnection$onPostFling$1.J$0 = j6;
                    scrollableNestedScrollConnection$onPostFling$1.label = 1;
                    obj = scrollingLogic.m229doFlingAnimationQWom1Mo(j6, scrollableNestedScrollConnection$onPostFling$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i5 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    j6 = scrollableNestedScrollConnection$onPostFling$1.J$0;
                    ResultKt.throwOnFailure(obj);
                }
                m2709getZero9UxMQ8M = Velocity.m2704minusAH228Gc(j6, ((Velocity) obj).getPackedValue());
                return Velocity.m2695boximpl(m2709getZero9UxMQ8M);
            }
        }
        scrollableNestedScrollConnection$onPostFling$1 = new ScrollableNestedScrollConnection$onPostFling$1(this, continuation);
        Object obj2 = scrollableNestedScrollConnection$onPostFling$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = scrollableNestedScrollConnection$onPostFling$1.label;
        if (i5 != 0) {
        }
        m2709getZero9UxMQ8M = Velocity.m2704minusAH228Gc(j6, ((Velocity) obj2).getPackedValue());
        return Velocity.m2695boximpl(m2709getZero9UxMQ8M);
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* renamed from: onPostScroll-DzOQY0M, reason: not valid java name */
    public long mo219onPostScrollDzOQY0M(long consumed, long available, int source) {
        return this.enabled ? this.scrollingLogic.m231performRawScrollMKHz9U(available) : Offset.INSTANCE.m1349getZeroF1C5BW0();
    }

    public final void setEnabled(boolean z5) {
        this.enabled = z5;
    }
}
