package dk.molslinjen.ui.views.screens.developer;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.Dp;
import dk.molslinjen.domain.model.booking.Departure;
import dk.molslinjen.ui.views.screens.booking.departures.rows.departure.DepartureRowViewKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* renamed from: dk.molslinjen.ui.views.screens.developer.ComposableSingletons$DeveloperComponentsScreenKt$lambda-1$1, reason: invalid class name */
/* loaded from: classes2.dex */
final class ComposableSingletons$DeveloperComponentsScreenKt$lambda1$1 implements Function3<LazyItemScope, Composer, Integer, Unit> {
    public static final ComposableSingletons$DeveloperComponentsScreenKt$lambda1$1 INSTANCE = new ComposableSingletons$DeveloperComponentsScreenKt$lambda1$1();

    ComposableSingletons$DeveloperComponentsScreenKt$lambda1$1() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$1$lambda$0(Departure it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

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
            ComposerKt.traceEventStart(-1356763189, i5, -1, "dk.molslinjen.ui.views.screens.developer.ComposableSingletons$DeveloperComponentsScreenKt.lambda-1.<anonymous> (DeveloperComponentsScreen.kt:28)");
        }
        Modifier.Companion companion = Modifier.INSTANCE;
        float f5 = 16;
        Modifier m313paddingVpY3zN4$default = PaddingKt.m313paddingVpY3zN4$default(companion, Dp.m2599constructorimpl(f5), 0.0f, 2, null);
        Departure mock = Departure.INSTANCE.getMock();
        composer.startReplaceGroup(-144146261);
        Object rememberedValue = composer.rememberedValue();
        if (rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = new Function1() { // from class: dk.molslinjen.ui.views.screens.developer.a
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit invoke$lambda$1$lambda$0;
                    invoke$lambda$1$lambda$0 = ComposableSingletons$DeveloperComponentsScreenKt$lambda1$1.invoke$lambda$1$lambda$0((Departure) obj);
                    return invoke$lambda$1$lambda$0;
                }
            };
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceGroup();
        DepartureRowViewKt.DepartureRowView(m313paddingVpY3zN4$default, mock, false, false, (Function1) rememberedValue, false, composer, 24582, 44);
        SpacerKt.Spacer(SizeKt.m325height3ABfNKs(companion, Dp.m2599constructorimpl(f5)), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
