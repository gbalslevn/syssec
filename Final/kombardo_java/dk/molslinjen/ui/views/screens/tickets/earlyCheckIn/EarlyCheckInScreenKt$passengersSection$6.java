package dk.molslinjen.ui.views.screens.tickets.earlyCheckIn;

import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.lazy.grid.LazyGridItemScope;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Dp;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.theme.AppColor;
import dk.molslinjen.ui.theme.TypographyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
final class EarlyCheckInScreenKt$passengersSection$6 implements Function3<LazyGridItemScope, Composer, Integer, Unit> {
    final /* synthetic */ MutableState<Boolean> $showAllPassengers;

    /* JADX INFO: Access modifiers changed from: package-private */
    public EarlyCheckInScreenKt$passengersSection$6(MutableState<Boolean> mutableState) {
        this.$showAllPassengers = mutableState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$1$lambda$0(MutableState mutableState) {
        mutableState.setValue(Boolean.valueOf(!((Boolean) mutableState.getValue()).booleanValue()));
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(LazyGridItemScope lazyGridItemScope, Composer composer, Integer num) {
        invoke(lazyGridItemScope, composer, num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(LazyGridItemScope item, Composer composer, int i5) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        if ((i5 & 17) == 16 && composer.getSkipping()) {
            composer.skipToGroupEnd();
            return;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1998984994, i5, -1, "dk.molslinjen.ui.views.screens.tickets.earlyCheckIn.passengersSection.<anonymous> (EarlyCheckInScreen.kt:402)");
        }
        Modifier.Companion companion = Modifier.INSTANCE;
        composer.startReplaceGroup(-950092983);
        boolean changed = composer.changed(this.$showAllPassengers);
        final MutableState<Boolean> mutableState = this.$showAllPassengers;
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = new Function0() { // from class: dk.molslinjen.ui.views.screens.tickets.earlyCheckIn.i
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit invoke$lambda$1$lambda$0;
                    invoke$lambda$1$lambda$0 = EarlyCheckInScreenKt$passengersSection$6.invoke$lambda$1$lambda$0(MutableState.this);
                    return invoke$lambda$1$lambda$0;
                }
            };
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceGroup();
        TextKt.m940Text4IGK_g(StringResources_androidKt.stringResource(this.$showAllPassengers.getValue().booleanValue() ? R.string.common_showLess : R.string.common_showAll, composer, 0), PaddingKt.m311padding3ABfNKs(ClickableKt.m122clickableXHw0xAI$default(companion, false, null, null, (Function0) rememberedValue, 7, null), Dp.m2599constructorimpl(8)), AppColor.INSTANCE.m3255getBrandBlue10d7_KjU(), 0L, null, null, null, 0L, null, TextAlign.m2521boximpl(TextAlign.INSTANCE.m2528getCentere0LSkKk()), 0L, 0, false, 0, 0, null, TypographyKt.getSubBold(), composer, 384, 1572864, 65016);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
