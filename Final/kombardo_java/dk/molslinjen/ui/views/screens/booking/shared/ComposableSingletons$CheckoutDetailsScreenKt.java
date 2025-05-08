package dk.molslinjen.ui.views.screens.booking.shared;

import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ComposableSingletons$CheckoutDetailsScreenKt {
    public static final ComposableSingletons$CheckoutDetailsScreenKt INSTANCE = new ComposableSingletons$CheckoutDetailsScreenKt();

    /* renamed from: lambda-1, reason: not valid java name */
    private static Function3<AnimatedVisibilityScope, Composer, Integer, Unit> f177lambda1 = ComposableLambdaKt.composableLambdaInstance(-1348199043, false, new Function3<AnimatedVisibilityScope, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.booking.shared.ComposableSingletons$CheckoutDetailsScreenKt$lambda-1$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(AnimatedVisibilityScope animatedVisibilityScope, Composer composer, Integer num) {
            invoke(animatedVisibilityScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(AnimatedVisibilityScope AnimatedVisibility, Composer composer, int i5) {
            Intrinsics.checkNotNullParameter(AnimatedVisibility, "$this$AnimatedVisibility");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1348199043, i5, -1, "dk.molslinjen.ui.views.screens.booking.shared.ComposableSingletons$CheckoutDetailsScreenKt.lambda-1.<anonymous> (CheckoutDetailsScreen.kt:221)");
            }
            BoxKt.Box(BackgroundKt.background$default(SizeKt.fillMaxWidth$default(SizeKt.m325height3ABfNKs(Modifier.INSTANCE, Dp.m2599constructorimpl(112)), 0.0f, 1, null), Brush.Companion.m1466verticalGradient8A3gB4$default(Brush.INSTANCE, new Pair[]{TuplesKt.to(Float.valueOf(0.0f), Color.m1481boximpl(ColorKt.Color(16054781))), TuplesKt.to(Float.valueOf(1.0f), Color.m1481boximpl(ColorKt.Color(4294244861L)))}, 0.0f, 0.0f, 0, 14, (Object) null), null, 0.0f, 6, null), composer, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: getLambda-1$app_kombardoProd, reason: not valid java name */
    public final Function3<AnimatedVisibilityScope, Composer, Integer, Unit> m3466getLambda1$app_kombardoProd() {
        return f177lambda1;
    }
}
