package dk.molslinjen.ui.views.screens.booking.addons.seating.groups;

import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.IntrinsicKt;
import androidx.compose.foundation.layout.IntrinsicSize;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
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
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.TransformOriginKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.PainterResources_androidKt;
import dk.molslinjen.core.extensions.Accessibility;
import dk.molslinjen.extensions.ComposeExtensionsKt;
import dk.molslinjen.ui.views.screens.booking.addons.seating.groups.BaseSeatingViewsKt;
import dk.molslinjen.ui.views.screens.booking.addons.seating.select.FerrySectionSeatsViewModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;
import uniffi.molslinjen_shared.Point;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\u001a\u001f\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\n\b\u0001\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0007¢\u0006\u0004\b\u0004\u0010\u0005\u001a'\u0010\t\u001a\u00020\u0003*\u00020\u00062\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00030\u0007H\u0007¢\u0006\u0004\b\t\u0010\n\u001a3\u0010\u000f\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00030\u0007H\u0007¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Landroidx/compose/foundation/layout/RowScope;", BuildConfig.FLAVOR, "tableRes", BuildConfig.FLAVOR, "SeatTableView", "(Landroidx/compose/foundation/layout/RowScope;Ljava/lang/Integer;Landroidx/compose/runtime/Composer;I)V", "Landroidx/compose/foundation/layout/ColumnScope;", "Lkotlin/Function1;", "content", "BaseSeatingRow", "(Landroidx/compose/foundation/layout/ColumnScope;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;I)V", "Luniffi/molslinjen_shared/Point;", "origin", BuildConfig.FLAVOR, "rotation", "BaseSeatingContainer", "(Luniffi/molslinjen_shared/Point;FLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;I)V", "app_kombardoProd"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes2.dex */
public abstract class BaseSeatingViewsKt {
    public static final void BaseSeatingContainer(final Point origin, final float f5, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> content, Composer composer, final int i5) {
        int i6;
        Intrinsics.checkNotNullParameter(origin, "origin");
        Intrinsics.checkNotNullParameter(content, "content");
        Composer startRestartGroup = composer.startRestartGroup(-668084913);
        if ((i5 & 6) == 0) {
            i6 = (startRestartGroup.changedInstance(origin) ? 4 : 2) | i5;
        } else {
            i6 = i5;
        }
        if ((i5 & 48) == 0) {
            i6 |= startRestartGroup.changed(f5) ? 32 : 16;
        }
        if ((i5 & 384) == 0) {
            i6 |= startRestartGroup.changedInstance(content) ? 256 : 128;
        }
        if ((i6 & 147) == 146 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-668084913, i6, -1, "dk.molslinjen.ui.views.screens.booking.addons.seating.groups.BaseSeatingContainer (BaseSeatingViews.kt:44)");
            }
            Modifier m294offsetVpY3zN4 = OffsetKt.m294offsetVpY3zN4(Modifier.INSTANCE, ComposeExtensionsKt.pxToDp((int) origin.getX(), startRestartGroup, 0), ComposeExtensionsKt.pxToDp((int) origin.getY(), startRestartGroup, 0));
            startRestartGroup.startReplaceGroup(1859813106);
            boolean z5 = (i6 & 112) == 32;
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (z5 || rememberedValue == Composer.INSTANCE.getEmpty()) {
                rememberedValue = new Function1() { // from class: F2.a
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        Unit BaseSeatingContainer$lambda$5$lambda$4;
                        BaseSeatingContainer$lambda$5$lambda$4 = BaseSeatingViewsKt.BaseSeatingContainer$lambda$5$lambda$4(f5, (GraphicsLayerScope) obj);
                        return BaseSeatingContainer$lambda$5$lambda$4;
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceGroup();
            Modifier graphicsLayer = GraphicsLayerModifierKt.graphicsLayer(m294offsetVpY3zN4, (Function1) rememberedValue);
            IntrinsicSize intrinsicSize = IntrinsicSize.Min;
            Modifier width = IntrinsicKt.width(IntrinsicKt.height(graphicsLayer, intrinsicSize), intrinsicSize);
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.m265spacedBy0680j_4(FerrySectionSeatsViewModel.INSTANCE.m3452getVerticalSpacingD9Ej5fM()), Alignment.INSTANCE.getStart(), startRestartGroup, 6);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier(startRestartGroup, width);
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
            content.invoke(ColumnScopeInstance.INSTANCE, startRestartGroup, Integer.valueOf(((i6 >> 3) & 112) | 6));
            startRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: F2.b
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit BaseSeatingContainer$lambda$7;
                    BaseSeatingContainer$lambda$7 = BaseSeatingViewsKt.BaseSeatingContainer$lambda$7(Point.this, f5, content, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return BaseSeatingContainer$lambda$7;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BaseSeatingContainer$lambda$5$lambda$4(float f5, GraphicsLayerScope graphicsLayer) {
        Intrinsics.checkNotNullParameter(graphicsLayer, "$this$graphicsLayer");
        graphicsLayer.mo1530setTransformOrigin__ExYCQ(TransformOriginKt.TransformOrigin(0.0f, 0.0f));
        graphicsLayer.setRotationZ(f5);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BaseSeatingContainer$lambda$7(Point point, float f5, Function3 function3, int i5, Composer composer, int i6) {
        BaseSeatingContainer(point, f5, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    public static final void BaseSeatingRow(final ColumnScope columnScope, final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> content, Composer composer, final int i5) {
        int i6;
        Intrinsics.checkNotNullParameter(columnScope, "<this>");
        Intrinsics.checkNotNullParameter(content, "content");
        Composer startRestartGroup = composer.startRestartGroup(-945449286);
        if ((i5 & 48) == 0) {
            i6 = (startRestartGroup.changedInstance(content) ? 32 : 16) | i5;
        } else {
            i6 = i5;
        }
        if ((i6 & 17) == 16 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-945449286, i6, -1, "dk.molslinjen.ui.views.screens.booking.addons.seating.groups.BaseSeatingRow (BaseSeatingViews.kt:37)");
            }
            Arrangement.HorizontalOrVertical m265spacedBy0680j_4 = Arrangement.INSTANCE.m265spacedBy0680j_4(FerrySectionSeatsViewModel.INSTANCE.m3450getHorizontalSpacingD9Ej5fM());
            Modifier.Companion companion = Modifier.INSTANCE;
            MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(m265spacedBy0680j_4, Alignment.INSTANCE.getTop(), startRestartGroup, 6);
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
            content.invoke(RowScopeInstance.INSTANCE, startRestartGroup, Integer.valueOf((i6 & 112) | 6));
            startRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: F2.d
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit BaseSeatingRow$lambda$3;
                    BaseSeatingRow$lambda$3 = BaseSeatingViewsKt.BaseSeatingRow$lambda$3(ColumnScope.this, content, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return BaseSeatingRow$lambda$3;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BaseSeatingRow$lambda$3(ColumnScope columnScope, Function3 function3, int i5, Composer composer, int i6) {
        BaseSeatingRow(columnScope, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }

    public static final void SeatTableView(final RowScope rowScope, final Integer num, Composer composer, final int i5) {
        int i6;
        Intrinsics.checkNotNullParameter(rowScope, "<this>");
        Composer startRestartGroup = composer.startRestartGroup(1737650203);
        if ((i5 & 48) == 0) {
            i6 = (startRestartGroup.changed(num) ? 32 : 16) | i5;
        } else {
            i6 = i5;
        }
        if ((i6 & 17) == 16 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1737650203, i6, -1, "dk.molslinjen.ui.views.screens.booking.addons.seating.groups.SeatTableView (BaseSeatingViews.kt:27)");
            }
            if (num != null) {
                ImageKt.Image(PainterResources_androidKt.painterResource(num.intValue(), startRestartGroup, 0), Accessibility.INSTANCE.getSkip(), null, null, null, 0.0f, null, startRestartGroup, 0, 124);
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: F2.c
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    Unit SeatTableView$lambda$1;
                    SeatTableView$lambda$1 = BaseSeatingViewsKt.SeatTableView$lambda$1(RowScope.this, num, i5, (Composer) obj, ((Integer) obj2).intValue());
                    return SeatTableView$lambda$1;
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SeatTableView$lambda$1(RowScope rowScope, Integer num, int i5, Composer composer, int i6) {
        SeatTableView(rowScope, num, composer, RecomposeScopeImplKt.updateChangedFlags(i5 | 1));
        return Unit.INSTANCE;
    }
}
