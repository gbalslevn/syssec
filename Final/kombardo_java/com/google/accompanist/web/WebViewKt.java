package com.google.accompanist.web;

import android.content.Context;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.FrameLayout;
import androidx.compose.foundation.layout.BoxWithConstraintsKt;
import androidx.compose.foundation.layout.BoxWithConstraintsScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.MapSaverKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.viewinterop.AndroidView_androidKt;
import androidx.view.compose.BackHandlerKt;
import com.google.accompanist.web.WebContent;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\u001a\u008d\u0001\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\u0014\b\u0002\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b2\u0014\b\u0002\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b2\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\u0016\b\u0002\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\t\u0018\u00010\bH\u0007¢\u0006\u0004\b\u0013\u0010\u0014\u001a\u0095\u0001\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u00152\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\u0014\b\u0002\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b2\u0014\b\u0002\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b2\b\b\u0002\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\u0016\b\u0002\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\t\u0018\u00010\bH\u0007¢\u0006\u0004\b\u0013\u0010\u0017\u001a\u0019\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\u0019\u001a\u00020\u0018H\u0007¢\u0006\u0004\b\u001a\u0010\u001b\u001a-\u0010 \u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u001c2\u0014\b\u0002\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001c0\u001eH\u0007¢\u0006\u0004\b \u0010!\",\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020#0\"8\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b$\u0010%\u0012\u0004\b(\u0010)\u001a\u0004\b&\u0010'¨\u0006*"}, d2 = {"Lcom/google/accompanist/web/WebViewState;", "state", "Landroidx/compose/ui/Modifier;", "modifier", BuildConfig.FLAVOR, "captureBackPresses", "Lcom/google/accompanist/web/WebViewNavigator;", "navigator", "Lkotlin/Function1;", "Landroid/webkit/WebView;", BuildConfig.FLAVOR, "onCreated", "onDispose", "Lcom/google/accompanist/web/AccompanistWebViewClient;", "client", "Lcom/google/accompanist/web/AccompanistWebChromeClient;", "chromeClient", "Landroid/content/Context;", "factory", "WebView", "(Lcom/google/accompanist/web/WebViewState;Landroidx/compose/ui/Modifier;ZLcom/google/accompanist/web/WebViewNavigator;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lcom/google/accompanist/web/AccompanistWebViewClient;Lcom/google/accompanist/web/AccompanistWebChromeClient;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "Landroid/widget/FrameLayout$LayoutParams;", "layoutParams", "(Lcom/google/accompanist/web/WebViewState;Landroid/widget/FrameLayout$LayoutParams;Landroidx/compose/ui/Modifier;ZLcom/google/accompanist/web/WebViewNavigator;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lcom/google/accompanist/web/AccompanistWebViewClient;Lcom/google/accompanist/web/AccompanistWebChromeClient;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "Lkotlinx/coroutines/CoroutineScope;", "coroutineScope", "rememberWebViewNavigator", "(Lkotlinx/coroutines/CoroutineScope;Landroidx/compose/runtime/Composer;II)Lcom/google/accompanist/web/WebViewNavigator;", BuildConfig.FLAVOR, "url", BuildConfig.FLAVOR, "additionalHttpHeaders", "rememberWebViewState", "(Ljava/lang/String;Ljava/util/Map;Landroidx/compose/runtime/Composer;II)Lcom/google/accompanist/web/WebViewState;", "Landroidx/compose/runtime/saveable/Saver;", BuildConfig.FLAVOR, "WebStateSaver", "Landroidx/compose/runtime/saveable/Saver;", "getWebStateSaver", "()Landroidx/compose/runtime/saveable/Saver;", "getWebStateSaver$annotations", "()V", "web_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class WebViewKt {
    private static final Saver<WebViewState, Object> WebStateSaver;

    static {
        final String str = "pagetitle";
        final String str2 = "lastloaded";
        final String str3 = "bundle";
        WebStateSaver = MapSaverKt.mapSaver(new Function2<SaverScope, WebViewState, Map<String, ? extends Object>>() { // from class: com.google.accompanist.web.WebViewKt$WebStateSaver$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Map<String, Object> invoke(SaverScope mapSaver, WebViewState it) {
                Intrinsics.checkNotNullParameter(mapSaver, "$this$mapSaver");
                Intrinsics.checkNotNullParameter(it, "it");
                Bundle bundle = new Bundle();
                WebView webView$web_release = it.getWebView$web_release();
                if (webView$web_release != null) {
                    webView$web_release.saveState(bundle);
                }
                return MapsKt.mapOf(TuplesKt.to(str, it.getPageTitle()), TuplesKt.to(str2, it.getLastLoadedUrl()), TuplesKt.to(str3, bundle));
            }
        }, new Function1<Map<String, ? extends Object>, WebViewState>() { // from class: com.google.accompanist.web.WebViewKt$WebStateSaver$1$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final WebViewState invoke(Map<String, ? extends Object> it) {
                Intrinsics.checkNotNullParameter(it, "it");
                WebViewState webViewState = new WebViewState(WebContent.NavigatorOnly.INSTANCE);
                String str4 = str;
                String str5 = str2;
                String str6 = str3;
                webViewState.setPageTitle$web_release((String) it.get(str4));
                webViewState.setLastLoadedUrl$web_release((String) it.get(str5));
                webViewState.setViewState$web_release((Bundle) it.get(str6));
                return webViewState;
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:106:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x021f  */
    /* JADX WARN: Removed duplicated region for block: B:49:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x01c6  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x020e  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0160  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0166  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x016c  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0192  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x01bb  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x01b6  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x018e  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0169  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0163  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x015d  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x00d2  */
    @Deprecated
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void WebView(final WebViewState state, Modifier modifier, boolean z5, WebViewNavigator webViewNavigator, Function1<? super WebView, Unit> function1, Function1<? super WebView, Unit> function12, AccompanistWebViewClient accompanistWebViewClient, AccompanistWebChromeClient accompanistWebChromeClient, Function1<? super Context, ? extends WebView> function13, Composer composer, final int i5, final int i6) {
        int i7;
        int i8;
        WebViewNavigator webViewNavigator2;
        int i9;
        Function1<? super WebView, Unit> function14;
        int i10;
        Function1<? super WebView, Unit> function15;
        int i11;
        int i12;
        int i13;
        Modifier modifier2;
        boolean z6;
        Function1<? super Context, ? extends WebView> function16;
        WebViewNavigator webViewNavigator3;
        Function1<? super WebView, Unit> function17;
        Function1<? super WebView, Unit> function18;
        AccompanistWebViewClient accompanistWebViewClient2;
        AccompanistWebChromeClient accompanistWebChromeClient2;
        final boolean z7;
        final Function1<? super WebView, Unit> function19;
        final AccompanistWebChromeClient accompanistWebChromeClient3;
        Function1<? super Context, ? extends WebView> function110;
        final AccompanistWebViewClient accompanistWebViewClient3;
        ScopeUpdateScope endRestartGroup;
        int i14;
        Intrinsics.checkNotNullParameter(state, "state");
        Composer startRestartGroup = composer.startRestartGroup(1473276617);
        if ((i6 & 1) != 0) {
            i7 = i5 | 6;
        } else if ((i5 & 14) == 0) {
            i7 = (startRestartGroup.changed(state) ? 4 : 2) | i5;
        } else {
            i7 = i5;
        }
        int i15 = i6 & 2;
        if (i15 != 0) {
            i7 |= 48;
        } else if ((i5 & 112) == 0) {
            i7 |= startRestartGroup.changed(modifier) ? 32 : 16;
            i8 = i6 & 4;
            if (i8 == 0) {
                i7 |= 384;
            } else if ((i5 & 896) == 0) {
                i7 |= startRestartGroup.changed(z5) ? 256 : 128;
                if ((i5 & 7168) == 0) {
                    if ((i6 & 8) == 0) {
                        webViewNavigator2 = webViewNavigator;
                        if (startRestartGroup.changed(webViewNavigator2)) {
                            i14 = 2048;
                            i7 |= i14;
                        }
                    } else {
                        webViewNavigator2 = webViewNavigator;
                    }
                    i14 = 1024;
                    i7 |= i14;
                } else {
                    webViewNavigator2 = webViewNavigator;
                }
                i9 = i6 & 16;
                if (i9 != 0) {
                    i7 |= 24576;
                } else if ((57344 & i5) == 0) {
                    function14 = function1;
                    i7 |= startRestartGroup.changedInstance(function14) ? 16384 : 8192;
                    i10 = i6 & 32;
                    if (i10 == 0) {
                        i7 |= 196608;
                    } else if ((458752 & i5) == 0) {
                        function15 = function12;
                        i7 |= startRestartGroup.changedInstance(function15) ? 131072 : 65536;
                        i11 = i6 & 64;
                        if (i11 != 0) {
                            i7 |= 524288;
                        }
                        i12 = i6 & 128;
                        if (i12 != 0) {
                            i7 |= 4194304;
                        }
                        i13 = i6 & 256;
                        if (i13 != 0) {
                            i7 |= 100663296;
                        } else if ((i5 & 234881024) == 0) {
                            i7 |= startRestartGroup.changedInstance(function13) ? 67108864 : 33554432;
                        }
                        if ((i6 & 192) != 192 && (191739611 & i7) == 38347922 && startRestartGroup.getSkipping()) {
                            startRestartGroup.skipToGroupEnd();
                            modifier2 = modifier;
                            z7 = z5;
                            accompanistWebViewClient3 = accompanistWebViewClient;
                            webViewNavigator3 = webViewNavigator2;
                            function19 = function14;
                            function18 = function15;
                            accompanistWebChromeClient3 = accompanistWebChromeClient;
                            function110 = function13;
                        } else {
                            startRestartGroup.startDefaults();
                            if ((i5 & 1) == 0 && !startRestartGroup.getDefaultsInvalid()) {
                                startRestartGroup.skipToGroupEnd();
                                if ((i6 & 8) != 0) {
                                    i7 &= -7169;
                                }
                                if (i11 != 0) {
                                    i7 &= -3670017;
                                }
                                if (i12 != 0) {
                                    i7 &= -29360129;
                                }
                                modifier2 = modifier;
                                z6 = z5;
                                accompanistWebChromeClient2 = accompanistWebChromeClient;
                                function16 = function13;
                                webViewNavigator3 = webViewNavigator2;
                                function17 = function14;
                                function18 = function15;
                                accompanistWebViewClient2 = accompanistWebViewClient;
                            } else {
                                modifier2 = i15 != 0 ? Modifier.INSTANCE : modifier;
                                z6 = i8 != 0 ? true : z5;
                                function16 = null;
                                if ((i6 & 8) != 0) {
                                    webViewNavigator3 = rememberWebViewNavigator(null, startRestartGroup, 0, 1);
                                    i7 &= -7169;
                                } else {
                                    webViewNavigator3 = webViewNavigator2;
                                }
                                function17 = i9 != 0 ? new Function1<WebView, Unit>() { // from class: com.google.accompanist.web.WebViewKt$WebView$1
                                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(WebView it) {
                                        Intrinsics.checkNotNullParameter(it, "it");
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(WebView webView) {
                                        invoke2(webView);
                                        return Unit.INSTANCE;
                                    }
                                } : function14;
                                function18 = i10 != 0 ? new Function1<WebView, Unit>() { // from class: com.google.accompanist.web.WebViewKt$WebView$2
                                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(WebView it) {
                                        Intrinsics.checkNotNullParameter(it, "it");
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Unit invoke(WebView webView) {
                                        invoke2(webView);
                                        return Unit.INSTANCE;
                                    }
                                } : function15;
                                if (i11 != 0) {
                                    startRestartGroup.startReplaceableGroup(1370702801);
                                    Object rememberedValue = startRestartGroup.rememberedValue();
                                    if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                                        rememberedValue = new AccompanistWebViewClient();
                                        startRestartGroup.updateRememberedValue(rememberedValue);
                                    }
                                    accompanistWebViewClient2 = (AccompanistWebViewClient) rememberedValue;
                                    startRestartGroup.endReplaceableGroup();
                                    i7 &= -3670017;
                                } else {
                                    accompanistWebViewClient2 = accompanistWebViewClient;
                                }
                                if (i12 != 0) {
                                    startRestartGroup.startReplaceableGroup(1370702889);
                                    Object rememberedValue2 = startRestartGroup.rememberedValue();
                                    if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                        rememberedValue2 = new AccompanistWebChromeClient();
                                        startRestartGroup.updateRememberedValue(rememberedValue2);
                                    }
                                    accompanistWebChromeClient2 = (AccompanistWebChromeClient) rememberedValue2;
                                    startRestartGroup.endReplaceableGroup();
                                    i7 &= -29360129;
                                } else {
                                    accompanistWebChromeClient2 = accompanistWebChromeClient;
                                }
                                if (i13 == 0) {
                                    function16 = function13;
                                }
                            }
                            startRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1473276617, i7, -1, "com.google.accompanist.web.WebView (WebView.kt:100)");
                            }
                            final boolean z8 = z6;
                            final WebViewNavigator webViewNavigator4 = webViewNavigator3;
                            final Function1<? super WebView, Unit> function111 = function17;
                            final Function1<? super WebView, Unit> function112 = function18;
                            final AccompanistWebViewClient accompanistWebViewClient4 = accompanistWebViewClient2;
                            final AccompanistWebChromeClient accompanistWebChromeClient4 = accompanistWebChromeClient2;
                            final Function1<? super Context, ? extends WebView> function113 = function16;
                            BoxWithConstraintsKt.BoxWithConstraints(modifier2, null, false, ComposableLambdaKt.composableLambda(startRestartGroup, -1606035789, true, new Function3<BoxWithConstraintsScope, Composer, Integer, Unit>() { // from class: com.google.accompanist.web.WebViewKt$WebView$5
                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(3);
                                }

                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ Unit invoke(BoxWithConstraintsScope boxWithConstraintsScope, Composer composer2, Integer num) {
                                    invoke(boxWithConstraintsScope, composer2, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(BoxWithConstraintsScope BoxWithConstraints, Composer composer2, int i16) {
                                    int i17;
                                    Intrinsics.checkNotNullParameter(BoxWithConstraints, "$this$BoxWithConstraints");
                                    if ((i16 & 14) == 0) {
                                        i17 = i16 | (composer2.changed(BoxWithConstraints) ? 4 : 2);
                                    } else {
                                        i17 = i16;
                                    }
                                    if ((i17 & 91) == 18 && composer2.getSkipping()) {
                                        composer2.skipToGroupEnd();
                                        return;
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-1606035789, i17, -1, "com.google.accompanist.web.WebView.<anonymous> (WebView.kt:105)");
                                    }
                                    WebViewKt.WebView(WebViewState.this, new FrameLayout.LayoutParams(Constraints.m2576getHasFixedWidthimpl(BoxWithConstraints.getConstraints()) ? -1 : -2, Constraints.m2575getHasFixedHeightimpl(BoxWithConstraints.getConstraints()) ? -1 : -2), Modifier.INSTANCE, z8, webViewNavigator4, function111, function112, accompanistWebViewClient4, accompanistWebChromeClient4, function113, composer2, 150995392, 0);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }), startRestartGroup, ((i7 >> 3) & 14) | 3072, 6);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            z7 = z6;
                            function19 = function17;
                            accompanistWebChromeClient3 = accompanistWebChromeClient2;
                            AccompanistWebViewClient accompanistWebViewClient5 = accompanistWebViewClient2;
                            function110 = function16;
                            accompanistWebViewClient3 = accompanistWebViewClient5;
                        }
                        endRestartGroup = startRestartGroup.endRestartGroup();
                        if (endRestartGroup != null) {
                            final Modifier modifier3 = modifier2;
                            final WebViewNavigator webViewNavigator5 = webViewNavigator3;
                            final Function1<? super WebView, Unit> function114 = function18;
                            final Function1<? super Context, ? extends WebView> function115 = function110;
                            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.google.accompanist.web.WebViewKt$WebView$6
                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                /* JADX WARN: Multi-variable type inference failed */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                    invoke(composer2, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer composer2, int i16) {
                                    WebViewKt.WebView(WebViewState.this, modifier3, z7, webViewNavigator5, function19, function114, accompanistWebViewClient3, accompanistWebChromeClient3, function115, composer2, RecomposeScopeImplKt.updateChangedFlags(i5 | 1), i6);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    function15 = function12;
                    i11 = i6 & 64;
                    if (i11 != 0) {
                    }
                    i12 = i6 & 128;
                    if (i12 != 0) {
                    }
                    i13 = i6 & 256;
                    if (i13 != 0) {
                    }
                    if ((i6 & 192) != 192) {
                    }
                    startRestartGroup.startDefaults();
                    if ((i5 & 1) == 0) {
                    }
                    if (i15 != 0) {
                    }
                    if (i8 != 0) {
                    }
                    function16 = null;
                    if ((i6 & 8) != 0) {
                    }
                    if (i9 != 0) {
                    }
                    if (i10 != 0) {
                    }
                    if (i11 != 0) {
                    }
                    if (i12 != 0) {
                    }
                    if (i13 == 0) {
                    }
                    startRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    final boolean z82 = z6;
                    final WebViewNavigator webViewNavigator42 = webViewNavigator3;
                    final Function1<? super WebView, Unit> function1112 = function17;
                    final Function1<? super WebView, Unit> function1122 = function18;
                    final AccompanistWebViewClient accompanistWebViewClient42 = accompanistWebViewClient2;
                    final AccompanistWebChromeClient accompanistWebChromeClient42 = accompanistWebChromeClient2;
                    final Function1<? super Context, ? extends WebView> function1132 = function16;
                    BoxWithConstraintsKt.BoxWithConstraints(modifier2, null, false, ComposableLambdaKt.composableLambda(startRestartGroup, -1606035789, true, new Function3<BoxWithConstraintsScope, Composer, Integer, Unit>() { // from class: com.google.accompanist.web.WebViewKt$WebView$5
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Unit invoke(BoxWithConstraintsScope boxWithConstraintsScope, Composer composer2, Integer num) {
                            invoke(boxWithConstraintsScope, composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(BoxWithConstraintsScope BoxWithConstraints, Composer composer2, int i16) {
                            int i17;
                            Intrinsics.checkNotNullParameter(BoxWithConstraints, "$this$BoxWithConstraints");
                            if ((i16 & 14) == 0) {
                                i17 = i16 | (composer2.changed(BoxWithConstraints) ? 4 : 2);
                            } else {
                                i17 = i16;
                            }
                            if ((i17 & 91) == 18 && composer2.getSkipping()) {
                                composer2.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1606035789, i17, -1, "com.google.accompanist.web.WebView.<anonymous> (WebView.kt:105)");
                            }
                            WebViewKt.WebView(WebViewState.this, new FrameLayout.LayoutParams(Constraints.m2576getHasFixedWidthimpl(BoxWithConstraints.getConstraints()) ? -1 : -2, Constraints.m2575getHasFixedHeightimpl(BoxWithConstraints.getConstraints()) ? -1 : -2), Modifier.INSTANCE, z82, webViewNavigator42, function1112, function1122, accompanistWebViewClient42, accompanistWebChromeClient42, function1132, composer2, 150995392, 0);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }), startRestartGroup, ((i7 >> 3) & 14) | 3072, 6);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    z7 = z6;
                    function19 = function17;
                    accompanistWebChromeClient3 = accompanistWebChromeClient2;
                    AccompanistWebViewClient accompanistWebViewClient52 = accompanistWebViewClient2;
                    function110 = function16;
                    accompanistWebViewClient3 = accompanistWebViewClient52;
                    endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup != null) {
                    }
                }
                function14 = function1;
                i10 = i6 & 32;
                if (i10 == 0) {
                }
                function15 = function12;
                i11 = i6 & 64;
                if (i11 != 0) {
                }
                i12 = i6 & 128;
                if (i12 != 0) {
                }
                i13 = i6 & 256;
                if (i13 != 0) {
                }
                if ((i6 & 192) != 192) {
                }
                startRestartGroup.startDefaults();
                if ((i5 & 1) == 0) {
                }
                if (i15 != 0) {
                }
                if (i8 != 0) {
                }
                function16 = null;
                if ((i6 & 8) != 0) {
                }
                if (i9 != 0) {
                }
                if (i10 != 0) {
                }
                if (i11 != 0) {
                }
                if (i12 != 0) {
                }
                if (i13 == 0) {
                }
                startRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                }
                final boolean z822 = z6;
                final WebViewNavigator webViewNavigator422 = webViewNavigator3;
                final Function1<? super WebView, Unit> function11122 = function17;
                final Function1<? super WebView, Unit> function11222 = function18;
                final AccompanistWebViewClient accompanistWebViewClient422 = accompanistWebViewClient2;
                final AccompanistWebChromeClient accompanistWebChromeClient422 = accompanistWebChromeClient2;
                final Function1<? super Context, ? extends WebView> function11322 = function16;
                BoxWithConstraintsKt.BoxWithConstraints(modifier2, null, false, ComposableLambdaKt.composableLambda(startRestartGroup, -1606035789, true, new Function3<BoxWithConstraintsScope, Composer, Integer, Unit>() { // from class: com.google.accompanist.web.WebViewKt$WebView$5
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(BoxWithConstraintsScope boxWithConstraintsScope, Composer composer2, Integer num) {
                        invoke(boxWithConstraintsScope, composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(BoxWithConstraintsScope BoxWithConstraints, Composer composer2, int i16) {
                        int i17;
                        Intrinsics.checkNotNullParameter(BoxWithConstraints, "$this$BoxWithConstraints");
                        if ((i16 & 14) == 0) {
                            i17 = i16 | (composer2.changed(BoxWithConstraints) ? 4 : 2);
                        } else {
                            i17 = i16;
                        }
                        if ((i17 & 91) == 18 && composer2.getSkipping()) {
                            composer2.skipToGroupEnd();
                            return;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1606035789, i17, -1, "com.google.accompanist.web.WebView.<anonymous> (WebView.kt:105)");
                        }
                        WebViewKt.WebView(WebViewState.this, new FrameLayout.LayoutParams(Constraints.m2576getHasFixedWidthimpl(BoxWithConstraints.getConstraints()) ? -1 : -2, Constraints.m2575getHasFixedHeightimpl(BoxWithConstraints.getConstraints()) ? -1 : -2), Modifier.INSTANCE, z822, webViewNavigator422, function11122, function11222, accompanistWebViewClient422, accompanistWebChromeClient422, function11322, composer2, 150995392, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    }
                }), startRestartGroup, ((i7 >> 3) & 14) | 3072, 6);
                if (ComposerKt.isTraceInProgress()) {
                }
                z7 = z6;
                function19 = function17;
                accompanistWebChromeClient3 = accompanistWebChromeClient2;
                AccompanistWebViewClient accompanistWebViewClient522 = accompanistWebViewClient2;
                function110 = function16;
                accompanistWebViewClient3 = accompanistWebViewClient522;
                endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                }
            }
            if ((i5 & 7168) == 0) {
            }
            i9 = i6 & 16;
            if (i9 != 0) {
            }
            function14 = function1;
            i10 = i6 & 32;
            if (i10 == 0) {
            }
            function15 = function12;
            i11 = i6 & 64;
            if (i11 != 0) {
            }
            i12 = i6 & 128;
            if (i12 != 0) {
            }
            i13 = i6 & 256;
            if (i13 != 0) {
            }
            if ((i6 & 192) != 192) {
            }
            startRestartGroup.startDefaults();
            if ((i5 & 1) == 0) {
            }
            if (i15 != 0) {
            }
            if (i8 != 0) {
            }
            function16 = null;
            if ((i6 & 8) != 0) {
            }
            if (i9 != 0) {
            }
            if (i10 != 0) {
            }
            if (i11 != 0) {
            }
            if (i12 != 0) {
            }
            if (i13 == 0) {
            }
            startRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
            }
            final boolean z8222 = z6;
            final WebViewNavigator webViewNavigator4222 = webViewNavigator3;
            final Function1<? super WebView, Unit> function111222 = function17;
            final Function1<? super WebView, Unit> function112222 = function18;
            final AccompanistWebViewClient accompanistWebViewClient4222 = accompanistWebViewClient2;
            final AccompanistWebChromeClient accompanistWebChromeClient4222 = accompanistWebChromeClient2;
            final Function1<? super Context, ? extends WebView> function113222 = function16;
            BoxWithConstraintsKt.BoxWithConstraints(modifier2, null, false, ComposableLambdaKt.composableLambda(startRestartGroup, -1606035789, true, new Function3<BoxWithConstraintsScope, Composer, Integer, Unit>() { // from class: com.google.accompanist.web.WebViewKt$WebView$5
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(BoxWithConstraintsScope boxWithConstraintsScope, Composer composer2, Integer num) {
                    invoke(boxWithConstraintsScope, composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(BoxWithConstraintsScope BoxWithConstraints, Composer composer2, int i16) {
                    int i17;
                    Intrinsics.checkNotNullParameter(BoxWithConstraints, "$this$BoxWithConstraints");
                    if ((i16 & 14) == 0) {
                        i17 = i16 | (composer2.changed(BoxWithConstraints) ? 4 : 2);
                    } else {
                        i17 = i16;
                    }
                    if ((i17 & 91) == 18 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1606035789, i17, -1, "com.google.accompanist.web.WebView.<anonymous> (WebView.kt:105)");
                    }
                    WebViewKt.WebView(WebViewState.this, new FrameLayout.LayoutParams(Constraints.m2576getHasFixedWidthimpl(BoxWithConstraints.getConstraints()) ? -1 : -2, Constraints.m2575getHasFixedHeightimpl(BoxWithConstraints.getConstraints()) ? -1 : -2), Modifier.INSTANCE, z8222, webViewNavigator4222, function111222, function112222, accompanistWebViewClient4222, accompanistWebChromeClient4222, function113222, composer2, 150995392, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }), startRestartGroup, ((i7 >> 3) & 14) | 3072, 6);
            if (ComposerKt.isTraceInProgress()) {
            }
            z7 = z6;
            function19 = function17;
            accompanistWebChromeClient3 = accompanistWebChromeClient2;
            AccompanistWebViewClient accompanistWebViewClient5222 = accompanistWebViewClient2;
            function110 = function16;
            accompanistWebViewClient3 = accompanistWebViewClient5222;
            endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
            }
        }
        i8 = i6 & 4;
        if (i8 == 0) {
        }
        if ((i5 & 7168) == 0) {
        }
        i9 = i6 & 16;
        if (i9 != 0) {
        }
        function14 = function1;
        i10 = i6 & 32;
        if (i10 == 0) {
        }
        function15 = function12;
        i11 = i6 & 64;
        if (i11 != 0) {
        }
        i12 = i6 & 128;
        if (i12 != 0) {
        }
        i13 = i6 & 256;
        if (i13 != 0) {
        }
        if ((i6 & 192) != 192) {
        }
        startRestartGroup.startDefaults();
        if ((i5 & 1) == 0) {
        }
        if (i15 != 0) {
        }
        if (i8 != 0) {
        }
        function16 = null;
        if ((i6 & 8) != 0) {
        }
        if (i9 != 0) {
        }
        if (i10 != 0) {
        }
        if (i11 != 0) {
        }
        if (i12 != 0) {
        }
        if (i13 == 0) {
        }
        startRestartGroup.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        final boolean z82222 = z6;
        final WebViewNavigator webViewNavigator42222 = webViewNavigator3;
        final Function1<? super WebView, Unit> function1112222 = function17;
        final Function1<? super WebView, Unit> function1122222 = function18;
        final AccompanistWebViewClient accompanistWebViewClient42222 = accompanistWebViewClient2;
        final AccompanistWebChromeClient accompanistWebChromeClient42222 = accompanistWebChromeClient2;
        final Function1<? super Context, ? extends WebView> function1132222 = function16;
        BoxWithConstraintsKt.BoxWithConstraints(modifier2, null, false, ComposableLambdaKt.composableLambda(startRestartGroup, -1606035789, true, new Function3<BoxWithConstraintsScope, Composer, Integer, Unit>() { // from class: com.google.accompanist.web.WebViewKt$WebView$5
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(BoxWithConstraintsScope boxWithConstraintsScope, Composer composer2, Integer num) {
                invoke(boxWithConstraintsScope, composer2, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(BoxWithConstraintsScope BoxWithConstraints, Composer composer2, int i16) {
                int i17;
                Intrinsics.checkNotNullParameter(BoxWithConstraints, "$this$BoxWithConstraints");
                if ((i16 & 14) == 0) {
                    i17 = i16 | (composer2.changed(BoxWithConstraints) ? 4 : 2);
                } else {
                    i17 = i16;
                }
                if ((i17 & 91) == 18 && composer2.getSkipping()) {
                    composer2.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1606035789, i17, -1, "com.google.accompanist.web.WebView.<anonymous> (WebView.kt:105)");
                }
                WebViewKt.WebView(WebViewState.this, new FrameLayout.LayoutParams(Constraints.m2576getHasFixedWidthimpl(BoxWithConstraints.getConstraints()) ? -1 : -2, Constraints.m2575getHasFixedHeightimpl(BoxWithConstraints.getConstraints()) ? -1 : -2), Modifier.INSTANCE, z82222, webViewNavigator42222, function1112222, function1122222, accompanistWebViewClient42222, accompanistWebChromeClient42222, function1132222, composer2, 150995392, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }), startRestartGroup, ((i7 >> 3) & 14) | 3072, 6);
        if (ComposerKt.isTraceInProgress()) {
        }
        z7 = z6;
        function19 = function17;
        accompanistWebChromeClient3 = accompanistWebChromeClient2;
        AccompanistWebViewClient accompanistWebViewClient52222 = accompanistWebViewClient2;
        function110 = function16;
        accompanistWebViewClient3 = accompanistWebViewClient52222;
        endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    @Deprecated
    public static final WebViewNavigator rememberWebViewNavigator(CoroutineScope coroutineScope, Composer composer, int i5, int i6) {
        composer.startReplaceableGroup(1602323198);
        if ((i6 & 1) != 0) {
            Object rememberedValue = composer.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composer));
                composer.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
                rememberedValue = compositionScopedCoroutineScopeCanceller;
            }
            coroutineScope = ((CompositionScopedCoroutineScopeCanceller) rememberedValue).getCoroutineScope();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1602323198, i5, -1, "com.google.accompanist.web.rememberWebViewNavigator (WebView.kt:691)");
        }
        composer.startReplaceableGroup(948350619);
        boolean changed = composer.changed(coroutineScope);
        Object rememberedValue2 = composer.rememberedValue();
        if (changed || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
            rememberedValue2 = new WebViewNavigator(coroutineScope);
            composer.updateRememberedValue(rememberedValue2);
        }
        WebViewNavigator webViewNavigator = (WebViewNavigator) rememberedValue2;
        composer.endReplaceableGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return webViewNavigator;
    }

    @Deprecated
    public static final WebViewState rememberWebViewState(String url, Map<String, String> map, Composer composer, int i5, int i6) {
        Intrinsics.checkNotNullParameter(url, "url");
        composer.startReplaceableGroup(1238013775);
        if ((i6 & 2) != 0) {
            map = MapsKt.emptyMap();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1238013775, i5, -1, "com.google.accompanist.web.rememberWebViewState (WebView.kt:736)");
        }
        composer.startReplaceableGroup(400020825);
        Object rememberedValue = composer.rememberedValue();
        if (rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = new WebViewState(new WebContent.Url(url, map));
            composer.updateRememberedValue(rememberedValue);
        }
        WebViewState webViewState = (WebViewState) rememberedValue;
        composer.endReplaceableGroup();
        webViewState.setContent(new WebContent.Url(url, map));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return webViewState;
    }

    @Deprecated
    public static final void WebView(final WebViewState state, final FrameLayout.LayoutParams layoutParams, Modifier modifier, boolean z5, WebViewNavigator webViewNavigator, Function1<? super WebView, Unit> function1, Function1<? super WebView, Unit> function12, AccompanistWebViewClient accompanistWebViewClient, AccompanistWebChromeClient accompanistWebChromeClient, Function1<? super Context, ? extends WebView> function13, Composer composer, final int i5, final int i6) {
        WebViewNavigator webViewNavigator2;
        int i7;
        AccompanistWebViewClient accompanistWebViewClient2;
        int i8;
        AccompanistWebChromeClient accompanistWebChromeClient2;
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(layoutParams, "layoutParams");
        Composer startRestartGroup = composer.startRestartGroup(-1401343589);
        Modifier modifier2 = (i6 & 4) != 0 ? Modifier.INSTANCE : modifier;
        boolean z6 = (i6 & 8) != 0 ? true : z5;
        if ((i6 & 16) != 0) {
            webViewNavigator2 = rememberWebViewNavigator(null, startRestartGroup, 0, 1);
            i7 = i5 & (-57345);
        } else {
            webViewNavigator2 = webViewNavigator;
            i7 = i5;
        }
        Function1<? super WebView, Unit> function14 = (i6 & 32) != 0 ? new Function1<WebView, Unit>() { // from class: com.google.accompanist.web.WebViewKt$WebView$7
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(WebView it) {
                Intrinsics.checkNotNullParameter(it, "it");
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(WebView webView) {
                invoke2(webView);
                return Unit.INSTANCE;
            }
        } : function1;
        final Function1<? super WebView, Unit> function15 = (i6 & 64) != 0 ? new Function1<WebView, Unit>() { // from class: com.google.accompanist.web.WebViewKt$WebView$8
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(WebView it) {
                Intrinsics.checkNotNullParameter(it, "it");
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(WebView webView) {
                invoke2(webView);
                return Unit.INSTANCE;
            }
        } : function12;
        if ((i6 & 128) != 0) {
            startRestartGroup.startReplaceableGroup(1370705963);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new AccompanistWebViewClient();
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            accompanistWebViewClient2 = (AccompanistWebViewClient) rememberedValue;
            startRestartGroup.endReplaceableGroup();
            i7 &= -29360129;
        } else {
            accompanistWebViewClient2 = accompanistWebViewClient;
        }
        if ((i6 & 256) != 0) {
            startRestartGroup.startReplaceableGroup(1370706051);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                rememberedValue2 = new AccompanistWebChromeClient();
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            startRestartGroup.endReplaceableGroup();
            int i9 = i7 & (-234881025);
            accompanistWebChromeClient2 = (AccompanistWebChromeClient) rememberedValue2;
            i8 = i9;
        } else {
            i8 = i7;
            accompanistWebChromeClient2 = accompanistWebChromeClient;
        }
        Function1<? super Context, ? extends WebView> function16 = (i6 & 512) != 0 ? null : function13;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1401343589, i8, -1, "com.google.accompanist.web.WebView (WebView.kt:180)");
        }
        final WebView webView$web_release = state.getWebView$web_release();
        BackHandlerKt.BackHandler(z6 && webViewNavigator2.getCanGoBack(), new Function0<Unit>() { // from class: com.google.accompanist.web.WebViewKt$WebView$11
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                WebView webView = webView$web_release;
                if (webView != null) {
                    webView.goBack();
                }
            }
        }, startRestartGroup, 0, 0);
        startRestartGroup.startReplaceableGroup(1370706283);
        if (webView$web_release != null) {
            EffectsKt.LaunchedEffect(webView$web_release, webViewNavigator2, new WebViewKt$WebView$12$1(webViewNavigator2, webView$web_release, null), startRestartGroup, ((i8 >> 9) & 112) | 520);
            EffectsKt.LaunchedEffect(webView$web_release, state, new WebViewKt$WebView$12$2(state, webView$web_release, null), startRestartGroup, ((i8 << 3) & 112) | 520);
            Unit unit = Unit.INSTANCE;
        }
        startRestartGroup.endReplaceableGroup();
        accompanistWebViewClient2.setState$web_release(state);
        accompanistWebViewClient2.setNavigator$web_release(webViewNavigator2);
        accompanistWebChromeClient2.setState$web_release(state);
        final Function1<? super Context, ? extends WebView> function17 = function16;
        final Function1<? super WebView, Unit> function18 = function14;
        final AccompanistWebChromeClient accompanistWebChromeClient3 = accompanistWebChromeClient2;
        final AccompanistWebViewClient accompanistWebViewClient3 = accompanistWebViewClient2;
        Function1<Context, WebView> function19 = new Function1<Context, WebView>() { // from class: com.google.accompanist.web.WebViewKt$WebView$13
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final WebView invoke(Context context) {
                WebView webView;
                Intrinsics.checkNotNullParameter(context, "context");
                Function1<Context, WebView> function110 = function17;
                if (function110 == null || (webView = function110.invoke(context)) == null) {
                    webView = new WebView(context);
                }
                Function1<WebView, Unit> function111 = function18;
                FrameLayout.LayoutParams layoutParams2 = layoutParams;
                WebViewState webViewState = state;
                AccompanistWebChromeClient accompanistWebChromeClient4 = accompanistWebChromeClient3;
                AccompanistWebViewClient accompanistWebViewClient4 = accompanistWebViewClient3;
                function111.invoke(webView);
                webView.setLayoutParams(layoutParams2);
                Bundle viewState = webViewState.getViewState();
                if (viewState != null) {
                    webView.restoreState(viewState);
                }
                webView.setWebChromeClient(accompanistWebChromeClient4);
                webView.setWebViewClient(accompanistWebViewClient4);
                state.setWebView$web_release(webView);
                return webView;
            }
        };
        startRestartGroup.startReplaceableGroup(1370708191);
        boolean z7 = (((i5 & 3670016) ^ 1572864) > 1048576 && startRestartGroup.changedInstance(function15)) || (i5 & 1572864) == 1048576;
        Object rememberedValue3 = startRestartGroup.rememberedValue();
        if (z7 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
            rememberedValue3 = new Function1<WebView, Unit>() { // from class: com.google.accompanist.web.WebViewKt$WebView$14$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(WebView webView) {
                    invoke2(webView);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(WebView it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    function15.invoke(it);
                }
            };
            startRestartGroup.updateRememberedValue(rememberedValue3);
        }
        startRestartGroup.endReplaceableGroup();
        AndroidView_androidKt.AndroidView(function19, modifier2, null, (Function1) rememberedValue3, null, startRestartGroup, (i8 >> 3) & 112, 20);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier3 = modifier2;
            final boolean z8 = z6;
            final WebViewNavigator webViewNavigator3 = webViewNavigator2;
            final Function1<? super WebView, Unit> function110 = function14;
            final Function1<? super WebView, Unit> function111 = function15;
            final AccompanistWebViewClient accompanistWebViewClient4 = accompanistWebViewClient2;
            final AccompanistWebChromeClient accompanistWebChromeClient4 = accompanistWebChromeClient2;
            final Function1<? super Context, ? extends WebView> function112 = function16;
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.google.accompanist.web.WebViewKt$WebView$15
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i10) {
                    WebViewKt.WebView(WebViewState.this, layoutParams, modifier3, z8, webViewNavigator3, function110, function111, accompanistWebViewClient4, accompanistWebChromeClient4, function112, composer2, RecomposeScopeImplKt.updateChangedFlags(i5 | 1), i6);
                }
            });
        }
    }
}
