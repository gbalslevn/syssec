package androidx.compose.runtime.changelist;

import androidx.compose.runtime.Anchor;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposeNodeLifecycleCallback;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.Composition;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.MovableContentStateReference;
import androidx.compose.runtime.OffsetApplier;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.RememberManager;
import androidx.compose.runtime.RememberObserver;
import androidx.compose.runtime.RememberObserverHolder;
import androidx.compose.runtime.SlotTable;
import androidx.compose.runtime.SlotWriter;
import androidx.compose.runtime.internal.IntRef;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000Æ\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\"\"#$%&'()*+,-./0123456789:;<=>?@ABCB\u001d\b\u0004\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J/\u0010\u000f\u001a\u00020\u000e*\u00020\u00072\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH&¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0011H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015J\u001e\u0010\u0019\u001a\u00020\u00132\n\u0010\u0012\u001a\u0006\u0012\u0002\b\u00030\u0017H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0015J\u000f\u0010\u001a\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u001a\u0010\u001bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u001c\u001a\u0004\b\u001f\u0010\u001eR\u0011\u0010!\u001a\u00020\u00138F¢\u0006\u0006\u001a\u0004\b \u0010\u001b\u0082\u0001 DEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abc\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006d"}, d2 = {"Landroidx/compose/runtime/changelist/Operation;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "ints", "objects", "<init>", "(II)V", "Landroidx/compose/runtime/changelist/OperationArgContainer;", "Landroidx/compose/runtime/Applier;", "applier", "Landroidx/compose/runtime/SlotWriter;", "slots", "Landroidx/compose/runtime/RememberManager;", "rememberManager", BuildConfig.FLAVOR, "execute", "(Landroidx/compose/runtime/changelist/OperationArgContainer;Landroidx/compose/runtime/Applier;Landroidx/compose/runtime/SlotWriter;Landroidx/compose/runtime/RememberManager;)V", "Landroidx/compose/runtime/changelist/Operation$IntParameter;", "parameter", BuildConfig.FLAVOR, "intParamName-w8GmfQM", "(I)Ljava/lang/String;", "intParamName", "Landroidx/compose/runtime/changelist/Operation$ObjectParameter;", "objectParamName-31yXWZQ", "objectParamName", "toString", "()Ljava/lang/String;", "I", "getInts", "()I", "getObjects", "getName", "name", "AdvanceSlotsBy", "AppendValue", "ApplyChangeList", "CopyNodesToNewAnchorLocation", "CopySlotTableToAnchorLocation", "DeactivateCurrentGroup", "DetermineMovableContentNodeIndex", "Downs", "EndCompositionScope", "EndCurrentGroup", "EndMovableContentPlacement", "EnsureGroupStarted", "EnsureRootGroupStarted", "InsertNodeFixup", "InsertSlots", "InsertSlotsWithFixups", "IntParameter", "MoveCurrentGroup", "MoveNode", "ObjectParameter", "PostInsertNodeFixup", "Remember", "RemoveCurrentGroup", "RemoveNode", "ResetSlots", "SideEffect", "SkipToEndOfCurrentGroup", "TrimParentValues", "UpdateAnchoredValue", "UpdateAuxData", "UpdateNode", "UpdateValue", "Ups", "UseCurrentNode", "Landroidx/compose/runtime/changelist/Operation$AdvanceSlotsBy;", "Landroidx/compose/runtime/changelist/Operation$AppendValue;", "Landroidx/compose/runtime/changelist/Operation$ApplyChangeList;", "Landroidx/compose/runtime/changelist/Operation$CopyNodesToNewAnchorLocation;", "Landroidx/compose/runtime/changelist/Operation$CopySlotTableToAnchorLocation;", "Landroidx/compose/runtime/changelist/Operation$DeactivateCurrentGroup;", "Landroidx/compose/runtime/changelist/Operation$DetermineMovableContentNodeIndex;", "Landroidx/compose/runtime/changelist/Operation$Downs;", "Landroidx/compose/runtime/changelist/Operation$EndCompositionScope;", "Landroidx/compose/runtime/changelist/Operation$EndCurrentGroup;", "Landroidx/compose/runtime/changelist/Operation$EndMovableContentPlacement;", "Landroidx/compose/runtime/changelist/Operation$EnsureGroupStarted;", "Landroidx/compose/runtime/changelist/Operation$EnsureRootGroupStarted;", "Landroidx/compose/runtime/changelist/Operation$InsertNodeFixup;", "Landroidx/compose/runtime/changelist/Operation$InsertSlots;", "Landroidx/compose/runtime/changelist/Operation$InsertSlotsWithFixups;", "Landroidx/compose/runtime/changelist/Operation$MoveCurrentGroup;", "Landroidx/compose/runtime/changelist/Operation$MoveNode;", "Landroidx/compose/runtime/changelist/Operation$PostInsertNodeFixup;", "Landroidx/compose/runtime/changelist/Operation$Remember;", "Landroidx/compose/runtime/changelist/Operation$RemoveCurrentGroup;", "Landroidx/compose/runtime/changelist/Operation$RemoveNode;", "Landroidx/compose/runtime/changelist/Operation$ResetSlots;", "Landroidx/compose/runtime/changelist/Operation$SideEffect;", "Landroidx/compose/runtime/changelist/Operation$SkipToEndOfCurrentGroup;", "Landroidx/compose/runtime/changelist/Operation$TrimParentValues;", "Landroidx/compose/runtime/changelist/Operation$UpdateAnchoredValue;", "Landroidx/compose/runtime/changelist/Operation$UpdateAuxData;", "Landroidx/compose/runtime/changelist/Operation$UpdateNode;", "Landroidx/compose/runtime/changelist/Operation$UpdateValue;", "Landroidx/compose/runtime/changelist/Operation$Ups;", "Landroidx/compose/runtime/changelist/Operation$UseCurrentNode;", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class Operation {
    private final int ints;
    private final int objects;

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\bJ/\u0010\u0012\u001a\u00020\u0011*\u00020\n2\n\u0010\f\u001a\u0006\u0012\u0002\b\u00030\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0012\u0010\u0013\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0014"}, d2 = {"Landroidx/compose/runtime/changelist/Operation$AdvanceSlotsBy;", "Landroidx/compose/runtime/changelist/Operation;", "<init>", "()V", "Landroidx/compose/runtime/changelist/Operation$IntParameter;", "parameter", BuildConfig.FLAVOR, "intParamName-w8GmfQM", "(I)Ljava/lang/String;", "intParamName", "Landroidx/compose/runtime/changelist/OperationArgContainer;", "Landroidx/compose/runtime/Applier;", "applier", "Landroidx/compose/runtime/SlotWriter;", "slots", "Landroidx/compose/runtime/RememberManager;", "rememberManager", BuildConfig.FLAVOR, "execute", "(Landroidx/compose/runtime/changelist/OperationArgContainer;Landroidx/compose/runtime/Applier;Landroidx/compose/runtime/SlotWriter;Landroidx/compose/runtime/RememberManager;)V", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class AdvanceSlotsBy extends Operation {
        public static final AdvanceSlotsBy INSTANCE = new AdvanceSlotsBy();

        private AdvanceSlotsBy() {
            super(1, 0, 2, null);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public void execute(OperationArgContainer operationArgContainer, Applier<?> applier, SlotWriter slotWriter, RememberManager rememberManager) {
            slotWriter.advanceBy(operationArgContainer.mo1234getIntw8GmfQM(IntParameter.m1230constructorimpl(0)));
        }

        @Override // androidx.compose.runtime.changelist.Operation
        /* renamed from: intParamName-w8GmfQM */
        public String mo1228intParamNamew8GmfQM(int parameter) {
            return IntParameter.m1231equalsimpl0(parameter, IntParameter.m1230constructorimpl(0)) ? "distance" : super.mo1228intParamNamew8GmfQM(parameter);
        }
    }

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\t\u001a\u00020\u00062\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0004H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\bJ/\u0010\u0012\u001a\u00020\u0011*\u00020\n2\n\u0010\f\u001a\u0006\u0012\u0002\b\u00030\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0012\u0010\u0013\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0014"}, d2 = {"Landroidx/compose/runtime/changelist/Operation$AppendValue;", "Landroidx/compose/runtime/changelist/Operation;", "<init>", "()V", "Landroidx/compose/runtime/changelist/Operation$ObjectParameter;", "parameter", BuildConfig.FLAVOR, "objectParamName-31yXWZQ", "(I)Ljava/lang/String;", "objectParamName", "Landroidx/compose/runtime/changelist/OperationArgContainer;", "Landroidx/compose/runtime/Applier;", "applier", "Landroidx/compose/runtime/SlotWriter;", "slots", "Landroidx/compose/runtime/RememberManager;", "rememberManager", BuildConfig.FLAVOR, "execute", "(Landroidx/compose/runtime/changelist/OperationArgContainer;Landroidx/compose/runtime/Applier;Landroidx/compose/runtime/SlotWriter;Landroidx/compose/runtime/RememberManager;)V", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class AppendValue extends Operation {
        public static final AppendValue INSTANCE = new AppendValue();

        private AppendValue() {
            super(0, 2, 1, null);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public void execute(OperationArgContainer operationArgContainer, Applier<?> applier, SlotWriter slotWriter, RememberManager rememberManager) {
            Anchor anchor = (Anchor) operationArgContainer.mo1235getObject31yXWZQ(ObjectParameter.m1232constructorimpl(0));
            Object mo1235getObject31yXWZQ = operationArgContainer.mo1235getObject31yXWZQ(ObjectParameter.m1232constructorimpl(1));
            if (mo1235getObject31yXWZQ instanceof RememberObserverHolder) {
                rememberManager.remembering(((RememberObserverHolder) mo1235getObject31yXWZQ).getWrapped());
            }
            slotWriter.appendSlot(anchor, mo1235getObject31yXWZQ);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        /* renamed from: objectParamName-31yXWZQ */
        public String mo1229objectParamName31yXWZQ(int parameter) {
            return ObjectParameter.m1233equalsimpl0(parameter, ObjectParameter.m1232constructorimpl(0)) ? "anchor" : ObjectParameter.m1233equalsimpl0(parameter, ObjectParameter.m1232constructorimpl(1)) ? "value" : super.mo1229objectParamName31yXWZQ(parameter);
        }
    }

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\t\u001a\u00020\u00062\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0004H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\bJ/\u0010\u0012\u001a\u00020\u0011*\u00020\n2\n\u0010\f\u001a\u0006\u0012\u0002\b\u00030\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0012\u0010\u0013\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0014"}, d2 = {"Landroidx/compose/runtime/changelist/Operation$ApplyChangeList;", "Landroidx/compose/runtime/changelist/Operation;", "<init>", "()V", "Landroidx/compose/runtime/changelist/Operation$ObjectParameter;", "parameter", BuildConfig.FLAVOR, "objectParamName-31yXWZQ", "(I)Ljava/lang/String;", "objectParamName", "Landroidx/compose/runtime/changelist/OperationArgContainer;", "Landroidx/compose/runtime/Applier;", "applier", "Landroidx/compose/runtime/SlotWriter;", "slots", "Landroidx/compose/runtime/RememberManager;", "rememberManager", BuildConfig.FLAVOR, "execute", "(Landroidx/compose/runtime/changelist/OperationArgContainer;Landroidx/compose/runtime/Applier;Landroidx/compose/runtime/SlotWriter;Landroidx/compose/runtime/RememberManager;)V", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class ApplyChangeList extends Operation {
        public static final ApplyChangeList INSTANCE = new ApplyChangeList();

        private ApplyChangeList() {
            super(0, 2, 1, null);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public void execute(OperationArgContainer operationArgContainer, Applier<?> applier, SlotWriter slotWriter, RememberManager rememberManager) {
            IntRef intRef = (IntRef) operationArgContainer.mo1235getObject31yXWZQ(ObjectParameter.m1232constructorimpl(1));
            int element = intRef != null ? intRef.getElement() : 0;
            ChangeList changeList = (ChangeList) operationArgContainer.mo1235getObject31yXWZQ(ObjectParameter.m1232constructorimpl(0));
            if (element > 0) {
                applier = new OffsetApplier(applier, element);
            }
            changeList.executeAndFlushAllPendingChanges(applier, slotWriter, rememberManager);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        /* renamed from: objectParamName-31yXWZQ */
        public String mo1229objectParamName31yXWZQ(int parameter) {
            return ObjectParameter.m1233equalsimpl0(parameter, ObjectParameter.m1232constructorimpl(0)) ? "changes" : ObjectParameter.m1233equalsimpl0(parameter, ObjectParameter.m1232constructorimpl(1)) ? "effectiveNodeIndex" : super.mo1229objectParamName31yXWZQ(parameter);
        }
    }

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\t\u001a\u00020\u00062\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0004H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\bJ/\u0010\u0012\u001a\u00020\u0011*\u00020\n2\n\u0010\f\u001a\u0006\u0012\u0002\b\u00030\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0012\u0010\u0013\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0014"}, d2 = {"Landroidx/compose/runtime/changelist/Operation$CopyNodesToNewAnchorLocation;", "Landroidx/compose/runtime/changelist/Operation;", "<init>", "()V", "Landroidx/compose/runtime/changelist/Operation$ObjectParameter;", "parameter", BuildConfig.FLAVOR, "objectParamName-31yXWZQ", "(I)Ljava/lang/String;", "objectParamName", "Landroidx/compose/runtime/changelist/OperationArgContainer;", "Landroidx/compose/runtime/Applier;", "applier", "Landroidx/compose/runtime/SlotWriter;", "slots", "Landroidx/compose/runtime/RememberManager;", "rememberManager", BuildConfig.FLAVOR, "execute", "(Landroidx/compose/runtime/changelist/OperationArgContainer;Landroidx/compose/runtime/Applier;Landroidx/compose/runtime/SlotWriter;Landroidx/compose/runtime/RememberManager;)V", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class CopyNodesToNewAnchorLocation extends Operation {
        public static final CopyNodesToNewAnchorLocation INSTANCE = new CopyNodesToNewAnchorLocation();

        private CopyNodesToNewAnchorLocation() {
            super(0, 2, 1, null);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public void execute(OperationArgContainer operationArgContainer, Applier<?> applier, SlotWriter slotWriter, RememberManager rememberManager) {
            int element = ((IntRef) operationArgContainer.mo1235getObject31yXWZQ(ObjectParameter.m1232constructorimpl(0))).getElement();
            List list = (List) operationArgContainer.mo1235getObject31yXWZQ(ObjectParameter.m1232constructorimpl(1));
            int size = list.size();
            for (int i5 = 0; i5 < size; i5++) {
                Object obj = list.get(i5);
                Intrinsics.checkNotNull(applier, "null cannot be cast to non-null type androidx.compose.runtime.Applier<kotlin.Any?>");
                int i6 = element + i5;
                applier.insertBottomUp(i6, obj);
                applier.insertTopDown(i6, obj);
            }
        }

        @Override // androidx.compose.runtime.changelist.Operation
        /* renamed from: objectParamName-31yXWZQ */
        public String mo1229objectParamName31yXWZQ(int parameter) {
            return ObjectParameter.m1233equalsimpl0(parameter, ObjectParameter.m1232constructorimpl(0)) ? "effectiveNodeIndex" : ObjectParameter.m1233equalsimpl0(parameter, ObjectParameter.m1232constructorimpl(1)) ? "nodes" : super.mo1229objectParamName31yXWZQ(parameter);
        }
    }

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\t\u001a\u00020\u00062\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0004H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\bJ/\u0010\u0012\u001a\u00020\u0011*\u00020\n2\n\u0010\f\u001a\u0006\u0012\u0002\b\u00030\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0012\u0010\u0013\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0014"}, d2 = {"Landroidx/compose/runtime/changelist/Operation$CopySlotTableToAnchorLocation;", "Landroidx/compose/runtime/changelist/Operation;", "<init>", "()V", "Landroidx/compose/runtime/changelist/Operation$ObjectParameter;", "parameter", BuildConfig.FLAVOR, "objectParamName-31yXWZQ", "(I)Ljava/lang/String;", "objectParamName", "Landroidx/compose/runtime/changelist/OperationArgContainer;", "Landroidx/compose/runtime/Applier;", "applier", "Landroidx/compose/runtime/SlotWriter;", "slots", "Landroidx/compose/runtime/RememberManager;", "rememberManager", BuildConfig.FLAVOR, "execute", "(Landroidx/compose/runtime/changelist/OperationArgContainer;Landroidx/compose/runtime/Applier;Landroidx/compose/runtime/SlotWriter;Landroidx/compose/runtime/RememberManager;)V", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class CopySlotTableToAnchorLocation extends Operation {
        public static final CopySlotTableToAnchorLocation INSTANCE = new CopySlotTableToAnchorLocation();

        private CopySlotTableToAnchorLocation() {
            super(0, 4, 1, null);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public void execute(OperationArgContainer operationArgContainer, Applier<?> applier, SlotWriter slotWriter, RememberManager rememberManager) {
            MovableContentStateReference movableContentStateReference = (MovableContentStateReference) operationArgContainer.mo1235getObject31yXWZQ(ObjectParameter.m1232constructorimpl(2));
            CompositionContext compositionContext = (CompositionContext) operationArgContainer.mo1235getObject31yXWZQ(ObjectParameter.m1232constructorimpl(1));
            compositionContext.movableContentStateResolve$runtime_release(movableContentStateReference);
            ComposerKt.composeRuntimeError("Could not resolve state for movable content");
            throw new KotlinNothingValueException();
        }

        @Override // androidx.compose.runtime.changelist.Operation
        /* renamed from: objectParamName-31yXWZQ */
        public String mo1229objectParamName31yXWZQ(int parameter) {
            return ObjectParameter.m1233equalsimpl0(parameter, ObjectParameter.m1232constructorimpl(0)) ? "resolvedState" : ObjectParameter.m1233equalsimpl0(parameter, ObjectParameter.m1232constructorimpl(1)) ? "resolvedCompositionContext" : ObjectParameter.m1233equalsimpl0(parameter, ObjectParameter.m1232constructorimpl(2)) ? "from" : ObjectParameter.m1233equalsimpl0(parameter, ObjectParameter.m1232constructorimpl(3)) ? "to" : super.mo1229objectParamName31yXWZQ(parameter);
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J(\u0010\u0003\u001a\u00020\u0004*\u00020\u00052\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, d2 = {"Landroidx/compose/runtime/changelist/Operation$DeactivateCurrentGroup;", "Landroidx/compose/runtime/changelist/Operation;", "()V", "execute", BuildConfig.FLAVOR, "Landroidx/compose/runtime/changelist/OperationArgContainer;", "applier", "Landroidx/compose/runtime/Applier;", "slots", "Landroidx/compose/runtime/SlotWriter;", "rememberManager", "Landroidx/compose/runtime/RememberManager;", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class DeactivateCurrentGroup extends Operation {
        public static final DeactivateCurrentGroup INSTANCE = new DeactivateCurrentGroup();

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private DeactivateCurrentGroup() {
            super(r2, r2, 3, null);
            int i5 = 0;
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public void execute(OperationArgContainer operationArgContainer, Applier<?> applier, SlotWriter slotWriter, RememberManager rememberManager) {
            ComposerKt.deactivateCurrentGroup(slotWriter, rememberManager);
        }
    }

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\t\u001a\u00020\u00062\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0004H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\bJ/\u0010\u0012\u001a\u00020\u0011*\u00020\n2\n\u0010\f\u001a\u0006\u0012\u0002\b\u00030\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0012\u0010\u0013\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0014"}, d2 = {"Landroidx/compose/runtime/changelist/Operation$DetermineMovableContentNodeIndex;", "Landroidx/compose/runtime/changelist/Operation;", "<init>", "()V", "Landroidx/compose/runtime/changelist/Operation$ObjectParameter;", "parameter", BuildConfig.FLAVOR, "objectParamName-31yXWZQ", "(I)Ljava/lang/String;", "objectParamName", "Landroidx/compose/runtime/changelist/OperationArgContainer;", "Landroidx/compose/runtime/Applier;", "applier", "Landroidx/compose/runtime/SlotWriter;", "slots", "Landroidx/compose/runtime/RememberManager;", "rememberManager", BuildConfig.FLAVOR, "execute", "(Landroidx/compose/runtime/changelist/OperationArgContainer;Landroidx/compose/runtime/Applier;Landroidx/compose/runtime/SlotWriter;Landroidx/compose/runtime/RememberManager;)V", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class DetermineMovableContentNodeIndex extends Operation {
        public static final DetermineMovableContentNodeIndex INSTANCE = new DetermineMovableContentNodeIndex();

        private DetermineMovableContentNodeIndex() {
            super(0, 2, 1, null);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public void execute(OperationArgContainer operationArgContainer, Applier<?> applier, SlotWriter slotWriter, RememberManager rememberManager) {
            int positionToInsert;
            IntRef intRef = (IntRef) operationArgContainer.mo1235getObject31yXWZQ(ObjectParameter.m1232constructorimpl(0));
            Anchor anchor = (Anchor) operationArgContainer.mo1235getObject31yXWZQ(ObjectParameter.m1232constructorimpl(1));
            Intrinsics.checkNotNull(applier, "null cannot be cast to non-null type androidx.compose.runtime.Applier<kotlin.Any?>");
            positionToInsert = OperationKt.positionToInsert(slotWriter, anchor, applier);
            intRef.setElement(positionToInsert);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        /* renamed from: objectParamName-31yXWZQ */
        public String mo1229objectParamName31yXWZQ(int parameter) {
            return ObjectParameter.m1233equalsimpl0(parameter, ObjectParameter.m1232constructorimpl(0)) ? "effectiveNodeIndexOut" : ObjectParameter.m1233equalsimpl0(parameter, ObjectParameter.m1232constructorimpl(1)) ? "anchor" : super.mo1229objectParamName31yXWZQ(parameter);
        }
    }

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\t\u001a\u00020\u00062\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0004H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\bJ/\u0010\u0012\u001a\u00020\u0011*\u00020\n2\n\u0010\f\u001a\u0006\u0012\u0002\b\u00030\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0012\u0010\u0013\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0014"}, d2 = {"Landroidx/compose/runtime/changelist/Operation$Downs;", "Landroidx/compose/runtime/changelist/Operation;", "<init>", "()V", "Landroidx/compose/runtime/changelist/Operation$ObjectParameter;", "parameter", BuildConfig.FLAVOR, "objectParamName-31yXWZQ", "(I)Ljava/lang/String;", "objectParamName", "Landroidx/compose/runtime/changelist/OperationArgContainer;", "Landroidx/compose/runtime/Applier;", "applier", "Landroidx/compose/runtime/SlotWriter;", "slots", "Landroidx/compose/runtime/RememberManager;", "rememberManager", BuildConfig.FLAVOR, "execute", "(Landroidx/compose/runtime/changelist/OperationArgContainer;Landroidx/compose/runtime/Applier;Landroidx/compose/runtime/SlotWriter;Landroidx/compose/runtime/RememberManager;)V", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Downs extends Operation {
        public static final Downs INSTANCE = new Downs();

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private Downs() {
            super(0, r0, r0, null);
            int i5 = 1;
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public void execute(OperationArgContainer operationArgContainer, Applier<?> applier, SlotWriter slotWriter, RememberManager rememberManager) {
            Intrinsics.checkNotNull(applier, "null cannot be cast to non-null type androidx.compose.runtime.Applier<kotlin.Any?>");
            for (Object obj : (Object[]) operationArgContainer.mo1235getObject31yXWZQ(ObjectParameter.m1232constructorimpl(0))) {
                applier.down(obj);
            }
        }

        @Override // androidx.compose.runtime.changelist.Operation
        /* renamed from: objectParamName-31yXWZQ */
        public String mo1229objectParamName31yXWZQ(int parameter) {
            return ObjectParameter.m1233equalsimpl0(parameter, ObjectParameter.m1232constructorimpl(0)) ? "nodes" : super.mo1229objectParamName31yXWZQ(parameter);
        }
    }

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\t\u001a\u00020\u00062\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0004H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\bJ/\u0010\u0012\u001a\u00020\u0011*\u00020\n2\n\u0010\f\u001a\u0006\u0012\u0002\b\u00030\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0012\u0010\u0013\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0014"}, d2 = {"Landroidx/compose/runtime/changelist/Operation$EndCompositionScope;", "Landroidx/compose/runtime/changelist/Operation;", "<init>", "()V", "Landroidx/compose/runtime/changelist/Operation$ObjectParameter;", "parameter", BuildConfig.FLAVOR, "objectParamName-31yXWZQ", "(I)Ljava/lang/String;", "objectParamName", "Landroidx/compose/runtime/changelist/OperationArgContainer;", "Landroidx/compose/runtime/Applier;", "applier", "Landroidx/compose/runtime/SlotWriter;", "slots", "Landroidx/compose/runtime/RememberManager;", "rememberManager", BuildConfig.FLAVOR, "execute", "(Landroidx/compose/runtime/changelist/OperationArgContainer;Landroidx/compose/runtime/Applier;Landroidx/compose/runtime/SlotWriter;Landroidx/compose/runtime/RememberManager;)V", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class EndCompositionScope extends Operation {
        public static final EndCompositionScope INSTANCE = new EndCompositionScope();

        private EndCompositionScope() {
            super(0, 2, 1, null);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public void execute(OperationArgContainer operationArgContainer, Applier<?> applier, SlotWriter slotWriter, RememberManager rememberManager) {
            ((Function1) operationArgContainer.mo1235getObject31yXWZQ(ObjectParameter.m1232constructorimpl(0))).invoke((Composition) operationArgContainer.mo1235getObject31yXWZQ(ObjectParameter.m1232constructorimpl(1)));
        }

        @Override // androidx.compose.runtime.changelist.Operation
        /* renamed from: objectParamName-31yXWZQ */
        public String mo1229objectParamName31yXWZQ(int parameter) {
            return ObjectParameter.m1233equalsimpl0(parameter, ObjectParameter.m1232constructorimpl(0)) ? "anchor" : ObjectParameter.m1233equalsimpl0(parameter, ObjectParameter.m1232constructorimpl(1)) ? "composition" : super.mo1229objectParamName31yXWZQ(parameter);
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J(\u0010\u0003\u001a\u00020\u0004*\u00020\u00052\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, d2 = {"Landroidx/compose/runtime/changelist/Operation$EndCurrentGroup;", "Landroidx/compose/runtime/changelist/Operation;", "()V", "execute", BuildConfig.FLAVOR, "Landroidx/compose/runtime/changelist/OperationArgContainer;", "applier", "Landroidx/compose/runtime/Applier;", "slots", "Landroidx/compose/runtime/SlotWriter;", "rememberManager", "Landroidx/compose/runtime/RememberManager;", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class EndCurrentGroup extends Operation {
        public static final EndCurrentGroup INSTANCE = new EndCurrentGroup();

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private EndCurrentGroup() {
            super(r2, r2, 3, null);
            int i5 = 0;
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public void execute(OperationArgContainer operationArgContainer, Applier<?> applier, SlotWriter slotWriter, RememberManager rememberManager) {
            slotWriter.endGroup();
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J(\u0010\u0003\u001a\u00020\u0004*\u00020\u00052\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, d2 = {"Landroidx/compose/runtime/changelist/Operation$EndMovableContentPlacement;", "Landroidx/compose/runtime/changelist/Operation;", "()V", "execute", BuildConfig.FLAVOR, "Landroidx/compose/runtime/changelist/OperationArgContainer;", "applier", "Landroidx/compose/runtime/Applier;", "slots", "Landroidx/compose/runtime/SlotWriter;", "rememberManager", "Landroidx/compose/runtime/RememberManager;", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class EndMovableContentPlacement extends Operation {
        public static final EndMovableContentPlacement INSTANCE = new EndMovableContentPlacement();

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private EndMovableContentPlacement() {
            super(r2, r2, 3, null);
            int i5 = 0;
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public void execute(OperationArgContainer operationArgContainer, Applier<?> applier, SlotWriter slotWriter, RememberManager rememberManager) {
            Intrinsics.checkNotNull(applier, "null cannot be cast to non-null type androidx.compose.runtime.Applier<kotlin.Any?>");
            OperationKt.positionToParentOf(slotWriter, applier, 0);
            slotWriter.endGroup();
        }
    }

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\t\u001a\u00020\u00062\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0004H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\bJ/\u0010\u0012\u001a\u00020\u0011*\u00020\n2\n\u0010\f\u001a\u0006\u0012\u0002\b\u00030\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0012\u0010\u0013\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0014"}, d2 = {"Landroidx/compose/runtime/changelist/Operation$EnsureGroupStarted;", "Landroidx/compose/runtime/changelist/Operation;", "<init>", "()V", "Landroidx/compose/runtime/changelist/Operation$ObjectParameter;", "parameter", BuildConfig.FLAVOR, "objectParamName-31yXWZQ", "(I)Ljava/lang/String;", "objectParamName", "Landroidx/compose/runtime/changelist/OperationArgContainer;", "Landroidx/compose/runtime/Applier;", "applier", "Landroidx/compose/runtime/SlotWriter;", "slots", "Landroidx/compose/runtime/RememberManager;", "rememberManager", BuildConfig.FLAVOR, "execute", "(Landroidx/compose/runtime/changelist/OperationArgContainer;Landroidx/compose/runtime/Applier;Landroidx/compose/runtime/SlotWriter;Landroidx/compose/runtime/RememberManager;)V", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class EnsureGroupStarted extends Operation {
        public static final EnsureGroupStarted INSTANCE = new EnsureGroupStarted();

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private EnsureGroupStarted() {
            super(0, r0, r0, null);
            int i5 = 1;
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public void execute(OperationArgContainer operationArgContainer, Applier<?> applier, SlotWriter slotWriter, RememberManager rememberManager) {
            slotWriter.ensureStarted((Anchor) operationArgContainer.mo1235getObject31yXWZQ(ObjectParameter.m1232constructorimpl(0)));
        }

        @Override // androidx.compose.runtime.changelist.Operation
        /* renamed from: objectParamName-31yXWZQ */
        public String mo1229objectParamName31yXWZQ(int parameter) {
            return ObjectParameter.m1233equalsimpl0(parameter, ObjectParameter.m1232constructorimpl(0)) ? "anchor" : super.mo1229objectParamName31yXWZQ(parameter);
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J(\u0010\u0003\u001a\u00020\u0004*\u00020\u00052\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, d2 = {"Landroidx/compose/runtime/changelist/Operation$EnsureRootGroupStarted;", "Landroidx/compose/runtime/changelist/Operation;", "()V", "execute", BuildConfig.FLAVOR, "Landroidx/compose/runtime/changelist/OperationArgContainer;", "applier", "Landroidx/compose/runtime/Applier;", "slots", "Landroidx/compose/runtime/SlotWriter;", "rememberManager", "Landroidx/compose/runtime/RememberManager;", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class EnsureRootGroupStarted extends Operation {
        public static final EnsureRootGroupStarted INSTANCE = new EnsureRootGroupStarted();

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private EnsureRootGroupStarted() {
            super(r2, r2, 3, null);
            int i5 = 0;
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public void execute(OperationArgContainer operationArgContainer, Applier<?> applier, SlotWriter slotWriter, RememberManager rememberManager) {
            slotWriter.ensureStarted(0);
        }
    }

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\bJ\u001e\u0010\f\u001a\u00020\u00062\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\nH\u0016ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\bJ/\u0010\u0015\u001a\u00020\u0014*\u00020\r2\n\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0015\u0010\u0016\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0017"}, d2 = {"Landroidx/compose/runtime/changelist/Operation$InsertNodeFixup;", "Landroidx/compose/runtime/changelist/Operation;", "<init>", "()V", "Landroidx/compose/runtime/changelist/Operation$IntParameter;", "parameter", BuildConfig.FLAVOR, "intParamName-w8GmfQM", "(I)Ljava/lang/String;", "intParamName", "Landroidx/compose/runtime/changelist/Operation$ObjectParameter;", "objectParamName-31yXWZQ", "objectParamName", "Landroidx/compose/runtime/changelist/OperationArgContainer;", "Landroidx/compose/runtime/Applier;", "applier", "Landroidx/compose/runtime/SlotWriter;", "slots", "Landroidx/compose/runtime/RememberManager;", "rememberManager", BuildConfig.FLAVOR, "execute", "(Landroidx/compose/runtime/changelist/OperationArgContainer;Landroidx/compose/runtime/Applier;Landroidx/compose/runtime/SlotWriter;Landroidx/compose/runtime/RememberManager;)V", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class InsertNodeFixup extends Operation {
        public static final InsertNodeFixup INSTANCE = new InsertNodeFixup();

        private InsertNodeFixup() {
            super(1, 2, null);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public void execute(OperationArgContainer operationArgContainer, Applier<?> applier, SlotWriter slotWriter, RememberManager rememberManager) {
            Object invoke = ((Function0) operationArgContainer.mo1235getObject31yXWZQ(ObjectParameter.m1232constructorimpl(0))).invoke();
            Anchor anchor = (Anchor) operationArgContainer.mo1235getObject31yXWZQ(ObjectParameter.m1232constructorimpl(1));
            int mo1234getIntw8GmfQM = operationArgContainer.mo1234getIntw8GmfQM(IntParameter.m1230constructorimpl(0));
            Intrinsics.checkNotNull(applier, "null cannot be cast to non-null type androidx.compose.runtime.Applier<kotlin.Any?>");
            slotWriter.updateNode(anchor, invoke);
            applier.insertTopDown(mo1234getIntw8GmfQM, invoke);
            applier.down(invoke);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        /* renamed from: intParamName-w8GmfQM */
        public String mo1228intParamNamew8GmfQM(int parameter) {
            return IntParameter.m1231equalsimpl0(parameter, IntParameter.m1230constructorimpl(0)) ? "insertIndex" : super.mo1228intParamNamew8GmfQM(parameter);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        /* renamed from: objectParamName-31yXWZQ */
        public String mo1229objectParamName31yXWZQ(int parameter) {
            return ObjectParameter.m1233equalsimpl0(parameter, ObjectParameter.m1232constructorimpl(0)) ? "factory" : ObjectParameter.m1233equalsimpl0(parameter, ObjectParameter.m1232constructorimpl(1)) ? "groupAnchor" : super.mo1229objectParamName31yXWZQ(parameter);
        }
    }

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\t\u001a\u00020\u00062\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0004H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\bJ/\u0010\u0012\u001a\u00020\u0011*\u00020\n2\n\u0010\f\u001a\u0006\u0012\u0002\b\u00030\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0012\u0010\u0013\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0014"}, d2 = {"Landroidx/compose/runtime/changelist/Operation$InsertSlots;", "Landroidx/compose/runtime/changelist/Operation;", "<init>", "()V", "Landroidx/compose/runtime/changelist/Operation$ObjectParameter;", "parameter", BuildConfig.FLAVOR, "objectParamName-31yXWZQ", "(I)Ljava/lang/String;", "objectParamName", "Landroidx/compose/runtime/changelist/OperationArgContainer;", "Landroidx/compose/runtime/Applier;", "applier", "Landroidx/compose/runtime/SlotWriter;", "slots", "Landroidx/compose/runtime/RememberManager;", "rememberManager", BuildConfig.FLAVOR, "execute", "(Landroidx/compose/runtime/changelist/OperationArgContainer;Landroidx/compose/runtime/Applier;Landroidx/compose/runtime/SlotWriter;Landroidx/compose/runtime/RememberManager;)V", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class InsertSlots extends Operation {
        public static final InsertSlots INSTANCE = new InsertSlots();

        private InsertSlots() {
            super(0, 2, 1, null);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public void execute(OperationArgContainer operationArgContainer, Applier<?> applier, SlotWriter slotWriter, RememberManager rememberManager) {
            SlotTable slotTable = (SlotTable) operationArgContainer.mo1235getObject31yXWZQ(ObjectParameter.m1232constructorimpl(1));
            Anchor anchor = (Anchor) operationArgContainer.mo1235getObject31yXWZQ(ObjectParameter.m1232constructorimpl(0));
            slotWriter.beginInsert();
            slotWriter.moveFrom(slotTable, anchor.toIndexFor(slotTable), false);
            slotWriter.endInsert();
        }

        @Override // androidx.compose.runtime.changelist.Operation
        /* renamed from: objectParamName-31yXWZQ */
        public String mo1229objectParamName31yXWZQ(int parameter) {
            return ObjectParameter.m1233equalsimpl0(parameter, ObjectParameter.m1232constructorimpl(0)) ? "anchor" : ObjectParameter.m1233equalsimpl0(parameter, ObjectParameter.m1232constructorimpl(1)) ? "from" : super.mo1229objectParamName31yXWZQ(parameter);
        }
    }

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\t\u001a\u00020\u00062\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0004H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\bJ/\u0010\u0012\u001a\u00020\u0011*\u00020\n2\n\u0010\f\u001a\u0006\u0012\u0002\b\u00030\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0012\u0010\u0013\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0014"}, d2 = {"Landroidx/compose/runtime/changelist/Operation$InsertSlotsWithFixups;", "Landroidx/compose/runtime/changelist/Operation;", "<init>", "()V", "Landroidx/compose/runtime/changelist/Operation$ObjectParameter;", "parameter", BuildConfig.FLAVOR, "objectParamName-31yXWZQ", "(I)Ljava/lang/String;", "objectParamName", "Landroidx/compose/runtime/changelist/OperationArgContainer;", "Landroidx/compose/runtime/Applier;", "applier", "Landroidx/compose/runtime/SlotWriter;", "slots", "Landroidx/compose/runtime/RememberManager;", "rememberManager", BuildConfig.FLAVOR, "execute", "(Landroidx/compose/runtime/changelist/OperationArgContainer;Landroidx/compose/runtime/Applier;Landroidx/compose/runtime/SlotWriter;Landroidx/compose/runtime/RememberManager;)V", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class InsertSlotsWithFixups extends Operation {
        public static final InsertSlotsWithFixups INSTANCE = new InsertSlotsWithFixups();

        private InsertSlotsWithFixups() {
            super(0, 3, 1, null);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public void execute(OperationArgContainer operationArgContainer, Applier<?> applier, SlotWriter slotWriter, RememberManager rememberManager) {
            SlotTable slotTable = (SlotTable) operationArgContainer.mo1235getObject31yXWZQ(ObjectParameter.m1232constructorimpl(1));
            Anchor anchor = (Anchor) operationArgContainer.mo1235getObject31yXWZQ(ObjectParameter.m1232constructorimpl(0));
            FixupList fixupList = (FixupList) operationArgContainer.mo1235getObject31yXWZQ(ObjectParameter.m1232constructorimpl(2));
            SlotWriter openWriter = slotTable.openWriter();
            try {
                fixupList.executeAndFlushAllPendingFixups(applier, openWriter, rememberManager);
                Unit unit = Unit.INSTANCE;
                openWriter.close(true);
                slotWriter.beginInsert();
                slotWriter.moveFrom(slotTable, anchor.toIndexFor(slotTable), false);
                slotWriter.endInsert();
            } catch (Throwable th) {
                openWriter.close(false);
                throw th;
            }
        }

        @Override // androidx.compose.runtime.changelist.Operation
        /* renamed from: objectParamName-31yXWZQ */
        public String mo1229objectParamName31yXWZQ(int parameter) {
            return ObjectParameter.m1233equalsimpl0(parameter, ObjectParameter.m1232constructorimpl(0)) ? "anchor" : ObjectParameter.m1233equalsimpl0(parameter, ObjectParameter.m1232constructorimpl(1)) ? "from" : ObjectParameter.m1233equalsimpl0(parameter, ObjectParameter.m1232constructorimpl(2)) ? "fixups" : super.mo1229objectParamName31yXWZQ(parameter);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0087@\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005\u0088\u0001\u0003\u0092\u0001\u00020\u0002¨\u0006\u0006"}, d2 = {"Landroidx/compose/runtime/changelist/Operation$IntParameter;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "offset", "constructor-impl", "(I)I", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class IntParameter {
        /* renamed from: constructor-impl, reason: not valid java name */
        public static int m1230constructorimpl(int i5) {
            return i5;
        }

        /* renamed from: equals-impl0, reason: not valid java name */
        public static final boolean m1231equalsimpl0(int i5, int i6) {
            return i5 == i6;
        }
    }

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\bJ/\u0010\u0012\u001a\u00020\u0011*\u00020\n2\n\u0010\f\u001a\u0006\u0012\u0002\b\u00030\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0012\u0010\u0013\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0014"}, d2 = {"Landroidx/compose/runtime/changelist/Operation$MoveCurrentGroup;", "Landroidx/compose/runtime/changelist/Operation;", "<init>", "()V", "Landroidx/compose/runtime/changelist/Operation$IntParameter;", "parameter", BuildConfig.FLAVOR, "intParamName-w8GmfQM", "(I)Ljava/lang/String;", "intParamName", "Landroidx/compose/runtime/changelist/OperationArgContainer;", "Landroidx/compose/runtime/Applier;", "applier", "Landroidx/compose/runtime/SlotWriter;", "slots", "Landroidx/compose/runtime/RememberManager;", "rememberManager", BuildConfig.FLAVOR, "execute", "(Landroidx/compose/runtime/changelist/OperationArgContainer;Landroidx/compose/runtime/Applier;Landroidx/compose/runtime/SlotWriter;Landroidx/compose/runtime/RememberManager;)V", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class MoveCurrentGroup extends Operation {
        public static final MoveCurrentGroup INSTANCE = new MoveCurrentGroup();

        private MoveCurrentGroup() {
            super(1, 0, 2, null);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public void execute(OperationArgContainer operationArgContainer, Applier<?> applier, SlotWriter slotWriter, RememberManager rememberManager) {
            slotWriter.moveGroup(operationArgContainer.mo1234getIntw8GmfQM(IntParameter.m1230constructorimpl(0)));
        }

        @Override // androidx.compose.runtime.changelist.Operation
        /* renamed from: intParamName-w8GmfQM */
        public String mo1228intParamNamew8GmfQM(int parameter) {
            return IntParameter.m1231equalsimpl0(parameter, IntParameter.m1230constructorimpl(0)) ? "offset" : super.mo1228intParamNamew8GmfQM(parameter);
        }
    }

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\bJ/\u0010\u0012\u001a\u00020\u0011*\u00020\n2\n\u0010\f\u001a\u0006\u0012\u0002\b\u00030\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0012\u0010\u0013\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0014"}, d2 = {"Landroidx/compose/runtime/changelist/Operation$MoveNode;", "Landroidx/compose/runtime/changelist/Operation;", "<init>", "()V", "Landroidx/compose/runtime/changelist/Operation$IntParameter;", "parameter", BuildConfig.FLAVOR, "intParamName-w8GmfQM", "(I)Ljava/lang/String;", "intParamName", "Landroidx/compose/runtime/changelist/OperationArgContainer;", "Landroidx/compose/runtime/Applier;", "applier", "Landroidx/compose/runtime/SlotWriter;", "slots", "Landroidx/compose/runtime/RememberManager;", "rememberManager", BuildConfig.FLAVOR, "execute", "(Landroidx/compose/runtime/changelist/OperationArgContainer;Landroidx/compose/runtime/Applier;Landroidx/compose/runtime/SlotWriter;Landroidx/compose/runtime/RememberManager;)V", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class MoveNode extends Operation {
        public static final MoveNode INSTANCE = new MoveNode();

        private MoveNode() {
            super(3, 0, 2, null);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public void execute(OperationArgContainer operationArgContainer, Applier<?> applier, SlotWriter slotWriter, RememberManager rememberManager) {
            applier.move(operationArgContainer.mo1234getIntw8GmfQM(IntParameter.m1230constructorimpl(0)), operationArgContainer.mo1234getIntw8GmfQM(IntParameter.m1230constructorimpl(1)), operationArgContainer.mo1234getIntw8GmfQM(IntParameter.m1230constructorimpl(2)));
        }

        @Override // androidx.compose.runtime.changelist.Operation
        /* renamed from: intParamName-w8GmfQM */
        public String mo1228intParamNamew8GmfQM(int parameter) {
            return IntParameter.m1231equalsimpl0(parameter, IntParameter.m1230constructorimpl(0)) ? "from" : IntParameter.m1231equalsimpl0(parameter, IntParameter.m1230constructorimpl(1)) ? "to" : IntParameter.m1231equalsimpl0(parameter, IntParameter.m1230constructorimpl(2)) ? "count" : super.mo1228intParamNamew8GmfQM(parameter);
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0087@\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006\u0088\u0001\u0004\u0092\u0001\u00020\u0003¨\u0006\u0007"}, d2 = {"Landroidx/compose/runtime/changelist/Operation$ObjectParameter;", "T", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "offset", "constructor-impl", "(I)I", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class ObjectParameter<T> {
        /* renamed from: constructor-impl, reason: not valid java name */
        public static <T> int m1232constructorimpl(int i5) {
            return i5;
        }

        /* renamed from: equals-impl0, reason: not valid java name */
        public static final boolean m1233equalsimpl0(int i5, int i6) {
            return i5 == i6;
        }
    }

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\bJ\u001e\u0010\f\u001a\u00020\u00062\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\nH\u0016ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\bJ/\u0010\u0015\u001a\u00020\u0014*\u00020\r2\n\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0015\u0010\u0016\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0017"}, d2 = {"Landroidx/compose/runtime/changelist/Operation$PostInsertNodeFixup;", "Landroidx/compose/runtime/changelist/Operation;", "<init>", "()V", "Landroidx/compose/runtime/changelist/Operation$IntParameter;", "parameter", BuildConfig.FLAVOR, "intParamName-w8GmfQM", "(I)Ljava/lang/String;", "intParamName", "Landroidx/compose/runtime/changelist/Operation$ObjectParameter;", "objectParamName-31yXWZQ", "objectParamName", "Landroidx/compose/runtime/changelist/OperationArgContainer;", "Landroidx/compose/runtime/Applier;", "applier", "Landroidx/compose/runtime/SlotWriter;", "slots", "Landroidx/compose/runtime/RememberManager;", "rememberManager", BuildConfig.FLAVOR, "execute", "(Landroidx/compose/runtime/changelist/OperationArgContainer;Landroidx/compose/runtime/Applier;Landroidx/compose/runtime/SlotWriter;Landroidx/compose/runtime/RememberManager;)V", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class PostInsertNodeFixup extends Operation {
        public static final PostInsertNodeFixup INSTANCE = new PostInsertNodeFixup();

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private PostInsertNodeFixup() {
            super(r0, r0, null);
            int i5 = 1;
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public void execute(OperationArgContainer operationArgContainer, Applier<?> applier, SlotWriter slotWriter, RememberManager rememberManager) {
            Anchor anchor = (Anchor) operationArgContainer.mo1235getObject31yXWZQ(ObjectParameter.m1232constructorimpl(0));
            int mo1234getIntw8GmfQM = operationArgContainer.mo1234getIntw8GmfQM(IntParameter.m1230constructorimpl(0));
            applier.up();
            Intrinsics.checkNotNull(applier, "null cannot be cast to non-null type androidx.compose.runtime.Applier<kotlin.Any?>");
            applier.insertBottomUp(mo1234getIntw8GmfQM, slotWriter.node(anchor));
        }

        @Override // androidx.compose.runtime.changelist.Operation
        /* renamed from: intParamName-w8GmfQM */
        public String mo1228intParamNamew8GmfQM(int parameter) {
            return IntParameter.m1231equalsimpl0(parameter, IntParameter.m1230constructorimpl(0)) ? "insertIndex" : super.mo1228intParamNamew8GmfQM(parameter);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        /* renamed from: objectParamName-31yXWZQ */
        public String mo1229objectParamName31yXWZQ(int parameter) {
            return ObjectParameter.m1233equalsimpl0(parameter, ObjectParameter.m1232constructorimpl(0)) ? "groupAnchor" : super.mo1229objectParamName31yXWZQ(parameter);
        }
    }

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\t\u001a\u00020\u00062\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0004H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\bJ/\u0010\u0012\u001a\u00020\u0011*\u00020\n2\n\u0010\f\u001a\u0006\u0012\u0002\b\u00030\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0012\u0010\u0013\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0014"}, d2 = {"Landroidx/compose/runtime/changelist/Operation$Remember;", "Landroidx/compose/runtime/changelist/Operation;", "<init>", "()V", "Landroidx/compose/runtime/changelist/Operation$ObjectParameter;", "parameter", BuildConfig.FLAVOR, "objectParamName-31yXWZQ", "(I)Ljava/lang/String;", "objectParamName", "Landroidx/compose/runtime/changelist/OperationArgContainer;", "Landroidx/compose/runtime/Applier;", "applier", "Landroidx/compose/runtime/SlotWriter;", "slots", "Landroidx/compose/runtime/RememberManager;", "rememberManager", BuildConfig.FLAVOR, "execute", "(Landroidx/compose/runtime/changelist/OperationArgContainer;Landroidx/compose/runtime/Applier;Landroidx/compose/runtime/SlotWriter;Landroidx/compose/runtime/RememberManager;)V", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Remember extends Operation {
        public static final Remember INSTANCE = new Remember();

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private Remember() {
            super(0, r0, r0, null);
            int i5 = 1;
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public void execute(OperationArgContainer operationArgContainer, Applier<?> applier, SlotWriter slotWriter, RememberManager rememberManager) {
            rememberManager.remembering((RememberObserver) operationArgContainer.mo1235getObject31yXWZQ(ObjectParameter.m1232constructorimpl(0)));
        }

        @Override // androidx.compose.runtime.changelist.Operation
        /* renamed from: objectParamName-31yXWZQ */
        public String mo1229objectParamName31yXWZQ(int parameter) {
            return ObjectParameter.m1233equalsimpl0(parameter, ObjectParameter.m1232constructorimpl(0)) ? "value" : super.mo1229objectParamName31yXWZQ(parameter);
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J(\u0010\u0003\u001a\u00020\u0004*\u00020\u00052\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, d2 = {"Landroidx/compose/runtime/changelist/Operation$RemoveCurrentGroup;", "Landroidx/compose/runtime/changelist/Operation;", "()V", "execute", BuildConfig.FLAVOR, "Landroidx/compose/runtime/changelist/OperationArgContainer;", "applier", "Landroidx/compose/runtime/Applier;", "slots", "Landroidx/compose/runtime/SlotWriter;", "rememberManager", "Landroidx/compose/runtime/RememberManager;", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class RemoveCurrentGroup extends Operation {
        public static final RemoveCurrentGroup INSTANCE = new RemoveCurrentGroup();

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private RemoveCurrentGroup() {
            super(r2, r2, 3, null);
            int i5 = 0;
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public void execute(OperationArgContainer operationArgContainer, Applier<?> applier, SlotWriter slotWriter, RememberManager rememberManager) {
            ComposerKt.removeCurrentGroup(slotWriter, rememberManager);
        }
    }

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\bJ/\u0010\u0012\u001a\u00020\u0011*\u00020\n2\n\u0010\f\u001a\u0006\u0012\u0002\b\u00030\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0012\u0010\u0013\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0014"}, d2 = {"Landroidx/compose/runtime/changelist/Operation$RemoveNode;", "Landroidx/compose/runtime/changelist/Operation;", "<init>", "()V", "Landroidx/compose/runtime/changelist/Operation$IntParameter;", "parameter", BuildConfig.FLAVOR, "intParamName-w8GmfQM", "(I)Ljava/lang/String;", "intParamName", "Landroidx/compose/runtime/changelist/OperationArgContainer;", "Landroidx/compose/runtime/Applier;", "applier", "Landroidx/compose/runtime/SlotWriter;", "slots", "Landroidx/compose/runtime/RememberManager;", "rememberManager", BuildConfig.FLAVOR, "execute", "(Landroidx/compose/runtime/changelist/OperationArgContainer;Landroidx/compose/runtime/Applier;Landroidx/compose/runtime/SlotWriter;Landroidx/compose/runtime/RememberManager;)V", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class RemoveNode extends Operation {
        public static final RemoveNode INSTANCE = new RemoveNode();

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private RemoveNode() {
            super(r2, 0, r2, null);
            int i5 = 2;
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public void execute(OperationArgContainer operationArgContainer, Applier<?> applier, SlotWriter slotWriter, RememberManager rememberManager) {
            applier.remove(operationArgContainer.mo1234getIntw8GmfQM(IntParameter.m1230constructorimpl(0)), operationArgContainer.mo1234getIntw8GmfQM(IntParameter.m1230constructorimpl(1)));
        }

        @Override // androidx.compose.runtime.changelist.Operation
        /* renamed from: intParamName-w8GmfQM */
        public String mo1228intParamNamew8GmfQM(int parameter) {
            return IntParameter.m1231equalsimpl0(parameter, IntParameter.m1230constructorimpl(0)) ? "removeIndex" : IntParameter.m1231equalsimpl0(parameter, IntParameter.m1230constructorimpl(1)) ? "count" : super.mo1228intParamNamew8GmfQM(parameter);
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J(\u0010\u0003\u001a\u00020\u0004*\u00020\u00052\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, d2 = {"Landroidx/compose/runtime/changelist/Operation$ResetSlots;", "Landroidx/compose/runtime/changelist/Operation;", "()V", "execute", BuildConfig.FLAVOR, "Landroidx/compose/runtime/changelist/OperationArgContainer;", "applier", "Landroidx/compose/runtime/Applier;", "slots", "Landroidx/compose/runtime/SlotWriter;", "rememberManager", "Landroidx/compose/runtime/RememberManager;", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class ResetSlots extends Operation {
        public static final ResetSlots INSTANCE = new ResetSlots();

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private ResetSlots() {
            super(r2, r2, 3, null);
            int i5 = 0;
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public void execute(OperationArgContainer operationArgContainer, Applier<?> applier, SlotWriter slotWriter, RememberManager rememberManager) {
            slotWriter.reset();
        }
    }

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\t\u001a\u00020\u00062\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0004H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\bJ/\u0010\u0012\u001a\u00020\u0011*\u00020\n2\n\u0010\f\u001a\u0006\u0012\u0002\b\u00030\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0012\u0010\u0013\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0014"}, d2 = {"Landroidx/compose/runtime/changelist/Operation$SideEffect;", "Landroidx/compose/runtime/changelist/Operation;", "<init>", "()V", "Landroidx/compose/runtime/changelist/Operation$ObjectParameter;", "parameter", BuildConfig.FLAVOR, "objectParamName-31yXWZQ", "(I)Ljava/lang/String;", "objectParamName", "Landroidx/compose/runtime/changelist/OperationArgContainer;", "Landroidx/compose/runtime/Applier;", "applier", "Landroidx/compose/runtime/SlotWriter;", "slots", "Landroidx/compose/runtime/RememberManager;", "rememberManager", BuildConfig.FLAVOR, "execute", "(Landroidx/compose/runtime/changelist/OperationArgContainer;Landroidx/compose/runtime/Applier;Landroidx/compose/runtime/SlotWriter;Landroidx/compose/runtime/RememberManager;)V", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class SideEffect extends Operation {
        public static final SideEffect INSTANCE = new SideEffect();

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private SideEffect() {
            super(0, r0, r0, null);
            int i5 = 1;
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public void execute(OperationArgContainer operationArgContainer, Applier<?> applier, SlotWriter slotWriter, RememberManager rememberManager) {
            rememberManager.sideEffect((Function0) operationArgContainer.mo1235getObject31yXWZQ(ObjectParameter.m1232constructorimpl(0)));
        }

        @Override // androidx.compose.runtime.changelist.Operation
        /* renamed from: objectParamName-31yXWZQ */
        public String mo1229objectParamName31yXWZQ(int parameter) {
            return ObjectParameter.m1233equalsimpl0(parameter, ObjectParameter.m1232constructorimpl(0)) ? "effect" : super.mo1229objectParamName31yXWZQ(parameter);
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J(\u0010\u0003\u001a\u00020\u0004*\u00020\u00052\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, d2 = {"Landroidx/compose/runtime/changelist/Operation$SkipToEndOfCurrentGroup;", "Landroidx/compose/runtime/changelist/Operation;", "()V", "execute", BuildConfig.FLAVOR, "Landroidx/compose/runtime/changelist/OperationArgContainer;", "applier", "Landroidx/compose/runtime/Applier;", "slots", "Landroidx/compose/runtime/SlotWriter;", "rememberManager", "Landroidx/compose/runtime/RememberManager;", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class SkipToEndOfCurrentGroup extends Operation {
        public static final SkipToEndOfCurrentGroup INSTANCE = new SkipToEndOfCurrentGroup();

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private SkipToEndOfCurrentGroup() {
            super(r2, r2, 3, null);
            int i5 = 0;
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public void execute(OperationArgContainer operationArgContainer, Applier<?> applier, SlotWriter slotWriter, RememberManager rememberManager) {
            slotWriter.skipToGroupEnd();
        }
    }

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\bJ/\u0010\u0012\u001a\u00020\u0011*\u00020\n2\n\u0010\f\u001a\u0006\u0012\u0002\b\u00030\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0012\u0010\u0013\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0014"}, d2 = {"Landroidx/compose/runtime/changelist/Operation$TrimParentValues;", "Landroidx/compose/runtime/changelist/Operation;", "<init>", "()V", "Landroidx/compose/runtime/changelist/Operation$IntParameter;", "parameter", BuildConfig.FLAVOR, "intParamName-w8GmfQM", "(I)Ljava/lang/String;", "intParamName", "Landroidx/compose/runtime/changelist/OperationArgContainer;", "Landroidx/compose/runtime/Applier;", "applier", "Landroidx/compose/runtime/SlotWriter;", "slots", "Landroidx/compose/runtime/RememberManager;", "rememberManager", BuildConfig.FLAVOR, "execute", "(Landroidx/compose/runtime/changelist/OperationArgContainer;Landroidx/compose/runtime/Applier;Landroidx/compose/runtime/SlotWriter;Landroidx/compose/runtime/RememberManager;)V", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class TrimParentValues extends Operation {
        public static final TrimParentValues INSTANCE = new TrimParentValues();

        private TrimParentValues() {
            super(1, 0, 2, null);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public void execute(OperationArgContainer operationArgContainer, Applier<?> applier, SlotWriter slotWriter, RememberManager rememberManager) {
            int dataIndexToDataAddress;
            int mo1234getIntw8GmfQM = operationArgContainer.mo1234getIntw8GmfQM(IntParameter.m1230constructorimpl(0));
            int slotsSize = slotWriter.getSlotsSize();
            int parent = slotWriter.getParent();
            int slotsStartIndex$runtime_release = slotWriter.slotsStartIndex$runtime_release(parent);
            int slotsEndIndex$runtime_release = slotWriter.slotsEndIndex$runtime_release(parent);
            for (int max = Math.max(slotsStartIndex$runtime_release, slotsEndIndex$runtime_release - mo1234getIntw8GmfQM); max < slotsEndIndex$runtime_release; max++) {
                Object[] objArr = slotWriter.slots;
                dataIndexToDataAddress = slotWriter.dataIndexToDataAddress(max);
                Object obj = objArr[dataIndexToDataAddress];
                if (obj instanceof RememberObserverHolder) {
                    rememberManager.forgetting(((RememberObserverHolder) obj).getWrapped(), slotsSize - max, -1, -1);
                } else if (obj instanceof RecomposeScopeImpl) {
                    ((RecomposeScopeImpl) obj).release();
                }
            }
            slotWriter.trimTailSlots(mo1234getIntw8GmfQM);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        /* renamed from: intParamName-w8GmfQM */
        public String mo1228intParamNamew8GmfQM(int parameter) {
            return IntParameter.m1231equalsimpl0(parameter, IntParameter.m1230constructorimpl(0)) ? "count" : super.mo1228intParamNamew8GmfQM(parameter);
        }
    }

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\bJ\u001e\u0010\f\u001a\u00020\u00062\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\nH\u0016ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\bJ/\u0010\u0015\u001a\u00020\u0014*\u00020\r2\n\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0015\u0010\u0016\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0017"}, d2 = {"Landroidx/compose/runtime/changelist/Operation$UpdateAnchoredValue;", "Landroidx/compose/runtime/changelist/Operation;", "<init>", "()V", "Landroidx/compose/runtime/changelist/Operation$IntParameter;", "parameter", BuildConfig.FLAVOR, "intParamName-w8GmfQM", "(I)Ljava/lang/String;", "intParamName", "Landroidx/compose/runtime/changelist/Operation$ObjectParameter;", "objectParamName-31yXWZQ", "objectParamName", "Landroidx/compose/runtime/changelist/OperationArgContainer;", "Landroidx/compose/runtime/Applier;", "applier", "Landroidx/compose/runtime/SlotWriter;", "slots", "Landroidx/compose/runtime/RememberManager;", "rememberManager", BuildConfig.FLAVOR, "execute", "(Landroidx/compose/runtime/changelist/OperationArgContainer;Landroidx/compose/runtime/Applier;Landroidx/compose/runtime/SlotWriter;Landroidx/compose/runtime/RememberManager;)V", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class UpdateAnchoredValue extends Operation {
        public static final UpdateAnchoredValue INSTANCE = new UpdateAnchoredValue();

        private UpdateAnchoredValue() {
            super(1, 2, null);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public void execute(OperationArgContainer operationArgContainer, Applier<?> applier, SlotWriter slotWriter, RememberManager rememberManager) {
            int i5;
            int i6;
            Object mo1235getObject31yXWZQ = operationArgContainer.mo1235getObject31yXWZQ(ObjectParameter.m1232constructorimpl(0));
            Anchor anchor = (Anchor) operationArgContainer.mo1235getObject31yXWZQ(ObjectParameter.m1232constructorimpl(1));
            int mo1234getIntw8GmfQM = operationArgContainer.mo1234getIntw8GmfQM(IntParameter.m1230constructorimpl(0));
            if (mo1235getObject31yXWZQ instanceof RememberObserverHolder) {
                rememberManager.remembering(((RememberObserverHolder) mo1235getObject31yXWZQ).getWrapped());
            }
            int anchorIndex = slotWriter.anchorIndex(anchor);
            Object obj = slotWriter.set(anchorIndex, mo1234getIntw8GmfQM, mo1235getObject31yXWZQ);
            if (!(obj instanceof RememberObserverHolder)) {
                if (obj instanceof RecomposeScopeImpl) {
                    ((RecomposeScopeImpl) obj).release();
                    return;
                }
                return;
            }
            int slotsSize = slotWriter.getSlotsSize() - slotWriter.slotIndexOfGroupSlotIndex(anchorIndex, mo1234getIntw8GmfQM);
            RememberObserverHolder rememberObserverHolder = (RememberObserverHolder) obj;
            Anchor after = rememberObserverHolder.getAfter();
            if (after == null || !after.getValid()) {
                i5 = -1;
                i6 = -1;
            } else {
                i5 = slotWriter.anchorIndex(after);
                i6 = slotWriter.getSlotsSize() - slotWriter.slotsEndAllIndex$runtime_release(i5);
            }
            rememberManager.forgetting(rememberObserverHolder.getWrapped(), slotsSize, i5, i6);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        /* renamed from: intParamName-w8GmfQM */
        public String mo1228intParamNamew8GmfQM(int parameter) {
            return IntParameter.m1231equalsimpl0(parameter, IntParameter.m1230constructorimpl(0)) ? "groupSlotIndex" : super.mo1228intParamNamew8GmfQM(parameter);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        /* renamed from: objectParamName-31yXWZQ */
        public String mo1229objectParamName31yXWZQ(int parameter) {
            return ObjectParameter.m1233equalsimpl0(parameter, ObjectParameter.m1232constructorimpl(0)) ? "value" : ObjectParameter.m1233equalsimpl0(parameter, ObjectParameter.m1232constructorimpl(1)) ? "anchor" : super.mo1229objectParamName31yXWZQ(parameter);
        }
    }

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\t\u001a\u00020\u00062\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0004H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\bJ/\u0010\u0012\u001a\u00020\u0011*\u00020\n2\n\u0010\f\u001a\u0006\u0012\u0002\b\u00030\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0012\u0010\u0013\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0014"}, d2 = {"Landroidx/compose/runtime/changelist/Operation$UpdateAuxData;", "Landroidx/compose/runtime/changelist/Operation;", "<init>", "()V", "Landroidx/compose/runtime/changelist/Operation$ObjectParameter;", "parameter", BuildConfig.FLAVOR, "objectParamName-31yXWZQ", "(I)Ljava/lang/String;", "objectParamName", "Landroidx/compose/runtime/changelist/OperationArgContainer;", "Landroidx/compose/runtime/Applier;", "applier", "Landroidx/compose/runtime/SlotWriter;", "slots", "Landroidx/compose/runtime/RememberManager;", "rememberManager", BuildConfig.FLAVOR, "execute", "(Landroidx/compose/runtime/changelist/OperationArgContainer;Landroidx/compose/runtime/Applier;Landroidx/compose/runtime/SlotWriter;Landroidx/compose/runtime/RememberManager;)V", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class UpdateAuxData extends Operation {
        public static final UpdateAuxData INSTANCE = new UpdateAuxData();

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private UpdateAuxData() {
            super(0, r0, r0, null);
            int i5 = 1;
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public void execute(OperationArgContainer operationArgContainer, Applier<?> applier, SlotWriter slotWriter, RememberManager rememberManager) {
            slotWriter.updateAux(operationArgContainer.mo1235getObject31yXWZQ(ObjectParameter.m1232constructorimpl(0)));
        }

        @Override // androidx.compose.runtime.changelist.Operation
        /* renamed from: objectParamName-31yXWZQ */
        public String mo1229objectParamName31yXWZQ(int parameter) {
            return ObjectParameter.m1233equalsimpl0(parameter, ObjectParameter.m1232constructorimpl(0)) ? "data" : super.mo1229objectParamName31yXWZQ(parameter);
        }
    }

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\t\u001a\u00020\u00062\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0004H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\bJ/\u0010\u0012\u001a\u00020\u0011*\u00020\n2\n\u0010\f\u001a\u0006\u0012\u0002\b\u00030\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0012\u0010\u0013\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0014"}, d2 = {"Landroidx/compose/runtime/changelist/Operation$UpdateNode;", "Landroidx/compose/runtime/changelist/Operation;", "<init>", "()V", "Landroidx/compose/runtime/changelist/Operation$ObjectParameter;", "parameter", BuildConfig.FLAVOR, "objectParamName-31yXWZQ", "(I)Ljava/lang/String;", "objectParamName", "Landroidx/compose/runtime/changelist/OperationArgContainer;", "Landroidx/compose/runtime/Applier;", "applier", "Landroidx/compose/runtime/SlotWriter;", "slots", "Landroidx/compose/runtime/RememberManager;", "rememberManager", BuildConfig.FLAVOR, "execute", "(Landroidx/compose/runtime/changelist/OperationArgContainer;Landroidx/compose/runtime/Applier;Landroidx/compose/runtime/SlotWriter;Landroidx/compose/runtime/RememberManager;)V", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class UpdateNode extends Operation {
        public static final UpdateNode INSTANCE = new UpdateNode();

        private UpdateNode() {
            super(0, 2, 1, null);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public void execute(OperationArgContainer operationArgContainer, Applier<?> applier, SlotWriter slotWriter, RememberManager rememberManager) {
            ((Function2) operationArgContainer.mo1235getObject31yXWZQ(ObjectParameter.m1232constructorimpl(1))).invoke(applier.getCurrent(), operationArgContainer.mo1235getObject31yXWZQ(ObjectParameter.m1232constructorimpl(0)));
        }

        @Override // androidx.compose.runtime.changelist.Operation
        /* renamed from: objectParamName-31yXWZQ */
        public String mo1229objectParamName31yXWZQ(int parameter) {
            return ObjectParameter.m1233equalsimpl0(parameter, ObjectParameter.m1232constructorimpl(0)) ? "value" : ObjectParameter.m1233equalsimpl0(parameter, ObjectParameter.m1232constructorimpl(1)) ? "block" : super.mo1229objectParamName31yXWZQ(parameter);
        }
    }

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\bJ\u001e\u0010\f\u001a\u00020\u00062\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\nH\u0016ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\bJ/\u0010\u0015\u001a\u00020\u0014*\u00020\r2\n\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0015\u0010\u0016\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0017"}, d2 = {"Landroidx/compose/runtime/changelist/Operation$UpdateValue;", "Landroidx/compose/runtime/changelist/Operation;", "<init>", "()V", "Landroidx/compose/runtime/changelist/Operation$IntParameter;", "parameter", BuildConfig.FLAVOR, "intParamName-w8GmfQM", "(I)Ljava/lang/String;", "intParamName", "Landroidx/compose/runtime/changelist/Operation$ObjectParameter;", "objectParamName-31yXWZQ", "objectParamName", "Landroidx/compose/runtime/changelist/OperationArgContainer;", "Landroidx/compose/runtime/Applier;", "applier", "Landroidx/compose/runtime/SlotWriter;", "slots", "Landroidx/compose/runtime/RememberManager;", "rememberManager", BuildConfig.FLAVOR, "execute", "(Landroidx/compose/runtime/changelist/OperationArgContainer;Landroidx/compose/runtime/Applier;Landroidx/compose/runtime/SlotWriter;Landroidx/compose/runtime/RememberManager;)V", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class UpdateValue extends Operation {
        public static final UpdateValue INSTANCE = new UpdateValue();

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private UpdateValue() {
            super(r0, r0, null);
            int i5 = 1;
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public void execute(OperationArgContainer operationArgContainer, Applier<?> applier, SlotWriter slotWriter, RememberManager rememberManager) {
            Object mo1235getObject31yXWZQ = operationArgContainer.mo1235getObject31yXWZQ(ObjectParameter.m1232constructorimpl(0));
            int mo1234getIntw8GmfQM = operationArgContainer.mo1234getIntw8GmfQM(IntParameter.m1230constructorimpl(0));
            if (mo1235getObject31yXWZQ instanceof RememberObserverHolder) {
                rememberManager.remembering(((RememberObserverHolder) mo1235getObject31yXWZQ).getWrapped());
            }
            Object obj = slotWriter.set(mo1234getIntw8GmfQM, mo1235getObject31yXWZQ);
            if (obj instanceof RememberObserverHolder) {
                rememberManager.forgetting(((RememberObserverHolder) obj).getWrapped(), slotWriter.getSlotsSize() - slotWriter.slotIndexOfGroupSlotIndex(slotWriter.getCurrentGroup(), mo1234getIntw8GmfQM), -1, -1);
            } else if (obj instanceof RecomposeScopeImpl) {
                ((RecomposeScopeImpl) obj).release();
            }
        }

        @Override // androidx.compose.runtime.changelist.Operation
        /* renamed from: intParamName-w8GmfQM */
        public String mo1228intParamNamew8GmfQM(int parameter) {
            return IntParameter.m1231equalsimpl0(parameter, IntParameter.m1230constructorimpl(0)) ? "groupSlotIndex" : super.mo1228intParamNamew8GmfQM(parameter);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        /* renamed from: objectParamName-31yXWZQ */
        public String mo1229objectParamName31yXWZQ(int parameter) {
            return ObjectParameter.m1233equalsimpl0(parameter, ObjectParameter.m1232constructorimpl(0)) ? "value" : super.mo1229objectParamName31yXWZQ(parameter);
        }
    }

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\bJ/\u0010\u0012\u001a\u00020\u0011*\u00020\n2\n\u0010\f\u001a\u0006\u0012\u0002\b\u00030\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0012\u0010\u0013\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0014"}, d2 = {"Landroidx/compose/runtime/changelist/Operation$Ups;", "Landroidx/compose/runtime/changelist/Operation;", "<init>", "()V", "Landroidx/compose/runtime/changelist/Operation$IntParameter;", "parameter", BuildConfig.FLAVOR, "intParamName-w8GmfQM", "(I)Ljava/lang/String;", "intParamName", "Landroidx/compose/runtime/changelist/OperationArgContainer;", "Landroidx/compose/runtime/Applier;", "applier", "Landroidx/compose/runtime/SlotWriter;", "slots", "Landroidx/compose/runtime/RememberManager;", "rememberManager", BuildConfig.FLAVOR, "execute", "(Landroidx/compose/runtime/changelist/OperationArgContainer;Landroidx/compose/runtime/Applier;Landroidx/compose/runtime/SlotWriter;Landroidx/compose/runtime/RememberManager;)V", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Ups extends Operation {
        public static final Ups INSTANCE = new Ups();

        private Ups() {
            super(1, 0, 2, null);
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public void execute(OperationArgContainer operationArgContainer, Applier<?> applier, SlotWriter slotWriter, RememberManager rememberManager) {
            int mo1234getIntw8GmfQM = operationArgContainer.mo1234getIntw8GmfQM(IntParameter.m1230constructorimpl(0));
            for (int i5 = 0; i5 < mo1234getIntw8GmfQM; i5++) {
                applier.up();
            }
        }

        @Override // androidx.compose.runtime.changelist.Operation
        /* renamed from: intParamName-w8GmfQM */
        public String mo1228intParamNamew8GmfQM(int parameter) {
            return IntParameter.m1231equalsimpl0(parameter, IntParameter.m1230constructorimpl(0)) ? "count" : super.mo1228intParamNamew8GmfQM(parameter);
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J(\u0010\u0003\u001a\u00020\u0004*\u00020\u00052\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, d2 = {"Landroidx/compose/runtime/changelist/Operation$UseCurrentNode;", "Landroidx/compose/runtime/changelist/Operation;", "()V", "execute", BuildConfig.FLAVOR, "Landroidx/compose/runtime/changelist/OperationArgContainer;", "applier", "Landroidx/compose/runtime/Applier;", "slots", "Landroidx/compose/runtime/SlotWriter;", "rememberManager", "Landroidx/compose/runtime/RememberManager;", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class UseCurrentNode extends Operation {
        public static final UseCurrentNode INSTANCE = new UseCurrentNode();

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private UseCurrentNode() {
            super(r2, r2, 3, null);
            int i5 = 0;
        }

        @Override // androidx.compose.runtime.changelist.Operation
        public void execute(OperationArgContainer operationArgContainer, Applier<?> applier, SlotWriter slotWriter, RememberManager rememberManager) {
            Object current = applier.getCurrent();
            Intrinsics.checkNotNull(current, "null cannot be cast to non-null type androidx.compose.runtime.ComposeNodeLifecycleCallback");
            ((ComposeNodeLifecycleCallback) current).onReuse();
        }
    }

    public /* synthetic */ Operation(int i5, int i6, DefaultConstructorMarker defaultConstructorMarker) {
        this(i5, i6);
    }

    public abstract void execute(OperationArgContainer operationArgContainer, Applier<?> applier, SlotWriter slotWriter, RememberManager rememberManager);

    public final int getInts() {
        return this.ints;
    }

    public final String getName() {
        String simpleName = Reflection.getOrCreateKotlinClass(getClass()).getSimpleName();
        return simpleName == null ? BuildConfig.FLAVOR : simpleName;
    }

    public final int getObjects() {
        return this.objects;
    }

    /* renamed from: intParamName-w8GmfQM, reason: not valid java name */
    public String mo1228intParamNamew8GmfQM(int parameter) {
        return "IntParameter(" + parameter + ')';
    }

    /* renamed from: objectParamName-31yXWZQ, reason: not valid java name */
    public String mo1229objectParamName31yXWZQ(int parameter) {
        return "ObjectParameter(" + parameter + ')';
    }

    public String toString() {
        return getName();
    }

    private Operation(int i5, int i6) {
        this.ints = i5;
        this.objects = i6;
    }

    public /* synthetic */ Operation(int i5, int i6, int i7, DefaultConstructorMarker defaultConstructorMarker) {
        this((i7 & 1) != 0 ? 0 : i5, (i7 & 2) != 0 ? 0 : i6, null);
    }
}
