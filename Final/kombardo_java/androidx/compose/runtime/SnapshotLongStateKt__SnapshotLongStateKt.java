package androidx.compose.runtime;

import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0017\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {BuildConfig.FLAVOR, "value", "Landroidx/compose/runtime/MutableLongState;", "mutableLongStateOf", "(J)Landroidx/compose/runtime/MutableLongState;", "runtime_release"}, k = 5, mv = {1, 8, 0}, xi = 48, xs = "androidx/compose/runtime/SnapshotLongStateKt")
/* loaded from: classes.dex */
abstract /* synthetic */ class SnapshotLongStateKt__SnapshotLongStateKt {
    public static final MutableLongState mutableLongStateOf(long j5) {
        return ActualAndroid_androidKt.createSnapshotMutableLongState(j5);
    }
}
