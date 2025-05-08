package com.sun.jna;

import java.lang.reflect.Method;

/* loaded from: classes2.dex */
abstract class VarArgsChecker {

    /* loaded from: classes2.dex */
    private static final class NoVarArgsChecker extends VarArgsChecker {
        private NoVarArgsChecker() {
            super();
        }

        @Override // com.sun.jna.VarArgsChecker
        int fixedArgs(Method method) {
            return 0;
        }

        @Override // com.sun.jna.VarArgsChecker
        boolean isVarArgs(Method method) {
            return false;
        }
    }

    /* loaded from: classes2.dex */
    private static final class RealVarArgsChecker extends VarArgsChecker {
        private RealVarArgsChecker() {
            super();
        }

        @Override // com.sun.jna.VarArgsChecker
        int fixedArgs(Method method) {
            if (method.isVarArgs()) {
                return method.getParameterTypes().length - 1;
            }
            return 0;
        }

        @Override // com.sun.jna.VarArgsChecker
        boolean isVarArgs(Method method) {
            return method.isVarArgs();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static VarArgsChecker create() {
        try {
            return Method.class.getMethod("isVarArgs", null) != null ? new RealVarArgsChecker() : new NoVarArgsChecker();
        } catch (NoSuchMethodException | SecurityException unused) {
            return new NoVarArgsChecker();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract int fixedArgs(Method method);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract boolean isVarArgs(Method method);

    private VarArgsChecker() {
    }
}
