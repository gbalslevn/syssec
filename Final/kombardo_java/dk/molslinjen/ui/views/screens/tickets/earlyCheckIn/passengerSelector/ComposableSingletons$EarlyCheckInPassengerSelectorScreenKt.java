package dk.molslinjen.ui.views.screens.tickets.earlyCheckIn.passengerSelector;

import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import dk.molslinjen.ui.views.reusable.LoadingComponentKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ComposableSingletons$EarlyCheckInPassengerSelectorScreenKt {
    public static final ComposableSingletons$EarlyCheckInPassengerSelectorScreenKt INSTANCE = new ComposableSingletons$EarlyCheckInPassengerSelectorScreenKt();

    /* renamed from: lambda-1, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f248lambda1 = ComposableLambdaKt.composableLambdaInstance(-1006820842, false, new Function2<Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.tickets.earlyCheckIn.passengerSelector.ComposableSingletons$EarlyCheckInPassengerSelectorScreenKt$lambda-1$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer composer, int i5) {
            if ((i5 & 3) == 2 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1006820842, i5, -1, "dk.molslinjen.ui.views.screens.tickets.earlyCheckIn.passengerSelector.ComposableSingletons$EarlyCheckInPassengerSelectorScreenKt.lambda-1.<anonymous> (EarlyCheckInPassengerSelectorScreen.kt:150)");
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-2, reason: not valid java name */
    private static Function3<LazyItemScope, Composer, Integer, Unit> f249lambda2 = ComposableLambdaKt.composableLambdaInstance(-1315403318, false, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.tickets.earlyCheckIn.passengerSelector.ComposableSingletons$EarlyCheckInPassengerSelectorScreenKt$lambda-2$1
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
                ComposerKt.traceEventStart(-1315403318, i5, -1, "dk.molslinjen.ui.views.screens.tickets.earlyCheckIn.passengerSelector.ComposableSingletons$EarlyCheckInPassengerSelectorScreenKt.lambda-2.<anonymous> (EarlyCheckInPassengerSelectorScreen.kt:150)");
            }
            LoadingComponentKt.m3392LoadingComponentjfnsLPA(null, 0.0f, true, 0, false, null, ComposableSingletons$EarlyCheckInPassengerSelectorScreenKt.INSTANCE.m3551getLambda1$app_kombardoProd(), composer, 1573248, 59);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: getLambda-1$app_kombardoProd, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m3551getLambda1$app_kombardoProd() {
        return f248lambda1;
    }

    /* renamed from: getLambda-2$app_kombardoProd, reason: not valid java name */
    public final Function3<LazyItemScope, Composer, Integer, Unit> m3552getLambda2$app_kombardoProd() {
        return f249lambda2;
    }
}
