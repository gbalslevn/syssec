package coil.request;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import kotlin.Metadata;
import kotlinx.coroutines.Job;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\bH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcoil/request/BaseRequestDelegate;", "Lcoil/request/RequestDelegate;", "lifecycle", "Landroidx/lifecycle/Lifecycle;", "job", "Lkotlinx/coroutines/Job;", "(Landroidx/lifecycle/Lifecycle;Lkotlinx/coroutines/Job;)V", "complete", BuildConfig.FLAVOR, "dispose", "onDestroy", "owner", "Landroidx/lifecycle/LifecycleOwner;", "start", "coil-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class BaseRequestDelegate implements RequestDelegate {
    private final Job job;
    private final Lifecycle lifecycle;

    public BaseRequestDelegate(Lifecycle lifecycle, Job job) {
        this.lifecycle = lifecycle;
        this.job = job;
    }

    @Override // coil.request.RequestDelegate
    public void complete() {
        this.lifecycle.removeObserver(this);
    }

    public void dispose() {
        Job.DefaultImpls.cancel$default(this.job, null, 1, null);
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public void onDestroy(LifecycleOwner owner) {
        dispose();
    }

    @Override // coil.request.RequestDelegate
    public void start() {
        this.lifecycle.addObserver(this);
    }
}
