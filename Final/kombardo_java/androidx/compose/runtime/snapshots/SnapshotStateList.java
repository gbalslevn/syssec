package androidx.compose.runtime.snapshots;

import androidx.compose.runtime.PreconditionsKt;
import androidx.compose.runtime.external.kotlinx.collections.immutable.ExtensionsKt;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableList;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u001e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010)\n\u0002\b\u0003\n\u0002\u0010+\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u00022\b\u0012\u0004\u0012\u00028\u00000\u00032\u00060\u0004j\u0002`\u0005:\u0001QB\u0007¢\u0006\u0004\b\u0006\u0010\u0007J)\u0010\u000b\u001a\u00020\t2\u0018\u0010\n\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0004\u0012\u00020\t0\bH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0018\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u001d\u0010\u0017\u001a\u00020\t2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u0015H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0018\u0010\u001b\u001a\u00028\u00002\u0006\u0010\u001a\u001a\u00020\u0019H\u0096\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001d\u001a\u00020\u00192\u0006\u0010\u0012\u001a\u00028\u0000H\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\tH\u0016¢\u0006\u0004\b\u001f\u0010 J\u0016\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000!H\u0096\u0002¢\u0006\u0004\b\"\u0010#J\u0017\u0010$\u001a\u00020\u00192\u0006\u0010\u0012\u001a\u00028\u0000H\u0016¢\u0006\u0004\b$\u0010\u001eJ\u0015\u0010&\u001a\b\u0012\u0004\u0012\u00028\u00000%H\u0016¢\u0006\u0004\b&\u0010'J\u001d\u0010&\u001a\b\u0012\u0004\u0012\u00028\u00000%2\u0006\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b&\u0010(J%\u0010+\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\u0006\u0010)\u001a\u00020\u00192\u0006\u0010*\u001a\u00020\u0019H\u0016¢\u0006\u0004\b+\u0010,J\u000f\u0010.\u001a\u00020-H\u0016¢\u0006\u0004\b.\u0010/J\u0017\u00100\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00028\u0000H\u0016¢\u0006\u0004\b0\u0010\u0014J\u001f\u00100\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0012\u001a\u00028\u0000H\u0016¢\u0006\u0004\b0\u00101J%\u00102\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u00192\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u0015H\u0016¢\u0006\u0004\b2\u00103J\u001d\u00102\u001a\u00020\t2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u0015H\u0016¢\u0006\u0004\b2\u0010\u0018J\u000f\u00104\u001a\u00020\u000fH\u0016¢\u0006\u0004\b4\u0010\u0007J\u0017\u00105\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00028\u0000H\u0016¢\u0006\u0004\b5\u0010\u0014J\u001d\u00106\u001a\u00020\t2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u0015H\u0016¢\u0006\u0004\b6\u0010\u0018J\u0017\u00107\u001a\u00028\u00002\u0006\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b7\u0010\u001cJ\u001d\u00108\u001a\u00020\t2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u0015H\u0016¢\u0006\u0004\b8\u0010\u0018J \u00109\u001a\u00028\u00002\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0012\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0004\b9\u0010:J\u001d\u0010;\u001a\u00020\u000f2\u0006\u0010)\u001a\u00020\u00192\u0006\u0010*\u001a\u00020\u0019¢\u0006\u0004\b;\u0010<J-\u0010A\u001a\u00020\u00192\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u00152\u0006\u0010=\u001a\u00020\u00192\u0006\u0010>\u001a\u00020\u0019H\u0000¢\u0006\u0004\b?\u0010@R$\u0010C\u001a\u00020\r2\u0006\u0010B\u001a\u00020\r8\u0016@RX\u0096\u000e¢\u0006\f\n\u0004\bC\u0010D\u001a\u0004\bE\u0010FR\u0014\u0010I\u001a\u00020\u00198@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bG\u0010HR \u0010N\u001a\b\u0012\u0004\u0012\u00028\u00000J8@X\u0080\u0004¢\u0006\f\u0012\u0004\bM\u0010\u0007\u001a\u0004\bK\u0010LR\u0014\u0010P\u001a\u00020\u00198VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bO\u0010H¨\u0006R"}, d2 = {"Landroidx/compose/runtime/snapshots/SnapshotStateList;", "T", "Landroidx/compose/runtime/snapshots/StateObject;", BuildConfig.FLAVOR, "Ljava/util/RandomAccess;", "Lkotlin/collections/RandomAccess;", "<init>", "()V", "Lkotlin/Function1;", BuildConfig.FLAVOR, "block", "mutateBoolean", "(Lkotlin/jvm/functions/Function1;)Z", "Landroidx/compose/runtime/snapshots/StateRecord;", "value", BuildConfig.FLAVOR, "prependStateRecord", "(Landroidx/compose/runtime/snapshots/StateRecord;)V", "element", "contains", "(Ljava/lang/Object;)Z", BuildConfig.FLAVOR, "elements", "containsAll", "(Ljava/util/Collection;)Z", BuildConfig.FLAVOR, "index", "get", "(I)Ljava/lang/Object;", "indexOf", "(Ljava/lang/Object;)I", "isEmpty", "()Z", BuildConfig.FLAVOR, "iterator", "()Ljava/util/Iterator;", "lastIndexOf", BuildConfig.FLAVOR, "listIterator", "()Ljava/util/ListIterator;", "(I)Ljava/util/ListIterator;", "fromIndex", "toIndex", "subList", "(II)Ljava/util/List;", BuildConfig.FLAVOR, "toString", "()Ljava/lang/String;", "add", "(ILjava/lang/Object;)V", "addAll", "(ILjava/util/Collection;)Z", "clear", "remove", "removeAll", "removeAt", "retainAll", "set", "(ILjava/lang/Object;)Ljava/lang/Object;", "removeRange", "(II)V", "start", "end", "retainAllInRange$runtime_release", "(Ljava/util/Collection;II)I", "retainAllInRange", "<set-?>", "firstStateRecord", "Landroidx/compose/runtime/snapshots/StateRecord;", "getFirstStateRecord", "()Landroidx/compose/runtime/snapshots/StateRecord;", "getStructure$runtime_release", "()I", "structure", "Landroidx/compose/runtime/snapshots/SnapshotStateList$StateListStateRecord;", "getReadable$runtime_release", "()Landroidx/compose/runtime/snapshots/SnapshotStateList$StateListStateRecord;", "getReadable$runtime_release$annotations", "readable", "getSize", "size", "StateListStateRecord", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SnapshotStateList<T> implements StateObject, List<T>, RandomAccess, KMutableList {
    private StateRecord firstStateRecord;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000*\u0004\b\u0001\u0010\u00012\u00020\u0002B\u0015\b\u0000\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0002H\u0016J\b\u0010\u0015\u001a\u00020\u0002H\u0016R \u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005R\u001a\u0010\t\u001a\u00020\nX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\nX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000e¨\u0006\u0016"}, d2 = {"Landroidx/compose/runtime/snapshots/SnapshotStateList$StateListStateRecord;", "T", "Landroidx/compose/runtime/snapshots/StateRecord;", "list", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentList;", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentList;)V", "getList$runtime_release", "()Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentList;", "setList$runtime_release", "modification", BuildConfig.FLAVOR, "getModification$runtime_release", "()I", "setModification$runtime_release", "(I)V", "structuralChange", "getStructuralChange$runtime_release", "setStructuralChange$runtime_release", "assign", BuildConfig.FLAVOR, "value", "create", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class StateListStateRecord<T> extends StateRecord {
        private PersistentList<? extends T> list;
        private int modification;
        private int structuralChange;

        public StateListStateRecord(PersistentList<? extends T> persistentList) {
            this.list = persistentList;
        }

        @Override // androidx.compose.runtime.snapshots.StateRecord
        public void assign(StateRecord value) {
            Object obj;
            obj = SnapshotStateListKt.sync;
            synchronized (obj) {
                Intrinsics.checkNotNull(value, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord.assign$lambda$0>");
                this.list = ((StateListStateRecord) value).list;
                this.modification = ((StateListStateRecord) value).modification;
                this.structuralChange = ((StateListStateRecord) value).structuralChange;
                Unit unit = Unit.INSTANCE;
            }
        }

        @Override // androidx.compose.runtime.snapshots.StateRecord
        public StateRecord create() {
            return new StateListStateRecord(this.list);
        }

        public final PersistentList<T> getList$runtime_release() {
            return this.list;
        }

        /* renamed from: getModification$runtime_release, reason: from getter */
        public final int getModification() {
            return this.modification;
        }

        /* renamed from: getStructuralChange$runtime_release, reason: from getter */
        public final int getStructuralChange() {
            return this.structuralChange;
        }

        public final void setList$runtime_release(PersistentList<? extends T> persistentList) {
            this.list = persistentList;
        }

        public final void setModification$runtime_release(int i5) {
            this.modification = i5;
        }

        public final void setStructuralChange$runtime_release(int i5) {
            this.structuralChange = i5;
        }
    }

    public SnapshotStateList() {
        PersistentList persistentListOf = ExtensionsKt.persistentListOf();
        StateListStateRecord stateListStateRecord = new StateListStateRecord(persistentListOf);
        if (Snapshot.INSTANCE.isInSnapshot()) {
            StateListStateRecord stateListStateRecord2 = new StateListStateRecord(persistentListOf);
            stateListStateRecord2.setSnapshotId$runtime_release(1);
            stateListStateRecord.setNext$runtime_release(stateListStateRecord2);
        }
        this.firstStateRecord = stateListStateRecord;
    }

    private final boolean mutateBoolean(Function1<? super List<T>, Boolean> block) {
        Object obj;
        int modification;
        PersistentList<T> list$runtime_release;
        Boolean invoke;
        Snapshot current;
        Object obj2;
        boolean z5;
        do {
            obj = SnapshotStateListKt.sync;
            synchronized (obj) {
                StateRecord firstStateRecord = getFirstStateRecord();
                Intrinsics.checkNotNull(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
                StateListStateRecord stateListStateRecord = (StateListStateRecord) SnapshotKt.current((StateListStateRecord) firstStateRecord);
                modification = stateListStateRecord.getModification();
                list$runtime_release = stateListStateRecord.getList$runtime_release();
                Unit unit = Unit.INSTANCE;
            }
            Intrinsics.checkNotNull(list$runtime_release);
            PersistentList.Builder<T> builder = list$runtime_release.builder();
            invoke = block.invoke(builder);
            PersistentList<T> build = builder.build();
            if (Intrinsics.areEqual(build, list$runtime_release)) {
                break;
            }
            StateRecord firstStateRecord2 = getFirstStateRecord();
            Intrinsics.checkNotNull(firstStateRecord2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
            StateListStateRecord stateListStateRecord2 = (StateListStateRecord) firstStateRecord2;
            SnapshotKt.getSnapshotInitializer();
            synchronized (SnapshotKt.getLock()) {
                current = Snapshot.INSTANCE.getCurrent();
                StateListStateRecord stateListStateRecord3 = (StateListStateRecord) SnapshotKt.writableRecord(stateListStateRecord2, this, current);
                obj2 = SnapshotStateListKt.sync;
                synchronized (obj2) {
                    if (stateListStateRecord3.getModification() == modification) {
                        stateListStateRecord3.setList$runtime_release(build);
                        z5 = true;
                        stateListStateRecord3.setModification$runtime_release(stateListStateRecord3.getModification() + 1);
                        stateListStateRecord3.setStructuralChange$runtime_release(stateListStateRecord3.getStructuralChange() + 1);
                    } else {
                        z5 = false;
                    }
                }
            }
            SnapshotKt.notifyWrite(current, this);
        } while (!z5);
        return invoke.booleanValue();
    }

    @Override // java.util.List, java.util.Collection
    public boolean add(T element) {
        Object obj;
        int modification;
        PersistentList<T> list$runtime_release;
        boolean z5;
        Snapshot current;
        Object obj2;
        do {
            obj = SnapshotStateListKt.sync;
            synchronized (obj) {
                StateRecord firstStateRecord = getFirstStateRecord();
                Intrinsics.checkNotNull(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
                StateListStateRecord stateListStateRecord = (StateListStateRecord) SnapshotKt.current((StateListStateRecord) firstStateRecord);
                modification = stateListStateRecord.getModification();
                list$runtime_release = stateListStateRecord.getList$runtime_release();
                Unit unit = Unit.INSTANCE;
            }
            Intrinsics.checkNotNull(list$runtime_release);
            PersistentList<T> add = list$runtime_release.add((PersistentList<T>) element);
            z5 = false;
            if (Intrinsics.areEqual(add, list$runtime_release)) {
                return false;
            }
            StateRecord firstStateRecord2 = getFirstStateRecord();
            Intrinsics.checkNotNull(firstStateRecord2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
            StateListStateRecord stateListStateRecord2 = (StateListStateRecord) firstStateRecord2;
            SnapshotKt.getSnapshotInitializer();
            synchronized (SnapshotKt.getLock()) {
                current = Snapshot.INSTANCE.getCurrent();
                StateListStateRecord stateListStateRecord3 = (StateListStateRecord) SnapshotKt.writableRecord(stateListStateRecord2, this, current);
                obj2 = SnapshotStateListKt.sync;
                synchronized (obj2) {
                    if (stateListStateRecord3.getModification() == modification) {
                        stateListStateRecord3.setList$runtime_release(add);
                        stateListStateRecord3.setStructuralChange$runtime_release(stateListStateRecord3.getStructuralChange() + 1);
                        stateListStateRecord3.setModification$runtime_release(stateListStateRecord3.getModification() + 1);
                        z5 = true;
                    }
                }
            }
            SnapshotKt.notifyWrite(current, this);
        } while (!z5);
        return true;
    }

    @Override // java.util.List
    public boolean addAll(final int index, final Collection<? extends T> elements) {
        return mutateBoolean(new Function1<List<T>, Boolean>() { // from class: androidx.compose.runtime.snapshots.SnapshotStateList$addAll$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(List<T> list) {
                return Boolean.valueOf(list.addAll(index, elements));
            }
        });
    }

    @Override // java.util.List, java.util.Collection
    public void clear() {
        Snapshot current;
        Object obj;
        StateRecord firstStateRecord = getFirstStateRecord();
        Intrinsics.checkNotNull(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
        StateListStateRecord stateListStateRecord = (StateListStateRecord) firstStateRecord;
        SnapshotKt.getSnapshotInitializer();
        synchronized (SnapshotKt.getLock()) {
            current = Snapshot.INSTANCE.getCurrent();
            StateListStateRecord stateListStateRecord2 = (StateListStateRecord) SnapshotKt.writableRecord(stateListStateRecord, this, current);
            obj = SnapshotStateListKt.sync;
            synchronized (obj) {
                stateListStateRecord2.setList$runtime_release(ExtensionsKt.persistentListOf());
                stateListStateRecord2.setModification$runtime_release(stateListStateRecord2.getModification() + 1);
                stateListStateRecord2.setStructuralChange$runtime_release(stateListStateRecord2.getStructuralChange() + 1);
            }
        }
        SnapshotKt.notifyWrite(current, this);
    }

    @Override // java.util.List, java.util.Collection
    public boolean contains(Object element) {
        return getReadable$runtime_release().getList$runtime_release().contains(element);
    }

    @Override // java.util.List, java.util.Collection
    public boolean containsAll(Collection<? extends Object> elements) {
        return getReadable$runtime_release().getList$runtime_release().containsAll(elements);
    }

    @Override // java.util.List
    public T get(int index) {
        return getReadable$runtime_release().getList$runtime_release().get(index);
    }

    @Override // androidx.compose.runtime.snapshots.StateObject
    public StateRecord getFirstStateRecord() {
        return this.firstStateRecord;
    }

    public final StateListStateRecord<T> getReadable$runtime_release() {
        StateRecord firstStateRecord = getFirstStateRecord();
        Intrinsics.checkNotNull(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
        return (StateListStateRecord) SnapshotKt.readable((StateListStateRecord) firstStateRecord, this);
    }

    public int getSize() {
        return getReadable$runtime_release().getList$runtime_release().size();
    }

    public final int getStructure$runtime_release() {
        StateRecord firstStateRecord = getFirstStateRecord();
        Intrinsics.checkNotNull(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
        return ((StateListStateRecord) SnapshotKt.current((StateListStateRecord) firstStateRecord)).getStructuralChange();
    }

    @Override // java.util.List
    public int indexOf(Object element) {
        return getReadable$runtime_release().getList$runtime_release().indexOf(element);
    }

    @Override // java.util.List, java.util.Collection
    public boolean isEmpty() {
        return getReadable$runtime_release().getList$runtime_release().isEmpty();
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    public Iterator<T> iterator() {
        return listIterator();
    }

    @Override // java.util.List
    public int lastIndexOf(Object element) {
        return getReadable$runtime_release().getList$runtime_release().lastIndexOf(element);
    }

    @Override // java.util.List
    public ListIterator<T> listIterator() {
        return new StateListIterator(this, 0);
    }

    @Override // androidx.compose.runtime.snapshots.StateObject
    public void prependStateRecord(StateRecord value) {
        value.setNext$runtime_release(getFirstStateRecord());
        Intrinsics.checkNotNull(value, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
        this.firstStateRecord = (StateListStateRecord) value;
    }

    @Override // java.util.List
    public final /* bridge */ T remove(int i5) {
        return removeAt(i5);
    }

    @Override // java.util.List, java.util.Collection
    public boolean removeAll(Collection<? extends Object> elements) {
        Object obj;
        int modification;
        PersistentList<T> list$runtime_release;
        boolean z5;
        Snapshot current;
        Object obj2;
        do {
            obj = SnapshotStateListKt.sync;
            synchronized (obj) {
                StateRecord firstStateRecord = getFirstStateRecord();
                Intrinsics.checkNotNull(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
                StateListStateRecord stateListStateRecord = (StateListStateRecord) SnapshotKt.current((StateListStateRecord) firstStateRecord);
                modification = stateListStateRecord.getModification();
                list$runtime_release = stateListStateRecord.getList$runtime_release();
                Unit unit = Unit.INSTANCE;
            }
            Intrinsics.checkNotNull(list$runtime_release);
            PersistentList<T> removeAll = list$runtime_release.removeAll((Collection<? extends T>) elements);
            z5 = false;
            if (Intrinsics.areEqual(removeAll, list$runtime_release)) {
                return false;
            }
            StateRecord firstStateRecord2 = getFirstStateRecord();
            Intrinsics.checkNotNull(firstStateRecord2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
            StateListStateRecord stateListStateRecord2 = (StateListStateRecord) firstStateRecord2;
            SnapshotKt.getSnapshotInitializer();
            synchronized (SnapshotKt.getLock()) {
                current = Snapshot.INSTANCE.getCurrent();
                StateListStateRecord stateListStateRecord3 = (StateListStateRecord) SnapshotKt.writableRecord(stateListStateRecord2, this, current);
                obj2 = SnapshotStateListKt.sync;
                synchronized (obj2) {
                    if (stateListStateRecord3.getModification() == modification) {
                        stateListStateRecord3.setList$runtime_release(removeAll);
                        stateListStateRecord3.setStructuralChange$runtime_release(stateListStateRecord3.getStructuralChange() + 1);
                        stateListStateRecord3.setModification$runtime_release(stateListStateRecord3.getModification() + 1);
                        z5 = true;
                    }
                }
            }
            SnapshotKt.notifyWrite(current, this);
        } while (!z5);
        return true;
    }

    public T removeAt(int index) {
        Object obj;
        int modification;
        PersistentList<T> list$runtime_release;
        Snapshot current;
        Object obj2;
        boolean z5;
        T t5 = get(index);
        do {
            obj = SnapshotStateListKt.sync;
            synchronized (obj) {
                StateRecord firstStateRecord = getFirstStateRecord();
                Intrinsics.checkNotNull(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
                StateListStateRecord stateListStateRecord = (StateListStateRecord) SnapshotKt.current((StateListStateRecord) firstStateRecord);
                modification = stateListStateRecord.getModification();
                list$runtime_release = stateListStateRecord.getList$runtime_release();
                Unit unit = Unit.INSTANCE;
            }
            Intrinsics.checkNotNull(list$runtime_release);
            PersistentList<T> removeAt = list$runtime_release.removeAt(index);
            if (Intrinsics.areEqual(removeAt, list$runtime_release)) {
                break;
            }
            StateRecord firstStateRecord2 = getFirstStateRecord();
            Intrinsics.checkNotNull(firstStateRecord2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
            StateListStateRecord stateListStateRecord2 = (StateListStateRecord) firstStateRecord2;
            SnapshotKt.getSnapshotInitializer();
            synchronized (SnapshotKt.getLock()) {
                current = Snapshot.INSTANCE.getCurrent();
                StateListStateRecord stateListStateRecord3 = (StateListStateRecord) SnapshotKt.writableRecord(stateListStateRecord2, this, current);
                obj2 = SnapshotStateListKt.sync;
                synchronized (obj2) {
                    if (stateListStateRecord3.getModification() == modification) {
                        stateListStateRecord3.setList$runtime_release(removeAt);
                        z5 = true;
                        stateListStateRecord3.setStructuralChange$runtime_release(stateListStateRecord3.getStructuralChange() + 1);
                        stateListStateRecord3.setModification$runtime_release(stateListStateRecord3.getModification() + 1);
                    } else {
                        z5 = false;
                    }
                }
            }
            SnapshotKt.notifyWrite(current, this);
        } while (!z5);
        return t5;
    }

    public final void removeRange(int fromIndex, int toIndex) {
        Object obj;
        int modification;
        PersistentList<T> list$runtime_release;
        Snapshot current;
        Object obj2;
        boolean z5;
        do {
            obj = SnapshotStateListKt.sync;
            synchronized (obj) {
                StateRecord firstStateRecord = getFirstStateRecord();
                Intrinsics.checkNotNull(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
                StateListStateRecord stateListStateRecord = (StateListStateRecord) SnapshotKt.current((StateListStateRecord) firstStateRecord);
                modification = stateListStateRecord.getModification();
                list$runtime_release = stateListStateRecord.getList$runtime_release();
                Unit unit = Unit.INSTANCE;
            }
            Intrinsics.checkNotNull(list$runtime_release);
            PersistentList.Builder<T> builder = list$runtime_release.builder();
            builder.subList(fromIndex, toIndex).clear();
            PersistentList<T> build = builder.build();
            if (Intrinsics.areEqual(build, list$runtime_release)) {
                return;
            }
            StateRecord firstStateRecord2 = getFirstStateRecord();
            Intrinsics.checkNotNull(firstStateRecord2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
            StateListStateRecord stateListStateRecord2 = (StateListStateRecord) firstStateRecord2;
            SnapshotKt.getSnapshotInitializer();
            synchronized (SnapshotKt.getLock()) {
                current = Snapshot.INSTANCE.getCurrent();
                StateListStateRecord stateListStateRecord3 = (StateListStateRecord) SnapshotKt.writableRecord(stateListStateRecord2, this, current);
                obj2 = SnapshotStateListKt.sync;
                synchronized (obj2) {
                    if (stateListStateRecord3.getModification() == modification) {
                        stateListStateRecord3.setList$runtime_release(build);
                        z5 = true;
                        stateListStateRecord3.setModification$runtime_release(stateListStateRecord3.getModification() + 1);
                        stateListStateRecord3.setStructuralChange$runtime_release(stateListStateRecord3.getStructuralChange() + 1);
                    } else {
                        z5 = false;
                    }
                }
            }
            SnapshotKt.notifyWrite(current, this);
        } while (!z5);
    }

    @Override // java.util.List, java.util.Collection
    public boolean retainAll(final Collection<? extends Object> elements) {
        return mutateBoolean(new Function1<List<T>, Boolean>() { // from class: androidx.compose.runtime.snapshots.SnapshotStateList$retainAll$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(List<T> list) {
                return Boolean.valueOf(list.retainAll(elements));
            }
        });
    }

    public final int retainAllInRange$runtime_release(Collection<? extends T> elements, int start, int end) {
        Object obj;
        int modification;
        PersistentList<T> list$runtime_release;
        Snapshot current;
        Object obj2;
        boolean z5;
        int size = size();
        do {
            obj = SnapshotStateListKt.sync;
            synchronized (obj) {
                StateRecord firstStateRecord = getFirstStateRecord();
                Intrinsics.checkNotNull(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
                StateListStateRecord stateListStateRecord = (StateListStateRecord) SnapshotKt.current((StateListStateRecord) firstStateRecord);
                modification = stateListStateRecord.getModification();
                list$runtime_release = stateListStateRecord.getList$runtime_release();
                Unit unit = Unit.INSTANCE;
            }
            Intrinsics.checkNotNull(list$runtime_release);
            PersistentList.Builder<T> builder = list$runtime_release.builder();
            builder.subList(start, end).retainAll(elements);
            PersistentList<T> build = builder.build();
            if (Intrinsics.areEqual(build, list$runtime_release)) {
                break;
            }
            StateRecord firstStateRecord2 = getFirstStateRecord();
            Intrinsics.checkNotNull(firstStateRecord2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
            StateListStateRecord stateListStateRecord2 = (StateListStateRecord) firstStateRecord2;
            SnapshotKt.getSnapshotInitializer();
            synchronized (SnapshotKt.getLock()) {
                current = Snapshot.INSTANCE.getCurrent();
                StateListStateRecord stateListStateRecord3 = (StateListStateRecord) SnapshotKt.writableRecord(stateListStateRecord2, this, current);
                obj2 = SnapshotStateListKt.sync;
                synchronized (obj2) {
                    if (stateListStateRecord3.getModification() == modification) {
                        stateListStateRecord3.setList$runtime_release(build);
                        z5 = true;
                        stateListStateRecord3.setModification$runtime_release(stateListStateRecord3.getModification() + 1);
                        stateListStateRecord3.setStructuralChange$runtime_release(stateListStateRecord3.getStructuralChange() + 1);
                    } else {
                        z5 = false;
                    }
                }
            }
            SnapshotKt.notifyWrite(current, this);
        } while (!z5);
        return size - size();
    }

    @Override // java.util.List
    public T set(int index, T element) {
        Object obj;
        int modification;
        PersistentList<T> list$runtime_release;
        Snapshot current;
        Object obj2;
        boolean z5;
        T t5 = get(index);
        do {
            obj = SnapshotStateListKt.sync;
            synchronized (obj) {
                StateRecord firstStateRecord = getFirstStateRecord();
                Intrinsics.checkNotNull(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
                StateListStateRecord stateListStateRecord = (StateListStateRecord) SnapshotKt.current((StateListStateRecord) firstStateRecord);
                modification = stateListStateRecord.getModification();
                list$runtime_release = stateListStateRecord.getList$runtime_release();
                Unit unit = Unit.INSTANCE;
            }
            Intrinsics.checkNotNull(list$runtime_release);
            PersistentList<T> persistentList = list$runtime_release.set(index, (int) element);
            if (Intrinsics.areEqual(persistentList, list$runtime_release)) {
                break;
            }
            StateRecord firstStateRecord2 = getFirstStateRecord();
            Intrinsics.checkNotNull(firstStateRecord2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
            StateListStateRecord stateListStateRecord2 = (StateListStateRecord) firstStateRecord2;
            SnapshotKt.getSnapshotInitializer();
            synchronized (SnapshotKt.getLock()) {
                current = Snapshot.INSTANCE.getCurrent();
                StateListStateRecord stateListStateRecord3 = (StateListStateRecord) SnapshotKt.writableRecord(stateListStateRecord2, this, current);
                obj2 = SnapshotStateListKt.sync;
                synchronized (obj2) {
                    if (stateListStateRecord3.getModification() == modification) {
                        stateListStateRecord3.setList$runtime_release(persistentList);
                        z5 = true;
                        stateListStateRecord3.setModification$runtime_release(stateListStateRecord3.getModification() + 1);
                    } else {
                        z5 = false;
                    }
                }
            }
            SnapshotKt.notifyWrite(current, this);
        } while (!z5);
        return t5;
    }

    @Override // java.util.List, java.util.Collection
    public final /* bridge */ int size() {
        return getSize();
    }

    @Override // java.util.List
    public List<T> subList(int fromIndex, int toIndex) {
        if (!(fromIndex >= 0 && fromIndex <= toIndex && toIndex <= size())) {
            PreconditionsKt.throwIllegalArgumentException("fromIndex or toIndex are out of bounds");
        }
        return new SubList(this, fromIndex, toIndex);
    }

    @Override // java.util.List, java.util.Collection
    public Object[] toArray() {
        return CollectionToArray.toArray(this);
    }

    public String toString() {
        StateRecord firstStateRecord = getFirstStateRecord();
        Intrinsics.checkNotNull(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
        return "SnapshotStateList(value=" + ((StateListStateRecord) SnapshotKt.current((StateListStateRecord) firstStateRecord)).getList$runtime_release() + ")@" + hashCode();
    }

    @Override // java.util.List, java.util.Collection
    public boolean addAll(Collection<? extends T> elements) {
        Object obj;
        int modification;
        PersistentList<T> list$runtime_release;
        boolean z5;
        Snapshot current;
        Object obj2;
        do {
            obj = SnapshotStateListKt.sync;
            synchronized (obj) {
                StateRecord firstStateRecord = getFirstStateRecord();
                Intrinsics.checkNotNull(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
                StateListStateRecord stateListStateRecord = (StateListStateRecord) SnapshotKt.current((StateListStateRecord) firstStateRecord);
                modification = stateListStateRecord.getModification();
                list$runtime_release = stateListStateRecord.getList$runtime_release();
                Unit unit = Unit.INSTANCE;
            }
            Intrinsics.checkNotNull(list$runtime_release);
            PersistentList<T> addAll = list$runtime_release.addAll(elements);
            z5 = false;
            if (Intrinsics.areEqual(addAll, list$runtime_release)) {
                return false;
            }
            StateRecord firstStateRecord2 = getFirstStateRecord();
            Intrinsics.checkNotNull(firstStateRecord2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
            StateListStateRecord stateListStateRecord2 = (StateListStateRecord) firstStateRecord2;
            SnapshotKt.getSnapshotInitializer();
            synchronized (SnapshotKt.getLock()) {
                current = Snapshot.INSTANCE.getCurrent();
                StateListStateRecord stateListStateRecord3 = (StateListStateRecord) SnapshotKt.writableRecord(stateListStateRecord2, this, current);
                obj2 = SnapshotStateListKt.sync;
                synchronized (obj2) {
                    if (stateListStateRecord3.getModification() == modification) {
                        stateListStateRecord3.setList$runtime_release(addAll);
                        stateListStateRecord3.setStructuralChange$runtime_release(stateListStateRecord3.getStructuralChange() + 1);
                        stateListStateRecord3.setModification$runtime_release(stateListStateRecord3.getModification() + 1);
                        z5 = true;
                    }
                }
            }
            SnapshotKt.notifyWrite(current, this);
        } while (!z5);
        return true;
    }

    @Override // java.util.List
    public ListIterator<T> listIterator(int index) {
        return new StateListIterator(this, index);
    }

    @Override // java.util.List, java.util.Collection
    public boolean remove(Object element) {
        Object obj;
        int modification;
        PersistentList<T> list$runtime_release;
        boolean z5;
        Snapshot current;
        Object obj2;
        do {
            obj = SnapshotStateListKt.sync;
            synchronized (obj) {
                StateRecord firstStateRecord = getFirstStateRecord();
                Intrinsics.checkNotNull(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
                StateListStateRecord stateListStateRecord = (StateListStateRecord) SnapshotKt.current((StateListStateRecord) firstStateRecord);
                modification = stateListStateRecord.getModification();
                list$runtime_release = stateListStateRecord.getList$runtime_release();
                Unit unit = Unit.INSTANCE;
            }
            Intrinsics.checkNotNull(list$runtime_release);
            PersistentList<T> remove = list$runtime_release.remove((PersistentList<T>) element);
            z5 = false;
            if (Intrinsics.areEqual(remove, list$runtime_release)) {
                return false;
            }
            StateRecord firstStateRecord2 = getFirstStateRecord();
            Intrinsics.checkNotNull(firstStateRecord2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
            StateListStateRecord stateListStateRecord2 = (StateListStateRecord) firstStateRecord2;
            SnapshotKt.getSnapshotInitializer();
            synchronized (SnapshotKt.getLock()) {
                current = Snapshot.INSTANCE.getCurrent();
                StateListStateRecord stateListStateRecord3 = (StateListStateRecord) SnapshotKt.writableRecord(stateListStateRecord2, this, current);
                obj2 = SnapshotStateListKt.sync;
                synchronized (obj2) {
                    if (stateListStateRecord3.getModification() == modification) {
                        stateListStateRecord3.setList$runtime_release(remove);
                        stateListStateRecord3.setStructuralChange$runtime_release(stateListStateRecord3.getStructuralChange() + 1);
                        stateListStateRecord3.setModification$runtime_release(stateListStateRecord3.getModification() + 1);
                        z5 = true;
                    }
                }
            }
            SnapshotKt.notifyWrite(current, this);
        } while (!z5);
        return true;
    }

    @Override // java.util.List, java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        return (T[]) CollectionToArray.toArray(this, tArr);
    }

    @Override // java.util.List
    public void add(int index, T element) {
        Object obj;
        int modification;
        PersistentList<T> list$runtime_release;
        Snapshot current;
        Object obj2;
        boolean z5;
        do {
            obj = SnapshotStateListKt.sync;
            synchronized (obj) {
                StateRecord firstStateRecord = getFirstStateRecord();
                Intrinsics.checkNotNull(firstStateRecord, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
                StateListStateRecord stateListStateRecord = (StateListStateRecord) SnapshotKt.current((StateListStateRecord) firstStateRecord);
                modification = stateListStateRecord.getModification();
                list$runtime_release = stateListStateRecord.getList$runtime_release();
                Unit unit = Unit.INSTANCE;
            }
            Intrinsics.checkNotNull(list$runtime_release);
            PersistentList<T> add = list$runtime_release.add(index, (int) element);
            if (Intrinsics.areEqual(add, list$runtime_release)) {
                return;
            }
            StateRecord firstStateRecord2 = getFirstStateRecord();
            Intrinsics.checkNotNull(firstStateRecord2, "null cannot be cast to non-null type androidx.compose.runtime.snapshots.SnapshotStateList.StateListStateRecord<T of androidx.compose.runtime.snapshots.SnapshotStateList>");
            StateListStateRecord stateListStateRecord2 = (StateListStateRecord) firstStateRecord2;
            SnapshotKt.getSnapshotInitializer();
            synchronized (SnapshotKt.getLock()) {
                current = Snapshot.INSTANCE.getCurrent();
                StateListStateRecord stateListStateRecord3 = (StateListStateRecord) SnapshotKt.writableRecord(stateListStateRecord2, this, current);
                obj2 = SnapshotStateListKt.sync;
                synchronized (obj2) {
                    if (stateListStateRecord3.getModification() == modification) {
                        stateListStateRecord3.setList$runtime_release(add);
                        z5 = true;
                        stateListStateRecord3.setStructuralChange$runtime_release(stateListStateRecord3.getStructuralChange() + 1);
                        stateListStateRecord3.setModification$runtime_release(stateListStateRecord3.getModification() + 1);
                    } else {
                        z5 = false;
                    }
                }
            }
            SnapshotKt.notifyWrite(current, this);
        } while (!z5);
    }
}
