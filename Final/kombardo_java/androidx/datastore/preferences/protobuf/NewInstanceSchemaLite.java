package androidx.datastore.preferences.protobuf;

/* loaded from: classes.dex */
final class NewInstanceSchemaLite implements NewInstanceSchema {
    @Override // androidx.datastore.preferences.protobuf.NewInstanceSchema
    public Object newInstance(Object obj) {
        return ((GeneratedMessageLite) obj).newMutableInstance();
    }
}
