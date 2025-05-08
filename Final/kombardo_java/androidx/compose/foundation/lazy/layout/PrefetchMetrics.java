package androidx.compose.foundation.lazy.layout;

import androidx.collection.MutableObjectLongMap;
import androidx.collection.ObjectLongMapKt;
import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001f\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bR\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00010\t8\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001d\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00010\t8\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000b\u001a\u0004\b\u000f\u0010\rR$\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00048\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R$\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00048\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u0015\u0010\u0012\u001a\u0004\b\u0016\u0010\u0014¨\u0006\u0017"}, d2 = {"Landroidx/compose/foundation/lazy/layout/PrefetchMetrics;", BuildConfig.FLAVOR, "<init>", "()V", BuildConfig.FLAVOR, "new", "current", "calculateAverageTime", "(JJ)J", "Landroidx/collection/MutableObjectLongMap;", "averageCompositionTimeNanosByContentType", "Landroidx/collection/MutableObjectLongMap;", "getAverageCompositionTimeNanosByContentType", "()Landroidx/collection/MutableObjectLongMap;", "averageMeasureTimeNanosByContentType", "getAverageMeasureTimeNanosByContentType", "<set-?>", "averageCompositionTimeNanos", "J", "getAverageCompositionTimeNanos", "()J", "averageMeasureTimeNanos", "getAverageMeasureTimeNanos", "foundation_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class PrefetchMetrics {
    private long averageCompositionTimeNanos;
    private long averageMeasureTimeNanos;
    private final MutableObjectLongMap<Object> averageCompositionTimeNanosByContentType = ObjectLongMapKt.mutableObjectLongMapOf();
    private final MutableObjectLongMap<Object> averageMeasureTimeNanosByContentType = ObjectLongMapKt.mutableObjectLongMapOf();

    public static final /* synthetic */ long access$calculateAverageTime(PrefetchMetrics prefetchMetrics, long j5, long j6) {
        return prefetchMetrics.calculateAverageTime(j5, j6);
    }

    public static final /* synthetic */ void access$setAverageCompositionTimeNanos$p(PrefetchMetrics prefetchMetrics, long j5) {
        prefetchMetrics.averageCompositionTimeNanos = j5;
    }

    public static final /* synthetic */ void access$setAverageMeasureTimeNanos$p(PrefetchMetrics prefetchMetrics, long j5) {
        prefetchMetrics.averageMeasureTimeNanos = j5;
    }

    public final long calculateAverageTime(long r5, long current) {
        if (current == 0) {
            return r5;
        }
        long j5 = 4;
        return (r5 / j5) + ((current / j5) * 3);
    }

    public final long getAverageCompositionTimeNanos() {
        return this.averageCompositionTimeNanos;
    }

    public final MutableObjectLongMap<Object> getAverageCompositionTimeNanosByContentType() {
        return this.averageCompositionTimeNanosByContentType;
    }

    public final long getAverageMeasureTimeNanos() {
        return this.averageMeasureTimeNanos;
    }

    public final MutableObjectLongMap<Object> getAverageMeasureTimeNanosByContentType() {
        return this.averageMeasureTimeNanosByContentType;
    }
}
