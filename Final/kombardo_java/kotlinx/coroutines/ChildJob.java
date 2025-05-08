package kotlinx.coroutines;

import kotlin.Deprecated;
import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Deprecated
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H'¨\u0006\u0006"}, d2 = {"Lkotlinx/coroutines/ChildJob;", "Lkotlinx/coroutines/Job;", "parentCancelled", BuildConfig.FLAVOR, "parentJob", "Lkotlinx/coroutines/ParentJob;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public interface ChildJob extends Job {
    void parentCancelled(ParentJob parentJob);
}
