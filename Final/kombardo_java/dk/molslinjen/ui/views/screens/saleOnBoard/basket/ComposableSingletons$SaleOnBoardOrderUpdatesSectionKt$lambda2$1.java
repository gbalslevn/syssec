package dk.molslinjen.ui.views.screens.saleOnBoard.basket;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.res.StringResources_androidKt;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.views.reusable.buttons.SecondaryButtonKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* renamed from: dk.molslinjen.ui.views.screens.saleOnBoard.basket.ComposableSingletons$SaleOnBoardOrderUpdatesSectionKt$lambda-2$1, reason: invalid class name */
/* loaded from: classes2.dex */
final class ComposableSingletons$SaleOnBoardOrderUpdatesSectionKt$lambda2$1 implements Function4<Boolean, Function1<? super Boolean, ? extends Unit>, Composer, Integer, Unit> {
    public static final ComposableSingletons$SaleOnBoardOrderUpdatesSectionKt$lambda2$1 INSTANCE = new ComposableSingletons$SaleOnBoardOrderUpdatesSectionKt$lambda2$1();

    ComposableSingletons$SaleOnBoardOrderUpdatesSectionKt$lambda2$1() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$1$lambda$0(Function1 function1) {
        function1.invoke(Boolean.TRUE);
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function4
    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, Function1<? super Boolean, ? extends Unit> function1, Composer composer, Integer num) {
        invoke(bool.booleanValue(), (Function1<? super Boolean, Unit>) function1, composer, num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(boolean z5, final Function1<? super Boolean, Unit> onToggle, Composer composer, int i5) {
        int i6;
        Intrinsics.checkNotNullParameter(onToggle, "onToggle");
        if ((i5 & 6) == 0) {
            i6 = i5 | (composer.changed(z5) ? 4 : 2);
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= composer.changedInstance(onToggle) ? 32 : 16;
        }
        if ((i6 & 147) == 146 && composer.getSkipping()) {
            composer.skipToGroupEnd();
            return;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-466613215, i6, -1, "dk.molslinjen.ui.views.screens.saleOnBoard.basket.ComposableSingletons$SaleOnBoardOrderUpdatesSectionKt.lambda-2.<anonymous> (SaleOnBoardOrderUpdatesSection.kt:161)");
        }
        String stringResource = StringResources_androidKt.stringResource(R.string.saleOnBoard_basket_orderUpdates_notificationPermission_details, composer, 6);
        composer.startReplaceGroup(-1168655189);
        boolean z6 = (i6 & 112) == 32;
        Object rememberedValue = composer.rememberedValue();
        if (z6 || rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = new Function0() { // from class: dk.molslinjen.ui.views.screens.saleOnBoard.basket.a
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit invoke$lambda$1$lambda$0;
                    invoke$lambda$1$lambda$0 = ComposableSingletons$SaleOnBoardOrderUpdatesSectionKt$lambda2$1.invoke$lambda$1$lambda$0(Function1.this);
                    return invoke$lambda$1$lambda$0;
                }
            };
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceGroup();
        SecondaryButtonKt.m3406SecondaryButtonbZJ32A(null, stringResource, (Function0) rememberedValue, null, z5, null, false, null, null, 0L, false, composer, (i6 << 12) & 57344, 0, 2025);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
