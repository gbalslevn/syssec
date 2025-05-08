package dk.molslinjen.ui.views.reusable.input.checkbox;

import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.material3.IconKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.res.PainterResources_androidKt;
import dk.molslinjen.core.extensions.Accessibility;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.theme.AppColor;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ComposableSingletons$SelectionControlKt {
    public static final ComposableSingletons$SelectionControlKt INSTANCE = new ComposableSingletons$SelectionControlKt();

    /* renamed from: lambda-1, reason: not valid java name */
    private static Function3<AnimatedVisibilityScope, Composer, Integer, Unit> f153lambda1 = ComposableLambdaKt.composableLambdaInstance(1776579862, false, new Function3<AnimatedVisibilityScope, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.reusable.input.checkbox.ComposableSingletons$SelectionControlKt$lambda-1$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(AnimatedVisibilityScope animatedVisibilityScope, Composer composer, Integer num) {
            invoke(animatedVisibilityScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(AnimatedVisibilityScope AnimatedVisibility, Composer composer, int i5) {
            Intrinsics.checkNotNullParameter(AnimatedVisibility, "$this$AnimatedVisibility");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1776579862, i5, -1, "dk.molslinjen.ui.views.reusable.input.checkbox.ComposableSingletons$SelectionControlKt.lambda-1.<anonymous> (SelectionControl.kt:86)");
            }
            IconKt.m857Iconww6aTOc(PainterResources_androidKt.painterResource(R.drawable.icon_checkmark, composer, 6), Accessibility.INSTANCE.getSkip(), (Modifier) null, AppColor.INSTANCE.m3281getWhite0d7_KjU(), composer, 3072, 4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: getLambda-1$app_kombardoProd, reason: not valid java name */
    public final Function3<AnimatedVisibilityScope, Composer, Integer, Unit> m3415getLambda1$app_kombardoProd() {
        return f153lambda1;
    }
}
