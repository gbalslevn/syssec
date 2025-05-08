package okhttp3.sse;

import kotlin.Metadata;
import okhttp3.Request;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0001\u0005J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lokhttp3/sse/EventSource;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "cancel", "()V", "Factory", "okhttp-sse"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes3.dex */
public interface EventSource {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lokhttp3/sse/EventSource$Factory;", BuildConfig.FLAVOR, "newEventSource", "Lokhttp3/sse/EventSource;", "request", "Lokhttp3/Request;", "listener", "Lokhttp3/sse/EventSourceListener;", "okhttp-sse"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes3.dex */
    public interface Factory {
        EventSource newEventSource(Request request, EventSourceListener listener);
    }

    void cancel();
}
