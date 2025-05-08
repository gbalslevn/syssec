package com.airbnb.lottie.compose;

import android.content.Context;
import androidx.compose.runtime.MutableState;
import com.airbnb.lottie.LottieComposition;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "com.airbnb.lottie.compose.RememberLottieCompositionKt$rememberLottieComposition$3", f = "rememberLottieComposition.kt", l = {90, 92}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class RememberLottieCompositionKt$rememberLottieComposition$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $cacheKey;
    final /* synthetic */ Context $context;
    final /* synthetic */ String $fontAssetsFolder;
    final /* synthetic */ String $fontFileExtension;
    final /* synthetic */ String $imageAssetsFolder;
    final /* synthetic */ Function3<Integer, Throwable, Continuation<? super Boolean>, Object> $onRetry;
    final /* synthetic */ MutableState<LottieCompositionResultImpl> $result$delegate;
    final /* synthetic */ LottieCompositionSpec $spec;
    int I$0;
    Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public RememberLottieCompositionKt$rememberLottieComposition$3(Function3<? super Integer, ? super Throwable, ? super Continuation<? super Boolean>, ? extends Object> function3, Context context, LottieCompositionSpec lottieCompositionSpec, String str, String str2, String str3, String str4, MutableState<LottieCompositionResultImpl> mutableState, Continuation<? super RememberLottieCompositionKt$rememberLottieComposition$3> continuation) {
        super(2, continuation);
        this.$onRetry = function3;
        this.$context = context;
        this.$spec = lottieCompositionSpec;
        this.$imageAssetsFolder = str;
        this.$fontAssetsFolder = str2;
        this.$fontFileExtension = str3;
        this.$cacheKey = str4;
        this.$result$delegate = mutableState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new RememberLottieCompositionKt$rememberLottieComposition$3(this.$onRetry, this.$context, this.$spec, this.$imageAssetsFolder, this.$fontAssetsFolder, this.$fontFileExtension, this.$cacheKey, this.$result$delegate, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x005e, code lost:
    
        if (((java.lang.Boolean) r13).booleanValue() == false) goto L29;
     */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0040  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0083 -> B:8:0x0086). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        int i5;
        Throwable th;
        LottieCompositionResultImpl m2768rememberLottieComposition$lambda1;
        LottieCompositionResultImpl m2768rememberLottieComposition$lambda12;
        String ensureTrailingSlash;
        String ensureTrailingSlash2;
        String ensureLeadingPeriod;
        LottieCompositionResultImpl m2768rememberLottieComposition$lambda13;
        LottieCompositionResultImpl m2768rememberLottieComposition$lambda14;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i6 = this.label;
        if (i6 == 0) {
            ResultKt.throwOnFailure(obj);
            i5 = 0;
            th = null;
            m2768rememberLottieComposition$lambda13 = RememberLottieCompositionKt.m2768rememberLottieComposition$lambda1(this.$result$delegate);
            if (!m2768rememberLottieComposition$lambda13.isSuccess()) {
            }
            m2768rememberLottieComposition$lambda1 = RememberLottieCompositionKt.m2768rememberLottieComposition$lambda1(this.$result$delegate);
            if (!m2768rememberLottieComposition$lambda1.isComplete()) {
                m2768rememberLottieComposition$lambda12 = RememberLottieCompositionKt.m2768rememberLottieComposition$lambda1(this.$result$delegate);
                m2768rememberLottieComposition$lambda12.completeExceptionally$lottie_compose_release(th);
            }
            return Unit.INSTANCE;
        }
        if (i6 != 1) {
            if (i6 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            i5 = this.I$0;
            th = (Throwable) this.L$0;
            try {
                ResultKt.throwOnFailure(obj);
            } catch (Throwable th2) {
                th = th2;
                i5++;
            }
            m2768rememberLottieComposition$lambda14 = RememberLottieCompositionKt.m2768rememberLottieComposition$lambda1(this.$result$delegate);
            m2768rememberLottieComposition$lambda14.complete$lottie_compose_release((LottieComposition) obj);
            m2768rememberLottieComposition$lambda13 = RememberLottieCompositionKt.m2768rememberLottieComposition$lambda1(this.$result$delegate);
            if (!m2768rememberLottieComposition$lambda13.isSuccess()) {
                if (i5 != 0) {
                    Function3<Integer, Throwable, Continuation<? super Boolean>, Object> function3 = this.$onRetry;
                    Integer boxInt = Boxing.boxInt(i5);
                    Intrinsics.checkNotNull(th);
                    this.L$0 = th;
                    this.I$0 = i5;
                    this.label = 1;
                    obj = function3.invoke(boxInt, th, this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                Context context = this.$context;
                LottieCompositionSpec lottieCompositionSpec = this.$spec;
                ensureTrailingSlash = RememberLottieCompositionKt.ensureTrailingSlash(this.$imageAssetsFolder);
                ensureTrailingSlash2 = RememberLottieCompositionKt.ensureTrailingSlash(this.$fontAssetsFolder);
                ensureLeadingPeriod = RememberLottieCompositionKt.ensureLeadingPeriod(this.$fontFileExtension);
                String str = this.$cacheKey;
                this.L$0 = th;
                this.I$0 = i5;
                this.label = 2;
                obj = RememberLottieCompositionKt.lottieComposition(context, lottieCompositionSpec, ensureTrailingSlash, ensureTrailingSlash2, ensureLeadingPeriod, str, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                m2768rememberLottieComposition$lambda14 = RememberLottieCompositionKt.m2768rememberLottieComposition$lambda1(this.$result$delegate);
                m2768rememberLottieComposition$lambda14.complete$lottie_compose_release((LottieComposition) obj);
                m2768rememberLottieComposition$lambda13 = RememberLottieCompositionKt.m2768rememberLottieComposition$lambda1(this.$result$delegate);
                if (!m2768rememberLottieComposition$lambda13.isSuccess()) {
                }
            }
            m2768rememberLottieComposition$lambda1 = RememberLottieCompositionKt.m2768rememberLottieComposition$lambda1(this.$result$delegate);
            if (!m2768rememberLottieComposition$lambda1.isComplete() && th != null) {
                m2768rememberLottieComposition$lambda12 = RememberLottieCompositionKt.m2768rememberLottieComposition$lambda1(this.$result$delegate);
                m2768rememberLottieComposition$lambda12.completeExceptionally$lottie_compose_release(th);
            }
            return Unit.INSTANCE;
        }
        i5 = this.I$0;
        th = (Throwable) this.L$0;
        ResultKt.throwOnFailure(obj);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((RememberLottieCompositionKt$rememberLottieComposition$3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
