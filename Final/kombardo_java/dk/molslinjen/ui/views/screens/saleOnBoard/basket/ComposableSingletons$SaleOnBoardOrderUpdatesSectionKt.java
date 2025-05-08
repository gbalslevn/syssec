package dk.molslinjen.ui.views.screens.saleOnBoard.basket;

import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import dk.molslinjen.ui.views.reusable.HorizontalDividerKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ComposableSingletons$SaleOnBoardOrderUpdatesSectionKt {
    public static final ComposableSingletons$SaleOnBoardOrderUpdatesSectionKt INSTANCE = new ComposableSingletons$SaleOnBoardOrderUpdatesSectionKt();

    /* renamed from: lambda-1, reason: not valid java name */
    private static Function3<LazyItemScope, Composer, Integer, Unit> f227lambda1 = ComposableLambdaKt.composableLambdaInstance(1321898588, false, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.saleOnBoard.basket.ComposableSingletons$SaleOnBoardOrderUpdatesSectionKt$lambda-1$1
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
                ComposerKt.traceEventStart(1321898588, i5, -1, "dk.molslinjen.ui.views.screens.saleOnBoard.basket.ComposableSingletons$SaleOnBoardOrderUpdatesSectionKt.lambda-1.<anonymous> (SaleOnBoardOrderUpdatesSection.kt:90)");
            }
            HorizontalDividerKt.m3388HorizontalDividertZIQpXc(null, 0L, 0.0f, null, composer, 0, 15);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-2, reason: not valid java name */
    private static Function4<Boolean, Function1<? super Boolean, Unit>, Composer, Integer, Unit> f228lambda2 = ComposableLambdaKt.composableLambdaInstance(-466613215, false, ComposableSingletons$SaleOnBoardOrderUpdatesSectionKt$lambda2$1.INSTANCE);

    /* renamed from: getLambda-1$app_kombardoProd, reason: not valid java name */
    public final Function3<LazyItemScope, Composer, Integer, Unit> m3528getLambda1$app_kombardoProd() {
        return f227lambda1;
    }

    /* renamed from: getLambda-2$app_kombardoProd, reason: not valid java name */
    public final Function4<Boolean, Function1<? super Boolean, Unit>, Composer, Integer, Unit> m3529getLambda2$app_kombardoProd() {
        return f228lambda2;
    }
}
