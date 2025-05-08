package androidx.compose.runtime.snapshots;

import androidx.collection.MutableScatterSet;
import androidx.compose.runtime.ActualJvm_jvmKt;
import androidx.compose.runtime.PreconditionsKt;
import androidx.compose.runtime.snapshots.Snapshot;
import com.sdk.growthbook.utils.Constants;
import java.util.Collection;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u0000 J2\u00020\u0001:\u0001JB\u0019\b\u0004\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nJ'\u0010\r\u001a\u00020\u00002\u0016\b\u0002\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\b\u0018\u00010\u000bH&¢\u0006\u0004\b\r\u0010\u000eJ\u0011\u0010\u000f\u001a\u0004\u0018\u00010\u0000H\u0011¢\u0006\u0004\b\u000f\u0010\u0010J\u0019\u0010\u0012\u001a\u00020\b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0000H\u0011¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0000H ¢\u0006\u0004\b\u0014\u0010\u0013J\u0017\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0000H ¢\u0006\u0004\b\u0016\u0010\u0013J\u0017\u0010\u001c\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u0018H ¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001e\u001a\u00020\bH ¢\u0006\u0004\b\u001d\u0010\nJ\u000f\u0010 \u001a\u00020\bH\u0000¢\u0006\u0004\b\u001f\u0010\nJ\u000f\u0010\"\u001a\u00020\bH\u0010¢\u0006\u0004\b!\u0010\nJ\u000f\u0010$\u001a\u00020\bH\u0010¢\u0006\u0004\b#\u0010\nJ\u000f\u0010&\u001a\u00020\bH\u0000¢\u0006\u0004\b%\u0010\nJ\u000f\u0010(\u001a\u00020\bH\u0000¢\u0006\u0004\b'\u0010\nJ\u000f\u0010+\u001a\u00020\u0002H\u0000¢\u0006\u0004\b)\u0010*R\"\u0010\u0005\u001a\u00020\u00048\u0010@\u0010X\u0090\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R*\u0010\u0003\u001a\u00020\u00022\u0006\u00101\u001a\u00020\u00028\u0016@PX\u0096\u000e¢\u0006\u0012\n\u0004\b\u0003\u00102\u001a\u0004\b3\u0010*\"\u0004\b4\u00105R\"\u00107\u001a\u0002068\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b7\u00108\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\u001c\u0010=\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\f\n\u0004\b=\u00102\u0012\u0004\b>\u0010\nR$\u0010B\u001a\u00020\u00022\u0006\u0010?\u001a\u00020\u00028P@PX\u0090\u000e¢\u0006\f\u001a\u0004\b@\u0010*\"\u0004\bA\u00105R\u0014\u0010D\u001a\u0002068&X¦\u0004¢\u0006\u0006\u001a\u0004\bC\u0010:R(\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\b\u0018\u00010\u000b8 X¡\u0004¢\u0006\f\u0012\u0004\bG\u0010\n\u001a\u0004\bE\u0010FR\"\u0010I\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\b\u0018\u00010\u000b8 X \u0004¢\u0006\u0006\u001a\u0004\bH\u0010F\u0082\u0001\u0004KLMN¨\u0006O"}, d2 = {"Landroidx/compose/runtime/snapshots/Snapshot;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, Constants.ID_ATTRIBUTE_KEY, "Landroidx/compose/runtime/snapshots/SnapshotIdSet;", "invalid", "<init>", "(ILandroidx/compose/runtime/snapshots/SnapshotIdSet;)V", BuildConfig.FLAVOR, "dispose", "()V", "Lkotlin/Function1;", "readObserver", "takeNestedSnapshot", "(Lkotlin/jvm/functions/Function1;)Landroidx/compose/runtime/snapshots/Snapshot;", "makeCurrent", "()Landroidx/compose/runtime/snapshots/Snapshot;", "snapshot", "restoreCurrent", "(Landroidx/compose/runtime/snapshots/Snapshot;)V", "nestedActivated$runtime_release", "nestedActivated", "nestedDeactivated$runtime_release", "nestedDeactivated", "Landroidx/compose/runtime/snapshots/StateObject;", "state", "recordModified$runtime_release", "(Landroidx/compose/runtime/snapshots/StateObject;)V", "recordModified", "notifyObjectsInitialized$runtime_release", "notifyObjectsInitialized", "closeAndReleasePinning$runtime_release", "closeAndReleasePinning", "closeLocked$runtime_release", "closeLocked", "releasePinnedSnapshotsForCloseLocked$runtime_release", "releasePinnedSnapshotsForCloseLocked", "validateNotDisposed$runtime_release", "validateNotDisposed", "releasePinnedSnapshotLocked$runtime_release", "releasePinnedSnapshotLocked", "takeoverPinnedSnapshot$runtime_release", "()I", "takeoverPinnedSnapshot", "Landroidx/compose/runtime/snapshots/SnapshotIdSet;", "getInvalid$runtime_release", "()Landroidx/compose/runtime/snapshots/SnapshotIdSet;", "setInvalid$runtime_release", "(Landroidx/compose/runtime/snapshots/SnapshotIdSet;)V", "<set-?>", "I", "getId", "setId$runtime_release", "(I)V", BuildConfig.FLAVOR, "disposed", "Z", "getDisposed$runtime_release", "()Z", "setDisposed$runtime_release", "(Z)V", "pinningTrackingHandle", "getPinningTrackingHandle$annotations", "value", "getWriteCount$runtime_release", "setWriteCount$runtime_release", "writeCount", "getReadOnly", "readOnly", "getReadObserver", "()Lkotlin/jvm/functions/Function1;", "getReadObserver$annotations", "getWriteObserver$runtime_release", "writeObserver", "Companion", "Landroidx/compose/runtime/snapshots/MutableSnapshot;", "Landroidx/compose/runtime/snapshots/NestedReadonlySnapshot;", "Landroidx/compose/runtime/snapshots/ReadonlySnapshot;", "Landroidx/compose/runtime/snapshots/TransparentObserverSnapshot;", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class Snapshot {
    private boolean disposed;
    private int id;
    private SnapshotIdSet invalid;
    private int pinningTrackingHandle;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J%\u0010\b\u001a\u00020\u00072\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004¢\u0006\u0004\b\b\u0010\tJ=\u0010\f\u001a\u00020\u000b2\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u0016\b\u0002\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004¢\u0006\u0004\b\f\u0010\rJQ\u0010\u0011\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u000e2\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u0016\b\u0002\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\u0019\u0010\u0014\u001a\u00020\u00072\b\u0010\u0013\u001a\u0004\u0018\u00010\u0007H\u0001¢\u0006\u0004\b\u0014\u0010\u0015J7\u0010\u0018\u001a\u00020\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0016\u001a\u00020\u00072\u0014\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004H\u0001¢\u0006\u0004\b\u0018\u0010\u0019J-\u0010\u001d\u001a\u00020\u001c2\u001e\u0010\u0017\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u001b\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00050\u001a¢\u0006\u0004\b\u001d\u0010\u001eJ!\u0010\u001f\u001a\u00020\u001c2\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u001f\u0010 J\r\u0010!\u001a\u00020\u0005¢\u0006\u0004\b!\u0010\u0003J\r\u0010\"\u001a\u00020\u0005¢\u0006\u0004\b\"\u0010\u0003R\u0011\u0010%\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b#\u0010$R\u0011\u0010'\u001a\u00020&8F¢\u0006\u0006\u001a\u0004\b'\u0010(R\u001c\u0010+\u001a\u0004\u0018\u00010\u00078@X\u0081\u0004¢\u0006\f\u0012\u0004\b*\u0010\u0003\u001a\u0004\b)\u0010$¨\u0006,"}, d2 = {"Landroidx/compose/runtime/snapshots/Snapshot$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "Lkotlin/Function1;", BuildConfig.FLAVOR, "readObserver", "Landroidx/compose/runtime/snapshots/Snapshot;", "takeSnapshot", "(Lkotlin/jvm/functions/Function1;)Landroidx/compose/runtime/snapshots/Snapshot;", "writeObserver", "Landroidx/compose/runtime/snapshots/MutableSnapshot;", "takeMutableSnapshot", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Landroidx/compose/runtime/snapshots/MutableSnapshot;", "T", "Lkotlin/Function0;", "block", "observe", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "previous", "makeCurrentNonObservable", "(Landroidx/compose/runtime/snapshots/Snapshot;)Landroidx/compose/runtime/snapshots/Snapshot;", "nonObservable", "observer", "restoreNonObservable", "(Landroidx/compose/runtime/snapshots/Snapshot;Landroidx/compose/runtime/snapshots/Snapshot;Lkotlin/jvm/functions/Function1;)V", "Lkotlin/Function2;", BuildConfig.FLAVOR, "Landroidx/compose/runtime/snapshots/ObserverHandle;", "registerApplyObserver", "(Lkotlin/jvm/functions/Function2;)Landroidx/compose/runtime/snapshots/ObserverHandle;", "registerGlobalWriteObserver", "(Lkotlin/jvm/functions/Function1;)Landroidx/compose/runtime/snapshots/ObserverHandle;", "notifyObjectsInitialized", "sendApplyNotifications", "getCurrent", "()Landroidx/compose/runtime/snapshots/Snapshot;", "current", BuildConfig.FLAVOR, "isInSnapshot", "()Z", "getCurrentThreadSnapshot", "getCurrentThreadSnapshot$annotations", "currentThreadSnapshot", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void registerApplyObserver$lambda$6(Function2 function2) {
            synchronized (SnapshotKt.getLock()) {
                SnapshotKt.access$setApplyObservers$p(CollectionsKt.minus(SnapshotKt.access$getApplyObservers$p(), function2));
                Unit unit = Unit.INSTANCE;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void registerGlobalWriteObserver$lambda$9(Function1 function1) {
            synchronized (SnapshotKt.getLock()) {
                SnapshotKt.access$setGlobalWriteObservers$p(CollectionsKt.minus(SnapshotKt.access$getGlobalWriteObservers$p(), function1));
                Unit unit = Unit.INSTANCE;
            }
            SnapshotKt.access$advanceGlobalSnapshot();
        }

        public final Snapshot getCurrent() {
            return SnapshotKt.currentSnapshot();
        }

        public final Snapshot getCurrentThreadSnapshot() {
            return (Snapshot) SnapshotKt.access$getThreadSnapshot$p().get();
        }

        public final boolean isInSnapshot() {
            return SnapshotKt.access$getThreadSnapshot$p().get() != null;
        }

        public final Snapshot makeCurrentNonObservable(Snapshot previous) {
            if (previous instanceof TransparentObserverMutableSnapshot) {
                TransparentObserverMutableSnapshot transparentObserverMutableSnapshot = (TransparentObserverMutableSnapshot) previous;
                if (transparentObserverMutableSnapshot.getThreadId() == ActualJvm_jvmKt.currentThreadId()) {
                    transparentObserverMutableSnapshot.setReadObserver(null);
                    return previous;
                }
            }
            if (previous instanceof TransparentObserverSnapshot) {
                TransparentObserverSnapshot transparentObserverSnapshot = (TransparentObserverSnapshot) previous;
                if (transparentObserverSnapshot.getThreadId$runtime_release() == ActualJvm_jvmKt.currentThreadId()) {
                    transparentObserverSnapshot.setReadObserver(null);
                    return previous;
                }
            }
            Snapshot createTransparentSnapshotWithNoParentReadObserver$default = SnapshotKt.createTransparentSnapshotWithNoParentReadObserver$default(previous, null, false, 6, null);
            createTransparentSnapshotWithNoParentReadObserver$default.makeCurrent();
            return createTransparentSnapshotWithNoParentReadObserver$default;
        }

        public final void notifyObjectsInitialized() {
            SnapshotKt.currentSnapshot().notifyObjectsInitialized$runtime_release();
        }

        public final <T> T observe(Function1<Object, Unit> readObserver, Function1<Object, Unit> writeObserver, Function0<? extends T> block) {
            Snapshot transparentObserverMutableSnapshot;
            if (readObserver == null && writeObserver == null) {
                return block.invoke();
            }
            Snapshot snapshot = (Snapshot) SnapshotKt.access$getThreadSnapshot$p().get();
            if (snapshot instanceof TransparentObserverMutableSnapshot) {
                TransparentObserverMutableSnapshot transparentObserverMutableSnapshot2 = (TransparentObserverMutableSnapshot) snapshot;
                if (transparentObserverMutableSnapshot2.getThreadId() == ActualJvm_jvmKt.currentThreadId()) {
                    Function1<Object, Unit> readObserver2 = transparentObserverMutableSnapshot2.getReadObserver();
                    Function1<Object, Unit> writeObserver$runtime_release = transparentObserverMutableSnapshot2.getWriteObserver$runtime_release();
                    try {
                        ((TransparentObserverMutableSnapshot) snapshot).setReadObserver(SnapshotKt.mergedReadObserver$default(readObserver, readObserver2, false, 4, null));
                        ((TransparentObserverMutableSnapshot) snapshot).setWriteObserver(SnapshotKt.access$mergedWriteObserver(writeObserver, writeObserver$runtime_release));
                        return block.invoke();
                    } finally {
                        transparentObserverMutableSnapshot2.setReadObserver(readObserver2);
                        transparentObserverMutableSnapshot2.setWriteObserver(writeObserver$runtime_release);
                    }
                }
            }
            if (snapshot == null || (snapshot instanceof MutableSnapshot)) {
                transparentObserverMutableSnapshot = new TransparentObserverMutableSnapshot(snapshot instanceof MutableSnapshot ? (MutableSnapshot) snapshot : null, readObserver, writeObserver, true, false);
            } else {
                if (readObserver == null) {
                    return block.invoke();
                }
                transparentObserverMutableSnapshot = snapshot.takeNestedSnapshot(readObserver);
            }
            try {
                Snapshot makeCurrent = transparentObserverMutableSnapshot.makeCurrent();
                try {
                    return block.invoke();
                } finally {
                    transparentObserverMutableSnapshot.restoreCurrent(makeCurrent);
                }
            } finally {
                transparentObserverMutableSnapshot.dispose();
            }
        }

        public final ObserverHandle registerApplyObserver(final Function2<? super Set<? extends Object>, ? super Snapshot, Unit> observer) {
            SnapshotKt.access$advanceGlobalSnapshot(SnapshotKt.access$getEmptyLambda$p());
            synchronized (SnapshotKt.getLock()) {
                SnapshotKt.access$setApplyObservers$p(CollectionsKt.plus((Collection<? extends Function2<? super Set<? extends Object>, ? super Snapshot, Unit>>) SnapshotKt.access$getApplyObservers$p(), observer));
                Unit unit = Unit.INSTANCE;
            }
            return new ObserverHandle() { // from class: k.a
                @Override // androidx.compose.runtime.snapshots.ObserverHandle
                public final void dispose() {
                    Snapshot.Companion.registerApplyObserver$lambda$6(Function2.this);
                }
            };
        }

        public final ObserverHandle registerGlobalWriteObserver(final Function1<Object, Unit> observer) {
            synchronized (SnapshotKt.getLock()) {
                SnapshotKt.access$setGlobalWriteObservers$p(CollectionsKt.plus((Collection<? extends Function1<Object, Unit>>) SnapshotKt.access$getGlobalWriteObservers$p(), observer));
                Unit unit = Unit.INSTANCE;
            }
            SnapshotKt.access$advanceGlobalSnapshot();
            return new ObserverHandle() { // from class: k.b
                @Override // androidx.compose.runtime.snapshots.ObserverHandle
                public final void dispose() {
                    Snapshot.Companion.registerGlobalWriteObserver$lambda$9(Function1.this);
                }
            };
        }

        public final void restoreNonObservable(Snapshot previous, Snapshot nonObservable, Function1<Object, Unit> observer) {
            if (previous != nonObservable) {
                nonObservable.restoreCurrent(previous);
                nonObservable.dispose();
            } else if (previous instanceof TransparentObserverMutableSnapshot) {
                ((TransparentObserverMutableSnapshot) previous).setReadObserver(observer);
            } else {
                if (previous instanceof TransparentObserverSnapshot) {
                    ((TransparentObserverSnapshot) previous).setReadObserver(observer);
                    return;
                }
                throw new IllegalStateException(("Non-transparent snapshot was reused: " + previous).toString());
            }
        }

        public final void sendApplyNotifications() {
            boolean z5;
            synchronized (SnapshotKt.getLock()) {
                MutableScatterSet<StateObject> modified$runtime_release = ((GlobalSnapshot) SnapshotKt.access$getCurrentGlobalSnapshot$p().get()).getModified$runtime_release();
                z5 = false;
                if (modified$runtime_release != null) {
                    if (modified$runtime_release.isNotEmpty()) {
                        z5 = true;
                    }
                }
            }
            if (z5) {
                SnapshotKt.access$advanceGlobalSnapshot();
            }
        }

        public final MutableSnapshot takeMutableSnapshot(Function1<Object, Unit> readObserver, Function1<Object, Unit> writeObserver) {
            MutableSnapshot takeNestedMutableSnapshot;
            Snapshot currentSnapshot = SnapshotKt.currentSnapshot();
            MutableSnapshot mutableSnapshot = currentSnapshot instanceof MutableSnapshot ? (MutableSnapshot) currentSnapshot : null;
            if (mutableSnapshot == null || (takeNestedMutableSnapshot = mutableSnapshot.takeNestedMutableSnapshot(readObserver, writeObserver)) == null) {
                throw new IllegalStateException("Cannot create a mutable snapshot of an read-only snapshot");
            }
            return takeNestedMutableSnapshot;
        }

        public final Snapshot takeSnapshot(Function1<Object, Unit> readObserver) {
            return SnapshotKt.currentSnapshot().takeNestedSnapshot(readObserver);
        }

        private Companion() {
        }
    }

    public /* synthetic */ Snapshot(int i5, SnapshotIdSet snapshotIdSet, DefaultConstructorMarker defaultConstructorMarker) {
        this(i5, snapshotIdSet);
    }

    public final void closeAndReleasePinning$runtime_release() {
        synchronized (SnapshotKt.getLock()) {
            closeLocked$runtime_release();
            releasePinnedSnapshotsForCloseLocked$runtime_release();
            Unit unit = Unit.INSTANCE;
        }
    }

    public void closeLocked$runtime_release() {
        SnapshotKt.access$setOpenSnapshots$p(SnapshotKt.access$getOpenSnapshots$p().clear(getId()));
    }

    public void dispose() {
        this.disposed = true;
        synchronized (SnapshotKt.getLock()) {
            releasePinnedSnapshotLocked$runtime_release();
            Unit unit = Unit.INSTANCE;
        }
    }

    /* renamed from: getDisposed$runtime_release, reason: from getter */
    public final boolean getDisposed() {
        return this.disposed;
    }

    public int getId() {
        return this.id;
    }

    /* renamed from: getInvalid$runtime_release, reason: from getter */
    public SnapshotIdSet getInvalid() {
        return this.invalid;
    }

    public abstract Function1<Object, Unit> getReadObserver();

    public abstract boolean getReadOnly();

    public int getWriteCount$runtime_release() {
        return 0;
    }

    public abstract Function1<Object, Unit> getWriteObserver$runtime_release();

    public Snapshot makeCurrent() {
        Snapshot snapshot = (Snapshot) SnapshotKt.access$getThreadSnapshot$p().get();
        SnapshotKt.access$getThreadSnapshot$p().set(this);
        return snapshot;
    }

    /* renamed from: nestedActivated$runtime_release */
    public abstract void mo1245nestedActivated$runtime_release(Snapshot snapshot);

    /* renamed from: nestedDeactivated$runtime_release */
    public abstract void mo1246nestedDeactivated$runtime_release(Snapshot snapshot);

    public abstract void notifyObjectsInitialized$runtime_release();

    /* renamed from: recordModified$runtime_release */
    public abstract void mo1247recordModified$runtime_release(StateObject state);

    public final void releasePinnedSnapshotLocked$runtime_release() {
        int i5 = this.pinningTrackingHandle;
        if (i5 >= 0) {
            SnapshotKt.releasePinningLocked(i5);
            this.pinningTrackingHandle = -1;
        }
    }

    public void releasePinnedSnapshotsForCloseLocked$runtime_release() {
        releasePinnedSnapshotLocked$runtime_release();
    }

    public void restoreCurrent(Snapshot snapshot) {
        SnapshotKt.access$getThreadSnapshot$p().set(snapshot);
    }

    public final void setDisposed$runtime_release(boolean z5) {
        this.disposed = z5;
    }

    public void setId$runtime_release(int i5) {
        this.id = i5;
    }

    public void setInvalid$runtime_release(SnapshotIdSet snapshotIdSet) {
        this.invalid = snapshotIdSet;
    }

    public void setWriteCount$runtime_release(int i5) {
        throw new IllegalStateException("Updating write count is not supported for this snapshot");
    }

    public abstract Snapshot takeNestedSnapshot(Function1<Object, Unit> readObserver);

    public final int takeoverPinnedSnapshot$runtime_release() {
        int i5 = this.pinningTrackingHandle;
        this.pinningTrackingHandle = -1;
        return i5;
    }

    public final void validateNotDisposed$runtime_release() {
        if (this.disposed) {
            PreconditionsKt.throwIllegalArgumentException("Cannot use a disposed snapshot");
        }
    }

    private Snapshot(int i5, SnapshotIdSet snapshotIdSet) {
        this.invalid = snapshotIdSet;
        this.id = i5;
        this.pinningTrackingHandle = i5 != 0 ? SnapshotKt.trackPinning(i5, getInvalid()) : -1;
    }
}
