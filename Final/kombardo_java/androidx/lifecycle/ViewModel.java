package androidx.lifecycle;

import androidx.lifecycle.viewmodel.internal.ViewModelImpl;
import java.io.Closeable;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0014¢\u0006\u0004\b\u0005\u0010\u0003J\u000f\u0010\u0007\u001a\u00020\u0004H\u0001¢\u0006\u0004\b\u0006\u0010\u0003J\u001d\u0010\f\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u000eH\u0017¢\u0006\u0004\b\f\u0010\u000fJ!\u0010\u0011\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u0010*\u00020\n2\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Landroidx/lifecycle/ViewModel;", BuildConfig.FLAVOR, "<init>", "()V", BuildConfig.FLAVOR, "onCleared", "clear$lifecycle_viewmodel_release", "clear", BuildConfig.FLAVOR, "key", "Ljava/lang/AutoCloseable;", "closeable", "addCloseable", "(Ljava/lang/String;Ljava/lang/AutoCloseable;)V", "Ljava/io/Closeable;", "(Ljava/io/Closeable;)V", "T", "getCloseable", "(Ljava/lang/String;)Ljava/lang/AutoCloseable;", "Landroidx/lifecycle/viewmodel/internal/ViewModelImpl;", "impl", "Landroidx/lifecycle/viewmodel/internal/ViewModelImpl;", "lifecycle-viewmodel_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class ViewModel {
    private final ViewModelImpl impl = new ViewModelImpl();

    public final void addCloseable(String key, AutoCloseable closeable) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(closeable, "closeable");
        ViewModelImpl viewModelImpl = this.impl;
        if (viewModelImpl != null) {
            viewModelImpl.addCloseable(key, closeable);
        }
    }

    public final void clear$lifecycle_viewmodel_release() {
        ViewModelImpl viewModelImpl = this.impl;
        if (viewModelImpl != null) {
            viewModelImpl.clear();
        }
        onCleared();
    }

    public final <T extends AutoCloseable> T getCloseable(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        ViewModelImpl viewModelImpl = this.impl;
        if (viewModelImpl != null) {
            return (T) viewModelImpl.getCloseable(key);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onCleared() {
    }

    @Deprecated
    public /* synthetic */ void addCloseable(Closeable closeable) {
        Intrinsics.checkNotNullParameter(closeable, "closeable");
        ViewModelImpl viewModelImpl = this.impl;
        if (viewModelImpl != null) {
            viewModelImpl.addCloseable(closeable);
        }
    }
}
