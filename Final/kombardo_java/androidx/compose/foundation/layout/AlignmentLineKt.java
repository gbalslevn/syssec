package androidx.compose.foundation.layout;

import android.support.v4.media.session.a;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.HorizontalAlignmentLine;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.ranges.RangesKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\u001a2\u0010\b\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001a*\u0010\r\u001a\u00020\u0000*\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u0003H\u0007ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\f\u001a>\u0010\u0016\u001a\u00020\u0013*\u00020\u000e2\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0002ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015\"\u0018\u0010\u001a\u001a\u00020\u0017*\u00020\u00018BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u001b"}, d2 = {"Landroidx/compose/ui/Modifier;", "Landroidx/compose/ui/layout/AlignmentLine;", "alignmentLine", "Landroidx/compose/ui/unit/Dp;", "before", "after", "paddingFrom-4j6BHR0", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/layout/AlignmentLine;FF)Landroidx/compose/ui/Modifier;", "paddingFrom", "top", "bottom", "paddingFromBaseline-VpY3zN4", "(Landroidx/compose/ui/Modifier;FF)Landroidx/compose/ui/Modifier;", "paddingFromBaseline", "Landroidx/compose/ui/layout/MeasureScope;", "Landroidx/compose/ui/layout/Measurable;", "measurable", "Landroidx/compose/ui/unit/Constraints;", "constraints", "Landroidx/compose/ui/layout/MeasureResult;", "alignmentLineOffsetMeasure-tjqqzMA", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/AlignmentLine;FFLandroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "alignmentLineOffsetMeasure", BuildConfig.FLAVOR, "getHorizontal", "(Landroidx/compose/ui/layout/AlignmentLine;)Z", "horizontal", "foundation-layout_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class AlignmentLineKt {
    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: alignmentLineOffsetMeasure-tjqqzMA, reason: not valid java name */
    public static final MeasureResult m259alignmentLineOffsetMeasuretjqqzMA(MeasureScope measureScope, final AlignmentLine alignmentLine, final float f5, float f6, Measurable measurable, long j5) {
        final Placeable mo1946measureBRTryo0 = measurable.mo1946measureBRTryo0(getHorizontal(alignmentLine) ? Constraints.m2570copyZbe2FdA$default(j5, 0, 0, 0, 0, 11, null) : Constraints.m2570copyZbe2FdA$default(j5, 0, 0, 0, 0, 14, null));
        int i5 = mo1946measureBRTryo0.get(alignmentLine);
        if (i5 == Integer.MIN_VALUE) {
            i5 = 0;
        }
        int height = getHorizontal(alignmentLine) ? mo1946measureBRTryo0.getHeight() : mo1946measureBRTryo0.getWidth();
        int m2577getMaxHeightimpl = getHorizontal(alignmentLine) ? Constraints.m2577getMaxHeightimpl(j5) : Constraints.m2578getMaxWidthimpl(j5);
        Dp.Companion companion = Dp.INSTANCE;
        int i6 = m2577getMaxHeightimpl - height;
        final int coerceIn = RangesKt.coerceIn((!Dp.m2601equalsimpl0(f5, companion.m2608getUnspecifiedD9Ej5fM()) ? measureScope.mo206roundToPx0680j_4(f5) : 0) - i5, 0, i6);
        final int coerceIn2 = RangesKt.coerceIn(((!Dp.m2601equalsimpl0(f6, companion.m2608getUnspecifiedD9Ej5fM()) ? measureScope.mo206roundToPx0680j_4(f6) : 0) - height) + i5, 0, i6 - coerceIn);
        final int width = getHorizontal(alignmentLine) ? mo1946measureBRTryo0.getWidth() : Math.max(mo1946measureBRTryo0.getWidth() + coerceIn + coerceIn2, Constraints.m2580getMinWidthimpl(j5));
        final int max = getHorizontal(alignmentLine) ? Math.max(mo1946measureBRTryo0.getHeight() + coerceIn + coerceIn2, Constraints.m2579getMinHeightimpl(j5)) : mo1946measureBRTryo0.getHeight();
        return MeasureScope.layout$default(measureScope, width, max, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.layout.AlignmentLineKt$alignmentLineOffsetMeasure$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                invoke2(placementScope);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Placeable.PlacementScope placementScope) {
                boolean horizontal;
                int width2;
                boolean horizontal2;
                horizontal = AlignmentLineKt.getHorizontal(AlignmentLine.this);
                int i7 = 0;
                if (horizontal) {
                    width2 = 0;
                } else {
                    width2 = !Dp.m2601equalsimpl0(f5, Dp.INSTANCE.m2608getUnspecifiedD9Ej5fM()) ? coerceIn : (width - coerceIn2) - mo1946measureBRTryo0.getWidth();
                }
                horizontal2 = AlignmentLineKt.getHorizontal(AlignmentLine.this);
                if (horizontal2) {
                    i7 = !Dp.m2601equalsimpl0(f5, Dp.INSTANCE.m2608getUnspecifiedD9Ej5fM()) ? coerceIn : (max - coerceIn2) - mo1946measureBRTryo0.getHeight();
                }
                Placeable.PlacementScope.placeRelative$default(placementScope, mo1946measureBRTryo0, width2, i7, 0.0f, 4, null);
            }
        }, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean getHorizontal(AlignmentLine alignmentLine) {
        return alignmentLine instanceof HorizontalAlignmentLine;
    }

    /* renamed from: paddingFrom-4j6BHR0, reason: not valid java name */
    public static final Modifier m260paddingFrom4j6BHR0(Modifier modifier, final AlignmentLine alignmentLine, final float f5, final float f6) {
        return modifier.then(new AlignmentLineOffsetDpElement(alignmentLine, f5, f6, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.foundation.layout.AlignmentLineKt$paddingFrom-4j6BHR0$$inlined$debugInspectorInfo$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(InspectorInfo inspectorInfo) {
                a.a(inspectorInfo);
                invoke2((InspectorInfo) null);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(InspectorInfo inspectorInfo) {
                throw null;
            }
        } : InspectableValueKt.getNoInspectorInfo(), null));
    }

    /* renamed from: paddingFrom-4j6BHR0$default, reason: not valid java name */
    public static /* synthetic */ Modifier m261paddingFrom4j6BHR0$default(Modifier modifier, AlignmentLine alignmentLine, float f5, float f6, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            f5 = Dp.INSTANCE.m2608getUnspecifiedD9Ej5fM();
        }
        if ((i5 & 4) != 0) {
            f6 = Dp.INSTANCE.m2608getUnspecifiedD9Ej5fM();
        }
        return m260paddingFrom4j6BHR0(modifier, alignmentLine, f5, f6);
    }

    /* renamed from: paddingFromBaseline-VpY3zN4, reason: not valid java name */
    public static final Modifier m262paddingFromBaselineVpY3zN4(Modifier modifier, float f5, float f6) {
        Dp.Companion companion = Dp.INSTANCE;
        return modifier.then(!Dp.m2601equalsimpl0(f5, companion.m2608getUnspecifiedD9Ej5fM()) ? m261paddingFrom4j6BHR0$default(Modifier.INSTANCE, androidx.compose.ui.layout.AlignmentLineKt.getFirstBaseline(), f5, 0.0f, 4, null) : Modifier.INSTANCE).then(!Dp.m2601equalsimpl0(f6, companion.m2608getUnspecifiedD9Ej5fM()) ? m261paddingFrom4j6BHR0$default(Modifier.INSTANCE, androidx.compose.ui.layout.AlignmentLineKt.getLastBaseline(), 0.0f, f6, 2, null) : Modifier.INSTANCE);
    }
}
