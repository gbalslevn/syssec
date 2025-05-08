package com.google.protobuf;

import android.support.v4.media.session.a;
import java.util.Map;

/* loaded from: classes2.dex */
final class ExtensionSchemaLite extends ExtensionSchema<Object> {
    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.protobuf.ExtensionSchema
    public int extensionNumber(Map.Entry<?, ?> entry) {
        a.a(entry.getKey());
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.protobuf.ExtensionSchema
    public FieldSet<Object> getExtensions(Object obj) {
        a.a(obj);
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.protobuf.ExtensionSchema
    public FieldSet<Object> getMutableExtensions(Object obj) {
        a.a(obj);
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.protobuf.ExtensionSchema
    public boolean hasExtensions(MessageLite messageLite) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.protobuf.ExtensionSchema
    public void makeImmutable(Object obj) {
        getExtensions(obj).makeImmutable();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.protobuf.ExtensionSchema
    public void serializeExtension(Writer writer, Map.Entry<?, ?> entry) {
        a.a(entry.getKey());
        throw null;
    }
}
