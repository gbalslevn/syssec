package kotlinx.coroutines.scheduling;

import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b!\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0019\b\u0000\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bB\t\b\u0010¢\u0006\u0004\b\u0007\u0010\tR\u0016\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0004\u0010\nR\u0016\u0010\u0006\u001a\u00020\u00058\u0000@\u0000X\u0081\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u000b¨\u0006\f"}, d2 = {"Lkotlinx/coroutines/scheduling/Task;", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", BuildConfig.FLAVOR, "submissionTime", "Lkotlinx/coroutines/scheduling/TaskContext;", "taskContext", "<init>", "(JLkotlinx/coroutines/scheduling/TaskContext;)V", "()V", "J", "Lkotlinx/coroutines/scheduling/TaskContext;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public abstract class Task implements Runnable {
    public long submissionTime;
    public TaskContext taskContext;

    public Task(long j5, TaskContext taskContext) {
        this.submissionTime = j5;
        this.taskContext = taskContext;
    }

    public Task() {
        this(0L, TasksKt.NonBlockingContext);
    }
}
