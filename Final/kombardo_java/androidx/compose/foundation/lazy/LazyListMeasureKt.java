package androidx.compose.foundation.lazy;

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
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.IntProgression;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScope;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0013\u001a\u009e\u0002\u00101\u001a\u00020.2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00000\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u00172\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00192\u0006\u0010\u001c\u001a\u00020\u00002\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00000\u00102\u0006\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020\u000e2\b\u0010!\u001a\u0004\u0018\u00010 2\u0006\u0010#\u001a\u00020\"2\u0006\u0010%\u001a\u00020$2\u0006\u0010'\u001a\u00020&2*\u0010-\u001a&\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u0000\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020+0)\u0012\u0004\u0012\u00020,0(H\u0000ø\u0001\u0000¢\u0006\u0004\b/\u00100\u001ac\u00106\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00102\f\u00103\u001a\b\u0012\u0004\u0012\u00020\u001a022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u00002\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00000\u00102\u0006\u00104\u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020\u000e2\b\u00105\u001a\u0004\u0018\u00010 H\u0002¢\u0006\u0004\b6\u00107\u001a;\u00109\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00102\u0006\u00108\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u00002\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00000\u0010H\u0002¢\u0006\u0004\b9\u0010:\u001a\u0093\u0001\u0010C\u001a\b\u0012\u0004\u0012\u00020\u001a022\f\u0010;\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00102\f\u0010<\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00102\f\u0010=\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00102\u0006\u0010>\u001a\u00020\u00002\u0006\u0010?\u001a\u00020\u00002\u0006\u0010@\u001a\u00020\u00002\u0006\u0010A\u001a\u00020\u00002\u0006\u0010B\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u0017H\u0002¢\u0006\u0004\bC\u0010D\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006E"}, d2 = {BuildConfig.FLAVOR, "itemsCount", "Landroidx/compose/foundation/lazy/LazyListMeasuredItemProvider;", "measuredItemProvider", "mainAxisAvailableSize", "beforeContentPadding", "afterContentPadding", "spaceBetweenItems", "firstVisibleItemIndex", "firstVisibleItemScrollOffset", BuildConfig.FLAVOR, "scrollToBeConsumed", "Landroidx/compose/ui/unit/Constraints;", "constraints", BuildConfig.FLAVOR, "isVertical", BuildConfig.FLAVOR, "headerIndexes", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "verticalArrangement", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "horizontalArrangement", "reverseLayout", "Landroidx/compose/ui/unit/Density;", "density", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator;", "Landroidx/compose/foundation/lazy/LazyListMeasuredItem;", "itemAnimator", "beyondBoundsItemCount", "pinnedItems", "hasLookaheadPassOccurred", "isLookingAhead", "Landroidx/compose/foundation/lazy/LazyListLayoutInfo;", "postLookaheadLayoutInfo", "Lkotlinx/coroutines/CoroutineScope;", "coroutineScope", "Landroidx/compose/foundation/lazy/layout/ObservableScopeInvalidator;", "placementScopeInvalidator", "Landroidx/compose/ui/graphics/GraphicsContext;", "graphicsContext", "Lkotlin/Function3;", "Lkotlin/Function1;", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", BuildConfig.FLAVOR, "Landroidx/compose/ui/layout/MeasureResult;", "layout", "Landroidx/compose/foundation/lazy/LazyListMeasureResult;", "measureLazyList-x0Ok8Vo", "(ILandroidx/compose/foundation/lazy/LazyListMeasuredItemProvider;IIIIIIFJZLjava/util/List;Landroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/layout/Arrangement$Horizontal;ZLandroidx/compose/ui/unit/Density;Landroidx/compose/foundation/lazy/layout/LazyLayoutItemAnimator;ILjava/util/List;ZZLandroidx/compose/foundation/lazy/LazyListLayoutInfo;Lkotlinx/coroutines/CoroutineScope;Landroidx/compose/runtime/MutableState;Landroidx/compose/ui/graphics/GraphicsContext;Lkotlin/jvm/functions/Function3;)Landroidx/compose/foundation/lazy/LazyListMeasureResult;", "measureLazyList", BuildConfig.FLAVOR, "visibleItems", "consumedScroll", "lastPostLookaheadLayoutInfo", "createItemsAfterList", "(Ljava/util/List;Landroidx/compose/foundation/lazy/LazyListMeasuredItemProvider;IILjava/util/List;FZLandroidx/compose/foundation/lazy/LazyListLayoutInfo;)Ljava/util/List;", "currentFirstItemIndex", "createItemsBeforeList", "(ILandroidx/compose/foundation/lazy/LazyListMeasuredItemProvider;ILjava/util/List;)Ljava/util/List;", "items", "extraItemsBefore", "extraItemsAfter", "layoutWidth", "layoutHeight", "finalMainAxisOffset", "maxOffset", "itemsScrollOffset", "calculateItemsOffsets", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;IIIIIZLandroidx/compose/foundation/layout/Arrangement$Vertical;Landroidx/compose/foundation/layout/Arrangement$Horizontal;ZLandroidx/compose/ui/unit/Density;)Ljava/util/List;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class LazyListMeasureKt {
    private static final List<LazyListMeasuredItem> calculateItemsOffsets(List<LazyListMeasuredItem> list, List<LazyListMeasuredItem> list2, List<LazyListMeasuredItem> list3, int i5, int i6, int i7, int i8, int i9, boolean z5, Arrangement.Vertical vertical, Arrangement.Horizontal horizontal, boolean z6, Density density) {
        int i10 = z5 ? i6 : i5;
        boolean z7 = i7 < Math.min(i10, i8);
        if (z7 && i9 != 0) {
            throw new IllegalStateException("non-zero itemsScrollOffset");
        }
        ArrayList arrayList = new ArrayList(list.size() + list2.size() + list3.size());
        if (!z7) {
            int size = list2.size();
            int i11 = i9;
            for (int i12 = 0; i12 < size; i12++) {
                LazyListMeasuredItem lazyListMeasuredItem = list2.get(i12);
                i11 -= lazyListMeasuredItem.getMainAxisSizeWithSpacings();
                lazyListMeasuredItem.position(i11, i5, i6);
                arrayList.add(lazyListMeasuredItem);
            }
            int size2 = list.size();
            int i13 = i9;
            for (int i14 = 0; i14 < size2; i14++) {
                LazyListMeasuredItem lazyListMeasuredItem2 = list.get(i14);
                lazyListMeasuredItem2.position(i13, i5, i6);
                arrayList.add(lazyListMeasuredItem2);
                i13 += lazyListMeasuredItem2.getMainAxisSizeWithSpacings();
            }
            int size3 = list3.size();
            for (int i15 = 0; i15 < size3; i15++) {
                LazyListMeasuredItem lazyListMeasuredItem3 = list3.get(i15);
                lazyListMeasuredItem3.position(i13, i5, i6);
                arrayList.add(lazyListMeasuredItem3);
                i13 += lazyListMeasuredItem3.getMainAxisSizeWithSpacings();
            }
        } else {
            if (!list2.isEmpty() || !list3.isEmpty()) {
                throw new IllegalArgumentException("no extra items");
            }
            int size4 = list.size();
            int[] iArr = new int[size4];
            for (int i16 = 0; i16 < size4; i16++) {
                iArr[i16] = list.get(calculateItemsOffsets$reverseAware(i16, z6, size4)).getSize();
            }
            int[] iArr2 = new int[size4];
            for (int i17 = 0; i17 < size4; i17++) {
                iArr2[i17] = 0;
            }
            if (z5) {
                if (vertical == null) {
                    throw new IllegalArgumentException("null verticalArrangement when isVertical == true");
                }
                vertical.arrange(density, i10, iArr, iArr2);
            } else {
                if (horizontal == null) {
                    throw new IllegalArgumentException("null horizontalArrangement when isVertical == false");
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
                    int i18 = iArr2[first];
                    LazyListMeasuredItem lazyListMeasuredItem4 = list.get(calculateItemsOffsets$reverseAware(first, z6, size4));
                    if (z6) {
                        i18 = (i10 - i18) - lazyListMeasuredItem4.getSize();
                    }
                    lazyListMeasuredItem4.position(i18, i5, i6);
                    arrayList.add(lazyListMeasuredItem4);
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

    /* JADX WARN: Code restructure failed: missing block: B:24:0x007b, code lost:
    
        r5 = r5.get(r6);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final List<LazyListMeasuredItem> createItemsAfterList(List<LazyListMeasuredItem> list, LazyListMeasuredItemProvider lazyListMeasuredItemProvider, int i5, int i6, List<Integer> list2, float f5, boolean z5, LazyListLayoutInfo lazyListLayoutInfo) {
        ArrayList arrayList;
        LazyListItemInfo lazyListItemInfo;
        LazyListMeasuredItem lazyListMeasuredItem;
        LazyListMeasuredItem lazyListMeasuredItem2;
        int mainAxisSizeWithSpacings;
        LazyListMeasuredItem lazyListMeasuredItem3;
        int index;
        int min;
        LazyListMeasuredItem lazyListMeasuredItem4;
        LazyListMeasuredItem lazyListMeasuredItem5;
        int i7 = i5 - 1;
        int min2 = Math.min(((LazyListMeasuredItem) CollectionsKt.last((List) list)).getIndex() + i6, i7);
        int index2 = ((LazyListMeasuredItem) CollectionsKt.last((List) list)).getIndex() + 1;
        if (index2 <= min2) {
            ArrayList arrayList2 = null;
            while (true) {
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList();
                }
                arrayList = arrayList2;
                arrayList.add(LazyListMeasuredItemProvider.m374getAndMeasure0kLqBqw$default(lazyListMeasuredItemProvider, index2, 0L, 2, null));
                if (index2 == min2) {
                    break;
                }
                index2++;
                arrayList2 = arrayList;
            }
        } else {
            arrayList = null;
        }
        if (z5 && lazyListLayoutInfo != null && !lazyListLayoutInfo.getVisibleItemsInfo().isEmpty()) {
            List<LazyListItemInfo> visibleItemsInfo = lazyListLayoutInfo.getVisibleItemsInfo();
            int size = visibleItemsInfo.size();
            while (true) {
                size--;
                if (-1 >= size) {
                    lazyListItemInfo = null;
                    break;
                }
                if (visibleItemsInfo.get(size).getIndex() <= min2 || (size != 0 && visibleItemsInfo.get(size - 1).getIndex() > min2)) {
                }
            }
            LazyListItemInfo lazyListItemInfo2 = (LazyListItemInfo) CollectionsKt.last((List) lazyListLayoutInfo.getVisibleItemsInfo());
            if (lazyListItemInfo != null && (index = lazyListItemInfo.getIndex()) <= (min = Math.min(lazyListItemInfo2.getIndex(), i7))) {
                while (true) {
                    if (arrayList != null) {
                        int size2 = arrayList.size();
                        int i8 = 0;
                        while (true) {
                            if (i8 >= size2) {
                                lazyListMeasuredItem5 = null;
                                break;
                            }
                            lazyListMeasuredItem5 = arrayList.get(i8);
                            if (lazyListMeasuredItem5.getIndex() == index) {
                                break;
                            }
                            i8++;
                        }
                        lazyListMeasuredItem4 = lazyListMeasuredItem5;
                    } else {
                        lazyListMeasuredItem4 = null;
                    }
                    if (lazyListMeasuredItem4 == null) {
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        arrayList.add(LazyListMeasuredItemProvider.m374getAndMeasure0kLqBqw$default(lazyListMeasuredItemProvider, index, 0L, 2, null));
                    }
                    if (index == min) {
                        break;
                    }
                    index++;
                }
            }
            float viewportEndOffset = ((lazyListLayoutInfo.getViewportEndOffset() - lazyListItemInfo2.getOffset()) - lazyListItemInfo2.getSize()) - f5;
            if (viewportEndOffset > 0.0f) {
                int index3 = lazyListItemInfo2.getIndex() + 1;
                int i9 = 0;
                while (index3 < i5 && i9 < viewportEndOffset) {
                    if (index3 <= min2) {
                        int size3 = list.size();
                        int i10 = 0;
                        while (true) {
                            if (i10 >= size3) {
                                lazyListMeasuredItem3 = null;
                                break;
                            }
                            lazyListMeasuredItem3 = list.get(i10);
                            if (lazyListMeasuredItem3.getIndex() == index3) {
                                break;
                            }
                            i10++;
                        }
                        lazyListMeasuredItem = lazyListMeasuredItem3;
                    } else if (arrayList != null) {
                        int size4 = arrayList.size();
                        int i11 = 0;
                        while (true) {
                            if (i11 >= size4) {
                                lazyListMeasuredItem2 = null;
                                break;
                            }
                            lazyListMeasuredItem2 = arrayList.get(i11);
                            if (lazyListMeasuredItem2.getIndex() == index3) {
                                break;
                            }
                            i11++;
                        }
                        lazyListMeasuredItem = lazyListMeasuredItem2;
                    } else {
                        lazyListMeasuredItem = null;
                    }
                    if (lazyListMeasuredItem != null) {
                        index3++;
                        mainAxisSizeWithSpacings = lazyListMeasuredItem.getMainAxisSizeWithSpacings();
                    } else {
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        arrayList.add(LazyListMeasuredItemProvider.m374getAndMeasure0kLqBqw$default(lazyListMeasuredItemProvider, index3, 0L, 2, null));
                        index3++;
                        mainAxisSizeWithSpacings = ((LazyListMeasuredItem) CollectionsKt.last((List) arrayList)).getMainAxisSizeWithSpacings();
                    }
                    i9 += mainAxisSizeWithSpacings;
                }
            }
        }
        if (arrayList != null && ((LazyListMeasuredItem) CollectionsKt.last((List) arrayList)).getIndex() > min2) {
            min2 = ((LazyListMeasuredItem) CollectionsKt.last((List) arrayList)).getIndex();
        }
        int size5 = list2.size();
        for (int i12 = 0; i12 < size5; i12++) {
            int intValue = list2.get(i12).intValue();
            if (intValue > min2) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(LazyListMeasuredItemProvider.m374getAndMeasure0kLqBqw$default(lazyListMeasuredItemProvider, intValue, 0L, 2, null));
            }
        }
        return arrayList == null ? CollectionsKt.emptyList() : arrayList;
    }

    private static final List<LazyListMeasuredItem> createItemsBeforeList(int i5, LazyListMeasuredItemProvider lazyListMeasuredItemProvider, int i6, List<Integer> list) {
        int max = Math.max(0, i5 - i6);
        int i7 = i5 - 1;
        ArrayList arrayList = null;
        if (max <= i7) {
            while (true) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(LazyListMeasuredItemProvider.m374getAndMeasure0kLqBqw$default(lazyListMeasuredItemProvider, i7, 0L, 2, null));
                if (i7 == max) {
                    break;
                }
                i7--;
            }
        }
        int size = list.size() - 1;
        if (size >= 0) {
            while (true) {
                int i8 = size - 1;
                int intValue = list.get(size).intValue();
                if (intValue < max) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(LazyListMeasuredItemProvider.m374getAndMeasure0kLqBqw$default(lazyListMeasuredItemProvider, intValue, 0L, 2, null));
                }
                if (i8 < 0) {
                    break;
                }
                size = i8;
            }
        }
        return arrayList == null ? CollectionsKt.emptyList() : arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:117:0x038d  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x03a3  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x03cb  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0410  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0415  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x03cd  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x03ae  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x039f  */
    /* renamed from: measureLazyList-x0Ok8Vo, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final LazyListMeasureResult m369measureLazyListx0Ok8Vo(int i5, LazyListMeasuredItemProvider lazyListMeasuredItemProvider, int i6, int i7, int i8, int i9, int i10, int i11, float f5, long j5, boolean z5, List<Integer> list, Arrangement.Vertical vertical, Arrangement.Horizontal horizontal, boolean z6, Density density, LazyLayoutItemAnimator<LazyListMeasuredItem> lazyLayoutItemAnimator, int i12, List<Integer> list2, boolean z7, boolean z8, LazyListLayoutInfo lazyListLayoutInfo, CoroutineScope coroutineScope, final MutableState<Unit> mutableState, GraphicsContext graphicsContext, Function3<? super Integer, ? super Integer, ? super Function1<? super Placeable.PlacementScope, Unit>, ? extends MeasureResult> function3) {
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        LazyListMeasuredItemProvider lazyListMeasuredItemProvider2;
        LazyListMeasuredItem lazyListMeasuredItem;
        int i20;
        int i21;
        int i22;
        int i23;
        final boolean z9;
        boolean z10;
        List<LazyListMeasuredItem> list3;
        int i24;
        int i25;
        if (i7 < 0) {
            throw new IllegalArgumentException("invalid beforeContentPadding");
        }
        if (i8 < 0) {
            throw new IllegalArgumentException("invalid afterContentPadding");
        }
        if (i5 <= 0) {
            int m2580getMinWidthimpl = Constraints.m2580getMinWidthimpl(j5);
            int m2579getMinHeightimpl = Constraints.m2579getMinHeightimpl(j5);
            lazyLayoutItemAnimator.onMeasured(0, m2580getMinWidthimpl, m2579getMinHeightimpl, new ArrayList(), lazyListMeasuredItemProvider.getKeyIndexMap(), lazyListMeasuredItemProvider, z5, z8, 1, z7, 0, 0, coroutineScope, graphicsContext);
            if (!z8) {
                long m417getMinSizeToFitDisappearingItemsYbymL2g = lazyLayoutItemAnimator.m417getMinSizeToFitDisappearingItemsYbymL2g();
                if (!IntSize.m2659equalsimpl0(m417getMinSizeToFitDisappearingItemsYbymL2g, IntSize.INSTANCE.m2665getZeroYbymL2g())) {
                    m2580getMinWidthimpl = ConstraintsKt.m2593constrainWidthK40F9xA(j5, IntSize.m2661getWidthimpl(m417getMinSizeToFitDisappearingItemsYbymL2g));
                    m2579getMinHeightimpl = ConstraintsKt.m2592constrainHeightK40F9xA(j5, IntSize.m2660getHeightimpl(m417getMinSizeToFitDisappearingItemsYbymL2g));
                }
            }
            return new LazyListMeasureResult(null, 0, false, 0.0f, function3.invoke(Integer.valueOf(m2580getMinWidthimpl), Integer.valueOf(m2579getMinHeightimpl), new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.lazy.LazyListMeasureKt$measureLazyList$3
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Placeable.PlacementScope placementScope) {
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                    invoke2(placementScope);
                    return Unit.INSTANCE;
                }
            }), 0.0f, false, coroutineScope, density, lazyListMeasuredItemProvider.getChildConstraints(), CollectionsKt.emptyList(), -i7, i6 + i8, 0, z6, z5 ? Orientation.Vertical : Orientation.Horizontal, i8, i9, null);
        }
        int i26 = 0;
        int i27 = i10;
        if (i27 >= i5) {
            i27 = i5 - 1;
            i13 = 0;
        } else {
            i13 = i11;
        }
        int round = Math.round(f5);
        int i28 = i13 - round;
        if (i27 == 0 && i28 < 0) {
            round += i28;
            i28 = 0;
        }
        ArrayDeque arrayDeque = new ArrayDeque();
        int i29 = -i7;
        int i30 = (i9 < 0 ? i9 : 0) + i29;
        int i31 = i28 + i30;
        int i32 = 0;
        while (i31 < 0 && i27 > 0) {
            i27--;
            LazyListMeasuredItem m374getAndMeasure0kLqBqw$default = LazyListMeasuredItemProvider.m374getAndMeasure0kLqBqw$default(lazyListMeasuredItemProvider, i27, 0L, 2, null);
            arrayDeque.add(i26, m374getAndMeasure0kLqBqw$default);
            i32 = Math.max(i32, m374getAndMeasure0kLqBqw$default.getCrossAxisSize());
            i31 += m374getAndMeasure0kLqBqw$default.getMainAxisSizeWithSpacings();
            i26 = 0;
        }
        if (i31 < i30) {
            round += i31;
            i31 = i30;
        }
        int i33 = i31 - i30;
        int i34 = i6 + i8;
        int i35 = i27;
        int coerceAtLeast = RangesKt.coerceAtLeast(i34, 0);
        int i36 = i35;
        int i37 = i32;
        int i38 = -i33;
        int i39 = 0;
        boolean z11 = false;
        while (i39 < arrayDeque.size()) {
            if (i38 >= coerceAtLeast) {
                arrayDeque.remove(i39);
                z11 = true;
            } else {
                i36++;
                i38 += ((LazyListMeasuredItem) arrayDeque.get(i39)).getMainAxisSizeWithSpacings();
                i39++;
            }
        }
        int i40 = i33;
        int i41 = i38;
        boolean z12 = z11;
        int i42 = i36;
        int i43 = i37;
        while (i42 < i5 && (i41 < coerceAtLeast || i41 <= 0 || arrayDeque.isEmpty())) {
            int i44 = coerceAtLeast;
            LazyListMeasuredItem m374getAndMeasure0kLqBqw$default2 = LazyListMeasuredItemProvider.m374getAndMeasure0kLqBqw$default(lazyListMeasuredItemProvider, i42, 0L, 2, null);
            i41 += m374getAndMeasure0kLqBqw$default2.getMainAxisSizeWithSpacings();
            if (i41 <= i30) {
                i24 = i30;
                if (i42 != i5 - 1) {
                    i25 = i42 + 1;
                    i40 -= m374getAndMeasure0kLqBqw$default2.getMainAxisSizeWithSpacings();
                    z12 = true;
                    i42++;
                    coerceAtLeast = i44;
                    i35 = i25;
                    i30 = i24;
                }
            } else {
                i24 = i30;
            }
            i43 = Math.max(i43, m374getAndMeasure0kLqBqw$default2.getCrossAxisSize());
            arrayDeque.add(m374getAndMeasure0kLqBqw$default2);
            i25 = i35;
            i42++;
            coerceAtLeast = i44;
            i35 = i25;
            i30 = i24;
        }
        if (i41 < i6) {
            int i45 = i6 - i41;
            i40 -= i45;
            int i46 = i41 + i45;
            i15 = i43;
            i18 = i35;
            while (i40 < i7 && i18 > 0) {
                int i47 = i18 - 1;
                LazyListMeasuredItem m374getAndMeasure0kLqBqw$default3 = LazyListMeasuredItemProvider.m374getAndMeasure0kLqBqw$default(lazyListMeasuredItemProvider, i47, 0L, 2, null);
                arrayDeque.add(0, m374getAndMeasure0kLqBqw$default3);
                i15 = Math.max(i15, m374getAndMeasure0kLqBqw$default3.getCrossAxisSize());
                i40 += m374getAndMeasure0kLqBqw$default3.getMainAxisSizeWithSpacings();
                i18 = i47;
                i34 = i34;
            }
            i14 = i34;
            i16 = i45 + round;
            if (i40 < 0) {
                i16 += i40;
                i17 = i46 + i40;
                i40 = 0;
            } else {
                i17 = i46;
            }
        } else {
            i14 = i34;
            i15 = i43;
            i16 = round;
            i17 = i41;
            i18 = i35;
        }
        int i48 = i15;
        float f6 = (MathKt.getSign(Math.round(f5)) != MathKt.getSign(i16) || Math.abs(Math.round(f5)) < Math.abs(i16)) ? f5 : i16;
        float f7 = f5 - f6;
        float f8 = (!z8 || i16 <= round || f7 > 0.0f) ? 0.0f : (i16 - round) + f7;
        if (i40 < 0) {
            throw new IllegalArgumentException("negative currentFirstItemScrollOffset");
        }
        int i49 = -i40;
        LazyListMeasuredItem lazyListMeasuredItem2 = (LazyListMeasuredItem) arrayDeque.first();
        if (i7 > 0 || i9 < 0) {
            int size = arrayDeque.size();
            LazyListMeasuredItem lazyListMeasuredItem3 = lazyListMeasuredItem2;
            int i50 = i40;
            int i51 = 0;
            while (i51 < size) {
                int i52 = size;
                int mainAxisSizeWithSpacings = ((LazyListMeasuredItem) arrayDeque.get(i51)).getMainAxisSizeWithSpacings();
                if (i50 == 0 || mainAxisSizeWithSpacings > i50) {
                    break;
                }
                i19 = i49;
                if (i51 == CollectionsKt.getLastIndex(arrayDeque)) {
                    break;
                }
                i50 -= mainAxisSizeWithSpacings;
                i51++;
                lazyListMeasuredItem3 = (LazyListMeasuredItem) arrayDeque.get(i51);
                i49 = i19;
                size = i52;
            }
            i19 = i49;
            lazyListMeasuredItemProvider2 = lazyListMeasuredItemProvider;
            lazyListMeasuredItem = lazyListMeasuredItem3;
            i20 = i12;
            i21 = i50;
        } else {
            i20 = i12;
            i19 = i49;
            i21 = i40;
            lazyListMeasuredItemProvider2 = lazyListMeasuredItemProvider;
            lazyListMeasuredItem = lazyListMeasuredItem2;
        }
        List<LazyListMeasuredItem> createItemsBeforeList = createItemsBeforeList(i18, lazyListMeasuredItemProvider2, i20, list2);
        int i53 = i42;
        int i54 = 0;
        int i55 = i48;
        for (int size2 = createItemsBeforeList.size(); i54 < size2; size2 = size2) {
            i55 = Math.max(i55, createItemsBeforeList.get(i54).getCrossAxisSize());
            i54++;
        }
        float f9 = f6;
        LazyListMeasuredItem lazyListMeasuredItem4 = lazyListMeasuredItem;
        List<LazyListMeasuredItem> createItemsAfterList = createItemsAfterList(arrayDeque, lazyListMeasuredItemProvider, i5, i12, list2, f9, z8, lazyListLayoutInfo);
        int size3 = createItemsAfterList.size();
        for (int i56 = 0; i56 < size3; i56++) {
            i55 = Math.max(i55, createItemsAfterList.get(i56).getCrossAxisSize());
        }
        boolean z13 = Intrinsics.areEqual(lazyListMeasuredItem4, arrayDeque.first()) && createItemsBeforeList.isEmpty() && createItemsAfterList.isEmpty();
        int m2593constrainWidthK40F9xA = ConstraintsKt.m2593constrainWidthK40F9xA(j5, z5 ? i55 : i17);
        if (z5) {
            i55 = i17;
        }
        int m2592constrainHeightK40F9xA = ConstraintsKt.m2592constrainHeightK40F9xA(j5, i55);
        int i57 = i14;
        int i58 = i17;
        final List<LazyListMeasuredItem> calculateItemsOffsets = calculateItemsOffsets(arrayDeque, createItemsBeforeList, createItemsAfterList, m2593constrainWidthK40F9xA, m2592constrainHeightK40F9xA, i17, i6, i19, z5, vertical, horizontal, z6, density);
        lazyLayoutItemAnimator.onMeasured((int) f9, m2593constrainWidthK40F9xA, m2592constrainHeightK40F9xA, calculateItemsOffsets, lazyListMeasuredItemProvider.getKeyIndexMap(), lazyListMeasuredItemProvider, z5, z8, 1, z7, i21, i58, coroutineScope, graphicsContext);
        if (!z8) {
            long m417getMinSizeToFitDisappearingItemsYbymL2g2 = lazyLayoutItemAnimator.m417getMinSizeToFitDisappearingItemsYbymL2g();
            if (!IntSize.m2659equalsimpl0(m417getMinSizeToFitDisappearingItemsYbymL2g2, IntSize.INSTANCE.m2665getZeroYbymL2g())) {
                int i59 = z5 ? m2592constrainHeightK40F9xA : m2593constrainWidthK40F9xA;
                int m2593constrainWidthK40F9xA2 = ConstraintsKt.m2593constrainWidthK40F9xA(j5, Math.max(m2593constrainWidthK40F9xA, IntSize.m2661getWidthimpl(m417getMinSizeToFitDisappearingItemsYbymL2g2)));
                i22 = ConstraintsKt.m2592constrainHeightK40F9xA(j5, Math.max(m2592constrainHeightK40F9xA, IntSize.m2660getHeightimpl(m417getMinSizeToFitDisappearingItemsYbymL2g2)));
                int i60 = z5 ? i22 : m2593constrainWidthK40F9xA2;
                if (i60 != i59) {
                    int size4 = calculateItemsOffsets.size();
                    for (int i61 = 0; i61 < size4; i61++) {
                        calculateItemsOffsets.get(i61).updateMainAxisLayoutSize(i60);
                    }
                }
                i23 = m2593constrainWidthK40F9xA2;
                final LazyListMeasuredItem findOrComposeLazyListHeader = list.isEmpty() ? LazyListHeadersKt.findOrComposeLazyListHeader(calculateItemsOffsets, lazyListMeasuredItemProvider, list, i7, i23, i22) : null;
                if (i53 < i5) {
                    z9 = z8;
                    if (i58 <= i6) {
                        z10 = false;
                        MeasureResult invoke = function3.invoke(Integer.valueOf(i23), Integer.valueOf(i22), new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.lazy.LazyListMeasureKt$measureLazyList$8
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
                                List<LazyListMeasuredItem> list4 = calculateItemsOffsets;
                                LazyListMeasuredItem lazyListMeasuredItem5 = findOrComposeLazyListHeader;
                                boolean z14 = z9;
                                int size5 = list4.size();
                                for (int i62 = 0; i62 < size5; i62++) {
                                    LazyListMeasuredItem lazyListMeasuredItem6 = list4.get(i62);
                                    if (lazyListMeasuredItem6 != lazyListMeasuredItem5) {
                                        lazyListMeasuredItem6.place(placementScope, z14);
                                    }
                                }
                                LazyListMeasuredItem lazyListMeasuredItem7 = findOrComposeLazyListHeader;
                                if (lazyListMeasuredItem7 != null) {
                                    lazyListMeasuredItem7.place(placementScope, z9);
                                }
                                ObservableScopeInvalidator.m425attachToScopeimpl(mutableState);
                            }
                        });
                        if (z13) {
                            list3 = calculateItemsOffsets;
                        } else {
                            ArrayList arrayList = new ArrayList(calculateItemsOffsets.size());
                            int size5 = calculateItemsOffsets.size();
                            for (int i62 = 0; i62 < size5; i62++) {
                                LazyListMeasuredItem lazyListMeasuredItem5 = calculateItemsOffsets.get(i62);
                                LazyListMeasuredItem lazyListMeasuredItem6 = lazyListMeasuredItem5;
                                if ((lazyListMeasuredItem6.getIndex() >= ((LazyListMeasuredItem) arrayDeque.first()).getIndex() && lazyListMeasuredItem6.getIndex() <= ((LazyListMeasuredItem) arrayDeque.last()).getIndex()) || lazyListMeasuredItem6 == findOrComposeLazyListHeader) {
                                    arrayList.add(lazyListMeasuredItem5);
                                }
                            }
                            list3 = arrayList;
                        }
                        return new LazyListMeasureResult(lazyListMeasuredItem4, i21, z10, f9, invoke, f8, z12, coroutineScope, density, lazyListMeasuredItemProvider.getChildConstraints(), list3, i29, i57, i5, z6, z5 ? Orientation.Vertical : Orientation.Horizontal, i8, i9, null);
                    }
                } else {
                    z9 = z8;
                }
                z10 = true;
                MeasureResult invoke2 = function3.invoke(Integer.valueOf(i23), Integer.valueOf(i22), new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.lazy.LazyListMeasureKt$measureLazyList$8
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
                        List<LazyListMeasuredItem> list4 = calculateItemsOffsets;
                        LazyListMeasuredItem lazyListMeasuredItem52 = findOrComposeLazyListHeader;
                        boolean z14 = z9;
                        int size52 = list4.size();
                        for (int i622 = 0; i622 < size52; i622++) {
                            LazyListMeasuredItem lazyListMeasuredItem62 = list4.get(i622);
                            if (lazyListMeasuredItem62 != lazyListMeasuredItem52) {
                                lazyListMeasuredItem62.place(placementScope, z14);
                            }
                        }
                        LazyListMeasuredItem lazyListMeasuredItem7 = findOrComposeLazyListHeader;
                        if (lazyListMeasuredItem7 != null) {
                            lazyListMeasuredItem7.place(placementScope, z9);
                        }
                        ObservableScopeInvalidator.m425attachToScopeimpl(mutableState);
                    }
                });
                if (z13) {
                }
                return new LazyListMeasureResult(lazyListMeasuredItem4, i21, z10, f9, invoke2, f8, z12, coroutineScope, density, lazyListMeasuredItemProvider.getChildConstraints(), list3, i29, i57, i5, z6, z5 ? Orientation.Vertical : Orientation.Horizontal, i8, i9, null);
            }
        }
        i22 = m2592constrainHeightK40F9xA;
        i23 = m2593constrainWidthK40F9xA;
        if (list.isEmpty()) {
        }
        if (i53 < i5) {
        }
        z10 = true;
        MeasureResult invoke22 = function3.invoke(Integer.valueOf(i23), Integer.valueOf(i22), new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.lazy.LazyListMeasureKt$measureLazyList$8
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
                List<LazyListMeasuredItem> list4 = calculateItemsOffsets;
                LazyListMeasuredItem lazyListMeasuredItem52 = findOrComposeLazyListHeader;
                boolean z14 = z9;
                int size52 = list4.size();
                for (int i622 = 0; i622 < size52; i622++) {
                    LazyListMeasuredItem lazyListMeasuredItem62 = list4.get(i622);
                    if (lazyListMeasuredItem62 != lazyListMeasuredItem52) {
                        lazyListMeasuredItem62.place(placementScope, z14);
                    }
                }
                LazyListMeasuredItem lazyListMeasuredItem7 = findOrComposeLazyListHeader;
                if (lazyListMeasuredItem7 != null) {
                    lazyListMeasuredItem7.place(placementScope, z9);
                }
                ObservableScopeInvalidator.m425attachToScopeimpl(mutableState);
            }
        });
        if (z13) {
        }
        return new LazyListMeasureResult(lazyListMeasuredItem4, i21, z10, f9, invoke22, f8, z12, coroutineScope, density, lazyListMeasuredItemProvider.getChildConstraints(), list3, i29, i57, i5, z6, z5 ? Orientation.Vertical : Orientation.Horizontal, i8, i9, null);
    }
}
