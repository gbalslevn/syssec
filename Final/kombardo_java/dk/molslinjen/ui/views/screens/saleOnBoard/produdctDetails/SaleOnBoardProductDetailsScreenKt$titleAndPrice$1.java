package dk.molslinjen.ui.views.screens.saleOnBoard.produdctDetails;

import android.content.Context;
import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Dp;
import dk.molslinjen.domain.model.saleOnBoard.SaleOnBoardProduct;
import dk.molslinjen.domain.model.shared.Price;
import dk.molslinjen.extensions.domain.PriceFormatExtensionsKt;
import dk.molslinjen.ui.theme.AppColor;
import dk.molslinjen.ui.theme.TypographyKt;
import dk.molslinjen.ui.views.shared.components.PriceTextKt;
import dk.molslinjen.ui.views.shared.components.PriceViewType;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
final class SaleOnBoardProductDetailsScreenKt$titleAndPrice$1 implements Function3<LazyItemScope, Composer, Integer, Unit> {
    final /* synthetic */ LazyListState $listState;
    final /* synthetic */ SaleOnBoardProduct $product;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SaleOnBoardProductDetailsScreenKt$titleAndPrice$1(LazyListState lazyListState, SaleOnBoardProduct saleOnBoardProduct) {
        this.$listState = lazyListState;
        this.$product = saleOnBoardProduct;
    }

