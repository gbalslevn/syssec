package com.airbnb.lottie.compose;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.airbnb.lottie.compose.RememberLottieCompositionKt$rememberLottieComposition$1", f = "rememberLottieComposition.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes.dex */
final class RememberLottieCompositionKt$rememberLottieComposition$1 extends SuspendLambda implements Function3<Integer, Throwable, Continuation<? super Boolean>, Object> {
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RememberLottieCompositionKt$rememberLottieComposition$1(Continuation<? super RememberLottieCompositionKt$rememberLottieComposition$1> continuation) {
        super(3, continuation);
    }

    public final Object invoke(int i5, Throwable th, Continuation<? super Boolean> continuation) {
        return new RememberLottieCompositionKt$rememberLottieComposition$1(continuation).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        return Boxing.boxBoolean(false);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(Integer num, Throwable th, Continuation<? super Boolean> continuation) {
        return invoke(num.intValue(), th, continuation);
    }
}
