package okhttp3.sse;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.internal.sse.RealEventSource;
import okhttp3.sse.EventSource;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lokhttp3/sse/EventSources;", BuildConfig.FLAVOR, "<init>", "()V", "Lokhttp3/OkHttpClient;", "client", "Lokhttp3/sse/EventSource$Factory;", "createFactory", "(Lokhttp3/OkHttpClient;)Lokhttp3/sse/EventSource$Factory;", "okhttp-sse"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes3.dex */
public final class EventSources {
    public static final EventSources INSTANCE = new EventSources();

    private EventSources() {
    }

    public static final EventSource.Factory createFactory(final OkHttpClient client) {
        Intrinsics.checkNotNullParameter(client, "client");
        return new EventSource.Factory() { // from class: okhttp3.sse.EventSources$createFactory$1
            @Override // okhttp3.sse.EventSource.Factory
            public final EventSource newEventSource(Request request, EventSourceListener listener) {
                Intrinsics.checkNotNullParameter(request, "request");
                Intrinsics.checkNotNullParameter(listener, "listener");
                if (request.header("Accept") == null) {
                    request = request.newBuilder().addHeader("Accept", "text/event-stream").build();
                }
                RealEventSource realEventSource = new RealEventSource(request, listener);
                realEventSource.connect(OkHttpClient.this);
                return realEventSource;
            }
        };
    }
}
