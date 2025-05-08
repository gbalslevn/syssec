package androidx.datastore.preferences.protobuf;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public interface Schema<T> {
    boolean equals(T t5, T t6);

    int getSerializedSize(T t5);

    int hashCode(T t5);

    boolean isInitialized(T t5);

    void makeImmutable(T t5);

    void mergeFrom(T t5, Reader reader, ExtensionRegistryLite extensionRegistryLite);

    void mergeFrom(T t5, T t6);

    T newInstance();

    void writeTo(T t5, Writer writer);
}
