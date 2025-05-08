package androidx.datastore.preferences.protobuf;

import com.sun.jna.Function;
import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.security.PrivilegedExceptionAction;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class UnsafeUtil {
    private static final long BOOLEAN_ARRAY_BASE_OFFSET;
    private static final long BOOLEAN_ARRAY_INDEX_SCALE;
    private static final long BUFFER_ADDRESS_OFFSET;
    private static final int BYTE_ARRAY_ALIGNMENT;
    static final long BYTE_ARRAY_BASE_OFFSET;
    private static final long DOUBLE_ARRAY_BASE_OFFSET;
    private static final long DOUBLE_ARRAY_INDEX_SCALE;
    private static final long FLOAT_ARRAY_BASE_OFFSET;
    private static final long FLOAT_ARRAY_INDEX_SCALE;
    private static final long INT_ARRAY_BASE_OFFSET;
    private static final long INT_ARRAY_INDEX_SCALE;
    static final boolean IS_BIG_ENDIAN;
    private static final long LONG_ARRAY_BASE_OFFSET;
    private static final long LONG_ARRAY_INDEX_SCALE;
    private static final long OBJECT_ARRAY_BASE_OFFSET;
    private static final long OBJECT_ARRAY_INDEX_SCALE;
    private static final int STRIDE = 8;
    private static final int STRIDE_ALIGNMENT_MASK = 7;
    private static final Unsafe UNSAFE = getUnsafe();
    private static final Class<?> MEMORY_CLASS = Android.getMemoryClass();
    private static final boolean IS_ANDROID_64 = determineAndroidSupportByAddressSize(Long.TYPE);
    private static final boolean IS_ANDROID_32 = determineAndroidSupportByAddressSize(Integer.TYPE);
    private static final MemoryAccessor MEMORY_ACCESSOR = getMemoryAccessor();
    private static final boolean HAS_UNSAFE_BYTEBUFFER_OPERATIONS = supportsUnsafeByteBufferOperations();
    private static final boolean HAS_UNSAFE_ARRAY_OPERATIONS = supportsUnsafeArrayOperations();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class Android32MemoryAccessor extends MemoryAccessor {
        private static final long SMALL_ADDRESS_MASK = -1;

        Android32MemoryAccessor(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // androidx.datastore.preferences.protobuf.UnsafeUtil.MemoryAccessor
        public boolean getBoolean(Object obj, long j5) {
            return UnsafeUtil.IS_BIG_ENDIAN ? UnsafeUtil.getBooleanBigEndian(obj, j5) : UnsafeUtil.getBooleanLittleEndian(obj, j5);
        }

        @Override // androidx.datastore.preferences.protobuf.UnsafeUtil.MemoryAccessor
        public double getDouble(Object obj, long j5) {
            return Double.longBitsToDouble(getLong(obj, j5));
        }

        @Override // androidx.datastore.preferences.protobuf.UnsafeUtil.MemoryAccessor
        public float getFloat(Object obj, long j5) {
            return Float.intBitsToFloat(getInt(obj, j5));
        }

        @Override // androidx.datastore.preferences.protobuf.UnsafeUtil.MemoryAccessor
        public void putBoolean(Object obj, long j5, boolean z5) {
            if (UnsafeUtil.IS_BIG_ENDIAN) {
                UnsafeUtil.putBooleanBigEndian(obj, j5, z5);
            } else {
                UnsafeUtil.putBooleanLittleEndian(obj, j5, z5);
            }
        }

        @Override // androidx.datastore.preferences.protobuf.UnsafeUtil.MemoryAccessor
        public void putByte(Object obj, long j5, byte b5) {
            if (UnsafeUtil.IS_BIG_ENDIAN) {
                UnsafeUtil.putByteBigEndian(obj, j5, b5);
            } else {
                UnsafeUtil.putByteLittleEndian(obj, j5, b5);
            }
        }

        @Override // androidx.datastore.preferences.protobuf.UnsafeUtil.MemoryAccessor
        public void putDouble(Object obj, long j5, double d5) {
            putLong(obj, j5, Double.doubleToLongBits(d5));
        }

        @Override // androidx.datastore.preferences.protobuf.UnsafeUtil.MemoryAccessor
        public void putFloat(Object obj, long j5, float f5) {
            putInt(obj, j5, Float.floatToIntBits(f5));
        }

        @Override // androidx.datastore.preferences.protobuf.UnsafeUtil.MemoryAccessor
        public boolean supportsUnsafeByteBufferOperations() {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class Android64MemoryAccessor extends MemoryAccessor {
        Android64MemoryAccessor(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // androidx.datastore.preferences.protobuf.UnsafeUtil.MemoryAccessor
        public boolean getBoolean(Object obj, long j5) {
            return UnsafeUtil.IS_BIG_ENDIAN ? UnsafeUtil.getBooleanBigEndian(obj, j5) : UnsafeUtil.getBooleanLittleEndian(obj, j5);
        }

        @Override // androidx.datastore.preferences.protobuf.UnsafeUtil.MemoryAccessor
        public double getDouble(Object obj, long j5) {
            return Double.longBitsToDouble(getLong(obj, j5));
        }

        @Override // androidx.datastore.preferences.protobuf.UnsafeUtil.MemoryAccessor
        public float getFloat(Object obj, long j5) {
            return Float.intBitsToFloat(getInt(obj, j5));
        }

        @Override // androidx.datastore.preferences.protobuf.UnsafeUtil.MemoryAccessor
        public void putBoolean(Object obj, long j5, boolean z5) {
            if (UnsafeUtil.IS_BIG_ENDIAN) {
                UnsafeUtil.putBooleanBigEndian(obj, j5, z5);
            } else {
                UnsafeUtil.putBooleanLittleEndian(obj, j5, z5);
            }
        }

        @Override // androidx.datastore.preferences.protobuf.UnsafeUtil.MemoryAccessor
        public void putByte(Object obj, long j5, byte b5) {
            if (UnsafeUtil.IS_BIG_ENDIAN) {
                UnsafeUtil.putByteBigEndian(obj, j5, b5);
            } else {
                UnsafeUtil.putByteLittleEndian(obj, j5, b5);
            }
        }

        @Override // androidx.datastore.preferences.protobuf.UnsafeUtil.MemoryAccessor
        public void putDouble(Object obj, long j5, double d5) {
            putLong(obj, j5, Double.doubleToLongBits(d5));
        }

        @Override // androidx.datastore.preferences.protobuf.UnsafeUtil.MemoryAccessor
        public void putFloat(Object obj, long j5, float f5) {
            putInt(obj, j5, Float.floatToIntBits(f5));
        }

        @Override // androidx.datastore.preferences.protobuf.UnsafeUtil.MemoryAccessor
        public boolean supportsUnsafeByteBufferOperations() {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static final class JvmMemoryAccessor extends MemoryAccessor {
        JvmMemoryAccessor(Unsafe unsafe) {
            super(unsafe);
        }

        @Override // androidx.datastore.preferences.protobuf.UnsafeUtil.MemoryAccessor
        public boolean getBoolean(Object obj, long j5) {
            return this.unsafe.getBoolean(obj, j5);
        }

        @Override // androidx.datastore.preferences.protobuf.UnsafeUtil.MemoryAccessor
        public double getDouble(Object obj, long j5) {
            return this.unsafe.getDouble(obj, j5);
        }

        @Override // androidx.datastore.preferences.protobuf.UnsafeUtil.MemoryAccessor
        public float getFloat(Object obj, long j5) {
            return this.unsafe.getFloat(obj, j5);
        }

        @Override // androidx.datastore.preferences.protobuf.UnsafeUtil.MemoryAccessor
        public void putBoolean(Object obj, long j5, boolean z5) {
            this.unsafe.putBoolean(obj, j5, z5);
        }

        @Override // androidx.datastore.preferences.protobuf.UnsafeUtil.MemoryAccessor
        public void putByte(Object obj, long j5, byte b5) {
            this.unsafe.putByte(obj, j5, b5);
        }

        @Override // androidx.datastore.preferences.protobuf.UnsafeUtil.MemoryAccessor
        public void putDouble(Object obj, long j5, double d5) {
            this.unsafe.putDouble(obj, j5, d5);
        }

        @Override // androidx.datastore.preferences.protobuf.UnsafeUtil.MemoryAccessor
        public void putFloat(Object obj, long j5, float f5) {
            this.unsafe.putFloat(obj, j5, f5);
        }

        @Override // androidx.datastore.preferences.protobuf.UnsafeUtil.MemoryAccessor
        public boolean supportsUnsafeArrayOperations() {
            if (!super.supportsUnsafeArrayOperations()) {
                return false;
            }
            try {
                Class<?> cls = this.unsafe.getClass();
                Class cls2 = Long.TYPE;
                cls.getMethod("getByte", Object.class, cls2);
                cls.getMethod("putByte", Object.class, cls2, Byte.TYPE);
                cls.getMethod("getBoolean", Object.class, cls2);
                cls.getMethod("putBoolean", Object.class, cls2, Boolean.TYPE);
                cls.getMethod("getFloat", Object.class, cls2);
                cls.getMethod("putFloat", Object.class, cls2, Float.TYPE);
                cls.getMethod("getDouble", Object.class, cls2);
                cls.getMethod("putDouble", Object.class, cls2, Double.TYPE);
                return true;
            } catch (Throwable th) {
                UnsafeUtil.logMissingMethod(th);
                return false;
            }
        }

        @Override // androidx.datastore.preferences.protobuf.UnsafeUtil.MemoryAccessor
        public boolean supportsUnsafeByteBufferOperations() {
            if (!super.supportsUnsafeByteBufferOperations()) {
                return false;
            }
            try {
                Class<?> cls = this.unsafe.getClass();
                Class cls2 = Long.TYPE;
                cls.getMethod("getByte", cls2);
                cls.getMethod("putByte", cls2, Byte.TYPE);
                cls.getMethod("getInt", cls2);
                cls.getMethod("putInt", cls2, Integer.TYPE);
                cls.getMethod("getLong", cls2);
                cls.getMethod("putLong", cls2, cls2);
                cls.getMethod("copyMemory", cls2, cls2, cls2);
                cls.getMethod("copyMemory", Object.class, cls2, Object.class, cls2, cls2);
                return true;
            } catch (Throwable th) {
                UnsafeUtil.logMissingMethod(th);
                return false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static abstract class MemoryAccessor {
        Unsafe unsafe;

        MemoryAccessor(Unsafe unsafe) {
            this.unsafe = unsafe;
        }

        public final int arrayBaseOffset(Class<?> cls) {
            return this.unsafe.arrayBaseOffset(cls);
        }

        public final int arrayIndexScale(Class<?> cls) {
            return this.unsafe.arrayIndexScale(cls);
        }

        public abstract boolean getBoolean(Object obj, long j5);

        public abstract double getDouble(Object obj, long j5);

        public abstract float getFloat(Object obj, long j5);

        public final int getInt(Object obj, long j5) {
            return this.unsafe.getInt(obj, j5);
        }

        public final long getLong(Object obj, long j5) {
            return this.unsafe.getLong(obj, j5);
        }

        public final Object getObject(Object obj, long j5) {
            return this.unsafe.getObject(obj, j5);
        }

        public final long objectFieldOffset(Field field) {
            return this.unsafe.objectFieldOffset(field);
        }

        public abstract void putBoolean(Object obj, long j5, boolean z5);

        public abstract void putByte(Object obj, long j5, byte b5);

        public abstract void putDouble(Object obj, long j5, double d5);

        public abstract void putFloat(Object obj, long j5, float f5);

        public final void putInt(Object obj, long j5, int i5) {
            this.unsafe.putInt(obj, j5, i5);
        }

        public final void putLong(Object obj, long j5, long j6) {
            this.unsafe.putLong(obj, j5, j6);
        }

        public final void putObject(Object obj, long j5, Object obj2) {
            this.unsafe.putObject(obj, j5, obj2);
        }

        public boolean supportsUnsafeArrayOperations() {
            Unsafe unsafe = this.unsafe;
            if (unsafe == null) {
                return false;
            }
            try {
                Class<?> cls = unsafe.getClass();
                cls.getMethod("objectFieldOffset", Field.class);
                cls.getMethod("arrayBaseOffset", Class.class);
                cls.getMethod("arrayIndexScale", Class.class);
                Class cls2 = Long.TYPE;
                cls.getMethod("getInt", Object.class, cls2);
                cls.getMethod("putInt", Object.class, cls2, Integer.TYPE);
                cls.getMethod("getLong", Object.class, cls2);
                cls.getMethod("putLong", Object.class, cls2, cls2);
                cls.getMethod("getObject", Object.class, cls2);
                cls.getMethod("putObject", Object.class, cls2, Object.class);
                return true;
            } catch (Throwable th) {
                UnsafeUtil.logMissingMethod(th);
                return false;
            }
        }

        public boolean supportsUnsafeByteBufferOperations() {
            Unsafe unsafe = this.unsafe;
            if (unsafe == null) {
                return false;
            }
            try {
                Class<?> cls = unsafe.getClass();
                cls.getMethod("objectFieldOffset", Field.class);
                cls.getMethod("getLong", Object.class, Long.TYPE);
                return UnsafeUtil.access$100() != null;
            } catch (Throwable th) {
                UnsafeUtil.logMissingMethod(th);
                return false;
            }
        }
    }

    static {
        long arrayBaseOffset = arrayBaseOffset(byte[].class);
        BYTE_ARRAY_BASE_OFFSET = arrayBaseOffset;
        BOOLEAN_ARRAY_BASE_OFFSET = arrayBaseOffset(boolean[].class);
        BOOLEAN_ARRAY_INDEX_SCALE = arrayIndexScale(boolean[].class);
        INT_ARRAY_BASE_OFFSET = arrayBaseOffset(int[].class);
        INT_ARRAY_INDEX_SCALE = arrayIndexScale(int[].class);
        LONG_ARRAY_BASE_OFFSET = arrayBaseOffset(long[].class);
        LONG_ARRAY_INDEX_SCALE = arrayIndexScale(long[].class);
        FLOAT_ARRAY_BASE_OFFSET = arrayBaseOffset(float[].class);
        FLOAT_ARRAY_INDEX_SCALE = arrayIndexScale(float[].class);
        DOUBLE_ARRAY_BASE_OFFSET = arrayBaseOffset(double[].class);
        DOUBLE_ARRAY_INDEX_SCALE = arrayIndexScale(double[].class);
        OBJECT_ARRAY_BASE_OFFSET = arrayBaseOffset(Object[].class);
        OBJECT_ARRAY_INDEX_SCALE = arrayIndexScale(Object[].class);
        BUFFER_ADDRESS_OFFSET = fieldOffset(bufferAddressField());
        BYTE_ARRAY_ALIGNMENT = (int) (arrayBaseOffset & 7);
        IS_BIG_ENDIAN = ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN;
    }

    static /* synthetic */ Field access$100() {
        return bufferAddressField();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> T allocateInstance(Class<T> cls) {
        try {
            return (T) UNSAFE.allocateInstance(cls);
        } catch (InstantiationException e5) {
            throw new IllegalStateException(e5);
        }
    }

    private static int arrayBaseOffset(Class<?> cls) {
        if (HAS_UNSAFE_ARRAY_OPERATIONS) {
            return MEMORY_ACCESSOR.arrayBaseOffset(cls);
        }
        return -1;
    }

    private static int arrayIndexScale(Class<?> cls) {
        if (HAS_UNSAFE_ARRAY_OPERATIONS) {
            return MEMORY_ACCESSOR.arrayIndexScale(cls);
        }
        return -1;
    }

    private static Field bufferAddressField() {
        Field field;
        if (Android.isOnAndroidDevice() && (field = field(Buffer.class, "effectiveDirectAddress")) != null) {
            return field;
        }
        Field field2 = field(Buffer.class, "address");
        if (field2 == null || field2.getType() != Long.TYPE) {
            return null;
        }
        return field2;
    }

    static boolean determineAndroidSupportByAddressSize(Class<?> cls) {
        if (!Android.isOnAndroidDevice()) {
            return false;
        }
        try {
            Class<?> cls2 = MEMORY_CLASS;
            Class cls3 = Boolean.TYPE;
            cls2.getMethod("peekLong", cls, cls3);
            cls2.getMethod("pokeLong", cls, Long.TYPE, cls3);
            Class cls4 = Integer.TYPE;
            cls2.getMethod("pokeInt", cls, cls4, cls3);
            cls2.getMethod("peekInt", cls, cls3);
            cls2.getMethod("pokeByte", cls, Byte.TYPE);
            cls2.getMethod("peekByte", cls);
            cls2.getMethod("pokeByteArray", cls, byte[].class, cls4, cls4);
            cls2.getMethod("peekByteArray", cls, byte[].class, cls4, cls4);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    private static Field field(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    private static long fieldOffset(Field field) {
        MemoryAccessor memoryAccessor;
        if (field == null || (memoryAccessor = MEMORY_ACCESSOR) == null) {
            return -1L;
        }
        return memoryAccessor.objectFieldOffset(field);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean getBoolean(Object obj, long j5) {
        return MEMORY_ACCESSOR.getBoolean(obj, j5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean getBooleanBigEndian(Object obj, long j5) {
        return getByteBigEndian(obj, j5) != 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean getBooleanLittleEndian(Object obj, long j5) {
        return getByteLittleEndian(obj, j5) != 0;
    }

    private static byte getByteBigEndian(Object obj, long j5) {
        return (byte) ((getInt(obj, (-4) & j5) >>> ((int) (((~j5) & 3) << 3))) & Function.USE_VARARGS);
    }

    private static byte getByteLittleEndian(Object obj, long j5) {
        return (byte) ((getInt(obj, (-4) & j5) >>> ((int) ((j5 & 3) << 3))) & Function.USE_VARARGS);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static double getDouble(Object obj, long j5) {
        return MEMORY_ACCESSOR.getDouble(obj, j5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static float getFloat(Object obj, long j5) {
        return MEMORY_ACCESSOR.getFloat(obj, j5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int getInt(Object obj, long j5) {
        return MEMORY_ACCESSOR.getInt(obj, j5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long getLong(Object obj, long j5) {
        return MEMORY_ACCESSOR.getLong(obj, j5);
    }

    private static MemoryAccessor getMemoryAccessor() {
        Unsafe unsafe = UNSAFE;
        if (unsafe == null) {
            return null;
        }
        if (!Android.isOnAndroidDevice()) {
            return new JvmMemoryAccessor(unsafe);
        }
        if (IS_ANDROID_64) {
            return new Android64MemoryAccessor(unsafe);
        }
        if (IS_ANDROID_32) {
            return new Android32MemoryAccessor(unsafe);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object getObject(Object obj, long j5) {
        return MEMORY_ACCESSOR.getObject(obj, j5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Unsafe getUnsafe() {
        try {
            return (Unsafe) AccessController.doPrivileged(new PrivilegedExceptionAction<Unsafe>() { // from class: androidx.datastore.preferences.protobuf.UnsafeUtil.1
                @Override // java.security.PrivilegedExceptionAction
                public Unsafe run() {
                    for (Field field : Unsafe.class.getDeclaredFields()) {
                        field.setAccessible(true);
                        Object obj = field.get(null);
                        if (Unsafe.class.isInstance(obj)) {
                            return (Unsafe) Unsafe.class.cast(obj);
                        }
                    }
                    return null;
                }
            });
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean hasUnsafeArrayOperations() {
        return HAS_UNSAFE_ARRAY_OPERATIONS;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean hasUnsafeByteBufferOperations() {
        return HAS_UNSAFE_BYTEBUFFER_OPERATIONS;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void logMissingMethod(Throwable th) {
        Logger.getLogger(UnsafeUtil.class.getName()).log(Level.WARNING, "platform method missing - proto runtime falling back to safer methods: " + th);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void putBoolean(Object obj, long j5, boolean z5) {
        MEMORY_ACCESSOR.putBoolean(obj, j5, z5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void putBooleanBigEndian(Object obj, long j5, boolean z5) {
        putByteBigEndian(obj, j5, z5 ? (byte) 1 : (byte) 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void putBooleanLittleEndian(Object obj, long j5, boolean z5) {
        putByteLittleEndian(obj, j5, z5 ? (byte) 1 : (byte) 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void putByte(byte[] bArr, long j5, byte b5) {
        MEMORY_ACCESSOR.putByte(bArr, BYTE_ARRAY_BASE_OFFSET + j5, b5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void putByteBigEndian(Object obj, long j5, byte b5) {
        long j6 = (-4) & j5;
        int i5 = getInt(obj, j6);
        int i6 = ((~((int) j5)) & 3) << 3;
        putInt(obj, j6, ((255 & b5) << i6) | (i5 & (~(Function.USE_VARARGS << i6))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void putByteLittleEndian(Object obj, long j5, byte b5) {
        long j6 = (-4) & j5;
        int i5 = (((int) j5) & 3) << 3;
        putInt(obj, j6, ((255 & b5) << i5) | (getInt(obj, j6) & (~(Function.USE_VARARGS << i5))));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void putDouble(Object obj, long j5, double d5) {
        MEMORY_ACCESSOR.putDouble(obj, j5, d5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void putFloat(Object obj, long j5, float f5) {
        MEMORY_ACCESSOR.putFloat(obj, j5, f5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void putInt(Object obj, long j5, int i5) {
        MEMORY_ACCESSOR.putInt(obj, j5, i5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void putLong(Object obj, long j5, long j6) {
        MEMORY_ACCESSOR.putLong(obj, j5, j6);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void putObject(Object obj, long j5, Object obj2) {
        MEMORY_ACCESSOR.putObject(obj, j5, obj2);
    }

    private static boolean supportsUnsafeArrayOperations() {
        MemoryAccessor memoryAccessor = MEMORY_ACCESSOR;
        if (memoryAccessor == null) {
            return false;
        }
        return memoryAccessor.supportsUnsafeArrayOperations();
    }

    private static boolean supportsUnsafeByteBufferOperations() {
        MemoryAccessor memoryAccessor = MEMORY_ACCESSOR;
        if (memoryAccessor == null) {
            return false;
        }
        return memoryAccessor.supportsUnsafeByteBufferOperations();
    }
}
