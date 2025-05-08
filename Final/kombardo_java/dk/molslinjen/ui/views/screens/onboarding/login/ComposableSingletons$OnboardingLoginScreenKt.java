package dk.molslinjen.ui.views.screens.onboarding.login;

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
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ComposableSingletons$OnboardingLoginScreenKt {
    public static final ComposableSingletons$OnboardingLoginScreenKt INSTANCE = new ComposableSingletons$OnboardingLoginScreenKt();

    /* renamed from: lambda-1, reason: not valid java name */
    private static Function3<AnimatedVisibilityScope, Composer, Integer, Unit> f209lambda1 = ComposableLambdaKt.composableLambdaInstance(358352735, false, new Function3<AnimatedVisibilityScope, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.onboarding.login.ComposableSingletons$OnboardingLoginScreenKt$lambda-1$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(AnimatedVisibilityScope animatedVisibilityScope, Composer composer, Integer num) {
            invoke(animatedVisibilityScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(AnimatedVisibilityScope AnimatedVisibility, Composer composer, int i5) {
            Intrinsics.checkNotNullParameter(AnimatedVisibility, "$this$AnimatedVisibility");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(358352735, i5, -1, "dk.molslinjen.ui.views.screens.onboarding.login.ComposableSingletons$OnboardingLoginScreenKt.lambda-1.<anonymous> (OnboardingLoginScreen.kt:244)");
            }
            BoxKt.Box(BackgroundKt.background$default(SizeKt.m325height3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m2599constructorimpl(112)), Brush.Companion.m1465verticalGradient8A3gB4$default(Brush.INSTANCE, CollectionsKt.listOf((Object[]) new Color[]{Color.m1481boximpl(ColorKt.Color(16054781)), Color.m1481boximpl(ColorKt.Color(4294244861L))}), 0.0f, 0.0f, 0, 14, (Object) null), null, 0.0f, 6, null), composer, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: getLambda-1$app_kombardoProd, reason: not valid java name */
    public final Function3<AnimatedVisibilityScope, Composer, Integer, Unit> m3502getLambda1$app_kombardoProd() {
        return f209lambda1;
    }
}
