package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aE\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u0016\b\u0002\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"E", BuildConfig.FLAVOR, "capacity", "Lkotlinx/coroutines/channels/BufferOverflow;", "onBufferOverflow", "Lkotlin/Function1;", BuildConfig.FLAVOR, "onUndeliveredElement", "Lkotlinx/coroutines/channels/Channel;", "Channel", "(ILkotlinx/coroutines/channels/BufferOverflow;Lkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/channels/Channel;", "kotlinx-coroutines-core"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public abstract class ChannelKt {
    public static final <E> Channel<E> Channel(int i5, BufferOverflow bufferOverflow, Function1<? super E, Unit> function1) {
        Channel<E> bufferedChannel;
        if (i5 == -2) {
            bufferedChannel = bufferOverflow == BufferOverflow.SUSPEND ? new BufferedChannel<>(Channel.INSTANCE.getCHANNEL_DEFAULT_CAPACITY$kotlinx_coroutines_core(), function1) : new ConflatedBufferedChannel<>(1, bufferOverflow, function1);
        } else {
            if (i5 == -1) {
                if (bufferOverflow == BufferOverflow.SUSPEND) {
                    return new ConflatedBufferedChannel(1, BufferOverflow.DROP_OLDEST, function1);
                }
                throw new IllegalArgumentException("CONFLATED capacity cannot be used with non-default onBufferOverflow");
            }
            if (i5 != 0) {
                return i5 != Integer.MAX_VALUE ? bufferOverflow == BufferOverflow.SUSPEND ? new BufferedChannel(i5, function1) : new ConflatedBufferedChannel(i5, bufferOverflow, function1) : new BufferedChannel(Integer.MAX_VALUE, function1);
            }
            bufferedChannel = bufferOverflow == BufferOverflow.SUSPEND ? new BufferedChannel<>(0, function1) : new ConflatedBufferedChannel<>(1, bufferOverflow, function1);
        }
        return bufferedChannel;
    }

    public static /* synthetic */ Channel Channel$default(int i5, BufferOverflow bufferOverflow, Function1 function1, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            i5 = 0;
        }
        if ((i6 & 2) != 0) {
            bufferOverflow = BufferOverflow.SUSPEND;
        }
        if ((i6 & 4) != 0) {
            function1 = null;
        }
        return Channel(i5, bufferOverflow, function1);
    }
}
