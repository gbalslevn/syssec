package androidx.compose.runtime.changelist;

import androidx.compose.runtime.Anchor;
import androidx.compose.runtime.ComposerImpl;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.Composition;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.IntStack;
import androidx.compose.runtime.MovableContentState;
import androidx.compose.runtime.MovableContentStateReference;
import androidx.compose.runtime.RememberObserver;
import androidx.compose.runtime.SlotReader;
import androidx.compose.runtime.SlotTable;
import androidx.compose.runtime.Stack;
import androidx.compose.runtime.internal.IntRef;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000¦\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u0000 \u0091\u00012\u00020\u0001:\u0002\u0091\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\nJ\u0019\u0010\u000e\u001a\u00020\b2\b\b\u0002\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0010\u0010\nJ\u0017\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0019\u0010\u0016\u001a\u00020\b2\b\b\u0002\u0010\u0015\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0016\u0010\u000fJ\u000f\u0010\u0017\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0017\u0010\nJ\u001f\u0010\u001b\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u0018H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ'\u0010 \u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\u00182\u0006\u0010\u001f\u001a\u00020\u0018H\u0002¢\u0006\u0004\b \u0010!J\u000f\u0010\"\u001a\u00020\bH\u0002¢\u0006\u0004\b\"\u0010\nJ\u0015\u0010$\u001a\u00020\b2\u0006\u0010#\u001a\u00020\u0018¢\u0006\u0004\b$\u0010%J\u0015\u0010&\u001a\u00020\b2\u0006\u0010#\u001a\u00020\u0018¢\u0006\u0004\b&\u0010%J\r\u0010'\u001a\u00020\b¢\u0006\u0004\b'\u0010\nJ\u0015\u0010*\u001a\u00020\b2\u0006\u0010)\u001a\u00020(¢\u0006\u0004\b*\u0010+J\u001f\u0010-\u001a\u00020\b2\b\u0010)\u001a\u0004\u0018\u00010\u00012\u0006\u0010,\u001a\u00020\u0018¢\u0006\u0004\b-\u0010.J'\u0010/\u001a\u00020\b2\b\u0010)\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010,\u001a\u00020\u0018¢\u0006\u0004\b/\u00100J\u001f\u00101\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010)\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b1\u00102J\u0015\u00103\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\u0018¢\u0006\u0004\b3\u0010%J\r\u00104\u001a\u00020\b¢\u0006\u0004\b4\u0010\nJ\u0017\u00106\u001a\u00020\b2\b\u00105\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b6\u00107J\r\u00108\u001a\u00020\b¢\u0006\u0004\b8\u0010\nJ\r\u00109\u001a\u00020\b¢\u0006\u0004\b9\u0010\nJ\r\u0010:\u001a\u00020\b¢\u0006\u0004\b:\u0010\nJ\r\u0010;\u001a\u00020\b¢\u0006\u0004\b;\u0010\nJ\u001d\u0010=\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020<¢\u0006\u0004\b=\u0010>J%\u0010=\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020<2\u0006\u0010@\u001a\u00020?¢\u0006\u0004\b=\u0010AJ\u0015\u0010C\u001a\u00020\b2\u0006\u0010B\u001a\u00020\u0018¢\u0006\u0004\bC\u0010%J)\u0010H\u001a\u00020\b2\u0012\u0010F\u001a\u000e\u0012\u0004\u0012\u00020E\u0012\u0004\u0012\u00020\b0D2\u0006\u0010G\u001a\u00020E¢\u0006\u0004\bH\u0010IJ\u0017\u0010K\u001a\u00020\b2\b\u0010J\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\bK\u00107J;\u0010P\u001a\u00020\b\"\u0004\b\u0000\u0010L\"\u0004\b\u0001\u0010M2\u0006\u0010)\u001a\u00028\u00012\u0018\u0010O\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\b0N¢\u0006\u0004\bP\u0010QJ\u001d\u0010S\u001a\u00020\b2\u0006\u0010R\u001a\u00020\u00182\u0006\u0010\u001f\u001a\u00020\u0018¢\u0006\u0004\bS\u0010\u001cJ%\u0010T\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u001f\u001a\u00020\u0018¢\u0006\u0004\bT\u0010!J\r\u0010U\u001a\u00020\b¢\u0006\u0004\bU\u0010\nJ\r\u0010V\u001a\u00020\b¢\u0006\u0004\bV\u0010\nJ\r\u0010W\u001a\u00020\b¢\u0006\u0004\bW\u0010\nJ\u0017\u0010X\u001a\u00020\b2\b\u0010J\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\bX\u00107J\u001b\u0010[\u001a\u00020\b2\f\u0010Z\u001a\b\u0012\u0004\u0012\u00020\b0Y¢\u0006\u0004\b[\u0010\\J\u001d\u0010_\u001a\u00020\b2\u0006\u0010^\u001a\u00020]2\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b_\u0010`J%\u0010d\u001a\u00020\b2\u000e\u0010b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010a2\u0006\u0010c\u001a\u00020]¢\u0006\u0004\bd\u0010eJ/\u0010k\u001a\u00020\b2\b\u0010g\u001a\u0004\u0018\u00010f2\u0006\u0010i\u001a\u00020h2\u0006\u0010\u001e\u001a\u00020j2\u0006\u0010\u001d\u001a\u00020j¢\u0006\u0004\bk\u0010lJ\r\u0010m\u001a\u00020\b¢\u0006\u0004\bm\u0010\nJ!\u0010o\u001a\u00020\b2\u0006\u0010n\u001a\u00020\u00042\n\b\u0002\u0010c\u001a\u0004\u0018\u00010]¢\u0006\u0004\bo\u0010pJ\r\u0010q\u001a\u00020\b¢\u0006\u0004\bq\u0010\nJ\r\u0010r\u001a\u00020\b¢\u0006\u0004\br\u0010\nJ\r\u0010s\u001a\u00020\b¢\u0006\u0004\bs\u0010\nR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010tR\"\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010u\u001a\u0004\bv\u0010w\"\u0004\bx\u0010yR\u0016\u0010z\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bz\u0010{R\u0014\u0010}\u001a\u00020|8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b}\u0010~R%\u0010\u007f\u001a\u00020\f8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0004\b\u007f\u0010{\u001a\u0006\b\u0080\u0001\u0010\u0081\u0001\"\u0005\b\u0082\u0001\u0010\u000fR\u0019\u0010\u0083\u0001\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0083\u0001\u0010\u0084\u0001R\u0019\u0010\u0085\u0001\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0085\u0001\u0010\u0084\u0001R\"\u0010\u0087\u0001\u001a\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0086\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0087\u0001\u0010\u0088\u0001R\u0017\u0010\u0019\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0019\u0010\u0084\u0001R\u0019\u0010\u0089\u0001\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0089\u0001\u0010\u0084\u0001R\u0019\u0010\u008a\u0001\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008a\u0001\u0010\u0084\u0001R\u0017\u0010\u001a\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u001a\u0010\u0084\u0001R\u0018\u0010\u008e\u0001\u001a\u00030\u008b\u00018BX\u0082\u0004¢\u0006\b\u001a\u0006\b\u008c\u0001\u0010\u008d\u0001R\u0014\u0010\u0090\u0001\u001a\u00020\f8F¢\u0006\b\u001a\u0006\b\u008f\u0001\u0010\u0081\u0001¨\u0006\u0092\u0001"}, d2 = {"Landroidx/compose/runtime/changelist/ComposerChangeListWriter;", BuildConfig.FLAVOR, "Landroidx/compose/runtime/ComposerImpl;", "composer", "Landroidx/compose/runtime/changelist/ChangeList;", "changeList", "<init>", "(Landroidx/compose/runtime/ComposerImpl;Landroidx/compose/runtime/changelist/ChangeList;)V", BuildConfig.FLAVOR, "pushApplierOperationPreamble", "()V", "pushSlotEditingOperationPreamble", BuildConfig.FLAVOR, "useParentSlot", "pushSlotTableOperationPreamble", "(Z)V", "ensureRootStarted", "Landroidx/compose/runtime/Anchor;", "anchor", "ensureGroupStarted", "(Landroidx/compose/runtime/Anchor;)V", "forParent", "realizeOperationLocation", "realizeNodeMovementOperations", BuildConfig.FLAVOR, "removeFrom", "moveCount", "realizeRemoveNode", "(II)V", "to", "from", "count", "realizeMoveNode", "(III)V", "pushPendingUpsAndDowns", "location", "moveReaderRelativeTo", "(I)V", "moveReaderToAbsolute", "recordSlotEditing", "Landroidx/compose/runtime/RememberObserver;", "value", "remember", "(Landroidx/compose/runtime/RememberObserver;)V", "groupSlotIndex", "updateValue", "(Ljava/lang/Object;I)V", "updateAnchoredValue", "(Ljava/lang/Object;Landroidx/compose/runtime/Anchor;I)V", "appendValue", "(Landroidx/compose/runtime/Anchor;Ljava/lang/Object;)V", "trimValues", "resetSlots", "data", "updateAuxData", "(Ljava/lang/Object;)V", "endRoot", "endCurrentGroup", "skipToEndOfCurrentGroup", "removeCurrentGroup", "Landroidx/compose/runtime/SlotTable;", "insertSlots", "(Landroidx/compose/runtime/Anchor;Landroidx/compose/runtime/SlotTable;)V", "Landroidx/compose/runtime/changelist/FixupList;", "fixups", "(Landroidx/compose/runtime/Anchor;Landroidx/compose/runtime/SlotTable;Landroidx/compose/runtime/changelist/FixupList;)V", "offset", "moveCurrentGroup", "Lkotlin/Function1;", "Landroidx/compose/runtime/Composition;", "action", "composition", "endCompositionScope", "(Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composition;)V", "node", "useNode", "T", "V", "Lkotlin/Function2;", "block", "updateNode", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", "nodeIndex", "removeNode", "moveNode", "releaseMovableContent", "endNodeMovement", "moveUp", "moveDown", "Lkotlin/Function0;", "effect", "sideEffect", "(Lkotlin/jvm/functions/Function0;)V", "Landroidx/compose/runtime/internal/IntRef;", "effectiveNodeIndexOut", "determineMovableContentNodeIndex", "(Landroidx/compose/runtime/internal/IntRef;Landroidx/compose/runtime/Anchor;)V", BuildConfig.FLAVOR, "nodes", "effectiveNodeIndex", "copyNodesToNewAnchorLocation", "(Ljava/util/List;Landroidx/compose/runtime/internal/IntRef;)V", "Landroidx/compose/runtime/MovableContentState;", "resolvedState", "Landroidx/compose/runtime/CompositionContext;", "parentContext", "Landroidx/compose/runtime/MovableContentStateReference;", "copySlotTableToAnchorLocation", "(Landroidx/compose/runtime/MovableContentState;Landroidx/compose/runtime/CompositionContext;Landroidx/compose/runtime/MovableContentStateReference;Landroidx/compose/runtime/MovableContentStateReference;)V", "endMovableContentPlacement", "other", "includeOperationsIn", "(Landroidx/compose/runtime/changelist/ChangeList;Landroidx/compose/runtime/internal/IntRef;)V", "finalizeComposition", "resetTransientState", "deactivateCurrentGroup", "Landroidx/compose/runtime/ComposerImpl;", "Landroidx/compose/runtime/changelist/ChangeList;", "getChangeList", "()Landroidx/compose/runtime/changelist/ChangeList;", "setChangeList", "(Landroidx/compose/runtime/changelist/ChangeList;)V", "startedGroup", "Z", "Landroidx/compose/runtime/IntStack;", "startedGroups", "Landroidx/compose/runtime/IntStack;", "implicitRootStart", "getImplicitRootStart", "()Z", "setImplicitRootStart", "writersReaderDelta", "I", "pendingUps", "Landroidx/compose/runtime/Stack;", "pendingDownNodes", "Landroidx/compose/runtime/Stack;", "moveFrom", "moveTo", "Landroidx/compose/runtime/SlotReader;", "getReader", "()Landroidx/compose/runtime/SlotReader;", "reader", "getPastParent", "pastParent", "Companion", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ComposerChangeListWriter {
    private static final int invalidGroupLocation = -2;
    private ChangeList changeList;
    private final ComposerImpl composer;
    private int moveCount;
    private int pendingUps;
    private boolean startedGroup;
    private int writersReaderDelta;
    public static final int $stable = 8;
    private final IntStack startedGroups = new IntStack();
    private boolean implicitRootStart = true;
    private Stack<Object> pendingDownNodes = new Stack<>();
    private int removeFrom = -1;
    private int moveFrom = -1;
    private int moveTo = -1;

    public ComposerChangeListWriter(ComposerImpl composerImpl, ChangeList changeList) {
        this.composer = composerImpl;
        this.changeList = changeList;
    }

    private final void ensureGroupStarted(Anchor anchor) {
        pushSlotTableOperationPreamble$default(this, false, 1, null);
        this.changeList.pushEnsureGroupStarted(anchor);
        this.startedGroup = true;
    }

    private final void ensureRootStarted() {
        if (this.startedGroup || !this.implicitRootStart) {
            return;
        }
        pushSlotTableOperationPreamble$default(this, false, 1, null);
        this.changeList.pushEnsureRootStarted();
        this.startedGroup = true;
    }

    private final SlotReader getReader() {
        return this.composer.getReader();
    }

    private final void pushApplierOperationPreamble() {
        pushPendingUpsAndDowns();
    }

    private final void pushPendingUpsAndDowns() {
        int i5 = this.pendingUps;
        if (i5 > 0) {
            this.changeList.pushUps(i5);
            this.pendingUps = 0;
        }
        if (this.pendingDownNodes.isNotEmpty()) {
            this.changeList.pushDowns(this.pendingDownNodes.toArray());
            this.pendingDownNodes.clear();
        }
    }

    private final void pushSlotEditingOperationPreamble() {
        realizeOperationLocation$default(this, false, 1, null);
        recordSlotEditing();
    }

    private final void pushSlotTableOperationPreamble(boolean useParentSlot) {
        realizeOperationLocation(useParentSlot);
    }

    static /* synthetic */ void pushSlotTableOperationPreamble$default(ComposerChangeListWriter composerChangeListWriter, boolean z5, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            z5 = false;
        }
        composerChangeListWriter.pushSlotTableOperationPreamble(z5);
    }

    private final void realizeMoveNode(int to, int from, int count) {
        pushApplierOperationPreamble();
        this.changeList.pushMoveNode(to, from, count);
    }

    private final void realizeNodeMovementOperations() {
        int i5 = this.moveCount;
        if (i5 > 0) {
            int i6 = this.removeFrom;
            if (i6 >= 0) {
                realizeRemoveNode(i6, i5);
                this.removeFrom = -1;
            } else {
                realizeMoveNode(this.moveTo, this.moveFrom, i5);
                this.moveFrom = -1;
                this.moveTo = -1;
            }
            this.moveCount = 0;
        }
    }

    private final void realizeOperationLocation(boolean forParent) {
        int parent = forParent ? getReader().getParent() : getReader().getCurrent();
        int i5 = parent - this.writersReaderDelta;
        if (!(i5 >= 0)) {
            ComposerKt.composeImmediateRuntimeError("Tried to seek backward");
        }
        if (i5 > 0) {
            this.changeList.pushAdvanceSlotsBy(i5);
            this.writersReaderDelta = parent;
        }
    }

    static /* synthetic */ void realizeOperationLocation$default(ComposerChangeListWriter composerChangeListWriter, boolean z5, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            z5 = false;
        }
        composerChangeListWriter.realizeOperationLocation(z5);
    }

    private final void realizeRemoveNode(int removeFrom, int moveCount) {
        pushApplierOperationPreamble();
        this.changeList.pushRemoveNode(removeFrom, moveCount);
    }

    public final void appendValue(Anchor anchor, Object value) {
        this.changeList.pushAppendValue(anchor, value);
    }

    public final void copyNodesToNewAnchorLocation(List<? extends Object> nodes, IntRef effectiveNodeIndex) {
        this.changeList.pushCopyNodesToNewAnchorLocation(nodes, effectiveNodeIndex);
    }

    public final void copySlotTableToAnchorLocation(MovableContentState resolvedState, CompositionContext parentContext, MovableContentStateReference from, MovableContentStateReference to) {
        this.changeList.pushCopySlotTableToAnchorLocation(resolvedState, parentContext, from, to);
    }

    public final void deactivateCurrentGroup() {
        pushSlotTableOperationPreamble$default(this, false, 1, null);
        this.changeList.pushDeactivateCurrentGroup();
    }

    public final void determineMovableContentNodeIndex(IntRef effectiveNodeIndexOut, Anchor anchor) {
        pushPendingUpsAndDowns();
        this.changeList.pushDetermineMovableContentNodeIndex(effectiveNodeIndexOut, anchor);
    }

    public final void endCompositionScope(Function1<? super Composition, Unit> action, Composition composition) {
        this.changeList.pushEndCompositionScope(action, composition);
    }

    public final void endCurrentGroup() {
        int parent = getReader().getParent();
        if (!(this.startedGroups.peekOr(-1) <= parent)) {
            ComposerKt.composeImmediateRuntimeError("Missed recording an endGroup");
        }
        if (this.startedGroups.peekOr(-1) == parent) {
            pushSlotTableOperationPreamble$default(this, false, 1, null);
            this.startedGroups.pop();
            this.changeList.pushEndCurrentGroup();
        }
    }

    public final void endMovableContentPlacement() {
        this.changeList.pushEndMovableContentPlacement();
        this.writersReaderDelta = 0;
    }

    public final void endNodeMovement() {
        realizeNodeMovementOperations();
    }

    public final void endRoot() {
        if (this.startedGroup) {
            pushSlotTableOperationPreamble$default(this, false, 1, null);
            pushSlotTableOperationPreamble$default(this, false, 1, null);
            this.changeList.pushEndCurrentGroup();
            this.startedGroup = false;
        }
    }

    public final void finalizeComposition() {
        pushPendingUpsAndDowns();
        if (this.startedGroups.isEmpty()) {
            return;
        }
        ComposerKt.composeImmediateRuntimeError("Missed recording an endGroup()");
    }

    public final ChangeList getChangeList() {
        return this.changeList;
    }

    public final boolean getImplicitRootStart() {
        return this.implicitRootStart;
    }

    public final boolean getPastParent() {
        return getReader().getParent() - this.writersReaderDelta < 0;
    }

    public final void includeOperationsIn(ChangeList other, IntRef effectiveNodeIndex) {
        this.changeList.pushExecuteOperationsIn(other, effectiveNodeIndex);
    }

    public final void insertSlots(Anchor anchor, SlotTable from) {
        pushPendingUpsAndDowns();
        pushSlotEditingOperationPreamble();
        realizeNodeMovementOperations();
        this.changeList.pushInsertSlots(anchor, from);
    }

    public final void moveCurrentGroup(int offset) {
        pushSlotEditingOperationPreamble();
        this.changeList.pushMoveCurrentGroup(offset);
    }

    public final void moveDown(Object node) {
        realizeNodeMovementOperations();
        this.pendingDownNodes.push(node);
    }

    public final void moveNode(int from, int to, int count) {
        if (count > 0) {
            int i5 = this.moveCount;
            if (i5 > 0 && this.moveFrom == from - i5 && this.moveTo == to - i5) {
                this.moveCount = i5 + count;
                return;
            }
            realizeNodeMovementOperations();
            this.moveFrom = from;
            this.moveTo = to;
            this.moveCount = count;
        }
    }

    public final void moveReaderRelativeTo(int location) {
        this.writersReaderDelta += location - getReader().getCurrent();
    }

    public final void moveReaderToAbsolute(int location) {
        this.writersReaderDelta = location;
    }

    public final void moveUp() {
        realizeNodeMovementOperations();
        if (this.pendingDownNodes.isNotEmpty()) {
            this.pendingDownNodes.pop();
        } else {
            this.pendingUps++;
        }
    }

    public final void recordSlotEditing() {
        SlotReader reader;
        int parent;
        if (getReader().getGroupsSize() <= 0 || this.startedGroups.peekOr(invalidGroupLocation) == (parent = (reader = getReader()).getParent())) {
            return;
        }
        ensureRootStarted();
        if (parent > 0) {
            Anchor anchor = reader.anchor(parent);
            this.startedGroups.push(parent);
            ensureGroupStarted(anchor);
        }
    }

    public final void releaseMovableContent() {
        pushPendingUpsAndDowns();
        if (this.startedGroup) {
            skipToEndOfCurrentGroup();
            endRoot();
        }
    }

    public final void remember(RememberObserver value) {
        this.changeList.pushRemember(value);
    }

    public final void removeCurrentGroup() {
        pushSlotEditingOperationPreamble();
        this.changeList.pushRemoveCurrentGroup();
        this.writersReaderDelta += getReader().getGroupSize();
    }

    public final void removeNode(int nodeIndex, int count) {
        if (count > 0) {
            if (!(nodeIndex >= 0)) {
                ComposerKt.composeImmediateRuntimeError("Invalid remove index " + nodeIndex);
            }
            if (this.removeFrom == nodeIndex) {
                this.moveCount += count;
                return;
            }
            realizeNodeMovementOperations();
            this.removeFrom = nodeIndex;
            this.moveCount = count;
        }
    }

    public final void resetSlots() {
        this.changeList.pushResetSlots();
    }

    public final void resetTransientState() {
        this.startedGroup = false;
        this.startedGroups.clear();
        this.writersReaderDelta = 0;
    }

    public final void setChangeList(ChangeList changeList) {
        this.changeList = changeList;
    }

    public final void setImplicitRootStart(boolean z5) {
        this.implicitRootStart = z5;
    }

    public final void sideEffect(Function0<Unit> effect) {
        this.changeList.pushSideEffect(effect);
    }

    public final void skipToEndOfCurrentGroup() {
        this.changeList.pushSkipToEndOfCurrentGroup();
    }

    public final void trimValues(int count) {
        if (count > 0) {
            pushSlotEditingOperationPreamble();
            this.changeList.pushTrimValues(count);
        }
    }

    public final void updateAnchoredValue(Object value, Anchor anchor, int groupSlotIndex) {
        this.changeList.pushUpdateAnchoredValue(value, anchor, groupSlotIndex);
    }

    public final void updateAuxData(Object data) {
        pushSlotTableOperationPreamble$default(this, false, 1, null);
        this.changeList.pushUpdateAuxData(data);
    }

    public final <T, V> void updateNode(V value, Function2<? super T, ? super V, Unit> block) {
        pushApplierOperationPreamble();
        this.changeList.pushUpdateNode(value, block);
    }

    public final void updateValue(Object value, int groupSlotIndex) {
        pushSlotTableOperationPreamble(true);
        this.changeList.pushUpdateValue(value, groupSlotIndex);
    }

    public final void useNode(Object node) {
        pushApplierOperationPreamble();
        this.changeList.pushUseNode(node);
    }

    public final void insertSlots(Anchor anchor, SlotTable from, FixupList fixups) {
        pushPendingUpsAndDowns();
        pushSlotEditingOperationPreamble();
        realizeNodeMovementOperations();
        this.changeList.pushInsertSlots(anchor, from, fixups);
    }
}
