package androidx.compose.ui.node;

import android.support.v4.media.session.a;
import androidx.collection.MutableObjectFloatMap;
import androidx.collection.MutableScatterMap;
import androidx.collection.MutableScatterSet;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.PlaceableKt;
import androidx.compose.ui.layout.Ruler;
import androidx.compose.ui.layout.RulerScope;
import androidx.compose.ui.unit.IntOffset;
import java.lang.ref.WeakReference;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u009c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\r\b \u0018\u0000 e2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001eB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J-\u0010\u0016\u001a\u00020\n2\u001c\u0010\u0015\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00130\u0012j\b\u0012\u0004\u0012\u00020\u0013`\u00140\u0011H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0018\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0019\u001a\u00020\u0018H\u0086\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u0019\u001a\u00020\u0018H&¢\u0006\u0004\b\u001d\u0010\u001cJ\u000f\u0010\u001f\u001a\u00020\nH ¢\u0006\u0004\b\u001e\u0010\u0005J\u0013\u0010!\u001a\u00020\n*\u00020 H\u0004¢\u0006\u0004\b!\u0010\"J]\u0010-\u001a\u00020,2\u0006\u0010#\u001a\u00020\u001a2\u0006\u0010$\u001a\u00020\u001a2\u0012\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u001a0%2\u0014\u0010)\u001a\u0010\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020\n\u0018\u00010'2\u0012\u0010+\u001a\u000e\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020\n0'H\u0016¢\u0006\u0004\b-\u0010.J\u0019\u0010\u000f\u001a\u00020\n2\b\u0010/\u001a\u0004\u0018\u00010,H\u0000¢\u0006\u0004\b0\u00101R\u0018\u00102\u001a\u0004\u0018\u00010(8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u00103R\"\u00105\u001a\u0002048\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b5\u00106\u001a\u0004\b5\u00107\"\u0004\b8\u00109R\"\u0010:\u001a\u0002048\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b:\u00106\u001a\u0004\b;\u00107\"\u0004\b<\u00109R\"\u0010=\u001a\u0002048\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b=\u00106\u001a\u0004\b>\u00107\"\u0004\b?\u00109R\u0017\u0010@\u001a\u00020*8\u0006¢\u0006\f\n\u0004\b@\u0010A\u001a\u0004\bB\u0010CR\u001e\u0010E\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010D8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bE\u0010FR\u001e\u0010G\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010D8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bG\u0010FR:\u0010I\u001a&\u0012\u0004\u0012\u00020\u0006\u0012\u001a\u0012\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00130\u0012j\b\u0012\u0004\u0012\u00020\u0013`\u00140\u0011\u0018\u00010H8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bI\u0010JR\u001a\u0010N\u001a\u00020K8&X¦\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\bL\u0010MR\u0016\u0010Q\u001a\u0004\u0018\u00010\u00008&X¦\u0004¢\u0006\u0006\u001a\u0004\bO\u0010PR\u0016\u0010S\u001a\u0004\u0018\u00010\u00008&X¦\u0004¢\u0006\u0006\u001a\u0004\bR\u0010PR\u0014\u0010U\u001a\u0002048&X¦\u0004¢\u0006\u0006\u001a\u0004\bT\u00107R\u0014\u0010X\u001a\u00020\u00138&X¦\u0004¢\u0006\u0006\u001a\u0004\bV\u0010WR\u0014\u0010\\\u001a\u00020Y8&X¦\u0004¢\u0006\u0006\u001a\u0004\bZ\u0010[R\u0011\u0010_\u001a\u00020(8F¢\u0006\u0006\u001a\u0004\b]\u0010^R\u0014\u0010b\u001a\u00020,8 X \u0004¢\u0006\u0006\u001a\u0004\b`\u0010aR\u001a\u0010c\u001a\u0002048VX\u0096\u0004¢\u0006\f\u0012\u0004\bd\u0010\u0005\u001a\u0004\bc\u00107\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006f"}, d2 = {"Landroidx/compose/ui/node/LookaheadCapablePlaceable;", "Landroidx/compose/ui/layout/Placeable;", "Landroidx/compose/ui/node/MeasureScopeWithLayoutNode;", "Landroidx/compose/ui/node/MotionReferencePlacementDelegate;", "<init>", "()V", "Landroidx/compose/ui/layout/Ruler;", "ruler", "findAncestorRulerDefiner", "(Landroidx/compose/ui/layout/Ruler;)Landroidx/compose/ui/node/LookaheadCapablePlaceable;", BuildConfig.FLAVOR, "invalidateChildrenOfDefiningRuler", "(Landroidx/compose/ui/layout/Ruler;)V", "Landroidx/compose/ui/node/PlaceableResult;", "placeableResult", "captureRulers", "(Landroidx/compose/ui/node/PlaceableResult;)V", "Landroidx/collection/MutableScatterSet;", "Ljava/lang/ref/WeakReference;", "Landroidx/compose/ui/node/LayoutNode;", "Landroidx/compose/ui/node/WeakReference;", "layoutNodes", "notifyRulerValueChange", "(Landroidx/collection/MutableScatterSet;)V", "Landroidx/compose/ui/layout/AlignmentLine;", "alignmentLine", BuildConfig.FLAVOR, "get", "(Landroidx/compose/ui/layout/AlignmentLine;)I", "calculateAlignmentLine", "replace$ui_release", "replace", "Landroidx/compose/ui/node/NodeCoordinator;", "invalidateAlignmentLinesFromPositionChange", "(Landroidx/compose/ui/node/NodeCoordinator;)V", "width", "height", BuildConfig.FLAVOR, "alignmentLines", "Lkotlin/Function1;", "Landroidx/compose/ui/layout/RulerScope;", "rulers", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "placementBlock", "Landroidx/compose/ui/layout/MeasureResult;", "layout", "(IILjava/util/Map;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Landroidx/compose/ui/layout/MeasureResult;", "result", "captureRulers$ui_release", "(Landroidx/compose/ui/layout/MeasureResult;)V", "_rulerScope", "Landroidx/compose/ui/layout/RulerScope;", BuildConfig.FLAVOR, "isPlacedUnderMotionFrameOfReference", "Z", "()Z", "setPlacedUnderMotionFrameOfReference", "(Z)V", "isShallowPlacing", "isShallowPlacing$ui_release", "setShallowPlacing$ui_release", "isPlacingForAlignment", "isPlacingForAlignment$ui_release", "setPlacingForAlignment$ui_release", "placementScope", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "getPlacementScope", "()Landroidx/compose/ui/layout/Placeable$PlacementScope;", "Landroidx/collection/MutableObjectFloatMap;", "rulerValues", "Landroidx/collection/MutableObjectFloatMap;", "rulerValuesCache", "Landroidx/collection/MutableScatterMap;", "rulerReaders", "Landroidx/collection/MutableScatterMap;", "Landroidx/compose/ui/unit/IntOffset;", "getPosition-nOcc-ac", "()J", "position", "getChild", "()Landroidx/compose/ui/node/LookaheadCapablePlaceable;", "child", "getParent", "parent", "getHasMeasureResult", "hasMeasureResult", "getLayoutNode", "()Landroidx/compose/ui/node/LayoutNode;", "layoutNode", "Landroidx/compose/ui/layout/LayoutCoordinates;", "getCoordinates", "()Landroidx/compose/ui/layout/LayoutCoordinates;", "coordinates", "getRulerScope", "()Landroidx/compose/ui/layout/RulerScope;", "rulerScope", "getMeasureResult$ui_release", "()Landroidx/compose/ui/layout/MeasureResult;", "measureResult", "isLookingAhead", "isLookingAhead$annotations", "Companion", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class LookaheadCapablePlaceable extends Placeable implements MeasureScopeWithLayoutNode, MotionReferencePlacementDelegate {
    private static final Function1<PlaceableResult, Unit> onCommitAffectingRuler = new Function1<PlaceableResult, Unit>() { // from class: androidx.compose.ui.node.LookaheadCapablePlaceable$Companion$onCommitAffectingRuler$1
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(PlaceableResult placeableResult) {
            invoke2(placeableResult);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(PlaceableResult placeableResult) {
            if (placeableResult.isValidOwnerScope()) {
                placeableResult.getPlaceable().captureRulers(placeableResult);
            }
        }
    };
    private RulerScope _rulerScope;
    private boolean isPlacedUnderMotionFrameOfReference;
    private boolean isPlacingForAlignment;
    private boolean isShallowPlacing;
    private final Placeable.PlacementScope placementScope = PlaceableKt.PlacementScope(this);
    private MutableScatterMap<Ruler, MutableScatterSet<WeakReference<LayoutNode>>> rulerReaders;
    private MutableObjectFloatMap<Ruler> rulerValues;
    private MutableObjectFloatMap<Ruler> rulerValuesCache;

    /* JADX INFO: Access modifiers changed from: private */
    public final void captureRulers(final PlaceableResult placeableResult) {
        LookaheadCapablePlaceable parent;
        MutableScatterSet<WeakReference<LayoutNode>> remove;
        OwnerSnapshotObserver snapshotObserver;
        if (this.isPlacingForAlignment) {
            return;
        }
        Function1<RulerScope, Unit> rulers = placeableResult.getResult().getRulers();
        MutableScatterMap<Ruler, MutableScatterSet<WeakReference<LayoutNode>>> mutableScatterMap = this.rulerReaders;
        char c5 = 7;
        long j5 = -9187201950435737472L;
        int i5 = 0;
        if (rulers == null) {
            if (mutableScatterMap != null) {
                Object[] objArr = mutableScatterMap.values;
                long[] jArr = mutableScatterMap.metadata;
                int length = jArr.length - 2;
                if (length >= 0) {
                    int i6 = 0;
                    while (true) {
                        long j6 = jArr[i6];
                        if ((((~j6) << 7) & j6 & (-9187201950435737472L)) != -9187201950435737472L) {
                            int i7 = 8 - ((~(i6 - length)) >>> 31);
                            for (int i8 = 0; i8 < i7; i8++) {
                                if ((j6 & 255) < 128) {
                                    notifyRulerValueChange((MutableScatterSet) objArr[(i6 << 3) + i8]);
                                }
                                j6 >>= 8;
                            }
                            if (i7 != 8) {
                                break;
                            }
                        }
                        if (i6 == length) {
                            break;
                        } else {
                            i6++;
                        }
                    }
                }
                mutableScatterMap.clear();
                return;
            }
            return;
        }
        MutableObjectFloatMap<Ruler> mutableObjectFloatMap = this.rulerValuesCache;
        DefaultConstructorMarker defaultConstructorMarker = null;
        int i9 = 1;
        if (mutableObjectFloatMap == null) {
            mutableObjectFloatMap = new MutableObjectFloatMap<>(i5, i9, defaultConstructorMarker);
            this.rulerValuesCache = mutableObjectFloatMap;
        }
        MutableObjectFloatMap<Ruler> mutableObjectFloatMap2 = this.rulerValues;
        if (mutableObjectFloatMap2 == null) {
            mutableObjectFloatMap2 = new MutableObjectFloatMap<>(i5, i9, defaultConstructorMarker);
            this.rulerValues = mutableObjectFloatMap2;
        }
        mutableObjectFloatMap.putAll(mutableObjectFloatMap2);
        mutableObjectFloatMap2.clear();
        Owner owner = getLayoutNode().getOwner();
        if (owner != null && (snapshotObserver = owner.getSnapshotObserver()) != null) {
            snapshotObserver.observeReads$ui_release(placeableResult, onCommitAffectingRuler, new Function0<Unit>() { // from class: androidx.compose.ui.node.LookaheadCapablePlaceable$captureRulers$3
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    Function1<RulerScope, Unit> rulers2 = PlaceableResult.this.getResult().getRulers();
                    if (rulers2 != null) {
                        rulers2.invoke(this.getRulerScope());
                    }
                }
            });
        }
        if (mutableScatterMap != null) {
            Object[] objArr2 = mutableObjectFloatMap.keys;
            float[] fArr = mutableObjectFloatMap.values;
            long[] jArr2 = mutableObjectFloatMap.metadata;
            int length2 = jArr2.length - 2;
            if (length2 >= 0) {
                int i10 = 0;
                while (true) {
                    long j7 = jArr2[i10];
                    if ((((~j7) << 7) & j7 & j5) != j5) {
                        int i11 = 8 - ((~(i10 - length2)) >>> 31);
                        for (int i12 = 0; i12 < i11; i12++) {
                            if ((j7 & 255) < 128) {
                                int i13 = (i10 << 3) + i12;
                                Object obj = objArr2[i13];
                                float f5 = fArr[i13];
                                a.a(obj);
                                if (mutableObjectFloatMap2.getOrDefault(null, Float.NaN) != f5 && (remove = mutableScatterMap.remove(null)) != null) {
                                    notifyRulerValueChange(remove);
                                }
                            }
                            j7 >>= 8;
                        }
                        if (i11 != 8) {
                            break;
                        }
                    }
                    if (i10 == length2) {
                        break;
                    }
                    i10++;
                    j5 = -9187201950435737472L;
                }
            }
        }
        Object[] objArr3 = mutableObjectFloatMap2.keys;
        long[] jArr3 = mutableObjectFloatMap2.metadata;
        int length3 = jArr3.length - 2;
        if (length3 >= 0) {
            int i14 = 0;
            while (true) {
                long j8 = jArr3[i14];
                if ((((~j8) << c5) & j8 & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i15 = 8 - ((~(i14 - length3)) >>> 31);
                    for (int i16 = 0; i16 < i15; i16++) {
                        if ((j8 & 255) < 128) {
                            a.a(objArr3[(i14 << 3) + i16]);
                            if (!mutableObjectFloatMap.contains(null) && (parent = getParent()) != null) {
                                parent.invalidateChildrenOfDefiningRuler(null);
                            }
                        }
                        j8 >>= 8;
                    }
                    if (i15 != 8) {
                        break;
                    }
                }
                if (i14 == length3) {
                    break;
                }
                i14++;
                c5 = 7;
            }
        }
        mutableObjectFloatMap.clear();
    }

    private final LookaheadCapablePlaceable findAncestorRulerDefiner(Ruler ruler) {
        LookaheadCapablePlaceable parent;
        LookaheadCapablePlaceable lookaheadCapablePlaceable = this;
        while (true) {
            MutableObjectFloatMap<Ruler> mutableObjectFloatMap = lookaheadCapablePlaceable.rulerValues;
            if ((mutableObjectFloatMap != null && mutableObjectFloatMap.contains(ruler)) || (parent = lookaheadCapablePlaceable.getParent()) == null) {
                return lookaheadCapablePlaceable;
            }
            lookaheadCapablePlaceable = parent;
        }
    }

    private final void invalidateChildrenOfDefiningRuler(Ruler ruler) {
        MutableScatterMap<Ruler, MutableScatterSet<WeakReference<LayoutNode>>> mutableScatterMap = findAncestorRulerDefiner(ruler).rulerReaders;
        MutableScatterSet<WeakReference<LayoutNode>> remove = mutableScatterMap != null ? mutableScatterMap.remove(ruler) : null;
        if (remove != null) {
            notifyRulerValueChange(remove);
        }
    }

    private final void notifyRulerValueChange(MutableScatterSet<WeakReference<LayoutNode>> layoutNodes) {
        LayoutNode layoutNode;
        Object[] objArr = layoutNodes.elements;
        long[] jArr = layoutNodes.metadata;
        int length = jArr.length - 2;
        if (length < 0) {
            return;
        }
        int i5 = 0;
        while (true) {
            long j5 = jArr[i5];
            if ((((~j5) << 7) & j5 & (-9187201950435737472L)) != -9187201950435737472L) {
                int i6 = 8 - ((~(i5 - length)) >>> 31);
                for (int i7 = 0; i7 < i6; i7++) {
                    if ((255 & j5) < 128 && (layoutNode = (LayoutNode) ((WeakReference) objArr[(i5 << 3) + i7]).get()) != null) {
                        if (isLookingAhead()) {
                            layoutNode.requestLookaheadRelayout$ui_release(false);
                        } else {
                            layoutNode.requestRelayout$ui_release(false);
                        }
                    }
                    j5 >>= 8;
                }
                if (i6 != 8) {
                    return;
                }
            }
            if (i5 == length) {
                return;
            } else {
                i5++;
            }
        }
    }

    public abstract int calculateAlignmentLine(AlignmentLine alignmentLine);

    public final void captureRulers$ui_release(MeasureResult result) {
        if (result != null) {
            captureRulers(new PlaceableResult(result, this));
            return;
        }
        MutableScatterMap<Ruler, MutableScatterSet<WeakReference<LayoutNode>>> mutableScatterMap = this.rulerReaders;
        if (mutableScatterMap != null) {
            Object[] objArr = mutableScatterMap.values;
            long[] jArr = mutableScatterMap.metadata;
            int length = jArr.length - 2;
            if (length >= 0) {
                int i5 = 0;
                while (true) {
                    long j5 = jArr[i5];
                    if ((((~j5) << 7) & j5 & (-9187201950435737472L)) != -9187201950435737472L) {
                        int i6 = 8 - ((~(i5 - length)) >>> 31);
                        for (int i7 = 0; i7 < i6; i7++) {
                            if ((255 & j5) < 128) {
                                notifyRulerValueChange((MutableScatterSet) objArr[(i5 << 3) + i7]);
                            }
                            j5 >>= 8;
                        }
                        if (i6 != 8) {
                            break;
                        }
                    }
                    if (i5 == length) {
                        break;
                    } else {
                        i5++;
                    }
                }
            }
        }
        MutableScatterMap<Ruler, MutableScatterSet<WeakReference<LayoutNode>>> mutableScatterMap2 = this.rulerReaders;
        if (mutableScatterMap2 != null) {
            mutableScatterMap2.clear();
        }
        MutableObjectFloatMap<Ruler> mutableObjectFloatMap = this.rulerValues;
        if (mutableObjectFloatMap != null) {
            mutableObjectFloatMap.clear();
        }
    }

    @Override // androidx.compose.ui.layout.Measured
    public final int get(AlignmentLine alignmentLine) {
        int calculateAlignmentLine;
        if (getHasMeasureResult() && (calculateAlignmentLine = calculateAlignmentLine(alignmentLine)) != Integer.MIN_VALUE) {
            return calculateAlignmentLine + IntOffset.m2641getYimpl(getApparentToRealOffset());
        }
        return Integer.MIN_VALUE;
    }

    public abstract LookaheadCapablePlaceable getChild();

    public abstract LayoutCoordinates getCoordinates();

    public abstract boolean getHasMeasureResult();

    @Override // androidx.compose.ui.node.MeasureScopeWithLayoutNode
    public abstract LayoutNode getLayoutNode();

    public abstract MeasureResult getMeasureResult$ui_release();

    public abstract LookaheadCapablePlaceable getParent();

    public final Placeable.PlacementScope getPlacementScope() {
        return this.placementScope;
    }

    /* renamed from: getPosition-nOcc-ac, reason: not valid java name */
    public abstract long getPosition();

    public final RulerScope getRulerScope() {
        RulerScope rulerScope = this._rulerScope;
        return rulerScope == null ? new RulerScope() { // from class: androidx.compose.ui.node.LookaheadCapablePlaceable$rulerScope$1
            @Override // androidx.compose.ui.unit.Density
            public float getDensity() {
                return LookaheadCapablePlaceable.this.getDensity();
            }

            @Override // androidx.compose.ui.unit.FontScaling
            public float getFontScale() {
                return LookaheadCapablePlaceable.this.getFontScale();
            }
        } : rulerScope;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void invalidateAlignmentLinesFromPositionChange(NodeCoordinator nodeCoordinator) {
        AlignmentLines alignmentLines;
        NodeCoordinator wrapped = nodeCoordinator.getWrapped();
        if (!Intrinsics.areEqual(wrapped != null ? wrapped.getLayoutNode() : null, nodeCoordinator.getLayoutNode())) {
            nodeCoordinator.getAlignmentLinesOwner().getAlignmentLines().onAlignmentsChanged();
            return;
        }
        AlignmentLinesOwner parentAlignmentLinesOwner = nodeCoordinator.getAlignmentLinesOwner().getParentAlignmentLinesOwner();
        if (parentAlignmentLinesOwner == null || (alignmentLines = parentAlignmentLinesOwner.getAlignmentLines()) == null) {
            return;
        }
        alignmentLines.onAlignmentsChanged();
    }

    @Override // androidx.compose.ui.layout.IntrinsicMeasureScope
    public boolean isLookingAhead() {
        return false;
    }

    /* renamed from: isPlacedUnderMotionFrameOfReference, reason: from getter */
    public boolean getIsPlacedUnderMotionFrameOfReference() {
        return this.isPlacedUnderMotionFrameOfReference;
    }

    /* renamed from: isPlacingForAlignment$ui_release, reason: from getter */
    public final boolean getIsPlacingForAlignment() {
        return this.isPlacingForAlignment;
    }

    /* renamed from: isShallowPlacing$ui_release, reason: from getter */
    public final boolean getIsShallowPlacing() {
        return this.isShallowPlacing;
    }

    @Override // androidx.compose.ui.layout.MeasureScope
    public MeasureResult layout(final int width, final int height, final Map<AlignmentLine, Integer> alignmentLines, final Function1<? super RulerScope, Unit> rulers, final Function1<? super Placeable.PlacementScope, Unit> placementBlock) {
        if (!((width & (-16777216)) == 0 && ((-16777216) & height) == 0)) {
            InlineClassHelperKt.throwIllegalStateException("Size(" + width + " x " + height + ") is out of range. Each dimension must be between 0 and 16777215.");
        }
        return new MeasureResult() { // from class: androidx.compose.ui.node.LookaheadCapablePlaceable$layout$1
            @Override // androidx.compose.ui.layout.MeasureResult
            public Map<AlignmentLine, Integer> getAlignmentLines() {
                return alignmentLines;
            }

            @Override // androidx.compose.ui.layout.MeasureResult
            /* renamed from: getHeight, reason: from getter */
            public int get$height() {
                return height;
            }

            @Override // androidx.compose.ui.layout.MeasureResult
            public Function1<RulerScope, Unit> getRulers() {
                return rulers;
            }

            @Override // androidx.compose.ui.layout.MeasureResult
            /* renamed from: getWidth, reason: from getter */
            public int get$width() {
                return width;
            }

            @Override // androidx.compose.ui.layout.MeasureResult
            public void placeChildren() {
                placementBlock.invoke(this.getPlacementScope());
            }
        };
    }

    public abstract void replace$ui_release();

    @Override // androidx.compose.ui.node.MotionReferencePlacementDelegate
    public void setPlacedUnderMotionFrameOfReference(boolean z5) {
        this.isPlacedUnderMotionFrameOfReference = z5;
    }

    public final void setPlacingForAlignment$ui_release(boolean z5) {
        this.isPlacingForAlignment = z5;
    }

    public final void setShallowPlacing$ui_release(boolean z5) {
        this.isShallowPlacing = z5;
    }
}
