package com.sun.jna;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class NativeString implements CharSequence, Comparable {
    static final String WIDE_STRING = "--WIDE-STRING--";
    private String encoding;
    private Pointer pointer;

    /* loaded from: classes2.dex */
    private class StringMemory extends Memory {
        public StringMemory(long j5) {
            super(j5);
        }

        @Override // com.sun.jna.Memory, com.sun.jna.Pointer
        public String toString() {
            return NativeString.this.toString();
        }
    }

    public NativeString(String str) {
        this(str, Native.getDefaultStringEncoding());
    }

    @Override // java.lang.CharSequence
    public char charAt(int i5) {
        return toString().charAt(i5);
    }

    @Override // java.lang.Comparable
    public int compareTo(Object obj) {
        if (obj == null) {
            return 1;
        }
        return toString().compareTo(obj.toString());
    }

    public boolean equals(Object obj) {
        return (obj instanceof CharSequence) && compareTo(obj) == 0;
    }

    public Pointer getPointer() {
        return this.pointer;
    }

    public int hashCode() {
        return toString().hashCode();
    }

    @Override // java.lang.CharSequence
    public int length() {
        return toString().length();
    }

    @Override // java.lang.CharSequence
    public CharSequence subSequence(int i5, int i6) {
        return toString().subSequence(i5, i6);
    }

    @Override // java.lang.CharSequence
    public String toString() {
        return WIDE_STRING.equals(this.encoding) ? this.pointer.getWideString(0L) : this.pointer.getString(0L, this.encoding);
    }

    public NativeString(String str, boolean z5) {
        this(str, z5 ? WIDE_STRING : Native.getDefaultStringEncoding());
    }

    public NativeString(WString wString) {
        this(wString.toString(), WIDE_STRING);
    }

    public NativeString(String str, String str2) {
        if (str != null) {
            this.encoding = str2;
            if (WIDE_STRING.equals(str2)) {
                StringMemory stringMemory = new StringMemory((str.length() + 1) * Native.WCHAR_SIZE);
                this.pointer = stringMemory;
                stringMemory.setWideString(0L, str);
                return;
            } else {
                byte[] bytes = Native.getBytes(str, str2);
                StringMemory stringMemory2 = new StringMemory(bytes.length + 1);
                this.pointer = stringMemory2;
                stringMemory2.write(0L, bytes, 0, bytes.length);
                this.pointer.setByte(bytes.length, (byte) 0);
                return;
            }
        }
        throw new NullPointerException("String must not be null");
    }
}
