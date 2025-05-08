package com.sun.jna;

import com.sun.jna.Structure;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Array;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public class Pointer {
    public static final Pointer NULL = null;
    protected long peer;

    /* loaded from: classes2.dex */
    private static class Opaque extends Pointer {
        private final String MSG;

        @Override // com.sun.jna.Pointer
        public void clear(long j5) {
            throw new UnsupportedOperationException(this.MSG);
        }

        @Override // com.sun.jna.Pointer
        public String dump(long j5, int i5) {
            throw new UnsupportedOperationException(this.MSG);
        }

        @Override // com.sun.jna.Pointer
        public byte getByte(long j5) {
            throw new UnsupportedOperationException(this.MSG);
        }

        @Override // com.sun.jna.Pointer
        public ByteBuffer getByteBuffer(long j5, long j6) {
            throw new UnsupportedOperationException(this.MSG);
        }

        @Override // com.sun.jna.Pointer
        public char getChar(long j5) {
            throw new UnsupportedOperationException(this.MSG);
        }

        @Override // com.sun.jna.Pointer
        public double getDouble(long j5) {
            throw new UnsupportedOperationException(this.MSG);
        }

        @Override // com.sun.jna.Pointer
        public float getFloat(long j5) {
            throw new UnsupportedOperationException(this.MSG);
        }

        @Override // com.sun.jna.Pointer
        public int getInt(long j5) {
            throw new UnsupportedOperationException(this.MSG);
        }

        @Override // com.sun.jna.Pointer
        public long getLong(long j5) {
            throw new UnsupportedOperationException(this.MSG);
        }

        @Override // com.sun.jna.Pointer
        public Pointer getPointer(long j5) {
            throw new UnsupportedOperationException(this.MSG);
        }

        @Override // com.sun.jna.Pointer
        public short getShort(long j5) {
            throw new UnsupportedOperationException(this.MSG);
        }

        @Override // com.sun.jna.Pointer
        public String getString(long j5, String str) {
            throw new UnsupportedOperationException(this.MSG);
        }

        @Override // com.sun.jna.Pointer
        public String getWideString(long j5) {
            throw new UnsupportedOperationException(this.MSG);
        }

        @Override // com.sun.jna.Pointer
        public long indexOf(long j5, byte b5) {
            throw new UnsupportedOperationException(this.MSG);
        }

        @Override // com.sun.jna.Pointer
        public void read(long j5, byte[] bArr, int i5, int i6) {
            throw new UnsupportedOperationException(this.MSG);
        }

        @Override // com.sun.jna.Pointer
        public void setByte(long j5, byte b5) {
            throw new UnsupportedOperationException(this.MSG);
        }

        @Override // com.sun.jna.Pointer
        public void setChar(long j5, char c5) {
            throw new UnsupportedOperationException(this.MSG);
        }

        @Override // com.sun.jna.Pointer
        public void setDouble(long j5, double d5) {
            throw new UnsupportedOperationException(this.MSG);
        }

        @Override // com.sun.jna.Pointer
        public void setFloat(long j5, float f5) {
            throw new UnsupportedOperationException(this.MSG);
        }

        @Override // com.sun.jna.Pointer
        public void setInt(long j5, int i5) {
            throw new UnsupportedOperationException(this.MSG);
        }

        @Override // com.sun.jna.Pointer
        public void setLong(long j5, long j6) {
            throw new UnsupportedOperationException(this.MSG);
        }

        @Override // com.sun.jna.Pointer
        public void setMemory(long j5, long j6, byte b5) {
            throw new UnsupportedOperationException(this.MSG);
        }

        @Override // com.sun.jna.Pointer
        public void setPointer(long j5, Pointer pointer) {
            throw new UnsupportedOperationException(this.MSG);
        }

        @Override // com.sun.jna.Pointer
        public void setShort(long j5, short s5) {
            throw new UnsupportedOperationException(this.MSG);
        }

        @Override // com.sun.jna.Pointer
        public void setString(long j5, String str, String str2) {
            throw new UnsupportedOperationException(this.MSG);
        }

        @Override // com.sun.jna.Pointer
        public void setWideString(long j5, String str) {
            throw new UnsupportedOperationException(this.MSG);
        }

        @Override // com.sun.jna.Pointer
        public Pointer share(long j5, long j6) {
            throw new UnsupportedOperationException(this.MSG);
        }

        @Override // com.sun.jna.Pointer
        public String toString() {
            return "const@0x" + Long.toHexString(this.peer);
        }

        @Override // com.sun.jna.Pointer
        public void write(long j5, byte[] bArr, int i5, int i6) {
            throw new UnsupportedOperationException(this.MSG);
        }

        private Opaque(long j5) {
            super(j5);
            this.MSG = "This pointer is opaque: " + this;
        }

        @Override // com.sun.jna.Pointer
        public void read(long j5, char[] cArr, int i5, int i6) {
            throw new UnsupportedOperationException(this.MSG);
        }

        @Override // com.sun.jna.Pointer
        public void write(long j5, char[] cArr, int i5, int i6) {
            throw new UnsupportedOperationException(this.MSG);
        }

        @Override // com.sun.jna.Pointer
        public void read(long j5, short[] sArr, int i5, int i6) {
            throw new UnsupportedOperationException(this.MSG);
        }

        @Override // com.sun.jna.Pointer
        public void write(long j5, short[] sArr, int i5, int i6) {
            throw new UnsupportedOperationException(this.MSG);
        }

        @Override // com.sun.jna.Pointer
        public void read(long j5, int[] iArr, int i5, int i6) {
            throw new UnsupportedOperationException(this.MSG);
        }

        @Override // com.sun.jna.Pointer
        public void write(long j5, int[] iArr, int i5, int i6) {
            throw new UnsupportedOperationException(this.MSG);
        }

        @Override // com.sun.jna.Pointer
        public void read(long j5, long[] jArr, int i5, int i6) {
            throw new UnsupportedOperationException(this.MSG);
        }

        @Override // com.sun.jna.Pointer
        public void write(long j5, long[] jArr, int i5, int i6) {
            throw new UnsupportedOperationException(this.MSG);
        }

        @Override // com.sun.jna.Pointer
        public void read(long j5, float[] fArr, int i5, int i6) {
            throw new UnsupportedOperationException(this.MSG);
        }

        @Override // com.sun.jna.Pointer
        public void write(long j5, float[] fArr, int i5, int i6) {
            throw new UnsupportedOperationException(this.MSG);
        }

        @Override // com.sun.jna.Pointer
        public void read(long j5, double[] dArr, int i5, int i6) {
            throw new UnsupportedOperationException(this.MSG);
        }

        @Override // com.sun.jna.Pointer
        public void write(long j5, double[] dArr, int i5, int i6) {
            throw new UnsupportedOperationException(this.MSG);
        }

        @Override // com.sun.jna.Pointer
        public void read(long j5, Pointer[] pointerArr, int i5, int i6) {
            throw new UnsupportedOperationException(this.MSG);
        }

        @Override // com.sun.jna.Pointer
        public void write(long j5, Pointer[] pointerArr, int i5, int i6) {
            throw new UnsupportedOperationException(this.MSG);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Pointer() {
    }

    public static final Pointer createConstant(long j5) {
        return new Opaque(j5);
    }

    public static long nativeValue(Pointer pointer) {
        if (pointer == null) {
            return 0L;
        }
        return pointer.peer;
    }

    private void readArray(long j5, Object obj, Class<?> cls) {
        int length = Array.getLength(obj);
        if (cls == Byte.TYPE) {
            read(j5, (byte[]) obj, 0, length);
            return;
        }
        if (cls == Short.TYPE) {
            read(j5, (short[]) obj, 0, length);
            return;
        }
        if (cls == Character.TYPE) {
            read(j5, (char[]) obj, 0, length);
            return;
        }
        if (cls == Integer.TYPE) {
            read(j5, (int[]) obj, 0, length);
            return;
        }
        if (cls == Long.TYPE) {
            read(j5, (long[]) obj, 0, length);
            return;
        }
        if (cls == Float.TYPE) {
            read(j5, (float[]) obj, 0, length);
            return;
        }
        if (cls == Double.TYPE) {
            read(j5, (double[]) obj, 0, length);
            return;
        }
        if (Pointer.class.isAssignableFrom(cls)) {
            read(j5, (Pointer[]) obj, 0, length);
            return;
        }
        int i5 = 0;
        if (!Structure.class.isAssignableFrom(cls)) {
            if (!NativeMapped.class.isAssignableFrom(cls)) {
                throw new IllegalArgumentException("Reading array of " + cls + " from memory not supported");
            }
            NativeMapped[] nativeMappedArr = (NativeMapped[]) obj;
            NativeMappedConverter nativeMappedConverter = NativeMappedConverter.getInstance(cls);
            int nativeSize = Native.getNativeSize(obj.getClass(), obj) / nativeMappedArr.length;
            while (i5 < nativeMappedArr.length) {
                nativeMappedArr[i5] = (NativeMapped) nativeMappedConverter.fromNative(getValue((nativeSize * i5) + j5, nativeMappedConverter.nativeType(), nativeMappedArr[i5]), new FromNativeContext(cls));
                i5++;
            }
            return;
        }
        Structure[] structureArr = (Structure[]) obj;
        if (Structure.ByReference.class.isAssignableFrom(cls)) {
            Pointer[] pointerArray = getPointerArray(j5, structureArr.length);
            while (i5 < structureArr.length) {
                structureArr[i5] = Structure.updateStructureByReference(cls, structureArr[i5], pointerArray[i5]);
                i5++;
            }
            return;
        }
        Structure structure = structureArr[0];
        if (structure == null) {
            structure = Structure.newInstance((Class<Structure>) cls, share(j5));
            structure.conditionalAutoRead();
            structureArr[0] = structure;
        } else {
            structure.useMemory(this, (int) j5, true);
            structure.read();
        }
        Structure[] array = structure.toArray(structureArr.length);
        for (int i6 = 1; i6 < structureArr.length; i6++) {
            Structure structure2 = structureArr[i6];
            if (structure2 == null) {
                structureArr[i6] = array[i6];
            } else {
                structure2.useMemory(this, (int) ((structure2.size() * i6) + j5), true);
                structureArr[i6].read();
            }
        }
    }

    private void writeArray(long j5, Object obj, Class<?> cls) {
        if (cls == Byte.TYPE) {
            byte[] bArr = (byte[]) obj;
            write(j5, bArr, 0, bArr.length);
            return;
        }
        if (cls == Short.TYPE) {
            short[] sArr = (short[]) obj;
            write(j5, sArr, 0, sArr.length);
            return;
        }
        if (cls == Character.TYPE) {
            char[] cArr = (char[]) obj;
            write(j5, cArr, 0, cArr.length);
            return;
        }
        if (cls == Integer.TYPE) {
            int[] iArr = (int[]) obj;
            write(j5, iArr, 0, iArr.length);
            return;
        }
        if (cls == Long.TYPE) {
            long[] jArr = (long[]) obj;
            write(j5, jArr, 0, jArr.length);
            return;
        }
        if (cls == Float.TYPE) {
            float[] fArr = (float[]) obj;
            write(j5, fArr, 0, fArr.length);
            return;
        }
        if (cls == Double.TYPE) {
            double[] dArr = (double[]) obj;
            write(j5, dArr, 0, dArr.length);
            return;
        }
        if (Pointer.class.isAssignableFrom(cls)) {
            Pointer[] pointerArr = (Pointer[]) obj;
            write(j5, pointerArr, 0, pointerArr.length);
            return;
        }
        int i5 = 0;
        if (!Structure.class.isAssignableFrom(cls)) {
            if (!NativeMapped.class.isAssignableFrom(cls)) {
                throw new IllegalArgumentException("Writing array of " + cls + " to memory not supported");
            }
            NativeMapped[] nativeMappedArr = (NativeMapped[]) obj;
            NativeMappedConverter nativeMappedConverter = NativeMappedConverter.getInstance(cls);
            Class<?> nativeType = nativeMappedConverter.nativeType();
            int nativeSize = Native.getNativeSize(obj.getClass(), obj) / nativeMappedArr.length;
            while (i5 < nativeMappedArr.length) {
                setValue((i5 * nativeSize) + j5, nativeMappedConverter.toNative(nativeMappedArr[i5], new ToNativeContext()), nativeType);
                i5++;
            }
            return;
        }
        Structure[] structureArr = (Structure[]) obj;
        if (Structure.ByReference.class.isAssignableFrom(cls)) {
            int length = structureArr.length;
            Pointer[] pointerArr2 = new Pointer[length];
            while (i5 < structureArr.length) {
                Structure structure = structureArr[i5];
                if (structure == null) {
                    pointerArr2[i5] = null;
                } else {
                    pointerArr2[i5] = structure.getPointer();
                    structureArr[i5].write();
                }
                i5++;
            }
            write(j5, pointerArr2, 0, length);
            return;
        }
        Structure structure2 = structureArr[0];
        if (structure2 == null) {
            structure2 = Structure.newInstance((Class<Structure>) cls, share(j5));
            structureArr[0] = structure2;
        } else {
            structure2.useMemory(this, (int) j5, true);
        }
        structure2.write();
        Structure[] array = structure2.toArray(structureArr.length);
        for (int i6 = 1; i6 < structureArr.length; i6++) {
            Structure structure3 = structureArr[i6];
            if (structure3 == null) {
                structureArr[i6] = array[i6];
            } else {
                structure3.useMemory(this, (int) ((structure3.size() * i6) + j5), true);
            }
            structureArr[i6].write();
        }
    }

    public void clear(long j5) {
        setMemory(0L, j5, (byte) 0);
    }

    public String dump(long j5, int i5) {
        StringWriter stringWriter = new StringWriter(13 + (i5 * 2) + ((i5 / 4) * 4));
        PrintWriter printWriter = new PrintWriter(stringWriter);
        printWriter.println("memory dump");
        for (int i6 = 0; i6 < i5; i6++) {
            byte b5 = getByte(i6 + j5);
            int i7 = i6 % 4;
            if (i7 == 0) {
                printWriter.print("[");
            }
            if (b5 >= 0 && b5 < 16) {
                printWriter.print("0");
            }
            printWriter.print(Integer.toHexString(b5 & 255));
            if (i7 == 3 && i6 < i5 - 1) {
                printWriter.println("]");
            }
        }
        if (stringWriter.getBuffer().charAt(stringWriter.getBuffer().length() - 2) != ']') {
            printWriter.println("]");
        }
        return stringWriter.toString();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        return (obj instanceof Pointer) && ((Pointer) obj).peer == this.peer;
    }

    public byte getByte(long j5) {
        return Native.getByte(this, this.peer, j5);
    }

    public byte[] getByteArray(long j5, int i5) {
        byte[] bArr = new byte[i5];
        read(j5, bArr, 0, i5);
        return bArr;
    }

    public ByteBuffer getByteBuffer(long j5, long j6) {
        return Native.getDirectByteBuffer(this, this.peer, j5, j6).order(ByteOrder.nativeOrder());
    }

    public char getChar(long j5) {
        return Native.getChar(this, this.peer, j5);
    }

    public char[] getCharArray(long j5, int i5) {
        char[] cArr = new char[i5];
        read(j5, cArr, 0, i5);
        return cArr;
    }

    public double getDouble(long j5) {
        return Native.getDouble(this, this.peer, j5);
    }

    public double[] getDoubleArray(long j5, int i5) {
        double[] dArr = new double[i5];
        read(j5, dArr, 0, i5);
        return dArr;
    }

    public float getFloat(long j5) {
        return Native.getFloat(this, this.peer, j5);
    }

    public float[] getFloatArray(long j5, int i5) {
        float[] fArr = new float[i5];
        read(j5, fArr, 0, i5);
        return fArr;
    }

    public int getInt(long j5) {
        return Native.getInt(this, this.peer, j5);
    }

    public int[] getIntArray(long j5, int i5) {
        int[] iArr = new int[i5];
        read(j5, iArr, 0, i5);
        return iArr;
    }

    public long getLong(long j5) {
        return Native.getLong(this, this.peer, j5);
    }

    public long[] getLongArray(long j5, int i5) {
        long[] jArr = new long[i5];
        read(j5, jArr, 0, i5);
        return jArr;
    }

    public NativeLong getNativeLong(long j5) {
        return new NativeLong(NativeLong.SIZE == 8 ? getLong(j5) : getInt(j5));
    }

    public Pointer getPointer(long j5) {
        return Native.getPointer(this.peer + j5);
    }

    public Pointer[] getPointerArray(long j5) {
        ArrayList arrayList = new ArrayList();
        Pointer pointer = getPointer(j5);
        int i5 = 0;
        while (pointer != null) {
            arrayList.add(pointer);
            i5 += Native.POINTER_SIZE;
            pointer = getPointer(i5 + j5);
        }
        return (Pointer[]) arrayList.toArray(new Pointer[0]);
    }

    public short getShort(long j5) {
        return Native.getShort(this, this.peer, j5);
    }

    public short[] getShortArray(long j5, int i5) {
        short[] sArr = new short[i5];
        read(j5, sArr, 0, i5);
        return sArr;
    }

    public String getString(long j5) {
        return getString(j5, Native.getDefaultStringEncoding());
    }

    public String[] getStringArray(long j5) {
        return getStringArray(j5, -1, Native.getDefaultStringEncoding());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0095, code lost:
    
        if (r5.peer == r1.peer) goto L60;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v12, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v14, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v22, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r5v23, types: [com.sun.jna.Pointer] */
    /* JADX WARN: Type inference failed for: r5v24 */
    /* JADX WARN: Type inference failed for: r5v27, types: [com.sun.jna.Structure] */
    /* JADX WARN: Type inference failed for: r8v10, types: [com.sun.jna.NativeMapped, java.lang.Object] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object getValue(long j5, Class<?> cls, Object obj) {
        Object fromNative;
        if (!Structure.class.isAssignableFrom(cls)) {
            if (cls == Boolean.TYPE || cls == Boolean.class) {
                return Function.valueOf(getInt(j5) != 0);
            }
            if (cls == Byte.TYPE || cls == Byte.class) {
                return Byte.valueOf(getByte(j5));
            }
            if (cls == Short.TYPE || cls == Short.class) {
                return Short.valueOf(getShort(j5));
            }
            if (cls == Character.TYPE || cls == Character.class) {
                return Character.valueOf(getChar(j5));
            }
            if (cls == Integer.TYPE || cls == Integer.class) {
                return Integer.valueOf(getInt(j5));
            }
            if (cls == Long.TYPE || cls == Long.class) {
                return Long.valueOf(getLong(j5));
            }
            if (cls == Float.TYPE || cls == Float.class) {
                return Float.valueOf(getFloat(j5));
            }
            if (cls == Double.TYPE || cls == Double.class) {
                return Double.valueOf(getDouble(j5));
            }
            if (Pointer.class.isAssignableFrom(cls)) {
                fromNative = getPointer(j5);
                if (fromNative != 0) {
                    r1 = obj instanceof Pointer ? (Pointer) obj : null;
                    if (r1 != null) {
                    }
                }
                return r1;
            }
            if (cls == String.class) {
                Pointer pointer = getPointer(j5);
                if (pointer != null) {
                    fromNative = pointer.getString(0L);
                }
                return r1;
            }
            if (cls == WString.class) {
                Pointer pointer2 = getPointer(j5);
                if (pointer2 != null) {
                    return new WString(pointer2.getWideString(0L));
                }
            } else if (Callback.class.isAssignableFrom(cls)) {
                Pointer pointer3 = getPointer(j5);
                if (pointer3 != null) {
                    Callback callback = (Callback) obj;
                    return !pointer3.equals(CallbackReference.getFunctionPointer(callback)) ? CallbackReference.getCallback(cls, pointer3) : callback;
                }
            } else if (Platform.HAS_BUFFERS && Buffer.class.isAssignableFrom(cls)) {
                Pointer pointer4 = getPointer(j5);
                if (pointer4 != null) {
                    r1 = obj != null ? Native.getDirectBufferPointer((Buffer) obj) : null;
                    if (r1 == null || !r1.equals(pointer4)) {
                        throw new IllegalStateException("Can't autogenerate a direct buffer on memory read");
                    }
                    return obj;
                }
            } else {
                if (!NativeMapped.class.isAssignableFrom(cls)) {
                    if (cls.isArray()) {
                        if (obj == null) {
                            throw new IllegalStateException("Need an initialized array");
                        }
                        readArray(j5, obj, cls.getComponentType());
                        return obj;
                    }
                    throw new IllegalArgumentException("Reading \"" + cls + "\" from memory is not supported");
                }
                ?? r8 = (NativeMapped) obj;
                if (r8 != 0) {
                    fromNative = r8.fromNative(getValue(j5, r8.nativeType(), null), new FromNativeContext(cls));
                    if (r8.equals(fromNative)) {
                        return r8;
                    }
                } else {
                    NativeMappedConverter nativeMappedConverter = NativeMappedConverter.getInstance(cls);
                    fromNative = nativeMappedConverter.fromNative(getValue(j5, nativeMappedConverter.nativeType(), null), new FromNativeContext(cls));
                }
            }
            return r1;
        }
        Structure structure = (Structure) obj;
        if (!Structure.ByReference.class.isAssignableFrom(cls)) {
            structure.useMemory(this, (int) j5, true);
            structure.read();
            return structure;
        }
        fromNative = Structure.updateStructureByReference(cls, structure, getPointer(j5));
        return fromNative;
    }

    public String getWideString(long j5) {
        return Native.getWideString(this, this.peer, j5);
    }

    public String[] getWideStringArray(long j5) {
        return getWideStringArray(j5, -1);
    }

    public int hashCode() {
        long j5 = this.peer;
        return (int) ((j5 >>> 32) + (j5 & 4294967295L));
    }

    public long indexOf(long j5, byte b5) {
        return Native.indexOf(this, this.peer, j5, b5);
    }

    public void read(long j5, byte[] bArr, int i5, int i6) {
        Native.read(this, this.peer, j5, bArr, i5, i6);
    }

    public void setByte(long j5, byte b5) {
        Native.setByte(this, this.peer, j5, b5);
    }

    public void setChar(long j5, char c5) {
        Native.setChar(this, this.peer, j5, c5);
    }

    public void setDouble(long j5, double d5) {
        Native.setDouble(this, this.peer, j5, d5);
    }

    public void setFloat(long j5, float f5) {
        Native.setFloat(this, this.peer, j5, f5);
    }

    public void setInt(long j5, int i5) {
        Native.setInt(this, this.peer, j5, i5);
    }

    public void setLong(long j5, long j6) {
        Native.setLong(this, this.peer, j5, j6);
    }

    public void setMemory(long j5, long j6, byte b5) {
        Native.setMemory(this, this.peer, j5, j6, b5);
    }

    public void setNativeLong(long j5, NativeLong nativeLong) {
        if (NativeLong.SIZE == 8) {
            setLong(j5, nativeLong.longValue());
        } else {
            setInt(j5, nativeLong.intValue());
        }
    }

    public void setPointer(long j5, Pointer pointer) {
        Native.setPointer(this, this.peer, j5, pointer != null ? pointer.peer : 0L);
    }

    public void setShort(long j5, short s5) {
        Native.setShort(this, this.peer, j5, s5);
    }

    public void setString(long j5, WString wString) {
        setWideString(j5, wString == null ? null : wString.toString());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setValue(long j5, Object obj, Class<?> cls) {
        if (cls == Boolean.TYPE || cls == Boolean.class) {
            setInt(j5, Boolean.TRUE.equals(obj) ? -1 : 0);
            return;
        }
        if (cls == Byte.TYPE || cls == Byte.class) {
            setByte(j5, obj != null ? ((Byte) obj).byteValue() : (byte) 0);
            return;
        }
        if (cls == Short.TYPE || cls == Short.class) {
            setShort(j5, obj != null ? ((Short) obj).shortValue() : (short) 0);
            return;
        }
        if (cls == Character.TYPE || cls == Character.class) {
            setChar(j5, obj != null ? ((Character) obj).charValue() : (char) 0);
            return;
        }
        if (cls == Integer.TYPE || cls == Integer.class) {
            setInt(j5, obj != null ? ((Integer) obj).intValue() : 0);
            return;
        }
        if (cls == Long.TYPE || cls == Long.class) {
            setLong(j5, obj == null ? 0L : ((Long) obj).longValue());
            return;
        }
        if (cls == Float.TYPE || cls == Float.class) {
            setFloat(j5, obj == null ? 0.0f : ((Float) obj).floatValue());
            return;
        }
        if (cls == Double.TYPE || cls == Double.class) {
            setDouble(j5, obj == null ? 0.0d : ((Double) obj).doubleValue());
            return;
        }
        if (cls == Pointer.class) {
            setPointer(j5, (Pointer) obj);
            return;
        }
        if (cls == String.class) {
            setPointer(j5, (Pointer) obj);
            return;
        }
        if (cls == WString.class) {
            setPointer(j5, (Pointer) obj);
            return;
        }
        if (Structure.class.isAssignableFrom(cls)) {
            Structure structure = (Structure) obj;
            if (!Structure.ByReference.class.isAssignableFrom(cls)) {
                structure.useMemory(this, (int) j5, true);
                structure.write();
                return;
            } else {
                setPointer(j5, structure != null ? structure.getPointer() : null);
                if (structure != null) {
                    structure.autoWrite();
                    return;
                }
                return;
            }
        }
        if (Callback.class.isAssignableFrom(cls)) {
            setPointer(j5, CallbackReference.getFunctionPointer((Callback) obj));
            return;
        }
        if (Platform.HAS_BUFFERS && Buffer.class.isAssignableFrom(cls)) {
            setPointer(j5, obj != null ? Native.getDirectBufferPointer((Buffer) obj) : null);
            return;
        }
        if (NativeMapped.class.isAssignableFrom(cls)) {
            NativeMappedConverter nativeMappedConverter = NativeMappedConverter.getInstance(cls);
            setValue(j5, nativeMappedConverter.toNative(obj, new ToNativeContext()), nativeMappedConverter.nativeType());
        } else {
            if (cls.isArray()) {
                writeArray(j5, obj, cls.getComponentType());
                return;
            }
            throw new IllegalArgumentException("Writing " + cls + " to memory is not supported");
        }
    }

    public void setWideString(long j5, String str) {
        Native.setWideString(this, this.peer, j5, str);
    }

    public Pointer share(long j5) {
        return share(j5, 0L);
    }

    public String toString() {
        return "native@0x" + Long.toHexString(this.peer);
    }

    public void write(long j5, byte[] bArr, int i5, int i6) {
        Native.write(this, this.peer, j5, bArr, i5, i6);
    }

    public Pointer(long j5) {
        this.peer = j5;
    }

    public static final Pointer createConstant(int i5) {
        return new Opaque(i5 & 4294967295L);
    }

    public static void nativeValue(Pointer pointer, long j5) {
        pointer.peer = j5;
    }

    public String getString(long j5, String str) {
        return Native.getString(this, j5, str);
    }

    public String[] getStringArray(long j5, String str) {
        return getStringArray(j5, -1, str);
    }

    public String[] getWideStringArray(long j5, int i5) {
        return getStringArray(j5, i5, "--WIDE-STRING--");
    }

    public void read(long j5, short[] sArr, int i5, int i6) {
        Native.read(this, this.peer, j5, sArr, i5, i6);
    }

    public void setString(long j5, String str) {
        setString(j5, str, Native.getDefaultStringEncoding());
    }

    public Pointer share(long j5, long j6) {
        return j5 == 0 ? this : new Pointer(this.peer + j5);
    }

    public void write(long j5, short[] sArr, int i5, int i6) {
        Native.write(this, this.peer, j5, sArr, i5, i6);
    }

    public String[] getStringArray(long j5, int i5) {
        return getStringArray(j5, i5, Native.getDefaultStringEncoding());
    }

    public void read(long j5, char[] cArr, int i5, int i6) {
        Native.read(this, this.peer, j5, cArr, i5, i6);
    }

    public void setString(long j5, String str, String str2) {
        byte[] bytes = Native.getBytes(str, str2);
        write(j5, bytes, 0, bytes.length);
        setByte(j5 + bytes.length, (byte) 0);
    }

    public void write(long j5, char[] cArr, int i5, int i6) {
        Native.write(this, this.peer, j5, cArr, i5, i6);
    }

    public String[] getStringArray(long j5, int i5, String str) {
        String string;
        String wideString;
        ArrayList arrayList = new ArrayList();
        if (i5 == -1) {
            int i6 = 0;
            while (true) {
                Pointer pointer = getPointer(i6 + j5);
                if (pointer == null) {
                    break;
                }
                if ("--WIDE-STRING--".equals(str)) {
                    string = pointer.getWideString(0L);
                } else {
                    string = pointer.getString(0L, str);
                }
                arrayList.add(string);
                i6 += Native.POINTER_SIZE;
            }
        } else {
            Pointer pointer2 = getPointer(0 + j5);
            int i7 = 0;
            int i8 = 0;
            while (true) {
                int i9 = i7 + 1;
                if (i7 >= i5) {
                    break;
                }
                if (pointer2 == null) {
                    wideString = null;
                } else {
                    wideString = "--WIDE-STRING--".equals(str) ? pointer2.getWideString(0L) : pointer2.getString(0L, str);
                }
                arrayList.add(wideString);
                if (i9 < i5) {
                    i8 += Native.POINTER_SIZE;
                    pointer2 = getPointer(i8 + j5);
                }
                i7 = i9;
            }
        }
        return (String[]) arrayList.toArray(new String[0]);
    }

    public void read(long j5, int[] iArr, int i5, int i6) {
        Native.read(this, this.peer, j5, iArr, i5, i6);
    }

    public void write(long j5, int[] iArr, int i5, int i6) {
        Native.write(this, this.peer, j5, iArr, i5, i6);
    }

    public void read(long j5, long[] jArr, int i5, int i6) {
        Native.read(this, this.peer, j5, jArr, i5, i6);
    }

    public void write(long j5, long[] jArr, int i5, int i6) {
        Native.write(this, this.peer, j5, jArr, i5, i6);
    }

    public void read(long j5, float[] fArr, int i5, int i6) {
        Native.read(this, this.peer, j5, fArr, i5, i6);
    }

    public void write(long j5, float[] fArr, int i5, int i6) {
        Native.write(this, this.peer, j5, fArr, i5, i6);
    }

    public Pointer[] getPointerArray(long j5, int i5) {
        Pointer[] pointerArr = new Pointer[i5];
        read(j5, pointerArr, 0, i5);
        return pointerArr;
    }

    public void read(long j5, double[] dArr, int i5, int i6) {
        Native.read(this, this.peer, j5, dArr, i5, i6);
    }

    public void write(long j5, double[] dArr, int i5, int i6) {
        Native.write(this, this.peer, j5, dArr, i5, i6);
    }

    public void read(long j5, Pointer[] pointerArr, int i5, int i6) {
        for (int i7 = 0; i7 < i6; i7++) {
            Pointer pointer = getPointer((Native.POINTER_SIZE * i7) + j5);
            int i8 = i7 + i5;
            Pointer pointer2 = pointerArr[i8];
            if (pointer2 == null || pointer == null || pointer.peer != pointer2.peer) {
                pointerArr[i8] = pointer;
            }
        }
    }

    public void write(long j5, Pointer[] pointerArr, int i5, int i6) {
        for (int i7 = 0; i7 < i6; i7++) {
            setPointer((Native.POINTER_SIZE * i7) + j5, pointerArr[i5 + i7]);
        }
    }
}
