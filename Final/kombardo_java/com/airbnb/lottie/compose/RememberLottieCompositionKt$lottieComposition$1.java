package com.airbnb.lottie.compose;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.airbnb.lottie.compose.RememberLottieCompositionKt", f = "rememberLottieComposition.kt", l = {125, 126, 127}, m = "lottieComposition")
/* loaded from: classes.dex */
public final class RememberLottieCompositionKt$lottieComposition$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RememberLottieCompositionKt$lottieComposition$1(Continuation<? super RememberLottieCompositionKt$lottieComposition$1> continuation) {
        super(continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object lottieComposition;
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        lottieComposition = RememberLottieCompositionKt.lottieComposition(null, null, null, null, null, null, this);
        return lottieComposition;
    }
}
