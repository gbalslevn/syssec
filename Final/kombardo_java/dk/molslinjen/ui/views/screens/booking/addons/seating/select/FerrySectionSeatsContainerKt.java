package dk.molslinjen.ui.views.screens.booking.addons.seating.select;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.gestures.TransformableKt;
import androidx.compose.foundation.gestures.TransformableState;
import androidx.compose.foundation.gestures.TransformableStateKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.OnRemeasuredModifierKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import dk.molslinjen.ui.theme.AppColor;
import dk.molslinjen.ui.views.screens.booking.addons.seating.groups.CornerTableLargeViewKt;
import dk.molslinjen.ui.views.screens.booking.addons.seating.groups.CornerTableViewKt;
import dk.molslinjen.ui.views.screens.booking.addons.seating.groups.DoubleSeatViewKt;
import dk.molslinjen.ui.views.screens.booking.addons.seating.groups.LargeTableViewKt;
import dk.molslinjen.ui.views.screens.booking.addons.seating.groups.SingleSeatViewKt;
import dk.molslinjen.ui.views.screens.booking.addons.seating.groups.SmallTableViewKt;
import dk.molslinjen.ui.views.screens.booking.addons.seating.groups.XLargeTableViewKt;
import dk.molslinjen.ui.views.screens.booking.addons.seating.sections.FerrySectionViewKt;
import dk.molslinjen.ui.views.screens.booking.addons.seating.select.FerrySectionSeatsContainerKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.conscrypt.BuildConfig;
import uniffi.molslinjen_shared.FerrySeat;
import uniffi.molslinjen_shared.FerrySeatingGroup;
import uniffi.molslinjen_shared.FerrySeatingGroupType;
import uniffi.molslinjen_shared.FerrySeatingSectionDetails;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\b\u001aG\u0010\r\u001a\u00020\t*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\bH\u0007¢\u0006\u0004\b\u000b\u0010\f\u001a?\u0010\u0011\u001a\u00020\t2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00052\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\bH\u0003¢\u0006\u0004\b\u0011\u0010\u0012\u001a/\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u0018H\u0002¢\u0006\u0004\b\u001a\u0010\u001b\u001a-\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u001d\u0010\u001b¨\u0006 ²\u0006\u000e\u0010\u0017\u001a\u00020\u00168\n@\nX\u008a\u008e\u0002²\u0006\u000e\u0010\u001f\u001a\u00020\u00038\n@\nX\u008a\u008e\u0002"}, d2 = {"Landroidx/compose/foundation/layout/ColumnScope;", "Luniffi/molslinjen_shared/FerrySeatingSectionDetails;", "sectionDetails", "Landroidx/compose/ui/geometry/Offset;", "initialFocusOffset", BuildConfig.FLAVOR, "Luniffi/molslinjen_shared/FerrySeat;", "selectedSeats", "Lkotlin/Function1;", BuildConfig.FLAVOR, "onToggleSeat", "FerrySectionSeatsContainer-cliRtBg", "(Landroidx/compose/foundation/layout/ColumnScope;Luniffi/molslinjen_shared/FerrySeatingSectionDetails;Landroidx/compose/ui/geometry/Offset;Ljava/util/List;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "FerrySectionSeatsContainer", "Luniffi/molslinjen_shared/FerrySeatingGroup;", "seatGroups", "onSeatPressed", "SeatGroups", "(Ljava/util/List;Ljava/util/List;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", BuildConfig.FLAVOR, "sectionWidth", "sectionHeight", "Landroidx/compose/ui/geometry/Size;", "containerSize", BuildConfig.FLAVOR, "extraAllowedOffset", "getTopStartMax-JM5-EMQ", "(IIJF)J", "getTopStartMax", "getBottomEndMax-JM5-EMQ", "getBottomEndMax", "panOffset", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class FerrySectionSeatsContainerKt {
    /* renamed from: FerrySectionSeatsContainer-cliRtBg, reason: not valid java name */
    public static final void m3444FerrySectionSeatsContainercliRtBg(final ColumnScope FerrySectionSeatsContainer, final FerrySeatingSectionDetails sectionDetails, final Offset offset, final List<FerrySeat> selectedSeats, final Function1<? super FerrySeat, Unit> onToggleSeat, Composer composer, final int i5) {
        int i6;
        MutableState mutableState;
        TransformableState transformableState;
        int i7;
        MutableState mutableState2;
        Object obj;
        Composer composer2;
        Intrinsics.checkNotNullParameter(FerrySectionSeatsContainer, "$this$FerrySectionSeatsContainer");
        Intrinsics.checkNotNullParameter(sectionDetails, "sectionDetails");
        Intrinsics.checkNotNullParameter(selectedSeats, "selectedSeats");
        Intrinsics.checkNotNullParameter(onToggleSeat, "onToggleSeat");
        Composer startRestartGroup = composer.startRestartGroup(323894018);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changed(FerrySectionSeatsContainer) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changedInstance(sectionDetails) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i6 |= startRestartGroup.changed(offset) ? 256 : 128;
        }
        if ((i5 & 3072) == 0) {
            i6 |= startRestartGroup.changedInstance(selectedSeats) ? 2048 : 1024;
        }
        if ((i5 & 24576) == 0) {
            i6 |= startRestartGroup.changedInstance(onToggleSeat) ? 16384 : 8192;
        }
        if ((i6 & 9363) == 9362 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(323894018, i6, -1, "dk.molslinjen.ui.views.screens.booking.addons.seating.select.FerrySectionSeatsContainer (FerrySectionSeatsContainer.kt:46)");
            }
            startRestartGroup.startReplaceGroup(-649540980);
            Object rememberedValue = startRestartGroup.rememberedValue();
            Composer.Companion companion = Composer.INSTANCE;
            if (rememberedValue == companion.getEmpty()) {
                rememberedValue = Integer.valueOf((int) sectionDetails.getSize().getWidth());
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            int intValue = ((Number) rememberedValue).intValue();
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(-649538707);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (rememberedValue2 == companion.getEmpty()) {
                rememberedValue2 = Integer.valueOf((int) sectionDetails.getSize().getHeight());
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            int intValue2 = ((Number) rememberedValue2).intValue();
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(-649536380);
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (rememberedValue3 == companion.getEmpty()) {
                rememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Size.m1370boximpl(Size.INSTANCE.m1384getZeroNHjbRc()), null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            MutableState mutableState3 = (MutableState) rememberedValue3;
            startRestartGroup.endReplaceGroup();
            long FerrySectionSeatsContainer_cliRtBg$lambda$3 = FerrySectionSeatsContainer_cliRtBg$lambda$3(mutableState3);
            startRestartGroup.startReplaceGroup(-649534154);
            boolean changed = startRestartGroup.changed(FerrySectionSeatsContainer_cliRtBg$lambda$3);
            Object rememberedValue4 = startRestartGroup.rememberedValue();
            if (changed || rememberedValue4 == companion.getEmpty()) {
                rememberedValue4 = Float.valueOf(Size.m1375getHeightimpl(FerrySectionSeatsContainer_cliRtBg$lambda$3(mutableState3)) * 0.05f);
                startRestartGroup.updateRememberedValue(rememberedValue4);
            }
            float floatValue = ((Number) rememberedValue4).floatValue();
            startRestartGroup.endReplaceGroup();
            long FerrySectionSeatsContainer_cliRtBg$lambda$32 = FerrySectionSeatsContainer_cliRtBg$lambda$3(mutableState3);
            startRestartGroup.startReplaceGroup(-649531386);
            boolean changed2 = startRestartGroup.changed(FerrySectionSeatsContainer_cliRtBg$lambda$32) | startRestartGroup.changed(floatValue);
            Object rememberedValue5 = startRestartGroup.rememberedValue();
            if (changed2 || rememberedValue5 == companion.getEmpty()) {
                rememberedValue5 = Offset.m1328boximpl(Size.m1374equalsimpl0(FerrySectionSeatsContainer_cliRtBg$lambda$3(mutableState3), Size.INSTANCE.m1384getZeroNHjbRc()) ? Offset.INSTANCE.m1349getZeroF1C5BW0() : m3446getTopStartMaxJM5EMQ(intValue, intValue2, FerrySectionSeatsContainer_cliRtBg$lambda$3(mutableState3), floatValue));
                startRestartGroup = startRestartGroup;
                startRestartGroup.updateRememberedValue(rememberedValue5);
            }
            final long packedValue = ((Offset) rememberedValue5).getPackedValue();
            startRestartGroup.endReplaceGroup();
            long FerrySectionSeatsContainer_cliRtBg$lambda$33 = FerrySectionSeatsContainer_cliRtBg$lambda$3(mutableState3);
            startRestartGroup.startReplaceGroup(-649522137);
            boolean changed3 = startRestartGroup.changed(FerrySectionSeatsContainer_cliRtBg$lambda$33) | startRestartGroup.changed(floatValue);
            Object rememberedValue6 = startRestartGroup.rememberedValue();
            if (changed3 || rememberedValue6 == companion.getEmpty()) {
                mutableState = mutableState3;
                rememberedValue6 = Offset.m1328boximpl(Size.m1374equalsimpl0(FerrySectionSeatsContainer_cliRtBg$lambda$3(mutableState3), Size.INSTANCE.m1384getZeroNHjbRc()) ? Offset.INSTANCE.m1349getZeroF1C5BW0() : m3445getBottomEndMaxJM5EMQ(intValue, intValue2, FerrySectionSeatsContainer_cliRtBg$lambda$3(mutableState), floatValue));
                startRestartGroup.updateRememberedValue(rememberedValue6);
            } else {
                mutableState = mutableState3;
            }
            final long packedValue2 = ((Offset) rememberedValue6).getPackedValue();
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(-649513178);
            Object rememberedValue7 = startRestartGroup.rememberedValue();
            if (rememberedValue7 == companion.getEmpty()) {
                rememberedValue7 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Offset.m1328boximpl(Offset.INSTANCE.m1349getZeroF1C5BW0()), null, 2, null);
                startRestartGroup.updateRememberedValue(rememberedValue7);
            }
            final MutableState mutableState4 = (MutableState) rememberedValue7;
            startRestartGroup.endReplaceGroup();
            startRestartGroup.startReplaceGroup(-649509840);
            boolean changed4 = startRestartGroup.changed(packedValue2) | startRestartGroup.changed(packedValue);
            Object rememberedValue8 = startRestartGroup.rememberedValue();
            if (changed4 || rememberedValue8 == companion.getEmpty()) {
                rememberedValue8 = new Function3() { // from class: I2.a
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj2, Object obj3, Object obj4) {
                        Unit FerrySectionSeatsContainer_cliRtBg$lambda$12$lambda$11;
                        FerrySectionSeatsContainer_cliRtBg$lambda$12$lambda$11 = FerrySectionSeatsContainerKt.FerrySectionSeatsContainer_cliRtBg$lambda$12$lambda$11(packedValue2, packedValue, mutableState4, ((Float) obj2).floatValue(), (Offset) obj3, ((Float) obj4).floatValue());
                        return FerrySectionSeatsContainer_cliRtBg$lambda$12$lambda$11;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue8);
            }
            startRestartGroup.endReplaceGroup();
            TransformableState rememberTransformableState = TransformableStateKt.rememberTransformableState((Function3) rememberedValue8, startRestartGroup, 0);
            Offset m1328boximpl = Offset.m1328boximpl(packedValue);
            Offset m1328boximpl2 = Offset.m1328boximpl(packedValue2);
            startRestartGroup.startReplaceGroup(-649499680);
            boolean changed5 = ((i6 & 896) == 256) | startRestartGroup.changed(packedValue) | startRestartGroup.changed(packedValue2) | startRestartGroup.changedInstance(rememberTransformableState);
            Object rememberedValue9 = startRestartGroup.rememberedValue();
            if (changed5 || rememberedValue9 == companion.getEmpty()) {
                transformableState = rememberTransformableState;
                i7 = 1;
                mutableState2 = mutableState;
                obj = null;
                FerrySectionSeatsContainerKt$FerrySectionSeatsContainer$1$1 ferrySectionSeatsContainerKt$FerrySectionSeatsContainer$1$1 = new FerrySectionSeatsContainerKt$FerrySectionSeatsContainer$1$1(offset, packedValue, packedValue2, transformableState, mutableState4, mutableState2, null);
                startRestartGroup.updateRememberedValue(ferrySectionSeatsContainerKt$FerrySectionSeatsContainer$1$1);
                rememberedValue9 = ferrySectionSeatsContainerKt$FerrySectionSeatsContainer$1$1;
            } else {
                transformableState = rememberTransformableState;
                i7 = 1;
                obj = null;
                mutableState2 = mutableState;
            }
            startRestartGroup.endReplaceGroup();
            int i8 = i6 >> 6;
            EffectsKt.LaunchedEffect(offset, m1328boximpl, m1328boximpl2, (Function2) rememberedValue9, startRestartGroup, i8 & 14);
            Modifier.Companion companion2 = Modifier.INSTANCE;
            Object obj2 = obj;
            Composer composer3 = startRestartGroup;
            Modifier m104backgroundbw27NRU$default = BackgroundKt.m104backgroundbw27NRU$default(ColumnScope.weight$default(FerrySectionSeatsContainer, SizeKt.fillMaxSize$default(companion2, 0.0f, i7, obj), 1.0f, false, 2, null), AppColor.INSTANCE.m3268getGrey50d7_KjU(), null, 2, null);
            Alignment.Companion companion3 = Alignment.INSTANCE;
            MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(companion3.getTopStart(), false);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
            CompositionLocalMap currentCompositionLocalMap = composer3.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(composer3, m104backgroundbw27NRU$default);
            ComposeUiNode.Companion companion4 = ComposeUiNode.INSTANCE;
            Function0<ComposeUiNode> constructor = companion4.getConstructor();
            if (composer3.getApplier() == null) {
                ComposablesKt.invalidApplier();
            }
            composer3.startReusableNode();
            if (composer3.getInserting()) {
                composer3.createNode(constructor);
            } else {
                composer3.useNode();
            }
            Composer m1226constructorimpl = Updater.m1226constructorimpl(composer3);
            Updater.m1227setimpl(m1226constructorimpl, maybeCachedBoxMeasurePolicy, companion4.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl, currentCompositionLocalMap, companion4.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = companion4.getSetCompositeKeyHash();
            if (m1226constructorimpl.getInserting() || !Intrinsics.areEqual(m1226constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m1226constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m1226constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m1227setimpl(m1226constructorimpl, materializeModifier, companion4.getSetModifier());
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            Modifier clip = ClipKt.clip(TransformableKt.transformable$default(SizeKt.fillMaxSize$default(companion2, 0.0f, i7, obj2), transformableState, true, false, 4, null), RectangleShapeKt.getRectangleShape());
            composer3.startReplaceGroup(-1714810738);
            Object rememberedValue10 = composer3.rememberedValue();
            if (rememberedValue10 == companion.getEmpty()) {
                rememberedValue10 = new Function1() { // from class: I2.b
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj3) {
                        Unit FerrySectionSeatsContainer_cliRtBg$lambda$19$lambda$15$lambda$14;
                        FerrySectionSeatsContainer_cliRtBg$lambda$19$lambda$15$lambda$14 = FerrySectionSeatsContainerKt.FerrySectionSeatsContainer_cliRtBg$lambda$19$lambda$15$lambda$14(MutableState.this, (GraphicsLayerScope) obj3);
                        return FerrySectionSeatsContainer_cliRtBg$lambda$19$lambda$15$lambda$14;
                    }
                };
                composer3.updateRememberedValue(rememberedValue10);
            }
            composer3.endReplaceGroup();
            Modifier graphicsLayer = GraphicsLayerModifierKt.graphicsLayer(clip, (Function1) rememberedValue10);
            composer3.startReplaceGroup(-1714806180);
            Object rememberedValue11 = composer3.rememberedValue();
            if (rememberedValue11 == companion.getEmpty()) {
                final MutableState mutableState5 = mutableState2;
                rememberedValue11 = new Function1() { // from class: I2.c
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj3) {
                        Unit FerrySectionSeatsContainer_cliRtBg$lambda$19$lambda$17$lambda$16;
                        FerrySectionSeatsContainer_cliRtBg$lambda$19$lambda$17$lambda$16 = FerrySectionSeatsContainerKt.FerrySectionSeatsContainer_cliRtBg$lambda$19$lambda$17$lambda$16(MutableState.this, (IntSize) obj3);
                        return FerrySectionSeatsContainer_cliRtBg$lambda$19$lambda$17$lambda$16;
                    }
                };
                composer3.updateRememberedValue(rememberedValue11);
            }
            composer3.endReplaceGroup();
            Modifier onSizeChanged = OnRemeasuredModifierKt.onSizeChanged(graphicsLayer, (Function1) rememberedValue11);
            MeasurePolicy maybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(companion3.getTopStart(), false);
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
            CompositionLocalMap currentCompositionLocalMap2 = composer3.getCurrentCompositionLocalMap();
            Modifier materializeModifier2 = ComposedModifierKt.materializeModifier(composer3, onSizeChanged);
            Function0<ComposeUiNode> constructor2 = companion4.getConstructor();
            if (composer3.getApplier() == null) {
                ComposablesKt.invalidApplier();
            }
            composer3.startReusableNode();
            if (composer3.getInserting()) {
                composer3.createNode(constructor2);
            } else {
                composer3.useNode();
            }
            Composer m1226constructorimpl2 = Updater.m1226constructorimpl(composer3);
            Updater.m1227setimpl(m1226constructorimpl2, maybeCachedBoxMeasurePolicy2, companion4.getSetMeasurePolicy());
            Updater.m1227setimpl(m1226constructorimpl2, currentCompositionLocalMap2, companion4.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = companion4.getSetCompositeKeyHash();
            if (m1226constructorimpl2.getInserting() || !Intrinsics.areEqual(m1226constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                m1226constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                m1226constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            Updater.m1227setimpl(m1226constructorimpl2, materializeModifier2, companion4.getSetModifier());
            composer2 = composer3;
            FerrySectionViewKt.m3443FerrySectionViewjA1GFJw(null, sectionDetails.getCoordinates(), sectionDetails.getSize(), 0L, 0L, composer2, 0, 25);
            SeatGroups(sectionDetails.getSeatGroups(), selectedSeats, onToggleSeat, composer2, i8 & 1008);
            composer2.endNode();
            composer2.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: I2.d
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj3, Object obj4) {
                    Unit FerrySectionSeatsContainer_cliRtBg$lambda$20;
                    FerrySectionSeatsContainer_cliRtBg$lambda$20 = FerrySectionSeatsContainerKt.FerrySectionSeatsContainer_cliRtBg$lambda$20(ColumnScope.this, sectionDetails, offset, selectedSeats, onToggleSeat, i5, (Composer) obj3, ((Integer) obj4).intValue());
                    return FerrySectionSeatsContainer_cliRtBg$lambda$20;
                }
            });
        }
    }

    private static final void FerrySectionSeatsContainer_cliRtBg$lambda$10(MutableState<Offset> mutableState, long j5) {
        mutableState.setValue(Offset.m1328boximpl(j5));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FerrySectionSeatsContainer_cliRtBg$lambda$12$lambda$11(long j5, long j6, MutableState mutableState, float f5, Offset offset, float f6) {
        FerrySectionSeatsContainer_cliRtBg$lambda$10(mutableState, OffsetKt.Offset(RangesKt.coerceIn(Offset.m1337getXimpl(FerrySectionSeatsContainer_cliRtBg$lambda$9(mutableState)) + Offset.m1337getXimpl(offset.getPackedValue()), Offset.m1337getXimpl(j5), Offset.m1337getXimpl(j6)), RangesKt.coerceIn(Offset.m1338getYimpl(FerrySectionSeatsContainer_cliRtBg$lambda$9(mutableState)) + Offset.m1338getYimpl(offset.getPackedValue()), Offset.m1338getYimpl(j5), Offset.m1338getYimpl(j6))));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FerrySectionSeatsContainer_cliRtBg$lambda$19$lambda$15$lambda$14(MutableState mutableState, GraphicsLayerScope graphicsLayer) {
        Intrinsics.checkNotNullParameter(graphicsLayer, "$this$graphicsLayer");
        graphicsLayer.setTranslationX(Offset.m1337getXimpl(FerrySectionSeatsContainer_cliRtBg$lambda$9(mutableState)));
        graphicsLayer.setTranslationY(Offset.m1338getYimpl(FerrySectionSeatsContainer_cliRtBg$lambda$9(mutableState)));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FerrySectionSeatsContainer_cliRtBg$lambda$19$lambda$17$lambda$16(MutableState mutableState, IntSize intSize) {
        FerrySectionSeatsContainer_cliRtBg$lambda$4(mutableState, IntSizeKt.m2668toSizeozmzZPI(intSize.getPackedValue()));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FerrySectionSeatsContainer_cliRtBg$lambda$20(ColumnScope columnScope, FerrySeatingSectionDetails ferrySeatingSectionDetails, Offset offset, List list, Function1 function1, int i5, Composer composer, int i6) {
        m3444FerrySectionSeatsContainercliRtBg(columnScope, ferrySeatingSectionDetails, offset, list, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long FerrySectionSeatsContainer_cliRtBg$lambda$3(MutableState<Size> mutableState) {
        return mutableState.getValue().getPackedValue();
    }

    private static final void FerrySectionSeatsContainer_cliRtBg$lambda$4(MutableState<Size> mutableState, long j5) {
        mutableState.setValue(Size.m1370boximpl(j5));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long FerrySectionSeatsContainer_cliRtBg$lambda$9(MutableState<Offset> mutableState) {
        return mutableState.getValue().getPackedValue();
    }

    private static final void SeatGroups(final List<FerrySeatingGroup> list, final List<FerrySeat> list2, final Function1<? super FerrySeat, Unit> function1, Composer composer, final int i5) {
        Composer startRestartGroup = composer.startRestartGroup(-581193970);
        int i6 = (i5 & 6) == 0 ? (startRestartGroup.changedInstance(list) ? 4 : 2) | i5 : i5;
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changedInstance(list2) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i6 |= startRestartGroup.changedInstance(function1) ? 256 : 128;
        }
        int i7 = i6;
        if ((i7 & 147) == 146 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-581193970, i7, -1, "dk.molslinjen.ui.views.screens.booking.addons.seating.select.SeatGroups (FerrySectionSeatsContainer.kt:127)");
            }
            for (FerrySeatingGroup ferrySeatingGroup : list) {
                FerrySeatingGroupType groupType = ferrySeatingGroup.getGroupType();
                if (groupType instanceof FerrySeatingGroupType.SingleSeat) {
                    startRestartGroup.startReplaceGroup(1090344822);
                    SingleSeatViewKt.SingleSeatView((FerrySeatingGroupType.SingleSeat) groupType, ferrySeatingGroup.getOrigin(), (float) ferrySeatingGroup.getRotation(), list2, function1, startRestartGroup, (i7 << 6) & 64512);
                    startRestartGroup.endReplaceGroup();
                } else if (groupType instanceof FerrySeatingGroupType.DoubleSeat) {
                    startRestartGroup.startReplaceGroup(1090354630);
                    DoubleSeatViewKt.DoubleSeatView((FerrySeatingGroupType.DoubleSeat) groupType, ferrySeatingGroup.getOrigin(), (float) ferrySeatingGroup.getRotation(), list2, function1, startRestartGroup, (i7 << 6) & 64512);
                    startRestartGroup.endReplaceGroup();
                } else if (groupType instanceof FerrySeatingGroupType.SmallTable) {
                    startRestartGroup.startReplaceGroup(1090363958);
                    SmallTableViewKt.SmallTableView((FerrySeatingGroupType.SmallTable) groupType, ferrySeatingGroup.getOrigin(), (float) ferrySeatingGroup.getRotation(), list2, function1, startRestartGroup, (i7 << 6) & 64512);
                    startRestartGroup.endReplaceGroup();
                } else if (groupType instanceof FerrySeatingGroupType.LargeTable) {
                    startRestartGroup.startReplaceGroup(1090373782);
                    LargeTableViewKt.LargeTableView((FerrySeatingGroupType.LargeTable) groupType, ferrySeatingGroup.getOrigin(), (float) ferrySeatingGroup.getRotation(), list2, function1, startRestartGroup, (i7 << 6) & 64512);
                    startRestartGroup.endReplaceGroup();
                } else if (groupType instanceof FerrySeatingGroupType.XLargeTable) {
                    startRestartGroup.startReplaceGroup(1090383640);
                    XLargeTableViewKt.XLargeTableView((FerrySeatingGroupType.XLargeTable) groupType, ferrySeatingGroup.getOrigin(), (float) ferrySeatingGroup.getRotation(), list2, function1, startRestartGroup, (i7 << 6) & 64512);
                    startRestartGroup.endReplaceGroup();
                } else if (groupType instanceof FerrySeatingGroupType.CornerTable) {
                    startRestartGroup.startReplaceGroup(1090393560);
                    CornerTableViewKt.CornerTableView((FerrySeatingGroupType.CornerTable) groupType, ferrySeatingGroup.getOrigin(), (float) ferrySeatingGroup.getRotation(), list2, function1, startRestartGroup, (i7 << 6) & 64512);
                    startRestartGroup.endReplaceGroup();
                } else {
                    if (!(groupType instanceof FerrySeatingGroupType.CornerTableLarge)) {
                        startRestartGroup.startReplaceGroup(1090343830);
                        startRestartGroup.endReplaceGroup();
                        throw new NoWhenBranchMatchedException();
                    }
                    startRestartGroup.startReplaceGroup(1090403650);
                    CornerTableLargeViewKt.CornerTableLargeView((FerrySeatingGroupType.CornerTableLarge) groupType, ferrySeatingGroup.getOrigin(), (float) ferrySeatingGroup.getRotation(), list2, function1, startRestartGroup, (i7 << 6) & 64512);
                    startRestartGroup.endReplaceGroup();
                }
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: I2.e
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit SeatGroups$lambda$22;
                    SeatGroups$lambda$22 = FerrySectionSeatsContainerKt.SeatGroups$lambda$22(list, list2, function1, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return SeatGroups$lambda$22;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SeatGroups$lambda$22(List list, List list2, Function1 function1, int i5, Composer composer, int i6) {
        SeatGroups(list, list2, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    /* renamed from: getBottomEndMax-JM5-EMQ, reason: not valid java name */
    public static final long m3445getBottomEndMaxJM5EMQ(int i5, int i6, long j5, float f5) {
        float f6 = i5;
        float m1377getWidthimpl = f6 < Size.m1377getWidthimpl(j5) - f5 ? (Size.m1377getWidthimpl(j5) - f6) * 0.5f : -((f6 - Size.m1377getWidthimpl(j5)) + f5);
        float f7 = i6;
        return OffsetKt.Offset(m1377getWidthimpl, f7 < Size.m1375getHeightimpl(j5) - f5 ? (Size.m1375getHeightimpl(j5) - f7) * 0.5f : -((f7 - Size.m1375getHeightimpl(j5)) + f5));
    }

    /* renamed from: getTopStartMax-JM5-EMQ, reason: not valid java name */
    private static final long m3446getTopStartMaxJM5EMQ(int i5, int i6, long j5, float f5) {
        float f6 = i5;
        float m1377getWidthimpl = f6 < Size.m1377getWidthimpl(j5) - f5 ? (Size.m1377getWidthimpl(j5) - f6) * 0.5f : f5;
        float f7 = i6;
        if (f7 < Size.m1375getHeightimpl(j5) - f5) {
            f5 = (Size.m1375getHeightimpl(j5) - f7) * 0.5f;
        }
        return OffsetKt.Offset(m1377getWidthimpl, f5);
    }
}
