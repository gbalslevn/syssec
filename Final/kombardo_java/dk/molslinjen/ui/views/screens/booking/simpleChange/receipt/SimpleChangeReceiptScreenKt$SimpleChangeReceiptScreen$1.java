package dk.molslinjen.ui.views.screens.booking.simpleChange.receipt;

import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import com.ramcosta.composedestinations.result.ResultBackNavigator;
import dk.molslinjen.domain.managers.checkout.SimpleChangeCheckoutManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SimpleChangeReceiptScreenKt$SimpleChangeReceiptScreen$1 implements Function3<ColumnScope, Composer, Integer, Unit> {
    final /* synthetic */ ResultBackNavigator<Boolean> $resultNavigator;
    final /* synthetic */ SimpleChangeCheckoutManager.SimpleChangeCheckoutState $simpleChangeCheckoutState;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SimpleChangeReceiptScreenKt$SimpleChangeReceiptScreen$1(SimpleChangeCheckoutManager.SimpleChangeCheckoutState simpleChangeCheckoutState, ResultBackNavigator<Boolean> resultBackNavigator) {
        this.$simpleChangeCheckoutState = simpleChangeCheckoutState;
        this.$resultNavigator = resultBackNavigator;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$1$lambda$0(ResultBackNavigator resultBackNavigator) {
        resultBackNavigator.navigateBack(Boolean.TRUE);
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, Composer composer, Integer num) {
        invoke(columnScope, composer, num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(ColumnScope BottomSheetContainer, Composer composer, int i5) {
        Intrinsics.checkNotNullParameter(BottomSheetContainer, "$this$BottomSheetContainer");
        if ((i5 & 17) == 16 && composer.getSkipping()) {
            composer.skipToGroupEnd();
            return;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1608896644, i5, -1, "dk.molslinjen.ui.views.screens.booking.simpleChange.receipt.SimpleChangeReceiptScreen.<anonymous> (SimpleChangeReceiptScreen.kt:33)");
        }
        SimpleChangeCheckoutManager.SimpleChangeCheckoutState simpleChangeCheckoutState = this.$simpleChangeCheckoutState;
        composer.startReplaceGroup(-76680485);
        boolean changed = composer.changed(this.$resultNavigator);
        final ResultBackNavigator<Boolean> resultBackNavigator = this.$resultNavigator;
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = new Function0() { // from class: dk.molslinjen.ui.views.screens.booking.simpleChange.receipt.a
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit invoke$lambda$1$lambda$0;
                    invoke$lambda$1$lambda$0 = SimpleChangeReceiptScreenKt$SimpleChangeReceiptScreen$1.invoke$lambda$1$lambda$0(ResultBackNavigator.this);
                    return invoke$lambda$1$lambda$0;
                }
            };
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceGroup();
        SimpleChangeReceiptScreenKt.SimpleChangeReceiptContent(simpleChangeCheckoutState, (Function0) rememberedValue, composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
