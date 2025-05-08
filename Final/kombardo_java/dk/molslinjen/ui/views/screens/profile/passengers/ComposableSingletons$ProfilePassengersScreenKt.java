package dk.molslinjen.ui.views.screens.profile.passengers;

import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import dk.molslinjen.ui.views.reusable.HorizontalDividerKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ComposableSingletons$ProfilePassengersScreenKt {
    public static final ComposableSingletons$ProfilePassengersScreenKt INSTANCE = new ComposableSingletons$ProfilePassengersScreenKt();

    /* renamed from: lambda-1, reason: not valid java name */
    private static Function3<LazyItemScope, Composer, Integer, Unit> f216lambda1 = ComposableLambdaKt.composableLambdaInstance(-258820485, false, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.profile.passengers.ComposableSingletons$ProfilePassengersScreenKt$lambda-1$1
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
                ComposerKt.traceEventStart(-258820485, i5, -1, "dk.molslinjen.ui.views.screens.profile.passengers.ComposableSingletons$ProfilePassengersScreenKt.lambda-1.<anonymous> (ProfilePassengersScreen.kt:72)");
            }
            HorizontalDividerKt.m3388HorizontalDividertZIQpXc(null, 0L, 0.0f, null, composer, 0, 15);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: getLambda-1$app_kombardoProd, reason: not valid java name */
    public final Function3<LazyItemScope, Composer, Integer, Unit> m3514getLambda1$app_kombardoProd() {
        return f216lambda1;
    }
}
