package androidx.compose.ui.viewinterop;

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
import kotlinx.coroutines.CoroutineScope;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.ui.viewinterop.AndroidViewHolder$onNestedFling$1", f = "AndroidViewHolder.android.kt", l = {565, 570}, m = "invokeSuspend")
/* loaded from: classes.dex */
final class AndroidViewHolder$onNestedFling$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $consumed;
    final /* synthetic */ long $viewVelocity;
    int label;
    final /* synthetic */ AndroidViewHolder this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AndroidViewHolder$onNestedFling$1(boolean z5, AndroidViewHolder androidViewHolder, long j5, Continuation<? super AndroidViewHolder$onNestedFling$1> continuation) {
        super(2, continuation);
        this.$consumed = z5;
        this.this$0 = androidViewHolder;
        this.$viewVelocity = j5;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AndroidViewHolder$onNestedFling$1(this.$consumed, this.this$0, this.$viewVelocity, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        NestedScrollDispatcher nestedScrollDispatcher;
        NestedScrollDispatcher nestedScrollDispatcher2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = this.label;
        if (i5 == 0) {
            ResultKt.throwOnFailure(obj);
            if (this.$consumed) {
                nestedScrollDispatcher = this.this$0.dispatcher;
                long j5 = this.$viewVelocity;
                long m2709getZero9UxMQ8M = Velocity.INSTANCE.m2709getZero9UxMQ8M();
                this.label = 2;
                if (nestedScrollDispatcher.m1835dispatchPostFlingRZ2iAVY(j5, m2709getZero9UxMQ8M, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                nestedScrollDispatcher2 = this.this$0.dispatcher;
                long m2709getZero9UxMQ8M2 = Velocity.INSTANCE.m2709getZero9UxMQ8M();
                long j6 = this.$viewVelocity;
                this.label = 1;
                if (nestedScrollDispatcher2.m1835dispatchPostFlingRZ2iAVY(m2709getZero9UxMQ8M2, j6, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        } else {
            if (i5 != 1 && i5 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((AndroidViewHolder$onNestedFling$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
