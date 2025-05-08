package dk.molslinjen.ui.views.screens.booking.departures.rows;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.Dp;
import dk.molslinjen.domain.extensions.LocalDateTimeExtensionsKt;
import dk.molslinjen.ui.theme.TypographyKt;
import dk.molslinjen.ui.views.screens.booking.departures.rows.DepartureDayHeaderViewKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;
import org.threeten.bp.LocalDate;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a\u0017\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lorg/threeten/bp/LocalDate;", "date", BuildConfig.FLAVOR, "DepartureDayHeaderView", "(Lorg/threeten/bp/LocalDate;Landroidx/compose/runtime/Composer;I)V", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class DepartureDayHeaderViewKt {
    public static final void DepartureDayHeaderView(final LocalDate date, Composer composer, final int i5) {
        int i6;
        Composer composer2;
        Intrinsics.checkNotNullParameter(date, "date");
        Composer startRestartGroup = composer.startRestartGroup(503594289);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(date) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i6 & 3) == 2 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(503594289, i6, -1, "dk.molslinjen.ui.views.screens.booking.departures.rows.DepartureDayHeaderView (DepartureDayHeaderView.kt:15)");
            }
            float f5 = 16;
            composer2 = startRestartGroup;
            TextKt.m940Text4IGK_g(LocalDateTimeExtensionsKt.toFormatWeekdayWithDate(date), PaddingKt.m315paddingqDBjuR0$default(Modifier.INSTANCE, Dp.m2599constructorimpl(f5), Dp.m2599constructorimpl(8), Dp.m2599constructorimpl(f5), 0.0f, 8, null), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getParagraphSmallBold(), composer2, 0, 1572864, 65532);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: M2.c
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit DepartureDayHeaderView$lambda$0;
                    DepartureDayHeaderView$lambda$0 = DepartureDayHeaderViewKt.DepartureDayHeaderView$lambda$0(LocalDate.this, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return DepartureDayHeaderView$lambda$0;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DepartureDayHeaderView$lambda$0(LocalDate localDate, int i5, Composer composer, int i6) {
        DepartureDayHeaderView(localDate, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }
}
