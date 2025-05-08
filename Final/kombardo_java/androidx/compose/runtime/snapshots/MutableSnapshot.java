package androidx.compose.runtime.snapshots;

import androidx.collection.MutableScatterSet;
import androidx.collection.ScatterSetKt;
import androidx.compose.runtime.PreconditionsKt;
import androidx.compose.runtime.collection.ScatterSetWrapperKt;
import androidx.compose.runtime.snapshots.SnapshotApplyResult;
import com.sdk.growthbook.utils.Constants;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0015\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\n\b\u0017\u0018\u0000 n2\u00020\u0001:\u0001nBE\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0014\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0006\u0012\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0006¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\bH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000f\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0010\u0010\u000eJ\u000f\u0010\u0011\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0011\u0010\u000eJ?\u0010\u0012\u001a\u00020\u00002\u0016\b\u0002\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u00062\u0016\b\u0002\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0017\u0010\u000eJ%\u0010\u0018\u001a\u00020\u00012\u0014\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001d\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u0001H\u0010¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001f\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u0001H\u0010¢\u0006\u0004\b\u001e\u0010\u001cJ\u000f\u0010!\u001a\u00020\bH\u0010¢\u0006\u0004\b \u0010\u000eJ\u000f\u0010#\u001a\u00020\bH\u0010¢\u0006\u0004\b\"\u0010\u000eJ\u000f\u0010%\u001a\u00020\bH\u0010¢\u0006\u0004\b$\u0010\u000eJ5\u0010-\u001a\u00020\u00142\u0006\u0010&\u001a\u00020\u00022\u0014\u0010)\u001a\u0010\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020(\u0018\u00010'2\u0006\u0010*\u001a\u00020\u0004H\u0000¢\u0006\u0004\b+\u0010,J\u000f\u0010/\u001a\u00020\bH\u0000¢\u0006\u0004\b.\u0010\u000eJ\u0017\u00102\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0000¢\u0006\u0004\b0\u00101J\u0017\u00104\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0000¢\u0006\u0004\b3\u00101J\u0017\u00109\u001a\u00020\b2\u0006\u00106\u001a\u000205H\u0000¢\u0006\u0004\b7\u00108J\u0017\u0010=\u001a\u00020\b2\u0006\u0010:\u001a\u00020\u0004H\u0000¢\u0006\u0004\b;\u0010<J\u0017\u0010B\u001a\u00020\b2\u0006\u0010?\u001a\u00020>H\u0010¢\u0006\u0004\b@\u0010AR(\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u00068\u0010X\u0090\u0004¢\u0006\f\n\u0004\b\t\u0010C\u001a\u0004\bD\u0010ER(\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u00068\u0010X\u0090\u0004¢\u0006\f\n\u0004\b\n\u0010C\u001a\u0004\bF\u0010ER\"\u0010G\u001a\u00020\u00028\u0010@\u0010X\u0090\u000e¢\u0006\u0012\n\u0004\bG\u0010H\u001a\u0004\bI\u0010J\"\u0004\bK\u00101R:\u0010N\u001a\n\u0012\u0004\u0012\u00020>\u0018\u00010L2\u000e\u0010M\u001a\n\u0012\u0004\u0012\u00020>\u0018\u00010L8\u0010@VX\u0090\u000e¢\u0006\u0012\n\u0004\bN\u0010O\u001a\u0004\bP\u0010Q\"\u0004\bR\u0010SR*\u0010U\u001a\n\u0012\u0004\u0012\u00020>\u0018\u00010T8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bU\u0010V\u001a\u0004\bW\u0010X\"\u0004\bY\u0010ZR\"\u0010[\u001a\u00020\u00048\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b[\u0010\\\u001a\u0004\b]\u0010^\"\u0004\b_\u0010<R\"\u0010`\u001a\u0002058\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b`\u0010a\u001a\u0004\bb\u0010c\"\u0004\bd\u00108R\u0016\u0010:\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b:\u0010HR\"\u0010f\u001a\u00020e8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\bf\u0010g\u001a\u0004\bh\u0010i\"\u0004\bj\u0010kR\u0014\u0010m\u001a\u00020e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bl\u0010i¨\u0006o"}, d2 = {"Landroidx/compose/runtime/snapshots/MutableSnapshot;", "Landroidx/compose/runtime/snapshots/Snapshot;", BuildConfig.FLAVOR, Constants.ID_ATTRIBUTE_KEY, "Landroidx/compose/runtime/snapshots/SnapshotIdSet;", "invalid", "Lkotlin/Function1;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "readObserver", "writeObserver", "<init>", "(ILandroidx/compose/runtime/snapshots/SnapshotIdSet;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "validateNotApplied", "()V", "validateNotAppliedOrPinned", "abandon", "releasePreviouslyPinnedSnapshotsLocked", "takeNestedMutableSnapshot", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Landroidx/compose/runtime/snapshots/MutableSnapshot;", "Landroidx/compose/runtime/snapshots/SnapshotApplyResult;", "apply", "()Landroidx/compose/runtime/snapshots/SnapshotApplyResult;", "dispose", "takeNestedSnapshot", "(Lkotlin/jvm/functions/Function1;)Landroidx/compose/runtime/snapshots/Snapshot;", "snapshot", "nestedActivated$runtime_release", "(Landroidx/compose/runtime/snapshots/Snapshot;)V", "nestedActivated", "nestedDeactivated$runtime_release", "nestedDeactivated", "notifyObjectsInitialized$runtime_release", "notifyObjectsInitialized", "closeLocked$runtime_release", "closeLocked", "releasePinnedSnapshotsForCloseLocked$runtime_release", "releasePinnedSnapshotsForCloseLocked", "snapshotId", BuildConfig.FLAVOR, "Landroidx/compose/runtime/snapshots/StateRecord;", "optimisticMerges", "invalidSnapshots", "innerApplyLocked$runtime_release", "(ILjava/util/Map;Landroidx/compose/runtime/snapshots/SnapshotIdSet;)Landroidx/compose/runtime/snapshots/SnapshotApplyResult;", "innerApplyLocked", "advance$runtime_release", "advance", "recordPrevious$runtime_release", "(I)V", "recordPrevious", "recordPreviousPinnedSnapshot$runtime_release", "recordPreviousPinnedSnapshot", BuildConfig.FLAVOR, "handles", "recordPreviousPinnedSnapshots$runtime_release", "([I)V", "recordPreviousPinnedSnapshots", "snapshots", "recordPreviousList$runtime_release", "(Landroidx/compose/runtime/snapshots/SnapshotIdSet;)V", "recordPreviousList", "Landroidx/compose/runtime/snapshots/StateObject;", "state", "recordModified$runtime_release", "(Landroidx/compose/runtime/snapshots/StateObject;)V", "recordModified", "Lkotlin/jvm/functions/Function1;", "getReadObserver$runtime_release", "()Lkotlin/jvm/functions/Function1;", "getWriteObserver$runtime_release", "writeCount", "I", "getWriteCount$runtime_release", "()I", "setWriteCount$runtime_release", "Landroidx/collection/MutableScatterSet;", "<set-?>", "modified", "Landroidx/collection/MutableScatterSet;", "getModified$runtime_release", "()Landroidx/collection/MutableScatterSet;", "setModified", "(Landroidx/collection/MutableScatterSet;)V", BuildConfig.FLAVOR, "merged", "Ljava/util/List;", "getMerged$runtime_release", "()Ljava/util/List;", "setMerged$runtime_release", "(Ljava/util/List;)V", "previousIds", "Landroidx/compose/runtime/snapshots/SnapshotIdSet;", "getPreviousIds$runtime_release", "()Landroidx/compose/runtime/snapshots/SnapshotIdSet;", "setPreviousIds$runtime_release", "previousPinnedSnapshots", "[I", "getPreviousPinnedSnapshots$runtime_release", "()[I", "setPreviousPinnedSnapshots$runtime_release", BuildConfig.FLAVOR, "applied", "Z", "getApplied$runtime_release", "()Z", "setApplied$runtime_release", "(Z)V", "getReadOnly", "readOnly", "Companion", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public class MutableSnapshot extends Snapshot {
    private boolean applied;
    private List<? extends StateObject> merged;
    private MutableScatterSet<StateObject> modified;
    private SnapshotIdSet previousIds;
    private int[] previousPinnedSnapshots;
    private final Function1<Object, Unit> readObserver;
    private int snapshots;
    private int writeCount;
    private final Function1<Object, Unit> writeObserver;
    private static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    private static final int[] EmptyIntArray = new int[0];

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Landroidx/compose/runtime/snapshots/MutableSnapshot$Companion;", BuildConfig.FLAVOR, "()V", "EmptyIntArray", BuildConfig.FLAVOR, "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public MutableSnapshot(int i5, SnapshotIdSet snapshotIdSet, Function1<Object, Unit> function1, Function1<Object, Unit> function12) {
        super(i5, snapshotIdSet, null);
        this.readObserver = function1;
        this.writeObserver = function12;
        this.previousIds = SnapshotIdSet.INSTANCE.getEMPTY();
        this.previousPinnedSnapshots = EmptyIntArray;
        this.snapshots = 1;
    }

    private final void abandon() {
        MutableScatterSet<StateObject> modified$runtime_release = getModified$runtime_release();
        if (modified$runtime_release != null) {
            validateNotApplied();
            setModified(null);
            int id = getId();
            Object[] objArr = modified$runtime_release.elements;
            long[] jArr = modified$runtime_release.metadata;
            int length = jArr.length - 2;
            if (length >= 0) {
                int i5 = 0;
                while (true) {
                    long j5 = jArr[i5];
                    if ((((~j5) << 7) & j5 & (-9187201950435737472L)) != -9187201950435737472L) {
                        int i6 = 8 - ((~(i5 - length)) >>> 31);
                        for (int i7 = 0; i7 < i6; i7++) {
                            if ((255 & j5) < 128) {
                                for (StateRecord firstStateRecord = ((StateObject) objArr[(i5 << 3) + i7]).getFirstStateRecord(); firstStateRecord != null; firstStateRecord = firstStateRecord.getNext()) {
                                    if (firstStateRecord.getSnapshotId() == id || CollectionsKt.contains(this.previousIds, Integer.valueOf(firstStateRecord.getSnapshotId()))) {
                                        firstStateRecord.setSnapshotId$runtime_release(0);
                                    }
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
                    } else {
                        i5++;
                    }
                }
            }
        }
        closeAndReleasePinning$runtime_release();
    }

    private final void releasePreviouslyPinnedSnapshotsLocked() {
        int length = this.previousPinnedSnapshots.length;
        for (int i5 = 0; i5 < length; i5++) {
            SnapshotKt.releasePinningLocked(this.previousPinnedSnapshots[i5]);
        }
    }

    private final void validateNotApplied() {
        if (this.applied) {
            PreconditionsKt.throwIllegalStateException("Unsupported operation on a snapshot that has been applied");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0010  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void validateNotAppliedOrPinned() {
        boolean z5;
        int i5;
        if (this.applied) {
            i5 = ((Snapshot) this).pinningTrackingHandle;
            if (i5 < 0) {
                z5 = false;
                if (z5) {
                    PreconditionsKt.throwIllegalStateException("Unsupported operation on a disposed or applied snapshot");
                    return;
                }
                return;
            }
        }
        z5 = true;
        if (z5) {
        }
    }

    public final void advance$runtime_release() {
        int i5;
        SnapshotIdSet snapshotIdSet;
        recordPrevious$runtime_release(getId());
        Unit unit = Unit.INSTANCE;
        if (getApplied() || getDisposed()) {
            return;
        }
        int id = getId();
        synchronized (SnapshotKt.getLock()) {
            i5 = SnapshotKt.nextSnapshotId;
            SnapshotKt.nextSnapshotId = i5 + 1;
            setId$runtime_release(i5);
            snapshotIdSet = SnapshotKt.openSnapshots;
            SnapshotKt.openSnapshots = snapshotIdSet.set(getId());
        }
        setInvalid$runtime_release(SnapshotKt.addRange(getInvalid(), id + 1, getId()));
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00e8 A[LOOP:1: B:32:0x00e6->B:33:0x00e8, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00f8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public SnapshotApplyResult apply() {
        Map<StateRecord, ? extends StateRecord> map;
        AtomicReference atomicReference;
        Function1 function1;
        MutableScatterSet<StateObject> modified$runtime_release;
        int i5;
        int size;
        int i6;
        AtomicReference atomicReference2;
        int i7;
        SnapshotIdSet snapshotIdSet;
        Function1 function12;
        AtomicReference atomicReference3;
        SnapshotIdSet snapshotIdSet2;
        AtomicReference atomicReference4;
        MutableScatterSet<StateObject> modified$runtime_release2 = getModified$runtime_release();
        if (modified$runtime_release2 != null) {
            atomicReference3 = SnapshotKt.currentGlobalSnapshot;
            MutableSnapshot mutableSnapshot = (MutableSnapshot) atomicReference3.get();
            snapshotIdSet2 = SnapshotKt.openSnapshots;
            atomicReference4 = SnapshotKt.currentGlobalSnapshot;
            map = SnapshotKt.optimisticMerges(mutableSnapshot, this, snapshotIdSet2.clear(((GlobalSnapshot) atomicReference4.get()).getId()));
        } else {
            map = null;
        }
        List emptyList = CollectionsKt.emptyList();
        synchronized (SnapshotKt.getLock()) {
            try {
                SnapshotKt.validateOpen(this);
                if (modified$runtime_release2 != null && modified$runtime_release2.get_size() != 0) {
                    atomicReference2 = SnapshotKt.currentGlobalSnapshot;
                    GlobalSnapshot globalSnapshot = (GlobalSnapshot) atomicReference2.get();
                    i7 = SnapshotKt.nextSnapshotId;
                    snapshotIdSet = SnapshotKt.openSnapshots;
                    SnapshotApplyResult innerApplyLocked$runtime_release = innerApplyLocked$runtime_release(i7, map, snapshotIdSet.clear(globalSnapshot.getId()));
                    if (!Intrinsics.areEqual(innerApplyLocked$runtime_release, SnapshotApplyResult.Success.INSTANCE)) {
                        return innerApplyLocked$runtime_release;
                    }
                    closeLocked$runtime_release();
                    function12 = SnapshotKt.emptyLambda;
                    SnapshotKt.takeNewGlobalSnapshot(globalSnapshot, function12);
                    modified$runtime_release = globalSnapshot.getModified$runtime_release();
                    setModified(null);
                    globalSnapshot.setModified(null);
                    emptyList = SnapshotKt.applyObservers;
                    Unit unit = Unit.INSTANCE;
                    this.applied = true;
                    if (modified$runtime_release != null) {
                        Set wrapIntoSet = ScatterSetWrapperKt.wrapIntoSet(modified$runtime_release);
                        if (!wrapIntoSet.isEmpty()) {
                            int size2 = emptyList.size();
                            for (int i8 = 0; i8 < size2; i8++) {
                                ((Function2) emptyList.get(i8)).invoke(wrapIntoSet, this);
                            }
                        }
                    }
                    if (modified$runtime_release2 != null && modified$runtime_release2.isNotEmpty()) {
                        Set wrapIntoSet2 = ScatterSetWrapperKt.wrapIntoSet(modified$runtime_release2);
                        size = emptyList.size();
                        for (i6 = 0; i6 < size; i6++) {
                            ((Function2) emptyList.get(i6)).invoke(wrapIntoSet2, this);
                        }
                    }
                    synchronized (SnapshotKt.getLock()) {
                        try {
                            releasePinnedSnapshotsForCloseLocked$runtime_release();
                            SnapshotKt.checkAndOverwriteUnusedRecordsLocked();
                            if (modified$runtime_release != null) {
                                try {
                                    Object[] objArr = modified$runtime_release.elements;
                                    long[] jArr = modified$runtime_release.metadata;
                                    int length = jArr.length - 2;
                                    if (length >= 0) {
                                        int i9 = 0;
                                        while (true) {
                                            long j5 = jArr[i9];
                                            if ((((~j5) << 7) & j5 & (-9187201950435737472L)) != -9187201950435737472L) {
                                                int i10 = 8 - ((~(i9 - length)) >>> 31);
                                                for (int i11 = 0; i11 < i10; i11++) {
                                                    if ((j5 & 255) < 128) {
                                                        SnapshotKt.processForUnusedRecordsLocked((StateObject) objArr[(i9 << 3) + i11]);
                                                    }
                                                    j5 >>= 8;
                                                }
                                                if (i10 != 8) {
                                                    break;
                                                }
                                            }
                                            if (i9 == length) {
                                                break;
                                            }
                                            i9++;
                                        }
                                    }
                                } catch (Throwable th) {
                                    th = th;
                                    throw th;
                                }
                            }
                            if (modified$runtime_release2 != null) {
                                Object[] objArr2 = modified$runtime_release2.elements;
                                long[] jArr2 = modified$runtime_release2.metadata;
                                int length2 = jArr2.length - 2;
                                if (length2 >= 0) {
                                    int i12 = 0;
                                    while (true) {
                                        long j6 = jArr2[i12];
                                        if ((((~j6) << 7) & j6 & (-9187201950435737472L)) != -9187201950435737472L) {
                                            int i13 = 8 - ((~(i12 - length2)) >>> 31);
                                            for (int i14 = 0; i14 < i13; i14++) {
                                                if ((j6 & 255) < 128) {
                                                    SnapshotKt.processForUnusedRecordsLocked((StateObject) objArr2[(i12 << 3) + i14]);
                                                }
                                                j6 >>= 8;
                                            }
                                            i5 = 1;
                                            if (i13 != 8) {
                                                break;
                                            }
                                        } else {
                                            i5 = 1;
                                        }
                                        if (i12 == length2) {
                                            break;
                                        }
                                        i12 += i5;
                                    }
                                }
                            }
                            List<? extends StateObject> list = this.merged;
                            if (list != null) {
                                int size3 = list.size();
                                for (int i15 = 0; i15 < size3; i15++) {
                                    SnapshotKt.processForUnusedRecordsLocked(list.get(i15));
                                }
                            }
                            this.merged = null;
                            Unit unit2 = Unit.INSTANCE;
                            return SnapshotApplyResult.Success.INSTANCE;
                        } catch (Throwable th2) {
                            th = th2;
                        }
                    }
                }
                closeLocked$runtime_release();
                atomicReference = SnapshotKt.currentGlobalSnapshot;
                GlobalSnapshot globalSnapshot2 = (GlobalSnapshot) atomicReference.get();
                function1 = SnapshotKt.emptyLambda;
                SnapshotKt.takeNewGlobalSnapshot(globalSnapshot2, function1);
                modified$runtime_release = globalSnapshot2.getModified$runtime_release();
                if (modified$runtime_release == null || !modified$runtime_release.isNotEmpty()) {
                    modified$runtime_release = null;
                } else {
                    emptyList = SnapshotKt.applyObservers;
                }
                Unit unit3 = Unit.INSTANCE;
                this.applied = true;
                if (modified$runtime_release != null) {
                }
                if (modified$runtime_release2 != null) {
                    Set wrapIntoSet22 = ScatterSetWrapperKt.wrapIntoSet(modified$runtime_release2);
                    size = emptyList.size();
                    while (i6 < size) {
                    }
                }
                synchronized (SnapshotKt.getLock()) {
                }
            } catch (Throwable th3) {
                throw th3;
            }
        }
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public void closeLocked$runtime_release() {
        SnapshotIdSet snapshotIdSet;
        snapshotIdSet = SnapshotKt.openSnapshots;
        SnapshotKt.openSnapshots = snapshotIdSet.clear(getId()).andNot(this.previousIds);
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public void dispose() {
        if (getDisposed()) {
            return;
        }
        super.dispose();
        mo1246nestedDeactivated$runtime_release(this);
    }

    /* renamed from: getApplied$runtime_release, reason: from getter */
    public final boolean getApplied() {
        return this.applied;
    }

    public MutableScatterSet<StateObject> getModified$runtime_release() {
        return this.modified;
    }

    /* renamed from: getPreviousIds$runtime_release, reason: from getter */
    public final SnapshotIdSet getPreviousIds() {
        return this.previousIds;
    }

    /* renamed from: getPreviousPinnedSnapshots$runtime_release, reason: from getter */
    public final int[] getPreviousPinnedSnapshots() {
        return this.previousPinnedSnapshots;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    /* renamed from: getReadObserver$runtime_release */
    public Function1<Object, Unit> getReadObserver() {
        return this.readObserver;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public boolean getReadOnly() {
        return false;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    /* renamed from: getWriteCount$runtime_release, reason: from getter */
    public int getWriteCount() {
        return this.writeCount;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public Function1<Object, Unit> getWriteObserver$runtime_release() {
        return this.writeObserver;
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0074, code lost:
    
        r5 = androidx.compose.runtime.snapshots.SnapshotKt.readable(r2, getId(), r3);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final SnapshotApplyResult innerApplyLocked$runtime_release(int snapshotId, Map<StateRecord, ? extends StateRecord> optimisticMerges, SnapshotIdSet invalidSnapshots) {
        MutableScatterSet<StateObject> mutableScatterSet;
        List<? extends StateObject> list;
        SnapshotIdSet snapshotIdSet;
        Object[] objArr;
        long[] jArr;
        int i5;
        SnapshotIdSet snapshotIdSet2;
        MutableScatterSet<StateObject> mutableScatterSet2;
        Object[] objArr2;
        long[] jArr2;
        int i6;
        StateRecord readable;
        StateRecord readable2;
        StateRecord readable3;
        StateRecord mergeRecords;
        SnapshotIdSet or = getInvalid().set(getId()).or(this.previousIds);
        MutableScatterSet<StateObject> modified$runtime_release = getModified$runtime_release();
        Intrinsics.checkNotNull(modified$runtime_release);
        Object[] objArr3 = modified$runtime_release.elements;
        long[] jArr3 = modified$runtime_release.metadata;
        int length = jArr3.length - 2;
        ArrayList arrayList = null;
        if (length >= 0) {
            list = null;
            int i7 = 0;
            while (true) {
                long j5 = jArr3[i7];
                if ((((~j5) << 7) & j5 & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i8 = 8;
                    int i9 = 8 - ((~(i7 - length)) >>> 31);
                    int i10 = 0;
                    while (i10 < i9) {
                        if ((j5 & 255) < 128) {
                            StateObject stateObject = (StateObject) objArr3[(i7 << 3) + i10];
                            StateRecord firstStateRecord = stateObject.getFirstStateRecord();
                            mutableScatterSet2 = modified$runtime_release;
                            objArr2 = objArr3;
                            jArr2 = jArr3;
                            readable = SnapshotKt.readable(firstStateRecord, snapshotId, invalidSnapshots);
                            if (readable == null || readable2 == null) {
                                snapshotIdSet2 = or;
                            } else {
                                snapshotIdSet2 = or;
                                if (readable2.getSnapshotId() != 1 && !Intrinsics.areEqual(readable, readable2)) {
                                    readable3 = SnapshotKt.readable(firstStateRecord, getId(), getInvalid());
                                    if (readable3 == null) {
                                        SnapshotKt.readError();
                                        throw new KotlinNothingValueException();
                                    }
                                    if (optimisticMerges == null || (mergeRecords = optimisticMerges.get(readable)) == null) {
                                        mergeRecords = stateObject.mergeRecords(readable2, readable, readable3);
                                    }
                                    if (mergeRecords == null) {
                                        return new SnapshotApplyResult.Failure(this);
                                    }
                                    if (!Intrinsics.areEqual(mergeRecords, readable3)) {
                                        if (Intrinsics.areEqual(mergeRecords, readable)) {
                                            if (arrayList == null) {
                                                arrayList = new ArrayList();
                                            }
                                            arrayList.add(TuplesKt.to(stateObject, readable.create()));
                                            if (list == null) {
                                                list = new ArrayList<>();
                                            }
                                            list.add(stateObject);
                                        } else {
                                            if (arrayList == null) {
                                                arrayList = new ArrayList();
                                            }
                                            arrayList.add(!Intrinsics.areEqual(mergeRecords, readable2) ? TuplesKt.to(stateObject, mergeRecords) : TuplesKt.to(stateObject, readable2.create()));
                                        }
                                    }
                                }
                            }
                            i6 = 8;
                        } else {
                            snapshotIdSet2 = or;
                            mutableScatterSet2 = modified$runtime_release;
                            objArr2 = objArr3;
                            jArr2 = jArr3;
                            i6 = i8;
                        }
                        j5 >>= i6;
                        i10++;
                        i8 = i6;
                        objArr3 = objArr2;
                        jArr3 = jArr2;
                        modified$runtime_release = mutableScatterSet2;
                        or = snapshotIdSet2;
                    }
                    snapshotIdSet = or;
                    mutableScatterSet = modified$runtime_release;
                    objArr = objArr3;
                    jArr = jArr3;
                    i5 = 1;
                    if (i9 != i8) {
                        break;
                    }
                } else {
                    snapshotIdSet = or;
                    mutableScatterSet = modified$runtime_release;
                    objArr = objArr3;
                    jArr = jArr3;
                    i5 = 1;
                }
                if (i7 == length) {
                    break;
                }
                i7 += i5;
                objArr3 = objArr;
                jArr3 = jArr;
                modified$runtime_release = mutableScatterSet;
                or = snapshotIdSet;
            }
        } else {
            mutableScatterSet = modified$runtime_release;
            list = null;
        }
        if (arrayList != null) {
            advance$runtime_release();
            int size = arrayList.size();
            for (int i11 = 0; i11 < size; i11++) {
                Pair pair = (Pair) arrayList.get(i11);
                StateObject stateObject2 = (StateObject) pair.component1();
                StateRecord stateRecord = (StateRecord) pair.component2();
                stateRecord.setSnapshotId$runtime_release(getId());
                synchronized (SnapshotKt.getLock()) {
                    stateRecord.setNext$runtime_release(stateObject2.getFirstStateRecord());
                    stateObject2.prependStateRecord(stateRecord);
                    Unit unit = Unit.INSTANCE;
                }
            }
        }
        if (list != null) {
            int size2 = list.size();
            for (int i12 = 0; i12 < size2; i12++) {
                mutableScatterSet.remove(list.get(i12));
            }
            List<? extends StateObject> list2 = this.merged;
            if (list2 != null) {
                list = CollectionsKt.plus((Collection) list2, (Iterable) list);
            }
            this.merged = list;
        }
        return SnapshotApplyResult.Success.INSTANCE;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    /* renamed from: nestedActivated$runtime_release */
    public void mo1245nestedActivated$runtime_release(Snapshot snapshot) {
        this.snapshots++;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    /* renamed from: nestedDeactivated$runtime_release */
    public void mo1246nestedDeactivated$runtime_release(Snapshot snapshot) {
        if (!(this.snapshots > 0)) {
            PreconditionsKt.throwIllegalArgumentException("no pending nested snapshots");
        }
        int i5 = this.snapshots - 1;
        this.snapshots = i5;
        if (i5 != 0 || this.applied) {
            return;
        }
        abandon();
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public void notifyObjectsInitialized$runtime_release() {
        if (this.applied || getDisposed()) {
            return;
        }
        advance$runtime_release();
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    /* renamed from: recordModified$runtime_release */
    public void mo1247recordModified$runtime_release(StateObject state) {
        MutableScatterSet<StateObject> modified$runtime_release = getModified$runtime_release();
        if (modified$runtime_release == null) {
            modified$runtime_release = ScatterSetKt.mutableScatterSetOf();
            setModified(modified$runtime_release);
        }
        modified$runtime_release.add(state);
    }

    public final void recordPrevious$runtime_release(int id) {
        synchronized (SnapshotKt.getLock()) {
            this.previousIds = this.previousIds.set(id);
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void recordPreviousList$runtime_release(SnapshotIdSet snapshots) {
        synchronized (SnapshotKt.getLock()) {
            this.previousIds = this.previousIds.or(snapshots);
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void recordPreviousPinnedSnapshot$runtime_release(int id) {
        if (id >= 0) {
            this.previousPinnedSnapshots = ArraysKt.plus(this.previousPinnedSnapshots, id);
        }
    }

    public final void recordPreviousPinnedSnapshots$runtime_release(int[] handles) {
        if (handles.length == 0) {
            return;
        }
        int[] iArr = this.previousPinnedSnapshots;
        if (iArr.length != 0) {
            handles = ArraysKt.plus(iArr, handles);
        }
        this.previousPinnedSnapshots = handles;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public void releasePinnedSnapshotsForCloseLocked$runtime_release() {
        releasePreviouslyPinnedSnapshotsLocked();
        super.releasePinnedSnapshotsForCloseLocked$runtime_release();
    }

    public final void setApplied$runtime_release(boolean z5) {
        this.applied = z5;
    }

    public void setModified(MutableScatterSet<StateObject> mutableScatterSet) {
        this.modified = mutableScatterSet;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public void setWriteCount$runtime_release(int i5) {
        this.writeCount = i5;
    }

    public MutableSnapshot takeNestedMutableSnapshot(Function1<Object, Unit> readObserver, Function1<Object, Unit> writeObserver) {
        int i5;
        SnapshotIdSet snapshotIdSet;
        NestedMutableSnapshot nestedMutableSnapshot;
        Function1 mergedWriteObserver;
        int i6;
        SnapshotIdSet snapshotIdSet2;
        validateNotDisposed$runtime_release();
        validateNotAppliedOrPinned();
        recordPrevious$runtime_release(getId());
        synchronized (SnapshotKt.getLock()) {
            i5 = SnapshotKt.nextSnapshotId;
            SnapshotKt.nextSnapshotId = i5 + 1;
            snapshotIdSet = SnapshotKt.openSnapshots;
            SnapshotKt.openSnapshots = snapshotIdSet.set(i5);
            SnapshotIdSet invalid = getInvalid();
            setInvalid$runtime_release(invalid.set(i5));
            SnapshotIdSet addRange = SnapshotKt.addRange(invalid, getId() + 1, i5);
            Function1 mergedReadObserver$default = SnapshotKt.mergedReadObserver$default(readObserver, getReadObserver(), false, 4, null);
            mergedWriteObserver = SnapshotKt.mergedWriteObserver(writeObserver, getWriteObserver$runtime_release());
            nestedMutableSnapshot = new NestedMutableSnapshot(i5, addRange, mergedReadObserver$default, mergedWriteObserver, this);
        }
        if (!getApplied() && !getDisposed()) {
            int id = getId();
            synchronized (SnapshotKt.getLock()) {
                i6 = SnapshotKt.nextSnapshotId;
                SnapshotKt.nextSnapshotId = i6 + 1;
                setId$runtime_release(i6);
                snapshotIdSet2 = SnapshotKt.openSnapshots;
                SnapshotKt.openSnapshots = snapshotIdSet2.set(getId());
                Unit unit = Unit.INSTANCE;
            }
            setInvalid$runtime_release(SnapshotKt.addRange(getInvalid(), id + 1, getId()));
        }
        return nestedMutableSnapshot;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public Snapshot takeNestedSnapshot(Function1<Object, Unit> readObserver) {
        int i5;
        SnapshotIdSet snapshotIdSet;
        NestedReadonlySnapshot nestedReadonlySnapshot;
        int i6;
        SnapshotIdSet snapshotIdSet2;
        validateNotDisposed$runtime_release();
        validateNotAppliedOrPinned();
        int id = getId();
        recordPrevious$runtime_release(getId());
        synchronized (SnapshotKt.getLock()) {
            i5 = SnapshotKt.nextSnapshotId;
            SnapshotKt.nextSnapshotId = i5 + 1;
            snapshotIdSet = SnapshotKt.openSnapshots;
            SnapshotKt.openSnapshots = snapshotIdSet.set(i5);
            nestedReadonlySnapshot = new NestedReadonlySnapshot(i5, SnapshotKt.addRange(getInvalid(), id + 1, i5), SnapshotKt.mergedReadObserver$default(readObserver, getReadObserver(), false, 4, null), this);
        }
        if (!getApplied() && !getDisposed()) {
            int id2 = getId();
            synchronized (SnapshotKt.getLock()) {
                i6 = SnapshotKt.nextSnapshotId;
                SnapshotKt.nextSnapshotId = i6 + 1;
                setId$runtime_release(i6);
                snapshotIdSet2 = SnapshotKt.openSnapshots;
                SnapshotKt.openSnapshots = snapshotIdSet2.set(getId());
                Unit unit = Unit.INSTANCE;
            }
            setInvalid$runtime_release(SnapshotKt.addRange(getInvalid(), id2 + 1, getId()));
        }
        return nestedReadonlySnapshot;
    }
}
