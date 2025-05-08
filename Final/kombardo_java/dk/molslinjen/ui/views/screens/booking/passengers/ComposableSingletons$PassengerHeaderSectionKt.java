package dk.molslinjen.ui.views.screens.booking.passengers;

import androidx.compose.material3.IconKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import dk.molslinjen.kombardo.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ComposableSingletons$PassengerHeaderSectionKt {
    public static final ComposableSingletons$PassengerHeaderSectionKt INSTANCE = new ComposableSingletons$PassengerHeaderSectionKt();

    /* renamed from: lambda-1, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f176lambda1 = ComposableLambdaKt.composableLambdaInstance(1325657676, false, new Function2<Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.booking.passengers.ComposableSingletons$PassengerHeaderSectionKt$lambda-1$1
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
                ComposerKt.traceEventStart(1325657676, i5, -1, "dk.molslinjen.ui.views.screens.booking.passengers.ComposableSingletons$PassengerHeaderSectionKt.lambda-1.<anonymous> (PassengerHeaderSection.kt:72)");
            }
            IconKt.m857Iconww6aTOc(PainterResources_androidKt.painterResource(R.drawable.icon_help, composer, 6), StringResources_androidKt.stringResource(R.string.passengers_help_title, composer, 6), (Modifier) null, Color.INSTANCE.m1501getUnspecified0d7_KjU(), composer, 3072, 4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: getLambda-1$app_kombardoProd, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m3465getLambda1$app_kombardoProd() {
        return f176lambda1;
    }
}
