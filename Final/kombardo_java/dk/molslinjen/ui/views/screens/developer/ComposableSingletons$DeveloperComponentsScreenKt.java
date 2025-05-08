package dk.molslinjen.ui.views.screens.developer;

import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.Dp;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.views.screens.booking.departures.rows.DepartureDayHeaderViewKt;
import dk.molslinjen.ui.views.screens.booking.departures.rows.EmptyDeparturesViewKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.threeten.bp.LocalDate;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ComposableSingletons$DeveloperComponentsScreenKt {
    public static final ComposableSingletons$DeveloperComponentsScreenKt INSTANCE = new ComposableSingletons$DeveloperComponentsScreenKt();

    /* renamed from: lambda-1, reason: not valid java name */
    private static Function3<LazyItemScope, Composer, Integer, Unit> f186lambda1 = ComposableLambdaKt.composableLambdaInstance(-1356763189, false, ComposableSingletons$DeveloperComponentsScreenKt$lambda1$1.INSTANCE);

    /* renamed from: lambda-2, reason: not valid java name */
    private static Function3<LazyItemScope, Composer, Integer, Unit> f187lambda2 = ComposableLambdaKt.composableLambdaInstance(241471988, false, ComposableSingletons$DeveloperComponentsScreenKt$lambda2$1.INSTANCE);

    /* renamed from: lambda-3, reason: not valid java name */
    private static Function3<LazyItemScope, Composer, Integer, Unit> f188lambda3 = ComposableLambdaKt.composableLambdaInstance(-173854829, false, ComposableSingletons$DeveloperComponentsScreenKt$lambda3$1.INSTANCE);

    /* renamed from: lambda-4, reason: not valid java name */
    private static Function3<LazyItemScope, Composer, Integer, Unit> f189lambda4 = ComposableLambdaKt.composableLambdaInstance(-589181646, false, ComposableSingletons$DeveloperComponentsScreenKt$lambda4$1.INSTANCE);

    /* renamed from: lambda-5, reason: not valid java name */
    private static Function3<LazyItemScope, Composer, Integer, Unit> f190lambda5 = ComposableLambdaKt.composableLambdaInstance(-1004508463, false, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.developer.ComposableSingletons$DeveloperComponentsScreenKt$lambda-5$1
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
                ComposerKt.traceEventStart(-1004508463, i5, -1, "dk.molslinjen.ui.views.screens.developer.ComposableSingletons$DeveloperComponentsScreenKt.lambda-5.<anonymous> (DeveloperComponentsScreen.kt:53)");
            }
            LocalDate now = LocalDate.now();
            Intrinsics.checkNotNullExpressionValue(now, "now(...)");
            DepartureDayHeaderViewKt.DepartureDayHeaderView(now, composer, 0);
            SpacerKt.Spacer(SizeKt.m325height3ABfNKs(Modifier.INSTANCE, Dp.m2599constructorimpl(16)), composer, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-6, reason: not valid java name */
    private static Function3<LazyItemScope, Composer, Integer, Unit> f191lambda6 = ComposableLambdaKt.composableLambdaInstance(-1419835280, false, ComposableSingletons$DeveloperComponentsScreenKt$lambda6$1.INSTANCE);

    /* renamed from: lambda-7, reason: not valid java name */
    private static Function3<LazyItemScope, Composer, Integer, Unit> f192lambda7 = ComposableLambdaKt.composableLambdaInstance(-1835162097, false, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.developer.ComposableSingletons$DeveloperComponentsScreenKt$lambda-7$1
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
                ComposerKt.traceEventStart(-1835162097, i5, -1, "dk.molslinjen.ui.views.screens.developer.ComposableSingletons$DeveloperComponentsScreenKt.lambda-7.<anonymous> (DeveloperComponentsScreen.kt:68)");
            }
            LocalDate now = LocalDate.now();
            Intrinsics.checkNotNullExpressionValue(now, "now(...)");
            DepartureDayHeaderViewKt.DepartureDayHeaderView(now, composer, 0);
            SpacerKt.Spacer(SizeKt.m325height3ABfNKs(Modifier.INSTANCE, Dp.m2599constructorimpl(16)), composer, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-8, reason: not valid java name */
    private static Function3<LazyItemScope, Composer, Integer, Unit> f193lambda8 = ComposableLambdaKt.composableLambdaInstance(2044478382, false, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.developer.ComposableSingletons$DeveloperComponentsScreenKt$lambda-8$1
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
                ComposerKt.traceEventStart(2044478382, i5, -1, "dk.molslinjen.ui.views.screens.developer.ComposableSingletons$DeveloperComponentsScreenKt.lambda-8.<anonymous> (DeveloperComponentsScreen.kt:72)");
            }
            EmptyDeparturesViewKt.EmptyDeparturesView(R.string.departures_noDepartureOnDay, composer, 6);
            SpacerKt.Spacer(SizeKt.m325height3ABfNKs(Modifier.INSTANCE, Dp.m2599constructorimpl(16)), composer, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: getLambda-1$app_kombardoProd, reason: not valid java name */
    public final Function3<LazyItemScope, Composer, Integer, Unit> m3479getLambda1$app_kombardoProd() {
        return f186lambda1;
    }

    /* renamed from: getLambda-2$app_kombardoProd, reason: not valid java name */
    public final Function3<LazyItemScope, Composer, Integer, Unit> m3480getLambda2$app_kombardoProd() {
        return f187lambda2;
    }

    /* renamed from: getLambda-3$app_kombardoProd, reason: not valid java name */
    public final Function3<LazyItemScope, Composer, Integer, Unit> m3481getLambda3$app_kombardoProd() {
        return f188lambda3;
    }

    /* renamed from: getLambda-4$app_kombardoProd, reason: not valid java name */
    public final Function3<LazyItemScope, Composer, Integer, Unit> m3482getLambda4$app_kombardoProd() {
        return f189lambda4;
    }

    /* renamed from: getLambda-5$app_kombardoProd, reason: not valid java name */
    public final Function3<LazyItemScope, Composer, Integer, Unit> m3483getLambda5$app_kombardoProd() {
        return f190lambda5;
    }

    /* renamed from: getLambda-6$app_kombardoProd, reason: not valid java name */
    public final Function3<LazyItemScope, Composer, Integer, Unit> m3484getLambda6$app_kombardoProd() {
        return f191lambda6;
    }

    /* renamed from: getLambda-7$app_kombardoProd, reason: not valid java name */
    public final Function3<LazyItemScope, Composer, Integer, Unit> m3485getLambda7$app_kombardoProd() {
        return f192lambda7;
    }

    /* renamed from: getLambda-8$app_kombardoProd, reason: not valid java name */
    public final Function3<LazyItemScope, Composer, Integer, Unit> m3486getLambda8$app_kombardoProd() {
        return f193lambda8;
    }
}
