package dk.molslinjen.ui.views.reusable.snackbar;

import androidx.compose.material3.SnackbarData;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import dk.molslinjen.core.snackbar.SnackbarMessageEvent;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
final class CustomSnackbarHostKt$CustomSnackbarHost$1$1 implements Function3<SnackbarData, Composer, Integer, Unit> {
    final /* synthetic */ SnackbarMessageEvent $latestSnackbarMessageEvent;

    /* JADX INFO: Access modifiers changed from: package-private */
    public CustomSnackbarHostKt$CustomSnackbarHost$1$1(SnackbarMessageEvent snackbarMessageEvent) {
        this.$latestSnackbarMessageEvent = snackbarMessageEvent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$4$lambda$1$lambda$0(SnackbarData snackbarData) {
        snackbarData.performAction();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$4$lambda$3$lambda$2(SnackbarData snackbarData) {
        snackbarData.dismiss();
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(SnackbarData snackbarData, Composer composer, Integer num) {
        invoke(snackbarData, composer, num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(final SnackbarData snackbarData, Composer composer, int i5) {
        Intrinsics.checkNotNullParameter(snackbarData, "snackbarData");
        if ((i5 & 6) == 0) {
            i5 |= composer.changed(snackbarData) ? 4 : 2;
        }
        if ((i5 & 19) == 18 && composer.getSkipping()) {
            composer.skipToGroupEnd();
            return;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1359348164, i5, -1, "dk.molslinjen.ui.views.reusable.snackbar.CustomSnackbarHost.<anonymous>.<anonymous> (CustomSnackbarHost.kt:28)");
        }
        SnackbarMessageEvent snackbarMessageEvent = this.$latestSnackbarMessageEvent;
        if (snackbarMessageEvent != null) {
            String message = snackbarData.getVisuals().getMessage();
            String actionLabel = snackbarData.getVisuals().getActionLabel();
            composer.startReplaceGroup(-2020894401);
            int i6 = i5 & 14;
            boolean z5 = i6 == 4;
            Object rememberedValue = composer.rememberedValue();
            if (z5 || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function0() { // from class: dk.molslinjen.ui.views.reusable.snackbar.a
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit invoke$lambda$4$lambda$1$lambda$0;
                        invoke$lambda$4$lambda$1$lambda$0 = CustomSnackbarHostKt$CustomSnackbarHost$1$1.invoke$lambda$4$lambda$1$lambda$0(SnackbarData.this);
                        return invoke$lambda$4$lambda$1$lambda$0;
                    }
                };
                composer.updateRememberedValue(rememberedValue);
            }
            Function0 function0 = (Function0) rememberedValue;
            composer.endReplaceGroup();
            composer.startReplaceGroup(-2020892359);
            boolean z6 = i6 == 4;
            Object rememberedValue2 = composer.rememberedValue();
            if (z6 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                rememberedValue2 = new Function0() { // from class: dk.molslinjen.ui.views.reusable.snackbar.b
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit invoke$lambda$4$lambda$3$lambda$2;
                        invoke$lambda$4$lambda$3$lambda$2 = CustomSnackbarHostKt$CustomSnackbarHost$1$1.invoke$lambda$4$lambda$3$lambda$2(SnackbarData.this);
                        return invoke$lambda$4$lambda$3$lambda$2;
                    }
                };
                composer.updateRememberedValue(rememberedValue2);
            }
            composer.endReplaceGroup();
            StyledSnackbarKt.StyledSnackbar(message, actionLabel, function0, (Function0) rememberedValue2, snackbarMessageEvent.getShowDismiss(), snackbarMessageEvent.getStyle(), composer, 0, 0);
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
