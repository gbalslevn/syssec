package com.google.common.collect;

import java.io.ObjectOutputStream;
import java.lang.reflect.Field;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes2.dex */
abstract class Serialization {

    /* loaded from: classes2.dex */
    static final class FieldSetter<T> {
        private final Field field;

        /* JADX INFO: Access modifiers changed from: package-private */
        public void set(T t5, Object obj) {
            try {
                this.field.set(t5, obj);
            } catch (IllegalAccessException e5) {
                throw new AssertionError(e5);
            }
        }

        private FieldSetter(Field field) {
            this.field = field;
            field.setAccessible(true);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void set(T t5, int i5) {
            try {
                this.field.set(t5, Integer.valueOf(i5));
            } catch (IllegalAccessException e5) {
                throw new AssertionError(e5);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> FieldSetter<T> getFieldSetter(Class<T> cls, String str) {
        try {
            return new FieldSetter<>(cls.getDeclaredField(str));
        } catch (NoSuchFieldException e5) {
            throw new AssertionError(e5);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <K, V> void writeMultimap(Multimap<K, V> multimap, ObjectOutputStream objectOutputStream) {
        objectOutputStream.writeInt(multimap.asMap().size());
        for (Map.Entry<K, Collection<V>> entry : multimap.asMap().entrySet()) {
            objectOutputStream.writeObject(entry.getKey());
            objectOutputStream.writeInt(entry.getValue().size());
            Iterator<V> it = entry.getValue().iterator();
            while (it.hasNext()) {
                objectOutputStream.writeObject(it.next());
            }
        }
    }
}
