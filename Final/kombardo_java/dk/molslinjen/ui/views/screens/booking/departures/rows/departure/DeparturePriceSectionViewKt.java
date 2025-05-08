package dk.molslinjen.ui.views.screens.booking.departures.rows.departure;

import android.content.Context;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
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
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.PlatformTextStyle;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.Dp;
import dk.molslinjen.domain.model.booking.CheapestTicketPriceIndicator;
import dk.molslinjen.domain.model.shared.Price;
import dk.molslinjen.domain.model.shared.PriceWithCurrency;
import dk.molslinjen.extensions.domain.CheapestTicketPriceIndicatorExtensionsKt;
import dk.molslinjen.extensions.domain.PriceFormatExtensionsKt;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.theme.AppColor;
import dk.molslinjen.ui.theme.TypographyKt;
import dk.molslinjen.ui.views.screens.booking.departures.rows.departure.DeparturePriceSectionViewKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a;\u0010\t\u001a\u00020\b2\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0001¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Ldk/molslinjen/domain/model/shared/Price;", "price", "Ldk/molslinjen/domain/model/booking/CheapestTicketPriceIndicator;", "priceIndicator", BuildConfig.FLAVOR, "soldOut", "cancelled", "showDisabled", BuildConfig.FLAVOR, "DeparturePriceSection", "(Ldk/molslinjen/domain/model/shared/Price;Ldk/molslinjen/domain/model/booking/CheapestTicketPriceIndicator;ZZZLandroidx/compose/runtime/Composer;I)V", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class DeparturePriceSectionViewKt {
    public static final void DeparturePriceSection(final Price price, final CheapestTicketPriceIndicator cheapestTicketPriceIndicator, final boolean z5, final boolean z6, final boolean z7, Composer composer, final int i5) {
        int i6;
        Composer composer2;
        String formattedValue$default;
        String str;
        TextStyle m2295copyp1EtxEg;
        TextStyle m2295copyp1EtxEg2;
        Composer startRestartGroup = composer.startRestartGroup(-1054273919);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(price) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changed(cheapestTicketPriceIndicator) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i6 |= startRestartGroup.changed(z5) ? 256 : 128;
        }
        if ((i5 & 3072) == 0) {
            i6 |= startRestartGroup.changed(z6) ? 2048 : 1024;
        }
        if ((i5 & 24576) == 0) {
            i6 |= startRestartGroup.changed(z7) ? 16384 : 8192;
        }
        if ((i6 & 9363) == 9362 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1054273919, i6, -1, "dk.molslinjen.ui.views.screens.booking.departures.rows.departure.DeparturePriceSection (DeparturePriceSectionView.kt:42)");
            }
            AppColor appColor = AppColor.INSTANCE;
            long m3266getGrey30d7_KjU = z7 ? appColor.m3266getGrey30d7_KjU() : appColor.m3253getBrandBlack10d7_KjU();
            if (z5 || z6) {
                composer2 = startRestartGroup;
                composer2.startReplaceGroup(1940681736);
                Modifier.Companion companion = Modifier.INSTANCE;
                Modifier m325height3ABfNKs = SizeKt.m325height3ABfNKs(companion, Dp.m2599constructorimpl(28));
                AppColor appColor2 = AppColor.INSTANCE;
                Modifier m103backgroundbw27NRU = BackgroundKt.m103backgroundbw27NRU(m325height3ABfNKs, appColor2.m3275getTagGrey0d7_KjU(), RoundedCornerShapeKt.m460RoundedCornerShape0680j_4(Dp.m2599constructorimpl(14)));
                MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getCenter(), false);
                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer2, m103backgroundbw27NRU);
                ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
                Function0<ComposeUiNode> constructor = companion2.getConstructor();
                if (composer2.getApplier() == null) {
                    ComposablesKt.invalidApplier();
                }
                composer2.startReusableNode();
                if (composer2.getInserting()) {
                    composer2.createNode(constructor);
                } else {
                    composer2.useNode();
                }
                Composer m1226constructorimpl = Updater.m1226constructorimpl(composer2);
                Updater.m1227setimpl(m1226constructorimpl, maybeCachedBoxMeasurePolicy, companion2.getSetMeasurePolicy());
                Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion2.getSetCompositeKeyHash();
                if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                    m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion2.getSetModifier());
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                TextKt.m940Text4IGK_g(StringResources_androidKt.stringResource(z5 ? R.string.common_soldOut : R.string.common_cancelled, composer2, 0), PaddingKt.m312paddingVpY3zN4(companion, Dp.m2599constructorimpl(8), Dp.m2599constructorimpl(4)), appColor2.m3253getBrandBlack10d7_KjU(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getSubBold(), composer2, 432, 1572864, 65528);
                composer2.endNode();
                composer2.endReplaceGroup();
            } else {
                startRestartGroup.startReplaceGroup(1941302728);
                Modifier.Companion companion3 = Modifier.INSTANCE;
                Modifier m315paddingqDBjuR0$default = PaddingKt.m315paddingqDBjuR0$default(companion3, 0.0f, Dp.m2599constructorimpl(12), 0.0f, 0.0f, 13, null);
                Arrangement arrangement = Arrangement.INSTANCE;
                Arrangement.Vertical top = arrangement.getTop();
                Alignment.Companion companion4 = Alignment.INSTANCE;
                MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(top, companion4.getStart(), startRestartGroup, 0);
                int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
                Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, m315paddingqDBjuR0$default);
                ComposeUiNode.Companion companion5 = ComposeUiNode.INSTANCE;
                Function0<ComposeUiNode> constructor2 = companion5.getConstructor();
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
                Updater.m1227setimpl(m1226constructorimpl2, columnMeasurePolicy, companion5.getSetMeasurePolicy());
                Updater.m1227setimpl(m1226constructorimpl2, currentCompositionLocalMap2, companion5.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = companion5.getSetCompositeKeyHash();
                if (m1226constructorimpl2.getInserting() || !Intrinsics.areEqual(m1226constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                    m1226constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                    m1226constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                }
                Updater.m1227setimpl(m1226constructorimpl2, materializeModifier2, companion5.getSetModifier());
                ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                final Context context = (Context) startRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
                startRestartGroup.startReplaceGroup(1468628200);
                boolean changed = startRestartGroup.changed(price);
                Object rememberedValue = startRestartGroup.rememberedValue();
                if (changed || rememberedValue == Composer.INSTANCE.getEmpty()) {
                    if (price instanceof Price.Charge) {
                        formattedValue$default = PriceFormatExtensionsKt.formatted((Price.Charge) price, context);
                    } else if (price instanceof PriceWithCurrency) {
                        formattedValue$default = PriceWithCurrency.formattedValue$default((PriceWithCurrency) price, false, 1, null);
                    } else {
                        if (price != null) {
                            throw new NoWhenBranchMatchedException();
                        }
                        rememberedValue = "-";
                        startRestartGroup.updateRememberedValue(rememberedValue);
                    }
                    rememberedValue = formattedValue$default;
                    startRestartGroup.updateRememberedValue(rememberedValue);
                }
                String str2 = (String) rememberedValue;
                startRestartGroup.endReplaceGroup();
                if (price instanceof Price.Charge) {
                    startRestartGroup.startReplaceGroup(-1716854690);
                    TextKt.m940Text4IGK_g(StringResources_androidKt.stringResource(R.string.common_price, startRestartGroup, 6), null, m3266getGrey30d7_KjU, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getSubSmall(), startRestartGroup, 0, 1572864, 65530);
                    TextKt.m940Text4IGK_g(str2, PaddingKt.m315paddingqDBjuR0$default(companion3, 0.0f, Dp.m2599constructorimpl(2), 0.0f, 0.0f, 13, null), m3266getGrey30d7_KjU, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getH3Bold(), startRestartGroup, 48, 1572864, 65528);
                    startRestartGroup.endReplaceGroup();
                    composer2 = startRestartGroup;
                } else {
                    if (!(price instanceof PriceWithCurrency) && price != null) {
                        startRestartGroup.startReplaceGroup(1468638595);
                        startRestartGroup.endReplaceGroup();
                        throw new NoWhenBranchMatchedException();
                    }
                    startRestartGroup.startReplaceGroup(-1716305122);
                    final String stringResource = StringResources_androidKt.stringResource(R.string.common_from, startRestartGroup, 6);
                    startRestartGroup.startReplaceGroup(1468659760);
                    boolean changed2 = startRestartGroup.changed(stringResource) | startRestartGroup.changedInstance(price) | startRestartGroup.changedInstance(context);
                    Object rememberedValue2 = startRestartGroup.rememberedValue();
                    if (changed2 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        rememberedValue2 = new Function1() { // from class: N2.h
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                Unit DeparturePriceSection$lambda$5$lambda$3$lambda$2;
                                DeparturePriceSection$lambda$5$lambda$3$lambda$2 = DeparturePriceSectionViewKt.DeparturePriceSection$lambda$5$lambda$3$lambda$2(stringResource, price, context, (SemanticsPropertyReceiver) obj);
                                return DeparturePriceSection$lambda$5$lambda$3$lambda$2;
                            }
                        };
                        startRestartGroup.updateRememberedValue(rememberedValue2);
                    }
                    startRestartGroup.endReplaceGroup();
                    Modifier clearAndSetSemantics = SemanticsModifierKt.clearAndSetSemantics(companion3, (Function1) rememberedValue2);
                    MeasurePolicy columnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(arrangement.getTop(), companion4.getStart(), startRestartGroup, 0);
                    int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap3 = startRestartGroup.getCurrentCompositionLocalMap();
                    Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(startRestartGroup, clearAndSetSemantics);
                    Function0<ComposeUiNode> constructor3 = companion5.getConstructor();
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
                    Updater.m1227setimpl(m1226constructorimpl3, columnMeasurePolicy2, companion5.getSetMeasurePolicy());
                    Updater.m1227setimpl(m1226constructorimpl3, currentCompositionLocalMap3, companion5.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = companion5.getSetCompositeKeyHash();
                    if (m1226constructorimpl3.getInserting() || !Intrinsics.areEqual(m1226constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                        m1226constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                        m1226constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                    }
                    Updater.m1227setimpl(m1226constructorimpl3, materializeModifier3, companion5.getSetModifier());
                    float f5 = 8;
                    Modifier m315paddingqDBjuR0$default2 = PaddingKt.m315paddingqDBjuR0$default(companion3, Dp.m2599constructorimpl(f5), 0.0f, 0.0f, 0.0f, 14, null);
                    PriceWithCurrency priceWithCurrency = (PriceWithCurrency) price;
                    if (priceWithCurrency == null || (str = PriceFormatExtensionsKt.getCurrencyFormatted(priceWithCurrency, context)) == null) {
                        str = BuildConfig.FLAVOR;
                    }
                    m2295copyp1EtxEg = r37.m2295copyp1EtxEg((r48 & 1) != 0 ? r37.spanStyle.m2255getColor0d7_KjU() : 0L, (r48 & 2) != 0 ? r37.spanStyle.getFontSize() : 0L, (r48 & 4) != 0 ? r37.spanStyle.getFontWeight() : null, (r48 & 8) != 0 ? r37.spanStyle.getFontStyle() : null, (r48 & 16) != 0 ? r37.spanStyle.getFontSynthesis() : null, (r48 & 32) != 0 ? r37.spanStyle.getFontFamily() : null, (r48 & 64) != 0 ? r37.spanStyle.getFontFeatureSettings() : null, (r48 & 128) != 0 ? r37.spanStyle.getLetterSpacing() : 0L, (r48 & 256) != 0 ? r37.spanStyle.getBaselineShift() : null, (r48 & 512) != 0 ? r37.spanStyle.getTextGeometricTransform() : null, (r48 & 1024) != 0 ? r37.spanStyle.getLocaleList() : null, (r48 & 2048) != 0 ? r37.spanStyle.getBackground() : 0L, (r48 & 4096) != 0 ? r37.spanStyle.getTextDecoration() : null, (r48 & 8192) != 0 ? r37.spanStyle.getShadow() : null, (r48 & 16384) != 0 ? r37.spanStyle.getDrawStyle() : null, (r48 & 32768) != 0 ? r37.paragraphStyle.getTextAlign() : 0, (r48 & 65536) != 0 ? r37.paragraphStyle.getTextDirection() : 0, (r48 & 131072) != 0 ? r37.paragraphStyle.getLineHeight() : 0L, (r48 & 262144) != 0 ? r37.paragraphStyle.getTextIndent() : null, (r48 & 524288) != 0 ? r37.platformStyle : new PlatformTextStyle(true), (r48 & 1048576) != 0 ? r37.paragraphStyle.getLineHeightStyle() : null, (r48 & 2097152) != 0 ? r37.paragraphStyle.getLineBreak() : 0, (r48 & 4194304) != 0 ? r37.paragraphStyle.getHyphens() : 0, (r48 & 8388608) != 0 ? TypographyKt.getSubSmall().paragraphStyle.getTextMotion() : null);
                    TextKt.m940Text4IGK_g(stringResource + " " + str, m315paddingqDBjuR0$default2, m3266getGrey30d7_KjU, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, m2295copyp1EtxEg, startRestartGroup, 48, 0, 65528);
                    SpacerKt.Spacer(SizeKt.m325height3ABfNKs(companion3, Dp.m2599constructorimpl(2)), startRestartGroup, 6);
                    Color highlightColor = cheapestTicketPriceIndicator != null ? CheapestTicketPriceIndicatorExtensionsKt.getHighlightColor(cheapestTicketPriceIndicator) : null;
                    Modifier m313paddingVpY3zN4$default = PaddingKt.m313paddingVpY3zN4$default(highlightColor != null ? BackgroundKt.m103backgroundbw27NRU(companion3, highlightColor.getValue(), RoundedCornerShapeKt.m460RoundedCornerShape0680j_4(Dp.m2599constructorimpl(32))) : companion3, Dp.m2599constructorimpl(f5), 0.0f, 2, null);
                    String str3 = z7 ? "-" : str2;
                    m2295copyp1EtxEg2 = r34.m2295copyp1EtxEg((r48 & 1) != 0 ? r34.spanStyle.m2255getColor0d7_KjU() : 0L, (r48 & 2) != 0 ? r34.spanStyle.getFontSize() : 0L, (r48 & 4) != 0 ? r34.spanStyle.getFontWeight() : null, (r48 & 8) != 0 ? r34.spanStyle.getFontStyle() : null, (r48 & 16) != 0 ? r34.spanStyle.getFontSynthesis() : null, (r48 & 32) != 0 ? r34.spanStyle.getFontFamily() : null, (r48 & 64) != 0 ? r34.spanStyle.getFontFeatureSettings() : null, (r48 & 128) != 0 ? r34.spanStyle.getLetterSpacing() : 0L, (r48 & 256) != 0 ? r34.spanStyle.getBaselineShift() : null, (r48 & 512) != 0 ? r34.spanStyle.getTextGeometricTransform() : null, (r48 & 1024) != 0 ? r34.spanStyle.getLocaleList() : null, (r48 & 2048) != 0 ? r34.spanStyle.getBackground() : 0L, (r48 & 4096) != 0 ? r34.spanStyle.getTextDecoration() : null, (r48 & 8192) != 0 ? r34.spanStyle.getShadow() : null, (r48 & 16384) != 0 ? r34.spanStyle.getDrawStyle() : null, (r48 & 32768) != 0 ? r34.paragraphStyle.getTextAlign() : 0, (r48 & 65536) != 0 ? r34.paragraphStyle.getTextDirection() : 0, (r48 & 131072) != 0 ? r34.paragraphStyle.getLineHeight() : 0L, (r48 & 262144) != 0 ? r34.paragraphStyle.getTextIndent() : null, (r48 & 524288) != 0 ? r34.platformStyle : new PlatformTextStyle(true), (r48 & 1048576) != 0 ? r34.paragraphStyle.getLineHeightStyle() : null, (r48 & 2097152) != 0 ? r34.paragraphStyle.getLineBreak() : 0, (r48 & 4194304) != 0 ? r34.paragraphStyle.getHyphens() : 0, (r48 & 8388608) != 0 ? TypographyKt.getH3Bold().paragraphStyle.getTextMotion() : null);
                    composer2 = startRestartGroup;
                    TextKt.m940Text4IGK_g(str3, m313paddingVpY3zN4$default, m3266getGrey30d7_KjU, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, m2295copyp1EtxEg2, composer2, 0, 0, 65528);
                    composer2.endNode();
                    composer2.endReplaceGroup();
                }
                composer2.endNode();
                composer2.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: N2.i
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit DeparturePriceSection$lambda$6;
                    DeparturePriceSection$lambda$6 = DeparturePriceSectionViewKt.DeparturePriceSection$lambda$6(Price.this, cheapestTicketPriceIndicator, z5, z6, z7, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return DeparturePriceSection$lambda$6;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DeparturePriceSection$lambda$5$lambda$3$lambda$2(String str, Price price, Context context, SemanticsPropertyReceiver clearAndSetSemantics) {
        String str2;
        Intrinsics.checkNotNullParameter(clearAndSetSemantics, "$this$clearAndSetSemantics");
        PriceWithCurrency priceWithCurrency = (PriceWithCurrency) price;
        if (priceWithCurrency == null || (str2 = PriceFormatExtensionsKt.formatted(priceWithCurrency, context)) == null) {
            str2 = BuildConfig.FLAVOR;
        }
        SemanticsPropertiesKt.setContentDescription(clearAndSetSemantics, str + " " + str2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DeparturePriceSection$lambda$6(Price price, CheapestTicketPriceIndicator cheapestTicketPriceIndicator, boolean z5, boolean z6, boolean z7, int i5, Composer composer, int i6) {
        DeparturePriceSection(price, cheapestTicketPriceIndicator, z5, z6, z7, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }
}
