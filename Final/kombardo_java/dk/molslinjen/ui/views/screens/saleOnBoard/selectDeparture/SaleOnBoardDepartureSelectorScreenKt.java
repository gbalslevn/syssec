package dk.molslinjen.ui.views.screens.saleOnBoard.selectDeparture;

import androidx.compose.foundation.BackgroundKt;
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
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.lazy.LazyListStateKt;
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
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.unit.Dp;
import com.ramcosta.composedestinations.generated.destinations.CalendarScreenDestination;
import com.ramcosta.composedestinations.navigation.DestinationsNavigator;
import com.ramcosta.composedestinations.result.OpenResultRecipientKt;
import com.ramcosta.composedestinations.result.ResultRecipient;
import dk.molslinjen.domain.managers.departure.DepartureState;
import dk.molslinjen.domain.managers.saleOnBoard.SaleOnBoardRouteState;
import dk.molslinjen.domain.model.booking.Departure;
import dk.molslinjen.domain.model.booking.DepartureDirection;
import dk.molslinjen.domain.model.booking.RouteDirection;
import dk.molslinjen.domain.model.config.LocalizedSiteConfiguration;
import dk.molslinjen.domain.model.config.RouteDirectionGroup;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.theme.AppColor;
import dk.molslinjen.ui.theme.TypographyKt;
import dk.molslinjen.ui.views.reusable.IndexHolder;
import dk.molslinjen.ui.views.reusable.ItemIndexedKt;
import dk.molslinjen.ui.views.reusable.LoadingComponentKt;
import dk.molslinjen.ui.views.reusable.bottomsheet.BottomSheetContainerKt;
import dk.molslinjen.ui.views.reusable.buttons.NavigationButtonKt;
import dk.molslinjen.ui.views.reusable.buttons.NavigationButtonType;
import dk.molslinjen.ui.views.screens.booking.departures.DepartureErrorViewKt;
import dk.molslinjen.ui.views.screens.booking.departures.DepartureItemsViewKt;
import dk.molslinjen.ui.views.screens.booking.departures.DepartureTabState;
import dk.molslinjen.ui.views.screens.booking.departures.selectRoute.RouteSelectorViewKt;
import dk.molslinjen.ui.views.screens.saleOnBoard.selectDeparture.SaleOnBoardDepartureSelectorScreenKt;
import dk.molslinjen.ui.views.screens.saleOnBoard.selectDeparture.SaleOnBoardDepartureSelectorViewModel;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;
import org.threeten.bp.LocalDate;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0007\u001a3\u0010\t\u001a\u00020\b2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004H\u0007¢\u0006\u0004\b\t\u0010\n\u001a«\u0001\u0010\u001d\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\b0\u00112\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\b0\u00132\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b0\u00132\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b0\u00132\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\b0\u00112\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\b0\u00112\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b0\u00132\u0006\u0010\u001c\u001a\u00020\u001bH\u0003¢\u0006\u0004\b\u001d\u0010\u001e\u001a=\u0010\u001f\u001a\u00020\b2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\b0\u00112\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\b0\u00112\u0006\u0010\u001c\u001a\u00020\u001bH\u0003¢\u0006\u0004\b\u001f\u0010 ¨\u0006\"²\u0006\f\u0010!\u001a\u00020\u001b8\nX\u008a\u0084\u0002"}, d2 = {"Ldk/molslinjen/ui/views/screens/saleOnBoard/selectDeparture/SaleOnBoardDepartureSelectorViewModel;", "viewModel", "Lcom/ramcosta/composedestinations/navigation/DestinationsNavigator;", "navigator", "Lcom/ramcosta/composedestinations/result/ResultRecipient;", "Lcom/ramcosta/composedestinations/generated/destinations/CalendarScreenDestination;", "Lorg/threeten/bp/LocalDate;", "calendarResultRecipient", BuildConfig.FLAVOR, "SaleOnBoardDepartureSelectorScreen", "(Ldk/molslinjen/ui/views/screens/saleOnBoard/selectDeparture/SaleOnBoardDepartureSelectorViewModel;Lcom/ramcosta/composedestinations/navigation/DestinationsNavigator;Lcom/ramcosta/composedestinations/result/ResultRecipient;Landroidx/compose/runtime/Composer;I)V", "Ldk/molslinjen/domain/managers/saleOnBoard/SaleOnBoardRouteState;", "routeState", "Ldk/molslinjen/domain/managers/departure/DepartureState;", "departureState", "Ldk/molslinjen/ui/views/screens/booking/departures/DepartureTabState;", "departureTabState", "Lkotlin/Function0;", "flipDirection", "Lkotlin/Function1;", "Ldk/molslinjen/domain/model/booking/Departure;", "departureSelected", "updateShownHeaderDate", "departureDayHeaderShown", "dismiss", "reloadDeparturesAfterError", "showCalendar", BuildConfig.FLAVOR, "splitTestShowRouteSwitchWithText", "SaleOnBoardContent", "(Ldk/molslinjen/domain/managers/saleOnBoard/SaleOnBoardRouteState;Ldk/molslinjen/domain/managers/departure/DepartureState;Ldk/molslinjen/ui/views/screens/booking/departures/DepartureTabState;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;ZLandroidx/compose/runtime/Composer;II)V", "FilterHeader", "(Lkotlin/jvm/functions/Function0;Ldk/molslinjen/domain/managers/saleOnBoard/SaleOnBoardRouteState;Lkotlin/jvm/functions/Function0;ZLandroidx/compose/runtime/Composer;I)V", "isSticky", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class SaleOnBoardDepartureSelectorScreenKt {
    private static final void FilterHeader(final Function0<Unit> function0, final SaleOnBoardRouteState saleOnBoardRouteState, final Function0<Unit> function02, final boolean z5, Composer composer, final int i5) {
        int i6;
        LocalizedSiteConfiguration configuration;
        Composer startRestartGroup = composer.startRestartGroup(592660775);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(function0) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changedInstance(saleOnBoardRouteState) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i6 |= startRestartGroup.changedInstance(function02) ? 256 : 128;
        }
        if ((i5 & 3072) == 0) {
            i6 |= startRestartGroup.changed(z5) ? 2048 : 1024;
        }
        if ((i6 & 1171) == 1170 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(592660775, i6, -1, "dk.molslinjen.ui.views.screens.saleOnBoard.selectDeparture.FilterHeader (SaleOnBoardDepartureSelectorScreen.kt:199)");
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            Brush.Companion companion2 = Brush.INSTANCE;
            Float valueOf = Float.valueOf(0.0f);
            AppColor appColor = AppColor.INSTANCE;
            float f5 = 24;
            Modifier m314paddingqDBjuR0 = PaddingKt.m314paddingqDBjuR0(SizeKt.fillMaxWidth$default(BackgroundKt.background$default(companion, Brush.Companion.m1466verticalGradient8A3gB4$default(companion2, new Pair[]{TuplesKt.to(valueOf, Color.m1481boximpl(appColor.m3259getBrandDarkBlue10d7_KjU())), TuplesKt.to(Float.valueOf(0.44f), Color.m1481boximpl(ColorKt.Color(4280040641L))), TuplesKt.to(Float.valueOf(1.0f), Color.m1481boximpl(ColorKt.Color(4279713462L)))}, 0.0f, 0.0f, 0, 14, (Object) null), null, 0.0f, 6, null), 0.0f, 1, null), Dp.m2599constructorimpl(f5), Dp.m2599constructorimpl(32), Dp.m2599constructorimpl(f5), Dp.m2599constructorimpl(f5));
            Arrangement arrangement = Arrangement.INSTANCE;
            Arrangement.Vertical top = arrangement.getTop();
            Alignment.Companion companion3 = Alignment.INSTANCE;
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(top, companion3.getStart(), startRestartGroup, 0);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, m314paddingqDBjuR0);
            ComposeUiNode.Companion companion4 = ComposeUiNode.INSTANCE;
            Function0<ComposeUiNode> constructor = companion4.getConstructor();
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
            Updater.m1227setimpl(m1226constructorimpl, columnMeasurePolicy, companion4.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion4.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion4.getSetCompositeKeyHash();
            if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion4.getSetModifier());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null);
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(arrangement.getSpaceBetween(), companion3.getCenterVertically(), startRestartGroup, 54);
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, fillMaxWidth$default);
            Function0<ComposeUiNode> constructor2 = companion4.getConstructor();
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
            Updater.m1227setimpl(m1226constructorimpl2, rowMeasurePolicy, companion4.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl2, currentCompositionLocalMap2, companion4.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = companion4.getSetCompositeKeyHash();
            if (m1226constructorimpl2.getInserting() || !Intrinsics.areEqual(m1226constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                m1226constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                m1226constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            Updater.m1227setimpl(m1226constructorimpl2, materializeModifier2, companion4.getSetModifier());
            TextKt.m940Text4IGK_g(StringResources_androidKt.stringResource(R.string.saleOnBoard_departureSelector_title, startRestartGroup, 6), RowScope.weight$default(RowScopeInstance.INSTANCE, companion, 1.0f, false, 2, null), appColor.m3281getWhite0d7_KjU(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getH2Bold(), startRestartGroup, 384, 1572864, 65528);
            int i7 = i6;
            NavigationButtonKt.NavigationButton(NavigationButtonType.Close, PaddingKt.m315paddingqDBjuR0$default(companion, Dp.m2599constructorimpl(16), 0.0f, 0.0f, 0.0f, 14, null), function0, startRestartGroup, ((i6 << 6) & 896) | 54, 0);
            startRestartGroup.endNode();
            SpacerKt.Spacer(SizeKt.m325height3ABfNKs(companion, Dp.m2599constructorimpl(f5)), startRestartGroup, 6);
            RouteDirectionGroup selectedRouteDirectionGroup = saleOnBoardRouteState != null ? saleOnBoardRouteState.getSelectedRouteDirectionGroup() : null;
            String lineLogoUrl = (saleOnBoardRouteState == null || (configuration = saleOnBoardRouteState.getConfiguration()) == null) ? null : configuration.getLineLogoUrl();
            startRestartGroup.startReplaceGroup(-2098712384);
            boolean z6 = (i7 & 896) == 256;
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (z6 || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function1() { // from class: l4.a
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit FilterHeader$lambda$13$lambda$12$lambda$11;
                        FilterHeader$lambda$13$lambda$12$lambda$11 = SaleOnBoardDepartureSelectorScreenKt.FilterHeader$lambda$13$lambda$12$lambda$11(Function0.this, (RouteDirection) obj);
                        return FilterHeader$lambda$13$lambda$12$lambda$11;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            RouteSelectorViewKt.RouteSelectorView(selectedRouteDirectionGroup, lineLogoUrl, (Function1) rememberedValue, function02, z5, startRestartGroup, (i7 << 3) & 64512);
            startRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: l4.b
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit FilterHeader$lambda$14;
                    FilterHeader$lambda$14 = SaleOnBoardDepartureSelectorScreenKt.FilterHeader$lambda$14(Function0.this, saleOnBoardRouteState, function02, z5, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return FilterHeader$lambda$14;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FilterHeader$lambda$13$lambda$12$lambda$11(Function0 function0, RouteDirection it) {
        Intrinsics.checkNotNullParameter(it, "it");
        function0.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FilterHeader$lambda$14(Function0 function0, SaleOnBoardRouteState saleOnBoardRouteState, Function0 function02, boolean z5, int i5, Composer composer, int i6) {
        FilterHeader(function0, saleOnBoardRouteState, function02, z5, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void SaleOnBoardContent(final SaleOnBoardRouteState saleOnBoardRouteState, final DepartureState departureState, final DepartureTabState departureTabState, final Function0<Unit> function0, final Function1<? super Departure, Unit> function1, final Function1<? super LocalDate, Unit> function12, final Function1<? super LocalDate, Unit> function13, final Function0<Unit> function02, final Function0<Unit> function03, final Function1<? super LocalDate, Unit> function14, final boolean z5, Composer composer, final int i5, final int i6) {
        int i7;
        int i8;
        boolean z6;
        LazyListState lazyListState;
        boolean z7;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(811583476);
        if ((i5 & 6) == 0) {
            i7 = (startRestartGroup.changedInstance(saleOnBoardRouteState) ? 4 : 2) | i5;
        } else {
            i7 = i5;
        }
        if ((i5 & 48) == 0) {
            i7 |= startRestartGroup.changedInstance(departureState) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i7 |= startRestartGroup.changedInstance(departureTabState) ? 256 : 128;
        }
        if ((i5 & 3072) == 0) {
            i7 |= startRestartGroup.changedInstance(function0) ? 2048 : 1024;
        }
        if ((i5 & 24576) == 0) {
            i7 |= startRestartGroup.changedInstance(function1) ? 16384 : 8192;
        }
        if ((196608 & i5) == 0) {
            i7 |= startRestartGroup.changedInstance(function12) ? 131072 : 65536;
        }
        if ((i5 & 1572864) == 0) {
            i7 |= startRestartGroup.changedInstance(function13) ? 1048576 : 524288;
        }
        if ((i5 & 12582912) == 0) {
            i7 |= startRestartGroup.changedInstance(function02) ? 8388608 : 4194304;
        }
        if ((i5 & 100663296) == 0) {
            i7 |= startRestartGroup.changedInstance(function03) ? 67108864 : 33554432;
        }
        if ((i5 & 805306368) == 0) {
            i7 |= startRestartGroup.changedInstance(function14) ? 536870912 : 268435456;
        }
        if ((i6 & 6) == 0) {
            i8 = i6 | (startRestartGroup.changed(z5) ? 4 : 2);
        } else {
            i8 = i6;
        }
        if ((i7 & 306783379) == 306783378 && (i8 & 3) == 2 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(811583476, i7, i8, "dk.molslinjen.ui.views.screens.saleOnBoard.selectDeparture.SaleOnBoardContent (SaleOnBoardDepartureSelectorScreen.kt:129)");
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            Alignment.Companion companion2 = Alignment.INSTANCE;
            MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(companion2.getTopStart(), false);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, companion);
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
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), companion2.getStart(), startRestartGroup, 0);
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
            Updater.m1227setimpl(m1226constructorimpl2, columnMeasurePolicy, companion3.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl2, currentCompositionLocalMap2, companion3.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = companion3.getSetCompositeKeyHash();
            if (m1226constructorimpl2.getInserting() || !Intrinsics.areEqual(m1226constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                m1226constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                m1226constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            Updater.m1227setimpl(m1226constructorimpl2, materializeModifier2, companion3.getSetModifier());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            int i9 = i7;
            FilterHeader(function02, saleOnBoardRouteState, function0, z5, startRestartGroup, ((i7 >> 21) & 14) | ((i7 << 3) & 112) | ((i7 >> 3) & 896) | ((i8 << 9) & 7168));
            final LazyListState rememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, startRestartGroup, 0, 3);
            Modifier m104backgroundbw27NRU$default = BackgroundKt.m104backgroundbw27NRU$default(SizeKt.fillMaxSize$default(companion, 0.0f, 1, null), AppColor.INSTANCE.m3269getGrey60d7_KjU(), null, 2, null);
            PaddingValues m310PaddingValuesa9UjIt4$default = PaddingKt.m310PaddingValuesa9UjIt4$default(0.0f, 0.0f, 0.0f, Dp.m2599constructorimpl(24), 7, null);
            startRestartGroup.startReplaceGroup(1798458550);
            boolean changedInstance = startRestartGroup.changedInstance(saleOnBoardRouteState) | startRestartGroup.changed(rememberLazyListState) | startRestartGroup.changedInstance(departureState) | ((i9 & 1879048192) == 536870912) | ((i9 & 458752) == 131072) | ((i9 & 3670016) == 1048576) | ((i9 & 57344) == 16384) | startRestartGroup.changedInstance(departureTabState);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                z6 = true;
                lazyListState = rememberLazyListState;
                z7 = false;
                Function1 function15 = new Function1() { // from class: l4.e
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit SaleOnBoardContent$lambda$8$lambda$5$lambda$4$lambda$3;
                        SaleOnBoardContent$lambda$8$lambda$5$lambda$4$lambda$3 = SaleOnBoardDepartureSelectorScreenKt.SaleOnBoardContent$lambda$8$lambda$5$lambda$4$lambda$3(SaleOnBoardRouteState.this, rememberLazyListState, departureState, function12, function13, function1, function14, departureTabState, (LazyListScope) obj);
                        return SaleOnBoardContent$lambda$8$lambda$5$lambda$4$lambda$3;
                    }
                };
                startRestartGroup.updateRememberedValue(function15);
                rememberedValue = function15;
            } else {
                z6 = true;
                lazyListState = rememberLazyListState;
                z7 = false;
            }
            startRestartGroup.endReplaceGroup();
            composer2 = startRestartGroup;
            LazyDslKt.LazyColumn(m104backgroundbw27NRU$default, lazyListState, m310PaddingValuesa9UjIt4$default, false, null, null, null, false, (Function1) rememberedValue, composer2, 390, 248);
            composer2.endNode();
            composer2.startReplaceGroup(593091381);
            if (departureTabState.getShowLoadDepartureError()) {
                composer2.startReplaceGroup(593094689);
                if ((i9 & 234881024) != 67108864) {
                    z6 = z7;
                }
                Object rememberedValue2 = composer2.rememberedValue();
                if (z6 || rememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    rememberedValue2 = new Function1() { // from class: l4.f
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            Unit SaleOnBoardContent$lambda$8$lambda$7$lambda$6;
                            SaleOnBoardContent$lambda$8$lambda$7$lambda$6 = SaleOnBoardDepartureSelectorScreenKt.SaleOnBoardContent$lambda$8$lambda$7$lambda$6(Function0.this, (DepartureDirection) obj);
                            return SaleOnBoardContent$lambda$8$lambda$7$lambda$6;
                        }
                    };
                    composer2.updateRememberedValue(rememberedValue2);
                }
                composer2.endReplaceGroup();
                DepartureErrorViewKt.DepartureErrorView(boxScopeInstance, (Function1) rememberedValue2, DepartureDirection.Outbound, composer2, 390);
            }
            composer2.endReplaceGroup();
            composer2.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: l4.g
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit SaleOnBoardContent$lambda$9;
                    SaleOnBoardContent$lambda$9 = SaleOnBoardDepartureSelectorScreenKt.SaleOnBoardContent$lambda$9(SaleOnBoardRouteState.this, departureState, departureTabState, function0, function1, function12, function13, function02, function03, function14, z5, i5, i6, (Composer) obj, ((Integer) obj2).intValue());
                    return SaleOnBoardContent$lambda$9;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SaleOnBoardContent$lambda$8$lambda$5$lambda$4$lambda$3(SaleOnBoardRouteState saleOnBoardRouteState, LazyListState lazyListState, DepartureState departureState, Function1 function1, Function1 function12, Function1 function13, Function1 function14, final DepartureTabState departureTabState, LazyListScope LazyColumn) {
        Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
        IndexHolder indexHolder = new IndexHolder(0, 1, null);
        ItemIndexedKt.stickyHeaderIndexed$default(LazyColumn, indexHolder, null, null, ComposableLambdaKt.composableLambdaInstance(-1448954144, true, new SaleOnBoardDepartureSelectorScreenKt$SaleOnBoardContent$1$1$1$1$1(saleOnBoardRouteState, lazyListState, departureState, function14)), 6, null);
        ItemIndexedKt.itemIndexed$default(LazyColumn, indexHolder, null, null, ComposableSingletons$SaleOnBoardDepartureSelectorScreenKt.INSTANCE.m3538getLambda1$app_kombardoProd(), 6, null);
        DepartureItemsViewKt.departureItemsView(LazyColumn, departureState, saleOnBoardRouteState != null ? saleOnBoardRouteState.getSelectedStartDate() : null, indexHolder, lazyListState.getFirstVisibleItemIndex(), (r21 & 16) != 0 ? false : true, (r21 & 32) != 0, function1, function12, function13);
        ItemIndexedKt.itemIndexed$default(LazyColumn, indexHolder, null, null, ComposableLambdaKt.composableLambdaInstance(1142866694, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.saleOnBoard.selectDeparture.SaleOnBoardDepartureSelectorScreenKt$SaleOnBoardContent$1$1$1$1$2
            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Integer num, Composer composer, Integer num2) {
                invoke(lazyItemScope, num.intValue(), composer, num2.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(LazyItemScope itemIndexed, int i5, Composer composer, int i6) {
                Intrinsics.checkNotNullParameter(itemIndexed, "$this$itemIndexed");
                if ((i6 & 129) == 128 && composer.getSkipping()) {
                    composer.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1142866694, i6, -1, "dk.molslinjen.ui.views.screens.saleOnBoard.selectDeparture.SaleOnBoardContent.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SaleOnBoardDepartureSelectorScreen.kt:183)");
                }
                LoadingComponentKt.m3392LoadingComponentjfnsLPA(null, 0.0f, DepartureTabState.this.getIsLoading(), 0, false, null, ComposableSingletons$SaleOnBoardDepartureSelectorScreenKt.INSTANCE.m3539getLambda2$app_kombardoProd(), composer, 1572864, 59);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }), 6, null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SaleOnBoardContent$lambda$8$lambda$7$lambda$6(Function0 function0, DepartureDirection it) {
        Intrinsics.checkNotNullParameter(it, "it");
        function0.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SaleOnBoardContent$lambda$9(SaleOnBoardRouteState saleOnBoardRouteState, DepartureState departureState, DepartureTabState departureTabState, Function0 function0, Function1 function1, Function1 function12, Function1 function13, Function0 function02, Function0 function03, Function1 function14, boolean z5, int i5, int i6, Composer composer, int i7) {
        SaleOnBoardContent(saleOnBoardRouteState, departureState, departureTabState, function0, function1, function12, function13, function02, function03, function14, z5, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1), RecomposeScopeImplKt.updateChangedFlags(i6));
        return Unit.INSTANCE;
    }

    public static final void SaleOnBoardDepartureSelectorScreen(final SaleOnBoardDepartureSelectorViewModel viewModel, final DestinationsNavigator navigator, final ResultRecipient<CalendarScreenDestination, LocalDate> calendarResultRecipient, Composer composer, final int i5) {
        int i6;
        Composer composer2;
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(navigator, "navigator");
        Intrinsics.checkNotNullParameter(calendarResultRecipient, "calendarResultRecipient");
        Composer startRestartGroup = composer.startRestartGroup(50328674);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(viewModel) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changed(navigator) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i6 |= startRestartGroup.changed(calendarResultRecipient) ? 256 : 128;
        }
        if ((i6 & 147) == 146 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(50328674, i6, -1, "dk.molslinjen.ui.views.screens.saleOnBoard.selectDeparture.SaleOnBoardDepartureSelectorScreen (SaleOnBoardDepartureSelectorScreen.kt:70)");
            }
            SaleOnBoardRouteState saleOnBoardRouteState = (SaleOnBoardRouteState) SnapshotStateKt.collectAsState(viewModel.getRouteState(), null, startRestartGroup, 0, 1).getValue();
            DepartureState departureState = (DepartureState) SnapshotStateKt.collectAsState(viewModel.getDepartureState(), null, startRestartGroup, 0, 1).getValue();
            DepartureTabState departureTabState = (DepartureTabState) SnapshotStateKt.collectAsState(viewModel.getDepartureTabState(), null, startRestartGroup, 0, 1).getValue();
            startRestartGroup.startReplaceGroup(-80970708);
            boolean changedInstance = startRestartGroup.changedInstance(viewModel);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changedInstance || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function1() { // from class: l4.c
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit SaleOnBoardDepartureSelectorScreen$lambda$1$lambda$0;
                        SaleOnBoardDepartureSelectorScreen$lambda$1$lambda$0 = SaleOnBoardDepartureSelectorScreenKt.SaleOnBoardDepartureSelectorScreen$lambda$1$lambda$0(SaleOnBoardDepartureSelectorViewModel.this, (LocalDate) obj);
                        return SaleOnBoardDepartureSelectorScreen$lambda$1$lambda$0;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            OpenResultRecipientKt.onResult(calendarResultRecipient, null, (Function1) rememberedValue, startRestartGroup, (i6 >> 6) & 14, 1);
            composer2 = startRestartGroup;
            BottomSheetContainerKt.m3399BottomSheetContainerZO57_FM(SizeKt.fillMaxHeight$default(Modifier.INSTANCE, 0.0f, 1, null), 0.0f, null, null, 0L, null, null, null, null, ComposableLambdaKt.rememberComposableLambda(-929090443, true, new SaleOnBoardDepartureSelectorScreenKt$SaleOnBoardDepartureSelectorScreen$2(saleOnBoardRouteState, departureState, departureTabState, viewModel, navigator), startRestartGroup, 54), composer2, 805306758, 506);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: l4.d
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit SaleOnBoardDepartureSelectorScreen$lambda$2;
                    SaleOnBoardDepartureSelectorScreen$lambda$2 = SaleOnBoardDepartureSelectorScreenKt.SaleOnBoardDepartureSelectorScreen$lambda$2(SaleOnBoardDepartureSelectorViewModel.this, navigator, calendarResultRecipient, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return SaleOnBoardDepartureSelectorScreen$lambda$2;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SaleOnBoardDepartureSelectorScreen$lambda$1$lambda$0(SaleOnBoardDepartureSelectorViewModel saleOnBoardDepartureSelectorViewModel, LocalDate selectedDate) {
        Intrinsics.checkNotNullParameter(selectedDate, "selectedDate");
        saleOnBoardDepartureSelectorViewModel.dateSelected(selectedDate);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SaleOnBoardDepartureSelectorScreen$lambda$2(SaleOnBoardDepartureSelectorViewModel saleOnBoardDepartureSelectorViewModel, DestinationsNavigator destinationsNavigator, ResultRecipient resultRecipient, int i5, Composer composer, int i6) {
        SaleOnBoardDepartureSelectorScreen(saleOnBoardDepartureSelectorViewModel, destinationsNavigator, resultRecipient, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }
}
