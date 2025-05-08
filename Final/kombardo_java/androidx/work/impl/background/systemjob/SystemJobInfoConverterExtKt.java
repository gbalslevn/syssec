package androidx.work.impl.background.systemjob;

import android.app.job.JobInfo;
import android.net.NetworkRequest;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¨\u0006\u0006"}, d2 = {"setRequiredNetworkRequest", BuildConfig.FLAVOR, "builder", "Landroid/app/job/JobInfo$Builder;", "networkRequest", "Landroid/net/NetworkRequest;", "work-runtime_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class SystemJobInfoConverterExtKt {
    public static final void setRequiredNetworkRequest(JobInfo.Builder builder, NetworkRequest networkRequest) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        builder.setRequiredNetwork(networkRequest);
    }
}
