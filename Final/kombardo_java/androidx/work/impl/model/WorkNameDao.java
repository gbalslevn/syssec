package androidx.work.impl.model;

import java.util.List;
import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\t2\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\n\u0010\u000bø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\fÀ\u0006\u0001"}, d2 = {"Landroidx/work/impl/model/WorkNameDao;", BuildConfig.FLAVOR, "Landroidx/work/impl/model/WorkName;", "workName", BuildConfig.FLAVOR, "insert", "(Landroidx/work/impl/model/WorkName;)V", BuildConfig.FLAVOR, "workSpecId", BuildConfig.FLAVOR, "getNamesForWorkSpecId", "(Ljava/lang/String;)Ljava/util/List;", "work-runtime_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public interface WorkNameDao {
    List<String> getNamesForWorkSpecId(String workSpecId);

    void insert(WorkName workName);
}
