package dk.molslinjen.ui.views.screens.booking.shared;

import android.content.Context;
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
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntSize;
import dk.molslinjen.core.extensions.Accessibility;
import dk.molslinjen.domain.model.shared.CurrencyType;
import dk.molslinjen.extensions.ModifierExtensionsKt;
import dk.molslinjen.extensions.domain.PriceFormatExtensionsKt;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.theme.AppColor;
import dk.molslinjen.ui.theme.ThemeShapesKt;
import dk.molslinjen.ui.theme.TypographyKt;
import dk.molslinjen.ui.views.reusable.HorizontalDividerKt;
import dk.molslinjen.ui.views.screens.booking.shared.FanoeReturnInfoViewKt;
import dk.molslinjen.ui.views.shared.ticket.ticketSummary.TicketSummaryBackgroundViewKt;
import dk.molslinjen.ui.views.shared.ticket.ticketSummary.TicketSummaryHeaderRowKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u001a\u0017\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0007¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0017\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0007¢\u0006\u0004\b\u0005\u0010\u0004\u001a\u0019\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u0006H\u0003¢\u0006\u0004\b\b\u0010\t\u001a/\u0010\r\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u00062\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\u0001\u001a\u00020\u0000H\u0003¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Ldk/molslinjen/domain/model/shared/CurrencyType;", "currency", BuildConfig.FLAVOR, "FanoeReturnInfoViewWithoutBackground", "(Ldk/molslinjen/domain/model/shared/CurrencyType;Landroidx/compose/runtime/Composer;I)V", "FanoeReturnInfoView", "Landroidx/compose/ui/Modifier;", "modifier", "DetailsSection", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "Landroidx/compose/runtime/MutableState;", BuildConfig.FLAVOR, "priceRowHeightPx", "PriceSection", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/MutableState;Ldk/molslinjen/domain/model/shared/CurrencyType;Landroidx/compose/runtime/Composer;II)V", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class FanoeReturnInfoViewKt {
    private static final void DetailsSection(Modifier modifier, Composer composer, final int i5, final int i6) {
        Modifier modifier2;
        int i7;
        final Modifier modifier3;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(-17741605);
        int i8 = i6 & 1;
        if (i8 != 0) {
            i7 = i5 | 6;
            modifier2 = modifier;
        } else if ((i5 & 6) == 0) {
            modifier2 = modifier;
            i7 = (startRestartGroup.changed(modifier2) ? 4 : 2) | i5;
        } else {
            modifier2 = modifier;
            i7 = i5;
        }
        if ((i7 & 3) == 2 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
            composer2 = startRestartGroup;
        } else {
            Modifier modifier4 = i8 != 0 ? Modifier.INSTANCE : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-17741605, i7, -1, "dk.molslinjen.ui.views.screens.booking.shared.DetailsSection (FanoeReturnInfoView.kt:93)");
            }
            Arrangement arrangement = Arrangement.INSTANCE;
            Arrangement.Vertical top = arrangement.getTop();
            Alignment.Companion companion = Alignment.INSTANCE;
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(top, companion.getStart(), startRestartGroup, 0);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, modifier4);
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
            Modifier.Companion companion3 = Modifier.INSTANCE;
            float f5 = 16;
            Modifier m315paddingqDBjuR0$default = PaddingKt.m315paddingqDBjuR0$default(companion3, 0.0f, 0.0f, 0.0f, Dp.m2599constructorimpl(f5), 7, null);
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(arrangement.getStart(), companion.getTop(), startRestartGroup, 0);
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, m315paddingqDBjuR0$default);
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
            IconKt.m857Iconww6aTOc(PainterResources_androidKt.painterResource(R.drawable.icon_checkmark_circle, startRestartGroup, 6), Accessibility.INSTANCE.getSkip(), SizeKt.m331size3ABfNKs(companion3, Dp.m2599constructorimpl(f5)), AppColor.INSTANCE.m3266getGrey30d7_KjU(), startRestartGroup, 3456, 0);
            modifier3 = modifier4;
            TextKt.m940Text4IGK_g(StringResources_androidKt.stringResource(R.string.bookingSummary_fanoe_freeReturnTravel, startRestartGroup, 6), PaddingKt.m315paddingqDBjuR0$default(companion3, Dp.m2599constructorimpl(8), 0.0f, 0.0f, 0.0f, 14, null), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getSub(), startRestartGroup, 48, 1572864, 65532);
            startRestartGroup.endNode();
            composer2 = startRestartGroup;
            TextKt.m940Text4IGK_g(StringResources_androidKt.stringResource(R.string.bookingSummary_fanoe_noBookingRequired, startRestartGroup, 6), null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getSub(), composer2, 0, 1572864, 65534);
            composer2.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: a3.Q
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit DetailsSection$lambda$15;
                    DetailsSection$lambda$15 = FanoeReturnInfoViewKt.DetailsSection$lambda$15(Modifier.this, i5, i6, (Composer) obj, ((Integer) obj2).intValue());
                    return DetailsSection$lambda$15;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DetailsSection$lambda$15(Modifier modifier, int i5, int i6, Composer composer, int i7) {
        DetailsSection(modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1), i6);
        return Unit.INSTANCE;
    }

    public static final void FanoeReturnInfoView(final CurrencyType currency, Composer composer, final int i5) {
        int i6;
        Composer composer2;
        Intrinsics.checkNotNullParameter(currency, "currency");
        Composer startRestartGroup = composer.startRestartGroup(-2018559948);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changed(currency) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i6 & 3) == 2 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2018559948, i6, -1, "dk.molslinjen.ui.views.screens.booking.shared.FanoeReturnInfoView (FanoeReturnInfoView.kt:50)");
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
            startRestartGroup.startReplaceGroup(1298493809);
            Object rememberedValue = startRestartGroup.rememberedValue();
            Composer.Companion companion4 = Composer.INSTANCE;
            if (rememberedValue == companion4.getEmpty()) {
                rememberedValue = new Function0() { // from class: a3.S
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        MutableState FanoeReturnInfoView$lambda$11$lambda$5$lambda$4;
                        FanoeReturnInfoView$lambda$11$lambda$5$lambda$4 = FanoeReturnInfoViewKt.FanoeReturnInfoView$lambda$11$lambda$5$lambda$4();
                        return FanoeReturnInfoView$lambda$11$lambda$5$lambda$4;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            final MutableState mutableState = (MutableState) RememberSaveableKt.rememberSaveable(objArr, null, null, (Function0) rememberedValue, startRestartGroup, 3072, 6);
            Object[] objArr2 = new Object[0];
            startRestartGroup.startReplaceGroup(1298496049);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (rememberedValue2 == companion4.getEmpty()) {
                rememberedValue2 = new Function0() { // from class: a3.T
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        MutableState FanoeReturnInfoView$lambda$11$lambda$7$lambda$6;
                        FanoeReturnInfoView$lambda$11$lambda$7$lambda$6 = FanoeReturnInfoViewKt.FanoeReturnInfoView$lambda$11$lambda$7$lambda$6();
                        return FanoeReturnInfoView$lambda$11$lambda$7$lambda$6;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            startRestartGroup.endReplaceGroup();
            MutableState mutableState2 = (MutableState) RememberSaveableKt.rememberSaveable(objArr2, null, null, (Function0) rememberedValue2, startRestartGroup, 3072, 6);
            TicketSummaryBackgroundViewKt.m3563TicketSummaryBackgroundViewww6aTOc(ModifierExtensionsKt.defaultShadow$default(SizeKt.fillMaxHeight$default(companion, 0.0f, 1, null), null, 1, null), ((Number) mutableState.getValue()).intValue(), ((Number) mutableState2.getValue()).intValue(), 0L, startRestartGroup, 0, 8);
            float f5 = 16;
            Modifier m313paddingVpY3zN4$default = PaddingKt.m313paddingVpY3zN4$default(companion, Dp.m2599constructorimpl(f5), 0.0f, 2, null);
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
            startRestartGroup.startReplaceGroup(932636839);
            boolean changed = startRestartGroup.changed(mutableState);
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (changed || rememberedValue3 == companion4.getEmpty()) {
                rememberedValue3 = new Function1() { // from class: a3.U
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit FanoeReturnInfoView$lambda$11$lambda$10$lambda$9$lambda$8;
                        FanoeReturnInfoView$lambda$11$lambda$10$lambda$9$lambda$8 = FanoeReturnInfoViewKt.FanoeReturnInfoView$lambda$11$lambda$10$lambda$9$lambda$8(MutableState.this, (LayoutCoordinates) obj);
                        return FanoeReturnInfoView$lambda$11$lambda$10$lambda$9$lambda$8;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            startRestartGroup.endReplaceGroup();
            TicketSummaryHeaderRowKt.TicketSummaryHeaderRow(OnGloballyPositionedModifierKt.onGloballyPositioned(companion, (Function1) rememberedValue3), StringResources_androidKt.stringResource(R.string.departures_return_return, startRestartGroup, 6), null, startRestartGroup, 0, 4);
            float f6 = 2;
            float f7 = 24;
            HorizontalDividerKt.m3388HorizontalDividertZIQpXc(PaddingKt.m315paddingqDBjuR0$default(companion, 0.0f, 0.0f, 0.0f, Dp.m2599constructorimpl(f7), 7, null), 0L, 0.0f, Dp.m2597boximpl(Dp.m2599constructorimpl(f6)), startRestartGroup, 3078, 6);
            float f8 = 8;
            TextKt.m940Text4IGK_g(StringResources_androidKt.stringResource(R.string.bookingSummary_fanoe_ticketIncludes, startRestartGroup, 6), PaddingKt.m315paddingqDBjuR0$default(PaddingKt.m313paddingVpY3zN4$default(companion, Dp.m2599constructorimpl(f8), 0.0f, 2, null), 0.0f, 0.0f, 0.0f, Dp.m2599constructorimpl(f5), 7, null), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getSub(), startRestartGroup, 48, 1572864, 65532);
            DetailsSection(PaddingKt.m313paddingVpY3zN4$default(companion, Dp.m2599constructorimpl(f8), 0.0f, 2, null), startRestartGroup, 6, 0);
            HorizontalDividerKt.m3388HorizontalDividertZIQpXc(PaddingKt.m315paddingqDBjuR0$default(companion, 0.0f, Dp.m2599constructorimpl(f7), 0.0f, 0.0f, 13, null), 0L, 0.0f, Dp.m2597boximpl(Dp.m2599constructorimpl(f6)), startRestartGroup, 3078, 6);
            composer2 = startRestartGroup;
            PriceSection(PaddingKt.m313paddingVpY3zN4$default(companion, Dp.m2599constructorimpl(f8), 0.0f, 2, null), mutableState2, currency, startRestartGroup, ((i6 << 6) & 896) | 6, 0);
            composer2.endNode();
            composer2.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: a3.V
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit FanoeReturnInfoView$lambda$12;
                    FanoeReturnInfoView$lambda$12 = FanoeReturnInfoViewKt.FanoeReturnInfoView$lambda$12(CurrencyType.this, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return FanoeReturnInfoView$lambda$12;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FanoeReturnInfoView$lambda$11$lambda$10$lambda$9$lambda$8(MutableState mutableState, LayoutCoordinates it) {
        Intrinsics.checkNotNullParameter(it, "it");
        mutableState.setValue(Integer.valueOf(IntSize.m2660getHeightimpl(it.mo1948getSizeYbymL2g())));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MutableState FanoeReturnInfoView$lambda$11$lambda$5$lambda$4() {
        MutableState mutableStateOf$default;
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(0, null, 2, null);
        return mutableStateOf$default;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MutableState FanoeReturnInfoView$lambda$11$lambda$7$lambda$6() {
        MutableState mutableStateOf$default;
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(0, null, 2, null);
        return mutableStateOf$default;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FanoeReturnInfoView$lambda$12(CurrencyType currencyType, int i5, Composer composer, int i6) {
        FanoeReturnInfoView(currencyType, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    public static final void FanoeReturnInfoViewWithoutBackground(final CurrencyType currency, Composer composer, final int i5) {
        int i6;
        Composer composer2;
        Intrinsics.checkNotNullParameter(currency, "currency");
        Composer startRestartGroup = composer.startRestartGroup(1314272814);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changed(currency) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i6 & 3) == 2 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1314272814, i6, -1, "dk.molslinjen.ui.views.screens.booking.shared.FanoeReturnInfoViewWithoutBackground (FanoeReturnInfoView.kt:30)");
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            Modifier m313paddingVpY3zN4$default = PaddingKt.m313paddingVpY3zN4$default(companion, Dp.m2599constructorimpl(24), 0.0f, 2, null);
            Arrangement.Vertical top = Arrangement.INSTANCE.getTop();
            Alignment.Companion companion2 = Alignment.INSTANCE;
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(top, companion2.getStart(), startRestartGroup, 0);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, m313paddingVpY3zN4$default);
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
            TextKt.m940Text4IGK_g(StringResources_androidKt.stringResource(R.string.bookingSummary_fanoe_ticketIncludes, startRestartGroup, 6), null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getParagraphSmall(), startRestartGroup, 0, 1572864, 65534);
            float f5 = 16;
            Modifier m311padding3ABfNKs = PaddingKt.m311padding3ABfNKs(BackgroundKt.m103backgroundbw27NRU(PaddingKt.m313paddingVpY3zN4$default(companion, 0.0f, Dp.m2599constructorimpl(f5), 1, null), AppColor.INSTANCE.m3269getGrey60d7_KjU(), ThemeShapesKt.getThemeShapes().getMedium()), Dp.m2599constructorimpl(f5));
            MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(companion2.getTopStart(), false);
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, m311padding3ABfNKs);
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
            Updater.m1227setimpl(m1226constructorimpl2, maybeCachedBoxMeasurePolicy, companion3.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl2, currentCompositionLocalMap2, companion3.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = companion3.getSetCompositeKeyHash();
            if (m1226constructorimpl2.getInserting() || !Intrinsics.areEqual(m1226constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                m1226constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                m1226constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            Updater.m1227setimpl(m1226constructorimpl2, materializeModifier2, companion3.getSetModifier());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            DetailsSection(null, startRestartGroup, 0, 1);
            startRestartGroup.endNode();
            startRestartGroup.startReplaceGroup(2001365302);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(0, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            composer2 = startRestartGroup;
            PriceSection(null, (MutableState) rememberedValue, currency, startRestartGroup, ((i6 << 6) & 896) | 48, 1);
            composer2.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: a3.W
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit FanoeReturnInfoViewWithoutBackground$lambda$3;
                    FanoeReturnInfoViewWithoutBackground$lambda$3 = FanoeReturnInfoViewKt.FanoeReturnInfoViewWithoutBackground$lambda$3(CurrencyType.this, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return FanoeReturnInfoViewWithoutBackground$lambda$3;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FanoeReturnInfoViewWithoutBackground$lambda$3(CurrencyType currencyType, int i5, Composer composer, int i6) {
        FanoeReturnInfoViewWithoutBackground(currencyType, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    private static final void PriceSection(Modifier modifier, final MutableState<Integer> mutableState, final CurrencyType currencyType, Composer composer, final int i5, final int i6) {
        Modifier modifier2;
        int i7;
        Modifier modifier3;
        Composer startRestartGroup = composer.startRestartGroup(563719412);
        int i8 = i6 & 1;
        if (i8 != 0) {
            i7 = i5 | 6;
            modifier2 = modifier;
        } else if ((i5 & 6) == 0) {
            modifier2 = modifier;
            i7 = (startRestartGroup.changed(modifier2) ? 4 : 2) | i5;
        } else {
            modifier2 = modifier;
            i7 = i5;
        }
        if ((i6 & 2) != 0) {
            i7 |= 48;
        } else if ((i5 & 48) == 0) {
            i7 |= startRestartGroup.changed(mutableState) ? 32 : 16;
        }
        if ((i6 & 4) != 0) {
            i7 |= 384;
        } else if ((i5 & 384) == 0) {
            i7 |= startRestartGroup.changed(currencyType) ? 256 : 128;
        }
        if ((i7 & 147) == 146 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
        } else {
            Modifier modifier4 = i8 != 0 ? Modifier.INSTANCE : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(563719412, i7, -1, "dk.molslinjen.ui.views.screens.booking.shared.PriceSection (FanoeReturnInfoView.kt:116)");
            }
            startRestartGroup.startReplaceGroup(-1980192746);
            boolean z5 = (i7 & 112) == 32;
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (z5 || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function1() { // from class: a3.O
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit PriceSection$lambda$17$lambda$16;
                        PriceSection$lambda$17$lambda$16 = FanoeReturnInfoViewKt.PriceSection$lambda$17$lambda$16(MutableState.this, (LayoutCoordinates) obj);
                        return PriceSection$lambda$17$lambda$16;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            Modifier m315paddingqDBjuR0$default = PaddingKt.m315paddingqDBjuR0$default(OnGloballyPositionedModifierKt.onGloballyPositioned(modifier4, (Function1) rememberedValue), 0.0f, Dp.m2599constructorimpl(10), 0.0f, Dp.m2599constructorimpl(16), 5, null);
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.INSTANCE.getCenterVertically(), startRestartGroup, 48);
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
            Updater.m1227setimpl(m1226constructorimpl, rowMeasurePolicy, companion.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion.getSetCompositeKeyHash();
            if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion.getSetModifier());
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            Modifier.Companion companion2 = Modifier.INSTANCE;
            modifier3 = modifier4;
            TextKt.m940Text4IGK_g(StringResources_androidKt.stringResource(R.string.bookingSummary_fanoe_returnPrice, startRestartGroup, 6), RowScope.weight$default(rowScopeInstance, companion2, 1.0f, false, 2, null), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getSub(), startRestartGroup, 0, 1572864, 65532);
            TextKt.m940Text4IGK_g("0", rowScopeInstance.alignByBaseline(companion2), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getH2Bold(), startRestartGroup, 6, 1572864, 65532);
            TextKt.m940Text4IGK_g(PriceFormatExtensionsKt.formatted(currencyType, (Context) startRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext())), PaddingKt.m315paddingqDBjuR0$default(rowScopeInstance.alignByBaseline(companion2), Dp.m2599constructorimpl(2), 0.0f, 0.0f, 0.0f, 14, null), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getSub(), startRestartGroup, 0, 1572864, 65532);
            startRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            endRestartGroup.updateScope(new Function2() { // from class: a3.P
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit PriceSection$lambda$19;
                    PriceSection$lambda$19 = FanoeReturnInfoViewKt.PriceSection$lambda$19(Modifier.this, mutableState, currencyType, i5, i6, (Composer) obj, ((Integer) obj2).intValue());
                    return PriceSection$lambda$19;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PriceSection$lambda$17$lambda$16(MutableState mutableState, LayoutCoordinates it) {
        Intrinsics.checkNotNullParameter(it, "it");
        mutableState.setValue(Integer.valueOf(IntSize.m2660getHeightimpl(it.mo1948getSizeYbymL2g())));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PriceSection$lambda$19(Modifier modifier, MutableState mutableState, CurrencyType currencyType, int i5, int i6, Composer composer, int i7) {
        PriceSection(modifier, mutableState, currencyType, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1), i6);
        return Unit.INSTANCE;
    }
}
