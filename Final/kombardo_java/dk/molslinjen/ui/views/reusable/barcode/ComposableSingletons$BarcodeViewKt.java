package dk.molslinjen.ui.views.reusable.barcode;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ComposableSingletons$BarcodeViewKt {
    public static final ComposableSingletons$BarcodeViewKt INSTANCE = new ComposableSingletons$BarcodeViewKt();

    /* renamed from: lambda-1, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f151lambda1 = ComposableLambdaKt.composableLambdaInstance(2072559827, false, new Function2<Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.reusable.barcode.ComposableSingletons$BarcodeViewKt$lambda-1$1
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
                ComposerKt.traceEventStart(2072559827, i5, -1, "dk.molslinjen.ui.views.reusable.barcode.ComposableSingletons$BarcodeViewKt.lambda-1.<anonymous> (BarcodeView.kt:89)");
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: getLambda-1$app_kombardoProd, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m3396getLambda1$app_kombardoProd() {
        return f151lambda1;
    }
}
