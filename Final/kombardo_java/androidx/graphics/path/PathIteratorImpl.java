package androidx.graphics.path;

import android.graphics.Path;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u0014\n\u0002\b\u0004\b \u0018\u0000 \u00142\u00020\u0001:\u0001\u0014R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\r\u001a\u00020\f8\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0012\u001a\u00020\u00118\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0015"}, d2 = {"Landroidx/graphics/path/PathIteratorImpl;", BuildConfig.FLAVOR, "Landroid/graphics/Path;", "path", "Landroid/graphics/Path;", "getPath", "()Landroid/graphics/Path;", "Landroidx/graphics/path/PathIterator$ConicEvaluation;", "conicEvaluation", "Landroidx/graphics/path/PathIterator$ConicEvaluation;", "getConicEvaluation", "()Landroidx/graphics/path/PathIterator$ConicEvaluation;", BuildConfig.FLAVOR, "tolerance", "F", "getTolerance", "()F", BuildConfig.FLAVOR, "pointsData", "[F", "Companion", "graphics-path_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class PathIteratorImpl {
    private static final Companion Companion = new Companion(null);
    private final PathIterator$ConicEvaluation conicEvaluation;
    private final Path path;
    private final float[] pointsData;
    private final float tolerance;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Landroidx/graphics/path/PathIteratorImpl$Companion;", BuildConfig.FLAVOR, "()V", "graphics-path_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    static {
        System.loadLibrary("androidx.graphics.path");
    }
}
