package dk.molslinjen.ui.views.screens.deeplink;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ComposableSingletons$DeepLinkScreenKt {
    public static final ComposableSingletons$DeepLinkScreenKt INSTANCE = new ComposableSingletons$DeepLinkScreenKt();

    /* renamed from: lambda-1, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f184lambda1 = ComposableLambdaKt.composableLambdaInstance(-1341774237, false, new Function2<Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.deeplink.ComposableSingletons$DeepLinkScreenKt$lambda-1$1
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
                ComposerKt.traceEventStart(-1341774237, i5, -1, "dk.molslinjen.ui.views.screens.deeplink.ComposableSingletons$DeepLinkScreenKt.lambda-1.<anonymous> (DeepLinkScreen.kt:61)");
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: getLambda-1$app_kombardoProd, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m3477getLambda1$app_kombardoProd() {
        return f184lambda1;
    }
}
