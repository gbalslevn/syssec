package com.google.protobuf;

import com.google.protobuf.MapEntryLite;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
interface Writer {

    /* loaded from: classes2.dex */
    public enum FieldOrder {
        ASCENDING,
        DESCENDING
    }

    FieldOrder fieldOrder();

    void writeBool(int i5, boolean z5);

    void writeBoolList(int i5, List<Boolean> list, boolean z5);

    void writeBytes(int i5, ByteString byteString);

    void writeBytesList(int i5, List<ByteString> list);

    void writeDouble(int i5, double d5);

    void writeDoubleList(int i5, List<Double> list, boolean z5);

    @Deprecated
    void writeEndGroup(int i5);

    void writeEnum(int i5, int i6);

    void writeEnumList(int i5, List<Integer> list, boolean z5);

    void writeFixed32(int i5, int i6);

    void writeFixed32List(int i5, List<Integer> list, boolean z5);

    void writeFixed64(int i5, long j5);

    void writeFixed64List(int i5, List<Long> list, boolean z5);

    void writeFloat(int i5, float f5);

    void writeFloatList(int i5, List<Float> list, boolean z5);

    @Deprecated
    void writeGroup(int i5, Object obj, Schema schema);

    @Deprecated
    void writeGroupList(int i5, List<?> list, Schema schema);

    void writeInt32(int i5, int i6);

    void writeInt32List(int i5, List<Integer> list, boolean z5);

    void writeInt64(int i5, long j5);

    void writeInt64List(int i5, List<Long> list, boolean z5);

    <K, V> void writeMap(int i5, MapEntryLite.Metadata<K, V> metadata, Map<K, V> map);

    void writeMessage(int i5, Object obj, Schema schema);

    void writeMessageList(int i5, List<?> list, Schema schema);

    void writeMessageSetItem(int i5, Object obj);

    void writeSFixed32(int i5, int i6);

    void writeSFixed32List(int i5, List<Integer> list, boolean z5);

    void writeSFixed64(int i5, long j5);

    void writeSFixed64List(int i5, List<Long> list, boolean z5);

    void writeSInt32(int i5, int i6);

    void writeSInt32List(int i5, List<Integer> list, boolean z5);

    void writeSInt64(int i5, long j5);

    void writeSInt64List(int i5, List<Long> list, boolean z5);

    @Deprecated
    void writeStartGroup(int i5);

    void writeString(int i5, String str);

    void writeStringList(int i5, List<String> list);

    void writeUInt32(int i5, int i6);

    void writeUInt32List(int i5, List<Integer> list, boolean z5);

    void writeUInt64(int i5, long j5);

    void writeUInt64List(int i5, List<Long> list, boolean z5);
}
