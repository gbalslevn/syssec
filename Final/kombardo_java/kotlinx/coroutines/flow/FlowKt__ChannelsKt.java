package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.channels.ChannelIterator;
import kotlinx.coroutines.channels.ChannelsKt;
import kotlinx.coroutines.channels.ReceiveChannel;
import org.conscrypt.BuildConfig;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a1\u0010\u0005\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a9\u0010\u000b\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0082@ø\u0001\u0000¢\u0006\u0004\b\t\u0010\n\u001a#\u0010\r\u001a\b\u0012\u0004\u0012\u00028\u00000\f\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0002¢\u0006\u0004\b\r\u0010\u000e\u001a#\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\f\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0002¢\u0006\u0004\b\u000f\u0010\u000e\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0010"}, d2 = {"T", "Lkotlinx/coroutines/flow/FlowCollector;", "Lkotlinx/coroutines/channels/ReceiveChannel;", "channel", BuildConfig.FLAVOR, "emitAll", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlinx/coroutines/channels/ReceiveChannel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", BuildConfig.FLAVOR, "consume", "emitAllImpl$FlowKt__ChannelsKt", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlinx/coroutines/channels/ReceiveChannel;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "emitAllImpl", "Lkotlinx/coroutines/flow/Flow;", "receiveAsFlow", "(Lkotlinx/coroutines/channels/ReceiveChannel;)Lkotlinx/coroutines/flow/Flow;", "consumeAsFlow", "kotlinx-coroutines-core"}, k = 5, mv = {1, 8, 0}, xi = 48, xs = "kotlinx/coroutines/flow/FlowKt")
/* loaded from: classes3.dex */
public abstract /* synthetic */ class FlowKt__ChannelsKt {
    public static final <T> Flow<T> consumeAsFlow(ReceiveChannel<? extends T> receiveChannel) {
        return new ChannelAsFlow(receiveChannel, true, null, 0, null, 28, null);
    }

    public static final <T> Object emitAll(FlowCollector<? super T> flowCollector, ReceiveChannel<? extends T> receiveChannel, Continuation<? super Unit> continuation) {
        Object emitAllImpl$FlowKt__ChannelsKt = emitAllImpl$FlowKt__ChannelsKt(flowCollector, receiveChannel, true, continuation);
        return emitAllImpl$FlowKt__ChannelsKt == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? emitAllImpl$FlowKt__ChannelsKt : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0072 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x007f A[Catch: all -> 0x003c, TRY_LEAVE, TryCatch #0 {all -> 0x003c, blocks: (B:12:0x0036, B:14:0x0062, B:19:0x0077, B:21:0x007f, B:32:0x0054, B:34:0x005e), top: B:7:0x0022 }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0024  */
    /* JADX WARN: Type inference failed for: r2v1, types: [kotlinx.coroutines.flow.FlowCollector, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0091 -> B:13:0x0039). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <T> Object emitAllImpl$FlowKt__ChannelsKt(FlowCollector<? super T> flowCollector, ReceiveChannel<? extends T> receiveChannel, boolean z5, Continuation<? super Unit> continuation) {
        FlowKt__ChannelsKt$emitAllImpl$1 flowKt__ChannelsKt$emitAllImpl$1;
        int i5;
        ChannelIterator<? extends T> it;
        ChannelIterator<? extends T> channelIterator;
        ?? r22;
        Object hasNext;
        try {
            if (continuation instanceof FlowKt__ChannelsKt$emitAllImpl$1) {
                flowKt__ChannelsKt$emitAllImpl$1 = (FlowKt__ChannelsKt$emitAllImpl$1) continuation;
                int i6 = flowKt__ChannelsKt$emitAllImpl$1.label;
                if ((i6 & Integer.MIN_VALUE) != 0) {
                    flowKt__ChannelsKt$emitAllImpl$1.label = i6 - Integer.MIN_VALUE;
                    Object obj = flowKt__ChannelsKt$emitAllImpl$1.result;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    i5 = flowKt__ChannelsKt$emitAllImpl$1.label;
                    if (i5 != 0) {
                        ResultKt.throwOnFailure(obj);
                        FlowKt.ensureActive(flowCollector);
                        it = receiveChannel.iterator();
                        flowKt__ChannelsKt$emitAllImpl$1.L$0 = flowCollector;
                        flowKt__ChannelsKt$emitAllImpl$1.L$1 = receiveChannel;
                        flowKt__ChannelsKt$emitAllImpl$1.L$2 = it;
                        flowKt__ChannelsKt$emitAllImpl$1.Z$0 = z5;
                        flowKt__ChannelsKt$emitAllImpl$1.label = 1;
                        hasNext = it.hasNext(flowKt__ChannelsKt$emitAllImpl$1);
                        if (hasNext == coroutine_suspended) {
                        }
                    } else if (i5 == 1) {
                        z5 = flowKt__ChannelsKt$emitAllImpl$1.Z$0;
                        channelIterator = (ChannelIterator) flowKt__ChannelsKt$emitAllImpl$1.L$2;
                        receiveChannel = (ReceiveChannel) flowKt__ChannelsKt$emitAllImpl$1.L$1;
                        FlowCollector flowCollector2 = (FlowCollector) flowKt__ChannelsKt$emitAllImpl$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        r22 = flowCollector2;
                        if (((Boolean) obj).booleanValue()) {
                        }
                    } else {
                        if (i5 != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        z5 = flowKt__ChannelsKt$emitAllImpl$1.Z$0;
                        channelIterator = (ChannelIterator) flowKt__ChannelsKt$emitAllImpl$1.L$2;
                        receiveChannel = (ReceiveChannel) flowKt__ChannelsKt$emitAllImpl$1.L$1;
                        FlowCollector<? super T> flowCollector3 = (FlowCollector) flowKt__ChannelsKt$emitAllImpl$1.L$0;
                        ResultKt.throwOnFailure(obj);
                        FlowCollector<? super T> flowCollector4 = flowCollector3;
                        it = channelIterator;
                        flowCollector = flowCollector4;
                        flowKt__ChannelsKt$emitAllImpl$1.L$0 = flowCollector;
                        flowKt__ChannelsKt$emitAllImpl$1.L$1 = receiveChannel;
                        flowKt__ChannelsKt$emitAllImpl$1.L$2 = it;
                        flowKt__ChannelsKt$emitAllImpl$1.Z$0 = z5;
                        flowKt__ChannelsKt$emitAllImpl$1.label = 1;
                        hasNext = it.hasNext(flowKt__ChannelsKt$emitAllImpl$1);
                        if (hasNext == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        r22 = flowCollector;
                        channelIterator = it;
                        obj = hasNext;
                        if (((Boolean) obj).booleanValue()) {
                            if (z5) {
                                ChannelsKt.cancelConsumed(receiveChannel, null);
                            }
                            return Unit.INSTANCE;
                        }
                        T next = channelIterator.next();
                        flowKt__ChannelsKt$emitAllImpl$1.L$0 = r22;
                        flowKt__ChannelsKt$emitAllImpl$1.L$1 = receiveChannel;
                        flowKt__ChannelsKt$emitAllImpl$1.L$2 = channelIterator;
                        flowKt__ChannelsKt$emitAllImpl$1.Z$0 = z5;
                        flowKt__ChannelsKt$emitAllImpl$1.label = 2;
                        Object emit = r22.emit(next, flowKt__ChannelsKt$emitAllImpl$1);
                        flowCollector4 = r22;
                        if (emit == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        it = channelIterator;
                        flowCollector = flowCollector4;
                        flowKt__ChannelsKt$emitAllImpl$1.L$0 = flowCollector;
                        flowKt__ChannelsKt$emitAllImpl$1.L$1 = receiveChannel;
                        flowKt__ChannelsKt$emitAllImpl$1.L$2 = it;
                        flowKt__ChannelsKt$emitAllImpl$1.Z$0 = z5;
                        flowKt__ChannelsKt$emitAllImpl$1.label = 1;
                        hasNext = it.hasNext(flowKt__ChannelsKt$emitAllImpl$1);
                        if (hasNext == coroutine_suspended) {
                        }
                    }
                }
            }
            if (i5 != 0) {
            }
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                if (z5) {
                    ChannelsKt.cancelConsumed(receiveChannel, th);
                }
                throw th2;
            }
        }
        flowKt__ChannelsKt$emitAllImpl$1 = new FlowKt__ChannelsKt$emitAllImpl$1(continuation);
        Object obj2 = flowKt__ChannelsKt$emitAllImpl$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i5 = flowKt__ChannelsKt$emitAllImpl$1.label;
    }

    public static final <T> Flow<T> receiveAsFlow(ReceiveChannel<? extends T> receiveChannel) {
        return new ChannelAsFlow(receiveChannel, false, null, 0, null, 28, null);
    }
}
