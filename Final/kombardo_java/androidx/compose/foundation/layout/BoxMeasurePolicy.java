package androidx.compose.foundation.layout;

import androidx.compose.ui.Alignment;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$IntRef;
import org.conscrypt.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\b\u0082\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J,\u0010\u0011\u001a\u00020\u000e*\u00020\b2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\r\u001a\u00020\fH\u0016ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0016\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u001a\u0010\u001a\u001a\u00020\u00042\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018HÖ\u0003¢\u0006\u0004\b\u001a\u0010\u001bR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u001cR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u001d\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u001e"}, d2 = {"Landroidx/compose/foundation/layout/BoxMeasurePolicy;", "Landroidx/compose/ui/layout/MeasurePolicy;", "Landroidx/compose/ui/Alignment;", "alignment", BuildConfig.FLAVOR, "propagateMinConstraints", "<init>", "(Landroidx/compose/ui/Alignment;Z)V", "Landroidx/compose/ui/layout/MeasureScope;", BuildConfig.FLAVOR, "Landroidx/compose/ui/layout/Measurable;", "measurables", "Landroidx/compose/ui/unit/Constraints;", "constraints", "Landroidx/compose/ui/layout/MeasureResult;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Landroidx/compose/ui/layout/MeasureResult;", "measure", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", BuildConfig.FLAVOR, "hashCode", "()I", BuildConfig.FLAVOR, "other", "equals", "(Ljava/lang/Object;)Z", "Landroidx/compose/ui/Alignment;", "Z", "foundation-layout_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class BoxMeasurePolicy implements MeasurePolicy {
    private final Alignment alignment;
    private final boolean propagateMinConstraints;

    public BoxMeasurePolicy(Alignment alignment, boolean z5) {
        this.alignment = alignment;
        this.propagateMinConstraints = z5;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BoxMeasurePolicy)) {
            return false;
        }
        BoxMeasurePolicy boxMeasurePolicy = (BoxMeasurePolicy) other;
        return Intrinsics.areEqual(this.alignment, boxMeasurePolicy.alignment) && this.propagateMinConstraints == boxMeasurePolicy.propagateMinConstraints;
    }

    public int hashCode() {
        return (this.alignment.hashCode() * 31) + Boolean.hashCode(this.propagateMinConstraints);
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    /* renamed from: measure-3p2s80s */
    public MeasureResult mo19measure3p2s80s(final MeasureScope measureScope, final List<? extends Measurable> list, long j5) {
        boolean matchesParentSize;
        boolean matchesParentSize2;
        boolean matchesParentSize3;
        int m2580getMinWidthimpl;
        int m2579getMinHeightimpl;
        Placeable mo1946measureBRTryo0;
        if (list.isEmpty()) {
            return MeasureScope.layout$default(measureScope, Constraints.m2580getMinWidthimpl(j5), Constraints.m2579getMinHeightimpl(j5), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.layout.BoxMeasurePolicy$measure$1
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Placeable.PlacementScope placementScope) {
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                    invoke2(placementScope);
                    return Unit.INSTANCE;
                }
            }, 4, null);
        }
        long m2570copyZbe2FdA$default = this.propagateMinConstraints ? j5 : Constraints.m2570copyZbe2FdA$default(j5, 0, 0, 0, 0, 10, null);
        if (list.size() == 1) {
            final Measurable measurable = list.get(0);
            matchesParentSize3 = BoxKt.getMatchesParentSize(measurable);
            if (matchesParentSize3) {
                m2580getMinWidthimpl = Constraints.m2580getMinWidthimpl(j5);
                m2579getMinHeightimpl = Constraints.m2579getMinHeightimpl(j5);
                mo1946measureBRTryo0 = measurable.mo1946measureBRTryo0(Constraints.INSTANCE.m2587fixedJhjzzOo(Constraints.m2580getMinWidthimpl(j5), Constraints.m2579getMinHeightimpl(j5)));
            } else {
                mo1946measureBRTryo0 = measurable.mo1946measureBRTryo0(m2570copyZbe2FdA$default);
                m2580getMinWidthimpl = Math.max(Constraints.m2580getMinWidthimpl(j5), mo1946measureBRTryo0.getWidth());
                m2579getMinHeightimpl = Math.max(Constraints.m2579getMinHeightimpl(j5), mo1946measureBRTryo0.getHeight());
            }
            final int i5 = m2580getMinWidthimpl;
            final int i6 = m2579getMinHeightimpl;
            final Placeable placeable = mo1946measureBRTryo0;
            return MeasureScope.layout$default(measureScope, i5, i6, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.layout.BoxMeasurePolicy$measure$2
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
                    Alignment alignment;
                    Placeable placeable2 = Placeable.this;
                    Measurable measurable2 = measurable;
                    LayoutDirection layoutDirection = measureScope.getLayoutDirection();
                    int i7 = i5;
                    int i8 = i6;
                    alignment = this.alignment;
                    BoxKt.placeInBox(placementScope, placeable2, measurable2, layoutDirection, i7, i8, alignment);
                }
            }, 4, null);
        }
        final Placeable[] placeableArr = new Placeable[list.size()];
        final Ref$IntRef ref$IntRef = new Ref$IntRef();
        ref$IntRef.element = Constraints.m2580getMinWidthimpl(j5);
        final Ref$IntRef ref$IntRef2 = new Ref$IntRef();
        ref$IntRef2.element = Constraints.m2579getMinHeightimpl(j5);
        int size = list.size();
        boolean z5 = false;
        for (int i7 = 0; i7 < size; i7++) {
            Measurable measurable2 = list.get(i7);
            matchesParentSize2 = BoxKt.getMatchesParentSize(measurable2);
            if (matchesParentSize2) {
                z5 = true;
            } else {
                Placeable mo1946measureBRTryo02 = measurable2.mo1946measureBRTryo0(m2570copyZbe2FdA$default);
                placeableArr[i7] = mo1946measureBRTryo02;
                ref$IntRef.element = Math.max(ref$IntRef.element, mo1946measureBRTryo02.getWidth());
                ref$IntRef2.element = Math.max(ref$IntRef2.element, mo1946measureBRTryo02.getHeight());
            }
        }
        if (z5) {
            int i8 = ref$IntRef.element;
            int i9 = i8 != Integer.MAX_VALUE ? i8 : 0;
            int i10 = ref$IntRef2.element;
            long Constraints = ConstraintsKt.Constraints(i9, i8, i10 != Integer.MAX_VALUE ? i10 : 0, i10);
            int size2 = list.size();
            for (int i11 = 0; i11 < size2; i11++) {
                Measurable measurable3 = list.get(i11);
                matchesParentSize = BoxKt.getMatchesParentSize(measurable3);
                if (matchesParentSize) {
                    placeableArr[i11] = measurable3.mo1946measureBRTryo0(Constraints);
                }
            }
        }
        return MeasureScope.layout$default(measureScope, ref$IntRef.element, ref$IntRef2.element, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.layout.BoxMeasurePolicy$measure$5
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
                Alignment alignment;
                Placeable[] placeableArr2 = placeableArr;
                List<Measurable> list2 = list;
                MeasureScope measureScope2 = measureScope;
                Ref$IntRef ref$IntRef3 = ref$IntRef;
                Ref$IntRef ref$IntRef4 = ref$IntRef2;
                BoxMeasurePolicy boxMeasurePolicy = this;
                int length = placeableArr2.length;
                int i12 = 0;
                int i13 = 0;
                while (i12 < length) {
                    Placeable placeable2 = placeableArr2[i12];
                    Intrinsics.checkNotNull(placeable2, "null cannot be cast to non-null type androidx.compose.ui.layout.Placeable");
                    Measurable measurable4 = list2.get(i13);
                    LayoutDirection layoutDirection = measureScope2.getLayoutDirection();
                    int i14 = ref$IntRef3.element;
                    int i15 = ref$IntRef4.element;
                    alignment = boxMeasurePolicy.alignment;
                    BoxKt.placeInBox(placementScope, placeable2, measurable4, layoutDirection, i14, i15, alignment);
                    i12++;
                    i13++;
                }
            }
        }, 4, null);
    }

    public String toString() {
        return "BoxMeasurePolicy(alignment=" + this.alignment + ", propagateMinConstraints=" + this.propagateMinConstraints + ')';
    }
}
