package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.FieldSet;
import androidx.datastore.preferences.protobuf.Internal;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class SchemaUtil {
    private static final int DEFAULT_LOOK_UP_START_NUMBER = 40;
    private static final Class<?> GENERATED_MESSAGE_CLASS = getGeneratedMessageClass();
    private static final UnknownFieldSchema<?, ?> UNKNOWN_FIELD_SET_FULL_SCHEMA = getUnknownFieldSetSchema();
    private static final UnknownFieldSchema<?, ?> UNKNOWN_FIELD_SET_LITE_SCHEMA = new UnknownFieldSetLiteSchema();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int computeSizeBoolList(int i5, List<?> list, boolean z5) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return z5 ? CodedOutputStream.computeTagSize(i5) + CodedOutputStream.computeLengthDelimitedFieldSize(size) : size * CodedOutputStream.computeBoolSize(i5, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int computeSizeBoolListNoTag(List<?> list) {
        return list.size();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int computeSizeByteStringList(int i5, List<ByteString> list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int computeTagSize = size * CodedOutputStream.computeTagSize(i5);
        for (int i6 = 0; i6 < list.size(); i6++) {
            computeTagSize += CodedOutputStream.computeBytesSizeNoTag(list.get(i6));
        }
        return computeTagSize;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int computeSizeEnumList(int i5, List<Integer> list, boolean z5) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int computeSizeEnumListNoTag = computeSizeEnumListNoTag(list);
        return z5 ? CodedOutputStream.computeTagSize(i5) + CodedOutputStream.computeLengthDelimitedFieldSize(computeSizeEnumListNoTag) : computeSizeEnumListNoTag + (size * CodedOutputStream.computeTagSize(i5));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int computeSizeEnumListNoTag(List<Integer> list) {
        int i5;
        int size = list.size();
        int i6 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof IntArrayList) {
            IntArrayList intArrayList = (IntArrayList) list;
            i5 = 0;
            while (i6 < size) {
                i5 += CodedOutputStream.computeEnumSizeNoTag(intArrayList.getInt(i6));
                i6++;
            }
        } else {
            i5 = 0;
            while (i6 < size) {
                i5 += CodedOutputStream.computeEnumSizeNoTag(list.get(i6).intValue());
                i6++;
            }
        }
        return i5;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int computeSizeFixed32List(int i5, List<?> list, boolean z5) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return z5 ? CodedOutputStream.computeTagSize(i5) + CodedOutputStream.computeLengthDelimitedFieldSize(size * 4) : size * CodedOutputStream.computeFixed32Size(i5, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int computeSizeFixed32ListNoTag(List<?> list) {
        return list.size() * 4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int computeSizeFixed64List(int i5, List<?> list, boolean z5) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return z5 ? CodedOutputStream.computeTagSize(i5) + CodedOutputStream.computeLengthDelimitedFieldSize(size * 8) : size * CodedOutputStream.computeFixed64Size(i5, 0L);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int computeSizeFixed64ListNoTag(List<?> list) {
        return list.size() * 8;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int computeSizeGroupList(int i5, List<MessageLite> list, Schema schema) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i6 = 0;
        for (int i7 = 0; i7 < size; i7++) {
            i6 += CodedOutputStream.computeGroupSize(i5, list.get(i7), schema);
        }
        return i6;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int computeSizeInt32List(int i5, List<Integer> list, boolean z5) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int computeSizeInt32ListNoTag = computeSizeInt32ListNoTag(list);
        return z5 ? CodedOutputStream.computeTagSize(i5) + CodedOutputStream.computeLengthDelimitedFieldSize(computeSizeInt32ListNoTag) : computeSizeInt32ListNoTag + (size * CodedOutputStream.computeTagSize(i5));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int computeSizeInt32ListNoTag(List<Integer> list) {
        int i5;
        int size = list.size();
        int i6 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof IntArrayList) {
            IntArrayList intArrayList = (IntArrayList) list;
            i5 = 0;
            while (i6 < size) {
                i5 += CodedOutputStream.computeInt32SizeNoTag(intArrayList.getInt(i6));
                i6++;
            }
        } else {
            i5 = 0;
            while (i6 < size) {
                i5 += CodedOutputStream.computeInt32SizeNoTag(list.get(i6).intValue());
                i6++;
            }
        }
        return i5;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int computeSizeInt64List(int i5, List<Long> list, boolean z5) {
        if (list.size() == 0) {
            return 0;
        }
        int computeSizeInt64ListNoTag = computeSizeInt64ListNoTag(list);
        return z5 ? CodedOutputStream.computeTagSize(i5) + CodedOutputStream.computeLengthDelimitedFieldSize(computeSizeInt64ListNoTag) : computeSizeInt64ListNoTag + (list.size() * CodedOutputStream.computeTagSize(i5));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int computeSizeInt64ListNoTag(List<Long> list) {
        int i5;
        int size = list.size();
        int i6 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof LongArrayList) {
            LongArrayList longArrayList = (LongArrayList) list;
            i5 = 0;
            while (i6 < size) {
                i5 += CodedOutputStream.computeInt64SizeNoTag(longArrayList.getLong(i6));
                i6++;
            }
        } else {
            i5 = 0;
            while (i6 < size) {
                i5 += CodedOutputStream.computeInt64SizeNoTag(list.get(i6).longValue());
                i6++;
            }
        }
        return i5;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int computeSizeMessage(int i5, Object obj, Schema schema) {
        return CodedOutputStream.computeMessageSize(i5, (MessageLite) obj, schema);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int computeSizeMessageList(int i5, List<?> list, Schema schema) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int computeTagSize = CodedOutputStream.computeTagSize(i5) * size;
        for (int i6 = 0; i6 < size; i6++) {
            computeTagSize += CodedOutputStream.computeMessageSizeNoTag((MessageLite) list.get(i6), schema);
        }
        return computeTagSize;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int computeSizeSInt32List(int i5, List<Integer> list, boolean z5) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int computeSizeSInt32ListNoTag = computeSizeSInt32ListNoTag(list);
        return z5 ? CodedOutputStream.computeTagSize(i5) + CodedOutputStream.computeLengthDelimitedFieldSize(computeSizeSInt32ListNoTag) : computeSizeSInt32ListNoTag + (size * CodedOutputStream.computeTagSize(i5));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int computeSizeSInt32ListNoTag(List<Integer> list) {
        int i5;
        int size = list.size();
        int i6 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof IntArrayList) {
            IntArrayList intArrayList = (IntArrayList) list;
            i5 = 0;
            while (i6 < size) {
                i5 += CodedOutputStream.computeSInt32SizeNoTag(intArrayList.getInt(i6));
                i6++;
            }
        } else {
            i5 = 0;
            while (i6 < size) {
                i5 += CodedOutputStream.computeSInt32SizeNoTag(list.get(i6).intValue());
                i6++;
            }
        }
        return i5;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int computeSizeSInt64List(int i5, List<Long> list, boolean z5) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int computeSizeSInt64ListNoTag = computeSizeSInt64ListNoTag(list);
        return z5 ? CodedOutputStream.computeTagSize(i5) + CodedOutputStream.computeLengthDelimitedFieldSize(computeSizeSInt64ListNoTag) : computeSizeSInt64ListNoTag + (size * CodedOutputStream.computeTagSize(i5));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int computeSizeSInt64ListNoTag(List<Long> list) {
        int i5;
        int size = list.size();
        int i6 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof LongArrayList) {
            LongArrayList longArrayList = (LongArrayList) list;
            i5 = 0;
            while (i6 < size) {
                i5 += CodedOutputStream.computeSInt64SizeNoTag(longArrayList.getLong(i6));
                i6++;
            }
        } else {
            i5 = 0;
            while (i6 < size) {
                i5 += CodedOutputStream.computeSInt64SizeNoTag(list.get(i6).longValue());
                i6++;
            }
        }
        return i5;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int computeSizeStringList(int i5, List<?> list) {
        int size = list.size();
        int i6 = 0;
        if (size == 0) {
            return 0;
        }
        int computeTagSize = CodedOutputStream.computeTagSize(i5) * size;
        if (list instanceof LazyStringList) {
            LazyStringList lazyStringList = (LazyStringList) list;
            while (i6 < size) {
                Object raw = lazyStringList.getRaw(i6);
                computeTagSize += raw instanceof ByteString ? CodedOutputStream.computeBytesSizeNoTag((ByteString) raw) : CodedOutputStream.computeStringSizeNoTag((String) raw);
                i6++;
            }
        } else {
            while (i6 < size) {
                Object obj = list.get(i6);
                computeTagSize += obj instanceof ByteString ? CodedOutputStream.computeBytesSizeNoTag((ByteString) obj) : CodedOutputStream.computeStringSizeNoTag((String) obj);
                i6++;
            }
        }
        return computeTagSize;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int computeSizeUInt32List(int i5, List<Integer> list, boolean z5) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int computeSizeUInt32ListNoTag = computeSizeUInt32ListNoTag(list);
        return z5 ? CodedOutputStream.computeTagSize(i5) + CodedOutputStream.computeLengthDelimitedFieldSize(computeSizeUInt32ListNoTag) : computeSizeUInt32ListNoTag + (size * CodedOutputStream.computeTagSize(i5));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int computeSizeUInt32ListNoTag(List<Integer> list) {
        int i5;
        int size = list.size();
        int i6 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof IntArrayList) {
            IntArrayList intArrayList = (IntArrayList) list;
            i5 = 0;
            while (i6 < size) {
                i5 += CodedOutputStream.computeUInt32SizeNoTag(intArrayList.getInt(i6));
                i6++;
            }
        } else {
            i5 = 0;
            while (i6 < size) {
                i5 += CodedOutputStream.computeUInt32SizeNoTag(list.get(i6).intValue());
                i6++;
            }
        }
        return i5;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int computeSizeUInt64List(int i5, List<Long> list, boolean z5) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int computeSizeUInt64ListNoTag = computeSizeUInt64ListNoTag(list);
        return z5 ? CodedOutputStream.computeTagSize(i5) + CodedOutputStream.computeLengthDelimitedFieldSize(computeSizeUInt64ListNoTag) : computeSizeUInt64ListNoTag + (size * CodedOutputStream.computeTagSize(i5));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int computeSizeUInt64ListNoTag(List<Long> list) {
        int i5;
        int size = list.size();
        int i6 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof LongArrayList) {
            LongArrayList longArrayList = (LongArrayList) list;
            i5 = 0;
            while (i6 < size) {
                i5 += CodedOutputStream.computeUInt64SizeNoTag(longArrayList.getLong(i6));
                i6++;
            }
        } else {
            i5 = 0;
            while (i6 < size) {
                i5 += CodedOutputStream.computeUInt64SizeNoTag(list.get(i6).longValue());
                i6++;
            }
        }
        return i5;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <UT, UB> UB filterUnknownEnumList(Object obj, int i5, List<Integer> list, Internal.EnumVerifier enumVerifier, UB ub, UnknownFieldSchema<UT, UB> unknownFieldSchema) {
        if (enumVerifier == null) {
            return ub;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            int i6 = 0;
            for (int i7 = 0; i7 < size; i7++) {
                Integer num = list.get(i7);
                int intValue = num.intValue();
                if (enumVerifier.isInRange(intValue)) {
                    if (i7 != i6) {
                        list.set(i6, num);
                    }
                    i6++;
                } else {
                    ub = (UB) storeUnknownEnum(obj, i5, intValue, ub, unknownFieldSchema);
                }
            }
            if (i6 != size) {
                list.subList(i6, size).clear();
            }
        } else {
            Iterator<Integer> it = list.iterator();
            while (it.hasNext()) {
                int intValue2 = it.next().intValue();
                if (!enumVerifier.isInRange(intValue2)) {
                    ub = (UB) storeUnknownEnum(obj, i5, intValue2, ub, unknownFieldSchema);
                    it.remove();
                }
            }
        }
        return ub;
    }

    private static Class<?> getGeneratedMessageClass() {
        if (Protobuf.assumeLiteRuntime) {
            return null;
        }
        try {
            return Class.forName("androidx.datastore.preferences.protobuf.GeneratedMessage");
        } catch (Throwable unused) {
            return null;
        }
    }

    private static UnknownFieldSchema<?, ?> getUnknownFieldSetSchema() {
        try {
            Class<?> unknownFieldSetSchemaClass = getUnknownFieldSetSchemaClass();
            if (unknownFieldSetSchemaClass == null) {
                return null;
            }
            return (UnknownFieldSchema) unknownFieldSetSchemaClass.getConstructor(null).newInstance(null);
        } catch (Throwable unused) {
            return null;
        }
    }

    private static Class<?> getUnknownFieldSetSchemaClass() {
        if (Protobuf.assumeLiteRuntime) {
            return null;
        }
        try {
            return Class.forName("androidx.datastore.preferences.protobuf.UnknownFieldSetSchema");
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T, FT extends FieldSet.FieldDescriptorLite<FT>> void mergeExtensions(ExtensionSchema<FT> extensionSchema, T t5, T t6) {
        FieldSet<FT> extensions = extensionSchema.getExtensions(t6);
        if (extensions.isEmpty()) {
            return;
        }
        extensionSchema.getMutableExtensions(t5).mergeFrom(extensions);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> void mergeMap(MapFieldSchema mapFieldSchema, T t5, T t6, long j5) {
        UnsafeUtil.putObject(t5, j5, mapFieldSchema.mergeFrom(UnsafeUtil.getObject(t5, j5), UnsafeUtil.getObject(t6, j5)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T, UT, UB> void mergeUnknownFields(UnknownFieldSchema<UT, UB> unknownFieldSchema, T t5, T t6) {
        unknownFieldSchema.setToMessage(t5, unknownFieldSchema.merge(unknownFieldSchema.getFromMessage(t5), unknownFieldSchema.getFromMessage(t6)));
    }

    public static void requireGeneratedMessage(Class<?> cls) {
        Class<?> cls2;
        if (!GeneratedMessageLite.class.isAssignableFrom(cls) && !Protobuf.assumeLiteRuntime && (cls2 = GENERATED_MESSAGE_CLASS) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean safeEquals(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    static <UT, UB> UB storeUnknownEnum(Object obj, int i5, int i6, UB ub, UnknownFieldSchema<UT, UB> unknownFieldSchema) {
        if (ub == null) {
            ub = unknownFieldSchema.getBuilderFromMessage(obj);
        }
        unknownFieldSchema.addVarint(ub, i5, i6);
        return ub;
    }

    public static UnknownFieldSchema<?, ?> unknownFieldSetFullSchema() {
        return UNKNOWN_FIELD_SET_FULL_SCHEMA;
    }

    public static UnknownFieldSchema<?, ?> unknownFieldSetLiteSchema() {
        return UNKNOWN_FIELD_SET_LITE_SCHEMA;
    }

    public static void writeBoolList(int i5, List<Boolean> list, Writer writer, boolean z5) {
        if (list == null || list.isEmpty()) {
            return;
        }
        writer.writeBoolList(i5, list, z5);
    }

    public static void writeBytesList(int i5, List<ByteString> list, Writer writer) {
        if (list == null || list.isEmpty()) {
            return;
        }
        writer.writeBytesList(i5, list);
    }

    public static void writeDoubleList(int i5, List<Double> list, Writer writer, boolean z5) {
        if (list == null || list.isEmpty()) {
            return;
        }
        writer.writeDoubleList(i5, list, z5);
    }

    public static void writeEnumList(int i5, List<Integer> list, Writer writer, boolean z5) {
        if (list == null || list.isEmpty()) {
            return;
        }
        writer.writeEnumList(i5, list, z5);
    }

    public static void writeFixed32List(int i5, List<Integer> list, Writer writer, boolean z5) {
        if (list == null || list.isEmpty()) {
            return;
        }
        writer.writeFixed32List(i5, list, z5);
    }

    public static void writeFixed64List(int i5, List<Long> list, Writer writer, boolean z5) {
        if (list == null || list.isEmpty()) {
            return;
        }
        writer.writeFixed64List(i5, list, z5);
    }

    public static void writeFloatList(int i5, List<Float> list, Writer writer, boolean z5) {
        if (list == null || list.isEmpty()) {
            return;
        }
        writer.writeFloatList(i5, list, z5);
    }

    public static void writeGroupList(int i5, List<?> list, Writer writer, Schema schema) {
        if (list == null || list.isEmpty()) {
            return;
        }
        writer.writeGroupList(i5, list, schema);
    }

    public static void writeInt32List(int i5, List<Integer> list, Writer writer, boolean z5) {
        if (list == null || list.isEmpty()) {
            return;
        }
        writer.writeInt32List(i5, list, z5);
    }

    public static void writeInt64List(int i5, List<Long> list, Writer writer, boolean z5) {
        if (list == null || list.isEmpty()) {
            return;
        }
        writer.writeInt64List(i5, list, z5);
    }

    public static void writeMessageList(int i5, List<?> list, Writer writer, Schema schema) {
        if (list == null || list.isEmpty()) {
            return;
        }
        writer.writeMessageList(i5, list, schema);
    }

    public static void writeSFixed32List(int i5, List<Integer> list, Writer writer, boolean z5) {
        if (list == null || list.isEmpty()) {
            return;
        }
        writer.writeSFixed32List(i5, list, z5);
    }

    public static void writeSFixed64List(int i5, List<Long> list, Writer writer, boolean z5) {
        if (list == null || list.isEmpty()) {
            return;
        }
        writer.writeSFixed64List(i5, list, z5);
    }

    public static void writeSInt32List(int i5, List<Integer> list, Writer writer, boolean z5) {
        if (list == null || list.isEmpty()) {
            return;
        }
        writer.writeSInt32List(i5, list, z5);
    }

    public static void writeSInt64List(int i5, List<Long> list, Writer writer, boolean z5) {
        if (list == null || list.isEmpty()) {
            return;
        }
        writer.writeSInt64List(i5, list, z5);
    }

    public static void writeStringList(int i5, List<String> list, Writer writer) {
        if (list == null || list.isEmpty()) {
            return;
        }
        writer.writeStringList(i5, list);
    }

    public static void writeUInt32List(int i5, List<Integer> list, Writer writer, boolean z5) {
        if (list == null || list.isEmpty()) {
            return;
        }
        writer.writeUInt32List(i5, list, z5);
    }

    public static void writeUInt64List(int i5, List<Long> list, Writer writer, boolean z5) {
        if (list == null || list.isEmpty()) {
            return;
        }
        writer.writeUInt64List(i5, list, z5);
    }
}
