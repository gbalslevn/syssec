package androidx.compose.material;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import org.conscrypt.BuildConfig;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0001\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u001a\u0010\t\u001a\u00020\n*\u00028\u00002\u0006\u0010\u000b\u001a\u00020\u0006H\u0086\u0004¢\u0006\u0002\u0010\fR \u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00060\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\r"}, d2 = {"Landroidx/compose/material/DraggableAnchorsConfig;", "T", BuildConfig.FLAVOR, "()V", "anchors", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "getAnchors$material_release", "()Ljava/util/Map;", "at", BuildConfig.FLAVOR, "position", "(Ljava/lang/Object;F)V", "material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class DraggableAnchorsConfig<T> {
    private final Map<T, Float> anchors = new LinkedHashMap();

    public final void at(T t5, float f5) {
        this.anchors.put(t5, Float.valueOf(f5));
    }

    public final Map<T, Float> getAnchors$material_release() {
        return this.anchors;
    }
}
