package androidx.compose.runtime.snapshots;

import androidx.collection.MutableScatterSet;
import androidx.compose.runtime.AtomicInt;
import androidx.compose.runtime.SnapshotThreadLocal;
import androidx.compose.runtime.WeakReference;
import androidx.compose.runtime.collection.ScatterSetWrapperKt;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.runtime.snapshots.SnapshotIdSet;
import com.sdk.growthbook.utils.Constants;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u009a\u0001\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001f\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\b\u0010\t\u001a\u000f\u0010\u000b\u001a\u00020\nH\u0000¢\u0006\u0004\b\u000b\u0010\f\u001a;\u0010\u0013\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\n2\u0016\b\u0002\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000e2\b\b\u0002\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0013\u0010\u0014\u001aS\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000e2\u0014\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000e2\u0014\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000e2\b\b\u0002\u0010\u0016\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0017\u0010\u0018\u001aI\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000e2\u0014\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000e2\u0014\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000eH\u0002¢\u0006\u0004\b\u001a\u0010\u001b\u001a1\u0010\u001f\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u001c2\u0006\u0010\u001d\u001a\u00020\n2\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00028\u00000\u000eH\u0002¢\u0006\u0004\b\u001f\u0010 \u001a)\u0010!\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u001c2\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00028\u00000\u000eH\u0002¢\u0006\u0004\b!\u0010\"\u001a\u000f\u0010!\u001a\u00020\u0007H\u0002¢\u0006\u0004\b!\u0010#\u001a-\u0010$\u001a\u00028\u0000\"\b\b\u0000\u0010\u001c*\u00020\n2\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00028\u00000\u000eH\u0002¢\u0006\u0004\b$\u0010%\u001a\u0017\u0010'\u001a\u00020\u00072\u0006\u0010&\u001a\u00020\nH\u0002¢\u0006\u0004\b'\u0010(\u001a'\u0010*\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\u00002\u0006\u0010)\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b*\u0010+\u001a'\u0010*\u001a\u00020\u00112\u0006\u0010-\u001a\u00020,2\u0006\u0010&\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b*\u0010.\u001a3\u00100\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u001c*\u00020,2\u0006\u0010/\u001a\u00028\u00002\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b0\u00101\u001a#\u00100\u001a\u00028\u0000\"\b\b\u0000\u0010\u001c*\u00020,*\u00028\u00002\u0006\u00103\u001a\u000202¢\u0006\u0004\b0\u00104\u001a\u000f\u00106\u001a\u000205H\u0002¢\u0006\u0004\b6\u00107\u001a\u0019\u00108\u001a\u0004\u0018\u00010,2\u0006\u00103\u001a\u000202H\u0002¢\u0006\u0004\b8\u00109\u001a\u0017\u0010:\u001a\u00020\u00112\u0006\u00103\u001a\u000202H\u0002¢\u0006\u0004\b:\u0010;\u001a\u000f\u0010<\u001a\u00020\u0007H\u0002¢\u0006\u0004\b<\u0010#\u001a\u0017\u0010=\u001a\u00020\u00072\u0006\u00103\u001a\u000202H\u0002¢\u0006\u0004\b=\u0010>\u001a-\u0010?\u001a\u00028\u0000\"\b\b\u0000\u0010\u001c*\u00020,*\u00028\u00002\u0006\u00103\u001a\u0002022\u0006\u0010&\u001a\u00020\nH\u0001¢\u0006\u0004\b?\u0010@\u001a5\u0010B\u001a\u00028\u0000\"\b\b\u0000\u0010\u001c*\u00020,*\u00028\u00002\u0006\u00103\u001a\u0002022\u0006\u0010&\u001a\u00020\n2\u0006\u0010A\u001a\u00028\u0000H\u0000¢\u0006\u0004\bB\u0010C\u001a-\u0010D\u001a\u00028\u0000\"\b\b\u0000\u0010\u001c*\u00020,*\u00028\u00002\u0006\u00103\u001a\u0002022\u0006\u0010&\u001a\u00020\nH\u0000¢\u0006\u0004\bD\u0010@\u001a-\u0010E\u001a\u00028\u0000\"\b\b\u0000\u0010\u001c*\u00020,*\u00028\u00002\u0006\u00103\u001a\u0002022\u0006\u0010&\u001a\u00020\nH\u0002¢\u0006\u0004\bE\u0010@\u001a%\u0010F\u001a\u00028\u0000\"\b\b\u0000\u0010\u001c*\u00020,*\u00028\u00002\u0006\u00103\u001a\u000202H\u0000¢\u0006\u0004\bF\u00104\u001a\u001f\u0010G\u001a\u00020\u00072\u0006\u0010&\u001a\u00020\n2\u0006\u00103\u001a\u000202H\u0001¢\u0006\u0004\bG\u0010H\u001a5\u0010M\u001a\u0010\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020,\u0018\u00010L2\u0006\u0010\u000b\u001a\u00020I2\u0006\u0010J\u001a\u00020I2\u0006\u0010K\u001a\u00020\u0002H\u0002¢\u0006\u0004\bM\u0010N\u001a\u000f\u0010O\u001a\u000205H\u0002¢\u0006\u0004\bO\u00107\u001a)\u0010P\u001a\u00028\u0000\"\b\b\u0000\u0010\u001c*\u00020,2\u0006\u0010/\u001a\u00028\u00002\u0006\u0010&\u001a\u00020\nH\u0001¢\u0006\u0004\bP\u0010Q\u001a!\u0010P\u001a\u00028\u0000\"\b\b\u0000\u0010\u001c*\u00020,2\u0006\u0010/\u001a\u00028\u0000H\u0001¢\u0006\u0004\bP\u0010R\u001a#\u0010U\u001a\u00020\u0002*\u00020\u00022\u0006\u0010S\u001a\u00020\u00002\u0006\u0010T\u001a\u00020\u0000H\u0000¢\u0006\u0004\bU\u0010V\" \u0010W\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00070\u000e8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bW\u0010X\"\u0014\u0010Y\u001a\u00020\u00008\u0002X\u0082T¢\u0006\u0006\n\u0004\bY\u0010Z\"\u001a\u0010\\\u001a\b\u0012\u0004\u0012\u00020\n0[8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\\\u0010]\" \u0010^\u001a\u00020\u000f8\u0000X\u0081\u0004¢\u0006\u0012\n\u0004\b^\u0010_\u0012\u0004\bb\u0010#\u001a\u0004\b`\u0010a\"\u0016\u0010c\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bc\u0010d\"\u0016\u0010e\u001a\u00020\u00008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\be\u0010Z\"\u0014\u0010g\u001a\u00020f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bg\u0010h\"\u001a\u0010j\u001a\b\u0012\u0004\u0012\u0002020i8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bj\u0010k\"4\u0010o\u001a \u0012\u001c\u0012\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0n\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00070m0l8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bo\u0010p\"(\u0010q\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00070\u000e0l8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bq\u0010p\"4\u0010v\u001a\"\u0012\f\u0012\n t*\u0004\u0018\u00010s0s0rj\u0010\u0012\f\u0012\n t*\u0004\u0018\u00010s0s`u8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bv\u0010w\" \u0010x\u001a\u00020\n8\u0000X\u0081\u0004¢\u0006\u0012\n\u0004\bx\u0010y\u0012\u0004\b{\u0010#\u001a\u0004\bz\u0010\f\"\u0016\u0010}\u001a\u00020|8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b}\u0010~¨\u0006\u007f"}, d2 = {BuildConfig.FLAVOR, Constants.ID_ATTRIBUTE_KEY, "Landroidx/compose/runtime/snapshots/SnapshotIdSet;", "invalid", "trackPinning", "(ILandroidx/compose/runtime/snapshots/SnapshotIdSet;)I", "handle", BuildConfig.FLAVOR, "releasePinningLocked", "(I)V", "Landroidx/compose/runtime/snapshots/Snapshot;", "currentSnapshot", "()Landroidx/compose/runtime/snapshots/Snapshot;", "previousSnapshot", "Lkotlin/Function1;", BuildConfig.FLAVOR, "readObserver", BuildConfig.FLAVOR, "ownsPreviousSnapshot", "createTransparentSnapshotWithNoParentReadObserver", "(Landroidx/compose/runtime/snapshots/Snapshot;Lkotlin/jvm/functions/Function1;Z)Landroidx/compose/runtime/snapshots/Snapshot;", "parentObserver", "mergeReadObserver", "mergedReadObserver", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Z)Lkotlin/jvm/functions/Function1;", "writeObserver", "mergedWriteObserver", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Lkotlin/jvm/functions/Function1;", "T", "previousGlobalSnapshot", "block", "takeNewGlobalSnapshot", "(Landroidx/compose/runtime/snapshots/Snapshot;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "advanceGlobalSnapshot", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "()V", "takeNewSnapshot", "(Lkotlin/jvm/functions/Function1;)Landroidx/compose/runtime/snapshots/Snapshot;", "snapshot", "validateOpen", "(Landroidx/compose/runtime/snapshots/Snapshot;)V", "candidateSnapshot", "valid", "(IILandroidx/compose/runtime/snapshots/SnapshotIdSet;)Z", "Landroidx/compose/runtime/snapshots/StateRecord;", "data", "(Landroidx/compose/runtime/snapshots/StateRecord;ILandroidx/compose/runtime/snapshots/SnapshotIdSet;)Z", "r", "readable", "(Landroidx/compose/runtime/snapshots/StateRecord;ILandroidx/compose/runtime/snapshots/SnapshotIdSet;)Landroidx/compose/runtime/snapshots/StateRecord;", "Landroidx/compose/runtime/snapshots/StateObject;", "state", "(Landroidx/compose/runtime/snapshots/StateRecord;Landroidx/compose/runtime/snapshots/StateObject;)Landroidx/compose/runtime/snapshots/StateRecord;", BuildConfig.FLAVOR, "readError", "()Ljava/lang/Void;", "usedLocked", "(Landroidx/compose/runtime/snapshots/StateObject;)Landroidx/compose/runtime/snapshots/StateRecord;", "overwriteUnusedRecordsLocked", "(Landroidx/compose/runtime/snapshots/StateObject;)Z", "checkAndOverwriteUnusedRecordsLocked", "processForUnusedRecordsLocked", "(Landroidx/compose/runtime/snapshots/StateObject;)V", "writableRecord", "(Landroidx/compose/runtime/snapshots/StateRecord;Landroidx/compose/runtime/snapshots/StateObject;Landroidx/compose/runtime/snapshots/Snapshot;)Landroidx/compose/runtime/snapshots/StateRecord;", "candidate", "overwritableRecord", "(Landroidx/compose/runtime/snapshots/StateRecord;Landroidx/compose/runtime/snapshots/StateObject;Landroidx/compose/runtime/snapshots/Snapshot;Landroidx/compose/runtime/snapshots/StateRecord;)Landroidx/compose/runtime/snapshots/StateRecord;", "newWritableRecord", "newWritableRecordLocked", "newOverwritableRecordLocked", "notifyWrite", "(Landroidx/compose/runtime/snapshots/Snapshot;Landroidx/compose/runtime/snapshots/StateObject;)V", "Landroidx/compose/runtime/snapshots/MutableSnapshot;", "applyingSnapshot", "invalidSnapshots", BuildConfig.FLAVOR, "optimisticMerges", "(Landroidx/compose/runtime/snapshots/MutableSnapshot;Landroidx/compose/runtime/snapshots/MutableSnapshot;Landroidx/compose/runtime/snapshots/SnapshotIdSet;)Ljava/util/Map;", "reportReadonlySnapshotWrite", "current", "(Landroidx/compose/runtime/snapshots/StateRecord;Landroidx/compose/runtime/snapshots/Snapshot;)Landroidx/compose/runtime/snapshots/StateRecord;", "(Landroidx/compose/runtime/snapshots/StateRecord;)Landroidx/compose/runtime/snapshots/StateRecord;", "from", "until", "addRange", "(Landroidx/compose/runtime/snapshots/SnapshotIdSet;II)Landroidx/compose/runtime/snapshots/SnapshotIdSet;", "emptyLambda", "Lkotlin/jvm/functions/Function1;", "INVALID_SNAPSHOT", "I", "Landroidx/compose/runtime/SnapshotThreadLocal;", "threadSnapshot", "Landroidx/compose/runtime/SnapshotThreadLocal;", "lock", "Ljava/lang/Object;", "getLock", "()Ljava/lang/Object;", "getLock$annotations", "openSnapshots", "Landroidx/compose/runtime/snapshots/SnapshotIdSet;", "nextSnapshotId", "Landroidx/compose/runtime/snapshots/SnapshotDoubleIndexHeap;", "pinningTable", "Landroidx/compose/runtime/snapshots/SnapshotDoubleIndexHeap;", "Landroidx/compose/runtime/snapshots/SnapshotWeakSet;", "extraStateObjects", "Landroidx/compose/runtime/snapshots/SnapshotWeakSet;", BuildConfig.FLAVOR, "Lkotlin/Function2;", BuildConfig.FLAVOR, "applyObservers", "Ljava/util/List;", "globalWriteObservers", "Ljava/util/concurrent/atomic/AtomicReference;", "Landroidx/compose/runtime/snapshots/GlobalSnapshot;", "kotlin.jvm.PlatformType", "Landroidx/compose/runtime/AtomicReference;", "currentGlobalSnapshot", "Ljava/util/concurrent/atomic/AtomicReference;", "snapshotInitializer", "Landroidx/compose/runtime/snapshots/Snapshot;", "getSnapshotInitializer", "getSnapshotInitializer$annotations", "Landroidx/compose/runtime/AtomicInt;", "pendingApplyObserverCount", "Landroidx/compose/runtime/AtomicInt;", "runtime_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class SnapshotKt {
    private static final int INVALID_SNAPSHOT = 0;
    private static List<? extends Function2<? super Set<? extends Object>, ? super Snapshot, Unit>> applyObservers;
    private static final AtomicReference<GlobalSnapshot> currentGlobalSnapshot;
    private static final SnapshotWeakSet<StateObject> extraStateObjects;
    private static List<? extends Function1<Object, Unit>> globalWriteObservers;
    private static int nextSnapshotId;
    private static SnapshotIdSet openSnapshots;
    private static AtomicInt pendingApplyObserverCount;
    private static final SnapshotDoubleIndexHeap pinningTable;
    private static final Snapshot snapshotInitializer;
    private static final Function1<SnapshotIdSet, Unit> emptyLambda = new Function1<SnapshotIdSet, Unit>() { // from class: androidx.compose.runtime.snapshots.SnapshotKt$emptyLambda$1
        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(SnapshotIdSet snapshotIdSet) {
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(SnapshotIdSet snapshotIdSet) {
            invoke2(snapshotIdSet);
            return Unit.INSTANCE;
        }
    };
    private static final SnapshotThreadLocal<Snapshot> threadSnapshot = new SnapshotThreadLocal<>();
    private static final Object lock = new Object();

    static {
        SnapshotIdSet.Companion companion = SnapshotIdSet.INSTANCE;
        openSnapshots = companion.getEMPTY();
        nextSnapshotId = 2;
        pinningTable = new SnapshotDoubleIndexHeap();
        extraStateObjects = new SnapshotWeakSet<>();
        applyObservers = CollectionsKt.emptyList();
        globalWriteObservers = CollectionsKt.emptyList();
        int i5 = nextSnapshotId;
        nextSnapshotId = i5 + 1;
        GlobalSnapshot globalSnapshot = new GlobalSnapshot(i5, companion.getEMPTY());
        openSnapshots = openSnapshots.set(globalSnapshot.getId());
        AtomicReference<GlobalSnapshot> atomicReference = new AtomicReference<>(globalSnapshot);
        currentGlobalSnapshot = atomicReference;
        snapshotInitializer = atomicReference.get();
        pendingApplyObserverCount = new AtomicInt(0);
    }

    public static final SnapshotIdSet addRange(SnapshotIdSet snapshotIdSet, int i5, int i6) {
        while (i5 < i6) {
            snapshotIdSet = snapshotIdSet.set(i5);
            i5++;
        }
        return snapshotIdSet;
    }

    public static final <T> T advanceGlobalSnapshot(Function1<? super SnapshotIdSet, ? extends T> function1) {
        GlobalSnapshot globalSnapshot;
        MutableScatterSet<StateObject> modified$runtime_release;
        T t5;
        Snapshot snapshot = snapshotInitializer;
        Intrinsics.checkNotNull(snapshot, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.GlobalSnapshot");
        synchronized (getLock()) {
            try {
                globalSnapshot = currentGlobalSnapshot.get();
                modified$runtime_release = globalSnapshot.getModified$runtime_release();
                if (modified$runtime_release != null) {
                    pendingApplyObserverCount.add(1);
                }
                t5 = (T) takeNewGlobalSnapshot(globalSnapshot, function1);
            } catch (Throwable th) {
                throw th;
            }
        }
        if (modified$runtime_release != null) {
            try {
                List<? extends Function2<? super Set<? extends Object>, ? super Snapshot, Unit>> list = applyObservers;
                int size = list.size();
                for (int i5 = 0; i5 < size; i5++) {
                    list.get(i5).invoke(ScatterSetWrapperKt.wrapIntoSet(modified$runtime_release), globalSnapshot);
                }
            } finally {
                pendingApplyObserverCount.add(-1);
            }
        }
        synchronized (getLock()) {
            try {
                checkAndOverwriteUnusedRecordsLocked();
                if (modified$runtime_release != null) {
                    Object[] objArr = modified$runtime_release.elements;
                    long[] jArr = modified$runtime_release.metadata;
                    int length = jArr.length - 2;
                    if (length >= 0) {
                        int i6 = 0;
                        while (true) {
                            long j5 = jArr[i6];
                            if ((((~j5) << 7) & j5 & (-9187201950435737472L)) != -9187201950435737472L) {
                                int i7 = 8 - ((~(i6 - length)) >>> 31);
                                for (int i8 = 0; i8 < i7; i8++) {
                                    if ((255 & j5) < 128) {
                                        processForUnusedRecordsLocked((StateObject) objArr[(i6 << 3) + i8]);
                                    }
                                    j5 >>= 8;
                                }
                                if (i7 != 8) {
                                    break;
                                }
                            }
                            if (i6 == length) {
                                break;
                            }
                            i6++;
                        }
                    }
                    Unit unit = Unit.INSTANCE;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return t5;
    }

    public static final void checkAndOverwriteUnusedRecordsLocked() {
        SnapshotWeakSet<StateObject> snapshotWeakSet = extraStateObjects;
        int size = snapshotWeakSet.getSize();
        int i5 = 0;
        int i6 = 0;
        while (true) {
            if (i5 >= size) {
                break;
            }
            WeakReference<StateObject> weakReference = snapshotWeakSet.getValues$runtime_release()[i5];
            StateObject stateObject = weakReference != null ? weakReference.get() : null;
            if (stateObject != null && overwriteUnusedRecordsLocked(stateObject)) {
                if (i6 != i5) {
                    snapshotWeakSet.getValues$runtime_release()[i6] = weakReference;
                    snapshotWeakSet.getHashes()[i6] = snapshotWeakSet.getHashes()[i5];
                }
                i6++;
            }
            i5++;
        }
        for (int i7 = i6; i7 < size; i7++) {
            snapshotWeakSet.getValues$runtime_release()[i7] = null;
            snapshotWeakSet.getHashes()[i7] = 0;
        }
        if (i6 != size) {
            snapshotWeakSet.setSize$runtime_release(i6);
        }
    }

    public static final Snapshot createTransparentSnapshotWithNoParentReadObserver(Snapshot snapshot, Function1<Object, Unit> function1, boolean z5) {
        boolean z6 = snapshot instanceof MutableSnapshot;
        if (z6 || snapshot == null) {
            return new TransparentObserverMutableSnapshot(z6 ? (MutableSnapshot) snapshot : null, function1, null, false, z5);
        }
        return new TransparentObserverSnapshot(snapshot, function1, false, z5);
    }

    public static /* synthetic */ Snapshot createTransparentSnapshotWithNoParentReadObserver$default(Snapshot snapshot, Function1 function1, boolean z5, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            function1 = null;
        }
        if ((i5 & 4) != 0) {
            z5 = false;
        }
        return createTransparentSnapshotWithNoParentReadObserver(snapshot, function1, z5);
    }

    public static final <T extends StateRecord> T current(T t5, Snapshot snapshot) {
        T t6 = (T) readable(t5, snapshot.getId(), snapshot.getInvalid());
        if (t6 != null) {
            return t6;
        }
        readError();
        throw new KotlinNothingValueException();
    }

    public static final Snapshot currentSnapshot() {
        Snapshot snapshot = threadSnapshot.get();
        return snapshot == null ? currentGlobalSnapshot.get() : snapshot;
    }

    public static final Object getLock() {
        return lock;
    }

    public static final Snapshot getSnapshotInitializer() {
        return snapshotInitializer;
    }

    public static final Function1<Object, Unit> mergedReadObserver(final Function1<Object, Unit> function1, final Function1<Object, Unit> function12, boolean z5) {
        if (!z5) {
            function12 = null;
        }
        return (function1 == null || function12 == null || function1 == function12) ? function1 == null ? function12 : function1 : new Function1<Object, Unit>() { // from class: androidx.compose.runtime.snapshots.SnapshotKt$mergedReadObserver$1
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
                function1.invoke(obj);
                function12.invoke(obj);
            }
        };
    }

    public static /* synthetic */ Function1 mergedReadObserver$default(Function1 function1, Function1 function12, boolean z5, int i5, Object obj) {
        if ((i5 & 4) != 0) {
            z5 = true;
        }
        return mergedReadObserver(function1, function12, z5);
    }

    public static final Function1<Object, Unit> mergedWriteObserver(final Function1<Object, Unit> function1, final Function1<Object, Unit> function12) {
        return (function1 == null || function12 == null || function1 == function12) ? function1 == null ? function12 : function1 : new Function1<Object, Unit>() { // from class: androidx.compose.runtime.snapshots.SnapshotKt$mergedWriteObserver$1
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
                function1.invoke(obj);
                function12.invoke(obj);
            }
        };
    }

    public static final <T extends StateRecord> T newOverwritableRecordLocked(T t5, StateObject stateObject) {
        T t6 = (T) usedLocked(stateObject);
        if (t6 != null) {
            t6.setSnapshotId$runtime_release(Integer.MAX_VALUE);
            return t6;
        }
        T t7 = (T) t5.create();
        t7.setSnapshotId$runtime_release(Integer.MAX_VALUE);
        t7.setNext$runtime_release(stateObject.getFirstStateRecord());
        Intrinsics.checkNotNull(t7, "null cannot be cast to non-null type T of androidx.compose.runtime.snapshots.SnapshotKt.newOverwritableRecordLocked$lambda$16");
        stateObject.prependStateRecord(t7);
        Intrinsics.checkNotNull(t7, "null cannot be cast to non-null type T of androidx.compose.runtime.snapshots.SnapshotKt.newOverwritableRecordLocked");
        return t7;
    }

    public static final <T extends StateRecord> T newWritableRecord(T t5, StateObject stateObject, Snapshot snapshot) {
        T t6;
        synchronized (getLock()) {
            t6 = (T) newWritableRecordLocked(t5, stateObject, snapshot);
        }
        return t6;
    }

    private static final <T extends StateRecord> T newWritableRecordLocked(T t5, StateObject stateObject, Snapshot snapshot) {
        T t6 = (T) newOverwritableRecordLocked(t5, stateObject);
        t6.assign(t5);
        t6.setSnapshotId$runtime_release(snapshot.getId());
        return t6;
    }

    public static final void notifyWrite(Snapshot snapshot, StateObject stateObject) {
        snapshot.setWriteCount$runtime_release(snapshot.getWriteCount$runtime_release() + 1);
        Function1<Object, Unit> writeObserver$runtime_release = snapshot.getWriteObserver$runtime_release();
        if (writeObserver$runtime_release != null) {
            writeObserver$runtime_release.invoke(stateObject);
        }
    }

    public static final Map<StateRecord, StateRecord> optimisticMerges(MutableSnapshot mutableSnapshot, MutableSnapshot mutableSnapshot2, SnapshotIdSet snapshotIdSet) {
        long[] jArr;
        int i5;
        HashMap hashMap;
        long[] jArr2;
        int i6;
        HashMap hashMap2;
        int i7;
        StateRecord readable;
        MutableScatterSet<StateObject> modified$runtime_release = mutableSnapshot2.getModified$runtime_release();
        int id = mutableSnapshot.getId();
        HashMap hashMap3 = null;
        if (modified$runtime_release == null) {
            return null;
        }
        SnapshotIdSet or = mutableSnapshot2.getInvalid().set(mutableSnapshot2.getId()).or(mutableSnapshot2.getPreviousIds$runtime_release());
        Object[] objArr = modified$runtime_release.elements;
        long[] jArr3 = modified$runtime_release.metadata;
        int length = jArr3.length - 2;
        if (length >= 0) {
            HashMap hashMap4 = null;
            int i8 = 0;
            while (true) {
                long j5 = jArr3[i8];
                if ((((~j5) << 7) & j5 & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i9 = 8;
                    int i10 = 8 - ((~(i8 - length)) >>> 31);
                    int i11 = 0;
                    while (i11 < i10) {
                        if ((255 & j5) < 128) {
                            StateObject stateObject = (StateObject) objArr[(i8 << 3) + i11];
                            StateRecord firstStateRecord = stateObject.getFirstStateRecord();
                            StateRecord readable2 = readable(firstStateRecord, id, snapshotIdSet);
                            if (readable2 == null || (readable = readable(firstStateRecord, id, or)) == null || Intrinsics.areEqual(readable2, readable)) {
                                jArr2 = jArr3;
                                i6 = id;
                            } else {
                                jArr2 = jArr3;
                                i6 = id;
                                StateRecord readable3 = readable(firstStateRecord, mutableSnapshot2.getId(), mutableSnapshot2.getInvalid());
                                if (readable3 == null) {
                                    readError();
                                    throw new KotlinNothingValueException();
                                }
                                StateRecord mergeRecords = stateObject.mergeRecords(readable, readable2, readable3);
                                if (mergeRecords == null) {
                                    return null;
                                }
                                if (hashMap4 == null) {
                                    hashMap4 = new HashMap();
                                }
                                hashMap4.put(readable2, mergeRecords);
                                hashMap4 = hashMap4;
                            }
                            hashMap2 = null;
                            i7 = 8;
                        } else {
                            jArr2 = jArr3;
                            i6 = id;
                            hashMap2 = hashMap3;
                            i7 = i9;
                        }
                        j5 >>= i7;
                        i11++;
                        hashMap3 = hashMap2;
                        i9 = i7;
                        jArr3 = jArr2;
                        id = i6;
                    }
                    jArr = jArr3;
                    i5 = id;
                    hashMap = hashMap3;
                    if (i10 != i9) {
                        return hashMap4;
                    }
                } else {
                    jArr = jArr3;
                    i5 = id;
                    hashMap = hashMap3;
                }
                if (i8 == length) {
                    hashMap3 = hashMap4;
                    break;
                }
                i8++;
                hashMap3 = hashMap;
                jArr3 = jArr;
                id = i5;
            }
        }
        return hashMap3;
    }

    public static final <T extends StateRecord> T overwritableRecord(T t5, StateObject stateObject, Snapshot snapshot, T t6) {
        T t7;
        if (snapshot.getReadOnly()) {
            snapshot.mo1247recordModified$runtime_release(stateObject);
        }
        int id = snapshot.getId();
        if (t6.getSnapshotId() == id) {
            return t6;
        }
        synchronized (getLock()) {
            t7 = (T) newOverwritableRecordLocked(t5, stateObject);
        }
        t7.setSnapshotId$runtime_release(id);
        if (t6.getSnapshotId() != 1) {
            snapshot.mo1247recordModified$runtime_release(stateObject);
        }
        return t7;
    }

    private static final boolean overwriteUnusedRecordsLocked(StateObject stateObject) {
        StateRecord stateRecord;
        int lowestOrDefault = pinningTable.lowestOrDefault(nextSnapshotId);
        StateRecord stateRecord2 = null;
        StateRecord stateRecord3 = null;
        int i5 = 0;
        for (StateRecord firstStateRecord = stateObject.getFirstStateRecord(); firstStateRecord != null; firstStateRecord = firstStateRecord.getNext()) {
            int snapshotId = firstStateRecord.getSnapshotId();
            if (snapshotId != 0) {
                if (snapshotId >= lowestOrDefault) {
                    i5++;
                } else if (stateRecord2 == null) {
                    i5++;
                    stateRecord2 = firstStateRecord;
                } else {
                    if (firstStateRecord.getSnapshotId() < stateRecord2.getSnapshotId()) {
                        stateRecord = stateRecord2;
                        stateRecord2 = firstStateRecord;
                    } else {
                        stateRecord = firstStateRecord;
                    }
                    if (stateRecord3 == null) {
                        stateRecord3 = stateObject.getFirstStateRecord();
                        StateRecord stateRecord4 = stateRecord3;
                        while (true) {
                            if (stateRecord3 == null) {
                                stateRecord3 = stateRecord4;
                                break;
                            }
                            if (stateRecord3.getSnapshotId() >= lowestOrDefault) {
                                break;
                            }
                            if (stateRecord4.getSnapshotId() < stateRecord3.getSnapshotId()) {
                                stateRecord4 = stateRecord3;
                            }
                            stateRecord3 = stateRecord3.getNext();
                        }
                    }
                    stateRecord2.setSnapshotId$runtime_release(0);
                    stateRecord2.assign(stateRecord3);
                    stateRecord2 = stateRecord;
                }
            }
        }
        return i5 > 1;
    }

    public static final void processForUnusedRecordsLocked(StateObject stateObject) {
        if (overwriteUnusedRecordsLocked(stateObject)) {
            extraStateObjects.add(stateObject);
        }
    }

    public static final Void readError() {
        throw new IllegalStateException("Reading a state that was created after the snapshot was taken or in a snapshot that has not yet been applied");
    }

    public static final <T extends StateRecord> T readable(T t5, int i5, SnapshotIdSet snapshotIdSet) {
        T t6 = null;
        while (t5 != null) {
            if (valid(t5, i5, snapshotIdSet) && (t6 == null || t6.getSnapshotId() < t5.getSnapshotId())) {
                t6 = t5;
            }
            t5 = (T) t5.getNext();
        }
        if (t6 != null) {
            return t6;
        }
        return null;
    }

    public static final void releasePinningLocked(int i5) {
        pinningTable.remove(i5);
    }

    public static final Void reportReadonlySnapshotWrite() {
        throw new IllegalStateException("Cannot modify a state object in a read-only snapshot");
    }

    public static final <T> T takeNewGlobalSnapshot(Snapshot snapshot, Function1<? super SnapshotIdSet, ? extends T> function1) {
        T invoke = function1.invoke(openSnapshots.clear(snapshot.getId()));
        synchronized (getLock()) {
            int i5 = nextSnapshotId;
            nextSnapshotId = i5 + 1;
            openSnapshots = openSnapshots.clear(snapshot.getId());
            currentGlobalSnapshot.set(new GlobalSnapshot(i5, openSnapshots));
            snapshot.dispose();
            openSnapshots = openSnapshots.set(i5);
            Unit unit = Unit.INSTANCE;
        }
        return invoke;
    }

    public static final <T extends Snapshot> T takeNewSnapshot(final Function1<? super SnapshotIdSet, ? extends T> function1) {
        return (T) advanceGlobalSnapshot(new Function1<SnapshotIdSet, T>() { // from class: androidx.compose.runtime.snapshots.SnapshotKt$takeNewSnapshot$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            /* JADX WARN: Incorrect return type in method signature: (Landroidx/compose/runtime/snapshots/SnapshotIdSet;)TT; */
            @Override // kotlin.jvm.functions.Function1
            public final Snapshot invoke(SnapshotIdSet snapshotIdSet) {
                SnapshotIdSet snapshotIdSet2;
                Snapshot snapshot = (Snapshot) function1.invoke(snapshotIdSet);
                synchronized (SnapshotKt.getLock()) {
                    snapshotIdSet2 = SnapshotKt.openSnapshots;
                    SnapshotKt.openSnapshots = snapshotIdSet2.set(snapshot.getId());
                    Unit unit = Unit.INSTANCE;
                }
                return snapshot;
            }
        });
    }

    public static final int trackPinning(int i5, SnapshotIdSet snapshotIdSet) {
        int add;
        int lowest = snapshotIdSet.lowest(i5);
        synchronized (getLock()) {
            add = pinningTable.add(lowest);
        }
        return add;
    }

    private static final StateRecord usedLocked(StateObject stateObject) {
        int lowestOrDefault = pinningTable.lowestOrDefault(nextSnapshotId) - 1;
        SnapshotIdSet empty = SnapshotIdSet.INSTANCE.getEMPTY();
        StateRecord stateRecord = null;
        for (StateRecord firstStateRecord = stateObject.getFirstStateRecord(); firstStateRecord != null; firstStateRecord = firstStateRecord.getNext()) {
            if (firstStateRecord.getSnapshotId() == 0) {
                return firstStateRecord;
            }
            if (valid(firstStateRecord, lowestOrDefault, empty)) {
                if (stateRecord != null) {
                    return firstStateRecord.getSnapshotId() < stateRecord.getSnapshotId() ? firstStateRecord : stateRecord;
                }
                stateRecord = firstStateRecord;
            }
        }
        return null;
    }

    private static final boolean valid(int i5, int i6, SnapshotIdSet snapshotIdSet) {
        return (i6 == 0 || i6 > i5 || snapshotIdSet.get(i6)) ? false : true;
    }

    public static final void validateOpen(Snapshot snapshot) {
        int lowestOrDefault;
        if (openSnapshots.get(snapshot.getId())) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Snapshot is not open: id=");
        sb.append(snapshot.getId());
        sb.append(", disposed=");
        sb.append(snapshot.getDisposed());
        sb.append(", applied=");
        MutableSnapshot mutableSnapshot = snapshot instanceof MutableSnapshot ? (MutableSnapshot) snapshot : null;
        sb.append(mutableSnapshot != null ? Boolean.valueOf(mutableSnapshot.getApplied$runtime_release()) : "read-only");
        sb.append(", lowestPin=");
        synchronized (getLock()) {
            lowestOrDefault = pinningTable.lowestOrDefault(-1);
        }
        sb.append(lowestOrDefault);
        throw new IllegalStateException(sb.toString().toString());
    }

    public static final <T extends StateRecord> T writableRecord(T t5, StateObject stateObject, Snapshot snapshot) {
        T t6;
        if (snapshot.getReadOnly()) {
            snapshot.mo1247recordModified$runtime_release(stateObject);
        }
        int id = snapshot.getId();
        T t7 = (T) readable(t5, id, snapshot.getInvalid());
        if (t7 == null) {
            readError();
            throw new KotlinNothingValueException();
        }
        if (t7.getSnapshotId() == snapshot.getId()) {
            return t7;
        }
        synchronized (getLock()) {
            t6 = (T) readable(stateObject.getFirstStateRecord(), id, snapshot.getInvalid());
            if (t6 == null) {
                readError();
                throw new KotlinNothingValueException();
            }
            if (t6.getSnapshotId() != id) {
                t6 = (T) newWritableRecordLocked(t6, stateObject, snapshot);
            }
        }
        Intrinsics.checkNotNull(t6, "null cannot be cast to non-null type T of androidx.compose.runtime.snapshots.SnapshotKt.writableRecord");
        if (t7.getSnapshotId() != 1) {
            snapshot.mo1247recordModified$runtime_release(stateObject);
        }
        return t6;
    }

    public static final <T extends StateRecord> T current(T t5) {
        T t6;
        Snapshot.Companion companion = Snapshot.INSTANCE;
        Snapshot current = companion.getCurrent();
        T t7 = (T) readable(t5, current.getId(), current.getInvalid());
        if (t7 != null) {
            return t7;
        }
        synchronized (getLock()) {
            Snapshot current2 = companion.getCurrent();
            t6 = (T) readable(t5, current2.getId(), current2.getInvalid());
        }
        if (t6 != null) {
            return t6;
        }
        readError();
        throw new KotlinNothingValueException();
    }

    private static final boolean valid(StateRecord stateRecord, int i5, SnapshotIdSet snapshotIdSet) {
        return valid(i5, stateRecord.getSnapshotId(), snapshotIdSet);
    }

    public static final <T extends StateRecord> T readable(T t5, StateObject stateObject) {
        T t6;
        Snapshot.Companion companion = Snapshot.INSTANCE;
        Snapshot current = companion.getCurrent();
        Function1<Object, Unit> readObserver = current.getReadObserver();
        if (readObserver != null) {
            readObserver.invoke(stateObject);
        }
        T t7 = (T) readable(t5, current.getId(), current.getInvalid());
        if (t7 != null) {
            return t7;
        }
        synchronized (getLock()) {
            Snapshot current2 = companion.getCurrent();
            StateRecord firstStateRecord = stateObject.getFirstStateRecord();
            Intrinsics.checkNotNull(firstStateRecord, "null cannot be cast to non-null type T of androidx.compose.runtime.snapshots.SnapshotKt.readable$lambda$9");
            t6 = (T) readable(firstStateRecord, current2.getId(), current2.getInvalid());
            if (t6 == null) {
                readError();
                throw new KotlinNothingValueException();
            }
        }
        return t6;
    }

    public static final void advanceGlobalSnapshot() {
        advanceGlobalSnapshot(new Function1<SnapshotIdSet, Unit>() { // from class: androidx.compose.runtime.snapshots.SnapshotKt$advanceGlobalSnapshot$3
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(SnapshotIdSet snapshotIdSet) {
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SnapshotIdSet snapshotIdSet) {
                invoke2(snapshotIdSet);
                return Unit.INSTANCE;
            }
        });
    }
}
