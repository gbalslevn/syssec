package androidx.compose.foundation.pager;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.snapping.SnapPosition;
import androidx.compose.foundation.gestures.snapping.SnapPositionKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope;
import androidx.compose.foundation.lazy.layout.ObservableScopeInvalidator;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntProgression;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScope;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0003\u001aì\u0001\u0010*\u001a\u00020'*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00012\u0006\u0010\u0018\u001a\u00020\u00012\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00010\u00192\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020\u001f2*\u0010&\u001a&\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0001\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020$0\"\u0012\u0004\u0012\u00020%0!H\u0000ø\u0001\u0000¢\u0006\u0004\b(\u0010)\u001aO\u0010/\u001a\b\u0012\u0004\u0012\u00020-0\u00192\u0006\u0010+\u001a\u00020\u00012\u0006\u0010,\u001a\u00020\u00012\u0006\u0010\u0018\u001a\u00020\u00012\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00010\u00192\u0012\u0010.\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020-0\"H\u0002¢\u0006\u0004\b/\u00100\u001aG\u00102\u001a\b\u0012\u0004\u0012\u00020-0\u00192\u0006\u00101\u001a\u00020\u00012\u0006\u0010\u0018\u001a\u00020\u00012\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00010\u00192\u0012\u0010.\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020-0\"H\u0002¢\u0006\u0004\b2\u00103\u001aO\u00107\u001a\u0004\u0018\u00010-2\u0006\u00104\u001a\u00020\u00012\f\u00105\u001a\b\u0012\u0004\u0012\u00020-0\u00192\u0006\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u00106\u001a\u00020\u00012\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0002\u001a\u00020\u0001H\u0002¢\u0006\u0004\b7\u00108\u001aj\u0010.\u001a\u00020-*\u00020\u00002\u0006\u00109\u001a\u00020\u00012\u0006\u0010:\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010<\u001a\u00020;2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0001H\u0002ø\u0001\u0000¢\u0006\u0004\b=\u0010>\u001a\u0093\u0001\u0010J\u001a\b\u0012\u0004\u0012\u00020-0I*\u00020\u00002\f\u0010?\u001a\b\u0012\u0004\u0012\u00020-0\u00192\f\u0010@\u001a\b\u0012\u0004\u0012\u00020-0\u00192\f\u0010A\u001a\b\u0012\u0004\u0012\u00020-0\u00192\u0006\u0010B\u001a\u00020\u00012\u0006\u0010C\u001a\u00020\u00012\u0006\u0010D\u001a\u00020\u00012\u0006\u0010E\u001a\u00020\u00012\u0006\u0010F\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010H\u001a\u00020G2\u0006\u0010\b\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\u0002¢\u0006\u0004\bJ\u0010K\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006L"}, d2 = {"Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;", BuildConfig.FLAVOR, "pageCount", "Landroidx/compose/foundation/pager/PagerLazyLayoutItemProvider;", "pagerItemProvider", "mainAxisAvailableSize", "beforeContentPadding", "afterContentPadding", "spaceBetweenPages", "currentPage", "currentPageOffset", "Landroidx/compose/ui/unit/Constraints;", "constraints", "Landroidx/compose/foundation/gestures/Orientation;", "orientation", "Landroidx/compose/ui/Alignment$Vertical;", "verticalAlignment", "Landroidx/compose/ui/Alignment$Horizontal;", "horizontalAlignment", BuildConfig.FLAVOR, "reverseLayout", "Landroidx/compose/ui/unit/IntOffset;", "visualPageOffset", "pageAvailableSize", "beyondViewportPageCount", BuildConfig.FLAVOR, "pinnedPages", "Landroidx/compose/foundation/gestures/snapping/SnapPosition;", "snapPosition", "Landroidx/compose/foundation/lazy/layout/ObservableScopeInvalidator;", "placementScopeInvalidator", "Lkotlinx/coroutines/CoroutineScope;", "coroutineScope", "Lkotlin/Function3;", "Lkotlin/Function1;", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", BuildConfig.FLAVOR, "Landroidx/compose/ui/layout/MeasureResult;", "layout", "Landroidx/compose/foundation/pager/PagerMeasureResult;", "measurePager-bmk8ZPk", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;ILandroidx/compose/foundation/pager/PagerLazyLayoutItemProvider;IIIIIIJLandroidx/compose/foundation/gestures/Orientation;Landroidx/compose/ui/Alignment$Vertical;Landroidx/compose/ui/Alignment$Horizontal;ZJIILjava/util/List;Landroidx/compose/foundation/gestures/snapping/SnapPosition;Landroidx/compose/runtime/MutableState;Lkotlinx/coroutines/CoroutineScope;Lkotlin/jvm/functions/Function3;)Landroidx/compose/foundation/pager/PagerMeasureResult;", "measurePager", "currentLastPage", "pagesCount", "Landroidx/compose/foundation/pager/MeasuredPage;", "getAndMeasure", "createPagesAfterList", "(IIILjava/util/List;Lkotlin/jvm/functions/Function1;)Ljava/util/List;", "currentFirstPage", "createPagesBeforeList", "(IILjava/util/List;Lkotlin/jvm/functions/Function1;)Ljava/util/List;", "viewportSize", "visiblePagesInfo", "itemSize", "calculateNewCurrentPage", "(ILjava/util/List;IIILandroidx/compose/foundation/gestures/snapping/SnapPosition;I)Landroidx/compose/foundation/pager/MeasuredPage;", "index", "childConstraints", "Landroidx/compose/ui/unit/LayoutDirection;", "layoutDirection", "getAndMeasure-SGf7dI0", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;IJLandroidx/compose/foundation/pager/PagerLazyLayoutItemProvider;JLandroidx/compose/foundation/gestures/Orientation;Landroidx/compose/ui/Alignment$Horizontal;Landroidx/compose/ui/Alignment$Vertical;Landroidx/compose/ui/unit/LayoutDirection;ZI)Landroidx/compose/foundation/pager/MeasuredPage;", "pages", "extraPagesBefore", "extraPagesAfter", "layoutWidth", "layoutHeight", "finalMainAxisOffset", "maxOffset", "pagesScrollOffset", "Landroidx/compose/ui/unit/Density;", "density", BuildConfig.FLAVOR, "calculatePagesOffsets", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;Ljava/util/List;Ljava/util/List;Ljava/util/List;IIIIILandroidx/compose/foundation/gestures/Orientation;ZLandroidx/compose/ui/unit/Density;II)Ljava/util/List;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class PagerMeasureKt {
    private static final MeasuredPage calculateNewCurrentPage(int i5, List<MeasuredPage> list, int i6, int i7, int i8, SnapPosition snapPosition, int i9) {
        MeasuredPage measuredPage;
        if (list.isEmpty()) {
            measuredPage = null;
        } else {
            MeasuredPage measuredPage2 = list.get(0);
            MeasuredPage measuredPage3 = measuredPage2;
            float f5 = -Math.abs(SnapPositionKt.calculateDistanceToDesiredSnapPosition(i5, i6, i7, i8, measuredPage3.getOffset(), measuredPage3.getIndex(), snapPosition, i9));
            int lastIndex = CollectionsKt.getLastIndex(list);
            int i10 = 1;
            if (1 <= lastIndex) {
                while (true) {
                    MeasuredPage measuredPage4 = list.get(i10);
                    MeasuredPage measuredPage5 = measuredPage4;
                    float f6 = -Math.abs(SnapPositionKt.calculateDistanceToDesiredSnapPosition(i5, i6, i7, i8, measuredPage5.getOffset(), measuredPage5.getIndex(), snapPosition, i9));
                    if (Float.compare(f5, f6) < 0) {
                        measuredPage2 = measuredPage4;
                        f5 = f6;
                    }
                    if (i10 == lastIndex) {
                        break;
                    }
                    i10++;
                }
            }
            measuredPage = measuredPage2;
        }
        return measuredPage;
    }

    private static final List<MeasuredPage> calculatePagesOffsets(LazyLayoutMeasureScope lazyLayoutMeasureScope, List<MeasuredPage> list, List<MeasuredPage> list2, List<MeasuredPage> list3, int i5, int i6, int i7, int i8, int i9, Orientation orientation, boolean z5, Density density, int i10, int i11) {
        int i12;
        int i13;
        int i14 = i9;
        int i15 = i11 + i10;
        if (orientation == Orientation.Vertical) {
            i12 = i8;
            i13 = i6;
        } else {
            i12 = i8;
            i13 = i5;
        }
        boolean z6 = i7 < Math.min(i13, i12);
        if (z6 && i14 != 0) {
            throw new IllegalStateException(("non-zero pagesScrollOffset=" + i14).toString());
        }
        ArrayList arrayList = new ArrayList(list.size() + list2.size() + list3.size());
        if (!z6) {
            int size = list2.size();
            int i16 = i14;
            for (int i17 = 0; i17 < size; i17++) {
                MeasuredPage measuredPage = list2.get(i17);
                i16 -= i15;
                measuredPage.position(i16, i5, i6);
                arrayList.add(measuredPage);
            }
            int size2 = list.size();
            for (int i18 = 0; i18 < size2; i18++) {
                MeasuredPage measuredPage2 = list.get(i18);
                measuredPage2.position(i14, i5, i6);
                arrayList.add(measuredPage2);
                i14 += i15;
            }
            int size3 = list3.size();
            for (int i19 = 0; i19 < size3; i19++) {
                MeasuredPage measuredPage3 = list3.get(i19);
                measuredPage3.position(i14, i5, i6);
                arrayList.add(measuredPage3);
                i14 += i15;
            }
        } else {
            if (!list2.isEmpty() || !list3.isEmpty()) {
                throw new IllegalArgumentException("No extra pages");
            }
            int size4 = list.size();
            int[] iArr = new int[size4];
            for (int i20 = 0; i20 < size4; i20++) {
                iArr[i20] = i11;
            }
            int[] iArr2 = new int[size4];
            for (int i21 = 0; i21 < size4; i21++) {
                iArr2[i21] = 0;
            }
            Arrangement.HorizontalOrVertical m266spacedBy0680j_4 = Arrangement.Absolute.INSTANCE.m266spacedBy0680j_4(lazyLayoutMeasureScope.mo209toDpu2uoSUM(i10));
            if (orientation == Orientation.Vertical) {
                m266spacedBy0680j_4.arrange(density, i13, iArr, iArr2);
            } else {
                m266spacedBy0680j_4.arrange(density, i13, iArr, LayoutDirection.Ltr, iArr2);
            }
            IntProgression indices = ArraysKt.getIndices(iArr2);
            if (z5) {
                indices = RangesKt.reversed(indices);
            }
            int first = indices.getFirst();
            int last = indices.getLast();
            int step = indices.getStep();
            if ((step > 0 && first <= last) || (step < 0 && last <= first)) {
                while (true) {
                    int i22 = iArr2[first];
                    MeasuredPage measuredPage4 = list.get(calculatePagesOffsets$reverseAware(first, z5, size4));
                    if (z5) {
                        i22 = (i13 - i22) - measuredPage4.getSize();
                    }
                    measuredPage4.position(i22, i5, i6);
                    arrayList.add(measuredPage4);
                    if (first == last) {
                        break;
                    }
                    first += step;
                }
            }
        }
        return arrayList;
    }

    private static final int calculatePagesOffsets$reverseAware(int i5, boolean z5, int i6) {
        return !z5 ? i5 : (i6 - i5) - 1;
    }

    private static final List<MeasuredPage> createPagesAfterList(int i5, int i6, int i7, List<Integer> list, Function1<? super Integer, MeasuredPage> function1) {
        int min = Math.min(i7 + i5, i6 - 1);
        int i8 = i5 + 1;
        ArrayList arrayList = null;
        if (i8 <= min) {
            while (true) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(function1.invoke(Integer.valueOf(i8)));
                if (i8 == min) {
                    break;
                }
                i8++;
            }
        }
        int size = list.size();
        for (int i9 = 0; i9 < size; i9++) {
            int intValue = list.get(i9).intValue();
            if (min + 1 <= intValue && intValue < i6) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(function1.invoke(Integer.valueOf(intValue)));
            }
        }
        return arrayList == null ? CollectionsKt.emptyList() : arrayList;
    }

    private static final List<MeasuredPage> createPagesBeforeList(int i5, int i6, List<Integer> list, Function1<? super Integer, MeasuredPage> function1) {
        int max = Math.max(0, i5 - i6);
        int i7 = i5 - 1;
        ArrayList arrayList = null;
        if (max <= i7) {
            while (true) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(function1.invoke(Integer.valueOf(i7)));
                if (i7 == max) {
                    break;
                }
                i7--;
            }
        }
        int size = list.size();
        for (int i8 = 0; i8 < size; i8++) {
            int intValue = list.get(i8).intValue();
            if (intValue < max) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(function1.invoke(Integer.valueOf(intValue)));
            }
        }
        return arrayList == null ? CollectionsKt.emptyList() : arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: getAndMeasure-SGf7dI0, reason: not valid java name */
    public static final MeasuredPage m441getAndMeasureSGf7dI0(LazyLayoutMeasureScope lazyLayoutMeasureScope, int i5, long j5, PagerLazyLayoutItemProvider pagerLazyLayoutItemProvider, long j6, Orientation orientation, Alignment.Horizontal horizontal, Alignment.Vertical vertical, LayoutDirection layoutDirection, boolean z5, int i6) {
        return new MeasuredPage(i5, i6, lazyLayoutMeasureScope.mo422measure0kLqBqw(i5, j5), j6, pagerLazyLayoutItemProvider.getKey(i5), orientation, horizontal, vertical, layoutDirection, z5, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: measurePager-bmk8ZPk, reason: not valid java name */
    public static final PagerMeasureResult m442measurePagerbmk8ZPk(final LazyLayoutMeasureScope lazyLayoutMeasureScope, int i5, final PagerLazyLayoutItemProvider pagerLazyLayoutItemProvider, int i6, int i7, int i8, int i9, int i10, int i11, long j5, final Orientation orientation, final Alignment.Vertical vertical, final Alignment.Horizontal horizontal, final boolean z5, final long j6, final int i12, int i13, List<Integer> list, SnapPosition snapPosition, final MutableState<Unit> mutableState, CoroutineScope coroutineScope, Function3<? super Integer, ? super Integer, ? super Function1<? super Placeable.PlacementScope, Unit>, ? extends MeasureResult> function3) {
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        MeasuredPage measuredPage;
        int i19;
        long j7;
        int i20;
        List<MeasuredPage> list2;
        List arrayList;
        List arrayList2;
        if (i7 < 0) {
            throw new IllegalArgumentException("negative beforeContentPadding");
        }
        if (i8 < 0) {
            throw new IllegalArgumentException("negative afterContentPadding");
        }
        int i21 = 0;
        int coerceAtLeast = RangesKt.coerceAtLeast(i12 + i9, 0);
        if (i5 <= 0) {
            return new PagerMeasureResult(CollectionsKt.emptyList(), i12, i9, i8, orientation, -i7, i6 + i8, false, i13, null, null, 0.0f, 0, false, snapPosition, function3.invoke(Integer.valueOf(Constraints.m2580getMinWidthimpl(j5)), Integer.valueOf(Constraints.m2579getMinHeightimpl(j5)), new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.pager.PagerMeasureKt$measurePager$4
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Placeable.PlacementScope placementScope) {
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                    invoke2(placementScope);
                    return Unit.INSTANCE;
                }
            }), false, null, null, coroutineScope, 393216, null);
        }
        Orientation orientation2 = Orientation.Vertical;
        final long Constraints$default = ConstraintsKt.Constraints$default(0, orientation == orientation2 ? Constraints.m2578getMaxWidthimpl(j5) : i12, 0, orientation != orientation2 ? Constraints.m2577getMaxHeightimpl(j5) : i12, 5, null);
        int i22 = i10;
        int i23 = i11;
        while (i22 > 0 && i23 > 0) {
            i22--;
            i23 -= coerceAtLeast;
        }
        int i24 = i23 * (-1);
        if (i22 >= i5) {
            i22 = i5 - 1;
            i24 = 0;
        }
        ArrayDeque arrayDeque = new ArrayDeque();
        int i25 = -i7;
        int i26 = (i9 < 0 ? i9 : 0) + i25;
        int i27 = i24 + i26;
        int i28 = 0;
        while (i27 < 0 && i22 > 0) {
            int i29 = i22 - 1;
            ArrayDeque arrayDeque2 = arrayDeque;
            int i30 = i21;
            int i31 = coerceAtLeast;
            MeasuredPage m441getAndMeasureSGf7dI0 = m441getAndMeasureSGf7dI0(lazyLayoutMeasureScope, i29, Constraints$default, pagerLazyLayoutItemProvider, j6, orientation, horizontal, vertical, lazyLayoutMeasureScope.getLayoutDirection(), z5, i12);
            arrayDeque2.add(i30, m441getAndMeasureSGf7dI0);
            i28 = Math.max(i28, m441getAndMeasureSGf7dI0.getCrossAxisSize());
            i27 += i31;
            i22 = i29;
            i26 = i26;
            arrayDeque = arrayDeque2;
            i21 = i30;
            coerceAtLeast = i31;
            i25 = i25;
        }
        int i32 = i27;
        int i33 = i25;
        int i34 = i26;
        ArrayDeque arrayDeque3 = arrayDeque;
        int i35 = i21;
        int i36 = coerceAtLeast;
        int i37 = (i32 < i34 ? i34 : i32) - i34;
        int i38 = i6 + i8;
        int coerceAtLeast2 = RangesKt.coerceAtLeast(i38, i35);
        int i39 = -i37;
        int i40 = i35;
        int i41 = i40;
        int i42 = i22;
        while (i40 < arrayDeque3.size()) {
            if (i39 >= coerceAtLeast2) {
                arrayDeque3.remove(i40);
                i41 = 1;
            } else {
                i42++;
                i39 += i36;
                i40++;
            }
        }
        int i43 = i22;
        int i44 = i37;
        int i45 = i41;
        int i46 = i42;
        int i47 = i39;
        while (i46 < i5 && (i47 < coerceAtLeast2 || i47 <= 0 || arrayDeque3.isEmpty())) {
            int i48 = i38;
            int i49 = i46;
            int i50 = i43;
            int i51 = coerceAtLeast2;
            int i52 = i47;
            int i53 = i36;
            MeasuredPage m441getAndMeasureSGf7dI02 = m441getAndMeasureSGf7dI0(lazyLayoutMeasureScope, i46, Constraints$default, pagerLazyLayoutItemProvider, j6, orientation, horizontal, vertical, lazyLayoutMeasureScope.getLayoutDirection(), z5, i12);
            int i54 = i5 - 1;
            i47 = (i49 == i54 ? i12 : i53) + i52;
            if (i47 > i34 || i49 == i54) {
                i28 = Math.max(i28, m441getAndMeasureSGf7dI02.getCrossAxisSize());
                arrayDeque3.add(m441getAndMeasureSGf7dI02);
                i43 = i50;
            } else {
                i44 -= i53;
                i43 = i49 + 1;
                i45 = 1;
            }
            i46 = i49 + 1;
            i38 = i48;
            i36 = i53;
            coerceAtLeast2 = i51;
        }
        int i55 = i43;
        int i56 = i38;
        int i57 = i46;
        int i58 = i47;
        int i59 = i36;
        if (i58 < i6) {
            int i60 = i6 - i58;
            int i61 = i44 - i60;
            int i62 = i60 + i58;
            int i63 = i7;
            i18 = i55;
            int i64 = i59;
            int i65 = i61;
            while (i65 < i63 && i18 > 0) {
                i18--;
                int i66 = i64;
                MeasuredPage m441getAndMeasureSGf7dI03 = m441getAndMeasureSGf7dI0(lazyLayoutMeasureScope, i18, Constraints$default, pagerLazyLayoutItemProvider, j6, orientation, horizontal, vertical, lazyLayoutMeasureScope.getLayoutDirection(), z5, i12);
                arrayDeque3.add(0, m441getAndMeasureSGf7dI03);
                i28 = Math.max(i28, m441getAndMeasureSGf7dI03.getCrossAxisSize());
                i65 += i66;
                i63 = i7;
                i64 = i66;
            }
            i14 = i64;
            i15 = 0;
            if (i65 < 0) {
                i16 = i62 + i65;
                i17 = 0;
            } else {
                i17 = i65;
                i16 = i62;
            }
        } else {
            i14 = i59;
            i15 = 0;
            i16 = i58;
            i17 = i44;
            i18 = i55;
        }
        if (i17 < 0) {
            throw new IllegalArgumentException("invalid currentFirstPageScrollOffset");
        }
        int i67 = -i17;
        MeasuredPage measuredPage2 = (MeasuredPage) arrayDeque3.first();
        if (i7 > 0 || i9 < 0) {
            int size = arrayDeque3.size();
            int i68 = i17;
            int i69 = i15;
            while (i69 < size && i68 != 0 && i14 <= i68 && i69 != CollectionsKt.getLastIndex(arrayDeque3)) {
                i68 -= i14;
                i69++;
                measuredPage2 = (MeasuredPage) arrayDeque3.get(i69);
            }
            measuredPage = measuredPage2;
            i19 = i68;
        } else {
            i19 = i17;
            measuredPage = measuredPage2;
        }
        int i70 = i28;
        MeasuredPage measuredPage3 = measuredPage;
        int i71 = i15;
        List<MeasuredPage> createPagesBeforeList = createPagesBeforeList(i18, i13, list, new Function1<Integer, MeasuredPage>() { // from class: androidx.compose.foundation.pager.PagerMeasureKt$measurePager$extraPagesBefore$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ MeasuredPage invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final MeasuredPage invoke(int i72) {
                MeasuredPage m441getAndMeasureSGf7dI04;
                LazyLayoutMeasureScope lazyLayoutMeasureScope2 = LazyLayoutMeasureScope.this;
                m441getAndMeasureSGf7dI04 = PagerMeasureKt.m441getAndMeasureSGf7dI0(lazyLayoutMeasureScope2, i72, Constraints$default, pagerLazyLayoutItemProvider, j6, orientation, horizontal, vertical, lazyLayoutMeasureScope2.getLayoutDirection(), z5, i12);
                return m441getAndMeasureSGf7dI04;
            }
        });
        int size2 = createPagesBeforeList.size();
        int i72 = i70;
        for (int i73 = i71; i73 < size2; i73++) {
            i72 = Math.max(i72, createPagesBeforeList.get(i73).getCrossAxisSize());
        }
        int i74 = i14;
        List<MeasuredPage> createPagesAfterList = createPagesAfterList(((MeasuredPage) arrayDeque3.last()).getIndex(), i5, i13, list, new Function1<Integer, MeasuredPage>() { // from class: androidx.compose.foundation.pager.PagerMeasureKt$measurePager$extraPagesAfter$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ MeasuredPage invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final MeasuredPage invoke(int i75) {
                MeasuredPage m441getAndMeasureSGf7dI04;
                LazyLayoutMeasureScope lazyLayoutMeasureScope2 = LazyLayoutMeasureScope.this;
                m441getAndMeasureSGf7dI04 = PagerMeasureKt.m441getAndMeasureSGf7dI0(lazyLayoutMeasureScope2, i75, Constraints$default, pagerLazyLayoutItemProvider, j6, orientation, horizontal, vertical, lazyLayoutMeasureScope2.getLayoutDirection(), z5, i12);
                return m441getAndMeasureSGf7dI04;
            }
        });
        int size3 = createPagesAfterList.size();
        int i75 = i72;
        for (int i76 = i71; i76 < size3; i76++) {
            i75 = Math.max(i75, createPagesAfterList.get(i76).getCrossAxisSize());
        }
        int i77 = (Intrinsics.areEqual(measuredPage3, arrayDeque3.first()) && createPagesBeforeList.isEmpty() && createPagesAfterList.isEmpty()) ? 1 : i71;
        Orientation orientation3 = Orientation.Vertical;
        if (orientation == orientation3) {
            j7 = j5;
            i20 = i75;
        } else {
            j7 = j5;
            i20 = i16;
        }
        int m2593constrainWidthK40F9xA = ConstraintsKt.m2593constrainWidthK40F9xA(j7, i20);
        if (orientation == orientation3) {
            i75 = i16;
        }
        int m2592constrainHeightK40F9xA = ConstraintsKt.m2592constrainHeightK40F9xA(j7, i75);
        final List<MeasuredPage> calculatePagesOffsets = calculatePagesOffsets(lazyLayoutMeasureScope, arrayDeque3, createPagesBeforeList, createPagesAfterList, m2593constrainWidthK40F9xA, m2592constrainHeightK40F9xA, i16, i6, i67, orientation, z5, lazyLayoutMeasureScope, i9, i12);
        if (i77 != 0) {
            list2 = calculatePagesOffsets;
        } else {
            ArrayList arrayList3 = new ArrayList(calculatePagesOffsets.size());
            int size4 = calculatePagesOffsets.size();
            for (int i78 = i71; i78 < size4; i78++) {
                MeasuredPage measuredPage4 = calculatePagesOffsets.get(i78);
                MeasuredPage measuredPage5 = measuredPage4;
                if (measuredPage5.getIndex() >= ((MeasuredPage) arrayDeque3.first()).getIndex() && measuredPage5.getIndex() <= ((MeasuredPage) arrayDeque3.last()).getIndex()) {
                    arrayList3.add(measuredPage4);
                }
            }
            list2 = arrayList3;
        }
        if (createPagesBeforeList.isEmpty()) {
            arrayList = CollectionsKt.emptyList();
        } else {
            arrayList = new ArrayList(calculatePagesOffsets.size());
            int size5 = calculatePagesOffsets.size();
            for (int i79 = i71; i79 < size5; i79++) {
                MeasuredPage measuredPage6 = calculatePagesOffsets.get(i79);
                if (measuredPage6.getIndex() < ((MeasuredPage) arrayDeque3.first()).getIndex()) {
                    arrayList.add(measuredPage6);
                }
            }
        }
        List list3 = arrayList;
        if (createPagesAfterList.isEmpty()) {
            arrayList2 = CollectionsKt.emptyList();
        } else {
            arrayList2 = new ArrayList(calculatePagesOffsets.size());
            int size6 = calculatePagesOffsets.size();
            for (int i80 = i71; i80 < size6; i80++) {
                MeasuredPage measuredPage7 = calculatePagesOffsets.get(i80);
                if (measuredPage7.getIndex() > ((MeasuredPage) arrayDeque3.last()).getIndex()) {
                    arrayList2.add(measuredPage7);
                }
            }
        }
        List list4 = arrayList2;
        int i81 = i16;
        MeasuredPage calculateNewCurrentPage = calculateNewCurrentPage(orientation == Orientation.Vertical ? m2592constrainHeightK40F9xA : m2593constrainWidthK40F9xA, list2, i7, i8, i74, snapPosition, i5);
        return new PagerMeasureResult(list2, i12, i9, i8, orientation, i33, i56, z5, i13, measuredPage3, calculateNewCurrentPage, i74 == 0 ? 0.0f : RangesKt.coerceIn((snapPosition.position(i6, i12, i7, i8, calculateNewCurrentPage != null ? calculateNewCurrentPage.getIndex() : i71, i5) - (calculateNewCurrentPage != null ? calculateNewCurrentPage.getOffset() : i71)) / i74, -0.5f, 0.5f), i19, (i57 < i5 || i81 > i6) ? 1 : i71, snapPosition, function3.invoke(Integer.valueOf(m2593constrainWidthK40F9xA), Integer.valueOf(m2592constrainHeightK40F9xA), new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.pager.PagerMeasureKt$measurePager$14
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
                List<MeasuredPage> list5 = calculatePagesOffsets;
                int size7 = list5.size();
                for (int i82 = 0; i82 < size7; i82++) {
                    list5.get(i82).place(placementScope);
                }
                ObservableScopeInvalidator.m425attachToScopeimpl(mutableState);
            }
        }), i45, list3, list4, coroutineScope);
    }
}
