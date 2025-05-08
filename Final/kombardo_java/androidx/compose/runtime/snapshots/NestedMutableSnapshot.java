package androidx.compose.runtime.snapshots;

import androidx.collection.MutableScatterSet;
import androidx.compose.runtime.snapshots.SnapshotApplyResult;
import com.sdk.growthbook.utils.Constants;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001BK\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0014\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0006\u0012\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0006\u0012\u0006\u0010\u000b\u001a\u00020\u0001¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0010\u0010\u000fJ\u000f\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0012\u0010\u0013R\u0017\u0010\u000b\u001a\u00020\u00018\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0018\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, d2 = {"Landroidx/compose/runtime/snapshots/NestedMutableSnapshot;", "Landroidx/compose/runtime/snapshots/MutableSnapshot;", BuildConfig.FLAVOR, Constants.ID_ATTRIBUTE_KEY, "Landroidx/compose/runtime/snapshots/SnapshotIdSet;", "invalid", "Lkotlin/Function1;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "readObserver", "writeObserver", "parent", "<init>", "(ILandroidx/compose/runtime/snapshots/SnapshotIdSet;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/snapshots/MutableSnapshot;)V", "deactivate", "()V", "dispose", "Landroidx/compose/runtime/snapshots/SnapshotApplyResult;", "apply", "()Landroidx/compose/runtime/snapshots/SnapshotApplyResult;", "Landroidx/compose/runtime/snapshots/MutableSnapshot;", "getParent", "()Landroidx/compose/runtime/snapshots/MutableSnapshot;", BuildConfig.FLAVOR, "deactivated", "Z", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class NestedMutableSnapshot extends MutableSnapshot {
    private boolean deactivated;
    private final MutableSnapshot parent;

    public NestedMutableSnapshot(int i5, SnapshotIdSet snapshotIdSet, Function1<Object, Unit> function1, Function1<Object, Unit> function12, MutableSnapshot mutableSnapshot) {
        super(i5, snapshotIdSet, function1, function12);
        this.parent = mutableSnapshot;
        mutableSnapshot.mo1245nestedActivated$runtime_release(this);
    }

    private final void deactivate() {
        if (this.deactivated) {
            return;
        }
        this.deactivated = true;
        this.parent.mo1246nestedDeactivated$runtime_release(this);
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0076 A[Catch: all -> 0x0060, TryCatch #0 {all -> 0x0060, blocks: (B:11:0x002e, B:13:0x0033, B:16:0x003a, B:21:0x0054, B:23:0x005c, B:24:0x006e, B:26:0x0076, B:27:0x007b, B:32:0x0062, B:33:0x006b), top: B:10:0x002e }] */
    @Override // androidx.compose.runtime.snapshots.MutableSnapshot
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public SnapshotApplyResult apply() {
        Map<StateRecord, ? extends StateRecord> map;
        if (this.parent.getApplied() || this.parent.getDisposed()) {
            return new SnapshotApplyResult.Failure(this);
        }
        MutableScatterSet<StateObject> modified$runtime_release = getModified$runtime_release();
        int id = getId();
        if (modified$runtime_release != null) {
            MutableSnapshot mutableSnapshot = this.parent;
            map = SnapshotKt.optimisticMerges(mutableSnapshot, this, mutableSnapshot.getInvalid());
        } else {
            map = null;
        }
        synchronized (SnapshotKt.getLock()) {
            try {
                SnapshotKt.validateOpen(this);
                if (modified$runtime_release != null && modified$runtime_release.get_size() != 0) {
                    SnapshotApplyResult innerApplyLocked$runtime_release = innerApplyLocked$runtime_release(this.parent.getId(), map, this.parent.getInvalid());
                    if (!Intrinsics.areEqual(innerApplyLocked$runtime_release, SnapshotApplyResult.Success.INSTANCE)) {
                        return innerApplyLocked$runtime_release;
                    }
                    MutableScatterSet<StateObject> modified$runtime_release2 = this.parent.getModified$runtime_release();
                    if (modified$runtime_release2 != null) {
                        modified$runtime_release2.addAll(modified$runtime_release);
                    } else {
                        this.parent.setModified(modified$runtime_release);
                        setModified(null);
                    }
                    if (this.parent.getId() < id) {
                        this.parent.advance$runtime_release();
                    }
                    MutableSnapshot mutableSnapshot2 = this.parent;
                    mutableSnapshot2.setInvalid$runtime_release(mutableSnapshot2.getInvalid().clear(id).andNot(getPreviousIds()));
                    this.parent.recordPrevious$runtime_release(id);
                    this.parent.recordPreviousPinnedSnapshot$runtime_release(takeoverPinnedSnapshot$runtime_release());
                    this.parent.recordPreviousList$runtime_release(getPreviousIds());
                    this.parent.recordPreviousPinnedSnapshots$runtime_release(getPreviousPinnedSnapshots());
                    Unit unit = Unit.INSTANCE;
                    setApplied$runtime_release(true);
                    deactivate();
                    return SnapshotApplyResult.Success.INSTANCE;
                }
                closeAndReleasePinning$runtime_release();
                if (this.parent.getId() < id) {
                }
                MutableSnapshot mutableSnapshot22 = this.parent;
                mutableSnapshot22.setInvalid$runtime_release(mutableSnapshot22.getInvalid().clear(id).andNot(getPreviousIds()));
                this.parent.recordPrevious$runtime_release(id);
                this.parent.recordPreviousPinnedSnapshot$runtime_release(takeoverPinnedSnapshot$runtime_release());
                this.parent.recordPreviousList$runtime_release(getPreviousIds());
                this.parent.recordPreviousPinnedSnapshots$runtime_release(getPreviousPinnedSnapshots());
                Unit unit2 = Unit.INSTANCE;
                setApplied$runtime_release(true);
                deactivate();
                return SnapshotApplyResult.Success.INSTANCE;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // androidx.compose.runtime.snapshots.MutableSnapshot, androidx.compose.runtime.snapshots.Snapshot
    public void dispose() {
        if (getDisposed()) {
            return;
        }
        super.dispose();
        deactivate();
    }
}
