package androidx.compose.runtime.snapshots;

import androidx.collection.MutableObjectIntMap;
import androidx.collection.MutableScatterMap;
import androidx.collection.MutableScatterSet;
import androidx.collection.ObjectIntMap;
import androidx.collection.ScatterSet;
import androidx.compose.runtime.ActualJvm_jvmKt;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DerivedState;
import androidx.compose.runtime.DerivedStateObserver;
import androidx.compose.runtime.PreconditionsKt;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.collection.ScatterSetWrapper;
import androidx.compose.runtime.collection.ScopeMap;
import androidx.compose.runtime.snapshots.SnapshotStateObserver;
import e.AbstractC0321h;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\"\n\u0002\b\u0005\n\u0002\u0010\u0001\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001:\u0001>B!\u0012\u0018\u0010\u0005\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0004\u0012\u00020\u00040\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u000f\u001a\u00020\u00042\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00010\rH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\rH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0014\u0010\u0015J-\u0010\u0019\u001a\u00020\u0018\"\b\b\u0000\u0010\u0016*\u00020\u00012\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00040\u0002H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJA\u0010\u001e\u001a\u00020\u0004\"\b\b\u0000\u0010\u0016*\u00020\u00012\u0006\u0010\u001b\u001a\u00028\u00002\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00040\u00022\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u001e\u0010\u001fJ\u0015\u0010 \u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u0001¢\u0006\u0004\b \u0010!J!\u0010#\u001a\u00020\u00042\u0012\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\b0\u0002¢\u0006\u0004\b#\u0010\u0007J\r\u0010$\u001a\u00020\u0004¢\u0006\u0004\b$\u0010\fJ\r\u0010%\u001a\u00020\u0004¢\u0006\u0004\b%\u0010\fJ\r\u0010 \u001a\u00020\u0004¢\u0006\u0004\b \u0010\fR&\u0010\u0005\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0004\u0012\u00020\u00040\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010&R(\u0010)\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u00010'j\n\u0012\u0006\u0012\u0004\u0018\u00010\u0001`(8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010+\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010,R,\u0010/\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\r\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020\u00040-8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b/\u00100R \u00101\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00040\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b1\u0010&R\u001a\u00103\u001a\b\u0012\u0004\u0012\u00020\u0018028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b3\u00104R\u0018\u00106\u001a\u0004\u0018\u0001058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u00107R\u0016\u00108\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b8\u0010,R\u0018\u00109\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010<\u001a\u00020;8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b<\u0010=¨\u0006?"}, d2 = {"Landroidx/compose/runtime/snapshots/SnapshotStateObserver;", BuildConfig.FLAVOR, "Lkotlin/Function1;", "Lkotlin/Function0;", BuildConfig.FLAVOR, "onChangedExecutor", "<init>", "(Lkotlin/jvm/functions/Function1;)V", BuildConfig.FLAVOR, "drainChanges", "()Z", "sendNotifications", "()V", BuildConfig.FLAVOR, "set", "addChanges", "(Ljava/util/Set;)V", "removeChanges", "()Ljava/util/Set;", BuildConfig.FLAVOR, "report", "()Ljava/lang/Void;", "T", "onChanged", "Landroidx/compose/runtime/snapshots/SnapshotStateObserver$ObservedScopeMap;", "ensureMap", "(Lkotlin/jvm/functions/Function1;)Landroidx/compose/runtime/snapshots/SnapshotStateObserver$ObservedScopeMap;", "scope", "onValueChangedForScope", "block", "observeReads", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)V", "clear", "(Ljava/lang/Object;)V", "predicate", "clearIf", "start", "stop", "Lkotlin/jvm/functions/Function1;", "Ljava/util/concurrent/atomic/AtomicReference;", "Landroidx/compose/runtime/AtomicReference;", "pendingChanges", "Ljava/util/concurrent/atomic/AtomicReference;", "sendingNotifications", "Z", "Lkotlin/Function2;", "Landroidx/compose/runtime/snapshots/Snapshot;", "applyObserver", "Lkotlin/jvm/functions/Function2;", "readObserver", "Landroidx/compose/runtime/collection/MutableVector;", "observedScopeMaps", "Landroidx/compose/runtime/collection/MutableVector;", "Landroidx/compose/runtime/snapshots/ObserverHandle;", "applyUnsubscribe", "Landroidx/compose/runtime/snapshots/ObserverHandle;", "isPaused", "currentMap", "Landroidx/compose/runtime/snapshots/SnapshotStateObserver$ObservedScopeMap;", BuildConfig.FLAVOR, "currentMapThreadId", "J", "ObservedScopeMap", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SnapshotStateObserver {
    public static final int $stable = 8;
    private ObserverHandle applyUnsubscribe;
    private ObservedScopeMap currentMap;
    private boolean isPaused;
    private final Function1<Function0<Unit>, Unit> onChangedExecutor;
    private boolean sendingNotifications;
    private final AtomicReference<Object> pendingChanges = new AtomicReference<>(null);
    private final Function2<Set<? extends Object>, Snapshot, Unit> applyObserver = new Function2<Set<? extends Object>, Snapshot, Unit>() { // from class: androidx.compose.runtime.snapshots.SnapshotStateObserver$applyObserver$1
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Set<? extends Object> set, Snapshot snapshot) {
            invoke2(set, snapshot);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Set<? extends Object> set, Snapshot snapshot) {
            boolean drainChanges;
            SnapshotStateObserver.this.addChanges(set);
            drainChanges = SnapshotStateObserver.this.drainChanges();
            if (drainChanges) {
                SnapshotStateObserver.this.sendNotifications();
            }
        }
    };
    private final Function1<Object, Unit> readObserver = new Function1<Object, Unit>() { // from class: androidx.compose.runtime.snapshots.SnapshotStateObserver$readObserver$1
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
            boolean z5;
            MutableVector mutableVector;
            SnapshotStateObserver.ObservedScopeMap observedScopeMap;
            z5 = SnapshotStateObserver.this.isPaused;
            if (z5) {
                return;
            }
            mutableVector = SnapshotStateObserver.this.observedScopeMaps;
            SnapshotStateObserver snapshotStateObserver = SnapshotStateObserver.this;
            synchronized (mutableVector) {
                observedScopeMap = snapshotStateObserver.currentMap;
                Intrinsics.checkNotNull(observedScopeMap);
                observedScopeMap.recordRead(obj);
                Unit unit = Unit.INSTANCE;
            }
        }
    };
    private final MutableVector<ObservedScopeMap> observedScopeMaps = new MutableVector<>(new ObservedScopeMap[16], 0);
    private long currentMapThreadId = -1;

    /* JADX WARN: Multi-variable type inference failed */
    public SnapshotStateObserver(Function1<? super Function0<Unit>, Unit> function1) {
        this.onChangedExecutor = function1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void addChanges(Set<? extends Object> set) {
        Object obj;
        List plus;
        do {
            obj = this.pendingChanges.get();
            if (obj == null) {
                plus = set;
            } else if (obj instanceof Set) {
                plus = CollectionsKt.listOf((Object[]) new Set[]{obj, set});
            } else {
                if (!(obj instanceof List)) {
                    report();
                    throw new KotlinNothingValueException();
                }
                plus = CollectionsKt.plus((Collection) obj, (Iterable) CollectionsKt.listOf(set));
            }
        } while (!AbstractC0321h.a(this.pendingChanges, obj, plus));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean drainChanges() {
        boolean z5;
        synchronized (this.observedScopeMaps) {
            z5 = this.sendingNotifications;
        }
        if (z5) {
            return false;
        }
        boolean z6 = false;
        while (true) {
            Set<? extends Object> removeChanges = removeChanges();
            if (removeChanges == null) {
                return z6;
            }
            synchronized (this.observedScopeMaps) {
                try {
                    MutableVector<ObservedScopeMap> mutableVector = this.observedScopeMaps;
                    int size = mutableVector.getSize();
                    if (size > 0) {
                        ObservedScopeMap[] content = mutableVector.getContent();
                        int i5 = 0;
                        do {
                            if (!content[i5].recordInvalidation(removeChanges) && !z6) {
                                z6 = false;
                                i5++;
                            }
                            z6 = true;
                            i5++;
                        } while (i5 < size);
                    }
                    Unit unit = Unit.INSTANCE;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    private final <T> ObservedScopeMap ensureMap(Function1<? super T, Unit> onChanged) {
        ObservedScopeMap observedScopeMap;
        MutableVector<ObservedScopeMap> mutableVector = this.observedScopeMaps;
        int size = mutableVector.getSize();
        if (size > 0) {
            ObservedScopeMap[] content = mutableVector.getContent();
            int i5 = 0;
            do {
                observedScopeMap = content[i5];
                if (observedScopeMap.getOnChanged() == onChanged) {
                    break;
                }
                i5++;
            } while (i5 < size);
        }
        observedScopeMap = null;
        ObservedScopeMap observedScopeMap2 = observedScopeMap;
        if (observedScopeMap2 != null) {
            return observedScopeMap2;
        }
        Intrinsics.checkNotNull(onChanged, "null cannot be cast to non-null type kotlin.Function1<kotlin.Any, kotlin.Unit>");
        ObservedScopeMap observedScopeMap3 = new ObservedScopeMap((Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(onChanged, 1));
        this.observedScopeMaps.add(observedScopeMap3);
        return observedScopeMap3;
    }

    private final Set<Object> removeChanges() {
        Object obj;
        Object obj2;
        Set<Object> set;
        do {
            obj = this.pendingChanges.get();
            obj2 = null;
            if (obj == null) {
                return null;
            }
            if (obj instanceof Set) {
                set = (Set) obj;
            } else {
                if (!(obj instanceof List)) {
                    report();
                    throw new KotlinNothingValueException();
                }
                List list = (List) obj;
                Set<Object> set2 = (Set) list.get(0);
                if (list.size() == 2) {
                    obj2 = list.get(1);
                } else if (list.size() > 2) {
                    obj2 = list.subList(1, list.size());
                }
                set = set2;
            }
        } while (!AbstractC0321h.a(this.pendingChanges, obj, obj2));
        return set;
    }

    private final Void report() {
        ComposerKt.composeRuntimeError("Unexpected notification");
        throw new KotlinNothingValueException();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void sendNotifications() {
        this.onChangedExecutor.invoke(new Function0<Unit>() { // from class: androidx.compose.runtime.snapshots.SnapshotStateObserver$sendNotifications$1
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
                MutableVector mutableVector;
                boolean z5;
                boolean drainChanges;
                MutableVector mutableVector2;
                do {
                    mutableVector = SnapshotStateObserver.this.observedScopeMaps;
                    SnapshotStateObserver snapshotStateObserver = SnapshotStateObserver.this;
                    synchronized (mutableVector) {
                        try {
                            z5 = snapshotStateObserver.sendingNotifications;
                            if (!z5) {
                                snapshotStateObserver.sendingNotifications = true;
                                try {
                                    mutableVector2 = snapshotStateObserver.observedScopeMaps;
                                    int size = mutableVector2.getSize();
                                    if (size > 0) {
                                        Object[] content = mutableVector2.getContent();
                                        int i5 = 0;
                                        do {
                                            ((SnapshotStateObserver.ObservedScopeMap) content[i5]).notifyInvalidatedScopes();
                                            i5++;
                                        } while (i5 < size);
                                    }
                                    snapshotStateObserver.sendingNotifications = false;
                                } finally {
                                }
                            }
                            Unit unit = Unit.INSTANCE;
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                    drainChanges = SnapshotStateObserver.this.drainChanges();
                } while (drainChanges);
            }
        });
    }

    public final void clear(Object scope) {
        synchronized (this.observedScopeMaps) {
            try {
                MutableVector<ObservedScopeMap> mutableVector = this.observedScopeMaps;
                int size = mutableVector.getSize();
                int i5 = 0;
                for (int i6 = 0; i6 < size; i6++) {
                    ObservedScopeMap observedScopeMap = mutableVector.getContent()[i6];
                    observedScopeMap.clearScopeObservations(scope);
                    if (!observedScopeMap.hasScopeObservations()) {
                        i5++;
                    } else if (i5 > 0) {
                        mutableVector.getContent()[i6 - i5] = mutableVector.getContent()[i6];
                    }
                }
                int i7 = size - i5;
                ArraysKt.fill(mutableVector.getContent(), (Object) null, i7, size);
                mutableVector.setSize(i7);
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void clearIf(Function1<Object, Boolean> predicate) {
        synchronized (this.observedScopeMaps) {
            try {
                MutableVector<ObservedScopeMap> mutableVector = this.observedScopeMaps;
                int size = mutableVector.getSize();
                int i5 = 0;
                for (int i6 = 0; i6 < size; i6++) {
                    ObservedScopeMap observedScopeMap = mutableVector.getContent()[i6];
                    observedScopeMap.removeScopeIf(predicate);
                    if (!observedScopeMap.hasScopeObservations()) {
                        i5++;
                    } else if (i5 > 0) {
                        mutableVector.getContent()[i6 - i5] = mutableVector.getContent()[i6];
                    }
                }
                int i7 = size - i5;
                ArraysKt.fill(mutableVector.getContent(), (Object) null, i7, size);
                mutableVector.setSize(i7);
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final <T> void observeReads(T scope, Function1<? super T, Unit> onValueChangedForScope, Function0<Unit> block) {
        ObservedScopeMap ensureMap;
        synchronized (this.observedScopeMaps) {
            ensureMap = ensureMap(onValueChangedForScope);
        }
        boolean z5 = this.isPaused;
        ObservedScopeMap observedScopeMap = this.currentMap;
        long j5 = this.currentMapThreadId;
        if (j5 != -1) {
            if (!(j5 == ActualJvm_jvmKt.currentThreadId())) {
                PreconditionsKt.throwIllegalArgumentException("Detected multithreaded access to SnapshotStateObserver: previousThreadId=" + j5 + "), currentThread={id=" + ActualJvm_jvmKt.currentThreadId() + ", name=" + ActualJvm_jvmKt.currentThreadName() + "}. Note that observation on multiple threads in layout/draw is not supported. Make sure your measure/layout/draw for each Owner (AndroidComposeView) is executed on the same thread.");
            }
        }
        try {
            this.isPaused = false;
            this.currentMap = ensureMap;
            this.currentMapThreadId = ActualJvm_jvmKt.currentThreadId();
            ensureMap.observe(scope, this.readObserver, block);
        } finally {
            this.currentMap = observedScopeMap;
            this.isPaused = z5;
            this.currentMapThreadId = j5;
        }
    }

    public final void start() {
        this.applyUnsubscribe = Snapshot.INSTANCE.registerApplyObserver(this.applyObserver);
    }

    public final void stop() {
        ObserverHandle observerHandle = this.applyUnsubscribe;
        if (observerHandle != null) {
            observerHandle.dispose();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u001b\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0005\u0010\u0006J5\u0010\r\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00010\u000bH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\r\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0001¢\u0006\u0004\b\r\u0010\u0011J7\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00012\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00030\u0015¢\u0006\u0004\b\u0017\u0010\u0018J\u0015\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0001¢\u0006\u0004\b\u0019\u0010\u0011J!\u0010\u001c\u001a\u00020\u00032\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u001a0\u0002¢\u0006\u0004\b\u001c\u0010\u0006J\r\u0010\u001d\u001a\u00020\u001a¢\u0006\u0004\b\u001d\u0010\u001eJ\r\u0010\u001f\u001a\u00020\u0003¢\u0006\u0004\b\u001f\u0010 J\u001b\u0010#\u001a\u00020\u001a2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00010!¢\u0006\u0004\b#\u0010$J\u0019\u0010'\u001a\u00020\u00032\n\u0010&\u001a\u0006\u0012\u0002\b\u00030%¢\u0006\u0004\b'\u0010(J\r\u0010)\u001a\u00020\u0003¢\u0006\u0004\b)\u0010 R#\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010*\u001a\u0004\b+\u0010,R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\n\u0010-R\u001e\u0010.\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010/R\u0016\u0010\t\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\t\u00100R \u00102\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0001018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b2\u00103R&\u00105\u001a\u0014\u0012\u0004\u0012\u00020\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u000b048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b5\u00106R\u001a\u00108\u001a\b\u0012\u0004\u0012\u00020\u0001078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b8\u00109R\u001e\u0010;\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030%0:8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b;\u0010<R\u0017\u0010>\u001a\u00020=8\u0006¢\u0006\f\n\u0004\b>\u0010?\u001a\u0004\b@\u0010AR\u0016\u0010B\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bB\u00100R$\u0010C\u001a\u0012\u0012\u0004\u0012\u00020\u0001\u0012\b\u0012\u0006\u0012\u0002\b\u00030%018\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bC\u00103R<\u0010F\u001a*\u0012\b\u0012\u0006\u0012\u0002\b\u00030%\u0012\u0006\u0012\u0004\u0018\u00010\u00010Dj\u0014\u0012\b\u0012\u0006\u0012\u0002\b\u00030%\u0012\u0006\u0012\u0004\u0018\u00010\u0001`E8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bF\u0010G¨\u0006H"}, d2 = {"Landroidx/compose/runtime/snapshots/SnapshotStateObserver$ObservedScopeMap;", BuildConfig.FLAVOR, "Lkotlin/Function1;", BuildConfig.FLAVOR, "onChanged", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "value", BuildConfig.FLAVOR, "currentToken", "currentScope", "Landroidx/collection/MutableObjectIntMap;", "recordedValues", "recordRead", "(Ljava/lang/Object;ILjava/lang/Object;Landroidx/collection/MutableObjectIntMap;)V", "scope", "clearObsoleteStateReads", "(Ljava/lang/Object;)V", "removeObservation", "(Ljava/lang/Object;Ljava/lang/Object;)V", "readObserver", "Lkotlin/Function0;", "block", "observe", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)V", "clearScopeObservations", BuildConfig.FLAVOR, "predicate", "removeScopeIf", "hasScopeObservations", "()Z", "clear", "()V", BuildConfig.FLAVOR, "changes", "recordInvalidation", "(Ljava/util/Set;)Z", "Landroidx/compose/runtime/DerivedState;", "derivedState", "rereadDerivedState", "(Landroidx/compose/runtime/DerivedState;)V", "notifyInvalidatedScopes", "Lkotlin/jvm/functions/Function1;", "getOnChanged", "()Lkotlin/jvm/functions/Function1;", "Ljava/lang/Object;", "currentScopeReads", "Landroidx/collection/MutableObjectIntMap;", "I", "Landroidx/compose/runtime/collection/ScopeMap;", "valueToScopes", "Landroidx/compose/runtime/collection/ScopeMap;", "Landroidx/collection/MutableScatterMap;", "scopeToValues", "Landroidx/collection/MutableScatterMap;", "Landroidx/collection/MutableScatterSet;", "invalidated", "Landroidx/collection/MutableScatterSet;", "Landroidx/compose/runtime/collection/MutableVector;", "statesToReread", "Landroidx/compose/runtime/collection/MutableVector;", "Landroidx/compose/runtime/DerivedStateObserver;", "derivedStateObserver", "Landroidx/compose/runtime/DerivedStateObserver;", "getDerivedStateObserver", "()Landroidx/compose/runtime/DerivedStateObserver;", "deriveStateScopeCount", "dependencyToDerivedStates", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "recordedDerivedStateValues", "Ljava/util/HashMap;", "runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class ObservedScopeMap {
        private Object currentScope;
        private MutableObjectIntMap<Object> currentScopeReads;
        private int deriveStateScopeCount;
        private final Function1<Object, Unit> onChanged;
        private int currentToken = -1;
        private final ScopeMap<Object, Object> valueToScopes = new ScopeMap<>();
        private final MutableScatterMap<Object, MutableObjectIntMap<Object>> scopeToValues = new MutableScatterMap<>(0, 1, null);
        private final MutableScatterSet<Object> invalidated = new MutableScatterSet<>(0, 1, null);
        private final MutableVector<DerivedState<?>> statesToReread = new MutableVector<>(new DerivedState[16], 0);
        private final DerivedStateObserver derivedStateObserver = new DerivedStateObserver() { // from class: androidx.compose.runtime.snapshots.SnapshotStateObserver$ObservedScopeMap$derivedStateObserver$1
            @Override // androidx.compose.runtime.DerivedStateObserver
            public void done(DerivedState<?> derivedState) {
                int i5;
                SnapshotStateObserver.ObservedScopeMap observedScopeMap = SnapshotStateObserver.ObservedScopeMap.this;
                i5 = observedScopeMap.deriveStateScopeCount;
                observedScopeMap.deriveStateScopeCount = i5 - 1;
            }

            @Override // androidx.compose.runtime.DerivedStateObserver
            public void start(DerivedState<?> derivedState) {
                int i5;
                SnapshotStateObserver.ObservedScopeMap observedScopeMap = SnapshotStateObserver.ObservedScopeMap.this;
                i5 = observedScopeMap.deriveStateScopeCount;
                observedScopeMap.deriveStateScopeCount = i5 + 1;
            }
        };
        private final ScopeMap<Object, DerivedState<?>> dependencyToDerivedStates = new ScopeMap<>();
        private final HashMap<DerivedState<?>, Object> recordedDerivedStateValues = new HashMap<>();

        public ObservedScopeMap(Function1<Object, Unit> function1) {
            this.onChanged = function1;
        }

        private final void clearObsoleteStateReads(Object scope) {
            int i5 = this.currentToken;
            MutableObjectIntMap<Object> mutableObjectIntMap = this.currentScopeReads;
            if (mutableObjectIntMap == null) {
                return;
            }
            long[] jArr = mutableObjectIntMap.metadata;
            int length = jArr.length - 2;
            if (length < 0) {
                return;
            }
            int i6 = 0;
            while (true) {
                long j5 = jArr[i6];
                if ((((~j5) << 7) & j5 & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i7 = 8 - ((~(i6 - length)) >>> 31);
                    for (int i8 = 0; i8 < i7; i8++) {
                        if ((255 & j5) < 128) {
                            int i9 = (i6 << 3) + i8;
                            Object obj = mutableObjectIntMap.keys[i9];
                            boolean z5 = mutableObjectIntMap.values[i9] != i5;
                            if (z5) {
                                removeObservation(scope, obj);
                            }
                            if (z5) {
                                mutableObjectIntMap.removeValueAt(i9);
                            }
                        }
                        j5 >>= 8;
                    }
                    if (i7 != 8) {
                        return;
                    }
                }
                if (i6 == length) {
                    return;
                } else {
                    i6++;
                }
            }
        }

        private final void removeObservation(Object scope, Object value) {
            this.valueToScopes.remove(value, scope);
            if (!(value instanceof DerivedState) || this.valueToScopes.contains(value)) {
                return;
            }
            this.dependencyToDerivedStates.removeScope(value);
            this.recordedDerivedStateValues.remove(value);
        }

        public final void clear() {
            this.valueToScopes.clear();
            this.scopeToValues.clear();
            this.dependencyToDerivedStates.clear();
            this.recordedDerivedStateValues.clear();
        }

        public final void clearScopeObservations(Object scope) {
            MutableObjectIntMap<Object> remove = this.scopeToValues.remove(scope);
            if (remove == null) {
                return;
            }
            Object[] objArr = remove.keys;
            int[] iArr = remove.values;
            long[] jArr = remove.metadata;
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
                            int i8 = (i5 << 3) + i7;
                            Object obj = objArr[i8];
                            int i9 = iArr[i8];
                            removeObservation(scope, obj);
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

        public final Function1<Object, Unit> getOnChanged() {
            return this.onChanged;
        }

        public final boolean hasScopeObservations() {
            return this.scopeToValues.isNotEmpty();
        }

        public final void notifyInvalidatedScopes() {
            MutableScatterSet<Object> mutableScatterSet = this.invalidated;
            Function1<Object, Unit> function1 = this.onChanged;
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
                                function1.invoke(objArr[(i5 << 3) + i7]);
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
            mutableScatterSet.clear();
        }

        public final void observe(Object scope, Function1<Object, Unit> readObserver, Function0<Unit> block) {
            Object obj = this.currentScope;
            MutableObjectIntMap<Object> mutableObjectIntMap = this.currentScopeReads;
            int i5 = this.currentToken;
            this.currentScope = scope;
            this.currentScopeReads = this.scopeToValues.get(scope);
            if (this.currentToken == -1) {
                this.currentToken = SnapshotKt.currentSnapshot().getId();
            }
            DerivedStateObserver derivedStateObserver = this.derivedStateObserver;
            MutableVector<DerivedStateObserver> derivedStateObservers = SnapshotStateKt.derivedStateObservers();
            try {
                derivedStateObservers.add(derivedStateObserver);
                Snapshot.INSTANCE.observe(readObserver, null, block);
                derivedStateObservers.removeAt(derivedStateObservers.getSize() - 1);
                Object obj2 = this.currentScope;
                Intrinsics.checkNotNull(obj2);
                clearObsoleteStateReads(obj2);
                this.currentScope = obj;
                this.currentScopeReads = mutableObjectIntMap;
                this.currentToken = i5;
            } catch (Throwable th) {
                derivedStateObservers.removeAt(derivedStateObservers.getSize() - 1);
                throw th;
            }
        }

        public final boolean recordInvalidation(Set<? extends Object> changes) {
            boolean z5;
            Iterator it;
            HashMap<DerivedState<?>, Object> hashMap;
            Object obj;
            String str;
            int i5;
            char c5;
            Object obj2;
            char c6;
            HashMap<DerivedState<?>, Object> hashMap2;
            long[] jArr;
            Object[] objArr;
            Iterator it2;
            HashMap<DerivedState<?>, Object> hashMap3;
            Object obj3;
            ScopeMap<Object, DerivedState<?>> scopeMap;
            long[] jArr2;
            Object[] objArr2;
            int i6;
            String str2;
            long[] jArr3;
            long[] jArr4;
            char c7;
            long[] jArr5;
            ScopeMap<Object, DerivedState<?>> scopeMap2;
            HashMap<DerivedState<?>, Object> hashMap4;
            ScopeMap<Object, Object> scopeMap3;
            Object[] objArr3;
            String str3;
            int i7;
            long[] jArr6;
            ScopeMap<Object, DerivedState<?>> scopeMap4;
            HashMap<DerivedState<?>, Object> hashMap5;
            ScopeMap<Object, Object> scopeMap5;
            Object[] objArr4;
            String str4;
            int i8;
            int i9;
            long j5;
            int i10;
            Object obj4;
            char c8;
            Object obj5;
            char c9;
            HashMap<DerivedState<?>, Object> hashMap6;
            Object[] objArr5;
            ScopeMap<Object, DerivedState<?>> scopeMap6;
            HashMap<DerivedState<?>, Object> hashMap7;
            ScopeMap<Object, Object> scopeMap7;
            String str5;
            long j6;
            Object obj6;
            Object[] objArr6;
            ScopeMap<Object, Object> scopeMap8;
            char c10;
            ScopeMap<Object, DerivedState<?>> scopeMap9 = this.dependencyToDerivedStates;
            HashMap<DerivedState<?>, Object> hashMap8 = this.recordedDerivedStateValues;
            ScopeMap<Object, Object> scopeMap10 = this.valueToScopes;
            MutableScatterSet<Object> mutableScatterSet = this.invalidated;
            String str6 = "null cannot be cast to non-null type androidx.compose.runtime.DerivedState<kotlin.Any?>";
            char c11 = 7;
            long j7 = -9187201950435737472L;
            int i11 = 0;
            if (changes instanceof ScatterSetWrapper) {
                ScatterSet set$runtime_release = ((ScatterSetWrapper) changes).getSet$runtime_release();
                Object[] objArr7 = set$runtime_release.elements;
                long[] jArr7 = set$runtime_release.metadata;
                int length = jArr7.length - 2;
                if (length >= 0) {
                    int i12 = 0;
                    z5 = false;
                    while (true) {
                        long j8 = jArr7[i12];
                        int i13 = length;
                        if ((((~j8) << c11) & j8 & j7) != j7) {
                            int i14 = 8 - ((~(i12 - i13)) >>> 31);
                            int i15 = 0;
                            while (i15 < i14) {
                                if ((j8 & 255) < 128) {
                                    Object obj7 = objArr7[(i12 << 3) + i15];
                                    if (!(obj7 instanceof StateObjectImpl) || ((StateObjectImpl) obj7).m1249isReadInh_f27i8$runtime_release(ReaderKind.m1248constructorimpl(2))) {
                                        if (!scopeMap9.contains(obj7) || (obj5 = scopeMap9.getMap().get(obj7)) == null) {
                                            jArr6 = jArr7;
                                            scopeMap4 = scopeMap9;
                                            hashMap5 = hashMap8;
                                            scopeMap5 = scopeMap10;
                                            objArr4 = objArr7;
                                            str4 = str6;
                                            i8 = i14;
                                            i9 = i15;
                                            j5 = j8;
                                            i10 = i12;
                                            obj4 = obj7;
                                        } else if (obj5 instanceof MutableScatterSet) {
                                            MutableScatterSet mutableScatterSet2 = (MutableScatterSet) obj5;
                                            Object[] objArr8 = mutableScatterSet2.elements;
                                            long[] jArr8 = mutableScatterSet2.metadata;
                                            jArr6 = jArr7;
                                            int length2 = jArr8.length - 2;
                                            if (length2 >= 0) {
                                                objArr4 = objArr7;
                                                i8 = i14;
                                                i9 = i15;
                                                int i16 = 0;
                                                while (true) {
                                                    long j9 = jArr8[i16];
                                                    long[] jArr9 = jArr8;
                                                    i10 = i12;
                                                    if ((((~j9) << 7) & j9 & (-9187201950435737472L)) != -9187201950435737472L) {
                                                        int i17 = 8 - ((~(i16 - length2)) >>> 31);
                                                        int i18 = 0;
                                                        while (i18 < i17) {
                                                            if ((j9 & 255) < 128) {
                                                                objArr6 = objArr8;
                                                                DerivedState<?> derivedState = (DerivedState) objArr8[(i16 << 3) + i18];
                                                                Intrinsics.checkNotNull(derivedState, str6);
                                                                str5 = str6;
                                                                Object obj8 = hashMap8.get(derivedState);
                                                                SnapshotMutationPolicy<?> policy = derivedState.getPolicy();
                                                                if (policy == null) {
                                                                    policy = SnapshotStateKt.structuralEqualityPolicy();
                                                                }
                                                                scopeMap6 = scopeMap9;
                                                                j6 = j8;
                                                                if (policy.equivalent(derivedState.getCurrentRecord().getCurrentValue(), obj8)) {
                                                                    hashMap7 = hashMap8;
                                                                    scopeMap7 = scopeMap10;
                                                                    obj6 = obj7;
                                                                    this.statesToReread.add(derivedState);
                                                                } else {
                                                                    Object obj9 = scopeMap10.getMap().get(derivedState);
                                                                    if (obj9 != null) {
                                                                        if (obj9 instanceof MutableScatterSet) {
                                                                            MutableScatterSet mutableScatterSet3 = (MutableScatterSet) obj9;
                                                                            Object[] objArr9 = mutableScatterSet3.elements;
                                                                            long[] jArr10 = mutableScatterSet3.metadata;
                                                                            int length3 = jArr10.length - 2;
                                                                            if (length3 >= 0) {
                                                                                obj6 = obj7;
                                                                                int i19 = 0;
                                                                                while (true) {
                                                                                    long j10 = jArr10[i19];
                                                                                    long[] jArr11 = jArr10;
                                                                                    hashMap7 = hashMap8;
                                                                                    if ((((~j10) << 7) & j10 & (-9187201950435737472L)) != -9187201950435737472L) {
                                                                                        int i20 = 8 - ((~(i19 - length3)) >>> 31);
                                                                                        int i21 = 0;
                                                                                        while (i21 < i20) {
                                                                                            if ((j10 & 255) < 128) {
                                                                                                scopeMap8 = scopeMap10;
                                                                                                mutableScatterSet.add(objArr9[(i19 << 3) + i21]);
                                                                                                c10 = '\b';
                                                                                                z5 = true;
                                                                                            } else {
                                                                                                scopeMap8 = scopeMap10;
                                                                                                c10 = '\b';
                                                                                            }
                                                                                            j10 >>= c10;
                                                                                            i21++;
                                                                                            scopeMap10 = scopeMap8;
                                                                                        }
                                                                                        scopeMap7 = scopeMap10;
                                                                                        if (i20 != 8) {
                                                                                            break;
                                                                                        }
                                                                                    } else {
                                                                                        scopeMap7 = scopeMap10;
                                                                                    }
                                                                                    if (i19 == length3) {
                                                                                        break;
                                                                                    }
                                                                                    i19++;
                                                                                    hashMap8 = hashMap7;
                                                                                    jArr10 = jArr11;
                                                                                    scopeMap10 = scopeMap7;
                                                                                }
                                                                            }
                                                                        } else {
                                                                            hashMap7 = hashMap8;
                                                                            scopeMap7 = scopeMap10;
                                                                            obj6 = obj7;
                                                                            mutableScatterSet.add(obj9);
                                                                            z5 = true;
                                                                        }
                                                                    }
                                                                    hashMap7 = hashMap8;
                                                                    scopeMap7 = scopeMap10;
                                                                    obj6 = obj7;
                                                                }
                                                            } else {
                                                                scopeMap6 = scopeMap9;
                                                                hashMap7 = hashMap8;
                                                                scopeMap7 = scopeMap10;
                                                                str5 = str6;
                                                                j6 = j8;
                                                                obj6 = obj7;
                                                                objArr6 = objArr8;
                                                            }
                                                            j9 >>= 8;
                                                            i18++;
                                                            str6 = str5;
                                                            objArr8 = objArr6;
                                                            obj7 = obj6;
                                                            scopeMap9 = scopeMap6;
                                                            j8 = j6;
                                                            hashMap8 = hashMap7;
                                                            scopeMap10 = scopeMap7;
                                                        }
                                                        scopeMap4 = scopeMap9;
                                                        hashMap6 = hashMap8;
                                                        scopeMap5 = scopeMap10;
                                                        str4 = str6;
                                                        j5 = j8;
                                                        obj4 = obj7;
                                                        objArr5 = objArr8;
                                                        if (i17 != 8) {
                                                            break;
                                                        }
                                                    } else {
                                                        scopeMap4 = scopeMap9;
                                                        hashMap6 = hashMap8;
                                                        scopeMap5 = scopeMap10;
                                                        str4 = str6;
                                                        j5 = j8;
                                                        obj4 = obj7;
                                                        objArr5 = objArr8;
                                                    }
                                                    if (i16 == length2) {
                                                        break;
                                                    }
                                                    i16++;
                                                    i12 = i10;
                                                    jArr8 = jArr9;
                                                    str6 = str4;
                                                    objArr8 = objArr5;
                                                    obj7 = obj4;
                                                    scopeMap9 = scopeMap4;
                                                    j8 = j5;
                                                    hashMap8 = hashMap6;
                                                    scopeMap10 = scopeMap5;
                                                }
                                            } else {
                                                scopeMap4 = scopeMap9;
                                                hashMap6 = hashMap8;
                                                scopeMap5 = scopeMap10;
                                                objArr4 = objArr7;
                                                str4 = str6;
                                                i8 = i14;
                                                i9 = i15;
                                                j5 = j8;
                                                i10 = i12;
                                                obj4 = obj7;
                                            }
                                            hashMap5 = hashMap6;
                                        } else {
                                            jArr6 = jArr7;
                                            scopeMap4 = scopeMap9;
                                            scopeMap5 = scopeMap10;
                                            objArr4 = objArr7;
                                            str4 = str6;
                                            i8 = i14;
                                            i9 = i15;
                                            j5 = j8;
                                            i10 = i12;
                                            obj4 = obj7;
                                            DerivedState<?> derivedState2 = (DerivedState) obj5;
                                            hashMap5 = hashMap8;
                                            Object obj10 = hashMap5.get(derivedState2);
                                            SnapshotMutationPolicy<?> policy2 = derivedState2.getPolicy();
                                            if (policy2 == null) {
                                                policy2 = SnapshotStateKt.structuralEqualityPolicy();
                                            }
                                            if (policy2.equivalent(derivedState2.getCurrentRecord().getCurrentValue(), obj10)) {
                                                this.statesToReread.add(derivedState2);
                                            } else {
                                                Object obj11 = scopeMap5.getMap().get(derivedState2);
                                                if (obj11 != null) {
                                                    if (obj11 instanceof MutableScatterSet) {
                                                        MutableScatterSet mutableScatterSet4 = (MutableScatterSet) obj11;
                                                        Object[] objArr10 = mutableScatterSet4.elements;
                                                        long[] jArr12 = mutableScatterSet4.metadata;
                                                        int length4 = jArr12.length - 2;
                                                        if (length4 >= 0) {
                                                            int i22 = 0;
                                                            while (true) {
                                                                long j11 = jArr12[i22];
                                                                if ((((~j11) << 7) & j11 & (-9187201950435737472L)) != -9187201950435737472L) {
                                                                    int i23 = 8 - ((~(i22 - length4)) >>> 31);
                                                                    for (int i24 = 0; i24 < i23; i24++) {
                                                                        if ((j11 & 255) < 128) {
                                                                            mutableScatterSet.add(objArr10[(i22 << 3) + i24]);
                                                                            c9 = '\b';
                                                                            z5 = true;
                                                                        } else {
                                                                            c9 = '\b';
                                                                        }
                                                                        j11 >>= c9;
                                                                    }
                                                                    if (i23 != 8) {
                                                                        break;
                                                                    }
                                                                }
                                                                if (i22 == length4) {
                                                                    break;
                                                                }
                                                                i22++;
                                                            }
                                                        }
                                                    } else {
                                                        mutableScatterSet.add(obj11);
                                                        z5 = true;
                                                    }
                                                }
                                            }
                                        }
                                        Object obj12 = scopeMap5.getMap().get(obj4);
                                        if (obj12 != null) {
                                            if (obj12 instanceof MutableScatterSet) {
                                                MutableScatterSet mutableScatterSet5 = (MutableScatterSet) obj12;
                                                Object[] objArr11 = mutableScatterSet5.elements;
                                                long[] jArr13 = mutableScatterSet5.metadata;
                                                int length5 = jArr13.length - 2;
                                                if (length5 >= 0) {
                                                    int i25 = 0;
                                                    while (true) {
                                                        long j12 = jArr13[i25];
                                                        if ((((~j12) << 7) & j12 & (-9187201950435737472L)) != -9187201950435737472L) {
                                                            int i26 = 8 - ((~(i25 - length5)) >>> 31);
                                                            for (int i27 = 0; i27 < i26; i27++) {
                                                                if ((j12 & 255) < 128) {
                                                                    mutableScatterSet.add(objArr11[(i25 << 3) + i27]);
                                                                    c8 = '\b';
                                                                    z5 = true;
                                                                } else {
                                                                    c8 = '\b';
                                                                }
                                                                j12 >>= c8;
                                                            }
                                                            if (i26 != 8) {
                                                                break;
                                                            }
                                                        }
                                                        if (i25 == length5) {
                                                            break;
                                                        }
                                                        i25++;
                                                    }
                                                }
                                            } else {
                                                mutableScatterSet.add(obj12);
                                                z5 = true;
                                            }
                                        }
                                        j8 = j5 >> 8;
                                        i15 = i9 + 1;
                                        hashMap8 = hashMap5;
                                        jArr7 = jArr6;
                                        objArr7 = objArr4;
                                        i14 = i8;
                                        i12 = i10;
                                        str6 = str4;
                                        scopeMap9 = scopeMap4;
                                        scopeMap10 = scopeMap5;
                                    }
                                }
                                jArr6 = jArr7;
                                scopeMap4 = scopeMap9;
                                hashMap5 = hashMap8;
                                scopeMap5 = scopeMap10;
                                objArr4 = objArr7;
                                str4 = str6;
                                i8 = i14;
                                i9 = i15;
                                j5 = j8;
                                i10 = i12;
                                j8 = j5 >> 8;
                                i15 = i9 + 1;
                                hashMap8 = hashMap5;
                                jArr7 = jArr6;
                                objArr7 = objArr4;
                                i14 = i8;
                                i12 = i10;
                                str6 = str4;
                                scopeMap9 = scopeMap4;
                                scopeMap10 = scopeMap5;
                            }
                            jArr5 = jArr7;
                            scopeMap2 = scopeMap9;
                            hashMap4 = hashMap8;
                            scopeMap3 = scopeMap10;
                            objArr3 = objArr7;
                            str3 = str6;
                            int i28 = i12;
                            if (i14 != 8) {
                                break;
                            }
                            length = i13;
                            i7 = i28;
                        } else {
                            jArr5 = jArr7;
                            scopeMap2 = scopeMap9;
                            hashMap4 = hashMap8;
                            scopeMap3 = scopeMap10;
                            objArr3 = objArr7;
                            str3 = str6;
                            length = i13;
                            i7 = i12;
                        }
                        if (i7 == length) {
                            break;
                        }
                        i12 = i7 + 1;
                        hashMap8 = hashMap4;
                        jArr7 = jArr5;
                        objArr7 = objArr3;
                        str6 = str3;
                        scopeMap9 = scopeMap2;
                        scopeMap10 = scopeMap3;
                        c11 = 7;
                        j7 = -9187201950435737472L;
                    }
                } else {
                    z5 = false;
                }
            } else {
                ScopeMap<Object, DerivedState<?>> scopeMap11 = scopeMap9;
                HashMap<DerivedState<?>, Object> hashMap9 = hashMap8;
                String str7 = "null cannot be cast to non-null type androidx.compose.runtime.DerivedState<kotlin.Any?>";
                Iterator it3 = changes.iterator();
                z5 = false;
                while (it3.hasNext()) {
                    Object next = it3.next();
                    if (!(next instanceof StateObjectImpl) || ((StateObjectImpl) next).m1249isReadInh_f27i8$runtime_release(ReaderKind.m1248constructorimpl(2))) {
                        ScopeMap<Object, DerivedState<?>> scopeMap12 = scopeMap11;
                        if (!scopeMap12.contains(next) || (obj2 = scopeMap12.getMap().get(next)) == null) {
                            it = it3;
                            hashMap = hashMap9;
                            obj = next;
                            scopeMap11 = scopeMap12;
                            str = str7;
                        } else if (obj2 instanceof MutableScatterSet) {
                            MutableScatterSet mutableScatterSet6 = (MutableScatterSet) obj2;
                            Object[] objArr12 = mutableScatterSet6.elements;
                            long[] jArr14 = mutableScatterSet6.metadata;
                            int length6 = jArr14.length - 2;
                            if (length6 >= 0) {
                                int i29 = 0;
                                while (true) {
                                    long j13 = jArr14[i29];
                                    if ((((~j13) << 7) & j13 & (-9187201950435737472L)) != -9187201950435737472L) {
                                        int i30 = 8 - ((~(i29 - length6)) >>> 31);
                                        int i31 = 0;
                                        while (i31 < i30) {
                                            if ((j13 & 255) < 128) {
                                                DerivedState<?> derivedState3 = (DerivedState) objArr12[(i29 << 3) + i31];
                                                str2 = str7;
                                                Intrinsics.checkNotNull(derivedState3, str2);
                                                it2 = it3;
                                                Object obj13 = hashMap9.get(derivedState3);
                                                SnapshotMutationPolicy<?> policy3 = derivedState3.getPolicy();
                                                if (policy3 == null) {
                                                    policy3 = SnapshotStateKt.structuralEqualityPolicy();
                                                }
                                                scopeMap = scopeMap12;
                                                jArr2 = jArr14;
                                                if (policy3.equivalent(derivedState3.getCurrentRecord().getCurrentValue(), obj13)) {
                                                    hashMap3 = hashMap9;
                                                    obj3 = next;
                                                    objArr2 = objArr12;
                                                    i6 = length6;
                                                    this.statesToReread.add(derivedState3);
                                                } else {
                                                    Object obj14 = scopeMap10.getMap().get(derivedState3);
                                                    if (obj14 != null) {
                                                        if (obj14 instanceof MutableScatterSet) {
                                                            MutableScatterSet mutableScatterSet7 = (MutableScatterSet) obj14;
                                                            Object[] objArr13 = mutableScatterSet7.elements;
                                                            long[] jArr15 = mutableScatterSet7.metadata;
                                                            int length7 = jArr15.length - 2;
                                                            if (length7 >= 0) {
                                                                hashMap3 = hashMap9;
                                                                obj3 = next;
                                                                int i32 = 0;
                                                                while (true) {
                                                                    long j14 = jArr15[i32];
                                                                    objArr2 = objArr12;
                                                                    i6 = length6;
                                                                    if ((((~j14) << 7) & j14 & (-9187201950435737472L)) != -9187201950435737472L) {
                                                                        int i33 = 8 - ((~(i32 - length7)) >>> 31);
                                                                        int i34 = 0;
                                                                        while (i34 < i33) {
                                                                            if ((j14 & 255) < 128) {
                                                                                jArr4 = jArr15;
                                                                                mutableScatterSet.add(objArr13[(i32 << 3) + i34]);
                                                                                c7 = '\b';
                                                                                z5 = true;
                                                                            } else {
                                                                                jArr4 = jArr15;
                                                                                c7 = '\b';
                                                                            }
                                                                            j14 >>= c7;
                                                                            i34++;
                                                                            jArr15 = jArr4;
                                                                        }
                                                                        jArr3 = jArr15;
                                                                        if (i33 != 8) {
                                                                            break;
                                                                        }
                                                                    } else {
                                                                        jArr3 = jArr15;
                                                                    }
                                                                    if (i32 == length7) {
                                                                        break;
                                                                    }
                                                                    i32++;
                                                                    objArr12 = objArr2;
                                                                    length6 = i6;
                                                                    jArr15 = jArr3;
                                                                }
                                                            }
                                                        } else {
                                                            hashMap3 = hashMap9;
                                                            obj3 = next;
                                                            objArr2 = objArr12;
                                                            i6 = length6;
                                                            mutableScatterSet.add(obj14);
                                                            z5 = true;
                                                        }
                                                    }
                                                    hashMap3 = hashMap9;
                                                    obj3 = next;
                                                    objArr2 = objArr12;
                                                    i6 = length6;
                                                }
                                            } else {
                                                it2 = it3;
                                                hashMap3 = hashMap9;
                                                obj3 = next;
                                                scopeMap = scopeMap12;
                                                jArr2 = jArr14;
                                                objArr2 = objArr12;
                                                i6 = length6;
                                                str2 = str7;
                                            }
                                            j13 >>= 8;
                                            i31++;
                                            it3 = it2;
                                            str7 = str2;
                                            next = obj3;
                                            jArr14 = jArr2;
                                            objArr12 = objArr2;
                                            length6 = i6;
                                            scopeMap12 = scopeMap;
                                            hashMap9 = hashMap3;
                                        }
                                        it = it3;
                                        hashMap2 = hashMap9;
                                        obj = next;
                                        scopeMap11 = scopeMap12;
                                        jArr = jArr14;
                                        objArr = objArr12;
                                        int i35 = length6;
                                        str = str7;
                                        if (i30 != 8) {
                                            break;
                                        }
                                        length6 = i35;
                                    } else {
                                        it = it3;
                                        hashMap2 = hashMap9;
                                        obj = next;
                                        scopeMap11 = scopeMap12;
                                        jArr = jArr14;
                                        objArr = objArr12;
                                        str = str7;
                                    }
                                    if (i29 == length6) {
                                        break;
                                    }
                                    i29++;
                                    it3 = it;
                                    str7 = str;
                                    next = obj;
                                    jArr14 = jArr;
                                    objArr12 = objArr;
                                    scopeMap12 = scopeMap11;
                                    hashMap9 = hashMap2;
                                }
                            } else {
                                it = it3;
                                hashMap2 = hashMap9;
                                obj = next;
                                scopeMap11 = scopeMap12;
                                str = str7;
                            }
                            hashMap = hashMap2;
                        } else {
                            it = it3;
                            obj = next;
                            scopeMap11 = scopeMap12;
                            str = str7;
                            DerivedState<?> derivedState4 = (DerivedState) obj2;
                            hashMap = hashMap9;
                            Object obj15 = hashMap.get(derivedState4);
                            SnapshotMutationPolicy<?> policy4 = derivedState4.getPolicy();
                            if (policy4 == null) {
                                policy4 = SnapshotStateKt.structuralEqualityPolicy();
                            }
                            if (policy4.equivalent(derivedState4.getCurrentRecord().getCurrentValue(), obj15)) {
                                this.statesToReread.add(derivedState4);
                            } else {
                                Object obj16 = scopeMap10.getMap().get(derivedState4);
                                if (obj16 != null) {
                                    if (obj16 instanceof MutableScatterSet) {
                                        MutableScatterSet mutableScatterSet8 = (MutableScatterSet) obj16;
                                        Object[] objArr14 = mutableScatterSet8.elements;
                                        long[] jArr16 = mutableScatterSet8.metadata;
                                        int length8 = jArr16.length - 2;
                                        if (length8 >= 0) {
                                            int i36 = 0;
                                            while (true) {
                                                long j15 = jArr16[i36];
                                                if ((((~j15) << 7) & j15 & (-9187201950435737472L)) != -9187201950435737472L) {
                                                    int i37 = 8 - ((~(i36 - length8)) >>> 31);
                                                    for (int i38 = 0; i38 < i37; i38++) {
                                                        if ((j15 & 255) < 128) {
                                                            mutableScatterSet.add(objArr14[(i36 << 3) + i38]);
                                                            c6 = '\b';
                                                            z5 = true;
                                                        } else {
                                                            c6 = '\b';
                                                        }
                                                        j15 >>= c6;
                                                    }
                                                    if (i37 != 8) {
                                                        break;
                                                    }
                                                }
                                                if (i36 == length8) {
                                                    break;
                                                }
                                                i36++;
                                            }
                                        }
                                    } else {
                                        mutableScatterSet.add(obj16);
                                        z5 = true;
                                    }
                                }
                            }
                        }
                        Object obj17 = scopeMap10.getMap().get(obj);
                        if (obj17 != null) {
                            if (obj17 instanceof MutableScatterSet) {
                                MutableScatterSet mutableScatterSet9 = (MutableScatterSet) obj17;
                                Object[] objArr15 = mutableScatterSet9.elements;
                                long[] jArr17 = mutableScatterSet9.metadata;
                                int length9 = jArr17.length - 2;
                                if (length9 >= 0) {
                                    while (true) {
                                        long j16 = jArr17[i5];
                                        if ((((~j16) << 7) & j16 & (-9187201950435737472L)) != -9187201950435737472L) {
                                            int i39 = 8 - ((~(i5 - length9)) >>> 31);
                                            for (int i40 = 0; i40 < i39; i40++) {
                                                if ((j16 & 255) < 128) {
                                                    mutableScatterSet.add(objArr15[(i5 << 3) + i40]);
                                                    c5 = '\b';
                                                    z5 = true;
                                                } else {
                                                    c5 = '\b';
                                                }
                                                j16 >>= c5;
                                            }
                                            if (i39 != 8) {
                                                break;
                                            }
                                        }
                                        i5 = i5 != length9 ? i5 + 1 : 0;
                                    }
                                }
                            } else {
                                mutableScatterSet.add(obj17);
                                z5 = true;
                            }
                            hashMap9 = hashMap;
                            str7 = str;
                            it3 = it;
                        }
                    } else {
                        it = it3;
                        hashMap = hashMap9;
                        str = str7;
                    }
                    hashMap9 = hashMap;
                    str7 = str;
                    it3 = it;
                }
            }
            if (this.statesToReread.isNotEmpty()) {
                MutableVector<DerivedState<?>> mutableVector = this.statesToReread;
                int size = mutableVector.getSize();
                if (size > 0) {
                    DerivedState<?>[] content = mutableVector.getContent();
                    while (true) {
                        rereadDerivedState(content[i11]);
                        int i41 = i11 + 1;
                        if (i41 >= size) {
                            break;
                        }
                        i11 = i41;
                    }
                }
                this.statesToReread.clear();
            }
            return z5;
        }

        public final void recordRead(Object value) {
            Object obj = this.currentScope;
            Intrinsics.checkNotNull(obj);
            int i5 = this.currentToken;
            MutableObjectIntMap<Object> mutableObjectIntMap = this.currentScopeReads;
            if (mutableObjectIntMap == null) {
                mutableObjectIntMap = new MutableObjectIntMap<>(0, 1, null);
                this.currentScopeReads = mutableObjectIntMap;
                this.scopeToValues.set(obj, mutableObjectIntMap);
                Unit unit = Unit.INSTANCE;
            }
            recordRead(value, i5, obj, mutableObjectIntMap);
        }

        public final void removeScopeIf(Function1<Object, Boolean> predicate) {
            long[] jArr;
            int i5;
            long[] jArr2;
            int i6;
            long j5;
            int i7;
            long j6;
            int i8;
            MutableScatterMap<Object, MutableObjectIntMap<Object>> mutableScatterMap = this.scopeToValues;
            long[] jArr3 = mutableScatterMap.metadata;
            int length = jArr3.length - 2;
            if (length < 0) {
                return;
            }
            int i9 = 0;
            while (true) {
                long j7 = jArr3[i9];
                long j8 = -9187201950435737472L;
                if ((((~j7) << 7) & j7 & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i10 = 8;
                    int i11 = 8 - ((~(i9 - length)) >>> 31);
                    int i12 = 0;
                    while (i12 < i11) {
                        if ((j7 & 255) < 128) {
                            int i13 = (i9 << 3) + i12;
                            Object obj = mutableScatterMap.keys[i13];
                            MutableObjectIntMap mutableObjectIntMap = (MutableObjectIntMap) mutableScatterMap.values[i13];
                            Boolean invoke = predicate.invoke(obj);
                            if (invoke.booleanValue()) {
                                Object[] objArr = mutableObjectIntMap.keys;
                                int[] iArr = mutableObjectIntMap.values;
                                long[] jArr4 = mutableObjectIntMap.metadata;
                                int length2 = jArr4.length - 2;
                                jArr2 = jArr3;
                                if (length2 >= 0) {
                                    i7 = i11;
                                    int i14 = 0;
                                    while (true) {
                                        long j9 = jArr4[i14];
                                        i6 = i9;
                                        j5 = j7;
                                        j6 = -9187201950435737472L;
                                        if ((((~j9) << 7) & j9 & (-9187201950435737472L)) != -9187201950435737472L) {
                                            int i15 = 8 - ((~(i14 - length2)) >>> 31);
                                            for (int i16 = 0; i16 < i15; i16++) {
                                                if ((j9 & 255) < 128) {
                                                    int i17 = (i14 << 3) + i16;
                                                    Object obj2 = objArr[i17];
                                                    int i18 = iArr[i17];
                                                    removeObservation(obj, obj2);
                                                }
                                                j9 >>= 8;
                                            }
                                            if (i15 != 8) {
                                                break;
                                            }
                                        }
                                        if (i14 == length2) {
                                            break;
                                        }
                                        i14++;
                                        i9 = i6;
                                        j7 = j5;
                                    }
                                } else {
                                    i6 = i9;
                                    j5 = j7;
                                    i7 = i11;
                                    j6 = -9187201950435737472L;
                                }
                            } else {
                                jArr2 = jArr3;
                                i6 = i9;
                                j5 = j7;
                                i7 = i11;
                                j6 = j8;
                            }
                            if (invoke.booleanValue()) {
                                mutableScatterMap.removeValueAt(i13);
                            }
                            i8 = 8;
                        } else {
                            jArr2 = jArr3;
                            i6 = i9;
                            j5 = j7;
                            i7 = i11;
                            j6 = j8;
                            i8 = i10;
                        }
                        j7 = j5 >> i8;
                        i12++;
                        i10 = i8;
                        j8 = j6;
                        jArr3 = jArr2;
                        i11 = i7;
                        i9 = i6;
                    }
                    jArr = jArr3;
                    int i19 = i9;
                    if (i11 != i10) {
                        return;
                    } else {
                        i5 = i19;
                    }
                } else {
                    jArr = jArr3;
                    i5 = i9;
                }
                if (i5 == length) {
                    return;
                }
                i9 = i5 + 1;
                jArr3 = jArr;
            }
        }

        public final void rereadDerivedState(DerivedState<?> derivedState) {
            long[] jArr;
            long[] jArr2;
            int i5;
            MutableObjectIntMap<Object> mutableObjectIntMap;
            MutableScatterMap<Object, MutableObjectIntMap<Object>> mutableScatterMap = this.scopeToValues;
            int id = SnapshotKt.currentSnapshot().getId();
            Object obj = this.valueToScopes.getMap().get(derivedState);
            if (obj == null) {
                return;
            }
            if (!(obj instanceof MutableScatterSet)) {
                MutableObjectIntMap<Object> mutableObjectIntMap2 = mutableScatterMap.get(obj);
                if (mutableObjectIntMap2 == null) {
                    mutableObjectIntMap2 = new MutableObjectIntMap<>(0, 1, null);
                    mutableScatterMap.set(obj, mutableObjectIntMap2);
                    Unit unit = Unit.INSTANCE;
                }
                recordRead(derivedState, id, obj, mutableObjectIntMap2);
                return;
            }
            MutableScatterSet mutableScatterSet = (MutableScatterSet) obj;
            Object[] objArr = mutableScatterSet.elements;
            long[] jArr3 = mutableScatterSet.metadata;
            int length = jArr3.length - 2;
            if (length < 0) {
                return;
            }
            int i6 = 0;
            while (true) {
                long j5 = jArr3[i6];
                if ((((~j5) << 7) & j5 & (-9187201950435737472L)) != -9187201950435737472L) {
                    int i7 = 8;
                    int i8 = 8 - ((~(i6 - length)) >>> 31);
                    int i9 = 0;
                    while (i9 < i8) {
                        if ((j5 & 255) < 128) {
                            Object obj2 = objArr[(i6 << 3) + i9];
                            MutableObjectIntMap<Object> mutableObjectIntMap3 = mutableScatterMap.get(obj2);
                            jArr2 = jArr3;
                            if (mutableObjectIntMap3 == null) {
                                mutableObjectIntMap = new MutableObjectIntMap<>(0, 1, null);
                                mutableScatterMap.set(obj2, mutableObjectIntMap);
                                Unit unit2 = Unit.INSTANCE;
                            } else {
                                mutableObjectIntMap = mutableObjectIntMap3;
                            }
                            recordRead(derivedState, id, obj2, mutableObjectIntMap);
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
                        return;
                    }
                } else {
                    jArr = jArr3;
                }
                if (i6 == length) {
                    return;
                }
                i6++;
                jArr3 = jArr;
            }
        }

        private final void recordRead(Object value, int currentToken, Object currentScope, MutableObjectIntMap<Object> recordedValues) {
            int i5;
            int i6;
            if (this.deriveStateScopeCount > 0) {
                return;
            }
            int put = recordedValues.put(value, currentToken, -1);
            if (!(value instanceof DerivedState) || put == currentToken) {
                i5 = -1;
            } else {
                DerivedState.Record currentRecord = ((DerivedState) value).getCurrentRecord();
                this.recordedDerivedStateValues.put(value, currentRecord.getCurrentValue());
                ObjectIntMap<StateObject> dependencies = currentRecord.getDependencies();
                ScopeMap<Object, DerivedState<?>> scopeMap = this.dependencyToDerivedStates;
                scopeMap.removeScope(value);
                Object[] objArr = dependencies.keys;
                long[] jArr = dependencies.metadata;
                int length = jArr.length - 2;
                if (length >= 0) {
                    int i7 = 0;
                    while (true) {
                        long j5 = jArr[i7];
                        if ((((~j5) << 7) & j5 & (-9187201950435737472L)) != -9187201950435737472L) {
                            int i8 = 8;
                            int i9 = 8 - ((~(i7 - length)) >>> 31);
                            int i10 = 0;
                            while (i10 < i9) {
                                if ((j5 & 255) < 128) {
                                    StateObject stateObject = (StateObject) objArr[(i7 << 3) + i10];
                                    if (stateObject instanceof StateObjectImpl) {
                                        ((StateObjectImpl) stateObject).m1250recordReadInh_f27i8$runtime_release(ReaderKind.m1248constructorimpl(2));
                                    }
                                    scopeMap.add(stateObject, value);
                                    i6 = 8;
                                } else {
                                    i6 = i8;
                                }
                                j5 >>= i6;
                                i10++;
                                i8 = i6;
                            }
                            if (i9 != i8) {
                                break;
                            }
                        }
                        if (i7 == length) {
                            break;
                        } else {
                            i7++;
                        }
                    }
                }
                i5 = -1;
            }
            if (put == i5) {
                if (value instanceof StateObjectImpl) {
                    ((StateObjectImpl) value).m1250recordReadInh_f27i8$runtime_release(ReaderKind.m1248constructorimpl(2));
                }
                this.valueToScopes.add(value, currentScope);
            }
        }
    }

    public final void clear() {
        synchronized (this.observedScopeMaps) {
            try {
                MutableVector<ObservedScopeMap> mutableVector = this.observedScopeMaps;
                int size = mutableVector.getSize();
                if (size > 0) {
                    ObservedScopeMap[] content = mutableVector.getContent();
                    int i5 = 0;
                    do {
                        content[i5].clear();
                        i5++;
                    } while (i5 < size);
                }
                Unit unit = Unit.INSTANCE;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
