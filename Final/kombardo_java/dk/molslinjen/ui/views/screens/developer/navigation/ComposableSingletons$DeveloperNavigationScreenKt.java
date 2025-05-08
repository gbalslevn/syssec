package dk.molslinjen.ui.views.screens.developer.navigation;

import androidx.compose.foundation.layout.RowScope;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ComposableSingletons$DeveloperNavigationScreenKt {
    public static final ComposableSingletons$DeveloperNavigationScreenKt INSTANCE = new ComposableSingletons$DeveloperNavigationScreenKt();

    /* renamed from: lambda-1, reason: not valid java name */
    private static Function3<RowScope, Composer, Integer, Unit> f206lambda1 = ComposableLambdaKt.composableLambdaInstance(1232252131, false, new Function3<RowScope, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.developer.navigation.ComposableSingletons$DeveloperNavigationScreenKt$lambda-1$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer, Integer num) {
            invoke(rowScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(RowScope Button, Composer composer, int i5) {
            Intrinsics.checkNotNullParameter(Button, "$this$Button");
            if ((i5 & 17) == 16 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1232252131, i5, -1, "dk.molslinjen.ui.views.screens.developer.navigation.ComposableSingletons$DeveloperNavigationScreenKt.lambda-1.<anonymous> (DeveloperNavigationScreen.kt:27)");
            }
            TextKt.m940Text4IGK_g("Show with only top bar", null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer, 6, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-2, reason: not valid java name */
    private static Function3<RowScope, Composer, Integer, Unit> f207lambda2 = ComposableLambdaKt.composableLambdaInstance(-39398246, false, new Function3<RowScope, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.developer.navigation.ComposableSingletons$DeveloperNavigationScreenKt$lambda-2$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer, Integer num) {
            invoke(rowScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(RowScope Button, Composer composer, int i5) {
            Intrinsics.checkNotNullParameter(Button, "$this$Button");
            if ((i5 & 17) == 16 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-39398246, i5, -1, "dk.molslinjen.ui.views.screens.developer.navigation.ComposableSingletons$DeveloperNavigationScreenKt.lambda-2.<anonymous> (DeveloperNavigationScreen.kt:30)");
            }
            TextKt.m940Text4IGK_g("Show with only bottom bar", null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer, 6, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-3, reason: not valid java name */
    private static Function3<RowScope, Composer, Integer, Unit> f208lambda3 = ComposableLambdaKt.composableLambdaInstance(-447421861, false, new Function3<RowScope, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.developer.navigation.ComposableSingletons$DeveloperNavigationScreenKt$lambda-3$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer, Integer num) {
            invoke(rowScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(RowScope Button, Composer composer, int i5) {
            Intrinsics.checkNotNullParameter(Button, "$this$Button");
            if ((i5 & 17) == 16 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-447421861, i5, -1, "dk.molslinjen.ui.views.screens.developer.navigation.ComposableSingletons$DeveloperNavigationScreenKt.lambda-3.<anonymous> (DeveloperNavigationScreen.kt:33)");
            }
            TextKt.m940Text4IGK_g("Show with both", null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer, 6, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: getLambda-1$app_kombardoProd, reason: not valid java name */
    public final Function3<RowScope, Composer, Integer, Unit> m3499getLambda1$app_kombardoProd() {
        return f206lambda1;
    }

    /* renamed from: getLambda-2$app_kombardoProd, reason: not valid java name */
    public final Function3<RowScope, Composer, Integer, Unit> m3500getLambda2$app_kombardoProd() {
        return f207lambda2;
    }

    /* renamed from: getLambda-3$app_kombardoProd, reason: not valid java name */
    public final Function3<RowScope, Composer, Integer, Unit> m3501getLambda3$app_kombardoProd() {
        return f208lambda3;
    }
}
