package dk.molslinjen.ui.views.screens.saleOnBoard.basket;

import android.content.Context;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.IntrinsicKt;
import androidx.compose.foundation.layout.IntrinsicSize;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Dp;
import coil.compose.AsyncImagePainter;
import coil.compose.SingletonAsyncImagePainterKt;
import dk.molslinjen.core.extensions.Accessibility;
import dk.molslinjen.domain.model.saleOnBoard.SaleOnBoardCrossSaleProduct;
import dk.molslinjen.domain.model.saleOnBoard.SaleOnBoardProduct;
import dk.molslinjen.domain.model.shared.Price;
import dk.molslinjen.extensions.domain.PriceFormatExtensionsKt;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.theme.AppColor;
import dk.molslinjen.ui.theme.TypographyKt;
import dk.molslinjen.ui.views.screens.saleOnBoard.basket.SaleOnBoardCrossSaleViewKt;
import dk.molslinjen.ui.views.shared.components.PriceTextKt;
import dk.molslinjen.ui.views.shared.components.PriceViewType;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u001a+\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0001\u001a\u00020\u00002\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00030\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardCrossSaleProduct;", "crossSaleProduct", "Lkotlin/Function1;", BuildConfig.FLAVOR, "add", "SaleOnBoardCrossSaleView", "(Ldk/molslinjen/domain/model/saleOnBoard/SaleOnBoardCrossSaleProduct;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class SaleOnBoardCrossSaleViewKt {
    public static final void SaleOnBoardCrossSaleView(final SaleOnBoardCrossSaleProduct crossSaleProduct, final Function1<? super SaleOnBoardCrossSaleProduct, Unit> add, Composer composer, final int i5) {
        int i6;
        float f5;
        int i7;
        Intrinsics.checkNotNullParameter(crossSaleProduct, "crossSaleProduct");
        Intrinsics.checkNotNullParameter(add, "add");
        Composer startRestartGroup = composer.startRestartGroup(95076090);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(crossSaleProduct) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changedInstance(add) ? 32 : 16;
        }
        int i8 = i6;
        if ((i8 & 19) == 18 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(95076090, i8, -1, "dk.molslinjen.ui.views.screens.saleOnBoard.basket.SaleOnBoardCrossSaleView (SaleOnBoardCrossSaleView.kt:46)");
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null);
            AppColor appColor = AppColor.INSTANCE;
            float f6 = 16;
            Modifier height = IntrinsicKt.height(PaddingKt.m311padding3ABfNKs(BackgroundKt.m104backgroundbw27NRU$default(fillMaxWidth$default, appColor.m3281getWhite0d7_KjU(), null, 2, null), Dp.m2599constructorimpl(f6)), IntrinsicSize.Max);
            Alignment.Companion companion2 = Alignment.INSTANCE;
            Alignment.Vertical centerVertically = companion2.getCenterVertically();
            Arrangement arrangement = Arrangement.INSTANCE;
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(arrangement.getStart(), centerVertically, startRestartGroup, 48);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, height);
            ComposeUiNode.Companion companion3 = ComposeUiNode.INSTANCE;
            Function0<ComposeUiNode> constructor = companion3.getConstructor();
            if (startRestartGroup.getApplier() == null) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor);
            } else {
                startRestartGroup.useNode();
            }
            Composer m1226constructorimpl = Updater.m1226constructorimpl(startRestartGroup);
            Updater.m1227setimpl(m1226constructorimpl, rowMeasurePolicy, companion3.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion3.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion3.getSetCompositeKeyHash();
            if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion3.getSetModifier());
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            startRestartGroup.startReplaceGroup(1171858818);
            Object rememberedValue = startRestartGroup.rememberedValue();
            Composer.Companion companion4 = Composer.INSTANCE;
            if (rememberedValue == companion4.getEmpty()) {
                rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            final MutableState mutableState = (MutableState) rememberedValue;
            startRestartGroup.endReplaceGroup();
            Modifier m104backgroundbw27NRU$default = BackgroundKt.m104backgroundbw27NRU$default(ClipKt.clip(SizeKt.m331size3ABfNKs(companion, Dp.m2599constructorimpl(56)), MaterialTheme.INSTANCE.getShapes(startRestartGroup, MaterialTheme.$stable).getSmall()), appColor.m3268getGrey50d7_KjU(), null, 2, null);
            MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(companion2.getCenter(), false);
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, m104backgroundbw27NRU$default);
            Function0<ComposeUiNode> constructor2 = companion3.getConstructor();
            if (startRestartGroup.getApplier() == null) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor2);
            } else {
                startRestartGroup.useNode();
            }
            Composer m1226constructorimpl2 = Updater.m1226constructorimpl(startRestartGroup);
            Updater.m1227setimpl(m1226constructorimpl2, maybeCachedBoxMeasurePolicy, companion3.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl2, currentCompositionLocalMap2, companion3.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = companion3.getSetCompositeKeyHash();
            if (m1226constructorimpl2.getInserting() || !Intrinsics.areEqual(m1226constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                m1226constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                m1226constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            Updater.m1227setimpl(m1226constructorimpl2, materializeModifier2, companion3.getSetModifier());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            if (((Boolean) mutableState.getValue()).booleanValue()) {
                f5 = f6;
                i7 = i8;
                startRestartGroup.startReplaceGroup(-2061868895);
                ImageKt.Image(PainterResources_androidKt.painterResource(R.drawable.icon_food_image_missing, startRestartGroup, 6), Accessibility.INSTANCE.getSkip(), SizeKt.m331size3ABfNKs(companion, Dp.m2599constructorimpl(24)), null, null, 0.0f, null, startRestartGroup, 384, 120);
                startRestartGroup.endReplaceGroup();
            } else {
                startRestartGroup.startReplaceGroup(-2062367189);
                Modifier fillMaxHeight$default = SizeKt.fillMaxHeight$default(companion, 0.0f, 1, null);
                SaleOnBoardProduct product = crossSaleProduct.getProduct();
                String squareImageUrl = product != null ? product.getSquareImageUrl() : null;
                startRestartGroup.startReplaceGroup(903310838);
                Object rememberedValue2 = startRestartGroup.rememberedValue();
                if (rememberedValue2 == companion4.getEmpty()) {
                    rememberedValue2 = new Function1() { // from class: f4.s
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            Unit SaleOnBoardCrossSaleView$lambda$10$lambda$3$lambda$2$lambda$1;
                            SaleOnBoardCrossSaleView$lambda$10$lambda$3$lambda$2$lambda$1 = SaleOnBoardCrossSaleViewKt.SaleOnBoardCrossSaleView$lambda$10$lambda$3$lambda$2$lambda$1(MutableState.this, (AsyncImagePainter.State.Error) obj);
                            return SaleOnBoardCrossSaleView$lambda$10$lambda$3$lambda$2$lambda$1;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue2);
                }
                startRestartGroup.endReplaceGroup();
                f5 = f6;
                i7 = i8;
                ImageKt.Image(SingletonAsyncImagePainterKt.m2745rememberAsyncImagePainterMqRF_0(squareImageUrl, null, null, null, null, null, (Function1) rememberedValue2, null, 0, startRestartGroup, 1572864, 446), Accessibility.INSTANCE.getSkip(), fillMaxHeight$default, null, ContentScale.INSTANCE.getCrop(), 0.0f, null, startRestartGroup, 24960, 104);
                startRestartGroup.endReplaceGroup();
                startRestartGroup = startRestartGroup;
            }
            startRestartGroup.endNode();
            Modifier fillMaxHeight$default2 = SizeKt.fillMaxHeight$default(PaddingKt.m313paddingVpY3zN4$default(companion, Dp.m2599constructorimpl(f5), 0.0f, 2, null), 0.0f, 1, null);
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(arrangement.getTop(), companion2.getStart(), startRestartGroup, 0);
            int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap3 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(startRestartGroup, fillMaxHeight$default2);
            Function0<ComposeUiNode> constructor3 = companion3.getConstructor();
            if (startRestartGroup.getApplier() == null) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor3);
            } else {
                startRestartGroup.useNode();
            }
            Composer m1226constructorimpl3 = Updater.m1226constructorimpl(startRestartGroup);
            Updater.m1227setimpl(m1226constructorimpl3, columnMeasurePolicy, companion3.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl3, currentCompositionLocalMap3, companion3.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = companion3.getSetCompositeKeyHash();
            if (m1226constructorimpl3.getInserting() || !Intrinsics.areEqual(m1226constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                m1226constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                m1226constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
            }
            Updater.m1227setimpl(m1226constructorimpl3, materializeModifier3, companion3.getSetModifier());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            Composer composer2 = startRestartGroup;
            TextKt.m940Text4IGK_g(crossSaleProduct.getName(), null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getParagraphSmall(), composer2, 0, 1572864, 65534);
            SpacerKt.Spacer(ColumnScope.weight$default(columnScopeInstance, companion, 1.0f, false, 2, null), composer2, 0);
            final Context context = (Context) composer2.consume(AndroidCompositionLocals_androidKt.getLocalContext());
            Modifier m315paddingqDBjuR0$default = PaddingKt.m315paddingqDBjuR0$default(companion, 0.0f, Dp.m2599constructorimpl(8), 0.0f, 0.0f, 13, null);
            composer2.startReplaceGroup(903343489);
            boolean changedInstance = composer2.changedInstance(crossSaleProduct) | composer2.changedInstance(context);
            Object rememberedValue3 = composer2.rememberedValue();
            if (changedInstance || rememberedValue3 == companion4.getEmpty()) {
                rememberedValue3 = new Function1() { // from class: f4.t
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit SaleOnBoardCrossSaleView$lambda$10$lambda$7$lambda$5$lambda$4;
                        SaleOnBoardCrossSaleView$lambda$10$lambda$7$lambda$5$lambda$4 = SaleOnBoardCrossSaleViewKt.SaleOnBoardCrossSaleView$lambda$10$lambda$7$lambda$5$lambda$4(SaleOnBoardCrossSaleProduct.this, context, (SemanticsPropertyReceiver) obj);
                        return SaleOnBoardCrossSaleView$lambda$10$lambda$7$lambda$5$lambda$4;
                    }
                };
                composer2.updateRememberedValue(rememberedValue3);
            }
            composer2.endReplaceGroup();
            Modifier clearAndSetSemantics = SemanticsModifierKt.clearAndSetSemantics(m315paddingqDBjuR0$default, (Function1) rememberedValue3);
            MeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(arrangement.getStart(), companion2.getTop(), composer2, 0);
            int currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
            CompositionLocalMap currentCompositionLocalMap4 = composer2.getCurrentCompositionLocalMap();
            Modifier materializeModifier4 = ComposedModifierKt.materializeModifier(composer2, clearAndSetSemantics);
            Function0<ComposeUiNode> constructor4 = companion3.getConstructor();
            if (composer2.getApplier() == null) {
                ComposablesKt.invalidApplier();
            }
            composer2.startReusableNode();
            if (composer2.getInserting()) {
                composer2.createNode(constructor4);
            } else {
                composer2.useNode();
            }
            Composer m1226constructorimpl4 = Updater.m1226constructorimpl(composer2);
            Updater.m1227setimpl(m1226constructorimpl4, rowMeasurePolicy2, companion3.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl4, currentCompositionLocalMap4, companion3.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash4 = companion3.getSetCompositeKeyHash();
            if (m1226constructorimpl4.getInserting() || !Intrinsics.areEqual(m1226constructorimpl4.rememberedValue(), Integer.valueOf(currentCompositeKeyHash4))) {
                m1226constructorimpl4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                m1226constructorimpl4.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash4);
            }
            Updater.m1227setimpl(m1226constructorimpl4, materializeModifier4, companion3.getSetModifier());
            PriceTextKt.m3557PriceText1y9Plug((Price) crossSaleProduct.getPrice(), rowScopeInstance.alignByBaseline(companion), PriceViewType.PriceOnly, false, TypographyKt.getParagraph(), (TextAlign) null, 0, 0L, composer2, 24960, 232);
            PriceTextKt.m3557PriceText1y9Plug((Price) crossSaleProduct.getPrice(), PaddingKt.m315paddingqDBjuR0$default(rowScopeInstance.alignByBaseline(companion), Dp.m2599constructorimpl(2), 0.0f, 0.0f, 0.0f, 14, null), PriceViewType.CurrencyOnly, false, TypographyKt.getSubSmall(), (TextAlign) null, 0, 0L, composer2, 24960, 232);
            composer2.endNode();
            composer2.endNode();
            startRestartGroup = composer2;
            SpacerKt.Spacer(RowScope.weight$default(rowScopeInstance, companion, 1.0f, false, 2, null), startRestartGroup, 0);
            Painter painterResource = PainterResources_androidKt.painterResource(R.drawable.icon_add_green_circle, startRestartGroup, 6);
            String stringResource = StringResources_androidKt.stringResource(R.string.saleOnBoard_addToBasket, startRestartGroup, 6);
            Modifier clip = ClipKt.clip(SizeKt.m331size3ABfNKs(companion, Dp.m2599constructorimpl(40)), RoundedCornerShapeKt.getCircleShape());
            startRestartGroup.startReplaceGroup(1171942649);
            boolean changedInstance2 = startRestartGroup.changedInstance(crossSaleProduct) | ((i7 & 112) == 32);
            Object rememberedValue4 = startRestartGroup.rememberedValue();
            if (changedInstance2 || rememberedValue4 == companion4.getEmpty()) {
                rememberedValue4 = new Function0() { // from class: f4.u
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit SaleOnBoardCrossSaleView$lambda$10$lambda$9$lambda$8;
                        SaleOnBoardCrossSaleView$lambda$10$lambda$9$lambda$8 = SaleOnBoardCrossSaleViewKt.SaleOnBoardCrossSaleView$lambda$10$lambda$9$lambda$8(Function1.this, crossSaleProduct);
                        return SaleOnBoardCrossSaleView$lambda$10$lambda$9$lambda$8;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue4);
            }
            startRestartGroup.endReplaceGroup();
            ImageKt.Image(painterResource, stringResource, ClickableKt.m122clickableXHw0xAI$default(clip, false, null, null, (Function0) rememberedValue4, 7, null), null, null, 0.0f, null, startRestartGroup, 0, 120);
            startRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: f4.v
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit SaleOnBoardCrossSaleView$lambda$11;
                    SaleOnBoardCrossSaleView$lambda$11 = SaleOnBoardCrossSaleViewKt.SaleOnBoardCrossSaleView$lambda$11(SaleOnBoardCrossSaleProduct.this, add, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return SaleOnBoardCrossSaleView$lambda$11;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SaleOnBoardCrossSaleView$lambda$10$lambda$3$lambda$2$lambda$1(MutableState mutableState, AsyncImagePainter.State.Error it) {
        Intrinsics.checkNotNullParameter(it, "it");
        mutableState.setValue(Boolean.TRUE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SaleOnBoardCrossSaleView$lambda$10$lambda$7$lambda$5$lambda$4(SaleOnBoardCrossSaleProduct saleOnBoardCrossSaleProduct, Context context, SemanticsPropertyReceiver clearAndSetSemantics) {
        Intrinsics.checkNotNullParameter(clearAndSetSemantics, "$this$clearAndSetSemantics");
        SemanticsPropertiesKt.setContentDescription(clearAndSetSemantics, PriceFormatExtensionsKt.formatted(saleOnBoardCrossSaleProduct.getPrice(), context));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SaleOnBoardCrossSaleView$lambda$10$lambda$9$lambda$8(Function1 function1, SaleOnBoardCrossSaleProduct saleOnBoardCrossSaleProduct) {
        function1.invoke(saleOnBoardCrossSaleProduct);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SaleOnBoardCrossSaleView$lambda$11(SaleOnBoardCrossSaleProduct saleOnBoardCrossSaleProduct, Function1 function1, int i5, Composer composer, int i6) {
        SaleOnBoardCrossSaleView(saleOnBoardCrossSaleProduct, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }
}
