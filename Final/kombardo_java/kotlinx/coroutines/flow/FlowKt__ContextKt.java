package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.internal.ChannelFlowOperatorImpl;
import kotlinx.coroutines.flow.internal.FusibleFlow;
import org.conscrypt.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a7\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007\u001a#\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"T", "Lkotlinx/coroutines/flow/Flow;", BuildConfig.FLAVOR, "capacity", "Lkotlinx/coroutines/channels/BufferOverflow;", "onBufferOverflow", "buffer", "(Lkotlinx/coroutines/flow/Flow;ILkotlinx/coroutines/channels/BufferOverflow;)Lkotlinx/coroutines/flow/Flow;", "conflate", "(Lkotlinx/coroutines/flow/Flow;)Lkotlinx/coroutines/flow/Flow;", "kotlinx-coroutines-core"}, k = 5, mv = {1, 8, 0}, xi = 48, xs = "kotlinx/coroutines/flow/FlowKt")
/* loaded from: classes3.dex */
public abstract /* synthetic */ class FlowKt__ContextKt {
    public static final <T> Flow<T> buffer(Flow<? extends T> flow, int i5, BufferOverflow bufferOverflow) {
        if (i5 < 0 && i5 != -2 && i5 != -1) {
            throw new IllegalArgumentException(("Buffer size should be non-negative, BUFFERED, or CONFLATED, but was " + i5).toString());
        }
        if (i5 == -1 && bufferOverflow != BufferOverflow.SUSPEND) {
            throw new IllegalArgumentException("CONFLATED capacity cannot be used with non-default onBufferOverflow");
        }
        if (i5 == -1) {
            bufferOverflow = BufferOverflow.DROP_OLDEST;
            i5 = 0;
        }
        int i6 = i5;
        BufferOverflow bufferOverflow2 = bufferOverflow;
        return flow instanceof FusibleFlow ? FusibleFlow.DefaultImpls.fuse$default((FusibleFlow) flow, null, i6, bufferOverflow2, 1, null) : new ChannelFlowOperatorImpl(flow, null, i6, bufferOverflow2, 2, null);
    }

    public static /* synthetic */ Flow buffer$default(Flow flow, int i5, BufferOverflow bufferOverflow, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            i5 = -2;
        }
        if ((i6 & 2) != 0) {
            bufferOverflow = BufferOverflow.SUSPEND;
        }
        return FlowKt.buffer(flow, i5, bufferOverflow);
    }

    public static final <T> Flow<T> conflate(Flow<? extends T> flow) {
        return FlowKt.buffer$default(flow, -1, null, 2, null);
    }
}
