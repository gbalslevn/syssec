package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.Internal;
import java.util.List;

/* loaded from: classes.dex */
final class ListFieldSchemaLite implements ListFieldSchema {
    static <E> Internal.ProtobufList<E> getProtobufList(Object obj, long j5) {
        return (Internal.ProtobufList) UnsafeUtil.getObject(obj, j5);
    }

    @Override // androidx.datastore.preferences.protobuf.ListFieldSchema
    public void makeImmutableListAt(Object obj, long j5) {
        getProtobufList(obj, j5).makeImmutable();
    }

    @Override // androidx.datastore.preferences.protobuf.ListFieldSchema
    public <E> void mergeListsAt(Object obj, Object obj2, long j5) {
        Internal.ProtobufList protobufList = getProtobufList(obj, j5);
        Internal.ProtobufList protobufList2 = getProtobufList(obj2, j5);
        int size = protobufList.size();
        int size2 = protobufList2.size();
        if (size > 0 && size2 > 0) {
            if (!protobufList.isModifiable()) {
                protobufList = protobufList.mutableCopyWithCapacity2(size2 + size);
            }
            protobufList.addAll(protobufList2);
        }
        if (size > 0) {
            protobufList2 = protobufList;
        }
        UnsafeUtil.putObject(obj, j5, protobufList2);
    }

    @Override // androidx.datastore.preferences.protobuf.ListFieldSchema
    public <L> List<L> mutableListAt(Object obj, long j5) {
        Internal.ProtobufList protobufList = getProtobufList(obj, j5);
        if (protobufList.isModifiable()) {
            return protobufList;
        }
        int size = protobufList.size();
        Internal.ProtobufList mutableCopyWithCapacity2 = protobufList.mutableCopyWithCapacity2(size == 0 ? 10 : size * 2);
        UnsafeUtil.putObject(obj, j5, mutableCopyWithCapacity2);
        return mutableCopyWithCapacity2;
    }
}
