package androidx.compose.runtime;

import androidx.collection.MutableIntList;
import androidx.collection.MutableScatterMap;
import androidx.collection.MutableScatterSet;
import androidx.collection.ObjectIntMap;
import androidx.collection.ScatterSet;
import androidx.collection.ScatterSetKt;
import androidx.compose.runtime.DerivedState;
import androidx.compose.runtime.changelist.ChangeList;
import androidx.compose.runtime.collection.ScatterSetWrapper;
import androidx.compose.runtime.collection.ScopeMap;
import androidx.compose.runtime.snapshots.ReaderKind;
import androidx.compose.runtime.snapshots.StateObject;
import androidx.compose.runtime.snapshots.StateObjectImpl;
import androidx.compose.runtime.tooling.CompositionObserver;
import e.AbstractC0321h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000Ò\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0013\b\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0002£\u0001B'\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u0010\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0014\u0010\u0013J\u001f\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\u0018\u0010\u0019J%\u0010\u0018\u001a\u00020\u000e2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00040\u001a2\u0006\u0010\u0017\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\u0018\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u001d\u0010\u0013J\u0017\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010\"\u001a\u00020\u000e2\u0006\u0010!\u001a\u00020 H\u0002¢\u0006\u0004\b\"\u0010#J!\u0010'\u001a\u00020\u00162\u0006\u0010%\u001a\u00020$2\b\u0010&\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b'\u0010(J)\u0010,\u001a\u00020+2\u0006\u0010%\u001a\u00020$2\u0006\u0010*\u001a\u00020)2\b\u0010&\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b,\u0010-J\u001b\u0010/\u001a\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u00040.H\u0002¢\u0006\u0004\b/\u00100J\u0011\u00102\u001a\u0004\u0018\u000101H\u0002¢\u0006\u0004\b2\u00103J\u001d\u00104\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0016¢\u0006\u0004\b4\u0010\u0011J\u001d\u00105\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0016¢\u0006\u0004\b5\u0010\u0011J\u001d\u00106\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0016¢\u0006\u0004\b6\u0010\u0011J\u000f\u00107\u001a\u00020\u000eH\u0016¢\u0006\u0004\b7\u0010\u0013J\u001d\u00108\u001a\u00020\u000e2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00040\u001aH\u0016¢\u0006\u0004\b8\u00109J\u001d\u0010:\u001a\u00020\u00162\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00040\u001aH\u0016¢\u0006\u0004\b:\u0010;J\u001d\u0010=\u001a\u00020\u000e2\f\u0010<\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0016¢\u0006\u0004\b=\u0010>J\u0017\u0010?\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u0004H\u0016¢\u0006\u0004\b?\u0010\u001fJ\u0017\u0010@\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u0004H\u0016¢\u0006\u0004\b@\u0010\u001fJ\u000f\u0010A\u001a\u00020\u0016H\u0016¢\u0006\u0004\bA\u0010BJ+\u0010G\u001a\u00020\u000e2\u001a\u0010F\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020E\u0012\u0006\u0012\u0004\u0018\u00010E0D0CH\u0016¢\u0006\u0004\bG\u0010HJ\u0017\u0010K\u001a\u00020\u000e2\u0006\u0010J\u001a\u00020IH\u0016¢\u0006\u0004\bK\u0010LJ\u000f\u0010M\u001a\u00020\u000eH\u0016¢\u0006\u0004\bM\u0010\u0013J\u000f\u0010N\u001a\u00020\u000eH\u0016¢\u0006\u0004\bN\u0010\u0013J\u000f\u0010O\u001a\u00020\u000eH\u0016¢\u0006\u0004\bO\u0010\u0013J\u000f\u0010P\u001a\u00020\u000eH\u0016¢\u0006\u0004\bP\u0010\u0013J\u000f\u0010Q\u001a\u00020\u000eH\u0016¢\u0006\u0004\bQ\u0010\u0013J5\u0010V\u001a\u00028\u0000\"\u0004\b\u0000\u0010R2\b\u0010S\u001a\u0004\u0018\u00010\u00012\u0006\u0010U\u001a\u00020T2\f\u0010<\u001a\b\u0012\u0004\u0012\u00028\u00000\rH\u0016¢\u0006\u0004\bV\u0010WJ!\u0010X\u001a\u00020+2\u0006\u0010%\u001a\u00020$2\b\u0010&\u001a\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\bX\u0010YJ\u0017\u0010Z\u001a\u00020\u000e2\u0006\u0010%\u001a\u00020$H\u0016¢\u0006\u0004\bZ\u0010[J\u001f\u0010^\u001a\u00020\u000e2\u0006\u0010&\u001a\u00020\u00042\u0006\u0010%\u001a\u00020$H\u0000¢\u0006\u0004\b\\\u0010]J\u001b\u0010b\u001a\u00020\u000e2\n\u0010J\u001a\u0006\u0012\u0002\b\u00030_H\u0000¢\u0006\u0004\b`\u0010aJ\u000f\u0010c\u001a\u00020\u000eH\u0016¢\u0006\u0004\bc\u0010\u0013R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010dR\u0018\u0010\b\u001a\u0006\u0012\u0002\b\u00030\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010eR(\u0010h\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00040fj\n\u0012\u0006\u0012\u0004\u0018\u00010\u0004`g8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bh\u0010iR\u0014\u0010j\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bj\u0010kR \u0010n\u001a\b\u0012\u0004\u0012\u00020m0l8\u0002X\u0082\u0004¢\u0006\f\n\u0004\bn\u0010o\u0012\u0004\bp\u0010\u0013R \u0010r\u001a\u00020q8\u0000X\u0080\u0004¢\u0006\u0012\n\u0004\br\u0010s\u0012\u0004\bv\u0010\u0013\u001a\u0004\bt\u0010uR \u0010w\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020$0.8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bw\u0010xR\u001a\u0010z\u001a\b\u0012\u0004\u0012\u00020$0y8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bz\u0010{R\u001a\u0010|\u001a\b\u0012\u0004\u0012\u00020$0y8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b|\u0010{R$\u0010}\u001a\u0012\u0012\u0004\u0012\u00020\u0004\u0012\b\u0012\u0006\u0012\u0002\b\u00030_0.8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b}\u0010xR\u0014\u0010!\u001a\u00020 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010~R\u0014\u0010\u007f\u001a\u00020 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u007f\u0010~R\"\u0010\u0080\u0001\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020$0.8\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u0080\u0001\u0010xR$\u0010\u0081\u0001\u001a\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u00040.8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0081\u0001\u0010xR/\u0010\u0082\u0001\u001a\u00020\u00168\u0000@\u0000X\u0080\u000e¢\u0006\u001e\n\u0006\b\u0082\u0001\u0010\u0083\u0001\u0012\u0005\b\u0087\u0001\u0010\u0013\u001a\u0005\b\u0084\u0001\u0010B\"\u0006\b\u0085\u0001\u0010\u0086\u0001R\u001b\u0010\u0088\u0001\u001a\u0004\u0018\u00010\u00008\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0088\u0001\u0010\u0089\u0001R\u0019\u0010\u008a\u0001\u001a\u00020T8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008a\u0001\u0010\u008b\u0001R \u0010\u008d\u0001\u001a\u00030\u008c\u00018\u0000X\u0080\u0004¢\u0006\u0010\n\u0006\b\u008d\u0001\u0010\u008e\u0001\u001a\u0006\b\u008f\u0001\u0010\u0090\u0001R\u0018\u0010\u0092\u0001\u001a\u00030\u0091\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0092\u0001\u0010\u0093\u0001R\u0019\u0010\u0094\u0001\u001a\u0004\u0018\u00010\t8\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0094\u0001\u0010\u0095\u0001R\u001b\u0010\u0096\u0001\u001a\u00020\u00168\u0006¢\u0006\u000f\n\u0006\b\u0096\u0001\u0010\u0083\u0001\u001a\u0005\b\u0096\u0001\u0010BR\u0019\u0010\u0097\u0001\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0097\u0001\u0010\u0083\u0001R.\u0010\u0098\u0001\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0006\b\u0098\u0001\u0010\u0099\u0001\u001a\u0006\b\u009a\u0001\u0010\u009b\u0001\"\u0005\b\u009c\u0001\u0010\u0011R\u0016\u0010\u009e\u0001\u001a\u00020\u00168BX\u0082\u0004¢\u0006\u0007\u001a\u0005\b\u009d\u0001\u0010BR\u0016\u0010\u009f\u0001\u001a\u00020\u00168VX\u0096\u0004¢\u0006\u0007\u001a\u0005\b\u009f\u0001\u0010BR\u0016\u0010 \u0001\u001a\u00020\u00168VX\u0096\u0004¢\u0006\u0007\u001a\u0005\b \u0001\u0010BR\u0016\u0010¢\u0001\u001a\u00020\u00168VX\u0096\u0004¢\u0006\u0007\u001a\u0005\b¡\u0001\u0010B¨\u0006¤\u0001"}, d2 = {"Landroidx/compose/runtime/CompositionImpl;", "Landroidx/compose/runtime/ControlledComposition;", "Landroidx/compose/runtime/ReusableComposition;", "Landroidx/compose/runtime/RecomposeScopeOwner;", BuildConfig.FLAVOR, "Landroidx/compose/runtime/CompositionContext;", "parent", "Landroidx/compose/runtime/Applier;", "applier", "Lkotlin/coroutines/CoroutineContext;", "recomposeContext", "<init>", "(Landroidx/compose/runtime/CompositionContext;Landroidx/compose/runtime/Applier;Lkotlin/coroutines/CoroutineContext;)V", "Lkotlin/Function0;", BuildConfig.FLAVOR, "content", "composeInitial", "(Lkotlin/jvm/functions/Function2;)V", "drainPendingModificationsForCompositionLocked", "()V", "drainPendingModificationsLocked", "value", BuildConfig.FLAVOR, "forgetConditionalScopes", "addPendingInvalidationsLocked", "(Ljava/lang/Object;Z)V", BuildConfig.FLAVOR, "values", "(Ljava/util/Set;Z)V", "cleanUpDerivedStateObservations", "invalidateScopeOfLocked", "(Ljava/lang/Object;)V", "Landroidx/compose/runtime/changelist/ChangeList;", "changes", "applyChangesInLocked", "(Landroidx/compose/runtime/changelist/ChangeList;)V", "Landroidx/compose/runtime/RecomposeScopeImpl;", "scope", "instance", "tryImminentInvalidation", "(Landroidx/compose/runtime/RecomposeScopeImpl;Ljava/lang/Object;)Z", "Landroidx/compose/runtime/Anchor;", "anchor", "Landroidx/compose/runtime/InvalidationResult;", "invalidateChecked", "(Landroidx/compose/runtime/RecomposeScopeImpl;Landroidx/compose/runtime/Anchor;Ljava/lang/Object;)Landroidx/compose/runtime/InvalidationResult;", "Landroidx/compose/runtime/collection/ScopeMap;", "takeInvalidations", "()Landroidx/compose/runtime/collection/ScopeMap;", "Landroidx/compose/runtime/tooling/CompositionObserver;", "observer", "()Landroidx/compose/runtime/tooling/CompositionObserver;", "setContent", "setContentWithReuse", "composeContent", "dispose", "recordModificationsOf", "(Ljava/util/Set;)V", "observesAnyOf", "(Ljava/util/Set;)Z", "block", "prepareCompose", "(Lkotlin/jvm/functions/Function0;)V", "recordReadOf", "recordWriteOf", "recompose", "()Z", BuildConfig.FLAVOR, "Lkotlin/Pair;", "Landroidx/compose/runtime/MovableContentStateReference;", "references", "insertMovableContent", "(Ljava/util/List;)V", "Landroidx/compose/runtime/MovableContentState;", "state", "disposeUnusedMovableContent", "(Landroidx/compose/runtime/MovableContentState;)V", "applyChanges", "applyLateChanges", "changesApplied", "abandonChanges", "invalidateAll", "R", "to", BuildConfig.FLAVOR, "groupIndex", "delegateInvalidations", "(Landroidx/compose/runtime/ControlledComposition;ILkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "invalidate", "(Landroidx/compose/runtime/RecomposeScopeImpl;Ljava/lang/Object;)Landroidx/compose/runtime/InvalidationResult;", "recomposeScopeReleased", "(Landroidx/compose/runtime/RecomposeScopeImpl;)V", "removeObservation$runtime_release", "(Ljava/lang/Object;Landroidx/compose/runtime/RecomposeScopeImpl;)V", "removeObservation", "Landroidx/compose/runtime/DerivedState;", "removeDerivedStateObservation$runtime_release", "(Landroidx/compose/runtime/DerivedState;)V", "removeDerivedStateObservation", "deactivate", "Landroidx/compose/runtime/CompositionContext;", "Landroidx/compose/runtime/Applier;", "Ljava/util/concurrent/atomic/AtomicReference;", "Landroidx/compose/runtime/AtomicReference;", "pendingModifications", "Ljava/util/concurrent/atomic/AtomicReference;", "lock", "Ljava/lang/Object;", BuildConfig.FLAVOR, "Landroidx/compose/runtime/RememberObserver;", "abandonSet", "Ljava/util/Set;", "getAbandonSet$annotations", "Landroidx/compose/runtime/SlotTable;", "slotTable", "Landroidx/compose/runtime/SlotTable;", "getSlotTable$runtime_release", "()Landroidx/compose/runtime/SlotTable;", "getSlotTable$runtime_release$annotations", "observations", "Landroidx/compose/runtime/collection/ScopeMap;", "Landroidx/collection/MutableScatterSet;", "invalidatedScopes", "Landroidx/collection/MutableScatterSet;", "conditionallyInvalidatedScopes", "derivedStates", "Landroidx/compose/runtime/changelist/ChangeList;", "lateChanges", "observationsProcessed", "invalidations", "pendingInvalidScopes", "Z", "getPendingInvalidScopes$runtime_release", "setPendingInvalidScopes$runtime_release", "(Z)V", "getPendingInvalidScopes$runtime_release$annotations", "invalidationDelegate", "Landroidx/compose/runtime/CompositionImpl;", "invalidationDelegateGroup", "I", "Landroidx/compose/runtime/CompositionObserverHolder;", "observerHolder", "Landroidx/compose/runtime/CompositionObserverHolder;", "getObserverHolder$runtime_release", "()Landroidx/compose/runtime/CompositionObserverHolder;", "Landroidx/compose/runtime/ComposerImpl;", "composer", "Landroidx/compose/runtime/ComposerImpl;", "_recomposeContext", "Lkotlin/coroutines/CoroutineContext;", "isRoot", "disposed", "composable", "Lkotlin/jvm/functions/Function2;", "getComposable", "()Lkotlin/jvm/functions/Function2;", "setComposable", "getAreChildrenComposing", "areChildrenComposing", "isComposing", "isDisposed", "getHasInvalidations", "hasInvalidations", "RememberEventDispatcher", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class CompositionImpl implements ControlledComposition, ReusableComposition, RecomposeScopeOwner {
    private final CoroutineContext _recomposeContext;
    private final Set<RememberObserver> abandonSet;
    private final Applier<?> applier;
    private final ChangeList changes;
    private Function2<? super Composer, ? super Integer, Unit> composable;
    private final ComposerImpl composer;
    private final MutableScatterSet<RecomposeScopeImpl> conditionallyInvalidatedScopes;
    private final ScopeMap<Object, DerivedState<?>> derivedStates;
    private boolean disposed;
    private final MutableScatterSet<RecomposeScopeImpl> invalidatedScopes;
    private CompositionImpl invalidationDelegate;
    private int invalidationDelegateGroup;
    private ScopeMap<RecomposeScopeImpl, Object> invalidations;
    private final boolean isRoot;
    private final ChangeList lateChanges;
    private final Object lock;
    private final ScopeMap<Object, RecomposeScopeImpl> observations;
    private final ScopeMap<Object, RecomposeScopeImpl> observationsProcessed;
    private final CompositionObserverHolder observerHolder;
    private final CompositionContext parent;
    private boolean pendingInvalidScopes;
    private final AtomicReference<Object> pendingModifications;
    private final SlotTable slotTable;

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000b\b\u0002\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J(\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u0017H\u0016J\u0006\u0010\u001a\u001a\u00020\u0013J\u0006\u0010\u001b\u001a\u00020\u0013J\u0006\u0010\u001c\u001a\u00020\u0013J(\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u0017H\u0016J\u0010\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J(\u0010\u001f\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u0017H\u0002J(\u0010\r\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u0017H\u0016J\u0010\u0010\u0010\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0004H\u0016J\u0016\u0010 \u001a\u00020\u00132\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0016R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00040\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00120\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Landroidx/compose/runtime/CompositionImpl$RememberEventDispatcher;", "Landroidx/compose/runtime/RememberManager;", "abandoning", BuildConfig.FLAVOR, "Landroidx/compose/runtime/RememberObserver;", "(Ljava/util/Set;)V", "afters", "Landroidx/collection/MutableIntList;", "leaving", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "pending", "priorities", "releasing", "Landroidx/collection/MutableScatterSet;", "Landroidx/compose/runtime/ComposeNodeLifecycleCallback;", "remembering", "sideEffects", "Lkotlin/Function0;", BuildConfig.FLAVOR, "deactivating", "instance", "endRelativeOrder", BuildConfig.FLAVOR, "priority", "endRelativeAfter", "dispatchAbandons", "dispatchRememberObservers", "dispatchSideEffects", "forgetting", "processPendingLeaving", "recordLeaving", "sideEffect", "effect", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class RememberEventDispatcher implements RememberManager {
        private final Set<RememberObserver> abandoning;
        private MutableScatterSet<ComposeNodeLifecycleCallback> releasing;
        private final List<RememberObserver> remembering = new ArrayList();
        private final List<Object> leaving = new ArrayList();
        private final List<Function0<Unit>> sideEffects = new ArrayList();
        private final List<Object> pending = new ArrayList();
        private final MutableIntList priorities = new MutableIntList(0, 1, null);
        private final MutableIntList afters = new MutableIntList(0, 1, null);

        public RememberEventDispatcher(Set<RememberObserver> set) {
            this.abandoning = set;
        }

        private final void processPendingLeaving(int endRelativeOrder) {
            if (this.pending.isEmpty()) {
                return;
            }
            int i5 = 0;
            int i6 = 0;
            List list = null;
            MutableIntList mutableIntList = null;
            MutableIntList mutableIntList2 = null;
            while (i6 < this.afters.get_size()) {
                if (endRelativeOrder <= this.afters.get(i6)) {
                    Object remove = this.pending.remove(i6);
                    int removeAt = this.afters.removeAt(i6);
                    int removeAt2 = this.priorities.removeAt(i6);
                    if (list == null) {
                        list = CollectionsKt.mutableListOf(remove);
                        mutableIntList2 = new MutableIntList(0, 1, null);
                        mutableIntList2.add(removeAt);
                        mutableIntList = new MutableIntList(0, 1, null);
                        mutableIntList.add(removeAt2);
                    } else {
                        Intrinsics.checkNotNull(mutableIntList, "null cannot be cast to non-null type androidx.collection.MutableIntList");
                        Intrinsics.checkNotNull(mutableIntList2, "null cannot be cast to non-null type androidx.collection.MutableIntList");
                        list.add(remove);
                        mutableIntList2.add(removeAt);
                        mutableIntList.add(removeAt2);
                    }
                } else {
                    i6++;
                }
            }
            if (list != null) {
                Intrinsics.checkNotNull(mutableIntList, "null cannot be cast to non-null type androidx.collection.MutableIntList");
                Intrinsics.checkNotNull(mutableIntList2, "null cannot be cast to non-null type androidx.collection.MutableIntList");
                int size = list.size() - 1;
                while (i5 < size) {
                    int i7 = i5 + 1;
                    int size2 = list.size();
                    for (int i8 = i7; i8 < size2; i8++) {
                        int i9 = mutableIntList2.get(i5);
                        int i10 = mutableIntList2.get(i8);
                        if (i9 < i10 || (i10 == i9 && mutableIntList.get(i5) < mutableIntList.get(i8))) {
                            CompositionKt.swap(list, i5, i8);
                            CompositionKt.swap(mutableIntList, i5, i8);
                            CompositionKt.swap(mutableIntList2, i5, i8);
                        }
                    }
                    i5 = i7;
                }
                this.leaving.addAll(list);
            }
        }

        private final void recordLeaving(Object instance, int endRelativeOrder, int priority, int endRelativeAfter) {
            processPendingLeaving(endRelativeOrder);
            if (endRelativeAfter < 0 || endRelativeAfter >= endRelativeOrder) {
                this.leaving.add(instance);
                return;
            }
            this.pending.add(instance);
            this.priorities.add(priority);
            this.afters.add(endRelativeAfter);
        }

        @Override // androidx.compose.runtime.RememberManager
        public void deactivating(ComposeNodeLifecycleCallback instance, int endRelativeOrder, int priority, int endRelativeAfter) {
            recordLeaving(instance, endRelativeOrder, priority, endRelativeAfter);
        }

        public final void dispatchAbandons() {
            if (this.abandoning.isEmpty()) {
                return;
            }
            Object beginSection = Trace.INSTANCE.beginSection("Compose:abandons");
            try {
                Iterator<RememberObserver> it = this.abandoning.iterator();
                while (it.hasNext()) {
                    RememberObserver next = it.next();
                    it.remove();
                    next.onAbandoned();
                }
                Unit unit = Unit.INSTANCE;
                Trace.INSTANCE.endSection(beginSection);
            } catch (Throwable th) {
                Trace.INSTANCE.endSection(beginSection);
                throw th;
            }
        }

        public final void dispatchRememberObservers() {
            Object beginSection;
            processPendingLeaving(Integer.MIN_VALUE);
            if (!this.leaving.isEmpty()) {
                beginSection = Trace.INSTANCE.beginSection("Compose:onForgotten");
                try {
                    ScatterSet scatterSet = this.releasing;
                    for (int size = this.leaving.size() - 1; -1 < size; size--) {
                        Object obj = this.leaving.get(size);
                        if (obj instanceof RememberObserver) {
                            this.abandoning.remove(obj);
                            ((RememberObserver) obj).onForgotten();
                        }
                        if (obj instanceof ComposeNodeLifecycleCallback) {
                            if (scatterSet == null || !scatterSet.contains(obj)) {
                                ((ComposeNodeLifecycleCallback) obj).onDeactivate();
                            } else {
                                ((ComposeNodeLifecycleCallback) obj).onRelease();
                            }
                        }
                    }
                    Unit unit = Unit.INSTANCE;
                    Trace.INSTANCE.endSection(beginSection);
                } finally {
                }
            }
            if (this.remembering.isEmpty()) {
                return;
            }
            beginSection = Trace.INSTANCE.beginSection("Compose:onRemembered");
            try {
                List<RememberObserver> list = this.remembering;
                int size2 = list.size();
                for (int i5 = 0; i5 < size2; i5++) {
                    RememberObserver rememberObserver = list.get(i5);
                    this.abandoning.remove(rememberObserver);
                    rememberObserver.onRemembered();
                }
                Unit unit2 = Unit.INSTANCE;
                Trace.INSTANCE.endSection(beginSection);
            } finally {
            }
        }

        public final void dispatchSideEffects() {
            if (this.sideEffects.isEmpty()) {
                return;
            }
            Object beginSection = Trace.INSTANCE.beginSection("Compose:sideeffects");
            try {
                List<Function0<Unit>> list = this.sideEffects;
                int size = list.size();
                for (int i5 = 0; i5 < size; i5++) {
                    list.get(i5).invoke();
                }
                this.sideEffects.clear();
                Unit unit = Unit.INSTANCE;
                Trace.INSTANCE.endSection(beginSection);
            } catch (Throwable th) {
                Trace.INSTANCE.endSection(beginSection);
                throw th;
            }
        }

        @Override // androidx.compose.runtime.RememberManager
        public void forgetting(RememberObserver instance, int endRelativeOrder, int priority, int endRelativeAfter) {
            recordLeaving(instance, endRelativeOrder, priority, endRelativeAfter);
        }

        @Override // androidx.compose.runtime.RememberManager
        public void releasing(ComposeNodeLifecycleCallback instance, int endRelativeOrder, int priority, int endRelativeAfter) {
            MutableScatterSet<ComposeNodeLifecycleCallback> mutableScatterSet = this.releasing;
            if (mutableScatterSet == null) {
                mutableScatterSet = ScatterSetKt.mutableScatterSetOf();
                this.releasing = mutableScatterSet;
            }
            mutableScatterSet.plusAssign((MutableScatterSet<ComposeNodeLifecycleCallback>) instance);
            recordLeaving(instance, endRelativeOrder, priority, endRelativeAfter);
        }

        @Override // androidx.compose.runtime.RememberManager
        public void remembering(RememberObserver instance) {
            this.remembering.add(instance);
        }

        @Override // androidx.compose.runtime.RememberManager
        public void sideEffect(Function0<Unit> effect) {
            this.sideEffects.add(effect);
        }
    }

    public CompositionImpl(CompositionContext compositionContext, Applier<?> applier, CoroutineContext coroutineContext) {
        this.parent = compositionContext;
        this.applier = applier;
        this.pendingModifications = new AtomicReference<>(null);
        this.lock = new Object();
        Set<RememberObserver> asMutableSet = new MutableScatterSet(0, 1, null).asMutableSet();
        this.abandonSet = asMutableSet;
        SlotTable slotTable = new SlotTable();
        if (compositionContext.getCollectingCallByInformation$runtime_release()) {
            slotTable.collectCalledByInformation();
        }
        if (compositionContext.getCollectingSourceInformation()) {
            slotTable.collectSourceInformation();
        }
        this.slotTable = slotTable;
        this.observations = new ScopeMap<>();
        this.invalidatedScopes = new MutableScatterSet<>(0, 1, null);
        this.conditionallyInvalidatedScopes = new MutableScatterSet<>(0, 1, null);
        this.derivedStates = new ScopeMap<>();
        ChangeList changeList = new ChangeList();
        this.changes = changeList;
        ChangeList changeList2 = new ChangeList();
        this.lateChanges = changeList2;
        this.observationsProcessed = new ScopeMap<>();
        this.invalidations = new ScopeMap<>();
        this.observerHolder = new CompositionObserverHolder(null, false, 3, null);
        ComposerImpl composerImpl = new ComposerImpl(applier, compositionContext, slotTable, asMutableSet, changeList, changeList2, this);
        compositionContext.registerComposer$runtime_release(composerImpl);
        this.composer = composerImpl;
        this._recomposeContext = coroutineContext;
        this.isRoot = compositionContext instanceof Recomposer;
        this.composable = ComposableSingletons$CompositionKt.INSTANCE.m1209getLambda1$runtime_release();
    }

    private final void addPendingInvalidationsLocked(Object value, boolean forgetConditionalScopes) {
        Object obj = this.observations.getMap().get(value);
        if (obj == null) {
            return;
        }
        if (obj instanceof MutableScatterSet) {
            MutableScatterSet mutableScatterSet = (MutableScatterSet) obj;
            Object[] objArr = mutableScatterSet.elements;
            long[] jArr = mutableScatterSet.metadata;
            int length = jArr.length - 2;
            if (length < 0) {
                return;
            }
            int i5 = 0;
            while (true) {
                long j5 = jArr[i5];
                if ((((~j5) << 7) & j5 & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i6 = 8 - ((~(i5 - length)) >>> 31);
                    for (int i7 = 0; i7 < i6; i7++) {
                        if ((255 & j5) < 128) {
                            RecomposeScopeImpl recomposeScopeImpl = (RecomposeScopeImpl) objArr[(i5 << 3) + i7];
                            if (!this.observationsProcessed.remove(value, recomposeScopeImpl) && recomposeScopeImpl.invalidateForResult(value) != InvalidationResult.IGNORED) {
                                if (recomposeScopeImpl.isConditional() && !forgetConditionalScopes) {
                                    this.conditionallyInvalidatedScopes.add(recomposeScopeImpl);
                                } else {
                                    this.invalidatedScopes.add(recomposeScopeImpl);
                                }
                            }
                        }
                        j5 >>= 8;
                    }
                    if (i6 != 8) {
                        return;
                    }
                }
                if (i5 == length) {
                    return;
                } else {
                    i5++;
                }
            }
        } else {
            RecomposeScopeImpl recomposeScopeImpl2 = (RecomposeScopeImpl) obj;
            if (this.observationsProcessed.remove(value, recomposeScopeImpl2) || recomposeScopeImpl2.invalidateForResult(value) == InvalidationResult.IGNORED) {
                return;
            }
            if (recomposeScopeImpl2.isConditional() && !forgetConditionalScopes) {
                this.conditionallyInvalidatedScopes.add(recomposeScopeImpl2);
            } else {
                this.invalidatedScopes.add(recomposeScopeImpl2);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:106:0x01e3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void applyChangesInLocked(ChangeList changes) {
        RememberEventDispatcher rememberEventDispatcher;
        RememberEventDispatcher rememberEventDispatcher2;
        boolean z5;
        long[] jArr;
        int i5;
        RememberEventDispatcher rememberEventDispatcher3;
        long[] jArr2;
        int i6;
        int i7;
        char c5;
        long j5;
        int i8;
        boolean z6;
        long[] jArr3;
        long[] jArr4;
        CompositionImpl compositionImpl = this;
        boolean z7 = true;
        RememberEventDispatcher rememberEventDispatcher4 = new RememberEventDispatcher(compositionImpl.abandonSet);
        try {
            if (changes.isEmpty()) {
                if (compositionImpl.lateChanges.isEmpty()) {
                    rememberEventDispatcher4.dispatchAbandons();
                    return;
                }
                return;
            }
            Trace trace = Trace.INSTANCE;
            Object beginSection = trace.beginSection("Compose:applyChanges");
            try {
                compositionImpl.applier.onBeginChanges();
                SlotWriter openWriter = compositionImpl.slotTable.openWriter();
                int i9 = 0;
                try {
                    changes.executeAndFlushAllPendingChanges(compositionImpl.applier, openWriter, rememberEventDispatcher4);
                    Unit unit = Unit.INSTANCE;
                    openWriter.close(true);
                    compositionImpl.applier.onEndChanges();
                    trace.endSection(beginSection);
                    rememberEventDispatcher4.dispatchRememberObservers();
                    rememberEventDispatcher4.dispatchSideEffects();
                    if (compositionImpl.pendingInvalidScopes) {
                        try {
                            try {
                                Object beginSection2 = trace.beginSection("Compose:unobserve");
                                try {
                                    compositionImpl.pendingInvalidScopes = false;
                                    MutableScatterMap<Object, Object> map = compositionImpl.observations.getMap();
                                    long[] jArr5 = map.metadata;
                                    int length = jArr5.length - 2;
                                    if (length >= 0) {
                                        int i10 = 0;
                                        while (true) {
                                            long j6 = jArr5[i10];
                                            char c6 = 7;
                                            long j7 = -9187201950435737472L;
                                            if ((((~j6) << 7) & j6 & (-9187201950435737472L)) != -9187201950435737472L) {
                                                int i11 = 8;
                                                int i12 = 8 - ((~(i10 - length)) >>> 31);
                                                while (i9 < i12) {
                                                    if ((j6 & 255) < 128) {
                                                        int i13 = (i10 << 3) + i9;
                                                        Object obj = map.keys[i13];
                                                        Object obj2 = map.values[i13];
                                                        if (obj2 instanceof MutableScatterSet) {
                                                            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type androidx.collection.MutableScatterSet<Scope of androidx.compose.runtime.collection.ScopeMap.removeScopeIf$lambda$2>");
                                                            MutableScatterSet mutableScatterSet = (MutableScatterSet) obj2;
                                                            Object[] objArr = mutableScatterSet.elements;
                                                            long[] jArr6 = mutableScatterSet.metadata;
                                                            int length2 = jArr6.length - 2;
                                                            rememberEventDispatcher3 = rememberEventDispatcher4;
                                                            jArr2 = jArr5;
                                                            if (length2 >= 0) {
                                                                int i14 = 0;
                                                                while (true) {
                                                                    try {
                                                                        long j8 = jArr6[i14];
                                                                        i6 = length;
                                                                        i7 = i10;
                                                                        c5 = 7;
                                                                        j5 = -9187201950435737472L;
                                                                        if ((((~j8) << 7) & j8 & (-9187201950435737472L)) != -9187201950435737472L) {
                                                                            int i15 = 8 - ((~(i14 - length2)) >>> 31);
                                                                            int i16 = 0;
                                                                            while (i16 < i15) {
                                                                                if ((j8 & 255) < 128) {
                                                                                    jArr4 = jArr6;
                                                                                    int i17 = (i14 << 3) + i16;
                                                                                    if (!((RecomposeScopeImpl) objArr[i17]).getValid()) {
                                                                                        mutableScatterSet.removeElementAt(i17);
                                                                                    }
                                                                                } else {
                                                                                    jArr4 = jArr6;
                                                                                }
                                                                                j8 >>= 8;
                                                                                i16++;
                                                                                jArr6 = jArr4;
                                                                            }
                                                                            jArr3 = jArr6;
                                                                            if (i15 != 8) {
                                                                                break;
                                                                            }
                                                                        } else {
                                                                            jArr3 = jArr6;
                                                                        }
                                                                        if (i14 == length2) {
                                                                            break;
                                                                        }
                                                                        i14++;
                                                                        length = i6;
                                                                        i10 = i7;
                                                                        jArr6 = jArr3;
                                                                    } catch (Throwable th) {
                                                                        th = th;
                                                                        Trace.INSTANCE.endSection(beginSection2);
                                                                        throw th;
                                                                    }
                                                                }
                                                            } else {
                                                                i6 = length;
                                                                i7 = i10;
                                                                c5 = 7;
                                                                j5 = -9187201950435737472L;
                                                            }
                                                            z6 = mutableScatterSet.isEmpty();
                                                        } else {
                                                            rememberEventDispatcher3 = rememberEventDispatcher4;
                                                            jArr2 = jArr5;
                                                            i6 = length;
                                                            i7 = i10;
                                                            c5 = c6;
                                                            j5 = -9187201950435737472L;
                                                            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type Scope of androidx.compose.runtime.collection.ScopeMap.removeScopeIf$lambda$2");
                                                            z6 = !((RecomposeScopeImpl) obj2).getValid();
                                                        }
                                                        if (z6) {
                                                            map.removeValueAt(i13);
                                                        }
                                                        i8 = 8;
                                                    } else {
                                                        rememberEventDispatcher3 = rememberEventDispatcher4;
                                                        jArr2 = jArr5;
                                                        i6 = length;
                                                        i7 = i10;
                                                        c5 = c6;
                                                        j5 = j7;
                                                        i8 = i11;
                                                    }
                                                    j6 >>= i8;
                                                    i9++;
                                                    i11 = i8;
                                                    z7 = true;
                                                    c6 = c5;
                                                    j7 = j5;
                                                    jArr5 = jArr2;
                                                    rememberEventDispatcher4 = rememberEventDispatcher3;
                                                    length = i6;
                                                    i10 = i7;
                                                }
                                                z5 = z7;
                                                rememberEventDispatcher2 = rememberEventDispatcher4;
                                                jArr = jArr5;
                                                int i18 = length;
                                                int i19 = i10;
                                                if (i12 != i11) {
                                                    break;
                                                }
                                                length = i18;
                                                i5 = i19;
                                            } else {
                                                z5 = z7;
                                                rememberEventDispatcher2 = rememberEventDispatcher4;
                                                jArr = jArr5;
                                                i5 = i10;
                                            }
                                            if (i5 == length) {
                                                break;
                                            }
                                            i10 = i5 + 1;
                                            z7 = z5;
                                            jArr5 = jArr;
                                            rememberEventDispatcher4 = rememberEventDispatcher2;
                                            i9 = 0;
                                        }
                                    } else {
                                        rememberEventDispatcher2 = rememberEventDispatcher4;
                                    }
                                    cleanUpDerivedStateObservations();
                                    Unit unit2 = Unit.INSTANCE;
                                    Trace.INSTANCE.endSection(beginSection2);
                                } catch (Throwable th2) {
                                    th = th2;
                                }
                            } catch (Throwable th3) {
                                th = th3;
                                rememberEventDispatcher = rememberEventDispatcher4;
                                compositionImpl = this;
                                if (compositionImpl.lateChanges.isEmpty()) {
                                    rememberEventDispatcher.dispatchAbandons();
                                }
                                throw th;
                            }
                        } catch (Throwable th4) {
                            th = th4;
                            compositionImpl = this;
                            if (compositionImpl.lateChanges.isEmpty()) {
                            }
                            throw th;
                        }
                    } else {
                        rememberEventDispatcher2 = rememberEventDispatcher4;
                    }
                    if (this.lateChanges.isEmpty()) {
                        rememberEventDispatcher2.dispatchAbandons();
                    }
                } catch (Throwable th5) {
                    rememberEventDispatcher = rememberEventDispatcher4;
                    try {
                        openWriter.close(false);
                        throw th5;
                    } catch (Throwable th6) {
                        th = th6;
                        try {
                            Trace.INSTANCE.endSection(beginSection);
                            throw th;
                        } catch (Throwable th7) {
                            th = th7;
                            if (compositionImpl.lateChanges.isEmpty()) {
                            }
                            throw th;
                        }
                    }
                }
            } catch (Throwable th8) {
                th = th8;
                rememberEventDispatcher = rememberEventDispatcher4;
            }
        } catch (Throwable th9) {
            th = th9;
            rememberEventDispatcher = rememberEventDispatcher4;
        }
    }

    private final void cleanUpDerivedStateObservations() {
        long[] jArr;
        int i5;
        long[] jArr2;
        int i6;
        int i7;
        int i8;
        boolean z5;
        Object[] objArr;
        long[] jArr3;
        long[] jArr4;
        MutableScatterMap<Object, Object> map = this.derivedStates.getMap();
        long[] jArr5 = map.metadata;
        int length = jArr5.length - 2;
        char c5 = 7;
        long j5 = -9187201950435737472L;
        int i9 = 8;
        if (length >= 0) {
            int i10 = 0;
            while (true) {
                long j6 = jArr5[i10];
                if ((((~j6) << c5) & j6 & j5) != j5) {
                    int i11 = 8 - ((~(i10 - length)) >>> 31);
                    int i12 = 0;
                    while (i12 < i11) {
                        if ((j6 & 255) < 128) {
                            int i13 = (i10 << 3) + i12;
                            Object obj = map.keys[i13];
                            Object obj2 = map.values[i13];
                            if (obj2 instanceof MutableScatterSet) {
                                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type androidx.collection.MutableScatterSet<Scope of androidx.compose.runtime.collection.ScopeMap.removeScopeIf$lambda$2>");
                                MutableScatterSet mutableScatterSet = (MutableScatterSet) obj2;
                                Object[] objArr2 = mutableScatterSet.elements;
                                long[] jArr6 = mutableScatterSet.metadata;
                                int length2 = jArr6.length - 2;
                                jArr2 = jArr5;
                                i6 = length;
                                if (length2 >= 0) {
                                    int i14 = 0;
                                    while (true) {
                                        long j7 = jArr6[i14];
                                        i7 = i10;
                                        Object[] objArr3 = objArr2;
                                        if ((((~j7) << c5) & j7 & (-9187201950435737472L)) != -9187201950435737472L) {
                                            int i15 = 8 - ((~(i14 - length2)) >>> 31);
                                            int i16 = 0;
                                            while (i16 < i15) {
                                                int i17 = i16;
                                                Object[] objArr4 = objArr3;
                                                if ((j7 & 255) < 128) {
                                                    int i18 = (i14 << 3) + i17;
                                                    jArr4 = jArr6;
                                                    if (!this.observations.contains((DerivedState) objArr4[i18])) {
                                                        mutableScatterSet.removeElementAt(i18);
                                                    }
                                                } else {
                                                    jArr4 = jArr6;
                                                }
                                                j7 >>= 8;
                                                i16 = i17 + 1;
                                                jArr6 = jArr4;
                                                objArr3 = objArr4;
                                            }
                                            objArr = objArr3;
                                            jArr3 = jArr6;
                                            if (i15 != 8) {
                                                break;
                                            }
                                        } else {
                                            objArr = objArr3;
                                            jArr3 = jArr6;
                                        }
                                        if (i14 == length2) {
                                            break;
                                        }
                                        i14++;
                                        jArr6 = jArr3;
                                        objArr2 = objArr;
                                        i10 = i7;
                                        c5 = 7;
                                    }
                                } else {
                                    i7 = i10;
                                }
                                z5 = mutableScatterSet.isEmpty();
                            } else {
                                jArr2 = jArr5;
                                i6 = length;
                                i7 = i10;
                                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type Scope of androidx.compose.runtime.collection.ScopeMap.removeScopeIf$lambda$2");
                                z5 = !this.observations.contains((DerivedState) obj2);
                            }
                            if (z5) {
                                map.removeValueAt(i13);
                            }
                            i8 = 8;
                        } else {
                            jArr2 = jArr5;
                            i6 = length;
                            i7 = i10;
                            i8 = i9;
                        }
                        j6 >>= i8;
                        i12++;
                        i9 = i8;
                        jArr5 = jArr2;
                        length = i6;
                        i10 = i7;
                        c5 = 7;
                    }
                    jArr = jArr5;
                    int i19 = length;
                    int i20 = i10;
                    if (i11 != i9) {
                        break;
                    }
                    length = i19;
                    i5 = i20;
                } else {
                    jArr = jArr5;
                    i5 = i10;
                }
                if (i5 == length) {
                    break;
                }
                i10 = i5 + 1;
                jArr5 = jArr;
                c5 = 7;
                j5 = -9187201950435737472L;
                i9 = 8;
            }
        }
        if (!this.conditionallyInvalidatedScopes.isNotEmpty()) {
            return;
        }
        MutableScatterSet<RecomposeScopeImpl> mutableScatterSet2 = this.conditionallyInvalidatedScopes;
        Object[] objArr5 = mutableScatterSet2.elements;
        long[] jArr7 = mutableScatterSet2.metadata;
        int length3 = jArr7.length - 2;
        if (length3 < 0) {
            return;
        }
        int i21 = 0;
        while (true) {
            long j8 = jArr7[i21];
            if ((((~j8) << 7) & j8 & (-9187201950435737472L)) != -9187201950435737472L) {
                int i22 = 8 - ((~(i21 - length3)) >>> 31);
                for (int i23 = 0; i23 < i22; i23++) {
                    if ((j8 & 255) < 128) {
                        int i24 = (i21 << 3) + i23;
                        if (!((RecomposeScopeImpl) objArr5[i24]).isConditional()) {
                            mutableScatterSet2.removeElementAt(i24);
                        }
                    }
                    j8 >>= 8;
                }
                if (i22 != 8) {
                    return;
                }
            }
            if (i21 == length3) {
                return;
            } else {
                i21++;
            }
        }
    }

    private final void composeInitial(Function2<? super Composer, ? super Integer, Unit> content) {
        if (this.disposed) {
            PreconditionsKt.throwIllegalStateException("The composition is disposed");
        }
        this.composable = content;
        this.parent.composeInitial$runtime_release(this, content);
    }

    private final void drainPendingModificationsForCompositionLocked() {
        Object obj;
        Object obj2;
        AtomicReference<Object> atomicReference = this.pendingModifications;
        obj = CompositionKt.PendingApplyNoModifications;
        Object andSet = atomicReference.getAndSet(obj);
        if (andSet != null) {
            obj2 = CompositionKt.PendingApplyNoModifications;
            if (Intrinsics.areEqual(andSet, obj2)) {
                ComposerKt.composeRuntimeError("pending composition has not been applied");
                throw new KotlinNothingValueException();
            }
            if (andSet instanceof Set) {
                addPendingInvalidationsLocked((Set<? extends Object>) andSet, true);
                return;
            }
            if (!(andSet instanceof Object[])) {
                ComposerKt.composeRuntimeError("corrupt pendingModifications drain: " + this.pendingModifications);
                throw new KotlinNothingValueException();
            }
            for (Set<? extends Object> set : (Set[]) andSet) {
                addPendingInvalidationsLocked(set, true);
            }
        }
    }

    private final void drainPendingModificationsLocked() {
        Object obj;
        Object andSet = this.pendingModifications.getAndSet(null);
        obj = CompositionKt.PendingApplyNoModifications;
        if (Intrinsics.areEqual(andSet, obj)) {
            return;
        }
        if (andSet instanceof Set) {
            addPendingInvalidationsLocked((Set<? extends Object>) andSet, false);
            return;
        }
        if (andSet instanceof Object[]) {
            for (Set<? extends Object> set : (Set[]) andSet) {
                addPendingInvalidationsLocked(set, false);
            }
            return;
        }
        if (andSet == null) {
            ComposerKt.composeRuntimeError("calling recordModificationsOf and applyChanges concurrently is not supported");
            throw new KotlinNothingValueException();
        }
        ComposerKt.composeRuntimeError("corrupt pendingModifications drain: " + this.pendingModifications);
        throw new KotlinNothingValueException();
    }

    private final boolean getAreChildrenComposing() {
        return this.composer.getAreChildrenComposing$runtime_release();
    }

    private final InvalidationResult invalidateChecked(RecomposeScopeImpl scope, Anchor anchor, Object instance) {
        int i5;
        synchronized (this.lock) {
            try {
                CompositionImpl compositionImpl = this.invalidationDelegate;
                CompositionImpl compositionImpl2 = null;
                if (compositionImpl != null) {
                    if (!this.slotTable.groupContainsAnchor(this.invalidationDelegateGroup, anchor)) {
                        compositionImpl = null;
                    }
                    compositionImpl2 = compositionImpl;
                }
                if (compositionImpl2 == null) {
                    if (tryImminentInvalidation(scope, instance)) {
                        return InvalidationResult.IMMINENT;
                    }
                    observer();
                    if (instance == null) {
                        this.invalidations.set(scope, ScopeInvalidated.INSTANCE);
                    } else if (instance instanceof DerivedState) {
                        Object obj = this.invalidations.getMap().get(scope);
                        if (obj != null) {
                            if (obj instanceof MutableScatterSet) {
                                MutableScatterSet mutableScatterSet = (MutableScatterSet) obj;
                                Object[] objArr = mutableScatterSet.elements;
                                long[] jArr = mutableScatterSet.metadata;
                                int length = jArr.length - 2;
                                if (length >= 0) {
                                    int i6 = 0;
                                    loop0: while (true) {
                                        long j5 = jArr[i6];
                                        if ((((~j5) << 7) & j5 & (-9187201950435737472L)) != -9187201950435737472L) {
                                            int i7 = 8;
                                            int i8 = 8 - ((~(i6 - length)) >>> 31);
                                            int i9 = 0;
                                            while (i9 < i8) {
                                                if ((j5 & 255) >= 128) {
                                                    i5 = i7;
                                                } else {
                                                    if (objArr[(i6 << 3) + i9] == ScopeInvalidated.INSTANCE) {
                                                        break loop0;
                                                    }
                                                    i5 = 8;
                                                }
                                                j5 >>= i5;
                                                i9++;
                                                i7 = i5;
                                            }
                                            if (i8 != i7) {
                                                break;
                                            }
                                        }
                                        if (i6 == length) {
                                            break;
                                        }
                                        i6++;
                                    }
                                }
                            } else if (obj == ScopeInvalidated.INSTANCE) {
                            }
                        }
                        this.invalidations.add(scope, instance);
                    } else {
                        this.invalidations.set(scope, ScopeInvalidated.INSTANCE);
                    }
                }
                if (compositionImpl2 != null) {
                    return compositionImpl2.invalidateChecked(scope, anchor, instance);
                }
                this.parent.invalidate$runtime_release(this);
                return isComposing() ? InvalidationResult.DEFERRED : InvalidationResult.SCHEDULED;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private final void invalidateScopeOfLocked(Object value) {
        Object obj = this.observations.getMap().get(value);
        if (obj == null) {
            return;
        }
        if (!(obj instanceof MutableScatterSet)) {
            RecomposeScopeImpl recomposeScopeImpl = (RecomposeScopeImpl) obj;
            if (recomposeScopeImpl.invalidateForResult(value) == InvalidationResult.IMMINENT) {
                this.observationsProcessed.add(value, recomposeScopeImpl);
                return;
            }
            return;
        }
        MutableScatterSet mutableScatterSet = (MutableScatterSet) obj;
        Object[] objArr = mutableScatterSet.elements;
        long[] jArr = mutableScatterSet.metadata;
        int length = jArr.length - 2;
        if (length < 0) {
            return;
        }
        int i5 = 0;
        while (true) {
            long j5 = jArr[i5];
            if ((((~j5) << 7) & j5 & (-9187201950435737472L)) != -9187201950435737472L) {
                int i6 = 8 - ((~(i5 - length)) >>> 31);
                for (int i7 = 0; i7 < i6; i7++) {
                    if ((255 & j5) < 128) {
                        RecomposeScopeImpl recomposeScopeImpl2 = (RecomposeScopeImpl) objArr[(i5 << 3) + i7];
                        if (recomposeScopeImpl2.invalidateForResult(value) == InvalidationResult.IMMINENT) {
                            this.observationsProcessed.add(value, recomposeScopeImpl2);
                        }
                    }
                    j5 >>= 8;
                }
                if (i6 != 8) {
                    return;
                }
            }
            if (i5 == length) {
                return;
            } else {
                i5++;
            }
        }
    }

    private final CompositionObserver observer() {
        CompositionObserverHolder compositionObserverHolder = this.observerHolder;
        if (compositionObserverHolder.getRoot()) {
            compositionObserverHolder.getObserver();
        } else {
            CompositionObserverHolder observerHolder = this.parent.getObserverHolder();
            if (observerHolder != null) {
                observerHolder.getObserver();
            }
            compositionObserverHolder.getObserver();
            if (!Intrinsics.areEqual((Object) null, (Object) null)) {
                compositionObserverHolder.setObserver(null);
            }
        }
        return null;
    }

    private final ScopeMap<RecomposeScopeImpl, Object> takeInvalidations() {
        ScopeMap<RecomposeScopeImpl, Object> scopeMap = this.invalidations;
        this.invalidations = new ScopeMap<>();
        return scopeMap;
    }

    private final boolean tryImminentInvalidation(RecomposeScopeImpl scope, Object instance) {
        return isComposing() && this.composer.tryImminentInvalidation$runtime_release(scope, instance);
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public void abandonChanges() {
        this.pendingModifications.set(null);
        this.changes.clear();
        this.lateChanges.clear();
        if (this.abandonSet.isEmpty()) {
            return;
        }
        new RememberEventDispatcher(this.abandonSet).dispatchAbandons();
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public void applyChanges() {
        synchronized (this.lock) {
            try {
                applyChangesInLocked(this.changes);
                drainPendingModificationsLocked();
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                try {
                    try {
                        if (!this.abandonSet.isEmpty()) {
                            new RememberEventDispatcher(this.abandonSet).dispatchAbandons();
                        }
                        throw th;
                    } catch (Exception e5) {
                        abandonChanges();
                        throw e5;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public void applyLateChanges() {
        synchronized (this.lock) {
            try {
                if (this.lateChanges.isNotEmpty()) {
                    applyChangesInLocked(this.lateChanges);
                }
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                try {
                    try {
                        if (!this.abandonSet.isEmpty()) {
                            new RememberEventDispatcher(this.abandonSet).dispatchAbandons();
                        }
                        throw th;
                    } catch (Exception e5) {
                        abandonChanges();
                        throw e5;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public void changesApplied() {
        synchronized (this.lock) {
            try {
                this.composer.changesApplied$runtime_release();
                if (!this.abandonSet.isEmpty()) {
                    new RememberEventDispatcher(this.abandonSet).dispatchAbandons();
                }
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                try {
                    try {
                        if (!this.abandonSet.isEmpty()) {
                            new RememberEventDispatcher(this.abandonSet).dispatchAbandons();
                        }
                        throw th;
                    } catch (Exception e5) {
                        abandonChanges();
                        throw e5;
                    }
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public void composeContent(Function2<? super Composer, ? super Integer, Unit> content) {
        try {
            synchronized (this.lock) {
                drainPendingModificationsForCompositionLocked();
                ScopeMap<RecomposeScopeImpl, Object> takeInvalidations = takeInvalidations();
                try {
                    observer();
                    this.composer.composeContent$runtime_release(takeInvalidations, content);
                } catch (Exception e5) {
                    this.invalidations = takeInvalidations;
                    throw e5;
                }
            }
        } catch (Throwable th) {
            try {
                if (!this.abandonSet.isEmpty()) {
                    new RememberEventDispatcher(this.abandonSet).dispatchAbandons();
                }
                throw th;
            } catch (Exception e6) {
                abandonChanges();
                throw e6;
            }
        }
    }

    @Override // androidx.compose.runtime.ReusableComposition
    public void deactivate() {
        Trace trace;
        Object beginSection;
        synchronized (this.lock) {
            try {
                boolean z5 = this.slotTable.getGroupsSize() > 0;
                try {
                    if (!z5) {
                        if (!this.abandonSet.isEmpty()) {
                        }
                        this.observations.clear();
                        this.derivedStates.clear();
                        this.invalidations.clear();
                        this.changes.clear();
                        this.lateChanges.clear();
                        this.composer.deactivate$runtime_release();
                        Unit unit = Unit.INSTANCE;
                    }
                    RememberEventDispatcher rememberEventDispatcher = new RememberEventDispatcher(this.abandonSet);
                    if (z5) {
                        this.applier.onBeginChanges();
                        SlotWriter openWriter = this.slotTable.openWriter();
                        try {
                            ComposerKt.deactivateCurrentGroup(openWriter, rememberEventDispatcher);
                            Unit unit2 = Unit.INSTANCE;
                            openWriter.close(true);
                            this.applier.onEndChanges();
                            rememberEventDispatcher.dispatchRememberObservers();
                        } catch (Throwable th) {
                            openWriter.close(false);
                            throw th;
                        }
                    }
                    rememberEventDispatcher.dispatchAbandons();
                    Unit unit3 = Unit.INSTANCE;
                    trace.endSection(beginSection);
                    this.observations.clear();
                    this.derivedStates.clear();
                    this.invalidations.clear();
                    this.changes.clear();
                    this.lateChanges.clear();
                    this.composer.deactivate$runtime_release();
                    Unit unit4 = Unit.INSTANCE;
                } catch (Throwable th2) {
                    Trace.INSTANCE.endSection(beginSection);
                    throw th2;
                }
                trace = Trace.INSTANCE;
                beginSection = trace.beginSection("Compose:deactivate");
            } catch (Throwable th3) {
                throw th3;
            }
        }
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public <R> R delegateInvalidations(ControlledComposition to, int groupIndex, Function0<? extends R> block) {
        if (to == null || Intrinsics.areEqual(to, this) || groupIndex < 0) {
            return block.invoke();
        }
        this.invalidationDelegate = (CompositionImpl) to;
        this.invalidationDelegateGroup = groupIndex;
        try {
            return block.invoke();
        } finally {
            this.invalidationDelegate = null;
            this.invalidationDelegateGroup = 0;
        }
    }

    @Override // androidx.compose.runtime.Composition
    public void dispose() {
        synchronized (this.lock) {
            try {
                if (this.composer.getIsComposing()) {
                    PreconditionsKt.throwIllegalStateException("Composition is disposed while composing. If dispose is triggered by a call in @Composable function, consider wrapping it with SideEffect block.");
                }
                if (!this.disposed) {
                    this.disposed = true;
                    this.composable = ComposableSingletons$CompositionKt.INSTANCE.m1210getLambda2$runtime_release();
                    ChangeList deferredChanges = this.composer.getDeferredChanges();
                    if (deferredChanges != null) {
                        applyChangesInLocked(deferredChanges);
                    }
                    boolean z5 = this.slotTable.getGroupsSize() > 0;
                    if (z5 || !this.abandonSet.isEmpty()) {
                        RememberEventDispatcher rememberEventDispatcher = new RememberEventDispatcher(this.abandonSet);
                        if (z5) {
                            this.applier.onBeginChanges();
                            SlotWriter openWriter = this.slotTable.openWriter();
                            try {
                                ComposerKt.removeCurrentGroup(openWriter, rememberEventDispatcher);
                                Unit unit = Unit.INSTANCE;
                                openWriter.close(true);
                                this.applier.clear();
                                this.applier.onEndChanges();
                                rememberEventDispatcher.dispatchRememberObservers();
                            } catch (Throwable th) {
                                openWriter.close(false);
                                throw th;
                            }
                        }
                        rememberEventDispatcher.dispatchAbandons();
                    }
                    this.composer.dispose$runtime_release();
                }
                Unit unit2 = Unit.INSTANCE;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        this.parent.unregisterComposition$runtime_release(this);
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public void disposeUnusedMovableContent(MovableContentState state) {
        RememberEventDispatcher rememberEventDispatcher = new RememberEventDispatcher(this.abandonSet);
        SlotWriter openWriter = state.getSlotTable$runtime_release().openWriter();
        try {
            ComposerKt.removeCurrentGroup(openWriter, rememberEventDispatcher);
            Unit unit = Unit.INSTANCE;
            openWriter.close(true);
            rememberEventDispatcher.dispatchRememberObservers();
        } catch (Throwable th) {
            openWriter.close(false);
            throw th;
        }
    }

    @Override // androidx.compose.runtime.Composition
    public boolean getHasInvalidations() {
        boolean z5;
        synchronized (this.lock) {
            z5 = this.invalidations.getSize() > 0;
        }
        return z5;
    }

    /* renamed from: getObserverHolder$runtime_release, reason: from getter */
    public final CompositionObserverHolder getObserverHolder() {
        return this.observerHolder;
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public void insertMovableContent(List<Pair<MovableContentStateReference, MovableContentStateReference>> references) {
        boolean z5 = true;
        int size = references.size();
        int i5 = 0;
        while (true) {
            if (i5 >= size) {
                break;
            }
            if (!Intrinsics.areEqual(references.get(i5).getFirst().getComposition(), this)) {
                z5 = false;
                break;
            }
            i5++;
        }
        ComposerKt.runtimeCheck(z5);
        try {
            this.composer.insertMovableContentReferences(references);
            Unit unit = Unit.INSTANCE;
        } finally {
        }
    }

    @Override // androidx.compose.runtime.RecomposeScopeOwner
    public InvalidationResult invalidate(RecomposeScopeImpl scope, Object instance) {
        CompositionImpl compositionImpl;
        if (scope.getDefaultsInScope()) {
            scope.setDefaultsInvalid(true);
        }
        Anchor anchor = scope.getAnchor();
        if (anchor == null || !anchor.getValid()) {
            return InvalidationResult.IGNORED;
        }
        if (this.slotTable.ownsAnchor(anchor)) {
            return !scope.getCanRecompose() ? InvalidationResult.IGNORED : invalidateChecked(scope, anchor, instance);
        }
        synchronized (this.lock) {
            compositionImpl = this.invalidationDelegate;
        }
        return (compositionImpl == null || !compositionImpl.tryImminentInvalidation(scope, instance)) ? InvalidationResult.IGNORED : InvalidationResult.IMMINENT;
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public void invalidateAll() {
        synchronized (this.lock) {
            try {
                for (Object obj : this.slotTable.getSlots()) {
                    RecomposeScopeImpl recomposeScopeImpl = obj instanceof RecomposeScopeImpl ? (RecomposeScopeImpl) obj : null;
                    if (recomposeScopeImpl != null) {
                        recomposeScopeImpl.invalidate();
                    }
                }
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public boolean isComposing() {
        return this.composer.getIsComposing();
    }

    @Override // androidx.compose.runtime.Composition
    /* renamed from: isDisposed, reason: from getter */
    public boolean getDisposed() {
        return this.disposed;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0050, code lost:
    
        return true;
     */
    @Override // androidx.compose.runtime.ControlledComposition
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean observesAnyOf(Set<? extends Object> values) {
        if (values instanceof ScatterSetWrapper) {
            ScatterSet set$runtime_release = ((ScatterSetWrapper) values).getSet$runtime_release();
            Object[] objArr = set$runtime_release.elements;
            long[] jArr = set$runtime_release.metadata;
            int length = jArr.length - 2;
            if (length >= 0) {
                int i5 = 0;
                loop0: while (true) {
                    long j5 = jArr[i5];
                    if ((((~j5) << 7) & j5 & (-9187201950435737472L)) != -9187201950435737472L) {
                        int i6 = 8 - ((~(i5 - length)) >>> 31);
                        for (int i7 = 0; i7 < i6; i7++) {
                            if ((255 & j5) < 128) {
                                Object obj = objArr[(i5 << 3) + i7];
                                if (this.observations.contains(obj) || this.derivedStates.contains(obj)) {
                                    break loop0;
                                }
                            }
                            j5 >>= 8;
                        }
                        if (i6 != 8) {
                            break;
                        }
                    }
                    if (i5 == length) {
                        break;
                    }
                    i5++;
                }
            }
        } else {
            for (Object obj2 : values) {
                if (this.observations.contains(obj2) || this.derivedStates.contains(obj2)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public void prepareCompose(Function0<Unit> block) {
        this.composer.prepareCompose$runtime_release(block);
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public boolean recompose() {
        boolean recompose$runtime_release;
        synchronized (this.lock) {
            try {
                drainPendingModificationsForCompositionLocked();
                try {
                    ScopeMap<RecomposeScopeImpl, Object> takeInvalidations = takeInvalidations();
                    try {
                        observer();
                        recompose$runtime_release = this.composer.recompose$runtime_release(takeInvalidations);
                        if (!recompose$runtime_release) {
                            drainPendingModificationsLocked();
                        }
                    } catch (Exception e5) {
                        this.invalidations = takeInvalidations;
                        throw e5;
                    }
                } catch (Throwable th) {
                    try {
                        if (!this.abandonSet.isEmpty()) {
                            new RememberEventDispatcher(this.abandonSet).dispatchAbandons();
                        }
                        throw th;
                    } catch (Exception e6) {
                        abandonChanges();
                        throw e6;
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return recompose$runtime_release;
    }

    @Override // androidx.compose.runtime.RecomposeScopeOwner
    public void recomposeScopeReleased(RecomposeScopeImpl scope) {
        this.pendingInvalidScopes = true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r2v6, types: [java.util.Set[]] */
    @Override // androidx.compose.runtime.ControlledComposition
    public void recordModificationsOf(Set<? extends Object> values) {
        Object obj;
        Object obj2;
        boolean areEqual;
        Set<? extends Object> set;
        do {
            obj = this.pendingModifications.get();
            if (obj == null) {
                areEqual = true;
            } else {
                obj2 = CompositionKt.PendingApplyNoModifications;
                areEqual = Intrinsics.areEqual(obj, obj2);
            }
            if (areEqual) {
                set = values;
            } else if (obj instanceof Set) {
                set = new Set[]{obj, values};
            } else {
                if (!(obj instanceof Object[])) {
                    throw new IllegalStateException(("corrupt pendingModifications: " + this.pendingModifications).toString());
                }
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Array<kotlin.collections.Set<kotlin.Any>>");
                set = ArraysKt.plus((Set<? extends Object>[]) obj, values);
            }
        } while (!AbstractC0321h.a(this.pendingModifications, obj, set));
        if (obj == null) {
            synchronized (this.lock) {
                drainPendingModificationsLocked();
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    @Override // androidx.compose.runtime.ControlledComposition, androidx.compose.runtime.RecomposeScopeOwner
    public void recordReadOf(Object value) {
        RecomposeScopeImpl currentRecomposeScope$runtime_release;
        long[] jArr;
        long[] jArr2;
        int i5;
        if (getAreChildrenComposing() || (currentRecomposeScope$runtime_release = this.composer.getCurrentRecomposeScope$runtime_release()) == null) {
            return;
        }
        currentRecomposeScope$runtime_release.setUsed(true);
        if (currentRecomposeScope$runtime_release.recordRead(value)) {
            return;
        }
        if (value instanceof StateObjectImpl) {
            ((StateObjectImpl) value).m1250recordReadInh_f27i8$runtime_release(ReaderKind.m1248constructorimpl(1));
        }
        this.observations.add(value, currentRecomposeScope$runtime_release);
        if (value instanceof DerivedState) {
            DerivedState<?> derivedState = (DerivedState) value;
            DerivedState.Record<?> currentRecord = derivedState.getCurrentRecord();
            this.derivedStates.removeScope(value);
            ObjectIntMap<StateObject> dependencies = currentRecord.getDependencies();
            Object[] objArr = dependencies.keys;
            long[] jArr3 = dependencies.metadata;
            int length = jArr3.length - 2;
            if (length >= 0) {
                int i6 = 0;
                while (true) {
                    long j5 = jArr3[i6];
                    if ((((~j5) << 7) & j5 & (-9187201950435737472L)) != -9187201950435737472L) {
                        int i7 = 8;
                        int i8 = 8 - ((~(i6 - length)) >>> 31);
                        int i9 = 0;
                        while (i9 < i8) {
                            if ((j5 & 255) < 128) {
                                StateObject stateObject = (StateObject) objArr[(i6 << 3) + i9];
                                if (stateObject instanceof StateObjectImpl) {
                                    jArr2 = jArr3;
                                    ((StateObjectImpl) stateObject).m1250recordReadInh_f27i8$runtime_release(ReaderKind.m1248constructorimpl(1));
                                } else {
                                    jArr2 = jArr3;
                                }
                                this.derivedStates.add(stateObject, value);
                                i5 = 8;
                            } else {
                                jArr2 = jArr3;
                                i5 = i7;
                            }
                            j5 >>= i5;
                            i9++;
                            i7 = i5;
                            jArr3 = jArr2;
                        }
                        jArr = jArr3;
                        if (i8 != i7) {
                            break;
                        }
                    } else {
                        jArr = jArr3;
                    }
                    if (i6 == length) {
                        break;
                    }
                    i6++;
                    jArr3 = jArr;
                }
            }
            currentRecomposeScope$runtime_release.recordDerivedStateValue(derivedState, currentRecord.getCurrentValue());
        }
    }

    @Override // androidx.compose.runtime.ControlledComposition
    public void recordWriteOf(Object value) {
        synchronized (this.lock) {
            try {
                invalidateScopeOfLocked(value);
                Object obj = this.derivedStates.getMap().get(value);
                if (obj != null) {
                    if (obj instanceof MutableScatterSet) {
                        MutableScatterSet mutableScatterSet = (MutableScatterSet) obj;
                        Object[] objArr = mutableScatterSet.elements;
                        long[] jArr = mutableScatterSet.metadata;
                        int length = jArr.length - 2;
                        if (length >= 0) {
                            int i5 = 0;
                            while (true) {
                                long j5 = jArr[i5];
                                if ((((~j5) << 7) & j5 & (-9187201950435737472L)) != -9187201950435737472L) {
                                    int i6 = 8 - ((~(i5 - length)) >>> 31);
                                    for (int i7 = 0; i7 < i6; i7++) {
                                        if ((255 & j5) < 128) {
                                            invalidateScopeOfLocked((DerivedState) objArr[(i5 << 3) + i7]);
                                        }
                                        j5 >>= 8;
                                    }
                                    if (i6 != 8) {
                                        break;
                                    }
                                }
                                if (i5 == length) {
                                    break;
                                } else {
                                    i5++;
                                }
                            }
                        }
                    } else {
                        invalidateScopeOfLocked((DerivedState) obj);
                    }
                }
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void removeDerivedStateObservation$runtime_release(DerivedState<?> state) {
        if (this.observations.contains(state)) {
            return;
        }
        this.derivedStates.removeScope(state);
    }

    public final void removeObservation$runtime_release(Object instance, RecomposeScopeImpl scope) {
        this.observations.remove(instance, scope);
    }

    @Override // androidx.compose.runtime.Composition
    public void setContent(Function2<? super Composer, ? super Integer, Unit> content) {
        composeInitial(content);
    }

    @Override // androidx.compose.runtime.ReusableComposition
    public void setContentWithReuse(Function2<? super Composer, ? super Integer, Unit> content) {
        this.composer.startReuseFromRoot();
        composeInitial(content);
        this.composer.endReuseFromRoot();
    }

    private final void addPendingInvalidationsLocked(Set<? extends Object> values, boolean forgetConditionalScopes) {
        int i5;
        long[] jArr;
        String str;
        int i6;
        long[] jArr2;
        int i7;
        int i8;
        String str2;
        int i9;
        boolean contains;
        Object[] objArr;
        long[] jArr3;
        Object[] objArr2;
        long[] jArr4;
        String str3;
        long[] jArr5;
        int i10;
        String str4;
        long[] jArr6;
        int i11;
        int i12;
        int i13;
        int i14;
        boolean z5;
        Object[] objArr3;
        long[] jArr7;
        Object[] objArr4;
        long[] jArr8;
        int i15;
        int i16;
        int i17;
        int i18;
        int i19;
        int i20;
        char c5 = 7;
        long j5 = -9187201950435737472L;
        int i21 = 8;
        if (values instanceof ScatterSetWrapper) {
            ScatterSet set$runtime_release = ((ScatterSetWrapper) values).getSet$runtime_release();
            Object[] objArr5 = set$runtime_release.elements;
            long[] jArr9 = set$runtime_release.metadata;
            int length = jArr9.length - 2;
            if (length >= 0) {
                int i22 = 0;
                while (true) {
                    long j6 = jArr9[i22];
                    if ((((~j6) << c5) & j6 & j5) != j5) {
                        int i23 = 8 - ((~(i22 - length)) >>> 31);
                        int i24 = 0;
                        while (i24 < i23) {
                            if ((j6 & 255) < 128) {
                                Object obj = objArr5[(i22 << 3) + i24];
                                if (obj instanceof RecomposeScopeImpl) {
                                    ((RecomposeScopeImpl) obj).invalidateForResult(null);
                                } else {
                                    addPendingInvalidationsLocked(obj, forgetConditionalScopes);
                                    Object obj2 = this.derivedStates.getMap().get(obj);
                                    if (obj2 != null) {
                                        if (obj2 instanceof MutableScatterSet) {
                                            MutableScatterSet mutableScatterSet = (MutableScatterSet) obj2;
                                            Object[] objArr6 = mutableScatterSet.elements;
                                            long[] jArr10 = mutableScatterSet.metadata;
                                            int length2 = jArr10.length - 2;
                                            if (length2 >= 0) {
                                                i18 = length;
                                                i19 = i22;
                                                int i25 = 0;
                                                while (true) {
                                                    long j7 = jArr10[i25];
                                                    i16 = i23;
                                                    i17 = i24;
                                                    if ((((~j7) << c5) & j7 & (-9187201950435737472L)) != -9187201950435737472L) {
                                                        int i26 = 8 - ((~(i25 - length2)) >>> 31);
                                                        for (int i27 = 0; i27 < i26; i27++) {
                                                            if ((j7 & 255) < 128) {
                                                                addPendingInvalidationsLocked((DerivedState) objArr6[(i25 << 3) + i27], forgetConditionalScopes);
                                                            }
                                                            j7 >>= 8;
                                                        }
                                                        if (i26 != 8) {
                                                            break;
                                                        }
                                                    }
                                                    if (i25 == length2) {
                                                        break;
                                                    }
                                                    i25++;
                                                    i23 = i16;
                                                    i24 = i17;
                                                    c5 = 7;
                                                }
                                            }
                                        } else {
                                            i16 = i23;
                                            i17 = i24;
                                            i18 = length;
                                            i19 = i22;
                                            addPendingInvalidationsLocked((DerivedState) obj2, forgetConditionalScopes);
                                        }
                                        i20 = 8;
                                    }
                                }
                                i16 = i23;
                                i17 = i24;
                                i18 = length;
                                i19 = i22;
                                i20 = 8;
                            } else {
                                i16 = i23;
                                i17 = i24;
                                i18 = length;
                                i19 = i22;
                                i20 = i21;
                            }
                            j6 >>= i20;
                            i24 = i17 + 1;
                            length = i18;
                            i21 = i20;
                            i22 = i19;
                            i23 = i16;
                            c5 = 7;
                        }
                        int i28 = length;
                        i15 = i22;
                        if (i23 != i21) {
                            break;
                        } else {
                            length = i28;
                        }
                    } else {
                        i15 = i22;
                    }
                    if (i15 == length) {
                        break;
                    }
                    i22 = i15 + 1;
                    c5 = 7;
                    j5 = -9187201950435737472L;
                    i21 = 8;
                }
            }
        } else {
            for (Object obj3 : values) {
                if (obj3 instanceof RecomposeScopeImpl) {
                    ((RecomposeScopeImpl) obj3).invalidateForResult(null);
                } else {
                    addPendingInvalidationsLocked(obj3, forgetConditionalScopes);
                    Object obj4 = this.derivedStates.getMap().get(obj3);
                    if (obj4 != null) {
                        if (obj4 instanceof MutableScatterSet) {
                            MutableScatterSet mutableScatterSet2 = (MutableScatterSet) obj4;
                            Object[] objArr7 = mutableScatterSet2.elements;
                            long[] jArr11 = mutableScatterSet2.metadata;
                            int length3 = jArr11.length - 2;
                            if (length3 >= 0) {
                                while (true) {
                                    long j8 = jArr11[i5];
                                    if ((((~j8) << 7) & j8 & (-9187201950435737472L)) != -9187201950435737472L) {
                                        int i29 = 8 - ((~(i5 - length3)) >>> 31);
                                        for (int i30 = 0; i30 < i29; i30++) {
                                            if ((j8 & 255) < 128) {
                                                addPendingInvalidationsLocked((DerivedState) objArr7[(i5 << 3) + i30], forgetConditionalScopes);
                                            }
                                            j8 >>= 8;
                                        }
                                        if (i29 != 8) {
                                            break;
                                        }
                                    }
                                    i5 = i5 != length3 ? i5 + 1 : 0;
                                }
                            }
                        } else {
                            addPendingInvalidationsLocked((DerivedState) obj4, forgetConditionalScopes);
                        }
                    }
                }
            }
        }
        MutableScatterSet<RecomposeScopeImpl> mutableScatterSet3 = this.conditionallyInvalidatedScopes;
        MutableScatterSet<RecomposeScopeImpl> mutableScatterSet4 = this.invalidatedScopes;
        String str5 = "null cannot be cast to non-null type androidx.collection.MutableScatterSet<Scope of androidx.compose.runtime.collection.ScopeMap.removeScopeIf$lambda$2>";
        if (forgetConditionalScopes && mutableScatterSet3.isNotEmpty()) {
            MutableScatterMap<Object, Object> map = this.observations.getMap();
            long[] jArr12 = map.metadata;
            int length4 = jArr12.length - 2;
            if (length4 >= 0) {
                int i31 = 0;
                while (true) {
                    long j9 = jArr12[i31];
                    if ((((~j9) << 7) & j9 & (-9187201950435737472L)) != -9187201950435737472L) {
                        int i32 = 8 - ((~(i31 - length4)) >>> 31);
                        int i33 = 0;
                        while (i33 < i32) {
                            if ((j9 & 255) < 128) {
                                int i34 = (i31 << 3) + i33;
                                Object obj5 = map.keys[i34];
                                Object obj6 = map.values[i34];
                                if (obj6 instanceof MutableScatterSet) {
                                    Intrinsics.checkNotNull(obj6, str5);
                                    MutableScatterSet mutableScatterSet5 = (MutableScatterSet) obj6;
                                    Object[] objArr8 = mutableScatterSet5.elements;
                                    jArr6 = jArr12;
                                    long[] jArr13 = mutableScatterSet5.metadata;
                                    str4 = str5;
                                    int length5 = jArr13.length - 2;
                                    i11 = length4;
                                    i12 = i31;
                                    if (length5 >= 0) {
                                        int i35 = 0;
                                        while (true) {
                                            long j10 = jArr13[i35];
                                            i13 = i32;
                                            i14 = i33;
                                            if ((((~j10) << 7) & j10 & (-9187201950435737472L)) != -9187201950435737472L) {
                                                int i36 = 8 - ((~(i35 - length5)) >>> 31);
                                                int i37 = 0;
                                                while (i37 < i36) {
                                                    if ((j10 & 255) < 128) {
                                                        jArr8 = jArr13;
                                                        int i38 = (i35 << 3) + i37;
                                                        objArr4 = objArr8;
                                                        RecomposeScopeImpl recomposeScopeImpl = (RecomposeScopeImpl) objArr8[i38];
                                                        if (mutableScatterSet3.contains(recomposeScopeImpl) || mutableScatterSet4.contains(recomposeScopeImpl)) {
                                                            mutableScatterSet5.removeElementAt(i38);
                                                        }
                                                    } else {
                                                        objArr4 = objArr8;
                                                        jArr8 = jArr13;
                                                    }
                                                    j10 >>= 8;
                                                    i37++;
                                                    jArr13 = jArr8;
                                                    objArr8 = objArr4;
                                                }
                                                objArr3 = objArr8;
                                                jArr7 = jArr13;
                                                if (i36 != 8) {
                                                    break;
                                                }
                                            } else {
                                                objArr3 = objArr8;
                                                jArr7 = jArr13;
                                            }
                                            if (i35 == length5) {
                                                break;
                                            }
                                            i35++;
                                            i32 = i13;
                                            i33 = i14;
                                            jArr13 = jArr7;
                                            objArr8 = objArr3;
                                        }
                                    } else {
                                        i13 = i32;
                                        i14 = i33;
                                    }
                                    z5 = mutableScatterSet5.isEmpty();
                                } else {
                                    str4 = str5;
                                    jArr6 = jArr12;
                                    i11 = length4;
                                    i12 = i31;
                                    i13 = i32;
                                    i14 = i33;
                                    Intrinsics.checkNotNull(obj6, "null cannot be cast to non-null type Scope of androidx.compose.runtime.collection.ScopeMap.removeScopeIf$lambda$2");
                                    RecomposeScopeImpl recomposeScopeImpl2 = (RecomposeScopeImpl) obj6;
                                    z5 = mutableScatterSet3.contains(recomposeScopeImpl2) || mutableScatterSet4.contains(recomposeScopeImpl2);
                                }
                                if (z5) {
                                    map.removeValueAt(i34);
                                }
                            } else {
                                str4 = str5;
                                jArr6 = jArr12;
                                i11 = length4;
                                i12 = i31;
                                i13 = i32;
                                i14 = i33;
                            }
                            j9 >>= 8;
                            i33 = i14 + 1;
                            length4 = i11;
                            jArr12 = jArr6;
                            str5 = str4;
                            i31 = i12;
                            i32 = i13;
                        }
                        str3 = str5;
                        jArr5 = jArr12;
                        int i39 = length4;
                        int i40 = i31;
                        if (i32 != 8) {
                            break;
                        }
                        length4 = i39;
                        i10 = i40;
                    } else {
                        str3 = str5;
                        jArr5 = jArr12;
                        i10 = i31;
                    }
                    if (i10 == length4) {
                        break;
                    }
                    i31 = i10 + 1;
                    jArr12 = jArr5;
                    str5 = str3;
                }
            }
            mutableScatterSet3.clear();
            cleanUpDerivedStateObservations();
            return;
        }
        String str6 = "null cannot be cast to non-null type androidx.collection.MutableScatterSet<Scope of androidx.compose.runtime.collection.ScopeMap.removeScopeIf$lambda$2>";
        if (mutableScatterSet4.isNotEmpty()) {
            MutableScatterMap<Object, Object> map2 = this.observations.getMap();
            long[] jArr14 = map2.metadata;
            int length6 = jArr14.length - 2;
            if (length6 >= 0) {
                int i41 = 0;
                while (true) {
                    long j11 = jArr14[i41];
                    if ((((~j11) << 7) & j11 & (-9187201950435737472L)) != -9187201950435737472L) {
                        int i42 = 8 - ((~(i41 - length6)) >>> 31);
                        int i43 = 0;
                        while (i43 < i42) {
                            if ((j11 & 255) < 128) {
                                int i44 = (i41 << 3) + i43;
                                Object obj7 = map2.keys[i44];
                                Object obj8 = map2.values[i44];
                                if (obj8 instanceof MutableScatterSet) {
                                    String str7 = str6;
                                    Intrinsics.checkNotNull(obj8, str7);
                                    MutableScatterSet mutableScatterSet6 = (MutableScatterSet) obj8;
                                    Object[] objArr9 = mutableScatterSet6.elements;
                                    long[] jArr15 = mutableScatterSet6.metadata;
                                    int length7 = jArr15.length - 2;
                                    jArr2 = jArr14;
                                    i7 = length6;
                                    i9 = i41;
                                    if (length7 >= 0) {
                                        int i45 = 0;
                                        while (true) {
                                            long j12 = jArr15[i45];
                                            str2 = str7;
                                            i8 = i42;
                                            if ((((~j12) << 7) & j12 & (-9187201950435737472L)) != -9187201950435737472L) {
                                                int i46 = 8 - ((~(i45 - length7)) >>> 31);
                                                int i47 = 0;
                                                while (i47 < i46) {
                                                    if ((j12 & 255) < 128) {
                                                        jArr4 = jArr15;
                                                        int i48 = (i45 << 3) + i47;
                                                        objArr2 = objArr9;
                                                        if (mutableScatterSet4.contains((RecomposeScopeImpl) objArr9[i48])) {
                                                            mutableScatterSet6.removeElementAt(i48);
                                                        }
                                                    } else {
                                                        objArr2 = objArr9;
                                                        jArr4 = jArr15;
                                                    }
                                                    j12 >>= 8;
                                                    i47++;
                                                    jArr15 = jArr4;
                                                    objArr9 = objArr2;
                                                }
                                                objArr = objArr9;
                                                jArr3 = jArr15;
                                                if (i46 != 8) {
                                                    break;
                                                }
                                            } else {
                                                objArr = objArr9;
                                                jArr3 = jArr15;
                                            }
                                            if (i45 == length7) {
                                                break;
                                            }
                                            i45++;
                                            i42 = i8;
                                            str7 = str2;
                                            jArr15 = jArr3;
                                            objArr9 = objArr;
                                        }
                                    } else {
                                        str2 = str7;
                                        i8 = i42;
                                    }
                                    contains = mutableScatterSet6.isEmpty();
                                } else {
                                    jArr2 = jArr14;
                                    i7 = length6;
                                    i8 = i42;
                                    str2 = str6;
                                    i9 = i41;
                                    Intrinsics.checkNotNull(obj8, "null cannot be cast to non-null type Scope of androidx.compose.runtime.collection.ScopeMap.removeScopeIf$lambda$2");
                                    contains = mutableScatterSet4.contains((RecomposeScopeImpl) obj8);
                                }
                                if (contains) {
                                    map2.removeValueAt(i44);
                                }
                            } else {
                                jArr2 = jArr14;
                                i7 = length6;
                                i8 = i42;
                                str2 = str6;
                                i9 = i41;
                            }
                            j11 >>= 8;
                            i43++;
                            length6 = i7;
                            jArr14 = jArr2;
                            i41 = i9;
                            i42 = i8;
                            str6 = str2;
                        }
                        jArr = jArr14;
                        int i49 = length6;
                        str = str6;
                        int i50 = i41;
                        if (i42 != 8) {
                            break;
                        }
                        length6 = i49;
                        i6 = i50;
                    } else {
                        jArr = jArr14;
                        str = str6;
                        i6 = i41;
                    }
                    if (i6 == length6) {
                        break;
                    }
                    i41 = i6 + 1;
                    jArr14 = jArr;
                    str6 = str;
                }
            }
            cleanUpDerivedStateObservations();
            mutableScatterSet4.clear();
        }
    }

    public /* synthetic */ CompositionImpl(CompositionContext compositionContext, Applier applier, CoroutineContext coroutineContext, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this(compositionContext, applier, (i5 & 4) != 0 ? null : coroutineContext);
    }
}
