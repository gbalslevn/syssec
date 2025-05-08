package androidx.compose.runtime.changelist;

import androidx.compose.runtime.Anchor;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.PreconditionsKt;
import androidx.compose.runtime.RememberManager;
import androidx.compose.runtime.SlotWriter;
import androidx.compose.runtime.changelist.Operation;
import androidx.compose.runtime.changelist.Operations;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\r\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\u0003J)\u0010\u000f\u001a\u00020\u00072\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J-\u0010\u0018\u001a\u00020\u00072\u000e\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u00112\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\r\u0010\u001a\u001a\u00020\u0007¢\u0006\u0004\b\u001a\u0010\u0003J;\u0010 \u001a\u00020\u0007\"\u0004\b\u0000\u0010\u001b\"\u0004\b\u0001\u0010\u001c2\u0006\u0010\u001d\u001a\u00028\u00002\u0018\u0010\u001f\u001a\u0014\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00070\u001e¢\u0006\u0004\b \u0010!R\u0014\u0010#\u001a\u00020\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0014\u0010%\u001a\u00020\"8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010$¨\u0006&"}, d2 = {"Landroidx/compose/runtime/changelist/FixupList;", "Landroidx/compose/runtime/changelist/OperationsDebugStringFormattable;", "<init>", "()V", BuildConfig.FLAVOR, "isEmpty", "()Z", BuildConfig.FLAVOR, "clear", "Landroidx/compose/runtime/Applier;", "applier", "Landroidx/compose/runtime/SlotWriter;", "slots", "Landroidx/compose/runtime/RememberManager;", "rememberManager", "executeAndFlushAllPendingFixups", "(Landroidx/compose/runtime/Applier;Landroidx/compose/runtime/SlotWriter;Landroidx/compose/runtime/RememberManager;)V", "Lkotlin/Function0;", BuildConfig.FLAVOR, "factory", BuildConfig.FLAVOR, "insertIndex", "Landroidx/compose/runtime/Anchor;", "groupAnchor", "createAndInsertNode", "(Lkotlin/jvm/functions/Function0;ILandroidx/compose/runtime/Anchor;)V", "endNodeInsert", "V", "T", "value", "Lkotlin/Function2;", "block", "updateNode", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", "Landroidx/compose/runtime/changelist/Operations;", "operations", "Landroidx/compose/runtime/changelist/Operations;", "pendingOperations", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class FixupList extends OperationsDebugStringFormattable {
    private final Operations operations = new Operations();
    private final Operations pendingOperations = new Operations();

    public final void clear() {
        this.pendingOperations.clear();
        this.operations.clear();
    }

    public final void createAndInsertNode(Function0<? extends Object> factory, int insertIndex, Anchor groupAnchor) {
        Operations operations;
        Operations operations2;
        Operations operations3 = this.operations;
        Operation.InsertNodeFixup insertNodeFixup = Operation.InsertNodeFixup.INSTANCE;
        operations3.pushOp(insertNodeFixup);
        Operations m1240constructorimpl = Operations.WriteScope.m1240constructorimpl(operations3);
        Operations.WriteScope.m1243setObjectDKhxnng(m1240constructorimpl, Operation.ObjectParameter.m1232constructorimpl(0), factory);
        Operations.WriteScope.m1242setIntA6tL2VI(m1240constructorimpl, Operation.IntParameter.m1230constructorimpl(0), insertIndex);
        int i5 = 1;
        Operations.WriteScope.m1243setObjectDKhxnng(m1240constructorimpl, Operation.ObjectParameter.m1232constructorimpl(1), groupAnchor);
        if (!(Operations.access$getPushedIntMask$p(operations3) == Operations.access$createExpectedArgMask(operations3, insertNodeFixup.getInts()) && Operations.access$getPushedObjectMask$p(operations3) == Operations.access$createExpectedArgMask(operations3, insertNodeFixup.getObjects()))) {
            StringBuilder sb = new StringBuilder();
            int ints = insertNodeFixup.getInts();
            int i6 = 0;
            int i7 = 0;
            while (i7 < ints) {
                if (((i5 << i7) & Operations.access$getPushedIntMask$p(operations3)) != 0) {
                    if (i6 > 0) {
                        sb.append(", ");
                    }
                    sb.append(insertNodeFixup.mo1228intParamNamew8GmfQM(Operation.IntParameter.m1230constructorimpl(i7)));
                    i6++;
                }
                i7++;
                i5 = 1;
            }
            String sb2 = sb.toString();
            Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder().apply(builderAction).toString()");
            StringBuilder sb3 = new StringBuilder();
            int objects = insertNodeFixup.getObjects();
            int i8 = 0;
            int i9 = 0;
            while (i9 < objects) {
                if (((1 << i9) & Operations.access$getPushedObjectMask$p(operations3)) != 0) {
                    if (i6 > 0) {
                        sb3.append(", ");
                    }
                    operations2 = operations3;
                    sb3.append(insertNodeFixup.mo1229objectParamName31yXWZQ(Operation.ObjectParameter.m1232constructorimpl(i9)));
                    i8++;
                } else {
                    operations2 = operations3;
                }
                i9++;
                operations3 = operations2;
            }
            String sb4 = sb3.toString();
            Intrinsics.checkNotNullExpressionValue(sb4, "StringBuilder().apply(builderAction).toString()");
            PreconditionsKt.throwIllegalStateException("Error while pushing " + insertNodeFixup + ". Not all arguments were provided. Missing " + i6 + " int arguments (" + sb2 + ") and " + i8 + " object arguments (" + sb4 + ").");
        }
        Operations operations4 = this.pendingOperations;
        Operation.PostInsertNodeFixup postInsertNodeFixup = Operation.PostInsertNodeFixup.INSTANCE;
        operations4.pushOp(postInsertNodeFixup);
        Operations m1240constructorimpl2 = Operations.WriteScope.m1240constructorimpl(operations4);
        Operations.WriteScope.m1242setIntA6tL2VI(m1240constructorimpl2, Operation.IntParameter.m1230constructorimpl(0), insertIndex);
        Operations.WriteScope.m1243setObjectDKhxnng(m1240constructorimpl2, Operation.ObjectParameter.m1232constructorimpl(0), groupAnchor);
        if (Operations.access$getPushedIntMask$p(operations4) == Operations.access$createExpectedArgMask(operations4, postInsertNodeFixup.getInts()) && Operations.access$getPushedObjectMask$p(operations4) == Operations.access$createExpectedArgMask(operations4, postInsertNodeFixup.getObjects())) {
            return;
        }
        StringBuilder sb5 = new StringBuilder();
        int ints2 = postInsertNodeFixup.getInts();
        int i10 = 0;
        for (int i11 = 0; i11 < ints2; i11++) {
            if (((1 << i11) & Operations.access$getPushedIntMask$p(operations4)) != 0) {
                if (i10 > 0) {
                    sb5.append(", ");
                }
                sb5.append(postInsertNodeFixup.mo1228intParamNamew8GmfQM(Operation.IntParameter.m1230constructorimpl(i11)));
                i10++;
            }
        }
        String sb6 = sb5.toString();
        Intrinsics.checkNotNullExpressionValue(sb6, "StringBuilder().apply(builderAction).toString()");
        StringBuilder sb7 = new StringBuilder();
        int objects2 = postInsertNodeFixup.getObjects();
        int i12 = 0;
        int i13 = 0;
        while (i13 < objects2) {
            if (((1 << i13) & Operations.access$getPushedObjectMask$p(operations4)) != 0) {
                if (i10 > 0) {
                    sb7.append(", ");
                }
                operations = operations4;
                sb7.append(postInsertNodeFixup.mo1229objectParamName31yXWZQ(Operation.ObjectParameter.m1232constructorimpl(i13)));
                i12++;
            } else {
                operations = operations4;
            }
            i13++;
            operations4 = operations;
        }
        String sb8 = sb7.toString();
        Intrinsics.checkNotNullExpressionValue(sb8, "StringBuilder().apply(builderAction).toString()");
        PreconditionsKt.throwIllegalStateException("Error while pushing " + postInsertNodeFixup + ". Not all arguments were provided. Missing " + i10 + " int arguments (" + sb6 + ") and " + i12 + " object arguments (" + sb8 + ").");
    }

    public final void endNodeInsert() {
        if (!this.pendingOperations.isNotEmpty()) {
            ComposerKt.composeImmediateRuntimeError("Cannot end node insertion, there are no pending operations that can be realized.");
        }
        this.pendingOperations.popInto(this.operations);
    }

    public final void executeAndFlushAllPendingFixups(Applier<?> applier, SlotWriter slots, RememberManager rememberManager) {
        if (!this.pendingOperations.isEmpty()) {
            ComposerKt.composeImmediateRuntimeError("FixupList has pending fixup operations that were not realized. Were there mismatched insertNode() and endNodeInsert() calls?");
        }
        this.operations.executeAndFlushAllPendingOperations(applier, slots, rememberManager);
    }

    public final boolean isEmpty() {
        return this.operations.isEmpty();
    }

    public final <V, T> void updateNode(V value, Function2<? super T, ? super V, Unit> block) {
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
}
