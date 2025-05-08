package kotlinx.coroutines.internal;

import androidx.concurrent.futures.a;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 .*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0001:\u0002./B\u0017\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ3\u0010\f\u001a\u0016\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0000j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\u000b2\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\f\u0010\rJ3\u0010\u0010\u001a\u0016\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0000j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\u000b2\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J'\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u0000j\b\u0012\u0004\u0012\u00028\u0000`\u000b2\u0006\u0010\u0015\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J'\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u0000j\b\u0012\u0004\u0012\u00028\u0000`\u000b2\u0006\u0010\u0015\u001a\u00020\u0012H\u0002¢\u0006\u0004\b\u0018\u0010\u0017J\r\u0010\u0019\u001a\u00020\u0005¢\u0006\u0004\b\u0019\u0010\u001aJ\u0015\u0010\u001b\u001a\u00020\u00032\u0006\u0010\n\u001a\u00028\u0000¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u001d\u0010\u001eJ\u0013\u0010\u001f\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000¢\u0006\u0004\b\u001f\u0010 R\u0014\u0010\u0004\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010!R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\"R\u0014\u0010#\u001a\u00020\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010!R\u0011\u0010$\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b$\u0010\u001aR\u0011\u0010'\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b%\u0010&R%\u0010)\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0000j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\u000b0(8\u0002X\u0082\u0004R\u000b\u0010+\u001a\u00020*8\u0002X\u0082\u0004R\u0013\u0010-\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010,8\u0002X\u0082\u0004¨\u00060"}, d2 = {"Lkotlinx/coroutines/internal/LockFreeTaskQueueCore;", BuildConfig.FLAVOR, "E", BuildConfig.FLAVOR, "capacity", BuildConfig.FLAVOR, "singleConsumer", "<init>", "(IZ)V", "index", "element", "Lkotlinx/coroutines/internal/Core;", "fillPlaceholder", "(ILjava/lang/Object;)Lkotlinx/coroutines/internal/LockFreeTaskQueueCore;", "oldHead", "newHead", "removeSlowPath", "(II)Lkotlinx/coroutines/internal/LockFreeTaskQueueCore;", BuildConfig.FLAVOR, "markFrozen", "()J", "state", "allocateOrGetNextCopy", "(J)Lkotlinx/coroutines/internal/LockFreeTaskQueueCore;", "allocateNextCopy", "close", "()Z", "addLast", "(Ljava/lang/Object;)I", "removeFirstOrNull", "()Ljava/lang/Object;", "next", "()Lkotlinx/coroutines/internal/LockFreeTaskQueueCore;", "I", "Z", "mask", "isEmpty", "getSize", "()I", "size", "Lkotlinx/atomicfu/AtomicRef;", "_next", "Lkotlinx/atomicfu/AtomicLong;", "_state", "Lkotlinx/atomicfu/AtomicArray;", "array", "Companion", "Placeholder", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class LockFreeTaskQueueCore<E> {
    private volatile Object _next;
    private volatile long _state;
    private final AtomicReferenceArray array;
    private final int capacity;
    private final int mask;
    private final boolean singleConsumer;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final AtomicReferenceFieldUpdater _next$FU = AtomicReferenceFieldUpdater.newUpdater(LockFreeTaskQueueCore.class, Object.class, "_next");
    private static final AtomicLongFieldUpdater _state$FU = AtomicLongFieldUpdater.newUpdater(LockFreeTaskQueueCore.class, "_state");
    public static final Symbol REMOVE_FROZEN = new Symbol("REMOVE_FROZEN");

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0006\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0086\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\n\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\r\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\f\u001a\u00020\b¢\u0006\u0004\b\r\u0010\u000bJ\u0011\u0010\u000e\u001a\u00020\b*\u00020\u0004¢\u0006\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0012\u0010\u0011R\u0014\u0010\u0013\u001a\u00020\b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0013\u0010\u0011R\u0014\u0010\u0014\u001a\u00020\b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0014\u0010\u0011R\u0014\u0010\u0015\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0017\u001a\u00020\b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0017\u0010\u0011R\u0014\u0010\u0018\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0018\u0010\u0016R\u0014\u0010\u0019\u001a\u00020\b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0019\u0010\u0011R\u0014\u0010\u001a\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001a\u0010\u0016R\u0014\u0010\u001b\u001a\u00020\b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001b\u0010\u0011R\u0014\u0010\u001c\u001a\u00020\b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001c\u0010\u0011R\u0014\u0010\u001d\u001a\u00020\b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001d\u0010\u0011R\u0014\u0010\u001e\u001a\u00020\b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u001e\u0010\u0011R\u0014\u0010 \u001a\u00020\u001f8\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u0014\u0010\"\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\"\u0010\u0016R\u0014\u0010#\u001a\u00020\b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b#\u0010\u0011¨\u0006$"}, d2 = {"Lkotlinx/coroutines/internal/LockFreeTaskQueueCore$Companion;", BuildConfig.FLAVOR, "<init>", "()V", BuildConfig.FLAVOR, "other", "wo", "(JJ)J", BuildConfig.FLAVOR, "newHead", "updateHead", "(JI)J", "newTail", "updateTail", "addFailReason", "(J)I", "ADD_CLOSED", "I", "ADD_FROZEN", "ADD_SUCCESS", "CAPACITY_BITS", "CLOSED_MASK", "J", "CLOSED_SHIFT", "FROZEN_MASK", "FROZEN_SHIFT", "HEAD_MASK", "HEAD_SHIFT", "INITIAL_CAPACITY", "MAX_CAPACITY_MASK", "MIN_ADD_SPIN_CAPACITY", "Lkotlinx/coroutines/internal/Symbol;", "REMOVE_FROZEN", "Lkotlinx/coroutines/internal/Symbol;", "TAIL_MASK", "TAIL_SHIFT", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int addFailReason(long j5) {
            return (j5 & 2305843009213693952L) != 0 ? 2 : 1;
        }

        public final long updateHead(long j5, int i5) {
            return wo(j5, 1073741823L) | i5;
        }

        public final long updateTail(long j5, int i5) {
            return wo(j5, 1152921503533105152L) | (i5 << 30);
        }

        public final long wo(long j5, long j6) {
            return j5 & (~j6);
        }

        private Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lkotlinx/coroutines/internal/LockFreeTaskQueueCore$Placeholder;", BuildConfig.FLAVOR, "index", BuildConfig.FLAVOR, "(I)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Placeholder {
        public final int index;

        public Placeholder(int i5) {
            this.index = i5;
        }
    }

    public LockFreeTaskQueueCore(int i5, boolean z5) {
        this.capacity = i5;
        this.singleConsumer = z5;
        int i6 = i5 - 1;
        this.mask = i6;
        this.array = new AtomicReferenceArray(i5);
        if (i6 > 1073741823) {
            throw new IllegalStateException("Check failed.");
        }
        if ((i5 & i6) != 0) {
            throw new IllegalStateException("Check failed.");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final LockFreeTaskQueueCore<E> allocateNextCopy(long state) {
        LockFreeTaskQueueCore<E> lockFreeTaskQueueCore = new LockFreeTaskQueueCore<>(this.capacity * 2, this.singleConsumer);
        int i5 = (int) (1073741823 & state);
        int i6 = (int) ((1152921503533105152L & state) >> 30);
        while (true) {
            int i7 = this.mask;
            if ((i5 & i7) == (i6 & i7)) {
                _state$FU.set(lockFreeTaskQueueCore, INSTANCE.wo(state, 1152921504606846976L));
                return lockFreeTaskQueueCore;
            }
            Object obj = this.array.get(i7 & i5);
            if (obj == null) {
                obj = new Placeholder(i5);
            }
            lockFreeTaskQueueCore.array.set(lockFreeTaskQueueCore.mask & i5, obj);
            i5++;
        }
    }

    private final LockFreeTaskQueueCore<E> allocateOrGetNextCopy(long state) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = _next$FU;
        while (true) {
            LockFreeTaskQueueCore<E> lockFreeTaskQueueCore = (LockFreeTaskQueueCore) atomicReferenceFieldUpdater.get(this);
            if (lockFreeTaskQueueCore != null) {
                return lockFreeTaskQueueCore;
            }
            a.a(_next$FU, this, null, allocateNextCopy(state));
        }
    }

    private final LockFreeTaskQueueCore<E> fillPlaceholder(int index, E element) {
        Object obj = this.array.get(this.mask & index);
        if (!(obj instanceof Placeholder) || ((Placeholder) obj).index != index) {
            return null;
        }
        this.array.set(index & this.mask, element);
        return this;
    }

    private final long markFrozen() {
        long j5;
        long j6;
        AtomicLongFieldUpdater atomicLongFieldUpdater = _state$FU;
        do {
            j5 = atomicLongFieldUpdater.get(this);
            if ((j5 & 1152921504606846976L) != 0) {
                return j5;
            }
            j6 = j5 | 1152921504606846976L;
        } while (!atomicLongFieldUpdater.compareAndSet(this, j5, j6));
        return j6;
    }

    private final LockFreeTaskQueueCore<E> removeSlowPath(int oldHead, int newHead) {
        long j5;
        int i5;
        AtomicLongFieldUpdater atomicLongFieldUpdater = _state$FU;
        do {
            j5 = atomicLongFieldUpdater.get(this);
            i5 = (int) (1073741823 & j5);
            if ((1152921504606846976L & j5) != 0) {
                return next();
            }
        } while (!_state$FU.compareAndSet(this, j5, INSTANCE.updateHead(j5, newHead)));
        this.array.set(this.mask & i5, null);
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x004e, code lost:
    
        return 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int addLast(E element) {
        AtomicLongFieldUpdater atomicLongFieldUpdater = _state$FU;
        while (true) {
            long j5 = atomicLongFieldUpdater.get(this);
            if ((3458764513820540928L & j5) != 0) {
                return INSTANCE.addFailReason(j5);
            }
            int i5 = (int) (1073741823 & j5);
            int i6 = (int) ((1152921503533105152L & j5) >> 30);
            int i7 = this.mask;
            if (((i6 + 2) & i7) == (i5 & i7)) {
                return 1;
            }
            if (!this.singleConsumer && this.array.get(i6 & i7) != null) {
                int i8 = this.capacity;
                if (i8 < 1024 || ((i6 - i5) & 1073741823) > (i8 >> 1)) {
                    break;
                }
            } else if (_state$FU.compareAndSet(this, j5, INSTANCE.updateTail(j5, (i6 + 1) & 1073741823))) {
                this.array.set(i6 & i7, element);
                LockFreeTaskQueueCore<E> lockFreeTaskQueueCore = this;
                while ((_state$FU.get(lockFreeTaskQueueCore) & 1152921504606846976L) != 0 && (lockFreeTaskQueueCore = lockFreeTaskQueueCore.next().fillPlaceholder(i6, element)) != null) {
                }
                return 0;
            }
        }
    }

    public final boolean close() {
        long j5;
        AtomicLongFieldUpdater atomicLongFieldUpdater = _state$FU;
        do {
            j5 = atomicLongFieldUpdater.get(this);
            if ((j5 & 2305843009213693952L) != 0) {
                return true;
            }
            if ((1152921504606846976L & j5) != 0) {
                return false;
            }
        } while (!atomicLongFieldUpdater.compareAndSet(this, j5, j5 | 2305843009213693952L));
        return true;
    }

    public final int getSize() {
        long j5 = _state$FU.get(this);
        return (((int) ((j5 & 1152921503533105152L) >> 30)) - ((int) (1073741823 & j5))) & 1073741823;
    }

    public final boolean isEmpty() {
        long j5 = _state$FU.get(this);
        return ((int) (1073741823 & j5)) == ((int) ((j5 & 1152921503533105152L) >> 30));
    }

    public final LockFreeTaskQueueCore<E> next() {
        return allocateOrGetNextCopy(markFrozen());
    }

    public final Object removeFirstOrNull() {
        AtomicLongFieldUpdater atomicLongFieldUpdater = _state$FU;
        while (true) {
            long j5 = atomicLongFieldUpdater.get(this);
            if ((1152921504606846976L & j5) != 0) {
                return REMOVE_FROZEN;
            }
            int i5 = (int) (1073741823 & j5);
            int i6 = this.mask;
            if ((((int) ((1152921503533105152L & j5) >> 30)) & i6) == (i5 & i6)) {
                return null;
            }
            Object obj = this.array.get(i6 & i5);
            if (obj == null) {
                if (this.singleConsumer) {
                    return null;
                }
            } else {
                if (obj instanceof Placeholder) {
                    return null;
                }
                int i7 = (i5 + 1) & 1073741823;
                if (_state$FU.compareAndSet(this, j5, INSTANCE.updateHead(j5, i7))) {
                    this.array.set(this.mask & i5, null);
                    return obj;
                }
                if (this.singleConsumer) {
                    LockFreeTaskQueueCore<E> lockFreeTaskQueueCore = this;
                    do {
                        lockFreeTaskQueueCore = lockFreeTaskQueueCore.removeSlowPath(i5, i7);
                    } while (lockFreeTaskQueueCore != null);
                    return obj;
                }
            }
        }
    }
}
