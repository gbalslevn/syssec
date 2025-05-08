package androidx.compose.runtime;

import androidx.collection.MutableObjectIntMap;
import androidx.collection.ObjectIntMap;
import androidx.collection.ObjectIntMapKt;
import androidx.compose.runtime.DerivedState;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.internal.IntRef;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.runtime.snapshots.SnapshotKt;
import androidx.compose.runtime.snapshots.StateObject;
import androidx.compose.runtime.snapshots.StateObjectImpl;
import androidx.compose.runtime.snapshots.StateRecord;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u00022\b\u0012\u0004\u0012\u00028\u00000\u0003:\u0001+B%\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJA\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0015\u0010\u0016\u001a\u00020\u00152\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u001c\u0010\u0014R\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u001dR\"\u0010\u0007\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00068\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u001c\u0010!\u001a\b\u0012\u0004\u0012\u00028\u00000\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010%\u001a\u00020\u00158VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b#\u0010$R\u0014\u0010\u0018\u001a\u00028\u00008VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b&\u0010'R\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000(8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b)\u0010*¨\u0006,"}, d2 = {"Landroidx/compose/runtime/DerivedSnapshotState;", "T", "Landroidx/compose/runtime/snapshots/StateObjectImpl;", "Landroidx/compose/runtime/DerivedState;", "Lkotlin/Function0;", "calculation", "Landroidx/compose/runtime/SnapshotMutationPolicy;", "policy", "<init>", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/SnapshotMutationPolicy;)V", "Landroidx/compose/runtime/DerivedSnapshotState$ResultRecord;", "readable", "Landroidx/compose/runtime/snapshots/Snapshot;", "snapshot", BuildConfig.FLAVOR, "forceDependencyReads", "currentRecord", "(Landroidx/compose/runtime/DerivedSnapshotState$ResultRecord;Landroidx/compose/runtime/snapshots/Snapshot;ZLkotlin/jvm/functions/Function0;)Landroidx/compose/runtime/DerivedSnapshotState$ResultRecord;", BuildConfig.FLAVOR, "displayValue", "()Ljava/lang/String;", "Landroidx/compose/runtime/snapshots/StateRecord;", "current", "(Landroidx/compose/runtime/snapshots/Snapshot;)Landroidx/compose/runtime/snapshots/StateRecord;", "value", BuildConfig.FLAVOR, "prependStateRecord", "(Landroidx/compose/runtime/snapshots/StateRecord;)V", "toString", "Lkotlin/jvm/functions/Function0;", "Landroidx/compose/runtime/SnapshotMutationPolicy;", "getPolicy", "()Landroidx/compose/runtime/SnapshotMutationPolicy;", "first", "Landroidx/compose/runtime/DerivedSnapshotState$ResultRecord;", "getFirstStateRecord", "()Landroidx/compose/runtime/snapshots/StateRecord;", "firstStateRecord", "getValue", "()Ljava/lang/Object;", "Landroidx/compose/runtime/DerivedState$Record;", "getCurrentRecord", "()Landroidx/compose/runtime/DerivedState$Record;", "ResultRecord", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* renamed from: androidx.compose.runtime.DerivedSnapshotState, reason: from toString */
/* loaded from: classes.dex */
public final class DerivedState<T> extends StateObjectImpl implements androidx.compose.runtime.DerivedState<T> {
    private final Function0<T> calculation;
    private ResultRecord<T> first = new ResultRecord<>();
    private final SnapshotMutationPolicy<T> policy;

    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\r\b\u0007\u0018\u0000 3*\u0004\b\u0001\u0010\u00012\u00020\u00022\b\u0012\u0004\u0012\u00028\u00010\u0003:\u00013B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\u000bJ!\u0010\u0011\u001a\u00020\u00102\n\u0010\r\u001a\u0006\u0012\u0002\b\u00030\f2\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0011\u0010\u0012J!\u0010\u0014\u001a\u00020\u00132\n\u0010\r\u001a\u0006\u0012\u0002\b\u00030\f2\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0014\u0010\u0015R\"\u0010\u0016\u001a\u00020\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\"\u0010\u001c\u001a\u00020\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u0017\u001a\u0004\b\u001d\u0010\u0019\"\u0004\b\u001e\u0010\u001bR(\u0010!\u001a\b\u0012\u0004\u0012\u00020 0\u001f8\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R$\u0010(\u001a\u0004\u0018\u00010'8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\"\u0010.\u001a\u00020\u00138\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b.\u0010\u0017\u001a\u0004\b/\u0010\u0019\"\u0004\b0\u0010\u001bR\u0014\u00102\u001a\u00028\u00018VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b1\u0010+¨\u00064"}, d2 = {"Landroidx/compose/runtime/DerivedSnapshotState$ResultRecord;", "T", "Landroidx/compose/runtime/snapshots/StateRecord;", "Landroidx/compose/runtime/DerivedState$Record;", "<init>", "()V", "value", BuildConfig.FLAVOR, "assign", "(Landroidx/compose/runtime/snapshots/StateRecord;)V", "create", "()Landroidx/compose/runtime/snapshots/StateRecord;", "Landroidx/compose/runtime/DerivedState;", "derivedState", "Landroidx/compose/runtime/snapshots/Snapshot;", "snapshot", BuildConfig.FLAVOR, "isValid", "(Landroidx/compose/runtime/DerivedState;Landroidx/compose/runtime/snapshots/Snapshot;)Z", BuildConfig.FLAVOR, "readableHash", "(Landroidx/compose/runtime/DerivedState;Landroidx/compose/runtime/snapshots/Snapshot;)I", "validSnapshotId", "I", "getValidSnapshotId", "()I", "setValidSnapshotId", "(I)V", "validSnapshotWriteCount", "getValidSnapshotWriteCount", "setValidSnapshotWriteCount", "Landroidx/collection/ObjectIntMap;", "Landroidx/compose/runtime/snapshots/StateObject;", "dependencies", "Landroidx/collection/ObjectIntMap;", "getDependencies", "()Landroidx/collection/ObjectIntMap;", "setDependencies", "(Landroidx/collection/ObjectIntMap;)V", BuildConfig.FLAVOR, "result", "Ljava/lang/Object;", "getResult", "()Ljava/lang/Object;", "setResult", "(Ljava/lang/Object;)V", "resultHash", "getResultHash", "setResultHash", "getCurrentValue", "currentValue", "Companion", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* renamed from: androidx.compose.runtime.DerivedSnapshotState$ResultRecord */
    /* loaded from: classes.dex */
    public static final class ResultRecord<T> extends StateRecord implements DerivedState.Record<T> {
        private ObjectIntMap<StateObject> dependencies = ObjectIntMapKt.emptyObjectIntMap();
        private Object result = Unset;
        private int resultHash;
        private int validSnapshotId;
        private int validSnapshotWriteCount;

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        public static final int $stable = 8;
        private static final Object Unset = new Object();

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Landroidx/compose/runtime/DerivedSnapshotState$ResultRecord$Companion;", BuildConfig.FLAVOR, "()V", "Unset", "getUnset", "()Ljava/lang/Object;", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
        /* renamed from: androidx.compose.runtime.DerivedSnapshotState$ResultRecord$Companion, reason: from kotlin metadata */
        /* loaded from: classes.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final Object getUnset() {
                return ResultRecord.Unset;
            }

            private Companion() {
            }
        }

        @Override // androidx.compose.runtime.snapshots.StateRecord
        public void assign(StateRecord value) {
            Intrinsics.checkNotNull(value, "null cannot be cast to non-null type androidx.compose.runtime.DerivedSnapshotState.ResultRecord<T of androidx.compose.runtime.DerivedSnapshotState.ResultRecord>");
            ResultRecord resultRecord = (ResultRecord) value;
            setDependencies(resultRecord.getDependencies());
            this.result = resultRecord.result;
            this.resultHash = resultRecord.resultHash;
        }

        @Override // androidx.compose.runtime.snapshots.StateRecord
        public StateRecord create() {
            return new ResultRecord();
        }

        @Override // androidx.compose.runtime.DerivedState.Record
        public T getCurrentValue() {
            return (T) this.result;
        }

        @Override // androidx.compose.runtime.DerivedState.Record
        public ObjectIntMap<StateObject> getDependencies() {
            return this.dependencies;
        }

        public final Object getResult() {
            return this.result;
        }

        public final boolean isValid(androidx.compose.runtime.DerivedState<?> derivedState, Snapshot snapshot) {
            boolean z5;
            boolean z6;
            synchronized (SnapshotKt.getLock()) {
                z5 = true;
                if (this.validSnapshotId == snapshot.getId()) {
                    if (this.validSnapshotWriteCount == snapshot.getWriteCount()) {
                        z6 = false;
                    }
                }
                z6 = true;
            }
            if (this.result == Unset || (z6 && this.resultHash != readableHash(derivedState, snapshot))) {
                z5 = false;
            }
            if (z5 && z6) {
                synchronized (SnapshotKt.getLock()) {
                    this.validSnapshotId = snapshot.getId();
                    this.validSnapshotWriteCount = snapshot.getWriteCount();
                    Unit unit = Unit.INSTANCE;
                }
            }
            return z5;
        }

        public final int readableHash(androidx.compose.runtime.DerivedState<?> derivedState, Snapshot snapshot) {
            ObjectIntMap<StateObject> dependencies;
            int i5;
            int i6;
            synchronized (SnapshotKt.getLock()) {
                dependencies = getDependencies();
            }
            char c5 = 7;
            if (!dependencies.isNotEmpty()) {
                return 7;
            }
            MutableVector<DerivedStateObserver> derivedStateObservers = SnapshotStateKt.derivedStateObservers();
            int size = derivedStateObservers.getSize();
            if (size > 0) {
                DerivedStateObserver[] content = derivedStateObservers.getContent();
                int i7 = 0;
                do {
                    content[i7].start(derivedState);
                    i7++;
                } while (i7 < size);
            }
            try {
                Object[] objArr = dependencies.keys;
                int[] iArr = dependencies.values;
                long[] jArr = dependencies.metadata;
                int length = jArr.length - 2;
                if (length >= 0) {
                    int i8 = 7;
                    int i9 = 0;
                    while (true) {
                        long j5 = jArr[i9];
                        if ((((~j5) << c5) & j5 & (-9187201950435737472L)) != -9187201950435737472L) {
                            int i10 = 8;
                            int i11 = 8 - ((~(i9 - length)) >>> 31);
                            int i12 = 0;
                            while (i12 < i11) {
                                if ((j5 & 255) < 128) {
                                    int i13 = (i9 << 3) + i12;
                                    StateObject stateObject = (StateObject) objArr[i13];
                                    if (iArr[i13] == 1) {
                                        StateRecord current = stateObject instanceof DerivedState ? ((DerivedState) stateObject).current(snapshot) : SnapshotKt.current(stateObject.getFirstStateRecord(), snapshot);
                                        i8 = (((i8 * 31) + ActualJvm_jvmKt.identityHashCode(current)) * 31) + current.getSnapshotId();
                                    }
                                    i6 = 8;
                                } else {
                                    i6 = i10;
                                }
                                j5 >>= i6;
                                i12++;
                                i10 = i6;
                            }
                            if (i11 != i10) {
                                break;
                            }
                        }
                        if (i9 == length) {
                            break;
                        }
                        i9++;
                        c5 = 7;
                    }
                    i5 = i8;
                } else {
                    i5 = 7;
                }
                Unit unit = Unit.INSTANCE;
                int size2 = derivedStateObservers.getSize();
                if (size2 <= 0) {
                    return i5;
                }
                DerivedStateObserver[] content2 = derivedStateObservers.getContent();
                int i14 = 0;
                do {
                    content2[i14].done(derivedState);
                    i14++;
                } while (i14 < size2);
                return i5;
            } catch (Throwable th) {
                int size3 = derivedStateObservers.getSize();
                if (size3 > 0) {
                    DerivedStateObserver[] content3 = derivedStateObservers.getContent();
                    int i15 = 0;
                    do {
                        content3[i15].done(derivedState);
                        i15++;
                    } while (i15 < size3);
                }
                throw th;
            }
        }

        public void setDependencies(ObjectIntMap<StateObject> objectIntMap) {
            this.dependencies = objectIntMap;
        }

        public final void setResult(Object obj) {
            this.result = obj;
        }

        public final void setResultHash(int i5) {
            this.resultHash = i5;
        }

        public final void setValidSnapshotId(int i5) {
            this.validSnapshotId = i5;
        }

        public final void setValidSnapshotWriteCount(int i5) {
            this.validSnapshotWriteCount = i5;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DerivedState(Function0<? extends T> function0, SnapshotMutationPolicy<T> snapshotMutationPolicy) {
        this.calculation = function0;
        this.policy = snapshotMutationPolicy;
    }

    /* JADX WARN: Finally extract failed */
    /* JADX WARN: Multi-variable type inference failed */
    private final ResultRecord<T> currentRecord(ResultRecord<T> readable, Snapshot snapshot, boolean forceDependencyReads, Function0<? extends T> calculation) {
        SnapshotThreadLocal snapshotThreadLocal;
        Snapshot.Companion companion;
        SnapshotThreadLocal snapshotThreadLocal2;
        SnapshotMutationPolicy<T> policy;
        SnapshotThreadLocal snapshotThreadLocal3;
        SnapshotThreadLocal snapshotThreadLocal4;
        int i5;
        int i6;
        SnapshotThreadLocal snapshotThreadLocal5;
        ResultRecord<T> resultRecord = readable;
        int i7 = 1;
        if (!resultRecord.isValid(this, snapshot)) {
            int i8 = 0;
            final MutableObjectIntMap mutableObjectIntMap = new MutableObjectIntMap(0, 1, null);
            snapshotThreadLocal = SnapshotStateKt__DerivedStateKt.calculationBlockNestedLevel;
            final IntRef intRef = (IntRef) snapshotThreadLocal.get();
            if (intRef == null) {
                intRef = new IntRef(0);
                snapshotThreadLocal3 = SnapshotStateKt__DerivedStateKt.calculationBlockNestedLevel;
                snapshotThreadLocal3.set(intRef);
            }
            final int element = intRef.getElement();
            MutableVector<DerivedStateObserver> derivedStateObservers = SnapshotStateKt.derivedStateObservers();
            int size = derivedStateObservers.getSize();
            if (size > 0) {
                DerivedStateObserver[] content = derivedStateObservers.getContent();
                int i9 = 0;
                while (true) {
                    content[i9].start(this);
                    int i10 = i9 + 1;
                    if (i10 >= size) {
                        break;
                    }
                    i9 = i10;
                }
            }
            try {
                intRef.setElement(element + 1);
                Object observe = Snapshot.INSTANCE.observe(new Function1<Object, Unit>(this) { // from class: androidx.compose.runtime.DerivedSnapshotState$currentRecord$result$1$1$result$1
                    final /* synthetic */ DerivedState<T> this$0;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                        this.this$0 = this;
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
                        invoke2(obj);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Object obj) {
                        if (obj != this.this$0) {
                            if (obj instanceof StateObject) {
                                int element2 = intRef.getElement();
                                MutableObjectIntMap<StateObject> mutableObjectIntMap2 = mutableObjectIntMap;
                                mutableObjectIntMap2.set(obj, Math.min(element2 - element, mutableObjectIntMap2.getOrDefault(obj, Integer.MAX_VALUE)));
                                return;
                            }
                            return;
                        }
                        throw new IllegalStateException("A derived state calculation cannot read itself");
                    }
                }, null, calculation);
                intRef.setElement(element);
                int size2 = derivedStateObservers.getSize();
                if (size2 > 0) {
                    DerivedStateObserver[] content2 = derivedStateObservers.getContent();
                    do {
                        content2[i8].done(this);
                        i8++;
                    } while (i8 < size2);
                }
                synchronized (SnapshotKt.getLock()) {
                    try {
                        companion = Snapshot.INSTANCE;
                        Snapshot current = companion.getCurrent();
                        if (readable.getResult() == ResultRecord.INSTANCE.getUnset() || (policy = getPolicy()) == 0 || !policy.equivalent(observe, readable.getResult())) {
                            resultRecord = (ResultRecord) SnapshotKt.newWritableRecord(this.first, this, current);
                            resultRecord.setDependencies(mutableObjectIntMap);
                            resultRecord.setResultHash(resultRecord.readableHash(this, current));
                            resultRecord.setResult(observe);
                        } else {
                            resultRecord.setDependencies(mutableObjectIntMap);
                            resultRecord.setResultHash(resultRecord.readableHash(this, current));
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                snapshotThreadLocal2 = SnapshotStateKt__DerivedStateKt.calculationBlockNestedLevel;
                IntRef intRef2 = (IntRef) snapshotThreadLocal2.get();
                if (intRef2 != null && intRef2.getElement() == 0) {
                    companion.notifyObjectsInitialized();
                    synchronized (SnapshotKt.getLock()) {
                        Snapshot current2 = companion.getCurrent();
                        resultRecord.setValidSnapshotId(current2.getId());
                        resultRecord.setValidSnapshotWriteCount(current2.getWriteCount());
                        Unit unit = Unit.INSTANCE;
                    }
                }
                return resultRecord;
            } catch (Throwable th2) {
                int size3 = derivedStateObservers.getSize();
                if (size3 > 0) {
                    DerivedStateObserver[] content3 = derivedStateObservers.getContent();
                    do {
                        content3[i8].done(this);
                        i8++;
                    } while (i8 < size3);
                }
                throw th2;
            }
        }
        if (forceDependencyReads) {
            MutableVector<DerivedStateObserver> derivedStateObservers2 = SnapshotStateKt.derivedStateObservers();
            int size4 = derivedStateObservers2.getSize();
            if (size4 > 0) {
                DerivedStateObserver[] content4 = derivedStateObservers2.getContent();
                int i11 = 0;
                do {
                    content4[i11].start(this);
                    i11++;
                } while (i11 < size4);
            }
            try {
                ObjectIntMap<StateObject> dependencies = readable.getDependencies();
                snapshotThreadLocal4 = SnapshotStateKt__DerivedStateKt.calculationBlockNestedLevel;
                IntRef intRef3 = (IntRef) snapshotThreadLocal4.get();
                if (intRef3 == null) {
                    intRef3 = new IntRef(0);
                    snapshotThreadLocal5 = SnapshotStateKt__DerivedStateKt.calculationBlockNestedLevel;
                    snapshotThreadLocal5.set(intRef3);
                }
                int element2 = intRef3.getElement();
                Object[] objArr = dependencies.keys;
                int[] iArr = dependencies.values;
                long[] jArr = dependencies.metadata;
                int length = jArr.length - 2;
                if (length >= 0) {
                    int i12 = 0;
                    while (true) {
                        long j5 = jArr[i12];
                        long[] jArr2 = jArr;
                        if ((((~j5) << 7) & j5 & (-9187201950435737472L)) != -9187201950435737472L) {
                            int i13 = 8;
                            int i14 = 8 - ((~(i12 - length)) >>> 31);
                            int i15 = 0;
                            while (i15 < i14) {
                                if ((j5 & 255) < 128) {
                                    int i16 = (i12 << 3) + i15;
                                    StateObject stateObject = (StateObject) objArr[i16];
                                    intRef3.setElement(element2 + iArr[i16]);
                                    Function1<Object, Unit> readObserver = snapshot.getReadObserver();
                                    if (readObserver != null) {
                                        readObserver.invoke(stateObject);
                                    }
                                    i6 = 8;
                                } else {
                                    i6 = i13;
                                }
                                j5 >>= i6;
                                i15++;
                                i13 = i6;
                                i7 = 1;
                            }
                            int i17 = i13;
                            i5 = i7;
                            if (i14 != i17) {
                                break;
                            }
                        } else {
                            i5 = i7;
                        }
                        if (i12 == length) {
                            break;
                        }
                        i12 += i5;
                        i7 = i5;
                        jArr = jArr2;
                    }
                }
                intRef3.setElement(element2);
                Unit unit2 = Unit.INSTANCE;
                int size5 = derivedStateObservers2.getSize();
                if (size5 > 0) {
                    DerivedStateObserver[] content5 = derivedStateObservers2.getContent();
                    int i18 = 0;
                    do {
                        content5[i18].done(this);
                        i18++;
                    } while (i18 < size5);
                }
            } catch (Throwable th3) {
                int size6 = derivedStateObservers2.getSize();
                if (size6 > 0) {
                    DerivedStateObserver[] content6 = derivedStateObservers2.getContent();
                    int i19 = 0;
                    do {
                        content6[i19].done(this);
                        i19++;
                    } while (i19 < size6);
                }
                throw th3;
            }
        }
        return resultRecord;
    }

    private final String displayValue() {
        ResultRecord resultRecord = (ResultRecord) SnapshotKt.current(this.first);
        return resultRecord.isValid(this, Snapshot.INSTANCE.getCurrent()) ? String.valueOf(resultRecord.getResult()) : "<Not calculated>";
    }

    public final StateRecord current(Snapshot snapshot) {
        return currentRecord((ResultRecord) SnapshotKt.current(this.first, snapshot), snapshot, false, this.calculation);
    }

    @Override // androidx.compose.runtime.DerivedState
    public DerivedState.Record<T> getCurrentRecord() {
        Snapshot current = Snapshot.INSTANCE.getCurrent();
        return currentRecord((ResultRecord) SnapshotKt.current(this.first, current), current, false, this.calculation);
    }

    @Override // androidx.compose.runtime.snapshots.StateObject
    public StateRecord getFirstStateRecord() {
        return this.first;
    }

    @Override // androidx.compose.runtime.DerivedState
    public SnapshotMutationPolicy<T> getPolicy() {
        return this.policy;
    }

    @Override // androidx.compose.runtime.State
    public T getValue() {
        Snapshot.Companion companion = Snapshot.INSTANCE;
        Function1<Object, Unit> readObserver = companion.getCurrent().getReadObserver();
        if (readObserver != null) {
            readObserver.invoke(this);
        }
        Snapshot current = companion.getCurrent();
        return (T) currentRecord((ResultRecord) SnapshotKt.current(this.first, current), current, true, this.calculation).getResult();
    }

    @Override // androidx.compose.runtime.snapshots.StateObject
    public void prependStateRecord(StateRecord value) {
        Intrinsics.checkNotNull(value, "null cannot be cast to non-null type androidx.compose.runtime.DerivedSnapshotState.ResultRecord<T of androidx.compose.runtime.DerivedSnapshotState>");
        this.first = (ResultRecord) value;
    }

    public String toString() {
        return "DerivedState(value=" + displayValue() + ")@" + hashCode();
    }
}
