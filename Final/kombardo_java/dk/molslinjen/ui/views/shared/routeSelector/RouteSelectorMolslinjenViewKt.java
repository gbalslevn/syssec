package dk.molslinjen.ui.views.shared.routeSelector;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Dp;
import dk.molslinjen.core.extensions.Accessibility;
import dk.molslinjen.domain.model.config.Route;
import dk.molslinjen.domain.model.config.Site;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.theme.AppColor;
import dk.molslinjen.ui.theme.TypographyKt;
import dk.molslinjen.ui.views.shared.routeSelector.RouteSelectorMolslinjenViewKt;
import dk.molslinjen.ui.views.shared.routeSelector.RouteSelectorMolslinjenViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\u001a%\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0001\u001a\u00020\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006\u001a7\u0010\r\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00072\u001e\u0010\u0004\u001a\u001a\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00030\tH\u0003¢\u0006\u0004\b\r\u0010\u000e\u001ag\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u00152\u001e\u0010\u0004\u001a\u001a\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00030\tH\u0003¢\u0006\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Ldk/molslinjen/ui/views/shared/routeSelector/RouteSelectorMolslinjenViewModel;", "viewModel", "Lkotlin/Function0;", BuildConfig.FLAVOR, "onRouteSelected", "RouteSelectorMolslinjenView", "(Ldk/molslinjen/ui/views/shared/routeSelector/RouteSelectorMolslinjenViewModel;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "Ldk/molslinjen/ui/views/shared/routeSelector/RouteSelectorMolslinjenViewModel$ViewState;", "viewState", "Lkotlin/Function3;", "Ldk/molslinjen/domain/model/config/Site;", "Ldk/molslinjen/domain/model/config/Route;", BuildConfig.FLAVOR, "RouteSelectorContent", "(Ldk/molslinjen/ui/views/shared/routeSelector/RouteSelectorMolslinjenViewModel$ViewState;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;I)V", "departingHarborName", "arrivalHarborName", "site", "route", "lineName", "defaultTransportationId", BuildConfig.FLAVOR, "selected", "RouteRow", "(Ljava/lang/String;Ljava/lang/String;Ldk/molslinjen/domain/model/config/Site;Ldk/molslinjen/domain/model/config/Route;Ljava/lang/String;Ljava/lang/String;ZLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;I)V", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class RouteSelectorMolslinjenViewKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void RouteRow(final String str, final String str2, final Site site, final Route route, final String str3, final String str4, final boolean z5, final Function3<? super Site, ? super Route, ? super String, Unit> function3, Composer composer, final int i5) {
        int i6;
        Modifier m108borderxT4_qwU;
        Composer startRestartGroup = composer.startRestartGroup(-91314045);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changed(str) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changed(str2) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i6 |= startRestartGroup.changed(site) ? 256 : 128;
        }
        if ((i5 & 3072) == 0) {
            i6 |= startRestartGroup.changedInstance(route) ? 2048 : 1024;
        }
        if ((i5 & 24576) == 0) {
            i6 |= startRestartGroup.changed(str3) ? 16384 : 8192;
        }
        if ((i5 & 196608) == 0) {
            i6 |= startRestartGroup.changed(str4) ? 131072 : 65536;
        }
        if ((i5 & 1572864) == 0) {
            i6 |= startRestartGroup.changed(z5) ? 1048576 : 524288;
        }
        if ((i5 & 12582912) == 0) {
            i6 |= startRestartGroup.changedInstance(function3) ? 8388608 : 4194304;
        }
        if ((i6 & 4793491) == 4793490 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-91314045, i6, -1, "dk.molslinjen.ui.views.shared.routeSelector.RouteRow (RouteSelectorMolslinjenView.kt:75)");
            }
            if (z5) {
                startRestartGroup.startReplaceGroup(750130542);
                m108borderxT4_qwU = BackgroundKt.m103backgroundbw27NRU(Modifier.INSTANCE, AppColor.INSTANCE.m3255getBrandBlue10d7_KjU(), MaterialTheme.INSTANCE.getShapes(startRestartGroup, MaterialTheme.$stable).getMedium());
                startRestartGroup.endReplaceGroup();
            } else {
                startRestartGroup.startReplaceGroup(750252124);
                Modifier.Companion companion = Modifier.INSTANCE;
                AppColor appColor = AppColor.INSTANCE;
                long m3269getGrey60d7_KjU = appColor.m3269getGrey60d7_KjU();
                MaterialTheme materialTheme = MaterialTheme.INSTANCE;
                int i7 = MaterialTheme.$stable;
                m108borderxT4_qwU = BorderKt.m108borderxT4_qwU(BackgroundKt.m103backgroundbw27NRU(companion, m3269getGrey60d7_KjU, materialTheme.getShapes(startRestartGroup, i7).getMedium()), Dp.m2599constructorimpl(1), appColor.m3268getGrey50d7_KjU(), materialTheme.getShapes(startRestartGroup, i7).getMedium());
                startRestartGroup.endReplaceGroup();
            }
            Modifier modifier = m108borderxT4_qwU;
            AppColor appColor2 = AppColor.INSTANCE;
            long m3281getWhite0d7_KjU = z5 ? appColor2.m3281getWhite0d7_KjU() : appColor2.m3253getBrandBlack10d7_KjU();
            startRestartGroup.startReplaceGroup(716949111);
            boolean changedInstance = ((29360128 & i6) == 8388608) | ((i6 & 896) == 256) | startRestartGroup.changedInstance(route) | ((458752 & i6) == 131072);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function0() { // from class: A4.s
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit RouteRow$lambda$7$lambda$6;
                        RouteRow$lambda$7$lambda$6 = RouteSelectorMolslinjenViewKt.RouteRow$lambda$7$lambda$6(Function3.this, site, route, str4);
                        return RouteRow$lambda$7$lambda$6;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            Modifier m312paddingVpY3zN4 = PaddingKt.m312paddingVpY3zN4(ClickableKt.m122clickableXHw0xAI$default(modifier, false, null, null, (Function0) rememberedValue, 7, null), Dp.m2599constructorimpl(16), Dp.m2599constructorimpl(8));
            Alignment.Companion companion2 = Alignment.INSTANCE;
            MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(companion2.getTopStart(), false);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, m312paddingVpY3zN4);
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
            Modifier.Companion companion4 = Modifier.INSTANCE;
            Arrangement arrangement = Arrangement.INSTANCE;
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(arrangement.getTop(), companion2.getStart(), startRestartGroup, 0);
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, companion4);
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
            TextStyle paragraphSmall = TypographyKt.getParagraphSmall();
            TextAlign.Companion companion5 = TextAlign.INSTANCE;
            int i8 = i6;
            TextKt.m940Text4IGK_g(str3, SizeKt.fillMaxWidth$default(companion4, 0.0f, 1, null), m3281getWhite0d7_KjU, 0L, null, null, null, 0L, null, TextAlign.m2521boximpl(companion5.m2528getCentere0LSkKk()), 0L, 0, false, 0, 0, null, paragraphSmall, startRestartGroup, ((i6 >> 12) & 14) | 48, 1572864, 65016);
            Alignment.Vertical centerVertically = companion2.getCenterVertically();
            Modifier m315paddingqDBjuR0$default = PaddingKt.m315paddingqDBjuR0$default(companion4, 0.0f, Dp.m2599constructorimpl(4), 0.0f, 0.0f, 13, null);
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(arrangement.getStart(), centerVertically, startRestartGroup, 48);
            int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap3 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(startRestartGroup, m315paddingqDBjuR0$default);
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
            Updater.m1227setimpl(m1226constructorimpl3, rowMeasurePolicy, companion3.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl3, currentCompositionLocalMap3, companion3.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = companion3.getSetCompositeKeyHash();
            if (m1226constructorimpl3.getInserting() || !Intrinsics.areEqual(m1226constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                m1226constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                m1226constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
            }
            Updater.m1227setimpl(m1226constructorimpl3, materializeModifier3, companion3.getSetModifier());
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            TextKt.m940Text4IGK_g(str, RowScope.weight$default(rowScopeInstance, companion4, 1.0f, false, 2, null), m3281getWhite0d7_KjU, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getParagraphSmallBold(), startRestartGroup, i8 & 14, 1572864, 65528);
            Painter painterResource = PainterResources_androidKt.painterResource(R.drawable.icon_select_route_arrows, startRestartGroup, 6);
            String skip = Accessibility.INSTANCE.getSkip();
            AppColor appColor3 = AppColor.INSTANCE;
            IconKt.m857Iconww6aTOc(painterResource, skip, (Modifier) null, z5 ? appColor3.m3281getWhite0d7_KjU() : appColor3.m3265getGrey20d7_KjU(), startRestartGroup, 0, 4);
            TextKt.m940Text4IGK_g(str2, RowScope.weight$default(rowScopeInstance, companion4, 1.0f, false, 2, null), m3281getWhite0d7_KjU, 0L, null, null, null, 0L, null, TextAlign.m2521boximpl(companion5.m2529getEnde0LSkKk()), 0L, 0, false, 0, 0, null, TypographyKt.getParagraphSmallBold(), startRestartGroup, (i8 >> 3) & 14, 1572864, 65016);
            startRestartGroup.endNode();
            startRestartGroup.endNode();
            startRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: A4.t
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit RouteRow$lambda$11;
                    RouteRow$lambda$11 = RouteSelectorMolslinjenViewKt.RouteRow$lambda$11(str, str2, site, route, str3, str4, z5, function3, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return RouteRow$lambda$11;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RouteRow$lambda$11(String str, String str2, Site site, Route route, String str3, String str4, boolean z5, Function3 function3, int i5, Composer composer, int i6) {
        RouteRow(str, str2, site, route, str3, str4, z5, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RouteRow$lambda$7$lambda$6(Function3 function3, Site site, Route route, String str) {
        function3.invoke(site, route, str);
        return Unit.INSTANCE;
    }

    private static final void RouteSelectorContent(final RouteSelectorMolslinjenViewModel.ViewState viewState, final Function3<? super Site, ? super Route, ? super String, Unit> function3, Composer composer, final int i5) {
        int i6;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(-652115351);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(viewState) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changedInstance(function3) ? 32 : 16;
        }
        if ((i6 & 19) == 18 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-652115351, i6, -1, "dk.molslinjen.ui.views.shared.routeSelector.RouteSelectorContent (RouteSelectorMolslinjenView.kt:42)");
            }
            float f5 = 24;
            Modifier m313paddingVpY3zN4$default = PaddingKt.m313paddingVpY3zN4$default(Modifier.INSTANCE, Dp.m2599constructorimpl(f5), 0.0f, 2, null);
            Arrangement.HorizontalOrVertical m265spacedBy0680j_4 = Arrangement.INSTANCE.m265spacedBy0680j_4(Dp.m2599constructorimpl(8));
            PaddingValues m310PaddingValuesa9UjIt4$default = PaddingKt.m310PaddingValuesa9UjIt4$default(0.0f, 0.0f, 0.0f, Dp.m2599constructorimpl(f5), 7, null);
            startRestartGroup.startReplaceGroup(594902969);
            boolean changedInstance = ((i6 & 112) == 32) | startRestartGroup.changedInstance(viewState);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function1() { // from class: A4.q
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit RouteSelectorContent$lambda$4$lambda$3;
                        RouteSelectorContent$lambda$4$lambda$3 = RouteSelectorMolslinjenViewKt.RouteSelectorContent$lambda$4$lambda$3(RouteSelectorMolslinjenViewModel.ViewState.this, function3, (LazyListScope) obj);
                        return RouteSelectorContent$lambda$4$lambda$3;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            composer2 = startRestartGroup;
            LazyDslKt.LazyColumn(m313paddingVpY3zN4$default, null, m310PaddingValuesa9UjIt4$default, false, m265spacedBy0680j_4, null, null, false, (Function1) rememberedValue, startRestartGroup, 24966, 234);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: A4.r
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit RouteSelectorContent$lambda$5;
                    RouteSelectorContent$lambda$5 = RouteSelectorMolslinjenViewKt.RouteSelectorContent$lambda$5(RouteSelectorMolslinjenViewModel.ViewState.this, function3, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return RouteSelectorContent$lambda$5;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RouteSelectorContent$lambda$4$lambda$3(final RouteSelectorMolslinjenViewModel.ViewState viewState, final Function3 function3, LazyListScope LazyColumn) {
        Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
        for (final RouteSelectorMolslinjenViewModel.ViewState.RouteRow routeRow : viewState.getRouteRows()) {
            LazyListScope.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(1167165599, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.shared.routeSelector.RouteSelectorMolslinjenViewKt$RouteSelectorContent$1$1$1
                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer, Integer num) {
                    invoke(lazyItemScope, composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(LazyItemScope item, Composer composer, int i5) {
                    Intrinsics.checkNotNullParameter(item, "$this$item");
                    if ((i5 & 17) == 16 && composer.getSkipping()) {
                        composer.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1167165599, i5, -1, "dk.molslinjen.ui.views.shared.routeSelector.RouteSelectorContent.<anonymous>.<anonymous>.<anonymous> (RouteSelectorMolslinjenView.kt:50)");
                    }
                    RouteSelectorMolslinjenViewKt.RouteRow(RouteSelectorMolslinjenViewModel.ViewState.RouteRow.this.getDepartingHarborName(), RouteSelectorMolslinjenViewModel.ViewState.RouteRow.this.getArrivalHarborName(), RouteSelectorMolslinjenViewModel.ViewState.RouteRow.this.getSite(), RouteSelectorMolslinjenViewModel.ViewState.RouteRow.this.getRoute(), RouteSelectorMolslinjenViewModel.ViewState.RouteRow.this.getSiteName(), RouteSelectorMolslinjenViewModel.ViewState.RouteRow.this.getDefaultTransportationId(), Intrinsics.areEqual(viewState.getSelectedRouteId(), RouteSelectorMolslinjenViewModel.ViewState.RouteRow.this.getRoute().getId()), function3, composer, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }), 3, null);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RouteSelectorContent$lambda$5(RouteSelectorMolslinjenViewModel.ViewState viewState, Function3 function3, int i5, Composer composer, int i6) {
        RouteSelectorContent(viewState, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    public static final void RouteSelectorMolslinjenView(final RouteSelectorMolslinjenViewModel viewModel, final Function0<Unit> onRouteSelected, Composer composer, final int i5) {
        int i6;
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(onRouteSelected, "onRouteSelected");
        Composer startRestartGroup = composer.startRestartGroup(130378016);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(viewModel) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changedInstance(onRouteSelected) ? 32 : 16;
        }
        if ((i6 & 19) == 18 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(130378016, i6, -1, "dk.molslinjen.ui.views.shared.routeSelector.RouteSelectorMolslinjenView (RouteSelectorMolslinjenView.kt:28)");
            }
            RouteSelectorMolslinjenViewModel.ViewState viewState = (RouteSelectorMolslinjenViewModel.ViewState) SnapshotStateKt.collectAsState(viewModel.getViewState(), null, startRestartGroup, 0, 1).getValue();
            startRestartGroup.startReplaceGroup(-954436907);
            boolean changedInstance = startRestartGroup.changedInstance(viewModel) | ((i6 & 112) == 32);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function3() { // from class: A4.u
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        Unit RouteSelectorMolslinjenView$lambda$1$lambda$0;
                        RouteSelectorMolslinjenView$lambda$1$lambda$0 = RouteSelectorMolslinjenViewKt.RouteSelectorMolslinjenView$lambda$1$lambda$0(RouteSelectorMolslinjenViewModel.this, onRouteSelected, (Site) obj, (Route) obj2, (String) obj3);
                        return RouteSelectorMolslinjenView$lambda$1$lambda$0;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            RouteSelectorContent(viewState, (Function3) rememberedValue, startRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: A4.v
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit RouteSelectorMolslinjenView$lambda$2;
                    RouteSelectorMolslinjenView$lambda$2 = RouteSelectorMolslinjenViewKt.RouteSelectorMolslinjenView$lambda$2(RouteSelectorMolslinjenViewModel.this, onRouteSelected, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return RouteSelectorMolslinjenView$lambda$2;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RouteSelectorMolslinjenView$lambda$1$lambda$0(RouteSelectorMolslinjenViewModel routeSelectorMolslinjenViewModel, Function0 function0, Site site, Route route, String defaultTransportationId) {
        Intrinsics.checkNotNullParameter(site, "site");
        Intrinsics.checkNotNullParameter(route, "route");
        Intrinsics.checkNotNullParameter(defaultTransportationId, "defaultTransportationId");
        routeSelectorMolslinjenViewModel.routeSelected(site, route, defaultTransportationId, function0);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RouteSelectorMolslinjenView$lambda$2(RouteSelectorMolslinjenViewModel routeSelectorMolslinjenViewModel, Function0 function0, int i5, Composer composer, int i6) {
        RouteSelectorMolslinjenView(routeSelectorMolslinjenViewModel, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }
}
