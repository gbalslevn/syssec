package com.sun.jna;

import com.sun.jna.internal.Cleaner;
import java.io.Closeable;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes2.dex */
public class Memory extends Pointer implements Closeable {
    private static final Map<Long, Reference<Memory>> allocatedMemory = new ConcurrentHashMap();
    private static final WeakMemoryHolder buffers = new WeakMemoryHolder();
    private final Cleaner.Cleanable cleanable;
    protected long size;

    /* loaded from: classes2.dex */
    private static final class MemoryDisposer implements Runnable {
        private long peer;

        public MemoryDisposer(long j5) {
            this.peer = j5;
        }

        @Override // java.lang.Runnable
        public synchronized void run() {
            try {
                Memory.free(this.peer);
            } finally {
                Memory.allocatedMemory.remove(Long.valueOf(this.peer));
                this.peer = 0L;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class SharedMemory extends Memory {
        public SharedMemory(long j5, long j6) {
            this.size = j6;
            this.peer = Memory.this.peer + j5;
        }

        @Override // com.sun.jna.Memory
        protected void boundsCheck(long j5, long j6) {
            Memory memory = Memory.this;
            memory.boundsCheck((this.peer - memory.peer) + j5, j6);
        }

        @Override // com.sun.jna.Memory
        protected synchronized void dispose() {
            this.peer = 0L;
        }

        @Override // com.sun.jna.Memory, com.sun.jna.Pointer
        public String toString() {
            return super.toString() + " (shared from " + Memory.this.toString() + ")";
        }
    }

    public Memory(long j5) {
        this.size = j5;
        if (j5 > 0) {
            long malloc = malloc(j5);
            this.peer = malloc;
            if (malloc != 0) {
                allocatedMemory.put(Long.valueOf(malloc), new WeakReference(this));
                this.cleanable = Cleaner.getCleaner().register(this, new MemoryDisposer(this.peer));
                return;
            } else {
                throw new OutOfMemoryError("Cannot allocate " + j5 + " bytes");
            }
        }
        throw new IllegalArgumentException("Allocation size must be greater than zero");
    }

    public static void disposeAll() {
        Iterator it = new ArrayList(allocatedMemory.values()).iterator();
        while (it.hasNext()) {
            Memory memory = (Memory) ((Reference) it.next()).get();
            if (memory != null) {
                memory.close();
            }
        }
    }

    protected static void free(long j5) {
        if (j5 != 0) {
            Native.free(j5);
        }
    }

    protected static long malloc(long j5) {
        return Native.malloc(j5);
    }

    public static void purge() {
        buffers.clean();
    }

    private Pointer shareReferenceIfInBounds(Pointer pointer) {
        if (pointer == null) {
            return null;
        }
        long j5 = pointer.peer - this.peer;
        return (j5 < 0 || j5 >= this.size) ? pointer : share(j5);
    }

    public Memory align(int i5) {
        if (i5 <= 0) {
            throw new IllegalArgumentException("Byte boundary must be positive: " + i5);
        }
        for (int i6 = 0; i6 < 32; i6++) {
            if (i5 == (1 << i6)) {
                long j5 = i5;
                long j6 = ~(j5 - 1);
                long j7 = this.peer;
                if ((j7 & j6) == j7) {
                    return this;
                }
                long j8 = ((j5 + j7) - 1) & j6;
                long j9 = (this.size + j7) - j8;
                if (j9 > 0) {
                    return (Memory) share(j8 - j7, j9);
                }
                throw new IllegalArgumentException("Insufficient memory to align to the requested boundary");
            }
        }
        throw new IllegalArgumentException("Byte boundary must be a power of two");
    }

    protected void boundsCheck(long j5, long j6) {
        if (j5 < 0) {
            throw new IndexOutOfBoundsException("Invalid offset: " + j5);
        }
        long j7 = j5 + j6;
        if (j7 <= this.size) {
            return;
        }
        throw new IndexOutOfBoundsException("Bounds exceeds available space : size=" + this.size + ", offset=" + j7);
    }

    public void clear() {
        clear(this.size);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.peer = 0L;
        Cleaner.Cleanable cleanable = this.cleanable;
        if (cleanable != null) {
            cleanable.clean();
        }
    }

    @Deprecated
    protected void dispose() {
        close();
    }

    public String dump() {
        return dump(0L, (int) size());
    }

    @Override // com.sun.jna.Pointer
    public byte getByte(long j5) {
        boundsCheck(j5, 1L);
        return super.getByte(j5);
    }

    @Override // com.sun.jna.Pointer
    public ByteBuffer getByteBuffer(long j5, long j6) {
        boundsCheck(j5, j6);
        ByteBuffer byteBuffer = super.getByteBuffer(j5, j6);
        buffers.put(byteBuffer, this);
        return byteBuffer;
    }

    @Override // com.sun.jna.Pointer
    public char getChar(long j5) {
        boundsCheck(j5, Native.WCHAR_SIZE);
        return super.getChar(j5);
    }

    @Override // com.sun.jna.Pointer
    public double getDouble(long j5) {
        boundsCheck(j5, 8L);
        return super.getDouble(j5);
    }

    @Override // com.sun.jna.Pointer
    public float getFloat(long j5) {
        boundsCheck(j5, 4L);
        return super.getFloat(j5);
    }

    @Override // com.sun.jna.Pointer
    public int getInt(long j5) {
        boundsCheck(j5, 4L);
        return super.getInt(j5);
    }

    @Override // com.sun.jna.Pointer
    public long getLong(long j5) {
        boundsCheck(j5, 8L);
        return super.getLong(j5);
    }

    @Override // com.sun.jna.Pointer
    public Pointer getPointer(long j5) {
        boundsCheck(j5, Native.POINTER_SIZE);
        return shareReferenceIfInBounds(super.getPointer(j5));
    }

    @Override // com.sun.jna.Pointer
    public short getShort(long j5) {
        boundsCheck(j5, 2L);
        return super.getShort(j5);
    }

    @Override // com.sun.jna.Pointer
    public String getString(long j5, String str) {
        boundsCheck(j5, 0L);
        return super.getString(j5, str);
    }

    @Override // com.sun.jna.Pointer
    public String getWideString(long j5) {
        boundsCheck(j5, 0L);
        return super.getWideString(j5);
    }

    @Override // com.sun.jna.Pointer
    public void read(long j5, byte[] bArr, int i5, int i6) {
        boundsCheck(j5, i6);
        super.read(j5, bArr, i5, i6);
    }

    @Override // com.sun.jna.Pointer
    public void setByte(long j5, byte b5) {
        boundsCheck(j5, 1L);
        super.setByte(j5, b5);
    }

    @Override // com.sun.jna.Pointer
    public void setChar(long j5, char c5) {
        boundsCheck(j5, Native.WCHAR_SIZE);
        super.setChar(j5, c5);
    }

    @Override // com.sun.jna.Pointer
    public void setDouble(long j5, double d5) {
        boundsCheck(j5, 8L);
        super.setDouble(j5, d5);
    }

    @Override // com.sun.jna.Pointer
    public void setFloat(long j5, float f5) {
        boundsCheck(j5, 4L);
        super.setFloat(j5, f5);
    }

    @Override // com.sun.jna.Pointer
    public void setInt(long j5, int i5) {
        boundsCheck(j5, 4L);
        super.setInt(j5, i5);
    }

    @Override // com.sun.jna.Pointer
    public void setLong(long j5, long j6) {
        boundsCheck(j5, 8L);
        super.setLong(j5, j6);
    }

    @Override // com.sun.jna.Pointer
    public void setPointer(long j5, Pointer pointer) {
        boundsCheck(j5, Native.POINTER_SIZE);
        super.setPointer(j5, pointer);
    }

    @Override // com.sun.jna.Pointer
    public void setShort(long j5, short s5) {
        boundsCheck(j5, 2L);
        super.setShort(j5, s5);
    }

    @Override // com.sun.jna.Pointer
    public void setString(long j5, String str, String str2) {
        boundsCheck(j5, Native.getBytes(str, str2).length + 1);
        super.setString(j5, str, str2);
    }

    @Override // com.sun.jna.Pointer
    public void setWideString(long j5, String str) {
        boundsCheck(j5, (str.length() + 1) * Native.WCHAR_SIZE);
        super.setWideString(j5, str);
    }

    @Override // com.sun.jna.Pointer
    public Pointer share(long j5) {
        return share(j5, size() - j5);
    }

    public long size() {
        return this.size;
    }

    @Override // com.sun.jna.Pointer
    public String toString() {
        return "allocated@0x" + Long.toHexString(this.peer) + " (" + this.size + " bytes)";
    }

    public boolean valid() {
        return this.peer != 0;
    }

    @Override // com.sun.jna.Pointer
    public void write(long j5, byte[] bArr, int i5, int i6) {
        boundsCheck(j5, i6);
        super.write(j5, bArr, i5, i6);
    }

    @Override // com.sun.jna.Pointer
    public Pointer share(long j5, long j6) {
        boundsCheck(j5, j6);
        return new SharedMemory(j5, j6);
    }

    @Override // com.sun.jna.Pointer
    public void read(long j5, short[] sArr, int i5, int i6) {
        boundsCheck(j5, i6 * 2);
        super.read(j5, sArr, i5, i6);
    }

    @Override // com.sun.jna.Pointer
    public void write(long j5, short[] sArr, int i5, int i6) {
        boundsCheck(j5, i6 * 2);
        super.write(j5, sArr, i5, i6);
    }

    @Override // com.sun.jna.Pointer
    public void read(long j5, char[] cArr, int i5, int i6) {
        boundsCheck(j5, Native.WCHAR_SIZE * i6);
        super.read(j5, cArr, i5, i6);
    }

    @Override // com.sun.jna.Pointer
    public void write(long j5, char[] cArr, int i5, int i6) {
        boundsCheck(j5, Native.WCHAR_SIZE * i6);
        super.write(j5, cArr, i5, i6);
    }

    @Override // com.sun.jna.Pointer
    public void read(long j5, int[] iArr, int i5, int i6) {
        boundsCheck(j5, i6 * 4);
        super.read(j5, iArr, i5, i6);
    }

    @Override // com.sun.jna.Pointer
    public void write(long j5, int[] iArr, int i5, int i6) {
        boundsCheck(j5, i6 * 4);
        super.write(j5, iArr, i5, i6);
    }

    protected Memory() {
        this.cleanable = null;
    }

    @Override // com.sun.jna.Pointer
    public void read(long j5, long[] jArr, int i5, int i6) {
        boundsCheck(j5, i6 * 8);
        super.read(j5, jArr, i5, i6);
    }

    @Override // com.sun.jna.Pointer
    public void write(long j5, long[] jArr, int i5, int i6) {
        boundsCheck(j5, i6 * 8);
        super.write(j5, jArr, i5, i6);
    }

    @Override // com.sun.jna.Pointer
    public void read(long j5, float[] fArr, int i5, int i6) {
        boundsCheck(j5, i6 * 4);
        super.read(j5, fArr, i5, i6);
    }

    @Override // com.sun.jna.Pointer
    public void write(long j5, float[] fArr, int i5, int i6) {
        boundsCheck(j5, i6 * 4);
        super.write(j5, fArr, i5, i6);
    }

    @Override // com.sun.jna.Pointer
    public void read(long j5, double[] dArr, int i5, int i6) {
        boundsCheck(j5, i6 * 8);
        super.read(j5, dArr, i5, i6);
    }

    @Override // com.sun.jna.Pointer
    public void write(long j5, double[] dArr, int i5, int i6) {
        boundsCheck(j5, i6 * 8);
        super.write(j5, dArr, i5, i6);
    }

    @Override // com.sun.jna.Pointer
    public void read(long j5, Pointer[] pointerArr, int i5, int i6) {
        boundsCheck(j5, Native.POINTER_SIZE * i6);
        super.read(j5, pointerArr, i5, i6);
    }

    @Override // com.sun.jna.Pointer
    public void write(long j5, Pointer[] pointerArr, int i5, int i6) {
        boundsCheck(j5, Native.POINTER_SIZE * i6);
        super.write(j5, pointerArr, i5, i6);
    }
}
