package com.google.accompanist.web;

import android.webkit.WebView;
import kotlin.KotlinNothingValueException;
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

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.google.accompanist.web.WebViewKt$WebView$12$1", f = "WebView.kt", l = {191}, m = "invokeSuspend")
/* loaded from: classes.dex */
final class WebViewKt$WebView$12$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ WebViewNavigator $navigator;
    final /* synthetic */ WebView $wv;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WebViewKt$WebView$12$1(WebViewNavigator webViewNavigator, WebView webView, Continuation<? super WebViewKt$WebView$12$1> continuation) {
        super(2, continuation);
        this.$navigator = webViewNavigator;
        this.$wv = webView;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new WebViewKt$WebView$12$1(this.$navigator, this.$wv, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = this.label;
        if (i5 == 0) {
            ResultKt.throwOnFailure(obj);
            WebViewNavigator webViewNavigator = this.$navigator;
            WebView webView = this.$wv;
            this.label = 1;
            if (webViewNavigator.handleNavigationEvents$web_release(webView, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i5 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((WebViewKt$WebView$12$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
