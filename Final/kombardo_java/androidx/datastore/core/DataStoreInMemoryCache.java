package androidx.datastore.core;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J!\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\u0004\b\u0007\u0010\bR&\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00050\t8\u0002X\u0082\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u0012\u0004\b\f\u0010\u0004R\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00058F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u001d\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00050\u00108F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0014"}, d2 = {"Landroidx/datastore/core/DataStoreInMemoryCache;", "T", BuildConfig.FLAVOR, "<init>", "()V", "Landroidx/datastore/core/State;", "newState", "tryUpdate", "(Landroidx/datastore/core/State;)Landroidx/datastore/core/State;", "Lkotlinx/coroutines/flow/MutableStateFlow;", "cachedValue", "Lkotlinx/coroutines/flow/MutableStateFlow;", "getCachedValue$annotations", "getCurrentState", "()Landroidx/datastore/core/State;", "currentState", "Lkotlinx/coroutines/flow/Flow;", "getFlow", "()Lkotlinx/coroutines/flow/Flow;", "flow", "datastore-core_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class DataStoreInMemoryCache<T> {
    private final MutableStateFlow<State<T>> cachedValue;

    public DataStoreInMemoryCache() {
        UnInitialized unInitialized = UnInitialized.INSTANCE;
        Intrinsics.checkNotNull(unInitialized, "null cannot be cast to non-null type androidx.datastore.core.State<T of androidx.datastore.core.DataStoreInMemoryCache>");
        this.cachedValue = StateFlowKt.MutableStateFlow(unInitialized);
    }

    public final State<T> getCurrentState() {
        return this.cachedValue.getValue();
    }

    public final Flow<State<T>> getFlow() {
        return this.cachedValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0029, code lost:
    
        if (r6.getVersion() > r2.getVersion()) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final State<T> tryUpdate(State<T> newState) {
        State<T> value;
        State<T> state;
        Intrinsics.checkNotNullParameter(newState, "newState");
        MutableStateFlow<State<T>> mutableStateFlow = this.cachedValue;
        do {
            value = mutableStateFlow.getValue();
            state = value;
            if (!(state instanceof ReadException ? true : Intrinsics.areEqual(state, UnInitialized.INSTANCE))) {
                if (!(state instanceof Data)) {
                    if (!(state instanceof Final)) {
                        throw new NoWhenBranchMatchedException();
                    }
                }
            }
            state = newState;
        } while (!mutableStateFlow.compareAndSet(value, state));
        return state;
    }
}
