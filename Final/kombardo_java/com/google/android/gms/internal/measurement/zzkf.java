package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzjt;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.ServiceConfigurationError;
import java.util.ServiceLoader;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes.dex */
public abstract class zzkf<T extends zzjt> {
    private static String zza = "com.google.protobuf.BlazeGeneratedExtensionRegistryLiteLoader";

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T extends zzjt> T zza(Class<T> cls) {
        String str;
        ClassLoader classLoader = zzkf.class.getClassLoader();
        if (cls.equals(zzjt.class)) {
            str = zza;
        } else {
            if (!cls.getPackage().equals(zzkf.class.getPackage())) {
                throw new IllegalArgumentException(cls.getName());
            }
            str = String.format("%s.BlazeGenerated%sLoader", cls.getPackage().getName(), cls.getSimpleName());
        }
        try {
            try {
                try {
                    android.support.v4.media.session.a.a(Class.forName(str, true, classLoader).getConstructor(null).newInstance(null));
                    throw null;
                } catch (IllegalAccessException e5) {
                    throw new IllegalStateException(e5);
                } catch (InvocationTargetException e6) {
                    throw new IllegalStateException(e6);
                }
            } catch (InstantiationException e7) {
                throw new IllegalStateException(e7);
            } catch (NoSuchMethodException e8) {
                throw new IllegalStateException(e8);
            }
        } catch (ClassNotFoundException unused) {
            Iterator it = ServiceLoader.load(zzkf.class, classLoader).iterator();
            ArrayList arrayList = new ArrayList();
            while (it.hasNext()) {
                try {
                    android.support.v4.media.session.a.a(it.next());
                    throw null;
                } catch (ServiceConfigurationError e9) {
                    Logger.getLogger(zzjn.class.getName()).logp(Level.SEVERE, "com.google.protobuf.GeneratedExtensionRegistryLoader", "load", "Unable to load " + cls.getSimpleName(), (Throwable) e9);
                }
            }
            if (arrayList.size() == 1) {
                return (T) arrayList.get(0);
            }
            if (arrayList.size() == 0) {
                return null;
            }
            try {
                return (T) cls.getMethod("combine", Collection.class).invoke(null, arrayList);
            } catch (IllegalAccessException e10) {
                throw new IllegalStateException(e10);
            } catch (NoSuchMethodException e11) {
                throw new IllegalStateException(e11);
            } catch (InvocationTargetException e12) {
                throw new IllegalStateException(e12);
            }
        }
    }
}
