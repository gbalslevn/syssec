package dagger.hilt;

import dagger.hilt.internal.GeneratedComponent;
import dagger.hilt.internal.GeneratedComponentManager;

/* loaded from: classes2.dex */
public abstract class EntryPoints {
    private static final String EARLY_ENTRY_POINT = "dagger.hilt.android.EarlyEntryPoint";

    public static <T> T get(Object obj, Class<T> cls) {
        if (obj instanceof GeneratedComponent) {
            return cls.cast(obj);
        }
        if (obj instanceof GeneratedComponentManager) {
            return (T) get(((GeneratedComponentManager) obj).generatedComponent(), cls);
        }
        throw new IllegalStateException(String.format("Given component holder %s does not implement %s or %s", obj.getClass(), GeneratedComponent.class, GeneratedComponentManager.class));
    }
}
