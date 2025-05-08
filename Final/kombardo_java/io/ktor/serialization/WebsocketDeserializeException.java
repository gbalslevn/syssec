package io.ktor.serialization;

import io.ktor.websocket.Frame;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lio/ktor/serialization/WebsocketDeserializeException;", "Lio/ktor/serialization/WebsocketContentConvertException;", "Lio/ktor/websocket/Frame;", "frame", "Lio/ktor/websocket/Frame;", "getFrame", "()Lio/ktor/websocket/Frame;", "ktor-serialization"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class WebsocketDeserializeException extends WebsocketContentConvertException {
    private final Frame frame;
}
