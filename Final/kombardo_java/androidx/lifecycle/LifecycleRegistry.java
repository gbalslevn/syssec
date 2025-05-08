package androidx.lifecycle;

import androidx.arch.core.internal.FastSafeIterableMap;
import androidx.arch.core.internal.SafeIterableMap;
import androidx.lifecycle.Lifecycle;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0016\u0018\u0000 ?2\u00020\u0001:\u0002?@B\u0019\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007B\u0011\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\bJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\tH\u0002¢\u0006\u0004\b\u0015\u0010\rJ\u0017\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0017\u0010\bJ\u0017\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0018\u0010\bJ\u000f\u0010\u0019\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0019\u0010\u0013J\u0017\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u001aH\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010 \u001a\u00020\u000b2\u0006\u0010\u001f\u001a\u00020\u001eH\u0016¢\u0006\u0004\b \u0010!J\u0017\u0010\"\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\"\u0010#J\u0017\u0010$\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b$\u0010#R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010%R\"\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020'0&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010\u0014\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010*R\u001a\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00020+8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010,R\u0016\u0010.\u001a\u00020-8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00100\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b0\u0010%R\u0016\u00101\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b1\u0010%R&\u00104\u001a\u0012\u0012\u0004\u0012\u00020\t02j\b\u0012\u0004\u0012\u00020\t`38\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u00105R\u001a\u00107\u001a\b\u0012\u0004\u0012\u00020\t068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b7\u00108R\u0014\u00109\u001a\u00020\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b9\u0010:R$\u0010>\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\t8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b;\u0010<\"\u0004\b=\u0010\r¨\u0006A"}, d2 = {"Landroidx/lifecycle/LifecycleRegistry;", "Landroidx/lifecycle/Lifecycle;", "Landroidx/lifecycle/LifecycleOwner;", "provider", BuildConfig.FLAVOR, "enforceMainThread", "<init>", "(Landroidx/lifecycle/LifecycleOwner;Z)V", "(Landroidx/lifecycle/LifecycleOwner;)V", "Landroidx/lifecycle/Lifecycle$State;", "next", BuildConfig.FLAVOR, "moveToState", "(Landroidx/lifecycle/Lifecycle$State;)V", "Landroidx/lifecycle/LifecycleObserver;", "observer", "calculateTargetState", "(Landroidx/lifecycle/LifecycleObserver;)Landroidx/lifecycle/Lifecycle$State;", "popParentState", "()V", "state", "pushParentState", "lifecycleOwner", "forwardPass", "backwardPass", "sync", BuildConfig.FLAVOR, "methodName", "enforceMainThreadIfNeeded", "(Ljava/lang/String;)V", "Landroidx/lifecycle/Lifecycle$Event;", "event", "handleLifecycleEvent", "(Landroidx/lifecycle/Lifecycle$Event;)V", "addObserver", "(Landroidx/lifecycle/LifecycleObserver;)V", "removeObserver", "Z", "Landroidx/arch/core/internal/FastSafeIterableMap;", "Landroidx/lifecycle/LifecycleRegistry$ObserverWithState;", "observerMap", "Landroidx/arch/core/internal/FastSafeIterableMap;", "Landroidx/lifecycle/Lifecycle$State;", "Ljava/lang/ref/WeakReference;", "Ljava/lang/ref/WeakReference;", BuildConfig.FLAVOR, "addingObserverCounter", "I", "handlingEvent", "newEventOccurred", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "parentStates", "Ljava/util/ArrayList;", "Lkotlinx/coroutines/flow/MutableStateFlow;", "_currentStateFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", "isSynced", "()Z", "getCurrentState", "()Landroidx/lifecycle/Lifecycle$State;", "setCurrentState", "currentState", "Companion", "ObserverWithState", "lifecycle-runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public class LifecycleRegistry extends Lifecycle {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final MutableStateFlow<Lifecycle.State> _currentStateFlow;
    private int addingObserverCounter;
    private final boolean enforceMainThread;
    private boolean handlingEvent;
    private final WeakReference<LifecycleOwner> lifecycleOwner;
    private boolean newEventOccurred;
    private FastSafeIterableMap<LifecycleObserver, ObserverWithState> observerMap;
    private ArrayList<Lifecycle.State> parentStates;
    private Lifecycle.State state;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0001¢\u0006\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Landroidx/lifecycle/LifecycleRegistry$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "Landroidx/lifecycle/Lifecycle$State;", "state1", "state2", "min$lifecycle_runtime_release", "(Landroidx/lifecycle/Lifecycle$State;Landroidx/lifecycle/Lifecycle$State;)Landroidx/lifecycle/Lifecycle$State;", "min", "lifecycle-runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Lifecycle.State min$lifecycle_runtime_release(Lifecycle.State state1, Lifecycle.State state2) {
            Intrinsics.checkNotNullParameter(state1, "state1");
            return (state2 == null || state2.compareTo(state1) >= 0) ? state1 : state2;
        }

        private Companion() {
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\r\u001a\u00020\f2\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000eR\"\u0010\u000f\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\"\u0010\u0016\u001a\u00020\u00158\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"Landroidx/lifecycle/LifecycleRegistry$ObserverWithState;", BuildConfig.FLAVOR, "Landroidx/lifecycle/LifecycleObserver;", "observer", "Landroidx/lifecycle/Lifecycle$State;", "initialState", "<init>", "(Landroidx/lifecycle/LifecycleObserver;Landroidx/lifecycle/Lifecycle$State;)V", "Landroidx/lifecycle/LifecycleOwner;", "owner", "Landroidx/lifecycle/Lifecycle$Event;", "event", BuildConfig.FLAVOR, "dispatchEvent", "(Landroidx/lifecycle/LifecycleOwner;Landroidx/lifecycle/Lifecycle$Event;)V", "state", "Landroidx/lifecycle/Lifecycle$State;", "getState", "()Landroidx/lifecycle/Lifecycle$State;", "setState", "(Landroidx/lifecycle/Lifecycle$State;)V", "Landroidx/lifecycle/LifecycleEventObserver;", "lifecycleObserver", "Landroidx/lifecycle/LifecycleEventObserver;", "getLifecycleObserver", "()Landroidx/lifecycle/LifecycleEventObserver;", "setLifecycleObserver", "(Landroidx/lifecycle/LifecycleEventObserver;)V", "lifecycle-runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class ObserverWithState {
        private LifecycleEventObserver lifecycleObserver;
        private Lifecycle.State state;

        public ObserverWithState(LifecycleObserver lifecycleObserver, Lifecycle.State initialState) {
            Intrinsics.checkNotNullParameter(initialState, "initialState");
            Intrinsics.checkNotNull(lifecycleObserver);
            this.lifecycleObserver = Lifecycling.lifecycleEventObserver(lifecycleObserver);
            this.state = initialState;
        }

        public final void dispatchEvent(LifecycleOwner owner, Lifecycle.Event event) {
            Intrinsics.checkNotNullParameter(event, "event");
            Lifecycle.State targetState = event.getTargetState();
            this.state = LifecycleRegistry.INSTANCE.min$lifecycle_runtime_release(this.state, targetState);
            LifecycleEventObserver lifecycleEventObserver = this.lifecycleObserver;
            Intrinsics.checkNotNull(owner);
            lifecycleEventObserver.onStateChanged(owner, event);
            this.state = targetState;
        }

        public final Lifecycle.State getState() {
            return this.state;
        }
    }

    private LifecycleRegistry(LifecycleOwner lifecycleOwner, boolean z5) {
        this.enforceMainThread = z5;
        this.observerMap = new FastSafeIterableMap<>();
        Lifecycle.State state = Lifecycle.State.INITIALIZED;
        this.state = state;
        this.parentStates = new ArrayList<>();
        this.lifecycleOwner = new WeakReference<>(lifecycleOwner);
        this._currentStateFlow = StateFlowKt.MutableStateFlow(state);
    }

    private final void backwardPass(LifecycleOwner lifecycleOwner) {
        Iterator<Map.Entry<LifecycleObserver, ObserverWithState>> descendingIterator = this.observerMap.descendingIterator();
        Intrinsics.checkNotNullExpressionValue(descendingIterator, "observerMap.descendingIterator()");
        while (descendingIterator.hasNext() && !this.newEventOccurred) {
            Map.Entry<LifecycleObserver, ObserverWithState> next = descendingIterator.next();
            Intrinsics.checkNotNullExpressionValue(next, "next()");
            LifecycleObserver key = next.getKey();
            ObserverWithState value = next.getValue();
            while (value.getState().compareTo(this.state) > 0 && !this.newEventOccurred && this.observerMap.contains(key)) {
                Lifecycle.Event downFrom = Lifecycle.Event.INSTANCE.downFrom(value.getState());
                if (downFrom == null) {
                    throw new IllegalStateException("no event down from " + value.getState());
                }
                pushParentState(downFrom.getTargetState());
                value.dispatchEvent(lifecycleOwner, downFrom);
                popParentState();
            }
        }
    }

    private final Lifecycle.State calculateTargetState(LifecycleObserver observer) {
        ObserverWithState value;
        Map.Entry<LifecycleObserver, ObserverWithState> ceil = this.observerMap.ceil(observer);
        Lifecycle.State state = null;
        Lifecycle.State state2 = (ceil == null || (value = ceil.getValue()) == null) ? null : value.getState();
        if (!this.parentStates.isEmpty()) {
            state = this.parentStates.get(r0.size() - 1);
        }
        Companion companion = INSTANCE;
        return companion.min$lifecycle_runtime_release(companion.min$lifecycle_runtime_release(this.state, state2), state);
    }

    private final void enforceMainThreadIfNeeded(String methodName) {
        if (!this.enforceMainThread || LifecycleRegistry_androidKt.isMainThread()) {
            return;
        }
        throw new IllegalStateException(("Method " + methodName + " must be called on the main thread").toString());
    }

    private final void forwardPass(LifecycleOwner lifecycleOwner) {
        SafeIterableMap<LifecycleObserver, ObserverWithState>.IteratorWithAdditions iteratorWithAdditions = this.observerMap.iteratorWithAdditions();
        Intrinsics.checkNotNullExpressionValue(iteratorWithAdditions, "observerMap.iteratorWithAdditions()");
        while (iteratorWithAdditions.hasNext() && !this.newEventOccurred) {
            Map.Entry next = iteratorWithAdditions.next();
            LifecycleObserver lifecycleObserver = (LifecycleObserver) next.getKey();
            ObserverWithState observerWithState = (ObserverWithState) next.getValue();
            while (observerWithState.getState().compareTo(this.state) < 0 && !this.newEventOccurred && this.observerMap.contains(lifecycleObserver)) {
                pushParentState(observerWithState.getState());
                Lifecycle.Event upFrom = Lifecycle.Event.INSTANCE.upFrom(observerWithState.getState());
                if (upFrom == null) {
                    throw new IllegalStateException("no event up from " + observerWithState.getState());
                }
                observerWithState.dispatchEvent(lifecycleOwner, upFrom);
                popParentState();
            }
        }
    }

    private final boolean isSynced() {
        if (this.observerMap.size() == 0) {
            return true;
        }
        Map.Entry<LifecycleObserver, ObserverWithState> eldest = this.observerMap.eldest();
        Intrinsics.checkNotNull(eldest);
        Lifecycle.State state = eldest.getValue().getState();
        Map.Entry<LifecycleObserver, ObserverWithState> newest = this.observerMap.newest();
        Intrinsics.checkNotNull(newest);
        Lifecycle.State state2 = newest.getValue().getState();
        return state == state2 && this.state == state2;
    }

    private final void moveToState(Lifecycle.State next) {
        Lifecycle.State state = this.state;
        if (state == next) {
            return;
        }
        if (state == Lifecycle.State.INITIALIZED && next == Lifecycle.State.DESTROYED) {
            throw new IllegalStateException(("State must be at least CREATED to move to " + next + ", but was " + this.state + " in component " + this.lifecycleOwner.get()).toString());
        }
        this.state = next;
        if (this.handlingEvent || this.addingObserverCounter != 0) {
            this.newEventOccurred = true;
            return;
        }
        this.handlingEvent = true;
        sync();
        this.handlingEvent = false;
        if (this.state == Lifecycle.State.DESTROYED) {
            this.observerMap = new FastSafeIterableMap<>();
        }
    }

    private final void popParentState() {
        this.parentStates.remove(r0.size() - 1);
    }

    private final void pushParentState(Lifecycle.State state) {
        this.parentStates.add(state);
    }

    private final void sync() {
        LifecycleOwner lifecycleOwner = this.lifecycleOwner.get();
        if (lifecycleOwner == null) {
            throw new IllegalStateException("LifecycleOwner of this LifecycleRegistry is already garbage collected. It is too late to change lifecycle state.");
        }
        while (!isSynced()) {
            this.newEventOccurred = false;
            Lifecycle.State state = this.state;
            Map.Entry<LifecycleObserver, ObserverWithState> eldest = this.observerMap.eldest();
            Intrinsics.checkNotNull(eldest);
            if (state.compareTo(eldest.getValue().getState()) < 0) {
                backwardPass(lifecycleOwner);
            }
            Map.Entry<LifecycleObserver, ObserverWithState> newest = this.observerMap.newest();
            if (!this.newEventOccurred && newest != null && this.state.compareTo(newest.getValue().getState()) > 0) {
                forwardPass(lifecycleOwner);
            }
        }
        this.newEventOccurred = false;
        this._currentStateFlow.setValue(getState());
    }

    @Override // androidx.lifecycle.Lifecycle
    public void addObserver(LifecycleObserver observer) {
        LifecycleOwner lifecycleOwner;
        Intrinsics.checkNotNullParameter(observer, "observer");
        enforceMainThreadIfNeeded("addObserver");
        Lifecycle.State state = this.state;
        Lifecycle.State state2 = Lifecycle.State.DESTROYED;
        if (state != state2) {
            state2 = Lifecycle.State.INITIALIZED;
        }
        ObserverWithState observerWithState = new ObserverWithState(observer, state2);
        if (this.observerMap.putIfAbsent(observer, observerWithState) == null && (lifecycleOwner = this.lifecycleOwner.get()) != null) {
            boolean z5 = this.addingObserverCounter != 0 || this.handlingEvent;
            Lifecycle.State calculateTargetState = calculateTargetState(observer);
            this.addingObserverCounter++;
            while (observerWithState.getState().compareTo(calculateTargetState) < 0 && this.observerMap.contains(observer)) {
                pushParentState(observerWithState.getState());
                Lifecycle.Event upFrom = Lifecycle.Event.INSTANCE.upFrom(observerWithState.getState());
                if (upFrom == null) {
                    throw new IllegalStateException("no event up from " + observerWithState.getState());
                }
                observerWithState.dispatchEvent(lifecycleOwner, upFrom);
                popParentState();
                calculateTargetState = calculateTargetState(observer);
            }
            if (!z5) {
                sync();
            }
            this.addingObserverCounter--;
        }
    }

    @Override // androidx.lifecycle.Lifecycle
    /* renamed from: getCurrentState, reason: from getter */
    public Lifecycle.State getState() {
        return this.state;
    }

    public void handleLifecycleEvent(Lifecycle.Event event) {
        Intrinsics.checkNotNullParameter(event, "event");
        enforceMainThreadIfNeeded("handleLifecycleEvent");
        moveToState(event.getTargetState());
    }

    @Override // androidx.lifecycle.Lifecycle
    public void removeObserver(LifecycleObserver observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        enforceMainThreadIfNeeded("removeObserver");
        this.observerMap.remove(observer);
    }

    public void setCurrentState(Lifecycle.State state) {
        Intrinsics.checkNotNullParameter(state, "state");
        enforceMainThreadIfNeeded("setCurrentState");
        moveToState(state);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LifecycleRegistry(LifecycleOwner provider) {
        this(provider, true);
        Intrinsics.checkNotNullParameter(provider, "provider");
    }
}
