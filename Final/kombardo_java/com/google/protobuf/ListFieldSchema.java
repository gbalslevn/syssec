package com.google.protobuf;

import com.google.protobuf.Internal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
abstract class ListFieldSchema {
    private static final ListFieldSchema FULL_INSTANCE;
    private static final ListFieldSchema LITE_INSTANCE;

    /* loaded from: classes2.dex */
    private static final class ListFieldSchemaFull extends ListFieldSchema {
        private static final Class<?> UNMODIFIABLE_LIST_CLASS = Collections.unmodifiableList(Collections.emptyList()).getClass();

        private ListFieldSchemaFull() {
            super();
        }

        static <E> List<E> getList(Object obj, long j5) {
            return (List) UnsafeUtil.getObject(obj, j5);
        }

        /* JADX WARN: Multi-variable type inference failed */
        private static <L> List<L> mutableListAt(Object obj, long j5, int i5) {
            LazyStringArrayList lazyStringArrayList;
            List<L> list = getList(obj, j5);
            if (list.isEmpty()) {
                List<L> lazyStringArrayList2 = list instanceof LazyStringList ? new LazyStringArrayList(i5) : ((list instanceof PrimitiveNonBoxingCollection) && (list instanceof Internal.ProtobufList)) ? ((Internal.ProtobufList) list).mutableCopyWithCapacity2(i5) : new ArrayList<>(i5);
                UnsafeUtil.putObject(obj, j5, lazyStringArrayList2);
                return lazyStringArrayList2;
            }
            if (UNMODIFIABLE_LIST_CLASS.isAssignableFrom(list.getClass())) {
                ArrayList arrayList = new ArrayList(list.size() + i5);
                arrayList.addAll(list);
                UnsafeUtil.putObject(obj, j5, arrayList);
                lazyStringArrayList = arrayList;
            } else {
                if (!(list instanceof UnmodifiableLazyStringList)) {
                    if (!(list instanceof PrimitiveNonBoxingCollection) || !(list instanceof Internal.ProtobufList)) {
                        return list;
                    }
                    Internal.ProtobufList protobufList = (Internal.ProtobufList) list;
                    if (protobufList.isModifiable()) {
                        return list;
                    }
                    Internal.ProtobufList mutableCopyWithCapacity2 = protobufList.mutableCopyWithCapacity2(list.size() + i5);
                    UnsafeUtil.putObject(obj, j5, mutableCopyWithCapacity2);
                    return mutableCopyWithCapacity2;
                }
                LazyStringArrayList lazyStringArrayList3 = new LazyStringArrayList(list.size() + i5);
                lazyStringArrayList3.addAll((UnmodifiableLazyStringList) list);
                UnsafeUtil.putObject(obj, j5, lazyStringArrayList3);
                lazyStringArrayList = lazyStringArrayList3;
            }
            return lazyStringArrayList;
        }

        @Override // com.google.protobuf.ListFieldSchema
        void makeImmutableListAt(Object obj, long j5) {
            Object unmodifiableList;
            List list = (List) UnsafeUtil.getObject(obj, j5);
            if (list instanceof LazyStringList) {
                unmodifiableList = ((LazyStringList) list).getUnmodifiableView();
            } else {
                if (UNMODIFIABLE_LIST_CLASS.isAssignableFrom(list.getClass())) {
                    return;
                }
                if ((list instanceof PrimitiveNonBoxingCollection) && (list instanceof Internal.ProtobufList)) {
                    Internal.ProtobufList protobufList = (Internal.ProtobufList) list;
                    if (protobufList.isModifiable()) {
                        protobufList.makeImmutable();
                        return;
                    }
                    return;
                }
                unmodifiableList = Collections.unmodifiableList(list);
            }
            UnsafeUtil.putObject(obj, j5, unmodifiableList);
        }

        @Override // com.google.protobuf.ListFieldSchema
        <E> void mergeListsAt(Object obj, Object obj2, long j5) {
            List list = getList(obj2, j5);
            List mutableListAt = mutableListAt(obj, j5, list.size());
            int size = mutableListAt.size();
            int size2 = list.size();
            if (size > 0 && size2 > 0) {
                mutableListAt.addAll(list);
            }
            if (size > 0) {
                list = mutableListAt;
            }
            UnsafeUtil.putObject(obj, j5, list);
        }
    }

    /* loaded from: classes2.dex */
    private static final class ListFieldSchemaLite extends ListFieldSchema {
        private ListFieldSchemaLite() {
            super();
        }

        static <E> Internal.ProtobufList<E> getProtobufList(Object obj, long j5) {
            return (Internal.ProtobufList) UnsafeUtil.getObject(obj, j5);
        }

        @Override // com.google.protobuf.ListFieldSchema
        void makeImmutableListAt(Object obj, long j5) {
            getProtobufList(obj, j5).makeImmutable();
        }

        @Override // com.google.protobuf.ListFieldSchema
        <E> void mergeListsAt(Object obj, Object obj2, long j5) {
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
    }

    static {
        FULL_INSTANCE = new ListFieldSchemaFull();
        LITE_INSTANCE = new ListFieldSchemaLite();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ListFieldSchema full() {
        return FULL_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ListFieldSchema lite() {
        return LITE_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void makeImmutableListAt(Object obj, long j5);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract <L> void mergeListsAt(Object obj, Object obj2, long j5);

    private ListFieldSchema() {
    }
}
