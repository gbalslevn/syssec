package com.sun.jna;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.nio.Buffer;
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.conscrypt.BuildConfig;

/* loaded from: classes2.dex */
public abstract class Structure {
    public static final int ALIGN_DEFAULT = 0;
    public static final int ALIGN_GNUC = 2;
    public static final int ALIGN_MSVC = 3;
    public static final int ALIGN_NONE = 1;
    protected static final int CALCULATE_SIZE = -1;
    private int actualAlignType;
    private int alignType;
    private Structure[] array;
    private boolean autoRead;
    private boolean autoWrite;
    private String encoding;
    private Pointer memory;
    private final Map<String, NativeStringTracking> nativeStrings;
    private boolean readCalled;
    private int size;
    private int structAlignment;
    private Map<String, StructField> structFields;
    private long typeInfo;
    private TypeMapper typeMapper;
    private static final Logger LOG = Logger.getLogger(Structure.class.getName());
    static final Map<Class<?>, LayoutInfo> layoutInfo = new WeakHashMap();
    static final Map<Class<?>, List<String>> fieldOrder = new WeakHashMap();
    private static final ThreadLocal<Map<Pointer, Structure>> reads = new ThreadLocal<Map<Pointer, Structure>>() { // from class: com.sun.jna.Structure.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        public synchronized Map<Pointer, Structure> initialValue() {
            return new HashMap();
        }
    };
    private static final ThreadLocal<Set<Structure>> busy = new ThreadLocal<Set<Structure>>() { // from class: com.sun.jna.Structure.2
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        public synchronized Set<Structure> initialValue() {
            return new StructureSet();
        }
    };
    private static final Pointer PLACEHOLDER_MEMORY = new Pointer(0) { // from class: com.sun.jna.Structure.3
        @Override // com.sun.jna.Pointer
        public Pointer share(long j5, long j6) {
            return this;
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class AutoAllocated extends Memory {
        public AutoAllocated(int i5) {
            super(i5);
            super.clear();
        }

        @Override // com.sun.jna.Memory, com.sun.jna.Pointer
        public String toString() {
            return "auto-" + super.toString();
        }
    }

    /* loaded from: classes2.dex */
    public interface ByReference {
    }

    /* loaded from: classes2.dex */
    public interface ByValue {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @FieldOrder({"size", "alignment", "type", "elements"})
    /* loaded from: classes2.dex */
    public static class FFIType extends Structure {
        private static final int FFI_TYPE_STRUCT = 13;
        private static final Map<Pointer, FFIType> ffiTypeInfo;
        private static final Map<Class, Map<Integer, FFIType>> typeInfoMap = new WeakHashMap();
        private static final Map<Class, FFIType> unionHelper = new WeakHashMap();
        public short alignment;
        public Pointer elements;
        public size_t size;
        public short type;

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes2.dex */
        public static class FFITypes {
            private static Pointer ffi_type_double;
            private static Pointer ffi_type_float;
            private static Pointer ffi_type_longdouble;
            private static Pointer ffi_type_pointer;
            private static Pointer ffi_type_sint16;
            private static Pointer ffi_type_sint32;
            private static Pointer ffi_type_sint64;
            private static Pointer ffi_type_sint8;
            private static Pointer ffi_type_uint16;
            private static Pointer ffi_type_uint32;
            private static Pointer ffi_type_uint64;
            private static Pointer ffi_type_uint8;
            private static Pointer ffi_type_void;

            private FFITypes() {
            }
        }

        /* loaded from: classes2.dex */
        public static class size_t extends IntegerType {
            private static final long serialVersionUID = 1;

            public size_t() {
                this(0L);
            }

            public size_t(long j5) {
                super(Native.SIZE_T_SIZE, j5);
            }
        }

        static {
            HashMap hashMap = new HashMap();
            ffiTypeInfo = hashMap;
            if (Native.POINTER_SIZE == 0) {
                throw new Error("Native library not initialized");
            }
            if (FFITypes.ffi_type_void == null) {
                throw new Error("FFI types not initialized");
            }
            hashMap.put(FFITypes.ffi_type_void, Structure.newInstance(FFIType.class, FFITypes.ffi_type_void));
            hashMap.put(FFITypes.ffi_type_float, Structure.newInstance(FFIType.class, FFITypes.ffi_type_float));
            hashMap.put(FFITypes.ffi_type_double, Structure.newInstance(FFIType.class, FFITypes.ffi_type_double));
            hashMap.put(FFITypes.ffi_type_longdouble, Structure.newInstance(FFIType.class, FFITypes.ffi_type_longdouble));
            hashMap.put(FFITypes.ffi_type_uint8, Structure.newInstance(FFIType.class, FFITypes.ffi_type_uint8));
            hashMap.put(FFITypes.ffi_type_sint8, Structure.newInstance(FFIType.class, FFITypes.ffi_type_sint8));
            hashMap.put(FFITypes.ffi_type_uint16, Structure.newInstance(FFIType.class, FFITypes.ffi_type_uint16));
            hashMap.put(FFITypes.ffi_type_sint16, Structure.newInstance(FFIType.class, FFITypes.ffi_type_sint16));
            hashMap.put(FFITypes.ffi_type_uint32, Structure.newInstance(FFIType.class, FFITypes.ffi_type_uint32));
            hashMap.put(FFITypes.ffi_type_sint32, Structure.newInstance(FFIType.class, FFITypes.ffi_type_sint32));
            hashMap.put(FFITypes.ffi_type_uint64, Structure.newInstance(FFIType.class, FFITypes.ffi_type_uint64));
            hashMap.put(FFITypes.ffi_type_sint64, Structure.newInstance(FFIType.class, FFITypes.ffi_type_sint64));
            hashMap.put(FFITypes.ffi_type_pointer, Structure.newInstance(FFIType.class, FFITypes.ffi_type_pointer));
            Iterator it = hashMap.values().iterator();
            while (it.hasNext()) {
                ((FFIType) it.next()).read();
            }
            Class cls = Void.TYPE;
            Map<Pointer, FFIType> map = ffiTypeInfo;
            storeTypeInfo(cls, map.get(FFITypes.ffi_type_void));
            storeTypeInfo(Void.class, map.get(FFITypes.ffi_type_void));
            storeTypeInfo(Float.TYPE, map.get(FFITypes.ffi_type_float));
            storeTypeInfo(Float.class, map.get(FFITypes.ffi_type_float));
            storeTypeInfo(Double.TYPE, map.get(FFITypes.ffi_type_double));
            storeTypeInfo(Double.class, map.get(FFITypes.ffi_type_double));
            storeTypeInfo(Long.TYPE, map.get(FFITypes.ffi_type_sint64));
            storeTypeInfo(Long.class, map.get(FFITypes.ffi_type_sint64));
            storeTypeInfo(Integer.TYPE, map.get(FFITypes.ffi_type_sint32));
            storeTypeInfo(Integer.class, map.get(FFITypes.ffi_type_sint32));
            storeTypeInfo(Short.TYPE, map.get(FFITypes.ffi_type_sint16));
            storeTypeInfo(Short.class, map.get(FFITypes.ffi_type_sint16));
            FFIType fFIType = map.get(Native.WCHAR_SIZE == 2 ? FFITypes.ffi_type_uint16 : FFITypes.ffi_type_uint32);
            storeTypeInfo(Character.TYPE, fFIType);
            storeTypeInfo(Character.class, fFIType);
            storeTypeInfo(Byte.TYPE, map.get(FFITypes.ffi_type_sint8));
            storeTypeInfo(Byte.class, map.get(FFITypes.ffi_type_sint8));
            storeTypeInfo(Pointer.class, map.get(FFITypes.ffi_type_pointer));
            storeTypeInfo(String.class, map.get(FFITypes.ffi_type_pointer));
            storeTypeInfo(WString.class, map.get(FFITypes.ffi_type_pointer));
            storeTypeInfo(Boolean.TYPE, map.get(FFITypes.ffi_type_uint32));
            storeTypeInfo(Boolean.class, map.get(FFITypes.ffi_type_uint32));
        }

        public FFIType(FFIType fFIType) {
            this.type = (short) 13;
            this.size = fFIType.size;
            this.alignment = fFIType.alignment;
            this.type = fFIType.type;
            this.elements = fFIType.elements;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static FFIType get(Object obj) {
            FFIType typeInfo;
            if (obj == null) {
                synchronized (typeInfoMap) {
                    typeInfo = getTypeInfo(Pointer.class, 0);
                }
                return typeInfo;
            }
            if (obj instanceof Class) {
                return get(null, (Class) obj);
            }
            return get(obj, obj.getClass());
        }

        private static FFIType getTypeInfo(Class cls, int i5) {
            Map<Integer, FFIType> map = typeInfoMap.get(cls);
            if (map != null) {
                return map.get(Integer.valueOf(i5));
            }
            return null;
        }

        private void init(Pointer[] pointerArr) {
            Memory memory = new Memory(Native.POINTER_SIZE * pointerArr.length);
            this.elements = memory;
            memory.write(0L, pointerArr, 0, pointerArr.length);
            write();
        }

        private static boolean isFloatType(FFIType fFIType) {
            Pointer pointer = fFIType.getPointer();
            return pointer.equals(FFITypes.ffi_type_float) || pointer.equals(FFITypes.ffi_type_double);
        }

        private static boolean isIntegerType(FFIType fFIType) {
            Pointer pointer = fFIType.getPointer();
            return pointer.equals(FFITypes.ffi_type_uint8) || pointer.equals(FFITypes.ffi_type_sint8) || pointer.equals(FFITypes.ffi_type_uint16) || pointer.equals(FFITypes.ffi_type_sint16) || pointer.equals(FFITypes.ffi_type_uint32) || pointer.equals(FFITypes.ffi_type_sint32) || pointer.equals(FFITypes.ffi_type_uint64) || pointer.equals(FFITypes.ffi_type_sint64) || pointer.equals(FFITypes.ffi_type_pointer);
        }

        private static void storeTypeInfo(Class cls, FFIType fFIType) {
            storeTypeInfo(cls, 0, fFIType);
        }

        private static void storeTypeInfo(Class cls, int i5, FFIType fFIType) {
            Map<Class, Map<Integer, FFIType>> map = typeInfoMap;
            synchronized (map) {
                try {
                    Map<Integer, FFIType> map2 = map.get(cls);
                    if (map2 == null) {
                        map2 = new HashMap<>();
                        map.put(cls, map2);
                    }
                    map2.put(Integer.valueOf(i5), fFIType);
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public FFIType() {
            this.type = (short) 13;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static FFIType get(Object obj, Class<?> cls) {
            ToNativeConverter toNativeConverter;
            TypeMapper typeMapper = Native.getTypeMapper(cls);
            if (typeMapper != null && (toNativeConverter = typeMapper.getToNativeConverter(cls)) != null) {
                cls = toNativeConverter.nativeType();
            }
            Map<Class, Map<Integer, FFIType>> map = typeInfoMap;
            synchronized (map) {
                try {
                    FFIType typeInfo = getTypeInfo(cls, cls.isArray() ? Array.getLength(obj) : 0);
                    if (typeInfo != null) {
                        return typeInfo;
                    }
                    if ((Platform.HAS_BUFFERS && Buffer.class.isAssignableFrom(cls)) || Callback.class.isAssignableFrom(cls)) {
                        map.put(cls, map.get(Pointer.class));
                        return map.get(Pointer.class).get(0);
                    }
                    if (Structure.class.isAssignableFrom(cls)) {
                        if (obj == null) {
                            obj = Structure.newInstance(cls, Structure.PLACEHOLDER_MEMORY);
                        }
                        if (ByReference.class.isAssignableFrom(cls)) {
                            map.put(cls, map.get(Pointer.class));
                            return map.get(Pointer.class).get(0);
                        }
                        FFIType fFIType = new FFIType((Structure) obj);
                        storeTypeInfo(cls, fFIType);
                        return fFIType;
                    }
                    if (NativeMapped.class.isAssignableFrom(cls)) {
                        NativeMappedConverter nativeMappedConverter = NativeMappedConverter.getInstance(cls);
                        return get(nativeMappedConverter.toNative(obj, new ToNativeContext()), nativeMappedConverter.nativeType());
                    }
                    if (cls.isArray()) {
                        FFIType fFIType2 = new FFIType(obj, cls);
                        storeTypeInfo(cls, Array.getLength(obj), fFIType2);
                        return fFIType2;
                    }
                    throw new IllegalArgumentException("Unsupported type " + cls);
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public FFIType(Structure structure) {
            Pointer[] pointerArr;
            int i5;
            this.type = (short) 13;
            structure.ensureAllocated(true);
            int i6 = 0;
            if (structure instanceof Union) {
                int i7 = 0;
                boolean z5 = false;
                FFIType fFIType = null;
                for (StructField structField : structure.fields().values()) {
                    FFIType fieldTypeInfo = structure.getFieldTypeInfo(structField);
                    z5 = isIntegerType(fieldTypeInfo) ? true : z5;
                    if (fFIType == null || i7 < (i5 = structField.size) || (i7 == i5 && Structure.class.isAssignableFrom(structField.type))) {
                        i7 = structField.size;
                        fFIType = fieldTypeInfo;
                    }
                }
                if (((Platform.isIntel() && Platform.is64Bit() && !Platform.isWindows()) || Platform.isARM() || Platform.isLoongArch()) && z5 && isFloatType(fFIType)) {
                    FFIType fFIType2 = new FFIType(fFIType);
                    if (fFIType2.size.intValue() == 4) {
                        fFIType2.type = ffiTypeInfo.get(FFITypes.ffi_type_uint32).type;
                    } else if (fFIType2.size.intValue() == 8) {
                        fFIType2.type = ffiTypeInfo.get(FFITypes.ffi_type_uint64).type;
                    }
                    fFIType2.write();
                    fFIType = fFIType2;
                }
                pointerArr = new Pointer[]{fFIType.getPointer(), null};
                unionHelper.put(structure.getClass(), fFIType);
            } else {
                pointerArr = new Pointer[structure.fields().size() + 1];
                Iterator<StructField> it = structure.fields().values().iterator();
                while (it.hasNext()) {
                    pointerArr[i6] = structure.getFieldTypeInfo(it.next()).getPointer();
                    i6++;
                }
            }
            init(pointerArr);
            write();
        }

        public FFIType(Object obj, Class<?> cls) {
            this.type = (short) 13;
            int length = Array.getLength(obj);
            Pointer[] pointerArr = new Pointer[length + 1];
            Pointer pointer = get(null, cls.getComponentType()).getPointer();
            for (int i5 = 0; i5 < length; i5++) {
                pointerArr[i5] = pointer;
            }
            init(pointerArr);
            write();
        }
    }

    @Target({ElementType.TYPE})
    @Documented
    @Retention(RetentionPolicy.RUNTIME)
    /* loaded from: classes2.dex */
    public @interface FieldOrder {
        String[] value();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class LayoutInfo {
        private int alignType;
        private int alignment;
        private final Map<String, StructField> fields;
        private int size;
        private TypeMapper typeMapper;
        private boolean variable;

        private LayoutInfo() {
            this.size = -1;
            this.alignment = 1;
            this.fields = Collections.synchronizedMap(new LinkedHashMap());
            this.alignType = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class NativeStringTracking {
        private NativeString peer;
        private final Object value;

        NativeStringTracking(Object obj) {
            this.value = obj;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes2.dex */
    public static class StructField {
        public FromNativeContext context;
        public Field field;
        public boolean isReadOnly;
        public boolean isVolatile;
        public String name;
        public FromNativeConverter readConverter;
        public Class<?> type;
        public ToNativeConverter writeConverter;
        public int size = -1;
        public int offset = -1;

        protected StructField() {
        }

        public String toString() {
            return this.name + "@" + this.offset + "[" + this.size + "] (" + this.type + ")";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class StructureSet extends AbstractCollection<Structure> implements Set<Structure> {
        private int count;
        Structure[] elements;

        StructureSet() {
        }

        private void ensureCapacity(int i5) {
            Structure[] structureArr = this.elements;
            if (structureArr == null) {
                this.elements = new Structure[(i5 * 3) / 2];
            } else if (structureArr.length < i5) {
                Structure[] structureArr2 = new Structure[(i5 * 3) / 2];
                System.arraycopy(structureArr, 0, structureArr2, 0, structureArr.length);
                this.elements = structureArr2;
            }
        }

        private int indexOf(Structure structure) {
            for (int i5 = 0; i5 < this.count; i5++) {
                Structure structure2 = this.elements[i5];
                if (structure == structure2 || (structure.getClass() == structure2.getClass() && structure.size() == structure2.size() && structure.getPointer().equals(structure2.getPointer()))) {
                    return i5;
                }
            }
            return -1;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return indexOf((Structure) obj) != -1;
        }

        public Structure[] getElements() {
            return this.elements;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Structure> iterator() {
            int i5 = this.count;
            Structure[] structureArr = new Structure[i5];
            if (i5 > 0) {
                System.arraycopy(this.elements, 0, structureArr, 0, i5);
            }
            return Arrays.asList(structureArr).iterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            int indexOf = indexOf((Structure) obj);
            if (indexOf == -1) {
                return false;
            }
            int i5 = this.count - 1;
            this.count = i5;
            if (i5 >= 0) {
                Structure[] structureArr = this.elements;
                structureArr[indexOf] = structureArr[i5];
                structureArr[i5] = null;
            }
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.count;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean add(Structure structure) {
            if (contains(structure)) {
                return false;
            }
            ensureCapacity(this.count + 1);
            Structure[] structureArr = this.elements;
            int i5 = this.count;
            this.count = i5 + 1;
            structureArr[i5] = structure;
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Structure() {
        this(0);
    }

    private int addPadding(int i5) {
        return addPadding(i5, this.structAlignment);
    }

    public static void autoRead(Structure[] structureArr) {
        structureArrayCheck(structureArr);
        Structure structure = structureArr[0];
        if (structure.array == structureArr) {
            structure.autoRead();
            return;
        }
        for (Structure structure2 : structureArr) {
            if (structure2 != null) {
                structure2.autoRead();
            }
        }
    }

    public static void autoWrite(Structure[] structureArr) {
        structureArrayCheck(structureArr);
        Structure structure = structureArr[0];
        if (structure.array == structureArr) {
            structure.autoWrite();
            return;
        }
        for (Structure structure2 : structureArr) {
            if (structure2 != null) {
                structure2.autoWrite();
            }
        }
    }

    private Class<?> baseClass() {
        return (((this instanceof ByReference) || (this instanceof ByValue)) && Structure.class.isAssignableFrom(getClass().getSuperclass())) ? getClass().getSuperclass() : getClass();
    }

    static Set<Structure> busy() {
        return busy.get();
    }

    public static List<String> createFieldsOrder(List<String> list, String... strArr) {
        return createFieldsOrder(list, (List<String>) Arrays.asList(strArr));
    }

    private LayoutInfo deriveLayout(boolean z5, boolean z6) {
        Class<?> cls;
        List<Field> fields = getFields(z5);
        if (fields == null) {
            return null;
        }
        LayoutInfo layoutInfo2 = new LayoutInfo();
        layoutInfo2.alignType = this.alignType;
        layoutInfo2.typeMapper = this.typeMapper;
        boolean z7 = true;
        boolean z8 = true;
        int i5 = 0;
        for (Field field : fields) {
            int modifiers = field.getModifiers();
            Class<?> type = field.getType();
            if (type.isArray()) {
                layoutInfo2.variable = z7;
            }
            StructField structField = new StructField();
            structField.isVolatile = Modifier.isVolatile(modifiers);
            boolean isFinal = Modifier.isFinal(modifiers);
            structField.isReadOnly = isFinal;
            if (isFinal) {
                if (!Platform.RO_FIELDS) {
                    throw new IllegalArgumentException("This VM does not support read-only fields (field '" + field.getName() + "' within " + getClass() + ")");
                }
                field.setAccessible(z7);
            }
            structField.field = field;
            structField.name = field.getName();
            structField.type = type;
            if (Callback.class.isAssignableFrom(type) && !type.isInterface()) {
                throw new IllegalArgumentException("Structure Callback field '" + field.getName() + "' must be an interface");
            }
            if (type.isArray() && Structure.class.equals(type.getComponentType())) {
                throw new IllegalArgumentException("Nested Structure arrays must use a derived Structure type so that the size of the elements can be determined");
            }
            if (Modifier.isPublic(field.getModifiers())) {
                Object fieldValue = getFieldValue(structField.field);
                if (fieldValue == null && type.isArray()) {
                    if (z5) {
                        throw new IllegalStateException("Array fields must be initialized");
                    }
                    return null;
                }
                if (NativeMapped.class.isAssignableFrom(type)) {
                    NativeMappedConverter nativeMappedConverter = NativeMappedConverter.getInstance(type);
                    cls = nativeMappedConverter.nativeType();
                    structField.writeConverter = nativeMappedConverter;
                    structField.readConverter = nativeMappedConverter;
                    structField.context = new StructureReadContext(this, field);
                } else {
                    TypeMapper typeMapper = this.typeMapper;
                    if (typeMapper != null) {
                        ToNativeConverter toNativeConverter = typeMapper.getToNativeConverter(type);
                        FromNativeConverter fromNativeConverter = this.typeMapper.getFromNativeConverter(type);
                        if (toNativeConverter != null && fromNativeConverter != null) {
                            fieldValue = toNativeConverter.toNative(fieldValue, new StructureWriteContext(this, structField.field));
                            Class cls2 = fieldValue != null ? fieldValue.getClass() : Pointer.class;
                            structField.writeConverter = toNativeConverter;
                            structField.readConverter = fromNativeConverter;
                            structField.context = new StructureReadContext(this, field);
                            cls = cls2;
                        } else if (toNativeConverter != null || fromNativeConverter != null) {
                            throw new IllegalArgumentException("Structures require bidirectional type conversion for " + type);
                        }
                    }
                    cls = type;
                }
                if (fieldValue == null) {
                    fieldValue = initializeField(structField.field, type);
                }
                try {
                    structField.size = getNativeSize(cls, fieldValue);
                    int nativeAlignment = getNativeAlignment(cls, fieldValue, z8);
                    if (nativeAlignment == 0) {
                        throw new Error("Field alignment is zero for field '" + structField.name + "' within " + getClass());
                    }
                    layoutInfo2.alignment = Math.max(layoutInfo2.alignment, nativeAlignment);
                    int i6 = i5 % nativeAlignment;
                    if (i6 != 0) {
                        i5 += nativeAlignment - i6;
                    }
                    if (this instanceof Union) {
                        structField.offset = 0;
                        i5 = Math.max(i5, structField.size);
                    } else {
                        structField.offset = i5;
                        i5 += structField.size;
                    }
                    layoutInfo2.fields.put(structField.name, structField);
                } catch (IllegalArgumentException e5) {
                    if (!z5 && this.typeMapper == null) {
                        return null;
                    }
                    throw new IllegalArgumentException("Invalid Structure field in " + getClass() + ", field name '" + structField.name + "' (" + structField.type + "): " + e5.getMessage(), e5);
                }
            }
            z8 = false;
            z7 = true;
        }
        if (i5 <= 0) {
            throw new IllegalArgumentException("Structure " + getClass() + " has unknown or zero size (ensure all fields are public)");
        }
        int addPadding = addPadding(i5, layoutInfo2.alignment);
        if ((this instanceof ByValue) && !z6) {
            getTypeInfo();
        }
        layoutInfo2.size = addPadding;
        return layoutInfo2;
    }

    private List<String> fieldOrder() {
        List<String> list;
        Class<?> cls = getClass();
        Map<Class<?>, List<String>> map = fieldOrder;
        synchronized (map) {
            try {
                list = map.get(cls);
                if (list == null) {
                    list = getFieldOrder();
                    map.put(cls, list);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return list;
    }

    private String format(Class<?> cls) {
        String name = cls.getName();
        return name.substring(name.lastIndexOf(".") + 1);
    }

    private static <T> Constructor<T> getPointerConstructor(Class<T> cls) {
        for (Object obj : cls.getConstructors()) {
            Constructor<T> constructor = (Constructor<T>) obj;
            Class<?>[] parameterTypes = constructor.getParameterTypes();
            if (parameterTypes.length == 1 && parameterTypes[0].equals(Pointer.class)) {
                return constructor;
            }
        }
        return null;
    }

    private Object initializeField(Field field, Class<?> cls) {
        if (!Structure.class.isAssignableFrom(cls) || ByReference.class.isAssignableFrom(cls)) {
            if (!NativeMapped.class.isAssignableFrom(cls)) {
                return null;
            }
            NativeMapped defaultValue = NativeMappedConverter.getInstance(cls).defaultValue();
            setFieldValue(field, defaultValue);
            return defaultValue;
        }
        try {
            Structure newInstance = newInstance((Class<Structure>) cls, PLACEHOLDER_MEMORY);
            setFieldValue(field, newInstance);
            return newInstance;
        } catch (IllegalArgumentException e5) {
            throw new IllegalArgumentException("Can't determine size of nested structure", e5);
        }
    }

    private void initializeFields() {
        for (Field field : getFieldList()) {
            try {
                if (field.get(this) == null) {
                    initializeField(field, field.getType());
                }
            } catch (Exception e5) {
                throw new Error("Exception reading field '" + field.getName() + "' in " + getClass(), e5);
            }
        }
    }

    private void initializeTypeMapper(TypeMapper typeMapper) {
        if (typeMapper == null) {
            typeMapper = Native.getTypeMapper(getClass());
        }
        this.typeMapper = typeMapper;
        layoutChanged();
    }

    private void layoutChanged() {
        if (this.size != -1) {
            this.size = -1;
            if (this.memory instanceof AutoAllocated) {
                this.memory = null;
            }
            ensureAllocated();
        }
    }

    private static <T extends Structure> T newInstance(Class<T> cls, long j5) {
        try {
            T t5 = (T) newInstance(cls, j5 == 0 ? PLACEHOLDER_MEMORY : new Pointer(j5));
            if (j5 != 0) {
                t5.conditionalAutoRead();
            }
            return t5;
        } catch (Throwable th) {
            LOG.log(Level.WARNING, "JNA: Error creating structure", th);
            return null;
        }
    }

    static Map<Pointer, Structure> reading() {
        return reads.get();
    }

    private static <T extends Comparable<T>> List<T> sort(Collection<? extends T> collection) {
        ArrayList arrayList = new ArrayList(collection);
        Collections.sort(arrayList);
        return arrayList;
    }

    private static void structureArrayCheck(Structure[] structureArr) {
        if (ByReference[].class.isAssignableFrom(structureArr.getClass())) {
            return;
        }
        Pointer pointer = structureArr[0].getPointer();
        int size = structureArr[0].size();
        for (int i5 = 1; i5 < structureArr.length; i5++) {
            if (structureArr[i5].getPointer().peer != pointer.peer + (size * i5)) {
                throw new IllegalArgumentException("Structure array elements must use contiguous memory (bad backing address at Structure array index " + i5 + ")");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T extends Structure> T updateStructureByReference(Class<T> cls, T t5, Pointer pointer) {
        if (pointer == null) {
            return null;
        }
        if (t5 != null && pointer.equals(t5.getPointer())) {
            t5.autoRead();
            return t5;
        }
        T t6 = (T) reading().get(pointer);
        if (t6 != null && cls.equals(t6.getClass())) {
            t6.autoRead();
            return t6;
        }
        T t7 = (T) newInstance(cls, pointer);
        t7.conditionalAutoRead();
        return t7;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void validate(Class<? extends Structure> cls) {
        try {
            cls.getConstructor(null);
        } catch (NoSuchMethodException | SecurityException unused) {
            throw new IllegalArgumentException("No suitable constructor found for class: " + cls.getName());
        }
    }

    private void validateField(String str, Class<?> cls) {
        ToNativeConverter toNativeConverter;
        TypeMapper typeMapper = this.typeMapper;
        if (typeMapper != null && (toNativeConverter = typeMapper.getToNativeConverter(cls)) != null) {
            validateField(str, toNativeConverter.nativeType());
            return;
        }
        if (cls.isArray()) {
            validateField(str, cls.getComponentType());
            return;
        }
        try {
            getNativeSize(cls);
        } catch (IllegalArgumentException e5) {
            throw new IllegalArgumentException("Invalid Structure field in " + getClass() + ", field name '" + str + "' (" + cls + "): " + e5.getMessage(), e5);
        }
    }

    private void validateFields() {
        for (Field field : getFieldList()) {
            validateField(field.getName(), field.getType());
        }
    }

    protected void allocateMemory() {
        allocateMemory(false);
    }

    protected Memory autoAllocate(int i5) {
        return new AutoAllocated(i5);
    }

    protected void cacheTypeInfo(Pointer pointer) {
        this.typeInfo = pointer.peer;
    }

    protected int calculateSize(boolean z5) {
        return calculateSize(z5, false);
    }

    public void clear() {
        ensureAllocated();
        this.nativeStrings.clear();
        this.memory.clear(size());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void conditionalAutoRead() {
        if (this.readCalled) {
            return;
        }
        autoRead();
    }

    public boolean dataEquals(Structure structure) {
        return dataEquals(structure, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ensureAllocated() {
        ensureAllocated(false);
    }

    public boolean equals(Object obj) {
        return (obj instanceof Structure) && obj.getClass() == getClass() && ((Structure) obj).getPointer().equals(getPointer());
    }

    protected int fieldOffset(String str) {
        ensureAllocated();
        StructField structField = fields().get(str);
        if (structField != null) {
            return structField.offset;
        }
        throw new IllegalArgumentException("No such field: " + str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Map<String, StructField> fields() {
        return this.structFields;
    }

    public boolean getAutoRead() {
        return this.autoRead;
    }

    public boolean getAutoWrite() {
        return this.autoWrite;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public List<Field> getFieldList() {
        ArrayList arrayList = new ArrayList();
        for (Class<?> cls = getClass(); !cls.equals(Structure.class); cls = cls.getSuperclass()) {
            ArrayList arrayList2 = new ArrayList();
            Field[] declaredFields = cls.getDeclaredFields();
            for (int i5 = 0; i5 < declaredFields.length; i5++) {
                int modifiers = declaredFields[i5].getModifiers();
                if (!Modifier.isStatic(modifiers) && Modifier.isPublic(modifiers)) {
                    arrayList2.add(declaredFields[i5]);
                }
            }
            arrayList.addAll(0, arrayList2);
        }
        return arrayList;
    }

    protected List<String> getFieldOrder() {
        LinkedList linkedList = new LinkedList();
        for (Class<?> cls = getClass(); cls != Structure.class; cls = cls.getSuperclass()) {
            FieldOrder fieldOrder2 = (FieldOrder) cls.getAnnotation(FieldOrder.class);
            if (fieldOrder2 != null) {
                linkedList.addAll(0, Arrays.asList(fieldOrder2.value()));
            }
        }
        return Collections.unmodifiableList(linkedList);
    }

    FFIType getFieldTypeInfo(StructField structField) {
        ToNativeConverter toNativeConverter;
        Class<?> cls = structField.type;
        Object fieldValue = getFieldValue(structField.field);
        TypeMapper typeMapper = this.typeMapper;
        if (typeMapper != null && (toNativeConverter = typeMapper.getToNativeConverter(cls)) != null) {
            cls = toNativeConverter.nativeType();
            fieldValue = toNativeConverter.toNative(fieldValue, new ToNativeContext());
        }
        return FFIType.get(fieldValue, cls);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Object getFieldValue(Field field) {
        try {
            return field.get(this);
        } catch (Exception e5) {
            throw new Error("Exception reading field '" + field.getName() + "' in " + getClass(), e5);
        }
    }

    protected List<Field> getFields(boolean z5) {
        List<Field> fieldList = getFieldList();
        HashSet hashSet = new HashSet();
        Iterator<Field> it = fieldList.iterator();
        while (it.hasNext()) {
            hashSet.add(it.next().getName());
        }
        List<String> fieldOrder2 = fieldOrder();
        if (fieldOrder2.size() == fieldList.size() || fieldList.size() <= 1) {
            if (new HashSet(fieldOrder2).equals(hashSet)) {
                sortFields(fieldList, fieldOrder2);
                return fieldList;
            }
            throw new Error("Structure.getFieldOrder() on " + getClass() + " returns names (" + sort(fieldOrder2) + ") which do not match declared field names (" + sort(hashSet) + ")");
        }
        if (!z5) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Structure.getFieldOrder() on ");
        sb.append(getClass());
        sb.append(fieldOrder2.size() < fieldList.size() ? " does not provide enough" : " provides too many");
        sb.append(" names [");
        sb.append(fieldOrder2.size());
        sb.append("] (");
        sb.append(sort(fieldOrder2));
        sb.append(") to match declared fields [");
        sb.append(fieldList.size());
        sb.append("] (");
        sb.append(sort(hashSet));
        sb.append(")");
        throw new Error(sb.toString());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getNativeAlignment(Class<?> cls, Object obj, boolean z5) {
        if (NativeMapped.class.isAssignableFrom(cls)) {
            NativeMappedConverter nativeMappedConverter = NativeMappedConverter.getInstance(cls);
            Class<?> nativeType = nativeMappedConverter.nativeType();
            obj = nativeMappedConverter.toNative(obj, new ToNativeContext());
            cls = nativeType;
        }
        int nativeSize = Native.getNativeSize(cls, obj);
        if (!cls.isPrimitive() && Long.class != cls && Integer.class != cls && Short.class != cls && Character.class != cls && Byte.class != cls && Boolean.class != cls && Float.class != cls && Double.class != cls) {
            if ((Pointer.class.isAssignableFrom(cls) && !Function.class.isAssignableFrom(cls)) || ((Platform.HAS_BUFFERS && Buffer.class.isAssignableFrom(cls)) || Callback.class.isAssignableFrom(cls) || WString.class == cls || String.class == cls)) {
                nativeSize = Native.POINTER_SIZE;
            } else if (Structure.class.isAssignableFrom(cls)) {
                if (ByReference.class.isAssignableFrom(cls)) {
                    nativeSize = Native.POINTER_SIZE;
                } else {
                    if (obj == null) {
                        obj = newInstance(cls, PLACEHOLDER_MEMORY);
                    }
                    nativeSize = ((Structure) obj).getStructAlignment();
                }
            } else {
                if (!cls.isArray()) {
                    throw new IllegalArgumentException("Type " + cls + " has unknown native alignment");
                }
                nativeSize = getNativeAlignment(cls.getComponentType(), null, z5);
            }
        }
        int i5 = this.actualAlignType;
        if (i5 == 1) {
            return 1;
        }
        if (i5 == 3) {
            return Math.min(8, nativeSize);
        }
        if (i5 != 2) {
            return nativeSize;
        }
        if (!z5 || !Platform.isMac() || !Platform.isPPC()) {
            nativeSize = Math.min(Native.MAX_ALIGNMENT, nativeSize);
        }
        if (z5 || !Platform.isAIX()) {
            return nativeSize;
        }
        if (cls == Double.TYPE || cls == Double.class) {
            return 4;
        }
        return nativeSize;
    }

    protected int getNativeSize(Class<?> cls) {
        return getNativeSize(cls, null);
    }

    public Pointer getPointer() {
        ensureAllocated();
        return this.memory;
    }

    protected String getStringEncoding() {
        return this.encoding;
    }

    protected int getStructAlignment() {
        if (this.size == -1) {
            calculateSize(true);
        }
        return this.structAlignment;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Pointer getTypeInfo() {
        Pointer pointer = getTypeInfo(this).getPointer();
        cacheTypeInfo(pointer);
        return pointer;
    }

    TypeMapper getTypeMapper() {
        return this.typeMapper;
    }

    public int hashCode() {
        return getPointer() != null ? getPointer().hashCode() : getClass().hashCode();
    }

    public void read() {
        if (this.memory == PLACEHOLDER_MEMORY) {
            return;
        }
        this.readCalled = true;
        ensureAllocated();
        if (busy().add(this)) {
            boolean z5 = this instanceof ByReference;
            if (z5) {
                reading().put(getPointer(), this);
            }
            try {
                Iterator<StructField> it = fields().values().iterator();
                while (it.hasNext()) {
                    readField(it.next());
                }
            } finally {
                busy().remove(this);
                if (z5 && reading().get(getPointer()) == this) {
                    reading().remove(getPointer());
                }
            }
        }
    }

    public Object readField(String str) {
        ensureAllocated();
        StructField structField = fields().get(str);
        if (structField != null) {
            return readField(structField);
        }
        throw new IllegalArgumentException("No such field: " + str);
    }

    protected void setAlignType(int i5) {
        this.alignType = i5;
        if (i5 == 0 && (i5 = Native.getStructureAlignment(getClass())) == 0) {
            i5 = Platform.isWindows() ? 3 : 2;
        }
        this.actualAlignType = i5;
        layoutChanged();
    }

    public void setAutoRead(boolean z5) {
        this.autoRead = z5;
    }

    public void setAutoSynch(boolean z5) {
        setAutoRead(z5);
        setAutoWrite(z5);
    }

    public void setAutoWrite(boolean z5) {
        this.autoWrite = z5;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setFieldValue(Field field, Object obj) {
        setFieldValue(field, obj, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setStringEncoding(String str) {
        this.encoding = str;
    }

    public int size() {
        ensureAllocated();
        return this.size;
    }

    protected void sortFields(List<Field> list, List<String> list2) {
        for (int i5 = 0; i5 < list2.size(); i5++) {
            String str = list2.get(i5);
            int i6 = 0;
            while (true) {
                if (i6 >= list.size()) {
                    break;
                }
                if (str.equals(list.get(i6).getName())) {
                    Collections.swap(list, i5, i6);
                    break;
                }
                i6++;
            }
        }
    }

    public Structure[] toArray(Structure[] structureArr) {
        ensureAllocated();
        Pointer pointer = this.memory;
        if (pointer instanceof AutoAllocated) {
            int length = structureArr.length * size();
            if (((Memory) pointer).size() < length) {
                useMemory(autoAllocate(length));
            }
        }
        structureArr[0] = this;
        int size = size();
        for (int i5 = 1; i5 < structureArr.length; i5++) {
            Structure newInstance = newInstance((Class<Structure>) getClass(), this.memory.share(i5 * size, size));
            structureArr[i5] = newInstance;
            newInstance.conditionalAutoRead();
        }
        if (!(this instanceof ByValue)) {
            this.array = structureArr;
        }
        return structureArr;
    }

    public String toString() {
        return toString(Boolean.getBoolean("jna.dump_memory"));
    }

    protected void useMemory(Pointer pointer) {
        useMemory(pointer, 0);
    }

    public void write() {
        if (this.memory == PLACEHOLDER_MEMORY) {
            return;
        }
        ensureAllocated();
        if (this instanceof ByValue) {
            getTypeInfo();
        }
        if (busy().add(this)) {
            try {
                for (StructField structField : fields().values()) {
                    if (!structField.isVolatile) {
                        writeField(structField);
                    }
                }
            } finally {
                busy().remove(this);
            }
        }
    }

    public void writeField(String str) {
        ensureAllocated();
        StructField structField = fields().get(str);
        if (structField != null) {
            writeField(structField);
            return;
        }
        throw new IllegalArgumentException("No such field: " + str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Structure(TypeMapper typeMapper) {
        this(null, 0, typeMapper);
    }

    private int addPadding(int i5, int i6) {
        int i7;
        return (this.actualAlignType == 1 || (i7 = i5 % i6) == 0) ? i5 : i5 + (i6 - i7);
    }

    private void allocateMemory(boolean z5) {
        allocateMemory(calculateSize(true, z5));
    }

    public static List<String> createFieldsOrder(List<String> list, List<String> list2) {
        ArrayList arrayList = new ArrayList(list.size() + list2.size());
        arrayList.addAll(list);
        arrayList.addAll(list2);
        return Collections.unmodifiableList(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ensureAllocated(boolean z5) {
        if (this.memory == null) {
            allocateMemory(z5);
            return;
        }
        if (this.size == -1) {
            int calculateSize = calculateSize(true, z5);
            this.size = calculateSize;
            Pointer pointer = this.memory;
            if (pointer instanceof AutoAllocated) {
                return;
            }
            try {
                this.memory = pointer.share(0L, calculateSize);
            } catch (IndexOutOfBoundsException e5) {
                throw new IllegalArgumentException("Structure exceeds provided memory bounds", e5);
            }
        }
    }

    private void setFieldValue(Field field, Object obj, boolean z5) {
        try {
            field.set(this, obj);
        } catch (IllegalAccessException e5) {
            if (!Modifier.isFinal(field.getModifiers())) {
                throw new Error("Unexpectedly unable to write to field '" + field.getName() + "' within " + getClass(), e5);
            }
            if (z5) {
                throw new UnsupportedOperationException("This VM does not support Structures with final fields (field '" + field.getName() + "' within " + getClass() + ")", e5);
            }
            throw new UnsupportedOperationException("Attempt to write to read-only field '" + field.getName() + "' within " + getClass(), e5);
        }
    }

    int calculateSize(boolean z5, boolean z6) {
        LayoutInfo layoutInfo2;
        Class<?> cls = getClass();
        Map<Class<?>, LayoutInfo> map = layoutInfo;
        synchronized (map) {
            layoutInfo2 = map.get(cls);
        }
        if (layoutInfo2 == null || this.alignType != layoutInfo2.alignType || this.typeMapper != layoutInfo2.typeMapper) {
            layoutInfo2 = deriveLayout(z5, z6);
        }
        if (layoutInfo2 == null) {
            return -1;
        }
        this.structAlignment = layoutInfo2.alignment;
        this.structFields = layoutInfo2.fields;
        if (!layoutInfo2.variable) {
            synchronized (map) {
                try {
                    if (map.containsKey(cls)) {
                        if (this.alignType == 0) {
                            if (this.typeMapper != null) {
                            }
                        }
                    }
                    map.put(cls, layoutInfo2);
                } finally {
                }
            }
        }
        return layoutInfo2.size;
    }

    public boolean dataEquals(Structure structure, boolean z5) {
        if (z5) {
            structure.getPointer().clear(structure.size());
            structure.write();
            getPointer().clear(size());
            write();
        }
        byte[] byteArray = structure.getPointer().getByteArray(0L, structure.size());
        byte[] byteArray2 = getPointer().getByteArray(0L, size());
        if (byteArray.length != byteArray2.length) {
            return false;
        }
        for (int i5 = 0; i5 < byteArray.length; i5++) {
            if (byteArray[i5] != byteArray2[i5]) {
                return false;
            }
        }
        return true;
    }

    protected int getNativeSize(Class<?> cls, Object obj) {
        return Native.getNativeSize(cls, obj);
    }

    public String toString(boolean z5) {
        return toString(0, true, z5);
    }

    protected void useMemory(Pointer pointer, int i5) {
        useMemory(pointer, i5, false);
    }

    protected Structure(int i5) {
        this((Pointer) null, i5);
    }

    static FFIType getTypeInfo(Object obj) {
        return FFIType.get(obj);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int size(Class<? extends Structure> cls) {
        return size(cls, null);
    }

    private String toString(int i5, boolean z5, boolean z6) {
        String str;
        String str2;
        String str3;
        ensureAllocated();
        String lineSeparator = System.lineSeparator();
        String str4 = format(getClass()) + "(" + getPointer() + ")";
        if (!(getPointer() instanceof Memory)) {
            str4 = str4 + " (" + size() + " bytes)";
        }
        String str5 = BuildConfig.FLAVOR;
        for (int i6 = 0; i6 < i5; i6++) {
            str5 = str5 + "  ";
        }
        if (!z5) {
            str = "...}";
        } else {
            Iterator<StructField> it = fields().values().iterator();
            String str6 = lineSeparator;
            while (it.hasNext()) {
                StructField next = it.next();
                Object fieldValue = getFieldValue(next.field);
                String format = format(next.type);
                String str7 = str6 + str5;
                if (!next.type.isArray() || fieldValue == null) {
                    str2 = BuildConfig.FLAVOR;
                } else {
                    format = format(next.type.getComponentType());
                    str2 = "[" + Array.getLength(fieldValue) + "]";
                }
                String str8 = str7 + String.format("  %s %s%s@0x%X", format, next.name, str2, Integer.valueOf(next.offset));
                if (fieldValue instanceof Structure) {
                    fieldValue = ((Structure) fieldValue).toString(i5 + 1, !(fieldValue instanceof ByReference), z6);
                }
                String str9 = str8 + "=";
                if (fieldValue instanceof Long) {
                    str3 = str9 + String.format("0x%08X", (Long) fieldValue);
                } else if (fieldValue instanceof Integer) {
                    str3 = str9 + String.format("0x%04X", (Integer) fieldValue);
                } else if (fieldValue instanceof Short) {
                    str3 = str9 + String.format("0x%02X", (Short) fieldValue);
                } else if (fieldValue instanceof Byte) {
                    str3 = str9 + String.format("0x%01X", (Byte) fieldValue);
                } else {
                    str3 = str9 + String.valueOf(fieldValue).trim();
                }
                String str10 = str3 + lineSeparator;
                if (!it.hasNext()) {
                    str10 = str10 + str5 + "}";
                }
                str6 = str10;
            }
            str = str6;
        }
        if (i5 == 0 && z6) {
            String str11 = str + lineSeparator + "memory dump" + lineSeparator;
            byte[] byteArray = getPointer().getByteArray(0L, size());
            for (int i7 = 0; i7 < byteArray.length; i7++) {
                int i8 = i7 % 4;
                if (i8 == 0) {
                    str11 = str11 + "[";
                }
                byte b5 = byteArray[i7];
                if (b5 >= 0 && b5 < 16) {
                    str11 = str11 + "0";
                }
                str11 = str11 + Integer.toHexString(byteArray[i7] & 255);
                if (i8 == 3 && i7 < byteArray.length - 1) {
                    str11 = str11 + "]" + lineSeparator;
                }
            }
            str = str11 + "]";
        }
        return str4 + " {" + str;
    }

    protected void allocateMemory(int i5) {
        if (i5 == -1) {
            i5 = calculateSize(false);
        } else if (i5 <= 0) {
            throw new IllegalArgumentException("Structure size must be greater than zero: " + i5);
        }
        if (i5 != -1) {
            Pointer pointer = this.memory;
            if (pointer == null || (pointer instanceof AutoAllocated)) {
                this.memory = autoAllocate(i5);
            }
            this.size = i5;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void useMemory(Pointer pointer, int i5, boolean z5) {
        try {
            this.nativeStrings.clear();
            if ((this instanceof ByValue) && !z5) {
                int size = size();
                byte[] bArr = new byte[size];
                pointer.read(0L, bArr, 0, size);
                this.memory.write(0L, bArr, 0, size);
            } else {
                if (this.size == -1) {
                    this.size = calculateSize(false);
                }
                int i6 = this.size;
                if (i6 != -1) {
                    this.memory = pointer.share(i5, i6);
                } else {
                    this.memory = pointer.share(i5);
                }
            }
            this.array = null;
            this.readCalled = false;
        } catch (IndexOutOfBoundsException e5) {
            throw new IllegalArgumentException("Structure exceeds provided memory bounds", e5);
        }
    }

    protected Structure(int i5, TypeMapper typeMapper) {
        this(null, i5, typeMapper);
    }

    public static <T extends Structure> T newInstance(Class<T> cls, Pointer pointer) {
        try {
            Constructor pointerConstructor = getPointerConstructor(cls);
            if (pointerConstructor != null) {
                return (T) pointerConstructor.newInstance(pointer);
            }
        } catch (IllegalAccessException e5) {
            throw new IllegalArgumentException("Instantiation of " + cls + " (Pointer) not allowed, is it public?", e5);
        } catch (InstantiationException e6) {
            throw new IllegalArgumentException("Can't instantiate " + cls, e6);
        } catch (SecurityException unused) {
        } catch (InvocationTargetException e7) {
            throw new IllegalArgumentException("Exception thrown while instantiating an instance of " + cls, e7);
        }
        T t5 = (T) newInstance(cls);
        if (pointer != PLACEHOLDER_MEMORY) {
            t5.useMemory(pointer);
        }
        return t5;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T extends Structure> int size(Class<T> cls, T t5) {
        LayoutInfo layoutInfo2;
        Map<Class<?>, LayoutInfo> map = layoutInfo;
        synchronized (map) {
            layoutInfo2 = map.get(cls);
        }
        int i5 = (layoutInfo2 == null || layoutInfo2.variable) ? -1 : layoutInfo2.size;
        if (i5 != -1) {
            return i5;
        }
        if (t5 == null) {
            t5 = (T) newInstance(cls, PLACEHOLDER_MEMORY);
        }
        return t5.size();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Structure(Pointer pointer) {
        this(pointer, 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Object readField(StructField structField) {
        int i5 = structField.offset;
        Class<?> cls = structField.type;
        FromNativeConverter fromNativeConverter = structField.readConverter;
        if (fromNativeConverter != null) {
            cls = fromNativeConverter.nativeType();
        }
        Object obj = null;
        Object fieldValue = (Structure.class.isAssignableFrom(cls) || Callback.class.isAssignableFrom(cls) || (Platform.HAS_BUFFERS && Buffer.class.isAssignableFrom(cls)) || Pointer.class.isAssignableFrom(cls) || NativeMapped.class.isAssignableFrom(cls) || cls.isArray()) ? getFieldValue(structField.field) : null;
        if (cls == String.class) {
            Pointer pointer = this.memory.getPointer(i5);
            if (pointer != null) {
                obj = pointer.getString(0L, this.encoding);
            }
        } else {
            obj = this.memory.getValue(i5, cls, fieldValue);
        }
        if (fromNativeConverter != null) {
            Object fromNative = fromNativeConverter.fromNative(obj, structField.context);
            if (fieldValue == null || !fieldValue.equals(fromNative)) {
                fieldValue = fromNative;
            }
        } else {
            fieldValue = obj;
        }
        if (cls.equals(String.class) || cls.equals(WString.class)) {
            if (fieldValue != null) {
                NativeStringTracking nativeStringTracking = new NativeStringTracking(fieldValue);
                NativeStringTracking put = this.nativeStrings.put(structField.name, nativeStringTracking);
                if (put != null) {
                    nativeStringTracking.peer = put.peer;
                }
            } else {
                this.nativeStrings.remove(structField.name);
            }
        }
        setFieldValue(structField.field, fieldValue, true);
        return fieldValue;
    }

    public void writeField(String str, Object obj) {
        ensureAllocated();
        StructField structField = fields().get(str);
        if (structField != null) {
            setFieldValue(structField.field, obj);
            writeField(structField, obj);
        } else {
            throw new IllegalArgumentException("No such field: " + str);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Structure(Pointer pointer, int i5) {
        this(pointer, i5, null);
    }

    public static List<String> createFieldsOrder(String str) {
        return Collections.unmodifiableList(Collections.singletonList(str));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Structure(Pointer pointer, int i5, TypeMapper typeMapper) {
        this.size = -1;
        this.nativeStrings = new HashMap(8);
        this.autoRead = true;
        this.autoWrite = true;
        setAlignType(i5);
        setStringEncoding(Native.getStringEncoding(getClass()));
        initializeTypeMapper(typeMapper);
        validateFields();
        if (pointer != null) {
            useMemory(pointer, 0, true);
        } else {
            allocateMemory(-1);
        }
        initializeFields();
    }

    public static List<String> createFieldsOrder(String... strArr) {
        return Collections.unmodifiableList(Arrays.asList(strArr));
    }

    public void autoRead() {
        if (!getAutoRead()) {
            return;
        }
        read();
        if (this.array == null) {
            return;
        }
        int i5 = 1;
        while (true) {
            Structure[] structureArr = this.array;
            if (i5 >= structureArr.length) {
                return;
            }
            structureArr[i5].autoRead();
            i5++;
        }
    }

    public void autoWrite() {
        if (!getAutoWrite()) {
            return;
        }
        write();
        if (this.array == null) {
            return;
        }
        int i5 = 1;
        while (true) {
            Structure[] structureArr = this.array;
            if (i5 >= structureArr.length) {
                return;
            }
            structureArr[i5].autoWrite();
            i5++;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void writeField(StructField structField) {
        if (structField.isReadOnly) {
            return;
        }
        writeField(structField, getFieldValue(structField.field));
    }

    private void writeField(StructField structField, Object obj) {
        NativeString nativeString;
        String str;
        int i5 = structField.offset;
        Class<?> cls = structField.type;
        ToNativeConverter toNativeConverter = structField.writeConverter;
        if (toNativeConverter != null) {
            obj = toNativeConverter.toNative(obj, new StructureWriteContext(this, structField.field));
            cls = toNativeConverter.nativeType();
        }
        if (String.class == cls || WString.class == cls) {
            if (obj != null) {
                NativeStringTracking nativeStringTracking = new NativeStringTracking(obj);
                NativeStringTracking put = this.nativeStrings.put(structField.name, nativeStringTracking);
                if (put != null && obj.equals(put.value)) {
                    nativeStringTracking.peer = put.peer;
                    return;
                }
                if (cls == WString.class) {
                    nativeString = new NativeString(obj.toString(), true);
                } else {
                    nativeString = new NativeString(obj.toString(), this.encoding);
                }
                nativeStringTracking.peer = nativeString;
                obj = nativeString.getPointer();
            } else {
                this.nativeStrings.remove(structField.name);
            }
        }
        try {
            this.memory.setValue(i5, obj, cls);
        } catch (IllegalArgumentException e5) {
            StringBuilder sb = new StringBuilder();
            sb.append("Structure field \"");
            sb.append(structField.name);
            sb.append("\" was declared as ");
            sb.append(structField.type);
            if (structField.type == cls) {
                str = BuildConfig.FLAVOR;
            } else {
                str = " (native type " + cls + ")";
            }
            sb.append(str);
            sb.append(", which is not supported within a Structure");
            throw new IllegalArgumentException(sb.toString(), e5);
        }
    }

    public Structure[] toArray(int i5) {
        return toArray((Structure[]) Array.newInstance(getClass(), i5));
    }

    public static <T extends Structure> T newInstance(Class<T> cls) {
        T t5 = (T) Klass.newInstance(cls);
        if (t5 instanceof ByValue) {
            t5.allocateMemory();
        }
        return t5;
    }
}
