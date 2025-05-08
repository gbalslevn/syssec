package okio;

import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004J\u0015\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\b\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\b\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u000f\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u000f\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u0001H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0001H\u0016¢\u0006\u0004\b\u0014\u0010\u0013J\u000f\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0016\u0010\u0017R\"\u0010\u0002\u001a\u00020\u00018\u0007@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0002\u0010\u0018\u001a\u0004\b\u0002\u0010\u0013\"\u0004\b\u0005\u0010\u0004¨\u0006\u0019"}, d2 = {"Lokio/ForwardingTimeout;", "Lokio/Timeout;", "delegate", "<init>", "(Lokio/Timeout;)V", "setDelegate", "(Lokio/Timeout;)Lokio/ForwardingTimeout;", BuildConfig.FLAVOR, "timeout", "Ljava/util/concurrent/TimeUnit;", "unit", "(JLjava/util/concurrent/TimeUnit;)Lokio/Timeout;", BuildConfig.FLAVOR, "hasDeadline", "()Z", "deadlineNanoTime", "()J", "(J)Lokio/Timeout;", "clearTimeout", "()Lokio/Timeout;", "clearDeadline", BuildConfig.FLAVOR, "throwIfReached", "()V", "Lokio/Timeout;", "okio"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public class ForwardingTimeout extends Timeout {
    private Timeout delegate;

    public ForwardingTimeout(Timeout delegate) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        this.delegate = delegate;
    }

    @Override // okio.Timeout
    public Timeout clearDeadline() {
        return this.delegate.clearDeadline();
    }

    @Override // okio.Timeout
    public Timeout clearTimeout() {
        return this.delegate.clearTimeout();
    }

    @Override // okio.Timeout
    public long deadlineNanoTime() {
        return this.delegate.deadlineNanoTime();
    }

    /* renamed from: delegate, reason: from getter */
    public final Timeout getDelegate() {
        return this.delegate;
    }

    @Override // okio.Timeout
    /* renamed from: hasDeadline */
    public boolean getHasDeadline() {
        return this.delegate.getHasDeadline();
    }

    public final ForwardingTimeout setDelegate(Timeout delegate) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        this.delegate = delegate;
        return this;
    }

    @Override // okio.Timeout
    public void throwIfReached() {
        this.delegate.throwIfReached();
    }

    @Override // okio.Timeout
    public Timeout timeout(long timeout, TimeUnit unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        return this.delegate.timeout(timeout, unit);
    }

    @Override // okio.Timeout
    public Timeout deadlineNanoTime(long deadlineNanoTime) {
        return this.delegate.deadlineNanoTime(deadlineNanoTime);
    }
}
