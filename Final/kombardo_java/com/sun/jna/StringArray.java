package com.sun.jna;

import com.sun.jna.Function;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes2.dex */
public class StringArray extends Memory implements Function.PostCallRead {
    private String encoding;
    private List<NativeString> natives;
    private Object[] original;

    public StringArray(String[] strArr) {
        this(strArr, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v2, types: [com.sun.jna.WString] */
    @Override // com.sun.jna.Function.PostCallRead
    public void read() {
        String str;
        boolean z5 = this.original instanceof WString[];
        boolean equals = "--WIDE-STRING--".equals(this.encoding);
        for (int i5 = 0; i5 < this.original.length; i5++) {
            Pointer pointer = getPointer(Native.POINTER_SIZE * i5);
            if (pointer != null) {
                str = equals ? pointer.getWideString(0L) : pointer.getString(0L, this.encoding);
                if (z5) {
                    str = new WString(str);
                }
            } else {
                str = null;
            }
            this.original[i5] = str;
        }
    }

    @Override // com.sun.jna.Memory, com.sun.jna.Pointer
    public String toString() {
        return ("--WIDE-STRING--".equals(this.encoding) ? "const wchar_t*[]" : "const char*[]") + Arrays.asList(this.original);
    }

    public StringArray(String[] strArr, boolean z5) {
        this((Object[]) strArr, z5 ? "--WIDE-STRING--" : Native.getDefaultStringEncoding());
    }

    public StringArray(String[] strArr, String str) {
        this((Object[]) strArr, str);
    }

    public StringArray(WString[] wStringArr) {
        this(wStringArr, "--WIDE-STRING--");
    }

    private StringArray(Object[] objArr, String str) {
        super((objArr.length + 1) * Native.POINTER_SIZE);
        this.natives = new ArrayList();
        this.original = objArr;
        this.encoding = str;
        int i5 = 0;
        while (true) {
            Pointer pointer = null;
            if (i5 < objArr.length) {
                Object obj = objArr[i5];
                if (obj != null) {
                    NativeString nativeString = new NativeString(obj.toString(), str);
                    this.natives.add(nativeString);
                    pointer = nativeString.getPointer();
                }
                setPointer(Native.POINTER_SIZE * i5, pointer);
                i5++;
            } else {
                setPointer(Native.POINTER_SIZE * objArr.length, null);
                return;
            }
        }
    }
}
