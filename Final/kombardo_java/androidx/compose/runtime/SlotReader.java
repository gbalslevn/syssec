package androidx.compose.runtime;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u001a\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001d\u0010\t\u001a\u0004\u0018\u00010\u0001*\u00020\u00062\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\u000b\u001a\u0004\u0018\u00010\u0001*\u00020\u00062\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u000b\u0010\nJ\u001d\u0010\f\u001a\u0004\u0018\u00010\u0001*\u00020\u00062\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\f\u0010\nJ\u0015\u0010\r\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u0015\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0012\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u0012\u0010\u000eJ\u0017\u0010\t\u001a\u0004\u0018\u00010\u00012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\u0013J\u0015\u0010\u0014\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u0014\u0010\u000eJ\u0015\u0010\u0015\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u0015\u0010\u000eJ\u0015\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u0016\u0010\u0011J\u0017\u0010\u0017\u001a\u0004\u0018\u00010\u00012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u0017\u0010\u0013J\u0017\u0010\u0018\u001a\u0004\u0018\u00010\u00012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u0018\u0010\u0013J\u0015\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u0019\u0010\u0011J\u0015\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u001a\u0010\u0011J\u0017\u0010\u001b\u001a\u0004\u0018\u00010\u00012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u001b\u0010\u0013J\u001f\u0010\u001b\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u001c\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u001b\u0010\u001dJ\u000f\u0010\u001e\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ\r\u0010!\u001a\u00020 ¢\u0006\u0004\b!\u0010\"J\r\u0010#\u001a\u00020 ¢\u0006\u0004\b#\u0010\"J\r\u0010$\u001a\u00020 ¢\u0006\u0004\b$\u0010\"J\r\u0010%\u001a\u00020 ¢\u0006\u0004\b%\u0010\"J\r\u0010&\u001a\u00020 ¢\u0006\u0004\b&\u0010\"J\r\u0010'\u001a\u00020\u0007¢\u0006\u0004\b'\u0010(J\r\u0010)\u001a\u00020 ¢\u0006\u0004\b)\u0010\"J\u0015\u0010*\u001a\u00020 2\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b*\u0010+J\u0015\u0010,\u001a\u00020 2\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b,\u0010+J\r\u0010-\u001a\u00020 ¢\u0006\u0004\b-\u0010\"J\u0013\u00100\u001a\b\u0012\u0004\u0012\u00020/0.¢\u0006\u0004\b0\u00101J\u000f\u00103\u001a\u000202H\u0016¢\u0006\u0004\b3\u00104J\u0017\u00106\u001a\u0002052\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b6\u00107R\u001a\u0010\u0003\u001a\u00020\u00028\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0003\u00108\u001a\u0004\b9\u0010:R\u0014\u0010;\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b;\u0010<R\u0014\u0010=\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b=\u0010>R\u001c\u0010@\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010?8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b@\u0010AR\u0014\u0010B\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bB\u0010>R6\u0010F\u001a\"\u0012\u0004\u0012\u000205\u0012\u0004\u0012\u00020D\u0018\u00010Cj\u0010\u0012\u0004\u0012\u000205\u0012\u0004\u0012\u00020D\u0018\u0001`E8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bF\u0010GR$\u0010I\u001a\u00020\u000f2\u0006\u0010H\u001a\u00020\u000f8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\bI\u0010J\u001a\u0004\bK\u0010LR$\u0010M\u001a\u00020\u00072\u0006\u0010H\u001a\u00020\u00078\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\bM\u0010>\u001a\u0004\bN\u0010(R$\u0010O\u001a\u00020\u00072\u0006\u0010H\u001a\u00020\u00078\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\bO\u0010>\u001a\u0004\bP\u0010(R$\u0010\r\u001a\u00020\u00072\u0006\u0010H\u001a\u00020\u00078\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\r\u0010>\u001a\u0004\bQ\u0010(R\u0014\u0010S\u001a\u00020R8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bS\u0010TR\u0016\u0010U\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bU\u0010>R\u0016\u0010V\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bV\u0010>R\u0016\u0010W\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bW\u0010>R$\u0010X\u001a\u00020\u000f2\u0006\u0010H\u001a\u00020\u000f8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\bX\u0010J\u001a\u0004\bY\u0010LR\u0011\u0010[\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\bZ\u0010(R\u0011\u0010\u0010\u001a\u00020\u000f8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010LR\u0011\u0010\\\u001a\u00020\u000f8F¢\u0006\u0006\u001a\u0004\b\\\u0010LR\u0011\u0010^\u001a\u00020\u000f8F¢\u0006\u0006\u001a\u0004\b]\u0010LR\u0011\u0010\u0014\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b_\u0010(R\u0011\u0010a\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b`\u0010(R\u0011\u0010\u0015\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\bb\u0010(R\u0011\u0010d\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\bc\u0010(R\u0011\u0010\u0016\u001a\u00020\u000f8F¢\u0006\u0006\u001a\u0004\be\u0010LR\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u00018F¢\u0006\u0006\u001a\u0004\bf\u0010\u001fR\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u00018F¢\u0006\u0006\u001a\u0004\bg\u0010\u001fR\u0011\u0010i\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\bh\u0010(R\u0011\u0010k\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\bj\u0010(¨\u0006l"}, d2 = {"Landroidx/compose/runtime/SlotReader;", BuildConfig.FLAVOR, "Landroidx/compose/runtime/SlotTable;", "table", "<init>", "(Landroidx/compose/runtime/SlotTable;)V", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "index", "node", "([II)Ljava/lang/Object;", "aux", "objectKey", "parent", "(I)I", BuildConfig.FLAVOR, "isNode", "(I)Z", "nodeCount", "(I)Ljava/lang/Object;", "groupSize", "groupKey", "hasObjectKey", "groupObjectKey", "groupAux", "hasMark", "containsMark", "groupGet", "group", "(II)Ljava/lang/Object;", "next", "()Ljava/lang/Object;", BuildConfig.FLAVOR, "beginEmpty", "()V", "endEmpty", "close", "startGroup", "startNode", "skipGroup", "()I", "skipToGroupEnd", "reposition", "(I)V", "restoreParent", "endGroup", BuildConfig.FLAVOR, "Landroidx/compose/runtime/KeyInfo;", "extractKeys", "()Ljava/util/List;", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", "Landroidx/compose/runtime/Anchor;", "anchor", "(I)Landroidx/compose/runtime/Anchor;", "Landroidx/compose/runtime/SlotTable;", "getTable$runtime_release", "()Landroidx/compose/runtime/SlotTable;", "groups", "[I", "groupsSize", "I", BuildConfig.FLAVOR, "slots", "[Ljava/lang/Object;", "slotsSize", "Ljava/util/HashMap;", "Landroidx/compose/runtime/GroupSourceInformation;", "Lkotlin/collections/HashMap;", "sourceInformationMap", "Ljava/util/HashMap;", "<set-?>", "closed", "Z", "getClosed", "()Z", "currentGroup", "getCurrentGroup", "currentEnd", "getCurrentEnd", "getParent", "Landroidx/compose/runtime/IntStack;", "currentSlotStack", "Landroidx/compose/runtime/IntStack;", "emptyCount", "currentSlot", "currentSlotEnd", "hadNext", "getHadNext", "getSize", "size", "isGroupEnd", "getInEmpty", "inEmpty", "getGroupSize", "getGroupEnd", "groupEnd", "getGroupKey", "getGroupSlotIndex", "groupSlotIndex", "getHasObjectKey", "getGroupObjectKey", "getGroupAux", "getParentNodes", "parentNodes", "getRemainingSlots", "remainingSlots", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SlotReader {
    private boolean closed;

    /* renamed from: currentEnd, reason: from kotlin metadata and from toString */
    private int end;

    /* renamed from: currentGroup, reason: from kotlin metadata and from toString */
    private int current;
    private int currentSlot;
    private int currentSlotEnd;
    private final IntStack currentSlotStack;
    private int emptyCount;
    private final int[] groups;
    private final int groupsSize;
    private boolean hadNext;
    private int parent;
    private final Object[] slots;
    private final int slotsSize;
    private HashMap<Anchor, GroupSourceInformation> sourceInformationMap;
    private final SlotTable table;

    public SlotReader(SlotTable slotTable) {
        this.table = slotTable;
        this.groups = slotTable.getGroups();
        int groupsSize = slotTable.getGroupsSize();
        this.groupsSize = groupsSize;
        this.slots = slotTable.getSlots();
        this.slotsSize = slotTable.getSlotsSize();
        this.end = groupsSize;
        this.parent = -1;
        this.currentSlotStack = new IntStack();
    }

    private final Object aux(int[] iArr, int i5) {
        return SlotTableKt.access$hasAux(iArr, i5) ? this.slots[SlotTableKt.access$auxIndex(iArr, i5)] : Composer.INSTANCE.getEmpty();
    }

    private final Object objectKey(int[] iArr, int i5) {
        if (SlotTableKt.access$hasObjectKey(iArr, i5)) {
            return this.slots[SlotTableKt.access$objectKeyIndex(iArr, i5)];
        }
        return null;
    }

    public final Anchor anchor(int index) {
        ArrayList<Anchor> anchors$runtime_release = this.table.getAnchors$runtime_release();
        int access$search = SlotTableKt.access$search(anchors$runtime_release, index, this.groupsSize);
        if (access$search >= 0) {
            return anchors$runtime_release.get(access$search);
        }
        Anchor anchor = new Anchor(index);
        anchors$runtime_release.add(-(access$search + 1), anchor);
        return anchor;
    }

    public final void beginEmpty() {
        this.emptyCount++;
    }

    public final void close() {
        this.closed = true;
        this.table.close$runtime_release(this, this.sourceInformationMap);
    }

    public final boolean containsMark(int index) {
        return SlotTableKt.access$containsMark(this.groups, index);
    }

    public final void endEmpty() {
        if (!(this.emptyCount > 0)) {
            PreconditionsKt.throwIllegalArgumentException("Unbalanced begin/end empty");
        }
        this.emptyCount--;
    }

    public final void endGroup() {
        if (this.emptyCount == 0) {
            if (!(this.current == this.end)) {
                ComposerKt.composeImmediateRuntimeError("endGroup() not called at the end of a group");
            }
            int access$parentAnchor = SlotTableKt.access$parentAnchor(this.groups, this.parent);
            this.parent = access$parentAnchor;
            this.end = access$parentAnchor < 0 ? this.groupsSize : SlotTableKt.access$groupSize(this.groups, access$parentAnchor) + access$parentAnchor;
            int pop = this.currentSlotStack.pop();
            if (pop < 0) {
                this.currentSlot = 0;
                this.currentSlotEnd = 0;
            } else {
                this.currentSlot = pop;
                this.currentSlotEnd = access$parentAnchor >= this.groupsSize - 1 ? this.slotsSize : SlotTableKt.access$dataAnchor(this.groups, access$parentAnchor + 1);
            }
        }
    }

    public final List<KeyInfo> extractKeys() {
        ArrayList arrayList = new ArrayList();
        if (this.emptyCount > 0) {
            return arrayList;
        }
        int i5 = this.current;
        int i6 = 0;
        while (i5 < this.end) {
            arrayList.add(new KeyInfo(SlotTableKt.access$key(this.groups, i5), objectKey(this.groups, i5), i5, SlotTableKt.access$isNode(this.groups, i5) ? 1 : SlotTableKt.access$nodeCount(this.groups, i5), i6));
            i5 += SlotTableKt.access$groupSize(this.groups, i5);
            i6++;
        }
        return arrayList;
    }

    public final boolean getClosed() {
        return this.closed;
    }

    /* renamed from: getCurrentEnd, reason: from getter */
    public final int getEnd() {
        return this.end;
    }

    /* renamed from: getCurrentGroup, reason: from getter */
    public final int getCurrent() {
        return this.current;
    }

    public final Object getGroupAux() {
        int i5 = this.current;
        if (i5 < this.end) {
            return aux(this.groups, i5);
        }
        return 0;
    }

    public final int getGroupEnd() {
        return this.end;
    }

    public final int getGroupKey() {
        int i5 = this.current;
        if (i5 < this.end) {
            return SlotTableKt.access$key(this.groups, i5);
        }
        return 0;
    }

    public final Object getGroupObjectKey() {
        int i5 = this.current;
        if (i5 < this.end) {
            return objectKey(this.groups, i5);
        }
        return null;
    }

    public final int getGroupSize() {
        return SlotTableKt.access$groupSize(this.groups, this.current);
    }

    public final int getGroupSlotIndex() {
        return this.currentSlot - SlotTableKt.access$slotAnchor(this.groups, this.parent);
    }

    public final boolean getHadNext() {
        return this.hadNext;
    }

    public final boolean getHasObjectKey() {
        int i5 = this.current;
        return i5 < this.end && SlotTableKt.access$hasObjectKey(this.groups, i5);
    }

    public final boolean getInEmpty() {
        return this.emptyCount > 0;
    }

    public final int getParent() {
        return this.parent;
    }

    public final int getParentNodes() {
        int i5 = this.parent;
        if (i5 >= 0) {
            return SlotTableKt.access$nodeCount(this.groups, i5);
        }
        return 0;
    }

    public final int getRemainingSlots() {
        return this.currentSlotEnd - this.currentSlot;
    }

    /* renamed from: getSize, reason: from getter */
    public final int getGroupsSize() {
        return this.groupsSize;
    }

    /* renamed from: getTable$runtime_release, reason: from getter */
    public final SlotTable getTable() {
        return this.table;
    }

    public final Object groupAux(int index) {
        return aux(this.groups, index);
    }

    public final Object groupGet(int index) {
        return groupGet(this.current, index);
    }

    public final int groupKey(int index) {
        return SlotTableKt.access$key(this.groups, index);
    }

    public final Object groupObjectKey(int index) {
        return objectKey(this.groups, index);
    }

    public final int groupSize(int index) {
        return SlotTableKt.access$groupSize(this.groups, index);
    }

    public final boolean hasMark(int index) {
        return SlotTableKt.access$hasMark(this.groups, index);
    }

    public final boolean hasObjectKey(int index) {
        return SlotTableKt.access$hasObjectKey(this.groups, index);
    }

    public final boolean isGroupEnd() {
        return getInEmpty() || this.current == this.end;
    }

    public final boolean isNode() {
        return SlotTableKt.access$isNode(this.groups, this.current);
    }

    public final Object next() {
        int i5;
        if (this.emptyCount > 0 || (i5 = this.currentSlot) >= this.currentSlotEnd) {
            this.hadNext = false;
            return Composer.INSTANCE.getEmpty();
        }
        this.hadNext = true;
        Object[] objArr = this.slots;
        this.currentSlot = i5 + 1;
        return objArr[i5];
    }

    public final Object node(int index) {
        if (SlotTableKt.access$isNode(this.groups, index)) {
            return node(this.groups, index);
        }
        return null;
    }

    public final int nodeCount(int index) {
        return SlotTableKt.access$nodeCount(this.groups, index);
    }

    public final int parent(int index) {
        return SlotTableKt.access$parentAnchor(this.groups, index);
    }

    public final void reposition(int index) {
        if (!(this.emptyCount == 0)) {
            ComposerKt.composeImmediateRuntimeError("Cannot reposition while in an empty region");
        }
        this.current = index;
        int access$parentAnchor = index < this.groupsSize ? SlotTableKt.access$parentAnchor(this.groups, index) : -1;
        this.parent = access$parentAnchor;
        if (access$parentAnchor < 0) {
            this.end = this.groupsSize;
        } else {
            this.end = access$parentAnchor + SlotTableKt.access$groupSize(this.groups, access$parentAnchor);
        }
        this.currentSlot = 0;
        this.currentSlotEnd = 0;
    }

    public final void restoreParent(int index) {
        int access$groupSize = SlotTableKt.access$groupSize(this.groups, index) + index;
        int i5 = this.current;
        if (!(i5 >= index && i5 <= access$groupSize)) {
            ComposerKt.composeImmediateRuntimeError("Index " + index + " is not a parent of " + i5);
        }
        this.parent = index;
        this.end = access$groupSize;
        this.currentSlot = 0;
        this.currentSlotEnd = 0;
    }

    public final int skipGroup() {
        if (!(this.emptyCount == 0)) {
            ComposerKt.composeImmediateRuntimeError("Cannot skip while in an empty region");
        }
        int access$nodeCount = SlotTableKt.access$isNode(this.groups, this.current) ? 1 : SlotTableKt.access$nodeCount(this.groups, this.current);
        int i5 = this.current;
        this.current = i5 + SlotTableKt.access$groupSize(this.groups, i5);
        return access$nodeCount;
    }

    public final void skipToGroupEnd() {
        if (!(this.emptyCount == 0)) {
            ComposerKt.composeImmediateRuntimeError("Cannot skip the enclosing group while in an empty region");
        }
        this.current = this.end;
        this.currentSlot = 0;
        this.currentSlotEnd = 0;
    }

    public final void startGroup() {
        if (this.emptyCount <= 0) {
            int i5 = this.parent;
            int i6 = this.current;
            if (!(SlotTableKt.access$parentAnchor(this.groups, i6) == i5)) {
                PreconditionsKt.throwIllegalArgumentException("Invalid slot table detected");
            }
            HashMap<Anchor, GroupSourceInformation> hashMap = this.sourceInformationMap;
            if (hashMap != null) {
                hashMap.get(anchor(i5));
            }
            IntStack intStack = this.currentSlotStack;
            int i7 = this.currentSlot;
            int i8 = this.currentSlotEnd;
            if (i7 == 0 && i8 == 0) {
                intStack.push(-1);
            } else {
                intStack.push(i7);
            }
            this.parent = i6;
            this.end = SlotTableKt.access$groupSize(this.groups, i6) + i6;
            int i9 = i6 + 1;
            this.current = i9;
            this.currentSlot = SlotTableKt.access$slotAnchor(this.groups, i6);
            this.currentSlotEnd = i6 >= this.groupsSize - 1 ? this.slotsSize : SlotTableKt.access$dataAnchor(this.groups, i9);
        }
    }

    public final void startNode() {
        if (this.emptyCount <= 0) {
            if (!SlotTableKt.access$isNode(this.groups, this.current)) {
                PreconditionsKt.throwIllegalArgumentException("Expected a node group");
            }
            startGroup();
        }
    }

    public String toString() {
        return "SlotReader(current=" + this.current + ", key=" + getGroupKey() + ", parent=" + this.parent + ", end=" + this.end + ')';
    }

    private final Object node(int[] iArr, int i5) {
        if (SlotTableKt.access$isNode(iArr, i5)) {
            return this.slots[SlotTableKt.access$nodeIndex(iArr, i5)];
        }
        return Composer.INSTANCE.getEmpty();
    }

    public final Object groupGet(int group, int index) {
        int access$slotAnchor = SlotTableKt.access$slotAnchor(this.groups, group);
        int i5 = group + 1;
        int i6 = access$slotAnchor + index;
        return i6 < (i5 < this.groupsSize ? SlotTableKt.access$dataAnchor(this.groups, i5) : this.slotsSize) ? this.slots[i6] : Composer.INSTANCE.getEmpty();
    }

    public final boolean isNode(int index) {
        return SlotTableKt.access$isNode(this.groups, index);
    }
}
