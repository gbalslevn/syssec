package androidx.compose.ui.node;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.AlignmentLineKt;
import androidx.compose.ui.layout.HorizontalAlignmentLine;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0016\n\u0002\u0010%\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001B\u0011\b\u0004\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J'\u0010\r\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\r\u0010\u000f\u001a\u00020\f¢\u0006\u0004\b\u000f\u0010\u0010J\u0019\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b0\u0011¢\u0006\u0004\b\u0012\u0010\u0013J\u001b\u0010\u0014\u001a\u00020\b*\u00020\n2\u0006\u0010\u0007\u001a\u00020\u0006H$¢\u0006\u0004\b\u0014\u0010\u0015J\r\u0010\u0016\u001a\u00020\f¢\u0006\u0004\b\u0016\u0010\u0010J\u000f\u0010\u0018\u001a\u00020\fH\u0000¢\u0006\u0004\b\u0017\u0010\u0010J\r\u0010\u0019\u001a\u00020\f¢\u0006\u0004\b\u0019\u0010\u0010J\u001e\u0010\u001e\u001a\u00020\u001a*\u00020\n2\u0006\u0010\u001b\u001a\u00020\u001aH$ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001dR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001f\u001a\u0004\b \u0010!R\"\u0010#\u001a\u00020\"8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\"\u0010)\u001a\u00020\"8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b)\u0010$\u001a\u0004\b*\u0010&\"\u0004\b+\u0010(R\"\u0010,\u001a\u00020\"8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b,\u0010$\u001a\u0004\b-\u0010&\"\u0004\b.\u0010(R\"\u0010/\u001a\u00020\"8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b/\u0010$\u001a\u0004\b0\u0010&\"\u0004\b1\u0010(R\"\u00102\u001a\u00020\"8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b2\u0010$\u001a\u0004\b3\u0010&\"\u0004\b4\u0010(R\"\u00105\u001a\u00020\"8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b5\u0010$\u001a\u0004\b6\u0010&\"\u0004\b7\u0010(R\u0018\u00108\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b8\u0010\u001fR \u0010:\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b098\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b:\u0010;R\u0014\u0010=\u001a\u00020\"8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b<\u0010&R\u0014\u0010?\u001a\u00020\"8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b>\u0010&R$\u0010B\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b0\u0011*\u00020\n8$X¤\u0004¢\u0006\u0006\u001a\u0004\b@\u0010A\u0082\u0001\u0002CD\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006E"}, d2 = {"Landroidx/compose/ui/node/AlignmentLines;", BuildConfig.FLAVOR, "Landroidx/compose/ui/node/AlignmentLinesOwner;", "alignmentLinesOwner", "<init>", "(Landroidx/compose/ui/node/AlignmentLinesOwner;)V", "Landroidx/compose/ui/layout/AlignmentLine;", "alignmentLine", BuildConfig.FLAVOR, "initialPosition", "Landroidx/compose/ui/node/NodeCoordinator;", "initialCoordinator", BuildConfig.FLAVOR, "addAlignmentLine", "(Landroidx/compose/ui/layout/AlignmentLine;ILandroidx/compose/ui/node/NodeCoordinator;)V", "recalculateQueryOwner", "()V", BuildConfig.FLAVOR, "getLastCalculation", "()Ljava/util/Map;", "getPositionFor", "(Landroidx/compose/ui/node/NodeCoordinator;Landroidx/compose/ui/layout/AlignmentLine;)I", "recalculate", "reset$ui_release", "reset", "onAlignmentsChanged", "Landroidx/compose/ui/geometry/Offset;", "position", "calculatePositionInParent-R5De75A", "(Landroidx/compose/ui/node/NodeCoordinator;J)J", "calculatePositionInParent", "Landroidx/compose/ui/node/AlignmentLinesOwner;", "getAlignmentLinesOwner", "()Landroidx/compose/ui/node/AlignmentLinesOwner;", BuildConfig.FLAVOR, "dirty", "Z", "getDirty$ui_release", "()Z", "setDirty$ui_release", "(Z)V", "usedDuringParentMeasurement", "getUsedDuringParentMeasurement$ui_release", "setUsedDuringParentMeasurement$ui_release", "usedDuringParentLayout", "getUsedDuringParentLayout$ui_release", "setUsedDuringParentLayout$ui_release", "previousUsedDuringParentLayout", "getPreviousUsedDuringParentLayout$ui_release", "setPreviousUsedDuringParentLayout$ui_release", "usedByModifierMeasurement", "getUsedByModifierMeasurement$ui_release", "setUsedByModifierMeasurement$ui_release", "usedByModifierLayout", "getUsedByModifierLayout$ui_release", "setUsedByModifierLayout$ui_release", "queryOwner", BuildConfig.FLAVOR, "alignmentLineMap", "Ljava/util/Map;", "getQueried$ui_release", "queried", "getRequired$ui_release", "required", "getAlignmentLinesMap", "(Landroidx/compose/ui/node/NodeCoordinator;)Ljava/util/Map;", "alignmentLinesMap", "Landroidx/compose/ui/node/LayoutNodeAlignmentLines;", "Landroidx/compose/ui/node/LookaheadAlignmentLines;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class AlignmentLines {
    private final Map<AlignmentLine, Integer> alignmentLineMap;
    private final AlignmentLinesOwner alignmentLinesOwner;
    private boolean dirty;
    private boolean previousUsedDuringParentLayout;
    private AlignmentLinesOwner queryOwner;
    private boolean usedByModifierLayout;
    private boolean usedByModifierMeasurement;
    private boolean usedDuringParentLayout;
    private boolean usedDuringParentMeasurement;

    public /* synthetic */ AlignmentLines(AlignmentLinesOwner alignmentLinesOwner, DefaultConstructorMarker defaultConstructorMarker) {
        this(alignmentLinesOwner);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void addAlignmentLine(AlignmentLine alignmentLine, int initialPosition, NodeCoordinator initialCoordinator) {
        float f5 = initialPosition;
        long Offset = OffsetKt.Offset(f5, f5);
        while (true) {
            Offset = mo1984calculatePositionInParentR5De75A(initialCoordinator, Offset);
            initialCoordinator = initialCoordinator.getWrappedBy();
            Intrinsics.checkNotNull(initialCoordinator);
            if (Intrinsics.areEqual(initialCoordinator, this.alignmentLinesOwner.getInnerCoordinator())) {
                break;
            } else if (getAlignmentLinesMap(initialCoordinator).containsKey(alignmentLine)) {
                float positionFor = getPositionFor(initialCoordinator, alignmentLine);
                Offset = OffsetKt.Offset(positionFor, positionFor);
            }
        }
        int round = Math.round(alignmentLine instanceof HorizontalAlignmentLine ? Offset.m1338getYimpl(Offset) : Offset.m1337getXimpl(Offset));
        Map<AlignmentLine, Integer> map = this.alignmentLineMap;
        if (map.containsKey(alignmentLine)) {
            round = AlignmentLineKt.merge(alignmentLine, ((Number) MapsKt.getValue(this.alignmentLineMap, alignmentLine)).intValue(), round);
        }
        map.put(alignmentLine, Integer.valueOf(round));
    }

    /* renamed from: calculatePositionInParent-R5De75A, reason: not valid java name */
    protected abstract long mo1984calculatePositionInParentR5De75A(NodeCoordinator nodeCoordinator, long j5);

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract Map<AlignmentLine, Integer> getAlignmentLinesMap(NodeCoordinator nodeCoordinator);

    public final AlignmentLinesOwner getAlignmentLinesOwner() {
        return this.alignmentLinesOwner;
    }

    /* renamed from: getDirty$ui_release, reason: from getter */
    public final boolean getDirty() {
        return this.dirty;
    }

    public final Map<AlignmentLine, Integer> getLastCalculation() {
        return this.alignmentLineMap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract int getPositionFor(NodeCoordinator nodeCoordinator, AlignmentLine alignmentLine);

    public final boolean getQueried$ui_release() {
        return this.usedDuringParentMeasurement || this.previousUsedDuringParentLayout || this.usedByModifierMeasurement || this.usedByModifierLayout;
    }

    public final boolean getRequired$ui_release() {
        recalculateQueryOwner();
        return this.queryOwner != null;
    }

    /* renamed from: getUsedDuringParentLayout$ui_release, reason: from getter */
    public final boolean getUsedDuringParentLayout() {
        return this.usedDuringParentLayout;
    }

    public final void onAlignmentsChanged() {
        this.dirty = true;
        AlignmentLinesOwner parentAlignmentLinesOwner = this.alignmentLinesOwner.getParentAlignmentLinesOwner();
        if (parentAlignmentLinesOwner == null) {
            return;
        }
        if (this.usedDuringParentMeasurement) {
            parentAlignmentLinesOwner.requestMeasure();
        } else if (this.previousUsedDuringParentLayout || this.usedDuringParentLayout) {
            parentAlignmentLinesOwner.requestLayout();
        }
        if (this.usedByModifierMeasurement) {
            this.alignmentLinesOwner.requestMeasure();
        }
        if (this.usedByModifierLayout) {
            this.alignmentLinesOwner.requestLayout();
        }
        parentAlignmentLinesOwner.getAlignmentLines().onAlignmentsChanged();
    }

    public final void recalculate() {
        this.alignmentLineMap.clear();
        this.alignmentLinesOwner.forEachChildAlignmentLinesOwner(new Function1<AlignmentLinesOwner, Unit>() { // from class: androidx.compose.ui.node.AlignmentLines$recalculate$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(AlignmentLinesOwner alignmentLinesOwner) {
                invoke2(alignmentLinesOwner);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(AlignmentLinesOwner alignmentLinesOwner) {
                Map map;
                if (alignmentLinesOwner.getIsPlaced()) {
                    if (alignmentLinesOwner.getAlignmentLines().getDirty()) {
                        alignmentLinesOwner.layoutChildren();
                    }
                    map = alignmentLinesOwner.getAlignmentLines().alignmentLineMap;
                    AlignmentLines alignmentLines = AlignmentLines.this;
                    for (Map.Entry entry : map.entrySet()) {
                        alignmentLines.addAlignmentLine((AlignmentLine) entry.getKey(), ((Number) entry.getValue()).intValue(), alignmentLinesOwner.getInnerCoordinator());
                    }
                    NodeCoordinator wrappedBy = alignmentLinesOwner.getInnerCoordinator().getWrappedBy();
                    Intrinsics.checkNotNull(wrappedBy);
                    while (!Intrinsics.areEqual(wrappedBy, AlignmentLines.this.getAlignmentLinesOwner().getInnerCoordinator())) {
                        Set<AlignmentLine> keySet = AlignmentLines.this.getAlignmentLinesMap(wrappedBy).keySet();
                        AlignmentLines alignmentLines2 = AlignmentLines.this;
                        for (AlignmentLine alignmentLine : keySet) {
                            alignmentLines2.addAlignmentLine(alignmentLine, alignmentLines2.getPositionFor(wrappedBy, alignmentLine), wrappedBy);
                        }
                        wrappedBy = wrappedBy.getWrappedBy();
                        Intrinsics.checkNotNull(wrappedBy);
                    }
                }
            }
        });
        this.alignmentLineMap.putAll(getAlignmentLinesMap(this.alignmentLinesOwner.getInnerCoordinator()));
        this.dirty = false;
    }

    public final void recalculateQueryOwner() {
        AlignmentLinesOwner alignmentLinesOwner;
        AlignmentLines alignmentLines;
        AlignmentLines alignmentLines2;
        if (getQueried$ui_release()) {
            alignmentLinesOwner = this.alignmentLinesOwner;
        } else {
            AlignmentLinesOwner parentAlignmentLinesOwner = this.alignmentLinesOwner.getParentAlignmentLinesOwner();
            if (parentAlignmentLinesOwner == null) {
                return;
            }
            alignmentLinesOwner = parentAlignmentLinesOwner.getAlignmentLines().queryOwner;
            if (alignmentLinesOwner == null || !alignmentLinesOwner.getAlignmentLines().getQueried$ui_release()) {
                AlignmentLinesOwner alignmentLinesOwner2 = this.queryOwner;
                if (alignmentLinesOwner2 == null || alignmentLinesOwner2.getAlignmentLines().getQueried$ui_release()) {
                    return;
                }
                AlignmentLinesOwner parentAlignmentLinesOwner2 = alignmentLinesOwner2.getParentAlignmentLinesOwner();
                if (parentAlignmentLinesOwner2 != null && (alignmentLines2 = parentAlignmentLinesOwner2.getAlignmentLines()) != null) {
                    alignmentLines2.recalculateQueryOwner();
                }
                AlignmentLinesOwner parentAlignmentLinesOwner3 = alignmentLinesOwner2.getParentAlignmentLinesOwner();
                alignmentLinesOwner = (parentAlignmentLinesOwner3 == null || (alignmentLines = parentAlignmentLinesOwner3.getAlignmentLines()) == null) ? null : alignmentLines.queryOwner;
            }
        }
        this.queryOwner = alignmentLinesOwner;
    }

    public final void reset$ui_release() {
        this.dirty = true;
        this.usedDuringParentMeasurement = false;
        this.previousUsedDuringParentLayout = false;
        this.usedDuringParentLayout = false;
        this.usedByModifierMeasurement = false;
        this.usedByModifierLayout = false;
        this.queryOwner = null;
    }

    public final void setPreviousUsedDuringParentLayout$ui_release(boolean z5) {
        this.previousUsedDuringParentLayout = z5;
    }

    public final void setUsedByModifierLayout$ui_release(boolean z5) {
        this.usedByModifierLayout = z5;
    }

    public final void setUsedByModifierMeasurement$ui_release(boolean z5) {
        this.usedByModifierMeasurement = z5;
    }

    public final void setUsedDuringParentLayout$ui_release(boolean z5) {
        this.usedDuringParentLayout = z5;
    }

    public final void setUsedDuringParentMeasurement$ui_release(boolean z5) {
        this.usedDuringParentMeasurement = z5;
    }

    private AlignmentLines(AlignmentLinesOwner alignmentLinesOwner) {
        this.alignmentLinesOwner = alignmentLinesOwner;
        this.dirty = true;
        this.alignmentLineMap = new HashMap();
    }
}
