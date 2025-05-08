package androidx.compose.runtime;

import androidx.compose.runtime.tooling.CompositionGroup;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010(\n\u0002\b\u000e\n\u0002\u0010\u0000\n\u0002\b\t\b\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00010\u0002B'\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\u0016\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00010\rH\u0096\u0002¢\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\n\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\n\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001d\u001a\u00020\u001c8\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R \u0010!\u001a\b\u0012\u0004\u0012\u00020\u00010\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$¨\u0006%"}, d2 = {"Landroidx/compose/runtime/SourceInformationSlotTableGroup;", "Landroidx/compose/runtime/tooling/CompositionGroup;", BuildConfig.FLAVOR, "Landroidx/compose/runtime/SlotTable;", "table", BuildConfig.FLAVOR, "parent", "Landroidx/compose/runtime/GroupSourceInformation;", "sourceInformation", "Landroidx/compose/runtime/SourceInformationGroupPath;", "identityPath", "<init>", "(Landroidx/compose/runtime/SlotTable;ILandroidx/compose/runtime/GroupSourceInformation;Landroidx/compose/runtime/SourceInformationGroupPath;)V", BuildConfig.FLAVOR, "iterator", "()Ljava/util/Iterator;", "Landroidx/compose/runtime/SlotTable;", "getTable", "()Landroidx/compose/runtime/SlotTable;", "I", "getParent", "()I", "Landroidx/compose/runtime/GroupSourceInformation;", "getSourceInformation", "()Landroidx/compose/runtime/GroupSourceInformation;", "Landroidx/compose/runtime/SourceInformationGroupPath;", "getIdentityPath", "()Landroidx/compose/runtime/SourceInformationGroupPath;", BuildConfig.FLAVOR, "key", "Ljava/lang/Object;", "getKey", "()Ljava/lang/Object;", "compositionGroups", "Ljava/lang/Iterable;", "getCompositionGroups", "()Ljava/lang/Iterable;", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
final class SourceInformationSlotTableGroup implements CompositionGroup, Iterable<CompositionGroup>, KMappedMarker {
    private final Iterable<CompositionGroup> compositionGroups = this;
    private final SourceInformationGroupPath identityPath;
    private final Object key;
    private final int parent;
    private final GroupSourceInformation sourceInformation;
    private final SlotTable table;

    public SourceInformationSlotTableGroup(SlotTable slotTable, int i5, GroupSourceInformation groupSourceInformation, SourceInformationGroupPath sourceInformationGroupPath) {
        this.table = slotTable;
        this.parent = i5;
        this.identityPath = sourceInformationGroupPath;
        this.key = Integer.valueOf(groupSourceInformation.getKey());
    }

    @Override // java.lang.Iterable
    public Iterator<CompositionGroup> iterator() {
        return new SourceInformationGroupIterator(this.table, this.parent, this.sourceInformation, this.identityPath);
    }
}
