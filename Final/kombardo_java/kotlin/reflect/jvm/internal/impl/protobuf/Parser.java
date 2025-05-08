package kotlin.reflect.jvm.internal.impl.protobuf;

import java.io.InputStream;

/* loaded from: classes3.dex */
public interface Parser<MessageType> {
    MessageType parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite);

    MessageType parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite);

    MessageType parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite);
}
