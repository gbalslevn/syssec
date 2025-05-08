package dk.molslinjen.ui.views.screens.booking.ticketType;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
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
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Dp;
import com.ramcosta.composedestinations.spec.Direction;
import dk.molslinjen.domain.model.booking.BookingType;
import dk.molslinjen.domain.model.booking.Departure;
import dk.molslinjen.domain.model.booking.DepartureDirection;
import dk.molslinjen.domain.model.booking.DepartureTicket;
import dk.molslinjen.domain.model.booking.RouteType;
import dk.molslinjen.domain.model.booking.TicketCategory;
import dk.molslinjen.domain.model.booking.TicketDescriptionItem;
import dk.molslinjen.domain.model.config.Subline;
import dk.molslinjen.domain.model.shared.Price;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.theme.AppColor;
import dk.molslinjen.ui.theme.ThemeShapesKt;
import dk.molslinjen.ui.theme.TypographyKt;
import dk.molslinjen.ui.views.reusable.HorizontalDividerKt;
import dk.molslinjen.ui.views.reusable.InfoBoxViewKt;
import dk.molslinjen.ui.views.reusable.bottomsheet.BottomSheetContainerKt;
import dk.molslinjen.ui.views.screens.booking.shared.kombardoTravelDetails.KombardoTravelDetailsViewKt;
import dk.molslinjen.ui.views.screens.booking.shared.kombardoTravelDetails.TravelDetailsState;
import dk.molslinjen.ui.views.screens.booking.ticketType.TicketTypeKombardoScreenKt;
import dk.molslinjen.ui.views.screens.booking.ticketType.TicketTypeKombardoViewModel;
import dk.molslinjen.ui.views.shared.components.PriceTextKt;
import dk.molslinjen.ui.views.shared.components.PriceViewType;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\u001a?\u0010\t\u001a\u00020\u00032\u0006\u0010\u0001\u001a\u00020\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0018\u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00030\u0005H\u0007¢\u0006\u0004\b\t\u0010\n\u001a#\u0010\u0010\u001a\u00020\u0003*\u00020\u000b2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0003¢\u0006\u0004\b\u0010\u0010\u0011\u001a\u0017\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0012H\u0003¢\u0006\u0004\b\u0014\u0010\u0015\u001a\u001d\u0010\u0019\u001a\u00020\u00032\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016H\u0003¢\u0006\u0004\b\u0019\u0010\u001a\u001a\u000f\u0010\u001b\u001a\u00020\u0003H\u0003¢\u0006\u0004\b\u001b\u0010\u001c¨\u0006\u001d"}, d2 = {"Ldk/molslinjen/ui/views/screens/booking/ticketType/TicketTypeKombardoViewModel;", "viewModel", "Lkotlin/Function0;", BuildConfig.FLAVOR, "dismiss", "Lkotlin/Function2;", "Lcom/ramcosta/composedestinations/spec/Direction;", BuildConfig.FLAVOR, "proceed", "TicketTypeKombardoScreen", "(Ldk/molslinjen/ui/views/screens/booking/ticketType/TicketTypeKombardoViewModel;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "Landroidx/compose/foundation/layout/ColumnScope;", "Ldk/molslinjen/ui/views/screens/booking/ticketType/TicketTypeKombardoViewModel$ViewState;", "viewState", "Ldk/molslinjen/ui/views/screens/booking/shared/kombardoTravelDetails/IKombardoTravelDetailsHandler$TravelDetailsState;", "state", "TicketTypeContent", "(Landroidx/compose/foundation/layout/ColumnScope;Ldk/molslinjen/ui/views/screens/booking/ticketType/TicketTypeKombardoViewModel$ViewState;Ldk/molslinjen/ui/views/screens/booking/shared/kombardoTravelDetails/IKombardoTravelDetailsHandler$TravelDetailsState;Landroidx/compose/runtime/Composer;I)V", "Ldk/molslinjen/domain/model/booking/Departure;", "departure", "TicketPriceRow", "(Ldk/molslinjen/domain/model/booking/Departure;Landroidx/compose/runtime/Composer;I)V", BuildConfig.FLAVOR, "Ldk/molslinjen/domain/model/booking/TicketDescriptionItem;", "descriptionItems", "TermsSection", "(Ljava/util/List;Landroidx/compose/runtime/Composer;I)V", "ShuttleInfoBar", "(Landroidx/compose/runtime/Composer;I)V", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class TicketTypeKombardoScreenKt {
    private static final void ShuttleInfoBar(Composer composer, final int i5) {
        Composer startRestartGroup = composer.startRestartGroup(-1778946081);
        if (i5 == 0 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1778946081, i5, -1, "dk.molslinjen.ui.views.screens.booking.ticketType.ShuttleInfoBar (TicketTypeKombardoScreen.kt:186)");
            }
            InfoBoxViewKt.InfoBoxView(SizeKt.fillMaxWidth$default(PaddingKt.m311padding3ABfNKs(Modifier.INSTANCE, Dp.m2599constructorimpl(24)), 0.0f, 1, null), R.drawable.icon_alert_warning, StringResources_androidKt.stringResource(R.string.ticketInfo_shuttleBus, startRestartGroup, 6), false, startRestartGroup, 54, 8);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: i3.h
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit ShuttleInfoBar$lambda$12;
                    ShuttleInfoBar$lambda$12 = TicketTypeKombardoScreenKt.ShuttleInfoBar$lambda$12(i5, (Composer) obj, ((Integer) obj2).intValue());
                    return ShuttleInfoBar$lambda$12;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ShuttleInfoBar$lambda$12(int i5, Composer composer, int i6) {
        ShuttleInfoBar(composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    private static final void TermsSection(final List<TicketDescriptionItem> list, Composer composer, final int i5) {
        int i6;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(406294923);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(list) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i6 & 3) == 2 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(406294923, i6, -1, "dk.molslinjen.ui.views.screens.booking.ticketType.TermsSection (TicketTypeKombardoScreen.kt:163)");
            }
            float f5 = 24;
            Modifier m311padding3ABfNKs = PaddingKt.m311padding3ABfNKs(BorderKt.m108borderxT4_qwU(PaddingKt.m311padding3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m2599constructorimpl(f5)), Dp.m2599constructorimpl(1), AppColor.INSTANCE.m3268getGrey50d7_KjU(), ThemeShapesKt.getThemeShapes().getMedium()), Dp.m2599constructorimpl(f5));
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.m265spacedBy0680j_4(Dp.m2599constructorimpl(16)), Alignment.INSTANCE.getStart(), startRestartGroup, 6);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, m311padding3ABfNKs);
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
            TextKt.m940Text4IGK_g(StringResources_androidKt.stringResource(R.string.ticketType_termsTitle, startRestartGroup, 6), null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getParagraphSmallBold(), startRestartGroup, 0, 1572864, 65534);
            composer2 = startRestartGroup;
            TicketTermsListKt.m3473TicketTermsListbMFp3s(list, null, composer2, (i6 & 14) | 48);
            composer2.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: i3.f
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit TermsSection$lambda$11;
                    TermsSection$lambda$11 = TicketTypeKombardoScreenKt.TermsSection$lambda$11(list, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return TermsSection$lambda$11;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TermsSection$lambda$11(List list, int i5, Composer composer, int i6) {
        TermsSection(list, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    private static final void TicketPriceRow(final Departure departure, Composer composer, final int i5) {
        int i6;
        Unit unit;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(244206024);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(departure) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i6 & 3) == 2 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(244206024, i6, -1, "dk.molslinjen.ui.views.screens.booking.ticketType.TicketPriceRow (TicketTypeKombardoScreen.kt:130)");
            }
            HorizontalDividerKt.m3388HorizontalDividertZIQpXc(null, 0L, 0.0f, null, startRestartGroup, 0, 15);
            Modifier.Companion companion = Modifier.INSTANCE;
            Modifier m312paddingVpY3zN4 = PaddingKt.m312paddingVpY3zN4(BackgroundKt.m104backgroundbw27NRU$default(SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null), AppColor.INSTANCE.m3269getGrey60d7_KjU(), null, 2, null), Dp.m2599constructorimpl(24), Dp.m2599constructorimpl(16));
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.INSTANCE.getCenterVertically(), startRestartGroup, 48);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, m312paddingVpY3zN4);
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
            TextKt.m940Text4IGK_g(StringResources_androidKt.stringResource(R.string.ticketInfo_ticketPrice, startRestartGroup, 6), null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getSub(), startRestartGroup, 0, 1572864, 65534);
            SpacerKt.Spacer(SizeKt.m336width3ABfNKs(companion, Dp.m2599constructorimpl(8)), startRestartGroup, 6);
            TextStyle subBold = TypographyKt.getSubBold();
            Price fromPrice = departure.getFromPrice();
            startRestartGroup.startReplaceGroup(2090934801);
            if (fromPrice == null) {
                unit = null;
            } else {
                PriceTextKt.m3557PriceText1y9Plug(fromPrice, (Modifier) null, (PriceViewType) null, false, subBold, (TextAlign) null, 0, 0L, startRestartGroup, 24576, 238);
                unit = Unit.INSTANCE;
            }
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(2090934264);
            if (unit == null) {
                composer2 = startRestartGroup;
                TextKt.m940Text4IGK_g("-", null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, subBold, composer2, 6, 1572864, 65534);
            } else {
                composer2 = startRestartGroup;
            }
            composer2.endReplaceGroup();
            composer2.endNode();
            HorizontalDividerKt.m3388HorizontalDividertZIQpXc(null, 0L, 0.0f, null, composer2, 0, 15);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: i3.g
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit TicketPriceRow$lambda$9;
                    TicketPriceRow$lambda$9 = TicketTypeKombardoScreenKt.TicketPriceRow$lambda$9(Departure.this, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return TicketPriceRow$lambda$9;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TicketPriceRow$lambda$9(Departure departure, int i5, Composer composer, int i6) {
        TicketPriceRow(departure, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void TicketTypeContent(final ColumnScope columnScope, final TicketTypeKombardoViewModel.ViewState viewState, final TravelDetailsState travelDetailsState, Composer composer, final int i5) {
        int i6;
        List<TicketDescriptionItem> emptyList;
        TicketCategory category;
        Composer startRestartGroup = composer.startRestartGroup(648764493);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changed(columnScope) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changedInstance(viewState) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i6 |= startRestartGroup.changedInstance(travelDetailsState) ? 256 : 128;
        }
        if ((i6 & 147) == 146 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(648764493, i6, -1, "dk.molslinjen.ui.views.screens.booking.ticketType.TicketTypeContent (TicketTypeKombardoScreen.kt:102)");
            }
            Departure departure = viewState.getDeparture();
            if (departure == null) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
                if (endRestartGroup != null) {
                    endRestartGroup.updateScope(new Function2() { // from class: i3.c
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            Unit TicketTypeContent$lambda$1;
                            TicketTypeContent$lambda$1 = TicketTypeKombardoScreenKt.TicketTypeContent$lambda$1(ColumnScope.this, viewState, travelDetailsState, i5, (Composer) obj, ((Integer) obj2).intValue());
                            return TicketTypeContent$lambda$1;
                        }
                    });
                    return;
                }
                return;
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            Modifier weight = columnScope.weight(ScrollKt.verticalScroll$default(companion, ScrollKt.rememberScrollState(0, startRestartGroup, 0, 1), false, null, false, 14, null), 1.0f, false);
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), startRestartGroup, 0);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, weight);
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
            startRestartGroup.startReplaceGroup(-756332412);
            if (viewState.getDeparture().getRouteType() == RouteType.Shuttle) {
                ShuttleInfoBar(startRestartGroup, 0);
            }
            startRestartGroup.endReplaceGroup();
            Modifier m311padding3ABfNKs = PaddingKt.m311padding3ABfNKs(BackgroundKt.m104backgroundbw27NRU$default(SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null), AppColor.INSTANCE.m3269getGrey60d7_KjU(), null, 2, null), Dp.m2599constructorimpl(24));
            List<Step> detailSteps = travelDetailsState.getDetailSteps();
            Subline subline = viewState.getSubline();
            startRestartGroup.startReplaceGroup(-756318874);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function1() { // from class: i3.d
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit TicketTypeContent$lambda$4$lambda$3$lambda$2;
                        TicketTypeContent$lambda$4$lambda$3$lambda$2 = TicketTypeKombardoScreenKt.TicketTypeContent$lambda$4$lambda$3$lambda$2((String) obj);
                        return TicketTypeContent$lambda$4$lambda$3$lambda$2;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            KombardoTravelDetailsViewKt.KombardoTravelDetailsView(m311padding3ABfNKs, detailSteps, false, false, (Function1) rememberedValue, subline, startRestartGroup, 24966, 8);
            TicketPriceRow(departure, startRestartGroup, 0);
            DepartureTicket departureTicket = (DepartureTicket) CollectionsKt.firstOrNull((List) departure.getTickets());
            if (departureTicket == null || (category = departureTicket.getCategory()) == null || (emptyList = category.getDescriptionItems()) == null) {
                emptyList = CollectionsKt.emptyList();
            }
            TermsSection(emptyList, startRestartGroup, 0);
            startRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup2 = startRestartGroup.endRestartGroup();
        if (endRestartGroup2 != null) {
            endRestartGroup2.updateScope(new Function2() { // from class: i3.e
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit TicketTypeContent$lambda$5;
                    TicketTypeContent$lambda$5 = TicketTypeKombardoScreenKt.TicketTypeContent$lambda$5(ColumnScope.this, viewState, travelDetailsState, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return TicketTypeContent$lambda$5;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TicketTypeContent$lambda$1(ColumnScope columnScope, TicketTypeKombardoViewModel.ViewState viewState, TravelDetailsState travelDetailsState, int i5, Composer composer, int i6) {
        TicketTypeContent(columnScope, viewState, travelDetailsState, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TicketTypeContent$lambda$4$lambda$3$lambda$2(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TicketTypeContent$lambda$5(ColumnScope columnScope, TicketTypeKombardoViewModel.ViewState viewState, TravelDetailsState travelDetailsState, int i5, Composer composer, int i6) {
        TicketTypeContent(columnScope, viewState, travelDetailsState, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    public static final void TicketTypeKombardoScreen(final TicketTypeKombardoViewModel viewModel, final Function0<Unit> dismiss, final Function2<? super Direction, ? super Boolean, Unit> proceed, Composer composer, final int i5) {
        int i6;
        String stringResource;
        AnnotatedString annotatedString;
        Composer composer2;
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(dismiss, "dismiss");
        Intrinsics.checkNotNullParameter(proceed, "proceed");
        Composer startRestartGroup = composer.startRestartGroup(337561665);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(viewModel) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changedInstance(dismiss) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i6 |= startRestartGroup.changedInstance(proceed) ? 256 : 128;
        }
        if ((i6 & 147) == 146 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(337561665, i6, -1, "dk.molslinjen.ui.views.screens.booking.ticketType.TicketTypeKombardoScreen (TicketTypeKombardoScreen.kt:53)");
            }
            final TicketTypeKombardoViewModel.ViewState viewState = (TicketTypeKombardoViewModel.ViewState) SnapshotStateKt.collectAsState(viewModel.getViewState(), null, startRestartGroup, 0, 1).getValue();
            final TravelDetailsState travelDetailsState = (TravelDetailsState) SnapshotStateKt.collectAsState(viewModel.getTravelDetailsState(), null, startRestartGroup, 0, 1).getValue();
            if (viewState.getBookingType() == BookingType.Single) {
                startRestartGroup.startReplaceGroup(-2042008619);
                annotatedString = new AnnotatedString(StringResources_androidKt.stringResource(R.string.ticketType_kombardo_title, startRestartGroup, 6), null, null, 6, null);
                startRestartGroup.endReplaceGroup();
            } else {
                startRestartGroup.startReplaceGroup(-2041895221);
                if (viewState.getDepartureDirection() == DepartureDirection.Outbound) {
                    startRestartGroup.startReplaceGroup(-2041821379);
                    stringResource = StringResources_androidKt.stringResource(R.string.departures_return_outbound, startRestartGroup, 6);
                    startRestartGroup.endReplaceGroup();
                } else {
                    startRestartGroup.startReplaceGroup(-2041736129);
                    stringResource = StringResources_androidKt.stringResource(R.string.departures_return_return, startRestartGroup, 6);
                    startRestartGroup.endReplaceGroup();
                }
                String lowerCase = stringResource.toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                String stringResource2 = StringResources_androidKt.stringResource(R.string.ticketType_kombardo_twoWay_title, new Object[]{lowerCase}, startRestartGroup, 6);
                int indexOf$default = StringsKt.indexOf$default((CharSequence) stringResource2, lowerCase, 0, false, 6, (Object) null);
                annotatedString = new AnnotatedString(stringResource2, CollectionsKt.mutableListOf(new AnnotatedString.Range(new SpanStyle(AppColor.INSTANCE.m3255getBrandBlue10d7_KjU(), 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, null, 65534, null), indexOf$default, lowerCase.length() + indexOf$default)), null, 4, null);
                startRestartGroup.endReplaceGroup();
            }
            composer2 = startRestartGroup;
            BottomSheetContainerKt.m3398BottomSheetContainer8Un_QVk(null, 0.0f, 0L, annotatedString, null, null, dismiss, null, ComposableLambdaKt.rememberComposableLambda(1378189823, true, new TicketTypeKombardoScreenKt$TicketTypeKombardoScreen$1(viewState, viewModel, proceed), startRestartGroup, 54), ComposableLambdaKt.rememberComposableLambda(-1980185394, true, new Function3<ColumnScope, Composer, Integer, Unit>() { // from class: dk.molslinjen.ui.views.screens.booking.ticketType.TicketTypeKombardoScreenKt$TicketTypeKombardoScreen$2
                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(ColumnScope columnScope, Composer composer3, Integer num) {
                    invoke(columnScope, composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(ColumnScope BottomSheetContainer, Composer composer3, int i7) {
                    Intrinsics.checkNotNullParameter(BottomSheetContainer, "$this$BottomSheetContainer");
                    if ((i7 & 6) == 0) {
                        i7 |= composer3.changed(BottomSheetContainer) ? 4 : 2;
                    }
                    if ((i7 & 19) == 18 && composer3.getSkipping()) {
                        composer3.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1980185394, i7, -1, "dk.molslinjen.ui.views.screens.booking.ticketType.TicketTypeKombardoScreen.<anonymous> (TicketTypeKombardoScreen.kt:94)");
                    }
                    TicketTypeKombardoScreenKt.TicketTypeContent(BottomSheetContainer, TicketTypeKombardoViewModel.ViewState.this, travelDetailsState, composer3, i7 & 14);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, startRestartGroup, 54), startRestartGroup, ((i6 << 15) & 3670016) | 905969664, 183);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: i3.b
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit TicketTypeKombardoScreen$lambda$0;
                    TicketTypeKombardoScreen$lambda$0 = TicketTypeKombardoScreenKt.TicketTypeKombardoScreen$lambda$0(TicketTypeKombardoViewModel.this, dismiss, proceed, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return TicketTypeKombardoScreen$lambda$0;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TicketTypeKombardoScreen$lambda$0(TicketTypeKombardoViewModel ticketTypeKombardoViewModel, Function0 function0, Function2 function2, int i5, Composer composer, int i6) {
        TicketTypeKombardoScreen(ticketTypeKombardoViewModel, function0, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }
}
