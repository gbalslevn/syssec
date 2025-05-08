package androidx.compose.ui.input.nestedscroll;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.unit.Velocity;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.CoroutineScope;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006ø\u0001\u0000¢\u0006\u0004\b\b\u0010\tJ(\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006ø\u0001\u0000¢\u0006\u0004\b\f\u0010\rJ\u001b\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u000fH\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011J#\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u000fH\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014R$\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR*\u0010\u001f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001e0\u001d8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R$\u0010%\u001a\u0004\u0018\u00010\u001e8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u0011\u0010,\u001a\u00020\u001e8F¢\u0006\u0006\u001a\u0004\b+\u0010(R\u0016\u00100\u001a\u0004\u0018\u00010-8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b.\u0010/\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u00061"}, d2 = {"Landroidx/compose/ui/input/nestedscroll/NestedScrollDispatcher;", BuildConfig.FLAVOR, "<init>", "()V", "Landroidx/compose/ui/geometry/Offset;", "available", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "source", "dispatchPreScroll-OzD1aCk", "(JI)J", "dispatchPreScroll", "consumed", "dispatchPostScroll-DzOQY0M", "(JJI)J", "dispatchPostScroll", "Landroidx/compose/ui/unit/Velocity;", "dispatchPreFling-QWom1Mo", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "dispatchPreFling", "dispatchPostFling-RZ2iAVY", "(JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "dispatchPostFling", "Landroidx/compose/ui/input/nestedscroll/NestedScrollNode;", "nestedScrollNode", "Landroidx/compose/ui/input/nestedscroll/NestedScrollNode;", "getNestedScrollNode$ui_release", "()Landroidx/compose/ui/input/nestedscroll/NestedScrollNode;", "setNestedScrollNode$ui_release", "(Landroidx/compose/ui/input/nestedscroll/NestedScrollNode;)V", "Lkotlin/Function0;", "Lkotlinx/coroutines/CoroutineScope;", "calculateNestedScrollScope", "Lkotlin/jvm/functions/Function0;", "getCalculateNestedScrollScope$ui_release", "()Lkotlin/jvm/functions/Function0;", "setCalculateNestedScrollScope$ui_release", "(Lkotlin/jvm/functions/Function0;)V", "scope", "Lkotlinx/coroutines/CoroutineScope;", "getScope$ui_release", "()Lkotlinx/coroutines/CoroutineScope;", "setScope$ui_release", "(Lkotlinx/coroutines/CoroutineScope;)V", "getCoroutineScope", "coroutineScope", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "getParent$ui_release", "()Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "parent", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class NestedScrollDispatcher {
    private Function0<? extends CoroutineScope> calculateNestedScrollScope = new Function0<CoroutineScope>() { // from class: androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher$calculateNestedScrollScope$1
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final CoroutineScope invoke() {
            return NestedScrollDispatcher.this.getScope();
        }
    };
    private NestedScrollNode nestedScrollNode;
    private CoroutineScope scope;

    /* JADX WARN: Removed duplicated region for block: B:17:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0025  */
    /* renamed from: dispatchPostFling-RZ2iAVY, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object m1835dispatchPostFlingRZ2iAVY(long j5, long j6, Continuation<? super Velocity> continuation) {
        NestedScrollDispatcher$dispatchPostFling$1 nestedScrollDispatcher$dispatchPostFling$1;
        int i5;
        long m2709getZero9UxMQ8M;
        if (continuation instanceof NestedScrollDispatcher$dispatchPostFling$1) {
            nestedScrollDispatcher$dispatchPostFling$1 = (NestedScrollDispatcher$dispatchPostFling$1) continuation;
            int i6 = nestedScrollDispatcher$dispatchPostFling$1.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                nestedScrollDispatcher$dispatchPostFling$1.label = i6 - Integer.MIN_VALUE;
                NestedScrollDispatcher$dispatchPostFling$1 nestedScrollDispatcher$dispatchPostFling$12 = nestedScrollDispatcher$dispatchPostFling$1;
                Object obj = nestedScrollDispatcher$dispatchPostFling$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = nestedScrollDispatcher$dispatchPostFling$12.label;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj);
                    NestedScrollConnection parent$ui_release = getParent$ui_release();
                    if (parent$ui_release == null) {
                        m2709getZero9UxMQ8M = Velocity.INSTANCE.m2709getZero9UxMQ8M();
                        return Velocity.m2695boximpl(m2709getZero9UxMQ8M);
                    }
                    nestedScrollDispatcher$dispatchPostFling$12.label = 1;
                    obj = parent$ui_release.mo218onPostFlingRZ2iAVY(j5, j6, nestedScrollDispatcher$dispatchPostFling$12);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i5 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                m2709getZero9UxMQ8M = ((Velocity) obj).getPackedValue();
                return Velocity.m2695boximpl(m2709getZero9UxMQ8M);
            }
        }
        nestedScrollDispatcher$dispatchPostFling$1 = new NestedScrollDispatcher$dispatchPostFling$1(this, continuation);
        NestedScrollDispatcher$dispatchPostFling$1 nestedScrollDispatcher$dispatchPostFling$122 = nestedScrollDispatcher$dispatchPostFling$1;
        Object obj2 = nestedScrollDispatcher$dispatchPostFling$122.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = nestedScrollDispatcher$dispatchPostFling$122.label;
        if (i5 != 0) {
        }
        m2709getZero9UxMQ8M = ((Velocity) obj2).getPackedValue();
        return Velocity.m2695boximpl(m2709getZero9UxMQ8M);
    }

    /* renamed from: dispatchPostScroll-DzOQY0M, reason: not valid java name */
    public final long m1836dispatchPostScrollDzOQY0M(long consumed, long available, int source) {
        NestedScrollConnection parent$ui_release = getParent$ui_release();
        return parent$ui_release != null ? parent$ui_release.mo219onPostScrollDzOQY0M(consumed, available, source) : Offset.INSTANCE.m1349getZeroF1C5BW0();
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /* renamed from: dispatchPreFling-QWom1Mo, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object m1837dispatchPreFlingQWom1Mo(long j5, Continuation<? super Velocity> continuation) {
        NestedScrollDispatcher$dispatchPreFling$1 nestedScrollDispatcher$dispatchPreFling$1;
        int i5;
        long m2709getZero9UxMQ8M;
        if (continuation instanceof NestedScrollDispatcher$dispatchPreFling$1) {
            nestedScrollDispatcher$dispatchPreFling$1 = (NestedScrollDispatcher$dispatchPreFling$1) continuation;
            int i6 = nestedScrollDispatcher$dispatchPreFling$1.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                nestedScrollDispatcher$dispatchPreFling$1.label = i6 - Integer.MIN_VALUE;
                Object obj = nestedScrollDispatcher$dispatchPreFling$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = nestedScrollDispatcher$dispatchPreFling$1.label;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj);
                    NestedScrollConnection parent$ui_release = getParent$ui_release();
                    if (parent$ui_release == null) {
                        m2709getZero9UxMQ8M = Velocity.INSTANCE.m2709getZero9UxMQ8M();
                        return Velocity.m2695boximpl(m2709getZero9UxMQ8M);
                    }
                    nestedScrollDispatcher$dispatchPreFling$1.label = 1;
                    obj = parent$ui_release.mo711onPreFlingQWom1Mo(j5, nestedScrollDispatcher$dispatchPreFling$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i5 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                m2709getZero9UxMQ8M = ((Velocity) obj).getPackedValue();
                return Velocity.m2695boximpl(m2709getZero9UxMQ8M);
            }
        }
        nestedScrollDispatcher$dispatchPreFling$1 = new NestedScrollDispatcher$dispatchPreFling$1(this, continuation);
        Object obj2 = nestedScrollDispatcher$dispatchPreFling$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = nestedScrollDispatcher$dispatchPreFling$1.label;
        if (i5 != 0) {
        }
        m2709getZero9UxMQ8M = ((Velocity) obj2).getPackedValue();
        return Velocity.m2695boximpl(m2709getZero9UxMQ8M);
    }

    /* renamed from: dispatchPreScroll-OzD1aCk, reason: not valid java name */
    public final long m1838dispatchPreScrollOzD1aCk(long available, int source) {
        NestedScrollConnection parent$ui_release = getParent$ui_release();
        return parent$ui_release != null ? parent$ui_release.mo435onPreScrollOzD1aCk(available, source) : Offset.INSTANCE.m1349getZeroF1C5BW0();
    }

    public final CoroutineScope getCoroutineScope() {
        CoroutineScope invoke = this.calculateNestedScrollScope.invoke();
        if (invoke != null) {
            return invoke;
        }
        throw new IllegalStateException("in order to access nested coroutine scope you need to attach dispatcher to the `Modifier.nestedScroll` first.");
    }

    /* renamed from: getNestedScrollNode$ui_release, reason: from getter */
    public final NestedScrollNode getNestedScrollNode() {
        return this.nestedScrollNode;
    }

    public final NestedScrollConnection getParent$ui_release() {
        NestedScrollNode nestedScrollNode = this.nestedScrollNode;
        if (nestedScrollNode != null) {
            return nestedScrollNode.getParentNestedScrollNode$ui_release();
        }
        return null;
    }

    /* renamed from: getScope$ui_release, reason: from getter */
    public final CoroutineScope getScope() {
        return this.scope;
    }

    public final void setCalculateNestedScrollScope$ui_release(Function0<? extends CoroutineScope> function0) {
        this.calculateNestedScrollScope = function0;
    }

    public final void setNestedScrollNode$ui_release(NestedScrollNode nestedScrollNode) {
        this.nestedScrollNode = nestedScrollNode;
    }

    public final void setScope$ui_release(CoroutineScope coroutineScope) {
        this.scope = coroutineScope;
    }
}
