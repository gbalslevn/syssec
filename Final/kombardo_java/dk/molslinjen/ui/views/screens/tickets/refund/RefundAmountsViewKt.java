package dk.molslinjen.ui.views.screens.tickets.refund;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
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
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Dp;
import dk.molslinjen.domain.model.shared.Price;
import dk.molslinjen.domain.model.shared.PriceWithCurrency;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.theme.AppColor;
import dk.molslinjen.ui.theme.TypographyKt;
import dk.molslinjen.ui.views.screens.tickets.refund.RefundAmountsViewKt;
import dk.molslinjen.ui.views.shared.components.PriceTextKt;
import dk.molslinjen.ui.views.shared.components.PriceViewType;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a+\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0001\u001a\u00020\u00002\b\u0010\u0002\u001a\u0004\u0018\u00010\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0003H\u0007¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Ldk/molslinjen/domain/model/shared/PriceWithCurrency;", "refundAmount", "handlingFee", BuildConfig.FLAVOR, "darkBackground", BuildConfig.FLAVOR, "RefundAmountsView", "(Ldk/molslinjen/domain/model/shared/PriceWithCurrency;Ldk/molslinjen/domain/model/shared/PriceWithCurrency;ZLandroidx/compose/runtime/Composer;II)V", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class RefundAmountsViewKt {
    /* JADX WARN: Removed duplicated region for block: B:18:0x036a  */
    /* JADX WARN: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0209  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0211  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x035f  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x034e  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x020e  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x007f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void RefundAmountsView(final PriceWithCurrency refundAmount, final PriceWithCurrency priceWithCurrency, boolean z5, Composer composer, final int i5, final int i6) {
        int i7;
        final boolean z6;
        int currentCompositeKeyHash;
        Composer m1226constructorimpl;
        int currentCompositeKeyHash2;
        Composer m1226constructorimpl2;
        Composer composer2;
        ScopeUpdateScope endRestartGroup;
        Intrinsics.checkNotNullParameter(refundAmount, "refundAmount");
        Composer startRestartGroup = composer.startRestartGroup(-777997616);
        int currentMarker = startRestartGroup.getCurrentMarker();
        if ((i6 & 1) != 0) {
            i7 = i5 | 6;
        } else if ((i5 & 6) == 0) {
            i7 = (startRestartGroup.changedInstance(refundAmount) ? 4 : 2) | i5;
        } else {
            i7 = i5;
        }
        if ((i6 & 2) != 0) {
            i7 |= 48;
        } else if ((i5 & 48) == 0) {
            i7 |= startRestartGroup.changedInstance(priceWithCurrency) ? 32 : 16;
        }
        int i8 = i6 & 4;
        if (i8 != 0) {
            i7 |= 384;
        } else if ((i5 & 384) == 0) {
            z6 = z5;
            i7 |= startRestartGroup.changed(z6) ? 256 : 128;
            if ((i7 & 147) == 146 || !startRestartGroup.getSkipping()) {
                boolean z7 = i8 == 0 ? false : z6;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-777997616, i7, -1, "dk.molslinjen.ui.views.screens.tickets.refund.RefundAmountsView (RefundAmountsView.kt:15)");
                }
                Modifier.Companion companion = Modifier.INSTANCE;
                Arrangement arrangement = Arrangement.INSTANCE;
                Arrangement.Vertical top = arrangement.getTop();
                Alignment.Companion companion2 = Alignment.INSTANCE;
                MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(top, companion2.getStart(), startRestartGroup, 0);
                currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, companion);
                ComposeUiNode.Companion companion3 = ComposeUiNode.INSTANCE;
                Function0<ComposeUiNode> constructor = companion3.getConstructor();
                if (startRestartGroup.getApplier() == null) {
                    ComposablesKt.invalidApplier();
                }
                startRestartGroup.startReusableNode();
                if (startRestartGroup.getInserting()) {
                    startRestartGroup.useNode();
                } else {
                    startRestartGroup.createNode(constructor);
                }
                m1226constructorimpl = Updater.m1226constructorimpl(startRestartGroup);
                Updater.m1227setimpl(m1226constructorimpl, columnMeasurePolicy, companion3.getSetMeasurePolicy());
                Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion3.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion3.getSetCompositeKeyHash();
                if (!m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                    m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion3.getSetModifier());
                ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                startRestartGroup.startReplaceGroup(-205776591);
                Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null);
                MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(arrangement.getStart(), companion2.getTop(), startRestartGroup, 0);
                currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, fillMaxWidth$default);
                Function0<ComposeUiNode> constructor2 = companion3.getConstructor();
                if (startRestartGroup.getApplier() == null) {
                    ComposablesKt.invalidApplier();
                }
                startRestartGroup.startReusableNode();
                if (startRestartGroup.getInserting()) {
                    startRestartGroup.useNode();
                } else {
                    startRestartGroup.createNode(constructor2);
                }
                m1226constructorimpl2 = Updater.m1226constructorimpl(startRestartGroup);
                Updater.m1227setimpl(m1226constructorimpl2, rowMeasurePolicy, companion3.getSetMeasurePolicy());
                Updater.m1227setimpl(m1226constructorimpl2, currentCompositionLocalMap2, companion3.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = companion3.getSetCompositeKeyHash();
                if (!m1226constructorimpl2.getInserting() || !Intrinsics.areEqual(m1226constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                    m1226constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                    m1226constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                }
                Updater.m1227setimpl(m1226constructorimpl2, materializeModifier2, companion3.getSetModifier());
                RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                TextKt.m940Text4IGK_g(StringResources_androidKt.stringResource(R.string.refund_amountText, startRestartGroup, 6), null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getParagraph(), startRestartGroup, 0, 1572864, 65534);
                SpacerKt.Spacer(RowScope.weight$default(rowScopeInstance, companion, 1.0f, false, 2, null), startRestartGroup, 0);
                PriceTextKt.m3557PriceText1y9Plug((Price) refundAmount, (Modifier) null, (PriceViewType) null, false, TypographyKt.getParagraphBold(), (TextAlign) null, 0, 0L, startRestartGroup, (i7 & 14) | 24576, 238);
                startRestartGroup.endNode();
                startRestartGroup.startReplaceGroup(686109959);
                if ((priceWithCurrency == null ? priceWithCurrency.getValue() : 0) <= 0) {
                    SpacerKt.Spacer(SizeKt.m325height3ABfNKs(companion, Dp.m2599constructorimpl(4)), startRestartGroup, 6);
                    Modifier fillMaxWidth$default2 = SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null);
                    MeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(arrangement.getStart(), companion2.getTop(), startRestartGroup, 0);
                    int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap3 = startRestartGroup.getCurrentCompositionLocalMap();
                    Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(startRestartGroup, fillMaxWidth$default2);
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
                    Updater.m1227setimpl(m1226constructorimpl3, rowMeasurePolicy2, companion3.getSetMeasurePolicy());
                    Updater.m1227setimpl(m1226constructorimpl3, currentCompositionLocalMap3, companion3.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = companion3.getSetCompositeKeyHash();
                    if (m1226constructorimpl3.getInserting() || !Intrinsics.areEqual(m1226constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                        m1226constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                        m1226constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                    }
                    Updater.m1227setimpl(m1226constructorimpl3, materializeModifier3, companion3.getSetModifier());
                    startRestartGroup.startReplaceGroup(-777350411);
                    String stringResource = StringResources_androidKt.stringResource(R.string.refund_handingFee, startRestartGroup, 6);
                    TextStyle sub = TypographyKt.getSub();
                    AppColor appColor = AppColor.INSTANCE;
                    TextKt.m940Text4IGK_g(stringResource, null, z7 ? appColor.m3253getBrandBlack10d7_KjU() : appColor.m3264getGrey10d7_KjU(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, sub, startRestartGroup, 0, 1572864, 65530);
                    SpacerKt.Spacer(RowScope.weight$default(rowScopeInstance, companion, 1.0f, false, 2, null), startRestartGroup, 0);
                    if (priceWithCurrency == null) {
                        startRestartGroup.endToMarker(currentMarker);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        ScopeUpdateScope endRestartGroup2 = startRestartGroup.endRestartGroup();
                        if (endRestartGroup2 != null) {
                            final boolean z8 = z7;
                            endRestartGroup2.updateScope(new Function2() { // from class: u4.a
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    Unit RefundAmountsView$lambda$3$lambda$2$lambda$1;
                                    RefundAmountsView$lambda$3$lambda$2$lambda$1 = RefundAmountsViewKt.RefundAmountsView$lambda$3$lambda$2$lambda$1(PriceWithCurrency.this, priceWithCurrency, z8, i5, i6, (Composer) obj, ((Integer) obj2).intValue());
                                    return RefundAmountsView$lambda$3$lambda$2$lambda$1;
                                }
                            });
                            return;
                        }
                        return;
                    }
                    TextStyle subBold = TypographyKt.getSubBold();
                    AppColor appColor2 = AppColor.INSTANCE;
                    composer2 = startRestartGroup;
                    PriceTextKt.m3557PriceText1y9Plug((Price) priceWithCurrency, (Modifier) null, (PriceViewType) null, false, subBold, (TextAlign) null, 0, z7 ? appColor2.m3253getBrandBlack10d7_KjU() : appColor2.m3264getGrey10d7_KjU(), startRestartGroup, 24576, 110);
                    composer2.endReplaceGroup();
                    composer2.endNode();
                } else {
                    composer2 = startRestartGroup;
                }
                composer2.endReplaceGroup();
                composer2.endReplaceGroup();
                composer2.endNode();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z6 = z7;
            } else {
                startRestartGroup.skipToGroupEnd();
                composer2 = startRestartGroup;
            }
            endRestartGroup = composer2.endRestartGroup();
            if (endRestartGroup == null) {
                endRestartGroup.updateScope(new Function2() { // from class: u4.b
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        Unit RefundAmountsView$lambda$4;
                        RefundAmountsView$lambda$4 = RefundAmountsViewKt.RefundAmountsView$lambda$4(PriceWithCurrency.this, priceWithCurrency, z6, i5, i6, (Composer) obj, ((Integer) obj2).intValue());
                        return RefundAmountsView$lambda$4;
                    }
                });
                return;
            }
            return;
        }
        z6 = z5;
        if ((i7 & 147) == 146) {
        }
        if (i8 == 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        Modifier.Companion companion4 = Modifier.INSTANCE;
        Arrangement arrangement2 = Arrangement.INSTANCE;
        Arrangement.Vertical top2 = arrangement2.getTop();
        Alignment.Companion companion22 = Alignment.INSTANCE;
        MeasurePolicy columnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(top2, companion22.getStart(), startRestartGroup, 0);
        currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
        CompositionLocalMap currentCompositionLocalMap4 = startRestartGroup.getCurrentCompositionLocalMap();
        Modifier materializeModifier4 = ComposedModifierKt.materializeModifier(startRestartGroup, companion4);
        ComposeUiNode.Companion companion32 = ComposeUiNode.INSTANCE;
        Function0<ComposeUiNode> constructor4 = companion32.getConstructor();
        if (startRestartGroup.getApplier() == null) {
        }
        startRestartGroup.startReusableNode();
        if (startRestartGroup.getInserting()) {
        }
        m1226constructorimpl = Updater.m1226constructorimpl(startRestartGroup);
        Updater.m1227setimpl(m1226constructorimpl, columnMeasurePolicy2, companion32.getSetMeasurePolicy());
        Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap4, companion32.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash4 = companion32.getSetCompositeKeyHash();
        if (!m1226constructorimpl.getInserting()) {
        }
        m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
        m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash4);
        Updater.m1227setimpl(m1226constructorimpl, materializeModifier4, companion32.getSetModifier());
        ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
        startRestartGroup.startReplaceGroup(-205776591);
        Modifier fillMaxWidth$default3 = SizeKt.fillMaxWidth$default(companion4, 0.0f, 1, null);
        MeasurePolicy rowMeasurePolicy3 = RowKt.rowMeasurePolicy(arrangement2.getStart(), companion22.getTop(), startRestartGroup, 0);
        currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
        CompositionLocalMap currentCompositionLocalMap22 = startRestartGroup.getCurrentCompositionLocalMap();
        Modifier materializeModifier22 = ComposedModifierKt.materializeModifier(startRestartGroup, fillMaxWidth$default3);
        Function0<ComposeUiNode> constructor22 = companion32.getConstructor();
        if (startRestartGroup.getApplier() == null) {
        }
        startRestartGroup.startReusableNode();
        if (startRestartGroup.getInserting()) {
        }
        m1226constructorimpl2 = Updater.m1226constructorimpl(startRestartGroup);
        Updater.m1227setimpl(m1226constructorimpl2, rowMeasurePolicy3, companion32.getSetMeasurePolicy());
        Updater.m1227setimpl(m1226constructorimpl2, currentCompositionLocalMap22, companion32.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash22 = companion32.getSetCompositeKeyHash();
        if (!m1226constructorimpl2.getInserting()) {
        }
        m1226constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
        m1226constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash22);
        Updater.m1227setimpl(m1226constructorimpl2, materializeModifier22, companion32.getSetModifier());
        RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
        TextKt.m940Text4IGK_g(StringResources_androidKt.stringResource(R.string.refund_amountText, startRestartGroup, 6), null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getParagraph(), startRestartGroup, 0, 1572864, 65534);
        SpacerKt.Spacer(RowScope.weight$default(rowScopeInstance2, companion4, 1.0f, false, 2, null), startRestartGroup, 0);
        PriceTextKt.m3557PriceText1y9Plug((Price) refundAmount, (Modifier) null, (PriceViewType) null, false, TypographyKt.getParagraphBold(), (TextAlign) null, 0, 0L, startRestartGroup, (i7 & 14) | 24576, 238);
        startRestartGroup.endNode();
        startRestartGroup.startReplaceGroup(686109959);
        if ((priceWithCurrency == null ? priceWithCurrency.getValue() : 0) <= 0) {
        }
        composer2.endReplaceGroup();
        composer2.endReplaceGroup();
        composer2.endNode();
        if (ComposerKt.isTraceInProgress()) {
        }
        z6 = z7;
        endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RefundAmountsView$lambda$3$lambda$2$lambda$1(PriceWithCurrency priceWithCurrency, PriceWithCurrency priceWithCurrency2, boolean z5, int i5, int i6, Composer composer, int i7) {
        RefundAmountsView(priceWithCurrency, priceWithCurrency2, z5, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1), i6);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RefundAmountsView$lambda$4(PriceWithCurrency priceWithCurrency, PriceWithCurrency priceWithCurrency2, boolean z5, int i5, int i6, Composer composer, int i7) {
        RefundAmountsView(priceWithCurrency, priceWithCurrency2, z5, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1), i6);
        return Unit.INSTANCE;
    }
}
