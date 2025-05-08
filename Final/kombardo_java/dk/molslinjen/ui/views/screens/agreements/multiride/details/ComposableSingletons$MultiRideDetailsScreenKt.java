package dk.molslinjen.ui.views.screens.agreements.multiride.details;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.unit.Dp;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.theme.TypographyKt;
import dk.molslinjen.ui.views.screens.agreements.common.AgreementDetailsEmptyStateCardKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ComposableSingletons$MultiRideDetailsScreenKt {
    public static final ComposableSingletons$MultiRideDetailsScreenKt INSTANCE = new ComposableSingletons$MultiRideDetailsScreenKt();

    /* renamed from: lambda-1, reason: not valid java name */
    private static Function3<LazyItemScope, Composer, Integer, Unit> f161lambda1 = ComposableLambdaKt.composableLambdaInstance(-1636605702, false, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.agreements.multiride.details.ComposableSingletons$MultiRideDetailsScreenKt$lambda-1$1
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
                ComposerKt.traceEventStart(-1636605702, i5, -1, "dk.molslinjen.ui.views.screens.agreements.multiride.details.ComposableSingletons$MultiRideDetailsScreenKt.lambda-1.<anonymous> (MultiRideDetailsScreen.kt:187)");
            }
            TextKt.m940Text4IGK_g(StringResources_androidKt.stringResource(R.string.multiRide_associatedVehicles_header, composer, 6), PaddingKt.m315paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, Dp.m2599constructorimpl(32), 0.0f, Dp.m2599constructorimpl(16), 5, null), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getParagraphSmallBold(), composer, 48, 1572864, 65532);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-2, reason: not valid java name */
    private static Function3<LazyItemScope, Composer, Integer, Unit> f162lambda2 = ComposableLambdaKt.composableLambdaInstance(-1680297031, false, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.agreements.multiride.details.ComposableSingletons$MultiRideDetailsScreenKt$lambda-2$1
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
                ComposerKt.traceEventStart(-1680297031, i5, -1, "dk.molslinjen.ui.views.screens.agreements.multiride.details.ComposableSingletons$MultiRideDetailsScreenKt.lambda-2.<anonymous> (MultiRideDetailsScreen.kt:200)");
            }
            AgreementDetailsEmptyStateCardKt.AgreementDetailsEmptyStateCard(R.drawable.icon_profile_vehicles, StringResources_androidKt.stringResource(R.string.multiRide_associatedVehicles_emptyDescription, composer, 6), composer, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-3, reason: not valid java name */
    private static Function3<LazyItemScope, Composer, Integer, Unit> f163lambda3 = ComposableLambdaKt.composableLambdaInstance(-735247335, false, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.agreements.multiride.details.ComposableSingletons$MultiRideDetailsScreenKt$lambda-3$1
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
                ComposerKt.traceEventStart(-735247335, i5, -1, "dk.molslinjen.ui.views.screens.agreements.multiride.details.ComposableSingletons$MultiRideDetailsScreenKt.lambda-3.<anonymous> (MultiRideDetailsScreen.kt:220)");
            }
            SpacerKt.Spacer(SizeKt.m325height3ABfNKs(Modifier.INSTANCE, Dp.m2599constructorimpl(8)), composer, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: getLambda-1$app_kombardoProd, reason: not valid java name */
    public final Function3<LazyItemScope, Composer, Integer, Unit> m3433getLambda1$app_kombardoProd() {
        return f161lambda1;
    }

    /* renamed from: getLambda-2$app_kombardoProd, reason: not valid java name */
    public final Function3<LazyItemScope, Composer, Integer, Unit> m3434getLambda2$app_kombardoProd() {
        return f162lambda2;
    }

    /* renamed from: getLambda-3$app_kombardoProd, reason: not valid java name */
    public final Function3<LazyItemScope, Composer, Integer, Unit> m3435getLambda3$app_kombardoProd() {
        return f163lambda3;
    }
}
