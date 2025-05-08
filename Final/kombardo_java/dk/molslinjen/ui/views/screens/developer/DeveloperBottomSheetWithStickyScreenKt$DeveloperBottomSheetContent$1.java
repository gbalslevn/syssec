package dk.molslinjen.ui.views.screens.developer;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import dk.molslinjen.ui.views.reusable.bottomsheet.BottomSheetButtonKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class DeveloperBottomSheetWithStickyScreenKt$DeveloperBottomSheetContent$1 implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ MutableState<Boolean> $showBackAction$delegate;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DeveloperBottomSheetWithStickyScreenKt$DeveloperBottomSheetContent$1(MutableState<Boolean> mutableState) {
        this.$showBackAction$delegate = mutableState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$1$lambda$0(MutableState mutableState) {
        boolean DeveloperBottomSheetContent$lambda$3;
        DeveloperBottomSheetContent$lambda$3 = DeveloperBottomSheetWithStickyScreenKt.DeveloperBottomSheetContent$lambda$3(mutableState);
        DeveloperBottomSheetWithStickyScreenKt.DeveloperBottomSheetContent$lambda$4(mutableState, !DeveloperBottomSheetContent$lambda$3);
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
        invoke(composer, num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(Composer composer, int i5) {
        if ((i5 & 3) == 2 && composer.getSkipping()) {
            composer.skipToGroupEnd();
            return;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(630901141, i5, -1, "dk.molslinjen.ui.views.screens.developer.DeveloperBottomSheetContent.<anonymous> (DeveloperBottomSheetWithStickyScreen.kt:34)");
        }
        composer.startReplaceGroup(-180412571);
        final MutableState<Boolean> mutableState = this.$showBackAction$delegate;
        Object rememberedValue = composer.rememberedValue();
        if (rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = new Function0() { // from class: dk.molslinjen.ui.views.screens.developer.g
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit invoke$lambda$1$lambda$0;
                    invoke$lambda$1$lambda$0 = DeveloperBottomSheetWithStickyScreenKt$DeveloperBottomSheetContent$1.invoke$lambda$1$lambda$0(MutableState.this);
                    return invoke$lambda$1$lambda$0;
                }
            };
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceGroup();
        BottomSheetButtonKt.m3397BottomSheetButton1YH7lEI("Mine billetter", null, false, false, false, 0L, null, (Function0) rememberedValue, composer, 12582918, 126);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
