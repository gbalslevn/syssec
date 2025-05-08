package com.google.protobuf;

import com.google.protobuf.MapEntryLite;
import com.google.protobuf.WireFormat;
import com.google.protobuf.Writer;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class CodedOutputStreamWriter implements Writer {
    private final CodedOutputStream output;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.google.protobuf.CodedOutputStreamWriter$1, reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$WireFormat$FieldType;

        static {
            int[] iArr = new int[WireFormat.FieldType.values().length];
            $SwitchMap$com$google$protobuf$WireFormat$FieldType = iArr;
            try {
                iArr[WireFormat.FieldType.BOOL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.FIXED32.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.INT32.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SFIXED32.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SINT32.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.UINT32.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.FIXED64.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.INT64.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SFIXED64.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.SINT64.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.UINT64.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$com$google$protobuf$WireFormat$FieldType[WireFormat.FieldType.STRING.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    private CodedOutputStreamWriter(CodedOutputStream codedOutputStream) {
        CodedOutputStream codedOutputStream2 = (CodedOutputStream) Internal.checkNotNull(codedOutputStream, "output");
        this.output = codedOutputStream2;
        codedOutputStream2.wrapper = this;
    }

    public static CodedOutputStreamWriter forCodedOutput(CodedOutputStream codedOutputStream) {
        CodedOutputStreamWriter codedOutputStreamWriter = codedOutputStream.wrapper;
        return codedOutputStreamWriter != null ? codedOutputStreamWriter : new CodedOutputStreamWriter(codedOutputStream);
    }

    private <V> void writeDeterministicBooleanMapEntry(int i5, boolean z5, V v5, MapEntryLite.Metadata<Boolean, V> metadata) {
        this.output.writeTag(i5, 2);
        this.output.writeUInt32NoTag(MapEntryLite.computeSerializedSize(metadata, Boolean.valueOf(z5), v5));
        MapEntryLite.writeTo(this.output, metadata, Boolean.valueOf(z5), v5);
    }

    private <V> void writeDeterministicIntegerMap(int i5, MapEntryLite.Metadata<Integer, V> metadata, Map<Integer, V> map) {
        int size = map.size();
        int[] iArr = new int[size];
        Iterator<Integer> it = map.keySet().iterator();
        int i6 = 0;
        while (it.hasNext()) {
            iArr[i6] = it.next().intValue();
            i6++;
        }
        Arrays.sort(iArr);
        for (int i7 = 0; i7 < size; i7++) {
            int i8 = iArr[i7];
            V v5 = map.get(Integer.valueOf(i8));
            this.output.writeTag(i5, 2);
            this.output.writeUInt32NoTag(MapEntryLite.computeSerializedSize(metadata, Integer.valueOf(i8), v5));
            MapEntryLite.writeTo(this.output, metadata, Integer.valueOf(i8), v5);
        }
    }

    private <V> void writeDeterministicLongMap(int i5, MapEntryLite.Metadata<Long, V> metadata, Map<Long, V> map) {
        int size = map.size();
        long[] jArr = new long[size];
        Iterator<Long> it = map.keySet().iterator();
        int i6 = 0;
        while (it.hasNext()) {
            jArr[i6] = it.next().longValue();
            i6++;
        }
        Arrays.sort(jArr);
        for (int i7 = 0; i7 < size; i7++) {
            long j5 = jArr[i7];
            V v5 = map.get(Long.valueOf(j5));
            this.output.writeTag(i5, 2);
            this.output.writeUInt32NoTag(MapEntryLite.computeSerializedSize(metadata, Long.valueOf(j5), v5));
            MapEntryLite.writeTo(this.output, metadata, Long.valueOf(j5), v5);
        }
    }

    private <K, V> void writeDeterministicMap(int i5, MapEntryLite.Metadata<K, V> metadata, Map<K, V> map) {
        switch (AnonymousClass1.$SwitchMap$com$google$protobuf$WireFormat$FieldType[metadata.keyType.ordinal()]) {
            case 1:
                V v5 = map.get(Boolean.FALSE);
                if (v5 != null) {
                    writeDeterministicBooleanMapEntry(i5, false, v5, metadata);
                }
                V v6 = map.get(Boolean.TRUE);
                if (v6 != null) {
                    writeDeterministicBooleanMapEntry(i5, true, v6, metadata);
                    return;
                }
                return;
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                writeDeterministicIntegerMap(i5, metadata, map);
                return;
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
                writeDeterministicLongMap(i5, metadata, map);
                return;
            case 12:
                writeDeterministicStringMap(i5, metadata, map);
                return;
            default:
                throw new IllegalArgumentException("does not support key type: " + metadata.keyType);
        }
    }

    private <V> void writeDeterministicStringMap(int i5, MapEntryLite.Metadata<String, V> metadata, Map<String, V> map) {
        int size = map.size();
        String[] strArr = new String[size];
        Iterator<String> it = map.keySet().iterator();
        int i6 = 0;
        while (it.hasNext()) {
            strArr[i6] = it.next();
            i6++;
        }
        Arrays.sort(strArr);
        for (int i7 = 0; i7 < size; i7++) {
            String str = strArr[i7];
            V v5 = map.get(str);
            this.output.writeTag(i5, 2);
            this.output.writeUInt32NoTag(MapEntryLite.computeSerializedSize(metadata, str, v5));
            MapEntryLite.writeTo(this.output, metadata, str, v5);
        }
    }

    private void writeLazyString(int i5, Object obj) {
        if (obj instanceof String) {
            this.output.writeString(i5, (String) obj);
        } else {
            this.output.writeBytes(i5, (ByteString) obj);
        }
    }

    @Override // com.google.protobuf.Writer
    public Writer.FieldOrder fieldOrder() {
        return Writer.FieldOrder.ASCENDING;
    }

    @Override // com.google.protobuf.Writer
    public void writeBool(int i5, boolean z5) {
        this.output.writeBool(i5, z5);
    }

    @Override // com.google.protobuf.Writer
    public void writeBoolList(int i5, List<Boolean> list, boolean z5) {
        int i6 = 0;
        if (!z5) {
            while (i6 < list.size()) {
                this.output.writeBool(i5, list.get(i6).booleanValue());
                i6++;
            }
            return;
        }
        this.output.writeTag(i5, 2);
        int i7 = 0;
        for (int i8 = 0; i8 < list.size(); i8++) {
            i7 += CodedOutputStream.computeBoolSizeNoTag(list.get(i8).booleanValue());
        }
        this.output.writeUInt32NoTag(i7);
        while (i6 < list.size()) {
            this.output.writeBoolNoTag(list.get(i6).booleanValue());
            i6++;
        }
    }

    @Override // com.google.protobuf.Writer
    public void writeBytes(int i5, ByteString byteString) {
        this.output.writeBytes(i5, byteString);
    }

    @Override // com.google.protobuf.Writer
    public void writeBytesList(int i5, List<ByteString> list) {
        for (int i6 = 0; i6 < list.size(); i6++) {
            this.output.writeBytes(i5, list.get(i6));
        }
    }

    @Override // com.google.protobuf.Writer
    public void writeDouble(int i5, double d5) {
        this.output.writeDouble(i5, d5);
    }

    @Override // com.google.protobuf.Writer
    public void writeDoubleList(int i5, List<Double> list, boolean z5) {
        int i6 = 0;
        if (!z5) {
            while (i6 < list.size()) {
                this.output.writeDouble(i5, list.get(i6).doubleValue());
                i6++;
            }
            return;
        }
        this.output.writeTag(i5, 2);
        int i7 = 0;
        for (int i8 = 0; i8 < list.size(); i8++) {
            i7 += CodedOutputStream.computeDoubleSizeNoTag(list.get(i8).doubleValue());
        }
        this.output.writeUInt32NoTag(i7);
        while (i6 < list.size()) {
            this.output.writeDoubleNoTag(list.get(i6).doubleValue());
            i6++;
        }
    }

    @Override // com.google.protobuf.Writer
    @Deprecated
    public void writeEndGroup(int i5) {
        this.output.writeTag(i5, 4);
    }

    @Override // com.google.protobuf.Writer
    public void writeEnum(int i5, int i6) {
        this.output.writeEnum(i5, i6);
    }

    @Override // com.google.protobuf.Writer
    public void writeEnumList(int i5, List<Integer> list, boolean z5) {
        int i6 = 0;
        if (!z5) {
            while (i6 < list.size()) {
                this.output.writeEnum(i5, list.get(i6).intValue());
                i6++;
            }
            return;
        }
        this.output.writeTag(i5, 2);
        int i7 = 0;
        for (int i8 = 0; i8 < list.size(); i8++) {
            i7 += CodedOutputStream.computeEnumSizeNoTag(list.get(i8).intValue());
        }
        this.output.writeUInt32NoTag(i7);
        while (i6 < list.size()) {
            this.output.writeEnumNoTag(list.get(i6).intValue());
            i6++;
        }
    }

    @Override // com.google.protobuf.Writer
    public void writeFixed32(int i5, int i6) {
        this.output.writeFixed32(i5, i6);
    }

    @Override // com.google.protobuf.Writer
    public void writeFixed32List(int i5, List<Integer> list, boolean z5) {
        int i6 = 0;
        if (!z5) {
            while (i6 < list.size()) {
                this.output.writeFixed32(i5, list.get(i6).intValue());
                i6++;
            }
            return;
        }
        this.output.writeTag(i5, 2);
        int i7 = 0;
        for (int i8 = 0; i8 < list.size(); i8++) {
            i7 += CodedOutputStream.computeFixed32SizeNoTag(list.get(i8).intValue());
        }
        this.output.writeUInt32NoTag(i7);
        while (i6 < list.size()) {
            this.output.writeFixed32NoTag(list.get(i6).intValue());
            i6++;
        }
    }

    @Override // com.google.protobuf.Writer
    public void writeFixed64(int i5, long j5) {
        this.output.writeFixed64(i5, j5);
    }

    @Override // com.google.protobuf.Writer
    public void writeFixed64List(int i5, List<Long> list, boolean z5) {
        int i6 = 0;
        if (!z5) {
            while (i6 < list.size()) {
                this.output.writeFixed64(i5, list.get(i6).longValue());
                i6++;
            }
            return;
        }
        this.output.writeTag(i5, 2);
        int i7 = 0;
        for (int i8 = 0; i8 < list.size(); i8++) {
            i7 += CodedOutputStream.computeFixed64SizeNoTag(list.get(i8).longValue());
        }
        this.output.writeUInt32NoTag(i7);
        while (i6 < list.size()) {
            this.output.writeFixed64NoTag(list.get(i6).longValue());
            i6++;
        }
    }

    @Override // com.google.protobuf.Writer
    public void writeFloat(int i5, float f5) {
        this.output.writeFloat(i5, f5);
    }

    @Override // com.google.protobuf.Writer
    public void writeFloatList(int i5, List<Float> list, boolean z5) {
        int i6 = 0;
        if (!z5) {
            while (i6 < list.size()) {
                this.output.writeFloat(i5, list.get(i6).floatValue());
                i6++;
            }
            return;
        }
        this.output.writeTag(i5, 2);
        int i7 = 0;
        for (int i8 = 0; i8 < list.size(); i8++) {
            i7 += CodedOutputStream.computeFloatSizeNoTag(list.get(i8).floatValue());
        }
        this.output.writeUInt32NoTag(i7);
        while (i6 < list.size()) {
            this.output.writeFloatNoTag(list.get(i6).floatValue());
            i6++;
        }
    }

    @Override // com.google.protobuf.Writer
    public void writeGroup(int i5, Object obj, Schema schema) {
        this.output.writeGroup(i5, (MessageLite) obj, schema);
    }

    @Override // com.google.protobuf.Writer
    public void writeGroupList(int i5, List<?> list, Schema schema) {
        for (int i6 = 0; i6 < list.size(); i6++) {
            writeGroup(i5, list.get(i6), schema);
        }
    }

    @Override // com.google.protobuf.Writer
    public void writeInt32(int i5, int i6) {
        this.output.writeInt32(i5, i6);
    }

    @Override // com.google.protobuf.Writer
    public void writeInt32List(int i5, List<Integer> list, boolean z5) {
        int i6 = 0;
        if (!z5) {
            while (i6 < list.size()) {
                this.output.writeInt32(i5, list.get(i6).intValue());
                i6++;
            }
            return;
        }
        this.output.writeTag(i5, 2);
        int i7 = 0;
        for (int i8 = 0; i8 < list.size(); i8++) {
            i7 += CodedOutputStream.computeInt32SizeNoTag(list.get(i8).intValue());
        }
        this.output.writeUInt32NoTag(i7);
        while (i6 < list.size()) {
            this.output.writeInt32NoTag(list.get(i6).intValue());
            i6++;
        }
    }

    @Override // com.google.protobuf.Writer
    public void writeInt64(int i5, long j5) {
        this.output.writeInt64(i5, j5);
    }

    @Override // com.google.protobuf.Writer
    public void writeInt64List(int i5, List<Long> list, boolean z5) {
        int i6 = 0;
        if (!z5) {
            while (i6 < list.size()) {
                this.output.writeInt64(i5, list.get(i6).longValue());
                i6++;
            }
            return;
        }
        this.output.writeTag(i5, 2);
        int i7 = 0;
        for (int i8 = 0; i8 < list.size(); i8++) {
            i7 += CodedOutputStream.computeInt64SizeNoTag(list.get(i8).longValue());
        }
        this.output.writeUInt32NoTag(i7);
        while (i6 < list.size()) {
            this.output.writeInt64NoTag(list.get(i6).longValue());
            i6++;
        }
    }

    @Override // com.google.protobuf.Writer
    public <K, V> void writeMap(int i5, MapEntryLite.Metadata<K, V> metadata, Map<K, V> map) {
        if (this.output.isSerializationDeterministic()) {
            writeDeterministicMap(i5, metadata, map);
            return;
        }
        for (Map.Entry<K, V> entry : map.entrySet()) {
            this.output.writeTag(i5, 2);
            this.output.writeUInt32NoTag(MapEntryLite.computeSerializedSize(metadata, entry.getKey(), entry.getValue()));
            MapEntryLite.writeTo(this.output, metadata, entry.getKey(), entry.getValue());
        }
    }

    @Override // com.google.protobuf.Writer
    public void writeMessage(int i5, Object obj, Schema schema) {
        this.output.writeMessage(i5, (MessageLite) obj, schema);
    }

    @Override // com.google.protobuf.Writer
    public void writeMessageList(int i5, List<?> list, Schema schema) {
        for (int i6 = 0; i6 < list.size(); i6++) {
            writeMessage(i5, list.get(i6), schema);
        }
    }

    @Override // com.google.protobuf.Writer
    public final void writeMessageSetItem(int i5, Object obj) {
        if (obj instanceof ByteString) {
            this.output.writeRawMessageSetExtension(i5, (ByteString) obj);
        } else {
            this.output.writeMessageSetExtension(i5, (MessageLite) obj);
        }
    }

    @Override // com.google.protobuf.Writer
    public void writeSFixed32(int i5, int i6) {
        this.output.writeSFixed32(i5, i6);
    }

    @Override // com.google.protobuf.Writer
    public void writeSFixed32List(int i5, List<Integer> list, boolean z5) {
        int i6 = 0;
        if (!z5) {
            while (i6 < list.size()) {
                this.output.writeSFixed32(i5, list.get(i6).intValue());
                i6++;
            }
            return;
        }
        this.output.writeTag(i5, 2);
        int i7 = 0;
        for (int i8 = 0; i8 < list.size(); i8++) {
            i7 += CodedOutputStream.computeSFixed32SizeNoTag(list.get(i8).intValue());
        }
        this.output.writeUInt32NoTag(i7);
        while (i6 < list.size()) {
            this.output.writeSFixed32NoTag(list.get(i6).intValue());
            i6++;
        }
    }

    @Override // com.google.protobuf.Writer
    public void writeSFixed64(int i5, long j5) {
        this.output.writeSFixed64(i5, j5);
    }

    @Override // com.google.protobuf.Writer
    public void writeSFixed64List(int i5, List<Long> list, boolean z5) {
        int i6 = 0;
        if (!z5) {
            while (i6 < list.size()) {
                this.output.writeSFixed64(i5, list.get(i6).longValue());
                i6++;
            }
            return;
        }
        this.output.writeTag(i5, 2);
        int i7 = 0;
        for (int i8 = 0; i8 < list.size(); i8++) {
            i7 += CodedOutputStream.computeSFixed64SizeNoTag(list.get(i8).longValue());
        }
        this.output.writeUInt32NoTag(i7);
        while (i6 < list.size()) {
            this.output.writeSFixed64NoTag(list.get(i6).longValue());
            i6++;
        }
    }

    @Override // com.google.protobuf.Writer
    public void writeSInt32(int i5, int i6) {
        this.output.writeSInt32(i5, i6);
    }

    @Override // com.google.protobuf.Writer
    public void writeSInt32List(int i5, List<Integer> list, boolean z5) {
        int i6 = 0;
        if (!z5) {
            while (i6 < list.size()) {
                this.output.writeSInt32(i5, list.get(i6).intValue());
                i6++;
            }
            return;
        }
        this.output.writeTag(i5, 2);
        int i7 = 0;
        for (int i8 = 0; i8 < list.size(); i8++) {
            i7 += CodedOutputStream.computeSInt32SizeNoTag(list.get(i8).intValue());
        }
        this.output.writeUInt32NoTag(i7);
        while (i6 < list.size()) {
            this.output.writeSInt32NoTag(list.get(i6).intValue());
            i6++;
        }
    }

    @Override // com.google.protobuf.Writer
    public void writeSInt64(int i5, long j5) {
        this.output.writeSInt64(i5, j5);
    }

    @Override // com.google.protobuf.Writer
    public void writeSInt64List(int i5, List<Long> list, boolean z5) {
        int i6 = 0;
        if (!z5) {
            while (i6 < list.size()) {
                this.output.writeSInt64(i5, list.get(i6).longValue());
                i6++;
            }
            return;
        }
        this.output.writeTag(i5, 2);
        int i7 = 0;
        for (int i8 = 0; i8 < list.size(); i8++) {
            i7 += CodedOutputStream.computeSInt64SizeNoTag(list.get(i8).longValue());
        }
        this.output.writeUInt32NoTag(i7);
        while (i6 < list.size()) {
            this.output.writeSInt64NoTag(list.get(i6).longValue());
            i6++;
        }
    }

    @Override // com.google.protobuf.Writer
    @Deprecated
    public void writeStartGroup(int i5) {
        this.output.writeTag(i5, 3);
    }

    @Override // com.google.protobuf.Writer
    public void writeString(int i5, String str) {
        this.output.writeString(i5, str);
    }

    @Override // com.google.protobuf.Writer
    public void writeStringList(int i5, List<String> list) {
        int i6 = 0;
        if (!(list instanceof LazyStringList)) {
            while (i6 < list.size()) {
                this.output.writeString(i5, list.get(i6));
                i6++;
            }
        } else {
            LazyStringList lazyStringList = (LazyStringList) list;
            while (i6 < list.size()) {
                writeLazyString(i5, lazyStringList.getRaw(i6));
                i6++;
            }
        }
    }

    @Override // com.google.protobuf.Writer
    public void writeUInt32(int i5, int i6) {
        this.output.writeUInt32(i5, i6);
    }

    @Override // com.google.protobuf.Writer
    public void writeUInt32List(int i5, List<Integer> list, boolean z5) {
        int i6 = 0;
        if (!z5) {
            while (i6 < list.size()) {
                this.output.writeUInt32(i5, list.get(i6).intValue());
                i6++;
            }
            return;
        }
        this.output.writeTag(i5, 2);
        int i7 = 0;
        for (int i8 = 0; i8 < list.size(); i8++) {
            i7 += CodedOutputStream.computeUInt32SizeNoTag(list.get(i8).intValue());
        }
        this.output.writeUInt32NoTag(i7);
        while (i6 < list.size()) {
            this.output.writeUInt32NoTag(list.get(i6).intValue());
            i6++;
        }
    }

    @Override // com.google.protobuf.Writer
    public void writeUInt64(int i5, long j5) {
        this.output.writeUInt64(i5, j5);
    }

    @Override // com.google.protobuf.Writer
    public void writeUInt64List(int i5, List<Long> list, boolean z5) {
        int i6 = 0;
        if (!z5) {
            while (i6 < list.size()) {
                this.output.writeUInt64(i5, list.get(i6).longValue());
                i6++;
            }
            return;
        }
        this.output.writeTag(i5, 2);
        int i7 = 0;
        for (int i8 = 0; i8 < list.size(); i8++) {
            i7 += CodedOutputStream.computeUInt64SizeNoTag(list.get(i8).longValue());
        }
        this.output.writeUInt32NoTag(i7);
        while (i6 < list.size()) {
            this.output.writeUInt64NoTag(list.get(i6).longValue());
            i6++;
        }
    }
}
