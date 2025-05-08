package androidx.compose.runtime;

import androidx.collection.MutableIntObjectMap;
import androidx.collection.MutableIntSet;
import androidx.compose.runtime.tooling.CompositionData;
import androidx.compose.runtime.tooling.CompositionGroup;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010(\n\u0002\b%\b\u0000\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0019\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\nJ\r\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\r\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0011\u0010\nJ\u0015\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\b¢\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0011\u001a\u00020\b¢\u0006\u0004\b\u0015\u0010\u0016J\u001d\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\b¢\u0006\u0004\b\u0018\u0010\u0019J?\u0010\"\u001a\u00020\u001f2\u0006\u0010\u001a\u001a\u00020\u000b2&\u0010\u001e\u001a\"\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001bj\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u001c\u0018\u0001`\u001dH\u0000¢\u0006\u0004\b \u0010!J\u008f\u0001\u0010\"\u001a\u00020\u001f2\u0006\u0010#\u001a\u00020\u000e2\u0006\u0010%\u001a\u00020$2\u0006\u0010&\u001a\u00020\u00062\u000e\u0010)\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010(0'2\u0006\u0010*\u001a\u00020\u00062\u0016\u0010-\u001a\u0012\u0012\u0004\u0012\u00020\b0+j\b\u0012\u0004\u0012\u00020\b`,2&\u0010\u001e\u001a\"\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001bj\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u001c\u0018\u0001`\u001d2\u000e\u00100\u001a\n\u0012\u0004\u0012\u00020/\u0018\u00010.H\u0000¢\u0006\u0004\b \u00101J\u0087\u0001\u00104\u001a\u00020\u001f2\u0006\u0010%\u001a\u00020$2\u0006\u0010&\u001a\u00020\u00062\u000e\u0010)\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010(0'2\u0006\u0010*\u001a\u00020\u00062\u0016\u0010-\u001a\u0012\u0012\u0004\u0012\u00020\b0+j\b\u0012\u0004\u0012\u00020\b`,2&\u0010\u001e\u001a\"\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001bj\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u001c\u0018\u0001`\u001d2\u000e\u00100\u001a\n\u0012\u0004\u0012\u00020/\u0018\u00010.H\u0000¢\u0006\u0004\b2\u00103J\r\u00105\u001a\u00020\u0014¢\u0006\u0004\b5\u00106J\u0017\u00108\u001a\u0004\u0018\u00010\u001c2\u0006\u00107\u001a\u00020\u0006¢\u0006\u0004\b8\u00109J\r\u0010:\u001a\u00020\u001f¢\u0006\u0004\b:\u0010\u0005J\r\u0010;\u001a\u00020\u001f¢\u0006\u0004\b;\u0010\u0005J\u0016\u0010=\u001a\b\u0012\u0004\u0012\u00020\u00030<H\u0096\u0002¢\u0006\u0004\b=\u0010>R$\u0010%\u001a\u00020$2\u0006\u0010?\u001a\u00020$8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b%\u0010@\u001a\u0004\bA\u0010BR$\u0010&\u001a\u00020\u00062\u0006\u0010?\u001a\u00020\u00068\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b&\u0010C\u001a\u0004\bD\u0010ER4\u0010)\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010(0'2\u000e\u0010?\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010(0'8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b)\u0010F\u001a\u0004\bG\u0010HR$\u0010*\u001a\u00020\u00062\u0006\u0010?\u001a\u00020\u00068\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b*\u0010C\u001a\u0004\bI\u0010ER\u0016\u0010J\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bJ\u0010CR$\u0010#\u001a\u00020\u00142\u0006\u0010?\u001a\u00020\u00148\u0000@BX\u0080\u000e¢\u0006\f\n\u0004\b#\u0010K\u001a\u0004\bL\u00106R\"\u0010M\u001a\u00020\u00068\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bM\u0010C\u001a\u0004\bN\u0010E\"\u0004\bO\u0010PR2\u0010-\u001a\u0012\u0012\u0004\u0012\u00020\b0+j\b\u0012\u0004\u0012\u00020\b`,8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b-\u0010Q\u001a\u0004\bR\u0010S\"\u0004\bT\u0010URB\u0010\u001e\u001a\"\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001bj\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u001c\u0018\u0001`\u001d8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010V\u001a\u0004\bW\u0010X\"\u0004\bY\u0010ZR*\u00100\u001a\n\u0012\u0004\u0012\u00020/\u0018\u00010.8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b0\u0010[\u001a\u0004\b\\\u0010]\"\u0004\b^\u0010_R\u0014\u0010`\u001a\u00020\u00148VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b`\u00106¨\u0006a"}, d2 = {"Landroidx/compose/runtime/SlotTable;", "Landroidx/compose/runtime/tooling/CompositionData;", BuildConfig.FLAVOR, "Landroidx/compose/runtime/tooling/CompositionGroup;", "<init>", "()V", BuildConfig.FLAVOR, "index", "Landroidx/compose/runtime/Anchor;", "tryAnchor", "(I)Landroidx/compose/runtime/Anchor;", "Landroidx/compose/runtime/SlotReader;", "openReader", "()Landroidx/compose/runtime/SlotReader;", "Landroidx/compose/runtime/SlotWriter;", "openWriter", "()Landroidx/compose/runtime/SlotWriter;", "anchor", "anchorIndex", "(Landroidx/compose/runtime/Anchor;)I", BuildConfig.FLAVOR, "ownsAnchor", "(Landroidx/compose/runtime/Anchor;)Z", "groupIndex", "groupContainsAnchor", "(ILandroidx/compose/runtime/Anchor;)Z", "reader", "Ljava/util/HashMap;", "Landroidx/compose/runtime/GroupSourceInformation;", "Lkotlin/collections/HashMap;", "sourceInformationMap", BuildConfig.FLAVOR, "close$runtime_release", "(Landroidx/compose/runtime/SlotReader;Ljava/util/HashMap;)V", "close", "writer", BuildConfig.FLAVOR, "groups", "groupsSize", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "slots", "slotsSize", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "anchors", "Landroidx/collection/MutableIntObjectMap;", "Landroidx/collection/MutableIntSet;", "calledByMap", "(Landroidx/compose/runtime/SlotWriter;[II[Ljava/lang/Object;ILjava/util/ArrayList;Ljava/util/HashMap;Landroidx/collection/MutableIntObjectMap;)V", "setTo$runtime_release", "([II[Ljava/lang/Object;ILjava/util/ArrayList;Ljava/util/HashMap;Landroidx/collection/MutableIntObjectMap;)V", "setTo", "containsMark", "()Z", "group", "sourceInformationOf", "(I)Landroidx/compose/runtime/GroupSourceInformation;", "collectCalledByInformation", "collectSourceInformation", BuildConfig.FLAVOR, "iterator", "()Ljava/util/Iterator;", "<set-?>", "[I", "getGroups", "()[I", "I", "getGroupsSize", "()I", "[Ljava/lang/Object;", "getSlots", "()[Ljava/lang/Object;", "getSlotsSize", "readers", "Z", "getWriter$runtime_release", "version", "getVersion$runtime_release", "setVersion$runtime_release", "(I)V", "Ljava/util/ArrayList;", "getAnchors$runtime_release", "()Ljava/util/ArrayList;", "setAnchors$runtime_release", "(Ljava/util/ArrayList;)V", "Ljava/util/HashMap;", "getSourceInformationMap$runtime_release", "()Ljava/util/HashMap;", "setSourceInformationMap$runtime_release", "(Ljava/util/HashMap;)V", "Landroidx/collection/MutableIntObjectMap;", "getCalledByMap$runtime_release", "()Landroidx/collection/MutableIntObjectMap;", "setCalledByMap$runtime_release", "(Landroidx/collection/MutableIntObjectMap;)V", "isEmpty", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SlotTable implements CompositionData, Iterable<CompositionGroup>, KMappedMarker {
    private MutableIntObjectMap<MutableIntSet> calledByMap;
    private int groupsSize;
    private int readers;
    private int slotsSize;
    private HashMap<Anchor, GroupSourceInformation> sourceInformationMap;
    private int version;
    private boolean writer;
    private int[] groups = new int[0];
    private Object[] slots = new Object[0];
    private ArrayList<Anchor> anchors = new ArrayList<>();

    private final Anchor tryAnchor(int index) {
        int i5;
        if (this.writer) {
            ComposerKt.composeImmediateRuntimeError("use active SlotWriter to crate an anchor for location instead");
        }
        if (index < 0 || index >= (i5 = this.groupsSize)) {
            return null;
        }
        return SlotTableKt.access$find(this.anchors, index, i5);
    }

    public final Anchor anchor(int index) {
        if (this.writer) {
            ComposerKt.composeImmediateRuntimeError("use active SlotWriter to create an anchor location instead");
        }
        boolean z5 = false;
        if (index >= 0 && index < this.groupsSize) {
            z5 = true;
        }
        if (!z5) {
            PreconditionsKt.throwIllegalArgumentException("Parameter index is out of range");
        }
        ArrayList<Anchor> arrayList = this.anchors;
        int access$search = SlotTableKt.access$search(arrayList, index, this.groupsSize);
        if (access$search >= 0) {
            return arrayList.get(access$search);
        }
        Anchor anchor = new Anchor(index);
        arrayList.add(-(access$search + 1), anchor);
        return anchor;
    }

    public final int anchorIndex(Anchor anchor) {
        if (this.writer) {
            ComposerKt.composeImmediateRuntimeError("Use active SlotWriter to determine anchor location instead");
        }
        if (!anchor.getValid()) {
            PreconditionsKt.throwIllegalArgumentException("Anchor refers to a group that was removed");
        }
        return anchor.getLocation();
    }

    public final void close$runtime_release(SlotReader reader, HashMap<Anchor, GroupSourceInformation> sourceInformationMap) {
        if (!(reader.getTable() == this && this.readers > 0)) {
            ComposerKt.composeImmediateRuntimeError("Unexpected reader close()");
        }
        this.readers--;
        if (sourceInformationMap != null) {
            synchronized (this) {
                try {
                    HashMap<Anchor, GroupSourceInformation> hashMap = this.sourceInformationMap;
                    if (hashMap != null) {
                        hashMap.putAll(sourceInformationMap);
                    } else {
                        this.sourceInformationMap = sourceInformationMap;
                    }
                    Unit unit = Unit.INSTANCE;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public final void collectCalledByInformation() {
        this.calledByMap = new MutableIntObjectMap<>(0, 1, null);
    }

    public final void collectSourceInformation() {
        this.sourceInformationMap = new HashMap<>();
    }

    public final boolean containsMark() {
        return this.groupsSize > 0 && SlotTableKt.access$containsMark(this.groups, 0);
    }

    public final ArrayList<Anchor> getAnchors$runtime_release() {
        return this.anchors;
    }

    public final MutableIntObjectMap<MutableIntSet> getCalledByMap$runtime_release() {
        return this.calledByMap;
    }

    public final int[] getGroups() {
        return this.groups;
    }

    public final int getGroupsSize() {
        return this.groupsSize;
    }

    public final Object[] getSlots() {
        return this.slots;
    }

    public final int getSlotsSize() {
        return this.slotsSize;
    }

    public final HashMap<Anchor, GroupSourceInformation> getSourceInformationMap$runtime_release() {
        return this.sourceInformationMap;
    }

    /* renamed from: getVersion$runtime_release, reason: from getter */
    public final int getVersion() {
        return this.version;
    }

    /* renamed from: getWriter$runtime_release, reason: from getter */
    public final boolean getWriter() {
        return this.writer;
    }

    public final boolean groupContainsAnchor(int groupIndex, Anchor anchor) {
        if (this.writer) {
            ComposerKt.composeImmediateRuntimeError("Writer is active");
        }
        if (!(groupIndex >= 0 && groupIndex < this.groupsSize)) {
            ComposerKt.composeImmediateRuntimeError("Invalid group index");
        }
        if (ownsAnchor(anchor)) {
            int access$groupSize = SlotTableKt.access$groupSize(this.groups, groupIndex) + groupIndex;
            int location = anchor.getLocation();
            if (groupIndex <= location && location < access$groupSize) {
                return true;
            }
        }
        return false;
    }

    public boolean isEmpty() {
        return this.groupsSize == 0;
    }

    @Override // java.lang.Iterable
    public Iterator<CompositionGroup> iterator() {
        return new GroupIterator(this, 0, this.groupsSize);
    }

    public final SlotReader openReader() {
        if (this.writer) {
            throw new IllegalStateException("Cannot read while a writer is pending");
        }
        this.readers++;
        return new SlotReader(this);
    }

    public final SlotWriter openWriter() {
        if (this.writer) {
            ComposerKt.composeImmediateRuntimeError("Cannot start a writer when another writer is pending");
        }
        if (!(this.readers <= 0)) {
            ComposerKt.composeImmediateRuntimeError("Cannot start a writer when a reader is pending");
        }
        this.writer = true;
        this.version++;
        return new SlotWriter(this);
    }

    public final boolean ownsAnchor(Anchor anchor) {
        int access$search;
        return anchor.getValid() && (access$search = SlotTableKt.access$search(this.anchors, anchor.getLocation(), this.groupsSize)) >= 0 && Intrinsics.areEqual(this.anchors.get(access$search), anchor);
    }

    public final void setTo$runtime_release(int[] groups, int groupsSize, Object[] slots, int slotsSize, ArrayList<Anchor> anchors, HashMap<Anchor, GroupSourceInformation> sourceInformationMap, MutableIntObjectMap<MutableIntSet> calledByMap) {
        this.groups = groups;
        this.groupsSize = groupsSize;
        this.slots = slots;
        this.slotsSize = slotsSize;
        this.anchors = anchors;
        this.sourceInformationMap = sourceInformationMap;
        this.calledByMap = calledByMap;
    }

    public final GroupSourceInformation sourceInformationOf(int group) {
        Anchor tryAnchor;
        HashMap<Anchor, GroupSourceInformation> hashMap = this.sourceInformationMap;
        if (hashMap == null || (tryAnchor = tryAnchor(group)) == null) {
            return null;
        }
        return hashMap.get(tryAnchor);
    }

    public final void close$runtime_release(SlotWriter writer, int[] groups, int groupsSize, Object[] slots, int slotsSize, ArrayList<Anchor> anchors, HashMap<Anchor, GroupSourceInformation> sourceInformationMap, MutableIntObjectMap<MutableIntSet> calledByMap) {
        if (!(writer.getTable() == this && this.writer)) {
            PreconditionsKt.throwIllegalArgumentException("Unexpected writer close()");
        }
        this.writer = false;
        setTo$runtime_release(groups, groupsSize, slots, slotsSize, anchors, sourceInformationMap, calledByMap);
    }
}
