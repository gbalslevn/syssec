package dk.molslinjen.ui.views.shared.ticket.ticketSummary;

import androidx.compose.foundation.layout.RowScope;
import androidx.compose.material3.IconKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.res.PainterResources_androidKt;
import dk.molslinjen.core.extensions.Accessibility;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.theme.AppColor;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ComposableSingletons$TicketSummaryFooterRowKt {
    public static final ComposableSingletons$TicketSummaryFooterRowKt INSTANCE = new ComposableSingletons$TicketSummaryFooterRowKt();

    /* renamed from: lambda-1, reason: not valid java name */
    private static Function3<RowScope, Composer, Integer, Unit> f255lambda1 = ComposableLambdaKt.composableLambdaInstance(1251857287, false, new Function3<RowScope, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.shared.ticket.ticketSummary.ComposableSingletons$TicketSummaryFooterRowKt$lambda-1$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer, Integer num) {
            invoke(rowScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(RowScope TertiaryButton, Composer composer, int i5) {
            Intrinsics.checkNotNullParameter(TertiaryButton, "$this$TertiaryButton");
            if ((i5 & 17) == 16 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1251857287, i5, -1, "dk.molslinjen.ui.views.shared.ticket.ticketSummary.ComposableSingletons$TicketSummaryFooterRowKt.lambda-1.<anonymous> (TicketSummaryFooterRow.kt:55)");
            }
            IconKt.m857Iconww6aTOc(PainterResources_androidKt.painterResource(R.drawable.icon_calendar, composer, 6), Accessibility.INSTANCE.getSkip(), (Modifier) null, AppColor.INSTANCE.m3255getBrandBlue10d7_KjU(), composer, 3072, 4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: getLambda-1$app_kombardoProd, reason: not valid java name */
    public final Function3<RowScope, Composer, Integer, Unit> m3560getLambda1$app_kombardoProd() {
        return f255lambda1;
    }
}
