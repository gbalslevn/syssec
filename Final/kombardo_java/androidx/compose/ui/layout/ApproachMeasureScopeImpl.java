package androidx.compose.ui.layout;

import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.LayoutModifierNodeCoordinator;
import androidx.compose.ui.node.LookaheadDelegate;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0001B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJJ\u0010\u0014\u001a\u00020\u00132\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0014\b\u0002\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\t0\f2\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000fH\u0096\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0019\u001a\u00020\t*\u00020\u0016H\u0097\u0001ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001d\u001a\u00020\u0016*\u00020\u001aH\u0097\u0001ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u001cJ\u001a\u0010\u001d\u001a\u00020\u0016*\u00020\u001eH\u0097\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010 J\u001a\u0010\u001d\u001a\u00020\u0016*\u00020\tH\u0097\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010!J\u0017\u0010&\u001a\u00020#*\u00020\"H\u0097\u0001ø\u0001\u0000¢\u0006\u0004\b$\u0010%J\u0017\u0010(\u001a\u00020\u001e*\u00020\u0016H\u0097\u0001ø\u0001\u0000¢\u0006\u0004\b'\u0010 J\u0017\u0010(\u001a\u00020\u001e*\u00020\u001aH\u0097\u0001ø\u0001\u0000¢\u0006\u0004\b)\u0010\u001cJ\u0017\u0010+\u001a\u00020\"*\u00020#H\u0097\u0001ø\u0001\u0000¢\u0006\u0004\b*\u0010%J\u0017\u0010.\u001a\u00020\u001a*\u00020\u0016H\u0097\u0001ø\u0001\u0000¢\u0006\u0004\b,\u0010-J\u001a\u0010.\u001a\u00020\u001a*\u00020\u001eH\u0097\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b/\u0010-J]\u0010\u0014\u001a\u00020\u00132\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\t0\f2\u0014\u00101\u001a\u0010\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u000f2\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000fH\u0016¢\u0006\u0004\b\u0014\u00102R\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u00103\u001a\u0004\b4\u00105R\"\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0006\u00106\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\"\u0010<\u001a\u00020;8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\u0014\u0010D\u001a\u00020\u001e8\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\bB\u0010CR\u0014\u0010F\u001a\u00020\u001e8\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\bE\u0010CR\u0014\u0010J\u001a\u00020G8\u0016X\u0096\u0005¢\u0006\u0006\u001a\u0004\bH\u0010IR\u001a\u0010N\u001a\u00020K8VX\u0096\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\bL\u0010MR\u0014\u0010O\u001a\u00020;8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bO\u0010?\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006P"}, d2 = {"Landroidx/compose/ui/layout/ApproachMeasureScopeImpl;", BuildConfig.FLAVOR, "Landroidx/compose/ui/layout/MeasureScope;", "Landroidx/compose/ui/node/LayoutModifierNodeCoordinator;", "coordinator", "Landroidx/compose/ui/layout/ApproachLayoutModifierNode;", "approachNode", "<init>", "(Landroidx/compose/ui/node/LayoutModifierNodeCoordinator;Landroidx/compose/ui/layout/ApproachLayoutModifierNode;)V", BuildConfig.FLAVOR, "width", "height", BuildConfig.FLAVOR, "Landroidx/compose/ui/layout/AlignmentLine;", "alignmentLines", "Lkotlin/Function1;", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", BuildConfig.FLAVOR, "placementBlock", "Landroidx/compose/ui/layout/MeasureResult;", "layout", "(IILjava/util/Map;Lkotlin/jvm/functions/Function1;)Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/unit/Dp;", "roundToPx-0680j_4", "(F)I", "roundToPx", "Landroidx/compose/ui/unit/TextUnit;", "toDp-GaN1DYA", "(J)F", "toDp", BuildConfig.FLAVOR, "toDp-u2uoSUM", "(F)F", "(I)F", "Landroidx/compose/ui/geometry/Size;", "Landroidx/compose/ui/unit/DpSize;", "toDpSize-k-rfVVM", "(J)J", "toDpSize", "toPx-0680j_4", "toPx", "toPx--R2X_6o", "toSize-XkaWNTQ", "toSize", "toSp-0xMU5do", "(F)J", "toSp", "toSp-kPz2Gy4", "Landroidx/compose/ui/layout/RulerScope;", "rulers", "(IILjava/util/Map;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/node/LayoutModifierNodeCoordinator;", "getCoordinator", "()Landroidx/compose/ui/node/LayoutModifierNodeCoordinator;", "Landroidx/compose/ui/layout/ApproachLayoutModifierNode;", "getApproachNode", "()Landroidx/compose/ui/layout/ApproachLayoutModifierNode;", "setApproachNode", "(Landroidx/compose/ui/layout/ApproachLayoutModifierNode;)V", BuildConfig.FLAVOR, "approachMeasureRequired", "Z", "getApproachMeasureRequired$ui_release", "()Z", "setApproachMeasureRequired$ui_release", "(Z)V", "getDensity", "()F", "density", "getFontScale", "fontScale", "Landroidx/compose/ui/unit/LayoutDirection;", "getLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "layoutDirection", "Landroidx/compose/ui/unit/IntSize;", "getLookaheadSize-YbymL2g", "()J", "lookaheadSize", "isLookingAhead", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ApproachMeasureScopeImpl implements IntrinsicMeasureScope, MeasureScope {
    private boolean approachMeasureRequired;
    private ApproachLayoutModifierNode approachNode;
    private final LayoutModifierNodeCoordinator coordinator;

    public ApproachMeasureScopeImpl(LayoutModifierNodeCoordinator layoutModifierNodeCoordinator, ApproachLayoutModifierNode approachLayoutModifierNode) {
        this.coordinator = layoutModifierNodeCoordinator;
    }

    public final ApproachLayoutModifierNode getApproachNode() {
        return null;
    }

    public final LayoutModifierNodeCoordinator getCoordinator() {
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

    @Override // androidx.compose.ui.layout.IntrinsicMeasureScope
    public LayoutDirection getLayoutDirection() {
        return this.coordinator.getLayoutDirection();
    }

    /* renamed from: getLookaheadSize-YbymL2g, reason: not valid java name */
    public long m1927getLookaheadSizeYbymL2g() {
        LookaheadDelegate lookaheadDelegate = this.coordinator.getLookaheadDelegate();
        Intrinsics.checkNotNull(lookaheadDelegate);
        MeasureResult measureResult$ui_release = lookaheadDelegate.getMeasureResult$ui_release();
        return IntSizeKt.IntSize(measureResult$ui_release.getWidth(), measureResult$ui_release.getHeight());
    }

    @Override // androidx.compose.ui.layout.IntrinsicMeasureScope
    public boolean isLookingAhead() {
        return false;
    }

    @Override // androidx.compose.ui.layout.MeasureScope
    public MeasureResult layout(int width, int height, Map<AlignmentLine, Integer> alignmentLines, Function1<? super Placeable.PlacementScope, Unit> placementBlock) {
        return this.coordinator.layout(width, height, alignmentLines, placementBlock);
    }

    @Override // androidx.compose.ui.unit.Density
    /* renamed from: roundToPx-0680j_4 */
    public int mo206roundToPx0680j_4(float f5) {
        return this.coordinator.mo206roundToPx0680j_4(f5);
    }

    public final void setApproachNode(ApproachLayoutModifierNode approachLayoutModifierNode) {
    }

    @Override // androidx.compose.ui.unit.FontScaling
    /* renamed from: toDp-GaN1DYA */
    public float mo207toDpGaN1DYA(long j5) {
        return this.coordinator.mo207toDpGaN1DYA(j5);
    }

    @Override // androidx.compose.ui.unit.Density
    /* renamed from: toDp-u2uoSUM */
    public float mo208toDpu2uoSUM(float f5) {
        return this.coordinator.mo208toDpu2uoSUM(f5);
    }

    @Override // androidx.compose.ui.unit.Density
    /* renamed from: toDpSize-k-rfVVM */
    public long mo210toDpSizekrfVVM(long j5) {
        return this.coordinator.mo210toDpSizekrfVVM(j5);
    }

    @Override // androidx.compose.ui.unit.Density
    /* renamed from: toPx--R2X_6o */
    public float mo211toPxR2X_6o(long j5) {
        return this.coordinator.mo211toPxR2X_6o(j5);
    }

    @Override // androidx.compose.ui.unit.Density
    /* renamed from: toPx-0680j_4 */
    public float mo212toPx0680j_4(float f5) {
        return this.coordinator.mo212toPx0680j_4(f5);
    }

    @Override // androidx.compose.ui.unit.Density
    /* renamed from: toSize-XkaWNTQ */
    public long mo213toSizeXkaWNTQ(long j5) {
        return this.coordinator.mo213toSizeXkaWNTQ(j5);
    }

    @Override // androidx.compose.ui.unit.FontScaling
    /* renamed from: toSp-0xMU5do */
    public long mo214toSp0xMU5do(float f5) {
        return this.coordinator.mo214toSp0xMU5do(f5);
    }

    @Override // androidx.compose.ui.unit.Density
    /* renamed from: toSp-kPz2Gy4 */
    public long mo215toSpkPz2Gy4(float f5) {
        return this.coordinator.mo215toSpkPz2Gy4(f5);
    }

    @Override // androidx.compose.ui.layout.MeasureScope
    public MeasureResult layout(final int width, final int height, final Map<AlignmentLine, Integer> alignmentLines, final Function1<? super RulerScope, Unit> rulers, final Function1<? super Placeable.PlacementScope, Unit> placementBlock) {
        if (!((width & (-16777216)) == 0 && ((-16777216) & height) == 0)) {
            InlineClassHelperKt.throwIllegalStateException("Size(" + width + " x " + height + ") is out of range. Each dimension must be between 0 and 16777215.");
        }
        return new MeasureResult(width, height, alignmentLines, rulers, placementBlock, this) { // from class: androidx.compose.ui.layout.ApproachMeasureScopeImpl$layout$1
            final /* synthetic */ Function1<Placeable.PlacementScope, Unit> $placementBlock;
            private final Map<AlignmentLine, Integer> alignmentLines;
            private final int height;
            private final Function1<RulerScope, Unit> rulers;
            final /* synthetic */ ApproachMeasureScopeImpl this$0;
            private final int width;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: Multi-variable type inference failed */
            {
                this.$placementBlock = placementBlock;
                this.this$0 = this;
                this.width = width;
                this.height = height;
                this.alignmentLines = alignmentLines;
                this.rulers = rulers;
            }

            @Override // androidx.compose.ui.layout.MeasureResult
            public Map<AlignmentLine, Integer> getAlignmentLines() {
                return this.alignmentLines;
            }

            @Override // androidx.compose.ui.layout.MeasureResult
            public int getHeight() {
                return this.height;
            }

            @Override // androidx.compose.ui.layout.MeasureResult
            public Function1<RulerScope, Unit> getRulers() {
                return this.rulers;
            }

            @Override // androidx.compose.ui.layout.MeasureResult
            public int getWidth() {
                return this.width;
            }

            @Override // androidx.compose.ui.layout.MeasureResult
            public void placeChildren() {
                this.$placementBlock.invoke(this.this$0.getCoordinator().getPlacementScope());
            }
        };
    }

    @Override // androidx.compose.ui.unit.Density
    /* renamed from: toDp-u2uoSUM */
    public float mo209toDpu2uoSUM(int i5) {
        return this.coordinator.mo209toDpu2uoSUM(i5);
    }
}
