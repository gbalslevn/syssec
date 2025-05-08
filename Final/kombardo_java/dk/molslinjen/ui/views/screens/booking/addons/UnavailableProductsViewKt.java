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
import androidx.compose.material3.IconKt;
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
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Dp;
import dk.molslinjen.core.extensions.Accessibility;
import dk.molslinjen.domain.model.booking.product.UnavailableProduct;
import dk.molslinjen.domain.model.shared.Price;
import dk.molslinjen.domain.model.shared.PriceWithCurrency;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.theme.AppColor;
import dk.molslinjen.ui.theme.ThemeShapesKt;
import dk.molslinjen.ui.theme.TypographyKt;
import dk.molslinjen.ui.views.screens.booking.addons.UnavailableProductsViewKt;
import dk.molslinjen.ui.views.shared.components.PriceTextKt;
import dk.molslinjen.ui.views.shared.components.PriceViewType;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u001a/\u0010\b\u001a\u00020\u00072\u0006\u0010\u0001\u001a\u00020\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0007¢\u0006\u0004\b\b\u0010\t\u001a\u001f\u0010\f\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0005H\u0003¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {BuildConfig.FLAVOR, "description", BuildConfig.FLAVOR, "Ldk/molslinjen/domain/model/booking/product/UnavailableProduct;", "unavailableProducts", "Ldk/molslinjen/domain/model/shared/PriceWithCurrency;", "unavailableSeatReservationPrice", BuildConfig.FLAVOR, "UnavailableProductsView", "(Ljava/lang/String;Ljava/util/List;Ldk/molslinjen/domain/model/shared/PriceWithCurrency;Landroidx/compose/runtime/Composer;I)V", "name", "price", "UnavailableProductView", "(Ljava/lang/String;Ldk/molslinjen/domain/model/shared/PriceWithCurrency;Landroidx/compose/runtime/Composer;I)V", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class UnavailableProductsViewKt {
    private static final void UnavailableProductView(final String str, final PriceWithCurrency priceWithCurrency, Composer composer, final int i5) {
        int i6;
        TextStyle m2295copyp1EtxEg;
        Composer composer2;
        TextStyle m2295copyp1EtxEg2;
        Composer startRestartGroup = composer.startRestartGroup(1847148015);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changed(str) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changedInstance(priceWithCurrency) ? 32 : 16;
        }
        int i7 = i6;
        if ((i7 & 19) == 18 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1847148015, i7, -1, "dk.molslinjen.ui.views.screens.booking.addons.UnavailableProductView (UnavailableProductsView.kt:72)");
            }
            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
            Modifier.Companion companion = Modifier.INSTANCE;
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, startRestartGroup, 48);
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
            Updater.m1227setimpl(m1226constructorimpl, rowMeasurePolicy, companion2.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion2.getSetCompositeKeyHash();
            if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion2.getSetModifier());
            Modifier weight$default = RowScope.weight$default(RowScopeInstance.INSTANCE, companion, 1.0f, false, 2, null);
            TextStyle sub = TypographyKt.getSub();
            TextDecoration.Companion companion3 = TextDecoration.INSTANCE;
            m2295copyp1EtxEg = sub.m2295copyp1EtxEg((r48 & 1) != 0 ? sub.spanStyle.m2255getColor0d7_KjU() : 0L, (r48 & 2) != 0 ? sub.spanStyle.getFontSize() : 0L, (r48 & 4) != 0 ? sub.spanStyle.getFontWeight() : null, (r48 & 8) != 0 ? sub.spanStyle.getFontStyle() : null, (r48 & 16) != 0 ? sub.spanStyle.getFontSynthesis() : null, (r48 & 32) != 0 ? sub.spanStyle.getFontFamily() : null, (r48 & 64) != 0 ? sub.spanStyle.getFontFeatureSettings() : null, (r48 & 128) != 0 ? sub.spanStyle.getLetterSpacing() : 0L, (r48 & 256) != 0 ? sub.spanStyle.getBaselineShift() : null, (r48 & 512) != 0 ? sub.spanStyle.getTextGeometricTransform() : null, (r48 & 1024) != 0 ? sub.spanStyle.getLocaleList() : null, (r48 & 2048) != 0 ? sub.spanStyle.getBackground() : 0L, (r48 & 4096) != 0 ? sub.spanStyle.getTextDecoration() : companion3.getLineThrough(), (r48 & 8192) != 0 ? sub.spanStyle.getShadow() : null, (r48 & 16384) != 0 ? sub.spanStyle.getDrawStyle() : null, (r48 & 32768) != 0 ? sub.paragraphStyle.getTextAlign() : 0, (r48 & 65536) != 0 ? sub.paragraphStyle.getTextDirection() : 0, (r48 & 131072) != 0 ? sub.paragraphStyle.getLineHeight() : 0L, (r48 & 262144) != 0 ? sub.paragraphStyle.getTextIndent() : null, (r48 & 524288) != 0 ? sub.platformStyle : null, (r48 & 1048576) != 0 ? sub.paragraphStyle.getLineHeightStyle() : null, (r48 & 2097152) != 0 ? sub.paragraphStyle.getLineBreak() : 0, (r48 & 4194304) != 0 ? sub.paragraphStyle.getHyphens() : 0, (r48 & 8388608) != 0 ? sub.paragraphStyle.getTextMotion() : null);
            composer2 = startRestartGroup;
            TextKt.m940Text4IGK_g(str, weight$default, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, m2295copyp1EtxEg, composer2, i7 & 14, 0, 65532);
            Modifier m315paddingqDBjuR0$default = PaddingKt.m315paddingqDBjuR0$default(companion, Dp.m2599constructorimpl(8), 0.0f, 0.0f, 0.0f, 14, null);
            m2295copyp1EtxEg2 = r49.m2295copyp1EtxEg((r48 & 1) != 0 ? r49.spanStyle.m2255getColor0d7_KjU() : 0L, (r48 & 2) != 0 ? r49.spanStyle.getFontSize() : 0L, (r48 & 4) != 0 ? r49.spanStyle.getFontWeight() : null, (r48 & 8) != 0 ? r49.spanStyle.getFontStyle() : null, (r48 & 16) != 0 ? r49.spanStyle.getFontSynthesis() : null, (r48 & 32) != 0 ? r49.spanStyle.getFontFamily() : null, (r48 & 64) != 0 ? r49.spanStyle.getFontFeatureSettings() : null, (r48 & 128) != 0 ? r49.spanStyle.getLetterSpacing() : 0L, (r48 & 256) != 0 ? r49.spanStyle.getBaselineShift() : null, (r48 & 512) != 0 ? r49.spanStyle.getTextGeometricTransform() : null, (r48 & 1024) != 0 ? r49.spanStyle.getLocaleList() : null, (r48 & 2048) != 0 ? r49.spanStyle.getBackground() : 0L, (r48 & 4096) != 0 ? r49.spanStyle.getTextDecoration() : companion3.getLineThrough(), (r48 & 8192) != 0 ? r49.spanStyle.getShadow() : null, (r48 & 16384) != 0 ? r49.spanStyle.getDrawStyle() : null, (r48 & 32768) != 0 ? r49.paragraphStyle.getTextAlign() : 0, (r48 & 65536) != 0 ? r49.paragraphStyle.getTextDirection() : 0, (r48 & 131072) != 0 ? r49.paragraphStyle.getLineHeight() : 0L, (r48 & 262144) != 0 ? r49.paragraphStyle.getTextIndent() : null, (r48 & 524288) != 0 ? r49.platformStyle : null, (r48 & 1048576) != 0 ? r49.paragraphStyle.getLineHeightStyle() : null, (r48 & 2097152) != 0 ? r49.paragraphStyle.getLineBreak() : 0, (r48 & 4194304) != 0 ? r49.paragraphStyle.getHyphens() : 0, (r48 & 8388608) != 0 ? TypographyKt.getSubBold().paragraphStyle.getTextMotion() : null);
            PriceTextKt.m3557PriceText1y9Plug((Price) priceWithCurrency, m315paddingqDBjuR0$default, (PriceViewType) null, false, m2295copyp1EtxEg2, (TextAlign) null, 0, 0L, composer2, ((i7 >> 3) & 14) | 48, 236);
            composer2.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: D2.q0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit UnavailableProductView$lambda$7;
                    UnavailableProductView$lambda$7 = UnavailableProductsViewKt.UnavailableProductView$lambda$7(str, priceWithCurrency, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return UnavailableProductView$lambda$7;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit UnavailableProductView$lambda$7(String str, PriceWithCurrency priceWithCurrency, int i5, Composer composer, int i6) {
        UnavailableProductView(str, priceWithCurrency, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    public static final void UnavailableProductsView(final String description, final List<UnavailableProduct> unavailableProducts, final PriceWithCurrency priceWithCurrency, Composer composer, final int i5) {
        Composer composer2;
        final PriceWithCurrency priceWithCurrency2;
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(unavailableProducts, "unavailableProducts");
        Composer startRestartGroup = composer.startRestartGroup(2094634458);
        int i6 = (i5 & 6) == 0 ? (startRestartGroup.changed(description) ? 4 : 2) | i5 : i5;
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changedInstance(unavailableProducts) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i6 |= startRestartGroup.changedInstance(priceWithCurrency) ? 256 : 128;
        }
        int i7 = i6;
        if ((i7 & 147) == 146 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
            priceWithCurrency2 = priceWithCurrency;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2094634458, i7, -1, "dk.molslinjen.ui.views.screens.booking.addons.UnavailableProductsView (UnavailableProductsView.kt:32)");
            }
            if (unavailableProducts.isEmpty() && priceWithCurrency == null) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                    endRestartGroup.updateScope(new Function2() { // from class: D2.o0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            Unit UnavailableProductsView$lambda$0;
                            UnavailableProductsView$lambda$0 = UnavailableProductsViewKt.UnavailableProductsView$lambda$0(description, unavailableProducts, priceWithCurrency, i5, (Composer) obj, ((Integer) obj2).intValue());
                            return UnavailableProductsView$lambda$0;
                        }
                    });
                    return;
                }
                return;
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null);
            AppColor appColor = AppColor.INSTANCE;
            float f5 = 16;
            Modifier m311padding3ABfNKs = PaddingKt.m311padding3ABfNKs(BackgroundKt.m103backgroundbw27NRU(fillMaxWidth$default, appColor.m3268getGrey50d7_KjU(), ThemeShapesKt.getThemeShapes().getMedium()), Dp.m2599constructorimpl(f5));
            Arrangement arrangement = Arrangement.INSTANCE;
            Arrangement.Vertical top = arrangement.getTop();
            Alignment.Companion companion2 = Alignment.INSTANCE;
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(top, companion2.getStart(), startRestartGroup, 0);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, m311padding3ABfNKs);
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
            Updater.m1227setimpl(m1226constructorimpl, columnMeasurePolicy, companion3.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion3.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion3.getSetCompositeKeyHash();
            if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion3.getSetModifier());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(arrangement.getStart(), companion2.getCenterVertically(), startRestartGroup, 48);
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, companion);
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
            Updater.m1227setimpl(m1226constructorimpl2, rowMeasurePolicy, companion3.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl2, currentCompositionLocalMap2, companion3.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = companion3.getSetCompositeKeyHash();
            if (m1226constructorimpl2.getInserting() || !Intrinsics.areEqual(m1226constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                m1226constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                m1226constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            Updater.m1227setimpl(m1226constructorimpl2, materializeModifier2, companion3.getSetModifier());
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            IconKt.m857Iconww6aTOc(PainterResources_androidKt.painterResource(R.drawable.icon_alert_warning, startRestartGroup, 6), Accessibility.INSTANCE.getSkip(), (Modifier) null, appColor.m3266getGrey30d7_KjU(), startRestartGroup, 3072, 4);
            TextKt.m940Text4IGK_g(description, PaddingKt.m315paddingqDBjuR0$default(companion, Dp.m2599constructorimpl(10), 0.0f, 0.0f, 0.0f, 14, null), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getSub(), startRestartGroup, (i7 & 14) | 48, 1572864, 65532);
            startRestartGroup.endNode();
            composer2 = startRestartGroup;
            SpacerKt.Spacer(SizeKt.m325height3ABfNKs(companion, Dp.m2599constructorimpl(f5)), composer2, 6);
            MeasurePolicy columnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(arrangement.m265spacedBy0680j_4(Dp.m2599constructorimpl(8)), companion2.getStart(), composer2, 6);
            int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
            CompositionLocalMap currentCompositionLocalMap3 = composer2.getCurrentCompositionLocalMap();
            Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(composer2, companion);
            Function0<ComposeUiNode> constructor3 = companion3.getConstructor();
            if (composer2.getApplier() == null) {
                ComposablesKt.invalidApplier();
            }
            composer2.startReusableNode();
            if (composer2.getInserting()) {
                composer2.createNode(constructor3);
            } else {
                composer2.useNode();
            }
            Composer m1226constructorimpl3 = Updater.m1226constructorimpl(composer2);
            Updater.m1227setimpl(m1226constructorimpl3, columnMeasurePolicy2, companion3.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl3, currentCompositionLocalMap3, companion3.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = companion3.getSetCompositeKeyHash();
            if (m1226constructorimpl3.getInserting() || !Intrinsics.areEqual(m1226constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                m1226constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                m1226constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
            }
            Updater.m1227setimpl(m1226constructorimpl3, materializeModifier3, companion3.getSetModifier());
            composer2.startReplaceGroup(1475139549);
            for (UnavailableProduct unavailableProduct : unavailableProducts) {
                UnavailableProductView(unavailableProduct.getName(), unavailableProduct.getPrice(), composer2, 0);
            }
            composer2.endReplaceGroup();
            composer2.startReplaceGroup(1475145402);
            priceWithCurrency2 = priceWithCurrency;
            if (priceWithCurrency2 != null) {
                UnavailableProductView(StringResources_androidKt.stringResource(R.string.ticketDetails_seatReservation, composer2, 6), priceWithCurrency2, composer2, 0);
                Unit unit = Unit.INSTANCE;
            }
            composer2.endReplaceGroup();
            composer2.endNode();
            composer2.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup2 = composer2.endRestartGroup();
        if (endRestartGroup2 != null) {
            endRestartGroup2.updateScope(new Function2() { // from class: D2.p0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit UnavailableProductsView$lambda$5;
                    UnavailableProductsView$lambda$5 = UnavailableProductsViewKt.UnavailableProductsView$lambda$5(description, unavailableProducts, priceWithCurrency2, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return UnavailableProductsView$lambda$5;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit UnavailableProductsView$lambda$0(String str, List list, PriceWithCurrency priceWithCurrency, int i5, Composer composer, int i6) {
        UnavailableProductsView(str, list, priceWithCurrency, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit UnavailableProductsView$lambda$5(String str, List list, PriceWithCurrency priceWithCurrency, int i5, Composer composer, int i6) {
        UnavailableProductsView(str, list, priceWithCurrency, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }
}
