package dk.molslinjen.ui.views.screens.agreements.multiride.details;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
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
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.unit.Dp;
import dk.molslinjen.core.extensions.Accessibility;
import dk.molslinjen.domain.model.agreement.multiRide.MultiRideAssociatedVehicle;
import dk.molslinjen.extensions.ModifierExtensionsKt;
import dk.molslinjen.kombardo.R;
import dk.molslinjen.ui.theme.AppColor;
import dk.molslinjen.ui.theme.ThemeShapesKt;
import dk.molslinjen.ui.theme.TypographyKt;
import dk.molslinjen.ui.views.reusable.HorizontalDividerKt;
import dk.molslinjen.ui.views.screens.agreements.multiride.details.MultiRideAssociatedVehicleRowKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a-\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0001\u001a\u00020\u00002\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0007¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Ldk/molslinjen/domain/model/agreement/multiRide/MultiRideAssociatedVehicle;", "associatedVehicle", "Lkotlin/Function0;", BuildConfig.FLAVOR, "removeVehicleAssociation", "Ldk/molslinjen/ui/views/screens/agreements/multiride/details/MultiRideAssociatedVehicleRowStyle;", "style", "MultiRideAssociatedVehicleRow", "(Ldk/molslinjen/domain/model/agreement/multiRide/MultiRideAssociatedVehicle;Lkotlin/jvm/functions/Function0;Ldk/molslinjen/ui/views/screens/agreements/multiride/details/MultiRideAssociatedVehicleRowStyle;Landroidx/compose/runtime/Composer;I)V", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class MultiRideAssociatedVehicleRowKt {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[MultiRideAssociatedVehicleRowStyle.values().length];
            try {
                iArr[MultiRideAssociatedVehicleRowStyle.First.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[MultiRideAssociatedVehicleRowStyle.Middle.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[MultiRideAssociatedVehicleRowStyle.Last.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[MultiRideAssociatedVehicleRowStyle.SingleItem.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final void MultiRideAssociatedVehicleRow(final MultiRideAssociatedVehicle associatedVehicle, final Function0<Unit> removeVehicleAssociation, final MultiRideAssociatedVehicleRowStyle style, Composer composer, final int i5) {
        int i6;
        int i7;
        Shape m462RoundedCornerShapea9UjIt4$default;
        Composer composer2;
        Intrinsics.checkNotNullParameter(associatedVehicle, "associatedVehicle");
        Intrinsics.checkNotNullParameter(removeVehicleAssociation, "removeVehicleAssociation");
        Intrinsics.checkNotNullParameter(style, "style");
        Composer startRestartGroup = composer.startRestartGroup(-1814497872);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(associatedVehicle) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changedInstance(removeVehicleAssociation) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i6 |= startRestartGroup.changed(style) ? 256 : 128;
        }
        if ((i6 & 147) == 146 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1814497872, i6, -1, "dk.molslinjen.ui.views.screens.agreements.multiride.details.MultiRideAssociatedVehicleRow (MultiRideAssociatedVehicleRow.kt:37)");
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            Arrangement arrangement = Arrangement.INSTANCE;
            Arrangement.Vertical top = arrangement.getTop();
            Alignment.Companion companion2 = Alignment.INSTANCE;
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(top, companion2.getStart(), startRestartGroup, 0);
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
            Updater.m1227setimpl(m1226constructorimpl, columnMeasurePolicy, companion3.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion3.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion3.getSetCompositeKeyHash();
            if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion3.getSetModifier());
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            startRestartGroup.startReplaceGroup(-1957969710);
            if (style == MultiRideAssociatedVehicleRowStyle.Middle || style == MultiRideAssociatedVehicleRowStyle.Last) {
                i7 = 16;
                HorizontalDividerKt.m3388HorizontalDividertZIQpXc(null, 0L, 0.0f, null, startRestartGroup, 0, 15);
            } else {
                i7 = 16;
            }
            startRestartGroup.endReplaceGroup();
            int i8 = WhenMappings.$EnumSwitchMapping$0[style.ordinal()];
            if (i8 == 1) {
                float f5 = 8;
                m462RoundedCornerShapea9UjIt4$default = RoundedCornerShapeKt.m462RoundedCornerShapea9UjIt4$default(Dp.m2599constructorimpl(f5), Dp.m2599constructorimpl(f5), 0.0f, 0.0f, 12, null);
            } else if (i8 == 2) {
                m462RoundedCornerShapea9UjIt4$default = RectangleShapeKt.getRectangleShape();
            } else if (i8 == 3) {
                float f6 = 8;
                m462RoundedCornerShapea9UjIt4$default = RoundedCornerShapeKt.m462RoundedCornerShapea9UjIt4$default(0.0f, 0.0f, Dp.m2599constructorimpl(f6), Dp.m2599constructorimpl(f6), 3, null);
            } else {
                if (i8 != 4) {
                    throw new NoWhenBranchMatchedException();
                }
                m462RoundedCornerShapea9UjIt4$default = ThemeShapesKt.getThemeShapes().getMedium();
            }
            Modifier defaultShadow = ModifierExtensionsKt.defaultShadow(companion, m462RoundedCornerShapea9UjIt4$default);
            AppColor appColor = AppColor.INSTANCE;
            float f7 = i7;
            float f8 = 24;
            Modifier m314paddingqDBjuR0 = PaddingKt.m314paddingqDBjuR0(BackgroundKt.m103backgroundbw27NRU(defaultShadow, appColor.m3281getWhite0d7_KjU(), m462RoundedCornerShapea9UjIt4$default), Dp.m2599constructorimpl(f7), Dp.m2599constructorimpl(f7), Dp.m2599constructorimpl(f8), Dp.m2599constructorimpl(f7));
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(arrangement.getStart(), companion2.getCenterVertically(), startRestartGroup, 48);
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(startRestartGroup, m314paddingqDBjuR0);
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
            IconKt.m857Iconww6aTOc(PainterResources_androidKt.painterResource(R.drawable.icon_car, startRestartGroup, 6), Accessibility.INSTANCE.getSkip(), SizeKt.m331size3ABfNKs(companion, Dp.m2599constructorimpl(f8)), appColor.m3266getGrey30d7_KjU(), startRestartGroup, 3456, 0);
            SpacerKt.Spacer(SizeKt.m336width3ABfNKs(companion, Dp.m2599constructorimpl(f7)), startRestartGroup, 6);
            Modifier weight$default = RowScope.weight$default(rowScopeInstance, companion, 1.0f, false, 2, null);
            MeasurePolicy columnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(arrangement.getTop(), companion2.getStart(), startRestartGroup, 0);
            int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap3 = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier3 = ComposedModifierKt.materializeModifier(startRestartGroup, weight$default);
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
            Updater.m1227setimpl(m1226constructorimpl3, columnMeasurePolicy2, companion3.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl3, currentCompositionLocalMap3, companion3.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = companion3.getSetCompositeKeyHash();
            if (m1226constructorimpl3.getInserting() || !Intrinsics.areEqual(m1226constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                m1226constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                m1226constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
            }
            Updater.m1227setimpl(m1226constructorimpl3, materializeModifier3, companion3.getSetModifier());
            TextKt.m940Text4IGK_g(associatedVehicle.getName(), null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 1, 0, null, TypographyKt.getParagraph(), startRestartGroup, 0, 1575936, 57342);
            TextKt.m940Text4IGK_g(associatedVehicle.getLicensePlate(), PaddingKt.m313paddingVpY3zN4$default(companion, 0.0f, Dp.m2599constructorimpl(4), 1, null), appColor.m3264getGrey10d7_KjU(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, TypographyKt.getSub(), startRestartGroup, 432, 1572864, 65528);
            startRestartGroup.endNode();
            SpacerKt.Spacer(SizeKt.m336width3ABfNKs(companion, Dp.m2599constructorimpl(f7)), startRestartGroup, 6);
            composer2 = startRestartGroup;
            IconKt.m857Iconww6aTOc(PainterResources_androidKt.painterResource(R.drawable.icon_trash_circle, startRestartGroup, 6), StringResources_androidKt.stringResource(R.string.accessibilityLabel_remove, startRestartGroup, 6), ClickableKt.m122clickableXHw0xAI$default(SizeKt.m331size3ABfNKs(companion, Dp.m2599constructorimpl(32)), false, null, null, removeVehicleAssociation, 7, null), Color.INSTANCE.m1501getUnspecified0d7_KjU(), composer2, 3072, 0);
            composer2.endNode();
            composer2.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: y2.a
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit MultiRideAssociatedVehicleRow$lambda$3;
                    MultiRideAssociatedVehicleRow$lambda$3 = MultiRideAssociatedVehicleRowKt.MultiRideAssociatedVehicleRow$lambda$3(MultiRideAssociatedVehicle.this, removeVehicleAssociation, style, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return MultiRideAssociatedVehicleRow$lambda$3;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MultiRideAssociatedVehicleRow$lambda$3(MultiRideAssociatedVehicle multiRideAssociatedVehicle, Function0 function0, MultiRideAssociatedVehicleRowStyle multiRideAssociatedVehicleRowStyle, int i5, Composer composer, int i6) {
        MultiRideAssociatedVehicleRow(multiRideAssociatedVehicle, function0, multiRideAssociatedVehicleRowStyle, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }
}
