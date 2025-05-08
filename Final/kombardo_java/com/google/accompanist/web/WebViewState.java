package com.google.accompanist.web;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.webkit.WebView;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import com.google.accompanist.web.LoadingState;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Deprecated
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R/\u0010\u000e\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00068F@@X\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR+\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00028F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u000f\u0010\t\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0005R+\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u0007\u001a\u00020\u00148F@@X\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u0015\u0010\t\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R/\u0010\u001e\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00068F@@X\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u001b\u0010\t\u001a\u0004\b\u001c\u0010\u000b\"\u0004\b\u001d\u0010\rR/\u0010%\u001a\u0004\u0018\u00010\u001f2\b\u0010\u0007\u001a\u0004\u0018\u00010\u001f8F@@X\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b \u0010\t\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001d\u0010(\u001a\b\u0012\u0004\u0012\u00020'0&8\u0006¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+R.\u0010-\u001a\u0004\u0018\u00010,2\b\u0010\u0007\u001a\u0004\u0018\u00010,8\u0006@@X\u0086\u000e¢\u0006\u0012\n\u0004\b-\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u00102R/\u00109\u001a\u0004\u0018\u0001032\b\u0010\u0007\u001a\u0004\u0018\u0001038@@@X\u0080\u008e\u0002¢\u0006\u0012\n\u0004\b4\u0010\t\u001a\u0004\b5\u00106\"\u0004\b7\u00108¨\u0006:"}, d2 = {"Lcom/google/accompanist/web/WebViewState;", BuildConfig.FLAVOR, "Lcom/google/accompanist/web/WebContent;", "webContent", "<init>", "(Lcom/google/accompanist/web/WebContent;)V", BuildConfig.FLAVOR, "<set-?>", "lastLoadedUrl$delegate", "Landroidx/compose/runtime/MutableState;", "getLastLoadedUrl", "()Ljava/lang/String;", "setLastLoadedUrl$web_release", "(Ljava/lang/String;)V", "lastLoadedUrl", "content$delegate", "getContent", "()Lcom/google/accompanist/web/WebContent;", "setContent", "content", "Lcom/google/accompanist/web/LoadingState;", "loadingState$delegate", "getLoadingState", "()Lcom/google/accompanist/web/LoadingState;", "setLoadingState$web_release", "(Lcom/google/accompanist/web/LoadingState;)V", "loadingState", "pageTitle$delegate", "getPageTitle", "setPageTitle$web_release", "pageTitle", "Landroid/graphics/Bitmap;", "pageIcon$delegate", "getPageIcon", "()Landroid/graphics/Bitmap;", "setPageIcon$web_release", "(Landroid/graphics/Bitmap;)V", "pageIcon", "Landroidx/compose/runtime/snapshots/SnapshotStateList;", "Lcom/google/accompanist/web/WebViewError;", "errorsForCurrentRequest", "Landroidx/compose/runtime/snapshots/SnapshotStateList;", "getErrorsForCurrentRequest", "()Landroidx/compose/runtime/snapshots/SnapshotStateList;", "Landroid/os/Bundle;", "viewState", "Landroid/os/Bundle;", "getViewState", "()Landroid/os/Bundle;", "setViewState$web_release", "(Landroid/os/Bundle;)V", "Landroid/webkit/WebView;", "webView$delegate", "getWebView$web_release", "()Landroid/webkit/WebView;", "setWebView$web_release", "(Landroid/webkit/WebView;)V", "webView", "web_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class WebViewState {

    /* renamed from: content$delegate, reason: from kotlin metadata */
    private final MutableState content;
    private final SnapshotStateList<WebViewError> errorsForCurrentRequest;

    /* renamed from: lastLoadedUrl$delegate, reason: from kotlin metadata */
    private final MutableState lastLoadedUrl;

    /* renamed from: loadingState$delegate, reason: from kotlin metadata */
    private final MutableState loadingState;

    /* renamed from: pageIcon$delegate, reason: from kotlin metadata */
    private final MutableState pageIcon;

    /* renamed from: pageTitle$delegate, reason: from kotlin metadata */
    private final MutableState pageTitle;
    private Bundle viewState;

    /* renamed from: webView$delegate, reason: from kotlin metadata */
    private final MutableState webView;

    public WebViewState(WebContent webContent) {
        MutableState mutableStateOf$default;
        MutableState mutableStateOf$default2;
        MutableState mutableStateOf$default3;
        MutableState mutableStateOf$default4;
        MutableState mutableStateOf$default5;
        MutableState mutableStateOf$default6;
        Intrinsics.checkNotNullParameter(webContent, "webContent");
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.lastLoadedUrl = mutableStateOf$default;
        mutableStateOf$default2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(webContent, null, 2, null);
        this.content = mutableStateOf$default2;
        mutableStateOf$default3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(LoadingState.Initializing.INSTANCE, null, 2, null);
        this.loadingState = mutableStateOf$default3;
        mutableStateOf$default4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.pageTitle = mutableStateOf$default4;
        mutableStateOf$default5 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.pageIcon = mutableStateOf$default5;
        this.errorsForCurrentRequest = SnapshotStateKt.mutableStateListOf();
        mutableStateOf$default6 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.webView = mutableStateOf$default6;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final WebContent getContent() {
        return (WebContent) this.content.getValue();
    }

    public final SnapshotStateList<WebViewError> getErrorsForCurrentRequest() {
        return this.errorsForCurrentRequest;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final String getLastLoadedUrl() {
        return (String) this.lastLoadedUrl.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final LoadingState getLoadingState() {
        return (LoadingState) this.loadingState.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final String getPageTitle() {
        return (String) this.pageTitle.getValue();
    }

    public final Bundle getViewState() {
        return this.viewState;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final WebView getWebView$web_release() {
        return (WebView) this.webView.getValue();
    }

    public final void setContent(WebContent webContent) {
        Intrinsics.checkNotNullParameter(webContent, "<set-?>");
        this.content.setValue(webContent);
    }

    public final void setLastLoadedUrl$web_release(String str) {
        this.lastLoadedUrl.setValue(str);
    }

    public final void setLoadingState$web_release(LoadingState loadingState) {
        Intrinsics.checkNotNullParameter(loadingState, "<set-?>");
        this.loadingState.setValue(loadingState);
    }

    public final void setPageIcon$web_release(Bitmap bitmap) {
        this.pageIcon.setValue(bitmap);
    }

    public final void setPageTitle$web_release(String str) {
        this.pageTitle.setValue(str);
    }

    public final void setViewState$web_release(Bundle bundle) {
        this.viewState = bundle;
    }

    public final void setWebView$web_release(WebView webView) {
        this.webView.setValue(webView);
    }
}
