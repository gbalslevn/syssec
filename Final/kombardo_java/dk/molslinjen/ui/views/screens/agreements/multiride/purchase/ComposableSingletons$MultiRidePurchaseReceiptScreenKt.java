package dk.molslinjen.ui.views.screens.agreements.multiride.purchase;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ComposableSingletons$MultiRidePurchaseReceiptScreenKt {
    public static final ComposableSingletons$MultiRidePurchaseReceiptScreenKt INSTANCE = new ComposableSingletons$MultiRidePurchaseReceiptScreenKt();

    /* renamed from: lambda-1, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f165lambda1 = ComposableLambdaKt.composableLambdaInstance(183379121, false, new Function2<Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.agreements.multiride.purchase.ComposableSingletons$MultiRidePurchaseReceiptScreenKt$lambda-1$1
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
                ComposerKt.traceEventStart(183379121, i5, -1, "dk.molslinjen.ui.views.screens.agreements.multiride.purchase.ComposableSingletons$MultiRidePurchaseReceiptScreenKt.lambda-1.<anonymous> (MultiRidePurchaseReceiptScreen.kt:57)");
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: getLambda-1$app_kombardoProd, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m3437getLambda1$app_kombardoProd() {
        return f165lambda1;
    }
}
