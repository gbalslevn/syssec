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
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Dp;
import dk.molslinjen.domain.model.booking.DepartureDirection;
import dk.molslinjen.domain.model.booking.product.ExtraProduct;
import dk.molslinjen.domain.model.booking.product.IQuantityProduct;
import dk.molslinjen.domain.model.booking.product.Product;
import dk.molslinjen.domain.model.shared.Price;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.theme.AppColor;
import dk.molslinjen.ui.theme.TypographyKt;
import dk.molslinjen.ui.views.reusable.input.checkbox.LabeledSelectionControlKt;
import dk.molslinjen.ui.views.reusable.input.checkbox.SelectionControlStyle;
import dk.molslinjen.ui.views.screens.booking.addons.BidirectionalBooleanProductViewKt;
import dk.molslinjen.ui.views.shared.components.PriceTextKt;
import dk.molslinjen.ui.views.shared.components.PriceViewType;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aC\u0010\t\u001a\u00020\u00072\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u00002\u001e\u0010\b\u001a\u001a\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0003H\u0007¢\u0006\u0004\b\t\u0010\n\u001a;\u0010\u000f\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u00002\u0018\u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u000eH\u0003¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Ldk/molslinjen/domain/model/booking/product/IQuantityProduct;", "outboundProduct", "returnProduct", "Lkotlin/Function3;", "Ldk/molslinjen/domain/model/booking/DepartureDirection;", "Ldk/molslinjen/domain/model/booking/product/Product;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "onQuantityChanged", "BidirectionalBooleanProductView", "(Ldk/molslinjen/domain/model/booking/product/IQuantityProduct;Ldk/molslinjen/domain/model/booking/product/IQuantityProduct;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;I)V", BuildConfig.FLAVOR, "label", "product", "Lkotlin/Function2;", "DirectionRow", "(Ljava/lang/String;Ldk/molslinjen/domain/model/booking/product/IQuantityProduct;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class BidirectionalBooleanProductViewKt {
    public static final void BidirectionalBooleanProductView(final IQuantityProduct iQuantityProduct, final IQuantityProduct iQuantityProduct2, final Function3<? super DepartureDirection, ? super Product, ? super Integer, Unit> onQuantityChanged, Composer composer, final int i5) {
        int i6;
        IQuantityProduct iQuantityProduct3;
        Composer composer2;
        Intrinsics.checkNotNullParameter(onQuantityChanged, "onQuantityChanged");
        Composer startRestartGroup = composer.startRestartGroup(833308160);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(iQuantityProduct) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changedInstance(iQuantityProduct2) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i6 |= startRestartGroup.changedInstance(onQuantityChanged) ? 256 : 128;
        }
        int i7 = i6;
        if ((i7 & 147) == 146 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(833308160, i7, -1, "dk.molslinjen.ui.views.screens.booking.addons.BidirectionalBooleanProductView (BidirectionalBooleanProductView.kt:27)");
            }
            if (iQuantityProduct != null) {
                iQuantityProduct3 = iQuantityProduct;
            } else {
                if (iQuantityProduct2 == null) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
                    if (endRestartGroup != null) {
                        endRestartGroup.updateScope(new Function2() { // from class: D2.l
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                Unit BidirectionalBooleanProductView$lambda$0;
                                BidirectionalBooleanProductView$lambda$0 = BidirectionalBooleanProductViewKt.BidirectionalBooleanProductView$lambda$0(IQuantityProduct.this, iQuantityProduct2, onQuantityChanged, i5, (Composer) obj, ((Integer) obj2).intValue());
                                return BidirectionalBooleanProductView$lambda$0;
                            }
                        });
                        return;
                    }
                    return;
                }
                iQuantityProduct3 = iQuantityProduct2;
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            AppColor appColor = AppColor.INSTANCE;
            float f5 = 16;
            Modifier m311padding3ABfNKs = PaddingKt.m311padding3ABfNKs(BackgroundKt.m104backgroundbw27NRU$default(companion, appColor.m3281getWhite0d7_KjU(), null, 2, null), Dp.m2599constructorimpl(f5));
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), startRestartGroup, 0);
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
            TextKt.m940Text4IGK_g(iQuantityProduct3.getName(), null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getParagraphBold(), startRestartGroup, 0, 1572864, 65534);
            startRestartGroup.startReplaceGroup(2104655);
            if (iQuantityProduct3 instanceof ExtraProduct) {
                float f6 = 8;
                composer2 = startRestartGroup;
                TextKt.m940Text4IGK_g(((ExtraProduct) iQuantityProduct3).getDescription(), PaddingKt.m315paddingqDBjuR0$default(companion, 0.0f, Dp.m2599constructorimpl(f6), Dp.m2599constructorimpl(f6), Dp.m2599constructorimpl(f5), 1, null), appColor.m3264getGrey10d7_KjU(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getSub(), composer2, 384, 1572864, 65528);
            } else {
                composer2 = startRestartGroup;
            }
            composer2.endReplaceGroup();
            String stringResource = StringResources_androidKt.stringResource(R.string.bookingSummary_addToOutbound, composer2, 6);
            composer2.startReplaceGroup(2119171);
            int i8 = i7 & 896;
            boolean z5 = i8 == 256;
            Object rememberedValue = composer2.rememberedValue();
            if (z5 || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function2() { // from class: D2.m
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        Unit BidirectionalBooleanProductView$lambda$5$lambda$2$lambda$1;
                        BidirectionalBooleanProductView$lambda$5$lambda$2$lambda$1 = BidirectionalBooleanProductViewKt.BidirectionalBooleanProductView$lambda$5$lambda$2$lambda$1(Function3.this, (Product) obj, ((Integer) obj2).intValue());
                        return BidirectionalBooleanProductView$lambda$5$lambda$2$lambda$1;
                    }
                };
                composer2.updateRememberedValue(rememberedValue);
            }
            composer2.endReplaceGroup();
            DirectionRow(stringResource, iQuantityProduct, (Function2) rememberedValue, composer2, (i7 << 3) & 112);
            SpacerKt.Spacer(SizeKt.m325height3ABfNKs(companion, Dp.m2599constructorimpl(8)), composer2, 6);
            String stringResource2 = StringResources_androidKt.stringResource(R.string.bookingSummary_addToReturn, composer2, 6);
            composer2.startReplaceGroup(2130113);
            boolean z6 = i8 == 256;
            Object rememberedValue2 = composer2.rememberedValue();
            if (z6 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                rememberedValue2 = new Function2() { // from class: D2.n
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        Unit BidirectionalBooleanProductView$lambda$5$lambda$4$lambda$3;
                        BidirectionalBooleanProductView$lambda$5$lambda$4$lambda$3 = BidirectionalBooleanProductViewKt.BidirectionalBooleanProductView$lambda$5$lambda$4$lambda$3(Function3.this, (Product) obj, ((Integer) obj2).intValue());
                        return BidirectionalBooleanProductView$lambda$5$lambda$4$lambda$3;
                    }
                };
                composer2.updateRememberedValue(rememberedValue2);
            }
            composer2.endReplaceGroup();
            DirectionRow(stringResource2, iQuantityProduct2, (Function2) rememberedValue2, composer2, i7 & 112);
            composer2.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup2 = composer2.endRestartGroup();
        if (endRestartGroup2 != null) {
            endRestartGroup2.updateScope(new Function2() { // from class: D2.o
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit BidirectionalBooleanProductView$lambda$6;
                    BidirectionalBooleanProductView$lambda$6 = BidirectionalBooleanProductViewKt.BidirectionalBooleanProductView$lambda$6(IQuantityProduct.this, iQuantityProduct2, onQuantityChanged, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return BidirectionalBooleanProductView$lambda$6;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BidirectionalBooleanProductView$lambda$0(IQuantityProduct iQuantityProduct, IQuantityProduct iQuantityProduct2, Function3 function3, int i5, Composer composer, int i6) {
        BidirectionalBooleanProductView(iQuantityProduct, iQuantityProduct2, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BidirectionalBooleanProductView$lambda$5$lambda$2$lambda$1(Function3 function3, Product product, int i5) {
        Intrinsics.checkNotNullParameter(product, "product");
        function3.invoke(DepartureDirection.Outbound, product, Integer.valueOf(i5));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BidirectionalBooleanProductView$lambda$5$lambda$4$lambda$3(Function3 function3, Product product, int i5) {
        Intrinsics.checkNotNullParameter(product, "product");
        function3.invoke(DepartureDirection.Return, product, Integer.valueOf(i5));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BidirectionalBooleanProductView$lambda$6(IQuantityProduct iQuantityProduct, IQuantityProduct iQuantityProduct2, Function3 function3, int i5, Composer composer, int i6) {
        BidirectionalBooleanProductView(iQuantityProduct, iQuantityProduct2, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    private static final void DirectionRow(final String str, final IQuantityProduct iQuantityProduct, final Function2<? super Product, ? super Integer, Unit> function2, Composer composer, final int i5) {
        int i6;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(-1511888945);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changed(str) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changedInstance(iQuantityProduct) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i6 |= startRestartGroup.changedInstance(function2) ? 256 : 128;
        }
        if ((i6 & 147) == 146 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1511888945, i6, -1, "dk.molslinjen.ui.views.screens.booking.addons.DirectionRow (BidirectionalBooleanProductView.kt:67)");
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            float f5 = 8;
            Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(PaddingKt.m315paddingqDBjuR0$default(companion, 0.0f, Dp.m2599constructorimpl(f5), 0.0f, 0.0f, 13, null), 0.0f, 1, null);
            Arrangement arrangement = Arrangement.INSTANCE;
            Arrangement.Horizontal start = arrangement.getStart();
            Alignment.Companion companion2 = Alignment.INSTANCE;
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(start, companion2.getTop(), startRestartGroup, 0);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, fillMaxWidth$default);
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
            Modifier align = rowScopeInstance.align(PaddingKt.m315paddingqDBjuR0$default(companion, Dp.m2599constructorimpl(f5), 0.0f, 0.0f, 0.0f, 14, null), companion2.getBottom());
            boolean z5 = (iQuantityProduct != null ? iQuantityProduct.getQuantity() : 0) > 0;
            SelectionControlStyle selectionControlStyle = SelectionControlStyle.Checkbox;
            boolean z6 = (iQuantityProduct == null || iQuantityProduct.getDisabled()) ? false : true;
            startRestartGroup.startReplaceGroup(-238927415);
            boolean changedInstance = startRestartGroup.changedInstance(iQuantityProduct) | ((i6 & 896) == 256);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function1() { // from class: D2.p
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit DirectionRow$lambda$10$lambda$8$lambda$7;
                        DirectionRow$lambda$10$lambda$8$lambda$7 = BidirectionalBooleanProductViewKt.DirectionRow$lambda$10$lambda$8$lambda$7(Function2.this, iQuantityProduct, ((Boolean) obj).booleanValue());
                        return DirectionRow$lambda$10$lambda$8$lambda$7;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            composer2 = startRestartGroup;
            LabeledSelectionControlKt.LabeledSelectionControl(align, str, z5, (Function1) rememberedValue, null, z6, null, selectionControlStyle, false, startRestartGroup, ((i6 << 3) & 112) | 12582912, 336);
            composer2.startReplaceGroup(-238919985);
            if (iQuantityProduct != null) {
                if (iQuantityProduct.getDisabled()) {
                    composer2.startReplaceGroup(1183443920);
                    TextKt.m940Text4IGK_g(StringResources_androidKt.stringResource(R.string.bookingSummary_isIncluded, composer2, 6), null, AppColor.INSTANCE.m3264getGrey10d7_KjU(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getSubSmall(), composer2, 384, 1572864, 65530);
                    composer2.endReplaceGroup();
                } else {
                    composer2.startReplaceGroup(1183681907);
                    MeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(arrangement.getStart(), companion2.getTop(), composer2, 0);
                    int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                    CompositionLocalMap currentCompositionLocalMap2 = composer2.getCurrentCompositionLocalMap();
                    Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(composer2, companion);
                    Function0<ComposeUiNode> constructor2 = companion3.getConstructor();
                    if (composer2.getApplier() == null) {
                        ComposablesKt.invalidApplier();
                    }
                    composer2.startReusableNode();
                    if (composer2.getInserting()) {
                        composer2.createNode(constructor2);
                    } else {
                        composer2.useNode();
                    }
                    Composer m1226constructorimpl2 = Updater.m1226constructorimpl(composer2);
                    Updater.m1227setimpl(m1226constructorimpl2, rowMeasurePolicy2, companion3.getSetMeasurePolicy());
                    Updater.m1227setimpl(m1226constructorimpl2, currentCompositionLocalMap2, companion3.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = companion3.getSetCompositeKeyHash();
                    if (m1226constructorimpl2.getInserting() || !Intrinsics.areEqual(m1226constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                        m1226constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                        m1226constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                    }
                    Updater.m1227setimpl(m1226constructorimpl2, materializeModifier2, companion3.getSetModifier());
                    SpacerKt.Spacer(RowScope.weight$default(rowScopeInstance, companion, 1.0f, false, 2, null), composer2, 0);
                    PriceTextKt.m3557PriceText1y9Plug((Price) iQuantityProduct.getPrice(), rowScopeInstance.alignByBaseline(companion), PriceViewType.PriceOnly, false, TypographyKt.getParagraph(), (TextAlign) null, 0, 0L, composer2, 24960, 232);
                    PriceTextKt.m3557PriceText1y9Plug((Price) iQuantityProduct.getPrice(), PaddingKt.m315paddingqDBjuR0$default(rowScopeInstance.alignByBaseline(companion), Dp.m2599constructorimpl(2), 0.0f, 0.0f, 0.0f, 14, null), PriceViewType.CurrencyOnly, false, TypographyKt.getSubSmall(), (TextAlign) null, 0, 0L, composer2, 24960, 232);
                    composer2.endNode();
                    composer2.endReplaceGroup();
                }
            }
            composer2.endReplaceGroup();
            composer2.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: D2.q
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit DirectionRow$lambda$11;
                    DirectionRow$lambda$11 = BidirectionalBooleanProductViewKt.DirectionRow$lambda$11(str, iQuantityProduct, function2, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return DirectionRow$lambda$11;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit DirectionRow$lambda$10$lambda$8$lambda$7(Function2 function2, IQuantityProduct iQuantityProduct, boolean z5) {
        Intrinsics.checkNotNull(iQuantityProduct, "null cannot be cast to non-null type dk.molslinjen.domain.model.booking.product.Product");
        Product product = (Product) iQuantityProduct;
        function2.invoke(product, Integer.valueOf(product.getQuantity() == 0 ? 1 : 0));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DirectionRow$lambda$11(String str, IQuantityProduct iQuantityProduct, Function2 function2, int i5, Composer composer, int i6) {
        DirectionRow(str, iQuantityProduct, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }
}
