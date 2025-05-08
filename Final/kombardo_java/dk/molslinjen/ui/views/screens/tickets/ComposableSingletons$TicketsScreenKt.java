package dk.molslinjen.ui.views.screens.tickets;

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
public final class ComposableSingletons$TicketsScreenKt {
    public static final ComposableSingletons$TicketsScreenKt INSTANCE = new ComposableSingletons$TicketsScreenKt();

    /* renamed from: lambda-1, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f237lambda1 = ComposableLambdaKt.composableLambdaInstance(-286079781, false, new Function2<Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.tickets.ComposableSingletons$TicketsScreenKt$lambda-1$1
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
                ComposerKt.traceEventStart(-286079781, i5, -1, "dk.molslinjen.ui.views.screens.tickets.ComposableSingletons$TicketsScreenKt.lambda-1.<anonymous> (TicketsScreen.kt:107)");
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-2, reason: not valid java name */
    private static Function3<LazyItemScope, Composer, Integer, Unit> f238lambda2 = ComposableLambdaKt.composableLambdaInstance(2028352911, false, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.tickets.ComposableSingletons$TicketsScreenKt$lambda-2$1
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
                ComposerKt.traceEventStart(2028352911, i5, -1, "dk.molslinjen.ui.views.screens.tickets.ComposableSingletons$TicketsScreenKt.lambda-2.<anonymous> (TicketsScreen.kt:107)");
            }
            LoadingComponentKt.m3392LoadingComponentjfnsLPA(null, 0.0f, true, 0, false, null, ComposableSingletons$TicketsScreenKt.INSTANCE.m3540getLambda1$app_kombardoProd(), composer, 1573248, 59);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: getLambda-1$app_kombardoProd, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m3540getLambda1$app_kombardoProd() {
        return f237lambda1;
    }

    /* renamed from: getLambda-2$app_kombardoProd, reason: not valid java name */
    public final Function3<LazyItemScope, Composer, Integer, Unit> m3541getLambda2$app_kombardoProd() {
        return f238lambda2;
    }
}
