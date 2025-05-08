package dk.molslinjen.ui.views.screens.booking.departures.selectTrailers;

import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.material3.DividerKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.unit.Dp;
import dk.molslinjen.ui.theme.AppColor;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ComposableSingletons$TrailerSelectorScreenKt {
    public static final ComposableSingletons$TrailerSelectorScreenKt INSTANCE = new ComposableSingletons$TrailerSelectorScreenKt();

    /* renamed from: lambda-1, reason: not valid java name */
    private static Function3<LazyItemScope, Composer, Integer, Unit> f171lambda1 = ComposableLambdaKt.composableLambdaInstance(1442714392, false, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.booking.departures.selectTrailers.ComposableSingletons$TrailerSelectorScreenKt$lambda-1$1
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
                ComposerKt.traceEventStart(1442714392, i5, -1, "dk.molslinjen.ui.views.screens.booking.departures.selectTrailers.ComposableSingletons$TrailerSelectorScreenKt.lambda-1.<anonymous> (TrailerSelectorScreen.kt:119)");
            }
            DividerKt.m843Divider9IZ8Weo(null, Dp.m2599constructorimpl(1), AppColor.INSTANCE.m3268getGrey50d7_KjU(), composer, 432, 1);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: getLambda-1$app_kombardoProd, reason: not valid java name */
    public final Function3<LazyItemScope, Composer, Integer, Unit> m3460getLambda1$app_kombardoProd() {
        return f171lambda1;
    }
}
