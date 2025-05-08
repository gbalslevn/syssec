package dk.molslinjen.ui.views.screens.agreements.common;

import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import dk.molslinjen.ui.views.screens.tickets.history.TicketHistoryEmptyViewKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ComposableSingletons$AgreementTicketHistoryContentKt {
    public static final ComposableSingletons$AgreementTicketHistoryContentKt INSTANCE = new ComposableSingletons$AgreementTicketHistoryContentKt();

    /* renamed from: lambda-1, reason: not valid java name */
    private static Function3<LazyItemScope, Composer, Integer, Unit> f158lambda1 = ComposableLambdaKt.composableLambdaInstance(-1712284342, false, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.agreements.common.ComposableSingletons$AgreementTicketHistoryContentKt$lambda-1$1
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
                ComposerKt.traceEventStart(-1712284342, i5, -1, "dk.molslinjen.ui.views.screens.agreements.common.ComposableSingletons$AgreementTicketHistoryContentKt.lambda-1.<anonymous> (AgreementTicketHistoryContent.kt:51)");
            }
            TicketHistoryEmptyViewKt.TicketHistoryEmptyView(composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: getLambda-1$app_kombardoProd, reason: not valid java name */
    public final Function3<LazyItemScope, Composer, Integer, Unit> m3428getLambda1$app_kombardoProd() {
        return f158lambda1;
    }
}
