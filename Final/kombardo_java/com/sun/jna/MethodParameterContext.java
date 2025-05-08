package com.sun.jna;

import java.lang.reflect.Method;

/* loaded from: classes2.dex */
public class MethodParameterContext extends FunctionParameterContext {
    private Method method;

    /* JADX INFO: Access modifiers changed from: package-private */
    public MethodParameterContext(Function function, Object[] objArr, int i5, Method method) {
        super(function, objArr, i5);
        this.method = method;
    }

    public Method getMethod() {
        return this.method;
    }
}
