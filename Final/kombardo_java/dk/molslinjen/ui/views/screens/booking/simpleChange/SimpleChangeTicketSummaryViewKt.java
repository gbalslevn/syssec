package dk.molslinjen.ui.views.screens.booking.simpleChange;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.IntrinsicKt;
import androidx.compose.foundation.layout.IntrinsicSize;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.IconKt;
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
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.OnGloballyPositionedModifierKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntSize;
import dk.molslinjen.core.extensions.Accessibility;
import dk.molslinjen.domain.managers.checkout.PriceTotal;
import dk.molslinjen.domain.model.booking.product.ISummaryProduct;
import dk.molslinjen.domain.model.shared.Price;
import dk.molslinjen.domain.model.shared.PriceWithCurrency;
import dk.molslinjen.extensions.ModifierExtensionsKt;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.theme.AppColor;
import dk.molslinjen.ui.theme.TypographyKt;
import dk.molslinjen.ui.views.reusable.HorizontalDividerKt;
import dk.molslinjen.ui.views.screens.booking.simpleChange.SimpleChangeTicketSummaryViewKt;
import dk.molslinjen.ui.views.shared.components.PriceTextKt;
import dk.molslinjen.ui.views.shared.components.PriceViewType;
import dk.molslinjen.ui.views.shared.ticket.ticketSummary.TicketSummaryBackgroundViewKt;
import dk.molslinjen.ui.views.shared.ticket.ticketSummary.TicketSummaryFooterRowKt;
import dk.molslinjen.ui.views.shared.ticket.ticketSummary.TicketSummaryHeaderRowKt;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u001a%\u0010\u0006\u001a\u00020\u00052\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00002\u0006\u0010\u0004\u001a\u00020\u0003H\u0007¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u0017\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0001H\u0003¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {BuildConfig.FLAVOR, "Ldk/molslinjen/domain/model/booking/product/ISummaryProduct;", "products", "Ldk/molslinjen/domain/model/shared/PriceWithCurrency;", "totalPrice", BuildConfig.FLAVOR, "SimpleChangeTicketSummaryView", "(Ljava/util/List;Ldk/molslinjen/domain/model/shared/PriceWithCurrency;Landroidx/compose/runtime/Composer;I)V", "product", "ProductRow", "(Ldk/molslinjen/domain/model/booking/product/ISummaryProduct;Landroidx/compose/runtime/Composer;I)V", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class SimpleChangeTicketSummaryViewKt {
    private static final void ProductRow(final ISummaryProduct iSummaryProduct, Composer composer, final int i5) {
        int i6;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(-1412359694);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(iSummaryProduct) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i6 & 3) == 2 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1412359694, i6, -1, "dk.molslinjen.ui.views.screens.booking.simpleChange.ProductRow (SimpleChangeTicketSummaryView.kt:82)");
            }
            AnnotatedString.Builder builder = new AnnotatedString.Builder(0, 1, null);
            if (iSummaryProduct.showQuantity()) {
                int pushStyle = builder.pushStyle(new SpanStyle(0L, 0L, TypographyKt.getSubBold().getFontWeight(), null, null, null, null, 0L, null, null, null, 0L, null, null, null, null, 65531, null));
                try {
                    builder.append(iSummaryProduct.getQuantity() + " ");
                    Unit unit = Unit.INSTANCE;
                } finally {
                    builder.pop(pushStyle);
                }
            }
            builder.append(iSummaryProduct.getName());
            AnnotatedString annotatedString = builder.toAnnotatedString();
            Modifier.Companion companion = Modifier.INSTANCE;
            float f5 = 8;
            Modifier m311padding3ABfNKs = PaddingKt.m311padding3ABfNKs(SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null), Dp.m2599constructorimpl(f5));
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.INSTANCE.getCenterVertically(), startRestartGroup, 48);
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
            Updater.m1227setimpl(m1226constructorimpl, rowMeasurePolicy, companion2.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion2.getSetCompositeKeyHash();
            if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion2.getSetModifier());
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            IconKt.m857Iconww6aTOc(PainterResources_androidKt.painterResource(R.drawable.icon_checkmark_circle, startRestartGroup, 6), Accessibility.INSTANCE.getSkip(), SizeKt.m331size3ABfNKs(companion, Dp.m2599constructorimpl(16)), AppColor.INSTANCE.m3266getGrey30d7_KjU(), startRestartGroup, 3456, 0);
            composer2 = startRestartGroup;
            TextKt.m941TextIbK3jfQ(annotatedString, PaddingKt.m315paddingqDBjuR0$default(RowScope.weight$default(rowScopeInstance, companion, 1.0f, false, 2, null), Dp.m2599constructorimpl(f5), 0.0f, 0.0f, 0.0f, 14, null), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, TypographyKt.getSub(), composer2, 0, 12582912, 131068);
            PriceTextKt.m3557PriceText1y9Plug((Price) iSummaryProduct.sum(), PaddingKt.m315paddingqDBjuR0$default(companion, Dp.m2599constructorimpl(f5), 0.0f, 0.0f, 0.0f, 14, null), (PriceViewType) null, false, TypographyKt.getSubBold(), (TextAlign) null, 0, 0L, composer2, 24624, 236);
            composer2.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: d3.l
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit ProductRow$lambda$14;
                    ProductRow$lambda$14 = SimpleChangeTicketSummaryViewKt.ProductRow$lambda$14(ISummaryProduct.this, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return ProductRow$lambda$14;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ProductRow$lambda$14(ISummaryProduct iSummaryProduct, int i5, Composer composer, int i6) {
        ProductRow(iSummaryProduct, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    public static final void SimpleChangeTicketSummaryView(final List<? extends ISummaryProduct> products, final PriceWithCurrency totalPrice, Composer composer, final int i5) {
        int i6;
        Intrinsics.checkNotNullParameter(products, "products");
        Intrinsics.checkNotNullParameter(totalPrice, "totalPrice");
        Composer startRestartGroup = composer.startRestartGroup(1119551178);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(products) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changedInstance(totalPrice) ? 32 : 16;
        }
        if ((i6 & 19) == 18 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1119551178, i6, -1, "dk.molslinjen.ui.views.screens.booking.simpleChange.SimpleChangeTicketSummaryView (SimpleChangeTicketSummaryView.kt:43)");
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            Modifier height = IntrinsicKt.height(companion, IntrinsicSize.Max);
            Alignment.Companion companion2 = Alignment.INSTANCE;
            MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(companion2.getCenter(), false);
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
            Updater.m1227setimpl(m1226constructorimpl, maybeCachedBoxMeasurePolicy, companion3.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion3.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion3.getSetCompositeKeyHash();
            if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion3.getSetModifier());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            Object[] objArr = new Object[0];
            startRestartGroup.startReplaceGroup(1726959199);
            Object rememberedValue = startRestartGroup.rememberedValue();
            Composer.Companion companion4 = Composer.INSTANCE;
            if (rememberedValue == companion4.getEmpty()) {
                rememberedValue = new Function0() { // from class: d3.g
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        MutableState SimpleChangeTicketSummaryView$lambda$9$lambda$1$lambda$0;
                        SimpleChangeTicketSummaryView$lambda$9$lambda$1$lambda$0 = SimpleChangeTicketSummaryViewKt.SimpleChangeTicketSummaryView$lambda$9$lambda$1$lambda$0();
                        return SimpleChangeTicketSummaryView$lambda$9$lambda$1$lambda$0;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            final MutableState mutableState = (MutableState) RememberSaveableKt.rememberSaveable(objArr, null, null, (Function0) rememberedValue, startRestartGroup, 3072, 6);
            Object[] objArr2 = new Object[0];
            startRestartGroup.startReplaceGroup(1726961439);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (rememberedValue2 == companion4.getEmpty()) {
                rememberedValue2 = new Function0() { // from class: d3.h
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        MutableState SimpleChangeTicketSummaryView$lambda$9$lambda$3$lambda$2;
                        SimpleChangeTicketSummaryView$lambda$9$lambda$3$lambda$2 = SimpleChangeTicketSummaryViewKt.SimpleChangeTicketSummaryView$lambda$9$lambda$3$lambda$2();
                        return SimpleChangeTicketSummaryView$lambda$9$lambda$3$lambda$2;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            startRestartGroup.endReplaceGroup();
            final MutableState mutableState2 = (MutableState) RememberSaveableKt.rememberSaveable(objArr2, null, null, (Function0) rememberedValue2, startRestartGroup, 3072, 6);
            TicketSummaryBackgroundViewKt.m3563TicketSummaryBackgroundViewww6aTOc(ModifierExtensionsKt.defaultShadow$default(SizeKt.fillMaxHeight$default(companion, 0.0f, 1, null), null, 1, null), ((Number) mutableState.getValue()).intValue(), ((Number) mutableState2.getValue()).intValue(), 0L, startRestartGroup, 0, 8);
            Modifier m313paddingVpY3zN4$default = PaddingKt.m313paddingVpY3zN4$default(companion, Dp.m2599constructorimpl(16), 0.0f, 2, null);
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), companion2.getStart(), startRestartGroup, 0);
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, m313paddingVpY3zN4$default);
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
            Updater.m1227setimpl(m1226constructorimpl2, columnMeasurePolicy, companion3.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl2, currentCompositionLocalMap2, companion3.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = companion3.getSetCompositeKeyHash();
            if (m1226constructorimpl2.getInserting() || !Intrinsics.areEqual(m1226constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                m1226constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                m1226constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            Updater.m1227setimpl(m1226constructorimpl2, materializeModifier2, companion3.getSetModifier());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            startRestartGroup.startReplaceGroup(-1873153899);
            boolean changed = startRestartGroup.changed(mutableState);
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (changed || rememberedValue3 == companion4.getEmpty()) {
                rememberedValue3 = new Function1() { // from class: d3.i
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit SimpleChangeTicketSummaryView$lambda$9$lambda$8$lambda$5$lambda$4;
                        SimpleChangeTicketSummaryView$lambda$9$lambda$8$lambda$5$lambda$4 = SimpleChangeTicketSummaryViewKt.SimpleChangeTicketSummaryView$lambda$9$lambda$8$lambda$5$lambda$4(MutableState.this, (LayoutCoordinates) obj);
                        return SimpleChangeTicketSummaryView$lambda$9$lambda$8$lambda$5$lambda$4;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            startRestartGroup.endReplaceGroup();
            TicketSummaryHeaderRowKt.TicketSummaryHeaderRow(OnGloballyPositionedModifierKt.onGloballyPositioned(companion, (Function1) rememberedValue3), StringResources_androidKt.stringResource(R.string.simpleChange_summary_yourOrder, startRestartGroup, 6), null, startRestartGroup, 0, 4);
            float f5 = 2;
            float f6 = 8;
            HorizontalDividerKt.m3388HorizontalDividertZIQpXc(PaddingKt.m315paddingqDBjuR0$default(companion, 0.0f, 0.0f, 0.0f, Dp.m2599constructorimpl(f6), 7, null), 0L, 0.0f, Dp.m2597boximpl(Dp.m2599constructorimpl(f5)), startRestartGroup, 3078, 6);
            startRestartGroup.startReplaceGroup(-1873145834);
            Iterator<? extends ISummaryProduct> it = products.iterator();
            while (it.hasNext()) {
                ProductRow(it.next(), startRestartGroup, 0);
            }
            startRestartGroup.endReplaceGroup();
            float m2599constructorimpl = Dp.m2599constructorimpl(f5);
            Modifier.Companion companion5 = Modifier.INSTANCE;
            HorizontalDividerKt.m3388HorizontalDividertZIQpXc(PaddingKt.m315paddingqDBjuR0$default(companion5, 0.0f, Dp.m2599constructorimpl(f6), 0.0f, 0.0f, 13, null), 0L, 0.0f, Dp.m2597boximpl(m2599constructorimpl), startRestartGroup, 3078, 6);
            startRestartGroup.startReplaceGroup(-1873137356);
            boolean changed2 = startRestartGroup.changed(mutableState2);
            Object rememberedValue4 = startRestartGroup.rememberedValue();
            if (changed2 || rememberedValue4 == Composer.INSTANCE.getEmpty()) {
                rememberedValue4 = new Function1() { // from class: d3.j
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit SimpleChangeTicketSummaryView$lambda$9$lambda$8$lambda$7$lambda$6;
                        SimpleChangeTicketSummaryView$lambda$9$lambda$8$lambda$7$lambda$6 = SimpleChangeTicketSummaryViewKt.SimpleChangeTicketSummaryView$lambda$9$lambda$8$lambda$7$lambda$6(MutableState.this, (LayoutCoordinates) obj);
                        return SimpleChangeTicketSummaryView$lambda$9$lambda$8$lambda$7$lambda$6;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue4);
            }
            startRestartGroup.endReplaceGroup();
            TicketSummaryFooterRowKt.TicketSummaryFooterRow(OnGloballyPositionedModifierKt.onGloballyPositioned(companion5, (Function1) rememberedValue4), new PriceTotal(totalPrice), null, null, null, null, null, startRestartGroup, 196608, 92);
            startRestartGroup.endNode();
            startRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: d3.k
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit SimpleChangeTicketSummaryView$lambda$10;
                    SimpleChangeTicketSummaryView$lambda$10 = SimpleChangeTicketSummaryViewKt.SimpleChangeTicketSummaryView$lambda$10(products, totalPrice, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return SimpleChangeTicketSummaryView$lambda$10;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SimpleChangeTicketSummaryView$lambda$10(List list, PriceWithCurrency priceWithCurrency, int i5, Composer composer, int i6) {
        SimpleChangeTicketSummaryView(list, priceWithCurrency, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MutableState SimpleChangeTicketSummaryView$lambda$9$lambda$1$lambda$0() {
        MutableState mutableStateOf$default;
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(0, null, 2, null);
        return mutableStateOf$default;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MutableState SimpleChangeTicketSummaryView$lambda$9$lambda$3$lambda$2() {
        MutableState mutableStateOf$default;
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(0, null, 2, null);
        return mutableStateOf$default;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SimpleChangeTicketSummaryView$lambda$9$lambda$8$lambda$5$lambda$4(MutableState mutableState, LayoutCoordinates it) {
        Intrinsics.checkNotNullParameter(it, "it");
        mutableState.setValue(Integer.valueOf(IntSize.m2660getHeightimpl(it.mo1948getSizeYbymL2g())));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SimpleChangeTicketSummaryView$lambda$9$lambda$8$lambda$7$lambda$6(MutableState mutableState, LayoutCoordinates it) {
        Intrinsics.checkNotNullParameter(it, "it");
        mutableState.setValue(Integer.valueOf(IntSize.m2660getHeightimpl(it.mo1948getSizeYbymL2g())));
        return Unit.INSTANCE;
    }
}
