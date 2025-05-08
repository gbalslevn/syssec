package androidx.compose.runtime;

import androidx.collection.MutableScatterSet;
import androidx.compose.runtime.Recomposer;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.collection.ScatterSetWrapperKt;
import androidx.compose.runtime.external.kotlinx.collections.immutable.ExtensionsKt;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentSet;
import androidx.compose.runtime.snapshots.MutableSnapshot;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.runtime.snapshots.SnapshotApplyResult;
import androidx.compose.runtime.tooling.CompositionData;
import com.adjust.sdk.Constants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CompletableJob;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.ExceptionsKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000þ\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0007\u0018\u0000 ±\u00012\u00020\u0001:\b±\u0001²\u0001³\u0001´\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H\u0002¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J1\u0010\u0017\u001a\u00020\u00072\n\u0010\u0013\u001a\u00060\u0011j\u0002`\u00122\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\b\u0002\u0010\u0016\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u0019\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u001e\u0010\u001dJ\u0017\u0010\u001f\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u001f\u0010\u001dJ\u0010\u0010 \u001a\u00020\u0007H\u0082@¢\u0006\u0004\b \u0010!J:\u0010(\u001a\u00020\u00072(\u0010'\u001a$\b\u0001\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020$\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070%\u0012\u0006\u0012\u0004\u0018\u00010&0\"H\u0082@¢\u0006\u0004\b(\u0010)J\u0017\u0010*\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u0014H\u0002¢\u0006\u0004\b*\u0010\u001dJ)\u0010-\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u001b\u001a\u00020\u00142\u000e\u0010,\u001a\n\u0012\u0004\u0012\u00020&\u0018\u00010+H\u0002¢\u0006\u0004\b-\u0010.J3\u00102\u001a\b\u0012\u0004\u0012\u00020\u00140/2\f\u00101\u001a\b\u0012\u0004\u0012\u0002000/2\u000e\u0010,\u001a\n\u0012\u0004\u0012\u00020&\u0018\u00010+H\u0002¢\u0006\u0004\b2\u00103J\u000f\u00104\u001a\u00020\u0007H\u0002¢\u0006\u0004\b4\u0010\u001aJ#\u00106\u001a\u000e\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020\u0007052\u0006\u0010\u001b\u001a\u00020\u0014H\u0002¢\u0006\u0004\b6\u00107J3\u00108\u001a\u000e\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020\u0007052\u0006\u0010\u001b\u001a\u00020\u00142\u000e\u0010,\u001a\n\u0012\u0004\u0012\u00020&\u0018\u00010+H\u0002¢\u0006\u0004\b8\u00109J\u0017\u0010<\u001a\u00020\u00072\u0006\u0010;\u001a\u00020:H\u0002¢\u0006\u0004\b<\u0010=J\u0010\u0010>\u001a\u00020\u0007H\u0086@¢\u0006\u0004\b>\u0010!J\r\u0010?\u001a\u00020\u0007¢\u0006\u0004\b?\u0010\u001aJ\u0010\u0010@\u001a\u00020\u0007H\u0086@¢\u0006\u0004\b@\u0010!J%\u0010E\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u00142\f\u0010B\u001a\b\u0012\u0004\u0012\u00020\u00070AH\u0010¢\u0006\u0004\bC\u0010DJ\r\u0010F\u001a\u00020\u0007¢\u0006\u0004\bF\u0010\u001aJ\r\u0010G\u001a\u00020\u0007¢\u0006\u0004\bG\u0010\u001aJ\u001d\u0010M\u001a\u00020\u00072\f\u0010J\u001a\b\u0012\u0004\u0012\u00020I0HH\u0010¢\u0006\u0004\bK\u0010LJ\u0017\u0010O\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u0014H\u0010¢\u0006\u0004\bN\u0010\u001dJ\u0017\u0010Q\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u0014H\u0010¢\u0006\u0004\bP\u0010\u001dJ\u0017\u0010U\u001a\u00020\u00072\u0006\u0010R\u001a\u000200H\u0010¢\u0006\u0004\bS\u0010TJ\u0017\u0010W\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u0014H\u0010¢\u0006\u0004\bV\u0010\u001dJ\u0019\u0010[\u001a\u0004\u0018\u00010X2\u0006\u0010R\u001a\u000200H\u0010¢\u0006\u0004\bY\u0010ZR$\u0010^\u001a\u00020\\2\u0006\u0010]\u001a\u00020\\8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b^\u0010_\u001a\u0004\b`\u0010aR\u0014\u0010c\u001a\u00020b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bc\u0010dR\u0014\u0010e\u001a\u00020&8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\be\u0010fR\u0018\u0010g\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bg\u0010hR\u0018\u0010j\u001a\u0004\u0018\u00010i8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bj\u0010kR\u001a\u0010m\u001a\b\u0012\u0004\u0012\u00020\u00140l8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bm\u0010nR\u001e\u0010o\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010/8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bo\u0010nR\u001c\u0010p\u001a\b\u0012\u0004\u0012\u00020&0+8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bp\u0010qR\u001a\u0010s\u001a\b\u0012\u0004\u0012\u00020\u00140r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bs\u0010tR\u001a\u0010u\u001a\b\u0012\u0004\u0012\u00020\u00140l8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bu\u0010nR\u001a\u0010v\u001a\b\u0012\u0004\u0012\u0002000l8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bv\u0010nR.\u0010y\u001a\u001c\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010&0x\u0012\n\u0012\b\u0012\u0004\u0012\u0002000l0w8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\by\u0010zR \u0010{\u001a\u000e\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020X0w8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b{\u0010zR\u001e\u0010|\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010l8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b|\u0010nR\u001e\u0010}\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010H8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b}\u0010~R\u001f\u0010\u007f\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u007f\u0010\u0080\u0001R\u001a\u0010\u0082\u0001\u001a\u00030\u0081\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0082\u0001\u0010\u0083\u0001R\u0019\u0010\u0084\u0001\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0084\u0001\u0010\u0085\u0001R\u001c\u0010\u0087\u0001\u001a\u0005\u0018\u00010\u0086\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0087\u0001\u0010\u0088\u0001R\u0019\u0010\u0089\u0001\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0089\u0001\u0010\u0085\u0001R\u001f\u0010\u008c\u0001\u001a\n\u0012\u0005\u0012\u00030\u008b\u00010\u008a\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u008c\u0001\u0010\u008d\u0001R\u0018\u0010\u008f\u0001\u001a\u00030\u008e\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u008f\u0001\u0010\u0090\u0001R\u001d\u0010\u0003\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\u000f\n\u0005\b\u0003\u0010\u0091\u0001\u001a\u0006\b\u0092\u0001\u0010\u0093\u0001R\u001c\u0010\u0095\u0001\u001a\u00070\u0094\u0001R\u00020\u00008\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0095\u0001\u0010\u0096\u0001R\u001d\u0010\u0099\u0001\u001a\b\u0012\u0004\u0012\u00020\u00140/8BX\u0082\u0004¢\u0006\b\u001a\u0006\b\u0097\u0001\u0010\u0098\u0001R\u0016\u0010\u009b\u0001\u001a\u00020\n8BX\u0082\u0004¢\u0006\u0007\u001a\u0005\b\u009a\u0001\u0010\fR\u0016\u0010\u009d\u0001\u001a\u00020\n8BX\u0082\u0004¢\u0006\u0007\u001a\u0005\b\u009c\u0001\u0010\fR\u0016\u0010\u009f\u0001\u001a\u00020\n8BX\u0082\u0004¢\u0006\u0007\u001a\u0005\b\u009e\u0001\u0010\fR\u0016\u0010¡\u0001\u001a\u00020\n8BX\u0082\u0004¢\u0006\u0007\u001a\u0005\b \u0001\u0010\fR\u0016\u0010£\u0001\u001a\u00020\n8BX\u0082\u0004¢\u0006\u0007\u001a\u0005\b¢\u0001\u0010\fR\u001c\u0010§\u0001\u001a\n\u0012\u0005\u0012\u00030\u008b\u00010¤\u00018F¢\u0006\b\u001a\u0006\b¥\u0001\u0010¦\u0001R\u0018\u0010ª\u0001\u001a\u00030\u0081\u00018PX\u0090\u0004¢\u0006\b\u001a\u0006\b¨\u0001\u0010©\u0001R\u0016\u0010¬\u0001\u001a\u00020\n8PX\u0090\u0004¢\u0006\u0007\u001a\u0005\b«\u0001\u0010\fR\u0016\u0010®\u0001\u001a\u00020\n8PX\u0090\u0004¢\u0006\u0007\u001a\u0005\b\u00ad\u0001\u0010\fR\u0016\u0010°\u0001\u001a\u00020\n8PX\u0090\u0004¢\u0006\u0007\u001a\u0005\b¯\u0001\u0010\f¨\u0006µ\u0001"}, d2 = {"Landroidx/compose/runtime/Recomposer;", "Landroidx/compose/runtime/CompositionContext;", "Lkotlin/coroutines/CoroutineContext;", "effectCoroutineContext", "<init>", "(Lkotlin/coroutines/CoroutineContext;)V", "Lkotlinx/coroutines/CancellableContinuation;", BuildConfig.FLAVOR, "deriveStateLocked", "()Lkotlinx/coroutines/CancellableContinuation;", BuildConfig.FLAVOR, "recordComposerModifications", "()Z", "Lkotlinx/coroutines/Job;", "callingJob", "registerRunnerJob", "(Lkotlinx/coroutines/Job;)V", "Ljava/lang/Exception;", "Lkotlin/Exception;", "e", "Landroidx/compose/runtime/ControlledComposition;", "failedInitialComposition", "recoverable", "processCompositionError", "(Ljava/lang/Exception;Landroidx/compose/runtime/ControlledComposition;Z)V", "clearKnownCompositionsLocked", "()V", "composition", "removeKnownCompositionLocked", "(Landroidx/compose/runtime/ControlledComposition;)V", "addKnownCompositionLocked", "recordFailedCompositionLocked", "awaitWorkAvailable", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlin/Function3;", "Lkotlinx/coroutines/CoroutineScope;", "Landroidx/compose/runtime/MonotonicFrameClock;", "Lkotlin/coroutines/Continuation;", BuildConfig.FLAVOR, "block", "recompositionRunner", "(Lkotlin/jvm/functions/Function3;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "performInitialMovableContentInserts", "Landroidx/collection/MutableScatterSet;", "modifiedValues", "performRecompose", "(Landroidx/compose/runtime/ControlledComposition;Landroidx/collection/MutableScatterSet;)Landroidx/compose/runtime/ControlledComposition;", BuildConfig.FLAVOR, "Landroidx/compose/runtime/MovableContentStateReference;", "references", "performInsertValues", "(Ljava/util/List;Landroidx/collection/MutableScatterSet;)Ljava/util/List;", "discardUnusedValues", "Lkotlin/Function1;", "readObserverOf", "(Landroidx/compose/runtime/ControlledComposition;)Lkotlin/jvm/functions/Function1;", "writeObserverOf", "(Landroidx/compose/runtime/ControlledComposition;Landroidx/collection/MutableScatterSet;)Lkotlin/jvm/functions/Function1;", "Landroidx/compose/runtime/snapshots/MutableSnapshot;", "snapshot", "applyAndCheck", "(Landroidx/compose/runtime/snapshots/MutableSnapshot;)V", "runRecomposeAndApplyChanges", "cancel", "join", "Lkotlin/Function0;", "content", "composeInitial$runtime_release", "(Landroidx/compose/runtime/ControlledComposition;Lkotlin/jvm/functions/Function2;)V", "composeInitial", "pauseCompositionFrameClock", "resumeCompositionFrameClock", BuildConfig.FLAVOR, "Landroidx/compose/runtime/tooling/CompositionData;", "table", "recordInspectionTable$runtime_release", "(Ljava/util/Set;)V", "recordInspectionTable", "unregisterComposition$runtime_release", "unregisterComposition", "invalidate$runtime_release", "invalidate", "reference", "insertMovableContent$runtime_release", "(Landroidx/compose/runtime/MovableContentStateReference;)V", "insertMovableContent", "reportRemovedComposition$runtime_release", "reportRemovedComposition", "Landroidx/compose/runtime/MovableContentState;", "movableContentStateResolve$runtime_release", "(Landroidx/compose/runtime/MovableContentStateReference;)Landroidx/compose/runtime/MovableContentState;", "movableContentStateResolve", BuildConfig.FLAVOR, "<set-?>", "changeCount", "J", "getChangeCount", "()J", "Landroidx/compose/runtime/BroadcastFrameClock;", "broadcastFrameClock", "Landroidx/compose/runtime/BroadcastFrameClock;", "stateLock", "Ljava/lang/Object;", "runnerJob", "Lkotlinx/coroutines/Job;", BuildConfig.FLAVOR, "closeCause", "Ljava/lang/Throwable;", BuildConfig.FLAVOR, "_knownCompositions", "Ljava/util/List;", "_knownCompositionsCache", "snapshotInvalidations", "Landroidx/collection/MutableScatterSet;", "Landroidx/compose/runtime/collection/MutableVector;", "compositionInvalidations", "Landroidx/compose/runtime/collection/MutableVector;", "compositionsAwaitingApply", "compositionValuesAwaitingInsert", BuildConfig.FLAVOR, "Landroidx/compose/runtime/MovableContent;", "compositionValuesRemoved", "Ljava/util/Map;", "compositionValueStatesAvailable", "failedCompositions", "compositionsRemoved", "Ljava/util/Set;", "workContinuation", "Lkotlinx/coroutines/CancellableContinuation;", BuildConfig.FLAVOR, "concurrentCompositionsOutstanding", "I", "isClosed", "Z", "Landroidx/compose/runtime/Recomposer$RecomposerErrorState;", "errorState", "Landroidx/compose/runtime/Recomposer$RecomposerErrorState;", "frameClockPaused", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Landroidx/compose/runtime/Recomposer$State;", "_state", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lkotlinx/coroutines/CompletableJob;", "effectJob", "Lkotlinx/coroutines/CompletableJob;", "Lkotlin/coroutines/CoroutineContext;", "getEffectCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "Landroidx/compose/runtime/Recomposer$RecomposerInfoImpl;", "recomposerInfo", "Landroidx/compose/runtime/Recomposer$RecomposerInfoImpl;", "getKnownCompositions", "()Ljava/util/List;", "knownCompositions", "getHasBroadcastFrameClockAwaitersLocked", "hasBroadcastFrameClockAwaitersLocked", "getHasBroadcastFrameClockAwaiters", "hasBroadcastFrameClockAwaiters", "getShouldKeepRecomposing", "shouldKeepRecomposing", "getHasSchedulingWork", "hasSchedulingWork", "getHasFrameWorkLocked", "hasFrameWorkLocked", "Lkotlinx/coroutines/flow/StateFlow;", "getCurrentState", "()Lkotlinx/coroutines/flow/StateFlow;", "currentState", "getCompoundHashKey$runtime_release", "()I", "compoundHashKey", "getCollectingCallByInformation$runtime_release", "collectingCallByInformation", "getCollectingParameterInformation$runtime_release", "collectingParameterInformation", "getCollectingSourceInformation$runtime_release", "collectingSourceInformation", "Companion", "RecomposerErrorState", "RecomposerInfoImpl", "State", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class Recomposer extends CompositionContext {
    private final List<ControlledComposition> _knownCompositions;
    private List<? extends ControlledComposition> _knownCompositionsCache;
    private final MutableStateFlow<State> _state;
    private final BroadcastFrameClock broadcastFrameClock;
    private long changeCount;
    private Throwable closeCause;
    private final MutableVector<ControlledComposition> compositionInvalidations;
    private final Map<MovableContentStateReference, MovableContentState> compositionValueStatesAvailable;
    private final List<MovableContentStateReference> compositionValuesAwaitingInsert;
    private final Map<MovableContent<Object>, List<MovableContentStateReference>> compositionValuesRemoved;
    private final List<ControlledComposition> compositionsAwaitingApply;
    private Set<ControlledComposition> compositionsRemoved;
    private int concurrentCompositionsOutstanding;
    private final CoroutineContext effectCoroutineContext;
    private final CompletableJob effectJob;
    private RecomposerErrorState errorState;
    private List<ControlledComposition> failedCompositions;
    private boolean frameClockPaused;
    private boolean isClosed;
    private final RecomposerInfoImpl recomposerInfo;
    private Job runnerJob;
    private MutableScatterSet<Object> snapshotInvalidations;
    private final Object stateLock;
    private CancellableContinuation<? super Unit> workContinuation;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;
    private static final MutableStateFlow<PersistentSet<RecomposerInfoImpl>> _runningRecomposers = StateFlowKt.MutableStateFlow(ExtensionsKt.persistentSetOf());
    private static final AtomicReference<Boolean> _hotReloadEnabled = new AtomicReference<>(Boolean.FALSE);

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001b\u0010\b\u001a\u00020\u00072\n\u0010\u0006\u001a\u00060\u0004R\u00020\u0005H\u0002¢\u0006\u0004\b\b\u0010\tJ\u001b\u0010\n\u001a\u00020\u00072\n\u0010\u0006\u001a\u00060\u0004R\u00020\u0005H\u0002¢\u0006\u0004\b\n\u0010\tR4\u0010\u000f\u001a\"\u0012\f\u0012\n \r*\u0004\u0018\u00010\f0\f0\u000bj\u0010\u0012\f\u0012\n \r*\u0004\u0018\u00010\f0\f`\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R$\u0010\u0013\u001a\u0012\u0012\u000e\u0012\f\u0012\b\u0012\u00060\u0004R\u00020\u00050\u00120\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Landroidx/compose/runtime/Recomposer$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "Landroidx/compose/runtime/Recomposer$RecomposerInfoImpl;", "Landroidx/compose/runtime/Recomposer;", "info", BuildConfig.FLAVOR, "addRunning", "(Landroidx/compose/runtime/Recomposer$RecomposerInfoImpl;)V", "removeRunning", "Ljava/util/concurrent/atomic/AtomicReference;", BuildConfig.FLAVOR, "kotlin.jvm.PlatformType", "Landroidx/compose/runtime/AtomicReference;", "_hotReloadEnabled", "Ljava/util/concurrent/atomic/AtomicReference;", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentSet;", "_runningRecomposers", "Lkotlinx/coroutines/flow/MutableStateFlow;", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void addRunning(RecomposerInfoImpl info) {
            PersistentSet persistentSet;
            PersistentSet add;
            do {
                persistentSet = (PersistentSet) Recomposer._runningRecomposers.getValue();
                add = persistentSet.add((PersistentSet) info);
                if (persistentSet == add) {
                    return;
                }
            } while (!Recomposer._runningRecomposers.compareAndSet(persistentSet, add));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void removeRunning(RecomposerInfoImpl info) {
            PersistentSet persistentSet;
            PersistentSet remove;
            do {
                persistentSet = (PersistentSet) Recomposer._runningRecomposers.getValue();
                remove = persistentSet.remove((PersistentSet) info);
                if (persistentSet == remove) {
                    return;
                }
            } while (!Recomposer._runningRecomposers.compareAndSet(persistentSet, remove));
        }

        private Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0002\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\u0010\u0006\u001a\u00060\u0004j\u0002`\u0005¢\u0006\u0004\b\u0007\u0010\bR\u001a\u0010\u0003\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001e\u0010\u0006\u001a\u00060\u0004j\u0002`\u00058\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0006\u0010\f\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Landroidx/compose/runtime/Recomposer$RecomposerErrorState;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "recoverable", "Ljava/lang/Exception;", "Lkotlin/Exception;", "cause", "<init>", "(ZLjava/lang/Exception;)V", "Z", "getRecoverable", "()Z", "Ljava/lang/Exception;", "getCause", "()Ljava/lang/Exception;", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class RecomposerErrorState {
        private final Exception cause;
        private final boolean recoverable;

        public RecomposerErrorState(boolean z5, Exception exc) {
            this.recoverable = z5;
            this.cause = exc;
        }

        public Exception getCause() {
            return this.cause;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Landroidx/compose/runtime/Recomposer$RecomposerInfoImpl;", BuildConfig.FLAVOR, "<init>", "(Landroidx/compose/runtime/Recomposer;)V", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public final class RecomposerInfoImpl {
        public RecomposerInfoImpl() {
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Landroidx/compose/runtime/Recomposer$State;", BuildConfig.FLAVOR, "(Ljava/lang/String;I)V", "ShutDown", "ShuttingDown", "Inactive", "InactivePendingWork", "Idle", "PendingWork", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public enum State {
        ShutDown,
        ShuttingDown,
        Inactive,
        InactivePendingWork,
        Idle,
        PendingWork
    }

    public Recomposer(CoroutineContext coroutineContext) {
        BroadcastFrameClock broadcastFrameClock = new BroadcastFrameClock(new Function0<Unit>() { // from class: androidx.compose.runtime.Recomposer$broadcastFrameClock$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                CancellableContinuation deriveStateLocked;
                MutableStateFlow mutableStateFlow;
                Throwable th;
                Object obj = Recomposer.this.stateLock;
                Recomposer recomposer = Recomposer.this;
                synchronized (obj) {
                    deriveStateLocked = recomposer.deriveStateLocked();
                    mutableStateFlow = recomposer._state;
                    if (((Recomposer.State) mutableStateFlow.getValue()).compareTo(Recomposer.State.ShuttingDown) <= 0) {
                        th = recomposer.closeCause;
                        throw ExceptionsKt.CancellationException("Recomposer shutdown; frame clock awaiter will never resume", th);
                    }
                }
                if (deriveStateLocked != null) {
                    Result.Companion companion = Result.INSTANCE;
                    deriveStateLocked.resumeWith(Result.m3567constructorimpl(Unit.INSTANCE));
                }
            }
        });
        this.broadcastFrameClock = broadcastFrameClock;
        this.stateLock = new Object();
        this._knownCompositions = new ArrayList();
        this.snapshotInvalidations = new MutableScatterSet<>(0, 1, null);
        this.compositionInvalidations = new MutableVector<>(new ControlledComposition[16], 0);
        this.compositionsAwaitingApply = new ArrayList();
        this.compositionValuesAwaitingInsert = new ArrayList();
        this.compositionValuesRemoved = new LinkedHashMap();
        this.compositionValueStatesAvailable = new LinkedHashMap();
        this._state = StateFlowKt.MutableStateFlow(State.Inactive);
        CompletableJob Job = JobKt.Job((Job) coroutineContext.get(Job.INSTANCE));
        Job.invokeOnCompletion(new Function1<Throwable, Unit>() { // from class: androidx.compose.runtime.Recomposer$effectJob$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                invoke2(th);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(final Throwable th) {
                Job job;
                CancellableContinuation cancellableContinuation;
                MutableStateFlow mutableStateFlow;
                MutableStateFlow mutableStateFlow2;
                boolean z5;
                CancellableContinuation cancellableContinuation2;
                CancellableContinuation cancellableContinuation3;
                CancellationException CancellationException = ExceptionsKt.CancellationException("Recomposer effect job completed", th);
                Object obj = Recomposer.this.stateLock;
                final Recomposer recomposer = Recomposer.this;
                synchronized (obj) {
                    try {
                        job = recomposer.runnerJob;
                        cancellableContinuation = null;
                        if (job != null) {
                            mutableStateFlow2 = recomposer._state;
                            mutableStateFlow2.setValue(Recomposer.State.ShuttingDown);
                            z5 = recomposer.isClosed;
                            if (!z5) {
                                job.cancel(CancellationException);
                            } else {
                                cancellableContinuation2 = recomposer.workContinuation;
                                if (cancellableContinuation2 != null) {
                                    cancellableContinuation3 = recomposer.workContinuation;
                                    recomposer.workContinuation = null;
                                    job.invokeOnCompletion(new Function1<Throwable, Unit>() { // from class: androidx.compose.runtime.Recomposer$effectJob$1$1$1$1
                                        /* JADX INFO: Access modifiers changed from: package-private */
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public /* bridge */ /* synthetic */ Unit invoke(Throwable th2) {
                                            invoke2(th2);
                                            return Unit.INSTANCE;
                                        }

                                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                        public final void invoke2(Throwable th2) {
                                            MutableStateFlow mutableStateFlow3;
                                            Object obj2 = Recomposer.this.stateLock;
                                            Recomposer recomposer2 = Recomposer.this;
                                            Throwable th3 = th;
                                            synchronized (obj2) {
                                                if (th3 == null) {
                                                    th3 = null;
                                                } else if (th2 != null) {
                                                    try {
                                                        if (th2 instanceof CancellationException) {
                                                            th2 = null;
                                                        }
                                                        if (th2 != null) {
                                                            kotlin.ExceptionsKt.addSuppressed(th3, th2);
                                                        }
                                                    } catch (Throwable th4) {
                                                        throw th4;
                                                    }
                                                }
                                                recomposer2.closeCause = th3;
                                                mutableStateFlow3 = recomposer2._state;
                                                mutableStateFlow3.setValue(Recomposer.State.ShutDown);
                                                Unit unit = Unit.INSTANCE;
                                            }
                                        }
                                    });
                                    cancellableContinuation = cancellableContinuation3;
                                }
                            }
                            cancellableContinuation3 = null;
                            recomposer.workContinuation = null;
                            job.invokeOnCompletion(new Function1<Throwable, Unit>() { // from class: androidx.compose.runtime.Recomposer$effectJob$1$1$1$1
                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(Throwable th2) {
                                    invoke2(th2);
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(Throwable th2) {
                                    MutableStateFlow mutableStateFlow3;
                                    Object obj2 = Recomposer.this.stateLock;
                                    Recomposer recomposer2 = Recomposer.this;
                                    Throwable th3 = th;
                                    synchronized (obj2) {
                                        if (th3 == null) {
                                            th3 = null;
                                        } else if (th2 != null) {
                                            try {
                                                if (th2 instanceof CancellationException) {
                                                    th2 = null;
                                                }
                                                if (th2 != null) {
                                                    kotlin.ExceptionsKt.addSuppressed(th3, th2);
                                                }
                                            } catch (Throwable th4) {
                                                throw th4;
                                            }
                                        }
                                        recomposer2.closeCause = th3;
                                        mutableStateFlow3 = recomposer2._state;
                                        mutableStateFlow3.setValue(Recomposer.State.ShutDown);
                                        Unit unit = Unit.INSTANCE;
                                    }
                                }
                            });
                            cancellableContinuation = cancellableContinuation3;
                        } else {
                            recomposer.closeCause = CancellationException;
                            mutableStateFlow = recomposer._state;
                            mutableStateFlow.setValue(Recomposer.State.ShutDown);
                            Unit unit = Unit.INSTANCE;
                        }
                    } catch (Throwable th2) {
                        throw th2;
                    }
                }
                if (cancellableContinuation != null) {
                    Result.Companion companion = Result.INSTANCE;
                    cancellableContinuation.resumeWith(Result.m3567constructorimpl(Unit.INSTANCE));
                }
            }
        });
        this.effectJob = Job;
        this.effectCoroutineContext = coroutineContext.plus(broadcastFrameClock).plus(Job);
        this.recomposerInfo = new RecomposerInfoImpl();
    }

    private final void addKnownCompositionLocked(ControlledComposition composition) {
        this._knownCompositions.add(composition);
        this._knownCompositionsCache = null;
    }

    private final void applyAndCheck(MutableSnapshot snapshot) {
        try {
            if (snapshot.apply() instanceof SnapshotApplyResult.Failure) {
                throw new IllegalStateException("Unsupported concurrent change during composition. A state object was modified by composition as well as being modified outside composition.");
            }
        } finally {
            snapshot.dispose();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object awaitWorkAvailable(Continuation<? super Unit> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl;
        if (getHasSchedulingWork()) {
            return Unit.INSTANCE;
        }
        CancellableContinuationImpl cancellableContinuationImpl2 = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl2.initCancellability();
        synchronized (this.stateLock) {
            if (getHasSchedulingWork()) {
                cancellableContinuationImpl = cancellableContinuationImpl2;
            } else {
                this.workContinuation = cancellableContinuationImpl2;
                cancellableContinuationImpl = null;
            }
        }
        if (cancellableContinuationImpl != null) {
            Result.Companion companion = Result.INSTANCE;
            cancellableContinuationImpl.resumeWith(Result.m3567constructorimpl(Unit.INSTANCE));
        }
        Object result = cancellableContinuationImpl2.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? result : Unit.INSTANCE;
    }

    private final void clearKnownCompositionsLocked() {
        this._knownCompositions.clear();
        this._knownCompositionsCache = CollectionsKt.emptyList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CancellableContinuation<Unit> deriveStateLocked() {
        State state;
        if (this._state.getValue().compareTo(State.ShuttingDown) <= 0) {
            clearKnownCompositionsLocked();
            this.snapshotInvalidations = new MutableScatterSet<>(0, 1, null);
            this.compositionInvalidations.clear();
            this.compositionsAwaitingApply.clear();
            this.compositionValuesAwaitingInsert.clear();
            this.failedCompositions = null;
            CancellableContinuation<? super Unit> cancellableContinuation = this.workContinuation;
            if (cancellableContinuation != null) {
                CancellableContinuation.DefaultImpls.cancel$default(cancellableContinuation, null, 1, null);
            }
            this.workContinuation = null;
            this.errorState = null;
            return null;
        }
        if (this.errorState != null) {
            state = State.Inactive;
        } else if (this.runnerJob == null) {
            this.snapshotInvalidations = new MutableScatterSet<>(0, 1, null);
            this.compositionInvalidations.clear();
            state = getHasBroadcastFrameClockAwaitersLocked() ? State.InactivePendingWork : State.Inactive;
        } else {
            state = (this.compositionInvalidations.isNotEmpty() || this.snapshotInvalidations.isNotEmpty() || !this.compositionsAwaitingApply.isEmpty() || !this.compositionValuesAwaitingInsert.isEmpty() || this.concurrentCompositionsOutstanding > 0 || getHasBroadcastFrameClockAwaitersLocked()) ? State.PendingWork : State.Idle;
        }
        this._state.setValue(state);
        if (state != State.PendingWork) {
            return null;
        }
        CancellableContinuation cancellableContinuation2 = this.workContinuation;
        this.workContinuation = null;
        return cancellableContinuation2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void discardUnusedValues() {
        int i5;
        List emptyList;
        synchronized (this.stateLock) {
            try {
                if (this.compositionValuesRemoved.isEmpty()) {
                    emptyList = CollectionsKt.emptyList();
                } else {
                    List flatten = CollectionsKt.flatten(this.compositionValuesRemoved.values());
                    this.compositionValuesRemoved.clear();
                    emptyList = new ArrayList(flatten.size());
                    int size = flatten.size();
                    for (int i6 = 0; i6 < size; i6++) {
                        MovableContentStateReference movableContentStateReference = (MovableContentStateReference) flatten.get(i6);
                        emptyList.add(TuplesKt.to(movableContentStateReference, this.compositionValueStatesAvailable.get(movableContentStateReference)));
                    }
                    this.compositionValueStatesAvailable.clear();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        int size2 = emptyList.size();
        for (i5 = 0; i5 < size2; i5++) {
            Pair pair = (Pair) emptyList.get(i5);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean getHasBroadcastFrameClockAwaiters() {
        boolean hasBroadcastFrameClockAwaitersLocked;
        synchronized (this.stateLock) {
            hasBroadcastFrameClockAwaitersLocked = getHasBroadcastFrameClockAwaitersLocked();
        }
        return hasBroadcastFrameClockAwaitersLocked;
    }

    private final boolean getHasBroadcastFrameClockAwaitersLocked() {
        return !this.frameClockPaused && this.broadcastFrameClock.getHasAwaiters();
    }

    private final boolean getHasFrameWorkLocked() {
        return this.compositionInvalidations.isNotEmpty() || getHasBroadcastFrameClockAwaitersLocked();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean getHasSchedulingWork() {
        boolean z5;
        synchronized (this.stateLock) {
            if (!this.snapshotInvalidations.isNotEmpty() && !this.compositionInvalidations.isNotEmpty()) {
                z5 = getHasBroadcastFrameClockAwaitersLocked();
            }
        }
        return z5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final List<ControlledComposition> getKnownCompositions() {
        List list = this._knownCompositionsCache;
        List list2 = list;
        if (list == null) {
            List<ControlledComposition> list3 = this._knownCompositions;
            List emptyList = list3.isEmpty() ? CollectionsKt.emptyList() : new ArrayList(list3);
            this._knownCompositionsCache = emptyList;
            list2 = emptyList;
        }
        return list2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean getShouldKeepRecomposing() {
        boolean z5;
        synchronized (this.stateLock) {
            z5 = this.isClosed;
        }
        if (z5) {
            Iterator<Job> it = this.effectJob.getChildren().iterator();
            while (it.hasNext()) {
                if (it.next().isActive()) {
                }
            }
            return false;
        }
        return true;
    }

    private final void performInitialMovableContentInserts(ControlledComposition composition) {
        synchronized (this.stateLock) {
            List<MovableContentStateReference> list = this.compositionValuesAwaitingInsert;
            int size = list.size();
            for (int i5 = 0; i5 < size; i5++) {
                if (Intrinsics.areEqual(list.get(i5).getComposition(), composition)) {
                    Unit unit = Unit.INSTANCE;
                    ArrayList arrayList = new ArrayList();
                    performInitialMovableContentInserts$fillToInsert(arrayList, this, composition);
                    while (!arrayList.isEmpty()) {
                        performInsertValues(arrayList, null);
                        performInitialMovableContentInserts$fillToInsert(arrayList, this, composition);
                    }
                    return;
                }
            }
        }
    }

    private static final void performInitialMovableContentInserts$fillToInsert(List<MovableContentStateReference> list, Recomposer recomposer, ControlledComposition controlledComposition) {
        list.clear();
        synchronized (recomposer.stateLock) {
            try {
                Iterator<MovableContentStateReference> it = recomposer.compositionValuesAwaitingInsert.iterator();
                while (it.hasNext()) {
                    MovableContentStateReference next = it.next();
                    if (Intrinsics.areEqual(next.getComposition(), controlledComposition)) {
                        list.add(next);
                        it.remove();
                    }
                }
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00b4, code lost:
    
        r1 = r7.size();
        r6 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00b9, code lost:
    
        if (r6 >= r1) goto L85;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00c5, code lost:
    
        if (r7.get(r6).getSecond() == null) goto L84;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00c7, code lost:
    
        r6 = r6 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00ca, code lost:
    
        r1 = new java.util.ArrayList(r7.size());
        r6 = r7.size();
        r8 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00d8, code lost:
    
        if (r8 >= r6) goto L86;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00da, code lost:
    
        r9 = r7.get(r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00e4, code lost:
    
        if (r9.getSecond() != null) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00e6, code lost:
    
        r9 = r9.getFirst();
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00f0, code lost:
    
        if (r9 == null) goto L88;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00f2, code lost:
    
        r1.add(r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00f5, code lost:
    
        r8 = r8 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00ef, code lost:
    
        r9 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00f8, code lost:
    
        r6 = r13.stateLock;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00fa, code lost:
    
        monitor-enter(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00fb, code lost:
    
        kotlin.collections.CollectionsKt.addAll(r13.compositionValuesAwaitingInsert, r1);
        r1 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0104, code lost:
    
        monitor-exit(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0105, code lost:
    
        r1 = new java.util.ArrayList(r7.size());
        r6 = r7.size();
        r8 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0113, code lost:
    
        if (r8 >= r6) goto L89;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0115, code lost:
    
        r9 = r7.get(r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0120, code lost:
    
        if (r9.getSecond() == null) goto L91;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0122, code lost:
    
        r1.add(r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x0125, code lost:
    
        r8 = r8 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0128, code lost:
    
        r7 = r1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final List<ControlledComposition> performInsertValues(List<MovableContentStateReference> references, MutableScatterSet<Object> modifiedValues) {
        ArrayList arrayList;
        HashMap hashMap = new HashMap(references.size());
        int size = references.size();
        for (int i5 = 0; i5 < size; i5++) {
            MovableContentStateReference movableContentStateReference = references.get(i5);
            ControlledComposition composition = movableContentStateReference.getComposition();
            Object obj = hashMap.get(composition);
            if (obj == null) {
                obj = new ArrayList();
                hashMap.put(composition, obj);
            }
            ((ArrayList) obj).add(movableContentStateReference);
        }
        for (Map.Entry entry : hashMap.entrySet()) {
            ControlledComposition controlledComposition = (ControlledComposition) entry.getKey();
            List list = (List) entry.getValue();
            ComposerKt.runtimeCheck(!controlledComposition.isComposing());
            MutableSnapshot takeMutableSnapshot = Snapshot.INSTANCE.takeMutableSnapshot(readObserverOf(controlledComposition), writeObserverOf(controlledComposition, modifiedValues));
            try {
                Snapshot makeCurrent = takeMutableSnapshot.makeCurrent();
                try {
                    synchronized (this.stateLock) {
                        arrayList = new ArrayList(list.size());
                        int size2 = list.size();
                        for (int i6 = 0; i6 < size2; i6++) {
                            MovableContentStateReference movableContentStateReference2 = (MovableContentStateReference) list.get(i6);
                            Map<MovableContent<Object>, List<MovableContentStateReference>> map = this.compositionValuesRemoved;
                            movableContentStateReference2.getContent$runtime_release();
                            arrayList.add(TuplesKt.to(movableContentStateReference2, RecomposerKt.removeLastMultiValue(map, null)));
                        }
                    }
                    int size3 = arrayList.size();
                    int i7 = 0;
                    while (true) {
                        if (i7 >= size3) {
                            break;
                        }
                        if (arrayList.get(i7).getSecond() != null) {
                            break;
                        }
                        i7++;
                    }
                    controlledComposition.insertMovableContent(arrayList);
                    Unit unit = Unit.INSTANCE;
                    takeMutableSnapshot.restoreCurrent(makeCurrent);
                } catch (Throwable th) {
                    takeMutableSnapshot.restoreCurrent(makeCurrent);
                    throw th;
                }
            } finally {
                applyAndCheck(takeMutableSnapshot);
            }
        }
        return CollectionsKt.toList(hashMap.keySet());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ControlledComposition performRecompose(final ControlledComposition composition, final MutableScatterSet<Object> modifiedValues) {
        Set<ControlledComposition> set;
        if (composition.isComposing() || composition.getDisposed() || ((set = this.compositionsRemoved) != null && set.contains(composition))) {
            return null;
        }
        MutableSnapshot takeMutableSnapshot = Snapshot.INSTANCE.takeMutableSnapshot(readObserverOf(composition), writeObserverOf(composition, modifiedValues));
        try {
            Snapshot makeCurrent = takeMutableSnapshot.makeCurrent();
            if (modifiedValues != null) {
                try {
                    if (modifiedValues.isNotEmpty()) {
                        composition.prepareCompose(new Function0<Unit>() { // from class: androidx.compose.runtime.Recomposer$performRecompose$1$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public /* bridge */ /* synthetic */ Unit invoke() {
                                invoke2();
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2() {
                                MutableScatterSet<Object> mutableScatterSet = modifiedValues;
                                ControlledComposition controlledComposition = composition;
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
                                                controlledComposition.recordWriteOf(objArr[(i5 << 3) + i7]);
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
                        });
                    }
                } catch (Throwable th) {
                    takeMutableSnapshot.restoreCurrent(makeCurrent);
                    throw th;
                }
            }
            boolean recompose = composition.recompose();
            takeMutableSnapshot.restoreCurrent(makeCurrent);
            if (recompose) {
                return composition;
            }
            return null;
        } finally {
            applyAndCheck(takeMutableSnapshot);
        }
    }

    private final void processCompositionError(Exception e5, ControlledComposition failedInitialComposition, boolean recoverable) {
        if (!_hotReloadEnabled.get().booleanValue() || (e5 instanceof ComposeRuntimeError)) {
            synchronized (this.stateLock) {
                RecomposerErrorState recomposerErrorState = this.errorState;
                if (recomposerErrorState != null) {
                    throw recomposerErrorState.getCause();
                }
                this.errorState = new RecomposerErrorState(false, e5);
                Unit unit = Unit.INSTANCE;
            }
            throw e5;
        }
        synchronized (this.stateLock) {
            try {
                ActualAndroid_androidKt.logError("Error was captured in composition while live edit was enabled.", e5);
                this.compositionsAwaitingApply.clear();
                this.compositionInvalidations.clear();
                this.snapshotInvalidations = new MutableScatterSet<>(0, 1, null);
                this.compositionValuesAwaitingInsert.clear();
                this.compositionValuesRemoved.clear();
                this.compositionValueStatesAvailable.clear();
                this.errorState = new RecomposerErrorState(recoverable, e5);
                if (failedInitialComposition != null) {
                    recordFailedCompositionLocked(failedInitialComposition);
                }
                deriveStateLocked();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void processCompositionError$default(Recomposer recomposer, Exception exc, ControlledComposition controlledComposition, boolean z5, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            controlledComposition = null;
        }
        if ((i5 & 4) != 0) {
            z5 = false;
        }
        recomposer.processCompositionError(exc, controlledComposition, z5);
    }

    private final Function1<Object, Unit> readObserverOf(final ControlledComposition composition) {
        return new Function1<Object, Unit>() { // from class: androidx.compose.runtime.Recomposer$readObserverOf$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
                invoke2(obj);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Object obj) {
                ControlledComposition.this.recordReadOf(obj);
            }
        };
    }

    private final Object recompositionRunner(Function3<? super CoroutineScope, ? super MonotonicFrameClock, ? super Continuation<? super Unit>, ? extends Object> function3, Continuation<? super Unit> continuation) {
        Object withContext = BuildersKt.withContext(this.broadcastFrameClock, new Recomposer$recompositionRunner$2(this, function3, MonotonicFrameClockKt.getMonotonicFrameClock(continuation.getContext()), null), continuation);
        return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean recordComposerModifications() {
        List<ControlledComposition> knownCompositions;
        boolean hasFrameWorkLocked;
        synchronized (this.stateLock) {
            if (this.snapshotInvalidations.isEmpty()) {
                return getHasFrameWorkLocked();
            }
            Set<? extends Object> wrapIntoSet = ScatterSetWrapperKt.wrapIntoSet(this.snapshotInvalidations);
            this.snapshotInvalidations = new MutableScatterSet<>(0, 1, null);
            synchronized (this.stateLock) {
                knownCompositions = getKnownCompositions();
            }
            try {
                int size = knownCompositions.size();
                for (int i5 = 0; i5 < size; i5++) {
                    knownCompositions.get(i5).recordModificationsOf(wrapIntoSet);
                    if (this._state.getValue().compareTo(State.ShuttingDown) <= 0) {
                        break;
                    }
                }
                synchronized (this.stateLock) {
                    this.snapshotInvalidations = new MutableScatterSet<>(0, 1, null);
                    Unit unit = Unit.INSTANCE;
                }
                synchronized (this.stateLock) {
                    if (deriveStateLocked() != null) {
                        throw new IllegalStateException("called outside of runRecomposeAndApplyChanges");
                    }
                    hasFrameWorkLocked = getHasFrameWorkLocked();
                }
                return hasFrameWorkLocked;
            } catch (Throwable th) {
                synchronized (this.stateLock) {
                    this.snapshotInvalidations.addAll(wrapIntoSet);
                    throw th;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void recordFailedCompositionLocked(ControlledComposition composition) {
        List list = this.failedCompositions;
        if (list == null) {
            list = new ArrayList();
            this.failedCompositions = list;
        }
        if (!list.contains(composition)) {
            list.add(composition);
        }
        removeKnownCompositionLocked(composition);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void registerRunnerJob(Job callingJob) {
        synchronized (this.stateLock) {
            Throwable th = this.closeCause;
            if (th != null) {
                throw th;
            }
            if (this._state.getValue().compareTo(State.ShuttingDown) <= 0) {
                throw new IllegalStateException("Recomposer shut down");
            }
            if (this.runnerJob != null) {
                throw new IllegalStateException("Recomposer already running");
            }
            this.runnerJob = callingJob;
            deriveStateLocked();
        }
    }

    private final void removeKnownCompositionLocked(ControlledComposition composition) {
        this._knownCompositions.remove(composition);
        this._knownCompositionsCache = null;
    }

    private final Function1<Object, Unit> writeObserverOf(final ControlledComposition composition, final MutableScatterSet<Object> modifiedValues) {
        return new Function1<Object, Unit>() { // from class: androidx.compose.runtime.Recomposer$writeObserverOf$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
                invoke2(obj);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Object obj) {
                ControlledComposition.this.recordWriteOf(obj);
                MutableScatterSet<Object> mutableScatterSet = modifiedValues;
                if (mutableScatterSet != null) {
                    mutableScatterSet.add(obj);
                }
            }
        };
    }

    public final void cancel() {
        synchronized (this.stateLock) {
            try {
                if (this._state.getValue().compareTo(State.Idle) >= 0) {
                    this._state.setValue(State.ShuttingDown);
                }
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                throw th;
            }
        }
        Job.DefaultImpls.cancel$default(this.effectJob, null, 1, null);
    }

    @Override // androidx.compose.runtime.CompositionContext
    public void composeInitial$runtime_release(ControlledComposition composition, Function2<? super Composer, ? super Integer, Unit> content) {
        boolean isComposing = composition.isComposing();
        try {
            Snapshot.Companion companion = Snapshot.INSTANCE;
            MutableSnapshot takeMutableSnapshot = companion.takeMutableSnapshot(readObserverOf(composition), writeObserverOf(composition, null));
            try {
                Snapshot makeCurrent = takeMutableSnapshot.makeCurrent();
                try {
                    composition.composeContent(content);
                    Unit unit = Unit.INSTANCE;
                    if (!isComposing) {
                        companion.notifyObjectsInitialized();
                    }
                    synchronized (this.stateLock) {
                        if (this._state.getValue().compareTo(State.ShuttingDown) > 0 && !getKnownCompositions().contains(composition)) {
                            addKnownCompositionLocked(composition);
                        }
                    }
                    try {
                        performInitialMovableContentInserts(composition);
                        try {
                            composition.applyChanges();
                            composition.applyLateChanges();
                            if (isComposing) {
                                return;
                            }
                            companion.notifyObjectsInitialized();
                        } catch (Exception e5) {
                            processCompositionError$default(this, e5, null, false, 6, null);
                        }
                    } catch (Exception e6) {
                        processCompositionError(e6, composition, true);
                    }
                } finally {
                    takeMutableSnapshot.restoreCurrent(makeCurrent);
                }
            } finally {
                applyAndCheck(takeMutableSnapshot);
            }
        } catch (Exception e7) {
            processCompositionError(e7, composition, true);
        }
    }

    public final long getChangeCount() {
        return this.changeCount;
    }

    @Override // androidx.compose.runtime.CompositionContext
    public boolean getCollectingCallByInformation$runtime_release() {
        return _hotReloadEnabled.get().booleanValue();
    }

    @Override // androidx.compose.runtime.CompositionContext
    public boolean getCollectingParameterInformation$runtime_release() {
        return false;
    }

    @Override // androidx.compose.runtime.CompositionContext
    public boolean getCollectingSourceInformation$runtime_release() {
        return false;
    }

    @Override // androidx.compose.runtime.CompositionContext
    public int getCompoundHashKey$runtime_release() {
        return Constants.ONE_SECOND;
    }

    public final StateFlow<State> getCurrentState() {
        return this._state;
    }

    @Override // androidx.compose.runtime.CompositionContext
    public CoroutineContext getEffectCoroutineContext() {
        return this.effectCoroutineContext;
    }

    @Override // androidx.compose.runtime.CompositionContext
    public void insertMovableContent$runtime_release(MovableContentStateReference reference) {
        CancellableContinuation<Unit> deriveStateLocked;
        synchronized (this.stateLock) {
            this.compositionValuesAwaitingInsert.add(reference);
            deriveStateLocked = deriveStateLocked();
        }
        if (deriveStateLocked != null) {
            Result.Companion companion = Result.INSTANCE;
            deriveStateLocked.resumeWith(Result.m3567constructorimpl(Unit.INSTANCE));
        }
    }

    @Override // androidx.compose.runtime.CompositionContext
    public void invalidate$runtime_release(ControlledComposition composition) {
        CancellableContinuation<Unit> cancellableContinuation;
        synchronized (this.stateLock) {
            if (this.compositionInvalidations.contains(composition)) {
                cancellableContinuation = null;
            } else {
                this.compositionInvalidations.add(composition);
                cancellableContinuation = deriveStateLocked();
            }
        }
        if (cancellableContinuation != null) {
            Result.Companion companion = Result.INSTANCE;
            cancellableContinuation.resumeWith(Result.m3567constructorimpl(Unit.INSTANCE));
        }
    }

    public final Object join(Continuation<? super Unit> continuation) {
        Object first = FlowKt.first(getCurrentState(), new Recomposer$join$2(null), continuation);
        return first == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? first : Unit.INSTANCE;
    }

    @Override // androidx.compose.runtime.CompositionContext
    public MovableContentState movableContentStateResolve$runtime_release(MovableContentStateReference reference) {
        MovableContentState remove;
        synchronized (this.stateLock) {
            remove = this.compositionValueStatesAvailable.remove(reference);
        }
        return remove;
    }

    public final void pauseCompositionFrameClock() {
        synchronized (this.stateLock) {
            this.frameClockPaused = true;
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // androidx.compose.runtime.CompositionContext
    public void recordInspectionTable$runtime_release(Set<CompositionData> table) {
    }

    @Override // androidx.compose.runtime.CompositionContext
    public void reportRemovedComposition$runtime_release(ControlledComposition composition) {
        synchronized (this.stateLock) {
            try {
                Set set = this.compositionsRemoved;
                if (set == null) {
                    set = new LinkedHashSet();
                    this.compositionsRemoved = set;
                }
                set.add(composition);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void resumeCompositionFrameClock() {
        CancellableContinuation<Unit> cancellableContinuation;
        synchronized (this.stateLock) {
            if (this.frameClockPaused) {
                this.frameClockPaused = false;
                cancellableContinuation = deriveStateLocked();
            } else {
                cancellableContinuation = null;
            }
        }
        if (cancellableContinuation != null) {
            Result.Companion companion = Result.INSTANCE;
            cancellableContinuation.resumeWith(Result.m3567constructorimpl(Unit.INSTANCE));
        }
    }

    public final Object runRecomposeAndApplyChanges(Continuation<? super Unit> continuation) {
        Object recompositionRunner = recompositionRunner(new Recomposer$runRecomposeAndApplyChanges$2(this, null), continuation);
        return recompositionRunner == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? recompositionRunner : Unit.INSTANCE;
    }

    @Override // androidx.compose.runtime.CompositionContext
    public void unregisterComposition$runtime_release(ControlledComposition composition) {
        synchronized (this.stateLock) {
            removeKnownCompositionLocked(composition);
            this.compositionInvalidations.remove(composition);
            this.compositionsAwaitingApply.remove(composition);
            Unit unit = Unit.INSTANCE;
        }
    }
}
