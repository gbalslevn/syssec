package androidx.compose.material.navigation;

import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.navigation.NavBackStackEntry;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ComposableSingletons$BottomSheetNavigatorKt {
    public static final ComposableSingletons$BottomSheetNavigatorKt INSTANCE = new ComposableSingletons$BottomSheetNavigatorKt();

    /* renamed from: lambda-1, reason: not valid java name */
    public static Function4<ColumnScope, NavBackStackEntry, Composer, Integer, Unit> f16lambda1 = ComposableLambdaKt.composableLambdaInstance(-1104060618, false, new Function4<ColumnScope, NavBackStackEntry, Composer, Integer, Unit>() { // from class: androidx.compose.material.navigation.ComposableSingletons$BottomSheetNavigatorKt$lambda-1$1
        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, NavBackStackEntry navBackStackEntry, Composer composer, Integer num) {
            invoke(columnScope, navBackStackEntry, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(ColumnScope columnScope, NavBackStackEntry navBackStackEntry, Composer composer, int i5) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1104060618, i5, -1, "androidx.compose.material.navigation.ComposableSingletons$BottomSheetNavigatorKt.lambda-1.<anonymous> (BottomSheetNavigator.kt:216)");
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: getLambda-1$material_navigation_release, reason: not valid java name */
    public final Function4<ColumnScope, NavBackStackEntry, Composer, Integer, Unit> m749getLambda1$material_navigation_release() {
        return f16lambda1;
    }
}
