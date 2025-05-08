package androidx.compose.animation;

import androidx.compose.animation.AnimatedContentTransitionScopeImpl;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.ranges.IntRange;
import org.conscrypt.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u0011\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003¢\u0006\u0002\u0010\u0004J\"\u0010\u0007\u001a\u00020\b*\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\r\u001a\u00020\bH\u0016J\"\u0010\u000e\u001a\u00020\b*\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\u000f\u001a\u00020\bH\u0016J,\u0010\u0010\u001a\u00020\u0011*\u00020\u00122\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00130\u000b2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017J\"\u0010\u0018\u001a\u00020\b*\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\r\u001a\u00020\bH\u0016J\"\u0010\u0019\u001a\u00020\b*\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\u000f\u001a\u00020\bH\u0016R\u0015\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u001a"}, d2 = {"Landroidx/compose/animation/AnimatedContentMeasurePolicy;", "Landroidx/compose/ui/layout/MeasurePolicy;", "rootScope", "Landroidx/compose/animation/AnimatedContentTransitionScopeImpl;", "(Landroidx/compose/animation/AnimatedContentTransitionScopeImpl;)V", "getRootScope", "()Landroidx/compose/animation/AnimatedContentTransitionScopeImpl;", "maxIntrinsicHeight", BuildConfig.FLAVOR, "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "measurables", BuildConfig.FLAVOR, "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "width", "maxIntrinsicWidth", "height", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntrinsicHeight", "minIntrinsicWidth", "animation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class AnimatedContentMeasurePolicy implements MeasurePolicy {
    private final AnimatedContentTransitionScopeImpl<?> rootScope;

    public AnimatedContentMeasurePolicy(AnimatedContentTransitionScopeImpl<?> animatedContentTransitionScopeImpl) {
        this.rootScope = animatedContentTransitionScopeImpl;
    }

    public final AnimatedContentTransitionScopeImpl<?> getRootScope() {
        return this.rootScope;
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i5) {
        Integer valueOf;
        if (list.isEmpty()) {
            valueOf = null;
        } else {
            valueOf = Integer.valueOf(list.get(0).maxIntrinsicHeight(i5));
            int lastIndex = CollectionsKt.getLastIndex(list);
            int i6 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    Integer valueOf2 = Integer.valueOf(list.get(i6).maxIntrinsicHeight(i5));
                    if (valueOf2.compareTo(valueOf) > 0) {
                        valueOf = valueOf2;
                    }
                    if (i6 == lastIndex) {
                        break;
                    }
                    i6++;
                }
            }
        }
        if (valueOf != null) {
            return valueOf.intValue();
        }
        return 0;
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i5) {
        Integer valueOf;
        if (list.isEmpty()) {
            valueOf = null;
        } else {
            valueOf = Integer.valueOf(list.get(0).maxIntrinsicWidth(i5));
            int lastIndex = CollectionsKt.getLastIndex(list);
            int i6 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    Integer valueOf2 = Integer.valueOf(list.get(i6).maxIntrinsicWidth(i5));
                    if (valueOf2.compareTo(valueOf) > 0) {
                        valueOf = valueOf2;
                    }
                    if (i6 == lastIndex) {
                        break;
                    }
                    i6++;
                }
            }
        }
        if (valueOf != null) {
            return valueOf.intValue();
        }
        return 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00bc  */
    /* JADX WARN: Type inference failed for: r1v11, types: [kotlin.collections.IntIterator, java.util.Iterator] */
    /* JADX WARN: Type inference failed for: r2v2, types: [kotlin.collections.IntIterator, java.util.Iterator] */
    @Override // androidx.compose.ui.layout.MeasurePolicy
    /* renamed from: measure-3p2s80s, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public MeasureResult mo19measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j5) {
        Placeable placeable;
        Placeable placeable2;
        final int i5;
        int width;
        int size = list.size();
        final Placeable[] placeableArr = new Placeable[size];
        long m2665getZeroYbymL2g = IntSize.INSTANCE.m2665getZeroYbymL2g();
        int size2 = list.size();
        int i6 = 0;
        int i7 = 0;
        while (true) {
            placeable = null;
            if (i7 >= size2) {
                break;
            }
            Measurable measurable = list.get(i7);
            Object parentData = measurable.getParentData();
            AnimatedContentTransitionScopeImpl.ChildData childData = parentData instanceof AnimatedContentTransitionScopeImpl.ChildData ? (AnimatedContentTransitionScopeImpl.ChildData) parentData : null;
            if (childData != null && childData.isTarget()) {
                Placeable mo1946measureBRTryo0 = measurable.mo1946measureBRTryo0(j5);
                long IntSize = IntSizeKt.IntSize(mo1946measureBRTryo0.getWidth(), mo1946measureBRTryo0.getHeight());
                Unit unit = Unit.INSTANCE;
                placeableArr[i7] = mo1946measureBRTryo0;
                m2665getZeroYbymL2g = IntSize;
            }
            i7++;
        }
        int size3 = list.size();
        for (int i8 = 0; i8 < size3; i8++) {
            Measurable measurable2 = list.get(i8);
            if (placeableArr[i8] == null) {
                placeableArr[i8] = measurable2.mo1946measureBRTryo0(j5);
            }
        }
        if (measureScope.isLookingAhead()) {
            width = IntSize.m2661getWidthimpl(m2665getZeroYbymL2g);
        } else {
            if (size == 0) {
                placeable2 = null;
            } else {
                placeable2 = placeableArr[0];
                int lastIndex = ArraysKt.getLastIndex(placeableArr);
                if (lastIndex != 0) {
                    int width2 = placeable2 != null ? placeable2.getWidth() : 0;
                    ?? it = new IntRange(1, lastIndex).iterator();
                    while (it.hasNext()) {
                        Placeable placeable3 = placeableArr[it.nextInt()];
                        int width3 = placeable3 != null ? placeable3.getWidth() : 0;
                        if (width2 < width3) {
                            placeable2 = placeable3;
                            width2 = width3;
                        }
                    }
                }
            }
            if (placeable2 == null) {
                i5 = 0;
                if (measureScope.isLookingAhead()) {
                    if (size != 0) {
                        placeable = placeableArr[0];
                        int lastIndex2 = ArraysKt.getLastIndex(placeableArr);
                        if (lastIndex2 != 0) {
                            int height = placeable != null ? placeable.getHeight() : 0;
                            ?? it2 = new IntRange(1, lastIndex2).iterator();
                            while (it2.hasNext()) {
                                Placeable placeable4 = placeableArr[it2.nextInt()];
                                int height2 = placeable4 != null ? placeable4.getHeight() : 0;
                                if (height < height2) {
                                    placeable = placeable4;
                                    height = height2;
                                }
                            }
                        }
                    }
                    if (placeable != null) {
                        i6 = placeable.getHeight();
                    }
                } else {
                    i6 = IntSize.m2660getHeightimpl(m2665getZeroYbymL2g);
                }
                final int i9 = i6;
                if (!measureScope.isLookingAhead()) {
                    this.rootScope.m20setMeasuredSizeozmzZPI$animation_release(IntSizeKt.IntSize(i5, i9));
                }
                return MeasureScope.layout$default(measureScope, i5, i9, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.animation.AnimatedContentMeasurePolicy$measure$3
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
                        Placeable[] placeableArr2 = placeableArr;
                        AnimatedContentMeasurePolicy animatedContentMeasurePolicy = this;
                        int i10 = i5;
                        int i11 = i9;
                        for (Placeable placeable5 : placeableArr2) {
                            if (placeable5 != null) {
                                long mo1251alignKFBX0sM = animatedContentMeasurePolicy.getRootScope().getContentAlignment().mo1251alignKFBX0sM(IntSizeKt.IntSize(placeable5.getWidth(), placeable5.getHeight()), IntSizeKt.IntSize(i10, i11), LayoutDirection.Ltr);
                                Placeable.PlacementScope.place$default(placementScope, placeable5, IntOffset.m2640getXimpl(mo1251alignKFBX0sM), IntOffset.m2641getYimpl(mo1251alignKFBX0sM), 0.0f, 4, null);
                            }
                        }
                    }
                }, 4, null);
            }
            width = placeable2.getWidth();
        }
        i5 = width;
        if (measureScope.isLookingAhead()) {
        }
        final int i92 = i6;
        if (!measureScope.isLookingAhead()) {
        }
        return MeasureScope.layout$default(measureScope, i5, i92, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.animation.AnimatedContentMeasurePolicy$measure$3
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
                Placeable[] placeableArr2 = placeableArr;
                AnimatedContentMeasurePolicy animatedContentMeasurePolicy = this;
                int i10 = i5;
                int i11 = i92;
                for (Placeable placeable5 : placeableArr2) {
                    if (placeable5 != null) {
                        long mo1251alignKFBX0sM = animatedContentMeasurePolicy.getRootScope().getContentAlignment().mo1251alignKFBX0sM(IntSizeKt.IntSize(placeable5.getWidth(), placeable5.getHeight()), IntSizeKt.IntSize(i10, i11), LayoutDirection.Ltr);
                        Placeable.PlacementScope.place$default(placementScope, placeable5, IntOffset.m2640getXimpl(mo1251alignKFBX0sM), IntOffset.m2641getYimpl(mo1251alignKFBX0sM), 0.0f, 4, null);
                    }
                }
            }
        }, 4, null);
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i5) {
        Integer valueOf;
        if (list.isEmpty()) {
            valueOf = null;
        } else {
            valueOf = Integer.valueOf(list.get(0).minIntrinsicHeight(i5));
            int lastIndex = CollectionsKt.getLastIndex(list);
            int i6 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    Integer valueOf2 = Integer.valueOf(list.get(i6).minIntrinsicHeight(i5));
                    if (valueOf2.compareTo(valueOf) > 0) {
                        valueOf = valueOf2;
                    }
                    if (i6 == lastIndex) {
                        break;
                    }
                    i6++;
                }
            }
        }
        if (valueOf != null) {
            return valueOf.intValue();
        }
        return 0;
    }

    @Override // androidx.compose.ui.layout.MeasurePolicy
    public int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List<? extends IntrinsicMeasurable> list, int i5) {
        Integer valueOf;
        if (list.isEmpty()) {
            valueOf = null;
        } else {
            valueOf = Integer.valueOf(list.get(0).minIntrinsicWidth(i5));
            int lastIndex = CollectionsKt.getLastIndex(list);
            int i6 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    Integer valueOf2 = Integer.valueOf(list.get(i6).minIntrinsicWidth(i5));
                    if (valueOf2.compareTo(valueOf) > 0) {
                        valueOf = valueOf2;
                    }
                    if (i6 == lastIndex) {
                        break;
                    }
                    i6++;
                }
            }
        }
        if (valueOf != null) {
            return valueOf.intValue();
        }
        return 0;
    }
}
