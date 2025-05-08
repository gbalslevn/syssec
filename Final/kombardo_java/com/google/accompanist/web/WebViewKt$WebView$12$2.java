package com.google.accompanist.web;

import android.webkit.WebView;
import androidx.compose.runtime.SnapshotStateKt;
import com.google.accompanist.web.WebContent;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.google.accompanist.web.WebViewKt$WebView$12$2", f = "WebView.kt", l = {196}, m = "invokeSuspend")
/* loaded from: classes.dex */
final class WebViewKt$WebView$12$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ WebViewState $state;
    final /* synthetic */ WebView $wv;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WebViewKt$WebView$12$2(WebViewState webViewState, WebView webView, Continuation<? super WebViewKt$WebView$12$2> continuation) {
        super(2, continuation);
        this.$state = webViewState;
        this.$wv = webView;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new WebViewKt$WebView$12$2(this.$state, this.$wv, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i5 = this.label;
        if (i5 == 0) {
            ResultKt.throwOnFailure(obj);
            final WebViewState webViewState = this.$state;
            Flow snapshotFlow = SnapshotStateKt.snapshotFlow(new Function0<WebContent>() { // from class: com.google.accompanist.web.WebViewKt$WebView$12$2.1
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final WebContent invoke() {
                    return WebViewState.this.getContent();
                }
            });
            final WebView webView = this.$wv;
            FlowCollector flowCollector = new FlowCollector() { // from class: com.google.accompanist.web.WebViewKt$WebView$12$2.2
                @Override // kotlinx.coroutines.flow.FlowCollector
                public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                    return emit((WebContent) obj2, (Continuation<? super Unit>) continuation);
                }

                public final Object emit(WebContent webContent, Continuation<? super Unit> continuation) {
                    if (webContent instanceof WebContent.Url) {
                        WebContent.Url url = (WebContent.Url) webContent;
                        webView.loadUrl(url.getUrl(), url.getAdditionalHttpHeaders());
                    } else {
                        boolean z5 = webContent instanceof WebContent.NavigatorOnly;
                    }
                    return Unit.INSTANCE;
                }
            };
            this.label = 1;
            if (snapshotFlow.collect(flowCollector, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i5 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((WebViewKt$WebView$12$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
