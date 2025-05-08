package androidx.compose.runtime;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.runtime.snapshots.SnapshotStateMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.StateFlow;

@Metadata(d1 = {"androidx/compose/runtime/SnapshotStateKt__DerivedStateKt", "androidx/compose/runtime/SnapshotStateKt__ProduceStateKt", "androidx/compose/runtime/SnapshotStateKt__SnapshotFlowKt", "androidx/compose/runtime/SnapshotStateKt__SnapshotMutationPolicyKt", "androidx/compose/runtime/SnapshotStateKt__SnapshotStateKt"}, k = 4, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class SnapshotStateKt {
    public static final <T extends R, R> State<R> collectAsState(Flow<? extends T> flow, R r5, CoroutineContext coroutineContext, Composer composer, int i5, int i6) {
        return SnapshotStateKt__SnapshotFlowKt.collectAsState(flow, r5, coroutineContext, composer, i5, i6);
    }

    public static final MutableVector<DerivedStateObserver> derivedStateObservers() {
        return SnapshotStateKt__DerivedStateKt.derivedStateObservers();
    }

    public static final <T> State<T> derivedStateOf(SnapshotMutationPolicy<T> snapshotMutationPolicy, Function0<? extends T> function0) {
        return SnapshotStateKt__DerivedStateKt.derivedStateOf(snapshotMutationPolicy, function0);
    }

    public static final <T> SnapshotStateList<T> mutableStateListOf() {
        return SnapshotStateKt__SnapshotStateKt.mutableStateListOf();
    }

    public static final <K, V> SnapshotStateMap<K, V> mutableStateMapOf() {
        return SnapshotStateKt__SnapshotStateKt.mutableStateMapOf();
    }

    public static final <T> MutableState<T> mutableStateOf(T t5, SnapshotMutationPolicy<T> snapshotMutationPolicy) {
        return SnapshotStateKt__SnapshotStateKt.mutableStateOf(t5, snapshotMutationPolicy);
    }

    public static final <T> SnapshotMutationPolicy<T> neverEqualPolicy() {
        return SnapshotStateKt__SnapshotMutationPolicyKt.neverEqualPolicy();
    }

    public static final <T> State<T> produceState(T t5, Object obj, Object obj2, Function2<? super ProduceStateScope<T>, ? super Continuation<? super Unit>, ? extends Object> function2, Composer composer, int i5) {
        return SnapshotStateKt__ProduceStateKt.produceState(t5, obj, obj2, function2, composer, i5);
    }

    public static final <T> SnapshotMutationPolicy<T> referentialEqualityPolicy() {
        return SnapshotStateKt__SnapshotMutationPolicyKt.referentialEqualityPolicy();
    }

    public static final <T> State<T> rememberUpdatedState(T t5, Composer composer, int i5) {
        return SnapshotStateKt__SnapshotStateKt.rememberUpdatedState(t5, composer, i5);
    }

    public static final <T> Flow<T> snapshotFlow(Function0<? extends T> function0) {
        return SnapshotStateKt__SnapshotFlowKt.snapshotFlow(function0);
    }

    public static final <T> SnapshotMutationPolicy<T> structuralEqualityPolicy() {
        return SnapshotStateKt__SnapshotMutationPolicyKt.structuralEqualityPolicy();
    }

    public static final <T> State<T> collectAsState(StateFlow<? extends T> stateFlow, CoroutineContext coroutineContext, Composer composer, int i5, int i6) {
        return SnapshotStateKt__SnapshotFlowKt.collectAsState(stateFlow, coroutineContext, composer, i5, i6);
    }

    public static final <T> State<T> derivedStateOf(Function0<? extends T> function0) {
        return SnapshotStateKt__DerivedStateKt.derivedStateOf(function0);
    }

    public static final <T> SnapshotStateList<T> mutableStateListOf(T... tArr) {
        return SnapshotStateKt__SnapshotStateKt.mutableStateListOf(tArr);
    }

    public static final <T> State<T> produceState(T t5, Object obj, Function2<? super ProduceStateScope<T>, ? super Continuation<? super Unit>, ? extends Object> function2, Composer composer, int i5) {
        return SnapshotStateKt__ProduceStateKt.produceState(t5, obj, function2, composer, i5);
    }

    public static final <T> State<T> produceState(T t5, Function2<? super ProduceStateScope<T>, ? super Continuation<? super Unit>, ? extends Object> function2, Composer composer, int i5) {
        return SnapshotStateKt__ProduceStateKt.produceState(t5, function2, composer, i5);
    }
}
