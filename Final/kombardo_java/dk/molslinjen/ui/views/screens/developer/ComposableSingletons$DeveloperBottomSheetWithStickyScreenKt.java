package dk.molslinjen.ui.views.screens.developer;

import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ComposableSingletons$DeveloperBottomSheetWithStickyScreenKt {
    public static final ComposableSingletons$DeveloperBottomSheetWithStickyScreenKt INSTANCE = new ComposableSingletons$DeveloperBottomSheetWithStickyScreenKt();

    /* renamed from: lambda-1, reason: not valid java name */
    private static Function3<ColumnScope, Composer, Integer, Unit> f185lambda1 = ComposableLambdaKt.composableLambdaInstance(1148520548, false, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.developer.ComposableSingletons$DeveloperBottomSheetWithStickyScreenKt$lambda-1$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, Composer composer, Integer num) {
            invoke(columnScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(ColumnScope BottomSheetContainer, Composer composer, int i5) {
            Intrinsics.checkNotNullParameter(BottomSheetContainer, "$this$BottomSheetContainer");
            if ((i5 & 17) == 16 && composer.getSkipping()) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1148520548, i5, -1, "dk.molslinjen.ui.views.screens.developer.ComposableSingletons$DeveloperBottomSheetWithStickyScreenKt.lambda-1.<anonymous> (DeveloperBottomSheetWithStickyScreen.kt:39)");
            }
            DeveloperBottomSheetWithStickyScreenKt.access$SheetContent(composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: getLambda-1$app_kombardoProd, reason: not valid java name */
    public final Function3<ColumnScope, Composer, Integer, Unit> m3478getLambda1$app_kombardoProd() {
        return f185lambda1;
    }
}
