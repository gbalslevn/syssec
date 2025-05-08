package dk.molslinjen.domain.extensions;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: Add missing generic type declarations: [Incoming, Result] */
@Metadata(d1 = {"\u0000\u0004\n\u0002\b\u0004\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001\"\u0004\b\u0001\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u0002H\n"}, d2 = {"<anonymous>", "Result", "Incoming", "it"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.domain.extensions.ApiResultExtensionsKt$mapToManagerResult$2", f = "ApiResultExtensions.kt", l = {9}, m = "invokeSuspend")
/* loaded from: classes2.dex */
final class ApiResultExtensionsKt$mapToManagerResult$2<Incoming, Result> extends SuspendLambda implements Function2<Incoming, Continuation<? super Result>, Object> {
    final /* synthetic */ Function2<Incoming, Continuation<? super Result>, Object> $block;
    /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ApiResultExtensionsKt$mapToManagerResult$2(Function2<? super Incoming, ? super Continuation<? super Result>, ? extends Object> function2, Continuation<? super ApiResultExtensionsKt$mapToManagerResult$2> continuation) {
        super(2, continuation);
        this.$block = function2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ApiResultExtensionsKt$mapToManagerResult$2 apiResultExtensionsKt$mapToManagerResult$2 = new ApiResultExtensionsKt$mapToManagerResult$2(this.$block, continuation);
        apiResultExtensionsKt$mapToManagerResult$2.L$0 = obj;
        return apiResultExtensionsKt$mapToManagerResult$2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return invoke((ApiResultExtensionsKt$mapToManagerResult$2<Incoming, Result>) obj, (Continuation) obj2);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = this.label;
        if (i5 == 0) {
            ResultKt.throwOnFailure(obj);
            Object obj2 = this.L$0;
            Function2<Incoming, Continuation<? super Result>, Object> function2 = this.$block;
            this.label = 1;
            obj = function2.invoke(obj2, this);
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

    public final Object invoke(Incoming incoming, Continuation<? super Result> continuation) {
        return ((ApiResultExtensionsKt$mapToManagerResult$2) create(incoming, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
