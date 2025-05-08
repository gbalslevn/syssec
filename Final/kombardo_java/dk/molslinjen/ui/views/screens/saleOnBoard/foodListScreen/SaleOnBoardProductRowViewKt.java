package dk.molslinjen.ui.views.screens.saleOnBoard.foodListScreen;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.material3.RippleKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import dk.molslinjen.domain.model.saleOnBoard.SaleOnBoardProduct;
import dk.molslinjen.ui.views.screens.saleOnBoard.foodListScreen.SaleOnBoardProductRowViewKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u001a;\u0010\b\u001a\u00020\u00032\u0006\u0010\u0001\u001a\u00020\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0007¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardProduct;", "product", "Lkotlin/Function0;", BuildConfig.FLAVOR, "showProductDetails", BuildConfig.FLAVOR, "isInBasket", "seenProduct", "SaleOnBoardProductRowView", "(Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardProduct;Lkotlin/jvm/functions/Function0;ZLkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class SaleOnBoardProductRowViewKt {
    public static final void SaleOnBoardProductRowView(final SaleOnBoardProduct product, final Function0<Unit> showProductDetails, final boolean z5, final Function0<Unit> seenProduct, Composer composer, final int i5) {
        int i6;
        Intrinsics.checkNotNullParameter(product, "product");
        Intrinsics.checkNotNullParameter(showProductDetails, "showProductDetails");
        Intrinsics.checkNotNullParameter(seenProduct, "seenProduct");
        Composer startRestartGroup = composer.startRestartGroup(-1954424488);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(product) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changedInstance(showProductDetails) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i6 |= startRestartGroup.changed(z5) ? 256 : 128;
        }
        if ((i5 & 3072) == 0) {
            i6 |= startRestartGroup.changedInstance(seenProduct) ? 2048 : 1024;
        }
        if ((i6 & 1171) == 1170 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1954424488, i6, -1, "dk.molslinjen.ui.views.screens.saleOnBoard.foodListScreen.SaleOnBoardProductRowView (SaleOnBoardProductRowView.kt:61)");
            }
            startRestartGroup.startReplaceGroup(-1410965160);
            Object rememberedValue = startRestartGroup.rememberedValue();
            Composer.Companion companion = Composer.INSTANCE;
            if (rememberedValue == companion.getEmpty()) {
                rememberedValue = AnimatableKt.Animatable$default(1.0f, 0.0f, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            Animatable animatable = (Animatable) rememberedValue;
            startRestartGroup.endReplaceGroup();
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (rememberedValue2 == companion.getEmpty()) {
                CompositionScopedCoroutineScopeCanceller compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, startRestartGroup));
                startRestartGroup.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
                rememberedValue2 = compositionScopedCoroutineScopeCanceller;
            }
            CoroutineScope coroutineScope = ((CompositionScopedCoroutineScopeCanceller) rememberedValue2).getCoroutineScope();
            seenProduct.invoke();
            CompositionLocalKt.CompositionLocalProvider(RippleKt.getLocalRippleConfiguration().provides(null), ComposableLambdaKt.rememberComposableLambda(-1605530088, true, new SaleOnBoardProductRowViewKt$SaleOnBoardProductRowView$1(coroutineScope, animatable, showProductDetails, product, z5), startRestartGroup, 54), startRestartGroup, ProvidedValue.$stable | 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: g4.s
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit SaleOnBoardProductRowView$lambda$1;
                    SaleOnBoardProductRowView$lambda$1 = SaleOnBoardProductRowViewKt.SaleOnBoardProductRowView$lambda$1(SaleOnBoardProduct.this, showProductDetails, z5, seenProduct, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return SaleOnBoardProductRowView$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SaleOnBoardProductRowView$lambda$1(SaleOnBoardProduct saleOnBoardProduct, Function0 function0, boolean z5, Function0 function02, int i5, Composer composer, int i6) {
        SaleOnBoardProductRowView(saleOnBoardProduct, function0, z5, function02, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }
}
