package dk.molslinjen.ui.views.screens.tickets.earlyCheckIn;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.lazy.grid.LazyGridItemScope;
import androidx.compose.material3.IconKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.unit.Dp;
import dk.molslinjen.core.extensions.Accessibility;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.views.reusable.HorizontalDividerKt;
import dk.molslinjen.ui.views.reusable.InfoBoxViewKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ComposableSingletons$EarlyCheckInScreenKt {
    public static final ComposableSingletons$EarlyCheckInScreenKt INSTANCE = new ComposableSingletons$EarlyCheckInScreenKt();

    /* renamed from: lambda-1, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f241lambda1 = ComposableLambdaKt.composableLambdaInstance(-1036821334, false, new Function2<Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.tickets.earlyCheckIn.ComposableSingletons$EarlyCheckInScreenKt$lambda-1$1
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
                ComposerKt.traceEventStart(-1036821334, i5, -1, "dk.molslinjen.ui.views.screens.tickets.earlyCheckIn.ComposableSingletons$EarlyCheckInScreenKt.lambda-1.<anonymous> (EarlyCheckInScreen.kt:197)");
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-2, reason: not valid java name */
    private static Function3<LazyGridItemScope, Composer, Integer, Unit> f242lambda2 = ComposableLambdaKt.composableLambdaInstance(271130773, false, new Function3<LazyGridItemScope, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.tickets.earlyCheckIn.ComposableSingletons$EarlyCheckInScreenKt$lambda-2$1
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
                ComposerKt.traceEventStart(271130773, i5, -1, "dk.molslinjen.ui.views.screens.tickets.earlyCheckIn.ComposableSingletons$EarlyCheckInScreenKt.lambda-2.<anonymous> (EarlyCheckInScreen.kt:240)");
            }
            HorizontalDividerKt.m3388HorizontalDividertZIQpXc(PaddingKt.m313paddingVpY3zN4$default(Modifier.INSTANCE, 0.0f, Dp.m2599constructorimpl(8), 1, null), 0L, 0.0f, null, composer, 6, 14);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-3, reason: not valid java name */
    private static Function3<LazyGridItemScope, Composer, Integer, Unit> f243lambda3 = ComposableLambdaKt.composableLambdaInstance(1553230530, false, new Function3<LazyGridItemScope, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.tickets.earlyCheckIn.ComposableSingletons$EarlyCheckInScreenKt$lambda-3$1
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
                ComposerKt.traceEventStart(1553230530, i5, -1, "dk.molslinjen.ui.views.screens.tickets.earlyCheckIn.ComposableSingletons$EarlyCheckInScreenKt.lambda-3.<anonymous> (EarlyCheckInScreen.kt:283)");
            }
            HorizontalDividerKt.m3388HorizontalDividertZIQpXc(PaddingKt.m315paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, Dp.m2599constructorimpl(8), 0.0f, 0.0f, 13, null), 0L, 0.0f, null, composer, 6, 14);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-4, reason: not valid java name */
    private static Function3<LazyGridItemScope, Composer, Integer, Unit> f244lambda4 = ComposableLambdaKt.composableLambdaInstance(970908282, false, new Function3<LazyGridItemScope, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.tickets.earlyCheckIn.ComposableSingletons$EarlyCheckInScreenKt$lambda-4$1
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
                ComposerKt.traceEventStart(970908282, i5, -1, "dk.molslinjen.ui.views.screens.tickets.earlyCheckIn.ComposableSingletons$EarlyCheckInScreenKt.lambda-4.<anonymous> (EarlyCheckInScreen.kt:318)");
            }
            HorizontalDividerKt.m3388HorizontalDividertZIQpXc(null, 0L, 0.0f, null, composer, 0, 15);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-5, reason: not valid java name */
    private static Function3<LazyGridItemScope, Composer, Integer, Unit> f245lambda5 = ComposableLambdaKt.composableLambdaInstance(-1354876363, false, new Function3<LazyGridItemScope, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.tickets.earlyCheckIn.ComposableSingletons$EarlyCheckInScreenKt$lambda-5$1
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
                ComposerKt.traceEventStart(-1354876363, i5, -1, "dk.molslinjen.ui.views.screens.tickets.earlyCheckIn.ComposableSingletons$EarlyCheckInScreenKt.lambda-5.<anonymous> (EarlyCheckInScreen.kt:388)");
            }
            InfoBoxViewKt.InfoBoxView(null, 0, StringResources_androidKt.stringResource(R.string.earlyCheckIn_seatReservation_unavailable, composer, 6), false, composer, 0, 11);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-6, reason: not valid java name */
    private static Function3<LazyGridItemScope, Composer, Integer, Unit> f246lambda6 = ComposableLambdaKt.composableLambdaInstance(1639589557, false, new Function3<LazyGridItemScope, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.tickets.earlyCheckIn.ComposableSingletons$EarlyCheckInScreenKt$lambda-6$1
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
                ComposerKt.traceEventStart(1639589557, i5, -1, "dk.molslinjen.ui.views.screens.tickets.earlyCheckIn.ComposableSingletons$EarlyCheckInScreenKt.lambda-6.<anonymous> (EarlyCheckInScreen.kt:414)");
            }
            SpacerKt.Spacer(SizeKt.m325height3ABfNKs(Modifier.INSTANCE, Dp.m2599constructorimpl(24)), composer, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-7, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f247lambda7 = ComposableLambdaKt.composableLambdaInstance(-518319604, false, new Function2<Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.tickets.earlyCheckIn.ComposableSingletons$EarlyCheckInScreenKt$lambda-7$1
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
                ComposerKt.traceEventStart(-518319604, i5, -1, "dk.molslinjen.ui.views.screens.tickets.earlyCheckIn.ComposableSingletons$EarlyCheckInScreenKt.lambda-7.<anonymous> (EarlyCheckInScreen.kt:476)");
            }
            IconKt.m857Iconww6aTOc(PainterResources_androidKt.painterResource(R.drawable.icon_edit_circle_white, composer, 6), Accessibility.INSTANCE.getSkip(), SizeKt.m331size3ABfNKs(Modifier.INSTANCE, Dp.m2599constructorimpl(32)), Color.INSTANCE.m1501getUnspecified0d7_KjU(), composer, 3456, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: getLambda-1$app_kombardoProd, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m3544getLambda1$app_kombardoProd() {
        return f241lambda1;
    }

    /* renamed from: getLambda-2$app_kombardoProd, reason: not valid java name */
    public final Function3<LazyGridItemScope, Composer, Integer, Unit> m3545getLambda2$app_kombardoProd() {
        return f242lambda2;
    }

    /* renamed from: getLambda-3$app_kombardoProd, reason: not valid java name */
    public final Function3<LazyGridItemScope, Composer, Integer, Unit> m3546getLambda3$app_kombardoProd() {
        return f243lambda3;
    }

    /* renamed from: getLambda-4$app_kombardoProd, reason: not valid java name */
    public final Function3<LazyGridItemScope, Composer, Integer, Unit> m3547getLambda4$app_kombardoProd() {
        return f244lambda4;
    }

    /* renamed from: getLambda-5$app_kombardoProd, reason: not valid java name */
    public final Function3<LazyGridItemScope, Composer, Integer, Unit> m3548getLambda5$app_kombardoProd() {
        return f245lambda5;
    }

    /* renamed from: getLambda-6$app_kombardoProd, reason: not valid java name */
    public final Function3<LazyGridItemScope, Composer, Integer, Unit> m3549getLambda6$app_kombardoProd() {
        return f246lambda6;
    }

    /* renamed from: getLambda-7$app_kombardoProd, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m3550getLambda7$app_kombardoProd() {
        return f247lambda7;
    }
}
