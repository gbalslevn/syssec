package dk.molslinjen.ui.views.screens.booking.departures.selectTransportation;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.unit.Dp;
import dk.molslinjen.domain.model.config.Transportation;
import dk.molslinjen.extensions.ModifierExtensionsKt;
import dk.molslinjen.ui.theme.AppColor;
import dk.molslinjen.ui.views.reusable.HorizontalDividerKt;
import dk.molslinjen.ui.views.screens.booking.departures.selectTransportation.TransportationSelectorViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class TransportationSelectorScreenKt$transportationItems$1 implements Function3<LazyItemScope, Composer, Integer, Unit> {
    final /* synthetic */ boolean $isFirst;
    final /* synthetic */ boolean $isLast;
    final /* synthetic */ boolean $showTicketCategories;
    final /* synthetic */ Transportation $transportation;
    final /* synthetic */ Function1<Transportation, Unit> $transportationSelected;
    final /* synthetic */ TransportationSelectorViewModel.ViewState $viewState;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public TransportationSelectorScreenKt$transportationItems$1(boolean z5, boolean z6, boolean z7, Transportation transportation, TransportationSelectorViewModel.ViewState viewState, Function1<? super Transportation, Unit> function1) {
        this.$isFirst = z5;
        this.$showTicketCategories = z6;
        this.$isLast = z7;
        this.$transportation = transportation;
        this.$viewState = viewState;
        this.$transportationSelected = function1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Modifier invoke$lambda$1$lambda$0(boolean z5, boolean z6, Modifier applyIf) {
        Intrinsics.checkNotNullParameter(applyIf, "$this$applyIf");
        return BackgroundKt.m104backgroundbw27NRU$default(ClipKt.clip(Modifier.INSTANCE, RoundedCornerShapeKt.m461RoundedCornerShapea9UjIt4(Dp.m2599constructorimpl(z5 ? 8 : 0), Dp.m2599constructorimpl(z5 ? 8 : 0), Dp.m2599constructorimpl(z6 ? 8 : 0), Dp.m2599constructorimpl(z6 ? 8 : 0))), AppColor.INSTANCE.m3281getWhite0d7_KjU(), null, 2, null);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer, Integer num) {
        invoke(lazyItemScope, composer, num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(LazyItemScope item, Composer composer, int i5) {
        Intrinsics.checkNotNullParameter(item, "$this$item");
        if ((i5 & 17) == 16 && composer.getSkipping()) {
            composer.skipToGroupEnd();
            return;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(289094771, i5, -1, "dk.molslinjen.ui.views.screens.booking.departures.selectTransportation.transportationItems.<anonymous> (TransportationSelectorScreen.kt:199)");
        }
        composer.startReplaceGroup(-836583908);
        if (!this.$isFirst || !this.$showTicketCategories) {
            HorizontalDividerKt.m3388HorizontalDividertZIQpXc(null, 0L, 0.0f, null, composer, 0, 15);
        }
        composer.endReplaceGroup();
        Modifier.Companion companion = Modifier.INSTANCE;
        boolean z5 = this.$showTicketCategories;
        composer.startReplaceGroup(-836576712);
        boolean changed = composer.changed(this.$isFirst) | composer.changed(this.$isLast);
        final boolean z6 = this.$isFirst;
        final boolean z7 = this.$isLast;
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = new Function1() { // from class: dk.molslinjen.ui.views.screens.booking.departures.selectTransportation.g
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Modifier invoke$lambda$1$lambda$0;
                    invoke$lambda$1$lambda$0 = TransportationSelectorScreenKt$transportationItems$1.invoke$lambda$1$lambda$0(z6, z7, (Modifier) obj);
                    return invoke$lambda$1$lambda$0;
                }
            };
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceGroup();
        Modifier applyIf = ModifierExtensionsKt.applyIf(companion, z5, (Function1) rememberedValue);
        Transportation transportation = this.$transportation;
        String id = transportation.getId();
        Transportation selectedTransportation = this.$viewState.getSelectedTransportation();
        TransportationSelectorScreenKt.TransportationRow(applyIf, transportation, Intrinsics.areEqual(id, selectedTransportation != null ? selectedTransportation.getId() : null), this.$transportationSelected, composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
