package androidx.startup;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import androidx.tracing.Trace;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public final class AppInitializer {
    private static final String SECTION_NAME = "Startup";
    private static volatile AppInitializer sInstance;
    private static final Object sLock = new Object();
    final Context mContext;
    final Set<Class<? extends Initializer<?>>> mDiscovered = new HashSet();
    final Map<Class<?>, Object> mInitialized = new HashMap();

    AppInitializer(Context context) {
        this.mContext = context.getApplicationContext();
    }

    public static AppInitializer getInstance(Context context) {
        if (sInstance == null) {
            synchronized (sLock) {
                try {
                    if (sInstance == null) {
                        sInstance = new AppInitializer(context);
                    }
                } finally {
                }
            }
        }
        return sInstance;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void discoverAndInitialize() {
        try {
            try {
                Trace.beginSection(SECTION_NAME);
                discoverAndInitialize(this.mContext.getPackageManager().getProviderInfo(new ComponentName(this.mContext.getPackageName(), InitializationProvider.class.getName()), 128).metaData);
            } catch (PackageManager.NameNotFoundException e5) {
                throw new StartupException(e5);
            }
        } finally {
            Trace.endSection();
        }
    }

    <T> T doInitialize(Class<? extends Initializer<?>> cls) {
        T t5;
        synchronized (sLock) {
            try {
                t5 = (T) this.mInitialized.get(cls);
                if (t5 == null) {
                    t5 = (T) doInitialize(cls, new HashSet());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return t5;
    }

    public <T> T initializeComponent(Class<? extends Initializer<T>> cls) {
        return (T) doInitialize(cls);
    }

    public boolean isEagerlyInitialized(Class<? extends Initializer<?>> cls) {
        return this.mDiscovered.contains(cls);
    }

    private <T> T doInitialize(Class<? extends Initializer<?>> cls, Set<Class<?>> set) {
        T t5;
        if (Trace.isEnabled()) {
            try {
                Trace.beginSection(cls.getSimpleName());
            } catch (Throwable th) {
                Trace.endSection();
                throw th;
            }
        }
        if (!set.contains(cls)) {
            if (!this.mInitialized.containsKey(cls)) {
                set.add(cls);
                try {
                    Initializer<?> newInstance = cls.getDeclaredConstructor(null).newInstance(null);
                    List<Class<? extends Initializer<?>>> dependencies = newInstance.dependencies();
                    if (!dependencies.isEmpty()) {
                        for (Class<? extends Initializer<?>> cls2 : dependencies) {
                            if (!this.mInitialized.containsKey(cls2)) {
                                doInitialize(cls2, set);
                            }
                        }
                    }
                    t5 = (T) newInstance.create(this.mContext);
                    set.remove(cls);
                    this.mInitialized.put(cls, t5);
                } catch (Throwable th2) {
                    throw new StartupException(th2);
                }
            } else {
                t5 = (T) this.mInitialized.get(cls);
            }
            Trace.endSection();
            return t5;
        }
        throw new IllegalStateException(String.format("Cannot initialize %s. Cycle detected.", cls.getName()));
    }

    /* JADX WARN: Multi-variable type inference failed */
    void discoverAndInitialize(Bundle bundle) {
        String string = this.mContext.getString(R$string.androidx_startup);
        if (bundle != null) {
            try {
                HashSet hashSet = new HashSet();
                for (String str : bundle.keySet()) {
                    if (string.equals(bundle.getString(str, null))) {
                        Class<?> cls = Class.forName(str);
                        if (Initializer.class.isAssignableFrom(cls)) {
                            this.mDiscovered.add(cls);
                        }
                    }
                }
                Iterator<Class<? extends Initializer<?>>> it = this.mDiscovered.iterator();
                while (it.hasNext()) {
                    doInitialize(it.next(), hashSet);
                }
            } catch (ClassNotFoundException e5) {
                throw new StartupException(e5);
            }
        }
    }
}
