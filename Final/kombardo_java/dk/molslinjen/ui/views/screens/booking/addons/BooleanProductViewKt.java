package dk.molslinjen.ui.views.screens.booking.addons;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.IntrinsicKt;
import androidx.compose.foundation.layout.IntrinsicSize;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.selection.ToggleableKt;
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
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Dp;
import dk.molslinjen.domain.extensions.domain.IQuantityProductExtensionsKt;
import dk.molslinjen.domain.model.booking.product.ExtraProduct;
import dk.molslinjen.domain.model.booking.product.IQuantityProduct;
import dk.molslinjen.domain.model.booking.product.Product;
import dk.molslinjen.ui.theme.AppColor;
import dk.molslinjen.ui.theme.TypographyKt;
import dk.molslinjen.ui.views.reusable.input.checkbox.SelectionControlKt;
import dk.molslinjen.ui.views.reusable.input.checkbox.SelectionControlStyle;
import dk.molslinjen.ui.views.screens.booking.addons.BooleanProductViewKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\u001a1\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0001\u001a\u00020\u00002\u0018\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0002H\u0007¢\u0006\u0004\b\u0007\u0010\b\u001aA\u0010\r\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u000b2\u0018\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0002H\u0003¢\u0006\u0004\b\r\u0010\u000e\u001a'\u0010\u000f\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u000bH\u0003¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Ldk/molslinjen/domain/model/booking/product/IQuantityProduct;", "product", "Lkotlin/Function2;", "Ldk/molslinjen/domain/model/booking/product/Product;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "onQuantityChanged", "BooleanProductView", "(Ldk/molslinjen/domain/model/booking/product/IQuantityProduct;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "Landroidx/compose/ui/Modifier;", "modifier", BuildConfig.FLAVOR, "isRecommended", "Content", "(Landroidx/compose/ui/Modifier;Ldk/molslinjen/domain/model/booking/product/IQuantityProduct;ZLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "ProductInformationView", "(Landroidx/compose/ui/Modifier;Ldk/molslinjen/domain/model/booking/product/IQuantityProduct;ZLandroidx/compose/runtime/Composer;I)V", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class BooleanProductViewKt {
    public static final void BooleanProductView(final IQuantityProduct product, final Function2<? super Product, ? super Integer, Unit> onQuantityChanged, Composer composer, final int i5) {
        int i6;
        final Modifier m455toggleableXHw0xAI$default;
        Intrinsics.checkNotNullParameter(product, "product");
        Intrinsics.checkNotNullParameter(onQuantityChanged, "onQuantityChanged");
        Composer startRestartGroup = composer.startRestartGroup(-550854282);
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
                ComposerKt.traceEventStart(-550854282, i6, -1, "dk.molslinjen.ui.views.screens.booking.addons.BooleanProductView (BooleanProductView.kt:35)");
            }
            final boolean isRecommended = IQuantityProductExtensionsKt.isRecommended(product);
            if (isRecommended) {
                startRestartGroup.startReplaceGroup(1089104222);
                m455toggleableXHw0xAI$default = BackgroundKt.m103backgroundbw27NRU(Modifier.INSTANCE, AppColor.INSTANCE.m3281getWhite0d7_KjU(), MaterialTheme.INSTANCE.getShapes(startRestartGroup, MaterialTheme.$stable).getSmall());
                startRestartGroup.endReplaceGroup();
            } else {
                startRestartGroup.startReplaceGroup(1089203825);
                Modifier m104backgroundbw27NRU$default = BackgroundKt.m104backgroundbw27NRU$default(Modifier.INSTANCE, AppColor.INSTANCE.m3281getWhite0d7_KjU(), null, 2, null);
                startRestartGroup.startReplaceGroup(1974801360);
                Object rememberedValue = startRestartGroup.rememberedValue();
                Composer.Companion companion = Composer.INSTANCE;
                if (rememberedValue == companion.getEmpty()) {
                    rememberedValue = new Function1() { // from class: D2.r
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            Unit BooleanProductView$lambda$1$lambda$0;
                            BooleanProductView$lambda$1$lambda$0 = BooleanProductViewKt.BooleanProductView$lambda$1$lambda$0((SemanticsPropertyReceiver) obj);
                            return BooleanProductView$lambda$1$lambda$0;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue);
                }
                startRestartGroup.endReplaceGroup();
                Modifier semantics = SemanticsModifierKt.semantics(m104backgroundbw27NRU$default, true, (Function1) rememberedValue);
                boolean z5 = product.getQuantity() > 0;
                boolean z6 = !product.getDisabled();
                startRestartGroup.startReplaceGroup(1974805691);
                boolean changedInstance = ((i6 & 112) == 32) | startRestartGroup.changedInstance(product);
                Object rememberedValue2 = startRestartGroup.rememberedValue();
                if (changedInstance || rememberedValue2 == companion.getEmpty()) {
                    rememberedValue2 = new Function1() { // from class: D2.s
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            Unit BooleanProductView$lambda$3$lambda$2;
                            BooleanProductView$lambda$3$lambda$2 = BooleanProductViewKt.BooleanProductView$lambda$3$lambda$2(Function2.this, product, ((Boolean) obj).booleanValue());
                            return BooleanProductView$lambda$3$lambda$2;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue2);
                }
                startRestartGroup.endReplaceGroup();
                m455toggleableXHw0xAI$default = ToggleableKt.m455toggleableXHw0xAI$default(semantics, z5, z6, null, (Function1) rememberedValue2, 4, null);
                startRestartGroup.endReplaceGroup();
            }
            ComposableLambda rememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-1212616777, true, new Function2<Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.booking.addons.BooleanProductViewKt$BooleanProductView$content$1
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
                        ComposerKt.traceEventStart(-1212616777, i7, -1, "dk.molslinjen.ui.views.screens.booking.addons.BooleanProductView.<anonymous> (BooleanProductView.kt:49)");
                    }
                    BooleanProductViewKt.Content(Modifier.this, product, isRecommended, onQuantityChanged, composer2, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, startRestartGroup, 54);
            if (isRecommended) {
                startRestartGroup.startReplaceGroup(1089769885);
                Modifier.Companion companion2 = Modifier.INSTANCE;
                boolean z7 = product.getQuantity() > 0;
                boolean z8 = !product.getDisabled();
                startRestartGroup.startReplaceGroup(1974821151);
                boolean changedInstance2 = startRestartGroup.changedInstance(product) | ((i6 & 112) == 32);
                Object rememberedValue3 = startRestartGroup.rememberedValue();
                if (changedInstance2 || rememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue3 = new Function1() { // from class: D2.t
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            Unit BooleanProductView$lambda$5$lambda$4;
                            BooleanProductView$lambda$5$lambda$4 = BooleanProductViewKt.BooleanProductView$lambda$5$lambda$4(Function2.this, product, ((Boolean) obj).booleanValue());
                            return BooleanProductView$lambda$5$lambda$4;
                        }
                    };
                    startRestartGroup.updateRememberedValue(rememberedValue3);
                }
                startRestartGroup.endReplaceGroup();
                RecommendedFrameViewKt.RecommendedFrameView(ToggleableKt.m455toggleableXHw0xAI$default(companion2, z7, z8, null, (Function1) rememberedValue3, 4, null), rememberComposableLambda, startRestartGroup, 48, 0);
                startRestartGroup.endReplaceGroup();
            } else {
                startRestartGroup.startReplaceGroup(1090076444);
                rememberComposableLambda.invoke(startRestartGroup, 6);
                startRestartGroup.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: D2.u
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit BooleanProductView$lambda$6;
                    BooleanProductView$lambda$6 = BooleanProductViewKt.BooleanProductView$lambda$6(IQuantityProduct.this, onQuantityChanged, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return BooleanProductView$lambda$6;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BooleanProductView$lambda$1$lambda$0(SemanticsPropertyReceiver semantics) {
        Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit BooleanProductView$lambda$3$lambda$2(Function2 function2, IQuantityProduct iQuantityProduct, boolean z5) {
        Intrinsics.checkNotNull(iQuantityProduct, "null cannot be cast to non-null type dk.molslinjen.domain.model.booking.product.Product");
        Product product = (Product) iQuantityProduct;
        function2.invoke(product, Integer.valueOf(product.getQuantity() == 0 ? 1 : 0));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit BooleanProductView$lambda$5$lambda$4(Function2 function2, IQuantityProduct iQuantityProduct, boolean z5) {
        Intrinsics.checkNotNull(iQuantityProduct, "null cannot be cast to non-null type dk.molslinjen.domain.model.booking.product.Product");
        Product product = (Product) iQuantityProduct;
        function2.invoke(product, Integer.valueOf(product.getQuantity() == 0 ? 1 : 0));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BooleanProductView$lambda$6(IQuantityProduct iQuantityProduct, Function2 function2, int i5, Composer composer, int i6) {
        BooleanProductView(iQuantityProduct, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void Content(final Modifier modifier, final IQuantityProduct iQuantityProduct, final boolean z5, final Function2<? super Product, ? super Integer, Unit> function2, Composer composer, final int i5) {
        int i6;
        int i7;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(1081820092);
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
                ComposerKt.traceEventStart(1081820092, i6, -1, "dk.molslinjen.ui.views.screens.booking.addons.Content (BooleanProductView.kt:76)");
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
            startRestartGroup.startReplaceGroup(-1033578553);
            if (z5) {
                RecommendedProductImageViewKt.RecommendedProductImageView(iQuantityProduct instanceof Product ? (Product) iQuantityProduct : null, startRestartGroup, 0);
                SpacerKt.Spacer(SizeKt.m325height3ABfNKs(Modifier.INSTANCE, Dp.m2599constructorimpl(f5)), startRestartGroup, 6);
            }
            startRestartGroup.endReplaceGroup();
            Modifier.Companion companion3 = Modifier.INSTANCE;
            Modifier height = IntrinsicKt.height(PaddingKt.m311padding3ABfNKs(companion3, Dp.m2599constructorimpl(f5)), IntrinsicSize.Min);
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(arrangement.getStart(), companion.getTop(), startRestartGroup, 0);
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, height);
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
            Alignment.Vertical centerVertically = z5 ? companion.getCenterVertically() : companion.getBottom();
            ProductInformationView(RowScope.weight$default(rowScopeInstance, companion3, 1.0f, false, 2, null), iQuantityProduct, z5, startRestartGroup, i6 & 1008);
            MeasurePolicy columnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(arrangement.getTop(), companion.getEnd(), startRestartGroup, 48);
            int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap3 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(startRestartGroup, companion3);
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
            startRestartGroup.startReplaceGroup(-1249750416);
            if (z5) {
                i7 = 0;
            } else {
                i7 = 0;
                ProductTagViewKt.ProductTagView(PaddingKt.m315paddingqDBjuR0$default(companion3, 0.0f, 0.0f, 0.0f, Dp.m2599constructorimpl(f5), 7, null), iQuantityProduct instanceof Product ? (Product) iQuantityProduct : null, startRestartGroup, 6, 0);
            }
            startRestartGroup.endReplaceGroup();
            Modifier fillMaxHeight$default = SizeKt.fillMaxHeight$default(companion3, 0.0f, 1, null);
            MeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(arrangement.getStart(), companion.getTop(), startRestartGroup, i7);
            int currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, i7);
            CompositionLocalMap currentCompositionLocalMap4 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier4 = ComposedModifierKt.materializeModifier(startRestartGroup, fillMaxHeight$default);
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
            Modifier align = rowScopeInstance.align(companion3, centerVertically);
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
            Modifier align2 = rowScopeInstance.align(PaddingKt.m315paddingqDBjuR0$default(companion3, Dp.m2599constructorimpl(f5), 0.0f, 0.0f, 0.0f, 14, null), centerVertically);
            startRestartGroup.startReplaceGroup(-83915153);
            Object rememberedValue = startRestartGroup.rememberedValue();
            Composer.Companion companion4 = Composer.INSTANCE;
            if (rememberedValue == companion4.getEmpty()) {
                rememberedValue = new Function1() { // from class: D2.v
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit Content$lambda$15$lambda$14$lambda$13$lambda$12$lambda$9$lambda$8;
                        Content$lambda$15$lambda$14$lambda$13$lambda$12$lambda$9$lambda$8 = BooleanProductViewKt.Content$lambda$15$lambda$14$lambda$13$lambda$12$lambda$9$lambda$8((SemanticsPropertyReceiver) obj);
                        return Content$lambda$15$lambda$14$lambda$13$lambda$12$lambda$9$lambda$8;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            Modifier clearAndSetSemantics = SemanticsModifierKt.clearAndSetSemantics(align2, (Function1) rememberedValue);
            boolean z6 = iQuantityProduct.getQuantity() > 0;
            SelectionControlStyle selectionControlStyle = SelectionControlStyle.Checkbox;
            boolean z7 = !iQuantityProduct.getDisabled();
            startRestartGroup.startReplaceGroup(-83911038);
            boolean changedInstance = startRestartGroup.changedInstance(iQuantityProduct) | ((i6 & 7168) == 2048);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue2 == companion4.getEmpty()) {
                rememberedValue2 = new Function1() { // from class: D2.w
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit Content$lambda$15$lambda$14$lambda$13$lambda$12$lambda$11$lambda$10;
                        Content$lambda$15$lambda$14$lambda$13$lambda$12$lambda$11$lambda$10 = BooleanProductViewKt.Content$lambda$15$lambda$14$lambda$13$lambda$12$lambda$11$lambda$10(Function2.this, iQuantityProduct, ((Boolean) obj).booleanValue());
                        return Content$lambda$15$lambda$14$lambda$13$lambda$12$lambda$11$lambda$10;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            startRestartGroup.endReplaceGroup();
            boolean z8 = z6;
            composer2 = startRestartGroup;
            SelectionControlKt.SelectionControl(clearAndSetSemantics, z8, (Function1) rememberedValue2, null, z7, null, selectionControlStyle, false, startRestartGroup, 1572864, 168);
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
            endRestartGroup.updateScope(new Function2() { // from class: D2.x
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit Content$lambda$16;
                    Content$lambda$16 = BooleanProductViewKt.Content$lambda$16(Modifier.this, iQuantityProduct, z5, function2, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return Content$lambda$16;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit Content$lambda$15$lambda$14$lambda$13$lambda$12$lambda$11$lambda$10(Function2 function2, IQuantityProduct iQuantityProduct, boolean z5) {
        Intrinsics.checkNotNull(iQuantityProduct, "null cannot be cast to non-null type dk.molslinjen.domain.model.booking.product.Product");
        Product product = (Product) iQuantityProduct;
        function2.invoke(product, Integer.valueOf(product.getQuantity() == 0 ? 1 : 0));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Content$lambda$15$lambda$14$lambda$13$lambda$12$lambda$9$lambda$8(SemanticsPropertyReceiver clearAndSetSemantics) {
        Intrinsics.checkNotNullParameter(clearAndSetSemantics, "$this$clearAndSetSemantics");
        SemanticsPropertiesKt.setContentDescription(clearAndSetSemantics, BuildConfig.FLAVOR);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Content$lambda$16(Modifier modifier, IQuantityProduct iQuantityProduct, boolean z5, Function2 function2, int i5, Composer composer, int i6) {
        Content(modifier, iQuantityProduct, z5, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    private static final void ProductInformationView(final Modifier modifier, final IQuantityProduct iQuantityProduct, final boolean z5, Composer composer, final int i5) {
        int i6;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(-512487405);
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
        if ((i6 & 147) == 146 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-512487405, i6, -1, "dk.molslinjen.ui.views.screens.booking.addons.ProductInformationView (BooleanProductView.kt:126)");
            }
            float f5 = 8;
            Modifier m315paddingqDBjuR0$default = PaddingKt.m315paddingqDBjuR0$default(modifier, 0.0f, Dp.m2599constructorimpl(f5), 0.0f, 0.0f, 13, null);
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), startRestartGroup, 0);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, m315paddingqDBjuR0$default);
            ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
            Function0<ComposeUiNode> constructor = companion.getConstructor();
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
            Updater.m1227setimpl(m1226constructorimpl, columnMeasurePolicy, companion.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion.getSetCompositeKeyHash();
            if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion.getSetModifier());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            composer2 = startRestartGroup;
            TextKt.m940Text4IGK_g(iQuantityProduct.getName(), null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getParagraphBold(), composer2, 0, 1572864, 65534);
            composer2.startReplaceGroup(-1479078177);
            if (iQuantityProduct instanceof ExtraProduct) {
                TextKt.m940Text4IGK_g(((ExtraProduct) iQuantityProduct).getDescription(), PaddingKt.m315paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, Dp.m2599constructorimpl(f5), 0.0f, z5 ? Dp.m2599constructorimpl(0) : Dp.m2599constructorimpl(f5), 5, null), AppColor.INSTANCE.m3264getGrey10d7_KjU(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getSub(), composer2, 384, 1572864, 65528);
            }
            composer2.endReplaceGroup();
            composer2.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: D2.y
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit ProductInformationView$lambda$18;
                    ProductInformationView$lambda$18 = BooleanProductViewKt.ProductInformationView$lambda$18(Modifier.this, iQuantityProduct, z5, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return ProductInformationView$lambda$18;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ProductInformationView$lambda$18(Modifier modifier, IQuantityProduct iQuantityProduct, boolean z5, int i5, Composer composer, int i6) {
        ProductInformationView(modifier, iQuantityProduct, z5, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }
}
