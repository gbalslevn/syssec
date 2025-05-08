package dk.molslinjen.ui.views.screens.booking.addons;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
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
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Dp;
import dk.molslinjen.domain.extensions.domain.IQuantityProductExtensionsKt;
import dk.molslinjen.domain.model.booking.product.ExtraProduct;
import dk.molslinjen.domain.model.booking.product.IQuantityProduct;
import dk.molslinjen.domain.model.booking.product.Product;
import dk.molslinjen.ui.theme.AppColor;
import dk.molslinjen.ui.theme.TypographyKt;
import dk.molslinjen.ui.views.reusable.input.NumberSelectorKt;
import dk.molslinjen.ui.views.screens.booking.addons.QuantityProductViewKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\u001a1\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0001\u001a\u00020\u00002\u0018\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0002H\u0007¢\u0006\u0004\b\u0007\u0010\b\u001aA\u0010\r\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u000b2\u0018\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0002H\u0003¢\u0006\u0004\b\r\u0010\u000e\u001a\u0017\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0001\u001a\u00020\u0000H\u0003¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Ldk/molslinjen/domain/model/booking/product/IQuantityProduct;", "product", "Lkotlin/Function2;", "Ldk/molslinjen/domain/model/booking/product/Product;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "onQuantityChanged", "QuantityProductView", "(Ldk/molslinjen/domain/model/booking/product/IQuantityProduct;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "Landroidx/compose/ui/Modifier;", "modifier", BuildConfig.FLAVOR, "isRecommended", "Content", "(Landroidx/compose/ui/Modifier;Ldk/molslinjen/domain/model/booking/product/IQuantityProduct;ZLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "ProductInformationView", "(Ldk/molslinjen/domain/model/booking/product/IQuantityProduct;Landroidx/compose/runtime/Composer;I)V", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class QuantityProductViewKt {
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void Content(final Modifier modifier, final IQuantityProduct iQuantityProduct, final boolean z5, final Function2<? super Product, ? super Integer, Unit> function2, Composer composer, final int i5) {
        int i6;
        int i7;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(2074498269);
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
        if ((i6 & 1171) == 1170 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2074498269, i6, -1, "dk.molslinjen.ui.views.screens.booking.addons.Content (QuantityProductView.kt:63)");
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
            startRestartGroup.startReplaceGroup(-1033601881);
            if (z5) {
                RecommendedProductImageViewKt.RecommendedProductImageView(iQuantityProduct instanceof Product ? (Product) iQuantityProduct : null, startRestartGroup, 0);
                SpacerKt.Spacer(SizeKt.m325height3ABfNKs(Modifier.INSTANCE, Dp.m2599constructorimpl(f5)), startRestartGroup, 6);
            }
            startRestartGroup.endReplaceGroup();
            Modifier.Companion companion3 = Modifier.INSTANCE;
            Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(companion3, 0.0f, 1, null);
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(arrangement.getStart(), companion.getTop(), startRestartGroup, 0);
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, fillMaxWidth$default);
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
            ProductInformationView(iQuantityProduct, startRestartGroup, (i6 >> 3) & 14);
            SpacerKt.Spacer(RowScope.weight$default(rowScopeInstance, companion3, 1.0f, false, 2, null), startRestartGroup, 0);
            startRestartGroup.startReplaceGroup(-304063974);
            if (z5) {
                i7 = 0;
            } else {
                i7 = 0;
                ProductTagViewKt.ProductTagView(PaddingKt.m315paddingqDBjuR0$default(companion3, 0.0f, 0.0f, Dp.m2599constructorimpl(f5), 0.0f, 11, null), iQuantityProduct instanceof Product ? (Product) iQuantityProduct : null, startRestartGroup, 6, 0);
            }
            startRestartGroup.endReplaceGroup();
            startRestartGroup.endNode();
            Modifier m311padding3ABfNKs2 = PaddingKt.m311padding3ABfNKs(companion3, Dp.m2599constructorimpl(f5));
            MeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(arrangement.getStart(), companion.getTop(), startRestartGroup, i7);
            int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, i7);
            CompositionLocalMap currentCompositionLocalMap3 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(startRestartGroup, m311padding3ABfNKs2);
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
            Updater.m1227setimpl(m1226constructorimpl3, rowMeasurePolicy2, companion2.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl3, currentCompositionLocalMap3, companion2.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = companion2.getSetCompositeKeyHash();
            if (m1226constructorimpl3.getInserting() || !Intrinsics.areEqual(m1226constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                m1226constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                m1226constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
            }
            Updater.m1227setimpl(m1226constructorimpl3, materializeModifier3, companion2.getSetModifier());
            Modifier align = rowScopeInstance.align(companion3, companion.getCenterVertically());
            startRestartGroup.startReplaceGroup(-304050728);
            Object rememberedValue = startRestartGroup.rememberedValue();
            Composer.Companion companion4 = Composer.INSTANCE;
            if (rememberedValue == companion4.getEmpty()) {
                rememberedValue = new Function1() { // from class: D2.Y
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit Content$lambda$10$lambda$9$lambda$3$lambda$2;
                        Content$lambda$10$lambda$9$lambda$3$lambda$2 = QuantityProductViewKt.Content$lambda$10$lambda$9$lambda$3$lambda$2((SemanticsPropertyReceiver) obj);
                        return Content$lambda$10$lambda$9$lambda$3$lambda$2;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            Modifier semantics = SemanticsModifierKt.semantics(align, true, (Function1) rememberedValue);
            MeasurePolicy rowMeasurePolicy3 = RowKt.rowMeasurePolicy(arrangement.getStart(), companion.getTop(), startRestartGroup, 0);
            int currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap4 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier4 = ComposedModifierKt.materializeModifier(startRestartGroup, semantics);
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
            Updater.m1227setimpl(m1226constructorimpl4, rowMeasurePolicy3, companion2.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl4, currentCompositionLocalMap4, companion2.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash4 = companion2.getSetCompositeKeyHash();
            if (m1226constructorimpl4.getInserting() || !Intrinsics.areEqual(m1226constructorimpl4.rememberedValue(), Integer.valueOf(currentCompositeKeyHash4))) {
                m1226constructorimpl4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                m1226constructorimpl4.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash4);
            }
            Updater.m1227setimpl(m1226constructorimpl4, materializeModifier4, companion2.getSetModifier());
            ProductPriceViewKt.ProductPriceView(iQuantityProduct.getPrice(), startRestartGroup, 0);
            startRestartGroup.endNode();
            SpacerKt.Spacer(RowScope.weight$default(rowScopeInstance, companion3, 1.0f, false, 2, null), startRestartGroup, 0);
            int quantity = iQuantityProduct.getQuantity();
            int maxQuantity = iQuantityProduct.getMaxQuantity();
            int minFirstStep = iQuantityProduct.getMinFirstStep();
            boolean z6 = !iQuantityProduct.getDisabled();
            startRestartGroup.startReplaceGroup(-304038205);
            int i8 = i6 & 7168;
            boolean changedInstance = (i8 == 2048) | startRestartGroup.changedInstance(iQuantityProduct);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue2 == companion4.getEmpty()) {
                rememberedValue2 = new Function1() { // from class: D2.Z
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit Content$lambda$10$lambda$9$lambda$6$lambda$5;
                        Content$lambda$10$lambda$9$lambda$6$lambda$5 = QuantityProductViewKt.Content$lambda$10$lambda$9$lambda$6$lambda$5(Function2.this, iQuantityProduct, ((Integer) obj).intValue());
                        return Content$lambda$10$lambda$9$lambda$6$lambda$5;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            Function1 function1 = (Function1) rememberedValue2;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(-304035613);
            boolean changedInstance2 = startRestartGroup.changedInstance(iQuantityProduct) | (i8 == 2048);
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (changedInstance2 || rememberedValue3 == companion4.getEmpty()) {
                rememberedValue3 = new Function1() { // from class: D2.a0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit Content$lambda$10$lambda$9$lambda$8$lambda$7;
                        Content$lambda$10$lambda$9$lambda$8$lambda$7 = QuantityProductViewKt.Content$lambda$10$lambda$9$lambda$8$lambda$7(Function2.this, iQuantityProduct, ((Integer) obj).intValue());
                        return Content$lambda$10$lambda$9$lambda$8$lambda$7;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            startRestartGroup.endReplaceGroup();
            composer2 = startRestartGroup;
            NumberSelectorKt.NumberSelector(null, quantity, minFirstStep, 0, maxQuantity, null, null, null, function1, (Function1) rememberedValue3, null, false, true, z6, false, composer2, 0, 384, 19689);
            composer2.endNode();
            composer2.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: D2.b0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit Content$lambda$11;
                    Content$lambda$11 = QuantityProductViewKt.Content$lambda$11(Modifier.this, iQuantityProduct, z5, function2, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return Content$lambda$11;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Content$lambda$10$lambda$9$lambda$3$lambda$2(SemanticsPropertyReceiver semantics) {
        Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit Content$lambda$10$lambda$9$lambda$6$lambda$5(Function2 function2, IQuantityProduct iQuantityProduct, int i5) {
        Intrinsics.checkNotNull(iQuantityProduct, "null cannot be cast to non-null type dk.molslinjen.domain.model.booking.product.Product");
        function2.invoke((Product) iQuantityProduct, Integer.valueOf(i5));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit Content$lambda$10$lambda$9$lambda$8$lambda$7(Function2 function2, IQuantityProduct iQuantityProduct, int i5) {
        Intrinsics.checkNotNull(iQuantityProduct, "null cannot be cast to non-null type dk.molslinjen.domain.model.booking.product.Product");
        function2.invoke((Product) iQuantityProduct, Integer.valueOf(i5));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Content$lambda$11(Modifier modifier, IQuantityProduct iQuantityProduct, boolean z5, Function2 function2, int i5, Composer composer, int i6) {
        Content(modifier, iQuantityProduct, z5, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    private static final void ProductInformationView(final IQuantityProduct iQuantityProduct, Composer composer, final int i5) {
        int i6;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(-1151837561);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(iQuantityProduct) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i6 & 3) == 2 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1151837561, i6, -1, "dk.molslinjen.ui.views.screens.booking.addons.ProductInformationView (QuantityProductView.kt:102)");
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), startRestartGroup, 0);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, companion);
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
            float f5 = 8;
            TextKt.m940Text4IGK_g(iQuantityProduct.getName(), PaddingKt.m315paddingqDBjuR0$default(companion, Dp.m2599constructorimpl(f5), Dp.m2599constructorimpl(f5), Dp.m2599constructorimpl(f5), 0.0f, 8, null), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getParagraphBold(), startRestartGroup, 0, 1572864, 65532);
            startRestartGroup.startReplaceGroup(-1479114643);
            if (iQuantityProduct instanceof ExtraProduct) {
                composer2 = startRestartGroup;
                TextKt.m940Text4IGK_g(((ExtraProduct) iQuantityProduct).getDescription(), PaddingKt.m315paddingqDBjuR0$default(companion, Dp.m2599constructorimpl(f5), Dp.m2599constructorimpl(f5), Dp.m2599constructorimpl(f5), 0.0f, 8, null), AppColor.INSTANCE.m3264getGrey10d7_KjU(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getSub(), composer2, 384, 1572864, 65528);
            } else {
                composer2 = startRestartGroup;
            }
            composer2.endReplaceGroup();
            composer2.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: D2.c0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit ProductInformationView$lambda$13;
                    ProductInformationView$lambda$13 = QuantityProductViewKt.ProductInformationView$lambda$13(IQuantityProduct.this, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return ProductInformationView$lambda$13;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ProductInformationView$lambda$13(IQuantityProduct iQuantityProduct, int i5, Composer composer, int i6) {
        ProductInformationView(iQuantityProduct, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    public static final void QuantityProductView(final IQuantityProduct product, final Function2<? super Product, ? super Integer, Unit> onQuantityChanged, Composer composer, final int i5) {
        int i6;
        Intrinsics.checkNotNullParameter(product, "product");
        Intrinsics.checkNotNullParameter(onQuantityChanged, "onQuantityChanged");
        Composer startRestartGroup = composer.startRestartGroup(990873540);
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
                ComposerKt.traceEventStart(990873540, i6, -1, "dk.molslinjen.ui.views.screens.booking.addons.QuantityProductView (QuantityProductView.kt:32)");
            }
            final boolean isRecommended = IQuantityProductExtensionsKt.isRecommended(product);
            startRestartGroup.startReplaceGroup(-204643532);
            final Modifier m103backgroundbw27NRU = isRecommended ? BackgroundKt.m103backgroundbw27NRU(Modifier.INSTANCE, AppColor.INSTANCE.m3281getWhite0d7_KjU(), MaterialTheme.INSTANCE.getShapes(startRestartGroup, MaterialTheme.$stable).getSmall()) : BackgroundKt.m104backgroundbw27NRU$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), AppColor.INSTANCE.m3281getWhite0d7_KjU(), null, 2, null);
            startRestartGroup.endReplaceGroup();
            ComposableLambda rememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(692275653, true, new Function2<Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.booking.addons.QuantityProductViewKt$QuantityProductView$content$1
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
                        ComposerKt.traceEventStart(692275653, i7, -1, "dk.molslinjen.ui.views.screens.booking.addons.QuantityProductView.<anonymous> (QuantityProductView.kt:42)");
                    }
                    QuantityProductViewKt.Content(Modifier.this, product, isRecommended, onQuantityChanged, composer2, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, startRestartGroup, 54);
            if (isRecommended) {
                startRestartGroup.startReplaceGroup(-2048539421);
                RecommendedFrameViewKt.RecommendedFrameView(null, rememberComposableLambda, startRestartGroup, 48, 1);
                startRestartGroup.endReplaceGroup();
            } else {
                startRestartGroup.startReplaceGroup(-2048479839);
                rememberComposableLambda.invoke(startRestartGroup, 6);
                startRestartGroup.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: D2.X
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit QuantityProductView$lambda$0;
                    QuantityProductView$lambda$0 = QuantityProductViewKt.QuantityProductView$lambda$0(IQuantityProduct.this, onQuantityChanged, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return QuantityProductView$lambda$0;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit QuantityProductView$lambda$0(IQuantityProduct iQuantityProduct, Function2 function2, int i5, Composer composer, int i6) {
        QuantityProductView(iQuantityProduct, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }
}
