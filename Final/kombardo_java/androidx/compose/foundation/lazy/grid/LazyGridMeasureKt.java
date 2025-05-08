package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator;
import androidx.compose.foundation.lazy.layout.ObservableScopeInvalidator;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.graphics.GraphicsContext;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.math.MathKt;
import kotlin.ranges.IntProgression;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScope;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u009a\u0001\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0004\u001a¤\u0002\u00100\u001a\u00020-2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u00172\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00192\u0006\u0010\u001c\u001a\u00020\u00002\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00000\u001d2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010\"\u001a\u00020!2\u0006\u0010$\u001a\u00020#2$\u0010'\u001a \u0012\u0004\u0012\u00020\u0000\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u000e0&0\u001d0%2*\u0010,\u001a&\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u0000\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020*0%\u0012\u0004\u0012\u00020+0(H\u0000ø\u0001\u0000¢\u0006\u0004\b.\u0010/\u001a\u0093\u0001\u0010;\u001a\b\u0012\u0004\u0012\u00020\u001a0:2\f\u00102\u001a\b\u0012\u0004\u0012\u0002010\u001d2\f\u00103\u001a\b\u0012\u0004\u0012\u00020\u001a0\u001d2\f\u00104\u001a\b\u0012\u0004\u0012\u00020\u001a0\u001d2\u0006\u00105\u001a\u00020\u00002\u0006\u00106\u001a\u00020\u00002\u0006\u00107\u001a\u00020\u00002\u0006\u00108\u001a\u00020\u00002\u0006\u00109\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u0017H\u0002¢\u0006\u0004\b;\u0010<\u001a-\u0010@\u001a\u00020*\"\u0004\b\u0000\u0010=*\b\u0012\u0004\u0012\u00028\u00000:2\f\u0010?\u001a\b\u0012\u0004\u0012\u00028\u00000>H\u0002¢\u0006\u0004\b@\u0010A\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006B"}, d2 = {BuildConfig.FLAVOR, "itemsCount", "Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredLineProvider;", "measuredLineProvider", "Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredItemProvider;", "measuredItemProvider", "mainAxisAvailableSize", "beforeContentPadding", "afterContentPadding", "spaceBetweenLines", "firstVisibleLineIndex", "firstVisibleLineScrollOffset", BuildConfig.FLAVOR, "scrollToBeConsumed", "Landroidx/compose/ui/unit/Constraints;", "constraints", BuildConfig.FLAVOR, "isVertical", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "verticalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "horizontalArrangement", "reverseLayout", "Landroidx/compose/ui/unit/Density;", "density", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator;", "Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredItem;", "itemAnimator", "slotsPerLine", BuildConfig.FLAVOR, "pinnedItems", "Lkotlinx/coroutines/CoroutineScope;", "coroutineScope", "Landroidx/compose/foundation/lazy/layout/ObservableScopeInvalidator;", "placementScopeInvalidator", "Landroidx/compose/ui/graphics/GraphicsContext;", "graphicsContext", "Lkotlin/Function1;", "Lkotlin/Pair;", "prefetchInfoRetriever", "Lkotlin/Function3;", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", BuildConfig.FLAVOR, "Landroidx/compose/ui/layout/MeasureResult;", "layout", "Landroidx/compose/foundation/lazy/grid/LazyGridMeasureResult;", "measureLazyGrid-OZKpZRA", "(ILandroidx/compose/foundation/lazy/grid/LazyGridMeasuredLineProvider;Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredItemProvider;IIIIIIFJZLandroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/layout/Arrangement$Horizontal;ZLandroidx/compose/ui/unit/Density;Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator;ILjava/util/List;Lkotlinx/coroutines/CoroutineScope;Landroidx/compose/runtime/MutableState;Landroidx/compose/ui/graphics/GraphicsContext;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function3;)Landroidx/compose/foundation/lazy/grid/LazyGridMeasureResult;", "measureLazyGrid", "Landroidx/compose/foundation/lazy/grid/LazyGridMeasuredLine;", "lines", "itemsBefore", "itemsAfter", "layoutWidth", "layoutHeight", "finalMainAxisOffset", "maxOffset", "firstLineScrollOffset", BuildConfig.FLAVOR, "calculateItemsOffsets", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;IIIIIZLandroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/layout/Arrangement$Horizontal;ZLandroidx/compose/ui/unit/Density;)Ljava/util/List;", "T", BuildConfig.FLAVOR, "arr", "addAllFromArray", "(Ljava/util/List;[Ljava/lang/Object;)V", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class LazyGridMeasureKt {
    private static final <T> void addAllFromArray(List<T> list, T[] tArr) {
        for (T t5 : tArr) {
            list.add(t5);
        }
    }

    private static final List<LazyGridMeasuredItem> calculateItemsOffsets(List<LazyGridMeasuredLine> list, List<LazyGridMeasuredItem> list2, List<LazyGridMeasuredItem> list3, int i5, int i6, int i7, int i8, int i9, boolean z5, Arrangement.Vertical vertical, Arrangement.Horizontal horizontal, boolean z6, Density density) {
        int i10 = z5 ? i6 : i5;
        boolean z7 = i7 < Math.min(i10, i8);
        if (z7 && i9 != 0) {
            throw new IllegalStateException("non-zero firstLineScrollOffset");
        }
        int size = list.size();
        int i11 = 0;
        for (int i12 = 0; i12 < size; i12++) {
            i11 += list.get(i12).getItems().length;
        }
        ArrayList arrayList = new ArrayList(i11);
        if (!z7) {
            int size2 = list2.size() - 1;
            if (size2 >= 0) {
                int i13 = i9;
                while (true) {
                    int i14 = size2 - 1;
                    LazyGridMeasuredItem lazyGridMeasuredItem = list2.get(size2);
                    i13 -= lazyGridMeasuredItem.getMainAxisSizeWithSpacings();
                    lazyGridMeasuredItem.position(i13, 0, i5, i6);
                    arrayList.add(lazyGridMeasuredItem);
                    if (i14 < 0) {
                        break;
                    }
                    size2 = i14;
                }
            }
            int size3 = list.size();
            int i15 = i9;
            for (int i16 = 0; i16 < size3; i16++) {
                LazyGridMeasuredLine lazyGridMeasuredLine = list.get(i16);
                addAllFromArray(arrayList, lazyGridMeasuredLine.position(i15, i5, i6));
                i15 += lazyGridMeasuredLine.getMainAxisSizeWithSpacings();
            }
            int size4 = list3.size();
            for (int i17 = 0; i17 < size4; i17++) {
                LazyGridMeasuredItem lazyGridMeasuredItem2 = list3.get(i17);
                lazyGridMeasuredItem2.position(i15, 0, i5, i6);
                arrayList.add(lazyGridMeasuredItem2);
                i15 += lazyGridMeasuredItem2.getMainAxisSizeWithSpacings();
            }
        } else {
            if (!list2.isEmpty() || !list3.isEmpty()) {
                throw new IllegalArgumentException("no items");
            }
            int size5 = list.size();
            int[] iArr = new int[size5];
            for (int i18 = 0; i18 < size5; i18++) {
                iArr[i18] = list.get(calculateItemsOffsets$reverseAware(i18, z6, size5)).getMainAxisSize();
            }
            int[] iArr2 = new int[size5];
            for (int i19 = 0; i19 < size5; i19++) {
                iArr2[i19] = 0;
            }
            if (z5) {
                if (vertical == null) {
                    throw new IllegalArgumentException("null verticalArrangement");
                }
                vertical.arrange(density, i10, iArr, iArr2);
            } else {
                if (horizontal == null) {
                    throw new IllegalArgumentException("null horizontalArrangement");
                }
                horizontal.arrange(density, i10, iArr, LayoutDirection.Ltr, iArr2);
            }
            IntProgression indices = ArraysKt.getIndices(iArr2);
            if (z6) {
                indices = RangesKt.reversed(indices);
            }
            int first = indices.getFirst();
            int last = indices.getLast();
            int step = indices.getStep();
            if ((step > 0 && first <= last) || (step < 0 && last <= first)) {
                while (true) {
                    int i20 = iArr2[first];
                    LazyGridMeasuredLine lazyGridMeasuredLine2 = list.get(calculateItemsOffsets$reverseAware(first, z6, size5));
                    if (z6) {
                        i20 = (i10 - i20) - lazyGridMeasuredLine2.getMainAxisSize();
                    }
                    addAllFromArray(arrayList, lazyGridMeasuredLine2.position(i20, i5, i6));
                    if (first == last) {
                        break;
                    }
                    first += step;
                }
            }
        }
        return arrayList;
    }

    private static final int calculateItemsOffsets$reverseAware(int i5, boolean z5, int i6) {
        return !z5 ? i5 : (i6 - i5) - 1;
    }

    /* renamed from: measureLazyGrid-OZKpZRA, reason: not valid java name */
    public static final LazyGridMeasureResult m396measureLazyGridOZKpZRA(int i5, LazyGridMeasuredLineProvider lazyGridMeasuredLineProvider, LazyGridMeasuredItemProvider lazyGridMeasuredItemProvider, int i6, int i7, int i8, int i9, int i10, int i11, float f5, long j5, boolean z5, Arrangement.Vertical vertical, Arrangement.Horizontal horizontal, boolean z6, Density density, LazyLayoutItemAnimator<LazyGridMeasuredItem> lazyLayoutItemAnimator, int i12, List<Integer> list, CoroutineScope coroutineScope, final MutableState<Unit> mutableState, GraphicsContext graphicsContext, Function1<? super Integer, ? extends List<Pair<Integer, Constraints>>> function1, Function3<? super Integer, ? super Integer, ? super Function1<? super Placeable.PlacementScope, Unit>, ? extends MeasureResult> function3) {
        boolean z7;
        int i13;
        int i14;
        LazyGridMeasuredLine lazyGridMeasuredLine;
        int i15;
        LazyGridMeasuredLine lazyGridMeasuredLine2;
        int i16;
        int i17;
        int i18;
        List<LazyGridMeasuredItem> list2;
        int i19;
        int i20;
        float f6;
        LazyGridMeasuredItem[] items;
        LazyGridMeasuredItem lazyGridMeasuredItem;
        int i21;
        int i22;
        if (i7 < 0) {
            throw new IllegalArgumentException("negative beforeContentPadding");
        }
        if (i8 < 0) {
            throw new IllegalArgumentException("negative afterContentPadding");
        }
        if (i5 <= 0) {
            int m2580getMinWidthimpl = Constraints.m2580getMinWidthimpl(j5);
            int m2579getMinHeightimpl = Constraints.m2579getMinHeightimpl(j5);
            lazyLayoutItemAnimator.onMeasured(0, m2580getMinWidthimpl, m2579getMinHeightimpl, new ArrayList(), lazyGridMeasuredItemProvider.getKeyIndexMap(), lazyGridMeasuredItemProvider, z5, false, i12, false, 0, 0, coroutineScope, graphicsContext);
            long m417getMinSizeToFitDisappearingItemsYbymL2g = lazyLayoutItemAnimator.m417getMinSizeToFitDisappearingItemsYbymL2g();
            if (!IntSize.m2659equalsimpl0(m417getMinSizeToFitDisappearingItemsYbymL2g, IntSize.INSTANCE.m2665getZeroYbymL2g())) {
                m2580getMinWidthimpl = ConstraintsKt.m2593constrainWidthK40F9xA(j5, IntSize.m2661getWidthimpl(m417getMinSizeToFitDisappearingItemsYbymL2g));
                m2579getMinHeightimpl = ConstraintsKt.m2592constrainHeightK40F9xA(j5, IntSize.m2660getHeightimpl(m417getMinSizeToFitDisappearingItemsYbymL2g));
            }
            return new LazyGridMeasureResult(null, 0, false, 0.0f, function3.invoke(Integer.valueOf(m2580getMinWidthimpl), Integer.valueOf(m2579getMinHeightimpl), new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.lazy.grid.LazyGridMeasureKt$measureLazyGrid$3
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Placeable.PlacementScope placementScope) {
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                    invoke2(placementScope);
                    return Unit.INSTANCE;
                }
            }), false, coroutineScope, density, i12, function1, CollectionsKt.emptyList(), -i7, i6 + i8, 0, z6, z5 ? Orientation.Vertical : Orientation.Horizontal, i8, i9);
        }
        int round = Math.round(f5);
        int i23 = i11 - round;
        if (i10 == 0 && i23 < 0) {
            round += i23;
            i23 = 0;
        }
        ArrayDeque arrayDeque = new ArrayDeque();
        int i24 = -i7;
        int i25 = (i9 < 0 ? i9 : 0) + i24;
        int i26 = i23 + i25;
        int i27 = i10;
        while (i26 < 0 && i27 > 0) {
            i27--;
            LazyGridMeasuredLine andMeasure = lazyGridMeasuredLineProvider.getAndMeasure(i27);
            arrayDeque.add(0, andMeasure);
            i26 += andMeasure.getMainAxisSizeWithSpacings();
        }
        if (i26 < i25) {
            round += i26;
            i26 = i25;
        }
        int i28 = i26 - i25;
        int i29 = i6 + i8;
        int i30 = i27;
        int coerceAtLeast = RangesKt.coerceAtLeast(i29, 0);
        int i31 = i30;
        int i32 = i28;
        int i33 = -i28;
        int i34 = 0;
        boolean z8 = false;
        while (true) {
            z7 = true;
            if (i34 >= arrayDeque.size()) {
                break;
            }
            if (i33 >= coerceAtLeast) {
                arrayDeque.remove(i34);
                z8 = true;
            } else {
                i31++;
                i33 += ((LazyGridMeasuredLine) arrayDeque.get(i34)).getMainAxisSizeWithSpacings();
                i34++;
            }
        }
        int i35 = i33;
        boolean z9 = z8;
        int i36 = i31;
        int i37 = i30;
        while (i36 < i5 && (i35 < coerceAtLeast || i35 <= 0 || arrayDeque.isEmpty())) {
            int i38 = coerceAtLeast;
            LazyGridMeasuredLine andMeasure2 = lazyGridMeasuredLineProvider.getAndMeasure(i36);
            if (andMeasure2.isEmpty()) {
                break;
            }
            i35 += andMeasure2.getMainAxisSizeWithSpacings();
            if (i35 <= i25) {
                i21 = i25;
                i22 = i37;
                if (((LazyGridMeasuredItem) ArraysKt.last(andMeasure2.getItems())).getIndex() != i5 - 1) {
                    i32 -= andMeasure2.getMainAxisSizeWithSpacings();
                    i37 = i36 + 1;
                    z9 = true;
                    i36++;
                    coerceAtLeast = i38;
                    i25 = i21;
                }
            } else {
                i21 = i25;
                i22 = i37;
            }
            arrayDeque.add(andMeasure2);
            i37 = i22;
            i36++;
            coerceAtLeast = i38;
            i25 = i21;
        }
        int i39 = i37;
        if (i35 < i6) {
            int i40 = i6 - i35;
            int i41 = i35 + i40;
            int i42 = i39;
            i14 = i32 - i40;
            while (i14 < i7 && i42 > 0) {
                int i43 = i42 - 1;
                LazyGridMeasuredLine andMeasure3 = lazyGridMeasuredLineProvider.getAndMeasure(i43);
                arrayDeque.add(0, andMeasure3);
                i14 += andMeasure3.getMainAxisSizeWithSpacings();
                i42 = i43;
            }
            round += i40;
            if (i14 < 0) {
                round += i14;
                i13 = i41 + i14;
                i14 = 0;
            } else {
                i13 = i41;
            }
        } else {
            i13 = i35;
            i14 = i32;
        }
        float f7 = (MathKt.getSign(Math.round(f5)) != MathKt.getSign(round) || Math.abs(Math.round(f5)) < Math.abs(round)) ? f5 : round;
        if (i14 < 0) {
            throw new IllegalArgumentException("negative initial offset");
        }
        int i44 = -i14;
        LazyGridMeasuredLine lazyGridMeasuredLine3 = (LazyGridMeasuredLine) arrayDeque.first();
        LazyGridMeasuredItem lazyGridMeasuredItem2 = (LazyGridMeasuredItem) ArraysKt.firstOrNull(lazyGridMeasuredLine3.getItems());
        int index = lazyGridMeasuredItem2 != null ? lazyGridMeasuredItem2.getIndex() : 0;
        LazyGridMeasuredLine lazyGridMeasuredLine4 = (LazyGridMeasuredLine) arrayDeque.lastOrNull();
        if (lazyGridMeasuredLine4 == null || (items = lazyGridMeasuredLine4.getItems()) == null || (lazyGridMeasuredItem = (LazyGridMeasuredItem) ArraysKt.lastOrNull(items)) == null) {
            lazyGridMeasuredLine = lazyGridMeasuredLine3;
            i15 = 0;
        } else {
            lazyGridMeasuredLine = lazyGridMeasuredLine3;
            i15 = lazyGridMeasuredItem.getIndex();
        }
        int size = list.size();
        List list3 = null;
        int i45 = i14;
        List list4 = null;
        int i46 = 0;
        while (i46 < size) {
            int i47 = size;
            int intValue = list.get(i46).intValue();
            if (intValue < 0 || intValue >= index) {
                i20 = index;
                f6 = f7;
            } else {
                i20 = index;
                int spanOf = lazyGridMeasuredLineProvider.spanOf(intValue);
                f6 = f7;
                LazyGridMeasuredItem mo375getAndMeasurehBUhpc = lazyGridMeasuredItemProvider.mo375getAndMeasurehBUhpc(intValue, 0, spanOf, lazyGridMeasuredLineProvider.m399childConstraintsJhjzzOo$foundation_release(0, spanOf));
                if (list4 == null) {
                    list4 = new ArrayList();
                }
                List list5 = list4;
                list5.add(mo375getAndMeasurehBUhpc);
                list4 = list5;
            }
            i46++;
            size = i47;
            index = i20;
            f7 = f6;
        }
        int i48 = index;
        float f8 = f7;
        if (list4 == null) {
            list4 = CollectionsKt.emptyList();
        }
        List list6 = list4;
        int size2 = list.size();
        int i49 = 0;
        while (i49 < size2) {
            int intValue2 = list.get(i49).intValue();
            if (i15 + 1 > intValue2 || intValue2 >= i5) {
                i19 = i15;
            } else {
                int spanOf2 = lazyGridMeasuredLineProvider.spanOf(intValue2);
                i19 = i15;
                LazyGridMeasuredItem mo375getAndMeasurehBUhpc2 = lazyGridMeasuredItemProvider.mo375getAndMeasurehBUhpc(intValue2, 0, spanOf2, lazyGridMeasuredLineProvider.m399childConstraintsJhjzzOo$foundation_release(0, spanOf2));
                if (list3 == null) {
                    list3 = new ArrayList();
                }
                List list7 = list3;
                list7.add(mo375getAndMeasurehBUhpc2);
                list3 = list7;
            }
            i49++;
            i15 = i19;
        }
        int i50 = i15;
        if (list3 == null) {
            list3 = CollectionsKt.emptyList();
        }
        List list8 = list3;
        if (i7 > 0 || i9 < 0) {
            int size3 = arrayDeque.size();
            LazyGridMeasuredLine lazyGridMeasuredLine5 = lazyGridMeasuredLine;
            int i51 = 0;
            int i52 = i45;
            while (i51 < size3) {
                int mainAxisSizeWithSpacings = ((LazyGridMeasuredLine) arrayDeque.get(i51)).getMainAxisSizeWithSpacings();
                if (i52 == 0 || mainAxisSizeWithSpacings > i52 || i51 == CollectionsKt.getLastIndex(arrayDeque)) {
                    break;
                }
                i52 -= mainAxisSizeWithSpacings;
                i51++;
                lazyGridMeasuredLine5 = (LazyGridMeasuredLine) arrayDeque.get(i51);
            }
            lazyGridMeasuredLine2 = lazyGridMeasuredLine5;
            i16 = i52;
        } else {
            lazyGridMeasuredLine2 = lazyGridMeasuredLine;
            i16 = i45;
        }
        int m2578getMaxWidthimpl = z5 ? Constraints.m2578getMaxWidthimpl(j5) : ConstraintsKt.m2593constrainWidthK40F9xA(j5, i13);
        int m2592constrainHeightK40F9xA = z5 ? ConstraintsKt.m2592constrainHeightK40F9xA(j5, i13) : Constraints.m2577getMaxHeightimpl(j5);
        int i53 = i48;
        final List<LazyGridMeasuredItem> calculateItemsOffsets = calculateItemsOffsets(arrayDeque, list6, list8, m2578getMaxWidthimpl, m2592constrainHeightK40F9xA, i13, i6, i44, z5, vertical, horizontal, z6, density);
        int i54 = i13;
        lazyLayoutItemAnimator.onMeasured((int) f8, m2578getMaxWidthimpl, m2592constrainHeightK40F9xA, calculateItemsOffsets, lazyGridMeasuredItemProvider.getKeyIndexMap(), lazyGridMeasuredItemProvider, z5, false, i12, false, i16, i54, coroutineScope, graphicsContext);
        long m417getMinSizeToFitDisappearingItemsYbymL2g2 = lazyLayoutItemAnimator.m417getMinSizeToFitDisappearingItemsYbymL2g();
        if (IntSize.m2659equalsimpl0(m417getMinSizeToFitDisappearingItemsYbymL2g2, IntSize.INSTANCE.m2665getZeroYbymL2g())) {
            i17 = m2578getMaxWidthimpl;
            i18 = m2592constrainHeightK40F9xA;
        } else {
            int i55 = z5 ? m2592constrainHeightK40F9xA : m2578getMaxWidthimpl;
            i17 = ConstraintsKt.m2593constrainWidthK40F9xA(j5, Math.max(m2578getMaxWidthimpl, IntSize.m2661getWidthimpl(m417getMinSizeToFitDisappearingItemsYbymL2g2)));
            i18 = ConstraintsKt.m2592constrainHeightK40F9xA(j5, Math.max(m2592constrainHeightK40F9xA, IntSize.m2660getHeightimpl(m417getMinSizeToFitDisappearingItemsYbymL2g2)));
            int i56 = z5 ? i18 : i17;
            if (i56 != i55) {
                int size4 = calculateItemsOffsets.size();
                for (int i57 = 0; i57 < size4; i57++) {
                    calculateItemsOffsets.get(i57).updateMainAxisLayoutSize(i56);
                }
            }
        }
        if (i50 == i5 - 1 && i54 <= i6) {
            z7 = false;
        }
        MeasureResult invoke = function3.invoke(Integer.valueOf(i17), Integer.valueOf(i18), new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.lazy.grid.LazyGridMeasureKt$measureLazyGrid$6
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
                List<LazyGridMeasuredItem> list9 = calculateItemsOffsets;
                int size5 = list9.size();
                for (int i58 = 0; i58 < size5; i58++) {
                    list9.get(i58).place(placementScope);
                }
                ObservableScopeInvalidator.m425attachToScopeimpl(mutableState);
            }
        });
        if (list6.isEmpty() && list8.isEmpty()) {
            list2 = calculateItemsOffsets;
        } else {
            ArrayList arrayList = new ArrayList(calculateItemsOffsets.size());
            int size5 = calculateItemsOffsets.size();
            int i58 = 0;
            while (i58 < size5) {
                LazyGridMeasuredItem lazyGridMeasuredItem3 = calculateItemsOffsets.get(i58);
                int index2 = lazyGridMeasuredItem3.getIndex();
                int i59 = i53;
                if (i59 <= index2 && index2 <= i50) {
                    arrayList.add(lazyGridMeasuredItem3);
                }
                i58++;
                i53 = i59;
            }
            list2 = arrayList;
        }
        return new LazyGridMeasureResult(lazyGridMeasuredLine2, i16, z7, f8, invoke, z9, coroutineScope, density, i12, function1, list2, i24, i29, i5, z6, z5 ? Orientation.Vertical : Orientation.Horizontal, i8, i9);
    }
}
