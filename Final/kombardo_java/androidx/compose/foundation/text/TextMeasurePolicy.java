package androidx.compose.foundation.text;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import org.conscrypt.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B+\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0016\u0010\u0005\u001a\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u00060\u0003¢\u0006\u0002\u0010\bJ,\u0010\t\u001a\u00020\n*\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u00062\u0006\u0010\u000e\u001a\u00020\u000fH\u0016ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0005\u001a\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u00060\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0012"}, d2 = {"Landroidx/compose/foundation/text/TextMeasurePolicy;", "Landroidx/compose/ui/layout/MeasurePolicy;", "shouldMeasureLinks", "Lkotlin/Function0;", BuildConfig.FLAVOR, "placements", BuildConfig.FLAVOR, "Landroidx/compose/ui/geometry/Rect;", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurables", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Landroidx/compose/ui/layout/MeasureResult;", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class TextMeasurePolicy implements MeasurePolicy {
    private final Function0<List<Rect>> placements;
    private final Function0<Boolean> shouldMeasureLinks;

    /* JADX WARN: Multi-variable type inference failed */
    public TextMeasurePolicy(Function0<Boolean> function0, Function0<? extends List<Rect>> function02) {
        this.shouldMeasureLinks = function0;
        this.placements = function02;
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    /* renamed from: measure-3p2s80s */
    public MeasureResult mo19measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j5) {
        final List measureWithTextRangeMeasureConstraints;
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i5 = 0; i5 < size; i5++) {
            Measurable measurable = list.get(i5);
            if (!(measurable.getParentData() instanceof TextRangeLayoutModifier)) {
                arrayList.add(measurable);
            }
        }
        List<Rect> invoke = this.placements.invoke();
        final ArrayList arrayList2 = null;
        if (invoke != null) {
            ArrayList arrayList3 = new ArrayList(invoke.size());
            int size2 = invoke.size();
            for (int i6 = 0; i6 < size2; i6++) {
                Rect rect = invoke.get(i6);
                Pair pair = rect != null ? new Pair(((Measurable) arrayList.get(i6)).mo1946measureBRTryo0(ConstraintsKt.Constraints$default(0, (int) Math.floor(rect.getWidth()), 0, (int) Math.floor(rect.getHeight()), 5, null)), IntOffset.m2632boximpl(IntOffsetKt.IntOffset(Math.round(rect.getLeft()), Math.round(rect.getTop())))) : null;
                if (pair != null) {
                    arrayList3.add(pair);
                }
            }
            arrayList2 = arrayList3;
        }
        ArrayList arrayList4 = new ArrayList(list.size());
        int size3 = list.size();
        for (int i7 = 0; i7 < size3; i7++) {
            Measurable measurable2 = list.get(i7);
            if (measurable2.getParentData() instanceof TextRangeLayoutModifier) {
                arrayList4.add(measurable2);
            }
        }
        measureWithTextRangeMeasureConstraints = BasicTextKt.measureWithTextRangeMeasureConstraints(arrayList4, this.shouldMeasureLinks);
        return MeasureScope.layout$default(measureScope, Constraints.m2578getMaxWidthimpl(j5), Constraints.m2577getMaxHeightimpl(j5), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.text.TextMeasurePolicy$measure$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
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
                List<Pair<Placeable, IntOffset>> list2 = arrayList2;
                if (list2 != null) {
                    int size4 = list2.size();
                    for (int i8 = 0; i8 < size4; i8++) {
                        Pair<Placeable, IntOffset> pair2 = list2.get(i8);
                        Placeable.PlacementScope.m1968place70tqf50$default(placementScope, pair2.component1(), pair2.component2().getPackedValue(), 0.0f, 2, null);
                    }
                }
                List<Pair<Placeable, Function0<IntOffset>>> list3 = measureWithTextRangeMeasureConstraints;
                if (list3 != null) {
                    int size5 = list3.size();
                    for (int i9 = 0; i9 < size5; i9++) {
                        Pair<Placeable, Function0<IntOffset>> pair3 = list3.get(i9);
                        Placeable component1 = pair3.component1();
                        Function0<IntOffset> component2 = pair3.component2();
                        Placeable.PlacementScope.m1968place70tqf50$default(placementScope, component1, component2 != null ? component2.invoke().getPackedValue() : IntOffset.INSTANCE.m2648getZeronOccac(), 0.0f, 2, null);
                    }
                }
            }
        }, 4, null);
    }
}
