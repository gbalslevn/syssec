package androidx.work.impl;

import androidx.work.impl.model.WorkGenerationalId;
import com.sdk.growthbook.utils.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Landroidx/work/impl/StartStopToken;", BuildConfig.FLAVOR, Constants.ID_ATTRIBUTE_KEY, "Landroidx/work/impl/model/WorkGenerationalId;", "(Landroidx/work/impl/model/WorkGenerationalId;)V", "getId", "()Landroidx/work/impl/model/WorkGenerationalId;", "work-runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class StartStopToken {
    private final WorkGenerationalId id;

    public StartStopToken(WorkGenerationalId id) {
        Intrinsics.checkNotNullParameter(id, "id");
        this.id = id;
    }

    public final WorkGenerationalId getId() {
        return this.id;
    }
}
