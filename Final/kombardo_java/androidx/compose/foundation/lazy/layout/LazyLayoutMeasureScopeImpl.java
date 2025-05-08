package androidx.compose.foundation.lazy.layout;

import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.RulerScope;
import androidx.compose.ui.layout.SubcomposeMeasureScope;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000¢\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u00002\u00020\u00012\u00020\u0002B\u0019\b\u0000\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJb\u0010\u0016\u001a\u00020\u00152\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0014\b\u0002\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\t0\f2\u0016\b\u0002\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u000f2\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00110\u000fH\u0096\u0001¢\u0006\u0004\b\u0016\u0010\u0017JJ\u0010\u0016\u001a\u00020\u00152\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0014\b\u0002\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\t0\f2\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00110\u000fH\u0096\u0001¢\u0006\u0004\b\u0016\u0010\u0018J\u0017\u0010\u001c\u001a\u00020\t*\u00020\u0019H\u0097\u0001ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010 \u001a\u00020\u001d*\u00020\u0019H\u0097\u0001ø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010 \u001a\u00020\u001d*\u00020!H\u0097\u0001ø\u0001\u0000¢\u0006\u0004\b\"\u0010#J(\u0010+\u001a\b\u0012\u0004\u0012\u00020(0'2\u0006\u0010$\u001a\u00020\t2\u0006\u0010&\u001a\u00020%H\u0016ø\u0001\u0000¢\u0006\u0004\b)\u0010*J\u0016\u0010-\u001a\u00020\u0019*\u00020!H\u0016ø\u0001\u0000¢\u0006\u0004\b,\u0010#J\u0019\u0010-\u001a\u00020\u0019*\u00020\tH\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b.\u0010/J\u0019\u0010-\u001a\u00020\u0019*\u00020\u001dH\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b.\u0010\u001fJ\u0019\u00102\u001a\u00020!*\u00020\u001dH\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b0\u00101J\u0016\u00102\u001a\u00020!*\u00020\u0019H\u0016ø\u0001\u0000¢\u0006\u0004\b3\u00101J\u0016\u00108\u001a\u000205*\u000204H\u0016ø\u0001\u0000¢\u0006\u0004\b6\u00107J\u0016\u0010:\u001a\u000204*\u000205H\u0016ø\u0001\u0000¢\u0006\u0004\b9\u00107R\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010;R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010<R\u0014\u0010>\u001a\u00020=8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b>\u0010?R<\u0010B\u001a*\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020(0'0@j\u0014\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020(0'`A8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bB\u0010CR\u0014\u0010F\u001a\u00020\u001d8\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\bD\u0010ER\u0014\u0010H\u001a\u00020\u001d8\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\bG\u0010ER\u0014\u0010J\u001a\u00020I8VX\u0096\u0005¢\u0006\u0006\u001a\u0004\bJ\u0010KR\u0014\u0010O\u001a\u00020L8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\bM\u0010N\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006P"}, d2 = {"Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScopeImpl;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutMeasureScope;", "Landroidx/compose/ui/layout/MeasureScope;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemContentFactory;", "itemContentFactory", "Landroidx/compose/ui/layout/SubcomposeMeasureScope;", "subcomposeMeasureScope", "<init>", "(Landroidx/compose/foundation/lazy/layout/LazyLayoutItemContentFactory;Landroidx/compose/ui/layout/SubcomposeMeasureScope;)V", BuildConfig.FLAVOR, "width", "height", BuildConfig.FLAVOR, "Landroidx/compose/ui/layout/AlignmentLine;", "alignmentLines", "Lkotlin/Function1;", "Landroidx/compose/ui/layout/RulerScope;", BuildConfig.FLAVOR, "rulers", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "placementBlock", "Landroidx/compose/ui/layout/MeasureResult;", "layout", "(IILjava/util/Map;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Landroidx/compose/ui/layout/MeasureResult;", "(IILjava/util/Map;Lkotlin/jvm/functions/Function1;)Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/unit/Dp;", "roundToPx-0680j_4", "(F)I", "roundToPx", BuildConfig.FLAVOR, "toPx-0680j_4", "(F)F", "toPx", "Landroidx/compose/ui/unit/TextUnit;", "toPx--R2X_6o", "(J)F", "index", "Landroidx/compose/ui/unit/Constraints;", "constraints", BuildConfig.FLAVOR, "Landroidx/compose/ui/layout/Placeable;", "measure-0kLqBqw", "(IJ)Ljava/util/List;", "measure", "toDp-GaN1DYA", "toDp", "toDp-u2uoSUM", "(I)F", "toSp-kPz2Gy4", "(F)J", "toSp", "toSp-0xMU5do", "Landroidx/compose/ui/unit/DpSize;", "Landroidx/compose/ui/geometry/Size;", "toSize-XkaWNTQ", "(J)J", "toSize", "toDpSize-k-rfVVM", "toDpSize", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemContentFactory;", "Landroidx/compose/ui/layout/SubcomposeMeasureScope;", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemProvider;", "itemProvider", "Landroidx/compose/foundation/lazy/layout/LazyLayoutItemProvider;", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "placeablesCache", "Ljava/util/HashMap;", "getDensity", "()F", "density", "getFontScale", "fontScale", BuildConfig.FLAVOR, "isLookingAhead", "()Z", "Landroidx/compose/ui/unit/LayoutDirection;", "getLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "layoutDirection", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class LazyLayoutMeasureScopeImpl implements LazyLayoutMeasureScope, MeasureScope {
    private final LazyLayoutItemContentFactory itemContentFactory;
    private final LazyLayoutItemProvider itemProvider;
    private final HashMap<Integer, List<Placeable>> placeablesCache = new HashMap<>();
    private final SubcomposeMeasureScope subcomposeMeasureScope;

    public LazyLayoutMeasureScopeImpl(LazyLayoutItemContentFactory lazyLayoutItemContentFactory, SubcomposeMeasureScope subcomposeMeasureScope) {
        this.itemContentFactory = lazyLayoutItemContentFactory;
        this.subcomposeMeasureScope = subcomposeMeasureScope;
        this.itemProvider = lazyLayoutItemContentFactory.getItemProvider().invoke();
    }

    @Override // androidx.compose.ui.unit.Density
    public float getDensity() {
        return this.subcomposeMeasureScope.getDensity();
    }

    @Override // androidx.compose.ui.unit.FontScaling
    public float getFontScale() {
        return this.subcomposeMeasureScope.getFontScale();
    }

    @Override // androidx.compose.ui.layout.IntrinsicMeasureScope
    public LayoutDirection getLayoutDirection() {
        return this.subcomposeMeasureScope.getLayoutDirection();
    }

    @Override // androidx.compose.ui.layout.IntrinsicMeasureScope
    public boolean isLookingAhead() {
        return this.subcomposeMeasureScope.isLookingAhead();
    }

    @Override // androidx.compose.ui.layout.MeasureScope
    public MeasureResult layout(int width, int height, Map<AlignmentLine, Integer> alignmentLines, Function1<? super Placeable.PlacementScope, Unit> placementBlock) {
        return this.subcomposeMeasureScope.layout(width, height, alignmentLines, placementBlock);
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope
    /* renamed from: measure-0kLqBqw */
    public List<Placeable> mo422measure0kLqBqw(int index, long constraints) {
        List<Placeable> list = this.placeablesCache.get(Integer.valueOf(index));
        if (list != null) {
            return list;
        }
        Object key = this.itemProvider.getKey(index);
        List<Measurable> subcompose = this.subcomposeMeasureScope.subcompose(key, this.itemContentFactory.getContent(index, key, this.itemProvider.getContentType(index)));
        int size = subcompose.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i5 = 0; i5 < size; i5++) {
            arrayList.add(subcompose.get(i5).mo1946measureBRTryo0(constraints));
        }
        this.placeablesCache.put(Integer.valueOf(index), arrayList);
        return arrayList;
    }

    @Override // androidx.compose.ui.unit.Density
    /* renamed from: roundToPx-0680j_4 */
    public int mo206roundToPx0680j_4(float f5) {
        return this.subcomposeMeasureScope.mo206roundToPx0680j_4(f5);
    }

    @Override // androidx.compose.ui.unit.FontScaling
    /* renamed from: toDp-GaN1DYA */
    public float mo207toDpGaN1DYA(long j5) {
        return this.subcomposeMeasureScope.mo207toDpGaN1DYA(j5);
    }

    @Override // androidx.compose.foundation.lazy.layout.LazyLayoutMeasureScope, androidx.compose.ui.unit.Density
    /* renamed from: toDp-u2uoSUM */
    public float mo209toDpu2uoSUM(int i5) {
        return this.subcomposeMeasureScope.mo209toDpu2uoSUM(i5);
    }

    @Override // androidx.compose.ui.unit.Density
    /* renamed from: toDpSize-k-rfVVM */
    public long mo210toDpSizekrfVVM(long j5) {
        return this.subcomposeMeasureScope.mo210toDpSizekrfVVM(j5);
    }

    @Override // androidx.compose.ui.unit.Density
    /* renamed from: toPx--R2X_6o */
    public float mo211toPxR2X_6o(long j5) {
        return this.subcomposeMeasureScope.mo211toPxR2X_6o(j5);
    }

    @Override // androidx.compose.ui.unit.Density
    /* renamed from: toPx-0680j_4 */
    public float mo212toPx0680j_4(float f5) {
        return this.subcomposeMeasureScope.mo212toPx0680j_4(f5);
    }

    @Override // androidx.compose.ui.unit.Density
    /* renamed from: toSize-XkaWNTQ */
    public long mo213toSizeXkaWNTQ(long j5) {
        return this.subcomposeMeasureScope.mo213toSizeXkaWNTQ(j5);
    }

    @Override // androidx.compose.ui.unit.FontScaling
    /* renamed from: toSp-0xMU5do */
    public long mo214toSp0xMU5do(float f5) {
        return this.subcomposeMeasureScope.mo214toSp0xMU5do(f5);
    }

    @Override // androidx.compose.ui.unit.Density
    /* renamed from: toSp-kPz2Gy4 */
    public long mo215toSpkPz2Gy4(float f5) {
        return this.subcomposeMeasureScope.mo215toSpkPz2Gy4(f5);
    }

    @Override // androidx.compose.ui.layout.MeasureScope
    public MeasureResult layout(int width, int height, Map<AlignmentLine, Integer> alignmentLines, Function1<? super RulerScope, Unit> rulers, Function1<? super Placeable.PlacementScope, Unit> placementBlock) {
        return this.subcomposeMeasureScope.layout(width, height, alignmentLines, rulers, placementBlock);
    }

    @Override // androidx.compose.ui.unit.Density
    /* renamed from: toDp-u2uoSUM */
    public float mo208toDpu2uoSUM(float f5) {
        return this.subcomposeMeasureScope.mo208toDpu2uoSUM(f5);
    }
}
