package androidx.compose.runtime.changelist;

import androidx.compose.runtime.Anchor;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposeNodeLifecycleCallback;
import androidx.compose.runtime.Composition;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.MovableContentState;
import androidx.compose.runtime.MovableContentStateReference;
import androidx.compose.runtime.PreconditionsKt;
import androidx.compose.runtime.RememberManager;
import androidx.compose.runtime.RememberObserver;
import androidx.compose.runtime.SlotTable;
import androidx.compose.runtime.SlotWriter;
import androidx.compose.runtime.changelist.Operation;
import androidx.compose.runtime.changelist.Operations;
import androidx.compose.runtime.internal.IntRef;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000ª\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\u0007\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\u0006J\r\u0010\t\u001a\u00020\b¢\u0006\u0004\b\t\u0010\u0003J)\u0010\u0010\u001a\u00020\b2\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015J\u001f\u0010\u0019\u001a\u00020\b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u0019\u0010\u001aJ'\u0010\u001d\u001a\u00020\b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u001d\u0010\u001eJ\u001f\u0010\u001f\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u001b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0016¢\u0006\u0004\b\u001f\u0010 J\u0015\u0010\"\u001a\u00020\b2\u0006\u0010!\u001a\u00020\u0017¢\u0006\u0004\b\"\u0010#J\r\u0010$\u001a\u00020\b¢\u0006\u0004\b$\u0010\u0003J\r\u0010%\u001a\u00020\b¢\u0006\u0004\b%\u0010\u0003J\u0017\u0010'\u001a\u00020\b2\b\u0010&\u001a\u0004\u0018\u00010\u0016¢\u0006\u0004\b'\u0010(J\r\u0010)\u001a\u00020\b¢\u0006\u0004\b)\u0010\u0003J\u0015\u0010*\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b*\u0010+J\r\u0010,\u001a\u00020\b¢\u0006\u0004\b,\u0010\u0003J\r\u0010-\u001a\u00020\b¢\u0006\u0004\b-\u0010\u0003J\r\u0010.\u001a\u00020\b¢\u0006\u0004\b.\u0010\u0003J\u001d\u00101\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u00100\u001a\u00020/¢\u0006\u0004\b1\u00102J%\u00101\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u00100\u001a\u00020/2\u0006\u00104\u001a\u000203¢\u0006\u0004\b1\u00105J\u0015\u00107\u001a\u00020\b2\u0006\u00106\u001a\u00020\u0017¢\u0006\u0004\b7\u0010#J)\u0010<\u001a\u00020\b2\u0012\u0010:\u001a\u000e\u0012\u0004\u0012\u000209\u0012\u0004\u0012\u00020\b082\u0006\u0010;\u001a\u000209¢\u0006\u0004\b<\u0010=J\u0017\u0010?\u001a\u00020\b2\b\u0010>\u001a\u0004\u0018\u00010\u0016¢\u0006\u0004\b?\u0010(J;\u0010D\u001a\u00020\b\"\u0004\b\u0000\u0010@\"\u0004\b\u0001\u0010A2\u0006\u0010\u0013\u001a\u00028\u00012\u0018\u0010C\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00020\b0B¢\u0006\u0004\bD\u0010EJ\u001d\u0010H\u001a\u00020\b2\u0006\u0010F\u001a\u00020\u00172\u0006\u0010G\u001a\u00020\u0017¢\u0006\u0004\bH\u0010IJ%\u0010K\u001a\u00020\b2\u0006\u0010J\u001a\u00020\u00172\u0006\u00100\u001a\u00020\u00172\u0006\u0010!\u001a\u00020\u0017¢\u0006\u0004\bK\u0010LJ\u0015\u0010N\u001a\u00020\b2\u0006\u0010M\u001a\u00020\u0017¢\u0006\u0004\bN\u0010#J\u0015\u0010O\u001a\u00020\b2\u0006\u0010!\u001a\u00020\u0017¢\u0006\u0004\bO\u0010#J\u001d\u0010R\u001a\u00020\b2\u000e\u0010Q\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00160P¢\u0006\u0004\bR\u0010SJ\u001b\u0010V\u001a\u00020\b2\f\u0010U\u001a\b\u0012\u0004\u0012\u00020\b0T¢\u0006\u0004\bV\u0010WJ\u001d\u0010Z\u001a\u00020\b2\u0006\u0010Y\u001a\u00020X2\u0006\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\bZ\u0010[J%\u0010^\u001a\u00020\b2\u000e\u0010Q\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00160\\2\u0006\u0010]\u001a\u00020X¢\u0006\u0004\b^\u0010_J/\u0010e\u001a\u00020\b2\b\u0010a\u001a\u0004\u0018\u00010`2\u0006\u0010c\u001a\u00020b2\u0006\u00100\u001a\u00020d2\u0006\u0010J\u001a\u00020d¢\u0006\u0004\be\u0010fJ\r\u0010g\u001a\u00020\b¢\u0006\u0004\bg\u0010\u0003J!\u0010i\u001a\u00020\b2\u0006\u0010h\u001a\u00020\u00002\n\b\u0002\u0010]\u001a\u0004\u0018\u00010X¢\u0006\u0004\bi\u0010jR\u0014\u0010l\u001a\u00020k8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bl\u0010m¨\u0006n"}, d2 = {"Landroidx/compose/runtime/changelist/ChangeList;", "Landroidx/compose/runtime/changelist/OperationsDebugStringFormattable;", "<init>", "()V", BuildConfig.FLAVOR, "isEmpty", "()Z", "isNotEmpty", BuildConfig.FLAVOR, "clear", "Landroidx/compose/runtime/Applier;", "applier", "Landroidx/compose/runtime/SlotWriter;", "slots", "Landroidx/compose/runtime/RememberManager;", "rememberManager", "executeAndFlushAllPendingChanges", "(Landroidx/compose/runtime/Applier;Landroidx/compose/runtime/SlotWriter;Landroidx/compose/runtime/RememberManager;)V", "Landroidx/compose/runtime/RememberObserver;", "value", "pushRemember", "(Landroidx/compose/runtime/RememberObserver;)V", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "groupSlotIndex", "pushUpdateValue", "(Ljava/lang/Object;I)V", "Landroidx/compose/runtime/Anchor;", "anchor", "pushUpdateAnchoredValue", "(Ljava/lang/Object;Landroidx/compose/runtime/Anchor;I)V", "pushAppendValue", "(Landroidx/compose/runtime/Anchor;Ljava/lang/Object;)V", "count", "pushTrimValues", "(I)V", "pushResetSlots", "pushDeactivateCurrentGroup", "data", "pushUpdateAuxData", "(Ljava/lang/Object;)V", "pushEnsureRootStarted", "pushEnsureGroupStarted", "(Landroidx/compose/runtime/Anchor;)V", "pushEndCurrentGroup", "pushSkipToEndOfCurrentGroup", "pushRemoveCurrentGroup", "Landroidx/compose/runtime/SlotTable;", "from", "pushInsertSlots", "(Landroidx/compose/runtime/Anchor;Landroidx/compose/runtime/SlotTable;)V", "Landroidx/compose/runtime/changelist/FixupList;", "fixups", "(Landroidx/compose/runtime/Anchor;Landroidx/compose/runtime/SlotTable;Landroidx/compose/runtime/changelist/FixupList;)V", "offset", "pushMoveCurrentGroup", "Lkotlin/Function1;", "Landroidx/compose/runtime/Composition;", "action", "composition", "pushEndCompositionScope", "(Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composition;)V", "node", "pushUseNode", "T", "V", "Lkotlin/Function2;", "block", "pushUpdateNode", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", "removeFrom", "moveCount", "pushRemoveNode", "(II)V", "to", "pushMoveNode", "(III)V", "distance", "pushAdvanceSlotsBy", "pushUps", BuildConfig.FLAVOR, "nodes", "pushDowns", "([Ljava/lang/Object;)V", "Lkotlin/Function0;", "effect", "pushSideEffect", "(Lkotlin/jvm/functions/Function0;)V", "Landroidx/compose/runtime/internal/IntRef;", "effectiveNodeIndexOut", "pushDetermineMovableContentNodeIndex", "(Landroidx/compose/runtime/internal/IntRef;Landroidx/compose/runtime/Anchor;)V", BuildConfig.FLAVOR, "effectiveNodeIndex", "pushCopyNodesToNewAnchorLocation", "(Ljava/util/List;Landroidx/compose/runtime/internal/IntRef;)V", "Landroidx/compose/runtime/MovableContentState;", "resolvedState", "Landroidx/compose/runtime/CompositionContext;", "parentContext", "Landroidx/compose/runtime/MovableContentStateReference;", "pushCopySlotTableToAnchorLocation", "(Landroidx/compose/runtime/MovableContentState;Landroidx/compose/runtime/CompositionContext;Landroidx/compose/runtime/MovableContentStateReference;Landroidx/compose/runtime/MovableContentStateReference;)V", "pushEndMovableContentPlacement", "changeList", "pushExecuteOperationsIn", "(Landroidx/compose/runtime/changelist/ChangeList;Landroidx/compose/runtime/internal/IntRef;)V", "Landroidx/compose/runtime/changelist/Operations;", "operations", "Landroidx/compose/runtime/changelist/Operations;", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ChangeList extends OperationsDebugStringFormattable {
    private final Operations operations = new Operations();

    public final void clear() {
        this.operations.clear();
    }

    public final void executeAndFlushAllPendingChanges(Applier<?> applier, SlotWriter slots, RememberManager rememberManager) {
        this.operations.executeAndFlushAllPendingOperations(applier, slots, rememberManager);
    }

    public final boolean isEmpty() {
        return this.operations.isEmpty();
    }

    public final boolean isNotEmpty() {
        return this.operations.isNotEmpty();
    }

    public final void pushAdvanceSlotsBy(int distance) {
        Operations operations = this.operations;
        Operation.AdvanceSlotsBy advanceSlotsBy = Operation.AdvanceSlotsBy.INSTANCE;
        operations.pushOp(advanceSlotsBy);
        Operations.WriteScope.m1242setIntA6tL2VI(Operations.WriteScope.m1240constructorimpl(operations), Operation.IntParameter.m1230constructorimpl(0), distance);
        if (Operations.access$getPushedIntMask$p(operations) == Operations.access$createExpectedArgMask(operations, advanceSlotsBy.getInts()) && Operations.access$getPushedObjectMask$p(operations) == Operations.access$createExpectedArgMask(operations, advanceSlotsBy.getObjects())) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        int ints = advanceSlotsBy.getInts();
        int i5 = 0;
        for (int i6 = 0; i6 < ints; i6++) {
            if (((1 << i6) & Operations.access$getPushedIntMask$p(operations)) != 0) {
                if (i5 > 0) {
                    sb.append(", ");
                }
                sb.append(advanceSlotsBy.mo1228intParamNamew8GmfQM(Operation.IntParameter.m1230constructorimpl(i6)));
                i5++;
            }
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
        StringBuilder sb3 = new StringBuilder();
        int objects = advanceSlotsBy.getObjects();
        int i7 = 0;
        for (int i8 = 0; i8 < objects; i8++) {
            if (((1 << i8) & Operations.access$getPushedObjectMask$p(operations)) != 0) {
                if (i5 > 0) {
                    sb3.append(", ");
                }
                sb3.append(advanceSlotsBy.mo1229objectParamName31yXWZQ(Operation.ObjectParameter.m1232constructorimpl(i8)));
                i7++;
            }
        }
        String sb4 = sb3.toString();
        Intrinsics.checkNotNullExpressionValue(sb4, "StringBuilder().apply(builderAction).toString()");
        PreconditionsKt.throwIllegalStateException("Error while pushing " + advanceSlotsBy + ". Not all arguments were provided. Missing " + i5 + " int arguments (" + sb2 + ") and " + i7 + " object arguments (" + sb4 + ").");
    }

    public final void pushAppendValue(Anchor anchor, Object value) {
        Operations operations = this.operations;
        Operation.AppendValue appendValue = Operation.AppendValue.INSTANCE;
        operations.pushOp(appendValue);
        Operations m1240constructorimpl = Operations.WriteScope.m1240constructorimpl(operations);
        Operations.WriteScope.m1243setObjectDKhxnng(m1240constructorimpl, Operation.ObjectParameter.m1232constructorimpl(0), anchor);
        Operations.WriteScope.m1243setObjectDKhxnng(m1240constructorimpl, Operation.ObjectParameter.m1232constructorimpl(1), value);
        if (Operations.access$getPushedIntMask$p(operations) == Operations.access$createExpectedArgMask(operations, appendValue.getInts()) && Operations.access$getPushedObjectMask$p(operations) == Operations.access$createExpectedArgMask(operations, appendValue.getObjects())) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        int ints = appendValue.getInts();
        int i5 = 0;
        for (int i6 = 0; i6 < ints; i6++) {
            if (((1 << i6) & Operations.access$getPushedIntMask$p(operations)) != 0) {
                if (i5 > 0) {
                    sb.append(", ");
                }
                sb.append(appendValue.mo1228intParamNamew8GmfQM(Operation.IntParameter.m1230constructorimpl(i6)));
                i5++;
            }
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
        StringBuilder sb3 = new StringBuilder();
        int objects = appendValue.getObjects();
        int i7 = 0;
        for (int i8 = 0; i8 < objects; i8++) {
            if (((1 << i8) & Operations.access$getPushedObjectMask$p(operations)) != 0) {
                if (i5 > 0) {
                    sb3.append(", ");
                }
                sb3.append(appendValue.mo1229objectParamName31yXWZQ(Operation.ObjectParameter.m1232constructorimpl(i8)));
                i7++;
            }
        }
        String sb4 = sb3.toString();
        Intrinsics.checkNotNullExpressionValue(sb4, "StringBuilder().apply(builderAction).toString()");
        PreconditionsKt.throwIllegalStateException("Error while pushing " + appendValue + ". Not all arguments were provided. Missing " + i5 + " int arguments (" + sb2 + ") and " + i7 + " object arguments (" + sb4 + ").");
    }

    public final void pushCopyNodesToNewAnchorLocation(List<? extends Object> nodes, IntRef effectiveNodeIndex) {
        if (nodes.isEmpty()) {
            return;
        }
        Operations operations = this.operations;
        Operation.CopyNodesToNewAnchorLocation copyNodesToNewAnchorLocation = Operation.CopyNodesToNewAnchorLocation.INSTANCE;
        operations.pushOp(copyNodesToNewAnchorLocation);
        Operations m1240constructorimpl = Operations.WriteScope.m1240constructorimpl(operations);
        Operations.WriteScope.m1243setObjectDKhxnng(m1240constructorimpl, Operation.ObjectParameter.m1232constructorimpl(1), nodes);
        Operations.WriteScope.m1243setObjectDKhxnng(m1240constructorimpl, Operation.ObjectParameter.m1232constructorimpl(0), effectiveNodeIndex);
        if (Operations.access$getPushedIntMask$p(operations) == Operations.access$createExpectedArgMask(operations, copyNodesToNewAnchorLocation.getInts()) && Operations.access$getPushedObjectMask$p(operations) == Operations.access$createExpectedArgMask(operations, copyNodesToNewAnchorLocation.getObjects())) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        int ints = copyNodesToNewAnchorLocation.getInts();
        int i5 = 0;
        for (int i6 = 0; i6 < ints; i6++) {
            if (((1 << i6) & Operations.access$getPushedIntMask$p(operations)) != 0) {
                if (i5 > 0) {
                    sb.append(", ");
                }
                sb.append(copyNodesToNewAnchorLocation.mo1228intParamNamew8GmfQM(Operation.IntParameter.m1230constructorimpl(i6)));
                i5++;
            }
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
        StringBuilder sb3 = new StringBuilder();
        int objects = copyNodesToNewAnchorLocation.getObjects();
        int i7 = 0;
        for (int i8 = 0; i8 < objects; i8++) {
            if (((1 << i8) & Operations.access$getPushedObjectMask$p(operations)) != 0) {
                if (i5 > 0) {
                    sb3.append(", ");
                }
                sb3.append(copyNodesToNewAnchorLocation.mo1229objectParamName31yXWZQ(Operation.ObjectParameter.m1232constructorimpl(i8)));
                i7++;
            }
        }
        String sb4 = sb3.toString();
        Intrinsics.checkNotNullExpressionValue(sb4, "StringBuilder().apply(builderAction).toString()");
        PreconditionsKt.throwIllegalStateException("Error while pushing " + copyNodesToNewAnchorLocation + ". Not all arguments were provided. Missing " + i5 + " int arguments (" + sb2 + ") and " + i7 + " object arguments (" + sb4 + ").");
    }

    public final void pushCopySlotTableToAnchorLocation(MovableContentState resolvedState, CompositionContext parentContext, MovableContentStateReference from, MovableContentStateReference to) {
        Operations operations = this.operations;
        Operation.CopySlotTableToAnchorLocation copySlotTableToAnchorLocation = Operation.CopySlotTableToAnchorLocation.INSTANCE;
        operations.pushOp(copySlotTableToAnchorLocation);
        Operations m1240constructorimpl = Operations.WriteScope.m1240constructorimpl(operations);
        Operations.WriteScope.m1243setObjectDKhxnng(m1240constructorimpl, Operation.ObjectParameter.m1232constructorimpl(0), resolvedState);
        Operations.WriteScope.m1243setObjectDKhxnng(m1240constructorimpl, Operation.ObjectParameter.m1232constructorimpl(1), parentContext);
        Operations.WriteScope.m1243setObjectDKhxnng(m1240constructorimpl, Operation.ObjectParameter.m1232constructorimpl(3), to);
        Operations.WriteScope.m1243setObjectDKhxnng(m1240constructorimpl, Operation.ObjectParameter.m1232constructorimpl(2), from);
        if (Operations.access$getPushedIntMask$p(operations) == Operations.access$createExpectedArgMask(operations, copySlotTableToAnchorLocation.getInts()) && Operations.access$getPushedObjectMask$p(operations) == Operations.access$createExpectedArgMask(operations, copySlotTableToAnchorLocation.getObjects())) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        int ints = copySlotTableToAnchorLocation.getInts();
        int i5 = 0;
        for (int i6 = 0; i6 < ints; i6++) {
            if (((1 << i6) & Operations.access$getPushedIntMask$p(operations)) != 0) {
                if (i5 > 0) {
                    sb.append(", ");
                }
                sb.append(copySlotTableToAnchorLocation.mo1228intParamNamew8GmfQM(Operation.IntParameter.m1230constructorimpl(i6)));
                i5++;
            }
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
        StringBuilder sb3 = new StringBuilder();
        int objects = copySlotTableToAnchorLocation.getObjects();
        int i7 = 0;
        for (int i8 = 0; i8 < objects; i8++) {
            if (((1 << i8) & Operations.access$getPushedObjectMask$p(operations)) != 0) {
                if (i5 > 0) {
                    sb3.append(", ");
                }
                sb3.append(copySlotTableToAnchorLocation.mo1229objectParamName31yXWZQ(Operation.ObjectParameter.m1232constructorimpl(i8)));
                i7++;
            }
        }
        String sb4 = sb3.toString();
        Intrinsics.checkNotNullExpressionValue(sb4, "StringBuilder().apply(builderAction).toString()");
        PreconditionsKt.throwIllegalStateException("Error while pushing " + copySlotTableToAnchorLocation + ". Not all arguments were provided. Missing " + i5 + " int arguments (" + sb2 + ") and " + i7 + " object arguments (" + sb4 + ").");
    }

    public final void pushDeactivateCurrentGroup() {
        this.operations.push(Operation.DeactivateCurrentGroup.INSTANCE);
    }

    public final void pushDetermineMovableContentNodeIndex(IntRef effectiveNodeIndexOut, Anchor anchor) {
        Operations operations = this.operations;
        Operation.DetermineMovableContentNodeIndex determineMovableContentNodeIndex = Operation.DetermineMovableContentNodeIndex.INSTANCE;
        operations.pushOp(determineMovableContentNodeIndex);
        Operations m1240constructorimpl = Operations.WriteScope.m1240constructorimpl(operations);
        Operations.WriteScope.m1243setObjectDKhxnng(m1240constructorimpl, Operation.ObjectParameter.m1232constructorimpl(0), effectiveNodeIndexOut);
        Operations.WriteScope.m1243setObjectDKhxnng(m1240constructorimpl, Operation.ObjectParameter.m1232constructorimpl(1), anchor);
        if (Operations.access$getPushedIntMask$p(operations) == Operations.access$createExpectedArgMask(operations, determineMovableContentNodeIndex.getInts()) && Operations.access$getPushedObjectMask$p(operations) == Operations.access$createExpectedArgMask(operations, determineMovableContentNodeIndex.getObjects())) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        int ints = determineMovableContentNodeIndex.getInts();
        int i5 = 0;
        for (int i6 = 0; i6 < ints; i6++) {
            if (((1 << i6) & Operations.access$getPushedIntMask$p(operations)) != 0) {
                if (i5 > 0) {
                    sb.append(", ");
                }
                sb.append(determineMovableContentNodeIndex.mo1228intParamNamew8GmfQM(Operation.IntParameter.m1230constructorimpl(i6)));
                i5++;
            }
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
        StringBuilder sb3 = new StringBuilder();
        int objects = determineMovableContentNodeIndex.getObjects();
        int i7 = 0;
        for (int i8 = 0; i8 < objects; i8++) {
            if (((1 << i8) & Operations.access$getPushedObjectMask$p(operations)) != 0) {
                if (i5 > 0) {
                    sb3.append(", ");
                }
                sb3.append(determineMovableContentNodeIndex.mo1229objectParamName31yXWZQ(Operation.ObjectParameter.m1232constructorimpl(i8)));
                i7++;
            }
        }
        String sb4 = sb3.toString();
        Intrinsics.checkNotNullExpressionValue(sb4, "StringBuilder().apply(builderAction).toString()");
        PreconditionsKt.throwIllegalStateException("Error while pushing " + determineMovableContentNodeIndex + ". Not all arguments were provided. Missing " + i5 + " int arguments (" + sb2 + ") and " + i7 + " object arguments (" + sb4 + ").");
    }

    public final void pushDowns(Object[] nodes) {
        if (nodes.length == 0) {
            return;
        }
        Operations operations = this.operations;
        Operation.Downs downs = Operation.Downs.INSTANCE;
        operations.pushOp(downs);
        Operations.WriteScope.m1243setObjectDKhxnng(Operations.WriteScope.m1240constructorimpl(operations), Operation.ObjectParameter.m1232constructorimpl(0), nodes);
        if (Operations.access$getPushedIntMask$p(operations) == Operations.access$createExpectedArgMask(operations, downs.getInts()) && Operations.access$getPushedObjectMask$p(operations) == Operations.access$createExpectedArgMask(operations, downs.getObjects())) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        int ints = downs.getInts();
        int i5 = 0;
        for (int i6 = 0; i6 < ints; i6++) {
            if (((1 << i6) & Operations.access$getPushedIntMask$p(operations)) != 0) {
                if (i5 > 0) {
                    sb.append(", ");
                }
                sb.append(downs.mo1228intParamNamew8GmfQM(Operation.IntParameter.m1230constructorimpl(i6)));
                i5++;
            }
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
        StringBuilder sb3 = new StringBuilder();
        int objects = downs.getObjects();
        int i7 = 0;
        for (int i8 = 0; i8 < objects; i8++) {
            if (((1 << i8) & Operations.access$getPushedObjectMask$p(operations)) != 0) {
                if (i5 > 0) {
                    sb3.append(", ");
                }
                sb3.append(downs.mo1229objectParamName31yXWZQ(Operation.ObjectParameter.m1232constructorimpl(i8)));
                i7++;
            }
        }
        String sb4 = sb3.toString();
        Intrinsics.checkNotNullExpressionValue(sb4, "StringBuilder().apply(builderAction).toString()");
        PreconditionsKt.throwIllegalStateException("Error while pushing " + downs + ". Not all arguments were provided. Missing " + i5 + " int arguments (" + sb2 + ") and " + i7 + " object arguments (" + sb4 + ").");
    }

    public final void pushEndCompositionScope(Function1<? super Composition, Unit> action, Composition composition) {
        Operations operations = this.operations;
        Operation.EndCompositionScope endCompositionScope = Operation.EndCompositionScope.INSTANCE;
        operations.pushOp(endCompositionScope);
        Operations m1240constructorimpl = Operations.WriteScope.m1240constructorimpl(operations);
        Operations.WriteScope.m1243setObjectDKhxnng(m1240constructorimpl, Operation.ObjectParameter.m1232constructorimpl(0), action);
        Operations.WriteScope.m1243setObjectDKhxnng(m1240constructorimpl, Operation.ObjectParameter.m1232constructorimpl(1), composition);
        if (Operations.access$getPushedIntMask$p(operations) == Operations.access$createExpectedArgMask(operations, endCompositionScope.getInts()) && Operations.access$getPushedObjectMask$p(operations) == Operations.access$createExpectedArgMask(operations, endCompositionScope.getObjects())) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        int ints = endCompositionScope.getInts();
        int i5 = 0;
        for (int i6 = 0; i6 < ints; i6++) {
            if (((1 << i6) & Operations.access$getPushedIntMask$p(operations)) != 0) {
                if (i5 > 0) {
                    sb.append(", ");
                }
                sb.append(endCompositionScope.mo1228intParamNamew8GmfQM(Operation.IntParameter.m1230constructorimpl(i6)));
                i5++;
            }
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
        StringBuilder sb3 = new StringBuilder();
        int objects = endCompositionScope.getObjects();
        int i7 = 0;
        for (int i8 = 0; i8 < objects; i8++) {
            if (((1 << i8) & Operations.access$getPushedObjectMask$p(operations)) != 0) {
                if (i5 > 0) {
                    sb3.append(", ");
                }
                sb3.append(endCompositionScope.mo1229objectParamName31yXWZQ(Operation.ObjectParameter.m1232constructorimpl(i8)));
                i7++;
            }
        }
        String sb4 = sb3.toString();
        Intrinsics.checkNotNullExpressionValue(sb4, "StringBuilder().apply(builderAction).toString()");
        PreconditionsKt.throwIllegalStateException("Error while pushing " + endCompositionScope + ". Not all arguments were provided. Missing " + i5 + " int arguments (" + sb2 + ") and " + i7 + " object arguments (" + sb4 + ").");
    }

    public final void pushEndCurrentGroup() {
        this.operations.push(Operation.EndCurrentGroup.INSTANCE);
    }

    public final void pushEndMovableContentPlacement() {
        this.operations.push(Operation.EndMovableContentPlacement.INSTANCE);
    }

    public final void pushEnsureGroupStarted(Anchor anchor) {
        Operations operations = this.operations;
        Operation.EnsureGroupStarted ensureGroupStarted = Operation.EnsureGroupStarted.INSTANCE;
        operations.pushOp(ensureGroupStarted);
        Operations.WriteScope.m1243setObjectDKhxnng(Operations.WriteScope.m1240constructorimpl(operations), Operation.ObjectParameter.m1232constructorimpl(0), anchor);
        if (Operations.access$getPushedIntMask$p(operations) == Operations.access$createExpectedArgMask(operations, ensureGroupStarted.getInts()) && Operations.access$getPushedObjectMask$p(operations) == Operations.access$createExpectedArgMask(operations, ensureGroupStarted.getObjects())) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        int ints = ensureGroupStarted.getInts();
        int i5 = 0;
        for (int i6 = 0; i6 < ints; i6++) {
            if (((1 << i6) & Operations.access$getPushedIntMask$p(operations)) != 0) {
                if (i5 > 0) {
                    sb.append(", ");
                }
                sb.append(ensureGroupStarted.mo1228intParamNamew8GmfQM(Operation.IntParameter.m1230constructorimpl(i6)));
                i5++;
            }
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
        StringBuilder sb3 = new StringBuilder();
        int objects = ensureGroupStarted.getObjects();
        int i7 = 0;
        for (int i8 = 0; i8 < objects; i8++) {
            if (((1 << i8) & Operations.access$getPushedObjectMask$p(operations)) != 0) {
                if (i5 > 0) {
                    sb3.append(", ");
                }
                sb3.append(ensureGroupStarted.mo1229objectParamName31yXWZQ(Operation.ObjectParameter.m1232constructorimpl(i8)));
                i7++;
            }
        }
        String sb4 = sb3.toString();
        Intrinsics.checkNotNullExpressionValue(sb4, "StringBuilder().apply(builderAction).toString()");
        PreconditionsKt.throwIllegalStateException("Error while pushing " + ensureGroupStarted + ". Not all arguments were provided. Missing " + i5 + " int arguments (" + sb2 + ") and " + i7 + " object arguments (" + sb4 + ").");
    }

    public final void pushEnsureRootStarted() {
        this.operations.push(Operation.EnsureRootGroupStarted.INSTANCE);
    }

    public final void pushExecuteOperationsIn(ChangeList changeList, IntRef effectiveNodeIndex) {
        if (changeList.isNotEmpty()) {
            Operations operations = this.operations;
            Operation.ApplyChangeList applyChangeList = Operation.ApplyChangeList.INSTANCE;
            operations.pushOp(applyChangeList);
            Operations m1240constructorimpl = Operations.WriteScope.m1240constructorimpl(operations);
            Operations.WriteScope.m1243setObjectDKhxnng(m1240constructorimpl, Operation.ObjectParameter.m1232constructorimpl(0), changeList);
            Operations.WriteScope.m1243setObjectDKhxnng(m1240constructorimpl, Operation.ObjectParameter.m1232constructorimpl(1), effectiveNodeIndex);
            if (Operations.access$getPushedIntMask$p(operations) == Operations.access$createExpectedArgMask(operations, applyChangeList.getInts()) && Operations.access$getPushedObjectMask$p(operations) == Operations.access$createExpectedArgMask(operations, applyChangeList.getObjects())) {
                return;
            }
            StringBuilder sb = new StringBuilder();
            int ints = applyChangeList.getInts();
            int i5 = 0;
            for (int i6 = 0; i6 < ints; i6++) {
                if (((1 << i6) & Operations.access$getPushedIntMask$p(operations)) != 0) {
                    if (i5 > 0) {
                        sb.append(", ");
                    }
                    sb.append(applyChangeList.mo1228intParamNamew8GmfQM(Operation.IntParameter.m1230constructorimpl(i6)));
                    i5++;
                }
            }
            String sb2 = sb.toString();
            Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
            StringBuilder sb3 = new StringBuilder();
            int objects = applyChangeList.getObjects();
            int i7 = 0;
            for (int i8 = 0; i8 < objects; i8++) {
                if (((1 << i8) & Operations.access$getPushedObjectMask$p(operations)) != 0) {
                    if (i5 > 0) {
                        sb3.append(", ");
                    }
                    sb3.append(applyChangeList.mo1229objectParamName31yXWZQ(Operation.ObjectParameter.m1232constructorimpl(i8)));
                    i7++;
                }
            }
            String sb4 = sb3.toString();
            Intrinsics.checkNotNullExpressionValue(sb4, "StringBuilder().apply(builderAction).toString()");
            PreconditionsKt.throwIllegalStateException("Error while pushing " + applyChangeList + ". Not all arguments were provided. Missing " + i5 + " int arguments (" + sb2 + ") and " + i7 + " object arguments (" + sb4 + ").");
        }
    }

    public final void pushInsertSlots(Anchor anchor, SlotTable from) {
        Operations operations = this.operations;
        Operation.InsertSlots insertSlots = Operation.InsertSlots.INSTANCE;
        operations.pushOp(insertSlots);
        Operations m1240constructorimpl = Operations.WriteScope.m1240constructorimpl(operations);
        Operations.WriteScope.m1243setObjectDKhxnng(m1240constructorimpl, Operation.ObjectParameter.m1232constructorimpl(0), anchor);
        Operations.WriteScope.m1243setObjectDKhxnng(m1240constructorimpl, Operation.ObjectParameter.m1232constructorimpl(1), from);
        if (Operations.access$getPushedIntMask$p(operations) == Operations.access$createExpectedArgMask(operations, insertSlots.getInts()) && Operations.access$getPushedObjectMask$p(operations) == Operations.access$createExpectedArgMask(operations, insertSlots.getObjects())) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        int ints = insertSlots.getInts();
        int i5 = 0;
        for (int i6 = 0; i6 < ints; i6++) {
            if (((1 << i6) & Operations.access$getPushedIntMask$p(operations)) != 0) {
                if (i5 > 0) {
                    sb.append(", ");
                }
                sb.append(insertSlots.mo1228intParamNamew8GmfQM(Operation.IntParameter.m1230constructorimpl(i6)));
                i5++;
            }
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
        StringBuilder sb3 = new StringBuilder();
        int objects = insertSlots.getObjects();
        int i7 = 0;
        for (int i8 = 0; i8 < objects; i8++) {
            if (((1 << i8) & Operations.access$getPushedObjectMask$p(operations)) != 0) {
                if (i5 > 0) {
                    sb3.append(", ");
                }
                sb3.append(insertSlots.mo1229objectParamName31yXWZQ(Operation.ObjectParameter.m1232constructorimpl(i8)));
                i7++;
            }
        }
        String sb4 = sb3.toString();
        Intrinsics.checkNotNullExpressionValue(sb4, "StringBuilder().apply(builderAction).toString()");
        PreconditionsKt.throwIllegalStateException("Error while pushing " + insertSlots + ". Not all arguments were provided. Missing " + i5 + " int arguments (" + sb2 + ") and " + i7 + " object arguments (" + sb4 + ").");
    }

    public final void pushMoveCurrentGroup(int offset) {
        Operations operations = this.operations;
        Operation.MoveCurrentGroup moveCurrentGroup = Operation.MoveCurrentGroup.INSTANCE;
        operations.pushOp(moveCurrentGroup);
        Operations.WriteScope.m1242setIntA6tL2VI(Operations.WriteScope.m1240constructorimpl(operations), Operation.IntParameter.m1230constructorimpl(0), offset);
        if (Operations.access$getPushedIntMask$p(operations) == Operations.access$createExpectedArgMask(operations, moveCurrentGroup.getInts()) && Operations.access$getPushedObjectMask$p(operations) == Operations.access$createExpectedArgMask(operations, moveCurrentGroup.getObjects())) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        int ints = moveCurrentGroup.getInts();
        int i5 = 0;
        for (int i6 = 0; i6 < ints; i6++) {
            if (((1 << i6) & Operations.access$getPushedIntMask$p(operations)) != 0) {
                if (i5 > 0) {
                    sb.append(", ");
                }
                sb.append(moveCurrentGroup.mo1228intParamNamew8GmfQM(Operation.IntParameter.m1230constructorimpl(i6)));
                i5++;
            }
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
        StringBuilder sb3 = new StringBuilder();
        int objects = moveCurrentGroup.getObjects();
        int i7 = 0;
        for (int i8 = 0; i8 < objects; i8++) {
            if (((1 << i8) & Operations.access$getPushedObjectMask$p(operations)) != 0) {
                if (i5 > 0) {
                    sb3.append(", ");
                }
                sb3.append(moveCurrentGroup.mo1229objectParamName31yXWZQ(Operation.ObjectParameter.m1232constructorimpl(i8)));
                i7++;
            }
        }
        String sb4 = sb3.toString();
        Intrinsics.checkNotNullExpressionValue(sb4, "StringBuilder().apply(builderAction).toString()");
        PreconditionsKt.throwIllegalStateException("Error while pushing " + moveCurrentGroup + ". Not all arguments were provided. Missing " + i5 + " int arguments (" + sb2 + ") and " + i7 + " object arguments (" + sb4 + ").");
    }

    public final void pushMoveNode(int to, int from, int count) {
        Operations operations = this.operations;
        Operation.MoveNode moveNode = Operation.MoveNode.INSTANCE;
        operations.pushOp(moveNode);
        Operations m1240constructorimpl = Operations.WriteScope.m1240constructorimpl(operations);
        Operations.WriteScope.m1242setIntA6tL2VI(m1240constructorimpl, Operation.IntParameter.m1230constructorimpl(1), to);
        Operations.WriteScope.m1242setIntA6tL2VI(m1240constructorimpl, Operation.IntParameter.m1230constructorimpl(0), from);
        Operations.WriteScope.m1242setIntA6tL2VI(m1240constructorimpl, Operation.IntParameter.m1230constructorimpl(2), count);
        if (Operations.access$getPushedIntMask$p(operations) == Operations.access$createExpectedArgMask(operations, moveNode.getInts()) && Operations.access$getPushedObjectMask$p(operations) == Operations.access$createExpectedArgMask(operations, moveNode.getObjects())) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        int ints = moveNode.getInts();
        int i5 = 0;
        for (int i6 = 0; i6 < ints; i6++) {
            if (((1 << i6) & Operations.access$getPushedIntMask$p(operations)) != 0) {
                if (i5 > 0) {
                    sb.append(", ");
                }
                sb.append(moveNode.mo1228intParamNamew8GmfQM(Operation.IntParameter.m1230constructorimpl(i6)));
                i5++;
            }
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
        StringBuilder sb3 = new StringBuilder();
        int objects = moveNode.getObjects();
        int i7 = 0;
        for (int i8 = 0; i8 < objects; i8++) {
            if (((1 << i8) & Operations.access$getPushedObjectMask$p(operations)) != 0) {
                if (i5 > 0) {
                    sb3.append(", ");
                }
                sb3.append(moveNode.mo1229objectParamName31yXWZQ(Operation.ObjectParameter.m1232constructorimpl(i8)));
                i7++;
            }
        }
        String sb4 = sb3.toString();
        Intrinsics.checkNotNullExpressionValue(sb4, "StringBuilder().apply(builderAction).toString()");
        PreconditionsKt.throwIllegalStateException("Error while pushing " + moveNode + ". Not all arguments were provided. Missing " + i5 + " int arguments (" + sb2 + ") and " + i7 + " object arguments (" + sb4 + ").");
    }

    public final void pushRemember(RememberObserver value) {
        Operations operations = this.operations;
        Operation.Remember remember = Operation.Remember.INSTANCE;
        operations.pushOp(remember);
        Operations.WriteScope.m1243setObjectDKhxnng(Operations.WriteScope.m1240constructorimpl(operations), Operation.ObjectParameter.m1232constructorimpl(0), value);
        if (Operations.access$getPushedIntMask$p(operations) == Operations.access$createExpectedArgMask(operations, remember.getInts()) && Operations.access$getPushedObjectMask$p(operations) == Operations.access$createExpectedArgMask(operations, remember.getObjects())) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        int ints = remember.getInts();
        int i5 = 0;
        for (int i6 = 0; i6 < ints; i6++) {
            if (((1 << i6) & Operations.access$getPushedIntMask$p(operations)) != 0) {
                if (i5 > 0) {
                    sb.append(", ");
                }
                sb.append(remember.mo1228intParamNamew8GmfQM(Operation.IntParameter.m1230constructorimpl(i6)));
                i5++;
            }
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
        StringBuilder sb3 = new StringBuilder();
        int objects = remember.getObjects();
        int i7 = 0;
        for (int i8 = 0; i8 < objects; i8++) {
            if (((1 << i8) & Operations.access$getPushedObjectMask$p(operations)) != 0) {
                if (i5 > 0) {
                    sb3.append(", ");
                }
                sb3.append(remember.mo1229objectParamName31yXWZQ(Operation.ObjectParameter.m1232constructorimpl(i8)));
                i7++;
            }
        }
        String sb4 = sb3.toString();
        Intrinsics.checkNotNullExpressionValue(sb4, "StringBuilder().apply(builderAction).toString()");
        PreconditionsKt.throwIllegalStateException("Error while pushing " + remember + ". Not all arguments were provided. Missing " + i5 + " int arguments (" + sb2 + ") and " + i7 + " object arguments (" + sb4 + ").");
    }

    public final void pushRemoveCurrentGroup() {
        this.operations.push(Operation.RemoveCurrentGroup.INSTANCE);
    }

    public final void pushRemoveNode(int removeFrom, int moveCount) {
        Operations operations = this.operations;
        Operation.RemoveNode removeNode = Operation.RemoveNode.INSTANCE;
        operations.pushOp(removeNode);
        Operations m1240constructorimpl = Operations.WriteScope.m1240constructorimpl(operations);
        Operations.WriteScope.m1242setIntA6tL2VI(m1240constructorimpl, Operation.IntParameter.m1230constructorimpl(0), removeFrom);
        Operations.WriteScope.m1242setIntA6tL2VI(m1240constructorimpl, Operation.IntParameter.m1230constructorimpl(1), moveCount);
        if (Operations.access$getPushedIntMask$p(operations) == Operations.access$createExpectedArgMask(operations, removeNode.getInts()) && Operations.access$getPushedObjectMask$p(operations) == Operations.access$createExpectedArgMask(operations, removeNode.getObjects())) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        int ints = removeNode.getInts();
        int i5 = 0;
        for (int i6 = 0; i6 < ints; i6++) {
            if (((1 << i6) & Operations.access$getPushedIntMask$p(operations)) != 0) {
                if (i5 > 0) {
                    sb.append(", ");
                }
                sb.append(removeNode.mo1228intParamNamew8GmfQM(Operation.IntParameter.m1230constructorimpl(i6)));
                i5++;
            }
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
        StringBuilder sb3 = new StringBuilder();
        int objects = removeNode.getObjects();
        int i7 = 0;
        for (int i8 = 0; i8 < objects; i8++) {
            if (((1 << i8) & Operations.access$getPushedObjectMask$p(operations)) != 0) {
                if (i5 > 0) {
                    sb3.append(", ");
                }
                sb3.append(removeNode.mo1229objectParamName31yXWZQ(Operation.ObjectParameter.m1232constructorimpl(i8)));
                i7++;
            }
        }
        String sb4 = sb3.toString();
        Intrinsics.checkNotNullExpressionValue(sb4, "StringBuilder().apply(builderAction).toString()");
        PreconditionsKt.throwIllegalStateException("Error while pushing " + removeNode + ". Not all arguments were provided. Missing " + i5 + " int arguments (" + sb2 + ") and " + i7 + " object arguments (" + sb4 + ").");
    }

    public final void pushResetSlots() {
        this.operations.push(Operation.ResetSlots.INSTANCE);
    }

    public final void pushSideEffect(Function0<Unit> effect) {
        Operations operations = this.operations;
        Operation.SideEffect sideEffect = Operation.SideEffect.INSTANCE;
        operations.pushOp(sideEffect);
        Operations.WriteScope.m1243setObjectDKhxnng(Operations.WriteScope.m1240constructorimpl(operations), Operation.ObjectParameter.m1232constructorimpl(0), effect);
        if (Operations.access$getPushedIntMask$p(operations) == Operations.access$createExpectedArgMask(operations, sideEffect.getInts()) && Operations.access$getPushedObjectMask$p(operations) == Operations.access$createExpectedArgMask(operations, sideEffect.getObjects())) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        int ints = sideEffect.getInts();
        int i5 = 0;
        for (int i6 = 0; i6 < ints; i6++) {
            if (((1 << i6) & Operations.access$getPushedIntMask$p(operations)) != 0) {
                if (i5 > 0) {
                    sb.append(", ");
                }
                sb.append(sideEffect.mo1228intParamNamew8GmfQM(Operation.IntParameter.m1230constructorimpl(i6)));
                i5++;
            }
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
        StringBuilder sb3 = new StringBuilder();
        int objects = sideEffect.getObjects();
        int i7 = 0;
        for (int i8 = 0; i8 < objects; i8++) {
            if (((1 << i8) & Operations.access$getPushedObjectMask$p(operations)) != 0) {
                if (i5 > 0) {
                    sb3.append(", ");
                }
                sb3.append(sideEffect.mo1229objectParamName31yXWZQ(Operation.ObjectParameter.m1232constructorimpl(i8)));
                i7++;
            }
        }
        String sb4 = sb3.toString();
        Intrinsics.checkNotNullExpressionValue(sb4, "StringBuilder().apply(builderAction).toString()");
        PreconditionsKt.throwIllegalStateException("Error while pushing " + sideEffect + ". Not all arguments were provided. Missing " + i5 + " int arguments (" + sb2 + ") and " + i7 + " object arguments (" + sb4 + ").");
    }

    public final void pushSkipToEndOfCurrentGroup() {
        this.operations.push(Operation.SkipToEndOfCurrentGroup.INSTANCE);
    }

    public final void pushTrimValues(int count) {
        Operations operations = this.operations;
        Operation.TrimParentValues trimParentValues = Operation.TrimParentValues.INSTANCE;
        operations.pushOp(trimParentValues);
        Operations.WriteScope.m1242setIntA6tL2VI(Operations.WriteScope.m1240constructorimpl(operations), Operation.IntParameter.m1230constructorimpl(0), count);
        if (Operations.access$getPushedIntMask$p(operations) == Operations.access$createExpectedArgMask(operations, trimParentValues.getInts()) && Operations.access$getPushedObjectMask$p(operations) == Operations.access$createExpectedArgMask(operations, trimParentValues.getObjects())) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        int ints = trimParentValues.getInts();
        int i5 = 0;
        for (int i6 = 0; i6 < ints; i6++) {
            if (((1 << i6) & Operations.access$getPushedIntMask$p(operations)) != 0) {
                if (i5 > 0) {
                    sb.append(", ");
                }
                sb.append(trimParentValues.mo1228intParamNamew8GmfQM(Operation.IntParameter.m1230constructorimpl(i6)));
                i5++;
            }
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
        StringBuilder sb3 = new StringBuilder();
        int objects = trimParentValues.getObjects();
        int i7 = 0;
        for (int i8 = 0; i8 < objects; i8++) {
            if (((1 << i8) & Operations.access$getPushedObjectMask$p(operations)) != 0) {
                if (i5 > 0) {
                    sb3.append(", ");
                }
                sb3.append(trimParentValues.mo1229objectParamName31yXWZQ(Operation.ObjectParameter.m1232constructorimpl(i8)));
                i7++;
            }
        }
        String sb4 = sb3.toString();
        Intrinsics.checkNotNullExpressionValue(sb4, "StringBuilder().apply(builderAction).toString()");
        PreconditionsKt.throwIllegalStateException("Error while pushing " + trimParentValues + ". Not all arguments were provided. Missing " + i5 + " int arguments (" + sb2 + ") and " + i7 + " object arguments (" + sb4 + ").");
    }

    public final void pushUpdateAnchoredValue(Object value, Anchor anchor, int groupSlotIndex) {
        Operations operations = this.operations;
        Operation.UpdateAnchoredValue updateAnchoredValue = Operation.UpdateAnchoredValue.INSTANCE;
        operations.pushOp(updateAnchoredValue);
        Operations m1240constructorimpl = Operations.WriteScope.m1240constructorimpl(operations);
        Operations.WriteScope.m1243setObjectDKhxnng(m1240constructorimpl, Operation.ObjectParameter.m1232constructorimpl(0), value);
        Operations.WriteScope.m1243setObjectDKhxnng(m1240constructorimpl, Operation.ObjectParameter.m1232constructorimpl(1), anchor);
        Operations.WriteScope.m1242setIntA6tL2VI(m1240constructorimpl, Operation.IntParameter.m1230constructorimpl(0), groupSlotIndex);
        if (Operations.access$getPushedIntMask$p(operations) == Operations.access$createExpectedArgMask(operations, updateAnchoredValue.getInts()) && Operations.access$getPushedObjectMask$p(operations) == Operations.access$createExpectedArgMask(operations, updateAnchoredValue.getObjects())) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        int ints = updateAnchoredValue.getInts();
        int i5 = 0;
        for (int i6 = 0; i6 < ints; i6++) {
            if (((1 << i6) & Operations.access$getPushedIntMask$p(operations)) != 0) {
                if (i5 > 0) {
                    sb.append(", ");
                }
                sb.append(updateAnchoredValue.mo1228intParamNamew8GmfQM(Operation.IntParameter.m1230constructorimpl(i6)));
                i5++;
            }
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
        StringBuilder sb3 = new StringBuilder();
        int objects = updateAnchoredValue.getObjects();
        int i7 = 0;
        for (int i8 = 0; i8 < objects; i8++) {
            if (((1 << i8) & Operations.access$getPushedObjectMask$p(operations)) != 0) {
                if (i5 > 0) {
                    sb3.append(", ");
                }
                sb3.append(updateAnchoredValue.mo1229objectParamName31yXWZQ(Operation.ObjectParameter.m1232constructorimpl(i8)));
                i7++;
            }
        }
        String sb4 = sb3.toString();
        Intrinsics.checkNotNullExpressionValue(sb4, "StringBuilder().apply(builderAction).toString()");
        PreconditionsKt.throwIllegalStateException("Error while pushing " + updateAnchoredValue + ". Not all arguments were provided. Missing " + i5 + " int arguments (" + sb2 + ") and " + i7 + " object arguments (" + sb4 + ").");
    }

    public final void pushUpdateAuxData(Object data) {
        Operations operations = this.operations;
        Operation.UpdateAuxData updateAuxData = Operation.UpdateAuxData.INSTANCE;
        operations.pushOp(updateAuxData);
        Operations.WriteScope.m1243setObjectDKhxnng(Operations.WriteScope.m1240constructorimpl(operations), Operation.ObjectParameter.m1232constructorimpl(0), data);
        if (Operations.access$getPushedIntMask$p(operations) == Operations.access$createExpectedArgMask(operations, updateAuxData.getInts()) && Operations.access$getPushedObjectMask$p(operations) == Operations.access$createExpectedArgMask(operations, updateAuxData.getObjects())) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        int ints = updateAuxData.getInts();
        int i5 = 0;
        for (int i6 = 0; i6 < ints; i6++) {
            if (((1 << i6) & Operations.access$getPushedIntMask$p(operations)) != 0) {
                if (i5 > 0) {
                    sb.append(", ");
                }
                sb.append(updateAuxData.mo1228intParamNamew8GmfQM(Operation.IntParameter.m1230constructorimpl(i6)));
                i5++;
            }
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
        StringBuilder sb3 = new StringBuilder();
        int objects = updateAuxData.getObjects();
        int i7 = 0;
        for (int i8 = 0; i8 < objects; i8++) {
            if (((1 << i8) & Operations.access$getPushedObjectMask$p(operations)) != 0) {
                if (i5 > 0) {
                    sb3.append(", ");
                }
                sb3.append(updateAuxData.mo1229objectParamName31yXWZQ(Operation.ObjectParameter.m1232constructorimpl(i8)));
                i7++;
            }
        }
        String sb4 = sb3.toString();
        Intrinsics.checkNotNullExpressionValue(sb4, "StringBuilder().apply(builderAction).toString()");
        PreconditionsKt.throwIllegalStateException("Error while pushing " + updateAuxData + ". Not all arguments were provided. Missing " + i5 + " int arguments (" + sb2 + ") and " + i7 + " object arguments (" + sb4 + ").");
    }

    public final <T, V> void pushUpdateNode(V value, Function2<? super T, ? super V, Unit> block) {
        Operations operations = this.operations;
        Operation.UpdateNode updateNode = Operation.UpdateNode.INSTANCE;
        operations.pushOp(updateNode);
        Operations m1240constructorimpl = Operations.WriteScope.m1240constructorimpl(operations);
        Operations.WriteScope.m1243setObjectDKhxnng(m1240constructorimpl, Operation.ObjectParameter.m1232constructorimpl(0), value);
        int m1232constructorimpl = Operation.ObjectParameter.m1232constructorimpl(1);
        Intrinsics.checkNotNull(block, "null cannot be cast to non-null type @[ExtensionFunctionType] kotlin.Function2<kotlin.Any?, kotlin.Any?, kotlin.Unit>");
        Operations.WriteScope.m1243setObjectDKhxnng(m1240constructorimpl, m1232constructorimpl, (Function2) TypeIntrinsics.beforeCheckcastToFunctionOfArity(block, 2));
        if (Operations.access$getPushedIntMask$p(operations) == Operations.access$createExpectedArgMask(operations, updateNode.getInts()) && Operations.access$getPushedObjectMask$p(operations) == Operations.access$createExpectedArgMask(operations, updateNode.getObjects())) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        int ints = updateNode.getInts();
        int i5 = 0;
        for (int i6 = 0; i6 < ints; i6++) {
            if (((1 << i6) & Operations.access$getPushedIntMask$p(operations)) != 0) {
                if (i5 > 0) {
                    sb.append(", ");
                }
                sb.append(updateNode.mo1228intParamNamew8GmfQM(Operation.IntParameter.m1230constructorimpl(i6)));
                i5++;
            }
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
        StringBuilder sb3 = new StringBuilder();
        int objects = updateNode.getObjects();
        int i7 = 0;
        for (int i8 = 0; i8 < objects; i8++) {
            if (((1 << i8) & Operations.access$getPushedObjectMask$p(operations)) != 0) {
                if (i5 > 0) {
                    sb3.append(", ");
                }
                sb3.append(updateNode.mo1229objectParamName31yXWZQ(Operation.ObjectParameter.m1232constructorimpl(i8)));
                i7++;
            }
        }
        String sb4 = sb3.toString();
        Intrinsics.checkNotNullExpressionValue(sb4, "StringBuilder().apply(builderAction).toString()");
        PreconditionsKt.throwIllegalStateException("Error while pushing " + updateNode + ". Not all arguments were provided. Missing " + i5 + " int arguments (" + sb2 + ") and " + i7 + " object arguments (" + sb4 + ").");
    }

    public final void pushUpdateValue(Object value, int groupSlotIndex) {
        Operations operations = this.operations;
        Operation.UpdateValue updateValue = Operation.UpdateValue.INSTANCE;
        operations.pushOp(updateValue);
        Operations m1240constructorimpl = Operations.WriteScope.m1240constructorimpl(operations);
        Operations.WriteScope.m1243setObjectDKhxnng(m1240constructorimpl, Operation.ObjectParameter.m1232constructorimpl(0), value);
        Operations.WriteScope.m1242setIntA6tL2VI(m1240constructorimpl, Operation.IntParameter.m1230constructorimpl(0), groupSlotIndex);
        if (Operations.access$getPushedIntMask$p(operations) == Operations.access$createExpectedArgMask(operations, updateValue.getInts()) && Operations.access$getPushedObjectMask$p(operations) == Operations.access$createExpectedArgMask(operations, updateValue.getObjects())) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        int ints = updateValue.getInts();
        int i5 = 0;
        for (int i6 = 0; i6 < ints; i6++) {
            if (((1 << i6) & Operations.access$getPushedIntMask$p(operations)) != 0) {
                if (i5 > 0) {
                    sb.append(", ");
                }
                sb.append(updateValue.mo1228intParamNamew8GmfQM(Operation.IntParameter.m1230constructorimpl(i6)));
                i5++;
            }
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
        StringBuilder sb3 = new StringBuilder();
        int objects = updateValue.getObjects();
        int i7 = 0;
        for (int i8 = 0; i8 < objects; i8++) {
            if (((1 << i8) & Operations.access$getPushedObjectMask$p(operations)) != 0) {
                if (i5 > 0) {
                    sb3.append(", ");
                }
                sb3.append(updateValue.mo1229objectParamName31yXWZQ(Operation.ObjectParameter.m1232constructorimpl(i8)));
                i7++;
            }
        }
        String sb4 = sb3.toString();
        Intrinsics.checkNotNullExpressionValue(sb4, "StringBuilder().apply(builderAction).toString()");
        PreconditionsKt.throwIllegalStateException("Error while pushing " + updateValue + ". Not all arguments were provided. Missing " + i5 + " int arguments (" + sb2 + ") and " + i7 + " object arguments (" + sb4 + ").");
    }

    public final void pushUps(int count) {
        Operations operations = this.operations;
        Operation.Ups ups = Operation.Ups.INSTANCE;
        operations.pushOp(ups);
        Operations.WriteScope.m1242setIntA6tL2VI(Operations.WriteScope.m1240constructorimpl(operations), Operation.IntParameter.m1230constructorimpl(0), count);
        if (Operations.access$getPushedIntMask$p(operations) == Operations.access$createExpectedArgMask(operations, ups.getInts()) && Operations.access$getPushedObjectMask$p(operations) == Operations.access$createExpectedArgMask(operations, ups.getObjects())) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        int ints = ups.getInts();
        int i5 = 0;
        for (int i6 = 0; i6 < ints; i6++) {
            if (((1 << i6) & Operations.access$getPushedIntMask$p(operations)) != 0) {
                if (i5 > 0) {
                    sb.append(", ");
                }
                sb.append(ups.mo1228intParamNamew8GmfQM(Operation.IntParameter.m1230constructorimpl(i6)));
                i5++;
            }
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
        StringBuilder sb3 = new StringBuilder();
        int objects = ups.getObjects();
        int i7 = 0;
        for (int i8 = 0; i8 < objects; i8++) {
            if (((1 << i8) & Operations.access$getPushedObjectMask$p(operations)) != 0) {
                if (i5 > 0) {
                    sb3.append(", ");
                }
                sb3.append(ups.mo1229objectParamName31yXWZQ(Operation.ObjectParameter.m1232constructorimpl(i8)));
                i7++;
            }
        }
        String sb4 = sb3.toString();
        Intrinsics.checkNotNullExpressionValue(sb4, "StringBuilder().apply(builderAction).toString()");
        PreconditionsKt.throwIllegalStateException("Error while pushing " + ups + ". Not all arguments were provided. Missing " + i5 + " int arguments (" + sb2 + ") and " + i7 + " object arguments (" + sb4 + ").");
    }

    public final void pushUseNode(Object node) {
        if (node instanceof ComposeNodeLifecycleCallback) {
            this.operations.push(Operation.UseCurrentNode.INSTANCE);
        }
    }

    public final void pushInsertSlots(Anchor anchor, SlotTable from, FixupList fixups) {
        Operations operations = this.operations;
        Operation.InsertSlotsWithFixups insertSlotsWithFixups = Operation.InsertSlotsWithFixups.INSTANCE;
        operations.pushOp(insertSlotsWithFixups);
        Operations m1240constructorimpl = Operations.WriteScope.m1240constructorimpl(operations);
        Operations.WriteScope.m1243setObjectDKhxnng(m1240constructorimpl, Operation.ObjectParameter.m1232constructorimpl(0), anchor);
        Operations.WriteScope.m1243setObjectDKhxnng(m1240constructorimpl, Operation.ObjectParameter.m1232constructorimpl(1), from);
        Operations.WriteScope.m1243setObjectDKhxnng(m1240constructorimpl, Operation.ObjectParameter.m1232constructorimpl(2), fixups);
        if (Operations.access$getPushedIntMask$p(operations) == Operations.access$createExpectedArgMask(operations, insertSlotsWithFixups.getInts()) && Operations.access$getPushedObjectMask$p(operations) == Operations.access$createExpectedArgMask(operations, insertSlotsWithFixups.getObjects())) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        int ints = insertSlotsWithFixups.getInts();
        int i5 = 0;
        for (int i6 = 0; i6 < ints; i6++) {
            if (((1 << i6) & Operations.access$getPushedIntMask$p(operations)) != 0) {
                if (i5 > 0) {
                    sb.append(", ");
                }
                sb.append(insertSlotsWithFixups.mo1228intParamNamew8GmfQM(Operation.IntParameter.m1230constructorimpl(i6)));
                i5++;
            }
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
        StringBuilder sb3 = new StringBuilder();
        int objects = insertSlotsWithFixups.getObjects();
        int i7 = 0;
        for (int i8 = 0; i8 < objects; i8++) {
            if (((1 << i8) & Operations.access$getPushedObjectMask$p(operations)) != 0) {
                if (i5 > 0) {
                    sb3.append(", ");
                }
                sb3.append(insertSlotsWithFixups.mo1229objectParamName31yXWZQ(Operation.ObjectParameter.m1232constructorimpl(i8)));
                i7++;
            }
        }
        String sb4 = sb3.toString();
        Intrinsics.checkNotNullExpressionValue(sb4, "StringBuilder().apply(builderAction).toString()");
        PreconditionsKt.throwIllegalStateException("Error while pushing " + insertSlotsWithFixups + ". Not all arguments were provided. Missing " + i5 + " int arguments (" + sb2 + ") and " + i7 + " object arguments (" + sb4 + ").");
    }
}
