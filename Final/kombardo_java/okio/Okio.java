package okio;

import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import kotlin.Metadata;

@Metadata(d1 = {"okio/Okio__JvmOkioKt", "okio/Okio__OkioKt"}, k = 4, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public abstract class Okio {
    public static final Sink blackhole() {
        return Okio__OkioKt.blackhole();
    }

    public static final BufferedSink buffer(Sink sink) {
        return Okio__OkioKt.buffer(sink);
    }

    public static final boolean isAndroidGetsocknameError(AssertionError assertionError) {
        return Okio__JvmOkioKt.isAndroidGetsocknameError(assertionError);
    }

    public static final Sink sink(File file, boolean z5) {
        return Okio__JvmOkioKt.sink(file, z5);
    }

    public static final Source source(File file) {
        return Okio__JvmOkioKt.source(file);
    }

    public static final BufferedSource buffer(Source source) {
        return Okio__OkioKt.buffer(source);
    }

    public static final Sink sink(OutputStream outputStream) {
        return Okio__JvmOkioKt.sink(outputStream);
    }

    public static final Source source(InputStream inputStream) {
        return Okio__JvmOkioKt.source(inputStream);
    }

    public static final Sink sink(Socket socket) {
        return Okio__JvmOkioKt.sink(socket);
    }

    public static final Source source(Socket socket) {
        return Okio__JvmOkioKt.source(socket);
    }
}
