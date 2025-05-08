package androidx.work.impl.model;

import com.sdk.growthbook.utils.Constants;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH'J\u000e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u000bH'J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0003H'J\u0010\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u0007H'J\u0018\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH'ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0010À\u0006\u0003"}, d2 = {"Landroidx/work/impl/model/SystemIdInfoDao;", BuildConfig.FLAVOR, "getSystemIdInfo", "Landroidx/work/impl/model/SystemIdInfo;", Constants.ID_ATTRIBUTE_KEY, "Landroidx/work/impl/model/WorkGenerationalId;", "workSpecId", BuildConfig.FLAVOR, "generation", BuildConfig.FLAVOR, "getWorkSpecIds", BuildConfig.FLAVOR, "insertSystemIdInfo", BuildConfig.FLAVOR, "systemIdInfo", "removeSystemIdInfo", "work-runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public interface SystemIdInfoDao {
    default SystemIdInfo getSystemIdInfo(WorkGenerationalId id) {
        Intrinsics.checkNotNullParameter(id, "id");
        return getSystemIdInfo(id.getWorkSpecId(), id.getGeneration());
    }

    SystemIdInfo getSystemIdInfo(String workSpecId, int generation);

    List<String> getWorkSpecIds();

    void insertSystemIdInfo(SystemIdInfo systemIdInfo);

    default void removeSystemIdInfo(WorkGenerationalId id) {
        Intrinsics.checkNotNullParameter(id, "id");
        removeSystemIdInfo(id.getWorkSpecId(), id.getGeneration());
    }

    void removeSystemIdInfo(String workSpecId);

    void removeSystemIdInfo(String workSpecId, int generation);
}
