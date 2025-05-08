package dk.molslinjen.ui.views.screens.booking.addons;

import androidx.compose.foundation.BackgroundKt;
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
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.unit.Dp;
import coil.compose.AsyncImagePainter;
import coil.compose.SingletonAsyncImagePainterKt;
import dk.molslinjen.core.extensions.Accessibility;
import dk.molslinjen.core.image.ImageHelper;
import dk.molslinjen.domain.extensions.domain.IQuantityProductExtensionsKt;
import dk.molslinjen.domain.model.booking.product.IQuantityProduct;
import dk.molslinjen.domain.model.booking.product.Product;
import dk.molslinjen.domain.model.booking.product.presentation.ImageProductPresentation;
import dk.molslinjen.domain.model.booking.product.presentation.ProductPresentation;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.theme.AppColor;
import dk.molslinjen.ui.theme.TypographyKt;
import dk.molslinjen.ui.views.reusable.input.NumberSelectorKt;
import dk.molslinjen.ui.views.screens.booking.addons.FoodProductViewKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\u001a1\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0001\u001a\u00020\u00002\u0018\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0002H\u0007¢\u0006\u0004\b\u0007\u0010\b\u001aA\u0010\r\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u000b2\u0018\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0002H\u0003¢\u0006\u0004\b\r\u0010\u000e\u001a\u0017\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0001\u001a\u00020\u0000H\u0003¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Ldk/molslinjen/domain/model/booking/product/IQuantityProduct;", "product", "Lkotlin/Function2;", "Ldk/molslinjen/domain/model/booking/product/Product;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "onQuantityChanged", "FoodProductView", "(Ldk/molslinjen/domain/model/booking/product/IQuantityProduct;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "Landroidx/compose/ui/Modifier;", "modifier", BuildConfig.FLAVOR, "isRecommended", "Content", "(Landroidx/compose/ui/Modifier;Ldk/molslinjen/domain/model/booking/product/IQuantityProduct;ZLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "FoodProductImageView", "(Ldk/molslinjen/domain/model/booking/product/IQuantityProduct;Landroidx/compose/runtime/Composer;I)V", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class FoodProductViewKt {
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void Content(final Modifier modifier, final IQuantityProduct iQuantityProduct, final boolean z5, final Function2<? super Product, ? super Integer, Unit> function2, Composer composer, final int i5) {
        int i6;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(-1919963408);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changed(modifier) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changedInstance(iQuantityProduct) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i6 |= startRestartGroup.changed(z5) ? 256 : 128;
        }
        if ((i5 & 3072) == 0) {
            i6 |= startRestartGroup.changedInstance(function2) ? 2048 : 1024;
        }
        int i7 = i6;
        if ((i7 & 1171) == 1170 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1919963408, i7, -1, "dk.molslinjen.ui.views.screens.booking.addons.Content (FoodProductView.kt:78)");
            }
            float f5 = 8;
            Modifier m311padding3ABfNKs = PaddingKt.m311padding3ABfNKs(modifier, Dp.m2599constructorimpl(f5));
            Arrangement arrangement = Arrangement.INSTANCE;
            Arrangement.Vertical top = arrangement.getTop();
            Alignment.Companion companion = Alignment.INSTANCE;
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(top, companion.getStart(), startRestartGroup, 0);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, m311padding3ABfNKs);
            ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
            Function0<ComposeUiNode> constructor = companion2.getConstructor();
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
            Updater.m1227setimpl(m1226constructorimpl, columnMeasurePolicy, companion2.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion2.getSetCompositeKeyHash();
            if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion2.getSetModifier());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            startRestartGroup.startReplaceGroup(-1033582361);
            if (z5) {
                RecommendedProductImageViewKt.RecommendedProductImageView(iQuantityProduct instanceof Product ? (Product) iQuantityProduct : null, startRestartGroup, 0);
                SpacerKt.Spacer(SizeKt.m325height3ABfNKs(Modifier.INSTANCE, Dp.m2599constructorimpl(f5)), startRestartGroup, 6);
            }
            startRestartGroup.endReplaceGroup();
            Modifier.Companion companion3 = Modifier.INSTANCE;
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(arrangement.getStart(), companion.getTop(), startRestartGroup, 0);
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, companion3);
            Function0<ComposeUiNode> constructor2 = companion2.getConstructor();
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
            Updater.m1227setimpl(m1226constructorimpl2, rowMeasurePolicy, companion2.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl2, currentCompositionLocalMap2, companion2.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = companion2.getSetCompositeKeyHash();
            if (m1226constructorimpl2.getInserting() || !Intrinsics.areEqual(m1226constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                m1226constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                m1226constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            Updater.m1227setimpl(m1226constructorimpl2, materializeModifier2, companion2.getSetModifier());
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            startRestartGroup.startReplaceGroup(-304048705);
            if (!z5) {
                FoodProductImageView(iQuantityProduct, startRestartGroup, (i7 >> 3) & 14);
                SpacerKt.Spacer(SizeKt.m336width3ABfNKs(companion3, Dp.m2599constructorimpl(f5)), startRestartGroup, 6);
            }
            startRestartGroup.endReplaceGroup();
            Modifier fillMaxHeight$default = SizeKt.fillMaxHeight$default(PaddingKt.m311padding3ABfNKs(companion3, Dp.m2599constructorimpl(f5)), 0.0f, 1, null);
            MeasurePolicy columnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(arrangement.getTop(), companion.getStart(), startRestartGroup, 0);
            int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap3 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(startRestartGroup, fillMaxHeight$default);
            Function0<ComposeUiNode> constructor3 = companion2.getConstructor();
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
            Updater.m1227setimpl(m1226constructorimpl3, columnMeasurePolicy2, companion2.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl3, currentCompositionLocalMap3, companion2.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = companion2.getSetCompositeKeyHash();
            if (m1226constructorimpl3.getInserting() || !Intrinsics.areEqual(m1226constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                m1226constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                m1226constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
            }
            Updater.m1227setimpl(m1226constructorimpl3, materializeModifier3, companion2.getSetModifier());
            TextKt.m940Text4IGK_g(iQuantityProduct.getName(), null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getParagraphSmall(), startRestartGroup, 0, 1572864, 65534);
            SpacerKt.Spacer(ColumnScope.weight$default(columnScopeInstance, companion3, 1.0f, false, 2, null), startRestartGroup, 0);
            Modifier m315paddingqDBjuR0$default = PaddingKt.m315paddingqDBjuR0$default(companion3, 0.0f, Dp.m2599constructorimpl(f5), 0.0f, 0.0f, 13, null);
            MeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(arrangement.getStart(), companion.getTop(), startRestartGroup, 0);
            int currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap4 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier4 = ComposedModifierKt.materializeModifier(startRestartGroup, m315paddingqDBjuR0$default);
            Function0<ComposeUiNode> constructor4 = companion2.getConstructor();
            if (startRestartGroup.getApplier() == null) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor4);
            } else {
                startRestartGroup.useNode();
            }
            Composer m1226constructorimpl4 = Updater.m1226constructorimpl(startRestartGroup);
            Updater.m1227setimpl(m1226constructorimpl4, rowMeasurePolicy2, companion2.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl4, currentCompositionLocalMap4, companion2.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash4 = companion2.getSetCompositeKeyHash();
            if (m1226constructorimpl4.getInserting() || !Intrinsics.areEqual(m1226constructorimpl4.rememberedValue(), Integer.valueOf(currentCompositeKeyHash4))) {
                m1226constructorimpl4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                m1226constructorimpl4.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash4);
            }
            Updater.m1227setimpl(m1226constructorimpl4, materializeModifier4, companion2.getSetModifier());
            Modifier align = rowScopeInstance.align(companion3, companion.getCenterVertically());
            MeasurePolicy rowMeasurePolicy3 = RowKt.rowMeasurePolicy(arrangement.getStart(), companion.getTop(), startRestartGroup, 0);
            int currentCompositeKeyHash5 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap5 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier5 = ComposedModifierKt.materializeModifier(startRestartGroup, align);
            Function0<ComposeUiNode> constructor5 = companion2.getConstructor();
            if (startRestartGroup.getApplier() == null) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor5);
            } else {
                startRestartGroup.useNode();
            }
            Composer m1226constructorimpl5 = Updater.m1226constructorimpl(startRestartGroup);
            Updater.m1227setimpl(m1226constructorimpl5, rowMeasurePolicy3, companion2.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl5, currentCompositionLocalMap5, companion2.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash5 = companion2.getSetCompositeKeyHash();
            if (m1226constructorimpl5.getInserting() || !Intrinsics.areEqual(m1226constructorimpl5.rememberedValue(), Integer.valueOf(currentCompositeKeyHash5))) {
                m1226constructorimpl5.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash5));
                m1226constructorimpl5.apply(Integer.valueOf(currentCompositeKeyHash5), setCompositeKeyHash5);
            }
            Updater.m1227setimpl(m1226constructorimpl5, materializeModifier5, companion2.getSetModifier());
            ProductPriceViewKt.ProductPriceView(iQuantityProduct.getPrice(), startRestartGroup, 0);
            startRestartGroup.endNode();
            SpacerKt.Spacer(RowScope.weight$default(rowScopeInstance, companion3, 1.0f, false, 2, null), startRestartGroup, 0);
            int quantity = iQuantityProduct.getQuantity();
            int maxQuantity = iQuantityProduct.getMaxQuantity();
            int minFirstStep = iQuantityProduct.getMinFirstStep();
            boolean z6 = !iQuantityProduct.getDisabled();
            startRestartGroup.startReplaceGroup(-83923647);
            int i8 = i7 & 7168;
            boolean changedInstance = startRestartGroup.changedInstance(iQuantityProduct) | (i8 == 2048);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function1() { // from class: D2.E
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit Content$lambda$9$lambda$8$lambda$7$lambda$6$lambda$3$lambda$2;
                        Content$lambda$9$lambda$8$lambda$7$lambda$6$lambda$3$lambda$2 = FoodProductViewKt.Content$lambda$9$lambda$8$lambda$7$lambda$6$lambda$3$lambda$2(Function2.this, iQuantityProduct, ((Integer) obj).intValue());
                        return Content$lambda$9$lambda$8$lambda$7$lambda$6$lambda$3$lambda$2;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            Function1 function1 = (Function1) rememberedValue;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(-83920799);
            boolean changedInstance2 = startRestartGroup.changedInstance(iQuantityProduct) | (i8 == 2048);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (changedInstance2 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                rememberedValue2 = new Function1() { // from class: D2.F
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit Content$lambda$9$lambda$8$lambda$7$lambda$6$lambda$5$lambda$4;
                        Content$lambda$9$lambda$8$lambda$7$lambda$6$lambda$5$lambda$4 = FoodProductViewKt.Content$lambda$9$lambda$8$lambda$7$lambda$6$lambda$5$lambda$4(Function2.this, iQuantityProduct, ((Integer) obj).intValue());
                        return Content$lambda$9$lambda$8$lambda$7$lambda$6$lambda$5$lambda$4;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            startRestartGroup.endReplaceGroup();
            composer2 = startRestartGroup;
            NumberSelectorKt.NumberSelector(null, quantity, minFirstStep, 0, maxQuantity, null, null, null, function1, (Function1) rememberedValue2, null, false, true, z6, false, composer2, 0, 384, 19689);
            composer2.endNode();
            composer2.endNode();
            composer2.endNode();
            composer2.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: D2.G
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit Content$lambda$10;
                    Content$lambda$10 = FoodProductViewKt.Content$lambda$10(Modifier.this, iQuantityProduct, z5, function2, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return Content$lambda$10;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Content$lambda$10(Modifier modifier, IQuantityProduct iQuantityProduct, boolean z5, Function2 function2, int i5, Composer composer, int i6) {
        Content(modifier, iQuantityProduct, z5, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit Content$lambda$9$lambda$8$lambda$7$lambda$6$lambda$3$lambda$2(Function2 function2, IQuantityProduct iQuantityProduct, int i5) {
        Intrinsics.checkNotNull(iQuantityProduct, "null cannot be cast to non-null type dk.molslinjen.domain.model.booking.product.Product");
        function2.invoke((Product) iQuantityProduct, Integer.valueOf(i5));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit Content$lambda$9$lambda$8$lambda$7$lambda$6$lambda$5$lambda$4(Function2 function2, IQuantityProduct iQuantityProduct, int i5) {
        Intrinsics.checkNotNull(iQuantityProduct, "null cannot be cast to non-null type dk.molslinjen.domain.model.booking.product.Product");
        function2.invoke((Product) iQuantityProduct, Integer.valueOf(i5));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final void FoodProductImageView(final IQuantityProduct iQuantityProduct, Composer composer, final int i5) {
        int i6;
        BoxScopeInstance boxScopeInstance;
        Product product;
        Modifier.Companion companion;
        Composer startRestartGroup = composer.startRestartGroup(-1166562553);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(iQuantityProduct) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i6 & 3) == 2 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1166562553, i6, -1, "dk.molslinjen.ui.views.screens.booking.addons.FoodProductImageView (FoodProductView.kt:120)");
            }
            startRestartGroup.startReplaceGroup(-2063903470);
            Object rememberedValue = startRestartGroup.rememberedValue();
            Composer.Companion companion2 = Composer.INSTANCE;
            if (rememberedValue == companion2.getEmpty()) {
                rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            final MutableState mutableState = (MutableState) rememberedValue;
            startRestartGroup.endReplaceGroup();
            ImageHelper imageHelper = ImageHelper.INSTANCE;
            ProductPresentation presentation = iQuantityProduct.getPresentation();
            ImageProductPresentation imageProductPresentation = presentation instanceof ImageProductPresentation ? (ImageProductPresentation) presentation : null;
            float f5 = 121;
            float f6 = 86;
            String m3193buildImageUrlC8IHX40 = imageHelper.m3193buildImageUrlC8IHX40(imageProductPresentation != null ? imageProductPresentation.getImageUrl() : null, Dp.m2597boximpl(Dp.m2599constructorimpl(f6)), Dp.m2597boximpl(Dp.m2599constructorimpl(f5)), startRestartGroup, 3504, 0);
            Modifier.Companion companion3 = Modifier.INSTANCE;
            Modifier m104backgroundbw27NRU$default = BackgroundKt.m104backgroundbw27NRU$default(ClipKt.clip(SizeKt.m333sizeVpY3zN4(companion3, Dp.m2599constructorimpl(f6), Dp.m2599constructorimpl(f5)), MaterialTheme.INSTANCE.getShapes(startRestartGroup, MaterialTheme.$stable).getSmall()), AppColor.INSTANCE.m3268getGrey50d7_KjU(), null, 2, null);
            Alignment.Companion companion4 = Alignment.INSTANCE;
            MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(companion4.getCenter(), false);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, m104backgroundbw27NRU$default);
            ComposeUiNode.Companion companion5 = ComposeUiNode.INSTANCE;
            Function0<ComposeUiNode> constructor = companion5.getConstructor();
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
            Updater.m1227setimpl(m1226constructorimpl, maybeCachedBoxMeasurePolicy, companion5.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion5.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion5.getSetCompositeKeyHash();
            if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion5.getSetModifier());
            BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
            if (m3193buildImageUrlC8IHX40 == null || ((Boolean) mutableState.getValue()).booleanValue()) {
                boxScopeInstance = boxScopeInstance2;
                product = null;
                startRestartGroup.startReplaceGroup(-99837591);
                companion = companion3;
                ImageKt.Image(PainterResources_androidKt.painterResource(R.drawable.icon_food_image_missing, startRestartGroup, 6), Accessibility.INSTANCE.getSkip(), SizeKt.m331size3ABfNKs(companion, Dp.m2599constructorimpl(24)), null, null, 0.0f, null, startRestartGroup, 384, 120);
                startRestartGroup.endReplaceGroup();
            } else {
                startRestartGroup.startReplaceGroup(-100205406);
                startRestartGroup.startReplaceGroup(550961150);
                Object rememberedValue2 = startRestartGroup.rememberedValue();
                if (rememberedValue2 == companion2.getEmpty()) {
                    rememberedValue2 = new Function1() { // from class: D2.H
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            Unit FoodProductImageView$lambda$14$lambda$13$lambda$12;
                            FoodProductImageView$lambda$14$lambda$13$lambda$12 = FoodProductViewKt.FoodProductImageView$lambda$14$lambda$13$lambda$12(MutableState.this, (AsyncImagePainter.State.Error) obj);
                            return FoodProductImageView$lambda$14$lambda$13$lambda$12;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue2);
                }
                startRestartGroup.endReplaceGroup();
                boxScopeInstance = boxScopeInstance2;
                product = null;
                ImageKt.Image(SingletonAsyncImagePainterKt.m2745rememberAsyncImagePainterMqRF_0(m3193buildImageUrlC8IHX40, null, null, null, null, null, (Function1) rememberedValue2, null, 0, startRestartGroup, 1572864, 446), Accessibility.INSTANCE.getSkip(), null, null, ContentScale.INSTANCE.getFit(), 0.0f, null, startRestartGroup, 24576, 108);
                startRestartGroup.endReplaceGroup();
                companion = companion3;
            }
            float f7 = 8;
            ProductTagViewKt.ProductTagView(PaddingKt.m315paddingqDBjuR0$default(boxScopeInstance.align(companion, companion4.getTopStart()), Dp.m2599constructorimpl(f7), Dp.m2599constructorimpl(f7), 0.0f, 0.0f, 12, null), iQuantityProduct instanceof Product ? (Product) iQuantityProduct : product, startRestartGroup, 0, 0);
            startRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: D2.I
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit FoodProductImageView$lambda$15;
                    FoodProductImageView$lambda$15 = FoodProductViewKt.FoodProductImageView$lambda$15(IQuantityProduct.this, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return FoodProductImageView$lambda$15;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FoodProductImageView$lambda$14$lambda$13$lambda$12(MutableState mutableState, AsyncImagePainter.State.Error it) {
        Intrinsics.checkNotNullParameter(it, "it");
        mutableState.setValue(Boolean.TRUE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FoodProductImageView$lambda$15(IQuantityProduct iQuantityProduct, int i5, Composer composer, int i6) {
        FoodProductImageView(iQuantityProduct, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    public static final void FoodProductView(final IQuantityProduct product, final Function2<? super Product, ? super Integer, Unit> onQuantityChanged, Composer composer, final int i5) {
        int i6;
        Intrinsics.checkNotNullParameter(product, "product");
        Intrinsics.checkNotNullParameter(onQuantityChanged, "onQuantityChanged");
        Composer startRestartGroup = composer.startRestartGroup(1489794148);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(product) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changedInstance(onQuantityChanged) ? 32 : 16;
        }
        if ((i6 & 19) == 18 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1489794148, i6, -1, "dk.molslinjen.ui.views.screens.booking.addons.FoodProductView (FoodProductView.kt:43)");
            }
            final boolean isRecommended = IQuantityProductExtensionsKt.isRecommended(product);
            startRestartGroup.startReplaceGroup(-110727384);
            final Modifier m103backgroundbw27NRU = isRecommended ? BackgroundKt.m103backgroundbw27NRU(Modifier.INSTANCE, AppColor.INSTANCE.m3281getWhite0d7_KjU(), MaterialTheme.INSTANCE.getShapes(startRestartGroup, MaterialTheme.$stable).getSmall()) : IntrinsicKt.height(BackgroundKt.m104backgroundbw27NRU$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), AppColor.INSTANCE.m3281getWhite0d7_KjU(), null, 2, null), IntrinsicSize.Max);
            startRestartGroup.endReplaceGroup();
            ComposableLambda rememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-1799436443, true, new Function2<Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.booking.addons.FoodProductViewKt$FoodProductView$content$1
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i7) {
                    if ((i7 & 3) == 2 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1799436443, i7, -1, "dk.molslinjen.ui.views.screens.booking.addons.FoodProductView.<anonymous> (FoodProductView.kt:54)");
                    }
                    FoodProductViewKt.Content(Modifier.this, product, isRecommended, onQuantityChanged, composer2, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, startRestartGroup, 54);
            if (isRecommended) {
                startRestartGroup.startReplaceGroup(862901157);
                RecommendedFrameViewKt.RecommendedFrameView(IntrinsicKt.height(Modifier.INSTANCE, IntrinsicSize.Max), rememberComposableLambda, startRestartGroup, 54, 0);
                startRestartGroup.endReplaceGroup();
            } else {
                startRestartGroup.startReplaceGroup(863038580);
                rememberComposableLambda.invoke(startRestartGroup, 6);
                startRestartGroup.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: D2.D
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit FoodProductView$lambda$0;
                    FoodProductView$lambda$0 = FoodProductViewKt.FoodProductView$lambda$0(IQuantityProduct.this, onQuantityChanged, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return FoodProductView$lambda$0;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FoodProductView$lambda$0(IQuantityProduct iQuantityProduct, Function2 function2, int i5, Composer composer, int i6) {
        FoodProductView(iQuantityProduct, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }
}
