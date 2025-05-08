package androidx.datastore.preferences.protobuf;

import android.support.v4.media.session.a;
import java.util.Map;

/* loaded from: classes.dex */
final class ExtensionSchemaLite extends ExtensionSchema<Object> {
    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.datastore.preferences.protobuf.ExtensionSchema
    public int extensionNumber(Map.Entry<?, ?> entry) {
        a.a(entry.getKey());
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.datastore.preferences.protobuf.ExtensionSchema
    public Object findExtensionByNumber(ExtensionRegistryLite extensionRegistryLite, MessageLite messageLite, int i5) {
        extensionRegistryLite.findLiteExtensionByNumber(messageLite, i5);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.datastore.preferences.protobuf.ExtensionSchema
    public FieldSet<Object> getExtensions(Object obj) {
        a.a(obj);
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.datastore.preferences.protobuf.ExtensionSchema
    public FieldSet<Object> getMutableExtensions(Object obj) {
        a.a(obj);
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.datastore.preferences.protobuf.ExtensionSchema
    public boolean hasExtensions(MessageLite messageLite) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.datastore.preferences.protobuf.ExtensionSchema
    public void makeImmutable(Object obj) {
        getExtensions(obj).makeImmutable();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.datastore.preferences.protobuf.ExtensionSchema
    public <UT, UB> UB parseExtension(Object obj, Reader reader, Object obj2, ExtensionRegistryLite extensionRegistryLite, FieldSet<Object> fieldSet, UB ub, UnknownFieldSchema<UT, UB> unknownFieldSchema) {
        a.a(obj2);
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.datastore.preferences.protobuf.ExtensionSchema
    public void parseLengthPrefixedMessageSetItem(Reader reader, Object obj, ExtensionRegistryLite extensionRegistryLite, FieldSet<Object> fieldSet) {
        a.a(obj);
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.datastore.preferences.protobuf.ExtensionSchema
    public void parseMessageSetItem(ByteString byteString, Object obj, ExtensionRegistryLite extensionRegistryLite, FieldSet<Object> fieldSet) {
        a.a(obj);
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // androidx.datastore.preferences.protobuf.ExtensionSchema
    public void serializeExtension(Writer writer, Map.Entry<?, ?> entry) {
        a.a(entry.getKey());
        throw null;
    }
}
