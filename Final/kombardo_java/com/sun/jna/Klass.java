package com.sun.jna;

import java.lang.reflect.InvocationTargetException;

/* loaded from: classes2.dex */
abstract class Klass {
    private Klass() {
    }

    public static <T> T newInstance(Class<T> cls) {
        try {
            return cls.getDeclaredConstructor(null).newInstance(null);
        } catch (IllegalAccessException e5) {
            e = e5;
            throw new IllegalArgumentException("Can't create an instance of " + cls + ", requires a public no-arg constructor: " + e, e);
        } catch (IllegalArgumentException e6) {
            e = e6;
            throw new IllegalArgumentException("Can't create an instance of " + cls + ", requires a public no-arg constructor: " + e, e);
        } catch (InstantiationException e7) {
            e = e7;
            throw new IllegalArgumentException("Can't create an instance of " + cls + ", requires a public no-arg constructor: " + e, e);
        } catch (NoSuchMethodException e8) {
            e = e8;
            throw new IllegalArgumentException("Can't create an instance of " + cls + ", requires a public no-arg constructor: " + e, e);
        } catch (SecurityException e9) {
            e = e9;
            throw new IllegalArgumentException("Can't create an instance of " + cls + ", requires a public no-arg constructor: " + e, e);
        } catch (InvocationTargetException e10) {
            if (e10.getCause() instanceof RuntimeException) {
                throw ((RuntimeException) e10.getCause());
            }
            throw new IllegalArgumentException("Can't create an instance of " + cls + ", requires a public no-arg constructor: " + e10, e10);
        }
    }
}
