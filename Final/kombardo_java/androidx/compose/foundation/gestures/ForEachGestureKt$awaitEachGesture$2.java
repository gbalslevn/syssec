package androidx.compose.foundation.gestures;

import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.JobKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.gestures.ForEachGestureKt$awaitEachGesture$2", f = "ForEachGesture.kt", l = {104, 107, 112}, m = "invokeSuspend")
/* loaded from: classes.dex */
final class ForEachGestureKt$awaitEachGesture$2 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> $block;
    final /* synthetic */ CoroutineContext $currentContext;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ForEachGestureKt$awaitEachGesture$2(CoroutineContext coroutineContext, Function2<? super AwaitPointerEventScope, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super ForEachGestureKt$awaitEachGesture$2> continuation) {
        super(2, continuation);
        this.$currentContext = coroutineContext;
        this.$block = function2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ForEachGestureKt$awaitEachGesture$2 forEachGestureKt$awaitEachGesture$2 = new ForEachGestureKt$awaitEachGesture$2(this.$currentContext, this.$block, continuation);
        forEachGestureKt$awaitEachGesture$2.L$0 = obj;
        return forEachGestureKt$awaitEachGesture$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
        return ((ForEachGestureKt$awaitEachGesture$2) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0043 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x005b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0073  */
    /* JADX WARN: Type inference failed for: r1v0, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1 */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v2, types: [androidx.compose.ui.input.pointer.AwaitPointerEventScope, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v22 */
    /* JADX WARN: Type inference failed for: r1v3, types: [androidx.compose.ui.input.pointer.AwaitPointerEventScope, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x0059 -> B:8:0x0028). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x0070 -> B:8:0x0028). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        Object awaitAllPointersUp;
        AwaitPointerEventScope awaitPointerEventScope;
        AwaitPointerEventScope awaitPointerEventScope2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ?? r12 = this.label;
        try {
        } catch (CancellationException e5) {
            e = e5;
            if (JobKt.isActive(this.$currentContext)) {
            }
        }
        if (r12 == 0) {
            ResultKt.throwOnFailure(obj);
            awaitPointerEventScope = (AwaitPointerEventScope) this.L$0;
            if (JobKt.isActive(this.$currentContext)) {
            }
        } else if (r12 != 1) {
            if (r12 == 2) {
                AwaitPointerEventScope awaitPointerEventScope3 = (AwaitPointerEventScope) this.L$0;
                ResultKt.throwOnFailure(obj);
                awaitPointerEventScope2 = awaitPointerEventScope3;
            } else {
                if (r12 != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AwaitPointerEventScope awaitPointerEventScope4 = (AwaitPointerEventScope) this.L$0;
                ResultKt.throwOnFailure(obj);
                awaitPointerEventScope2 = awaitPointerEventScope4;
            }
            awaitPointerEventScope = awaitPointerEventScope2;
            if (JobKt.isActive(this.$currentContext)) {
                try {
                } catch (CancellationException e6) {
                    r12 = awaitPointerEventScope;
                    e = e6;
                    if (JobKt.isActive(this.$currentContext)) {
                        throw e;
                    }
                    this.L$0 = r12;
                    this.label = 3;
                    Object awaitAllPointersUp2 = ForEachGestureKt.awaitAllPointersUp(r12, this);
                    awaitPointerEventScope2 = r12;
                    if (awaitAllPointersUp2 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    awaitPointerEventScope = awaitPointerEventScope2;
                    if (JobKt.isActive(this.$currentContext)) {
                    }
                }
                Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> function2 = this.$block;
                this.L$0 = awaitPointerEventScope;
                this.label = 1;
                if (function2.invoke(awaitPointerEventScope, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                r12 = awaitPointerEventScope;
                this.L$0 = r12;
                this.label = 2;
                awaitAllPointersUp = ForEachGestureKt.awaitAllPointersUp(r12, this);
                awaitPointerEventScope2 = r12;
                if (awaitAllPointersUp == coroutine_suspended) {
                    return coroutine_suspended;
                }
                awaitPointerEventScope = awaitPointerEventScope2;
                if (JobKt.isActive(this.$currentContext)) {
                    return Unit.INSTANCE;
                }
            }
        } else {
            AwaitPointerEventScope awaitPointerEventScope5 = (AwaitPointerEventScope) this.L$0;
            ResultKt.throwOnFailure(obj);
            r12 = awaitPointerEventScope5;
            this.L$0 = r12;
            this.label = 2;
            awaitAllPointersUp = ForEachGestureKt.awaitAllPointersUp(r12, this);
            awaitPointerEventScope2 = r12;
            if (awaitAllPointersUp == coroutine_suspended) {
            }
            awaitPointerEventScope = awaitPointerEventScope2;
            if (JobKt.isActive(this.$currentContext)) {
            }
        }
    }
}
