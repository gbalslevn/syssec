package kotlinx.coroutines.flow.internal;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b \u0018\u0000*\f\b\u0000\u0010\u0002*\u0006\u0012\u0002\b\u00030\u00012\u00060\u0003j\u0002`\u0004B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00028\u0000H$¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u000b2\u0006\u0010\n\u001a\u00020\tH$¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00028\u0000H\u0004¢\u0006\u0004\b\u000e\u0010\bJ\u0017\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00028\u0000H\u0004¢\u0006\u0004\b\u0011\u0010\u0012R8\u0010\u0014\u001a\f\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0018\u00010\u000b2\u0010\u0010\u0013\u001a\f\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0018\u00010\u000b8\u0004@BX\u0084\u000e¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R$\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\t8\u0004@BX\u0084\u000e¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001c\u001a\u00020\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u0019R\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0017\u0010#\u001a\b\u0012\u0004\u0012\u00020\t0 8F¢\u0006\u0006\u001a\u0004\b!\u0010\"¨\u0006$"}, d2 = {"Lkotlinx/coroutines/flow/internal/AbstractSharedFlow;", "Lkotlinx/coroutines/flow/internal/AbstractSharedFlowSlot;", "S", BuildConfig.FLAVOR, "Lkotlinx/coroutines/internal/SynchronizedObject;", "<init>", "()V", "createSlot", "()Lkotlinx/coroutines/flow/internal/AbstractSharedFlowSlot;", BuildConfig.FLAVOR, "size", BuildConfig.FLAVOR, "createSlotArray", "(I)[Lkotlinx/coroutines/flow/internal/AbstractSharedFlowSlot;", "allocateSlot", "slot", BuildConfig.FLAVOR, "freeSlot", "(Lkotlinx/coroutines/flow/internal/AbstractSharedFlowSlot;)V", "<set-?>", "slots", "[Lkotlinx/coroutines/flow/internal/AbstractSharedFlowSlot;", "getSlots", "()[Lkotlinx/coroutines/flow/internal/AbstractSharedFlowSlot;", "nCollectors", "I", "getNCollectors", "()I", "nextIndex", "Lkotlinx/coroutines/flow/internal/SubscriptionCountStateFlow;", "_subscriptionCount", "Lkotlinx/coroutines/flow/internal/SubscriptionCountStateFlow;", "Lkotlinx/coroutines/flow/StateFlow;", "getSubscriptionCount", "()Lkotlinx/coroutines/flow/StateFlow;", "subscriptionCount", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public abstract class AbstractSharedFlow<S extends AbstractSharedFlowSlot<?>> {
    private SubscriptionCountStateFlow _subscriptionCount;
    private int nCollectors;
    private int nextIndex;
    private S[] slots;

    public static final /* synthetic */ int access$getNCollectors(AbstractSharedFlow abstractSharedFlow) {
        return abstractSharedFlow.nCollectors;
    }

    public static final /* synthetic */ AbstractSharedFlowSlot[] access$getSlots(AbstractSharedFlow abstractSharedFlow) {
        return abstractSharedFlow.slots;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final S allocateSlot() {
        S s5;
        SubscriptionCountStateFlow subscriptionCountStateFlow;
        synchronized (this) {
            try {
                S[] sArr = this.slots;
                if (sArr == null) {
                    sArr = createSlotArray(2);
                    this.slots = sArr;
                } else if (this.nCollectors >= sArr.length) {
                    Object[] copyOf = Arrays.copyOf(sArr, sArr.length * 2);
                    Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
                    this.slots = (S[]) ((AbstractSharedFlowSlot[]) copyOf);
                    sArr = (S[]) ((AbstractSharedFlowSlot[]) copyOf);
                }
                int i5 = this.nextIndex;
                do {
                    s5 = sArr[i5];
                    if (s5 == null) {
                        s5 = createSlot();
                        sArr[i5] = s5;
                    }
                    i5++;
                    if (i5 >= sArr.length) {
                        i5 = 0;
                    }
                    Intrinsics.checkNotNull(s5, "null cannot be cast to non-null type kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot<kotlin.Any>");
                } while (!s5.allocateLocked(this));
                this.nextIndex = i5;
                this.nCollectors++;
                subscriptionCountStateFlow = this._subscriptionCount;
            } catch (Throwable th) {
                throw th;
            }
        }
        if (subscriptionCountStateFlow != null) {
            subscriptionCountStateFlow.increment(1);
        }
        return s5;
    }

    protected abstract S createSlot();

    protected abstract S[] createSlotArray(int size);

    /* JADX INFO: Access modifiers changed from: protected */
    public final void freeSlot(S slot) {
        SubscriptionCountStateFlow subscriptionCountStateFlow;
        int i5;
        Continuation<Unit>[] freeLocked;
        synchronized (this) {
            try {
                int i6 = this.nCollectors - 1;
                this.nCollectors = i6;
                subscriptionCountStateFlow = this._subscriptionCount;
                if (i6 == 0) {
                    this.nextIndex = 0;
                }
                Intrinsics.checkNotNull(slot, "null cannot be cast to non-null type kotlinx.coroutines.flow.internal.AbstractSharedFlowSlot<kotlin.Any>");
                freeLocked = slot.freeLocked(this);
            } catch (Throwable th) {
                throw th;
            }
        }
        for (Continuation<Unit> continuation : freeLocked) {
            if (continuation != null) {
                Result.Companion companion = Result.INSTANCE;
                continuation.resumeWith(Result.m3567constructorimpl(Unit.INSTANCE));
            }
        }
        if (subscriptionCountStateFlow != null) {
            subscriptionCountStateFlow.increment(-1);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int getNCollectors() {
        return this.nCollectors;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final S[] getSlots() {
        return this.slots;
    }

    public final StateFlow<Integer> getSubscriptionCount() {
        SubscriptionCountStateFlow subscriptionCountStateFlow;
        synchronized (this) {
            subscriptionCountStateFlow = this._subscriptionCount;
            if (subscriptionCountStateFlow == null) {
                subscriptionCountStateFlow = new SubscriptionCountStateFlow(this.nCollectors);
                this._subscriptionCount = subscriptionCountStateFlow;
            }
        }
        return subscriptionCountStateFlow;
    }
}
