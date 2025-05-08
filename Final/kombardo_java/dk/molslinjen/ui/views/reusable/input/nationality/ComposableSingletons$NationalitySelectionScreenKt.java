package dk.molslinjen.ui.views.reusable.input.nationality;

import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import dk.molslinjen.kombardo.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ComposableSingletons$NationalitySelectionScreenKt {
    public static final ComposableSingletons$NationalitySelectionScreenKt INSTANCE = new ComposableSingletons$NationalitySelectionScreenKt();

    /* renamed from: lambda-1, reason: not valid java name */
    private static Function3<LazyItemScope, Composer, Integer, Unit> f154lambda1 = ComposableLambdaKt.composableLambdaInstance(1452200072, false, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.reusable.input.nationality.ComposableSingletons$NationalitySelectionScreenKt$lambda-1$1
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
                ComposerKt.traceEventStart(1452200072, i5, -1, "dk.molslinjen.ui.views.reusable.input.nationality.ComposableSingletons$NationalitySelectionScreenKt.lambda-1.<anonymous> (NationalitySelectionScreen.kt:64)");
            }
            NationalitySelectionScreenKt.access$NationalityHeader(R.string.nationalitySelection_frequentlyUsed, composer, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-2, reason: not valid java name */
    private static Function3<LazyItemScope, Composer, Integer, Unit> f155lambda2 = ComposableLambdaKt.composableLambdaInstance(-92662081, false, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.reusable.input.nationality.ComposableSingletons$NationalitySelectionScreenKt$lambda-2$1
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
                ComposerKt.traceEventStart(-92662081, i5, -1, "dk.molslinjen.ui.views.reusable.input.nationality.ComposableSingletons$NationalitySelectionScreenKt.lambda-2.<anonymous> (NationalitySelectionScreen.kt:75)");
            }
            NationalitySelectionScreenKt.access$NationalityHeader(R.string.nationalitySelection_all, composer, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: getLambda-1$app_kombardoProd, reason: not valid java name */
    public final Function3<LazyItemScope, Composer, Integer, Unit> m3419getLambda1$app_kombardoProd() {
        return f154lambda1;
    }

    /* renamed from: getLambda-2$app_kombardoProd, reason: not valid java name */
    public final Function3<LazyItemScope, Composer, Integer, Unit> m3420getLambda2$app_kombardoProd() {
        return f155lambda2;
    }
}
