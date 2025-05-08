package dk.molslinjen.ui.views.screens.booking.passengers;

import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ComposableSingletons$NameRegistrationSectionKt {
    public static final ComposableSingletons$NameRegistrationSectionKt INSTANCE = new ComposableSingletons$NameRegistrationSectionKt();

    /* renamed from: lambda-1, reason: not valid java name */
    private static Function3<LazyItemScope, Composer, Integer, Unit> f174lambda1 = ComposableLambdaKt.composableLambdaInstance(-826943829, false, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.booking.passengers.ComposableSingletons$NameRegistrationSectionKt$lambda-1$1
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
                ComposerKt.traceEventStart(-826943829, i5, -1, "dk.molslinjen.ui.views.screens.booking.passengers.ComposableSingletons$NameRegistrationSectionKt.lambda-1.<anonymous> (NameRegistrationSection.kt:236)");
            }
            CheckoutPassengerPortraitTemplateKt.CheckoutPassengerPortraitTemplate(null, composer, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-2, reason: not valid java name */
    private static Function3<LazyItemScope, Composer, Integer, Unit> f175lambda2 = ComposableLambdaKt.composableLambdaInstance(-2003127037, false, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.booking.passengers.ComposableSingletons$NameRegistrationSectionKt$lambda-2$1
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
                ComposerKt.traceEventStart(-2003127037, i5, -1, "dk.molslinjen.ui.views.screens.booking.passengers.ComposableSingletons$NameRegistrationSectionKt.lambda-2.<anonymous> (NameRegistrationSection.kt:274)");
            }
            SpacerKt.Spacer(SizeKt.m336width3ABfNKs(Modifier.INSTANCE, Dp.m2599constructorimpl(15)), composer, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: getLambda-1$app_kombardoProd, reason: not valid java name */
    public final Function3<LazyItemScope, Composer, Integer, Unit> m3463getLambda1$app_kombardoProd() {
        return f174lambda1;
    }

    /* renamed from: getLambda-2$app_kombardoProd, reason: not valid java name */
    public final Function3<LazyItemScope, Composer, Integer, Unit> m3464getLambda2$app_kombardoProd() {
        return f175lambda2;
    }
}
