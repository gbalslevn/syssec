package com.google.accompanist.web;

import android.support.v4.media.session.a;
import android.webkit.WebView;
import com.google.accompanist.web.WebViewNavigator;
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
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.MutableSharedFlow;
import org.conscrypt.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0001\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.google.accompanist.web.WebViewNavigator$handleNavigationEvents$2", f = "WebView.kt", l = {567}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class WebViewNavigator$handleNavigationEvents$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<?>, Object> {
    final /* synthetic */ WebView $this_handleNavigationEvents;
    int label;
    final /* synthetic */ WebViewNavigator this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WebViewNavigator$handleNavigationEvents$2(WebViewNavigator webViewNavigator, WebView webView, Continuation<? super WebViewNavigator$handleNavigationEvents$2> continuation) {
        super(2, continuation);
        this.this$0 = webViewNavigator;
        this.$this_handleNavigationEvents = webView;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new WebViewNavigator$handleNavigationEvents$2(this.this$0, this.$this_handleNavigationEvents, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        MutableSharedFlow mutableSharedFlow;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = this.label;
        if (i5 == 0) {
            ResultKt.throwOnFailure(obj);
            mutableSharedFlow = this.this$0.navigationEvents;
            final WebView webView = this.$this_handleNavigationEvents;
            FlowCollector flowCollector = new FlowCollector() { // from class: com.google.accompanist.web.WebViewNavigator$handleNavigationEvents$2.1
                @Override // kotlinx.coroutines.flow.FlowCollector
                public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                    a.a(obj2);
                    return emit((WebViewNavigator.NavigationEvent) null, (Continuation<? super Unit>) continuation);
                }

                public final Object emit(WebViewNavigator.NavigationEvent navigationEvent, Continuation<? super Unit> continuation) {
                    return Unit.INSTANCE;
                }
            };
            this.label = 1;
            if (mutableSharedFlow.collect(flowCollector, this) == coroutine_suspended) {
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
    public final Object invoke(CoroutineScope coroutineScope, Continuation<?> continuation) {
        return ((WebViewNavigator$handleNavigationEvents$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
