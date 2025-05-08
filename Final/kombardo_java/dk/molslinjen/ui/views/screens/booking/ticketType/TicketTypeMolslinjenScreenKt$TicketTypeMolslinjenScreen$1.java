package dk.molslinjen.ui.views.screens.booking.ticketType;

import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import com.ramcosta.composedestinations.spec.Direction;
import dk.molslinjen.domain.model.booking.DepartureTicket;
import dk.molslinjen.ui.views.screens.booking.ticketType.TicketTypeMolslinjenViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class TicketTypeMolslinjenScreenKt$TicketTypeMolslinjenScreen$1 implements Function3<ColumnScope, Composer, Integer, Unit> {
    final /* synthetic */ Function2<Direction, Boolean, Unit> $proceed;
    final /* synthetic */ TicketTypeMolslinjenViewModel $viewModel;
    final /* synthetic */ TicketTypeMolslinjenViewModel.ViewState $viewState;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public TicketTypeMolslinjenScreenKt$TicketTypeMolslinjenScreen$1(TicketTypeMolslinjenViewModel.ViewState viewState, TicketTypeMolslinjenViewModel ticketTypeMolslinjenViewModel, Function2<? super Direction, ? super Boolean, Unit> function2) {
        this.$viewState = viewState;
        this.$viewModel = ticketTypeMolslinjenViewModel;
        this.$proceed = function2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$1$lambda$0(TicketTypeMolslinjenViewModel ticketTypeMolslinjenViewModel, Function2 function2, DepartureTicket it) {
        Intrinsics.checkNotNullParameter(it, "it");
        ticketTypeMolslinjenViewModel.proceed(it, function2);
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, Composer composer, Integer num) {
        invoke(columnScope, composer, num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(ColumnScope BottomSheetContainer, Composer composer, int i5) {
        Intrinsics.checkNotNullParameter(BottomSheetContainer, "$this$BottomSheetContainer");
        if ((i5 & 6) == 0) {
            i5 |= composer.changed(BottomSheetContainer) ? 4 : 2;
        }
        if ((i5 & 19) == 18 && composer.getSkipping()) {
            composer.skipToGroupEnd();
            return;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(637110200, i5, -1, "dk.molslinjen.ui.views.screens.booking.ticketType.TicketTypeMolslinjenScreen.<anonymous> (TicketTypeMolslinjenScreen.kt:130)");
        }
        TicketTypeMolslinjenViewModel.ViewState viewState = this.$viewState;
        composer.startReplaceGroup(1891604840);
        boolean changedInstance = composer.changedInstance(this.$viewModel) | composer.changed(this.$proceed);
        final TicketTypeMolslinjenViewModel ticketTypeMolslinjenViewModel = this.$viewModel;
        final Function2<Direction, Boolean, Unit> function2 = this.$proceed;
        Object rememberedValue = composer.rememberedValue();
        if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = new Function1() { // from class: dk.molslinjen.ui.views.screens.booking.ticketType.c
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit invoke$lambda$1$lambda$0;
                    invoke$lambda$1$lambda$0 = TicketTypeMolslinjenScreenKt$TicketTypeMolslinjenScreen$1.invoke$lambda$1$lambda$0(TicketTypeMolslinjenViewModel.this, function2, (DepartureTicket) obj);
                    return invoke$lambda$1$lambda$0;
                }
            };
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceGroup();
        TicketTypeMolslinjenScreenKt.TicketTypeContent(BottomSheetContainer, viewState, (Function1) rememberedValue, composer, i5 & 14);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
