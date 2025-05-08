package dk.molslinjen.ui.views.screens.booking.shared.kombardoTravelDetails;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
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
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.OnGloballyPositionedModifierKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntSize;
import dk.molslinjen.core.extensions.Accessibility;
import dk.molslinjen.domain.extensions.LocalDateTimeExtensionsKt;
import dk.molslinjen.domain.model.config.Subline;
import dk.molslinjen.extensions.ComposeExtensionsKt;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.theme.AppColor;
import dk.molslinjen.ui.theme.TypographyKt;
import dk.molslinjen.ui.views.reusable.HorizontalDividerKt;
import dk.molslinjen.ui.views.reusable.InfoBoxViewKt;
import dk.molslinjen.ui.views.reusable.VerticalDividerKt;
import dk.molslinjen.ui.views.reusable.buttons.ShowDetailsButtonKt;
import dk.molslinjen.ui.views.screens.booking.shared.kombardoTravelDetails.KombardoTravelDetailsViewKt;
import dk.molslinjen.ui.views.screens.booking.ticketType.HarborStep;
import dk.molslinjen.ui.views.screens.booking.ticketType.IconStep;
import dk.molslinjen.ui.views.screens.booking.ticketType.Step;
import dk.molslinjen.ui.views.screens.booking.ticketType.WalkStep;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aW\u0010\u000e\u001a\u00020\n2\b\b\u0002\u0010\u0001\u001a\u00020\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0007¢\u0006\u0004\b\u000e\u0010\u000f\u001aE\u0010\u0012\u001a\u00020\n*\u00020\u00102\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bH\u0003¢\u0006\u0004\b\u0012\u0010\u0013\u001a=\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00052\u0014\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0018\u00010\bH\u0003¢\u0006\u0004\b\u0017\u0010\u0018\u001a\u0017\u0010\u001a\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u0019H\u0003¢\u0006\u0004\b\u001a\u0010\u001b¨\u0006\u001c²\u0006\u000e\u0010\u0011\u001a\u00020\u00058\n@\nX\u008a\u008e\u0002"}, d2 = {"Landroidx/compose/ui/Modifier;", "modifier", BuildConfig.FLAVOR, "Ldk/molslinjen/ui/views/screens/booking/ticketType/Step;", "steps", BuildConfig.FLAVOR, "showDetailsForDepartingTime", "collapsable", "Lkotlin/Function1;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "showOnMap", "Ldk/molslinjen/domain/model/config/Subline;", "subline", "KombardoTravelDetailsView", "(Landroidx/compose/ui/Modifier;Ljava/util/List;ZZLkotlin/jvm/functions/Function1;Ldk/molslinjen/domain/model/config/Subline;Landroidx/compose/runtime/Composer;II)V", "Landroidx/compose/foundation/layout/BoxScope;", "expanded", "TravelDetailsContentView", "(Landroidx/compose/foundation/layout/BoxScope;Ljava/util/List;ZZLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "Ldk/molslinjen/ui/views/screens/booking/ticketType/HarborStep;", "step", "showAddress", "HarborRow", "(Ldk/molslinjen/ui/views/screens/booking/ticketType/HarborStep;ZZLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "Ldk/molslinjen/ui/views/screens/booking/ticketType/IconStep;", "IconRow", "(Ldk/molslinjen/ui/views/screens/booking/ticketType/IconStep;Landroidx/compose/runtime/Composer;I)V", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class KombardoTravelDetailsViewKt {
    /* JADX WARN: Multi-variable type inference failed */
    private static final void HarborRow(final HarborStep harborStep, final boolean z5, final boolean z6, final Function1<? super String, Unit> function1, Composer composer, final int i5) {
        int i6;
        Modifier.Companion companion;
        int i7;
        boolean z7;
        int i8;
        Function1 function12;
        Composer composer2;
        int i9;
        Function1 function13;
        Composer startRestartGroup = composer.startRestartGroup(-488195107);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(harborStep) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changed(z5) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i6 |= startRestartGroup.changed(z6) ? 256 : 128;
        }
        if ((i5 & 3072) == 0) {
            i6 |= startRestartGroup.changedInstance(function1) ? 2048 : 1024;
        }
        int i10 = i6;
        if ((i10 & 1171) == 1170 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-488195107, i10, -1, "dk.molslinjen.ui.views.screens.booking.shared.kombardoTravelDetails.HarborRow (KombardoTravelDetailsView.kt:147)");
            }
            startRestartGroup.startReplaceGroup(877876898);
            Object rememberedValue = startRestartGroup.rememberedValue();
            Composer.Companion companion2 = Composer.INSTANCE;
            if (rememberedValue == companion2.getEmpty()) {
                rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(0, null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            final MutableState mutableState = (MutableState) rememberedValue;
            startRestartGroup.endReplaceGroup();
            Modifier.Companion companion3 = Modifier.INSTANCE;
            Arrangement arrangement = Arrangement.INSTANCE;
            Arrangement.Horizontal start = arrangement.getStart();
            Alignment.Companion companion4 = Alignment.INSTANCE;
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(start, companion4.getTop(), startRestartGroup, 0);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, companion3);
            ComposeUiNode.Companion companion5 = ComposeUiNode.INSTANCE;
            Function0<ComposeUiNode> constructor = companion5.getConstructor();
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
            Updater.m1227setimpl(m1226constructorimpl, rowMeasurePolicy, companion5.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion5.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion5.getSetCompositeKeyHash();
            if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion5.getSetModifier());
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            Modifier m325height3ABfNKs = SizeKt.m325height3ABfNKs(SizeKt.m336width3ABfNKs(companion3, Dp.m2599constructorimpl(24)), ComposeExtensionsKt.pxToDp(((Number) mutableState.getValue()).intValue(), startRestartGroup, 0));
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(arrangement.getTop(), companion4.getCenterHorizontally(), startRestartGroup, 48);
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, m325height3ABfNKs);
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
            MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(companion4.getTopCenter(), false);
            int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap3 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(startRestartGroup, companion3);
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
            Updater.m1227setimpl(m1226constructorimpl3, maybeCachedBoxMeasurePolicy, companion5.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl3, currentCompositionLocalMap3, companion5.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = companion5.getSetCompositeKeyHash();
            if (m1226constructorimpl3.getInserting() || !Intrinsics.areEqual(m1226constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                m1226constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                m1226constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
            }
            Updater.m1227setimpl(m1226constructorimpl3, materializeModifier3, companion5.getSetModifier());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            float f5 = 6;
            Modifier clip = ClipKt.clip(SizeKt.m331size3ABfNKs(PaddingKt.m315paddingqDBjuR0$default(companion3, 0.0f, Dp.m2599constructorimpl(f5), 0.0f, 0.0f, 13, null), Dp.m2599constructorimpl(11)), RoundedCornerShapeKt.getCircleShape());
            AppColor appColor = AppColor.INSTANCE;
            BoxKt.Box(BackgroundKt.m104backgroundbw27NRU$default(clip, appColor.m3267getGrey40d7_KjU(), null, 2, null), startRestartGroup, 0);
            startRestartGroup.startReplaceGroup(-641077304);
            if (harborStep.getIsPreviousStepNotFerry()) {
                function12 = null;
                i7 = i10;
                companion = companion3;
                z7 = true;
                i8 = 2;
                VerticalDividerKt.m3394VerticalDividertZIQpXc(OffsetKt.m295offsetVpY3zN4$default(SizeKt.m325height3ABfNKs(companion3, Dp.m2599constructorimpl(10)), 0.0f, Dp.m2599constructorimpl(-2), 1, null), appColor.m3267getGrey40d7_KjU(), 0.0f, null, startRestartGroup, 54, 12);
            } else {
                companion = companion3;
                i7 = i10;
                z7 = true;
                i8 = 2;
                function12 = null;
            }
            startRestartGroup.endReplaceGroup();
            startRestartGroup.endNode();
            startRestartGroup.startReplaceGroup(1622399356);
            if (!harborStep.getIsLast()) {
                VerticalDividerKt.m3394VerticalDividertZIQpXc(ColumnScope.weight$default(columnScopeInstance, PaddingKt.m315paddingqDBjuR0$default(companion, 0.0f, harborStep.getIsNextStepFerry() ? Dp.m2599constructorimpl(f5) : Dp.m2599constructorimpl(0), 0.0f, 0.0f, 13, null), 1.0f, false, 2, null), harborStep.getIsNextStepFerry() ? appColor.m3266getGrey30d7_KjU() : appColor.m3267getGrey40d7_KjU(), 0.0f, harborStep.getIsNextStepFerry() ? Dp.m2597boximpl(Dp.m2599constructorimpl(i8)) : function12, startRestartGroup, 0, 4);
            }
            startRestartGroup.endReplaceGroup();
            startRestartGroup.endNode();
            float f6 = 16;
            Modifier m336width3ABfNKs = SizeKt.m336width3ABfNKs(PaddingKt.m315paddingqDBjuR0$default(companion, Dp.m2599constructorimpl(f6), Dp.m2599constructorimpl(i8), 0.0f, 0.0f, 12, null), Dp.m2599constructorimpl(61));
            composer2 = startRestartGroup;
            TextKt.m940Text4IGK_g(LocalDateTimeExtensionsKt.toFormatTime(harborStep.getTime()), m336width3ABfNKs, appColor.m3254getBrandBlack20d7_KjU(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getParagraphSmallBold(), composer2, 432, 1572864, 65528);
            composer2.startReplaceGroup(629060356);
            Object rememberedValue2 = composer2.rememberedValue();
            if (rememberedValue2 == companion2.getEmpty()) {
                rememberedValue2 = new Function1() { // from class: c3.e
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit HarborRow$lambda$21$lambda$16$lambda$15;
                        HarborRow$lambda$21$lambda$16$lambda$15 = KombardoTravelDetailsViewKt.HarborRow$lambda$21$lambda$16$lambda$15(MutableState.this, (LayoutCoordinates) obj);
                        return HarborRow$lambda$21$lambda$16$lambda$15;
                    }
                };
                composer2.updateRememberedValue(rememberedValue2);
            }
            composer2.endReplaceGroup();
            Modifier.Companion companion6 = companion;
            Modifier m315paddingqDBjuR0$default = PaddingKt.m315paddingqDBjuR0$default(OnGloballyPositionedModifierKt.onGloballyPositioned(companion6, (Function1) rememberedValue2), 0.0f, 0.0f, Dp.m2599constructorimpl(f6), Dp.m2599constructorimpl(f6), 3, null);
            MeasurePolicy columnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(arrangement.getTop(), companion4.getStart(), composer2, 0);
            int currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
            CompositionLocalMap currentCompositionLocalMap4 = composer2.getCurrentCompositionLocalMap();
            Modifier materializeModifier4 = ComposedModifierKt.materializeModifier(composer2, m315paddingqDBjuR0$default);
            Function0<ComposeUiNode> constructor4 = companion5.getConstructor();
            if (composer2.getApplier() == null) {
                ComposablesKt.invalidApplier();
            }
            composer2.startReusableNode();
            if (composer2.getInserting()) {
                composer2.createNode(constructor4);
            } else {
                composer2.useNode();
            }
            Composer m1226constructorimpl4 = Updater.m1226constructorimpl(composer2);
            Updater.m1227setimpl(m1226constructorimpl4, columnMeasurePolicy2, companion5.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl4, currentCompositionLocalMap4, companion5.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash4 = companion5.getSetCompositeKeyHash();
            if (m1226constructorimpl4.getInserting() || !Intrinsics.areEqual(m1226constructorimpl4.rememberedValue(), Integer.valueOf(currentCompositeKeyHash4))) {
                m1226constructorimpl4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                m1226constructorimpl4.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash4);
            }
            Updater.m1227setimpl(m1226constructorimpl4, materializeModifier4, companion5.getSetModifier());
            TextKt.m940Text4IGK_g(harborStep.getHarbor().getName(), null, appColor.m3254getBrandBlack20d7_KjU(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getParagraphSmallBold(), composer2, 384, 1572864, 65530);
            composer2.startReplaceGroup(1622432930);
            if (z6) {
                Modifier m315paddingqDBjuR0$default2 = PaddingKt.m315paddingqDBjuR0$default(companion6, 0.0f, Dp.m2599constructorimpl(4), 0.0f, 0.0f, 13, null);
                String fullAddress = harborStep.getHarbor().fullAddress();
                composer2.startReplaceGroup(1622443314);
                if (function1 == null) {
                    function13 = function12;
                    i9 = i7;
                } else {
                    composer2.startReplaceGroup(-641022019);
                    i9 = i7;
                    boolean changedInstance = composer2.changedInstance(harborStep) | ((i9 & 7168) == 2048 ? z7 : false);
                    Object rememberedValue3 = composer2.rememberedValue();
                    if (changedInstance || rememberedValue3 == companion2.getEmpty()) {
                        rememberedValue3 = new Function1() { // from class: c3.f
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                Unit HarborRow$lambda$21$lambda$20$lambda$19$lambda$18$lambda$17;
                                HarborRow$lambda$21$lambda$20$lambda$19$lambda$18$lambda$17 = KombardoTravelDetailsViewKt.HarborRow$lambda$21$lambda$20$lambda$19$lambda$18$lambda$17(Function1.this, harborStep, (String) obj);
                                return HarborRow$lambda$21$lambda$20$lambda$19$lambda$18$lambda$17;
                            }
                        };
                        composer2.updateRememberedValue(rememberedValue3);
                    }
                    composer2.endReplaceGroup();
                    function13 = (Function1) rememberedValue3;
                }
                composer2.endReplaceGroup();
                AddressViewKt.AddressView(m315paddingqDBjuR0$default2, fullAddress, z5, false, false, false, function13, composer2, ((i9 << 3) & 896) | 3078, 48);
            }
            composer2.endReplaceGroup();
            composer2.endNode();
            composer2.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: c3.g
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit HarborRow$lambda$22;
                    HarborRow$lambda$22 = KombardoTravelDetailsViewKt.HarborRow$lambda$22(HarborStep.this, z5, z6, function1, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return HarborRow$lambda$22;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HarborRow$lambda$21$lambda$16$lambda$15(MutableState mutableState, LayoutCoordinates it) {
        Intrinsics.checkNotNullParameter(it, "it");
        mutableState.setValue(Integer.valueOf(IntSize.m2660getHeightimpl(it.mo1948getSizeYbymL2g())));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HarborRow$lambda$21$lambda$20$lambda$19$lambda$18$lambda$17(Function1 function1, HarborStep harborStep, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        function1.invoke(harborStep.getHarbor().fullAddress());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit HarborRow$lambda$22(HarborStep harborStep, boolean z5, boolean z6, Function1 function1, int i5, Composer composer, int i6) {
        HarborRow(harborStep, z5, z6, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    private static final void IconRow(final IconStep iconStep, Composer composer, final int i5) {
        int i6;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(-3517656);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changed(iconStep) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i6 & 3) == 2 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-3517656, i6, -1, "dk.molslinjen.ui.views.screens.booking.shared.kombardoTravelDetails.IconRow (KombardoTravelDetailsView.kt:220)");
            }
            Alignment.Companion companion = Alignment.INSTANCE;
            Alignment.Vertical centerVertically = companion.getCenterVertically();
            Modifier.Companion companion2 = Modifier.INSTANCE;
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, startRestartGroup, 48);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, companion2);
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
            float f5 = 24;
            Modifier m331size3ABfNKs = SizeKt.m331size3ABfNKs(companion2, Dp.m2599constructorimpl(f5));
            Painter painterResource = PainterResources_androidKt.painterResource(iconStep.getIcon(), startRestartGroup, 0);
            String skip = Accessibility.INSTANCE.getSkip();
            AppColor appColor = AppColor.INSTANCE;
            IconKt.m857Iconww6aTOc(painterResource, skip, m331size3ABfNKs, appColor.m3267getGrey40d7_KjU(), startRestartGroup, 3456, 0);
            Modifier weight$default = RowScope.weight$default(rowScopeInstance, PaddingKt.m315paddingqDBjuR0$default(companion2, Dp.m2599constructorimpl(16), 0.0f, 0.0f, 0.0f, 14, null), 1.0f, false, 2, null);
            Integer text = iconStep.getText();
            startRestartGroup.startReplaceGroup(-952386283);
            String stringResource = text == null ? null : StringResources_androidKt.stringResource(text.intValue(), startRestartGroup, 0);
            startRestartGroup.endReplaceGroup();
            if (stringResource == null) {
                stringResource = BuildConfig.FLAVOR;
            }
            TextKt.m940Text4IGK_g(stringResource, weight$default, appColor.m3265getGrey20d7_KjU(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getSubSmall(), startRestartGroup, 384, 1572864, 65528);
            composer2 = startRestartGroup;
            composer2.startReplaceGroup(-952382169);
            if (iconStep.getBusChangeOnFerry()) {
                String busChangeText = iconStep.getBusChangeText();
                InfoBoxViewKt.InfoBoxView(null, R.drawable.icon_busbus, busChangeText == null ? BuildConfig.FLAVOR : busChangeText, true, composer2, 3120, 1);
            }
            composer2.endReplaceGroup();
            composer2.endNode();
            Modifier m333sizeVpY3zN4 = SizeKt.m333sizeVpY3zN4(companion2, Dp.m2599constructorimpl(f5), Dp.m2599constructorimpl(35));
            MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(companion.getTopCenter(), false);
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
            CompositionLocalMap currentCompositionLocalMap2 = composer2.getCurrentCompositionLocalMap();
            Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(composer2, m333sizeVpY3zN4);
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
            Updater.m1227setimpl(m1226constructorimpl2, maybeCachedBoxMeasurePolicy, companion3.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl2, currentCompositionLocalMap2, companion3.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = companion3.getSetCompositeKeyHash();
            if (m1226constructorimpl2.getInserting() || !Intrinsics.areEqual(m1226constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                m1226constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                m1226constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            Updater.m1227setimpl(m1226constructorimpl2, materializeModifier2, companion3.getSetModifier());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            VerticalDividerKt.m3394VerticalDividertZIQpXc(PaddingKt.m315paddingqDBjuR0$default(companion2, 0.0f, Dp.m2599constructorimpl(4), 0.0f, 0.0f, 13, null), iconStep.getIsFerry() ? appColor.m3266getGrey30d7_KjU() : appColor.m3267getGrey40d7_KjU(), 0.0f, iconStep.getIsFerry() ? Dp.m2597boximpl(Dp.m2599constructorimpl(2)) : null, composer2, 6, 4);
            composer2.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: c3.d
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit IconRow$lambda$26;
                    IconRow$lambda$26 = KombardoTravelDetailsViewKt.IconRow$lambda$26(IconStep.this, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return IconRow$lambda$26;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit IconRow$lambda$26(IconStep iconStep, int i5, Composer composer, int i6) {
        IconRow(iconStep, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:105:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0117  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void KombardoTravelDetailsView(Modifier modifier, final List<? extends Step> steps, final boolean z5, boolean z6, final Function1<? super String, Unit> showOnMap, final Subline subline, Composer composer, final int i5, final int i6) {
        Modifier modifier2;
        int i7;
        int i8;
        boolean z7;
        Object obj;
        int i9;
        MutableState mutableState;
        Composer composer2;
        final boolean z8;
        final MutableState mutableState2;
        Intrinsics.checkNotNullParameter(steps, "steps");
        Intrinsics.checkNotNullParameter(showOnMap, "showOnMap");
        Composer startRestartGroup = composer.startRestartGroup(900308800);
        int i10 = i6 & 1;
        if (i10 != 0) {
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
            i7 |= startRestartGroup.changedInstance(steps) ? 32 : 16;
        }
        if ((i6 & 4) != 0) {
            i7 |= 384;
        } else if ((i5 & 384) == 0) {
            i7 |= startRestartGroup.changed(z5) ? 256 : 128;
            i8 = i6 & 8;
            if (i8 == 0) {
                i7 |= 3072;
            } else if ((i5 & 3072) == 0) {
                z7 = z6;
                i7 |= startRestartGroup.changed(z7) ? 2048 : 1024;
                if ((i6 & 16) != 0) {
                    i7 |= 24576;
                } else if ((i5 & 24576) == 0) {
                    i7 |= startRestartGroup.changedInstance(showOnMap) ? 16384 : 8192;
                }
                if ((i6 & 32) != 0) {
                    i7 |= 196608;
                } else if ((i5 & 196608) == 0) {
                    i7 |= startRestartGroup.changedInstance(subline) ? 131072 : 65536;
                }
                if ((74899 & i7) == 74898 || !startRestartGroup.getSkipping()) {
                    if (i10 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    boolean z9 = i8 != 0 ? false : z7;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(900308800, i7, -1, "dk.molslinjen.ui.views.screens.booking.shared.kombardoTravelDetails.KombardoTravelDetailsView (KombardoTravelDetailsView.kt:44)");
                    }
                    if (steps.isEmpty()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
                        if (endRestartGroup != null) {
                            final Modifier modifier3 = modifier2;
                            final boolean z10 = z9;
                            endRestartGroup.updateScope(new Function2() { // from class: c3.h
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj2, Object obj3) {
                                    Unit KombardoTravelDetailsView$lambda$0;
                                    KombardoTravelDetailsView$lambda$0 = KombardoTravelDetailsViewKt.KombardoTravelDetailsView$lambda$0(Modifier.this, steps, z5, z10, showOnMap, subline, i5, i6, (Composer) obj2, ((Integer) obj3).intValue());
                                    return KombardoTravelDetailsView$lambda$0;
                                }
                            });
                            return;
                        }
                        return;
                    }
                    startRestartGroup.startReplaceGroup(-580303337);
                    Object rememberedValue = startRestartGroup.rememberedValue();
                    Composer.Companion companion = Composer.INSTANCE;
                    if (rememberedValue == companion.getEmpty()) {
                        rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(!z9), null, 2, null);
                        startRestartGroup.updateRememberedValue(rememberedValue);
                    }
                    MutableState mutableState3 = (MutableState) rememberedValue;
                    startRestartGroup.endReplaceGroup();
                    HorizontalDividerKt.m3388HorizontalDividertZIQpXc(null, 0L, 0.0f, null, startRestartGroup, 0, 15);
                    Arrangement.Vertical top = Arrangement.INSTANCE.getTop();
                    Alignment.Companion companion2 = Alignment.INSTANCE;
                    MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(top, companion2.getStart(), startRestartGroup, 0);
                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                    CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
                    Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, modifier2);
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
                    Modifier.Companion companion4 = Modifier.INSTANCE;
                    Modifier modifier4 = modifier2;
                    int i11 = i7;
                    LineIconViewKt.LineIconView(PaddingKt.m315paddingqDBjuR0$default(companion4, 0.0f, 0.0f, 0.0f, Dp.m2599constructorimpl(16), 7, null), subline, null, startRestartGroup, ((i7 >> 12) & 112) | 6, 4);
                    if (KombardoTravelDetailsView$lambda$2(mutableState3)) {
                        startRestartGroup.startReplaceGroup(-1284050496);
                        MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(companion2.getTopStart(), false);
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
                        Updater.m1227setimpl(m1226constructorimpl2, maybeCachedBoxMeasurePolicy, companion3.getSetMeasurePolicy());
                        Updater.m1227setimpl(m1226constructorimpl2, currentCompositionLocalMap2, companion3.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = companion3.getSetCompositeKeyHash();
                        if (m1226constructorimpl2.getInserting() || !Intrinsics.areEqual(m1226constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                            m1226constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                            m1226constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                        }
                        Updater.m1227setimpl(m1226constructorimpl2, materializeModifier2, companion3.getSetModifier());
                        TravelDetailsContentView(BoxScopeInstance.INSTANCE, steps, KombardoTravelDetailsView$lambda$2(mutableState3), z5, showOnMap, startRestartGroup, (i11 & 112) | 6 | ((i11 << 3) & 7168) | (i11 & 57344));
                        startRestartGroup.endNode();
                        startRestartGroup.endReplaceGroup();
                        mutableState = mutableState3;
                        i9 = 1;
                        obj = null;
                    } else {
                        startRestartGroup.startReplaceGroup(-1283675427);
                        Modifier m327heightInVpY3zN4$default = SizeKt.m327heightInVpY3zN4$default(companion4, 0.0f, Dp.m2599constructorimpl(190), 1, null);
                        MeasurePolicy maybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(companion2.getTopStart(), false);
                        int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                        CompositionLocalMap currentCompositionLocalMap3 = startRestartGroup.getCurrentCompositionLocalMap();
                        Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(startRestartGroup, m327heightInVpY3zN4$default);
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
                        Updater.m1227setimpl(m1226constructorimpl3, maybeCachedBoxMeasurePolicy2, companion3.getSetMeasurePolicy());
                        Updater.m1227setimpl(m1226constructorimpl3, currentCompositionLocalMap3, companion3.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = companion3.getSetCompositeKeyHash();
                        if (m1226constructorimpl3.getInserting() || !Intrinsics.areEqual(m1226constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                            m1226constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                            m1226constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                        }
                        Updater.m1227setimpl(m1226constructorimpl3, materializeModifier3, companion3.getSetModifier());
                        obj = null;
                        i9 = 1;
                        mutableState = mutableState3;
                        TravelDetailsContentView(BoxScopeInstance.INSTANCE, steps, KombardoTravelDetailsView$lambda$2(mutableState3), z5, showOnMap, startRestartGroup, (i11 & 112) | 6 | ((i11 << 3) & 7168) | (i11 & 57344));
                        startRestartGroup.endNode();
                        startRestartGroup.endReplaceGroup();
                    }
                    startRestartGroup.startReplaceGroup(1898265221);
                    if (z9) {
                        Modifier align = columnScopeInstance.align(PaddingKt.m313paddingVpY3zN4$default(companion4, 0.0f, Dp.m2599constructorimpl(8), i9, obj), companion2.getCenterHorizontally());
                        String stringResource = StringResources_androidKt.stringResource(R.string.ticketDetails_showFullTravelDetails, startRestartGroup, 6);
                        String stringResource2 = StringResources_androidKt.stringResource(R.string.button_hide, startRestartGroup, 6);
                        startRestartGroup.startReplaceGroup(1898276937);
                        Object rememberedValue2 = startRestartGroup.rememberedValue();
                        if (rememberedValue2 == companion.getEmpty()) {
                            mutableState2 = mutableState;
                            rememberedValue2 = new Function0() { // from class: c3.i
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    Unit KombardoTravelDetailsView$lambda$8$lambda$7$lambda$6;
                                    KombardoTravelDetailsView$lambda$8$lambda$7$lambda$6 = KombardoTravelDetailsViewKt.KombardoTravelDetailsView$lambda$8$lambda$7$lambda$6(MutableState.this);
                                    return KombardoTravelDetailsView$lambda$8$lambda$7$lambda$6;
                                }
                            };
                            startRestartGroup.updateRememberedValue(rememberedValue2);
                        } else {
                            mutableState2 = mutableState;
                        }
                        Function0 function0 = (Function0) rememberedValue2;
                        startRestartGroup.endReplaceGroup();
                        boolean KombardoTravelDetailsView$lambda$2 = KombardoTravelDetailsView$lambda$2(mutableState2);
                        composer2 = startRestartGroup;
                        ShowDetailsButtonKt.ShowDetailsButton(align, stringResource, stringResource2, function0, KombardoTravelDetailsView$lambda$2, composer2, 3072, 0);
                    } else {
                        composer2 = startRestartGroup;
                    }
                    composer2.endReplaceGroup();
                    composer2.endNode();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z8 = z9;
                    modifier2 = modifier4;
                } else {
                    startRestartGroup.skipToGroupEnd();
                    composer2 = startRestartGroup;
                    z8 = z7;
                }
                ScopeUpdateScope endRestartGroup2 = composer2.endRestartGroup();
                if (endRestartGroup2 != null) {
                    final Modifier modifier5 = modifier2;
                    endRestartGroup2.updateScope(new Function2() { // from class: c3.j
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj2, Object obj3) {
                            Unit KombardoTravelDetailsView$lambda$9;
                            KombardoTravelDetailsView$lambda$9 = KombardoTravelDetailsViewKt.KombardoTravelDetailsView$lambda$9(Modifier.this, steps, z5, z8, showOnMap, subline, i5, i6, (Composer) obj2, ((Integer) obj3).intValue());
                            return KombardoTravelDetailsView$lambda$9;
                        }
                    });
                    return;
                }
                return;
            }
            z7 = z6;
            if ((i6 & 16) != 0) {
            }
            if ((i6 & 32) != 0) {
            }
            if ((74899 & i7) == 74898) {
            }
            if (i10 != 0) {
            }
            if (i8 != 0) {
            }
            if (ComposerKt.isTraceInProgress()) {
            }
            if (steps.isEmpty()) {
            }
        }
        i8 = i6 & 8;
        if (i8 == 0) {
        }
        z7 = z6;
        if ((i6 & 16) != 0) {
        }
        if ((i6 & 32) != 0) {
        }
        if ((74899 & i7) == 74898) {
        }
        if (i10 != 0) {
        }
        if (i8 != 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        if (steps.isEmpty()) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit KombardoTravelDetailsView$lambda$0(Modifier modifier, List list, boolean z5, boolean z6, Function1 function1, Subline subline, int i5, int i6, Composer composer, int i7) {
        KombardoTravelDetailsView(modifier, list, z5, z6, function1, subline, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1), i6);
        return Unit.INSTANCE;
    }

    private static final boolean KombardoTravelDetailsView$lambda$2(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void KombardoTravelDetailsView$lambda$3(MutableState<Boolean> mutableState, boolean z5) {
        mutableState.setValue(Boolean.valueOf(z5));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit KombardoTravelDetailsView$lambda$8$lambda$7$lambda$6(MutableState mutableState) {
        KombardoTravelDetailsView$lambda$3(mutableState, !KombardoTravelDetailsView$lambda$2(mutableState));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit KombardoTravelDetailsView$lambda$9(Modifier modifier, List list, boolean z5, boolean z6, Function1 function1, Subline subline, int i5, int i6, Composer composer, int i7) {
        KombardoTravelDetailsView(modifier, list, z5, z6, function1, subline, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1), i6);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final void TravelDetailsContentView(final BoxScope boxScope, final List<? extends Step> list, final boolean z5, final boolean z6, final Function1<? super String, Unit> function1, Composer composer, final int i5) {
        int i6;
        int i7 = 1;
        Composer startRestartGroup = composer.startRestartGroup(57644548);
        int i8 = (i5 & 6) == 0 ? (startRestartGroup.changed(boxScope) ? 4 : 2) | i5 : i5;
        if ((i5 & 48) == 0) {
            i8 |= startRestartGroup.changedInstance(list) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i8 |= startRestartGroup.changed(z5) ? 256 : 128;
        }
        if ((i5 & 3072) == 0) {
            i8 |= startRestartGroup.changed(z6) ? 2048 : 1024;
        }
        if ((i5 & 24576) == 0) {
            i8 |= startRestartGroup.changedInstance(function1) ? 16384 : 8192;
        }
        if ((i8 & 9363) == 9362 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(57644548, i8, -1, "dk.molslinjen.ui.views.screens.booking.shared.kombardoTravelDetails.TravelDetailsContentView (KombardoTravelDetailsView.kt:95)");
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            int i9 = 0;
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), startRestartGroup, 0);
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
            Updater.m1227setimpl(m1226constructorimpl, columnMeasurePolicy, companion2.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion2.getSetCompositeKeyHash();
            if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion2.getSetModifier());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            int size = list.size() - 1;
            startRestartGroup.startReplaceGroup(-1809461438);
            int i10 = 0;
            for (Step step : list) {
                int i11 = i10 + 1;
                if (step instanceof WalkStep) {
                    startRestartGroup.startReplaceGroup(-258649500);
                    i6 = i9;
                    InfoBoxViewKt.InfoBoxView(PaddingKt.m313paddingVpY3zN4$default(LayoutIdKt.layoutId(Modifier.INSTANCE, Boolean.valueOf(z5)), 0.0f, Dp.m2599constructorimpl(24), i7, null), R.drawable.icon_walking, ((WalkStep) step).getText(), false, startRestartGroup, 48, 8);
                    startRestartGroup.endReplaceGroup();
                } else {
                    i6 = i9;
                    if (step instanceof IconStep) {
                        startRestartGroup.startReplaceGroup(-258308562);
                        IconRow((IconStep) step, startRestartGroup, i6);
                        startRestartGroup.endReplaceGroup();
                    } else if (step instanceof HarborStep) {
                        startRestartGroup.startReplaceGroup(-258211532);
                        HarborRow((HarborStep) step, (i10 == 0 && z6) ? 1 : i6, (i10 == 0 || i10 == size) ? 1 : i6, z6 ? function1 : null, startRestartGroup, 0);
                        startRestartGroup.endReplaceGroup();
                    } else {
                        startRestartGroup.startReplaceGroup(-257844957);
                        startRestartGroup.endReplaceGroup();
                    }
                }
                i9 = i6;
                i10 = i11;
                i7 = 1;
            }
            int i12 = i9;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.endNode();
            if (!z5) {
                BoxKt.Box(boxScope.align(BackgroundKt.background$default(SizeKt.fillMaxWidth$default(SizeKt.m325height3ABfNKs(Modifier.INSTANCE, Dp.m2599constructorimpl(112)), 0.0f, 1, null), Brush.Companion.m1466verticalGradient8A3gB4$default(Brush.INSTANCE, new Pair[]{TuplesKt.to(Float.valueOf(0.0f), Color.m1481boximpl(ColorKt.Color(16054781))), TuplesKt.to(Float.valueOf(1.0f), Color.m1481boximpl(ColorKt.Color(4294244861L)))}, 0.0f, 0.0f, 0, 14, (Object) null), null, 0.0f, 6, null), Alignment.INSTANCE.getBottomCenter()), startRestartGroup, i12);
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: c3.c
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit TravelDetailsContentView$lambda$11;
                    TravelDetailsContentView$lambda$11 = KombardoTravelDetailsViewKt.TravelDetailsContentView$lambda$11(BoxScope.this, list, z5, z6, function1, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return TravelDetailsContentView$lambda$11;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TravelDetailsContentView$lambda$11(BoxScope boxScope, List list, boolean z5, boolean z6, Function1 function1, int i5, Composer composer, int i6) {
        TravelDetailsContentView(boxScope, list, z5, z6, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }
}
