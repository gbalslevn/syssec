package dk.molslinjen.ui.views.screens.booking.addons.seating.groups;

import androidx.compose.foundation.layout.RowScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import dk.molslinjen.kombardo.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ComposableSingletons$XLargeTableViewKt {
    public static final ComposableSingletons$XLargeTableViewKt INSTANCE = new ComposableSingletons$XLargeTableViewKt();

    /* renamed from: lambda-1, reason: not valid java name */
    private static Function3<RowScope, Composer, Integer, Unit> f166lambda1 = ComposableLambdaKt.composableLambdaInstance(-460331358, false, new Function3<RowScope, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.booking.addons.seating.groups.ComposableSingletons$XLargeTableViewKt$lambda-1$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer, Integer num) {
            invoke(rowScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(RowScope BaseSeatingRow, Composer composer, int i5) {
            Intrinsics.checkNotNullParameter(BaseSeatingRow, "$this$BaseSeatingRow");
            if ((i5 & 6) == 0) {
                i5 |= composer.changed(BaseSeatingRow) ? 4 : 2;
            }
            if ((i5 & 19) == 18 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-460331358, i5, -1, "dk.molslinjen.ui.views.screens.booking.addons.seating.groups.ComposableSingletons$XLargeTableViewKt.lambda-1.<anonymous> (XLargeTableView.kt:51)");
            }
            BaseSeatingViewsKt.SeatTableView(BaseSeatingRow, Integer.valueOf(R.drawable.seat_table_triple), composer, (i5 & 14) | 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: getLambda-1$app_kombardoProd, reason: not valid java name */
    public final Function3<RowScope, Composer, Integer, Unit> m3441getLambda1$app_kombardoProd() {
        return f166lambda1;
    }
}
