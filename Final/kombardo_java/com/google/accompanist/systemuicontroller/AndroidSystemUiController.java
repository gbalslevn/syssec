package com.google.accompanist.systemuicontroller;

import android.os.Build;
import android.view.View;
import android.view.Window;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;
import w0.AbstractC0823a;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J6\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\fH\u0016ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010J>\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\n2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\fH\u0016ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0016R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0017R\u0016\u0010\u0019\u001a\u0004\u0018\u00010\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR$\u0010 \u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\n8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR$\u0010#\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\n8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b!\u0010\u001d\"\u0004\b\"\u0010\u001fR$\u0010$\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\n8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b$\u0010\u001d\"\u0004\b%\u0010\u001f\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006&"}, d2 = {"Lcom/google/accompanist/systemuicontroller/AndroidSystemUiController;", "Lcom/google/accompanist/systemuicontroller/SystemUiController;", "Landroid/view/View;", "view", "Landroid/view/Window;", "window", "<init>", "(Landroid/view/View;Landroid/view/Window;)V", "Landroidx/compose/ui/graphics/Color;", "color", BuildConfig.FLAVOR, "darkIcons", "Lkotlin/Function1;", "transformColorForLightContent", BuildConfig.FLAVOR, "setStatusBarColor-ek8zF_U", "(JZLkotlin/jvm/functions/Function1;)V", "setStatusBarColor", "navigationBarContrastEnforced", "setNavigationBarColor-Iv8Zu3U", "(JZZLkotlin/jvm/functions/Function1;)V", "setNavigationBarColor", "Landroid/view/View;", "Landroid/view/Window;", "Landroidx/core/view/WindowInsetsControllerCompat;", "windowInsetsController", "Landroidx/core/view/WindowInsetsControllerCompat;", "value", "getStatusBarDarkContentEnabled", "()Z", "setStatusBarDarkContentEnabled", "(Z)V", "statusBarDarkContentEnabled", "getNavigationBarDarkContentEnabled", "setNavigationBarDarkContentEnabled", "navigationBarDarkContentEnabled", "isNavigationBarContrastEnforced", "setNavigationBarContrastEnforced", "systemuicontroller_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public final class AndroidSystemUiController implements SystemUiController {
    private final View view;
    private final Window window;
    private final WindowInsetsControllerCompat windowInsetsController;

    public AndroidSystemUiController(View view, Window window) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.view = view;
        this.window = window;
        this.windowInsetsController = window != null ? WindowCompat.getInsetsController(window, view) : null;
    }

    @Override // com.google.accompanist.systemuicontroller.SystemUiController
    /* renamed from: setNavigationBarColor-Iv8Zu3U, reason: not valid java name */
    public void mo2913setNavigationBarColorIv8Zu3U(long color, boolean darkIcons, boolean navigationBarContrastEnforced, Function1<? super Color, Color> transformColorForLightContent) {
        WindowInsetsControllerCompat windowInsetsControllerCompat;
        Intrinsics.checkNotNullParameter(transformColorForLightContent, "transformColorForLightContent");
        setNavigationBarDarkContentEnabled(darkIcons);
        setNavigationBarContrastEnforced(navigationBarContrastEnforced);
        Window window = this.window;
        if (window == null) {
            return;
        }
        if (darkIcons && ((windowInsetsControllerCompat = this.windowInsetsController) == null || !windowInsetsControllerCompat.isAppearanceLightNavigationBars())) {
            color = transformColorForLightContent.invoke(Color.m1481boximpl(color)).getValue();
        }
        window.setNavigationBarColor(ColorKt.m1508toArgb8_81llA(color));
    }

    public void setNavigationBarContrastEnforced(boolean z5) {
        Window window;
        if (Build.VERSION.SDK_INT < 29 || (window = this.window) == null) {
            return;
        }
        AbstractC0823a.a(window, z5);
    }

    public void setNavigationBarDarkContentEnabled(boolean z5) {
        WindowInsetsControllerCompat windowInsetsControllerCompat = this.windowInsetsController;
        if (windowInsetsControllerCompat == null) {
            return;
        }
        windowInsetsControllerCompat.setAppearanceLightNavigationBars(z5);
    }

    @Override // com.google.accompanist.systemuicontroller.SystemUiController
    /* renamed from: setStatusBarColor-ek8zF_U, reason: not valid java name */
    public void mo2914setStatusBarColorek8zF_U(long color, boolean darkIcons, Function1<? super Color, Color> transformColorForLightContent) {
        WindowInsetsControllerCompat windowInsetsControllerCompat;
        Intrinsics.checkNotNullParameter(transformColorForLightContent, "transformColorForLightContent");
        setStatusBarDarkContentEnabled(darkIcons);
        Window window = this.window;
        if (window == null) {
            return;
        }
        if (darkIcons && ((windowInsetsControllerCompat = this.windowInsetsController) == null || !windowInsetsControllerCompat.isAppearanceLightStatusBars())) {
            color = transformColorForLightContent.invoke(Color.m1481boximpl(color)).getValue();
        }
        window.setStatusBarColor(ColorKt.m1508toArgb8_81llA(color));
    }

    public void setStatusBarDarkContentEnabled(boolean z5) {
        WindowInsetsControllerCompat windowInsetsControllerCompat = this.windowInsetsController;
        if (windowInsetsControllerCompat == null) {
            return;
        }
        windowInsetsControllerCompat.setAppearanceLightStatusBars(z5);
    }
}
