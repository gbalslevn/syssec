package com.google.android.gms.measurement.internal;

import android.os.Bundle;

/* loaded from: classes.dex */
public abstract class zzjk {
    public static <T> T zza(Bundle bundle, String str, Class<T> cls, T t5) {
        T t6 = (T) bundle.get(str);
        if (t6 == null) {
            return t5;
        }
        if (cls.isAssignableFrom(t6.getClass())) {
            return t6;
        }
        throw new IllegalStateException(String.format("Invalid conditional user property field type. '%s' expected [%s] but was [%s]", str, cls.getCanonicalName(), t6.getClass().getCanonicalName()));
    }

    public static void zza(Bundle bundle, Object obj) {
        if (obj instanceof Double) {
            bundle.putDouble("value", ((Double) obj).doubleValue());
        } else if (obj instanceof Long) {
            bundle.putLong("value", ((Long) obj).longValue());
        } else {
            bundle.putString("value", obj.toString());
        }
    }
}
