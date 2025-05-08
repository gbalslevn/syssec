package dk.molslinjen.ui.views.screens.booking.addons;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.Dp;
import dk.molslinjen.domain.model.booking.product.Product;
import dk.molslinjen.domain.model.booking.product.ProductTag;
import dk.molslinjen.extensions.ColorExtensionsKt;
import dk.molslinjen.ui.theme.TypographyKt;
import dk.molslinjen.ui.views.screens.booking.addons.ProductTagViewKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a#\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0001\u001a\u00020\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Landroidx/compose/ui/Modifier;", "modifier", "Ldk/molslinjen/domain/model/booking/product/Product;", "product", BuildConfig.FLAVOR, "ProductTagView", "(Landroidx/compose/ui/Modifier;Ldk/molslinjen/domain/model/booking/product/Product;Landroidx/compose/runtime/Composer;II)V", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class ProductTagViewKt {
    public static final void ProductTagView(Modifier modifier, final Product product, Composer composer, final int i5, final int i6) {
        Modifier modifier2;
        int i7;
        final Modifier modifier3;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(-1533072993);
        int i8 = i6 & 1;
        if (i8 != 0) {
            i7 = i5 | 6;
            modifier2 = modifier;
        } else if ((i5 & 6) == 0) {
            modifier2 = modifier;
            i7 = (startRestartGroup.changed(modifier2) ? 4 : 2) | i5;
        } else {
            modifier2 = modifier;
            i7 = i5;
        }
        if ((i6 & 2) != 0) {
            i7 |= 48;
        } else if ((i5 & 48) == 0) {
            i7 |= startRestartGroup.changedInstance(product) ? 32 : 16;
        }
        if ((i7 & 19) == 18 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
            composer2 = startRestartGroup;
        } else {
            Modifier modifier4 = i8 != 0 ? Modifier.INSTANCE : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1533072993, i7, -1, "dk.molslinjen.ui.views.screens.booking.addons.ProductTagView (ProductTagView.kt:16)");
            }
            ProductTag tag = product != null ? product.getTag() : null;
            if (tag == null) {
                modifier3 = modifier4;
                composer2 = startRestartGroup;
            } else {
                Modifier m311padding3ABfNKs = PaddingKt.m311padding3ABfNKs(BackgroundKt.m103backgroundbw27NRU(modifier4, ColorExtensionsKt.safeToColor(tag.getBackgroundColour().getHex()), RoundedCornerShapeKt.m460RoundedCornerShape0680j_4(Dp.m2599constructorimpl(100))), Dp.m2599constructorimpl(8));
                TextStyle subSmallBold = TypographyKt.getSubSmallBold();
                String name = tag.getName();
                modifier3 = modifier4;
                composer2 = startRestartGroup;
                TextKt.m940Text4IGK_g(name, m311padding3ABfNKs, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, subSmallBold, composer2, 0, 1572864, 65532);
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: D2.S
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit ProductTagView$lambda$1;
                    ProductTagView$lambda$1 = ProductTagViewKt.ProductTagView$lambda$1(Modifier.this, product, i5, i6, (Composer) obj, ((Integer) obj2).intValue());
                    return ProductTagView$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ProductTagView$lambda$1(Modifier modifier, Product product, int i5, int i6, Composer composer, int i7) {
        ProductTagView(modifier, product, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1), i6);
        return Unit.INSTANCE;
    }
}
