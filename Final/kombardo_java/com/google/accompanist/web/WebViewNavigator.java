package com.google.accompanist.web;

import android.webkit.WebView;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import kotlin.Deprecated;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import org.conscrypt.BuildConfig;

@Deprecated
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\b\u0007\u0018\u00002\u00020\u0001:\u0001\u001dB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0014\u0010\n\u001a\u00020\u0007*\u00020\u0006H\u0080@¢\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u000bR\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR+\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00108F@@X\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R+\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00108F@@X\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u0019\u0010\u0013\u001a\u0004\b\u001a\u0010\u0015\"\u0004\b\u001b\u0010\u0017¨\u0006\u001e"}, d2 = {"Lcom/google/accompanist/web/WebViewNavigator;", BuildConfig.FLAVOR, "Lkotlinx/coroutines/CoroutineScope;", "coroutineScope", "<init>", "(Lkotlinx/coroutines/CoroutineScope;)V", "Landroid/webkit/WebView;", BuildConfig.FLAVOR, "handleNavigationEvents$web_release", "(Landroid/webkit/WebView;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handleNavigationEvents", "Lkotlinx/coroutines/CoroutineScope;", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lcom/google/accompanist/web/WebViewNavigator$NavigationEvent;", "navigationEvents", "Lkotlinx/coroutines/flow/MutableSharedFlow;", BuildConfig.FLAVOR, "<set-?>", "canGoBack$delegate", "Landroidx/compose/runtime/MutableState;", "getCanGoBack", "()Z", "setCanGoBack$web_release", "(Z)V", "canGoBack", "canGoForward$delegate", "getCanGoForward", "setCanGoForward$web_release", "canGoForward", "NavigationEvent", "web_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class WebViewNavigator {

    /* renamed from: canGoBack$delegate, reason: from kotlin metadata */
    private final MutableState canGoBack;

    /* renamed from: canGoForward$delegate, reason: from kotlin metadata */
    private final MutableState canGoForward;
    private final CoroutineScope coroutineScope;
    private final MutableSharedFlow<NavigationEvent> navigationEvents;

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\br\u0018\u00002\u00020\u0001ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0002À\u0006\u0001"}, d2 = {"Lcom/google/accompanist/web/WebViewNavigator$NavigationEvent;", BuildConfig.FLAVOR, "web_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes.dex */
    public interface NavigationEvent {
    }

    public WebViewNavigator(CoroutineScope coroutineScope) {
        MutableState mutableStateOf$default;
        MutableState mutableStateOf$default2;
        Intrinsics.checkNotNullParameter(coroutineScope, "coroutineScope");
        this.coroutineScope = coroutineScope;
        this.navigationEvents = SharedFlowKt.MutableSharedFlow$default(1, 0, null, 6, null);
        Boolean bool = Boolean.FALSE;
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(bool, null, 2, null);
        this.canGoBack = mutableStateOf$default;
        mutableStateOf$default2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(bool, null, 2, null);
        this.canGoForward = mutableStateOf$default2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean getCanGoBack() {
        return ((Boolean) this.canGoBack.getValue()).booleanValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object handleNavigationEvents$web_release(WebView webView, Continuation<?> continuation) {
        WebViewNavigator$handleNavigationEvents$1 webViewNavigator$handleNavigationEvents$1;
        int i5;
        if (continuation instanceof WebViewNavigator$handleNavigationEvents$1) {
            webViewNavigator$handleNavigationEvents$1 = (WebViewNavigator$handleNavigationEvents$1) continuation;
            int i6 = webViewNavigator$handleNavigationEvents$1.label;
            if ((i6 & Integer.MIN_VALUE) != 0) {
                webViewNavigator$handleNavigationEvents$1.label = i6 - Integer.MIN_VALUE;
                Object obj = webViewNavigator$handleNavigationEvents$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i5 = webViewNavigator$handleNavigationEvents$1.label;
                if (i5 != 0) {
                    ResultKt.throwOnFailure(obj);
                    MainCoroutineDispatcher main = Dispatchers.getMain();
                    WebViewNavigator$handleNavigationEvents$2 webViewNavigator$handleNavigationEvents$2 = new WebViewNavigator$handleNavigationEvents$2(this, webView, null);
                    webViewNavigator$handleNavigationEvents$1.label = 1;
                    if (BuildersKt.withContext(main, webViewNavigator$handleNavigationEvents$2, webViewNavigator$handleNavigationEvents$1) == coroutine_suspended) {
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
        }
        webViewNavigator$handleNavigationEvents$1 = new WebViewNavigator$handleNavigationEvents$1(this, continuation);
        Object obj2 = webViewNavigator$handleNavigationEvents$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = webViewNavigator$handleNavigationEvents$1.label;
        if (i5 != 0) {
        }
        throw new KotlinNothingValueException();
    }

    public final void setCanGoBack$web_release(boolean z5) {
        this.canGoBack.setValue(Boolean.valueOf(z5));
    }

    public final void setCanGoForward$web_release(boolean z5) {
        this.canGoForward.setValue(Boolean.valueOf(z5));
    }
}
