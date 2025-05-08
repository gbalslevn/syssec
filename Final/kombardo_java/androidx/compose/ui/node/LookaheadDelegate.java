package androidx.compose.ui.node;

import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LookaheadLayoutCoordinates;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.node.LayoutNodeLayoutDelegate;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0004\b \u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u001a\u0010\f\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0002ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\rH\u0000¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0015\u001a\u00020\tH\u0010¢\u0006\u0004\b\u0013\u0010\u0014J8\u0010\u001d\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u00162\u0014\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\t\u0018\u00010\u0018H\u0004ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001cJ\u001a\u0010\u001f\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0000ø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u000bJ\u000f\u0010 \u001a\u00020\tH\u0014¢\u0006\u0004\b \u0010\u0014J\u0017\u0010\"\u001a\u00020\u000f2\u0006\u0010!\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\"\u0010#J\u0017\u0010$\u001a\u00020\u000f2\u0006\u0010!\u001a\u00020\u000fH\u0016¢\u0006\u0004\b$\u0010#J\u0017\u0010&\u001a\u00020\u000f2\u0006\u0010%\u001a\u00020\u000fH\u0016¢\u0006\u0004\b&\u0010#J\u0017\u0010'\u001a\u00020\u000f2\u0006\u0010%\u001a\u00020\u000fH\u0016¢\u0006\u0004\b'\u0010#J%\u0010-\u001a\u00020\u00072\u0006\u0010(\u001a\u00020\u00002\u0006\u0010*\u001a\u00020)H\u0000ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b+\u0010,R\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010.\u001a\u0004\b/\u00100R(\u0010\b\u001a\u00020\u00078\u0016@\u0016X\u0096\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0012\n\u0004\b\b\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u0010\u000bR$\u00106\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000f\u0018\u0001058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u00107R\u0017\u00109\u001a\u0002088\u0006¢\u0006\f\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<R(\u0010?\u001a\u0004\u0018\u00010=2\b\u0010>\u001a\u0004\u0018\u00010=8\u0002@BX\u0082\u000e¢\u0006\f\n\u0004\b?\u0010@\"\u0004\bA\u0010BR&\u0010C\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000f058\u0004X\u0084\u0004¢\u0006\f\n\u0004\bC\u00107\u001a\u0004\bD\u0010ER\u0016\u0010H\u001a\u0004\u0018\u00010\u00028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bF\u0010GR\u0014\u0010K\u001a\u00020)8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bI\u0010JR\u0014\u0010N\u001a\u00020=8PX\u0090\u0004¢\u0006\u0006\u001a\u0004\bL\u0010MR\u0014\u0010O\u001a\u00020)8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bO\u0010JR\u0014\u0010S\u001a\u00020P8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bQ\u0010RR\u0014\u0010V\u001a\u00020\u00168VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bT\u0010UR\u0014\u0010X\u001a\u00020\u00168VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bW\u0010UR\u0016\u0010Z\u001a\u0004\u0018\u00010\u00028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bY\u0010GR\u0014\u0010^\u001a\u00020[8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\\\u0010]R\u0014\u0010b\u001a\u00020_8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b`\u0010aR\u001a\u0010e\u001a\u00020c8@X\u0080\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\bd\u00103R\u0014\u0010i\u001a\u00020f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bg\u0010hR\u0016\u0010m\u001a\u0004\u0018\u00010j8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bk\u0010l\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006n"}, d2 = {"Landroidx/compose/ui/node/LookaheadDelegate;", "Landroidx/compose/ui/layout/Measurable;", "Landroidx/compose/ui/node/LookaheadCapablePlaceable;", "Landroidx/compose/ui/node/NodeCoordinator;", "coordinator", "<init>", "(Landroidx/compose/ui/node/NodeCoordinator;)V", "Landroidx/compose/ui/unit/IntOffset;", "position", BuildConfig.FLAVOR, "placeSelf--gyyYBs", "(J)V", "placeSelf", "Landroidx/compose/ui/layout/AlignmentLine;", "alignmentLine", BuildConfig.FLAVOR, "getCachedAlignmentLine$ui_release", "(Landroidx/compose/ui/layout/AlignmentLine;)I", "getCachedAlignmentLine", "replace$ui_release", "()V", "replace", BuildConfig.FLAVOR, "zIndex", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/GraphicsLayerScope;", "layerBlock", "placeAt-f8xVGno", "(JFLkotlin/jvm/functions/Function1;)V", "placeAt", "placeSelfApparentToRealOffset--gyyYBs$ui_release", "placeSelfApparentToRealOffset", "placeChildren", "height", "minIntrinsicWidth", "(I)I", "maxIntrinsicWidth", "width", "minIntrinsicHeight", "maxIntrinsicHeight", "ancestor", BuildConfig.FLAVOR, "excludingAgnosticOffset", "positionIn-iSbpLlY$ui_release", "(Landroidx/compose/ui/node/LookaheadDelegate;Z)J", "positionIn", "Landroidx/compose/ui/node/NodeCoordinator;", "getCoordinator", "()Landroidx/compose/ui/node/NodeCoordinator;", "J", "getPosition-nOcc-ac", "()J", "setPosition--gyyYBs", BuildConfig.FLAVOR, "oldAlignmentLines", "Ljava/util/Map;", "Landroidx/compose/ui/layout/LookaheadLayoutCoordinates;", "lookaheadLayoutCoordinates", "Landroidx/compose/ui/layout/LookaheadLayoutCoordinates;", "getLookaheadLayoutCoordinates", "()Landroidx/compose/ui/layout/LookaheadLayoutCoordinates;", "Landroidx/compose/ui/layout/MeasureResult;", "result", "_measureResult", "Landroidx/compose/ui/layout/MeasureResult;", "set_measureResult", "(Landroidx/compose/ui/layout/MeasureResult;)V", "cachedAlignmentLinesMap", "getCachedAlignmentLinesMap", "()Ljava/util/Map;", "getChild", "()Landroidx/compose/ui/node/LookaheadCapablePlaceable;", "child", "getHasMeasureResult", "()Z", "hasMeasureResult", "getMeasureResult$ui_release", "()Landroidx/compose/ui/layout/MeasureResult;", "measureResult", "isLookingAhead", "Landroidx/compose/ui/unit/LayoutDirection;", "getLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "layoutDirection", "getDensity", "()F", "density", "getFontScale", "fontScale", "getParent", "parent", "Landroidx/compose/ui/node/LayoutNode;", "getLayoutNode", "()Landroidx/compose/ui/node/LayoutNode;", "layoutNode", "Landroidx/compose/ui/layout/LayoutCoordinates;", "getCoordinates", "()Landroidx/compose/ui/layout/LayoutCoordinates;", "coordinates", "Landroidx/compose/ui/unit/Constraints;", "getConstraints-msEJaDk$ui_release", "constraints", "Landroidx/compose/ui/node/AlignmentLinesOwner;", "getAlignmentLinesOwner", "()Landroidx/compose/ui/node/AlignmentLinesOwner;", "alignmentLinesOwner", BuildConfig.FLAVOR, "getParentData", "()Ljava/lang/Object;", "parentData", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class LookaheadDelegate extends LookaheadCapablePlaceable implements Measurable {
    private MeasureResult _measureResult;
    private final NodeCoordinator coordinator;
    private Map<AlignmentLine, Integer> oldAlignmentLines;
    private long position = IntOffset.INSTANCE.m2648getZeronOccac();
    private final LookaheadLayoutCoordinates lookaheadLayoutCoordinates = new LookaheadLayoutCoordinates(this);
    private final Map<AlignmentLine, Integer> cachedAlignmentLinesMap = new LinkedHashMap();

    public LookaheadDelegate(NodeCoordinator nodeCoordinator) {
        this.coordinator = nodeCoordinator;
    }

    /* renamed from: access$setMeasurementConstraints-BRTryo0 */
    public static final /* synthetic */ void m2029access$setMeasurementConstraintsBRTryo0(LookaheadDelegate lookaheadDelegate, long j5) {
        lookaheadDelegate.m1967setMeasurementConstraintsBRTryo0(j5);
    }

    public static final /* synthetic */ void access$set_measureResult(LookaheadDelegate lookaheadDelegate, MeasureResult measureResult) {
        lookaheadDelegate.set_measureResult(measureResult);
    }

    /* renamed from: placeSelf--gyyYBs */
    private final void m2030placeSelfgyyYBs(long position) {
        if (!IntOffset.m2639equalsimpl0(getPosition(), position)) {
            m2034setPositiongyyYBs(position);
            LayoutNodeLayoutDelegate.LookaheadPassDelegate lookaheadPassDelegate = getLayoutNode().getLayoutDelegate().getLookaheadPassDelegate();
            if (lookaheadPassDelegate != null) {
                lookaheadPassDelegate.notifyChildrenUsingLookaheadCoordinatesWhilePlacing();
            }
            invalidateAlignmentLinesFromPositionChange(this.coordinator);
        }
        if (getIsPlacingForAlignment()) {
            return;
        }
        captureRulers$ui_release(getMeasureResult$ui_release());
    }

    public final void set_measureResult(MeasureResult measureResult) {
        Unit unit;
        Map<AlignmentLine, Integer> map;
        if (measureResult != null) {
            m1966setMeasuredSizeozmzZPI(IntSizeKt.IntSize(measureResult.getWidth(), measureResult.getHeight()));
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            m1966setMeasuredSizeozmzZPI(IntSize.INSTANCE.m2665getZeroYbymL2g());
        }
        if (!Intrinsics.areEqual(this._measureResult, measureResult) && measureResult != null && ((((map = this.oldAlignmentLines) != null && !map.isEmpty()) || !measureResult.getAlignmentLines().isEmpty()) && !Intrinsics.areEqual(measureResult.getAlignmentLines(), this.oldAlignmentLines))) {
            getAlignmentLinesOwner().getAlignmentLines().onAlignmentsChanged();
            Map map2 = this.oldAlignmentLines;
            if (map2 == null) {
                map2 = new LinkedHashMap();
                this.oldAlignmentLines = map2;
            }
            map2.clear();
            map2.putAll(measureResult.getAlignmentLines());
        }
        this._measureResult = measureResult;
    }

    public AlignmentLinesOwner getAlignmentLinesOwner() {
        AlignmentLinesOwner lookaheadAlignmentLinesOwner$ui_release = this.coordinator.getLayoutNode().getLayoutDelegate().getLookaheadAlignmentLinesOwner$ui_release();
        Intrinsics.checkNotNull(lookaheadAlignmentLinesOwner$ui_release);
        return lookaheadAlignmentLinesOwner$ui_release;
    }

    public final int getCachedAlignmentLine$ui_release(AlignmentLine alignmentLine) {
        Integer num = this.cachedAlignmentLinesMap.get(alignmentLine);
        if (num != null) {
            return num.intValue();
        }
        return Integer.MIN_VALUE;
    }

    public final Map<AlignmentLine, Integer> getCachedAlignmentLinesMap() {
        return this.cachedAlignmentLinesMap;
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public LookaheadCapablePlaceable getChild() {
        NodeCoordinator wrapped = this.coordinator.getWrapped();
        if (wrapped != null) {
            return wrapped.getLookaheadDelegate();
        }
        return null;
    }

    /* renamed from: getConstraints-msEJaDk$ui_release */
    public final long m2031getConstraintsmsEJaDk$ui_release() {
        return getMeasurementConstraints();
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public LayoutCoordinates getCoordinates() {
        return this.lookaheadLayoutCoordinates;
    }

    public final NodeCoordinator getCoordinator() {
        return this.coordinator;
    }

    @Override // androidx.compose.ui.unit.Density
    public float getDensity() {
        return this.coordinator.getDensity();
    }

    @Override // androidx.compose.ui.unit.FontScaling
    public float getFontScale() {
        return this.coordinator.getFontScale();
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public boolean getHasMeasureResult() {
        return this._measureResult != null;
    }

    @Override // androidx.compose.ui.layout.IntrinsicMeasureScope
    public LayoutDirection getLayoutDirection() {
        return this.coordinator.getLayoutDirection();
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable, androidx.compose.ui.node.MeasureScopeWithLayoutNode
    public LayoutNode getLayoutNode() {
        return this.coordinator.getLayoutNode();
    }

    public final LookaheadLayoutCoordinates getLookaheadLayoutCoordinates() {
        return this.lookaheadLayoutCoordinates;
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public MeasureResult getMeasureResult$ui_release() {
        MeasureResult measureResult = this._measureResult;
        if (measureResult != null) {
            return measureResult;
        }
        throw new IllegalStateException("LookaheadDelegate has not been measured yet when measureResult is requested.");
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public LookaheadCapablePlaceable getParent() {
        NodeCoordinator wrappedBy = this.coordinator.getWrappedBy();
        if (wrappedBy != null) {
            return wrappedBy.getLookaheadDelegate();
        }
        return null;
    }

    @Override // androidx.compose.ui.layout.Measured, androidx.compose.ui.layout.IntrinsicMeasurable
    public Object getParentData() {
        return this.coordinator.getParentData();
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    /* renamed from: getPosition-nOcc-ac, reason: from getter */
    public long getPosition() {
        return this.position;
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable, androidx.compose.ui.layout.IntrinsicMeasureScope
    public boolean isLookingAhead() {
        return true;
    }

    public abstract int maxIntrinsicHeight(int width);

    public abstract int maxIntrinsicWidth(int height);

    public abstract int minIntrinsicHeight(int width);

    public abstract int minIntrinsicWidth(int height);

    @Override // androidx.compose.ui.layout.Placeable
    /* renamed from: placeAt-f8xVGno */
    public final void mo1947placeAtf8xVGno(long position, float zIndex, Function1<? super GraphicsLayerScope, Unit> layerBlock) {
        m2030placeSelfgyyYBs(position);
        if (getIsShallowPlacing()) {
            return;
        }
        placeChildren();
    }

    protected void placeChildren() {
        getMeasureResult$ui_release().placeChildren();
    }

    /* renamed from: placeSelfApparentToRealOffset--gyyYBs$ui_release */
    public final void m2032placeSelfApparentToRealOffsetgyyYBs$ui_release(long position) {
        m2030placeSelfgyyYBs(IntOffset.m2644plusqkQi6aY(position, getApparentToRealOffset()));
    }

    /* renamed from: positionIn-iSbpLlY$ui_release */
    public final long m2033positionIniSbpLlY$ui_release(LookaheadDelegate ancestor, boolean excludingAgnosticOffset) {
        long m2648getZeronOccac = IntOffset.INSTANCE.m2648getZeronOccac();
        LookaheadDelegate lookaheadDelegate = this;
        while (!Intrinsics.areEqual(lookaheadDelegate, ancestor)) {
            if (!lookaheadDelegate.getIsPlacedUnderMotionFrameOfReference() || !excludingAgnosticOffset) {
                m2648getZeronOccac = IntOffset.m2644plusqkQi6aY(m2648getZeronOccac, lookaheadDelegate.getPosition());
            }
            NodeCoordinator wrappedBy = lookaheadDelegate.coordinator.getWrappedBy();
            Intrinsics.checkNotNull(wrappedBy);
            lookaheadDelegate = wrappedBy.getLookaheadDelegate();
            Intrinsics.checkNotNull(lookaheadDelegate);
        }
        return m2648getZeronOccac;
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public void replace$ui_release() {
        mo1947placeAtf8xVGno(getPosition(), 0.0f, (Function1<? super GraphicsLayerScope, Unit>) null);
    }

    /* renamed from: setPosition--gyyYBs */
    public void m2034setPositiongyyYBs(long j5) {
        this.position = j5;
    }
}
