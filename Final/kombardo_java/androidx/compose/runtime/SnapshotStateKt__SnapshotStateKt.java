package androidx.compose.runtime;

import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.runtime.snapshots.SnapshotStateMap;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a3\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0001\u001a\u00028\u00002\u000e\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u001b\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\"\u0004\b\u0000\u0010\u0000H\u0007¢\u0006\u0004\b\b\u0010\t\u001a/\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\"\u0004\b\u0000\u0010\u00002\u0012\u0010\u000b\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\n\"\u00028\u0000H\u0007¢\u0006\u0004\b\b\u0010\f\u001a'\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000f\"\u0004\b\u0000\u0010\r\"\u0004\b\u0001\u0010\u000eH\u0007¢\u0006\u0004\b\u0010\u0010\u0011\u001a#\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0013\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0012\u001a\u00028\u0000H\u0007¢\u0006\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"T", "value", "Landroidx/compose/runtime/SnapshotMutationPolicy;", "policy", "Landroidx/compose/runtime/MutableState;", "mutableStateOf", "(Ljava/lang/Object;Landroidx/compose/runtime/SnapshotMutationPolicy;)Landroidx/compose/runtime/MutableState;", "Landroidx/compose/runtime/snapshots/SnapshotStateList;", "mutableStateListOf", "()Landroidx/compose/runtime/snapshots/SnapshotStateList;", BuildConfig.FLAVOR, "elements", "([Ljava/lang/Object;)Landroidx/compose/runtime/snapshots/SnapshotStateList;", "K", "V", "Landroidx/compose/runtime/snapshots/SnapshotStateMap;", "mutableStateMapOf", "()Landroidx/compose/runtime/snapshots/SnapshotStateMap;", "newValue", "Landroidx/compose/runtime/State;", "rememberUpdatedState", "(Ljava/lang/Object;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "runtime_release"}, k = 5, mv = {1, 8, 0}, xi = 48, xs = "androidx/compose/runtime/SnapshotStateKt")
/* loaded from: classes.dex */
public abstract /* synthetic */ class SnapshotStateKt__SnapshotStateKt {
    public static final <T> SnapshotStateList<T> mutableStateListOf() {
        return new SnapshotStateList<>();
    }

    public static final <K, V> SnapshotStateMap<K, V> mutableStateMapOf() {
        return new SnapshotStateMap<>();
    }

    public static final <T> MutableState<T> mutableStateOf(T t5, SnapshotMutationPolicy<T> snapshotMutationPolicy) {
        return ActualAndroid_androidKt.createSnapshotMutableState(t5, snapshotMutationPolicy);
    }

    public static /* synthetic */ MutableState mutableStateOf$default(Object obj, SnapshotMutationPolicy snapshotMutationPolicy, int i5, Object obj2) {
        if ((i5 & 2) != 0) {
            snapshotMutationPolicy = SnapshotStateKt.structuralEqualityPolicy();
        }
        return SnapshotStateKt.mutableStateOf(obj, snapshotMutationPolicy);
    }

    public static final <T> State<T> rememberUpdatedState(T t5, Composer composer, int i5) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1058319986, i5, -1, "androidx.compose.runtime.rememberUpdatedState (SnapshotState.kt:309)");
        }
        Object rememberedValue = composer.rememberedValue();
        if (rememberedValue == Composer.INSTANCE.getEmpty()) {
            rememberedValue = mutableStateOf$default(t5, null, 2, null);
            composer.updateRememberedValue(rememberedValue);
        }
        MutableState mutableState = (MutableState) rememberedValue;
        mutableState.setValue(t5);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return mutableState;
    }

    public static final <T> SnapshotStateList<T> mutableStateListOf(T... tArr) {
        SnapshotStateList<T> snapshotStateList = new SnapshotStateList<>();
        snapshotStateList.addAll(ArraysKt.toList(tArr));
        return snapshotStateList;
    }
}
