package _COROUTINE;

import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"L_COROUTINE/ArtificialStackFrames;", BuildConfig.FLAVOR, "<init>", "()V", "Ljava/lang/StackTraceElement;", "coroutineBoundary", "()Ljava/lang/StackTraceElement;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ArtificialStackFrames {
    public final StackTraceElement coroutineBoundary() {
        StackTraceElement artificialFrame;
        artificialFrame = CoroutineDebuggingKt.artificialFrame(new Exception(), _BOUNDARY.class.getSimpleName());
        return artificialFrame;
    }
}
