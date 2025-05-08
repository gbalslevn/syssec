package kotlinx.coroutines.internal;

import com.sdk.growthbook.utils.Constants;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aN\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\"\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u0000*\u00028\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0018\u0010\u0005\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00000\u0004H\u0000ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\b\u001a#\u0010\u000b\u001a\u00028\u0000\"\u000e\b\u0000\u0010\n*\b\u0012\u0004\u0012\u00028\u00000\t*\u00028\u0000H\u0000¢\u0006\u0004\b\u000b\u0010\f\u001a0\u0010\u0013\u001a\u00020\u0011*\u00020\r2\u0006\u0010\u000f\u001a\u00020\u000e2\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00110\u0010H\u0082\b¢\u0006\u0004\b\u0013\u0010\u0014\"\u0014\u0010\u0015\u001a\u00020\u000e8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016\"\u0014\u0010\u0018\u001a\u00020\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001a"}, d2 = {"Lkotlinx/coroutines/internal/Segment;", "S", BuildConfig.FLAVOR, Constants.ID_ATTRIBUTE_KEY, "Lkotlin/Function2;", "createNewSegment", "Lkotlinx/coroutines/internal/SegmentOrClosed;", "findSegmentInternal", "(Lkotlinx/coroutines/internal/Segment;JLkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "Lkotlinx/coroutines/internal/ConcurrentLinkedListNode;", "N", "close", "(Lkotlinx/coroutines/internal/ConcurrentLinkedListNode;)Lkotlinx/coroutines/internal/ConcurrentLinkedListNode;", "Lkotlinx/atomicfu/AtomicInt;", BuildConfig.FLAVOR, "delta", "Lkotlin/Function1;", BuildConfig.FLAVOR, "condition", "addConditionally", "(Lkotlinx/atomicfu/AtomicInt;ILkotlin/jvm/functions/Function1;)Z", "POINTERS_SHIFT", "I", "Lkotlinx/coroutines/internal/Symbol;", "CLOSED", "Lkotlinx/coroutines/internal/Symbol;", "kotlinx-coroutines-core"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public abstract class ConcurrentLinkedListKt {
    private static final Symbol CLOSED = new Symbol("CLOSED");
    private static final int POINTERS_SHIFT = 16;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [kotlinx.coroutines.internal.ConcurrentLinkedListNode] */
    public static final <N extends ConcurrentLinkedListNode<N>> N close(N n5) {
        while (true) {
            Object nextOrClosed = n5.getNextOrClosed();
            if (nextOrClosed == CLOSED) {
                return n5;
            }
            ?? r02 = (ConcurrentLinkedListNode) nextOrClosed;
            if (r02 != 0) {
                n5 = r02;
            } else if (n5.markAsClosed()) {
                return n5;
            }
        }
    }

    public static final <S extends Segment<S>> Object findSegmentInternal(S s5, long j5, Function2<? super Long, ? super S, ? extends S> function2) {
        while (true) {
            if (s5.id >= j5 && !s5.isRemoved()) {
                return SegmentOrClosed.m3790constructorimpl(s5);
            }
            Object nextOrClosed = s5.getNextOrClosed();
            if (nextOrClosed == CLOSED) {
                return SegmentOrClosed.m3790constructorimpl(CLOSED);
            }
            S s6 = (S) ((ConcurrentLinkedListNode) nextOrClosed);
            if (s6 == null) {
                s6 = function2.invoke(Long.valueOf(s5.id + 1), s5);
                if (s5.trySetNext(s6)) {
                    if (s5.isRemoved()) {
                        s5.remove();
                    }
                }
            }
            s5 = s6;
        }
    }
}
