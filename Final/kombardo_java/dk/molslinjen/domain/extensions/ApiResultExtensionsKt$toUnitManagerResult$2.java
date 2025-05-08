package dk.molslinjen.domain.extensions;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import org.conscrypt.BuildConfig;

/* JADX INFO: Add missing generic type declarations: [Incoming] */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u0002H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Incoming", "it"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "dk.molslinjen.domain.extensions.ApiResultExtensionsKt$toUnitManagerResult$2", f = "ApiResultExtensions.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes2.dex */
final class ApiResultExtensionsKt$toUnitManagerResult$2<Incoming> extends SuspendLambda implements Function2<Incoming, Continuation<? super Unit>, Object> {
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ApiResultExtensionsKt$toUnitManagerResult$2(Continuation<? super ApiResultExtensionsKt$toUnitManagerResult$2> continuation) {
        super(2, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ApiResultExtensionsKt$toUnitManagerResult$2(continuation);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Continuation<? super Unit> continuation) {
        return invoke2((ApiResultExtensionsKt$toUnitManagerResult$2<Incoming>) obj, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(Incoming incoming, Continuation<? super Unit> continuation) {
        return ((ApiResultExtensionsKt$toUnitManagerResult$2) create(incoming, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
