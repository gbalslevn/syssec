package dk.molslinjen.ui.views.screens.saleOnBoard;

import androidx.compose.foundation.BackgroundKt;
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
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.OnGloballyPositionedModifierKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntSize;
import dk.molslinjen.core.extensions.AccessibilityKt;
import dk.molslinjen.domain.extensions.LocalDateTimeExtensionsKt;
import dk.molslinjen.domain.model.booking.BookingHeader;
import dk.molslinjen.domain.model.booking.IDepartureInfo;
import dk.molslinjen.extensions.ComposeExtensionsKt;
import dk.molslinjen.extensions.domain.TicketCategoryExtensionsKt;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.theme.AppColor;
import dk.molslinjen.ui.theme.ThemeShapesKt;
import dk.molslinjen.ui.theme.TypographyKt;
import dk.molslinjen.ui.views.reusable.HorizontalDividerKt;
import dk.molslinjen.ui.views.reusable.buttons.PrimaryButtonKt;
import dk.molslinjen.ui.views.reusable.ticket.TicketBackgroundViewKt;
import dk.molslinjen.ui.views.screens.booking.departures.rows.departure.DepartureInfoSectionViewKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SaleOnBoardScreenKt$nextDepartureTicket$1 implements Function3<LazyItemScope, Composer, Integer, Unit> {
    final /* synthetic */ BookingHeader $bookingHeader;
    final /* synthetic */ Function1<IDepartureInfo, Unit> $orderFood;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public SaleOnBoardScreenKt$nextDepartureTicket$1(BookingHeader bookingHeader, Function1<? super IDepartureInfo, Unit> function1) {
        this.$bookingHeader = bookingHeader;
        this.$orderFood = function1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$10$lambda$2$lambda$1(MutableIntState mutableIntState, LayoutCoordinates it) {
        Intrinsics.checkNotNullParameter(it, "it");
        mutableIntState.setValue(IntSize.m2660getHeightimpl(it.mo1948getSizeYbymL2g()));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$10$lambda$9$lambda$8$lambda$5$lambda$4$lambda$3(String str, BookingHeader bookingHeader, SemanticsPropertyReceiver semantics) {
        Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
        SemanticsPropertiesKt.setContentDescription(semantics, str + " " + AccessibilityKt.splitNumberForAccessibility(bookingHeader.getReservationId()));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit invoke$lambda$10$lambda$9$lambda$8$lambda$7$lambda$6(Function1 function1, BookingHeader bookingHeader) {
        function1.invoke(bookingHeader);
        return Unit.INSTANCE;
    }

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
            ComposerKt.traceEventStart(1419067530, i5, -1, "dk.molslinjen.ui.views.screens.saleOnBoard.nextDepartureTicket.<anonymous> (SaleOnBoardScreen.kt:209)");
        }
        final BookingHeader bookingHeader = this.$bookingHeader;
        final Function1<IDepartureInfo, Unit> function1 = this.$orderFood;
        Modifier.Companion companion = Modifier.INSTANCE;
        Alignment.Companion companion2 = Alignment.INSTANCE;
        MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(companion2.getTopStart(), false);
        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
        CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
        Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer, companion);
        ComposeUiNode.Companion companion3 = ComposeUiNode.INSTANCE;
        Function0<ComposeUiNode> constructor = companion3.getConstructor();
        if (composer.getApplier() == null) {
            ComposablesKt.invalidApplier();
        }
        composer.startReusableNode();
        if (composer.getInserting()) {
            composer.createNode(constructor);
        } else {
            composer.useNode();
        }
        Composer m1226constructorimpl = Updater.m1226constructorimpl(composer);
        Updater.m1227setimpl(m1226constructorimpl, maybeCachedBoxMeasurePolicy, companion3.getSetMeasurePolicy());
        Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion3.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion3.getSetCompositeKeyHash();
        if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
            m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
            m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
        }
        Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion3.getSetModifier());
        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
        composer.startReplaceGroup(1040063289);
        Object rememberedValue = composer.rememberedValue();
        Composer.Companion companion4 = Composer.INSTANCE;
        if (rememberedValue == companion4.getEmpty()) {
            rememberedValue = SnapshotIntStateKt.mutableIntStateOf(0);
            composer.updateRememberedValue(rememberedValue);
        }
        final MutableIntState mutableIntState = (MutableIntState) rememberedValue;
        composer.endReplaceGroup();
        TicketBackgroundViewKt.TicketBackgroundView(SizeKt.m325height3ABfNKs(companion, ComposeExtensionsKt.pxToDp(mutableIntState.getValue().intValue(), composer, 0)), false, false, false, false, false, composer, 196656, 28);
        Modifier height = IntrinsicKt.height(companion, IntrinsicSize.Max);
        composer.startReplaceGroup(1040075001);
        Object rememberedValue2 = composer.rememberedValue();
        if (rememberedValue2 == companion4.getEmpty()) {
            rememberedValue2 = new Function1() { // from class: dk.molslinjen.ui.views.screens.saleOnBoard.h
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit invoke$lambda$10$lambda$2$lambda$1;
                    invoke$lambda$10$lambda$2$lambda$1 = SaleOnBoardScreenKt$nextDepartureTicket$1.invoke$lambda$10$lambda$2$lambda$1(MutableIntState.this, (LayoutCoordinates) obj);
                    return invoke$lambda$10$lambda$2$lambda$1;
                }
            };
            composer.updateRememberedValue(rememberedValue2);
        }
        composer.endReplaceGroup();
        Modifier clip = ClipKt.clip(OnGloballyPositionedModifierKt.onGloballyPositioned(height, (Function1) rememberedValue2), ThemeShapesKt.getThemeShapes().getMedium());
        Arrangement arrangement = Arrangement.INSTANCE;
        MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(arrangement.getStart(), companion2.getTop(), composer, 0);
        int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
        CompositionLocalMap currentCompositionLocalMap2 = composer.getCurrentCompositionLocalMap();
        Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(composer, clip);
        Function0<ComposeUiNode> constructor2 = companion3.getConstructor();
        if (composer.getApplier() == null) {
            ComposablesKt.invalidApplier();
        }
        composer.startReusableNode();
        if (composer.getInserting()) {
            composer.createNode(constructor2);
        } else {
            composer.useNode();
        }
        Composer m1226constructorimpl2 = Updater.m1226constructorimpl(composer);
        Updater.m1227setimpl(m1226constructorimpl2, rowMeasurePolicy, companion3.getSetMeasurePolicy());
        Updater.m1227setimpl(m1226constructorimpl2, currentCompositionLocalMap2, companion3.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = companion3.getSetCompositeKeyHash();
        if (m1226constructorimpl2.getInserting() || !Intrinsics.areEqual(m1226constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
            m1226constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
            m1226constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
        }
        Updater.m1227setimpl(m1226constructorimpl2, materializeModifier2, companion3.getSetModifier());
        RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
        BoxKt.Box(BackgroundKt.m104backgroundbw27NRU$default(SizeKt.fillMaxHeight$default(SizeKt.m336width3ABfNKs(companion, Dp.m2599constructorimpl(8)), 0.0f, 1, null), TicketCategoryExtensionsKt.getColor(bookingHeader.getTicketCategory()), null, 2, null), composer, 0);
        float f5 = 16;
        Modifier m311padding3ABfNKs = PaddingKt.m311padding3ABfNKs(companion, Dp.m2599constructorimpl(f5));
        MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(arrangement.getTop(), companion2.getStart(), composer, 0);
        int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
        CompositionLocalMap currentCompositionLocalMap3 = composer.getCurrentCompositionLocalMap();
        Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(composer, m311padding3ABfNKs);
        Function0<ComposeUiNode> constructor3 = companion3.getConstructor();
        if (composer.getApplier() == null) {
            ComposablesKt.invalidApplier();
        }
        composer.startReusableNode();
        if (composer.getInserting()) {
            composer.createNode(constructor3);
        } else {
            composer.useNode();
        }
        Composer m1226constructorimpl3 = Updater.m1226constructorimpl(composer);
        Updater.m1227setimpl(m1226constructorimpl3, columnMeasurePolicy, companion3.getSetMeasurePolicy());
        Updater.m1227setimpl(m1226constructorimpl3, currentCompositionLocalMap3, companion3.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = companion3.getSetCompositeKeyHash();
        if (m1226constructorimpl3.getInserting() || !Intrinsics.areEqual(m1226constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
            m1226constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
            m1226constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
        }
        Updater.m1227setimpl(m1226constructorimpl3, materializeModifier3, companion3.getSetModifier());
        ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
        MeasurePolicy rowMeasurePolicy2 = RowKt.rowMeasurePolicy(arrangement.getStart(), companion2.getTop(), composer, 0);
        int currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
        CompositionLocalMap currentCompositionLocalMap4 = composer.getCurrentCompositionLocalMap();
        Modifier materializeModifier4 = ComposedModifierKt.materializeModifier(composer, companion);
        Function0<ComposeUiNode> constructor4 = companion3.getConstructor();
        if (composer.getApplier() == null) {
            ComposablesKt.invalidApplier();
        }
        composer.startReusableNode();
        if (composer.getInserting()) {
            composer.createNode(constructor4);
        } else {
            composer.useNode();
        }
        Composer m1226constructorimpl4 = Updater.m1226constructorimpl(composer);
        Updater.m1227setimpl(m1226constructorimpl4, rowMeasurePolicy2, companion3.getSetMeasurePolicy());
        Updater.m1227setimpl(m1226constructorimpl4, currentCompositionLocalMap4, companion3.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash4 = companion3.getSetCompositeKeyHash();
        if (m1226constructorimpl4.getInserting() || !Intrinsics.areEqual(m1226constructorimpl4.rememberedValue(), Integer.valueOf(currentCompositeKeyHash4))) {
            m1226constructorimpl4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
            m1226constructorimpl4.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash4);
        }
        Updater.m1227setimpl(m1226constructorimpl4, materializeModifier4, companion3.getSetModifier());
        Modifier weight$default = RowScope.weight$default(rowScopeInstance, companion, 1.0f, false, 2, null);
        String formatWeekdayWithDate = LocalDateTimeExtensionsKt.toFormatWeekdayWithDate(bookingHeader.getDate());
        TextStyle sub = TypographyKt.getSub();
        AppColor appColor = AppColor.INSTANCE;
        TextKt.m940Text4IGK_g(formatWeekdayWithDate, weight$default, appColor.m3264getGrey10d7_KjU(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, sub, composer, 384, 1572864, 65528);
        final String stringResource = StringResources_androidKt.stringResource(R.string.common_reservationNumber, composer, 6);
        composer.startReplaceGroup(-1402673856);
        boolean changed = composer.changed(stringResource) | composer.changedInstance(bookingHeader);
        Object rememberedValue3 = composer.rememberedValue();
        if (changed || rememberedValue3 == companion4.getEmpty()) {
            rememberedValue3 = new Function1() { // from class: dk.molslinjen.ui.views.screens.saleOnBoard.i
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit invoke$lambda$10$lambda$9$lambda$8$lambda$5$lambda$4$lambda$3;
                    invoke$lambda$10$lambda$9$lambda$8$lambda$5$lambda$4$lambda$3 = SaleOnBoardScreenKt$nextDepartureTicket$1.invoke$lambda$10$lambda$9$lambda$8$lambda$5$lambda$4$lambda$3(stringResource, bookingHeader, (SemanticsPropertyReceiver) obj);
                    return invoke$lambda$10$lambda$9$lambda$8$lambda$5$lambda$4$lambda$3;
                }
            };
            composer.updateRememberedValue(rememberedValue3);
        }
        composer.endReplaceGroup();
        TextKt.m940Text4IGK_g("#" + bookingHeader.getReservationId(), SemanticsModifierKt.semantics$default(companion, false, (Function1) rememberedValue3, 1, null), appColor.m3264getGrey10d7_KjU(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getSub(), composer, 384, 1572864, 65528);
        composer.endNode();
        SpacerKt.Spacer(SizeKt.m325height3ABfNKs(companion, Dp.m2599constructorimpl(f5)), composer, 6);
        DepartureInfoSectionViewKt.DepartureInfoSection(null, null, bookingHeader, false, false, composer, 3072, 19);
        HorizontalDividerKt.m3388HorizontalDividertZIQpXc(SizeKt.fillMaxWidth$default(PaddingKt.m315paddingqDBjuR0$default(companion, 0.0f, Dp.m2599constructorimpl(f5), 0.0f, Dp.m2599constructorimpl(f5), 5, null), 0.0f, 1, null), 0L, 0.0f, Dp.m2597boximpl(Dp.m2599constructorimpl(2)), composer, 3078, 6);
        Modifier fillMaxWidth$default = SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null);
        String stringResource2 = StringResources_androidKt.stringResource(R.string.saleOnBoard_orderFoodToTheDeparture, composer, 6);
        composer.startReplaceGroup(-1562758222);
        boolean changed2 = composer.changed(function1) | composer.changedInstance(bookingHeader);
        Object rememberedValue4 = composer.rememberedValue();
        if (changed2 || rememberedValue4 == companion4.getEmpty()) {
            rememberedValue4 = new Function0() { // from class: dk.molslinjen.ui.views.screens.saleOnBoard.j
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    Unit invoke$lambda$10$lambda$9$lambda$8$lambda$7$lambda$6;
                    invoke$lambda$10$lambda$9$lambda$8$lambda$7$lambda$6 = SaleOnBoardScreenKt$nextDepartureTicket$1.invoke$lambda$10$lambda$9$lambda$8$lambda$7$lambda$6(Function1.this, bookingHeader);
                    return invoke$lambda$10$lambda$9$lambda$8$lambda$7$lambda$6;
                }
            };
            composer.updateRememberedValue(rememberedValue4);
        }
        composer.endReplaceGroup();
        PrimaryButtonKt.PrimaryButton(fillMaxWidth$default, stringResource2, (Function0) rememberedValue4, null, null, false, false, false, composer, 6, 248);
        composer.endNode();
        composer.endNode();
        composer.endNode();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
    }
}
