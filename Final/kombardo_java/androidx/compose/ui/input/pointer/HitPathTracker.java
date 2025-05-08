package androidx.compose.ui.input.pointer;

import androidx.collection.MutableLongObjectMap;
import androidx.collection.MutableObjectList;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutCoordinates;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J%\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0002¢\u0006\u0004\b\f\u0010\rJ0\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u000e2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\b\b\u0002\u0010\u0013\u001a\u00020\u0012ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015J\u001f\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u00172\b\b\u0002\u0010\u0019\u001a\u00020\u0012¢\u0006\u0004\b\u001a\u0010\u001bJ\r\u0010\u001c\u001a\u00020\u000b¢\u0006\u0004\b\u001c\u0010\u001dJ\r\u0010\u001e\u001a\u00020\u000b¢\u0006\u0004\b\u001e\u0010\u001dJ\r\u0010\u001f\u001a\u00020\u000b¢\u0006\u0004\b\u001f\u0010\u001dR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010 R\u001a\u0010\"\u001a\u00020!8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R \u0010'\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0&8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010(\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006)"}, d2 = {"Landroidx/compose/ui/input/pointer/HitPathTracker;", BuildConfig.FLAVOR, "Landroidx/compose/ui/layout/LayoutCoordinates;", "rootCoordinates", "<init>", "(Landroidx/compose/ui/layout/LayoutCoordinates;)V", BuildConfig.FLAVOR, "pointerId", "Landroidx/collection/MutableObjectList;", "Landroidx/compose/ui/input/pointer/Node;", "hitNodes", BuildConfig.FLAVOR, "removeInvalidPointerIdsAndChanges", "(JLandroidx/collection/MutableObjectList;)V", "Landroidx/compose/ui/input/pointer/PointerId;", BuildConfig.FLAVOR, "Landroidx/compose/ui/Modifier$Node;", "pointerInputNodes", BuildConfig.FLAVOR, "prunePointerIdsAndChangesNotInNodesList", "addHitPath-QJqDSyo", "(JLjava/util/List;Z)V", "addHitPath", "Landroidx/compose/ui/input/pointer/InternalPointerEvent;", "internalPointerEvent", "isInBounds", "dispatchChanges", "(Landroidx/compose/ui/input/pointer/InternalPointerEvent;Z)Z", "clearPreviouslyHitModifierNodeCache", "()V", "processCancel", "removeDetachedPointerInputNodes", "Landroidx/compose/ui/layout/LayoutCoordinates;", "Landroidx/compose/ui/input/pointer/NodeParent;", "root", "Landroidx/compose/ui/input/pointer/NodeParent;", "getRoot$ui_release", "()Landroidx/compose/ui/input/pointer/NodeParent;", "Landroidx/collection/MutableLongObjectMap;", "hitPointerIdsAndNodes", "Landroidx/collection/MutableLongObjectMap;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class HitPathTracker {
    private final LayoutCoordinates rootCoordinates;
    private final NodeParent root = new NodeParent();
    private final MutableLongObjectMap<MutableObjectList<Node>> hitPointerIdsAndNodes = new MutableLongObjectMap<>(10);

    public HitPathTracker(LayoutCoordinates layoutCoordinates) {
        this.rootCoordinates = layoutCoordinates;
    }

    private final void removeInvalidPointerIdsAndChanges(long pointerId, MutableObjectList<Node> hitNodes) {
        this.root.removeInvalidPointerIdsAndChanges(pointerId, hitNodes);
    }

    /* renamed from: addHitPath-QJqDSyo, reason: not valid java name */
    public final void m1847addHitPathQJqDSyo(long pointerId, List<? extends Modifier.Node> pointerInputNodes, boolean prunePointerIdsAndChangesNotInNodesList) {
        Node node;
        NodeParent nodeParent = this.root;
        this.hitPointerIdsAndNodes.clear();
        int size = pointerInputNodes.size();
        boolean z5 = true;
        for (int i5 = 0; i5 < size; i5++) {
            Modifier.Node node2 = pointerInputNodes.get(i5);
            if (z5) {
                MutableVector<Node> children = nodeParent.getChildren();
                int size2 = children.getSize();
                if (size2 > 0) {
                    Node[] content = children.getContent();
                    int i6 = 0;
                    do {
                        node = content[i6];
                        if (Intrinsics.areEqual(node.getPointerInputFilter(), node2)) {
                            break;
                        } else {
                            i6++;
                        }
                    } while (i6 < size2);
                }
                node = null;
                Node node3 = node;
                if (node3 != null) {
                    node3.markIsIn();
                    node3.getPointerIds().m1920add0FcD4WY(pointerId);
                    MutableLongObjectMap<MutableObjectList<Node>> mutableLongObjectMap = this.hitPointerIdsAndNodes;
                    MutableObjectList<Node> mutableObjectList = mutableLongObjectMap.get(pointerId);
                    if (mutableObjectList == null) {
                        mutableObjectList = new MutableObjectList<>(0, 1, null);
                        mutableLongObjectMap.set(pointerId, mutableObjectList);
                    }
                    mutableObjectList.add(node3);
                    nodeParent = node3;
                } else {
                    z5 = false;
                }
            }
            Node node4 = new Node(node2);
            node4.getPointerIds().m1920add0FcD4WY(pointerId);
            MutableLongObjectMap<MutableObjectList<Node>> mutableLongObjectMap2 = this.hitPointerIdsAndNodes;
            MutableObjectList<Node> mutableObjectList2 = mutableLongObjectMap2.get(pointerId);
            if (mutableObjectList2 == null) {
                mutableObjectList2 = new MutableObjectList<>(0, 1, null);
                mutableLongObjectMap2.set(pointerId, mutableObjectList2);
            }
            mutableObjectList2.add(node4);
            nodeParent.getChildren().add(node4);
            nodeParent = node4;
        }
        if (!prunePointerIdsAndChangesNotInNodesList) {
            return;
        }
        MutableLongObjectMap<MutableObjectList<Node>> mutableLongObjectMap3 = this.hitPointerIdsAndNodes;
        long[] jArr = mutableLongObjectMap3.keys;
        Object[] objArr = mutableLongObjectMap3.values;
        long[] jArr2 = mutableLongObjectMap3.metadata;
        int length = jArr2.length - 2;
        if (length < 0) {
            return;
        }
        int i7 = 0;
        while (true) {
            long j5 = jArr2[i7];
            if ((((~j5) << 7) & j5 & (-9187201950435737472L)) != -9187201950435737472L) {
                int i8 = 8 - ((~(i7 - length)) >>> 31);
                for (int i9 = 0; i9 < i8; i9++) {
                    if ((255 & j5) < 128) {
                        int i10 = (i7 << 3) + i9;
                        removeInvalidPointerIdsAndChanges(jArr[i10], (MutableObjectList) objArr[i10]);
                    }
                    j5 >>= 8;
                }
                if (i8 != 8) {
                    return;
                }
            }
            if (i7 == length) {
                return;
            } else {
                i7++;
            }
        }
    }

    public final void clearPreviouslyHitModifierNodeCache() {
        this.root.clear();
    }

    public final boolean dispatchChanges(InternalPointerEvent internalPointerEvent, boolean isInBounds) {
        if (this.root.buildCache(internalPointerEvent.getChanges(), this.rootCoordinates, internalPointerEvent, isInBounds)) {
            return this.root.dispatchFinalEventPass(internalPointerEvent) || this.root.dispatchMainEventPass(internalPointerEvent.getChanges(), this.rootCoordinates, internalPointerEvent, isInBounds);
        }
        return false;
    }

    public final void processCancel() {
        this.root.dispatchCancel();
        clearPreviouslyHitModifierNodeCache();
    }

    public final void removeDetachedPointerInputNodes() {
        this.root.removeDetachedPointerInputModifierNodes();
    }
}
