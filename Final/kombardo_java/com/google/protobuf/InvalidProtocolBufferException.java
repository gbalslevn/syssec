package com.google.protobuf;

import java.io.IOException;

/* loaded from: classes2.dex */
public class InvalidProtocolBufferException extends IOException {
    private static final long serialVersionUID = -1616151763072450476L;
    private MessageLite unfinishedMessage;
    private boolean wasThrownFromInputStream;

    /* loaded from: classes2.dex */
    public static class InvalidWireTypeException extends InvalidProtocolBufferException {
        private static final long serialVersionUID = 3283890091615336259L;

        public InvalidWireTypeException(String str) {
            super(str);
        }
    }

    public InvalidProtocolBufferException(String str) {
        super(str);
        this.unfinishedMessage = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static InvalidWireTypeException invalidWireType() {
        return new InvalidWireTypeException("Protocol message tag had invalid wire type.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static InvalidProtocolBufferException negativeSize() {
        return new InvalidProtocolBufferException("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static InvalidProtocolBufferException parseFailure() {
        return new InvalidProtocolBufferException("Failed to parse the message.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static InvalidProtocolBufferException truncatedMessage() {
        return new InvalidProtocolBufferException("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }
}
