package androidx.compose.runtime.snapshots;

import com.sdk.growthbook.utils.Constants;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0001\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0014\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0006\u0012\u0006\u0010\n\u001a\u00020\u0001¢\u0006\u0004\b\u000b\u0010\fJ%\u0010\r\u001a\u00020\u00002\u0014\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0011\u001a\u00020\bH\u0010¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0012\u0010\u0010J\u0017\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u0013H\u0010¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u0001H\u0010¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001e\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u0001H\u0010¢\u0006\u0004\b\u001d\u0010\u001bR(\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u00068\u0010X\u0090\u0004¢\u0006\f\n\u0004\b\t\u0010\u001f\u001a\u0004\b \u0010!R\u0017\u0010\n\u001a\u00020\u00018\u0006¢\u0006\f\n\u0004\b\n\u0010\"\u001a\u0004\b#\u0010$R\u0014\u0010(\u001a\u00020%8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b&\u0010'R\"\u0010*\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u00068PX\u0090\u0004¢\u0006\u0006\u001a\u0004\b)\u0010!¨\u0006+"}, d2 = {"Landroidx/compose/runtime/snapshots/NestedReadonlySnapshot;", "Landroidx/compose/runtime/snapshots/Snapshot;", BuildConfig.FLAVOR, Constants.ID_ATTRIBUTE_KEY, "Landroidx/compose/runtime/snapshots/SnapshotIdSet;", "invalid", "Lkotlin/Function1;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "readObserver", "parent", "<init>", "(ILandroidx/compose/runtime/snapshots/SnapshotIdSet;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/snapshots/Snapshot;)V", "takeNestedSnapshot", "(Lkotlin/jvm/functions/Function1;)Landroidx/compose/runtime/snapshots/NestedReadonlySnapshot;", "notifyObjectsInitialized$runtime_release", "()V", "notifyObjectsInitialized", "dispose", "Landroidx/compose/runtime/snapshots/StateObject;", "state", BuildConfig.FLAVOR, "recordModified$runtime_release", "(Landroidx/compose/runtime/snapshots/StateObject;)Ljava/lang/Void;", "recordModified", "snapshot", "nestedDeactivated$runtime_release", "(Landroidx/compose/runtime/snapshots/Snapshot;)Ljava/lang/Void;", "nestedDeactivated", "nestedActivated$runtime_release", "nestedActivated", "Lkotlin/jvm/functions/Function1;", "getReadObserver$runtime_release", "()Lkotlin/jvm/functions/Function1;", "Landroidx/compose/runtime/snapshots/Snapshot;", "getParent", "()Landroidx/compose/runtime/snapshots/Snapshot;", BuildConfig.FLAVOR, "getReadOnly", "()Z", "readOnly", "getWriteObserver$runtime_release", "writeObserver", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class NestedReadonlySnapshot extends Snapshot {
    private final Snapshot parent;
    private final Function1<Object, Unit> readObserver;

    public NestedReadonlySnapshot(int i5, SnapshotIdSet snapshotIdSet, Function1<Object, Unit> function1, Snapshot snapshot) {
        super(i5, snapshotIdSet, null);
        this.readObserver = function1;
        this.parent = snapshot;
        snapshot.mo1245nestedActivated$runtime_release(this);
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public void dispose() {
        if (getDisposed()) {
            return;
        }
        if (getId() != this.parent.getId()) {
            closeAndReleasePinning$runtime_release();
        }
        this.parent.mo1246nestedDeactivated$runtime_release(this);
        super.dispose();
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    /* renamed from: getReadObserver$runtime_release, reason: merged with bridge method [inline-methods] */
    public Function1<Object, Unit> getReadObserver() {
        return this.readObserver;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public boolean getReadOnly() {
        return true;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public Function1<Object, Unit> getWriteObserver$runtime_release() {
        return null;
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public void notifyObjectsInitialized$runtime_release() {
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public /* bridge */ /* synthetic */ Snapshot takeNestedSnapshot(Function1 function1) {
        return takeNestedSnapshot((Function1<Object, Unit>) function1);
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    /* renamed from: nestedActivated$runtime_release, reason: merged with bridge method [inline-methods] */
    public Void mo1245nestedActivated$runtime_release(Snapshot snapshot) {
        SnapshotStateMapKt.unsupported();
        throw new KotlinNothingValueException();
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    /* renamed from: nestedDeactivated$runtime_release, reason: merged with bridge method [inline-methods] */
    public Void mo1246nestedDeactivated$runtime_release(Snapshot snapshot) {
        SnapshotStateMapKt.unsupported();
        throw new KotlinNothingValueException();
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    /* renamed from: recordModified$runtime_release, reason: merged with bridge method [inline-methods] */
    public Void mo1247recordModified$runtime_release(StateObject state) {
        SnapshotKt.reportReadonlySnapshotWrite();
        throw new KotlinNothingValueException();
    }

    @Override // androidx.compose.runtime.snapshots.Snapshot
    public NestedReadonlySnapshot takeNestedSnapshot(Function1<Object, Unit> readObserver) {
        return new NestedReadonlySnapshot(getId(), getInvalid(), SnapshotKt.mergedReadObserver$default(readObserver, getReadObserver(), false, 4, null), this.parent);
    }
}
