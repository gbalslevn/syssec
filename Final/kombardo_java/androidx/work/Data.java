package androidx.work;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000e\u0018\u0000 \u001c2\u00020\u0001:\u0002\u001d\u001cB\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004B\u001b\b\u0010\u0012\u0010\u0010\u0007\u001a\f\u0012\u0004\u0012\u00020\u0006\u0012\u0002\b\u00030\u0005¢\u0006\u0004\b\u0003\u0010\bJ)\u0010\u000e\u001a\u00020\r\"\u0004\b\u0000\u0010\t2\u0006\u0010\n\u001a\u00020\u00062\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\u000b¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0013\u001a\u00020\r2\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0096\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0015\u0010\u0012J\u000f\u0010\u0016\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0016\u0010\u0017R\"\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00058\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0018R\u001f\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00058F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001a¨\u0006\u001e"}, d2 = {"Landroidx/work/Data;", BuildConfig.FLAVOR, "other", "<init>", "(Landroidx/work/Data;)V", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "values", "(Ljava/util/Map;)V", "T", "key", "Ljava/lang/Class;", "klass", BuildConfig.FLAVOR, "hasKeyWithValueOfType", "(Ljava/lang/String;Ljava/lang/Class;)Z", BuildConfig.FLAVOR, "size", "()I", "equals", "(Ljava/lang/Object;)Z", "hashCode", "toString", "()Ljava/lang/String;", "Ljava/util/Map;", "getKeyValueMap", "()Ljava/util/Map;", "keyValueMap", "Companion", "Builder", "work-runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class Data {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final Data EMPTY = new Builder().build();
    private static final String NULL_STRING_V1 = "androidx.work.Data-95ed6082-b8e9-46e8-a73f-ff56f00f5d9d";
    private static final short STREAM_MAGIC = -21521;
    private static final short STREAM_VERSION = 1;
    private static final byte TYPE_BOOLEAN = 1;
    private static final byte TYPE_BOOLEAN_ARRAY = 8;
    private static final byte TYPE_BYTE = 2;
    private static final byte TYPE_BYTE_ARRAY = 9;
    private static final byte TYPE_DOUBLE = 6;
    private static final byte TYPE_DOUBLE_ARRAY = 13;
    private static final byte TYPE_FLOAT = 5;
    private static final byte TYPE_FLOAT_ARRAY = 12;
    private static final byte TYPE_INTEGER = 3;
    private static final byte TYPE_INTEGER_ARRAY = 10;
    private static final byte TYPE_LONG = 4;
    private static final byte TYPE_LONG_ARRAY = 11;
    private static final byte TYPE_NULL = 0;
    private static final byte TYPE_STRING = 7;
    private static final byte TYPE_STRING_ARRAY = 14;
    private final Map<String, Object> values;

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\t\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\t\u0010\nJ\u0015\u0010\r\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ#\u0010\r\u001a\u00020\u00002\u0014\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000f¢\u0006\u0004\b\r\u0010\u0011J!\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u0007¢\u0006\u0004\b\u0012\u0010\bJ\r\u0010\u0013\u001a\u00020\u000b¢\u0006\u0004\b\u0013\u0010\u0014R\"\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00158\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0016¨\u0006\u0017"}, d2 = {"Landroidx/work/Data$Builder;", BuildConfig.FLAVOR, "<init>", "()V", BuildConfig.FLAVOR, "key", "value", "putDirect", "(Ljava/lang/String;Ljava/lang/Object;)Landroidx/work/Data$Builder;", "putString", "(Ljava/lang/String;Ljava/lang/String;)Landroidx/work/Data$Builder;", "Landroidx/work/Data;", "data", "putAll", "(Landroidx/work/Data;)Landroidx/work/Data$Builder;", BuildConfig.FLAVOR, "values", "(Ljava/util/Map;)Landroidx/work/Data$Builder;", "put", "build", "()Landroidx/work/Data;", BuildConfig.FLAVOR, "Ljava/util/Map;", "work-runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Builder {
        private final Map<String, Object> values = new LinkedHashMap();

        private final Builder putDirect(String key, Object value) {
            this.values.put(key, value);
            return this;
        }

        public final Data build() {
            Data data = new Data((Map<String, ?>) this.values);
            Data.INSTANCE.toByteArrayInternalV1(data);
            return data;
        }

        public final Builder put(String key, Object value) {
            Intrinsics.checkNotNullParameter(key, "key");
            Map<String, Object> map = this.values;
            if (value == null) {
                value = null;
            } else {
                KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(value.getClass());
                if (!(Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Boolean.TYPE)) ? true : Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Byte.TYPE)) ? true : Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer.TYPE)) ? true : Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Long.TYPE)) ? true : Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Float.TYPE)) ? true : Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Double.TYPE)) ? true : Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(String.class)) ? true : Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Boolean[].class)) ? true : Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Byte[].class)) ? true : Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer[].class)) ? true : Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Long[].class)) ? true : Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Float[].class)) ? true : Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Double[].class)) ? true : Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(String[].class)))) {
                    if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(boolean[].class))) {
                        value = Data_Kt.convertPrimitiveArray((boolean[]) value);
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(byte[].class))) {
                        value = Data_Kt.convertPrimitiveArray((byte[]) value);
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(int[].class))) {
                        value = Data_Kt.convertPrimitiveArray((int[]) value);
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(long[].class))) {
                        value = Data_Kt.convertPrimitiveArray((long[]) value);
                    } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(float[].class))) {
                        value = Data_Kt.convertPrimitiveArray((float[]) value);
                    } else {
                        if (!Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(double[].class))) {
                            throw new IllegalArgumentException("Key " + key + " has invalid type " + orCreateKotlinClass);
                        }
                        value = Data_Kt.convertPrimitiveArray((double[]) value);
                    }
                }
            }
            map.put(key, value);
            return this;
        }

        public final Builder putAll(Data data) {
            Intrinsics.checkNotNullParameter(data, "data");
            putAll(data.values);
            return this;
        }

        public final Builder putString(String key, String value) {
            Intrinsics.checkNotNullParameter(key, "key");
            return putDirect(key, value);
        }

        public final Builder putAll(Map<String, ? extends Object> values) {
            Intrinsics.checkNotNullParameter(values, "values");
            for (Map.Entry<String, ? extends Object> entry : values.entrySet()) {
                put(entry.getKey(), entry.getValue());
            }
            return this;
        }
    }

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\n\n\u0002\b\u0003\n\u0002\u0010\u0005\n\u0002\b\u0011\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u000f\u001a\u00020\u000e8\u0006X\u0087T¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0012\u001a\u00020\u00118\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0015\u001a\u00020\u00148\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0017\u001a\u00020\u00148\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0017\u0010\u0016R\u0014\u0010\u0019\u001a\u00020\u00188\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001b\u001a\u00020\u00188\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001b\u0010\u001aR\u0014\u0010\u001c\u001a\u00020\u00188\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001c\u0010\u001aR\u0014\u0010\u001d\u001a\u00020\u00188\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001d\u0010\u001aR\u0014\u0010\u001e\u001a\u00020\u00188\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001e\u0010\u001aR\u0014\u0010\u001f\u001a\u00020\u00188\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u001f\u0010\u001aR\u0014\u0010 \u001a\u00020\u00188\u0002X\u0082T¢\u0006\u0006\n\u0004\b \u0010\u001aR\u0014\u0010!\u001a\u00020\u00188\u0002X\u0082T¢\u0006\u0006\n\u0004\b!\u0010\u001aR\u0014\u0010\"\u001a\u00020\u00188\u0002X\u0082T¢\u0006\u0006\n\u0004\b\"\u0010\u001aR\u0014\u0010#\u001a\u00020\u00188\u0002X\u0082T¢\u0006\u0006\n\u0004\b#\u0010\u001aR\u0014\u0010$\u001a\u00020\u00188\u0002X\u0082T¢\u0006\u0006\n\u0004\b$\u0010\u001aR\u0014\u0010%\u001a\u00020\u00188\u0002X\u0082T¢\u0006\u0006\n\u0004\b%\u0010\u001aR\u0014\u0010&\u001a\u00020\u00188\u0002X\u0082T¢\u0006\u0006\n\u0004\b&\u0010\u001aR\u0014\u0010'\u001a\u00020\u00188\u0002X\u0082T¢\u0006\u0006\n\u0004\b'\u0010\u001aR\u0014\u0010(\u001a\u00020\u00188\u0002X\u0082T¢\u0006\u0006\n\u0004\b(\u0010\u001a¨\u0006)"}, d2 = {"Landroidx/work/Data$Companion;", BuildConfig.FLAVOR, "<init>", "()V", "Landroidx/work/Data;", "data", BuildConfig.FLAVOR, "toByteArrayInternalV1", "(Landroidx/work/Data;)[B", "bytes", "fromByteArray", "([B)Landroidx/work/Data;", "EMPTY", "Landroidx/work/Data;", BuildConfig.FLAVOR, "MAX_DATA_BYTES", "I", BuildConfig.FLAVOR, "NULL_STRING_V1", "Ljava/lang/String;", BuildConfig.FLAVOR, "STREAM_MAGIC", "S", "STREAM_VERSION", BuildConfig.FLAVOR, "TYPE_BOOLEAN", "B", "TYPE_BOOLEAN_ARRAY", "TYPE_BYTE", "TYPE_BYTE_ARRAY", "TYPE_DOUBLE", "TYPE_DOUBLE_ARRAY", "TYPE_FLOAT", "TYPE_FLOAT_ARRAY", "TYPE_INTEGER", "TYPE_INTEGER_ARRAY", "TYPE_LONG", "TYPE_LONG_ARRAY", "TYPE_NULL", "TYPE_STRING", "TYPE_STRING_ARRAY", "work-runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private static final boolean fromByteArray$isObjectStream(ByteArrayInputStream byteArrayInputStream) {
            byte[] bArr = new byte[2];
            byteArrayInputStream.read(bArr);
            byte b5 = (byte) (-21267);
            boolean z5 = false;
            if (bArr[0] == ((byte) 16777132) && bArr[1] == b5) {
                z5 = true;
            }
            byteArrayInputStream.reset();
            return z5;
        }

        private static final void fromByteArray$readHeader(DataInputStream dataInputStream) {
            short readShort = dataInputStream.readShort();
            if (readShort != -21521) {
                throw new IllegalStateException(("Magic number doesn't match: " + ((int) readShort)).toString());
            }
            short readShort2 = dataInputStream.readShort();
            if (readShort2 == 1) {
                return;
            }
            throw new IllegalStateException(("Unsupported version number: " + ((int) readShort2)).toString());
        }

        private static final Object fromByteArray$readValue(DataInputStream dataInputStream, byte b5) {
            if (b5 == 0) {
                return null;
            }
            if (b5 == 1) {
                return Boolean.valueOf(dataInputStream.readBoolean());
            }
            if (b5 == 2) {
                return Byte.valueOf(dataInputStream.readByte());
            }
            if (b5 == 3) {
                return Integer.valueOf(dataInputStream.readInt());
            }
            if (b5 == 4) {
                return Long.valueOf(dataInputStream.readLong());
            }
            if (b5 == 5) {
                return Float.valueOf(dataInputStream.readFloat());
            }
            if (b5 == 6) {
                return Double.valueOf(dataInputStream.readDouble());
            }
            if (b5 == 7) {
                return dataInputStream.readUTF();
            }
            int i5 = 0;
            if (b5 == 8) {
                int readInt = dataInputStream.readInt();
                Boolean[] boolArr = new Boolean[readInt];
                while (i5 < readInt) {
                    boolArr[i5] = Boolean.valueOf(dataInputStream.readBoolean());
                    i5++;
                }
                return boolArr;
            }
            if (b5 == 9) {
                int readInt2 = dataInputStream.readInt();
                Byte[] bArr = new Byte[readInt2];
                while (i5 < readInt2) {
                    bArr[i5] = Byte.valueOf(dataInputStream.readByte());
                    i5++;
                }
                return bArr;
            }
            if (b5 == 10) {
                int readInt3 = dataInputStream.readInt();
                Integer[] numArr = new Integer[readInt3];
                while (i5 < readInt3) {
                    numArr[i5] = Integer.valueOf(dataInputStream.readInt());
                    i5++;
                }
                return numArr;
            }
            if (b5 == 11) {
                int readInt4 = dataInputStream.readInt();
                Long[] lArr = new Long[readInt4];
                while (i5 < readInt4) {
                    lArr[i5] = Long.valueOf(dataInputStream.readLong());
                    i5++;
                }
                return lArr;
            }
            if (b5 == 12) {
                int readInt5 = dataInputStream.readInt();
                Float[] fArr = new Float[readInt5];
                while (i5 < readInt5) {
                    fArr[i5] = Float.valueOf(dataInputStream.readFloat());
                    i5++;
                }
                return fArr;
            }
            if (b5 == 13) {
                int readInt6 = dataInputStream.readInt();
                Double[] dArr = new Double[readInt6];
                while (i5 < readInt6) {
                    dArr[i5] = Double.valueOf(dataInputStream.readDouble());
                    i5++;
                }
                return dArr;
            }
            if (b5 != 14) {
                throw new IllegalStateException("Unsupported type " + ((int) b5));
            }
            int readInt7 = dataInputStream.readInt();
            String[] strArr = new String[readInt7];
            while (i5 < readInt7) {
                String readUTF = dataInputStream.readUTF();
                if (Intrinsics.areEqual(readUTF, Data.NULL_STRING_V1)) {
                    readUTF = null;
                }
                strArr[i5] = readUTF;
                i5++;
            }
            return strArr;
        }

        private static final void toByteArrayInternalV1$writeArray(DataOutputStream dataOutputStream, Object[] objArr) {
            int i5;
            KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(objArr.getClass());
            if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Boolean[].class))) {
                i5 = 8;
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Byte[].class))) {
                i5 = 9;
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Integer[].class))) {
                i5 = 10;
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Long[].class))) {
                i5 = 11;
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Float[].class))) {
                i5 = 12;
            } else if (Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Double[].class))) {
                i5 = 13;
            } else {
                if (!Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(String[].class))) {
                    throw new IllegalArgumentException("Unsupported value type " + Reflection.getOrCreateKotlinClass(objArr.getClass()).getQualifiedName());
                }
                i5 = 14;
            }
            dataOutputStream.writeByte(i5);
            dataOutputStream.writeInt(objArr.length);
            for (Object obj : objArr) {
                if (i5 == 8) {
                    Boolean bool = obj instanceof Boolean ? (Boolean) obj : null;
                    dataOutputStream.writeBoolean(bool != null ? bool.booleanValue() : false);
                } else if (i5 == 9) {
                    Byte b5 = obj instanceof Byte ? (Byte) obj : null;
                    dataOutputStream.writeByte(b5 != null ? b5.byteValue() : (byte) 0);
                } else if (i5 == 10) {
                    Integer num = obj instanceof Integer ? (Integer) obj : null;
                    dataOutputStream.writeInt(num != null ? num.intValue() : 0);
                } else if (i5 == 11) {
                    Long l5 = obj instanceof Long ? (Long) obj : null;
                    dataOutputStream.writeLong(l5 != null ? l5.longValue() : 0L);
                } else if (i5 == 12) {
                    Float f5 = obj instanceof Float ? (Float) obj : null;
                    dataOutputStream.writeFloat(f5 != null ? f5.floatValue() : 0.0f);
                } else if (i5 == 13) {
                    Double d5 = obj instanceof Double ? (Double) obj : null;
                    dataOutputStream.writeDouble(d5 != null ? d5.doubleValue() : 0.0d);
                } else if (i5 == 14) {
                    String str = obj instanceof String ? (String) obj : null;
                    if (str == null) {
                        str = Data.NULL_STRING_V1;
                    }
                    dataOutputStream.writeUTF(str);
                }
            }
        }

        private static final void toByteArrayInternalV1$writeEntry(DataOutputStream dataOutputStream, String str, Object obj) {
            if (obj == null) {
                dataOutputStream.writeByte(0);
            } else if (obj instanceof Boolean) {
                dataOutputStream.writeByte(1);
                dataOutputStream.writeBoolean(((Boolean) obj).booleanValue());
            } else if (obj instanceof Byte) {
                dataOutputStream.writeByte(2);
                dataOutputStream.writeByte(((Number) obj).byteValue());
            } else if (obj instanceof Integer) {
                dataOutputStream.writeByte(3);
                dataOutputStream.writeInt(((Number) obj).intValue());
            } else if (obj instanceof Long) {
                dataOutputStream.writeByte(4);
                dataOutputStream.writeLong(((Number) obj).longValue());
            } else if (obj instanceof Float) {
                dataOutputStream.writeByte(5);
                dataOutputStream.writeFloat(((Number) obj).floatValue());
            } else if (obj instanceof Double) {
                dataOutputStream.writeByte(6);
                dataOutputStream.writeDouble(((Number) obj).doubleValue());
            } else if (obj instanceof String) {
                dataOutputStream.writeByte(7);
                dataOutputStream.writeUTF((String) obj);
            } else {
                if (!(obj instanceof Object[])) {
                    throw new IllegalArgumentException("Unsupported value type " + Reflection.getOrCreateKotlinClass(obj.getClass()).getSimpleName());
                }
                toByteArrayInternalV1$writeArray(dataOutputStream, (Object[]) obj);
            }
            dataOutputStream.writeUTF(str);
        }

        private static final void toByteArrayInternalV1$writeHeader(DataOutputStream dataOutputStream) {
            dataOutputStream.writeShort(-21521);
            dataOutputStream.writeShort(1);
        }

        public final Data fromByteArray(byte[] bytes) {
            String str;
            String str2;
            ByteArrayInputStream byteArrayInputStream;
            int i5;
            Intrinsics.checkNotNullParameter(bytes, "bytes");
            if (bytes.length > 10240) {
                throw new IllegalStateException("Data cannot occupy more than 10240 bytes when serialized");
            }
            if (bytes.length == 0) {
                return Data.EMPTY;
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            try {
                byteArrayInputStream = new ByteArrayInputStream(bytes);
                i5 = 0;
            } catch (IOException e5) {
                str2 = Data_Kt.TAG;
                Logger.get().error(str2, "Error in Data#fromByteArray: ", e5);
            } catch (ClassNotFoundException e6) {
                str = Data_Kt.TAG;
                Logger.get().error(str, "Error in Data#fromByteArray: ", e6);
            }
            if (fromByteArray$isObjectStream(byteArrayInputStream)) {
                ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
                try {
                    int readInt = objectInputStream.readInt();
                    while (i5 < readInt) {
                        String readUTF = objectInputStream.readUTF();
                        Intrinsics.checkNotNullExpressionValue(readUTF, "readUTF()");
                        linkedHashMap.put(readUTF, objectInputStream.readObject());
                        i5++;
                    }
                    CloseableKt.closeFinally(objectInputStream, null);
                    return new Data(linkedHashMap);
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        CloseableKt.closeFinally(objectInputStream, th);
                        throw th2;
                    }
                }
            }
            DataInputStream dataInputStream = new DataInputStream(byteArrayInputStream);
            try {
                fromByteArray$readHeader(dataInputStream);
                int readInt2 = dataInputStream.readInt();
                while (i5 < readInt2) {
                    Object fromByteArray$readValue = fromByteArray$readValue(dataInputStream, dataInputStream.readByte());
                    String key = dataInputStream.readUTF();
                    Intrinsics.checkNotNullExpressionValue(key, "key");
                    linkedHashMap.put(key, fromByteArray$readValue);
                    i5++;
                }
                CloseableKt.closeFinally(dataInputStream, null);
                return new Data(linkedHashMap);
            } catch (Throwable th3) {
                try {
                    throw th3;
                } catch (Throwable th4) {
                    CloseableKt.closeFinally(dataInputStream, th3);
                    throw th4;
                }
            }
        }

        public final byte[] toByteArrayInternalV1(Data data) {
            String str;
            Intrinsics.checkNotNullParameter(data, "data");
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
                try {
                    toByteArrayInternalV1$writeHeader(dataOutputStream);
                    dataOutputStream.writeInt(data.size());
                    for (Map.Entry entry : data.values.entrySet()) {
                        toByteArrayInternalV1$writeEntry(dataOutputStream, (String) entry.getKey(), entry.getValue());
                    }
                    dataOutputStream.flush();
                    if (dataOutputStream.size() > 10240) {
                        throw new IllegalStateException("Data cannot occupy more than 10240 bytes when serialized");
                    }
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    CloseableKt.closeFinally(dataOutputStream, null);
                    Intrinsics.checkNotNullExpressionValue(byteArray, "{\n                ByteAr…          }\n            }");
                    return byteArray;
                } finally {
                }
            } catch (IOException e5) {
                str = Data_Kt.TAG;
                Logger.get().error(str, "Error in Data#toByteArray: ", e5);
                return new byte[0];
            }
        }

        private Companion() {
        }
    }

    public Data(Data other) {
        Intrinsics.checkNotNullParameter(other, "other");
        this.values = new HashMap(other.values);
    }

    public static final Data fromByteArray(byte[] bArr) {
        return INSTANCE.fromByteArray(bArr);
    }

    public static final byte[] toByteArrayInternalV1(Data data) {
        return INSTANCE.toByteArrayInternalV1(data);
    }

    public boolean equals(Object other) {
        boolean z5;
        if (this == other) {
            return true;
        }
        if (other == null || !Intrinsics.areEqual(Data.class, other.getClass())) {
            return false;
        }
        Data data = (Data) other;
        Set<String> keySet = this.values.keySet();
        if (!Intrinsics.areEqual(keySet, data.values.keySet())) {
            return false;
        }
        for (String str : keySet) {
            Object obj = this.values.get(str);
            Object obj2 = data.values.get(str);
            if (obj == null || obj2 == null) {
                z5 = obj == obj2;
            } else {
                if (obj instanceof Object[]) {
                    Object[] objArr = (Object[]) obj;
                    if (obj2 instanceof Object[]) {
                        z5 = ArraysKt.contentDeepEquals(objArr, (Object[]) obj2);
                    }
                }
                z5 = Intrinsics.areEqual(obj, obj2);
            }
            if (!z5) {
                return false;
            }
        }
        return true;
    }

    public final Map<String, Object> getKeyValueMap() {
        Map<String, Object> unmodifiableMap = Collections.unmodifiableMap(this.values);
        Intrinsics.checkNotNullExpressionValue(unmodifiableMap, "unmodifiableMap(values)");
        return unmodifiableMap;
    }

    public final <T> boolean hasKeyWithValueOfType(String key, Class<T> klass) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(klass, "klass");
        Object obj = this.values.get(key);
        return obj != null && klass.isAssignableFrom(obj.getClass());
    }

    public int hashCode() {
        int i5 = 0;
        for (Map.Entry<String, Object> entry : this.values.entrySet()) {
            Object value = entry.getValue();
            i5 += value instanceof Object[] ? Objects.hashCode(entry.getKey()) ^ ArraysKt.contentDeepHashCode((Object[]) value) : entry.hashCode();
        }
        return i5 * 31;
    }

    public final int size() {
        return this.values.size();
    }

    public String toString() {
        String str = "Data {" + CollectionsKt.joinToString$default(this.values.entrySet(), null, null, null, 0, null, new Function1<Map.Entry<? extends String, ? extends Object>, CharSequence>() { // from class: androidx.work.Data$toString$1$content$1
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final CharSequence invoke2(Map.Entry<String, ? extends Object> entry) {
                Intrinsics.checkNotNullParameter(entry, "<name for destructuring parameter 0>");
                String key = entry.getKey();
                Object value = entry.getValue();
                StringBuilder sb = new StringBuilder();
                sb.append(key);
                sb.append(" : ");
                if (value instanceof Object[]) {
                    value = Arrays.toString((Object[]) value);
                    Intrinsics.checkNotNullExpressionValue(value, "toString(this)");
                }
                sb.append(value);
                return sb.toString();
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ CharSequence invoke(Map.Entry<? extends String, ? extends Object> entry) {
                return invoke2((Map.Entry<String, ? extends Object>) entry);
            }
        }, 31, null) + "}";
        Intrinsics.checkNotNullExpressionValue(str, "StringBuilder().apply(builderAction).toString()");
        return str;
    }

    public Data(Map<String, ?> values) {
        Intrinsics.checkNotNullParameter(values, "values");
        this.values = new HashMap(values);
    }
}
