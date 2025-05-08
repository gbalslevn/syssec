package dk.molslinjen.ui.views.screens.agreements.multiride.purchase;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.Dp;
import dk.molslinjen.ui.views.reusable.HorizontalDividerKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ComposableSingletons$MultiRideCardPurchaseSummaryScreenKt {
    public static final ComposableSingletons$MultiRideCardPurchaseSummaryScreenKt INSTANCE = new ComposableSingletons$MultiRideCardPurchaseSummaryScreenKt();

    /* renamed from: lambda-1, reason: not valid java name */
    private static Function3<LazyItemScope, Composer, Integer, Unit> f164lambda1 = ComposableLambdaKt.composableLambdaInstance(-1073291793, false, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.agreements.multiride.purchase.ComposableSingletons$MultiRideCardPurchaseSummaryScreenKt$lambda-1$1
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
                ComposerKt.traceEventStart(-1073291793, i5, -1, "dk.molslinjen.ui.views.screens.agreements.multiride.purchase.ComposableSingletons$MultiRideCardPurchaseSummaryScreenKt.lambda-1.<anonymous> (MultiRideCardPurchaseSummaryScreen.kt:186)");
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            float f5 = 32;
            SpacerKt.Spacer(SizeKt.m325height3ABfNKs(companion, Dp.m2599constructorimpl(f5)), composer, 6);
            HorizontalDividerKt.m3388HorizontalDividertZIQpXc(PaddingKt.m313paddingVpY3zN4$default(companion, 0.0f, Dp.m2599constructorimpl(8), 1, null), 0L, 0.0f, null, composer, 6, 14);
            SpacerKt.Spacer(SizeKt.m325height3ABfNKs(companion, Dp.m2599constructorimpl(f5)), composer, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: getLambda-1$app_kombardoProd, reason: not valid java name */
    public final Function3<LazyItemScope, Composer, Integer, Unit> m3436getLambda1$app_kombardoProd() {
        return f164lambda1;
    }
}
