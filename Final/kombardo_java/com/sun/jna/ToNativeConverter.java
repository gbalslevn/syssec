package com.sun.jna;

/* loaded from: classes2.dex */
public interface ToNativeConverter {
    Class<?> nativeType();

    Object toNative(Object obj, ToNativeContext toNativeContext);
}