    private static final float invoke$lambda$0(State<Dp> state) {
        return state.getValue().getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$4$lambda$2$lambda$1(SaleOnBoardProduct saleOnBoardProduct, Context context, SemanticsPropertyReceiver clearAndSetSemantics) {
        Intrinsics.checkNotNullParameter(clearAndSetSemantics, "$this$clearAndSetSemantics");
        SemanticsPropertiesKt.setContentDescription(clearAndSetSemantics, PriceFormatExtensionsKt.formatted(saleOnBoardProduct.getPrice(), context));
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer, Integer num) {
        invoke(lazyItemScope, composer, num.intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(LazyItemScope stickyHeader, Composer composer, int i5) {
        Intrinsics.checkNotNullParameter(stickyHeader, "$this$stickyHeader");
        if ((i5 & 17) == 16 && composer.getSkipping()) {
            composer.skipToGroupEnd();
            return;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(718252939, i5, -1, "dk.molslinjen.ui.views.screens.saleOnBoard.produdctDetails.titleAndPrice.<anonymous> (SaleOnBoardProductDetailsScreen.kt:207)");
        }
        State<Dp> m56animateDpAsStateAjpBEmI = AnimateAsStateKt.m56animateDpAsStateAjpBEmI(Dp.m2599constructorimpl(this.$listState.getFirstVisibleItemIndex() > 0 ? 46 : 0), null, null, null, composer, 0, 14);
        Modifier.Companion companion = Modifier.INSTANCE;
        Modifier m312paddingVpY3zN4 = PaddingKt.m312paddingVpY3zN4(BackgroundKt.m104backgroundbw27NRU$default(companion, AppColor.INSTANCE.m3281getWhite0d7_KjU(), null, 2, null), Dp.m2599constructorimpl(24), Dp.m2599constructorimpl(16));
        Alignment.Companion companion2 = Alignment.INSTANCE;
        Alignment.Vertical centerVertically = companion2.getCenterVertically();
        final SaleOnBoardProduct saleOnBoardProduct = this.$product;
        Arrangement arrangement = Arrangement.INSTANCE;
        MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(arrangement.getStart(), centerVertically, composer, 48);
        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
        CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
        Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer, m312paddingVpY3zN4);
        ComposeUiNode.Companion companion3 = ComposeUiNode.INSTANCE;
        Function0<ComposeUiNode> constructor = companion3.getConstructor();
        if (composer.getApplier() == null) {
            ComposablesKt.invalidApplier();
        }
        composer.startReusableNode();
        if (composer.getInserting()) {
            composer.createNode(constructor);
        } else {
            composer.useNode();
        }
        Composer m1226constructorimpl = Updater.m1226constructorimpl(composer);
        Updater.m1227setimpl(m1226constructorimpl, rowMeasurePolicy, companion3.getSetMeasurePolicy());
        Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion3.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion3.getSetCompositeKeyHash();
        if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
            m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
            m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
        }
        Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion3.getSetModifier());
        RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
        TextKt.m940Text4IGK_g(saleOnBoardProduct.getName(), null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getH2Bold(), composer, 0, 1572864, 65534);
        SpacerKt.Spacer(RowScope.weight$default(rowScopeInstance, companion, 1.0f, false, 2, null), composer, 0);
        final Context context = (Context) composer.consume(AndroidCompositionLocals_androidKt.getLocalContext());
        Modifier m315paddingqDBjuR0$default = PaddingKt.m315paddingqDBjuR0$default(companion, 0.0f, 0.0f, invoke$lambda$0(m56animateDpAsStateAjpBEmI), 0.0f, 11, null);
        composer.startReplaceGroup(2074438987);
        boolean changedInstance = composer.changedInstance(saleOnBoardProduct) | composer.changedInstance(context);
        Object rememberedValue = composer.rememberedValue();
        if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = new Function1() { // from class: dk.molslinjen.ui.views.screens.saleOnBoard.produdctDetails.d
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit invoke$lambda$4$lambda$2$lambda$1;
                    invoke$lambda$4$lambda$2$lambda$1 = SaleOnBoardProductDetailsScreenKt$titleAndPrice$1.invoke$lambda$4$lambda$2$lambda$1(SaleOnBoardProduct.this, context, (SemanticsPropertyReceiver) obj);
                    return invoke$lambda$4$lambda$2$lambda$1;
                }
            };
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceGroup();
        Modifier clearAndSetSemantics = SemanticsModifierKt.clearAndSetSemantics(m315paddingqDBjuR0$default, (Function1) rememberedValue);
        MeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(arrangement.getStart(), companion2.getTop(), composer, 0);
        int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
        CompositionLocalMap currentCompositionLocalMap2 = composer.getCurrentCompositionLocalMap();
        Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(composer, clearAndSetSemantics);
        Function0<ComposeUiNode> constructor2 = companion3.getConstructor();
        if (composer.getApplier() == null) {
            ComposablesKt.invalidApplier();
        }
        composer.startReusableNode();
        if (composer.getInserting()) {
            composer.createNode(constructor2);
        } else {
            composer.useNode();
        }
        Composer m1226constructorimpl2 = Updater.m1226constructorimpl(composer);
        Updater.m1227setimpl(m1226constructorimpl2, rowMeasurePolicy2, companion3.getSetMeasurePolicy());
        Updater.m1227setimpl(m1226constructorimpl2, currentCompositionLocalMap2, companion3.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = companion3.getSetCompositeKeyHash();
        if (m1226constructorimpl2.getInserting() || !Intrinsics.areEqual(m1226constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
            m1226constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
            m1226constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
        }
        Updater.m1227setimpl(m1226constructorimpl2, materializeModifier2, companion3.getSetModifier());
        PriceTextKt.m3557PriceText1y9Plug((Price) saleOnBoardProduct.getPrice(), rowScopeInstance.alignByBaseline(companion), PriceViewType.PriceOnly, false, TypographyKt.getH3Bold(), (TextAlign) null, 0, 0L, composer, 24960, 232);
        PriceTextKt.m3557PriceText1y9Plug((Price) saleOnBoardProduct.getPrice(), PaddingKt.m315paddingqDBjuR0$default(rowScopeInstance.alignByBaseline(companion), Dp.m2599constructorimpl(2), 0.0f, 0.0f, 0.0f, 14, null), PriceViewType.CurrencyOnly, false, TypographyKt.getSub(), (TextAlign) null, 0, 0L, composer, 24960, 232);
        composer.endNode();
        composer.endNode();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
