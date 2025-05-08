package dk.molslinjen.ui.views.screens.booking.departures;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import dk.molslinjen.kombardo.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ComposableSingletons$DepartureDirectionTabsKt {
    public static final ComposableSingletons$DepartureDirectionTabsKt INSTANCE = new ComposableSingletons$DepartureDirectionTabsKt();

    /* renamed from: lambda-1, reason: not valid java name */
    private static Function3<Boolean, Composer, Integer, Unit> f167lambda1 = ComposableLambdaKt.composableLambdaInstance(-348264256, false, new Function3<Boolean, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.booking.departures.ComposableSingletons$DepartureDirectionTabsKt$lambda-1$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, Composer composer, Integer num) {
            invoke(bool.booleanValue(), composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(boolean z5, Composer composer, int i5) {
            if ((i5 & 6) == 0) {
                i5 |= composer.changed(z5) ? 4 : 2;
            }
            if ((i5 & 19) == 18 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-348264256, i5, -1, "dk.molslinjen.ui.views.screens.booking.departures.ComposableSingletons$DepartureDirectionTabsKt.lambda-1.<anonymous> (DepartureDirectionTabs.kt:114)");
            }
            if (z5) {
                composer.startReplaceGroup(1789112379);
                DepartureDirectionTabsKt.access$IconView(R.drawable.icon_checkmark_tick_small_blue, composer, 6);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(1789208727);
                DepartureDirectionTabsKt.access$IconView(R.drawable.icon_checkmark_tick_small_disabled, composer, 6);
                composer.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: getLambda-1$app_kombardoProd, reason: not valid java name */
    public final Function3<Boolean, Composer, Integer, Unit> m3456getLambda1$app_kombardoProd() {
        return f167lambda1;
    }
}
