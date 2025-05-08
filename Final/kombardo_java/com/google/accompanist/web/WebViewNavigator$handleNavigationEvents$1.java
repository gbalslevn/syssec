package com.google.accompanist.web;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.google.accompanist.web.WebViewNavigator", f = "WebView.kt", l = {566}, m = "handleNavigationEvents$web_release")
/* loaded from: classes.dex */
public final class WebViewNavigator$handleNavigationEvents$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ WebViewNavigator this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WebViewNavigator$handleNavigationEvents$1(WebViewNavigator webViewNavigator, Continuation<? super WebViewNavigator$handleNavigationEvents$1> continuation) {
        super(continuation);
        this.this$0 = webViewNavigator;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.handleNavigationEvents$web_release(null, this);
    }
}
