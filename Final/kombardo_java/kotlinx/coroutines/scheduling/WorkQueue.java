package kotlinx.coroutines.scheduling;

import androidx.concurrent.futures.a;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref$ObjectRef;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\u000b\u001a\u0004\u0018\u00010\u00042\n\u0010\n\u001a\u00060\bj\u0002`\tH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\u000f\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J!\u0010\u0012\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0012\u0010\u0013J+\u0010\u0017\u001a\u00020\u00162\n\u0010\n\u001a\u00060\bj\u0002`\t2\u000e\u0010\u0015\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0014H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001b\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u0019H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0011\u0010\u001d\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u0015\u0010 \u001a\u00020\u001f*\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b \u0010!J\u000f\u0010\"\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\"\u0010\u001eJ!\u0010$\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010#\u001a\u00020\r¢\u0006\u0004\b$\u0010%J)\u0010&\u001a\u00020\u00162\n\u0010\n\u001a\u00060\bj\u0002`\t2\u000e\u0010\u0015\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0014¢\u0006\u0004\b&\u0010\u0018J\u000f\u0010'\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b'\u0010\u001eJ\u0015\u0010)\u001a\u00020\u001f2\u0006\u0010(\u001a\u00020\u0019¢\u0006\u0004\b)\u0010*R\u001c\u0010,\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040+8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010-R\u0014\u00100\u001a\u00020\b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b.\u0010/R\u0014\u00102\u001a\u00020\b8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b1\u0010/R\u000b\u00104\u001a\u0002038\u0002X\u0082\u0004R\u000b\u00105\u001a\u0002038\u0002X\u0082\u0004R\u0013\u00107\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u0004068\u0002X\u0082\u0004R\u000b\u00108\u001a\u0002038\u0002X\u0082\u0004¨\u00069"}, d2 = {"Lkotlinx/coroutines/scheduling/WorkQueue;", BuildConfig.FLAVOR, "<init>", "()V", "Lkotlinx/coroutines/scheduling/Task;", "task", "addLast", "(Lkotlinx/coroutines/scheduling/Task;)Lkotlinx/coroutines/scheduling/Task;", BuildConfig.FLAVOR, "Lkotlinx/coroutines/scheduling/StealingMode;", "stealingMode", "stealWithExclusiveMode", "(I)Lkotlinx/coroutines/scheduling/Task;", BuildConfig.FLAVOR, "onlyBlocking", "pollWithExclusiveMode", "(Z)Lkotlinx/coroutines/scheduling/Task;", "index", "tryExtractFromTheMiddle", "(IZ)Lkotlinx/coroutines/scheduling/Task;", "Lkotlin/jvm/internal/Ref$ObjectRef;", "stolenTaskRef", BuildConfig.FLAVOR, "tryStealLastScheduled", "(ILkotlin/jvm/internal/Ref$ObjectRef;)J", "Lkotlinx/coroutines/scheduling/GlobalQueue;", "queue", "pollTo", "(Lkotlinx/coroutines/scheduling/GlobalQueue;)Z", "pollBuffer", "()Lkotlinx/coroutines/scheduling/Task;", BuildConfig.FLAVOR, "decrementIfBlocking", "(Lkotlinx/coroutines/scheduling/Task;)V", "poll", "fair", "add", "(Lkotlinx/coroutines/scheduling/Task;Z)Lkotlinx/coroutines/scheduling/Task;", "trySteal", "pollBlocking", "globalQueue", "offloadAllWorkTo", "(Lkotlinx/coroutines/scheduling/GlobalQueue;)V", "Ljava/util/concurrent/atomic/AtomicReferenceArray;", "buffer", "Ljava/util/concurrent/atomic/AtomicReferenceArray;", "getBufferSize", "()I", "bufferSize", "getSize$kotlinx_coroutines_core", "size", "Lkotlinx/atomicfu/AtomicInt;", "blockingTasksInBuffer", "consumerIndex", "Lkotlinx/atomicfu/AtomicRef;", "lastScheduledTask", "producerIndex", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class WorkQueue {
    private volatile int blockingTasksInBuffer;
    private final AtomicReferenceArray<Task> buffer = new AtomicReferenceArray<>(128);
    private volatile int consumerIndex;
    private volatile Object lastScheduledTask;
    private volatile int producerIndex;
    private static final AtomicReferenceFieldUpdater lastScheduledTask$FU = AtomicReferenceFieldUpdater.newUpdater(WorkQueue.class, Object.class, "lastScheduledTask");
    private static final AtomicIntegerFieldUpdater producerIndex$FU = AtomicIntegerFieldUpdater.newUpdater(WorkQueue.class, "producerIndex");
    private static final AtomicIntegerFieldUpdater consumerIndex$FU = AtomicIntegerFieldUpdater.newUpdater(WorkQueue.class, "consumerIndex");
    private static final AtomicIntegerFieldUpdater blockingTasksInBuffer$FU = AtomicIntegerFieldUpdater.newUpdater(WorkQueue.class, "blockingTasksInBuffer");

    private final Task addLast(Task task) {
        if (getBufferSize() == 127) {
            return task;
        }
        if (task.taskContext.getTaskMode() == 1) {
            blockingTasksInBuffer$FU.incrementAndGet(this);
        }
        int i5 = producerIndex$FU.get(this) & 127;
        while (this.buffer.get(i5) != null) {
            Thread.yield();
        }
        this.buffer.lazySet(i5, task);
        producerIndex$FU.incrementAndGet(this);
        return null;
    }

    private final void decrementIfBlocking(Task task) {
        if (task == null || task.taskContext.getTaskMode() != 1) {
            return;
        }
        blockingTasksInBuffer$FU.decrementAndGet(this);
    }

    private final int getBufferSize() {
        return producerIndex$FU.get(this) - consumerIndex$FU.get(this);
    }

    private final Task pollBuffer() {
        Task andSet;
        while (true) {
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = consumerIndex$FU;
            int i5 = atomicIntegerFieldUpdater.get(this);
            if (i5 - producerIndex$FU.get(this) == 0) {
                return null;
            }
            int i6 = i5 & 127;
            if (atomicIntegerFieldUpdater.compareAndSet(this, i5, i5 + 1) && (andSet = this.buffer.getAndSet(i6, null)) != null) {
                decrementIfBlocking(andSet);
                return andSet;
            }
        }
    }

    private final boolean pollTo(GlobalQueue queue) {
        Task pollBuffer = pollBuffer();
        if (pollBuffer == null) {
            return false;
        }
        queue.addLast(pollBuffer);
        return true;
    }

    private final Task pollWithExclusiveMode(boolean onlyBlocking) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        Task task;
        do {
            atomicReferenceFieldUpdater = lastScheduledTask$FU;
            task = (Task) atomicReferenceFieldUpdater.get(this);
            if (task != null) {
                if ((task.taskContext.getTaskMode() == 1) == onlyBlocking) {
                }
            }
            int i5 = consumerIndex$FU.get(this);
            int i6 = producerIndex$FU.get(this);
            while (i5 != i6) {
                if (onlyBlocking && blockingTasksInBuffer$FU.get(this) == 0) {
                    return null;
                }
                i6--;
                Task tryExtractFromTheMiddle = tryExtractFromTheMiddle(i6, onlyBlocking);
                if (tryExtractFromTheMiddle != null) {
                    return tryExtractFromTheMiddle;
                }
            }
            return null;
        } while (!a.a(atomicReferenceFieldUpdater, this, task, null));
        return task;
    }

    private final Task stealWithExclusiveMode(int stealingMode) {
        int i5 = consumerIndex$FU.get(this);
        int i6 = producerIndex$FU.get(this);
        boolean z5 = stealingMode == 1;
        while (i5 != i6) {
            if (z5 && blockingTasksInBuffer$FU.get(this) == 0) {
                return null;
            }
            int i7 = i5 + 1;
            Task tryExtractFromTheMiddle = tryExtractFromTheMiddle(i5, z5);
            if (tryExtractFromTheMiddle != null) {
                return tryExtractFromTheMiddle;
            }
            i5 = i7;
        }
        return null;
    }

    private final Task tryExtractFromTheMiddle(int index, boolean onlyBlocking) {
        int i5 = index & 127;
        Task task = this.buffer.get(i5);
        if (task != null) {
            if ((task.taskContext.getTaskMode() == 1) == onlyBlocking && I4.a.a(this.buffer, i5, task, null)) {
                if (onlyBlocking) {
                    blockingTasksInBuffer$FU.decrementAndGet(this);
                }
                return task;
            }
        }
        return null;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [T, kotlinx.coroutines.scheduling.Task, java.lang.Object] */
    private final long tryStealLastScheduled(int stealingMode, Ref$ObjectRef<Task> stolenTaskRef) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        ?? r12;
        do {
            atomicReferenceFieldUpdater = lastScheduledTask$FU;
            r12 = (Task) atomicReferenceFieldUpdater.get(this);
            if (r12 == 0) {
                return -2L;
            }
            if (((r12.taskContext.getTaskMode() != 1 ? 2 : 1) & stealingMode) == 0) {
                return -2L;
            }
            long nanoTime = TasksKt.schedulerTimeSource.nanoTime() - r12.submissionTime;
            long j5 = TasksKt.WORK_STEALING_TIME_RESOLUTION_NS;
            if (nanoTime < j5) {
                return j5 - nanoTime;
            }
        } while (!a.a(atomicReferenceFieldUpdater, this, r12, null));
        stolenTaskRef.element = r12;
        return -1L;
    }

    public final Task add(Task task, boolean fair) {
        if (fair) {
            return addLast(task);
        }
        Task task2 = (Task) lastScheduledTask$FU.getAndSet(this, task);
        if (task2 == null) {
            return null;
        }
        return addLast(task2);
    }

    public final int getSize$kotlinx_coroutines_core() {
        return lastScheduledTask$FU.get(this) != null ? getBufferSize() + 1 : getBufferSize();
    }

    public final void offloadAllWorkTo(GlobalQueue globalQueue) {
        Task task = (Task) lastScheduledTask$FU.getAndSet(this, null);
        if (task != null) {
            globalQueue.addLast(task);
        }
        do {
        } while (pollTo(globalQueue));
    }

    public final Task poll() {
        Task task = (Task) lastScheduledTask$FU.getAndSet(this, null);
        return task == null ? pollBuffer() : task;
    }

    public final Task pollBlocking() {
        return pollWithExclusiveMode(true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final long trySteal(int stealingMode, Ref$ObjectRef<Task> stolenTaskRef) {
        T pollBuffer = stealingMode == 3 ? pollBuffer() : stealWithExclusiveMode(stealingMode);
        if (pollBuffer == 0) {
            return tryStealLastScheduled(stealingMode, stolenTaskRef);
        }
        stolenTaskRef.element = pollBuffer;
        return -1L;
    }
}
