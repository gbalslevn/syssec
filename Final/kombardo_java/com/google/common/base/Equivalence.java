package com.google.common.base;

import java.io.Serializable;

/* loaded from: classes.dex */
public abstract class Equivalence<T> {

    /* loaded from: classes.dex */
    static final class Equals extends Equivalence<Object> implements Serializable {
        static final Equals INSTANCE = new Equals();
        private static final long serialVersionUID = 1;

        Equals() {
        }

        private Object readResolve() {
            return INSTANCE;
        }

        @Override // com.google.common.base.Equivalence
        protected boolean doEquivalent(Object obj, Object obj2) {
            return obj.equals(obj2);
        }

        @Override // com.google.common.base.Equivalence
        protected int doHash(Object obj) {
            return obj.hashCode();
        }
    }

    /* loaded from: classes.dex */
    static final class Identity extends Equivalence<Object> implements Serializable {
        static final Identity INSTANCE = new Identity();
        private static final long serialVersionUID = 1;

        Identity() {
        }

        private Object readResolve() {
            return INSTANCE;
        }

        @Override // com.google.common.base.Equivalence
        protected boolean doEquivalent(Object obj, Object obj2) {
            return false;
        }

        @Override // com.google.common.base.Equivalence
        protected int doHash(Object obj) {
            return System.identityHashCode(obj);
        }
    }

    protected Equivalence() {
    }

    public static Equivalence<Object> equals() {
        return Equals.INSTANCE;
    }

    public static Equivalence<Object> identity() {
        return Identity.INSTANCE;
    }

    protected abstract boolean doEquivalent(T t5, T t6);

    protected abstract int doHash(T t5);

    public final boolean equivalent(T t5, T t6) {
        if (t5 == t6) {
            return true;
        }
        if (t5 == null || t6 == null) {
            return false;
        }
        return doEquivalent(t5, t6);
    }

    public final int hash(T t5) {
        if (t5 == null) {
            return 0;
        }
        return doHash(t5);
    }
}
