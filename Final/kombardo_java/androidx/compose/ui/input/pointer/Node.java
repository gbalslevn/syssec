package androidx.compose.ui.input.pointer;

import androidx.collection.LongSparseArray;
import androidx.collection.MutableObjectList;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerEventType;
import androidx.compose.ui.input.pointer.util.PointerIdArray;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.NodeKind;
import androidx.compose.ui.node.PointerInputModifierNode;
import androidx.compose.ui.node.PointerInputModifierNodeKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J!\u0010\n\u001a\u00020\t2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\r\u0010\u000eJ%\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000f2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00000\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J5\u0010\u001d\u001a\u00020\t2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u00152\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\tH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010\u001f\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\u001aH\u0016¢\u0006\u0004\b\u001f\u0010 J5\u0010!\u001a\u00020\t2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u00152\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\tH\u0016¢\u0006\u0004\b!\u0010\u001eJ\u000f\u0010\"\u001a\u00020\fH\u0016¢\u0006\u0004\b\"\u0010\u000eJ\r\u0010#\u001a\u00020\f¢\u0006\u0004\b#\u0010\u000eJ\u0017\u0010$\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\u001aH\u0016¢\u0006\u0004\b$\u0010%J\u000f\u0010'\u001a\u00020&H\u0016¢\u0006\u0004\b'\u0010(R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010)\u001a\u0004\b*\u0010+R\u0017\u0010-\u001a\u00020,8\u0006¢\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u00100R\u001a\u00101\u001a\b\u0012\u0004\u0012\u00020\u00160\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b1\u00102R\u0018\u00103\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b3\u00104R\u0018\u00105\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b5\u00106R\u0016\u00107\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b7\u00108R\u0016\u00109\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b9\u00108R\u0016\u0010:\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b:\u00108¨\u0006;"}, d2 = {"Landroidx/compose/ui/input/pointer/Node;", "Landroidx/compose/ui/input/pointer/NodeParent;", "Landroidx/compose/ui/Modifier$Node;", "modifierNode", "<init>", "(Landroidx/compose/ui/Modifier$Node;)V", "Landroidx/compose/ui/input/pointer/PointerEvent;", "oldEvent", "newEvent", BuildConfig.FLAVOR, "hasPositionChanged", "(Landroidx/compose/ui/input/pointer/PointerEvent;Landroidx/compose/ui/input/pointer/PointerEvent;)Z", BuildConfig.FLAVOR, "clearCache", "()V", BuildConfig.FLAVOR, "pointerIdValue", "Landroidx/collection/MutableObjectList;", "hitNodes", "removeInvalidPointerIdsAndChanges", "(JLandroidx/collection/MutableObjectList;)V", "Landroidx/collection/LongSparseArray;", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "changes", "Landroidx/compose/ui/layout/LayoutCoordinates;", "parentCoordinates", "Landroidx/compose/ui/input/pointer/InternalPointerEvent;", "internalPointerEvent", "isInBounds", "dispatchMainEventPass", "(Landroidx/collection/LongSparseArray;Landroidx/compose/ui/layout/LayoutCoordinates;Landroidx/compose/ui/input/pointer/InternalPointerEvent;Z)Z", "dispatchFinalEventPass", "(Landroidx/compose/ui/input/pointer/InternalPointerEvent;)Z", "buildCache", "dispatchCancel", "markIsIn", "cleanUpHits", "(Landroidx/compose/ui/input/pointer/InternalPointerEvent;)V", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", "Landroidx/compose/ui/Modifier$Node;", "getModifierNode", "()Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/input/pointer/util/PointerIdArray;", "pointerIds", "Landroidx/compose/ui/input/pointer/util/PointerIdArray;", "getPointerIds", "()Landroidx/compose/ui/input/pointer/util/PointerIdArray;", "relevantChanges", "Landroidx/collection/LongSparseArray;", "coordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "pointerEvent", "Landroidx/compose/ui/input/pointer/PointerEvent;", "wasIn", "Z", "isIn", "hasExited", "ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class Node extends NodeParent {
    private LayoutCoordinates coordinates;

    /* renamed from: modifierNode, reason: from kotlin metadata and from toString */
    private final Modifier.Node pointerInputFilter;
    private PointerEvent pointerEvent;
    private boolean wasIn;
    private final PointerIdArray pointerIds = new PointerIdArray();
    private final LongSparseArray<PointerInputChange> relevantChanges = new LongSparseArray<>(2);
    private boolean isIn = true;
    private boolean hasExited = true;

    public Node(Modifier.Node node) {
        this.pointerInputFilter = node;
    }

    private final void clearCache() {
        this.relevantChanges.clear();
        this.coordinates = null;
    }

    private final boolean hasPositionChanged(PointerEvent oldEvent, PointerEvent newEvent) {
        if (oldEvent == null || oldEvent.getChanges().size() != newEvent.getChanges().size()) {
            return true;
        }
        int size = newEvent.getChanges().size();
        for (int i5 = 0; i5 < size; i5++) {
            if (!Offset.m1334equalsimpl0(oldEvent.getChanges().get(i5).getPosition(), newEvent.getChanges().get(i5).getPosition())) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:100:0x01fb  */
    /* JADX WARN: Type inference failed for: r5v2, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r5v20 */
    /* JADX WARN: Type inference failed for: r5v21, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r5v22, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v23 */
    /* JADX WARN: Type inference failed for: r5v24 */
    /* JADX WARN: Type inference failed for: r5v25 */
    /* JADX WARN: Type inference failed for: r5v26 */
    /* JADX WARN: Type inference failed for: r5v27 */
    /* JADX WARN: Type inference failed for: r5v28 */
    /* JADX WARN: Type inference failed for: r5v3, types: [androidx.compose.ui.Modifier$Node] */
    @Override // androidx.compose.ui.input.pointer.NodeParent
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean buildCache(LongSparseArray<PointerInputChange> changes, LayoutCoordinates parentCoordinates, InternalPointerEvent internalPointerEvent, boolean isInBounds) {
        PointerInputChange pointerInputChange;
        boolean z5;
        boolean z6;
        int type;
        PointerEventType.Companion companion;
        boolean z7;
        int i5;
        int i6;
        PointerInputChange m1877copyOHpmEuE;
        List<HistoricalChange> list;
        int i7;
        boolean buildCache = super.buildCache(changes, parentCoordinates, internalPointerEvent, isInBounds);
        if (!this.pointerInputFilter.getIsAttached()) {
            return true;
        }
        DelegatingNode delegatingNode = this.pointerInputFilter;
        int m2074constructorimpl = NodeKind.m2074constructorimpl(16);
        MutableVector mutableVector = null;
        while (delegatingNode != 0) {
            if (delegatingNode instanceof PointerInputModifierNode) {
                this.coordinates = PointerInputModifierNodeKt.getLayoutCoordinates((PointerInputModifierNode) delegatingNode);
            } else if ((delegatingNode.getKindSet() & m2074constructorimpl) != 0 && (delegatingNode instanceof DelegatingNode)) {
                Modifier.Node delegate = delegatingNode.getDelegate();
                int i8 = 0;
                delegatingNode = delegatingNode;
                while (delegate != null) {
                    if ((delegate.getKindSet() & m2074constructorimpl) != 0) {
                        i8++;
                        if (i8 == 1) {
                            delegatingNode = delegate;
                        } else {
                            if (mutableVector == null) {
                                mutableVector = new MutableVector(new Modifier.Node[16], 0);
                            }
                            if (delegatingNode != 0) {
                                mutableVector.add(delegatingNode);
                                delegatingNode = 0;
                            }
                            mutableVector.add(delegate);
                        }
                    }
                    delegate = delegate.getChild();
                    delegatingNode = delegatingNode;
                }
                if (i8 == 1) {
                }
            }
            delegatingNode = DelegatableNodeKt.pop(mutableVector);
        }
        int size = changes.size();
        int i9 = 0;
        while (i9 < size) {
            long keyAt = changes.keyAt(i9);
            PointerInputChange valueAt = changes.valueAt(i9);
            if (this.pointerIds.contains(keyAt)) {
                long previousPosition = valueAt.getPreviousPosition();
                i6 = i9;
                long position = valueAt.getPosition();
                if (Offset.m1340isValidimpl(previousPosition) && Offset.m1340isValidimpl(position)) {
                    ArrayList arrayList = new ArrayList(valueAt.getHistorical().size());
                    List<HistoricalChange> historical = valueAt.getHistorical();
                    int size2 = historical.size();
                    i5 = size;
                    int i10 = 0;
                    while (i10 < size2) {
                        HistoricalChange historicalChange = historical.get(i10);
                        boolean z8 = buildCache;
                        long position2 = historicalChange.getPosition();
                        if (Offset.m1340isValidimpl(position2)) {
                            list = historical;
                            long uptimeMillis = historicalChange.getUptimeMillis();
                            i7 = size2;
                            LayoutCoordinates layoutCoordinates = this.coordinates;
                            Intrinsics.checkNotNull(layoutCoordinates);
                            arrayList.add(new HistoricalChange(uptimeMillis, layoutCoordinates.mo1949localPositionOfR5De75A(parentCoordinates, position2), historicalChange.getOriginalEventPosition(), null));
                        } else {
                            list = historical;
                            i7 = size2;
                        }
                        i10++;
                        historical = list;
                        size2 = i7;
                        buildCache = z8;
                    }
                    z7 = buildCache;
                    LongSparseArray<PointerInputChange> longSparseArray = this.relevantChanges;
                    LayoutCoordinates layoutCoordinates2 = this.coordinates;
                    Intrinsics.checkNotNull(layoutCoordinates2);
                    long mo1949localPositionOfR5De75A = layoutCoordinates2.mo1949localPositionOfR5De75A(parentCoordinates, previousPosition);
                    LayoutCoordinates layoutCoordinates3 = this.coordinates;
                    Intrinsics.checkNotNull(layoutCoordinates3);
                    m1877copyOHpmEuE = valueAt.m1877copyOHpmEuE((r34 & 1) != 0 ? valueAt.id : 0L, (r34 & 2) != 0 ? valueAt.uptimeMillis : 0L, (r34 & 4) != 0 ? valueAt.position : layoutCoordinates3.mo1949localPositionOfR5De75A(parentCoordinates, position), (r34 & 8) != 0 ? valueAt.pressed : false, (r34 & 16) != 0 ? valueAt.previousUptimeMillis : 0L, (r34 & 32) != 0 ? valueAt.previousPosition : mo1949localPositionOfR5De75A, (r34 & 64) != 0 ? valueAt.previousPressed : false, (r34 & 128) != 0 ? valueAt.type : 0, arrayList, (r34 & 512) != 0 ? valueAt.scrollDelta : 0L);
                    longSparseArray.put(keyAt, m1877copyOHpmEuE);
                } else {
                    z7 = buildCache;
                    i5 = size;
                }
            } else {
                z7 = buildCache;
                i5 = size;
                i6 = i9;
            }
            i9 = i6 + 1;
            size = i5;
            buildCache = z7;
        }
        boolean z9 = buildCache;
        if (this.relevantChanges.isEmpty()) {
            this.pointerIds.clear();
            getChildren().clear();
            return true;
        }
        for (int size3 = this.pointerIds.getSize() - 1; -1 < size3; size3--) {
            if (!changes.containsKey(this.pointerIds.m1921get_I2yYro(size3))) {
                this.pointerIds.removeAt(size3);
            }
        }
        ArrayList arrayList2 = new ArrayList(this.relevantChanges.size());
        int size4 = this.relevantChanges.size();
        for (int i11 = 0; i11 < size4; i11++) {
            arrayList2.add(this.relevantChanges.valueAt(i11));
        }
        PointerEvent pointerEvent = new PointerEvent(arrayList2, internalPointerEvent);
        List<PointerInputChange> changes2 = pointerEvent.getChanges();
        int size5 = changes2.size();
        int i12 = 0;
        while (true) {
            if (i12 >= size5) {
                pointerInputChange = null;
                break;
            }
            PointerInputChange pointerInputChange2 = changes2.get(i12);
            if (internalPointerEvent.m1848activeHoverEvent0FcD4WY(pointerInputChange2.getId())) {
                pointerInputChange = pointerInputChange2;
                break;
            }
            i12++;
        }
        PointerInputChange pointerInputChange3 = pointerInputChange;
        if (pointerInputChange3 != null) {
            if (isInBounds) {
                z5 = false;
                if (!this.isIn && (pointerInputChange3.getPressed() || pointerInputChange3.getPreviousPressed())) {
                    Intrinsics.checkNotNull(this.coordinates);
                    z6 = true;
                    this.isIn = !PointerEventKt.m1856isOutOfBoundsO0kMr_c(pointerInputChange3, r3.mo1948getSizeYbymL2g());
                    if (this.isIn != this.wasIn) {
                        int type2 = pointerEvent.getType();
                        PointerEventType.Companion companion2 = PointerEventType.INSTANCE;
                        if (PointerEventType.m1859equalsimpl0(type2, companion2.m1862getMove7fucELk()) || PointerEventType.m1859equalsimpl0(pointerEvent.getType(), companion2.m1860getEnter7fucELk()) || PointerEventType.m1859equalsimpl0(pointerEvent.getType(), companion2.m1861getExit7fucELk())) {
                            pointerEvent.m1855setTypeEhbLWgg$ui_release(this.isIn ? companion2.m1860getEnter7fucELk() : companion2.m1861getExit7fucELk());
                        }
                    }
                    type = pointerEvent.getType();
                    companion = PointerEventType.INSTANCE;
                    if (!PointerEventType.m1859equalsimpl0(type, companion.m1860getEnter7fucELk()) && this.wasIn && !this.hasExited) {
                        pointerEvent.m1855setTypeEhbLWgg$ui_release(companion.m1862getMove7fucELk());
                    } else if (PointerEventType.m1859equalsimpl0(pointerEvent.getType(), companion.m1861getExit7fucELk()) && this.isIn && pointerInputChange3.getPressed()) {
                        pointerEvent.m1855setTypeEhbLWgg$ui_release(companion.m1862getMove7fucELk());
                    }
                }
            } else {
                z5 = false;
                this.isIn = false;
            }
            z6 = true;
            if (this.isIn != this.wasIn) {
            }
            type = pointerEvent.getType();
            companion = PointerEventType.INSTANCE;
            if (!PointerEventType.m1859equalsimpl0(type, companion.m1860getEnter7fucELk())) {
            }
            if (PointerEventType.m1859equalsimpl0(pointerEvent.getType(), companion.m1861getExit7fucELk())) {
                pointerEvent.m1855setTypeEhbLWgg$ui_release(companion.m1862getMove7fucELk());
            }
        } else {
            z5 = false;
            z6 = true;
        }
        boolean z10 = (z9 || !PointerEventType.m1859equalsimpl0(pointerEvent.getType(), PointerEventType.INSTANCE.m1862getMove7fucELk()) || hasPositionChanged(this.pointerEvent, pointerEvent)) ? z6 : z5;
        this.pointerEvent = pointerEvent;
        return z10;
    }

    @Override // androidx.compose.ui.input.pointer.NodeParent
    public void cleanUpHits(InternalPointerEvent internalPointerEvent) {
        super.cleanUpHits(internalPointerEvent);
        PointerEvent pointerEvent = this.pointerEvent;
        if (pointerEvent == null) {
            return;
        }
        this.wasIn = this.isIn;
        List<PointerInputChange> changes = pointerEvent.getChanges();
        int size = changes.size();
        for (int i5 = 0; i5 < size; i5++) {
            PointerInputChange pointerInputChange = changes.get(i5);
            boolean pressed = pointerInputChange.getPressed();
            boolean m1848activeHoverEvent0FcD4WY = internalPointerEvent.m1848activeHoverEvent0FcD4WY(pointerInputChange.getId());
            boolean z5 = this.isIn;
            if ((!pressed && !m1848activeHoverEvent0FcD4WY) || (!pressed && !z5)) {
                this.pointerIds.m1922remove0FcD4WY(pointerInputChange.getId());
            }
        }
        this.isIn = false;
        this.hasExited = PointerEventType.m1859equalsimpl0(pointerEvent.getType(), PointerEventType.INSTANCE.m1861getExit7fucELk());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v2, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r0v6, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    @Override // androidx.compose.ui.input.pointer.NodeParent
    public void dispatchCancel() {
        MutableVector<Node> children = getChildren();
        int size = children.getSize();
        if (size > 0) {
            Node[] content = children.getContent();
            int i5 = 0;
            do {
                content[i5].dispatchCancel();
                i5++;
            } while (i5 < size);
        }
        DelegatingNode delegatingNode = this.pointerInputFilter;
        int m2074constructorimpl = NodeKind.m2074constructorimpl(16);
        MutableVector mutableVector = null;
        while (delegatingNode != 0) {
            if (delegatingNode instanceof PointerInputModifierNode) {
                ((PointerInputModifierNode) delegatingNode).onCancelPointerInput();
            } else if ((delegatingNode.getKindSet() & m2074constructorimpl) != 0 && (delegatingNode instanceof DelegatingNode)) {
                Modifier.Node delegate = delegatingNode.getDelegate();
                int i6 = 0;
                delegatingNode = delegatingNode;
                while (delegate != null) {
                    if ((delegate.getKindSet() & m2074constructorimpl) != 0) {
                        i6++;
                        if (i6 == 1) {
                            delegatingNode = delegate;
                        } else {
                            if (mutableVector == null) {
                                mutableVector = new MutableVector(new Modifier.Node[16], 0);
                            }
                            if (delegatingNode != 0) {
                                mutableVector.add(delegatingNode);
                                delegatingNode = 0;
                            }
                            mutableVector.add(delegate);
                        }
                    }
                    delegate = delegate.getChild();
                    delegatingNode = delegatingNode;
                }
                if (i6 == 1) {
                }
            }
            delegatingNode = DelegatableNodeKt.pop(mutableVector);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r4v1, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v4, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r4v5, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r4v9 */
    @Override // androidx.compose.ui.input.pointer.NodeParent
    public boolean dispatchFinalEventPass(InternalPointerEvent internalPointerEvent) {
        MutableVector<Node> children;
        int size;
        boolean z5 = false;
        int i5 = 0;
        z5 = false;
        if (!this.relevantChanges.isEmpty() && this.pointerInputFilter.getIsAttached()) {
            PointerEvent pointerEvent = this.pointerEvent;
            Intrinsics.checkNotNull(pointerEvent);
            LayoutCoordinates layoutCoordinates = this.coordinates;
            Intrinsics.checkNotNull(layoutCoordinates);
            long mo1948getSizeYbymL2g = layoutCoordinates.mo1948getSizeYbymL2g();
            DelegatingNode delegatingNode = this.pointerInputFilter;
            int m2074constructorimpl = NodeKind.m2074constructorimpl(16);
            MutableVector mutableVector = null;
            while (delegatingNode != 0) {
                if (delegatingNode instanceof PointerInputModifierNode) {
                    ((PointerInputModifierNode) delegatingNode).mo91onPointerEventH0pRuoY(pointerEvent, PointerEventPass.Final, mo1948getSizeYbymL2g);
                } else if ((delegatingNode.getKindSet() & m2074constructorimpl) != 0 && (delegatingNode instanceof DelegatingNode)) {
                    Modifier.Node delegate = delegatingNode.getDelegate();
                    int i6 = 0;
                    delegatingNode = delegatingNode;
                    while (delegate != null) {
                        if ((delegate.getKindSet() & m2074constructorimpl) != 0) {
                            i6++;
                            if (i6 == 1) {
                                delegatingNode = delegate;
                            } else {
                                if (mutableVector == null) {
                                    mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                }
                                if (delegatingNode != 0) {
                                    mutableVector.add(delegatingNode);
                                    delegatingNode = 0;
                                }
                                mutableVector.add(delegate);
                            }
                        }
                        delegate = delegate.getChild();
                        delegatingNode = delegatingNode;
                    }
                    if (i6 == 1) {
                    }
                }
                delegatingNode = DelegatableNodeKt.pop(mutableVector);
            }
            if (this.pointerInputFilter.getIsAttached() && (size = (children = getChildren()).getSize()) > 0) {
                Node[] content = children.getContent();
                do {
                    content[i5].dispatchFinalEventPass(internalPointerEvent);
                    i5++;
                } while (i5 < size);
            }
            z5 = true;
        }
        cleanUpHits(internalPointerEvent);
        clearCache();
        return z5;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r14v10 */
    /* JADX WARN: Type inference failed for: r14v11 */
    /* JADX WARN: Type inference failed for: r14v12 */
    /* JADX WARN: Type inference failed for: r14v13 */
    /* JADX WARN: Type inference failed for: r14v14 */
    /* JADX WARN: Type inference failed for: r14v3, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r14v4, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r14v6 */
    /* JADX WARN: Type inference failed for: r14v7, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r14v8, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r14v9 */
    /* JADX WARN: Type inference failed for: r2v0, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r2v1, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v16, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r2v17, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v18 */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v20 */
    /* JADX WARN: Type inference failed for: r2v21 */
    /* JADX WARN: Type inference failed for: r2v22 */
    /* JADX WARN: Type inference failed for: r2v23 */
    @Override // androidx.compose.ui.input.pointer.NodeParent
    public boolean dispatchMainEventPass(LongSparseArray<PointerInputChange> changes, LayoutCoordinates parentCoordinates, InternalPointerEvent internalPointerEvent, boolean isInBounds) {
        MutableVector<Node> children;
        int size;
        if (this.relevantChanges.isEmpty() || !this.pointerInputFilter.getIsAttached()) {
            return false;
        }
        PointerEvent pointerEvent = this.pointerEvent;
        Intrinsics.checkNotNull(pointerEvent);
        LayoutCoordinates layoutCoordinates = this.coordinates;
        Intrinsics.checkNotNull(layoutCoordinates);
        long mo1948getSizeYbymL2g = layoutCoordinates.mo1948getSizeYbymL2g();
        DelegatingNode delegatingNode = this.pointerInputFilter;
        int m2074constructorimpl = NodeKind.m2074constructorimpl(16);
        MutableVector mutableVector = null;
        while (delegatingNode != 0) {
            if (delegatingNode instanceof PointerInputModifierNode) {
                ((PointerInputModifierNode) delegatingNode).mo91onPointerEventH0pRuoY(pointerEvent, PointerEventPass.Initial, mo1948getSizeYbymL2g);
            } else if ((delegatingNode.getKindSet() & m2074constructorimpl) != 0 && (delegatingNode instanceof DelegatingNode)) {
                Modifier.Node delegate = delegatingNode.getDelegate();
                int i5 = 0;
                delegatingNode = delegatingNode;
                while (delegate != null) {
                    if ((delegate.getKindSet() & m2074constructorimpl) != 0) {
                        i5++;
                        if (i5 == 1) {
                            delegatingNode = delegate;
                        } else {
                            if (mutableVector == null) {
                                mutableVector = new MutableVector(new Modifier.Node[16], 0);
                            }
                            if (delegatingNode != 0) {
                                mutableVector.add(delegatingNode);
                                delegatingNode = 0;
                            }
                            mutableVector.add(delegate);
                        }
                    }
                    delegate = delegate.getChild();
                    delegatingNode = delegatingNode;
                }
                if (i5 == 1) {
                }
            }
            delegatingNode = DelegatableNodeKt.pop(mutableVector);
        }
        if (this.pointerInputFilter.getIsAttached() && (size = (children = getChildren()).getSize()) > 0) {
            Node[] content = children.getContent();
            int i6 = 0;
            do {
                Node node = content[i6];
                LongSparseArray<PointerInputChange> longSparseArray = this.relevantChanges;
                LayoutCoordinates layoutCoordinates2 = this.coordinates;
                Intrinsics.checkNotNull(layoutCoordinates2);
                node.dispatchMainEventPass(longSparseArray, layoutCoordinates2, internalPointerEvent, isInBounds);
                i6++;
            } while (i6 < size);
        }
        if (this.pointerInputFilter.getIsAttached()) {
            DelegatingNode delegatingNode2 = this.pointerInputFilter;
            int m2074constructorimpl2 = NodeKind.m2074constructorimpl(16);
            MutableVector mutableVector2 = null;
            while (delegatingNode2 != 0) {
                if (delegatingNode2 instanceof PointerInputModifierNode) {
                    ((PointerInputModifierNode) delegatingNode2).mo91onPointerEventH0pRuoY(pointerEvent, PointerEventPass.Main, mo1948getSizeYbymL2g);
                } else if ((delegatingNode2.getKindSet() & m2074constructorimpl2) != 0 && (delegatingNode2 instanceof DelegatingNode)) {
                    Modifier.Node delegate2 = delegatingNode2.getDelegate();
                    int i7 = 0;
                    delegatingNode2 = delegatingNode2;
                    while (delegate2 != null) {
                        if ((delegate2.getKindSet() & m2074constructorimpl2) != 0) {
                            i7++;
                            if (i7 == 1) {
                                delegatingNode2 = delegate2;
                            } else {
                                if (mutableVector2 == null) {
                                    mutableVector2 = new MutableVector(new Modifier.Node[16], 0);
                                }
                                if (delegatingNode2 != 0) {
                                    mutableVector2.add(delegatingNode2);
                                    delegatingNode2 = 0;
                                }
                                mutableVector2.add(delegate2);
                            }
                        }
                        delegate2 = delegate2.getChild();
                        delegatingNode2 = delegatingNode2;
                    }
                    if (i7 == 1) {
                    }
                }
                delegatingNode2 = DelegatableNodeKt.pop(mutableVector2);
            }
        }
        return true;
    }

    /* renamed from: getModifierNode, reason: from getter */
    public final Modifier.Node getPointerInputFilter() {
        return this.pointerInputFilter;
    }

    public final PointerIdArray getPointerIds() {
        return this.pointerIds;
    }

    public final void markIsIn() {
        this.isIn = true;
    }

    @Override // androidx.compose.ui.input.pointer.NodeParent
    public void removeInvalidPointerIdsAndChanges(long pointerIdValue, MutableObjectList<Node> hitNodes) {
        if (this.pointerIds.contains(pointerIdValue) && !hitNodes.contains(this)) {
            this.pointerIds.remove(pointerIdValue);
            this.relevantChanges.remove(pointerIdValue);
        }
        MutableVector<Node> children = getChildren();
        int size = children.getSize();
        if (size > 0) {
            Node[] content = children.getContent();
            int i5 = 0;
            do {
                content[i5].removeInvalidPointerIdsAndChanges(pointerIdValue, hitNodes);
                i5++;
            } while (i5 < size);
        }
    }

    public String toString() {
        return "Node(pointerInputFilter=" + this.pointerInputFilter + ", children=" + getChildren() + ", pointerIds=" + this.pointerIds + ')';
    }
}
