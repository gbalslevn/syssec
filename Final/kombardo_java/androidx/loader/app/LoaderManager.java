package androidx.loader.app;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelStoreOwner;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* loaded from: classes.dex */
public abstract class LoaderManager {
    public static <T extends LifecycleOwner & ViewModelStoreOwner> LoaderManager getInstance(T t5) {
        return new LoaderManagerImpl(t5, t5.getViewModelStore());
    }

    @Deprecated
    public abstract void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    public abstract void markForRedelivery();
}
