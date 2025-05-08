package kotlin.collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.ranges.RangesKt;
import kotlin.sequences.SequenceScope;
import org.conscrypt.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: Add missing generic type declarations: [T] */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00040\u0003H\n"}, d2 = {"<anonymous>", BuildConfig.FLAVOR, "T", "Lkotlin/sequences/SequenceScope;", BuildConfig.FLAVOR}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "kotlin.collections.SlidingWindowKt$windowedIterator$1", f = "SlidingWindow.kt", l = {34, 40, 49, 55, 58}, m = "invokeSuspend")
/* loaded from: classes2.dex */
public final class SlidingWindowKt$windowedIterator$1<T> extends RestrictedSuspendLambda implements Function2<SequenceScope<? super List<? extends T>>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Iterator<T> $iterator;
    final /* synthetic */ boolean $partialWindows;
    final /* synthetic */ boolean $reuseBuffer;
    final /* synthetic */ int $size;
    final /* synthetic */ int $step;
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public SlidingWindowKt$windowedIterator$1(int i5, int i6, Iterator<? extends T> it, boolean z5, boolean z6, Continuation<? super SlidingWindowKt$windowedIterator$1> continuation) {
        super(2, continuation);
        this.$size = i5;
        this.$step = i6;
        this.$iterator = it;
        this.$reuseBuffer = z5;
        this.$partialWindows = z6;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        SlidingWindowKt$windowedIterator$1 slidingWindowKt$windowedIterator$1 = new SlidingWindowKt$windowedIterator$1(this.$size, this.$step, this.$iterator, this.$reuseBuffer, this.$partialWindows, continuation);
        slidingWindowKt$windowedIterator$1.L$0 = obj;
        return slidingWindowKt$windowedIterator$1;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x014e  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00d7 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00ad  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0145 -> B:12:0x0148). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:42:0x0117 -> B:30:0x011a). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:63:0x00a2 -> B:50:0x0055). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        RingBuffer ringBuffer;
        Iterator<T> it;
        SequenceScope sequenceScope;
        SequenceScope sequenceScope2;
        int i5;
        ArrayList arrayList;
        Iterator<T> it2;
        int i6;
        RingBuffer ringBuffer2;
        SequenceScope sequenceScope3;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i7 = this.label;
        if (i7 == 0) {
            ResultKt.throwOnFailure(obj);
            SequenceScope sequenceScope4 = (SequenceScope) this.L$0;
            int coerceAtMost = RangesKt.coerceAtMost(this.$size, 1024);
            int i8 = this.$step - this.$size;
            if (i8 < 0) {
                ringBuffer = new RingBuffer(coerceAtMost);
                it = this.$iterator;
                sequenceScope = sequenceScope4;
                while (it.hasNext()) {
                }
                if (this.$partialWindows) {
                }
                return Unit.INSTANCE;
            }
            sequenceScope2 = sequenceScope4;
            i5 = 0;
            arrayList = new ArrayList(coerceAtMost);
            it2 = this.$iterator;
            i6 = i8;
            while (it2.hasNext()) {
            }
            if (!arrayList.isEmpty()) {
                this.L$0 = null;
                this.L$1 = null;
                this.L$2 = null;
                this.label = 2;
                if (sequenceScope2.yield(arrayList, this) == coroutine_suspended) {
                }
            }
            return Unit.INSTANCE;
        }
        if (i7 == 1) {
            i6 = this.I$0;
            it2 = (Iterator) this.L$2;
            arrayList = (ArrayList) this.L$1;
            sequenceScope2 = (SequenceScope) this.L$0;
            ResultKt.throwOnFailure(obj);
            i5 = i6;
            if (this.$reuseBuffer) {
                arrayList = new ArrayList(this.$size);
            } else {
                arrayList.clear();
            }
            i6 = i5;
            while (it2.hasNext()) {
                T next = it2.next();
                if (i5 > 0) {
                    i5--;
                } else {
                    arrayList.add(next);
                    if (arrayList.size() == this.$size) {
                        this.L$0 = sequenceScope2;
                        this.L$1 = arrayList;
                        this.L$2 = it2;
                        this.I$0 = i6;
                        this.label = 1;
                        if (sequenceScope2.yield(arrayList, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        i5 = i6;
                        if (this.$reuseBuffer) {
                        }
                        i6 = i5;
                        while (it2.hasNext()) {
                        }
                    }
                }
            }
            if (!arrayList.isEmpty() && (this.$partialWindows || arrayList.size() == this.$size)) {
                this.L$0 = null;
                this.L$1 = null;
                this.L$2 = null;
                this.label = 2;
                if (sequenceScope2.yield(arrayList, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return Unit.INSTANCE;
        }
        if (i7 != 2) {
            if (i7 == 3) {
                it = (Iterator) this.L$2;
                ringBuffer = (RingBuffer) this.L$1;
                sequenceScope = (SequenceScope) this.L$0;
                ResultKt.throwOnFailure(obj);
                ringBuffer.removeFirst(this.$step);
                while (it.hasNext()) {
                    ringBuffer.add((RingBuffer) it.next());
                    if (ringBuffer.isFull()) {
                        int size = ringBuffer.size();
                        int i9 = this.$size;
                        if (size >= i9) {
                            RandomAccess arrayList2 = this.$reuseBuffer ? ringBuffer : new ArrayList(ringBuffer);
                            this.L$0 = sequenceScope;
                            this.L$1 = ringBuffer;
                            this.L$2 = it;
                            this.label = 3;
                            if (sequenceScope.yield(arrayList2, this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            ringBuffer.removeFirst(this.$step);
                            while (it.hasNext()) {
                            }
                        } else {
                            ringBuffer = ringBuffer.expanded(i9);
                        }
                    }
                }
                if (this.$partialWindows) {
                    ringBuffer2 = ringBuffer;
                    sequenceScope3 = sequenceScope;
                    if (ringBuffer2.size() <= this.$step) {
                    }
                }
                return Unit.INSTANCE;
            }
            if (i7 == 4) {
                ringBuffer2 = (RingBuffer) this.L$1;
                sequenceScope3 = (SequenceScope) this.L$0;
                ResultKt.throwOnFailure(obj);
                ringBuffer2.removeFirst(this.$step);
                if (ringBuffer2.size() <= this.$step) {
                    RandomAccess arrayList3 = this.$reuseBuffer ? ringBuffer2 : new ArrayList(ringBuffer2);
                    this.L$0 = sequenceScope3;
                    this.L$1 = ringBuffer2;
                    this.L$2 = null;
                    this.label = 4;
                    if (sequenceScope3.yield(arrayList3, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    ringBuffer2.removeFirst(this.$step);
                    if (ringBuffer2.size() <= this.$step) {
                        if (!ringBuffer2.isEmpty()) {
                            this.L$0 = null;
                            this.L$1 = null;
                            this.L$2 = null;
                            this.label = 5;
                            if (sequenceScope3.yield(ringBuffer2, this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
                        return Unit.INSTANCE;
                    }
                }
            } else if (i7 != 5) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }
        ResultKt.throwOnFailure(obj);
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(SequenceScope<? super List<? extends T>> sequenceScope, Continuation<? super Unit> continuation) {
        return ((SlidingWindowKt$windowedIterator$1) create(sequenceScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
