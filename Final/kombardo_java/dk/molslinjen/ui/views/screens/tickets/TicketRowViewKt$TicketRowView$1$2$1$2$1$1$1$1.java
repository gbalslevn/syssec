package dk.molslinjen.ui.views.screens.tickets;

import androidx.compose.foundation.layout.FlowRowScope;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.TextStyle;
import dk.molslinjen.core.extensions.AccessibilityKt;
import dk.molslinjen.domain.extensions.LocalDateTimeExtensionsKt;
import dk.molslinjen.domain.model.booking.BookingHeader;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.theme.AppColor;
import dk.molslinjen.ui.theme.TypographyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
final class TicketRowViewKt$TicketRowView$1$2$1$2$1$1$1$1 implements Function3<FlowRowScope, Composer, Integer, Unit> {
    final /* synthetic */ BookingHeader $bookingHeader;

    /* JADX INFO: Access modifiers changed from: package-private */
    public TicketRowViewKt$TicketRowView$1$2$1$2$1$1$1$1(BookingHeader bookingHeader) {
        this.$bookingHeader = bookingHeader;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$1$lambda$0(String str, BookingHeader bookingHeader, SemanticsPropertyReceiver semantics) {
        Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
        SemanticsPropertiesKt.setContentDescription(semantics, str + " " + AccessibilityKt.splitNumberForAccessibility(bookingHeader.getReservationId()));
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(FlowRowScope flowRowScope, Composer composer, Integer num) {
        invoke(flowRowScope, composer, num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(FlowRowScope FlowRow, Composer composer, int i5) {
        int i6;
        Intrinsics.checkNotNullParameter(FlowRow, "$this$FlowRow");
        if ((i5 & 6) == 0) {
            i6 = i5 | (composer.changed(FlowRow) ? 4 : 2);
        } else {
            i6 = i5;
        }
        if ((i6 & 19) == 18 && composer.getSkipping()) {
            composer.skipToGroupEnd();
            return;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1483163725, i6, -1, "dk.molslinjen.ui.views.screens.tickets.TicketRowView.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (TicketRowView.kt:123)");
        }
        String formatWeekdayWithDate = LocalDateTimeExtensionsKt.toFormatWeekdayWithDate(this.$bookingHeader.getDate());
        TextStyle sub = TypographyKt.getSub();
        AppColor appColor = AppColor.INSTANCE;
        TextKt.m940Text4IGK_g(formatWeekdayWithDate, null, appColor.m3264getGrey10d7_KjU(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, sub, composer, 384, 1572864, 65530);
        Modifier.Companion companion = Modifier.INSTANCE;
        SpacerKt.Spacer(RowScope.weight$default(FlowRow, companion, 1.0f, false, 2, null), composer, 0);
        final String stringResource = StringResources_androidKt.stringResource(R.string.common_reservationNumber, composer, 6);
        composer.startReplaceGroup(227735576);
        boolean changed = composer.changed(stringResource) | composer.changedInstance(this.$bookingHeader);
        final BookingHeader bookingHeader = this.$bookingHeader;
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = new Function1() { // from class: dk.molslinjen.ui.views.screens.tickets.d
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit invoke$lambda$1$lambda$0;
                    invoke$lambda$1$lambda$0 = TicketRowViewKt$TicketRowView$1$2$1$2$1$1$1$1.invoke$lambda$1$lambda$0(stringResource, bookingHeader, (SemanticsPropertyReceiver) obj);
                    return invoke$lambda$1$lambda$0;
                }
            };
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceGroup();
        TextKt.m940Text4IGK_g("#" + this.$bookingHeader.getReservationId(), SemanticsModifierKt.semantics$default(companion, false, (Function1) rememberedValue, 1, null), appColor.m3264getGrey10d7_KjU(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getSub(), composer, 384, 1572864, 65528);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
