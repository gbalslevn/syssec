package androidx.lifecycle.viewmodel.internal;

import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;

@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u000f\u0010\u0001\u001a\u00020\u0000H\u0000¢\u0006\u0004\b\u0001\u0010\u0002¨\u0006\u0003"}, d2 = {"Landroidx/lifecycle/viewmodel/internal/CloseableCoroutineScope;", "createViewModelScope", "()Landroidx/lifecycle/viewmodel/internal/CloseableCoroutineScope;", "lifecycle-viewmodel_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class CloseableCoroutineScopeKt {
    public static final CloseableCoroutineScope createViewModelScope() {
        CoroutineContext coroutineContext;
        try {
            coroutineContext = Dispatchers.getMain().getImmediate();
        } catch (IllegalStateException unused) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        } catch (NotImplementedError unused2) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        return new CloseableCoroutineScope(coroutineContext.plus(SupervisorKt.SupervisorJob$default(null, 1, null)));
    }
}
