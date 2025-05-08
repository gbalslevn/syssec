package okhttp3.logging;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.Connection;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.http.HttpHeaders;
import okhttp3.internal.platform.Platform;
import okio.Buffer;
import okio.BufferedSource;
import okio.GzipSource;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u00002\u00020\u0001:\u0002#$B\u0013\b\u0007\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0019R\u001c\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR*\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u00108\u0006@GX\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\u0011\u0010\"¨\u0006%"}, d2 = {"Lokhttp3/logging/HttpLoggingInterceptor;", "Lokhttp3/Interceptor;", "Lokhttp3/logging/HttpLoggingInterceptor$Logger;", "logger", "<init>", "(Lokhttp3/logging/HttpLoggingInterceptor$Logger;)V", "Lokhttp3/Headers;", "headers", BuildConfig.FLAVOR, "i", BuildConfig.FLAVOR, "logHeader", "(Lokhttp3/Headers;I)V", BuildConfig.FLAVOR, "bodyHasUnknownEncoding", "(Lokhttp3/Headers;)Z", "Lokhttp3/logging/HttpLoggingInterceptor$Level;", "level", "setLevel", "(Lokhttp3/logging/HttpLoggingInterceptor$Level;)Lokhttp3/logging/HttpLoggingInterceptor;", "Lokhttp3/Interceptor$Chain;", "chain", "Lokhttp3/Response;", "intercept", "(Lokhttp3/Interceptor$Chain;)Lokhttp3/Response;", "Lokhttp3/logging/HttpLoggingInterceptor$Logger;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "headersToRedact", "Ljava/util/Set;", "<set-?>", "Lokhttp3/logging/HttpLoggingInterceptor$Level;", "getLevel", "()Lokhttp3/logging/HttpLoggingInterceptor$Level;", "(Lokhttp3/logging/HttpLoggingInterceptor$Level;)V", "Level", "Logger", "okhttp-logging-interceptor"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class HttpLoggingInterceptor implements Interceptor {
    private volatile Set<String> headersToRedact;
    private volatile Level level;
    private final Logger logger;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lokhttp3/logging/HttpLoggingInterceptor$Level;", BuildConfig.FLAVOR, "(Ljava/lang/String;I)V", "NONE", "BASIC", "HEADERS", "BODY", "okhttp-logging-interceptor"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public enum Level {
        NONE,
        BASIC,
        HEADERS,
        BODY
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bæ\u0080\u0001\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0007"}, d2 = {"Lokhttp3/logging/HttpLoggingInterceptor$Logger;", BuildConfig.FLAVOR, "log", BuildConfig.FLAVOR, "message", BuildConfig.FLAVOR, "Companion", "okhttp-logging-interceptor"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes3.dex */
    public interface Logger {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = Companion.$$INSTANCE;
        public static final Logger DEFAULT = new Companion.DefaultLogger();

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0001\u0005B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0013\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0001¨\u0006\u0006"}, d2 = {"Lokhttp3/logging/HttpLoggingInterceptor$Logger$Companion;", BuildConfig.FLAVOR, "()V", "DEFAULT", "Lokhttp3/logging/HttpLoggingInterceptor$Logger;", "DefaultLogger", "okhttp-logging-interceptor"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* loaded from: classes3.dex */
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();

            @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lokhttp3/logging/HttpLoggingInterceptor$Logger$Companion$DefaultLogger;", "Lokhttp3/logging/HttpLoggingInterceptor$Logger;", "()V", "log", BuildConfig.FLAVOR, "message", BuildConfig.FLAVOR, "okhttp-logging-interceptor"}, k = 1, mv = {1, 6, 0}, xi = 48)
            /* loaded from: classes3.dex */
            private static final class DefaultLogger implements Logger {
                @Override // okhttp3.logging.HttpLoggingInterceptor.Logger
                public void log(String message) {
                    Intrinsics.checkNotNullParameter(message, "message");
                    Platform.log$default(Platform.INSTANCE.get(), message, 0, null, 6, null);
                }
            }

            private Companion() {
            }
        }

        void log(String message);
    }

    public HttpLoggingInterceptor(Logger logger) {
        Intrinsics.checkNotNullParameter(logger, "logger");
        this.logger = logger;
        this.headersToRedact = SetsKt.emptySet();
        this.level = Level.NONE;
    }

    private final boolean bodyHasUnknownEncoding(Headers headers) {
        String str = headers.get("Content-Encoding");
        return (str == null || StringsKt.equals(str, "identity", true) || StringsKt.equals(str, "gzip", true)) ? false : true;
    }

    private final void logHeader(Headers headers, int i5) {
        String value = this.headersToRedact.contains(headers.name(i5)) ? "██" : headers.value(i5);
        this.logger.log(headers.name(i5) + ": " + value);
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) {
        String str;
        char c5;
        String sb;
        Charset charset;
        Long l5;
        Intrinsics.checkNotNullParameter(chain, "chain");
        Level level = this.level;
        Request request = chain.request();
        if (level == Level.NONE) {
            return chain.proceed(request);
        }
        boolean z5 = level == Level.BODY;
        boolean z6 = z5 || level == Level.HEADERS;
        RequestBody body = request.getBody();
        Connection connection = chain.connection();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("--> ");
        sb2.append(request.getMethod());
        sb2.append(' ');
        sb2.append(request.getUrl());
        sb2.append(connection != null ? Intrinsics.stringPlus(" ", connection.protocol()) : BuildConfig.FLAVOR);
        String sb3 = sb2.toString();
        if (!z6 && body != null) {
            sb3 = sb3 + " (" + body.contentLength() + "-byte body)";
        }
        this.logger.log(sb3);
        if (z6) {
            Headers headers = request.getHeaders();
            if (body != null) {
                MediaType contentType = body.getContentType();
                if (contentType != null && headers.get("Content-Type") == null) {
                    this.logger.log(Intrinsics.stringPlus("Content-Type: ", contentType));
                }
                if (body.contentLength() != -1 && headers.get("Content-Length") == null) {
                    this.logger.log(Intrinsics.stringPlus("Content-Length: ", Long.valueOf(body.contentLength())));
                }
            }
            int size = headers.size();
            for (int i5 = 0; i5 < size; i5++) {
                logHeader(headers, i5);
            }
            if (!z5 || body == null) {
                this.logger.log(Intrinsics.stringPlus("--> END ", request.getMethod()));
            } else if (bodyHasUnknownEncoding(request.getHeaders())) {
                this.logger.log("--> END " + request.getMethod() + " (encoded body omitted)");
            } else if (body.isDuplex()) {
                this.logger.log("--> END " + request.getMethod() + " (duplex request body omitted)");
            } else if (body.isOneShot()) {
                this.logger.log("--> END " + request.getMethod() + " (one-shot body omitted)");
            } else {
                Buffer buffer = new Buffer();
                body.writeTo(buffer);
                MediaType contentType2 = body.getContentType();
                Charset UTF_8 = contentType2 == null ? null : contentType2.charset(StandardCharsets.UTF_8);
                if (UTF_8 == null) {
                    UTF_8 = StandardCharsets.UTF_8;
                    Intrinsics.checkNotNullExpressionValue(UTF_8, "UTF_8");
                }
                this.logger.log(BuildConfig.FLAVOR);
                if (Utf8Kt.isProbablyUtf8(buffer)) {
                    this.logger.log(buffer.readString(UTF_8));
                    this.logger.log("--> END " + request.getMethod() + " (" + body.contentLength() + "-byte body)");
                } else {
                    this.logger.log("--> END " + request.getMethod() + " (binary " + body.contentLength() + "-byte body omitted)");
                }
            }
        }
        long nanoTime = System.nanoTime();
        try {
            Response proceed = chain.proceed(request);
            long millis = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - nanoTime);
            ResponseBody body2 = proceed.getBody();
            Intrinsics.checkNotNull(body2);
            long contentLength = body2.getContentLength();
            String str2 = contentLength != -1 ? contentLength + "-byte" : "unknown-length";
            Logger logger = this.logger;
            StringBuilder sb4 = new StringBuilder();
            sb4.append("<-- ");
            sb4.append(proceed.getCode());
            if (proceed.getMessage().length() == 0) {
                str = "-byte body omitted)";
                sb = BuildConfig.FLAVOR;
                c5 = ' ';
            } else {
                String message = proceed.getMessage();
                StringBuilder sb5 = new StringBuilder();
                str = "-byte body omitted)";
                c5 = ' ';
                sb5.append(' ');
                sb5.append(message);
                sb = sb5.toString();
            }
            sb4.append(sb);
            sb4.append(c5);
            sb4.append(proceed.getRequest().getUrl());
            sb4.append(" (");
            sb4.append(millis);
            sb4.append("ms");
            sb4.append(z6 ? BuildConfig.FLAVOR : ", " + str2 + " body");
            sb4.append(')');
            logger.log(sb4.toString());
            if (z6) {
                Headers headers2 = proceed.getHeaders();
                int size2 = headers2.size();
                for (int i6 = 0; i6 < size2; i6++) {
                    logHeader(headers2, i6);
                }
                if (!z5 || !HttpHeaders.promisesBody(proceed)) {
                    this.logger.log("<-- END HTTP");
                } else if (bodyHasUnknownEncoding(proceed.getHeaders())) {
                    this.logger.log("<-- END HTTP (encoded body omitted)");
                } else {
                    BufferedSource source = body2.getSource();
                    source.request(Long.MAX_VALUE);
                    Buffer bufferField = source.getBufferField();
                    if (StringsKt.equals("gzip", headers2.get("Content-Encoding"), true)) {
                        l5 = Long.valueOf(bufferField.getSize());
                        GzipSource gzipSource = new GzipSource(bufferField.clone());
                        try {
                            bufferField = new Buffer();
                            bufferField.writeAll(gzipSource);
                            charset = null;
                            CloseableKt.closeFinally(gzipSource, null);
                        } finally {
                        }
                    } else {
                        charset = null;
                        l5 = null;
                    }
                    MediaType mediaType = body2.get$contentType();
                    Charset UTF_82 = mediaType == null ? charset : mediaType.charset(StandardCharsets.UTF_8);
                    if (UTF_82 == null) {
                        UTF_82 = StandardCharsets.UTF_8;
                        Intrinsics.checkNotNullExpressionValue(UTF_82, "UTF_8");
                    }
                    if (!Utf8Kt.isProbablyUtf8(bufferField)) {
                        this.logger.log(BuildConfig.FLAVOR);
                        this.logger.log("<-- END HTTP (binary " + bufferField.getSize() + str);
                        return proceed;
                    }
                    if (contentLength != 0) {
                        this.logger.log(BuildConfig.FLAVOR);
                        this.logger.log(bufferField.clone().readString(UTF_82));
                    }
                    if (l5 != null) {
                        this.logger.log("<-- END HTTP (" + bufferField.getSize() + "-byte, " + l5 + "-gzipped-byte body)");
                    } else {
                        this.logger.log("<-- END HTTP (" + bufferField.getSize() + "-byte body)");
                    }
                }
            }
            return proceed;
        } catch (Exception e5) {
            this.logger.log(Intrinsics.stringPlus("<-- HTTP FAILED: ", e5));
            throw e5;
        }
    }

    public final void level(Level level) {
        Intrinsics.checkNotNullParameter(level, "<set-?>");
        this.level = level;
    }

    public final HttpLoggingInterceptor setLevel(Level level) {
        Intrinsics.checkNotNullParameter(level, "level");
        level(level);
        return this;
    }

    public /* synthetic */ HttpLoggingInterceptor(Logger logger, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this((i5 & 1) != 0 ? Logger.DEFAULT : logger);
    }
}
