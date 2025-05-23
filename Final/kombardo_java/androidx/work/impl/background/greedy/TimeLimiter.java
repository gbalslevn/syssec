package androidx.work.impl.background.greedy;

import androidx.work.RunnableScheduler;
import androidx.work.impl.StartStopToken;
import androidx.work.impl.WorkLauncher;
import androidx.work.impl.background.greedy.TimeLimiter;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\fJ\u000e\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Landroidx/work/impl/background/greedy/TimeLimiter;", BuildConfig.FLAVOR, "runnableScheduler", "Landroidx/work/RunnableScheduler;", "launcher", "Landroidx/work/impl/WorkLauncher;", "timeoutMs", BuildConfig.FLAVOR, "(Landroidx/work/RunnableScheduler;Landroidx/work/impl/WorkLauncher;J)V", "lock", "tracked", BuildConfig.FLAVOR, "Landroidx/work/impl/StartStopToken;", "Ljava/lang/Runnable;", "cancel", BuildConfig.FLAVOR, "token", "track", "work-runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class TimeLimiter {
    private final WorkLauncher launcher;
    private final Object lock;
    private final RunnableScheduler runnableScheduler;
    private final long timeoutMs;
    private final Map<StartStopToken, Runnable> tracked;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TimeLimiter(RunnableScheduler runnableScheduler, WorkLauncher launcher) {
        this(runnableScheduler, launcher, 0L, 4, null);
        Intrinsics.checkNotNullParameter(runnableScheduler, "runnableScheduler");
        Intrinsics.checkNotNullParameter(launcher, "launcher");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void track$lambda$0(TimeLimiter timeLimiter, StartStopToken startStopToken) {
        timeLimiter.launcher.stopWork(startStopToken, 3);
    }

    public final void cancel(StartStopToken token) {
        Runnable remove;
        Intrinsics.checkNotNullParameter(token, "token");
        synchronized (this.lock) {
            remove = this.tracked.remove(token);
        }
        if (remove != null) {
            this.runnableScheduler.cancel(remove);
        }
    }

    public final void track(final StartStopToken token) {
        Intrinsics.checkNotNullParameter(token, "token");
        Runnable runnable = new Runnable() { // from class: R.a
            @Override // java.lang.Runnable
            public final void run() {
                TimeLimiter.track$lambda$0(TimeLimiter.this, token);
            }
        };
        synchronized (this.lock) {
            this.tracked.put(token, runnable);
        }
        this.runnableScheduler.scheduleWithDelay(this.timeoutMs, runnable);
    }

    public TimeLimiter(RunnableScheduler runnableScheduler, WorkLauncher launcher, long j5) {
        Intrinsics.checkNotNullParameter(runnableScheduler, "runnableScheduler");
        Intrinsics.checkNotNullParameter(launcher, "launcher");
        this.runnableScheduler = runnableScheduler;
        this.launcher = launcher;
        this.timeoutMs = j5;
        this.lock = new Object();
        this.tracked = new LinkedHashMap();
    }

    public /* synthetic */ TimeLimiter(RunnableScheduler runnableScheduler, WorkLauncher workLauncher, long j5, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this(runnableScheduler, workLauncher, (i5 & 4) != 0 ? TimeUnit.MINUTES.toMillis(90L) : j5);
    }
}
