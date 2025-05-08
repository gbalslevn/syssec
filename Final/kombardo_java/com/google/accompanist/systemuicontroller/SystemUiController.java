package com.google.accompanist.systemuicontroller;

import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import org.conscrypt.BuildConfig;

@Deprecated
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\bg\u0018\u00002\u00020\u0001J:\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0006H&ø\u0001\u0000¢\u0006\u0004\b\t\u0010\nJD\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\f\u001a\u00020\u00042\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0006H&ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000eø\u0001\u0001\u0082\u0002\r\n\u0005\b¡\u001e0\u0001\n\u0004\b!0\u0001¨\u0006\u0010À\u0006\u0001"}, d2 = {"Lcom/google/accompanist/systemuicontroller/SystemUiController;", BuildConfig.FLAVOR, "Landroidx/compose/ui/graphics/Color;", "color", BuildConfig.FLAVOR, "darkIcons", "Lkotlin/Function1;", "transformColorForLightContent", BuildConfig.FLAVOR, "setStatusBarColor-ek8zF_U", "(JZLkotlin/jvm/functions/Function1;)V", "setStatusBarColor", "navigationBarContrastEnforced", "setNavigationBarColor-Iv8Zu3U", "(JZZLkotlin/jvm/functions/Function1;)V", "setNavigationBarColor", "systemuicontroller_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public interface SystemUiController {
    /* renamed from: setNavigationBarColor-Iv8Zu3U$default, reason: not valid java name */
    static /* synthetic */ void m2915setNavigationBarColorIv8Zu3U$default(SystemUiController systemUiController, long j5, boolean z5, boolean z6, Function1 function1, int i5, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setNavigationBarColor-Iv8Zu3U");
        }
        if ((i5 & 2) != 0) {
            z5 = ColorKt.m1507luminance8_81llA(j5) > 0.5f;
        }
        boolean z7 = z5;
        boolean z8 = (i5 & 4) != 0 ? true : z6;
        if ((i5 & 8) != 0) {
            function1 = SystemUiControllerKt.BlackScrimmed;
        }
        systemUiController.mo2913setNavigationBarColorIv8Zu3U(j5, z7, z8, function1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: setStatusBarColor-ek8zF_U$default, reason: not valid java name */
    static /* synthetic */ void m2916setStatusBarColorek8zF_U$default(SystemUiController systemUiController, long j5, boolean z5, Function1 function1, int i5, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setStatusBarColor-ek8zF_U");
        }
        if ((i5 & 2) != 0) {
            z5 = ColorKt.m1507luminance8_81llA(j5) > 0.5f;
        }
        if ((i5 & 4) != 0) {
            function1 = SystemUiControllerKt.BlackScrimmed;
        }
        systemUiController.mo2914setStatusBarColorek8zF_U(j5, z5, function1);
    }

    /* renamed from: setNavigationBarColor-Iv8Zu3U */
    void mo2913setNavigationBarColorIv8Zu3U(long color, boolean darkIcons, boolean navigationBarContrastEnforced, Function1<? super Color, Color> transformColorForLightContent);

    /* renamed from: setStatusBarColor-ek8zF_U */
    void mo2914setStatusBarColorek8zF_U(long color, boolean darkIcons, Function1<? super Color, Color> transformColorForLightContent);
}
