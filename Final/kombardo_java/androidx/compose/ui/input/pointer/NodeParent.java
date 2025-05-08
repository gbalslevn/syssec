package androidx.compose.ui.input.pointer;

import androidx.collection.LongSparseArray;
import androidx.collection.MutableObjectList;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.layout.LayoutCoordinates;
import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0010\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J.\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\tH\u0016J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0006\u0010\u0014\u001a\u00020\u0013J\b\u0010\u0015\u001a\u00020\u0013H\u0016J\u0010\u0010\u0016\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J.\u0010\u0017\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\tH\u0016J\u0006\u0010\u0018\u001a\u00020\u0013J\u001e\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u001b2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00050\u001dH\u0016R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u001e"}, d2 = {"Landroidx/compose/ui/input/pointer/NodeParent;", BuildConfig.FLAVOR, "()V", "children", "Landroidx/compose/runtime/collection/MutableVector;", "Landroidx/compose/ui/input/pointer/Node;", "getChildren", "()Landroidx/compose/runtime/collection/MutableVector;", "buildCache", BuildConfig.FLAVOR, "changes", "Landroidx/collection/LongSparseArray;", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "parentCoordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "internalPointerEvent", "Landroidx/compose/ui/input/pointer/InternalPointerEvent;", "isInBounds", "cleanUpHits", BuildConfig.FLAVOR, "clear", "dispatchCancel", "dispatchFinalEventPass", "dispatchMainEventPass", "removeDetachedPointerInputModifierNodes", "removeInvalidPointerIdsAndChanges", "pointerIdValue", BuildConfig.FLAVOR, "hitNodes", "Landroidx/collection/MutableObjectList;", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public class NodeParent {
    public static final int $stable = MutableVector.$stable;
    private final MutableVector<Node> children = new MutableVector<>(new Node[16], 0);

    public boolean buildCache(LongSparseArray<PointerInputChange> changes, LayoutCoordinates parentCoordinates, InternalPointerEvent internalPointerEvent, boolean isInBounds) {
        MutableVector<Node> mutableVector = this.children;
        int size = mutableVector.getSize();
        if (size <= 0) {
            return false;
        }
        Node[] content = mutableVector.getContent();
        int i5 = 0;
        boolean z5 = false;
        do {
            z5 = content[i5].buildCache(changes, parentCoordinates, internalPointerEvent, isInBounds) || z5;
            i5++;
        } while (i5 < size);
        return z5;
    }

    public void cleanUpHits(InternalPointerEvent internalPointerEvent) {
        int size = this.children.getSize();
        while (true) {
            size--;
            if (-1 >= size) {
                return;
            }
            if (this.children.getContent()[size].getPointerIds().isEmpty()) {
                this.children.removeAt(size);
            }
        }
    }

    public final void clear() {
        this.children.clear();
    }

    public void dispatchCancel() {
        MutableVector<Node> mutableVector = this.children;
        int size = mutableVector.getSize();
        if (size > 0) {
            Node[] content = mutableVector.getContent();
            int i5 = 0;
            do {
                content[i5].dispatchCancel();
                i5++;
            } while (i5 < size);
        }
    }

    public boolean dispatchFinalEventPass(InternalPointerEvent internalPointerEvent) {
        MutableVector<Node> mutableVector = this.children;
        int size = mutableVector.getSize();
        boolean z5 = false;
        if (size > 0) {
            Node[] content = mutableVector.getContent();
            int i5 = 0;
            boolean z6 = false;
            do {
                z6 = content[i5].dispatchFinalEventPass(internalPointerEvent) || z6;
                i5++;
            } while (i5 < size);
            z5 = z6;
        }
        cleanUpHits(internalPointerEvent);
        return z5;
    }

    public boolean dispatchMainEventPass(LongSparseArray<PointerInputChange> changes, LayoutCoordinates parentCoordinates, InternalPointerEvent internalPointerEvent, boolean isInBounds) {
        MutableVector<Node> mutableVector = this.children;
        int size = mutableVector.getSize();
        if (size <= 0) {
            return false;
        }
        Node[] content = mutableVector.getContent();
        int i5 = 0;
        boolean z5 = false;
        do {
            z5 = content[i5].dispatchMainEventPass(changes, parentCoordinates, internalPointerEvent, isInBounds) || z5;
            i5++;
        } while (i5 < size);
        return z5;
    }

    public final MutableVector<Node> getChildren() {
        return this.children;
    }

    public final void removeDetachedPointerInputModifierNodes() {
        int i5 = 0;
        while (i5 < this.children.getSize()) {
            Node node = this.children.getContent()[i5];
            if (node.getPointerInputFilter().getIsAttached()) {
                i5++;
                node.removeDetachedPointerInputModifierNodes();
            } else {
                node.dispatchCancel();
                this.children.removeAt(i5);
            }
        }
    }

    public void removeInvalidPointerIdsAndChanges(long pointerIdValue, MutableObjectList<Node> hitNodes) {
        MutableVector<Node> mutableVector = this.children;
        int size = mutableVector.getSize();
        if (size > 0) {
            Node[] content = mutableVector.getContent();
            int i5 = 0;
            do {
                content[i5].removeInvalidPointerIdsAndChanges(pointerIdValue, hitNodes);
                i5++;
            } while (i5 < size);
        }
    }
}
