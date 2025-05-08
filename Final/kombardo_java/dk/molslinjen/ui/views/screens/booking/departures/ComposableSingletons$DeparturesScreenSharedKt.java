package dk.molslinjen.ui.views.screens.booking.departures;

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
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ComposableSingletons$DeparturesScreenSharedKt {
    public static final ComposableSingletons$DeparturesScreenSharedKt INSTANCE = new ComposableSingletons$DeparturesScreenSharedKt();

    /* renamed from: lambda-1, reason: not valid java name */
    private static Function4<LazyItemScope, Integer, Composer, Integer, Unit> f168lambda1 = ComposableLambdaKt.composableLambdaInstance(-19330823, false, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.booking.departures.ComposableSingletons$DeparturesScreenSharedKt$lambda-1$1
        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Integer num, Composer composer, Integer num2) {
            invoke(lazyItemScope, num.intValue(), composer, num2.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(LazyItemScope itemIndexed, int i5, Composer composer, int i6) {
            Intrinsics.checkNotNullParameter(itemIndexed, "$this$itemIndexed");
            if ((i6 & 129) == 128 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-19330823, i6, -1, "dk.molslinjen.ui.views.screens.booking.departures.ComposableSingletons$DeparturesScreenSharedKt.lambda-1.<anonymous> (DeparturesScreenShared.kt:431)");
            }
            SpacerKt.Spacer(SizeKt.m325height3ABfNKs(Modifier.INSTANCE, Dp.m2599constructorimpl(16)), composer, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-2, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f169lambda2 = ComposableLambdaKt.composableLambdaInstance(1627453924, false, new Function2<Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.booking.departures.ComposableSingletons$DeparturesScreenSharedKt$lambda-2$1
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
                ComposerKt.traceEventStart(1627453924, i5, -1, "dk.molslinjen.ui.views.screens.booking.departures.ComposableSingletons$DeparturesScreenSharedKt.lambda-2.<anonymous> (DeparturesScreenShared.kt:455)");
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: getLambda-1$app_kombardoProd, reason: not valid java name */
    public final Function4<LazyItemScope, Integer, Composer, Integer, Unit> m3457getLambda1$app_kombardoProd() {
        return f168lambda1;
    }

    /* renamed from: getLambda-2$app_kombardoProd, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m3458getLambda2$app_kombardoProd() {
        return f169lambda2;
    }
}
