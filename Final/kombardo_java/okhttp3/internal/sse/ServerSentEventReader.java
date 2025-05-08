package okhttp3.internal.sse;

import com.sdk.growthbook.utils.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.Util;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import okio.Options;
import org.conscrypt.BuildConfig;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u0000 \u00122\u00020\u0001:\u0002\u0011\u0012B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J$\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\b2\b\u0010\f\u001a\u0004\u0018\u00010\b2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0006\u0010\u000f\u001a\u00020\u0010R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lokhttp3/internal/sse/ServerSentEventReader;", BuildConfig.FLAVOR, "source", "Lokio/BufferedSource;", com.sun.jna.Callback.METHOD_NAME, "Lokhttp3/internal/sse/ServerSentEventReader$Callback;", "(Lokio/BufferedSource;Lokhttp3/internal/sse/ServerSentEventReader$Callback;)V", "lastId", BuildConfig.FLAVOR, "completeEvent", BuildConfig.FLAVOR, Constants.ID_ATTRIBUTE_KEY, "type", "data", "Lokio/Buffer;", "processNextEvent", BuildConfig.FLAVOR, "Callback", "Companion", "okhttp-sse"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes3.dex */
public final class ServerSentEventReader {
    private static final ByteString CRLF;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Options options;
    private final Callback callback;
    private String lastId;
    private final BufferedSource source;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\bf\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0007\u001a\u00020\u0005H&J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH&¨\u0006\u000b"}, d2 = {"Lokhttp3/internal/sse/ServerSentEventReader$Callback;", BuildConfig.FLAVOR, "onEvent", BuildConfig.FLAVOR, Constants.ID_ATTRIBUTE_KEY, BuildConfig.FLAVOR, "type", "data", "onRetryChange", "timeMs", BuildConfig.FLAVOR, "okhttp-sse"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes3.dex */
    public interface Callback {
        void onEvent(String id, String type, String data);

        void onRetryChange(long timeMs);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\t\u001a\u00020\n*\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002J\f\u0010\u000e\u001a\u00020\u000f*\u00020\u000bH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0010"}, d2 = {"Lokhttp3/internal/sse/ServerSentEventReader$Companion;", BuildConfig.FLAVOR, "()V", "CRLF", "Lokio/ByteString;", "options", "Lokio/Options;", "getOptions", "()Lokio/Options;", "readData", BuildConfig.FLAVOR, "Lokio/BufferedSource;", "data", "Lokio/Buffer;", "readRetryMs", BuildConfig.FLAVOR, "okhttp-sse"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void readData(BufferedSource bufferedSource, Buffer buffer) {
            buffer.writeByte(10);
            bufferedSource.readFully(buffer, bufferedSource.indexOfElement(ServerSentEventReader.CRLF));
            bufferedSource.select(getOptions());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final long readRetryMs(BufferedSource bufferedSource) {
            return Util.toLongOrDefault(bufferedSource.readUtf8LineStrict(), -1L);
        }

        public final Options getOptions() {
            return ServerSentEventReader.options;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        Options.Companion companion = Options.INSTANCE;
        ByteString.Companion companion2 = ByteString.INSTANCE;
        options = companion.of(companion2.encodeUtf8("\r\n"), companion2.encodeUtf8("\r"), companion2.encodeUtf8("\n"), companion2.encodeUtf8("data: "), companion2.encodeUtf8("data:"), companion2.encodeUtf8("data\r\n"), companion2.encodeUtf8("data\r"), companion2.encodeUtf8("data\n"), companion2.encodeUtf8("id: "), companion2.encodeUtf8("id:"), companion2.encodeUtf8("id\r\n"), companion2.encodeUtf8("id\r"), companion2.encodeUtf8("id\n"), companion2.encodeUtf8("event: "), companion2.encodeUtf8("event:"), companion2.encodeUtf8("event\r\n"), companion2.encodeUtf8("event\r"), companion2.encodeUtf8("event\n"), companion2.encodeUtf8("retry: "), companion2.encodeUtf8("retry:"));
        CRLF = companion2.encodeUtf8("\r\n");
    }

    public ServerSentEventReader(BufferedSource source, Callback callback) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.source = source;
        this.callback = callback;
    }

    private final void completeEvent(String id, String type, Buffer data) {
        if (data.getSize() != 0) {
            this.lastId = id;
            data.skip(1L);
            this.callback.onEvent(id, type, data.readUtf8());
        }
    }

    public final boolean processNextEvent() {
        String str = this.lastId;
        Buffer buffer = new Buffer();
        while (true) {
            String str2 = null;
            while (true) {
                BufferedSource bufferedSource = this.source;
                Options options2 = options;
                int select = bufferedSource.select(options2);
                if (select >= 0 && 2 >= select) {
                    completeEvent(str, str2, buffer);
                    return true;
                }
                if (3 <= select && 4 >= select) {
                    INSTANCE.readData(this.source, buffer);
                } else if (5 <= select && 7 >= select) {
                    buffer.writeByte(10);
                } else if (8 <= select && 9 >= select) {
                    str = this.source.readUtf8LineStrict();
                    if (str.length() <= 0) {
                        str = null;
                    }
                } else if (10 <= select && 12 >= select) {
                    str = null;
                } else if (13 <= select && 14 >= select) {
                    str2 = this.source.readUtf8LineStrict();
                    if (str2.length() > 0) {
                    }
                } else {
                    if (15 <= select && 17 >= select) {
                        break;
                    }
                    if (18 <= select && 19 >= select) {
                        long readRetryMs = INSTANCE.readRetryMs(this.source);
                        if (readRetryMs != -1) {
                            this.callback.onRetryChange(readRetryMs);
                        }
                    } else {
                        if (select != -1) {
                            throw new AssertionError();
                        }
                        long indexOfElement = this.source.indexOfElement(CRLF);
                        if (indexOfElement == -1) {
                            return false;
                        }
                        this.source.skip(indexOfElement);
                        this.source.select(options2);
                    }
                }
            }
        }
    }
}
