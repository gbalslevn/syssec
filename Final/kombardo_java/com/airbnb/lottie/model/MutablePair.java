package com.airbnb.lottie.model;

import androidx.core.util.Pair;

/* loaded from: classes.dex */
public class MutablePair<T> {
    T first;
    T second;

    private static boolean objectsEqual(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Pair)) {
            return false;
        }
        Pair pair = (Pair) obj;
        return objectsEqual(pair.f3649a, this.first) && objectsEqual(pair.f3650b, this.second);
    }

    public int hashCode() {
        T t5 = this.first;
        int hashCode = t5 == null ? 0 : t5.hashCode();
        T t6 = this.second;
        return hashCode ^ (t6 != null ? t6.hashCode() : 0);
    }

    public void set(T t5, T t6) {
        this.first = t5;
        this.second = t6;
    }

    public String toString() {
        return "Pair{" + this.first + " " + this.second + "}";
    }
}
