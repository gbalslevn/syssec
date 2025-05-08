package kotlinx.coroutines.channels;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.AbstractCoroutine;
import kotlinx.coroutines.JobCancellationException;
import kotlinx.coroutines.JobSupport;
import kotlinx.coroutines.selects.SelectClause1;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0010\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00020\u00030\u00022\b\u0012\u0004\u0012\u00028\u00000\u0004B-\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u000f\u001a\u00020\b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0096\u0001¢\u0006\u0004\b\u000f\u0010\u0010J&\u0010\u0013\u001a\u00020\u00032\u0014\u0010\u0012\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\r\u0012\u0004\u0012\u00020\u00030\u0011H\u0096\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0016\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u0015H\u0096\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u0013\u0010\u0018\u001a\u00028\u0000H\u0096Aø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019J\"\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00000\u001aH\u0096Aø\u0001\u0001ø\u0001\u0002ø\u0001\u0000ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u0019J\u001b\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00028\u0000H\u0096Aø\u0001\u0000¢\u0006\u0004\b\u001e\u0010\u001fJ\u001f\u0010\"\u001a\b\u0012\u0004\u0012\u00028\u00000\u001aH\u0096\u0001ø\u0001\u0001ø\u0001\u0002ø\u0001\u0000¢\u0006\u0004\b \u0010!J'\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00030\u001a2\u0006\u0010\u001d\u001a\u00028\u0000H\u0096\u0001ø\u0001\u0001ø\u0001\u0002ø\u0001\u0000¢\u0006\u0004\b#\u0010$J\u001d\u0010(\u001a\u00020\u00032\u000e\u0010\u000e\u001a\n\u0018\u00010&j\u0004\u0018\u0001`'¢\u0006\u0004\b(\u0010)J\u0017\u0010*\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b*\u0010+R \u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u00048\u0004X\u0084\u0004¢\u0006\f\n\u0004\b\u0007\u0010,\u001a\u0004\b-\u0010.R\u0014\u0010/\u001a\u00020\b8\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b/\u00100R#\u00104\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u001a018\u0016X\u0096\u0005ø\u0001\u0000¢\u0006\u0006\u001a\u0004\b2\u00103R\u0017\u00106\u001a\b\u0012\u0004\u0012\u00028\u00000\u00048F¢\u0006\u0006\u001a\u0004\b5\u0010.\u0082\u0002\u000f\n\u0002\b\u0019\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u00067"}, d2 = {"Lkotlinx/coroutines/channels/ChannelCoroutine;", "E", "Lkotlinx/coroutines/AbstractCoroutine;", BuildConfig.FLAVOR, "Lkotlinx/coroutines/channels/Channel;", "Lkotlin/coroutines/CoroutineContext;", "parentContext", "_channel", BuildConfig.FLAVOR, "initParentJob", "active", "<init>", "(Lkotlin/coroutines/CoroutineContext;Lkotlinx/coroutines/channels/Channel;ZZ)V", BuildConfig.FLAVOR, "cause", "close", "(Ljava/lang/Throwable;)Z", "Lkotlin/Function1;", "handler", "invokeOnClose", "(Lkotlin/jvm/functions/Function1;)V", "Lkotlinx/coroutines/channels/ChannelIterator;", "iterator", "()Lkotlinx/coroutines/channels/ChannelIterator;", "receive", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlinx/coroutines/channels/ChannelResult;", "receiveCatching-JP2dKIU", "receiveCatching", "element", "send", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "tryReceive-PtdJZtk", "()Ljava/lang/Object;", "tryReceive", "trySend-JP2dKIU", "(Ljava/lang/Object;)Ljava/lang/Object;", "trySend", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "cancel", "(Ljava/util/concurrent/CancellationException;)V", "cancelInternal", "(Ljava/lang/Throwable;)V", "Lkotlinx/coroutines/channels/Channel;", "get_channel", "()Lkotlinx/coroutines/channels/Channel;", "isClosedForSend", "()Z", "Lkotlinx/coroutines/selects/SelectClause1;", "getOnReceiveCatching", "()Lkotlinx/coroutines/selects/SelectClause1;", "onReceiveCatching", "getChannel", "channel", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public abstract class ChannelCoroutine<E> extends AbstractCoroutine<Unit> implements Channel<E> {
    private final Channel<E> _channel;

    public ChannelCoroutine(CoroutineContext coroutineContext, Channel<E> channel, boolean z5, boolean z6) {
        super(coroutineContext, z5, z6);
        this._channel = channel;
    }

    @Override // kotlinx.coroutines.JobSupport, kotlinx.coroutines.Job
    public final void cancel(CancellationException cause) {
        if (isCancelled()) {
            return;
        }
        if (cause == null) {
            cause = new JobCancellationException(cancellationExceptionMessage(), null, this);
        }
        cancelInternal(cause);
    }

    @Override // kotlinx.coroutines.JobSupport
    public void cancelInternal(Throwable cause) {
        CancellationException cancellationException$default = JobSupport.toCancellationException$default(this, cause, null, 1, null);
        this._channel.cancel(cancellationException$default);
        cancelCoroutine(cancellationException$default);
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public boolean close(Throwable cause) {
        return this._channel.close(cause);
    }

    public final Channel<E> getChannel() {
        return this;
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public SelectClause1<ChannelResult<E>> getOnReceiveCatching() {
        return this._channel.getOnReceiveCatching();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Channel<E> get_channel() {
        return this._channel;
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public void invokeOnClose(Function1<? super Throwable, Unit> handler) {
        this._channel.invokeOnClose(handler);
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public boolean isClosedForSend() {
        return this._channel.isClosedForSend();
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public ChannelIterator<E> iterator() {
        return this._channel.iterator();
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    public Object receive(Continuation<? super E> continuation) {
        return this._channel.receive(continuation);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    /* renamed from: receiveCatching-JP2dKIU */
    public Object mo3765receiveCatchingJP2dKIU(Continuation<? super ChannelResult<? extends E>> continuation) {
        Object mo3765receiveCatchingJP2dKIU = this._channel.mo3765receiveCatchingJP2dKIU(continuation);
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        return mo3765receiveCatchingJP2dKIU;
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    public Object send(E e5, Continuation<? super Unit> continuation) {
        return this._channel.send(e5, continuation);
    }

    @Override // kotlinx.coroutines.channels.ReceiveChannel
    /* renamed from: tryReceive-PtdJZtk */
    public Object mo3766tryReceivePtdJZtk() {
        return this._channel.mo3766tryReceivePtdJZtk();
    }

    @Override // kotlinx.coroutines.channels.SendChannel
    /* renamed from: trySend-JP2dKIU */
    public Object mo3767trySendJP2dKIU(E element) {
        return this._channel.mo3767trySendJP2dKIU(element);
    }
}
