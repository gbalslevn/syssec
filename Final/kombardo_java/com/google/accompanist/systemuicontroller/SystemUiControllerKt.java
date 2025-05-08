package com.google.accompanist.systemuicontroller;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.view.View;
import android.view.ViewParent;
import android.view.Window;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.window.DialogWindowProvider;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u000f\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0003¢\u0006\u0002\u0010\u0007\u001a\u0019\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0006H\u0007¢\u0006\u0002\u0010\u000b\u001a\u000f\u0010\u0005\u001a\u0004\u0018\u00010\u0006*\u00020\fH\u0082\u0010\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"BlackScrim", "Landroidx/compose/ui/graphics/Color;", "J", "BlackScrimmed", "Lkotlin/Function1;", "findWindow", "Landroid/view/Window;", "(Landroidx/compose/runtime/Composer;I)Landroid/view/Window;", "rememberSystemUiController", "Lcom/google/accompanist/systemuicontroller/SystemUiController;", "window", "(Landroid/view/Window;Landroidx/compose/runtime/Composer;II)Lcom/google/accompanist/systemuicontroller/SystemUiController;", "Landroid/content/Context;", "systemuicontroller_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class SystemUiControllerKt {
    private static final long BlackScrim = ColorKt.Color$default(0.0f, 0.0f, 0.0f, 0.3f, null, 16, null);
    private static final Function1<Color, Color> BlackScrimmed = new Function1<Color, Color>() { // from class: com.google.accompanist.systemuicontroller.SystemUiControllerKt$BlackScrimmed$1
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Color invoke(Color color) {
            return Color.m1481boximpl(m2917invokel2rxGTc(color.getValue()));
        }

        /* renamed from: invoke-l2rxGTc, reason: not valid java name */
        public final long m2917invokel2rxGTc(long j5) {
            long j6;
            j6 = SystemUiControllerKt.BlackScrim;
            return ColorKt.m1505compositeOverOWjLjI(j6, j5);
        }
    };

    private static final Window findWindow(Composer composer, int i5) {
        composer.startReplaceableGroup(1009281237);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1009281237, i5, -1, "com.google.accompanist.systemuicontroller.findWindow (SystemUiController.kt:208)");
        }
        ViewParent parent = ((View) composer.consume(AndroidCompositionLocals_androidKt.getLocalView())).getParent();
        DialogWindowProvider dialogWindowProvider = parent instanceof DialogWindowProvider ? (DialogWindowProvider) parent : null;
        Window window = dialogWindowProvider != null ? dialogWindowProvider.getWindow() : null;
        if (window == null) {
            Context context = ((View) composer.consume(AndroidCompositionLocals_androidKt.getLocalView())).getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
            window = findWindow(context);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return window;
    }

    @Deprecated
    public static final SystemUiController rememberSystemUiController(Window window, Composer composer, int i5, int i6) {
        composer.startReplaceableGroup(-715745933);
        if ((i6 & 1) != 0) {
            window = findWindow(composer, 0);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-715745933, i5, -1, "com.google.accompanist.systemuicontroller.rememberSystemUiController (SystemUiController.kt:201)");
        }
        View view = (View) composer.consume(AndroidCompositionLocals_androidKt.getLocalView());
        composer.startReplaceableGroup(-1044852491);
        boolean changed = composer.changed(view) | composer.changed(window);
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = new AndroidSystemUiController(view, window);
            composer.updateRememberedValue(rememberedValue);
        }
        AndroidSystemUiController androidSystemUiController = (AndroidSystemUiController) rememberedValue;
        composer.endReplaceableGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return androidSystemUiController;
    }

    private static final Window findWindow(Context context) {
        while (!(context instanceof Activity)) {
            if (!(context instanceof ContextWrapper)) {
                return null;
            }
            context = ((ContextWrapper) context).getBaseContext();
            Intrinsics.checkNotNullExpressionValue(context, "getBaseContext(...)");
        }
        return ((Activity) context).getWindow();
    }
}
