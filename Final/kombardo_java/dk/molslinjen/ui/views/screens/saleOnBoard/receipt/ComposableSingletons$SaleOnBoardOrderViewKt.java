package dk.molslinjen.ui.views.screens.saleOnBoard.receipt;

import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.style.TextAlign;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.theme.TypographyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ComposableSingletons$SaleOnBoardOrderViewKt {
    public static final ComposableSingletons$SaleOnBoardOrderViewKt INSTANCE = new ComposableSingletons$SaleOnBoardOrderViewKt();

    /* renamed from: lambda-1, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f234lambda1 = ComposableLambdaKt.composableLambdaInstance(2117476889, false, new Function2<Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.saleOnBoard.receipt.ComposableSingletons$SaleOnBoardOrderViewKt$lambda-1$1
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
                ComposerKt.traceEventStart(2117476889, i5, -1, "dk.molslinjen.ui.views.screens.saleOnBoard.receipt.ComposableSingletons$SaleOnBoardOrderViewKt.lambda-1.<anonymous> (SaleOnBoardOrderView.kt:136)");
            }
            TextKt.m940Text4IGK_g(StringResources_androidKt.stringResource(R.string.saleOnBoard_order_readyForPickupAt, composer, 6), null, 0L, 0L, null, null, null, 0L, null, TextAlign.m2521boximpl(TextAlign.INSTANCE.m2533getStarte0LSkKk()), 0L, 0, false, 0, 0, null, TypographyKt.getSub(), composer, 0, 1572864, 65022);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: getLambda-1$app_kombardoProd, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m3537getLambda1$app_kombardoProd() {
        return f234lambda1;
    }
}
