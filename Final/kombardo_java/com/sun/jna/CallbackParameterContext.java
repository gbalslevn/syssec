package com.sun.jna;

import java.lang.reflect.Method;

/* loaded from: classes2.dex */
public class CallbackParameterContext extends FromNativeContext {
    private Object[] args;
    private int index;
    private Method method;

    /* JADX INFO: Access modifiers changed from: package-private */
    public CallbackParameterContext(Class<?> cls, Method method, Object[] objArr, int i5) {
        super(cls);
        this.method = method;
        this.args = objArr;
        this.index = i5;
    }

    public Object[] getArguments() {
        return this.args;
    }

    public int getIndex() {
        return this.index;
    }

    public Method getMethod() {
        return this.method;
    }
}
