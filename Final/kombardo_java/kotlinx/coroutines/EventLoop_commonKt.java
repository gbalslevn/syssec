package kotlinx.coroutines;

import kotlin.Metadata;
import kotlinx.coroutines.internal.Symbol;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000 \n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0017\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0001\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u0002\u0010\u0003\"\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006\"\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082T¢\u0006\u0006\n\u0004\b\b\u0010\t\"\u0014\u0010\n\u001a\u00020\u00078\u0002X\u0082T¢\u0006\u0006\n\u0004\b\n\u0010\t\"\u0014\u0010\u000b\u001a\u00020\u00078\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000b\u0010\t\"\u0014\u0010\f\u001a\u00020\u00008\u0002X\u0082T¢\u0006\u0006\n\u0004\b\f\u0010\r\"\u0014\u0010\u000e\u001a\u00020\u00008\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000e\u0010\r\"\u0014\u0010\u000f\u001a\u00020\u00008\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000f\u0010\r\"\u0014\u0010\u0010\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0006*\u001e\b\u0002\u0010\u0013\u001a\u0004\b\u0000\u0010\u0011\"\b\u0012\u0004\u0012\u00028\u00000\u00122\b\u0012\u0004\u0012\u00028\u00000\u0012¨\u0006\u0014"}, d2 = {BuildConfig.FLAVOR, "timeMillis", "delayToNanos", "(J)J", "Lkotlinx/coroutines/internal/Symbol;", "DISPOSED_TASK", "Lkotlinx/coroutines/internal/Symbol;", BuildConfig.FLAVOR, "SCHEDULE_OK", "I", "SCHEDULE_COMPLETED", "SCHEDULE_DISPOSED", "MS_TO_NS", "J", "MAX_MS", "MAX_DELAY_NS", "CLOSED_EMPTY", "T", "Lkotlinx/coroutines/internal/LockFreeTaskQueueCore;", "Queue", "kotlinx-coroutines-core"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public abstract class EventLoop_commonKt {
    private static final long MAX_DELAY_NS = 4611686018427387903L;
    private static final long MAX_MS = 9223372036854L;
    private static final long MS_TO_NS = 1000000;
    private static final int SCHEDULE_COMPLETED = 1;
    private static final int SCHEDULE_DISPOSED = 2;
    private static final int SCHEDULE_OK = 0;
    private static final Symbol DISPOSED_TASK = new Symbol("REMOVED_TASK");
    private static final Symbol CLOSED_EMPTY = new Symbol("CLOSED_EMPTY");

    public static final long delayToNanos(long j5) {
        if (j5 <= 0) {
            return 0L;
        }
        if (j5 >= MAX_MS) {
            return Long.MAX_VALUE;
        }
        return MS_TO_NS * j5;
    }
}
