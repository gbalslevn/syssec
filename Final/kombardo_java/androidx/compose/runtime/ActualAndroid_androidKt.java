package androidx.compose.runtime;

import android.os.Looper;
import android.util.Log;
import androidx.compose.runtime.snapshots.SnapshotMutableState;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0000\n\u0002\b\u0002\u001a1\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u00002\u0006\u0010\u0001\u001a\u00028\u00002\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0001\u001a\u00020\u0007H\u0000¢\u0006\u0004\b\t\u0010\n\u001a\u0017\u0010\r\u001a\u00020\f2\u0006\u0010\u0001\u001a\u00020\u000bH\u0000¢\u0006\u0004\b\r\u0010\u000e\u001a\u0017\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0001\u001a\u00020\u000fH\u0000¢\u0006\u0004\b\u0011\u0010\u0012\u001a\u001f\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0015H\u0000¢\u0006\u0004\b\u0018\u0010\u0019\"\u0014\u0010\u001b\u001a\u00020\u001a8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001b\u0010\u001c\"!\u0010$\u001a\u00020\u001d8FX\u0087\u0084\u0002¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u0012\u0004\b\"\u0010#\u001a\u0004\b \u0010!\"\u0014\u0010%\u001a\u00020\u00138\u0002X\u0082T¢\u0006\u0006\n\u0004\b%\u0010&\"\u001a\u0010'\u001a\u00020\u000b8\u0000X\u0080\u0004¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010**\f\b\u0000\u0010,\"\u00020+2\u00020+¨\u0006-"}, d2 = {"T", "value", "Landroidx/compose/runtime/SnapshotMutationPolicy;", "policy", "Landroidx/compose/runtime/snapshots/SnapshotMutableState;", "createSnapshotMutableState", "(Ljava/lang/Object;Landroidx/compose/runtime/SnapshotMutationPolicy;)Landroidx/compose/runtime/snapshots/SnapshotMutableState;", BuildConfig.FLAVOR, "Landroidx/compose/runtime/MutableIntState;", "createSnapshotMutableIntState", "(I)Landroidx/compose/runtime/MutableIntState;", BuildConfig.FLAVOR, "Landroidx/compose/runtime/MutableLongState;", "createSnapshotMutableLongState", "(J)Landroidx/compose/runtime/MutableLongState;", BuildConfig.FLAVOR, "Landroidx/compose/runtime/MutableFloatState;", "createSnapshotMutableFloatState", "(F)Landroidx/compose/runtime/MutableFloatState;", BuildConfig.FLAVOR, "message", BuildConfig.FLAVOR, "e", BuildConfig.FLAVOR, "logError", "(Ljava/lang/String;Ljava/lang/Throwable;)V", BuildConfig.FLAVOR, "DisallowDefaultMonotonicFrameClock", "Z", "Landroidx/compose/runtime/MonotonicFrameClock;", "DefaultMonotonicFrameClock$delegate", "Lkotlin/Lazy;", "getDefaultMonotonicFrameClock", "()Landroidx/compose/runtime/MonotonicFrameClock;", "getDefaultMonotonicFrameClock$annotations", "()V", "DefaultMonotonicFrameClock", "LogTag", "Ljava/lang/String;", "MainThreadId", "J", "getMainThreadId", "()J", BuildConfig.FLAVOR, "CheckResult", "runtime_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class ActualAndroid_androidKt {
    private static final Lazy DefaultMonotonicFrameClock$delegate = LazyKt.lazy(new Function0<MonotonicFrameClock>() { // from class: androidx.compose.runtime.ActualAndroid_androidKt$DefaultMonotonicFrameClock$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final MonotonicFrameClock invoke() {
            return Looper.getMainLooper() != null ? DefaultChoreographerFrameClock.INSTANCE : SdkStubsFallbackFrameClock.INSTANCE;
        }
    });
    private static final boolean DisallowDefaultMonotonicFrameClock = false;
    private static final String LogTag = "ComposeInternal";
    private static final long MainThreadId;

    static {
        long j5;
        try {
            j5 = Looper.getMainLooper().getThread().getId();
        } catch (Exception unused) {
            j5 = -1;
        }
        MainThreadId = j5;
    }

    public static final MutableFloatState createSnapshotMutableFloatState(float f5) {
        return new ParcelableSnapshotMutableFloatState(f5);
    }

    public static final MutableIntState createSnapshotMutableIntState(int i5) {
        return new ParcelableSnapshotMutableIntState(i5);
    }

    public static final MutableLongState createSnapshotMutableLongState(long j5) {
        return new ParcelableSnapshotMutableLongState(j5);
    }

    public static final <T> SnapshotMutableState<T> createSnapshotMutableState(T t5, SnapshotMutationPolicy<T> snapshotMutationPolicy) {
        return new ParcelableSnapshotMutableState(t5, snapshotMutationPolicy);
    }

    public static final long getMainThreadId() {
        return MainThreadId;
    }

    public static final void logError(String str, Throwable th) {
        Log.e(LogTag, str, th);
    }
}
