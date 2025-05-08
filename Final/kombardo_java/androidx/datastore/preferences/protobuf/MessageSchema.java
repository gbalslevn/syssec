package androidx.datastore.preferences.protobuf;

import android.support.v4.media.session.a;
import androidx.appcompat.R$styleable;
import androidx.datastore.preferences.protobuf.FieldSet;
import androidx.datastore.preferences.protobuf.Internal;
import androidx.datastore.preferences.protobuf.InvalidProtocolBufferException;
import androidx.datastore.preferences.protobuf.WireFormat;
import androidx.datastore.preferences.protobuf.Writer;
import com.sun.jna.Function;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import sun.misc.Unsafe;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class MessageSchema<T> implements Schema<T> {
    private static final int CHECK_INITIALIZED_BIT = 1024;
    private static final int ENFORCE_UTF8_MASK = 536870912;
    private static final int FIELD_TYPE_MASK = 267386880;
    private static final int HAS_HAS_BIT = 4096;
    private static final int INTS_PER_FIELD = 3;
    private static final int LEGACY_ENUM_IS_CLOSED_BIT = 2048;
    private static final int LEGACY_ENUM_IS_CLOSED_MASK = Integer.MIN_VALUE;
    private static final int NO_PRESENCE_SENTINEL = 1048575;
    private static final int OFFSET_BITS = 20;
    private static final int OFFSET_MASK = 1048575;
    private static final int REQUIRED_BIT = 256;
    private static final int REQUIRED_MASK = 268435456;
    private static final int UTF8_CHECK_BIT = 512;
    private final int[] buffer;
    private final int checkInitializedCount;
    private final MessageLite defaultInstance;
    private final ExtensionSchema<?> extensionSchema;
    private final boolean hasExtensions;
    private final int[] intArray;
    private final ListFieldSchema listFieldSchema;
    private final boolean lite;
    private final MapFieldSchema mapFieldSchema;
    private final int maxFieldNumber;
    private final int minFieldNumber;
    private final NewInstanceSchema newInstanceSchema;
    private final Object[] objects;
    private final int repeatedFieldOffsetStart;
    private final ProtoSyntax syntax;
    private final UnknownFieldSchema<?, ?> unknownFieldSchema;
    private final boolean useCachedSizeField;
    private static final int[] EMPTY_INT_ARRAY = new int[0];
    private static final Unsafe UNSAFE = UnsafeUtil.getUnsafe();

    private MessageSchema(int[] iArr, Object[] objArr, int i5, int i6, MessageLite messageLite, ProtoSyntax protoSyntax, boolean z5, int[] iArr2, int i7, int i8, NewInstanceSchema newInstanceSchema, ListFieldSchema listFieldSchema, UnknownFieldSchema<?, ?> unknownFieldSchema, ExtensionSchema<?> extensionSchema, MapFieldSchema mapFieldSchema) {
        this.buffer = iArr;
        this.objects = objArr;
        this.minFieldNumber = i5;
        this.maxFieldNumber = i6;
        this.lite = messageLite instanceof GeneratedMessageLite;
        this.syntax = protoSyntax;
        this.hasExtensions = extensionSchema != null && extensionSchema.hasExtensions(messageLite);
        this.useCachedSizeField = z5;
        this.intArray = iArr2;
        this.checkInitializedCount = i7;
        this.repeatedFieldOffsetStart = i8;
        this.newInstanceSchema = newInstanceSchema;
        this.listFieldSchema = listFieldSchema;
        this.unknownFieldSchema = unknownFieldSchema;
        this.extensionSchema = extensionSchema;
        this.defaultInstance = messageLite;
        this.mapFieldSchema = mapFieldSchema;
    }

    private boolean arePresentForEquals(T t5, T t6, int i5) {
        return isFieldPresent(t5, i5) == isFieldPresent(t6, i5);
    }

    private static <T> boolean booleanAt(T t5, long j5) {
        return UnsafeUtil.getBoolean(t5, j5);
    }

    private static void checkMutable(Object obj) {
        if (isMutable(obj)) {
            return;
        }
        throw new IllegalArgumentException("Mutating immutable message: " + obj);
    }

    private static <T> double doubleAt(T t5, long j5) {
        return UnsafeUtil.getDouble(t5, j5);
    }

    private <UT, UB> UB filterMapUnknownEnumValues(Object obj, int i5, UB ub, UnknownFieldSchema<UT, UB> unknownFieldSchema, Object obj2) {
        numberAt(i5);
        if (UnsafeUtil.getObject(obj, offset(typeAndOffsetAt(i5))) == null) {
            return ub;
        }
        getEnumFieldVerifier(i5);
        return ub;
    }

    private static <T> float floatAt(T t5, long j5) {
        return UnsafeUtil.getFloat(t5, j5);
    }

    private Internal.EnumVerifier getEnumFieldVerifier(int i5) {
        a.a(this.objects[((i5 / 3) * 2) + 1]);
        return null;
    }

    private Object getMapFieldDefaultEntry(int i5) {
        return this.objects[(i5 / 3) * 2];
    }

    private Schema getMessageFieldSchema(int i5) {
        int i6 = (i5 / 3) * 2;
        Schema schema = (Schema) this.objects[i6];
        if (schema != null) {
            return schema;
        }
        Schema<T> schemaFor = Protobuf.getInstance().schemaFor((Class) this.objects[i6 + 1]);
        this.objects[i6] = schemaFor;
        return schemaFor;
    }

    private <UT, UB> int getUnknownFieldsSerializedSize(UnknownFieldSchema<UT, UB> unknownFieldSchema, T t5) {
        return unknownFieldSchema.getSerializedSize(unknownFieldSchema.getFromMessage(t5));
    }

    private static <T> int intAt(T t5, long j5) {
        return UnsafeUtil.getInt(t5, j5);
    }

    private static boolean isEnforceUtf8(int i5) {
        return (i5 & ENFORCE_UTF8_MASK) != 0;
    }

    private boolean isFieldPresent(T t5, int i5, int i6, int i7, int i8) {
        if (i6 == 1048575) {
            return isFieldPresent(t5, i5);
        }
        return (i7 & i8) != 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private <N> boolean isListInitialized(Object obj, int i5, int i6) {
        List list = (List) UnsafeUtil.getObject(obj, offset(i5));
        if (list.isEmpty()) {
            return true;
        }
        Schema messageFieldSchema = getMessageFieldSchema(i6);
        for (int i7 = 0; i7 < list.size(); i7++) {
            if (!messageFieldSchema.isInitialized(list.get(i7))) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v12 */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r5v7 */
    /* JADX WARN: Type inference failed for: r5v8, types: [androidx.datastore.preferences.protobuf.Schema] */
    private boolean isMapInitialized(T t5, int i5, int i6) {
        Map<?, ?> forMapData = this.mapFieldSchema.forMapData(UnsafeUtil.getObject(t5, offset(i5)));
        if (forMapData.isEmpty()) {
            return true;
        }
        if (this.mapFieldSchema.forMapMetadata(getMapFieldDefaultEntry(i6)).valueType.getJavaType() != WireFormat.JavaType.MESSAGE) {
            return true;
        }
        ?? r5 = 0;
        for (Object obj : forMapData.values()) {
            r5 = r5;
            if (r5 == 0) {
                r5 = Protobuf.getInstance().schemaFor((Class) obj.getClass());
            }
            if (!r5.isInitialized(obj)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isMutable(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof GeneratedMessageLite) {
            return ((GeneratedMessageLite) obj).isMutable();
        }
        return true;
    }

    private boolean isOneofCaseEqual(T t5, T t6, int i5) {
        long presenceMaskAndOffsetAt = presenceMaskAndOffsetAt(i5) & 1048575;
        return UnsafeUtil.getInt(t5, presenceMaskAndOffsetAt) == UnsafeUtil.getInt(t6, presenceMaskAndOffsetAt);
    }

    private boolean isOneofPresent(T t5, int i5, int i6) {
        return UnsafeUtil.getInt(t5, (long) (presenceMaskAndOffsetAt(i6) & 1048575)) == i5;
    }

    private static boolean isRequired(int i5) {
        return (i5 & REQUIRED_MASK) != 0;
    }

    private static <T> long longAt(T t5, long j5) {
        return UnsafeUtil.getLong(t5, j5);
    }

    /* JADX WARN: Code restructure failed: missing block: B:196:0x009c, code lost:
    
        r0 = r19.checkInitializedCount;
        r5 = r18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:198:0x00a2, code lost:
    
        if (r0 >= r19.repeatedFieldOffsetStart) goto L235;
     */
    /* JADX WARN: Code restructure failed: missing block: B:199:0x00a4, code lost:
    
        r5 = filterMapUnknownEnumValues(r22, r19.intArray[r0], r5, r20, r22);
        r0 = r0 + 1;
        r4 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:201:0x00ba, code lost:
    
        r11 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:202:0x00bb, code lost:
    
        if (r5 == null) goto L238;
     */
    /* JADX WARN: Code restructure failed: missing block: B:203:0x00bd, code lost:
    
        r7.setBuilderToMessage(r11, r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:204:0x00c0, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:205:?, code lost:
    
        return;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:12:0x00d4. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0604 A[Catch: all -> 0x0291, TRY_LEAVE, TryCatch #2 {all -> 0x0291, blocks: (B:42:0x05fe, B:44:0x0604, B:57:0x062d, B:117:0x028c, B:120:0x0294, B:121:0x02a5, B:122:0x02b6, B:123:0x02c7, B:124:0x02d8, B:125:0x02f9, B:126:0x030a, B:127:0x031b, B:128:0x032c, B:129:0x033d, B:130:0x034e, B:131:0x035f, B:132:0x0370, B:133:0x0381, B:134:0x0392, B:135:0x03a3, B:136:0x03b4, B:137:0x03c5, B:138:0x03d6, B:139:0x03f7, B:140:0x0408, B:141:0x0419, B:142:0x042d, B:143:0x0434, B:144:0x0445, B:145:0x0456, B:146:0x0467, B:147:0x0478, B:148:0x0489, B:149:0x049a, B:150:0x04ab, B:151:0x04bc, B:152:0x04d0, B:153:0x04e2, B:154:0x04f4, B:155:0x0506, B:156:0x0518, B:157:0x052d, B:158:0x053f, B:159:0x0551, B:160:0x0565, B:161:0x056f, B:162:0x0581, B:163:0x0593, B:164:0x05a5, B:165:0x05b7, B:166:0x05c9, B:167:0x05db, B:168:0x05ed), top: B:41:0x05fe }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x062b  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x066d A[LOOP:4: B:76:0x0669->B:78:0x066d, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0682  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private <UT, UB, ET extends FieldSet.FieldDescriptorLite<ET>> void mergeFromHelper(UnknownFieldSchema<UT, UB> unknownFieldSchema, ExtensionSchema<ET> extensionSchema, T t5, Reader reader, ExtensionRegistryLite extensionRegistryLite) {
        UnknownFieldSchema unknownFieldSchema2;
        T t6;
        int i5;
        Object obj;
        T t7;
        Object builderFromMessage;
        ExtensionRegistryLite extensionRegistryLite2;
        UnknownFieldSchema unknownFieldSchema3 = unknownFieldSchema;
        T t8 = t5;
        ExtensionRegistryLite extensionRegistryLite3 = extensionRegistryLite;
        FieldSet<ET> fieldSet = null;
        Object obj2 = null;
        while (true) {
            try {
                int fieldNumber = reader.getFieldNumber();
                int positionForFieldNumber = positionForFieldNumber(fieldNumber);
                if (positionForFieldNumber >= 0) {
                    t6 = t8;
                    try {
                        int typeAndOffsetAt = typeAndOffsetAt(positionForFieldNumber);
                        switch (type(typeAndOffsetAt)) {
                            case 0:
                                extensionRegistryLite2 = extensionRegistryLite3;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                UnsafeUtil.putDouble(t6, offset(typeAndOffsetAt), reader.readDouble());
                                setFieldPresent(t6, positionForFieldNumber);
                                t8 = t6;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                unknownFieldSchema3 = unknownFieldSchema2;
                                break;
                            case 1:
                                extensionRegistryLite2 = extensionRegistryLite3;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                UnsafeUtil.putFloat(t6, offset(typeAndOffsetAt), reader.readFloat());
                                setFieldPresent(t6, positionForFieldNumber);
                                t8 = t6;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                unknownFieldSchema3 = unknownFieldSchema2;
                                break;
                            case 2:
                                extensionRegistryLite2 = extensionRegistryLite3;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                UnsafeUtil.putLong(t6, offset(typeAndOffsetAt), reader.readInt64());
                                setFieldPresent(t6, positionForFieldNumber);
                                t8 = t6;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                unknownFieldSchema3 = unknownFieldSchema2;
                                break;
                            case 3:
                                extensionRegistryLite2 = extensionRegistryLite3;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                UnsafeUtil.putLong(t6, offset(typeAndOffsetAt), reader.readUInt64());
                                setFieldPresent(t6, positionForFieldNumber);
                                t8 = t6;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                unknownFieldSchema3 = unknownFieldSchema2;
                                break;
                            case 4:
                                extensionRegistryLite2 = extensionRegistryLite3;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                UnsafeUtil.putInt(t6, offset(typeAndOffsetAt), reader.readInt32());
                                setFieldPresent(t6, positionForFieldNumber);
                                t8 = t6;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                unknownFieldSchema3 = unknownFieldSchema2;
                                break;
                            case 5:
                                extensionRegistryLite2 = extensionRegistryLite3;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                UnsafeUtil.putLong(t6, offset(typeAndOffsetAt), reader.readFixed64());
                                setFieldPresent(t6, positionForFieldNumber);
                                t8 = t6;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                unknownFieldSchema3 = unknownFieldSchema2;
                                break;
                            case 6:
                                extensionRegistryLite2 = extensionRegistryLite3;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                UnsafeUtil.putInt(t6, offset(typeAndOffsetAt), reader.readFixed32());
                                setFieldPresent(t6, positionForFieldNumber);
                                t8 = t6;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                unknownFieldSchema3 = unknownFieldSchema2;
                                break;
                            case 7:
                                extensionRegistryLite2 = extensionRegistryLite3;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                UnsafeUtil.putBoolean(t6, offset(typeAndOffsetAt), reader.readBool());
                                setFieldPresent(t6, positionForFieldNumber);
                                t8 = t6;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                unknownFieldSchema3 = unknownFieldSchema2;
                                break;
                            case 8:
                                extensionRegistryLite2 = extensionRegistryLite3;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                readString(t6, typeAndOffsetAt, reader);
                                setFieldPresent(t6, positionForFieldNumber);
                                t8 = t6;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                unknownFieldSchema3 = unknownFieldSchema2;
                                break;
                            case 9:
                                extensionRegistryLite2 = extensionRegistryLite3;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                MessageLite messageLite = (MessageLite) mutableMessageFieldForMerge(t6, positionForFieldNumber);
                                reader.mergeMessageField(messageLite, getMessageFieldSchema(positionForFieldNumber), extensionRegistryLite2);
                                storeMessageField(t6, positionForFieldNumber, messageLite);
                                t8 = t6;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                unknownFieldSchema3 = unknownFieldSchema2;
                                break;
                            case 10:
                                extensionRegistryLite2 = extensionRegistryLite3;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                UnsafeUtil.putObject(t6, offset(typeAndOffsetAt), reader.readBytes());
                                setFieldPresent(t6, positionForFieldNumber);
                                t8 = t6;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                unknownFieldSchema3 = unknownFieldSchema2;
                                break;
                            case 11:
                                extensionRegistryLite2 = extensionRegistryLite3;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                UnsafeUtil.putInt(t6, offset(typeAndOffsetAt), reader.readUInt32());
                                setFieldPresent(t6, positionForFieldNumber);
                                t8 = t6;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                unknownFieldSchema3 = unknownFieldSchema2;
                                break;
                            case 12:
                                extensionRegistryLite2 = extensionRegistryLite3;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                int readEnum = reader.readEnum();
                                getEnumFieldVerifier(positionForFieldNumber);
                                UnsafeUtil.putInt(t6, offset(typeAndOffsetAt), readEnum);
                                setFieldPresent(t6, positionForFieldNumber);
                                t8 = t6;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                unknownFieldSchema3 = unknownFieldSchema2;
                                break;
                            case 13:
                                extensionRegistryLite2 = extensionRegistryLite3;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                UnsafeUtil.putInt(t6, offset(typeAndOffsetAt), reader.readSFixed32());
                                setFieldPresent(t6, positionForFieldNumber);
                                t8 = t6;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                unknownFieldSchema3 = unknownFieldSchema2;
                                break;
                            case 14:
                                extensionRegistryLite2 = extensionRegistryLite3;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                UnsafeUtil.putLong(t6, offset(typeAndOffsetAt), reader.readSFixed64());
                                setFieldPresent(t6, positionForFieldNumber);
                                t8 = t6;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                unknownFieldSchema3 = unknownFieldSchema2;
                                break;
                            case 15:
                                extensionRegistryLite2 = extensionRegistryLite3;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                UnsafeUtil.putInt(t6, offset(typeAndOffsetAt), reader.readSInt32());
                                setFieldPresent(t6, positionForFieldNumber);
                                t8 = t6;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                unknownFieldSchema3 = unknownFieldSchema2;
                                break;
                            case 16:
                                extensionRegistryLite2 = extensionRegistryLite3;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                UnsafeUtil.putLong(t6, offset(typeAndOffsetAt), reader.readSInt64());
                                setFieldPresent(t6, positionForFieldNumber);
                                t8 = t6;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                unknownFieldSchema3 = unknownFieldSchema2;
                                break;
                            case 17:
                                extensionRegistryLite2 = extensionRegistryLite3;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                MessageLite messageLite2 = (MessageLite) mutableMessageFieldForMerge(t6, positionForFieldNumber);
                                reader.mergeGroupField(messageLite2, getMessageFieldSchema(positionForFieldNumber), extensionRegistryLite2);
                                storeMessageField(t6, positionForFieldNumber, messageLite2);
                                t8 = t6;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                unknownFieldSchema3 = unknownFieldSchema2;
                                break;
                            case 18:
                                extensionRegistryLite2 = extensionRegistryLite3;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                reader.readDoubleList(this.listFieldSchema.mutableListAt(t6, offset(typeAndOffsetAt)));
                                t8 = t6;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                unknownFieldSchema3 = unknownFieldSchema2;
                                break;
                            case 19:
                                extensionRegistryLite2 = extensionRegistryLite3;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                reader.readFloatList(this.listFieldSchema.mutableListAt(t6, offset(typeAndOffsetAt)));
                                t8 = t6;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                unknownFieldSchema3 = unknownFieldSchema2;
                                break;
                            case 20:
                                extensionRegistryLite2 = extensionRegistryLite3;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                reader.readInt64List(this.listFieldSchema.mutableListAt(t6, offset(typeAndOffsetAt)));
                                t8 = t6;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                unknownFieldSchema3 = unknownFieldSchema2;
                                break;
                            case 21:
                                extensionRegistryLite2 = extensionRegistryLite3;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                reader.readUInt64List(this.listFieldSchema.mutableListAt(t6, offset(typeAndOffsetAt)));
                                t8 = t6;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                unknownFieldSchema3 = unknownFieldSchema2;
                                break;
                            case 22:
                                extensionRegistryLite2 = extensionRegistryLite3;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                reader.readInt32List(this.listFieldSchema.mutableListAt(t6, offset(typeAndOffsetAt)));
                                t8 = t6;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                unknownFieldSchema3 = unknownFieldSchema2;
                                break;
                            case R$styleable.Toolbar_titleMarginBottom /* 23 */:
                                extensionRegistryLite2 = extensionRegistryLite3;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                reader.readFixed64List(this.listFieldSchema.mutableListAt(t6, offset(typeAndOffsetAt)));
                                t8 = t6;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                unknownFieldSchema3 = unknownFieldSchema2;
                                break;
                            case R$styleable.Toolbar_titleMarginEnd /* 24 */:
                                extensionRegistryLite2 = extensionRegistryLite3;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                reader.readFixed32List(this.listFieldSchema.mutableListAt(t6, offset(typeAndOffsetAt)));
                                t8 = t6;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                unknownFieldSchema3 = unknownFieldSchema2;
                                break;
                            case 25:
                                extensionRegistryLite2 = extensionRegistryLite3;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                reader.readBoolList(this.listFieldSchema.mutableListAt(t6, offset(typeAndOffsetAt)));
                                t8 = t6;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                unknownFieldSchema3 = unknownFieldSchema2;
                                break;
                            case 26:
                                extensionRegistryLite2 = extensionRegistryLite3;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                readStringList(t6, typeAndOffsetAt, reader);
                                t8 = t6;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                unknownFieldSchema3 = unknownFieldSchema2;
                                break;
                            case 27:
                                extensionRegistryLite2 = extensionRegistryLite3;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                readMessageList(t5, typeAndOffsetAt, reader, getMessageFieldSchema(positionForFieldNumber), extensionRegistryLite);
                                t8 = t6;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                unknownFieldSchema3 = unknownFieldSchema2;
                                break;
                            case 28:
                                extensionRegistryLite2 = extensionRegistryLite3;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                reader.readBytesList(this.listFieldSchema.mutableListAt(t6, offset(typeAndOffsetAt)));
                                t8 = t6;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                unknownFieldSchema3 = unknownFieldSchema2;
                                break;
                            case R$styleable.Toolbar_titleTextColor /* 29 */:
                                extensionRegistryLite2 = extensionRegistryLite3;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                reader.readUInt32List(this.listFieldSchema.mutableListAt(t6, offset(typeAndOffsetAt)));
                                t8 = t6;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                unknownFieldSchema3 = unknownFieldSchema2;
                                break;
                            case 30:
                                extensionRegistryLite2 = extensionRegistryLite3;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                List<Integer> mutableListAt = this.listFieldSchema.mutableListAt(t6, offset(typeAndOffsetAt));
                                reader.readEnumList(mutableListAt);
                                getEnumFieldVerifier(positionForFieldNumber);
                                obj2 = SchemaUtil.filterUnknownEnumList(t5, fieldNumber, mutableListAt, null, obj2, unknownFieldSchema);
                                t8 = t6;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                unknownFieldSchema3 = unknownFieldSchema2;
                                break;
                            case 31:
                                extensionRegistryLite2 = extensionRegistryLite3;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                reader.readSFixed32List(this.listFieldSchema.mutableListAt(t6, offset(typeAndOffsetAt)));
                                t8 = t6;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                unknownFieldSchema3 = unknownFieldSchema2;
                                break;
                            case 32:
                                extensionRegistryLite2 = extensionRegistryLite3;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                reader.readSFixed64List(this.listFieldSchema.mutableListAt(t6, offset(typeAndOffsetAt)));
                                t8 = t6;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                unknownFieldSchema3 = unknownFieldSchema2;
                                break;
                            case 33:
                                extensionRegistryLite2 = extensionRegistryLite3;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                reader.readSInt32List(this.listFieldSchema.mutableListAt(t6, offset(typeAndOffsetAt)));
                                t8 = t6;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                unknownFieldSchema3 = unknownFieldSchema2;
                                break;
                            case 34:
                                extensionRegistryLite2 = extensionRegistryLite3;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                reader.readSInt64List(this.listFieldSchema.mutableListAt(t6, offset(typeAndOffsetAt)));
                                t8 = t6;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                unknownFieldSchema3 = unknownFieldSchema2;
                                break;
                            case 35:
                                extensionRegistryLite2 = extensionRegistryLite3;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                reader.readDoubleList(this.listFieldSchema.mutableListAt(t6, offset(typeAndOffsetAt)));
                                t8 = t6;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                unknownFieldSchema3 = unknownFieldSchema2;
                                break;
                            case 36:
                                extensionRegistryLite2 = extensionRegistryLite3;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                reader.readFloatList(this.listFieldSchema.mutableListAt(t6, offset(typeAndOffsetAt)));
                                t8 = t6;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                unknownFieldSchema3 = unknownFieldSchema2;
                                break;
                            case 37:
                                extensionRegistryLite2 = extensionRegistryLite3;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                reader.readInt64List(this.listFieldSchema.mutableListAt(t6, offset(typeAndOffsetAt)));
                                t8 = t6;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                unknownFieldSchema3 = unknownFieldSchema2;
                                break;
                            case 38:
                                extensionRegistryLite2 = extensionRegistryLite3;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                reader.readUInt64List(this.listFieldSchema.mutableListAt(t6, offset(typeAndOffsetAt)));
                                t8 = t6;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                unknownFieldSchema3 = unknownFieldSchema2;
                                break;
                            case 39:
                                extensionRegistryLite2 = extensionRegistryLite3;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                reader.readInt32List(this.listFieldSchema.mutableListAt(t6, offset(typeAndOffsetAt)));
                                t8 = t6;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                unknownFieldSchema3 = unknownFieldSchema2;
                                break;
                            case 40:
                                extensionRegistryLite2 = extensionRegistryLite3;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                reader.readFixed64List(this.listFieldSchema.mutableListAt(t6, offset(typeAndOffsetAt)));
                                t8 = t6;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                unknownFieldSchema3 = unknownFieldSchema2;
                                break;
                            case 41:
                                extensionRegistryLite2 = extensionRegistryLite3;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                reader.readFixed32List(this.listFieldSchema.mutableListAt(t6, offset(typeAndOffsetAt)));
                                t8 = t6;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                unknownFieldSchema3 = unknownFieldSchema2;
                                break;
                            case 42:
                                extensionRegistryLite2 = extensionRegistryLite3;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                reader.readBoolList(this.listFieldSchema.mutableListAt(t6, offset(typeAndOffsetAt)));
                                t8 = t6;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                unknownFieldSchema3 = unknownFieldSchema2;
                                break;
                            case 43:
                                extensionRegistryLite2 = extensionRegistryLite3;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                reader.readUInt32List(this.listFieldSchema.mutableListAt(t6, offset(typeAndOffsetAt)));
                                t8 = t6;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                unknownFieldSchema3 = unknownFieldSchema2;
                                break;
                            case 44:
                                extensionRegistryLite2 = extensionRegistryLite3;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                List<Integer> mutableListAt2 = this.listFieldSchema.mutableListAt(t6, offset(typeAndOffsetAt));
                                reader.readEnumList(mutableListAt2);
                                getEnumFieldVerifier(positionForFieldNumber);
                                obj2 = SchemaUtil.filterUnknownEnumList(t5, fieldNumber, mutableListAt2, null, obj2, unknownFieldSchema);
                                t8 = t6;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                unknownFieldSchema3 = unknownFieldSchema2;
                                break;
                            case 45:
                                extensionRegistryLite2 = extensionRegistryLite3;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                reader.readSFixed32List(this.listFieldSchema.mutableListAt(t6, offset(typeAndOffsetAt)));
                                t8 = t6;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                unknownFieldSchema3 = unknownFieldSchema2;
                                break;
                            case 46:
                                extensionRegistryLite2 = extensionRegistryLite3;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                reader.readSFixed64List(this.listFieldSchema.mutableListAt(t6, offset(typeAndOffsetAt)));
                                t8 = t6;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                unknownFieldSchema3 = unknownFieldSchema2;
                                break;
                            case 47:
                                extensionRegistryLite2 = extensionRegistryLite3;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                reader.readSInt32List(this.listFieldSchema.mutableListAt(t6, offset(typeAndOffsetAt)));
                                t8 = t6;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                unknownFieldSchema3 = unknownFieldSchema2;
                                break;
                            case 48:
                                extensionRegistryLite2 = extensionRegistryLite3;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                reader.readSInt64List(this.listFieldSchema.mutableListAt(t6, offset(typeAndOffsetAt)));
                                t8 = t6;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                unknownFieldSchema3 = unknownFieldSchema2;
                                break;
                            case 49:
                                extensionRegistryLite2 = extensionRegistryLite3;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                try {
                                    readGroupList(t5, offset(typeAndOffsetAt), reader, getMessageFieldSchema(positionForFieldNumber), extensionRegistryLite);
                                } catch (InvalidProtocolBufferException.InvalidWireTypeException unused) {
                                    try {
                                        if (!unknownFieldSchema2.shouldDiscardUnknownFields(reader)) {
                                            Object builderFromMessage2 = obj2 == null ? unknownFieldSchema2.getBuilderFromMessage(t6) : obj2;
                                            try {
                                                if (!unknownFieldSchema2.mergeOneFieldFrom(builderFromMessage2, reader, 0)) {
                                                    Object obj3 = builderFromMessage2;
                                                    for (int i6 = this.checkInitializedCount; i6 < this.repeatedFieldOffsetStart; i6++) {
                                                        obj3 = filterMapUnknownEnumValues(t5, this.intArray[i6], obj3, unknownFieldSchema, t5);
                                                    }
                                                    if (obj3 != null) {
                                                        unknownFieldSchema2.setBuilderToMessage(t6, obj3);
                                                        return;
                                                    }
                                                    return;
                                                }
                                                obj2 = builderFromMessage2;
                                            } catch (Throwable th) {
                                                th = th;
                                                obj2 = builderFromMessage2;
                                                obj = obj2;
                                                while (i5 < this.repeatedFieldOffsetStart) {
                                                }
                                                if (obj != null) {
                                                }
                                                throw th;
                                            }
                                        } else if (!reader.skipField()) {
                                            Object obj4 = obj2;
                                            for (int i7 = this.checkInitializedCount; i7 < this.repeatedFieldOffsetStart; i7++) {
                                                obj4 = filterMapUnknownEnumValues(t5, this.intArray[i7], obj4, unknownFieldSchema, t5);
                                            }
                                            if (obj4 != null) {
                                                unknownFieldSchema2.setBuilderToMessage(t6, obj4);
                                                return;
                                            }
                                            return;
                                        }
                                        t8 = t6;
                                        extensionRegistryLite3 = extensionRegistryLite2;
                                        unknownFieldSchema3 = unknownFieldSchema2;
                                    } catch (Throwable th2) {
                                        th = th2;
                                    }
                                }
                                t8 = t6;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                unknownFieldSchema3 = unknownFieldSchema2;
                                break;
                            case 50:
                                extensionRegistryLite2 = extensionRegistryLite3;
                                try {
                                    mergeMap(t5, positionForFieldNumber, getMapFieldDefaultEntry(positionForFieldNumber), extensionRegistryLite, reader);
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                } catch (InvalidProtocolBufferException.InvalidWireTypeException unused2) {
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    if (!unknownFieldSchema2.shouldDiscardUnknownFields(reader)) {
                                    }
                                    t8 = t6;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                }
                                t8 = t6;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                unknownFieldSchema3 = unknownFieldSchema2;
                                break;
                            case 51:
                                UnsafeUtil.putObject(t6, offset(typeAndOffsetAt), Double.valueOf(reader.readDouble()));
                                setOneofPresent(t6, fieldNumber, positionForFieldNumber);
                                extensionRegistryLite2 = extensionRegistryLite3;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                t8 = t6;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                unknownFieldSchema3 = unknownFieldSchema2;
                                break;
                            case 52:
                                UnsafeUtil.putObject(t6, offset(typeAndOffsetAt), Float.valueOf(reader.readFloat()));
                                setOneofPresent(t6, fieldNumber, positionForFieldNumber);
                                extensionRegistryLite2 = extensionRegistryLite3;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                t8 = t6;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                unknownFieldSchema3 = unknownFieldSchema2;
                                break;
                            case 53:
                                UnsafeUtil.putObject(t6, offset(typeAndOffsetAt), Long.valueOf(reader.readInt64()));
                                setOneofPresent(t6, fieldNumber, positionForFieldNumber);
                                extensionRegistryLite2 = extensionRegistryLite3;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                t8 = t6;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                unknownFieldSchema3 = unknownFieldSchema2;
                                break;
                            case 54:
                                UnsafeUtil.putObject(t6, offset(typeAndOffsetAt), Long.valueOf(reader.readUInt64()));
                                setOneofPresent(t6, fieldNumber, positionForFieldNumber);
                                extensionRegistryLite2 = extensionRegistryLite3;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                t8 = t6;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                unknownFieldSchema3 = unknownFieldSchema2;
                                break;
                            case 55:
                                UnsafeUtil.putObject(t6, offset(typeAndOffsetAt), Integer.valueOf(reader.readInt32()));
                                setOneofPresent(t6, fieldNumber, positionForFieldNumber);
                                extensionRegistryLite2 = extensionRegistryLite3;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                t8 = t6;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                unknownFieldSchema3 = unknownFieldSchema2;
                                break;
                            case 56:
                                UnsafeUtil.putObject(t6, offset(typeAndOffsetAt), Long.valueOf(reader.readFixed64()));
                                setOneofPresent(t6, fieldNumber, positionForFieldNumber);
                                extensionRegistryLite2 = extensionRegistryLite3;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                t8 = t6;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                unknownFieldSchema3 = unknownFieldSchema2;
                                break;
                            case 57:
                                UnsafeUtil.putObject(t6, offset(typeAndOffsetAt), Integer.valueOf(reader.readFixed32()));
                                setOneofPresent(t6, fieldNumber, positionForFieldNumber);
                                extensionRegistryLite2 = extensionRegistryLite3;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                t8 = t6;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                unknownFieldSchema3 = unknownFieldSchema2;
                                break;
                            case 58:
                                UnsafeUtil.putObject(t6, offset(typeAndOffsetAt), Boolean.valueOf(reader.readBool()));
                                setOneofPresent(t6, fieldNumber, positionForFieldNumber);
                                extensionRegistryLite2 = extensionRegistryLite3;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                t8 = t6;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                unknownFieldSchema3 = unknownFieldSchema2;
                                break;
                            case 59:
                                readString(t6, typeAndOffsetAt, reader);
                                setOneofPresent(t6, fieldNumber, positionForFieldNumber);
                                extensionRegistryLite2 = extensionRegistryLite3;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                t8 = t6;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                unknownFieldSchema3 = unknownFieldSchema2;
                                break;
                            case 60:
                                MessageLite messageLite3 = (MessageLite) mutableOneofMessageFieldForMerge(t6, fieldNumber, positionForFieldNumber);
                                reader.mergeMessageField(messageLite3, getMessageFieldSchema(positionForFieldNumber), extensionRegistryLite3);
                                storeOneofMessageField(t6, fieldNumber, positionForFieldNumber, messageLite3);
                                extensionRegistryLite2 = extensionRegistryLite3;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                t8 = t6;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                unknownFieldSchema3 = unknownFieldSchema2;
                                break;
                            case 61:
                                UnsafeUtil.putObject(t6, offset(typeAndOffsetAt), reader.readBytes());
                                setOneofPresent(t6, fieldNumber, positionForFieldNumber);
                                extensionRegistryLite2 = extensionRegistryLite3;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                t8 = t6;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                unknownFieldSchema3 = unknownFieldSchema2;
                                break;
                            case 62:
                                UnsafeUtil.putObject(t6, offset(typeAndOffsetAt), Integer.valueOf(reader.readUInt32()));
                                setOneofPresent(t6, fieldNumber, positionForFieldNumber);
                                extensionRegistryLite2 = extensionRegistryLite3;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                t8 = t6;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                unknownFieldSchema3 = unknownFieldSchema2;
                                break;
                            case Function.ALT_CONVENTION /* 63 */:
                                int readEnum2 = reader.readEnum();
                                getEnumFieldVerifier(positionForFieldNumber);
                                UnsafeUtil.putObject(t6, offset(typeAndOffsetAt), Integer.valueOf(readEnum2));
                                setOneofPresent(t6, fieldNumber, positionForFieldNumber);
                                extensionRegistryLite2 = extensionRegistryLite3;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                t8 = t6;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                unknownFieldSchema3 = unknownFieldSchema2;
                                break;
                            case Function.THROW_LAST_ERROR /* 64 */:
                                UnsafeUtil.putObject(t6, offset(typeAndOffsetAt), Integer.valueOf(reader.readSFixed32()));
                                setOneofPresent(t6, fieldNumber, positionForFieldNumber);
                                extensionRegistryLite2 = extensionRegistryLite3;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                t8 = t6;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                unknownFieldSchema3 = unknownFieldSchema2;
                                break;
                            case 65:
                                UnsafeUtil.putObject(t6, offset(typeAndOffsetAt), Long.valueOf(reader.readSFixed64()));
                                setOneofPresent(t6, fieldNumber, positionForFieldNumber);
                                extensionRegistryLite2 = extensionRegistryLite3;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                t8 = t6;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                unknownFieldSchema3 = unknownFieldSchema2;
                                break;
                            case 66:
                                UnsafeUtil.putObject(t6, offset(typeAndOffsetAt), Integer.valueOf(reader.readSInt32()));
                                setOneofPresent(t6, fieldNumber, positionForFieldNumber);
                                extensionRegistryLite2 = extensionRegistryLite3;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                t8 = t6;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                unknownFieldSchema3 = unknownFieldSchema2;
                                break;
                            case 67:
                                UnsafeUtil.putObject(t6, offset(typeAndOffsetAt), Long.valueOf(reader.readSInt64()));
                                setOneofPresent(t6, fieldNumber, positionForFieldNumber);
                                extensionRegistryLite2 = extensionRegistryLite3;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                t8 = t6;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                unknownFieldSchema3 = unknownFieldSchema2;
                                break;
                            case 68:
                                MessageLite messageLite4 = (MessageLite) mutableOneofMessageFieldForMerge(t6, fieldNumber, positionForFieldNumber);
                                reader.mergeGroupField(messageLite4, getMessageFieldSchema(positionForFieldNumber), extensionRegistryLite3);
                                storeOneofMessageField(t6, fieldNumber, positionForFieldNumber, messageLite4);
                                extensionRegistryLite2 = extensionRegistryLite3;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                t8 = t6;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                unknownFieldSchema3 = unknownFieldSchema2;
                                break;
                            default:
                                if (obj2 == null) {
                                    obj2 = unknownFieldSchema3.getBuilderFromMessage(t6);
                                }
                                builderFromMessage = obj2;
                                try {
                                } catch (InvalidProtocolBufferException.InvalidWireTypeException unused3) {
                                    obj2 = builderFromMessage;
                                    extensionRegistryLite2 = extensionRegistryLite3;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    if (!unknownFieldSchema2.shouldDiscardUnknownFields(reader)) {
                                    }
                                    t8 = t6;
                                    extensionRegistryLite3 = extensionRegistryLite2;
                                    unknownFieldSchema3 = unknownFieldSchema2;
                                } catch (Throwable th3) {
                                    th = th3;
                                    obj2 = builderFromMessage;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    obj = obj2;
                                    while (i5 < this.repeatedFieldOffsetStart) {
                                    }
                                    if (obj != null) {
                                    }
                                    throw th;
                                }
                                if (!unknownFieldSchema3.mergeOneFieldFrom(builderFromMessage, reader, 0)) {
                                    Object obj5 = builderFromMessage;
                                    for (int i8 = this.checkInitializedCount; i8 < this.repeatedFieldOffsetStart; i8++) {
                                        obj5 = filterMapUnknownEnumValues(t5, this.intArray[i8], obj5, unknownFieldSchema, t5);
                                    }
                                    if (obj5 != null) {
                                        unknownFieldSchema3.setBuilderToMessage(t6, obj5);
                                        return;
                                    }
                                    return;
                                }
                                obj2 = builderFromMessage;
                                extensionRegistryLite2 = extensionRegistryLite3;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                t8 = t6;
                                extensionRegistryLite3 = extensionRegistryLite2;
                                unknownFieldSchema3 = unknownFieldSchema2;
                                break;
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        unknownFieldSchema2 = unknownFieldSchema3;
                        obj = obj2;
                        for (i5 = this.checkInitializedCount; i5 < this.repeatedFieldOffsetStart; i5++) {
                            obj = filterMapUnknownEnumValues(t5, this.intArray[i5], obj, unknownFieldSchema, t5);
                        }
                        if (obj != null) {
                            unknownFieldSchema2.setBuilderToMessage(t6, obj);
                        }
                        throw th;
                    }
                } else {
                    if (fieldNumber == Integer.MAX_VALUE) {
                        Object obj6 = obj2;
                        for (int i9 = this.checkInitializedCount; i9 < this.repeatedFieldOffsetStart; i9++) {
                            obj6 = filterMapUnknownEnumValues(t5, this.intArray[i9], obj6, unknownFieldSchema, t5);
                        }
                        if (obj6 != null) {
                            unknownFieldSchema3.setBuilderToMessage(t8, obj6);
                            return;
                        }
                        return;
                    }
                    try {
                        Object findExtensionByNumber = !this.hasExtensions ? null : extensionSchema.findExtensionByNumber(extensionRegistryLite3, this.defaultInstance, fieldNumber);
                        if (findExtensionByNumber != null) {
                            FieldSet<ET> mutableExtensions = fieldSet == null ? extensionSchema.getMutableExtensions(t5) : fieldSet;
                            t7 = t8;
                            try {
                                obj2 = extensionSchema.parseExtension(t5, reader, findExtensionByNumber, extensionRegistryLite, mutableExtensions, obj2, unknownFieldSchema);
                                fieldSet = mutableExtensions;
                            } catch (Throwable th5) {
                                th = th5;
                                t6 = t7;
                                unknownFieldSchema2 = unknownFieldSchema3;
                                obj = obj2;
                                while (i5 < this.repeatedFieldOffsetStart) {
                                }
                                if (obj != null) {
                                }
                                throw th;
                            }
                        } else {
                            t7 = t8;
                            if (!unknownFieldSchema3.shouldDiscardUnknownFields(reader)) {
                                builderFromMessage = obj2 == null ? unknownFieldSchema3.getBuilderFromMessage(t7) : obj2;
                                try {
                                    obj2 = builderFromMessage;
                                    if (!unknownFieldSchema3.mergeOneFieldFrom(builderFromMessage, reader, 0)) {
                                    }
                                } catch (Throwable th6) {
                                    th = th6;
                                    t6 = t7;
                                    obj2 = builderFromMessage;
                                    unknownFieldSchema2 = unknownFieldSchema3;
                                    obj = obj2;
                                    while (i5 < this.repeatedFieldOffsetStart) {
                                    }
                                    if (obj != null) {
                                    }
                                    throw th;
                                }
                            } else if (reader.skipField()) {
                            }
                        }
                        t8 = t7;
                    } catch (Throwable th7) {
                        th = th7;
                        t6 = t8;
                    }
                }
            } catch (Throwable th8) {
                th = th8;
                unknownFieldSchema2 = unknownFieldSchema3;
                t6 = t8;
            }
        }
    }

    private final <K, V> void mergeMap(Object obj, int i5, Object obj2, ExtensionRegistryLite extensionRegistryLite, Reader reader) {
        long offset = offset(typeAndOffsetAt(i5));
        Object object = UnsafeUtil.getObject(obj, offset);
        if (object == null) {
            object = this.mapFieldSchema.newMapField(obj2);
            UnsafeUtil.putObject(obj, offset, object);
        } else if (this.mapFieldSchema.isImmutable(object)) {
            Object newMapField = this.mapFieldSchema.newMapField(obj2);
            this.mapFieldSchema.mergeFrom(newMapField, object);
            UnsafeUtil.putObject(obj, offset, newMapField);
            object = newMapField;
        }
        reader.readMap(this.mapFieldSchema.forMutableMapData(object), this.mapFieldSchema.forMapMetadata(obj2), extensionRegistryLite);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void mergeMessage(T t5, T t6, int i5) {
        if (isFieldPresent(t6, i5)) {
            long offset = offset(typeAndOffsetAt(i5));
            Unsafe unsafe = UNSAFE;
            Object object = unsafe.getObject(t6, offset);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + numberAt(i5) + " is present but null: " + t6);
            }
            Schema messageFieldSchema = getMessageFieldSchema(i5);
            if (!isFieldPresent(t5, i5)) {
                if (isMutable(object)) {
                    Object newInstance = messageFieldSchema.newInstance();
                    messageFieldSchema.mergeFrom(newInstance, object);
                    unsafe.putObject(t5, offset, newInstance);
                } else {
                    unsafe.putObject(t5, offset, object);
                }
                setFieldPresent(t5, i5);
                return;
            }
            Object object2 = unsafe.getObject(t5, offset);
            if (!isMutable(object2)) {
                Object newInstance2 = messageFieldSchema.newInstance();
                messageFieldSchema.mergeFrom(newInstance2, object2);
                unsafe.putObject(t5, offset, newInstance2);
                object2 = newInstance2;
            }
            messageFieldSchema.mergeFrom(object2, object);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void mergeOneofMessage(T t5, T t6, int i5) {
        int numberAt = numberAt(i5);
        if (isOneofPresent(t6, numberAt, i5)) {
            long offset = offset(typeAndOffsetAt(i5));
            Unsafe unsafe = UNSAFE;
            Object object = unsafe.getObject(t6, offset);
            if (object == null) {
                throw new IllegalStateException("Source subfield " + numberAt(i5) + " is present but null: " + t6);
            }
            Schema messageFieldSchema = getMessageFieldSchema(i5);
            if (!isOneofPresent(t5, numberAt, i5)) {
                if (isMutable(object)) {
                    Object newInstance = messageFieldSchema.newInstance();
                    messageFieldSchema.mergeFrom(newInstance, object);
                    unsafe.putObject(t5, offset, newInstance);
                } else {
                    unsafe.putObject(t5, offset, object);
                }
                setOneofPresent(t5, numberAt, i5);
                return;
            }
            Object object2 = unsafe.getObject(t5, offset);
            if (!isMutable(object2)) {
                Object newInstance2 = messageFieldSchema.newInstance();
                messageFieldSchema.mergeFrom(newInstance2, object2);
                unsafe.putObject(t5, offset, newInstance2);
                object2 = newInstance2;
            }
            messageFieldSchema.mergeFrom(object2, object);
        }
    }

    private void mergeSingleField(T t5, T t6, int i5) {
        int typeAndOffsetAt = typeAndOffsetAt(i5);
        long offset = offset(typeAndOffsetAt);
        int numberAt = numberAt(i5);
        switch (type(typeAndOffsetAt)) {
            case 0:
                if (isFieldPresent(t6, i5)) {
                    UnsafeUtil.putDouble(t5, offset, UnsafeUtil.getDouble(t6, offset));
                    setFieldPresent(t5, i5);
                    return;
                }
                return;
            case 1:
                if (isFieldPresent(t6, i5)) {
                    UnsafeUtil.putFloat(t5, offset, UnsafeUtil.getFloat(t6, offset));
                    setFieldPresent(t5, i5);
                    return;
                }
                return;
            case 2:
                if (isFieldPresent(t6, i5)) {
                    UnsafeUtil.putLong(t5, offset, UnsafeUtil.getLong(t6, offset));
                    setFieldPresent(t5, i5);
                    return;
                }
                return;
            case 3:
                if (isFieldPresent(t6, i5)) {
                    UnsafeUtil.putLong(t5, offset, UnsafeUtil.getLong(t6, offset));
                    setFieldPresent(t5, i5);
                    return;
                }
                return;
            case 4:
                if (isFieldPresent(t6, i5)) {
                    UnsafeUtil.putInt(t5, offset, UnsafeUtil.getInt(t6, offset));
                    setFieldPresent(t5, i5);
                    return;
                }
                return;
            case 5:
                if (isFieldPresent(t6, i5)) {
                    UnsafeUtil.putLong(t5, offset, UnsafeUtil.getLong(t6, offset));
                    setFieldPresent(t5, i5);
                    return;
                }
                return;
            case 6:
                if (isFieldPresent(t6, i5)) {
                    UnsafeUtil.putInt(t5, offset, UnsafeUtil.getInt(t6, offset));
                    setFieldPresent(t5, i5);
                    return;
                }
                return;
            case 7:
                if (isFieldPresent(t6, i5)) {
                    UnsafeUtil.putBoolean(t5, offset, UnsafeUtil.getBoolean(t6, offset));
                    setFieldPresent(t5, i5);
                    return;
                }
                return;
            case 8:
                if (isFieldPresent(t6, i5)) {
                    UnsafeUtil.putObject(t5, offset, UnsafeUtil.getObject(t6, offset));
                    setFieldPresent(t5, i5);
                    return;
                }
                return;
            case 9:
                mergeMessage(t5, t6, i5);
                return;
            case 10:
                if (isFieldPresent(t6, i5)) {
                    UnsafeUtil.putObject(t5, offset, UnsafeUtil.getObject(t6, offset));
                    setFieldPresent(t5, i5);
                    return;
                }
                return;
            case 11:
                if (isFieldPresent(t6, i5)) {
                    UnsafeUtil.putInt(t5, offset, UnsafeUtil.getInt(t6, offset));
                    setFieldPresent(t5, i5);
                    return;
                }
                return;
            case 12:
                if (isFieldPresent(t6, i5)) {
                    UnsafeUtil.putInt(t5, offset, UnsafeUtil.getInt(t6, offset));
                    setFieldPresent(t5, i5);
                    return;
                }
                return;
            case 13:
                if (isFieldPresent(t6, i5)) {
                    UnsafeUtil.putInt(t5, offset, UnsafeUtil.getInt(t6, offset));
                    setFieldPresent(t5, i5);
                    return;
                }
                return;
            case 14:
                if (isFieldPresent(t6, i5)) {
                    UnsafeUtil.putLong(t5, offset, UnsafeUtil.getLong(t6, offset));
                    setFieldPresent(t5, i5);
                    return;
                }
                return;
            case 15:
                if (isFieldPresent(t6, i5)) {
                    UnsafeUtil.putInt(t5, offset, UnsafeUtil.getInt(t6, offset));
                    setFieldPresent(t5, i5);
                    return;
                }
                return;
            case 16:
                if (isFieldPresent(t6, i5)) {
                    UnsafeUtil.putLong(t5, offset, UnsafeUtil.getLong(t6, offset));
                    setFieldPresent(t5, i5);
                    return;
                }
                return;
            case 17:
                mergeMessage(t5, t6, i5);
                return;
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case R$styleable.Toolbar_titleMarginBottom /* 23 */:
            case R$styleable.Toolbar_titleMarginEnd /* 24 */:
            case 25:
            case 26:
            case 27:
            case 28:
            case R$styleable.Toolbar_titleTextColor /* 29 */:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 46:
            case 47:
            case 48:
            case 49:
                this.listFieldSchema.mergeListsAt(t5, t6, offset);
                return;
            case 50:
                SchemaUtil.mergeMap(this.mapFieldSchema, t5, t6, offset);
                return;
            case 51:
            case 52:
            case 53:
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
            case 59:
                if (isOneofPresent(t6, numberAt, i5)) {
                    UnsafeUtil.putObject(t5, offset, UnsafeUtil.getObject(t6, offset));
                    setOneofPresent(t5, numberAt, i5);
                    return;
                }
                return;
            case 60:
                mergeOneofMessage(t5, t6, i5);
                return;
            case 61:
            case 62:
            case Function.ALT_CONVENTION /* 63 */:
            case Function.THROW_LAST_ERROR /* 64 */:
            case 65:
            case 66:
            case 67:
                if (isOneofPresent(t6, numberAt, i5)) {
                    UnsafeUtil.putObject(t5, offset, UnsafeUtil.getObject(t6, offset));
                    setOneofPresent(t5, numberAt, i5);
                    return;
                }
                return;
            case 68:
                mergeOneofMessage(t5, t6, i5);
                return;
            default:
                return;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private Object mutableMessageFieldForMerge(T t5, int i5) {
        Schema messageFieldSchema = getMessageFieldSchema(i5);
        long offset = offset(typeAndOffsetAt(i5));
        if (!isFieldPresent(t5, i5)) {
            return messageFieldSchema.newInstance();
        }
        Object object = UNSAFE.getObject(t5, offset);
        if (isMutable(object)) {
            return object;
        }
        Object newInstance = messageFieldSchema.newInstance();
        if (object != null) {
            messageFieldSchema.mergeFrom(newInstance, object);
        }
        return newInstance;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private Object mutableOneofMessageFieldForMerge(T t5, int i5, int i6) {
        Schema messageFieldSchema = getMessageFieldSchema(i6);
        if (!isOneofPresent(t5, i5, i6)) {
            return messageFieldSchema.newInstance();
        }
        Object object = UNSAFE.getObject(t5, offset(typeAndOffsetAt(i6)));
        if (isMutable(object)) {
            return object;
        }
        Object newInstance = messageFieldSchema.newInstance();
        if (object != null) {
            messageFieldSchema.mergeFrom(newInstance, object);
        }
        return newInstance;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> MessageSchema<T> newSchema(Class<T> cls, MessageInfo messageInfo, NewInstanceSchema newInstanceSchema, ListFieldSchema listFieldSchema, UnknownFieldSchema<?, ?> unknownFieldSchema, ExtensionSchema<?> extensionSchema, MapFieldSchema mapFieldSchema) {
        if (messageInfo instanceof RawMessageInfo) {
            return newSchemaForRawMessageInfo((RawMessageInfo) messageInfo, newInstanceSchema, listFieldSchema, unknownFieldSchema, extensionSchema, mapFieldSchema);
        }
        a.a(messageInfo);
        return newSchemaForMessageInfo(null, newInstanceSchema, listFieldSchema, unknownFieldSchema, extensionSchema, mapFieldSchema);
    }

    static <T> MessageSchema<T> newSchemaForMessageInfo(StructuralMessageInfo structuralMessageInfo, NewInstanceSchema newInstanceSchema, ListFieldSchema listFieldSchema, UnknownFieldSchema<?, ?> unknownFieldSchema, ExtensionSchema<?> extensionSchema, MapFieldSchema mapFieldSchema) {
        throw null;
    }

    /* JADX WARN: Removed duplicated region for block: B:63:0x0249  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0264  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0267  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x024e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    static <T> MessageSchema<T> newSchemaForRawMessageInfo(RawMessageInfo rawMessageInfo, NewInstanceSchema newInstanceSchema, ListFieldSchema listFieldSchema, UnknownFieldSchema<?, ?> unknownFieldSchema, ExtensionSchema<?> extensionSchema, MapFieldSchema mapFieldSchema) {
        int i5;
        int charAt;
        int charAt2;
        int i6;
        int i7;
        int[] iArr;
        int i8;
        int i9;
        int i10;
        int i11;
        char charAt3;
        int i12;
        char charAt4;
        int i13;
        char charAt5;
        int i14;
        char charAt6;
        int i15;
        char charAt7;
        int i16;
        char charAt8;
        int i17;
        char charAt9;
        int i18;
        char charAt10;
        int i19;
        int i20;
        int i21;
        int i22;
        String str;
        int i23;
        int i24;
        int i25;
        int i26;
        int i27;
        Field reflectField;
        int i28;
        char charAt11;
        int i29;
        int i30;
        Object obj;
        Field reflectField2;
        Object obj2;
        Field reflectField3;
        int i31;
        char charAt12;
        int i32;
        char charAt13;
        int i33;
        char charAt14;
        int i34;
        char charAt15;
        String stringInfo = rawMessageInfo.getStringInfo();
        int length = stringInfo.length();
        char c5 = 55296;
        if (stringInfo.charAt(0) >= 55296) {
            int i35 = 1;
            while (true) {
                i5 = i35 + 1;
                if (stringInfo.charAt(i35) < 55296) {
                    break;
                }
                i35 = i5;
            }
        } else {
            i5 = 1;
        }
        int i36 = i5 + 1;
        int charAt16 = stringInfo.charAt(i5);
        if (charAt16 >= 55296) {
            int i37 = charAt16 & 8191;
            int i38 = 13;
            while (true) {
                i34 = i36 + 1;
                charAt15 = stringInfo.charAt(i36);
                if (charAt15 < 55296) {
                    break;
                }
                i37 |= (charAt15 & 8191) << i38;
                i38 += 13;
                i36 = i34;
            }
            charAt16 = i37 | (charAt15 << i38);
            i36 = i34;
        }
        if (charAt16 == 0) {
            charAt = 0;
            charAt2 = 0;
            i9 = 0;
            i10 = 0;
            i6 = 0;
            i8 = 0;
            iArr = EMPTY_INT_ARRAY;
            i7 = 0;
        } else {
            int i39 = i36 + 1;
            int charAt17 = stringInfo.charAt(i36);
            if (charAt17 >= 55296) {
                int i40 = charAt17 & 8191;
                int i41 = 13;
                while (true) {
                    i18 = i39 + 1;
                    charAt10 = stringInfo.charAt(i39);
                    if (charAt10 < 55296) {
                        break;
                    }
                    i40 |= (charAt10 & 8191) << i41;
                    i41 += 13;
                    i39 = i18;
                }
                charAt17 = i40 | (charAt10 << i41);
                i39 = i18;
            }
            int i42 = i39 + 1;
            int charAt18 = stringInfo.charAt(i39);
            if (charAt18 >= 55296) {
                int i43 = charAt18 & 8191;
                int i44 = 13;
                while (true) {
                    i17 = i42 + 1;
                    charAt9 = stringInfo.charAt(i42);
                    if (charAt9 < 55296) {
                        break;
                    }
                    i43 |= (charAt9 & 8191) << i44;
                    i44 += 13;
                    i42 = i17;
                }
                charAt18 = i43 | (charAt9 << i44);
                i42 = i17;
            }
            int i45 = i42 + 1;
            int charAt19 = stringInfo.charAt(i42);
            if (charAt19 >= 55296) {
                int i46 = charAt19 & 8191;
                int i47 = 13;
                while (true) {
                    i16 = i45 + 1;
                    charAt8 = stringInfo.charAt(i45);
                    if (charAt8 < 55296) {
                        break;
                    }
                    i46 |= (charAt8 & 8191) << i47;
                    i47 += 13;
                    i45 = i16;
                }
                charAt19 = i46 | (charAt8 << i47);
                i45 = i16;
            }
            int i48 = i45 + 1;
            int charAt20 = stringInfo.charAt(i45);
            if (charAt20 >= 55296) {
                int i49 = charAt20 & 8191;
                int i50 = 13;
                while (true) {
                    i15 = i48 + 1;
                    charAt7 = stringInfo.charAt(i48);
                    if (charAt7 < 55296) {
                        break;
                    }
                    i49 |= (charAt7 & 8191) << i50;
                    i50 += 13;
                    i48 = i15;
                }
                charAt20 = i49 | (charAt7 << i50);
                i48 = i15;
            }
            int i51 = i48 + 1;
            charAt = stringInfo.charAt(i48);
            if (charAt >= 55296) {
                int i52 = charAt & 8191;
                int i53 = 13;
                while (true) {
                    i14 = i51 + 1;
                    charAt6 = stringInfo.charAt(i51);
                    if (charAt6 < 55296) {
                        break;
                    }
                    i52 |= (charAt6 & 8191) << i53;
                    i53 += 13;
                    i51 = i14;
                }
                charAt = i52 | (charAt6 << i53);
                i51 = i14;
            }
            int i54 = i51 + 1;
            charAt2 = stringInfo.charAt(i51);
            if (charAt2 >= 55296) {
                int i55 = charAt2 & 8191;
                int i56 = 13;
                while (true) {
                    i13 = i54 + 1;
                    charAt5 = stringInfo.charAt(i54);
                    if (charAt5 < 55296) {
                        break;
                    }
                    i55 |= (charAt5 & 8191) << i56;
                    i56 += 13;
                    i54 = i13;
                }
                charAt2 = i55 | (charAt5 << i56);
                i54 = i13;
            }
            int i57 = i54 + 1;
            int charAt21 = stringInfo.charAt(i54);
            if (charAt21 >= 55296) {
                int i58 = charAt21 & 8191;
                int i59 = 13;
                while (true) {
                    i12 = i57 + 1;
                    charAt4 = stringInfo.charAt(i57);
                    if (charAt4 < 55296) {
                        break;
                    }
                    i58 |= (charAt4 & 8191) << i59;
                    i59 += 13;
                    i57 = i12;
                }
                charAt21 = i58 | (charAt4 << i59);
                i57 = i12;
            }
            int i60 = i57 + 1;
            int charAt22 = stringInfo.charAt(i57);
            if (charAt22 >= 55296) {
                int i61 = charAt22 & 8191;
                int i62 = 13;
                while (true) {
                    i11 = i60 + 1;
                    charAt3 = stringInfo.charAt(i60);
                    if (charAt3 < 55296) {
                        break;
                    }
                    i61 |= (charAt3 & 8191) << i62;
                    i62 += 13;
                    i60 = i11;
                }
                charAt22 = i61 | (charAt3 << i62);
                i60 = i11;
            }
            i6 = (charAt17 * 2) + charAt18;
            i7 = charAt17;
            iArr = new int[charAt22 + charAt2 + charAt21];
            i8 = charAt22;
            i36 = i60;
            i9 = charAt19;
            i10 = charAt20;
        }
        Unsafe unsafe = UNSAFE;
        Object[] objects = rawMessageInfo.getObjects();
        Class<?> cls = rawMessageInfo.getDefaultInstance().getClass();
        int[] iArr2 = new int[charAt * 3];
        Object[] objArr = new Object[charAt * 2];
        int i63 = i8 + charAt2;
        int i64 = i8;
        int i65 = i63;
        int i66 = 0;
        int i67 = 0;
        while (i36 < length) {
            int i68 = i36 + 1;
            int charAt23 = stringInfo.charAt(i36);
            if (charAt23 >= c5) {
                int i69 = charAt23 & 8191;
                int i70 = i68;
                int i71 = 13;
                while (true) {
                    i33 = i70 + 1;
                    charAt14 = stringInfo.charAt(i70);
                    if (charAt14 < c5) {
                        break;
                    }
                    i69 |= (charAt14 & 8191) << i71;
                    i71 += 13;
                    i70 = i33;
                }
                charAt23 = i69 | (charAt14 << i71);
                i19 = i33;
            } else {
                i19 = i68;
            }
            int i72 = i19 + 1;
            int charAt24 = stringInfo.charAt(i19);
            if (charAt24 >= c5) {
                int i73 = charAt24 & 8191;
                int i74 = i72;
                int i75 = 13;
                while (true) {
                    i32 = i74 + 1;
                    charAt13 = stringInfo.charAt(i74);
                    if (charAt13 < c5) {
                        break;
                    }
                    i73 |= (charAt13 & 8191) << i75;
                    i75 += 13;
                    i74 = i32;
                }
                charAt24 = i73 | (charAt13 << i75);
                i20 = i32;
            } else {
                i20 = i72;
            }
            int i76 = charAt24 & Function.USE_VARARGS;
            int i77 = length;
            if ((charAt24 & CHECK_INITIALIZED_BIT) != 0) {
                iArr[i66] = i67;
                i66++;
            }
            int i78 = i66;
            if (i76 >= 51) {
                int i79 = i20 + 1;
                int charAt25 = stringInfo.charAt(i20);
                char c6 = 55296;
                if (charAt25 >= 55296) {
                    int i80 = charAt25 & 8191;
                    int i81 = 13;
                    while (true) {
                        i31 = i79 + 1;
                        charAt12 = stringInfo.charAt(i79);
                        if (charAt12 < c6) {
                            break;
                        }
                        i80 |= (charAt12 & 8191) << i81;
                        i81 += 13;
                        i79 = i31;
                        c6 = 55296;
                    }
                    charAt25 = i80 | (charAt12 << i81);
                    i79 = i31;
                }
                int i82 = i76 - 51;
                int i83 = i79;
                if (i82 == 9 || i82 == 17) {
                    i30 = i6 + 1;
                    objArr[((i67 / 3) * 2) + 1] = objects[i6];
                } else {
                    if (i82 == 12 && (rawMessageInfo.getSyntax().equals(ProtoSyntax.PROTO2) || (charAt24 & LEGACY_ENUM_IS_CLOSED_BIT) != 0)) {
                        i30 = i6 + 1;
                        objArr[((i67 / 3) * 2) + 1] = objects[i6];
                    }
                    int i84 = charAt25 * 2;
                    obj = objects[i84];
                    if (obj instanceof Field) {
                        reflectField2 = reflectField(cls, (String) obj);
                        objects[i84] = reflectField2;
                    } else {
                        reflectField2 = (Field) obj;
                    }
                    i21 = i9;
                    i27 = (int) unsafe.objectFieldOffset(reflectField2);
                    int i85 = i84 + 1;
                    obj2 = objects[i85];
                    if (obj2 instanceof Field) {
                        reflectField3 = reflectField(cls, (String) obj2);
                        objects[i85] = reflectField3;
                    } else {
                        reflectField3 = (Field) obj2;
                    }
                    i22 = i10;
                    i23 = i6;
                    i25 = i83;
                    str = stringInfo;
                    i24 = (int) unsafe.objectFieldOffset(reflectField3);
                    i26 = 0;
                }
                i6 = i30;
                int i842 = charAt25 * 2;
                obj = objects[i842];
                if (obj instanceof Field) {
                }
                i21 = i9;
                i27 = (int) unsafe.objectFieldOffset(reflectField2);
                int i852 = i842 + 1;
                obj2 = objects[i852];
                if (obj2 instanceof Field) {
                }
                i22 = i10;
                i23 = i6;
                i25 = i83;
                str = stringInfo;
                i24 = (int) unsafe.objectFieldOffset(reflectField3);
                i26 = 0;
            } else {
                i21 = i9;
                int i86 = i6 + 1;
                Field reflectField4 = reflectField(cls, (String) objects[i6]);
                if (i76 == 9 || i76 == 17) {
                    i22 = i10;
                    objArr[((i67 / 3) * 2) + 1] = reflectField4.getType();
                } else {
                    if (i76 == 27 || i76 == 49) {
                        i22 = i10;
                        i29 = i6 + 2;
                        objArr[((i67 / 3) * 2) + 1] = objects[i86];
                    } else if (i76 == 12 || i76 == 30 || i76 == 44) {
                        i22 = i10;
                        if (rawMessageInfo.getSyntax() == ProtoSyntax.PROTO2 || (charAt24 & LEGACY_ENUM_IS_CLOSED_BIT) != 0) {
                            i29 = i6 + 2;
                            objArr[((i67 / 3) * 2) + 1] = objects[i86];
                        }
                    } else {
                        if (i76 == 50) {
                            int i87 = i64 + 1;
                            iArr[i64] = i67;
                            int i88 = (i67 / 3) * 2;
                            int i89 = i6 + 2;
                            objArr[i88] = objects[i86];
                            if ((charAt24 & LEGACY_ENUM_IS_CLOSED_BIT) != 0) {
                                i86 = i6 + 3;
                                objArr[i88 + 1] = objects[i89];
                                i64 = i87;
                            } else {
                                i64 = i87;
                                i86 = i89;
                            }
                        }
                        i22 = i10;
                    }
                    i86 = i29;
                }
                int objectFieldOffset = (int) unsafe.objectFieldOffset(reflectField4);
                if ((charAt24 & HAS_HAS_BIT) == 0 || i76 > 17) {
                    str = stringInfo;
                    i23 = i86;
                    i24 = 1048575;
                    i25 = i20;
                    i26 = 0;
                } else {
                    i25 = i20 + 1;
                    int charAt26 = stringInfo.charAt(i20);
                    if (charAt26 >= 55296) {
                        int i90 = charAt26 & 8191;
                        int i91 = 13;
                        while (true) {
                            i28 = i25 + 1;
                            charAt11 = stringInfo.charAt(i25);
                            if (charAt11 < 55296) {
                                break;
                            }
                            i90 |= (charAt11 & 8191) << i91;
                            i91 += 13;
                            i25 = i28;
                        }
                        charAt26 = i90 | (charAt11 << i91);
                        i25 = i28;
                    }
                    int i92 = (i7 * 2) + (charAt26 / 32);
                    Object obj3 = objects[i92];
                    if (obj3 instanceof Field) {
                        reflectField = (Field) obj3;
                    } else {
                        reflectField = reflectField(cls, (String) obj3);
                        objects[i92] = reflectField;
                    }
                    str = stringInfo;
                    i23 = i86;
                    i24 = (int) unsafe.objectFieldOffset(reflectField);
                    i26 = charAt26 % 32;
                }
                if (i76 >= 18 && i76 <= 49) {
                    iArr[i65] = objectFieldOffset;
                    i65++;
                }
                i27 = objectFieldOffset;
            }
            int i93 = i67 + 1;
            iArr2[i67] = charAt23;
            int i94 = i67 + 2;
            int i95 = i7;
            iArr2[i93] = i27 | (i76 << 20) | ((charAt24 & 256) != 0 ? REQUIRED_MASK : 0) | ((charAt24 & UTF8_CHECK_BIT) != 0 ? ENFORCE_UTF8_MASK : 0) | ((charAt24 & LEGACY_ENUM_IS_CLOSED_BIT) != 0 ? LEGACY_ENUM_IS_CLOSED_MASK : 0);
            i67 += 3;
            iArr2[i94] = i24 | (i26 << 20);
            i36 = i25;
            stringInfo = str;
            i6 = i23;
            length = i77;
            i10 = i22;
            i66 = i78;
            i7 = i95;
            i9 = i21;
            c5 = 55296;
        }
        return new MessageSchema<>(iArr2, objArr, i9, i10, rawMessageInfo.getDefaultInstance(), rawMessageInfo.getSyntax(), false, iArr, i8, i63, newInstanceSchema, listFieldSchema, unknownFieldSchema, extensionSchema, mapFieldSchema);
    }

    private int numberAt(int i5) {
        return this.buffer[i5];
    }

    private static long offset(int i5) {
        return i5 & 1048575;
    }

    private static <T> boolean oneofBooleanAt(T t5, long j5) {
        return ((Boolean) UnsafeUtil.getObject(t5, j5)).booleanValue();
    }

    private static <T> double oneofDoubleAt(T t5, long j5) {
        return ((Double) UnsafeUtil.getObject(t5, j5)).doubleValue();
    }

    private static <T> float oneofFloatAt(T t5, long j5) {
        return ((Float) UnsafeUtil.getObject(t5, j5)).floatValue();
    }

    private static <T> int oneofIntAt(T t5, long j5) {
        return ((Integer) UnsafeUtil.getObject(t5, j5)).intValue();
    }

    private static <T> long oneofLongAt(T t5, long j5) {
        return ((Long) UnsafeUtil.getObject(t5, j5)).longValue();
    }

    private int positionForFieldNumber(int i5) {
        if (i5 < this.minFieldNumber || i5 > this.maxFieldNumber) {
            return -1;
        }
        return slowPositionForFieldNumber(i5, 0);
    }

    private int presenceMaskAndOffsetAt(int i5) {
        return this.buffer[i5 + 2];
    }

    private <E> void readGroupList(Object obj, long j5, Reader reader, Schema<E> schema, ExtensionRegistryLite extensionRegistryLite) {
        reader.readGroupList(this.listFieldSchema.mutableListAt(obj, j5), schema, extensionRegistryLite);
    }

    private <E> void readMessageList(Object obj, int i5, Reader reader, Schema<E> schema, ExtensionRegistryLite extensionRegistryLite) {
        reader.readMessageList(this.listFieldSchema.mutableListAt(obj, offset(i5)), schema, extensionRegistryLite);
    }

    private void readString(Object obj, int i5, Reader reader) {
        if (isEnforceUtf8(i5)) {
            UnsafeUtil.putObject(obj, offset(i5), reader.readStringRequireUtf8());
        } else if (this.lite) {
            UnsafeUtil.putObject(obj, offset(i5), reader.readString());
        } else {
            UnsafeUtil.putObject(obj, offset(i5), reader.readBytes());
        }
    }

    private void readStringList(Object obj, int i5, Reader reader) {
        if (isEnforceUtf8(i5)) {
            reader.readStringListRequireUtf8(this.listFieldSchema.mutableListAt(obj, offset(i5)));
        } else {
            reader.readStringList(this.listFieldSchema.mutableListAt(obj, offset(i5)));
        }
    }

    private static Field reflectField(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            throw new RuntimeException("Field " + str + " for " + cls.getName() + " not found. Known fields are " + Arrays.toString(declaredFields));
        }
    }

    private void setFieldPresent(T t5, int i5) {
        int presenceMaskAndOffsetAt = presenceMaskAndOffsetAt(i5);
        long j5 = 1048575 & presenceMaskAndOffsetAt;
        if (j5 == 1048575) {
            return;
        }
        UnsafeUtil.putInt(t5, j5, (1 << (presenceMaskAndOffsetAt >>> 20)) | UnsafeUtil.getInt(t5, j5));
    }

    private void setOneofPresent(T t5, int i5, int i6) {
        UnsafeUtil.putInt(t5, presenceMaskAndOffsetAt(i6) & 1048575, i5);
    }

    private int slowPositionForFieldNumber(int i5, int i6) {
        int length = (this.buffer.length / 3) - 1;
        while (i6 <= length) {
            int i7 = (length + i6) >>> 1;
            int i8 = i7 * 3;
            int numberAt = numberAt(i8);
            if (i5 == numberAt) {
                return i8;
            }
            if (i5 < numberAt) {
                length = i7 - 1;
            } else {
                i6 = i7 + 1;
            }
        }
        return -1;
    }

    private void storeMessageField(T t5, int i5, Object obj) {
        UNSAFE.putObject(t5, offset(typeAndOffsetAt(i5)), obj);
        setFieldPresent(t5, i5);
    }

    private void storeOneofMessageField(T t5, int i5, int i6, Object obj) {
        UNSAFE.putObject(t5, offset(typeAndOffsetAt(i6)), obj);
        setOneofPresent(t5, i5, i6);
    }

    private static int type(int i5) {
        return (i5 & FIELD_TYPE_MASK) >>> 20;
    }

    private int typeAndOffsetAt(int i5) {
        return this.buffer[i5 + 1];
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:31:0x0095. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:221:0x0629  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0031  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void writeFieldsInAscendingOrder(T t5, Writer writer) {
        Map.Entry<?, ?> entry;
        Iterator<Map.Entry<?, Object>> it;
        int length;
        int i5;
        int i6;
        Map.Entry<?, ?> entry2;
        int i7;
        int i8;
        Map.Entry<?, ?> entry3;
        boolean z5;
        Map.Entry<?, ?> entry4;
        if (this.hasExtensions) {
            FieldSet<?> extensions = this.extensionSchema.getExtensions(t5);
            if (!extensions.isEmpty()) {
                Iterator<Map.Entry<?, Object>> it2 = extensions.iterator();
                entry = (Map.Entry) it2.next();
                it = it2;
                length = this.buffer.length;
                Unsafe unsafe = UNSAFE;
                int i9 = 1048575;
                int i10 = 1048575;
                int i11 = 0;
                i5 = 0;
                while (i5 < length) {
                    int typeAndOffsetAt = typeAndOffsetAt(i5);
                    int numberAt = numberAt(i5);
                    int type = type(typeAndOffsetAt);
                    if (type <= 17) {
                        int i12 = this.buffer[i5 + 2];
                        int i13 = i12 & i9;
                        if (i13 != i10) {
                            if (i13 == i9) {
                                entry4 = entry;
                                i11 = 0;
                            } else {
                                entry4 = entry;
                                i11 = unsafe.getInt(t5, i13);
                            }
                            i10 = i13;
                        } else {
                            entry4 = entry;
                        }
                        int i14 = 1 << (i12 >>> 20);
                        i6 = i10;
                        i7 = i14;
                        entry2 = entry4;
                    } else {
                        i6 = i10;
                        entry2 = entry;
                        i7 = 0;
                    }
                    int i15 = i11;
                    while (entry2 != null && this.extensionSchema.extensionNumber(entry2) <= numberAt) {
                        this.extensionSchema.serializeExtension(writer, entry2);
                        entry2 = it.hasNext() ? (Map.Entry) it.next() : null;
                    }
                    long offset = offset(typeAndOffsetAt);
                    switch (type) {
                        case 0:
                            i8 = length;
                            entry3 = entry2;
                            if (!isFieldPresent(t5, i5, i6, i15, i7)) {
                                break;
                            } else {
                                writer.writeDouble(numberAt, doubleAt(t5, offset));
                                break;
                            }
                        case 1:
                            i8 = length;
                            entry3 = entry2;
                            if (!isFieldPresent(t5, i5, i6, i15, i7)) {
                                break;
                            } else {
                                writer.writeFloat(numberAt, floatAt(t5, offset));
                                break;
                            }
                        case 2:
                            i8 = length;
                            entry3 = entry2;
                            if (!isFieldPresent(t5, i5, i6, i15, i7)) {
                                break;
                            } else {
                                writer.writeInt64(numberAt, unsafe.getLong(t5, offset));
                                break;
                            }
                        case 3:
                            i8 = length;
                            entry3 = entry2;
                            if (!isFieldPresent(t5, i5, i6, i15, i7)) {
                                break;
                            } else {
                                writer.writeUInt64(numberAt, unsafe.getLong(t5, offset));
                                break;
                            }
                        case 4:
                            i8 = length;
                            entry3 = entry2;
                            if (!isFieldPresent(t5, i5, i6, i15, i7)) {
                                break;
                            } else {
                                writer.writeInt32(numberAt, unsafe.getInt(t5, offset));
                                break;
                            }
                        case 5:
                            i8 = length;
                            entry3 = entry2;
                            if (!isFieldPresent(t5, i5, i6, i15, i7)) {
                                break;
                            } else {
                                writer.writeFixed64(numberAt, unsafe.getLong(t5, offset));
                                break;
                            }
                        case 6:
                            i8 = length;
                            entry3 = entry2;
                            if (!isFieldPresent(t5, i5, i6, i15, i7)) {
                                break;
                            } else {
                                writer.writeFixed32(numberAt, unsafe.getInt(t5, offset));
                                break;
                            }
                        case 7:
                            i8 = length;
                            entry3 = entry2;
                            if (!isFieldPresent(t5, i5, i6, i15, i7)) {
                                break;
                            } else {
                                writer.writeBool(numberAt, booleanAt(t5, offset));
                                break;
                            }
                        case 8:
                            i8 = length;
                            entry3 = entry2;
                            if (!isFieldPresent(t5, i5, i6, i15, i7)) {
                                break;
                            } else {
                                writeString(numberAt, unsafe.getObject(t5, offset), writer);
                                break;
                            }
                        case 9:
                            i8 = length;
                            entry3 = entry2;
                            if (!isFieldPresent(t5, i5, i6, i15, i7)) {
                                break;
                            } else {
                                writer.writeMessage(numberAt, unsafe.getObject(t5, offset), getMessageFieldSchema(i5));
                                break;
                            }
                        case 10:
                            i8 = length;
                            entry3 = entry2;
                            if (!isFieldPresent(t5, i5, i6, i15, i7)) {
                                break;
                            } else {
                                writer.writeBytes(numberAt, (ByteString) unsafe.getObject(t5, offset));
                                break;
                            }
                        case 11:
                            i8 = length;
                            entry3 = entry2;
                            if (!isFieldPresent(t5, i5, i6, i15, i7)) {
                                break;
                            } else {
                                writer.writeUInt32(numberAt, unsafe.getInt(t5, offset));
                                break;
                            }
                        case 12:
                            i8 = length;
                            entry3 = entry2;
                            if (!isFieldPresent(t5, i5, i6, i15, i7)) {
                                break;
                            } else {
                                writer.writeEnum(numberAt, unsafe.getInt(t5, offset));
                                break;
                            }
                        case 13:
                            i8 = length;
                            entry3 = entry2;
                            if (!isFieldPresent(t5, i5, i6, i15, i7)) {
                                break;
                            } else {
                                writer.writeSFixed32(numberAt, unsafe.getInt(t5, offset));
                                break;
                            }
                        case 14:
                            i8 = length;
                            entry3 = entry2;
                            if (!isFieldPresent(t5, i5, i6, i15, i7)) {
                                break;
                            } else {
                                writer.writeSFixed64(numberAt, unsafe.getLong(t5, offset));
                                break;
                            }
                        case 15:
                            i8 = length;
                            entry3 = entry2;
                            if (!isFieldPresent(t5, i5, i6, i15, i7)) {
                                break;
                            } else {
                                writer.writeSInt32(numberAt, unsafe.getInt(t5, offset));
                                break;
                            }
                        case 16:
                            i8 = length;
                            entry3 = entry2;
                            if (!isFieldPresent(t5, i5, i6, i15, i7)) {
                                break;
                            } else {
                                writer.writeSInt64(numberAt, unsafe.getLong(t5, offset));
                                break;
                            }
                        case 17:
                            entry3 = entry2;
                            i8 = length;
                            if (!isFieldPresent(t5, i5, i6, i15, i7)) {
                                break;
                            } else {
                                writer.writeGroup(numberAt, unsafe.getObject(t5, offset), getMessageFieldSchema(i5));
                                break;
                            }
                        case 18:
                            z5 = false;
                            SchemaUtil.writeDoubleList(numberAt(i5), (List) unsafe.getObject(t5, offset), writer, false);
                            i8 = length;
                            entry3 = entry2;
                            break;
                        case 19:
                            z5 = false;
                            SchemaUtil.writeFloatList(numberAt(i5), (List) unsafe.getObject(t5, offset), writer, false);
                            i8 = length;
                            entry3 = entry2;
                            break;
                        case 20:
                            z5 = false;
                            SchemaUtil.writeInt64List(numberAt(i5), (List) unsafe.getObject(t5, offset), writer, false);
                            i8 = length;
                            entry3 = entry2;
                            break;
                        case 21:
                            z5 = false;
                            SchemaUtil.writeUInt64List(numberAt(i5), (List) unsafe.getObject(t5, offset), writer, false);
                            i8 = length;
                            entry3 = entry2;
                            break;
                        case 22:
                            z5 = false;
                            SchemaUtil.writeInt32List(numberAt(i5), (List) unsafe.getObject(t5, offset), writer, false);
                            i8 = length;
                            entry3 = entry2;
                            break;
                        case R$styleable.Toolbar_titleMarginBottom /* 23 */:
                            z5 = false;
                            SchemaUtil.writeFixed64List(numberAt(i5), (List) unsafe.getObject(t5, offset), writer, false);
                            i8 = length;
                            entry3 = entry2;
                            break;
                        case R$styleable.Toolbar_titleMarginEnd /* 24 */:
                            z5 = false;
                            SchemaUtil.writeFixed32List(numberAt(i5), (List) unsafe.getObject(t5, offset), writer, false);
                            i8 = length;
                            entry3 = entry2;
                            break;
                        case 25:
                            z5 = false;
                            SchemaUtil.writeBoolList(numberAt(i5), (List) unsafe.getObject(t5, offset), writer, false);
                            i8 = length;
                            entry3 = entry2;
                            break;
                        case 26:
                            SchemaUtil.writeStringList(numberAt(i5), (List) unsafe.getObject(t5, offset), writer);
                            i8 = length;
                            entry3 = entry2;
                            break;
                        case 27:
                            SchemaUtil.writeMessageList(numberAt(i5), (List) unsafe.getObject(t5, offset), writer, getMessageFieldSchema(i5));
                            i8 = length;
                            entry3 = entry2;
                            break;
                        case 28:
                            SchemaUtil.writeBytesList(numberAt(i5), (List) unsafe.getObject(t5, offset), writer);
                            i8 = length;
                            entry3 = entry2;
                            break;
                        case R$styleable.Toolbar_titleTextColor /* 29 */:
                            z5 = false;
                            SchemaUtil.writeUInt32List(numberAt(i5), (List) unsafe.getObject(t5, offset), writer, false);
                            i8 = length;
                            entry3 = entry2;
                            break;
                        case 30:
                            z5 = false;
                            SchemaUtil.writeEnumList(numberAt(i5), (List) unsafe.getObject(t5, offset), writer, false);
                            i8 = length;
                            entry3 = entry2;
                            break;
                        case 31:
                            z5 = false;
                            SchemaUtil.writeSFixed32List(numberAt(i5), (List) unsafe.getObject(t5, offset), writer, false);
                            i8 = length;
                            entry3 = entry2;
                            break;
                        case 32:
                            z5 = false;
                            SchemaUtil.writeSFixed64List(numberAt(i5), (List) unsafe.getObject(t5, offset), writer, false);
                            i8 = length;
                            entry3 = entry2;
                            break;
                        case 33:
                            z5 = false;
                            SchemaUtil.writeSInt32List(numberAt(i5), (List) unsafe.getObject(t5, offset), writer, false);
                            i8 = length;
                            entry3 = entry2;
                            break;
                        case 34:
                            z5 = false;
                            SchemaUtil.writeSInt64List(numberAt(i5), (List) unsafe.getObject(t5, offset), writer, false);
                            i8 = length;
                            entry3 = entry2;
                            break;
                        case 35:
                            SchemaUtil.writeDoubleList(numberAt(i5), (List) unsafe.getObject(t5, offset), writer, true);
                            i8 = length;
                            entry3 = entry2;
                            break;
                        case 36:
                            SchemaUtil.writeFloatList(numberAt(i5), (List) unsafe.getObject(t5, offset), writer, true);
                            i8 = length;
                            entry3 = entry2;
                            break;
                        case 37:
                            SchemaUtil.writeInt64List(numberAt(i5), (List) unsafe.getObject(t5, offset), writer, true);
                            i8 = length;
                            entry3 = entry2;
                            break;
                        case 38:
                            SchemaUtil.writeUInt64List(numberAt(i5), (List) unsafe.getObject(t5, offset), writer, true);
                            i8 = length;
                            entry3 = entry2;
                            break;
                        case 39:
                            SchemaUtil.writeInt32List(numberAt(i5), (List) unsafe.getObject(t5, offset), writer, true);
                            i8 = length;
                            entry3 = entry2;
                            break;
                        case 40:
                            SchemaUtil.writeFixed64List(numberAt(i5), (List) unsafe.getObject(t5, offset), writer, true);
                            i8 = length;
                            entry3 = entry2;
                            break;
                        case 41:
                            SchemaUtil.writeFixed32List(numberAt(i5), (List) unsafe.getObject(t5, offset), writer, true);
                            i8 = length;
                            entry3 = entry2;
                            break;
                        case 42:
                            SchemaUtil.writeBoolList(numberAt(i5), (List) unsafe.getObject(t5, offset), writer, true);
                            i8 = length;
                            entry3 = entry2;
                            break;
                        case 43:
                            SchemaUtil.writeUInt32List(numberAt(i5), (List) unsafe.getObject(t5, offset), writer, true);
                            i8 = length;
                            entry3 = entry2;
                            break;
                        case 44:
                            SchemaUtil.writeEnumList(numberAt(i5), (List) unsafe.getObject(t5, offset), writer, true);
                            i8 = length;
                            entry3 = entry2;
                            break;
                        case 45:
                            SchemaUtil.writeSFixed32List(numberAt(i5), (List) unsafe.getObject(t5, offset), writer, true);
                            i8 = length;
                            entry3 = entry2;
                            break;
                        case 46:
                            SchemaUtil.writeSFixed64List(numberAt(i5), (List) unsafe.getObject(t5, offset), writer, true);
                            i8 = length;
                            entry3 = entry2;
                            break;
                        case 47:
                            SchemaUtil.writeSInt32List(numberAt(i5), (List) unsafe.getObject(t5, offset), writer, true);
                            i8 = length;
                            entry3 = entry2;
                            break;
                        case 48:
                            SchemaUtil.writeSInt64List(numberAt(i5), (List) unsafe.getObject(t5, offset), writer, true);
                            i8 = length;
                            entry3 = entry2;
                            break;
                        case 49:
                            SchemaUtil.writeGroupList(numberAt(i5), (List) unsafe.getObject(t5, offset), writer, getMessageFieldSchema(i5));
                            i8 = length;
                            entry3 = entry2;
                            break;
                        case 50:
                            writeMapHelper(writer, numberAt, unsafe.getObject(t5, offset), i5);
                            i8 = length;
                            entry3 = entry2;
                            break;
                        case 51:
                            if (isOneofPresent(t5, numberAt, i5)) {
                                writer.writeDouble(numberAt, oneofDoubleAt(t5, offset));
                            }
                            i8 = length;
                            entry3 = entry2;
                            break;
                        case 52:
                            if (isOneofPresent(t5, numberAt, i5)) {
                                writer.writeFloat(numberAt, oneofFloatAt(t5, offset));
                            }
                            i8 = length;
                            entry3 = entry2;
                            break;
                        case 53:
                            if (isOneofPresent(t5, numberAt, i5)) {
                                writer.writeInt64(numberAt, oneofLongAt(t5, offset));
                            }
                            i8 = length;
                            entry3 = entry2;
                            break;
                        case 54:
                            if (isOneofPresent(t5, numberAt, i5)) {
                                writer.writeUInt64(numberAt, oneofLongAt(t5, offset));
                            }
                            i8 = length;
                            entry3 = entry2;
                            break;
                        case 55:
                            if (isOneofPresent(t5, numberAt, i5)) {
                                writer.writeInt32(numberAt, oneofIntAt(t5, offset));
                            }
                            i8 = length;
                            entry3 = entry2;
                            break;
                        case 56:
                            if (isOneofPresent(t5, numberAt, i5)) {
                                writer.writeFixed64(numberAt, oneofLongAt(t5, offset));
                            }
                            i8 = length;
                            entry3 = entry2;
                            break;
                        case 57:
                            if (isOneofPresent(t5, numberAt, i5)) {
                                writer.writeFixed32(numberAt, oneofIntAt(t5, offset));
                            }
                            i8 = length;
                            entry3 = entry2;
                            break;
                        case 58:
                            if (isOneofPresent(t5, numberAt, i5)) {
                                writer.writeBool(numberAt, oneofBooleanAt(t5, offset));
                            }
                            i8 = length;
                            entry3 = entry2;
                            break;
                        case 59:
                            if (isOneofPresent(t5, numberAt, i5)) {
                                writeString(numberAt, unsafe.getObject(t5, offset), writer);
                            }
                            i8 = length;
                            entry3 = entry2;
                            break;
                        case 60:
                            if (isOneofPresent(t5, numberAt, i5)) {
                                writer.writeMessage(numberAt, unsafe.getObject(t5, offset), getMessageFieldSchema(i5));
                            }
                            i8 = length;
                            entry3 = entry2;
                            break;
                        case 61:
                            if (isOneofPresent(t5, numberAt, i5)) {
                                writer.writeBytes(numberAt, (ByteString) unsafe.getObject(t5, offset));
                            }
                            i8 = length;
                            entry3 = entry2;
                            break;
                        case 62:
                            if (isOneofPresent(t5, numberAt, i5)) {
                                writer.writeUInt32(numberAt, oneofIntAt(t5, offset));
                            }
                            i8 = length;
                            entry3 = entry2;
                            break;
                        case Function.ALT_CONVENTION /* 63 */:
                            if (isOneofPresent(t5, numberAt, i5)) {
                                writer.writeEnum(numberAt, oneofIntAt(t5, offset));
                            }
                            i8 = length;
                            entry3 = entry2;
                            break;
                        case Function.THROW_LAST_ERROR /* 64 */:
                            if (isOneofPresent(t5, numberAt, i5)) {
                                writer.writeSFixed32(numberAt, oneofIntAt(t5, offset));
                            }
                            i8 = length;
                            entry3 = entry2;
                            break;
                        case 65:
                            if (isOneofPresent(t5, numberAt, i5)) {
                                writer.writeSFixed64(numberAt, oneofLongAt(t5, offset));
                            }
                            i8 = length;
                            entry3 = entry2;
                            break;
                        case 66:
                            if (isOneofPresent(t5, numberAt, i5)) {
                                writer.writeSInt32(numberAt, oneofIntAt(t5, offset));
                            }
                            i8 = length;
                            entry3 = entry2;
                            break;
                        case 67:
                            if (isOneofPresent(t5, numberAt, i5)) {
                                writer.writeSInt64(numberAt, oneofLongAt(t5, offset));
                            }
                            i8 = length;
                            entry3 = entry2;
                            break;
                        case 68:
                            if (isOneofPresent(t5, numberAt, i5)) {
                                writer.writeGroup(numberAt, unsafe.getObject(t5, offset), getMessageFieldSchema(i5));
                            }
                            i8 = length;
                            entry3 = entry2;
                            break;
                        default:
                            i8 = length;
                            entry3 = entry2;
                            break;
                    }
                    i5 += 3;
                    i10 = i6;
                    entry = entry3;
                    i11 = i15;
                    length = i8;
                    i9 = 1048575;
                }
                while (entry != null) {
                    this.extensionSchema.serializeExtension(writer, entry);
                    entry = it.hasNext() ? (Map.Entry) it.next() : null;
                }
                writeUnknownInMessageTo(this.unknownFieldSchema, t5, writer);
            }
        }
        entry = null;
        it = null;
        length = this.buffer.length;
        Unsafe unsafe2 = UNSAFE;
        int i92 = 1048575;
        int i102 = 1048575;
        int i112 = 0;
        i5 = 0;
        while (i5 < length) {
        }
        while (entry != null) {
        }
        writeUnknownInMessageTo(this.unknownFieldSchema, t5, writer);
    }

    /* JADX WARN: Removed duplicated region for block: B:275:0x058e  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void writeFieldsInDescendingOrder(T t5, Writer writer) {
        Iterator<Map.Entry<?, Object>> it;
        Map.Entry<?, ?> entry;
        int length;
        writeUnknownInMessageTo(this.unknownFieldSchema, t5, writer);
        if (this.hasExtensions) {
            FieldSet<?> extensions = this.extensionSchema.getExtensions(t5);
            if (!extensions.isEmpty()) {
                it = extensions.descendingIterator();
                entry = (Map.Entry) it.next();
                for (length = this.buffer.length - 3; length >= 0; length -= 3) {
                    int typeAndOffsetAt = typeAndOffsetAt(length);
                    int numberAt = numberAt(length);
                    while (entry != null && this.extensionSchema.extensionNumber(entry) > numberAt) {
                        this.extensionSchema.serializeExtension(writer, entry);
                        entry = it.hasNext() ? (Map.Entry) it.next() : null;
                    }
                    switch (type(typeAndOffsetAt)) {
                        case 0:
                            if (isFieldPresent(t5, length)) {
                                writer.writeDouble(numberAt, doubleAt(t5, offset(typeAndOffsetAt)));
                                break;
                            } else {
                                break;
                            }
                        case 1:
                            if (isFieldPresent(t5, length)) {
                                writer.writeFloat(numberAt, floatAt(t5, offset(typeAndOffsetAt)));
                                break;
                            } else {
                                break;
                            }
                        case 2:
                            if (isFieldPresent(t5, length)) {
                                writer.writeInt64(numberAt, longAt(t5, offset(typeAndOffsetAt)));
                                break;
                            } else {
                                break;
                            }
                        case 3:
                            if (isFieldPresent(t5, length)) {
                                writer.writeUInt64(numberAt, longAt(t5, offset(typeAndOffsetAt)));
                                break;
                            } else {
                                break;
                            }
                        case 4:
                            if (isFieldPresent(t5, length)) {
                                writer.writeInt32(numberAt, intAt(t5, offset(typeAndOffsetAt)));
                                break;
                            } else {
                                break;
                            }
                        case 5:
                            if (isFieldPresent(t5, length)) {
                                writer.writeFixed64(numberAt, longAt(t5, offset(typeAndOffsetAt)));
                                break;
                            } else {
                                break;
                            }
                        case 6:
                            if (isFieldPresent(t5, length)) {
                                writer.writeFixed32(numberAt, intAt(t5, offset(typeAndOffsetAt)));
                                break;
                            } else {
                                break;
                            }
                        case 7:
                            if (isFieldPresent(t5, length)) {
                                writer.writeBool(numberAt, booleanAt(t5, offset(typeAndOffsetAt)));
                                break;
                            } else {
                                break;
                            }
                        case 8:
                            if (isFieldPresent(t5, length)) {
                                writeString(numberAt, UnsafeUtil.getObject(t5, offset(typeAndOffsetAt)), writer);
                                break;
                            } else {
                                break;
                            }
                        case 9:
                            if (isFieldPresent(t5, length)) {
                                writer.writeMessage(numberAt, UnsafeUtil.getObject(t5, offset(typeAndOffsetAt)), getMessageFieldSchema(length));
                                break;
                            } else {
                                break;
                            }
                        case 10:
                            if (isFieldPresent(t5, length)) {
                                writer.writeBytes(numberAt, (ByteString) UnsafeUtil.getObject(t5, offset(typeAndOffsetAt)));
                                break;
                            } else {
                                break;
                            }
                        case 11:
                            if (isFieldPresent(t5, length)) {
                                writer.writeUInt32(numberAt, intAt(t5, offset(typeAndOffsetAt)));
                                break;
                            } else {
                                break;
                            }
                        case 12:
                            if (isFieldPresent(t5, length)) {
                                writer.writeEnum(numberAt, intAt(t5, offset(typeAndOffsetAt)));
                                break;
                            } else {
                                break;
                            }
                        case 13:
                            if (isFieldPresent(t5, length)) {
                                writer.writeSFixed32(numberAt, intAt(t5, offset(typeAndOffsetAt)));
                                break;
                            } else {
                                break;
                            }
                        case 14:
                            if (isFieldPresent(t5, length)) {
                                writer.writeSFixed64(numberAt, longAt(t5, offset(typeAndOffsetAt)));
                                break;
                            } else {
                                break;
                            }
                        case 15:
                            if (isFieldPresent(t5, length)) {
                                writer.writeSInt32(numberAt, intAt(t5, offset(typeAndOffsetAt)));
                                break;
                            } else {
                                break;
                            }
                        case 16:
                            if (isFieldPresent(t5, length)) {
                                writer.writeSInt64(numberAt, longAt(t5, offset(typeAndOffsetAt)));
                                break;
                            } else {
                                break;
                            }
                        case 17:
                            if (isFieldPresent(t5, length)) {
                                writer.writeGroup(numberAt, UnsafeUtil.getObject(t5, offset(typeAndOffsetAt)), getMessageFieldSchema(length));
                                break;
                            } else {
                                break;
                            }
                        case 18:
                            SchemaUtil.writeDoubleList(numberAt(length), (List) UnsafeUtil.getObject(t5, offset(typeAndOffsetAt)), writer, false);
                            break;
                        case 19:
                            SchemaUtil.writeFloatList(numberAt(length), (List) UnsafeUtil.getObject(t5, offset(typeAndOffsetAt)), writer, false);
                            break;
                        case 20:
                            SchemaUtil.writeInt64List(numberAt(length), (List) UnsafeUtil.getObject(t5, offset(typeAndOffsetAt)), writer, false);
                            break;
                        case 21:
                            SchemaUtil.writeUInt64List(numberAt(length), (List) UnsafeUtil.getObject(t5, offset(typeAndOffsetAt)), writer, false);
                            break;
                        case 22:
                            SchemaUtil.writeInt32List(numberAt(length), (List) UnsafeUtil.getObject(t5, offset(typeAndOffsetAt)), writer, false);
                            break;
                        case R$styleable.Toolbar_titleMarginBottom /* 23 */:
                            SchemaUtil.writeFixed64List(numberAt(length), (List) UnsafeUtil.getObject(t5, offset(typeAndOffsetAt)), writer, false);
                            break;
                        case R$styleable.Toolbar_titleMarginEnd /* 24 */:
                            SchemaUtil.writeFixed32List(numberAt(length), (List) UnsafeUtil.getObject(t5, offset(typeAndOffsetAt)), writer, false);
                            break;
                        case 25:
                            SchemaUtil.writeBoolList(numberAt(length), (List) UnsafeUtil.getObject(t5, offset(typeAndOffsetAt)), writer, false);
                            break;
                        case 26:
                            SchemaUtil.writeStringList(numberAt(length), (List) UnsafeUtil.getObject(t5, offset(typeAndOffsetAt)), writer);
                            break;
                        case 27:
                            SchemaUtil.writeMessageList(numberAt(length), (List) UnsafeUtil.getObject(t5, offset(typeAndOffsetAt)), writer, getMessageFieldSchema(length));
                            break;
                        case 28:
                            SchemaUtil.writeBytesList(numberAt(length), (List) UnsafeUtil.getObject(t5, offset(typeAndOffsetAt)), writer);
                            break;
                        case R$styleable.Toolbar_titleTextColor /* 29 */:
                            SchemaUtil.writeUInt32List(numberAt(length), (List) UnsafeUtil.getObject(t5, offset(typeAndOffsetAt)), writer, false);
                            break;
                        case 30:
                            SchemaUtil.writeEnumList(numberAt(length), (List) UnsafeUtil.getObject(t5, offset(typeAndOffsetAt)), writer, false);
                            break;
                        case 31:
                            SchemaUtil.writeSFixed32List(numberAt(length), (List) UnsafeUtil.getObject(t5, offset(typeAndOffsetAt)), writer, false);
                            break;
                        case 32:
                            SchemaUtil.writeSFixed64List(numberAt(length), (List) UnsafeUtil.getObject(t5, offset(typeAndOffsetAt)), writer, false);
                            break;
                        case 33:
                            SchemaUtil.writeSInt32List(numberAt(length), (List) UnsafeUtil.getObject(t5, offset(typeAndOffsetAt)), writer, false);
                            break;
                        case 34:
                            SchemaUtil.writeSInt64List(numberAt(length), (List) UnsafeUtil.getObject(t5, offset(typeAndOffsetAt)), writer, false);
                            break;
                        case 35:
                            SchemaUtil.writeDoubleList(numberAt(length), (List) UnsafeUtil.getObject(t5, offset(typeAndOffsetAt)), writer, true);
                            break;
                        case 36:
                            SchemaUtil.writeFloatList(numberAt(length), (List) UnsafeUtil.getObject(t5, offset(typeAndOffsetAt)), writer, true);
                            break;
                        case 37:
                            SchemaUtil.writeInt64List(numberAt(length), (List) UnsafeUtil.getObject(t5, offset(typeAndOffsetAt)), writer, true);
                            break;
                        case 38:
                            SchemaUtil.writeUInt64List(numberAt(length), (List) UnsafeUtil.getObject(t5, offset(typeAndOffsetAt)), writer, true);
                            break;
                        case 39:
                            SchemaUtil.writeInt32List(numberAt(length), (List) UnsafeUtil.getObject(t5, offset(typeAndOffsetAt)), writer, true);
                            break;
                        case 40:
                            SchemaUtil.writeFixed64List(numberAt(length), (List) UnsafeUtil.getObject(t5, offset(typeAndOffsetAt)), writer, true);
                            break;
                        case 41:
                            SchemaUtil.writeFixed32List(numberAt(length), (List) UnsafeUtil.getObject(t5, offset(typeAndOffsetAt)), writer, true);
                            break;
                        case 42:
                            SchemaUtil.writeBoolList(numberAt(length), (List) UnsafeUtil.getObject(t5, offset(typeAndOffsetAt)), writer, true);
                            break;
                        case 43:
                            SchemaUtil.writeUInt32List(numberAt(length), (List) UnsafeUtil.getObject(t5, offset(typeAndOffsetAt)), writer, true);
                            break;
                        case 44:
                            SchemaUtil.writeEnumList(numberAt(length), (List) UnsafeUtil.getObject(t5, offset(typeAndOffsetAt)), writer, true);
                            break;
                        case 45:
                            SchemaUtil.writeSFixed32List(numberAt(length), (List) UnsafeUtil.getObject(t5, offset(typeAndOffsetAt)), writer, true);
                            break;
                        case 46:
                            SchemaUtil.writeSFixed64List(numberAt(length), (List) UnsafeUtil.getObject(t5, offset(typeAndOffsetAt)), writer, true);
                            break;
                        case 47:
                            SchemaUtil.writeSInt32List(numberAt(length), (List) UnsafeUtil.getObject(t5, offset(typeAndOffsetAt)), writer, true);
                            break;
                        case 48:
                            SchemaUtil.writeSInt64List(numberAt(length), (List) UnsafeUtil.getObject(t5, offset(typeAndOffsetAt)), writer, true);
                            break;
                        case 49:
                            SchemaUtil.writeGroupList(numberAt(length), (List) UnsafeUtil.getObject(t5, offset(typeAndOffsetAt)), writer, getMessageFieldSchema(length));
                            break;
                        case 50:
                            writeMapHelper(writer, numberAt, UnsafeUtil.getObject(t5, offset(typeAndOffsetAt)), length);
                            break;
                        case 51:
                            if (isOneofPresent(t5, numberAt, length)) {
                                writer.writeDouble(numberAt, oneofDoubleAt(t5, offset(typeAndOffsetAt)));
                                break;
                            } else {
                                break;
                            }
                        case 52:
                            if (isOneofPresent(t5, numberAt, length)) {
                                writer.writeFloat(numberAt, oneofFloatAt(t5, offset(typeAndOffsetAt)));
                                break;
                            } else {
                                break;
                            }
                        case 53:
                            if (isOneofPresent(t5, numberAt, length)) {
                                writer.writeInt64(numberAt, oneofLongAt(t5, offset(typeAndOffsetAt)));
                                break;
                            } else {
                                break;
                            }
                        case 54:
                            if (isOneofPresent(t5, numberAt, length)) {
                                writer.writeUInt64(numberAt, oneofLongAt(t5, offset(typeAndOffsetAt)));
                                break;
                            } else {
                                break;
                            }
                        case 55:
                            if (isOneofPresent(t5, numberAt, length)) {
                                writer.writeInt32(numberAt, oneofIntAt(t5, offset(typeAndOffsetAt)));
                                break;
                            } else {
                                break;
                            }
                        case 56:
                            if (isOneofPresent(t5, numberAt, length)) {
                                writer.writeFixed64(numberAt, oneofLongAt(t5, offset(typeAndOffsetAt)));
                                break;
                            } else {
                                break;
                            }
                        case 57:
                            if (isOneofPresent(t5, numberAt, length)) {
                                writer.writeFixed32(numberAt, oneofIntAt(t5, offset(typeAndOffsetAt)));
                                break;
                            } else {
                                break;
                            }
                        case 58:
                            if (isOneofPresent(t5, numberAt, length)) {
                                writer.writeBool(numberAt, oneofBooleanAt(t5, offset(typeAndOffsetAt)));
                                break;
                            } else {
                                break;
                            }
                        case 59:
                            if (isOneofPresent(t5, numberAt, length)) {
                                writeString(numberAt, UnsafeUtil.getObject(t5, offset(typeAndOffsetAt)), writer);
                                break;
                            } else {
                                break;
                            }
                        case 60:
                            if (isOneofPresent(t5, numberAt, length)) {
                                writer.writeMessage(numberAt, UnsafeUtil.getObject(t5, offset(typeAndOffsetAt)), getMessageFieldSchema(length));
                                break;
                            } else {
                                break;
                            }
                        case 61:
                            if (isOneofPresent(t5, numberAt, length)) {
                                writer.writeBytes(numberAt, (ByteString) UnsafeUtil.getObject(t5, offset(typeAndOffsetAt)));
                                break;
                            } else {
                                break;
                            }
                        case 62:
                            if (isOneofPresent(t5, numberAt, length)) {
                                writer.writeUInt32(numberAt, oneofIntAt(t5, offset(typeAndOffsetAt)));
                                break;
                            } else {
                                break;
                            }
                        case Function.ALT_CONVENTION /* 63 */:
                            if (isOneofPresent(t5, numberAt, length)) {
                                writer.writeEnum(numberAt, oneofIntAt(t5, offset(typeAndOffsetAt)));
                                break;
                            } else {
                                break;
                            }
                        case Function.THROW_LAST_ERROR /* 64 */:
                            if (isOneofPresent(t5, numberAt, length)) {
                                writer.writeSFixed32(numberAt, oneofIntAt(t5, offset(typeAndOffsetAt)));
                                break;
                            } else {
                                break;
                            }
                        case 65:
                            if (isOneofPresent(t5, numberAt, length)) {
                                writer.writeSFixed64(numberAt, oneofLongAt(t5, offset(typeAndOffsetAt)));
                                break;
                            } else {
                                break;
                            }
                        case 66:
                            if (isOneofPresent(t5, numberAt, length)) {
                                writer.writeSInt32(numberAt, oneofIntAt(t5, offset(typeAndOffsetAt)));
                                break;
                            } else {
                                break;
                            }
                        case 67:
                            if (isOneofPresent(t5, numberAt, length)) {
                                writer.writeSInt64(numberAt, oneofLongAt(t5, offset(typeAndOffsetAt)));
                                break;
                            } else {
                                break;
                            }
                        case 68:
                            if (isOneofPresent(t5, numberAt, length)) {
                                writer.writeGroup(numberAt, UnsafeUtil.getObject(t5, offset(typeAndOffsetAt)), getMessageFieldSchema(length));
                                break;
                            } else {
                                break;
                            }
                    }
                }
                while (entry != null) {
                    this.extensionSchema.serializeExtension(writer, entry);
                    entry = it.hasNext() ? (Map.Entry) it.next() : null;
                }
            }
        }
        it = null;
        entry = null;
        while (length >= 0) {
        }
        while (entry != null) {
        }
    }

    private <K, V> void writeMapHelper(Writer writer, int i5, Object obj, int i6) {
        if (obj != null) {
            writer.writeMap(i5, this.mapFieldSchema.forMapMetadata(getMapFieldDefaultEntry(i6)), this.mapFieldSchema.forMapData(obj));
        }
    }

    private void writeString(int i5, Object obj, Writer writer) {
        if (obj instanceof String) {
            writer.writeString(i5, (String) obj);
        } else {
            writer.writeBytes(i5, (ByteString) obj);
        }
    }

    private <UT, UB> void writeUnknownInMessageTo(UnknownFieldSchema<UT, UB> unknownFieldSchema, T t5, Writer writer) {
        unknownFieldSchema.writeTo(unknownFieldSchema.getFromMessage(t5), writer);
    }

    @Override // androidx.datastore.preferences.protobuf.Schema
    public boolean equals(T t5, T t6) {
        int length = this.buffer.length;
        for (int i5 = 0; i5 < length; i5 += 3) {
            if (!equals(t5, t6, i5)) {
                return false;
            }
        }
        if (!this.unknownFieldSchema.getFromMessage(t5).equals(this.unknownFieldSchema.getFromMessage(t6))) {
            return false;
        }
        if (this.hasExtensions) {
            return this.extensionSchema.getExtensions(t5).equals(this.extensionSchema.getExtensions(t6));
        }
        return true;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:17:0x0060. Please report as an issue. */
    @Override // androidx.datastore.preferences.protobuf.Schema
    public int getSerializedSize(T t5) {
        int i5;
        int i6;
        int i7;
        int computeDoubleSize;
        int computeBoolSize;
        int computeSFixed32Size;
        boolean z5;
        int computeSizeFixed32List;
        int computeSizeFixed64ListNoTag;
        int computeTagSize;
        int computeUInt32SizeNoTag;
        Unsafe unsafe = UNSAFE;
        int i8 = 1048575;
        int i9 = 1048575;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        while (i11 < this.buffer.length) {
            int typeAndOffsetAt = typeAndOffsetAt(i11);
            int type = type(typeAndOffsetAt);
            int numberAt = numberAt(i11);
            int i13 = this.buffer[i11 + 2];
            int i14 = i13 & i8;
            if (type <= 17) {
                if (i14 != i9) {
                    i10 = i14 == i8 ? 0 : unsafe.getInt(t5, i14);
                    i9 = i14;
                }
                i5 = i9;
                i6 = i10;
                i7 = 1 << (i13 >>> 20);
            } else {
                i5 = i9;
                i6 = i10;
                i7 = 0;
            }
            long offset = offset(typeAndOffsetAt);
            if (type < FieldType.DOUBLE_LIST_PACKED.id() || type > FieldType.SINT64_LIST_PACKED.id()) {
                i14 = 0;
            }
            switch (type) {
                case 0:
                    if (!isFieldPresent(t5, i11, i5, i6, i7)) {
                        break;
                    } else {
                        computeDoubleSize = CodedOutputStream.computeDoubleSize(numberAt, 0.0d);
                        i12 += computeDoubleSize;
                        break;
                    }
                case 1:
                    if (!isFieldPresent(t5, i11, i5, i6, i7)) {
                        break;
                    } else {
                        computeDoubleSize = CodedOutputStream.computeFloatSize(numberAt, 0.0f);
                        i12 += computeDoubleSize;
                        break;
                    }
                case 2:
                    if (!isFieldPresent(t5, i11, i5, i6, i7)) {
                        break;
                    } else {
                        computeDoubleSize = CodedOutputStream.computeInt64Size(numberAt, unsafe.getLong(t5, offset));
                        i12 += computeDoubleSize;
                        break;
                    }
                case 3:
                    if (!isFieldPresent(t5, i11, i5, i6, i7)) {
                        break;
                    } else {
                        computeDoubleSize = CodedOutputStream.computeUInt64Size(numberAt, unsafe.getLong(t5, offset));
                        i12 += computeDoubleSize;
                        break;
                    }
                case 4:
                    if (!isFieldPresent(t5, i11, i5, i6, i7)) {
                        break;
                    } else {
                        computeDoubleSize = CodedOutputStream.computeInt32Size(numberAt, unsafe.getInt(t5, offset));
                        i12 += computeDoubleSize;
                        break;
                    }
                case 5:
                    if (!isFieldPresent(t5, i11, i5, i6, i7)) {
                        break;
                    } else {
                        computeDoubleSize = CodedOutputStream.computeFixed64Size(numberAt, 0L);
                        i12 += computeDoubleSize;
                        break;
                    }
                case 6:
                    if (isFieldPresent(t5, i11, i5, i6, i7)) {
                        computeDoubleSize = CodedOutputStream.computeFixed32Size(numberAt, 0);
                        i12 += computeDoubleSize;
                        break;
                    }
                    break;
                case 7:
                    if (isFieldPresent(t5, i11, i5, i6, i7)) {
                        computeBoolSize = CodedOutputStream.computeBoolSize(numberAt, true);
                        i12 += computeBoolSize;
                    }
                    break;
                case 8:
                    if (isFieldPresent(t5, i11, i5, i6, i7)) {
                        Object object = unsafe.getObject(t5, offset);
                        computeBoolSize = object instanceof ByteString ? CodedOutputStream.computeBytesSize(numberAt, (ByteString) object) : CodedOutputStream.computeStringSize(numberAt, (String) object);
                        i12 += computeBoolSize;
                    }
                    break;
                case 9:
                    if (isFieldPresent(t5, i11, i5, i6, i7)) {
                        computeBoolSize = SchemaUtil.computeSizeMessage(numberAt, unsafe.getObject(t5, offset), getMessageFieldSchema(i11));
                        i12 += computeBoolSize;
                    }
                    break;
                case 10:
                    if (isFieldPresent(t5, i11, i5, i6, i7)) {
                        computeBoolSize = CodedOutputStream.computeBytesSize(numberAt, (ByteString) unsafe.getObject(t5, offset));
                        i12 += computeBoolSize;
                    }
                    break;
                case 11:
                    if (isFieldPresent(t5, i11, i5, i6, i7)) {
                        computeBoolSize = CodedOutputStream.computeUInt32Size(numberAt, unsafe.getInt(t5, offset));
                        i12 += computeBoolSize;
                    }
                    break;
                case 12:
                    if (isFieldPresent(t5, i11, i5, i6, i7)) {
                        computeBoolSize = CodedOutputStream.computeEnumSize(numberAt, unsafe.getInt(t5, offset));
                        i12 += computeBoolSize;
                    }
                    break;
                case 13:
                    if (isFieldPresent(t5, i11, i5, i6, i7)) {
                        computeSFixed32Size = CodedOutputStream.computeSFixed32Size(numberAt, 0);
                        i12 += computeSFixed32Size;
                    }
                    break;
                case 14:
                    if (isFieldPresent(t5, i11, i5, i6, i7)) {
                        computeBoolSize = CodedOutputStream.computeSFixed64Size(numberAt, 0L);
                        i12 += computeBoolSize;
                    }
                    break;
                case 15:
                    if (isFieldPresent(t5, i11, i5, i6, i7)) {
                        computeBoolSize = CodedOutputStream.computeSInt32Size(numberAt, unsafe.getInt(t5, offset));
                        i12 += computeBoolSize;
                    }
                    break;
                case 16:
                    if (isFieldPresent(t5, i11, i5, i6, i7)) {
                        computeBoolSize = CodedOutputStream.computeSInt64Size(numberAt, unsafe.getLong(t5, offset));
                        i12 += computeBoolSize;
                    }
                    break;
                case 17:
                    if (isFieldPresent(t5, i11, i5, i6, i7)) {
                        computeBoolSize = CodedOutputStream.computeGroupSize(numberAt, (MessageLite) unsafe.getObject(t5, offset), getMessageFieldSchema(i11));
                        i12 += computeBoolSize;
                    }
                    break;
                case 18:
                    computeBoolSize = SchemaUtil.computeSizeFixed64List(numberAt, (List) unsafe.getObject(t5, offset), false);
                    i12 += computeBoolSize;
                    break;
                case 19:
                    z5 = false;
                    computeSizeFixed32List = SchemaUtil.computeSizeFixed32List(numberAt, (List) unsafe.getObject(t5, offset), false);
                    i12 += computeSizeFixed32List;
                    break;
                case 20:
                    z5 = false;
                    computeSizeFixed32List = SchemaUtil.computeSizeInt64List(numberAt, (List) unsafe.getObject(t5, offset), false);
                    i12 += computeSizeFixed32List;
                    break;
                case 21:
                    z5 = false;
                    computeSizeFixed32List = SchemaUtil.computeSizeUInt64List(numberAt, (List) unsafe.getObject(t5, offset), false);
                    i12 += computeSizeFixed32List;
                    break;
                case 22:
                    z5 = false;
                    computeSizeFixed32List = SchemaUtil.computeSizeInt32List(numberAt, (List) unsafe.getObject(t5, offset), false);
                    i12 += computeSizeFixed32List;
                    break;
                case R$styleable.Toolbar_titleMarginBottom /* 23 */:
                    z5 = false;
                    computeSizeFixed32List = SchemaUtil.computeSizeFixed64List(numberAt, (List) unsafe.getObject(t5, offset), false);
                    i12 += computeSizeFixed32List;
                    break;
                case R$styleable.Toolbar_titleMarginEnd /* 24 */:
                    z5 = false;
                    computeSizeFixed32List = SchemaUtil.computeSizeFixed32List(numberAt, (List) unsafe.getObject(t5, offset), false);
                    i12 += computeSizeFixed32List;
                    break;
                case 25:
                    z5 = false;
                    computeSizeFixed32List = SchemaUtil.computeSizeBoolList(numberAt, (List) unsafe.getObject(t5, offset), false);
                    i12 += computeSizeFixed32List;
                    break;
                case 26:
                    computeBoolSize = SchemaUtil.computeSizeStringList(numberAt, (List) unsafe.getObject(t5, offset));
                    i12 += computeBoolSize;
                    break;
                case 27:
                    computeBoolSize = SchemaUtil.computeSizeMessageList(numberAt, (List) unsafe.getObject(t5, offset), getMessageFieldSchema(i11));
                    i12 += computeBoolSize;
                    break;
                case 28:
                    computeBoolSize = SchemaUtil.computeSizeByteStringList(numberAt, (List) unsafe.getObject(t5, offset));
                    i12 += computeBoolSize;
                    break;
                case R$styleable.Toolbar_titleTextColor /* 29 */:
                    computeBoolSize = SchemaUtil.computeSizeUInt32List(numberAt, (List) unsafe.getObject(t5, offset), false);
                    i12 += computeBoolSize;
                    break;
                case 30:
                    z5 = false;
                    computeSizeFixed32List = SchemaUtil.computeSizeEnumList(numberAt, (List) unsafe.getObject(t5, offset), false);
                    i12 += computeSizeFixed32List;
                    break;
                case 31:
                    z5 = false;
                    computeSizeFixed32List = SchemaUtil.computeSizeFixed32List(numberAt, (List) unsafe.getObject(t5, offset), false);
                    i12 += computeSizeFixed32List;
                    break;
                case 32:
                    z5 = false;
                    computeSizeFixed32List = SchemaUtil.computeSizeFixed64List(numberAt, (List) unsafe.getObject(t5, offset), false);
                    i12 += computeSizeFixed32List;
                    break;
                case 33:
                    z5 = false;
                    computeSizeFixed32List = SchemaUtil.computeSizeSInt32List(numberAt, (List) unsafe.getObject(t5, offset), false);
                    i12 += computeSizeFixed32List;
                    break;
                case 34:
                    z5 = false;
                    computeSizeFixed32List = SchemaUtil.computeSizeSInt64List(numberAt, (List) unsafe.getObject(t5, offset), false);
                    i12 += computeSizeFixed32List;
                    break;
                case 35:
                    computeSizeFixed64ListNoTag = SchemaUtil.computeSizeFixed64ListNoTag((List) unsafe.getObject(t5, offset));
                    if (computeSizeFixed64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t5, i14, computeSizeFixed64ListNoTag);
                        }
                        computeTagSize = CodedOutputStream.computeTagSize(numberAt);
                        computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(computeSizeFixed64ListNoTag);
                        computeSFixed32Size = computeTagSize + computeUInt32SizeNoTag + computeSizeFixed64ListNoTag;
                        i12 += computeSFixed32Size;
                    }
                    break;
                case 36:
                    computeSizeFixed64ListNoTag = SchemaUtil.computeSizeFixed32ListNoTag((List) unsafe.getObject(t5, offset));
                    if (computeSizeFixed64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t5, i14, computeSizeFixed64ListNoTag);
                        }
                        computeTagSize = CodedOutputStream.computeTagSize(numberAt);
                        computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(computeSizeFixed64ListNoTag);
                        computeSFixed32Size = computeTagSize + computeUInt32SizeNoTag + computeSizeFixed64ListNoTag;
                        i12 += computeSFixed32Size;
                    }
                    break;
                case 37:
                    computeSizeFixed64ListNoTag = SchemaUtil.computeSizeInt64ListNoTag((List) unsafe.getObject(t5, offset));
                    if (computeSizeFixed64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t5, i14, computeSizeFixed64ListNoTag);
                        }
                        computeTagSize = CodedOutputStream.computeTagSize(numberAt);
                        computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(computeSizeFixed64ListNoTag);
                        computeSFixed32Size = computeTagSize + computeUInt32SizeNoTag + computeSizeFixed64ListNoTag;
                        i12 += computeSFixed32Size;
                    }
                    break;
                case 38:
                    computeSizeFixed64ListNoTag = SchemaUtil.computeSizeUInt64ListNoTag((List) unsafe.getObject(t5, offset));
                    if (computeSizeFixed64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t5, i14, computeSizeFixed64ListNoTag);
                        }
                        computeTagSize = CodedOutputStream.computeTagSize(numberAt);
                        computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(computeSizeFixed64ListNoTag);
                        computeSFixed32Size = computeTagSize + computeUInt32SizeNoTag + computeSizeFixed64ListNoTag;
                        i12 += computeSFixed32Size;
                    }
                    break;
                case 39:
                    computeSizeFixed64ListNoTag = SchemaUtil.computeSizeInt32ListNoTag((List) unsafe.getObject(t5, offset));
                    if (computeSizeFixed64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t5, i14, computeSizeFixed64ListNoTag);
                        }
                        computeTagSize = CodedOutputStream.computeTagSize(numberAt);
                        computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(computeSizeFixed64ListNoTag);
                        computeSFixed32Size = computeTagSize + computeUInt32SizeNoTag + computeSizeFixed64ListNoTag;
                        i12 += computeSFixed32Size;
                    }
                    break;
                case 40:
                    computeSizeFixed64ListNoTag = SchemaUtil.computeSizeFixed64ListNoTag((List) unsafe.getObject(t5, offset));
                    if (computeSizeFixed64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t5, i14, computeSizeFixed64ListNoTag);
                        }
                        computeTagSize = CodedOutputStream.computeTagSize(numberAt);
                        computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(computeSizeFixed64ListNoTag);
                        computeSFixed32Size = computeTagSize + computeUInt32SizeNoTag + computeSizeFixed64ListNoTag;
                        i12 += computeSFixed32Size;
                    }
                    break;
                case 41:
                    computeSizeFixed64ListNoTag = SchemaUtil.computeSizeFixed32ListNoTag((List) unsafe.getObject(t5, offset));
                    if (computeSizeFixed64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t5, i14, computeSizeFixed64ListNoTag);
                        }
                        computeTagSize = CodedOutputStream.computeTagSize(numberAt);
                        computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(computeSizeFixed64ListNoTag);
                        computeSFixed32Size = computeTagSize + computeUInt32SizeNoTag + computeSizeFixed64ListNoTag;
                        i12 += computeSFixed32Size;
                    }
                    break;
                case 42:
                    computeSizeFixed64ListNoTag = SchemaUtil.computeSizeBoolListNoTag((List) unsafe.getObject(t5, offset));
                    if (computeSizeFixed64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t5, i14, computeSizeFixed64ListNoTag);
                        }
                        computeTagSize = CodedOutputStream.computeTagSize(numberAt);
                        computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(computeSizeFixed64ListNoTag);
                        computeSFixed32Size = computeTagSize + computeUInt32SizeNoTag + computeSizeFixed64ListNoTag;
                        i12 += computeSFixed32Size;
                    }
                    break;
                case 43:
                    computeSizeFixed64ListNoTag = SchemaUtil.computeSizeUInt32ListNoTag((List) unsafe.getObject(t5, offset));
                    if (computeSizeFixed64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t5, i14, computeSizeFixed64ListNoTag);
                        }
                        computeTagSize = CodedOutputStream.computeTagSize(numberAt);
                        computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(computeSizeFixed64ListNoTag);
                        computeSFixed32Size = computeTagSize + computeUInt32SizeNoTag + computeSizeFixed64ListNoTag;
                        i12 += computeSFixed32Size;
                    }
                    break;
                case 44:
                    computeSizeFixed64ListNoTag = SchemaUtil.computeSizeEnumListNoTag((List) unsafe.getObject(t5, offset));
                    if (computeSizeFixed64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t5, i14, computeSizeFixed64ListNoTag);
                        }
                        computeTagSize = CodedOutputStream.computeTagSize(numberAt);
                        computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(computeSizeFixed64ListNoTag);
                        computeSFixed32Size = computeTagSize + computeUInt32SizeNoTag + computeSizeFixed64ListNoTag;
                        i12 += computeSFixed32Size;
                    }
                    break;
                case 45:
                    computeSizeFixed64ListNoTag = SchemaUtil.computeSizeFixed32ListNoTag((List) unsafe.getObject(t5, offset));
                    if (computeSizeFixed64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t5, i14, computeSizeFixed64ListNoTag);
                        }
                        computeTagSize = CodedOutputStream.computeTagSize(numberAt);
                        computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(computeSizeFixed64ListNoTag);
                        computeSFixed32Size = computeTagSize + computeUInt32SizeNoTag + computeSizeFixed64ListNoTag;
                        i12 += computeSFixed32Size;
                    }
                    break;
                case 46:
                    computeSizeFixed64ListNoTag = SchemaUtil.computeSizeFixed64ListNoTag((List) unsafe.getObject(t5, offset));
                    if (computeSizeFixed64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t5, i14, computeSizeFixed64ListNoTag);
                        }
                        computeTagSize = CodedOutputStream.computeTagSize(numberAt);
                        computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(computeSizeFixed64ListNoTag);
                        computeSFixed32Size = computeTagSize + computeUInt32SizeNoTag + computeSizeFixed64ListNoTag;
                        i12 += computeSFixed32Size;
                    }
                    break;
                case 47:
                    computeSizeFixed64ListNoTag = SchemaUtil.computeSizeSInt32ListNoTag((List) unsafe.getObject(t5, offset));
                    if (computeSizeFixed64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t5, i14, computeSizeFixed64ListNoTag);
                        }
                        computeTagSize = CodedOutputStream.computeTagSize(numberAt);
                        computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(computeSizeFixed64ListNoTag);
                        computeSFixed32Size = computeTagSize + computeUInt32SizeNoTag + computeSizeFixed64ListNoTag;
                        i12 += computeSFixed32Size;
                    }
                    break;
                case 48:
                    computeSizeFixed64ListNoTag = SchemaUtil.computeSizeSInt64ListNoTag((List) unsafe.getObject(t5, offset));
                    if (computeSizeFixed64ListNoTag > 0) {
                        if (this.useCachedSizeField) {
                            unsafe.putInt(t5, i14, computeSizeFixed64ListNoTag);
                        }
                        computeTagSize = CodedOutputStream.computeTagSize(numberAt);
                        computeUInt32SizeNoTag = CodedOutputStream.computeUInt32SizeNoTag(computeSizeFixed64ListNoTag);
                        computeSFixed32Size = computeTagSize + computeUInt32SizeNoTag + computeSizeFixed64ListNoTag;
                        i12 += computeSFixed32Size;
                    }
                    break;
                case 49:
                    computeBoolSize = SchemaUtil.computeSizeGroupList(numberAt, (List) unsafe.getObject(t5, offset), getMessageFieldSchema(i11));
                    i12 += computeBoolSize;
                    break;
                case 50:
                    computeBoolSize = this.mapFieldSchema.getSerializedSize(numberAt, unsafe.getObject(t5, offset), getMapFieldDefaultEntry(i11));
                    i12 += computeBoolSize;
                    break;
                case 51:
                    if (isOneofPresent(t5, numberAt, i11)) {
                        computeBoolSize = CodedOutputStream.computeDoubleSize(numberAt, 0.0d);
                        i12 += computeBoolSize;
                    }
                    break;
                case 52:
                    if (isOneofPresent(t5, numberAt, i11)) {
                        computeBoolSize = CodedOutputStream.computeFloatSize(numberAt, 0.0f);
                        i12 += computeBoolSize;
                    }
                    break;
                case 53:
                    if (isOneofPresent(t5, numberAt, i11)) {
                        computeBoolSize = CodedOutputStream.computeInt64Size(numberAt, oneofLongAt(t5, offset));
                        i12 += computeBoolSize;
                    }
                    break;
                case 54:
                    if (isOneofPresent(t5, numberAt, i11)) {
                        computeBoolSize = CodedOutputStream.computeUInt64Size(numberAt, oneofLongAt(t5, offset));
                        i12 += computeBoolSize;
                    }
                    break;
                case 55:
                    if (isOneofPresent(t5, numberAt, i11)) {
                        computeBoolSize = CodedOutputStream.computeInt32Size(numberAt, oneofIntAt(t5, offset));
                        i12 += computeBoolSize;
                    }
                    break;
                case 56:
                    if (isOneofPresent(t5, numberAt, i11)) {
                        computeBoolSize = CodedOutputStream.computeFixed64Size(numberAt, 0L);
                        i12 += computeBoolSize;
                    }
                    break;
                case 57:
                    if (isOneofPresent(t5, numberAt, i11)) {
                        computeSFixed32Size = CodedOutputStream.computeFixed32Size(numberAt, 0);
                        i12 += computeSFixed32Size;
                    }
                    break;
                case 58:
                    if (isOneofPresent(t5, numberAt, i11)) {
                        computeBoolSize = CodedOutputStream.computeBoolSize(numberAt, true);
                        i12 += computeBoolSize;
                    }
                    break;
                case 59:
                    if (isOneofPresent(t5, numberAt, i11)) {
                        Object object2 = unsafe.getObject(t5, offset);
                        computeBoolSize = object2 instanceof ByteString ? CodedOutputStream.computeBytesSize(numberAt, (ByteString) object2) : CodedOutputStream.computeStringSize(numberAt, (String) object2);
                        i12 += computeBoolSize;
                    }
                    break;
                case 60:
                    if (isOneofPresent(t5, numberAt, i11)) {
                        computeBoolSize = SchemaUtil.computeSizeMessage(numberAt, unsafe.getObject(t5, offset), getMessageFieldSchema(i11));
                        i12 += computeBoolSize;
                    }
                    break;
                case 61:
                    if (isOneofPresent(t5, numberAt, i11)) {
                        computeBoolSize = CodedOutputStream.computeBytesSize(numberAt, (ByteString) unsafe.getObject(t5, offset));
                        i12 += computeBoolSize;
                    }
                    break;
                case 62:
                    if (isOneofPresent(t5, numberAt, i11)) {
                        computeBoolSize = CodedOutputStream.computeUInt32Size(numberAt, oneofIntAt(t5, offset));
                        i12 += computeBoolSize;
                    }
                    break;
                case Function.ALT_CONVENTION /* 63 */:
                    if (isOneofPresent(t5, numberAt, i11)) {
                        computeBoolSize = CodedOutputStream.computeEnumSize(numberAt, oneofIntAt(t5, offset));
                        i12 += computeBoolSize;
                    }
                    break;
                case Function.THROW_LAST_ERROR /* 64 */:
                    if (isOneofPresent(t5, numberAt, i11)) {
                        computeSFixed32Size = CodedOutputStream.computeSFixed32Size(numberAt, 0);
                        i12 += computeSFixed32Size;
                    }
                    break;
                case 65:
                    if (isOneofPresent(t5, numberAt, i11)) {
                        computeBoolSize = CodedOutputStream.computeSFixed64Size(numberAt, 0L);
                        i12 += computeBoolSize;
                    }
                    break;
                case 66:
                    if (isOneofPresent(t5, numberAt, i11)) {
                        computeBoolSize = CodedOutputStream.computeSInt32Size(numberAt, oneofIntAt(t5, offset));
                        i12 += computeBoolSize;
                    }
                    break;
                case 67:
                    if (isOneofPresent(t5, numberAt, i11)) {
                        computeBoolSize = CodedOutputStream.computeSInt64Size(numberAt, oneofLongAt(t5, offset));
                        i12 += computeBoolSize;
                    }
                    break;
                case 68:
                    if (isOneofPresent(t5, numberAt, i11)) {
                        computeBoolSize = CodedOutputStream.computeGroupSize(numberAt, (MessageLite) unsafe.getObject(t5, offset), getMessageFieldSchema(i11));
                        i12 += computeBoolSize;
                    }
                    break;
            }
            i11 += 3;
            i9 = i5;
            i10 = i6;
            i8 = 1048575;
        }
        int unknownFieldsSerializedSize = i12 + getUnknownFieldsSerializedSize(this.unknownFieldSchema, t5);
        return this.hasExtensions ? unknownFieldsSerializedSize + this.extensionSchema.getExtensions(t5).getSerializedSize() : unknownFieldsSerializedSize;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:4:0x0019. Please report as an issue. */
    @Override // androidx.datastore.preferences.protobuf.Schema
    public int hashCode(T t5) {
        int i5;
        int hashLong;
        int length = this.buffer.length;
        int i6 = 0;
        for (int i7 = 0; i7 < length; i7 += 3) {
            int typeAndOffsetAt = typeAndOffsetAt(i7);
            int numberAt = numberAt(i7);
            long offset = offset(typeAndOffsetAt);
            int i8 = 37;
            switch (type(typeAndOffsetAt)) {
                case 0:
                    i5 = i6 * 53;
                    hashLong = Internal.hashLong(Double.doubleToLongBits(UnsafeUtil.getDouble(t5, offset)));
                    i6 = i5 + hashLong;
                    break;
                case 1:
                    i5 = i6 * 53;
                    hashLong = Float.floatToIntBits(UnsafeUtil.getFloat(t5, offset));
                    i6 = i5 + hashLong;
                    break;
                case 2:
                    i5 = i6 * 53;
                    hashLong = Internal.hashLong(UnsafeUtil.getLong(t5, offset));
                    i6 = i5 + hashLong;
                    break;
                case 3:
                    i5 = i6 * 53;
                    hashLong = Internal.hashLong(UnsafeUtil.getLong(t5, offset));
                    i6 = i5 + hashLong;
                    break;
                case 4:
                    i5 = i6 * 53;
                    hashLong = UnsafeUtil.getInt(t5, offset);
                    i6 = i5 + hashLong;
                    break;
                case 5:
                    i5 = i6 * 53;
                    hashLong = Internal.hashLong(UnsafeUtil.getLong(t5, offset));
                    i6 = i5 + hashLong;
                    break;
                case 6:
                    i5 = i6 * 53;
                    hashLong = UnsafeUtil.getInt(t5, offset);
                    i6 = i5 + hashLong;
                    break;
                case 7:
                    i5 = i6 * 53;
                    hashLong = Internal.hashBoolean(UnsafeUtil.getBoolean(t5, offset));
                    i6 = i5 + hashLong;
                    break;
                case 8:
                    i5 = i6 * 53;
                    hashLong = ((String) UnsafeUtil.getObject(t5, offset)).hashCode();
                    i6 = i5 + hashLong;
                    break;
                case 9:
                    Object object = UnsafeUtil.getObject(t5, offset);
                    if (object != null) {
                        i8 = object.hashCode();
                    }
                    i6 = (i6 * 53) + i8;
                    break;
                case 10:
                    i5 = i6 * 53;
                    hashLong = UnsafeUtil.getObject(t5, offset).hashCode();
                    i6 = i5 + hashLong;
                    break;
                case 11:
                    i5 = i6 * 53;
                    hashLong = UnsafeUtil.getInt(t5, offset);
                    i6 = i5 + hashLong;
                    break;
                case 12:
                    i5 = i6 * 53;
                    hashLong = UnsafeUtil.getInt(t5, offset);
                    i6 = i5 + hashLong;
                    break;
                case 13:
                    i5 = i6 * 53;
                    hashLong = UnsafeUtil.getInt(t5, offset);
                    i6 = i5 + hashLong;
                    break;
                case 14:
                    i5 = i6 * 53;
                    hashLong = Internal.hashLong(UnsafeUtil.getLong(t5, offset));
                    i6 = i5 + hashLong;
                    break;
                case 15:
                    i5 = i6 * 53;
                    hashLong = UnsafeUtil.getInt(t5, offset);
                    i6 = i5 + hashLong;
                    break;
                case 16:
                    i5 = i6 * 53;
                    hashLong = Internal.hashLong(UnsafeUtil.getLong(t5, offset));
                    i6 = i5 + hashLong;
                    break;
                case 17:
                    Object object2 = UnsafeUtil.getObject(t5, offset);
                    if (object2 != null) {
                        i8 = object2.hashCode();
                    }
                    i6 = (i6 * 53) + i8;
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case R$styleable.Toolbar_titleMarginBottom /* 23 */:
                case R$styleable.Toolbar_titleMarginEnd /* 24 */:
                case 25:
                case 26:
                case 27:
                case 28:
                case R$styleable.Toolbar_titleTextColor /* 29 */:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    i5 = i6 * 53;
                    hashLong = UnsafeUtil.getObject(t5, offset).hashCode();
                    i6 = i5 + hashLong;
                    break;
                case 50:
                    i5 = i6 * 53;
                    hashLong = UnsafeUtil.getObject(t5, offset).hashCode();
                    i6 = i5 + hashLong;
                    break;
                case 51:
                    if (isOneofPresent(t5, numberAt, i7)) {
                        i5 = i6 * 53;
                        hashLong = Internal.hashLong(Double.doubleToLongBits(oneofDoubleAt(t5, offset)));
                        i6 = i5 + hashLong;
                        break;
                    } else {
                        break;
                    }
                case 52:
                    if (isOneofPresent(t5, numberAt, i7)) {
                        i5 = i6 * 53;
                        hashLong = Float.floatToIntBits(oneofFloatAt(t5, offset));
                        i6 = i5 + hashLong;
                        break;
                    } else {
                        break;
                    }
                case 53:
                    if (isOneofPresent(t5, numberAt, i7)) {
                        i5 = i6 * 53;
                        hashLong = Internal.hashLong(oneofLongAt(t5, offset));
                        i6 = i5 + hashLong;
                        break;
                    } else {
                        break;
                    }
                case 54:
                    if (isOneofPresent(t5, numberAt, i7)) {
                        i5 = i6 * 53;
                        hashLong = Internal.hashLong(oneofLongAt(t5, offset));
                        i6 = i5 + hashLong;
                        break;
                    } else {
                        break;
                    }
                case 55:
                    if (isOneofPresent(t5, numberAt, i7)) {
                        i5 = i6 * 53;
                        hashLong = oneofIntAt(t5, offset);
                        i6 = i5 + hashLong;
                        break;
                    } else {
                        break;
                    }
                case 56:
                    if (isOneofPresent(t5, numberAt, i7)) {
                        i5 = i6 * 53;
                        hashLong = Internal.hashLong(oneofLongAt(t5, offset));
                        i6 = i5 + hashLong;
                        break;
                    } else {
                        break;
                    }
                case 57:
                    if (isOneofPresent(t5, numberAt, i7)) {
                        i5 = i6 * 53;
                        hashLong = oneofIntAt(t5, offset);
                        i6 = i5 + hashLong;
                        break;
                    } else {
                        break;
                    }
                case 58:
                    if (isOneofPresent(t5, numberAt, i7)) {
                        i5 = i6 * 53;
                        hashLong = Internal.hashBoolean(oneofBooleanAt(t5, offset));
                        i6 = i5 + hashLong;
                        break;
                    } else {
                        break;
                    }
                case 59:
                    if (isOneofPresent(t5, numberAt, i7)) {
                        i5 = i6 * 53;
                        hashLong = ((String) UnsafeUtil.getObject(t5, offset)).hashCode();
                        i6 = i5 + hashLong;
                        break;
                    } else {
                        break;
                    }
                case 60:
                    if (isOneofPresent(t5, numberAt, i7)) {
                        i5 = i6 * 53;
                        hashLong = UnsafeUtil.getObject(t5, offset).hashCode();
                        i6 = i5 + hashLong;
                        break;
                    } else {
                        break;
                    }
                case 61:
                    if (isOneofPresent(t5, numberAt, i7)) {
                        i5 = i6 * 53;
                        hashLong = UnsafeUtil.getObject(t5, offset).hashCode();
                        i6 = i5 + hashLong;
                        break;
                    } else {
                        break;
                    }
                case 62:
                    if (isOneofPresent(t5, numberAt, i7)) {
                        i5 = i6 * 53;
                        hashLong = oneofIntAt(t5, offset);
                        i6 = i5 + hashLong;
                        break;
                    } else {
                        break;
                    }
                case Function.ALT_CONVENTION /* 63 */:
                    if (isOneofPresent(t5, numberAt, i7)) {
                        i5 = i6 * 53;
                        hashLong = oneofIntAt(t5, offset);
                        i6 = i5 + hashLong;
                        break;
                    } else {
                        break;
                    }
                case Function.THROW_LAST_ERROR /* 64 */:
                    if (isOneofPresent(t5, numberAt, i7)) {
                        i5 = i6 * 53;
                        hashLong = oneofIntAt(t5, offset);
                        i6 = i5 + hashLong;
                        break;
                    } else {
                        break;
                    }
                case 65:
                    if (isOneofPresent(t5, numberAt, i7)) {
                        i5 = i6 * 53;
                        hashLong = Internal.hashLong(oneofLongAt(t5, offset));
                        i6 = i5 + hashLong;
                        break;
                    } else {
                        break;
                    }
                case 66:
                    if (isOneofPresent(t5, numberAt, i7)) {
                        i5 = i6 * 53;
                        hashLong = oneofIntAt(t5, offset);
                        i6 = i5 + hashLong;
                        break;
                    } else {
                        break;
                    }
                case 67:
                    if (isOneofPresent(t5, numberAt, i7)) {
                        i5 = i6 * 53;
                        hashLong = Internal.hashLong(oneofLongAt(t5, offset));
                        i6 = i5 + hashLong;
                        break;
                    } else {
                        break;
                    }
                case 68:
                    if (isOneofPresent(t5, numberAt, i7)) {
                        i5 = i6 * 53;
                        hashLong = UnsafeUtil.getObject(t5, offset).hashCode();
                        i6 = i5 + hashLong;
                        break;
                    } else {
                        break;
                    }
            }
        }
        int hashCode = (i6 * 53) + this.unknownFieldSchema.getFromMessage(t5).hashCode();
        return this.hasExtensions ? (hashCode * 53) + this.extensionSchema.getExtensions(t5).hashCode() : hashCode;
    }

    @Override // androidx.datastore.preferences.protobuf.Schema
    public final boolean isInitialized(T t5) {
        int i5;
        int i6;
        int i7 = 1048575;
        int i8 = 0;
        int i9 = 0;
        while (i9 < this.checkInitializedCount) {
            int i10 = this.intArray[i9];
            int numberAt = numberAt(i10);
            int typeAndOffsetAt = typeAndOffsetAt(i10);
            int i11 = this.buffer[i10 + 2];
            int i12 = i11 & 1048575;
            int i13 = 1 << (i11 >>> 20);
            if (i12 != i7) {
                if (i12 != 1048575) {
                    i8 = UNSAFE.getInt(t5, i12);
                }
                i6 = i8;
                i5 = i12;
            } else {
                i5 = i7;
                i6 = i8;
            }
            if (isRequired(typeAndOffsetAt) && !isFieldPresent(t5, i10, i5, i6, i13)) {
                return false;
            }
            int type = type(typeAndOffsetAt);
            if (type != 9 && type != 17) {
                if (type != 27) {
                    if (type == 60 || type == 68) {
                        if (isOneofPresent(t5, numberAt, i10) && !isInitialized(t5, typeAndOffsetAt, getMessageFieldSchema(i10))) {
                            return false;
                        }
                    } else if (type != 49) {
                        if (type == 50 && !isMapInitialized(t5, typeAndOffsetAt, i10)) {
                            return false;
                        }
                    }
                }
                if (!isListInitialized(t5, typeAndOffsetAt, i10)) {
                    return false;
                }
            } else if (isFieldPresent(t5, i10, i5, i6, i13) && !isInitialized(t5, typeAndOffsetAt, getMessageFieldSchema(i10))) {
                return false;
            }
            i9++;
            i7 = i5;
            i8 = i6;
        }
        return !this.hasExtensions || this.extensionSchema.getExtensions(t5).isInitialized();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.datastore.preferences.protobuf.Schema
    public void makeImmutable(T t5) {
        if (isMutable(t5)) {
            if (t5 instanceof GeneratedMessageLite) {
                GeneratedMessageLite generatedMessageLite = (GeneratedMessageLite) t5;
                generatedMessageLite.clearMemoizedSerializedSize();
                generatedMessageLite.clearMemoizedHashCode();
                generatedMessageLite.markImmutable();
            }
            int length = this.buffer.length;
            for (int i5 = 0; i5 < length; i5 += 3) {
                int typeAndOffsetAt = typeAndOffsetAt(i5);
                long offset = offset(typeAndOffsetAt);
                int type = type(typeAndOffsetAt);
                if (type != 9) {
                    if (type != 60 && type != 68) {
                        switch (type) {
                            case 18:
                            case 19:
                            case 20:
                            case 21:
                            case 22:
                            case R$styleable.Toolbar_titleMarginBottom /* 23 */:
                            case R$styleable.Toolbar_titleMarginEnd /* 24 */:
                            case 25:
                            case 26:
                            case 27:
                            case 28:
                            case R$styleable.Toolbar_titleTextColor /* 29 */:
                            case 30:
                            case 31:
                            case 32:
                            case 33:
                            case 34:
                            case 35:
                            case 36:
                            case 37:
                            case 38:
                            case 39:
                            case 40:
                            case 41:
                            case 42:
                            case 43:
                            case 44:
                            case 45:
                            case 46:
                            case 47:
                            case 48:
                            case 49:
                                this.listFieldSchema.makeImmutableListAt(t5, offset);
                                break;
                            case 50:
                                Unsafe unsafe = UNSAFE;
                                Object object = unsafe.getObject(t5, offset);
                                if (object != null) {
                                    unsafe.putObject(t5, offset, this.mapFieldSchema.toImmutable(object));
                                    break;
                                } else {
                                    break;
                                }
                        }
                    } else if (isOneofPresent(t5, numberAt(i5), i5)) {
                        getMessageFieldSchema(i5).makeImmutable(UNSAFE.getObject(t5, offset));
                    }
                }
                if (isFieldPresent(t5, i5)) {
                    getMessageFieldSchema(i5).makeImmutable(UNSAFE.getObject(t5, offset));
                }
            }
            this.unknownFieldSchema.makeImmutable(t5);
            if (this.hasExtensions) {
                this.extensionSchema.makeImmutable(t5);
            }
        }
    }

    @Override // androidx.datastore.preferences.protobuf.Schema
    public void mergeFrom(T t5, T t6) {
        checkMutable(t5);
        t6.getClass();
        for (int i5 = 0; i5 < this.buffer.length; i5 += 3) {
            mergeSingleField(t5, t6, i5);
        }
        SchemaUtil.mergeUnknownFields(this.unknownFieldSchema, t5, t6);
        if (this.hasExtensions) {
            SchemaUtil.mergeExtensions(this.extensionSchema, t5, t6);
        }
    }

    @Override // androidx.datastore.preferences.protobuf.Schema
    public T newInstance() {
        return (T) this.newInstanceSchema.newInstance(this.defaultInstance);
    }

    @Override // androidx.datastore.preferences.protobuf.Schema
    public void writeTo(T t5, Writer writer) {
        if (writer.fieldOrder() == Writer.FieldOrder.DESCENDING) {
            writeFieldsInDescendingOrder(t5, writer);
        } else {
            writeFieldsInAscendingOrder(t5, writer);
        }
    }

    private boolean isFieldPresent(T t5, int i5) {
        int presenceMaskAndOffsetAt = presenceMaskAndOffsetAt(i5);
        long j5 = 1048575 & presenceMaskAndOffsetAt;
        if (j5 != 1048575) {
            return (UnsafeUtil.getInt(t5, j5) & (1 << (presenceMaskAndOffsetAt >>> 20))) != 0;
        }
        int typeAndOffsetAt = typeAndOffsetAt(i5);
        long offset = offset(typeAndOffsetAt);
        switch (type(typeAndOffsetAt)) {
            case 0:
                return Double.doubleToRawLongBits(UnsafeUtil.getDouble(t5, offset)) != 0;
            case 1:
                return Float.floatToRawIntBits(UnsafeUtil.getFloat(t5, offset)) != 0;
            case 2:
                return UnsafeUtil.getLong(t5, offset) != 0;
            case 3:
                return UnsafeUtil.getLong(t5, offset) != 0;
            case 4:
                return UnsafeUtil.getInt(t5, offset) != 0;
            case 5:
                return UnsafeUtil.getLong(t5, offset) != 0;
            case 6:
                return UnsafeUtil.getInt(t5, offset) != 0;
            case 7:
                return UnsafeUtil.getBoolean(t5, offset);
            case 8:
                Object object = UnsafeUtil.getObject(t5, offset);
                if (object instanceof String) {
                    return !((String) object).isEmpty();
                }
                if (object instanceof ByteString) {
                    return !ByteString.EMPTY.equals(object);
                }
                throw new IllegalArgumentException();
            case 9:
                return UnsafeUtil.getObject(t5, offset) != null;
            case 10:
                return !ByteString.EMPTY.equals(UnsafeUtil.getObject(t5, offset));
            case 11:
                return UnsafeUtil.getInt(t5, offset) != 0;
            case 12:
                return UnsafeUtil.getInt(t5, offset) != 0;
            case 13:
                return UnsafeUtil.getInt(t5, offset) != 0;
            case 14:
                return UnsafeUtil.getLong(t5, offset) != 0;
            case 15:
                return UnsafeUtil.getInt(t5, offset) != 0;
            case 16:
                return UnsafeUtil.getLong(t5, offset) != 0;
            case 17:
                return UnsafeUtil.getObject(t5, offset) != null;
            default:
                throw new IllegalArgumentException();
        }
    }

    @Override // androidx.datastore.preferences.protobuf.Schema
    public void mergeFrom(T t5, Reader reader, ExtensionRegistryLite extensionRegistryLite) {
        extensionRegistryLite.getClass();
        checkMutable(t5);
        mergeFromHelper(this.unknownFieldSchema, this.extensionSchema, t5, reader, extensionRegistryLite);
    }

    private boolean equals(T t5, T t6, int i5) {
        int typeAndOffsetAt = typeAndOffsetAt(i5);
        long offset = offset(typeAndOffsetAt);
        switch (type(typeAndOffsetAt)) {
            case 0:
                return arePresentForEquals(t5, t6, i5) && Double.doubleToLongBits(UnsafeUtil.getDouble(t5, offset)) == Double.doubleToLongBits(UnsafeUtil.getDouble(t6, offset));
            case 1:
                return arePresentForEquals(t5, t6, i5) && Float.floatToIntBits(UnsafeUtil.getFloat(t5, offset)) == Float.floatToIntBits(UnsafeUtil.getFloat(t6, offset));
            case 2:
                return arePresentForEquals(t5, t6, i5) && UnsafeUtil.getLong(t5, offset) == UnsafeUtil.getLong(t6, offset);
            case 3:
                return arePresentForEquals(t5, t6, i5) && UnsafeUtil.getLong(t5, offset) == UnsafeUtil.getLong(t6, offset);
            case 4:
                return arePresentForEquals(t5, t6, i5) && UnsafeUtil.getInt(t5, offset) == UnsafeUtil.getInt(t6, offset);
            case 5:
                return arePresentForEquals(t5, t6, i5) && UnsafeUtil.getLong(t5, offset) == UnsafeUtil.getLong(t6, offset);
            case 6:
                return arePresentForEquals(t5, t6, i5) && UnsafeUtil.getInt(t5, offset) == UnsafeUtil.getInt(t6, offset);
            case 7:
                return arePresentForEquals(t5, t6, i5) && UnsafeUtil.getBoolean(t5, offset) == UnsafeUtil.getBoolean(t6, offset);
            case 8:
                return arePresentForEquals(t5, t6, i5) && SchemaUtil.safeEquals(UnsafeUtil.getObject(t5, offset), UnsafeUtil.getObject(t6, offset));
            case 9:
                return arePresentForEquals(t5, t6, i5) && SchemaUtil.safeEquals(UnsafeUtil.getObject(t5, offset), UnsafeUtil.getObject(t6, offset));
            case 10:
                return arePresentForEquals(t5, t6, i5) && SchemaUtil.safeEquals(UnsafeUtil.getObject(t5, offset), UnsafeUtil.getObject(t6, offset));
            case 11:
                return arePresentForEquals(t5, t6, i5) && UnsafeUtil.getInt(t5, offset) == UnsafeUtil.getInt(t6, offset);
            case 12:
                return arePresentForEquals(t5, t6, i5) && UnsafeUtil.getInt(t5, offset) == UnsafeUtil.getInt(t6, offset);
            case 13:
                return arePresentForEquals(t5, t6, i5) && UnsafeUtil.getInt(t5, offset) == UnsafeUtil.getInt(t6, offset);
            case 14:
                return arePresentForEquals(t5, t6, i5) && UnsafeUtil.getLong(t5, offset) == UnsafeUtil.getLong(t6, offset);
            case 15:
                return arePresentForEquals(t5, t6, i5) && UnsafeUtil.getInt(t5, offset) == UnsafeUtil.getInt(t6, offset);
            case 16:
                return arePresentForEquals(t5, t6, i5) && UnsafeUtil.getLong(t5, offset) == UnsafeUtil.getLong(t6, offset);
            case 17:
                return arePresentForEquals(t5, t6, i5) && SchemaUtil.safeEquals(UnsafeUtil.getObject(t5, offset), UnsafeUtil.getObject(t6, offset));
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case R$styleable.Toolbar_titleMarginBottom /* 23 */:
            case R$styleable.Toolbar_titleMarginEnd /* 24 */:
            case 25:
            case 26:
            case 27:
            case 28:
            case R$styleable.Toolbar_titleTextColor /* 29 */:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 46:
            case 47:
            case 48:
            case 49:
                return SchemaUtil.safeEquals(UnsafeUtil.getObject(t5, offset), UnsafeUtil.getObject(t6, offset));
            case 50:
                return SchemaUtil.safeEquals(UnsafeUtil.getObject(t5, offset), UnsafeUtil.getObject(t6, offset));
            case 51:
            case 52:
            case 53:
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
            case 59:
            case 60:
            case 61:
            case 62:
            case Function.ALT_CONVENTION /* 63 */:
            case Function.THROW_LAST_ERROR /* 64 */:
            case 65:
            case 66:
            case 67:
            case 68:
                return isOneofCaseEqual(t5, t6, i5) && SchemaUtil.safeEquals(UnsafeUtil.getObject(t5, offset), UnsafeUtil.getObject(t6, offset));
            default:
                return true;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static boolean isInitialized(Object obj, int i5, Schema schema) {
        return schema.isInitialized(UnsafeUtil.getObject(obj, offset(i5)));
    }
}
