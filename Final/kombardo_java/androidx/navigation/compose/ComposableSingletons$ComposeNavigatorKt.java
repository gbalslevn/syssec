package androidx.navigation.compose;

import androidx.compose.animation.AnimatedContentScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.navigation.NavBackStackEntry;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ComposableSingletons$ComposeNavigatorKt {
    public static final ComposableSingletons$ComposeNavigatorKt INSTANCE = new ComposableSingletons$ComposeNavigatorKt();

    /* renamed from: lambda-1, reason: not valid java name */
    public static Function4<AnimatedContentScope, NavBackStackEntry, Composer, Integer, Unit> f48lambda1 = ComposableLambdaKt.composableLambdaInstance(127448943, false, new Function4<AnimatedContentScope, NavBackStackEntry, Composer, Integer, Unit>() { // from class: androidx.navigation.compose.ComposableSingletons$ComposeNavigatorKt$lambda-1$1
        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(AnimatedContentScope animatedContentScope, NavBackStackEntry navBackStackEntry, Composer composer, Integer num) {
            invoke(animatedContentScope, navBackStackEntry, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(AnimatedContentScope animatedContentScope, NavBackStackEntry navBackStackEntry, Composer composer, int i5) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(127448943, i5, -1, "androidx.navigation.compose.ComposableSingletons$ComposeNavigatorKt.lambda-1.<anonymous> (ComposeNavigator.kt:59)");
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: getLambda-1$navigation_compose_release, reason: not valid java name */
    public final Function4<AnimatedContentScope, NavBackStackEntry, Composer, Integer, Unit> m2724getLambda1$navigation_compose_release() {
        return f48lambda1;
    }
}
