package com.sun.jna;

/* loaded from: classes2.dex */
public interface FromNativeConverter {
    Object fromNative(Object obj, FromNativeContext fromNativeContext);

    Class<?> nativeType();
}
