package com.google.protobuf;

import com.google.protobuf.FieldSet;
import com.google.protobuf.FieldSet.FieldDescriptorLite;
import java.util.Map;

/* loaded from: classes2.dex */
abstract class ExtensionSchema<T extends FieldSet.FieldDescriptorLite<T>> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract int extensionNumber(Map.Entry<?, ?> entry);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract FieldSet<T> getExtensions(Object obj);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract FieldSet<T> getMutableExtensions(Object obj);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract boolean hasExtensions(MessageLite messageLite);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void makeImmutable(Object obj);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void serializeExtension(Writer writer, Map.Entry<?, ?> entry);
}
