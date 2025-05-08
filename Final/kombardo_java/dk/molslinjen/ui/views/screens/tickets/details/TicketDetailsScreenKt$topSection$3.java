package dk.molslinjen.ui.views.screens.tickets.details;

import android.content.Context;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import dk.molslinjen.core.Feature;
import dk.molslinjen.domain.model.booking.Booking;
import dk.molslinjen.ui.views.screens.tickets.details.TicketDetailsViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class TicketDetailsScreenKt$topSection$3 implements Function3<LazyItemScope, Composer, Integer, Unit> {
    final /* synthetic */ Function0<Unit> $editTicket;
    final /* synthetic */ Function0<Unit> $refund;
    final /* synthetic */ Function1<Context, Unit> $shareReceipt;
    final /* synthetic */ Function0<Unit> $showReceiptDisabledMessage;
    final /* synthetic */ Function0<Unit> $showRefundDisabledMessage;
    final /* synthetic */ TicketDetailsViewModel.ViewState $state;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public TicketDetailsScreenKt$topSection$3(TicketDetailsViewModel.ViewState viewState, Function0<Unit> function0, Function1<? super Context, Unit> function1, Function0<Unit> function02, Function0<Unit> function03, Function0<Unit> function04) {
        this.$state = viewState;
        this.$refund = function0;
        this.$shareReceipt = function1;
        this.$editTicket = function02;
        this.$showReceiptDisabledMessage = function03;
        this.$showRefundDisabledMessage = function04;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$1$lambda$0(Function1 function1, Context context) {
        function1.invoke(context);
        return Unit.INSTANCE;
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
            ComposerKt.traceEventStart(654952908, i5, -1, "dk.molslinjen.ui.views.screens.tickets.details.topSection.<anonymous> (TicketDetailsScreen.kt:345)");
        }
        final Context context = (Context) composer.consume(AndroidCompositionLocals_androidKt.getLocalContext());
        Booking booking = this.$state.getBooking();
        boolean z5 = false;
        boolean z6 = booking != null && booking.isRefundAvailable();
        Booking booking2 = this.$state.getBooking();
        if (booking2 != null && booking2.getCanChange()) {
            z5 = true;
        }
        boolean isReceiptShareable = this.$state.getIsReceiptShareable();
        boolean z7 = !Feature.MultipleTicketTypes.isEnabled();
        boolean isEnabled = true ^ Feature.Account.isEnabled();
        boolean isLoadingPdfReceipt = this.$state.getIsLoadingPdfReceipt();
        Function0<Unit> function0 = this.$refund;
        composer.startReplaceGroup(-314177012);
        boolean changed = composer.changed(this.$shareReceipt) | composer.changedInstance(context);
        final Function1<Context, Unit> function1 = this.$shareReceipt;
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = new Function0() { // from class: dk.molslinjen.ui.views.screens.tickets.details.e
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit invoke$lambda$1$lambda$0;
                    invoke$lambda$1$lambda$0 = TicketDetailsScreenKt$topSection$3.invoke$lambda$1$lambda$0(Function1.this, context);
                    return invoke$lambda$1$lambda$0;
                }
            };
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceGroup();
        TicketDetailsActionButtonsSectionKt.TicketDetailsActionButtonsSection(z6, z5, isReceiptShareable, isEnabled, z7, function0, (Function0) rememberedValue, this.$editTicket, this.$showReceiptDisabledMessage, this.$showRefundDisabledMessage, isLoadingPdfReceipt, composer, 0, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
